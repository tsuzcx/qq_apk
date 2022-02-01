package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.bj;
import com.tencent.mm.autogen.a.qw;
import com.tencent.mm.autogen.a.xl;
import com.tencent.mm.autogen.a.xl.b;
import com.tencent.mm.autogen.a.zp;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.k.i;
import com.tencent.mm.model.ah;
import com.tencent.mm.model.ai;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.service.v;
import com.tencent.mm.plugin.findersdk.a.ca;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.plugin.websearch.api.al;
import com.tencent.mm.plugin.websearch.api.as;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.jsapi.e;
import com.tencent.mm.plugin.webview.jsapi.p;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo.WhichApp;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.contact.w;
import com.tencent.mm.ui.widget.a.g.a;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "PAGE_ABOUT_VERSION", "", "PAGE_BINDPHONEINFO", "PAGE_BINDPHONENUMBER", "PAGE_BINDQQ", "PAGE_BRANDSERVICEINDEXUI", "PAGE_CARDHOMEPAGEV3UI", "PAGE_CHANNEL", "PAGE_CHANNEL_AUTH", "PAGE_CHANNEL_PUBLISH", "PAGE_CHAT_BACKGROUND", "PAGE_CHAT_LOG", "PAGE_CHAT_LOG_MIGRATE", "PAGE_CONTACTMGRONLYCHATUI", "PAGE_CONTACTS", "PAGE_CONTACT_ADDFRIEND", "PAGE_CONTACT_BLACK_LIST", "PAGE_CONTACT_TAGLIST", "PAGE_CREATEROOM", "PAGE_DARK_MODE", "PAGE_DEEPLINK_SETNAME", "PAGE_DEEPLINK_SETTINGS", "PAGE_FACETOFACECREATEROOM", "PAGE_FAVORITES", "PAGE_FILE_HELPER", "PAGE_FINDER_MANAGERROOM", "PAGE_FREEZE_ACCOUNT", "PAGE_GLOBAL_SEARCH", "PAGE_GROUPS", "PAGE_LANGUAGE", "PAGE_LOGINDEVICEMANAGE", "PAGE_MASS_SEND", "PAGE_MESSAGENOTIFICATION", "PAGE_MINIPROGRAM", "PAGE_MODIFYALIASE", "PAGE_MYQRCODE", "PAGE_NEWFRIENDS", "PAGE_PLUGIN", "PAGE_PRIVACYMANAGE", "PAGE_PRIVACYMANAGE_TIMELINE", "PAGE_PRIVACYMANAGE_TIMELINE_BLACKLIST", "PAGE_QQMAILREMINDER", "PAGE_REGBYMOBILESETPWDUI", "PAGE_RINGTONESETTINGSUI", "PAGE_SETHEADPORTRAIT", "PAGE_SETTINGSACTIVETIMEUI", "PAGE_SETTINGSCAREMODEINTRO", "PAGE_SETTINGSMESSAGENOTIFICATIONUI", "PAGE_SETTINGSPERSONALMOREUI", "PAGE_SET_PAT", "PAGE_SHAKE", "PAGE_SHAKE_SETTING", "PAGE_STORAGEMANAGE", "PAGE_TEXTSTATUSDOWHATACTIVITY", "PAGE_TEXT_SIZE", "PAGE_TIMELINE_PUBLISH", "PAGE_TIMELINE_PUBLISHTEXT", "PAGE_TIMELINE_SETBACKGROUNDCOVER", "PAGE_TOOL_RECOVER", "PAGE_TOPSTORIES", "PAGE_VERSIONUPDATE", "PAGE_WX_CHAT_TEAM", "PAGE_WX_SPORT", "TAG", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "goBlackList", "", "context", "Landroid/content/Context;", "goDarkMode", "goFreezeAccount", "goSystemNotice", "goToContactTabUI", "goToLookOneLook", "goToPageAddMoreFriendsUISuffix", "goToPageBindQQUIUISuffix", "goToPageBindphoneInfoUISuffix", "goToPageChannelAuthUISuffix", "goToPageChannelPublishSuffix", "goToPageContactTaglistSuffix", "goToPageContactsSuffix", "goToPageCreateroomSuffix", "goToPageDeeplinkSetnameSuffix", "goToPageDeeplinkSettingsUIUISuffix", "goToPageFacetoFaceCreateroomSuffix", "goToPageFavUISuffix", "goToPageFileHelperSuffix", "goToPageFinderManagerSuffix", "goToPageLanguageUISuffix", "goToPageLoginDeviceManageUISuffix", "goToPageMINIProgramUISuffix", "goToPageMessageNotificationUIUISuffix", "goToPageModifyAliaseUISuffix", "goToPageMyqrcodeUISuffix", "goToPageNewfriendsUISuffix", "goToPagePhoneNumberBindsSuffix", "goToPagePluginUISuffix", "goToPagePrivacyManageTimeLineBlockListUIUISuffix", "goToPagePrivacyManageTimeLineUIUISuffix", "goToPagePrivacyManageUIUISuffix", "goToPageQQMailReminderUISuffix", "goToPageSetheadportraitUISuffix", "goToPageSettingsActiveTimeUIUISuffix", "goToPageShakeSettingsUISuffix", "goToPageShakeUISuffix", "goToPageStorageManageUISuffix", "goToPageTimelinePublishSuffix", "goToPageTimelinePublishTextUISuffix", "goToPageTimelineSetbackgroundCoverUISuffix", "goToPageToolRecoverSuffix", "goToPageVersionUpdateSuffix", "goToSetPatSuffix", "goWebView", "url", "showShare", "", "handleMsg", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "handlePageUrl", "pageUrl", "isDebug", "showErrorDialog", "startChattingUI", "userName", "startContactInfo", "username", "OpenWeiXinPageData", "OpenWeiXinPageTask", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class JsApiOpenWeiXinPage
  extends com.tencent.mm.plugin.webview.jsapi.c.a
{
  private static final int OOk;
  public static final JsApiOpenWeiXinPage XnJ;
  private static final String idA;
  
  static
  {
    AppMethodBeat.i(297787);
    XnJ = new JsApiOpenWeiXinPage();
    OOk = 396;
    idA = "openWeiXinPage";
    AppMethodBeat.o(297787);
  }
  
  private static final void aN(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(297783);
    Log.i("MicroMsg.JsApiOpenWeiXinPage", "showErrorDialog, has shown tip");
    AppMethodBeat.o(297783);
  }
  
  public static boolean dM(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(297726);
    Context localContext;
    Object localObject;
    int i;
    label242:
    boolean bool1;
    label5262:
    for (;;)
    {
      try
      {
        localContext = MMApplicationContext.getContext();
        s.s(localContext, "getContext()");
        localObject = "";
        if (paramBoolean)
        {
          if (paramString != null) {
            localObject = paramString;
          }
          Log.i("MicroMsg.JsApiOpenWeiXinPage", s.X("handlePageUrl pagePath:", localObject));
          if (!kotlin.n.n.T((String)localObject, "page/wesport", true)) {
            break label278;
          }
          paramString = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE("gh_43f2581f6fd6");
          if ((paramString != null) && (com.tencent.mm.contact.d.rs(paramString.field_type) == true))
          {
            i = 1;
            if (i == 0) {
              break label242;
            }
            paramString = new Intent();
            paramString.putExtra("Chat_User", "gh_43f2581f6fd6");
            paramString.putExtra("finish_direct", true);
            paramString.putExtra("chat_from_scene", 5);
            com.tencent.mm.br.c.g(localContext, ".ui.chatting.ChattingUI", paramString);
            paramBoolean = true;
            AppMethodBeat.o(297726);
            return paramBoolean;
          }
        }
        else
        {
          localObject = Uri.parse(paramString);
          paramString = ((Uri)localObject).getScheme();
          localObject = s.X(((Uri)localObject).getHost(), ((Uri)localObject).getPath());
          Log.i("MicroMsg.JsApiOpenWeiXinPage", "handlePageUrl scheme:" + paramString + " pagePath:" + (String)localObject);
          continue;
        }
        i = 0;
      }
      finally
      {
        Log.printErrStackTrace("MicroMsg.JsApiOpenWeiXinPage", paramString, "handlePageErr!!", new Object[0]);
        AppMethodBeat.o(297726);
        return false;
      }
      continue;
      paramString = new Intent();
      paramString.putExtra("Contact_User", "gh_43f2581f6fd6");
      com.tencent.mm.br.c.b(localContext, "profile", ".ui.ContactInfoUI", paramString);
      paramBoolean = true;
      continue;
      label278:
      if (kotlin.n.n.T((String)localObject, "page/wechatteam", true))
      {
        paramString = new Intent();
        paramString.putExtra("Chat_User", "weixin");
        paramString.putExtra("finish_direct", true);
        paramString.putExtra("specific_chat_from_scene", 3);
        paramString.putExtra("preChatTYPE", 9);
        paramString.putExtra("chat_from_scene", 5);
        com.tencent.mm.br.c.g(localContext, ".ui.chatting.ChattingUI", paramString);
        paramBoolean = true;
      }
      else if (kotlin.n.n.T((String)localObject, "page/masssend", true))
      {
        if (z.bBx())
        {
          paramString = new Intent();
          paramString.putExtra("finish_direct", true);
          com.tencent.mm.br.c.b(localContext, "masssend", ".ui.MassSendHistoryUI", paramString);
          paramBoolean = true;
        }
        else
        {
          com.tencent.mm.br.c.b(localContext, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", "masssendapp"));
          paramBoolean = true;
        }
      }
      else if (kotlin.n.n.T((String)localObject, "page/groups", true))
      {
        paramString = new Intent();
        paramString.setClassName(localContext, "com.tencent.mm.ui.contact.ChatroomContactUI");
        paramString.addFlags(268435456);
        paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
        com.tencent.mm.hellhoundlib.a.a.b(localContext, paramString.aYi(), "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "handlePageUrl", "(Ljava/lang/String;Z)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localContext.startActivity((Intent)paramString.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "handlePageUrl", "(Ljava/lang/String;Z)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramBoolean = true;
      }
      else if (kotlin.n.n.T((String)localObject, "page/textsize", true))
      {
        paramString = new Intent();
        paramString.setClassName(localContext, "com.tencent.mm.plugin.setting.ui.setting.SettingsFontUI");
        paramString.addFlags(268435456);
        paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
        com.tencent.mm.hellhoundlib.a.a.b(localContext, paramString.aYi(), "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "handlePageUrl", "(Ljava/lang/String;Z)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localContext.startActivity((Intent)paramString.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "handlePageUrl", "(Ljava/lang/String;Z)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramBoolean = true;
      }
      else if (kotlin.n.n.T((String)localObject, "page/securitycenter", true))
      {
        localObject = i.aRC().getValue("WeChatSafeCenterUrl");
        Log.i("MicroMsg.JsApiOpenWeiXinPage", "safe center url %s", new Object[] { localObject });
        paramString = (String)localObject;
        if (Util.isNullOrNil((String)localObject)) {
          paramString = s.X(localContext.getString(c.i.wechat_securiy_center_path), LocaleUtil.getApplicationLanguage());
        }
        localObject = new Intent();
        ((Intent)localObject).putExtra("rawUrl", paramString);
        ((Intent)localObject).putExtra("showShare", true);
        ((Intent)localObject).putExtra("show_bottom", false);
        ((Intent)localObject).putExtra("needRedirect", false);
        ((Intent)localObject).putExtra("hardcode_jspermission", (Parcelable)JsapiPermissionWrapper.YxF);
        ((Intent)localObject).putExtra("hardcode_general_ctrl", (Parcelable)GeneralControlWrapper.YxA);
        com.tencent.mm.br.c.b(localContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", (Intent)localObject);
        paramBoolean = true;
      }
      else if (kotlin.n.n.T((String)localObject, "page/contactblacklist", true))
      {
        paramString = ai.Js(localContext.getString(c.i.group_blacklist));
        localObject = new Intent();
        ((Intent)localObject).putExtra("filter_type", paramString.getType());
        ((Intent)localObject).putExtra("titile", localContext.getString(c.i.settings_private_blacklist));
        ((Intent)localObject).putExtra("list_attr", 32768);
        ((Intent)localObject).addFlags(268435456);
        ((Intent)localObject).setClassName(localContext, "com.tencent.mm.ui.contact.SelectSpecialContactUI");
        paramString = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(localContext, paramString.aYi(), "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goBlackList", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localContext.startActivity((Intent)paramString.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goBlackList", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramBoolean = true;
      }
      else if (kotlin.n.n.T((String)localObject, "page/darkmode", true))
      {
        MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putBoolean("dark_mode_red_dot", false);
        paramString = new Intent();
        paramString.setClassName(localContext, "com.tencent.mm.plugin.setting.ui.setting.SettingDarkMode");
        paramString.addFlags(268435456);
        paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
        com.tencent.mm.hellhoundlib.a.a.b(localContext, paramString.aYi(), "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goDarkMode", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localContext.startActivity((Intent)paramString.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goDarkMode", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramBoolean = true;
      }
      else
      {
        if (kotlin.n.n.T((String)localObject, "page/aboutversion", true))
        {
          com.tencent.mm.kernel.h.baC();
          i = com.tencent.mm.kernel.b.getUin();
          paramString = com.tencent.mm.kernel.h.baE().ban().d(12304, null);
          if (paramString == null)
          {
            paramString = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(297726);
            throw paramString;
          }
          int j = Util.nullAsNil(Integer.valueOf(((Integer)paramString).intValue()));
          paramString = localContext.getString(c.i.settings_system_notice_url, new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          s.s(paramString, "context.getString(R.stri…otice_url, uin, newCount)");
          if (kotlin.n.n.bp((CharSequence)paramString)) {
            break label6956;
          }
          com.tencent.mm.kernel.h.baE().ban().B(12304, Integer.valueOf(0));
          localObject = new Intent();
          ((Intent)localObject).putExtra("title", localContext.getString(c.i.settings_system_notice));
          ((Intent)localObject).putExtra("rawUrl", paramString);
          ((Intent)localObject).putExtra("showShare", false);
          com.tencent.mm.br.c.b(localContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
          break label6956;
        }
        if (kotlin.n.n.T((String)localObject, "page/globalsearch", true))
        {
          com.tencent.mm.plugin.fts.a.d.b(localContext, ".ui.FTSMainUI", new Intent(), null);
          paramBoolean = true;
        }
        else if (kotlin.n.n.T((String)localObject, "page/chatlogmigrate", true))
        {
          paramString = new Intent();
          paramString.setClassName(localContext, "com.tencent.mm.plugin.backup.backupmoveui.BackupUI");
          MMWizardActivity.aQ(localContext, paramString);
          paramBoolean = true;
        }
        else if (kotlin.n.n.T((String)localObject, "page/chatlog", true))
        {
          paramString = new Intent().setClassName(localContext, "com.tencent.mm.plugin.backup.backupui.BackupChooseBackupModeUI");
          s.s(paramString, "Intent().setClassName(co…ackupChooseBackupModeUI\")");
          paramString.addFlags(268435456);
          paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
          com.tencent.mm.hellhoundlib.a.a.b(localContext, paramString.aYi(), "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "handlePageUrl", "(Ljava/lang/String;Z)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localContext.startActivity((Intent)paramString.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "handlePageUrl", "(Ljava/lang/String;Z)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramBoolean = true;
        }
        else if (kotlin.n.n.T((String)localObject, "page/chatbackground", true))
        {
          paramString = new Intent();
          paramString.setClassName(localContext, "com.tencent.mm.plugin.setting.ui.setting.SettingsChattingBackgroundUI");
          paramString.addFlags(268435456);
          paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
          com.tencent.mm.hellhoundlib.a.a.b(localContext, paramString.aYi(), "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "handlePageUrl", "(Ljava/lang/String;Z)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localContext.startActivity((Intent)paramString.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "handlePageUrl", "(Ljava/lang/String;Z)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramBoolean = true;
        }
        else if (kotlin.n.n.T((String)localObject, "page/setpat", true))
        {
          paramString = new Intent();
          paramString.setClassName(localContext, "com.tencent.mm.plugin.setting.ui.setting.SettingsModifyPatSuffixUI");
          paramString.addFlags(268435456);
          paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
          com.tencent.mm.hellhoundlib.a.a.b(localContext, paramString.aYi(), "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goToSetPatSuffix", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localContext.startActivity((Intent)paramString.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goToSetPatSuffix", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramBoolean = true;
        }
        else if (kotlin.n.n.T((String)localObject, "page/channel/publish", true))
        {
          paramString = new Intent();
          paramString.setClassName(localContext, "com.tencent.mm.plugin.finder.ui.FinderSelfUI");
          paramString.addFlags(268435456);
          paramString.putExtra("key_need_done_post_action", true);
          paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
          com.tencent.mm.hellhoundlib.a.a.b(localContext, paramString.aYi(), "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goToPageChannelPublishSuffix", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localContext.startActivity((Intent)paramString.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goToPageChannelPublishSuffix", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramBoolean = true;
        }
        else if (kotlin.n.n.T((String)localObject, "page/tool/recover", true))
        {
          paramString = new Intent();
          paramString.setClassName(localContext, "com.tencent.mm.plugin.dbbackup.DBRecoveryUI");
          paramString.addFlags(268435456);
          paramString.putExtra("scene", 3);
          paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
          com.tencent.mm.hellhoundlib.a.a.b(localContext, paramString.aYi(), "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goToPageToolRecoverSuffix", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localContext.startActivity((Intent)paramString.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goToPageToolRecoverSuffix", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramBoolean = true;
        }
        else if (kotlin.n.n.T((String)localObject, "page/fileHelper", true))
        {
          paramString = new Intent();
          paramString.putExtra("Contact_User", "filehelper");
          paramString.putExtra("CONTACT_INFO_UI_SOURCE", 23);
          paramString.addFlags(268435456);
          com.tencent.mm.br.c.b(localContext, "profile", ".ui.ContactInfoUI", paramString);
          ((com.tencent.mm.plugin.textstatus.a.f)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.textstatus.a.f.class)).report22210("filehelper", 10L);
          paramBoolean = true;
        }
        else if (kotlin.n.n.T((String)localObject, "page/contact/faceToFaceCreateRoom", true))
        {
          com.tencent.mm.plugin.report.service.h.OAn.b(11140, new Object[] { Integer.valueOf(0) });
          com.tencent.mm.br.c.ai(localContext, "pwdgroup", ".ui.FacingCreateChatRoomAllInOneUI");
          paramBoolean = true;
        }
        else if (kotlin.n.n.T((String)localObject, "page/deeplink/groupchat", true))
        {
          paramString = new Intent();
          paramString.setClassName(localContext, "com.tencent.mm.ui.contact.SelectContactUI");
          com.tencent.luggage.sdk.h.a.ce(paramString);
          paramString.putExtra("titile", localContext.getString(c.i.address_title_launch_chatting));
          paramString.putExtra("list_type", 0);
          paramString.addFlags(268435456);
          paramString.putExtra("list_attr", w.R(new int[] { w.affr, 256, 512 }));
          paramString.putExtra("scene", 7);
          paramString.putExtra("menu_mode", 2);
          paramString.putExtra("create_group_recommend", true);
          paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
          com.tencent.mm.hellhoundlib.a.a.b(localContext, paramString.aYi(), "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goToPageCreateroomSuffix", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localContext.startActivity((Intent)paramString.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goToPageCreateroomSuffix", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramBoolean = true;
        }
        else if (kotlin.n.n.T((String)localObject, "page/tool/discoverPageManage", true))
        {
          kV(localContext);
          paramBoolean = true;
        }
        else if (kotlin.n.n.T((String)localObject, "page/contacts", true))
        {
          MMHandlerThread.postToMainThreadDelayed(JsApiOpenWeiXinPage..ExternalSyntheticLambda2.INSTANCE, 300L);
          if ((localContext instanceof MMActivity)) {
            ((MMActivity)localContext).hideVKB();
          }
          paramString = new Intent();
          paramString.addFlags(268435456);
          paramString.addFlags(67108864);
          paramString.setClassName(localContext, "com.tencent.mm.ui.LauncherUI");
          paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
          com.tencent.mm.hellhoundlib.a.a.b(localContext, paramString.aYi(), "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goToContactTabUI", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localContext.startActivity((Intent)paramString.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goToContactTabUI", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramBoolean = true;
        }
        else if (kotlin.n.n.T((String)localObject, "page/tool/bindPhoneNumber", true))
        {
          paramString = new Intent();
          paramString.setClassName(localContext, "com.tencent.mm.plugin.setting.ui.setting.SettingsAccountInfoUI");
          paramString.addFlags(268435456);
          paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
          com.tencent.mm.hellhoundlib.a.a.b(localContext, paramString.aYi(), "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goToPagePhoneNumberBindsSuffix", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localContext.startActivity((Intent)paramString.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goToPagePhoneNumberBindsSuffix", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramBoolean = true;
        }
        else if (kotlin.n.n.T((String)localObject, "page/deeplink/setname", true))
        {
          paramString = new Intent();
          paramString.setClassName(localContext, "com.tencent.mm.plugin.setting.ui.setting.SettingsModifyNameUI");
          paramString.addFlags(268435456);
          paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
          com.tencent.mm.hellhoundlib.a.a.b(localContext, paramString.aYi(), "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goToPageDeeplinkSetnameSuffix", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localContext.startActivity((Intent)paramString.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goToPageDeeplinkSetnameSuffix", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramBoolean = true;
        }
        else if (kotlin.n.n.T((String)localObject, "page/versionUpdate", true))
        {
          paramString = new Intent();
          paramString.setClassName(localContext, "com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMicroMsgUI");
          paramString.addFlags(268435456);
          paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
          com.tencent.mm.hellhoundlib.a.a.b(localContext, paramString.aYi(), "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goToPageVersionUpdateSuffix", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localContext.startActivity((Intent)paramString.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goToPageVersionUpdateSuffix", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramBoolean = true;
        }
        else if (kotlin.n.n.T((String)localObject, "page/timeline/publish", true))
        {
          if ((z.bBf() & 0x8000) != 0) {
            break label6961;
          }
          paramBoolean = true;
          label2923:
          if ((paramBoolean) && (com.tencent.mm.br.c.blq("sns")))
          {
            paramString = new Intent();
            paramString.setFlags(268435456);
            paramString.addFlags(67108864);
            paramString.setClassName(MMApplicationContext.getContext(), "com.tencent.mm.plugin.sns.ui.SnsTimeLineUI");
            paramString.putExtra("sns_timeline_NeedFirstLoadint", true);
            paramString.putExtra("sns_timeline_NeedShowPushlistDialog", true);
            paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
            com.tencent.mm.hellhoundlib.a.a.b(localContext, paramString.aYi(), "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goToPageTimelinePublishSuffix", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localContext.startActivity((Intent)paramString.sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goToPageTimelinePublishSuffix", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramBoolean = true;
          }
          else
          {
            Log.i("MicroMsg.JsApiOpenWeiXinPage", s.X("goToPageTimelinePublishSuffix, enable = ", Boolean.valueOf(paramBoolean)));
            paramBoolean = true;
          }
        }
        else if (kotlin.n.n.T((String)localObject, "page/contact/tagList", true))
        {
          paramString = new Intent();
          paramString.setClassName(localContext, "com.tencent.mm.plugin.label.ui.ContactLabelManagerUI");
          paramString.addFlags(268435456);
          paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
          com.tencent.mm.hellhoundlib.a.a.b(localContext, paramString.aYi(), "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goToPageContactTaglistSuffix", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localContext.startActivity((Intent)paramString.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goToPageContactTaglistSuffix", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramBoolean = true;
        }
        else if (kotlin.n.n.T((String)localObject, "page/contact/addFriend", true))
        {
          paramString = new Intent();
          paramString.setClassName(localContext, "com.tencent.mm.plugin.subapp.ui.pluginapp.AddMoreFriendsUI");
          paramString.addFlags(268435456);
          paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
          com.tencent.mm.hellhoundlib.a.a.b(localContext, paramString.aYi(), "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goToPageAddMoreFriendsUISuffix", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localContext.startActivity((Intent)paramString.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goToPageAddMoreFriendsUISuffix", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramBoolean = true;
        }
        else if (kotlin.n.n.T((String)localObject, "page/channel/auth", true))
        {
          paramString = new zp();
          paramString.icM.userName = "gh_4ee148a6ecaa@app";
          paramString.icM.appId = "wxdfda2588e999a42d";
          paramString.icM.icO = "pages/index/index.html";
          paramString.icM.scene = 1201;
          paramString.publish();
          paramBoolean = true;
        }
        else if (kotlin.n.n.T((String)localObject, "page/favorites", true))
        {
          com.tencent.mm.plugin.fav.a.b.b(localContext, ".ui.FavoriteIndexUI", new Intent());
          paramBoolean = true;
        }
        else if (kotlin.n.n.T((String)localObject, "page/modifyAliase", true))
        {
          if ((Util.isNullOrNil(z.bAN())) && (au.bxc(z.bAM())) && (i.aRC().getInt("EnableModAlias", 0) == 0))
          {
            paramString = new Intent();
            paramString.setClassName(localContext, "com.tencent.mm.plugin.setting.ui.setting.SettingsCreateAliasUI");
            paramString.addFlags(268435456);
            paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
            com.tencent.mm.hellhoundlib.a.a.b(localContext, paramString.aYi(), "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goToPageModifyAliaseUISuffix", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localContext.startActivity((Intent)paramString.sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goToPageModifyAliaseUISuffix", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramBoolean = true;
          }
          else
          {
            if (i.aRC().getInt("EnableModAlias", 0) == 0) {
              break label6966;
            }
            paramString = new Intent();
            paramString.setClassName(localContext, "com.tencent.mm.plugin.setting.ui.setting.SettingsAliasUI");
            paramString.putExtra("WizardRootClass", "com.tencent.mm.plugin.setting.ui.setting.SettingsAccountInfoUI");
            paramString.addFlags(268435456);
            MMWizardActivity.aQ(localContext, paramString);
            break label6966;
          }
        }
        else if (kotlin.n.n.T((String)localObject, "page/setHeadPortrait", true))
        {
          paramString = new Intent();
          paramString.setClassName(localContext, "com.tencent.mm.plugin.setting.ui.setting.PreviewHdHeadImg");
          paramString.putExtra("need_show_menu_choose", true);
          paramString.addFlags(268435456);
          paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
          com.tencent.mm.hellhoundlib.a.a.b(localContext, paramString.aYi(), "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goToPageSetheadportraitUISuffix", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localContext.startActivity((Intent)paramString.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goToPageSetheadportraitUISuffix", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramBoolean = true;
        }
        else if (kotlin.n.n.T((String)localObject, "page/storageManage", true))
        {
          paramString = new Intent();
          paramString.setClassName(localContext, "com.tencent.mm.plugin.clean.ui.fileindexui.CleanNewUI");
          paramString.addFlags(268435456);
          paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
          com.tencent.mm.hellhoundlib.a.a.b(localContext, paramString.aYi(), "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goToPageStorageManageUISuffix", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localContext.startActivity((Intent)paramString.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goToPageStorageManageUISuffix", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramBoolean = true;
        }
        else if (kotlin.n.n.T((String)localObject, "page/newFriends", true))
        {
          com.tencent.mm.br.c.b(localContext, "subapp", ".ui.friend.FMessageConversationUI", new Intent());
          paramBoolean = true;
        }
        else if (kotlin.n.n.T((String)localObject, "page/settingsActiveTimeUI", true))
        {
          paramString = new Intent();
          paramString.setClassName(localContext, "com.tencent.mm.plugin.setting.ui.setting.SettingsActiveTimeUI");
          paramString.addFlags(268435456);
          paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
          com.tencent.mm.hellhoundlib.a.a.b(localContext, paramString.aYi(), "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goToPageSettingsActiveTimeUIUISuffix", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localContext.startActivity((Intent)paramString.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goToPageSettingsActiveTimeUIUISuffix", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramBoolean = true;
        }
        else if (kotlin.n.n.T((String)localObject, "page/privacyManage", true))
        {
          paramString = new Intent();
          paramString.addFlags(268435456);
          com.tencent.mm.br.c.b(localContext, "setting", ".ui.setting.SettingsPrivacyUI", paramString);
          paramBoolean = true;
        }
        else if (kotlin.n.n.T((String)localObject, "page/privacyManage/timeline", true))
        {
          paramString = new Intent();
          paramString.addFlags(268435456);
          com.tencent.mm.br.c.b(localContext, "setting", ".ui.setting.SettingsSnsPrivacyUI", paramString);
          paramBoolean = true;
        }
        else if (kotlin.n.n.T((String)localObject, "page/privacyManage/timeline/blackList", true))
        {
          paramString = new Intent();
          paramString.putExtra("k_sns_tag_id", 4L);
          paramString.putExtra("k_sns_from_settings_about_sns", 1);
          paramString.addFlags(268435456);
          paramString.setClassName(localContext, "com.tencent.mm.ui.contact.privacy.SnsTagDetailUI");
          paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
          com.tencent.mm.hellhoundlib.a.a.b(localContext, paramString.aYi(), "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goToPagePrivacyManageTimeLineBlockListUIUISuffix", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localContext.startActivity((Intent)paramString.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goToPagePrivacyManageTimeLineBlockListUIUISuffix", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramBoolean = true;
        }
        else if (kotlin.n.n.T((String)localObject, "page/deeplink/settings", true))
        {
          com.tencent.mm.br.c.b(localContext, "setting", ".ui.setting.SettingsUI", new Intent());
          paramBoolean = true;
        }
        else if (kotlin.n.n.T((String)localObject, "page/messageNotification", true))
        {
          paramString = new Intent();
          paramString.setClassName(localContext, "com.tencent.mm.plugin.setting.ui.setting.SettingsNotificationUI");
          paramString.addFlags(268435456);
          paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
          com.tencent.mm.hellhoundlib.a.a.b(localContext, paramString.aYi(), "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goToPageMessageNotificationUIUISuffix", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localContext.startActivity((Intent)paramString.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goToPageMessageNotificationUIUISuffix", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramBoolean = true;
        }
        else if (kotlin.n.n.T((String)localObject, "page/bindPhoneInfo", true))
        {
          paramString = new Intent();
          paramString.setClassName(localContext, "com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI");
          paramString.addFlags(268435456);
          paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
          com.tencent.mm.hellhoundlib.a.a.b(localContext, paramString.aYi(), "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goToPageBindphoneInfoUISuffix", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localContext.startActivity((Intent)paramString.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goToPageBindphoneInfoUISuffix", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramBoolean = true;
        }
        else if (kotlin.n.n.T((String)localObject, "page/timeline/publishText", true))
        {
          if ((z.bBf() & 0x8000) != 0) {
            break label6971;
          }
          paramBoolean = true;
          label4556:
          if ((paramBoolean) && (com.tencent.mm.br.c.blq("sns")))
          {
            paramString = new Intent();
            paramString.setFlags(268435456);
            paramString.addFlags(67108864);
            paramString.setClassName(MMApplicationContext.getContext(), "com.tencent.mm.plugin.sns.ui.SnsTimeLineUI");
            paramString.putExtra("sns_timeline_NeedFirstLoadint", true);
            paramString.putExtra("sns_timeline_NeedShowPulistText", true);
            paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
            com.tencent.mm.hellhoundlib.a.a.b(localContext, paramString.aYi(), "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goToPageTimelinePublishTextUISuffix", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localContext.startActivity((Intent)paramString.sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goToPageTimelinePublishTextUISuffix", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramBoolean = true;
          }
          else
          {
            Log.i("MicroMsg.JsApiOpenWeiXinPage", s.X("goToPageTimelinePublishSuffix, enable = ", Boolean.valueOf(paramBoolean)));
            paramBoolean = true;
          }
        }
        else if (kotlin.n.n.T((String)localObject, "page/loginDeviceManage", true))
        {
          com.tencent.mm.br.c.ai(localContext, "account", ".security.ui.MySafeDeviceListUI");
          paramBoolean = true;
        }
        else if (kotlin.n.n.T((String)localObject, "page/bindQQ", true))
        {
          paramString = new Intent();
          paramString.setClassName(localContext, "com.tencent.mm.plugin.account.bind.ui.BindQQUI");
          paramString.addFlags(268435456);
          paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
          com.tencent.mm.hellhoundlib.a.a.b(localContext, paramString.aYi(), "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goToPageBindQQUIUISuffix", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localContext.startActivity((Intent)paramString.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goToPageBindQQUIUISuffix", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramBoolean = true;
        }
        else if (kotlin.n.n.T((String)localObject, "page/shake", true))
        {
          if ((z.bBf() & 0x100) != 0L) {
            break label6976;
          }
          i = 1;
          label4895:
          if (i != 0)
          {
            paramString = new Intent();
            paramString.setClassName(localContext, "com.tencent.mm.plugin.shake.ui.ShakeReportUI");
            paramString.addFlags(268435456);
            paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
            com.tencent.mm.hellhoundlib.a.a.b(localContext, paramString.aYi(), "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goToPageShakeUISuffix", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localContext.startActivity((Intent)paramString.sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goToPageShakeUISuffix", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramBoolean = true;
          }
          else
          {
            kV(localContext);
            paramBoolean = true;
          }
        }
        else if (kotlin.n.n.T((String)localObject, "page/shake/setting", true))
        {
          paramString = new Intent();
          paramString.setClassName(localContext, "com.tencent.mm.plugin.shake.ui.ShakePersonalInfoUI");
          paramString.addFlags(268435456);
          paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
          com.tencent.mm.hellhoundlib.a.a.b(localContext, paramString.aYi(), "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goToPageShakeSettingsUISuffix", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localContext.startActivity((Intent)paramString.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goToPageShakeSettingsUISuffix", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramBoolean = true;
        }
        else if (kotlin.n.n.T((String)localObject, "page/miniProgram", true))
        {
          paramString = new xl();
          paramString.iaO.iaQ = true;
          paramString.publish();
          bool1 = paramString.iaP.iaR;
          if ((!((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu()) || (((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).eZD() != 2)) {
            break label6981;
          }
          paramBoolean = true;
          label5212:
          Log.i("MicroMsg.JsApiOpenWeiXinPage", "shouldShowMiniProgram %s, isTeenModeAndNotAccessRight:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(paramBoolean) });
          if ((!bool1) || (paramBoolean)) {
            break label6951;
          }
          if ((z.bAR() & 0x1000000) != 0L) {
            break label6986;
          }
          i = 1;
          if (i != 0)
          {
            ((v)com.tencent.mm.kernel.h.ax(v.class)).T(localContext, 16);
            paramBoolean = true;
          }
          else
          {
            kV(localContext);
            paramBoolean = true;
          }
        }
        else if (kotlin.n.n.T((String)localObject, "page/qqMailReminder", true))
        {
          paramString = new Intent();
          paramString.putExtra("Contact_User", "qqmail");
          com.tencent.mm.br.c.b(localContext, "profile", ".ui.ContactInfoUI", paramString);
          paramBoolean = true;
        }
        else if (kotlin.n.n.T((String)localObject, "page/plugin", true))
        {
          kW(localContext);
          paramBoolean = true;
        }
        else
        {
          if (!kotlin.n.n.T((String)localObject, "page/MyQRCode", true)) {
            break;
          }
          kX(localContext);
          paramBoolean = true;
        }
      }
    }
    if (kotlin.n.n.T((String)localObject, "page/TopStories", true)) {
      if ((z.bAR() & 0x4000000) != 0L) {
        break label6991;
      }
    }
    label6951:
    label6956:
    label6961:
    label6966:
    label6971:
    label6976:
    label6981:
    label6986:
    label6991:
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramString = com.tencent.mm.kernel.h.baE().ban().d(274436, null);
      if (paramString == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(297726);
        throw paramString;
      }
      if (com.tencent.mm.au.b.OE((String)paramString))
      {
        Log.i("MicroMsg.JsApiOpenWeiXinPage", "european user");
        paramBoolean = false;
      }
      for (bool1 = false;; bool1 = true)
      {
        boolean bool2 = ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu();
        Log.i("MicroMsg.JsApiOpenWeiXinPage", "isInExperiment %s ,openLook %s, isTeenMode:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool2) });
        if ((bool1) && (paramBoolean) && (!bool2))
        {
          la(localContext);
          paramBoolean = true;
          break;
        }
        kV(localContext);
        paramBoolean = true;
        break;
        if (kotlin.n.n.T((String)localObject, "page/language", true))
        {
          kY(localContext);
          paramBoolean = true;
          break;
        }
        if (kotlin.n.n.T((String)localObject, "page/timeline/setBackgroundCover", true))
        {
          kZ(localContext);
          paramBoolean = true;
          break;
        }
        if (kotlin.n.n.T((String)localObject, "page/channel", true))
        {
          if ((localContext instanceof Activity))
          {
            paramString = new Bundle();
            paramString.putString("realname_verify_process_jump_activity", ((cn)com.tencent.mm.kernel.h.az(cn.class)).getFinderUtilApi().fgJ());
            paramString.putString("realname_verify_process_jump_plugin", "finder");
            ((com.tencent.mm.plugin.wxpaysdk.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.wxpaysdk.api.c.class)).h((Activity)localContext, paramString);
            paramBoolean = true;
            break;
          }
          Log.i("MicroMsg.JsApiOpenWeiXinPage", "context is no activity.");
          paramString = new Intent();
          paramString.setClassName(localContext, ((cn)com.tencent.mm.kernel.h.az(cn.class)).getFinderUtilApi().fgI());
          paramString.addFlags(268435456);
          paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
          com.tencent.mm.hellhoundlib.a.a.b(localContext, paramString.aYi(), "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "handlePageUrl", "(Ljava/lang/String;Z)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localContext.startActivity((Intent)paramString.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "handlePageUrl", "(Ljava/lang/String;Z)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramBoolean = true;
          break;
        }
        if (kotlin.n.n.T((String)localObject, "page/RegByMobileSetPwdUI", true))
        {
          paramString = new Intent();
          paramString.setClassName(localContext, "com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI");
          paramString.addFlags(268435456);
          paramString.putExtra("kintent_hint", localContext.getResources().getString(c.i.settings_modify_password_tip));
          paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
          com.tencent.mm.hellhoundlib.a.a.b(localContext, paramString.aYi(), "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "handlePageUrl", "(Ljava/lang/String;Z)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localContext.startActivity((Intent)paramString.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "handlePageUrl", "(Ljava/lang/String;Z)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramBoolean = true;
          break;
        }
        if (kotlin.n.n.T((String)localObject, "page/ContactMgrOnlyChatUI", true))
        {
          paramString = new Intent();
          paramString.setClassName(localContext, "com.tencent.mm.ui.contact.privacy.ContactMgrOnlyChatUI");
          paramString.addFlags(268435456);
          paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
          com.tencent.mm.hellhoundlib.a.a.b(localContext, paramString.aYi(), "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "handlePageUrl", "(Ljava/lang/String;Z)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localContext.startActivity((Intent)paramString.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "handlePageUrl", "(Ljava/lang/String;Z)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramBoolean = true;
          break;
        }
        if (kotlin.n.n.T((String)localObject, "page/CardHomePageV3UI", true))
        {
          paramString = new Intent();
          paramString.setClassName(localContext, "com.tencent.mm.plugin.card.ui.v3.CardHomePageV3UI");
          paramString.addFlags(268435456);
          paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
          com.tencent.mm.hellhoundlib.a.a.b(localContext, paramString.aYi(), "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "handlePageUrl", "(Ljava/lang/String;Z)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localContext.startActivity((Intent)paramString.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "handlePageUrl", "(Ljava/lang/String;Z)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramBoolean = true;
          break;
        }
        if (kotlin.n.n.T((String)localObject, "page/SettingsPersonalMoreUI", true))
        {
          paramString = new Intent();
          paramString.setClassName(localContext, "com.tencent.mm.plugin.setting.ui.setting.SettingsPersonalMoreUI");
          paramString.addFlags(268435456);
          paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
          com.tencent.mm.hellhoundlib.a.a.b(localContext, paramString.aYi(), "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "handlePageUrl", "(Ljava/lang/String;Z)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localContext.startActivity((Intent)paramString.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "handlePageUrl", "(Ljava/lang/String;Z)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramBoolean = true;
          break;
        }
        if (kotlin.n.n.T((String)localObject, "page/BrandServiceIndexUI", true))
        {
          paramString = new Intent();
          paramString.setClassName(localContext, "com.tencent.mm.plugin.brandservice.ui.BrandServiceIndexUI");
          paramString.addFlags(268435456);
          paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
          com.tencent.mm.hellhoundlib.a.a.b(localContext, paramString.aYi(), "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "handlePageUrl", "(Ljava/lang/String;Z)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localContext.startActivity((Intent)paramString.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "handlePageUrl", "(Ljava/lang/String;Z)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramBoolean = true;
          break;
        }
        if (kotlin.n.n.T((String)localObject, "page/TextStatusDoWhatActivity", true))
        {
          paramString = new Intent();
          paramString.setClassName(localContext, "com.tencent.mm.plugin.textstatus.ui.TextStatusDoWhatActivity");
          paramString.addFlags(268435456);
          paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
          com.tencent.mm.hellhoundlib.a.a.b(localContext, paramString.aYi(), "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "handlePageUrl", "(Ljava/lang/String;Z)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localContext.startActivity((Intent)paramString.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "handlePageUrl", "(Ljava/lang/String;Z)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramBoolean = true;
          break;
        }
        if (kotlin.n.n.T((String)localObject, "page/RingtoneSettingsUI", true))
        {
          paramString = new Intent();
          paramString.setClassName(localContext, "com.tencent.mm.plugin.ringtone.ui.RingtoneSettingsUI");
          paramString.addFlags(268435456);
          paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
          com.tencent.mm.hellhoundlib.a.a.b(localContext, paramString.aYi(), "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "handlePageUrl", "(Ljava/lang/String;Z)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localContext.startActivity((Intent)paramString.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "handlePageUrl", "(Ljava/lang/String;Z)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramBoolean = true;
          break;
        }
        if (kotlin.n.n.T((String)localObject, "page/SettingsMessageNotificationUI", true))
        {
          paramString = new Intent();
          paramString.setClassName(localContext, "com.tencent.mm.plugin.setting.ui.setting.SettingsMessageNotificationUI");
          paramString.addFlags(268435456);
          paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
          com.tencent.mm.hellhoundlib.a.a.b(localContext, paramString.aYi(), "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "handlePageUrl", "(Ljava/lang/String;Z)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localContext.startActivity((Intent)paramString.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "handlePageUrl", "(Ljava/lang/String;Z)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramBoolean = true;
          break;
        }
        if (kotlin.n.n.T((String)localObject, "page/SettingsCareModeIntro", true))
        {
          if (!WeChatBrands.AppInfo.current().isMainland())
          {
            Log.i("MicroMsg.JsApiOpenWeiXinPage", "PAGE_SETTINGSCAREMODEINTRO, disable.");
            lb(localContext);
            paramBoolean = true;
            break;
          }
          paramString = new Intent();
          paramString.setClassName(localContext, "com.tencent.mm.plugin.setting.ui.setting.SettingsCareModeIntro");
          paramString.addFlags(268435456);
          paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
          com.tencent.mm.hellhoundlib.a.a.b(localContext, paramString.aYi(), "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "handlePageUrl", "(Ljava/lang/String;Z)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localContext.startActivity((Intent)paramString.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "handlePageUrl", "(Ljava/lang/String;Z)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramBoolean = true;
          break;
        }
        Log.i("MicroMsg.JsApiOpenWeiXinPage", "handlePageUrl not exist path");
        paramBoolean = false;
        break;
      }
      paramBoolean = true;
      break;
      paramBoolean = true;
      break;
      paramBoolean = false;
      break label2923;
      paramBoolean = true;
      break;
      paramBoolean = false;
      break label4556;
      i = 0;
      break label4895;
      paramBoolean = false;
      break label5212;
      i = 0;
      break label5262;
    }
  }
  
  private static final void h(com.tencent.mm.plugin.webview.jsapi.h paramh, p paramp, IPCBoolean paramIPCBoolean)
  {
    AppMethodBeat.i(297777);
    s.u(paramh, "$env");
    s.u(paramp, "$msg");
    if (paramIPCBoolean.value)
    {
      paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":ok"), null);
      AppMethodBeat.o(297777);
      return;
    }
    paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":fail"), null);
    AppMethodBeat.o(297777);
  }
  
  private static final void iBN()
  {
    AppMethodBeat.i(297780);
    bj localbj = new bj();
    localbj.hBv.index = 1;
    localbj.publish();
    AppMethodBeat.o(297780);
  }
  
  private static void kV(Context paramContext)
  {
    AppMethodBeat.i(297731);
    Object localObject = new Intent();
    ((Intent)localObject).setClassName(paramContext, "com.tencent.mm.plugin.setting.ui.setting.SettingsManageFindMoreUI");
    ((Intent)localObject).addFlags(268435456);
    ((Intent)localObject).putExtra("scene", 3);
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goToPageFinderManagerSuffix", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goToPageFinderManagerSuffix", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(297731);
  }
  
  private static void kW(Context paramContext)
  {
    AppMethodBeat.i(297737);
    Intent localIntent = new Intent();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("labs_browse");
    localIntent.putStringArrayListExtra("key_exclude_apps", localArrayList);
    localIntent.addFlags(268435456);
    ((com.tencent.mm.plugin.welab.a.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.welab.a.a.c.class)).aL(paramContext, localIntent);
    AppMethodBeat.o(297737);
  }
  
  private static void kX(Context paramContext)
  {
    AppMethodBeat.i(297742);
    Object localObject = new Intent();
    ((Intent)localObject).setClassName(paramContext, "com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI");
    ((Intent)localObject).addFlags(268435456);
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goToPageMyqrcodeUISuffix", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goToPageMyqrcodeUISuffix", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(297742);
  }
  
  private static void kY(Context paramContext)
  {
    AppMethodBeat.i(297748);
    Object localObject = new Intent();
    ((Intent)localObject).setClassName(paramContext, "com.tencent.mm.plugin.setting.ui.setting.SettingsLanguageUI");
    ((Intent)localObject).addFlags(268435456);
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goToPageLanguageUISuffix", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goToPageLanguageUISuffix", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(297748);
  }
  
  private static void kZ(Context paramContext)
  {
    AppMethodBeat.i(297757);
    if ((z.bBf() & 0x8000) == 0) {}
    for (boolean bool = true; (bool) && (com.tencent.mm.br.c.blq("sns")); bool = false)
    {
      Object localObject = new Intent();
      ((Intent)localObject).setFlags(268435456);
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).setClassName(MMApplicationContext.getContext(), "com.tencent.mm.plugin.sns.ui.SnsTimeLineUI");
      ((Intent)localObject).putExtra("sns_timeline_NeedFirstLoadint", true);
      ((Intent)localObject).putExtra("sns_timeline_NeedShowChangeAlbumDialog", true);
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goToPageTimelineSetbackgroundCoverUISuffix", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goToPageTimelineSetbackgroundCoverUISuffix", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(297757);
      return;
    }
    Log.i("MicroMsg.JsApiOpenWeiXinPage", s.X("goToPageTimelinePublishSuffix, enable = ", Boolean.valueOf(bool)));
    AppMethodBeat.o(297757);
  }
  
  private static void la(Context paramContext)
  {
    AppMethodBeat.i(297762);
    if (!aj.asX(1))
    {
      Log.e("MicroMsg.JsApiOpenWeiXinPage", "fts h5 template not avail");
      AppMethodBeat.o(297762);
      return;
    }
    String str = al.bix("discoverRecommendEntry").optString("wording");
    if (Util.isNullOrNil(str))
    {
      Log.e("MicroMsg.JsApiOpenWeiXinPage", "empty query");
      AppMethodBeat.o(297762);
      return;
    }
    Log.i("MicroMsg.JsApiOpenWeiXinPage", "look one look clikced");
    com.tencent.mm.plugin.topstory.ui.d.bc(paramContext, 20);
    ((com.tencent.mm.plugin.welab.a.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.welab.a.a.a.class)).open("labs_browse");
    paramContext = new qw();
    paramContext.hTT.scene = 0;
    paramContext.publish();
    as.dE(20, str);
    as.nb(20, 0);
    if (aj.asY(1) > aj.ipO()) {
      as.nb(20, 15);
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().hMB();
      AppMethodBeat.o(297762);
      return;
      as.nb(20, 14);
    }
  }
  
  private static void lb(Context paramContext)
  {
    AppMethodBeat.i(297768);
    g.a locala = new g.a(paramContext);
    locala.bDE(paramContext.getString(c.i.open_search_page_error));
    locala.Xdm = true;
    locala.aEX(c.i.app_i_know);
    locala.b(JsApiOpenWeiXinPage..ExternalSyntheticLambda1.INSTANCE);
    locala.show();
    AppMethodBeat.o(297768);
  }
  
  public final boolean a(com.tencent.mm.plugin.webview.jsapi.h paramh, p paramp)
  {
    AppMethodBeat.i(297825);
    s.u(paramh, "env");
    s.u(paramp, "msg");
    String str = (String)paramp.params.get("pageUrl");
    Log.i("MicroMsg.JsApiOpenWeiXinPage", s.X("OpenWeiXinPage:", str));
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new OpenWeiXinPageData(str), a.class, new JsApiOpenWeiXinPage..ExternalSyntheticLambda0(paramh, paramp));
    AppMethodBeat.o(297825);
    return true;
  }
  
  public final String gPX()
  {
    return idA;
  }
  
  public final int gPZ()
  {
    return OOk;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage$OpenWeiXinPageData;", "Landroid/os/Parcelable;", "pageUrl", "", "(Ljava/lang/String;)V", "src", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getPageUrl", "()Ljava/lang/String;", "setPageUrl", "describeContents", "", "writeToParcel", "", "dest", "flags", "CREATOR", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class OpenWeiXinPageData
    implements Parcelable
  {
    public static final a CREATOR;
    String pageUrl;
    
    static
    {
      AppMethodBeat.i(297574);
      CREATOR = new a((byte)0);
      AppMethodBeat.o(297574);
    }
    
    public OpenWeiXinPageData(Parcel paramParcel)
    {
      AppMethodBeat.i(297569);
      String str = paramParcel.readString();
      paramParcel = str;
      if (str == null) {
        paramParcel = "";
      }
      this.pageUrl = paramParcel;
      AppMethodBeat.o(297569);
    }
    
    public OpenWeiXinPageData(String paramString)
    {
      this.pageUrl = paramString;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(297583);
      s.u(paramParcel, "dest");
      paramParcel.writeString(this.pageUrl);
      AppMethodBeat.o(297583);
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage$OpenWeiXinPageData$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage$OpenWeiXinPageData;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage$OpenWeiXinPageData;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements Parcelable.Creator<JsApiOpenWeiXinPage.OpenWeiXinPageData>
    {}
  }
  
  @com.tencent.mm.ipcinvoker.c.a
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage$OpenWeiXinPageTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage$OpenWeiXinPageData;", "Lcom/tencent/mm/ipcinvoker/type/IPCBoolean;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a
    implements com.tencent.mm.ipcinvoker.d<JsApiOpenWeiXinPage.OpenWeiXinPageData, IPCBoolean>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.JsApiOpenWeiXinPage
 * JD-Core Version:    0.7.0.1
 */