package com.tencent.mm.plugin.search.a;

import android.content.Context;
import android.content.Intent;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.appbrand.service.g.a;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.MMWizardActivity;
import java.util.List;

public final class a
{
  public static final SparseArray<a> yBt;
  
  static
  {
    AppMethodBeat.i(28069);
    SparseArray localSparseArray = new SparseArray();
    yBt = localSparseArray;
    localSparseArray.put(19, new a(19, -1, ".ui.SnsTimeLineUI", "sns", ""));
    yBt.put(30, new a(19, -1, ".ui.BaseScanUI", "scanner", "", (byte)0));
    yBt.put(18, new a(18, -1, ".ui.ShakeReportUI", "shake", ""));
    yBt.put(17, new a(17, -1, ".ui.NearbyFriendsIntroUI", "nearby", ""));
    yBt.put(16, new a(16, -1, ".ui.BottleBeachUI", "bottle", ""));
    yBt.put(31, new a(31, -1, ".ui.GameCenterUI", "game", ""));
    yBt.put(20, new a(20, -1, ".plugin.profile.ui.ContactInfoUI", "", "voiceinputapp"));
    yBt.put(21, new a(21, -1, ".plugin.profile.ui.ContactInfoUI", "", "linkedinplugin"));
    yBt.put(26, new a(26, -1, ".plugin.profile.ui.ContactInfoUI", "", "qqfriend"));
    yBt.put(29, new a(29, -1, ".plugin.profile.ui.ContactInfoUI", "", "voipapp"));
    yBt.put(23, new a(23, 1, ".ui.chatting.ChattingUI", "", "qqmail"));
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qzF, false))
    {
      yBt.put(1, new a(1, -1, ".ui.MallIndexUIv2", "mall", ""));
      yBt.put(24, new a(24, 8, ".ui.chatting.ChattingUI", "", "weibo"));
      yBt.put(27, new a(27, 65536, ".ui.MassSendHistoryUI", "masssend", "masssendapp"));
      yBt.put(28, new a(28, 524288, ".ui.ReaderAppUI", "readerapp", "newsapp"));
      yBt.put(32, new a(32, -1, ".ui.v2.EmojiStoreV2UI", "emoji", ""));
      yBt.put(33, new a(33, -1, ".ui.FavoriteIndexUI", "favorite", ""));
      if (!((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qzF, false)) {
        break label979;
      }
      yBt.put(34, new a(34, -1, ".ui.MallIndexUIv2", "mall", ""));
    }
    for (;;)
    {
      yBt.put(35, new a(35, -1, ".backupmoveui.BackupUI", "backup", ""));
      yBt.put(38, new a(38, 16, ".ui.chatting.ChattingUI", "", "medianote"));
      yBt.put(39, new a(39, -1, ".ui.chatting.ChattingUI", "", "filehelper"));
      yBt.put(6, new a(6, -1, ".ui.LuckyMoneyIndexUI", "luckymoney", ""));
      yBt.put(41, new a(41, -1, ".ui.WalletOfflineEntranceUI", "offline", ""));
      yBt.put(42, new a(42, -1, ".ui.CollectAdapterUI", "collect", ""));
      yBt.put(40, new a(40, -1, ".balance.ui.WalletBalanceManagerUI", "wallet", ""));
      yBt.put(43, new a(43, -1, ".ui.chatting.ChattingUI", "", "gh_43f2581f6fd6"));
      yBt.put(50, new a(50, -1, ".ui.conversation.BizConversationUI", "app", ""));
      yBt.put(51, new a(51, -1, ".ui.setting.SettingsPrivacyUI", "setting", ""));
      yBt.put(66, new a(66, -1, ".ui.AppBrandLauncherUI", "appbrand", ""));
      yBt.put(63, new a(63, -1, ".ui.conversation.BizConversationUI", "app", ""));
      yBt.put(64, new a(64, -1, ".plugin.setting.ui.fixtools.FixToolsUI", "app", ""));
      yBt.put(65, new a(65, -1, "", "", ""));
      yBt.put(67, new a(67, -1, ".plugin.brandservice.ui.timeline.BizTimeLineUI", "app", ""));
      yBt.put(68, new a(68, -1, ".ui.chatting.ChattingUI", "", "gh_3dfda90e39d6"));
      yBt.put(69, new a(69, -1, ".ui.conversation.AppBrandServiceConversationUI", "app", ""));
      yBt.put(70, new a(70, -1, ".ui.chatting.ChattingUI", "", "gh_f0a92aa7146c"));
      yBt.put(71, new a(71, -1, ".ui.chatting.ChattingUI", "", "appbrand_notify_message"));
      AppMethodBeat.o(28069);
      return;
      yBt.put(1, new a(1, -1, ".ui.MallIndexUI", "mall", ""));
      break;
      label979:
      yBt.put(34, new a(34, -1, ".ui.MallIndexUI", "mall", ""));
    }
  }
  
  public static boolean ah(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(28068);
    if (yBt.indexOfKey(paramInt) < 0)
    {
      AppMethodBeat.o(28068);
      return false;
    }
    if ((paramInt == 30) && ((com.tencent.mm.s.a.n(paramContext, true)) || (com.tencent.mm.s.a.cd(paramContext)) || (com.tencent.mm.s.a.ch(paramContext))))
    {
      AppMethodBeat.o(28068);
      return false;
    }
    Object localObject1 = (a)yBt.get(paramInt);
    boolean bool;
    if ((((a)localObject1).yBu != -1) && ((u.aAy() & ((a)localObject1).yBu) != 0))
    {
      bool = bc(paramContext, ((a)localObject1).username);
      AppMethodBeat.o(28068);
      return bool;
    }
    Object localObject2;
    if (!bt.isNullOrNil(((a)localObject1).til))
    {
      localObject2 = new Intent();
      if (paramInt == 28) {
        ((Intent)localObject2).putExtra("type", 20);
      }
      if (paramInt == 1) {
        ((Intent)localObject2).putExtra("key_native_url", "wxpay://bizmall/mobile_recharge");
      }
      ((Intent)localObject2).putExtra("animation_pop_in", ((a)localObject1).yBv);
      if (paramInt == 32) {
        com.tencent.mm.plugin.report.service.g.yhR.f(12065, new Object[] { Integer.valueOf(6) });
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
        com.tencent.mm.ui.base.b.am(paramContext, (Intent)localObject2);
        AppMethodBeat.o(28068);
        return true;
        if (paramInt == 35)
        {
          ((Intent)localObject2).setClassName(paramContext, "com.tencent.mm.plugin.backup.backupmoveui.BackupUI");
          MMWizardActivity.al(paramContext, (Intent)localObject2);
        }
        else if (paramInt == 66)
        {
          ((q)com.tencent.mm.kernel.g.ab(q.class)).H(paramContext, 16);
        }
        else if (!((a)localObject1).til.equals("app"))
        {
          com.tencent.mm.bs.d.b(paramContext, ((a)localObject1).til, ((a)localObject1).uri, (Intent)localObject2);
        }
        else
        {
          com.tencent.mm.bs.d.f(paramContext, ((a)localObject1).uri, (Intent)localObject2);
        }
      }
    }
    if (paramInt == 65)
    {
      com.tencent.mm.plugin.topstory.ui.d.aj(paramContext, 21);
      AppMethodBeat.o(28068);
      return true;
    }
    if (paramInt == 71)
    {
      localObject2 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azv();
      if (localObject2 != null)
      {
        List localList = ((bq)localObject2).fqP();
        paramInt = 0;
        if (paramInt >= localList.size()) {
          break label797;
        }
        if (!"appbrand_notify_message".equals((String)localList.get(paramInt))) {
          break label727;
        }
      }
    }
    for (;;)
    {
      localObject2 = ((bq)localObject2).aTz("appbrand_notify_message");
      if (localObject2 != null) {}
      for (int i = ((ba)localObject2).field_unReadCount;; i = 0)
      {
        localObject2 = (com.tencent.mm.plugin.appbrand.service.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.g.class);
        com.tencent.mm.kernel.g.ajA();
        ((com.tencent.mm.plugin.appbrand.service.g)localObject2).KW(bt.nullAsNil(String.valueOf(com.tencent.mm.kernel.a.getUin())));
        ((com.tencent.mm.plugin.appbrand.service.g)localObject2).a(new g.a(i, paramInt + 1));
        if (((a)localObject1).uri.equals(".ui.chatting.ChattingUI"))
        {
          localObject1 = ((a)localObject1).username;
          if (com.tencent.mm.o.b.lM(((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf((String)localObject1).field_type))
          {
            localObject2 = new Intent();
            ((Intent)localObject2).putExtra("Chat_User", (String)localObject1);
            ((Intent)localObject2).putExtra("finish_direct", true);
            com.tencent.mm.bs.d.f(paramContext, ".ui.chatting.ChattingUI", (Intent)localObject2);
          }
          for (;;)
          {
            AppMethodBeat.o(28068);
            return true;
            label727:
            paramInt += 1;
            break;
            bc(paramContext, (String)localObject1);
          }
        }
        if (((a)localObject1).uri.equals(".plugin.profile.ui.ContactInfoUI"))
        {
          bool = bc(paramContext, ((a)localObject1).username);
          AppMethodBeat.o(28068);
          return bool;
        }
        ad.e("MicroMsg.Feature", "Error URI of android feature");
        AppMethodBeat.o(28068);
        return false;
      }
      label797:
      paramInt = 0;
    }
  }
  
  private static boolean bc(Context paramContext, String paramString)
  {
    AppMethodBeat.i(28067);
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", paramString);
    com.tencent.mm.bs.d.b(paramContext, "profile", ".ui.ContactInfoUI", localIntent);
    AppMethodBeat.o(28067);
    return true;
  }
  
  static final class a
  {
    int id;
    String til;
    String uri;
    String username;
    int yBu;
    boolean yBv;
    
    public a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
    {
      this(paramInt1, paramInt2, paramString1, paramString2, paramString3, (byte)0);
    }
    
    public a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, byte paramByte)
    {
      this.id = paramInt1;
      this.yBu = paramInt2;
      this.uri = paramString1;
      this.til = paramString2;
      this.username = paramString3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.search.a.a
 * JD-Core Version:    0.7.0.1
 */