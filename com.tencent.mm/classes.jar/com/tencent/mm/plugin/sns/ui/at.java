package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.nj;
import com.tencent.mm.b.g;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.compatible.util.Exif.a;
import com.tencent.mm.model.cn;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.comm.b.e.a;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.c;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.bf;
import com.tencent.mm.plugin.sns.model.bg;
import com.tencent.mm.plugin.sns.statistics.h.a;
import com.tencent.mm.plugin.sns.statistics.h.a.a;
import com.tencent.mm.plugin.sns.statistics.n;
import com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.djv;
import com.tencent.mm.protocal.protobuf.dmb;
import com.tencent.mm.protocal.protobuf.dna;
import com.tencent.mm.protocal.protobuf.fdr;
import com.tencent.mm.protocal.protobuf.ffa;
import com.tencent.mm.protocal.protobuf.ffw;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.tools.b.a;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import org.b.d.i;

public class at
  implements ag
{
  private int QzF;
  private com.tencent.mm.modelsns.l RcD;
  private String RcE;
  private int Rcy;
  private boolean Rei;
  private boolean Rej;
  private WXMediaMessage Rek;
  private String RfQ;
  private boolean RfR;
  b RhW;
  ac RhX;
  Map<String, Exif.a> RhY;
  private Map<String, ffa> RhZ;
  private int Ria;
  private boolean Rib;
  djv Ric;
  private String appId;
  private String appName;
  int lyL;
  protected MMActivity lzt;
  private String mSessionId;
  
  public at(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(98173);
    this.RhW = new b();
    this.RfR = false;
    this.RhY = new HashMap();
    this.RhZ = new HashMap();
    this.Ria = 0;
    this.Rei = false;
    this.Rib = false;
    this.Rej = false;
    this.Rek = null;
    this.RcD = null;
    this.QzF = 1;
    this.RcE = "";
    this.lyL = 9;
    this.lzt = paramMMActivity;
    AppMethodBeat.o(98173);
  }
  
  private static bg a(bg parambg, List<com.tencent.mm.plugin.sns.data.s> paramList)
  {
    AppMethodBeat.i(98181);
    parambg.kC(paramList);
    AppMethodBeat.o(98181);
    return parambg;
  }
  
  private void alI(int paramInt)
  {
    AppMethodBeat.i(98188);
    nj localnj = new nj().aIU();
    localnj.jeX = paramInt;
    localnj.vH(this.RfQ).bMH();
    AppMethodBeat.o(98188);
  }
  
  private void b(bg parambg)
  {
    AppMethodBeat.i(98182);
    int i = parambg.FW();
    if (this.RcD != null)
    {
      this.RcD.wQ(i);
      com.tencent.mm.plugin.sns.statistics.l.QGY.c(this.RcD);
    }
    if ((this.RhW != null) && (this.RhW.Rih != null) && (com.tencent.mm.plugin.sns.storage.aa.hlm())) {
      com.tencent.mm.plugin.report.service.h.OAn.b(12834, new Object[] { Integer.valueOf(this.RhW.Rih.size()) });
    }
    parambg = new Intent();
    parambg.putExtra("sns_local_id", i);
    this.lzt.setResult(-1, parambg);
    this.lzt.finish();
    al.hgx().hej();
    AppMethodBeat.o(98182);
  }
  
  private boolean bb(Bundle paramBundle)
  {
    AppMethodBeat.i(98176);
    if (paramBundle == null)
    {
      AppMethodBeat.o(98176);
      return false;
    }
    paramBundle = paramBundle.getStringArrayList("sns_media_latlong_list");
    if (paramBundle == null)
    {
      AppMethodBeat.o(98176);
      return false;
    }
    paramBundle = paramBundle.iterator();
    while (paramBundle.hasNext())
    {
      String[] arrayOfString = ((String)paramBundle.next()).split("\n");
      if (3 != arrayOfString.length)
      {
        Log.e("MicroMsg.PicWidget", "invalid params");
        AppMethodBeat.o(98176);
        return true;
      }
      try
      {
        this.RhY.put(arrayOfString[0].trim(), new Exif.a(Util.getDouble(arrayOfString[1], 0.0D), Util.getDouble(arrayOfString[2], 0.0D), 0.0D));
      }
      catch (NumberFormatException localNumberFormatException)
      {
        Log.e("MicroMsg.PicWidget", localNumberFormatException.toString());
      }
    }
    AppMethodBeat.o(98176);
    return true;
  }
  
  private void hmp()
  {
    boolean bool1 = true;
    AppMethodBeat.i(308452);
    int j = this.lyL - this.RhW.Rih.size();
    if (j <= 0)
    {
      Log.e("MicroMsg.PicWidget", "has select the max image count");
      AppMethodBeat.o(308452);
      return;
    }
    Object localObject = this.lzt.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getString("gallery", "1");
    long l = cn.bDv();
    com.tencent.mm.plugin.report.service.h.OAn.b(13822, new Object[] { Integer.valueOf(2), Integer.valueOf(2), com.tencent.mm.plugin.sns.data.t.heR(), Long.valueOf(l) });
    if (((String)localObject).equalsIgnoreCase("0")) {
      com.tencent.mm.pluginsdk.ui.tools.t.g(this.lzt, false);
    }
    for (;;)
    {
      alI(2);
      AppMethodBeat.o(308452);
      return;
      if (j >= this.lyL) {
        break;
      }
      localObject = new Intent();
      ((Intent)localObject).putExtra("key_can_select_video_and_pic", true);
      com.tencent.mm.pluginsdk.ui.tools.t.a(this.lzt, 9, j, 4, 1, SnsTimeLineUI.hpL(), (Intent)localObject);
    }
    localObject = new Intent();
    ((Intent)localObject).putExtra("key_edit_video_max_time_length", com.tencent.mm.modelcontrol.e.bIg().bIk().duration);
    boolean bool2 = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yWw, false);
    int i;
    if ((com.tencent.mm.kernel.h.baE().ban().getInt(com.tencent.mm.storage.at.a.acWc, 0) == 1) || (bool2))
    {
      i = 1;
      label264:
      if (i != 0) {
        break label303;
      }
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("key_can_select_video_and_pic", bool1);
      com.tencent.mm.pluginsdk.ui.tools.t.a(this.lzt, 9, j, 4, 3, SnsTimeLineUI.hpL(), (Intent)localObject);
      break;
      i = 0;
      break label264;
      label303:
      bool1 = false;
    }
  }
  
  public final View a(View paramView1, View paramView2, DynamicGridView paramDynamicGridView, View paramView3)
  {
    AppMethodBeat.i(98179);
    boolean bool;
    if (this.RhX == null)
    {
      MMActivity localMMActivity = this.lzt;
      ArrayList localArrayList = this.RhW.Rih;
      int i = this.lyL;
      ac.a local1 = new ac.a()
      {
        public final void VB(int paramAnonymousInt)
        {
          AppMethodBeat.i(98155);
          Log.d("MicroMsg.PicWidget", "I click");
          if (paramAnonymousInt < 0)
          {
            at.this.hne();
            AppMethodBeat.o(98155);
            return;
          }
          Intent localIntent = new Intent();
          localIntent.setClass(at.this.lzt, SnsUploadBrowseUI.class);
          localIntent.putExtra("sns_gallery_position", paramAnonymousInt);
          localIntent.putExtra("sns_gallery_temp_paths", at.this.RhW.Rih);
          localIntent.putExtra("key_from_scene", 7);
          at.this.lzt.startActivityForResult(localIntent, 7);
          AppMethodBeat.o(98155);
        }
      };
      com.tencent.mm.plugin.sns.ui.previewimageview.c.a local2 = new com.tencent.mm.plugin.sns.ui.previewimageview.c.a()
      {
        public final void lF(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(98156);
          at.b localb = at.this.RhW;
          String str;
          if ((paramAnonymousInt1 != paramAnonymousInt2) && (localb.Rih.size() > paramAnonymousInt1))
          {
            str = (String)localb.Rih.remove(paramAnonymousInt1);
            if (paramAnonymousInt2 >= localb.Rih.size()) {
              break label95;
            }
            localb.Rih.add(paramAnonymousInt2, str);
          }
          for (;;)
          {
            at.this.lzt.getIntent().putExtra("sns_kemdia_path_list", at.this.RhW.Rih);
            AppMethodBeat.o(98156);
            return;
            label95:
            localb.Rih.add(str);
          }
        }
        
        public final void removeItem(int paramAnonymousInt)
        {
          AppMethodBeat.i(98157);
          at.b localb = at.this.RhW;
          if (localb.Rih.size() > paramAnonymousInt) {
            localb.Rih.remove(paramAnonymousInt);
          }
          if ((at.this.lzt instanceof SnsUploadUI)) {
            ((SnsUploadUI)at.this.lzt).hqt();
          }
          at.this.lzt.getIntent().putExtra("sns_kemdia_path_list", at.this.RhW.Rih);
          at.this.lzt.getIntent().putExtra("sns_kemdia_path", "");
          ((com.tencent.mm.plugin.sns.ui.previewimageview.e)at.this.RhX).amE(at.this.RhW.Rih.size());
          AppMethodBeat.o(98157);
        }
      };
      if (!this.Rib)
      {
        bool = true;
        this.RhX = new com.tencent.mm.plugin.sns.ui.previewimageview.e(paramView1, paramView2, paramView3, localMMActivity, localArrayList, i, paramDynamicGridView, local1, local2, bool);
      }
    }
    for (;;)
    {
      paramView1 = this.RhX.getView();
      AppMethodBeat.o(98179);
      return paramView1;
      bool = false;
      break;
      this.RhX.ah(this.RhW.Rih, this.lyL);
    }
  }
  
  protected void a(bg parambg) {}
  
  public final boolean a(int paramInt1, int paramInt2, i parami, String paramString1, List<String> paramList1, djv paramdjv, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(98183);
    paramLinkedList = new LinkedList();
    paramString2 = this.RhW.Rih.iterator();
    int i = 0;
    Object localObject1;
    Object localObject2;
    label109:
    Object localObject3;
    if (paramString2.hasNext())
    {
      localObject1 = (String)paramString2.next();
      localObject2 = new com.tencent.mm.plugin.sns.data.s((String)localObject1, 2);
      ((com.tencent.mm.plugin.sns.data.s)localObject2).type = 2;
      ((com.tencent.mm.plugin.sns.data.s)localObject2).Qoh = paramInt1;
      int j;
      if (i == 0)
      {
        ((com.tencent.mm.plugin.sns.data.s)localObject2).Qog = paramInt2;
        if (parami != null)
        {
          ((com.tencent.mm.plugin.sns.data.s)localObject2).Qoi = parami.token;
          ((com.tencent.mm.plugin.sns.data.s)localObject2).Qoj = parami.aaTQ;
        }
        localObject3 = this.RhW;
        if (!((b)localObject3).Rij.containsKey(localObject1)) {
          break label248;
        }
        j = ((Integer)((b)localObject3).Rij.get(localObject1)).intValue();
        label150:
        ((com.tencent.mm.plugin.sns.data.s)localObject2).Qof = j;
        ((com.tencent.mm.plugin.sns.data.s)localObject2).desc = paramString1;
        localObject3 = this.RhW;
        if ((Util.isNullOrNil((String)localObject1)) || (!((b)localObject3).Rii.containsKey(localObject1))) {
          break label254;
        }
      }
      label248:
      label254:
      for (boolean bool = ((Boolean)((b)localObject3).Rii.get(localObject1)).booleanValue();; bool = false)
      {
        ((com.tencent.mm.plugin.sns.data.s)localObject2).Qol = bool;
        paramLinkedList.add(localObject2);
        i += 1;
        break;
        ((com.tencent.mm.plugin.sns.data.s)localObject2).Qog = 0;
        break label109;
        j = 0;
        break label150;
      }
    }
    paramString2 = com.tencent.mm.plugin.sns.statistics.h.QFO;
    kotlin.g.b.s.u(paramLinkedList, "paths");
    paramString2 = com.tencent.mm.plugin.comm.b.e.xfd;
    e.a.a("SnsPublishProcess", "mediaMD5_", (kotlin.g.a.a)new h.a.a(paramLinkedList));
    paramString2 = new LinkedList();
    if (paramList1 != null)
    {
      new LinkedList();
      localObject1 = com.tencent.mm.pluginsdk.platformtools.a.iIX();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        localObject2 = (String)paramList1.next();
        if ((localObject1 != null) && (!((List)localObject1).contains(localObject2)))
        {
          localObject3 = new ffw();
          ((ffw)localObject3).UserName = ((String)localObject2);
          paramString2.add(localObject3);
        }
      }
    }
    paramList1 = new bg(1, this.lzt);
    paramPInt.value = paramList1.cIh;
    if (parami != null) {
      paramList1.mm(parami.token, parami.aaTQ);
    }
    if (paramInt3 > com.tencent.mm.plugin.sns.d.a.Qkq) {
      paramList1.akL(3);
    }
    paramList1.aYM(paramString1).a(paramdjv).bU(paramString2).akO(paramInt1).akP(paramInt2);
    if (paramBoolean) {
      paramList1.akR(1);
    }
    for (;;)
    {
      if (!Util.isNullOrNil(this.appId)) {
        paramList1.aYS(this.appId);
      }
      if (!Util.isNullOrNil(this.appName)) {
        paramList1.aYT(Util.nullAs(this.appName, ""));
      }
      paramList1.akQ(this.Rcy);
      if (this.Rei) {
        paramList1.akQ(5);
      }
      if ((this.Rej) && (this.Rek != null))
      {
        paramList1.aYN(this.Rek.mediaTagName);
        paramList1.aY(this.appId, this.Rek.messageExt, this.Rek.messageAction);
      }
      paramList1.i(null, null, null, paramInt4, paramInt5);
      paramList1.df(this.QzF, this.RcE);
      paramList1.kB(paramList2);
      paramList1.setSessionId(this.mSessionId);
      a(paramList1);
      if ((paramdjv != null) && (paramdjv.score != 0))
      {
        paramInt1 = paramdjv.score;
        parami = paramdjv.ZWG;
        paramList1.QzB.aaTY = new fdr();
        paramList1.QzB.aaTY.abDt = paramInt1;
        paramList1.QzB.aaTY.abDr = parami;
      }
      Log.i("MicroMsg.PicWidget", "commit pic size %d, browseImageCount:%d", new Object[] { Integer.valueOf(paramLinkedList.size()), Integer.valueOf(this.Ria) });
      com.tencent.mm.plugin.report.service.h.OAn.b(11602, new Object[] { Integer.valueOf(this.Ria), Integer.valueOf(paramLinkedList.size()) });
      parami = paramLinkedList.iterator();
      while (parami.hasNext())
      {
        paramString1 = (com.tencent.mm.plugin.sns.data.s)parami.next();
        Log.i("MicroMsg.PicWidget", "commit path  %s len: %d", new Object[] { paramString1.path, Long.valueOf(y.bEl(paramString1.path)) });
      }
      paramList1.akR(0);
    }
    if (this.lzt.getIntent().getBooleanExtra("is_tiger2022", false)) {
      paramList1.kLL();
    }
    paramString1 = paramLinkedList.iterator();
    if (paramString1.hasNext())
    {
      paramdjv = ((com.tencent.mm.plugin.sns.data.s)paramString1.next()).path;
      parami = (ffa)this.RhZ.get(paramdjv);
      if (parami != null) {
        break label1434;
      }
      parami = new ffa();
    }
    label1035:
    label1434:
    for (;;)
    {
      if ((this.Ric != null) && ((this.Ric.ZaH != 0.0F) || (this.Ric.ZaG != 0.0F)))
      {
        parami.abEL = this.Ric.ZaH;
        parami.abEM = this.Ric.ZaG;
        parami.ReZ = this.Ric.ReZ;
        parami.ReY = this.Ric.ReY;
        paramdjv = (Exif.a)this.RhY.get(paramdjv);
        if ((paramdjv == null) || ((paramdjv.latitude == 0.0D) && (paramdjv.longitude == 0.0D))) {
          break label1341;
        }
        parami.abEJ = ((float)paramdjv.latitude);
      }
      for (parami.abEK = ((float)paramdjv.longitude);; parami.abEK = -1000.0F)
      {
        paramdjv = new StringBuffer();
        paramdjv.append("||index: " + paramList1.QzB.aaTT.size());
        paramdjv.append("||item poi lat " + parami.abEL + " " + parami.abEM);
        paramdjv.append("||item pic lat " + parami.abEJ + " " + parami.abEK);
        paramdjv.append("||item exitime:" + parami.abEO + " filetime: " + parami.abEP);
        paramdjv.append("||item source: " + parami.abEN);
        Log.i("MicroMsg.UploadPackHelper", "addSnsReportInfo item : " + paramdjv.toString());
        paramList1.QzB.aaTT.add(parami);
        break;
        parami.abEL = -1000.0F;
        parami.abEM = -1000.0F;
        break label1035;
        label1341:
        parami.abEJ = -1000.0F;
      }
      if (paramLinkedList.size() <= 1)
      {
        a(paramList1, paramLinkedList);
        b(paramList1);
      }
      for (;;)
      {
        com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(98159);
            long l = System.currentTimeMillis();
            Iterator localIterator = at.this.RhW.Rih.iterator();
            Exif localExif;
            int i;
            label78:
            String str2;
            int k;
            int j;
            if (localIterator.hasNext())
            {
              String str1 = (String)localIterator.next();
              localExif = Exif.fromFile(str1);
              if ((localExif.latitude >= 0.0D) && (localExif.longitude >= 0.0D))
              {
                i = 1;
                str2 = localExif.model;
                k = localExif.imageWidth;
                j = localExif.imageHeight;
                if ((k > 0) && (j > 0)) {
                  break label235;
                }
                BitmapFactory.Options localOptions = new BitmapFactory.Options();
                localOptions.inJustDecodeBounds = true;
                BitmapUtil.decodeFile(str1, localOptions);
                k = localOptions.outWidth;
                j = localOptions.outHeight;
              }
            }
            label235:
            for (;;)
            {
              int m = (int)localExif.getUxtimeDatatimeOriginal();
              com.tencent.mm.plugin.report.service.h.OAn.b(15523, new Object[] { Integer.valueOf(i), str2, Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(m) });
              break;
              i = 0;
              break label78;
              Log.d("MicroMsg.PicWidget", "report photo info cost " + (System.currentTimeMillis() - l));
              AppMethodBeat.o(98159);
              return;
            }
          }
        });
        AppMethodBeat.o(98183);
        return true;
        new a(paramList1, paramLinkedList).A(new String[] { "" });
      }
    }
  }
  
  public void aZ(Bundle paramBundle)
  {
    AppMethodBeat.i(98174);
    this.RcD = com.tencent.mm.modelsns.l.y(this.lzt.getIntent());
    this.RfR = this.lzt.getIntent().getBooleanExtra("Kis_take_photo", false);
    this.appId = Util.nullAs(this.lzt.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.appName = Util.nullAs(this.lzt.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.Rei = this.lzt.getIntent().getBooleanExtra("KThrid_app", false);
    this.Rib = this.lzt.getIntent().getBooleanExtra("KBlockAdd", false);
    this.Rej = this.lzt.getIntent().getBooleanExtra("KSnsAction", false);
    this.Rcy = this.lzt.getIntent().getIntExtra("Ksnsupload_source", 0);
    this.mSessionId = Util.nullAs(this.lzt.getIntent().getStringExtra("reportSessionId"), "");
    this.RfQ = this.lzt.getIntent().getStringExtra("KSessionID");
    Object localObject1 = this.lzt.getIntent().getBundleExtra("Ksnsupload_timeline");
    if (localObject1 != null) {
      this.Rek = new SendMessageToWX.Req((Bundle)localObject1).message;
    }
    Object localObject3 = this.lzt.getIntent().getStringExtra("sns_kemdia_path");
    Object localObject4 = this.lzt.getIntent().getByteArrayExtra("Ksnsupload_imgbuf");
    localObject1 = localObject4;
    if (localObject4 == null)
    {
      localObject1 = localObject4;
      if (this.Rek != null)
      {
        localObject1 = localObject4;
        if (this.Rek.mediaObject != null)
        {
          localObject1 = localObject4;
          if ((this.Rek.mediaObject instanceof WXImageObject)) {
            localObject1 = ((WXImageObject)this.Rek.mediaObject).imageData;
          }
        }
      }
    }
    if ((Util.isNullOrNil((String)localObject3)) && (!Util.isNullOrNil((byte[])localObject1)))
    {
      localObject3 = al.getAccSnsTmpPath() + g.getMessageDigest(new StringBuilder(" ").append(System.currentTimeMillis()).toString().getBytes());
      y.deleteFile((String)localObject3);
      y.f((String)localObject3, (byte[])localObject1, localObject1.length);
    }
    label497:
    label758:
    Object localObject2;
    for (localObject1 = localObject3;; localObject2 = localObject3)
    {
      int j = this.lzt.getIntent().getIntExtra("KFilterId", 0);
      boolean bool;
      if (paramBundle == null)
      {
        localObject3 = null;
        bb(paramBundle);
        bool = bb(this.lzt.getIntent().getExtras());
        this.Ria = 0;
        if (Util.isNullOrNil((String)localObject3)) {
          break label538;
        }
        this.RhW.baA((String)localObject3);
      }
      for (;;)
      {
        if (this.lzt.getIntent().getBooleanExtra("SendAppMessageWrapper_TokenValid", true))
        {
          this.QzF = 1;
          this.RcE = Util.nullAs(this.lzt.getIntent().getStringExtra("SendAppMessageWrapper_PkgName"), "");
          AppMethodBeat.o(98174);
          return;
          localObject3 = paramBundle.getString("sns_kemdia_path_list");
          break;
          label538:
          paramBundle = this.lzt.getIntent().getStringArrayListExtra("sns_kemdia_path_list");
          if (!Util.isNullOrNil(paramBundle))
          {
            paramBundle = paramBundle.iterator();
            label564:
            if (paramBundle.hasNext())
            {
              localObject1 = (String)paramBundle.next();
              Log.d("MicroMsg.PicWidget", "newPath ".concat(String.valueOf(localObject1)));
              this.RhW.z((String)localObject1, j, false);
              if (!bool)
              {
                localObject3 = Exif.fromFile((String)localObject1).getLocation();
                if (localObject3 != null) {
                  this.RhY.put(localObject1, localObject3);
                }
              }
            }
            for (;;)
            {
              try
              {
                localObject3 = new u((String)localObject1);
                localObject4 = new ffa();
                if (!this.RfR) {
                  break label758;
                }
                i = 1;
                ((ffa)localObject4).abEN = i;
                ((ffa)localObject4).abEP = (((u)localObject3).lastModified() / 1000L);
                ((ffa)localObject4).abEO = Exif.fromFile((String)localObject1).getUxtimeDatatimeOriginal();
                this.RhZ.put(localObject1, localObject4);
              }
              catch (Exception localException)
              {
                Log.e("MicroMsg.PicWidget", "get report info error " + localException.getMessage());
              }
              break label564;
              break;
              i = 2;
            }
          }
          if (!Util.isNullOrNil(localException))
          {
            paramBundle = al.getAccSnsTmpPath() + "pre_temp_sns_pic" + g.getMessageDigest(localException.getBytes());
            y.bDX(y.bEo(paramBundle));
            y.O(localException, paramBundle, false);
            if (j != -1) {
              break label996;
            }
          }
        }
      }
      label983:
      label996:
      for (int i = 0;; i = j)
      {
        this.RhW.z(paramBundle, i, this.RfR);
        if (!bool)
        {
          localObject3 = Exif.fromFile(localException).getLocation();
          if (localObject3 != null) {
            this.RhY.put(paramBundle, localObject3);
          }
        }
        for (;;)
        {
          try
          {
            localObject3 = new u(localException);
            localObject4 = new ffa();
            if (!this.RfR) {
              break label983;
            }
            i = 1;
            ((ffa)localObject4).abEN = i;
            ((ffa)localObject4).abEP = (((u)localObject3).lastModified() / 1000L);
            ((ffa)localObject4).abEO = Exif.fromFile(localException).getUxtimeDatatimeOriginal();
            this.RhZ.put(paramBundle, localObject4);
          }
          catch (Exception paramBundle)
          {
            Log.e("MicroMsg.PicWidget", "get report info error " + paramBundle.getMessage());
          }
          break;
          i = 2;
        }
        this.QzF = 0;
        break label497;
      }
    }
  }
  
  public final void ba(Bundle paramBundle)
  {
    AppMethodBeat.i(98177);
    paramBundle.putString("sns_kemdia_path_list", this.RhW.toString());
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.RhY.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localArrayList.add(String.format("%s\n%f\n%f", new Object[] { localEntry.getKey(), Double.valueOf(((Exif.a)localEntry.getValue()).latitude), Double.valueOf(((Exif.a)localEntry.getValue()).longitude) }));
    }
    paramBundle.putStringArrayList("sns_media_latlong_list", localArrayList);
    paramBundle.getString("contentdesc");
    AppMethodBeat.o(98177);
  }
  
  public final boolean d(List<String> paramList, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(98185);
    if ((paramList == null) || (paramList.size() == 0))
    {
      Log.i("MicroMsg.PicWidget", "no image selected");
      AppMethodBeat.o(98185);
      return true;
    }
    if (this.RhW.Rih.size() >= 9)
    {
      AppMethodBeat.o(98185);
      return true;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject1 = (String)paramList.next();
      if (y.ZC((String)localObject1))
      {
        String str = "pre_temp_sns_pic" + g.getMessageDigest(new StringBuilder().append((String)localObject1).append(System.currentTimeMillis()).toString().getBytes());
        com.tencent.mm.plugin.sns.storage.aa.bd(al.getAccSnsTmpPath(), (String)localObject1, str);
        Object localObject2 = com.tencent.mm.plugin.recordvideo.util.f.Obq;
        com.tencent.mm.plugin.recordvideo.util.f.aTs((String)localObject1);
        Log.d("MicroMsg.PicWidget", "newPath " + al.getAccSnsTmpPath() + str);
        boolean bool = paramBoolean;
        if (SnsTimeLineUI.hpL())
        {
          localObject2 = com.tencent.mm.plugin.sns.statistics.h.QFO;
          bool = paramBoolean;
          if (h.a.aZl((String)localObject1)) {
            bool = true;
          }
        }
        this.RhW.z(al.getAccSnsTmpPath() + str, paramInt, bool);
        ((com.tencent.mm.plugin.sns.ui.previewimageview.e)this.RhX).amE(this.RhW.Rih.size());
        this.RhX.ah(this.RhW.Rih, this.lyL);
        this.lzt.getIntent().putExtra("sns_kemdia_path_list", this.RhW.Rih);
        for (;;)
        {
          try
          {
            localObject2 = new u((String)localObject1);
            ffa localffa = new ffa();
            if (!bool) {
              continue;
            }
            i = 1;
            localffa.abEN = i;
            localffa.abEP = (((u)localObject2).lastModified() / 1000L);
            localffa.abEO = Exif.fromFile((String)localObject1).getUxtimeDatatimeOriginal();
            this.RhZ.put(al.getAccSnsTmpPath() + str, localffa);
          }
          catch (Exception localException)
          {
            int i;
            Log.e("MicroMsg.PicWidget", "get report info error " + localException.getMessage());
            continue;
          }
          localObject1 = Exif.fromFile((String)localObject1).getLocation();
          paramBoolean = bool;
          if (localObject1 == null) {
            break;
          }
          this.RhY.put(al.getAccSnsTmpPath() + str, localObject1);
          paramBoolean = bool;
          break;
          i = 2;
        }
      }
    }
    AppMethodBeat.o(98185);
    return true;
  }
  
  public final boolean hlP()
  {
    AppMethodBeat.i(98178);
    if (this.RhW != null)
    {
      b localb = this.RhW;
      if ((localb.Rih != null) && (localb.Rih.size() > 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(98178);
        return true;
      }
    }
    AppMethodBeat.o(98178);
    return false;
  }
  
  public View hlQ()
  {
    AppMethodBeat.i(98180);
    this.RhX = new PreviewImageView(this.lzt);
    if (this.Rib) {
      this.RhX.setIsShowAddImage(false);
    }
    this.RhX.setImageClick(new ac.a()
    {
      public final void VB(int paramAnonymousInt)
      {
        AppMethodBeat.i(98158);
        Log.d("MicroMsg.PicWidget", "I click");
        if (paramAnonymousInt < 0)
        {
          at.this.hne();
          AppMethodBeat.o(98158);
          return;
        }
        Intent localIntent = new Intent();
        localIntent.setClass(at.this.lzt, SnsUploadBrowseUI.class);
        localIntent.putExtra("sns_gallery_position", paramAnonymousInt);
        localIntent.putExtra("key_from_scene", 7);
        localIntent.putExtra("sns_gallery_temp_paths", at.this.RhW.Rih);
        at.this.lzt.startActivityForResult(localIntent, 7);
        AppMethodBeat.o(98158);
      }
    });
    this.RhX.ah(this.RhW.Rih, this.lyL);
    View localView = this.RhX.getView();
    AppMethodBeat.o(98180);
    return localView;
  }
  
  public final boolean hlR()
  {
    AppMethodBeat.i(308485);
    if ((this.RhW != null) && (!Util.isNullOrNil(this.RhW.Rih)))
    {
      Iterator localIterator = this.RhW.Rih.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (y.ZC((String)localIterator.next()));
    }
    for (boolean bool = false;; bool = true)
    {
      if (!bool) {
        k.s(this.lzt, b.j.sns_upload_media_not_exist, b.j.app_tip);
      }
      AppMethodBeat.o(308485);
      return bool;
    }
  }
  
  public final boolean hlS()
  {
    return true;
  }
  
  public final boolean hlT()
  {
    AppMethodBeat.i(98187);
    if (this.RhX != null) {
      this.RhX.clean();
    }
    this.RhY.clear();
    this.RhZ.clear();
    AppMethodBeat.o(98187);
    return false;
  }
  
  public final int hnd()
  {
    AppMethodBeat.i(98175);
    int i = this.RhW.Rih.size();
    AppMethodBeat.o(98175);
    return i;
  }
  
  protected final boolean hne()
  {
    AppMethodBeat.i(98184);
    com.tencent.mm.kernel.h.baF();
    if (!com.tencent.mm.kernel.h.baE().isSDCardAvailable())
    {
      com.tencent.mm.ui.base.aa.j(this.lzt, null);
      AppMethodBeat.o(98184);
      return false;
    }
    if (this.RhW.Rih.size() >= 9)
    {
      k.s(this.lzt, b.j.sns_upload_litmit, b.j.app_tip);
      AppMethodBeat.o(98184);
      return false;
    }
    if (SnsTimeLineUI.hpL()) {
      hmp();
    }
    for (;;)
    {
      AppMethodBeat.o(98184);
      return true;
      try
      {
        com.tencent.mm.ui.widget.a.f localf = new com.tencent.mm.ui.widget.a.f(this.lzt, 1, false);
        localf.Vtg = new at..ExternalSyntheticLambda0(this);
        localf.GAC = new at..ExternalSyntheticLambda1(this);
        localf.dDn();
      }
      catch (Exception localException) {}
    }
  }
  
  public final Map<String, Boolean> hnf()
  {
    AppMethodBeat.i(98189);
    Object localObject = new HashMap();
    if ((this.RhW != null) && (!this.RhW.Rih.isEmpty()))
    {
      Iterator localIterator = this.RhW.Rih.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ((Boolean)this.RhW.Rii.get(str) != null) {
          ((Map)localObject).put(str, (Boolean)this.RhW.Rii.get(str));
        }
      }
    }
    if (this.RhW != null)
    {
      localObject = this.RhW.Rii;
      AppMethodBeat.o(98189);
      return localObject;
    }
    AppMethodBeat.o(98189);
    return null;
  }
  
  /* Error */
  public boolean n(int paramInt, Intent paramIntent)
  {
    // Byte code:
    //   0: ldc_w 1311
    //   3: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: iload_1
    //   7: tableswitch	default:+53 -> 60, 2:+61->68, 3:+164->171, 4:+1298->1305, 5:+53->60, 6:+53->60, 7:+1690->1697, 8:+53->60, 9:+488->495, 10:+53->60, 11:+1196->1203
    //   61: iconst_2
    //   62: lload_1
    //   63: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: iconst_0
    //   67: ireturn
    //   68: ldc_w 280
    //   71: ldc_w 1313
    //   74: invokestatic 1104	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   77: aload_2
    //   78: ifnonnull +11 -> 89
    //   81: ldc_w 1311
    //   84: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: iconst_0
    //   88: ireturn
    //   89: ldc_w 280
    //   92: ldc_w 1315
    //   95: invokestatic 1104	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   98: new 217	android/content/Intent
    //   101: dup
    //   102: invokespecial 218	android/content/Intent:<init>	()V
    //   105: astore 4
    //   107: aload 4
    //   109: ldc_w 1317
    //   112: iconst_4
    //   113: invokevirtual 224	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   116: pop
    //   117: aload 4
    //   119: ldc_w 1319
    //   122: iconst_1
    //   123: invokevirtual 487	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   126: pop
    //   127: aload 4
    //   129: ldc_w 1321
    //   132: iconst_1
    //   133: invokevirtual 487	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   136: pop
    //   137: getstatic 1325	com/tencent/mm/plugin/sns/d/a:pFn	Lcom/tencent/mm/pluginsdk/m;
    //   140: aload_0
    //   141: getfield 125	com/tencent/mm/plugin/sns/ui/at:lzt	Lcom/tencent/mm/ui/MMActivity;
    //   144: aload_2
    //   145: aload 4
    //   147: invokestatic 1045	com/tencent/mm/plugin/sns/model/al:getAccSnsTmpPath	()Ljava/lang/String;
    //   150: new 16	com/tencent/mm/plugin/sns/ui/at$5
    //   153: dup
    //   154: aload_0
    //   155: invokespecial 1326	com/tencent/mm/plugin/sns/ui/at$5:<init>	(Lcom/tencent/mm/plugin/sns/ui/at;)V
    //   158: invokeinterface 1331 6 0
    //   163: ldc_w 1311
    //   166: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   169: iconst_1
    //   170: ireturn
    //   171: ldc_w 280
    //   174: ldc_w 1333
    //   177: invokestatic 1104	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   180: aload_0
    //   181: getfield 125	com/tencent/mm/plugin/sns/ui/at:lzt	Lcom/tencent/mm/ui/MMActivity;
    //   184: invokevirtual 1337	com/tencent/mm/ui/MMActivity:getApplicationContext	()Landroid/content/Context;
    //   187: aload_2
    //   188: invokestatic 1045	com/tencent/mm/plugin/sns/model/al:getAccSnsTmpPath	()Ljava/lang/String;
    //   191: invokestatic 1340	com/tencent/mm/pluginsdk/ui/tools/t:g	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;)Ljava/lang/String;
    //   194: astore_2
    //   195: aload_2
    //   196: ifnonnull +11 -> 207
    //   199: ldc_w 1311
    //   202: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   205: iconst_1
    //   206: ireturn
    //   207: new 217	android/content/Intent
    //   210: dup
    //   211: invokespecial 218	android/content/Intent:<init>	()V
    //   214: astore 4
    //   216: aload 4
    //   218: ldc_w 1317
    //   221: iconst_4
    //   222: invokevirtual 224	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   225: pop
    //   226: aload 4
    //   228: ldc_w 1321
    //   231: iconst_1
    //   232: invokevirtual 487	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   235: pop
    //   236: aload 4
    //   238: ldc_w 1319
    //   241: iconst_1
    //   242: invokevirtual 487	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   245: pop
    //   246: aload 4
    //   248: ldc_w 1342
    //   251: aload_2
    //   252: invokevirtual 1345	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   255: pop
    //   256: new 897	java/lang/StringBuilder
    //   259: dup
    //   260: invokespecial 1042	java/lang/StringBuilder:<init>	()V
    //   263: aload_2
    //   264: invokevirtual 924	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: invokestatic 1050	java/lang/System:currentTimeMillis	()J
    //   270: invokevirtual 934	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   273: invokevirtual 911	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   276: invokevirtual 1054	java/lang/String:getBytes	()[B
    //   279: invokestatic 1060	com/tencent/mm/b/g:getMessageDigest	([B)Ljava/lang/String;
    //   282: astore 5
    //   284: aload 4
    //   286: ldc_w 1347
    //   289: new 897	java/lang/StringBuilder
    //   292: dup
    //   293: invokespecial 1042	java/lang/StringBuilder:<init>	()V
    //   296: invokestatic 1045	com/tencent/mm/plugin/sns/model/al:getAccSnsTmpPath	()Ljava/lang/String;
    //   299: invokevirtual 924	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: aload 5
    //   304: invokevirtual 924	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: invokevirtual 911	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   310: invokevirtual 1345	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   313: pop
    //   314: aload_2
    //   315: invokestatic 1114	com/tencent/mm/compatible/util/Exif:fromFile	(Ljava/lang/String;)Lcom/tencent/mm/compatible/util/Exif;
    //   318: invokevirtual 1118	com/tencent/mm/compatible/util/Exif:getLocation	()Lcom/tencent/mm/compatible/util/Exif$a;
    //   321: astore 6
    //   323: aload 6
    //   325: ifnull +71 -> 396
    //   328: aload_0
    //   329: getfield 101	com/tencent/mm/plugin/sns/ui/at:RhY	Ljava/util/Map;
    //   332: new 897	java/lang/StringBuilder
    //   335: dup
    //   336: invokespecial 1042	java/lang/StringBuilder:<init>	()V
    //   339: invokestatic 1045	com/tencent/mm/plugin/sns/model/al:getAccSnsTmpPath	()Ljava/lang/String;
    //   342: invokevirtual 924	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: aload 5
    //   347: invokevirtual 924	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: invokevirtual 911	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   353: aload 6
    //   355: invokeinterface 308 3 0
    //   360: pop
    //   361: ldc_w 280
    //   364: ldc_w 1349
    //   367: iconst_2
    //   368: anewarray 4	java/lang/Object
    //   371: dup
    //   372: iconst_0
    //   373: aload 6
    //   375: getfield 883	com/tencent/mm/compatible/util/Exif$a:latitude	D
    //   378: invokestatic 1175	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   381: aastore
    //   382: dup
    //   383: iconst_1
    //   384: aload 6
    //   386: getfield 886	com/tencent/mm/compatible/util/Exif$a:longitude	D
    //   389: invokestatic 1175	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   392: aastore
    //   393: invokestatic 1351	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   396: new 855	com/tencent/mm/protocal/protobuf/ffa
    //   399: dup
    //   400: invokespecial 856	com/tencent/mm/protocal/protobuf/ffa:<init>	()V
    //   403: astore 6
    //   405: aload 6
    //   407: iconst_1
    //   408: putfield 944	com/tencent/mm/protocal/protobuf/ffa:abEN	I
    //   411: aload 6
    //   413: invokestatic 1050	java/lang/System:currentTimeMillis	()J
    //   416: putfield 939	com/tencent/mm/protocal/protobuf/ffa:abEP	J
    //   419: aload 6
    //   421: aload_2
    //   422: invokestatic 1114	com/tencent/mm/compatible/util/Exif:fromFile	(Ljava/lang/String;)Lcom/tencent/mm/compatible/util/Exif;
    //   425: getfield 1354	com/tencent/mm/compatible/util/Exif:dateTime	Ljava/lang/String;
    //   428: invokestatic 1357	com/tencent/mm/sdk/platformtools/Util:safeParseLong	(Ljava/lang/String;)J
    //   431: putfield 931	com/tencent/mm/protocal/protobuf/ffa:abEO	J
    //   434: aload_0
    //   435: getfield 103	com/tencent/mm/plugin/sns/ui/at:RhZ	Ljava/util/Map;
    //   438: new 897	java/lang/StringBuilder
    //   441: dup
    //   442: invokespecial 1042	java/lang/StringBuilder:<init>	()V
    //   445: invokestatic 1045	com/tencent/mm/plugin/sns/model/al:getAccSnsTmpPath	()Ljava/lang/String;
    //   448: invokevirtual 924	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: aload 5
    //   453: invokevirtual 924	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: invokevirtual 911	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   459: aload 6
    //   461: invokeinterface 308 3 0
    //   466: pop
    //   467: getstatic 1325	com/tencent/mm/plugin/sns/d/a:pFn	Lcom/tencent/mm/pluginsdk/m;
    //   470: aload_0
    //   471: getfield 125	com/tencent/mm/plugin/sns/ui/at:lzt	Lcom/tencent/mm/ui/MMActivity;
    //   474: aload 4
    //   476: iconst_4
    //   477: invokeinterface 1360 4 0
    //   482: aload_0
    //   483: iconst_1
    //   484: putfield 96	com/tencent/mm/plugin/sns/ui/at:RfR	Z
    //   487: ldc_w 1311
    //   490: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   493: iconst_1
    //   494: ireturn
    //   495: aload_2
    //   496: ldc_w 1362
    //   499: invokevirtual 1013	android/content/Intent:getBundleExtra	(Ljava/lang/String;)Landroid/os/Bundle;
    //   502: astore 4
    //   504: aload 4
    //   506: ifnull +132 -> 638
    //   509: aload 4
    //   511: ldc_w 1364
    //   514: invokevirtual 1367	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   517: ifnull +121 -> 638
    //   520: aload 4
    //   522: ldc_w 1369
    //   525: invokevirtual 1367	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   528: ifnull +110 -> 638
    //   531: ldc_w 280
    //   534: ldc_w 1371
    //   537: invokestatic 951	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   540: aload_0
    //   541: getfield 125	com/tencent/mm/plugin/sns/ui/at:lzt	Lcom/tencent/mm/ui/MMActivity;
    //   544: invokevirtual 844	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   547: invokevirtual 1075	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   550: invokevirtual 1372	android/os/Bundle:clear	()V
    //   553: aload_0
    //   554: getfield 125	com/tencent/mm/plugin/sns/ui/at:lzt	Lcom/tencent/mm/ui/MMActivity;
    //   557: invokevirtual 844	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   560: ldc_w 984
    //   563: iconst_0
    //   564: invokevirtual 487	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   567: pop
    //   568: aload_0
    //   569: getfield 125	com/tencent/mm/plugin/sns/ui/at:lzt	Lcom/tencent/mm/ui/MMActivity;
    //   572: invokevirtual 844	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   575: ldc_w 1374
    //   578: iconst_1
    //   579: invokevirtual 487	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   582: pop
    //   583: aload_0
    //   584: getfield 125	com/tencent/mm/plugin/sns/ui/at:lzt	Lcom/tencent/mm/ui/MMActivity;
    //   587: invokevirtual 844	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   590: ldc_w 1376
    //   593: bipush 14
    //   595: invokevirtual 224	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   598: pop
    //   599: aload_0
    //   600: getfield 125	com/tencent/mm/plugin/sns/ui/at:lzt	Lcom/tencent/mm/ui/MMActivity;
    //   603: invokevirtual 844	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   606: ldc_w 1362
    //   609: aload_2
    //   610: ldc_w 1362
    //   613: invokevirtual 1013	android/content/Intent:getBundleExtra	(Ljava/lang/String;)Landroid/os/Bundle;
    //   616: invokevirtual 1379	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;
    //   619: pop
    //   620: aload_0
    //   621: getfield 125	com/tencent/mm/plugin/sns/ui/at:lzt	Lcom/tencent/mm/ui/MMActivity;
    //   624: checkcast 1381	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   627: invokevirtual 1384	com/tencent/mm/plugin/sns/ui/SnsUploadUI:hqu	()V
    //   630: ldc_w 1311
    //   633: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   636: iconst_1
    //   637: ireturn
    //   638: aload_2
    //   639: ldc_w 1386
    //   642: invokevirtual 1090	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   645: astore 4
    //   647: aload 4
    //   649: ifnull +11 -> 660
    //   652: aload 4
    //   654: invokevirtual 206	java/util/ArrayList:size	()I
    //   657: ifgt +16 -> 673
    //   660: aload_2
    //   661: ldc_w 1388
    //   664: invokevirtual 989	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   667: invokestatic 631	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   670: ifne +399 -> 1069
    //   673: aload 4
    //   675: ifnull +127 -> 802
    //   678: aload 4
    //   680: invokevirtual 206	java/util/ArrayList:size	()I
    //   683: ifle +119 -> 802
    //   686: aload 4
    //   688: iconst_0
    //   689: invokevirtual 1391	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   692: checkcast 272	java/lang/String
    //   695: astore 4
    //   697: aload_2
    //   698: ldc_w 1393
    //   701: invokevirtual 989	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   704: astore 6
    //   706: aload 6
    //   708: invokestatic 631	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   711: ifne +15 -> 726
    //   714: aload 6
    //   716: astore 5
    //   718: aload 6
    //   720: invokestatic 1193	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
    //   723: ifne +187 -> 910
    //   726: new 897	java/lang/StringBuilder
    //   729: dup
    //   730: invokespecial 1042	java/lang/StringBuilder:<init>	()V
    //   733: invokestatic 1045	com/tencent/mm/plugin/sns/model/al:getAccSnsTmpPath	()Ljava/lang/String;
    //   736: invokevirtual 924	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   739: aload 4
    //   741: invokestatic 1396	com/tencent/mm/vfs/y:bub	(Ljava/lang/String;)Ljava/lang/String;
    //   744: invokevirtual 924	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   747: invokevirtual 911	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   750: astore 5
    //   752: new 1398	com/tencent/mm/compatible/i/d
    //   755: dup
    //   756: invokespecial 1399	com/tencent/mm/compatible/i/d:<init>	()V
    //   759: astore 6
    //   761: aload 6
    //   763: aload 4
    //   765: invokevirtual 1404	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   768: aload 6
    //   770: lconst_0
    //   771: invokevirtual 1408	android/media/MediaMetadataRetriever:getFrameAtTime	(J)Landroid/graphics/Bitmap;
    //   774: astore 7
    //   776: aload 7
    //   778: ifnonnull +36 -> 814
    //   781: ldc_w 280
    //   784: ldc_w 1410
    //   787: invokestatic 287	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   790: aload 6
    //   792: invokevirtual 1413	android/media/MediaMetadataRetriever:release	()V
    //   795: goto -735 -> 60
    //   798: astore_2
    //   799: goto -739 -> 60
    //   802: aload_2
    //   803: ldc_w 1388
    //   806: invokevirtual 989	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   809: astore 4
    //   811: goto -114 -> 697
    //   814: ldc_w 280
    //   817: ldc_w 1415
    //   820: iconst_2
    //   821: anewarray 4	java/lang/Object
    //   824: dup
    //   825: iconst_0
    //   826: aload 7
    //   828: invokevirtual 1420	android/graphics/Bitmap:getWidth	()I
    //   831: invokestatic 212	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   834: aastore
    //   835: dup
    //   836: iconst_1
    //   837: aload 7
    //   839: invokevirtual 1423	android/graphics/Bitmap:getHeight	()I
    //   842: invokestatic 212	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   845: aastore
    //   846: invokestatic 829	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   849: aload 7
    //   851: bipush 80
    //   853: getstatic 1429	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   856: aload 5
    //   858: iconst_1
    //   859: invokestatic 1435	com/tencent/mm/sdk/platformtools/BitmapUtil:saveBitmapToImage	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
    //   862: pop
    //   863: aload 5
    //   865: invokestatic 1439	com/tencent/mm/sdk/platformtools/BitmapUtil:getImageOptions	(Ljava/lang/String;)Landroid/graphics/BitmapFactory$Options;
    //   868: astore 7
    //   870: ldc_w 280
    //   873: ldc_w 1441
    //   876: iconst_2
    //   877: anewarray 4	java/lang/Object
    //   880: dup
    //   881: iconst_0
    //   882: aload 7
    //   884: getfield 1446	android/graphics/BitmapFactory$Options:outWidth	I
    //   887: invokestatic 212	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   890: aastore
    //   891: dup
    //   892: iconst_1
    //   893: aload 7
    //   895: getfield 1449	android/graphics/BitmapFactory$Options:outHeight	I
    //   898: invokestatic 212	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   901: aastore
    //   902: invokestatic 829	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   905: aload 6
    //   907: invokevirtual 1413	android/media/MediaMetadataRetriever:release	()V
    //   910: ldc_w 280
    //   913: ldc_w 1451
    //   916: iconst_4
    //   917: anewarray 4	java/lang/Object
    //   920: dup
    //   921: iconst_0
    //   922: aload 4
    //   924: aastore
    //   925: dup
    //   926: iconst_1
    //   927: aload 5
    //   929: aastore
    //   930: dup
    //   931: iconst_2
    //   932: aload 4
    //   934: invokestatic 840	com/tencent/mm/vfs/y:bEl	(Ljava/lang/String;)J
    //   937: invokestatic 403	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   940: aastore
    //   941: dup
    //   942: iconst_3
    //   943: aload 5
    //   945: invokestatic 840	com/tencent/mm/vfs/y:bEl	(Ljava/lang/String;)J
    //   948: invokestatic 403	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   951: aastore
    //   952: invokestatic 829	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   955: aload 4
    //   957: invokestatic 1396	com/tencent/mm/vfs/y:bub	(Ljava/lang/String;)Ljava/lang/String;
    //   960: astore 6
    //   962: aload_0
    //   963: getfield 125	com/tencent/mm/plugin/sns/ui/at:lzt	Lcom/tencent/mm/ui/MMActivity;
    //   966: instanceof 1381
    //   969: ifeq +42 -> 1011
    //   972: aload_2
    //   973: ldc_w 1453
    //   976: invokevirtual 989	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   979: invokestatic 1456	com/tencent/mm/plugin/sns/data/t:aXG	(Ljava/lang/String;)V
    //   982: aload_0
    //   983: getfield 125	com/tencent/mm/plugin/sns/ui/at:lzt	Lcom/tencent/mm/ui/MMActivity;
    //   986: checkcast 1381	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   989: aload 4
    //   991: aload 5
    //   993: aload 6
    //   995: aconst_null
    //   996: iconst_0
    //   997: iconst_0
    //   998: invokevirtual 1459	com/tencent/mm/plugin/sns/ui/SnsUploadUI:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BZZ)V
    //   1001: aload_0
    //   1002: getfield 125	com/tencent/mm/plugin/sns/ui/at:lzt	Lcom/tencent/mm/ui/MMActivity;
    //   1005: checkcast 1381	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   1008: invokevirtual 1384	com/tencent/mm/plugin/sns/ui/SnsUploadUI:hqu	()V
    //   1011: ldc_w 1311
    //   1014: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1017: iconst_1
    //   1018: ireturn
    //   1019: astore 7
    //   1021: ldc_w 280
    //   1024: ldc_w 1461
    //   1027: iconst_1
    //   1028: anewarray 4	java/lang/Object
    //   1031: dup
    //   1032: iconst_0
    //   1033: aload 7
    //   1035: invokevirtual 1134	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1038: aastore
    //   1039: invokestatic 1463	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1042: aload 6
    //   1044: invokevirtual 1413	android/media/MediaMetadataRetriever:release	()V
    //   1047: goto -137 -> 910
    //   1050: astore 6
    //   1052: goto -142 -> 910
    //   1055: astore_2
    //   1056: aload 6
    //   1058: invokevirtual 1413	android/media/MediaMetadataRetriever:release	()V
    //   1061: ldc_w 1311
    //   1064: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1067: aload_2
    //   1068: athrow
    //   1069: aload_2
    //   1070: ldc_w 1465
    //   1073: invokevirtual 1469	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   1076: checkcast 1471	com/tencent/mm/plugin/mmsight/SightCaptureResult
    //   1079: astore 4
    //   1081: aload 4
    //   1083: ifnull +41 -> 1124
    //   1086: aload 4
    //   1088: getfield 1474	com/tencent/mm/plugin/mmsight/SightCaptureResult:KTL	Z
    //   1091: ifne +33 -> 1124
    //   1094: aload_0
    //   1095: getfield 125	com/tencent/mm/plugin/sns/ui/at:lzt	Lcom/tencent/mm/ui/MMActivity;
    //   1098: instanceof 1381
    //   1101: ifeq +23 -> 1124
    //   1104: aload_0
    //   1105: getfield 125	com/tencent/mm/plugin/sns/ui/at:lzt	Lcom/tencent/mm/ui/MMActivity;
    //   1108: checkcast 1381	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   1111: aload 4
    //   1113: invokevirtual 1477	com/tencent/mm/plugin/sns/ui/SnsUploadUI:b	(Lcom/tencent/mm/plugin/mmsight/SightCaptureResult;)V
    //   1116: ldc_w 1311
    //   1119: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1122: iconst_1
    //   1123: ireturn
    //   1124: aload_2
    //   1125: ldc_w 1479
    //   1128: invokevirtual 1090	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   1131: astore 4
    //   1133: aload_2
    //   1134: ldc_w 1481
    //   1137: iconst_0
    //   1138: invokevirtual 1003	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1141: istore_1
    //   1142: aload_2
    //   1143: ldc_w 1483
    //   1146: iconst_0
    //   1147: invokevirtual 850	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   1150: istore_3
    //   1151: ldc_w 358
    //   1154: invokestatic 364	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   1157: checkcast 358	com/tencent/mm/plugin/expt/b/c
    //   1160: getstatic 1486	com/tencent/mm/plugin/expt/b/c$a:yVQ	Lcom/tencent/mm/plugin/expt/b/c$a;
    //   1163: iconst_1
    //   1164: invokeinterface 373 3 0
    //   1169: ifeq +17 -> 1186
    //   1172: aload 4
    //   1174: ifnull +12 -> 1186
    //   1177: getstatic 1203	com/tencent/mm/plugin/recordvideo/util/f:Obq	Lcom/tencent/mm/plugin/recordvideo/util/f;
    //   1180: astore_2
    //   1181: aload 4
    //   1183: invokestatic 1490	com/tencent/mm/plugin/recordvideo/util/f:bn	(Ljava/util/ArrayList;)V
    //   1186: aload_0
    //   1187: aload 4
    //   1189: iload_1
    //   1190: iload_3
    //   1191: invokevirtual 1492	com/tencent/mm/plugin/sns/ui/at:d	(Ljava/util/List;IZ)Z
    //   1194: istore_3
    //   1195: ldc_w 1311
    //   1198: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1201: iload_3
    //   1202: ireturn
    //   1203: aload_2
    //   1204: ldc_w 1465
    //   1207: invokevirtual 1469	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   1210: checkcast 1471	com/tencent/mm/plugin/mmsight/SightCaptureResult
    //   1213: astore_2
    //   1214: aload_2
    //   1215: ifnull -1155 -> 60
    //   1218: aload_2
    //   1219: getfield 1474	com/tencent/mm/plugin/mmsight/SightCaptureResult:KTL	Z
    //   1222: ifeq +64 -> 1286
    //   1225: aload_2
    //   1226: getfield 1495	com/tencent/mm/plugin/mmsight/SightCaptureResult:KTT	Ljava/lang/String;
    //   1229: astore_2
    //   1230: aload_2
    //   1231: invokestatic 631	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   1234: ifne -1174 -> 60
    //   1237: ldc_w 358
    //   1240: invokestatic 364	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   1243: checkcast 358	com/tencent/mm/plugin/expt/b/c
    //   1246: getstatic 1486	com/tencent/mm/plugin/expt/b/c$a:yVQ	Lcom/tencent/mm/plugin/expt/b/c$a;
    //   1249: iconst_1
    //   1250: invokeinterface 373 3 0
    //   1255: ifeq +12 -> 1267
    //   1258: getstatic 1203	com/tencent/mm/plugin/recordvideo/util/f:Obq	Lcom/tencent/mm/plugin/recordvideo/util/f;
    //   1261: astore 4
    //   1263: aload_2
    //   1264: invokestatic 1498	com/tencent/mm/plugin/recordvideo/util/f:aTr	(Ljava/lang/String;)V
    //   1267: aload_0
    //   1268: aload_2
    //   1269: invokestatic 1504	java/util/Collections:singletonList	(Ljava/lang/Object;)Ljava/util/List;
    //   1272: iconst_0
    //   1273: iconst_1
    //   1274: invokevirtual 1492	com/tencent/mm/plugin/sns/ui/at:d	(Ljava/util/List;IZ)Z
    //   1277: istore_3
    //   1278: ldc_w 1311
    //   1281: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1284: iload_3
    //   1285: ireturn
    //   1286: aload_0
    //   1287: getfield 125	com/tencent/mm/plugin/sns/ui/at:lzt	Lcom/tencent/mm/ui/MMActivity;
    //   1290: checkcast 1381	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   1293: aload_2
    //   1294: invokevirtual 1477	com/tencent/mm/plugin/sns/ui/SnsUploadUI:b	(Lcom/tencent/mm/plugin/mmsight/SightCaptureResult;)V
    //   1297: ldc_w 1311
    //   1300: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1303: iconst_1
    //   1304: ireturn
    //   1305: ldc_w 280
    //   1308: ldc_w 1506
    //   1311: invokestatic 1104	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1314: aload_2
    //   1315: ifnonnull +11 -> 1326
    //   1318: ldc_w 1311
    //   1321: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1324: iconst_1
    //   1325: ireturn
    //   1326: aload_2
    //   1327: ldc_w 1347
    //   1330: invokevirtual 989	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1333: astore 4
    //   1335: ldc_w 280
    //   1338: ldc_w 1508
    //   1341: aload 4
    //   1343: invokestatic 1098	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1346: invokevirtual 1101	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1349: invokestatic 1104	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1352: aload 4
    //   1354: ifnonnull +11 -> 1365
    //   1357: ldc_w 1311
    //   1360: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1363: iconst_1
    //   1364: ireturn
    //   1365: aload 4
    //   1367: invokestatic 1193	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
    //   1370: ifne +11 -> 1381
    //   1373: ldc_w 1311
    //   1376: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1379: iconst_1
    //   1380: ireturn
    //   1381: aload_0
    //   1382: getfield 94	com/tencent/mm/plugin/sns/ui/at:RhW	Lcom/tencent/mm/plugin/sns/ui/at$b;
    //   1385: getfield 190	com/tencent/mm/plugin/sns/ui/at$b:Rih	Ljava/util/ArrayList;
    //   1388: invokevirtual 206	java/util/ArrayList:size	()I
    //   1391: bipush 9
    //   1393: if_icmplt +11 -> 1404
    //   1396: ldc_w 1311
    //   1399: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1402: iconst_1
    //   1403: ireturn
    //   1404: aload_2
    //   1405: ldc_w 1481
    //   1408: iconst_0
    //   1409: invokevirtual 1003	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1412: istore_1
    //   1413: new 897	java/lang/StringBuilder
    //   1416: dup
    //   1417: ldc_w 1136
    //   1420: invokespecial 901	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1423: new 897	java/lang/StringBuilder
    //   1426: dup
    //   1427: invokespecial 1042	java/lang/StringBuilder:<init>	()V
    //   1430: aload 4
    //   1432: invokevirtual 924	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1435: invokestatic 1050	java/lang/System:currentTimeMillis	()J
    //   1438: invokevirtual 934	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1441: invokevirtual 911	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1444: invokevirtual 1054	java/lang/String:getBytes	()[B
    //   1447: invokestatic 1060	com/tencent/mm/b/g:getMessageDigest	([B)Ljava/lang/String;
    //   1450: invokevirtual 924	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1453: invokevirtual 911	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1456: astore_2
    //   1457: ldc_w 280
    //   1460: new 897	java/lang/StringBuilder
    //   1463: dup
    //   1464: ldc_w 1510
    //   1467: invokespecial 901	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1470: aload 4
    //   1472: invokestatic 840	com/tencent/mm/vfs/y:bEl	(Ljava/lang/String;)J
    //   1475: invokevirtual 934	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1478: ldc_w 921
    //   1481: invokevirtual 924	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1484: aload 4
    //   1486: invokevirtual 924	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1489: invokevirtual 911	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1492: invokestatic 951	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1495: aload 4
    //   1497: new 897	java/lang/StringBuilder
    //   1500: dup
    //   1501: invokespecial 1042	java/lang/StringBuilder:<init>	()V
    //   1504: invokestatic 1045	com/tencent/mm/plugin/sns/model/al:getAccSnsTmpPath	()Ljava/lang/String;
    //   1507: invokevirtual 924	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1510: aload_2
    //   1511: invokevirtual 924	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1514: invokevirtual 911	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1517: iconst_0
    //   1518: invokestatic 1146	com/tencent/mm/vfs/y:O	(Ljava/lang/String;Ljava/lang/String;Z)J
    //   1521: pop2
    //   1522: aload_0
    //   1523: getfield 101	com/tencent/mm/plugin/sns/ui/at:RhY	Ljava/util/Map;
    //   1526: aload 4
    //   1528: invokeinterface 615 2 0
    //   1533: ifeq +47 -> 1580
    //   1536: aload_0
    //   1537: getfield 101	com/tencent/mm/plugin/sns/ui/at:RhY	Ljava/util/Map;
    //   1540: new 897	java/lang/StringBuilder
    //   1543: dup
    //   1544: invokespecial 1042	java/lang/StringBuilder:<init>	()V
    //   1547: invokestatic 1045	com/tencent/mm/plugin/sns/model/al:getAccSnsTmpPath	()Ljava/lang/String;
    //   1550: invokevirtual 924	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1553: aload_2
    //   1554: invokevirtual 924	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1557: invokevirtual 911	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1560: aload_0
    //   1561: getfield 101	com/tencent/mm/plugin/sns/ui/at:RhY	Ljava/util/Map;
    //   1564: aload 4
    //   1566: invokeinterface 619 2 0
    //   1571: checkcast 293	com/tencent/mm/compatible/util/Exif$a
    //   1574: invokeinterface 308 3 0
    //   1579: pop
    //   1580: new 897	java/lang/StringBuilder
    //   1583: dup
    //   1584: invokespecial 1042	java/lang/StringBuilder:<init>	()V
    //   1587: invokestatic 1045	com/tencent/mm/plugin/sns/model/al:getAccSnsTmpPath	()Ljava/lang/String;
    //   1590: invokevirtual 924	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1593: aload_2
    //   1594: invokevirtual 924	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1597: invokevirtual 911	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1600: astore_2
    //   1601: ldc_w 280
    //   1604: ldc_w 1095
    //   1607: aload_2
    //   1608: invokestatic 1098	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1611: invokevirtual 1101	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1614: invokestatic 1104	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1617: aload_0
    //   1618: getfield 94	com/tencent/mm/plugin/sns/ui/at:RhW	Lcom/tencent/mm/plugin/sns/ui/at$b;
    //   1621: aload_2
    //   1622: iload_1
    //   1623: iconst_0
    //   1624: invokevirtual 1108	com/tencent/mm/plugin/sns/ui/at$b:z	(Ljava/lang/String;IZ)Lcom/tencent/mm/plugin/sns/ui/at$b;
    //   1627: pop
    //   1628: aload_0
    //   1629: getfield 125	com/tencent/mm/plugin/sns/ui/at:lzt	Lcom/tencent/mm/ui/MMActivity;
    //   1632: invokevirtual 844	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   1635: ldc_w 1085
    //   1638: aload_0
    //   1639: getfield 94	com/tencent/mm/plugin/sns/ui/at:RhW	Lcom/tencent/mm/plugin/sns/ui/at$b;
    //   1642: getfield 190	com/tencent/mm/plugin/sns/ui/at$b:Rih	Ljava/util/ArrayList;
    //   1645: invokevirtual 1217	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;
    //   1648: pop
    //   1649: aload_0
    //   1650: getfield 558	com/tencent/mm/plugin/sns/ui/at:RhX	Lcom/tencent/mm/plugin/sns/ui/ac;
    //   1653: checkcast 562	com/tencent/mm/plugin/sns/ui/previewimageview/e
    //   1656: aload_0
    //   1657: getfield 94	com/tencent/mm/plugin/sns/ui/at:RhW	Lcom/tencent/mm/plugin/sns/ui/at$b;
    //   1660: getfield 190	com/tencent/mm/plugin/sns/ui/at$b:Rih	Ljava/util/ArrayList;
    //   1663: invokevirtual 206	java/util/ArrayList:size	()I
    //   1666: invokevirtual 1214	com/tencent/mm/plugin/sns/ui/previewimageview/e:amE	(I)V
    //   1669: aload_0
    //   1670: getfield 558	com/tencent/mm/plugin/sns/ui/at:RhX	Lcom/tencent/mm/plugin/sns/ui/ac;
    //   1673: aload_0
    //   1674: getfield 94	com/tencent/mm/plugin/sns/ui/at:RhW	Lcom/tencent/mm/plugin/sns/ui/at$b;
    //   1677: getfield 190	com/tencent/mm/plugin/sns/ui/at$b:Rih	Ljava/util/ArrayList;
    //   1680: aload_0
    //   1681: getfield 123	com/tencent/mm/plugin/sns/ui/at:lyL	I
    //   1684: invokeinterface 575 3 0
    //   1689: ldc_w 1311
    //   1692: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1695: iconst_1
    //   1696: ireturn
    //   1697: aload_2
    //   1698: ifnonnull +11 -> 1709
    //   1701: ldc_w 1311
    //   1704: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1707: iconst_1
    //   1708: ireturn
    //   1709: aload_0
    //   1710: getfield 94	com/tencent/mm/plugin/sns/ui/at:RhW	Lcom/tencent/mm/plugin/sns/ui/at$b;
    //   1713: aload_2
    //   1714: ldc_w 1512
    //   1717: invokevirtual 1090	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   1720: invokevirtual 1515	com/tencent/mm/plugin/sns/ui/at$b:bE	(Ljava/util/ArrayList;)V
    //   1723: aload_0
    //   1724: getfield 125	com/tencent/mm/plugin/sns/ui/at:lzt	Lcom/tencent/mm/ui/MMActivity;
    //   1727: invokevirtual 844	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   1730: ldc_w 1085
    //   1733: aload_0
    //   1734: getfield 94	com/tencent/mm/plugin/sns/ui/at:RhW	Lcom/tencent/mm/plugin/sns/ui/at$b;
    //   1737: getfield 190	com/tencent/mm/plugin/sns/ui/at$b:Rih	Ljava/util/ArrayList;
    //   1740: invokevirtual 1217	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;
    //   1743: pop
    //   1744: aload_0
    //   1745: getfield 558	com/tencent/mm/plugin/sns/ui/at:RhX	Lcom/tencent/mm/plugin/sns/ui/ac;
    //   1748: checkcast 562	com/tencent/mm/plugin/sns/ui/previewimageview/e
    //   1751: aload_0
    //   1752: getfield 94	com/tencent/mm/plugin/sns/ui/at:RhW	Lcom/tencent/mm/plugin/sns/ui/at$b;
    //   1755: getfield 190	com/tencent/mm/plugin/sns/ui/at$b:Rih	Ljava/util/ArrayList;
    //   1758: invokevirtual 206	java/util/ArrayList:size	()I
    //   1761: invokevirtual 1214	com/tencent/mm/plugin/sns/ui/previewimageview/e:amE	(I)V
    //   1764: aload_0
    //   1765: getfield 558	com/tencent/mm/plugin/sns/ui/at:RhX	Lcom/tencent/mm/plugin/sns/ui/ac;
    //   1768: aload_0
    //   1769: getfield 94	com/tencent/mm/plugin/sns/ui/at:RhW	Lcom/tencent/mm/plugin/sns/ui/at$b;
    //   1772: getfield 190	com/tencent/mm/plugin/sns/ui/at$b:Rih	Ljava/util/ArrayList;
    //   1775: aload_0
    //   1776: getfield 123	com/tencent/mm/plugin/sns/ui/at:lyL	I
    //   1779: invokeinterface 575 3 0
    //   1784: aload_0
    //   1785: aload_2
    //   1786: ldc_w 1517
    //   1789: iconst_0
    //   1790: invokevirtual 1003	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1793: putfield 105	com/tencent/mm/plugin/sns/ui/at:Ria	I
    //   1796: ldc_w 1311
    //   1799: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1802: iconst_1
    //   1803: ireturn
    //   1804: astore 6
    //   1806: goto -896 -> 910
    //   1809: astore 4
    //   1811: goto -750 -> 1061
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1814	0	this	at
    //   0	1814	1	paramInt	int
    //   0	1814	2	paramIntent	Intent
    //   1150	135	3	bool	boolean
    //   105	1460	4	localObject1	Object
    //   1809	1	4	localException1	Exception
    //   282	710	5	localObject2	Object
    //   321	722	6	localObject3	Object
    //   1050	7	6	localException2	Exception
    //   1804	1	6	localException3	Exception
    //   774	120	7	localObject4	Object
    //   1019	15	7	localException4	Exception
    // Exception table:
    //   from	to	target	type
    //   790	795	798	java/lang/Exception
    //   761	776	1019	java/lang/Exception
    //   781	790	1019	java/lang/Exception
    //   814	905	1019	java/lang/Exception
    //   1042	1047	1050	java/lang/Exception
    //   761	776	1055	finally
    //   781	790	1055	finally
    //   814	905	1055	finally
    //   1021	1042	1055	finally
    //   905	910	1804	java/lang/Exception
    //   1056	1061	1809	java/lang/Exception
  }
  
  final class a
    extends com.tencent.mm.plugin.sns.model.h<String, Integer, Boolean>
  {
    private bg Rgf;
    private List<com.tencent.mm.plugin.sns.data.s> Rie;
    private ProgressDialog lzP;
    
    public a(List<com.tencent.mm.plugin.sns.data.s> paramList)
    {
      AppMethodBeat.i(98164);
      this.lzP = null;
      this.Rgf = paramList;
      Object localObject;
      this.Rie = localObject;
      paramList = at.this.lzt;
      at.this.lzt.getString(b.j.app_tip);
      this.lzP = k.a(paramList, at.this.lzt.getString(b.j.app_loading_data), false, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
      });
      AppMethodBeat.o(98164);
    }
    
    public final ExecutorService gDT()
    {
      AppMethodBeat.i(179157);
      ExecutorService localExecutorService = al.hgo();
      AppMethodBeat.o(179157);
      return localExecutorService;
    }
  }
  
  final class b
  {
    ArrayList<String> Rih;
    Map<String, Boolean> Rii;
    Map<String, Integer> Rij;
    
    b()
    {
      AppMethodBeat.i(98168);
      this.Rih = new ArrayList();
      this.Rii = new HashMap();
      this.Rij = new HashMap();
      AppMethodBeat.o(98168);
    }
    
    public final void bE(ArrayList<String> paramArrayList)
    {
      AppMethodBeat.i(98170);
      this.Rii.clear();
      if (paramArrayList == null)
      {
        this.Rih = new ArrayList();
        AppMethodBeat.o(98170);
        return;
      }
      this.Rih = paramArrayList;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        this.Rii.put(str, Boolean.FALSE);
      }
      AppMethodBeat.o(98170);
    }
    
    public final b baA(String paramString)
    {
      int i = 0;
      AppMethodBeat.i(98172);
      try
      {
        paramString = paramString.split(";");
        int j = paramString.length;
        while (i < j)
        {
          String[] arrayOfString = paramString[i].split(",");
          this.Rih.add(arrayOfString[0]);
          this.Rij.put(arrayOfString[0], Integer.valueOf(Util.getInt(arrayOfString[1], 0)));
          i += 1;
        }
        return this;
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(98172);
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(98171);
      Iterator localIterator = this.Rih.iterator();
      String str2;
      int i;
      for (String str1 = ""; localIterator.hasNext(); str1 = str1 + str2 + "," + i + ";")
      {
        str2 = (String)localIterator.next();
        i = 0;
        if (this.Rij != null) {
          i = ((Integer)this.Rij.get(str2)).intValue();
        }
      }
      AppMethodBeat.o(98171);
      return str1;
    }
    
    public final b z(String paramString, int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(98169);
      this.Rih.add(paramString);
      this.Rij.put(paramString, Integer.valueOf(paramInt));
      this.Rii.put(paramString, Boolean.valueOf(paramBoolean));
      AppMethodBeat.o(98169);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.at
 * JD-Core Version:    0.7.0.1
 */