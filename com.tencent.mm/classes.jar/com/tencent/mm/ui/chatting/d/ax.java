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
import com.tencent.mm.ak.t;
import com.tencent.mm.av.i;
import com.tencent.mm.av.k.a;
import com.tencent.mm.av.n;
import com.tencent.mm.av.p;
import com.tencent.mm.av.q;
import com.tencent.mm.ba.f;
import com.tencent.mm.g.b.a.jc;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.br;
import com.tencent.mm.model.z;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.modelmulti.o.b;
import com.tencent.mm.modelmulti.o.d;
import com.tencent.mm.modelmulti.o.e;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.expt.b.b;
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
import com.tencent.mm.ui.chatting.d.b.an;
import com.tencent.mm.ui.chatting.d.b.av;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.w;
import com.tencent.mm.ui.tools.a.1;
import com.tencent.mm.ui.widget.DrawnCallBackLinearLayout;
import com.tencent.mm.ui.widget.DrawnCallBackLinearLayout.a;
import java.util.ArrayList;

@com.tencent.mm.ui.chatting.d.a.a(gRF=an.class)
public class ax
  extends a
  implements k.a, an
{
  private com.tencent.mm.ui.widget.a.d zol;
  
  private void cf(ca paramca)
  {
    AppMethodBeat.i(35572);
    com.tencent.mm.ui.chatting.s.a(paramca, this.dom.Pwc.getContext(), this.dom);
    AppMethodBeat.o(35572);
  }
  
  public final void Q(final String paramString1, int paramInt, final String paramString2)
  {
    AppMethodBeat.i(35575);
    if (((this.zol == null) || (!this.zol.isShowing())) && (!Util.isNullOrNil(paramString2)) && (ImgUtil.isImgFile(paramString2)))
    {
      Object localObject = BitmapUtil.extractThumbNail(paramString2, 300, 300, false);
      if (localObject == null)
      {
        Log.e("MicroMsg.ChattingUI.SendImgComponent", "showAlert fail, bmp is null");
        AppMethodBeat.o(35575);
        return;
      }
      final com.tencent.mm.ui.chatting.d.b.u localu = (com.tencent.mm.ui.chatting.d.b.u)this.dom.bh(com.tencent.mm.ui.chatting.d.b.u.class);
      ImageView localImageView = new ImageView(this.dom.Pwc.getContext());
      int i = this.dom.Pwc.getMMResources().getDimensionPixelSize(2131165498);
      localImageView.setImageBitmap((Bitmap)localObject);
      localImageView.setPadding(i, i, i, i);
      localObject = Settings.Secure.getString(this.dom.Pwc.getContentResolver(), "default_input_method");
      final boolean bool;
      if ((ImgUtil.isGif(com.tencent.mm.vfs.s.aW(paramString2, 0, -1))) && (localObject != null) && ((((String)localObject).contains("com.sohu.inputmethod.sogou")) || (((String)localObject).contains("com.tencent.qqpinyin"))))
      {
        bool = true;
        if (bool)
        {
          if (!((String)localObject).contains("com.sohu.inputmethod.sogou")) {
            break label329;
          }
          com.tencent.mm.plugin.report.service.h.CyF.dN(1062, 1);
        }
      }
      for (;;)
      {
        if ((!bool) || (!as.bjw(this.dom.getTalkerUserName()))) {
          break label353;
        }
        paramString1 = paramString1.substring(0, paramInt);
        localu.gPO().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(233186);
            localu.gPO().z(paramString1, -1, false);
            AppMethodBeat.o(233186);
          }
        }, 0L);
        Log.i("MicroMsg.ChattingUI.SendImgComponent", "gamelife fobidden image: from the third playground");
        Toast.makeText(this.dom.Pwc.getContext(), this.dom.Pwc.getMMResources().getString(2131758590), 0).show();
        AppMethodBeat.o(35575);
        return;
        bool = false;
        break;
        label329:
        if (((String)localObject).contains("com.tencent.qqpinyin")) {
          com.tencent.mm.plugin.report.service.h.CyF.dN(1062, 2);
        }
      }
      label353:
      this.zol = com.tencent.mm.ui.base.h.a(this.dom.Pwc.getContext(), this.dom.Pwc.getMMResources().getString(2131757524), localImageView, this.dom.Pwc.getMMResources().getString(2131755921), this.dom.Pwc.getMMResources().getString(2131755761), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(233187);
          if ((bool) && (localu.gPO() != null) && (localu.gPO().getCallback() != null) && ((localu.gPO().getCallback() instanceof w)))
          {
            if (this.PtP.contains("com.sohu.inputmethod.sogou")) {
              com.tencent.mm.plugin.report.service.h.CyF.dN(1062, 3);
            }
            for (;;)
            {
              paramAnonymousDialogInterface = new BitmapFactory.Options();
              paramAnonymousDialogInterface.inJustDecodeBounds = true;
              if (((BitmapUtil.decodeFile(paramString2, paramAnonymousDialogInterface) == null) || (paramAnonymousDialogInterface.outHeight <= com.tencent.mm.n.c.aqo())) && (paramAnonymousDialogInterface.outWidth <= com.tencent.mm.n.c.aqo())) {
                break;
              }
              Toast.makeText(ax.this.dom.Pwc.getContext(), 2131758534, 0).show();
              AppMethodBeat.o(233187);
              return;
              if (this.PtP.contains("com.tencent.qqpinyin")) {
                com.tencent.mm.plugin.report.service.h.CyF.dN(1062, 4);
              }
            }
            paramAnonymousDialogInterface = new WXMediaMessage(new WXEmojiObject(paramString2));
            paramAnonymousDialogInterface = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(ax.this.dom.Pwc.getContext(), paramAnonymousDialogInterface, null);
            if (paramAnonymousDialogInterface != null) {
              ((w)localu.gPO().getCallback()).N(((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aml(paramAnonymousDialogInterface));
            }
            AppMethodBeat.o(233187);
            return;
          }
          paramAnonymousDialogInterface = o.a(o.d.jdL).tc(5);
          paramAnonymousDialogInterface.dRL = ax.this.dom.gRI();
          paramAnonymousDialogInterface.toUser = ax.this.dom.getTalkerUserName();
          paramAnonymousDialogInterface.iZt = paramString2;
          paramAnonymousDialogInterface.iXp = 0;
          paramAnonymousDialogInterface.jdS = null;
          paramAnonymousDialogInterface.dQd = 0;
          paramAnonymousDialogInterface.iXy = "";
          paramAnonymousDialogInterface.thumbPath = "";
          paramAnonymousDialogInterface.jdV = true;
          paramAnonymousDialogInterface.jdU = 2131231628;
          paramAnonymousDialogInterface.jdR = 11;
          paramAnonymousDialogInterface.bdQ().execute();
          AppMethodBeat.o(233187);
        }
      }, null);
      paramString1 = paramString1.substring(0, paramInt);
      localu.gPO().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(233188);
          localu.gPO().z(paramString1, -1, false);
          AppMethodBeat.o(233188);
        }
      }, 10L);
    }
    AppMethodBeat.o(35575);
  }
  
  public final void T(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(35569);
    if ((paramString == null) || (paramString.equals("")) || (!com.tencent.mm.vfs.s.YS(paramString)))
    {
      Log.d("MicroMsg.ChattingUI.SendImgComponent", " doSendImage : filePath is null or empty");
      AppMethodBeat.o(35569);
      return;
    }
    if (l.at(this.dom.GUe))
    {
      AppMethodBeat.o(35569);
      return;
    }
    o.e locale = o.a(o.d.jdL).tc(4);
    locale.dRL = this.dom.gRI();
    locale.toUser = this.dom.getTalkerUserName();
    locale.iZt = paramString;
    locale.iXp = paramInt1;
    locale.jdS = null;
    locale.dQd = paramInt2;
    locale.iXy = "";
    locale.thumbPath = "";
    locale.jdV = true;
    locale.jdU = 2131231628;
    locale.jdR = 11;
    locale.bdQ().execute();
    this.dom.BN(true);
    AppMethodBeat.o(35569);
  }
  
  public final void a(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(35573);
    ((k)this.dom.bh(k.class)).s(paramLong, paramInt1, paramInt2);
    AppMethodBeat.o(35573);
  }
  
  public final void a(ContextMenu paramContextMenu, int paramInt, ca paramca)
  {
    AppMethodBeat.i(35571);
    paramContextMenu.add(paramInt, 100, 0, this.dom.Pwc.getMMResources().getString(2131757432));
    com.tencent.mm.av.g localg1 = null;
    if (paramca.field_msgId > 0L) {
      localg1 = q.bcR().H(paramca.field_talker, paramca.field_msgId);
    }
    com.tencent.mm.av.g localg2;
    if (localg1 != null)
    {
      localg2 = localg1;
      if (localg1.localId > 0L) {}
    }
    else
    {
      localg2 = localg1;
      if (paramca.field_msgSvrId > 0L) {
        localg2 = q.bcR().G(paramca.field_talker, paramca.field_msgSvrId);
      }
    }
    if ((paramca.field_isSend == 1) || ((localg2 != null) && (paramca.field_isSend == 0) && (localg2.offset >= localg2.iKP) && (localg2.iKP != 0))) {
      paramContextMenu.add(paramInt, 110, 0, this.dom.Pwc.getMMResources().getString(2131764628));
    }
    if (localg2 == null) {}
    for (paramca = "";; paramca = q.bcR().o(localg2.iXm, "", ""))
    {
      if ((localg2 != null) && (com.tencent.mm.vfs.s.YS(paramca))) {
        paramContextMenu.add(paramInt, 112, 0, this.dom.Pwc.getMMResources().getString(2131757354));
      }
      AppMethodBeat.o(35571);
      return;
    }
  }
  
  public final void a(SightCaptureResult paramSightCaptureResult)
  {
    AppMethodBeat.i(35568);
    String str = paramSightCaptureResult.zsG;
    if (!Util.isNullOrNil(str)) {
      try
      {
        boolean bool = paramSightCaptureResult.zsz;
        Log.i("MicroMsg.ChattingUI.SendImgComponent", "doSendChattingImage, path: %s", new Object[] { str });
        paramSightCaptureResult = o.a(o.d.jdL);
        if (bool) {}
        for (int i = 2;; i = 1)
        {
          paramSightCaptureResult = paramSightCaptureResult.tc(i);
          paramSightCaptureResult.dRL = z.aTY();
          paramSightCaptureResult.toUser = this.dom.getTalkerUserName();
          paramSightCaptureResult.iZt = str;
          paramSightCaptureResult.iXp = 1;
          paramSightCaptureResult.jdS = null;
          paramSightCaptureResult.dQd = 0;
          paramSightCaptureResult.iXy = "";
          paramSightCaptureResult.thumbPath = "";
          paramSightCaptureResult.jdV = true;
          paramSightCaptureResult.jdU = 2131231628;
          paramSightCaptureResult.jdR = 11;
          paramSightCaptureResult = (n)paramSightCaptureResult.bdQ().jdJ;
          if (((b)com.tencent.mm.kernel.g.af(b.class)).a(b.a.rZj, true))
          {
            com.tencent.mm.plugin.recordvideo.e.c localc = com.tencent.mm.plugin.recordvideo.e.c.Cic;
            com.tencent.mm.plugin.recordvideo.e.c.jD(String.valueOf(paramSightCaptureResult.bcD().field_msgId), str);
          }
          bg.azz().a(paramSightCaptureResult, 0);
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
    paramMenuItem = br.N(paramca);
    if ((Util.isNullOrNil(paramMenuItem)) || (paramca.field_isSend == 1)) {
      cf(paramca);
    }
    for (;;)
    {
      if (br.D(paramca))
      {
        paramMenuItem = new jc();
        paramMenuItem.emN = paramca.field_msgSvrId;
        paramMenuItem.eLn = paramca.getType();
        paramMenuItem.eQu = br.C(paramca);
        paramMenuItem.ejA = 4L;
        paramMenuItem.bfK();
      }
      AppMethodBeat.o(35566);
      return true;
      com.tencent.mm.plugin.report.service.h.CyF.a(17509, new Object[] { Integer.valueOf(3), paramMenuItem });
      com.tencent.mm.ui.base.h.a(this.dom.Pwc.getContext(), 2131765108, 2131765109, 2131756020, 2131757502, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(35559);
          paramAnonymousDialogInterface = new Intent();
          paramAnonymousDialogInterface.putExtra("rawUrl", paramMenuItem);
          paramAnonymousDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
          paramAnonymousDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
          com.tencent.mm.br.c.b(ax.this.dom.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousDialogInterface);
          com.tencent.mm.plugin.report.service.h.CyF.a(17509, new Object[] { Integer.valueOf(1), paramMenuItem });
          AppMethodBeat.o(35559);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(35560);
          ax.a(ax.this, paramca);
          com.tencent.mm.plugin.report.service.h.CyF.a(17509, new Object[] { Integer.valueOf(2), paramMenuItem });
          AppMethodBeat.o(35560);
        }
      });
    }
  }
  
  public final boolean bU(ca paramca)
  {
    AppMethodBeat.i(35570);
    if (!paramca.gAz())
    {
      AppMethodBeat.o(35570);
      return false;
    }
    bg.aVF();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      com.tencent.mm.ui.base.u.g(this.dom.Pwc.getContext(), this.dom.Pwc.getContentView());
      AppMethodBeat.o(35570);
      return true;
    }
    if (!this.dom.getTalkerUserName().equals("medianote"))
    {
      bg.aVF();
      com.tencent.mm.model.c.aSM().d(new f(paramca.field_talker, paramca.field_msgSvrId));
    }
    ak.bH(paramca);
    this.dom.BN(true);
    AppMethodBeat.o(35570);
    return true;
  }
  
  public final void gIm()
  {
    AppMethodBeat.i(35577);
    q.bcP().iYF = this;
    AppMethodBeat.o(35577);
  }
  
  public final void gIn()
  {
    AppMethodBeat.i(35578);
    q.bcP().iYF = null;
    AppMethodBeat.o(35578);
  }
  
  public final void gOK()
  {
    AppMethodBeat.i(35579);
    super.gOK();
    q.bcP().iYF = null;
    AppMethodBeat.o(35579);
  }
  
  public final boolean i(final int paramInt1, int paramInt2, final Intent paramIntent)
  {
    int i = 1;
    AppMethodBeat.i(35567);
    this.dom.dismissDialog();
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
      ((Intent)localObject1).setClassName(this.dom.Pwc.getContext(), "com.tencent.mm.ui.tools.CropImageNewUI");
      ((Intent)localObject1).putExtra("CropImageMode", 4);
      ((Intent)localObject1).putExtra("CropImage_Filter", true);
      localObject2 = this.dom.getTalkerUserName();
      if ((localObject2 != null) && ((as.bjm((String)localObject2)) || (as.bjo((String)localObject2))))
      {
        bool = false;
        ((Intent)localObject1).putExtra("CropImage_Has_Raw_Img_Btn", bool);
        ((Intent)localObject1).putExtra("from_source", 3);
        localObject2 = this.dom.Pwc;
        bg.aVF();
        localObject3 = com.tencent.mm.model.c.aSY();
        if (paramIntent.getData().toString().startsWith("content://com.google.android.gallery3d")) {
          break label301;
        }
        paramIntent = com.tencent.mm.ui.tools.a.i(((MMFragment)localObject2).getContext(), paramIntent, (String)localObject3);
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
        new a.1(paramIntent, (MMFragment)localObject2, (String)localObject3, (Intent)localObject1).execute(new Integer[] { Integer.valueOf(0) });
      }
    case 201: 
      localObject1 = this.dom.Pwc.getContext().getApplicationContext();
      bg.aVF();
      paramIntent = com.tencent.mm.pluginsdk.ui.tools.s.h((Context)localObject1, paramIntent, com.tencent.mm.model.c.aSY());
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
      ((Intent)localObject1).putExtra("GalleryUI_FromUser", this.dom.gRI());
      ((Intent)localObject1).putExtra("GalleryUI_ToUser", this.dom.getTalkerUserName());
      ((Intent)localObject1).putExtra("is_long_click", true);
      ((Intent)localObject1).putStringArrayListExtra("preview_image_list", (ArrayList)localObject2);
      ((Intent)localObject1).addFlags(67108864);
      com.tencent.mm.br.c.a(this.dom.Pwc, "gallery", ".ui.GalleryEntryUI", (Intent)localObject1, 217);
      AppMethodBeat.o(35567);
      return true;
    case 217: 
      label301:
      if (paramIntent == null)
      {
        localObject1 = p.bcF().OJ(this.dom.getTalkerUserName());
        if (((ArrayList)localObject1).size() > 0)
        {
          paramIntent = new Intent();
          paramIntent.putStringArrayListExtra("CropImage_OutputPath_List", (ArrayList)localObject1);
          localObject1 = new ArrayList();
          ((ArrayList)localObject1).add(Integer.valueOf(-1));
          paramIntent.putIntegerArrayListExtra("GalleryUI_ImgIdList", (ArrayList)localObject1);
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(594L, 4L, 1L, true);
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
      for (localObject1 = this.dom.getTalkerUserName();; localObject1 = localObject2)
      {
        Log.i("MicroMsg.ChattingUI.SendImgComponent", "CONTEXT_MENU_WECHAT_GALLERY_IMAGE userFromIntent:%s rawUsername:%s", new Object[] { localObject2, this.dom.getTalkerUserName() });
        localObject2 = (com.tencent.mm.ui.chatting.d.b.u)this.dom.bh(com.tencent.mm.ui.chatting.d.b.u.class);
        ((com.tencent.mm.ui.chatting.d.b.u)localObject2).gPO().clearFocus();
        ((com.tencent.mm.ui.chatting.d.b.u)localObject2).gPO().setBottomPanelVisibility(8);
        localObject3 = (DrawnCallBackLinearLayout)this.dom.findViewById(2131298408);
        if (localObject3 == null) {
          break;
        }
        ((DrawnCallBackLinearLayout)localObject3).setListener(new DrawnCallBackLinearLayout.a()
        {
          public final void gRe()
          {
            AppMethodBeat.i(35562);
            bg.aAk().postToWorkerDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(35561);
                bg.aAk().setHighPriority();
                ax.a(ax.this, ax.3.this.val$data, ax.3.this.PtK);
                ((av)ax.this.dom.bh(av.class)).bE(ax.3.this.val$data);
                if (ax.3.this.PtL.gPP() != null) {
                  ax.3.this.PtL.gPP().s(ax.3.this.val$requestCode, ax.3.this.val$data);
                }
                bg.aAk().setLowPriority();
                AppMethodBeat.o(35561);
              }
            }, 100L);
            AppMethodBeat.o(35562);
          }
        });
        break;
      }
      localObject1 = (com.tencent.mm.ui.chatting.d.b.u)this.dom.bh(com.tencent.mm.ui.chatting.d.b.u.class);
      localObject2 = paramIntent.getStringExtra("CropImage_OutputPath");
      if (localObject2 == null)
      {
        ((com.tencent.mm.ui.chatting.d.b.u)localObject1).gPO().clearFocus();
        AppMethodBeat.o(35567);
        return true;
      }
      bool = paramIntent.getBooleanExtra("CropImage_Compress_Img", true);
      bool = z.f((String)localObject2, this.dom.getTalkerUserName(), bool);
      paramIntent.getIntExtra("from_source", 0);
      paramInt2 = paramIntent.getIntExtra("CropImage_rotateCount", 0);
      Log.d("MicroMsg.ChattingUI.SendImgComponent", "dkimgsource" + paramIntent.getIntExtra("from_source", 0));
      if (bool) {}
      for (paramInt1 = i;; paramInt1 = 0)
      {
        T(paramInt1, paramInt2, (String)localObject2);
        ((com.tencent.mm.ui.chatting.d.b.u)localObject1).gPO().clearFocus();
        break;
      }
    }
  }
  
  public final void j(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(35574);
    com.tencent.mm.plugin.recordvideo.e.c localc = com.tencent.mm.plugin.recordvideo.e.c.Cic;
    com.tencent.mm.plugin.recordvideo.e.c.aLD(String.valueOf(paramLong));
    ((k)this.dom.bh(k.class)).Q(paramLong, paramBoolean);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.ax
 * JD-Core Version:    0.7.0.1
 */