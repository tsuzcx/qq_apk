package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.ah;
import com.tencent.mm.model.ai;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMWizardActivity;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "PAGE_ABOUT_VERSION", "", "PAGE_CHAT_BACKGROUND", "PAGE_CHAT_LOG", "PAGE_CHAT_LOG_MIGRATE", "PAGE_CONTACT_BLACK_LIST", "PAGE_DARK_MODE", "PAGE_FREEZE_ACCOUNT", "PAGE_GLOBAL_SEARCH", "PAGE_GROUPS", "PAGE_MASS_SEND", "PAGE_SET_PAT", "PAGE_TEXT_SIZE", "PAGE_WX_CHAT_TEAM", "PAGE_WX_SPORT", "TAG", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "goBlackList", "", "context", "Landroid/content/Context;", "goDarkMode", "goFreezeAccount", "goSystemNotice", "goToSetPatSuffix", "goWebView", "url", "showShare", "", "handleMsg", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "handlePageUrl", "pageUrl", "startChattingUI", "userName", "startContactInfo", "username", "OpenWeiXinPageData", "OpenWeiXinPageTask", "plugin-webview_release"})
public final class JsApiOpenWeiXinPage
  extends com.tencent.mm.plugin.webview.d.c.a
{
  private static final int IIl = 396;
  public static final JsApiOpenWeiXinPage Qvz;
  private static final String fXz = "openWeiXinPage";
  
  static
  {
    AppMethodBeat.i(219618);
    Qvz = new JsApiOpenWeiXinPage();
    IIl = 396;
    fXz = "openWeiXinPage";
    AppMethodBeat.o(219618);
  }
  
  private static boolean bnf(String paramString)
  {
    AppMethodBeat.i(219615);
    for (;;)
    {
      Context localContext;
      Object localObject;
      int i;
      try
      {
        localContext = MMApplicationContext.getContext();
        p.j(localContext, "MMApplicationContext.getContext()");
        localObject = Uri.parse(paramString);
        p.j(localObject, "uri");
        paramString = ((Uri)localObject).getScheme();
        localObject = p.I(((Uri)localObject).getHost(), ((Uri)localObject).getPath());
        Log.i("MicroMsg.JsApiOpenWeiXinPage", "handlePageUrl scheme:" + paramString + " pagePath:" + (String)localObject);
        if (kotlin.n.n.L((String)localObject, "page/wesport", true))
        {
          paramString = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class);
          p.j(paramString, "MMKernel.service(IMessengerStorage::class.java)");
          paramString = ((com.tencent.mm.plugin.messenger.foundation.a.n)paramString).bbL().RG("gh_43f2581f6fd6");
          if ((paramString != null) && (paramString.axZ() == true))
          {
            paramString = new Intent();
            paramString.putExtra("Chat_User", "gh_43f2581f6fd6");
            paramString.putExtra("finish_direct", true);
            paramString.putExtra("chat_from_scene", 5);
            c.f(localContext, ".ui.chatting.ChattingUI", paramString);
            bool = true;
            AppMethodBeat.o(219615);
            return bool;
          }
          paramString = new Intent();
          paramString.putExtra("Contact_User", "gh_43f2581f6fd6");
          c.b(localContext, "profile", ".ui.ContactInfoUI", paramString);
          bool = true;
          continue;
        }
        if (kotlin.n.n.L((String)localObject, "page/wechatteam", true))
        {
          paramString = new Intent();
          paramString.putExtra("Chat_User", "weixin");
          paramString.putExtra("finish_direct", true);
          paramString.putExtra("specific_chat_from_scene", 3);
          paramString.putExtra("preChatTYPE", 9);
          paramString.putExtra("chat_from_scene", 5);
          c.f(localContext, ".ui.chatting.ChattingUI", paramString);
          bool = true;
          continue;
        }
        if (kotlin.n.n.L((String)localObject, "page/masssend", true))
        {
          if (z.bdF())
          {
            paramString = new Intent();
            paramString.putExtra("finish_direct", true);
            c.b(localContext, "masssend", ".ui.MassSendHistoryUI", paramString);
            bool = true;
            continue;
          }
          c.b(localContext, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", "masssendapp"));
          bool = true;
          continue;
        }
        if (kotlin.n.n.L((String)localObject, "page/groups", true))
        {
          paramString = new Intent();
          paramString.setClassName(localContext, "com.tencent.mm.ui.contact.ChatroomContactUI");
          paramString.addFlags(268435456);
          paramString = new com.tencent.mm.hellhoundlib.b.a().bm(paramString);
          com.tencent.mm.hellhoundlib.a.a.b(localContext, paramString.aFh(), "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "handlePageUrl", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localContext.startActivity((Intent)paramString.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "handlePageUrl", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          bool = true;
          continue;
        }
        if (kotlin.n.n.L((String)localObject, "page/textsize", true))
        {
          paramString = new Intent();
          paramString.setClassName(localContext, "com.tencent.mm.plugin.setting.ui.setting.SettingsFontUI");
          paramString.addFlags(268435456);
          paramString = new com.tencent.mm.hellhoundlib.b.a().bm(paramString);
          com.tencent.mm.hellhoundlib.a.a.b(localContext, paramString.aFh(), "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "handlePageUrl", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localContext.startActivity((Intent)paramString.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "handlePageUrl", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          bool = true;
          continue;
        }
        if (kotlin.n.n.L((String)localObject, "page/securitycenter", true))
        {
          localObject = com.tencent.mm.n.h.axc().getValue("WeChatSafeCenterUrl");
          Log.i("MicroMsg.JsApiOpenWeiXinPage", "safe center url %s", new Object[] { localObject });
          paramString = (String)localObject;
          if (Util.isNullOrNil((String)localObject)) {
            paramString = localContext.getString(c.i.wechat_securiy_center_path) + LocaleUtil.getApplicationLanguage();
          }
          localObject = new Intent();
          ((Intent)localObject).putExtra("rawUrl", paramString);
          ((Intent)localObject).putExtra("showShare", true);
          ((Intent)localObject).putExtra("show_bottom", false);
          ((Intent)localObject).putExtra("needRedirect", false);
          ((Intent)localObject).putExtra("hardcode_jspermission", (Parcelable)JsapiPermissionWrapper.RBc);
          ((Intent)localObject).putExtra("hardcode_general_ctrl", (Parcelable)GeneralControlWrapper.RAX);
          c.b(localContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", (Intent)localObject);
          bool = true;
          continue;
        }
        if (kotlin.n.n.L((String)localObject, "page/contactblacklist", true))
        {
          paramString = ai.Rt(localContext.getString(c.i.group_blacklist));
          localObject = new Intent();
          p.j(paramString, "blackList");
          ((Intent)localObject).putExtra("filter_type", paramString.getType());
          ((Intent)localObject).putExtra("titile", localContext.getString(c.i.settings_private_blacklist));
          ((Intent)localObject).putExtra("list_attr", 32768);
          ((Intent)localObject).addFlags(268435456);
          ((Intent)localObject).setClassName(localContext, "com.tencent.mm.ui.contact.SelectSpecialContactUI");
          paramString = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(localContext, paramString.aFh(), "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goBlackList", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localContext.startActivity((Intent)paramString.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goBlackList", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          bool = true;
          continue;
        }
        if (kotlin.n.n.L((String)localObject, "page/darkmode", true))
        {
          MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putBoolean("dark_mode_red_dot", false);
          paramString = new Intent();
          paramString.setClassName(localContext, "com.tencent.mm.plugin.setting.ui.setting.SettingDarkMode");
          paramString.addFlags(268435456);
          paramString = new com.tencent.mm.hellhoundlib.b.a().bm(paramString);
          com.tencent.mm.hellhoundlib.a.a.b(localContext, paramString.aFh(), "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goDarkMode", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localContext.startActivity((Intent)paramString.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goDarkMode", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          bool = true;
          continue;
        }
        if (!kotlin.n.n.L((String)localObject, "page/aboutversion", true)) {
          break label1327;
        }
        p.j(com.tencent.mm.kernel.h.aHE(), "MMKernel.account()");
        i = b.getUin();
        paramString = com.tencent.mm.kernel.h.aHG();
        p.j(paramString, "MMKernel.storage()");
        paramString = paramString.aHp().get(12304);
        if (paramString == null)
        {
          paramString = new t("null cannot be cast to non-null type kotlin.Int");
          AppMethodBeat.o(219615);
          throw paramString;
        }
      }
      catch (Throwable paramString)
      {
        Log.printErrStackTrace("MicroMsg.JsApiOpenWeiXinPage", paramString, "handlePageErr!!", new Object[0]);
        AppMethodBeat.o(219615);
        return false;
      }
      int j = Util.nullAsNil((Integer)paramString);
      paramString = localContext.getString(c.i.settings_system_notice_url, new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      p.j(paramString, "context.getString(R.stri…otice_url, uin, newCount)");
      if (!kotlin.n.n.ba((CharSequence)paramString))
      {
        localObject = com.tencent.mm.kernel.h.aHG();
        p.j(localObject, "MMKernel.storage()");
        ((com.tencent.mm.kernel.f)localObject).aHp().i(12304, Integer.valueOf(0));
        localObject = new Intent();
        ((Intent)localObject).putExtra("title", localContext.getString(c.i.settings_system_notice));
        ((Intent)localObject).putExtra("rawUrl", paramString);
        ((Intent)localObject).putExtra("showShare", false);
        c.b(localContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
        break label1773;
        label1327:
        if (kotlin.n.n.L((String)localObject, "page/globalsearch", true))
        {
          com.tencent.mm.plugin.fts.a.d.b(localContext, ".ui.FTSMainUI", new Intent(), null);
          bool = true;
          continue;
        }
        if (kotlin.n.n.L((String)localObject, "page/chatlogmigrate", true))
        {
          paramString = new Intent();
          paramString.setClassName(localContext, "com.tencent.mm.plugin.backup.backupmoveui.BackupUI");
          MMWizardActivity.aH(localContext, paramString);
          bool = true;
          continue;
        }
        if (kotlin.n.n.L((String)localObject, "page/chatlog", true))
        {
          paramString = new Intent().setClassName(localContext, "com.tencent.mm.plugin.backup.backupui.BackupChooseBackupModeUI");
          p.j(paramString, "Intent().setClassName(co…ackupChooseBackupModeUI\")");
          paramString.addFlags(268435456);
          paramString = new com.tencent.mm.hellhoundlib.b.a().bm(paramString);
          com.tencent.mm.hellhoundlib.a.a.b(localContext, paramString.aFh(), "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "handlePageUrl", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localContext.startActivity((Intent)paramString.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "handlePageUrl", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          bool = true;
          continue;
        }
        if (kotlin.n.n.L((String)localObject, "page/chatbackground", true))
        {
          paramString = new Intent();
          paramString.setClassName(localContext, "com.tencent.mm.plugin.setting.ui.setting.SettingsChattingBackgroundUI");
          paramString.addFlags(268435456);
          paramString = new com.tencent.mm.hellhoundlib.b.a().bm(paramString);
          com.tencent.mm.hellhoundlib.a.a.b(localContext, paramString.aFh(), "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "handlePageUrl", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localContext.startActivity((Intent)paramString.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "handlePageUrl", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          bool = true;
          continue;
        }
        if (kotlin.n.n.L((String)localObject, "page/setpat", true))
        {
          paramString = new Intent();
          paramString.setClassName(localContext, "com.tencent.mm.plugin.setting.ui.setting.SettingsModifyPatSuffixUI");
          paramString.addFlags(268435456);
          paramString = new com.tencent.mm.hellhoundlib.b.a().bm(paramString);
          com.tencent.mm.hellhoundlib.a.a.b(localContext, paramString.aFh(), "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goToSetPatSuffix", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localContext.startActivity((Intent)paramString.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goToSetPatSuffix", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          bool = true;
          continue;
        }
        Log.i("MicroMsg.JsApiOpenWeiXinPage", "handlePageUrl not exist path");
        bool = false;
        continue;
      }
      label1773:
      boolean bool = true;
    }
  }
  
  public final boolean a(com.tencent.mm.plugin.webview.d.f paramf, final com.tencent.mm.plugin.webview.d.n paramn)
  {
    AppMethodBeat.i(219578);
    p.k(paramf, "env");
    p.k(paramn, "msg");
    String str = (String)paramn.params.get("pageUrl");
    Log.i("MicroMsg.JsApiOpenWeiXinPage", "OpenWeiXinPage:".concat(String.valueOf(str)));
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new OpenWeiXinPageData(str), a.class, (com.tencent.mm.ipcinvoker.f)new b(paramf, paramn));
    AppMethodBeat.o(219578);
    return true;
  }
  
  public final String fCm()
  {
    return fXz;
  }
  
  public final int fCn()
  {
    return IIl;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage$OpenWeiXinPageData;", "Landroid/os/Parcelable;", "pageUrl", "", "(Ljava/lang/String;)V", "src", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getPageUrl", "()Ljava/lang/String;", "setPageUrl", "describeContents", "", "writeToParcel", "", "dest", "flags", "CREATOR", "plugin-webview_release"})
  static final class OpenWeiXinPageData
    implements Parcelable
  {
    public static final a CREATOR;
    String pageUrl;
    
    static
    {
      AppMethodBeat.i(238333);
      CREATOR = new a((byte)0);
      AppMethodBeat.o(238333);
    }
    
    public OpenWeiXinPageData(Parcel paramParcel)
    {
      AppMethodBeat.i(238328);
      String str = paramParcel.readString();
      paramParcel = str;
      if (str == null) {
        paramParcel = "";
      }
      this.pageUrl = paramParcel;
      AppMethodBeat.o(238328);
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
      AppMethodBeat.i(238320);
      p.k(paramParcel, "dest");
      paramParcel.writeString(this.pageUrl);
      AppMethodBeat.o(238320);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage$OpenWeiXinPageData$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage$OpenWeiXinPageData;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage$OpenWeiXinPageData;", "plugin-webview_release"})
    public static final class a
      implements Parcelable.Creator<JsApiOpenWeiXinPage.OpenWeiXinPageData>
    {}
  }
  
  @com.tencent.mm.ipcinvoker.c.a
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage$OpenWeiXinPageTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage$OpenWeiXinPageData;", "Lcom/tencent/mm/ipcinvoker/type/IPCBoolean;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-webview_release"})
  static final class a
    implements com.tencent.mm.ipcinvoker.d<JsApiOpenWeiXinPage.OpenWeiXinPageData, IPCBoolean>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Lcom/tencent/mm/ipcinvoker/type/IPCBoolean;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class b<T>
    implements com.tencent.mm.ipcinvoker.f<IPCBoolean>
  {
    b(com.tencent.mm.plugin.webview.d.f paramf, com.tencent.mm.plugin.webview.d.n paramn) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.JsApiOpenWeiXinPage
 * JD-Core Version:    0.7.0.1
 */