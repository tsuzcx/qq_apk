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
import com.tencent.mm.aw.k.a;
import com.tencent.mm.aw.n;
import com.tencent.mm.aw.p;
import com.tencent.mm.bb.f;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChatFooterCustom;
import com.tencent.mm.ui.chatting.d.b.ar;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.d.b.s;
import com.tencent.mm.ui.chatting.r;
import com.tencent.mm.ui.chatting.v;
import com.tencent.mm.ui.tools.a.1;
import com.tencent.mm.ui.widget.DrawnCallBackLinearLayout;
import com.tencent.mm.ui.widget.DrawnCallBackLinearLayout.a;
import java.util.ArrayList;

@com.tencent.mm.ui.chatting.d.a.a(fFo=com.tencent.mm.ui.chatting.d.b.aj.class)
public class at
  extends a
  implements k.a, com.tencent.mm.ui.chatting.d.b.aj
{
  private com.tencent.mm.ui.widget.a.d vIb;
  
  private void bQ(bu parambu)
  {
    AppMethodBeat.i(35572);
    r.a(parambu, this.cWM.JOR.getContext(), this.cWM);
    AppMethodBeat.o(35572);
  }
  
  public final void F(final String paramString1, int paramInt, final String paramString2)
  {
    AppMethodBeat.i(35575);
    Object localObject;
    final s locals;
    ImageView localImageView;
    final boolean bool;
    if (((this.vIb == null) || (!this.vIb.isShowing())) && (!bt.isNullOrNil(paramString2)) && (com.tencent.mm.sdk.platformtools.t.aQi(paramString2)))
    {
      localObject = com.tencent.mm.sdk.platformtools.g.d(paramString2, 300, 300, false);
      if (localObject == null)
      {
        ad.e("MicroMsg.ChattingUI.SendImgComponent", "showAlert fail, bmp is null");
        AppMethodBeat.o(35575);
        return;
      }
      locals = (s)this.cWM.bh(s.class);
      localImageView = new ImageView(this.cWM.JOR.getContext());
      int i = this.cWM.JOR.getMMResources().getDimensionPixelSize(2131165480);
      localImageView.setImageBitmap((Bitmap)localObject);
      localImageView.setPadding(i, i, i, i);
      localObject = Settings.Secure.getString(this.cWM.JOR.getContentResolver(), "default_input_method");
      if ((!com.tencent.mm.sdk.platformtools.t.ct(com.tencent.mm.vfs.i.aY(paramString2, 0, -1))) || (localObject == null) || ((!((String)localObject).contains("com.sohu.inputmethod.sogou")) && (!((String)localObject).contains("com.tencent.qqpinyin")))) {
        break label349;
      }
      bool = true;
      if (bool)
      {
        if (!((String)localObject).contains("com.sohu.inputmethod.sogou")) {
          break label355;
        }
        com.tencent.mm.plugin.report.service.g.yhR.dD(1062, 1);
      }
    }
    for (;;)
    {
      this.vIb = h.a(this.cWM.JOR.getContext(), this.cWM.JOR.getMMResources().getString(2131757310), localImageView, this.cWM.JOR.getMMResources().getString(2131755835), this.cWM.JOR.getMMResources().getString(2131755691), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(35564);
          if ((bool) && (locals.fDC() != null) && (locals.fDC().getCallback() != null) && ((locals.fDC().getCallback() instanceof v)))
          {
            if (this.JMW.contains("com.sohu.inputmethod.sogou")) {
              com.tencent.mm.plugin.report.service.g.yhR.dD(1062, 3);
            }
            for (;;)
            {
              paramAnonymousDialogInterface = new BitmapFactory.Options();
              paramAnonymousDialogInterface.inJustDecodeBounds = true;
              if (((com.tencent.mm.sdk.platformtools.g.decodeFile(paramString2, paramAnonymousDialogInterface) == null) || (paramAnonymousDialogInterface.outHeight <= com.tencent.mm.n.b.acf())) && (paramAnonymousDialogInterface.outWidth <= com.tencent.mm.n.b.acf())) {
                break;
              }
              Toast.makeText(at.this.cWM.JOR.getContext(), 2131758246, 0).show();
              AppMethodBeat.o(35564);
              return;
              if (this.JMW.contains("com.tencent.qqpinyin")) {
                com.tencent.mm.plugin.report.service.g.yhR.dD(1062, 4);
              }
            }
            paramAnonymousDialogInterface = new WXMediaMessage(new WXEmojiObject(paramString2));
            paramAnonymousDialogInterface = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(at.this.cWM.JOR.getContext(), paramAnonymousDialogInterface, null);
            if (paramAnonymousDialogInterface != null) {
              ((v)locals.fDC().getCallback()).M(((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().abr(paramAnonymousDialogInterface));
            }
            AppMethodBeat.o(35564);
            return;
          }
          paramAnonymousDialogInterface = o.a(o.d.ifX).pk(5);
          paramAnonymousDialogInterface.dyU = at.this.cWM.fFr();
          paramAnonymousDialogInterface.toUser = at.this.cWM.getTalkerUserName();
          paramAnonymousDialogInterface.ibF = paramString2;
          paramAnonymousDialogInterface.hZz = 0;
          paramAnonymousDialogInterface.igd = null;
          paramAnonymousDialogInterface.dxr = 0;
          paramAnonymousDialogInterface.hZI = "";
          paramAnonymousDialogInterface.thumbPath = "";
          paramAnonymousDialogInterface.igg = true;
          paramAnonymousDialogInterface.igf = 2131231564;
          paramAnonymousDialogInterface.igc = 11;
          paramAnonymousDialogInterface.aJv().execute();
          AppMethodBeat.o(35564);
        }
      }, null);
      paramString1 = paramString1.substring(0, paramInt);
      locals.fDC().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(35565);
          locals.fDC().w(paramString1, -1, false);
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
        com.tencent.mm.plugin.report.service.g.yhR.dD(1062, 2);
      }
    }
  }
  
  public final void R(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(35569);
    if ((paramString == null) || (paramString.equals("")) || (!com.tencent.mm.vfs.i.fv(paramString)))
    {
      ad.d("MicroMsg.ChattingUI.SendImgComponent", " doSendImage : filePath is null or empty");
      AppMethodBeat.o(35569);
      return;
    }
    if (l.ak(this.cWM.BYG))
    {
      AppMethodBeat.o(35569);
      return;
    }
    o.e locale = o.a(o.d.ifX).pk(4);
    locale.dyU = this.cWM.fFr();
    locale.toUser = this.cWM.getTalkerUserName();
    locale.ibF = paramString;
    locale.hZz = paramInt1;
    locale.igd = null;
    locale.dxr = paramInt2;
    locale.hZI = "";
    locale.thumbPath = "";
    locale.igg = true;
    locale.igf = 2131231564;
    locale.igc = 11;
    locale.aJv().execute();
    this.cWM.xR(true);
    AppMethodBeat.o(35569);
  }
  
  public final void a(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(35573);
    ((k)this.cWM.bh(k.class)).r(paramLong, paramInt1, paramInt2);
    AppMethodBeat.o(35573);
  }
  
  public final void a(ContextMenu paramContextMenu, int paramInt, bu parambu)
  {
    AppMethodBeat.i(35571);
    paramContextMenu.add(paramInt, 100, 0, this.cWM.JOR.getMMResources().getString(2131757220));
    com.tencent.mm.aw.g localg1 = null;
    if (parambu.field_msgId > 0L) {
      localg1 = com.tencent.mm.aw.q.aIF().G(parambu.field_talker, parambu.field_msgId);
    }
    com.tencent.mm.aw.g localg2;
    if (localg1 != null)
    {
      localg2 = localg1;
      if (localg1.dnz > 0L) {}
    }
    else
    {
      localg2 = localg1;
      if (parambu.field_msgSvrId > 0L) {
        localg2 = com.tencent.mm.aw.q.aIF().F(parambu.field_talker, parambu.field_msgSvrId);
      }
    }
    if ((parambu.field_isSend == 1) || ((localg2 != null) && (parambu.field_isSend == 0) && (localg2.offset >= localg2.hMP) && (localg2.hMP != 0))) {
      paramContextMenu.add(paramInt, 110, 0, this.cWM.JOR.getMMResources().getString(2131762559));
    }
    if (localg2 == null) {}
    for (parambu = "";; parambu = com.tencent.mm.aw.q.aIF().o(localg2.hZw, "", ""))
    {
      if ((localg2 != null) && (com.tencent.mm.vfs.i.fv(parambu))) {
        paramContextMenu.add(paramInt, 112, 0, this.cWM.JOR.getMMResources().getString(2131757150));
      }
      AppMethodBeat.o(35571);
      return;
    }
  }
  
  public final void a(SightCaptureResult paramSightCaptureResult)
  {
    AppMethodBeat.i(35568);
    String str = paramSightCaptureResult.vMA;
    if (!bt.isNullOrNil(str)) {
      try
      {
        boolean bool = paramSightCaptureResult.vMt;
        ad.i("MicroMsg.ChattingUI.SendImgComponent", "doSendChattingImage, path: %s", new Object[] { str });
        paramSightCaptureResult = o.a(o.d.ifX);
        if (bool) {}
        for (int i = 2;; i = 1)
        {
          paramSightCaptureResult = paramSightCaptureResult.pk(i);
          paramSightCaptureResult.dyU = u.aAm();
          paramSightCaptureResult.toUser = this.cWM.getTalkerUserName();
          paramSightCaptureResult.ibF = str;
          paramSightCaptureResult.hZz = 1;
          paramSightCaptureResult.igd = null;
          paramSightCaptureResult.dxr = 0;
          paramSightCaptureResult.hZI = "";
          paramSightCaptureResult.thumbPath = "";
          paramSightCaptureResult.igg = true;
          paramSightCaptureResult.igf = 2131231564;
          paramSightCaptureResult.igc = 11;
          paramSightCaptureResult = (n)paramSightCaptureResult.aJv().ifV;
          if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qyQ, true))
          {
            com.tencent.mm.plugin.recordvideo.e.b localb = com.tencent.mm.plugin.recordvideo.e.b.xRl;
            com.tencent.mm.plugin.recordvideo.e.b.iL(String.valueOf(paramSightCaptureResult.aIr().field_msgId), str);
          }
          ba.aiU().a(paramSightCaptureResult, 0);
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
  
  public final boolean a(final MenuItem paramMenuItem, final bu parambu)
  {
    AppMethodBeat.i(35566);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(35566);
      return false;
    }
    paramMenuItem = bl.E(parambu);
    if ((bt.isNullOrNil(paramMenuItem)) || (parambu.field_isSend == 1)) {
      bQ(parambu);
    }
    for (;;)
    {
      AppMethodBeat.o(35566);
      return true;
      com.tencent.mm.plugin.report.service.g.yhR.f(17509, new Object[] { Integer.valueOf(3), paramMenuItem });
      h.a(this.cWM.JOR.getContext(), 2131762971, 2131762972, 2131755928, 2131757288, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(35559);
          paramAnonymousDialogInterface = new Intent();
          paramAnonymousDialogInterface.putExtra("rawUrl", paramMenuItem);
          paramAnonymousDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.FnD);
          paramAnonymousDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Fnz);
          com.tencent.mm.bs.d.b(at.this.cWM.JOR.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousDialogInterface);
          com.tencent.mm.plugin.report.service.g.yhR.f(17509, new Object[] { Integer.valueOf(1), paramMenuItem });
          AppMethodBeat.o(35559);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(35560);
          at.a(at.this, parambu);
          com.tencent.mm.plugin.report.service.g.yhR.f(17509, new Object[] { Integer.valueOf(2), paramMenuItem });
          AppMethodBeat.o(35560);
        }
      });
    }
  }
  
  public final boolean bF(bu parambu)
  {
    AppMethodBeat.i(35570);
    if (!parambu.fpi())
    {
      AppMethodBeat.o(35570);
      return false;
    }
    ba.aBQ();
    if (!c.isSDCardAvailable())
    {
      com.tencent.mm.ui.base.t.g(this.cWM.JOR.getContext(), this.cWM.JOR.getContentView());
      AppMethodBeat.o(35570);
      return true;
    }
    if (!this.cWM.getTalkerUserName().equals("medianote"))
    {
      ba.aBQ();
      c.azo().c(new f(parambu.field_talker, parambu.field_msgSvrId));
    }
    com.tencent.mm.ui.chatting.aj.bt(parambu);
    this.cWM.xR(true);
    AppMethodBeat.o(35570);
    return true;
  }
  
  public final void fCC()
  {
    AppMethodBeat.i(35579);
    super.fCC();
    com.tencent.mm.aw.q.aID().iaQ = null;
    AppMethodBeat.o(35579);
  }
  
  public final void fwu()
  {
    AppMethodBeat.i(35577);
    com.tencent.mm.aw.q.aID().iaQ = this;
    AppMethodBeat.o(35577);
  }
  
  public final void fwx()
  {
    AppMethodBeat.i(35578);
    com.tencent.mm.aw.q.aID().iaQ = null;
    AppMethodBeat.o(35578);
  }
  
  public final boolean h(final int paramInt1, int paramInt2, final Intent paramIntent)
  {
    int i = 1;
    AppMethodBeat.i(35567);
    this.cWM.dismissDialog();
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
      ((Intent)localObject1).setClassName(this.cWM.JOR.getContext(), "com.tencent.mm.ui.tools.CropImageNewUI");
      ((Intent)localObject1).putExtra("CropImageMode", 4);
      ((Intent)localObject1).putExtra("CropImage_Filter", true);
      localObject2 = this.cWM.getTalkerUserName();
      if ((localObject2 != null) && ((am.aSN((String)localObject2)) || (am.aSP((String)localObject2))))
      {
        bool = false;
        ((Intent)localObject1).putExtra("CropImage_Has_Raw_Img_Btn", bool);
        ((Intent)localObject1).putExtra("from_source", 3);
        localObject2 = this.cWM.JOR;
        ba.aBQ();
        localObject3 = c.azA();
        if (paramIntent.getData().toString().startsWith("content://com.google.android.gallery3d")) {
          break label301;
        }
        paramIntent = com.tencent.mm.ui.tools.a.j(((MMFragment)localObject2).getContext(), paramIntent, (String)localObject3);
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
      localObject1 = this.cWM.JOR.getContext().getApplicationContext();
      ba.aBQ();
      paramIntent = com.tencent.mm.pluginsdk.ui.tools.q.i((Context)localObject1, paramIntent, c.azA());
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
      ((Intent)localObject1).putExtra("GalleryUI_FromUser", this.cWM.fFr());
      ((Intent)localObject1).putExtra("GalleryUI_ToUser", this.cWM.getTalkerUserName());
      ((Intent)localObject1).putExtra("is_long_click", true);
      ((Intent)localObject1).putStringArrayListExtra("preview_image_list", (ArrayList)localObject2);
      ((Intent)localObject1).addFlags(67108864);
      com.tencent.mm.bs.d.a(this.cWM.JOR, "gallery", ".ui.GalleryEntryUI", (Intent)localObject1, 217);
      AppMethodBeat.o(35567);
      return true;
    case 217: 
      label301:
      if (paramIntent == null)
      {
        localObject1 = p.aIt().Fw(this.cWM.getTalkerUserName());
        if (((ArrayList)localObject1).size() > 0)
        {
          paramIntent = new Intent();
          paramIntent.putStringArrayListExtra("CropImage_OutputPath_List", (ArrayList)localObject1);
          localObject1 = new ArrayList();
          ((ArrayList)localObject1).add(Integer.valueOf(-1));
          paramIntent.putIntegerArrayListExtra("GalleryUI_ImgIdList", (ArrayList)localObject1);
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(594L, 4L, 1L, true);
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
      for (localObject1 = this.cWM.getTalkerUserName();; localObject1 = localObject2)
      {
        ad.i("MicroMsg.ChattingUI.SendImgComponent", "CONTEXT_MENU_WECHAT_GALLERY_IMAGE userFromIntent:%s rawUsername:%s", new Object[] { localObject2, this.cWM.getTalkerUserName() });
        localObject2 = (s)this.cWM.bh(s.class);
        ((s)localObject2).fDC().clearFocus();
        ((s)localObject2).fDC().setBottomPanelVisibility(8);
        localObject3 = (DrawnCallBackLinearLayout)this.cWM.findViewById(2131298066);
        if (localObject3 == null) {
          break;
        }
        ((DrawnCallBackLinearLayout)localObject3).setListener(new DrawnCallBackLinearLayout.a()
        {
          public final void fER()
          {
            AppMethodBeat.i(35562);
            ba.ajF().n(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(35561);
                ba.ajF().LZ();
                at.a(at.this, at.3.this.val$data, at.3.this.JMS);
                ((ar)at.this.cWM.bh(ar.class)).bt(at.3.this.val$data);
                if (at.3.this.JMT.fDD() != null) {
                  at.3.this.JMT.fDD().p(at.3.this.val$requestCode, at.3.this.val$data);
                }
                ba.ajF().fkT();
                AppMethodBeat.o(35561);
              }
            }, 100L);
            AppMethodBeat.o(35562);
          }
        });
        break;
      }
      localObject1 = (s)this.cWM.bh(s.class);
      localObject2 = paramIntent.getStringExtra("CropImage_OutputPath");
      if (localObject2 == null)
      {
        ((s)localObject1).fDC().clearFocus();
        AppMethodBeat.o(35567);
        return true;
      }
      bool = paramIntent.getBooleanExtra("CropImage_Compress_Img", true);
      bool = u.f((String)localObject2, this.cWM.getTalkerUserName(), bool);
      paramIntent.getIntExtra("from_source", 0);
      paramInt2 = paramIntent.getIntExtra("CropImage_rotateCount", 0);
      ad.d("MicroMsg.ChattingUI.SendImgComponent", "dkimgsource" + paramIntent.getIntExtra("from_source", 0));
      if (bool) {}
      for (paramInt1 = i;; paramInt1 = 0)
      {
        R(paramInt1, paramInt2, (String)localObject2);
        ((s)localObject1).fDC().clearFocus();
        break;
      }
    }
  }
  
  public final void j(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(35574);
    com.tencent.mm.plugin.recordvideo.e.b localb = com.tencent.mm.plugin.recordvideo.e.b.xRl;
    com.tencent.mm.plugin.recordvideo.e.b.avQ(String.valueOf(paramLong));
    ((k)this.cWM.bh(k.class)).J(paramLong, paramBoolean);
    AppMethodBeat.o(35574);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(35576);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    h(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(35576);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.at
 * JD-Core Version:    0.7.0.1
 */