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
import com.tencent.mm.ah.k.b;
import com.tencent.mm.al.h.b;
import com.tencent.mm.av.o;
import com.tencent.mm.g.a.db;
import com.tencent.mm.g.a.db.a;
import com.tencent.mm.g.a.hv;
import com.tencent.mm.g.a.qs;
import com.tencent.mm.g.a.qs.a;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.g.c.y;
import com.tencent.mm.m.e;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.pluginsdk.ui.chat.l.a;
import com.tencent.mm.pluginsdk.ui.chat.l.b;
import com.tencent.mm.protocal.protobuf.dzk;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.bo;
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
import java.util.concurrent.Future;

public abstract class c
{
  private static boolean HZQ = false;
  private static long HZR = 0L;
  public boolean HJB;
  private c IhC;
  private a.f IhD;
  private d IhE;
  private boolean IhF = false;
  protected s.b IhG;
  protected s.d IhH;
  protected s.c IhI;
  protected s.p IhJ;
  protected s.h IhK;
  protected s.k IhL;
  protected s.e IhM;
  private Future IhN = null;
  private final long IhO = 120000L;
  private final long IhP = 10800000L;
  protected boolean opt;
  
  public static void A(ImageView paramImageView, String paramString)
  {
    if (bs.isNullOrNil(paramString))
    {
      paramImageView.setImageResource(2131231342);
      return;
    }
    com.tencent.mm.pluginsdk.ui.a.b.d(paramImageView, paramString);
  }
  
  private s.e a(com.tencent.mm.ui.chatting.d.a parama, final s.n paramn)
  {
    if (this.IhM == null) {
      this.IhM = new s.e(parama)
      {
        public final void a(View paramAnonymousView, com.tencent.mm.ui.chatting.d.a paramAnonymousa, bo paramAnonymousbo)
        {
          AppMethodBeat.i(36730);
          paramn.a(paramAnonymousa, paramAnonymousbo);
          AppMethodBeat.o(36730);
        }
      };
    }
    return this.IhM;
  }
  
  public static String a(bo parambo, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str1 = null;
    String str2 = null;
    if (parambo == null) {
      return str2;
    }
    if (parambo.field_isSend == 1) {
      return u.axw();
    }
    if (paramBoolean1) {
      str1 = bi.yl(parambo.field_content);
    }
    for (;;)
    {
      str2 = str1;
      if (!bs.isNullOrNil(str1)) {
        break;
      }
      return parambo.field_talker;
      if (paramBoolean2) {
        str1 = parambo.field_bizChatUserId;
      }
    }
  }
  
  public static void a(bo parambo, EmojiInfo paramEmojiInfo)
  {
    db localdb = new db();
    localdb.dcD.dcE = paramEmojiInfo;
    paramEmojiInfo = localdb.dcD.dcE;
    if (parambo != null) {}
    for (parambo = parambo.field_talker;; parambo = null)
    {
      paramEmojiInfo.talker = parambo;
      localdb.dcD.scene = 0;
      com.tencent.mm.sdk.b.a.GpY.l(localdb);
      return;
    }
  }
  
  protected static void a(com.tencent.mm.ui.chatting.d.a parama, View paramView, bo parambo, k.b paramb, String paramString, long paramLong)
  {
    if (!com.tencent.mm.pluginsdk.model.app.h.aGf(paramb.appId))
    {
      paramView.setTag(new l.b());
      return;
    }
    if (parama.foQ()) {}
    for (int i = 2;; i = 1)
    {
      l.a locala = new l.a();
      locala.appId = paramb.appId;
      locala.dsT = "message";
      locala.dtC = paramString;
      locala.dtD = d(parama, parambo);
      locala.DyM = paramb.type;
      locala.scene = i;
      locala.DyN = paramb.mediaTagName;
      locala.dpl = paramLong;
      locala.DyO = parama.getTalkerUserName();
      a(parama, paramView, locala);
      return;
    }
  }
  
  private static void a(com.tencent.mm.ui.chatting.d.a parama, View paramView, Object paramObject)
  {
    paramView.setTag(paramObject);
    paramView.setOnClickListener(((com.tencent.mm.ui.chatting.c.b.i)parama.bf(com.tencent.mm.ui.chatting.c.b.i.class)).fmd());
  }
  
  protected static void a(com.tencent.mm.ui.chatting.d.a parama, View paramView, String paramString)
  {
    if (!com.tencent.mm.pluginsdk.model.app.h.aGf(paramString))
    {
      paramView.setTag(new l.b());
      return;
    }
    l.b localb = new l.b();
    localb.appId = paramString;
    localb.dsT = "message";
    a(parama, paramView, localb);
  }
  
  private static void a(com.tencent.mm.ui.chatting.d.a parama, ImageView paramImageView, Bitmap paramBitmap)
  {
    paramBitmap = new BitmapDrawable(paramBitmap);
    int i = (int)parama.HZF.getMMResources().getDimension(2131165576);
    paramBitmap.setBounds(0, 0, i, i);
    paramImageView.setImageDrawable(paramBitmap);
  }
  
  protected static void a(com.tencent.mm.ui.chatting.d.a parama, ImageView paramImageView, String paramString)
  {
    if ((bs.lr("wx485a97c844086dc9", paramString)) && ((paramImageView instanceof WeImageView)))
    {
      paramImageView.setImageResource(2131690438);
      ((WeImageView)paramImageView).setIconColor(parama.HZF.getContext().getResources().getColor(2131099734));
      return;
    }
    if ((bs.lr("wxaf060266bfa9a35c", paramString)) && ((paramImageView instanceof WeImageView)))
    {
      paramImageView.setImageResource(2131690670);
      ((WeImageView)paramImageView).setIconColor(parama.HZF.getContext().getResources().getColor(2131099734));
      return;
    }
    if ((paramImageView instanceof WeImageView)) {
      ((WeImageView)paramImageView).setIconColor(parama.HZF.getContext().getResources().getColor(2131101053));
    }
    paramString = com.tencent.mm.pluginsdk.model.app.h.c(paramString, 2, com.tencent.mm.cc.a.getDensity(parama.HZF.getContext()));
    if ((paramString != null) && (!paramString.isRecycled()))
    {
      a(parama, paramImageView, paramString);
      return;
    }
    a(parama, paramImageView, BitmapFactory.decodeResource(parama.HZF.getMMResources(), 2131233479));
  }
  
