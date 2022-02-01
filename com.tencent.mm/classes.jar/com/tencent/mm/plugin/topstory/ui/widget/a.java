package com.tencent.mm.plugin.topstory.ui.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.topstory.ui.c.g;
import com.tencent.mm.plugin.topstory.ui.c.i;
import com.tencent.mm.plugin.topstory.ui.d;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.protocal.protobuf.cas;
import com.tencent.mm.protocal.protobuf.edx;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.by;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;

public final class a
  implements com.tencent.mm.pluginsdk.c.a, MStorageEx.IOnStorageChange
{
  private au contact;
  private Context context;
  private com.tencent.mm.ui.base.preference.f screen;
  private CheckBoxPreference xvc;
  
  public a(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private void dvr()
  {
    AppMethodBeat.i(126629);
    HelperHeaderPreference localHelperHeaderPreference = (HelperHeaderPreference)this.screen.bAi("contact_info_header_helper");
    localHelperHeaderPreference.bz(this.contact.field_username, this.contact.aSV(), this.context.getString(c.g.contact_info_top_story_switch_tip));
    int i;
    if ((z.bBf() & 0x4000000) == 0)
    {
      i = 1;
      if (i == 0) {
        break label145;
      }
      localHelperHeaderPreference.updateStatus(1);
      this.screen.eh("contact_info_top_story_install", true);
      this.screen.eh("contact_info_top_story_uninstall", false);
      this.screen.eh("contact_info_go_to_top_story", false);
      this.screen.eh("contact_info_top_story_not_disturb", false);
    }
    for (;;)
    {
      if (!hOZ()) {
        break label205;
      }
      this.xvc.setChecked(true);
      AppMethodBeat.o(126629);
      return;
      i = 0;
      break;
      label145:
      localHelperHeaderPreference.updateStatus(0);
      this.screen.eh("contact_info_top_story_install", false);
      this.screen.eh("contact_info_top_story_uninstall", true);
      this.screen.eh("contact_info_go_to_top_story", true);
      this.screen.eh("contact_info_top_story_not_disturb", true);
    }
    label205:
    this.xvc.setChecked(false);
    AppMethodBeat.o(126629);
  }
  
  private static boolean hOZ()
  {
    AppMethodBeat.i(126631);
    if ((z.bAU() & 0x1000000) == 0)
    {
      AppMethodBeat.o(126631);
      return true;
    }
    AppMethodBeat.o(126631);
    return false;
  }
  
  private void setInstall(boolean paramBoolean)
  {
    AppMethodBeat.i(126628);
    int i = z.bBf();
    Object localObject;
    if (paramBoolean)
    {
      i &= 0xFBFFFFFF;
      h.baE().ban().B(34, Integer.valueOf(i));
      localObject = new edx();
      ((edx)localObject).YBX = 67108864;
      if (!paramBoolean) {
        break label196;
      }
    }
    label196:
    for (i = 0;; i = 1)
    {
      ((edx)localObject).abiW = i;
      ((n)h.ax(n.class)).bzz().d(new k.a(39, (com.tencent.mm.bx.a)localObject));
      dvr();
      if (!paramBoolean) {
        break label201;
      }
      if (((n)h.ax(n.class)).bzG().bxM("topstoryapp") == null)
      {
        localObject = new bb();
        ((bb)localObject).setUsername("topstoryapp");
        ((bb)localObject).setContent(this.context.getString(c.g.contact_info_top_story_switch_tip));
        ((bb)localObject).gR(Util.nowMilliSecond());
        ((bb)localObject).pI(0);
        ((bb)localObject).pG(0);
        ((n)h.ax(n.class)).bzG().h((bb)localObject);
      }
      AppMethodBeat.o(126628);
      return;
      i |= 0x4000000;
      break;
    }
    label201:
    ((n)h.ax(n.class)).bzG().bxK("topstoryapp");
    AppMethodBeat.o(126628);
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, au paramau, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(126625);
    this.screen = paramf;
    this.contact = paramau;
    paramf.aBe(c.i.contact_info_pref_top_story);
    h.baE().ban().add(this);
    this.xvc = ((CheckBoxPreference)paramf.bAi("contact_info_top_story_not_disturb"));
    dvr();
    AppMethodBeat.o(126625);
    return true;
  }
  
  public final boolean anl(String paramString)
  {
    AppMethodBeat.i(126627);
    if ("contact_info_go_to_top_story".equals(paramString)) {
      d.bc(this.context, 0);
    }
    do
    {
      for (;;)
      {
        AppMethodBeat.o(126627);
        return false;
        if ("contact_info_top_story_install".equals(paramString))
        {
          setInstall(true);
        }
        else
        {
          if (!"contact_info_top_story_uninstall".equals(paramString)) {
            break;
          }
          k.b(this.context, this.context.getString(c.g.settings_plugins_uninstall_hint), "", this.context.getString(c.g.app_clear), this.context.getString(c.g.app_cancel), new DialogInterface.OnClickListener()
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
    int i = z.bAU();
    if (this.xvc.isChecked())
    {
      i &= 0xFEFFFFFF;
      label137:
      h.baE().ban().B(40, Integer.valueOf(i));
      paramString = new cas();
      paramString.aajJ = 55;
      if (!this.xvc.isChecked()) {
        break label222;
      }
    }
    label222:
    for (i = 2;; i = 1)
    {
      paramString.NkL = i;
      ((n)h.ax(n.class)).bzz().d(new k.a(55, paramString));
      break;
      i |= 0x1000000;
      break label137;
    }
  }
  
  public final boolean dvq()
  {
    AppMethodBeat.i(126626);
    h.baE().ban().remove(this);
    AppMethodBeat.o(126626);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(126630);
    paramInt = Util.nullAsInt(paramObject, 0);
    if ((paramMStorageEx != h.baE().ban()) || (paramInt <= 0))
    {
      AppMethodBeat.o(126630);
      return;
    }
    if ((paramInt != 40) && (paramInt != 34) && (paramInt != 7))
    {
      AppMethodBeat.o(126630);
      return;
    }
    dvr();
    AppMethodBeat.o(126630);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.widget.a
 * JD-Core Version:    0.7.0.1
 */