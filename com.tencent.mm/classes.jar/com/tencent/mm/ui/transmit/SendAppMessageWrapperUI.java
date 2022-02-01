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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.g.a.qi;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z.b;
import com.tencent.mm.modelappbrand.k;
import com.tencent.mm.modelappbrand.k.c;
import com.tencent.mm.modelmulti.o.b;
import com.tencent.mm.modelmulti.o.d;
import com.tencent.mm.modelmulti.o.e;
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
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.model.l;
import com.tencent.mm.pluginsdk.model.l.a;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.protocal.protobuf.deo;
import com.tencent.mm.protocal.protobuf.ehr;
import com.tencent.mm.protocal.protobuf.ehz;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.a.d.a.b;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(3)
public class SendAppMessageWrapperUI
  extends MMActivity
{
  private com.tencent.mm.pluginsdk.model.app.g LkU;
  private boolean LkV;
  private boolean LkW;
  private boolean LkX;
  private boolean LkY;
  private aw cYd;
  private String dGI;
  private int nSG;
  private WXMediaMessage nTL;
  private int rNI;
  private int scene;
  private String source;
  private com.tencent.mm.ui.base.p tipDialog;
  private String toUser;
  
  public SendAppMessageWrapperUI()
  {
    AppMethodBeat.i(39425);
    this.source = null;
    this.LkU = null;
    this.toUser = null;
    this.nTL = null;
    this.scene = 0;
    this.LkV = false;
    this.LkW = false;
    this.dGI = "";
    this.LkX = false;
    this.LkY = false;
    this.nSG = 0;
    this.rNI = 0;
    this.cYd = new aw(new aw.a()
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
  
  private static String a(WXMiniProgramObject paramWXMiniProgramObject)
  {
    AppMethodBeat.i(188227);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      String str = paramWXMiniProgramObject.getExtra("_wx_mini_program_key_activity_id", "");
      paramWXMiniProgramObject = paramWXMiniProgramObject.getExtra("_wx_mini_program_key_parameter_info_list", "");
      localJSONObject.put("activity_id", str);
      if (!bu.isNullOrNil(paramWXMiniProgramObject)) {
        localJSONObject.put("parameter_list", new JSONArray(paramWXMiniProgramObject));
      }
      ae.d("MicroMsg.SendAppMessageWrapperUI", "getAppBrandActivityInfo activityId: %s, json: %s", new Object[] { str, localJSONObject.toString() });
      paramWXMiniProgramObject = localJSONObject.toString();
      AppMethodBeat.o(188227);
      return paramWXMiniProgramObject;
    }
    catch (Exception paramWXMiniProgramObject)
    {
      ae.printErrStackTrace("MicroMsg.SendAppMessageWrapperUI", paramWXMiniProgramObject, "getAppBrandActivityInfo exception", new Object[0]);
      AppMethodBeat.o(188227);
    }
    return null;
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
          locala.hBc = paramWXMediaMessage.getWidth();
          locala.hBd = paramWXMediaMessage.getHeight();
        }
      }
      locala.videoSource = localWXDynamicVideoMiniProgramObject.videoSource;
      locala.appThumbUrl = localWXDynamicVideoMiniProgramObject.appThumbUrl;
      locala.hBe = 1;
      paramb.a(locala);
      paramb.hFl = localWXDynamicVideoMiniProgramObject.disableforward;
      paramb.dIu = null;
      AppMethodBeat.o(39435);
      return;
    }
    if ((paramWXMediaMessage.mediaObject instanceof WXMiniProgramObject)) {
      paramb.hFl = ((WXMiniProgramObject)paramWXMediaMessage.mediaObject).disableforward;
    }
    AppMethodBeat.o(39435);
  }
  
  private void a(WXMediaMessage paramWXMediaMessage, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(39434);
    Object localObject1;
    if ((paramWXMediaMessage == null) || (!(paramWXMediaMessage.mediaObject instanceof WXImageObject)))
    {
      ae.w("MicroMsg.SendAppMessageWrapperUI", "sendImgMsg msg not img");
      localObject1 = null;
    }
    while (bu.isNullOrNil((String)localObject1))
    {
      ae.e("MicroMsg.SendAppMessageWrapperUI", "sendImgMsg imgPath is null");
      setResult(0);
      AppMethodBeat.o(39434);
      return;
      localObject1 = (WXImageObject)paramWXMediaMessage.mediaObject;
      if (!bu.cF(((WXImageObject)localObject1).imageData))
      {
        ae.d("MicroMsg.SendAppMessageWrapperUI", "getImagePath fileData:" + ((WXImageObject)localObject1).imageData.length);
        localObject1 = m.cl(((WXImageObject)localObject1).imageData);
      }
      else
      {
        localObject1 = ((WXImageObject)localObject1).imagePath;
      }
    }
    int j = bu.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acL().getValue("PicCompressAvoidanceActiveSizeNormal"), 100);
    int i = j;
    if (j <= 0) {
      i = 100;
    }
    long l = com.tencent.mm.vfs.o.aZR((String)localObject1);
    if ((l > 26214400L) || (l <= i * 1024)) {}
    for (i = 0;; i = 1)
    {
      if ((!this.LkW) && (fPw()))
      {
        paramWXMediaMessage = null;
        paramLinkedList = paramLinkedList.iterator();
      }
      String str1;
      Object localObject2;
      String str2;
      while (paramLinkedList.hasNext())
      {
        str1 = (String)paramLinkedList.next();
        localObject2 = com.tencent.mm.modelmulti.o.a(o.d.iiQ).pn(6);
        ((o.e)localObject2).dzZ = v.aAC();
        ((o.e)localObject2).toUser = str1;
        ((o.e)localObject2).iey = ((String)localObject1);
        ((o.e)localObject2).icr = i;
        ((o.e)localObject2).iiW = null;
        ((o.e)localObject2).dyw = 0;
        ((o.e)localObject2).icA = paramWXMediaMessage;
        ((o.e)localObject2).thumbPath = "";
        ((o.e)localObject2).iiZ = true;
        ((o.e)localObject2).iiY = 2131231565;
        ((o.e)localObject2).iiV = 11;
        ((o.e)localObject2).aJO().execute();
        continue;
        str1 = this.LkU.field_appId;
        localObject2 = paramWXMediaMessage.mediaTagName;
        str2 = paramWXMediaMessage.messageExt;
        paramWXMediaMessage = paramWXMediaMessage.messageAction;
        if (bu.isNullOrNil(str1)) {
          break label409;
        }
      }
      label409:
      for (paramWXMediaMessage = "<msg>" + com.tencent.mm.av.h.d(str1, (String)localObject2, str2, paramWXMediaMessage) + "</msg>";; paramWXMediaMessage = null)
      {
        break;
        AppMethodBeat.o(39434);
        return;
      }
    }
  }
  
  private static void a(WxaAttributes paramWxaAttributes, k.b paramb, ehz paramehz)
  {
    AppMethodBeat.i(188228);
    com.tencent.mm.ah.a locala = new com.tencent.mm.ah.a();
    locala.hAV = paramWxaAttributes.beU().kcY.kaX;
    if (paramehz != null)
    {
      locala.hAM = paramehz.Ilg;
      if ((paramehz.Ilg) && (paramehz.Ilz != null))
      {
        locala.hAN = paramehz.Ilz.content;
        locala.hAO = paramehz.Ilz.HLI;
        locala.hAP = paramehz.Ilz.HLJ;
        locala.hAQ = paramehz.Ilz.HLK;
        locala.hAR = paramehz.Ilz.HLL;
        locala.hAS = paramehz.Ilz.HLN;
        locala.hAU = paramehz.Ilz.state;
        locala.hAT = paramehz.Ilz.HLM;
      }
      locala.hAZ = paramehz.Ilj;
      if (paramehz.Ilj) {
        paramb.hFl = 1;
      }
    }
    paramb.a(locala);
    AppMethodBeat.o(188228);
  }
  
  private void aZa(String paramString)
  {
    AppMethodBeat.i(39439);
    if ("wx5dfbe0a95623607b".equals(this.LkU.field_appId))
    {
      if (this.nTL.getType() == 5)
      {
        ae.i("MicroMsg.SendAppMessageWrapperUI", "report(17256) url, to timeline, appId : %s", new Object[] { this.LkU.field_appId });
        com.tencent.mm.plugin.report.service.g.yxI.f(17256, new Object[] { paramString, Integer.valueOf(2) });
        AppMethodBeat.o(39439);
        return;
      }
      if (this.nTL.getType() == 38)
      {
        ae.i("MicroMsg.SendAppMessageWrapperUI", "report(17256) video file, to timeline, appId : %s", new Object[] { this.LkU.field_appId });
        com.tencent.mm.plugin.report.service.g.yxI.f(17256, new Object[] { paramString, Integer.valueOf(1) });
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
        ae.i("MicroMsg.SendAppMessageWrapperUI", "sendMultiVedeo");
        paramLinkedList = new l(this, localArrayList, getIntent(), paramLinkedList, 1, new l.a()
        {
          public final void fdq()
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
            paramLinkedList.fdk();
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
    Object localObject1 = com.tencent.mm.model.z.aBG().F("kWXEntryActivity_data_center_session_id", true);
    if (localObject1 == null)
    {
      ae.e("MicroMsg.SendAppMessageWrapperUI", "sendWXWeworkObject fail values is null");
      AppMethodBeat.o(39438);
      return;
    }
    if (com.tencent.mm.pluginsdk.model.app.h.Za(((WXWeWorkObject)this.nTL.mediaObject).subType) < 0)
    {
      ae.e("MicroMsg.SendAppMessageWrapperUI", "sendWXWeworkObject fail innerType < 0");
      AppMethodBeat.o(39438);
      return;
    }
    k.b localb = k.b.zb((String)((z.b)localObject1).get("kWXEntryActivity_data_center_wework_msgcontent", ""));
    if (localb != null)
    {
      localObject1 = com.tencent.mm.plugin.record.b.p.awG(localb.hDg);
      if ((localObject1 != null) && (!bu.isNullOrNil(((c)localObject1).title))) {}
      for (localObject1 = ((c)localObject1).title;; localObject1 = localb.title)
      {
        Object localObject3 = this.LkU.field_appId;
        Object localObject2 = localObject3;
        if (!this.LkW)
        {
          localObject2 = localObject3;
          if (fPw()) {
            localObject2 = "";
          }
        }
        localb.appId = ((String)localObject2);
        localb.title = getResources().getString(2131761822, new Object[] { localObject1 });
        paramLinkedList = paramLinkedList.iterator();
        while (paramLinkedList.hasNext())
        {
          localObject1 = (String)paramLinkedList.next();
          localObject2 = new qi();
          ((qi)localObject2).dFS.type = 4;
          localObject3 = new bv();
          ((bv)localObject3).setContent(k.b.a(localb, null, null));
          ((qi)localObject2).dFS.dCi = ((bv)localObject3);
          ((qi)localObject2).dFS.toUser = ((String)localObject1);
          ((qi)localObject2).dFS.dGb = true;
          com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject2);
        }
      }
    }
    ae.e("MicroMsg.SendAppMessageWrapperUI", "dealWXWeWorkObject fail msg content is null");
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
      ae.e("MicroMsg.SendAppMessageWrapperUI", "sendCardMsg msgType invalid");
      setResult(0);
      finish();
      AppMethodBeat.o(39437);
      return;
    }
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      String str = (String)paramLinkedList.next();
      o.e locale = com.tencent.mm.modelmulti.o.Gz(str);
      locale.toUser = str;
      locale.content = paramWXMediaMessage.cardInfo;
      locale.type = paramWXMediaMessage.msgType;
      locale.dEu = 0;
      locale.iiV = 4;
      locale.aJO().execute();
    }
    AppMethodBeat.o(39437);
  }
  
  private boolean fPw()
  {
    AppMethodBeat.i(39428);
    ae.i("MicroMsg.SendAppMessageWrapperUI", "blockInvalidToken block %b", new Object[] { Boolean.valueOf(this.LkY) });
    boolean bool = this.LkY;
    AppMethodBeat.o(39428);
    return bool;
  }
  
  private com.tencent.mm.pluginsdk.model.app.a fPx()
  {
    AppMethodBeat.i(39433);
    com.tencent.mm.pluginsdk.model.app.a locala = new com.tencent.mm.pluginsdk.model.app.a();
    if (this.LkW) {}
    for (int i = 1;; i = 0)
    {
      locala.FeS = i;
      locala.dGI = this.dGI;
      AppMethodBeat.o(39433);
      return locala;
    }
  }
  
  private void yT(boolean paramBoolean)
  {
    AppMethodBeat.i(39427);
    if ((!this.LkW) && (fPw())) {}
    for (Intent localIntent = com.tencent.mm.modelsns.a.a(this.nSG, this.nTL, "", "", this.LkU.Ee()); localIntent == null; localIntent = com.tencent.mm.modelsns.a.a(this.nSG, this.nTL, this.LkU.field_appId, this.LkU.field_appName, this.LkU.Ee()))
    {
      finish();
      AppMethodBeat.o(39427);
      return;
    }
    String str = null;
    if ((this.nTL.getType() == 5) || (this.nTL.getType() == 2) || (this.nTL.getType() == 38))
    {
      ae.d("MicroMsg.SendAppMessageWrapperUI", "report(11954), to timeline, appId : %s", new Object[] { this.LkU.field_appId });
      str = com.tencent.mm.model.z.Br("app_" + this.LkU.field_appId);
      z.b localb = com.tencent.mm.model.z.aBG().F(str, true);
      localb.k("prePublishId", "app_" + this.LkU.field_appId);
      if ((this.nTL.mediaObject instanceof WXWebpageObject)) {
        localb.k("url", ((WXWebpageObject)this.nTL.mediaObject).webpageUrl);
      }
    }
    aZa(str);
    localIntent.putExtra("reportSessionId", str);
    localIntent.putExtra("KSnsUploadFromSkipCompress", paramBoolean);
    localIntent.putExtra("SendAppMessageWrapper_TokenValid", this.LkW);
    localIntent.putExtra("SendAppMessageWrapper_PkgName", this.dGI);
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
    ae.i("MicroMsg.SendAppMessageWrapperUI", "requestCode " + paramInt1 + " resultCode " + paramInt2);
    if (paramInt1 == 1)
    {
      if (paramInt2 == -1) {
        ReportUtil.a(this, ReportUtil.d(getIntent().getExtras(), 0), false);
      }
      for (;;)
      {
        finish();
        AppMethodBeat.o(39429);
        return;
        ReportUtil.a(this, ReportUtil.d(getIntent().getExtras(), 0), true);
      }
    }
    if ((paramInt1 == 2) && (paramInt2 == -1))
    {
      Object localObject;
      if ((this.nTL.mediaObject instanceof WXVideoFileObject))
      {
        localObject = (WXVideoFileObject)this.nTL.mediaObject;
        ((WXVideoFileObject)localObject).filePath = paramIntent.getStringExtra("K_SEGMENTVIDEOPATH");
        if ((!bu.isNullOrNil(((WXVideoFileObject)localObject).filePath)) && (com.tencent.mm.vfs.o.fB(((WXVideoFileObject)localObject).filePath)))
        {
          yT(false);
          AppMethodBeat.o(39429);
          return;
        }
        setResult(-5);
        finish();
        AppMethodBeat.o(39429);
        return;
      }
      if ((this.nTL.mediaObject instanceof WXGameVideoFileObject))
      {
        localObject = (WXGameVideoFileObject)this.nTL.mediaObject;
        ((WXGameVideoFileObject)localObject).filePath = paramIntent.getStringExtra("K_SEGMENTVIDEOPATH");
        if ((!bu.isNullOrNil(((WXGameVideoFileObject)localObject).filePath)) && (com.tencent.mm.vfs.o.fB(((WXGameVideoFileObject)localObject).filePath)))
        {
          yT(false);
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
    paramBundle = getSharedPreferences(ak.fow(), 0);
    if (!paramBundle.getBoolean("settings_landscape_mode", false))
    {
      ae.d("MicroMsg.SendAppMessageWrapperUI", "change orientation");
      this.LkV = true;
      setRequestedOrientation(-1);
      paramBundle.edit().putBoolean("settings_landscape_mode", true).commit();
    }
    Bundle localBundle = getIntent().getExtras();
    Object localObject2 = new SendMessageToWX.Req(localBundle);
    this.toUser = localBundle.getString("Select_Conv_User");
    this.LkW = localBundle.getBoolean("SendAppMessageWrapper_TokenValid", true);
    this.dGI = localBundle.getString("SendAppMessageWrapper_PkgName", "");
    this.LkX = localBundle.getBoolean("SendAppMessageWrapper_NoNeedStayInWeixin", false);
    this.LkY = localBundle.getBoolean("SendAppMessageWrapper_BlockInvalidToken", false);
    this.nSG = com.tencent.mm.sdk.platformtools.z.getIntExtra(getIntent(), "_mmessage_sdkVersion", 0);
    this.scene = localBundle.getInt("SendAppMessageWrapper_Scene", 0);
    Object localObject1 = localBundle.getString("SendAppMessageWrapper_AppId");
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null) {
      paramBundle = Uri.parse(localBundle.getString("_mmessage_content")).getQueryParameter("appid");
    }
    this.LkU = new com.tencent.mm.pluginsdk.model.app.g();
    this.LkU.field_appId = paramBundle;
    ao.dBg().get(this.LkU, new String[0]);
    if (this.LkU.field_appName == null) {}
    boolean bool;
    for (paramBundle = getString(2131757565);; paramBundle = com.tencent.mm.pluginsdk.model.app.h.a(getContext(), this.LkU, null))
    {
      this.source = getString(2131757563, new Object[] { paramBundle });
      this.nTL = ((SendMessageToWX.Req)localObject2).message;
      bool = getIntent().getBooleanExtra("SendAppMessageWrapper_SkipCompressVideo", false);
      ae.i("MicroMsg.SendAppMessageWrapperUI", "onCreate, messageAction = %s, messageExt = %s, skipCompress = %b", new Object[] { this.nTL.messageAction, this.nTL.messageExt, Boolean.valueOf(bool) });
      if (this.scene != 1) {
        break label1289;
      }
      if (this.nTL.mediaObject != null) {
        break;
      }
      finish();
      AppMethodBeat.o(39426);
      return;
    }
    if (this.nTL.getType() == 38)
    {
      localObject2 = (WXVideoFileObject)this.nTL.mediaObject;
      localObject1 = this.nTL.messageExt;
      paramBundle = ((WXVideoFileObject)localObject2).filePath;
      if ((bu.isNullOrNil(((WXVideoFileObject)localObject2).filePath)) || (!com.tencent.mm.vfs.o.fB(((WXVideoFileObject)localObject2).filePath))) {
        finish();
      }
      if (bool)
      {
        if ((!bu.isNullOrNil(((WXVideoFileObject)localObject2).filePath)) && (com.tencent.mm.vfs.o.fB(((WXVideoFileObject)localObject2).filePath)))
        {
          paramBundle = ((WXVideoFileObject)localObject2).filePath;
          if (paramBundle != null)
          {
            paramBundle = new File(paramBundle);
            if (!paramBundle.exists()) {}
          }
          for (paramBundle = com.tencent.xweb.util.d.ah(paramBundle); bu.lX((String)localObject1, paramBundle); paramBundle = null)
          {
            yT(bool);
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
    if (this.nTL.getType() == 39)
    {
      paramBundle = (WXGameVideoFileObject)this.nTL.mediaObject;
      if (bool)
      {
        if ((!bu.isNullOrNil(paramBundle.filePath)) && (com.tencent.mm.vfs.o.fB(paramBundle.filePath)))
        {
          paramBundle = paramBundle.filePath;
          int i = com.tencent.mm.n.g.acL().getInt("ShareVideoMaxSize", 104857600);
          if (com.tencent.mm.vfs.o.aZR(paramBundle) > i)
          {
            ae.e("MicroMsg.ShareSnsImpl", "file len too big ");
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
            yT(bool);
            AppMethodBeat.o(39426);
            return;
            i = 0;
            break;
            label732:
            paramBundle = a.a.GT(paramBundle);
            if ((paramBundle.videoWidth <= 0) || (paramBundle.videoHeight <= 0) || (paramBundle.videoWidth / paramBundle.videoHeight > 3.0F) || (paramBundle.videoWidth / paramBundle.videoHeight < 0.5F))
            {
              ae.i("MicroMsg.ShareSnsImpl", "check ratio faild width = [%d], height = [%d]", new Object[] { Integer.valueOf(paramBundle.videoWidth), Integer.valueOf(paramBundle.videoHeight) });
              i = 1;
              label822:
              if (i == 0)
              {
                ae.d("MicroMsg.ShareSnsImpl", "checkFormat() called with: item = [%s]", new Object[] { paramBundle });
                if (!bu.isNullOrNil(paramBundle.ipI))
                {
                  localObject1 = paramBundle.ipI;
                  if (!bu.isNullOrNil((String)localObject1)) {
                    break label971;
                  }
                  i = 1;
                  label869:
                  if ((i == 0) && ("video/avc".equalsIgnoreCase(paramBundle.ipJ)) && ((bu.isNullOrNil(paramBundle.ipK)) || ("audio/mp4a-latm".equalsIgnoreCase(paramBundle.ipK)))) {
                    break label1186;
                  }
                }
                ae.i("MicroMsg.ShareSnsImpl", "check video format failed, dst format [video/avc], video format [%s]", new Object[] { paramBundle.ipJ });
                ae.i("MicroMsg.ShareSnsImpl", "check video format failed, dst audioTrackMime [%s], video audioTrackMime [%s]", new Object[] { "audio/mp4a-latm", paramBundle.ipK });
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
              if (com.tencent.mm.modelsns.a.ipH == null)
              {
                localObject2 = new HashSet();
                com.tencent.mm.modelsns.a.ipH = (Set)localObject2;
                ((Set)localObject2).add(".h264");
                com.tencent.mm.modelsns.a.ipH.add(".h26l");
                com.tencent.mm.modelsns.a.ipH.add(".264");
                com.tencent.mm.modelsns.a.ipH.add(".avc");
                com.tencent.mm.modelsns.a.ipH.add(".mov");
                com.tencent.mm.modelsns.a.ipH.add(".mp4");
                com.tencent.mm.modelsns.a.ipH.add(".m4a");
                com.tencent.mm.modelsns.a.ipH.add(".3gp");
                com.tencent.mm.modelsns.a.ipH.add(".3g2");
                com.tencent.mm.modelsns.a.ipH.add(".mj2");
                com.tencent.mm.modelsns.a.ipH.add(".m4v");
              }
              localObject1 = ((String)localObject1).trim();
              i = ((String)localObject1).lastIndexOf(".");
              if ((i < 0) || (i >= ((String)localObject1).length()))
              {
                i = 1;
                break label869;
              }
              if (!com.tencent.mm.modelsns.a.ipH.contains(((String)localObject1).substring(i).toLowerCase()))
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
        ReportUtil.a(this, ReportUtil.d(getIntent().getExtras(), -5), false);
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
    yT(bool);
    AppMethodBeat.o(39426);
    return;
    label1289:
    this.cYd.ay(100L, 100L);
    AppMethodBeat.o(39426);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(39430);
    super.onDestroy();
    if (this.LkV)
    {
      ae.d("MicroMsg.SendAppMessageWrapperUI", "restore orientation");
      SharedPreferences localSharedPreferences = getSharedPreferences(ak.fow(), 0);
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