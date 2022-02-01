package com.tencent.mm.plugin.topstory.ui.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.topstory.ui.d;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.protocal.protobuf.auo;
import com.tencent.mm.protocal.protobuf.clm;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.br;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;

public final class a
  implements com.tencent.mm.pluginsdk.b.a, n.b
{
  private an contact;
  private Context context;
  private CheckBoxPreference pyb;
  private f screen;
  
  public a(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private void ceD()
  {
    AppMethodBeat.i(126629);
    HelperHeaderPreference localHelperHeaderPreference = (HelperHeaderPreference)this.screen.aXe("contact_info_header_helper");
    localHelperHeaderPreference.ba(this.contact.field_username, this.contact.adG(), this.context.getString(2131757887));
    int i;
    if ((v.aAO() & 0x4000000) == 0)
    {
      i = 1;
      if (i == 0) {
        break label144;
      }
      localHelperHeaderPreference.updateStatus(1);
      this.screen.cT("contact_info_top_story_install", true);
      this.screen.cT("contact_info_top_story_uninstall", false);
      this.screen.cT("contact_info_go_to_top_story", false);
      this.screen.cT("contact_info_top_story_not_disturb", false);
    }
    for (;;)
    {
      if (!euE()) {
        break label204;
      }
      this.pyb.setChecked(true);
      AppMethodBeat.o(126629);
      return;
      i = 0;
      break;
      label144:
      localHelperHeaderPreference.updateStatus(0);
      this.screen.cT("contact_info_top_story_install", false);
      this.screen.cT("contact_info_top_story_uninstall", true);
      this.screen.cT("contact_info_go_to_top_story", true);
      this.screen.cT("contact_info_top_story_not_disturb", true);
    }
    label204:
    this.pyb.setChecked(false);
    AppMethodBeat.o(126629);
  }
  
  private static boolean euE()
  {
    AppMethodBeat.i(126631);
    if ((v.aAI() & 0x1000000) == 0)
    {
      AppMethodBeat.o(126631);
      return true;
    }
    AppMethodBeat.o(126631);
    return false;
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(126630);
    paramInt = bu.m(paramObject, 0);
    if ((paramn != g.ajR().ajA()) || (paramInt <= 0))
    {
      AppMethodBeat.o(126630);
      return;
    }
    if ((paramInt != 40) && (paramInt != 34) && (paramInt != 7))
    {
      AppMethodBeat.o(126630);
      return;
    }
    ceD();
    AppMethodBeat.o(126630);
  }
  
  public final boolean a(f paramf, an paraman, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(126625);
    this.screen = paramf;
    this.contact = paraman;
    paramf.addPreferencesFromResource(2131951659);
    g.ajR().ajA().a(this);
    this.pyb = ((CheckBoxPreference)paramf.aXe("contact_info_top_story_not_disturb"));
    ceD();
    AppMethodBeat.o(126625);
    return true;
  }
  
  public final boolean abx(String paramString)
  {
    AppMethodBeat.i(126627);
    if ("contact_info_go_to_top_story".equals(paramString)) {
      d.aj(this.context, 0);
    }
    do
    {
      for (;;)
      {
        AppMethodBeat.o(126627);
        return false;
        if ("contact_info_top_story_install".equals(paramString))
        {
          sT(true);
        }
        else
        {
          if (!"contact_info_top_story_uninstall".equals(paramString)) {
            break;
          }
          h.e(this.context, this.context.getString(2131763366), "", this.context.getString(2131755694), this.context.getString(2131755691), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(126624);
              a.this.sT(false);
              AppMethodBeat.o(126624);
            }
          }, null);
        }
      }
    } while (!"contact_info_top_story_not_disturb".equals(paramString));
    int i = v.aAI();
    if (this.pyb.isChecked())
    {
      i &= 0xFEFFFFFF;
      label132:
      g.ajR().ajA().set(40, Integer.valueOf(i));
      paramString = new auo();
      paramString.GLx = 55;
      if (!this.pyb.isChecked()) {
        break label217;
      }
    }
    label217:
    for (i = 2;; i = 1)
    {
      paramString.xsz = i;
      ((l)g.ab(l.class)).azE().d(new k.a(55, paramString));
      break;
      i |= 0x1000000;
      break label132;
    }
  }
  
  public final boolean ceC()
  {
    AppMethodBeat.i(126626);
    g.ajR().ajA().b(this);
    AppMethodBeat.o(126626);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  final void sT(boolean paramBoolean)
  {
    AppMethodBeat.i(126628);
    int i = v.aAO();
    Object localObject;
    if (paramBoolean)
    {
      i &= 0xFBFFFFFF;
      g.ajR().ajA().set(34, Integer.valueOf(i));
      localObject = new clm();
      ((clm)localObject).FKG = 67108864;
      if (!paramBoolean) {
        break label195;
      }
    }
    label195:
    for (i = 0;; i = 1)
    {
      ((clm)localObject).HxH = i;
      ((l)g.ab(l.class)).azE().d(new k.a(39, (com.tencent.mm.bw.a)localObject));
      ceD();
      if (!paramBoolean) {
        break label200;
      }
      if (((l)g.ab(l.class)).azL().aVa("topstoryapp") == null)
      {
        localObject = new au();
        ((au)localObject).setUsername("topstoryapp");
        ((au)localObject).setContent(this.context.getString(2131757887));
        ((au)localObject).qH(bu.fpO());
        ((au)localObject).kt(0);
        ((au)localObject).kr(0);
        ((l)g.ab(l.class)).azL().e((au)localObject);
      }
      AppMethodBeat.o(126628);
      return;
      i |= 0x4000000;
      break;
    }
    label200:
    ((l)g.ab(l.class)).azL().aUY("topstoryapp");
    AppMethodBeat.o(126628);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.widget.a
 * JD-Core Version:    0.7.0.1
 */