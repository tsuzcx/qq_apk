package com.tencent.mm.ui.chatting.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.Settings.Secure;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.widget.ImageView;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.p;
import com.tencent.mm.as.i.a;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.am;
import com.tencent.mm.ui.chatting.b.b.z;
import com.tencent.mm.ui.tools.a.1;
import com.tencent.mm.ui.widget.DrawnCallBackLinearLayout;
import com.tencent.mm.ui.x;
import java.util.ArrayList;

@com.tencent.mm.ui.chatting.b.a.a(cFA=z.class)
public class ag
  extends a
  implements i.a, z
{
  private com.tencent.mm.ui.widget.a.c mbF;
  
  public final void B(final String paramString1, int paramInt, String paramString2)
  {
    if (((this.mbF == null) || (!this.mbF.isShowing())) && (!bk.bl(paramString2)) && (com.tencent.mm.sdk.platformtools.o.YY(paramString2)))
    {
      localObject = com.tencent.mm.sdk.platformtools.c.e(paramString2, 300, 300, false);
      if (localObject == null) {
        y.e("MicroMsg.ChattingUI.SendImgComponent", "showAlert fail, bmp is null");
      }
    }
    else
    {
      return;
    }
    final com.tencent.mm.ui.chatting.b.b.n localn = (com.tencent.mm.ui.chatting.b.b.n)this.byx.ac(com.tencent.mm.ui.chatting.b.b.n.class);
    ImageView localImageView = new ImageView(this.byx.vtz.getContext());
    int i = this.byx.vtz.getMMResources().getDimensionPixelSize(R.f.LargePadding);
    localImageView.setImageBitmap((Bitmap)localObject);
    localImageView.setPadding(i, i, i, i);
    Object localObject = Settings.Secure.getString(this.byx.vtz.getContentResolver(), "default_input_method");
    if ((com.tencent.mm.sdk.platformtools.o.bx(com.tencent.mm.vfs.e.c(paramString2, 0, -1))) && ((((String)localObject).contains("com.sohu.inputmethod.sogou")) || (((String)localObject).contains("com.tencent.qqpinyin")))) {}
    for (boolean bool = true;; bool = false)
    {
      this.mbF = com.tencent.mm.ui.base.h.a(this.byx.vtz.getContext(), this.byx.vtz.getMMResources().getString(R.l.chatting_send_img_confirm), localImageView, this.byx.vtz.getMMResources().getString(R.l.app_ok), this.byx.vtz.getMMResources().getString(R.l.app_cancel), new ag.3(this, bool, localn, paramString2), null);
      paramString1 = paramString1.substring(0, paramInt);
      localn.cEq().postDelayed(new Runnable()
      {
        public final void run()
        {
          localn.cEq().r(paramString1, -1, false);
        }
      }, 10L);
      return;
    }
  }
  
  public final void a(ContextMenu paramContextMenu, int paramInt, bi parambi)
  {
    paramContextMenu.add(paramInt, 100, 0, this.byx.vtz.getMMResources().getString(R.l.chatting_long_click_menu_delete_img));
    com.tencent.mm.as.e locale1 = null;
    if (parambi.field_msgId > 0L) {
      locale1 = com.tencent.mm.as.o.OJ().bY(parambi.field_msgId);
    }
    com.tencent.mm.as.e locale2;
    if (locale1 != null)
    {
      locale2 = locale1;
      if (locale1.enp > 0L) {}
    }
    else
    {
      locale2 = locale1;
      if (parambi.field_msgSvrId > 0L) {
        locale2 = com.tencent.mm.as.o.OJ().bX(parambi.field_msgSvrId);
      }
    }
    if ((parambi.field_isSend == 1) || ((locale2 != null) && (parambi.field_isSend == 0) && (locale2.offset >= locale2.ebK) && (locale2.ebK != 0))) {
      paramContextMenu.add(paramInt, 110, 0, this.byx.vtz.getMMResources().getString(R.l.retransmit));
    }
    if (locale2 == null) {}
    for (parambi = "";; parambi = com.tencent.mm.as.o.OJ().o(locale2.enq, "", ""))
    {
      if ((locale2 != null) && (com.tencent.mm.vfs.e.bK(parambi))) {
        paramContextMenu.add(paramInt, 112, 0, this.byx.vtz.getMMResources().getString(R.l.chatting_copy));
      }
      return;
    }
  }
  
  public final void a(SightCaptureResult paramSightCaptureResult)
  {
    String str = paramSightCaptureResult.mfp;
    if (!bk.bl(str)) {}
    try
    {
      boolean bool = paramSightCaptureResult.mfi;
      y.i("MicroMsg.ChattingUI.SendImgComponent", "doSendChattingImage, path: %s", new Object[] { str });
      if (bool) {}
      for (int i = 2;; i = 1)
      {
        paramSightCaptureResult = new com.tencent.mm.as.l(i, q.Gj(), this.byx.getTalkerUserName(), str, 0, null, 0, "", "", true, R.g.chat_img_template);
        au.Dk().a(paramSightCaptureResult, 0);
        return;
      }
      return;
    }
    catch (Exception paramSightCaptureResult)
    {
      y.e("MicroMsg.ChattingUI.SendImgComponent", "doSendChattingImage error: %s", new Object[] { paramSightCaptureResult.getMessage() });
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, bi parambi)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return false;
    }
    com.tencent.mm.ui.chatting.s.a(parambi, this.byx.vtz.getContext(), this.byx);
    return true;
  }
  
  public final boolean aR(bi parambi)
  {
    if (!parambi.ctB()) {
      return false;
    }
    au.Hx();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      com.tencent.mm.ui.base.s.gM(this.byx.vtz.getContext());
      return true;
    }
    if (!this.byx.getTalkerUserName().equals("medianote"))
    {
      au.Hx();
      com.tencent.mm.model.c.Fv().b(new com.tencent.mm.ay.d(parambi.field_talker, parambi.field_msgSvrId));
    }
    am.aI(parambi);
    this.byx.cCW();
    return true;
  }
  
  public final void b(long paramLong, int paramInt1, int paramInt2)
  {
    ((com.tencent.mm.ui.chatting.b.b.g)this.byx.ac(com.tencent.mm.ui.chatting.b.b.g.class)).j(paramLong, paramInt1, paramInt2);
  }
  
  public final void cyO()
  {
    com.tencent.mm.as.o.OH().eoD = this;
  }
  
  public final void cyR()
  {
    com.tencent.mm.as.o.OH().eoD = null;
  }
  
  public final boolean g(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 1;
    boolean bool2 = true;
    this.byx.dismissDialog();
    boolean bool1;
    if (paramInt2 != -1)
    {
      y.e("MicroMsg.ChattingUI.SendImgComponent", "[dealWithRequestCode] resultCode:%d", new Object[] { Integer.valueOf(paramInt2) });
      bool1 = false;
    }
    Object localObject3;
    label285:
    do
    {
      do
      {
        return bool1;
        switch (paramInt1)
        {
        default: 
          return false;
        case 200: 
          bool1 = bool2;
        }
      } while (paramIntent == null);
      localObject1 = new Intent();
      ((Intent)localObject1).setClassName(this.byx.vtz.getContext(), "com.tencent.mm.ui.tools.CropImageNewUI");
      ((Intent)localObject1).putExtra("CropImageMode", 4);
      ((Intent)localObject1).putExtra("CropImage_Filter", true);
      localObject2 = this.byx.getTalkerUserName();
      if ((localObject2 != null) && ((ad.aaR((String)localObject2)) || (ad.aaT((String)localObject2)))) {}
      for (bool1 = false;; bool1 = true)
      {
        ((Intent)localObject1).putExtra("CropImage_Has_Raw_Img_Btn", bool1);
        ((Intent)localObject1).putExtra("from_source", 3);
        localObject2 = this.byx.vtz;
        au.Hx();
        localObject3 = com.tencent.mm.model.c.FG();
        if (paramIntent.getData().toString().startsWith("content://com.google.android.gallery3d")) {
          break label285;
        }
        paramIntent = com.tencent.mm.ui.tools.a.g(((x)localObject2).getContext(), paramIntent, (String)localObject3);
        bool1 = bool2;
        if (bk.bl(paramIntent)) {
          break;
        }
        ((Intent)localObject1).putExtra("CropImage_ImgPath", paramIntent);
        ((x)localObject2).startActivityForResult((Intent)localObject1, 203);
        return true;
      }
      new a.1(paramIntent, (x)localObject2, (String)localObject3, (Intent)localObject1).execute(new Integer[] { Integer.valueOf(0) });
      return true;
      localObject1 = this.byx.vtz.getContext().getApplicationContext();
      au.Hx();
      paramIntent = com.tencent.mm.pluginsdk.ui.tools.l.f((Context)localObject1, paramIntent, com.tencent.mm.model.c.FG());
      bool1 = bool2;
    } while (paramIntent == null);
    Object localObject1 = new Intent();
    Object localObject2 = new ArrayList(1);
    ((ArrayList)localObject2).add(paramIntent);
    ((Intent)localObject1).putExtra("query_source_type", 3);
    ((Intent)localObject1).putExtra("preview_image", true);
    ((Intent)localObject1).putExtra("isTakePhoto", true);
    ((Intent)localObject1).putExtra("GalleryUI_FromUser", this.byx.cFB());
    ((Intent)localObject1).putExtra("GalleryUI_ToUser", this.byx.getTalkerUserName());
    ((Intent)localObject1).putExtra("is_long_click", true);
    ((Intent)localObject1).putStringArrayListExtra("preview_image_list", (ArrayList)localObject2);
    ((Intent)localObject1).addFlags(67108864);
    com.tencent.mm.br.d.a(this.byx.vtz, "gallery", ".ui.GalleryEntryUI", (Intent)localObject1, 217);
    return true;
    if (paramIntent == null)
    {
      localObject1 = com.tencent.mm.as.n.OA().mg(this.byx.getTalkerUserName());
      if (((ArrayList)localObject1).size() > 0)
      {
        paramIntent = new Intent();
        paramIntent.putStringArrayListExtra("CropImage_OutputPath_List", (ArrayList)localObject1);
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).add(Integer.valueOf(-1));
        paramIntent.putIntegerArrayListExtra("GalleryUI_ImgIdList", (ArrayList)localObject1);
        com.tencent.mm.plugin.report.service.h.nFQ.a(594L, 4L, 1L, true);
      }
    }
    for (;;)
    {
      if (paramIntent == null)
      {
        y.e("MicroMsg.ChattingUI.SendImgComponent", "CONTEXT_MENU_WECHAT_GALLERY_IMAGE intent == null");
        return true;
      }
      localObject2 = paramIntent.getStringExtra("GalleryUI_ToUser");
      if (bk.bl((String)localObject2)) {}
      for (localObject1 = this.byx.getTalkerUserName();; localObject1 = localObject2)
      {
        y.i("MicroMsg.ChattingUI.SendImgComponent", "CONTEXT_MENU_WECHAT_GALLERY_IMAGE userFromIntent:%s rawUsername:%s", new Object[] { localObject2, this.byx.getTalkerUserName() });
        localObject2 = (com.tencent.mm.ui.chatting.b.b.n)this.byx.ac(com.tencent.mm.ui.chatting.b.b.n.class);
        ((com.tencent.mm.ui.chatting.b.b.n)localObject2).cEq().clearFocus();
        ((com.tencent.mm.ui.chatting.b.b.n)localObject2).cEq().setBottomPanelVisibility(8);
        localObject3 = (DrawnCallBackLinearLayout)this.byx.findViewById(R.h.chatting_bg_ll);
        if (localObject3 == null) {
          break;
        }
        ((DrawnCallBackLinearLayout)localObject3).setListener(new ag.1(this, paramIntent, (String)localObject1, (com.tencent.mm.ui.chatting.b.b.n)localObject2, paramInt1));
        break;
      }
      localObject1 = (com.tencent.mm.ui.chatting.b.b.n)this.byx.ac(com.tencent.mm.ui.chatting.b.b.n.class);
      localObject2 = paramIntent.getStringExtra("CropImage_OutputPath");
      if (localObject2 == null)
      {
        ((com.tencent.mm.ui.chatting.b.b.n)localObject1).cEq().clearFocus();
        return true;
      }
      bool1 = paramIntent.getBooleanExtra("CropImage_Compress_Img", true);
      bool1 = q.g((String)localObject2, this.byx.getTalkerUserName(), bool1);
      paramIntent.getIntExtra("from_source", 0);
      paramInt2 = paramIntent.getIntExtra("CropImage_rotateCount", 0);
      y.d("MicroMsg.ChattingUI.SendImgComponent", "dkimgsource" + paramIntent.getIntExtra("from_source", 0));
      if (bool1) {}
      for (paramInt1 = i;; paramInt1 = 0)
      {
        x(paramInt1, paramInt2, (String)localObject2);
        ((com.tencent.mm.ui.chatting.b.b.n)localObject1).cEq().clearFocus();
        break;
      }
    }
  }
  
  public final void h(long paramLong, boolean paramBoolean)
  {
    ((com.tencent.mm.ui.chatting.b.b.g)this.byx.ac(com.tencent.mm.ui.chatting.b.b.g.class)).v(paramLong, paramBoolean);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    g(paramInt1, paramInt2, paramIntent);
  }
  
  public final void x(int paramInt1, int paramInt2, String paramString)
  {
    if ((paramString == null) || (paramString.equals("")) || (!com.tencent.mm.vfs.e.bK(paramString))) {
      y.d("MicroMsg.ChattingUI.SendImgComponent", " doSendImage : filePath is null or empty");
    }
    while (i.Z(this.byx.pSb)) {
      return;
    }
    paramString = new com.tencent.mm.as.l(4, this.byx.cFB(), this.byx.getTalkerUserName(), paramString, paramInt1, null, paramInt2, "", "", true, R.g.chat_img_template);
    au.Dk().a(paramString, 0);
    this.byx.cCW();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.ag
 * JD-Core Version:    0.7.0.1
 */