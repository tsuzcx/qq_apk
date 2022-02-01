package com.tencent.mm.ui.transmit;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.av.f;
import com.tencent.mm.g.a.pw;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.modelappbrand.k;
import com.tencent.mm.modelappbrand.k.c;
import com.tencent.mm.modelsns.a.a;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXDynamicVideoMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXEnterpriseCardObject;
import com.tencent.mm.opensdk.modelmsg.WXGameVideoFileObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;
import com.tencent.mm.opensdk.modelmsg.WXWeWorkObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.c;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.c.a;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.model.l.a;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.protocal.protobuf.dzw;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.a.d.a.b;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

@com.tencent.mm.ui.base.a(3)
public class SendAppMessageWrapperUI
  extends MMActivity
{
  private com.tencent.mm.pluginsdk.model.app.g IXr;
  private boolean IXs;
  private boolean IXt;
  private boolean IXu;
  private boolean IXv;
  private au cLS;
  private String dtC;
  private int nmu;
  private WXMediaMessage nnt;
  private int qVj;
  private int scene;
  private String source;
  private p tipDialog;
  private String toUser;
  
  public SendAppMessageWrapperUI()
  {
    AppMethodBeat.i(39425);
    this.source = null;
    this.IXr = null;
    this.toUser = null;
    this.nnt = null;
    this.scene = 0;
    this.IXs = false;
    this.IXt = false;
    this.dtC = "";
    this.IXu = false;
    this.IXv = false;
    this.nmu = 0;
    this.qVj = 0;
    this.cLS = new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(39415);
        if ((SendAppMessageWrapperUI.this.getWindow() == null) || (SendAppMessageWrapperUI.this.getWindow().getDecorView() == null) || (SendAppMessageWrapperUI.this.getWindow().getDecorView().getWindowToken() == null))
        {
          if (SendAppMessageWrapperUI.a(SendAppMessageWrapperUI.this) < 10)
          {
            SendAppMessageWrapperUI.b(SendAppMessageWrapperUI.this);
            AppMethodBeat.o(39415);
            return true;
          }
          AppMethodBeat.o(39415);
          return false;
        }
        SendAppMessageWrapperUI.c(SendAppMessageWrapperUI.this);
        AppMethodBeat.o(39415);
        return false;
      }
    }, true);
    AppMethodBeat.o(39425);
  }
  
  private y.a a(final WXMediaMessage paramWXMediaMessage)
  {
    AppMethodBeat.i(39432);
    paramWXMediaMessage = new y.a()
    {
      public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(39420);
        if (paramAnonymousBoolean)
        {
          SendAppMessageWrapperUI.a(SendAppMessageWrapperUI.this, paramWXMediaMessage, paramAnonymousString, paramAnonymousInt);
          AppMethodBeat.o(39420);
          return;
        }
        SendAppMessageWrapperUI.e(SendAppMessageWrapperUI.this);
        AppMethodBeat.o(39420);
      }
    };
    AppMethodBeat.o(39432);
    return paramWXMediaMessage;
  }
  
  private static void a(k.b paramb, WXMediaMessage paramWXMediaMessage)
  {
    AppMethodBeat.i(39435);
    if ((paramb == null) || (paramWXMediaMessage == null) || (paramWXMediaMessage.mediaObject == null))
    {
      AppMethodBeat.o(39435);
      return;
    }
    if ((paramWXMediaMessage.mediaObject instanceof WXDynamicVideoMiniProgramObject))
    {
      WXDynamicVideoMiniProgramObject localWXDynamicVideoMiniProgramObject = (WXDynamicVideoMiniProgramObject)paramWXMediaMessage.mediaObject;
      com.tencent.mm.ah.a locala = new com.tencent.mm.ah.a();
      if ((paramWXMediaMessage.thumbData != null) && (paramWXMediaMessage.thumbData.length > 0))
      {
        paramWXMediaMessage = BitmapFactory.decodeByteArray(paramWXMediaMessage.thumbData, 0, paramWXMediaMessage.thumbData.length);
        if (paramWXMediaMessage != null)
        {
          locala.hgf = paramWXMediaMessage.getWidth();
          locala.hgg = paramWXMediaMessage.getHeight();
        }
      }
      locala.videoSource = localWXDynamicVideoMiniProgramObject.videoSource;
      locala.appThumbUrl = localWXDynamicVideoMiniProgramObject.appThumbUrl;
      locala.hgh = 1;
      paramb.a(locala);
      paramb.hkn = localWXDynamicVideoMiniProgramObject.disableforward;
      paramb.dvm = null;
      AppMethodBeat.o(39435);
      return;
    }
    if ((paramWXMediaMessage.mediaObject instanceof WXMiniProgramObject)) {
      paramb.hkn = ((WXMiniProgramObject)paramWXMediaMessage.mediaObject).disableforward;
    }
    AppMethodBeat.o(39435);
  }
  
  private void a(WXMediaMessage paramWXMediaMessage, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(39434);
    Object localObject1;
    if ((paramWXMediaMessage == null) || (!(paramWXMediaMessage.mediaObject instanceof WXImageObject)))
    {
      ac.w("MicroMsg.SendAppMessageWrapperUI", "sendImgMsg msg not img");
      localObject1 = null;
    }
    while (bs.isNullOrNil((String)localObject1))
    {
      ac.e("MicroMsg.SendAppMessageWrapperUI", "sendImgMsg imgPath is null");
      setResult(0);
      AppMethodBeat.o(39434);
      return;
      localObject1 = (WXImageObject)paramWXMediaMessage.mediaObject;
      if (!bs.cv(((WXImageObject)localObject1).imageData))
      {
        ac.d("MicroMsg.SendAppMessageWrapperUI", "getImagePath fileData:" + ((WXImageObject)localObject1).imageData.length);
        localObject1 = m.cb(((WXImageObject)localObject1).imageData);
      }
      else
      {
        localObject1 = ((WXImageObject)localObject1).imagePath;
      }
    }
    int j = bs.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getValue("PicCompressAvoidanceActiveSizeNormal"), 100);
    int i = j;
    if (j <= 0) {
      i = 100;
    }
    j = 1;
    long l = com.tencent.mm.vfs.i.aSp((String)localObject1);
    if ((l > 26214400L) || (l <= i * 1024)) {
      j = 0;
    }
    if ((!this.IXt) && (fuq())) {
      paramWXMediaMessage = null;
    }
    for (;;)
    {
      paramLinkedList = paramLinkedList.iterator();
      while (paramLinkedList.hasNext())
      {
        localObject2 = (String)paramLinkedList.next();
        localObject2 = new com.tencent.mm.av.l(6, u.axw(), (String)localObject2, (String)localObject1, j, null, 0, paramWXMediaMessage, "", true, 2131231565);
        az.agi().a((com.tencent.mm.ak.n)localObject2, 0);
      }
      Object localObject2 = this.IXr.field_appId;
      String str1 = paramWXMediaMessage.mediaTagName;
      String str2 = paramWXMediaMessage.messageExt;
      String str3 = paramWXMediaMessage.messageAction;
      paramWXMediaMessage = null;
      if (!bs.isNullOrNil((String)localObject2)) {
        paramWXMediaMessage = "<msg>" + f.e((String)localObject2, str1, str2, str3) + "</msg>";
      }
    }
    AppMethodBeat.o(39434);
  }
  
  private static void a(WxaAttributes paramWxaAttributes, k.b paramb)
  {
    AppMethodBeat.i(163388);
    com.tencent.mm.ah.a locala = new com.tencent.mm.ah.a();
    locala.hfZ = paramWxaAttributes.baM().jFC.ccR;
    paramb.a(locala);
    AppMethodBeat.o(163388);
  }
  
  private void aRA(String paramString)
  {
    AppMethodBeat.i(39439);
    if ("wx5dfbe0a95623607b".equals(this.IXr.field_appId))
    {
      if (this.nnt.getType() == 5)
      {
        ac.i("MicroMsg.SendAppMessageWrapperUI", "report(17256) url, to timeline, appId : %s", new Object[] { this.IXr.field_appId });
        com.tencent.mm.plugin.report.service.h.wUl.f(17256, new Object[] { paramString, Integer.valueOf(2) });
        AppMethodBeat.o(39439);
        return;
      }
      if (this.nnt.getType() == 38)
      {
        ac.i("MicroMsg.SendAppMessageWrapperUI", "report(17256) video file, to timeline, appId : %s", new Object[] { this.IXr.field_appId });
        com.tencent.mm.plugin.report.service.h.wUl.f(17256, new Object[] { paramString, Integer.valueOf(1) });
      }
    }
    AppMethodBeat.o(39439);
  }
  
  private void b(WXMediaMessage paramWXMediaMessage, final LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(39436);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(((WXVideoFileObject)paramWXMediaMessage.mediaObject).filePath);
    if (localArrayList.size() > 0)
    {
      paramWXMediaMessage = paramLinkedList.iterator();
      while (paramWXMediaMessage.hasNext())
      {
        paramLinkedList = (String)paramWXMediaMessage.next();
        ac.i("MicroMsg.SendAppMessageWrapperUI", "sendMultiVedeo");
        paramLinkedList = new com.tencent.mm.pluginsdk.model.l(this, localArrayList, getIntent(), paramLinkedList, 1, new l.a()
        {
          public final void eKI()
          {
            AppMethodBeat.i(180105);
            if (SendAppMessageWrapperUI.j(SendAppMessageWrapperUI.this) != null)
            {
              SendAppMessageWrapperUI.j(SendAppMessageWrapperUI.this).dismiss();
              SendAppMessageWrapperUI.k(SendAppMessageWrapperUI.this);
            }
            AppMethodBeat.o(180105);
          }
        });
        com.tencent.mm.sdk.g.b.c(paramLinkedList, "ChattingUI_importMultiVideo");
        getString(2131755906);
        this.tipDialog = com.tencent.mm.ui.base.h.b(this, getString(2131755936), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(180106);
            paramLinkedList.eKC();
            SendAppMessageWrapperUI.this.setResult(-1);
            SendAppMessageWrapperUI.this.finish();
            AppMethodBeat.o(180106);
          }
        });
      }
    }
    AppMethodBeat.o(39436);
  }
  
  private void bs(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(39438);
    Object localObject1 = y.ayq().F("kWXEntryActivity_data_center_session_id", true);
    if (localObject1 == null)
    {
      ac.e("MicroMsg.SendAppMessageWrapperUI", "sendWXWeworkObject fail values is null");
      AppMethodBeat.o(39438);
      return;
    }
    if (com.tencent.mm.pluginsdk.model.app.h.Wy(((WXWeWorkObject)this.nnt.mediaObject).subType) < 0)
    {
      ac.e("MicroMsg.SendAppMessageWrapperUI", "sendWXWeworkObject fail innerType < 0");
      AppMethodBeat.o(39438);
      return;
    }
    k.b localb = k.b.vA((String)((y.b)localObject1).get("kWXEntryActivity_data_center_wework_msgcontent", ""));
    if (localb != null)
    {
      localObject1 = com.tencent.mm.plugin.record.b.n.aqs(localb.hij);
      if ((localObject1 != null) && (!bs.isNullOrNil(((c)localObject1).title))) {}
      for (localObject1 = ((c)localObject1).title;; localObject1 = localb.title)
      {
        Object localObject3 = this.IXr.field_appId;
        Object localObject2 = localObject3;
        if (!this.IXt)
        {
          localObject2 = localObject3;
          if (fuq()) {
            localObject2 = "";
          }
        }
        localb.appId = ((String)localObject2);
        localb.title = getResources().getString(2131761822, new Object[] { localObject1 });
        paramLinkedList = paramLinkedList.iterator();
        while (paramLinkedList.hasNext())
        {
          localObject1 = (String)paramLinkedList.next();
          localObject2 = new pw();
          ((pw)localObject2).dsN.type = 4;
          localObject3 = new bo();
          ((bo)localObject3).setContent(k.b.a(localb, null, null));
          ((pw)localObject2).dsN.dpq = ((bo)localObject3);
          ((pw)localObject2).dsN.toUser = ((String)localObject1);
          ((pw)localObject2).dsN.dsW = true;
          com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject2);
        }
      }
    }
    ac.e("MicroMsg.SendAppMessageWrapperUI", "dealWXWeWorkObject fail msg content is null");
    AppMethodBeat.o(39438);
    return;
    AppMethodBeat.o(39438);
  }
  
  private void c(WXMediaMessage paramWXMediaMessage, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(39437);
    paramWXMediaMessage = (WXEnterpriseCardObject)paramWXMediaMessage.mediaObject;
    if ((paramWXMediaMessage.msgType != 66) && (paramWXMediaMessage.msgType != 42))
    {
      ac.e("MicroMsg.SendAppMessageWrapperUI", "sendCardMsg msgType invalid");
      setResult(0);
      finish();
      AppMethodBeat.o(39437);
      return;
    }
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      com.tencent.mm.modelmulti.i locali = new com.tencent.mm.modelmulti.i((String)paramLinkedList.next(), paramWXMediaMessage.cardInfo, paramWXMediaMessage.msgType, 0);
      az.agi().a(locali, 0);
    }
    AppMethodBeat.o(39437);
  }
  
  private boolean fuq()
  {
    AppMethodBeat.i(39428);
    ac.i("MicroMsg.SendAppMessageWrapperUI", "blockInvalidToken block %b", new Object[] { Boolean.valueOf(this.IXv) });
    boolean bool = this.IXv;
    AppMethodBeat.o(39428);
    return bool;
  }
  
  private com.tencent.mm.pluginsdk.model.app.a fur()
  {
    AppMethodBeat.i(39433);
    com.tencent.mm.pluginsdk.model.app.a locala = new com.tencent.mm.pluginsdk.model.app.a();
    if (this.IXt) {}
    for (int i = 1;; i = 0)
    {
      locala.DhJ = i;
      locala.dtC = this.dtC;
      AppMethodBeat.o(39433);
      return locala;
    }
  }
  
  private void xR(boolean paramBoolean)
  {
    AppMethodBeat.i(39427);
    if ((!this.IXt) && (fuq())) {}
    for (Intent localIntent = com.tencent.mm.modelsns.a.a(this.nmu, this.nnt, "", "", this.IXr.CC()); localIntent == null; localIntent = com.tencent.mm.modelsns.a.a(this.nmu, this.nnt, this.IXr.field_appId, this.IXr.field_appName, this.IXr.CC()))
    {
      finish();
      AppMethodBeat.o(39427);
      return;
    }
    String str = null;
    if ((this.nnt.getType() == 5) || (this.nnt.getType() == 2) || (this.nnt.getType() == 38))
    {
      ac.d("MicroMsg.SendAppMessageWrapperUI", "report(11954), to timeline, appId : %s", new Object[] { this.IXr.field_appId });
      str = y.xJ("app_" + this.IXr.field_appId);
      y.b localb = y.ayq().F(str, true);
      localb.l("prePublishId", "app_" + this.IXr.field_appId);
      if ((this.nnt.mediaObject instanceof WXWebpageObject)) {
        localb.l("url", ((WXWebpageObject)this.nnt.mediaObject).webpageUrl);
      }
    }
    aRA(str);
    localIntent.putExtra("reportSessionId", str);
    localIntent.putExtra("KSnsUploadFromSkipCompress", paramBoolean);
    localIntent.putExtra("SendAppMessageWrapper_TokenValid", this.IXt);
    localIntent.putExtra("SendAppMessageWrapper_PkgName", this.dtC);
    com.tencent.mm.br.d.b(this, "sns", ".ui.SnsUploadUI", localIntent, 1);
    AppMethodBeat.o(39427);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void initView() {}
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(39429);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ac.i("MicroMsg.SendAppMessageWrapperUI", "requestCode " + paramInt1 + " resultCode " + paramInt2);
    if (paramInt1 == 1)
    {
      if (paramInt2 == -1) {
        ReportUtil.a(this, ReportUtil.c(getIntent().getExtras(), 0), false);
      }
      for (;;)
      {
        finish();
        AppMethodBeat.o(39429);
        return;
        ReportUtil.a(this, ReportUtil.c(getIntent().getExtras(), 0), true);
      }
    }
    if ((paramInt1 == 2) && (paramInt2 == -1))
    {
      Object localObject;
      if ((this.nnt.mediaObject instanceof WXVideoFileObject))
      {
        localObject = (WXVideoFileObject)this.nnt.mediaObject;
        ((WXVideoFileObject)localObject).filePath = paramIntent.getStringExtra("K_SEGMENTVIDEOPATH");
        if ((!bs.isNullOrNil(((WXVideoFileObject)localObject).filePath)) && (com.tencent.mm.vfs.i.eA(((WXVideoFileObject)localObject).filePath)))
        {
          xR(false);
          AppMethodBeat.o(39429);
          return;
        }
        setResult(-5);
        finish();
        AppMethodBeat.o(39429);
        return;
      }
      if ((this.nnt.mediaObject instanceof WXGameVideoFileObject))
      {
        localObject = (WXGameVideoFileObject)this.nnt.mediaObject;
        ((WXGameVideoFileObject)localObject).filePath = paramIntent.getStringExtra("K_SEGMENTVIDEOPATH");
        if ((!bs.isNullOrNil(((WXGameVideoFileObject)localObject).filePath)) && (com.tencent.mm.vfs.i.eA(((WXGameVideoFileObject)localObject).filePath)))
        {
          xR(false);
          AppMethodBeat.o(39429);
          return;
        }
        setResult(-5);
        finish();
      }
    }
    AppMethodBeat.o(39429);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39426);
    super.onCreate(paramBundle);
    getSupportActionBar().hide();
    paramBundle = getSharedPreferences(ai.eUX(), 0);
    if (!paramBundle.getBoolean("settings_landscape_mode", false))
    {
      ac.d("MicroMsg.SendAppMessageWrapperUI", "change orientation");
      this.IXs = true;
      setRequestedOrientation(-1);
      paramBundle.edit().putBoolean("settings_landscape_mode", true).commit();
    }
    Bundle localBundle = getIntent().getExtras();
    Object localObject2 = new SendMessageToWX.Req(localBundle);
    this.toUser = localBundle.getString("Select_Conv_User");
    this.IXt = localBundle.getBoolean("SendAppMessageWrapper_TokenValid", true);
    this.dtC = localBundle.getString("SendAppMessageWrapper_PkgName", "");
    this.IXu = localBundle.getBoolean("SendAppMessageWrapper_NoNeedStayInWeixin", false);
    this.IXv = localBundle.getBoolean("SendAppMessageWrapper_BlockInvalidToken", false);
    this.nmu = x.getIntExtra(getIntent(), "_mmessage_sdkVersion", 0);
    this.scene = localBundle.getInt("SendAppMessageWrapper_Scene", 0);
    Object localObject1 = localBundle.getString("SendAppMessageWrapper_AppId");
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null) {
      paramBundle = Uri.parse(localBundle.getString("_mmessage_content")).getQueryParameter("appid");
    }
    this.IXr = new com.tencent.mm.pluginsdk.model.app.g();
    this.IXr.field_appId = paramBundle;
    ap.dny().get(this.IXr, new String[0]);
    if (this.IXr.field_appName == null) {}
    boolean bool;
    for (paramBundle = getString(2131757565);; paramBundle = com.tencent.mm.pluginsdk.model.app.h.a(getContext(), this.IXr, null))
    {
      this.source = getString(2131757563, new Object[] { paramBundle });
      this.nnt = ((SendMessageToWX.Req)localObject2).message;
      bool = getIntent().getBooleanExtra("SendAppMessageWrapper_SkipCompressVideo", false);
      ac.i("MicroMsg.SendAppMessageWrapperUI", "onCreate, messageAction = %s, messageExt = %s, skipCompress = %b", new Object[] { this.nnt.messageAction, this.nnt.messageExt, Boolean.valueOf(bool) });
      if (this.scene != 1) {
        break label1289;
      }
      if (this.nnt.mediaObject != null) {
        break;
      }
      finish();
      AppMethodBeat.o(39426);
      return;
    }
    if (this.nnt.getType() == 38)
    {
      localObject2 = (WXVideoFileObject)this.nnt.mediaObject;
      localObject1 = this.nnt.messageExt;
      paramBundle = ((WXVideoFileObject)localObject2).filePath;
      if ((bs.isNullOrNil(((WXVideoFileObject)localObject2).filePath)) || (!com.tencent.mm.vfs.i.eA(((WXVideoFileObject)localObject2).filePath))) {
        finish();
      }
      if (bool)
      {
        if ((!bs.isNullOrNil(((WXVideoFileObject)localObject2).filePath)) && (com.tencent.mm.vfs.i.eA(((WXVideoFileObject)localObject2).filePath)))
        {
          paramBundle = ((WXVideoFileObject)localObject2).filePath;
          if (paramBundle != null)
          {
            paramBundle = new File(paramBundle);
            if (!paramBundle.exists()) {}
          }
          for (paramBundle = com.tencent.xweb.util.d.ag(paramBundle); bs.lr((String)localObject1, paramBundle); paramBundle = null)
          {
            xR(bool);
            AppMethodBeat.o(39426);
            return;
          }
        }
        setResult(-5);
        finish();
        AppMethodBeat.o(39426);
        return;
      }
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("K_SEGMENTVIDEOPATH", paramBundle);
      ((Intent)localObject1).putExtra("KSEGMENTVIDEOTHUMBPATH", "");
      com.tencent.mm.br.d.b(this, "mmsight", ".segment.VideoCompressUI", (Intent)localObject1, 2);
      AppMethodBeat.o(39426);
      return;
    }
    if (this.nnt.getType() == 39)
    {
      paramBundle = (WXGameVideoFileObject)this.nnt.mediaObject;
      if (bool)
      {
        if ((!bs.isNullOrNil(paramBundle.filePath)) && (com.tencent.mm.vfs.i.eA(paramBundle.filePath)))
        {
          paramBundle = paramBundle.filePath;
          int i = com.tencent.mm.m.g.ZY().getInt("ShareVideoMaxSize", 104857600);
          if (com.tencent.mm.vfs.i.aSp(paramBundle) > i)
          {
            ac.e("MicroMsg.ShareSnsImpl", "file len too big ");
            i = 1;
            if (i == 0) {
              break label732;
            }
            i = 1;
          }
          for (;;)
          {
            if (i != 0) {
              break label1196;
            }
            xR(bool);
            AppMethodBeat.o(39426);
            return;
            i = 0;
            break;
            label732:
            paramBundle = a.a.Dm(paramBundle);
            if ((paramBundle.videoWidth <= 0) || (paramBundle.videoHeight <= 0) || (paramBundle.videoWidth / paramBundle.videoHeight > 3.0F) || (paramBundle.videoWidth / paramBundle.videoHeight < 0.5F))
            {
              ac.i("MicroMsg.ShareSnsImpl", "check ratio faild width = [%d], height = [%d]", new Object[] { Integer.valueOf(paramBundle.videoWidth), Integer.valueOf(paramBundle.videoHeight) });
              i = 1;
              label822:
              if (i == 0)
              {
                ac.d("MicroMsg.ShareSnsImpl", "checkFormat() called with: item = [%s]", new Object[] { paramBundle });
                if (!bs.isNullOrNil(paramBundle.hTt))
                {
                  localObject1 = paramBundle.hTt;
                  if (!bs.isNullOrNil((String)localObject1)) {
                    break label971;
                  }
                  i = 1;
                  label869:
                  if ((i == 0) && ("video/avc".equalsIgnoreCase(paramBundle.hTu)) && ((bs.isNullOrNil(paramBundle.hTv)) || ("audio/mp4a-latm".equalsIgnoreCase(paramBundle.hTv)))) {
                    break label1186;
                  }
                }
                ac.i("MicroMsg.ShareSnsImpl", "check video format failed, dst format [video/avc], video format [%s]", new Object[] { paramBundle.hTu });
                ac.i("MicroMsg.ShareSnsImpl", "check video format failed, dst audioTrackMime [%s], video audioTrackMime [%s]", new Object[] { "audio/mp4a-latm", paramBundle.hTv });
              }
            }
            label1186:
            for (i = 1;; i = 0)
            {
              if (i == 0) {
                break label1191;
              }
              i = 1;
              break;
              i = 0;
              break label822;
              label971:
              if (com.tencent.mm.modelsns.a.hTs == null)
              {
                localObject2 = new HashSet();
                com.tencent.mm.modelsns.a.hTs = (Set)localObject2;
                ((Set)localObject2).add(".h264");
                com.tencent.mm.modelsns.a.hTs.add(".h26l");
                com.tencent.mm.modelsns.a.hTs.add(".264");
                com.tencent.mm.modelsns.a.hTs.add(".avc");
                com.tencent.mm.modelsns.a.hTs.add(".mov");
                com.tencent.mm.modelsns.a.hTs.add(".mp4");
                com.tencent.mm.modelsns.a.hTs.add(".m4a");
                com.tencent.mm.modelsns.a.hTs.add(".3gp");
                com.tencent.mm.modelsns.a.hTs.add(".3g2");
                com.tencent.mm.modelsns.a.hTs.add(".mj2");
                com.tencent.mm.modelsns.a.hTs.add(".m4v");
              }
              localObject1 = ((String)localObject1).trim();
              i = ((String)localObject1).lastIndexOf(".");
              if ((i < 0) || (i >= ((String)localObject1).length()))
              {
                i = 1;
                break label869;
              }
              if (!com.tencent.mm.modelsns.a.hTs.contains(((String)localObject1).substring(i).toLowerCase()))
              {
                i = 1;
                break label869;
              }
              i = 0;
              break label869;
            }
            label1191:
            i = 0;
          }
        }
        label1196:
        ReportUtil.a(this, ReportUtil.c(getIntent().getExtras(), -5), false);
        finish();
        AppMethodBeat.o(39426);
        return;
      }
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("K_SEGMENTVIDEOPATH", paramBundle.filePath);
      ((Intent)localObject1).putExtra("KSEGMENTVIDEOTHUMBPATH", "");
      com.tencent.mm.br.d.b(this, "mmsight", ".segment.VideoCompressUI", (Intent)localObject1, 2);
      AppMethodBeat.o(39426);
      return;
    }
    xR(bool);
    AppMethodBeat.o(39426);
    return;
    label1289:
    this.cLS.au(100L, 100L);
    AppMethodBeat.o(39426);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(39430);
    super.onDestroy();
    if (this.IXs)
    {
      ac.d("MicroMsg.SendAppMessageWrapperUI", "restore orientation");
      SharedPreferences localSharedPreferences = getSharedPreferences(ai.eUX(), 0);
      setRequestedOrientation(1);
      localSharedPreferences.edit().putBoolean("settings_landscape_mode", false).commit();
    }
    AppMethodBeat.o(39430);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(39431);
    hideVKB();
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(39431);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SendAppMessageWrapperUI
 * JD-Core Version:    0.7.0.1
 */