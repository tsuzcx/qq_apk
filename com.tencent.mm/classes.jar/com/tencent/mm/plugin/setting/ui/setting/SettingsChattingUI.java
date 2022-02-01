package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.sq;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.bp.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.wallet.d;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SettingsChattingUI
  extends MMPreference
{
  private ProgressDialog Dav = null;
  private boolean isDeleteCancel = false;
  private f screen;
  
  public int getResourceId()
  {
    return 2132017271;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74147);
    setMMTitle(2131765363);
    this.screen = getPreferenceScreen();
    if (g.aAh().azQ().getInt(89, 0) != 2) {
      this.screen.bmi("settings_recovery");
    }
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(74139);
        SettingsChattingUI.this.hideVKB();
        SettingsChattingUI.this.finish();
        AppMethodBeat.o(74139);
        return true;
      }
    });
    AppMethodBeat.o(74147);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74146);
    super.onCreate(paramBundle);
    if (!g.aAf().azp())
    {
      finish();
      AppMethodBeat.o(74146);
      return;
    }
    initView();
    AppMethodBeat.o(74146);
  }
  
  public boolean onPreferenceTreeClick(final f paramf, Preference paramPreference)
  {
    boolean bool2 = false;
    AppMethodBeat.i(74149);
    paramf = paramPreference.mKey;
    int i = -1;
    switch (paramf.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(74149);
        return false;
        if (paramf.equals("settings_voice_play_mode"))
        {
          i = 0;
          continue;
          if (paramf.equals("settings_enter_button_send"))
          {
            i = 1;
            continue;
            if (paramf.equals("settings_bak_chat"))
            {
              i = 2;
              continue;
              if (paramf.equals("settings_chatting_bg"))
              {
                i = 3;
                continue;
                if (paramf.equals("settings_emoji_manager"))
                {
                  i = 4;
                  continue;
                  if (paramf.equals("settings_reset"))
                  {
                    i = 5;
                    continue;
                    if (paramf.equals("settings_recovery")) {
                      i = 6;
                    }
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    boolean bool3 = ((Boolean)g.aAh().azQ().get(26, Boolean.FALSE)).booleanValue();
    if (!bool3) {}
    for (final boolean bool1 = true;; bool1 = false)
    {
      Log.d("MicroMsg.SettingsChattingUI", "set voice mode from %B to %B", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool1) });
      paramf = g.aAh().azQ();
      bool1 = bool2;
      if (!bool3) {
        bool1 = true;
      }
      paramf.set(26, Boolean.valueOf(bool1));
      AppMethodBeat.o(74149);
      return true;
    }
    paramf = (CheckBoxPreference)this.screen.bmg("settings_enter_button_send");
    if (paramf != null)
    {
      bool1 = paramf.isChecked();
      if (!bool1) {
        break label415;
      }
      paramPreference = new f.a(getContext());
      paramPreference.bow(getResources().getString(2131765386));
      paramPreference.c(new f.c()
      {
        public final void e(boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          AppMethodBeat.i(256524);
          if (paramAnonymousBoolean)
          {
            Log.d("MicroMsg.SettingsChattingUI", "set enter button send : %s", new Object[] { Boolean.valueOf(bool1) });
            g.aAh().azQ().set(66832, Boolean.valueOf(bool1));
            AppMethodBeat.o(256524);
            return;
          }
          paramf.setChecked(false);
          SettingsChattingUI.d(SettingsChattingUI.this).notifyDataSetChanged();
          AppMethodBeat.o(256524);
        }
      }).show();
    }
    for (;;)
    {
      AppMethodBeat.o(74149);
      return true;
      label415:
      Log.d("MicroMsg.SettingsChattingUI", "set enter button send : %s", new Object[] { Boolean.valueOf(bool1) });
      g.aAh().azQ().set(66832, Boolean.valueOf(bool1));
    }
    paramf = new Intent().setClassName(getContext(), "com.tencent.mm.plugin.backup.backupui.BackupChooseBackupModeUI");
    paramf = new com.tencent.mm.hellhoundlib.b.a().bl(paramf);
    com.tencent.mm.hellhoundlib.a.a.a(this, paramf.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsChattingUI", "goToBackup", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramf.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsChattingUI", "goToBackup", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(74149);
    return true;
    paramPreference = new Intent();
    paramPreference.setClass(this, SettingsChattingBackgroundUI.class);
    paramf = getContext();
    paramPreference = new com.tencent.mm.hellhoundlib.b.a().bl(paramPreference);
    com.tencent.mm.hellhoundlib.a.a.a(paramf, paramPreference.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsChattingUI", "goTosetChattingBackground", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramf.startActivity((Intent)paramPreference.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramf, "com/tencent/mm/plugin/setting/ui/setting/SettingsChattingUI", "goTosetChattingBackground", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(74149);
    return true;
    paramf = new Intent();
    paramf.putExtra("10931", 2);
    com.tencent.mm.br.c.b(getContext(), "emoji", ".ui.EmojiMineUI", paramf);
    AppMethodBeat.o(74149);
    return true;
    com.tencent.mm.ui.base.h.c(getContext(), getResources().getString(2131765566), "", getString(2131755764), getString(2131755761), new DialogInterface.OnClickListener()
    {
      public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(74143);
        com.tencent.mm.plugin.report.service.h.CyF.a(14553, new Object[] { Integer.valueOf(5), Integer.valueOf(2), "" });
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(324L, 0L, 1L, false);
        SettingsChattingUI.a(SettingsChattingUI.this, false);
        paramAnonymousDialogInterface = SettingsChattingUI.this;
        Object localObject = SettingsChattingUI.this;
        SettingsChattingUI.this.getString(2131755998);
        SettingsChattingUI.a(paramAnonymousDialogInterface, com.tencent.mm.ui.base.h.a((Context)localObject, SettingsChattingUI.this.getString(2131756029), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(74140);
            SettingsChattingUI.a(SettingsChattingUI.this, true);
            AppMethodBeat.o(74140);
          }
        }));
        paramAnonymousDialogInterface = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().eiQ();
        if (paramAnonymousDialogInterface != null)
        {
          Log.i("MicroMsg.WalletConvDelCheckLogic", "checkGetUnProcessorWalletConversation, msgInfoList size: %s", new Object[] { Integer.valueOf(paramAnonymousDialogInterface.size()) });
          localObject = new HashSet();
          paramAnonymousDialogInterface = paramAnonymousDialogInterface.iterator();
          while (paramAnonymousDialogInterface.hasNext())
          {
            ca localca = (ca)paramAnonymousDialogInterface.next();
            if ((!((Set)localObject).contains(localca.field_talker)) && (((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().bjY(localca.field_talker) != null) && (d.aU(localca))) {
              ((Set)localObject).add(localca.field_talker);
            }
          }
          paramAnonymousDialogInterface = new ArrayList();
          paramAnonymousDialogInterface.addAll((Collection)localObject);
        }
        while ((paramAnonymousDialogInterface != null) && (paramAnonymousDialogInterface.size() > 0))
        {
          SettingsChattingUI.a(SettingsChattingUI.this).dismiss();
          com.tencent.mm.ui.base.h.a(SettingsChattingUI.this, false, SettingsChattingUI.this.getString(2131767656, new Object[] { Integer.valueOf(paramAnonymousDialogInterface.size()) }), null, SettingsChattingUI.this.getString(2131761460), SettingsChattingUI.this.getString(2131757642), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(74141);
              com.tencent.mm.plugin.report.service.h.CyF.a(14553, new Object[] { Integer.valueOf(5), Integer.valueOf(4), "" });
              SettingsChattingUI.a(SettingsChattingUI.this, true);
              if (paramAnonymousDialogInterface.size() <= 1)
              {
                paramAnonymous2DialogInterface = new Intent();
                paramAnonymous2DialogInterface.putExtra("Chat_User", (String)paramAnonymousDialogInterface.get(0));
                paramAnonymous2DialogInterface.addFlags(67108864);
                com.tencent.mm.br.c.f(SettingsChattingUI.this, ".ui.chatting.ChattingUI", paramAnonymous2DialogInterface);
                AppMethodBeat.o(74141);
                return;
              }
              paramAnonymous2DialogInterface = new Intent();
              paramAnonymous2DialogInterface.putStringArrayListExtra("key_conversation_list", paramAnonymousDialogInterface);
              com.tencent.mm.br.c.f(SettingsChattingUI.this, ".ui.conversation.SettingCheckUnProcessWalletConvUI", paramAnonymous2DialogInterface);
              AppMethodBeat.o(74141);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(74142);
              com.tencent.mm.plugin.report.service.h.CyF.a(14553, new Object[] { Integer.valueOf(5), Integer.valueOf(3), "" });
              SettingsChattingUI.a(SettingsChattingUI.this).show();
              SettingsChattingUI.a(SettingsChattingUI.this, false);
              SettingsChattingUI.b(SettingsChattingUI.this);
              AppMethodBeat.o(74142);
            }
          }, -1, 2131099922);
          AppMethodBeat.o(74143);
          return;
          paramAnonymousDialogInterface = null;
        }
        SettingsChattingUI.b(SettingsChattingUI.this);
        AppMethodBeat.o(74143);
      }
    }, null);
    AppMethodBeat.o(74149);
    return true;
    paramPreference = new Intent().setClassName(getContext(), "com.tencent.mm.plugin.dbbackup.DBRecoveryUI");
    paramPreference.putExtra("scene", 1);
    paramf = getContext();
    paramPreference = new com.tencent.mm.hellhoundlib.b.a().bl(paramPreference);
    com.tencent.mm.hellhoundlib.a.a.a(paramf, paramPreference.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsChattingUI", "goToRecovery", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramf.startActivity((Intent)paramPreference.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramf, "com/tencent/mm/plugin/setting/ui/setting/SettingsChattingUI", "goToRecovery", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(74149);
    return true;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74148);
    super.onResume();
    CheckBoxPreference localCheckBoxPreference = (CheckBoxPreference)this.screen.bmg("settings_voice_play_mode");
    if (localCheckBoxPreference != null)
    {
      localCheckBoxPreference.setChecked(((Boolean)g.aAh().azQ().get(26, Boolean.FALSE)).booleanValue());
      localCheckBoxPreference.OZw = false;
    }
    localCheckBoxPreference = (CheckBoxPreference)this.screen.bmg("settings_enter_button_send");
    if (localCheckBoxPreference != null)
    {
      localCheckBoxPreference.setChecked(((Boolean)g.aAh().azQ().get(66832, Boolean.FALSE)).booleanValue());
      localCheckBoxPreference.OZw = false;
    }
    AppMethodBeat.o(74148);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsChattingUI
 * JD-Core Version:    0.7.0.1
 */