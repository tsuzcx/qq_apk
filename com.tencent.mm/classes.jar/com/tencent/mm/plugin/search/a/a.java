package com.tencent.mm.plugin.search.a;

import android.content.Context;
import android.content.Intent;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.appbrand.service.p;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.MMWizardActivity;

public final class a
{
  public static final SparseArray<a> wch;
  
  static
  {
    AppMethodBeat.i(28069);
    SparseArray localSparseArray = new SparseArray();
    wch = localSparseArray;
    localSparseArray.put(19, new a(19, -1, ".ui.SnsTimeLineUI", "sns", ""));
    wch.put(30, new a(19, -1, ".ui.BaseScanUI", "scanner", "", (byte)0));
    wch.put(18, new a(18, -1, ".ui.ShakeReportUI", "shake", ""));
    wch.put(17, new a(17, -1, ".ui.NearbyFriendsIntroUI", "nearby", ""));
    wch.put(16, new a(16, -1, ".ui.BottleBeachUI", "bottle", ""));
    wch.put(31, new a(31, -1, ".ui.GameCenterUI", "game", ""));
    wch.put(20, new a(20, -1, ".plugin.profile.ui.ContactInfoUI", "", "voiceinputapp"));
    wch.put(21, new a(21, -1, ".plugin.profile.ui.ContactInfoUI", "", "linkedinplugin"));
    wch.put(26, new a(26, -1, ".plugin.profile.ui.ContactInfoUI", "", "qqfriend"));
    wch.put(29, new a(29, -1, ".plugin.profile.ui.ContactInfoUI", "", "voipapp"));
    wch.put(23, new a(23, 1, ".ui.chatting.ChattingUI", "", "qqmail"));
    wch.put(1, new a(1, -1, ".ui.MallIndexUI", "mall", ""));
    wch.put(24, new a(24, 8, ".ui.chatting.ChattingUI", "", "weibo"));
    wch.put(27, new a(27, 65536, ".ui.MassSendHistoryUI", "masssend", "masssendapp"));
    wch.put(28, new a(28, 524288, ".ui.ReaderAppUI", "readerapp", "newsapp"));
    wch.put(32, new a(32, -1, ".ui.v2.EmojiStoreV2UI", "emoji", ""));
    wch.put(33, new a(33, -1, ".ui.FavoriteIndexUI", "favorite", ""));
    wch.put(34, new a(34, -1, ".ui.MallIndexUI", "mall", ""));
    wch.put(35, new a(35, -1, ".backupmoveui.BackupUI", "backup", ""));
    wch.put(38, new a(38, 16, ".ui.chatting.ChattingUI", "", "medianote"));
    wch.put(39, new a(39, -1, ".ui.chatting.ChattingUI", "", "filehelper"));
    wch.put(6, new a(6, -1, ".ui.LuckyMoneyIndexUI", "luckymoney", ""));
    wch.put(41, new a(41, -1, ".ui.WalletOfflineEntranceUI", "offline", ""));
    wch.put(42, new a(42, -1, ".ui.CollectAdapterUI", "collect", ""));
    wch.put(40, new a(40, -1, ".balance.ui.WalletBalanceManagerUI", "wallet", ""));
    wch.put(43, new a(43, -1, ".ui.chatting.ChattingUI", "", "gh_43f2581f6fd6"));
    wch.put(50, new a(50, -1, ".ui.conversation.BizConversationUI", "app", ""));
    wch.put(51, new a(51, -1, ".ui.setting.SettingsPrivacyUI", "setting", ""));
    wch.put(66, new a(66, -1, ".ui.AppBrandLauncherUI", "appbrand", ""));
    wch.put(63, new a(63, -1, ".ui.conversation.BizConversationUI", "app", ""));
    wch.put(64, new a(64, -1, ".plugin.setting.ui.fixtools.FixToolsUI", "app", ""));
    wch.put(65, new a(65, -1, "", "", ""));
    wch.put(67, new a(67, -1, ".plugin.brandservice.ui.timeline.BizTimeLineUI", "app", ""));
    wch.put(68, new a(68, -1, ".ui.chatting.ChattingUI", "", "gh_3dfda90e39d6"));
    wch.put(69, new a(69, -1, ".ui.conversation.AppBrandServiceConversationUI", "app", ""));
    wch.put(70, new a(70, -1, ".ui.chatting.ChattingUI", "", "gh_f0a92aa7146c"));
    wch.put(71, new a(71, -1, ".ui.chatting.ChattingUI", "", "appbrand_notify_message"));
    AppMethodBeat.o(28069);
  }
  
