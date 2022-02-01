package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.k.f;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.plugin.report.service.l;
import com.tencent.mm.plugin.textstatus.a.w.a;
import com.tencent.mm.pluginsdk.l.e;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.protocal.protobuf.abm;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/tools/ShareToStatusUI;", "Lcom/tencent/mm/pluginsdk/ui/AutoLoginActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "mFileType", "", "mProgressDialog", "Landroid/app/ProgressDialog;", "mUri", "Landroid/net/Uri;", "checkShareFilePathAvailable", "", "filePath", "", "deal", "", "checkSysShare", "dealError", "errType", "dealNotLogin", "doCheckSysScene", "fileType", "doLaunch", "uri", "getFilePath", "getFileType", "mimeType", "hideDialog", "onDestroy", "onRequestPermissionsResult", "requestCode", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onSceneEnd", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "postLogin", "loginResult", "Lcom/tencent/mm/pluginsdk/ui/AutoLoginActivity$LoginResult;", "intent", "Landroid/content/Intent;", "preLogin", "shareToStatus", "path", "type", "showDialog", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ShareToStatusUI
  extends AutoLoginActivity
  implements com.tencent.mm.am.h
{
  public static final ShareToStatusUI.a afLg;
  private Uri mUri;
  private ProgressDialog wQT;
  private int xnM = -1;
  
  static
  {
    AppMethodBeat.i(250991);
    afLg = new ShareToStatusUI.a((byte)0);
    AppMethodBeat.o(250991);
  }
  
  private void MZ(boolean paramBoolean)
  {
    AppMethodBeat.i(250956);
    if (getIntent() == null)
    {
      Log.e("MicroMsg.ShareToStatusUI", "deal fail, intent is null");
      aEc(1);
      finish();
      AppMethodBeat.o(250956);
      return;
    }
    Object localObject1 = getIntent().getAction();
    if (Util.isNullOrNil((String)localObject1))
    {
      Log.e("MicroMsg.ShareToStatusUI", "deal fail, action is null");
      aEc(1);
      finish();
      AppMethodBeat.o(250956);
      return;
    }
    Object localObject2 = getIntent().resolveType((Context)this);
    int i;
    if (Util.isNullOrNil((String)localObject2))
    {
      Log.e("MicroMsg.ShareToStatusUI", "getFileType, mimeType is NONE");
      i = 0;
    }
    while (i == 0)
    {
      Log.e("MicroMsg.ShareToStatusUI", kotlin.g.b.s.X("deal fail, mimeType is illegal：", localObject2));
      aEc(3);
      finish();
      AppMethodBeat.o(250956);
      return;
      kotlin.g.b.s.checkNotNull(localObject2);
      if (kotlin.n.n.a((CharSequence)localObject2, (CharSequence)"image", true))
      {
        Log.i("MicroMsg.ShareToStatusUI", "getFileType, mimeType is image");
        i = 1;
      }
      else if (kotlin.n.n.a((CharSequence)localObject2, (CharSequence)"video", true))
      {
        Log.i("MicroMsg.ShareToStatusUI", "getFileType, mimeType is video");
        i = 2;
      }
      else
      {
        Log.i("MicroMsg.ShareToStatusUI", "getFileType, mimeType is NONE");
        i = 0;
      }
    }
    localObject2 = IntentUtil.getExtras(getIntent());
    if ((kotlin.g.b.s.p(localObject1, "android.intent.action.SEND")) && (localObject2 != null))
    {
      Log.i("MicroMsg.ShareToStatusUI", kotlin.g.b.s.X("send signal: ", localObject1));
      localObject1 = ((Bundle)localObject2).getParcelable("android.intent.extra.STREAM");
      if ((localObject1 == null) || (!(localObject1 instanceof Uri)))
      {
        Log.e("MicroMsg.ShareToStatusUI", kotlin.g.b.s.X("deal fail, uri is null or illegal：", localObject1));
        aEc(2);
        finish();
        AppMethodBeat.o(250956);
        return;
      }
      if (!Util.isUriSafeToBeCopySrc((Uri)localObject1))
      {
        Log.e("MicroMsg.ShareToStatusUI", kotlin.g.b.s.X("deal fail, not accept, ", localObject1));
        aEc(2);
        finish();
        AppMethodBeat.o(250956);
        return;
      }
      this.mUri = ((Uri)localObject1);
      this.xnM = i;
      localObject2 = (Activity)this;
      getString(R.l.permission_tips_title);
      String str = getString(R.l.gallery_permission_msg);
      boolean bool = b.a((Activity)localObject2, new String[] { "android.permission.READ_EXTERNAL_STORAGE" }, 145, str);
      Log.i("MicroMsg.ShareToStatusUI", "checkPermission checkMediaStorage[%b]", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        a((Uri)localObject1, i, paramBoolean);
        AppMethodBeat.o(250956);
      }
    }
    else
    {
      Log.e("MicroMsg.ShareToStatusUI", "deal fail, action or bundle is illegal, action: " + localObject1 + "  bundle:" + localObject2);
      aEc(1);
      finish();
    }
    AppMethodBeat.o(250956);
  }
  
  private final void a(Uri paramUri, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(250961);
    l.kK(12, 11);
    Object localObject = t(paramUri);
    if (!bCE((String)localObject))
    {
      Log.e("MicroMsg.ShareToStatusUI", kotlin.g.b.s.X("deal fail, filePath is not available：", localObject));
      aEc(2);
      finish();
      AppMethodBeat.o(250961);
      return;
    }
    if ((!bh.bCA()) || (bh.aZG()))
    {
      Log.e("MicroMsg.ShareToStatusUI", kotlin.g.b.s.X("deal fail, is not login ：", localObject));
      if (!Util.isNullOrNil((String)localObject))
      {
        localObject = new Intent((Context)this, ShareToStatusUI.class);
        ((Intent)localObject).putExtra("android.intent.extra.STREAM", (Parcelable)paramUri);
        ((Intent)localObject).addFlags(32768).addFlags(268435456);
        if (paramInt == 2)
        {
          ((Intent)localObject).setType("video/*");
          ((Intent)localObject).setAction("android.intent.action.SEND");
          MMWizardActivity.b((Context)this, new Intent((Context)this, SimpleLoginUI.class).addFlags(268435456).addFlags(32768), (Intent)localObject);
        }
      }
      for (;;)
      {
        finish();
        AppMethodBeat.o(250961);
        return;
        ((Intent)localObject).setType("image/*");
        break;
        aEc(0);
      }
    }
    if (paramBoolean)
    {
      kotlin.g.b.s.checkNotNull(localObject);
      jf((String)localObject, paramInt);
      AppMethodBeat.o(250961);
      return;
    }
    kotlin.g.b.s.checkNotNull(localObject);
    je((String)localObject, paramInt);
    AppMethodBeat.o(250961);
  }
  
  private static final void a(ShareToStatusUI paramShareToStatusUI, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(250984);
    kotlin.g.b.s.u(paramShareToStatusUI, "this$0");
    paramShareToStatusUI.finish();
    AppMethodBeat.o(250984);
  }
  
  private static final void a(ShareToStatusUI paramShareToStatusUI, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(250986);
    kotlin.g.b.s.u(paramShareToStatusUI, "this$0");
    b.lx((Context)paramShareToStatusUI.getContext());
    paramShareToStatusUI.finish();
    AppMethodBeat.o(250986);
  }
  
  private final void aEc(int paramInt)
  {
    AppMethodBeat.i(250978);
    ful();
    switch (paramInt)
    {
    default: 
      paramInt = R.l.gWb;
    }
    for (;;)
    {
      Toast.makeText((Context)this, paramInt, 1).show();
      AppMethodBeat.o(250978);
      return;
      paramInt = R.l.gWe;
      continue;
      paramInt = R.l.gWc;
      continue;
      paramInt = R.l.gWd;
    }
  }
  
  private static final void b(ShareToStatusUI paramShareToStatusUI, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(250988);
    kotlin.g.b.s.u(paramShareToStatusUI, "this$0");
    paramShareToStatusUI.finish();
    AppMethodBeat.o(250988);
  }
  
  private static boolean bCE(String paramString)
  {
    AppMethodBeat.i(250964);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.ShareToStatusUI", "checkShareFilePathAvailable  filePtah is Null or Nil, return false");
      AppMethodBeat.o(250964);
      return false;
    }
    kotlin.g.b.s.checkNotNull(paramString);
    u localu = new u(paramString);
    if ((!localu.jKS()) || (!localu.jKQ()))
    {
      Log.e("MicroMsg.ShareToStatusUI", "checkShareFilePathAvailable  file exists:" + localu.jKS() + ", canRead:" + localu.jKQ() + ", return false");
      AppMethodBeat.o(250964);
      return false;
    }
    Log.i("MicroMsg.ShareToStatusUI", kotlin.g.b.s.X("checkShareFilePathAvailable  filePath is available: ", paramString));
    AppMethodBeat.o(250964);
    return true;
  }
  
  private final void fpM()
  {
    AppMethodBeat.i(250979);
    Context localContext = (Context)this;
    getString(R.l.app_tip);
    this.wQT = ((ProgressDialog)k.a(localContext, getString(R.l.app_waiting), true, new ShareToStatusUI..ExternalSyntheticLambda0(this)));
    AppMethodBeat.o(250979);
  }
  
  private final void ful()
  {
    AppMethodBeat.i(250981);
    try
    {
      if (this.wQT != null)
      {
        ProgressDialog localProgressDialog = this.wQT;
        kotlin.g.b.s.checkNotNull(localProgressDialog);
        if (localProgressDialog.isShowing())
        {
          localProgressDialog = this.wQT;
          kotlin.g.b.s.checkNotNull(localProgressDialog);
          localProgressDialog.dismiss();
          AppMethodBeat.o(250981);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.ShareToStatusUI", (Throwable)localException, "", new Object[0]);
      AppMethodBeat.o(250981);
    }
  }
  
  private final void je(String paramString, int paramInt)
  {
    AppMethodBeat.i(250971);
    Log.i("MicroMsg.ShareToStatusUI", "shareToStatus  share path: " + paramString + "  type:" + paramInt);
    ful();
    com.tencent.mm.plugin.textstatus.a.n localn = (com.tencent.mm.plugin.textstatus.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.textstatus.a.n.class);
    Context localContext = (Context)getContext();
    w.a locala = new w.a();
    locala.bdt(paramString);
    locala.aol(paramInt);
    locala.hFH();
    paramString = ah.aiuX;
    localn.a(localContext, locala.ThS);
    finish();
    AppMethodBeat.o(250971);
  }
  
  private final void jf(String paramString, int paramInt)
  {
    AppMethodBeat.i(250975);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    paramString = null;
    switch (paramInt)
    {
    }
    while (paramString != null)
    {
      Log.i("MicroMsg.ShareToStatusUI", kotlin.g.b.s.X("doCheckSysScene, do scene：", Integer.valueOf(paramInt)));
      bh.aZW().b(837, (com.tencent.mm.am.h)this);
      bh.aZW().a(837, (com.tencent.mm.am.h)this);
      bh.aZW().a((p)paramString, 0);
      ful();
      fpM();
      AppMethodBeat.o(250975);
      return;
      paramString = new com.tencent.mm.modelsimple.i(3, (List)localArrayList, getCallerPackage());
      continue;
      paramString = new com.tencent.mm.modelsimple.i(1, (List)localArrayList, getCallerPackage());
    }
    Log.e("MicroMsg.ShareToStatusUI", "doCheckSysScene, mimeType is illegal");
    aEc(3);
    finish();
    AppMethodBeat.o(250975);
  }
  
  private final String t(Uri paramUri)
  {
    AppMethodBeat.i(250968);
    String str2 = Util.getFilePath((Context)this, paramUri);
    String str1 = str2;
    if (!bCE(str2))
    {
      Log.w("MicroMsg.ShareToStatusUI", kotlin.g.b.s.X("filePath is not available, should get copy path again：", str2));
      str1 = e.a(getContentResolver(), str2, paramUri);
    }
    AppMethodBeat.o(250968);
    return str1;
  }
  
  public final void a(AutoLoginActivity.a parama, Intent paramIntent)
  {
    AppMethodBeat.i(251015);
    kotlin.g.b.s.u(parama, "loginResult");
    kotlin.g.b.s.u(paramIntent, "intent");
    if (ShareToStatusUI.b.$EnumSwitchMapping$0[parama.ordinal()] == 1)
    {
      setIntent(paramIntent);
      int i = Util.getInt(com.tencent.mm.k.i.aRC().getValue("SystemShareControlBitset"), 0);
      Log.i("MicroMsg.ShareToStatusUI", "now permission = %d", new Object[] { Integer.valueOf(i) });
      if ((i & 0x2) > 0)
      {
        Log.e("MicroMsg.ShareToStatusUI", "now allowed to share to friend");
        finish();
        AppMethodBeat.o(251015);
        return;
      }
      MZ(true);
      AppMethodBeat.o(251015);
      return;
    }
    finish();
    AppMethodBeat.o(251015);
  }
  
  public final boolean ad(Intent paramIntent)
  {
    AppMethodBeat.i(251011);
    kotlin.g.b.s.u(paramIntent, "intent");
    AppMethodBeat.o(251011);
    return true;
  }
  
  public final boolean gtu()
  {
    AppMethodBeat.i(251003);
    if ((!bh.bCA()) || (bh.aZG()))
    {
      Log.w("MicroMsg.ShareToStatusUI", "not login");
      MZ(false);
      AppMethodBeat.o(251003);
      return true;
    }
    AppMethodBeat.o(251003);
    return false;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(251008);
    bh.aZW().b(837, (com.tencent.mm.am.h)this);
    ful();
    super.onDestroy();
    AppMethodBeat.o(251008);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(251023);
    kotlin.g.b.s.u(paramArrayOfString, "permissions");
    kotlin.g.b.s.u(paramArrayOfInt, "grantResults");
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    if (paramArrayOfInt.length == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.i("MicroMsg.ShareToStatusUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(251023);
      return;
    }
    Log.i("MicroMsg.ShareToStatusUI", "onRequestPermissionsResult requestCode[%d], grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    if (paramInt == 145)
    {
      if (paramArrayOfInt[0] == 0)
      {
        if (this.mUri != null)
        {
          paramArrayOfString = this.mUri;
          kotlin.g.b.s.checkNotNull(paramArrayOfString);
          a(paramArrayOfString, this.xnM, false);
          AppMethodBeat.o(251023);
          return;
        }
        finish();
        AppMethodBeat.o(251023);
        return;
      }
      k.a((Context)this, getString(R.l.permission_gallery_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.gallery_cancel), false, new ShareToStatusUI..ExternalSyntheticLambda1(this), new ShareToStatusUI..ExternalSyntheticLambda2(this));
    }
    AppMethodBeat.o(251023);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(251019);
    kotlin.g.b.s.u(paramp, "scene");
    Log.i("MicroMsg.ShareToStatusUI", "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt1 + ", errMsg = " + paramString);
    bh.aZW().b(837, (com.tencent.mm.am.h)this);
    ful();
    if ((paramp instanceof com.tencent.mm.modelsimple.i))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        break label253;
      }
      if (paramp.getReqResp() != null)
      {
        paramString = paramp.getReqResp();
        if (paramString == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
          AppMethodBeat.o(251019);
          throw paramString;
        }
        paramString = c.c.b(((com.tencent.mm.am.c)paramString).otC);
        if (paramString == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CheckShareExtensionResponse");
          AppMethodBeat.o(251019);
          throw paramString;
        }
        paramString = (abm)paramString;
        if (Util.isNullOrNil(paramString.Zkd)) {
          break label253;
        }
        paramp = new Intent();
        paramp.putExtra("rawUrl", paramString.Zkd);
        paramp.putExtra("showShare", false);
        paramp.putExtra("show_bottom", false);
        paramp.putExtra("needRedirect", false);
        com.tencent.mm.br.c.b((Context)this, "webview", ".ui.tools.WebViewUI", paramp);
      }
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(251019);
      return;
      label253:
      MZ(false);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ShareToStatusUI
 * JD-Core Version:    0.7.0.1
 */