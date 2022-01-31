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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.rd;
import com.tencent.mm.g.a.rd.b;
import com.tencent.mm.g.b.a.am;
import com.tencent.mm.model.t;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ay;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.bap;
import com.tencent.mm.protocal.protobuf.bby;
import com.tencent.mm.protocal.protobuf.cfm;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
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
  MMActivity cmc;
  private boolean cqS;
  String cqq;
  String desc;
  ProgressDialog eeN;
  String fgM;
  private View jIo;
  private String mSessionId;
  String nKP;
  private int rGd;
  private com.tencent.mm.modelsns.b rGj;
  private boolean rHD;
  private boolean rHE;
  private WXMediaMessage rHF;
  private String rIA;
  private boolean rIB;
  boolean rIC;
  private int rID;
  private MediaMetadataRetriever rIE;
  private int rIF;
  private int rIG;
  private int rIH;
  private Pair<Integer, Integer> rII;
  private Bitmap rIJ;
  boolean rIK;
  private c rIL;
  ay rIM;
  private int rIN;
  Runnable rIO;
  Runnable rIP;
  SightPlayImageView rIv;
  private ImageView rIw;
  boolean rIx;
  private Bitmap rIy;
  private bby rIz;
  String thumbPath;
  String videoPath;
  
  public ac(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(38347);
    this.jIo = null;
    this.rIw = null;
    this.thumbPath = "";
    this.videoPath = "";
    this.cqq = "";
    this.cqS = false;
    this.rIx = false;
    this.rIy = null;
    this.rGj = null;
    this.rIz = new bby();
    this.rHD = false;
    this.rHE = false;
    this.rHF = null;
    this.rIB = false;
    this.rIC = false;
    this.rID = 0;
    this.rIE = new MediaMetadataRetriever();
    this.rIF = 0;
    this.rIG = 0;
    this.rIH = 90;
    this.rII = null;
    this.rIJ = null;
    this.rIK = false;
    this.rIL = new ac.1(this);
    this.rIM = null;
    this.rIN = 0;
    this.desc = "";
    this.eeN = null;
    this.rIO = new ac.5(this);
    this.rIP = new ac.6(this);
    this.cmc = paramMMActivity;
    AppMethodBeat.o(38347);
  }
  
  private void lv(boolean paramBoolean)
  {
    AppMethodBeat.i(38351);
    this.videoPath = "";
    this.thumbPath = "";
    this.rIC = paramBoolean;
    this.rIH = 90;
    if (com.tencent.mm.plugin.sns.data.i.A(this.rIJ))
    {
      this.rIJ.recycle();
      this.rIJ = null;
    }
    AppMethodBeat.o(38351);
  }
  
  final void EG(int paramInt)
  {
    AppMethodBeat.i(38354);
    am localam = new am().Fn();
    localam.cUF = paramInt;
    localam.fR(this.rIA).ake();
    AppMethodBeat.o(38354);
  }
  
  public final void V(Bundle paramBundle)
  {
    AppMethodBeat.i(38348);
    this.rGj = com.tencent.mm.modelsns.b.w(this.cmc.getIntent());
    this.nKP = bo.bf(this.cmc.getIntent().getStringExtra("KSightCdnUrl"), "");
    this.fgM = bo.bf(this.cmc.getIntent().getStringExtra("KSightCdnThumbUrl"), "");
    this.appId = bo.bf(this.cmc.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.appName = bo.bf(this.cmc.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.rHD = this.cmc.getIntent().getBooleanExtra("KThrid_app", false);
    this.rHE = this.cmc.getIntent().getBooleanExtra("KSnsAction", false);
    this.rIB = this.cmc.getIntent().getBooleanExtra("Kis_take_photo", false);
    this.rIK = this.cmc.getIntent().getBooleanExtra("KBlockAdd", false);
    this.rGd = this.cmc.getIntent().getIntExtra("Ksnsupload_source", 0);
    this.mSessionId = bo.bf(this.cmc.getIntent().getStringExtra("reportSessionId"), "");
    this.rIA = this.cmc.getIntent().getStringExtra("KSessionID");
    paramBundle = this.cmc.getIntent().getBundleExtra("Ksnsupload_timeline");
    if (paramBundle != null) {
      this.rHF = new SendMessageToWX.Req(paramBundle).message;
    }
    this.thumbPath = this.cmc.getIntent().getStringExtra("KSightThumbPath");
    this.videoPath = this.cmc.getIntent().getStringExtra("KSightPath");
    this.cqq = this.cmc.getIntent().getStringExtra("sight_md5");
    paramBundle = this.cmc.getIntent().getByteArrayExtra("KMMSightExtInfo");
    if (paramBundle != null) {}
    try
    {
      this.rIz.parseFrom(paramBundle);
      if (this.rIz == null)
      {
        this.rIz = new bby();
        this.rIz.xra = this.rIB;
      }
      this.rIz.cwc = this.mSessionId;
      paramBundle = new rd();
      paramBundle.cHE.type = 2;
      com.tencent.mm.sdk.b.a.ymk.l(paramBundle);
      if (bo.isNullOrNil(this.videoPath))
      {
        this.videoPath = bo.bf(paramBundle.cHF.cHJ, "");
        ab.e("MicroMsg.SightWidget", "videoPath is null %s", new Object[] { this.videoPath });
      }
      if (bo.isNullOrNil(this.cqq))
      {
        paramBundle = bo.bf(paramBundle.cHF.cHH, "");
        this.cqq = paramBundle;
        ab.i("MicroMsg.SightWidget", "oncreate thumb path %s videopath %s md5 %s", new Object[] { this.thumbPath, this.videoPath, this.cqq });
        com.tencent.mm.sdk.b.a.ymk.c(this.rIL);
        if (this.rID != 0) {
          break label625;
        }
        ag.coU();
        i = s.getScreenWidth();
        if (i != 0) {
          break label586;
        }
        AppMethodBeat.o(38348);
      }
    }
    catch (Exception paramBundle)
    {
      int i;
      for (;;)
      {
        ab.i("MicroMsg.SightWidget", "error %s", new Object[] { paramBundle.getMessage() });
        continue;
        paramBundle = this.cqq;
      }
      label586:
      this.rID = ((i - this.cmc.getResources().getDimensionPixelSize(2131428718) * 4 - this.cmc.getResources().getDimensionPixelSize(2131427775) * 2) / 3);
      label625:
      AppMethodBeat.o(38348);
    }
  }
  
  public final void W(Bundle paramBundle) {}
  
  public final boolean a(int paramInt1, int paramInt2, org.b.d.i parami, String paramString1, List<String> paramList1, bap parambap, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(38350);
    if (!com.tencent.mm.vfs.e.cN(this.videoPath))
    {
      al.d(new ac.3(this));
      AppMethodBeat.o(38350);
      return false;
    }
    if (this.rIM != null)
    {
      AppMethodBeat.o(38350);
      return false;
    }
    if (this.rIx)
    {
      AppMethodBeat.o(38350);
      return true;
    }
    this.rIx = true;
    this.desc = paramString1;
    parami = new LinkedList();
    if (paramList1 != null)
    {
      new LinkedList();
      paramString2 = t.aac();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        String str = (String)paramList1.next();
        if (!paramString2.contains(str))
        {
          cfm localcfm = new cfm();
          localcfm.jJA = str;
          parami.add(localcfm);
        }
      }
    }
    this.rIM = new ay(15);
    paramPInt.value = this.rIM.ayi;
    if (paramInt3 > com.tencent.mm.plugin.sns.c.a.raX) {
      this.rIM.DS(3);
    }
    paramString1 = this.rIM.aaL(paramString1);
    new LinkedList();
    paramString1.a(parambap).av(parami).DU(paramInt1).DV(paramInt2).dc(paramList2);
    if (paramBoolean) {
      this.rIM.DX(1);
    }
    for (;;)
    {
      this.rIM.dc(paramList2);
      this.rIM.DW(this.rGd);
      this.rIM.cIu = this.rIz;
      this.rIM.g(null, null, null, paramInt4, paramInt5);
      this.rIM.setSessionId(this.mSessionId);
      if (!bo.isNullOrNil(this.appId)) {
        this.rIM.aaR(this.appId);
      }
      if (!bo.isNullOrNil(this.appName)) {
        this.rIM.aaS(bo.bf(this.appName, ""));
      }
      if (this.rHD) {
        this.rIM.DW(5);
      }
      if ((this.rHE) && (this.rHF != null))
      {
        this.rIM.aaM(this.rHF.mediaTagName);
        this.rIM.aj(this.appId, this.rHF.messageExt, this.rHF.messageAction);
      }
      al.p(this.rIP, 700L);
      d.post(new ac.4(this), "sight_send_ready");
      AppMethodBeat.o(38350);
      return true;
      this.rIM.DX(0);
    }
  }
  
  final void ctN()
  {
    AppMethodBeat.i(38355);
    if ((this.rIJ != null) && (!this.rIJ.isRecycled()))
    {
      this.rIv.setImageBitmap(this.rIJ);
      this.rIv.ft(((Integer)this.rII.first).intValue(), ((Integer)this.rII.second).intValue());
    }
    AppMethodBeat.o(38355);
  }
  
  final void ctO()
  {
    AppMethodBeat.i(38356);
    this.rIw.setVisibility(8);
    this.rIv.qTR.clear();
    this.rIv.ft(com.tencent.mm.cb.a.fromDPToPix(this.cmc, 100), com.tencent.mm.cb.a.fromDPToPix(this.cmc, 100));
    this.rIv.setBackgroundResource(2131690511);
    this.rIv.setImageResource(2131230781);
    this.rIv.setContentDescription(this.rIv.getContext().getString(2131303771));
    int i = com.tencent.mm.cb.a.fromDPToPix(this.cmc, 100) * 35 / 100;
    this.rIv.setPadding(i, i, i, i);
    AppMethodBeat.o(38356);
  }
  
  public final boolean ctu()
  {
    return !this.rIC;
  }
  
  public final View ctv()
  {
    AppMethodBeat.i(38349);
    this.jIo = View.inflate(this.cmc, 2130971053, null);
    this.rIv = ((SightPlayImageView)this.jIo.findViewById(2131821549));
    this.rIw = ((ImageView)this.jIo.findViewById(2131820996));
    Object localObject = new DisplayMetrics();
    this.cmc.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    this.rIG = com.tencent.mm.cb.a.fromDPToPix(this.cmc, 100);
    this.rIF = com.tencent.mm.cb.a.fromDPToPix(this.cmc, 100);
    try
    {
      this.rIE.setDataSource(this.videoPath);
      this.rIH = bo.getInt(this.rIE.extractMetadata(24), 0);
      this.rIJ = this.rIE.getFrameAtTime();
      if (this.rIH == 0) {
        break label544;
      }
      if (this.rIH != 180) {
        break label456;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        label456:
        ab.w("MicroMsg.SightWidget", "MetadataRetriever init fail! path:%s  exception:%s", new Object[] { this.videoPath, localException.getMessage() });
        continue;
        int i = 1;
      }
    }
    if (i != 0) {
      this.rIG = bo.getInt(this.rIE.extractMetadata(19), com.tencent.mm.cb.a.fromDPToPix(this.cmc, 100));
    }
    for (this.rIF = bo.getInt(this.rIE.extractMetadata(18), com.tencent.mm.cb.a.fromDPToPix(this.cmc, 100));; this.rIF = bo.getInt(this.rIE.extractMetadata(19), com.tencent.mm.cb.a.fromDPToPix(this.cmc, 100)))
    {
      this.rII = com.tencent.mm.modelsns.e.a(this.rIF, this.rIG, this.cmc, false);
      ab.d("MicroMsg.SightWidget", "rawWidth=%s rawHeight=%s fixWidth=%s fixHeight=%s rotation=%s", new Object[] { Integer.valueOf(this.rIF), Integer.valueOf(this.rIG), this.rII.first, this.rII.second, Integer.valueOf(this.rIH) });
      ctN();
      this.rIv.setScaleType(QImageView.a.AED);
      this.rIv.qTZ = true;
      this.rIv.setOnClickListener(new ac.2(this));
      ab.i("MicroMsg.SightWidget", "videoPath " + this.videoPath + " thumbPath " + this.thumbPath + " " + com.tencent.mm.vfs.e.avI(this.videoPath) + " " + com.tencent.mm.vfs.e.avI(this.thumbPath));
      if (com.tencent.mm.vfs.e.cN(this.videoPath)) {
        ab.i("MicroMsg.SightWidget", "videopath exist videopath %s md5 %s", new Object[] { this.videoPath, this.cqq });
      }
      localObject = this.jIo;
      AppMethodBeat.o(38349);
      return localObject;
      i = 0;
      break;
      this.rIG = bo.getInt(this.rIE.extractMetadata(18), com.tencent.mm.cb.a.fromDPToPix(this.cmc, 100));
    }
  }
  
  public final boolean ctw()
  {
    AppMethodBeat.i(38353);
    if (this.eeN != null) {
      this.eeN.dismiss();
    }
    com.tencent.mm.sdk.b.a.ymk.d(this.rIL);
    if (com.tencent.mm.plugin.sns.data.i.A(this.rIy)) {
      this.rIy.recycle();
    }
    lv(false);
    AppMethodBeat.o(38353);
    return false;
  }
  
  /* Error */
  public final boolean j(int paramInt, Intent paramIntent)
  {
    // Byte code:
    //   0: ldc_w 835
    //   3: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: iload_1
    //   7: tableswitch	default:+29 -> 36, 9:+279->286, 10:+29->36, 11:+77->84, 12:+37->44
    //   37: iconst_0
    //   38: fstore_0
    //   39: invokestatic 159	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: iconst_0
    //   43: ireturn
    //   44: aload_2
    //   45: ifnull -9 -> 36
    //   48: aload_0
    //   49: aload_2
    //   50: ldc_w 837
    //   53: iconst_0
    //   54: invokevirtual 251	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   57: putfield 110	com/tencent/mm/plugin/sns/ui/ac:rIC	Z
    //   60: aload_0
    //   61: getfield 110	com/tencent/mm/plugin/sns/ui/ac:rIC	Z
    //   64: ifeq +12 -> 76
    //   67: aload_0
    //   68: invokevirtual 839	com/tencent/mm/plugin/sns/ui/ac:ctO	()V
    //   71: aload_0
    //   72: iconst_1
    //   73: invokespecial 832	com/tencent/mm/plugin/sns/ui/ac:lv	(Z)V
    //   76: ldc_w 835
    //   79: invokestatic 159	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   82: iconst_1
    //   83: ireturn
    //   84: aload_2
    //   85: ldc_w 841
    //   88: invokevirtual 845	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   91: checkcast 847	com/tencent/mm/plugin/mmsight/SightCaptureResult
    //   94: astore 4
    //   96: aload 4
    //   98: ifnull -62 -> 36
    //   101: aload 4
    //   103: getfield 850	com/tencent/mm/plugin/mmsight/SightCaptureResult:oFG	Z
    //   106: ifne +113 -> 219
    //   109: aload_0
    //   110: iconst_0
    //   111: putfield 110	com/tencent/mm/plugin/sns/ui/ac:rIC	Z
    //   114: aload_0
    //   115: aload 4
    //   117: getfield 853	com/tencent/mm/plugin/mmsight/SightCaptureResult:oFI	Ljava/lang/String;
    //   120: putfield 85	com/tencent/mm/plugin/sns/ui/ac:videoPath	Ljava/lang/String;
    //   123: aload_0
    //   124: aload 4
    //   126: getfield 856	com/tencent/mm/plugin/mmsight/SightCaptureResult:oFJ	Ljava/lang/String;
    //   129: putfield 83	com/tencent/mm/plugin/sns/ui/ac:thumbPath	Ljava/lang/String;
    //   132: aload 4
    //   134: getfield 859	com/tencent/mm/plugin/mmsight/SightCaptureResult:oFL	Ljava/lang/String;
    //   137: invokestatic 422	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   140: ifne +64 -> 204
    //   143: aload_0
    //   144: aload 4
    //   146: getfield 859	com/tencent/mm/plugin/mmsight/SightCaptureResult:oFL	Ljava/lang/String;
    //   149: putfield 87	com/tencent/mm/plugin/sns/ui/ac:cqq	Ljava/lang/String;
    //   152: aload_0
    //   153: getfield 156	com/tencent/mm/plugin/sns/ui/ac:cmc	Lcom/tencent/mm/ui/MMActivity;
    //   156: instanceof 861
    //   159: ifeq +37 -> 196
    //   162: aload_0
    //   163: getfield 156	com/tencent/mm/plugin/sns/ui/ac:cmc	Lcom/tencent/mm/ui/MMActivity;
    //   166: checkcast 861	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   169: aload_0
    //   170: getfield 85	com/tencent/mm/plugin/sns/ui/ac:videoPath	Ljava/lang/String;
    //   173: aload_0
    //   174: getfield 83	com/tencent/mm/plugin/sns/ui/ac:thumbPath	Ljava/lang/String;
    //   177: aload_0
    //   178: getfield 87	com/tencent/mm/plugin/sns/ui/ac:cqq	Ljava/lang/String;
    //   181: aconst_null
    //   182: iconst_1
    //   183: invokevirtual 864	com/tencent/mm/plugin/sns/ui/SnsUploadUI:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BZ)V
    //   186: aload_0
    //   187: getfield 156	com/tencent/mm/plugin/sns/ui/ac:cmc	Lcom/tencent/mm/ui/MMActivity;
    //   190: checkcast 861	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   193: invokevirtual 867	com/tencent/mm/plugin/sns/ui/SnsUploadUI:cwE	()V
    //   196: ldc_w 835
    //   199: invokestatic 159	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   202: iconst_1
    //   203: ireturn
    //   204: aload_0
    //   205: aload 4
    //   207: getfield 853	com/tencent/mm/plugin/mmsight/SightCaptureResult:oFI	Ljava/lang/String;
    //   210: invokestatic 870	com/tencent/mm/vfs/e:avP	(Ljava/lang/String;)Ljava/lang/String;
    //   213: putfield 87	com/tencent/mm/plugin/sns/ui/ac:cqq	Ljava/lang/String;
    //   216: goto -64 -> 152
    //   219: aload_0
    //   220: iconst_1
    //   221: putfield 110	com/tencent/mm/plugin/sns/ui/ac:rIC	Z
    //   224: aload_2
    //   225: ldc_w 872
    //   228: iconst_0
    //   229: invokevirtual 375	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   232: istore_1
    //   233: aload 4
    //   235: getfield 875	com/tencent/mm/plugin/mmsight/SightCaptureResult:oFO	Ljava/lang/String;
    //   238: astore_2
    //   239: aload_0
    //   240: getfield 156	com/tencent/mm/plugin/sns/ui/ac:cmc	Lcom/tencent/mm/ui/MMActivity;
    //   243: instanceof 861
    //   246: ifeq +32 -> 278
    //   249: aload_0
    //   250: getfield 156	com/tencent/mm/plugin/sns/ui/ac:cmc	Lcom/tencent/mm/ui/MMActivity;
    //   253: checkcast 861	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   256: aload_2
    //   257: iconst_1
    //   258: iload_1
    //   259: aconst_null
    //   260: aconst_null
    //   261: aload_0
    //   262: getfield 377	com/tencent/mm/plugin/sns/ui/ac:rGd	I
    //   265: invokevirtual 878	com/tencent/mm/plugin/sns/ui/SnsUploadUI:a	(Ljava/lang/String;ZILjava/util/ArrayList;Ljava/util/ArrayList;I)V
    //   268: aload_0
    //   269: getfield 156	com/tencent/mm/plugin/sns/ui/ac:cmc	Lcom/tencent/mm/ui/MMActivity;
    //   272: checkcast 861	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   275: invokevirtual 867	com/tencent/mm/plugin/sns/ui/SnsUploadUI:cwE	()V
    //   278: ldc_w 835
    //   281: invokestatic 159	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   284: iconst_1
    //   285: ireturn
    //   286: aload_2
    //   287: ldc_w 880
    //   290: invokevirtual 884	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   293: astore 4
    //   295: aload 4
    //   297: ifnull +11 -> 308
    //   300: aload 4
    //   302: invokevirtual 889	java/util/ArrayList:size	()I
    //   305: ifgt +16 -> 321
    //   308: aload_2
    //   309: ldc_w 891
    //   312: invokevirtual 341	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   315: invokestatic 422	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   318: ifne +384 -> 702
    //   321: aload_0
    //   322: iconst_0
    //   323: putfield 110	com/tencent/mm/plugin/sns/ui/ac:rIC	Z
    //   326: aload 4
    //   328: ifnull +124 -> 452
    //   331: aload 4
    //   333: invokevirtual 889	java/util/ArrayList:size	()I
    //   336: ifle +116 -> 452
    //   339: aload 4
    //   341: iconst_0
    //   342: invokevirtual 895	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   345: checkcast 517	java/lang/String
    //   348: astore 4
    //   350: aload_2
    //   351: ldc_w 897
    //   354: invokevirtual 341	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   357: astore 5
    //   359: aload 5
    //   361: invokestatic 422	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   364: ifne +14 -> 378
    //   367: aload 5
    //   369: astore_2
    //   370: aload 5
    //   372: invokestatic 482	com/tencent/mm/vfs/e:cN	(Ljava/lang/String;)Z
    //   375: ifne +180 -> 555
    //   378: new 798	java/lang/StringBuilder
    //   381: dup
    //   382: invokespecial 898	java/lang/StringBuilder:<init>	()V
    //   385: invokestatic 901	com/tencent/mm/plugin/sns/model/ag:getAccSnsTmpPath	()Ljava/lang/String;
    //   388: invokevirtual 806	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: aload 4
    //   393: invokestatic 870	com/tencent/mm/vfs/e:avP	(Ljava/lang/String;)Ljava/lang/String;
    //   396: invokevirtual 806	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: invokevirtual 820	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   402: astore_2
    //   403: new 114	android/media/MediaMetadataRetriever
    //   406: dup
    //   407: invokespecial 115	android/media/MediaMetadataRetriever:<init>	()V
    //   410: astore 5
    //   412: aload 5
    //   414: aload 4
    //   416: invokevirtual 751	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   419: aload 5
    //   421: lconst_0
    //   422: invokevirtual 904	android/media/MediaMetadataRetriever:getFrameAtTime	(J)Landroid/graphics/Bitmap;
    //   425: astore 6
    //   427: aload 6
    //   429: ifnonnull +35 -> 464
    //   432: ldc 169
    //   434: ldc_w 906
    //   437: invokestatic 908	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   440: aload 5
    //   442: invokevirtual 911	android/media/MediaMetadataRetriever:release	()V
    //   445: goto -409 -> 36
    //   448: astore_2
    //   449: goto -413 -> 36
    //   452: aload_2
    //   453: ldc_w 891
    //   456: invokevirtual 341	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   459: astore 4
    //   461: goto -111 -> 350
    //   464: ldc 169
    //   466: ldc_w 913
    //   469: iconst_2
    //   470: anewarray 4	java/lang/Object
    //   473: dup
    //   474: iconst_0
    //   475: aload 6
    //   477: invokevirtual 916	android/graphics/Bitmap:getWidth	()I
    //   480: invokestatic 772	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   483: aastore
    //   484: dup
    //   485: iconst_1
    //   486: aload 6
    //   488: invokevirtual 919	android/graphics/Bitmap:getHeight	()I
    //   491: invokestatic 772	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   494: aastore
    //   495: invokestatic 444	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   498: aload 6
    //   500: bipush 80
    //   502: getstatic 925	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   505: aload_2
    //   506: iconst_1
    //   507: invokestatic 930	com/tencent/mm/sdk/platformtools/d:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)V
    //   510: aload_2
    //   511: invokestatic 934	com/tencent/mm/sdk/platformtools/d:aoT	(Ljava/lang/String;)Landroid/graphics/BitmapFactory$Options;
    //   514: astore 6
    //   516: ldc 169
    //   518: ldc_w 936
    //   521: iconst_2
    //   522: anewarray 4	java/lang/Object
    //   525: dup
    //   526: iconst_0
    //   527: aload 6
    //   529: getfield 941	android/graphics/BitmapFactory$Options:outWidth	I
    //   532: invokestatic 772	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   535: aastore
    //   536: dup
    //   537: iconst_1
    //   538: aload 6
    //   540: getfield 944	android/graphics/BitmapFactory$Options:outHeight	I
    //   543: invokestatic 772	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   546: aastore
    //   547: invokestatic 444	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   550: aload 5
    //   552: invokevirtual 911	android/media/MediaMetadataRetriever:release	()V
    //   555: aload_0
    //   556: aload 4
    //   558: invokestatic 870	com/tencent/mm/vfs/e:avP	(Ljava/lang/String;)Ljava/lang/String;
    //   561: putfield 87	com/tencent/mm/plugin/sns/ui/ac:cqq	Ljava/lang/String;
    //   564: ldc 169
    //   566: ldc_w 946
    //   569: iconst_4
    //   570: anewarray 4	java/lang/Object
    //   573: dup
    //   574: iconst_0
    //   575: aload 4
    //   577: aastore
    //   578: dup
    //   579: iconst_1
    //   580: aload_2
    //   581: aastore
    //   582: dup
    //   583: iconst_2
    //   584: aload 4
    //   586: invokestatic 814	com/tencent/mm/vfs/e:avI	(Ljava/lang/String;)J
    //   589: invokestatic 951	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   592: aastore
    //   593: dup
    //   594: iconst_3
    //   595: aload_2
    //   596: invokestatic 814	com/tencent/mm/vfs/e:avI	(Ljava/lang/String;)J
    //   599: invokestatic 951	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   602: aastore
    //   603: invokestatic 444	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   606: aload_0
    //   607: getfield 156	com/tencent/mm/plugin/sns/ui/ac:cmc	Lcom/tencent/mm/ui/MMActivity;
    //   610: instanceof 861
    //   613: ifeq +32 -> 645
    //   616: aload_0
    //   617: getfield 156	com/tencent/mm/plugin/sns/ui/ac:cmc	Lcom/tencent/mm/ui/MMActivity;
    //   620: checkcast 861	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   623: aload 4
    //   625: aload_2
    //   626: aload_0
    //   627: getfield 87	com/tencent/mm/plugin/sns/ui/ac:cqq	Ljava/lang/String;
    //   630: aconst_null
    //   631: iconst_0
    //   632: invokevirtual 864	com/tencent/mm/plugin/sns/ui/SnsUploadUI:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BZ)V
    //   635: aload_0
    //   636: getfield 156	com/tencent/mm/plugin/sns/ui/ac:cmc	Lcom/tencent/mm/ui/MMActivity;
    //   639: checkcast 861	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   642: invokevirtual 867	com/tencent/mm/plugin/sns/ui/SnsUploadUI:cwE	()V
    //   645: ldc_w 835
    //   648: invokestatic 159	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   651: iconst_1
    //   652: ireturn
    //   653: astore 6
    //   655: ldc 169
    //   657: ldc_w 953
    //   660: iconst_1
    //   661: anewarray 4	java/lang/Object
    //   664: dup
    //   665: iconst_0
    //   666: aload 6
    //   668: invokevirtual 462	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   671: aastore
    //   672: invokestatic 437	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   675: aload 5
    //   677: invokevirtual 911	android/media/MediaMetadataRetriever:release	()V
    //   680: goto -125 -> 555
    //   683: astore 5
    //   685: goto -130 -> 555
    //   688: astore_2
    //   689: aload 5
    //   691: invokevirtual 911	android/media/MediaMetadataRetriever:release	()V
    //   694: ldc_w 835
    //   697: invokestatic 159	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   700: aload_2
    //   701: athrow
    //   702: aload_0
    //   703: iconst_1
    //   704: putfield 110	com/tencent/mm/plugin/sns/ui/ac:rIC	Z
    //   707: aload_2
    //   708: ldc_w 955
    //   711: invokevirtual 884	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   714: astore 4
    //   716: aload 4
    //   718: ifnull +11 -> 729
    //   721: aload 4
    //   723: invokevirtual 889	java/util/ArrayList:size	()I
    //   726: ifne +19 -> 745
    //   729: ldc 169
    //   731: ldc_w 957
    //   734: invokestatic 176	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   737: ldc_w 835
    //   740: invokestatic 159	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   743: iconst_0
    //   744: ireturn
    //   745: new 886	java/util/ArrayList
    //   748: dup
    //   749: invokespecial 958	java/util/ArrayList:<init>	()V
    //   752: astore 5
    //   754: aload 4
    //   756: invokevirtual 959	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   759: astore 6
    //   761: aload 6
    //   763: invokeinterface 511 1 0
    //   768: ifeq +76 -> 844
    //   771: aload 6
    //   773: invokeinterface 515 1 0
    //   778: checkcast 517	java/lang/String
    //   781: astore 7
    //   783: aload 7
    //   785: invokestatic 965	com/tencent/mm/compatible/util/Exif:fromFile	(Ljava/lang/String;)Lcom/tencent/mm/compatible/util/Exif;
    //   788: invokevirtual 969	com/tencent/mm/compatible/util/Exif:getLocation	()Lcom/tencent/mm/compatible/util/Exif$a;
    //   791: astore 8
    //   793: aload 8
    //   795: ifnull -34 -> 761
    //   798: aload 5
    //   800: ldc_w 971
    //   803: iconst_3
    //   804: anewarray 4	java/lang/Object
    //   807: dup
    //   808: iconst_0
    //   809: aload 7
    //   811: aastore
    //   812: dup
    //   813: iconst_1
    //   814: aload 8
    //   816: getfield 977	com/tencent/mm/compatible/util/Exif$a:latitude	D
    //   819: invokestatic 982	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   822: aastore
    //   823: dup
    //   824: iconst_2
    //   825: aload 8
    //   827: getfield 985	com/tencent/mm/compatible/util/Exif$a:longitude	D
    //   830: invokestatic 982	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   833: aastore
    //   834: invokestatic 989	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   837: invokevirtual 990	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   840: pop
    //   841: goto -80 -> 761
    //   844: aload_2
    //   845: ldc_w 992
    //   848: iconst_0
    //   849: invokevirtual 251	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   852: istore_3
    //   853: aload_2
    //   854: ldc_w 872
    //   857: iconst_0
    //   858: invokevirtual 375	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   861: istore_1
    //   862: aload_0
    //   863: getfield 156	com/tencent/mm/plugin/sns/ui/ac:cmc	Lcom/tencent/mm/ui/MMActivity;
    //   866: instanceof 861
    //   869: ifeq -833 -> 36
    //   872: aload_0
    //   873: getfield 156	com/tencent/mm/plugin/sns/ui/ac:cmc	Lcom/tencent/mm/ui/MMActivity;
    //   876: checkcast 861	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   879: aconst_null
    //   880: iload_3
    //   881: iload_1
    //   882: aload 4
    //   884: aload 5
    //   886: aload_0
    //   887: getfield 377	com/tencent/mm/plugin/sns/ui/ac:rGd	I
    //   890: invokevirtual 878	com/tencent/mm/plugin/sns/ui/SnsUploadUI:a	(Ljava/lang/String;ZILjava/util/ArrayList;Ljava/util/ArrayList;I)V
    //   893: aload_0
    //   894: getfield 156	com/tencent/mm/plugin/sns/ui/ac:cmc	Lcom/tencent/mm/ui/MMActivity;
    //   897: checkcast 861	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   900: invokevirtual 867	com/tencent/mm/plugin/sns/ui/SnsUploadUI:cwE	()V
    //   903: goto -867 -> 36
    //   906: astore 5
    //   908: goto -353 -> 555
    //   911: astore 4
    //   913: goto -219 -> 694
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	916	0	this	ac
    //   0	916	1	paramInt	int
    //   0	916	2	paramIntent	Intent
    //   852	29	3	bool	boolean
    //   94	789	4	localObject1	Object
    //   911	1	4	localException1	Exception
    //   357	319	5	localObject2	Object
    //   683	7	5	localException2	Exception
    //   752	133	5	localArrayList	java.util.ArrayList
    //   906	1	5	localException3	Exception
    //   425	114	6	localObject3	Object
    //   653	14	6	localException4	Exception
    //   759	13	6	localIterator	Iterator
    //   781	29	7	str	String
    //   791	35	8	locala	com.tencent.mm.compatible.util.Exif.a
    // Exception table:
    //   from	to	target	type
    //   440	445	448	java/lang/Exception
    //   412	427	653	java/lang/Exception
    //   432	440	653	java/lang/Exception
    //   464	550	653	java/lang/Exception
    //   675	680	683	java/lang/Exception
    //   412	427	688	finally
    //   432	440	688	finally
    //   464	550	688	finally
    //   655	675	688	finally
    //   550	555	906	java/lang/Exception
    //   689	694	911	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ac
 * JD-Core Version:    0.7.0.1
 */