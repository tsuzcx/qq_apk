package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.q;
import com.tencent.mm.bs.d;
import com.tencent.mm.model.ba;
import com.tencent.mm.modelsimple.ab;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.protocal.protobuf.xv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import java.net.URLEncoder;
import java.util.ArrayList;

@JgClassChecked(author=20, fComment="checked", lastDate="20140422", reviewer=20, vComment={com.jg.EType.ACTIVITYCHECK})
public class ShareToTimeLineUI
  extends AutoLoginActivity
  implements com.tencent.mm.al.f
{
  private ProgressDialog fMu = null;
  private Intent intent;
  private Intent mCu;
  
  private static boolean aXo(String paramString)
  {
    AppMethodBeat.i(39180);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(39180);
      return false;
    }
    boolean bool = t.aQi(paramString);
    AppMethodBeat.o(39180);
    return bool;
  }
  
  private void am(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(39181);
    Intent localIntent = new Intent();
    ArrayList localArrayList = new ArrayList();
    if (!bt.isNullOrNil(paramString1))
    {
      localIntent.putExtra("sns_kemdia_path", paramString1);
      localIntent.putExtra("KFilterId", -1);
      localArrayList.add(paramString1);
    }
    if (!bt.isNullOrNil(paramString2)) {
      localIntent.putExtra("Kdescription", paramString2);
    }
    if ((paramInt == 4) && (bt.isNullOrNil(paramString1)) && (!bt.isNullOrNil(paramString2))) {
      localArrayList.add(paramString2);
    }
    if ((ba.aBR()) && (!ba.aiE()))
    {
      localIntent.putExtra("K_go_to_SnsTimeLineUI", true);
      localIntent.putExtra("Ksnsupload_source", 12);
      if (paramInt == 0) {
        localIntent.putExtra("KBlockAdd", true);
      }
      localIntent.setClassName(this, "com.tencent.mm.plugin.sns.ui.SnsUploadUI");
      this.mCu = localIntent;
      paramString1 = null;
      switch (paramInt)
      {
      }
      for (;;)
      {
        if (paramString1 != null)
        {
          ba.aiU().a(837, this);
          com.tencent.mm.kernel.g.aiU().a(paramString1, 0);
          showDialog();
        }
        AppMethodBeat.o(39181);
        return;
        paramString1 = new com.tencent.mm.modelsimple.f(5, localArrayList, getCallerPackage());
        continue;
        paramString1 = new com.tencent.mm.modelsimple.f(1, localArrayList, getCallerPackage());
      }
    }
    if (!bt.isNullOrNil(paramString1))
    {
      paramString2 = new Intent(this, ShareToTimeLineUI.class);
      paramString2.putExtra("android.intent.extra.STREAM", com.tencent.mm.sdk.platformtools.n.a(getContext(), new com.tencent.mm.vfs.e(paramString1)));
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
      fKm();
    }
  }
  
  private void fKI()
  {
    AppMethodBeat.i(39179);
    Intent localIntent = getIntent();
    if (localIntent == null)
    {
      ad.e("MicroMsg.ShareToTimeLine", "launch : fail, intent is null");
      fKm();
      finish();
      AppMethodBeat.o(39179);
      return;
    }
    Object localObject1 = localIntent.getAction();
    Object localObject2 = y.bk(localIntent);
    if (bt.isNullOrNil((String)localObject1))
    {
      ad.e("MicroMsg.ShareToTimeLine", "launch : fail, action is null");
      fKm();
      finish();
      AppMethodBeat.o(39179);
      return;
    }
    String str1 = y.getStringExtra(localIntent, "Kdescription");
    String str2 = getIntent().resolveType(this);
    if (bt.isNullOrNil(str2))
    {
      fKm();
      finish();
      AppMethodBeat.o(39179);
      return;
    }
    if (!str2.contains("image"))
    {
      fKm();
      finish();
      AppMethodBeat.o(39179);
      return;
    }
    if ((((String)localObject1).equals("android.intent.action.SEND")) && (localObject2 != null))
    {
      ad.i("MicroMsg.ShareToTimeLine", "send signal: ".concat(String.valueOf(localObject1)));
      localObject1 = ((Bundle)localObject2).getParcelable("android.intent.extra.STREAM");
      if ((localObject1 == null) || (!(localObject1 instanceof Uri)))
      {
        if (localIntent.getBooleanExtra("Ksnsupload_empty_img", false))
        {
          am(null, str1, 4);
          AppMethodBeat.o(39179);
          return;
        }
        fKm();
        finish();
        AppMethodBeat.o(39179);
        return;
      }
      localObject2 = (Uri)localObject1;
      if (!bt.z((Uri)localObject2))
      {
        ad.e("MicroMsg.ShareToTimeLine", "deal : fail, not accept, %s", new Object[] { localObject2 });
        fKm();
        finish();
        AppMethodBeat.o(39179);
        return;
      }
      localObject1 = bt.k(this, (Uri)localObject2);
      if ((!bt.isNullOrNil((String)localObject1)) && (new com.tencent.mm.vfs.e((String)localObject1).exists())) {
        break label414;
      }
      localObject1 = com.tencent.mm.pluginsdk.l.e.a(getContentResolver(), (Uri)localObject2, 2);
    }
    label414:
    for (;;)
    {
      if ((bt.isNullOrNil((String)localObject1)) || (!bt.aRs((String)localObject1)))
      {
        if (localIntent.getBooleanExtra("Ksnsupload_empty_img", false))
        {
          am((String)localObject1, str1, 4);
          AppMethodBeat.o(39179);
          return;
        }
        fKm();
        finish();
        AppMethodBeat.o(39179);
        return;
      }
      if (aXo((String)localObject1))
      {
        am((String)localObject1, str1, 0);
        AppMethodBeat.o(39179);
        return;
      }
      fKm();
      finish();
      AppMethodBeat.o(39179);
      return;
      ad.e("MicroMsg.ShareToTimeLine", "launch : fail, uri is null");
      fKm();
      finish();
      AppMethodBeat.o(39179);
      return;
    }
  }
  
  private void fKm()
  {
    AppMethodBeat.i(39183);
    Toast.makeText(this, 2131763661, 1).show();
    AppMethodBeat.o(39183);
  }
  
  private void showDialog()
  {
    AppMethodBeat.i(39184);
    getString(2131755906);
    this.fMu = h.b(this, getString(2131755936), true, new DialogInterface.OnCancelListener()
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
    switch (ShareToTimeLineUI.2.nNm[parama.ordinal()])
    {
    default: 
      finish();
      AppMethodBeat.o(39185);
      return;
    }
    this.intent = paramIntent;
    int i = bt.getInt(com.tencent.mm.n.g.acA().getValue("SystemShareControlBitset"), 0);
    ad.i("MicroMsg.ShareToTimeLine", "now permission = %d", new Object[] { Integer.valueOf(i) });
    if ((i & 0x2) > 0)
    {
      ad.e("MicroMsg.ShareToTimeLine", "now allowed to share to friend");
      finish();
      AppMethodBeat.o(39185);
      return;
    }
    parama = y.getStringExtra(paramIntent, "android.intent.extra.TEXT");
    ad.i("MicroMsg.ShareToTimeLine", "postLogin, text = %s", new Object[] { parama });
    if (!bt.isNullOrNil(parama))
    {
      parama = String.format("weixin://dl/business/systemshare/?txt=%s", new Object[] { URLEncoder.encode(parama) });
      showDialog();
      ba.aiU().a(1200, this);
      parama = new ab(parama, 15, null);
      ba.aiU().a(parama, 0);
      AppMethodBeat.o(39185);
      return;
    }
    fKI();
    AppMethodBeat.o(39185);
  }
  
  public final boolean ab(Intent paramIntent)
  {
    return true;
  }
  
  public final boolean duC()
  {
    AppMethodBeat.i(39178);
    if ((!ba.aBR()) || (ba.aiE()))
    {
      ad.w("MicroMsg.ShareToTimeLine", "not login");
      fKI();
      AppMethodBeat.o(39178);
      return true;
    }
    AppMethodBeat.o(39178);
    return false;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(39182);
    ba.aiU().b(837, this);
    super.onDestroy();
    AppMethodBeat.o(39182);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(39186);
    ad.i("MicroMsg.ShareToTimeLine", "onSceneEnd, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    ba.aiU().b(1200, this);
    if ((this.fMu != null) && (this.fMu.isShowing())) {
      this.fMu.dismiss();
    }
    if ((paramn instanceof ab))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        fKI();
        AppMethodBeat.o(39186);
        return;
      }
      fKm();
    }
    for (;;)
    {
      finish();
      do
      {
        AppMethodBeat.o(39186);
        return;
      } while (!(paramn instanceof com.tencent.mm.modelsimple.f));
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.mCu;
        paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramString.ahp(), "com/tencent/mm/ui/tools/ShareToTimeLineUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/tools/ShareToTimeLineUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      else if (paramn.getReqResp() != null)
      {
        paramString = (xv)((b)paramn.getReqResp()).hNL.hNQ;
        if ((paramString != null) && (!bt.isNullOrNil(paramString.FXy)))
        {
          paramn = new Intent();
          paramn.putExtra("rawUrl", paramString.FXy);
          paramn.putExtra("showShare", false);
          paramn.putExtra("show_bottom", false);
          paramn.putExtra("needRedirect", false);
          d.b(this, "webview", ".ui.tools.WebViewUI", paramn);
        }
        else
        {
          paramString = this.mCu;
          paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramString.ahp(), "com/tencent/mm/ui/tools/ShareToTimeLineUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramString.mq(0));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ShareToTimeLineUI
 * JD-Core Version:    0.7.0.1
 */