package com.tencent.mm.ui.chatting.c;

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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.at.g;
import com.tencent.mm.at.i.a;
import com.tencent.mm.at.l;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.aj;
import com.tencent.mm.ui.chatting.c.b.aa;
import com.tencent.mm.ui.tools.a.1;
import com.tencent.mm.ui.widget.DrawnCallBackLinearLayout;
import java.util.ArrayList;

@com.tencent.mm.ui.chatting.c.a.a(dJy=aa.class)
public class ah
  extends a
  implements i.a, aa
{
  private com.tencent.mm.ui.widget.b.c oCg;
  
  public final void E(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(31670);
    if ((paramString == null) || (paramString.equals("")) || (!com.tencent.mm.vfs.e.cN(paramString)))
    {
      ab.d("MicroMsg.ChattingUI.SendImgComponent", " doSendImage : filePath is null or empty");
      AppMethodBeat.o(31670);
      return;
    }
    if (i.ac(this.caz.txj))
    {
      AppMethodBeat.o(31670);
      return;
    }
    paramString = new l(4, this.caz.dJD(), this.caz.getTalkerUserName(), paramString, paramInt1, null, paramInt2, "", "", true, 2130838228);
    aw.Rc().a(paramString, 0);
    this.caz.qT(true);
    AppMethodBeat.o(31670);
  }
  
  public final void a(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(31673);
    ((com.tencent.mm.ui.chatting.c.b.h)this.caz.ay(com.tencent.mm.ui.chatting.c.b.h.class)).o(paramLong, paramInt1, paramInt2);
    AppMethodBeat.o(31673);
  }
  
  public final void a(ContextMenu paramContextMenu, int paramInt, bi parambi)
  {
    AppMethodBeat.i(31672);
    paramContextMenu.add(paramInt, 100, 0, this.caz.zJz.getMMResources().getString(2131298231));
    com.tencent.mm.at.e locale1 = null;
    if (parambi.field_msgId > 0L) {
      locale1 = com.tencent.mm.at.o.ahC().gT(parambi.field_msgId);
    }
    com.tencent.mm.at.e locale2;
    if (locale1 != null)
    {
      locale2 = locale1;
      if (locale1.fDL > 0L) {}
    }
    else
    {
      locale2 = locale1;
      if (parambi.field_msgSvrId > 0L) {
        locale2 = com.tencent.mm.at.o.ahC().gS(parambi.field_msgSvrId);
      }
    }
    if ((parambi.field_isSend == 1) || ((locale2 != null) && (parambi.field_isSend == 0) && (locale2.offset >= locale2.fsd) && (locale2.fsd != 0))) {
      paramContextMenu.add(paramInt, 110, 0, this.caz.zJz.getMMResources().getString(2131302650));
    }
    if (locale2 == null) {}
    for (parambi = "";; parambi = com.tencent.mm.at.o.ahC().q(locale2.fDM, "", ""))
    {
      if ((locale2 != null) && (com.tencent.mm.vfs.e.cN(parambi))) {
        paramContextMenu.add(paramInt, 112, 0, this.caz.zJz.getMMResources().getString(2131298161));
      }
      AppMethodBeat.o(31672);
      return;
    }
  }
  
  public final void a(SightCaptureResult paramSightCaptureResult)
  {
    AppMethodBeat.i(31669);
    String str = paramSightCaptureResult.oFO;
    if (!bo.isNullOrNil(str)) {
      try
      {
        boolean bool = paramSightCaptureResult.oFH;
        ab.i("MicroMsg.ChattingUI.SendImgComponent", "doSendChattingImage, path: %s", new Object[] { str });
        if (bool) {}
        for (int i = 2;; i = 1)
        {
          paramSightCaptureResult = new l(i, com.tencent.mm.model.r.Zn(), this.caz.getTalkerUserName(), str, 1, null, 0, "", "", true, 2130838228);
          aw.Rc().a(paramSightCaptureResult, 0);
          AppMethodBeat.o(31669);
          return;
        }
        AppMethodBeat.o(31669);
      }
      catch (Exception paramSightCaptureResult)
      {
        ab.e("MicroMsg.ChattingUI.SendImgComponent", "doSendChattingImage error: %s", new Object[] { paramSightCaptureResult.getMessage() });
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, bi parambi)
  {
    AppMethodBeat.i(31667);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(31667);
      return false;
    }
    com.tencent.mm.ui.chatting.r.a(parambi, this.caz.zJz.getContext(), this.caz);
    AppMethodBeat.o(31667);
    return true;
  }
  
  public final boolean bc(bi parambi)
  {
    AppMethodBeat.i(31671);
    if (!parambi.dvX())
    {
      AppMethodBeat.o(31671);
      return false;
    }
    aw.aaz();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      t.ii(this.caz.zJz.getContext());
      AppMethodBeat.o(31671);
      return true;
    }
    if (!this.caz.getTalkerUserName().equals("medianote"))
    {
      aw.aaz();
      com.tencent.mm.model.c.Yz().c(new com.tencent.mm.az.e(parambi.field_talker, parambi.field_msgSvrId));
    }
    aj.aS(parambi);
    this.caz.qT(true);
    AppMethodBeat.o(31671);
    return true;
  }
  
  public final void dCa()
  {
    AppMethodBeat.i(31677);
    com.tencent.mm.at.o.ahA().fFa = this;
    AppMethodBeat.o(31677);
  }
  
  public final void dCd()
  {
    AppMethodBeat.i(31678);
    com.tencent.mm.at.o.ahA().fFa = null;
    AppMethodBeat.o(31678);
  }
  
  public final void dHq()
  {
    AppMethodBeat.i(31679);
    super.dHq();
    com.tencent.mm.at.o.ahA().fFa = null;
    AppMethodBeat.o(31679);
  }
  
  public final boolean g(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 1;
    AppMethodBeat.i(31668);
    this.caz.dismissDialog();
    if (paramInt2 != -1)
    {
      ab.e("MicroMsg.ChattingUI.SendImgComponent", "[dealWithRequestCode] resultCode:%d", new Object[] { Integer.valueOf(paramInt2) });
      AppMethodBeat.o(31668);
      return false;
    }
    Object localObject1;
    Object localObject2;
    boolean bool;
    Object localObject3;
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(31668);
      return false;
    case 200: 
      if (paramIntent == null)
      {
        AppMethodBeat.o(31668);
        return true;
      }
      localObject1 = new Intent();
      ((Intent)localObject1).setClassName(this.caz.zJz.getContext(), "com.tencent.mm.ui.tools.CropImageNewUI");
      ((Intent)localObject1).putExtra("CropImageMode", 4);
      ((Intent)localObject1).putExtra("CropImage_Filter", true);
      localObject2 = this.caz.getTalkerUserName();
      if ((localObject2 != null) && ((ad.arc((String)localObject2)) || (ad.are((String)localObject2))))
      {
        bool = false;
        ((Intent)localObject1).putExtra("CropImage_Has_Raw_Img_Btn", bool);
        ((Intent)localObject1).putExtra("from_source", 3);
        localObject2 = this.caz.zJz;
        aw.aaz();
        localObject3 = com.tencent.mm.model.c.YK();
        if (paramIntent.getData().toString().startsWith("content://com.google.android.gallery3d")) {
          break label301;
        }
        paramIntent = com.tencent.mm.ui.tools.a.i(((MMFragment)localObject2).getContext(), paramIntent, (String)localObject3);
        if (!bo.isNullOrNil(paramIntent))
        {
          ((Intent)localObject1).putExtra("CropImage_ImgPath", paramIntent);
          ((MMFragment)localObject2).startActivityForResult((Intent)localObject1, 203);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(31668);
        return true;
        bool = true;
        break;
        new a.1(paramIntent, (MMFragment)localObject2, (String)localObject3, (Intent)localObject1).execute(new Integer[] { Integer.valueOf(0) });
      }
    case 201: 
      localObject1 = this.caz.zJz.getContext().getApplicationContext();
      aw.aaz();
      paramIntent = com.tencent.mm.pluginsdk.ui.tools.n.h((Context)localObject1, paramIntent, com.tencent.mm.model.c.YK());
      if (paramIntent == null)
      {
        AppMethodBeat.o(31668);
        return true;
      }
      localObject1 = new Intent();
      localObject2 = new ArrayList(1);
      ((ArrayList)localObject2).add(paramIntent);
      ((Intent)localObject1).putExtra("query_source_type", 3);
      ((Intent)localObject1).putExtra("preview_image", true);
      ((Intent)localObject1).putExtra("isTakePhoto", true);
      ((Intent)localObject1).putExtra("GalleryUI_FromUser", this.caz.dJD());
      ((Intent)localObject1).putExtra("GalleryUI_ToUser", this.caz.getTalkerUserName());
      ((Intent)localObject1).putExtra("is_long_click", true);
      ((Intent)localObject1).putStringArrayListExtra("preview_image_list", (ArrayList)localObject2);
      ((Intent)localObject1).addFlags(67108864);
      com.tencent.mm.bq.d.a(this.caz.zJz, "gallery", ".ui.GalleryEntryUI", (Intent)localObject1, 217);
      AppMethodBeat.o(31668);
      return true;
    case 217: 
      label301:
      if (paramIntent == null)
      {
        localObject1 = com.tencent.mm.at.n.ahs().tl(this.caz.getTalkerUserName());
        if (((ArrayList)localObject1).size() > 0)
        {
          paramIntent = new Intent();
          paramIntent.putStringArrayListExtra("CropImage_OutputPath_List", (ArrayList)localObject1);
          localObject1 = new ArrayList();
          ((ArrayList)localObject1).add(Integer.valueOf(-1));
          paramIntent.putIntegerArrayListExtra("GalleryUI_ImgIdList", (ArrayList)localObject1);
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(594L, 4L, 1L, true);
        }
      }
      break;
    }
    for (;;)
    {
      if (paramIntent == null)
      {
        ab.e("MicroMsg.ChattingUI.SendImgComponent", "CONTEXT_MENU_WECHAT_GALLERY_IMAGE intent == null");
        AppMethodBeat.o(31668);
        return true;
      }
      localObject2 = paramIntent.getStringExtra("GalleryUI_ToUser");
      if (bo.isNullOrNil((String)localObject2)) {}
      for (localObject1 = this.caz.getTalkerUserName();; localObject1 = localObject2)
      {
        ab.i("MicroMsg.ChattingUI.SendImgComponent", "CONTEXT_MENU_WECHAT_GALLERY_IMAGE userFromIntent:%s rawUsername:%s", new Object[] { localObject2, this.caz.getTalkerUserName() });
        localObject2 = (com.tencent.mm.ui.chatting.c.b.o)this.caz.ay(com.tencent.mm.ui.chatting.c.b.o.class);
        ((com.tencent.mm.ui.chatting.c.b.o)localObject2).dIg().clearFocus();
        ((com.tencent.mm.ui.chatting.c.b.o)localObject2).dIg().setBottomPanelVisibility(8);
        localObject3 = (DrawnCallBackLinearLayout)this.caz.findViewById(2131821559);
        if (localObject3 == null) {
          break;
        }
        ((DrawnCallBackLinearLayout)localObject3).setListener(new ah.1(this, paramIntent, (String)localObject1, (com.tencent.mm.ui.chatting.c.b.o)localObject2, paramInt1));
        break;
      }
      localObject1 = (com.tencent.mm.ui.chatting.c.b.o)this.caz.ay(com.tencent.mm.ui.chatting.c.b.o.class);
      localObject2 = paramIntent.getStringExtra("CropImage_OutputPath");
      if (localObject2 == null)
      {
        ((com.tencent.mm.ui.chatting.c.b.o)localObject1).dIg().clearFocus();
        AppMethodBeat.o(31668);
        return true;
      }
      bool = paramIntent.getBooleanExtra("CropImage_Compress_Img", true);
      bool = com.tencent.mm.model.r.g((String)localObject2, this.caz.getTalkerUserName(), bool);
      paramIntent.getIntExtra("from_source", 0);
      paramInt2 = paramIntent.getIntExtra("CropImage_rotateCount", 0);
      ab.d("MicroMsg.ChattingUI.SendImgComponent", "dkimgsource" + paramIntent.getIntExtra("from_source", 0));
      if (bool) {}
      for (paramInt1 = i;; paramInt1 = 0)
      {
        E(paramInt1, paramInt2, (String)localObject2);
        ((com.tencent.mm.ui.chatting.c.b.o)localObject1).dIg().clearFocus();
        break;
      }
    }
  }
  
  public final void k(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(31674);
    ((com.tencent.mm.ui.chatting.c.b.h)this.caz.ay(com.tencent.mm.ui.chatting.c.b.h.class)).C(paramLong, paramBoolean);
    AppMethodBeat.o(31674);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(31676);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    g(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(31676);
  }
  
  public final void z(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(31675);
    Object localObject;
    com.tencent.mm.ui.chatting.c.b.o localo;
    ImageView localImageView;
    boolean bool;
    if (((this.oCg == null) || (!this.oCg.isShowing())) && (!bo.isNullOrNil(paramString2)) && (com.tencent.mm.sdk.platformtools.r.aoX(paramString2)))
    {
      localObject = com.tencent.mm.sdk.platformtools.d.d(paramString2, 300, 300, false);
      if (localObject == null)
      {
        ab.e("MicroMsg.ChattingUI.SendImgComponent", "showAlert fail, bmp is null");
        AppMethodBeat.o(31675);
        return;
      }
      localo = (com.tencent.mm.ui.chatting.c.b.o)this.caz.ay(com.tencent.mm.ui.chatting.c.b.o.class);
      localImageView = new ImageView(this.caz.zJz.getContext());
      int i = this.caz.zJz.getMMResources().getDimensionPixelSize(2131427772);
      localImageView.setImageBitmap((Bitmap)localObject);
      localImageView.setPadding(i, i, i, i);
      localObject = Settings.Secure.getString(this.caz.zJz.getContentResolver(), "default_input_method");
      if ((!com.tencent.mm.sdk.platformtools.r.bV(com.tencent.mm.vfs.e.i(paramString2, 0, -1))) || ((!((String)localObject).contains("com.sohu.inputmethod.sogou")) && (!((String)localObject).contains("com.tencent.qqpinyin")))) {
        break label344;
      }
      bool = true;
      if (bool)
      {
        if (!((String)localObject).contains("com.sohu.inputmethod.sogou")) {
          break label350;
        }
        com.tencent.mm.plugin.report.service.h.qsU.cT(1062, 1);
      }
    }
    for (;;)
    {
      this.oCg = com.tencent.mm.ui.base.h.a(this.caz.zJz.getContext(), this.caz.zJz.getMMResources().getString(2131298319), localImageView, this.caz.zJz.getMMResources().getString(2131297018), this.caz.zJz.getMMResources().getString(2131296888), new ah.3(this, bool, localo, (String)localObject, paramString2), null);
      paramString1 = paramString1.substring(0, paramInt);
      localo.dIg().postDelayed(new ah.4(this, localo, paramString1), 10L);
      AppMethodBeat.o(31675);
      return;
      label344:
      bool = false;
      break;
      label350:
      if (((String)localObject).contains("com.tencent.qqpinyin")) {
        com.tencent.mm.plugin.report.service.h.qsU.cT(1062, 2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.ah
 * JD-Core Version:    0.7.0.1
 */