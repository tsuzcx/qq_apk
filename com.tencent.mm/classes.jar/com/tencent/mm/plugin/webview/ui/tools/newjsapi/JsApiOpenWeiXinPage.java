package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ah;
import com.tencent.mm.model.ai;
import com.tencent.mm.model.z;
import com.tencent.mm.n.h;
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
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "PAGE_ABOUT_VERSION", "", "PAGE_CHAT_BACKGROUND", "PAGE_CHAT_LOG", "PAGE_CHAT_LOG_MIGRATE", "PAGE_CONTACT_BLACK_LIST", "PAGE_DARK_MODE", "PAGE_FREEZE_ACCOUNT", "PAGE_GLOBAL_SEARCH", "PAGE_GROUPS", "PAGE_MASS_SEND", "PAGE_SET_PAT", "PAGE_TEXT_SIZE", "PAGE_WX_CHAT_TEAM", "PAGE_WX_SPORT", "TAG", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "goBlackList", "", "context", "Landroid/content/Context;", "goDarkMode", "goFreezeAccount", "goSystemNotice", "goToSetPatSuffix", "goWebView", "url", "showShare", "", "handleMsg", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "handlePageUrl", "pageUrl", "startChattingUI", "userName", "startContactInfo", "username", "OpenWeiXinPageData", "OpenWeiXinPageTask", "plugin-webview_release"})
public final class JsApiOpenWeiXinPage
  extends com.tencent.mm.plugin.webview.d.c.a
{
  private static final int CDJ = 396;
  public static final JsApiOpenWeiXinPage JxC;
  private static final String edq = "openWeiXinPage";
  
  static
  {
    AppMethodBeat.i(210649);
    JxC = new JsApiOpenWeiXinPage();
    CDJ = 396;
    edq = "openWeiXinPage";
    AppMethodBeat.o(210649);
  }
  
  private static boolean bbg(String paramString)
  {
    AppMethodBeat.i(210648);
    for (;;)
    {
      Context localContext;
      Object localObject;
      int i;
      try
      {
        localContext = MMApplicationContext.getContext();
        p.g(localContext, "MMApplicationContext.getContext()");
        localObject = Uri.parse(paramString);
        p.g(localObject, "uri");
        paramString = ((Uri)localObject).getScheme();
        localObject = p.I(((Uri)localObject).getHost(), ((Uri)localObject).getPath());
        Log.i("MicroMsg.JsApiOpenWeiXinPage", "handlePageUrl scheme:" + paramString + " pagePath:" + (String)localObject);
        if (kotlin.n.n.I((String)localObject, "page/wesport", true))
        {
          paramString = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
          p.g(paramString, "MMKernel.service(IMessengerStorage::class.java)");
          paramString = ((com.tencent.mm.plugin.messenger.foundation.a.l)paramString).aSN().Kn("gh_43f2581f6fd6");
          if ((paramString != null) && (paramString.arv() == true))
          {
            paramString = new Intent();
            paramString.putExtra("Chat_User", "gh_43f2581f6fd6");
            paramString.putExtra("finish_direct", true);
            paramString.putExtra("chat_from_scene", 5);
            c.f(localContext, ".ui.chatting.ChattingUI", paramString);
            bool = true;
            AppMethodBeat.o(210648);
            return bool;
          }
          paramString = new Intent();
          paramString.putExtra("Contact_User", "gh_43f2581f6fd6");
          c.b(localContext, "profile", ".ui.ContactInfoUI", paramString);
          bool = true;
          continue;
        }
        if (kotlin.n.n.I((String)localObject, "page/wechatteam", true))
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
        if (kotlin.n.n.I((String)localObject, "page/masssend", true))
        {
          if (z.aUD())
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
        if (kotlin.n.n.I((String)localObject, "page/groups", true))
        {
          paramString = new Intent();
          paramString.setClassName(localContext, "com.tencent.mm.ui.contact.ChatroomContactUI");
          paramString.addFlags(268435456);
          paramString = new com.tencent.mm.hellhoundlib.b.a().bl(paramString);
          com.tencent.mm.hellhoundlib.a.a.a(localContext, paramString.axQ(), "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "handlePageUrl", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localContext.startActivity((Intent)paramString.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "handlePageUrl", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          bool = true;
          continue;
        }
        if (kotlin.n.n.I((String)localObject, "page/textsize", true))
        {
          paramString = new Intent();
          paramString.setClassName(localContext, "com.tencent.mm.plugin.setting.ui.setting.SettingsFontUI");
          paramString.addFlags(268435456);
          paramString = new com.tencent.mm.hellhoundlib.b.a().bl(paramString);
          com.tencent.mm.hellhoundlib.a.a.a(localContext, paramString.axQ(), "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "handlePageUrl", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localContext.startActivity((Intent)paramString.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "handlePageUrl", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          bool = true;
          continue;
        }
        if (kotlin.n.n.I((String)localObject, "page/securitycenter", true))
        {
          localObject = h.aqJ().getValue("WeChatSafeCenterUrl");
          Log.i("MicroMsg.JsApiOpenWeiXinPage", "safe center url %s", new Object[] { localObject });
          paramString = (String)localObject;
          if (Util.isNullOrNil((String)localObject)) {
            paramString = localContext.getString(2131768669) + LocaleUtil.getApplicationLanguage();
          }
          localObject = new Intent();
          ((Intent)localObject).putExtra("rawUrl", paramString);
          ((Intent)localObject).putExtra("showShare", true);
          ((Intent)localObject).putExtra("show_bottom", false);
          ((Intent)localObject).putExtra("needRedirect", false);
          ((Intent)localObject).putExtra("hardcode_jspermission", (Parcelable)JsapiPermissionWrapper.Kzm);
          ((Intent)localObject).putExtra("hardcode_general_ctrl", (Parcelable)GeneralControlWrapper.Kzg);
          c.b(localContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", (Intent)localObject);
          bool = true;
          continue;
        }
        if (kotlin.n.n.I((String)localObject, "page/contactblacklist", true))
        {
          paramString = ai.Kb(localContext.getString(2131761463));
          localObject = new Intent();
          p.g(paramString, "blackList");
          ((Intent)localObject).putExtra("filter_type", paramString.getType());
          ((Intent)localObject).putExtra("titile", localContext.getString(2131765555));
          ((Intent)localObject).putExtra("list_attr", 32768);
          ((Intent)localObject).addFlags(268435456);
          ((Intent)localObject).setClassName(localContext, "com.tencent.mm.ui.contact.SelectSpecialContactUI");
          paramString = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(localContext, paramString.axQ(), "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goBlackList", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localContext.startActivity((Intent)paramString.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goBlackList", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          bool = true;
          continue;
        }
        if (kotlin.n.n.I((String)localObject, "page/darkmode", true))
        {
          MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putBoolean("dark_mode_red_dot", false);
          paramString = new Intent();
          paramString.setClassName(localContext, "com.tencent.mm.plugin.setting.ui.setting.SettingDarkMode");
          paramString.addFlags(268435456);
          paramString = new com.tencent.mm.hellhoundlib.b.a().bl(paramString);
          com.tencent.mm.hellhoundlib.a.a.a(localContext, paramString.axQ(), "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goDarkMode", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localContext.startActivity((Intent)paramString.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goDarkMode", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          bool = true;
          continue;
        }
        if (!kotlin.n.n.I((String)localObject, "page/aboutversion", true)) {
          break label1282;
        }
        p.g(g.aAf(), "MMKernel.account()");
        i = com.tencent.mm.kernel.a.getUin();
        paramString = g.aAh();
        p.g(paramString, "MMKernel.storage()");
        paramString = paramString.azQ().get(12304);
        if (paramString == null)
        {
          paramString = new t("null cannot be cast to non-null type kotlin.Int");
          AppMethodBeat.o(210648);
          throw paramString;
        }
      }
      catch (Throwable paramString)
      {
        Log.printErrStackTrace("MicroMsg.JsApiOpenWeiXinPage", paramString, "handlePageErr!!", new Object[0]);
        AppMethodBeat.o(210648);
        return false;
      }
      paramString = localContext.getString(2131765632, new Object[] { Integer.valueOf(i), Integer.valueOf(Util.nullAsNil((Integer)paramString)) });
      p.g(paramString, "context.getString(R.stri…otice_url, uin, newCount)");
      if (!kotlin.n.n.aL((CharSequence)paramString))
      {
        localObject = g.aAh();
        p.g(localObject, "MMKernel.storage()");
        ((e)localObject).azQ().set(12304, Integer.valueOf(0));
        localObject = new Intent();
        ((Intent)localObject).putExtra("title", localContext.getString(2131765631));
        ((Intent)localObject).putExtra("rawUrl", paramString);
        ((Intent)localObject).putExtra("showShare", false);
        c.b(localContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
        break label1723;
        label1282:
        if (kotlin.n.n.I((String)localObject, "page/globalsearch", true))
        {
          com.tencent.mm.plugin.fts.a.d.b(localContext, ".ui.FTSMainUI", new Intent(), null);
          bool = true;
          continue;
        }
        if (kotlin.n.n.I((String)localObject, "page/chatlogmigrate", true))
        {
          paramString = new Intent();
          paramString.setClassName(localContext, "com.tencent.mm.plugin.backup.backupmoveui.BackupUI");
          MMWizardActivity.ay(localContext, paramString);
          bool = true;
          continue;
        }
        if (kotlin.n.n.I((String)localObject, "page/chatlog", true))
        {
          paramString = new Intent().setClassName(localContext, "com.tencent.mm.plugin.backup.backupui.BackupChooseBackupModeUI");
          p.g(paramString, "Intent().setClassName(co…ackupChooseBackupModeUI\")");
          paramString.addFlags(268435456);
          paramString = new com.tencent.mm.hellhoundlib.b.a().bl(paramString);
          com.tencent.mm.hellhoundlib.a.a.a(localContext, paramString.axQ(), "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "handlePageUrl", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localContext.startActivity((Intent)paramString.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "handlePageUrl", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          bool = true;
          continue;
        }
        if (kotlin.n.n.I((String)localObject, "page/chatbackground", true))
        {
          paramString = new Intent();
          paramString.setClassName(localContext, "com.tencent.mm.plugin.setting.ui.setting.SettingsChattingBackgroundUI");
          paramString.addFlags(268435456);
          paramString = new com.tencent.mm.hellhoundlib.b.a().bl(paramString);
          com.tencent.mm.hellhoundlib.a.a.a(localContext, paramString.axQ(), "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "handlePageUrl", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localContext.startActivity((Intent)paramString.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "handlePageUrl", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          bool = true;
          continue;
        }
        if (kotlin.n.n.I((String)localObject, "page/setpat", true))
        {
          paramString = new Intent();
          paramString.setClassName(localContext, "com.tencent.mm.plugin.setting.ui.setting.SettingsModifyPatSuffixUI");
          paramString.addFlags(268435456);
          paramString = new com.tencent.mm.hellhoundlib.b.a().bl(paramString);
          com.tencent.mm.hellhoundlib.a.a.a(localContext, paramString.axQ(), "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goToSetPatSuffix", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localContext.startActivity((Intent)paramString.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goToSetPatSuffix", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          bool = true;
          continue;
        }
        Log.i("MicroMsg.JsApiOpenWeiXinPage", "handlePageUrl not exist path");
        bool = false;
        continue;
      }
      label1723:
      boolean bool = true;
    }
  }
  
  public final boolean a(com.tencent.mm.plugin.webview.d.f paramf, final com.tencent.mm.plugin.webview.d.n paramn)
  {
    AppMethodBeat.i(210647);
    p.h(paramf, "env");
    p.h(paramn, "msg");
    String str = (String)paramn.params.get("pageUrl");
    Log.i("MicroMsg.JsApiOpenWeiXinPage", "OpenWeiXinPage:".concat(String.valueOf(str)));
    XIPCInvoker.a(MainProcessIPCService.dkO, new OpenWeiXinPageData(str), a.class, (com.tencent.mm.ipcinvoker.d)new b(paramf, paramn));
    AppMethodBeat.o(210647);
    return true;
  }
  
  public final int ePA()
  {
    return CDJ;
  }
  
  public final String ePz()
  {
    return edq;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage$OpenWeiXinPageData;", "Landroid/os/Parcelable;", "pageUrl", "", "(Ljava/lang/String;)V", "src", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getPageUrl", "()Ljava/lang/String;", "setPageUrl", "describeContents", "", "writeToParcel", "", "dest", "flags", "CREATOR", "plugin-webview_release"})
  static final class OpenWeiXinPageData
    implements Parcelable
  {
    public static final a CREATOR;
    String pageUrl;
    
    static
    {
      AppMethodBeat.i(210644);
      CREATOR = new a((byte)0);
      AppMethodBeat.o(210644);
    }
    
    public OpenWeiXinPageData(Parcel paramParcel)
    {
      AppMethodBeat.i(210643);
      String str = paramParcel.readString();
      paramParcel = str;
      if (str == null) {
        paramParcel = "";
      }
      this.pageUrl = paramParcel;
      AppMethodBeat.o(210643);
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
      AppMethodBeat.i(210642);
      p.h(paramParcel, "dest");
      paramParcel.writeString(this.pageUrl);
      AppMethodBeat.o(210642);
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage$OpenWeiXinPageData$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage$OpenWeiXinPageData;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage$OpenWeiXinPageData;", "plugin-webview_release"})
    public static final class a
      implements Parcelable.Creator<JsApiOpenWeiXinPage.OpenWeiXinPageData>
    {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage$OpenWeiXinPageTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage$OpenWeiXinPageData;", "Lcom/tencent/mm/ipcinvoker/type/IPCBoolean;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-webview_release"})
  static final class a
    implements b<JsApiOpenWeiXinPage.OpenWeiXinPageData, IPCBoolean>
  {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "result", "Lcom/tencent/mm/ipcinvoker/type/IPCBoolean;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class b<T>
    implements com.tencent.mm.ipcinvoker.d<IPCBoolean>
  {
    b(com.tencent.mm.plugin.webview.d.f paramf, com.tencent.mm.plugin.webview.d.n paramn) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.JsApiOpenWeiXinPage
 * JD-Core Version:    0.7.0.1
 */