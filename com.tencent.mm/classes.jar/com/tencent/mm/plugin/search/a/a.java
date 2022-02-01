package com.tencent.mm.plugin.search.a;

import android.content.Context;
import android.content.Intent;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.service.g;
import com.tencent.mm.plugin.appbrand.service.g.a;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.MMWizardActivity;
import java.util.List;

public final class a
{
  public static final SparseArray<a> Jbs;
  
  static
  {
    AppMethodBeat.i(28069);
    SparseArray localSparseArray = new SparseArray();
    Jbs = localSparseArray;
    localSparseArray.put(19, new a(19, -1, ".ui.SnsTimeLineUI", "sns", ""));
    Jbs.put(30, new a(19, -1, ".ui.BaseScanUI", "scanner", "", (byte)0));
    Jbs.put(18, new a(18, -1, ".ui.ShakeReportUI", "shake", ""));
    Jbs.put(17, new a(17, -1, ".ui.NearbyFriendsIntroUI", "nearby", ""));
    Jbs.put(16, new a(16, -1, ".ui.BottleBeachUI", "bottle", ""));
    Jbs.put(31, new a(31, -1, ".ui.GameCenterUI", "game", ""));
    Jbs.put(20, new a(20, -1, ".plugin.profile.ui.ContactInfoUI", "", "voiceinputapp"));
    Jbs.put(21, new a(21, -1, ".plugin.profile.ui.ContactInfoUI", "", "linkedinplugin"));
    Jbs.put(26, new a(26, -1, ".plugin.profile.ui.ContactInfoUI", "", "qqfriend"));
    Jbs.put(29, new a(29, -1, ".plugin.profile.ui.ContactInfoUI", "", "voipapp"));
    Jbs.put(23, new a(23, 1, ".ui.chatting.ChattingUI", "", "qqmail"));
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vHh, true))
    {
      Jbs.put(1, new a(1, -1, ".ui.MallIndexUIv2", "mall", ""));
      Jbs.put(24, new a(24, 8, ".ui.chatting.ChattingUI", "", "weibo"));
      Jbs.put(27, new a(27, 65536, ".ui.MassSendHistoryUI", "masssend", "masssendapp"));
      Jbs.put(28, new a(28, 524288, ".ui.ReaderAppUI", "readerapp", "newsapp"));
      Jbs.put(32, new a(32, -1, ".ui.v2.EmojiStoreV2UI", "emoji", ""));
      Jbs.put(33, new a(33, -1, ".ui.FavoriteIndexUI", "favorite", ""));
      if (!((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vHh, true)) {
        break label1048;
      }
      Jbs.put(34, new a(34, -1, ".ui.MallIndexUIv2", "mall", ""));
    }
    for (;;)
    {
      Jbs.put(35, new a(35, -1, ".backupmoveui.BackupUI", "backup", ""));
      Jbs.put(38, new a(38, 16, ".ui.chatting.ChattingUI", "", "medianote"));
      Jbs.put(39, new a(39, -1, ".ui.chatting.ChattingUI", "", "filehelper"));
      Jbs.put(6, new a(6, -1, ".ui.LuckyMoneyIndexUI", "luckymoney", ""));
      Jbs.put(41, new a(41, -1, ".ui.WalletOfflineEntranceUI", "offline", ""));
      Jbs.put(42, new a(42, -1, ".ui.CollectAdapterUI", "collect", ""));
      Jbs.put(40, new a(40, -1, ".balance.ui.WalletBalanceManagerUI", "wallet", ""));
      Jbs.put(43, new a(43, -1, ".ui.chatting.ChattingUI", "", "gh_43f2581f6fd6"));
      Jbs.put(50, new a(50, -1, ".ui.conversation.BizConversationUI", "app", ""));
      Jbs.put(51, new a(51, -1, ".ui.setting.SettingsPrivacyUI", "setting", ""));
      Jbs.put(66, new a(66, -1, ".ui.AppBrandLauncherUI", "appbrand", ""));
      Jbs.put(63, new a(63, -1, ".ui.conversation.BizConversationUI", "app", ""));
      Jbs.put(64, new a(64, -1, ".plugin.setting.ui.fixtools.FixToolsUI", "app", ""));
      Jbs.put(65, new a(65, -1, "", "", ""));
      Jbs.put(67, new a(67, -1, ".plugin.brandservice.ui.timeline.BizTimeLineUI", "app", ""));
      Jbs.put(68, new a(68, -1, ".ui.chatting.ChattingUI", "", "gh_3dfda90e39d6"));
      Jbs.put(69, new a(69, -1, ".ui.conversation.AppBrandServiceConversationUI", "app", ""));
      Jbs.put(70, new a(70, -1, ".ui.chatting.ChattingUI", "", "gh_f0a92aa7146c"));
      Jbs.put(71, new a(71, -1, ".ui.chatting.ChattingUI", "", "appbrand_notify_message"));
      if (1 == ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.waa, 0)) {
        Jbs.put(72, new a(72, -1, ".ui.chatting.ChattingUI", "", "gh_579db1f2cf89"));
      }
      Jbs.put(73, new a(73, -1, ".ui.chatting.ChattingUI", "", "gh_b4af18eac3d5"));
      AppMethodBeat.o(28069);
      return;
      Jbs.put(1, new a(1, -1, ".ui.MallIndexUI", "mall", ""));
      break;
      label1048:
      Jbs.put(34, new a(34, -1, ".ui.MallIndexUI", "mall", ""));
    }
  }
  
  public static boolean aF(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(28068);
    if (Jbs.indexOfKey(paramInt) < 0)
    {
      AppMethodBeat.o(28068);
      return false;
    }
    if ((paramInt == 30) && ((com.tencent.mm.q.a.p(paramContext, true)) || (com.tencent.mm.q.a.cw(paramContext)) || (com.tencent.mm.q.a.cB(paramContext))))
    {
      AppMethodBeat.o(28068);
      return false;
    }
    Object localObject1 = (a)Jbs.get(paramInt);
    if ((ab.Qb(((a)localObject1).username)) && (!WeChatBrands.Business.Entries.HomePluginSports.checkAvailable(paramContext)))
    {
      AppMethodBeat.o(28068);
      return true;
    }
    if ((ab.Qc(((a)localObject1).username)) && (!WeChatBrands.Business.Entries.HomePluginWePay.checkAvailable(paramContext)))
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
    if ((((a)localObject1).Jbt != -1) && ((z.bdn() & ((a)localObject1).Jbt) != 0))
    {
      bool = bJ(paramContext, ((a)localObject1).username);
      AppMethodBeat.o(28068);
      return bool;
    }
    Object localObject2;
    if (!Util.isNullOrNil(((a)localObject1).BCt))
    {
      localObject2 = new Intent();
      if (paramInt == 28) {
        ((Intent)localObject2).putExtra("type", 20);
      }
      if (paramInt == 1) {
        ((Intent)localObject2).putExtra("key_native_url", "wxpay://bizmall/mobile_recharge");
      }
      ((Intent)localObject2).putExtra("animation_pop_in", ((a)localObject1).Jbu);
      if (paramInt == 32) {
        com.tencent.mm.plugin.report.service.h.IzE.a(12065, new Object[] { Integer.valueOf(6) });
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
      if (paramInt == 30)
      {
        ((Intent)localObject2).putExtra("key_enable_multi_code", true);
        ((Intent)localObject2).putExtra("key_scan_goods_enable_dynamic_wording", true);
      }
      if (paramInt == 33) {
        com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.FavoriteIndexUI", new Intent());
      }
      for (;;)
      {
        com.tencent.mm.ui.base.b.aI(paramContext, (Intent)localObject2);
        AppMethodBeat.o(28068);
        return true;
        if (paramInt == 35)
        {
          ((Intent)localObject2).setClassName(paramContext, "com.tencent.mm.plugin.backup.backupmoveui.BackupUI");
          MMWizardActivity.aH(paramContext, (Intent)localObject2);
        }
        else if (paramInt == 66)
        {
          ((t)com.tencent.mm.kernel.h.ae(t.class)).O(paramContext, 16);
        }
        else if (!((a)localObject1).BCt.equals("app"))
        {
          c.b(paramContext, ((a)localObject1).BCt, ((a)localObject1).uri, (Intent)localObject2);
        }
        else
        {
          c.f(paramContext, ((a)localObject1).uri, (Intent)localObject2);
        }
      }
    }
    if (paramInt == 65)
    {
      com.tencent.mm.plugin.topstory.ui.d.aK(paramContext, 21);
      AppMethodBeat.o(28068);
      return true;
    }
    if (paramInt == 71)
    {
      localObject2 = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR();
      if (localObject2 != null)
      {
        List localList = ((bw)localObject2).hyJ();
        paramInt = 0;
        if (paramInt >= localList.size()) {
          break label1099;
        }
        if (!"appbrand_notify_message".equals((String)localList.get(paramInt))) {
          break label1029;
        }
      }
    }
    for (;;)
    {
      localObject2 = ((bw)localObject2).bwx("appbrand_notify_message");
      if (localObject2 != null) {}
      for (int i = ((bb)localObject2).field_unReadCount;; i = 0)
      {
        localObject2 = (g)com.tencent.mm.kernel.h.ae(g.class);
        com.tencent.mm.kernel.h.aHE();
        ((g)localObject2).acp(Util.nullAsNil(String.valueOf(com.tencent.mm.kernel.b.getUin())));
        ((g)localObject2).a(new g.a(i, paramInt + 1));
        if (((a)localObject1).uri.equals(".ui.chatting.ChattingUI"))
        {
          localObject1 = ((a)localObject1).username;
          if (com.tencent.mm.contact.d.rk(((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG((String)localObject1).field_type))
          {
            localObject2 = new Intent();
            ((Intent)localObject2).putExtra("Chat_User", (String)localObject1);
            ((Intent)localObject2).putExtra("finish_direct", true);
            ((Intent)localObject2).putExtra("chat_from_scene", 5);
            c.f(paramContext, ".ui.chatting.ChattingUI", (Intent)localObject2);
          }
          for (;;)
          {
            AppMethodBeat.o(28068);
            return true;
            label1029:
            paramInt += 1;
            break;
            bJ(paramContext, (String)localObject1);
          }
        }
        if (((a)localObject1).uri.equals(".plugin.profile.ui.ContactInfoUI"))
        {
          bool = bJ(paramContext, ((a)localObject1).username);
          AppMethodBeat.o(28068);
          return bool;
        }
        Log.e("MicroMsg.Feature", "Error URI of android feature");
        AppMethodBeat.o(28068);
        return false;
      }
      label1099:
      paramInt = 0;
    }
  }
  
  private static boolean bJ(Context paramContext, String paramString)
  {
    AppMethodBeat.i(28067);
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", paramString);
    c.b(paramContext, "profile", ".ui.ContactInfoUI", localIntent);
    AppMethodBeat.o(28067);
    return true;
  }
  
  static final class a
  {
    String BCt;
    int Jbt;
    boolean Jbu;
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
      this.Jbt = paramInt2;
      this.uri = paramString1;
      this.BCt = paramString2;
      this.username = paramString3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.search.a.a
 * JD-Core Version:    0.7.0.1
 */