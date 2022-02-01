package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Bundle;
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

public class AppAttachDownloadUI
  extends MMSecDataActivity
  implements com.tencent.mm.an.i, f.b, MStorage.IOnStorageChange
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
  private int WwD;
  private boolean WwE;
  private int WwF;
  private LinearLayout WwG;
  private LinearLayout WwH;
  private boolean WwI;
  private com.tencent.mm.ui.chatting.j.b WwJ;
  private LinearLayout WwK;
  private ImageView WwL;
  private RoundProgressBtn Wwq;
  private AppAttachDownloadUI.a Wwr;
  private View Wws;
  private TextView Wwt;
  private TextView Wwu;
  private TextView Wwv;
  private com.tencent.mm.an.j Www;
  private boolean Wwx;
  private k.b Wwy;
  private String Wwz;
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
  private TextView mSz;
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
  private HandOffFile wOp;
  private View.OnTouchListener wOs;
  private View.OnLongClickListener wOt;
  
  public AppAttachDownloadUI()
  {
    AppMethodBeat.i(34129);
    this.tNG = 0;
    this.WwA = false;
    this.WwB = false;
    this.WwC = true;
    this.WwD = 5000;
    this.WwE = false;
    this.WwI = false;
    this.Rxk = null;
    this.QdI = null;
    this.Rxl = null;
    this.QdJ = null;
    this.rZT = null;
    this.szq = null;
    this.voR = new AppAttachDownloadUI.4(this);
    this.wOs = new AppAttachDownloadUI.5(this);
    this.wOt = new AppAttachDownloadUI.6(this);
    AppMethodBeat.o(34129);
  }
  
  private void auY(int paramInt)
  {
    AppMethodBeat.i(34158);
    if (paramInt != this.Wwq.getVisibility())
    {
      Log.i("MicroMsg.AppAttachDownloadUI", "setRoundProgressBar %s %s", new Object[] { Integer.valueOf(paramInt), ae.bvD() });
      this.Wwq.setVisibility(paramInt);
    }
    AppMethodBeat.o(34158);
  }
  
  private static boolean b(com.tencent.mm.pluginsdk.model.app.c paramc)
  {
    AppMethodBeat.i(34157);
    if (paramc == null)
    {
      AppMethodBeat.o(34157);
      return false;
    }
    com.tencent.mm.vfs.q localq = new com.tencent.mm.vfs.q(paramc.field_fileFullPath);
    if ((localq.ifE()) && (localq.length() == paramc.field_totalLen))
    {
      AppMethodBeat.o(34157);
      return true;
    }
    AppMethodBeat.o(34157);
    return false;
  }
  
  private boolean den()
  {
    AppMethodBeat.i(34134);
    this.scene = getIntent().getIntExtra("scene", 0);
    this.msgId = getIntent().getLongExtra("app_msg_id", -1L);
    this.WwE = getIntent().getBooleanExtra("choose_way", false);
    this.WwF = getIntent().getIntExtra("msg_type", 0);
    if (this.msgId == -1L)
    {
      AppMethodBeat.o(34134);
      return false;
    }
    bh.beI();
    this.fNz = com.tencent.mm.model.c.bbO().Oq(this.msgId);
    Object localObject1;
    if ((this.fNz == null) || (this.fNz.field_msgId == 0L) || (this.fNz.field_content == null))
    {
      if (!hLD()) {
        break label393;
      }
      localObject1 = (MsgQuoteItem)getIntent().getParcelableExtra("key_quoted_msg");
      if (localObject1 == null)
      {
        AppMethodBeat.o(34134);
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
    Object localObject2;
    if ((this.Wwx) && (this.fNz.field_isSend == 0))
    {
      localObject2 = this.fNz.field_content;
      localObject1 = localObject2;
      if (this.Wwx)
      {
        localObject1 = localObject2;
        if (localObject2 != null) {
          localObject1 = bq.RM((String)localObject2);
        }
      }
      this.fQs = ((String)localObject1);
    }
    this.Wwy = k.b.OQ(this.fQs);
    if (this.Wwy == null)
    {
      Log.e("MicroMsg.AppAttachDownloadUI", "summerapp parse msgContent error, %s", new Object[] { this.fQs });
      AppMethodBeat.o(34134);
      return false;
      label393:
      AppMethodBeat.o(34134);
      return false;
    }
    if ((ae.isNullOrNil(this.Wwy.fvr)) && (!ae.isNullOrNil(this.Wwy.lml)))
    {
      Log.e("MicroMsg.AppAttachDownloadUI", "summerapp msgContent format error, %s", new Object[] { this.fQs });
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
    Log.i("MicroMsg.AppAttachDownloadUI", "summerapp initParams msgId[%d], sender[%d], msgContent[%s], appType[%d], mediaId[%s], fileName[%s]", new Object[] { Long.valueOf(this.msgId), Integer.valueOf(this.fNz.field_isSend), this.fQs, Integer.valueOf(this.appType), this.mediaId, this.fileName });
    com.tencent.mm.pluginsdk.model.app.c localc = hLI();
    if (localc == null)
    {
      Log.i("MicroMsg.AppAttachDownloadUI", "summerapp initParams attInfo is null");
      this.WwB = false;
    }
    for (;;)
    {
      if (this.Wwy.type == 6) {
        ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.comm.a.b.class)).aa(String.valueOf(this.fNz.field_msgId), this.fNz.field_msgSvrId);
      }
      gm(4, 0);
      String str1 = ae.nullAsNil(z.bcZ());
      localObject2 = ae.nullAsNil(this.fNz.field_talker);
      localObject1 = localObject2;
      if (com.tencent.mm.model.ab.Lj((String)localObject2)) {
        localObject1 = ae.nullAsNil(this.Wwy.fLi);
      }
      label845:
      label856:
      boolean bool;
      label916:
      int i;
      if (this.fNz.field_isSend == 1)
      {
        localObject2 = str1;
        if (this.fNz.field_isSend != 1) {
          break label1243;
        }
        String str2 = ae.nullAsNil(this.filePath);
        String str3 = this.jmx;
        String str4 = this.fileName;
        String str5 = this.smU;
        long l = this.Rwe;
        String str6 = Long.toString(this.fNz.field_msgSvrId);
        if (ae.isNullOrNil(this.cdnURL)) {
          break label1250;
        }
        str1 = this.cdnURL;
        this.wOp = new HandOffFile(str2, str3, str4, str5, l, 1, str6, "", str1, this.aesKey, this.authKey, 1, "", 0, "", 0L, 1, (String)localObject2, (String)localObject1);
        bool = b(hLI());
        localObject1 = this.wOp;
        if (!bool) {
          break label1259;
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
        if (b(localc)) {
          if (this.scene == 3)
          {
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("filePath", this.filePath);
            ((Intent)localObject1).putExtra("fileName", this.fileName);
            ((Intent)localObject1).putExtra("fileExt", this.jmx);
            setResult(-1, (Intent)localObject1);
            finish();
            AppMethodBeat.o(34134);
            return true;
            this.filePath = localc.field_fileFullPath;
            new com.tencent.mm.vfs.q(localc.field_fileFullPath);
            if (localc.field_offset > 0L) {}
            for (this.WwB = true;; this.WwB = false)
            {
              Log.i("MicroMsg.AppAttachDownloadUI", "summerapp initParams attInfo field_fileFullPath[%s], field_offset[%d], isDownloadStarted[%b]", new Object[] { localc.field_fileFullPath, Long.valueOf(localc.field_offset), Boolean.valueOf(this.WwB) });
              break;
            }
            localObject2 = localObject1;
            break label845;
            label1243:
            localObject1 = str1;
            break label856;
            label1250:
            str1 = this.Wwz;
            break label916;
            label1259:
            i = 2;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.AppAttachDownloadUI", localException, "", new Object[0]);
        }
        if (this.scene == 1)
        {
          this.tNG = 7;
          if (this.WwE)
          {
            bool = com.tencent.mm.pluginsdk.ui.tools.a.c(this, localc.field_fileFullPath, this.jmx, this.tNG);
            AppMethodBeat.o(34134);
            return bool;
          }
          bool = com.tencent.mm.pluginsdk.ui.tools.a.a(localc.field_fileFullPath, this.jmx, this.tNG, (aco)localObject1);
          AppMethodBeat.o(34134);
          return bool;
        }
        if (this.tNG != 9) {
          this.tNG = 1;
        }
        if (this.WwE)
        {
          bool = com.tencent.mm.pluginsdk.ui.tools.a.c(this, localc.field_fileFullPath, this.jmx, this.tNG);
          AppMethodBeat.o(34134);
          return bool;
        }
        if (!com.tencent.mm.pluginsdk.ui.tools.a.nu(localc.field_fileFullPath, this.jmx))
        {
          bool = com.tencent.mm.pluginsdk.ui.tools.a.a(localc.field_fileFullPath, this.jmx, this.tNG, (aco)localObject1);
          AppMethodBeat.o(34134);
          return bool;
        }
        AppMethodBeat.o(34134);
      }
    }
    return true;
  }
  
  private void eiT()
  {
    AppMethodBeat.i(34153);
    Log.i("MicroMsg.AppAttachDownloadUI", "[ImageGalleryUI] showImage");
    Object localObject = new Intent(this, ImageGalleryUI.class);
    ((Intent)localObject).putExtra("img_gallery_msg_id", this.fNz.field_msgId);
    ((Intent)localObject).putExtra("img_gallery_talker", this.fNz.field_talker);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/ui/chatting/AppAttachDownloadUI", "showImage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/chatting/AppAttachDownloadUI", "showImage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    overridePendingTransition(0, 0);
    AppMethodBeat.o(34153);
  }
  
  private String getMimeType()
  {
    AppMethodBeat.i(34146);
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
      Log.w("MicroMsg.AppAttachDownloadUI", "getMimeType fail, not a built-in mimetype, use \"*/{fileext}\" instead");
      localObject2 = "*/" + localb.llY;
    }
    AppMethodBeat.o(34146);
    return localObject2;
  }
  
  private void gm(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(34161);
    String str;
    if (6 == this.appType)
    {
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1203L, paramInt2, 1L, false);
      str = this.Wwy.lml;
      if (this.Wwy.lmb != 1) {
        break label226;
      }
    }
    label226:
    for (paramInt2 = 7;; paramInt2 = 5)
    {
      str = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { str, Integer.valueOf(paramInt2), Integer.valueOf(this.Wwy.llX), Integer.valueOf(paramInt1), Long.valueOf((cm.bfD() - this.fNz.field_createTime) / 1000L), this.jmx, this.fNz.field_talker, Integer.valueOf(1), "", Long.valueOf(this.fNz.field_msgSvrId), Long.valueOf(this.fNz.field_createTime), Long.valueOf(cm.bfC()), Integer.valueOf(1) });
      Log.i("MicroMsg.AppAttachDownloadUI", "reportKVStat 14665 %s", new Object[] { str });
      com.tencent.mm.plugin.report.service.h.IzE.kvStat(14665, str);
      AppMethodBeat.o(34161);
      return;
    }
  }
  
  private void hLC()
  {
    AppMethodBeat.i(266347);
    this.WwJ = new com.tencent.mm.ui.chatting.j.b(new com.tencent.mm.plugin.multitask.a.b((MMActivity)super.getContext()));
    this.WwJ.d(this.filePath, this.jmx, this.tNG, true);
    this.WwJ.oc(this.jmx, this.fileName);
    this.wOp.saveToMultiTaskInfo(this.WwJ.FHd);
    AppMethodBeat.o(266347);
  }
  
  private boolean hLD()
  {
    return this.WwF == 1;
  }
  
  private void hLE()
  {
    AppMethodBeat.i(266349);
    Log.d("MicroMsg.AppAttachDownloadUI", "loadOpenMaterials");
    if (ae.isNullOrNil(this.filePath))
    {
      Log.w("MicroMsg.AppAttachDownloadUI", "loadOpenMaterials, filePath is empty");
      AppMethodBeat.o(266349);
      return;
    }
    if ((this.filePath.equals(this.Rxk)) && (this.QdI != null))
    {
      Log.i("MicroMsg.AppAttachDownloadUI", "loadOpenMaterials, already load");
      AppMethodBeat.o(266349);
      return;
    }
    MaterialModel localMaterialModel = MaterialModel.eQ(this.filePath, this.jmx);
    if (localMaterialModel == null)
    {
      Log.w("MicroMsg.AppAttachDownloadUI", "loadOpenMaterials, materialModel is null");
      AppMethodBeat.o(266349);
      return;
    }
    com.tencent.mm.plugin.appbrand.service.i locali = (com.tencent.mm.plugin.appbrand.service.i)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.i.class);
    if (locali == null)
    {
      Log.w("MicroMsg.AppAttachDownloadUI", "loadOpenMaterials, openMaterialService is null");
      AppMethodBeat.o(266349);
      return;
    }
    if (!locali.c(com.tencent.mm.plugin.appbrand.openmaterial.model.b.qns))
    {
      Log.i("MicroMsg.AppAttachDownloadUI", "loadOpenMaterials, openMaterialService is not enabled");
      AppMethodBeat.o(266349);
      return;
    }
    locali.alg(localMaterialModel.mimeType);
    locali.a(localMaterialModel, new AppAttachDownloadUI.b(this, localMaterialModel, locali));
    AppMethodBeat.o(266349);
  }
  
  private void hLF()
  {
    AppMethodBeat.i(34141);
    dd localdd = new dd();
    com.tencent.mm.pluginsdk.model.j.d(localdd, this.fNz);
    localdd.fyI.activity = this;
    localdd.fyI.fyP = 39;
    EventCenter.instance.publish(localdd);
    AppMethodBeat.o(34141);
  }
  
  private void hLG()
  {
    AppMethodBeat.i(34143);
    auY(0);
    this.Wwr.setVisibility(8);
    if (hLH())
    {
      Log.i("MicroMsg.AppAttachDownloadUI", "startToDownloadFile");
      if (this.HCv != null) {
        bh.aGY().a(this.HCv);
      }
      this.HCv = new com.tencent.mm.plugin.record.b.f(this.msgId, this.mediaId, this.Www);
      bh.aGY().a(this.HCv, 0);
      com.tencent.mm.modelsimple.ab.ah(this.fNz);
      gm(7, 1);
    }
    AppMethodBeat.o(34143);
  }
  
  private boolean hLH()
  {
    int i = -1;
    boolean bool2 = true;
    AppMethodBeat.i(34145);
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
          break label322;
        }
        Log.i("MicroMsg.AppAttachDownloadUI", "summerapp tryInitAttachInfo newInfo systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], signature len[%d]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), localObject1, Long.valueOf(l3), str1, Long.valueOf(l4), Boolean.valueOf(bool1), Integer.valueOf(i) });
        if (this.Wwy.lmb == 0)
        {
          localObject1 = localObject2;
          bool1 = bool2;
          if (this.Wwy.llX <= 26214400) {}
        }
        else
        {
          if (ae.isNullOrNil(((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_signature)) {
            break label334;
          }
          bool1 = true;
          label219:
          localObject1 = localObject2;
        }
      }
      if ((this.Wwy == null) || ((this.Wwy.lmb == 0) && (this.Wwy.llX <= 26214400))) {
        break label569;
      }
      bool1 = false;
    }
    label569:
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
      AppMethodBeat.o(34145);
      return bool1;
      label322:
      i = ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_signature.length();
      break;
      label334:
      bool1 = false;
      break label219;
      localObject2 = new com.tencent.mm.vfs.q(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath);
      if ((((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_status == 199L) && (!((com.tencent.mm.vfs.q)localObject2).ifE()))
      {
        Log.i("MicroMsg.AppAttachDownloadUI", "summerapp tryInitAttachInfo info exist but file not!");
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
        Log.i("MicroMsg.AppAttachDownloadUI", "summerapp tryInitAttachInfo info exist systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], file.exists[%b], status[%d], signature len[%d]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), str1, Long.valueOf(l3), str2, Long.valueOf(l4), Boolean.valueOf(bool1), Boolean.valueOf(bool3), Long.valueOf(l5), Integer.valueOf(i) });
        bool1 = bool2;
        break;
        i = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_signature.length();
      }
    }
  }
  
  private com.tencent.mm.pluginsdk.model.app.c hLI()
  {
    AppMethodBeat.i(34147);
    if (this.appType == 74)
    {
      AppMethodBeat.o(34147);
      return null;
    }
    com.tencent.mm.pluginsdk.model.app.c localc1 = ao.ctZ().TR(this.msgId);
    if (localc1 != null)
    {
      Log.i("MicroMsg.AppAttachDownloadUI", "summerapp getAppAttachInfo by msgId [%d] stack[%s]", new Object[] { Long.valueOf(this.msgId), ae.bvD() });
      AppMethodBeat.o(34147);
      return localc1;
    }
    localc1 = m.bqf(this.mediaId);
    if (localc1 == null)
    {
      Log.i("MicroMsg.AppAttachDownloadUI", "summerapp getAppAttachInfo by msgId and mediaId is null stack[%s]", new Object[] { ae.bvD() });
      AppMethodBeat.o(34147);
      return localc1;
    }
    if ((localc1.field_msgInfoId == this.msgId) || (u.agG(localc1.field_fileFullPath)))
    {
      AppMethodBeat.o(34147);
      return localc1;
    }
    m.M(this.msgId, this.fQs);
    com.tencent.mm.pluginsdk.model.app.c localc2 = ao.ctZ().TR(this.msgId);
    if (localc2 == null)
    {
      Log.w("MicroMsg.AppAttachDownloadUI", "summerapp getAppAttachInfo create new info from local but failed stack[%s]", new Object[] { ae.bvD() });
      AppMethodBeat.o(34147);
      return localc1;
    }
    ThreadPool.post(new AppAttachDownloadUI.8(this, localc1, localc2), "copyAttachFromLocal");
    AppMethodBeat.o(34147);
    return localc1;
  }
  
  private void hLJ()
  {
    AppMethodBeat.i(34150);
    switch (this.appType)
    {
    case 1: 
    case 3: 
    case 4: 
    case 5: 
    default: 
      this.wNZ.setVisibility(0);
      auY(8);
      this.Wws.setVisibility(8);
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
      AppMethodBeat.o(34150);
      return;
      if (hLK()) {
        if (Util.isImageExt(this.jmx))
        {
          hLL();
        }
        else
        {
          localObject = getMimeType();
          Log.i("MicroMsg.AppAttachDownloadUI", "onDownLoadImpl");
          hLN();
          auY(8);
          this.Wws.setVisibility(8);
          this.Wwr.setVisibility(8);
          this.Wwu.setVisibility(0);
          if (this.fileName.equals("")) {
            this.Wwu.setText(getString(R.l.openapi_app_file));
          }
          for (;;)
          {
            if ((localObject != null) && (!((String)localObject).equals(""))) {
              break label322;
            }
            this.wNZ.setVisibility(8);
            this.mSz.setText(getString(R.l.eBI));
            break;
            this.Wwu.setText(this.fileName);
          }
          label322:
          this.wNZ.setVisibility(0);
          this.mSz.setText(getString(R.l.eBJ));
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
  
  private boolean hLK()
  {
    AppMethodBeat.i(34151);
    Object localObject = hLI();
    if (localObject == null)
    {
      AppMethodBeat.o(34151);
      return true;
    }
    if (u.agG(((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath))
    {
      auY(8);
      this.Wws.setVisibility(8);
      this.Wwr.setVisibility(8);
      AppMethodBeat.o(34151);
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
    AppMethodBeat.o(34151);
    return false;
  }
  
  private void hLL()
  {
    AppMethodBeat.i(34152);
    Object localObject = hLI();
    if (localObject == null)
    {
      Log.e("MicroMsg.AppAttachDownloadUI", "info == null");
      AppMethodBeat.o(34152);
      return;
    }
    Intent localIntent = new Intent(this, ShowImageUI.class);
    localIntent.putExtra("key_message_id", this.fNz.field_msgId);
    localIntent.putExtra("key_image_path", ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath);
    localIntent.putExtra("key_favorite", true);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/ui/chatting/AppAttachDownloadUI", "showFileImage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/chatting/AppAttachDownloadUI", "showFileImage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    AppMethodBeat.o(34152);
  }
  
  private void hLM()
  {
    AppMethodBeat.i(34159);
    this.WwG.setVisibility(0);
    this.WwH.setVisibility(8);
    hLN();
    this.Wwr.hLO();
    AppMethodBeat.o(34159);
  }
  
  private void hLN()
  {
    AppMethodBeat.i(34160);
    this.mSz.setVisibility(8);
    AppMethodBeat.o(34160);
  }
  
  private void init()
  {
    AppMethodBeat.i(34131);
    setMMTitle("");
    setActionbarColor(getResources().getColor(R.e.white));
    hideActionbarLine();
    if (!den())
    {
      finish();
      AppMethodBeat.o(34131);
      return;
    }
    com.tencent.mm.vfs.q localq = new com.tencent.mm.vfs.q(com.tencent.mm.loader.j.b.aSO());
    if (!localq.ifE()) {
      localq.ifK();
    }
    ao.ctZ().add(this);
    initView();
    hLC();
    AppMethodBeat.o(34131);
  }
  
  public final MMActivity dlC()
  {
    AppMethodBeat.i(293200);
    MMActivity localMMActivity = (MMActivity)super.getContext();
    AppMethodBeat.o(293200);
    return localMMActivity;
  }
  
  public final void fus()
  {
    AppMethodBeat.i(34155);
    Toast.makeText(this, R.l.eBM, 0).show();
    AppMethodBeat.o(34155);
  }
  
  public int getLayoutId()
  {
    return R.i.efU;
  }
  
  public void initView()
  {
    AppMethodBeat.i(34139);
    this.HnZ = ((MMImageView)findViewById(R.h.download_type_icon));
    this.Wwq = ((RoundProgressBtn)findViewById(R.h.dTb));
    this.Wwr = new AppAttachDownloadUI.a(this, (Button)findViewById(R.h.dEY), (TextView)findViewById(R.h.dEZ));
    this.wNZ = ((Button)findViewById(R.h.dFk));
    this.Wws = findViewById(R.h.dFa);
    this.mSz = ((TextView)findViewById(R.h.dFg));
    this.Wwt = ((TextView)findViewById(R.h.dFb));
    this.Wwu = ((TextView)findViewById(R.h.dFe));
    this.Wwv = ((TextView)findViewById(R.h.dFf));
    this.WwG = ((LinearLayout)findViewById(R.h.dFh));
    this.WwH = ((LinearLayout)findViewById(R.h.dLw));
    this.WwK = ((LinearLayout)findViewById(R.h.dFj));
    this.WwL = ((ImageView)findViewById(R.h.dFi));
    this.WwL.setImageDrawable(au.o(this, R.k.icons_filled_mini_program, getResources().getColor(R.e.btn_green_text_color)));
    this.WwK.setOnClickListener(new AppAttachDownloadUI.1(this));
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
        AppMethodBeat.i(34115);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/AppAttachDownloadUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        AppAttachDownloadUI.a(AppAttachDownloadUI.this, 8);
        AppAttachDownloadUI.C(AppAttachDownloadUI.this).setVisibility(0);
        AppAttachDownloadUI.D(AppAttachDownloadUI.this).setVisibility(8);
        Log.i("MicroMsg.AppAttachDownloadUI", "summerapp roundProgressBar downloadAppAttachScene[%s]", new Object[] { AppAttachDownloadUI.b(AppAttachDownloadUI.this) });
        if (AppAttachDownloadUI.b(AppAttachDownloadUI.this) != null)
        {
          AppAttachDownloadUI.b(AppAttachDownloadUI.this).a(AppAttachDownloadUI.this);
          com.tencent.mm.kernel.h.aGY().a(AppAttachDownloadUI.b(AppAttachDownloadUI.this));
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/AppAttachDownloadUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(34115);
          return;
          paramAnonymousView = AppAttachDownloadUI.E(AppAttachDownloadUI.this);
          if ((paramAnonymousView != null) && (paramAnonymousView.field_status != 199L))
          {
            Log.i("MicroMsg.AppAttachDownloadUI", "summerapp roundProgressBar onClick but scene is null and set status[%d] paused", new Object[] { Long.valueOf(paramAnonymousView.field_status) });
            paramAnonymousView.field_status = 102L;
            ao.ctZ().a(paramAnonymousView, new String[0]);
          }
        }
      }
    });
    Object localObject = this.Wwr;
    View.OnClickListener local3 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(269562);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/AppAttachDownloadUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        AppAttachDownloadUI.a(AppAttachDownloadUI.this, 0);
        AppAttachDownloadUI.C(AppAttachDownloadUI.this).setVisibility(8);
        if (AppAttachDownloadUI.F(AppAttachDownloadUI.this))
        {
          paramAnonymousView = AppAttachDownloadUI.E(AppAttachDownloadUI.this);
          if (paramAnonymousView != null)
          {
            paramAnonymousView.field_status = 101L;
            paramAnonymousView.field_lastModifyTime = Util.nowSecond();
            ao.ctZ().a(paramAnonymousView, new String[0]);
          }
          if (AppAttachDownloadUI.b(AppAttachDownloadUI.this) != null) {
            bh.aGY().a(AppAttachDownloadUI.b(AppAttachDownloadUI.this));
          }
          AppAttachDownloadUI.a(AppAttachDownloadUI.this, new com.tencent.mm.plugin.record.b.f(AppAttachDownloadUI.G(AppAttachDownloadUI.this), AppAttachDownloadUI.H(AppAttachDownloadUI.this), AppAttachDownloadUI.I(AppAttachDownloadUI.this)));
          bh.aGY().a(AppAttachDownloadUI.b(AppAttachDownloadUI.this), 0);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/AppAttachDownloadUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(269562);
      }
    };
    ((AppAttachDownloadUI.a)localObject).xQQ.setOnClickListener(local3);
    this.wNZ.setOnClickListener(new AppAttachDownloadUI.7(this));
    switch (this.appType)
    {
    case 1: 
    case 3: 
    case 5: 
    default: 
      this.HnZ.setImageResource(R.k.app_attach_file_icon_unknow);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(34118);
          if (AppAttachDownloadUI.b(AppAttachDownloadUI.this) != null) {
            bh.aGY().a(AppAttachDownloadUI.b(AppAttachDownloadUI.this));
          }
          if ((AppAttachDownloadUI.c(AppAttachDownloadUI.this) != null) && (AppAttachDownloadUI.c(AppAttachDownloadUI.this).Q(1, false)))
          {
            AppMethodBeat.o(34118);
            return true;
          }
          AppAttachDownloadUI.this.finish();
          AppMethodBeat.o(34118);
          return true;
        }
      });
      this.fNQ = getIntent().getBooleanExtra("app_show_share", true);
      if (this.fNQ) {
        addIconOptionMenu(0, R.k.actionbar_icon_dark_more, new AppAttachDownloadUI.11(this));
      }
      this.WwA = false;
      if ((!hLD()) || (this.fNz.field_msgId != 0L)) {
        break label659;
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
      AppMethodBeat.o(34139);
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
    label659:
    int i;
    if (this.Rwe > 0L)
    {
      this.Wwv.setVisibility(0);
      this.Wwv.setText(getResources().getString(R.l.eEY, new Object[] { ae.getSizeKB(this.Rwe) }));
      localObject = hLI();
      if ((localObject != null) && (new com.tencent.mm.vfs.q(((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath).ifE())) {
        break label775;
      }
      i = 0;
    }
    for (;;)
    {
      if (i == 0) {
        break label810;
      }
      Log.i("MicroMsg.AppAttachDownloadUI", "summerapp isCanOpenFile");
      this.WwA = true;
      hLJ();
      AppMethodBeat.o(34139);
      return;
      this.Wwv.setVisibility(8);
      break;
      label775:
      if ((((com.tencent.mm.pluginsdk.model.app.c)localObject).evg()) || ((this.fNz.field_isSend == 1) && (((com.tencent.mm.pluginsdk.model.app.c)localObject).field_isUpload))) {
        i = 1;
      } else {
        i = 0;
      }
    }
    label810:
    if (this.WwA)
    {
      AppMethodBeat.o(34139);
      return;
    }
    this.Www = new com.tencent.mm.an.j()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, com.tencent.mm.an.q paramAnonymousq)
      {
        AppMethodBeat.i(277458);
        if (paramAnonymousInt2 == 0) {}
        for (float f = 0.0F;; f = paramAnonymousInt1 * 100.0F / paramAnonymousInt2)
        {
          if ((paramAnonymousInt1 < paramAnonymousInt2) && (AppAttachDownloadUI.B(AppAttachDownloadUI.this).getVisibility() != 0))
          {
            AppAttachDownloadUI.a(AppAttachDownloadUI.this, 0);
            AppAttachDownloadUI.C(AppAttachDownloadUI.this).setVisibility(8);
          }
          AppAttachDownloadUI.B(AppAttachDownloadUI.this).setProgress((int)f);
          AppMethodBeat.o(277458);
          return;
        }
      }
    };
    switch (this.appType)
    {
    default: 
      Log.i("MicroMsg.AppAttachDownloadUI", "summerapp progressCallBack[%s], isDownloadFinished[%b], isDownloadStarted[%b]", new Object[] { this.Www, Boolean.valueOf(this.WwA), Boolean.valueOf(this.WwB) });
      if ((this.appType == 2) || ((!this.WwA) && (!this.WwB))) {
        hLG();
      }
      AppMethodBeat.o(34139);
      return;
    case 0: 
    case 6: 
    case 74: 
      if (this.WwB)
      {
        this.Wwr.setVisibility(0);
        auY(8);
        this.Wws.setVisibility(8);
        this.wNZ.setVisibility(8);
        Log.d("MicroMsg.AppAttachDownloadUI", "hide moreOpenWaysArea");
        this.WwK.setVisibility(4);
        hLN();
        this.Wwu.setVisibility(0);
        if (!this.fileName.equals("")) {
          break label1120;
        }
        this.Wwu.setText(getString(R.l.openapi_app_file));
        localObject = getMimeType();
        if ((localObject != null) && (!((String)localObject).equals(""))) {
          break label1134;
        }
        this.mSz.setText(getString(R.l.eBI));
      }
      while (Util.isImageExt(this.jmx))
      {
        hLN();
        break;
        this.Wwr.setVisibility(8);
        break label979;
        this.Wwu.setText(this.fileName);
        break label1058;
        this.mSz.setText(getString(R.l.eBJ));
      }
    case 7: 
      label979:
      label1120:
      label1134:
      if (this.WwB) {
        this.Wwr.setVisibility(0);
      }
      for (;;)
      {
        label1058:
        auY(8);
        this.Wws.setVisibility(8);
        this.wNZ.setVisibility(8);
        Log.d("MicroMsg.AppAttachDownloadUI", "hide moreOpenWaysArea");
        this.WwK.setVisibility(4);
        this.Wwu.setVisibility(8);
        hLN();
        this.mSz.setText(getString(R.l.eBJ));
        break;
        this.Wwr.setVisibility(8);
      }
    }
    auY(8);
    this.Wws.setVisibility(8);
    if (this.WwB) {
      this.Wwr.setVisibility(0);
    }
    for (;;)
    {
      this.wNZ.setVisibility(8);
      Log.d("MicroMsg.AppAttachDownloadUI", "hide moreOpenWaysArea");
      this.WwK.setVisibility(4);
      this.Wwu.setVisibility(8);
      hLN();
      break;
      this.Wwr.setVisibility(8);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(34148);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.tencent.mm.pluginsdk.ui.tools.a.a(this, paramInt1, paramInt2, paramIntent, this.WwC, R.l.download_no_match_msg, R.l.download_no_match_title, 1);
    AppMethodBeat.o(34148);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(34130);
    super.onCreate(paramBundle);
    init();
    AppMethodBeat.o(34130);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(34144);
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    paramContextMenu.add(0, 0, 0, getString(R.l.app_copy));
    AppMethodBeat.o(34144);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(34136);
    if (this.HCv != null) {
      this.HCv.lPi = null;
    }
    ao.ctZ().remove(this);
    super.onDestroy();
    if (this.wOp != null) {
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.handoff.a.a.class)).d(this.wOp);
    }
    AppMethodBeat.o(34136);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(34140);
    Log.i("MicroMsg.AppAttachDownloadUI", "onKeyDown keyCode %d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt == 4) && (this.WwJ != null) && (this.WwJ.Q(2, false)))
    {
      AppMethodBeat.o(34140);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(34140);
    return bool;
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(34156);
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    if (this.WwJ != null) {
      this.WwJ.aOj();
    }
    init();
    AppMethodBeat.o(34156);
  }
  
  public void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(34149);
    com.tencent.mm.pluginsdk.model.app.c localc = hLI();
    int i;
    StringBuilder localStringBuilder;
    if (localc != null)
    {
      long l1 = localc.field_totalLen;
      long l2 = localc.field_offset;
      this.Rwe = l1;
      this.Wwt.setText(getString(R.l.eBK, new Object[] { ae.getSizeKB(l2), ae.getSizeKB(l1) }));
      if (localc.field_totalLen == 0L) {}
      for (i = 0;; i = (int)(localc.field_offset * 100L / localc.field_totalLen))
      {
        Log.v("MicroMsg.AppAttachDownloadUI", "summerapp attach progress:" + i + " offset:" + l2 + " totallen:" + l1 + " status " + localc.field_status);
        this.Wwq.setProgress(i);
        if ((localc.field_status != 199L) || (i < 100) || (this.WwA)) {
          break label456;
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
        paramString = new Intent();
        paramString.putExtra("filePath", this.filePath);
        paramString.putExtra("fileName", this.fileName);
        paramString.putExtra("fileExt", this.jmx);
        setResult(-1, paramString);
        finish();
        AppMethodBeat.o(34149);
        return;
      }
      if (localc != null)
      {
        localStringBuilder = new StringBuilder().append(getString(R.l.download_success)).append(" : ");
        paramMStorageEventData = localc.field_fileFullPath;
        paramString = paramMStorageEventData;
        if (paramMStorageEventData != null)
        {
          String str = com.tencent.mm.loader.j.b.aSG();
          paramMStorageEventData = u.n(paramMStorageEventData, true);
          int j = paramMStorageEventData.indexOf(str);
          paramString = paramMStorageEventData;
          if (j >= 0)
          {
            paramString = paramMStorageEventData.substring(str.length() + j);
            if (!paramString.startsWith("/")) {
              break label532;
            }
          }
        }
      }
    }
    label532:
    for (paramString = "/sdcard".concat(String.valueOf(paramString));; paramString = "/sdcard/".concat(String.valueOf(paramString)))
    {
      Toast.makeText(this, paramString, this.WwD).show();
      com.tencent.mm.pluginsdk.ui.tools.a.a(this, localc.field_fileFullPath, this.jmx, this.fileName, 1);
      MMHandlerThread.postToMainThreadDelayed(new AppAttachDownloadUI.9(this), 200L);
      label456:
      if ((this.Wwq.getVisibility() != 0) && (i < 100) && (!localc.field_isUpload) && (localc.field_status == 101L))
      {
        Log.i("MicroMsg.AppAttachDownloadUI", "summerapp still downloading updateProgress progress[%d]", new Object[] { Integer.valueOf(i) });
        auY(0);
        this.Wwr.setVisibility(8);
      }
      AppMethodBeat.o(34149);
      return;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(34138);
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
      Log.d("MicroMsg.AppAttachDownloadUI", "AppAttachDownloadUI cancel pause auto download logic");
      AppMethodBeat.o(34138);
      return;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(34137);
    super.onResume();
    bh.aGY().a(221, this);
    bh.aGY().a(728, this);
    qe localqe = new qe();
    localqe.fOR.pause = true;
    localqe.fOR.talker = this.fNz.field_talker;
    EventCenter.instance.asyncPublish(localqe, getMainLooper());
    Log.d("MicroMsg.AppAttachDownloadUI", "AppAttachDownloadUI req pause auto download logic");
    this.wNZ.setEnabled(true);
    if (this.WwJ != null) {
      this.WwJ.bNV();
    }
    AppMethodBeat.o(34137);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(34154);
    Log.i("MicroMsg.AppAttachDownloadUI", "summerapp onSceneEnd type[%d], [%d, %d, %s]", new Object[] { Integer.valueOf(paramq.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramq.getType() != 221) && (paramq.getType() != 728))
    {
      AppMethodBeat.o(34154);
      return;
    }
    if ((paramq.getType() == 728) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = hLI();
      if (paramString == null)
      {
        Log.i("MicroMsg.AppAttachDownloadUI", "summerapp onSceneEnd getAppAttachInfo is null");
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
        AppMethodBeat.o(34154);
        return;
      }
      if (paramString.field_signature == null) {}
      for (paramInt1 = -1;; paramInt1 = paramString.field_signature.length())
      {
        Log.i("MicroMsg.AppAttachDownloadUI", "summerapp onSceneEnd CheckBigFileDownload ok signature len[%d] start NetSceneDownloadAppAttach", new Object[] { Integer.valueOf(paramInt1) });
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
        Log.i("MicroMsg.AppAttachDownloadUI", "summerapp onSceneEnd reset downloadAppAttachScene[%s] by mediaSvrId[%s]", new Object[] { this.HCv, localc.field_mediaSvrId });
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
      AppMethodBeat.o(34154);
      return;
    }
    if ((paramInt2 != 0) && (CrashReportFactory.hasDebuger())) {
      Toast.makeText(this, "errCode[" + paramInt2 + "]", 0).show();
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
      AppMethodBeat.o(34154);
      return;
    }
    auY(8);
    this.Wwr.setVisibility(0);
    this.Wws.setVisibility(8);
    Log.e("MicroMsg.AppAttachDownloadUI", "summerapp onSceneEnd, download fail, type = " + paramq.getType() + " errType = " + paramInt1 + ", errCode = " + paramInt2);
    AppMethodBeat.o(34154);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppAttachDownloadUI
 * JD-Core Version:    0.7.0.1
 */