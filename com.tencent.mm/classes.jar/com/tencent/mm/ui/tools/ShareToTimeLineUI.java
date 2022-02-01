package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.widget.Toast;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.by.c;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.modelsimple.g;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.pluginsdk.m.e;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.protocal.protobuf.zo;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMWizardActivity;
import java.net.URLEncoder;
import java.util.ArrayList;

@JgClassChecked(author=20, fComment="checked", lastDate="20140422", reviewer=20, vComment={com.jg.EType.ACTIVITYCHECK})
public class ShareToTimeLineUI
  extends AutoLoginActivity
  implements i
{
  private ProgressDialog iXX = null;
  private Intent intent;
  private Intent qVX;
  
  private void aD(String paramString1, String paramString2, int paramInt)
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
    if ((bh.beJ()) && (!bh.aGE()))
    {
      localIntent.putExtra("K_go_to_SnsTimeLineUI", true);
      localIntent.putExtra("Ksnsupload_source", 12);
      if (paramInt == 0) {
        localIntent.putExtra("KBlockAdd", true);
      }
      localIntent.setClassName(this, "com.tencent.mm.plugin.sns.ui.SnsUploadUI");
      this.qVX = localIntent;
      paramString1 = null;
      switch (paramInt)
      {
      }
      for (;;)
      {
        if (paramString1 != null)
        {
          bh.aGY().a(837, this);
          com.tencent.mm.kernel.h.aGY().a(paramString1, 0);
          elK();
        }
        AppMethodBeat.o(39181);
        return;
        paramString1 = new g(5, localArrayList, getCallerPackage());
        continue;
        paramString1 = new g(1, localArrayList, getCallerPackage());
      }
    }
    if (!Util.isNullOrNil(paramString1))
    {
      paramString2 = new Intent(this, ShareToTimeLineUI.class);
      paramString2.putExtra("android.intent.extra.STREAM", FileProviderHelper.getUriForFile(getContext(), new com.tencent.mm.vfs.q(paramString1)));
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
      hYi();
    }
  }
  
  private static boolean bAH(String paramString)
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
  
  private void elK()
  {
    AppMethodBeat.i(39184);
    getString(R.l.app_tip);
    this.iXX = com.tencent.mm.ui.base.h.a(this, getString(R.l.app_waiting), true, new DialogInterface.OnCancelListener()
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
  
  private void hYE()
  {
    AppMethodBeat.i(39179);
    Intent localIntent = getIntent();
    if (localIntent == null)
    {
      Log.e("MicroMsg.ShareToTimeLine", "launch : fail, intent is null");
      hYi();
      finish();
      AppMethodBeat.o(39179);
      return;
    }
    Object localObject1 = localIntent.getAction();
    Object localObject2 = IntentUtil.getExtras(localIntent);
    if (Util.isNullOrNil((String)localObject1))
    {
      Log.e("MicroMsg.ShareToTimeLine", "launch : fail, action is null");
      hYi();
      finish();
      AppMethodBeat.o(39179);
      return;
    }
    String str1 = IntentUtil.getStringExtra(localIntent, "Kdescription");
    String str2 = getIntent().resolveType(this);
    if (Util.isNullOrNil(str2))
    {
      hYi();
      finish();
      AppMethodBeat.o(39179);
      return;
    }
    if (!str2.contains("image"))
    {
      hYi();
      finish();
      AppMethodBeat.o(39179);
      return;
    }
    if ((((String)localObject1).equals("android.intent.action.SEND")) && (localObject2 != null))
    {
      Log.i("MicroMsg.ShareToTimeLine", "send signal: ".concat(String.valueOf(localObject1)));
      localObject1 = ((Bundle)localObject2).getParcelable("android.intent.extra.STREAM");
      if ((localObject1 == null) || (!(localObject1 instanceof Uri)))
      {
        if (localIntent.getBooleanExtra("Ksnsupload_empty_img", false))
        {
          aD(null, str1, 4);
          AppMethodBeat.o(39179);
          return;
        }
        hYi();
        finish();
        AppMethodBeat.o(39179);
        return;
      }
      localObject2 = (Uri)localObject1;
      if (!Util.isUriSafeToBeCopySrc((Uri)localObject2))
      {
        Log.e("MicroMsg.ShareToTimeLine", "deal : fail, not accept, %s", new Object[] { localObject2 });
        hYi();
        finish();
        AppMethodBeat.o(39179);
        return;
      }
      localObject1 = Util.getFilePath(this, (Uri)localObject2);
      if ((!Util.isNullOrNil((String)localObject1)) && (new com.tencent.mm.vfs.q((String)localObject1).ifE()) && ((Build.VERSION.SDK_INT < 30) || (new com.tencent.mm.vfs.q((String)localObject1).ifC()))) {
        break label437;
      }
      localObject1 = e.a(getContentResolver(), (Uri)localObject2, 2);
    }
    label437:
    for (;;)
    {
      if ((Util.isNullOrNil((String)localObject1)) || (!Util.isImageFilename((String)localObject1)))
      {
        if (localIntent.getBooleanExtra("Ksnsupload_empty_img", false))
        {
          aD((String)localObject1, str1, 4);
          AppMethodBeat.o(39179);
          return;
        }
        hYi();
        finish();
        AppMethodBeat.o(39179);
        return;
      }
      if (bAH((String)localObject1))
      {
        aD((String)localObject1, str1, 0);
        AppMethodBeat.o(39179);
        return;
      }
      hYi();
      finish();
      AppMethodBeat.o(39179);
      return;
      Log.e("MicroMsg.ShareToTimeLine", "launch : fail, uri is null");
      hYi();
      finish();
      AppMethodBeat.o(39179);
      return;
    }
  }
  
  private void hYi()
  {
    AppMethodBeat.i(39183);
    Toast.makeText(this, R.l.eTv, 1).show();
    AppMethodBeat.o(39183);
  }
  
  public final boolean Z(Intent paramIntent)
  {
    return true;
  }
  
  public final void a(AutoLoginActivity.a parama, Intent paramIntent)
  {
    AppMethodBeat.i(39185);
    switch (2.sfH[parama.ordinal()])
    {
    default: 
      finish();
      AppMethodBeat.o(39185);
      return;
    }
    this.intent = paramIntent;
    int i = Util.getInt(com.tencent.mm.n.h.axc().getValue("SystemShareControlBitset"), 0);
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
      elK();
      bh.aGY().a(1200, this);
      parama = new ac(parama, 15, null);
      bh.aGY().a(parama, 0);
      AppMethodBeat.o(39185);
      return;
    }
    hYE();
    AppMethodBeat.o(39185);
  }
  
  public final boolean fje()
  {
    AppMethodBeat.i(39178);
    if ((!bh.beJ()) || (bh.aGE()))
    {
      Log.w("MicroMsg.ShareToTimeLine", "not login");
      hYE();
      AppMethodBeat.o(39178);
      return true;
    }
    AppMethodBeat.o(39178);
    return false;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(39182);
    bh.aGY().b(837, this);
    super.onDestroy();
    AppMethodBeat.o(39182);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(39186);
    Log.i("MicroMsg.ShareToTimeLine", "onSceneEnd, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    bh.aGY().b(1200, this);
    if ((this.iXX != null) && (this.iXX.isShowing())) {
      this.iXX.dismiss();
    }
    if ((paramq instanceof ac))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        hYE();
        AppMethodBeat.o(39186);
        return;
      }
      hYi();
    }
    for (;;)
    {
      finish();
      do
      {
        AppMethodBeat.o(39186);
        return;
      } while (!(paramq instanceof g));
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.qVX;
        paramString = new com.tencent.mm.hellhoundlib.b.a().bm(paramString);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aFh(), "com/tencent/mm/ui/tools/ShareToTimeLineUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/tools/ShareToTimeLineUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      else if (paramq.getReqResp() != null)
      {
        paramString = (zo)d.c.b(((d)paramq.getReqResp()).lBS);
        if ((paramString != null) && (!Util.isNullOrNil(paramString.SlS)))
        {
          paramq = new Intent();
          paramq.putExtra("rawUrl", paramString.SlS);
          paramq.putExtra("showShare", false);
          paramq.putExtra("show_bottom", false);
          paramq.putExtra("needRedirect", false);
          c.b(this, "webview", ".ui.tools.WebViewUI", paramq);
        }
        else
        {
          paramString = this.qVX;
          paramString = new com.tencent.mm.hellhoundlib.b.a().bm(paramString);
          com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aFh(), "com/tencent/mm/ui/tools/ShareToTimeLineUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramString.sf(0));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ShareToTimeLineUI
 * JD-Core Version:    0.7.0.1
 */