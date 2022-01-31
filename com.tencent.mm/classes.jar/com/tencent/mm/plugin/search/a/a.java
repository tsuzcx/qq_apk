package com.tencent.mm.plugin.search.a;

import android.content.Context;
import android.content.Intent;
import android.util.SparseArray;
import com.tencent.mm.br.d;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMWizardActivity;

public final class a
{
  public static final SparseArray<a.a> nPZ;
  
  static
  {
    SparseArray localSparseArray = new SparseArray();
    nPZ = localSparseArray;
    localSparseArray.put(19, new a.a(19, -1, ".ui.SnsTimeLineUI", "sns", ""));
    nPZ.put(30, new a.a(19, -1, ".ui.BaseScanUI", "scanner", "", (byte)0));
    nPZ.put(18, new a.a(18, -1, ".ui.ShakeReportUI", "shake", ""));
    nPZ.put(17, new a.a(17, -1, ".ui.NearbyFriendsIntroUI", "nearby", ""));
    nPZ.put(16, new a.a(16, -1, ".ui.BottleBeachUI", "bottle", ""));
    nPZ.put(31, new a.a(31, -1, ".ui.GameCenterUI", "game", ""));
    nPZ.put(20, new a.a(20, -1, ".plugin.profile.ui.ContactInfoUI", "", "voiceinputapp"));
    nPZ.put(21, new a.a(21, -1, ".plugin.profile.ui.ContactInfoUI", "", "linkedinplugin"));
    nPZ.put(26, new a.a(26, -1, ".plugin.profile.ui.ContactInfoUI", "", "qqfriend"));
    nPZ.put(29, new a.a(29, -1, ".plugin.profile.ui.ContactInfoUI", "", "voipapp"));
    nPZ.put(23, new a.a(23, 1, ".ui.chatting.ChattingUI", "", "qqmail"));
    nPZ.put(1, new a.a(1, -1, ".ui.MallIndexUI", "mall", ""));
    nPZ.put(24, new a.a(24, 8, ".ui.chatting.ChattingUI", "", "weibo"));
    nPZ.put(27, new a.a(27, 65536, ".ui.MassSendHistoryUI", "masssend", "masssendapp"));
    nPZ.put(28, new a.a(28, 524288, ".ui.ReaderAppUI", "readerapp", "newsapp"));
    nPZ.put(32, new a.a(32, -1, ".ui.v2.EmojiStoreV2UI", "emoji", ""));
    nPZ.put(33, new a.a(33, -1, ".ui.FavoriteIndexUI", "favorite", ""));
    nPZ.put(34, new a.a(34, -1, ".ui.MallIndexUI", "mall", ""));
    nPZ.put(35, new a.a(35, -1, ".backupmoveui.BackupUI", "backup", ""));
    nPZ.put(38, new a.a(38, 16, ".ui.chatting.ChattingUI", "", "medianote"));
    nPZ.put(39, new a.a(39, -1, ".ui.chatting.ChattingUI", "", "filehelper"));
    nPZ.put(6, new a.a(6, -1, ".ui.LuckyMoneyIndexUI", "luckymoney", ""));
    nPZ.put(41, new a.a(41, -1, ".ui.WalletOfflineEntranceUI", "offline", ""));
    nPZ.put(42, new a.a(42, -1, ".ui.CollectAdapterUI", "collect", ""));
    nPZ.put(40, new a.a(40, -1, ".balance.ui.WalletBalanceManagerUI", "wallet", ""));
    nPZ.put(43, new a.a(43, -1, ".ui.chatting.ChattingUI", "", "gh_43f2581f6fd6"));
    nPZ.put(50, new a.a(50, -1, ".ui.conversation.BizConversationUI", "app", ""));
    nPZ.put(51, new a.a(51, -1, ".ui.setting.SettingsPrivacyUI", "setting", ""));
  }
  
  public static boolean J(Context paramContext, int paramInt)
  {
    if (nPZ.indexOfKey(paramInt) < 0) {
      return false;
    }
    if ((paramInt == 30) && ((com.tencent.mm.r.a.bj(paramContext)) || (com.tencent.mm.r.a.bi(paramContext)))) {
      return false;
    }
    Object localObject = (a.a)nPZ.get(paramInt);
    if ((((a.a)localObject).nQa != -1) && ((q.Gu() & ((a.a)localObject).nQa) != 0)) {
      return aH(paramContext, ((a.a)localObject).username);
    }
    Intent localIntent;
    if (!bk.bl(((a.a)localObject).nQb))
    {
      localIntent = new Intent();
      if (paramInt == 28) {
        localIntent.putExtra("type", 20);
      }
      if (paramInt == 1) {
        localIntent.putExtra("key_native_url", "wxpay://bizmall/mobile_recharge");
      }
      localIntent.putExtra("animation_pop_in", ((a.a)localObject).nQc);
      if (paramInt == 32) {
        h.nFQ.f(12065, new Object[] { Integer.valueOf(6) });
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
      if (paramInt == 33) {
        com.tencent.mm.plugin.fav.a.b.a(paramContext, ".ui.FavoriteIndexUI", new Intent());
      }
      for (;;)
      {
        com.tencent.mm.ui.base.b.D(paramContext, localIntent);
        return true;
        if (paramInt == 35)
        {
          localIntent.setClassName(paramContext, "com.tencent.mm.plugin.backup.backupmoveui.BackupUI");
          MMWizardActivity.C(paramContext, localIntent);
        }
        else if (!((a.a)localObject).nQb.equals("app"))
        {
          d.b(paramContext, ((a.a)localObject).nQb, ((a.a)localObject).uri, localIntent);
        }
        else
        {
          d.e(paramContext, ((a.a)localObject).uri, localIntent);
        }
      }
    }
    if (((a.a)localObject).uri.equals(".ui.chatting.ChattingUI"))
    {
      localObject = ((a.a)localObject).username;
      if (com.tencent.mm.n.a.gR(((j)g.r(j.class)).Fw().abl((String)localObject).field_type))
      {
        localIntent = new Intent();
        localIntent.putExtra("Chat_User", (String)localObject);
        localIntent.putExtra("finish_direct", true);
        d.e(paramContext, ".ui.chatting.ChattingUI", localIntent);
      }
      for (;;)
      {
        return true;
        aH(paramContext, (String)localObject);
      }
    }
    if (((a.a)localObject).uri.equals(".plugin.profile.ui.ContactInfoUI")) {
      return aH(paramContext, ((a.a)localObject).username);
    }
    y.e("MicroMsg.Feature", "Error URI of android feature");
    return false;
  }
  
  private static boolean aH(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", paramString);
    d.b(paramContext, "profile", ".ui.ContactInfoUI", localIntent);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.search.a.a
 * JD-Core Version:    0.7.0.1
 */