  private static void a(com.tencent.mm.ui.chatting.d.a parama, TextView paramTextView, Bitmap paramBitmap)
  {
    paramBitmap = new BitmapDrawable(paramBitmap);
    int i = (int)parama.HZF.getMMResources().getDimension(2131165576);
    paramBitmap.setBounds(0, 0, i, i);
    paramTextView.setCompoundDrawables(paramBitmap, null, null, null);
  }
  
  protected static void a(com.tencent.mm.ui.chatting.d.a parama, TextView paramTextView, String paramString)
  {
    paramString = com.tencent.mm.pluginsdk.model.app.h.c(paramString, 2, com.tencent.mm.cc.a.getDensity(parama.HZF.getContext()));
    if ((paramString != null) && (!paramString.isRecycled()))
    {
      a(parama, paramTextView, paramString);
      return;
    }
    a(parama, paramTextView, BitmapFactory.decodeResource(parama.HZF.getMMResources(), 2131233479));
  }
  
  public static void a(com.tencent.mm.ui.chatting.d.a parama, k.b paramb, String paramString1, com.tencent.mm.pluginsdk.model.app.g paramg, long paramLong, int paramInt, String paramString2)
  {
    int j;
    int i;
    label53:
    label64:
    qs localqs;
    qs.a locala;
    if (parama.foQ())
    {
      j = 2;
      i = paramInt;
      if (paramInt == -1)
      {
        if (paramb.type != 7) {
          break label253;
        }
        if ((paramg == null) || (!com.tencent.mm.pluginsdk.model.app.q.t(parama.HZF.getContext(), paramg.field_packageName))) {
          break label246;
        }
        i = 0;
      }
      if (paramb.type != 2) {
        break label259;
      }
      i = 4;
      localqs = new qs();
      localqs.dtI.context = parama.HZF.getContext();
      localqs.dtI.scene = j;
      localqs.dtI.djj = paramb.appId;
      locala = localqs.dtI;
      if (paramg != null) {
        break label273;
      }
    }
    label259:
    label273:
    for (parama = null;; parama = paramg.field_packageName)
    {
      locala.packageName = parama;
      localqs.dtI.msgType = paramb.type;
      localqs.dtI.dng = paramString1;
      localqs.dtI.dtJ = i;
      localqs.dtI.mediaTagName = paramb.mediaTagName;
      localqs.dtI.dpl = paramLong;
      localqs.dtI.dtK = "";
      localqs.dtI.cYP = paramString2;
      parama = (com.tencent.mm.pluginsdk.ui.tools.c)paramb.ao(com.tencent.mm.pluginsdk.ui.tools.c.class);
      if (parama != null) {
        localqs.dtI.dtL = parama.dtL;
      }
      com.tencent.mm.sdk.b.a.GpY.l(localqs);
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
  
  private void a(a parama, com.tencent.mm.ui.chatting.d.a parama1, bo parambo)
  {
    if (this.IhF) {}
    do
    {
      return;
      this.IhF = true;
    } while (((parama1.HZF instanceof AppBrandServiceChattingUI.AppBrandServiceChattingFmUI)) || (w.wC(parama1.getTalkerUserName())));
    if ((parambo != null) && (!bs.isNullOrNil(parambo.eSj))) {
      this.IhG = new s.a(parama1);
    }
    for (;;)
    {
      parama.IhT.setOnClickListener(this.IhG);
      parama.IhT.setOnLongClickListener(this.IhH);
      return;
      this.IhG = new s.b(parama1);
      this.IhH = new s.d(parama1);
    }
  }
  
  protected static void a(a parama, CharSequence paramCharSequence)
  {
    if ((parama == null) || (parama.xpH == null)) {
      return;
    }
    if (paramCharSequence == null)
    {
      parama.xpH.setVisibility(8);
      return;
    }
    parama.xpH.setText(paramCharSequence);
    parama.xpH.setVisibility(0);
  }
  
  protected static void a(a parama, boolean paramBoolean)
  {
    c localc = parama.IhY;
    if (localc != null) {
      localc.a(parama, paramBoolean, false);
    }
    while (parama.vYf == null) {
      return;
    }
    if (paramBoolean)
    {
      parama.vYf.setVisibility(0);
      return;
    }
    parama.vYf.setVisibility(8);
  }
  
  protected static boolean a(com.tencent.mm.ui.chatting.c.b.i parami, long paramLong)
  {
    return (paramLong > 0L) && (parami.fmf() == paramLong);
  }
  
  protected static boolean a(com.tencent.mm.ui.chatting.d.a parama, com.tencent.mm.pluginsdk.model.app.g paramg)
  {
    com.tencent.mm.plugin.game.api.b localb = com.tencent.mm.plugin.game.api.b.a.cOr();
    if ((!com.tencent.mm.pluginsdk.model.app.h.a(parama.HZF.getContext(), paramg)) && (localb != null))
    {
      if (!bs.isNullOrNil(paramg.eqq))
      {
        boolean bool = r.bL(parama.HZF.getContext(), paramg.eqq);
        ac.i("MicroMsg.ChattingItem", "oversea game info and gpdownload url is not empty, jump to google play directy:[%s], jump result: [%b]", new Object[] { paramg.eqq, Boolean.valueOf(bool) });
        if (bool) {
          return true;
        }
      }
      if (parama.foQ()) {}
      for (int i = 2;; i = 1)
      {
        hv localhv = new hv();
        localhv.diT.actionCode = 2;
        localhv.diT.scene = i;
        localhv.diT.appId = paramg.field_appId;
        localhv.diT.context = parama.HZF.getContext();
        com.tencent.mm.sdk.b.a.GpY.l(localhv);
        parama.HZF.getContext();
        localb.af(paramg.field_appId, i, i);
        return true;
      }
    }
    return false;
  }
  
  protected static boolean aQE(String paramString)
  {
    return ((!w.wT(paramString)) && (!w.xj(paramString)) && (!w.wH(paramString)) && (!w.xs(paramString))) || (w.sQ(paramString));
  }
  
  private static int abM(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      ac.e("MicroMsg.ChattingItem", "getMsgStateResId: not found this state");
    case 1: 
    case 2: 
    case 3: 
    case 4: 
      return -1;
    }
    return 2131234176;
  }
  
  protected static void b(com.tencent.mm.ui.chatting.d.a parama, k.b paramb, bo parambo)
  {
    com.tencent.mm.plugin.game.api.b localb = com.tencent.mm.plugin.game.api.b.a.cOr();
    if (localb != null) {
      if (!parama.foQ()) {
        break label94;
      }
    }
    label94:
    for (int i = 2;; i = 1)
    {
      String str = d(parama, parambo);
      int j = 0;
      com.tencent.mm.pluginsdk.ui.tools.c localc = (com.tencent.mm.pluginsdk.ui.tools.c)paramb.ao(com.tencent.mm.pluginsdk.ui.tools.c.class);
      if (localc != null) {
        j = localc.dtL;
      }
      parama.HZF.getContext();
      localb.a(paramb.appId, str, paramb.type, i, paramb.mediaTagName, parambo.field_msgSvrId, parama.getTalkerUserName(), j);
      return;
    }
  }
  
  protected static boolean b(bo parambo, com.tencent.mm.ui.chatting.d.a parama)
  {
    long l1 = parambo.field_createTime;
    long l2 = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.qaz, 120000L);
    if (parambo.cKN())
    {
      k.b localb = k.b.vA(parambo.field_content);
      if ((localb != null) && (localb.type == 6))
      {
        ac.i("MicroMsg.ChattingItem", "File revoke time is ：%s", new Object[] { Long.valueOf(l2) });
        if (ce.azI() - l1 > l2) {
          i = 1;
        }
      }
    }
    while (i != 0)
    {
      ac.i("MicroMsg.ChattingItem", "isRevokeExpire, msg talker: %s, svr id: %s.", new Object[] { parambo.field_talker, Long.valueOf(parambo.field_msgSvrId) });
      return false;
      i = 0;
      continue;
      if (ce.azI() - l1 > 120000L) {
        i = 1;
      } else {
        i = 0;
      }
    }
    if ((parama != null) && (parama.getTalkerUserName().equals(parama.foM())) && (parambo.field_status == 2)) {
      return false;
    }
    int i = com.tencent.mm.m.g.ZY().getInt("ShowRevokeMsgEntry", 1);
    ac.i("MicroMsg.ChattingItem", "[oneliang][isRevokeMsgEnable] enable:%d", new Object[] { Integer.valueOf(i) });
    return 1 == i;
  }
  
