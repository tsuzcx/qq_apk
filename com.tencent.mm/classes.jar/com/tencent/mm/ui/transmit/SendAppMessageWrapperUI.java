package com.tencent.mm.ui.transmit;

import android.app.Activity;
import android.content.Context;
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
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.g.a.rc;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.modelappbrand.k;
import com.tencent.mm.modelappbrand.k.c;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.modelmulti.o.b;
import com.tencent.mm.modelmulti.o.d;
import com.tencent.mm.modelmulti.o.e;
import com.tencent.mm.modelsns.a.a;
import com.tencent.mm.n.f;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXDynamicVideoMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXEnterpriseCardObject;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXGameVideoFileObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;
import com.tencent.mm.opensdk.modelmsg.WXWeWorkObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.c;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.c.a;
import com.tencent.mm.plugin.record.b.p;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.pluginsdk.model.m.a;
import com.tencent.mm.pluginsdk.ui.applet.o.a;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.protocal.protobuf.dxs;
import com.tencent.mm.protocal.protobuf.fcj;
import com.tencent.mm.protocal.protobuf.fcr;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMRoundCornerImageView;
import com.tencent.mm.ui.widget.RoundCornerRelativeLayout;
import com.tencent.mm.ui.widget.a.d.a.b;
import com.tencent.mm.vfs.s;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.LinkedList<Ljava.lang.String;>;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(3)
public class SendAppMessageWrapperUI
  extends MMActivity
{
  private boolean QAa;
  private boolean QAb;
  private boolean QAc;
  private String QAd;
  private com.tencent.mm.pluginsdk.model.app.g QzY;
  private boolean QzZ;
  private String Rcb;
  private WXMediaMessage pez;
  private String pkgName;
  private int scene;
  private int sdkVersion;
  private String source;
  private MTimerHandler timer;
  private com.tencent.mm.ui.base.q tipDialog;
  private int tnt;
  private String toUser;
  
  public SendAppMessageWrapperUI()
  {
    AppMethodBeat.i(39425);
    this.source = null;
    this.QzY = null;
    this.toUser = null;
    this.pez = null;
    this.scene = 0;
    this.QzZ = false;
    this.QAa = false;
    this.pkgName = "";
    this.QAb = false;
    this.QAc = false;
    this.sdkVersion = 0;
    this.QAd = "";
    this.tnt = 0;
    this.timer = new MTimerHandler(new MTimerHandler.CallBack()
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
        AppMethodBeat.i(180109);
        if (paramAnonymousBoolean)
        {
          SendAppMessageWrapperUI.a(SendAppMessageWrapperUI.this, paramWXMediaMessage, paramAnonymousString, paramAnonymousInt);
          AppMethodBeat.o(180109);
          return;
        }
        SendAppMessageWrapperUI.e(SendAppMessageWrapperUI.this);
        AppMethodBeat.o(180109);
      }
    };
    AppMethodBeat.o(39432);
    return paramWXMediaMessage;
  }
  
  private static String a(WXMiniProgramObject paramWXMiniProgramObject)
  {
    AppMethodBeat.i(234522);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      String str = paramWXMiniProgramObject.getExtra("_wx_mini_program_key_activity_id", "");
      paramWXMiniProgramObject = paramWXMiniProgramObject.getExtra("_wx_mini_program_key_parameter_info_list", "");
      localJSONObject.put("activity_id", str);
      if (!Util.isNullOrNil(paramWXMiniProgramObject)) {
        localJSONObject.put("parameter_list", new JSONArray(paramWXMiniProgramObject));
      }
      com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.SendAppMessageWrapperUI", "getAppBrandActivityInfo activityId: %s, json: %s", new Object[] { str, localJSONObject.toString() });
      paramWXMiniProgramObject = localJSONObject.toString();
      AppMethodBeat.o(234522);
      return paramWXMiniProgramObject;
    }
    catch (Exception paramWXMiniProgramObject)
    {
      com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.SendAppMessageWrapperUI", paramWXMiniProgramObject, "getAppBrandActivityInfo exception", new Object[0]);
      AppMethodBeat.o(234522);
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
      com.tencent.mm.ag.a locala = new com.tencent.mm.ag.a();
      if ((paramWXMediaMessage.thumbData != null) && (paramWXMediaMessage.thumbData.length > 0))
      {
        paramWXMediaMessage = BitmapFactory.decodeByteArray(paramWXMediaMessage.thumbData, 0, paramWXMediaMessage.thumbData.length);
        if (paramWXMediaMessage != null)
        {
          locala.ivi = paramWXMediaMessage.getWidth();
          locala.ivj = paramWXMediaMessage.getHeight();
        }
      }
      locala.videoSource = localWXDynamicVideoMiniProgramObject.videoSource;
      locala.appThumbUrl = localWXDynamicVideoMiniProgramObject.appThumbUrl;
      locala.ivk = 1;
      paramb.a(locala);
      paramb.izr = localWXDynamicVideoMiniProgramObject.disableforward;
      paramb.eah = null;
      AppMethodBeat.o(39435);
      return;
    }
    if ((paramWXMediaMessage.mediaObject instanceof WXMiniProgramObject)) {
      paramb.izr = ((WXMiniProgramObject)paramWXMediaMessage.mediaObject).disableforward;
    }
    AppMethodBeat.o(39435);
  }
  
  private void a(WXMediaMessage paramWXMediaMessage, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(39434);
    Object localObject1;
    if ((paramWXMediaMessage == null) || (!(paramWXMediaMessage.mediaObject instanceof WXImageObject)))
    {
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.SendAppMessageWrapperUI", "sendImgMsg msg not img");
      localObject1 = null;
    }
    while (Util.isNullOrNil((String)localObject1))
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SendAppMessageWrapperUI", "sendImgMsg imgPath is null");
      setResult(0);
      AppMethodBeat.o(39434);
      return;
      localObject1 = (WXImageObject)paramWXMediaMessage.mediaObject;
      if (!Util.isNullOrNil(((WXImageObject)localObject1).imageData))
      {
        com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.SendAppMessageWrapperUI", "getImagePath fileData:" + ((WXImageObject)localObject1).imageData.length);
        localObject1 = com.tencent.mm.pluginsdk.model.app.m.cC(((WXImageObject)localObject1).imageData);
      }
      else
      {
        localObject1 = ((WXImageObject)localObject1).imagePath;
      }
    }
    int j = Util.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("PicCompressAvoidanceActiveSizeNormal"), 100);
    int i = j;
    if (j <= 0) {
      i = 100;
    }
    long l = s.boW((String)localObject1);
    if ((l > 26214400L) || (l <= i * 1024)) {}
    for (i = 0;; i = 1)
    {
      if ((!this.QAa) && (gYq()))
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
        localObject2 = o.a(o.d.jdL).tc(6);
        ((o.e)localObject2).dRL = z.aTY();
        ((o.e)localObject2).toUser = str1;
        ((o.e)localObject2).iZt = ((String)localObject1);
        ((o.e)localObject2).iXp = i;
        ((o.e)localObject2).jdS = null;
        ((o.e)localObject2).dQd = 0;
        ((o.e)localObject2).iXy = paramWXMediaMessage;
        ((o.e)localObject2).thumbPath = "";
        ((o.e)localObject2).jdV = true;
        ((o.e)localObject2).jdU = 2131231629;
        ((o.e)localObject2).jdR = 11;
        ((o.e)localObject2).bdQ().execute();
        continue;
        str1 = this.QzY.field_appId;
        localObject2 = paramWXMediaMessage.mediaTagName;
        str2 = paramWXMediaMessage.messageExt;
        paramWXMediaMessage = paramWXMediaMessage.messageAction;
        if (Util.isNullOrNil(str1)) {
          break label409;
        }
      }
      label409:
      for (paramWXMediaMessage = "<msg>" + com.tencent.mm.av.h.c(str1, (String)localObject2, str2, paramWXMediaMessage) + "</msg>";; paramWXMediaMessage = null)
      {
        break;
        AppMethodBeat.o(39434);
        return;
      }
    }
  }
  
  private void a(WXMediaMessage paramWXMediaMessage, LinkedList<String> paramLinkedList, String paramString1, String paramString2)
  {
    AppMethodBeat.i(234520);
    com.tencent.mm.pluginsdk.ui.tools.q.a(this.sdkVersion, this.QzY, paramWXMediaMessage, paramLinkedList);
    Object localObject2;
    Object localObject1;
    int i;
    if (paramWXMediaMessage.getType() == 6)
    {
      localObject2 = (WXFileObject)paramWXMediaMessage.mediaObject;
      localObject1 = ((WXFileObject)localObject2).fileData;
      if ((localObject1 == null) || (localObject1.length == 0))
      {
        localObject1 = ((WXFileObject)localObject2).filePath;
        if ((localObject1 == null) || (((String)localObject1).length() == 0)) {
          com.tencent.mm.opensdk.utils.Log.e("MicroMsg.SDK.WXFileObject", "checkArgs fail, both arguments is null");
        }
      }
      for (i = 0; i == 0; i = 1)
      {
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SendAppMessageWrapperUI", "check security problem %s", new Object[] { ((WXFileObject)localObject2).filePath });
        finish();
        AppMethodBeat.o(234520);
        return;
      }
      if (!Util.isNullOrNil(((WXFileObject)localObject2).filePath))
      {
        localObject1 = ((WXFileObject)localObject2).filePath;
        bg.aVF();
        if ((!((String)localObject1).startsWith(com.tencent.mm.model.c.aTg())) && (!((WXFileObject)localObject2).filePath.startsWith(com.tencent.mm.loader.j.b.aKM())))
        {
          localObject1 = ((WXFileObject)localObject2).filePath;
          if (Util.isNullOrNil(((WXFileObject)localObject2).filePath)) {}
        }
      }
    }
    for (;;)
    {
      try
      {
        int j = ((WXFileObject)localObject2).filePath.lastIndexOf('/') + 1;
        if (j < 0) {
          break label439;
        }
        i = j;
        if (j == ((WXFileObject)localObject2).filePath.length()) {
          break label439;
        }
        localObject1 = ((WXFileObject)localObject2).filePath;
        localObject1 = ((String)localObject1).substring(i, ((String)localObject1).length());
      }
      catch (Exception localException)
      {
        String str2;
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SendAppMessageWrapperUI", "get file name error " + localException.getMessage());
        String str1 = " ";
        continue;
        AppMethodBeat.o(234520);
        return;
      }
      bg.aVF();
      localObject1 = com.tencent.mm.pluginsdk.model.app.m.aB(com.tencent.mm.model.c.aTg(), (String)localObject1, s.akC(((WXFileObject)localObject2).filePath));
      s.nw(((WXFileObject)localObject2).filePath, (String)localObject1);
      ((WXFileObject)localObject2).filePath = ((String)localObject1);
      localObject2 = paramLinkedList.iterator();
      if (((Iterator)localObject2).hasNext())
      {
        str2 = (String)((Iterator)localObject2).next();
        localObject1 = this.QzY.field_appId;
        paramLinkedList = (LinkedList<String>)localObject1;
        if (!this.QAa)
        {
          paramLinkedList = (LinkedList<String>)localObject1;
          if (gYq()) {
            paramLinkedList = "";
          }
        }
        i = 0;
        if (this.scene == 3) {
          i = 1;
        }
        com.tencent.mm.pluginsdk.model.app.m.a(paramWXMediaMessage, paramLinkedList, this.QzY.field_appName, str2, 2, paramString1, paramString2, i, gYr());
      }
      else
      {
        label439:
        i = 0;
      }
    }
  }
  
  private static void a(WxaAttributes paramWxaAttributes, k.b paramb, fcr paramfcr)
  {
    AppMethodBeat.i(234523);
    com.tencent.mm.ag.a locala = new com.tencent.mm.ag.a();
    locala.ivc = paramWxaAttributes.bAo().lgD.leb;
    if (paramfcr != null)
    {
      locala.iuT = paramfcr.Nyi;
      if ((paramfcr.Nyi) && (paramfcr.NyB != null))
      {
        locala.iuU = paramfcr.NyB.content;
        locala.iuV = paramfcr.NyB.MXr;
        locala.iuW = paramfcr.NyB.MXs;
        locala.iuX = paramfcr.NyB.MXt;
        locala.iuY = paramfcr.NyB.MXu;
        locala.iuZ = paramfcr.NyB.MXw;
        locala.ivb = paramfcr.NyB.state;
        locala.iva = paramfcr.NyB.MXv;
      }
      locala.ivg = paramfcr.Nyl;
      if (paramfcr.Nyl) {
        paramb.izr = 1;
      }
    }
    paramb.a(locala);
    AppMethodBeat.o(234523);
  }
  
  private void a(String paramString, LinkedList<String> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(234521);
    Object localObject1;
    label48:
    Object localObject2;
    y.a local13;
    y.a local14;
    if (this.QzY.field_appId.equals("wx4310bbd51be7d979"))
    {
      localObject1 = null;
      if ((this.QAa) || (!gYq())) {
        break label154;
      }
      localObject1 = getString(2131757783);
      localObject2 = getString(2131757791);
      local13 = new y.a()
      {
        public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
        {
          AppMethodBeat.i(234516);
          SendAppMessageWrapperUI.this.setResult(-1, new Intent().putExtra("Select_stay_in_wx", true));
          SendAppMessageWrapperUI.this.finish();
          AppMethodBeat.o(234516);
        }
      };
      local14 = new y.a()
      {
        public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
        {
          AppMethodBeat.i(234517);
          paramAnonymousString = new Intent().putExtra("Select_back_to_app", true);
          if (SendAppMessageWrapperUI.f(SendAppMessageWrapperUI.this) != 3)
          {
            if (SendAppMessageWrapperUI.this.getIntent().getExtras() != null) {
              paramAnonymousString.putExtras(SendAppMessageWrapperUI.this.getIntent().getExtras());
            }
            SendAppMessageWrapperUI.this.setResult(-1, paramAnonymousString);
            SendAppMessageWrapperUI.this.finish();
            AppMethodBeat.o(234517);
            return;
          }
          SendAppMessageWrapperUI.this.setResult(-1);
          SendAppMessageWrapperUI.this.finish();
          paramAnonymousString = ReportUtil.d(SendAppMessageWrapperUI.this.getIntent().getExtras(), 0);
          ReportUtil.a(SendAppMessageWrapperUI.this, paramAnonymousString, false);
          AppMethodBeat.o(234517);
        }
      };
      if (!this.QAb) {
        break label174;
      }
      local14.a(true, paramString, paramInt);
    }
    for (;;)
    {
      if ((paramString != null) && (paramString.length() != 0)) {
        break label200;
      }
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SendAppMessageWrapperUI", "summerbig dealSucc, text is empty");
      AppMethodBeat.o(234521);
      return;
      localObject1 = getString(2131757784, new Object[] { com.tencent.mm.pluginsdk.model.app.h.a(this, this.QzY, this.QzY.field_appName) });
      break;
      label154:
      if (localObject1 == null)
      {
        localObject1 = getString(2131757783);
        break label48;
      }
      break label48;
      label174:
      com.tencent.mm.plugin.bizui.a.b.a(this.mController, getString(2131757788), (String)localObject1, (String)localObject2, local14, local13);
    }
    label200:
    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.SendAppMessageWrapperUI", "summerbig dktext , send msg here:".concat(String.valueOf(paramString)));
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      localObject1 = (String)paramLinkedList.next();
      localObject2 = o.Pl((String)localObject1);
      ((o.e)localObject2).toUser = ((String)localObject1);
      ((o.e)localObject2).content = paramString;
      localObject1 = ((o.e)localObject2).tD(ab.JG(this.toUser));
      ((o.e)localObject1).cSx = 0;
      ((o.e)localObject1).jdR = 4;
      ((o.e)localObject1).bdQ().execute();
    }
    AppMethodBeat.o(234521);
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
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SendAppMessageWrapperUI", "sendMultiVedeo");
        paramLinkedList = new com.tencent.mm.pluginsdk.model.m(this, localArrayList, getIntent(), paramLinkedList, 1, new m.a()
        {
          public final void gmA()
          {
            AppMethodBeat.i(234510);
            if (SendAppMessageWrapperUI.j(SendAppMessageWrapperUI.this) != null)
            {
              SendAppMessageWrapperUI.j(SendAppMessageWrapperUI.this).dismiss();
              SendAppMessageWrapperUI.k(SendAppMessageWrapperUI.this);
            }
            AppMethodBeat.o(234510);
          }
        });
        ThreadPool.post(paramLinkedList, "ChattingUI_importMultiVideo");
        getString(2131755998);
        this.tipDialog = com.tencent.mm.ui.base.h.a(this, getString(2131756029), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(234511);
            paramLinkedList.gmu();
            SendAppMessageWrapperUI.this.setResult(-1);
            SendAppMessageWrapperUI.this.finish();
            AppMethodBeat.o(234511);
          }
        });
      }
    }
    AppMethodBeat.o(39436);
  }
  
  private void bN(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(39438);
    Object localObject1 = ad.aVe().G("kWXEntryActivity_data_center_session_id", true);
    if (localObject1 == null)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SendAppMessageWrapperUI", "sendWXWeworkObject fail values is null");
      AppMethodBeat.o(39438);
      return;
    }
    if (com.tencent.mm.pluginsdk.model.app.h.ahL(((WXWeWorkObject)this.pez.mediaObject).subType) < 0)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SendAppMessageWrapperUI", "sendWXWeworkObject fail innerType < 0");
      AppMethodBeat.o(39438);
      return;
    }
    k.b localb = k.b.HD((String)((ad.b)localObject1).get("kWXEntryActivity_data_center_wework_msgcontent", ""));
    if (localb != null)
    {
      localObject1 = p.aKY(localb.ixl);
      if ((localObject1 != null) && (!Util.isNullOrNil(((com.tencent.mm.protocal.b.a.c)localObject1).title))) {}
      for (localObject1 = ((com.tencent.mm.protocal.b.a.c)localObject1).title;; localObject1 = localb.title)
      {
        Object localObject3 = this.QzY.field_appId;
        Object localObject2 = localObject3;
        if (!this.QAa)
        {
          localObject2 = localObject3;
          if (gYq()) {
            localObject2 = "";
          }
        }
        localb.appId = ((String)localObject2);
        localb.title = getResources().getString(2131763799, new Object[] { localObject1 });
        paramLinkedList = paramLinkedList.iterator();
        while (paramLinkedList.hasNext())
        {
          localObject1 = (String)paramLinkedList.next();
          localObject2 = new rc();
          ((rc)localObject2).dXF.type = 4;
          localObject3 = new ca();
          ((ca)localObject3).setContent(k.b.a(localb, null, null));
          ((rc)localObject2).dXF.dTX = ((ca)localObject3);
          ((rc)localObject2).dXF.toUser = ((String)localObject1);
          ((rc)localObject2).dXF.dXN = true;
          EventCenter.instance.publish((IEvent)localObject2);
        }
      }
    }
    com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SendAppMessageWrapperUI", "dealWXWeWorkObject fail msg content is null");
    AppMethodBeat.o(39438);
    return;
    AppMethodBeat.o(39438);
  }
  
  private void bog(String paramString)
  {
    AppMethodBeat.i(39439);
    if ("wx5dfbe0a95623607b".equals(this.QzY.field_appId))
    {
      if (this.pez.getType() == 5)
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SendAppMessageWrapperUI", "report(17256) url, to timeline, appId : %s", new Object[] { this.QzY.field_appId });
        com.tencent.mm.plugin.report.service.h.CyF.a(17256, new Object[] { paramString, Integer.valueOf(2) });
        AppMethodBeat.o(39439);
        return;
      }
      if (this.pez.getType() == 38)
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SendAppMessageWrapperUI", "report(17256) video file, to timeline, appId : %s", new Object[] { this.QzY.field_appId });
        com.tencent.mm.plugin.report.service.h.CyF.a(17256, new Object[] { paramString, Integer.valueOf(1) });
      }
    }
    AppMethodBeat.o(39439);
  }
  
  private void c(WXMediaMessage paramWXMediaMessage, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(39437);
    paramWXMediaMessage = (WXEnterpriseCardObject)paramWXMediaMessage.mediaObject;
    if ((paramWXMediaMessage.msgType != 66) && (paramWXMediaMessage.msgType != 42))
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SendAppMessageWrapperUI", "sendCardMsg msgType invalid");
      setResult(0);
      finish();
      AppMethodBeat.o(39437);
      return;
    }
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      Object localObject = (String)paramLinkedList.next();
      o.e locale = o.Pl((String)localObject);
      locale.toUser = ((String)localObject);
      locale.content = paramWXMediaMessage.cardInfo;
      localObject = locale.tD(paramWXMediaMessage.msgType);
      ((o.e)localObject).cSx = 0;
      ((o.e)localObject).jdR = 4;
      ((o.e)localObject).bdQ().execute();
    }
    AppMethodBeat.o(39437);
  }
  
  private void d(boolean paramBoolean, Bundle paramBundle)
  {
    AppMethodBeat.i(234519);
    if ((!this.QAa) && (gYq())) {}
    for (paramBundle = com.tencent.mm.modelsns.a.a(this.sdkVersion, this.pez, "", "", this.QzY.NA(), paramBundle); paramBundle == null; paramBundle = com.tencent.mm.modelsns.a.a(this.sdkVersion, this.pez, this.QzY.field_appId, this.QzY.field_appName, this.QzY.NA(), paramBundle))
    {
      finish();
      AppMethodBeat.o(234519);
      return;
    }
    String str = null;
    if ((this.pez.getType() == 5) || (this.pez.getType() == 2) || (this.pez.getType() == 38))
    {
      com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.SendAppMessageWrapperUI", "report(11954), to timeline, appId : %s", new Object[] { this.QzY.field_appId });
      str = ad.JX("app_" + this.QzY.field_appId);
      ad.b localb = ad.aVe().G(str, true);
      localb.l("prePublishId", "app_" + this.QzY.field_appId);
      if ((this.pez.mediaObject instanceof WXWebpageObject)) {
        localb.l("url", ((WXWebpageObject)this.pez.mediaObject).webpageUrl);
      }
    }
    bog(str);
    paramBundle.putExtra("reportSessionId", str);
    paramBundle.putExtra("KSnsUploadFromSkipCompress", paramBoolean);
    paramBundle.putExtra("SendAppMessageWrapper_TokenValid", this.QAa);
    paramBundle.putExtra("SendAppMessageWrapper_PkgName", this.pkgName);
    com.tencent.mm.br.c.b(this, "sns", ".ui.SnsUploadUI", paramBundle, 1);
    AppMethodBeat.o(234519);
  }
  
  private boolean d(WXMediaMessage paramWXMediaMessage)
  {
    AppMethodBeat.i(257977);
    o.a locala = new o.a(this);
    Object localObject2 = getIntent().getStringExtra("Select_Conv_User");
    Object localObject1 = null;
    if (localObject2 != null) {
      localObject1 = Util.stringsToList(((String)localObject2).split(","));
    }
    locala.ea(localObject1);
    Object localObject3 = paramWXMediaMessage.thumbData;
    Object localObject4;
    if ((paramWXMediaMessage.getType() != 76) && (paramWXMediaMessage.getType() != 3))
    {
      localObject1 = null;
      if (localObject1 != null)
      {
        locala.gl((View)localObject1);
        locala.gpz();
        locala.p(Boolean.TRUE);
        locala.p(Boolean.TRUE);
        locala.aii(2131757789).a(a(paramWXMediaMessage)).kdo.show();
        AppMethodBeat.o(257977);
        return true;
      }
    }
    else
    {
      localObject2 = paramWXMediaMessage.mediaObject;
      localObject4 = paramWXMediaMessage.title;
      localObject1 = paramWXMediaMessage.description;
      if (paramWXMediaMessage.getType() != 76) {
        break label455;
      }
      localObject1 = ((WXMusicVideoObject)localObject2).singerName;
      if (!Util.isNullOrNil((String)localObject1)) {
        break label452;
      }
      localObject1 = paramWXMediaMessage.description;
    }
    label438:
    label452:
    label455:
    for (;;)
    {
      localObject2 = View.inflate(this, 2131496301, null);
      ((RoundCornerRelativeLayout)((View)localObject2).findViewById(2131307176)).setRadius(com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 4));
      View localView1 = ((View)localObject2).findViewById(2131297645);
      View localView2 = ((View)localObject2).findViewById(2131305087);
      if (com.tencent.mm.ui.ao.isDarkMode())
      {
        localView2.setBackgroundResource(2131234996);
        label248:
        MMRoundCornerImageView localMMRoundCornerImageView = (MMRoundCornerImageView)localView2.findViewById(2131298519);
        TextView localTextView1 = (TextView)localView2.findViewById(2131298523);
        TextView localTextView2 = (TextView)localView2.findViewById(2131298524);
        TextView localTextView3 = (TextView)localView2.findViewById(2131298521);
        localTextView2.setMaxLines(2);
        localTextView1.setMaxLines(1);
        localTextView3.setMaxLines(1);
        localTextView2.setText((CharSequence)localObject4);
        localTextView1.setText((CharSequence)localObject1);
        if ((localObject3 != null) && (localObject3.length > 0))
        {
          localObject3 = MMBitmapFactory.decodeByteArray((byte[])localObject3, 0, localObject3.length);
          if ((localObject3 != null) && (!((Bitmap)localObject3).isRecycled()))
          {
            localMMRoundCornerImageView.setImageBitmap((Bitmap)localObject3);
            localObject1 = com.tencent.xweb.util.d.getMessageDigest("".getBytes());
            localObject4 = com.tencent.mm.plugin.comm.b.qCp;
            localObject4 = getContext();
            if (localObject1 == null) {
              break label438;
            }
          }
        }
      }
      for (;;)
      {
        com.tencent.mm.plugin.comm.b.a((Context)localObject4, localView1, (Bitmap)localObject3, (String)localObject1);
        localView2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        localObject1 = localObject2;
        break;
        localView2.setBackgroundResource(2131234997);
        break label248;
        localObject1 = "";
      }
      AppMethodBeat.o(257977);
      return false;
    }
  }
  
  private void gYp()
  {
    AppMethodBeat.i(234518);
    d(false, null);
    AppMethodBeat.o(234518);
  }
  
  private boolean gYq()
  {
    AppMethodBeat.i(39428);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SendAppMessageWrapperUI", "blockInvalidToken block %b", new Object[] { Boolean.valueOf(this.QAc) });
    boolean bool = this.QAc;
    AppMethodBeat.o(39428);
    return bool;
  }
  
  private com.tencent.mm.pluginsdk.model.app.a gYr()
  {
    AppMethodBeat.i(39433);
    com.tencent.mm.pluginsdk.model.app.a locala = new com.tencent.mm.pluginsdk.model.app.a();
    if (this.QAa) {}
    for (int i = 1;; i = 0)
    {
      locala.JVJ = i;
      locala.pkgName = this.pkgName;
      locala.pkK = this.QAd;
      AppMethodBeat.o(39433);
      return locala;
    }
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
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SendAppMessageWrapperUI", "requestCode " + paramInt1 + " resultCode " + paramInt2);
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
      if ((this.pez.mediaObject instanceof WXVideoFileObject))
      {
        localObject = (WXVideoFileObject)this.pez.mediaObject;
        ((WXVideoFileObject)localObject).filePath = paramIntent.getStringExtra("K_SEGMENTVIDEOPATH");
        if ((!Util.isNullOrNil(((WXVideoFileObject)localObject).filePath)) && (s.YS(((WXVideoFileObject)localObject).filePath)))
        {
          gYp();
          AppMethodBeat.o(39429);
          return;
        }
        setResult(-5);
        finish();
        AppMethodBeat.o(39429);
        return;
      }
      if ((this.pez.mediaObject instanceof WXGameVideoFileObject))
      {
        localObject = (WXGameVideoFileObject)this.pez.mediaObject;
        ((WXGameVideoFileObject)localObject).filePath = paramIntent.getStringExtra("K_SEGMENTVIDEOPATH");
        if ((!Util.isNullOrNil(((WXGameVideoFileObject)localObject).filePath)) && (s.YS(((WXGameVideoFileObject)localObject).filePath)))
        {
          gYp();
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
    paramBundle = getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0);
    if (!paramBundle.getBoolean("settings_landscape_mode", false))
    {
      com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.SendAppMessageWrapperUI", "change orientation");
      this.QzZ = true;
      setRequestedOrientation(-1);
      paramBundle.edit().putBoolean("settings_landscape_mode", true).commit();
    }
    paramBundle = getIntent().getExtras();
    Object localObject1 = new SendMessageToWX.Req(paramBundle);
    this.toUser = paramBundle.getString("Select_Conv_User");
    this.QAa = paramBundle.getBoolean("SendAppMessageWrapper_TokenValid", true);
    this.pkgName = paramBundle.getString("SendAppMessageWrapper_PkgName", "");
    this.QAb = paramBundle.getBoolean("SendAppMessageWrapper_NoNeedStayInWeixin", false);
    this.QAc = paramBundle.getBoolean("SendAppMessageWrapper_BlockInvalidToken", false);
    this.sdkVersion = IntentUtil.getIntExtra(getIntent(), "_mmessage_sdkVersion", 0);
    this.scene = paramBundle.getInt("SendAppMessageWrapper_Scene", 0);
    this.Rcb = paramBundle.getString("SendAppMessageWrapper_AppId");
    if (this.Rcb == null) {
      this.Rcb = Uri.parse(paramBundle.getString("_mmessage_content")).getQueryParameter("appid");
    }
    this.QzY = new com.tencent.mm.pluginsdk.model.app.g();
    this.QzY.field_appId = this.Rcb;
    com.tencent.mm.pluginsdk.model.app.ao.eAS().get(this.QzY, new String[0]);
    if (this.QzY.field_appName == null) {}
    boolean bool;
    for (paramBundle = getString(2131757792);; paramBundle = com.tencent.mm.pluginsdk.model.app.h.a(getContext(), this.QzY, null))
    {
      this.source = getString(2131757790, new Object[] { paramBundle });
      this.pez = ((SendMessageToWX.Req)localObject1).message;
      bool = getIntent().getBooleanExtra("SendAppMessageWrapper_SkipCompressVideo", false);
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SendAppMessageWrapperUI", "onCreate, messageAction = %s, messageExt = %s, skipCompress = %b", new Object[] { this.pez.messageAction, this.pez.messageExt, Boolean.valueOf(bool) });
      if (this.scene != 1) {
        break label1400;
      }
      if (this.pez.mediaObject != null) {
        break;
      }
      finish();
      AppMethodBeat.o(39426);
      return;
    }
    Object localObject2;
    if (this.pez.getType() == 38)
    {
      localObject2 = (WXVideoFileObject)this.pez.mediaObject;
      localObject1 = this.pez.messageExt;
      paramBundle = ((WXVideoFileObject)localObject2).filePath;
      if ((Util.isNullOrNil(((WXVideoFileObject)localObject2).filePath)) || (!s.YS(((WXVideoFileObject)localObject2).filePath))) {
        finish();
      }
      if (bool)
      {
        if ((!Util.isNullOrNil(((WXVideoFileObject)localObject2).filePath)) && (s.YS(((WXVideoFileObject)localObject2).filePath)))
        {
          paramBundle = ((WXVideoFileObject)localObject2).filePath;
          if (paramBundle != null)
          {
            paramBundle = new File(paramBundle);
            if (!paramBundle.exists()) {}
          }
          for (paramBundle = com.tencent.xweb.util.d.al(paramBundle); Util.isEqual((String)localObject1, paramBundle); paramBundle = null)
          {
            d(bool, null);
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
      com.tencent.mm.br.c.b(this, "mmsight", ".segment.VideoCompressUI", (Intent)localObject1, 2);
      AppMethodBeat.o(39426);
      return;
    }
    if (this.pez.getType() == 39)
    {
      paramBundle = (WXGameVideoFileObject)this.pez.mediaObject;
      if (bool)
      {
        if ((!Util.isNullOrNil(paramBundle.filePath)) && (s.YS(paramBundle.filePath)))
        {
          paramBundle = paramBundle.filePath;
          int i = com.tencent.mm.n.h.aqJ().getInt("ShareVideoMaxSize", 104857600);
          if (s.boW(paramBundle) > i)
          {
            com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.ShareSnsImpl", "file len too big ");
            i = 1;
            if (i == 0) {
              break label731;
            }
            i = 1;
          }
          for (;;)
          {
            if (i != 0) {
              break label1195;
            }
            d(bool, null);
            AppMethodBeat.o(39426);
            return;
            i = 0;
            break;
            label731:
            paramBundle = a.a.PG(paramBundle);
            if ((paramBundle.videoWidth <= 0) || (paramBundle.videoHeight <= 0) || (paramBundle.videoWidth / paramBundle.videoHeight > 3.0F) || (paramBundle.videoWidth / paramBundle.videoHeight < 0.5F))
            {
              com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.ShareSnsImpl", "check ratio faild width = [%d], height = [%d]", new Object[] { Integer.valueOf(paramBundle.videoWidth), Integer.valueOf(paramBundle.videoHeight) });
              i = 1;
              label821:
              if (i == 0)
              {
                com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.ShareSnsImpl", "checkFormat() called with: item = [%s]", new Object[] { paramBundle });
                if (!Util.isNullOrNil(paramBundle.jkP))
                {
                  localObject1 = paramBundle.jkP;
                  if (!Util.isNullOrNil((String)localObject1)) {
                    break label970;
                  }
                  i = 1;
                  label868:
                  if ((i == 0) && ("video/avc".equalsIgnoreCase(paramBundle.jkQ)) && ((Util.isNullOrNil(paramBundle.jkR)) || ("audio/mp4a-latm".equalsIgnoreCase(paramBundle.jkR)))) {
                    break label1185;
                  }
                }
                com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.ShareSnsImpl", "check video format failed, dst format [video/avc], video format [%s]", new Object[] { paramBundle.jkQ });
                com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.ShareSnsImpl", "check video format failed, dst audioTrackMime [%s], video audioTrackMime [%s]", new Object[] { "audio/mp4a-latm", paramBundle.jkR });
              }
            }
            label1185:
            for (i = 1;; i = 0)
            {
              if (i == 0) {
                break label1190;
              }
              i = 1;
              break;
              i = 0;
              break label821;
              label970:
              if (com.tencent.mm.modelsns.a.jkO == null)
              {
                localObject2 = new HashSet();
                com.tencent.mm.modelsns.a.jkO = (Set)localObject2;
                ((Set)localObject2).add(".h264");
                com.tencent.mm.modelsns.a.jkO.add(".h26l");
                com.tencent.mm.modelsns.a.jkO.add(".264");
                com.tencent.mm.modelsns.a.jkO.add(".avc");
                com.tencent.mm.modelsns.a.jkO.add(".mov");
                com.tencent.mm.modelsns.a.jkO.add(".mp4");
                com.tencent.mm.modelsns.a.jkO.add(".m4a");
                com.tencent.mm.modelsns.a.jkO.add(".3gp");
                com.tencent.mm.modelsns.a.jkO.add(".3g2");
                com.tencent.mm.modelsns.a.jkO.add(".mj2");
                com.tencent.mm.modelsns.a.jkO.add(".m4v");
              }
              localObject1 = ((String)localObject1).trim();
              i = ((String)localObject1).lastIndexOf(".");
              if ((i < 0) || (i >= ((String)localObject1).length()))
              {
                i = 1;
                break label868;
              }
              if (!com.tencent.mm.modelsns.a.jkO.contains(((String)localObject1).substring(i).toLowerCase()))
              {
                i = 1;
                break label868;
              }
              i = 0;
              break label868;
            }
            label1190:
            i = 0;
          }
        }
        label1195:
        ReportUtil.a(this, ReportUtil.d(getIntent().getExtras(), -5), false);
        finish();
        AppMethodBeat.o(39426);
        return;
      }
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("K_SEGMENTVIDEOPATH", paramBundle.filePath);
      ((Intent)localObject1).putExtra("KSEGMENTVIDEOTHUMBPATH", "");
      com.tencent.mm.br.c.b(this, "mmsight", ".segment.VideoCompressUI", (Intent)localObject1, 2);
      AppMethodBeat.o(39426);
      return;
    }
    if (this.pez.getType() == 76)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SendAppMessageWrapperUI", "alvinluo sendMessageToWx shareMusicVideo to timeline");
      paramBundle = (WXMusicVideoObject)this.pez.mediaObject;
      if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
        this.tipDialog.dismiss();
      }
      this.tipDialog = com.tencent.mm.ui.base.q.a(this, getString(2131762446), true, 0, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
      });
      paramBundle = paramBundle.hdAlbumThumbFilePath;
      if (!Util.isNullOrNil(paramBundle)) {
        d.a(paramBundle, new d.a()
        {
          public final void be(String paramAnonymousString, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(234512);
            if (paramAnonymousBoolean)
            {
              Bundle localBundle = new Bundle();
              localBundle.putString("music_mv_cover_url", paramAnonymousString);
              SendAppMessageWrapperUI.a(SendAppMessageWrapperUI.this, localBundle);
              AppMethodBeat.o(234512);
              return;
            }
            com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SendAppMessageWrapperUI", "thumb img CDN upload fail!");
            paramAnonymousString = ReportUtil.d(SendAppMessageWrapperUI.this.getIntent().getExtras(), -1);
            ReportUtil.a(SendAppMessageWrapperUI.this, paramAnonymousString, false);
            SendAppMessageWrapperUI.this.finish();
            AppMethodBeat.o(234512);
          }
        });
      }
      AppMethodBeat.o(39426);
      return;
    }
    d(bool, null);
    AppMethodBeat.o(39426);
    return;
    label1400:
    this.timer.startTimer(100L);
    AppMethodBeat.o(39426);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(39430);
    super.onDestroy();
    if (this.QzZ)
    {
      com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.SendAppMessageWrapperUI", "restore orientation");
      SharedPreferences localSharedPreferences = getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SendAppMessageWrapperUI
 * JD-Core Version:    0.7.0.1
 */