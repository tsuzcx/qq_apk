package com.tencent.mm.ui.transmit;

import android.app.Activity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.oa;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.modelsns.a.a;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXDynamicVideoMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXEnterpriseCardObject;
import com.tencent.mm.opensdk.modelmsg.WXGameVideoFileObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;
import com.tencent.mm.opensdk.modelmsg.WXWeWorkObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.record.b.n;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.pluginsdk.model.j;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.MMActivity;
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
  private com.tencent.mm.pluginsdk.model.app.f AAD;
  private boolean AAE;
  private boolean AAF;
  private boolean AAG;
  private ap caS;
  private int jLB;
  private WXMediaMessage jMk;
  private int mEM;
  private int scene;
  private String source;
  private com.tencent.mm.ui.base.p tipDialog;
  private String toUser;
  
  public SendAppMessageWrapperUI()
  {
    AppMethodBeat.i(35222);
    this.source = null;
    this.AAD = null;
    this.toUser = null;
    this.jMk = null;
    this.scene = 0;
    this.AAE = false;
    this.AAF = false;
    this.AAG = false;
    this.jLB = 0;
    this.mEM = 0;
    this.caS = new ap(new SendAppMessageWrapperUI.1(this), true);
    AppMethodBeat.o(35222);
  }
  
  private q.a a(WXMediaMessage paramWXMediaMessage)
  {
    AppMethodBeat.i(35229);
    paramWXMediaMessage = new SendAppMessageWrapperUI.5(this, paramWXMediaMessage);
    AppMethodBeat.o(35229);
    return paramWXMediaMessage;
  }
  
  private static void a(j.b paramb, WXMediaMessage paramWXMediaMessage)
  {
    AppMethodBeat.i(35231);
    if ((paramb == null) || (paramWXMediaMessage == null) || (paramWXMediaMessage.mediaObject == null))
    {
      AppMethodBeat.o(35231);
      return;
    }
    if ((paramWXMediaMessage.mediaObject instanceof WXDynamicVideoMiniProgramObject))
    {
      WXDynamicVideoMiniProgramObject localWXDynamicVideoMiniProgramObject = (WXDynamicVideoMiniProgramObject)paramWXMediaMessage.mediaObject;
      com.tencent.mm.af.a locala = new com.tencent.mm.af.a();
      if ((paramWXMediaMessage.thumbData != null) && (paramWXMediaMessage.thumbData.length > 0))
      {
        paramWXMediaMessage = BitmapFactory.decodeByteArray(paramWXMediaMessage.thumbData, 0, paramWXMediaMessage.thumbData.length);
        if (paramWXMediaMessage != null)
        {
          locala.ffr = paramWXMediaMessage.getWidth();
          locala.ffs = paramWXMediaMessage.getHeight();
        }
      }
      locala.videoSource = localWXDynamicVideoMiniProgramObject.videoSource;
      locala.appThumbUrl = localWXDynamicVideoMiniProgramObject.appThumbUrl;
      locala.fft = 1;
      paramb.a(locala);
      paramb.cGO = null;
    }
    AppMethodBeat.o(35231);
  }
  
  private void a(WXMediaMessage paramWXMediaMessage, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(35230);
    Object localObject1;
    if ((paramWXMediaMessage == null) || (!(paramWXMediaMessage.mediaObject instanceof WXImageObject)))
    {
      ab.w("MicroMsg.SendAppMessageWrapperUI", "sendImgMsg msg not img");
      localObject1 = null;
    }
    while (bo.isNullOrNil((String)localObject1))
    {
      ab.e("MicroMsg.SendAppMessageWrapperUI", "sendImgMsg imgPath is null");
      setResult(0);
      AppMethodBeat.o(35230);
      return;
      localObject1 = (WXImageObject)paramWXMediaMessage.mediaObject;
      if (!bo.ce(((WXImageObject)localObject1).imageData))
      {
        ab.d("MicroMsg.SendAppMessageWrapperUI", "getImagePath fileData:" + ((WXImageObject)localObject1).imageData.length);
        localObject1 = com.tencent.mm.pluginsdk.model.app.l.bK(((WXImageObject)localObject1).imageData);
      }
      else
      {
        localObject1 = ((WXImageObject)localObject1).imagePath;
      }
    }
    int j = bo.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getValue("PicCompressAvoidanceActiveSizeNormal"), 100);
    int i = j;
    if (j <= 0) {
      i = 100;
    }
    j = 1;
    long l = com.tencent.mm.vfs.e.avI((String)localObject1);
    if ((l > 26214400L) || (l <= i * 1024)) {
      j = 0;
    }
    if ((!this.AAF) && (dOt())) {
      paramWXMediaMessage = null;
    }
    for (;;)
    {
      paramLinkedList = paramLinkedList.iterator();
      while (paramLinkedList.hasNext())
      {
        localObject2 = (String)paramLinkedList.next();
        localObject2 = new com.tencent.mm.at.l(6, r.Zn(), (String)localObject2, (String)localObject1, j, null, 0, paramWXMediaMessage, "", true, 2130838229);
        aw.Rc().a((m)localObject2, 0);
      }
      Object localObject2 = this.AAD.field_appId;
      String str1 = paramWXMediaMessage.mediaTagName;
      String str2 = paramWXMediaMessage.messageExt;
      String str3 = paramWXMediaMessage.messageAction;
      paramWXMediaMessage = null;
      if (!bo.isNullOrNil((String)localObject2)) {
        paramWXMediaMessage = "<msg>" + com.tencent.mm.at.f.c((String)localObject2, str1, str2, str3) + "</msg>";
      }
    }
    AppMethodBeat.o(35230);
  }
  
  private void aR(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(154021);
    Object localObject1 = v.aae().z("kWXEntryActivity_data_center_session_id", true);
    if (localObject1 == null)
    {
      ab.e("MicroMsg.SendAppMessageWrapperUI", "sendWXWeworkObject fail values is null");
      AppMethodBeat.o(154021);
      return;
    }
    if (com.tencent.mm.pluginsdk.model.app.g.LC(((WXWeWorkObject)this.jMk.mediaObject).subType) < 0)
    {
      ab.e("MicroMsg.SendAppMessageWrapperUI", "sendWXWeworkObject fail innerType < 0");
      AppMethodBeat.o(154021);
      return;
    }
    j.b localb = j.b.mY((String)((v.b)localObject1).get("kWXEntryActivity_data_center_wework_msgcontent", ""));
    if (localb != null)
    {
      localObject1 = n.XS(localb.fhc);
      if ((localObject1 != null) && (!bo.isNullOrNil(((c)localObject1).title))) {}
      for (localObject1 = ((c)localObject1).title;; localObject1 = localb.title)
      {
        Object localObject3 = this.AAD.field_appId;
        Object localObject2 = localObject3;
        if (!this.AAF)
        {
          localObject2 = localObject3;
          if (dOt()) {
            localObject2 = "";
          }
        }
        localb.appId = ((String)localObject2);
        localb.title = getResources().getString(2131302037, new Object[] { localObject1 });
        paramLinkedList = paramLinkedList.iterator();
        while (paramLinkedList.hasNext())
        {
          localObject1 = (String)paramLinkedList.next();
          localObject2 = new oa();
          ((oa)localObject2).cEz.type = 4;
          localObject3 = new bi();
          ((bi)localObject3).setContent(j.b.a(localb, null, null));
          ((oa)localObject2).cEz.cEE = ((bi)localObject3);
          ((oa)localObject2).cEz.toUser = ((String)localObject1);
          ((oa)localObject2).cEz.cEJ = true;
          com.tencent.mm.sdk.b.a.ymk.l((b)localObject2);
        }
      }
    }
    ab.e("MicroMsg.SendAppMessageWrapperUI", "dealWXWeWorkObject fail msg content is null");
    AppMethodBeat.o(154021);
    return;
    AppMethodBeat.o(154021);
  }
  
  private void avf(String paramString)
  {
    AppMethodBeat.i(138663);
    if ("wx5dfbe0a95623607b".equals(this.AAD.field_appId))
    {
      if (this.jMk.getType() == 5)
      {
        ab.i("MicroMsg.SendAppMessageWrapperUI", "report(17256) url, to timeline, appId : %s", new Object[] { this.AAD.field_appId });
        com.tencent.mm.plugin.report.service.h.qsU.e(17256, new Object[] { paramString, Integer.valueOf(2) });
        AppMethodBeat.o(138663);
        return;
      }
      if (this.jMk.getType() == 38)
      {
        ab.i("MicroMsg.SendAppMessageWrapperUI", "report(17256) video file, to timeline, appId : %s", new Object[] { this.AAD.field_appId });
        com.tencent.mm.plugin.report.service.h.qsU.e(17256, new Object[] { paramString, Integer.valueOf(1) });
      }
    }
    AppMethodBeat.o(138663);
  }
  
  private void b(WXMediaMessage paramWXMediaMessage, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(35232);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(((WXVideoFileObject)paramWXMediaMessage.mediaObject).filePath);
    if (localArrayList.size() > 0)
    {
      paramWXMediaMessage = paramLinkedList.iterator();
      while (paramWXMediaMessage.hasNext())
      {
        paramLinkedList = (String)paramWXMediaMessage.next();
        ab.i("MicroMsg.SendAppMessageWrapperUI", "sendMultiVedeo");
        paramLinkedList = new j(this, localArrayList, getIntent(), paramLinkedList, 1, new SendAppMessageWrapperUI.10(this));
        com.tencent.mm.sdk.g.d.post(paramLinkedList, "ChattingUI_importMultiVideo");
        getString(2131297087);
        this.tipDialog = com.tencent.mm.ui.base.h.b(this, getString(2131297112), true, new SendAppMessageWrapperUI.2(this, paramLinkedList));
      }
    }
    AppMethodBeat.o(35232);
  }
  
  private void c(WXMediaMessage paramWXMediaMessage, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(35233);
    paramWXMediaMessage = (WXEnterpriseCardObject)paramWXMediaMessage.mediaObject;
    if ((paramWXMediaMessage.msgType != 66) && (paramWXMediaMessage.msgType != 42))
    {
      ab.e("MicroMsg.SendAppMessageWrapperUI", "sendCardMsg msgType invalid");
      setResult(0);
      finish();
      AppMethodBeat.o(35233);
      return;
    }
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      com.tencent.mm.modelmulti.h localh = new com.tencent.mm.modelmulti.h((String)paramLinkedList.next(), paramWXMediaMessage.cardInfo, paramWXMediaMessage.msgType);
      aw.Rc().a(localh, 0);
    }
    AppMethodBeat.o(35233);
  }
  
  private void dOs()
  {
    AppMethodBeat.i(35224);
    if ((!this.AAF) && (dOt())) {}
    for (Intent localIntent = com.tencent.mm.modelsns.a.a(this.jLB, this.jMk, "", "", this.AAD.vY()); localIntent == null; localIntent = com.tencent.mm.modelsns.a.a(this.jLB, this.jMk, this.AAD.field_appId, this.AAD.field_appName, this.AAD.vY()))
    {
      finish();
      AppMethodBeat.o(35224);
      return;
    }
    String str = null;
    if ((this.jMk.getType() == 5) || (this.jMk.getType() == 2) || (this.jMk.getType() == 38))
    {
      ab.d("MicroMsg.SendAppMessageWrapperUI", "report(11954), to timeline, appId : %s", new Object[] { this.AAD.field_appId });
      str = v.oQ("app_" + this.AAD.field_appId);
      v.b localb = v.aae().z(str, true);
      localb.i("prePublishId", "app_" + this.AAD.field_appId);
      if ((this.jMk.mediaObject instanceof WXWebpageObject)) {
        localb.i("url", ((WXWebpageObject)this.jMk.mediaObject).webpageUrl);
      }
    }
    avf(str);
    localIntent.putExtra("reportSessionId", str);
    com.tencent.mm.bq.d.b(this, "sns", ".ui.SnsUploadUI", localIntent, 1);
    AppMethodBeat.o(35224);
  }
  
  private boolean dOt()
  {
    AppMethodBeat.i(35225);
    ab.i("MicroMsg.SendAppMessageWrapperUI", "blockInvalidToken block %b", new Object[] { Boolean.valueOf(this.AAG) });
    boolean bool = this.AAG;
    AppMethodBeat.o(35225);
    return bool;
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void initView() {}
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(35226);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ab.i("MicroMsg.SendAppMessageWrapperUI", "requestCode " + paramInt1 + " resultCode " + paramInt2);
    if (paramInt1 == 1)
    {
      if (paramInt2 == -1) {
        ReportUtil.a(this, ReportUtil.c(getIntent().getExtras(), 0), false);
      }
      for (;;)
      {
        finish();
        AppMethodBeat.o(35226);
        return;
        ReportUtil.a(this, ReportUtil.c(getIntent().getExtras(), 0), true);
      }
    }
    if ((paramInt1 == 2) && (paramInt2 == -1))
    {
      Object localObject;
      if ((this.jMk.mediaObject instanceof WXVideoFileObject))
      {
        localObject = (WXVideoFileObject)this.jMk.mediaObject;
        ((WXVideoFileObject)localObject).filePath = paramIntent.getStringExtra("K_SEGMENTVIDEOPATH");
        if ((!bo.isNullOrNil(((WXVideoFileObject)localObject).filePath)) && (com.tencent.mm.vfs.e.cN(((WXVideoFileObject)localObject).filePath)))
        {
          dOs();
          AppMethodBeat.o(35226);
          return;
        }
        setResult(-5);
        finish();
        AppMethodBeat.o(35226);
        return;
      }
      if ((this.jMk.mediaObject instanceof WXGameVideoFileObject))
      {
        localObject = (WXGameVideoFileObject)this.jMk.mediaObject;
        ((WXGameVideoFileObject)localObject).filePath = paramIntent.getStringExtra("K_SEGMENTVIDEOPATH");
        if ((!bo.isNullOrNil(((WXGameVideoFileObject)localObject).filePath)) && (com.tencent.mm.vfs.e.cN(((WXGameVideoFileObject)localObject).filePath)))
        {
          dOs();
          AppMethodBeat.o(35226);
          return;
        }
        setResult(-5);
        finish();
      }
    }
    AppMethodBeat.o(35226);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(35223);
    super.onCreate(paramBundle);
    getSupportActionBar().hide();
    paramBundle = getSharedPreferences(ah.dsP(), 0);
    if (!paramBundle.getBoolean("settings_landscape_mode", false))
    {
      ab.d("MicroMsg.SendAppMessageWrapperUI", "change orientation");
      this.AAE = true;
      setRequestedOrientation(-1);
      paramBundle.edit().putBoolean("settings_landscape_mode", true).commit();
    }
    Bundle localBundle = getIntent().getExtras();
    Object localObject2 = new SendMessageToWX.Req(localBundle);
    this.toUser = localBundle.getString("Select_Conv_User");
    this.AAF = localBundle.getBoolean("SendAppMessageWrapper_TokenValid", false);
    this.AAG = localBundle.getBoolean("SendAppMessageWrapper_BlockInvalidToken", false);
    this.jLB = w.a(getIntent(), "_mmessage_sdkVersion", 0);
    this.scene = localBundle.getInt("SendAppMessageWrapper_Scene", 0);
    Object localObject1 = localBundle.getString("SendAppMessageWrapper_AppId");
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null) {
      paramBundle = Uri.parse(localBundle.getString("_mmessage_content")).getQueryParameter("appid");
    }
    this.AAD = new com.tencent.mm.pluginsdk.model.app.f();
    this.AAD.field_appId = paramBundle;
    al.cac().get(this.AAD, new String[0]);
    if (this.AAD.field_appName == null) {}
    boolean bool;
    for (paramBundle = getString(2131298506);; paramBundle = com.tencent.mm.pluginsdk.model.app.g.b(getContext(), this.AAD, null))
    {
      this.source = getString(2131298504, new Object[] { paramBundle });
      this.jMk = ((SendMessageToWX.Req)localObject2).message;
      bool = getIntent().getBooleanExtra("SendAppMessageWrapper_SkipCompressVideo", false);
      ab.i("MicroMsg.SendAppMessageWrapperUI", "onCreate, messageAction = %s, messageExt = %s, skipCompress = %b", new Object[] { this.jMk.messageAction, this.jMk.messageExt, Boolean.valueOf(bool) });
      if (this.scene != 1) {
        break label1261;
      }
      if (this.jMk.mediaObject != null) {
        break;
      }
      finish();
      AppMethodBeat.o(35223);
      return;
    }
    if (this.jMk.getType() == 38)
    {
      localObject2 = (WXVideoFileObject)this.jMk.mediaObject;
      localObject1 = this.jMk.messageExt;
      paramBundle = ((WXVideoFileObject)localObject2).filePath;
      if ((bo.isNullOrNil(((WXVideoFileObject)localObject2).filePath)) || (!com.tencent.mm.vfs.e.cN(((WXVideoFileObject)localObject2).filePath))) {
        finish();
      }
      if (bool)
      {
        if ((!bo.isNullOrNil(((WXVideoFileObject)localObject2).filePath)) && (com.tencent.mm.vfs.e.cN(((WXVideoFileObject)localObject2).filePath)))
        {
          paramBundle = ((WXVideoFileObject)localObject2).filePath;
          if (paramBundle != null)
          {
            paramBundle = new File(paramBundle);
            if (!paramBundle.exists()) {}
          }
          for (paramBundle = com.tencent.xweb.util.d.s(paramBundle); bo.isEqual((String)localObject1, paramBundle); paramBundle = null)
          {
            dOs();
            AppMethodBeat.o(35223);
            return;
          }
        }
        setResult(-5);
        finish();
        AppMethodBeat.o(35223);
        return;
      }
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("K_SEGMENTVIDEOPATH", paramBundle);
      ((Intent)localObject1).putExtra("KSEGMENTVIDEOTHUMBPATH", "");
      com.tencent.mm.bq.d.b(this, "mmsight", ".segment.VideoCompressUI", (Intent)localObject1, 2);
      AppMethodBeat.o(35223);
      return;
    }
    if (this.jMk.getType() == 39)
    {
      paramBundle = (WXGameVideoFileObject)this.jMk.mediaObject;
      if (bool)
      {
        if ((!bo.isNullOrNil(paramBundle.filePath)) && (com.tencent.mm.vfs.e.cN(paramBundle.filePath)))
        {
          paramBundle = paramBundle.filePath;
          int i = com.tencent.mm.m.g.Nq().getInt("ShareVideoMaxSize", 31457280);
          if (com.tencent.mm.vfs.e.avI(paramBundle) > i)
          {
            ab.e("MicroMsg.ShareSnsImpl", "file len too big ");
            i = 1;
            if (i == 0) {
              break label704;
            }
            i = 1;
          }
          for (;;)
          {
            if (i != 0) {
              break label1168;
            }
            dOs();
            AppMethodBeat.o(35223);
            return;
            i = 0;
            break;
            label704:
            paramBundle = a.a.uu(paramBundle);
            if ((paramBundle.videoWidth <= 0) || (paramBundle.videoHeight <= 0) || (paramBundle.videoWidth / paramBundle.videoHeight > 3.0F) || (paramBundle.videoWidth / paramBundle.videoHeight < 0.5F))
            {
              ab.i("MicroMsg.ShareSnsImpl", "check ratio faild width = [%d], height = [%d]", new Object[] { Integer.valueOf(paramBundle.videoWidth), Integer.valueOf(paramBundle.videoHeight) });
              i = 1;
              label794:
              if (i == 0)
              {
                ab.d("MicroMsg.ShareSnsImpl", "checkFormat() called with: item = [%s]", new Object[] { paramBundle });
                if (!bo.isNullOrNil(paramBundle.fQn))
                {
                  localObject1 = paramBundle.fQn;
                  if (!bo.isNullOrNil((String)localObject1)) {
                    break label943;
                  }
                  i = 1;
                  label841:
                  if ((i == 0) && ("video/avc".equalsIgnoreCase(paramBundle.fQo)) && ((bo.isNullOrNil(paramBundle.fQp)) || ("audio/mp4a-latm".equalsIgnoreCase(paramBundle.fQp)))) {
                    break label1158;
                  }
                }
                ab.i("MicroMsg.ShareSnsImpl", "check video format failed, dst format [video/avc], video format [%s]", new Object[] { paramBundle.fQo });
                ab.i("MicroMsg.ShareSnsImpl", "check video format failed, dst audioTrackMime [%s], video audioTrackMime [%s]", new Object[] { "audio/mp4a-latm", paramBundle.fQp });
              }
            }
            label1158:
            for (i = 1;; i = 0)
            {
              if (i == 0) {
                break label1163;
              }
              i = 1;
              break;
              i = 0;
              break label794;
              label943:
              if (com.tencent.mm.modelsns.a.fQm == null)
              {
                localObject2 = new HashSet();
                com.tencent.mm.modelsns.a.fQm = (Set)localObject2;
                ((Set)localObject2).add(".h264");
                com.tencent.mm.modelsns.a.fQm.add(".h26l");
                com.tencent.mm.modelsns.a.fQm.add(".264");
                com.tencent.mm.modelsns.a.fQm.add(".avc");
                com.tencent.mm.modelsns.a.fQm.add(".mov");
                com.tencent.mm.modelsns.a.fQm.add(".mp4");
                com.tencent.mm.modelsns.a.fQm.add(".m4a");
                com.tencent.mm.modelsns.a.fQm.add(".3gp");
                com.tencent.mm.modelsns.a.fQm.add(".3g2");
                com.tencent.mm.modelsns.a.fQm.add(".mj2");
                com.tencent.mm.modelsns.a.fQm.add(".m4v");
              }
              localObject1 = ((String)localObject1).trim();
              i = ((String)localObject1).lastIndexOf(".");
              if ((i < 0) || (i >= ((String)localObject1).length()))
              {
                i = 1;
                break label841;
              }
              if (!com.tencent.mm.modelsns.a.fQm.contains(((String)localObject1).substring(i).toLowerCase()))
              {
                i = 1;
                break label841;
              }
              i = 0;
              break label841;
            }
            label1163:
            i = 0;
          }
        }
        label1168:
        ReportUtil.a(this, ReportUtil.c(getIntent().getExtras(), -5), false);
        finish();
        AppMethodBeat.o(35223);
        return;
      }
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("K_SEGMENTVIDEOPATH", paramBundle.filePath);
      ((Intent)localObject1).putExtra("KSEGMENTVIDEOTHUMBPATH", "");
      com.tencent.mm.bq.d.b(this, "mmsight", ".segment.VideoCompressUI", (Intent)localObject1, 2);
      AppMethodBeat.o(35223);
      return;
    }
    dOs();
    AppMethodBeat.o(35223);
    return;
    label1261:
    this.caS.ag(100L, 100L);
    AppMethodBeat.o(35223);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(35227);
    super.onDestroy();
    if (this.AAE)
    {
      ab.d("MicroMsg.SendAppMessageWrapperUI", "restore orientation");
      SharedPreferences localSharedPreferences = getSharedPreferences(ah.dsP(), 0);
      setRequestedOrientation(1);
      localSharedPreferences.edit().putBoolean("settings_landscape_mode", false).commit();
    }
    AppMethodBeat.o(35227);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(35228);
    hideVKB();
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(35228);
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