  protected static String c(com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    parambo = parambo.field_talker;
    parama = (com.tencent.mm.ui.chatting.c.b.d)parama.bf(com.tencent.mm.ui.chatting.c.b.d.class);
    if ((parama.fmo()) && (parama.fmm() != null)) {
      return parama.fmm().field_bizChatServId;
    }
    return parambo;
  }
  
  protected static void c(com.tencent.mm.ui.chatting.d.a parama, View paramView, Object paramObject)
  {
    paramView.setTag(paramObject);
    paramView.setOnClickListener(((com.tencent.mm.ui.chatting.c.b.i)parama.bf(com.tencent.mm.ui.chatting.c.b.i.class)).fme());
  }
  
  public static String d(com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    String str = parama.getTalkerUserName();
    parama = str;
    if (w.sQ(str)) {
      parama = bi.yl(parambo.field_content);
    }
    return parama;
  }
  
  protected static boolean eC(String paramString)
  {
    return com.tencent.mm.pluginsdk.model.app.h.eC(paramString);
  }
  
  protected static boolean fqw()
  {
    String str = com.tencent.mm.m.g.ZY().getValue("ShowSendOK");
    if (bs.isNullOrNil(str)) {}
    for (int i = 0; 1 == i; i = bs.aLy(str)) {
      return true;
    }
    return false;
  }
  
  private s.c g(com.tencent.mm.ui.chatting.d.a parama)
  {
    if (this.IhI == null) {
      this.IhI = new s.c(parama);
    }
    return this.IhI;
  }
  
