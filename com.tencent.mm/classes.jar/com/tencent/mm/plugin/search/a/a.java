package com.tencent.mm.plugin.search.a;

import android.content.Context;
import android.content.Intent;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.appbrand.service.l;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMWizardActivity;

public final class a
{
  public static final SparseArray<a.a> qDW;
  
  static
  {
    AppMethodBeat.i(24402);
    SparseArray localSparseArray = new SparseArray();
    qDW = localSparseArray;
    localSparseArray.put(19, new a.a(19, -1, ".ui.SnsTimeLineUI", "sns", ""));
    qDW.put(30, new a.a(19, -1, ".ui.BaseScanUI", "scanner", "", (byte)0));
    qDW.put(18, new a.a(18, -1, ".ui.ShakeReportUI", "shake", ""));
    qDW.put(17, new a.a(17, -1, ".ui.NearbyFriendsIntroUI", "nearby", ""));
    qDW.put(16, new a.a(16, -1, ".ui.BottleBeachUI", "bottle", ""));
    qDW.put(31, new a.a(31, -1, ".ui.GameCenterUI", "game", ""));
    qDW.put(20, new a.a(20, -1, ".plugin.profile.ui.ContactInfoUI", "", "voiceinputapp"));
    qDW.put(21, new a.a(21, -1, ".plugin.profile.ui.ContactInfoUI", "", "linkedinplugin"));
    qDW.put(26, new a.a(26, -1, ".plugin.profile.ui.ContactInfoUI", "", "qqfriend"));
    qDW.put(29, new a.a(29, -1, ".plugin.profile.ui.ContactInfoUI", "", "voipapp"));
    qDW.put(23, new a.a(23, 1, ".ui.chatting.ChattingUI", "", "qqmail"));
    qDW.put(1, new a.a(1, -1, ".ui.MallIndexUI", "mall", ""));
    qDW.put(24, new a.a(24, 8, ".ui.chatting.ChattingUI", "", "weibo"));
    qDW.put(27, new a.a(27, 65536, ".ui.MassSendHistoryUI", "masssend", "masssendapp"));
    qDW.put(28, new a.a(28, 524288, ".ui.ReaderAppUI", "readerapp", "newsapp"));
    qDW.put(32, new a.a(32, -1, ".ui.v2.EmojiStoreV2UI", "emoji", ""));
    qDW.put(33, new a.a(33, -1, ".ui.FavoriteIndexUI", "favorite", ""));
    qDW.put(34, new a.a(34, -1, ".ui.MallIndexUI", "mall", ""));
    qDW.put(35, new a.a(35, -1, ".backupmoveui.BackupUI", "backup", ""));
    qDW.put(38, new a.a(38, 16, ".ui.chatting.ChattingUI", "", "medianote"));
    qDW.put(39, new a.a(39, -1, ".ui.chatting.ChattingUI", "", "filehelper"));
    qDW.put(6, new a.a(6, -1, ".ui.LuckyMoneyIndexUI", "luckymoney", ""));
    qDW.put(41, new a.a(41, -1, ".ui.WalletOfflineEntranceUI", "offline", ""));
    qDW.put(42, new a.a(42, -1, ".ui.CollectAdapterUI", "collect", ""));
    qDW.put(40, new a.a(40, -1, ".balance.ui.WalletBalanceManagerUI", "wallet", ""));
    qDW.put(43, new a.a(43, -1, ".ui.chatting.ChattingUI", "", "gh_43f2581f6fd6"));
    qDW.put(50, new a.a(50, -1, ".ui.conversation.BizConversationUI", "app", ""));
    qDW.put(51, new a.a(51, -1, ".ui.setting.SettingsPrivacyUI", "setting", ""));
    qDW.put(66, new a.a(66, -1, ".ui.AppBrandLauncherUI", "appbrand", ""));
    qDW.put(63, new a.a(63, -1, ".ui.conversation.BizConversationUI", "app", ""));
    qDW.put(64, new a.a(64, -1, ".plugin.setting.ui.fixtools.FixToolsUI", "app", ""));
    qDW.put(65, new a.a(65, -1, "", "", ""));
    qDW.put(67, new a.a(67, -1, ".plugin.brandservice.ui.timeline.BizTimeLineUI", "app", ""));
    AppMethodBeat.o(24402);
  }
  
