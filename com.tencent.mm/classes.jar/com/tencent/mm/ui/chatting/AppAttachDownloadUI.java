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
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.g;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.cm;
import com.tencent.mm.g.a.mj;
import com.tencent.mm.g.a.mj.a;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.t;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.plugin.record.b.e.a;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.tools.ShowImageUI;
import com.tencent.mm.ui.widget.progress.RoundProgressBtn;

public class AppAttachDownloadUI
  extends MMActivity
  implements f, e.a, k.a
{
  private String cBO;
  private boolean cBz;
  private String cDI;
  private bi cEE;
  private long cpO;
  private String czp;
  private int edl;
  private String elt;
  private String ewj;
  private String fileName;
  private TextView gtP;
  private int jUm;
  private int jUn;
  private com.tencent.mm.ui.widget.c.a jVd;
  private n.d lNZ;
  private View.OnTouchListener mAc;
  private View.OnLongClickListener mAd;
  private Button mzM;
  private String nKQ;
  private MMImageView pKQ;
  private com.tencent.mm.plugin.record.b.e pYd;
  private int scene;
  private g zvA;
  private boolean zvB;
  private j.b zvC;
  private long zvD;
  private boolean zvE;
  private boolean zvF;
  private boolean zvG;
  private int zvH;
  private boolean zvI;
  private LinearLayout zvJ;
  private LinearLayout zvK;
  private boolean zvL;
  private RoundProgressBtn zvu;
  private AppAttachDownloadUI.a zvv;
  private View zvw;
  private TextView zvx;
  private TextView zvy;
  private TextView zvz;
  
  public AppAttachDownloadUI()
  {
    AppMethodBeat.i(30280);
    this.zvE = false;
    this.zvF = false;
    this.zvG = true;
    this.zvH = 5000;
    this.zvI = false;
    this.zvL = false;
    this.jVd = null;
    this.lNZ = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(30273);
        ClipboardManager localClipboardManager = (ClipboardManager)com.tencent.mm.sdk.platformtools.ah.getContext().getSystemService("clipboard");
        if (AppAttachDownloadUI.s(AppAttachDownloadUI.this).equals("")) {}
        for (paramAnonymousMenuItem = AppAttachDownloadUI.this.getString(2131302024);; paramAnonymousMenuItem = AppAttachDownloadUI.s(AppAttachDownloadUI.this))
        {
          localClipboardManager.setPrimaryClip(ClipData.newPlainText(null, paramAnonymousMenuItem));
          com.tencent.mm.ui.base.h.bO(AppAttachDownloadUI.this, AppAttachDownloadUI.this.getString(2131296896));
          AppMethodBeat.o(30273);
          return;
        }
      }
    };
    this.mAc = new AppAttachDownloadUI.11(this);
    this.mAd = new AppAttachDownloadUI.12(this);
    AppMethodBeat.o(30280);
  }
  
  private void Pf(int paramInt)
  {
    AppMethodBeat.i(30312);
    if (paramInt != this.zvu.getVisibility())
    {
      ab.i("MicroMsg.AppAttachDownloadUI", "setRoundProgressBar %s %s", new Object[] { Integer.valueOf(paramInt), com.tencent.mm.platformtools.ah.aoA() });
      this.zvu.setVisibility(paramInt);
    }
    AppMethodBeat.o(30312);
  }
  
  private String atH(String paramString)
  {
    AppMethodBeat.i(30290);
    String str = paramString;
    if (this.zvB)
    {
      str = paramString;
      if (paramString != null) {
        str = bf.pv(paramString);
      }
    }
    AppMethodBeat.o(30290);
    return str;
  }
  
  private static boolean b(com.tencent.mm.pluginsdk.model.app.b paramb)
  {
    AppMethodBeat.i(30311);
    if (paramb == null)
    {
      AppMethodBeat.o(30311);
      return false;
    }
    com.tencent.mm.vfs.b localb = new com.tencent.mm.vfs.b(paramb.field_fileFullPath);
    if ((localb.exists()) && (localb.length() == paramb.field_totalLen))
    {
      AppMethodBeat.o(30311);
      return true;
    }
    AppMethodBeat.o(30311);
    return false;
  }
  
  private void cdY()
  {
    AppMethodBeat.i(30307);
    ab.i("MicroMsg.AppAttachDownloadUI", "[ImageGalleryUI] showImage");
    Intent localIntent = new Intent(this, ImageGalleryUI.class);
    localIntent.putExtra("img_gallery_msg_id", this.cEE.field_msgId);
    localIntent.putExtra("img_gallery_talker", this.cEE.field_talker);
    startActivity(localIntent);
    finish();
    overridePendingTransition(0, 0);
    AppMethodBeat.o(30307);
  }
  
  private boolean dFq()
  {
    AppMethodBeat.i(30283);
    this.scene = getIntent().getIntExtra("scene", 0);
    this.cpO = getIntent().getLongExtra("app_msg_id", -1L);
    this.zvI = getIntent().getBooleanExtra("choose_way", false);
    if (this.cpO == -1L)
    {
      AppMethodBeat.o(30283);
      return false;
    }
    aw.aaz();
    this.cEE = com.tencent.mm.model.c.YC().kB(this.cpO);
    if ((this.cEE == null) || (this.cEE.field_msgId == 0L) || (this.cEE.field_content == null))
    {
      AppMethodBeat.o(30283);
      return false;
    }
    this.zvB = t.lA(this.cEE.field_talker);
    this.cDI = this.cEE.field_content;
    if ((this.zvB) && (this.cEE.field_isSend == 0)) {
      this.cDI = atH(this.cEE.field_content);
    }
    this.zvC = j.b.mY(this.cDI);
    if (this.zvC == null)
    {
      ab.e("MicroMsg.AppAttachDownloadUI", "summerapp parse msgContent error, %s", new Object[] { this.cDI });
      AppMethodBeat.o(30283);
      return false;
    }
    if ((com.tencent.mm.platformtools.ah.isNullOrNil(this.zvC.cmN)) && (!com.tencent.mm.platformtools.ah.isNullOrNil(this.zvC.fgL)))
    {
      ab.e("MicroMsg.AppAttachDownloadUI", "summerapp msgContent format error, %s", new Object[] { this.cDI });
      this.zvC.cmN = this.zvC.fgL.hashCode();
    }
    this.edl = this.zvC.type;
    this.cBO = this.zvC.cmN;
    this.fileName = com.tencent.mm.platformtools.ah.nullAsNil(this.zvC.title);
    this.elt = com.tencent.mm.platformtools.ah.nullAsNil(this.zvC.fgx).toLowerCase();
    this.zvD = this.zvC.fgw;
    this.nKQ = com.tencent.mm.platformtools.ah.nullAsNil(this.zvC.filemd5);
    this.czp = com.tencent.mm.platformtools.ah.nullAsNil(this.zvC.czp);
    this.ewj = com.tencent.mm.platformtools.ah.nullAsNil(this.zvC.ewj);
    if (com.tencent.mm.platformtools.ah.isNullOrNil(this.elt)) {
      this.elt = com.tencent.mm.vfs.e.cP(this.fileName);
    }
    ab.i("MicroMsg.AppAttachDownloadUI", "summerapp initParams msgId[%d], sender[%d], msgContent[%s], appType[%d], mediaId[%s], fileName[%s]", new Object[] { Long.valueOf(this.cpO), Integer.valueOf(this.cEE.field_isSend), this.cDI, Integer.valueOf(this.edl), this.cBO, this.fileName });
    com.tencent.mm.pluginsdk.model.app.b localb = dFu();
    if (localb == null)
    {
      ab.i("MicroMsg.AppAttachDownloadUI", "summerapp initParams attInfo is null");
      this.zvF = false;
      if (!b(localb)) {
        break label716;
      }
      if (this.scene != 1) {
        break label666;
      }
      if (this.zvI)
      {
        bool = com.tencent.mm.pluginsdk.ui.tools.a.b(this, localb.field_fileFullPath, this.elt, 7);
        AppMethodBeat.o(30283);
        return bool;
      }
    }
    else
    {
      new com.tencent.mm.vfs.b(localb.field_fileFullPath);
      if (localb.field_offset > 0L) {}
      for (this.zvF = true;; this.zvF = false)
      {
        ab.i("MicroMsg.AppAttachDownloadUI", "summerapp initParams attInfo field_fileFullPath[%s], field_offset[%d], isDownloadStarted[%b]", new Object[] { localb.field_fileFullPath, Long.valueOf(localb.field_offset), Boolean.valueOf(this.zvF) });
        break;
      }
    }
    boolean bool = com.tencent.mm.pluginsdk.ui.tools.a.R(localb.field_fileFullPath, this.elt, 7);
    AppMethodBeat.o(30283);
    return bool;
    label666:
    if (this.zvI)
    {
      bool = com.tencent.mm.pluginsdk.ui.tools.a.b(this, localb.field_fileFullPath, this.elt, 1);
      AppMethodBeat.o(30283);
      return bool;
    }
    bool = com.tencent.mm.pluginsdk.ui.tools.a.R(localb.field_fileFullPath, this.elt, 1);
    AppMethodBeat.o(30283);
    return bool;
    label716:
    AppMethodBeat.o(30283);
    return true;
  }
  
  private void dFr()
  {
    AppMethodBeat.i(30289);
    cm localcm = new cm();
    com.tencent.mm.pluginsdk.model.e.d(localcm, this.cEE);
    localcm.cpR.activity = this;
    localcm.cpR.cpY = 39;
    com.tencent.mm.sdk.b.a.ymk.l(localcm);
    AppMethodBeat.o(30289);
  }
  
  private void dFs()
  {
    AppMethodBeat.i(30295);
    Pf(0);
    this.zvv.setVisibility(8);
    if (dFt())
    {
      ab.i("MicroMsg.AppAttachDownloadUI", "startToDownloadFile");
      this.pYd = new com.tencent.mm.plugin.record.b.e(this.cpO, this.cBO, this.zvA);
      aw.Rc().a(this.pYd, 0);
      aa.C(this.cEE);
    }
    AppMethodBeat.o(30295);
  }
  
  private boolean dFt()
  {
    int i = -1;
    boolean bool2 = true;
    AppMethodBeat.i(30298);
    Object localObject1 = dFu();
    Object localObject2;
    boolean bool1;
    long l1;
    long l2;
    long l3;
    String str1;
    long l4;
    if (localObject1 == null)
    {
      l.s(this.cpO, this.cDI);
      localObject2 = dFu();
      localObject1 = localObject2;
      bool1 = bool2;
      if (localObject2 != null)
      {
        l1 = ((com.tencent.mm.pluginsdk.model.app.b)localObject2).systemRowid;
        l2 = ((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_totalLen;
        localObject1 = ((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_fileFullPath;
        l3 = ((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_type;
        str1 = ((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_mediaId;
        l4 = ((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_msgInfoId;
        bool1 = ((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_isUpload;
        if (((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_signature != null) {
          break label304;
        }
        ab.i("MicroMsg.AppAttachDownloadUI", "summerapp tryInitAttachInfo newInfo systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], signature len[%d]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), localObject1, Long.valueOf(l3), str1, Long.valueOf(l4), Boolean.valueOf(bool1), Integer.valueOf(i) });
        if (this.zvC.fgA == 0)
        {
          localObject1 = localObject2;
          bool1 = bool2;
          if (this.zvC.fgw <= 26214400) {}
        }
        else
        {
          if (com.tencent.mm.platformtools.ah.isNullOrNil(((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_signature)) {
            break label316;
          }
          bool1 = true;
          label219:
          localObject1 = localObject2;
        }
      }
      if ((this.zvC == null) || ((this.zvC.fgA == 0) && (this.zvC.fgw <= 26214400))) {
        break label551;
      }
      bool1 = false;
    }
    label551:
    for (;;)
    {
      if (!bool1) {
        aw.Rc().a(new com.tencent.mm.plugin.record.b.c((com.tencent.mm.pluginsdk.model.app.b)localObject1, this.ewj, this.nKQ, this.fileName, this.elt, this.czp), 0);
      }
      AppMethodBeat.o(30298);
      return bool1;
      label304:
      i = ((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_signature.length();
      break;
      label316:
      bool1 = false;
      break label219;
      localObject2 = new com.tencent.mm.vfs.b(((com.tencent.mm.pluginsdk.model.app.b)localObject1).field_fileFullPath);
      if ((((com.tencent.mm.pluginsdk.model.app.b)localObject1).field_status == 199L) && (!((com.tencent.mm.vfs.b)localObject2).exists()))
      {
        ab.i("MicroMsg.AppAttachDownloadUI", "summerapp tryInitAttachInfo info exist but file not!");
        l.s(this.cpO, this.cDI);
      }
      l1 = ((com.tencent.mm.pluginsdk.model.app.b)localObject1).systemRowid;
      l2 = ((com.tencent.mm.pluginsdk.model.app.b)localObject1).field_totalLen;
      str1 = ((com.tencent.mm.pluginsdk.model.app.b)localObject1).field_fileFullPath;
      l3 = ((com.tencent.mm.pluginsdk.model.app.b)localObject1).field_type;
      String str2 = ((com.tencent.mm.pluginsdk.model.app.b)localObject1).field_mediaId;
      l4 = ((com.tencent.mm.pluginsdk.model.app.b)localObject1).field_msgInfoId;
      bool1 = ((com.tencent.mm.pluginsdk.model.app.b)localObject1).field_isUpload;
      boolean bool3 = ((com.tencent.mm.vfs.b)localObject2).exists();
      long l5 = ((com.tencent.mm.pluginsdk.model.app.b)localObject1).field_status;
      if (((com.tencent.mm.pluginsdk.model.app.b)localObject1).field_signature == null) {}
      for (;;)
      {
        ab.i("MicroMsg.AppAttachDownloadUI", "summerapp tryInitAttachInfo info exist systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], file.exists[%b], status[%d], signature len[%d]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), str1, Long.valueOf(l3), str2, Long.valueOf(l4), Boolean.valueOf(bool1), Boolean.valueOf(bool3), Long.valueOf(l5), Integer.valueOf(i) });
        bool1 = bool2;
        break;
        i = ((com.tencent.mm.pluginsdk.model.app.b)localObject1).field_signature.length();
      }
    }
  }
  
  private com.tencent.mm.pluginsdk.model.app.b dFu()
  {
    AppMethodBeat.i(30301);
    com.tencent.mm.pluginsdk.model.app.b localb1 = com.tencent.mm.pluginsdk.model.app.al.aUJ().nw(this.cpO);
    if (localb1 != null)
    {
      ab.i("MicroMsg.AppAttachDownloadUI", "summerapp getAppAttachInfo by msgId [%d] stack[%s]", new Object[] { Long.valueOf(this.cpO), com.tencent.mm.platformtools.ah.aoA() });
      AppMethodBeat.o(30301);
      return localb1;
    }
    localb1 = l.alv(this.cBO);
    if (localb1 == null)
    {
      ab.i("MicroMsg.AppAttachDownloadUI", "summerapp getAppAttachInfo by msgId and mediaId is null stack[%s]", new Object[] { com.tencent.mm.platformtools.ah.aoA() });
      AppMethodBeat.o(30301);
      return localb1;
    }
    if ((localb1.field_msgInfoId == this.cpO) || (com.tencent.mm.vfs.e.cN(localb1.field_fileFullPath)))
    {
      AppMethodBeat.o(30301);
      return localb1;
    }
    l.s(this.cpO, this.cDI);
    com.tencent.mm.pluginsdk.model.app.b localb2 = com.tencent.mm.pluginsdk.model.app.al.aUJ().nw(this.cpO);
    if (localb2 == null)
    {
      ab.w("MicroMsg.AppAttachDownloadUI", "summerapp getAppAttachInfo create new info from local but failed stack[%s]", new Object[] { com.tencent.mm.platformtools.ah.aoA() });
      AppMethodBeat.o(30301);
      return localb1;
    }
    d.post(new AppAttachDownloadUI.3(this, localb1, localb2), "copyAttachFromLocal");
    AppMethodBeat.o(30301);
    return localb1;
  }
  
  private void dFv()
  {
    AppMethodBeat.i(30304);
    switch (this.edl)
    {
    case 1: 
    case 3: 
    case 4: 
    case 5: 
    default: 
      this.mzM.setVisibility(0);
      Pf(8);
      this.zvw.setVisibility(8);
    case 0: 
    case 6: 
    case 2: 
      do
      {
        do
        {
          AppMethodBeat.o(30304);
          return;
        } while (!dFw());
        if (bo.aqj(this.elt))
        {
          dFx();
          AppMethodBeat.o(30304);
          return;
        }
        localObject = getMimeType();
        ab.i("MicroMsg.AppAttachDownloadUI", "onDownLoadImpl");
        dFz();
        Pf(8);
        this.zvw.setVisibility(8);
        this.zvv.setVisibility(8);
        this.zvy.setVisibility(0);
        if (this.fileName.equals("")) {
          this.zvy.setText(getString(2131302024));
        }
        while ((localObject == null) || (((String)localObject).equals("")))
        {
          this.mzM.setVisibility(8);
          this.gtP.setText(getString(2131299000));
          AppMethodBeat.o(30304);
          return;
          this.zvy.setText(this.fileName);
        }
        this.mzM.setVisibility(0);
        this.gtP.setText(getString(2131299001));
        AppMethodBeat.o(30304);
        return;
      } while (!dFw());
      cdY();
      AppMethodBeat.o(30304);
      return;
    }
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("App_MsgId", this.cpO);
    setResult(-1, (Intent)localObject);
    finish();
    AppMethodBeat.o(30304);
  }
  
  private boolean dFw()
  {
    AppMethodBeat.i(30305);
    com.tencent.mm.pluginsdk.model.app.b localb = dFu();
    if (localb == null)
    {
      AppMethodBeat.o(30305);
      return true;
    }
    if (com.tencent.mm.vfs.e.cN(localb.field_fileFullPath))
    {
      Pf(8);
      this.zvw.setVisibility(8);
      this.zvv.setVisibility(8);
      AppMethodBeat.o(30305);
      return true;
    }
    Pf(8);
    dFy();
    AppMethodBeat.o(30305);
    return false;
  }
  
  private void dFx()
  {
    AppMethodBeat.i(30306);
    com.tencent.mm.pluginsdk.model.app.b localb = dFu();
    Intent localIntent = new Intent(this, ShowImageUI.class);
    localIntent.putExtra("key_message_id", this.cEE.field_msgId);
    localIntent.putExtra("key_image_path", localb.field_fileFullPath);
    localIntent.putExtra("key_favorite", true);
    startActivity(localIntent);
    finish();
    AppMethodBeat.o(30306);
  }
  
  private void dFy()
  {
    AppMethodBeat.i(30313);
    this.zvJ.setVisibility(0);
    this.zvK.setVisibility(8);
    dFz();
    this.zvv.dFA();
    AppMethodBeat.o(30313);
  }
  
  private void dFz()
  {
    AppMethodBeat.i(30314);
    this.gtP.setVisibility(8);
    AppMethodBeat.o(30314);
  }
  
  private String getMimeType()
  {
    AppMethodBeat.i(30300);
    j.b localb = j.b.mY(this.cDI);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localb.fgx != null)
    {
      localObject1 = localObject2;
      if (localb.fgx.length() > 0) {
        localObject1 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(localb.fgx);
      }
    }
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((String)localObject1).length() != 0) {}
    }
    else
    {
      ab.w("MicroMsg.AppAttachDownloadUI", "getMimeType fail, not a built-in mimetype, use \"*/{fileext}\" instead");
      localObject2 = "*/" + localb.fgx;
    }
    AppMethodBeat.o(30300);
    return localObject2;
  }
  
  private void init()
  {
    AppMethodBeat.i(30282);
    setMMTitle("");
    setActionbarColor(getResources().getColor(2131689615));
    hideActionbarLine();
    if (!dFq())
    {
      finish();
      AppMethodBeat.o(30282);
      return;
    }
    com.tencent.mm.vfs.b localb = new com.tencent.mm.vfs.b(com.tencent.mm.compatible.util.e.esq);
    if (!localb.exists()) {
      localb.mkdirs();
    }
    com.tencent.mm.pluginsdk.model.app.al.aUJ().add(this);
    initView();
    AppMethodBeat.o(30282);
  }
  
  public final void a(String paramString, com.tencent.mm.sdk.e.m paramm)
  {
    AppMethodBeat.i(30303);
    paramString = dFu();
    long l1;
    long l2;
    if (paramString != null)
    {
      l1 = paramString.field_totalLen;
      l2 = paramString.field_offset;
      this.zvD = l1;
      this.zvx.setText(getString(2131299003, new Object[] { com.tencent.mm.platformtools.ah.hk(l2), com.tencent.mm.platformtools.ah.hk(l1) }));
      if (paramString.field_totalLen != 0L) {
        break label346;
      }
    }
    label346:
    for (int i = 0;; i = (int)(paramString.field_offset * 100L / paramString.field_totalLen))
    {
      ab.v("MicroMsg.AppAttachDownloadUI", "summerapp attach progress:" + i + " offset:" + l2 + " totallen:" + l1 + " status " + paramString.field_status);
      this.zvu.setProgress(i);
      if ((paramString.field_status == 199L) && (i >= 100) && (!this.zvE))
      {
        this.zvE = true;
        if (this.zvL)
        {
          this.zvL = false;
          dFr();
        }
        if (paramString != null)
        {
          Toast.makeText(this, getString(2131299017) + " : " + paramString.field_fileFullPath.replaceFirst(com.tencent.mm.compatible.util.e.eQx, com.tencent.mm.compatible.util.e.eso), this.zvH).show();
          com.tencent.mm.pluginsdk.ui.tools.a.a(this, paramString.field_fileFullPath, this.elt, 1);
        }
        com.tencent.mm.sdk.platformtools.al.p(new AppAttachDownloadUI.4(this), 200L);
      }
      if ((this.zvu.getVisibility() != 0) && (i < 100) && (!paramString.field_isUpload) && (paramString.field_status == 101L))
      {
        ab.i("MicroMsg.AppAttachDownloadUI", "summerapp still downloading updateProgress progress[%d]", new Object[] { Integer.valueOf(i) });
        Pf(0);
        this.zvv.setVisibility(8);
      }
      AppMethodBeat.o(30303);
      return;
    }
  }
  
  public final void cfP()
  {
    AppMethodBeat.i(30309);
    Toast.makeText(this, 2131299013, 0).show();
    AppMethodBeat.o(30309);
  }
  
  public int getLayoutId()
  {
    return 2130969336;
  }
  
  public void initView()
  {
    AppMethodBeat.i(30299);
    this.pKQ = ((MMImageView)findViewById(2131821561));
    this.zvu = ((RoundProgressBtn)findViewById(2131823457));
    this.zvv = new AppAttachDownloadUI.a(this, (Button)findViewById(2131823458), (TextView)findViewById(2131823459));
    this.mzM = ((Button)findViewById(2131823460));
    this.zvw = findViewById(2131823454);
    this.gtP = ((TextView)findViewById(2131823456));
    this.zvx = ((TextView)findViewById(2131823455));
    this.zvy = ((TextView)findViewById(2131823452));
    this.zvz = ((TextView)findViewById(2131823453));
    this.zvJ = ((LinearLayout)findViewById(2131823451));
    this.zvK = ((LinearLayout)findViewById(2131823461));
    this.zvy.setOnTouchListener(this.mAc);
    this.zvy.setOnLongClickListener(this.mAd);
    if (this.zvy != null)
    {
      localObject = this.zvy.getPaint();
      if (localObject != null) {
        ((Paint)localObject).setFakeBoldText(true);
      }
    }
    this.zvu.setOnClickListener(new AppAttachDownloadUI.8(this));
    Object localObject = this.zvv;
    AppAttachDownloadUI.9 local9 = new AppAttachDownloadUI.9(this);
    ((AppAttachDownloadUI.a)localObject).uxz.setOnClickListener(local9);
    this.mzM.setOnClickListener(new AppAttachDownloadUI.2(this));
    int i;
    switch (this.edl)
    {
    case 1: 
    case 3: 
    case 5: 
    default: 
      this.pKQ.setImageResource(2131230822);
      setBackBtn(new AppAttachDownloadUI.1(this));
      this.cBz = getIntent().getBooleanExtra("app_show_share", true);
      if (this.cBz) {
        addIconOptionMenu(0, 2131230740, new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(30268);
            AppAttachDownloadUI.a(AppAttachDownloadUI.this, AppAttachDownloadUI.b(AppAttachDownloadUI.this));
            AppMethodBeat.o(30268);
            return false;
          }
        });
      }
      this.zvE = false;
      localObject = dFu();
      if ((localObject == null) || (!new com.tencent.mm.vfs.b(((com.tencent.mm.pluginsdk.model.app.b)localObject).field_fileFullPath).exists()))
      {
        i = 0;
        label417:
        if (i == 0) {
          break label619;
        }
        ab.i("MicroMsg.AppAttachDownloadUI", "summerapp isCanOpenFile");
        if (this.zvD <= 0L) {
          break label607;
        }
        this.zvz.setVisibility(0);
        this.zvz.setText(getResources().getString(2131299895, new Object[] { com.tencent.mm.platformtools.ah.hk(this.zvD) }));
      }
      break;
    }
    for (;;)
    {
      this.zvE = true;
      dFv();
      AppMethodBeat.o(30299);
      return;
      this.pKQ.setImageResource(2130837708);
      break;
      this.pKQ.setImageResource(2131230826);
      break;
      this.pKQ.setImageResource(o.alm(this.elt));
      break;
      if (bo.aqj(this.elt))
      {
        this.pKQ.setImageResource(2130837708);
        break;
      }
      this.pKQ.setImageResource(2131230822);
      break;
      if ((((com.tencent.mm.pluginsdk.model.app.b)localObject).bEL()) || ((this.cEE.field_isSend == 1) && (((com.tencent.mm.pluginsdk.model.app.b)localObject).field_isUpload)))
      {
        i = 1;
        break label417;
      }
      i = 0;
      break label417;
      label607:
      this.zvz.setVisibility(8);
    }
    label619:
    if (this.zvD > 0L)
    {
      this.zvz.setVisibility(0);
      this.zvz.setText(getResources().getString(2131299895, new Object[] { com.tencent.mm.platformtools.ah.hk(this.zvD) }));
    }
    while (this.zvE)
    {
      AppMethodBeat.o(30299);
      return;
      this.zvz.setVisibility(8);
    }
    this.zvA = new AppAttachDownloadUI.7(this);
    switch (this.edl)
    {
    case 1: 
    case 3: 
    case 4: 
    case 5: 
    default: 
      ab.i("MicroMsg.AppAttachDownloadUI", "summerapp progressCallBack[%s], isDownloadFinished[%b], isDownloadStarted[%b]", new Object[] { this.zvA, Boolean.valueOf(this.zvE), Boolean.valueOf(this.zvF) });
      if ((this.edl == 2) || ((!this.zvE) && (!this.zvF))) {
        dFs();
      }
      AppMethodBeat.o(30299);
      return;
    case 0: 
    case 6: 
      if (this.zvF)
      {
        this.zvv.setVisibility(0);
        Pf(8);
        this.zvw.setVisibility(8);
        this.mzM.setVisibility(8);
        dFz();
        this.zvy.setVisibility(0);
        if (!this.fileName.equals("")) {
          break label968;
        }
        this.zvy.setText(getString(2131302024));
        localObject = getMimeType();
        if ((localObject != null) && (!((String)localObject).equals(""))) {
          break label982;
        }
        this.gtP.setText(getString(2131299000));
      }
      while (bo.aqj(this.elt))
      {
        dFz();
        break;
        this.zvv.setVisibility(8);
        break label843;
        this.zvy.setText(this.fileName);
        break label906;
        this.gtP.setText(getString(2131299001));
      }
    case 7: 
      label843:
      label982:
      if (this.zvF) {
        this.zvv.setVisibility(0);
      }
      for (;;)
      {
        label906:
        label968:
        Pf(8);
        this.zvw.setVisibility(8);
        this.mzM.setVisibility(8);
        this.zvy.setVisibility(8);
        dFz();
        this.gtP.setText(getString(2131299001));
        break;
        this.zvv.setVisibility(8);
      }
    }
    Pf(8);
    this.zvw.setVisibility(8);
    if (this.zvF) {
      this.zvv.setVisibility(0);
    }
    for (;;)
    {
      this.mzM.setVisibility(8);
      this.zvy.setVisibility(8);
      dFz();
      break;
      this.zvv.setVisibility(8);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(30302);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.tencent.mm.pluginsdk.ui.tools.a.a(this, paramInt1, paramInt2, paramIntent, this.zvG, 2131299009, 2131299010, 1);
    AppMethodBeat.o(30302);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(30281);
    super.onCreate(paramBundle);
    init();
    AppMethodBeat.o(30281);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(30297);
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    paramContextMenu.add(0, 0, 0, getString(2131296895));
    AppMethodBeat.o(30297);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(30284);
    com.tencent.mm.pluginsdk.model.app.al.aUJ().remove(this);
    super.onDestroy();
    AppMethodBeat.o(30284);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(30310);
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    init();
    AppMethodBeat.o(30310);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(30286);
    aw.Rc().b(221, this);
    aw.Rc().b(728, this);
    super.onPause();
    mj localmj = new mj();
    localmj.cCu.cCv = false;
    mj.a locala = localmj.cCu;
    if (this.cEE == null) {}
    for (String str = "";; str = this.cEE.field_talker)
    {
      locala.talker = str;
      com.tencent.mm.sdk.b.a.ymk.a(localmj, getMainLooper());
      ab.d("MicroMsg.AppAttachDownloadUI", "AppAttachDownloadUI cancel pause auto download logic");
      AppMethodBeat.o(30286);
      return;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(30285);
    super.onResume();
    aw.Rc().a(221, this);
    aw.Rc().a(728, this);
    mj localmj = new mj();
    localmj.cCu.cCv = true;
    localmj.cCu.talker = this.cEE.field_talker;
    com.tencent.mm.sdk.b.a.ymk.a(localmj, getMainLooper());
    ab.d("MicroMsg.AppAttachDownloadUI", "AppAttachDownloadUI req pause auto download logic");
    this.mzM.setEnabled(true);
    AppMethodBeat.o(30285);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(30308);
    ab.i("MicroMsg.AppAttachDownloadUI", "summerapp onSceneEnd type[%d], [%d, %d, %s]", new Object[] { Integer.valueOf(paramm.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramm.getType() != 221) && (paramm.getType() != 728))
    {
      AppMethodBeat.o(30308);
      return;
    }
    if ((paramm.getType() == 728) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = dFu();
      if (paramString == null)
      {
        ab.i("MicroMsg.AppAttachDownloadUI", "summerapp onSceneEnd getAppAttachInfo is null");
        if (paramString != null)
        {
          paramString.field_status = 101L;
          paramString.field_lastModifyTime = bo.aox();
          com.tencent.mm.pluginsdk.model.app.al.aUJ().a(paramString, new String[0]);
        }
        this.pYd = new com.tencent.mm.plugin.record.b.e(this.cpO, this.cBO, this.zvA);
        aw.Rc().a(this.pYd, 0);
        AppMethodBeat.o(30308);
        return;
      }
      if (paramString.field_signature == null) {}
      for (paramInt1 = -1;; paramInt1 = paramString.field_signature.length())
      {
        ab.i("MicroMsg.AppAttachDownloadUI", "summerapp onSceneEnd CheckBigFileDownload ok signature len[%d] start NetSceneDownloadAppAttach", new Object[] { Integer.valueOf(paramInt1) });
        break;
      }
    }
    if ((this.pYd == null) && ((paramm instanceof com.tencent.mm.plugin.record.b.e)))
    {
      paramString = (com.tencent.mm.plugin.record.b.e)paramm;
      com.tencent.mm.pluginsdk.model.app.b localb = dFu();
      if ((localb != null) && (!com.tencent.mm.platformtools.ah.isNullOrNil(localb.field_mediaSvrId)) && (localb.field_mediaSvrId.equals(paramString.getMediaId())))
      {
        this.pYd = paramString;
        ab.i("MicroMsg.AppAttachDownloadUI", "summerapp onSceneEnd reset downloadAppAttachScene[%s] by mediaSvrId[%s]", new Object[] { this.pYd, localb.field_mediaSvrId });
      }
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = com.tencent.mm.plugin.report.service.h.qsU;
      paramm = this.zvC.fgL;
      if (this.zvC.fgA == 1) {}
      for (paramInt1 = 7;; paramInt1 = 5)
      {
        paramString.e(14665, new Object[] { paramm, Integer.valueOf(paramInt1), Integer.valueOf(this.zvC.fgw), Integer.valueOf(0), Integer.valueOf(0), this.elt });
        AppMethodBeat.o(30308);
        return;
      }
    }
    if ((paramInt2 != 0) && (com.tencent.mm.sdk.a.b.dsf())) {
      Toast.makeText(this, "errCode[" + paramInt2 + "]", 0).show();
    }
    if (paramInt2 == -5103059)
    {
      dFy();
      Pf(8);
      if (this.edl == 6)
      {
        paramString = com.tencent.mm.plugin.report.service.h.qsU;
        paramm = this.zvC.fgL;
        if (this.zvC.fgA != 1) {
          break label580;
        }
      }
      label580:
      for (paramInt1 = 7;; paramInt1 = 5)
      {
        paramString.e(14665, new Object[] { paramm, Integer.valueOf(paramInt1), Integer.valueOf(this.zvC.fgw), Integer.valueOf(1), Integer.valueOf(0), this.elt });
        AppMethodBeat.o(30308);
        return;
      }
    }
    Pf(8);
    this.zvv.setVisibility(0);
    this.zvw.setVisibility(8);
    ab.e("MicroMsg.AppAttachDownloadUI", "summerapp onSceneEnd, download fail, type = " + paramm.getType() + " errType = " + paramInt1 + ", errCode = " + paramInt2);
    AppMethodBeat.o(30308);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppAttachDownloadUI
 * JD-Core Version:    0.7.0.1
 */