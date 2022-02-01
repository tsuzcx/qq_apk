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
import com.tencent.mm.g.a.cw;
import com.tencent.mm.g.a.oo;
import com.tencent.mm.g.a.oo.a;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.ch;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.modelsimple.ab;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.msgquote.model.MsgQuoteItem;
import com.tencent.mm.plugin.record.b.f.a;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.tools.ShowImageUI;
import com.tencent.mm.ui.widget.progress.RoundProgressBtn;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;

public class AppAttachDownloadUI
  extends MMActivity
  implements com.tencent.mm.ak.f, f.a, k.a
{
  private com.tencent.mm.ui.chatting.g.a FCU;
  private RoundProgressBtn JSb;
  private a JSc;
  private View JSd;
  private TextView JSe;
  private TextView JSf;
  private TextView JSg;
  private com.tencent.mm.ak.g JSh;
  private boolean JSi;
  private k.b JSj;
  private long JSk;
  private String JSl;
  private boolean JSm;
  private boolean JSn;
  private boolean JSo;
  private int JSp;
  private boolean JSq;
  private int JSr;
  private LinearLayout JSs;
  private LinearLayout JSt;
  private boolean JSu;
  private int appType;
  private bv dCi;
  private boolean dCy;
  private String dEU;
  private String dzZ;
  private String fXl;
  private String fileName;
  private String filePath;
  private String glu;
  private String gmb;
  private TextView jdb;
  private String mediaId;
  private long msgId;
  private String nZM;
  private int oZZ;
  private int oef;
  private int oeg;
  private com.tencent.mm.ui.widget.b.a ofu;
  private n.e qsh;
  private Button rIb;
  private HandOffFile rIr;
  private View.OnTouchListener rIt;
  private View.OnLongClickListener rIu;
  private int scene;
  private String uPt;
  private com.tencent.mm.plugin.record.b.f xGr;
  private MMImageView xtC;
  
  public AppAttachDownloadUI()
  {
    AppMethodBeat.i(34129);
    this.oZZ = 0;
    this.JSm = false;
    this.JSn = false;
    this.JSo = true;
    this.JSp = 5000;
    this.JSq = false;
    this.JSu = false;
    this.ofu = null;
    this.qsh = new n.e()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(187116);
        ClipboardManager localClipboardManager = (ClipboardManager)ak.getContext().getSystemService("clipboard");
        if (AppAttachDownloadUI.z(AppAttachDownloadUI.this).equals("")) {}
        for (paramAnonymousMenuItem = AppAttachDownloadUI.this.getString(2131761808);; paramAnonymousMenuItem = AppAttachDownloadUI.z(AppAttachDownloadUI.this))
        {
          localClipboardManager.setPrimaryClip(ClipData.newPlainText(null, paramAnonymousMenuItem));
          h.cm(AppAttachDownloadUI.this, AppAttachDownloadUI.this.getString(2131755702));
          AppMethodBeat.o(187116);
          return;
        }
      }
    };
    this.rIt = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(187117);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/AppAttachDownloadUI$9", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/chatting/AppAttachDownloadUI$9", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(187117);
          return false;
          AppAttachDownloadUI.b(AppAttachDownloadUI.this, (int)paramAnonymousMotionEvent.getRawX());
          AppAttachDownloadUI.c(AppAttachDownloadUI.this, (int)paramAnonymousMotionEvent.getRawY());
        }
      }
    };
    this.rIu = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(187109);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/AppAttachDownloadUI$10", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahF());
        ae.d("MicroMsg.AppAttachDownloadUI", "onLongClick");
        if (AppAttachDownloadUI.A(AppAttachDownloadUI.this) == null) {
          AppAttachDownloadUI.a(AppAttachDownloadUI.this, new com.tencent.mm.ui.widget.b.a(AppAttachDownloadUI.this.cyr()));
        }
        AppAttachDownloadUI.A(AppAttachDownloadUI.this).a(paramAnonymousView, AppAttachDownloadUI.this, AppAttachDownloadUI.B(AppAttachDownloadUI.this), AppAttachDownloadUI.C(AppAttachDownloadUI.this), AppAttachDownloadUI.D(AppAttachDownloadUI.this));
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/chatting/AppAttachDownloadUI$10", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(187109);
        return true;
      }
    };
    AppMethodBeat.o(34129);
  }
  
  private String aXp(String paramString)
  {
    AppMethodBeat.i(34142);
    String str = paramString;
    if (this.JSi)
    {
      str = paramString;
      if (paramString != null) {
        str = bl.BN(paramString);
      }
    }
    AppMethodBeat.o(34142);
    return str;
  }
  
  private void ado(int paramInt)
  {
    AppMethodBeat.i(34158);
    if (paramInt != this.JSb.getVisibility())
    {
      ae.i("MicroMsg.AppAttachDownloadUI", "setRoundProgressBar %s %s", new Object[] { Integer.valueOf(paramInt), af.aRk() });
      this.JSb.setVisibility(paramInt);
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
    k localk = new k(paramc.field_fileFullPath);
    if ((localk.exists()) && (localk.length() == paramc.field_totalLen))
    {
      AppMethodBeat.o(34157);
      return true;
    }
    AppMethodBeat.o(34157);
    return false;
  }
  
  private void dFJ()
  {
    AppMethodBeat.i(34153);
    ae.i("MicroMsg.AppAttachDownloadUI", "[ImageGalleryUI] showImage");
    Object localObject = new Intent(this, ImageGalleryUI.class);
    ((Intent)localObject).putExtra("img_gallery_msg_id", this.dCi.field_msgId);
    ((Intent)localObject).putExtra("img_gallery_talker", this.dCi.field_talker);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/chatting/AppAttachDownloadUI", "showImage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/AppAttachDownloadUI", "showImage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    overridePendingTransition(0, 0);
    AppMethodBeat.o(34153);
  }
  
  private void dhA()
  {
    AppMethodBeat.i(34132);
    this.FCU = new com.tencent.mm.ui.chatting.g.a(new com.tencent.mm.plugin.ball.a.e((MMActivity)super.getContext()));
    this.FCU.h(this.filePath, this.fXl, this.oZZ, true);
    this.FCU.mu(this.fXl, this.fileName);
    this.rIr.N(this.FCU.nLK);
    AppMethodBeat.o(34132);
  }
  
  private void fEn()
  {
    AppMethodBeat.i(34133);
    String str1 = af.nullAsNil(v.aAC());
    Object localObject2 = af.nullAsNil(this.dCi.field_talker);
    Object localObject1 = localObject2;
    if (x.wb((String)localObject2)) {
      localObject1 = af.nullAsNil(this.JSj.dzZ);
    }
    if (this.dCi.field_isSend == 1)
    {
      localObject2 = str1;
      if (this.dCi.field_isSend != 1) {
        break label259;
      }
      label76:
      String str2 = af.nullAsNil(this.filePath);
      String str3 = this.fXl;
      String str4 = this.fileName;
      String str5 = this.nZM;
      long l = this.JSk;
      String str6 = Long.toString(this.dCi.field_msgSvrId);
      if (af.isNullOrNil(this.uPt)) {
        break label266;
      }
      str1 = this.uPt;
      label136:
      this.rIr = new HandOffFile(str2, str3, str4, str5, l, str6, "", str1, this.gmb, this.glu, "", "", (String)localObject2, (String)localObject1);
      boolean bool = b(fEt());
      localObject1 = this.rIr;
      if (!bool) {
        break label275;
      }
    }
    label259:
    label266:
    label275:
    for (int i = 1;; i = 2)
    {
      ((HandOffFile)localObject1).uPu = i;
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).g(this.rIr);
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).c(this.rIr);
      AppMethodBeat.o(34133);
      return;
      localObject2 = localObject1;
      break;
      localObject1 = str1;
      break label76;
      str1 = this.JSl;
      break label136;
    }
  }
  
  private boolean fEo()
  {
    AppMethodBeat.i(34134);
    this.scene = getIntent().getIntExtra("scene", 0);
    this.msgId = getIntent().getLongExtra("app_msg_id", -1L);
    this.JSq = getIntent().getBooleanExtra("choose_way", false);
    this.JSr = getIntent().getIntExtra("msg_type", 0);
    if (this.msgId == -1L)
    {
      AppMethodBeat.o(34134);
      return false;
    }
    bc.aCg();
    this.dCi = com.tencent.mm.model.c.azI().ys(this.msgId);
    if ((this.dCi == null) || (this.dCi.field_msgId == 0L) || (this.dCi.field_content == null))
    {
      if (!fEp()) {
        break label358;
      }
      localObject = (MsgQuoteItem)getIntent().getParcelableExtra("key_quoted_msg");
      if (localObject == null)
      {
        AppMethodBeat.o(34134);
        return false;
      }
      this.dCi = new bv();
      this.dCi.setType(((MsgQuoteItem)localObject).type);
      this.dCi.qM(((MsgQuoteItem)localObject).wlg);
      this.dCi.ui(((MsgQuoteItem)localObject).wlh);
      this.dCi.tk(((MsgQuoteItem)localObject).wlk);
      this.dCi.setContent(((MsgQuoteItem)localObject).content);
      if (bu.lX(((MsgQuoteItem)localObject).wli, v.aAC())) {
        this.dCi.kt(1);
      }
    }
    this.JSi = x.wb(this.dCi.field_talker);
    this.dEU = this.dCi.field_content;
    if ((this.JSi) && (this.dCi.field_isSend == 0)) {
      this.dEU = aXp(this.dCi.field_content);
    }
    this.JSj = k.b.zb(this.dEU);
    if (this.JSj == null)
    {
      ae.e("MicroMsg.AppAttachDownloadUI", "summerapp parse msgContent error, %s", new Object[] { this.dEU });
      AppMethodBeat.o(34134);
      return false;
      label358:
      AppMethodBeat.o(34134);
      return false;
    }
    if ((af.isNullOrNil(this.JSj.dlu)) && (!af.isNullOrNil(this.JSj.hCR)))
    {
      ae.e("MicroMsg.AppAttachDownloadUI", "summerapp msgContent format error, %s", new Object[] { this.dEU });
      this.JSj.dlu = this.JSj.hCR.hashCode();
    }
    this.appType = this.JSj.type;
    this.mediaId = this.JSj.dlu;
    this.fileName = af.nullAsNil(this.JSj.title);
    this.fXl = af.nullAsNil(this.JSj.hCD).toLowerCase();
    this.JSk = this.JSj.hCC;
    this.nZM = af.nullAsNil(this.JSj.filemd5);
    this.dzZ = af.nullAsNil(this.JSj.dzZ);
    this.uPt = af.nullAsNil(this.JSj.hCR);
    this.JSl = af.nullAsNil(this.JSj.hCI);
    this.gmb = af.nullAsNil(this.JSj.gmb);
    this.glu = af.nullAsNil(this.JSj.hCO);
    if (af.isNullOrNil(this.fXl)) {
      this.fXl = o.aaw(this.fileName);
    }
    ae.i("MicroMsg.AppAttachDownloadUI", "summerapp initParams msgId[%d], sender[%d], msgContent[%s], appType[%d], mediaId[%s], fileName[%s]", new Object[] { Long.valueOf(this.msgId), Integer.valueOf(this.dCi.field_isSend), this.dEU, Integer.valueOf(this.appType), this.mediaId, this.fileName });
    Object localObject = fEt();
    if (localObject == null)
    {
      ae.i("MicroMsg.AppAttachDownloadUI", "summerapp initParams attInfo is null");
      this.JSn = false;
      if (this.JSj.type == 6) {
        ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).aa(String.valueOf(this.dCi.field_msgId), this.dCi.field_msgSvrId);
      }
      fz(4, 0);
      fEn();
      if (!b((com.tencent.mm.pluginsdk.model.app.c)localObject)) {
        break label998;
      }
      if (this.scene != 1) {
        break label914;
      }
      this.oZZ = 7;
      if (this.JSq)
      {
        bool = com.tencent.mm.pluginsdk.ui.tools.a.c(this, ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath, this.fXl, this.oZZ);
        AppMethodBeat.o(34134);
        return bool;
      }
    }
    else
    {
      this.filePath = ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath;
      new k(((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath);
      if (((com.tencent.mm.pluginsdk.model.app.c)localObject).field_offset > 0L) {}
      for (this.JSn = true;; this.JSn = false)
      {
        ae.i("MicroMsg.AppAttachDownloadUI", "summerapp initParams attInfo field_fileFullPath[%s], field_offset[%d], isDownloadStarted[%b]", new Object[] { ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath, Long.valueOf(((com.tencent.mm.pluginsdk.model.app.c)localObject).field_offset), Boolean.valueOf(this.JSn) });
        break;
      }
    }
    boolean bool = com.tencent.mm.pluginsdk.ui.tools.a.ak(((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath, this.fXl, this.oZZ);
    AppMethodBeat.o(34134);
    return bool;
    label914:
    if (this.oZZ != 9) {
      this.oZZ = 1;
    }
    if (this.JSq)
    {
      bool = com.tencent.mm.pluginsdk.ui.tools.a.c(this, ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath, this.fXl, this.oZZ);
      AppMethodBeat.o(34134);
      return bool;
    }
    if (!com.tencent.mm.pluginsdk.ui.tools.a.lG(((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath, this.fXl))
    {
      bool = com.tencent.mm.pluginsdk.ui.tools.a.ak(((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath, this.fXl, this.oZZ);
      AppMethodBeat.o(34134);
      return bool;
    }
    label998:
    AppMethodBeat.o(34134);
    return true;
  }
  
  private boolean fEp()
  {
    return this.JSr == 1;
  }
  
  private void fEq()
  {
    AppMethodBeat.i(34141);
    cw localcw = new cw();
    com.tencent.mm.pluginsdk.model.g.e(localcw, this.dCi);
    localcw.doL.activity = this;
    localcw.doL.doR = 39;
    com.tencent.mm.sdk.b.a.IvT.l(localcw);
    AppMethodBeat.o(34141);
  }
  
  private void fEr()
  {
    AppMethodBeat.i(34143);
    ado(0);
    this.JSc.setVisibility(8);
    if (fEs())
    {
      ae.i("MicroMsg.AppAttachDownloadUI", "startToDownloadFile");
      this.xGr = new com.tencent.mm.plugin.record.b.f(this.msgId, this.mediaId, this.JSh);
      bc.ajj().a(this.xGr, 0);
      ab.R(this.dCi);
      fz(7, 1);
    }
    AppMethodBeat.o(34143);
  }
  
  private boolean fEs()
  {
    int i = -1;
    boolean bool2 = true;
    AppMethodBeat.i(34145);
    Object localObject1 = fEt();
    Object localObject2;
    boolean bool1;
    long l1;
    long l2;
    long l3;
    String str1;
    long l4;
    if (localObject1 == null)
    {
      com.tencent.mm.pluginsdk.model.app.m.z(this.msgId, this.dEU);
      localObject2 = fEt();
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
        ae.i("MicroMsg.AppAttachDownloadUI", "summerapp tryInitAttachInfo newInfo systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], signature len[%d]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), localObject1, Long.valueOf(l3), str1, Long.valueOf(l4), Boolean.valueOf(bool1), Integer.valueOf(i) });
        if (this.JSj.hCG == 0)
        {
          localObject1 = localObject2;
          bool1 = bool2;
          if (this.JSj.hCC <= 26214400) {}
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
      if ((this.JSj == null) || ((this.JSj.hCG == 0) && (this.JSj.hCC <= 26214400))) {
        break label569;
      }
      bool1 = false;
    }
    label569:
    for (;;)
    {
      if (!bool1) {
        bc.ajj().a(new com.tencent.mm.plugin.record.b.d((com.tencent.mm.pluginsdk.model.app.c)localObject1, this.gmb, this.nZM, this.fileName, this.fXl, this.dzZ), 0);
      }
      if (localObject1 != null)
      {
        this.filePath = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath;
        dhA();
      }
      AppMethodBeat.o(34145);
      return bool1;
      label322:
      i = ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_signature.length();
      break;
      label334:
      bool1 = false;
      break label219;
      localObject2 = new k(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath);
      if ((((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_status == 199L) && (!((k)localObject2).exists()))
      {
        ae.i("MicroMsg.AppAttachDownloadUI", "summerapp tryInitAttachInfo info exist but file not!");
        com.tencent.mm.pluginsdk.model.app.m.z(this.msgId, this.dEU);
      }
      l1 = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).systemRowid;
      l2 = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_totalLen;
      str1 = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath;
      l3 = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_type;
      String str2 = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_mediaId;
      l4 = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_msgInfoId;
      bool1 = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_isUpload;
      boolean bool3 = ((k)localObject2).exists();
      long l5 = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_status;
      if (((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_signature == null) {}
      for (;;)
      {
        ae.i("MicroMsg.AppAttachDownloadUI", "summerapp tryInitAttachInfo info exist systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], file.exists[%b], status[%d], signature len[%d]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), str1, Long.valueOf(l3), str2, Long.valueOf(l4), Boolean.valueOf(bool1), Boolean.valueOf(bool3), Long.valueOf(l5), Integer.valueOf(i) });
        bool1 = bool2;
        break;
        i = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_signature.length();
      }
    }
  }
  
  private com.tencent.mm.pluginsdk.model.app.c fEt()
  {
    AppMethodBeat.i(34147);
    final com.tencent.mm.pluginsdk.model.app.c localc1 = ao.bJV().CZ(this.msgId);
    if (localc1 != null)
    {
      ae.i("MicroMsg.AppAttachDownloadUI", "summerapp getAppAttachInfo by msgId [%d] stack[%s]", new Object[] { Long.valueOf(this.msgId), af.aRk() });
      AppMethodBeat.o(34147);
      return localc1;
    }
    localc1 = com.tencent.mm.pluginsdk.model.app.m.aNj(this.mediaId);
    if (localc1 == null)
    {
      ae.i("MicroMsg.AppAttachDownloadUI", "summerapp getAppAttachInfo by msgId and mediaId is null stack[%s]", new Object[] { af.aRk() });
      AppMethodBeat.o(34147);
      return localc1;
    }
    if ((localc1.field_msgInfoId == this.msgId) || (o.fB(localc1.field_fileFullPath)))
    {
      AppMethodBeat.o(34147);
      return localc1;
    }
    com.tencent.mm.pluginsdk.model.app.m.z(this.msgId, this.dEU);
    final com.tencent.mm.pluginsdk.model.app.c localc2 = ao.bJV().CZ(this.msgId);
    if (localc2 == null)
    {
      ae.w("MicroMsg.AppAttachDownloadUI", "summerapp getAppAttachInfo create new info from local but failed stack[%s]", new Object[] { af.aRk() });
      AppMethodBeat.o(34147);
      return localc1;
    }
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34117);
        long l1 = System.currentTimeMillis();
        long l2 = o.mF(localc1.field_fileFullPath, localc2.field_fileFullPath);
        if (l2 > 0L)
        {
          localc2.field_offset = l2;
          if (AppAttachDownloadUI.c(localc2)) {
            localc2.field_status = 199L;
          }
        }
        for (boolean bool = ao.bJV().a(localc2, new String[0]);; bool = false)
        {
          ae.i("MicroMsg.AppAttachDownloadUI", "summerapp copyAttachFromLocal size[%d], id[%d, %d], ret[%b], new status[%d], take[%d]ms", new Object[] { Long.valueOf(l2), Long.valueOf(localc1.field_msgInfoId), Long.valueOf(localc2.field_msgInfoId), Boolean.valueOf(bool), Long.valueOf(localc2.field_status), Long.valueOf(System.currentTimeMillis() - l1) });
          AppMethodBeat.o(34117);
          return;
        }
      }
    }, "copyAttachFromLocal");
    AppMethodBeat.o(34147);
    return localc1;
  }
  
  private void fEu()
  {
    AppMethodBeat.i(34150);
    switch (this.appType)
    {
    case 1: 
    case 3: 
    case 4: 
    case 5: 
    default: 
      this.rIb.setVisibility(0);
      ado(8);
      this.JSd.setVisibility(8);
    }
    for (;;)
    {
      Object localObject;
      if (this.rIr.uPu != 1)
      {
        this.rIr.uPu = 1;
        localObject = fEt();
        if (localObject != null) {
          this.rIr.aof(af.nullAsNil(((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath));
        }
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).g(this.rIr);
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).e(this.rIr);
      }
      AppMethodBeat.o(34150);
      return;
      if (fEv()) {
        if (bu.aSQ(this.fXl))
        {
          fEw();
        }
        else
        {
          localObject = getMimeType();
          ae.i("MicroMsg.AppAttachDownloadUI", "onDownLoadImpl");
          fEy();
          ado(8);
          this.JSd.setVisibility(8);
          this.JSc.setVisibility(8);
          this.JSf.setVisibility(0);
          if (this.fileName.equals("")) {
            this.JSf.setText(getString(2131761808));
          }
          for (;;)
          {
            if ((localObject != null) && (!((String)localObject).equals(""))) {
              break label318;
            }
            this.rIb.setVisibility(8);
            this.jdb.setText(getString(2131758100));
            break;
            this.JSf.setText(this.fileName);
          }
          label318:
          this.rIb.setVisibility(0);
          this.jdb.setText(getString(2131758101));
          continue;
          if (fEv())
          {
            dFJ();
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
  
  private boolean fEv()
  {
    AppMethodBeat.i(34151);
    com.tencent.mm.pluginsdk.model.app.c localc = fEt();
    if (localc == null)
    {
      AppMethodBeat.o(34151);
      return true;
    }
    if (o.fB(localc.field_fileFullPath))
    {
      ado(8);
      this.JSd.setVisibility(8);
      this.JSc.setVisibility(8);
      AppMethodBeat.o(34151);
      return true;
    }
    ado(8);
    fEx();
    AppMethodBeat.o(34151);
    return false;
  }
  
  private void fEw()
  {
    AppMethodBeat.i(34152);
    Object localObject = fEt();
    if (localObject == null)
    {
      ae.e("MicroMsg.AppAttachDownloadUI", "info == null");
      AppMethodBeat.o(34152);
      return;
    }
    Intent localIntent = new Intent(this, ShowImageUI.class);
    localIntent.putExtra("key_message_id", this.dCi.field_msgId);
    localIntent.putExtra("key_image_path", ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath);
    localIntent.putExtra("key_favorite", true);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/chatting/AppAttachDownloadUI", "showFileImage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/AppAttachDownloadUI", "showFileImage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    AppMethodBeat.o(34152);
  }
  
  private void fEx()
  {
    AppMethodBeat.i(34159);
    this.JSs.setVisibility(0);
    this.JSt.setVisibility(8);
    fEy();
    this.JSc.fEz();
    AppMethodBeat.o(34159);
  }
  
  private void fEy()
  {
    AppMethodBeat.i(34160);
    this.jdb.setVisibility(8);
    AppMethodBeat.o(34160);
  }
  
  private void fz(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(34161);
    String str;
    if (6 == this.appType)
    {
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(1203L, paramInt2, 1L, false);
      str = this.JSj.hCR;
      if (this.JSj.hCG != 1) {
        break label208;
      }
    }
    label208:
    for (paramInt2 = 7;; paramInt2 = 5)
    {
      str = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { str, Integer.valueOf(paramInt2), Integer.valueOf(this.JSj.hCC), Integer.valueOf(paramInt1), Long.valueOf((ch.aDb() - this.dCi.field_createTime) / 1000L), this.fXl, this.dCi.field_talker, Integer.valueOf(1), "", Long.valueOf(this.dCi.field_msgSvrId), Long.valueOf(this.dCi.field_createTime) });
      ae.i("MicroMsg.AppAttachDownloadUI", "reportKVStat 14665 %s", new Object[] { str });
      com.tencent.mm.plugin.report.service.g.yxI.kvStat(14665, str);
      AppMethodBeat.o(34161);
      return;
    }
  }
  
  private String getMimeType()
  {
    AppMethodBeat.i(34146);
    k.b localb = k.b.zb(this.dEU);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localb.hCD != null)
    {
      localObject1 = localObject2;
      if (localb.hCD.length() > 0) {
        localObject1 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(localb.hCD);
      }
    }
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((String)localObject1).length() != 0) {}
    }
    else
    {
      ae.w("MicroMsg.AppAttachDownloadUI", "getMimeType fail, not a built-in mimetype, use \"*/{fileext}\" instead");
      localObject2 = "*/" + localb.hCD;
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
    if (!fEo())
    {
      finish();
      AppMethodBeat.o(34131);
      return;
    }
    k localk = new k(com.tencent.mm.loader.j.b.asm());
    if (!localk.exists()) {
      localk.mkdirs();
    }
    ao.bJV().add(this);
    initView();
    dhA();
    AppMethodBeat.o(34131);
  }
  
  public final void a(String paramString, com.tencent.mm.sdk.e.m paramm)
  {
    AppMethodBeat.i(34149);
    com.tencent.mm.pluginsdk.model.app.c localc = fEt();
    int i;
    StringBuilder localStringBuilder;
    if (localc != null)
    {
      long l1 = localc.field_totalLen;
      long l2 = localc.field_offset;
      this.JSk = l1;
      this.JSe.setText(getString(2131758103, new Object[] { af.sL(l2), af.sL(l1) }));
      if (localc.field_totalLen != 0L) {
        break label425;
      }
      i = 0;
      ae.v("MicroMsg.AppAttachDownloadUI", "summerapp attach progress:" + i + " offset:" + l2 + " totallen:" + l1 + " status " + localc.field_status);
      this.JSb.setProgress(i);
      if ((localc.field_status == 199L) && (i >= 100) && (!this.JSm))
      {
        this.JSm = true;
        if (this.JSu)
        {
          this.JSu = false;
          fEq();
        }
        if (localc != null)
        {
          localStringBuilder = new StringBuilder().append(getString(2131758120)).append(" : ");
          paramm = localc.field_fileFullPath;
          paramString = paramm;
          if (paramm != null)
          {
            String str = com.tencent.mm.loader.j.b.ase();
            paramm = o.k(paramm, true);
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
      Toast.makeText(this, paramString, this.JSp).show();
      com.tencent.mm.pluginsdk.ui.tools.a.a(this, localc.field_fileFullPath, this.fXl, this.fileName, 1);
      ar.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(187111);
          AppAttachDownloadUI.G(AppAttachDownloadUI.this);
          AppMethodBeat.o(187111);
        }
      }, 200L);
      if ((this.JSb.getVisibility() != 0) && (i < 100) && (!localc.field_isUpload) && (localc.field_status == 101L))
      {
        ae.i("MicroMsg.AppAttachDownloadUI", "summerapp still downloading updateProgress progress[%d]", new Object[] { Integer.valueOf(i) });
        ado(0);
        this.JSc.setVisibility(8);
      }
      AppMethodBeat.o(34149);
      return;
      i = (int)(localc.field_offset * 100L / localc.field_totalLen);
      break;
    }
  }
  
  public final MMActivity cyr()
  {
    AppMethodBeat.i(224191);
    MMActivity localMMActivity = (MMActivity)super.getContext();
    AppMethodBeat.o(224191);
    return localMMActivity;
  }
  
  public final void dHA()
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
    this.xtC = ((MMImageView)findViewById(2131299226));
    this.JSb = ((RoundProgressBtn)findViewById(2131304258));
    this.JSc = new a((Button)findViewById(2131299199), (TextView)findViewById(2131299200));
    this.rIb = ((Button)findViewById(2131299212));
    this.JSd = findViewById(2131299201);
    this.jdb = ((TextView)findViewById(2131299208));
    this.JSe = ((TextView)findViewById(2131299202));
    this.JSf = ((TextView)findViewById(2131299206));
    this.JSg = ((TextView)findViewById(2131299207));
    this.JSs = ((LinearLayout)findViewById(2131299210));
    this.JSt = ((LinearLayout)findViewById(2131301484));
    this.JSf.setOnTouchListener(this.rIt);
    this.JSf.setOnLongClickListener(this.rIu);
    if (this.JSf != null)
    {
      localObject = this.JSf.getPaint();
      if (localObject != null) {
        ((Paint)localObject).setFakeBoldText(true);
      }
    }
    this.JSb.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(34122);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/AppAttachDownloadUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        AppAttachDownloadUI.a(AppAttachDownloadUI.this, 8);
        AppAttachDownloadUI.s(AppAttachDownloadUI.this).setVisibility(0);
        AppAttachDownloadUI.t(AppAttachDownloadUI.this).setVisibility(8);
        ae.i("MicroMsg.AppAttachDownloadUI", "summerapp roundProgressBar downloadAppAttachScene[%s]", new Object[] { AppAttachDownloadUI.a(AppAttachDownloadUI.this) });
        if (AppAttachDownloadUI.a(AppAttachDownloadUI.this) != null)
        {
          AppAttachDownloadUI.a(AppAttachDownloadUI.this).a(AppAttachDownloadUI.this);
          com.tencent.mm.kernel.g.ajj().a(AppAttachDownloadUI.a(AppAttachDownloadUI.this));
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/AppAttachDownloadUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(34122);
          return;
          paramAnonymousView = AppAttachDownloadUI.u(AppAttachDownloadUI.this);
          if ((paramAnonymousView != null) && (paramAnonymousView.field_status != 199L))
          {
            ae.i("MicroMsg.AppAttachDownloadUI", "summerapp roundProgressBar onClick but scene is null and set status[%d] paused", new Object[] { Long.valueOf(paramAnonymousView.field_status) });
            paramAnonymousView.field_status = 102L;
            ao.bJV().a(paramAnonymousView, new String[0]);
          }
        }
      }
    });
    Object localObject = this.JSc;
    View.OnClickListener local11 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(187115);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/AppAttachDownloadUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        AppAttachDownloadUI.a(AppAttachDownloadUI.this, 0);
        AppAttachDownloadUI.s(AppAttachDownloadUI.this).setVisibility(8);
        if (AppAttachDownloadUI.v(AppAttachDownloadUI.this))
        {
          paramAnonymousView = AppAttachDownloadUI.u(AppAttachDownloadUI.this);
          if (paramAnonymousView != null)
          {
            paramAnonymousView.field_status = 101L;
            paramAnonymousView.field_lastModifyTime = bu.aRi();
            ao.bJV().a(paramAnonymousView, new String[0]);
          }
          AppAttachDownloadUI.a(AppAttachDownloadUI.this, new com.tencent.mm.plugin.record.b.f(AppAttachDownloadUI.w(AppAttachDownloadUI.this), AppAttachDownloadUI.x(AppAttachDownloadUI.this), AppAttachDownloadUI.y(AppAttachDownloadUI.this)));
          bc.ajj().a(AppAttachDownloadUI.a(AppAttachDownloadUI.this), 0);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/AppAttachDownloadUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(187115);
      }
    };
    ((a)localObject).sos.setOnClickListener(local11);
    this.rIb.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(187110);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/AppAttachDownloadUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        AppAttachDownloadUI.E(AppAttachDownloadUI.this);
        AppAttachDownloadUI.F(AppAttachDownloadUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/AppAttachDownloadUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(187110);
      }
    });
    switch (this.appType)
    {
    case 1: 
    case 3: 
    case 5: 
    default: 
      this.xtC.setImageResource(2131689577);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(34114);
          if (AppAttachDownloadUI.a(AppAttachDownloadUI.this) != null) {
            bc.ajj().a(AppAttachDownloadUI.a(AppAttachDownloadUI.this));
          }
          if ((AppAttachDownloadUI.b(AppAttachDownloadUI.this) != null) && (AppAttachDownloadUI.b(AppAttachDownloadUI.this).sy(1)))
          {
            AppMethodBeat.o(34114);
            return true;
          }
          AppAttachDownloadUI.this.finish();
          AppMethodBeat.o(34114);
          return true;
        }
      });
      this.dCy = getIntent().getBooleanExtra("app_show_share", true);
      if (this.dCy) {
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
      this.JSm = false;
      if ((!fEp()) || (this.dCi.field_msgId != 0L)) {
        break label556;
      }
      this.JSg.setVisibility(8);
      this.JSf.setVisibility(0);
      if (this.fileName.equals("")) {
        this.JSf.setText(getString(2131761808));
      }
      break;
    }
    for (;;)
    {
      fEx();
      AppMethodBeat.o(34139);
      return;
      this.xtC.setImageResource(2131230944);
      break;
      this.xtC.setImageResource(2131689581);
      break;
      this.xtC.setImageResource(com.tencent.mm.pluginsdk.model.q.aMX(this.fXl));
      break;
      if (bu.aSQ(this.fXl))
      {
        this.xtC.setImageResource(2131230944);
        break;
      }
      this.xtC.setImageResource(2131689577);
      break;
      this.JSf.setText(this.fileName);
    }
    label556:
    localObject = fEt();
    int i;
    if ((localObject == null) || (!new k(((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath).exists()))
    {
      i = 0;
      if (i == 0) {
        break label707;
      }
      ae.i("MicroMsg.AppAttachDownloadUI", "summerapp isCanOpenFile");
      if (this.JSk <= 0L) {
        break label695;
      }
      this.JSg.setVisibility(0);
      this.JSg.setText(getResources().getString(2131759078, new Object[] { af.sL(this.JSk) }));
    }
    for (;;)
    {
      this.JSm = true;
      fEu();
      AppMethodBeat.o(34139);
      return;
      if ((((com.tencent.mm.pluginsdk.model.app.c)localObject).cZe()) || ((this.dCi.field_isSend == 1) && (((com.tencent.mm.pluginsdk.model.app.c)localObject).field_isUpload)))
      {
        i = 1;
        break;
      }
      i = 0;
      break;
      label695:
      this.JSg.setVisibility(8);
    }
    label707:
    if (this.JSk > 0L)
    {
      this.JSg.setVisibility(0);
      this.JSg.setText(getResources().getString(2131759078, new Object[] { af.sL(this.JSk) }));
    }
    while (this.JSm)
    {
      AppMethodBeat.o(34139);
      return;
      this.JSg.setVisibility(8);
    }
    this.JSh = new com.tencent.mm.ak.g()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, n paramAnonymousn)
      {
        AppMethodBeat.i(187114);
        if (paramAnonymousInt2 == 0) {}
        for (float f = 0.0F;; f = paramAnonymousInt1 * 100.0F / paramAnonymousInt2)
        {
          if ((paramAnonymousInt1 < paramAnonymousInt2) && (AppAttachDownloadUI.r(AppAttachDownloadUI.this).getVisibility() != 0))
          {
            AppAttachDownloadUI.a(AppAttachDownloadUI.this, 0);
            AppAttachDownloadUI.s(AppAttachDownloadUI.this).setVisibility(8);
          }
          AppAttachDownloadUI.r(AppAttachDownloadUI.this).setProgress((int)f);
          AppMethodBeat.o(187114);
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
      ae.i("MicroMsg.AppAttachDownloadUI", "summerapp progressCallBack[%s], isDownloadFinished[%b], isDownloadStarted[%b]", new Object[] { this.JSh, Boolean.valueOf(this.JSm), Boolean.valueOf(this.JSn) });
      if ((this.appType == 2) || ((!this.JSm) && (!this.JSn))) {
        fEr();
      }
      AppMethodBeat.o(34139);
      return;
    case 0: 
    case 6: 
      if (this.JSn)
      {
        this.JSc.setVisibility(0);
        ado(8);
        this.JSd.setVisibility(8);
        this.rIb.setVisibility(8);
        fEy();
        this.JSf.setVisibility(0);
        if (!this.fileName.equals("")) {
          break label1056;
        }
        this.JSf.setText(getString(2131761808));
        localObject = getMimeType();
        if ((localObject != null) && (!((String)localObject).equals(""))) {
          break label1070;
        }
        this.jdb.setText(getString(2131758100));
      }
      while (bu.aSQ(this.fXl))
      {
        fEy();
        break;
        this.JSc.setVisibility(8);
        break label931;
        this.JSf.setText(this.fileName);
        break label994;
        this.jdb.setText(getString(2131758101));
      }
    case 7: 
      label931:
      label994:
      if (this.JSn) {
        this.JSc.setVisibility(0);
      }
      for (;;)
      {
        label1056:
        label1070:
        ado(8);
        this.JSd.setVisibility(8);
        this.rIb.setVisibility(8);
        this.JSf.setVisibility(8);
        fEy();
        this.jdb.setText(getString(2131758101));
        break;
        this.JSc.setVisibility(8);
      }
    }
    ado(8);
    this.JSd.setVisibility(8);
    if (this.JSn) {
      this.JSc.setVisibility(0);
    }
    for (;;)
    {
      this.rIb.setVisibility(8);
      this.JSf.setVisibility(8);
      fEy();
      break;
      this.JSc.setVisibility(8);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(34148);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.tencent.mm.pluginsdk.ui.tools.a.a(this, paramInt1, paramInt2, paramIntent, this.JSo, 2131758111, 2131758112, 1);
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
    ao.bJV().remove(this);
    super.onDestroy();
    if (this.FCU != null) {
      this.FCU.onDestroy();
    }
    if (this.rIr != null) {
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).d(this.rIr);
    }
    AppMethodBeat.o(34136);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(34140);
    ae.i("MicroMsg.AppAttachDownloadUI", "onKeyDown keyCode %d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt == 4) && (this.FCU != null) && (this.FCU.sy(2)))
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
    if (this.FCU != null)
    {
      this.FCU.bhk();
      this.FCU.onDestroy();
    }
    init();
    AppMethodBeat.o(34156);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(34138);
    bc.ajj().b(221, this);
    bc.ajj().b(728, this);
    super.onPause();
    if (this.FCU != null) {
      this.FCU.bhk();
    }
    oo localoo = new oo();
    localoo.dDz.dDA = false;
    oo.a locala = localoo.dDz;
    if (this.dCi == null) {}
    for (String str = "";; str = this.dCi.field_talker)
    {
      locala.talker = str;
      com.tencent.mm.sdk.b.a.IvT.a(localoo, getMainLooper());
      ae.d("MicroMsg.AppAttachDownloadUI", "AppAttachDownloadUI cancel pause auto download logic");
      AppMethodBeat.o(34138);
      return;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(34137);
    super.onResume();
    bc.ajj().a(221, this);
    bc.ajj().a(728, this);
    oo localoo = new oo();
    localoo.dDz.dDA = true;
    localoo.dDz.talker = this.dCi.field_talker;
    com.tencent.mm.sdk.b.a.IvT.a(localoo, getMainLooper());
    ae.d("MicroMsg.AppAttachDownloadUI", "AppAttachDownloadUI req pause auto download logic");
    this.rIb.setEnabled(true);
    if (this.FCU != null) {
      this.FCU.bhj();
    }
    AppMethodBeat.o(34137);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(34154);
    ae.i("MicroMsg.AppAttachDownloadUI", "summerapp onSceneEnd type[%d], [%d, %d, %s]", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramn.getType() != 221) && (paramn.getType() != 728))
    {
      AppMethodBeat.o(34154);
      return;
    }
    if ((paramn.getType() == 728) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = fEt();
      if (paramString == null)
      {
        ae.i("MicroMsg.AppAttachDownloadUI", "summerapp onSceneEnd getAppAttachInfo is null");
        if (paramString != null)
        {
          paramString.field_status = 101L;
          paramString.field_lastModifyTime = bu.aRi();
          ao.bJV().a(paramString, new String[0]);
        }
        this.xGr = new com.tencent.mm.plugin.record.b.f(this.msgId, this.mediaId, this.JSh);
        bc.ajj().a(this.xGr, 0);
        AppMethodBeat.o(34154);
        return;
      }
      if (paramString.field_signature == null) {}
      for (paramInt1 = -1;; paramInt1 = paramString.field_signature.length())
      {
        ae.i("MicroMsg.AppAttachDownloadUI", "summerapp onSceneEnd CheckBigFileDownload ok signature len[%d] start NetSceneDownloadAppAttach", new Object[] { Integer.valueOf(paramInt1) });
        break;
      }
    }
    if ((this.xGr == null) && ((paramn instanceof com.tencent.mm.plugin.record.b.f)))
    {
      paramString = (com.tencent.mm.plugin.record.b.f)paramn;
      com.tencent.mm.pluginsdk.model.app.c localc = fEt();
      if ((localc != null) && (!af.isNullOrNil(localc.field_mediaSvrId)) && (localc.field_mediaSvrId.equals(paramString.getMediaId())))
      {
        this.xGr = paramString;
        ae.i("MicroMsg.AppAttachDownloadUI", "summerapp onSceneEnd reset downloadAppAttachScene[%s] by mediaSvrId[%s]", new Object[] { this.xGr, localc.field_mediaSvrId });
      }
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (this.JSj.type == 6)
      {
        fz(0, 2);
        paramString = fEt();
        if (paramString != null) {
          com.tencent.mm.plugin.report.e.ywz.idkeyStat(1203L, 5L, paramString.field_totalLen, false);
        }
      }
      AppMethodBeat.o(34154);
      return;
    }
    if ((paramInt2 != 0) && (com.tencent.mm.sdk.a.b.fnF())) {
      Toast.makeText(this, "errCode[" + paramInt2 + "]", 0).show();
    }
    if (paramInt2 == -5103059)
    {
      fEx();
      ado(8);
      fz(1, 3);
      AppMethodBeat.o(34154);
      return;
    }
    ado(8);
    this.JSc.setVisibility(0);
    this.JSd.setVisibility(8);
    ae.e("MicroMsg.AppAttachDownloadUI", "summerapp onSceneEnd, download fail, type = " + paramn.getType() + " errType = " + paramInt1 + ", errCode = " + paramInt2);
    AppMethodBeat.o(34154);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
  {
    Button sos;
    private TextView vk;
    private boolean xIn;
    
    public a(Button paramButton, TextView paramTextView)
    {
      AppMethodBeat.i(34126);
      this.sos = paramButton;
      this.vk = paramTextView;
      if (paramTextView != null)
      {
        int i = com.tencent.mm.n.g.acL().getInt("MsgFileExpiredInterval", 432000);
        long l = AppAttachDownloadUI.H(AppAttachDownloadUI.this).field_createTime / 1000L;
        Math.floor((i - ch.rZ(l)) * 1.0D / 86400.0D);
        paramTextView.setText("");
      }
      AppMethodBeat.o(34126);
    }
    
    public final void fEz()
    {
      AppMethodBeat.i(34128);
      ae.i("MicroMsg.AppAttachDownloadUI", "showErrorTip overtime %s", new Object[] { Long.valueOf(AppAttachDownloadUI.H(AppAttachDownloadUI.this).field_msgId) });
      if (this.sos != null) {
        this.sos.setVisibility(4);
      }
      if (this.vk != null)
      {
        this.vk.setVisibility(0);
        this.vk.setText(2131759063);
        this.vk.setTextColor(AppAttachDownloadUI.this.getResources().getColor(2131099805));
        AppAttachDownloadUI.I(AppAttachDownloadUI.this).setVisibility(8);
        AppAttachDownloadUI.t(AppAttachDownloadUI.this).setVisibility(8);
        if (!this.xIn)
        {
          this.xIn = true;
          AppAttachDownloadUI.J(AppAttachDownloadUI.this);
        }
      }
      AppMethodBeat.o(34128);
    }
    
    public final void setVisibility(int paramInt)
    {
      AppMethodBeat.i(34127);
      if (this.sos != null) {
        this.sos.setVisibility(paramInt);
      }
      if (this.vk != null) {
        this.vk.setVisibility(paramInt);
      }
      AppMethodBeat.o(34127);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppAttachDownloadUI
 * JD-Core Version:    0.7.0.1
 */