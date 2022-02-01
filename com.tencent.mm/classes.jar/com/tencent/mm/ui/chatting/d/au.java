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
import com.tencent.mm.av.i;
import com.tencent.mm.av.k.a;
import com.tencent.mm.av.n;
import com.tencent.mm.av.p;
import com.tencent.mm.ba.f;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.c;
import com.tencent.mm.model.v;
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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChatFooterCustom;
import com.tencent.mm.ui.chatting.d.b.as;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.w;
import com.tencent.mm.ui.tools.a.1;
import com.tencent.mm.ui.widget.DrawnCallBackLinearLayout;
import com.tencent.mm.ui.widget.DrawnCallBackLinearLayout.a;
import java.util.ArrayList;

@com.tencent.mm.ui.chatting.d.a.a(fJv=com.tencent.mm.ui.chatting.d.b.ak.class)
public class au
  extends a
  implements k.a, com.tencent.mm.ui.chatting.d.b.ak
{
  private com.tencent.mm.ui.widget.a.d vUf;
  
  private void bP(bv parambv)
  {
    AppMethodBeat.i(35572);
    com.tencent.mm.ui.chatting.s.a(parambv, this.cXJ.Kkd.getContext(), this.cXJ);
    AppMethodBeat.o(35572);
  }
  
  public final void H(final String paramString1, int paramInt, final String paramString2)
  {
    AppMethodBeat.i(35575);
    if (((this.vUf == null) || (!this.vUf.isShowing())) && (!bu.isNullOrNil(paramString2)) && (u.aRF(paramString2)))
    {
      Object localObject = com.tencent.mm.sdk.platformtools.h.d(paramString2, 300, 300, false);
      if (localObject == null)
      {
        ae.e("MicroMsg.ChattingUI.SendImgComponent", "showAlert fail, bmp is null");
        AppMethodBeat.o(35575);
        return;
      }
      final com.tencent.mm.ui.chatting.d.b.s locals = (com.tencent.mm.ui.chatting.d.b.s)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.s.class);
      ImageView localImageView = new ImageView(this.cXJ.Kkd.getContext());
      int i = this.cXJ.Kkd.getMMResources().getDimensionPixelSize(2131165480);
      localImageView.setImageBitmap((Bitmap)localObject);
      localImageView.setPadding(i, i, i, i);
      localObject = Settings.Secure.getString(this.cXJ.Kkd.getContentResolver(), "default_input_method");
      final boolean bool;
      if ((u.cw(com.tencent.mm.vfs.o.bb(paramString2, 0, -1))) && (localObject != null) && ((((String)localObject).contains("com.sohu.inputmethod.sogou")) || (((String)localObject).contains("com.tencent.qqpinyin"))))
      {
        bool = true;
        if (bool)
        {
          if (!((String)localObject).contains("com.sohu.inputmethod.sogou")) {
            break label324;
          }
          com.tencent.mm.plugin.report.service.g.yxI.dD(1062, 1);
        }
      }
      for (;;)
      {
        if ((!bool) || (!(locals.fHF().getCallback() instanceof com.tencent.mm.plugin.gamelife.h.b))) {
          break label348;
        }
        paramString1 = paramString1.substring(0, paramInt);
        locals.fHF().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(187405);
            locals.fHF().w(paramString1, -1, false);
            AppMethodBeat.o(187405);
          }
        }, 0L);
        Toast.makeText(this.cXJ.Kkd.getContext(), this.cXJ.Kkd.getMMResources().getString(2131767096), 0).show();
        AppMethodBeat.o(35575);
        return;
        bool = false;
        break;
        label324:
        if (((String)localObject).contains("com.tencent.qqpinyin")) {
          com.tencent.mm.plugin.report.service.g.yxI.dD(1062, 2);
        }
      }
      label348:
      this.vUf = com.tencent.mm.ui.base.h.a(this.cXJ.Kkd.getContext(), this.cXJ.Kkd.getMMResources().getString(2131757310), localImageView, this.cXJ.Kkd.getMMResources().getString(2131755835), this.cXJ.Kkd.getMMResources().getString(2131755691), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(187406);
          if ((bool) && (locals.fHF() != null) && (locals.fHF().getCallback() != null) && ((locals.fHF().getCallback() instanceof w)))
          {
            if (this.KhU.contains("com.sohu.inputmethod.sogou")) {
              com.tencent.mm.plugin.report.service.g.yxI.dD(1062, 3);
            }
            for (;;)
            {
              paramAnonymousDialogInterface = new BitmapFactory.Options();
              paramAnonymousDialogInterface.inJustDecodeBounds = true;
              if (((com.tencent.mm.sdk.platformtools.h.decodeFile(paramString2, paramAnonymousDialogInterface) == null) || (paramAnonymousDialogInterface.outHeight <= com.tencent.mm.n.b.acp())) && (paramAnonymousDialogInterface.outWidth <= com.tencent.mm.n.b.acp())) {
                break;
              }
              Toast.makeText(au.this.cXJ.Kkd.getContext(), 2131758246, 0).show();
              AppMethodBeat.o(187406);
              return;
              if (this.KhU.contains("com.tencent.qqpinyin")) {
                com.tencent.mm.plugin.report.service.g.yxI.dD(1062, 4);
              }
            }
            paramAnonymousDialogInterface = new WXMediaMessage(new WXEmojiObject(paramString2));
            paramAnonymousDialogInterface = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(au.this.cXJ.Kkd.getContext(), paramAnonymousDialogInterface, null);
            if (paramAnonymousDialogInterface != null) {
              ((w)locals.fHF().getCallback()).M(((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aci(paramAnonymousDialogInterface));
            }
            AppMethodBeat.o(187406);
            return;
          }
          paramAnonymousDialogInterface = com.tencent.mm.modelmulti.o.a(o.d.iiQ).pn(5);
          paramAnonymousDialogInterface.dzZ = au.this.cXJ.fJy();
          paramAnonymousDialogInterface.toUser = au.this.cXJ.getTalkerUserName();
          paramAnonymousDialogInterface.iey = paramString2;
          paramAnonymousDialogInterface.icr = 0;
          paramAnonymousDialogInterface.iiW = null;
          paramAnonymousDialogInterface.dyw = 0;
          paramAnonymousDialogInterface.icA = "";
          paramAnonymousDialogInterface.thumbPath = "";
          paramAnonymousDialogInterface.iiZ = true;
          paramAnonymousDialogInterface.iiY = 2131231564;
          paramAnonymousDialogInterface.iiV = 11;
          paramAnonymousDialogInterface.aJO().execute();
          AppMethodBeat.o(187406);
        }
      }, null);
      paramString1 = paramString1.substring(0, paramInt);
      locals.fHF().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(187407);
          locals.fHF().w(paramString1, -1, false);
          AppMethodBeat.o(187407);
        }
      }, 10L);
    }
    AppMethodBeat.o(35575);
  }
  
  public final void R(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(35569);
    if ((paramString == null) || (paramString.equals("")) || (!com.tencent.mm.vfs.o.fB(paramString)))
    {
      ae.d("MicroMsg.ChattingUI.SendImgComponent", " doSendImage : filePath is null or empty");
      AppMethodBeat.o(35569);
      return;
    }
    if (l.ar(this.cXJ.Cqh))
    {
      AppMethodBeat.o(35569);
      return;
    }
    o.e locale = com.tencent.mm.modelmulti.o.a(o.d.iiQ).pn(4);
    locale.dzZ = this.cXJ.fJy();
    locale.toUser = this.cXJ.getTalkerUserName();
    locale.iey = paramString;
    locale.icr = paramInt1;
    locale.iiW = null;
    locale.dyw = paramInt2;
    locale.icA = "";
    locale.thumbPath = "";
    locale.iiZ = true;
    locale.iiY = 2131231564;
    locale.iiV = 11;
    locale.aJO().execute();
    this.cXJ.xY(true);
    AppMethodBeat.o(35569);
  }
  
  public final void a(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(35573);
    ((k)this.cXJ.bh(k.class)).r(paramLong, paramInt1, paramInt2);
    AppMethodBeat.o(35573);
  }
  
  public final void a(ContextMenu paramContextMenu, int paramInt, bv parambv)
  {
    AppMethodBeat.i(35571);
    paramContextMenu.add(paramInt, 100, 0, this.cXJ.Kkd.getMMResources().getString(2131757220));
    com.tencent.mm.av.g localg1 = null;
    if (parambv.field_msgId > 0L) {
      localg1 = com.tencent.mm.av.q.aIX().G(parambv.field_talker, parambv.field_msgId);
    }
    com.tencent.mm.av.g localg2;
    if (localg1 != null)
    {
      localg2 = localg1;
      if (localg1.doE > 0L) {}
    }
    else
    {
      localg2 = localg1;
      if (parambv.field_msgSvrId > 0L) {
        localg2 = com.tencent.mm.av.q.aIX().F(parambv.field_talker, parambv.field_msgSvrId);
      }
    }
    if ((parambv.field_isSend == 1) || ((localg2 != null) && (parambv.field_isSend == 0) && (localg2.offset >= localg2.hPI) && (localg2.hPI != 0))) {
      paramContextMenu.add(paramInt, 110, 0, this.cXJ.Kkd.getMMResources().getString(2131762559));
    }
    if (localg2 == null) {}
    for (parambv = "";; parambv = com.tencent.mm.av.q.aIX().o(localg2.ico, "", ""))
    {
      if ((localg2 != null) && (com.tencent.mm.vfs.o.fB(parambv))) {
        paramContextMenu.add(paramInt, 112, 0, this.cXJ.Kkd.getMMResources().getString(2131757150));
      }
      AppMethodBeat.o(35571);
      return;
    }
  }
  
  public final void a(SightCaptureResult paramSightCaptureResult)
  {
    AppMethodBeat.i(35568);
    String str = paramSightCaptureResult.vYE;
    if (!bu.isNullOrNil(str)) {
      try
      {
        boolean bool = paramSightCaptureResult.vYx;
        ae.i("MicroMsg.ChattingUI.SendImgComponent", "doSendChattingImage, path: %s", new Object[] { str });
        paramSightCaptureResult = com.tencent.mm.modelmulti.o.a(o.d.iiQ);
        if (bool) {}
        for (int i = 2;; i = 1)
        {
          paramSightCaptureResult = paramSightCaptureResult.pn(i);
          paramSightCaptureResult.dzZ = v.aAC();
          paramSightCaptureResult.toUser = this.cXJ.getTalkerUserName();
          paramSightCaptureResult.iey = str;
          paramSightCaptureResult.icr = 1;
          paramSightCaptureResult.iiW = null;
          paramSightCaptureResult.dyw = 0;
          paramSightCaptureResult.icA = "";
          paramSightCaptureResult.thumbPath = "";
          paramSightCaptureResult.iiZ = true;
          paramSightCaptureResult.iiY = 2131231564;
          paramSightCaptureResult.iiV = 11;
          paramSightCaptureResult = (n)paramSightCaptureResult.aJO().iiO;
          if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qFW, true))
          {
            com.tencent.mm.plugin.recordvideo.e.b localb = com.tencent.mm.plugin.recordvideo.e.b.yhe;
            com.tencent.mm.plugin.recordvideo.e.b.iR(String.valueOf(paramSightCaptureResult.aIJ().field_msgId), str);
          }
          bc.ajj().a(paramSightCaptureResult, 0);
          AppMethodBeat.o(35568);
          return;
        }
        AppMethodBeat.o(35568);
      }
      catch (Exception paramSightCaptureResult)
      {
        ae.e("MicroMsg.ChattingUI.SendImgComponent", "doSendChattingImage error: %s", new Object[] { paramSightCaptureResult.getMessage() });
      }
    }
  }
  
  public final boolean a(final MenuItem paramMenuItem, final bv parambv)
  {
    AppMethodBeat.i(35566);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(35566);
      return false;
    }
    paramMenuItem = bn.E(parambv);
    if ((bu.isNullOrNil(paramMenuItem)) || (parambv.field_isSend == 1)) {
      bP(parambv);
    }
    for (;;)
    {
      AppMethodBeat.o(35566);
      return true;
      com.tencent.mm.plugin.report.service.g.yxI.f(17509, new Object[] { Integer.valueOf(3), paramMenuItem });
      com.tencent.mm.ui.base.h.a(this.cXJ.Kkd.getContext(), 2131762971, 2131762972, 2131755928, 2131757288, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(35559);
          paramAnonymousDialogInterface = new Intent();
          paramAnonymousDialogInterface.putExtra("rawUrl", paramMenuItem);
          paramAnonymousDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.FGb);
          paramAnonymousDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.FFX);
          com.tencent.mm.br.d.b(au.this.cXJ.Kkd.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousDialogInterface);
          com.tencent.mm.plugin.report.service.g.yxI.f(17509, new Object[] { Integer.valueOf(1), paramMenuItem });
          AppMethodBeat.o(35559);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(35560);
          au.a(au.this, parambv);
          com.tencent.mm.plugin.report.service.g.yxI.f(17509, new Object[] { Integer.valueOf(2), paramMenuItem });
          AppMethodBeat.o(35560);
        }
      });
    }
  }
  
  public final boolean bE(bv parambv)
  {
    AppMethodBeat.i(35570);
    if (!parambv.ftg())
    {
      AppMethodBeat.o(35570);
      return false;
    }
    bc.aCg();
    if (!c.isSDCardAvailable())
    {
      t.g(this.cXJ.Kkd.getContext(), this.cXJ.Kkd.getContentView());
      AppMethodBeat.o(35570);
      return true;
    }
    if (!this.cXJ.getTalkerUserName().equals("medianote"))
    {
      bc.aCg();
      c.azE().d(new f(parambv.field_talker, parambv.field_msgSvrId));
    }
    com.tencent.mm.ui.chatting.ak.bs(parambv);
    this.cXJ.xY(true);
    AppMethodBeat.o(35570);
    return true;
  }
  
  public final void fAu()
  {
    AppMethodBeat.i(35577);
    com.tencent.mm.av.q.aIV().idJ = this;
    AppMethodBeat.o(35577);
  }
  
  public final void fAx()
  {
    AppMethodBeat.i(35578);
    com.tencent.mm.av.q.aIV().idJ = null;
    AppMethodBeat.o(35578);
  }
  
  public final void fGE()
  {
    AppMethodBeat.i(35579);
    super.fGE();
    com.tencent.mm.av.q.aIV().idJ = null;
    AppMethodBeat.o(35579);
  }
  
  public final boolean i(final int paramInt1, int paramInt2, final Intent paramIntent)
  {
    int i = 1;
    AppMethodBeat.i(35567);
    this.cXJ.dismissDialog();
    if (paramInt2 != -1)
    {
      ae.e("MicroMsg.ChattingUI.SendImgComponent", "[dealWithRequestCode] resultCode:%d", new Object[] { Integer.valueOf(paramInt2) });
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
      ((Intent)localObject1).setClassName(this.cXJ.Kkd.getContext(), "com.tencent.mm.ui.tools.CropImageNewUI");
      ((Intent)localObject1).putExtra("CropImageMode", 4);
      ((Intent)localObject1).putExtra("CropImage_Filter", true);
      localObject2 = this.cXJ.getTalkerUserName();
      if ((localObject2 != null) && ((an.aUn((String)localObject2)) || (an.aUp((String)localObject2))))
      {
        bool = false;
        ((Intent)localObject1).putExtra("CropImage_Has_Raw_Img_Btn", bool);
        ((Intent)localObject1).putExtra("from_source", 3);
        localObject2 = this.cXJ.Kkd;
        bc.aCg();
        localObject3 = c.azQ();
        if (paramIntent.getData().toString().startsWith("content://com.google.android.gallery3d")) {
          break label301;
        }
        paramIntent = com.tencent.mm.ui.tools.a.j(((MMFragment)localObject2).getContext(), paramIntent, (String)localObject3);
        if (!bu.isNullOrNil(paramIntent))
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
        new a.1(paramIntent, (MMFragment)localObject2, (String)localObject3, (Intent)localObject1).execute(new Integer[] { Integer.valueOf(0) });
      }
    case 201: 
      localObject1 = this.cXJ.Kkd.getContext().getApplicationContext();
      bc.aCg();
      paramIntent = com.tencent.mm.pluginsdk.ui.tools.q.i((Context)localObject1, paramIntent, c.azQ());
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
      ((Intent)localObject1).putExtra("GalleryUI_FromUser", this.cXJ.fJy());
      ((Intent)localObject1).putExtra("GalleryUI_ToUser", this.cXJ.getTalkerUserName());
      ((Intent)localObject1).putExtra("is_long_click", true);
      ((Intent)localObject1).putStringArrayListExtra("preview_image_list", (ArrayList)localObject2);
      ((Intent)localObject1).addFlags(67108864);
      com.tencent.mm.br.d.a(this.cXJ.Kkd, "gallery", ".ui.GalleryEntryUI", (Intent)localObject1, 217);
      AppMethodBeat.o(35567);
      return true;
    case 217: 
      label301:
      if (paramIntent == null)
      {
        localObject1 = p.aIL().FY(this.cXJ.getTalkerUserName());
        if (((ArrayList)localObject1).size() > 0)
        {
          paramIntent = new Intent();
          paramIntent.putStringArrayListExtra("CropImage_OutputPath_List", (ArrayList)localObject1);
          localObject1 = new ArrayList();
          ((ArrayList)localObject1).add(Integer.valueOf(-1));
          paramIntent.putIntegerArrayListExtra("GalleryUI_ImgIdList", (ArrayList)localObject1);
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(594L, 4L, 1L, true);
        }
      }
      break;
    }
    for (;;)
    {
      if (paramIntent == null)
      {
        ae.e("MicroMsg.ChattingUI.SendImgComponent", "CONTEXT_MENU_WECHAT_GALLERY_IMAGE intent == null");
        AppMethodBeat.o(35567);
        return true;
      }
      localObject2 = paramIntent.getStringExtra("GalleryUI_ToUser");
      if (bu.isNullOrNil((String)localObject2)) {}
      for (localObject1 = this.cXJ.getTalkerUserName();; localObject1 = localObject2)
      {
        ae.i("MicroMsg.ChattingUI.SendImgComponent", "CONTEXT_MENU_WECHAT_GALLERY_IMAGE userFromIntent:%s rawUsername:%s", new Object[] { localObject2, this.cXJ.getTalkerUserName() });
        localObject2 = (com.tencent.mm.ui.chatting.d.b.s)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.s.class);
        ((com.tencent.mm.ui.chatting.d.b.s)localObject2).fHF().clearFocus();
        ((com.tencent.mm.ui.chatting.d.b.s)localObject2).fHF().setBottomPanelVisibility(8);
        localObject3 = (DrawnCallBackLinearLayout)this.cXJ.findViewById(2131298066);
        if (localObject3 == null) {
          break;
        }
        ((DrawnCallBackLinearLayout)localObject3).setListener(new DrawnCallBackLinearLayout.a()
        {
          public final void fIU()
          {
            AppMethodBeat.i(35562);
            bc.ajU().n(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(35561);
                bc.ajU().Mh();
                au.a(au.this, au.3.this.val$data, au.3.this.KhP);
                ((as)au.this.cXJ.bh(as.class)).bu(au.3.this.val$data);
                if (au.3.this.KhQ.fHG() != null) {
                  au.3.this.KhQ.fHG().p(au.3.this.val$requestCode, au.3.this.val$data);
                }
                bc.ajU().foO();
                AppMethodBeat.o(35561);
              }
            }, 100L);
            AppMethodBeat.o(35562);
          }
        });
        break;
      }
      localObject1 = (com.tencent.mm.ui.chatting.d.b.s)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.s.class);
      localObject2 = paramIntent.getStringExtra("CropImage_OutputPath");
      if (localObject2 == null)
      {
        ((com.tencent.mm.ui.chatting.d.b.s)localObject1).fHF().clearFocus();
        AppMethodBeat.o(35567);
        return true;
      }
      bool = paramIntent.getBooleanExtra("CropImage_Compress_Img", true);
      bool = v.f((String)localObject2, this.cXJ.getTalkerUserName(), bool);
      paramIntent.getIntExtra("from_source", 0);
      paramInt2 = paramIntent.getIntExtra("CropImage_rotateCount", 0);
      ae.d("MicroMsg.ChattingUI.SendImgComponent", "dkimgsource" + paramIntent.getIntExtra("from_source", 0));
      if (bool) {}
      for (paramInt1 = i;; paramInt1 = 0)
      {
        R(paramInt1, paramInt2, (String)localObject2);
        ((com.tencent.mm.ui.chatting.d.b.s)localObject1).fHF().clearFocus();
        break;
      }
    }
  }
  
  public final void j(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(35574);
    com.tencent.mm.plugin.recordvideo.e.b localb = com.tencent.mm.plugin.recordvideo.e.b.yhe;
    com.tencent.mm.plugin.recordvideo.e.b.axf(String.valueOf(paramLong));
    ((k)this.cXJ.bh(k.class)).L(paramLong, paramBoolean);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.au
 * JD-Core Version:    0.7.0.1
 */