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
import com.tencent.mm.al.n;
import com.tencent.mm.al.x.a;
import com.tencent.mm.g.a.qh;
import com.tencent.mm.model.u;
import com.tencent.mm.model.y.b;
import com.tencent.mm.modelappbrand.k;
import com.tencent.mm.modelappbrand.k.c;
import com.tencent.mm.modelmulti.o;
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
import com.tencent.mm.protocal.protobuf.ddu;
import com.tencent.mm.protocal.protobuf.ega;
import com.tencent.mm.protocal.protobuf.egi;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.a.d.a.b;
import com.tencent.mm.vfs.i;
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
  private boolean KOA;
  private com.tencent.mm.pluginsdk.model.app.g KOw;
  private boolean KOx;
  private boolean KOy;
  private boolean KOz;
  private av cXg;
  private String dFD;
  private int nNb;
  private WXMediaMessage nOg;
  private int rFx;
  private int scene;
  private String source;
  private com.tencent.mm.ui.base.p tipDialog;
  private String toUser;
  
  public SendAppMessageWrapperUI()
  {
    AppMethodBeat.i(39425);
    this.source = null;
    this.KOw = null;
    this.toUser = null;
    this.nOg = null;
    this.scene = 0;
    this.KOx = false;
    this.KOy = false;
    this.dFD = "";
    this.KOz = false;
    this.KOA = false;
    this.nNb = 0;
    this.rFx = 0;
    this.cXg = new av(new av.a()
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
    AppMethodBeat.i(194825);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      String str = paramWXMiniProgramObject.getExtra("_wx_mini_program_key_activity_id", "");
      paramWXMiniProgramObject = paramWXMiniProgramObject.getExtra("_wx_mini_program_key_parameter_info_list", "");
      localJSONObject.put("activity_id", str);
      if (!bt.isNullOrNil(paramWXMiniProgramObject)) {
        localJSONObject.put("parameter_list", new JSONArray(paramWXMiniProgramObject));
      }
      ad.d("MicroMsg.SendAppMessageWrapperUI", "getAppBrandActivityInfo activityId: %s, json: %s", new Object[] { str, localJSONObject.toString() });
      paramWXMiniProgramObject = localJSONObject.toString();
      AppMethodBeat.o(194825);
      return paramWXMiniProgramObject;
    }
    catch (Exception paramWXMiniProgramObject)
    {
      ad.printErrStackTrace("MicroMsg.SendAppMessageWrapperUI", paramWXMiniProgramObject, "getAppBrandActivityInfo exception", new Object[0]);
      AppMethodBeat.o(194825);
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
      com.tencent.mm.ai.a locala = new com.tencent.mm.ai.a();
      if ((paramWXMediaMessage.thumbData != null) && (paramWXMediaMessage.thumbData.length > 0))
      {
        paramWXMediaMessage = BitmapFactory.decodeByteArray(paramWXMediaMessage.thumbData, 0, paramWXMediaMessage.thumbData.length);
        if (paramWXMediaMessage != null)
        {
          locala.hyo = paramWXMediaMessage.getWidth();
          locala.hyp = paramWXMediaMessage.getHeight();
        }
      }
      locala.videoSource = localWXDynamicVideoMiniProgramObject.videoSource;
      locala.appThumbUrl = localWXDynamicVideoMiniProgramObject.appThumbUrl;
      locala.hyq = 1;
      paramb.a(locala);
      paramb.hCw = localWXDynamicVideoMiniProgramObject.disableforward;
      paramb.dHp = null;
      AppMethodBeat.o(39435);
      return;
    }
    if ((paramWXMediaMessage.mediaObject instanceof WXMiniProgramObject)) {
      paramb.hCw = ((WXMiniProgramObject)paramWXMediaMessage.mediaObject).disableforward;
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
      if (!bt.cC(((WXImageObject)localObject1).imageData))
      {
        ad.d("MicroMsg.SendAppMessageWrapperUI", "getImagePath fileData:" + ((WXImageObject)localObject1).imageData.length);
        localObject1 = m.ci(((WXImageObject)localObject1).imageData);
      }
      else
      {
        localObject1 = ((WXImageObject)localObject1).imagePath;
      }
    }
    int j = bt.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getValue("PicCompressAvoidanceActiveSizeNormal"), 100);
    int i = j;
    if (j <= 0) {
      i = 100;
    }
    long l = i.aYo((String)localObject1);
    if ((l > 26214400L) || (l <= i * 1024)) {}
    for (i = 0;; i = 1)
    {
      if ((!this.KOy) && (fLd()))
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
        localObject2 = o.a(o.d.ifX).pk(6);
        ((o.e)localObject2).dyU = u.aAm();
        ((o.e)localObject2).toUser = str1;
        ((o.e)localObject2).ibF = ((String)localObject1);
        ((o.e)localObject2).hZz = i;
        ((o.e)localObject2).igd = null;
        ((o.e)localObject2).dxr = 0;
        ((o.e)localObject2).hZI = paramWXMediaMessage;
        ((o.e)localObject2).thumbPath = "";
        ((o.e)localObject2).igg = true;
        ((o.e)localObject2).igf = 2131231565;
        ((o.e)localObject2).igc = 11;
        ((o.e)localObject2).aJv().execute();
        continue;
        str1 = this.KOw.field_appId;
        localObject2 = paramWXMediaMessage.mediaTagName;
        str2 = paramWXMediaMessage.messageExt;
        paramWXMediaMessage = paramWXMediaMessage.messageAction;
        if (bt.isNullOrNil(str1)) {
          break label409;
        }
      }
      label409:
      for (paramWXMediaMessage = "<msg>" + com.tencent.mm.aw.h.d(str1, (String)localObject2, str2, paramWXMediaMessage) + "</msg>";; paramWXMediaMessage = null)
      {
        break;
        AppMethodBeat.o(39434);
        return;
      }
    }
  }
  
  private static void a(WxaAttributes paramWxaAttributes, k.b paramb, egi paramegi)
  {
    AppMethodBeat.i(194826);
    com.tencent.mm.ai.a locala = new com.tencent.mm.ai.a();
    locala.hyh = paramWxaAttributes.bem().jZH.jXI;
    if (paramegi != null)
    {
      locala.hxY = paramegi.HQZ;
      if ((paramegi.HQZ) && (paramegi.HRs != null))
      {
        locala.hxZ = paramegi.HRs.content;
        locala.hya = paramegi.HRs.Hsg;
        locala.hyb = paramegi.HRs.Hsh;
        locala.hyc = paramegi.HRs.Hsi;
        locala.hyd = paramegi.HRs.Hsj;
        locala.hye = paramegi.HRs.Hsl;
        locala.hyg = paramegi.HRs.state;
        locala.hyf = paramegi.HRs.Hsk;
      }
      locala.hyl = paramegi.HRc;
      if (paramegi.HRc) {
        paramb.hCw = 1;
      }
    }
    paramb.a(locala);
    AppMethodBeat.o(194826);
  }
  
  private void aXy(String paramString)
  {
    AppMethodBeat.i(39439);
    if ("wx5dfbe0a95623607b".equals(this.KOw.field_appId))
    {
      if (this.nOg.getType() == 5)
      {
        ad.i("MicroMsg.SendAppMessageWrapperUI", "report(17256) url, to timeline, appId : %s", new Object[] { this.KOw.field_appId });
        com.tencent.mm.plugin.report.service.g.yhR.f(17256, new Object[] { paramString, Integer.valueOf(2) });
        AppMethodBeat.o(39439);
        return;
      }
      if (this.nOg.getType() == 38)
      {
        ad.i("MicroMsg.SendAppMessageWrapperUI", "report(17256) video file, to timeline, appId : %s", new Object[] { this.KOw.field_appId });
        com.tencent.mm.plugin.report.service.g.yhR.f(17256, new Object[] { paramString, Integer.valueOf(1) });
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
        paramLinkedList = new l(this, localArrayList, getIntent(), paramLinkedList, 1, new l.a()
        {
          public final void eZC()
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
            paramLinkedList.eZw();
            SendAppMessageWrapperUI.this.setResult(-1);
            SendAppMessageWrapperUI.this.finish();
            AppMethodBeat.o(180106);
          }
        });
      }
    }
    AppMethodBeat.o(39436);
  }
  
  private void br(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(39438);
    Object localObject1 = com.tencent.mm.model.y.aBq().F("kWXEntryActivity_data_center_session_id", true);
    if (localObject1 == null)
    {
      ad.e("MicroMsg.SendAppMessageWrapperUI", "sendWXWeworkObject fail values is null");
      AppMethodBeat.o(39438);
      return;
    }
    if (com.tencent.mm.pluginsdk.model.app.h.Yu(((WXWeWorkObject)this.nOg.mediaObject).subType) < 0)
    {
      ad.e("MicroMsg.SendAppMessageWrapperUI", "sendWXWeworkObject fail innerType < 0");
      AppMethodBeat.o(39438);
      return;
    }
    k.b localb = k.b.yr((String)((y.b)localObject1).get("kWXEntryActivity_data_center_wework_msgcontent", ""));
    if (localb != null)
    {
      localObject1 = com.tencent.mm.plugin.record.b.p.avr(localb.hAs);
      if ((localObject1 != null) && (!bt.isNullOrNil(((c)localObject1).title))) {}
      for (localObject1 = ((c)localObject1).title;; localObject1 = localb.title)
      {
        Object localObject3 = this.KOw.field_appId;
        Object localObject2 = localObject3;
        if (!this.KOy)
        {
          localObject2 = localObject3;
          if (fLd()) {
            localObject2 = "";
          }
        }
        localb.appId = ((String)localObject2);
        localb.title = getResources().getString(2131761822, new Object[] { localObject1 });
        paramLinkedList = paramLinkedList.iterator();
        while (paramLinkedList.hasNext())
        {
          localObject1 = (String)paramLinkedList.next();
          localObject2 = new qh();
          ((qh)localObject2).dEN.type = 4;
          localObject3 = new bu();
          ((bu)localObject3).setContent(k.b.a(localb, null, null));
          ((qh)localObject2).dEN.dBd = ((bu)localObject3);
          ((qh)localObject2).dEN.toUser = ((String)localObject1);
          ((qh)localObject2).dEN.dEW = true;
          com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject2);
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
      String str = (String)paramLinkedList.next();
      o.e locale = o.FX(str);
      locale.toUser = str;
      locale.content = paramWXMediaMessage.cardInfo;
      locale.type = paramWXMediaMessage.msgType;
      locale.dDp = 0;
      locale.igc = 4;
      locale.aJv().execute();
    }
    AppMethodBeat.o(39437);
  }
  
  private boolean fLd()
  {
    AppMethodBeat.i(39428);
    ad.i("MicroMsg.SendAppMessageWrapperUI", "blockInvalidToken block %b", new Object[] { Boolean.valueOf(this.KOA) });
    boolean bool = this.KOA;
    AppMethodBeat.o(39428);
    return bool;
  }
  
  private com.tencent.mm.pluginsdk.model.app.a fLe()
  {
    AppMethodBeat.i(39433);
    com.tencent.mm.pluginsdk.model.app.a locala = new com.tencent.mm.pluginsdk.model.app.a();
    if (this.KOy) {}
    for (int i = 1;; i = 0)
    {
      locala.EMu = i;
      locala.dFD = this.dFD;
      AppMethodBeat.o(39433);
      return locala;
    }
  }
  
  private void yF(boolean paramBoolean)
  {
    AppMethodBeat.i(39427);
    if ((!this.KOy) && (fLd())) {}
    for (Intent localIntent = com.tencent.mm.modelsns.a.a(this.nNb, this.nOg, "", "", this.KOw.Eb()); localIntent == null; localIntent = com.tencent.mm.modelsns.a.a(this.nNb, this.nOg, this.KOw.field_appId, this.KOw.field_appName, this.KOw.Eb()))
    {
      finish();
      AppMethodBeat.o(39427);
      return;
    }
    String str = null;
    if ((this.nOg.getType() == 5) || (this.nOg.getType() == 2) || (this.nOg.getType() == 38))
    {
      ad.d("MicroMsg.SendAppMessageWrapperUI", "report(11954), to timeline, appId : %s", new Object[] { this.KOw.field_appId });
      str = com.tencent.mm.model.y.AH("app_" + this.KOw.field_appId);
      y.b localb = com.tencent.mm.model.y.aBq().F(str, true);
      localb.k("prePublishId", "app_" + this.KOw.field_appId);
      if ((this.nOg.mediaObject instanceof WXWebpageObject)) {
        localb.k("url", ((WXWebpageObject)this.nOg.mediaObject).webpageUrl);
      }
    }
    aXy(str);
    localIntent.putExtra("reportSessionId", str);
    localIntent.putExtra("KSnsUploadFromSkipCompress", paramBoolean);
    localIntent.putExtra("SendAppMessageWrapper_TokenValid", this.KOy);
    localIntent.putExtra("SendAppMessageWrapper_PkgName", this.dFD);
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
      if ((this.nOg.mediaObject instanceof WXVideoFileObject))
      {
        localObject = (WXVideoFileObject)this.nOg.mediaObject;
        ((WXVideoFileObject)localObject).filePath = paramIntent.getStringExtra("K_SEGMENTVIDEOPATH");
        if ((!bt.isNullOrNil(((WXVideoFileObject)localObject).filePath)) && (i.fv(((WXVideoFileObject)localObject).filePath)))
        {
          yF(false);
          AppMethodBeat.o(39429);
          return;
        }
        setResult(-5);
        finish();
        AppMethodBeat.o(39429);
        return;
      }
      if ((this.nOg.mediaObject instanceof WXGameVideoFileObject))
      {
        localObject = (WXGameVideoFileObject)this.nOg.mediaObject;
        ((WXGameVideoFileObject)localObject).filePath = paramIntent.getStringExtra("K_SEGMENTVIDEOPATH");
        if ((!bt.isNullOrNil(((WXGameVideoFileObject)localObject).filePath)) && (i.fv(((WXGameVideoFileObject)localObject).filePath)))
        {
          yF(false);
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
    paramBundle = getSharedPreferences(aj.fkC(), 0);
    if (!paramBundle.getBoolean("settings_landscape_mode", false))
    {
      ad.d("MicroMsg.SendAppMessageWrapperUI", "change orientation");
      this.KOx = true;
      setRequestedOrientation(-1);
      paramBundle.edit().putBoolean("settings_landscape_mode", true).commit();
    }
    Bundle localBundle = getIntent().getExtras();
    Object localObject2 = new SendMessageToWX.Req(localBundle);
    this.toUser = localBundle.getString("Select_Conv_User");
    this.KOy = localBundle.getBoolean("SendAppMessageWrapper_TokenValid", true);
    this.dFD = localBundle.getString("SendAppMessageWrapper_PkgName", "");
    this.KOz = localBundle.getBoolean("SendAppMessageWrapper_NoNeedStayInWeixin", false);
    this.KOA = localBundle.getBoolean("SendAppMessageWrapper_BlockInvalidToken", false);
    this.nNb = com.tencent.mm.sdk.platformtools.y.getIntExtra(getIntent(), "_mmessage_sdkVersion", 0);
    this.scene = localBundle.getInt("SendAppMessageWrapper_Scene", 0);
    Object localObject1 = localBundle.getString("SendAppMessageWrapper_AppId");
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null) {
      paramBundle = Uri.parse(localBundle.getString("_mmessage_content")).getQueryParameter("appid");
    }
    this.KOw = new com.tencent.mm.pluginsdk.model.app.g();
    this.KOw.field_appId = paramBundle;
    ao.dxQ().get(this.KOw, new String[0]);
    if (this.KOw.field_appName == null) {}
    boolean bool;
    for (paramBundle = getString(2131757565);; paramBundle = com.tencent.mm.pluginsdk.model.app.h.a(getContext(), this.KOw, null))
    {
      this.source = getString(2131757563, new Object[] { paramBundle });
      this.nOg = ((SendMessageToWX.Req)localObject2).message;
      bool = getIntent().getBooleanExtra("SendAppMessageWrapper_SkipCompressVideo", false);
      ad.i("MicroMsg.SendAppMessageWrapperUI", "onCreate, messageAction = %s, messageExt = %s, skipCompress = %b", new Object[] { this.nOg.messageAction, this.nOg.messageExt, Boolean.valueOf(bool) });
      if (this.scene != 1) {
        break label1289;
      }
      if (this.nOg.mediaObject != null) {
        break;
      }
      finish();
      AppMethodBeat.o(39426);
      return;
    }
    if (this.nOg.getType() == 38)
    {
      localObject2 = (WXVideoFileObject)this.nOg.mediaObject;
      localObject1 = this.nOg.messageExt;
      paramBundle = ((WXVideoFileObject)localObject2).filePath;
      if ((bt.isNullOrNil(((WXVideoFileObject)localObject2).filePath)) || (!i.fv(((WXVideoFileObject)localObject2).filePath))) {
        finish();
      }
      if (bool)
      {
        if ((!bt.isNullOrNil(((WXVideoFileObject)localObject2).filePath)) && (i.fv(((WXVideoFileObject)localObject2).filePath)))
        {
          paramBundle = ((WXVideoFileObject)localObject2).filePath;
          if (paramBundle != null)
          {
            paramBundle = new File(paramBundle);
            if (!paramBundle.exists()) {}
          }
          for (paramBundle = com.tencent.xweb.util.d.ai(paramBundle); bt.lQ((String)localObject1, paramBundle); paramBundle = null)
          {
            yF(bool);
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
    if (this.nOg.getType() == 39)
    {
      paramBundle = (WXGameVideoFileObject)this.nOg.mediaObject;
      if (bool)
      {
        if ((!bt.isNullOrNil(paramBundle.filePath)) && (i.fv(paramBundle.filePath)))
        {
          paramBundle = paramBundle.filePath;
          int i = com.tencent.mm.n.g.acA().getInt("ShareVideoMaxSize", 104857600);
          if (i.aYo(paramBundle) > i)
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
            yF(bool);
            AppMethodBeat.o(39426);
            return;
            i = 0;
            break;
            label732:
            paramBundle = a.a.Gr(paramBundle);
            if ((paramBundle.videoWidth <= 0) || (paramBundle.videoHeight <= 0) || (paramBundle.videoWidth / paramBundle.videoHeight > 3.0F) || (paramBundle.videoWidth / paramBundle.videoHeight < 0.5F))
            {
              ad.i("MicroMsg.ShareSnsImpl", "check ratio faild width = [%d], height = [%d]", new Object[] { Integer.valueOf(paramBundle.videoWidth), Integer.valueOf(paramBundle.videoHeight) });
              i = 1;
              label822:
              if (i == 0)
              {
                ad.d("MicroMsg.ShareSnsImpl", "checkFormat() called with: item = [%s]", new Object[] { paramBundle });
                if (!bt.isNullOrNil(paramBundle.imO))
                {
                  localObject1 = paramBundle.imO;
                  if (!bt.isNullOrNil((String)localObject1)) {
                    break label971;
                  }
                  i = 1;
                  label869:
                  if ((i == 0) && ("video/avc".equalsIgnoreCase(paramBundle.imP)) && ((bt.isNullOrNil(paramBundle.imQ)) || ("audio/mp4a-latm".equalsIgnoreCase(paramBundle.imQ)))) {
                    break label1186;
                  }
                }
                ad.i("MicroMsg.ShareSnsImpl", "check video format failed, dst format [video/avc], video format [%s]", new Object[] { paramBundle.imP });
                ad.i("MicroMsg.ShareSnsImpl", "check video format failed, dst audioTrackMime [%s], video audioTrackMime [%s]", new Object[] { "audio/mp4a-latm", paramBundle.imQ });
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
              if (com.tencent.mm.modelsns.a.imN == null)
              {
                localObject2 = new HashSet();
                com.tencent.mm.modelsns.a.imN = (Set)localObject2;
                ((Set)localObject2).add(".h264");
                com.tencent.mm.modelsns.a.imN.add(".h26l");
                com.tencent.mm.modelsns.a.imN.add(".264");
                com.tencent.mm.modelsns.a.imN.add(".avc");
                com.tencent.mm.modelsns.a.imN.add(".mov");
                com.tencent.mm.modelsns.a.imN.add(".mp4");
                com.tencent.mm.modelsns.a.imN.add(".m4a");
                com.tencent.mm.modelsns.a.imN.add(".3gp");
                com.tencent.mm.modelsns.a.imN.add(".3g2");
                com.tencent.mm.modelsns.a.imN.add(".mj2");
                com.tencent.mm.modelsns.a.imN.add(".m4v");
              }
              localObject1 = ((String)localObject1).trim();
              i = ((String)localObject1).lastIndexOf(".");
              if ((i < 0) || (i >= ((String)localObject1).length()))
              {
                i = 1;
                break label869;
              }
              if (!com.tencent.mm.modelsns.a.imN.contains(((String)localObject1).substring(i).toLowerCase()))
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
      com.tencent.mm.bs.d.b(this, "mmsight", ".segment.VideoCompressUI", (Intent)localObject1, 2);
      AppMethodBeat.o(39426);
      return;
    }
    yF(bool);
    AppMethodBeat.o(39426);
    return;
    label1289:
    this.cXg.az(100L, 100L);
    AppMethodBeat.o(39426);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(39430);
    super.onDestroy();
    if (this.KOx)
    {
      ad.d("MicroMsg.SendAppMessageWrapperUI", "restore orientation");
      SharedPreferences localSharedPreferences = getSharedPreferences(aj.fkC(), 0);
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