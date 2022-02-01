package com.tencent.mm.plugin.search.a;

import android.content.Context;
import android.content.Intent;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.service.g.a;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.MMWizardActivity;
import java.util.List;

public final class a
{
  public static final SparseArray<a> CVG;
  
  static
  {
    AppMethodBeat.i(28069);
    SparseArray localSparseArray = new SparseArray();
    CVG = localSparseArray;
    localSparseArray.put(19, new a(19, -1, ".ui.SnsTimeLineUI", "sns", ""));
    CVG.put(30, new a(19, -1, ".ui.BaseScanUI", "scanner", "", (byte)0));
    CVG.put(18, new a(18, -1, ".ui.ShakeReportUI", "shake", ""));
    CVG.put(17, new a(17, -1, ".ui.NearbyFriendsIntroUI", "nearby", ""));
    CVG.put(16, new a(16, -1, ".ui.BottleBeachUI", "bottle", ""));
    CVG.put(31, new a(31, -1, ".ui.GameCenterUI", "game", ""));
    CVG.put(20, new a(20, -1, ".plugin.profile.ui.ContactInfoUI", "", "voiceinputapp"));
    CVG.put(21, new a(21, -1, ".plugin.profile.ui.ContactInfoUI", "", "linkedinplugin"));
    CVG.put(26, new a(26, -1, ".plugin.profile.ui.ContactInfoUI", "", "qqfriend"));
    CVG.put(29, new a(29, -1, ".plugin.profile.ui.ContactInfoUI", "", "voipapp"));
    CVG.put(23, new a(23, 1, ".ui.chatting.ChattingUI", "", "qqmail"));
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sad, true))
    {
      CVG.put(1, new a(1, -1, ".ui.MallIndexUIv2", "mall", ""));
      CVG.put(24, new a(24, 8, ".ui.chatting.ChattingUI", "", "weibo"));
      CVG.put(27, new a(27, 65536, ".ui.MassSendHistoryUI", "masssend", "masssendapp"));
      CVG.put(28, new a(28, 524288, ".ui.ReaderAppUI", "readerapp", "newsapp"));
      CVG.put(32, new a(32, -1, ".ui.v2.EmojiStoreV2UI", "emoji", ""));
      CVG.put(33, new a(33, -1, ".ui.FavoriteIndexUI", "favorite", ""));
      if (!((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sad, true)) {
        break label1024;
      }
      CVG.put(34, new a(34, -1, ".ui.MallIndexUIv2", "mall", ""));
    }
    for (;;)
    {
      CVG.put(35, new a(35, -1, ".backupmoveui.BackupUI", "backup", ""));
      CVG.put(38, new a(38, 16, ".ui.chatting.ChattingUI", "", "medianote"));
      CVG.put(39, new a(39, -1, ".ui.chatting.ChattingUI", "", "filehelper"));
      CVG.put(6, new a(6, -1, ".ui.LuckyMoneyIndexUI", "luckymoney", ""));
      CVG.put(41, new a(41, -1, ".ui.WalletOfflineEntranceUI", "offline", ""));
      CVG.put(42, new a(42, -1, ".ui.CollectAdapterUI", "collect", ""));
      CVG.put(40, new a(40, -1, ".balance.ui.WalletBalanceManagerUI", "wallet", ""));
      CVG.put(43, new a(43, -1, ".ui.chatting.ChattingUI", "", "gh_43f2581f6fd6"));
      CVG.put(50, new a(50, -1, ".ui.conversation.BizConversationUI", "app", ""));
      CVG.put(51, new a(51, -1, ".ui.setting.SettingsPrivacyUI", "setting", ""));
      CVG.put(66, new a(66, -1, ".ui.AppBrandLauncherUI", "appbrand", ""));
      CVG.put(63, new a(63, -1, ".ui.conversation.BizConversationUI", "app", ""));
      CVG.put(64, new a(64, -1, ".plugin.setting.ui.fixtools.FixToolsUI", "app", ""));
      CVG.put(65, new a(65, -1, "", "", ""));
      CVG.put(67, new a(67, -1, ".plugin.brandservice.ui.timeline.BizTimeLineUI", "app", ""));
      CVG.put(68, new a(68, -1, ".ui.chatting.ChattingUI", "", "gh_3dfda90e39d6"));
      CVG.put(69, new a(69, -1, ".ui.conversation.AppBrandServiceConversationUI", "app", ""));
      CVG.put(70, new a(70, -1, ".ui.chatting.ChattingUI", "", "gh_f0a92aa7146c"));
      CVG.put(71, new a(71, -1, ".ui.chatting.ChattingUI", "", "appbrand_notify_message"));
      if (1 == ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.soA, 0)) {
        CVG.put(72, new a(72, -1, ".ui.chatting.ChattingUI", "", "gh_579db1f2cf89"));
      }
      AppMethodBeat.o(28069);
      return;
      CVG.put(1, new a(1, -1, ".ui.MallIndexUI", "mall", ""));
      break;
      label1024:
      CVG.put(34, new a(34, -1, ".ui.MallIndexUI", "mall", ""));
    }
  }
  
  public static boolean an(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(28068);
    if (CVG.indexOfKey(paramInt) < 0)
    {
      AppMethodBeat.o(28068);
      return false;
    }
    if ((paramInt == 30) && ((com.tencent.mm.q.a.o(paramContext, true)) || (com.tencent.mm.q.a.cA(paramContext)) || (com.tencent.mm.q.a.cE(paramContext))))
    {
      AppMethodBeat.o(28068);
      return false;
    }
    Object localObject1 = (a)CVG.get(paramInt);
    if ((ab.IJ(((a)localObject1).username)) && (!WeChatBrands.Business.Entries.HomePluginSports.checkAvailable(paramContext)))
    {
      AppMethodBeat.o(28068);
      return true;
    }
    if ((ab.IK(((a)localObject1).username)) && (!WeChatBrands.Business.Entries.HomePluginWePay.checkAvailable(paramContext)))
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
    if ((((a)localObject1).CVH != -1) && ((z.aUl() & ((a)localObject1).CVH) != 0))
    {
      bool = bw(paramContext, ((a)localObject1).username);
      AppMethodBeat.o(28068);
      return bool;
    }
    Object localObject2;
    if (!Util.isNullOrNil(((a)localObject1).wJd))
    {
      localObject2 = new Intent();
      if (paramInt == 28) {
        ((Intent)localObject2).putExtra("type", 20);
      }
      if (paramInt == 1) {
        ((Intent)localObject2).putExtra("key_native_url", "wxpay://bizmall/mobile_recharge");
      }
      ((Intent)localObject2).putExtra("animation_pop_in", ((a)localObject1).CVI);
      if (paramInt == 32) {
        h.CyF.a(12065, new Object[] { Integer.valueOf(6) });
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
      if (paramInt == 33) {
        com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.FavoriteIndexUI", new Intent());
      }
      for (;;)
      {
        com.tencent.mm.ui.base.b.az(paramContext, (Intent)localObject2);
        AppMethodBeat.o(28068);
        return true;
        if (paramInt == 35)
        {
          ((Intent)localObject2).setClassName(paramContext, "com.tencent.mm.plugin.backup.backupmoveui.BackupUI");
          MMWizardActivity.ay(paramContext, (Intent)localObject2);
        }
        else if (paramInt == 66)
        {
          ((t)com.tencent.mm.kernel.g.af(t.class)).K(paramContext, 16);
        }
        else if (!((a)localObject1).wJd.equals("app"))
        {
          com.tencent.mm.br.c.b(paramContext, ((a)localObject1).wJd, ((a)localObject1).uri, (Intent)localObject2);
        }
        else
        {
          com.tencent.mm.br.c.f(paramContext, ((a)localObject1).uri, (Intent)localObject2);
        }
      }
    }
    if (paramInt == 65)
    {
      com.tencent.mm.plugin.topstory.ui.c.as(paramContext, 21);
      AppMethodBeat.o(28068);
      return true;
    }
    if (paramInt == 71)
    {
      localObject2 = ((l)com.tencent.mm.kernel.g.af(l.class)).aST();
      if (localObject2 != null)
      {
        List localList = ((bw)localObject2).gCw();
        paramInt = 0;
        if (paramInt >= localList.size()) {
          break label1073;
        }
        if (!"appbrand_notify_message".equals((String)localList.get(paramInt))) {
          break label1003;
        }
      }
    }
    for (;;)
    {
      localObject2 = ((bw)localObject2).bjY("appbrand_notify_message");
      if (localObject2 != null) {}
      for (int i = ((bb)localObject2).field_unReadCount;; i = 0)
      {
        localObject2 = (com.tencent.mm.plugin.appbrand.service.g)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.g.class);
        com.tencent.mm.kernel.g.aAf();
        ((com.tencent.mm.plugin.appbrand.service.g)localObject2).UF(Util.nullAsNil(String.valueOf(com.tencent.mm.kernel.a.getUin())));
        ((com.tencent.mm.plugin.appbrand.service.g)localObject2).a(new g.a(i, paramInt + 1));
        if (((a)localObject1).uri.equals(".ui.chatting.ChattingUI"))
        {
          localObject1 = ((a)localObject1).username;
          if (com.tencent.mm.contact.c.oR(((l)com.tencent.mm.kernel.g.af(l.class)).aSN().Kn((String)localObject1).field_type))
          {
            localObject2 = new Intent();
            ((Intent)localObject2).putExtra("Chat_User", (String)localObject1);
            ((Intent)localObject2).putExtra("finish_direct", true);
            ((Intent)localObject2).putExtra("chat_from_scene", 5);
            com.tencent.mm.br.c.f(paramContext, ".ui.chatting.ChattingUI", (Intent)localObject2);
          }
          for (;;)
          {
            AppMethodBeat.o(28068);
            return true;
            label1003:
            paramInt += 1;
            break;
            bw(paramContext, (String)localObject1);
          }
        }
        if (((a)localObject1).uri.equals(".plugin.profile.ui.ContactInfoUI"))
        {
          bool = bw(paramContext, ((a)localObject1).username);
          AppMethodBeat.o(28068);
          return bool;
        }
        Log.e("MicroMsg.Feature", "Error URI of android feature");
        AppMethodBeat.o(28068);
        return false;
      }
      label1073:
      paramInt = 0;
    }
  }
  
  private static boolean bw(Context paramContext, String paramString)
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
    int CVH;
    boolean CVI;
    int id;
    String uri;
    String username;
    String wJd;
    
    public a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
    {
      this(paramInt1, paramInt2, paramString1, paramString2, paramString3, (byte)0);
    }
    
    public a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, byte paramByte)
    {
      this.id = paramInt1;
      this.CVH = paramInt2;
      this.uri = paramString1;
      this.wJd = paramString2;
      this.username = paramString3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.search.a.a
 * JD-Core Version:    0.7.0.1
 */