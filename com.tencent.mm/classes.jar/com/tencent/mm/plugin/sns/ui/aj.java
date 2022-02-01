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
import com.tencent.mm.modelsns.k;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicVideoObject;
import com.tencent.mm.plugin.comm.b;
import com.tencent.mm.plugin.sns.k.g;
import com.tencent.mm.plugin.sns.model.be;
import com.tencent.mm.plugin.sns.model.bf;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.cjy;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.protocal.protobuf.ebm;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.MMRoundCornerImageView;
import com.tencent.mm.ui.widget.RoundCornerRelativeLayout;
import com.tencent.xweb.util.d;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class aj
  implements ad
{
  private int DPi = 1;
  private int EpG;
  private k EpM = null;
  private String EpN = "";
  private boolean Ero = false;
  private boolean Erp = false;
  private WXMediaMessage Erq = null;
  private TextView EsH;
  private TextView EsI;
  private com.tencent.mm.modelsns.i EsJ;
  private String EsK;
  private Bitmap EsL;
  private String appName = "";
  private String dNI = "";
  private boolean gVd = false;
  private MMActivity gte;
  private View sc;
  private String songLyric;
  
  public aj(MMActivity paramMMActivity)
  {
    this.gte = paramMMActivity;
  }
  
  public final boolean a(int paramInt1, int paramInt2, org.b.d.i parami, String paramString1, List<String> paramList1, cjy paramcjy, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(203313);
    com.tencent.mm.plugin.sns.model.aj.faK();
    WXMediaMessage localWXMediaMessage = this.Erq;
    paramLinkedList = this.dNI;
    paramString2 = this.appName;
    String str1 = this.EsK;
    String str2 = this.songLyric;
    Log.d("MicroMsg.UploadManager", "appmsg.description " + localWXMediaMessage.description);
    Log.d("MicroMsg.UploadManager", "appmsg.title " + localWXMediaMessage.title);
    WXMediaMessage.IMediaObject localIMediaObject = localWXMediaMessage.mediaObject;
    bf localbf = new bf(42);
    localbf.aPC(Util.nullAs(paramLinkedList, "")).aPD(Util.nullAs(paramString2, ""));
    localbf.YK(5);
    Log.d("MicroMsg.UploadManager", "TimeLineType 42");
    if (!Util.isNullOrNil(paramString1)) {
      localbf.aPw(paramString1);
    }
    localbf.aPB(Util.nullAs(localWXMediaMessage.title, "")).aPz(Util.nullAs(localWXMediaMessage.description, ""));
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
        localbf.aPB("").aPz("");
        paramInt2 = be.tN(localIMediaObject.type());
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
      Log.e("MicroMsg.MusicMvWidget", "packHelper == null, %s, %s", new Object[] { this.dNI, this.appName });
      AppMethodBeat.o(203313);
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
      paramString1 = localbf;
      if (!localbf.a(localWXMediaMessage.thumbData, paramLinkedList, paramString2, (String)localObject, paramInt2, Util.nullAs(localWXMediaMessage.title, ""), Util.nullAs(localWXMediaMessage.description, ""), str1, str2)) {
        paramString1 = null;
      }
    }
    label528:
    if (this.EsJ != null)
    {
      paramLinkedList = this.EsJ;
      if (paramLinkedList != null) {
        paramString1.DPd.ContentObj.jfy = paramLinkedList.jlj;
      }
    }
    paramPInt.value = paramString1.beK;
    if (paramInt3 > com.tencent.mm.plugin.sns.c.a.DCT) {
      paramString1.YF(4);
    }
    paramString1.YK(this.EpG);
    if (this.Ero) {
      paramString1.YK(5);
    }
    paramLinkedList = new LinkedList();
    if (paramList1 != null)
    {
      new LinkedList();
      paramPInt = com.tencent.mm.pluginsdk.i.a.gnq();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramString2 = (String)paramList1.next();
        if (!paramPInt.contains(paramString2))
        {
          localObject = new ebm();
          ((ebm)localObject).UserName = paramString2;
          paramLinkedList.add(localObject);
        }
      }
    }
    paramString1.bq(paramLinkedList);
    if (parami != null) {
      paramString1.kl(parami.token, parami.Mte);
    }
    paramString1.a(paramcjy);
    if (paramBoolean) {
      paramString1.YL(1);
    }
    for (;;)
    {
      paramString1.gR(paramList2).YI(paramInt1);
      paramString1.g(null, null, null, paramInt4, paramInt5);
      paramString1.ct(this.DPi, this.EpN);
      if ((this.Erp) && (this.Erq != null))
      {
        paramString1.aPx(this.Erq.mediaTagName);
        paramString1.aO(this.dNI, this.Erq.messageExt, this.Erq.messageAction);
      }
      paramInt1 = paramString1.commit();
      if (this.EpM != null)
      {
        this.EpM.tQ(paramInt1);
        g.DVR.c(this.EpM);
      }
      com.tencent.mm.plugin.sns.model.aj.faK().eZn();
      this.gte.finish();
      AppMethodBeat.o(203313);
      return false;
      paramString1.YL(0);
    }
  }
  
  public final void aC(Bundle paramBundle)
  {
    AppMethodBeat.i(203311);
    this.Erq = new SendMessageToWX.Req(this.gte.getIntent().getBundleExtra("Ksnsupload_timeline")).message;
    paramBundle = this.gte.getIntent().getStringExtra("Ksnsupload_music_share_object_xml");
    if (!Util.isNullOrNil(paramBundle))
    {
      paramBundle = XmlParser.parseXml(paramBundle, "musicShareItem", null);
      if (paramBundle != null)
      {
        this.EsJ = new com.tencent.mm.modelsns.i();
        this.EsJ.j("", paramBundle);
      }
    }
    if (this.EsJ == null) {
      this.EsJ = new com.tencent.mm.modelsns.i();
    }
    if (this.Erq.getType() == 76)
    {
      this.EsK = this.gte.getIntent().getStringExtra("music_mv_cover_url");
      paramBundle = (WXMusicVideoObject)this.Erq.mediaObject;
      if (paramBundle != null)
      {
        this.songLyric = paramBundle.songLyric;
        this.EsJ.jlj.singerName = paramBundle.singerName;
        this.EsJ.jlj.albumName = paramBundle.albumName;
        this.EsJ.jlj.musicGenre = paramBundle.musicGenre;
        this.EsJ.jlj.issueDate = paramBundle.issueDate;
        this.EsJ.jlj.identification = paramBundle.identification;
        this.EsJ.jlj.Alz = paramBundle.duration;
        this.EsJ.jlj.extraInfo = this.Erq.messageExt;
      }
      this.EpM = k.w(this.gte.getIntent());
      this.dNI = Util.nullAs(this.gte.getIntent().getStringExtra("Ksnsupload_appid"), "");
      this.appName = Util.nullAs(this.gte.getIntent().getStringExtra("Ksnsupload_appname"), "");
      this.Ero = this.gte.getIntent().getBooleanExtra("KThrid_app", false);
      this.Erp = this.gte.getIntent().getBooleanExtra("KSnsAction", false);
      this.EpG = this.gte.getIntent().getIntExtra("Ksnsupload_source", 0);
      if (!this.gte.getIntent().getBooleanExtra("SendAppMessageWrapper_TokenValid", true)) {
        break label484;
      }
    }
    label484:
    for (this.DPi = 1;; this.DPi = 0)
    {
      this.EpN = Util.nullAs(this.gte.getIntent().getStringExtra("SendAppMessageWrapper_PkgName"), "");
      AppMethodBeat.o(203311);
      return;
      if (this.Erq.getType() != 3) {
        break;
      }
      paramBundle = (WXMusicObject)this.Erq.mediaObject;
      if (paramBundle == null) {
        break;
      }
      this.songLyric = paramBundle.songLyric;
      this.EsK = paramBundle.songAlbumUrl;
      this.EsJ.jlj.extraInfo = this.Erq.messageExt;
      break;
    }
  }
  
  public final void aD(Bundle paramBundle) {}
  
  public final boolean ffA()
  {
    return true;
  }
  
  public final View ffB()
  {
    AppMethodBeat.i(203312);
    this.sc = aa.jQ(this.gte).inflate(2131496780, null);
    ((RoundCornerRelativeLayout)this.sc.findViewById(2131307176)).setRadius(com.tencent.mm.cb.a.fromDPToPix(this.gte, 4));
    View localView = this.sc.findViewById(2131297645);
    Object localObject1 = (LinearLayout)this.sc.findViewById(2131305087);
    Object localObject2;
    if (ao.isDarkMode())
    {
      ((LinearLayout)localObject1).setBackgroundResource(2131234996);
      localObject1 = (MMRoundCornerImageView)this.sc.findViewById(2131298519);
      this.EsH = ((TextView)this.sc.findViewById(2131298523));
      localObject2 = (TextView)this.sc.findViewById(2131298524);
      this.EsI = ((TextView)this.sc.findViewById(2131298521));
      if (this.Erq.thumbData != null) {
        this.EsL = BitmapUtil.decodeByteArray(this.Erq.thumbData);
      }
      ((MMRoundCornerImageView)localObject1).setImageBitmap(this.EsL);
      ((TextView)localObject2).setText(this.Erq.title);
      if (Util.isNullOrNil(this.Erq.description)) {
        break label431;
      }
      this.EsH.setVisibility(0);
      this.EsH.setText(this.Erq.description);
      label227:
      if ((this.EsJ == null) || (this.EsJ.jlj == null) || (Util.isNullOrNil(this.EsJ.jlj.Ktq))) {
        break label451;
      }
      ((ViewGroup.MarginLayoutParams)((TextView)localObject2).getLayoutParams()).topMargin = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 6);
      ((ViewGroup.MarginLayoutParams)this.EsH.getLayoutParams()).topMargin = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 2);
      this.sc.findViewById(2131305768).setVisibility(0);
      this.EsI.setText(this.EsJ.jlj.Ktq + this.gte.getString(2131763368));
      this.EsI.setVisibility(0);
    }
    for (;;)
    {
      if ((this.EsL != null) && (!this.EsL.isRecycled()))
      {
        localObject1 = d.getMessageDigest(this.Erq.thumbData);
        localObject2 = b.qCp;
        b.a(this.gte, localView, this.EsL, (String)localObject1);
      }
      localView = this.sc;
      AppMethodBeat.o(203312);
      return localView;
      ((LinearLayout)localObject1).setBackgroundResource(2131234997);
      break;
      label431:
      this.EsH.setText("");
      this.EsH.setVisibility(0);
      break label227;
      label451:
      this.EsI.setText("");
      this.EsI.setVisibility(8);
    }
  }
  
  public final boolean ffC()
  {
    return true;
  }
  
  public final boolean ffD()
  {
    return true;
  }
  
  public final boolean ffE()
  {
    AppMethodBeat.i(203314);
    if ((this.EsL != null) && (!this.EsL.isRecycled())) {
      this.EsL.recycle();
    }
    AppMethodBeat.o(203314);
    return false;
  }
  
  public final boolean k(int paramInt, Intent paramIntent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.aj
 * JD-Core Version:    0.7.0.1
 */