package com.tencent.mm.plugin.topstory.ui.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.topstory.ui.c;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.protocal.protobuf.bfx;
import com.tencent.mm.protocal.protobuf.dbw;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;

public final class a
  implements com.tencent.mm.pluginsdk.b.a, MStorageEx.IOnStorageChange
{
  private as contact;
  private Context context;
  private CheckBoxPreference qNs;
  private f screen;
  
  public a(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private void cCt()
  {
    AppMethodBeat.i(126629);
    HelperHeaderPreference localHelperHeaderPreference = (HelperHeaderPreference)this.screen.bmg("contact_info_header_helper");
    localHelperHeaderPreference.bk(this.contact.field_username, this.contact.arJ(), this.context.getString(2131758127));
    int i;
    if ((z.aUl() & 0x4000000) == 0)
    {
      i = 1;
      if (i == 0) {
        break label144;
      }
      localHelperHeaderPreference.updateStatus(1);
      this.screen.jdMethod_do("contact_info_top_story_install", true);
      this.screen.jdMethod_do("contact_info_top_story_uninstall", false);
      this.screen.jdMethod_do("contact_info_go_to_top_story", false);
      this.screen.jdMethod_do("contact_info_top_story_not_disturb", false);
    }
    for (;;)
    {
      if (!fzX()) {
        break label204;
      }
      this.qNs.setChecked(true);
      AppMethodBeat.o(126629);
      return;
      i = 0;
      break;
      label144:
      localHelperHeaderPreference.updateStatus(0);
      this.screen.jdMethod_do("contact_info_top_story_install", false);
      this.screen.jdMethod_do("contact_info_top_story_uninstall", true);
      this.screen.jdMethod_do("contact_info_go_to_top_story", true);
      this.screen.jdMethod_do("contact_info_top_story_not_disturb", true);
    }
    label204:
    this.qNs.setChecked(false);
    AppMethodBeat.o(126629);
  }
  
  private static boolean fzX()
  {
    AppMethodBeat.i(126631);
    if ((z.aUe() & 0x1000000) == 0)
    {
      AppMethodBeat.o(126631);
      return true;
    }
    AppMethodBeat.o(126631);
    return false;
  }
  
  private void wx(boolean paramBoolean)
  {
    AppMethodBeat.i(126628);
    int i = z.aUl();
    Object localObject;
    if (paramBoolean)
    {
      i &= 0xFBFFFFFF;
      g.aAh().azQ().set(34, Integer.valueOf(i));
      localObject = new dbw();
      ((dbw)localObject).KEc = 67108864;
      if (!paramBoolean) {
        break label195;
      }
    }
    label195:
    for (i = 0;; i = 1)
    {
      ((dbw)localObject).MGK = i;
      ((l)g.af(l.class)).aSM().d(new k.a(39, (com.tencent.mm.bw.a)localObject));
      cCt();
      if (!paramBoolean) {
        break label200;
      }
      if (((l)g.af(l.class)).aST().bjY("topstoryapp") == null)
      {
        localObject = new az();
        ((az)localObject).setUsername("topstoryapp");
        ((az)localObject).setContent(this.context.getString(2131758127));
        ((az)localObject).yA(Util.nowMilliSecond());
        ((az)localObject).nv(0);
        ((az)localObject).nt(0);
        ((l)g.af(l.class)).aST().e((az)localObject);
      }
      AppMethodBeat.o(126628);
      return;
      i |= 0x4000000;
      break;
    }
    label200:
    ((l)g.af(l.class)).aST().bjW("topstoryapp");
    AppMethodBeat.o(126628);
  }
  
  public final boolean a(f paramf, as paramas, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(126625);
    this.screen = paramf;
    this.contact = paramas;
    paramf.addPreferencesFromResource(2132017197);
    g.aAh().azQ().add(this);
    this.qNs = ((CheckBoxPreference)paramf.bmg("contact_info_top_story_not_disturb"));
    cCt();
    AppMethodBeat.o(126625);
    return true;
  }
  
  public final boolean alD(String paramString)
  {
    AppMethodBeat.i(126627);
    if ("contact_info_go_to_top_story".equals(paramString)) {
      c.as(this.context, 0);
    }
    do
    {
      for (;;)
      {
        AppMethodBeat.o(126627);
        return false;
        if ("contact_info_top_story_install".equals(paramString))
        {
          wx(true);
        }
        else
        {
          if (!"contact_info_top_story_uninstall".equals(paramString)) {
            break;
          }
          h.c(this.context, this.context.getString(2131765548), "", this.context.getString(2131755764), this.context.getString(2131755761), new DialogInterface.OnClickListener()
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
    int i = z.aUe();
    if (this.qNs.isChecked())
    {
      i &= 0xFEFFFFFF;
      label133:
      g.aAh().azQ().set(40, Integer.valueOf(i));
      paramString = new bfx();
      paramString.LPB = 55;
      if (!this.qNs.isChecked()) {
        break label218;
      }
    }
    label218:
    for (i = 2;; i = 1)
    {
      paramString.BsD = i;
      ((l)g.af(l.class)).aSM().d(new k.a(55, paramString));
      break;
      i |= 0x1000000;
      break label133;
    }
  }
  
  public final boolean cCs()
  {
    AppMethodBeat.i(126626);
    g.aAh().azQ().remove(this);
    AppMethodBeat.o(126626);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(126630);
    paramInt = Util.nullAsInt(paramObject, 0);
    if ((paramMStorageEx != g.aAh().azQ()) || (paramInt <= 0))
    {
      AppMethodBeat.o(126630);
      return;
    }
    if ((paramInt != 40) && (paramInt != 34) && (paramInt != 7))
    {
      AppMethodBeat.o(126630);
      return;
    }
    cCt();
    AppMethodBeat.o(126630);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.widget.a
 * JD-Core Version:    0.7.0.1
 */