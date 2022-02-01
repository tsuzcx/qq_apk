package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.j;
import com.tencent.mm.modelsns.l;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicVideoObject;
import com.tencent.mm.plugin.comm.b;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.k.k;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.bd;
import com.tencent.mm.plugin.sns.model.be;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.cst;
import com.tencent.mm.protocal.protobuf.dbr;
import com.tencent.mm.protocal.protobuf.elm;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.MMRoundCornerImageView;
import com.tencent.mm.ui.widget.RoundCornerRelativeLayout;
import com.tencent.xweb.util.d;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class al
  implements af
{
  private int KCP;
  private l KCV = null;
  private String KCW = "";
  private boolean KEH = false;
  private boolean KEI = false;
  private WXMediaMessage KEJ = null;
  private TextView KGe;
  private TextView KGf;
  private j KGg;
  private String KGh;
  private Bitmap KGi;
  private int Kcp = 1;
  private String appName = "";
  private String appid = "";
  private View bvK;
  private boolean fGh = false;
  private MMActivity iXq;
  private String songLyric;
  
  public al(MMActivity paramMMActivity)
  {
    this.iXq = paramMMActivity;
  }
  
  public final boolean a(int paramInt1, int paramInt2, org.b.d.i parami, String paramString1, List<String> paramList1, cst paramcst, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(197448);
    aj.fOE();
    WXMediaMessage localWXMediaMessage = this.KEJ;
    paramLinkedList = this.appid;
    paramString2 = this.appName;
    String str1 = this.KGh;
    String str2 = this.songLyric;
    Log.d("MicroMsg.UploadManager", "appmsg.description " + localWXMediaMessage.description);
    Log.d("MicroMsg.UploadManager", "appmsg.title " + localWXMediaMessage.title);
    WXMediaMessage.IMediaObject localIMediaObject = localWXMediaMessage.mediaObject;
    be localbe = new be(42);
    localbe.bay(Util.nullAs(paramLinkedList, "")).baz(Util.nullAs(paramString2, ""));
    localbe.agb(5);
    Log.d("MicroMsg.UploadManager", "TimeLineType 42");
    if (!Util.isNullOrNil(paramString1)) {
      localbe.bas(paramString1);
    }
    localbe.bax(Util.nullAs(localWXMediaMessage.title, "")).bav(Util.nullAs(localWXMediaMessage.description, ""));
    paramLinkedList = "";
    Object localObject = "";
    paramString2 = "";
    if ((localIMediaObject instanceof WXMusicObject))
    {
      paramString2 = (WXMusicObject)localIMediaObject;
      if (!Util.isNullOrNil(paramString2.musicUrl))
      {
        paramString1 = paramString2.musicUrl;
        paramLinkedList = Util.nullAs(paramString1, "");
        if (Util.isNullOrNil(paramString2.musicDataUrl)) {
          break label383;
        }
        paramString1 = paramString2.musicDataUrl;
        label261:
        localObject = Util.nullAs(paramString1, "");
        if (Util.isNullOrNil(paramString2.musicLowBandDataUrl)) {
          break label393;
        }
        paramString1 = paramString2.musicLowBandDataUrl;
        label288:
        paramString2 = Util.nullAs(paramString1, "");
        label297:
        localbe.bax("").bav("");
        paramInt2 = bd.wN(localIMediaObject.type());
        if (paramInt2 != -1) {
          break label474;
        }
        Log.d("MicroMsg.UploadManager", "mediaType is invalid");
        paramString1 = null;
      }
    }
    for (;;)
    {
      if (paramString1 != null) {
        break label528;
      }
      Log.e("MicroMsg.MusicMvWidget", "packHelper == null, %s, %s", new Object[] { this.appid, this.appName });
      AppMethodBeat.o(197448);
      return false;
      paramString1 = paramString2.musicLowBandUrl;
      break;
      label383:
      paramString1 = paramString2.musicUrl;
      break label261;
      label393:
      paramString1 = paramString2.musicLowBandUrl;
      break label288;
      if (!(localIMediaObject instanceof WXMusicVideoObject)) {
        break label297;
      }
      paramString1 = (WXMusicVideoObject)localIMediaObject;
      paramLinkedList = Util.nullAs(paramString1.musicUrl, "");
      if (!Util.isNullOrNil(paramString1.musicDataUrl)) {}
      for (paramString1 = paramString1.musicDataUrl;; paramString1 = paramString1.musicUrl)
      {
        localObject = Util.nullAs(paramString1, "");
        paramString2 = "";
        break;
      }
      label474:
      paramString1 = localbe;
      if (!localbe.a(localWXMediaMessage.thumbData, paramLinkedList, paramString2, (String)localObject, paramInt2, Util.nullAs(localWXMediaMessage.title, ""), Util.nullAs(localWXMediaMessage.description, ""), str1, str2)) {
        paramString1 = null;
      }
    }
    label528:
    if (this.KGg != null)
    {
      paramLinkedList = this.KGg;
      if (paramLinkedList != null) {
        paramString1.Kck.ContentObj.lVY = paramLinkedList.mbm;
      }
    }
    paramPInt.value = paramString1.aOl;
    if (paramInt3 > com.tencent.mm.plugin.sns.c.a.JPj) {
      paramString1.afW(4);
    }
    paramString1.agb(this.KCP);
    if (this.KEH) {
      paramString1.agb(5);
    }
    paramLinkedList = new LinkedList();
    if (paramList1 != null)
    {
      new LinkedList();
      paramPInt = com.tencent.mm.pluginsdk.j.a.hhW();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramString2 = (String)paramList1.next();
        if (!paramPInt.contains(paramString2))
        {
          localObject = new elm();
          ((elm)localObject).UserName = paramString2;
          paramLinkedList.add(localObject);
        }
      }
    }
    paramString1.bL(paramLinkedList);
    if (parami != null) {
      paramString1.kG(parami.token, parami.TEk);
    }
    paramString1.a(paramcst);
    if (paramBoolean) {
      paramString1.agc(1);
    }
    for (;;)
    {
      paramString1.hA(paramList2).afZ(paramInt1);
      paramString1.i(null, null, null, paramInt4, paramInt5);
      paramString1.ct(this.Kcp, this.KCW);
      if ((this.KEI) && (this.KEJ != null))
      {
        paramString1.bat(this.KEJ.mediaTagName);
        paramString1.aI(this.appid, this.KEJ.messageExt, this.KEJ.messageAction);
      }
      paramInt1 = paramString1.in();
      if (this.KCV != null)
      {
        this.KCV.wQ(paramInt1);
        com.tencent.mm.plugin.sns.k.i.Kjb.c(this.KCV);
      }
      aj.fOE().fNd();
      this.iXq.finish();
      AppMethodBeat.o(197448);
      return false;
      paramString1.agc(0);
    }
  }
  
  public final void ay(Bundle paramBundle)
  {
    AppMethodBeat.i(197419);
    this.KEJ = new SendMessageToWX.Req(this.iXq.getIntent().getBundleExtra("Ksnsupload_timeline")).message;
    paramBundle = this.iXq.getIntent().getStringExtra("Ksnsupload_music_share_object_xml");
    if (!Util.isNullOrNil(paramBundle))
    {
      paramBundle = XmlParser.parseXml(paramBundle, "musicShareItem", null);
      if (paramBundle != null)
      {
        this.KGg = new j();
        this.KGg.i("", paramBundle);
      }
    }
    if (this.KGg == null) {
      this.KGg = new j();
    }
    if (this.KEJ.getType() == 76)
    {
      this.KGh = this.iXq.getIntent().getStringExtra("music_mv_cover_url");
      paramBundle = (WXMusicVideoObject)this.KEJ.mediaObject;
      if (paramBundle != null)
      {
        this.songLyric = paramBundle.songLyric;
        this.KGg.mbm.singerName = paramBundle.singerName;
        this.KGg.mbm.albumName = paramBundle.albumName;
        this.KGg.mbm.musicGenre = paramBundle.musicGenre;
        this.KGg.mbm.issueDate = paramBundle.issueDate;
        this.KGg.mbm.identification = paramBundle.identification;
        this.KGg.mbm.FSG = paramBundle.duration;
        this.KGg.mbm.extraInfo = this.KEJ.messageExt;
      }
      this.KCV = l.x(this.iXq.getIntent());
      this.appid = Util.nullAs(this.iXq.getIntent().getStringExtra("Ksnsupload_appid"), "");
      this.appName = Util.nullAs(this.iXq.getIntent().getStringExtra("Ksnsupload_appname"), "");
      this.KEH = this.iXq.getIntent().getBooleanExtra("KThrid_app", false);
      this.KEI = this.iXq.getIntent().getBooleanExtra("KSnsAction", false);
      this.KCP = this.iXq.getIntent().getIntExtra("Ksnsupload_source", 0);
      if (!this.iXq.getIntent().getBooleanExtra("SendAppMessageWrapper_TokenValid", true)) {
        break label484;
      }
    }
    label484:
    for (this.Kcp = 1;; this.Kcp = 0)
    {
      this.KCW = Util.nullAs(this.iXq.getIntent().getStringExtra("SendAppMessageWrapper_PkgName"), "");
      AppMethodBeat.o(197419);
      return;
      if (this.KEJ.getType() != 3) {
        break;
      }
      paramBundle = (WXMusicObject)this.KEJ.mediaObject;
      if (paramBundle == null) {
        break;
      }
      this.songLyric = paramBundle.songLyric;
      this.KGh = paramBundle.songAlbumUrl;
      this.KGg.mbm.extraInfo = this.KEJ.messageExt;
      break;
    }
  }
  
  public final void az(Bundle paramBundle) {}
  
  public final boolean fTA()
  {
    AppMethodBeat.i(197452);
    if ((this.KGi != null) && (!this.KGi.isRecycled())) {
      this.KGi.recycle();
    }
    AppMethodBeat.o(197452);
    return false;
  }
  
  public final boolean fTw()
  {
    return true;
  }
  
  public final View fTx()
  {
    AppMethodBeat.i(197423);
    this.bvK = ad.kS(this.iXq).inflate(i.g.upload_media_mv, null);
    ((RoundCornerRelativeLayout)this.bvK.findViewById(i.f.round_corner_rl)).setRadius(com.tencent.mm.ci.a.fromDPToPix(this.iXq, 4));
    View localView = this.bvK.findViewById(i.f.blur_bg_view);
    Object localObject1 = (LinearLayout)this.bvK.findViewById(i.f.music_container);
    Object localObject2;
    if (ar.isDarkMode())
    {
      ((LinearLayout)localObject1).setBackgroundResource(i.e.sns_music_mv_dark_gradient_bg);
      localObject1 = (MMRoundCornerImageView)this.bvK.findViewById(i.f.chatting_music_cover);
      this.KGe = ((TextView)this.bvK.findViewById(i.f.chatting_music_singer_name));
      localObject2 = (TextView)this.bvK.findViewById(i.f.chatting_music_song_name);
      this.KGf = ((TextView)this.bvK.findViewById(i.f.chatting_music_mv_info));
      if (this.KEJ.thumbData != null) {
        this.KGi = BitmapUtil.decodeByteArray(this.KEJ.thumbData);
      }
      ((MMRoundCornerImageView)localObject1).setImageBitmap(this.KGi);
      ((TextView)localObject2).setText(this.KEJ.title);
      if (Util.isNullOrNil(this.KEJ.description)) {
        break label431;
      }
      this.KGe.setVisibility(0);
      this.KGe.setText(this.KEJ.description);
      label227:
      if ((this.KGg == null) || (this.KGg.mbm == null) || (Util.isNullOrNil(this.KGg.mbm.Rux))) {
        break label451;
      }
      ((ViewGroup.MarginLayoutParams)((TextView)localObject2).getLayoutParams()).topMargin = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 6);
      ((ViewGroup.MarginLayoutParams)this.KGe.getLayoutParams()).topMargin = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 2);
      this.bvK.findViewById(i.f.padding_view).setVisibility(0);
      this.KGf.setText(this.KGg.mbm.Rux + this.iXq.getString(i.j.music_mv_info_share_suffix));
      this.KGf.setVisibility(0);
    }
    for (;;)
    {
      if ((this.KGi != null) && (!this.KGi.isRecycled()))
      {
        localObject1 = d.getMessageDigest(this.KEJ.thumbData);
        localObject2 = b.ubp;
        b.a(this.iXq, localView, this.KGi, (String)localObject1);
      }
      localView = this.bvK;
      AppMethodBeat.o(197423);
      return localView;
      ((LinearLayout)localObject1).setBackgroundResource(i.e.sns_music_mv_light_gradient_bg);
      break;
      label431:
      this.KGe.setText("");
      this.KGe.setVisibility(0);
      break label227;
      label451:
      this.KGf.setText("");
      this.KGf.setVisibility(8);
    }
  }
  
  public final boolean fTy()
  {
    return true;
  }
  
  public final boolean fTz()
  {
    return true;
  }
  
  public final boolean k(int paramInt, Intent paramIntent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.al
 * JD-Core Version:    0.7.0.1
 */