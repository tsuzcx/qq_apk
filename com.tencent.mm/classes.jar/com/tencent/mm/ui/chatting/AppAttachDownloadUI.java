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
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.oe;
import com.tencent.mm.g.a.oe.a;
import com.tencent.mm.g.c.dy;
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
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
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
  implements com.tencent.mm.ak.g, e.a, k.a
{
  private com.tencent.mm.ui.chatting.f.a DFr;
  private com.tencent.mm.ak.h HJA;
  private boolean HJB;
  private k.b HJC;
  private long HJD;
  private String HJE;
  private boolean HJF;
  private boolean HJG;
  private boolean HJH;
  private int HJI;
  private boolean HJJ;
  private int HJK;
  private LinearLayout HJL;
  private LinearLayout HJM;
  private boolean HJN;
  private RoundProgressBtn HJu;
  private a HJv;
  private View HJw;
  private TextView HJx;
  private TextView HJy;
  private TextView HJz;
  private int appType;
  private String dng;
  private boolean dpG;
  private bo dpq;
  private String drV;
  private String fBR;
  private String fPC;
  private String fQi;
  private String fileName;
  private String filePath;
  private TextView iGZ;
  private String mediaId;
  private long msgId;
  private String ntk;
  private int nwY;
  private int nwZ;
  private com.tencent.mm.ui.widget.b.a nym;
  private int oqc;
  private n.d pHX;
  private Button qPQ;
  private HandOffFile qQg;
  private View.OnTouchListener qQi;
  private View.OnLongClickListener qQj;
  private int scene;
  private String tBf;
  private MMImageView vVU;
  private com.tencent.mm.plugin.record.b.e wiK;
  
  public AppAttachDownloadUI()
  {
    AppMethodBeat.i(34129);
    this.oqc = 0;
    this.HJF = false;
    this.HJG = false;
    this.HJH = true;
    this.HJI = 5000;
    this.HJJ = false;
    this.HJN = false;
    this.nym = null;
    this.pHX = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(196401);
        ClipboardManager localClipboardManager = (ClipboardManager)ai.getContext().getSystemService("clipboard");
        if (AppAttachDownloadUI.y(AppAttachDownloadUI.this).equals("")) {}
        for (paramAnonymousMenuItem = AppAttachDownloadUI.this.getString(2131761808);; paramAnonymousMenuItem = AppAttachDownloadUI.y(AppAttachDownloadUI.this))
        {
          localClipboardManager.setPrimaryClip(ClipData.newPlainText(null, paramAnonymousMenuItem));
          com.tencent.mm.ui.base.h.cg(AppAttachDownloadUI.this, AppAttachDownloadUI.this.getString(2131755702));
          AppMethodBeat.o(196401);
          return;
        }
      }
    };
    this.qQi = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(196402);
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(196402);
          return false;
          AppAttachDownloadUI.b(AppAttachDownloadUI.this, (int)paramAnonymousMotionEvent.getRawX());
          AppAttachDownloadUI.c(AppAttachDownloadUI.this, (int)paramAnonymousMotionEvent.getRawY());
        }
      }
    };
    this.qQj = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(196394);
        ac.d("MicroMsg.AppAttachDownloadUI", "onLongClick");
        if (AppAttachDownloadUI.z(AppAttachDownloadUI.this) == null) {
          AppAttachDownloadUI.a(AppAttachDownloadUI.this, new com.tencent.mm.ui.widget.b.a(AppAttachDownloadUI.this.crg()));
        }
        AppAttachDownloadUI.z(AppAttachDownloadUI.this).a(paramAnonymousView, AppAttachDownloadUI.this, AppAttachDownloadUI.A(AppAttachDownloadUI.this), AppAttachDownloadUI.B(AppAttachDownloadUI.this), AppAttachDownloadUI.C(AppAttachDownloadUI.this));
        AppMethodBeat.o(196394);
        return true;
      }
    };
    AppMethodBeat.o(34129);
  }
  
  private String aPY(String paramString)
  {
    AppMethodBeat.i(34142);
    String str = paramString;
    if (this.HJB)
    {
      str = paramString;
      if (paramString != null) {
        str = bi.ym(paramString);
      }
    }
    AppMethodBeat.o(34142);
    return str;
  }
  
  private void aaw(int paramInt)
  {
    AppMethodBeat.i(34158);
    if (paramInt != this.HJu.getVisibility())
    {
      ac.i("MicroMsg.AppAttachDownloadUI", "setRoundProgressBar %s %s", new Object[] { Integer.valueOf(paramInt), ae.aNz() });
      this.HJu.setVisibility(paramInt);
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
    com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(paramc.field_fileFullPath);
    if ((locale.exists()) && (locale.length() == paramc.field_totalLen))
    {
      AppMethodBeat.o(34157);
      return true;
    }
    AppMethodBeat.o(34157);
    return false;
  }
  
  private void cVx()
  {
    AppMethodBeat.i(34132);
    this.DFr = new com.tencent.mm.ui.chatting.f.a(new com.tencent.mm.plugin.ball.a.e((MMActivity)super.getContext()));
    this.DFr.h(this.filePath, this.fBR, this.oqc, true);
    this.DFr.lP(this.fBR, this.fileName);
    this.qQg.K(this.DFr.nfN);
    AppMethodBeat.o(34132);
  }
  
  private void drU()
  {
    AppMethodBeat.i(34153);
    ac.i("MicroMsg.AppAttachDownloadUI", "[ImageGalleryUI] showImage");
    Object localObject = new Intent(this, ImageGalleryUI.class);
    ((Intent)localObject).putExtra("img_gallery_msg_id", this.dpq.field_msgId);
    ((Intent)localObject).putExtra("img_gallery_talker", this.dpq.field_talker);
    localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/ui/chatting/AppAttachDownloadUI", "showImage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/AppAttachDownloadUI", "showImage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    overridePendingTransition(0, 0);
    AppMethodBeat.o(34153);
  }
  
  private void fjW()
  {
    AppMethodBeat.i(34133);
    String str1 = ae.nullAsNil(u.axw());
    Object localObject2 = ae.nullAsNil(this.dpq.field_talker);
    Object localObject1 = localObject2;
    if (w.sQ((String)localObject2)) {
      localObject1 = ae.nullAsNil(this.HJC.dng);
    }
    if (this.dpq.field_isSend == 1)
    {
      localObject2 = str1;
      if (this.dpq.field_isSend != 1) {
        break label259;
      }
      label76:
      String str2 = ae.nullAsNil(this.filePath);
      String str3 = this.fBR;
      String str4 = this.fileName;
      String str5 = this.ntk;
      long l = this.HJD;
      String str6 = Long.toString(this.dpq.field_msgSvrId);
      if (ae.isNullOrNil(this.tBf)) {
        break label266;
      }
      str1 = this.tBf;
      label136:
      this.qQg = new HandOffFile(str2, str3, str4, str5, l, str6, "", str1, this.fQi, this.fPC, "", "", (String)localObject2, (String)localObject1);
      boolean bool = b(fkc());
      localObject1 = this.qQg;
      if (!bool) {
        break label275;
      }
    }
    label259:
    label266:
    label275:
    for (int i = 1;; i = 2)
    {
      ((HandOffFile)localObject1).tBg = i;
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).f(this.qQg);
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).c(this.qQg);
      AppMethodBeat.o(34133);
      return;
      localObject2 = localObject1;
      break;
      localObject1 = str1;
      break label76;
      str1 = this.HJE;
      break label136;
    }
  }
  
  private boolean fjX()
  {
    AppMethodBeat.i(34134);
    this.scene = getIntent().getIntExtra("scene", 0);
    this.msgId = getIntent().getLongExtra("app_msg_id", -1L);
    this.HJJ = getIntent().getBooleanExtra("choose_way", false);
    this.HJK = getIntent().getIntExtra("msg_type", 0);
    if (this.msgId == -1L)
    {
      AppMethodBeat.o(34134);
      return false;
    }
    az.ayM();
    this.dpq = com.tencent.mm.model.c.awD().vP(this.msgId);
    if ((this.dpq == null) || (this.dpq.field_msgId == 0L) || (this.dpq.field_content == null))
    {
      if (!fjY()) {
        break label358;
      }
      localObject = (MsgQuoteItem)getIntent().getParcelableExtra("key_quoted_msg");
      if (localObject == null)
      {
        AppMethodBeat.o(34134);
        return false;
      }
      this.dpq = new bo();
      this.dpq.setType(((MsgQuoteItem)localObject).type);
      this.dpq.oz(((MsgQuoteItem)localObject).uVU);
      this.dpq.re(((MsgQuoteItem)localObject).uVV);
      this.dpq.qf(((MsgQuoteItem)localObject).uVY);
      this.dpq.setContent(((MsgQuoteItem)localObject).content);
      if (bs.lr(((MsgQuoteItem)localObject).uVW, u.axw())) {
        this.dpq.jT(1);
      }
    }
    this.HJB = w.sQ(this.dpq.field_talker);
    this.drV = this.dpq.field_content;
    if ((this.HJB) && (this.dpq.field_isSend == 0)) {
      this.drV = aPY(this.dpq.field_content);
    }
    this.HJC = k.b.vA(this.drV);
    if (this.HJC == null)
    {
      ac.e("MicroMsg.AppAttachDownloadUI", "summerapp parse msgContent error, %s", new Object[] { this.drV });
      AppMethodBeat.o(34134);
      return false;
      label358:
      AppMethodBeat.o(34134);
      return false;
    }
    if ((ae.isNullOrNil(this.HJC.cZa)) && (!ae.isNullOrNil(this.HJC.hhU)))
    {
      ac.e("MicroMsg.AppAttachDownloadUI", "summerapp msgContent format error, %s", new Object[] { this.drV });
      this.HJC.cZa = this.HJC.hhU.hashCode();
    }
    this.appType = this.HJC.type;
    this.mediaId = this.HJC.cZa;
    this.fileName = ae.nullAsNil(this.HJC.title);
    this.fBR = ae.nullAsNil(this.HJC.hhG).toLowerCase();
    this.HJD = this.HJC.hhF;
    this.ntk = ae.nullAsNil(this.HJC.filemd5);
    this.dng = ae.nullAsNil(this.HJC.dng);
    this.tBf = ae.nullAsNil(this.HJC.hhU);
    this.HJE = ae.nullAsNil(this.HJC.hhL);
    this.fQi = ae.nullAsNil(this.HJC.fQi);
    this.fPC = ae.nullAsNil(this.HJC.hhR);
    if (ae.isNullOrNil(this.fBR)) {
      this.fBR = i.VW(this.fileName);
    }
    ac.i("MicroMsg.AppAttachDownloadUI", "summerapp initParams msgId[%d], sender[%d], msgContent[%s], appType[%d], mediaId[%s], fileName[%s]", new Object[] { Long.valueOf(this.msgId), Integer.valueOf(this.dpq.field_isSend), this.drV, Integer.valueOf(this.appType), this.mediaId, this.fileName });
    Object localObject = fkc();
    if (localObject == null)
    {
      ac.i("MicroMsg.AppAttachDownloadUI", "summerapp initParams attInfo is null");
      this.HJG = false;
      if (this.HJC.type == 6) {
        ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).T(String.valueOf(this.dpq.field_msgId), this.dpq.field_msgSvrId);
      }
      ft(4, 0);
      fjW();
      if (!b((com.tencent.mm.pluginsdk.model.app.c)localObject)) {
        break label984;
      }
      if (this.scene != 1) {
        break label914;
      }
      this.oqc = 7;
      if (this.HJJ)
      {
        bool = com.tencent.mm.pluginsdk.ui.tools.a.c(this, ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath, this.fBR, this.oqc);
        AppMethodBeat.o(34134);
        return bool;
      }
    }
    else
    {
      this.filePath = ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath;
      new com.tencent.mm.vfs.e(((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath);
      if (((com.tencent.mm.pluginsdk.model.app.c)localObject).field_offset > 0L) {}
      for (this.HJG = true;; this.HJG = false)
      {
        ac.i("MicroMsg.AppAttachDownloadUI", "summerapp initParams attInfo field_fileFullPath[%s], field_offset[%d], isDownloadStarted[%b]", new Object[] { ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath, Long.valueOf(((com.tencent.mm.pluginsdk.model.app.c)localObject).field_offset), Boolean.valueOf(this.HJG) });
        break;
      }
    }
    boolean bool = com.tencent.mm.pluginsdk.ui.tools.a.ae(((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath, this.fBR, this.oqc);
    AppMethodBeat.o(34134);
    return bool;
    label914:
    if (this.oqc != 9) {
      this.oqc = 1;
    }
    if (this.HJJ)
    {
      bool = com.tencent.mm.pluginsdk.ui.tools.a.c(this, ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath, this.fBR, this.oqc);
      AppMethodBeat.o(34134);
      return bool;
    }
    bool = com.tencent.mm.pluginsdk.ui.tools.a.ae(((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath, this.fBR, this.oqc);
    AppMethodBeat.o(34134);
    return bool;
    label984:
    AppMethodBeat.o(34134);
    return true;
  }
  
  private boolean fjY()
  {
    return this.HJK == 1;
  }
  
  private void fjZ()
  {
    AppMethodBeat.i(34141);
    cs localcs = new cs();
    com.tencent.mm.pluginsdk.model.g.e(localcs, this.dpq);
    localcs.dck.activity = this;
    localcs.dck.dcq = 39;
    com.tencent.mm.sdk.b.a.GpY.l(localcs);
    AppMethodBeat.o(34141);
  }
  
  private void fka()
  {
    AppMethodBeat.i(34143);
    aaw(0);
    this.HJv.setVisibility(8);
    if (fkb())
    {
      ac.i("MicroMsg.AppAttachDownloadUI", "startToDownloadFile");
      this.wiK = new com.tencent.mm.plugin.record.b.e(this.msgId, this.mediaId, this.HJA);
      az.agi().a(this.wiK, 0);
      aa.O(this.dpq);
      ft(7, 1);
    }
    AppMethodBeat.o(34143);
  }
  
  private boolean fkb()
  {
    int i = -1;
    boolean bool2 = true;
    AppMethodBeat.i(34145);
    Object localObject1 = fkc();
    Object localObject2;
    boolean bool1;
    long l1;
    long l2;
    long l3;
    String str1;
    long l4;
    if (localObject1 == null)
    {
      com.tencent.mm.pluginsdk.model.app.m.v(this.msgId, this.drV);
      localObject2 = fkc();
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
        ac.i("MicroMsg.AppAttachDownloadUI", "summerapp tryInitAttachInfo newInfo systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], signature len[%d]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), localObject1, Long.valueOf(l3), str1, Long.valueOf(l4), Boolean.valueOf(bool1), Integer.valueOf(i) });
        if (this.HJC.hhJ == 0)
        {
          localObject1 = localObject2;
          bool1 = bool2;
          if (this.HJC.hhF <= 26214400) {}
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
      if ((this.HJC == null) || ((this.HJC.hhJ == 0) && (this.HJC.hhF <= 26214400))) {
        break label569;
      }
      bool1 = false;
    }
    label569:
    for (;;)
    {
      if (!bool1) {
        az.agi().a(new com.tencent.mm.plugin.record.b.c((com.tencent.mm.pluginsdk.model.app.c)localObject1, this.fQi, this.ntk, this.fileName, this.fBR, this.dng), 0);
      }
      if (localObject1 != null)
      {
        this.filePath = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath;
        cVx();
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
        ac.i("MicroMsg.AppAttachDownloadUI", "summerapp tryInitAttachInfo info exist but file not!");
        com.tencent.mm.pluginsdk.model.app.m.v(this.msgId, this.drV);
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
        ac.i("MicroMsg.AppAttachDownloadUI", "summerapp tryInitAttachInfo info exist systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], file.exists[%b], status[%d], signature len[%d]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), str1, Long.valueOf(l3), str2, Long.valueOf(l4), Boolean.valueOf(bool1), Boolean.valueOf(bool3), Long.valueOf(l5), Integer.valueOf(i) });
        bool1 = bool2;
        break;
        i = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_signature.length();
      }
    }
  }
  
  private com.tencent.mm.pluginsdk.model.app.c fkc()
  {
    AppMethodBeat.i(34147);
    final com.tencent.mm.pluginsdk.model.app.c localc1 = com.tencent.mm.pluginsdk.model.app.ap.bEO().zM(this.msgId);
    if (localc1 != null)
    {
      ac.i("MicroMsg.AppAttachDownloadUI", "summerapp getAppAttachInfo by msgId [%d] stack[%s]", new Object[] { Long.valueOf(this.msgId), ae.aNz() });
      AppMethodBeat.o(34147);
      return localc1;
    }
    localc1 = com.tencent.mm.pluginsdk.model.app.m.aGn(this.mediaId);
    if (localc1 == null)
    {
      ac.i("MicroMsg.AppAttachDownloadUI", "summerapp getAppAttachInfo by msgId and mediaId is null stack[%s]", new Object[] { ae.aNz() });
      AppMethodBeat.o(34147);
      return localc1;
    }
    if ((localc1.field_msgInfoId == this.msgId) || (i.eA(localc1.field_fileFullPath)))
    {
      AppMethodBeat.o(34147);
      return localc1;
    }
    com.tencent.mm.pluginsdk.model.app.m.v(this.msgId, this.drV);
    final com.tencent.mm.pluginsdk.model.app.c localc2 = com.tencent.mm.pluginsdk.model.app.ap.bEO().zM(this.msgId);
    if (localc2 == null)
    {
      ac.w("MicroMsg.AppAttachDownloadUI", "summerapp getAppAttachInfo create new info from local but failed stack[%s]", new Object[] { ae.aNz() });
      AppMethodBeat.o(34147);
      return localc1;
    }
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34117);
        long l1 = System.currentTimeMillis();
        long l2 = i.lZ(localc1.field_fileFullPath, localc2.field_fileFullPath);
        if (l2 > 0L)
        {
          localc2.field_offset = l2;
          if (AppAttachDownloadUI.c(localc2)) {
            localc2.field_status = 199L;
          }
        }
        for (boolean bool = com.tencent.mm.pluginsdk.model.app.ap.bEO().a(localc2, new String[0]);; bool = false)
        {
          ac.i("MicroMsg.AppAttachDownloadUI", "summerapp copyAttachFromLocal size[%d], id[%d, %d], ret[%b], new status[%d], take[%d]ms", new Object[] { Long.valueOf(l2), Long.valueOf(localc1.field_msgInfoId), Long.valueOf(localc2.field_msgInfoId), Boolean.valueOf(bool), Long.valueOf(localc2.field_status), Long.valueOf(System.currentTimeMillis() - l1) });
          AppMethodBeat.o(34117);
          return;
        }
      }
    }, "copyAttachFromLocal");
    AppMethodBeat.o(34147);
    return localc1;
  }
  
  private void fkd()
  {
    AppMethodBeat.i(34150);
    switch (this.appType)
    {
    case 1: 
    case 3: 
    case 4: 
    case 5: 
    default: 
      this.qPQ.setVisibility(0);
      aaw(8);
      this.HJw.setVisibility(8);
    }
    for (;;)
    {
      Object localObject;
      if (this.qQg.tBg != 1)
      {
        this.qQg.tBg = 1;
        localObject = fkc();
        if (localObject != null) {
          this.qQg.air(ae.nullAsNil(((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath));
        }
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).f(this.qQg);
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).e(this.qQg);
      }
      AppMethodBeat.o(34150);
      return;
      if (fke()) {
        if (bs.aLM(this.fBR))
        {
          fkf();
        }
        else
        {
          localObject = getMimeType();
          ac.i("MicroMsg.AppAttachDownloadUI", "onDownLoadImpl");
          fkh();
          aaw(8);
          this.HJw.setVisibility(8);
          this.HJv.setVisibility(8);
          this.HJy.setVisibility(0);
          if (this.fileName.equals("")) {
            this.HJy.setText(getString(2131761808));
          }
          for (;;)
          {
            if ((localObject != null) && (!((String)localObject).equals(""))) {
              break label318;
            }
            this.qPQ.setVisibility(8);
            this.iGZ.setText(getString(2131758100));
            break;
            this.HJy.setText(this.fileName);
          }
          label318:
          this.qPQ.setVisibility(0);
          this.iGZ.setText(getString(2131758101));
          continue;
          if (fke())
          {
            drU();
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
  
  private boolean fke()
  {
    AppMethodBeat.i(34151);
    com.tencent.mm.pluginsdk.model.app.c localc = fkc();
    if (localc == null)
    {
      AppMethodBeat.o(34151);
      return true;
    }
    if (i.eA(localc.field_fileFullPath))
    {
      aaw(8);
      this.HJw.setVisibility(8);
      this.HJv.setVisibility(8);
      AppMethodBeat.o(34151);
      return true;
    }
    aaw(8);
    fkg();
    AppMethodBeat.o(34151);
    return false;
  }
  
  private void fkf()
  {
    AppMethodBeat.i(34152);
    Object localObject = fkc();
    if (localObject == null)
    {
      ac.e("MicroMsg.AppAttachDownloadUI", "info == null");
      AppMethodBeat.o(34152);
      return;
    }
    Intent localIntent = new Intent(this, ShowImageUI.class);
    localIntent.putExtra("key_message_id", this.dpq.field_msgId);
    localIntent.putExtra("key_image_path", ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath);
    localIntent.putExtra("key_favorite", true);
    localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/ui/chatting/AppAttachDownloadUI", "showFileImage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/AppAttachDownloadUI", "showFileImage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    AppMethodBeat.o(34152);
  }
  
  private void fkg()
  {
    AppMethodBeat.i(34159);
    this.HJL.setVisibility(0);
    this.HJM.setVisibility(8);
    fkh();
    this.HJv.fki();
    AppMethodBeat.o(34159);
  }
  
  private void fkh()
  {
    AppMethodBeat.i(34160);
    this.iGZ.setVisibility(8);
    AppMethodBeat.o(34160);
  }
  
  private void ft(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(34161);
    String str;
    if (6 == this.appType)
    {
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(1203L, paramInt2, 1L, false);
      str = this.HJC.hhU;
      if (this.HJC.hhJ != 1) {
        break label208;
      }
    }
    label208:
    for (paramInt2 = 7;; paramInt2 = 5)
    {
      str = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { str, Integer.valueOf(paramInt2), Integer.valueOf(this.HJC.hhF), Integer.valueOf(paramInt1), Long.valueOf((ce.azI() - this.dpq.field_createTime) / 1000L), this.fBR, this.dpq.field_talker, Integer.valueOf(1), "", Long.valueOf(this.dpq.field_msgSvrId), Long.valueOf(this.dpq.field_createTime) });
      ac.i("MicroMsg.AppAttachDownloadUI", "reportKVStat 14665 %s", new Object[] { str });
      com.tencent.mm.plugin.report.service.h.wUl.kvStat(14665, str);
      AppMethodBeat.o(34161);
      return;
    }
  }
  
  private String getMimeType()
  {
    AppMethodBeat.i(34146);
    k.b localb = k.b.vA(this.drV);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localb.hhG != null)
    {
      localObject1 = localObject2;
      if (localb.hhG.length() > 0) {
        localObject1 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(localb.hhG);
      }
    }
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((String)localObject1).length() != 0) {}
    }
    else
    {
      ac.w("MicroMsg.AppAttachDownloadUI", "getMimeType fail, not a built-in mimetype, use \"*/{fileext}\" instead");
      localObject2 = "*/" + localb.hhG;
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
    if (!fjX())
    {
      finish();
      AppMethodBeat.o(34131);
      return;
    }
    com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(com.tencent.mm.loader.j.b.apj());
    if (!locale.exists()) {
      locale.mkdirs();
    }
    com.tencent.mm.pluginsdk.model.app.ap.bEO().add(this);
    initView();
    cVx();
    AppMethodBeat.o(34131);
  }
  
  public final void a(String paramString, com.tencent.mm.sdk.e.m paramm)
  {
    AppMethodBeat.i(34149);
    com.tencent.mm.pluginsdk.model.app.c localc = fkc();
    int i;
    StringBuilder localStringBuilder;
    if (localc != null)
    {
      long l1 = localc.field_totalLen;
      long l2 = localc.field_offset;
      this.HJD = l1;
      this.HJx.setText(getString(2131758103, new Object[] { ae.qz(l2), ae.qz(l1) }));
      if (localc.field_totalLen != 0L) {
        break label425;
      }
      i = 0;
      ac.v("MicroMsg.AppAttachDownloadUI", "summerapp attach progress:" + i + " offset:" + l2 + " totallen:" + l1 + " status " + localc.field_status);
      this.HJu.setProgress(i);
      if ((localc.field_status == 199L) && (i >= 100) && (!this.HJF))
      {
        this.HJF = true;
        if (this.HJN)
        {
          this.HJN = false;
          fjZ();
        }
        if (localc != null)
        {
          localStringBuilder = new StringBuilder().append(getString(2131758120)).append(" : ");
          paramm = localc.field_fileFullPath;
          paramString = paramm;
          if (paramm != null)
          {
            String str = com.tencent.mm.loader.j.b.apc();
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
      Toast.makeText(this, paramString, this.HJI).show();
      com.tencent.mm.pluginsdk.ui.tools.a.a(this, localc.field_fileFullPath, this.fBR, this.fileName, 1);
      com.tencent.mm.sdk.platformtools.ap.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(196396);
          AppAttachDownloadUI.F(AppAttachDownloadUI.this);
          AppMethodBeat.o(196396);
        }
      }, 200L);
      if ((this.HJu.getVisibility() != 0) && (i < 100) && (!localc.field_isUpload) && (localc.field_status == 101L))
      {
        ac.i("MicroMsg.AppAttachDownloadUI", "summerapp still downloading updateProgress progress[%d]", new Object[] { Integer.valueOf(i) });
        aaw(0);
        this.HJv.setVisibility(8);
      }
      AppMethodBeat.o(34149);
      return;
      i = (int)(localc.field_offset * 100L / localc.field_totalLen);
      break;
    }
  }
  
  public final MMActivity crg()
  {
    AppMethodBeat.i(210128);
    MMActivity localMMActivity = (MMActivity)super.getContext();
    AppMethodBeat.o(210128);
    return localMMActivity;
  }
  
  public final void dtM()
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
    this.vVU = ((MMImageView)findViewById(2131299226));
    this.HJu = ((RoundProgressBtn)findViewById(2131304258));
    this.HJv = new a((Button)findViewById(2131299199), (TextView)findViewById(2131299200));
    this.qPQ = ((Button)findViewById(2131299212));
    this.HJw = findViewById(2131299201);
    this.iGZ = ((TextView)findViewById(2131299208));
    this.HJx = ((TextView)findViewById(2131299202));
    this.HJy = ((TextView)findViewById(2131299206));
    this.HJz = ((TextView)findViewById(2131299207));
    this.HJL = ((LinearLayout)findViewById(2131299210));
    this.HJM = ((LinearLayout)findViewById(2131301484));
    this.HJy.setOnTouchListener(this.qQi);
    this.HJy.setOnLongClickListener(this.qQj);
    if (this.HJy != null)
    {
      localObject = this.HJy.getPaint();
      if (localObject != null) {
        ((Paint)localObject).setFakeBoldText(true);
      }
    }
    this.HJu.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(34122);
        AppAttachDownloadUI.a(AppAttachDownloadUI.this, 8);
        AppAttachDownloadUI.r(AppAttachDownloadUI.this).setVisibility(0);
        AppAttachDownloadUI.s(AppAttachDownloadUI.this).setVisibility(8);
        ac.i("MicroMsg.AppAttachDownloadUI", "summerapp roundProgressBar downloadAppAttachScene[%s]", new Object[] { AppAttachDownloadUI.a(AppAttachDownloadUI.this) });
        if (AppAttachDownloadUI.a(AppAttachDownloadUI.this) != null)
        {
          AppAttachDownloadUI.a(AppAttachDownloadUI.this).a(AppAttachDownloadUI.this);
          com.tencent.mm.kernel.g.agi().a(AppAttachDownloadUI.a(AppAttachDownloadUI.this));
          AppMethodBeat.o(34122);
          return;
        }
        paramAnonymousView = AppAttachDownloadUI.t(AppAttachDownloadUI.this);
        if ((paramAnonymousView != null) && (paramAnonymousView.field_status != 199L))
        {
          ac.i("MicroMsg.AppAttachDownloadUI", "summerapp roundProgressBar onClick but scene is null and set status[%d] paused", new Object[] { Long.valueOf(paramAnonymousView.field_status) });
          paramAnonymousView.field_status = 102L;
          com.tencent.mm.pluginsdk.model.app.ap.bEO().a(paramAnonymousView, new String[0]);
        }
        AppMethodBeat.o(34122);
      }
    });
    Object localObject = this.HJv;
    View.OnClickListener local11 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(196400);
        AppAttachDownloadUI.a(AppAttachDownloadUI.this, 0);
        AppAttachDownloadUI.r(AppAttachDownloadUI.this).setVisibility(8);
        if (AppAttachDownloadUI.u(AppAttachDownloadUI.this))
        {
          paramAnonymousView = AppAttachDownloadUI.t(AppAttachDownloadUI.this);
          if (paramAnonymousView != null)
          {
            paramAnonymousView.field_status = 101L;
            paramAnonymousView.field_lastModifyTime = bs.aNx();
            com.tencent.mm.pluginsdk.model.app.ap.bEO().a(paramAnonymousView, new String[0]);
          }
          AppAttachDownloadUI.a(AppAttachDownloadUI.this, new com.tencent.mm.plugin.record.b.e(AppAttachDownloadUI.v(AppAttachDownloadUI.this), AppAttachDownloadUI.w(AppAttachDownloadUI.this), AppAttachDownloadUI.x(AppAttachDownloadUI.this)));
          az.agi().a(AppAttachDownloadUI.a(AppAttachDownloadUI.this), 0);
        }
        AppMethodBeat.o(196400);
      }
    };
    ((a)localObject).nyO.setOnClickListener(local11);
    this.qPQ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(196395);
        AppAttachDownloadUI.D(AppAttachDownloadUI.this);
        AppAttachDownloadUI.E(AppAttachDownloadUI.this);
        AppMethodBeat.o(196395);
      }
    });
    switch (this.appType)
    {
    case 1: 
    case 3: 
    case 5: 
    default: 
      this.vVU.setImageResource(2131689577);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(34114);
          if (AppAttachDownloadUI.a(AppAttachDownloadUI.this) != null) {
            az.agi().a(AppAttachDownloadUI.a(AppAttachDownloadUI.this));
          }
          if ((AppAttachDownloadUI.b(AppAttachDownloadUI.this) != null) && (AppAttachDownloadUI.b(AppAttachDownloadUI.this).rT(1)))
          {
            AppMethodBeat.o(34114);
            return true;
          }
          AppAttachDownloadUI.this.finish();
          AppMethodBeat.o(34114);
          return true;
        }
      });
      this.dpG = getIntent().getBooleanExtra("app_show_share", true);
      if (this.dpG) {
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
      this.HJF = false;
      if ((!fjY()) || (this.dpq.field_msgId != 0L)) {
        break label556;
      }
      this.HJz.setVisibility(8);
      this.HJy.setVisibility(0);
      if (this.fileName.equals("")) {
        this.HJy.setText(getString(2131761808));
      }
      break;
    }
    for (;;)
    {
      fkg();
      AppMethodBeat.o(34139);
      return;
      this.vVU.setImageResource(2131230944);
      break;
      this.vVU.setImageResource(2131689581);
      break;
      this.vVU.setImageResource(com.tencent.mm.pluginsdk.model.q.aGb(this.fBR));
      break;
      if (bs.aLM(this.fBR))
      {
        this.vVU.setImageResource(2131230944);
        break;
      }
      this.vVU.setImageResource(2131689577);
      break;
      this.HJy.setText(this.fileName);
    }
    label556:
    localObject = fkc();
    int i;
    if ((localObject == null) || (!new com.tencent.mm.vfs.e(((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath).exists()))
    {
      i = 0;
      if (i == 0) {
        break label707;
      }
      ac.i("MicroMsg.AppAttachDownloadUI", "summerapp isCanOpenFile");
      if (this.HJD <= 0L) {
        break label695;
      }
      this.HJz.setVisibility(0);
      this.HJz.setText(getResources().getString(2131759078, new Object[] { ae.qz(this.HJD) }));
    }
    for (;;)
    {
      this.HJF = true;
      fkd();
      AppMethodBeat.o(34139);
      return;
      if ((((com.tencent.mm.pluginsdk.model.app.c)localObject).cOg()) || ((this.dpq.field_isSend == 1) && (((com.tencent.mm.pluginsdk.model.app.c)localObject).field_isUpload)))
      {
        i = 1;
        break;
      }
      i = 0;
      break;
      label695:
      this.HJz.setVisibility(8);
    }
    label707:
    if (this.HJD > 0L)
    {
      this.HJz.setVisibility(0);
      this.HJz.setText(getResources().getString(2131759078, new Object[] { ae.qz(this.HJD) }));
    }
    while (this.HJF)
    {
      AppMethodBeat.o(34139);
      return;
      this.HJz.setVisibility(8);
    }
    this.HJA = new com.tencent.mm.ak.h()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, n paramAnonymousn)
      {
        AppMethodBeat.i(196399);
        if (paramAnonymousInt2 == 0) {}
        for (float f = 0.0F;; f = paramAnonymousInt1 * 100.0F / paramAnonymousInt2)
        {
          if ((paramAnonymousInt1 < paramAnonymousInt2) && (AppAttachDownloadUI.q(AppAttachDownloadUI.this).getVisibility() != 0))
          {
            AppAttachDownloadUI.a(AppAttachDownloadUI.this, 0);
            AppAttachDownloadUI.r(AppAttachDownloadUI.this).setVisibility(8);
          }
          AppAttachDownloadUI.q(AppAttachDownloadUI.this).setProgress((int)f);
          AppMethodBeat.o(196399);
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
      ac.i("MicroMsg.AppAttachDownloadUI", "summerapp progressCallBack[%s], isDownloadFinished[%b], isDownloadStarted[%b]", new Object[] { this.HJA, Boolean.valueOf(this.HJF), Boolean.valueOf(this.HJG) });
      if ((this.appType == 2) || ((!this.HJF) && (!this.HJG))) {
        fka();
      }
      AppMethodBeat.o(34139);
      return;
    case 0: 
    case 6: 
      if (this.HJG)
      {
        this.HJv.setVisibility(0);
        aaw(8);
        this.HJw.setVisibility(8);
        this.qPQ.setVisibility(8);
        fkh();
        this.HJy.setVisibility(0);
        if (!this.fileName.equals("")) {
          break label1056;
        }
        this.HJy.setText(getString(2131761808));
        localObject = getMimeType();
        if ((localObject != null) && (!((String)localObject).equals(""))) {
          break label1070;
        }
        this.iGZ.setText(getString(2131758100));
      }
      while (bs.aLM(this.fBR))
      {
        fkh();
        break;
        this.HJv.setVisibility(8);
        break label931;
        this.HJy.setText(this.fileName);
        break label994;
        this.iGZ.setText(getString(2131758101));
      }
    case 7: 
      label931:
      label994:
      if (this.HJG) {
        this.HJv.setVisibility(0);
      }
      for (;;)
      {
        label1056:
        label1070:
        aaw(8);
        this.HJw.setVisibility(8);
        this.qPQ.setVisibility(8);
        this.HJy.setVisibility(8);
        fkh();
        this.iGZ.setText(getString(2131758101));
        break;
        this.HJv.setVisibility(8);
      }
    }
    aaw(8);
    this.HJw.setVisibility(8);
    if (this.HJG) {
      this.HJv.setVisibility(0);
    }
    for (;;)
    {
      this.qPQ.setVisibility(8);
      this.HJy.setVisibility(8);
      fkh();
      break;
      this.HJv.setVisibility(8);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(34148);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.tencent.mm.pluginsdk.ui.tools.a.a(this, paramInt1, paramInt2, paramIntent, this.HJH, 2131758111, 2131758112, 1);
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
    com.tencent.mm.pluginsdk.model.app.ap.bEO().remove(this);
    super.onDestroy();
    if (this.DFr != null) {
      this.DFr.onDestroy();
    }
    if (this.qQg != null) {
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).d(this.qQg);
    }
    AppMethodBeat.o(34136);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(34140);
    ac.i("MicroMsg.AppAttachDownloadUI", "onKeyDown keyCode %d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt == 4) && (this.DFr != null) && (this.DFr.rT(2)))
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
    if (this.DFr != null)
    {
      this.DFr.bcY();
      this.DFr.onDestroy();
    }
    init();
    AppMethodBeat.o(34156);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(34138);
    az.agi().b(221, this);
    az.agi().b(728, this);
    super.onPause();
    if (this.DFr != null) {
      this.DFr.bcY();
    }
    oe localoe = new oe();
    localoe.dqD.dqE = false;
    oe.a locala = localoe.dqD;
    if (this.dpq == null) {}
    for (String str = "";; str = this.dpq.field_talker)
    {
      locala.talker = str;
      com.tencent.mm.sdk.b.a.GpY.a(localoe, getMainLooper());
      ac.d("MicroMsg.AppAttachDownloadUI", "AppAttachDownloadUI cancel pause auto download logic");
      AppMethodBeat.o(34138);
      return;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(34137);
    super.onResume();
    az.agi().a(221, this);
    az.agi().a(728, this);
    oe localoe = new oe();
    localoe.dqD.dqE = true;
    localoe.dqD.talker = this.dpq.field_talker;
    com.tencent.mm.sdk.b.a.GpY.a(localoe, getMainLooper());
    ac.d("MicroMsg.AppAttachDownloadUI", "AppAttachDownloadUI req pause auto download logic");
    this.qPQ.setEnabled(true);
    if (this.DFr != null) {
      this.DFr.bcX();
    }
    AppMethodBeat.o(34137);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(34154);
    ac.i("MicroMsg.AppAttachDownloadUI", "summerapp onSceneEnd type[%d], [%d, %d, %s]", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramn.getType() != 221) && (paramn.getType() != 728))
    {
      AppMethodBeat.o(34154);
      return;
    }
    if ((paramn.getType() == 728) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = fkc();
      if (paramString == null)
      {
        ac.i("MicroMsg.AppAttachDownloadUI", "summerapp onSceneEnd getAppAttachInfo is null");
        if (paramString != null)
        {
          paramString.field_status = 101L;
          paramString.field_lastModifyTime = bs.aNx();
          com.tencent.mm.pluginsdk.model.app.ap.bEO().a(paramString, new String[0]);
        }
        this.wiK = new com.tencent.mm.plugin.record.b.e(this.msgId, this.mediaId, this.HJA);
        az.agi().a(this.wiK, 0);
        AppMethodBeat.o(34154);
        return;
      }
      if (paramString.field_signature == null) {}
      for (paramInt1 = -1;; paramInt1 = paramString.field_signature.length())
      {
        ac.i("MicroMsg.AppAttachDownloadUI", "summerapp onSceneEnd CheckBigFileDownload ok signature len[%d] start NetSceneDownloadAppAttach", new Object[] { Integer.valueOf(paramInt1) });
        break;
      }
    }
    if ((this.wiK == null) && ((paramn instanceof com.tencent.mm.plugin.record.b.e)))
    {
      paramString = (com.tencent.mm.plugin.record.b.e)paramn;
      com.tencent.mm.pluginsdk.model.app.c localc = fkc();
      if ((localc != null) && (!ae.isNullOrNil(localc.field_mediaSvrId)) && (localc.field_mediaSvrId.equals(paramString.getMediaId())))
      {
        this.wiK = paramString;
        ac.i("MicroMsg.AppAttachDownloadUI", "summerapp onSceneEnd reset downloadAppAttachScene[%s] by mediaSvrId[%s]", new Object[] { this.wiK, localc.field_mediaSvrId });
      }
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (this.HJC.type == 6)
      {
        ft(0, 2);
        paramString = fkc();
        if (paramString != null) {
          com.tencent.mm.plugin.report.e.wTc.idkeyStat(1203L, 5L, paramString.field_totalLen, false);
        }
      }
      AppMethodBeat.o(34154);
      return;
    }
    if ((paramInt2 != 0) && (com.tencent.mm.sdk.a.b.eUk())) {
      Toast.makeText(this, "errCode[" + paramInt2 + "]", 0).show();
    }
    if (paramInt2 == -5103059)
    {
      fkg();
      aaw(8);
      ft(1, 3);
      AppMethodBeat.o(34154);
      return;
    }
    aaw(8);
    this.HJv.setVisibility(0);
    this.HJw.setVisibility(8);
    ac.e("MicroMsg.AppAttachDownloadUI", "summerapp onSceneEnd, download fail, type = " + paramn.getType() + " errType = " + paramInt1 + ", errCode = " + paramInt2);
    AppMethodBeat.o(34154);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
  {
    Button nyO;
    private TextView tr;
    private boolean wkw;
    
    public a(Button paramButton, TextView paramTextView)
    {
      AppMethodBeat.i(34126);
      this.nyO = paramButton;
      this.tr = paramTextView;
      if (paramTextView != null)
      {
        int i = com.tencent.mm.m.g.ZY().getInt("MsgFileExpiredInterval", 432000);
        long l = AppAttachDownloadUI.G(AppAttachDownloadUI.this).field_createTime / 1000L;
        Math.floor((i - ce.pN(l)) * 1.0D / 86400.0D);
        paramTextView.setText("");
      }
      AppMethodBeat.o(34126);
    }
    
    public final void fki()
    {
      AppMethodBeat.i(34128);
      ac.i("MicroMsg.AppAttachDownloadUI", "showErrorTip overtime %s", new Object[] { Long.valueOf(AppAttachDownloadUI.G(AppAttachDownloadUI.this).field_msgId) });
      if (this.nyO != null) {
        this.nyO.setVisibility(4);
      }
      if (this.tr != null)
      {
        this.tr.setVisibility(0);
        this.tr.setText(2131759063);
        this.tr.setTextColor(AppAttachDownloadUI.this.getResources().getColor(2131099805));
        AppAttachDownloadUI.H(AppAttachDownloadUI.this).setVisibility(8);
        AppAttachDownloadUI.s(AppAttachDownloadUI.this).setVisibility(8);
        if (!this.wkw)
        {
          this.wkw = true;
          AppAttachDownloadUI.I(AppAttachDownloadUI.this);
        }
      }
      AppMethodBeat.o(34128);
    }
    
    public final void setVisibility(int paramInt)
    {
      AppMethodBeat.i(34127);
      if (this.nyO != null) {
        this.nyO.setVisibility(paramInt);
      }
      if (this.tr != null) {
        this.tr.setVisibility(paramInt);
      }
      AppMethodBeat.o(34127);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppAttachDownloadUI
 * JD-Core Version:    0.7.0.1
 */