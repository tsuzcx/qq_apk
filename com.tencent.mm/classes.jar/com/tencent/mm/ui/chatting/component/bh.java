package com.tencent.mm.ui.chatting.component;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.autogen.mmdata.rpt.ol;
import com.tencent.mm.model.bt;
import com.tencent.mm.model.z;
import com.tencent.mm.modelimage.l.a;
import com.tencent.mm.modelimage.o;
import com.tencent.mm.modelimage.q;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.modelmulti.t.b;
import com.tencent.mm.modelmulti.t.d;
import com.tencent.mm.modelmulti.t.e;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChatFooterCustom;
import com.tencent.mm.ui.chatting.an;
import com.tencent.mm.ui.chatting.component.api.av;
import com.tencent.mm.ui.chatting.component.api.be;
import com.tencent.mm.ui.chatting.component.api.m;
import com.tencent.mm.ui.chatting.component.api.x;
import com.tencent.mm.ui.chatting.u;
import com.tencent.mm.ui.tools.b;
import com.tencent.mm.ui.tools.b.1;
import com.tencent.mm.ui.widget.DrawnCallBackLinearLayout;
import com.tencent.mm.ui.widget.DrawnCallBackLinearLayout.a;
import com.tencent.mm.ui.widget.a.e;
import java.util.ArrayList;