  public static boolean Y(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(28068);
    if (wch.indexOfKey(paramInt) < 0)
    {
      AppMethodBeat.o(28068);
      return false;
    }
    if ((paramInt == 30) && ((com.tencent.mm.r.a.cd(paramContext)) || (com.tencent.mm.r.a.cc(paramContext))))
    {
      AppMethodBeat.o(28068);
      return false;
    }
    Object localObject = (a)wch.get(paramInt);
    boolean bool;
    if ((((a)localObject).wci != -1) && ((u.aqS() & ((a)localObject).wci) != 0))
    {
      bool = aY(paramContext, ((a)localObject).username);
      AppMethodBeat.o(28068);
      return bool;
    }
    Intent localIntent;
    if (!bt.isNullOrNil(((a)localObject).rdo))
    {
      localIntent = new Intent();
      if (paramInt == 28) {
        localIntent.putExtra("type", 20);
      }
      if (paramInt == 1) {
        localIntent.putExtra("key_native_url", "wxpay://bizmall/mobile_recharge");
      }
      localIntent.putExtra("animation_pop_in", ((a)localObject).wcj);
      if (paramInt == 32) {
        h.vKh.f(12065, new Object[] { Integer.valueOf(6) });
      }
      if (paramInt == 6) {
        localIntent.putExtra("pay_channel", 15);
      }
      if (paramInt == 31) {
        localIntent.putExtra("game_report_from_scene", 4);
      }
      if (paramInt == 41) {
        localIntent.putExtra("key_from_scene", 5);
      }
      if (paramInt == 42) {
        localIntent.putExtra("key_from_scene", 4);
      }
      if (paramInt == 64) {
        localIntent.putExtra("entry_fix_tools", 1);
      }
      if ((paramInt == 63) || (paramInt == 67)) {
        localIntent.putExtra("biz_enter_source", 2);
      }
      if (paramInt == 69)
      {
        localIntent.putExtra("Contact_User", "appbrandcustomerservicemsg");
        localIntent.putExtra("app_brand_conversation_from_scene", 4);
        localIntent.addFlags(67108864);
      }
      if (paramInt == 33) {
        com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.FavoriteIndexUI", new Intent());
      }
      for (;;)
      {
        com.tencent.mm.ui.base.b.W(paramContext, localIntent);
        AppMethodBeat.o(28068);
        return true;
        if (paramInt == 35)
        {
          localIntent.setClassName(paramContext, "com.tencent.mm.plugin.backup.backupmoveui.BackupUI");
          MMWizardActivity.V(paramContext, localIntent);
        }
        else if (paramInt == 66)
        {
          ((p)g.ab(p.class)).D(paramContext, 16);
        }
        else if (!((a)localObject).rdo.equals("app"))
        {
          com.tencent.mm.bs.d.b(paramContext, ((a)localObject).rdo, ((a)localObject).uri, localIntent);
        }
        else
        {
          com.tencent.mm.bs.d.e(paramContext, ((a)localObject).uri, localIntent);
        }
      }
    }
    if (paramInt == 65)
    {
      com.tencent.mm.plugin.topstory.ui.d.aa(paramContext, 21);
      AppMethodBeat.o(28068);
      return true;
    }
    if (((a)localObject).uri.equals(".ui.chatting.ChattingUI"))
    {
      localObject = ((a)localObject).username;
      if (com.tencent.mm.n.b.ls(((k)g.ab(k.class)).apM().aHY((String)localObject).field_type))
      {
        localIntent = new Intent();
        localIntent.putExtra("Chat_User", (String)localObject);
        localIntent.putExtra("finish_direct", true);
        com.tencent.mm.bs.d.e(paramContext, ".ui.chatting.ChattingUI", localIntent);
      }
      for (;;)
      {
        AppMethodBeat.o(28068);
        return true;
        aY(paramContext, (String)localObject);
      }
    }
    if (((a)localObject).uri.equals(".plugin.profile.ui.ContactInfoUI"))
    {
      bool = aY(paramContext, ((a)localObject).username);
      AppMethodBeat.o(28068);
      return bool;
    }
    ad.e("MicroMsg.Feature", "Error URI of android feature");
    AppMethodBeat.o(28068);
    return false;
  }
  
  private static boolean aY(Context paramContext, String paramString)
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
    String rdo;
    String uri;
    String username;
    int wci;
    boolean wcj;
    
    public a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
    {
      this(paramInt1, paramInt2, paramString1, paramString2, paramString3, (byte)0);
    }
    
    public a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, byte paramByte)
    {
      this.id = paramInt1;
      this.wci = paramInt2;
      this.uri = paramString1;
      this.rdo = paramString2;
      this.username = paramString3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.search.a.a
 * JD-Core Version:    0.7.0.1
 */