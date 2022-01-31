package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;
import com.tencent.mm.h.a.pv;
import com.tencent.mm.h.a.pv.b;
import com.tencent.mm.h.b.a.u;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ax;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.aui;
import com.tencent.mm.protocal.c.avn;
import com.tencent.mm.protocal.c.buw;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.QImageView.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ac
  implements y
{
  private String appId;
  private String appName;
  MMActivity bER;
  String bIW = "";
  private boolean bJy = false;
  String dQL;
  String desc = "";
  ProgressDialog dnm = null;
  private String fKV;
  private View hNa = null;
  String lnw;
  private int oOs;
  private com.tencent.mm.modelsns.b oOy = null;
  private boolean oPR = false;
  private boolean oPS = false;
  private WXMediaMessage oPT = null;
  SightPlayImageView oQJ;
  private ImageView oQK = null;
  boolean oQL = false;
  private Bitmap oQM = null;
  private avn oQN = new avn();
  private String oQO;
  private boolean oQP = false;
  boolean oQQ = false;
  private int oQR = 0;
  private MediaMetadataRetriever oQS = new MediaMetadataRetriever();
  private int oQT = 0;
  private int oQU = 0;
  private int oQV = 90;
  private Pair<Integer, Integer> oQW = null;
  private Bitmap oQX = null;
  boolean oQY = false;
  private c oQZ = new ac.1(this);
  ax oRa = null;
  private int oRb = 0;
  Runnable oRc = new ac.5(this);
  Runnable oRd = new ac.6(this);
  String thumbPath = "";
  String videoPath = "";
  
  public ac(MMActivity paramMMActivity)
  {
    this.bER = paramMMActivity;
  }
  
  private void jr(boolean paramBoolean)
  {
    this.videoPath = "";
    this.thumbPath = "";
    this.oQQ = paramBoolean;
    this.oQV = 90;
    if (com.tencent.mm.plugin.sns.data.i.s(this.oQX))
    {
      this.oQX.recycle();
      this.oQX = null;
    }
  }
  
  public final void E(Bundle paramBundle)
  {
    this.oOy = com.tencent.mm.modelsns.b.i(this.bER.getIntent());
    this.lnw = bk.aM(this.bER.getIntent().getStringExtra("KSightCdnUrl"), "");
    this.dQL = bk.aM(this.bER.getIntent().getStringExtra("KSightCdnThumbUrl"), "");
    this.appId = bk.aM(this.bER.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.appName = bk.aM(this.bER.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.oPR = this.bER.getIntent().getBooleanExtra("KThrid_app", false);
    this.oPS = this.bER.getIntent().getBooleanExtra("KSnsAction", false);
    this.oQP = this.bER.getIntent().getBooleanExtra("Kis_take_photo", false);
    this.oQY = this.bER.getIntent().getBooleanExtra("KBlockAdd", false);
    this.oOs = this.bER.getIntent().getIntExtra("Ksnsupload_source", 0);
    this.fKV = bk.aM(this.bER.getIntent().getStringExtra("reportSessionId"), "");
    this.oQO = this.bER.getIntent().getStringExtra("KSessionID");
    paramBundle = this.bER.getIntent().getBundleExtra("Ksnsupload_timeline");
    if (paramBundle != null) {
      this.oPT = new SendMessageToWX.Req(paramBundle).message;
    }
    this.thumbPath = this.bER.getIntent().getStringExtra("KSightThumbPath");
    this.videoPath = this.bER.getIntent().getStringExtra("KSightPath");
    this.bIW = this.bER.getIntent().getStringExtra("sight_md5");
    paramBundle = this.bER.getIntent().getByteArrayExtra("KMMSightExtInfo");
    if (paramBundle != null) {}
    try
    {
      this.oQN.aH(paramBundle);
      if (this.oQN == null)
      {
        this.oQN = new avn();
        this.oQN.tra = this.oQP;
      }
      this.oQN.bOL = this.fKV;
      paramBundle = new pv();
      paramBundle.bZp.type = 2;
      com.tencent.mm.sdk.b.a.udP.m(paramBundle);
      if (bk.bl(this.videoPath))
      {
        this.videoPath = bk.aM(paramBundle.bZq.bZu, "");
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.SightWidget", "videoPath is null %s", new Object[] { this.videoPath });
      }
      if (bk.bl(this.bIW))
      {
        paramBundle = bk.aM(paramBundle.bZq.bZs, "");
        this.bIW = paramBundle;
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SightWidget", "oncreate thumb path %s videopath %s md5 %s", new Object[] { this.thumbPath, this.videoPath, this.bIW });
        com.tencent.mm.sdk.b.a.udP.c(this.oQZ);
        if (this.oQR == 0)
        {
          af.bDu();
          i = com.tencent.mm.plugin.sns.storage.s.getScreenWidth();
          if (i != 0) {
            break label574;
          }
        }
      }
    }
    catch (Exception paramBundle)
    {
      int i;
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SightWidget", "error %s", new Object[] { paramBundle.getMessage() });
        continue;
        paramBundle = this.bIW;
      }
      label574:
      this.oQR = ((i - this.bER.getResources().getDimensionPixelSize(i.d.sns_upload_previewimg_view_margin) * 4 - this.bER.getResources().getDimensionPixelSize(i.d.LargerPadding) * 2) / 3);
    }
  }
  
  public final void F(Bundle paramBundle) {}
  
  public final boolean a(int paramInt1, int paramInt2, org.c.d.i parami, String paramString1, List<String> paramList1, aui paramaui, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    if (!com.tencent.mm.vfs.e.bK(this.videoPath))
    {
      ai.d(new Runnable()
      {
        public final void run()
        {
          com.tencent.mm.ui.base.s.makeText(ac.this.bER, i.j.sendrequest_send_fail, 0).show();
        }
      });
      return false;
    }
    if (this.oRa != null) {
      return false;
    }
    if (this.oQL) {
      return true;
    }
    this.oQL = true;
    this.desc = paramString1;
    parami = new LinkedList();
    if (paramList1 != null)
    {
      new LinkedList();
      paramString2 = com.tencent.mm.model.s.Ha();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        String str = (String)paramList1.next();
        if (!paramString2.contains(str))
        {
          buw localbuw = new buw();
          localbuw.hPY = str;
          parami.add(localbuw);
        }
      }
    }
    this.oRa = new ax(15);
    paramPInt.value = this.oRa.avS;
    if (paramInt3 > com.tencent.mm.plugin.sns.c.a.omJ) {
      this.oRa.xS(3);
    }
    paramString1 = this.oRa.NR(paramString1);
    new LinkedList();
    paramString1.a(paramaui).am(parami).xU(paramInt1).xV(paramInt2).cx(paramList2);
    if (paramBoolean) {
      this.oRa.xX(1);
    }
    for (;;)
    {
      this.oRa.cx(paramList2);
      this.oRa.xW(this.oOs);
      this.oRa.bZX = this.oQN;
      this.oRa.f(null, null, null, paramInt4, paramInt5);
      if (!bk.bl(this.appId)) {
        this.oRa.NX(this.appId);
      }
      if (!bk.bl(this.appName)) {
        this.oRa.NY(bk.aM(this.appName, ""));
      }
      if (this.oPR) {
        this.oRa.xW(5);
      }
      if ((this.oPS) && (this.oPT != null))
      {
        this.oRa.NS(this.oPT.mediaTagName);
        this.oRa.Y(this.appId, this.oPT.messageExt, this.oPT.messageAction);
      }
      ai.l(this.oRd, 700L);
      com.tencent.mm.sdk.f.e.post(new ac.4(this), "sight_send_ready");
      return true;
      this.oRa.xX(0);
    }
  }
  
  final void bHH()
  {
    if ((this.oQX != null) && (!this.oQX.isRecycled()))
    {
      this.oQJ.setImageBitmap(this.oQX);
      this.oQJ.dL(((Integer)this.oQW.first).intValue(), ((Integer)this.oQW.second).intValue());
    }
  }
  
  final void bHI()
  {
    this.oQK.setVisibility(8);
    this.oQJ.ofD.clear();
    this.oQJ.dL(com.tencent.mm.cb.a.fromDPToPix(this.bER, 100), com.tencent.mm.cb.a.fromDPToPix(this.bER, 100));
    this.oQJ.setBackgroundResource(i.c.sns_upload_add_bg);
    this.oQJ.setImageResource(i.i.album_post_add_picture_btn);
    this.oQJ.setContentDescription(this.oQJ.getContext().getString(i.j.sns_add_video));
    int i = com.tencent.mm.cb.a.fromDPToPix(this.bER, 100) * 35 / 100;
    this.oQJ.setPadding(i, i, i, i);
  }
  
  public final boolean bHq()
  {
    return !this.oQQ;
  }
  
  public final View bHr()
  {
    this.hNa = View.inflate(this.bER, i.g.upload_new_sight_widget, null);
    this.oQJ = ((SightPlayImageView)this.hNa.findViewById(i.f.thumb_iv));
    this.oQK = ((ImageView)this.hNa.findViewById(i.f.status_btn));
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    this.bER.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    this.oQU = com.tencent.mm.cb.a.fromDPToPix(this.bER, 100);
    this.oQT = com.tencent.mm.cb.a.fromDPToPix(this.bER, 100);
    try
    {
      this.oQS.setDataSource(this.videoPath);
      this.oQV = bk.getInt(this.oQS.extractMetadata(24), 0);
      this.oQX = this.oQS.getFrameAtTime();
      if (this.oQV == 0) {
        break label530;
      }
      if (this.oQV != 180) {
        break label442;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        label442:
        com.tencent.mm.sdk.platformtools.y.w("MicroMsg.SightWidget", "MetadataRetriever init fail! path:%s  exception:%s", new Object[] { this.videoPath, localException.getMessage() });
        continue;
        int i = 1;
      }
    }
    if (i != 0) {
      this.oQU = bk.getInt(this.oQS.extractMetadata(19), com.tencent.mm.cb.a.fromDPToPix(this.bER, 100));
    }
    for (this.oQT = bk.getInt(this.oQS.extractMetadata(18), com.tencent.mm.cb.a.fromDPToPix(this.bER, 100));; this.oQT = bk.getInt(this.oQS.extractMetadata(19), com.tencent.mm.cb.a.fromDPToPix(this.bER, 100)))
    {
      this.oQW = com.tencent.mm.modelsns.e.a(this.oQT, this.oQU, this.bER, false);
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SightWidget", "rawWidth=%s rawHeight=%s fixWidth=%s fixHeight=%s rotation=%s", new Object[] { Integer.valueOf(this.oQT), Integer.valueOf(this.oQU), this.oQW.first, this.oQW.second, Integer.valueOf(this.oQV) });
      bHH();
      this.oQJ.setScaleType(QImageView.a.wkS);
      this.oQJ.ofL = true;
      this.oQJ.setOnClickListener(new ac.2(this));
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SightWidget", "videoPath " + this.videoPath + " thumbPath " + this.thumbPath + " " + com.tencent.mm.vfs.e.aeQ(this.videoPath) + " " + com.tencent.mm.vfs.e.aeQ(this.thumbPath));
      if (com.tencent.mm.vfs.e.bK(this.videoPath)) {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SightWidget", "videopath exist videopath %s md5 %s", new Object[] { this.videoPath, this.bIW });
      }
      return this.hNa;
      i = 0;
      break;
      this.oQU = bk.getInt(this.oQS.extractMetadata(18), com.tencent.mm.cb.a.fromDPToPix(this.bER, 100));
    }
  }
  
  public final boolean bHs()
  {
    if (this.dnm != null) {
      this.dnm.dismiss();
    }
    com.tencent.mm.sdk.b.a.udP.d(this.oQZ);
    if (com.tencent.mm.plugin.sns.data.i.s(this.oQM)) {
      this.oQM.recycle();
    }
    jr(false);
    return false;
  }
  
  /* Error */
  public final boolean d(int paramInt, Intent paramIntent)
  {
    // Byte code:
    //   0: iload_1
    //   1: tableswitch	default:+31 -> 32, 9:+257->258, 10:+31->32, 11:+67->68, 12:+33->34
    //   33: ireturn
    //   34: aload_2
    //   35: ifnull -3 -> 32
    //   38: aload_0
    //   39: aload_2
    //   40: ldc_w 825
    //   43: iconst_0
    //   44: invokevirtual 243	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   47: putfield 105	com/tencent/mm/plugin/sns/ui/ac:oQQ	Z
    //   50: aload_0
    //   51: getfield 105	com/tencent/mm/plugin/sns/ui/ac:oQQ	Z
    //   54: ifeq +12 -> 66
    //   57: aload_0
    //   58: invokevirtual 827	com/tencent/mm/plugin/sns/ui/ac:bHI	()V
    //   61: aload_0
    //   62: iconst_1
    //   63: invokespecial 822	com/tencent/mm/plugin/sns/ui/ac:jr	(Z)V
    //   66: iconst_1
    //   67: ireturn
    //   68: aload_2
    //   69: ldc_w 829
    //   72: invokevirtual 833	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   75: checkcast 835	com/tencent/mm/plugin/mmsight/SightCaptureResult
    //   78: astore 4
    //   80: aload 4
    //   82: ifnull -50 -> 32
    //   85: aload 4
    //   87: getfield 838	com/tencent/mm/plugin/mmsight/SightCaptureResult:mfh	Z
    //   90: ifne +107 -> 197
    //   93: aload_0
    //   94: iconst_0
    //   95: putfield 105	com/tencent/mm/plugin/sns/ui/ac:oQQ	Z
    //   98: aload_0
    //   99: aload 4
    //   101: getfield 841	com/tencent/mm/plugin/mmsight/SightCaptureResult:mfj	Ljava/lang/String;
    //   104: putfield 80	com/tencent/mm/plugin/sns/ui/ac:videoPath	Ljava/lang/String;
    //   107: aload_0
    //   108: aload 4
    //   110: getfield 844	com/tencent/mm/plugin/mmsight/SightCaptureResult:mfk	Ljava/lang/String;
    //   113: putfield 78	com/tencent/mm/plugin/sns/ui/ac:thumbPath	Ljava/lang/String;
    //   116: aload 4
    //   118: getfield 847	com/tencent/mm/plugin/mmsight/SightCaptureResult:mfm	Ljava/lang/String;
    //   121: invokestatic 392	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   124: ifne +58 -> 182
    //   127: aload_0
    //   128: aload 4
    //   130: getfield 847	com/tencent/mm/plugin/mmsight/SightCaptureResult:mfm	Ljava/lang/String;
    //   133: putfield 82	com/tencent/mm/plugin/sns/ui/ac:bIW	Ljava/lang/String;
    //   136: aload_0
    //   137: getfield 151	com/tencent/mm/plugin/sns/ui/ac:bER	Lcom/tencent/mm/ui/MMActivity;
    //   140: instanceof 849
    //   143: ifeq +37 -> 180
    //   146: aload_0
    //   147: getfield 151	com/tencent/mm/plugin/sns/ui/ac:bER	Lcom/tencent/mm/ui/MMActivity;
    //   150: checkcast 849	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   153: aload_0
    //   154: getfield 80	com/tencent/mm/plugin/sns/ui/ac:videoPath	Ljava/lang/String;
    //   157: aload_0
    //   158: getfield 78	com/tencent/mm/plugin/sns/ui/ac:thumbPath	Ljava/lang/String;
    //   161: aload_0
    //   162: getfield 82	com/tencent/mm/plugin/sns/ui/ac:bIW	Ljava/lang/String;
    //   165: aconst_null
    //   166: iconst_1
    //   167: invokevirtual 852	com/tencent/mm/plugin/sns/ui/SnsUploadUI:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BZ)V
    //   170: aload_0
    //   171: getfield 151	com/tencent/mm/plugin/sns/ui/ac:bER	Lcom/tencent/mm/ui/MMActivity;
    //   174: checkcast 849	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   177: invokevirtual 855	com/tencent/mm/plugin/sns/ui/SnsUploadUI:bKc	()V
    //   180: iconst_1
    //   181: ireturn
    //   182: aload_0
    //   183: aload 4
    //   185: getfield 841	com/tencent/mm/plugin/mmsight/SightCaptureResult:mfj	Ljava/lang/String;
    //   188: invokestatic 858	com/tencent/mm/vfs/e:aeY	(Ljava/lang/String;)Ljava/lang/String;
    //   191: putfield 82	com/tencent/mm/plugin/sns/ui/ac:bIW	Ljava/lang/String;
    //   194: goto -58 -> 136
    //   197: aload_0
    //   198: iconst_1
    //   199: putfield 105	com/tencent/mm/plugin/sns/ui/ac:oQQ	Z
    //   202: aload_2
    //   203: ldc_w 860
    //   206: iconst_0
    //   207: invokevirtual 343	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   210: istore_1
    //   211: aload 4
    //   213: getfield 863	com/tencent/mm/plugin/mmsight/SightCaptureResult:mfp	Ljava/lang/String;
    //   216: astore_2
    //   217: aload_0
    //   218: getfield 151	com/tencent/mm/plugin/sns/ui/ac:bER	Lcom/tencent/mm/ui/MMActivity;
    //   221: instanceof 849
    //   224: ifeq +32 -> 256
    //   227: aload_0
    //   228: getfield 151	com/tencent/mm/plugin/sns/ui/ac:bER	Lcom/tencent/mm/ui/MMActivity;
    //   231: checkcast 849	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   234: aload_2
    //   235: iconst_1
    //   236: iload_1
    //   237: aconst_null
    //   238: aconst_null
    //   239: aload_0
    //   240: getfield 345	com/tencent/mm/plugin/sns/ui/ac:oOs	I
    //   243: invokevirtual 866	com/tencent/mm/plugin/sns/ui/SnsUploadUI:a	(Ljava/lang/String;ZILjava/util/ArrayList;Ljava/util/ArrayList;I)V
    //   246: aload_0
    //   247: getfield 151	com/tencent/mm/plugin/sns/ui/ac:bER	Lcom/tencent/mm/ui/MMActivity;
    //   250: checkcast 849	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   253: invokevirtual 855	com/tencent/mm/plugin/sns/ui/SnsUploadUI:bKc	()V
    //   256: iconst_1
    //   257: ireturn
    //   258: aload_2
    //   259: ldc_w 868
    //   262: invokevirtual 872	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   265: astore 4
    //   267: aload 4
    //   269: ifnull +11 -> 280
    //   272: aload 4
    //   274: invokevirtual 877	java/util/ArrayList:size	()I
    //   277: ifgt +16 -> 293
    //   280: aload_2
    //   281: ldc_w 879
    //   284: invokevirtual 309	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   287: invokestatic 392	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   290: ifne +372 -> 662
    //   293: aload_0
    //   294: iconst_0
    //   295: putfield 105	com/tencent/mm/plugin/sns/ui/ac:oQQ	Z
    //   298: aload 4
    //   300: ifnull +124 -> 424
    //   303: aload 4
    //   305: invokevirtual 877	java/util/ArrayList:size	()I
    //   308: ifle +116 -> 424
    //   311: aload 4
    //   313: iconst_0
    //   314: invokevirtual 883	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   317: checkcast 491	java/lang/String
    //   320: astore 4
    //   322: aload_2
    //   323: ldc_w 885
    //   326: invokevirtual 309	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   329: astore 5
    //   331: aload 5
    //   333: invokestatic 392	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   336: ifne +14 -> 350
    //   339: aload 5
    //   341: astore_2
    //   342: aload 5
    //   344: invokestatic 457	com/tencent/mm/vfs/e:bK	(Ljava/lang/String;)Z
    //   347: ifne +180 -> 527
    //   350: new 788	java/lang/StringBuilder
    //   353: dup
    //   354: invokespecial 886	java/lang/StringBuilder:<init>	()V
    //   357: invokestatic 889	com/tencent/mm/plugin/sns/model/af:getAccSnsTmpPath	()Ljava/lang/String;
    //   360: invokevirtual 796	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: aload 4
    //   365: invokestatic 858	com/tencent/mm/vfs/e:aeY	(Ljava/lang/String;)Ljava/lang/String;
    //   368: invokevirtual 796	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: invokevirtual 810	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   374: astore_2
    //   375: new 109	android/media/MediaMetadataRetriever
    //   378: dup
    //   379: invokespecial 110	android/media/MediaMetadataRetriever:<init>	()V
    //   382: astore 5
    //   384: aload 5
    //   386: aload 4
    //   388: invokevirtual 741	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   391: aload 5
    //   393: lconst_0
    //   394: invokevirtual 892	android/media/MediaMetadataRetriever:getFrameAtTime	(J)Landroid/graphics/Bitmap;
    //   397: astore 6
    //   399: aload 6
    //   401: ifnonnull +35 -> 436
    //   404: ldc 160
    //   406: ldc_w 894
    //   409: invokestatic 896	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   412: aload 5
    //   414: invokevirtual 899	android/media/MediaMetadataRetriever:release	()V
    //   417: goto -385 -> 32
    //   420: astore_2
    //   421: goto -389 -> 32
    //   424: aload_2
    //   425: ldc_w 879
    //   428: invokevirtual 309	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   431: astore 4
    //   433: goto -111 -> 322
    //   436: ldc 160
    //   438: ldc_w 901
    //   441: iconst_2
    //   442: anewarray 4	java/lang/Object
    //   445: dup
    //   446: iconst_0
    //   447: aload 6
    //   449: invokevirtual 904	android/graphics/Bitmap:getWidth	()I
    //   452: invokestatic 762	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   455: aastore
    //   456: dup
    //   457: iconst_1
    //   458: aload 6
    //   460: invokevirtual 907	android/graphics/Bitmap:getHeight	()I
    //   463: invokestatic 762	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   466: aastore
    //   467: invokestatic 414	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   470: aload 6
    //   472: bipush 80
    //   474: getstatic 913	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   477: aload_2
    //   478: iconst_1
    //   479: invokestatic 918	com/tencent/mm/sdk/platformtools/c:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)V
    //   482: aload_2
    //   483: invokestatic 922	com/tencent/mm/sdk/platformtools/c:YU	(Ljava/lang/String;)Landroid/graphics/BitmapFactory$Options;
    //   486: astore 6
    //   488: ldc 160
    //   490: ldc_w 924
    //   493: iconst_2
    //   494: anewarray 4	java/lang/Object
    //   497: dup
    //   498: iconst_0
    //   499: aload 6
    //   501: getfield 929	android/graphics/BitmapFactory$Options:outWidth	I
    //   504: invokestatic 762	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   507: aastore
    //   508: dup
    //   509: iconst_1
    //   510: aload 6
    //   512: getfield 932	android/graphics/BitmapFactory$Options:outHeight	I
    //   515: invokestatic 762	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   518: aastore
    //   519: invokestatic 414	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   522: aload 5
    //   524: invokevirtual 899	android/media/MediaMetadataRetriever:release	()V
    //   527: aload_0
    //   528: aload 4
    //   530: invokestatic 858	com/tencent/mm/vfs/e:aeY	(Ljava/lang/String;)Ljava/lang/String;
    //   533: putfield 82	com/tencent/mm/plugin/sns/ui/ac:bIW	Ljava/lang/String;
    //   536: ldc 160
    //   538: ldc_w 934
    //   541: iconst_4
    //   542: anewarray 4	java/lang/Object
    //   545: dup
    //   546: iconst_0
    //   547: aload 4
    //   549: aastore
    //   550: dup
    //   551: iconst_1
    //   552: aload_2
    //   553: aastore
    //   554: dup
    //   555: iconst_2
    //   556: aload 4
    //   558: invokestatic 804	com/tencent/mm/vfs/e:aeQ	(Ljava/lang/String;)J
    //   561: invokestatic 939	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   564: aastore
    //   565: dup
    //   566: iconst_3
    //   567: aload_2
    //   568: invokestatic 804	com/tencent/mm/vfs/e:aeQ	(Ljava/lang/String;)J
    //   571: invokestatic 939	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   574: aastore
    //   575: invokestatic 414	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   578: aload_0
    //   579: getfield 151	com/tencent/mm/plugin/sns/ui/ac:bER	Lcom/tencent/mm/ui/MMActivity;
    //   582: instanceof 849
    //   585: ifeq +32 -> 617
    //   588: aload_0
    //   589: getfield 151	com/tencent/mm/plugin/sns/ui/ac:bER	Lcom/tencent/mm/ui/MMActivity;
    //   592: checkcast 849	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   595: aload 4
    //   597: aload_2
    //   598: aload_0
    //   599: getfield 82	com/tencent/mm/plugin/sns/ui/ac:bIW	Ljava/lang/String;
    //   602: aconst_null
    //   603: iconst_0
    //   604: invokevirtual 852	com/tencent/mm/plugin/sns/ui/SnsUploadUI:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BZ)V
    //   607: aload_0
    //   608: getfield 151	com/tencent/mm/plugin/sns/ui/ac:bER	Lcom/tencent/mm/ui/MMActivity;
    //   611: checkcast 849	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   614: invokevirtual 855	com/tencent/mm/plugin/sns/ui/SnsUploadUI:bKc	()V
    //   617: iconst_1
    //   618: ireturn
    //   619: astore 6
    //   621: ldc 160
    //   623: ldc_w 941
    //   626: iconst_1
    //   627: anewarray 4	java/lang/Object
    //   630: dup
    //   631: iconst_0
    //   632: aload 6
    //   634: invokevirtual 432	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   637: aastore
    //   638: invokestatic 407	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   641: aload 5
    //   643: invokevirtual 899	android/media/MediaMetadataRetriever:release	()V
    //   646: goto -119 -> 527
    //   649: astore 5
    //   651: goto -124 -> 527
    //   654: astore_2
    //   655: aload 5
    //   657: invokevirtual 899	android/media/MediaMetadataRetriever:release	()V
    //   660: aload_2
    //   661: athrow
    //   662: aload_0
    //   663: iconst_1
    //   664: putfield 105	com/tencent/mm/plugin/sns/ui/ac:oQQ	Z
    //   667: aload_2
    //   668: ldc_w 943
    //   671: invokevirtual 872	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   674: astore 4
    //   676: aload 4
    //   678: ifnull +11 -> 689
    //   681: aload 4
    //   683: invokevirtual 877	java/util/ArrayList:size	()I
    //   686: ifne +13 -> 699
    //   689: ldc 160
    //   691: ldc_w 945
    //   694: invokestatic 168	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   697: iconst_0
    //   698: ireturn
    //   699: new 874	java/util/ArrayList
    //   702: dup
    //   703: invokespecial 946	java/util/ArrayList:<init>	()V
    //   706: astore 5
    //   708: aload 4
    //   710: invokevirtual 947	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   713: astore 6
    //   715: aload 6
    //   717: invokeinterface 485 1 0
    //   722: ifeq +76 -> 798
    //   725: aload 6
    //   727: invokeinterface 489 1 0
    //   732: checkcast 491	java/lang/String
    //   735: astore 7
    //   737: aload 7
    //   739: invokestatic 953	com/tencent/mm/compatible/util/Exif:fromFile	(Ljava/lang/String;)Lcom/tencent/mm/compatible/util/Exif;
    //   742: invokevirtual 957	com/tencent/mm/compatible/util/Exif:getLocation	()Lcom/tencent/mm/compatible/util/Exif$a;
    //   745: astore 8
    //   747: aload 8
    //   749: ifnull -34 -> 715
    //   752: aload 5
    //   754: ldc_w 959
    //   757: iconst_3
    //   758: anewarray 4	java/lang/Object
    //   761: dup
    //   762: iconst_0
    //   763: aload 7
    //   765: aastore
    //   766: dup
    //   767: iconst_1
    //   768: aload 8
    //   770: getfield 965	com/tencent/mm/compatible/util/Exif$a:latitude	D
    //   773: invokestatic 970	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   776: aastore
    //   777: dup
    //   778: iconst_2
    //   779: aload 8
    //   781: getfield 973	com/tencent/mm/compatible/util/Exif$a:longitude	D
    //   784: invokestatic 970	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   787: aastore
    //   788: invokestatic 977	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   791: invokevirtual 978	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   794: pop
    //   795: goto -80 -> 715
    //   798: aload_2
    //   799: ldc_w 980
    //   802: iconst_0
    //   803: invokevirtual 243	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   806: istore_3
    //   807: aload_2
    //   808: ldc_w 860
    //   811: iconst_0
    //   812: invokevirtual 343	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   815: istore_1
    //   816: aload_0
    //   817: getfield 151	com/tencent/mm/plugin/sns/ui/ac:bER	Lcom/tencent/mm/ui/MMActivity;
    //   820: instanceof 849
    //   823: ifeq -791 -> 32
    //   826: aload_0
    //   827: getfield 151	com/tencent/mm/plugin/sns/ui/ac:bER	Lcom/tencent/mm/ui/MMActivity;
    //   830: checkcast 849	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   833: aconst_null
    //   834: iload_3
    //   835: iload_1
    //   836: aload 4
    //   838: aload 5
    //   840: aload_0
    //   841: getfield 345	com/tencent/mm/plugin/sns/ui/ac:oOs	I
    //   844: invokevirtual 866	com/tencent/mm/plugin/sns/ui/SnsUploadUI:a	(Ljava/lang/String;ZILjava/util/ArrayList;Ljava/util/ArrayList;I)V
    //   847: aload_0
    //   848: getfield 151	com/tencent/mm/plugin/sns/ui/ac:bER	Lcom/tencent/mm/ui/MMActivity;
    //   851: checkcast 849	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   854: invokevirtual 855	com/tencent/mm/plugin/sns/ui/SnsUploadUI:bKc	()V
    //   857: goto -825 -> 32
    //   860: astore 5
    //   862: goto -335 -> 527
    //   865: astore 4
    //   867: goto -207 -> 660
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	870	0	this	ac
    //   0	870	1	paramInt	int
    //   0	870	2	paramIntent	Intent
    //   806	29	3	bool	boolean
    //   78	759	4	localObject1	Object
    //   865	1	4	localException1	Exception
    //   329	313	5	localObject2	Object
    //   649	7	5	localException2	Exception
    //   706	133	5	localArrayList	java.util.ArrayList
    //   860	1	5	localException3	Exception
    //   397	114	6	localObject3	Object
    //   619	14	6	localException4	Exception
    //   713	13	6	localIterator	Iterator
    //   735	29	7	str	String
    //   745	35	8	locala	com.tencent.mm.compatible.util.Exif.a
    // Exception table:
    //   from	to	target	type
    //   412	417	420	java/lang/Exception
    //   384	399	619	java/lang/Exception
    //   404	412	619	java/lang/Exception
    //   436	522	619	java/lang/Exception
    //   641	646	649	java/lang/Exception
    //   384	399	654	finally
    //   404	412	654	finally
    //   436	522	654	finally
    //   621	641	654	finally
    //   522	527	860	java/lang/Exception
    //   655	660	865	java/lang/Exception
  }
  
  final void yB(int paramInt)
  {
    u localu = new u().uQ();
    localu.cjI = paramInt;
    localu.cie = this.oQO;
    localu.QX();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ac
 * JD-Core Version:    0.7.0.1
 */