@com.tencent.mm.ui.chatting.component.annotation.a(juB=av.class)
public class bh
  extends a
  implements l.a, av
{
  private e KOg;
  
  private void cW(cc paramcc)
  {
    AppMethodBeat.i(35572);
    u.a(paramcc, this.hlc.aezO.getContext(), this.hlc);
    AppMethodBeat.o(35572);
  }
  
  public final void X(final String paramString1, int paramInt, final String paramString2)
  {
    AppMethodBeat.i(35575);
    if (((this.KOg == null) || (!this.KOg.isShowing())) && (!Util.isNullOrNil(paramString2)) && (ImgUtil.isImgFile(paramString2)))
    {
      Object localObject = BitmapUtil.extractThumbNail(paramString2, 300, 300, false);
      if (localObject == null)
      {
        Log.e("MicroMsg.ChattingUI.SendImgComponent", "showAlert fail, bmp is null");
        AppMethodBeat.o(35575);
        return;
      }
      final x localx = (x)this.hlc.cm(x.class);
      ImageView localImageView = new ImageView(this.hlc.aezO.getContext());
      int i = this.hlc.aezO.getMMResources().getDimensionPixelSize(R.f.LargePadding);
      localImageView.setImageBitmap((Bitmap)localObject);
      localImageView.setPadding(i, i, i, i);
      localObject = this.hlc.aezO.getContentResolver();
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG("default_input_method").cG(localObject);
      localObject = (String)com.tencent.mm.hellhoundlib.a.a.a(new Object(), ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/chatting/component/SendImgComponent", "dealWithTextChange", "(Ljava/lang/String;ILjava/lang/String;)V", "android/provider/Settings$Secure", "getString", "(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;");
      final boolean bool;
      if ((ImgUtil.isGif(com.tencent.mm.vfs.y.bi(paramString2, 0, -1))) && (localObject != null) && ((((String)localObject).contains("com.sohu.inputmethod.sogou")) || (((String)localObject).contains("com.tencent.qqpinyin"))))
      {
        bool = true;
        if (bool)
        {
          if (!((String)localObject).contains("com.sohu.inputmethod.sogou")) {
            break label381;
          }
          com.tencent.mm.plugin.report.service.h.OAn.kJ(1062, 1);
        }
      }
      for (;;)
      {
        if ((!bool) || (!au.bwZ(this.hlc.getTalkerUserName()))) {
          break label405;
        }
        paramString1 = paramString1.substring(0, paramInt);
        localx.jsd().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(256306);
            localx.jsd().F(paramString1, -1, false);
            AppMethodBeat.o(256306);
          }
        }, 0L);
        Log.i("MicroMsg.ChattingUI.SendImgComponent", "gamelife fobidden image: from the third playground");
        Toast.makeText(this.hlc.aezO.getContext(), this.hlc.aezO.getMMResources().getString(R.l.emoji_send_fail_forbidden), 0).show();
        AppMethodBeat.o(35575);
        return;
        bool = false;
        break;
        label381:
        if (((String)localObject).contains("com.tencent.qqpinyin")) {
          com.tencent.mm.plugin.report.service.h.OAn.kJ(1062, 2);
        }
      }
      label405:
      this.KOg = k.a(this.hlc.aezO.getContext(), this.hlc.aezO.getMMResources().getString(R.l.gzE), localImageView, this.hlc.aezO.getMMResources().getString(R.l.app_ok), this.hlc.aezO.getMMResources().getString(R.l.app_cancel), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(256305);
          if ((bool) && (localx.jsd() != null) && (localx.jsd().getCallback() != null) && ((localx.jsd().getCallback() instanceof com.tencent.mm.ui.chatting.y)))
          {
            if (this.aewT.contains("com.sohu.inputmethod.sogou")) {
              com.tencent.mm.plugin.report.service.h.OAn.kJ(1062, 3);
            }
            for (;;)
            {
              paramAnonymousDialogInterface = new BitmapFactory.Options();
              paramAnonymousDialogInterface.inJustDecodeBounds = true;
              if (((BitmapUtil.decodeFile(paramString2, paramAnonymousDialogInterface) == null) || (paramAnonymousDialogInterface.outHeight <= com.tencent.mm.k.c.aRh())) && (paramAnonymousDialogInterface.outWidth <= com.tencent.mm.k.c.aRh())) {
                break;
              }
              Toast.makeText(bh.this.hlc.aezO.getContext(), R.l.emoji_custom_gif_max_size_limit_cannot_send, 0).show();
              AppMethodBeat.o(256305);
              return;
              if (this.aewT.contains("com.tencent.qqpinyin")) {
                com.tencent.mm.plugin.report.service.h.OAn.kJ(1062, 4);
              }
            }
            paramAnonymousDialogInterface = new WXMediaMessage(new WXEmojiObject(paramString2));
            paramAnonymousDialogInterface = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().a(bh.this.hlc.aezO.getContext(), paramAnonymousDialogInterface, null);
            if (paramAnonymousDialogInterface != null) {
              ((com.tencent.mm.ui.chatting.y)localx.jsd().getCallback()).O(((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aoe(paramAnonymousDialogInterface));
            }
            AppMethodBeat.o(256305);
            return;
          }
          paramAnonymousDialogInterface = com.tencent.mm.modelmulti.t.a(t.d.oNd).wg(5);
          paramAnonymousDialogInterface.hQQ = bh.this.hlc.getSelfUserName();
          paramAnonymousDialogInterface.toUser = bh.this.hlc.getTalkerUserName();
          paramAnonymousDialogInterface.oIx = paramString2;
          paramAnonymousDialogInterface.oGu = 0;
          paramAnonymousDialogInterface.oNk = null;
          paramAnonymousDialogInterface.hOX = 0;
          paramAnonymousDialogInterface.oGC = "";
          paramAnonymousDialogInterface.thumbPath = "";
          paramAnonymousDialogInterface.oNn = true;
          paramAnonymousDialogInterface.oNm = R.g.chat_img_template;
          paramAnonymousDialogInterface.oNj = 11;
          paramAnonymousDialogInterface.bKW().aXz();
          AppMethodBeat.o(256305);
        }
      }, null);
      paramString1 = paramString1.substring(0, paramInt);
      localx.jsd().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(256299);
          localx.jsd().F(paramString1, -1, false);
          AppMethodBeat.o(256299);
        }
      }, 10L);
    }
    AppMethodBeat.o(35575);
  }
  
  public final void a(ContextMenu paramContextMenu, int paramInt, cc paramcc)
  {
    AppMethodBeat.i(35571);
    paramContextMenu.add(paramInt, 100, 0, this.hlc.aezO.getMMResources().getString(R.l.gyn));
    com.tencent.mm.modelimage.h localh1 = null;
    if (paramcc.field_msgId > 0L) {
      localh1 = r.bKa().H(paramcc.field_talker, paramcc.field_msgId);
    }
    com.tencent.mm.modelimage.h localh2;
    if (localh1 != null)
    {
      localh2 = localh1;
      if (localh1.localId > 0L) {}
    }
    else
    {
      localh2 = localh1;
      if (paramcc.field_msgSvrId > 0L) {
        localh2 = r.bKa().G(paramcc.field_talker, paramcc.field_msgSvrId);
      }
    }
    if ((paramcc.field_isSend == 1) || ((localh2 != null) && (paramcc.field_isSend == 0) && (localh2.offset >= localh2.osy) && (localh2.osy != 0))) {
      paramContextMenu.add(paramInt, 110, 0, this.hlc.aezO.getMMResources().getString(R.l.retransmit));
    }
    if (localh2 == null) {}
    for (paramcc = "";; paramcc = r.bKa().v(localh2.oGr, "", ""))
    {
      if ((localh2 != null) && (com.tencent.mm.vfs.y.ZC(paramcc))) {
        paramContextMenu.add(paramInt, 112, 0, this.hlc.aezO.getMMResources().getString(R.l.gxg));
      }
      AppMethodBeat.o(35571);
      return;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, cc paramcc)
  {
    AppMethodBeat.i(35566);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(35566);
      return false;
    }
    paramMenuItem = bt.X(paramcc);
    if ((Util.isNullOrNil(paramMenuItem)) || (paramcc.field_isSend == 1)) {
      cW(paramcc);
    }
    for (;;)
    {
      if (bt.H(paramcc))
      {
        paramMenuItem = new ol();
        paramMenuItem.inO = paramcc.field_msgSvrId;
        paramMenuItem.iUM = paramcc.getType();
        paramMenuItem.jjm = bt.G(paramcc);
        paramMenuItem.ikE = 4L;
        paramMenuItem.bMH();
      }
      AppMethodBeat.o(35566);
      return true;
      com.tencent.mm.plugin.report.service.h.OAn.b(17509, new Object[] { Integer.valueOf(3), paramMenuItem });
      k.a(this.hlc.aezO.getContext(), R.l.gUu, R.l.gUv, R.l.app_view_detail, R.l.gzo, true, new bh.1(this, paramMenuItem), new bh.2(this, paramcc, paramMenuItem));
    }
  }
  
  public final void ab(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(35569);
    if ((paramString == null) || (paramString.equals("")) || (!com.tencent.mm.vfs.y.ZC(paramString)))
    {
      Log.d("MicroMsg.ChattingUI.SendImgComponent", " doSendImage : filePath is null or empty");
      AppMethodBeat.o(35569);
      return;
    }
    if (n.aF(this.hlc.Uxa))
    {
      AppMethodBeat.o(35569);
      return;
    }
    t.e locale = com.tencent.mm.modelmulti.t.a(t.d.oNd).wg(4);
    locale.hQQ = this.hlc.getSelfUserName();
    locale.toUser = this.hlc.getTalkerUserName();
    locale.oIx = paramString;
    locale.oGu = paramInt1;
    locale.oNk = null;
    locale.hOX = paramInt2;
    locale.oGC = "";
    locale.thumbPath = "";
    locale.oNn = true;
    locale.oNm = R.g.chat_img_template;
    locale.oNj = 11;
    locale.bKW().aXz();
    this.hlc.jpK();
    AppMethodBeat.o(35569);
  }
  
  public final void c(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(35573);
    ((m)this.hlc.cm(m.class)).C(paramLong, paramInt1, paramInt2);
    AppMethodBeat.o(35573);
  }
  
  public final void c(SightCaptureResult paramSightCaptureResult)
  {
    AppMethodBeat.i(35568);
    String str = paramSightCaptureResult.KTT;
    if (!Util.isNullOrNil(str)) {
      try
      {
        boolean bool = paramSightCaptureResult.KTM;
        Log.i("MicroMsg.ChattingUI.SendImgComponent", "doSendChattingImage, path: %s", new Object[] { str });
        paramSightCaptureResult = com.tencent.mm.modelmulti.t.a(t.d.oNd);
        if (bool) {}
        for (int i = 2;; i = 1)
        {
          paramSightCaptureResult = paramSightCaptureResult.wg(i);
          paramSightCaptureResult.hQQ = z.bAM();
          paramSightCaptureResult.toUser = this.hlc.getTalkerUserName();
          paramSightCaptureResult.oIx = str;
          paramSightCaptureResult.oGu = 1;
          paramSightCaptureResult.oNk = null;
          paramSightCaptureResult.hOX = 0;
          paramSightCaptureResult.oGC = "";
          paramSightCaptureResult.thumbPath = "";
          paramSightCaptureResult.oNn = true;
          paramSightCaptureResult.oNm = R.g.chat_img_template;
          paramSightCaptureResult.oNj = 11;
          paramSightCaptureResult = (o)paramSightCaptureResult.bKW().oNb;
          if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yVP, true))
          {
            com.tencent.mm.plugin.recordvideo.util.f localf = com.tencent.mm.plugin.recordvideo.util.f.Obq;
            com.tencent.mm.plugin.recordvideo.util.f.ln(String.valueOf(paramSightCaptureResult.bJM().field_msgId), str);
          }
          com.tencent.mm.model.bh.aZW().a(paramSightCaptureResult, 0);
          AppMethodBeat.o(35568);
          return;
        }
        AppMethodBeat.o(35568);
      }
      catch (Exception paramSightCaptureResult)
      {
        Log.e("MicroMsg.ChattingUI.SendImgComponent", "doSendChattingImage error: %s", new Object[] { paramSightCaptureResult.getMessage() });
      }
    }
  }
  
  public final boolean cK(cc paramcc)
  {
    AppMethodBeat.i(35570);
    if (!paramcc.iYk())
    {
      AppMethodBeat.o(35570);
      return false;
    }
    com.tencent.mm.model.bh.bCz();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      aa.j(this.hlc.aezO.getContext(), this.hlc.aezO.getContentView());
      AppMethodBeat.o(35570);
      return true;
    }
    if (!this.hlc.getTalkerUserName().equals("medianote"))
    {
      com.tencent.mm.model.bh.bCz();
      com.tencent.mm.model.c.bzz().d(new com.tencent.mm.ay.f(paramcc.field_talker, paramcc.field_msgSvrId));
    }
    an.cp(paramcc);
    this.hlc.jpK();
    AppMethodBeat.o(35570);
    return true;
  }
  
  public final void jjh()
  {
    AppMethodBeat.i(35577);
    r.bJY().oHJ = this;
    AppMethodBeat.o(35577);
  }
  
  public final void jjk()
  {
    AppMethodBeat.i(35578);
    r.bJY().oHJ = null;
    AppMethodBeat.o(35578);
  }
  
  public final void jqF()
  {
    AppMethodBeat.i(35579);
    super.jqF();
    r.bJY().oHJ = null;
    AppMethodBeat.o(35579);
  }
  
  public final boolean l(final int paramInt1, int paramInt2, final Intent paramIntent)
  {
    int i = 1;
    AppMethodBeat.i(35567);
    this.hlc.aDM();
    if (paramInt2 != -1)
    {
      Log.e("MicroMsg.ChattingUI.SendImgComponent", "[dealWithRequestCode] resultCode:%d", new Object[] { Integer.valueOf(paramInt2) });
      AppMethodBeat.o(35567);
      return false;
    }
    Object localObject1;
    Object localObject2;
    boolean bool;
    Object localObject3;
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(35567);
      return false;
    case 200: 
      if (paramIntent == null)
      {
        AppMethodBeat.o(35567);
        return true;
      }
      localObject1 = new Intent();
      ((Intent)localObject1).setClassName(this.hlc.aezO.getContext(), "com.tencent.mm.ui.tools.CropImageNewUI");
      ((Intent)localObject1).putExtra("CropImageMode", 4);
      ((Intent)localObject1).putExtra("CropImage_Filter", true);
      localObject2 = this.hlc.getTalkerUserName();
      if ((localObject2 != null) && ((au.bwL((String)localObject2)) || (au.bwN((String)localObject2))))
      {
        bool = false;
        ((Intent)localObject1).putExtra("CropImage_Has_Raw_Img_Btn", bool);
        ((Intent)localObject1).putExtra("from_source", 3);
        localObject2 = this.hlc.aezO;
        com.tencent.mm.model.bh.bCz();
        localObject3 = com.tencent.mm.model.c.bzL();
        if (paramIntent.getData().toString().startsWith("content://com.google.android.gallery3d")) {
          break label301;
        }
        paramIntent = b.i(((MMFragment)localObject2).getContext(), paramIntent, (String)localObject3);
        if (!Util.isNullOrNil(paramIntent))
        {
          ((Intent)localObject1).putExtra("CropImage_ImgPath", paramIntent);
          ((MMFragment)localObject2).startActivityForResult((Intent)localObject1, 203);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(35567);
        return true;
        bool = true;
        break;
        new b.1(paramIntent, (MMFragment)localObject2, (String)localObject3, (Intent)localObject1).execute(new Integer[] { Integer.valueOf(0) });
      }
    case 201: 
      localObject1 = this.hlc.aezO.getContext().getApplicationContext();
      com.tencent.mm.model.bh.bCz();
      paramIntent = com.tencent.mm.pluginsdk.ui.tools.t.g((Context)localObject1, paramIntent, com.tencent.mm.model.c.bzL());
      if (paramIntent == null)
      {
        AppMethodBeat.o(35567);
        return true;
      }
      localObject1 = new Intent();
      localObject2 = new ArrayList(1);
      ((ArrayList)localObject2).add(paramIntent);
      ((Intent)localObject1).putExtra("query_source_type", 3);
      ((Intent)localObject1).putExtra("preview_image", true);
      ((Intent)localObject1).putExtra("isTakePhoto", true);
      ((Intent)localObject1).putExtra("GalleryUI_FromUser", this.hlc.getSelfUserName());
      ((Intent)localObject1).putExtra("GalleryUI_ToUser", this.hlc.getTalkerUserName());
      ((Intent)localObject1).putExtra("is_long_click", true);
      ((Intent)localObject1).putStringArrayListExtra("preview_image_list", (ArrayList)localObject2);
      ((Intent)localObject1).addFlags(67108864);
      com.tencent.mm.br.c.a(this.hlc.aezO, "gallery", ".ui.GalleryEntryUI", (Intent)localObject1, 217);
      AppMethodBeat.o(35567);
      return true;
    case 217: 
      label301:
      if (paramIntent == null)
      {
        localObject1 = q.bJO().Oh(this.hlc.getTalkerUserName());
        if (((ArrayList)localObject1).size() > 0)
        {
          paramIntent = new Intent();
          paramIntent.putStringArrayListExtra("CropImage_OutputPath_List", (ArrayList)localObject1);
          localObject1 = new ArrayList();
          ((ArrayList)localObject1).add(Integer.valueOf(-1));
          paramIntent.putIntegerArrayListExtra("GalleryUI_ImgIdList", (ArrayList)localObject1);
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(594L, 4L, 1L, true);
        }
      }
      break;
    }
    for (;;)
    {
      if (paramIntent == null)
      {
        Log.e("MicroMsg.ChattingUI.SendImgComponent", "CONTEXT_MENU_WECHAT_GALLERY_IMAGE intent == null");
        AppMethodBeat.o(35567);
        return true;
      }
      localObject2 = paramIntent.getStringExtra("GalleryUI_ToUser");
      if (Util.isNullOrNil((String)localObject2)) {}
      for (localObject1 = this.hlc.getTalkerUserName();; localObject1 = localObject2)
      {
        Log.i("MicroMsg.ChattingUI.SendImgComponent", "CONTEXT_MENU_WECHAT_GALLERY_IMAGE userFromIntent:%s rawUsername:%s", new Object[] { localObject2, this.hlc.getTalkerUserName() });
        localObject2 = (x)this.hlc.cm(x.class);
        ((x)localObject2).jsd().clearFocus();
        ((x)localObject2).jsd().setBottomPanelVisibility(8);
        localObject3 = (DrawnCallBackLinearLayout)this.hlc.findViewById(R.h.chatting_bg_ll);
        if (localObject3 == null) {
          break;
        }
        ((DrawnCallBackLinearLayout)localObject3).setListener(new DrawnCallBackLinearLayout.a()
        {
          public final void jtE()
          {
            AppMethodBeat.i(35562);
            com.tencent.mm.model.bh.baH().postToWorkerDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(35561);
                com.tencent.mm.model.bh.baH().setHighPriority();
                bh.a(bh.this, bh.3.this.vsF, bh.3.this.aewO);
                ((be)bh.this.hlc.cm(be.class)).ci(bh.3.this.vsF);
                if ((bh.3.this.aewP.jse() != null) && (!bh.3.this.aewP.jse().Q(bh.3.this.val$requestCode, bh.3.this.vsF)))
                {
                  Log.w("MicroMsg.ChattingUI.SendImgComponent", "customFooter is null and isContinue is false");
                  AppMethodBeat.o(35561);
                  return;
                }
                com.tencent.mm.model.bh.baH().setLowPriority();
                AppMethodBeat.o(35561);
              }
            }, 100L);
            AppMethodBeat.o(35562);
          }
        });
        break;
      }
      localObject1 = (x)this.hlc.cm(x.class);
      localObject2 = paramIntent.getStringExtra("CropImage_OutputPath");
      if (localObject2 == null)
      {
        ((x)localObject1).jsd().clearFocus();
        AppMethodBeat.o(35567);
        return true;
      }
      bool = paramIntent.getBooleanExtra("CropImage_Compress_Img", true);
      bool = z.h((String)localObject2, this.hlc.getTalkerUserName(), bool);
      paramIntent.getIntExtra("from_source", 0);
      paramInt2 = paramIntent.getIntExtra("CropImage_rotateCount", 0);
      Log.d("MicroMsg.ChattingUI.SendImgComponent", "dkimgsource" + paramIntent.getIntExtra("from_source", 0));
      if (bool) {}
      for (paramInt1 = i;; paramInt1 = 0)
      {
        ab(paramInt1, paramInt2, (String)localObject2);
        ((x)localObject1).jsd().clearFocus();
        break;
      }
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(35576);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    l(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(35576);
  }
  
  public final void p(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(35574);
    com.tencent.mm.plugin.recordvideo.util.f localf = com.tencent.mm.plugin.recordvideo.util.f.Obq;
    com.tencent.mm.plugin.recordvideo.util.f.aTq(String.valueOf(paramLong));
    ((m)this.hlc.cm(m.class)).ab(paramLong, paramBoolean);
    AppMethodBeat.o(35574);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.bh
 * JD-Core Version:    0.7.0.1
 */