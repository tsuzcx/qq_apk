package com.tencent.mm.ui.tools;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import com.jg.JgClassChecked;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.m.e;
import com.tencent.mm.model.au;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.protocal.c.pp;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.e.h;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@JgClassChecked(author=20, fComment="checked", lastDate="20140422", reviewer=20, vComment={com.jg.EType.ACTIVITYCHECK})
public class ShareToTimeLineUI
  extends AutoLoginActivity
  implements f
{
  private ProgressDialog dnm = null;
  private Intent intent;
  private Intent weG;
  
  private void M(String paramString1, String paramString2, int paramInt)
  {
    Intent localIntent = new Intent();
    ArrayList localArrayList = new ArrayList();
    if (!bk.bl(paramString1))
    {
      localIntent.putExtra("sns_kemdia_path", paramString1);
      localIntent.putExtra("KFilterId", -1);
      localArrayList.add(paramString1);
    }
    if (!bk.bl(paramString2)) {
      localIntent.putExtra(e.h.uHV, paramString2);
    }
    if ((paramInt == 4) && (bk.bl(paramString1)) && (!bk.bl(paramString2))) {
      localArrayList.add(paramString2);
    }
    if ((au.Hz()) && (!au.CW()))
    {
      localIntent.putExtra("K_go_to_SnsTimeLineUI", true);
      localIntent.putExtra("Ksnsupload_source", 12);
      if (paramInt == 0) {
        localIntent.putExtra("KBlockAdd", true);
      }
      localIntent.setClassName(this, "com.tencent.mm.plugin.sns.ui.SnsUploadUI");
      this.weG = localIntent;
      paramString1 = null;
      switch (paramInt)
      {
      }
      for (;;)
      {
        if (paramString1 != null)
        {
          au.Dk().a(837, this);
          com.tencent.mm.kernel.g.Dk().a(paramString1, 0);
          showDialog();
        }
        return;
        paramString1 = new com.tencent.mm.modelsimple.d(5, localArrayList, czt());
        continue;
        paramString1 = new com.tencent.mm.modelsimple.d(1, localArrayList, czt());
      }
    }
    if (!bk.bl(paramString1))
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
      return;
      cIO();
    }
  }
  
  private static boolean aef(String paramString)
  {
    boolean bool1;
    if ((paramString == null) || (paramString.length() == 0)) {
      bool1 = false;
    }
    MMBitmapFactory.DecodeResultLogger localDecodeResultLogger;
    boolean bool2;
    do
    {
      do
      {
        return bool1;
        localDecodeResultLogger = new MMBitmapFactory.DecodeResultLogger();
        bool2 = o.a(paramString, localDecodeResultLogger);
        bool1 = bool2;
      } while (bool2);
      bool1 = bool2;
    } while (localDecodeResultLogger.getDecodeResult() < 2000);
    paramString = MMBitmapFactory.KVStatHelper.getKVStatString(paramString, 4, localDecodeResultLogger);
    com.tencent.mm.plugin.report.service.h.nFQ.aC(12712, paramString);
    return bool2;
  }
  
  private ArrayList<String> ar(Bundle paramBundle)
  {
    Object localObject1 = paramBundle.getParcelableArrayList("android.intent.extra.STREAM");
    if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
    {
      paramBundle = new ArrayList();
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Uri)((Iterator)localObject1).next();
        if ((localObject2 != null) && (bk.m((Uri)localObject2)) && (((Uri)localObject2).getScheme() != null))
        {
          localObject2 = bk.h(this, (Uri)localObject2);
          if (!bk.bl((String)localObject2)) {
            if (aef((String)localObject2))
            {
              y.i("MicroMsg.ShareToTimeLine", "multisend file path: " + (String)localObject2);
              paramBundle.add(localObject2);
            }
            else
            {
              y.w("MicroMsg.ShareToTimeLine", "not image: " + (String)localObject2);
            }
          }
        }
        else
        {
          y.e("MicroMsg.ShareToTimeLine", "unaccepted uri: " + localObject2);
        }
      }
      if (paramBundle.size() > 0) {
        return paramBundle;
      }
      return null;
    }
    y.e("MicroMsg.ShareToTimeLine", "getParcelableArrayList failed");
    return null;
  }
  
  private void cIO()
  {
    Toast.makeText(this, R.l.shareimg_to_timeline_get_res_fail, 1).show();
  }
  
  private void cJk()
  {
    Intent localIntent = getIntent();
    if (localIntent == null)
    {
      y.e("MicroMsg.ShareToTimeLine", "launch : fail, intent is null");
      cIO();
      finish();
      return;
    }
    Object localObject1 = localIntent.getAction();
    Object localObject2 = t.al(localIntent);
    if (bk.bl((String)localObject1))
    {
      y.e("MicroMsg.ShareToTimeLine", "launch : fail, action is null");
      cIO();
      finish();
      return;
    }
    String str1 = t.j(localIntent, e.h.uHV);
    String str2 = getIntent().resolveType(this);
    if (bk.bl(str2))
    {
      cIO();
      finish();
      return;
    }
    if (!str2.contains("image"))
    {
      cIO();
      finish();
      return;
    }
    if ((((String)localObject1).equals("android.intent.action.SEND")) && (localObject2 != null))
    {
      y.i("MicroMsg.ShareToTimeLine", "send signal: " + (String)localObject1);
      localObject1 = ((Bundle)localObject2).getParcelable("android.intent.extra.STREAM");
      if ((localObject1 == null) || (!(localObject1 instanceof Uri)))
      {
        if (localIntent.getBooleanExtra("Ksnsupload_empty_img", false))
        {
          M(null, str1, 4);
          return;
        }
        cIO();
        finish();
        return;
      }
      localObject2 = (Uri)localObject1;
      if (!bk.m((Uri)localObject2))
      {
        y.e("MicroMsg.ShareToTimeLine", "deal : fail, not accept, %s", new Object[] { localObject2 });
        cIO();
        finish();
        return;
      }
      localObject1 = bk.h(this, (Uri)localObject2);
      if (!bk.bl((String)localObject1)) {
        break label482;
      }
      localObject1 = com.tencent.mm.pluginsdk.i.d.a(getContentResolver(), (Uri)localObject2, 2);
    }
    label482:
    for (;;)
    {
      if ((bk.bl((String)localObject1)) || (!bk.aae((String)localObject1)))
      {
        if (localIntent.getBooleanExtra("Ksnsupload_empty_img", false))
        {
          M((String)localObject1, str1, 4);
          return;
        }
        cIO();
        finish();
        return;
      }
      if (aef((String)localObject1))
      {
        M((String)localObject1, str1, 0);
        return;
      }
      cIO();
      finish();
      return;
      if ((((String)localObject1).equals("android.intent.action.SEND_MULTIPLE")) && (localObject2 != null) && (((Bundle)localObject2).containsKey("android.intent.extra.STREAM")))
      {
        y.i("MicroMsg.ShareToTimeLine", "send multi: " + (String)localObject1);
        localObject1 = ar((Bundle)localObject2);
        if ((localObject1 == null) || (((ArrayList)localObject1).size() == 0))
        {
          cIO();
          finish();
          return;
        }
        if (((ArrayList)localObject1).size() > 1)
        {
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("sharePictureTo", "sns");
          ((Intent)localObject1).setClassName(this, "com.tencent.mm.ui.transmit.SelectNoSupportUI");
          this.weG = ((Intent)localObject1);
          startActivity(this.weG);
          finish();
          return;
        }
        f((ArrayList)localObject1, str1);
        return;
      }
      y.e("MicroMsg.ShareToTimeLine", "launch : fail, uri is null");
      cIO();
      finish();
      return;
    }
  }
  
  private void f(ArrayList<String> paramArrayList, String paramString)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      finish();
      return;
    }
    if (paramArrayList.size() > 9) {
      paramArrayList.subList(9, paramArrayList.size()).clear();
    }
    if ((au.Hz()) && (!au.CW()))
    {
      localObject = new Intent();
      ((Intent)localObject).putStringArrayListExtra("sns_kemdia_path_list", paramArrayList);
      if (!bk.bl(paramString)) {
        ((Intent)localObject).putExtra(e.h.uHV, paramString);
      }
      ((Intent)localObject).putExtra("K_go_to_SnsTimeLineUI", true);
      ((Intent)localObject).putExtra("Ksnsupload_source", 12);
      ((Intent)localObject).setClassName(this, "com.tencent.mm.plugin.sns.ui.SnsUploadUI");
      this.weG = ((Intent)localObject);
      paramArrayList = new com.tencent.mm.modelsimple.d(1, paramArrayList, czt());
      au.Dk().a(837, this);
      com.tencent.mm.kernel.g.Dk().a(paramArrayList, 0);
      showDialog();
      return;
    }
    paramString = new Intent(this, ShareToTimeLineUI.class);
    Object localObject = new ArrayList(paramArrayList.size());
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      ((ArrayList)localObject).add(Uri.fromFile(new File((String)paramArrayList.next())));
    }
    paramString.putParcelableArrayListExtra("android.intent.extra.STREAM", (ArrayList)localObject);
    paramString.setAction("android.intent.action.SEND_MULTIPLE");
    paramString.addFlags(32768).addFlags(268435456);
    paramString.setType("image/*");
    MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class).addFlags(268435456).addFlags(32768), paramString);
    finish();
  }
  
  private void showDialog()
  {
    getString(R.l.app_tip);
    this.dnm = com.tencent.mm.ui.base.h.b(this, getString(R.l.app_waiting), true, new ShareToTimeLineUI.1(this));
  }
  
  protected final void a(AutoLoginActivity.a parama, Intent paramIntent)
  {
    switch (ShareToTimeLineUI.2.hSj[parama.ordinal()])
    {
    default: 
      finish();
      return;
    }
    this.intent = paramIntent;
    int i = bk.getInt(com.tencent.mm.m.g.AA().getValue("SystemShareControlBitset"), 0);
    y.i("MicroMsg.ShareToTimeLine", "now permission = %d", new Object[] { Integer.valueOf(i) });
    if ((i & 0x2) > 0)
    {
      y.e("MicroMsg.ShareToTimeLine", "now allowed to share to friend");
      finish();
      return;
    }
    parama = t.j(paramIntent, "android.intent.extra.TEXT");
    y.i("MicroMsg.ShareToTimeLine", "postLogin, text = %s", new Object[] { parama });
    if (!bk.bl(parama))
    {
      parama = String.format("weixin://dl/business/systemshare/?txt=%s", new Object[] { URLEncoder.encode(parama) });
      showDialog();
      au.Dk().a(1200, this);
      parama = new aa(parama, 15, null);
      au.Dk().a(parama, 0);
      return;
    }
    cJk();
  }
  
  protected final boolean boC()
  {
    if ((!au.Hz()) || (au.CW()))
    {
      y.w("MicroMsg.ShareToTimeLine", "not login");
      cJk();
      return true;
    }
    return false;
  }
  
  protected void onDestroy()
  {
    au.Dk().b(837, this);
    super.onDestroy();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.ShareToTimeLine", "onSceneEnd, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    au.Dk().b(1200, this);
    if ((this.dnm != null) && (this.dnm.isShowing())) {
      this.dnm.dismiss();
    }
    if ((paramm instanceof aa))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        cJk();
        return;
      }
      cIO();
    }
    for (;;)
    {
      finish();
      return;
      if (!(paramm instanceof com.tencent.mm.modelsimple.d)) {
        break;
      }
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        if (paramm.edi == null) {
          continue;
        }
        paramString = (pp)((b)paramm.edi).ecF.ecN;
        if ((paramString != null) && (!bk.bl(paramString.sNw)))
        {
          paramm = new Intent();
          paramm.putExtra("rawUrl", paramString.sNw);
          paramm.putExtra("showShare", false);
          paramm.putExtra("show_bottom", false);
          paramm.putExtra("needRedirect", false);
          com.tencent.mm.br.d.b(this, "webview", ".ui.tools.WebViewUI", paramm);
          continue;
        }
      }
      startActivity(this.weG);
    }
  }
  
  protected final boolean w(Intent paramIntent)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ShareToTimeLineUI
 * JD-Core Version:    0.7.0.1
 */