package com.tencent.mm.plugin.mv.ui.uic;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.util.Pair;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.ay;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.music.model.m;
import com.tencent.mm.plugin.mv.b.b;
import com.tencent.mm.plugin.mv.b.c;
import com.tencent.mm.plugin.mv.b.d;
import com.tencent.mm.plugin.mv.b.g;
import com.tencent.mm.plugin.mv.b.h;
import com.tencent.mm.plugin.mv.model.f;
import com.tencent.mm.plugin.secdata.ui.a.a;
import com.tencent.mm.plugin.textstatus.a.q.a;
import com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bdp;
import com.tencent.mm.protocal.protobuf.bdr;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.protocal.protobuf.dbo;
import com.tencent.mm.protocal.protobuf.dbq;
import com.tencent.mm.protocal.protobuf.dbs;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.view.recyclerview.i;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.aa.a;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.n.n;
import org.json.JSONArray;
import org.json.JSONObject;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvShareUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "currentShareMv", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "fullScreenAnimate", "Lcom/tencent/mm/plugin/mv/ui/uic/VisibleRecord;", "clickOptionsMenu", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "musicMv", "doFav", "doShareMvToTimeLine", "musicWrapper", "Lcom/tencent/mm/modelmusic/MusicWrapper;", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "Landroid/app/Activity;", "coverBm", "Landroid/graphics/Bitmap;", "CoverLocalPath", "", "shareObject", "Lcom/tencent/mm/protocal/protobuf/MusicShareObject;", "doShareToChat", "doShareToSns", "getMvCoverLocalPath", "mv", "getTextStatusTips", "Landroid/text/SpannableString;", "context", "Landroid/content/Context;", "initLocalPostStats", "onCreateMVBtnClicked", "setTextStatus", "isFromBubble", "", "updateFullScreen", "Companion", "plugin-mv_release"})
public final class u
  extends UIComponent
{
  public static final u.a GmE;
  private final z GfJ;
  private f GmD;
  
  static
  {
    AppMethodBeat.i(230974);
    GmE = new u.a((byte)0);
    AppMethodBeat.o(230974);
  }
  
  public u(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(230973);
    this.GfJ = new z();
    AppMethodBeat.o(230973);
  }
  
  @SuppressLint({"ResourceType"})
  public static SpannableString hH(Context paramContext)
  {
    AppMethodBeat.i(230965);
    p.k(paramContext, "context");
    SpannableString localSpannableString = new SpannableString((CharSequence)paramContext.getString(b.h.menu_set_status));
    int i = n.a((CharSequence)localSpannableString, "{music}", 0, false, 6);
    Object localObject = paramContext.getResources().getDrawable(b.g.icons_music_staus_share);
    p.j(localObject, "drawable");
    int j = ((Drawable)localObject).getIntrinsicWidth();
    int k = com.tencent.mm.ci.a.aY(paramContext, b.c.Edge_2_5_A);
    float f = 1.0F * k / j;
    paramContext = com.tencent.mm.svg.a.a.a(paramContext.getResources(), b.g.icons_music_staus_share, f);
    localObject = new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
    p.j(paramContext, "scaleDrawable");
    paramContext.setColorFilter((ColorFilter)localObject);
    paramContext.setBounds(0, 0, k, k);
    localSpannableString.setSpan(new com.tencent.mm.plugin.mv.ui.view.a(paramContext), i, "{music}".length() + i, 17);
    AppMethodBeat.o(230965);
    return localSpannableString;
  }
  
  private final String l(f paramf)
  {
    AppMethodBeat.i(230964);
    Object localObject = paramf.Gbk;
    int i;
    if (localObject != null)
    {
      if (((CharSequence)localObject).length() > 0)
      {
        i = 1;
        if (i == 0) {
          break label57;
        }
      }
      for (;;)
      {
        if ((localObject == null) || (!com.tencent.mm.vfs.u.agG((String)localObject))) {
          break label62;
        }
        AppMethodBeat.o(230964);
        return localObject;
        i = 0;
        break;
        label57:
        localObject = null;
      }
    }
    label62:
    paramf = paramf.coverUrl;
    if (paramf != null)
    {
      if (((CharSequence)paramf).length() > 0)
      {
        i = 1;
        if (i == 0) {
          break label122;
        }
      }
      for (;;)
      {
        if (paramf == null) {
          break label127;
        }
        localObject = com.tencent.mm.plugin.mv.ui.a.Gfi;
        paramf = com.tencent.mm.plugin.mv.ui.a.aSH(paramf);
        if (!com.tencent.mm.vfs.u.agG(paramf)) {
          break label127;
        }
        AppMethodBeat.o(230964);
        return paramf;
        i = 0;
        break;
        label122:
        paramf = null;
      }
    }
    label127:
    paramf = com.tencent.mm.ui.component.g.Xox;
    paramf = com.tencent.mm.ui.component.g.b(getActivity()).i(g.class);
    p.j(paramf, "UICProvider.of(activity)…sicMvDataUIC::class.java)");
    localObject = (g)paramf;
    paramf = ((g)localObject).GiX.thumbPath;
    if (paramf != null)
    {
      p.j(paramf, "it");
      if (((CharSequence)paramf).length() > 0)
      {
        i = 1;
        if (i == 0) {
          break label216;
        }
      }
      for (;;)
      {
        if ((paramf == null) || (!com.tencent.mm.vfs.u.agG(paramf))) {
          break label221;
        }
        AppMethodBeat.o(230964);
        return paramf;
        i = 0;
        break;
        label216:
        paramf = null;
      }
    }
    label221:
    paramf = ((g)localObject).GaB.SOM;
    if (paramf != null)
    {
      p.j(paramf, "it");
      if (((CharSequence)paramf).length() > 0)
      {
        i = 1;
        if (i == 0) {
          break label298;
        }
      }
      for (;;)
      {
        if (paramf == null) {
          break label303;
        }
        localObject = com.tencent.mm.plugin.mv.ui.a.Gfi;
        p.j(paramf, "url");
        paramf = com.tencent.mm.plugin.mv.ui.a.aSH(paramf);
        if (!com.tencent.mm.vfs.u.agG(paramf)) {
          break label303;
        }
        AppMethodBeat.o(230964);
        return paramf;
        i = 0;
        break;
        label298:
        paramf = null;
      }
    }
    label303:
    AppMethodBeat.o(230964);
    return null;
  }
  
  public final void a(f paramf, boolean paramBoolean)
  {
    AppMethodBeat.i(230970);
    Object localObject1 = com.tencent.mm.ui.component.g.Xox;
    localObject1 = com.tencent.mm.ui.component.g.lm((Context)getContext()).i(g.class);
    p.j(localObject1, "UICProvider.of(context).…sicMvDataUIC::class.java)");
    localObject1 = (g)localObject1;
    bds localbds = ((g)localObject1).GaB;
    Object localObject5 = ((g)localObject1).verifyInfo;
    Object localObject3;
    if ((localbds != null) && (paramf != null) && (localObject5 != null))
    {
      localObject3 = localbds.SOM;
      localObject1 = (CharSequence)localObject3;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (i = 1;; i = 0)
      {
        localObject1 = localObject3;
        if (i != 0) {}
        try
        {
          localObject1 = com.tencent.mm.plugin.mv.ui.a.Gfi;
          localObject4 = com.tencent.mm.plugin.mv.ui.a.aSH("DEFAULT_TEXT_STATUS_MUSIC_THUMB_PATH");
          localObject1 = localObject3;
          if (!com.tencent.mm.vfs.u.agG((String)localObject4))
          {
            BitmapUtil.saveBitmapToImage(BitmapFactory.decodeResource(getContext().getResources(), b.d.FWy), 100, Bitmap.CompressFormat.PNG, (String)localObject4, true);
            localObject1 = localObject4;
          }
        }
        catch (Exception localException)
        {
          Object localObject4;
          for (;;)
          {
            Log.e("MicroMsg.Mv.MusicMvShareUIC", "save default text status thumb fail! " + localException.getLocalizedMessage());
            localObject2 = localObject3;
          }
          localObject2 = new q.a().bec("1016").bee((String)localObject2).bef("music_player@inner").bei(localbds.HLH).bej("http://wxapp.tc.qq.com/258/20304/stodownload?m=2009416463c227ad5a09b4fcf23bf985&filekey=30340201010420301e020201020402534804102009416463c227ad5a09b4fcf23bf9850202042e040d00000004627466730000000131&hy=SH&storeid=32303231303331383139353931363030306366646534303030303030303037636638353130393030303030313032&bizid=1023").beg(localbds.kkU).beh((String)localObject5);
          localObject5 = new TextStatusJumpInfo();
          ((TextStatusJumpInfo)localObject5).jumpType = "1";
          ((TextStatusJumpInfo)localObject5).busiBuf = com.tencent.mm.plugin.mv.ui.a.d.a(localbds, paramf);
          ((com.tencent.mm.plugin.textstatus.a.l)localObject3).a((Activity)localObject4, 1, ((q.a)localObject2).im(j.listOf(localObject5)).gkM().gkO());
          localObject2 = com.tencent.mm.plugin.mv.model.o.GcB;
          localObject2 = (Context)getContext();
          if (!paramBoolean) {
            break label392;
          }
        }
        localObject3 = (com.tencent.mm.plugin.textstatus.a.l)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.textstatus.a.l.class);
        localObject4 = getContext();
        if (localObject4 != null) {
          break;
        }
        paramf = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(230970);
        throw paramf;
      }
    }
    Object localObject2;
    label392:
    for (int i = 4;; i = 3)
    {
      com.tencent.mm.plugin.mv.model.o.a((Context)localObject2, localbds, paramf, 3, 0, i);
      AppMethodBeat.o(230970);
      return;
    }
  }
  
  public final void a(final i parami, final f paramf)
  {
    AppMethodBeat.i(230961);
    p.k(parami, "holder");
    p.k(paramf, "musicMv");
    Object localObject1 = com.tencent.mm.ui.component.g.Xox;
    localObject1 = com.tencent.mm.ui.component.g.lm((Context)getContext()).i(g.class);
    p.j(localObject1, "UICProvider.of(context).…sicMvDataUIC::class.java)");
    final g localg = (g)localObject1;
    localObject1 = paramf.Gbr;
    boolean bool2;
    final boolean bool3;
    final boolean bool4;
    label127:
    Object localObject3;
    Object localObject2;
    label155:
    final aa.a locala;
    int i;
    label193:
    boolean bool1;
    label201:
    label228:
    label254:
    Object localObject4;
    if (localObject1 != null)
    {
      localObject1 = ((FinderContact)localObject1).username;
      bool2 = p.h(localObject1, com.tencent.mm.model.z.bdh());
      localObject1 = com.tencent.mm.plugin.mv.ui.a.Gfi;
      bool3 = com.tencent.mm.plugin.mv.ui.a.e(paramf);
      bool4 = localg.f(paramf);
      if (!bool3) {
        break label556;
      }
      localObject1 = new e((Context)getActivity(), 0, false);
      localObject3 = (Context)getContext();
      localObject2 = localg.GaB;
      if (localObject2 == null) {
        break label612;
      }
      localObject2 = ((bds)localObject2).SOJ;
      localObject2 = com.tencent.mm.pluginsdk.model.app.h.t((Context)localObject3, (String)localObject2);
      locala = new aa.a();
      if (localObject2 == null) {
        break label623;
      }
      if (((CharSequence)localObject2).length() <= 0) {
        break label618;
      }
      i = 1;
      if (i != 1) {
        break label623;
      }
      bool1 = true;
      locala.aaBx = bool1;
      if (localObject2 == null) {
        break label634;
      }
      if (((CharSequence)localObject2).length() <= 0) {
        break label629;
      }
      i = 1;
      if (i != 1) {
        break label634;
      }
      localObject2 = getContext().getString(b.h.go_to_app_tips, new Object[] { localObject2 });
      p.j(localObject2, "if (appName?.isNotEmpty(…pp_tips, appName) else \"\"");
      localObject3 = com.tencent.mm.plugin.mv.ui.a.Gfi;
      localObject3 = localg.GaB;
      if (localObject3 == null) {
        break label641;
      }
      localObject3 = ((bds)localObject3).SOJ;
      label286:
      localObject4 = com.tencent.mm.plugin.mv.ui.a.aSJ((String)localObject3);
      localObject3 = new aa.f();
      ((aa.f)localObject3).aaBC = null;
      if (!Util.isNullOrNil((String)localObject4))
      {
        if (!n.M((String)localObject4, "file://", false)) {
          break label647;
        }
        ((aa.f)localObject3).aaBC = BitmapUtil.getBitmapNative((String)localObject4);
      }
      label338:
      if ((Bitmap)((aa.f)localObject3).aaBC == null) {
        break label756;
      }
      localObject4 = (Bitmap)((aa.f)localObject3).aaBC;
      if (localObject4 == null) {
        p.iCn();
      }
      if (((Bitmap)localObject4).isRecycled()) {
        break label756;
      }
      localObject3 = BitmapUtil.getRoundedCornerBitmap((Bitmap)((aa.f)localObject3).aaBC, false, com.tencent.mm.ci.a.fromDPToPix((Context)getContext(), 4));
      localObject3 = new BitmapDrawable(getResources(), (Bitmap)localObject3);
      label416:
      if (!locala.aaBx) {
        break label768;
      }
      if (localObject3 == null) {
        break label762;
      }
      bool1 = true;
    }
    for (;;)
    {
      locala.aaBx = bool1;
      ((e)localObject1).a((q.f)new c(this, bool3, locala, (BitmapDrawable)localObject3, (String)localObject2));
      ((e)localObject1).b((q.f)new d(this, bool4, bool2 ^ true, paramf, bool3));
      ((e)localObject1).a((q.g)new e(this, paramf, localg));
      ((e)localObject1).b((q.g)new f(this, paramf, localg, parami));
      ((e)localObject1).b((e.b)g.GmQ);
      ((e)localObject1).eik();
      AppMethodBeat.o(230961);
      return;
      localObject1 = null;
      break;
      label556:
      localObject1 = new e((Context)getActivity(), 0, true);
      ((e)localObject1).j((CharSequence)getActivity().getResources().getString(b.h.music_mv_posting_share_title), 17, com.tencent.mm.ci.a.fromDPToPix((Context)getActivity(), 12));
      break label127;
      label612:
      localObject2 = null;
      break label155;
      label618:
      i = 0;
      break label193;
      label623:
      bool1 = false;
      break label201;
      label629:
      i = 0;
      break label228;
      label634:
      localObject2 = "";
      break label254;
      label641:
      localObject3 = null;
      break label286;
      label647:
      Object localObject5 = com.tencent.mm.plugin.mv.ui.a.Gfi;
      localObject5 = com.tencent.mm.plugin.mv.ui.a.aSH((String)localObject4);
      Object localObject6 = com.tencent.mm.plugin.mv.ui.a.c.GfN;
      Log.i(com.tencent.mm.plugin.mv.ui.a.c.access$getTAG$cp(), "initCover save Path:".concat(String.valueOf(localObject5)));
      localObject6 = new c.a();
      ((c.a)localObject6).bmF();
      ((c.a)localObject6).gs(true);
      ((c.a)localObject6).Wq((String)localObject5);
      ((c.a)localObject6).h(new Object[] { localObject4 });
      com.tencent.mm.ay.q.bml().a((String)localObject4, ((c.a)localObject6).bmL(), (com.tencent.mm.ay.a.c.d)new b((aa.f)localObject3, (String)localObject5));
      break label338;
      label756:
      localObject3 = null;
      break label416;
      label762:
      bool1 = false;
      continue;
      label768:
      bool1 = false;
    }
  }
  
  public final void k(f paramf)
  {
    AppMethodBeat.i(230959);
    p.k(paramf, "musicMv");
    Intent localIntent = new Intent();
    Object localObject1 = com.tencent.mm.ui.component.g.Xox;
    localObject1 = com.tencent.mm.ui.component.g.lm((Context)getContext()).i(g.class);
    p.j(localObject1, "UICProvider.of(context).…sicMvDataUIC::class.java)");
    g localg = (g)localObject1;
    dbo localdbo = new dbo();
    localObject1 = new FinderObject();
    Object localObject2 = paramf.Gbl;
    long l;
    bdp localbdp;
    Object localObject3;
    if (localObject2 != null)
    {
      l = ((Long)localObject2).longValue();
      ((FinderObject)localObject1).id = l;
      ((FinderObject)localObject1).objectNonceId = paramf.Gbm;
      localObject2 = new FinderObjectDesc();
      localbdp = new bdp();
      localbdp.GaB = localg.GaB;
      localObject3 = new bdr();
      ((bdr)localObject3).SOH = 0.0F;
      ((bdr)localObject3).SOI = 0.0F;
      localbdp.Gbq = ((bdr)localObject3);
      if (paramf.Gbu != 1) {
        break label404;
      }
      localbdp.SOB = paramf.Gbo;
      label182:
      localObject3 = com.tencent.mm.plugin.comm.a.ubo;
      if (!com.tencent.mm.plugin.comm.a.cPm()) {
        break label469;
      }
      localbdp.SOF = 1;
      label199:
      ((FinderObjectDesc)localObject2).mvInfo = localbdp;
      ((FinderObject)localObject1).objectDesc = ((FinderObjectDesc)localObject2);
      localdbo.TIV = ((FinderObject)localObject1);
      if (paramf.Gbu != 1) {
        break label478;
      }
      localdbo.SGC = paramf.Gbt;
      label237:
      localdbo.GiZ = localg.GiZ;
      localObject1 = localdbo.TIV;
      if (localObject1 == null) {
        break label498;
      }
      localObject1 = ((FinderObject)localObject1).objectDesc;
      if (localObject1 == null) {
        break label498;
      }
    }
    label404:
    label469:
    label478:
    label498:
    for (localObject1 = ((FinderObjectDesc)localObject1).mvInfo;; localObject1 = null)
    {
      localdbo.TIX = ((bdp)localObject1);
      localdbo.TIW = l(paramf);
      localIntent.putExtra("key_track_data", localdbo.toByteArray());
      localIntent.putExtra("key_mv_music_duration", localg.GaB.duration);
      localIntent.putExtra("key_mv_enter_maker_ui_from_scene", 3);
      paramf = com.tencent.mm.plugin.music.model.c.FRf;
      com.tencent.mm.plugin.music.model.c.vs(true);
      paramf = com.tencent.mm.plugin.finder.utils.a.ACH;
      com.tencent.mm.plugin.finder.utils.a.K((Context)getActivity(), localIntent);
      paramf = com.tencent.mm.plugin.secdata.ui.a.JbV;
      paramf = (dbs)a.a.a((Context)getContext(), 7, dbs.class);
      if (paramf == null) {
        break label504;
      }
      paramf.TJb = 1;
      AppMethodBeat.o(230959);
      return;
      l = 0L;
      break;
      if (paramf.Gbu != 4) {
        break label182;
      }
      localObject3 = paramf.Gbx;
      if (localObject3 == null) {
        break label182;
      }
      localObject3 = ((FinderObject)localObject3).objectDesc;
      if (localObject3 == null) {
        break label182;
      }
      localObject3 = ((FinderObjectDesc)localObject3).mvInfo;
      if (localObject3 == null) {
        break label182;
      }
      localObject3 = ((bdp)localObject3).SOB;
      if (localObject3 == null) {
        break label182;
      }
      localbdp.SOB = ((LinkedList)localObject3);
      break label182;
      localbdp.SOF = 0;
      break label199;
      if (paramf.Gbu != 4) {
        break label237;
      }
      localdbo.SGC = paramf.Gby;
      break label237;
    }
    label504:
    AppMethodBeat.o(230959);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", "", "kotlin.jvm.PlatformType", "onImageDownload", "(Z[Ljava/lang/Object;)V"})
  static final class b
    implements com.tencent.mm.ay.a.c.d
  {
    b(aa.f paramf, String paramString) {}
    
    public final void a(boolean paramBoolean, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(242698);
      this.GmF.aaBC = BitmapUtil.getBitmapNative(this.GbF);
      AppMethodBeat.o(242698);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class c
    implements q.f
  {
    c(u paramu, boolean paramBoolean, aa.a parama, BitmapDrawable paramBitmapDrawable, String paramString) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramo)
    {
      AppMethodBeat.i(232844);
      CharSequence localCharSequence = (CharSequence)this.GmG.getContext().getString(b.h.app_share_to_weixin);
      int i = b.g.finder_full_share;
      int j = this.GmG.getContext().getResources().getColor(b.b.Brand);
      if (!bool3)
      {
        bool = true;
        paramo.a(101, localCharSequence, i, j, bool);
        localCharSequence = (CharSequence)this.GmG.getContext().getString(b.h.music_share_timeline);
        i = b.g.bottomsheet_icon_moment;
        if (bool3) {
          break label270;
        }
        bool = true;
        label99:
        paramo.a(102, localCharSequence, i, 0, bool);
        localCharSequence = (CharSequence)this.GmG.getContext().getString(b.h.music_favorite);
        i = b.g.bottomsheet_icon_fav;
        if (bool3) {
          break label276;
        }
        bool = true;
        label144:
        paramo.a(103, localCharSequence, i, 0, bool);
        localCharSequence = (CharSequence)this.GmG.getContext().getString(b.h.music_status_title);
        i = b.g.state_icon_main;
        j = this.GmG.getContext().getResources().getColor(b.b.Blue);
        if (bool3) {
          break label282;
        }
      }
      label270:
      label276:
      label282:
      for (boolean bool = true;; bool = false)
      {
        paramo.a(104, localCharSequence, i, j, bool);
        if ((locala.aaBx) && (this.GmJ != null)) {
          paramo.a(105, (CharSequence)this.GmK, (Drawable)this.GmJ, 0);
        }
        AppMethodBeat.o(232844);
        return;
        bool = false;
        break;
        bool = false;
        break label99;
        bool = false;
        break label144;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class d
    implements q.f
  {
    d(u paramu, boolean paramBoolean1, boolean paramBoolean2, f paramf, boolean paramBoolean3) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramo)
    {
      AppMethodBeat.i(243707);
      Object localObject = (CharSequence)this.GmG.getContext().getString(b.h.music_mv_maker_title);
      int i = b.g.icons_outlined_mv_making_share;
      int j = this.GmG.getContext().getResources().getColor(b.b.black_color);
      if (!bool4) {}
      for (boolean bool = true;; bool = false)
      {
        paramo.a(201, (CharSequence)localObject, i, j, bool);
        if (!this.GmM) {
          break;
        }
        localObject = f.GbD;
        if (com.tencent.mm.plugin.mv.model.f.a.c(paramf)) {
          paramo.a(203, (CharSequence)this.GmG.getContext().getString(b.h.music_main_mv_expose), b.g.icons_outlined_report_problem, this.GmG.getContext().getResources().getColor(b.b.black_color), false);
        }
        paramo.a(204, (CharSequence)this.GmG.getContext().getString(b.h.music_clear_screen), b.g.finder_icons_screen_clear, this.GmG.getContext().getResources().getColor(b.b.black_color), false);
        localObject = com.tencent.mm.util.d.YyA;
        if (com.tencent.mm.util.d.ien()) {
          paramo.a(205, (CharSequence)"调试", b.g.icons_outlined_report_problem, this.GmG.getContext().getResources().getColor(b.b.black_color), false);
        }
        AppMethodBeat.o(243707);
        return;
      }
      localObject = (CharSequence)this.GmG.getContext().getString(b.h.finder_edit_menu_delete);
      i = b.g.icons_outlined_delete;
      j = this.GmG.getContext().getResources().getColor(b.b.black_color);
      if (!bool3) {}
      for (bool = true;; bool = false)
      {
        paramo.a(202, (CharSequence)localObject, i, j, bool);
        break;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class e
    implements q.g
  {
    e(u paramu, f paramf, g paramg) {}
    
    public final void onMMMenuItemSelected(final MenuItem paramMenuItem, int paramInt)
    {
      int i = 0;
      paramInt = 0;
      AppMethodBeat.i(242581);
      p.j(paramMenuItem, "menuItem");
      switch (paramMenuItem.getItemId())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(242581);
        return;
        paramMenuItem = paramf.Gbr;
        if (paramMenuItem != null) {
          paramInt = paramMenuItem.extFlag;
        }
        if ((paramInt & 0x400) != 0)
        {
          paramMenuItem = aj.AGc;
          paramMenuItem = (Context)this.GmG.getActivity();
          localObject = this.GmG.getActivity().getString(b.j.finder_private_ban_share);
          p.j(localObject, "activity.getString(com.t…finder_private_ban_share)");
          aj.aL(paramMenuItem, (String)localObject);
          AppMethodBeat.o(242581);
          return;
        }
        u.a(this.GmG, paramf);
        AppMethodBeat.o(242581);
        return;
        paramMenuItem = paramf.Gbr;
        paramInt = i;
        if (paramMenuItem != null) {
          paramInt = paramMenuItem.extFlag;
        }
        if ((paramInt & 0x400) != 0)
        {
          paramMenuItem = aj.AGc;
          paramMenuItem = (Context)this.GmG.getActivity();
          localObject = this.GmG.getActivity().getString(b.j.finder_private_ban_share);
          p.j(localObject, "activity.getString(com.t…finder_private_ban_share)");
          aj.aL(paramMenuItem, (String)localObject);
          AppMethodBeat.o(242581);
          return;
        }
        u.b(this.GmG, paramf);
        AppMethodBeat.o(242581);
        return;
        u.c(this.GmG, paramf);
        AppMethodBeat.o(242581);
        return;
        this.GmG.a(paramf, false);
        AppMethodBeat.o(242581);
        return;
        paramMenuItem = localg.GaB;
        Object localObject = com.tencent.mm.ui.component.g.Xox;
        paramInt = ((k)com.tencent.mm.ui.component.g.lm((Context)this.GmG.getContext()).i(k.class)).a(paramMenuItem, (al)new a(this, paramMenuItem));
        if (paramInt != 7)
        {
          localObject = com.tencent.mm.plugin.mv.model.o.GcB;
          com.tencent.mm.plugin.mv.model.o.a((Context)this.GmG.getActivity(), paramMenuItem, paramf, 2, paramInt, 3);
        }
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "launchSuccess", "", "launchCancel", "onLaunchApp"})
    static final class a
      implements al
    {
      a(u.e parame, bds parambds) {}
      
      public final void y(boolean paramBoolean1, boolean paramBoolean2)
      {
        AppMethodBeat.i(243404);
        com.tencent.mm.plugin.mv.model.o localo;
        if (paramBoolean1)
        {
          localo = com.tencent.mm.plugin.mv.model.o.GcB;
          com.tencent.mm.plugin.mv.model.o.a((Context)this.GmN.GmG.getActivity(), paramMenuItem, this.GmN.Gkl, 2, 1, 3);
        }
        if (paramBoolean2)
        {
          localo = com.tencent.mm.plugin.mv.model.o.GcB;
          com.tencent.mm.plugin.mv.model.o.a((Context)this.GmN.GmG.getActivity(), paramMenuItem, this.GmN.Gkl, 2, 3, 3);
        }
        AppMethodBeat.o(243404);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class f
    implements q.g
  {
    f(u paramu, f paramf, g paramg, i parami) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      JSONArray localJSONArray = null;
      AppMethodBeat.i(240156);
      p.j(paramMenuItem, "menuItem");
      switch (paramMenuItem.getItemId())
      {
      }
      long l;
      h localh;
      Object localObject1;
      do
      {
        AppMethodBeat.o(240156);
        return;
        paramMenuItem = new com.tencent.mm.ui.widget.a.f.a((Context)this.GmG.getContext());
        paramMenuItem.bBl(this.GmG.getContext().getString(b.h.music_main_del_my_mv_tip)).ayp(b.h.app_delete).ayq(this.GmG.getContext().getResources().getColor(b.b.red_text_color)).bBq(this.GmG.getContext().getString(b.h.app_cancel)).ayr(this.GmG.getContext().getResources().getColor(b.b.normal_text_color));
        paramMenuItem.c((f.c)new f.c()
        {
          public final void g(boolean paramAnonymousBoolean, String paramAnonymousString)
          {
            AppMethodBeat.i(226293);
            Object localObject2;
            long l;
            if (paramAnonymousBoolean)
            {
              paramAnonymousString = com.tencent.mm.ui.component.g.Xox;
              paramAnonymousString = (k)com.tencent.mm.ui.component.g.b(this.GmP.GmG.getActivity()).i(k.class);
              localObject1 = this.GmP.Gkl;
              p.k(localObject1, "musicMv");
              Log.i(paramAnonymousString.TAG, "deleteMv " + ((f)localObject1).Gbl + ' ' + ((f)localObject1).Gbm + ' ' + ((f)localObject1).Gbu);
              if (((f)localObject1).Gbu == 1)
              {
                localObject2 = ((f)localObject1).Gbl;
                paramAnonymousString = ((f)localObject1).Gbm;
                if ((localObject2 != null) && (paramAnonymousString != null))
                {
                  l = ((Number)localObject2).longValue();
                  localObject1 = com.tencent.mm.kernel.h.aGY();
                  localObject2 = com.tencent.mm.model.z.bdh();
                  p.j(localObject2, "ConfigStorageLogic.getMyFinderUsername()");
                  ((com.tencent.mm.an.t)localObject1).b((com.tencent.mm.an.q)new ay((String)localObject2, l, paramAnonymousString, false));
                  AppMethodBeat.o(226293);
                }
              }
              else if (((f)localObject1).Gbu == 4)
              {
                paramAnonymousString = ((f)localObject1).Gbx;
                if (paramAnonymousString == null) {
                  break label294;
                }
                paramAnonymousString = Long.valueOf(paramAnonymousString.id);
                localObject1 = ((f)localObject1).Gbx;
                if (localObject1 == null) {
                  break label299;
                }
              }
            }
            label294:
            label299:
            for (Object localObject1 = ((FinderObject)localObject1).objectNonceId;; localObject1 = null)
            {
              if ((paramAnonymousString != null) && (localObject1 != null))
              {
                l = ((Number)paramAnonymousString).longValue();
                paramAnonymousString = com.tencent.mm.kernel.h.aGY();
                localObject2 = com.tencent.mm.model.z.bdh();
                p.j(localObject2, "ConfigStorageLogic.getMyFinderUsername()");
                paramAnonymousString.b((com.tencent.mm.an.q)new ay((String)localObject2, l, (String)localObject1, false));
              }
              AppMethodBeat.o(226293);
              return;
              paramAnonymousString = null;
              break;
            }
          }
        }).show();
        AppMethodBeat.o(240156);
        return;
        this.GmG.k(paramf);
        AppMethodBeat.o(240156);
        return;
        paramMenuItem = paramf.Gbl;
        if (paramMenuItem != null)
        {
          l = ((Number)paramMenuItem).longValue();
          m.bx((Context)this.GmG.getContext(), com.tencent.mm.ae.d.Fw(l));
          AppMethodBeat.o(240156);
          return;
        }
        AppMethodBeat.o(240156);
        return;
        localg.AJP = true;
        u.a(this.GmG, parami);
        u.a(this.GmG, parami, paramf);
        AppMethodBeat.o(240156);
        return;
        paramMenuItem = com.tencent.mm.ui.component.g.Xox;
        localh = (h)com.tencent.mm.ui.component.g.lm((Context)this.GmG.getContext()).i(h.class);
        localObject1 = paramf;
        p.k(localObject1, "musicMv");
        paramMenuItem = com.tencent.mm.util.d.YyA;
      } while (!com.tencent.mm.util.d.ien());
      paramMenuItem = com.tencent.mm.ui.component.g.Xox;
      Object localObject2 = ((g)com.tencent.mm.ui.component.g.b(localh.getActivity()).i(g.class)).GaB;
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("songId", ((bds)localObject2).kkU);
      localJSONObject.put("songName", ((bds)localObject2).HLH);
      localJSONObject.put("singer", ((bds)localObject2).ozs);
      localJSONObject.put("albumName", ((bds)localObject2).albumName);
      localJSONObject.put("albumUrl", ((bds)localObject2).SOM);
      localJSONObject.put("musicWebUrl", ((bds)localObject2).SOK);
      localJSONObject.put("musicDataUrl", ((bds)localObject2).musicDataUrl);
      localJSONObject.put("genre", ((bds)localObject2).SMY);
      localJSONObject.put("publicTime", ((bds)localObject2).SON);
      localJSONObject.put("musicAppId", ((bds)localObject2).SOJ);
      localJSONObject.put("publicTimeS", ((bds)localObject2).SOO);
      localJSONObject.put("extraInfo", ((bds)localObject2).extraInfo);
      localJSONObject.put("identification", ((bds)localObject2).identification);
      paramMenuItem = com.tencent.mm.plugin.music.e.k.fet();
      p.j(paramMenuItem, "MusicPlayerManager.Instance()");
      paramMenuItem = paramMenuItem.feg();
      if (paramMenuItem != null)
      {
        paramMenuItem = Integer.valueOf(paramMenuItem.getDuration());
        label581:
        localJSONObject.put("duration", paramMenuItem);
        localJSONObject.put("musicDuration", ((bds)localObject2).duration);
        paramMenuItem = com.tencent.mm.plugin.music.e.k.fet();
        p.j(paramMenuItem, "MusicPlayerManager.Instance()");
        paramMenuItem = paramMenuItem.feg();
        if (paramMenuItem == null) {
          break label1186;
        }
        paramMenuItem = Integer.valueOf(paramMenuItem.fdx());
        label635:
        localJSONObject.put("currentPosition", paramMenuItem);
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("localId", ((f)localObject1).Gbi);
        ((JSONObject)localObject2).put("localCoverPath", ((f)localObject1).Gbk);
        ((JSONObject)localObject2).put("mvObjectId", ((f)localObject1).Gbl);
        paramMenuItem = ((f)localObject1).Gbl;
        if (paramMenuItem == null) {
          break label1191;
        }
        l = paramMenuItem.longValue();
        label711:
        ((JSONObject)localObject2).put("unsignedMvObjectId", com.tencent.mm.ae.d.Fw(l));
        ((JSONObject)localObject2).put("mvObjectNonceId", ((f)localObject1).Gbm);
        ((JSONObject)localObject2).put("mvMakerNickName", ((f)localObject1).Gbn);
        paramMenuItem = ((f)localObject1).Gbr;
        if (paramMenuItem == null) {
          break label1196;
        }
        paramMenuItem = paramMenuItem.username;
        label767:
        ((JSONObject)localObject2).put("mvMakerUsername", paramMenuItem);
        ((JSONObject)localObject2).put("coverUrl", ((f)localObject1).coverUrl);
        ((JSONObject)localObject2).put("likeCount", ((f)localObject1).likeCount);
        ((JSONObject)localObject2).put("forwardCount", ((f)localObject1).forwardCount);
        ((JSONObject)localObject2).put("commentCount", ((f)localObject1).commentCount);
        ((JSONObject)localObject2).put("mvPostStatus", ((f)localObject1).Gbu);
        ((JSONObject)localObject2).put("isDelete", ((f)localObject1).wGy);
        paramMenuItem = ((f)localObject1).Gbq;
        if (paramMenuItem == null) {
          break label1201;
        }
      }
      label1186:
      label1191:
      label1196:
      label1201:
      for (paramMenuItem = Float.valueOf(paramMenuItem.SOH);; paramMenuItem = null)
      {
        ((JSONObject)localObject2).put("originality", paramMenuItem);
        Object localObject3 = ((f)localObject1).Gbq;
        paramMenuItem = localJSONArray;
        if (localObject3 != null) {
          paramMenuItem = Float.valueOf(((bdr)localObject3).SOI);
        }
        ((JSONObject)localObject2).put("completion", paramMenuItem);
        paramMenuItem = h.g((f)localObject1);
        localJSONArray = h.h((f)localObject1);
        localObject1 = h.fgW();
        localObject3 = new e((Context)localh.getActivity(), 0, false);
        ((e)localObject3).a((q.f)new h.b(localh));
        ((e)localObject3).b((q.f)new h.c(localh));
        ((e)localObject3).a((q.g)new h.d(localh, localJSONObject, (JSONObject)localObject2, paramMenuItem, localJSONArray, (JSONObject)localObject1));
        ((e)localObject3).b((q.g)new h.e(localh, localJSONObject, (JSONObject)localObject2, paramMenuItem, localJSONArray, (JSONObject)localObject1));
        ((e)localObject3).b((e.b)h.f.Gjh);
        ((e)localObject3).eik();
        Log.e(localh.TAG, "MV START####################################################START");
        Log.e(localh.TAG, "songInfoText: ".concat(String.valueOf(localJSONObject)));
        Log.e(localh.TAG, "mvHeadInfoText: ".concat(String.valueOf(localObject2)));
        Log.e(localh.TAG, "mvTrackInfoText: ".concat(String.valueOf(paramMenuItem)));
        Log.e(localh.TAG, "mvRefObjInfoText: ".concat(String.valueOf(localJSONArray)));
        Log.e(localh.TAG, "cgiInfo: ".concat(String.valueOf(localJSONArray)));
        Log.e(localh.TAG, "MV END  ####################################################  END");
        break;
        paramMenuItem = null;
        break label581;
        paramMenuItem = null;
        break label635;
        l = 0L;
        break label711;
        paramMenuItem = null;
        break label767;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onDismiss"})
  static final class g
    implements e.b
  {
    public static final g GmQ;
    
    static
    {
      AppMethodBeat.i(240438);
      GmQ = new g();
      AppMethodBeat.o(240438);
    }
    
    public final void onDismiss() {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
  static final class h
    implements MMActivity.a
  {
    h(u paramu, f paramf, bds parambds) {}
    
    public final void d(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(232281);
      if ((2 == paramInt1) && (paramInt2 == -1))
      {
        Toast.makeText((Context)this.GmG.getContext(), (CharSequence)this.GmG.getContext().getResources().getString(b.h.share_ok), 0).show();
        paramIntent = f.GbD;
        FinderObject localFinderObject = com.tencent.mm.plugin.mv.model.f.a.b(this.Gkl);
        if (localFinderObject != null)
        {
          Object localObject = new LinkedList();
          String str2 = com.tencent.mm.ae.d.Fw(localFinderObject.id);
          String str1 = localFinderObject.objectNonceId;
          paramIntent = str1;
          if (str1 == null) {
            paramIntent = "";
          }
          ((LinkedList)localObject).add(new Pair(str2, paramIntent));
          ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).shareStatsReport((List)localObject, false);
          localObject = new StringBuilder("share mv to sns success ").append(com.tencent.mm.ae.d.Fw(localFinderObject.id)).append(' ');
          str1 = localFinderObject.objectNonceId;
          paramIntent = str1;
          if (str1 == null) {
            paramIntent = "";
          }
          Log.i("MicroMsg.Mv.MusicMvShareUIC", paramIntent);
          paramIntent = com.tencent.mm.plugin.mv.model.o.GcB;
          com.tencent.mm.plugin.mv.model.o.a((Context)this.GmG.getContext(), this.GmO, this.Gkl, 1, "");
          AppMethodBeat.o(232281);
          return;
        }
      }
      AppMethodBeat.o(232281);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
  static final class i
    implements MMActivity.a
  {
    i(u paramu, f paramf, bds parambds) {}
    
    public final void d(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(228936);
      if ((paramInt1 == 1) && (paramInt2 == -1))
      {
        Object localObject1 = f.GbD;
        Object localObject3 = com.tencent.mm.plugin.mv.model.f.a.b(this.Gkl);
        if (localObject3 != null)
        {
          Object localObject4 = new LinkedList();
          String str = com.tencent.mm.ae.d.Fw(((FinderObject)localObject3).id);
          Object localObject2 = ((FinderObject)localObject3).objectNonceId;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          ((LinkedList)localObject4).add(new Pair(str, localObject1));
          ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).shareStatsReport((List)localObject4, false);
          localObject4 = new StringBuilder("share mv success ").append(com.tencent.mm.ae.d.Fw(((FinderObject)localObject3).id)).append(' ');
          localObject2 = ((FinderObject)localObject3).objectNonceId;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          Log.i("MicroMsg.Mv.MusicMvShareUIC", (String)localObject1);
          paramIntent = Util.listToString((List)paramIntent.getStringArrayListExtra("SendMsgUsernames"), ";");
          localObject1 = com.tencent.mm.plugin.mv.model.o.GcB;
          localObject1 = (Context)this.GmG.getContext();
          localObject2 = this.GmO;
          localObject3 = this.Gkl;
          p.j(paramIntent, "userListStr");
          com.tencent.mm.plugin.mv.model.o.a((Context)localObject1, (bds)localObject2, (f)localObject3, 2, paramIntent);
          AppMethodBeat.o(228936);
          return;
        }
      }
      AppMethodBeat.o(228936);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.u
 * JD-Core Version:    0.7.0.1
 */