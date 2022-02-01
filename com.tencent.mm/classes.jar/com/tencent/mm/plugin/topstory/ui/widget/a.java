package com.tencent.mm.plugin.topstory.ui.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.topstory.ui.d;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.protocal.protobuf.aty;
import com.tencent.mm.protocal.protobuf.cks;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;

public final class a
  implements com.tencent.mm.pluginsdk.b.a, n.b
{
  private am contact;
  private Context context;
  private CheckBoxPreference prv;
  private f screen;
  
  public a(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private void cdo()
  {
    AppMethodBeat.i(126629);
    HelperHeaderPreference localHelperHeaderPreference = (HelperHeaderPreference)this.screen.aVD("contact_info_header_helper");
    localHelperHeaderPreference.aZ(this.contact.field_username, this.contact.adv(), this.context.getString(2131757887));
    int i;
    if ((u.aAy() & 0x4000000) == 0)
    {
      i = 1;
      if (i == 0) {
        break label144;
      }
      localHelperHeaderPreference.updateStatus(1);
      this.screen.cP("contact_info_top_story_install", true);
      this.screen.cP("contact_info_top_story_uninstall", false);
      this.screen.cP("contact_info_go_to_top_story", false);
      this.screen.cP("contact_info_top_story_not_disturb", false);
    }
    for (;;)
    {
      if (!eqX()) {
        break label204;
      }
      this.prv.oB = true;
      AppMethodBeat.o(126629);
      return;
      i = 0;
      break;
      label144:
      localHelperHeaderPreference.updateStatus(0);
      this.screen.cP("contact_info_top_story_install", false);
      this.screen.cP("contact_info_top_story_uninstall", true);
      this.screen.cP("contact_info_go_to_top_story", true);
      this.screen.cP("contact_info_top_story_not_disturb", true);
    }
    label204:
    this.prv.oB = false;
    AppMethodBeat.o(126629);
  }
  
  private static boolean eqX()
  {
    AppMethodBeat.i(126631);
    if ((u.aAs() & 0x1000000) == 0)
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
    paramInt = bt.m(paramObject, 0);
    if ((paramn != g.ajC().ajl()) || (paramInt <= 0))
    {
      AppMethodBeat.o(126630);
      return;
    }
    if ((paramInt != 40) && (paramInt != 34) && (paramInt != 7))
    {
      AppMethodBeat.o(126630);
      return;
    }
    cdo();
    AppMethodBeat.o(126630);
  }
  
  public final boolean a(f paramf, am paramam, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(126625);
    this.screen = paramf;
    this.contact = paramam;
    paramf.addPreferencesFromResource(2131951659);
    g.ajC().ajl().a(this);
    this.prv = ((CheckBoxPreference)paramf.aVD("contact_info_top_story_not_disturb"));
    cdo();
    AppMethodBeat.o(126625);
    return true;
  }
  
  public final boolean aaG(String paramString)
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
          sM(true);
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
              a.this.sM(false);
              AppMethodBeat.o(126624);
            }
          }, null);
        }
      }
    } while (!"contact_info_top_story_not_disturb".equals(paramString));
    int i = u.aAs();
    if (this.prv.isChecked())
    {
      i &= 0xFEFFFFFF;
      label132:
      g.ajC().ajl().set(40, Integer.valueOf(i));
      paramString = new aty();
      paramString.GrZ = 55;
      if (!this.prv.isChecked()) {
        break label217;
      }
    }
    label217:
    for (i = 2;; i = 1)
    {
      paramString.xcI = i;
      ((l)g.ab(l.class)).azo().c(new k.a(55, paramString));
      break;
      i |= 0x1000000;
      break label132;
    }
  }
  
  public final boolean cdn()
  {
    AppMethodBeat.i(126626);
    g.ajC().ajl().b(this);
    AppMethodBeat.o(126626);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  final void sM(boolean paramBoolean)
  {
    AppMethodBeat.i(126628);
    int i = u.aAy();
    Object localObject;
    if (paramBoolean)
    {
      i &= 0xFBFFFFFF;
      g.ajC().ajl().set(34, Integer.valueOf(i));
      localObject = new cks();
      ((cks)localObject).Fsi = 67108864;
      if (!paramBoolean) {
        break label195;
      }
    }
    label195:
    for (i = 0;; i = 1)
    {
      ((cks)localObject).Heh = i;
      ((l)g.ab(l.class)).azo().c(new k.a(39, (com.tencent.mm.bx.a)localObject));
      cdo();
      if (!paramBoolean) {
        break label200;
      }
      if (((l)g.ab(l.class)).azv().aTz("topstoryapp") == null)
      {
        localObject = new at();
        ((at)localObject).setUsername("topstoryapp");
        ((at)localObject).setContent(this.context.getString(2131757887));
        ((at)localObject).qu(bt.flT());
        ((at)localObject).kr(0);
        ((at)localObject).kp(0);
        ((l)g.ab(l.class)).azv().e((at)localObject);
      }
      AppMethodBeat.o(126628);
      return;
      i |= 0x4000000;
      break;
    }
    label200:
    ((l)g.ab(l.class)).azv().aTx("topstoryapp");
    AppMethodBeat.o(126628);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.widget.a
 * JD-Core Version:    0.7.0.1
 */