  protected static PackageInfo getPackageInfo(Context paramContext, String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      paramString = null;
    }
    while (paramString == null)
    {
      return null;
      paramString = com.tencent.mm.pluginsdk.model.app.h.k(paramString, true, false);
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
      ac.printErrStackTrace("MicroMsg.ChattingItem", paramContext, "", new Object[0]);
    }
    return null;
  }
  
  public static int ka(Context paramContext)
  {
    float f = com.tencent.mm.cc.a.eb(paramContext);
    if (f == com.tencent.mm.cc.a.hP(paramContext)) {
      return com.tencent.mm.cc.a.av(paramContext, 2131166039);
    }
    if (f == com.tencent.mm.cc.a.hR(paramContext)) {
      return com.tencent.mm.cc.a.av(paramContext, 2131166032);
    }
    if (f == com.tencent.mm.cc.a.hS(paramContext)) {
      return com.tencent.mm.cc.a.av(paramContext, 2131166040);
    }
    if (f == com.tencent.mm.cc.a.hT(paramContext)) {
      return com.tencent.mm.cc.a.av(paramContext, 2131166021);
    }
    if ((f == com.tencent.mm.cc.a.hU(paramContext)) || (f == com.tencent.mm.cc.a.hV(paramContext)) || (f == com.tencent.mm.cc.a.hW(paramContext))) {
      return com.tencent.mm.cc.a.av(paramContext, 2131166022);
    }
    return com.tencent.mm.cc.a.av(paramContext, 2131166038);
  }
  
  public static int kb(Context paramContext)
  {
    float f = com.tencent.mm.cc.a.eb(paramContext);
    if ((f != com.tencent.mm.cc.a.hP(paramContext)) && (f != com.tencent.mm.cc.a.hR(paramContext)))
    {
      if (f == com.tencent.mm.cc.a.hS(paramContext)) {
        return com.tencent.mm.cc.a.av(paramContext, 2131166020);
      }
      if (f == com.tencent.mm.cc.a.hT(paramContext)) {
        return com.tencent.mm.cc.a.av(paramContext, 2131166018);
      }
      if ((f == com.tencent.mm.cc.a.hU(paramContext)) || (f == com.tencent.mm.cc.a.hV(paramContext)) || (f == com.tencent.mm.cc.a.hW(paramContext))) {
        return com.tencent.mm.cc.a.av(paramContext, 2131166022);
      }
    }
    return com.tencent.mm.cc.a.av(paramContext, 2131166019);
  }
  
  public static void t(Intent paramIntent, String paramString)
  {
    if ((w.wA(paramString)) || (w.wB(paramString))) {
      paramIntent.putExtra(e.m.HhK, true);
    }
  }
  
  public static void z(ImageView paramImageView, String paramString)
  {
    if (bs.isNullOrNil(paramString))
    {
      paramImageView.setImageResource(2131231875);
      return;
    }
    com.tencent.mm.pluginsdk.ui.a.b.c(paramImageView, paramString);
  }
  
  public abstract View a(LayoutInflater paramLayoutInflater, View paramView);
  
  protected final a.f a(c paramc)
  {
    if (this.IhD == null) {
      this.IhD = new e(paramc);
    }
    return this.IhD;
  }
  
  protected final void a(int paramInt, a parama, bo parambo, String paramString, boolean paramBoolean, com.tencent.mm.ui.chatting.d.a parama1, s.n paramn)
  {
    a(paramInt, parama, parambo, paramString, true, paramBoolean, parama1, paramn);
  }
  
  protected final void a(int paramInt, a parama, bo parambo, String paramString, boolean paramBoolean1, boolean paramBoolean2, com.tencent.mm.ui.chatting.d.a parama1, s.n paramn)
  {
    if (parambo.field_isSend == 1)
    {
      parama.IhW.setTag(new bj(parambo, paramBoolean2, paramInt, paramString, '\000'));
      parama.IhW.setOnClickListener(a(parama1, paramn));
      paramInt = abM(parambo.field_status);
      if (paramInt != -1)
      {
        parama.IhW.setImageResource(paramInt);
        parama.IhW.setVisibility(0);
        parama.IhW.setContentDescription(com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131761358));
        a(parama, false, paramBoolean1);
      }
    }
    else
    {
      return;
    }
    parama.IhW.setVisibility(8);
  }
  
  protected final void a(com.tencent.mm.ui.chatting.d.a parama, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, boolean paramBoolean, long paramLong1, long paramLong2, bo parambo)
  {
    if (((paramString1 == null) || (paramString1.length() == 0)) && ((paramString2 == null) || (paramString2.length() == 0)))
    {
      ac.e("MicroMsg.ChattingItem", "url, lowUrl both are empty");
      return;
    }
    String str;
    if (ax.isMobile(parama.HZF.getContext()))
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
      paramString1.putExtra("pre_username", b(parama, parambo));
      paramString1.putExtra("prePublishId", "msg_" + Long.toString(paramLong2));
      if (parambo != null) {
        paramString1.putExtra("preUsername", b(parama, parambo));
      }
      paramString1.putExtra("preChatName", parama.getTalkerUserName());
      paramString1.putExtra("preChatTYPE", x.aE(b(parama, parambo), parama.getTalkerUserName()));
      paramString1.putExtra("preMsgIndex", 0);
      com.tencent.mm.br.d.b(parama.HZF.getContext(), "webview", ".ui.tools.WebViewUI", paramString1);
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
  
  public final void a(a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bo parambo)
  {
    long l1 = HZR;
    long l2 = System.currentTimeMillis();
    HZR = l2;
    if (l1 + 30000L < l2)
    {
      az.ayM();
      HZQ = com.tencent.mm.model.c.isSDCardAvailable();
    }
    this.opt = HZQ;
    String str;
    if (fqt())
    {
      str = b(parama1, parambo);
      a(parama, parama1, parambo, str);
      a(parama, parama1, str, parambo);
    }
    for (;;)
    {
      if (parama.vYf != null)
      {
        parama.vYf.setTag(2131307296, null);
        if (this.IhN != null) {
          this.IhN.cancel(true);
        }
        parama.vYf.setVisibility(8);
        parama.vYf.setTag(2131307295, Long.valueOf(parambo.field_createTime));
      }
      a(parama, paramInt, parama1, parambo, str);
      if ((parama1.AzG != null) && (parama1.AzG.fad()))
      {
        parama = ((com.tencent.mm.ui.chatting.c.b.d)parama1.bf(com.tencent.mm.ui.chatting.c.b.d.class)).fml();
        if ((parama != null) && (parama.IK()))
        {
          int i = ((com.tencent.mm.ui.chatting.c.b.i)parama1.bf(com.tencent.mm.ui.chatting.c.b.i.class)).getCount();
          l1 = ((com.tencent.mm.ui.chatting.c.b.d)parama1.bf(com.tencent.mm.ui.chatting.c.b.d.class)).Rw();
          com.tencent.mm.al.k.a(parama1.AzG, parambo, paramInt, i, l1);
        }
      }
      return;
      str = null;
    }
  }
  
  public abstract void a(a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bo parambo, String paramString);
  
  protected void a(a parama, com.tencent.mm.ui.chatting.d.a parama1, bo parambo, String paramString)
  {
    if ((paramString == null) || (parama.xpH == null) || (parambo == null)) {
      return;
    }
    String str;
    if ((parambo.field_isSend == 0) && (!bs.isNullOrNil(parambo.eSj)))
    {
      com.tencent.mm.al.g localg = com.tencent.mm.al.af.aCV().AX(parambo.eSj);
      int i = 1;
      if ((localg != null) && (!bs.isNullOrNil(localg.field_openId)) && (!bs.isNullOrNil(localg.field_nickname)))
      {
        str = localg.field_nickname;
        i = 0;
        if (i == 0)
        {
          paramString = str;
          if (!com.tencent.mm.al.i.a(localg)) {}
        }
        else
        {
          com.tencent.mm.al.af.aCX().a(new b(parama1, parambo.eSj));
          com.tencent.mm.al.af.aCX().l(parama1.getTalkerUserName(), parambo.eSj, parambo.eSp);
          paramString = str;
        }
      }
    }
    for (;;)
    {
      a(parama, paramString);
      return;
      ac.i("MicroMsg.ChattingItem", "fillingUsername:need getKfInfo");
      str = null;
      break;
      if ((b(parama1)) && (((com.tencent.mm.ui.chatting.c.b.f)parama1.bf(com.tencent.mm.ui.chatting.c.b.f.class)).fmG()))
      {
        if (((com.tencent.mm.ui.chatting.c.b.d)parama1.bf(com.tencent.mm.ui.chatting.c.b.d.class)).fmp())
        {
          parambo = ((com.tencent.mm.ui.chatting.c.b.f)parama1.bf(com.tencent.mm.ui.chatting.c.b.f.class)).aQj(parambo.field_bizChatUserId);
          paramString = com.tencent.mm.pluginsdk.ui.span.k.b(parama1.HZF.getContext(), parambo, parama.xpH.getTextSize());
        }
        else
        {
          parambo = ((com.tencent.mm.ui.chatting.c.b.f)parama1.bf(com.tencent.mm.ui.chatting.c.b.f.class)).aQj(paramString);
          paramString = com.tencent.mm.pluginsdk.ui.span.k.b(parama1.HZF.getContext(), parambo, parama.xpH.getTextSize());
        }
      }
      else {
        paramString = null;
      }
    }
  }
  
  protected final void a(a parama, com.tencent.mm.ui.chatting.d.a parama1, String paramString, bo parambo)
  {
    Object localObject1 = null;
    if (parama.IhT == null) {
      return;
    }
    if ((w.xr(paramString)) && (!paramString.equals(w.hmW[0])))
    {
      parama.IhT.setVisibility(8);
      return;
    }
    Object localObject2;
    if ((parambo != null) && (!bs.isNullOrNil(parambo.eSj)))
    {
      localObject2 = new com.tencent.mm.aj.b();
      ((com.tencent.mm.aj.b)localObject2).htG = false;
      ((com.tencent.mm.aj.b)localObject2).htH = com.tencent.mm.pluginsdk.ui.a.nxI;
      if (parama1.foQ()) {
        localObject1 = parama1.getTalkerUserName();
      }
    }
    for (;;)
    {
      localObject1 = new bj(paramString, (String)localObject1);
      ((bj)localObject1).IqU = parambo.eSj;
      ((bj)localObject1).hoz = parambo.eSp;
      com.tencent.mm.pluginsdk.ui.a.b.a(parama.IhT, parambo.eSj, 2131231203, (com.tencent.mm.aj.b)localObject2);
      if (com.tencent.mm.al.g.F(parambo)) {
        com.tencent.mm.al.af.aCX().aCH();
      }
      label155:
      parama.IhT.setVisibility(0);
      parama.IhT.setTag(localObject1);
      a(parama, parama1, parambo);
      if (!fqu()) {
        ((ae)parama1.bf(ae.class)).a(parama.IhT);
      }
      parama.IhT.setOnDoubleClickListener(g(parama1));
      com.tencent.mm.ui.chatting.q.dT(parama.IhT);
      parama.IhT.setContentDescription(v.wk(paramString) + parama1.HZF.getContext().getString(2131756087));
      parama.IhT.eM(paramString, 5);
      if (parama.IhU == null) {
        break;
      }
      if ((parambo != null) && (parambo.eul != null) && (parambo.eul.contains("watch_msg_source_type")))
      {
        parama1 = (String)bv.L(parambo.eul, "msgsource").get(".msgsource.watch_msg_source_type");
        try
        {
          i = Integer.valueOf(parama1).intValue();
          if ((i > 0) && (i <= 4))
          {
            parama.IhU.setVisibility(0);
            return;
            localObject1 = null;
            continue;
            if ((parambo != null) && (((com.tencent.mm.ui.chatting.c.b.d)parama1.bf(com.tencent.mm.ui.chatting.c.b.d.class)).fmo()))
            {
              localObject1 = new bj(parambo.field_bizChatUserId, null);
              localObject2 = (com.tencent.mm.ui.chatting.c.b.d)parama1.bf(com.tencent.mm.ui.chatting.c.b.d.class);
              o.aFB().a(((com.tencent.mm.ui.chatting.c.b.d)localObject2).Bt(parambo.field_bizChatUserId), parama.IhT, ((com.tencent.mm.ui.chatting.c.b.i)parama1.bf(com.tencent.mm.ui.chatting.c.b.i.class)).fmg());
              break label155;
            }
            if ((parambo != null) && (parambo.field_isSend == 0) && (parama1.bf(com.tencent.mm.ui.chatting.c.b.a.class) != null) && (!bs.isNullOrNil(((com.tencent.mm.ui.chatting.c.b.a)parama1.bf(com.tencent.mm.ui.chatting.c.b.a.class)).foL())))
            {
              localObject1 = new bj(paramString, null);
              o.aFB().a(((com.tencent.mm.ui.chatting.c.b.a)parama1.bf(com.tencent.mm.ui.chatting.c.b.a.class)).foL(), parama.IhT, ((com.tencent.mm.ui.chatting.c.b.i)parama1.bf(com.tencent.mm.ui.chatting.c.b.i.class)).fmg());
              break label155;
            }
            if (parama1.foQ()) {
              localObject1 = parama1.getTalkerUserName();
            }
            localObject1 = new bj(paramString, (String)localObject1);
            z(parama.IhT, paramString);
          }
        }
        catch (Exception parama1)
        {
          for (;;)
          {
            int i = 0;
          }
          parama.IhU.setVisibility(8);
          return;
        }
      }
    }
    parama.IhU.setVisibility(8);
  }
  
  protected final void a(final a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (parama.vYf == null) {
      return;
    }
    ac.d("MicroMsg.ChattingItem", "showUploadingPB %s %s %s", new Object[] { parama, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    if (paramBoolean1)
    {
      if (!paramBoolean2)
      {
        parama.vYf.setVisibility(0);
        parama.vYf.setTag(2131307296, Boolean.TRUE);
        return;
      }
      Object localObject = parama.vYf.getTag(2131307295);
      if ((localObject != null) && (((Long)localObject).longValue() < ce.azI() - 1000L))
      {
        parama.vYf.setVisibility(0);
        parama.vYf.setTag(2131307296, Boolean.TRUE);
        ac.d("MicroMsg.ChattingItem", "showUploadingPB not init %s", new Object[] { parama });
        return;
      }
      localObject = parama.vYf.getTag(2131307296);
      if ((localObject != null) && (((Boolean)localObject).booleanValue()))
      {
        parama.vYf.setVisibility(0);
        ac.d("MicroMsg.ChattingItem", "showUploadingPB had delay visible %s", new Object[] { parama });
        return;
      }
      this.IhN = com.tencent.e.h.JZN.p(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(196659);
          parama.vYf.setVisibility(0);
          parama.vYf.setTag(2131307296, Boolean.TRUE);
          ac.d("MicroMsg.ChattingItem", "showUploadingPB delay visible %s", new Object[] { parama });
          AppMethodBeat.o(196659);
        }
      }, 1000L);
      return;
    }
    parama.vYf.setTag(2131307296, Boolean.FALSE);
    if (this.IhN != null) {
      this.IhN.cancel(true);
    }
    parama.vYf.setVisibility(8);
  }
  
  public abstract boolean a(ContextMenu paramContextMenu, View paramView, bo parambo);
  
  public abstract boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bo parambo);
  
  protected boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bj parambj)
  {
    return false;
  }
  
  public final boolean a(com.tencent.mm.ui.chatting.d.a parama, k.b paramb, bo parambo)
  {
    if (bs.isNullOrNil(paramb.hjV)) {
      return false;
    }
    com.tencent.mm.ui.chatting.a.a(com.tencent.mm.ui.chatting.a.a.HIZ, parambo, paramb.hkc, paramb.hkb);
    String str = parambo.field_imgPath;
    Intent localIntent = new Intent();
    localIntent.putExtra("KFromTimeLine", false);
    localIntent.putExtra("KStremVideoUrl", paramb.hjV);
    localIntent.putExtra("KThumUrl", paramb.hka);
    localIntent.putExtra("KThumbPath", str);
    localIntent.putExtra("KSta_StremVideoAduxInfo", paramb.hkb);
    localIntent.putExtra("KSta_StremVideoPublishId", paramb.hkc);
    localIntent.putExtra("KSta_SourceType", 2);
    int i;
    if (parama.foQ())
    {
      i = com.tencent.mm.ui.chatting.a.b.HJi.value;
      localIntent.putExtra("KSta_Scene", i);
      localIntent.putExtra("KSta_FromUserName", b(parama, parambo));
      localIntent.putExtra("KSta_ChatName", parama.getTalkerUserName());
      localIntent.putExtra("KSta_MsgId", parambo.field_msgSvrId);
      localIntent.putExtra("KSta_SnsStatExtStr", paramb.dvs);
      if (parama.foQ()) {
        localIntent.putExtra("KSta_ChatroomMembercount", com.tencent.mm.model.q.wb(parama.getTalkerUserName()));
      }
      localIntent.putExtra("KMediaId", "fakeid_" + parambo.field_msgId);
      localIntent.putExtra("KMediaVideoTime", paramb.hjW);
      localIntent.putExtra("StremWebUrl", paramb.hjZ);
      localIntent.putExtra("StreamWording", paramb.hjY);
      localIntent.putExtra("KMediaTitle", paramb.title);
      if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pMG, 0) != 0) {
        break label370;
      }
      com.tencent.mm.br.d.b(parama.HZF.getContext(), "sns", ".ui.SnsAdStreamVideoPlayUI", localIntent);
      ac.i("MicroMsg.ChattingItem", "use new stream video play UI");
    }
    for (;;)
    {
      return true;
      i = com.tencent.mm.ui.chatting.a.b.HJh.value;
      break;
      label370:
      com.tencent.mm.br.d.b(parama.HZF.getContext(), "sns", ".ui.VideoAdPlayerUI", localIntent);
    }
  }
  
  public String b(com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    Object localObject;
    if (fqu()) {
      localObject = parama.foM();
    }
    String str;
    do
    {
      return localObject;
      str = parama.getTalkerUserName();
      localObject = str;
    } while (!b(parama));
    if (parama.foQ())
    {
      parama = bi.yl(parambo.field_content);
      if ((str == null) || (parama == null) || (parama.length() <= 0)) {
        break label76;
      }
    }
    for (;;)
    {
      return parama;
      if (parambo != null) {
        parama = parambo.field_bizChatUserId;
      } else {
        label76:
        parama = str;
      }
    }
  }
  
  protected final void b(com.tencent.mm.ui.chatting.d.a parama, View paramView, Object paramObject)
  {
    paramView.setTag(paramObject);
    if (this.IhK == null) {
      this.IhK = new s.h(parama);
    }
    paramView.setOnClickListener(this.IhK);
  }
  
  protected final void b(a parama, boolean paramBoolean)
  {
    a(parama, paramBoolean, true);
  }
  
  public abstract boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bo parambo);
  
  protected boolean b(com.tencent.mm.ui.chatting.d.a parama)
  {
    if (fqu()) {
      return false;
    }
    return (parama.foQ()) || (((com.tencent.mm.ui.chatting.c.b.d)parama.bf(com.tencent.mm.ui.chatting.c.b.d.class)).fmo());
  }
  
  public abstract boolean bb(int paramInt, boolean paramBoolean);
  
  protected final c c(com.tencent.mm.ui.chatting.d.a parama)
  {
    if (this.IhC == null) {
      this.IhC = new c(parama);
    }
    return this.IhC;
  }
  
  protected final d d(com.tencent.mm.ui.chatting.d.a parama)
  {
    if (this.IhE == null)
    {
      if (!(parama.HZF instanceof AppBrandServiceChattingUI.AppBrandServiceChattingFmUI)) {
        break label47;
      }
      parama = (AppBrandServiceChattingUI.AppBrandServiceChattingFmUI)parama.HZF;
    }
    label47:
    for (this.IhE = new AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.3(parama, parama.cLy, this);; this.IhE = new d(parama, this)) {
      return this.IhE;
    }
  }
  
  protected final s.b e(com.tencent.mm.ui.chatting.d.a parama)
  {
    if (this.IhG == null) {
      this.IhG = new s.b(parama);
    }
    return this.IhG;
  }
  
  protected final s.d f(com.tencent.mm.ui.chatting.d.a parama)
  {
    if (this.IhH == null) {
      this.IhH = new s.d(parama);
    }
    return this.IhH;
  }
  
  protected boolean fqt()
  {
    return true;
  }
  
  public abstract boolean fqu();
  
  boolean fqv()
  {
    return true;
  }
  
  protected boolean fqx()
  {
    return true;
  }
  
  protected final s.p h(com.tencent.mm.ui.chatting.d.a parama)
  {
    if (this.IhJ == null) {
      this.IhJ = new s.p(parama);
    }
    return this.IhJ;
  }
  
  protected final s.k i(com.tencent.mm.ui.chatting.d.a parama)
  {
    if (this.IhL == null) {
      this.IhL = new s.k(parama);
    }
    return this.IhL;
  }
  
  public static class a
  {
    public AvatarImageView IhT;
    public ViewStub IhU;
    public View IhV;
    public ImageView IhW;
    public String IhX;
    public c IhY;
    public TextView fAz;
    public View gGk;
    public CheckBox ijt;
    public View nDl;
    public View sSS;
    public ProgressBar vYf;
    public TextView xpH;
    
    public static void aG(View paramView, int paramInt)
    {
      AppMethodBeat.i(36734);
      if (paramView != null)
      {
        ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
        localLayoutParams.width = ((int)(paramInt / com.tencent.mm.cd.a.eSl()));
        paramView.setLayoutParams(localLayoutParams);
        paramView.requestLayout();
      }
      AppMethodBeat.o(36734);
    }
    
    public final void fX(View paramView)
    {
      AppMethodBeat.i(36732);
      this.sSS = paramView;
      this.fAz = ((TextView)paramView.findViewById(2131298178));
      this.IhT = ((AvatarImageView)paramView.findViewById(2131298056));
      this.IhV = paramView.findViewById(2131298104);
      this.ijt = ((CheckBox)paramView.findViewById(2131298068));
      this.nDl = paramView.findViewById(2131298069);
      this.IhW = ((ImageView)paramView.findViewById(2131298174));
      this.IhU = null;
      AppMethodBeat.o(36732);
    }
    
    public final void setChattingBG(boolean paramBoolean)
    {
      AppMethodBeat.i(36731);
      if (this.IhT != null) {
        this.IhT.setChattingBG(paramBoolean);
      }
      AppMethodBeat.o(36731);
    }
    
    public final void xu(boolean paramBoolean)
    {
      AppMethodBeat.i(36733);
      if (paramBoolean) {}
      for (int i = 0;; i = 8)
      {
        if ((this.ijt != null) && (this.ijt.getVisibility() != i)) {
          this.ijt.setVisibility(i);
        }
        if ((this.gGk != null) && (this.gGk.getVisibility() != i)) {
          this.gGk.setVisibility(i);
        }
        AppMethodBeat.o(36733);
        return;
      }
    }
  }
  
  static final class b
    implements h.b
  {
    private String Ckt;
    com.tencent.mm.ui.chatting.d.a cLy;
    
    protected b(com.tencent.mm.ui.chatting.d.a parama, String paramString)
    {
      this.Ckt = paramString;
      this.cLy = parama;
    }
    
    public final String aCI()
    {
      return this.Ckt;
    }
    
    public final void e(LinkedList<dzk> paramLinkedList)
    {
      int k = 0;
      AppMethodBeat.i(36736);
      com.tencent.mm.al.af.aCX().b(this);
      ac.d("MicroMsg.ChattingItem", "onKFSceneEnd.");
      int i;
      if ((paramLinkedList != null) && (paramLinkedList.size() > 0))
      {
        ac.i("MicroMsg.ChattingItem", "onKFSceneEnd, workers size : %d. callbackid=%s", new Object[] { Integer.valueOf(paramLinkedList.size()), this.Ckt });
        if (this.cLy != null)
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
            ap.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(36735);
                c.b.this.cLy.bJU();
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
        dzk localdzk = (dzk)paramLinkedList.get(j);
        if ((localdzk != null) && (!bs.isNullOrNil(localdzk.GfE)) && (localdzk.GfE.equals(this.Ckt)))
        {
          ac.i("MicroMsg.ChattingItem", "needCallback find match kfopenid");
          if (!bs.isNullOrNil(localdzk.Nickname))
          {
            ac.i("MicroMsg.ChattingItem", "needCallback: true");
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
    com.tencent.mm.ui.chatting.d.a HNS;
    com.tencent.mm.ui.widget.b.a HQL;
    a.f IhD;
    private View.OnCreateContextMenuListener Iia;
    private a Iib;
    private View Iic;
    Object Iid;
    private PopupWindow.OnDismissListener adF;
    private int nwY;
    private int nwZ;
    
    public c(com.tencent.mm.ui.chatting.d.a parama)
    {
      AppMethodBeat.i(36741);
      this.adF = new PopupWindow.OnDismissListener()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(36739);
          if (((c.c.this.Iid instanceof Boolean)) && (((Boolean)c.c.this.Iid).booleanValue()) && (com.tencent.mm.ui.a.a.a.fhP().fhO()) && (c.c.c(c.c.this) != null)) {
            c.c.c(c.c.this).dismiss();
          }
          c.c.b(c.c.this).setFocused(true);
          AppMethodBeat.o(36739);
        }
      };
      this.HNS = parama;
      this.Iia = new View.OnCreateContextMenuListener()
      {
        public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
        {
          AppMethodBeat.i(36737);
          paramAnonymousContextMenuInfo = (bj)paramAnonymousView.getTag();
          if (paramAnonymousContextMenuInfo == null)
          {
            AppMethodBeat.o(36737);
            return;
          }
          int i = paramAnonymousContextMenuInfo.position;
          paramAnonymousContextMenuInfo = paramAnonymousContextMenuInfo.dpq;
          if (paramAnonymousContextMenuInfo == null)
          {
            ac.e("MicroMsg.ChattingItem", "msg is null!");
            AppMethodBeat.o(36737);
            return;
          }
          boolean bool = c.this.a(paramAnonymousContextMenu, paramAnonymousView, paramAnonymousContextMenuInfo);
          if ((com.tencent.mm.storage.ai.aNb(c.c.b(c.c.this).getTalkerUserName())) || (com.tencent.mm.storage.ai.aMZ(c.c.b(c.c.this).getTalkerUserName())))
          {
            ac.i("MicroMsg.ChattingItem", "on create context menu, match qcontact or tcontact, remove favorite menu item");
            paramAnonymousContextMenu.removeItem(116);
          }
          if (bool)
          {
            if (c.c.b(c.c.this).foR()) {
              paramAnonymousContextMenu.add(i, 100, 0, paramAnonymousView.getContext().getString(2131757221));
            }
            if (((!bk.x(paramAnonymousContextMenuInfo)) && (!bk.y(paramAnonymousContextMenuInfo)) && (c.this.fqx()) && (c.c.b(c.c.this).foR())) || (c.c.b(c.c.this).AzG.fad())) {
              paramAnonymousContextMenu.add(i, 122, 0, c.c.b(c.c.this).HZF.getMMResources().getString(2131757225));
            }
            if (paramAnonymousContextMenu.findItem(123) != null) {
              paramAnonymousContextMenu.removeItem(100);
            }
            if ((!bk.x(paramAnonymousContextMenuInfo)) && (!bk.z(paramAnonymousContextMenuInfo)) && (c.this.fqv())) {
              c.c.a(c.c.this, paramAnonymousContextMenu, paramAnonymousContextMenuInfo, i);
            }
            if ((!bk.x(paramAnonymousContextMenuInfo)) && (!bk.z(paramAnonymousContextMenuInfo)) && (c.c.a(c.c.this, paramAnonymousContextMenuInfo))) {
              c.c.a(c.c.this, paramAnonymousContextMenu, i);
            }
            AppMethodBeat.o(36737);
            return;
          }
          if (paramAnonymousContextMenuInfo.eZm())
          {
            az.ayM();
            if (com.tencent.mm.model.c.isSDCardAvailable()) {
              ((com.tencent.mm.ui.chatting.c.b.af)c.c.b(c.c.this).bf(com.tencent.mm.ui.chatting.c.b.af.class)).a(paramAnonymousContextMenu, i, paramAnonymousContextMenuInfo);
            }
          }
          for (;;)
          {
            if (paramAnonymousContextMenuInfo.field_status == 5)
            {
              paramAnonymousContextMenu.add(i, 103, 0, c.c.b(c.c.this).HZF.getMMResources().getString(2131757232));
              com.tencent.mm.av.f.c(o.aFx().I(paramAnonymousContextMenuInfo));
            }
            if (paramAnonymousContextMenu.findItem(123) != null) {
              paramAnonymousContextMenu.removeItem(100);
            }
            if ((!bk.x(paramAnonymousContextMenuInfo)) && (!bk.z(paramAnonymousContextMenuInfo)) && (c.this.fqv())) {
              c.c.a(c.c.this, paramAnonymousContextMenu, paramAnonymousContextMenuInfo, i);
            }
            if ((!bk.x(paramAnonymousContextMenuInfo)) && (!bk.z(paramAnonymousContextMenuInfo)) && (c.c.a(c.c.this, paramAnonymousContextMenuInfo))) {
              c.c.a(c.c.this, paramAnonymousContextMenu, i);
            }
            AppMethodBeat.o(36737);
            return;
            if (paramAnonymousContextMenuInfo.fbx()) {
              paramAnonymousContextMenu.add(i, 100, 0, c.c.b(c.c.this).HZF.getMMResources().getString(2131757221));
            }
          }
        }
      };
      this.Iib = new a();
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
        if (((this.nwY == 0) && (this.nwZ == 0)) || (!this.Iic.equals(paramView))) {
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
          u(paramView, this.nwY, this.nwZ);
        }
      }
    }
    
    final void u(View paramView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(36743);
      bj localbj = (bj)paramView.getTag();
      if (localbj == null)
      {
        ac.w("MicroMsg.ChattingItem", "open menu but tag is null");
        AppMethodBeat.o(36743);
        return;
      }
      this.Iib.Iig = localbj;
      if (this.HQL != null)
      {
        this.HQL.fkR();
        this.HQL = null;
      }
      this.HQL = new com.tencent.mm.ui.widget.b.a(this.HNS.HZF.getContext());
      this.Iid = paramView.getTag(2131305626);
      if (((this.Iid instanceof Boolean)) && (((Boolean)this.Iid).booleanValue())) {
        if (!com.tencent.mm.ui.a.a.a.fhP().fhO()) {
          break label246;
        }
      }
      label246:
      for (this.HQL.JiV = true;; this.HQL.JiV = false)
      {
        this.HQL.JiW = true;
        this.HQL.IUx = this.adF;
        if (((localbj instanceof ChattingItemTranslate.a)) && (2 == ((ChattingItemTranslate.a)localbj).oeH) && (this.IhD != null)) {
          this.IhD.dismiss();
        }
        this.HQL.a(paramView, this.Iia, this.Iib, paramInt1, paramInt2);
        if (this.HNS != null)
        {
          this.HNS.setFocused(false);
          this.HNS.xp(false);
          this.HNS.HZK = false;
        }
        AppMethodBeat.o(36743);
        return;
      }
    }
    
    final class a
      implements n.d
    {
      public bj Iig;
      
      a() {}
      
      public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
      {
        AppMethodBeat.i(36740);
        if (this.Iig == null)
        {
          ac.e("MicroMsg.ChattingItem", "context item select failed, null dataTag");
          AppMethodBeat.o(36740);
          return;
        }
        if (((c.this instanceof aw.a)) || ((c.this instanceof aw.b))) {
          c.this.a(paramMenuItem, c.c.b(c.c.this), this.Iig);
        }
        for (;;)
        {
          ((aa)c.c.b(c.c.this).bf(aa.class)).a(paramMenuItem, c.this);
          if (c.c.c(c.c.this) != null) {
            c.c.c(c.c.this).dismiss();
          }
          AppMethodBeat.o(36740);
          return;
          c.this.a(paramMenuItem, c.c.b(c.c.this), this.Iig.dpq);
        }
      }
    }
  }
  
  public static class d
    extends s.e
  {
    private c IhY;
    
    public d(com.tencent.mm.ui.chatting.d.a parama, c paramc)
    {
      super();
      this.IhY = paramc;
    }
    
    public void a(View paramView, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
    {
      AppMethodBeat.i(36747);
      paramView.getTag();
      this.IhY.b(paramView, parama, parambo);
      AppMethodBeat.o(36747);
    }
  }
  
  static final class e
    extends a.f
  {
    c.c IhC;
    
    e(c.c paramc)
    {
      this.IhC = paramc;
    }
    
    public final void dismiss()
    {
      AppMethodBeat.i(36749);
      c.c localc = this.IhC;
      if ((localc.HQL != null) && (localc.HQL.fkR())) {
        localc.HQL = null;
      }
      AppMethodBeat.o(36749);
    }
    
    public final void fY(View paramView)
    {
      AppMethodBeat.i(36748);
      this.IhC.u(paramView, 0, 0);
      AppMethodBeat.o(36748);
    }
    
    public final void fZ(View paramView)
    {
      AppMethodBeat.i(36750);
      this.IhC.onLongClick(paramView);
      AppMethodBeat.o(36750);
    }
    
    public final void fqA()
    {
      AppMethodBeat.i(179942);
      c.c localc = this.IhC;
      if (localc.HNS != null) {
        localc.HNS.setFocused(false);
      }
      AppMethodBeat.o(179942);
    }
    
    public final void fqy()
    {
      AppMethodBeat.i(179940);
      c.c localc = this.IhC;
      if (localc.HNS != null) {
        localc.HNS.xp(true);
      }
      AppMethodBeat.o(179940);
    }
    
    public final void fqz()
    {
      AppMethodBeat.i(179941);
      c.c localc = this.IhC;
      if (localc.HNS != null) {
        localc.HNS.xp(false);
      }
      AppMethodBeat.o(179941);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.c
 * JD-Core Version:    0.7.0.1
 */