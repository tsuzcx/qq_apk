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
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.d;
import com.tencent.mm.model.bc;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.protocal.protobuf.xy;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.k;
import java.net.URLEncoder;
import java.util.ArrayList;

@JgClassChecked(author=20, fComment="checked", lastDate="20140422", reviewer=20, vComment={com.jg.EType.ACTIVITYCHECK})
public class ShareToTimeLineUI
  extends AutoLoginActivity
  implements f
{
  private ProgressDialog fOC = null;
  private Intent intent;
  private Intent mHz;
  
  private static boolean aYP(String paramString)
  {
    AppMethodBeat.i(39180);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(39180);
      return false;
    }
    boolean bool = u.aRF(paramString);
    AppMethodBeat.o(39180);
    return bool;
  }
  
  private void ao(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(39181);
    Intent localIntent = new Intent();
    ArrayList localArrayList = new ArrayList();
    if (!bu.isNullOrNil(paramString1))
    {
      localIntent.putExtra("sns_kemdia_path", paramString1);
      localIntent.putExtra("KFilterId", -1);
      localArrayList.add(paramString1);
    }
    if (!bu.isNullOrNil(paramString2)) {
      localIntent.putExtra("Kdescription", paramString2);
    }
    if ((paramInt == 4) && (bu.isNullOrNil(paramString1)) && (!bu.isNullOrNil(paramString2))) {
      localArrayList.add(paramString2);
    }
    if ((bc.aCh()) && (!bc.aiT()))
    {
      localIntent.putExtra("K_go_to_SnsTimeLineUI", true);
      localIntent.putExtra("Ksnsupload_source", 12);
      if (paramInt == 0) {
        localIntent.putExtra("KBlockAdd", true);
      }
      localIntent.setClassName(this, "com.tencent.mm.plugin.sns.ui.SnsUploadUI");
      this.mHz = localIntent;
      paramString1 = null;
      switch (paramInt)
      {
      }
      for (;;)
      {
        if (paramString1 != null)
        {
          bc.ajj().a(837, this);
          com.tencent.mm.kernel.g.ajj().a(paramString1, 0);
          showDialog();
        }
        AppMethodBeat.o(39181);
        return;
        paramString1 = new com.tencent.mm.modelsimple.g(5, localArrayList, getCallerPackage());
        continue;
        paramString1 = new com.tencent.mm.modelsimple.g(1, localArrayList, getCallerPackage());
      }
    }
    if (!bu.isNullOrNil(paramString1))
    {
      paramString2 = new Intent(this, ShareToTimeLineUI.class);
      paramString2.putExtra("android.intent.extra.STREAM", o.a(getContext(), new k(paramString1)));
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
      fOD();
    }
  }
  
  private void fOD()
  {
    AppMethodBeat.i(39183);
    Toast.makeText(this, 2131763661, 1).show();
    AppMethodBeat.o(39183);
  }
  
  private void fOZ()
  {
    AppMethodBeat.i(39179);
    Intent localIntent = getIntent();
    if (localIntent == null)
    {
      ae.e("MicroMsg.ShareToTimeLine", "launch : fail, intent is null");
      fOD();
      finish();
      AppMethodBeat.o(39179);
      return;
    }
    Object localObject1 = localIntent.getAction();
    Object localObject2 = z.bl(localIntent);
    if (bu.isNullOrNil((String)localObject1))
    {
      ae.e("MicroMsg.ShareToTimeLine", "launch : fail, action is null");
      fOD();
      finish();
      AppMethodBeat.o(39179);
      return;
    }
    String str1 = z.getStringExtra(localIntent, "Kdescription");
    String str2 = getIntent().resolveType(this);
    if (bu.isNullOrNil(str2))
    {
      fOD();
      finish();
      AppMethodBeat.o(39179);
      return;
    }
    if (!str2.contains("image"))
    {
      fOD();
      finish();
      AppMethodBeat.o(39179);
      return;
    }
    if ((((String)localObject1).equals("android.intent.action.SEND")) && (localObject2 != null))
    {
      ae.i("MicroMsg.ShareToTimeLine", "send signal: ".concat(String.valueOf(localObject1)));
      localObject1 = ((Bundle)localObject2).getParcelable("android.intent.extra.STREAM");
      if ((localObject1 == null) || (!(localObject1 instanceof Uri)))
      {
        if (localIntent.getBooleanExtra("Ksnsupload_empty_img", false))
        {
          ao(null, str1, 4);
          AppMethodBeat.o(39179);
          return;
        }
        fOD();
        finish();
        AppMethodBeat.o(39179);
        return;
      }
      localObject2 = (Uri)localObject1;
      if (!bu.z((Uri)localObject2))
      {
        ae.e("MicroMsg.ShareToTimeLine", "deal : fail, not accept, %s", new Object[] { localObject2 });
        fOD();
        finish();
        AppMethodBeat.o(39179);
        return;
      }
      localObject1 = bu.k(this, (Uri)localObject2);
      if ((!bu.isNullOrNil((String)localObject1)) && (new k((String)localObject1).exists())) {
        break label414;
      }
      localObject1 = com.tencent.mm.pluginsdk.l.e.a(getContentResolver(), (Uri)localObject2, 2);
    }
    label414:
    for (;;)
    {
      if ((bu.isNullOrNil((String)localObject1)) || (!bu.aSP((String)localObject1)))
      {
        if (localIntent.getBooleanExtra("Ksnsupload_empty_img", false))
        {
          ao((String)localObject1, str1, 4);
          AppMethodBeat.o(39179);
          return;
        }
        fOD();
        finish();
        AppMethodBeat.o(39179);
        return;
      }
      if (aYP((String)localObject1))
      {
        ao((String)localObject1, str1, 0);
        AppMethodBeat.o(39179);
        return;
      }
      fOD();
      finish();
      AppMethodBeat.o(39179);
      return;
      ae.e("MicroMsg.ShareToTimeLine", "launch : fail, uri is null");
      fOD();
      finish();
      AppMethodBeat.o(39179);
      return;
    }
  }
  
  private void showDialog()
  {
    AppMethodBeat.i(39184);
    getString(2131755906);
    this.fOC = h.b(this, getString(2131755936), true, new DialogInterface.OnCancelListener()
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
    switch (ShareToTimeLineUI.2.nSR[parama.ordinal()])
    {
    default: 
      finish();
      AppMethodBeat.o(39185);
      return;
    }
    this.intent = paramIntent;
    int i = bu.getInt(com.tencent.mm.n.g.acL().getValue("SystemShareControlBitset"), 0);
    ae.i("MicroMsg.ShareToTimeLine", "now permission = %d", new Object[] { Integer.valueOf(i) });
    if ((i & 0x2) > 0)
    {
      ae.e("MicroMsg.ShareToTimeLine", "now allowed to share to friend");
      finish();
      AppMethodBeat.o(39185);
      return;
    }
    parama = z.getStringExtra(paramIntent, "android.intent.extra.TEXT");
    ae.i("MicroMsg.ShareToTimeLine", "postLogin, text = %s", new Object[] { parama });
    if (!bu.isNullOrNil(parama))
    {
      parama = String.format("weixin://dl/business/systemshare/?txt=%s", new Object[] { URLEncoder.encode(parama) });
      showDialog();
      bc.ajj().a(1200, this);
      parama = new ac(parama, 15, null);
      bc.ajj().a(parama, 0);
      AppMethodBeat.o(39185);
      return;
    }
    fOZ();
    AppMethodBeat.o(39185);
  }
  
  public final boolean ab(Intent paramIntent)
  {
    return true;
  }
  
  public final boolean dxS()
  {
    AppMethodBeat.i(39178);
    if ((!bc.aCh()) || (bc.aiT()))
    {
      ae.w("MicroMsg.ShareToTimeLine", "not login");
      fOZ();
      AppMethodBeat.o(39178);
      return true;
    }
    AppMethodBeat.o(39178);
    return false;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(39182);
    bc.ajj().b(837, this);
    super.onDestroy();
    AppMethodBeat.o(39182);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(39186);
    ae.i("MicroMsg.ShareToTimeLine", "onSceneEnd, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    bc.ajj().b(1200, this);
    if ((this.fOC != null) && (this.fOC.isShowing())) {
      this.fOC.dismiss();
    }
    if ((paramn instanceof ac))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        fOZ();
        AppMethodBeat.o(39186);
        return;
      }
      fOD();
    }
    for (;;)
    {
      finish();
      do
      {
        AppMethodBeat.o(39186);
        return;
      } while (!(paramn instanceof com.tencent.mm.modelsimple.g));
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.mHz;
        paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramString.ahE(), "com/tencent/mm/ui/tools/ShareToTimeLineUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/tools/ShareToTimeLineUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      else if (paramn.getReqResp() != null)
      {
        paramString = (xy)((b)paramn.getReqResp()).hQE.hQJ;
        if ((paramString != null) && (!bu.isNullOrNil(paramString.GpX)))
        {
          paramn = new Intent();
          paramn.putExtra("rawUrl", paramString.GpX);
          paramn.putExtra("showShare", false);
          paramn.putExtra("show_bottom", false);
          paramn.putExtra("needRedirect", false);
          d.b(this, "webview", ".ui.tools.WebViewUI", paramn);
        }
        else
        {
          paramString = this.mHz;
          paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramString.ahE(), "com/tencent/mm/ui/tools/ShareToTimeLineUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramString.mt(0));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ShareToTimeLineUI
 * JD-Core Version:    0.7.0.1
 */