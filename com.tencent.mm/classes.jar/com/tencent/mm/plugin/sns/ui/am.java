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
import com.tencent.mm.b.g;
import com.tencent.mm.modelsns.j;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicVipInfo;
import com.tencent.mm.plugin.comm.b;
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.bf;
import com.tencent.mm.plugin.sns.model.bg;
import com.tencent.mm.plugin.sns.statistics.n;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.djv;
import com.tencent.mm.protocal.protobuf.dtj;
import com.tencent.mm.protocal.protobuf.ffw;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.widget.MMRoundCornerImageView;
import com.tencent.mm.ui.widget.RoundCornerRelativeLayout;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.b.d.i;

public final class am
  implements ag
{
  private int QzF = 1;
  private com.tencent.mm.modelsns.l RcD = null;
  private String RcE = "";
  private int Rcy;
  private boolean Rei = false;
  private boolean Rej = false;
  private WXMediaMessage Rek = null;
  private TextView RfE;
  private TextView RfF;
  private j RfG;
  private String RfH;
  private Bitmap RfI;
  private String appName = "";
  private String appid = "";
  private View doN;
  private boolean hLy = false;
  private MMActivity lzt;
  private String songLyric;
  
  public am(MMActivity paramMMActivity)
  {
    this.lzt = paramMMActivity;
  }
  
  public final boolean a(int paramInt1, int paramInt2, i parami, String paramString1, List<String> paramList1, djv paramdjv, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(308494);
    al.hgx();
    WXMediaMessage localWXMediaMessage = this.Rek;
    paramLinkedList = this.appid;
    paramString2 = this.appName;
    String str1 = this.RfH;
    String str2 = this.songLyric;
    Log.d("MicroMsg.UploadManager", "appmsg.description " + localWXMediaMessage.description);
    Log.d("MicroMsg.UploadManager", "appmsg.title " + localWXMediaMessage.title);
    WXMediaMessage.IMediaObject localIMediaObject = localWXMediaMessage.mediaObject;
    bg localbg = new bg(42);
    localbg.aYS(Util.nullAs(paramLinkedList, "")).aYT(Util.nullAs(paramString2, ""));
    localbg.akQ(5);
    Log.d("MicroMsg.UploadManager", "TimeLineType 42");
    if (!Util.isNullOrNil(paramString1)) {
      localbg.aYM(paramString1);
    }
    localbg.aYR(Util.nullAs(localWXMediaMessage.title, "")).aYP(Util.nullAs(localWXMediaMessage.description, ""));
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
        localbg.aYR("").aYP("");
        paramInt2 = bf.wN(localIMediaObject.type());
        if (paramInt2 != -1) {
          break label542;
        }
        Log.d("MicroMsg.UploadManager", "mediaType is invalid");
        paramString1 = null;
      }
    }
    for (;;)
    {
      if (paramString1 != null) {
        break label596;
      }
      Log.e("MicroMsg.MusicMvWidget", "packHelper == null, %s, %s", new Object[] { this.appid, this.appName });
      AppMethodBeat.o(308494);
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
      WXMusicVideoObject localWXMusicVideoObject = (WXMusicVideoObject)localIMediaObject;
      paramLinkedList = Util.nullAs(localWXMusicVideoObject.musicUrl, "");
      if (!Util.isNullOrNil(localWXMusicVideoObject.musicDataUrl))
      {
        paramString1 = localWXMusicVideoObject.musicDataUrl;
        label448:
        localObject = Util.nullAs(paramString1, "");
        paramString2 = "";
        if (localWXMusicVideoObject.musicVipInfo != null) {
          com.tencent.mm.aw.a.OK(localWXMusicVideoObject.musicVipInfo.musicId);
        }
        paramString1 = localWXMusicVideoObject.singerName;
        if (localWXMusicVideoObject.musicVipInfo == null) {
          break label536;
        }
      }
      label536:
      for (boolean bool = true;; bool = false)
      {
        Log.i("MicroMsg.UploadManager", "share music mv to sns, singerName:%s, musicVipInfo is valid:%b", new Object[] { paramString1, Boolean.valueOf(bool) });
        break;
        paramString1 = localWXMusicVideoObject.musicUrl;
        break label448;
      }
      label542:
      paramString1 = localbg;
      if (!localbg.a(localWXMediaMessage.thumbData, paramLinkedList, paramString2, (String)localObject, paramInt2, Util.nullAs(localWXMediaMessage.title, ""), Util.nullAs(localWXMediaMessage.description, ""), str1, str2)) {
        paramString1 = null;
      }
    }
    label596:
    if (this.RfG != null)
    {
      paramLinkedList = this.RfG;
      if (paramLinkedList != null) {
        paramString1.QzA.ContentObj.oPb = paramLinkedList.oUg;
      }
    }
    paramPInt.value = paramString1.cIh;
    if (paramInt3 > com.tencent.mm.plugin.sns.d.a.Qkq) {
      paramString1.akL(4);
    }
    paramString1.akQ(this.Rcy);
    if (this.Rei) {
      paramString1.akQ(5);
    }
    paramLinkedList = new LinkedList();
    if (paramList1 != null)
    {
      new LinkedList();
      paramPInt = com.tencent.mm.pluginsdk.platformtools.a.iIX();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramString2 = (String)paramList1.next();
        if ((paramPInt != null) && (!paramPInt.contains(paramString2)))
        {
          localObject = new ffw();
          ((ffw)localObject).UserName = paramString2;
          paramLinkedList.add(localObject);
        }
      }
    }
    paramString1.bU(paramLinkedList);
    if (parami != null) {
      paramString1.mm(parami.token, parami.aaTQ);
    }
    paramString1.a(paramdjv);
    if (paramBoolean) {
      paramString1.akR(1);
    }
    for (;;)
    {
      paramString1.kB(paramList2).akO(paramInt1);
      paramString1.i(null, null, null, paramInt4, paramInt5);
      paramString1.df(this.QzF, this.RcE);
      if ((this.Rej) && (this.Rek != null))
      {
        paramString1.aYN(this.Rek.mediaTagName);
        paramString1.aY(this.appid, this.Rek.messageExt, this.Rek.messageAction);
      }
      paramInt1 = paramString1.FW();
      if (this.RcD != null)
      {
        this.RcD.wQ(paramInt1);
        com.tencent.mm.plugin.sns.statistics.l.QGY.c(this.RcD);
      }
      al.hgx().hej();
      this.lzt.finish();
      AppMethodBeat.o(308494);
      return false;
      paramString1.akR(0);
    }
  }
  
  public final void aZ(Bundle paramBundle)
  {
    AppMethodBeat.i(308481);
    this.Rek = new SendMessageToWX.Req(this.lzt.getIntent().getBundleExtra("Ksnsupload_timeline")).message;
    paramBundle = this.lzt.getIntent().getStringExtra("Ksnsupload_music_share_object_xml");
    if (!Util.isNullOrNil(paramBundle))
    {
      paramBundle = XmlParser.parseXml(paramBundle, "musicShareItem", null);
      if (paramBundle != null)
      {
        this.RfG = new j();
        this.RfG.i("", paramBundle);
      }
    }
    if (this.RfG == null) {
      this.RfG = new j();
    }
    if (this.Rek.getType() == 76)
    {
      this.RfH = this.lzt.getIntent().getStringExtra("music_mv_cover_url");
      paramBundle = (WXMusicVideoObject)this.Rek.mediaObject;
      if (paramBundle != null)
      {
        this.songLyric = paramBundle.songLyric;
        this.RfG.oUg.singerName = paramBundle.singerName;
        this.RfG.oUg.albumName = paramBundle.albumName;
        this.RfG.oUg.musicGenre = paramBundle.musicGenre;
        this.RfG.oUg.issueDate = paramBundle.issueDate;
        this.RfG.oUg.identification = paramBundle.identification;
        this.RfG.oUg.LNC = paramBundle.duration;
        this.RfG.oUg.extraInfo = this.Rek.messageExt;
        this.RfG.oUg.musicOperationUrl = paramBundle.musicOperationUrl;
        dtj localdtj = this.RfG.oUg;
        if (paramBundle.musicVipInfo != null)
        {
          paramBundle = com.tencent.mm.aw.a.OK(paramBundle.musicVipInfo.musicId);
          localdtj.oOZ = paramBundle;
        }
      }
      else
      {
        label304:
        this.RcD = com.tencent.mm.modelsns.l.y(this.lzt.getIntent());
        this.appid = Util.nullAs(this.lzt.getIntent().getStringExtra("Ksnsupload_appid"), "");
        this.appName = Util.nullAs(this.lzt.getIntent().getStringExtra("Ksnsupload_appname"), "");
        this.Rei = this.lzt.getIntent().getBooleanExtra("KThrid_app", false);
        this.Rej = this.lzt.getIntent().getBooleanExtra("KSnsAction", false);
        this.Rcy = this.lzt.getIntent().getIntExtra("Ksnsupload_source", 0);
        if (!this.lzt.getIntent().getBooleanExtra("SendAppMessageWrapper_TokenValid", true)) {
          break label535;
        }
      }
    }
    label535:
    for (this.QzF = 1;; this.QzF = 0)
    {
      this.RcE = Util.nullAs(this.lzt.getIntent().getStringExtra("SendAppMessageWrapper_PkgName"), "");
      AppMethodBeat.o(308481);
      return;
      paramBundle = "";
      break;
      if (this.Rek.getType() != 3) {
        break label304;
      }
      paramBundle = (WXMusicObject)this.Rek.mediaObject;
      if (paramBundle == null) {
        break label304;
      }
      this.songLyric = paramBundle.songLyric;
      this.RfH = paramBundle.songAlbumUrl;
      this.RfG.oUg.extraInfo = this.Rek.messageExt;
      break label304;
    }
  }
  
  public final void ba(Bundle paramBundle) {}
  
  public final boolean hlP()
  {
    return true;
  }
  
  public final View hlQ()
  {
    AppMethodBeat.i(308488);
    this.doN = af.mU(this.lzt).inflate(b.g.upload_media_mv, null);
    ((RoundCornerRelativeLayout)this.doN.findViewById(b.f.round_corner_rl)).setRadius(com.tencent.mm.cd.a.fromDPToPix(this.lzt, 4));
    View localView = this.doN.findViewById(b.f.blur_bg_view);
    Object localObject1 = (LinearLayout)this.doN.findViewById(b.f.music_container);
    Object localObject2;
    if (aw.isDarkMode())
    {
      ((LinearLayout)localObject1).setBackgroundResource(b.e.sns_music_mv_dark_gradient_bg);
      localObject1 = (MMRoundCornerImageView)this.doN.findViewById(b.f.chatting_music_cover);
      this.RfE = ((TextView)this.doN.findViewById(b.f.chatting_music_singer_name));
      localObject2 = (TextView)this.doN.findViewById(b.f.chatting_music_song_name);
      this.RfF = ((TextView)this.doN.findViewById(b.f.chatting_music_mv_info));
      if (this.Rek.thumbData != null) {
        this.RfI = BitmapUtil.decodeByteArray(this.Rek.thumbData);
      }
      ((MMRoundCornerImageView)localObject1).setImageBitmap(this.RfI);
      ((TextView)localObject2).setText(this.Rek.title);
      if (Util.isNullOrNil(this.Rek.description)) {
        break label431;
      }
      this.RfE.setVisibility(0);
      this.RfE.setText(this.Rek.description);
      label227:
      if ((this.RfG == null) || (this.RfG.oUg == null) || (Util.isNullOrNil(this.RfG.oUg.YqQ))) {
        break label451;
      }
      ((ViewGroup.MarginLayoutParams)((TextView)localObject2).getLayoutParams()).topMargin = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 6);
      ((ViewGroup.MarginLayoutParams)this.RfE.getLayoutParams()).topMargin = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 2);
      this.doN.findViewById(b.f.padding_view).setVisibility(0);
      this.RfF.setText(this.RfG.oUg.YqQ + this.lzt.getString(b.j.music_mv_info_share_suffix));
      this.RfF.setVisibility(0);
    }
    for (;;)
    {
      if ((this.RfI != null) && (!this.RfI.isRecycled()))
      {
        localObject1 = g.getMessageDigest(this.Rek.thumbData);
        localObject2 = b.xeH;
        b.a(this.lzt, localView, this.RfI, (String)localObject1);
      }
      localView = this.doN;
      AppMethodBeat.o(308488);
      return localView;
      ((LinearLayout)localObject1).setBackgroundResource(b.e.sns_music_mv_light_gradient_bg);
      break;
      label431:
      this.RfE.setText("");
      this.RfE.setVisibility(0);
      break label227;
      label451:
      this.RfF.setText("");
      this.RfF.setVisibility(8);
    }
  }
  
  public final boolean hlR()
  {
    return true;
  }
  
  public final boolean hlS()
  {
    return true;
  }
  
  public final boolean hlT()
  {
    AppMethodBeat.i(308495);
    if ((this.RfI != null) && (!this.RfI.isRecycled())) {
      this.RfI.recycle();
    }
    AppMethodBeat.o(308495);
    return false;
  }
  
  public final boolean n(int paramInt, Intent paramIntent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.am
 * JD-Core Version:    0.7.0.1
 */