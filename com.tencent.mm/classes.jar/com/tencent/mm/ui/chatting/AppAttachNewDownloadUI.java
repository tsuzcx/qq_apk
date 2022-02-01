package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Looper;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.dd;
import com.tencent.mm.f.a.qe;
import com.tencent.mm.f.a.qe.a;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection;
import com.tencent.mm.plugin.appbrand.openmaterial.model.MaterialModel;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.msgquote.model.MsgQuoteItem;
import com.tencent.mm.plugin.record.b.f.b;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.model.v;
import com.tencent.mm.protocal.protobuf.aco;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.h.e;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.report.MMSecDataActivity;
import com.tencent.mm.ui.tools.ShowImageUI;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.progress.RoundProgressBtn;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.Iterator;

public class AppAttachNewDownloadUI
  extends MMSecDataActivity
  implements com.tencent.mm.an.i, i.a, f.b, MStorage.IOnStorageChange
{
  private com.tencent.mm.plugin.record.b.f HCv;
  private MMImageView HnZ;
  private AppBrandOpenMaterialCollection QdI;
  private com.tencent.mm.plugin.appbrand.openmaterial.j QdJ;
  private long Rwe;
  private String Rxk;
  private com.tencent.mm.plugin.appbrand.openmaterial.h Rxl;
  private boolean WwA;
  private boolean WwB;
  private boolean WwC;
  private boolean WwE;
  private int WwF;
  private LinearLayout WwG;
  private boolean WwI;
  private com.tencent.mm.ui.chatting.j.b WwJ;
  private LinearLayout WwK;
  private ImageView WwL;
  private RoundProgressBtn Wwq;
  private TextView Wwu;
  private TextView Wwv;
  private com.tencent.mm.an.j Www;
  private boolean Wwx;
  private k.b Wwy;
  private String Wwz;
  private AppAttachNewDownloadUI.a Wxc;
  private TextView Wxd;
  private ProgressBar Wxe;
  private TextView Wxf;
  private String aesKey;
  private int appType;
  private String authKey;
  private String cdnURL;
  private String fLi;
  private boolean fNQ;
  private ca fNz;
  private String fQs;
  private String fileName;
  private String filePath;
  private String jmx;
  private String mediaId;
  private long msgId;
  private e rZT;
  private int scene;
  private String smU;
  private int syc;
  private int syd;
  private com.tencent.mm.ui.widget.b.a szq;
  private int tNG;
  private q.g voR;
  private Button wNZ;
  private Button wOa;
  private HandOffFile wOp;
  private View.OnTouchListener wOs;
  private View.OnLongClickListener wOt;
  
  public AppAttachNewDownloadUI()
  {
    AppMethodBeat.i(281661);
    this.tNG = 0;
    this.WwA = false;
    this.WwB = false;
    this.WwC = true;
    this.WwE = false;
    this.WwI = false;
    this.Rxk = null;
    this.QdI = null;
    this.Rxl = null;
    this.QdJ = null;
    this.rZT = null;
    this.szq = null;
    this.voR = new AppAttachNewDownloadUI.6(this);
    this.wOs = new AppAttachNewDownloadUI.7(this);
    this.wOt = new AppAttachNewDownloadUI.8(this);
    AppMethodBeat.o(281661);
  }
  
  private void Ge(boolean paramBoolean)
  {
    AppMethodBeat.i(281686);
    com.tencent.mm.pluginsdk.model.app.c localc;
    if ((this.appType == 74) || (this.appType == 6))
    {
      Log.i("MicroMsg.AppAttachNewDownloadUI", "showFileReceiveStateView appType:%s isFileSender:%s fileStatus:%s startDownload:%s isDownloadStarted:%s isDownloadFinished:%s", new Object[] { Integer.valueOf(this.appType), Integer.valueOf(this.fNz.ilx), Integer.valueOf(this.fNz.fileStatus), Boolean.valueOf(paramBoolean), Boolean.valueOf(this.WwB), Boolean.valueOf(this.WwA) });
      if ((this.appType == 74) && (!this.WwA)) {}
      switch (this.fNz.fileStatus)
      {
      default: 
        if ((this.appType == 6) || (this.WwA))
        {
          localc = hLI();
          if ((this.fNz.ilx != 1) || (localc == null) || (((int)localc.field_status != 102) && ((int)localc.field_status != 198) && ((int)localc.field_status != 101))) {
            break label773;
          }
          Log.i("MicroMsg.AppAttachNewDownloadUI", "showFileReceiveStateView appAttachInfo is %s", new Object[] { Long.valueOf(localc.field_status) });
          if ((int)localc.field_status != 102) {
            break label533;
          }
          this.Wxc.setVisibility(0);
          this.wOa.setVisibility(8);
          this.Wxd.setVisibility(8);
          this.Wxe.setVisibility(8);
          this.Wxf.setVisibility(8);
          this.wNZ.setVisibility(8);
          auY(8);
        }
        break;
      }
    }
    label773:
    for (;;)
    {
      hLQ();
      AppMethodBeat.o(281686);
      return;
      this.Wxc.setVisibility(8);
      this.wOa.setVisibility(0);
      this.Wxd.setVisibility(8);
      this.Wxe.setVisibility(8);
      this.Wxf.setVisibility(8);
      this.wNZ.setVisibility(8);
      auY(8);
      break;
      this.Wxc.setVisibility(8);
      this.wOa.setVisibility(8);
      this.Wxd.setVisibility(0);
      if (this.fNz.field_isSend == 1) {
        this.Wxd.setText(R.l.eEX);
      }
      for (;;)
      {
        this.Wxe.setVisibility(0);
        this.Wxf.setVisibility(0);
        this.wNZ.setVisibility(8);
        auY(8);
        break;
        this.Wxd.setText(R.l.eEW);
      }
      this.Wxc.Gf(true);
      this.wOa.setVisibility(8);
      this.Wxd.setVisibility(8);
      this.Wxe.setVisibility(8);
      this.Wxf.setVisibility(8);
      this.wNZ.setVisibility(8);
      auY(8);
      break;
      label533:
      if ((int)localc.field_status == 198)
      {
        switch (this.fNz.fileStatus)
        {
        default: 
          this.Wxc.Gf(false);
          this.wOa.setVisibility(8);
          this.Wxd.setVisibility(8);
          this.Wxe.setVisibility(8);
          this.Wxf.setVisibility(8);
          this.wNZ.setVisibility(8);
          auY(8);
          break;
        case 3: 
          this.Wxc.setVisibility(0);
          this.wOa.setVisibility(8);
          this.Wxd.setVisibility(8);
          this.Wxe.setVisibility(8);
          this.Wxf.setVisibility(8);
          this.wNZ.setVisibility(8);
          auY(8);
          break;
        }
      }
      else if ((int)localc.field_status == 101)
      {
        this.Wxc.setVisibility(8);
        this.wOa.setVisibility(8);
        this.Wxe.setVisibility(8);
        this.Wxd.setVisibility(0);
        this.Wxd.setText(R.l.eER);
        this.Wxf.setVisibility(8);
        this.wNZ.setVisibility(8);
        auY(0);
        continue;
        if (!paramBoolean) {
          break label848;
        }
        this.Wxc.setVisibility(8);
        this.wOa.setVisibility(8);
        this.Wxe.setVisibility(8);
        this.Wxd.setVisibility(0);
        this.Wxd.setText(R.l.eER);
        this.Wxf.setVisibility(8);
        this.wNZ.setVisibility(8);
        auY(0);
      }
    }
    label848:
    if (this.WwA)
    {
      this.Wxc.setVisibility(8);
      this.wOa.setVisibility(8);
      this.Wxe.setVisibility(8);
      this.Wxd.setVisibility(8);
      this.Wxf.setVisibility(8);
      if (getMimeType().equals("")) {
        this.wNZ.setVisibility(8);
      }
      for (;;)
      {
        auY(8);
        break;
        this.wNZ.setVisibility(0);
      }
    }
    if (this.WwB)
    {
      this.Wxc.setVisibility(8);
      this.wOa.setVisibility(8);
      auY(0);
      this.Wxd.setVisibility(0);
      this.Wxd.setText(R.l.eER);
      cQC();
    }
    for (;;)
    {
      this.Wxe.setVisibility(8);
      this.Wxf.setVisibility(8);
      this.wNZ.setVisibility(8);
      break;
      this.Wxc.setVisibility(8);
      this.wOa.setVisibility(0);
      auY(8);
      this.Wxd.setVisibility(8);
    }
  }
  
  public static com.tencent.mm.pluginsdk.model.app.c a(int paramInt, long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(281696);
    com.tencent.mm.pluginsdk.model.app.c localc = ao.ctZ().TR(paramLong);
    if (localc != null)
    {
      Log.i("MicroMsg.AppAttachNewDownloadUI", "summerapp getAppAttachInfo by msgId [%d] stack[%s]", new Object[] { Long.valueOf(paramLong), ae.bvD() });
      AppMethodBeat.o(281696);
      return localc;
    }
    if (paramInt == 74)
    {
      AppMethodBeat.o(281696);
      return null;
    }
    paramString1 = m.bqf(paramString1);
    if (paramString1 == null)
    {
      Log.i("MicroMsg.AppAttachNewDownloadUI", "summerapp getAppAttachInfo by msgId and mediaId is null stack[%s]", new Object[] { ae.bvD() });
      AppMethodBeat.o(281696);
      return paramString1;
    }
    if ((paramString1.field_msgInfoId == paramLong) || (u.agG(paramString1.field_fileFullPath)))
    {
      AppMethodBeat.o(281696);
      return paramString1;
    }
    m.M(paramLong, paramString2);
    paramString2 = ao.ctZ().TR(paramLong);
    if (paramString2 == null)
    {
      Log.w("MicroMsg.AppAttachNewDownloadUI", "summerapp getAppAttachInfo create new info from local but failed stack[%s]", new Object[] { ae.bvD() });
      AppMethodBeat.o(281696);
      return paramString1;
    }
    ThreadPool.post(new AppAttachNewDownloadUI.10(paramString1, paramString2), "copyAttachFromLocal");
    AppMethodBeat.o(281696);
    return paramString1;
  }
  
  private void auY(int paramInt)
  {
    AppMethodBeat.i(281722);
    if (paramInt != this.Wwq.getVisibility())
    {
      Log.i("MicroMsg.AppAttachNewDownloadUI", "setRoundProgressBar %s %s", new Object[] { Integer.valueOf(paramInt), ae.bvD() });
      this.Wwq.setVisibility(paramInt);
      if (paramInt == 0) {
        cQC();
      }
    }
    AppMethodBeat.o(281722);
  }
  
  private static boolean b(com.tencent.mm.pluginsdk.model.app.c paramc)
  {
    AppMethodBeat.i(281720);
    if (paramc == null)
    {
      AppMethodBeat.o(281720);
      return false;
    }
    com.tencent.mm.vfs.q localq = new com.tencent.mm.vfs.q(paramc.field_fileFullPath);
    if ((localq.ifE()) && (localq.length() == paramc.field_totalLen))
    {
      AppMethodBeat.o(281720);
      return true;
    }
    AppMethodBeat.o(281720);
    return false;
  }
  
  private String byS(String paramString)
  {
    AppMethodBeat.i(281684);
    String str = paramString;
    if (this.Wwx)
    {
      str = paramString;
      if (paramString != null) {
        str = bq.RM(paramString);
      }
    }
    AppMethodBeat.o(281684);
    return str;
  }
  
  private static String byT(String paramString)
  {
    AppMethodBeat.i(281704);
    if (paramString == null)
    {
      AppMethodBeat.o(281704);
      return paramString;
    }
    String str = com.tencent.mm.loader.j.b.aSG();
    paramString = u.n(paramString, true);
    int i = paramString.indexOf(str);
    if (i >= 0)
    {
      paramString = paramString.substring(str.length() + i);
      if (paramString.startsWith("/"))
      {
        paramString = "/sdcard".concat(String.valueOf(paramString));
        AppMethodBeat.o(281704);
        return paramString;
      }
      paramString = "/sdcard/".concat(String.valueOf(paramString));
      AppMethodBeat.o(281704);
      return paramString;
    }
    AppMethodBeat.o(281704);
    return paramString;
  }
  
  private void cQC()
  {
    AppMethodBeat.i(281705);
    Object localObject = hLI();
    if (localObject == null)
    {
      AppMethodBeat.o(281705);
      return;
    }
    long l1 = ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_totalLen;
    long l2 = ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_offset;
    this.Rwe = l1;
    if (((com.tencent.mm.pluginsdk.model.app.c)localObject).field_totalLen == 0L) {}
    for (int i = 0;; i = (int)(((com.tencent.mm.pluginsdk.model.app.c)localObject).field_offset * 100L / ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_totalLen))
    {
      Log.v("MicroMsg.AppAttachNewDownloadUI", "summerapp attach progress:" + i + " offset:" + l2 + " totallen:" + l1 + " status " + ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_status);
      this.Wwq.setProgress(i);
      if ((((com.tencent.mm.pluginsdk.model.app.c)localObject).field_status != 199L) || (i < 100) || (this.WwA)) {
        break label361;
      }
      if (this.WwJ != null) {
        this.WwJ.Wf(this.Rwe);
      }
      this.WwA = true;
      if (this.WwI)
      {
        this.WwI = false;
        hLF();
      }
      if (this.scene != 3) {
        break;
      }
      localObject = new Intent();
      ((Intent)localObject).putExtra("filePath", this.filePath);
      ((Intent)localObject).putExtra("fileName", this.fileName);
      ((Intent)localObject).putExtra("fileExt", this.jmx);
      setResult(-1, (Intent)localObject);
      finish();
      AppMethodBeat.o(281705);
      return;
    }
    if (localObject != null)
    {
      Toast.makeText(this, getString(R.l.download_success) + " : " + byT(((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath), 5000).show();
      com.tencent.mm.pluginsdk.ui.tools.a.a(this, ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath, this.jmx, this.fileName, 1);
    }
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(283544);
        AppAttachNewDownloadUI.W(AppAttachNewDownloadUI.this);
        AppMethodBeat.o(283544);
      }
    }, 200L);
    label361:
    if ((this.Wwq.getVisibility() != 0) && (i < 100) && (!((com.tencent.mm.pluginsdk.model.app.c)localObject).field_isUpload) && (((com.tencent.mm.pluginsdk.model.app.c)localObject).field_status == 101L))
    {
      Log.i("MicroMsg.AppAttachNewDownloadUI", "summerapp still downloading updateProgress progress[%d]", new Object[] { Integer.valueOf(i) });
      Ge(false);
    }
    AppMethodBeat.o(281705);
  }
  
  private boolean den()
  {
    AppMethodBeat.i(281669);
    this.scene = getIntent().getIntExtra("scene", 0);
    this.msgId = getIntent().getLongExtra("app_msg_id", -1L);
    this.WwE = getIntent().getBooleanExtra("choose_way", false);
    this.WwF = getIntent().getIntExtra("msg_type", 0);
    if (this.msgId == -1L)
    {
      AppMethodBeat.o(281669);
      return false;
    }
    this.fNQ = getIntent().getBooleanExtra("app_show_share", true);
    bh.beI();
    this.fNz = com.tencent.mm.model.c.bbO().Oq(this.msgId);
    Object localObject1;
    if ((this.fNz == null) || (this.fNz.field_msgId == 0L) || (this.fNz.field_content == null))
    {
      if (!hLD()) {
        break label381;
      }
      localObject1 = (MsgQuoteItem)getIntent().getParcelableExtra("key_quoted_msg");
      if (localObject1 == null)
      {
        AppMethodBeat.o(281669);
        return false;
      }
      this.fNz = new ca();
      this.fNz.setType(((MsgQuoteItem)localObject1).type);
      this.fNz.EG(((MsgQuoteItem)localObject1).FkS);
      this.fNz.Jm(((MsgQuoteItem)localObject1).FkT);
      this.fNz.Ip(((MsgQuoteItem)localObject1).FkW);
      this.fNz.setContent(((MsgQuoteItem)localObject1).content);
      if (Util.isEqual(((MsgQuoteItem)localObject1).FkU, z.bcZ())) {
        this.fNz.pJ(1);
      }
    }
    this.Wwx = com.tencent.mm.model.ab.Lj(this.fNz.field_talker);
    this.fQs = this.fNz.field_content;
    if ((this.Wwx) && (this.fNz.field_isSend == 0)) {
      this.fQs = byS(this.fNz.field_content);
    }
    this.Wwy = k.b.OQ(this.fQs);
    if (this.Wwy == null)
    {
      Log.e("MicroMsg.AppAttachNewDownloadUI", "summerapp parse msgContent error, %s", new Object[] { this.fQs });
      AppMethodBeat.o(281669);
      return false;
      label381:
      AppMethodBeat.o(281669);
      return false;
    }
    if ((ae.isNullOrNil(this.Wwy.fvr)) && (!ae.isNullOrNil(this.Wwy.lml)))
    {
      Log.e("MicroMsg.AppAttachNewDownloadUI", "summerapp msgContent format error, %s", new Object[] { this.fQs });
      this.Wwy.fvr = this.Wwy.lml.hashCode();
    }
    this.appType = this.Wwy.type;
    this.mediaId = this.Wwy.fvr;
    this.fileName = ae.nullAsNil(this.Wwy.title);
    this.jmx = ae.nullAsNil(this.Wwy.llY).toLowerCase();
    this.Rwe = this.Wwy.llX;
    this.smU = ae.nullAsNil(this.Wwy.filemd5);
    this.fLi = ae.nullAsNil(this.Wwy.fLi);
    this.cdnURL = ae.nullAsNil(this.Wwy.lml);
    this.Wwz = ae.nullAsNil(this.Wwy.lmc);
    this.aesKey = ae.nullAsNil(this.Wwy.aesKey);
    this.authKey = ae.nullAsNil(this.Wwy.lmi);
    if (ae.isNullOrNil(this.jmx)) {
      this.jmx = u.asq(this.fileName);
    }
    Log.i("MicroMsg.AppAttachNewDownloadUI", "summerapp initParams msgId[%d], sender[%d], msgContent[%s], appType[%d], mediaId[%s], fileName[%s]", new Object[] { Long.valueOf(this.msgId), Integer.valueOf(this.fNz.field_isSend), this.fQs, Integer.valueOf(this.appType), this.mediaId, this.fileName });
    com.tencent.mm.pluginsdk.model.app.c localc = hLI();
    if (localc == null)
    {
      Log.i("MicroMsg.AppAttachNewDownloadUI", "summerapp initParams attInfo is null");
      this.WwB = false;
    }
    for (;;)
    {
      if (this.Wwy.type == 6) {
        ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.comm.a.b.class)).aa(String.valueOf(this.fNz.field_msgId), this.fNz.field_msgSvrId);
      }
      gm(4, 0);
      String str1 = ae.nullAsNil(z.bcZ());
      Object localObject2 = ae.nullAsNil(this.fNz.field_talker);
      localObject1 = localObject2;
      if (com.tencent.mm.model.ab.Lj((String)localObject2)) {
        localObject1 = ae.nullAsNil(this.Wwy.fLi);
      }
      label833:
      label844:
      boolean bool;
      label904:
      int i;
      if (this.fNz.field_isSend == 1)
      {
        localObject2 = str1;
        if (this.fNz.field_isSend != 1) {
          break label1261;
        }
        String str2 = ae.nullAsNil(this.filePath);
        String str3 = this.jmx;
        String str4 = this.fileName;
        String str5 = this.smU;
        long l = this.Rwe;
        String str6 = Long.toString(this.fNz.field_msgSvrId);
        if (ae.isNullOrNil(this.cdnURL)) {
          break label1268;
        }
        str1 = this.cdnURL;
        this.wOp = new HandOffFile(str2, str3, str4, str5, l, 1, str6, "", str1, this.aesKey, this.authKey, 1, "", 0, "", 0L, 1, (String)localObject2, (String)localObject1);
        bool = b(hLI());
        localObject1 = this.wOp;
        if (!bool) {
          break label1277;
        }
        i = 1;
        ((HandOffFile)localObject1).setFileStatus(i);
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.handoff.a.a.class)).g(this.wOp);
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.handoff.a.a.class)).c(this.wOp);
        localObject1 = new aco();
        localObject2 = getIntent().getByteArrayExtra("key_multi_task_common_info");
        if (localObject2 == null) {}
      }
      try
      {
        ((aco)localObject1).parseFrom((byte[])localObject2);
        if ((localc == null) || (!new com.tencent.mm.vfs.q(localc.field_fileFullPath).ifE()))
        {
          bool = false;
          this.WwA = bool;
          if (!b(localc)) {
            break label1511;
          }
          if (this.scene != 3) {
            break label1340;
          }
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("filePath", this.filePath);
          ((Intent)localObject1).putExtra("fileName", this.fileName);
          ((Intent)localObject1).putExtra("fileExt", this.jmx);
          setResult(-1, (Intent)localObject1);
          finish();
          AppMethodBeat.o(281669);
          return true;
          this.filePath = localc.field_fileFullPath;
          if (localc.field_offset > 0L) {}
          for (this.WwB = true;; this.WwB = false)
          {
            Log.i("MicroMsg.AppAttachNewDownloadUI", "summerapp initParams attInfo field_fileFullPath[%s], field_offset[%d], isDownloadStarted[%b], status[%s]", new Object[] { localc.field_fileFullPath, Long.valueOf(localc.field_offset), Boolean.valueOf(this.WwB), Long.valueOf(localc.field_status) });
            break;
          }
          localObject2 = localObject1;
          break label833;
          label1261:
          localObject1 = str1;
          break label844;
          label1268:
          str1 = this.Wwz;
          break label904;
          label1277:
          i = 2;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.AppAttachNewDownloadUI", localException, "", new Object[0]);
          continue;
          if ((localc.evg()) || ((this.fNz.field_isSend == 1) && (localc.field_isUpload))) {
            bool = true;
          } else {
            bool = false;
          }
        }
        label1340:
        if (this.scene == 1)
        {
          this.tNG = 7;
          if (this.WwE)
          {
            bool = com.tencent.mm.pluginsdk.ui.tools.a.c(this, localc.field_fileFullPath, this.jmx, this.tNG);
            AppMethodBeat.o(281669);
            return bool;
          }
          bool = com.tencent.mm.pluginsdk.ui.tools.a.a(localc.field_fileFullPath, this.jmx, this.tNG, (aco)localObject1);
          AppMethodBeat.o(281669);
          return bool;
        }
        if (this.tNG != 9) {
          this.tNG = 1;
        }
        if (this.WwE)
        {
          bool = com.tencent.mm.pluginsdk.ui.tools.a.c(this, localc.field_fileFullPath, this.jmx, this.tNG);
          AppMethodBeat.o(281669);
          return bool;
        }
        if (!com.tencent.mm.pluginsdk.ui.tools.a.nu(localc.field_fileFullPath, this.jmx))
        {
          bool = com.tencent.mm.pluginsdk.ui.tools.a.a(localc.field_fileFullPath, this.jmx, this.tNG, (aco)localObject1);
          AppMethodBeat.o(281669);
          return bool;
        }
        label1511:
        AppMethodBeat.o(281669);
      }
    }
    return true;
  }
  
  private void eiT()
  {
    AppMethodBeat.i(281711);
    Log.i("MicroMsg.AppAttachNewDownloadUI", "[ImageGalleryUI] showImage");
    Object localObject = new Intent(this, ImageGalleryUI.class);
    ((Intent)localObject).putExtra("img_gallery_msg_id", this.fNz.field_msgId);
    ((Intent)localObject).putExtra("img_gallery_talker", this.fNz.field_talker);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/ui/chatting/AppAttachNewDownloadUI", "showImage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/chatting/AppAttachNewDownloadUI", "showImage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    overridePendingTransition(0, 0);
    AppMethodBeat.o(281711);
  }
  
  private String getMimeType()
  {
    AppMethodBeat.i(281693);
    k.b localb = k.b.OQ(this.fQs);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localb.llY != null)
    {
      localObject1 = localObject2;
      if (localb.llY.length() > 0) {
        localObject1 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(localb.llY);
      }
    }
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((String)localObject1).length() != 0) {}
    }
    else
    {
      Log.w("MicroMsg.AppAttachNewDownloadUI", "getMimeType fail, not a built-in mimetype, use \"*/{fileext}\" instead");
      localObject2 = "*/" + localb.llY;
    }
    AppMethodBeat.o(281693);
    return localObject2;
  }
  
  private void gm(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(281725);
    long l;
    Object localObject;
    if ((6 == this.appType) || (74 == this.appType))
    {
      if (paramInt2 != -1) {
        com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1203L, paramInt2, 1L, false);
      }
      l = this.fNz.field_msgSvrId;
      if (this.Wwy == null) {
        break label295;
      }
      localObject = (com.tencent.mm.aj.a.b)this.Wwy.ar(com.tencent.mm.aj.a.b.class);
      if ((localObject == null) || (((com.tencent.mm.aj.a.b)localObject).lqB == 0L)) {
        break label295;
      }
      l = ((com.tencent.mm.aj.a.b)localObject).lqB;
    }
    label295:
    for (;;)
    {
      localObject = this.Wwy.lml;
      if (this.Wwy.lmb == 1) {}
      for (paramInt2 = 7;; paramInt2 = 5)
      {
        localObject = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { localObject, Integer.valueOf(paramInt2), Integer.valueOf(this.Wwy.llX), Integer.valueOf(paramInt1), Long.valueOf((cm.bfD() - this.fNz.field_createTime) / 1000L), this.jmx, this.fNz.field_talker, Integer.valueOf(1), "", Long.valueOf(l), Long.valueOf(this.fNz.field_createTime), Long.valueOf(cm.bfC()), Integer.valueOf(1) });
        Log.i("MicroMsg.AppAttachNewDownloadUI", "reportKVStat 14665 %s", new Object[] { localObject });
        com.tencent.mm.plugin.report.service.h.IzE.kvStat(14665, (String)localObject);
        AppMethodBeat.o(281725);
        return;
      }
    }
  }
  
  private void hLC()
  {
    AppMethodBeat.i(281665);
    this.WwJ = new com.tencent.mm.ui.chatting.j.b(new com.tencent.mm.plugin.multitask.a.b((MMActivity)super.getContext()));
    this.WwJ.d(this.filePath, this.jmx, this.tNG, true);
    this.WwJ.oc(this.jmx, this.fileName);
    this.wOp.saveToMultiTaskInfo(this.WwJ.FHd);
    AppMethodBeat.o(281665);
  }
  
  private boolean hLD()
  {
    return this.WwF == 1;
  }
  
  private void hLE()
  {
    AppMethodBeat.i(281682);
    Log.d("MicroMsg.AppAttachNewDownloadUI", "loadOpenMaterials");
    if (ae.isNullOrNil(this.filePath))
    {
      Log.w("MicroMsg.AppAttachNewDownloadUI", "loadOpenMaterials, filePath is empty");
      AppMethodBeat.o(281682);
      return;
    }
    if ((this.filePath.equals(this.Rxk)) && (this.QdI != null))
    {
      Log.i("MicroMsg.AppAttachNewDownloadUI", "loadOpenMaterials, already load");
      AppMethodBeat.o(281682);
      return;
    }
    MaterialModel localMaterialModel = MaterialModel.eQ(this.filePath, this.jmx);
    if (localMaterialModel == null)
    {
      Log.w("MicroMsg.AppAttachNewDownloadUI", "loadOpenMaterials, materialModel is null");
      AppMethodBeat.o(281682);
      return;
    }
    com.tencent.mm.plugin.appbrand.service.i locali = (com.tencent.mm.plugin.appbrand.service.i)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.i.class);
    if (locali == null)
    {
      Log.w("MicroMsg.AppAttachNewDownloadUI", "loadOpenMaterials, openMaterialService is null");
      AppMethodBeat.o(281682);
      return;
    }
    if (!locali.c(com.tencent.mm.plugin.appbrand.openmaterial.model.b.qns))
    {
      Log.i("MicroMsg.AppAttachNewDownloadUI", "loadOpenMaterials, openMaterialService is not enabled");
      AppMethodBeat.o(281682);
      return;
    }
    locali.alg(localMaterialModel.mimeType);
    locali.a(localMaterialModel, new AppAttachNewDownloadUI.b(this, localMaterialModel, locali));
    AppMethodBeat.o(281682);
  }
  
  private void hLF()
  {
    AppMethodBeat.i(281683);
    dd localdd = new dd();
    com.tencent.mm.pluginsdk.model.j.d(localdd, this.fNz);
    localdd.fyI.activity = this;
    localdd.fyI.fyP = 39;
    EventCenter.instance.publish(localdd);
    AppMethodBeat.o(281683);
  }
  
  private void hLG()
  {
    AppMethodBeat.i(281688);
    Ge(true);
    if (hLH())
    {
      Log.i("MicroMsg.AppAttachNewDownloadUI", "startToDownloadFile");
      if (this.HCv != null) {
        bh.aGY().a(this.HCv);
      }
      this.HCv = new com.tencent.mm.plugin.record.b.f(this.msgId, this.mediaId, this.Www);
      bh.aGY().a(this.HCv, 0);
      com.tencent.mm.modelsimple.ab.ah(this.fNz);
      gm(7, 1);
    }
    AppMethodBeat.o(281688);
  }
  
  private boolean hLH()
  {
    int i = -1;
    boolean bool2 = true;
    AppMethodBeat.i(281691);
    Object localObject1 = hLI();
    Object localObject2;
    boolean bool1;
    long l1;
    long l2;
    long l3;
    String str1;
    long l4;
    if (localObject1 == null)
    {
      m.M(this.msgId, this.fQs);
      localObject2 = hLI();
      localObject1 = localObject2;
      bool1 = bool2;
      if (localObject2 != null)
      {
        l1 = ((com.tencent.mm.pluginsdk.model.app.c)localObject2).systemRowid;
        l2 = ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_totalLen;
        localObject1 = ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath;
        l3 = ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_type;
        str1 = ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_mediaId;
        l4 = ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_msgInfoId;
        bool1 = ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_isUpload;
        if (((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_signature != null) {
          break label321;
        }
        Log.i("MicroMsg.AppAttachNewDownloadUI", "summerapp tryInitAttachInfo newInfo systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], signature len[%d]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), localObject1, Long.valueOf(l3), str1, Long.valueOf(l4), Boolean.valueOf(bool1), Integer.valueOf(i) });
        if (this.Wwy.lmb == 0)
        {
          localObject1 = localObject2;
          bool1 = bool2;
          if (this.Wwy.llX <= 26214400) {}
        }
        else
        {
          if (ae.isNullOrNil(((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_signature)) {
            break label333;
          }
          bool1 = true;
          label219:
          localObject1 = localObject2;
        }
      }
      if (this.Wwy == null) {
        break label596;
      }
      if ((localObject1 == null) || ((int)((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_status != 102)) {
        break label568;
      }
      Log.i("MicroMsg.AppAttachNewDownloadUI", "tryInitAttachInfo file is pause!");
    }
    label321:
    label333:
    label596:
    for (;;)
    {
      if (!bool1) {
        bh.aGY().a(new com.tencent.mm.plugin.record.b.d((com.tencent.mm.pluginsdk.model.app.c)localObject1, this.aesKey, this.smU, this.fileName, this.jmx, this.fLi), 0);
      }
      if (localObject1 != null)
      {
        this.filePath = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath;
        hLC();
      }
      AppMethodBeat.o(281691);
      return bool1;
      i = ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_signature.length();
      break;
      bool1 = false;
      break label219;
      localObject2 = new com.tencent.mm.vfs.q(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath);
      if ((((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_status == 199L) && (!((com.tencent.mm.vfs.q)localObject2).ifE()))
      {
        Log.i("MicroMsg.AppAttachNewDownloadUI", "summerapp tryInitAttachInfo info exist but file not!");
        m.M(this.msgId, this.fQs);
      }
      l1 = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).systemRowid;
      l2 = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_totalLen;
      str1 = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath;
      l3 = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_type;
      String str2 = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_mediaId;
      l4 = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_msgInfoId;
      bool1 = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_isUpload;
      boolean bool3 = ((com.tencent.mm.vfs.q)localObject2).ifE();
      long l5 = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_status;
      if (((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_signature == null) {}
      for (;;)
      {
        Log.i("MicroMsg.AppAttachNewDownloadUI", "summerapp tryInitAttachInfo info exist systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], file.exists[%b], status[%d], signature len[%d]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), str1, Long.valueOf(l3), str2, Long.valueOf(l4), Boolean.valueOf(bool1), Boolean.valueOf(bool3), Long.valueOf(l5), Integer.valueOf(i) });
        bool1 = bool2;
        break;
        i = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_signature.length();
      }
      if ((this.Wwy.lmb != 0) || (this.Wwy.llX > 26214400)) {
        bool1 = false;
      }
    }
  }
  
  private com.tencent.mm.pluginsdk.model.app.c hLI()
  {
    AppMethodBeat.i(281694);
    com.tencent.mm.pluginsdk.model.app.c localc = a(this.appType, this.msgId, this.mediaId, this.fQs);
    AppMethodBeat.o(281694);
    return localc;
  }
  
  private void hLJ()
  {
    AppMethodBeat.i(281706);
    switch (this.appType)
    {
    default: 
      this.wNZ.setVisibility(0);
      auY(8);
    }
    for (;;)
    {
      Object localObject;
      if (this.wOp.getFileStatus() != 1)
      {
        this.wOp.setFileStatus(1);
        localObject = hLI();
        if (localObject != null) {
          this.wOp.setFullPath(ae.nullAsNil(((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath));
        }
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.handoff.a.a.class)).g(this.wOp);
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.handoff.a.a.class)).e(this.wOp);
      }
      hLE();
      AppMethodBeat.o(281706);
      return;
      if (hLK()) {
        if (Util.isImageExt(this.jmx))
        {
          hLL();
        }
        else
        {
          auY(8);
          this.Wxc.setVisibility(8);
          if (getMimeType().equals("")) {
            this.wNZ.setVisibility(8);
          }
          for (;;)
          {
            hLQ();
            break;
            this.wNZ.setVisibility(0);
          }
          if (hLK()) {
            if (Util.isImageExt(this.jmx))
            {
              hLL();
            }
            else
            {
              Log.i("MicroMsg.AppAttachNewDownloadUI", "onDownLoadImpl");
              Ge(false);
              continue;
              if (hLK())
              {
                eiT();
                continue;
                localObject = new Intent();
                ((Intent)localObject).putExtra("App_MsgId", this.msgId);
                setResult(-1, (Intent)localObject);
                finish();
              }
            }
          }
        }
      }
    }
  }
  
  private boolean hLK()
  {
    AppMethodBeat.i(281707);
    Object localObject = hLI();
    if (localObject == null)
    {
      AppMethodBeat.o(281707);
      return true;
    }
    if (u.agG(((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath))
    {
      auY(8);
      this.Wxc.setVisibility(8);
      AppMethodBeat.o(281707);
      return true;
    }
    auY(8);
    hLM();
    if (this.scene == 3)
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("resLoadFailed", true);
      setResult(-1, (Intent)localObject);
      finish();
    }
    AppMethodBeat.o(281707);
    return false;
  }
  
  private void hLL()
  {
    AppMethodBeat.i(281709);
    Object localObject = hLI();
    if (localObject == null)
    {
      Log.e("MicroMsg.AppAttachNewDownloadUI", "info == null");
      AppMethodBeat.o(281709);
      return;
    }
    Intent localIntent = new Intent(this, ShowImageUI.class);
    localIntent.putExtra("key_message_id", this.fNz.field_msgId);
    localIntent.putExtra("key_image_path", ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath);
    localIntent.putExtra("key_favorite", true);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/ui/chatting/AppAttachNewDownloadUI", "showFileImage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/chatting/AppAttachNewDownloadUI", "showFileImage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    AppMethodBeat.o(281709);
  }
  
  private void hLM()
  {
    AppMethodBeat.i(281724);
    this.WwG.setVisibility(0);
    this.Wxc.Gf(false);
    this.Wxd.setVisibility(8);
    AppMethodBeat.o(281724);
  }
  
  private void hLP()
  {
    AppMethodBeat.i(281666);
    if (this.fNz.getType() == 1090519089)
    {
      if ((this.fNz.ilx == 0) && (!this.WwA))
      {
        this.fNz.apT();
        this.fNz.setFileStatus(0);
        ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().a(this.msgId, this.fNz);
        Log.i("MicroMsg.AppAttachNewDownloadUI", "checkFileStatus msgId:%s reset file sender", new Object[] { Long.valueOf(this.msgId) });
      }
      com.tencent.mm.pluginsdk.model.app.c localc = hLI();
      if ((localc != null) && (localc.field_status == 199L) && (!u.agG(localc.field_fileFullPath)))
      {
        localc.field_status = 102L;
        localc.field_offset = 0L;
        ao.ctZ().a(localc, new String[0]);
        com.tencent.mm.pluginsdk.model.a.b.QXV.ba(this.fNz);
      }
    }
    AppMethodBeat.o(281666);
  }
  
  private void hLQ()
  {
    AppMethodBeat.i(281687);
    this.Wwu.setVisibility(0);
    if (this.fileName.equals(""))
    {
      this.Wwu.setText(getString(R.l.openapi_app_file));
      AppMethodBeat.o(281687);
      return;
    }
    this.Wwu.setText(this.fileName);
    AppMethodBeat.o(281687);
  }
  
  private void init()
  {
    AppMethodBeat.i(281664);
    setMMTitle("");
    setActionbarColor(getResources().getColor(R.e.white));
    hideActionbarLine();
    if (!den())
    {
      finish();
      AppMethodBeat.o(281664);
      return;
    }
    hLP();
    com.tencent.mm.vfs.q localq = new com.tencent.mm.vfs.q(com.tencent.mm.loader.j.b.aSO());
    if (!localq.ifE()) {
      localq.ifK();
    }
    ao.ctZ().add(this);
    ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().a(this, Looper.getMainLooper());
    initView();
    hLC();
    AppMethodBeat.o(281664);
  }
  
  public final MMActivity dlC()
  {
    AppMethodBeat.i(293342);
    MMActivity localMMActivity = (MMActivity)super.getContext();
    AppMethodBeat.o(293342);
    return localMMActivity;
  }
  
  public final void fus()
  {
    AppMethodBeat.i(281717);
    Toast.makeText(this, R.l.eBM, 0).show();
    AppMethodBeat.o(281717);
  }
  
  public int getLayoutId()
  {
    return R.i.efT;
  }
  
  public void initView()
  {
    AppMethodBeat.i(281672);
    this.HnZ = ((MMImageView)findViewById(R.h.download_type_icon));
    this.Wwq = ((RoundProgressBtn)findViewById(R.h.dTb));
    this.Wxc = new AppAttachNewDownloadUI.a(this, (Button)findViewById(R.h.dEY), (TextView)findViewById(R.h.dEZ));
    this.wNZ = ((Button)findViewById(R.h.dFk));
    this.Wwu = ((TextView)findViewById(R.h.dFe));
    this.Wwv = ((TextView)findViewById(R.h.dFf));
    this.WwG = ((LinearLayout)findViewById(R.h.dFh));
    this.Wxd = ((TextView)findViewById(R.h.dSe));
    this.Wxe = ((ProgressBar)findViewById(R.h.dSf));
    this.Wxf = ((TextView)findViewById(R.h.duU));
    this.wOa = ((Button)findViewById(R.h.download_btn));
    this.WwK = ((LinearLayout)findViewById(R.h.dFj));
    this.WwL = ((ImageView)findViewById(R.h.dFi));
    this.WwL.setImageDrawable(au.o(this, R.k.icons_filled_mini_program, getResources().getColor(R.e.btn_green_text_color)));
    this.WwK.setOnClickListener(new AppAttachNewDownloadUI.1(this));
    this.Wwu.setOnTouchListener(this.wOs);
    this.Wwu.setOnLongClickListener(this.wOt);
    if (this.Wwu != null)
    {
      localObject = this.Wwu.getPaint();
      if (localObject != null) {
        ((Paint)localObject).setFakeBoldText(true);
      }
    }
    this.Wwq.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(279229);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/AppAttachNewDownloadUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        Log.i("MicroMsg.AppAttachNewDownloadUI", "summerapp roundProgressBar downloadAppAttachScene[%s]", new Object[] { AppAttachNewDownloadUI.b(AppAttachNewDownloadUI.this) });
        if (AppAttachNewDownloadUI.b(AppAttachNewDownloadUI.this) != null)
        {
          AppAttachNewDownloadUI.b(AppAttachNewDownloadUI.this).a(AppAttachNewDownloadUI.this);
          com.tencent.mm.kernel.h.aGY().a(AppAttachNewDownloadUI.b(AppAttachNewDownloadUI.this));
          AppAttachNewDownloadUI.b(AppAttachNewDownloadUI.this, 15, -1);
        }
        for (;;)
        {
          AppAttachNewDownloadUI.G(AppAttachNewDownloadUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/AppAttachNewDownloadUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(279229);
          return;
          paramAnonymousView = AppAttachNewDownloadUI.E(AppAttachNewDownloadUI.this);
          if ((paramAnonymousView != null) && (paramAnonymousView.field_status != 199L))
          {
            Log.i("MicroMsg.AppAttachNewDownloadUI", "summerapp roundProgressBar onClick but scene is null and set status[%d] paused", new Object[] { Long.valueOf(paramAnonymousView.field_status) });
            paramAnonymousView.field_status = 102L;
            ao.ctZ().a(paramAnonymousView, new String[0]);
            AppAttachNewDownloadUI.b(AppAttachNewDownloadUI.this, 15, -1);
          }
          com.tencent.mm.pluginsdk.model.a.b.QXV.ba(AppAttachNewDownloadUI.F(AppAttachNewDownloadUI.this));
        }
      }
    });
    Object localObject = this.Wxc;
    View.OnClickListener local3 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(281631);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/AppAttachNewDownloadUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (AppAttachNewDownloadUI.H(AppAttachNewDownloadUI.this))
        {
          paramAnonymousView = AppAttachNewDownloadUI.E(AppAttachNewDownloadUI.this);
          if (paramAnonymousView != null)
          {
            paramAnonymousView.field_status = 101L;
            paramAnonymousView.field_lastModifyTime = Util.nowSecond();
            ao.ctZ().a(paramAnonymousView, new String[0]);
          }
          if (AppAttachNewDownloadUI.b(AppAttachNewDownloadUI.this) != null) {
            bh.aGY().a(AppAttachNewDownloadUI.b(AppAttachNewDownloadUI.this));
          }
          AppAttachNewDownloadUI.a(AppAttachNewDownloadUI.this, new com.tencent.mm.plugin.record.b.f(AppAttachNewDownloadUI.I(AppAttachNewDownloadUI.this), AppAttachNewDownloadUI.J(AppAttachNewDownloadUI.this), AppAttachNewDownloadUI.K(AppAttachNewDownloadUI.this)));
          bh.aGY().a(AppAttachNewDownloadUI.b(AppAttachNewDownloadUI.this), 0);
          paramAnonymousView = com.tencent.mm.pluginsdk.model.a.b.QXV;
          com.tencent.mm.pluginsdk.model.a.b.b(AppAttachNewDownloadUI.F(AppAttachNewDownloadUI.this), AppAttachNewDownloadUI.L(AppAttachNewDownloadUI.this));
        }
        AppAttachNewDownloadUI.G(AppAttachNewDownloadUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/AppAttachNewDownloadUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(281631);
      }
    };
    ((AppAttachNewDownloadUI.a)localObject).xQQ.setOnClickListener(local3);
    this.wOa.setOnClickListener(new AppAttachNewDownloadUI.4(this));
    this.Wxf.setOnClickListener(new AppAttachNewDownloadUI.5(this));
    this.wNZ.setOnClickListener(new AppAttachNewDownloadUI.9(this));
    switch (this.appType)
    {
    case 1: 
    case 3: 
    case 5: 
    default: 
      this.HnZ.setImageResource(R.k.app_attach_file_icon_unknow);
      this.Www = new com.tencent.mm.an.j()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, com.tencent.mm.an.q paramAnonymousq)
        {
          AppMethodBeat.i(196501);
          if (paramAnonymousInt2 == 0) {}
          for (float f = 0.0F;; f = paramAnonymousInt1 * 100.0F / paramAnonymousInt2)
          {
            if ((paramAnonymousInt1 < paramAnonymousInt2) && (AppAttachNewDownloadUI.B(AppAttachNewDownloadUI.this).getVisibility() != 0))
            {
              AppAttachNewDownloadUI.C(AppAttachNewDownloadUI.this);
              AppAttachNewDownloadUI.D(AppAttachNewDownloadUI.this).setVisibility(8);
            }
            AppAttachNewDownloadUI.B(AppAttachNewDownloadUI.this).setProgress((int)f);
            AppMethodBeat.o(196501);
            return;
          }
        }
      };
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(288253);
          if (AppAttachNewDownloadUI.b(AppAttachNewDownloadUI.this) != null) {
            bh.aGY().a(AppAttachNewDownloadUI.b(AppAttachNewDownloadUI.this));
          }
          if ((AppAttachNewDownloadUI.c(AppAttachNewDownloadUI.this) != null) && (AppAttachNewDownloadUI.c(AppAttachNewDownloadUI.this).Q(1, false)))
          {
            AppMethodBeat.o(288253);
            return true;
          }
          AppAttachNewDownloadUI.this.finish();
          AppMethodBeat.o(288253);
          return true;
        }
      });
      if (this.fNQ) {
        addIconOptionMenu(0, R.k.actionbar_icon_dark_more, new AppAttachNewDownloadUI.13(this));
      }
      if ((!hLD()) || (this.fNz.field_msgId != 0L)) {
        break label683;
      }
      this.Wwv.setVisibility(8);
      this.Wwu.setVisibility(0);
      if (this.fileName.equals("")) {
        this.Wwu.setText(getString(R.l.openapi_app_file));
      }
      break;
    }
    for (;;)
    {
      hLM();
      if (this.scene == 3)
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("resLoadFailed", true);
        setResult(-1, (Intent)localObject);
        finish();
      }
      AppMethodBeat.o(281672);
      return;
      this.HnZ.setImageResource(R.g.app_attach_file_icon_pic);
      break;
      this.HnZ.setImageResource(R.k.app_attach_file_icon_video);
      break;
      this.HnZ.setImageResource(v.bpJ(this.jmx));
      break;
      if (Util.isImageExt(this.jmx))
      {
        this.HnZ.setImageResource(R.g.app_attach_file_icon_pic);
        break;
      }
      this.HnZ.setImageResource(R.k.app_attach_file_icon_unknow);
      break;
      this.Wwu.setText(this.fileName);
    }
    label683:
    if (this.Rwe > 0L)
    {
      this.Wwv.setVisibility(0);
      this.Wwv.setText(getResources().getString(R.l.eEY, new Object[] { ae.getSizeKB(this.Rwe) }));
    }
    while (this.WwA)
    {
      Log.i("MicroMsg.AppAttachNewDownloadUI", "summerapp isCanOpenFile");
      hLJ();
      AppMethodBeat.o(281672);
      return;
      this.Wwv.setVisibility(8);
    }
    switch (this.appType)
    {
    default: 
    case 0: 
    case 6: 
    case 74: 
      for (;;)
      {
        Log.i("MicroMsg.AppAttachNewDownloadUI", "summerapp progressCallBack[%s], isDownloadFinished[%b], isDownloadStarted[%b]", new Object[] { this.Www, Boolean.valueOf(this.WwA), Boolean.valueOf(this.WwB) });
        if ((this.appType == 2) || ((!this.WwA) && (!this.WwB) && (this.appType != 74))) {
          hLG();
        }
        AppMethodBeat.o(281672);
        return;
        this.wOa.setVisibility(8);
        if (this.WwB) {
          this.Wxc.setVisibility(0);
        }
        for (;;)
        {
          auY(8);
          this.wNZ.setVisibility(8);
          Log.d("MicroMsg.AppAttachNewDownloadUI", "hide moreOpenWaysArea");
          this.WwK.setVisibility(4);
          hLQ();
          break;
          this.Wxc.setVisibility(8);
        }
        this.WwK.setVisibility(4);
        Ge(false);
      }
    case 7: 
      if (this.WwB)
      {
        this.Wxc.setVisibility(0);
        label1010:
        auY(8);
      }
      break;
    }
    for (;;)
    {
      this.wNZ.setVisibility(8);
      Log.d("MicroMsg.AppAttachNewDownloadUI", "hide moreOpenWaysArea");
      this.WwK.setVisibility(4);
      this.Wwu.setVisibility(8);
      break;
      this.Wxc.setVisibility(8);
      break label1010;
      auY(8);
      if (this.WwB) {
        this.Wxc.setVisibility(0);
      } else {
        this.Wxc.setVisibility(8);
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(281698);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.tencent.mm.pluginsdk.ui.tools.a.a(this, paramInt1, paramInt2, paramIntent, this.WwC, R.l.download_no_match_msg, R.l.download_no_match_title, 1);
    AppMethodBeat.o(281698);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(281662);
    super.onCreate(paramBundle);
    init();
    AppMethodBeat.o(281662);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(281689);
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    paramContextMenu.add(0, 0, 0, getString(R.l.app_copy));
    AppMethodBeat.o(281689);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(281675);
    if (this.HCv != null) {
      this.HCv.lPi = null;
    }
    ao.ctZ().remove(this);
    ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().a(this);
    super.onDestroy();
    if (this.wOp != null) {
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.handoff.a.a.class)).d(this.wOp);
    }
    AppMethodBeat.o(281675);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(281681);
    Log.i("MicroMsg.AppAttachNewDownloadUI", "onKeyDown keyCode %d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt == 4) && (this.WwJ != null) && (this.WwJ.Q(2, false)))
    {
      AppMethodBeat.o(281681);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(281681);
    return bool;
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(281719);
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    if (this.WwJ != null) {
      this.WwJ.aOj();
    }
    init();
    AppMethodBeat.o(281719);
  }
  
  public void onNotifyChange(com.tencent.mm.plugin.messenger.foundation.a.a.i parami, i.c paramc)
  {
    AppMethodBeat.i(281702);
    if ((parami == null) || (paramc == null))
    {
      AppMethodBeat.o(281702);
      return;
    }
    if (this.appType == 74)
    {
      parami = paramc.kvM.iterator();
      while (parami.hasNext())
      {
        ca localca = (ca)parami.next();
        if (this.msgId == localca.field_msgId)
        {
          paramc = localca.field_content;
          parami = paramc;
          if (this.Wwx)
          {
            parami = paramc;
            if (localca.field_isSend == 0) {
              parami = byS(localca.field_content);
            }
          }
          parami = k.b.OQ(parami);
          if (parami != null)
          {
            Log.i("MicroMsg.AppAttachNewDownloadUI", "update msgId:%s newType:%s newFileStatus:%s", new Object[] { Long.valueOf(this.msgId), Integer.valueOf(parami.type), Integer.valueOf(localca.fileStatus) });
            if ((parami.type == 6) && (this.fNz.fileStatus == 1))
            {
              if (!den())
              {
                finish();
                AppMethodBeat.o(281702);
                return;
              }
              Ge(true);
              AppMethodBeat.o(281702);
              return;
            }
            if ((parami.type == 6) && (!den()))
            {
              finish();
              AppMethodBeat.o(281702);
              return;
            }
          }
        }
      }
    }
    AppMethodBeat.o(281702);
  }
  
  public void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(281700);
    cQC();
    AppMethodBeat.o(281700);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(281679);
    bh.aGY().b(221, this);
    bh.aGY().b(728, this);
    super.onPause();
    if (this.WwJ != null) {
      this.WwJ.aOj();
    }
    qe localqe = new qe();
    localqe.fOR.pause = false;
    qe.a locala = localqe.fOR;
    if (this.fNz == null) {}
    for (String str = "";; str = this.fNz.field_talker)
    {
      locala.talker = str;
      EventCenter.instance.asyncPublish(localqe, getMainLooper());
      Log.d("MicroMsg.AppAttachNewDownloadUI", "AppAttachDownloadUI cancel pause auto download logic");
      AppMethodBeat.o(281679);
      return;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(281677);
    super.onResume();
    bh.aGY().a(221, this);
    bh.aGY().a(728, this);
    qe localqe = new qe();
    localqe.fOR.pause = true;
    localqe.fOR.talker = this.fNz.field_talker;
    EventCenter.instance.asyncPublish(localqe, getMainLooper());
    Log.d("MicroMsg.AppAttachNewDownloadUI", "AppAttachDownloadUI req pause auto download logic");
    this.wNZ.setEnabled(true);
    if (this.WwJ != null) {
      this.WwJ.bNV();
    }
    AppMethodBeat.o(281677);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(281715);
    Log.i("MicroMsg.AppAttachNewDownloadUI", "summerapp onSceneEnd type[%d], [%d, %d, %s]", new Object[] { Integer.valueOf(paramq.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramq.getType() != 221) && (paramq.getType() != 728))
    {
      AppMethodBeat.o(281715);
      return;
    }
    if ((paramq.getType() == 728) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = hLI();
      if (paramString == null)
      {
        Log.i("MicroMsg.AppAttachNewDownloadUI", "summerapp onSceneEnd getAppAttachInfo is null");
        if (paramString != null)
        {
          paramString.field_status = 101L;
          paramString.field_lastModifyTime = Util.nowSecond();
          ao.ctZ().a(paramString, new String[0]);
        }
        if (this.HCv != null) {
          bh.aGY().a(this.HCv);
        }
        this.HCv = new com.tencent.mm.plugin.record.b.f(this.msgId, this.mediaId, this.Www);
        bh.aGY().a(this.HCv, 0);
        AppMethodBeat.o(281715);
        return;
      }
      if (paramString.field_signature == null) {}
      for (paramInt1 = -1;; paramInt1 = paramString.field_signature.length())
      {
        Log.i("MicroMsg.AppAttachNewDownloadUI", "summerapp onSceneEnd CheckBigFileDownload ok signature len[%d] start NetSceneDownloadAppAttach", new Object[] { Integer.valueOf(paramInt1) });
        break;
      }
    }
    if ((this.HCv == null) && ((paramq instanceof com.tencent.mm.plugin.record.b.f)))
    {
      paramString = (com.tencent.mm.plugin.record.b.f)paramq;
      com.tencent.mm.pluginsdk.model.app.c localc = hLI();
      if ((localc != null) && (!ae.isNullOrNil(localc.field_mediaSvrId)) && (localc.field_mediaSvrId.equals(paramString.getMediaId())))
      {
        this.HCv = paramString;
        Log.i("MicroMsg.AppAttachNewDownloadUI", "summerapp onSceneEnd reset downloadAppAttachScene[%s] by mediaSvrId[%s]", new Object[] { this.HCv, localc.field_mediaSvrId });
      }
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (this.Wwy.type == 6)
      {
        gm(0, 2);
        paramString = hLI();
        if (paramString != null) {
          com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1203L, 5L, paramString.field_totalLen, false);
        }
      }
      AppMethodBeat.o(281715);
      return;
    }
    if ((paramInt2 != 0) && (CrashReportFactory.hasDebuger())) {
      Toast.makeText(this, "errCode[" + paramInt2 + "]", 0).show();
    }
    if ((paramInt2 == -5103087) || (paramInt2 == -5103017) || (paramInt2 == -5103059))
    {
      paramString = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(this.msgId);
      paramString.setFileStatus(4);
      ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().a(paramString.field_msgId, paramString);
      Log.i("MicroMsg.AppAttachNewDownloadUI", "msgId:%s fail, errCode:%s", new Object[] { Long.valueOf(this.msgId), Integer.valueOf(paramInt2) });
    }
    if (paramInt2 == -5103059)
    {
      hLM();
      auY(8);
      gm(1, 3);
      if (this.scene == 3)
      {
        paramString = new Intent();
        paramString.putExtra("resLoadFailed", true);
        setResult(-1, paramString);
        finish();
      }
      AppMethodBeat.o(281715);
      return;
    }
    Ge(false);
    Log.e("MicroMsg.AppAttachNewDownloadUI", "summerapp onSceneEnd, download fail, type = " + paramq.getType() + " errType = " + paramInt1 + ", errCode = " + paramInt2);
    AppMethodBeat.o(281715);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppAttachNewDownloadUI
 * JD-Core Version:    0.7.0.1
 */