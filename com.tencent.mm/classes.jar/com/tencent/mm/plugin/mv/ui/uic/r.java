package com.tencent.mm.plugin.mv.ui.uic;

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
import android.os.Bundle;
import android.text.SpannableString;
import android.util.Pair;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.Window;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.z;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.bt;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.findersdk.a.cq;
import com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation;
import com.tencent.mm.plugin.music.model.m;
import com.tencent.mm.plugin.mv.b.b;
import com.tencent.mm.plugin.mv.b.c;
import com.tencent.mm.plugin.mv.b.d;
import com.tencent.mm.plugin.mv.b.e;
import com.tencent.mm.plugin.mv.b.g;
import com.tencent.mm.plugin.mv.b.h;
import com.tencent.mm.plugin.mv.model.f.a;
import com.tencent.mm.plugin.mv.model.o;
import com.tencent.mm.plugin.secdata.ui.a.a;
import com.tencent.mm.plugin.textstatus.a.w.a;
import com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bol;
import com.tencent.mm.protocal.protobuf.bon;
import com.tencent.mm.protocal.protobuf.boo;
import com.tencent.mm.protocal.protobuf.bop;
import com.tencent.mm.protocal.protobuf.dtf;
import com.tencent.mm.protocal.protobuf.dti;
import com.tencent.mm.protocal.protobuf.dtj;
import com.tencent.mm.protocal.protobuf.dtk;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.vfs.y;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.ah;
import kotlin.g.b.ah.a;
import kotlin.g.b.ah.f;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvShareUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "currentShareMv", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "fullScreenAnimate", "Lcom/tencent/mm/plugin/mv/ui/uic/VisibleRecord;", "isNextStep", "", "mRecentForwardReporter", "Lcom/tencent/mm/plugin/mv/ui/uic/RecentForwardReporter;", "clickOptionsMenu", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "musicMv", "shareSource", "", "doFav", "doRecentForward", "username", "", "doShareMvToTimeLine", "musicWrapper", "Lcom/tencent/mm/modelmusic/MusicWrapper;", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "Landroid/app/Activity;", "coverBm", "Landroid/graphics/Bitmap;", "CoverLocalPath", "shareObject", "Lcom/tencent/mm/protocal/protobuf/MusicShareObject;", "doShareToChat", "doShareToSns", "getMvCoverLocalPath", "mv", "getTextStatusTips", "Landroid/text/SpannableString;", "context", "Landroid/content/Context;", "initLocalPostStats", "onCreateMVBtnClicked", "setTextStatus", "isFromBubble", "updateFullScreen", "Companion", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r
  extends UIComponent
{
  public static final r.a MgQ;
  private final x MaZ;
  private com.tencent.mm.plugin.mv.model.f MgR;
  private w MgS;
  private boolean MgT;
  
  static
  {
    AppMethodBeat.i(288187);
    MgQ = new r.a((byte)0);
    AppMethodBeat.o(288187);
  }
  
  public r(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(287758);
    this.MaZ = new x();
    AppMethodBeat.o(287758);
  }
  
  private static final void a(com.tencent.mm.plugin.mv.model.f paramf, View paramView)
  {
    AppMethodBeat.i(288078);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramf);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/uic/MusicMvShareUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramf, "$mv");
    paramf = paramf.LXg;
    if (paramf != null)
    {
      long l = ((Number)paramf).longValue();
      paramf = com.tencent.mm.plugin.finder.storage.logic.d.FND;
      paramf = d.a.qr(l);
      if (paramf != null) {
        ((com.tencent.mm.plugin.finder.publish.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.finder.publish.c.class)).finderPostManager().fy(paramf);
      }
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/mv/ui/uic/MusicMvShareUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(288078);
  }
  
  private static final void a(com.tencent.mm.plugin.mv.model.f paramf, r paramr, boo paramboo, int paramInt1, int paramInt2, int paramInt3, Intent paramIntent)
  {
    AppMethodBeat.i(288125);
    kotlin.g.b.s.u(paramf, "$musicMv");
    kotlin.g.b.s.u(paramr, "this$0");
    kotlin.g.b.s.u(paramboo, "$songInfo");
    if ((paramInt2 == 1) && (paramInt3 == -1))
    {
      Object localObject1 = com.tencent.mm.plugin.mv.model.f.LXf;
      FinderObject localFinderObject = f.a.b(paramf);
      if (localFinderObject != null)
      {
        Object localObject2 = new LinkedList();
        String str2 = com.tencent.mm.ae.d.hF(localFinderObject.id);
        String str1 = localFinderObject.objectNonceId;
        localObject1 = str1;
        if (str1 == null) {
          localObject1 = "";
        }
        ((LinkedList)localObject2).add(new Pair(str2, localObject1));
        ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).shareStatsReport((List)localObject2, false);
        localObject2 = new StringBuilder("share mv success ").append(com.tencent.mm.ae.d.hF(localFinderObject.id)).append(' ');
        str1 = localFinderObject.objectNonceId;
        localObject1 = str1;
        if (str1 == null) {
          localObject1 = "";
        }
        Log.i("MicroMsg.Mv.MusicMvShareUIC", (String)localObject1);
        paramIntent = Util.listToString((List)paramIntent.getStringArrayListExtra("SendMsgUsernames"), ";");
        localObject1 = o.LYk;
        paramr = (Context)paramr.getContext();
        kotlin.g.b.s.s(paramIntent, "userListStr");
        o.a(paramr, paramboo, paramf, 2, paramIntent, paramInt1);
      }
    }
    AppMethodBeat.o(288125);
  }
  
  private static final void a(com.tencent.mm.plugin.mv.model.f paramf, r paramr, String paramString, boo paramboo, int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(288096);
    kotlin.g.b.s.u(paramf, "$musicMv");
    kotlin.g.b.s.u(paramr, "this$0");
    kotlin.g.b.s.u(paramString, "$username");
    kotlin.g.b.s.u(paramboo, "$songInfo");
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      Object localObject1 = com.tencent.mm.plugin.mv.model.f.LXf;
      FinderObject localFinderObject = f.a.b(paramf);
      if (localFinderObject != null)
      {
        Object localObject2 = new LinkedList();
        String str2 = com.tencent.mm.ae.d.hF(localFinderObject.id);
        String str1 = localFinderObject.objectNonceId;
        localObject1 = str1;
        if (str1 == null) {
          localObject1 = "";
        }
        ((LinkedList)localObject2).add(new Pair(str2, localObject1));
        ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).shareStatsReport((List)localObject2, false);
        localObject2 = new StringBuilder("share mv success ").append(com.tencent.mm.ae.d.hF(localFinderObject.id)).append(' ');
        str1 = localFinderObject.objectNonceId;
        localObject1 = str1;
        if (str1 == null) {
          localObject1 = "";
        }
        Log.i("MicroMsg.Mv.MusicMvShareUIC", (String)localObject1);
        localObject1 = paramr.MgS;
        if (localObject1 != null)
        {
          long l = System.currentTimeMillis();
          kotlin.g.b.s.u(paramString, "toUser");
          ((w)localObject1).b(l, 3, "2", paramString);
        }
        paramIntent = Util.listToString((List)paramIntent.getStringArrayListExtra("SendMsgUsernames"), ";");
        ((PluginMessengerFoundation)com.tencent.mm.kernel.h.az(PluginMessengerFoundation.class)).getRecentForwardInfoStorage().bzq(paramString);
        paramString = o.LYk;
        paramr = (Context)paramr.getContext();
        kotlin.g.b.s.s(paramIntent, "userListStr");
        o.a(paramr, paramboo, paramf, 2, paramIntent, 2);
      }
    }
    AppMethodBeat.o(288096);
  }
  
  private void a(com.tencent.mm.plugin.mv.model.f paramf, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(287863);
    Object localObject1 = k.aeZF;
    localObject1 = k.nq((Context)getContext()).q(e.class);
    kotlin.g.b.s.s(localObject1, "UICProvider.of(context).…sicMvDataUIC::class.java)");
    localObject1 = (e)localObject1;
    boo localboo = ((e)localObject1).LWI;
    String str1 = ((e)localObject1).verifyInfo;
    if ((localboo != null) && (paramf != null) && (str1 != null))
    {
      localObject3 = localboo.ZWS;
      localObject1 = (CharSequence)localObject3;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        break label583;
      }
    }
    label583:
    for (int i = 1;; i = 0)
    {
      localObject1 = localObject3;
      if (i != 0) {}
      try
      {
        localObject1 = com.tencent.mm.plugin.mv.ui.a.Maz;
        localObject4 = com.tencent.mm.plugin.mv.ui.a.aPB("DEFAULT_TEXT_STATUS_MUSIC_THUMB_PATH");
        localObject1 = localObject3;
        if (!y.ZC((String)localObject4))
        {
          BitmapUtil.saveBitmapToImage(BitmapFactory.decodeResource(getContext().getResources(), b.d.LRL), 100, Bitmap.CompressFormat.PNG, (String)localObject4, true);
          localObject1 = localObject4;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject4;
          com.tencent.mm.plugin.textstatus.a.n localn;
          Activity localActivity;
          w.a locala;
          TextStatusJumpInfo localTextStatusJumpInfo;
          StringBuilder localStringBuilder;
          long l;
          String str2;
          Log.e("MicroMsg.Mv.MusicMvShareUIC", kotlin.g.b.s.X("save default text status thumb fail! ", localException.getLocalizedMessage()));
          Object localObject2 = localObject3;
          continue;
          localObject2 = paramf;
          continue;
          if (((com.tencent.mm.plugin.mv.model.f)localObject2).LXs == 4)
          {
            localObject4 = ((com.tencent.mm.plugin.mv.model.f)localObject2).LXv;
            if (localObject4 != null)
            {
              localObject3 = new dtj();
              ((dtj)localObject3).YqN = com.tencent.mm.ae.d.hF(((FinderObject)localObject4).id);
              ((dtj)localObject3).YqO = ((FinderObject)localObject4).objectNonceId;
              localObject2 = ((FinderObject)localObject4).objectDesc;
              if (localObject2 == null)
              {
                localObject2 = null;
                ((dtj)localObject3).YqP = ((String)localObject2);
                localObject2 = ((FinderObject)localObject4).contact;
                if (localObject2 != null) {
                  break label792;
                }
                localObject2 = "";
              }
              for (;;)
              {
                ((dtj)localObject3).YqQ = ((String)localObject2);
                localObject2 = ah.aiuX;
                localObject2 = localObject3;
                break;
                localObject2 = ((FinderObjectDesc)localObject2).media;
                if (localObject2 == null)
                {
                  localObject2 = null;
                  break label689;
                }
                localObject2 = (FinderMedia)kotlin.a.p.oL((List)localObject2);
                if (localObject2 == null)
                {
                  localObject2 = null;
                  break label689;
                }
                localObject2 = kotlin.g.b.s.X(((FinderMedia)localObject2).thumbUrl, ((FinderMedia)localObject2).thumb_url_token);
                break label689;
                localObject4 = ((FinderContact)localObject2).nickname;
                localObject2 = localObject4;
                if (localObject4 == null) {
                  localObject2 = "";
                }
              }
              if (paramBoolean)
              {
                paramInt = 4;
                continue;
              }
              paramInt = 3;
              continue;
            }
          }
          localObject2 = null;
          continue;
          localObject2 = null;
        }
      }
      localn = (com.tencent.mm.plugin.textstatus.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.textstatus.a.n.class);
      localActivity = getContext();
      locala = new w.a().bdr("1016").bdt((String)localObject1).bdu("music_player@inner").bdx(localboo.songName).bdy("http://wxapp.tc.qq.com/258/20304/stodownload?m=2009416463c227ad5a09b4fcf23bf985&filekey=30340201010420301e020201020402534804102009416463c227ad5a09b4fcf23bf9850202042e040d00000004627466730000000131&hy=SH&storeid=32303231303331383139353931363030306366646534303030303030303037636638353130393030303030313032&bizid=1023").bdv(localboo.mLQ).bdw(str1);
      localTextStatusJumpInfo = new TextStatusJumpInfo();
      localTextStatusJumpInfo.jumpType = "1";
      kotlin.g.b.s.u(localboo, "songInfo");
      localStringBuilder = new StringBuilder("\n<MusicVideoStatusOpenParams>\n").append(com.tencent.mm.plugin.mv.ui.a.d.c(localboo)).append('\n');
      if (paramf != null) {
        break;
      }
      localObject1 = new com.tencent.mm.plugin.mv.model.f();
      str1 = localboo.ZWS;
      kotlin.g.b.s.u(localObject1, "<this>");
      kotlin.g.b.s.u(localObject1, "<this>");
      if (((com.tencent.mm.plugin.mv.model.f)localObject1).LXs != 1) {
        break label621;
      }
      localObject4 = ((com.tencent.mm.plugin.mv.model.f)localObject1).LXj;
      localObject3 = ((com.tencent.mm.plugin.mv.model.f)localObject1).LXk;
      if ((localObject4 == null) || (localObject3 == null)) {
        break label830;
      }
      l = ((Number)localObject4).longValue();
      if (l == 0L) {
        break label836;
      }
      localObject4 = new dtj();
      ((dtj)localObject4).YqN = com.tencent.mm.ae.d.hF(l);
      ((dtj)localObject4).YqO = ((String)localObject3);
      str2 = ((com.tencent.mm.plugin.mv.model.f)localObject1).coverUrl;
      localObject3 = str2;
      if (str2 == null) {
        localObject3 = str1;
      }
      ((dtj)localObject4).YqP = ((String)localObject3);
      ((dtj)localObject4).YqQ = ((com.tencent.mm.plugin.mv.model.f)localObject1).LXl;
      localObject1 = ah.aiuX;
      localObject1 = localObject4;
      localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = new dtj();
      }
      localObject1 = cq.a((dtj)localObject3);
      kotlin.g.b.s.s(localObject1, "makeContent(toMusicShareObject(albumUrl))");
      localTextStatusJumpInfo.busiBuf = kotlin.n.n.bJB((String)localObject1 + "\n</MusicVideoStatusOpenParams>");
      localObject1 = ah.aiuX;
      localObject1 = locala.ls(kotlin.a.p.listOf(localTextStatusJumpInfo));
      ((w.a)localObject1).ThS.Toh = false;
      localn.a(localActivity, 1, ((w.a)localObject1).ThS);
      localObject1 = o.LYk;
      localObject1 = (Context)getContext();
      if (paramInt != 3) {
        break label816;
      }
      paramInt = 5;
      o.a((Context)localObject1, localboo, paramf, 3, 0, paramInt);
      AppMethodBeat.o(287863);
      return;
    }
  }
  
  private static final void a(r paramr, com.tencent.mm.plugin.mv.model.f paramf, int paramInt1, e parame, MenuItem paramMenuItem, int paramInt2)
  {
    AppMethodBeat.i(288011);
    kotlin.g.b.s.u(paramr, "this$0");
    kotlin.g.b.s.u(paramf, "$musicMv");
    kotlin.g.b.s.u(parame, "$dataUIC");
    Object localObject1;
    if (paramMenuItem.getItemId() != 101)
    {
      localObject1 = paramr.MgS;
      if (localObject1 != null) {
        ((w)localObject1).sN(System.currentTimeMillis());
      }
    }
    paramr.MgT = true;
    Object localObject4;
    Object localObject2;
    Object localObject3;
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(288011);
      return;
    case 101: 
      parame = paramf.LXp;
      if (parame == null) {}
      for (paramInt2 = 0; (paramInt2 & 0x400) != 0; paramInt2 = parame.extFlag)
      {
        paramf = av.GiL;
        paramf = (Context)paramr.getActivity();
        paramr = paramr.getActivity().getString(e.h.finder_private_ban_share);
        kotlin.g.b.s.s(paramr, "activity.getString(com.t…finder_private_ban_share)");
        av.aO(paramf, paramr);
        AppMethodBeat.o(288011);
        return;
      }
      parame = paramr.MgS;
      if (parame != null) {
        parame.b(System.currentTimeMillis(), 2, "2", null);
      }
      paramr.MgR = paramf;
      parame = k.aeZF;
      parame = k.d(paramr.getActivity()).q(e.class);
      kotlin.g.b.s.s(parame, "UICProvider.of(activity)…sicMvDataUIC::class.java)");
      localObject4 = (e)parame;
      localObject1 = ((e)localObject4).LWI;
      localObject2 = new com.tencent.mm.message.k.b();
      ((com.tencent.mm.message.k.b)localObject2).type = 76;
      ((com.tencent.mm.message.k.b)localObject2).title = ((boo)localObject1).songName;
      ((com.tencent.mm.message.k.b)localObject2).description = ((boo)localObject1).rDl;
      ((com.tencent.mm.message.k.b)localObject2).messageExt = ((boo)localObject1).extraInfo;
      paramMenuItem = ((boo)localObject1).ZWR;
      parame = paramMenuItem;
      if (paramMenuItem == null) {
        parame = "";
      }
      ((com.tencent.mm.message.k.b)localObject2).url = parame;
      ((com.tencent.mm.message.k.b)localObject2).nRc = "";
      paramMenuItem = ((boo)localObject1).musicDataUrl;
      parame = paramMenuItem;
      if (paramMenuItem == null) {
        parame = "";
      }
      ((com.tencent.mm.message.k.b)localObject2).nRx = parame;
      ((com.tencent.mm.message.k.b)localObject2).nRy = "";
      ((com.tencent.mm.message.k.b)localObject2).appId = ((boo)localObject1).ZWQ;
      localObject3 = new com.tencent.mm.pluginsdk.ui.tools.b();
      ((com.tencent.mm.pluginsdk.ui.tools.b)localObject3).songAlbumUrl = ((boo)localObject1).ZWS;
      ((com.tencent.mm.pluginsdk.ui.tools.b)localObject3).songLyric = ((boo)localObject1).Mcq;
      ((com.tencent.mm.pluginsdk.ui.tools.b)localObject3).oOZ = ((boo)localObject1).oOZ;
      if (((e)localObject4).Mef)
      {
        parame = "wx485a97c844086dc9";
        label420:
        ((com.tencent.mm.pluginsdk.ui.tools.b)localObject3).YqY = parame;
        parame = com.tencent.mm.plugin.mv.model.f.LXf;
        parame = f.a.b(paramf);
        if (parame != null)
        {
          ((com.tencent.mm.pluginsdk.ui.tools.b)localObject3).YqN = com.tencent.mm.ae.d.hF(parame.id);
          ((com.tencent.mm.pluginsdk.ui.tools.b)localObject3).YqO = parame.objectNonceId;
          paramMenuItem = parame.objectDesc;
          if (paramMenuItem != null)
          {
            paramMenuItem = paramMenuItem.media;
            if (paramMenuItem != null)
            {
              paramMenuItem = (FinderMedia)kotlin.a.p.oL((List)paramMenuItem);
              if (paramMenuItem != null) {
                ((com.tencent.mm.pluginsdk.ui.tools.b)localObject3).YqP = kotlin.g.b.s.X(paramMenuItem.thumbUrl, paramMenuItem.thumb_url_token);
              }
            }
          }
          parame = parame.contact;
          if (parame != null) {
            break label899;
          }
          parame = null;
          label530:
          ((com.tencent.mm.pluginsdk.ui.tools.b)localObject3).YqQ = parame;
        }
        ((com.tencent.mm.pluginsdk.ui.tools.b)localObject3).songAlbumUrl = ((boo)localObject1).ZWS;
        ((com.tencent.mm.pluginsdk.ui.tools.b)localObject3).songLyric = ((boo)localObject1).Mcq;
        ((com.tencent.mm.pluginsdk.ui.tools.b)localObject3).YqR = ((boo)localObject1).rDl;
        ((com.tencent.mm.pluginsdk.ui.tools.b)localObject3).YqS = ((boo)localObject1).albumName;
        ((com.tencent.mm.pluginsdk.ui.tools.b)localObject3).YqT = ((boo)localObject1).ZTA;
        ((com.tencent.mm.pluginsdk.ui.tools.b)localObject3).YqU = String.valueOf(((boo)localObject1).ZWU);
        ((com.tencent.mm.pluginsdk.ui.tools.b)localObject3).YqV = ((boo)localObject1).identification;
        ((com.tencent.mm.pluginsdk.ui.tools.b)localObject3).LNC = ((boo)localObject1).duration;
        ((com.tencent.mm.pluginsdk.ui.tools.b)localObject3).YqW = ((boo)localObject1).extraInfo;
        parame = ((boo)localObject1).ZWW;
        if (parame != null) {
          break label907;
        }
        parame = "";
        label643:
        ((com.tencent.mm.pluginsdk.ui.tools.b)localObject3).YqX = parame;
        ((com.tencent.mm.message.k.b)localObject2).a((com.tencent.mm.message.f)localObject3);
        parame = paramr.m(paramf);
        localObject2 = com.tencent.mm.message.k.b.a((com.tencent.mm.message.k.b)localObject2, null, null);
        paramMenuItem = new Intent();
        paramMenuItem.putExtra("Retr_Msg_Type", 2);
        paramMenuItem.putExtra("Retr_Msg_content", (String)localObject2);
        paramMenuItem.putExtra("Multi_Retr", true);
        paramMenuItem.putExtra("Retr_go_to_chattingUI", false);
        paramMenuItem.putExtra("Retr_show_success_tips", true);
        if (parame != null) {
          break label2342;
        }
        parame = m.H(com.tencent.mm.aw.a.bLn());
      }
      break;
    }
    label899:
    label907:
    label1304:
    label1827:
    label2342:
    for (;;)
    {
      paramMenuItem.putExtra("Retr_Msg_thumb_path", parame);
      localObject2 = com.tencent.mm.plugin.music.model.c.LLZ;
      com.tencent.mm.plugin.music.model.c.zK(true);
      com.tencent.mm.br.c.a((MMActivity)paramr.getContext(), ".ui.transmit.MsgRetransmitUI", paramMenuItem, 1, new r..ExternalSyntheticLambda4(paramf, paramr, (boo)localObject1, paramInt1));
      Log.i("MicroMsg.Mv.MusicMvShareUIC", "share mv to chat songName:" + ((boo)localObject1).songName + " mvObjectId:" + ((com.tencent.mm.pluginsdk.ui.tools.b)localObject3).YqN + " mvNonceId:" + ((com.tencent.mm.pluginsdk.ui.tools.b)localObject3).YqO + " mvCoverUrl:" + ((com.tencent.mm.pluginsdk.ui.tools.b)localObject3).YqP + " mvMakerFinderNickname:" + ((com.tencent.mm.pluginsdk.ui.tools.b)localObject3).YqQ + ", localCoverPath: " + parame);
      AppMethodBeat.o(288011);
      return;
      parame = "";
      break label420;
      parame = parame.nickname;
      break label530;
      paramMenuItem = parame.ZWX;
      parame = paramMenuItem;
      if (paramMenuItem != null) {
        break label643;
      }
      parame = "";
      break label643;
      parame = paramf.LXp;
      if (parame == null) {}
      for (paramInt2 = 0; (paramInt2 & 0x400) != 0; paramInt2 = parame.extFlag)
      {
        paramf = av.GiL;
        paramf = (Context)paramr.getActivity();
        paramr = paramr.getActivity().getString(e.h.finder_private_ban_share);
        kotlin.g.b.s.s(paramr, "activity.getString(com.t…finder_private_ban_share)");
        av.aO(paramf, paramr);
        AppMethodBeat.o(288011);
        return;
      }
      paramr.MgR = paramf;
      parame = null;
      paramMenuItem = com.tencent.mm.plugin.mv.model.f.LXf;
      localObject1 = f.a.b(paramf);
      if (localObject1 != null)
      {
        paramMenuItem = new dtj();
        paramMenuItem.YqN = com.tencent.mm.ae.d.hF(((FinderObject)localObject1).id);
        paramMenuItem.YqO = ((FinderObject)localObject1).objectNonceId;
        parame = ((FinderObject)localObject1).objectDesc;
        if (parame != null)
        {
          parame = parame.media;
          if (parame != null)
          {
            parame = (FinderMedia)kotlin.a.p.oL((List)parame);
            if (parame != null) {
              paramMenuItem.YqP = kotlin.g.b.s.X(parame.thumbUrl, parame.thumb_url_token);
            }
          }
        }
        parame = ((FinderObject)localObject1).contact;
        if (parame == null)
        {
          parame = null;
          paramMenuItem.YqQ = parame;
          parame = paramMenuItem;
        }
      }
      else
      {
        localObject3 = com.tencent.mm.plugin.music.logic.j.gnw().gng();
        localObject1 = paramr.m(paramf);
        if (parame != null) {
          break label2336;
        }
      }
      for (paramMenuItem = new dtj();; paramMenuItem = parame)
      {
        parame = k.aeZF;
        parame = k.d(paramr.getActivity()).q(e.class);
        kotlin.g.b.s.s(parame, "UICProvider.of(activity)…sicMvDataUIC::class.java)");
        Object localObject5 = (e)parame;
        localObject4 = ((e)localObject5).LWI;
        paramMenuItem.singerName = ((boo)localObject4).rDl;
        paramMenuItem.albumName = ((boo)localObject4).albumName;
        paramMenuItem.musicGenre = ((boo)localObject4).ZTA;
        paramMenuItem.issueDate = ((boo)localObject4).ZWU;
        paramMenuItem.identification = ((boo)localObject4).identification;
        paramMenuItem.LNC = ((boo)localObject4).duration;
        paramMenuItem.extraInfo = ((boo)localObject4).extraInfo;
        parame = ((boo)localObject4).ZWW;
        label1276:
        WXMediaMessage localWXMediaMessage;
        if (parame == null)
        {
          parame = "";
          paramMenuItem.musicOperationUrl = parame;
          paramMenuItem.oOZ = ((boo)localObject4).oOZ;
          if (!((e)localObject5).Mef) {
            break label1827;
          }
          parame = "wx485a97c844086dc9";
          paramMenuItem.YqY = parame;
          kotlin.g.b.s.s(localObject3, "wrapper");
          localObject5 = (Activity)paramr.getActivity();
          parame = new WXMusicObject();
          localObject2 = k.aeZF;
          kotlin.g.b.s.s(k.nq((Context)paramr.getContext()).q(e.class), "UICProvider.of(context).…sicMvDataUIC::class.java)");
          parame.musicUrl = ((com.tencent.mm.aw.f)localObject3).oOD;
          parame.musicDataUrl = ((com.tencent.mm.aw.f)localObject3).oOB;
          parame.musicLowBandUrl = ((com.tencent.mm.aw.f)localObject3).oOC;
          parame.musicLowBandDataUrl = ((com.tencent.mm.aw.f)localObject3).oOC;
          parame.songAlbumUrl = ((boo)localObject4).ZWS;
          parame.songLyric = ((boo)localObject4).Mcq;
          localWXMediaMessage = new WXMediaMessage();
          localWXMediaMessage.mediaObject = ((WXMediaMessage.IMediaObject)parame);
          localWXMediaMessage.title = ((boo)localObject4).songName;
          localWXMediaMessage.description = ((com.tencent.mm.aw.f)localObject3).oOy;
          localObject2 = ((boo)localObject4).extraInfo;
          parame = (e)localObject2;
          if (localObject2 == null) {
            parame = "";
          }
          localWXMediaMessage.messageExt = parame;
          localObject2 = null;
          if (!Util.isNullOrNil((String)localObject1)) {
            break label2330;
          }
        }
        for (parame = m.H((com.tencent.mm.aw.f)localObject3);; parame = (e)localObject1)
        {
          localObject1 = localObject2;
          if (parame != null)
          {
            localObject1 = localObject2;
            if (y.ZC(parame))
            {
              paramInt2 = (int)((Activity)localObject5).getResources().getDimension(b.c.LargerIconSize);
              localObject1 = BitmapUtil.getBitmapNative(parame, paramInt2, paramInt2);
            }
          }
          if (localObject1 != null) {}
          for (localWXMediaMessage.thumbData = Util.bmpToByteArray((Bitmap)localObject1, true);; localWXMediaMessage.thumbData = Util.bmpToByteArray(BitmapUtil.getBitmapNative(paramInt2), true))
          {
            parame = new Intent();
            localObject1 = new Bundle();
            localObject2 = new SendMessageToWX.Req();
            ((SendMessageToWX.Req)localObject2).message = localWXMediaMessage;
            ((SendMessageToWX.Req)localObject2).toBundle((Bundle)localObject1);
            parame.putExtra("Ksnsupload_timeline", (Bundle)localObject1);
            parame.putExtra("Ksnsupload_musicid", ((com.tencent.mm.aw.f)localObject3).oOv);
            if (com.tencent.mm.pluginsdk.model.app.h.bpJ(m.I((com.tencent.mm.aw.f)localObject3))) {
              parame.putExtra("Ksnsupload_appid", ((boo)localObject4).ZWQ);
            }
            parame.putExtra("Ksnsupload_appname", m.J((com.tencent.mm.aw.f)localObject3));
            localObject1 = ad.Jo("music_player");
            ad.bCb().M((String)localObject1, true).q("prePublishId", "music_player");
            parame.putExtra("reportSessionId", (String)localObject1);
            if (paramMenuItem != null)
            {
              localObject1 = new com.tencent.mm.modelsns.j();
              ((com.tencent.mm.modelsns.j)localObject1).oUg = paramMenuItem;
              parame.putExtra("Ksnsupload_music_share_object_xml", cq.a(((com.tencent.mm.modelsns.j)localObject1).oUg));
            }
            parame.putExtra("Ksnsupload_type", 25);
            parame.putExtra("need_result", true);
            parame.putExtra("Ksnsupload_source", 1);
            paramMenuItem = com.tencent.mm.plugin.music.model.c.LLZ;
            com.tencent.mm.plugin.music.model.c.zK(true);
            com.tencent.mm.br.c.a((MMActivity)localObject5, ".plugin.sns.ui.SnsUploadUI", parame, 2, new r..ExternalSyntheticLambda6(paramr, paramf, (boo)localObject4, paramInt1));
            AppMethodBeat.o(288011);
            return;
            parame = parame.nickname;
            break;
            localObject2 = parame.ZWX;
            parame = (e)localObject2;
            if (localObject2 != null) {
              break label1276;
            }
            parame = "";
            break label1276;
            parame = "";
            break label1304;
            paramInt2 = b.d.music_mv_cover_empty_lightmode;
            if (aw.isDarkMode()) {
              paramInt2 = b.d.music_mv_cover_empty_darkmode;
            }
          }
          paramr.MgR = paramf;
          parame = null;
          paramMenuItem = com.tencent.mm.plugin.mv.model.f.LXf;
          localObject1 = f.a.b(paramf);
          if (localObject1 != null)
          {
            paramMenuItem = new dtj();
            paramMenuItem.YqN = com.tencent.mm.ae.d.hF(((FinderObject)localObject1).id);
            paramMenuItem.YqO = ((FinderObject)localObject1).objectNonceId;
            parame = ((FinderObject)localObject1).objectDesc;
            if (parame != null)
            {
              parame = parame.media;
              if (parame != null)
              {
                parame = (FinderMedia)kotlin.a.p.oL((List)parame);
                if (parame != null) {
                  paramMenuItem.YqP = kotlin.g.b.s.X(parame.thumbUrl, parame.thumb_url_token);
                }
              }
            }
            parame = ((FinderObject)localObject1).contact;
            if (parame == null)
            {
              parame = null;
              paramMenuItem.YqQ = parame;
              parame = paramMenuItem;
            }
          }
          else
          {
            if (parame != null) {
              break label2324;
            }
          }
          for (paramMenuItem = new dtj();; paramMenuItem = parame)
          {
            parame = k.aeZF;
            parame = k.d(paramr.getActivity()).q(e.class);
            kotlin.g.b.s.s(parame, "UICProvider.of(activity)…sicMvDataUIC::class.java)");
            localObject2 = ((e)parame).LWI;
            paramMenuItem.singerName = ((boo)localObject2).rDl;
            paramMenuItem.albumName = ((boo)localObject2).albumName;
            paramMenuItem.musicGenre = ((boo)localObject2).ZTA;
            paramMenuItem.issueDate = ((boo)localObject2).ZWU;
            paramMenuItem.identification = ((boo)localObject2).identification;
            paramMenuItem.extraInfo = ((boo)localObject2).extraInfo;
            paramMenuItem.LNC = ((boo)localObject2).duration;
            parame = ((boo)localObject2).ZWW;
            if (parame == null) {
              parame = "";
            }
            for (;;)
            {
              paramMenuItem.musicOperationUrl = parame;
              paramMenuItem.oOZ = ((boo)localObject2).oOZ;
              m.a(com.tencent.mm.plugin.music.logic.j.gnw().gng(), (boo)localObject2, (Activity)paramr.getActivity(), paramMenuItem);
              parame = o.LYk;
              o.a((Context)paramr.getContext(), (boo)localObject2, paramf, 9, "", paramInt1);
              AppMethodBeat.o(288011);
              return;
              parame = parame.nickname;
              break;
              localObject1 = parame.ZWX;
              parame = (e)localObject1;
              if (localObject1 == null) {
                parame = "";
              }
            }
            paramr.a(paramf, false, paramInt1);
            AppMethodBeat.o(288011);
            return;
            parame = parame.LWI;
            paramMenuItem = k.aeZF;
            paramInt2 = ((i)k.nq((Context)paramr.getContext()).q(i.class)).a(parame, new r..ExternalSyntheticLambda2(paramr, parame, paramf, paramInt1));
            if (paramInt2 == 7) {
              break;
            }
            paramMenuItem = o.LYk;
            paramr = (Context)paramr.getActivity();
            if (paramInt1 == 3) {}
            for (paramInt1 = 5;; paramInt1 = 3)
            {
              o.a(paramr, parame, paramf, 2, paramInt2, paramInt1);
              break;
            }
          }
        }
      }
    }
  }
  
  private static final void a(r paramr, com.tencent.mm.plugin.mv.model.f paramf, int paramInt1, e parame, com.tencent.mm.view.recyclerview.j paramj, MenuItem paramMenuItem, int paramInt2)
  {
    AppMethodBeat.i(288057);
    kotlin.g.b.s.u(paramr, "this$0");
    kotlin.g.b.s.u(paramf, "$musicMv");
    kotlin.g.b.s.u(parame, "$dataUIC");
    kotlin.g.b.s.u(paramj, "$holder");
    paramr.MgT = true;
    Object localObject1 = paramr.MgS;
    if (localObject1 != null) {
      ((w)localObject1).sN(System.currentTimeMillis());
    }
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(288057);
      return;
      parame = new g.a((Context)paramr.getContext());
      parame.bDE(paramr.getContext().getString(b.h.music_main_del_my_mv_tip)).aEX(b.h.app_delete).aEY(paramr.getContext().getResources().getColor(b.b.red_text_color)).bDJ(paramr.getContext().getString(b.h.app_cancel)).aEZ(paramr.getContext().getResources().getColor(b.b.normal_text_color));
      parame.c(new r..ExternalSyntheticLambda15(paramr, paramf)).show();
      AppMethodBeat.o(288057);
      return;
      kotlin.g.b.s.u(paramf, "musicMv");
      paramj = new Intent();
      parame = k.aeZF;
      parame = k.nq((Context)paramr.getContext()).q(e.class);
      kotlin.g.b.s.s(parame, "UICProvider.of(context).…sicMvDataUIC::class.java)");
      paramMenuItem = (e)parame;
      localObject1 = new dtf();
      parame = new FinderObject();
      Object localObject2 = paramf.LXj;
      long l;
      Object localObject3;
      Object localObject4;
      if (localObject2 == null)
      {
        l = 0L;
        parame.id = l;
        parame.objectNonceId = paramf.LXk;
        localObject2 = new FinderObjectDesc();
        localObject3 = new bol();
        ((bol)localObject3).LWI = paramMenuItem.LWI;
        localObject4 = new bon();
        ((bon)localObject4).ZWO = 0.0F;
        ((bon)localObject4).ZWP = 0.0F;
        ah localah = ah.aiuX;
        ((bol)localObject3).LXo = ((bon)localObject4);
        if (paramf.LXs != 1) {
          break label611;
        }
        ((bol)localObject3).ZWI = paramf.LXm;
        label384:
        localObject4 = com.tencent.mm.plugin.comm.a.xeG;
        if (!com.tencent.mm.plugin.comm.a.dsS()) {
          break label676;
        }
        ((bol)localObject3).ZWM = 1;
        label401:
        localObject4 = ah.aiuX;
        ((FinderObjectDesc)localObject2).mvInfo = ((bol)localObject3);
        localObject3 = ah.aiuX;
        parame.objectDesc = ((FinderObjectDesc)localObject2);
        localObject2 = ah.aiuX;
        ((dtf)localObject1).aaYK = parame;
        if (paramf.LXs != 1) {
          break label685;
        }
        ((dtf)localObject1).ZJp = paramf.LXr;
        label452:
        ((dtf)localObject1).Mea = paramMenuItem.Mea;
        parame = ((dtf)localObject1).aaYK;
        if (parame != null) {
          break label705;
        }
        parame = null;
        label474:
        ((dtf)localObject1).aaYM = parame;
        ((dtf)localObject1).aaYL = paramr.m(paramf);
        paramj.putExtra("key_track_data", ((dtf)localObject1).toByteArray());
        paramj.putExtra("key_mv_music_duration", paramMenuItem.LWI.duration);
        if (paramInt1 != 3) {
          break label727;
        }
      }
      label676:
      label685:
      label705:
      label727:
      for (paramInt1 = 4;; paramInt1 = 3)
      {
        paramj.putExtra("key_mv_enter_maker_ui_from_scene", paramInt1);
        paramf = com.tencent.mm.plugin.music.model.c.LLZ;
        com.tencent.mm.plugin.music.model.c.zK(true);
        paramf = com.tencent.mm.plugin.finder.utils.a.GfO;
        com.tencent.mm.plugin.finder.utils.a.ae((Context)paramr.getActivity(), paramj);
        paramf = com.tencent.mm.plugin.secdata.ui.a.PlI;
        paramr = (dtk)a.a.a((Context)paramr.getContext(), 7, dtk.class);
        if (paramr != null) {
          paramr.aaYR = 1;
        }
        AppMethodBeat.o(288057);
        return;
        l = ((Long)localObject2).longValue();
        break;
        label611:
        if (paramf.LXs != 4) {
          break label384;
        }
        localObject4 = paramf.LXv;
        if (localObject4 == null) {
          break label384;
        }
        localObject4 = ((FinderObject)localObject4).objectDesc;
        if (localObject4 == null) {
          break label384;
        }
        localObject4 = ((FinderObjectDesc)localObject4).mvInfo;
        if (localObject4 == null) {
          break label384;
        }
        localObject4 = ((bol)localObject4).ZWI;
        if (localObject4 == null) {
          break label384;
        }
        ((bol)localObject3).ZWI = ((LinkedList)localObject4);
        break label384;
        ((bol)localObject3).ZWM = 0;
        break label401;
        if (paramf.LXs != 4) {
          break label452;
        }
        ((dtf)localObject1).ZJp = paramf.LXw;
        break label452;
        parame = parame.objectDesc;
        if (parame == null)
        {
          parame = null;
          break label474;
        }
        parame = parame.mvInfo;
        break label474;
      }
      paramf = paramf.LXj;
      if (paramf != null)
      {
        l = ((Number)paramf).longValue();
        m.bz((Context)paramr.getContext(), com.tencent.mm.ae.d.hF(l));
        AppMethodBeat.o(288057);
        return;
        parame.Flq = true;
        paramr.ad(paramj);
        parame = k.aeZF;
        if (!((e)k.d(paramr.getActivity()).q(e.class)).Flq)
        {
          switch (paramf.LXs)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(288057);
            return;
            paramr = paramj.caK.findViewById(b.e.loading_layout);
            if (paramr != null) {
              paramr.setVisibility(8);
            }
            paramr = paramj.caK.findViewById(b.e.LSV);
            if (paramr == null) {
              break;
            }
            paramr.setVisibility(8);
            AppMethodBeat.o(288057);
            return;
            paramr = paramj.caK.findViewById(b.e.loading_layout);
            if (paramr != null) {
              paramr.setVisibility(0);
            }
            paramr = paramj.caK.findViewById(b.e.LSV);
            if (paramr == null) {
              break;
            }
            paramr.setVisibility(8);
            AppMethodBeat.o(288057);
            return;
            paramr = paramj.caK.findViewById(b.e.loading_layout);
            if (paramr != null) {
              paramr.setVisibility(0);
            }
            paramr = paramj.caK.findViewById(b.e.LSV);
            if (paramr != null) {
              paramr.setVisibility(0);
            }
            paramr = paramj.caK.findViewById(b.e.LSV);
            if (paramr == null) {
              break;
            }
            paramr.setOnClickListener(new r..ExternalSyntheticLambda0(paramf));
            AppMethodBeat.o(288057);
            return;
            paramr = paramj.caK.findViewById(b.e.loading_layout);
            if (paramr != null) {
              paramr.setVisibility(8);
            }
            paramr = paramj.caK.findViewById(b.e.LSV);
            if (paramr == null) {
              break;
            }
            paramr.setVisibility(8);
          }
        }
        paramr = paramj.caK.findViewById(b.e.loading_layout);
        if (paramr != null) {
          paramr.setVisibility(8);
        }
        paramr = paramj.caK.findViewById(b.e.LSV);
        if (paramr != null) {
          paramr.setVisibility(8);
        }
        AppMethodBeat.o(288057);
        return;
        parame = k.aeZF;
        ((f)k.nq((Context)paramr.getContext()).q(f.class)).f(paramf);
      }
    }
  }
  
  private static final void a(r paramr, com.tencent.mm.plugin.mv.model.f paramf, boo paramboo, int paramInt1, int paramInt2, int paramInt3, Intent paramIntent)
  {
    AppMethodBeat.i(288137);
    kotlin.g.b.s.u(paramr, "this$0");
    kotlin.g.b.s.u(paramf, "$musicMv");
    kotlin.g.b.s.u(paramboo, "$songInfo");
    if ((2 == paramInt2) && (paramInt3 == -1))
    {
      Toast.makeText((Context)paramr.getContext(), (CharSequence)paramr.getContext().getResources().getString(b.h.share_ok), 0).show();
      paramIntent = com.tencent.mm.plugin.mv.model.f.LXf;
      FinderObject localFinderObject = f.a.b(paramf);
      if (localFinderObject != null)
      {
        Object localObject = new LinkedList();
        String str2 = com.tencent.mm.ae.d.hF(localFinderObject.id);
        String str1 = localFinderObject.objectNonceId;
        paramIntent = str1;
        if (str1 == null) {
          paramIntent = "";
        }
        ((LinkedList)localObject).add(new Pair(str2, paramIntent));
        ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).shareStatsReport((List)localObject, false);
        localObject = new StringBuilder("share mv to sns success ").append(com.tencent.mm.ae.d.hF(localFinderObject.id)).append(' ');
        str1 = localFinderObject.objectNonceId;
        paramIntent = str1;
        if (str1 == null) {
          paramIntent = "";
        }
        Log.i("MicroMsg.Mv.MusicMvShareUIC", paramIntent);
        paramIntent = o.LYk;
        o.a((Context)paramr.getContext(), paramboo, paramf, 1, "", paramInt1);
      }
    }
    AppMethodBeat.o(288137);
  }
  
  private static final void a(r paramr, com.tencent.mm.plugin.mv.model.f paramf, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(288021);
    kotlin.g.b.s.u(paramr, "this$0");
    kotlin.g.b.s.u(paramf, "$musicMv");
    long l;
    if (paramBoolean)
    {
      paramString = k.aeZF;
      paramr = (i)k.d(paramr.getActivity()).q(i.class);
      kotlin.g.b.s.u(paramf, "musicMv");
      Log.i(paramr.TAG, "deleteMv " + paramf.LXj + ' ' + paramf.LXk + ' ' + paramf.LXs);
      if (paramf.LXs == 1)
      {
        paramString = paramf.LXj;
        paramr = paramf.LXk;
        if ((paramString != null) && (paramr != null))
        {
          l = ((Number)paramString).longValue();
          paramf = com.tencent.mm.kernel.h.aZW();
          paramString = z.bAW();
          kotlin.g.b.s.s(paramString, "getMyFinderUsername()");
          paramf.a((com.tencent.mm.am.p)new bt(paramString, l, paramr, false), 0);
          AppMethodBeat.o(288021);
        }
      }
      else if (paramf.LXs == 4)
      {
        paramr = paramf.LXv;
        if (paramr != null) {
          break label271;
        }
        paramr = null;
        paramf = paramf.LXv;
        if (paramf != null) {
          break label282;
        }
      }
    }
    label271:
    label282:
    for (paramf = null;; paramf = paramf.objectNonceId)
    {
      if ((paramr != null) && (paramf != null))
      {
        l = ((Number)paramr).longValue();
        paramr = com.tencent.mm.kernel.h.aZW();
        paramString = z.bAW();
        kotlin.g.b.s.s(paramString, "getMyFinderUsername()");
        paramr.a((com.tencent.mm.am.p)new bt(paramString, l, paramf, false), 0);
      }
      AppMethodBeat.o(288021);
      return;
      paramr = Long.valueOf(paramr.id);
      break;
    }
  }
  
  private static final void a(r paramr, boo paramboo, com.tencent.mm.plugin.mv.model.f paramf, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(287957);
    kotlin.g.b.s.u(paramr, "this$0");
    kotlin.g.b.s.u(paramboo, "$songInfo");
    kotlin.g.b.s.u(paramf, "$musicMv");
    Object localObject;
    int i;
    if (paramBoolean1)
    {
      localObject = o.LYk;
      localObject = (Context)paramr.getActivity();
      if (paramInt == 3)
      {
        i = 5;
        o.a((Context)localObject, paramboo, paramf, 2, 1, i);
      }
    }
    else if (paramBoolean2)
    {
      localObject = o.LYk;
      paramr = (Context)paramr.getActivity();
      if (paramInt != 3) {
        break label112;
      }
    }
    label112:
    for (paramInt = 5;; paramInt = 3)
    {
      o.a(paramr, paramboo, paramf, 2, 3, paramInt);
      AppMethodBeat.o(287957);
      return;
      i = 3;
      break;
    }
  }
  
  private static final void a(r paramr, String paramString1, String paramString2, ah.f paramf, com.tencent.mm.plugin.mv.model.f paramf1, boo paramboo, boolean paramBoolean, String paramString3, int paramInt)
  {
    AppMethodBeat.i(288113);
    kotlin.g.b.s.u(paramr, "this$0");
    kotlin.g.b.s.u(paramString1, "$username");
    kotlin.g.b.s.u(paramf, "$coverLocalPath");
    kotlin.g.b.s.u(paramf1, "$musicMv");
    kotlin.g.b.s.u(paramboo, "$songInfo");
    if (!paramBoolean)
    {
      localObject = paramr.MgS;
      if (localObject != null) {
        ((w)localObject).b(System.currentTimeMillis(), 1, "2", null);
      }
    }
    if ((!paramBoolean) || (Util.isNullOrNil(paramString1)))
    {
      AppMethodBeat.o(288113);
      return;
    }
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("Retr_Msg_Type", 2);
    ((Intent)localObject).putExtra("Retr_Msg_content", paramString2);
    ((Intent)localObject).putExtra("Multi_Retr", true);
    ((Intent)localObject).putExtra("Retr_go_to_chattingUI", false);
    ((Intent)localObject).putExtra("Retr_show_success_tips", true);
    ((Intent)localObject).putExtra("Retr_Msg_thumb_path", (String)paramf.aqH);
    ((Intent)localObject).putExtra("custom_send_text", paramString3);
    ((Intent)localObject).putExtra("Retr_MsgQuickShare", true);
    ((Intent)localObject).putExtra("Select_Conv_User", paramString1);
    paramString2 = com.tencent.mm.plugin.music.model.c.LLZ;
    com.tencent.mm.plugin.music.model.c.zK(true);
    com.tencent.mm.br.c.a((MMActivity)paramr.getContext(), ".ui.transmit.MsgRetransmitUI", (Intent)localObject, 1, new r..ExternalSyntheticLambda5(paramf1, paramr, paramString1, paramboo));
    AppMethodBeat.o(288113);
  }
  
  private static final void a(r paramr, boolean paramBoolean, ah.a parama, BitmapDrawable paramBitmapDrawable, String paramString, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(287932);
    kotlin.g.b.s.u(paramr, "this$0");
    kotlin.g.b.s.u(parama, "$isShowAppName");
    kotlin.g.b.s.u(paramString, "$goAppTip");
    CharSequence localCharSequence = (CharSequence)paramr.getContext().getString(b.h.app_share_to_weixin);
    int i = b.g.finder_full_share;
    int j = paramr.getContext().getResources().getColor(b.b.Brand);
    boolean bool;
    if (!paramBoolean)
    {
      bool = true;
      params.a(101, localCharSequence, i, j, bool);
      localCharSequence = (CharSequence)paramr.getContext().getString(b.h.music_share_timeline);
      i = b.g.bottomsheet_icon_moment;
      if (paramBoolean) {
        break label268;
      }
      bool = true;
      label113:
      params.a(102, localCharSequence, i, 0, bool);
      localCharSequence = (CharSequence)paramr.getContext().getString(b.h.music_favorite);
      i = b.g.bottomsheet_icon_fav;
      if (paramBoolean) {
        break label274;
      }
      bool = true;
      label155:
      params.a(103, localCharSequence, i, 0, bool);
      localCharSequence = (CharSequence)paramr.getContext().getString(b.h.music_status_title);
      i = b.g.state_icon_main;
      j = paramr.getContext().getResources().getColor(b.b.Blue);
      if (paramBoolean) {
        break label280;
      }
    }
    label268:
    label274:
    label280:
    for (paramBoolean = true;; paramBoolean = false)
    {
      params.a(104, localCharSequence, i, j, paramBoolean);
      if ((parama.aiwY) && (paramBitmapDrawable != null)) {
        params.a(105, (CharSequence)paramString, (Drawable)paramBitmapDrawable, 0);
      }
      AppMethodBeat.o(287932);
      return;
      bool = false;
      break;
      bool = false;
      break label113;
      bool = false;
      break label155;
    }
  }
  
  private static final void a(r paramr, boolean paramBoolean1, boolean paramBoolean2, com.tencent.mm.plugin.mv.model.f paramf, boolean paramBoolean3, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(287949);
    kotlin.g.b.s.u(paramr, "this$0");
    kotlin.g.b.s.u(paramf, "$musicMv");
    Object localObject = (CharSequence)paramr.getContext().getString(b.h.music_mv_maker_title);
    int i = b.g.icons_outlined_mv_making_share;
    int j = paramr.getContext().getResources().getColor(b.b.black_color);
    if (!paramBoolean1) {}
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      params.a(201, (CharSequence)localObject, i, j, paramBoolean1);
      if (!paramBoolean2) {
        break;
      }
      localObject = com.tencent.mm.plugin.mv.model.f.LXf;
      if (f.a.c(paramf)) {
        params.a(203, (CharSequence)paramr.getContext().getString(b.h.music_main_mv_expose), b.g.icons_outlined_report_problem, paramr.getContext().getResources().getColor(b.b.black_color), false);
      }
      params.a(204, (CharSequence)paramr.getContext().getString(b.h.music_clear_screen), b.g.finder_icons_screen_clear, paramr.getContext().getResources().getColor(b.b.black_color), false);
      paramf = com.tencent.mm.util.d.agsY;
      if (com.tencent.mm.util.d.jJv()) {
        params.a(205, (CharSequence)"调试", b.g.icons_outlined_report_problem, paramr.getContext().getResources().getColor(b.b.black_color), false);
      }
      AppMethodBeat.o(287949);
      return;
    }
    paramf = (CharSequence)paramr.getContext().getString(b.h.finder_edit_menu_delete);
    i = b.g.icons_outlined_delete;
    j = paramr.getContext().getResources().getColor(b.b.black_color);
    if (!paramBoolean3) {}
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      params.a(202, paramf, i, j, paramBoolean1);
      break;
    }
  }
  
  private static final void a(q paramq, r paramr, final com.tencent.mm.plugin.mv.model.f paramf, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(287918);
    kotlin.g.b.s.u(paramq, "$quickMenuHelper");
    kotlin.g.b.s.u(paramr, "this$0");
    kotlin.g.b.s.u(paramf, "$musicMv");
    if (paramMenuItem == null)
    {
      paramq = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.MMMenuItem");
      AppMethodBeat.o(287918);
      throw paramq;
    }
    paramq.a((t)paramMenuItem, (kotlin.g.a.b)new b(paramr, paramf));
    AppMethodBeat.o(287918);
  }
  
  private static final void a(q paramq, r paramr, ah.f paramf, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(287894);
    kotlin.g.b.s.u(paramq, "$quickMenuHelper");
    kotlin.g.b.s.u(paramr, "this$0");
    kotlin.g.b.s.u(paramf, "$bottomSheet");
    paramr = (Context)paramr.getContext();
    kotlin.g.b.s.s(params, "menu");
    paramq.a(paramr, params, (com.tencent.mm.ui.widget.a.f)paramf.aqH);
    AppMethodBeat.o(287894);
  }
  
  private static final void a(q paramq, ah.f paramf, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(287909);
    kotlin.g.b.s.u(paramq, "$quickMenuHelper");
    kotlin.g.b.s.u(paramf, "$bottomSheet");
    paramf = (com.tencent.mm.ui.widget.a.f)paramf.aqH;
    if (paramMenuItem == null)
    {
      paramq = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.MMMenuItem");
      AppMethodBeat.o(287909);
      throw paramq;
    }
    paramq.a(paramf, (t)paramMenuItem);
    AppMethodBeat.o(287909);
  }
  
  private static final void a(ah.f paramf, String paramString, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(287881);
    kotlin.g.b.s.u(paramf, "$bitmap");
    kotlin.g.b.s.u(paramString, "$coverPath");
    paramf.aqH = BitmapUtil.getBitmapNative(paramString);
    AppMethodBeat.o(287881);
  }
  
  private final void ad(com.tencent.mm.view.recyclerview.j paramj)
  {
    AppMethodBeat.i(287784);
    Set localSet = ar.setOf(new Integer[] { Integer.valueOf(b.e.LUM), Integer.valueOf(b.e.LRY), Integer.valueOf(b.e.LSB), Integer.valueOf(b.e.footer_view) });
    k localk = k.aeZF;
    if (((e)k.d(getActivity()).q(e.class)).Flq)
    {
      this.MaZ.ix(paramj.caK).A(localSet);
      this.MaZ.Mhg.clear();
      AppMethodBeat.o(287784);
      return;
    }
    this.MaZ.ix(paramj.caK).B(localSet);
    this.MaZ.Mhg.clear();
    AppMethodBeat.o(287784);
  }
  
  private static final void grg() {}
  
  public static SpannableString ji(Context paramContext)
  {
    AppMethodBeat.i(287815);
    kotlin.g.b.s.u(paramContext, "context");
    SpannableString localSpannableString = new SpannableString((CharSequence)paramContext.getString(b.h.menu_set_status));
    int i = kotlin.n.n.a((CharSequence)localSpannableString, "{music}", 0, false, 6);
    int j = paramContext.getResources().getDrawable(b.g.state_icon_main).getIntrinsicWidth();
    int k = com.tencent.mm.cd.a.br(paramContext, b.c.Edge_2_5_A);
    float f = 1.0F * k / j;
    paramContext = com.tencent.mm.svg.a.a.a(paramContext.getResources(), b.g.state_icon_main, f);
    paramContext.setColorFilter((ColorFilter)new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
    paramContext.setBounds(0, 0, k, k);
    localSpannableString.setSpan(new com.tencent.mm.plugin.mv.ui.view.a(paramContext), i, "{music}".length() + i, 17);
    AppMethodBeat.o(287815);
    return localSpannableString;
  }
  
  private final String m(com.tencent.mm.plugin.mv.model.f paramf)
  {
    AppMethodBeat.i(287798);
    Object localObject = com.tencent.mm.plugin.mv.model.f.LXf;
    int i;
    if (!f.a.c(paramf))
    {
      localObject = k.aeZF;
      localObject = k.d(getActivity()).q(e.class);
      kotlin.g.b.s.s(localObject, "UICProvider.of(activity)…sicMvDataUIC::class.java)");
      localObject = ((e)localObject).LWI.ZWS;
      if (localObject != null)
      {
        if (((CharSequence)localObject).length() > 0)
        {
          i = 1;
          if (i == 0) {
            break label109;
          }
        }
        for (;;)
        {
          if (localObject == null) {
            break label114;
          }
          com.tencent.mm.plugin.mv.ui.a locala = com.tencent.mm.plugin.mv.ui.a.Maz;
          localObject = com.tencent.mm.plugin.mv.ui.a.aPB((String)localObject);
          if (!y.ZC((String)localObject)) {
            break label114;
          }
          AppMethodBeat.o(287798);
          return localObject;
          i = 0;
          break;
          label109:
          localObject = null;
        }
      }
    }
    label114:
    localObject = paramf.LXi;
    if (localObject != null)
    {
      if (((CharSequence)localObject).length() > 0)
      {
        i = 1;
        if (i == 0) {
          break label165;
        }
      }
      for (;;)
      {
        if ((localObject == null) || (!y.ZC((String)localObject))) {
          break label170;
        }
        AppMethodBeat.o(287798);
        return localObject;
        i = 0;
        break;
        label165:
        localObject = null;
      }
    }
    label170:
    paramf = paramf.coverUrl;
    if (paramf != null)
    {
      if (((CharSequence)paramf).length() > 0)
      {
        i = 1;
        if (i == 0) {
          break label230;
        }
      }
      for (;;)
      {
        if (paramf == null) {
          break label235;
        }
        localObject = com.tencent.mm.plugin.mv.ui.a.Maz;
        paramf = com.tencent.mm.plugin.mv.ui.a.aPB(paramf);
        if (!y.ZC(paramf)) {
          break label235;
        }
        AppMethodBeat.o(287798);
        return paramf;
        i = 0;
        break;
        label230:
        paramf = null;
      }
    }
    label235:
    paramf = k.aeZF;
    paramf = k.d(getActivity()).q(e.class);
    kotlin.g.b.s.s(paramf, "UICProvider.of(activity)…sicMvDataUIC::class.java)");
    localObject = (e)paramf;
    paramf = ((e)localObject).MdY.thumbPath;
    if (paramf != null)
    {
      if (((CharSequence)paramf).length() > 0)
      {
        i = 1;
        if (i == 0) {
          break label319;
        }
      }
      for (;;)
      {
        if ((paramf == null) || (!y.ZC(paramf))) {
          break label324;
        }
        AppMethodBeat.o(287798);
        return paramf;
        i = 0;
        break;
        label319:
        paramf = null;
      }
    }
    label324:
    paramf = ((e)localObject).LWI.ZWS;
    if (paramf != null)
    {
      if (((CharSequence)paramf).length() > 0)
      {
        i = 1;
        if (i == 0) {
          break label387;
        }
      }
      for (;;)
      {
        if (paramf == null) {
          break label392;
        }
        localObject = com.tencent.mm.plugin.mv.ui.a.Maz;
        paramf = com.tencent.mm.plugin.mv.ui.a.aPB(paramf);
        if (!y.ZC(paramf)) {
          break label392;
        }
        AppMethodBeat.o(287798);
        return paramf;
        i = 0;
        break;
        label387:
        paramf = null;
      }
    }
    label392:
    AppMethodBeat.o(287798);
    return null;
  }
  
  public final void a(com.tencent.mm.view.recyclerview.j paramj, com.tencent.mm.plugin.mv.model.f paramf, int paramInt)
  {
    AppMethodBeat.i(288297);
    kotlin.g.b.s.u(paramj, "holder");
    kotlin.g.b.s.u(paramf, "musicMv");
    Object localObject1 = k.aeZF;
    localObject1 = k.nq((Context)getContext()).q(e.class);
    kotlin.g.b.s.s(localObject1, "UICProvider.of(context).…sicMvDataUIC::class.java)");
    e locale = (e)localObject1;
    localObject1 = paramf.LXp;
    boolean bool3;
    label86:
    boolean bool4;
    boolean bool2;
    boolean bool1;
    label170:
    ah.f localf;
    label275:
    Object localObject2;
    label299:
    ah.a locala;
    int i;
    label338:
    label347:
    label375:
    Object localObject3;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (kotlin.g.b.s.p(localObject1, z.bAW())) {
        break label832;
      }
      bool3 = true;
      localObject1 = com.tencent.mm.plugin.mv.ui.a.Maz;
      bool4 = com.tencent.mm.plugin.mv.ui.a.e(paramf);
      kotlin.g.b.s.u(paramf, "musicMv");
      if ((locale.MdX & 1L) <= 0L) {
        break label937;
      }
      bool2 = ((cn)com.tencent.mm.kernel.h.az(cn.class)).showFinderEntry();
      if ((!((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu()) || (((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).eZD() != 2)) {
        break label838;
      }
      bool1 = true;
      Log.i(locale.TAG, "[canCreateMv] show:%s, isTeenModeAndNothing:%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if ((bool2) && (!bool1)) {
        break label844;
      }
      bool1 = false;
      this.MgS = new w((Context)getContext(), System.currentTimeMillis());
      this.MgT = false;
      localf = new ah.f();
      if (!bool4) {
        break label943;
      }
      localf.aqH = new com.tencent.mm.ui.widget.a.f((Context)getActivity(), 0, false);
      localObject2 = (Context)getContext();
      localObject1 = locale.LWI;
      if (localObject1 != null) {
        break label1008;
      }
      localObject1 = null;
      localObject1 = com.tencent.mm.pluginsdk.model.app.h.x((Context)localObject2, (String)localObject1);
      locala = new ah.a();
      if (localObject1 == null) {
        break label1024;
      }
      if (((CharSequence)localObject1).length() <= 0) {
        break label1018;
      }
      i = 1;
      if (i != 1) {
        break label1024;
      }
      bool2 = true;
      locala.aiwY = bool2;
      if (localObject1 == null) {
        break label1036;
      }
      if (((CharSequence)localObject1).length() <= 0) {
        break label1030;
      }
      i = 1;
      if (i != 1) {
        break label1036;
      }
      i = 1;
      label384:
      if (i == 0) {
        break label1042;
      }
      localObject1 = getContext().getString(b.h.go_to_app_tips, new Object[] { localObject1 });
      label410:
      kotlin.g.b.s.s(localObject1, "if (appName?.isNotEmpty(…pp_tips, appName) else \"\"");
      localObject2 = com.tencent.mm.plugin.mv.ui.a.Maz;
      localObject2 = locale.LWI;
      if (localObject2 != null) {
        break label1050;
      }
      localObject2 = null;
      label438:
      localObject3 = com.tencent.mm.plugin.mv.ui.a.aPD((String)localObject2);
      localObject2 = new ah.f();
      if (!Util.isNullOrNil((String)localObject3))
      {
        if (!kotlin.n.n.U((String)localObject3, "file://", false)) {
          break label1060;
        }
        ((ah.f)localObject2).aqH = BitmapUtil.getBitmapNative((String)localObject3);
      }
      label484:
      if (((ah.f)localObject2).aqH == null) {
        break label1160;
      }
      localObject3 = ((ah.f)localObject2).aqH;
      kotlin.g.b.s.checkNotNull(localObject3);
      if (((Bitmap)localObject3).isRecycled()) {
        break label1160;
      }
      localObject2 = BitmapUtil.getRoundedCornerBitmap((Bitmap)((ah.f)localObject2).aqH, false, com.tencent.mm.cd.a.fromDPToPix((Context)getContext(), 4));
      localObject2 = new BitmapDrawable(getResources(), (Bitmap)localObject2);
      label556:
      if (!locala.aiwY) {
        break label1172;
      }
      if (localObject2 == null) {
        break label1166;
      }
      bool2 = true;
    }
    label937:
    label943:
    for (;;)
    {
      locala.aiwY = bool2;
      localObject3 = ((q)com.tencent.mm.kernel.h.ax(q.class)).iGI();
      ((com.tencent.mm.ui.widget.a.f)localf.aqH).GAx = new r..ExternalSyntheticLambda9((q)localObject3, this, localf);
      ((com.tencent.mm.ui.widget.a.f)localf.aqH).ageo = new r..ExternalSyntheticLambda10((q)localObject3, localf);
      ((com.tencent.mm.ui.widget.a.f)localf.aqH).agen = new r..ExternalSyntheticLambda13((q)localObject3, this, paramf);
      ((com.tencent.mm.ui.widget.a.f)localf.aqH).getWindow().getDecorView().addOnAttachStateChangeListener((View.OnAttachStateChangeListener)new c(this));
      ((com.tencent.mm.ui.widget.a.f)localf.aqH).Vtg = new r..ExternalSyntheticLambda7(this, bool4, locala, (BitmapDrawable)localObject2, (String)localObject1);
      ((com.tencent.mm.ui.widget.a.f)localf.aqH).GAz = new r..ExternalSyntheticLambda8(this, bool1, bool3, paramf, bool4);
      ((com.tencent.mm.ui.widget.a.f)localf.aqH).GAC = new r..ExternalSyntheticLambda11(this, paramf, paramInt, locale);
      ((com.tencent.mm.ui.widget.a.f)localf.aqH).agem = new r..ExternalSyntheticLambda12(this, paramf, paramInt, locale, paramj);
      ((com.tencent.mm.ui.widget.a.f)localf.aqH).aeLi = r..ExternalSyntheticLambda14.INSTANCE;
      ((com.tencent.mm.ui.widget.a.f)localf.aqH).dDn();
      AppMethodBeat.o(288297);
      return;
      localObject1 = ((FinderContact)localObject1).username;
      break;
      label832:
      bool3 = false;
      break label86;
      label838:
      bool1 = false;
      break label170;
      label844:
      switch (paramf.LXs)
      {
      case 2: 
      case 3: 
      default: 
        bool1 = false;
        break;
      case 1: 
        if (paramf.LXm.size() > 0)
        {
          bool1 = true;
          break;
        }
        bool1 = false;
        break;
      case 4: 
        if ((paramf.LXv != null) && (paramf.LXw.size() > 0))
        {
          bool1 = true;
          break;
        }
        bool1 = false;
        break;
        bool1 = false;
        break;
        localf.aqH = new com.tencent.mm.ui.widget.a.f((Context)getActivity(), 0, true);
        ((com.tencent.mm.ui.widget.a.f)localf.aqH).h((CharSequence)getActivity().getResources().getString(b.h.music_mv_posting_share_title), 17, com.tencent.mm.cd.a.fromDPToPix((Context)getActivity(), 12));
        break label275;
        label1008:
        localObject1 = ((boo)localObject1).ZWQ;
        break label299;
        label1018:
        i = 0;
        break label338;
        bool2 = false;
        break label347;
        i = 0;
        break label375;
        i = 0;
        break label384;
        localObject1 = "";
        break label410;
        localObject2 = ((boo)localObject2).ZWQ;
        break label438;
        Object localObject4 = com.tencent.mm.plugin.mv.ui.a.Maz;
        localObject4 = com.tencent.mm.plugin.mv.ui.a.aPB((String)localObject3);
        Object localObject5 = com.tencent.mm.plugin.mv.ui.a.c.MaY;
        Log.i(com.tencent.mm.plugin.mv.ui.a.c.access$getTAG$cp(), kotlin.g.b.s.X("initCover save Path:", localObject4));
        localObject5 = new c.a();
        ((c.a)localObject5).oKp = true;
        ((c.a)localObject5).oKn = true;
        ((c.a)localObject5).fullPath = ((String)localObject4);
        ((c.a)localObject5).oKP = new Object[] { localObject3 };
        com.tencent.mm.modelimage.r.bKe().a((String)localObject3, ((c.a)localObject5).bKx(), new r..ExternalSyntheticLambda1((ah.f)localObject2, (String)localObject4));
        break label484;
        localObject2 = null;
        break label556;
        bool2 = false;
        continue;
        bool2 = false;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "username", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<String, ah>
  {
    b(r paramr, com.tencent.mm.plugin.mv.model.f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/uic/MusicMvShareUIC$clickOptionsMenu$5", "Landroid/view/View$OnAttachStateChangeListener;", "onViewAttachedToWindow", "", "view", "Landroid/view/View;", "onViewDetachedFromWindow", "v", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements View.OnAttachStateChangeListener
  {
    c(r paramr) {}
    
    public final void onViewAttachedToWindow(View paramView)
    {
      AppMethodBeat.i(287954);
      kotlin.g.b.s.u(paramView, "view");
      AppMethodBeat.o(287954);
    }
    
    public final void onViewDetachedFromWindow(View paramView)
    {
      AppMethodBeat.i(287963);
      kotlin.g.b.s.u(paramView, "v");
      if (!r.a(this.MgU))
      {
        paramView = r.b(this.MgU);
        if (paramView != null) {
          paramView.b(System.currentTimeMillis(), 1, "2", null);
        }
      }
      AppMethodBeat.o(287963);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.r
 * JD-Core Version:    0.7.0.1
 */