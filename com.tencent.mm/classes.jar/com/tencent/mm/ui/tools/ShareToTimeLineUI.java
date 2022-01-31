package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.bq.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.protocal.protobuf.st;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.e.j;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;

@JgClassChecked(author=20, fComment="checked", lastDate="20140422", reviewer=20, vComment={com.jg.EType.ACTIVITYCHECK})
public class ShareToTimeLineUI
  extends AutoLoginActivity
  implements com.tencent.mm.ai.f
{
  private Intent Axw;
  private ProgressDialog eeN = null;
  private Intent intent;
  
  private void V(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(34985);
    Intent localIntent = new Intent();
    ArrayList localArrayList = new ArrayList();
    if (!bo.isNullOrNil(paramString1))
    {
      localIntent.putExtra("sns_kemdia_path", paramString1);
      localIntent.putExtra("KFilterId", -1);
      localArrayList.add(paramString1);
    }
    if (!bo.isNullOrNil(paramString2)) {
      localIntent.putExtra(e.j.yVi, paramString2);
    }
    if ((paramInt == 4) && (bo.isNullOrNil(paramString1)) && (!bo.isNullOrNil(paramString2))) {
      localArrayList.add(paramString2);
    }
    if ((aw.aaB()) && (!aw.QP()))
    {
      localIntent.putExtra("K_go_to_SnsTimeLineUI", true);
      localIntent.putExtra("Ksnsupload_source", 12);
      if (paramInt == 0) {
        localIntent.putExtra("KBlockAdd", true);
      }
      localIntent.setClassName(this, "com.tencent.mm.plugin.sns.ui.SnsUploadUI");
      this.Axw = localIntent;
      paramString1 = null;
      switch (paramInt)
      {
      }
      for (;;)
      {
        if (paramString1 != null)
        {
          aw.Rc().a(837, this);
          com.tencent.mm.kernel.g.Rc().a(paramString1, 0);
          showDialog();
        }
        AppMethodBeat.o(34985);
        return;
        paramString1 = new com.tencent.mm.modelsimple.f(5, localArrayList, getCallerPackage());
        continue;
        paramString1 = new com.tencent.mm.modelsimple.f(1, localArrayList, getCallerPackage());
      }
    }
    if (!bo.isNullOrNil(paramString1))
    {
      paramString2 = new Intent(this, ShareToTimeLineUI.class);
      paramString2.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(paramString1)));
      paramString2.addFlags(32768).addFlags(268435456);
      paramString2.setType("image/*");
      paramString2.setAction("android.intent.action.SEND");
      MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class).addFlags(268435456).addFlags(32768), paramString2);
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(34985);
      return;
      dNC();
    }
  }
  
  private static boolean auV(String paramString)
  {
    AppMethodBeat.i(34984);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(34984);
      return false;
    }
    boolean bool = r.aoX(paramString);
    AppMethodBeat.o(34984);
    return bool;
  }
  
  private void dNC()
  {
    AppMethodBeat.i(34987);
    Toast.makeText(this, 2131303679, 1).show();
    AppMethodBeat.o(34987);
  }
  
  private void dNZ()
  {
    AppMethodBeat.i(34983);
    Intent localIntent = getIntent();
    if (localIntent == null)
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.ShareToTimeLine", "launch : fail, intent is null");
      dNC();
      finish();
      AppMethodBeat.o(34983);
      return;
    }
    Object localObject1 = localIntent.getAction();
    Object localObject2 = w.aL(localIntent);
    if (bo.isNullOrNil((String)localObject1))
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.ShareToTimeLine", "launch : fail, action is null");
      dNC();
      finish();
      AppMethodBeat.o(34983);
      return;
    }
    String str1 = w.n(localIntent, e.j.yVi);
    String str2 = getIntent().resolveType(this);
    if (bo.isNullOrNil(str2))
    {
      dNC();
      finish();
      AppMethodBeat.o(34983);
      return;
    }
    if (!str2.contains("image"))
    {
      dNC();
      finish();
      AppMethodBeat.o(34983);
      return;
    }
    if ((((String)localObject1).equals("android.intent.action.SEND")) && (localObject2 != null))
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ShareToTimeLine", "send signal: ".concat(String.valueOf(localObject1)));
      localObject1 = ((Bundle)localObject2).getParcelable("android.intent.extra.STREAM");
      if ((localObject1 == null) || (!(localObject1 instanceof Uri)))
      {
        if (localIntent.getBooleanExtra("Ksnsupload_empty_img", false))
        {
          V(null, str1, 4);
          AppMethodBeat.o(34983);
          return;
        }
        dNC();
        finish();
        AppMethodBeat.o(34983);
        return;
      }
      localObject2 = (Uri)localObject1;
      if (!bo.o((Uri)localObject2))
      {
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.ShareToTimeLine", "deal : fail, not accept, %s", new Object[] { localObject2 });
        dNC();
        finish();
        AppMethodBeat.o(34983);
        return;
      }
      localObject1 = bo.h(this, (Uri)localObject2);
      if ((!bo.isNullOrNil((String)localObject1)) && (new com.tencent.mm.vfs.b((String)localObject1).exists())) {
        break label415;
      }
      localObject1 = com.tencent.mm.pluginsdk.i.e.a(getContentResolver(), (Uri)localObject2, 2);
    }
    label415:
    for (;;)
    {
      if ((bo.isNullOrNil((String)localObject1)) || (!bo.aqi((String)localObject1)))
      {
        if (localIntent.getBooleanExtra("Ksnsupload_empty_img", false))
        {
          V((String)localObject1, str1, 4);
          AppMethodBeat.o(34983);
          return;
        }
        dNC();
        finish();
        AppMethodBeat.o(34983);
        return;
      }
      if (auV((String)localObject1))
      {
        V((String)localObject1, str1, 0);
        AppMethodBeat.o(34983);
        return;
      }
      dNC();
      finish();
      AppMethodBeat.o(34983);
      return;
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.ShareToTimeLine", "launch : fail, uri is null");
      dNC();
      finish();
      AppMethodBeat.o(34983);
      return;
    }
  }
  
  private void showDialog()
  {
    AppMethodBeat.i(34988);
    getString(2131297087);
    this.eeN = h.b(this, getString(2131297112), true, new ShareToTimeLineUI.1(this));
    AppMethodBeat.o(34988);
  }
  
  public final boolean O(Intent paramIntent)
  {
    return true;
  }
  
  public final void a(AutoLoginActivity.a parama, Intent paramIntent)
  {
    AppMethodBeat.i(34989);
    switch (2.jLR[parama.ordinal()])
    {
    default: 
      finish();
      AppMethodBeat.o(34989);
      return;
    }
    this.intent = paramIntent;
    int i = bo.getInt(com.tencent.mm.m.g.Nq().getValue("SystemShareControlBitset"), 0);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ShareToTimeLine", "now permission = %d", new Object[] { Integer.valueOf(i) });
    if ((i & 0x2) > 0)
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.ShareToTimeLine", "now allowed to share to friend");
      finish();
      AppMethodBeat.o(34989);
      return;
    }
    parama = w.n(paramIntent, "android.intent.extra.TEXT");
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ShareToTimeLine", "postLogin, text = %s", new Object[] { parama });
    if (!bo.isNullOrNil(parama))
    {
      parama = String.format("weixin://dl/business/systemshare/?txt=%s", new Object[] { URLEncoder.encode(parama) });
      showDialog();
      aw.Rc().a(1200, this);
      parama = new com.tencent.mm.modelsimple.ab(parama, 15, null);
      aw.Rc().a(parama, 0);
      AppMethodBeat.o(34989);
      return;
    }
    dNZ();
    AppMethodBeat.o(34989);
  }
  
  public final boolean bXc()
  {
    AppMethodBeat.i(34982);
    if ((!aw.aaB()) || (aw.QP()))
    {
      com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.ShareToTimeLine", "not login");
      dNZ();
      AppMethodBeat.o(34982);
      return true;
    }
    AppMethodBeat.o(34982);
    return false;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(34986);
    aw.Rc().b(837, this);
    super.onDestroy();
    AppMethodBeat.o(34986);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(34990);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ShareToTimeLine", "onSceneEnd, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    aw.Rc().b(1200, this);
    if ((this.eeN != null) && (this.eeN.isShowing())) {
      this.eeN.dismiss();
    }
    if ((paramm instanceof com.tencent.mm.modelsimple.ab))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        dNZ();
        AppMethodBeat.o(34990);
        return;
      }
      dNC();
    }
    for (;;)
    {
      finish();
      do
      {
        AppMethodBeat.o(34990);
        return;
      } while (!(paramm instanceof com.tencent.mm.modelsimple.f));
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        if (paramm.getReqResp() == null) {
          continue;
        }
        paramString = (st)((com.tencent.mm.ai.b)paramm.getReqResp()).fsW.fta;
        if ((paramString != null) && (!bo.isNullOrNil(paramString.wLm)))
        {
          paramm = new Intent();
          paramm.putExtra("rawUrl", paramString.wLm);
          paramm.putExtra("showShare", false);
          paramm.putExtra("show_bottom", false);
          paramm.putExtra("needRedirect", false);
          d.b(this, "webview", ".ui.tools.WebViewUI", paramm);
          continue;
        }
      }
      startActivity(this.Axw);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ShareToTimeLineUI
 * JD-Core Version:    0.7.0.1
 */