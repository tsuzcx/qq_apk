package com.tencent.mm.plugin.search.a;

import android.content.Context;
import android.content.Intent;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.az;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.appbrand.service.g.a;
import com.tencent.mm.plugin.appbrand.service.p;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
import com.tencent.mm.ui.MMWizardActivity;
import java.util.List;

public final class a
{
  public static final SparseArray<a> xns;
  
  static
  {
    AppMethodBeat.i(28069);
    SparseArray localSparseArray = new SparseArray();
    xns = localSparseArray;
    localSparseArray.put(19, new a(19, -1, ".ui.SnsTimeLineUI", "sns", ""));
    xns.put(30, new a(19, -1, ".ui.BaseScanUI", "scanner", "", (byte)0));
    xns.put(18, new a(18, -1, ".ui.ShakeReportUI", "shake", ""));
    xns.put(17, new a(17, -1, ".ui.NearbyFriendsIntroUI", "nearby", ""));
    xns.put(16, new a(16, -1, ".ui.BottleBeachUI", "bottle", ""));
    xns.put(31, new a(31, -1, ".ui.GameCenterUI", "game", ""));
    xns.put(20, new a(20, -1, ".plugin.profile.ui.ContactInfoUI", "", "voiceinputapp"));
    xns.put(21, new a(21, -1, ".plugin.profile.ui.ContactInfoUI", "", "linkedinplugin"));
    xns.put(26, new a(26, -1, ".plugin.profile.ui.ContactInfoUI", "", "qqfriend"));
    xns.put(29, new a(29, -1, ".plugin.profile.ui.ContactInfoUI", "", "voipapp"));
    xns.put(23, new a(23, 1, ".ui.chatting.ChattingUI", "", "qqmail"));
    xns.put(1, new a(1, -1, ".ui.MallIndexUI", "mall", ""));
    xns.put(24, new a(24, 8, ".ui.chatting.ChattingUI", "", "weibo"));
    xns.put(27, new a(27, 65536, ".ui.MassSendHistoryUI", "masssend", "masssendapp"));
    xns.put(28, new a(28, 524288, ".ui.ReaderAppUI", "readerapp", "newsapp"));
    xns.put(32, new a(32, -1, ".ui.v2.EmojiStoreV2UI", "emoji", ""));
    xns.put(33, new a(33, -1, ".ui.FavoriteIndexUI", "favorite", ""));
    xns.put(34, new a(34, -1, ".ui.MallIndexUI", "mall", ""));
    xns.put(35, new a(35, -1, ".backupmoveui.BackupUI", "backup", ""));
    xns.put(38, new a(38, 16, ".ui.chatting.ChattingUI", "", "medianote"));
    xns.put(39, new a(39, -1, ".ui.chatting.ChattingUI", "", "filehelper"));
    xns.put(6, new a(6, -1, ".ui.LuckyMoneyIndexUI", "luckymoney", ""));
    xns.put(41, new a(41, -1, ".ui.WalletOfflineEntranceUI", "offline", ""));
    xns.put(42, new a(42, -1, ".ui.CollectAdapterUI", "collect", ""));
    xns.put(40, new a(40, -1, ".balance.ui.WalletBalanceManagerUI", "wallet", ""));
    xns.put(43, new a(43, -1, ".ui.chatting.ChattingUI", "", "gh_43f2581f6fd6"));
    xns.put(50, new a(50, -1, ".ui.conversation.BizConversationUI", "app", ""));
    xns.put(51, new a(51, -1, ".ui.setting.SettingsPrivacyUI", "setting", ""));
    xns.put(66, new a(66, -1, ".ui.AppBrandLauncherUI", "appbrand", ""));
    xns.put(63, new a(63, -1, ".ui.conversation.BizConversationUI", "app", ""));
    xns.put(64, new a(64, -1, ".plugin.setting.ui.fixtools.FixToolsUI", "app", ""));
    xns.put(65, new a(65, -1, "", "", ""));
    xns.put(67, new a(67, -1, ".plugin.brandservice.ui.timeline.BizTimeLineUI", "app", ""));
    xns.put(68, new a(68, -1, ".ui.chatting.ChattingUI", "", "gh_3dfda90e39d6"));
    xns.put(69, new a(69, -1, ".ui.conversation.AppBrandServiceConversationUI", "app", ""));
    xns.put(70, new a(70, -1, ".ui.chatting.ChattingUI", "", "gh_f0a92aa7146c"));
    xns.put(71, new a(71, -1, ".ui.chatting.ChattingUI", "", "appbrand_notify_message"));
    AppMethodBeat.o(28069);
  }
  
  private static boolean aZ(Context paramContext, String paramString)
  {
    AppMethodBeat.i(28067);
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", paramString);
    com.tencent.mm.br.d.b(paramContext, "profile", ".ui.ContactInfoUI", localIntent);
    AppMethodBeat.o(28067);
    return true;
  }
  