  public static boolean W(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(24401);
    if (qDW.indexOfKey(paramInt) < 0)
    {
      AppMethodBeat.o(24401);
      return false;
    }
    if ((paramInt == 30) && ((com.tencent.mm.r.a.bN(paramContext)) || (com.tencent.mm.r.a.bM(paramContext))))
    {
      AppMethodBeat.o(24401);
      return false;
    }
    Object localObject = (a.a)qDW.get(paramInt);
    boolean bool;
    if ((((a.a)localObject).qDX != -1) && ((r.Zy() & ((a.a)localObject).qDX) != 0))
    {
      bool = aQ(paramContext, ((a.a)localObject).username);
      AppMethodBeat.o(24401);
      return bool;
    }
    Intent localIntent;
    if (!bo.isNullOrNil(((a.a)localObject).qDY))
    {
      localIntent = new Intent();
      if (paramInt == 28) {
        localIntent.putExtra("type", 20);
      }
      if (paramInt == 1) {
        localIntent.putExtra("key_native_url", "wxpay://bizmall/mobile_recharge");
      }
      localIntent.putExtra("animation_pop_in", ((a.a)localObject).qDZ);
      if (paramInt == 32) {
        h.qsU.e(12065, new Object[] { Integer.valueOf(6) });
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
      if (paramInt == 33) {
        com.tencent.mm.plugin.fav.a.b.b(paramContext, ".ui.FavoriteIndexUI", new Intent());
      }
      for (;;)
      {
        com.tencent.mm.ui.base.b.K(paramContext, localIntent);
        AppMethodBeat.o(24401);
        return true;
        if (paramInt == 35)
        {
          localIntent.setClassName(paramContext, "com.tencent.mm.plugin.backup.backupmoveui.BackupUI");
          MMWizardActivity.J(paramContext, localIntent);
        }
        else if (paramInt == 66)
        {
          ((l)g.E(l.class)).c(paramContext, 16, false);
        }
        else if (!((a.a)localObject).qDY.equals("app"))
        {
          com.tencent.mm.bq.d.b(paramContext, ((a.a)localObject).qDY, ((a.a)localObject).uri, localIntent);
        }
        else
        {
          com.tencent.mm.bq.d.f(paramContext, ((a.a)localObject).uri, localIntent);
        }
      }
    }
    if (paramInt == 65)
    {
      com.tencent.mm.plugin.topstory.ui.d.Y(paramContext, 21);
      AppMethodBeat.o(24401);
      return true;
    }
    if (((a.a)localObject).uri.equals(".ui.chatting.ChattingUI"))
    {
      localObject = ((a.a)localObject).username;
      if (com.tencent.mm.n.a.je(((j)g.E(j.class)).YA().arw((String)localObject).field_type))
      {
        localIntent = new Intent();
        localIntent.putExtra("Chat_User", (String)localObject);
        localIntent.putExtra("finish_direct", true);
        com.tencent.mm.bq.d.f(paramContext, ".ui.chatting.ChattingUI", localIntent);
      }
      for (;;)
      {
        AppMethodBeat.o(24401);
        return true;
        aQ(paramContext, (String)localObject);
      }
    }
    if (((a.a)localObject).uri.equals(".plugin.profile.ui.ContactInfoUI"))
    {
      bool = aQ(paramContext, ((a.a)localObject).username);
      AppMethodBeat.o(24401);
      return bool;
    }
    ab.e("MicroMsg.Feature", "Error URI of android feature");
    AppMethodBeat.o(24401);
    return false;
  }
  
  private static boolean aQ(Context paramContext, String paramString)
  {
    AppMethodBeat.i(24400);
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", paramString);
    com.tencent.mm.bq.d.b(paramContext, "profile", ".ui.ContactInfoUI", localIntent);
    AppMethodBeat.o(24400);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.search.a.a
 * JD-Core Version:    0.7.0.1
 */