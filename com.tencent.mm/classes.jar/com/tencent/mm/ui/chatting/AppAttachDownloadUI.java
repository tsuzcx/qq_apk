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
import com.tencent.mm.ag.k.b;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.pg;
import com.tencent.mm.g.a.pg.a;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.plugin.appbrand.openmaterial.g.a;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection;
import com.tencent.mm.plugin.appbrand.openmaterial.model.MaterialModel;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.plugin.msgquote.model.MsgQuoteItem;
import com.tencent.mm.plugin.record.b.f.a;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.protocal.protobuf.ach;
import com.tencent.mm.protocal.protobuf.aoe;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.h.e;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.report.MMSecDataActivity;
import com.tencent.mm.ui.tools.ShowImageUI;
import com.tencent.mm.ui.widget.progress.RoundProgressBtn;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.List;

public class AppAttachDownloadUI
  extends MMSecDataActivity
  implements com.tencent.mm.ak.i, f.a, MStorage.IOnStorageChange
{
  private com.tencent.mm.plugin.record.b.f BGq;
  private MMImageView BtF;
  private AppBrandOpenMaterialCollection Jgy;
  private com.tencent.mm.plugin.appbrand.openmaterial.h Jgz;
  private com.tencent.mm.ui.chatting.multitask.b KvS;
  private String KvW;
  private com.tencent.mm.plugin.appbrand.openmaterial.g KvX;
  private long LzM;
  private RoundProgressBtn Pdf;
  private a Pdg;
  private View Pdh;
  private TextView Pdi;
  private TextView Pdj;
  private TextView Pdk;
  private j Pdl;
  private boolean Pdm;
  private k.b Pdn;
  private String Pdo;
  private boolean Pdp;
  private boolean Pdq;
  private boolean Pdr;
  private int Pds;
  private boolean Pdt;
  private int Pdu;
  private LinearLayout Pdv;
  private LinearLayout Pdw;
  private boolean Pdx;
  private LinearLayout Pdy;
  private ImageView Pdz;
  private String aesKey;
  private int appType;
  private String authKey;
  private String cdnURL;
  private String dRL;
  private ca dTX;
  private boolean dUo;
  private String dWG;
  private String fileName;
  private String filePath;
  private String gCr;
  private TextView kbe;
  private String mediaId;
  private long msgId;
  private com.tencent.mm.ui.widget.a.e oXS;
  private String pkL;
  private int ppd;
  private int ppe;
  private com.tencent.mm.ui.widget.b.a pqr;
  private int qoX;
  private o.g rJj;
  private int scene;
  private Button thI;
  private HandOffFile thY;
  private View.OnTouchListener tia;
  private View.OnLongClickListener tib;
  
  public AppAttachDownloadUI()
  {
    AppMethodBeat.i(34129);
    this.qoX = 0;
    this.Pdp = false;
    this.Pdq = false;
    this.Pdr = true;
    this.Pds = 5000;
    this.Pdt = false;
    this.Pdx = false;
    this.KvW = null;
    this.Jgy = null;
    this.KvX = null;
    this.Jgz = null;
    this.oXS = null;
    this.pqr = null;
    this.rJj = new o.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(232797);
        if (AppAttachDownloadUI.J(AppAttachDownloadUI.this).equals("")) {}
        for (paramAnonymousMenuItem = AppAttachDownloadUI.this.getString(2131763782);; paramAnonymousMenuItem = AppAttachDownloadUI.J(AppAttachDownloadUI.this))
        {
          ClipboardHelper.setText(MMApplicationContext.getContext(), null, paramAnonymousMenuItem);
          com.tencent.mm.ui.base.h.cD(AppAttachDownloadUI.this, AppAttachDownloadUI.this.getString(2131755773));
          AppMethodBeat.o(232797);
          return;
        }
      }
    };
    this.tia = new AppAttachDownloadUI.5(this);
    this.tib = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(232799);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/AppAttachDownloadUI$14", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
        Log.d("MicroMsg.AppAttachDownloadUI", "onLongClick");
        if (AppAttachDownloadUI.K(AppAttachDownloadUI.this) == null) {
          AppAttachDownloadUI.a(AppAttachDownloadUI.this, new com.tencent.mm.ui.widget.b.a(AppAttachDownloadUI.this.cWv()));
        }
        AppAttachDownloadUI.K(AppAttachDownloadUI.this).a(paramAnonymousView, AppAttachDownloadUI.this, AppAttachDownloadUI.L(AppAttachDownloadUI.this), AppAttachDownloadUI.M(AppAttachDownloadUI.this), AppAttachDownloadUI.N(AppAttachDownloadUI.this));
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/chatting/AppAttachDownloadUI$14", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(232799);
        return true;
      }
    };
    AppMethodBeat.o(34129);
  }
  
  private void alY(int paramInt)
  {
    AppMethodBeat.i(34158);
    if (paramInt != this.Pdf.getVisibility())
    {
      Log.i("MicroMsg.AppAttachDownloadUI", "setRoundProgressBar %s %s", new Object[] { Integer.valueOf(paramInt), af.blN() });
      this.Pdf.setVisibility(paramInt);
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
    o localo = new o(paramc.field_fileFullPath);
    if ((localo.exists()) && (localo.length() == paramc.field_totalLen))
    {
      AppMethodBeat.o(34157);
      return true;
    }
    AppMethodBeat.o(34157);
    return false;
  }
  
  private boolean cPt()
  {
    AppMethodBeat.i(34134);
    this.scene = getIntent().getIntExtra("scene", 0);
    this.msgId = getIntent().getLongExtra("app_msg_id", -1L);
    this.Pdt = getIntent().getBooleanExtra("choose_way", false);
    this.Pdu = getIntent().getIntExtra("msg_type", 0);
    if (this.msgId == -1L)
    {
      AppMethodBeat.o(34134);
      return false;
    }
    bg.aVF();
    this.dTX = com.tencent.mm.model.c.aSQ().Hb(this.msgId);
    Object localObject1;
    if ((this.dTX == null) || (this.dTX.field_msgId == 0L) || (this.dTX.field_content == null))
    {
      if (!gMw()) {
        break label393;
      }
      localObject1 = (MsgQuoteItem)getIntent().getParcelableExtra("key_quoted_msg");
      if (localObject1 == null)
      {
        AppMethodBeat.o(34134);
        return false;
      }
      this.dTX = new ca();
      this.dTX.setType(((MsgQuoteItem)localObject1).type);
      this.dTX.yF(((MsgQuoteItem)localObject1).zFI);
      this.dTX.Cy(((MsgQuoteItem)localObject1).zFJ);
      this.dTX.BB(((MsgQuoteItem)localObject1).zFM);
      this.dTX.setContent(((MsgQuoteItem)localObject1).content);
      if (Util.isEqual(((MsgQuoteItem)localObject1).zFK, z.aTY())) {
        this.dTX.nv(1);
      }
    }
    this.Pdm = com.tencent.mm.model.ab.Eq(this.dTX.field_talker);
    this.dWG = this.dTX.field_content;
    Object localObject2;
    if ((this.Pdm) && (this.dTX.field_isSend == 0))
    {
      localObject2 = this.dTX.field_content;
      localObject1 = localObject2;
      if (this.Pdm)
      {
        localObject1 = localObject2;
        if (localObject2 != null) {
          localObject1 = bp.Kt((String)localObject2);
        }
      }
      this.dWG = ((String)localObject1);
    }
    this.Pdn = k.b.HD(this.dWG);
    if (this.Pdn == null)
    {
      Log.e("MicroMsg.AppAttachDownloadUI", "summerapp parse msgContent error, %s", new Object[] { this.dWG });
      AppMethodBeat.o(34134);
      return false;
      label393:
      AppMethodBeat.o(34134);
      return false;
    }
    if ((af.isNullOrNil(this.Pdn.dCK)) && (!af.isNullOrNil(this.Pdn.iwW)))
    {
      Log.e("MicroMsg.AppAttachDownloadUI", "summerapp msgContent format error, %s", new Object[] { this.dWG });
      this.Pdn.dCK = this.Pdn.iwW.hashCode();
    }
    this.appType = this.Pdn.type;
    this.mediaId = this.Pdn.dCK;
    this.fileName = af.nullAsNil(this.Pdn.title);
    this.gCr = af.nullAsNil(this.Pdn.iwJ).toLowerCase();
    this.LzM = this.Pdn.iwI;
    this.pkL = af.nullAsNil(this.Pdn.filemd5);
    this.dRL = af.nullAsNil(this.Pdn.dRL);
    this.cdnURL = af.nullAsNil(this.Pdn.iwW);
    this.Pdo = af.nullAsNil(this.Pdn.iwN);
    this.aesKey = af.nullAsNil(this.Pdn.aesKey);
    this.authKey = af.nullAsNil(this.Pdn.iwT);
    if (af.isNullOrNil(this.gCr)) {
      this.gCr = s.akC(this.fileName);
    }
    Log.i("MicroMsg.AppAttachDownloadUI", "summerapp initParams msgId[%d], sender[%d], msgContent[%s], appType[%d], mediaId[%s], fileName[%s]", new Object[] { Long.valueOf(this.msgId), Integer.valueOf(this.dTX.field_isSend), this.dWG, Integer.valueOf(this.appType), this.mediaId, this.fileName });
    com.tencent.mm.pluginsdk.model.app.c localc = gMB();
    if (localc == null)
    {
      Log.i("MicroMsg.AppAttachDownloadUI", "summerapp initParams attInfo is null");
      this.Pdq = false;
    }
    for (;;)
    {
      if (this.Pdn.type == 6) {
        ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.comm.a.b.class)).Z(String.valueOf(this.dTX.field_msgId), this.dTX.field_msgSvrId);
      }
      fP(4, 0);
      String str1 = af.nullAsNil(z.aTY());
      localObject2 = af.nullAsNil(this.dTX.field_talker);
      localObject1 = localObject2;
      if (com.tencent.mm.model.ab.Eq((String)localObject2)) {
        localObject1 = af.nullAsNil(this.Pdn.dRL);
      }
      label845:
      label856:
      boolean bool;
      label916:
      int i;
      if (this.dTX.field_isSend == 1)
      {
        localObject2 = str1;
        if (this.dTX.field_isSend != 1) {
          break label1243;
        }
        String str2 = af.nullAsNil(this.filePath);
        String str3 = this.gCr;
        String str4 = this.fileName;
        String str5 = this.pkL;
        long l = this.LzM;
        String str6 = Long.toString(this.dTX.field_msgSvrId);
        if (af.isNullOrNil(this.cdnURL)) {
          break label1250;
        }
        str1 = this.cdnURL;
        this.thY = new HandOffFile(str2, str3, str4, str5, l, 1, str6, "", str1, this.aesKey, this.authKey, 1, "", 0, "", 0L, 1, (String)localObject2, (String)localObject1);
        bool = b(gMB());
        localObject1 = this.thY;
        if (!bool) {
          break label1259;
        }
        i = 1;
        ((HandOffFile)localObject1).setFileStatus(i);
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).g(this.thY);
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).c(this.thY);
        localObject1 = new ach();
        localObject2 = getIntent().getByteArrayExtra("key_multi_task_common_info");
        if (localObject2 == null) {}
      }
      try
      {
        ((ach)localObject1).parseFrom((byte[])localObject2);
        if (b(localc)) {
          if (this.scene == 3)
          {
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("filePath", this.filePath);
            ((Intent)localObject1).putExtra("fileName", this.fileName);
            ((Intent)localObject1).putExtra("fileExt", this.gCr);
            setResult(-1, (Intent)localObject1);
            finish();
            AppMethodBeat.o(34134);
            return true;
            this.filePath = localc.field_fileFullPath;
            new o(localc.field_fileFullPath);
            if (localc.field_offset > 0L) {}
            for (this.Pdq = true;; this.Pdq = false)
            {
              Log.i("MicroMsg.AppAttachDownloadUI", "summerapp initParams attInfo field_fileFullPath[%s], field_offset[%d], isDownloadStarted[%b]", new Object[] { localc.field_fileFullPath, Long.valueOf(localc.field_offset), Boolean.valueOf(this.Pdq) });
              break;
            }
            localObject2 = localObject1;
            break label845;
            label1243:
            localObject1 = str1;
            break label856;
            label1250:
            str1 = this.Pdo;
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
          this.qoX = 7;
          if (this.Pdt)
          {
            bool = com.tencent.mm.pluginsdk.ui.tools.a.c(this, localc.field_fileFullPath, this.gCr, this.qoX);
            AppMethodBeat.o(34134);
            return bool;
          }
          bool = com.tencent.mm.pluginsdk.ui.tools.a.a(localc.field_fileFullPath, this.gCr, this.qoX, (ach)localObject1);
          AppMethodBeat.o(34134);
          return bool;
        }
        if (this.qoX != 9) {
          this.qoX = 1;
        }
        if (this.Pdt)
        {
          bool = com.tencent.mm.pluginsdk.ui.tools.a.c(this, localc.field_fileFullPath, this.gCr, this.qoX);
          AppMethodBeat.o(34134);
          return bool;
        }
        if (!com.tencent.mm.pluginsdk.ui.tools.a.mE(localc.field_fileFullPath, this.gCr))
        {
          bool = com.tencent.mm.pluginsdk.ui.tools.a.a(localc.field_fileFullPath, this.gCr, this.qoX, (ach)localObject1);
          AppMethodBeat.o(34134);
          return bool;
        }
        AppMethodBeat.o(34134);
      }
    }
    return true;
  }
  
  private void dGU()
  {
    AppMethodBeat.i(34153);
    Log.i("MicroMsg.AppAttachDownloadUI", "[ImageGalleryUI] showImage");
    Object localObject = new Intent(this, ImageGalleryUI.class);
    ((Intent)localObject).putExtra("img_gallery_msg_id", this.dTX.field_msgId);
    ((Intent)localObject).putExtra("img_gallery_talker", this.dTX.field_talker);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/chatting/AppAttachDownloadUI", "showImage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/AppAttachDownloadUI", "showImage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    overridePendingTransition(0, 0);
    AppMethodBeat.o(34153);
  }
  
  private void fP(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(34161);
    String str;
    if (6 == this.appType)
    {
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1203L, paramInt2, 1L, false);
      str = this.Pdn.iwW;
      if (this.Pdn.iwM != 1) {
        break label208;
      }
    }
    label208:
    for (paramInt2 = 7;; paramInt2 = 5)
    {
      str = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { str, Integer.valueOf(paramInt2), Integer.valueOf(this.Pdn.iwI), Integer.valueOf(paramInt1), Long.valueOf((cl.aWz() - this.dTX.field_createTime) / 1000L), this.gCr, this.dTX.field_talker, Integer.valueOf(1), "", Long.valueOf(this.dTX.field_msgSvrId), Long.valueOf(this.dTX.field_createTime) });
      Log.i("MicroMsg.AppAttachDownloadUI", "reportKVStat 14665 %s", new Object[] { str });
      com.tencent.mm.plugin.report.service.h.CyF.kvStat(14665, str);
      AppMethodBeat.o(34161);
      return;
    }
  }
  
  private boolean gMA()
  {
    int i = -1;
    boolean bool2 = true;
    AppMethodBeat.i(34145);
    Object localObject1 = gMB();
    Object localObject2;
    boolean bool1;
    long l1;
    long l2;
    long l3;
    String str1;
    long l4;
    if (localObject1 == null)
    {
      m.E(this.msgId, this.dWG);
      localObject2 = gMB();
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
        if (this.Pdn.iwM == 0)
        {
          localObject1 = localObject2;
          bool1 = bool2;
          if (this.Pdn.iwI <= 26214400) {}
        }
        else
        {
          if (af.isNullOrNil(((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_signature)) {
            break label334;
          }
          bool1 = true;
          label219:
          localObject1 = localObject2;
        }
      }
      if ((this.Pdn == null) || ((this.Pdn.iwM == 0) && (this.Pdn.iwI <= 26214400))) {
        break label569;
      }
      bool1 = false;
    }
    label569:
    for (;;)
    {
      if (!bool1) {
        bg.azz().a(new com.tencent.mm.plugin.record.b.d((com.tencent.mm.pluginsdk.model.app.c)localObject1, this.aesKey, this.pkL, this.fileName, this.gCr, this.dRL), 0);
      }
      if (localObject1 != null)
      {
        this.filePath = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath;
        gMv();
      }
      AppMethodBeat.o(34145);
      return bool1;
      label322:
      i = ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_signature.length();
      break;
      label334:
      bool1 = false;
      break label219;
      localObject2 = new o(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath);
      if ((((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_status == 199L) && (!((o)localObject2).exists()))
      {
        Log.i("MicroMsg.AppAttachDownloadUI", "summerapp tryInitAttachInfo info exist but file not!");
        m.E(this.msgId, this.dWG);
      }
      l1 = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).systemRowid;
      l2 = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_totalLen;
      str1 = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath;
      l3 = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_type;
      String str2 = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_mediaId;
      l4 = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_msgInfoId;
      bool1 = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_isUpload;
      boolean bool3 = ((o)localObject2).exists();
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
  
  private com.tencent.mm.pluginsdk.model.app.c gMB()
  {
    AppMethodBeat.i(34147);
    final com.tencent.mm.pluginsdk.model.app.c localc1 = ao.cgO().Mp(this.msgId);
    if (localc1 != null)
    {
      Log.i("MicroMsg.AppAttachDownloadUI", "summerapp getAppAttachInfo by msgId [%d] stack[%s]", new Object[] { Long.valueOf(this.msgId), af.blN() });
      AppMethodBeat.o(34147);
      return localc1;
    }
    localc1 = m.bdJ(this.mediaId);
    if (localc1 == null)
    {
      Log.i("MicroMsg.AppAttachDownloadUI", "summerapp getAppAttachInfo by msgId and mediaId is null stack[%s]", new Object[] { af.blN() });
      AppMethodBeat.o(34147);
      return localc1;
    }
    if ((localc1.field_msgInfoId == this.msgId) || (s.YS(localc1.field_fileFullPath)))
    {
      AppMethodBeat.o(34147);
      return localc1;
    }
    m.E(this.msgId, this.dWG);
    final com.tencent.mm.pluginsdk.model.app.c localc2 = ao.cgO().Mp(this.msgId);
    if (localc2 == null)
    {
      Log.w("MicroMsg.AppAttachDownloadUI", "summerapp getAppAttachInfo create new info from local but failed stack[%s]", new Object[] { af.blN() });
      AppMethodBeat.o(34147);
      return localc1;
    }
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(232801);
        long l1 = System.currentTimeMillis();
        long l2 = s.nw(localc1.field_fileFullPath, localc2.field_fileFullPath);
        if (l2 > 0L)
        {
          localc2.field_offset = l2;
          if (AppAttachDownloadUI.c(localc2)) {
            localc2.field_status = 199L;
          }
        }
        for (boolean bool = ao.cgO().a(localc2, new String[0]);; bool = false)
        {
          Log.i("MicroMsg.AppAttachDownloadUI", "summerapp copyAttachFromLocal size[%d], id[%d, %d], ret[%b], new status[%d], take[%d]ms", new Object[] { Long.valueOf(l2), Long.valueOf(localc1.field_msgInfoId), Long.valueOf(localc2.field_msgInfoId), Boolean.valueOf(bool), Long.valueOf(localc2.field_status), Long.valueOf(System.currentTimeMillis() - l1) });
          AppMethodBeat.o(232801);
          return;
        }
      }
    }, "copyAttachFromLocal");
    AppMethodBeat.o(34147);
    return localc1;
  }
  
  private void gMC()
  {
    AppMethodBeat.i(34150);
    switch (this.appType)
    {
    case 1: 
    case 3: 
    case 4: 
    case 5: 
    default: 
      this.thI.setVisibility(0);
      alY(8);
      this.Pdh.setVisibility(8);
    }
    for (;;)
    {
      Object localObject;
      if (this.thY.getFileStatus() != 1)
      {
        this.thY.setFileStatus(1);
        localObject = gMB();
        if (localObject != null) {
          this.thY.setFullPath(af.nullAsNil(((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath));
        }
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).g(this.thY);
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).e(this.thY);
      }
      gMx();
      AppMethodBeat.o(34150);
      return;
      if (gMD()) {
        if (Util.isImageExt(this.gCr))
        {
          gME();
        }
        else
        {
          localObject = getMimeType();
          Log.i("MicroMsg.AppAttachDownloadUI", "onDownLoadImpl");
          gMG();
          alY(8);
          this.Pdh.setVisibility(8);
          this.Pdg.setVisibility(8);
          this.Pdj.setVisibility(0);
          if (this.fileName.equals("")) {
            this.Pdj.setText(getString(2131763782));
          }
          for (;;)
          {
            if ((localObject != null) && (!((String)localObject).equals(""))) {
              break label322;
            }
            this.thI.setVisibility(8);
            this.kbe.setText(getString(2131758364));
            break;
            this.Pdj.setText(this.fileName);
          }
          label322:
          this.thI.setVisibility(0);
          this.kbe.setText(getString(2131758365));
          continue;
          if (gMD())
          {
            dGU();
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
  
  private boolean gMD()
  {
    AppMethodBeat.i(34151);
    Object localObject = gMB();
    if (localObject == null)
    {
      AppMethodBeat.o(34151);
      return true;
    }
    if (s.YS(((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath))
    {
      alY(8);
      this.Pdh.setVisibility(8);
      this.Pdg.setVisibility(8);
      AppMethodBeat.o(34151);
      return true;
    }
    alY(8);
    gMF();
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
  
  private void gME()
  {
    AppMethodBeat.i(34152);
    Object localObject = gMB();
    if (localObject == null)
    {
      Log.e("MicroMsg.AppAttachDownloadUI", "info == null");
      AppMethodBeat.o(34152);
      return;
    }
    Intent localIntent = new Intent(this, ShowImageUI.class);
    localIntent.putExtra("key_message_id", this.dTX.field_msgId);
    localIntent.putExtra("key_image_path", ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath);
    localIntent.putExtra("key_favorite", true);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/chatting/AppAttachDownloadUI", "showFileImage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/AppAttachDownloadUI", "showFileImage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    AppMethodBeat.o(34152);
  }
  
  private void gMF()
  {
    AppMethodBeat.i(34159);
    this.Pdv.setVisibility(0);
    this.Pdw.setVisibility(8);
    gMG();
    this.Pdg.gMH();
    AppMethodBeat.o(34159);
  }
  
  private void gMG()
  {
    AppMethodBeat.i(34160);
    this.kbe.setVisibility(8);
    AppMethodBeat.o(34160);
  }
  
  private void gMv()
  {
    AppMethodBeat.i(232813);
    this.KvS = new com.tencent.mm.ui.chatting.multitask.b(new com.tencent.mm.plugin.multitask.a.b((MMActivity)super.getContext()));
    this.KvS.g(this.filePath, this.gCr, this.qoX, true);
    this.KvS.ni(this.gCr, this.fileName);
    this.thY.saveToMultiTaskInfo(this.KvS.Abp);
    AppMethodBeat.o(232813);
  }
  
  private boolean gMw()
  {
    return this.Pdu == 1;
  }
  
  private void gMx()
  {
    AppMethodBeat.i(232815);
    Log.d("MicroMsg.AppAttachDownloadUI", "loadOpenMaterials");
    if (af.isNullOrNil(this.filePath))
    {
      Log.w("MicroMsg.AppAttachDownloadUI", "loadOpenMaterials, filePath is empty");
      AppMethodBeat.o(232815);
      return;
    }
    if ((this.filePath.equals(this.KvW)) && (this.Jgy != null))
    {
      Log.i("MicroMsg.AppAttachDownloadUI", "loadOpenMaterials, already load");
      AppMethodBeat.o(232815);
      return;
    }
    MaterialModel localMaterialModel = MaterialModel.eC(this.filePath, this.gCr);
    if (localMaterialModel == null)
    {
      Log.w("MicroMsg.AppAttachDownloadUI", "loadOpenMaterials, materialModel is null");
      AppMethodBeat.o(232815);
      return;
    }
    com.tencent.mm.plugin.appbrand.service.i locali = (com.tencent.mm.plugin.appbrand.service.i)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.i.class);
    if (locali == null)
    {
      Log.w("MicroMsg.AppAttachDownloadUI", "loadOpenMaterials, openMaterialService is null");
      AppMethodBeat.o(232815);
      return;
    }
    if (!locali.c(com.tencent.mm.plugin.appbrand.openmaterial.model.b.nlP))
    {
      Log.i("MicroMsg.AppAttachDownloadUI", "loadOpenMaterials, openMaterialService is not enabled");
      AppMethodBeat.o(232815);
      return;
    }
    if (!locali.adl(localMaterialModel.mimeType))
    {
      Log.i("MicroMsg.AppAttachDownloadUI", "loadOpenMaterials, openMaterialService is not support " + localMaterialModel.mimeType);
      AppMethodBeat.o(232815);
      return;
    }
    locali.a(localMaterialModel, new b(this, localMaterialModel, locali));
    AppMethodBeat.o(232815);
  }
  
  private void gMy()
  {
    AppMethodBeat.i(34141);
    cz localcz = new cz();
    com.tencent.mm.pluginsdk.model.h.d(localcz, this.dTX);
    localcz.dFZ.activity = this;
    localcz.dFZ.dGf = 39;
    EventCenter.instance.publish(localcz);
    AppMethodBeat.o(34141);
  }
  
  private void gMz()
  {
    AppMethodBeat.i(34143);
    alY(0);
    this.Pdg.setVisibility(8);
    if (gMA())
    {
      Log.i("MicroMsg.AppAttachDownloadUI", "startToDownloadFile");
      this.BGq = new com.tencent.mm.plugin.record.b.f(this.msgId, this.mediaId, this.Pdl);
      bg.azz().a(this.BGq, 0);
      com.tencent.mm.modelsimple.ab.ab(this.dTX);
      fP(7, 1);
    }
    AppMethodBeat.o(34143);
  }
  
  private String getMimeType()
  {
    AppMethodBeat.i(34146);
    k.b localb = k.b.HD(this.dWG);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localb.iwJ != null)
    {
      localObject1 = localObject2;
      if (localb.iwJ.length() > 0) {
        localObject1 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(localb.iwJ);
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
      localObject2 = "*/" + localb.iwJ;
    }
    AppMethodBeat.o(34146);
    return localObject2;
  }
  
  private void init()
  {
    AppMethodBeat.i(34131);
    setMMTitle("");
    setActionbarColor(getResources().getColor(2131101424));
    hideActionbarLine();
    if (!cPt())
    {
      finish();
      AppMethodBeat.o(34131);
      return;
    }
    o localo = new o(com.tencent.mm.loader.j.b.aKM());
    if (!localo.exists()) {
      localo.mkdirs();
    }
    ao.cgO().add(this);
    initView();
    gMv();
    AppMethodBeat.o(34131);
  }
  
  public final MMActivity cWv()
  {
    AppMethodBeat.i(258281);
    MMActivity localMMActivity = (MMActivity)super.getContext();
    AppMethodBeat.o(258281);
    return localMMActivity;
  }
  
  public final void eIn()
  {
    AppMethodBeat.i(34155);
    Toast.makeText(this, 2131758383, 0).show();
    AppMethodBeat.o(34155);
  }
  
  public int getLayoutId()
  {
    return 2131493859;
  }
  
  public void initView()
  {
    AppMethodBeat.i(34139);
    this.BtF = ((MMImageView)findViewById(2131299790));
    this.Pdf = ((RoundProgressBtn)findViewById(2131307181));
    this.Pdg = new a((Button)findViewById(2131299755), (TextView)findViewById(2131299756));
    this.thI = ((Button)findViewById(2131299773));
    this.Pdh = findViewById(2131299757);
    this.kbe = ((TextView)findViewById(2131299765));
    this.Pdi = ((TextView)findViewById(2131299758));
    this.Pdj = ((TextView)findViewById(2131299763));
    this.Pdk = ((TextView)findViewById(2131299764));
    this.Pdv = ((LinearLayout)findViewById(2131299767));
    this.Pdw = ((LinearLayout)findViewById(2131303681));
    this.Pdy = ((LinearLayout)findViewById(2131299769));
    this.Pdz = ((ImageView)findViewById(2131299768));
    this.Pdz.setImageDrawable(ar.m(this, 2131690605, getResources().getColor(2131100086)));
    this.Pdy.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(232795);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/AppAttachDownloadUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        Log.d("MicroMsg.AppAttachDownloadUI", "MoreOpenWaysArea#onClick");
        if (AppAttachDownloadUI.a(AppAttachDownloadUI.this) != null) {
          AppAttachDownloadUI.a(AppAttachDownloadUI.this).bPY();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/AppAttachDownloadUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(232795);
      }
    });
    this.Pdj.setOnTouchListener(this.tia);
    this.Pdj.setOnLongClickListener(this.tib);
    if (this.Pdj != null)
    {
      localObject = this.Pdj.getPaint();
      if (localObject != null) {
        ((Paint)localObject).setFakeBoldText(true);
      }
    }
    this.Pdf.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(34115);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/AppAttachDownloadUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        AppAttachDownloadUI.a(AppAttachDownloadUI.this, 8);
        AppAttachDownloadUI.C(AppAttachDownloadUI.this).setVisibility(0);
        AppAttachDownloadUI.D(AppAttachDownloadUI.this).setVisibility(8);
        Log.i("MicroMsg.AppAttachDownloadUI", "summerapp roundProgressBar downloadAppAttachScene[%s]", new Object[] { AppAttachDownloadUI.b(AppAttachDownloadUI.this) });
        if (AppAttachDownloadUI.b(AppAttachDownloadUI.this) != null)
        {
          AppAttachDownloadUI.b(AppAttachDownloadUI.this).a(AppAttachDownloadUI.this);
          com.tencent.mm.kernel.g.azz().a(AppAttachDownloadUI.b(AppAttachDownloadUI.this));
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
            ao.cgO().a(paramAnonymousView, new String[0]);
          }
        }
      }
    });
    Object localObject = this.Pdg;
    View.OnClickListener local3 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(232796);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/AppAttachDownloadUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        AppAttachDownloadUI.a(AppAttachDownloadUI.this, 0);
        AppAttachDownloadUI.C(AppAttachDownloadUI.this).setVisibility(8);
        if (AppAttachDownloadUI.F(AppAttachDownloadUI.this))
        {
          paramAnonymousView = AppAttachDownloadUI.E(AppAttachDownloadUI.this);
          if (paramAnonymousView != null)
          {
            paramAnonymousView.field_status = 101L;
            paramAnonymousView.field_lastModifyTime = Util.nowSecond();
            ao.cgO().a(paramAnonymousView, new String[0]);
          }
          AppAttachDownloadUI.a(AppAttachDownloadUI.this, new com.tencent.mm.plugin.record.b.f(AppAttachDownloadUI.G(AppAttachDownloadUI.this), AppAttachDownloadUI.H(AppAttachDownloadUI.this), AppAttachDownloadUI.I(AppAttachDownloadUI.this)));
          bg.azz().a(AppAttachDownloadUI.b(AppAttachDownloadUI.this), 0);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/AppAttachDownloadUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(232796);
      }
    };
    ((a)localObject).ubX.setOnClickListener(local3);
    this.thI.setOnClickListener(new AppAttachDownloadUI.7(this));
    switch (this.appType)
    {
    case 1: 
    case 3: 
    case 5: 
    default: 
      this.BtF.setImageResource(2131689580);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(34118);
          if (AppAttachDownloadUI.b(AppAttachDownloadUI.this) != null) {
            bg.azz().a(AppAttachDownloadUI.b(AppAttachDownloadUI.this));
          }
          if ((AppAttachDownloadUI.c(AppAttachDownloadUI.this) != null) && (AppAttachDownloadUI.c(AppAttachDownloadUI.this).O(1, false)))
          {
            AppMethodBeat.o(34118);
            return true;
          }
          AppAttachDownloadUI.this.finish();
          AppMethodBeat.o(34118);
          return true;
        }
      });
      this.dUo = getIntent().getBooleanExtra("app_show_share", true);
      if (this.dUo) {
        addIconOptionMenu(0, 2131689495, new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(232803);
            AppAttachDownloadUI.a(AppAttachDownloadUI.this, AppAttachDownloadUI.d(AppAttachDownloadUI.this));
            AppMethodBeat.o(232803);
            return false;
          }
        });
      }
      this.Pdp = false;
      if ((!gMw()) || (this.dTX.field_msgId != 0L)) {
        break label659;
      }
      this.Pdk.setVisibility(8);
      this.Pdj.setVisibility(0);
      if (this.fileName.equals("")) {
        this.Pdj.setText(getString(2131763782));
      }
      break;
    }
    for (;;)
    {
      gMF();
      if (this.scene == 3)
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("resLoadFailed", true);
        setResult(-1, (Intent)localObject);
        finish();
      }
      AppMethodBeat.o(34139);
      return;
      this.BtF.setImageResource(2131230967);
      break;
      this.BtF.setImageResource(2131689584);
      break;
      this.BtF.setImageResource(r.bdt(this.gCr));
      break;
      if (Util.isImageExt(this.gCr))
      {
        this.BtF.setImageResource(2131230967);
        break;
      }
      this.BtF.setImageResource(2131689580);
      break;
      this.Pdj.setText(this.fileName);
    }
    label659:
    localObject = gMB();
    int i;
    if ((localObject == null) || (!new o(((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath).exists()))
    {
      i = 0;
      if (i == 0) {
        break label810;
      }
      Log.i("MicroMsg.AppAttachDownloadUI", "summerapp isCanOpenFile");
      if (this.LzM <= 0L) {
        break label798;
      }
      this.Pdk.setVisibility(0);
      this.Pdk.setText(getResources().getString(2131759410, new Object[] { af.getSizeKB(this.LzM) }));
    }
    for (;;)
    {
      this.Pdp = true;
      gMC();
      AppMethodBeat.o(34139);
      return;
      if ((((com.tencent.mm.pluginsdk.model.app.c)localObject).deQ()) || ((this.dTX.field_isSend == 1) && (((com.tencent.mm.pluginsdk.model.app.c)localObject).field_isUpload)))
      {
        i = 1;
        break;
      }
      i = 0;
      break;
      label798:
      this.Pdk.setVisibility(8);
    }
    label810:
    if (this.LzM > 0L)
    {
      this.Pdk.setVisibility(0);
      this.Pdk.setText(getResources().getString(2131759410, new Object[] { af.getSizeKB(this.LzM) }));
    }
    while (this.Pdp)
    {
      AppMethodBeat.o(34139);
      return;
      this.Pdk.setVisibility(8);
    }
    this.Pdl = new j()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, q paramAnonymousq)
      {
        AppMethodBeat.i(232810);
        if (paramAnonymousInt2 == 0) {}
        for (float f = 0.0F;; f = paramAnonymousInt1 * 100.0F / paramAnonymousInt2)
        {
          if ((paramAnonymousInt1 < paramAnonymousInt2) && (AppAttachDownloadUI.B(AppAttachDownloadUI.this).getVisibility() != 0))
          {
            AppAttachDownloadUI.a(AppAttachDownloadUI.this, 0);
            AppAttachDownloadUI.C(AppAttachDownloadUI.this).setVisibility(8);
          }
          AppAttachDownloadUI.B(AppAttachDownloadUI.this).setProgress((int)f);
          AppMethodBeat.o(232810);
          return;
        }
      }
    };
    switch (this.appType)
    {
    case 1: 
    case 3: 
    case 4: 
    case 5: 
    default: 
      Log.i("MicroMsg.AppAttachDownloadUI", "summerapp progressCallBack[%s], isDownloadFinished[%b], isDownloadStarted[%b]", new Object[] { this.Pdl, Boolean.valueOf(this.Pdp), Boolean.valueOf(this.Pdq) });
      if ((this.appType == 2) || ((!this.Pdp) && (!this.Pdq))) {
        gMz();
      }
      AppMethodBeat.o(34139);
      return;
    case 0: 
    case 6: 
      if (this.Pdq)
      {
        this.Pdg.setVisibility(0);
        alY(8);
        this.Pdh.setVisibility(8);
        this.thI.setVisibility(8);
        Log.d("MicroMsg.AppAttachDownloadUI", "hide moreOpenWaysArea");
        this.Pdy.setVisibility(4);
        gMG();
        this.Pdj.setVisibility(0);
        if (!this.fileName.equals("")) {
          break label1176;
        }
        this.Pdj.setText(getString(2131763782));
        localObject = getMimeType();
        if ((localObject != null) && (!((String)localObject).equals(""))) {
          break label1190;
        }
        this.kbe.setText(getString(2131758364));
      }
      while (Util.isImageExt(this.gCr))
      {
        gMG();
        break;
        this.Pdg.setVisibility(8);
        break label1035;
        this.Pdj.setText(this.fileName);
        break label1114;
        this.kbe.setText(getString(2131758365));
      }
    case 7: 
      label1035:
      label1114:
      if (this.Pdq) {
        this.Pdg.setVisibility(0);
      }
      for (;;)
      {
        label1176:
        label1190:
        alY(8);
        this.Pdh.setVisibility(8);
        this.thI.setVisibility(8);
        Log.d("MicroMsg.AppAttachDownloadUI", "hide moreOpenWaysArea");
        this.Pdy.setVisibility(4);
        this.Pdj.setVisibility(8);
        gMG();
        this.kbe.setText(getString(2131758365));
        break;
        this.Pdg.setVisibility(8);
      }
    }
    alY(8);
    this.Pdh.setVisibility(8);
    if (this.Pdq) {
      this.Pdg.setVisibility(0);
    }
    for (;;)
    {
      this.thI.setVisibility(8);
      Log.d("MicroMsg.AppAttachDownloadUI", "hide moreOpenWaysArea");
      this.Pdy.setVisibility(4);
      this.Pdj.setVisibility(8);
      gMG();
      break;
      this.Pdg.setVisibility(8);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(34148);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.tencent.mm.pluginsdk.ui.tools.a.a(this, paramInt1, paramInt2, paramIntent, this.Pdr, 2131758379, 2131758380, 1);
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
    paramContextMenu.add(0, 0, 0, getString(2131755772));
    AppMethodBeat.o(34144);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(34136);
    ao.cgO().remove(this);
    super.onDestroy();
    if (this.thY != null) {
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).d(this.thY);
    }
    AppMethodBeat.o(34136);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(34140);
    Log.i("MicroMsg.AppAttachDownloadUI", "onKeyDown keyCode %d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt == 4) && (this.KvS != null) && (this.KvS.O(2, false)))
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
    if (this.KvS != null) {
      this.KvS.aGj();
    }
    init();
    AppMethodBeat.o(34156);
  }
  
  public void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(34149);
    com.tencent.mm.pluginsdk.model.app.c localc = gMB();
    int i;
    StringBuilder localStringBuilder;
    if (localc != null)
    {
      long l1 = localc.field_totalLen;
      long l2 = localc.field_offset;
      this.LzM = l1;
      this.Pdi.setText(getString(2131758367, new Object[] { af.getSizeKB(l2), af.getSizeKB(l1) }));
      if (localc.field_totalLen == 0L) {
        i = 0;
      }
      for (;;)
      {
        Log.v("MicroMsg.AppAttachDownloadUI", "summerapp attach progress:" + i + " offset:" + l2 + " totallen:" + l1 + " status " + localc.field_status);
        this.Pdf.setProgress(i);
        if ((localc.field_status != 199L) || (i < 100) || (this.Pdp)) {
          break label507;
        }
        if (this.KvS != null)
        {
          paramString = this.KvS;
          l1 = this.LzM;
          if (paramString.nhp != null) {
            paramString.nhp.LzM = l1;
          }
        }
        try
        {
          paramString.Abp.field_data = paramString.nhp.toByteArray();
          this.Pdp = true;
          if (this.Pdx)
          {
            this.Pdx = false;
            gMy();
          }
          if (this.scene == 3)
          {
            paramString = new Intent();
            paramString.putExtra("filePath", this.filePath);
            paramString.putExtra("fileName", this.fileName);
            paramString.putExtra("fileExt", this.gCr);
            setResult(-1, paramString);
            finish();
            AppMethodBeat.o(34149);
            return;
            i = (int)(localc.field_offset * 100L / localc.field_totalLen);
          }
        }
        catch (IOException paramString)
        {
          for (;;)
          {
            Log.e("MicroMsg.FilesFloatBall.FilesPageMultiTaskHelper", "updateFileLen", new Object[] { paramString });
          }
        }
      }
      if (localc != null)
      {
        localStringBuilder = new StringBuilder().append(getString(2131758392)).append(" : ");
        paramMStorageEventData = localc.field_fileFullPath;
        paramString = paramMStorageEventData;
        if (paramMStorageEventData != null)
        {
          String str = com.tencent.mm.loader.j.b.aKE();
          paramMStorageEventData = s.k(paramMStorageEventData, true);
          int j = paramMStorageEventData.indexOf(str);
          paramString = paramMStorageEventData;
          if (j >= 0)
          {
            paramString = paramMStorageEventData.substring(str.length() + j);
            if (!paramString.startsWith("/")) {
              break label583;
            }
          }
        }
      }
    }
    label583:
    for (paramString = "/sdcard".concat(String.valueOf(paramString));; paramString = "/sdcard/".concat(String.valueOf(paramString)))
    {
      Toast.makeText(this, paramString, this.Pds).show();
      com.tencent.mm.pluginsdk.ui.tools.a.a(this, localc.field_fileFullPath, this.gCr, this.fileName, 1);
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(232802);
          AppAttachDownloadUI.Q(AppAttachDownloadUI.this);
          AppMethodBeat.o(232802);
        }
      }, 200L);
      label507:
      if ((this.Pdf.getVisibility() != 0) && (i < 100) && (!localc.field_isUpload) && (localc.field_status == 101L))
      {
        Log.i("MicroMsg.AppAttachDownloadUI", "summerapp still downloading updateProgress progress[%d]", new Object[] { Integer.valueOf(i) });
        alY(0);
        this.Pdg.setVisibility(8);
      }
      AppMethodBeat.o(34149);
      return;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(34138);
    bg.azz().b(221, this);
    bg.azz().b(728, this);
    super.onPause();
    if (this.KvS != null) {
      this.KvS.aGj();
    }
    pg localpg = new pg();
    localpg.dVo.pause = false;
    pg.a locala = localpg.dVo;
    if (this.dTX == null) {}
    for (String str = "";; str = this.dTX.field_talker)
    {
      locala.talker = str;
      EventCenter.instance.asyncPublish(localpg, getMainLooper());
      Log.d("MicroMsg.AppAttachDownloadUI", "AppAttachDownloadUI cancel pause auto download logic");
      AppMethodBeat.o(34138);
      return;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(34137);
    super.onResume();
    bg.azz().a(221, this);
    bg.azz().a(728, this);
    pg localpg = new pg();
    localpg.dVo.pause = true;
    localpg.dVo.talker = this.dTX.field_talker;
    EventCenter.instance.asyncPublish(localpg, getMainLooper());
    Log.d("MicroMsg.AppAttachDownloadUI", "AppAttachDownloadUI req pause auto download logic");
    this.thI.setEnabled(true);
    if (this.KvS != null) {
      this.KvS.bCA();
    }
    AppMethodBeat.o(34137);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
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
      paramString = gMB();
      if (paramString == null)
      {
        Log.i("MicroMsg.AppAttachDownloadUI", "summerapp onSceneEnd getAppAttachInfo is null");
        if (paramString != null)
        {
          paramString.field_status = 101L;
          paramString.field_lastModifyTime = Util.nowSecond();
          ao.cgO().a(paramString, new String[0]);
        }
        this.BGq = new com.tencent.mm.plugin.record.b.f(this.msgId, this.mediaId, this.Pdl);
        bg.azz().a(this.BGq, 0);
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
    if ((this.BGq == null) && ((paramq instanceof com.tencent.mm.plugin.record.b.f)))
    {
      paramString = (com.tencent.mm.plugin.record.b.f)paramq;
      com.tencent.mm.pluginsdk.model.app.c localc = gMB();
      if ((localc != null) && (!af.isNullOrNil(localc.field_mediaSvrId)) && (localc.field_mediaSvrId.equals(paramString.getMediaId())))
      {
        this.BGq = paramString;
        Log.i("MicroMsg.AppAttachDownloadUI", "summerapp onSceneEnd reset downloadAppAttachScene[%s] by mediaSvrId[%s]", new Object[] { this.BGq, localc.field_mediaSvrId });
      }
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (this.Pdn.type == 6)
      {
        fP(0, 2);
        paramString = gMB();
        if (paramString != null) {
          com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1203L, 5L, paramString.field_totalLen, false);
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
      gMF();
      alY(8);
      fP(1, 3);
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
    alY(8);
    this.Pdg.setVisibility(0);
    this.Pdh.setVisibility(8);
    Log.e("MicroMsg.AppAttachDownloadUI", "summerapp onSceneEnd, download fail, type = " + paramq.getType() + " errType = " + paramInt1 + ", errCode = " + paramInt2);
    AppMethodBeat.o(34154);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
  {
    private boolean BIo;
    Button ubX;
    private TextView vr;
    
    public a(Button paramButton, TextView paramTextView)
    {
      AppMethodBeat.i(34126);
      this.ubX = paramButton;
      this.vr = paramTextView;
      if (paramTextView != null)
      {
        int i = com.tencent.mm.n.h.aqJ().getInt("MsgFileExpiredInterval", 432000);
        long l = AppAttachDownloadUI.R(AppAttachDownloadUI.this).field_createTime / 1000L;
        Math.floor((i - cl.secondsToNow(l)) * 1.0D / 86400.0D);
        paramTextView.setText("");
      }
      AppMethodBeat.o(34126);
    }
    
    public final void gMH()
    {
      AppMethodBeat.i(34128);
      Log.i("MicroMsg.AppAttachDownloadUI", "showErrorTip overtime %s", new Object[] { Long.valueOf(AppAttachDownloadUI.R(AppAttachDownloadUI.this).field_msgId) });
      if (this.ubX != null) {
        this.ubX.setVisibility(4);
      }
      if (this.vr != null)
      {
        this.vr.setVisibility(0);
        this.vr.setText(2131759394);
        this.vr.setTextColor(AppAttachDownloadUI.this.getResources().getColor(2131099820));
        AppAttachDownloadUI.S(AppAttachDownloadUI.this).setVisibility(8);
        AppAttachDownloadUI.D(AppAttachDownloadUI.this).setVisibility(8);
        if (!this.BIo)
        {
          this.BIo = true;
          AppAttachDownloadUI.T(AppAttachDownloadUI.this);
        }
      }
      AppMethodBeat.o(34128);
    }
    
    public final void setVisibility(int paramInt)
    {
      AppMethodBeat.i(34127);
      if (this.ubX != null) {
        this.ubX.setVisibility(paramInt);
      }
      if (this.vr != null) {
        this.vr.setVisibility(paramInt);
      }
      AppMethodBeat.o(34127);
    }
  }
  
  static final class b
    implements com.tencent.mm.plugin.appbrand.openmaterial.i
  {
    private final WeakReference<AppAttachDownloadUI> Kwe;
    private final com.tencent.mm.plugin.appbrand.service.i Kwf;
    private final MaterialModel nlD;
    
    public b(AppAttachDownloadUI paramAppAttachDownloadUI, MaterialModel paramMaterialModel, com.tencent.mm.plugin.appbrand.service.i parami)
    {
      AppMethodBeat.i(232811);
      this.Kwe = new WeakReference(paramAppAttachDownloadUI);
      this.nlD = paramMaterialModel;
      this.Kwf = parami;
      AppMethodBeat.o(232811);
    }
    
    public final void a(boolean paramBoolean, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection)
    {
      AppMethodBeat.i(232812);
      Log.d("MicroMsg.AppAttachDownloadUI", "loadOpenMaterials#onMyOpenMaterialsGot");
      AppAttachDownloadUI localAppAttachDownloadUI = (AppAttachDownloadUI)this.Kwe.get();
      if (localAppAttachDownloadUI == null)
      {
        Log.i("MicroMsg.AppAttachDownloadUI", "loadOpenMaterials#onMyOpenMaterialsGot, ui is null");
        AppMethodBeat.o(232812);
        return;
      }
      if (!paramBoolean)
      {
        Log.i("MicroMsg.AppAttachDownloadUI", "loadOpenMaterials#onMyOpenMaterialsGot, fail");
        AppMethodBeat.o(232812);
        return;
      }
      AppAttachDownloadUI.a(localAppAttachDownloadUI, this.nlD.nlI);
      AppAttachDownloadUI.a(localAppAttachDownloadUI, paramAppBrandOpenMaterialCollection);
      if ((AppAttachDownloadUI.d(localAppAttachDownloadUI)) && (!paramAppBrandOpenMaterialCollection.nlF.isEmpty())) {}
      for (int i = 1; i == 0; i = 0)
      {
        Log.i("MicroMsg.AppAttachDownloadUI", "loadOpenMaterials#onMyOpenMaterialsGot, not need enhance");
        AppMethodBeat.o(232812);
        return;
      }
      if (AppAttachDownloadUI.a(localAppAttachDownloadUI) != null) {
        AppAttachDownloadUI.a(localAppAttachDownloadUI).dead();
      }
      AppAttachDownloadUI.a(localAppAttachDownloadUI, this.Kwf.bQa().b(com.tencent.mm.plugin.appbrand.openmaterial.model.b.nlP).a(localAppAttachDownloadUI, AppAttachDownloadUI.w(localAppAttachDownloadUI), AppAttachDownloadUI.x(localAppAttachDownloadUI)));
      if (AppAttachDownloadUI.w(localAppAttachDownloadUI) != null)
      {
        if (AppAttachDownloadUI.y(localAppAttachDownloadUI) != null) {
          AppAttachDownloadUI.y(localAppAttachDownloadUI).dead();
        }
        AppAttachDownloadUI.a(localAppAttachDownloadUI, this.Kwf.a(com.tencent.mm.plugin.appbrand.openmaterial.model.b.nlP, localAppAttachDownloadUI, AppAttachDownloadUI.w(localAppAttachDownloadUI), AppAttachDownloadUI.x(localAppAttachDownloadUI), AppAttachDownloadUI.a(localAppAttachDownloadUI), null));
      }
      Log.d("MicroMsg.AppAttachDownloadUI", "show moreOpenWaysArea");
      AppAttachDownloadUI.z(localAppAttachDownloadUI).setVisibility(0);
      AppMethodBeat.o(232812);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppAttachDownloadUI
 * JD-Core Version:    0.7.0.1
 */