package com.tencent.mm.ui.chatting.d;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.provider.Settings.Secure;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.an.t;
import com.tencent.mm.ay.g;
import com.tencent.mm.ay.i;
import com.tencent.mm.ay.k.a;
import com.tencent.mm.ay.n;
import com.tencent.mm.ay.p;
import com.tencent.mm.ay.q;
import com.tencent.mm.bd.f;
import com.tencent.mm.f.b.a.ll;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bs;
import com.tencent.mm.model.z;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.modelmulti.o.b;
import com.tencent.mm.modelmulti.o.d;
import com.tencent.mm.modelmulti.o.e;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChatFooterCustom;
import com.tencent.mm.ui.chatting.ak;
import com.tencent.mm.ui.chatting.d.b.ao;
import com.tencent.mm.ui.chatting.d.b.aw;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.s;
import com.tencent.mm.ui.tools.b.1;
import com.tencent.mm.ui.widget.DrawnCallBackLinearLayout;
import com.tencent.mm.ui.widget.DrawnCallBackLinearLayout.a;
import java.util.ArrayList;

@com.tencent.mm.ui.chatting.d.a.a(hRc=ao.class)
public class ba
  extends a
  implements k.a, ao
{
  private com.tencent.mm.ui.widget.a.d ETC;
  
  private void cz(ca paramca)
  {
    AppMethodBeat.i(35572);
    s.a(paramca, this.fgR.WQv.getContext(), this.fgR);
    AppMethodBeat.o(35572);
  }
  
  public final void R(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(35569);
    if ((paramString == null) || (paramString.equals("")) || (!com.tencent.mm.vfs.u.agG(paramString)))
    {
      Log.d("MicroMsg.ChattingUI.SendImgComponent", " doSendImage : filePath is null or empty");
      AppMethodBeat.o(35569);
      return;
    }
    if (m.az(this.fgR.NKq))
    {
      AppMethodBeat.o(35569);
      return;
    }
    o.e locale = o.a(o.d.lUk).wb(4);
    locale.fLi = this.fgR.getSelfUserName();
    locale.toUser = this.fgR.getTalkerUserName();
    locale.lPO = paramString;
    locale.lNK = paramInt1;
    locale.lUr = null;
    locale.fJu = paramInt2;
    locale.lNS = "";
    locale.thumbPath = "";
    locale.lUu = true;
    locale.lUt = R.g.chat_img_template;
    locale.lUq = 11;
    locale.bnl().aEv();
    this.fgR.Gi(true);
    AppMethodBeat.o(35569);
  }
  
  public final void V(final String paramString1, int paramInt, final String paramString2)
  {
    AppMethodBeat.i(35575);
    if (((this.ETC == null) || (!this.ETC.isShowing())) && (!Util.isNullOrNil(paramString2)) && (ImgUtil.isImgFile(paramString2)))
    {
      Object localObject = BitmapUtil.extractThumbNail(paramString2, 300, 300, false);
      if (localObject == null)
      {
        Log.e("MicroMsg.ChattingUI.SendImgComponent", "showAlert fail, bmp is null");
        AppMethodBeat.o(35575);
        return;
      }
      final com.tencent.mm.ui.chatting.d.b.u localu = (com.tencent.mm.ui.chatting.d.b.u)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.u.class);
      ImageView localImageView = new ImageView(this.fgR.WQv.getContext());
      int i = this.fgR.WQv.getMMResources().getDimensionPixelSize(R.f.LargePadding);
      localImageView.setImageBitmap((Bitmap)localObject);
      localImageView.setPadding(i, i, i, i);
      localObject = Settings.Secure.getString(this.fgR.WQv.getContentResolver(), "default_input_method");
      final boolean bool;
      if ((ImgUtil.isGif(com.tencent.mm.vfs.u.aY(paramString2, 0, -1))) && (localObject != null) && ((((String)localObject).contains("com.sohu.inputmethod.sogou")) || (((String)localObject).contains("com.tencent.qqpinyin"))))
      {
        bool = true;
        if (bool)
        {
          if (!((String)localObject).contains("com.sohu.inputmethod.sogou")) {
            break label329;
          }
          com.tencent.mm.plugin.report.service.h.IzE.el(1062, 1);
        }
      }
      for (;;)
      {
        if ((!bool) || (!as.bvS(this.fgR.getTalkerUserName()))) {
          break label353;
        }
        paramString1 = paramString1.substring(0, paramInt);
        localu.hPj().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(271287);
            localu.hPj().D(paramString1, -1, false);
            AppMethodBeat.o(271287);
          }
        }, 0L);
        Log.i("MicroMsg.ChattingUI.SendImgComponent", "gamelife fobidden image: from the third playground");
        Toast.makeText(this.fgR.WQv.getContext(), this.fgR.WQv.getMMResources().getString(R.l.emoji_send_fail_forbidden), 0).show();
        AppMethodBeat.o(35575);
        return;
        bool = false;
        break;
        label329:
        if (((String)localObject).contains("com.tencent.qqpinyin")) {
          com.tencent.mm.plugin.report.service.h.IzE.el(1062, 2);
        }
      }
      label353:
      this.ETC = com.tencent.mm.ui.base.h.a(this.fgR.WQv.getContext(), this.fgR.WQv.getMMResources().getString(R.l.exa), localImageView, this.fgR.WQv.getMMResources().getString(R.l.app_ok), this.fgR.WQv.getMMResources().getString(R.l.app_cancel), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(257853);
          if ((bool) && (localu.hPj() != null) && (localu.hPj().getCallback() != null) && ((localu.hPj().getCallback() instanceof com.tencent.mm.ui.chatting.w)))
          {
            if (this.WOs.contains("com.sohu.inputmethod.sogou")) {
              com.tencent.mm.plugin.report.service.h.IzE.el(1062, 3);
            }
            for (;;)
            {
              paramAnonymousDialogInterface = new BitmapFactory.Options();
              paramAnonymousDialogInterface.inJustDecodeBounds = true;
              if (((BitmapUtil.decodeFile(paramString2, paramAnonymousDialogInterface) == null) || (paramAnonymousDialogInterface.outHeight <= com.tencent.mm.n.c.awH())) && (paramAnonymousDialogInterface.outWidth <= com.tencent.mm.n.c.awH())) {
                break;
              }
              Toast.makeText(ba.this.fgR.WQv.getContext(), R.l.emoji_custom_gif_max_size_limit_cannot_send, 0).show();
              AppMethodBeat.o(257853);
              return;
              if (this.WOs.contains("com.tencent.qqpinyin")) {
                com.tencent.mm.plugin.report.service.h.IzE.el(1062, 4);
              }
            }
            paramAnonymousDialogInterface = new WXMediaMessage(new WXEmojiObject(paramString2));
            paramAnonymousDialogInterface = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(ba.this.fgR.WQv.getContext(), paramAnonymousDialogInterface, null);
            if (paramAnonymousDialogInterface != null) {
              ((com.tencent.mm.ui.chatting.w)localu.hPj().getCallback()).O(((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aud(paramAnonymousDialogInterface));
            }
            AppMethodBeat.o(257853);
            return;
          }
          paramAnonymousDialogInterface = o.a(o.d.lUk).wb(5);
          paramAnonymousDialogInterface.fLi = ba.this.fgR.getSelfUserName();
          paramAnonymousDialogInterface.toUser = ba.this.fgR.getTalkerUserName();
          paramAnonymousDialogInterface.lPO = paramString2;
          paramAnonymousDialogInterface.lNK = 0;
          paramAnonymousDialogInterface.lUr = null;
          paramAnonymousDialogInterface.fJu = 0;
          paramAnonymousDialogInterface.lNS = "";
          paramAnonymousDialogInterface.thumbPath = "";
          paramAnonymousDialogInterface.lUu = true;
          paramAnonymousDialogInterface.lUt = R.g.chat_img_template;
          paramAnonymousDialogInterface.lUq = 11;
          paramAnonymousDialogInterface.bnl().aEv();
          AppMethodBeat.o(257853);
        }
      }, null);
      paramString1 = paramString1.substring(0, paramInt);
      localu.hPj().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(206348);
          localu.hPj().D(paramString1, -1, false);
          AppMethodBeat.o(206348);
        }
      }, 10L);
    }
    AppMethodBeat.o(35575);
  }
  
  public final void a(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(35573);
    ((k)this.fgR.bC(k.class)).t(paramLong, paramInt1, paramInt2);
    AppMethodBeat.o(35573);
  }
  
  public final void a(ContextMenu paramContextMenu, int paramInt, ca paramca)
  {
    AppMethodBeat.i(35571);
    paramContextMenu.add(paramInt, 100, 0, this.fgR.WQv.getMMResources().getString(R.l.evN));
    g localg1 = null;
    if (paramca.field_msgId > 0L) {
      localg1 = q.bmh().D(paramca.field_talker, paramca.field_msgId);
    }
    g localg2;
    if (localg1 != null)
    {
      localg2 = localg1;
      if (localg1.localId > 0L) {}
    }
    else
    {
      localg2 = localg1;
      if (paramca.field_msgSvrId > 0L) {
        localg2 = q.bmh().C(paramca.field_talker, paramca.field_msgSvrId);
      }
    }
    if ((paramca.field_isSend == 1) || ((localg2 != null) && (paramca.field_isSend == 0) && (localg2.offset >= localg2.lAW) && (localg2.lAW != 0))) {
      paramContextMenu.add(paramInt, 110, 0, this.fgR.WQv.getMMResources().getString(R.l.retransmit));
    }
    if (localg2 == null) {}
    for (paramca = "";; paramca = q.bmh().r(localg2.lNH, "", ""))
    {
      if ((localg2 != null) && (com.tencent.mm.vfs.u.agG(paramca))) {
        paramContextMenu.add(paramInt, 112, 0, this.fgR.WQv.getMMResources().getString(R.l.euH));
      }
      AppMethodBeat.o(35571);
      return;
    }
  }
  
  public final void a(SightCaptureResult paramSightCaptureResult)
  {
    AppMethodBeat.i(35568);
    String str = paramSightCaptureResult.EYh;
    if (!Util.isNullOrNil(str)) {
      try
      {
        boolean bool = paramSightCaptureResult.EYa;
        Log.i("MicroMsg.ChattingUI.SendImgComponent", "doSendChattingImage, path: %s", new Object[] { str });
        paramSightCaptureResult = o.a(o.d.lUk);
        if (bool) {}
        for (int i = 2;; i = 1)
        {
          paramSightCaptureResult = paramSightCaptureResult.wb(i);
          paramSightCaptureResult.fLi = z.bcZ();
          paramSightCaptureResult.toUser = this.fgR.getTalkerUserName();
          paramSightCaptureResult.lPO = str;
          paramSightCaptureResult.lNK = 1;
          paramSightCaptureResult.lUr = null;
          paramSightCaptureResult.fJu = 0;
          paramSightCaptureResult.lNS = "";
          paramSightCaptureResult.thumbPath = "";
          paramSightCaptureResult.lUu = true;
          paramSightCaptureResult.lUt = R.g.chat_img_template;
          paramSightCaptureResult.lUq = 11;
          paramSightCaptureResult = (n)paramSightCaptureResult.bnl().lUi;
          if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vGh, true))
          {
            com.tencent.mm.plugin.recordvideo.e.d locald = com.tencent.mm.plugin.recordvideo.e.d.IeU;
            com.tencent.mm.plugin.recordvideo.e.d.jR(String.valueOf(paramSightCaptureResult.blT().field_msgId), str);
          }
          bh.aGY().a(paramSightCaptureResult, 0);
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
  
  public final boolean a(final MenuItem paramMenuItem, final ca paramca)
  {
    AppMethodBeat.i(35566);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(35566);
      return false;
    }
    paramMenuItem = bs.T(paramca);
    if ((Util.isNullOrNil(paramMenuItem)) || (paramca.field_isSend == 1)) {
      cz(paramca);
    }
    for (;;)
    {
      if (bs.F(paramca))
      {
        paramMenuItem = new ll();
        paramMenuItem.ghT = paramca.field_msgSvrId;
        paramMenuItem.gKR = paramca.getType();
        paramMenuItem.gQQ = bs.E(paramca);
        paramMenuItem.gef = 4L;
        paramMenuItem.bpa();
      }
      AppMethodBeat.o(35566);
      return true;
      com.tencent.mm.plugin.report.service.h.IzE.a(17509, new Object[] { Integer.valueOf(3), paramMenuItem });
      com.tencent.mm.ui.base.h.a(this.fgR.WQv.getContext(), R.l.eRO, R.l.eRP, R.l.app_view_detail, R.l.ewL, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(35559);
          paramAnonymousDialogInterface = new Intent();
          paramAnonymousDialogInterface.putExtra("rawUrl", paramMenuItem);
          paramAnonymousDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.RBc);
          paramAnonymousDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.RAX);
          com.tencent.mm.by.c.b(ba.this.fgR.WQv.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousDialogInterface);
          com.tencent.mm.plugin.report.service.h.IzE.a(17509, new Object[] { Integer.valueOf(1), paramMenuItem });
          AppMethodBeat.o(35559);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(35560);
          ba.a(ba.this, paramca);
          com.tencent.mm.plugin.report.service.h.IzE.a(17509, new Object[] { Integer.valueOf(2), paramMenuItem });
          AppMethodBeat.o(35560);
        }
      });
    }
  }
  
  public final boolean co(ca paramca)
  {
    AppMethodBeat.i(35570);
    if (!paramca.hwG())
    {
      AppMethodBeat.o(35570);
      return false;
    }
    bh.beI();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      com.tencent.mm.ui.base.w.g(this.fgR.WQv.getContext(), this.fgR.WQv.getContentView());
      AppMethodBeat.o(35570);
      return true;
    }
    if (!this.fgR.getTalkerUserName().equals("medianote"))
    {
      bh.beI();
      com.tencent.mm.model.c.bbK().d(new f(paramca.field_talker, paramca.field_msgSvrId));
    }
    ak.cb(paramca);
    this.fgR.Gi(true);
    AppMethodBeat.o(35570);
    return true;
  }
  
  public final void hGW()
  {
    AppMethodBeat.i(35577);
    q.bmf().lOZ = this;
    AppMethodBeat.o(35577);
  }
  
  public final void hGZ()
  {
    AppMethodBeat.i(35578);
    q.bmf().lOZ = null;
    AppMethodBeat.o(35578);
  }
  
  public final void hNZ()
  {
    AppMethodBeat.i(35579);
    super.hNZ();
    q.bmf().lOZ = null;
    AppMethodBeat.o(35579);
  }
  
  public final boolean i(final int paramInt1, int paramInt2, final Intent paramIntent)
  {
    int i = 1;
    AppMethodBeat.i(35567);
    this.fgR.dismissDialog();
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
      ((Intent)localObject1).setClassName(this.fgR.WQv.getContext(), "com.tencent.mm.ui.tools.CropImageNewUI");
      ((Intent)localObject1).putExtra("CropImageMode", 4);
      ((Intent)localObject1).putExtra("CropImage_Filter", true);
      localObject2 = this.fgR.getTalkerUserName();
      if ((localObject2 != null) && ((as.bvH((String)localObject2)) || (as.bvJ((String)localObject2))))
      {
        bool = false;
        ((Intent)localObject1).putExtra("CropImage_Has_Raw_Img_Btn", bool);
        ((Intent)localObject1).putExtra("from_source", 3);
        localObject2 = this.fgR.WQv;
        bh.beI();
        localObject3 = com.tencent.mm.model.c.bbW();
        if (paramIntent.getData().toString().startsWith("content://com.google.android.gallery3d")) {
          break label301;
        }
        paramIntent = com.tencent.mm.ui.tools.b.h(((MMFragment)localObject2).getContext(), paramIntent, (String)localObject3);
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
      localObject1 = this.fgR.WQv.getContext().getApplicationContext();
      bh.beI();
      paramIntent = com.tencent.mm.pluginsdk.ui.tools.u.g((Context)localObject1, paramIntent, com.tencent.mm.model.c.bbW());
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
      ((Intent)localObject1).putExtra("GalleryUI_FromUser", this.fgR.getSelfUserName());
      ((Intent)localObject1).putExtra("GalleryUI_ToUser", this.fgR.getTalkerUserName());
      ((Intent)localObject1).putExtra("is_long_click", true);
      ((Intent)localObject1).putStringArrayListExtra("preview_image_list", (ArrayList)localObject2);
      ((Intent)localObject1).addFlags(67108864);
      com.tencent.mm.by.c.a(this.fgR.WQv, "gallery", ".ui.GalleryEntryUI", (Intent)localObject1, 217);
      AppMethodBeat.o(35567);
      return true;
    case 217: 
      label301:
      if (paramIntent == null)
      {
        localObject1 = p.blV().Wh(this.fgR.getTalkerUserName());
        if (((ArrayList)localObject1).size() > 0)
        {
          paramIntent = new Intent();
          paramIntent.putStringArrayListExtra("CropImage_OutputPath_List", (ArrayList)localObject1);
          localObject1 = new ArrayList();
          ((ArrayList)localObject1).add(Integer.valueOf(-1));
          paramIntent.putIntegerArrayListExtra("GalleryUI_ImgIdList", (ArrayList)localObject1);
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(594L, 4L, 1L, true);
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
      for (localObject1 = this.fgR.getTalkerUserName();; localObject1 = localObject2)
      {
        Log.i("MicroMsg.ChattingUI.SendImgComponent", "CONTEXT_MENU_WECHAT_GALLERY_IMAGE userFromIntent:%s rawUsername:%s", new Object[] { localObject2, this.fgR.getTalkerUserName() });
        localObject2 = (com.tencent.mm.ui.chatting.d.b.u)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.u.class);
        ((com.tencent.mm.ui.chatting.d.b.u)localObject2).hPj().clearFocus();
        ((com.tencent.mm.ui.chatting.d.b.u)localObject2).hPj().setBottomPanelVisibility(8);
        localObject3 = (DrawnCallBackLinearLayout)this.fgR.findViewById(R.h.chatting_bg_ll);
        if (localObject3 == null) {
          break;
        }
        ((DrawnCallBackLinearLayout)localObject3).setListener(new DrawnCallBackLinearLayout.a()
        {
          public final void hQB()
          {
            AppMethodBeat.i(35562);
            bh.aHJ().postToWorkerDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(35561);
                bh.aHJ().setHighPriority();
                ba.a(ba.this, ba.3.this.val$data, ba.3.this.WOn);
                ((aw)ba.this.fgR.bC(aw.class)).bF(ba.3.this.val$data);
                if (ba.3.this.WOo.hPk() != null) {
                  ba.3.this.WOo.hPk().w(ba.3.this.val$requestCode, ba.3.this.val$data);
                }
                bh.aHJ().setLowPriority();
                AppMethodBeat.o(35561);
              }
            }, 100L);
            AppMethodBeat.o(35562);
          }
        });
        break;
      }
      localObject1 = (com.tencent.mm.ui.chatting.d.b.u)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.u.class);
      localObject2 = paramIntent.getStringExtra("CropImage_OutputPath");
      if (localObject2 == null)
      {
        ((com.tencent.mm.ui.chatting.d.b.u)localObject1).hPj().clearFocus();
        AppMethodBeat.o(35567);
        return true;
      }
      bool = paramIntent.getBooleanExtra("CropImage_Compress_Img", true);
      bool = z.f((String)localObject2, this.fgR.getTalkerUserName(), bool);
      paramIntent.getIntExtra("from_source", 0);
      paramInt2 = paramIntent.getIntExtra("CropImage_rotateCount", 0);
      Log.d("MicroMsg.ChattingUI.SendImgComponent", "dkimgsource" + paramIntent.getIntExtra("from_source", 0));
      if (bool) {}
      for (paramInt1 = i;; paramInt1 = 0)
      {
        R(paramInt1, paramInt2, (String)localObject2);
        ((com.tencent.mm.ui.chatting.d.b.u)localObject1).hPj().clearFocus();
        break;
      }
    }
  }
  
  public final void j(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(35574);
    com.tencent.mm.plugin.recordvideo.e.d locald = com.tencent.mm.plugin.recordvideo.e.d.IeU;
    com.tencent.mm.plugin.recordvideo.e.d.aWh(String.valueOf(paramLong));
    ((k)this.fgR.bC(k.class)).Q(paramLong, paramBoolean);
    AppMethodBeat.o(35574);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(35576);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    i(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(35576);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.ba
 * JD-Core Version:    0.7.0.1
 */