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
import com.tencent.mm.g.a.cv;
import com.tencent.mm.g.a.on;
import com.tencent.mm.g.a.on.a;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.plugin.msgquote.model.MsgQuoteItem;
import com.tencent.mm.plugin.record.b.f.a;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.tools.ShowImageUI;
import com.tencent.mm.ui.widget.progress.RoundProgressBtn;

public class AppAttachDownloadUI
  extends MMActivity
  implements com.tencent.mm.al.f, f.a, k.a
{
  private com.tencent.mm.ui.chatting.g.a Fkw;
  private boolean JxA;
  private int JxB;
  private LinearLayout JxC;
  private LinearLayout JxD;
  private boolean JxE;
  private RoundProgressBtn Jxl;
  private a Jxm;
  private View Jxn;
  private TextView Jxo;
  private TextView Jxp;
  private TextView Jxq;
  private com.tencent.mm.al.g Jxr;
  private boolean Jxs;
  private k.b Jxt;
  private long Jxu;
  private String Jxv;
  private boolean Jxw;
  private boolean Jxx;
  private boolean Jxy;
  private int Jxz;
  private int appType;
  private bu dBd;
  private boolean dBt;
  private String dDP;
  private String dyU;
  private String fVf;
  private String fileName;
  private String filePath;
  private String gjI;
  private String gjc;
  private TextView jai;
  private String mediaId;
  private long msgId;
  private String nUg;
  private int nYw;
  private int nYx;
  private com.tencent.mm.ui.widget.b.a nZK;
  private int oTx;
  private n.e qlC;
  private HandOffFile rAg;
  private View.OnTouchListener rAi;
  private View.OnLongClickListener rAj;
  private Button rzQ;
  private int scene;
  private String uDO;
  private MMImageView xdL;
  private com.tencent.mm.plugin.record.b.f xqu;
  
  public AppAttachDownloadUI()
  {
    AppMethodBeat.i(34129);
    this.oTx = 0;
    this.Jxw = false;
    this.Jxx = false;
    this.Jxy = true;
    this.Jxz = 5000;
    this.JxA = false;
    this.JxE = false;
    this.nZK = null;
    this.qlC = new n.e()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(193820);
        ClipboardManager localClipboardManager = (ClipboardManager)aj.getContext().getSystemService("clipboard");
        if (AppAttachDownloadUI.z(AppAttachDownloadUI.this).equals("")) {}
        for (paramAnonymousMenuItem = AppAttachDownloadUI.this.getString(2131761808);; paramAnonymousMenuItem = AppAttachDownloadUI.z(AppAttachDownloadUI.this))
        {
          localClipboardManager.setPrimaryClip(ClipData.newPlainText(null, paramAnonymousMenuItem));
          h.cl(AppAttachDownloadUI.this, AppAttachDownloadUI.this.getString(2131755702));
          AppMethodBeat.o(193820);
          return;
        }
      }
    };
    this.rAi = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(193821);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/AppAttachDownloadUI$9", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/chatting/AppAttachDownloadUI$9", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(193821);
          return false;
          AppAttachDownloadUI.b(AppAttachDownloadUI.this, (int)paramAnonymousMotionEvent.getRawX());
          AppAttachDownloadUI.c(AppAttachDownloadUI.this, (int)paramAnonymousMotionEvent.getRawY());
        }
      }
    };
    this.rAj = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(193813);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/AppAttachDownloadUI$10", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahq());
        ad.d("MicroMsg.AppAttachDownloadUI", "onLongClick");
        if (AppAttachDownloadUI.A(AppAttachDownloadUI.this) == null) {
          AppAttachDownloadUI.a(AppAttachDownloadUI.this, new com.tencent.mm.ui.widget.b.a(AppAttachDownloadUI.this.cwQ()));
        }
        AppAttachDownloadUI.A(AppAttachDownloadUI.this).a(paramAnonymousView, AppAttachDownloadUI.this, AppAttachDownloadUI.B(AppAttachDownloadUI.this), AppAttachDownloadUI.C(AppAttachDownloadUI.this), AppAttachDownloadUI.D(AppAttachDownloadUI.this));
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/chatting/AppAttachDownloadUI$10", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(193813);
        return true;
      }
    };
    AppMethodBeat.o(34129);
  }
  
  private String aVO(String paramString)
  {
    AppMethodBeat.i(34142);
    String str = paramString;
    if (this.Jxs)
    {
      str = paramString;
      if (paramString != null) {
        str = bj.Bl(paramString);
      }
    }
    AppMethodBeat.o(34142);
    return str;
  }
  
  private void acG(int paramInt)
  {
    AppMethodBeat.i(34158);
    if (paramInt != this.Jxl.getVisibility())
    {
      ad.i("MicroMsg.AppAttachDownloadUI", "setRoundProgressBar %s %s", new Object[] { Integer.valueOf(paramInt), af.aQL() });
      this.Jxl.setVisibility(paramInt);
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
  
  private void dCs()
  {
    AppMethodBeat.i(34153);
    ad.i("MicroMsg.AppAttachDownloadUI", "[ImageGalleryUI] showImage");
    Object localObject = new Intent(this, ImageGalleryUI.class);
    ((Intent)localObject).putExtra("img_gallery_msg_id", this.dBd.field_msgId);
    ((Intent)localObject).putExtra("img_gallery_talker", this.dBd.field_talker);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/ui/chatting/AppAttachDownloadUI", "showImage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/AppAttachDownloadUI", "showImage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    overridePendingTransition(0, 0);
    AppMethodBeat.o(34153);
  }
  
  private void deI()
  {
    AppMethodBeat.i(34132);
    this.Fkw = new com.tencent.mm.ui.chatting.g.a(new com.tencent.mm.plugin.ball.a.e((MMActivity)super.getContext()));
    this.Fkw.h(this.filePath, this.fVf, this.oTx, true);
    this.Fkw.mn(this.fVf, this.fileName);
    this.rAg.L(this.Fkw.nGj);
    AppMethodBeat.o(34132);
  }
  
  private void fAl()
  {
    AppMethodBeat.i(34133);
    String str1 = af.nullAsNil(u.aAm());
    Object localObject2 = af.nullAsNil(this.dBd.field_talker);
    Object localObject1 = localObject2;
    if (w.vF((String)localObject2)) {
      localObject1 = af.nullAsNil(this.Jxt.dyU);
    }
    if (this.dBd.field_isSend == 1)
    {
      localObject2 = str1;
      if (this.dBd.field_isSend != 1) {
        break label259;
      }
      label76:
      String str2 = af.nullAsNil(this.filePath);
      String str3 = this.fVf;
      String str4 = this.fileName;
      String str5 = this.nUg;
      long l = this.Jxu;
      String str6 = Long.toString(this.dBd.field_msgSvrId);
      if (af.isNullOrNil(this.uDO)) {
        break label266;
      }
      str1 = this.uDO;
      label136:
      this.rAg = new HandOffFile(str2, str3, str4, str5, l, str6, "", str1, this.gjI, this.gjc, "", "", (String)localObject2, (String)localObject1);
      boolean bool = b(fAr());
      localObject1 = this.rAg;
      if (!bool) {
        break label275;
      }
    }
    label259:
    label266:
    label275:
    for (int i = 1;; i = 2)
    {
      ((HandOffFile)localObject1).uDP = i;
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).f(this.rAg);
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).c(this.rAg);
      AppMethodBeat.o(34133);
      return;
      localObject2 = localObject1;
      break;
      localObject1 = str1;
      break label76;
      str1 = this.Jxv;
      break label136;
    }
  }
  
  private boolean fAm()
  {
    AppMethodBeat.i(34134);
    this.scene = getIntent().getIntExtra("scene", 0);
    this.msgId = getIntent().getLongExtra("app_msg_id", -1L);
    this.JxA = getIntent().getBooleanExtra("choose_way", false);
    this.JxB = getIntent().getIntExtra("msg_type", 0);
    if (this.msgId == -1L)
    {
      AppMethodBeat.o(34134);
      return false;
    }
    ba.aBQ();
    this.dBd = com.tencent.mm.model.c.azs().xY(this.msgId);
    if ((this.dBd == null) || (this.dBd.field_msgId == 0L) || (this.dBd.field_content == null))
    {
      if (!fAn()) {
        break label358;
      }
      localObject = (MsgQuoteItem)getIntent().getParcelableExtra("key_quoted_msg");
      if (localObject == null)
      {
        AppMethodBeat.o(34134);
        return false;
      }
      this.dBd = new bu();
      this.dBd.setType(((MsgQuoteItem)localObject).type);
      this.dBd.qz(((MsgQuoteItem)localObject).vZc);
      this.dBd.tN(((MsgQuoteItem)localObject).vZd);
      this.dBd.sP(((MsgQuoteItem)localObject).vZg);
      this.dBd.setContent(((MsgQuoteItem)localObject).content);
      if (bt.lQ(((MsgQuoteItem)localObject).vZe, u.aAm())) {
        this.dBd.kr(1);
      }
    }
    this.Jxs = w.vF(this.dBd.field_talker);
    this.dDP = this.dBd.field_content;
    if ((this.Jxs) && (this.dBd.field_isSend == 0)) {
      this.dDP = aVO(this.dBd.field_content);
    }
    this.Jxt = k.b.yr(this.dDP);
    if (this.Jxt == null)
    {
      ad.e("MicroMsg.AppAttachDownloadUI", "summerapp parse msgContent error, %s", new Object[] { this.dDP });
      AppMethodBeat.o(34134);
      return false;
      label358:
      AppMethodBeat.o(34134);
      return false;
    }
    if ((af.isNullOrNil(this.Jxt.dks)) && (!af.isNullOrNil(this.Jxt.hAd)))
    {
      ad.e("MicroMsg.AppAttachDownloadUI", "summerapp msgContent format error, %s", new Object[] { this.dDP });
      this.Jxt.dks = this.Jxt.hAd.hashCode();
    }
    this.appType = this.Jxt.type;
    this.mediaId = this.Jxt.dks;
    this.fileName = af.nullAsNil(this.Jxt.title);
    this.fVf = af.nullAsNil(this.Jxt.hzP).toLowerCase();
    this.Jxu = this.Jxt.hzO;
    this.nUg = af.nullAsNil(this.Jxt.filemd5);
    this.dyU = af.nullAsNil(this.Jxt.dyU);
    this.uDO = af.nullAsNil(this.Jxt.hAd);
    this.Jxv = af.nullAsNil(this.Jxt.hzU);
    this.gjI = af.nullAsNil(this.Jxt.gjI);
    this.gjc = af.nullAsNil(this.Jxt.hAa);
    if (af.isNullOrNil(this.fVf)) {
      this.fVf = com.tencent.mm.vfs.i.ZF(this.fileName);
    }
    ad.i("MicroMsg.AppAttachDownloadUI", "summerapp initParams msgId[%d], sender[%d], msgContent[%s], appType[%d], mediaId[%s], fileName[%s]", new Object[] { Long.valueOf(this.msgId), Integer.valueOf(this.dBd.field_isSend), this.dDP, Integer.valueOf(this.appType), this.mediaId, this.fileName });
    Object localObject = fAr();
    if (localObject == null)
    {
      ad.i("MicroMsg.AppAttachDownloadUI", "summerapp initParams attInfo is null");
      this.Jxx = false;
      if (this.Jxt.type == 6) {
        ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).aa(String.valueOf(this.dBd.field_msgId), this.dBd.field_msgSvrId);
      }
      fB(4, 0);
      fAl();
      if (!b((com.tencent.mm.pluginsdk.model.app.c)localObject)) {
        break label998;
      }
      if (this.scene != 1) {
        break label914;
      }
      this.oTx = 7;
      if (this.JxA)
      {
        bool = com.tencent.mm.pluginsdk.ui.tools.a.c(this, ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath, this.fVf, this.oTx);
        AppMethodBeat.o(34134);
        return bool;
      }
    }
    else
    {
      this.filePath = ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath;
      new com.tencent.mm.vfs.e(((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath);
      if (((com.tencent.mm.pluginsdk.model.app.c)localObject).field_offset > 0L) {}
      for (this.Jxx = true;; this.Jxx = false)
      {
        ad.i("MicroMsg.AppAttachDownloadUI", "summerapp initParams attInfo field_fileFullPath[%s], field_offset[%d], isDownloadStarted[%b]", new Object[] { ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath, Long.valueOf(((com.tencent.mm.pluginsdk.model.app.c)localObject).field_offset), Boolean.valueOf(this.Jxx) });
        break;
      }
    }
    boolean bool = com.tencent.mm.pluginsdk.ui.tools.a.ai(((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath, this.fVf, this.oTx);
    AppMethodBeat.o(34134);
    return bool;
    label914:
    if (this.oTx != 9) {
      this.oTx = 1;
    }
    if (this.JxA)
    {
      bool = com.tencent.mm.pluginsdk.ui.tools.a.c(this, ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath, this.fVf, this.oTx);
      AppMethodBeat.o(34134);
      return bool;
    }
    if (!com.tencent.mm.pluginsdk.ui.tools.a.lz(((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath, this.fVf))
    {
      bool = com.tencent.mm.pluginsdk.ui.tools.a.ai(((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath, this.fVf, this.oTx);
      AppMethodBeat.o(34134);
      return bool;
    }
    label998:
    AppMethodBeat.o(34134);
    return true;
  }
  
  private boolean fAn()
  {
    return this.JxB == 1;
  }
  
  private void fAo()
  {
    AppMethodBeat.i(34141);
    cv localcv = new cv();
    com.tencent.mm.pluginsdk.model.g.e(localcv, this.dBd);
    localcv.dnG.activity = this;
    localcv.dnG.dnM = 39;
    com.tencent.mm.sdk.b.a.IbL.l(localcv);
    AppMethodBeat.o(34141);
  }
  
  private void fAp()
  {
    AppMethodBeat.i(34143);
    acG(0);
    this.Jxm.setVisibility(8);
    if (fAq())
    {
      ad.i("MicroMsg.AppAttachDownloadUI", "startToDownloadFile");
      this.xqu = new com.tencent.mm.plugin.record.b.f(this.msgId, this.mediaId, this.Jxr);
      ba.aiU().a(this.xqu, 0);
      aa.R(this.dBd);
      fB(7, 1);
    }
    AppMethodBeat.o(34143);
  }
  
  private boolean fAq()
  {
    int i = -1;
    boolean bool2 = true;
    AppMethodBeat.i(34145);
    Object localObject1 = fAr();
    Object localObject2;
    boolean bool1;
    long l1;
    long l2;
    long l3;
    String str1;
    long l4;
    if (localObject1 == null)
    {
      com.tencent.mm.pluginsdk.model.app.m.y(this.msgId, this.dDP);
      localObject2 = fAr();
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
        if (this.Jxt.hzS == 0)
        {
          localObject1 = localObject2;
          bool1 = bool2;
          if (this.Jxt.hzO <= 26214400) {}
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
      if ((this.Jxt == null) || ((this.Jxt.hzS == 0) && (this.Jxt.hzO <= 26214400))) {
        break label569;
      }
      bool1 = false;
    }
    label569:
    for (;;)
    {
      if (!bool1) {
        ba.aiU().a(new com.tencent.mm.plugin.record.b.d((com.tencent.mm.pluginsdk.model.app.c)localObject1, this.gjI, this.nUg, this.fileName, this.fVf, this.dyU), 0);
      }
      if (localObject1 != null)
      {
        this.filePath = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath;
        deI();
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
        com.tencent.mm.pluginsdk.model.app.m.y(this.msgId, this.dDP);
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
  
  private com.tencent.mm.pluginsdk.model.app.c fAr()
  {
    AppMethodBeat.i(34147);
    final com.tencent.mm.pluginsdk.model.app.c localc1 = ao.bIX().CB(this.msgId);
    if (localc1 != null)
    {
      ad.i("MicroMsg.AppAttachDownloadUI", "summerapp getAppAttachInfo by msgId [%d] stack[%s]", new Object[] { Long.valueOf(this.msgId), af.aQL() });
      AppMethodBeat.o(34147);
      return localc1;
    }
    localc1 = com.tencent.mm.pluginsdk.model.app.m.aLN(this.mediaId);
    if (localc1 == null)
    {
      ad.i("MicroMsg.AppAttachDownloadUI", "summerapp getAppAttachInfo by msgId and mediaId is null stack[%s]", new Object[] { af.aQL() });
      AppMethodBeat.o(34147);
      return localc1;
    }
    if ((localc1.field_msgInfoId == this.msgId) || (com.tencent.mm.vfs.i.fv(localc1.field_fileFullPath)))
    {
      AppMethodBeat.o(34147);
      return localc1;
    }
    com.tencent.mm.pluginsdk.model.app.m.y(this.msgId, this.dDP);
    final com.tencent.mm.pluginsdk.model.app.c localc2 = ao.bIX().CB(this.msgId);
    if (localc2 == null)
    {
      ad.w("MicroMsg.AppAttachDownloadUI", "summerapp getAppAttachInfo create new info from local but failed stack[%s]", new Object[] { af.aQL() });
      AppMethodBeat.o(34147);
      return localc1;
    }
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34117);
        long l1 = System.currentTimeMillis();
        long l2 = com.tencent.mm.vfs.i.mz(localc1.field_fileFullPath, localc2.field_fileFullPath);
        if (l2 > 0L)
        {
          localc2.field_offset = l2;
          if (AppAttachDownloadUI.c(localc2)) {
            localc2.field_status = 199L;
          }
        }
        for (boolean bool = ao.bIX().a(localc2, new String[0]);; bool = false)
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
  
  private void fAs()
  {
    AppMethodBeat.i(34150);
    switch (this.appType)
    {
    case 1: 
    case 3: 
    case 4: 
    case 5: 
    default: 
      this.rzQ.setVisibility(0);
      acG(8);
      this.Jxn.setVisibility(8);
    }
    for (;;)
    {
      Object localObject;
      if (this.rAg.uDP != 1)
      {
        this.rAg.uDP = 1;
        localObject = fAr();
        if (localObject != null) {
          this.rAg.ane(af.nullAsNil(((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath));
        }
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).f(this.rAg);
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).e(this.rAg);
      }
      AppMethodBeat.o(34150);
      return;
      if (fAt()) {
        if (bt.aRt(this.fVf))
        {
          fAu();
        }
        else
        {
          localObject = getMimeType();
          ad.i("MicroMsg.AppAttachDownloadUI", "onDownLoadImpl");
          fAw();
          acG(8);
          this.Jxn.setVisibility(8);
          this.Jxm.setVisibility(8);
          this.Jxp.setVisibility(0);
          if (this.fileName.equals("")) {
            this.Jxp.setText(getString(2131761808));
          }
          for (;;)
          {
            if ((localObject != null) && (!((String)localObject).equals(""))) {
              break label318;
            }
            this.rzQ.setVisibility(8);
            this.jai.setText(getString(2131758100));
            break;
            this.Jxp.setText(this.fileName);
          }
          label318:
          this.rzQ.setVisibility(0);
          this.jai.setText(getString(2131758101));
          continue;
          if (fAt())
          {
            dCs();
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
  
  private boolean fAt()
  {
    AppMethodBeat.i(34151);
    com.tencent.mm.pluginsdk.model.app.c localc = fAr();
    if (localc == null)
    {
      AppMethodBeat.o(34151);
      return true;
    }
    if (com.tencent.mm.vfs.i.fv(localc.field_fileFullPath))
    {
      acG(8);
      this.Jxn.setVisibility(8);
      this.Jxm.setVisibility(8);
      AppMethodBeat.o(34151);
      return true;
    }
    acG(8);
    fAv();
    AppMethodBeat.o(34151);
    return false;
  }
  
  private void fAu()
  {
    AppMethodBeat.i(34152);
    Object localObject = fAr();
    if (localObject == null)
    {
      ad.e("MicroMsg.AppAttachDownloadUI", "info == null");
      AppMethodBeat.o(34152);
      return;
    }
    Intent localIntent = new Intent(this, ShowImageUI.class);
    localIntent.putExtra("key_message_id", this.dBd.field_msgId);
    localIntent.putExtra("key_image_path", ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath);
    localIntent.putExtra("key_favorite", true);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/ui/chatting/AppAttachDownloadUI", "showFileImage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/AppAttachDownloadUI", "showFileImage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    AppMethodBeat.o(34152);
  }
  
  private void fAv()
  {
    AppMethodBeat.i(34159);
    this.JxC.setVisibility(0);
    this.JxD.setVisibility(8);
    fAw();
    this.Jxm.fAx();
    AppMethodBeat.o(34159);
  }
  
  private void fAw()
  {
    AppMethodBeat.i(34160);
    this.jai.setVisibility(8);
    AppMethodBeat.o(34160);
  }
  
  private void fB(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(34161);
    String str;
    if (6 == this.appType)
    {
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(1203L, paramInt2, 1L, false);
      str = this.Jxt.hAd;
      if (this.Jxt.hzS != 1) {
        break label208;
      }
    }
    label208:
    for (paramInt2 = 7;; paramInt2 = 5)
    {
      str = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { str, Integer.valueOf(paramInt2), Integer.valueOf(this.Jxt.hzO), Integer.valueOf(paramInt1), Long.valueOf((cf.aCL() - this.dBd.field_createTime) / 1000L), this.fVf, this.dBd.field_talker, Integer.valueOf(1), "", Long.valueOf(this.dBd.field_msgSvrId), Long.valueOf(this.dBd.field_createTime) });
      ad.i("MicroMsg.AppAttachDownloadUI", "reportKVStat 14665 %s", new Object[] { str });
      com.tencent.mm.plugin.report.service.g.yhR.kvStat(14665, str);
      AppMethodBeat.o(34161);
      return;
    }
  }
  
  private String getMimeType()
  {
    AppMethodBeat.i(34146);
    k.b localb = k.b.yr(this.dDP);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localb.hzP != null)
    {
      localObject1 = localObject2;
      if (localb.hzP.length() > 0) {
        localObject1 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(localb.hzP);
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
      localObject2 = "*/" + localb.hzP;
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
    if (!fAm())
    {
      finish();
      AppMethodBeat.o(34131);
      return;
    }
    com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(com.tencent.mm.loader.j.b.arX());
    if (!locale.exists()) {
      locale.mkdirs();
    }
    ao.bIX().add(this);
    initView();
    deI();
    AppMethodBeat.o(34131);
  }
  
  public final void a(String paramString, com.tencent.mm.sdk.e.m paramm)
  {
    AppMethodBeat.i(34149);
    com.tencent.mm.pluginsdk.model.app.c localc = fAr();
    int i;
    StringBuilder localStringBuilder;
    if (localc != null)
    {
      long l1 = localc.field_totalLen;
      long l2 = localc.field_offset;
      this.Jxu = l1;
      this.Jxo.setText(getString(2131758103, new Object[] { af.sy(l2), af.sy(l1) }));
      if (localc.field_totalLen != 0L) {
        break label425;
      }
      i = 0;
      ad.v("MicroMsg.AppAttachDownloadUI", "summerapp attach progress:" + i + " offset:" + l2 + " totallen:" + l1 + " status " + localc.field_status);
      this.Jxl.setProgress(i);
      if ((localc.field_status == 199L) && (i >= 100) && (!this.Jxw))
      {
        this.Jxw = true;
        if (this.JxE)
        {
          this.JxE = false;
          fAo();
        }
        if (localc != null)
        {
          localStringBuilder = new StringBuilder().append(getString(2131758120)).append(" : ");
          paramm = localc.field_fileFullPath;
          paramString = paramm;
          if (paramm != null)
          {
            String str = com.tencent.mm.loader.j.b.arP();
            paramm = com.tencent.mm.vfs.i.k(paramm, true);
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
      Toast.makeText(this, paramString, this.Jxz).show();
      com.tencent.mm.pluginsdk.ui.tools.a.a(this, localc.field_fileFullPath, this.fVf, this.fileName, 1);
      aq.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(193815);
          AppAttachDownloadUI.G(AppAttachDownloadUI.this);
          AppMethodBeat.o(193815);
        }
      }, 200L);
      if ((this.Jxl.getVisibility() != 0) && (i < 100) && (!localc.field_isUpload) && (localc.field_status == 101L))
      {
        ad.i("MicroMsg.AppAttachDownloadUI", "summerapp still downloading updateProgress progress[%d]", new Object[] { Integer.valueOf(i) });
        acG(0);
        this.Jxm.setVisibility(8);
      }
      AppMethodBeat.o(34149);
      return;
      i = (int)(localc.field_offset * 100L / localc.field_totalLen);
      break;
    }
  }
  
  public final MMActivity cwQ()
  {
    AppMethodBeat.i(221403);
    MMActivity localMMActivity = (MMActivity)super.getContext();
    AppMethodBeat.o(221403);
    return localMMActivity;
  }
  
  public final void dEj()
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
    this.xdL = ((MMImageView)findViewById(2131299226));
    this.Jxl = ((RoundProgressBtn)findViewById(2131304258));
    this.Jxm = new a((Button)findViewById(2131299199), (TextView)findViewById(2131299200));
    this.rzQ = ((Button)findViewById(2131299212));
    this.Jxn = findViewById(2131299201);
    this.jai = ((TextView)findViewById(2131299208));
    this.Jxo = ((TextView)findViewById(2131299202));
    this.Jxp = ((TextView)findViewById(2131299206));
    this.Jxq = ((TextView)findViewById(2131299207));
    this.JxC = ((LinearLayout)findViewById(2131299210));
    this.JxD = ((LinearLayout)findViewById(2131301484));
    this.Jxp.setOnTouchListener(this.rAi);
    this.Jxp.setOnLongClickListener(this.rAj);
    if (this.Jxp != null)
    {
      localObject = this.Jxp.getPaint();
      if (localObject != null) {
        ((Paint)localObject).setFakeBoldText(true);
      }
    }
    this.Jxl.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(34122);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/AppAttachDownloadUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        AppAttachDownloadUI.a(AppAttachDownloadUI.this, 8);
        AppAttachDownloadUI.s(AppAttachDownloadUI.this).setVisibility(0);
        AppAttachDownloadUI.t(AppAttachDownloadUI.this).setVisibility(8);
        ad.i("MicroMsg.AppAttachDownloadUI", "summerapp roundProgressBar downloadAppAttachScene[%s]", new Object[] { AppAttachDownloadUI.a(AppAttachDownloadUI.this) });
        if (AppAttachDownloadUI.a(AppAttachDownloadUI.this) != null)
        {
          AppAttachDownloadUI.a(AppAttachDownloadUI.this).a(AppAttachDownloadUI.this);
          com.tencent.mm.kernel.g.aiU().a(AppAttachDownloadUI.a(AppAttachDownloadUI.this));
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/AppAttachDownloadUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(34122);
          return;
          paramAnonymousView = AppAttachDownloadUI.u(AppAttachDownloadUI.this);
          if ((paramAnonymousView != null) && (paramAnonymousView.field_status != 199L))
          {
            ad.i("MicroMsg.AppAttachDownloadUI", "summerapp roundProgressBar onClick but scene is null and set status[%d] paused", new Object[] { Long.valueOf(paramAnonymousView.field_status) });
            paramAnonymousView.field_status = 102L;
            ao.bIX().a(paramAnonymousView, new String[0]);
          }
        }
      }
    });
    Object localObject = this.Jxm;
    View.OnClickListener local11 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(193819);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/AppAttachDownloadUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        AppAttachDownloadUI.a(AppAttachDownloadUI.this, 0);
        AppAttachDownloadUI.s(AppAttachDownloadUI.this).setVisibility(8);
        if (AppAttachDownloadUI.v(AppAttachDownloadUI.this))
        {
          paramAnonymousView = AppAttachDownloadUI.u(AppAttachDownloadUI.this);
          if (paramAnonymousView != null)
          {
            paramAnonymousView.field_status = 101L;
            paramAnonymousView.field_lastModifyTime = bt.aQJ();
            ao.bIX().a(paramAnonymousView, new String[0]);
          }
          AppAttachDownloadUI.a(AppAttachDownloadUI.this, new com.tencent.mm.plugin.record.b.f(AppAttachDownloadUI.w(AppAttachDownloadUI.this), AppAttachDownloadUI.x(AppAttachDownloadUI.this), AppAttachDownloadUI.y(AppAttachDownloadUI.this)));
          ba.aiU().a(AppAttachDownloadUI.a(AppAttachDownloadUI.this), 0);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/AppAttachDownloadUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(193819);
      }
    };
    ((a)localObject).sfz.setOnClickListener(local11);
    this.rzQ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(193814);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/AppAttachDownloadUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        AppAttachDownloadUI.E(AppAttachDownloadUI.this);
        AppAttachDownloadUI.F(AppAttachDownloadUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/AppAttachDownloadUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(193814);
      }
    });
    switch (this.appType)
    {
    case 1: 
    case 3: 
    case 5: 
    default: 
      this.xdL.setImageResource(2131689577);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(34114);
          if (AppAttachDownloadUI.a(AppAttachDownloadUI.this) != null) {
            ba.aiU().a(AppAttachDownloadUI.a(AppAttachDownloadUI.this));
          }
          if ((AppAttachDownloadUI.b(AppAttachDownloadUI.this) != null) && (AppAttachDownloadUI.b(AppAttachDownloadUI.this).sv(1)))
          {
            AppMethodBeat.o(34114);
            return true;
          }
          AppAttachDownloadUI.this.finish();
          AppMethodBeat.o(34114);
          return true;
        }
      });
      this.dBt = getIntent().getBooleanExtra("app_show_share", true);
      if (this.dBt) {
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
      this.Jxw = false;
      if ((!fAn()) || (this.dBd.field_msgId != 0L)) {
        break label556;
      }
      this.Jxq.setVisibility(8);
      this.Jxp.setVisibility(0);
      if (this.fileName.equals("")) {
        this.Jxp.setText(getString(2131761808));
      }
      break;
    }
    for (;;)
    {
      fAv();
      AppMethodBeat.o(34139);
      return;
      this.xdL.setImageResource(2131230944);
      break;
      this.xdL.setImageResource(2131689581);
      break;
      this.xdL.setImageResource(com.tencent.mm.pluginsdk.model.q.aLB(this.fVf));
      break;
      if (bt.aRt(this.fVf))
      {
        this.xdL.setImageResource(2131230944);
        break;
      }
      this.xdL.setImageResource(2131689577);
      break;
      this.Jxp.setText(this.fileName);
    }
    label556:
    localObject = fAr();
    int i;
    if ((localObject == null) || (!new com.tencent.mm.vfs.e(((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath).exists()))
    {
      i = 0;
      if (i == 0) {
        break label707;
      }
      ad.i("MicroMsg.AppAttachDownloadUI", "summerapp isCanOpenFile");
      if (this.Jxu <= 0L) {
        break label695;
      }
      this.Jxq.setVisibility(0);
      this.Jxq.setText(getResources().getString(2131759078, new Object[] { af.sy(this.Jxu) }));
    }
    for (;;)
    {
      this.Jxw = true;
      fAs();
      AppMethodBeat.o(34139);
      return;
      if ((((com.tencent.mm.pluginsdk.model.app.c)localObject).cWz()) || ((this.dBd.field_isSend == 1) && (((com.tencent.mm.pluginsdk.model.app.c)localObject).field_isUpload)))
      {
        i = 1;
        break;
      }
      i = 0;
      break;
      label695:
      this.Jxq.setVisibility(8);
    }
    label707:
    if (this.Jxu > 0L)
    {
      this.Jxq.setVisibility(0);
      this.Jxq.setText(getResources().getString(2131759078, new Object[] { af.sy(this.Jxu) }));
    }
    while (this.Jxw)
    {
      AppMethodBeat.o(34139);
      return;
      this.Jxq.setVisibility(8);
    }
    this.Jxr = new com.tencent.mm.al.g()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, n paramAnonymousn)
      {
        AppMethodBeat.i(193818);
        if (paramAnonymousInt2 == 0) {}
        for (float f = 0.0F;; f = paramAnonymousInt1 * 100.0F / paramAnonymousInt2)
        {
          if ((paramAnonymousInt1 < paramAnonymousInt2) && (AppAttachDownloadUI.r(AppAttachDownloadUI.this).getVisibility() != 0))
          {
            AppAttachDownloadUI.a(AppAttachDownloadUI.this, 0);
            AppAttachDownloadUI.s(AppAttachDownloadUI.this).setVisibility(8);
          }
          AppAttachDownloadUI.r(AppAttachDownloadUI.this).setProgress((int)f);
          AppMethodBeat.o(193818);
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
      ad.i("MicroMsg.AppAttachDownloadUI", "summerapp progressCallBack[%s], isDownloadFinished[%b], isDownloadStarted[%b]", new Object[] { this.Jxr, Boolean.valueOf(this.Jxw), Boolean.valueOf(this.Jxx) });
      if ((this.appType == 2) || ((!this.Jxw) && (!this.Jxx))) {
        fAp();
      }
      AppMethodBeat.o(34139);
      return;
    case 0: 
    case 6: 
      if (this.Jxx)
      {
        this.Jxm.setVisibility(0);
        acG(8);
        this.Jxn.setVisibility(8);
        this.rzQ.setVisibility(8);
        fAw();
        this.Jxp.setVisibility(0);
        if (!this.fileName.equals("")) {
          break label1056;
        }
        this.Jxp.setText(getString(2131761808));
        localObject = getMimeType();
        if ((localObject != null) && (!((String)localObject).equals(""))) {
          break label1070;
        }
        this.jai.setText(getString(2131758100));
      }
      while (bt.aRt(this.fVf))
      {
        fAw();
        break;
        this.Jxm.setVisibility(8);
        break label931;
        this.Jxp.setText(this.fileName);
        break label994;
        this.jai.setText(getString(2131758101));
      }
    case 7: 
      label931:
      label994:
      if (this.Jxx) {
        this.Jxm.setVisibility(0);
      }
      for (;;)
      {
        label1056:
        label1070:
        acG(8);
        this.Jxn.setVisibility(8);
        this.rzQ.setVisibility(8);
        this.Jxp.setVisibility(8);
        fAw();
        this.jai.setText(getString(2131758101));
        break;
        this.Jxm.setVisibility(8);
      }
    }
    acG(8);
    this.Jxn.setVisibility(8);
    if (this.Jxx) {
      this.Jxm.setVisibility(0);
    }
    for (;;)
    {
      this.rzQ.setVisibility(8);
      this.Jxp.setVisibility(8);
      fAw();
      break;
      this.Jxm.setVisibility(8);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(34148);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.tencent.mm.pluginsdk.ui.tools.a.a(this, paramInt1, paramInt2, paramIntent, this.Jxy, 2131758111, 2131758112, 1);
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
    ao.bIX().remove(this);
    super.onDestroy();
    if (this.Fkw != null) {
      this.Fkw.onDestroy();
    }
    if (this.rAg != null) {
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).d(this.rAg);
    }
    AppMethodBeat.o(34136);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(34140);
    ad.i("MicroMsg.AppAttachDownloadUI", "onKeyDown keyCode %d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt == 4) && (this.Fkw != null) && (this.Fkw.sv(2)))
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
    if (this.Fkw != null)
    {
      this.Fkw.bgC();
      this.Fkw.onDestroy();
    }
    init();
    AppMethodBeat.o(34156);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(34138);
    ba.aiU().b(221, this);
    ba.aiU().b(728, this);
    super.onPause();
    if (this.Fkw != null) {
      this.Fkw.bgC();
    }
    on localon = new on();
    localon.dCu.dCv = false;
    on.a locala = localon.dCu;
    if (this.dBd == null) {}
    for (String str = "";; str = this.dBd.field_talker)
    {
      locala.talker = str;
      com.tencent.mm.sdk.b.a.IbL.a(localon, getMainLooper());
      ad.d("MicroMsg.AppAttachDownloadUI", "AppAttachDownloadUI cancel pause auto download logic");
      AppMethodBeat.o(34138);
      return;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(34137);
    super.onResume();
    ba.aiU().a(221, this);
    ba.aiU().a(728, this);
    on localon = new on();
    localon.dCu.dCv = true;
    localon.dCu.talker = this.dBd.field_talker;
    com.tencent.mm.sdk.b.a.IbL.a(localon, getMainLooper());
    ad.d("MicroMsg.AppAttachDownloadUI", "AppAttachDownloadUI req pause auto download logic");
    this.rzQ.setEnabled(true);
    if (this.Fkw != null) {
      this.Fkw.bgB();
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
      paramString = fAr();
      if (paramString == null)
      {
        ad.i("MicroMsg.AppAttachDownloadUI", "summerapp onSceneEnd getAppAttachInfo is null");
        if (paramString != null)
        {
          paramString.field_status = 101L;
          paramString.field_lastModifyTime = bt.aQJ();
          ao.bIX().a(paramString, new String[0]);
        }
        this.xqu = new com.tencent.mm.plugin.record.b.f(this.msgId, this.mediaId, this.Jxr);
        ba.aiU().a(this.xqu, 0);
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
    if ((this.xqu == null) && ((paramn instanceof com.tencent.mm.plugin.record.b.f)))
    {
      paramString = (com.tencent.mm.plugin.record.b.f)paramn;
      com.tencent.mm.pluginsdk.model.app.c localc = fAr();
      if ((localc != null) && (!af.isNullOrNil(localc.field_mediaSvrId)) && (localc.field_mediaSvrId.equals(paramString.getMediaId())))
      {
        this.xqu = paramString;
        ad.i("MicroMsg.AppAttachDownloadUI", "summerapp onSceneEnd reset downloadAppAttachScene[%s] by mediaSvrId[%s]", new Object[] { this.xqu, localc.field_mediaSvrId });
      }
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (this.Jxt.type == 6)
      {
        fB(0, 2);
        paramString = fAr();
        if (paramString != null) {
          com.tencent.mm.plugin.report.e.ygI.idkeyStat(1203L, 5L, paramString.field_totalLen, false);
        }
      }
      AppMethodBeat.o(34154);
      return;
    }
    if ((paramInt2 != 0) && (com.tencent.mm.sdk.a.b.fjN())) {
      Toast.makeText(this, "errCode[" + paramInt2 + "]", 0).show();
    }
    if (paramInt2 == -5103059)
    {
      fAv();
      acG(8);
      fB(1, 3);
      AppMethodBeat.o(34154);
      return;
    }
    acG(8);
    this.Jxm.setVisibility(0);
    this.Jxn.setVisibility(8);
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
    Button sfz;
    private TextView vk;
    private boolean xsq;
    
    public a(Button paramButton, TextView paramTextView)
    {
      AppMethodBeat.i(34126);
      this.sfz = paramButton;
      this.vk = paramTextView;
      if (paramTextView != null)
      {
        int i = com.tencent.mm.n.g.acA().getInt("MsgFileExpiredInterval", 432000);
        long l = AppAttachDownloadUI.H(AppAttachDownloadUI.this).field_createTime / 1000L;
        Math.floor((i - cf.rM(l)) * 1.0D / 86400.0D);
        paramTextView.setText("");
      }
      AppMethodBeat.o(34126);
    }
    
    public final void fAx()
    {
      AppMethodBeat.i(34128);
      ad.i("MicroMsg.AppAttachDownloadUI", "showErrorTip overtime %s", new Object[] { Long.valueOf(AppAttachDownloadUI.H(AppAttachDownloadUI.this).field_msgId) });
      if (this.sfz != null) {
        this.sfz.setVisibility(4);
      }
      if (this.vk != null)
      {
        this.vk.setVisibility(0);
        this.vk.setText(2131759063);
        this.vk.setTextColor(AppAttachDownloadUI.this.getResources().getColor(2131099805));
        AppAttachDownloadUI.I(AppAttachDownloadUI.this).setVisibility(8);
        AppAttachDownloadUI.t(AppAttachDownloadUI.this).setVisibility(8);
        if (!this.xsq)
        {
          this.xsq = true;
          AppAttachDownloadUI.J(AppAttachDownloadUI.this);
        }
      }
      AppMethodBeat.o(34128);
    }
    
    public final void setVisibility(int paramInt)
    {
      AppMethodBeat.i(34127);
      if (this.sfz != null) {
        this.sfz.setVisibility(paramInt);
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