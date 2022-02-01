package com.tencent.mm.plugin.topstory.ui.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.topstory.ui.c.g;
import com.tencent.mm.plugin.topstory.ui.c.i;
import com.tencent.mm.plugin.topstory.ui.d;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.protocal.protobuf.bmy;
import com.tencent.mm.protocal.protobuf.dlm;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;

public final class a
  implements com.tencent.mm.pluginsdk.c.a, MStorageEx.IOnStorageChange
{
  private as contact;
  private Context context;
  private com.tencent.mm.ui.base.preference.f screen;
  private CheckBoxPreference uoF;
  
  public a(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private void Ak(boolean paramBoolean)
  {
    AppMethodBeat.i(126628);
    int i = z.bdn();
    Object localObject;
    if (paramBoolean)
    {
      i &= 0xFBFFFFFF;
      com.tencent.mm.kernel.h.aHG().aHp().i(34, Integer.valueOf(i));
      localObject = new dlm();
      ((dlm)localObject).RFu = 67108864;
      if (!paramBoolean) {
        break label196;
      }
    }
    label196:
    for (i = 0;; i = 1)
    {
      ((dlm)localObject).TSy = i;
      ((n)com.tencent.mm.kernel.h.ae(n.class)).bbK().d(new k.a(39, (com.tencent.mm.cd.a)localObject));
      cQY();
      if (!paramBoolean) {
        break label201;
      }
      if (((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().bwx("topstoryapp") == null)
      {
        localObject = new az();
        ((az)localObject).setUsername("topstoryapp");
        ((az)localObject).setContent(this.context.getString(c.g.contact_info_top_story_switch_tip));
        ((az)localObject).EB(Util.nowMilliSecond());
        ((az)localObject).pJ(0);
        ((az)localObject).pH(0);
        ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().e((az)localObject);
      }
      AppMethodBeat.o(126628);
      return;
      i |= 0x4000000;
      break;
    }
    label201:
    ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().bwv("topstoryapp");
    AppMethodBeat.o(126628);
  }
  
  private void cQY()
  {
    AppMethodBeat.i(126629);
    HelperHeaderPreference localHelperHeaderPreference = (HelperHeaderPreference)this.screen.byG("contact_info_header_helper");
    localHelperHeaderPreference.bf(this.contact.field_username, this.contact.ays(), this.context.getString(c.g.contact_info_top_story_switch_tip));
    int i;
    if ((z.bdn() & 0x4000000) == 0)
    {
      i = 1;
      if (i == 0) {
        break label145;
      }
      localHelperHeaderPreference.updateStatus(1);
      this.screen.dz("contact_info_top_story_install", true);
      this.screen.dz("contact_info_top_story_uninstall", false);
      this.screen.dz("contact_info_go_to_top_story", false);
      this.screen.dz("contact_info_top_story_not_disturb", false);
    }
    for (;;)
    {
      if (!grY()) {
        break label205;
      }
      this.uoF.setChecked(true);
      AppMethodBeat.o(126629);
      return;
      i = 0;
      break;
      label145:
      localHelperHeaderPreference.updateStatus(0);
      this.screen.dz("contact_info_top_story_install", false);
      this.screen.dz("contact_info_top_story_uninstall", true);
      this.screen.dz("contact_info_go_to_top_story", true);
      this.screen.dz("contact_info_top_story_not_disturb", true);
    }
    label205:
    this.uoF.setChecked(false);
    AppMethodBeat.o(126629);
  }
  
  private static boolean grY()
  {
    AppMethodBeat.i(126631);
    if ((z.bdf() & 0x1000000) == 0)
    {
      AppMethodBeat.o(126631);
      return true;
    }
    AppMethodBeat.o(126631);
    return false;
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, as paramas, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(126625);
    this.screen = paramf;
    this.contact = paramas;
    paramf.auC(c.i.contact_info_pref_top_story);
    com.tencent.mm.kernel.h.aHG().aHp().add(this);
    this.uoF = ((CheckBoxPreference)paramf.byG("contact_info_top_story_not_disturb"));
    cQY();
    AppMethodBeat.o(126625);
    return true;
  }
  
  public final boolean atw(String paramString)
  {
    AppMethodBeat.i(126627);
    if ("contact_info_go_to_top_story".equals(paramString)) {
      d.aK(this.context, 0);
    }
    do
    {
      for (;;)
      {
        AppMethodBeat.o(126627);
        return false;
        if ("contact_info_top_story_install".equals(paramString))
        {
          Ak(true);
        }
        else
        {
          if (!"contact_info_top_story_uninstall".equals(paramString)) {
            break;
          }
          com.tencent.mm.ui.base.h.c(this.context, this.context.getString(c.g.settings_plugins_uninstall_hint), "", this.context.getString(c.g.app_clear), this.context.getString(c.g.app_cancel), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(126624);
              a.a(a.this);
              AppMethodBeat.o(126624);
            }
          }, null);
        }
      }
    } while (!"contact_info_top_story_not_disturb".equals(paramString));
    int i = z.bdf();
    if (this.uoF.isChecked())
    {
      i &= 0xFEFFFFFF;
      label137:
      com.tencent.mm.kernel.h.aHG().aHp().i(40, Integer.valueOf(i));
      paramString = new bmy();
      paramString.SXP = 55;
      if (!this.uoF.isChecked()) {
        break label222;
      }
    }
    label222:
    for (i = 2;; i = 1)
    {
      paramString.HmX = i;
      ((n)com.tencent.mm.kernel.h.ae(n.class)).bbK().d(new k.a(55, paramString));
      break;
      i |= 0x1000000;
      break label137;
    }
  }
  
  public final boolean cQX()
  {
    AppMethodBeat.i(126626);
    com.tencent.mm.kernel.h.aHG().aHp().remove(this);
    AppMethodBeat.o(126626);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(126630);
    paramInt = Util.nullAsInt(paramObject, 0);
    if ((paramMStorageEx != com.tencent.mm.kernel.h.aHG().aHp()) || (paramInt <= 0))
    {
      AppMethodBeat.o(126630);
      return;
    }
    if ((paramInt != 40) && (paramInt != 34) && (paramInt != 7))
    {
      AppMethodBeat.o(126630);
      return;
    }
    cQY();
    AppMethodBeat.o(126630);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.widget.a
 * JD-Core Version:    0.7.0.1
 */