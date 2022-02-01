package com.tencent.mm.ui.chatting.c;

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
import com.tencent.mm.aw.i.a;
import com.tencent.mm.aw.l;
import com.tencent.mm.aw.n;
import com.tencent.mm.aw.o;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChatFooterCustom;
import com.tencent.mm.ui.chatting.aj;
import com.tencent.mm.ui.chatting.c.b.an;
import com.tencent.mm.ui.chatting.r;
import com.tencent.mm.ui.chatting.v;
import com.tencent.mm.ui.tools.a.1;
import com.tencent.mm.ui.widget.DrawnCallBackLinearLayout;
import com.tencent.mm.ui.widget.DrawnCallBackLinearLayout.a;
import java.util.ArrayList;

@com.tencent.mm.ui.chatting.c.a.a(eYT=com.tencent.mm.ui.chatting.c.b.af.class)
public class ap
  extends a
  implements i.a, com.tencent.mm.ui.chatting.c.b.af
{
  private com.tencent.mm.ui.widget.a.d twJ;
  
  private void bI(bl parambl)
  {
    AppMethodBeat.i(35572);
    r.a(parambl, this.cOd.GzJ.getContext(), this.cOd);
    AppMethodBeat.o(35572);
  }
  
  public final void F(final String paramString1, int paramInt, final String paramString2)
  {
    AppMethodBeat.i(35575);
    Object localObject;
    final com.tencent.mm.ui.chatting.c.b.q localq;
    ImageView localImageView;
    final boolean bool;
    if (((this.twJ == null) || (!this.twJ.isShowing())) && (!bt.isNullOrNil(paramString2)) && (com.tencent.mm.sdk.platformtools.t.aFl(paramString2)))
    {
      localObject = f.e(paramString2, 300, 300, false);
      if (localObject == null)
      {
        ad.e("MicroMsg.ChattingUI.SendImgComponent", "showAlert fail, bmp is null");
        AppMethodBeat.o(35575);
        return;
      }
      localq = (com.tencent.mm.ui.chatting.c.b.q)this.cOd.be(com.tencent.mm.ui.chatting.c.b.q.class);
      localImageView = new ImageView(this.cOd.GzJ.getContext());
      int i = this.cOd.GzJ.getMMResources().getDimensionPixelSize(2131165480);
      localImageView.setImageBitmap((Bitmap)localObject);
      localImageView.setPadding(i, i, i, i);
      localObject = Settings.Secure.getString(this.cOd.GzJ.getContentResolver(), "default_input_method");
      if ((!com.tencent.mm.sdk.platformtools.t.cn(com.tencent.mm.vfs.i.aR(paramString2, 0, -1))) || (localObject == null) || ((!((String)localObject).contains("com.sohu.inputmethod.sogou")) && (!((String)localObject).contains("com.tencent.qqpinyin")))) {
        break label349;
      }
      bool = true;
      if (bool)
      {
        if (!((String)localObject).contains("com.sohu.inputmethod.sogou")) {
          break label355;
        }
        com.tencent.mm.plugin.report.service.h.vKh.dB(1062, 1);
      }
    }
    for (;;)
    {
      this.twJ = com.tencent.mm.ui.base.h.a(this.cOd.GzJ.getContext(), this.cOd.GzJ.getMMResources().getString(2131757310), localImageView, this.cOd.GzJ.getMMResources().getString(2131755835), this.cOd.GzJ.getMMResources().getString(2131755691), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(35564);
          if ((bool) && (localq.eXs() != null) && (localq.eXs().getCallback() != null) && ((localq.eXs().getCallback() instanceof v)))
          {
            if (this.GxZ.contains("com.sohu.inputmethod.sogou")) {
              com.tencent.mm.plugin.report.service.h.vKh.dB(1062, 3);
            }
            for (;;)
            {
              paramAnonymousDialogInterface = new BitmapFactory.Options();
              paramAnonymousDialogInterface.inJustDecodeBounds = true;
              if (((f.decodeFile(paramString2, paramAnonymousDialogInterface) == null) || (paramAnonymousDialogInterface.outHeight <= com.tencent.mm.m.b.YI())) && (paramAnonymousDialogInterface.outWidth <= com.tencent.mm.m.b.YI())) {
                break;
              }
              Toast.makeText(ap.this.cOd.GzJ.getContext(), 2131758246, 0).show();
              AppMethodBeat.o(35564);
              return;
              if (this.GxZ.contains("com.tencent.qqpinyin")) {
                com.tencent.mm.plugin.report.service.h.vKh.dB(1062, 4);
              }
            }
            paramAnonymousDialogInterface = new WXMediaMessage(new WXEmojiObject(paramString2));
            paramAnonymousDialogInterface = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(ap.this.cOd.GzJ.getContext(), paramAnonymousDialogInterface, null);
            if (paramAnonymousDialogInterface != null) {
              ((v)localq.eXs().getCallback()).N(((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Tz(paramAnonymousDialogInterface));
            }
            AppMethodBeat.o(35564);
            return;
          }
          paramAnonymousDialogInterface = new l(5, ap.this.cOd.eYX(), ap.this.cOd.getTalkerUserName(), paramString2, 0, null, 0, "", "", true, 2131231564);
          az.aeS().a(paramAnonymousDialogInterface, 0);
          AppMethodBeat.o(35564);
        }
      }, null);
      paramString1 = paramString1.substring(0, paramInt);
      localq.eXs().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(35565);
          localq.eXs().w(paramString1, -1, false);
          AppMethodBeat.o(35565);
        }
      }, 10L);
      AppMethodBeat.o(35575);
      return;
      label349:
      bool = false;
      break;
      label355:
      if (((String)localObject).contains("com.tencent.qqpinyin")) {
        com.tencent.mm.plugin.report.service.h.vKh.dB(1062, 2);
      }
    }
  }
  
  public final void Q(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(35569);
    if ((paramString == null) || (paramString.equals("")) || (!com.tencent.mm.vfs.i.eK(paramString)))
    {
      ad.d("MicroMsg.ChattingUI.SendImgComponent", " doSendImage : filePath is null or empty");
      AppMethodBeat.o(35569);
      return;
    }
    if (j.aj(this.cOd.zgX))
    {
      AppMethodBeat.o(35569);
      return;
    }
    paramString = new l(4, this.cOd.eYX(), this.cOd.getTalkerUserName(), paramString, paramInt1, null, paramInt2, "", "", true, 2131231564);
    az.aeS().a(paramString, 0);
    this.cOd.wc(true);
    AppMethodBeat.o(35569);
  }
  
  public final void a(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(35573);
    ((com.tencent.mm.ui.chatting.c.b.i)this.cOd.be(com.tencent.mm.ui.chatting.c.b.i.class)).o(paramLong, paramInt1, paramInt2);
    AppMethodBeat.o(35573);
  }
  
  public final void a(ContextMenu paramContextMenu, int paramInt, bl parambl)
  {
    AppMethodBeat.i(35571);
    paramContextMenu.add(paramInt, 100, 0, this.cOd.GzJ.getMMResources().getString(2131757220));
    com.tencent.mm.aw.e locale1 = null;
    if (parambl.field_msgId > 0L) {
      locale1 = o.ayF().ms(parambl.field_msgId);
    }
    com.tencent.mm.aw.e locale2;
    if (locale1 != null)
    {
      locale2 = locale1;
      if (locale1.deI > 0L) {}
    }
    else
    {
      locale2 = locale1;
      if (parambl.field_msgSvrId > 0L) {
        locale2 = o.ayF().mr(parambl.field_msgSvrId);
      }
    }
    if ((parambl.field_isSend == 1) || ((locale2 != null) && (parambl.field_isSend == 0) && (locale2.offset >= locale2.gTY) && (locale2.gTY != 0))) {
      paramContextMenu.add(paramInt, 110, 0, this.cOd.GzJ.getMMResources().getString(2131762559));
    }
    if (locale2 == null) {}
    for (parambl = "";; parambl = o.ayF().p(locale2.hgj, "", ""))
    {
      if ((locale2 != null) && (com.tencent.mm.vfs.i.eK(parambl))) {
        paramContextMenu.add(paramInt, 112, 0, this.cOd.GzJ.getMMResources().getString(2131757150));
      }
      AppMethodBeat.o(35571);
      return;
    }
  }
  
  public final void a(SightCaptureResult paramSightCaptureResult)
  {
    AppMethodBeat.i(35568);
    String str = paramSightCaptureResult.tAX;
    if (!bt.isNullOrNil(str)) {
      try
      {
        boolean bool = paramSightCaptureResult.tAQ;
        ad.i("MicroMsg.ChattingUI.SendImgComponent", "doSendChattingImage, path: %s", new Object[] { str });
        if (bool) {}
        for (int i = 2;; i = 1)
        {
          paramSightCaptureResult = new l(i, u.aqG(), this.cOd.getTalkerUserName(), str, 1, null, 0, "", "", true, 2131231564);
          if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pqx, true))
          {
            com.tencent.mm.plugin.recordvideo.e.b localb = com.tencent.mm.plugin.recordvideo.e.b.vtE;
            com.tencent.mm.plugin.recordvideo.e.b.jdMethod_if(String.valueOf(paramSightCaptureResult.dbD.field_msgId), str);
          }
          az.aeS().a(paramSightCaptureResult, 0);
          AppMethodBeat.o(35568);
          return;
        }
        AppMethodBeat.o(35568);
      }
      catch (Exception paramSightCaptureResult)
      {
        ad.e("MicroMsg.ChattingUI.SendImgComponent", "doSendChattingImage error: %s", new Object[] { paramSightCaptureResult.getMessage() });
      }
    }
  }
  
  public final boolean a(final MenuItem paramMenuItem, final bl parambl)
  {
    AppMethodBeat.i(35566);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(35566);
      return false;
    }
    paramMenuItem = bk.C(parambl);
    if ((bt.isNullOrNil(paramMenuItem)) || (parambl.field_isSend == 1)) {
      bI(parambl);
    }
    for (;;)
    {
      AppMethodBeat.o(35566);
      return true;
      com.tencent.mm.plugin.report.service.h.vKh.f(17509, new Object[] { Integer.valueOf(3), paramMenuItem });
      com.tencent.mm.ui.base.h.a(this.cOd.GzJ.getContext(), 2131762971, 2131762972, 2131755928, 2131757288, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(35559);
          paramAnonymousDialogInterface = new Intent();
          paramAnonymousDialogInterface.putExtra("rawUrl", paramMenuItem);
          paramAnonymousDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Cqe);
          paramAnonymousDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Cqa);
          com.tencent.mm.bs.d.b(ap.this.cOd.GzJ.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousDialogInterface);
          com.tencent.mm.plugin.report.service.h.vKh.f(17509, new Object[] { Integer.valueOf(1), paramMenuItem });
          AppMethodBeat.o(35559);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(35560);
          ap.a(ap.this, parambl);
          com.tencent.mm.plugin.report.service.h.vKh.f(17509, new Object[] { Integer.valueOf(2), paramMenuItem });
          AppMethodBeat.o(35560);
        }
      });
    }
  }
  
  public final boolean bx(bl parambl)
  {
    AppMethodBeat.i(35570);
    if (!parambl.eJO())
    {
      AppMethodBeat.o(35570);
      return false;
    }
    az.arV();
    if (!c.isSDCardAvailable())
    {
      com.tencent.mm.ui.base.t.g(this.cOd.GzJ.getContext(), this.cOd.GzJ.getContentView());
      AppMethodBeat.o(35570);
      return true;
    }
    if (!this.cOd.getTalkerUserName().equals("medianote"))
    {
      az.arV();
      c.apL().c(new com.tencent.mm.bb.e(parambl.field_talker, parambl.field_msgSvrId));
    }
    aj.bn(parambl);
    this.cOd.wc(true);
    AppMethodBeat.o(35570);
    return true;
  }
  
  public final void eQC()
  {
    AppMethodBeat.i(35577);
    o.ayD().hhz = this;
    AppMethodBeat.o(35577);
  }
  
  public final void eQF()
  {
    AppMethodBeat.i(35578);
    o.ayD().hhz = null;
    AppMethodBeat.o(35578);
  }
  
  public final void eWx()
  {
    AppMethodBeat.i(35579);
    super.eWx();
    o.ayD().hhz = null;
    AppMethodBeat.o(35579);
  }
  
  public final void h(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(35574);
    com.tencent.mm.plugin.recordvideo.e.b localb = com.tencent.mm.plugin.recordvideo.e.b.vtE;
    com.tencent.mm.plugin.recordvideo.e.b.alP(String.valueOf(paramLong));
    ((com.tencent.mm.ui.chatting.c.b.i)this.cOd.be(com.tencent.mm.ui.chatting.c.b.i.class)).I(paramLong, paramBoolean);
    AppMethodBeat.o(35574);
  }
  
  public final boolean h(final int paramInt1, int paramInt2, final Intent paramIntent)
  {
    int i = 1;
    AppMethodBeat.i(35567);
    this.cOd.dismissDialog();
    if (paramInt2 != -1)
    {
      ad.e("MicroMsg.ChattingUI.SendImgComponent", "[dealWithRequestCode] resultCode:%d", new Object[] { Integer.valueOf(paramInt2) });
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
      ((Intent)localObject1).setClassName(this.cOd.GzJ.getContext(), "com.tencent.mm.ui.tools.CropImageNewUI");
      ((Intent)localObject1).putExtra("CropImageMode", 4);
      ((Intent)localObject1).putExtra("CropImage_Filter", true);
      localObject2 = this.cOd.getTalkerUserName();
      if ((localObject2 != null) && ((com.tencent.mm.storage.af.aHE((String)localObject2)) || (com.tencent.mm.storage.af.aHG((String)localObject2))))
      {
        bool = false;
        ((Intent)localObject1).putExtra("CropImage_Has_Raw_Img_Btn", bool);
        ((Intent)localObject1).putExtra("from_source", 3);
        localObject2 = this.cOd.GzJ;
        az.arV();
        localObject3 = c.apW();
        if (paramIntent.getData().toString().startsWith("content://com.google.android.gallery3d")) {
          break label301;
        }
        paramIntent = com.tencent.mm.ui.tools.a.i(((MMFragment)localObject2).getContext(), paramIntent, (String)localObject3);
        if (!bt.isNullOrNil(paramIntent))
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
      localObject1 = this.cOd.GzJ.getContext().getApplicationContext();
      az.arV();
      paramIntent = com.tencent.mm.pluginsdk.ui.tools.q.h((Context)localObject1, paramIntent, c.apW());
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
      ((Intent)localObject1).putExtra("GalleryUI_FromUser", this.cOd.eYX());
      ((Intent)localObject1).putExtra("GalleryUI_ToUser", this.cOd.getTalkerUserName());
      ((Intent)localObject1).putExtra("is_long_click", true);
      ((Intent)localObject1).putStringArrayListExtra("preview_image_list", (ArrayList)localObject2);
      ((Intent)localObject1).addFlags(67108864);
      com.tencent.mm.bs.d.a(this.cOd.GzJ, "gallery", ".ui.GalleryEntryUI", (Intent)localObject1, 217);
      AppMethodBeat.o(35567);
      return true;
    case 217: 
      label301:
      if (paramIntent == null)
      {
        localObject1 = n.ayt().yn(this.cOd.getTalkerUserName());
        if (((ArrayList)localObject1).size() > 0)
        {
          paramIntent = new Intent();
          paramIntent.putStringArrayListExtra("CropImage_OutputPath_List", (ArrayList)localObject1);
          localObject1 = new ArrayList();
          ((ArrayList)localObject1).add(Integer.valueOf(-1));
          paramIntent.putIntegerArrayListExtra("GalleryUI_ImgIdList", (ArrayList)localObject1);
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(594L, 4L, 1L, true);
        }
      }
      break;
    }
    for (;;)
    {
      if (paramIntent == null)
      {
        ad.e("MicroMsg.ChattingUI.SendImgComponent", "CONTEXT_MENU_WECHAT_GALLERY_IMAGE intent == null");
        AppMethodBeat.o(35567);
        return true;
      }
      localObject2 = paramIntent.getStringExtra("GalleryUI_ToUser");
      if (bt.isNullOrNil((String)localObject2)) {}
      for (localObject1 = this.cOd.getTalkerUserName();; localObject1 = localObject2)
      {
        ad.i("MicroMsg.ChattingUI.SendImgComponent", "CONTEXT_MENU_WECHAT_GALLERY_IMAGE userFromIntent:%s rawUsername:%s", new Object[] { localObject2, this.cOd.getTalkerUserName() });
        localObject2 = (com.tencent.mm.ui.chatting.c.b.q)this.cOd.be(com.tencent.mm.ui.chatting.c.b.q.class);
        ((com.tencent.mm.ui.chatting.c.b.q)localObject2).eXs().clearFocus();
        ((com.tencent.mm.ui.chatting.c.b.q)localObject2).eXs().setBottomPanelVisibility(8);
        localObject3 = (DrawnCallBackLinearLayout)this.cOd.findViewById(2131298066);
        if (localObject3 == null) {
          break;
        }
        ((DrawnCallBackLinearLayout)localObject3).setListener(new DrawnCallBackLinearLayout.a()
        {
          public final void eYB()
          {
            AppMethodBeat.i(35562);
            az.afE().m(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(35561);
                az.afE().KL();
                ap.a(ap.this, ap.3.this.val$data, ap.3.this.GxV);
                ((an)ap.this.cOd.be(an.class)).bn(ap.3.this.val$data);
                if (ap.3.this.GxW.eXt() != null) {
                  ap.3.this.GxW.eXt().q(ap.3.this.val$requestCode, ap.3.this.val$data);
                }
                az.afE().eFR();
                AppMethodBeat.o(35561);
              }
            }, 100L);
            AppMethodBeat.o(35562);
          }
        });
        break;
      }
      localObject1 = (com.tencent.mm.ui.chatting.c.b.q)this.cOd.be(com.tencent.mm.ui.chatting.c.b.q.class);
      localObject2 = paramIntent.getStringExtra("CropImage_OutputPath");
      if (localObject2 == null)
      {
        ((com.tencent.mm.ui.chatting.c.b.q)localObject1).eXs().clearFocus();
        AppMethodBeat.o(35567);
        return true;
      }
      bool = paramIntent.getBooleanExtra("CropImage_Compress_Img", true);
      bool = u.f((String)localObject2, this.cOd.getTalkerUserName(), bool);
      paramIntent.getIntExtra("from_source", 0);
      paramInt2 = paramIntent.getIntExtra("CropImage_rotateCount", 0);
      ad.d("MicroMsg.ChattingUI.SendImgComponent", "dkimgsource" + paramIntent.getIntExtra("from_source", 0));
      if (bool) {}
      for (paramInt1 = i;; paramInt1 = 0)
      {
        Q(paramInt1, paramInt2, (String)localObject2);
        ((com.tencent.mm.ui.chatting.c.b.q)localObject1).eXs().clearFocus();
        break;
      }
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(35576);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    h(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(35576);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.ap
 * JD-Core Version:    0.7.0.1
 */