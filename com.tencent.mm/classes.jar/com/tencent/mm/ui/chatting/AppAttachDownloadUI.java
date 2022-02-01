package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.nv;
import com.tencent.mm.g.a.nv.a;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.plugin.msgquote.model.MsgQuoteItem;
import com.tencent.mm.plugin.record.b.e.a;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.tools.ShowImageUI;
import com.tencent.mm.ui.widget.progress.RoundProgressBtn;
import com.tencent.mm.vfs.i;

public class AppAttachDownloadUI
  extends MMActivity
  implements com.tencent.mm.al.g, e.a, k.a
{
  private com.tencent.mm.ui.chatting.f.a CmZ;
  private RoundProgressBtn GjF;
  private a GjG;
  private View GjH;
  private TextView GjI;
  private TextView GjJ;
  private TextView GjK;
  private com.tencent.mm.al.h GjL;
  private boolean GjM;
  private k.b GjN;
  private long GjO;
  private String GjP;
  private boolean GjQ;
  private boolean GjR;
  private boolean GjS;
  private int GjT;
  private boolean GjU;
  private int GjV;
  private LinearLayout GjW;
  private LinearLayout GjX;
  private boolean GjY;
  private int appType;
  private String dpv;
  private bl drF;
  private boolean drV;
  private String duk;
  private String fLQ;
  private String fMw;
  private String fileName;
  private String filePath;
  private String fyk;
  private TextView igQ;
  private int mUE;
  private int mUF;
  private com.tencent.mm.ui.widget.b.a mVN;
  private String mediaId;
  private long msgId;
  private int nNc;
  private n.d peM;
  private HandOffFile qhE;
  private View.OnTouchListener qhG;
  private View.OnLongClickListener qhH;
  private Button qho;
  private int scene;
  private String stp;
  private String syI;
  private MMImageView uNe;
  private com.tencent.mm.plugin.record.b.e uZW;
  
  public AppAttachDownloadUI()
  {
    AppMethodBeat.i(34129);
    this.nNc = 0;
    this.GjQ = false;
    this.GjR = false;
    this.GjS = true;
    this.GjT = 5000;
    this.GjU = false;
    this.GjY = false;
    this.mVN = null;
    this.peM = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(191459);
        ClipboardManager localClipboardManager = (ClipboardManager)aj.getContext().getSystemService("clipboard");
        if (AppAttachDownloadUI.y(AppAttachDownloadUI.this).equals("")) {}
        for (paramAnonymousMenuItem = AppAttachDownloadUI.this.getString(2131761808);; paramAnonymousMenuItem = AppAttachDownloadUI.y(AppAttachDownloadUI.this))
        {
          localClipboardManager.setPrimaryClip(ClipData.newPlainText(null, paramAnonymousMenuItem));
          com.tencent.mm.ui.base.h.cf(AppAttachDownloadUI.this, AppAttachDownloadUI.this.getString(2131755702));
          AppMethodBeat.o(191459);
          return;
        }
      }
    };
    this.qhG = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(191460);
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(191460);
          return false;
          AppAttachDownloadUI.b(AppAttachDownloadUI.this, (int)paramAnonymousMotionEvent.getRawX());
          AppAttachDownloadUI.c(AppAttachDownloadUI.this, (int)paramAnonymousMotionEvent.getRawY());
        }
      }
    };
    this.qhH = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(191452);
        ad.d("MicroMsg.AppAttachDownloadUI", "onLongClick");
        if (AppAttachDownloadUI.z(AppAttachDownloadUI.this) == null) {
          AppAttachDownloadUI.a(AppAttachDownloadUI.this, new com.tencent.mm.ui.widget.b.a(AppAttachDownloadUI.this.cjz()));
        }
        AppAttachDownloadUI.z(AppAttachDownloadUI.this).a(paramAnonymousView, AppAttachDownloadUI.this, AppAttachDownloadUI.A(AppAttachDownloadUI.this), AppAttachDownloadUI.B(AppAttachDownloadUI.this), AppAttachDownloadUI.C(AppAttachDownloadUI.this));
        AppMethodBeat.o(191452);
        return true;
      }
    };
    AppMethodBeat.o(34129);
  }
  
  private void Yl(int paramInt)
  {
    AppMethodBeat.i(34158);
    if (paramInt != this.GjF.getVisibility())
    {
      ad.i("MicroMsg.AppAttachDownloadUI", "setRoundProgressBar %s %s", new Object[] { Integer.valueOf(paramInt), ae.aGM() });
      this.GjF.setVisibility(paramInt);
    }
    AppMethodBeat.o(34158);
  }
  
  private String aKv(String paramString)
  {
    AppMethodBeat.i(34142);
    String str = paramString;
    if (this.GjM)
    {
      str = paramString;
      if (paramString != null) {
        str = bi.ug(paramString);
      }
    }
    AppMethodBeat.o(34142);
    return str;
  }
  
  private static boolean b(com.tencent.mm.pluginsdk.model.app.c paramc)
  {
    AppMethodBeat.i(34157);
    if (paramc == null)
    {
      AppMethodBeat.o(34157);
      return false;
    }
    com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(paramc.field_fileFullPath);
    if ((locale.exists()) && (locale.length() == paramc.field_totalLen))
    {
      AppMethodBeat.o(34157);
      return true;
    }
    AppMethodBeat.o(34157);
    return false;
  }
  
  private void cIm()
  {
    AppMethodBeat.i(34132);
    this.CmZ = new com.tencent.mm.ui.chatting.f.a(new com.tencent.mm.plugin.ball.a.e((MMActivity)super.getContext()));
    this.CmZ.h(this.filePath, this.fyk, this.nNc, true);
    this.CmZ.ls(this.fyk, this.fileName);
    this.qhE.K(this.CmZ.mDH);
    AppMethodBeat.o(34132);
  }
  
  private void dem()
  {
    AppMethodBeat.i(34153);
    ad.i("MicroMsg.AppAttachDownloadUI", "[ImageGalleryUI] showImage");
    Object localObject = new Intent(this, ImageGalleryUI.class);
    ((Intent)localObject).putExtra("img_gallery_msg_id", this.drF.field_msgId);
    ((Intent)localObject).putExtra("img_gallery_talker", this.drF.field_talker);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/ui/chatting/AppAttachDownloadUI", "showImage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/AppAttachDownloadUI", "showImage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    overridePendingTransition(0, 0);
    AppMethodBeat.o(34153);
  }
  
  private void eUj()
  {
    AppMethodBeat.i(34133);
    String str1 = ae.nullAsNil(u.aqG());
    Object localObject2 = ae.nullAsNil(this.drF.field_talker);
    Object localObject1 = localObject2;
    if (w.pF((String)localObject2)) {
      localObject1 = ae.nullAsNil(this.GjN.dpv);
    }
    if (this.drF.field_isSend == 1)
    {
      localObject2 = str1;
      if (this.drF.field_isSend != 1) {
        break label259;
      }
      label76:
      String str2 = ae.nullAsNil(this.filePath);
      String str3 = this.fyk;
      String str4 = this.fileName;
      String str5 = this.syI;
      long l = this.GjO;
      String str6 = Long.toString(this.drF.field_msgSvrId);
      if (ae.isNullOrNil(this.stp)) {
        break label266;
      }
      str1 = this.stp;
      label136:
      this.qhE = new HandOffFile(str2, str3, str4, str5, l, str6, "", str1, this.fMw, this.fLQ, "", "", (String)localObject2, (String)localObject1);
      boolean bool = b(eUp());
      localObject1 = this.qhE;
      if (!bool) {
        break label275;
      }
    }
    label259:
    label266:
    label275:
    for (int i = 1;; i = 2)
    {
      ((HandOffFile)localObject1).stq = i;
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).f(this.qhE);
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).c(this.qhE);
      AppMethodBeat.o(34133);
      return;
      localObject2 = localObject1;
      break;
      localObject1 = str1;
      break label76;
      str1 = this.GjP;
      break label136;
    }
  }
  
  private boolean eUk()
  {
    AppMethodBeat.i(34134);
    this.scene = getIntent().getIntExtra("scene", 0);
    this.msgId = getIntent().getLongExtra("app_msg_id", -1L);
    this.GjU = getIntent().getBooleanExtra("choose_way", false);
    this.GjV = getIntent().getIntExtra("msg_type", 0);
    if (this.msgId == -1L)
    {
      AppMethodBeat.o(34134);
      return false;
    }
    az.arV();
    this.drF = com.tencent.mm.model.c.apO().rm(this.msgId);
    if ((this.drF == null) || (this.drF.field_msgId == 0L) || (this.drF.field_content == null))
    {
      if (!eUl()) {
        break label358;
      }
      localObject = (MsgQuoteItem)getIntent().getParcelableExtra("key_quoted_msg");
      if (localObject == null)
      {
        AppMethodBeat.o(34134);
        return false;
      }
      this.drF = new bl();
      this.drF.setType(((MsgQuoteItem)localObject).type);
      this.drF.kX(((MsgQuoteItem)localObject).tNr);
      this.drF.nY(((MsgQuoteItem)localObject).tNs);
      this.drF.mZ(((MsgQuoteItem)localObject).tNv);
      this.drF.setContent(((MsgQuoteItem)localObject).content);
      if (bt.kU(((MsgQuoteItem)localObject).tNt, u.aqG())) {
        this.drF.jV(1);
      }
    }
    this.GjM = w.pF(this.drF.field_talker);
    this.duk = this.drF.field_content;
    if ((this.GjM) && (this.drF.field_isSend == 0)) {
      this.duk = aKv(this.drF.field_content);
    }
    this.GjN = k.b.rx(this.duk);
    if (this.GjN == null)
    {
      ad.e("MicroMsg.AppAttachDownloadUI", "summerapp parse msgContent error, %s", new Object[] { this.duk });
      AppMethodBeat.o(34134);
      return false;
      label358:
      AppMethodBeat.o(34134);
      return false;
    }
    if ((ae.isNullOrNil(this.GjN.dbA)) && (!ae.isNullOrNil(this.GjN.gHt)))
    {
      ad.e("MicroMsg.AppAttachDownloadUI", "summerapp msgContent format error, %s", new Object[] { this.duk });
      this.GjN.dbA = this.GjN.gHt.hashCode();
    }
    this.appType = this.GjN.type;
    this.mediaId = this.GjN.dbA;
    this.fileName = ae.nullAsNil(this.GjN.title);
    this.fyk = ae.nullAsNil(this.GjN.gHf).toLowerCase();
    this.GjO = this.GjN.gHe;
    this.syI = ae.nullAsNil(this.GjN.filemd5);
    this.dpv = ae.nullAsNil(this.GjN.dpv);
    this.stp = ae.nullAsNil(this.GjN.gHt);
    this.GjP = ae.nullAsNil(this.GjN.gHk);
    this.fMw = ae.nullAsNil(this.GjN.fMw);
    this.fLQ = ae.nullAsNil(this.GjN.gHq);
    if (ae.isNullOrNil(this.fyk)) {
      this.fyk = i.RK(this.fileName);
    }
    ad.i("MicroMsg.AppAttachDownloadUI", "summerapp initParams msgId[%d], sender[%d], msgContent[%s], appType[%d], mediaId[%s], fileName[%s]", new Object[] { Long.valueOf(this.msgId), Integer.valueOf(this.drF.field_isSend), this.duk, Integer.valueOf(this.appType), this.mediaId, this.fileName });
    Object localObject = eUp();
    if (localObject == null)
    {
      ad.i("MicroMsg.AppAttachDownloadUI", "summerapp initParams attInfo is null");
      this.GjR = false;
      if (this.GjN.type == 6) {
        ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).S(String.valueOf(this.drF.field_msgId), this.drF.field_msgSvrId);
      }
      fq(4, 0);
      eUj();
      if (!b((com.tencent.mm.pluginsdk.model.app.c)localObject)) {
        break label984;
      }
      if (this.scene != 1) {
        break label914;
      }
      this.nNc = 7;
      if (this.GjU)
      {
        bool = com.tencent.mm.pluginsdk.ui.tools.a.c(this, ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath, this.fyk, this.nNc);
        AppMethodBeat.o(34134);
        return bool;
      }
    }
    else
    {
      this.filePath = ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath;
      new com.tencent.mm.vfs.e(((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath);
      if (((com.tencent.mm.pluginsdk.model.app.c)localObject).field_offset > 0L) {}
      for (this.GjR = true;; this.GjR = false)
      {
        ad.i("MicroMsg.AppAttachDownloadUI", "summerapp initParams attInfo field_fileFullPath[%s], field_offset[%d], isDownloadStarted[%b]", new Object[] { ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath, Long.valueOf(((com.tencent.mm.pluginsdk.model.app.c)localObject).field_offset), Boolean.valueOf(this.GjR) });
        break;
      }
    }
    boolean bool = com.tencent.mm.pluginsdk.ui.tools.a.ad(((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath, this.fyk, this.nNc);
    AppMethodBeat.o(34134);
    return bool;
    label914:
    if (this.nNc != 9) {
      this.nNc = 1;
    }
    if (this.GjU)
    {
      bool = com.tencent.mm.pluginsdk.ui.tools.a.c(this, ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath, this.fyk, this.nNc);
      AppMethodBeat.o(34134);
      return bool;
    }
    bool = com.tencent.mm.pluginsdk.ui.tools.a.ad(((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath, this.fyk, this.nNc);
    AppMethodBeat.o(34134);
    return bool;
    label984:
    AppMethodBeat.o(34134);
    return true;
  }
  
  private boolean eUl()
  {
    return this.GjV == 1;
  }
  
  private void eUm()
  {
    AppMethodBeat.i(34141);
    cs localcs = new cs();
    com.tencent.mm.pluginsdk.model.g.e(localcs, this.drF);
    localcs.deQ.activity = this;
    localcs.deQ.deW = 39;
    com.tencent.mm.sdk.b.a.ESL.l(localcs);
    AppMethodBeat.o(34141);
  }
  
  private void eUn()
  {
    AppMethodBeat.i(34143);
    Yl(0);
    this.GjG.setVisibility(8);
    if (eUo())
    {
      ad.i("MicroMsg.AppAttachDownloadUI", "startToDownloadFile");
      this.uZW = new com.tencent.mm.plugin.record.b.e(this.msgId, this.mediaId, this.GjL);
      az.aeS().a(this.uZW, 0);
      aa.O(this.drF);
      fq(7, 1);
    }
    AppMethodBeat.o(34143);
  }
  
  private boolean eUo()
  {
    int i = -1;
    boolean bool2 = true;
    AppMethodBeat.i(34145);
    Object localObject1 = eUp();
    Object localObject2;
    boolean bool1;
    long l1;
    long l2;
    long l3;
    String str1;
    long l4;
    if (localObject1 == null)
    {
      com.tencent.mm.pluginsdk.model.app.m.x(this.msgId, this.duk);
      localObject2 = eUp();
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
        ad.i("MicroMsg.AppAttachDownloadUI", "summerapp tryInitAttachInfo newInfo systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], signature len[%d]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), localObject1, Long.valueOf(l3), str1, Long.valueOf(l4), Boolean.valueOf(bool1), Integer.valueOf(i) });
        if (this.GjN.gHi == 0)
        {
          localObject1 = localObject2;
          bool1 = bool2;
          if (this.GjN.gHe <= 26214400) {}
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
      if ((this.GjN == null) || ((this.GjN.gHi == 0) && (this.GjN.gHe <= 26214400))) {
        break label569;
      }
      bool1 = false;
    }
    label569:
    for (;;)
    {
      if (!bool1) {
        az.aeS().a(new com.tencent.mm.plugin.record.b.c((com.tencent.mm.pluginsdk.model.app.c)localObject1, this.fMw, this.syI, this.fileName, this.fyk, this.dpv), 0);
      }
      if (localObject1 != null)
      {
        this.filePath = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath;
        cIm();
      }
      AppMethodBeat.o(34145);
      return bool1;
      label322:
      i = ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_signature.length();
      break;
      label334:
      bool1 = false;
      break label219;
      localObject2 = new com.tencent.mm.vfs.e(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath);
      if ((((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_status == 199L) && (!((com.tencent.mm.vfs.e)localObject2).exists()))
      {
        ad.i("MicroMsg.AppAttachDownloadUI", "summerapp tryInitAttachInfo info exist but file not!");
        com.tencent.mm.pluginsdk.model.app.m.x(this.msgId, this.duk);
      }
      l1 = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).systemRowid;
      l2 = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_totalLen;
      str1 = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath;
      l3 = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_type;
      String str2 = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_mediaId;
      l4 = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_msgInfoId;
      bool1 = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_isUpload;
      boolean bool3 = ((com.tencent.mm.vfs.e)localObject2).exists();
      long l5 = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_status;
      if (((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_signature == null) {}
      for (;;)
      {
        ad.i("MicroMsg.AppAttachDownloadUI", "summerapp tryInitAttachInfo info exist systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], file.exists[%b], status[%d], signature len[%d]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), str1, Long.valueOf(l3), str2, Long.valueOf(l4), Boolean.valueOf(bool1), Boolean.valueOf(bool3), Long.valueOf(l5), Integer.valueOf(i) });
        bool1 = bool2;
        break;
        i = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_signature.length();
      }
    }
  }
  
  private com.tencent.mm.pluginsdk.model.app.c eUp()
  {
    AppMethodBeat.i(34147);
    final com.tencent.mm.pluginsdk.model.app.c localc1 = ap.bxS().vj(this.msgId);
    if (localc1 != null)
    {
      ad.i("MicroMsg.AppAttachDownloadUI", "summerapp getAppAttachInfo by msgId [%d] stack[%s]", new Object[] { Long.valueOf(this.msgId), ae.aGM() });
      AppMethodBeat.o(34147);
      return localc1;
    }
    localc1 = com.tencent.mm.pluginsdk.model.app.m.aAV(this.mediaId);
    if (localc1 == null)
    {
      ad.i("MicroMsg.AppAttachDownloadUI", "summerapp getAppAttachInfo by msgId and mediaId is null stack[%s]", new Object[] { ae.aGM() });
      AppMethodBeat.o(34147);
      return localc1;
    }
    if ((localc1.field_msgInfoId == this.msgId) || (i.eK(localc1.field_fileFullPath)))
    {
      AppMethodBeat.o(34147);
      return localc1;
    }
    com.tencent.mm.pluginsdk.model.app.m.x(this.msgId, this.duk);
    final com.tencent.mm.pluginsdk.model.app.c localc2 = ap.bxS().vj(this.msgId);
    if (localc2 == null)
    {
      ad.w("MicroMsg.AppAttachDownloadUI", "summerapp getAppAttachInfo create new info from local but failed stack[%s]", new Object[] { ae.aGM() });
      AppMethodBeat.o(34147);
      return localc1;
    }
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34117);
        long l1 = System.currentTimeMillis();
        long l2 = i.lC(localc1.field_fileFullPath, localc2.field_fileFullPath);
        if (l2 > 0L)
        {
          localc2.field_offset = l2;
          if (AppAttachDownloadUI.c(localc2)) {
            localc2.field_status = 199L;
          }
        }
        for (boolean bool = ap.bxS().a(localc2, new String[0]);; bool = false)
        {
          ad.i("MicroMsg.AppAttachDownloadUI", "summerapp copyAttachFromLocal size[%d], id[%d, %d], ret[%b], new status[%d], take[%d]ms", new Object[] { Long.valueOf(l2), Long.valueOf(localc1.field_msgInfoId), Long.valueOf(localc2.field_msgInfoId), Boolean.valueOf(bool), Long.valueOf(localc2.field_status), Long.valueOf(System.currentTimeMillis() - l1) });
          AppMethodBeat.o(34117);
          return;
        }
      }
    }, "copyAttachFromLocal");
    AppMethodBeat.o(34147);
    return localc1;
  }
  
  private void eUq()
  {
    AppMethodBeat.i(34150);
    switch (this.appType)
    {
    case 1: 
    case 3: 
    case 4: 
    case 5: 
    default: 
      this.qho.setVisibility(0);
      Yl(8);
      this.GjH.setVisibility(8);
    }
    for (;;)
    {
      Object localObject;
      if (this.qhE.stq != 1)
      {
        this.qhE.stq = 1;
        localObject = eUp();
        if (localObject != null) {
          this.qhE.adz(ae.nullAsNil(((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath));
        }
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).f(this.qhE);
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).e(this.qhE);
      }
      AppMethodBeat.o(34150);
      return;
      if (eUr()) {
        if (bt.aGv(this.fyk))
        {
          eUs();
        }
        else
        {
          localObject = getMimeType();
          ad.i("MicroMsg.AppAttachDownloadUI", "onDownLoadImpl");
          eUu();
          Yl(8);
          this.GjH.setVisibility(8);
          this.GjG.setVisibility(8);
          this.GjJ.setVisibility(0);
          if (this.fileName.equals("")) {
            this.GjJ.setText(getString(2131761808));
          }
          for (;;)
          {
            if ((localObject != null) && (!((String)localObject).equals(""))) {
              break label318;
            }
            this.qho.setVisibility(8);
            this.igQ.setText(getString(2131758100));
            break;
            this.GjJ.setText(this.fileName);
          }
          label318:
          this.qho.setVisibility(0);
          this.igQ.setText(getString(2131758101));
          continue;
          if (eUr())
          {
            dem();
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
  
  private boolean eUr()
  {
    AppMethodBeat.i(34151);
    com.tencent.mm.pluginsdk.model.app.c localc = eUp();
    if (localc == null)
    {
      AppMethodBeat.o(34151);
      return true;
    }
    if (i.eK(localc.field_fileFullPath))
    {
      Yl(8);
      this.GjH.setVisibility(8);
      this.GjG.setVisibility(8);
      AppMethodBeat.o(34151);
      return true;
    }
    Yl(8);
    eUt();
    AppMethodBeat.o(34151);
    return false;
  }
  
  private void eUs()
  {
    AppMethodBeat.i(34152);
    Object localObject = eUp();
    if (localObject == null)
    {
      ad.e("MicroMsg.AppAttachDownloadUI", "info == null");
      AppMethodBeat.o(34152);
      return;
    }
    Intent localIntent = new Intent(this, ShowImageUI.class);
    localIntent.putExtra("key_message_id", this.drF.field_msgId);
    localIntent.putExtra("key_image_path", ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath);
    localIntent.putExtra("key_favorite", true);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/ui/chatting/AppAttachDownloadUI", "showFileImage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/AppAttachDownloadUI", "showFileImage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    AppMethodBeat.o(34152);
  }
  
  private void eUt()
  {
    AppMethodBeat.i(34159);
    this.GjW.setVisibility(0);
    this.GjX.setVisibility(8);
    eUu();
    this.GjG.eUv();
    AppMethodBeat.o(34159);
  }
  
  private void eUu()
  {
    AppMethodBeat.i(34160);
    this.igQ.setVisibility(8);
    AppMethodBeat.o(34160);
  }
  
  private void fq(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(34161);
    String str;
    if (6 == this.appType)
    {
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(1203L, paramInt2, 1L, false);
      str = this.GjN.gHt;
      if (this.GjN.gHi != 1) {
        break label208;
      }
    }
    label208:
    for (paramInt2 = 7;; paramInt2 = 5)
    {
      str = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { str, Integer.valueOf(paramInt2), Integer.valueOf(this.GjN.gHe), Integer.valueOf(paramInt1), Long.valueOf((ce.asR() - this.drF.field_createTime) / 1000L), this.fyk, this.drF.field_talker, Integer.valueOf(1), "", Long.valueOf(this.drF.field_msgSvrId), Long.valueOf(this.drF.field_createTime) });
      ad.i("MicroMsg.AppAttachDownloadUI", "reportKVStat 14665 %s", new Object[] { str });
      com.tencent.mm.plugin.report.service.h.vKh.kvStat(14665, str);
      AppMethodBeat.o(34161);
      return;
    }
  }
  
  private String getMimeType()
  {
    AppMethodBeat.i(34146);
    k.b localb = k.b.rx(this.duk);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localb.gHf != null)
    {
      localObject1 = localObject2;
      if (localb.gHf.length() > 0) {
        localObject1 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(localb.gHf);
      }
    }
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((String)localObject1).length() != 0) {}
    }
    else
    {
      ad.w("MicroMsg.AppAttachDownloadUI", "getMimeType fail, not a built-in mimetype, use \"*/{fileext}\" instead");
      localObject2 = "*/" + localb.gHf;
    }
    AppMethodBeat.o(34146);
    return localObject2;
  }
  
  private void init()
  {
    AppMethodBeat.i(34131);
    setMMTitle("");
    setActionbarColor(getResources().getColor(2131101179));
    hideActionbarLine();
    if (!eUk())
    {
      finish();
      AppMethodBeat.o(34131);
      return;
    }
    com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(com.tencent.mm.loader.j.b.aij());
    if (!locale.exists()) {
      locale.mkdirs();
    }
    ap.bxS().add(this);
    initView();
    cIm();
    AppMethodBeat.o(34131);
  }
  
  public final void a(String paramString, com.tencent.mm.sdk.e.m paramm)
  {
    AppMethodBeat.i(34149);
    com.tencent.mm.pluginsdk.model.app.c localc = eUp();
    int i;
    StringBuilder localStringBuilder;
    if (localc != null)
    {
      long l1 = localc.field_totalLen;
      long l2 = localc.field_offset;
      this.GjO = l1;
      this.GjI.setText(getString(2131758103, new Object[] { ae.mK(l2), ae.mK(l1) }));
      if (localc.field_totalLen != 0L) {
        break label425;
      }
      i = 0;
      ad.v("MicroMsg.AppAttachDownloadUI", "summerapp attach progress:" + i + " offset:" + l2 + " totallen:" + l1 + " status " + localc.field_status);
      this.GjF.setProgress(i);
      if ((localc.field_status == 199L) && (i >= 100) && (!this.GjQ))
      {
        this.GjQ = true;
        if (this.GjY)
        {
          this.GjY = false;
          eUm();
        }
        if (localc != null)
        {
          localStringBuilder = new StringBuilder().append(getString(2131758120)).append(" : ");
          paramm = localc.field_fileFullPath;
          paramString = paramm;
          if (paramm != null)
          {
            String str = com.tencent.mm.loader.j.b.aic();
            paramm = i.k(paramm, true);
            int j = paramm.indexOf(str);
            paramString = paramm;
            if (j >= 0)
            {
              paramString = paramm.substring(str.length() + j);
              if (!paramString.startsWith("/")) {
                break label445;
              }
            }
          }
        }
      }
    }
    label425:
    label445:
    for (paramString = "/sdcard".concat(String.valueOf(paramString));; paramString = "/sdcard/".concat(String.valueOf(paramString)))
    {
      Toast.makeText(this, paramString, this.GjT).show();
      com.tencent.mm.pluginsdk.ui.tools.a.a(this, localc.field_fileFullPath, this.fyk, this.fileName, 1);
      aq.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(191454);
          AppAttachDownloadUI.F(AppAttachDownloadUI.this);
          AppMethodBeat.o(191454);
        }
      }, 200L);
      if ((this.GjF.getVisibility() != 0) && (i < 100) && (!localc.field_isUpload) && (localc.field_status == 101L))
      {
        ad.i("MicroMsg.AppAttachDownloadUI", "summerapp still downloading updateProgress progress[%d]", new Object[] { Integer.valueOf(i) });
        Yl(0);
        this.GjG.setVisibility(8);
      }
      AppMethodBeat.o(34149);
      return;
      i = (int)(localc.field_offset * 100L / localc.field_totalLen);
      break;
    }
  }
  
  public final MMActivity cjz()
  {
    AppMethodBeat.i(204948);
    MMActivity localMMActivity = (MMActivity)super.getContext();
    AppMethodBeat.o(204948);
    return localMMActivity;
  }
  
  public final void dgf()
  {
    AppMethodBeat.i(34155);
    Toast.makeText(this, 2131758115, 0).show();
    AppMethodBeat.o(34155);
  }
  
  public int getLayoutId()
  {
    return 2131493725;
  }
  
  public void initView()
  {
    AppMethodBeat.i(34139);
    this.uNe = ((MMImageView)findViewById(2131299226));
    this.GjF = ((RoundProgressBtn)findViewById(2131304258));
    this.GjG = new a((Button)findViewById(2131299199), (TextView)findViewById(2131299200));
    this.qho = ((Button)findViewById(2131299212));
    this.GjH = findViewById(2131299201);
    this.igQ = ((TextView)findViewById(2131299208));
    this.GjI = ((TextView)findViewById(2131299202));
    this.GjJ = ((TextView)findViewById(2131299206));
    this.GjK = ((TextView)findViewById(2131299207));
    this.GjW = ((LinearLayout)findViewById(2131299210));
    this.GjX = ((LinearLayout)findViewById(2131301484));
    this.GjJ.setOnTouchListener(this.qhG);
    this.GjJ.setOnLongClickListener(this.qhH);
    if (this.GjJ != null)
    {
      localObject = this.GjJ.getPaint();
      if (localObject != null) {
        ((Paint)localObject).setFakeBoldText(true);
      }
    }
    this.GjF.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(34122);
        AppAttachDownloadUI.a(AppAttachDownloadUI.this, 8);
        AppAttachDownloadUI.r(AppAttachDownloadUI.this).setVisibility(0);
        AppAttachDownloadUI.s(AppAttachDownloadUI.this).setVisibility(8);
        ad.i("MicroMsg.AppAttachDownloadUI", "summerapp roundProgressBar downloadAppAttachScene[%s]", new Object[] { AppAttachDownloadUI.a(AppAttachDownloadUI.this) });
        if (AppAttachDownloadUI.a(AppAttachDownloadUI.this) != null)
        {
          AppAttachDownloadUI.a(AppAttachDownloadUI.this).a(AppAttachDownloadUI.this);
          com.tencent.mm.kernel.g.aeS().a(AppAttachDownloadUI.a(AppAttachDownloadUI.this));
          AppMethodBeat.o(34122);
          return;
        }
        paramAnonymousView = AppAttachDownloadUI.t(AppAttachDownloadUI.this);
        if ((paramAnonymousView != null) && (paramAnonymousView.field_status != 199L))
        {
          ad.i("MicroMsg.AppAttachDownloadUI", "summerapp roundProgressBar onClick but scene is null and set status[%d] paused", new Object[] { Long.valueOf(paramAnonymousView.field_status) });
          paramAnonymousView.field_status = 102L;
          ap.bxS().a(paramAnonymousView, new String[0]);
        }
        AppMethodBeat.o(34122);
      }
    });
    Object localObject = this.GjG;
    View.OnClickListener local11 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(191458);
        AppAttachDownloadUI.a(AppAttachDownloadUI.this, 0);
        AppAttachDownloadUI.r(AppAttachDownloadUI.this).setVisibility(8);
        if (AppAttachDownloadUI.u(AppAttachDownloadUI.this))
        {
          paramAnonymousView = AppAttachDownloadUI.t(AppAttachDownloadUI.this);
          if (paramAnonymousView != null)
          {
            paramAnonymousView.field_status = 101L;
            paramAnonymousView.field_lastModifyTime = bt.aGK();
            ap.bxS().a(paramAnonymousView, new String[0]);
          }
          AppAttachDownloadUI.a(AppAttachDownloadUI.this, new com.tencent.mm.plugin.record.b.e(AppAttachDownloadUI.v(AppAttachDownloadUI.this), AppAttachDownloadUI.w(AppAttachDownloadUI.this), AppAttachDownloadUI.x(AppAttachDownloadUI.this)));
          az.aeS().a(AppAttachDownloadUI.a(AppAttachDownloadUI.this), 0);
        }
        AppMethodBeat.o(191458);
      }
    };
    ((a)localObject).mWp.setOnClickListener(local11);
    this.qho.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(191453);
        AppAttachDownloadUI.D(AppAttachDownloadUI.this);
        AppAttachDownloadUI.E(AppAttachDownloadUI.this);
        AppMethodBeat.o(191453);
      }
    });
    switch (this.appType)
    {
    case 1: 
    case 3: 
    case 5: 
    default: 
      this.uNe.setImageResource(2131689577);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(34114);
          if (AppAttachDownloadUI.a(AppAttachDownloadUI.this) != null) {
            az.aeS().a(AppAttachDownloadUI.a(AppAttachDownloadUI.this));
          }
          if ((AppAttachDownloadUI.b(AppAttachDownloadUI.this) != null) && (AppAttachDownloadUI.b(AppAttachDownloadUI.this).rg(1)))
          {
            AppMethodBeat.o(34114);
            return true;
          }
          AppAttachDownloadUI.this.finish();
          AppMethodBeat.o(34114);
          return true;
        }
      });
      this.drV = getIntent().getBooleanExtra("app_show_share", true);
      if (this.drV) {
        addIconOptionMenu(0, 2131689493, new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(34118);
            AppAttachDownloadUI.a(AppAttachDownloadUI.this, AppAttachDownloadUI.c(AppAttachDownloadUI.this));
            AppMethodBeat.o(34118);
            return false;
          }
        });
      }
      this.GjQ = false;
      if ((!eUl()) || (this.drF.field_msgId != 0L)) {
        break label556;
      }
      this.GjK.setVisibility(8);
      this.GjJ.setVisibility(0);
      if (this.fileName.equals("")) {
        this.GjJ.setText(getString(2131761808));
      }
      break;
    }
    for (;;)
    {
      eUt();
      AppMethodBeat.o(34139);
      return;
      this.uNe.setImageResource(2131230944);
      break;
      this.uNe.setImageResource(2131689581);
      break;
      this.uNe.setImageResource(com.tencent.mm.pluginsdk.model.q.aAJ(this.fyk));
      break;
      if (bt.aGv(this.fyk))
      {
        this.uNe.setImageResource(2131230944);
        break;
      }
      this.uNe.setImageResource(2131689577);
      break;
      this.GjJ.setText(this.fileName);
    }
    label556:
    localObject = eUp();
    int i;
    if ((localObject == null) || (!new com.tencent.mm.vfs.e(((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath).exists()))
    {
      i = 0;
      if (i == 0) {
        break label707;
      }
      ad.i("MicroMsg.AppAttachDownloadUI", "summerapp isCanOpenFile");
      if (this.GjO <= 0L) {
        break label695;
      }
      this.GjK.setVisibility(0);
      this.GjK.setText(getResources().getString(2131759078, new Object[] { ae.mK(this.GjO) }));
    }
    for (;;)
    {
      this.GjQ = true;
      eUq();
      AppMethodBeat.o(34139);
      return;
      if ((((com.tencent.mm.pluginsdk.model.app.c)localObject).cAX()) || ((this.drF.field_isSend == 1) && (((com.tencent.mm.pluginsdk.model.app.c)localObject).field_isUpload)))
      {
        i = 1;
        break;
      }
      i = 0;
      break;
      label695:
      this.GjK.setVisibility(8);
    }
    label707:
    if (this.GjO > 0L)
    {
      this.GjK.setVisibility(0);
      this.GjK.setText(getResources().getString(2131759078, new Object[] { ae.mK(this.GjO) }));
    }
    while (this.GjQ)
    {
      AppMethodBeat.o(34139);
      return;
      this.GjK.setVisibility(8);
    }
    this.GjL = new com.tencent.mm.al.h()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, n paramAnonymousn)
      {
        AppMethodBeat.i(191457);
        if (paramAnonymousInt2 == 0) {}
        for (float f = 0.0F;; f = paramAnonymousInt1 * 100.0F / paramAnonymousInt2)
        {
          if ((paramAnonymousInt1 < paramAnonymousInt2) && (AppAttachDownloadUI.q(AppAttachDownloadUI.this).getVisibility() != 0))
          {
            AppAttachDownloadUI.a(AppAttachDownloadUI.this, 0);
            AppAttachDownloadUI.r(AppAttachDownloadUI.this).setVisibility(8);
          }
          AppAttachDownloadUI.q(AppAttachDownloadUI.this).setProgress((int)f);
          AppMethodBeat.o(191457);
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
      ad.i("MicroMsg.AppAttachDownloadUI", "summerapp progressCallBack[%s], isDownloadFinished[%b], isDownloadStarted[%b]", new Object[] { this.GjL, Boolean.valueOf(this.GjQ), Boolean.valueOf(this.GjR) });
      if ((this.appType == 2) || ((!this.GjQ) && (!this.GjR))) {
        eUn();
      }
      AppMethodBeat.o(34139);
      return;
    case 0: 
    case 6: 
      if (this.GjR)
      {
        this.GjG.setVisibility(0);
        Yl(8);
        this.GjH.setVisibility(8);
        this.qho.setVisibility(8);
        eUu();
        this.GjJ.setVisibility(0);
        if (!this.fileName.equals("")) {
          break label1056;
        }
        this.GjJ.setText(getString(2131761808));
        localObject = getMimeType();
        if ((localObject != null) && (!((String)localObject).equals(""))) {
          break label1070;
        }
        this.igQ.setText(getString(2131758100));
      }
      while (bt.aGv(this.fyk))
      {
        eUu();
        break;
        this.GjG.setVisibility(8);
        break label931;
        this.GjJ.setText(this.fileName);
        break label994;
        this.igQ.setText(getString(2131758101));
      }
    case 7: 
      label931:
      label994:
      if (this.GjR) {
        this.GjG.setVisibility(0);
      }
      for (;;)
      {
        label1056:
        label1070:
        Yl(8);
        this.GjH.setVisibility(8);
        this.qho.setVisibility(8);
        this.GjJ.setVisibility(8);
        eUu();
        this.igQ.setText(getString(2131758101));
        break;
        this.GjG.setVisibility(8);
      }
    }
    Yl(8);
    this.GjH.setVisibility(8);
    if (this.GjR) {
      this.GjG.setVisibility(0);
    }
    for (;;)
    {
      this.qho.setVisibility(8);
      this.GjJ.setVisibility(8);
      eUu();
      break;
      this.GjG.setVisibility(8);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(34148);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.tencent.mm.pluginsdk.ui.tools.a.a(this, paramInt1, paramInt2, paramIntent, this.GjS, 2131758111, 2131758112, 1);
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
    paramContextMenu.add(0, 0, 0, getString(2131755701));
    AppMethodBeat.o(34144);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(34136);
    ap.bxS().remove(this);
    super.onDestroy();
    if (this.CmZ != null) {
      this.CmZ.onDestroy();
    }
    if (this.qhE != null) {
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).d(this.qhE);
    }
    AppMethodBeat.o(34136);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(34140);
    ad.i("MicroMsg.AppAttachDownloadUI", "onKeyDown keyCode %d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt == 4) && (this.CmZ != null) && (this.CmZ.rg(2)))
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
    if (this.CmZ != null)
    {
      this.CmZ.aWa();
      this.CmZ.onDestroy();
    }
    init();
    AppMethodBeat.o(34156);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(34138);
    az.aeS().b(221, this);
    az.aeS().b(728, this);
    super.onPause();
    if (this.CmZ != null) {
      this.CmZ.aWa();
    }
    nv localnv = new nv();
    localnv.dsT.dsU = false;
    nv.a locala = localnv.dsT;
    if (this.drF == null) {}
    for (String str = "";; str = this.drF.field_talker)
    {
      locala.talker = str;
      com.tencent.mm.sdk.b.a.ESL.a(localnv, getMainLooper());
      ad.d("MicroMsg.AppAttachDownloadUI", "AppAttachDownloadUI cancel pause auto download logic");
      AppMethodBeat.o(34138);
      return;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(34137);
    super.onResume();
    az.aeS().a(221, this);
    az.aeS().a(728, this);
    nv localnv = new nv();
    localnv.dsT.dsU = true;
    localnv.dsT.talker = this.drF.field_talker;
    com.tencent.mm.sdk.b.a.ESL.a(localnv, getMainLooper());
    ad.d("MicroMsg.AppAttachDownloadUI", "AppAttachDownloadUI req pause auto download logic");
    this.qho.setEnabled(true);
    if (this.CmZ != null) {
      this.CmZ.aVZ();
    }
    AppMethodBeat.o(34137);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(34154);
    ad.i("MicroMsg.AppAttachDownloadUI", "summerapp onSceneEnd type[%d], [%d, %d, %s]", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramn.getType() != 221) && (paramn.getType() != 728))
    {
      AppMethodBeat.o(34154);
      return;
    }
    if ((paramn.getType() == 728) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = eUp();
      if (paramString == null)
      {
        ad.i("MicroMsg.AppAttachDownloadUI", "summerapp onSceneEnd getAppAttachInfo is null");
        if (paramString != null)
        {
          paramString.field_status = 101L;
          paramString.field_lastModifyTime = bt.aGK();
          ap.bxS().a(paramString, new String[0]);
        }
        this.uZW = new com.tencent.mm.plugin.record.b.e(this.msgId, this.mediaId, this.GjL);
        az.aeS().a(this.uZW, 0);
        AppMethodBeat.o(34154);
        return;
      }
      if (paramString.field_signature == null) {}
      for (paramInt1 = -1;; paramInt1 = paramString.field_signature.length())
      {
        ad.i("MicroMsg.AppAttachDownloadUI", "summerapp onSceneEnd CheckBigFileDownload ok signature len[%d] start NetSceneDownloadAppAttach", new Object[] { Integer.valueOf(paramInt1) });
        break;
      }
    }
    if ((this.uZW == null) && ((paramn instanceof com.tencent.mm.plugin.record.b.e)))
    {
      paramString = (com.tencent.mm.plugin.record.b.e)paramn;
      com.tencent.mm.pluginsdk.model.app.c localc = eUp();
      if ((localc != null) && (!ae.isNullOrNil(localc.field_mediaSvrId)) && (localc.field_mediaSvrId.equals(paramString.getMediaId())))
      {
        this.uZW = paramString;
        ad.i("MicroMsg.AppAttachDownloadUI", "summerapp onSceneEnd reset downloadAppAttachScene[%s] by mediaSvrId[%s]", new Object[] { this.uZW, localc.field_mediaSvrId });
      }
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (this.GjN.type == 6)
      {
        fq(0, 2);
        paramString = eUp();
        if (paramString != null) {
          com.tencent.mm.plugin.report.e.vIY.idkeyStat(1203L, 5L, paramString.field_totalLen, false);
        }
      }
      AppMethodBeat.o(34154);
      return;
    }
    if ((paramInt2 != 0) && (com.tencent.mm.sdk.a.b.eEQ())) {
      Toast.makeText(this, "errCode[" + paramInt2 + "]", 0).show();
    }
    if (paramInt2 == -5103059)
    {
      eUt();
      Yl(8);
      fq(1, 3);
      AppMethodBeat.o(34154);
      return;
    }
    Yl(8);
    this.GjG.setVisibility(0);
    this.GjH.setVisibility(8);
    ad.e("MicroMsg.AppAttachDownloadUI", "summerapp onSceneEnd, download fail, type = " + paramn.getType() + " errType = " + paramInt1 + ", errCode = " + paramInt2);
    AppMethodBeat.o(34154);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
  {
    Button mWp;
    private TextView ss;
    private boolean vbI;
    
    public a(Button paramButton, TextView paramTextView)
    {
      AppMethodBeat.i(34126);
      this.mWp = paramButton;
      this.ss = paramTextView;
      if (paramTextView != null)
      {
        int i = com.tencent.mm.m.g.Zd().getInt("MsgFileExpiredInterval", 432000);
        long l = AppAttachDownloadUI.G(AppAttachDownloadUI.this).field_createTime / 1000L;
        Math.floor((i - ce.lZ(l)) * 1.0D / 86400.0D);
        paramTextView.setText("");
      }
      AppMethodBeat.o(34126);
    }
    
    public final void eUv()
    {
      AppMethodBeat.i(34128);
      ad.i("MicroMsg.AppAttachDownloadUI", "showErrorTip overtime %s", new Object[] { Long.valueOf(AppAttachDownloadUI.G(AppAttachDownloadUI.this).field_msgId) });
      if (this.mWp != null) {
        this.mWp.setVisibility(4);
      }
      if (this.ss != null)
      {
        this.ss.setVisibility(0);
        this.ss.setText(2131759063);
        this.ss.setTextColor(AppAttachDownloadUI.this.getResources().getColor(2131099805));
        AppAttachDownloadUI.H(AppAttachDownloadUI.this).setVisibility(8);
        AppAttachDownloadUI.s(AppAttachDownloadUI.this).setVisibility(8);
        if (!this.vbI)
        {
          this.vbI = true;
          AppAttachDownloadUI.I(AppAttachDownloadUI.this);
        }
      }
      AppMethodBeat.o(34128);
    }
    
    public final void setVisibility(int paramInt)
    {
      AppMethodBeat.i(34127);
      if (this.mWp != null) {
        this.mWp.setVisibility(paramInt);
      }
      if (this.ss != null) {
        this.ss.setVisibility(paramInt);
      }
      AppMethodBeat.o(34127);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppAttachDownloadUI
 * JD-Core Version:    0.7.0.1
 */