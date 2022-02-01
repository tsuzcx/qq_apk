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
import com.tencent.mm.ai.k.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.q;
import com.tencent.mm.al.x.a;
import com.tencent.mm.aw.f;
import com.tencent.mm.g.a.pn;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
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
import com.tencent.mm.protocal.protobuf.duf;
import com.tencent.mm.protocal.protobuf.dun;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
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
  private com.tencent.mm.pluginsdk.model.app.g HwU;
  private boolean HwV;
  private boolean HwW;
  private boolean HwX;
  private boolean HwY;
  private av cOx;
  private String dvP;
  private int mKl;
  private WXMediaMessage mLk;
  private int qmH;
  private int scene;
  private String source;
  private p tipDialog;
  private String toUser;
  
  public SendAppMessageWrapperUI()
  {
    AppMethodBeat.i(39425);
    this.source = null;
    this.HwU = null;
    this.toUser = null;
    this.mLk = null;
    this.scene = 0;
    this.HwV = false;
    this.HwW = false;
    this.dvP = "";
    this.HwX = false;
    this.HwY = false;
    this.mKl = 0;
    this.qmH = 0;
    this.cOx = new av(new av.a()
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
      com.tencent.mm.ai.a locala = new com.tencent.mm.ai.a();
      if ((paramWXMediaMessage.thumbData != null) && (paramWXMediaMessage.thumbData.length > 0))
      {
        paramWXMediaMessage = BitmapFactory.decodeByteArray(paramWXMediaMessage.thumbData, 0, paramWXMediaMessage.thumbData.length);
        if (paramWXMediaMessage != null)
        {
          locala.gFE = paramWXMediaMessage.getWidth();
          locala.gFF = paramWXMediaMessage.getHeight();
        }
      }
      locala.videoSource = localWXDynamicVideoMiniProgramObject.videoSource;
      locala.appThumbUrl = localWXDynamicVideoMiniProgramObject.appThumbUrl;
      locala.gFG = 1;
      paramb.a(locala);
      paramb.gJN = localWXDynamicVideoMiniProgramObject.disableforward;
      paramb.dxA = null;
      AppMethodBeat.o(39435);
      return;
    }
    if ((paramWXMediaMessage.mediaObject instanceof WXMiniProgramObject)) {
      paramb.gJN = ((WXMiniProgramObject)paramWXMediaMessage.mediaObject).disableforward;
    }
    AppMethodBeat.o(39435);
  }
  
  private void a(WXMediaMessage paramWXMediaMessage, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(39434);
    Object localObject1;
    if ((paramWXMediaMessage == null) || (!(paramWXMediaMessage.mediaObject instanceof WXImageObject)))
    {
      ad.w("MicroMsg.SendAppMessageWrapperUI", "sendImgMsg msg not img");
      localObject1 = null;
    }
    while (bt.isNullOrNil((String)localObject1))
    {
      ad.e("MicroMsg.SendAppMessageWrapperUI", "sendImgMsg imgPath is null");
      setResult(0);
      AppMethodBeat.o(39434);
      return;
      localObject1 = (WXImageObject)paramWXMediaMessage.mediaObject;
      if (!bt.cw(((WXImageObject)localObject1).imageData))
      {
        ad.d("MicroMsg.SendAppMessageWrapperUI", "getImagePath fileData:" + ((WXImageObject)localObject1).imageData.length);
        localObject1 = m.cc(((WXImageObject)localObject1).imageData);
      }
      else
      {
        localObject1 = ((WXImageObject)localObject1).imagePath;
      }
    }
    int j = bt.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getValue("PicCompressAvoidanceActiveSizeNormal"), 100);
    int i = j;
    if (j <= 0) {
      i = 100;
    }
    j = 1;
    long l = com.tencent.mm.vfs.i.aMN((String)localObject1);
    if ((l > 26214400L) || (l <= i * 1024)) {
      j = 0;
    }
    if ((!this.HwW) && (fev())) {
      paramWXMediaMessage = null;
    }
    for (;;)
    {
      paramLinkedList = paramLinkedList.iterator();
      while (paramLinkedList.hasNext())
      {
        localObject2 = (String)paramLinkedList.next();
        localObject2 = new com.tencent.mm.aw.l(6, u.aqG(), (String)localObject2, (String)localObject1, j, null, 0, paramWXMediaMessage, "", true, 2131231565);
        az.aeS().a((com.tencent.mm.al.n)localObject2, 0);
      }
      Object localObject2 = this.HwU.field_appId;
      String str1 = paramWXMediaMessage.mediaTagName;
      String str2 = paramWXMediaMessage.messageExt;
      String str3 = paramWXMediaMessage.messageAction;
      paramWXMediaMessage = null;
      if (!bt.isNullOrNil((String)localObject2)) {
        paramWXMediaMessage = "<msg>" + f.c((String)localObject2, str1, str2, str3) + "</msg>";
      }
    }
    AppMethodBeat.o(39434);
  }
  
  private static void a(WxaAttributes paramWxaAttributes, k.b paramb)
  {
    AppMethodBeat.i(163388);
    com.tencent.mm.ai.a locala = new com.tencent.mm.ai.a();
    locala.gFy = paramWxaAttributes.aTO().jfn.cfU;
    paramb.a(locala);
    AppMethodBeat.o(163388);
  }
  
  private void aLY(String paramString)
  {
    AppMethodBeat.i(39439);
    if ("wx5dfbe0a95623607b".equals(this.HwU.field_appId))
    {
      if (this.mLk.getType() == 5)
      {
        ad.i("MicroMsg.SendAppMessageWrapperUI", "report(17256) url, to timeline, appId : %s", new Object[] { this.HwU.field_appId });
        com.tencent.mm.plugin.report.service.h.vKh.f(17256, new Object[] { paramString, Integer.valueOf(2) });
        AppMethodBeat.o(39439);
        return;
      }
      if (this.mLk.getType() == 38)
      {
        ad.i("MicroMsg.SendAppMessageWrapperUI", "report(17256) video file, to timeline, appId : %s", new Object[] { this.HwU.field_appId });
        com.tencent.mm.plugin.report.service.h.vKh.f(17256, new Object[] { paramString, Integer.valueOf(1) });
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
        ad.i("MicroMsg.SendAppMessageWrapperUI", "sendMultiVedeo");
        paramLinkedList = new com.tencent.mm.pluginsdk.model.l(this, localArrayList, getIntent(), paramLinkedList, 1, new l.a()
        {
          public final void evo()
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
            paramLinkedList.evi();
            SendAppMessageWrapperUI.this.setResult(-1);
            SendAppMessageWrapperUI.this.finish();
            AppMethodBeat.o(180106);
          }
        });
      }
    }
    AppMethodBeat.o(39436);
  }
  
  private void bl(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(39438);
    Object localObject1 = com.tencent.mm.model.y.arz().E("kWXEntryActivity_data_center_session_id", true);
    if (localObject1 == null)
    {
      ad.e("MicroMsg.SendAppMessageWrapperUI", "sendWXWeworkObject fail values is null");
      AppMethodBeat.o(39438);
      return;
    }
    if (com.tencent.mm.pluginsdk.model.app.h.Uo(((WXWeWorkObject)this.mLk.mediaObject).subType) < 0)
    {
      ad.e("MicroMsg.SendAppMessageWrapperUI", "sendWXWeworkObject fail innerType < 0");
      AppMethodBeat.o(39438);
      return;
    }
    k.b localb = k.b.rx((String)((y.b)localObject1).get("kWXEntryActivity_data_center_wework_msgcontent", ""));
    if (localb != null)
    {
      localObject1 = com.tencent.mm.plugin.record.b.n.alt(localb.gHI);
      if ((localObject1 != null) && (!bt.isNullOrNil(((c)localObject1).title))) {}
      for (localObject1 = ((c)localObject1).title;; localObject1 = localb.title)
      {
        Object localObject3 = this.HwU.field_appId;
        Object localObject2 = localObject3;
        if (!this.HwW)
        {
          localObject2 = localObject3;
          if (fev()) {
            localObject2 = "";
          }
        }
        localb.appId = ((String)localObject2);
        localb.title = getResources().getString(2131761822, new Object[] { localObject1 });
        paramLinkedList = paramLinkedList.iterator();
        while (paramLinkedList.hasNext())
        {
          localObject1 = (String)paramLinkedList.next();
          localObject2 = new pn();
          ((pn)localObject2).dvb.type = 4;
          localObject3 = new bl();
          ((bl)localObject3).setContent(k.b.a(localb, null, null));
          ((pn)localObject2).dvb.drF = ((bl)localObject3);
          ((pn)localObject2).dvb.toUser = ((String)localObject1);
          ((pn)localObject2).dvb.dvk = true;
          com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject2);
        }
      }
    }
    ad.e("MicroMsg.SendAppMessageWrapperUI", "dealWXWeWorkObject fail msg content is null");
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
      ad.e("MicroMsg.SendAppMessageWrapperUI", "sendCardMsg msgType invalid");
      setResult(0);
      finish();
      AppMethodBeat.o(39437);
      return;
    }
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      com.tencent.mm.modelmulti.i locali = new com.tencent.mm.modelmulti.i((String)paramLinkedList.next(), paramWXMediaMessage.cardInfo, paramWXMediaMessage.msgType, 0);
      az.aeS().a(locali, 0);
    }
    AppMethodBeat.o(39437);
  }
  
  private boolean fev()
  {
    AppMethodBeat.i(39428);
    ad.i("MicroMsg.SendAppMessageWrapperUI", "blockInvalidToken block %b", new Object[] { Boolean.valueOf(this.HwY) });
    boolean bool = this.HwY;
    AppMethodBeat.o(39428);
    return bool;
  }
  
  private com.tencent.mm.pluginsdk.model.app.a few()
  {
    AppMethodBeat.i(39433);
    com.tencent.mm.pluginsdk.model.app.a locala = new com.tencent.mm.pluginsdk.model.app.a();
    if (this.HwW) {}
    for (int i = 1;; i = 0)
    {
      locala.BPv = i;
      locala.dvP = this.dvP;
      AppMethodBeat.o(39433);
      return locala;
    }
  }
  
  private void wK(boolean paramBoolean)
  {
    AppMethodBeat.i(39427);
    if ((!this.HwW) && (fev())) {}
    for (Intent localIntent = com.tencent.mm.modelsns.a.a(this.mKl, this.mLk, "", "", this.HwU.CZ()); localIntent == null; localIntent = com.tencent.mm.modelsns.a.a(this.mKl, this.mLk, this.HwU.field_appId, this.HwU.field_appName, this.HwU.CZ()))
    {
      finish();
      AppMethodBeat.o(39427);
      return;
    }
    String str = null;
    if ((this.mLk.getType() == 5) || (this.mLk.getType() == 2) || (this.mLk.getType() == 38))
    {
      ad.d("MicroMsg.SendAppMessageWrapperUI", "report(11954), to timeline, appId : %s", new Object[] { this.HwU.field_appId });
      str = com.tencent.mm.model.y.tD("app_" + this.HwU.field_appId);
      y.b localb = com.tencent.mm.model.y.arz().E(str, true);
      localb.m("prePublishId", "app_" + this.HwU.field_appId);
      if ((this.mLk.mediaObject instanceof WXWebpageObject)) {
        localb.m("url", ((WXWebpageObject)this.mLk.mediaObject).webpageUrl);
      }
    }
    aLY(str);
    localIntent.putExtra("reportSessionId", str);
    localIntent.putExtra("KSnsUploadFromSkipCompress", paramBoolean);
    localIntent.putExtra("SendAppMessageWrapper_TokenValid", this.HwW);
    localIntent.putExtra("SendAppMessageWrapper_PkgName", this.dvP);
    com.tencent.mm.bs.d.b(this, "sns", ".ui.SnsUploadUI", localIntent, 1);
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
    ad.i("MicroMsg.SendAppMessageWrapperUI", "requestCode " + paramInt1 + " resultCode " + paramInt2);
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
      if ((this.mLk.mediaObject instanceof WXVideoFileObject))
      {
        localObject = (WXVideoFileObject)this.mLk.mediaObject;
        ((WXVideoFileObject)localObject).filePath = paramIntent.getStringExtra("K_SEGMENTVIDEOPATH");
        if ((!bt.isNullOrNil(((WXVideoFileObject)localObject).filePath)) && (com.tencent.mm.vfs.i.eK(((WXVideoFileObject)localObject).filePath)))
        {
          wK(false);
          AppMethodBeat.o(39429);
          return;
        }
        setResult(-5);
        finish();
        AppMethodBeat.o(39429);
        return;
      }
      if ((this.mLk.mediaObject instanceof WXGameVideoFileObject))
      {
        localObject = (WXGameVideoFileObject)this.mLk.mediaObject;
        ((WXGameVideoFileObject)localObject).filePath = paramIntent.getStringExtra("K_SEGMENTVIDEOPATH");
        if ((!bt.isNullOrNil(((WXGameVideoFileObject)localObject).filePath)) && (com.tencent.mm.vfs.i.eK(((WXGameVideoFileObject)localObject).filePath)))
        {
          wK(false);
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
    paramBundle = getSharedPreferences(aj.eFD(), 0);
    if (!paramBundle.getBoolean("settings_landscape_mode", false))
    {
      ad.d("MicroMsg.SendAppMessageWrapperUI", "change orientation");
      this.HwV = true;
      setRequestedOrientation(-1);
      paramBundle.edit().putBoolean("settings_landscape_mode", true).commit();
    }
    Bundle localBundle = getIntent().getExtras();
    Object localObject2 = new SendMessageToWX.Req(localBundle);
    this.toUser = localBundle.getString("Select_Conv_User");
    this.HwW = localBundle.getBoolean("SendAppMessageWrapper_TokenValid", true);
    this.dvP = localBundle.getString("SendAppMessageWrapper_PkgName", "");
    this.HwX = localBundle.getBoolean("SendAppMessageWrapper_NoNeedStayInWeixin", false);
    this.HwY = localBundle.getBoolean("SendAppMessageWrapper_BlockInvalidToken", false);
    this.mKl = com.tencent.mm.sdk.platformtools.y.getIntExtra(getIntent(), "_mmessage_sdkVersion", 0);
    this.scene = localBundle.getInt("SendAppMessageWrapper_Scene", 0);
    Object localObject1 = localBundle.getString("SendAppMessageWrapper_AppId");
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null) {
      paramBundle = Uri.parse(localBundle.getString("_mmessage_content")).getQueryParameter("appid");
    }
    this.HwU = new com.tencent.mm.pluginsdk.model.app.g();
    this.HwU.field_appId = paramBundle;
    ap.cZQ().get(this.HwU, new String[0]);
    if (this.HwU.field_appName == null) {}
    boolean bool;
    for (paramBundle = getString(2131757565);; paramBundle = com.tencent.mm.pluginsdk.model.app.h.a(getContext(), this.HwU, null))
    {
      this.source = getString(2131757563, new Object[] { paramBundle });
      this.mLk = ((SendMessageToWX.Req)localObject2).message;
      bool = getIntent().getBooleanExtra("SendAppMessageWrapper_SkipCompressVideo", false);
      ad.i("MicroMsg.SendAppMessageWrapperUI", "onCreate, messageAction = %s, messageExt = %s, skipCompress = %b", new Object[] { this.mLk.messageAction, this.mLk.messageExt, Boolean.valueOf(bool) });
      if (this.scene != 1) {
        break label1289;
      }
      if (this.mLk.mediaObject != null) {
        break;
      }
      finish();
      AppMethodBeat.o(39426);
      return;
    }
    if (this.mLk.getType() == 38)
    {
      localObject2 = (WXVideoFileObject)this.mLk.mediaObject;
      localObject1 = this.mLk.messageExt;
      paramBundle = ((WXVideoFileObject)localObject2).filePath;
      if ((bt.isNullOrNil(((WXVideoFileObject)localObject2).filePath)) || (!com.tencent.mm.vfs.i.eK(((WXVideoFileObject)localObject2).filePath))) {
        finish();
      }
      if (bool)
      {
        if ((!bt.isNullOrNil(((WXVideoFileObject)localObject2).filePath)) && (com.tencent.mm.vfs.i.eK(((WXVideoFileObject)localObject2).filePath)))
        {
          paramBundle = ((WXVideoFileObject)localObject2).filePath;
          if (paramBundle != null)
          {
            paramBundle = new File(paramBundle);
            if (!paramBundle.exists()) {}
          }
          for (paramBundle = com.tencent.xweb.util.d.ac(paramBundle); bt.kU((String)localObject1, paramBundle); paramBundle = null)
          {
            wK(bool);
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
      com.tencent.mm.bs.d.b(this, "mmsight", ".segment.VideoCompressUI", (Intent)localObject1, 2);
      AppMethodBeat.o(39426);
      return;
    }
    if (this.mLk.getType() == 39)
    {
      paramBundle = (WXGameVideoFileObject)this.mLk.mediaObject;
      if (bool)
      {
        if ((!bt.isNullOrNil(paramBundle.filePath)) && (com.tencent.mm.vfs.i.eK(paramBundle.filePath)))
        {
          paramBundle = paramBundle.filePath;
          int i = com.tencent.mm.m.g.Zd().getInt("ShareVideoMaxSize", 104857600);
          if (com.tencent.mm.vfs.i.aMN(paramBundle) > i)
          {
            ad.e("MicroMsg.ShareSnsImpl", "file len too big ");
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
            wK(bool);
            AppMethodBeat.o(39426);
            return;
            i = 0;
            break;
            label732:
            paramBundle = a.a.zh(paramBundle);
            if ((paramBundle.videoWidth <= 0) || (paramBundle.videoHeight <= 0) || (paramBundle.videoWidth / paramBundle.videoHeight > 3.0F) || (paramBundle.videoWidth / paramBundle.videoHeight < 0.5F))
            {
              ad.i("MicroMsg.ShareSnsImpl", "check ratio faild width = [%d], height = [%d]", new Object[] { Integer.valueOf(paramBundle.videoWidth), Integer.valueOf(paramBundle.videoHeight) });
              i = 1;
              label822:
              if (i == 0)
              {
                ad.d("MicroMsg.ShareSnsImpl", "checkFormat() called with: item = [%s]", new Object[] { paramBundle });
                if (!bt.isNullOrNil(paramBundle.hsR))
                {
                  localObject1 = paramBundle.hsR;
                  if (!bt.isNullOrNil((String)localObject1)) {
                    break label971;
                  }
                  i = 1;
                  label869:
                  if ((i == 0) && ("video/avc".equalsIgnoreCase(paramBundle.hsS)) && ((bt.isNullOrNil(paramBundle.hsT)) || ("audio/mp4a-latm".equalsIgnoreCase(paramBundle.hsT)))) {
                    break label1186;
                  }
                }
                ad.i("MicroMsg.ShareSnsImpl", "check video format failed, dst format [video/avc], video format [%s]", new Object[] { paramBundle.hsS });
                ad.i("MicroMsg.ShareSnsImpl", "check video format failed, dst audioTrackMime [%s], video audioTrackMime [%s]", new Object[] { "audio/mp4a-latm", paramBundle.hsT });
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
              if (com.tencent.mm.modelsns.a.hsQ == null)
              {
                localObject2 = new HashSet();
                com.tencent.mm.modelsns.a.hsQ = (Set)localObject2;
                ((Set)localObject2).add(".h264");
                com.tencent.mm.modelsns.a.hsQ.add(".h26l");
                com.tencent.mm.modelsns.a.hsQ.add(".264");
                com.tencent.mm.modelsns.a.hsQ.add(".avc");
                com.tencent.mm.modelsns.a.hsQ.add(".mov");
                com.tencent.mm.modelsns.a.hsQ.add(".mp4");
                com.tencent.mm.modelsns.a.hsQ.add(".m4a");
                com.tencent.mm.modelsns.a.hsQ.add(".3gp");
                com.tencent.mm.modelsns.a.hsQ.add(".3g2");
                com.tencent.mm.modelsns.a.hsQ.add(".mj2");
                com.tencent.mm.modelsns.a.hsQ.add(".m4v");
              }
              localObject1 = ((String)localObject1).trim();
              i = ((String)localObject1).lastIndexOf(".");
              if ((i < 0) || (i >= ((String)localObject1).length()))
              {
                i = 1;
                break label869;
              }
              if (!com.tencent.mm.modelsns.a.hsQ.contains(((String)localObject1).substring(i).toLowerCase()))
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
      com.tencent.mm.bs.d.b(this, "mmsight", ".segment.VideoCompressUI", (Intent)localObject1, 2);
      AppMethodBeat.o(39426);
      return;
    }
    wK(bool);
    AppMethodBeat.o(39426);
    return;
    label1289:
    this.cOx.av(100L, 100L);
    AppMethodBeat.o(39426);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(39430);
    super.onDestroy();
    if (this.HwV)
    {
      ad.d("MicroMsg.SendAppMessageWrapperUI", "restore orientation");
      SharedPreferences localSharedPreferences = getSharedPreferences(aj.eFD(), 0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SendAppMessageWrapperUI
 * JD-Core Version:    0.7.0.1
 */