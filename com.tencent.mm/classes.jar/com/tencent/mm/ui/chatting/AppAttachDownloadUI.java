package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.cj;
import com.tencent.mm.h.a.lt;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.s;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.ac;
import com.tencent.mm.pluginsdk.model.app.ac.a;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.tools.ShowImageUI;

public class AppAttachDownloadUI
  extends MMActivity
  implements com.tencent.mm.ah.f, ac.a, j.a
{
  private long bIt;
  private String bRO;
  private boolean bTT;
  private String bUi;
  private String bVV;
  private bi bWO;
  private String dQR;
  private int dlO;
  private String fGv;
  private TextView fce;
  private String fileName;
  private ProgressBar frw;
  private Button kfd;
  private View kfh;
  private Button kse;
  private String lnx;
  private MMImageView nfB;
  private ImageView nfC;
  private ac rUs;
  private com.tencent.mm.ah.g vgA;
  private boolean vgB;
  private g.a vgC;
  private boolean vgD = false;
  private boolean vgE = false;
  private boolean vgF = true;
  private int vgG = 5000;
  private LinearLayout vgH;
  private LinearLayout vgI;
  private boolean vgJ = false;
  private View vgx;
  private TextView vgy;
  private TextView vgz;
  
  private static boolean a(com.tencent.mm.pluginsdk.model.app.b paramb)
  {
    if (paramb == null) {}
    com.tencent.mm.vfs.b localb;
    do
    {
      return false;
      localb = new com.tencent.mm.vfs.b(paramb.field_fileFullPath);
    } while ((!localb.exists()) || (localb.length() != paramb.field_totalLen));
    return true;
  }
  
  private void cBL()
  {
    cj localcj = new cj();
    com.tencent.mm.pluginsdk.model.e.a(localcj, this.bWO);
    localcj.bIw.activity = this;
    localcj.bIw.bID = 39;
    com.tencent.mm.sdk.b.a.udP.m(localcj);
  }
  
  private void cBM()
  {
    this.kfh.setVisibility(0);
    this.kse.setVisibility(8);
    this.vgx.setVisibility(0);
    if (cBN())
    {
      this.rUs = new ac(this.bIt, this.bUi, this.vgA);
      au.Dk().a(this.rUs, 0);
      com.tencent.mm.modelsimple.z.w(this.bWO);
    }
  }
  
  private boolean cBN()
  {
    int i = -1;
    Object localObject1 = cBO();
    Object localObject2;
    long l1;
    long l2;
    long l3;
    String str1;
    long l4;
    boolean bool1;
    label270:
    String str2;
    boolean bool2;
    long l5;
    if (localObject1 == null)
    {
      com.tencent.mm.pluginsdk.model.app.l.A(this.bIt, this.bVV);
      localObject2 = cBO();
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        l1 = ((com.tencent.mm.pluginsdk.model.app.b)localObject2).ujK;
        l2 = ((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_totalLen;
        localObject1 = ((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_fileFullPath;
        l3 = ((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_type;
        str1 = ((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_mediaId;
        l4 = ((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_msgInfoId;
        bool1 = ((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_isUpload;
        if (((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_signature == null)
        {
          y.i("MicroMsg.AppAttachDownloadUI", "summerapp tryInitAttachInfo newInfo systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], signature len[%d]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), localObject1, Long.valueOf(l3), str1, Long.valueOf(l4), Boolean.valueOf(bool1), Integer.valueOf(i) });
          if (this.vgC.dQz == 0)
          {
            localObject1 = localObject2;
            if (this.vgC.dQv <= 26214400) {
              break label491;
            }
          }
          if (ah.bl(((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_signature)) {
            break label270;
          }
        }
        for (bool1 = true;; bool1 = false)
        {
          localObject1 = localObject2;
          if (!bool1) {
            au.Dk().a(new com.tencent.mm.pluginsdk.model.app.z((com.tencent.mm.pluginsdk.model.app.b)localObject1, this.dQR, this.lnx, this.fileName, this.fGv, this.bRO), 0);
          }
          return bool1;
          i = ((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_signature.length();
          break;
        }
      }
    }
    else
    {
      localObject2 = new com.tencent.mm.vfs.b(((com.tencent.mm.pluginsdk.model.app.b)localObject1).field_fileFullPath);
      if ((((com.tencent.mm.pluginsdk.model.app.b)localObject1).field_status == 199L) && (!((com.tencent.mm.vfs.b)localObject2).exists()))
      {
        y.i("MicroMsg.AppAttachDownloadUI", "summerapp tryInitAttachInfo info exist but file not!");
        com.tencent.mm.pluginsdk.model.app.l.A(this.bIt, this.bVV);
      }
      l1 = ((com.tencent.mm.pluginsdk.model.app.b)localObject1).ujK;
      l2 = ((com.tencent.mm.pluginsdk.model.app.b)localObject1).field_totalLen;
      str1 = ((com.tencent.mm.pluginsdk.model.app.b)localObject1).field_fileFullPath;
      l3 = ((com.tencent.mm.pluginsdk.model.app.b)localObject1).field_type;
      str2 = ((com.tencent.mm.pluginsdk.model.app.b)localObject1).field_mediaId;
      l4 = ((com.tencent.mm.pluginsdk.model.app.b)localObject1).field_msgInfoId;
      bool1 = ((com.tencent.mm.pluginsdk.model.app.b)localObject1).field_isUpload;
      bool2 = ((com.tencent.mm.vfs.b)localObject2).exists();
      l5 = ((com.tencent.mm.pluginsdk.model.app.b)localObject1).field_status;
      if (((com.tencent.mm.pluginsdk.model.app.b)localObject1).field_signature != null) {
        break label497;
      }
    }
    for (;;)
    {
      y.i("MicroMsg.AppAttachDownloadUI", "summerapp tryInitAttachInfo info exist systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], file.exists[%b], status[%d], signature len[%d]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), str1, Long.valueOf(l3), str2, Long.valueOf(l4), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Long.valueOf(l5), Integer.valueOf(i) });
      label491:
      bool1 = true;
      break;
      label497:
      i = ((com.tencent.mm.pluginsdk.model.app.b)localObject1).field_signature.length();
    }
  }
  
  private com.tencent.mm.pluginsdk.model.app.b cBO()
  {
    Object localObject = ap.avh().gY(this.bIt);
    if (localObject != null) {
      y.i("MicroMsg.AppAttachDownloadUI", "summerapp getAppAttachInfo by msgId [%d] stack[%s]", new Object[] { Long.valueOf(this.bIt), ah.Vb() });
    }
    com.tencent.mm.pluginsdk.model.app.b localb;
    do
    {
      do
      {
        return localObject;
        localb = com.tencent.mm.pluginsdk.model.app.l.VX(this.bUi);
        if (localb == null)
        {
          y.i("MicroMsg.AppAttachDownloadUI", "summerapp getAppAttachInfo by msgId and mediaId is null stack[%s]", new Object[] { ah.Vb() });
          return localb;
        }
        localObject = localb;
      } while (localb.field_msgInfoId == this.bIt);
      localObject = localb;
    } while (com.tencent.mm.vfs.e.bK(localb.field_fileFullPath));
    com.tencent.mm.pluginsdk.model.app.l.A(this.bIt, this.bVV);
    localObject = ap.avh().gY(this.bIt);
    if (localObject == null)
    {
      y.w("MicroMsg.AppAttachDownloadUI", "summerapp getAppAttachInfo create new info from local but failed stack[%s]", new Object[] { ah.Vb() });
      return localb;
    }
    com.tencent.mm.sdk.f.e.post(new AppAttachDownloadUI.8(this, localb, (com.tencent.mm.pluginsdk.model.app.b)localObject), "copyAttachFromLocal");
    return localb;
  }
  
  private void cBP()
  {
    switch (this.dlO)
    {
    case 1: 
    case 3: 
    case 4: 
    case 5: 
    default: 
      this.kfd.setVisibility(0);
      this.kfh.setVisibility(8);
      this.vgx.setVisibility(8);
    case 0: 
    case 6: 
    case 2: 
      do
      {
        do
        {
          return;
        } while (!cBQ());
        if (bk.aaf(this.fGv))
        {
          localObject = cBO();
          Intent localIntent = new Intent(this, ShowImageUI.class);
          localIntent.putExtra("key_message_id", this.bWO.field_msgId);
          localIntent.putExtra("key_image_path", ((com.tencent.mm.pluginsdk.model.app.b)localObject).field_fileFullPath);
          localIntent.putExtra("key_favorite", true);
          startActivity(localIntent);
          finish();
          return;
        }
        localObject = getMimeType();
        this.fce.setVisibility(0);
        this.kfh.setVisibility(8);
        this.vgx.setVisibility(8);
        this.kse.setVisibility(8);
        this.vgz.setVisibility(0);
        if (this.fileName.equals("")) {
          this.vgz.setText(getString(R.l.openapi_app_file));
        }
        while ((localObject == null) || (((String)localObject).equals("")))
        {
          this.kfd.setVisibility(8);
          this.fce.setText(getString(R.l.download_can_not_open));
          return;
          this.vgz.setText(this.fileName);
        }
        this.kfd.setVisibility(0);
        this.fce.setText(getString(R.l.download_can_not_open_by_wechat));
        return;
      } while (!cBQ());
      localObject = new Intent(this, ImageGalleryUI.class);
      ((Intent)localObject).putExtra("img_gallery_msg_id", this.bWO.field_msgId);
      ((Intent)localObject).putExtra("img_gallery_talker", this.bWO.field_talker);
      startActivity((Intent)localObject);
      finish();
      overridePendingTransition(0, 0);
      return;
    }
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("App_MsgId", this.bIt);
    setResult(-1, (Intent)localObject);
    finish();
  }
  
  private boolean cBQ()
  {
    com.tencent.mm.pluginsdk.model.app.b localb = cBO();
    if (localb == null) {
      return true;
    }
    if (com.tencent.mm.vfs.e.bK(localb.field_fileFullPath))
    {
      this.kfh.setVisibility(8);
      this.vgx.setVisibility(8);
      this.kse.setVisibility(8);
      return true;
    }
    this.vgH.setVisibility(8);
    this.vgI.setVisibility(0);
    return false;
  }
  
  private String getMimeType()
  {
    g.a locala = g.a.gp(this.bVV);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (locala.dQw != null)
    {
      localObject1 = localObject2;
      if (locala.dQw.length() > 0) {
        localObject1 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(locala.dQw);
      }
    }
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((String)localObject1).length() != 0) {}
    }
    else
    {
      y.w("MicroMsg.AppAttachDownloadUI", "getMimeType fail, not a built-in mimetype, use \"*/{fileext}\" instead");
      localObject2 = "*/" + locala.dQw;
    }
    return localObject2;
  }
  
  private void init()
  {
    setMMTitle(R.l.download_title);
    this.bIt = getIntent().getLongExtra("app_msg_id", -1L);
    boolean bool;
    if (this.bIt == -1L) {
      bool = false;
    }
    while (!bool)
    {
      finish();
      return;
      au.Hx();
      this.bWO = com.tencent.mm.model.c.Fy().fd(this.bIt);
      if ((this.bWO == null) || (this.bWO.field_msgId == 0L) || (this.bWO.field_content == null))
      {
        bool = false;
      }
      else
      {
        this.vgB = s.fn(this.bWO.field_talker);
        this.bVV = this.bWO.field_content;
        if ((this.vgB) && (this.bWO.field_isSend == 0))
        {
          String str = this.bWO.field_content;
          localObject = str;
          if (this.vgB)
          {
            localObject = str;
            if (str != null) {
              localObject = bd.iJ(str);
            }
          }
          this.bVV = ((String)localObject);
        }
        this.vgC = g.a.gp(this.bVV);
        if (this.vgC == null)
        {
          y.e("MicroMsg.AppAttachDownloadUI", "summerapp parse msgContent error, %s", new Object[] { this.bVV });
          bool = false;
        }
        else
        {
          if ((ah.bl(this.vgC.bFE)) && (!ah.bl(this.vgC.dQK)))
          {
            y.e("MicroMsg.AppAttachDownloadUI", "summerapp msgContent format error, %s", new Object[] { this.bVV });
            this.vgC.bFE = this.vgC.dQK.hashCode();
          }
          this.dlO = this.vgC.type;
          this.bUi = this.vgC.bFE;
          this.fileName = ah.pm(this.vgC.title);
          this.fGv = ah.pm(this.vgC.dQw).toLowerCase();
          this.lnx = ah.pm(this.vgC.filemd5);
          this.bRO = ah.pm(this.vgC.bRO);
          this.dQR = ah.pm(this.vgC.dQR);
          y.i("MicroMsg.AppAttachDownloadUI", "summerapp initParams msgId[%d], sender[%d], msgContent[%s], appType[%d], mediaId[%s], fileName[%s]", new Object[] { Long.valueOf(this.bIt), Integer.valueOf(this.bWO.field_isSend), this.bVV, Integer.valueOf(this.dlO), this.bUi, this.fileName });
          localObject = cBO();
          if (localObject == null)
          {
            y.i("MicroMsg.AppAttachDownloadUI", "summerapp initParams attInfo is null");
            this.vgE = false;
            if (a((com.tencent.mm.pluginsdk.model.app.b)localObject)) {
              bool = com.tencent.mm.pluginsdk.ui.tools.a.a(this, ((com.tencent.mm.pluginsdk.model.app.b)localObject).field_fileFullPath, this.fGv, 1);
            }
          }
          else
          {
            new com.tencent.mm.vfs.b(((com.tencent.mm.pluginsdk.model.app.b)localObject).field_fileFullPath);
            if (((com.tencent.mm.pluginsdk.model.app.b)localObject).field_offset > 0L) {}
            for (this.vgE = true;; this.vgE = false)
            {
              y.i("MicroMsg.AppAttachDownloadUI", "summerapp initParams attInfo field_fileFullPath[%s], field_offset[%d], isDownloadStarted[%b]", new Object[] { ((com.tencent.mm.pluginsdk.model.app.b)localObject).field_fileFullPath, Long.valueOf(((com.tencent.mm.pluginsdk.model.app.b)localObject).field_offset), Boolean.valueOf(this.vgE) });
              break;
            }
          }
          bool = true;
        }
      }
    }
    Object localObject = new com.tencent.mm.vfs.b(com.tencent.mm.compatible.util.e.dzB);
    if (!((com.tencent.mm.vfs.b)localObject).exists()) {
      ((com.tencent.mm.vfs.b)localObject).mkdirs();
    }
    ap.avh().c(this);
    initView();
  }
  
  public final void a(String paramString, com.tencent.mm.sdk.e.l paraml)
  {
    paramString = cBO();
    long l1;
    long l2;
    if (paramString != null)
    {
      l1 = paramString.field_totalLen;
      l2 = paramString.field_offset;
      this.vgy.setText(getString(R.l.download_data, new Object[] { ah.cm(l2), ah.cm(l1) }));
      if (paramString.field_totalLen != 0L) {
        break label328;
      }
    }
    label328:
    for (int i = 0;; i = (int)(paramString.field_offset * 100L / paramString.field_totalLen))
    {
      y.v("MicroMsg.AppAttachDownloadUI", "summerapp attach progress:" + i + " offset:" + l2 + " totallen:" + l1);
      this.frw.setProgress(i);
      if ((paramString.field_status == 199L) && (i >= 100) && (!this.vgD))
      {
        this.vgD = true;
        if (this.vgJ)
        {
          this.vgJ = false;
          cBL();
        }
        if (paramString != null)
        {
          Toast.makeText(this, getString(R.l.download_success) + " : " + paramString.field_fileFullPath.replaceFirst(com.tencent.mm.compatible.util.e.bkF, com.tencent.mm.compatible.util.e.dzA), this.vgG).show();
          com.tencent.mm.pluginsdk.ui.tools.a.b(this, paramString.field_fileFullPath, this.fGv, 1);
        }
        ai.l(new AppAttachDownloadUI.9(this), 200L);
      }
      if ((this.kfh.getVisibility() != 0) && (i < 100) && (!paramString.field_isUpload) && (paramString.field_status == 101L))
      {
        y.i("MicroMsg.AppAttachDownloadUI", "summerapp still downloading updateProgress progress[%d]", new Object[] { Integer.valueOf(i) });
        this.kfh.setVisibility(0);
        this.kse.setVisibility(8);
        this.vgx.setVisibility(0);
      }
      return;
    }
  }
  
  public final void ckY()
  {
    Toast.makeText(this, R.l.download_pause_tip, 0).show();
  }
  
  protected final int getLayoutId()
  {
    return R.i.download_ui;
  }
  
  protected final void initView()
  {
    this.nfB = ((MMImageView)findViewById(R.h.download_type_icon));
    this.kfh = findViewById(R.h.download_progress_area);
    this.frw = ((ProgressBar)findViewById(R.h.download_pb));
    this.nfC = ((ImageView)findViewById(R.h.download_stop_btn));
    this.kse = ((Button)findViewById(R.h.download_continue_btn));
    this.kfd = ((Button)findViewById(R.h.download_open_btn));
    this.vgx = findViewById(R.h.download_data_area);
    this.fce = ((TextView)findViewById(R.h.download_hint));
    this.vgy = ((TextView)findViewById(R.h.download_data_size));
    this.vgz = ((TextView)findViewById(R.h.download_file_name));
    this.vgH = ((LinearLayout)findViewById(R.h.download_ll));
    this.vgI = ((LinearLayout)findViewById(R.h.load_fail_ll));
    this.nfC.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppAttachDownloadUI.k(AppAttachDownloadUI.this).setVisibility(8);
        AppAttachDownloadUI.l(AppAttachDownloadUI.this).setVisibility(0);
        AppAttachDownloadUI.m(AppAttachDownloadUI.this).setVisibility(8);
        y.i("MicroMsg.AppAttachDownloadUI", "summerapp stopBtn downloadAppAttachScene[%s]", new Object[] { AppAttachDownloadUI.a(AppAttachDownloadUI.this) });
        if (AppAttachDownloadUI.a(AppAttachDownloadUI.this) != null)
        {
          paramAnonymousView = AppAttachDownloadUI.a(AppAttachDownloadUI.this);
          AppAttachDownloadUI localAppAttachDownloadUI = AppAttachDownloadUI.this;
          if (!paramAnonymousView.rUG)
          {
            com.tencent.mm.ak.f.Nd().lM(paramAnonymousView.eoQ);
            paramAnonymousView.rUA = ap.avh().VQ(paramAnonymousView.bUi);
          }
          y.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig pause listener[%s], info[%s], justSaveFile[%b], stack[%s]", new Object[] { localAppAttachDownloadUI, paramAnonymousView.rUA, Boolean.valueOf(paramAnonymousView.rUG), bk.csb() });
          if (paramAnonymousView.rUA != null)
          {
            if ((paramAnonymousView.rUA.field_status == 101L) && (localAppAttachDownloadUI != null)) {
              localAppAttachDownloadUI.ckY();
            }
            paramAnonymousView.rUA.field_status = 102L;
            if (!paramAnonymousView.rUG) {
              ap.avh().c(paramAnonymousView.rUA, new String[0]);
            }
          }
          com.tencent.mm.kernel.g.Dk().c(AppAttachDownloadUI.a(AppAttachDownloadUI.this));
        }
        do
        {
          return;
          paramAnonymousView = AppAttachDownloadUI.o(AppAttachDownloadUI.this);
        } while ((paramAnonymousView == null) || (paramAnonymousView.field_status == 199L));
        y.i("MicroMsg.AppAttachDownloadUI", "summerapp stopBtn onClick but scene is null and set status[%d] paused", new Object[] { Long.valueOf(paramAnonymousView.field_status) });
        paramAnonymousView.field_status = 102L;
        ap.avh().c(paramAnonymousView, new String[0]);
      }
    });
    this.kse.setOnClickListener(new AppAttachDownloadUI.6(this));
    this.kfd.setOnClickListener(new AppAttachDownloadUI.7(this));
    Object localObject;
    int i;
    switch (this.dlO)
    {
    case 1: 
    case 3: 
    case 5: 
    default: 
      this.nfB.setImageResource(R.k.app_attach_file_icon_unknow);
      setBackBtn(new AppAttachDownloadUI.1(this));
      this.bTT = getIntent().getBooleanExtra("app_show_share", true);
      if (this.bTT) {
        addIconOptionMenu(0, R.k.actionbar_icon_dark_more, new AppAttachDownloadUI.2(this));
      }
      this.vgD = false;
      localObject = cBO();
      if ((localObject == null) || (!new com.tencent.mm.vfs.b(((com.tencent.mm.pluginsdk.model.app.b)localObject).field_fileFullPath).exists()))
      {
        i = 0;
        label349:
        if (i == 0) {
          break label486;
        }
        y.i("MicroMsg.AppAttachDownloadUI", "summerapp isCanOpenFile");
        this.vgD = true;
        cBP();
      }
      break;
    }
    label486:
    do
    {
      do
      {
        return;
        this.nfB.setImageResource(R.g.app_attach_file_icon_pic);
        break;
        this.nfB.setImageResource(R.k.app_attach_file_icon_video);
        break;
        this.nfB.setImageResource(o.VP(this.fGv));
        break;
        if (bk.aaf(this.fGv))
        {
          this.nfB.setImageResource(R.g.app_attach_file_icon_pic);
          break;
        }
        this.nfB.setImageResource(R.k.app_attach_file_icon_unknow);
        break;
        if ((((com.tencent.mm.pluginsdk.model.app.b)localObject).aXY()) || ((this.bWO.field_isSend == 1) && (((com.tencent.mm.pluginsdk.model.app.b)localObject).field_isUpload)))
        {
          i = 1;
          break label349;
        }
        i = 0;
        break label349;
        if ((localObject != null) && (((com.tencent.mm.pluginsdk.model.app.b)localObject).aXY()) && (!new com.tencent.mm.vfs.b(((com.tencent.mm.pluginsdk.model.app.b)localObject).field_fileFullPath).exists()))
        {
          y.i("MicroMsg.AppAttachDownloadUI", "summerapp set fail info[%s]", new Object[] { localObject });
          this.vgH.setVisibility(8);
          this.vgI.setVisibility(0);
          return;
        }
      } while (this.vgD);
      this.vgA = new AppAttachDownloadUI.4(this);
      switch (this.dlO)
      {
      case 1: 
      case 3: 
      case 4: 
      case 5: 
      default: 
        y.i("MicroMsg.AppAttachDownloadUI", "summerapp progressCallBack[%s], isDownloadFinished[%b], isDownloadStarted[%b]", new Object[] { this.vgA, Boolean.valueOf(this.vgD), Boolean.valueOf(this.vgE) });
      }
    } while ((this.dlO != 2) && ((this.vgD) || (this.vgE)));
    cBM();
    return;
    if (this.vgE)
    {
      this.kse.setVisibility(0);
      label702:
      this.kfh.setVisibility(8);
      this.vgx.setVisibility(8);
      this.kfd.setVisibility(8);
      this.fce.setVisibility(8);
      this.vgz.setVisibility(0);
      if (!this.fileName.equals("")) {
        break label840;
      }
      this.vgz.setText(getString(R.l.openapi_app_file));
      label773:
      localObject = getMimeType();
      if ((localObject != null) && (!((String)localObject).equals(""))) {
        break label854;
      }
      this.fce.setText(getString(R.l.download_can_not_open));
    }
    while (bk.aaf(this.fGv))
    {
      this.fce.setVisibility(8);
      break;
      this.kse.setVisibility(8);
      break label702;
      label840:
      this.vgz.setText(this.fileName);
      break label773;
      label854:
      this.fce.setText(getString(R.l.download_can_not_open_by_wechat));
    }
    if (this.vgE) {
      this.kse.setVisibility(0);
    }
    for (;;)
    {
      this.kfh.setVisibility(8);
      this.vgx.setVisibility(8);
      this.kfd.setVisibility(8);
      this.vgz.setVisibility(8);
      this.fce.setVisibility(8);
      this.fce.setText(getString(R.l.download_can_not_open_by_wechat));
      break;
      this.kse.setVisibility(8);
    }
    this.kfh.setVisibility(8);
    this.vgx.setVisibility(8);
    if (this.vgE) {
      this.kse.setVisibility(0);
    }
    for (;;)
    {
      this.kfd.setVisibility(8);
      this.vgz.setVisibility(8);
      this.fce.setVisibility(8);
      break;
      this.kse.setVisibility(8);
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.tencent.mm.pluginsdk.ui.tools.a.a(this, paramInt1, paramInt2, paramIntent, this.vgF, R.l.download_no_match_msg, R.l.download_no_match_title, 1);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    init();
  }
  
  protected void onDestroy()
  {
    ap.avh().d(this);
    super.onDestroy();
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    init();
  }
  
  protected void onPause()
  {
    au.Dk().b(221, this);
    au.Dk().b(728, this);
    super.onPause();
    lt locallt = new lt();
    locallt.bUN.bUO = false;
    com.tencent.mm.sdk.b.a.udP.a(locallt, getMainLooper());
    y.d("MicroMsg.AppAttachDownloadUI", "AppAttachDownloadUI cancel pause auto download logic");
  }
  
  protected void onResume()
  {
    super.onResume();
    au.Dk().a(221, this);
    au.Dk().a(728, this);
    lt locallt = new lt();
    locallt.bUN.bUO = true;
    com.tencent.mm.sdk.b.a.udP.a(locallt, getMainLooper());
    y.d("MicroMsg.AppAttachDownloadUI", "AppAttachDownloadUI req pause auto download logic");
    this.kfd.setEnabled(true);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.AppAttachDownloadUI", "summerapp onSceneEnd type[%d], [%d, %d, %s]", new Object[] { Integer.valueOf(paramm.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramm.getType() != 221) && (paramm.getType() != 728)) {}
    do
    {
      return;
      if ((paramm.getType() == 728) && (paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = cBO();
        if (paramString == null)
        {
          y.i("MicroMsg.AppAttachDownloadUI", "summerapp onSceneEnd getAppAttachInfo is null");
          this.rUs = new ac(this.bIt, this.bUi, this.vgA);
          au.Dk().a(this.rUs, 0);
          return;
        }
        if (paramString.field_signature == null) {}
        for (paramInt1 = -1;; paramInt1 = paramString.field_signature.length())
        {
          y.i("MicroMsg.AppAttachDownloadUI", "summerapp onSceneEnd CheckBigFileDownload ok signature len[%d] start NetSceneDownloadAppAttach", new Object[] { Integer.valueOf(paramInt1) });
          break;
        }
      }
      if ((this.rUs == null) && ((paramm instanceof ac)))
      {
        paramString = (ac)paramm;
        com.tencent.mm.pluginsdk.model.app.b localb = cBO();
        if ((localb != null) && (!ah.bl(localb.field_mediaSvrId)) && (localb.field_mediaSvrId.equals(paramString.getMediaId())))
        {
          this.rUs = paramString;
          y.i("MicroMsg.AppAttachDownloadUI", "summerapp onSceneEnd reset downloadAppAttachScene[%s] by mediaSvrId[%s]", new Object[] { this.rUs, localb.field_mediaSvrId });
        }
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = h.nFQ;
        paramm = this.vgC.dQK;
        if (this.vgC.dQz == 1) {}
        for (paramInt1 = 7;; paramInt1 = 5)
        {
          paramString.f(14665, new Object[] { paramm, Integer.valueOf(paramInt1), Integer.valueOf(this.vgC.dQv), Integer.valueOf(0), Integer.valueOf(0), this.fGv });
          return;
        }
      }
      if ((paramInt2 != 0) && (com.tencent.mm.sdk.a.b.cqk())) {
        Toast.makeText(this, "errCode[" + paramInt2 + "]", 0).show();
      }
      if (paramInt2 != -5103059) {
        break;
      }
      this.vgI.setVisibility(0);
      this.vgH.setVisibility(8);
    } while (this.dlO != 6);
    paramString = h.nFQ;
    paramm = this.vgC.dQK;
    if (this.vgC.dQz == 1) {}
    for (paramInt1 = 7;; paramInt1 = 5)
    {
      paramString.f(14665, new Object[] { paramm, Integer.valueOf(paramInt1), Integer.valueOf(this.vgC.dQv), Integer.valueOf(1), Integer.valueOf(0), this.fGv });
      return;
    }
    this.kfh.setVisibility(8);
    this.kse.setVisibility(0);
    this.vgx.setVisibility(8);
    y.e("MicroMsg.AppAttachDownloadUI", "summerapp onSceneEnd, download fail, type = " + paramm.getType() + " errType = " + paramInt1 + ", errCode = " + paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppAttachDownloadUI
 * JD-Core Version:    0.7.0.1
 */