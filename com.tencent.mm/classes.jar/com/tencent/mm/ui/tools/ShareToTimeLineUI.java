package com.tencent.mm.ui.tools;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.k.f;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelsimple.ad;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.plugin.report.service.l;
import com.tencent.mm.pluginsdk.l.e;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.protocal.protobuf.abm;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.vfs.u;
import java.net.URLEncoder;
import java.util.ArrayList;

public class ShareToTimeLineUI
  extends AutoLoginActivity
  implements com.tencent.mm.am.h
{
  private Intent intent;
  private ProgressDialog lzP = null;
  private Intent ubG;
  
  private void aP(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(39181);
    Intent localIntent = new Intent();
    ArrayList localArrayList = new ArrayList();
    if (!Util.isNullOrNil(paramString1))
    {
      localIntent.putExtra("sns_kemdia_path", paramString1);
      localIntent.putExtra("KFilterId", -1);
      localArrayList.add(paramString1);
    }
    if (!Util.isNullOrNil(paramString2)) {
      localIntent.putExtra("Kdescription", paramString2);
    }
    if ((paramInt == 4) && (Util.isNullOrNil(paramString1)) && (!Util.isNullOrNil(paramString2))) {
      localArrayList.add(paramString2);
    }
    if ((bh.bCA()) && (!bh.aZG()))
    {
      localIntent.putExtra("K_go_to_SnsTimeLineUI", true);
      localIntent.putExtra("Ksnsupload_source", 12);
      if (paramInt == 0) {
        localIntent.putExtra("KBlockAdd", true);
      }
      localIntent.setClassName(this, "com.tencent.mm.plugin.sns.ui.SnsUploadUI");
      this.ubG = localIntent;
      paramString1 = null;
      switch (paramInt)
      {
      }
      for (;;)
      {
        if (paramString1 != null)
        {
          bh.aZW().a(837, this);
          com.tencent.mm.kernel.h.aZW().a(paramString1, 0);
          fpM();
        }
        AppMethodBeat.o(39181);
        return;
        paramString1 = new com.tencent.mm.modelsimple.i(5, localArrayList, getCallerPackage());
        continue;
        paramString1 = new com.tencent.mm.modelsimple.i(1, localArrayList, getCallerPackage());
      }
    }
    if (!Util.isNullOrNil(paramString1))
    {
      paramString2 = new Intent(this, ShareToTimeLineUI.class);
      paramString2.putExtra("android.intent.extra.STREAM", FileProviderHelper.getUriForFile(getContext(), new u(paramString1)));
      paramString2.addFlags(32768).addFlags(268435456);
      paramString2.setType("image/*");
      paramString2.setAction("android.intent.action.SEND");
      MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class).addFlags(268435456).addFlags(32768), paramString2);
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(39181);
      return;
      jCS();
    }
  }
  
  private void b(String paramString1, Bundle paramBundle, String paramString2)
  {
    AppMethodBeat.i(251093);
    l.kK(12, 11);
    if ((paramString1.equals("android.intent.action.SEND")) && (paramBundle != null))
    {
      Log.i("MicroMsg.ShareToTimeLine", "send signal: ".concat(String.valueOf(paramString1)));
      paramString1 = paramBundle.getParcelable("android.intent.extra.STREAM");
      if ((paramString1 == null) || (!(paramString1 instanceof Uri)))
      {
        if (this.intent.getBooleanExtra("Ksnsupload_empty_img", false))
        {
          aP(null, paramString2, 4);
          AppMethodBeat.o(251093);
          return;
        }
        jCS();
        finish();
        AppMethodBeat.o(251093);
        return;
      }
      paramBundle = (Uri)paramString1;
      if (!Util.isUriSafeToBeCopySrc(paramBundle))
      {
        Log.e("MicroMsg.ShareToTimeLine", "deal : fail, not accept, %s", new Object[] { paramBundle });
        jCS();
        finish();
        AppMethodBeat.o(251093);
        return;
      }
      paramString1 = Util.getFilePath(this, paramBundle);
      if ((!Util.isNullOrNil(paramString1)) && (new u(paramString1).jKS()) && ((Build.VERSION.SDK_INT < 30) || (new u(paramString1).jKQ()))) {
        break label307;
      }
      paramString1 = e.a(getContentResolver(), paramBundle, 2);
    }
    label307:
    for (;;)
    {
      if ((Util.isNullOrNil(paramString1)) || (!Util.isImageFilename(paramString1)))
      {
        if (this.intent.getBooleanExtra("Ksnsupload_empty_img", false))
        {
          aP(paramString1, paramString2, 4);
          AppMethodBeat.o(251093);
          return;
        }
        jCS();
        finish();
        AppMethodBeat.o(251093);
        return;
      }
      if (bCF(paramString1))
      {
        aP(paramString1, paramString2, 0);
        AppMethodBeat.o(251093);
        return;
      }
      jCS();
      finish();
      AppMethodBeat.o(251093);
      return;
      Log.e("MicroMsg.ShareToTimeLine", "launch : fail, uri is null");
      jCS();
      finish();
      AppMethodBeat.o(251093);
      return;
    }
  }
  
  private static boolean bCF(String paramString)
  {
    AppMethodBeat.i(39180);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(39180);
      return false;
    }
    boolean bool = ImgUtil.isImgFile(paramString);
    AppMethodBeat.o(39180);
    return bool;
  }
  
  private void fpM()
  {
    AppMethodBeat.i(39184);
    getString(R.l.app_tip);
    this.lzP = k.a(this, getString(R.l.app_waiting), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(39176);
        ShareToTimeLineUI.this.finish();
        AppMethodBeat.o(39176);
      }
    });
    AppMethodBeat.o(39184);
  }
  
  private void jCS()
  {
    AppMethodBeat.i(39183);
    Toast.makeText(this, R.l.gWm, 1).show();
    AppMethodBeat.o(39183);
  }
  
  private void jDn()
  {
    AppMethodBeat.i(39179);
    Object localObject = getIntent();
    if (localObject == null)
    {
      Log.e("MicroMsg.ShareToTimeLine", "launch : fail, intent is null");
      jCS();
      finish();
      AppMethodBeat.o(39179);
      return;
    }
    String str1 = ((Intent)localObject).getAction();
    Bundle localBundle = IntentUtil.getExtras((Intent)localObject);
    if (Util.isNullOrNil(str1))
    {
      Log.e("MicroMsg.ShareToTimeLine", "launch : fail, action is null");
      jCS();
      finish();
      AppMethodBeat.o(39179);
      return;
    }
    localObject = IntentUtil.getStringExtra((Intent)localObject, "Kdescription");
    String str2 = getIntent().resolveType(this);
    if (Util.isNullOrNil(str2))
    {
      jCS();
      finish();
      AppMethodBeat.o(39179);
      return;
    }
    if (!str2.contains("image"))
    {
      jCS();
      finish();
      AppMethodBeat.o(39179);
      return;
    }
    getString(R.l.permission_tips_title);
    str2 = getString(R.l.gallery_permission_msg);
    boolean bool = b.a(this, new String[] { "android.permission.READ_EXTERNAL_STORAGE" }, 145, str2);
    Log.i("MicroMsg.ShareToTimeLine", "checkPermission checkMediaStorage[%b]", new Object[] { Boolean.valueOf(bool) });
    if (bool) {
      b(str1, localBundle, (String)localObject);
    }
    AppMethodBeat.o(39179);
  }
  
  public final void a(AutoLoginActivity.a parama, Intent paramIntent)
  {
    AppMethodBeat.i(39185);
    switch (ShareToTimeLineUI.2.vrD[parama.ordinal()])
    {
    default: 
      finish();
      AppMethodBeat.o(39185);
      return;
    }
    this.intent = paramIntent;
    int i = Util.getInt(com.tencent.mm.k.i.aRC().getValue("SystemShareControlBitset"), 0);
    Log.i("MicroMsg.ShareToTimeLine", "now permission = %d", new Object[] { Integer.valueOf(i) });
    if ((i & 0x2) > 0)
    {
      Log.e("MicroMsg.ShareToTimeLine", "now allowed to share to friend");
      finish();
      AppMethodBeat.o(39185);
      return;
    }
    parama = IntentUtil.getStringExtra(paramIntent, "android.intent.extra.TEXT");
    Log.i("MicroMsg.ShareToTimeLine", "postLogin, text = %s", new Object[] { parama });
    if (!Util.isNullOrNil(parama))
    {
      parama = String.format("weixin://dl/business/systemshare/?txt=%s", new Object[] { URLEncoder.encode(parama) });
      fpM();
      bh.aZW().a(1200, this);
      parama = new ad(parama, 15, null);
      bh.aZW().a(parama, 0);
      AppMethodBeat.o(39185);
      return;
    }
    jDn();
    AppMethodBeat.o(39185);
  }
  
  public final boolean ad(Intent paramIntent)
  {
    return true;
  }
  
  public final boolean gtu()
  {
    AppMethodBeat.i(39178);
    if ((!bh.bCA()) || (bh.aZG()))
    {
      Log.w("MicroMsg.ShareToTimeLine", "not login");
      jDn();
      AppMethodBeat.o(39178);
      return true;
    }
    AppMethodBeat.o(39178);
    return false;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(39182);
    bh.aZW().b(837, this);
    super.onDestroy();
    AppMethodBeat.o(39182);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(251120);
    if (paramArrayOfInt.length <= 0)
    {
      Log.i("MicroMsg.ShareToTimeLine", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(251120);
      return;
    }
    Log.i("MicroMsg.ShareToTimeLine", "onRequestPermissionsResult requestCode[%d], grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(251120);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        if (this.intent == null) {
          this.intent = getIntent();
        }
        if ((this.intent != null) && (this.intent.getAction() != null))
        {
          paramArrayOfString = IntentUtil.getStringExtra(this.intent, "Kdescription");
          paramArrayOfInt = IntentUtil.getExtras(this.intent);
          b(this.intent.getAction(), paramArrayOfInt, paramArrayOfString);
          AppMethodBeat.o(251120);
        }
      }
      else
      {
        k.a(this, getString(R.l.permission_gallery_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.gallery_cancel), false, new ShareToTimeLineUI..ExternalSyntheticLambda1(this), new ShareToTimeLineUI..ExternalSyntheticLambda0(this));
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(39186);
    Log.i("MicroMsg.ShareToTimeLine", "onSceneEnd, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    bh.aZW().b(1200, this);
    if ((this.lzP != null) && (this.lzP.isShowing())) {
      this.lzP.dismiss();
    }
    if ((paramp instanceof ad))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        jDn();
        AppMethodBeat.o(39186);
        return;
      }
      jCS();
    }
    for (;;)
    {
      finish();
      do
      {
        AppMethodBeat.o(39186);
        return;
      } while (!(paramp instanceof com.tencent.mm.modelsimple.i));
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.ubG;
        paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aYi(), "com/tencent/mm/ui/tools/ShareToTimeLineUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/tools/ShareToTimeLineUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      else if (paramp.getReqResp() != null)
      {
        paramString = (abm)c.c.b(((com.tencent.mm.am.c)paramp.getReqResp()).otC);
        if ((paramString != null) && (!Util.isNullOrNil(paramString.Zkd)))
        {
          paramp = new Intent();
          paramp.putExtra("rawUrl", paramString.Zkd);
          paramp.putExtra("showShare", false);
          paramp.putExtra("show_bottom", false);
          paramp.putExtra("needRedirect", false);
          com.tencent.mm.br.c.b(this, "webview", ".ui.tools.WebViewUI", paramp);
        }
        else
        {
          paramString = this.ubG;
          paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
          com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aYi(), "com/tencent/mm/ui/tools/ShareToTimeLineUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramString.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/tools/ShareToTimeLineUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ShareToTimeLineUI
 * JD-Core Version:    0.7.0.1
 */