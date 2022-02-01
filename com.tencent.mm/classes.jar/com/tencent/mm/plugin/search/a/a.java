package com.tencent.mm.plugin.search.a;

import android.content.Context;
import android.content.Intent;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.service.h.a;
import com.tencent.mm.plugin.appbrand.service.v;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.findersdk.a.ca;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.ui.MMWizardActivity;
import java.util.List;

public final class a
{
  public static final SparseArray<a> Plj;
  
  static
  {
    AppMethodBeat.i(28069);
    SparseArray localSparseArray = new SparseArray();
    Plj = localSparseArray;
    localSparseArray.put(19, new a(19, -1, ".ui.SnsTimeLineUI", "sns", ""));
    Plj.put(30, new a(19, -1, ".ui.BaseScanUI", "scanner", "", (byte)0));
    Plj.put(18, new a(18, -1, ".ui.ShakeReportUI", "shake", ""));
    Plj.put(17, new a(17, -1, ".ui.NearbyFriendsIntroUI", "nearby", ""));
    Plj.put(16, new a(16, -1, ".ui.BottleBeachUI", "bottle", ""));
    Plj.put(31, new a(31, -1, ".ui.GameCenterUI", "game", ""));
    Plj.put(20, new a(20, -1, ".plugin.profile.ui.ContactInfoUI", "", "voiceinputapp"));
    Plj.put(21, new a(21, -1, ".plugin.profile.ui.ContactInfoUI", "", "linkedinplugin"));
    Plj.put(26, new a(26, -1, ".plugin.profile.ui.ContactInfoUI", "", "qqfriend"));
    Plj.put(29, new a(29, -1, ".plugin.profile.ui.ContactInfoUI", "", "voipapp"));
    Plj.put(23, new a(23, 1, ".ui.chatting.ChattingUI", "", "qqmail"));
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yXg, true))
    {
      Plj.put(1, new a(1, -1, ".ui.MallIndexUIv2", "mall", ""));
      Plj.put(24, new a(24, 8, ".ui.chatting.ChattingUI", "", "weibo"));
      Plj.put(27, new a(27, 65536, ".ui.MassSendHistoryUI", "masssend", "masssendapp"));
      Plj.put(28, new a(28, 524288, ".ui.ReaderAppUI", "readerapp", "newsapp"));
      Plj.put(32, new a(32, -1, ".ui.v2.EmojiStoreV2UI", "emoji", ""));
      Plj.put(33, new a(33, -1, ".ui.FavoriteIndexUI", "favorite", ""));
      if (!((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yXg, true)) {
        break label1160;
      }
      Plj.put(34, new a(34, -1, ".ui.MallIndexUIv2", "mall", ""));
    }
    for (;;)
    {
      Plj.put(35, new a(35, -1, ".backupmoveui.BackupUI", "backup", ""));
      Plj.put(38, new a(38, 16, ".ui.chatting.ChattingUI", "", "medianote"));
      Plj.put(39, new a(39, -1, ".ui.chatting.ChattingUI", "", "filehelper"));
      Plj.put(6, new a(6, -1, ".ui.LuckyMoneyIndexUI", "luckymoney", ""));
      Plj.put(41, new a(41, -1, ".ui.WalletOfflineEntranceUI", "offline", ""));
      Plj.put(42, new a(42, -1, ".ui.CollectAdapterUI", "collect", ""));
      Plj.put(40, new a(40, -1, ".balance.ui.WalletBalanceManagerUI", "wallet", ""));
      Plj.put(43, new a(43, -1, ".ui.chatting.ChattingUI", "", "gh_43f2581f6fd6"));
      Plj.put(50, new a(50, -1, ".ui.conversation.BizConversationUI", "app", ""));
      Plj.put(51, new a(51, -1, ".ui.setting.SettingsPrivacyUI", "setting", ""));
      Plj.put(66, new a(66, -1, ".ui.AppBrandLauncherUI", "appbrand", ""));
      Plj.put(63, new a(63, -1, ".ui.conversation.BizConversationUI", "app", ""));
      Plj.put(64, new a(64, -1, ".plugin.setting.ui.fixtools.FixToolsUI", "app", ""));
      Plj.put(65, new a(65, -1, "", "", ""));
      Plj.put(67, new a(67, -1, ".plugin.brandservice.ui.timeline.BizTimeLineUI", "app", ""));
      Plj.put(68, new a(68, -1, ".ui.chatting.ChattingUI", "", "gh_3dfda90e39d6"));
      Plj.put(69, new a(69, -1, ".ui.conversation.AppBrandServiceConversationUI", "app", ""));
      Plj.put(70, new a(70, -1, ".ui.chatting.ChattingUI", "", "gh_f0a92aa7146c"));
      Plj.put(71, new a(71, -1, ".ui.chatting.ChattingUI", "", "appbrand_notify_message"));
      if (1 == ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.ztC, 1)) {
        Plj.put(72, new a(72, -1, ".ui.chatting.ChattingUI", "", "gh_579db1f2cf89"));
      }
      Plj.put(73, new a(73, -1, ".ui.chatting.ChattingUI", "", "gh_b4af18eac3d5"));
      Plj.put(75, new a(75, -1, ((cn)com.tencent.mm.kernel.h.az(cn.class)).getFinderUtilApi().fgJ(), "finder", ""));
      Plj.put(74, new a(74, -1, ".ui.conversation.OpenImKefuServiceConversationUI", "app", ""));
      Plj.put(76, new a(76, -1, ".ui.chatting.ChattingUI", "", "gh_e087bb5b95e6"));
      Plj.put(77, new a(77, -1, ".ui.conversation.ConvBoxServiceConversationUI", "app", "conversationboxservice"));
      AppMethodBeat.o(28069);
      return;
      Plj.put(1, new a(1, -1, ".ui.MallIndexUI", "mall", ""));
      break;
      label1160:
      Plj.put(34, new a(34, -1, ".ui.MallIndexUI", "mall", ""));
    }
  }
  
  public static boolean aS(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(28068);
    if (Plj.indexOfKey(paramInt) < 0)
    {
      AppMethodBeat.o(28068);
      return false;
    }
    if ((paramInt == 30) && ((com.tencent.mm.n.a.p(paramContext, true)) || (com.tencent.mm.n.a.dl(paramContext)) || (com.tencent.mm.n.a.dp(paramContext))))
    {
      AppMethodBeat.o(28068);
      return false;
    }
    Object localObject1 = (a)Plj.get(paramInt);
    if ((au.bxe(((a)localObject1).username)) && (!WeChatBrands.Business.Entries.HomePluginSports.checkAvailable(paramContext)))
    {
      AppMethodBeat.o(28068);
      return true;
    }
    if ((au.bxf(((a)localObject1).username)) && (!WeChatBrands.Business.Entries.HomePluginWePay.checkAvailable(paramContext)))
    {
      AppMethodBeat.o(28068);
      return true;
    }
    if ((paramInt == 41) && (!WeChatBrands.Business.Entries.HomePluginWePay.checkAvailable(paramContext)))
    {
      AppMethodBeat.o(28068);
      return true;
    }
    if ((paramInt == 42) && (!WeChatBrands.Business.Entries.HomePluginWePay.checkAvailable(paramContext)))
    {
      AppMethodBeat.o(28068);
      return true;
    }
    if ((paramInt == 31) && (!WeChatBrands.Business.Entries.DiscoveryGame.checkAvailable(paramContext)))
    {
      AppMethodBeat.o(28068);
      return true;
    }
    if ((paramInt == 18) && (!WeChatBrands.Business.Entries.DiscoveryShake.checkAvailable(paramContext)))
    {
      AppMethodBeat.o(28068);
      return true;
    }
    if ((paramInt == 75) && (!WeChatBrands.Business.Entries.DiscoveryChannels.checkAvailable(paramContext)))
    {
      AppMethodBeat.o(28068);
      return true;
    }
    if ((paramInt == 65) && (!WeChatBrands.Business.Entries.DiscoveryLooks.checkAvailable(paramContext)))
    {
      AppMethodBeat.o(28068);
      return true;
    }
    if ((paramInt == 17) && (!WeChatBrands.Business.Entries.DiscoveryNearby.checkAvailable(paramContext)))
    {
      AppMethodBeat.o(28068);
      return true;
    }
    if (((paramInt == 50) || (paramInt == 63) || (paramInt == 67)) && (!WeChatBrands.Business.Entries.HomeServiceOa.checkAvailable(paramContext)))
    {
      AppMethodBeat.o(28068);
      return true;
    }
    if ((paramInt == 28) && (!WeChatBrands.Business.Entries.HomePluginQQMail.checkAvailable(paramContext)))
    {
      AppMethodBeat.o(28068);
      return true;
    }
    boolean bool;
    if ((((a)localObject1).Plk != -1) && ((z.bBf() & ((a)localObject1).Plk) != 0))
    {
      bool = bL(paramContext, ((a)localObject1).username);
      AppMethodBeat.o(28068);
      return bool;
    }
    if (paramInt == 75)
    {
      localObject1 = new Intent();
      ((Intent)localObject1).setClassName(paramContext, ((cn)com.tencent.mm.kernel.h.az(cn.class)).getFinderUtilApi().fgI());
      ((Intent)localObject1).putExtra("KEY_FINDER_POST_FINISH_JUMP_FRIEND_TAB", true);
      ((Intent)localObject1).putExtra("key_context_id", ((cn)com.tencent.mm.kernel.h.az(cn.class)).fillContextIdToIntent(30, 19, 18, null));
      ((Intent)localObject1).addFlags(268435456);
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/plugin/search/model/FeatureLogic", "startFeature", "(Landroid/content/Context;I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/search/model/FeatureLogic", "startFeature", "(Landroid/content/Context;I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(28068);
      return true;
    }
    Object localObject2;
    if (!Util.isNullOrNil(((a)localObject1).HjZ))
    {
      localObject2 = new Intent();
      if (paramInt == 28) {
        ((Intent)localObject2).putExtra("type", 20);
      }
      if (paramInt == 1) {
        ((Intent)localObject2).putExtra("key_native_url", "wxpay://bizmall/mobile_recharge");
      }
      ((Intent)localObject2).putExtra("animation_pop_in", ((a)localObject1).Pll);
      if (paramInt == 32) {
        com.tencent.mm.plugin.report.service.h.OAn.b(12065, new Object[] { Integer.valueOf(6) });
      }
      if (paramInt == 6) {
        ((Intent)localObject2).putExtra("pay_channel", 15);
      }
      if (paramInt == 31) {
        ((Intent)localObject2).putExtra("game_report_from_scene", 4);
      }
      if (paramInt == 41) {
        ((Intent)localObject2).putExtra("key_from_scene", 5);
      }
      if (paramInt == 42) {
        ((Intent)localObject2).putExtra("key_from_scene", 4);
      }
      if (paramInt == 64) {
        ((Intent)localObject2).putExtra("entry_fix_tools", 1);
      }
      if ((paramInt == 63) || (paramInt == 67)) {
        ((Intent)localObject2).putExtra("biz_enter_source", 2);
      }
      if (paramInt == 69)
      {
        ((Intent)localObject2).putExtra("Contact_User", "appbrandcustomerservicemsg");
        ((Intent)localObject2).putExtra("app_brand_conversation_from_scene", 4);
        ((Intent)localObject2).addFlags(67108864);
      }
      if (paramInt == 74)
      {
        ((Intent)localObject2).putExtra("Contact_User", "opencustomerservicemsg");
        ((Intent)localObject2).putExtra("open_im_kefu_conversation_list_ui_from_scene", 3);
        ((Intent)localObject2).addFlags(67108864);
      }
      if (paramInt == 30)
      {
        ((Intent)localObject2).putExtra("key_enable_multi_code", true);
        ((Intent)localObject2).putExtra("key_scan_goods_enable_dynamic_wording", true);
        ((Intent)localObject2).putExtra("key_enable_scan_code_product_merge", true);
      }
      if (paramInt == 33) {
        com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.FavoriteIndexUI", new Intent());
      }
      for (;;)
      {
        com.tencent.mm.ui.base.b.aR(paramContext, (Intent)localObject2);
        AppMethodBeat.o(28068);
        return true;
        if (paramInt == 35)
        {
          ((Intent)localObject2).setClassName(paramContext, "com.tencent.mm.plugin.backup.backupmoveui.BackupUI");
          MMWizardActivity.aQ(paramContext, (Intent)localObject2);
        }
        else if (paramInt == 66)
        {
          ((v)com.tencent.mm.kernel.h.ax(v.class)).T(paramContext, 16);
        }
        else if (!((a)localObject1).HjZ.equals("app"))
        {
          com.tencent.mm.br.c.b(paramContext, ((a)localObject1).HjZ, ((a)localObject1).uri, (Intent)localObject2);
        }
        else
        {
          com.tencent.mm.br.c.g(paramContext, ((a)localObject1).uri, (Intent)localObject2);
        }
      }
    }
    if (paramInt == 65)
    {
      com.tencent.mm.plugin.topstory.ui.d.bc(paramContext, 21);
      AppMethodBeat.o(28068);
      return true;
    }
    if (paramInt == 71)
    {
      localObject2 = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG();
      if (localObject2 != null)
      {
        List localList = ((by)localObject2).nd(null);
        if (localList == null) {
          break label1348;
        }
        paramInt = 0;
        if (paramInt >= localList.size()) {
          break label1348;
        }
        if (!"appbrand_notify_message".equals((String)localList.get(paramInt))) {
          break label1278;
        }
      }
    }
    for (;;)
    {
      localObject2 = ((by)localObject2).bxM("appbrand_notify_message");
      if (localObject2 != null) {}
      for (int i = ((bd)localObject2).field_unReadCount;; i = 0)
      {
        localObject2 = (com.tencent.mm.plugin.appbrand.service.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.h.class);
        com.tencent.mm.kernel.h.baC();
        ((com.tencent.mm.plugin.appbrand.service.h)localObject2).UQ(Util.nullAsNil(String.valueOf(com.tencent.mm.kernel.b.getUin())));
        ((com.tencent.mm.plugin.appbrand.service.h)localObject2).a(new h.a(i, paramInt + 1));
        if (((a)localObject1).uri.equals(".ui.chatting.ChattingUI"))
        {
          localObject1 = ((a)localObject1).username;
          if (com.tencent.mm.contact.d.rs(((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE((String)localObject1).field_type))
          {
            localObject2 = new Intent();
            ((Intent)localObject2).putExtra("Chat_User", (String)localObject1);
            ((Intent)localObject2).putExtra("finish_direct", true);
            ((Intent)localObject2).putExtra("chat_from_scene", 5);
            com.tencent.mm.br.c.g(paramContext, ".ui.chatting.ChattingUI", (Intent)localObject2);
          }
          for (;;)
          {
            AppMethodBeat.o(28068);
            return true;
            label1278:
            paramInt += 1;
            break;
            bL(paramContext, (String)localObject1);
          }
        }
        if (((a)localObject1).uri.equals(".plugin.profile.ui.ContactInfoUI"))
        {
          bool = bL(paramContext, ((a)localObject1).username);
          AppMethodBeat.o(28068);
          return bool;
        }
        Log.e("MicroMsg.Feature", "Error URI of android feature");
        AppMethodBeat.o(28068);
        return false;
      }
      label1348:
      paramInt = 0;
    }
  }
  
  private static boolean bL(Context paramContext, String paramString)
  {
    AppMethodBeat.i(28067);
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", paramString);
    com.tencent.mm.br.c.b(paramContext, "profile", ".ui.ContactInfoUI", localIntent);
    AppMethodBeat.o(28067);
    return true;
  }
  
  static final class a
  {
    String HjZ;
    int Plk;
    boolean Pll;
    int id;
    String uri;
    String username;
    
    public a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
    {
      this(paramInt1, paramInt2, paramString1, paramString2, paramString3, (byte)0);
    }
    
    public a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, byte paramByte)
    {
      this.id = paramInt1;
      this.Plk = paramInt2;
      this.uri = paramString1;
      this.HjZ = paramString2;
      this.username = paramString3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.search.a.a
 * JD-Core Version:    0.7.0.1
 */