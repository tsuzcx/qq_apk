package com.tencent.mm.ui.chatting;

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
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.dn;
import com.tencent.mm.autogen.a.rr;
import com.tencent.mm.autogen.a.rr.a;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.platformtools.ExportFileUtil.a;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.appbrand.openmaterial.g.a;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection;
import com.tencent.mm.plugin.appbrand.openmaterial.model.MaterialModel;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.plugin.msgquote.model.MsgQuoteItem;
import com.tencent.mm.plugin.record.model.e;
import com.tencent.mm.plugin.record.model.g.b;
import com.tencent.mm.plugin.secdata.ui.MMSecDataActivity;
import com.tencent.mm.pluginsdk.model.app.as;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.pluginsdk.model.l;
import com.tencent.mm.pluginsdk.model.x;
import com.tencent.mm.protocal.protobuf.aet;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.k.e;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.tools.ShowImageUI;
import com.tencent.mm.ui.widget.progress.RoundProgressBtn;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.lang.ref.WeakReference;

public class AppAttachDownloadUI
  extends MMSecDataActivity
  implements com.tencent.mm.am.h, g.b, MStorage.IOnStorageChange
{
  private Button AkB;
  private HandOffFile AkR;
  private View.OnTouchListener AkU;
  private View.OnLongClickListener AkV;
  private MMImageView NlM;
  private com.tencent.mm.plugin.record.model.g NzY;
  private com.tencent.mm.plugin.appbrand.openmaterial.i WVA;
  private AppBrandOpenMaterialCollection WVz;
  private long Ysz;
  private String Ytx;
  private com.tencent.mm.plugin.appbrand.openmaterial.g Yty;
  private RoundProgressBtn aedH;
  private a aedI;
  private View aedJ;
  private TextView aedK;
  private TextView aedL;
  private TextView aedM;
  private com.tencent.mm.am.i aedN;
  private boolean aedO;
  private k.b aedP;
  private String aedQ;
  private boolean aedR;
  private boolean aedS;
  private boolean aedT;
  private int aedU;
  private boolean aedV;
  private int aedW;
  private LinearLayout aedX;
  private LinearLayout aedY;
  private boolean aedZ;
  private com.tencent.mm.ui.chatting.multitask.b aeea;
  private LinearLayout aeeb;
  private ImageView aeec;
  private String aesKey;
  private int appType;
  private String authKey;
  private String cdnURL;
  private String fileName;
  private String filePath;
  private String hQQ;
  private boolean hTH;
  private cc hTm;
  private String hWn;
  private String lPJ;
  private String mediaId;
  private long msgId;
  private TextView pPe;
  private int scene;
  private com.tencent.mm.ui.widget.b.a vEV;
  private com.tencent.mm.ui.widget.a.f vlk;
  private String vyS;
  private int wQW;
  private int x_down;
  private u.i yBn;
  private int y_down;
  
  public AppAttachDownloadUI()
  {
    AppMethodBeat.i(34129);
    this.wQW = 0;
    this.aedR = false;
    this.aedS = false;
    this.aedT = true;
    this.aedU = 5000;
    this.aedV = false;
    this.aedZ = false;
    this.Ytx = null;
    this.WVz = null;
    this.Yty = null;
    this.WVA = null;
    this.vlk = null;
    this.vEV = null;
    this.yBn = new u.i()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(253985);
        if (AppAttachDownloadUI.K(AppAttachDownloadUI.this).equals("")) {}
        for (paramAnonymousMenuItem = AppAttachDownloadUI.this.getString(R.l.openapi_app_file);; paramAnonymousMenuItem = AppAttachDownloadUI.K(AppAttachDownloadUI.this))
        {
          ClipboardHelper.setText(MMApplicationContext.getContext(), null, paramAnonymousMenuItem);
          k.cZ(AppAttachDownloadUI.this, AppAttachDownloadUI.this.getString(R.l.app_copy_ok));
          AppMethodBeat.o(253985);
          return;
        }
      }
    };
    this.AkU = new AppAttachDownloadUI.5(this);
    this.AkV = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(253966);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/AppAttachDownloadUI$14", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
        Log.d("MicroMsg.AppAttachDownloadUI", "onLongClick");
        if (AppAttachDownloadUI.L(AppAttachDownloadUI.this) == null) {
          AppAttachDownloadUI.a(AppAttachDownloadUI.this, new com.tencent.mm.ui.widget.b.a(AppAttachDownloadUI.this.dSs()));
        }
        AppAttachDownloadUI.L(AppAttachDownloadUI.this).a(paramAnonymousView, AppAttachDownloadUI.this, AppAttachDownloadUI.M(AppAttachDownloadUI.this), AppAttachDownloadUI.N(AppAttachDownloadUI.this), AppAttachDownloadUI.O(AppAttachDownloadUI.this));
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/chatting/AppAttachDownloadUI$14", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(253966);
        return true;
      }
    };
    AppMethodBeat.o(34129);
  }
  
  private void aBA(int paramInt)
  {
    AppMethodBeat.i(34158);
    if (paramInt != this.aedH.getVisibility())
    {
      Log.i("MicroMsg.AppAttachDownloadUI", "setRoundProgressBar %s %s", new Object[] { Integer.valueOf(paramInt), ab.bTQ() });
      this.aedH.setVisibility(paramInt);
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
    u localu = new u(paramc.field_fileFullPath);
    if ((localu.jKS()) && (localu.length() == paramc.field_totalLen))
    {
      AppMethodBeat.o(34157);
      return true;
    }
    AppMethodBeat.o(34157);
    return false;
  }
  
  private boolean dLc()
  {
    AppMethodBeat.i(34134);
    this.scene = getIntent().getIntExtra("scene", 0);
    this.msgId = getIntent().getLongExtra("app_msg_id", -1L);
    this.aedV = getIntent().getBooleanExtra("choose_way", false);
    this.aedW = getIntent().getIntExtra("msg_type", 0);
    if (this.msgId == -1L)
    {
      AppMethodBeat.o(34134);
      return false;
    }
    bh.bCz();
    this.hTm = com.tencent.mm.model.c.bzD().sl(this.msgId);
    Object localObject1;
    if ((this.hTm == null) || (this.hTm.field_msgId == 0L) || (this.hTm.field_content == null))
    {
      if (!joe()) {
        break label393;
      }
      localObject1 = (MsgQuoteItem)getIntent().getParcelableExtra("key_quoted_msg");
      if (localObject1 == null)
      {
        AppMethodBeat.o(34134);
        return false;
      }
      this.hTm = new cc();
      this.hTm.setType(((MsgQuoteItem)localObject1).type);
      this.hTm.gX(((MsgQuoteItem)localObject1).LgU);
      this.hTm.BS(((MsgQuoteItem)localObject1).LgV);
      this.hTm.AU(((MsgQuoteItem)localObject1).LgY);
      this.hTm.setContent(((MsgQuoteItem)localObject1).content);
      if (Util.isEqual(((MsgQuoteItem)localObject1).LgW, z.bAM())) {
        this.hTm.pI(1);
      }
    }
    this.aedO = au.bwE(this.hTm.field_talker);
    this.hWn = this.hTm.field_content;
    Object localObject2;
    if ((this.aedO) && (this.hTm.field_isSend == 0))
    {
      localObject2 = this.hTm.field_content;
      localObject1 = localObject2;
      if (this.aedO)
      {
        localObject1 = localObject2;
        if (localObject2 != null) {
          localObject1 = br.JK((String)localObject2);
        }
      }
      this.hWn = ((String)localObject1);
    }
    this.aedP = k.b.Hf(this.hWn);
    if (this.aedP == null)
    {
      Log.e("MicroMsg.AppAttachDownloadUI", "summerapp parse msgContent error, %s", new Object[] { this.hWn });
      AppMethodBeat.o(34134);
      return false;
      label393:
      AppMethodBeat.o(34134);
      return false;
    }
    if ((ab.isNullOrNil(this.aedP.hzM)) && (!ab.isNullOrNil(this.aedP.nRq)))
    {
      Log.e("MicroMsg.AppAttachDownloadUI", "summerapp msgContent format error, %s", new Object[] { this.hWn });
      this.aedP.hzM = this.aedP.nRq.hashCode();
    }
    this.appType = this.aedP.type;
    this.mediaId = this.aedP.hzM;
    this.fileName = ab.nullAsNil(this.aedP.title);
    this.lPJ = ab.nullAsNil(this.aedP.nRe).toLowerCase();
    this.Ysz = this.aedP.nRd;
    this.vyS = ab.nullAsNil(this.aedP.filemd5);
    this.hQQ = ab.nullAsNil(this.aedP.hQQ);
    this.cdnURL = ab.nullAsNil(this.aedP.nRq);
    this.aedQ = ab.nullAsNil(this.aedP.tpurl);
    this.aesKey = ab.nullAsNil(this.aedP.aesKey);
    this.authKey = ab.nullAsNil(this.aedP.nRn);
    if (ab.isNullOrNil(this.lPJ)) {
      this.lPJ = y.alV(this.fileName);
    }
    Log.i("MicroMsg.AppAttachDownloadUI", "summerapp initParams msgId[%d], sender[%d], msgContent[%s], appType[%d], mediaId[%s], fileName[%s]", new Object[] { Long.valueOf(this.msgId), Integer.valueOf(this.hTm.field_isSend), this.hWn, Integer.valueOf(this.appType), this.mediaId, this.fileName });
    com.tencent.mm.pluginsdk.model.app.c localc = joj();
    if (localc == null)
    {
      Log.i("MicroMsg.AppAttachDownloadUI", "summerapp initParams attInfo is null");
      this.aedS = false;
    }
    for (;;)
    {
      if (this.aedP.type == 6) {
        ((com.tencent.mm.plugin.comm.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.comm.a.c.class)).ae(String.valueOf(this.hTm.field_msgId), this.hTm.field_msgSvrId);
      }
      hf(4, 0);
      String str1 = ab.nullAsNil(z.bAM());
      localObject2 = ab.nullAsNil(this.hTm.field_talker);
      localObject1 = localObject2;
      if (au.bwE((String)localObject2)) {
        localObject1 = ab.nullAsNil(this.aedP.hQQ);
      }
      label845:
      label856:
      boolean bool;
      label916:
      int i;
      if (this.hTm.field_isSend == 1)
      {
        localObject2 = str1;
        if (this.hTm.field_isSend != 1) {
          break label1243;
        }
        String str2 = ab.nullAsNil(this.filePath);
        String str3 = this.lPJ;
        String str4 = this.fileName;
        String str5 = this.vyS;
        long l = this.Ysz;
        String str6 = Long.toString(this.hTm.field_msgSvrId);
        if (ab.isNullOrNil(this.cdnURL)) {
          break label1250;
        }
        str1 = this.cdnURL;
        this.AkR = new HandOffFile(str2, str3, str4, str5, l, 1, str6, "", str1, this.aesKey, this.authKey, 1, "", 0, "", 0L, 1, (String)localObject2, (String)localObject1);
        bool = b(joj());
        localObject1 = this.AkR;
        if (!bool) {
          break label1259;
        }
        i = 1;
        ((HandOffFile)localObject1).setFileStatus(i);
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.handoff.a.a.class)).g(this.AkR);
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.handoff.a.a.class)).c(this.AkR);
        localObject1 = new aet();
        localObject2 = getIntent().getByteArrayExtra("key_multi_task_common_info");
        if (localObject2 == null) {}
      }
      try
      {
        ((aet)localObject1).parseFrom((byte[])localObject2);
        if (b(localc)) {
          if (this.scene == 3)
          {
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("filePath", this.filePath);
            ((Intent)localObject1).putExtra("fileName", this.fileName);
            ((Intent)localObject1).putExtra("fileExt", this.lPJ);
            setResult(-1, (Intent)localObject1);
            finish();
            AppMethodBeat.o(34134);
            return true;
            this.filePath = localc.field_fileFullPath;
            new u(localc.field_fileFullPath);
            if (localc.field_offset > 0L) {}
            for (this.aedS = true;; this.aedS = false)
            {
              Log.i("MicroMsg.AppAttachDownloadUI", "summerapp initParams attInfo field_fileFullPath[%s], field_offset[%d], isDownloadStarted[%b]", new Object[] { localc.field_fileFullPath, Long.valueOf(localc.field_offset), Boolean.valueOf(this.aedS) });
              break;
            }
            localObject2 = localObject1;
            break label845;
            label1243:
            localObject1 = str1;
            break label856;
            label1250:
            str1 = this.aedQ;
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
          this.wQW = 7;
          if (this.aedV)
          {
            bool = com.tencent.mm.pluginsdk.ui.tools.a.c(this, localc.field_fileFullPath, this.lPJ, this.wQW);
            AppMethodBeat.o(34134);
            return bool;
          }
          bool = com.tencent.mm.pluginsdk.ui.tools.a.a(localc.field_fileFullPath, this.lPJ, this.wQW, (aet)localObject1);
          AppMethodBeat.o(34134);
          return bool;
        }
        if (this.wQW != 9) {
          this.wQW = 1;
        }
        if (this.aedV)
        {
          bool = com.tencent.mm.pluginsdk.ui.tools.a.c(this, localc.field_fileFullPath, this.lPJ, this.wQW);
          AppMethodBeat.o(34134);
          return bool;
        }
        if (!com.tencent.mm.pluginsdk.ui.tools.a.pq(localc.field_fileFullPath, this.lPJ))
        {
          bool = com.tencent.mm.pluginsdk.ui.tools.a.a(localc.field_fileFullPath, this.lPJ, this.wQW, (aet)localObject1);
          AppMethodBeat.o(34134);
          return bool;
        }
        AppMethodBeat.o(34134);
      }
    }
    return true;
  }
  
  private void fkW()
  {
    AppMethodBeat.i(34153);
    Log.i("MicroMsg.AppAttachDownloadUI", "[ImageGalleryUI] showImage");
    Object localObject = new Intent(this, ImageGalleryUI.class);
    ((Intent)localObject).putExtra("img_gallery_msg_id", this.hTm.field_msgId);
    ((Intent)localObject).putExtra("img_gallery_talker", this.hTm.field_talker);
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/chatting/AppAttachDownloadUI", "showImage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/chatting/AppAttachDownloadUI", "showImage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    overridePendingTransition(0, 0);
    AppMethodBeat.o(34153);
  }
  
  private String getMimeType()
  {
    AppMethodBeat.i(34146);
    k.b localb = k.b.Hf(this.hWn);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localb.nRe != null)
    {
      localObject1 = localObject2;
      if (localb.nRe.length() > 0) {
        localObject1 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(localb.nRe);
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
      localObject2 = "*/" + localb.nRe;
    }
    AppMethodBeat.o(34146);
    return localObject2;
  }
  
  private void hf(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(34161);
    String str;
    if (6 == this.appType)
    {
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1203L, paramInt2, 1L, false);
      str = this.aedP.nRq;
      if (this.aedP.nRh != 1) {
        break label226;
      }
    }
    label226:
    for (paramInt2 = 7;; paramInt2 = 5)
    {
      str = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { str, Integer.valueOf(paramInt2), Integer.valueOf(this.aedP.nRd), Integer.valueOf(paramInt1), Long.valueOf((cn.bDv() - this.hTm.getCreateTime()) / 1000L), this.lPJ, this.hTm.field_talker, Integer.valueOf(1), "", Long.valueOf(this.hTm.field_msgSvrId), Long.valueOf(this.hTm.getCreateTime()), Long.valueOf(cn.bDu()), Integer.valueOf(1) });
      Log.i("MicroMsg.AppAttachDownloadUI", "reportKVStat 14665 %s", new Object[] { str });
      com.tencent.mm.plugin.report.service.h.OAn.kvStat(14665, str);
      AppMethodBeat.o(34161);
      return;
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(34131);
    setMMTitle("");
    setActionbarColor(getResources().getColor(R.e.white));
    hideActionbarLine();
    if (!dLc())
    {
      finish();
      AppMethodBeat.o(34131);
      return;
    }
    u localu = new u(com.tencent.mm.loader.i.b.bmC());
    if (!localu.jKS()) {
      localu.jKY();
    }
    as.cWJ().add(this);
    initView();
    jod();
    AppMethodBeat.o(34131);
  }
  
  private void jod()
  {
    AppMethodBeat.i(253827);
    this.aeea = new com.tencent.mm.ui.chatting.multitask.b(new com.tencent.mm.plugin.multitask.a.b((MMActivity)super.getContext()));
    this.aeea.d(this.filePath, this.lPJ, this.wQW, true);
    this.aeea.qa(this.lPJ, this.fileName);
    this.AkR.saveToMultiTaskInfo(this.aeea.LCE);
    AppMethodBeat.o(253827);
  }
  
  private boolean joe()
  {
    return this.aedW == 1;
  }
  
  private void jof()
  {
    AppMethodBeat.i(253846);
    Log.d("MicroMsg.AppAttachDownloadUI", "loadOpenMaterials");
    if (ab.isNullOrNil(this.filePath))
    {
      Log.w("MicroMsg.AppAttachDownloadUI", "loadOpenMaterials, filePath is empty");
      AppMethodBeat.o(253846);
      return;
    }
    if ((this.filePath.equals(this.Ytx)) && (this.WVz != null))
    {
      Log.i("MicroMsg.AppAttachDownloadUI", "loadOpenMaterials, already load");
      AppMethodBeat.o(253846);
      return;
    }
    MaterialModel localMaterialModel = MaterialModel.fh(this.filePath, this.lPJ);
    if (localMaterialModel == null)
    {
      Log.w("MicroMsg.AppAttachDownloadUI", "loadOpenMaterials, materialModel is null");
      AppMethodBeat.o(253846);
      return;
    }
    com.tencent.mm.plugin.appbrand.service.j localj = (com.tencent.mm.plugin.appbrand.service.j)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.j.class);
    if (localj == null)
    {
      Log.w("MicroMsg.AppAttachDownloadUI", "loadOpenMaterials, openMaterialService is null");
      AppMethodBeat.o(253846);
      return;
    }
    if (!localj.c(com.tencent.mm.plugin.appbrand.openmaterial.model.b.trZ))
    {
      Log.i("MicroMsg.AppAttachDownloadUI", "loadOpenMaterials, openMaterialService is not enabled");
      AppMethodBeat.o(253846);
      return;
    }
    if (!localj.aen(localMaterialModel.mimeType))
    {
      Log.i("MicroMsg.AppAttachDownloadUI", "loadOpenMaterials, openMaterialService is not support " + localMaterialModel.mimeType);
      AppMethodBeat.o(253846);
      return;
    }
    localj.a(localMaterialModel, new b(this, localMaterialModel, localj));
    AppMethodBeat.o(253846);
  }
  
  private void jog()
  {
    AppMethodBeat.i(34141);
    dn localdn = new dn();
    l.d(localdn, this.hTm);
    localdn.hDr.activity = this;
    localdn.hDr.hDy = 39;
    localdn.publish();
    AppMethodBeat.o(34141);
  }
  
  private void joh()
  {
    AppMethodBeat.i(34143);
    aBA(0);
    this.aedI.setVisibility(8);
    if (joi())
    {
      Log.i("MicroMsg.AppAttachDownloadUI", "startToDownloadFile");
      if (this.NzY != null) {
        bh.aZW().a(this.NzY);
      }
      this.NzY = new com.tencent.mm.plugin.record.model.g(this.msgId, this.mediaId, this.aedN);
      bh.aZW().a(this.NzY, 0);
      ac.am(this.hTm);
      hf(7, 1);
    }
    AppMethodBeat.o(34143);
  }
  
  private boolean joi()
  {
    int i = -1;
    boolean bool2 = true;
    AppMethodBeat.i(34145);
    Object localObject1 = joj();
    Object localObject2;
    boolean bool1;
    long l1;
    long l2;
    long l3;
    String str1;
    long l4;
    if (localObject1 == null)
    {
      n.ab(this.msgId, this.hWn);
      localObject2 = joj();
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
        if (this.aedP.nRh == 0)
        {
          localObject1 = localObject2;
          bool1 = bool2;
          if (this.aedP.nRd <= 26214400) {}
        }
        else
        {
          if (ab.isNullOrNil(((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_signature)) {
            break label334;
          }
          bool1 = true;
          label219:
          localObject1 = localObject2;
        }
      }
      if ((this.aedP == null) || ((this.aedP.nRh == 0) && (this.aedP.nRd <= 26214400))) {
        break label569;
      }
      bool1 = false;
    }
    label569:
    for (;;)
    {
      if (!bool1) {
        bh.aZW().a(new e((com.tencent.mm.pluginsdk.model.app.c)localObject1, this.aesKey, this.vyS, this.fileName, this.lPJ, this.hQQ), 0);
      }
      if (localObject1 != null)
      {
        this.filePath = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath;
        jod();
      }
      AppMethodBeat.o(34145);
      return bool1;
      label322:
      i = ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_signature.length();
      break;
      label334:
      bool1 = false;
      break label219;
      localObject2 = new u(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath);
      if ((((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_status == 199L) && (!((u)localObject2).jKS()))
      {
        Log.i("MicroMsg.AppAttachDownloadUI", "summerapp tryInitAttachInfo info exist but file not!");
        n.ab(this.msgId, this.hWn);
      }
      l1 = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).systemRowid;
      l2 = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_totalLen;
      str1 = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath;
      l3 = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_type;
      String str2 = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_mediaId;
      l4 = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_msgInfoId;
      bool1 = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_isUpload;
      boolean bool3 = ((u)localObject2).jKS();
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
  
  private com.tencent.mm.pluginsdk.model.app.c joj()
  {
    AppMethodBeat.i(34147);
    if (this.appType == 74)
    {
      AppMethodBeat.o(34147);
      return null;
    }
    com.tencent.mm.pluginsdk.model.app.c localc1 = as.cWJ().yi(this.msgId);
    if (localc1 != null)
    {
      Log.i("MicroMsg.AppAttachDownloadUI", "summerapp getAppAttachInfo by msgId [%d] stack[%s]", new Object[] { Long.valueOf(this.msgId), ab.bTQ() });
      AppMethodBeat.o(34147);
      return localc1;
    }
    localc1 = n.bpU(this.mediaId);
    if (localc1 == null)
    {
      Log.i("MicroMsg.AppAttachDownloadUI", "summerapp getAppAttachInfo by msgId and mediaId is null stack[%s]", new Object[] { ab.bTQ() });
      AppMethodBeat.o(34147);
      return localc1;
    }
    if ((localc1.field_msgInfoId == this.msgId) || (y.ZC(localc1.field_fileFullPath)))
    {
      AppMethodBeat.o(34147);
      return localc1;
    }
    n.ab(this.msgId, this.hWn);
    com.tencent.mm.pluginsdk.model.app.c localc2 = as.cWJ().yi(this.msgId);
    if (localc2 == null)
    {
      Log.w("MicroMsg.AppAttachDownloadUI", "summerapp getAppAttachInfo create new info from local but failed stack[%s]", new Object[] { ab.bTQ() });
      AppMethodBeat.o(34147);
      return localc1;
    }
    ThreadPool.post(new AppAttachDownloadUI.8(this, localc1, localc2), "copyAttachFromLocal");
    AppMethodBeat.o(34147);
    return localc1;
  }
  
  private void jok()
  {
    AppMethodBeat.i(34150);
    switch (this.appType)
    {
    case 1: 
    case 3: 
    case 4: 
    case 5: 
    default: 
      this.AkB.setVisibility(0);
      aBA(8);
      this.aedJ.setVisibility(8);
    }
    for (;;)
    {
      Object localObject;
      if (this.AkR.getFileStatus() != 1)
      {
        this.AkR.setFileStatus(1);
        localObject = joj();
        if (localObject != null) {
          this.AkR.setFullPath(ab.nullAsNil(((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath));
        }
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.handoff.a.a.class)).g(this.AkR);
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.handoff.a.a.class)).e(this.AkR);
      }
      jof();
      AppMethodBeat.o(34150);
      return;
      if (jol()) {
        if (Util.isImageExt(this.lPJ))
        {
          jom();
        }
        else
        {
          localObject = getMimeType();
          Log.i("MicroMsg.AppAttachDownloadUI", "onDownLoadImpl");
          joo();
          aBA(8);
          this.aedJ.setVisibility(8);
          this.aedI.setVisibility(8);
          this.aedL.setVisibility(0);
          if (this.fileName.equals("")) {
            this.aedL.setText(getString(R.l.openapi_app_file));
          }
          for (;;)
          {
            if ((localObject != null) && (!((String)localObject).equals(""))) {
              break label322;
            }
            this.AkB.setVisibility(8);
            this.pPe.setText(getString(R.l.gEQ));
            break;
            this.aedL.setText(this.fileName);
          }
          label322:
          this.AkB.setVisibility(0);
          this.pPe.setText(getString(R.l.gER));
          continue;
          if (jol())
          {
            fkW();
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
  
  private boolean jol()
  {
    AppMethodBeat.i(34151);
    Object localObject = joj();
    if (localObject == null)
    {
      AppMethodBeat.o(34151);
      return true;
    }
    if (y.ZC(((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath))
    {
      aBA(8);
      this.aedJ.setVisibility(8);
      this.aedI.setVisibility(8);
      AppMethodBeat.o(34151);
      return true;
    }
    aBA(8);
    jon();
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
  
  private void jom()
  {
    AppMethodBeat.i(34152);
    Object localObject = joj();
    if (localObject == null)
    {
      Log.e("MicroMsg.AppAttachDownloadUI", "info == null");
      AppMethodBeat.o(34152);
      return;
    }
    Intent localIntent = new Intent(this, ShowImageUI.class);
    localIntent.putExtra("key_message_id", this.hTm.field_msgId);
    localIntent.putExtra("key_image_path", ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath);
    localIntent.putExtra("key_favorite", true);
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/chatting/AppAttachDownloadUI", "showFileImage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/chatting/AppAttachDownloadUI", "showFileImage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    AppMethodBeat.o(34152);
  }
  
  private void jon()
  {
    AppMethodBeat.i(34159);
    this.aedX.setVisibility(0);
    this.aedY.setVisibility(8);
    joo();
    this.aedI.jop();
    AppMethodBeat.o(34159);
  }
  
  private void joo()
  {
    AppMethodBeat.i(34160);
    this.pPe.setVisibility(8);
    AppMethodBeat.o(34160);
  }
  
  public final MMActivity dSs()
  {
    AppMethodBeat.i(369647);
    MMActivity localMMActivity = (MMActivity)super.getContext();
    AppMethodBeat.o(369647);
    return localMMActivity;
  }
  
  public final void gGh()
  {
    AppMethodBeat.i(34155);
    runOnUiThread(new AppAttachDownloadUI..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(34155);
  }
  
  public int getLayoutId()
  {
    return R.i.giT;
  }
  
  public void initView()
  {
    AppMethodBeat.i(34139);
    this.NlM = ((MMImageView)findViewById(R.h.download_type_icon));
    this.aedH = ((RoundProgressBtn)findViewById(R.h.fVh));
    this.aedI = new a((Button)findViewById(R.h.fGc), (TextView)findViewById(R.h.fGd));
    this.AkB = ((Button)findViewById(R.h.fGo));
    this.aedJ = findViewById(R.h.fGe);
    this.pPe = ((TextView)findViewById(R.h.fGk));
    this.aedK = ((TextView)findViewById(R.h.fGf));
    this.aedL = ((TextView)findViewById(R.h.fGi));
    this.aedM = ((TextView)findViewById(R.h.fGj));
    this.aedX = ((LinearLayout)findViewById(R.h.fGl));
    this.aedY = ((LinearLayout)findViewById(R.h.fNe));
    this.aeeb = ((LinearLayout)findViewById(R.h.fGn));
    this.aeec = ((ImageView)findViewById(R.h.fGm));
    this.aeec.setImageDrawable(bb.m(this, R.k.icons_filled_mini_program, getResources().getColor(R.e.btn_green_text_color)));
    this.aeeb.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(253982);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/AppAttachDownloadUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        Log.d("MicroMsg.AppAttachDownloadUI", "MoreOpenWaysArea#onClick");
        if (AppAttachDownloadUI.a(AppAttachDownloadUI.this) != null) {
          AppAttachDownloadUI.a(AppAttachDownloadUI.this).cDb();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/AppAttachDownloadUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(253982);
      }
    });
    this.aedL.setOnTouchListener(this.AkU);
    this.aedL.setOnLongClickListener(this.AkV);
    if (this.aedL != null)
    {
      localObject = this.aedL.getPaint();
      if (localObject != null) {
        ((Paint)localObject).setFakeBoldText(true);
      }
    }
    this.aedH.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(34115);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/AppAttachDownloadUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        AppAttachDownloadUI.a(AppAttachDownloadUI.this, 8);
        AppAttachDownloadUI.D(AppAttachDownloadUI.this).setVisibility(0);
        AppAttachDownloadUI.E(AppAttachDownloadUI.this).setVisibility(8);
        Log.i("MicroMsg.AppAttachDownloadUI", "summerapp roundProgressBar downloadAppAttachScene[%s]", new Object[] { AppAttachDownloadUI.b(AppAttachDownloadUI.this) });
        if (AppAttachDownloadUI.b(AppAttachDownloadUI.this) != null)
        {
          AppAttachDownloadUI.b(AppAttachDownloadUI.this).a(AppAttachDownloadUI.this);
          com.tencent.mm.kernel.h.aZW().a(AppAttachDownloadUI.b(AppAttachDownloadUI.this));
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/AppAttachDownloadUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(34115);
          return;
          paramAnonymousView = AppAttachDownloadUI.F(AppAttachDownloadUI.this);
          if ((paramAnonymousView != null) && (paramAnonymousView.field_status != 199L))
          {
            Log.i("MicroMsg.AppAttachDownloadUI", "summerapp roundProgressBar onClick but scene is null and set status[%d] paused", new Object[] { Long.valueOf(paramAnonymousView.field_status) });
            paramAnonymousView.field_status = 102L;
            as.cWJ().a(paramAnonymousView, new String[0]);
          }
        }
      }
    });
    Object localObject = this.aedI;
    View.OnClickListener local3 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(253989);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/AppAttachDownloadUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        AppAttachDownloadUI.a(AppAttachDownloadUI.this, 0);
        AppAttachDownloadUI.D(AppAttachDownloadUI.this).setVisibility(8);
        if (AppAttachDownloadUI.G(AppAttachDownloadUI.this))
        {
          paramAnonymousView = AppAttachDownloadUI.F(AppAttachDownloadUI.this);
          if (paramAnonymousView != null)
          {
            paramAnonymousView.field_status = 101L;
            paramAnonymousView.field_lastModifyTime = Util.nowSecond();
            as.cWJ().a(paramAnonymousView, new String[0]);
          }
          if (AppAttachDownloadUI.b(AppAttachDownloadUI.this) != null) {
            bh.aZW().a(AppAttachDownloadUI.b(AppAttachDownloadUI.this));
          }
          AppAttachDownloadUI.a(AppAttachDownloadUI.this, new com.tencent.mm.plugin.record.model.g(AppAttachDownloadUI.H(AppAttachDownloadUI.this), AppAttachDownloadUI.I(AppAttachDownloadUI.this), AppAttachDownloadUI.J(AppAttachDownloadUI.this)));
          bh.aZW().a(AppAttachDownloadUI.b(AppAttachDownloadUI.this), 0);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/AppAttachDownloadUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(253989);
      }
    };
    ((a)localObject).Bqo.setOnClickListener(local3);
    this.AkB.setOnClickListener(new AppAttachDownloadUI.7(this));
    switch (this.appType)
    {
    case 1: 
    case 3: 
    case 5: 
    default: 
      this.NlM.setImageResource(R.k.app_attach_file_icon_unknow);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(34118);
          if (AppAttachDownloadUI.b(AppAttachDownloadUI.this) != null) {
            bh.aZW().a(AppAttachDownloadUI.b(AppAttachDownloadUI.this));
          }
          if ((AppAttachDownloadUI.c(AppAttachDownloadUI.this) != null) && (AppAttachDownloadUI.c(AppAttachDownloadUI.this).af(1, false)))
          {
            AppMethodBeat.o(34118);
            return true;
          }
          AppAttachDownloadUI.this.finish();
          AppMethodBeat.o(34118);
          return true;
        }
      });
      this.hTH = getIntent().getBooleanExtra("app_show_share", true);
      if (this.hTH) {
        addIconOptionMenu(0, R.k.actionbar_icon_dark_more, new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(253865);
            AppAttachDownloadUI.a(AppAttachDownloadUI.this, AppAttachDownloadUI.d(AppAttachDownloadUI.this));
            AppMethodBeat.o(253865);
            return false;
          }
        });
      }
      this.aedR = false;
      if ((!joe()) || (this.hTm.field_msgId != 0L)) {
        break label659;
      }
      this.aedM.setVisibility(8);
      this.aedL.setVisibility(0);
      if (this.fileName.equals("")) {
        this.aedL.setText(getString(R.l.openapi_app_file));
      }
      break;
    }
    for (;;)
    {
      jon();
      if (this.scene == 3)
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("resLoadFailed", true);
        setResult(-1, (Intent)localObject);
        finish();
      }
      AppMethodBeat.o(34139);
      return;
      this.NlM.setImageResource(R.g.app_attach_file_icon_pic);
      break;
      this.NlM.setImageResource(R.k.app_attach_file_icon_video);
      break;
      this.NlM.setImageResource(x.bpA(this.lPJ));
      break;
      if (Util.isImageExt(this.lPJ))
      {
        this.NlM.setImageResource(R.g.app_attach_file_icon_pic);
        break;
      }
      this.NlM.setImageResource(R.k.app_attach_file_icon_unknow);
      break;
      this.aedL.setText(this.fileName);
    }
    label659:
    int i;
    if (this.Ysz > 0L)
    {
      this.aedM.setVisibility(0);
      this.aedM.setText(getResources().getString(R.l.gHR, new Object[] { ab.getSizeKB(this.Ysz) }));
      localObject = joj();
      if ((localObject != null) && (new u(((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath).jKS())) {
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
      this.aedR = true;
      jok();
      AppMethodBeat.o(34139);
      return;
      this.aedM.setVisibility(8);
      break;
      label775:
      if ((((com.tencent.mm.pluginsdk.model.app.c)localObject).efT()) || ((this.hTm.field_isSend == 1) && (((com.tencent.mm.pluginsdk.model.app.c)localObject).field_isUpload))) {
        i = 1;
      } else {
        i = 0;
      }
    }
    label810:
    if (this.aedR)
    {
      AppMethodBeat.o(34139);
      return;
    }
    this.aedN = new com.tencent.mm.am.i()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, p paramAnonymousp)
      {
        AppMethodBeat.i(253833);
        if (paramAnonymousInt2 == 0) {}
        for (float f = 0.0F;; f = paramAnonymousInt1 * 100.0F / paramAnonymousInt2)
        {
          if ((paramAnonymousInt1 < paramAnonymousInt2) && (AppAttachDownloadUI.C(AppAttachDownloadUI.this).getVisibility() != 0))
          {
            AppAttachDownloadUI.a(AppAttachDownloadUI.this, 0);
            AppAttachDownloadUI.D(AppAttachDownloadUI.this).setVisibility(8);
          }
          AppAttachDownloadUI.C(AppAttachDownloadUI.this).setProgress((int)f);
          AppMethodBeat.o(253833);
          return;
        }
      }
    };
    switch (this.appType)
    {
    default: 
      Log.i("MicroMsg.AppAttachDownloadUI", "summerapp progressCallBack[%s], isDownloadFinished[%b], isDownloadStarted[%b]", new Object[] { this.aedN, Boolean.valueOf(this.aedR), Boolean.valueOf(this.aedS) });
      if ((this.appType == 2) || ((!this.aedR) && (!this.aedS))) {
        joh();
      }
      AppMethodBeat.o(34139);
      return;
    case 0: 
    case 6: 
    case 74: 
      if (this.aedS)
      {
        this.aedI.setVisibility(0);
        aBA(8);
        this.aedJ.setVisibility(8);
        this.AkB.setVisibility(8);
        Log.d("MicroMsg.AppAttachDownloadUI", "hide moreOpenWaysArea");
        this.aeeb.setVisibility(4);
        joo();
        this.aedL.setVisibility(0);
        if (!this.fileName.equals("")) {
          break label1120;
        }
        this.aedL.setText(getString(R.l.openapi_app_file));
        localObject = getMimeType();
        if ((localObject != null) && (!((String)localObject).equals(""))) {
          break label1134;
        }
        this.pPe.setText(getString(R.l.gEQ));
      }
      while (Util.isImageExt(this.lPJ))
      {
        joo();
        break;
        this.aedI.setVisibility(8);
        break label979;
        this.aedL.setText(this.fileName);
        break label1058;
        this.pPe.setText(getString(R.l.gER));
      }
    case 7: 
      label979:
      label1120:
      label1134:
      if (this.aedS) {
        this.aedI.setVisibility(0);
      }
      for (;;)
      {
        label1058:
        aBA(8);
        this.aedJ.setVisibility(8);
        this.AkB.setVisibility(8);
        Log.d("MicroMsg.AppAttachDownloadUI", "hide moreOpenWaysArea");
        this.aeeb.setVisibility(4);
        this.aedL.setVisibility(8);
        joo();
        this.pPe.setText(getString(R.l.gER));
        break;
        this.aedI.setVisibility(8);
      }
    }
    aBA(8);
    this.aedJ.setVisibility(8);
    if (this.aedS) {
      this.aedI.setVisibility(0);
    }
    for (;;)
    {
      this.AkB.setVisibility(8);
      Log.d("MicroMsg.AppAttachDownloadUI", "hide moreOpenWaysArea");
      this.aeeb.setVisibility(4);
      this.aedL.setVisibility(8);
      joo();
      break;
      this.aedI.setVisibility(8);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(34148);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.tencent.mm.pluginsdk.ui.tools.a.a(this, paramInt1, paramInt2, paramIntent, this.aedT, R.l.download_no_match_msg, R.l.download_no_match_title, 1);
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
    if (this.NzY != null) {
      this.NzY.oHS = null;
    }
    as.cWJ().remove(this);
    super.onDestroy();
    if (this.AkR != null) {
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.handoff.a.a.class)).d(this.AkR);
    }
    AppMethodBeat.o(34136);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(34140);
    Log.i("MicroMsg.AppAttachDownloadUI", "onKeyDown keyCode %d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt == 4) && (this.aeea != null) && (this.aeea.af(2, false)))
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
    if (this.aeea != null) {
      this.aeea.bhW();
    }
    init();
    AppMethodBeat.o(34156);
  }
  
  public void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(34149);
    com.tencent.mm.pluginsdk.model.app.c localc = joj();
    int i;
    StringBuilder localStringBuilder;
    if (localc != null)
    {
      long l1 = localc.field_totalLen;
      long l2 = localc.field_offset;
      this.Ysz = l1;
      this.aedK.setText(getString(R.l.gES, new Object[] { ab.getSizeKB(l2), ab.getSizeKB(l1) }));
      if (localc.field_totalLen == 0L) {}
      for (i = 0;; i = (int)(localc.field_offset * 100L / localc.field_totalLen))
      {
        Log.v("MicroMsg.AppAttachDownloadUI", "summerapp attach progress:" + i + " offset:" + l2 + " totallen:" + l1 + " status " + localc.field_status);
        this.aedH.setProgress(i);
        if ((localc.field_status != 199L) || (i < 100) || (this.aedR)) {
          break label456;
        }
        if (this.aeea != null) {
          this.aeea.Aq(this.Ysz);
        }
        this.aedR = true;
        if (this.aedZ)
        {
          this.aedZ = false;
          jog();
        }
        if (this.scene != 3) {
          break;
        }
        paramString = new Intent();
        paramString.putExtra("filePath", this.filePath);
        paramString.putExtra("fileName", this.fileName);
        paramString.putExtra("fileExt", this.lPJ);
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
          String str = com.tencent.mm.loader.i.b.bmu();
          paramMStorageEventData = y.n(paramMStorageEventData, true);
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
      Toast.makeText(this, paramString, this.aedU).show();
      com.tencent.mm.pluginsdk.ui.tools.a.a(this, localc.field_fileFullPath, this.lPJ, this.fileName, 1);
      MMHandlerThread.postToMainThreadDelayed(new AppAttachDownloadUI.9(this), 200L);
      label456:
      if ((this.aedH.getVisibility() != 0) && (i < 100) && (!localc.field_isUpload) && (localc.field_status == 101L))
      {
        Log.i("MicroMsg.AppAttachDownloadUI", "summerapp still downloading updateProgress progress[%d]", new Object[] { Integer.valueOf(i) });
        aBA(0);
        this.aedI.setVisibility(8);
      }
      AppMethodBeat.o(34149);
      return;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(34138);
    bh.aZW().b(221, this);
    bh.aZW().b(728, this);
    super.onPause();
    if (this.aeea != null) {
      this.aeea.bhW();
    }
    rr localrr = new rr();
    localrr.hUK.pause = false;
    rr.a locala = localrr.hUK;
    if (this.hTm == null) {}
    for (String str = "";; str = this.hTm.field_talker)
    {
      locala.talker = str;
      localrr.asyncPublish(getMainLooper());
      Log.d("MicroMsg.AppAttachDownloadUI", "AppAttachDownloadUI cancel pause auto download logic");
      AppMethodBeat.o(34138);
      return;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(34137);
    super.onResume();
    bh.aZW().a(221, this);
    bh.aZW().a(728, this);
    rr localrr = new rr();
    localrr.hUK.pause = true;
    localrr.hUK.talker = this.hTm.field_talker;
    localrr.asyncPublish(getMainLooper());
    Log.d("MicroMsg.AppAttachDownloadUI", "AppAttachDownloadUI req pause auto download logic");
    this.AkB.setEnabled(true);
    if (this.aeea != null) {
      this.aeea.coi();
    }
    AppMethodBeat.o(34137);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(34154);
    Log.i("MicroMsg.AppAttachDownloadUI", "summerapp onSceneEnd type[%d], [%d, %d, %s]", new Object[] { Integer.valueOf(paramp.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramp.getType() != 221) && (paramp.getType() != 728))
    {
      AppMethodBeat.o(34154);
      return;
    }
    if ((paramp.getType() == 728) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = joj();
      if (paramString == null)
      {
        Log.i("MicroMsg.AppAttachDownloadUI", "summerapp onSceneEnd getAppAttachInfo is null");
        if (paramString != null)
        {
          paramString.field_status = 101L;
          paramString.field_lastModifyTime = Util.nowSecond();
          as.cWJ().a(paramString, new String[0]);
        }
        if (this.NzY != null) {
          bh.aZW().a(this.NzY);
        }
        this.NzY = new com.tencent.mm.plugin.record.model.g(this.msgId, this.mediaId, this.aedN);
        bh.aZW().a(this.NzY, 0);
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
    if ((this.NzY == null) && ((paramp instanceof com.tencent.mm.plugin.record.model.g)))
    {
      paramString = (com.tencent.mm.plugin.record.model.g)paramp;
      com.tencent.mm.pluginsdk.model.app.c localc = joj();
      if ((localc != null) && (!ab.isNullOrNil(localc.field_mediaSvrId)) && (localc.field_mediaSvrId.equals(paramString.getMediaId())))
      {
        this.NzY = paramString;
        Log.i("MicroMsg.AppAttachDownloadUI", "summerapp onSceneEnd reset downloadAppAttachScene[%s] by mediaSvrId[%s]", new Object[] { this.NzY, localc.field_mediaSvrId });
      }
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (this.aedP.type == 6)
      {
        hf(0, 2);
        paramString = joj();
        if (paramString != null) {
          com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1203L, 5L, paramString.field_totalLen, false);
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
      jon();
      aBA(8);
      hf(1, 3);
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
    aBA(8);
    this.aedI.setVisibility(0);
    this.aedJ.setVisibility(8);
    Log.e("MicroMsg.AppAttachDownloadUI", "summerapp onSceneEnd, download fail, type = " + paramp.getType() + " errType = " + paramInt1 + ", errCode = " + paramInt2);
    AppMethodBeat.o(34154);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
  {
    Button Bqo;
    private boolean NBX;
    private TextView dyR;
    
    public a(Button paramButton, TextView paramTextView)
    {
      AppMethodBeat.i(34126);
      this.Bqo = paramButton;
      this.dyR = paramTextView;
      if (paramTextView != null)
      {
        int i = com.tencent.mm.k.i.aRC().getInt("MsgFileExpiredInterval", 432000);
        long l = AppAttachDownloadUI.S(AppAttachDownloadUI.this).getCreateTime() / 1000L;
        Math.floor((i - cn.secondsToNow(l)) * 1.0D / 86400.0D);
        paramTextView.setText("");
      }
      AppMethodBeat.o(34126);
    }
    
    public final void jop()
    {
      AppMethodBeat.i(34128);
      Log.i("MicroMsg.AppAttachDownloadUI", "showErrorTip overtime %s", new Object[] { Long.valueOf(AppAttachDownloadUI.S(AppAttachDownloadUI.this).field_msgId) });
      if (this.Bqo != null) {
        this.Bqo.setVisibility(4);
      }
      if (this.dyR != null)
      {
        this.dyR.setVisibility(0);
        this.dyR.setText(R.l.gHD);
        this.dyR.setTextColor(AppAttachDownloadUI.this.getResources().getColor(R.e.Red_120));
        AppAttachDownloadUI.T(AppAttachDownloadUI.this).setVisibility(8);
        AppAttachDownloadUI.E(AppAttachDownloadUI.this).setVisibility(8);
        if (!this.NBX)
        {
          this.NBX = true;
          AppAttachDownloadUI.U(AppAttachDownloadUI.this);
        }
      }
      AppMethodBeat.o(34128);
    }
    
    public final void setVisibility(int paramInt)
    {
      AppMethodBeat.i(34127);
      if (this.Bqo != null) {
        this.Bqo.setVisibility(paramInt);
      }
      if (this.dyR != null) {
        this.dyR.setVisibility(paramInt);
      }
      AppMethodBeat.o(34127);
    }
  }
  
  static final class b
    implements com.tencent.mm.plugin.appbrand.openmaterial.j
  {
    private final com.tencent.mm.plugin.appbrand.service.j WVQ;
    private final WeakReference<AppAttachDownloadUI> YtG;
    private final MaterialModel trN;
    
    public b(AppAttachDownloadUI paramAppAttachDownloadUI, MaterialModel paramMaterialModel, com.tencent.mm.plugin.appbrand.service.j paramj)
    {
      AppMethodBeat.i(253806);
      this.YtG = new WeakReference(paramAppAttachDownloadUI);
      this.trN = paramMaterialModel;
      this.WVQ = paramj;
      AppMethodBeat.o(253806);
    }
    
    public final void a(boolean paramBoolean, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection)
    {
      AppMethodBeat.i(253818);
      Log.d("MicroMsg.AppAttachDownloadUI", "loadOpenMaterials#onMyOpenMaterialsGot");
      AppAttachDownloadUI localAppAttachDownloadUI = (AppAttachDownloadUI)this.YtG.get();
      if (localAppAttachDownloadUI == null)
      {
        Log.i("MicroMsg.AppAttachDownloadUI", "loadOpenMaterials#onMyOpenMaterialsGot, ui is null");
        AppMethodBeat.o(253818);
        return;
      }
      if (!paramBoolean)
      {
        Log.i("MicroMsg.AppAttachDownloadUI", "loadOpenMaterials#onMyOpenMaterialsGot, fail");
        AppMethodBeat.o(253818);
        return;
      }
      AppAttachDownloadUI.a(localAppAttachDownloadUI, this.trN.trT);
      AppAttachDownloadUI.a(localAppAttachDownloadUI, paramAppBrandOpenMaterialCollection);
      if (!AppAttachDownloadUI.d(localAppAttachDownloadUI))
      {
        Log.i("MicroMsg.AppAttachDownloadUI", "loadOpenMaterials#onMyOpenMaterialsGot, download not finish");
        AppMethodBeat.o(253818);
        return;
      }
      if (this.WVQ.cDh().a(paramAppBrandOpenMaterialCollection))
      {
        if (AppAttachDownloadUI.a(localAppAttachDownloadUI) != null) {
          AppAttachDownloadUI.a(localAppAttachDownloadUI).dead();
        }
        AppAttachDownloadUI.a(localAppAttachDownloadUI, this.WVQ.cDh().b(com.tencent.mm.plugin.appbrand.openmaterial.model.b.trZ).a(localAppAttachDownloadUI, AppAttachDownloadUI.x(localAppAttachDownloadUI), AppAttachDownloadUI.y(localAppAttachDownloadUI), null, null));
        Log.d("MicroMsg.AppAttachDownloadUI", "show moreOpenWaysArea");
        AppAttachDownloadUI.z(localAppAttachDownloadUI).setVisibility(0);
      }
      while (AppAttachDownloadUI.x(localAppAttachDownloadUI) != null) {
        if (this.WVQ.a(AppAttachDownloadUI.x(localAppAttachDownloadUI), paramAppBrandOpenMaterialCollection))
        {
          if (AppAttachDownloadUI.A(localAppAttachDownloadUI) != null) {
            AppAttachDownloadUI.A(localAppAttachDownloadUI).dead();
          }
          AppAttachDownloadUI.a(localAppAttachDownloadUI, this.WVQ.a(com.tencent.mm.plugin.appbrand.openmaterial.model.b.trZ, localAppAttachDownloadUI, AppAttachDownloadUI.x(localAppAttachDownloadUI), AppAttachDownloadUI.y(localAppAttachDownloadUI), AppAttachDownloadUI.a(localAppAttachDownloadUI), null));
          AppMethodBeat.o(253818);
          return;
          Log.i("MicroMsg.AppAttachDownloadUI", "loadOpenMaterials#onMyOpenMaterialsGot, can not create");
        }
        else
        {
          Log.i("MicroMsg.AppAttachDownloadUI", "loadOpenMaterials#onMyOpenMaterialsGot, not need enhance");
        }
      }
      AppMethodBeat.o(253818);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppAttachDownloadUI
 * JD-Core Version:    0.7.0.1
 */