  public static boolean ae(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(28068);
    if (xns.indexOfKey(paramInt) < 0)
    {
      AppMethodBeat.o(28068);
      return false;
    }
    if ((paramInt == 30) && ((com.tencent.mm.r.a.cg(paramContext)) || (com.tencent.mm.r.a.cf(paramContext)) || (com.tencent.mm.r.a.ck(paramContext))))
    {
      AppMethodBeat.o(28068);
      return false;
    }
    Object localObject1 = (a)xns.get(paramInt);
    boolean bool;
    if ((((a)localObject1).xnt != -1) && ((u.axI() & ((a)localObject1).xnt) != 0))
    {
      bool = aZ(paramContext, ((a)localObject1).username);
      AppMethodBeat.o(28068);
      return bool;
    }
    Object localObject2;
    if (!bs.isNullOrNil(((a)localObject1).slI))
    {
      localObject2 = new Intent();
      if (paramInt == 28) {
        ((Intent)localObject2).putExtra("type", 20);
      }
      if (paramInt == 1) {
        ((Intent)localObject2).putExtra("key_native_url", "wxpay://bizmall/mobile_recharge");
      }
      ((Intent)localObject2).putExtra("animation_pop_in", ((a)localObject1).xnu);
      if (paramInt == 32) {
        h.wUl.f(12065, new Object[] { Integer.valueOf(6) });
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
        com.tencent.mm.ui.base.b.ak(paramContext, (Intent)localObject2);
        AppMethodBeat.o(28068);
        return true;
        if (paramInt == 35)
        {
          ((Intent)localObject2).setClassName(paramContext, "com.tencent.mm.plugin.backup.backupmoveui.BackupUI");
          MMWizardActivity.aj(paramContext, (Intent)localObject2);
        }
        else if (paramInt == 66)
        {
          ((p)com.tencent.mm.kernel.g.ab(p.class)).G(paramContext, 16);
        }
        else if (!((a)localObject1).slI.equals("app"))
        {
          com.tencent.mm.br.d.b(paramContext, ((a)localObject1).slI, ((a)localObject1).uri, (Intent)localObject2);
        }
        else
        {
          com.tencent.mm.br.d.e(paramContext, ((a)localObject1).uri, (Intent)localObject2);
        }
      }
    }
    if (paramInt == 65)
    {
      com.tencent.mm.plugin.topstory.ui.d.ag(paramContext, 21);
      AppMethodBeat.o(28068);
      return true;
    }
    if (paramInt == 71)
    {
      localObject2 = ((k)com.tencent.mm.kernel.g.ab(k.class)).awG();
      if (localObject2 != null)
      {
        List localList = ((bk)localObject2).faM();
        paramInt = 0;
        if (paramInt >= localList.size()) {
          break label795;
        }
        if (!"appbrand_notify_message".equals((String)localList.get(paramInt))) {
          break label725;
        }
      }
    }
    for (;;)
    {
      localObject2 = ((bk)localObject2).aNI("appbrand_notify_message");
      if (localObject2 != null) {}
      for (int i = ((az)localObject2).field_unReadCount;; i = 0)
      {
        localObject2 = (com.tencent.mm.plugin.appbrand.service.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.g.class);
        com.tencent.mm.kernel.g.agP();
        ((com.tencent.mm.plugin.appbrand.service.g)localObject2).HF(bs.nullAsNil(String.valueOf(com.tencent.mm.kernel.a.getUin())));
        ((com.tencent.mm.plugin.appbrand.service.g)localObject2).a(new g.a(i, paramInt + 1));
        if (((a)localObject1).uri.equals(".ui.chatting.ChattingUI"))
        {
          localObject1 = ((a)localObject1).username;
          if (com.tencent.mm.n.b.ln(((k)com.tencent.mm.kernel.g.ab(k.class)).awB().aNt((String)localObject1).field_type))
          {
            localObject2 = new Intent();
            ((Intent)localObject2).putExtra("Chat_User", (String)localObject1);
            ((Intent)localObject2).putExtra("finish_direct", true);
            com.tencent.mm.br.d.e(paramContext, ".ui.chatting.ChattingUI", (Intent)localObject2);
          }
          for (;;)
          {
            AppMethodBeat.o(28068);
            return true;
            label725:
            paramInt += 1;
            break;
            aZ(paramContext, (String)localObject1);
          }
        }
        if (((a)localObject1).uri.equals(".plugin.profile.ui.ContactInfoUI"))
        {
          bool = aZ(paramContext, ((a)localObject1).username);
          AppMethodBeat.o(28068);
          return bool;
        }
        ac.e("MicroMsg.Feature", "Error URI of android feature");
        AppMethodBeat.o(28068);
        return false;
      }
      label795:
      paramInt = 0;
    }
  }
  
  static final class a
  {
    int id;
    String slI;
    String uri;
    String username;
    int xnt;
    boolean xnu;
    
    public a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
    {
      this(paramInt1, paramInt2, paramString1, paramString2, paramString3, (byte)0);
    }
    
    public a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, byte paramByte)
    {
      this.id = paramInt1;
      this.xnt = paramInt2;
      this.uri = paramString1;
      this.slI = paramString2;
      this.username = paramString3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.search.a.a
 * JD-Core Version:    0.7.0.1
 */