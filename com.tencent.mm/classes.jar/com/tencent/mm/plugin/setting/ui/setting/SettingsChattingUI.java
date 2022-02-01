package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.vg;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.br;
import com.tencent.mm.model.br.a;
import com.tencent.mm.model.u;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.x;
import com.tencent.mm.plugin.setting.b.c;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.b.k;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.wallet.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.a.g.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SettingsChattingUI
  extends MMPreference
{
  private ProgressDialog PqL = null;
  private boolean isDeleteCancel = false;
  private com.tencent.mm.ui.base.preference.f screen;
  
  public int getResourceId()
  {
    return b.k.settings_pref_chatting;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74147);
    setMMTitle(b.i.settings_chatting);
    this.screen = getPreferenceScreen();
    if (com.tencent.mm.kernel.h.baE().ban().getInt(89, 0) != 2) {
      this.screen.bAk("settings_recovery");
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
    if (!com.tencent.mm.kernel.h.baC().aZN())
    {
      finish();
      AppMethodBeat.o(74146);
      return;
    }
    initView();
    AppMethodBeat.o(74146);
  }
  
  public boolean onPreferenceTreeClick(final com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
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
    boolean bool3 = ((Boolean)com.tencent.mm.kernel.h.baE().ban().d(26, Boolean.FALSE)).booleanValue();
    if (!bool3) {}
    for (final boolean bool1 = true;; bool1 = false)
    {
      Log.d("MicroMsg.SettingsChattingUI", "set voice mode from %B to %B", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool1) });
      paramf = com.tencent.mm.kernel.h.baE().ban();
      bool1 = bool2;
      if (!bool3) {
        bool1 = true;
      }
      paramf.B(26, Boolean.valueOf(bool1));
      AppMethodBeat.o(74149);
      return true;
    }
    paramf = (CheckBoxPreference)this.screen.bAi("settings_enter_button_send");
    if (paramf != null)
    {
      bool1 = paramf.isChecked();
      if (!bool1) {
        break label416;
      }
      paramPreference = new g.a(getContext());
      paramPreference.bDE(getResources().getString(b.i.settings_enter_button_send_alert));
      paramPreference.c(new g.c()
      {
        public final void onDialogClick(boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          AppMethodBeat.i(298737);
          if (paramAnonymousBoolean)
          {
            Log.d("MicroMsg.SettingsChattingUI", "set enter button send : %s", new Object[] { Boolean.valueOf(bool1) });
            com.tencent.mm.kernel.h.baE().ban().B(66832, Boolean.valueOf(bool1));
            AppMethodBeat.o(298737);
            return;
          }
          paramf.setChecked(false);
          SettingsChattingUI.d(SettingsChattingUI.this).notifyDataSetChanged();
          AppMethodBeat.o(298737);
        }
      }).show();
    }
    for (;;)
    {
      AppMethodBeat.o(74149);
      return true;
      label416:
      Log.d("MicroMsg.SettingsChattingUI", "set enter button send : %s", new Object[] { Boolean.valueOf(bool1) });
      com.tencent.mm.kernel.h.baE().ban().B(66832, Boolean.valueOf(bool1));
    }
    paramf = new Intent().setClassName(getContext(), "com.tencent.mm.plugin.backup.backupui.BackupChooseBackupModeUI");
    paramf = new com.tencent.mm.hellhoundlib.b.a().cG(paramf);
    com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aYi(), "com/tencent/mm/plugin/setting/ui/setting/SettingsChattingUI", "goToBackup", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramf.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsChattingUI", "goToBackup", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(74149);
    return true;
    paramPreference = new Intent();
    paramPreference.setClass(this, SettingsChattingBackgroundUI.class);
    paramf = getContext();
    paramPreference = new com.tencent.mm.hellhoundlib.b.a().cG(paramPreference);
    com.tencent.mm.hellhoundlib.a.a.b(paramf, paramPreference.aYi(), "com/tencent/mm/plugin/setting/ui/setting/SettingsChattingUI", "goTosetChattingBackground", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramf.startActivity((Intent)paramPreference.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramf, "com/tencent/mm/plugin/setting/ui/setting/SettingsChattingUI", "goTosetChattingBackground", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(74149);
    return true;
    paramf = new Intent();
    paramf.putExtra("10931", 2);
    com.tencent.mm.br.c.b(getContext(), "emoji", ".ui.EmojiMineUI", paramf);
    AppMethodBeat.o(74149);
    return true;
    k.a(getContext(), getResources().getString(b.i.settings_reset_warning), "", getString(b.i.app_clear), getString(b.i.app_cancel), new DialogInterface.OnClickListener()
    {
      public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(74143);
        com.tencent.mm.plugin.report.service.h.OAn.b(14553, new Object[] { Integer.valueOf(5), Integer.valueOf(2), "" });
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(324L, 0L, 1L, false);
        SettingsChattingUI.a(SettingsChattingUI.this, false);
        paramAnonymousDialogInterface = SettingsChattingUI.this;
        Object localObject = SettingsChattingUI.this;
        SettingsChattingUI.this.getString(b.i.app_tip);
        SettingsChattingUI.a(paramAnonymousDialogInterface, k.a((Context)localObject, SettingsChattingUI.this.getString(b.i.app_waiting), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(74140);
            SettingsChattingUI.a(SettingsChattingUI.this, true);
            AppMethodBeat.o(74140);
          }
        }));
        paramAnonymousDialogInterface = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().gbr();
        if (paramAnonymousDialogInterface != null)
        {
          Log.i("MicroMsg.WalletConvDelCheckLogic", "checkGetUnProcessorWalletConversation, msgInfoList size: %s", new Object[] { Integer.valueOf(paramAnonymousDialogInterface.size()) });
          localObject = new HashSet();
          paramAnonymousDialogInterface = paramAnonymousDialogInterface.iterator();
          while (paramAnonymousDialogInterface.hasNext())
          {
            cc localcc = (cc)paramAnonymousDialogInterface.next();
            if ((!((Set)localObject).contains(localcc.field_talker)) && (((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().bxM(localcc.field_talker) != null) && (d.bD(localcc))) {
              ((Set)localObject).add(localcc.field_talker);
            }
          }
          paramAnonymousDialogInterface = new ArrayList();
          paramAnonymousDialogInterface.addAll((Collection)localObject);
        }
        while ((paramAnonymousDialogInterface != null) && (paramAnonymousDialogInterface.size() > 0))
        {
          SettingsChattingUI.a(SettingsChattingUI.this).dismiss();
          k.a(SettingsChattingUI.this, false, SettingsChattingUI.this.getString(b.i.wallet_clearall_conversation_note, new Object[] { Integer.valueOf(paramAnonymousDialogInterface.size()) }), null, SettingsChattingUI.this.getString(b.i.goto_conversation), SettingsChattingUI.this.getString(b.i.clearall_conversation), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(74141);
              com.tencent.mm.plugin.report.service.h.OAn.b(14553, new Object[] { Integer.valueOf(5), Integer.valueOf(4), "" });
              SettingsChattingUI.a(SettingsChattingUI.this, true);
              if (paramAnonymousDialogInterface.size() <= 1)
              {
                paramAnonymous2DialogInterface = new Intent();
                paramAnonymous2DialogInterface.putExtra("Chat_User", (String)paramAnonymousDialogInterface.get(0));
                paramAnonymous2DialogInterface.addFlags(67108864);
                com.tencent.mm.br.c.g(SettingsChattingUI.this, ".ui.chatting.ChattingUI", paramAnonymous2DialogInterface);
                AppMethodBeat.o(74141);
                return;
              }
              paramAnonymous2DialogInterface = new Intent();
              paramAnonymous2DialogInterface.putStringArrayListExtra("key_conversation_list", paramAnonymousDialogInterface);
              com.tencent.mm.br.c.g(SettingsChattingUI.this, ".ui.conversation.SettingCheckUnProcessWalletConvUI", paramAnonymous2DialogInterface);
              AppMethodBeat.o(74141);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(74142);
              com.tencent.mm.plugin.report.service.h.OAn.b(14553, new Object[] { Integer.valueOf(5), Integer.valueOf(3), "" });
              SettingsChattingUI.a(SettingsChattingUI.this).show();
              SettingsChattingUI.a(SettingsChattingUI.this, false);
              SettingsChattingUI.b(SettingsChattingUI.this);
              AppMethodBeat.o(74142);
            }
          }, -1, b.c.alert_btn_color_warn);
          AppMethodBeat.o(74143);
          return;
          paramAnonymousDialogInterface = null;
        }
        SettingsChattingUI.b(SettingsChattingUI.this);
        AppMethodBeat.o(74143);
      }
    }, null, b.c.alert_btn_color_warn);
    AppMethodBeat.o(74149);
    return true;
    paramPreference = new Intent().setClassName(getContext(), "com.tencent.mm.plugin.dbbackup.DBRecoveryUI");
    paramPreference.putExtra("scene", 1);
    paramf = getContext();
    paramPreference = new com.tencent.mm.hellhoundlib.b.a().cG(paramPreference);
    com.tencent.mm.hellhoundlib.a.a.b(paramf, paramPreference.aYi(), "com/tencent/mm/plugin/setting/ui/setting/SettingsChattingUI", "goToRecovery", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramf.startActivity((Intent)paramPreference.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramf, "com/tencent/mm/plugin/setting/ui/setting/SettingsChattingUI", "goToRecovery", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(74149);
    return true;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74148);
    super.onResume();
    CheckBoxPreference localCheckBoxPreference = (CheckBoxPreference)this.screen.bAi("settings_voice_play_mode");
    if (localCheckBoxPreference != null)
    {
      localCheckBoxPreference.setChecked(((Boolean)com.tencent.mm.kernel.h.baE().ban().d(26, Boolean.FALSE)).booleanValue());
      localCheckBoxPreference.adZV = false;
    }
    localCheckBoxPreference = (CheckBoxPreference)this.screen.bAi("settings_enter_button_send");
    if (localCheckBoxPreference != null)
    {
      localCheckBoxPreference.setChecked(((Boolean)com.tencent.mm.kernel.h.baE().ban().d(66832, Boolean.FALSE)).booleanValue());
      localCheckBoxPreference.adZV = false;
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