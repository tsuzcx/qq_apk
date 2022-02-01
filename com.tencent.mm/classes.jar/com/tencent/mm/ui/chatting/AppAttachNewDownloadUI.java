package com.tencent.mm.ui.chatting;

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
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.msgquote.model.MsgQuoteItem;
import com.tencent.mm.plugin.record.model.g.b;
import com.tencent.mm.plugin.secdata.ui.MMSecDataActivity;
import com.tencent.mm.pluginsdk.model.app.as;
import com.tencent.mm.pluginsdk.model.app.d;
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
import java.util.ArrayList;
import java.util.Iterator;

public class AppAttachNewDownloadUI
  extends MMSecDataActivity
  implements com.tencent.mm.am.h, i.a, g.b, MStorage.IOnStorageChange
{
  private Button AkB;
  private Button AkC;
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
  private TextView aedL;
  private TextView aedM;
  private com.tencent.mm.am.i aedN;
  private boolean aedO;
  private k.b aedP;
  private String aedQ;
  private boolean aedR;
  private boolean aedS;
  private boolean aedT;
  private boolean aedV;
  private int aedW;
  private LinearLayout aedX;
  private boolean aedZ;
  private com.tencent.mm.ui.chatting.multitask.b aeea;
  private LinearLayout aeeb;
  private ImageView aeec;
  private a aeet;
  private TextView aeeu;
  private ProgressBar aeev;
  private TextView aeew;
  private com.tencent.mm.ui.chatting.floatball.a aeex;
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
  private int scene;
  private com.tencent.mm.ui.widget.b.a vEV;
  private com.tencent.mm.ui.widget.a.f vlk;
  private String vyS;
  private int wQW;
  private int x_down;
  private u.i yBn;
  private int y_down;
  
  public AppAttachNewDownloadUI()
  {
    AppMethodBeat.i(253750);
    this.wQW = 0;
    this.aedR = false;
    this.aedS = false;
    this.aedT = true;
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
        AppMethodBeat.i(253669);
        if (AppAttachNewDownloadUI.S(AppAttachNewDownloadUI.this).equals("")) {}
        for (paramAnonymousMenuItem = AppAttachNewDownloadUI.this.getString(R.l.openapi_app_file);; paramAnonymousMenuItem = AppAttachNewDownloadUI.S(AppAttachNewDownloadUI.this))
        {
          ClipboardHelper.setText(MMApplicationContext.getContext(), null, paramAnonymousMenuItem);
          k.cZ(AppAttachNewDownloadUI.this, AppAttachNewDownloadUI.this.getString(R.l.app_copy_ok));
          AppMethodBeat.o(253669);
          return;
        }
      }
    };
    this.AkU = new AppAttachNewDownloadUI.7(this);
    this.AkV = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(253677);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/AppAttachNewDownloadUI$16", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
        Log.d("MicroMsg.AppAttachNewDownloadUI", "onLongClick");
        if (AppAttachNewDownloadUI.T(AppAttachNewDownloadUI.this) == null) {
          AppAttachNewDownloadUI.a(AppAttachNewDownloadUI.this, new com.tencent.mm.ui.widget.b.a(AppAttachNewDownloadUI.this.dSs()));
        }
        AppAttachNewDownloadUI.T(AppAttachNewDownloadUI.this).a(paramAnonymousView, AppAttachNewDownloadUI.this, AppAttachNewDownloadUI.U(AppAttachNewDownloadUI.this), AppAttachNewDownloadUI.V(AppAttachNewDownloadUI.this), AppAttachNewDownloadUI.W(AppAttachNewDownloadUI.this));
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/chatting/AppAttachNewDownloadUI$16", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(253677);
        return true;
      }
    };
    AppMethodBeat.o(253750);
  }
  
  private void LQ(boolean paramBoolean)
  {
    AppMethodBeat.i(253800);
    com.tencent.mm.pluginsdk.model.app.c localc;
    if ((this.appType == 74) || (this.appType == 6))
    {
      Log.i("MicroMsg.AppAttachNewDownloadUI", "showFileReceiveStateView appType:%s isFileSender:%s fileStatus:%s startDownload:%s isDownloadStarted:%s isDownloadFinished:%s", new Object[] { Integer.valueOf(this.appType), Integer.valueOf(this.hTm.kLw), Integer.valueOf(this.hTm.fileStatus), Boolean.valueOf(paramBoolean), Boolean.valueOf(this.aedS), Boolean.valueOf(this.aedR) });
      if ((this.appType == 74) && (!this.aedR)) {}
      switch (this.hTm.fileStatus)
      {
      default: 
        if ((this.appType == 6) || (this.aedR))
        {
          localc = joj();
          if ((this.hTm.kLw != 1) || (localc == null) || (((int)localc.field_status != 102) && ((int)localc.field_status != 198) && ((int)localc.field_status != 101))) {
            break label777;
          }
          Log.i("MicroMsg.AppAttachNewDownloadUI", "showFileReceiveStateView appAttachInfo is %s", new Object[] { Long.valueOf(localc.field_status) });
          if ((int)localc.field_status != 102) {
            break label534;
          }
          this.aeet.setVisibility(0);
          this.AkC.setVisibility(8);
          this.aeeu.setVisibility(8);
          this.aeev.setVisibility(8);
          this.aeew.setVisibility(8);
          this.AkB.setVisibility(8);
          aBA(8);
        }
        break;
      }
    }
    label777:
    for (;;)
    {
      jor();
      AppMethodBeat.o(253800);
      return;
      this.aeet.setVisibility(8);
      this.AkC.setVisibility(0);
      this.aeeu.setVisibility(8);
      this.aeev.setVisibility(8);
      this.aeew.setVisibility(8);
      this.AkB.setVisibility(8);
      aBA(8);
      break;
      this.aeet.setVisibility(8);
      this.AkC.setVisibility(8);
      this.aeeu.setVisibility(0);
      if (this.hTm.field_isSend == 1) {
        this.aeeu.setText(R.l.gHQ);
      }
      for (;;)
      {
        this.aeev.setVisibility(0);
        this.aeew.setVisibility(0);
        this.AkB.setVisibility(8);
        aBA(8);
        break;
        this.aeeu.setText(R.l.gHP);
      }
      this.aeet.LR(true);
      this.AkC.setVisibility(8);
      this.aeeu.setVisibility(8);
      this.aeev.setVisibility(8);
      this.aeew.setVisibility(8);
      this.AkB.setVisibility(8);
      aBA(8);
      break;
      label534:
      if ((int)localc.field_status == 198)
      {
        switch (this.hTm.fileStatus)
        {
        default: 
          this.aeet.LR(false);
          this.AkC.setVisibility(8);
          this.aeeu.setVisibility(8);
          this.aeev.setVisibility(8);
          this.aeew.setVisibility(8);
          this.AkB.setVisibility(8);
          aBA(8);
          break;
        case 3: 
          this.aeet.setVisibility(0);
          this.AkC.setVisibility(8);
          this.aeeu.setVisibility(8);
          this.aeev.setVisibility(8);
          this.aeew.setVisibility(8);
          this.AkB.setVisibility(8);
          aBA(8);
          break;
        }
      }
      else if ((int)localc.field_status == 101)
      {
        this.aeet.setVisibility(8);
        this.AkC.setVisibility(8);
        this.aeev.setVisibility(8);
        this.aeeu.setVisibility(0);
        this.aeeu.setText(R.l.gHK);
        this.aeew.setVisibility(8);
        this.AkB.setVisibility(8);
        aBA(0);
        continue;
        if (!paramBoolean) {
          break label852;
        }
        this.aeet.setVisibility(8);
        this.AkC.setVisibility(8);
        this.aeev.setVisibility(8);
        this.aeeu.setVisibility(0);
        this.aeeu.setText(R.l.gHK);
        this.aeew.setVisibility(8);
        this.AkB.setVisibility(8);
        aBA(0);
      }
    }
    label852:
    if (this.aedR)
    {
      this.aeet.setVisibility(8);
      this.AkC.setVisibility(8);
      this.aeev.setVisibility(8);
      this.aeeu.setVisibility(8);
      this.aeew.setVisibility(8);
      if (getMimeType().equals("")) {
        this.AkB.setVisibility(8);
      }
      for (;;)
      {
        aBA(8);
        break;
        this.AkB.setVisibility(0);
      }
    }
    if (this.aedS)
    {
      this.aeet.setVisibility(8);
      this.AkC.setVisibility(8);
      aBA(0);
      this.aeeu.setVisibility(0);
      this.aeeu.setText(R.l.gHK);
      duV();
    }
    for (;;)
    {
      this.aeev.setVisibility(8);
      this.aeew.setVisibility(8);
      this.AkB.setVisibility(8);
      break;
      this.aeet.setVisibility(8);
      this.AkC.setVisibility(0);
      aBA(8);
      this.aeeu.setVisibility(8);
    }
  }
  
  public static com.tencent.mm.pluginsdk.model.app.c a(int paramInt, long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(253826);
    com.tencent.mm.pluginsdk.model.app.c localc = as.cWJ().yi(paramLong);
    if (localc != null)
    {
      Log.i("MicroMsg.AppAttachNewDownloadUI", "summerapp getAppAttachInfo by msgId [%d] stack[%s]", new Object[] { Long.valueOf(paramLong), ab.bTQ() });
      AppMethodBeat.o(253826);
      return localc;
    }
    if (paramInt == 74)
    {
      AppMethodBeat.o(253826);
      return null;
    }
    paramString1 = com.tencent.mm.pluginsdk.model.app.n.bpU(paramString1);
    if (paramString1 == null)
    {
      Log.i("MicroMsg.AppAttachNewDownloadUI", "summerapp getAppAttachInfo by msgId and mediaId is null stack[%s]", new Object[] { ab.bTQ() });
      AppMethodBeat.o(253826);
      return paramString1;
    }
    if ((paramString1.field_msgInfoId == paramLong) || (y.ZC(paramString1.field_fileFullPath)))
    {
      AppMethodBeat.o(253826);
      return paramString1;
    }
    com.tencent.mm.pluginsdk.model.app.n.ab(paramLong, paramString2);
    paramString2 = as.cWJ().yi(paramLong);
    if (paramString2 == null)
    {
      Log.w("MicroMsg.AppAttachNewDownloadUI", "summerapp getAppAttachInfo create new info from local but failed stack[%s]", new Object[] { ab.bTQ() });
      AppMethodBeat.o(253826);
      return paramString1;
    }
    com.tencent.threadpool.h.ahAA.g(new AppAttachNewDownloadUI.10(paramString1, paramString2), "copyAttachFromLocal");
    AppMethodBeat.o(253826);
    return paramString1;
  }
  
  private void aBA(int paramInt)
  {
    AppMethodBeat.i(253855);
    if (paramInt != this.aedH.getVisibility())
    {
      Log.i("MicroMsg.AppAttachNewDownloadUI", "setRoundProgressBar %s %s", new Object[] { Integer.valueOf(paramInt), ab.bTQ() });
      this.aedH.setVisibility(paramInt);
      if (paramInt == 0) {
        duV();
      }
    }
    AppMethodBeat.o(253855);
  }
  
  private static boolean b(com.tencent.mm.pluginsdk.model.app.c paramc)
  {
    AppMethodBeat.i(253853);
    if (paramc == null)
    {
      AppMethodBeat.o(253853);
      return false;
    }
    u localu = new u(paramc.field_fileFullPath);
    if ((localu.jKS()) && (localu.length() == paramc.field_totalLen))
    {
      AppMethodBeat.o(253853);
      return true;
    }
    AppMethodBeat.o(253853);
    return false;
  }
  
  private String bAv(String paramString)
  {
    AppMethodBeat.i(253794);
    String str = paramString;
    if (this.aedO)
    {
      str = paramString;
      if (paramString != null) {
        str = br.JK(paramString);
      }
    }
    AppMethodBeat.o(253794);
    return str;
  }
  
  private static String bAw(String paramString)
  {
    AppMethodBeat.i(253831);
    if (paramString == null)
    {
      AppMethodBeat.o(253831);
      return paramString;
    }
    String str = com.tencent.mm.loader.i.b.bmu();
    paramString = y.n(paramString, true);
    int i = paramString.indexOf(str);
    if (i >= 0)
    {
      paramString = paramString.substring(str.length() + i);
      if (paramString.startsWith("/"))
      {
        paramString = "/sdcard".concat(String.valueOf(paramString));
        AppMethodBeat.o(253831);
        return paramString;
      }
      paramString = "/sdcard/".concat(String.valueOf(paramString));
      AppMethodBeat.o(253831);
      return paramString;
    }
    AppMethodBeat.o(253831);
    return paramString;
  }
  
  private void ccH()
  {
    AppMethodBeat.i(253763);
    this.aeex = new com.tencent.mm.ui.chatting.floatball.a(new com.tencent.mm.plugin.ball.a.e((MMActivity)super.getContext()));
    this.aeex.d(this.filePath, this.lPJ, this.wQW, true);
    this.aeex.qa(this.lPJ, this.fileName);
    AppMethodBeat.o(253763);
  }
  
  private boolean dLc()
  {
    AppMethodBeat.i(253779);
    this.scene = getIntent().getIntExtra("scene", 0);
    this.msgId = getIntent().getLongExtra("app_msg_id", -1L);
    this.aedV = getIntent().getBooleanExtra("choose_way", false);
    this.aedW = getIntent().getIntExtra("msg_type", 0);
    if (this.msgId == -1L)
    {
      AppMethodBeat.o(253779);
      return false;
    }
    this.hTH = getIntent().getBooleanExtra("app_show_share", true);
    bh.bCz();
    this.hTm = com.tencent.mm.model.c.bzD().sl(this.msgId);
    Object localObject1;
    if ((this.hTm == null) || (this.hTm.field_msgId == 0L) || (this.hTm.field_content == null))
    {
      if (!joe()) {
        break label381;
      }
      localObject1 = (MsgQuoteItem)getIntent().getParcelableExtra("key_quoted_msg");
      if (localObject1 == null)
      {
        AppMethodBeat.o(253779);
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
    if ((this.aedO) && (this.hTm.field_isSend == 0)) {
      this.hWn = bAv(this.hTm.field_content);
    }
    this.aedP = k.b.Hf(this.hWn);
    if (this.aedP == null)
    {
      Log.e("MicroMsg.AppAttachNewDownloadUI", "summerapp parse msgContent error, %s", new Object[] { this.hWn });
      AppMethodBeat.o(253779);
      return false;
      label381:
      AppMethodBeat.o(253779);
      return false;
    }
    if ((ab.isNullOrNil(this.aedP.hzM)) && (!ab.isNullOrNil(this.aedP.nRq)))
    {
      Log.e("MicroMsg.AppAttachNewDownloadUI", "summerapp msgContent format error, %s", new Object[] { this.hWn });
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
    Log.i("MicroMsg.AppAttachNewDownloadUI", "summerapp initParams msgId[%d], sender[%d], msgContent[%s], appType[%d], mediaId[%s], fileName[%s]", new Object[] { Long.valueOf(this.msgId), Integer.valueOf(this.hTm.field_isSend), this.hWn, Integer.valueOf(this.appType), this.mediaId, this.fileName });
    com.tencent.mm.pluginsdk.model.app.c localc = joj();
    if (localc == null)
    {
      Log.i("MicroMsg.AppAttachNewDownloadUI", "summerapp initParams attInfo is null");
      this.aedS = false;
    }
    for (;;)
    {
      if (this.aedP.type == 6) {
        ((com.tencent.mm.plugin.comm.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.comm.a.c.class)).ae(String.valueOf(this.hTm.field_msgId), this.hTm.field_msgSvrId);
      }
      hf(4, 0);
      String str1 = ab.nullAsNil(z.bAM());
      Object localObject2 = ab.nullAsNil(this.hTm.field_talker);
      localObject1 = localObject2;
      if (au.bwE((String)localObject2)) {
        localObject1 = ab.nullAsNil(this.aedP.hQQ);
      }
      label833:
      label844:
      boolean bool;
      label904:
      int i;
      if (this.hTm.field_isSend == 1)
      {
        localObject2 = str1;
        if (this.hTm.field_isSend != 1) {
          break label1261;
        }
        String str2 = ab.nullAsNil(this.filePath);
        String str3 = this.lPJ;
        String str4 = this.fileName;
        String str5 = this.vyS;
        long l = this.Ysz;
        String str6 = Long.toString(this.hTm.field_msgSvrId);
        if (ab.isNullOrNil(this.cdnURL)) {
          break label1268;
        }
        str1 = this.cdnURL;
        this.AkR = new HandOffFile(str2, str3, str4, str5, l, 1, str6, "", str1, this.aesKey, this.authKey, 1, "", 0, "", 0L, 1, (String)localObject2, (String)localObject1);
        bool = b(joj());
        localObject1 = this.AkR;
        if (!bool) {
          break label1277;
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
        if ((localc == null) || (!new u(localc.field_fileFullPath).jKS()))
        {
          bool = false;
          this.aedR = bool;
          if (!b(localc)) {
            break label1511;
          }
          if (this.scene != 3) {
            break label1340;
          }
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("filePath", this.filePath);
          ((Intent)localObject1).putExtra("fileName", this.fileName);
          ((Intent)localObject1).putExtra("fileExt", this.lPJ);
          setResult(-1, (Intent)localObject1);
          finish();
          AppMethodBeat.o(253779);
          return true;
          this.filePath = localc.field_fileFullPath;
          if (localc.field_offset > 0L) {}
          for (this.aedS = true;; this.aedS = false)
          {
            Log.i("MicroMsg.AppAttachNewDownloadUI", "summerapp initParams attInfo field_fileFullPath[%s], field_offset[%d], isDownloadStarted[%b], status[%s]", new Object[] { localc.field_fileFullPath, Long.valueOf(localc.field_offset), Boolean.valueOf(this.aedS), Long.valueOf(localc.field_status) });
            break;
          }
          localObject2 = localObject1;
          break label833;
          label1261:
          localObject1 = str1;
          break label844;
          label1268:
          str1 = this.aedQ;
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
          if ((localc.efT()) || ((this.hTm.field_isSend == 1) && (localc.field_isUpload))) {
            bool = true;
          } else {
            bool = false;
          }
        }
        label1340:
        if (this.scene == 1)
        {
          this.wQW = 7;
          if (this.aedV)
          {
            bool = com.tencent.mm.pluginsdk.ui.tools.a.c(this, localc.field_fileFullPath, this.lPJ, this.wQW);
            AppMethodBeat.o(253779);
            return bool;
          }
          bool = com.tencent.mm.pluginsdk.ui.tools.a.a(localc.field_fileFullPath, this.lPJ, this.wQW, (aet)localObject1);
          AppMethodBeat.o(253779);
          return bool;
        }
        if (this.wQW != 9) {
          this.wQW = 1;
        }
        if (this.aedV)
        {
          bool = com.tencent.mm.pluginsdk.ui.tools.a.c(this, localc.field_fileFullPath, this.lPJ, this.wQW);
          AppMethodBeat.o(253779);
          return bool;
        }
        if (!com.tencent.mm.pluginsdk.ui.tools.a.pq(localc.field_fileFullPath, this.lPJ))
        {
          bool = com.tencent.mm.pluginsdk.ui.tools.a.a(localc.field_fileFullPath, this.lPJ, this.wQW, (aet)localObject1);
          AppMethodBeat.o(253779);
          return bool;
        }
        label1511:
        AppMethodBeat.o(253779);
      }
    }
    return true;
  }
  
  private void duV()
  {
    AppMethodBeat.i(253836);
    Object localObject = joj();
    if (localObject == null)
    {
      AppMethodBeat.o(253836);
      return;
    }
    long l1 = ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_totalLen;
    long l2 = ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_offset;
    this.Ysz = l1;
    if (((com.tencent.mm.pluginsdk.model.app.c)localObject).field_totalLen == 0L) {}
    for (int i = 0;; i = (int)(((com.tencent.mm.pluginsdk.model.app.c)localObject).field_offset * 100L / ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_totalLen))
    {
      Log.v("MicroMsg.AppAttachNewDownloadUI", "summerapp attach progress:" + i + " offset:" + l2 + " totallen:" + l1 + " status " + ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_status);
      this.aedH.setProgress(i);
      if ((((com.tencent.mm.pluginsdk.model.app.c)localObject).field_status != 199L) || (i < 100) || (this.aedR)) {
        break label361;
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
      localObject = new Intent();
      ((Intent)localObject).putExtra("filePath", this.filePath);
      ((Intent)localObject).putExtra("fileName", this.fileName);
      ((Intent)localObject).putExtra("fileExt", this.lPJ);
      setResult(-1, (Intent)localObject);
      finish();
      AppMethodBeat.o(253836);
      return;
    }
    if (localObject != null)
    {
      Toast.makeText(this, getString(R.l.download_success) + " : " + bAw(((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath), 5000).show();
      com.tencent.mm.pluginsdk.ui.tools.a.a(this, ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath, this.lPJ, this.fileName, 1);
    }
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(253797);
        AppAttachNewDownloadUI.Z(AppAttachNewDownloadUI.this);
        AppMethodBeat.o(253797);
      }
    }, 200L);
    label361:
    if ((this.aedH.getVisibility() != 0) && (i < 100) && (!((com.tencent.mm.pluginsdk.model.app.c)localObject).field_isUpload) && (((com.tencent.mm.pluginsdk.model.app.c)localObject).field_status == 101L))
    {
      Log.i("MicroMsg.AppAttachNewDownloadUI", "summerapp still downloading updateProgress progress[%d]", new Object[] { Integer.valueOf(i) });
      LQ(false);
    }
    AppMethodBeat.o(253836);
  }
  
  private void fkW()
  {
    AppMethodBeat.i(253850);
    Log.i("MicroMsg.AppAttachNewDownloadUI", "[ImageGalleryUI] showImage");
    Object localObject = new Intent(this, ImageGalleryUI.class);
    ((Intent)localObject).putExtra("img_gallery_msg_id", this.hTm.field_msgId);
    ((Intent)localObject).putExtra("img_gallery_talker", this.hTm.field_talker);
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/chatting/AppAttachNewDownloadUI", "showImage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/chatting/AppAttachNewDownloadUI", "showImage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    overridePendingTransition(0, 0);
    AppMethodBeat.o(253850);
  }
  
  private String getMimeType()
  {
    AppMethodBeat.i(253820);
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
      Log.w("MicroMsg.AppAttachNewDownloadUI", "getMimeType fail, not a built-in mimetype, use \"*/{fileext}\" instead");
      localObject2 = "*/" + localb.nRe;
    }
    AppMethodBeat.o(253820);
    return localObject2;
  }
  
  private void hf(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(253862);
    long l;
    Object localObject;
    if ((6 == this.appType) || (74 == this.appType))
    {
      if (paramInt2 != -1) {
        com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1203L, paramInt2, 1L, false);
      }
      l = this.hTm.field_msgSvrId;
      if (this.aedP == null) {
        break label295;
      }
      localObject = (com.tencent.mm.message.a.b)this.aedP.aK(com.tencent.mm.message.a.b.class);
      if ((localObject == null) || (((com.tencent.mm.message.a.b)localObject).nVD == 0L)) {
        break label295;
      }
      l = ((com.tencent.mm.message.a.b)localObject).nVD;
    }
    label295:
    for (;;)
    {
      localObject = this.aedP.nRq;
      if (this.aedP.nRh == 1) {}
      for (paramInt2 = 7;; paramInt2 = 5)
      {
        localObject = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { localObject, Integer.valueOf(paramInt2), Integer.valueOf(this.aedP.nRd), Integer.valueOf(paramInt1), Long.valueOf((cn.bDv() - this.hTm.getCreateTime()) / 1000L), this.lPJ, this.hTm.field_talker, Integer.valueOf(1), "", Long.valueOf(l), Long.valueOf(this.hTm.getCreateTime()), Long.valueOf(cn.bDu()), Integer.valueOf(1) });
        Log.i("MicroMsg.AppAttachNewDownloadUI", "reportKVStat 14665 %s", new Object[] { localObject });
        com.tencent.mm.plugin.report.service.h.OAn.kvStat(14665, (String)localObject);
        AppMethodBeat.o(253862);
        return;
      }
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(253753);
    setMMTitle("");
    setActionbarColor(getResources().getColor(R.e.white));
    hideActionbarLine();
    if (!dLc())
    {
      finish();
      AppMethodBeat.o(253753);
      return;
    }
    joq();
    u localu = new u(com.tencent.mm.loader.i.b.bmC());
    if (!localu.jKS()) {
      localu.jKY();
    }
    as.cWJ().add(this);
    ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().a(this, Looper.getMainLooper());
    initView();
    jod();
    ccH();
    AppMethodBeat.o(253753);
  }
  
  private void jod()
  {
    AppMethodBeat.i(253759);
    this.aeea = new com.tencent.mm.ui.chatting.multitask.b(new com.tencent.mm.plugin.multitask.a.b((MMActivity)super.getContext()));
    this.aeea.d(this.filePath, this.lPJ, this.wQW, true);
    this.aeea.qa(this.lPJ, this.fileName);
    this.AkR.saveToMultiTaskInfo(this.aeea.LCE);
    AppMethodBeat.o(253759);
  }
  
  private boolean joe()
  {
    return this.aedW == 1;
  }
  
  private void jof()
  {
    AppMethodBeat.i(253786);
    Log.d("MicroMsg.AppAttachNewDownloadUI", "loadOpenMaterials");
    if (ab.isNullOrNil(this.filePath))
    {
      Log.w("MicroMsg.AppAttachNewDownloadUI", "loadOpenMaterials, filePath is empty");
      AppMethodBeat.o(253786);
      return;
    }
    if ((this.filePath.equals(this.Ytx)) && (this.WVz != null))
    {
      Log.i("MicroMsg.AppAttachNewDownloadUI", "loadOpenMaterials, already load");
      AppMethodBeat.o(253786);
      return;
    }
    MaterialModel localMaterialModel = MaterialModel.fh(this.filePath, this.lPJ);
    if (localMaterialModel == null)
    {
      Log.w("MicroMsg.AppAttachNewDownloadUI", "loadOpenMaterials, materialModel is null");
      AppMethodBeat.o(253786);
      return;
    }
    com.tencent.mm.plugin.appbrand.service.j localj = (com.tencent.mm.plugin.appbrand.service.j)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.j.class);
    if (localj == null)
    {
      Log.w("MicroMsg.AppAttachNewDownloadUI", "loadOpenMaterials, openMaterialService is null");
      AppMethodBeat.o(253786);
      return;
    }
    if (!localj.c(com.tencent.mm.plugin.appbrand.openmaterial.model.b.trZ))
    {
      Log.i("MicroMsg.AppAttachNewDownloadUI", "loadOpenMaterials, openMaterialService is not enabled");
      AppMethodBeat.o(253786);
      return;
    }
    if (!localj.aen(localMaterialModel.mimeType))
    {
      Log.i("MicroMsg.AppAttachNewDownloadUI", "loadOpenMaterials, openMaterialService is not support " + localMaterialModel.mimeType);
      AppMethodBeat.o(253786);
      return;
    }
    localj.a(localMaterialModel, new b(this, localMaterialModel, localj));
    AppMethodBeat.o(253786);
  }
  
  private void jog()
  {
    AppMethodBeat.i(253791);
    dn localdn = new dn();
    l.d(localdn, this.hTm);
    localdn.hDr.activity = this;
    localdn.hDr.hDy = 39;
    localdn.publish();
    AppMethodBeat.o(253791);
  }
  
  private void joh()
  {
    AppMethodBeat.i(253807);
    LQ(true);
    if (joi())
    {
      Log.i("MicroMsg.AppAttachNewDownloadUI", "startToDownloadFile");
      if (this.NzY != null) {
        bh.aZW().a(this.NzY);
      }
      this.NzY = new com.tencent.mm.plugin.record.model.g(this.msgId, this.mediaId, this.aedN);
      bh.aZW().a(this.NzY, 0);
      ac.am(this.hTm);
      hf(7, 1);
    }
    AppMethodBeat.o(253807);
  }
  
  private boolean joi()
  {
    int i = -1;
    boolean bool2 = true;
    AppMethodBeat.i(253814);
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
      com.tencent.mm.pluginsdk.model.app.n.ab(this.msgId, this.hWn);
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
          break label321;
        }
        Log.i("MicroMsg.AppAttachNewDownloadUI", "summerapp tryInitAttachInfo newInfo systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], signature len[%d]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), localObject1, Long.valueOf(l3), str1, Long.valueOf(l4), Boolean.valueOf(bool1), Integer.valueOf(i) });
        if (this.aedP.nRh == 0)
        {
          localObject1 = localObject2;
          bool1 = bool2;
          if (this.aedP.nRd <= 26214400) {}
        }
        else
        {
          if (ab.isNullOrNil(((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_signature)) {
            break label333;
          }
          bool1 = true;
          label219:
          localObject1 = localObject2;
        }
      }
      if (this.aedP == null) {
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
        bh.aZW().a(new com.tencent.mm.plugin.record.model.e((com.tencent.mm.pluginsdk.model.app.c)localObject1, this.aesKey, this.vyS, this.fileName, this.lPJ, this.hQQ), 0);
      }
      if (localObject1 != null)
      {
        this.filePath = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath;
        jod();
      }
      AppMethodBeat.o(253814);
      return bool1;
      i = ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_signature.length();
      break;
      bool1 = false;
      break label219;
      localObject2 = new u(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath);
      if ((((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_status == 199L) && (!((u)localObject2).jKS()))
      {
        Log.i("MicroMsg.AppAttachNewDownloadUI", "summerapp tryInitAttachInfo info exist but file not!");
        com.tencent.mm.pluginsdk.model.app.n.ab(this.msgId, this.hWn);
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
        Log.i("MicroMsg.AppAttachNewDownloadUI", "summerapp tryInitAttachInfo info exist systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], file.exists[%b], status[%d], signature len[%d]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), str1, Long.valueOf(l3), str2, Long.valueOf(l4), Boolean.valueOf(bool1), Boolean.valueOf(bool3), Long.valueOf(l5), Integer.valueOf(i) });
        bool1 = bool2;
        break;
        i = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_signature.length();
      }
      if ((this.aedP.nRh != 0) || (this.aedP.nRd > 26214400)) {
        bool1 = false;
      }
    }
  }
  
  private com.tencent.mm.pluginsdk.model.app.c joj()
  {
    AppMethodBeat.i(253823);
    com.tencent.mm.pluginsdk.model.app.c localc = a(this.appType, this.msgId, this.mediaId, this.hWn);
    AppMethodBeat.o(253823);
    return localc;
  }
  
  private void jok()
  {
    AppMethodBeat.i(253841);
    switch (this.appType)
    {
    default: 
      this.AkB.setVisibility(0);
      aBA(8);
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
      AppMethodBeat.o(253841);
      return;
      if (jol()) {
        if (Util.isImageExt(this.lPJ))
        {
          jom();
        }
        else
        {
          aBA(8);
          this.aeet.setVisibility(8);
          if (getMimeType().equals("")) {
            this.AkB.setVisibility(8);
          }
          for (;;)
          {
            jor();
            break;
            this.AkB.setVisibility(0);
          }
          if (jol()) {
            if (Util.isImageExt(this.lPJ))
            {
              jom();
            }
            else
            {
              Log.i("MicroMsg.AppAttachNewDownloadUI", "onDownLoadImpl");
              LQ(false);
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
    }
  }
  
  private boolean jol()
  {
    AppMethodBeat.i(253843);
    Object localObject = joj();
    if (localObject == null)
    {
      AppMethodBeat.o(253843);
      return true;
    }
    if (y.ZC(((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath))
    {
      aBA(8);
      this.aeet.setVisibility(8);
      AppMethodBeat.o(253843);
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
    AppMethodBeat.o(253843);
    return false;
  }
  
  private void jom()
  {
    AppMethodBeat.i(253845);
    Object localObject = joj();
    if (localObject == null)
    {
      Log.e("MicroMsg.AppAttachNewDownloadUI", "info == null");
      AppMethodBeat.o(253845);
      return;
    }
    Intent localIntent = new Intent(this, ShowImageUI.class);
    localIntent.putExtra("key_message_id", this.hTm.field_msgId);
    localIntent.putExtra("key_image_path", ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath);
    localIntent.putExtra("key_favorite", true);
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/chatting/AppAttachNewDownloadUI", "showFileImage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/chatting/AppAttachNewDownloadUI", "showFileImage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    AppMethodBeat.o(253845);
  }
  
  private void jon()
  {
    AppMethodBeat.i(253857);
    this.aedX.setVisibility(0);
    this.aeet.LR(false);
    this.aeeu.setVisibility(8);
    AppMethodBeat.o(253857);
  }
  
  private void joq()
  {
    AppMethodBeat.i(253767);
    if (this.hTm.getType() == 1090519089)
    {
      if ((this.hTm.kLw == 0) && (!this.aedR))
      {
        this.hTm.aJR();
        this.hTm.setFileStatus(0);
        ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().a(this.msgId, this.hTm);
        Log.i("MicroMsg.AppAttachNewDownloadUI", "checkFileStatus msgId:%s reset file sender", new Object[] { Long.valueOf(this.msgId) });
      }
      com.tencent.mm.pluginsdk.model.app.c localc = joj();
      if ((localc != null) && (localc.field_status == 199L) && (!y.ZC(localc.field_fileFullPath)))
      {
        localc.field_status = 102L;
        localc.field_offset = 0L;
        as.cWJ().a(localc, new String[0]);
        com.tencent.mm.pluginsdk.model.file.b.XTS.br(this.hTm);
      }
    }
    AppMethodBeat.o(253767);
  }
  
  private void jor()
  {
    AppMethodBeat.i(253803);
    this.aedL.setVisibility(0);
    if (this.fileName.equals(""))
    {
      this.aedL.setText(getString(R.l.openapi_app_file));
      AppMethodBeat.o(253803);
      return;
    }
    this.aedL.setText(this.fileName);
    AppMethodBeat.o(253803);
  }
  
  public final MMActivity dSs()
  {
    AppMethodBeat.i(369648);
    MMActivity localMMActivity = (MMActivity)super.getContext();
    AppMethodBeat.o(369648);
    return localMMActivity;
  }
  
  public void finish()
  {
    AppMethodBeat.i(254107);
    if (this.aeex != null) {
      this.aeex.finish();
    }
    super.finish();
    AppMethodBeat.o(254107);
  }
  
  public final void gGh()
  {
    AppMethodBeat.i(254100);
    com.tencent.threadpool.h.ahAA.bk(new AppAttachNewDownloadUI..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(254100);
  }
  
  public int getLayoutId()
  {
    return R.i.giS;
  }
  
  public void initView()
  {
    AppMethodBeat.i(254060);
    this.NlM = ((MMImageView)findViewById(R.h.download_type_icon));
    this.aedH = ((RoundProgressBtn)findViewById(R.h.fVh));
    this.aeet = new a((Button)findViewById(R.h.fGc), (TextView)findViewById(R.h.fGd));
    this.AkB = ((Button)findViewById(R.h.fGo));
    this.aedL = ((TextView)findViewById(R.h.fGi));
    this.aedM = ((TextView)findViewById(R.h.fGj));
    this.aedX = ((LinearLayout)findViewById(R.h.fGl));
    this.aeeu = ((TextView)findViewById(R.h.fUe));
    this.aeev = ((ProgressBar)findViewById(R.h.fUf));
    this.aeew = ((TextView)findViewById(R.h.fvm));
    this.AkC = ((Button)findViewById(R.h.download_btn));
    this.aeeb = ((LinearLayout)findViewById(R.h.fGn));
    this.aeec = ((ImageView)findViewById(R.h.fGm));
    this.aeec.setImageDrawable(bb.m(this, R.k.icons_filled_mini_program, getResources().getColor(R.e.btn_green_text_color)));
    this.aeeb.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(253649);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/AppAttachNewDownloadUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        Log.d("MicroMsg.AppAttachNewDownloadUI", "MoreOpenWaysArea#onClick");
        if (AppAttachNewDownloadUI.a(AppAttachNewDownloadUI.this) != null) {
          AppAttachNewDownloadUI.a(AppAttachNewDownloadUI.this).cDb();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/AppAttachNewDownloadUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(253649);
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
        AppMethodBeat.i(253660);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/AppAttachNewDownloadUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        Log.i("MicroMsg.AppAttachNewDownloadUI", "summerapp roundProgressBar downloadAppAttachScene[%s]", new Object[] { AppAttachNewDownloadUI.b(AppAttachNewDownloadUI.this) });
        if (AppAttachNewDownloadUI.b(AppAttachNewDownloadUI.this) != null)
        {
          AppAttachNewDownloadUI.b(AppAttachNewDownloadUI.this).a(AppAttachNewDownloadUI.this);
          com.tencent.mm.kernel.h.aZW().a(AppAttachNewDownloadUI.b(AppAttachNewDownloadUI.this));
          AppAttachNewDownloadUI.b(AppAttachNewDownloadUI.this, 15, -1);
        }
        for (;;)
        {
          AppAttachNewDownloadUI.J(AppAttachNewDownloadUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/AppAttachNewDownloadUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(253660);
          return;
          paramAnonymousView = AppAttachNewDownloadUI.H(AppAttachNewDownloadUI.this);
          if ((paramAnonymousView != null) && (paramAnonymousView.field_status != 199L))
          {
            Log.i("MicroMsg.AppAttachNewDownloadUI", "summerapp roundProgressBar onClick but scene is null and set status[%d] paused", new Object[] { Long.valueOf(paramAnonymousView.field_status) });
            paramAnonymousView.field_status = 102L;
            paramAnonymousView.field_lastModifyTime = cn.bDw();
            as.cWJ().a(paramAnonymousView, new String[0]);
            AppAttachNewDownloadUI.b(AppAttachNewDownloadUI.this, 15, -1);
          }
          com.tencent.mm.pluginsdk.model.file.b.XTS.br(AppAttachNewDownloadUI.I(AppAttachNewDownloadUI.this));
        }
      }
    });
    Object localObject = this.aeet;
    View.OnClickListener local3 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(253659);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/AppAttachNewDownloadUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (AppAttachNewDownloadUI.K(AppAttachNewDownloadUI.this))
        {
          paramAnonymousView = AppAttachNewDownloadUI.H(AppAttachNewDownloadUI.this);
          if (paramAnonymousView != null)
          {
            paramAnonymousView.field_status = 101L;
            paramAnonymousView.field_lastModifyTime = cn.bDw();
            as.cWJ().a(paramAnonymousView, new String[0]);
          }
          if (AppAttachNewDownloadUI.b(AppAttachNewDownloadUI.this) != null)
          {
            AppAttachNewDownloadUI.b(AppAttachNewDownloadUI.this).pause();
            bh.aZW().a(AppAttachNewDownloadUI.b(AppAttachNewDownloadUI.this));
          }
          AppAttachNewDownloadUI.a(AppAttachNewDownloadUI.this, new com.tencent.mm.plugin.record.model.g(AppAttachNewDownloadUI.L(AppAttachNewDownloadUI.this), AppAttachNewDownloadUI.M(AppAttachNewDownloadUI.this), AppAttachNewDownloadUI.N(AppAttachNewDownloadUI.this)));
          bh.aZW().a(AppAttachNewDownloadUI.b(AppAttachNewDownloadUI.this), 0);
          paramAnonymousView = com.tencent.mm.pluginsdk.model.file.b.XTS;
          com.tencent.mm.pluginsdk.model.file.b.b(AppAttachNewDownloadUI.I(AppAttachNewDownloadUI.this), AppAttachNewDownloadUI.O(AppAttachNewDownloadUI.this));
        }
        AppAttachNewDownloadUI.J(AppAttachNewDownloadUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/AppAttachNewDownloadUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(253659);
      }
    };
    ((a)localObject).Bqo.setOnClickListener(local3);
    this.AkC.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(253662);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/AppAttachNewDownloadUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        Log.i("MicroMsg.AppAttachNewDownloadUI", "start receive file");
        if (AppAttachNewDownloadUI.P(AppAttachNewDownloadUI.this) == 74)
        {
          AppAttachNewDownloadUI.b(AppAttachNewDownloadUI.this, 12, -1);
          AppAttachNewDownloadUI.I(AppAttachNewDownloadUI.this).setFileStatus(1);
          ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().a(AppAttachNewDownloadUI.L(AppAttachNewDownloadUI.this), AppAttachNewDownloadUI.I(AppAttachNewDownloadUI.this));
          if (AppAttachNewDownloadUI.P(AppAttachNewDownloadUI.this) != 74) {
            break label188;
          }
          AppAttachNewDownloadUI.Q(AppAttachNewDownloadUI.this);
        }
        for (;;)
        {
          paramAnonymousView = com.tencent.mm.pluginsdk.model.file.b.XTS;
          com.tencent.mm.pluginsdk.model.file.b.b(AppAttachNewDownloadUI.I(AppAttachNewDownloadUI.this), AppAttachNewDownloadUI.O(AppAttachNewDownloadUI.this));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/AppAttachNewDownloadUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(253662);
          return;
          AppAttachNewDownloadUI.b(AppAttachNewDownloadUI.this, 13, -1);
          AppAttachNewDownloadUI.I(AppAttachNewDownloadUI.this).setFileStatus(0);
          break;
          label188:
          AppAttachNewDownloadUI.R(AppAttachNewDownloadUI.this);
        }
      }
    });
    this.aeew.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(253664);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/AppAttachNewDownloadUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        Log.i("MicroMsg.AppAttachNewDownloadUI", "cancel receive file");
        AppAttachNewDownloadUI.b(AppAttachNewDownloadUI.this, 14, -1);
        AppAttachNewDownloadUI.I(AppAttachNewDownloadUI.this).setFileStatus(0);
        ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().a(AppAttachNewDownloadUI.L(AppAttachNewDownloadUI.this), AppAttachNewDownloadUI.I(AppAttachNewDownloadUI.this));
        AppAttachNewDownloadUI.J(AppAttachNewDownloadUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/AppAttachNewDownloadUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(253664);
      }
    });
    this.AkB.setOnClickListener(new AppAttachNewDownloadUI.9(this));
    switch (this.appType)
    {
    case 1: 
    case 3: 
    case 5: 
    default: 
      this.NlM.setImageResource(R.k.app_attach_file_icon_unknow);
      this.aedN = new com.tencent.mm.am.i()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, p paramAnonymousp)
        {
          AppMethodBeat.i(253829);
          if (paramAnonymousInt2 == 0) {}
          for (float f = 0.0F;; f = paramAnonymousInt1 * 100.0F / paramAnonymousInt2)
          {
            if ((paramAnonymousInt1 < paramAnonymousInt2) && (AppAttachNewDownloadUI.E(AppAttachNewDownloadUI.this).getVisibility() != 0))
            {
              AppAttachNewDownloadUI.F(AppAttachNewDownloadUI.this);
              AppAttachNewDownloadUI.G(AppAttachNewDownloadUI.this).setVisibility(8);
            }
            AppAttachNewDownloadUI.E(AppAttachNewDownloadUI.this).setProgress((int)f);
            AppMethodBeat.o(253829);
            return;
          }
        }
      };
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(253789);
          if (AppAttachNewDownloadUI.b(AppAttachNewDownloadUI.this) != null) {
            bh.aZW().a(AppAttachNewDownloadUI.b(AppAttachNewDownloadUI.this));
          }
          if ((AppAttachNewDownloadUI.c(AppAttachNewDownloadUI.this) != null) && (AppAttachNewDownloadUI.c(AppAttachNewDownloadUI.this).af(1, false)))
          {
            AppMethodBeat.o(253789);
            return true;
          }
          AppAttachNewDownloadUI.this.finish();
          AppMethodBeat.o(253789);
          return true;
        }
      });
      if (this.hTH) {
        addIconOptionMenu(0, R.k.actionbar_icon_dark_more, new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(253844);
            AppAttachNewDownloadUI.a(AppAttachNewDownloadUI.this, AppAttachNewDownloadUI.d(AppAttachNewDownloadUI.this));
            AppMethodBeat.o(253844);
            return false;
          }
        });
      }
      if ((!joe()) || (this.hTm.field_msgId != 0L)) {
        break label683;
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
      AppMethodBeat.o(254060);
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
    label683:
    if (this.Ysz > 0L)
    {
      this.aedM.setVisibility(0);
      this.aedM.setText(getResources().getString(R.l.gHR, new Object[] { ab.getSizeKB(this.Ysz) }));
    }
    while (this.aedR)
    {
      Log.i("MicroMsg.AppAttachNewDownloadUI", "summerapp isCanOpenFile");
      jok();
      AppMethodBeat.o(254060);
      return;
      this.aedM.setVisibility(8);
    }
    switch (this.appType)
    {
    default: 
    case 0: 
    case 6: 
    case 74: 
      for (;;)
      {
        Log.i("MicroMsg.AppAttachNewDownloadUI", "summerapp progressCallBack[%s], isDownloadFinished[%b], isDownloadStarted[%b]", new Object[] { this.aedN, Boolean.valueOf(this.aedR), Boolean.valueOf(this.aedS) });
        if ((this.appType == 2) || ((!this.aedR) && (!this.aedS) && (this.appType != 74))) {
          joh();
        }
        AppMethodBeat.o(254060);
        return;
        this.AkC.setVisibility(8);
        if (this.aedS) {
          this.aeet.setVisibility(0);
        }
        for (;;)
        {
          aBA(8);
          this.AkB.setVisibility(8);
          Log.d("MicroMsg.AppAttachNewDownloadUI", "hide moreOpenWaysArea");
          this.aeeb.setVisibility(4);
          jor();
          break;
          this.aeet.setVisibility(8);
        }
        this.aeeb.setVisibility(4);
        LQ(false);
      }
    case 7: 
      if (this.aedS)
      {
        this.aeet.setVisibility(0);
        label1010:
        aBA(8);
      }
      break;
    }
    for (;;)
    {
      this.AkB.setVisibility(8);
      Log.d("MicroMsg.AppAttachNewDownloadUI", "hide moreOpenWaysArea");
      this.aeeb.setVisibility(4);
      this.aedL.setVisibility(8);
      break;
      this.aeet.setVisibility(8);
      break label1010;
      aBA(8);
      if (this.aedS) {
        this.aeet.setVisibility(0);
      } else {
        this.aeet.setVisibility(8);
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(254076);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.tencent.mm.pluginsdk.ui.tools.a.a(this, paramInt1, paramInt2, paramIntent, this.aedT, R.l.download_no_match_msg, R.l.download_no_match_title, 1);
    AppMethodBeat.o(254076);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(254051);
    super.onCreate(paramBundle);
    init();
    AppMethodBeat.o(254051);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(254073);
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    paramContextMenu.add(0, 0, 0, getString(R.l.app_copy));
    AppMethodBeat.o(254073);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(254065);
    if (this.NzY != null) {
      this.NzY.oHS = null;
    }
    as.cWJ().remove(this);
    ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().a(this);
    super.onDestroy();
    if (this.aeex != null) {
      this.aeex.onDestroy();
    }
    if (this.AkR != null) {
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.handoff.a.a.class)).d(this.AkR);
    }
    AppMethodBeat.o(254065);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(254071);
    Log.i("MicroMsg.AppAttachNewDownloadUI", "onKeyDown keyCode %d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt == 4) && (this.aeea != null) && (this.aeea.af(2, false)))
    {
      AppMethodBeat.o(254071);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(254071);
    return bool;
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(254106);
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    if (this.aeea != null) {
      this.aeea.bhW();
    }
    init();
    AppMethodBeat.o(254106);
  }
  
  public void onNotifyChange(com.tencent.mm.plugin.messenger.foundation.a.a.i parami, i.c paramc)
  {
    AppMethodBeat.i(254081);
    if ((parami == null) || (paramc == null))
    {
      AppMethodBeat.o(254081);
      return;
    }
    if (this.appType == 74)
    {
      parami = paramc.mZo.iterator();
      while (parami.hasNext())
      {
        cc localcc = (cc)parami.next();
        if (this.msgId == localcc.field_msgId)
        {
          paramc = localcc.field_content;
          parami = paramc;
          if (this.aedO)
          {
            parami = paramc;
            if (localcc.field_isSend == 0) {
              parami = bAv(localcc.field_content);
            }
          }
          parami = k.b.Hf(parami);
          if (parami != null)
          {
            Log.i("MicroMsg.AppAttachNewDownloadUI", "update msgId:%s newType:%s newFileStatus:%s", new Object[] { Long.valueOf(this.msgId), Integer.valueOf(parami.type), Integer.valueOf(localcc.fileStatus) });
            if ((parami.type == 6) && (this.hTm.fileStatus == 1))
            {
              if (!dLc())
              {
                finish();
                AppMethodBeat.o(254081);
                return;
              }
              LQ(true);
              AppMethodBeat.o(254081);
              return;
            }
            if ((parami.type == 6) && (!dLc()))
            {
              finish();
              AppMethodBeat.o(254081);
              return;
            }
          }
        }
      }
    }
    AppMethodBeat.o(254081);
  }
  
  public void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(254078);
    duV();
    AppMethodBeat.o(254078);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(254068);
    bh.aZW().b(221, this);
    bh.aZW().b(728, this);
    super.onPause();
    if (this.aeea != null) {
      this.aeea.bhW();
    }
    if (this.aeex != null) {
      this.aeex.bhW();
    }
    rr localrr = new rr();
    localrr.hUK.pause = false;
    rr.a locala = localrr.hUK;
    if (this.hTm == null) {}
    for (String str = "";; str = this.hTm.field_talker)
    {
      locala.talker = str;
      localrr.asyncPublish(getMainLooper());
      Log.d("MicroMsg.AppAttachNewDownloadUI", "AppAttachDownloadUI cancel pause auto download logic");
      AppMethodBeat.o(254068);
      return;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(254067);
    super.onResume();
    bh.aZW().a(221, this);
    bh.aZW().a(728, this);
    rr localrr = new rr();
    localrr.hUK.pause = true;
    localrr.hUK.talker = this.hTm.field_talker;
    localrr.asyncPublish(getMainLooper());
    Log.d("MicroMsg.AppAttachNewDownloadUI", "AppAttachDownloadUI req pause auto download logic");
    this.AkB.setEnabled(true);
    if (this.aeea != null) {
      this.aeea.coi();
    }
    if (this.aeex != null) {
      this.aeex.coi();
    }
    AppMethodBeat.o(254067);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(254095);
    Log.i("MicroMsg.AppAttachNewDownloadUI", "summerapp onSceneEnd type[%d], [%d, %d, %s]", new Object[] { Integer.valueOf(paramp.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramp.getType() != 221) && (paramp.getType() != 728))
    {
      AppMethodBeat.o(254095);
      return;
    }
    if ((paramp.getType() == 728) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = joj();
      if (paramString == null)
      {
        Log.i("MicroMsg.AppAttachNewDownloadUI", "summerapp onSceneEnd getAppAttachInfo is null");
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
        AppMethodBeat.o(254095);
        return;
      }
      if (paramString.field_signature == null) {}
      for (paramInt1 = -1;; paramInt1 = paramString.field_signature.length())
      {
        Log.i("MicroMsg.AppAttachNewDownloadUI", "summerapp onSceneEnd CheckBigFileDownload ok signature len[%d] start NetSceneDownloadAppAttach", new Object[] { Integer.valueOf(paramInt1) });
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
        Log.i("MicroMsg.AppAttachNewDownloadUI", "summerapp onSceneEnd reset downloadAppAttachScene[%s] by mediaSvrId[%s]", new Object[] { this.NzY, localc.field_mediaSvrId });
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
      AppMethodBeat.o(254095);
      return;
    }
    if ((paramInt2 != 0) && (CrashReportFactory.hasDebuger())) {
      Toast.makeText(this, "errCode[" + paramInt2 + "]", 0).show();
    }
    if ((paramInt2 == -5103087) || (paramInt2 == -5103017) || (paramInt2 == -5103059))
    {
      paramString = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().sl(this.msgId);
      if (paramString != null)
      {
        paramString.setFileStatus(4);
        ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().a(paramString.field_msgId, paramString);
        Log.i("MicroMsg.AppAttachNewDownloadUI", "msgId:%s fail, errCode:%s", new Object[] { Long.valueOf(this.msgId), Integer.valueOf(paramInt2) });
      }
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
      AppMethodBeat.o(254095);
      return;
    }
    LQ(false);
    Log.e("MicroMsg.AppAttachNewDownloadUI", "summerapp onSceneEnd, download fail, type = " + paramp.getType() + " errType = " + paramInt1 + ", errCode = " + paramInt2);
    AppMethodBeat.o(254095);
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
      AppMethodBeat.i(253633);
      this.Bqo = paramButton;
      this.dyR = paramTextView;
      if (paramTextView != null)
      {
        int i = com.tencent.mm.k.i.aRC().getInt("MsgFileExpiredInterval", 432000);
        long l = AppAttachNewDownloadUI.I(AppAttachNewDownloadUI.this).getCreateTime() / 1000L;
        Math.floor((i - cn.secondsToNow(l)) * 1.0D / 86400.0D);
        paramTextView.setText("");
      }
      AppMethodBeat.o(253633);
    }
    
    public final void LR(boolean paramBoolean)
    {
      AppMethodBeat.i(253644);
      Log.i("MicroMsg.AppAttachNewDownloadUI", "showErrorTip overtime %s", new Object[] { Long.valueOf(AppAttachNewDownloadUI.I(AppAttachNewDownloadUI.this).field_msgId) });
      if (this.Bqo != null) {
        this.Bqo.setVisibility(4);
      }
      if (this.dyR != null)
      {
        this.dyR.setVisibility(0);
        if (!paramBoolean) {
          break label135;
        }
        this.dyR.setText(R.l.gHC);
        AppAttachNewDownloadUI.b(AppAttachNewDownloadUI.this, 17, -1);
      }
      for (;;)
      {
        this.dyR.setTextColor(AppAttachNewDownloadUI.this.getResources().getColor(R.e.Red_120));
        if (!this.NBX)
        {
          this.NBX = true;
          AppAttachNewDownloadUI.b(AppAttachNewDownloadUI.this, 8, 6);
        }
        AppMethodBeat.o(253644);
        return;
        label135:
        this.dyR.setText(R.l.gHD);
      }
    }
    
    public final void setVisibility(int paramInt)
    {
      AppMethodBeat.i(253639);
      if (this.Bqo != null) {
        this.Bqo.setVisibility(paramInt);
      }
      if (this.dyR != null) {
        this.dyR.setVisibility(paramInt);
      }
      AppMethodBeat.o(253639);
    }
  }
  
  static final class b
    implements com.tencent.mm.plugin.appbrand.openmaterial.j
  {
    private final com.tencent.mm.plugin.appbrand.service.j WVQ;
    private final WeakReference<AppAttachNewDownloadUI> YtG;
    private final MaterialModel trN;
    
    public b(AppAttachNewDownloadUI paramAppAttachNewDownloadUI, MaterialModel paramMaterialModel, com.tencent.mm.plugin.appbrand.service.j paramj)
    {
      AppMethodBeat.i(253634);
      this.YtG = new WeakReference(paramAppAttachNewDownloadUI);
      this.trN = paramMaterialModel;
      this.WVQ = paramj;
      AppMethodBeat.o(253634);
    }
    
    public final void a(boolean paramBoolean, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection)
    {
      AppMethodBeat.i(253642);
      Log.d("MicroMsg.AppAttachNewDownloadUI", "loadOpenMaterials#onMyOpenMaterialsGot");
      AppAttachNewDownloadUI localAppAttachNewDownloadUI = (AppAttachNewDownloadUI)this.YtG.get();
      if (localAppAttachNewDownloadUI == null)
      {
        Log.i("MicroMsg.AppAttachNewDownloadUI", "loadOpenMaterials#onMyOpenMaterialsGot, ui is null");
        AppMethodBeat.o(253642);
        return;
      }
      if (!paramBoolean)
      {
        Log.i("MicroMsg.AppAttachNewDownloadUI", "loadOpenMaterials#onMyOpenMaterialsGot, fail");
        AppMethodBeat.o(253642);
        return;
      }
      AppAttachNewDownloadUI.a(localAppAttachNewDownloadUI, this.trN.trT);
      AppAttachNewDownloadUI.a(localAppAttachNewDownloadUI, paramAppBrandOpenMaterialCollection);
      if (!AppAttachNewDownloadUI.d(localAppAttachNewDownloadUI))
      {
        Log.i("MicroMsg.AppAttachNewDownloadUI", "loadOpenMaterials#onMyOpenMaterialsGot, download not finish");
        AppMethodBeat.o(253642);
        return;
      }
      if (this.WVQ.cDh().a(paramAppBrandOpenMaterialCollection))
      {
        if (AppAttachNewDownloadUI.a(localAppAttachNewDownloadUI) != null) {
          AppAttachNewDownloadUI.a(localAppAttachNewDownloadUI).dead();
        }
        AppAttachNewDownloadUI.a(localAppAttachNewDownloadUI, this.WVQ.cDh().b(com.tencent.mm.plugin.appbrand.openmaterial.model.b.trZ).a(localAppAttachNewDownloadUI, AppAttachNewDownloadUI.z(localAppAttachNewDownloadUI), AppAttachNewDownloadUI.A(localAppAttachNewDownloadUI), null, null));
        Log.d("MicroMsg.AppAttachNewDownloadUI", "show moreOpenWaysArea");
        AppAttachNewDownloadUI.B(localAppAttachNewDownloadUI).setVisibility(0);
      }
      while (AppAttachNewDownloadUI.z(localAppAttachNewDownloadUI) != null) {
        if (this.WVQ.a(AppAttachNewDownloadUI.z(localAppAttachNewDownloadUI), paramAppBrandOpenMaterialCollection))
        {
          if (AppAttachNewDownloadUI.C(localAppAttachNewDownloadUI) != null) {
            AppAttachNewDownloadUI.C(localAppAttachNewDownloadUI).dead();
          }
          AppAttachNewDownloadUI.a(localAppAttachNewDownloadUI, this.WVQ.a(com.tencent.mm.plugin.appbrand.openmaterial.model.b.trZ, localAppAttachNewDownloadUI, AppAttachNewDownloadUI.z(localAppAttachNewDownloadUI), AppAttachNewDownloadUI.A(localAppAttachNewDownloadUI), AppAttachNewDownloadUI.a(localAppAttachNewDownloadUI), null));
          AppMethodBeat.o(253642);
          return;
          Log.i("MicroMsg.AppAttachNewDownloadUI", "loadOpenMaterials#onMyOpenMaterialsGot, can not create");
        }
        else
        {
          Log.i("MicroMsg.AppAttachNewDownloadUI", "loadOpenMaterials#onMyOpenMaterialsGot, not need enhance");
        }
      }
      AppMethodBeat.o(253642);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppAttachNewDownloadUI
 * JD-Core Version:    0.7.0.1
 */