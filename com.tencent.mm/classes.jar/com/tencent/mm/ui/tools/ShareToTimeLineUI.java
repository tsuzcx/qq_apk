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
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.br.c;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.pluginsdk.l.e;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.protocal.protobuf.zk;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.vfs.o;
import java.net.URLEncoder;
import java.util.ArrayList;

@JgClassChecked(author=20, fComment="checked", lastDate="20140422", reviewer=20, vComment={com.jg.EType.ACTIVITYCHECK})
public class ShareToTimeLineUI
  extends AutoLoginActivity
  implements i
{
  private ProgressDialog gtM = null;
  private Intent intent;
  private Intent nUx;
  
  private void as(String paramString1, String paramString2, int paramInt)
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
    if ((bg.aVG()) && (!bg.azj()))
    {
      localIntent.putExtra("K_go_to_SnsTimeLineUI", true);
      localIntent.putExtra("Ksnsupload_source", 12);
      if (paramInt == 0) {
        localIntent.putExtra("KBlockAdd", true);
      }
      localIntent.setClassName(this, "com.tencent.mm.plugin.sns.ui.SnsUploadUI");
      this.nUx = localIntent;
      paramString1 = null;
      switch (paramInt)
      {
      }
      for (;;)
      {
        if (paramString1 != null)
        {
          bg.azz().a(837, this);
          com.tencent.mm.kernel.g.azz().a(paramString1, 0);
          showDialog();
        }
        AppMethodBeat.o(39181);
        return;
        paramString1 = new com.tencent.mm.modelsimple.g(5, localArrayList, getCallerPackage());
        continue;
        paramString1 = new com.tencent.mm.modelsimple.g(1, localArrayList, getCallerPackage());
      }
    }
    if (!Util.isNullOrNil(paramString1))
    {
      paramString2 = new Intent(this, ShareToTimeLineUI.class);
      paramString2.putExtra("android.intent.extra.STREAM", FileProviderHelper.getUriForFile(getContext(), new o(paramString1)));
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
      gXw();
    }
  }
  
  private static boolean bnU(String paramString)
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
  
  private void gXT()
  {
    AppMethodBeat.i(39179);
    Intent localIntent = getIntent();
    if (localIntent == null)
    {
      Log.e("MicroMsg.ShareToTimeLine", "launch : fail, intent is null");
      gXw();
      finish();
      AppMethodBeat.o(39179);
      return;
    }
    Object localObject1 = localIntent.getAction();
    Object localObject2 = IntentUtil.getExtras(localIntent);
    if (Util.isNullOrNil((String)localObject1))
    {
      Log.e("MicroMsg.ShareToTimeLine", "launch : fail, action is null");
      gXw();
      finish();
      AppMethodBeat.o(39179);
      return;
    }
    String str1 = IntentUtil.getStringExtra(localIntent, "Kdescription");
    String str2 = getIntent().resolveType(this);
    if (Util.isNullOrNil(str2))
    {
      gXw();
      finish();
      AppMethodBeat.o(39179);
      return;
    }
    if (!str2.contains("image"))
    {
      gXw();
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
          as(null, str1, 4);
          AppMethodBeat.o(39179);
          return;
        }
        gXw();
        finish();
        AppMethodBeat.o(39179);
        return;
      }
      localObject2 = (Uri)localObject1;
      if (!Util.isUriSafeToBeCopySrc((Uri)localObject2))
      {
        Log.e("MicroMsg.ShareToTimeLine", "deal : fail, not accept, %s", new Object[] { localObject2 });
        gXw();
        finish();
        AppMethodBeat.o(39179);
        return;
      }
      localObject1 = Util.getFilePath(this, (Uri)localObject2);
      if ((!Util.isNullOrNil((String)localObject1)) && (new o((String)localObject1).exists()) && ((Build.VERSION.SDK_INT < 30) || (new o((String)localObject1).canRead()))) {
        break label436;
      }
      localObject1 = e.a(getContentResolver(), (Uri)localObject2, 2);
    }
    label436:
    for (;;)
    {
      if ((Util.isNullOrNil((String)localObject1)) || (!Util.isImageFilename((String)localObject1)))
      {
        if (localIntent.getBooleanExtra("Ksnsupload_empty_img", false))
        {
          as((String)localObject1, str1, 4);
          AppMethodBeat.o(39179);
          return;
        }
        gXw();
        finish();
        AppMethodBeat.o(39179);
        return;
      }
      if (bnU((String)localObject1))
      {
        as((String)localObject1, str1, 0);
        AppMethodBeat.o(39179);
        return;
      }
      gXw();
      finish();
      AppMethodBeat.o(39179);
      return;
      Log.e("MicroMsg.ShareToTimeLine", "launch : fail, uri is null");
      gXw();
      finish();
      AppMethodBeat.o(39179);
      return;
    }
  }
  
  private void gXw()
  {
    AppMethodBeat.i(39183);
    Toast.makeText(this, 2131765850, 1).show();
    AppMethodBeat.o(39183);
  }
  
  private void showDialog()
  {
    AppMethodBeat.i(39184);
    getString(2131755998);
    this.gtM = com.tencent.mm.ui.base.h.a(this, getString(2131756029), true, new DialogInterface.OnCancelListener()
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
  
  public final void a(AutoLoginActivity.a parama, Intent paramIntent)
  {
    AppMethodBeat.i(39185);
    switch (ShareToTimeLineUI.2.pdF[parama.ordinal()])
    {
    default: 
      finish();
      AppMethodBeat.o(39185);
      return;
    }
    this.intent = paramIntent;
    int i = Util.getInt(com.tencent.mm.n.h.aqJ().getValue("SystemShareControlBitset"), 0);
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
      showDialog();
      bg.azz().a(1200, this);
      parama = new ac(parama, 15, null);
      bg.azz().a(parama, 0);
      AppMethodBeat.o(39185);
      return;
    }
    gXT();
    AppMethodBeat.o(39185);
  }
  
  public final boolean ab(Intent paramIntent)
  {
    return true;
  }
  
  public final boolean exA()
  {
    AppMethodBeat.i(39178);
    if ((!bg.aVG()) || (bg.azj()))
    {
      Log.w("MicroMsg.ShareToTimeLine", "not login");
      gXT();
      AppMethodBeat.o(39178);
      return true;
    }
    AppMethodBeat.o(39178);
    return false;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(39182);
    bg.azz().b(837, this);
    super.onDestroy();
    AppMethodBeat.o(39182);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(39186);
    Log.i("MicroMsg.ShareToTimeLine", "onSceneEnd, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    bg.azz().b(1200, this);
    if ((this.gtM != null) && (this.gtM.isShowing())) {
      this.gtM.dismiss();
    }
    if ((paramq instanceof ac))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        gXT();
        AppMethodBeat.o(39186);
        return;
      }
      gXw();
    }
    for (;;)
    {
      finish();
      do
      {
        AppMethodBeat.o(39186);
        return;
      } while (!(paramq instanceof com.tencent.mm.modelsimple.g));
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.nUx;
        paramString = new com.tencent.mm.hellhoundlib.b.a().bl(paramString);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramString.axQ(), "com/tencent/mm/ui/tools/ShareToTimeLineUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/tools/ShareToTimeLineUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      else if (paramq.getReqResp() != null)
      {
        paramString = (zk)((d)paramq.getReqResp()).iLL.iLR;
        if ((paramString != null) && (!Util.isNullOrNil(paramString.LkJ)))
        {
          paramq = new Intent();
          paramq.putExtra("rawUrl", paramString.LkJ);
          paramq.putExtra("showShare", false);
          paramq.putExtra("show_bottom", false);
          paramq.putExtra("needRedirect", false);
          c.b(this, "webview", ".ui.tools.WebViewUI", paramq);
        }
        else
        {
          paramString = this.nUx;
          paramString = new com.tencent.mm.hellhoundlib.b.a().bl(paramString);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramString.axQ(), "com/tencent/mm/ui/tools/ShareToTimeLineUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramString.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/tools/ShareToTimeLineUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ShareToTimeLineUI
 * JD-Core Version:    0.7.0.1
 */