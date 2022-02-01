package com.tencent.mm.plugin.topstory.ui.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.topstory.ui.d;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.protocal.protobuf.aqc;
import com.tencent.mm.protocal.protobuf.cft;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bk;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;

public final class a
  implements com.tencent.mm.pluginsdk.b.a, n.b
{
  private ai contact;
  private Context context;
  private CheckBoxPreference oNN;
  private f screen;
  
  public a(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private void bYK()
  {
    AppMethodBeat.i(126629);
    HelperHeaderPreference localHelperHeaderPreference = (HelperHeaderPreference)this.screen.aPN("contact_info_header_helper");
    localHelperHeaderPreference.aR(this.contact.field_username, this.contact.aaS(), this.context.getString(2131757887));
    int i;
    if ((u.axI() & 0x4000000) == 0)
    {
      i = 1;
      if (i == 0) {
        break label144;
      }
      localHelperHeaderPreference.updateStatus(1);
      this.screen.cK("contact_info_top_story_install", true);
      this.screen.cK("contact_info_top_story_uninstall", false);
      this.screen.cK("contact_info_go_to_top_story", false);
      this.screen.cK("contact_info_top_story_not_disturb", false);
    }
    for (;;)
    {
      if (!eeG()) {
        break label204;
      }
      this.oNN.mF = true;
      AppMethodBeat.o(126629);
      return;
      i = 0;
      break;
      label144:
      localHelperHeaderPreference.updateStatus(0);
      this.screen.cK("contact_info_top_story_install", false);
      this.screen.cK("contact_info_top_story_uninstall", true);
      this.screen.cK("contact_info_go_to_top_story", true);
      this.screen.cK("contact_info_top_story_not_disturb", true);
    }
    label204:
    this.oNN.mF = false;
    AppMethodBeat.o(126629);
  }
  
  private static boolean eeG()
  {
    AppMethodBeat.i(126631);
    if ((u.axC() & 0x1000000) == 0)
    {
      AppMethodBeat.o(126631);
      return true;
    }
    AppMethodBeat.o(126631);
    return false;
  }
  
  public final boolean WZ(String paramString)
  {
    AppMethodBeat.i(126627);
    if ("contact_info_go_to_top_story".equals(paramString)) {
      d.ag(this.context, 0);
    }
    do
    {
      for (;;)
      {
        AppMethodBeat.o(126627);
        return false;
        if ("contact_info_top_story_install".equals(paramString))
        {
          pb(true);
        }
        else
        {
          if (!"contact_info_top_story_uninstall".equals(paramString)) {
            break;
          }
          h.d(this.context, this.context.getString(2131763366), "", this.context.getString(2131755694), this.context.getString(2131755691), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(126624);
              a.this.pb(false);
              AppMethodBeat.o(126624);
            }
          }, null);
        }
      }
    } while (!"contact_info_top_story_not_disturb".equals(paramString));
    int i = u.axC();
    if (this.oNN.isChecked())
    {
      i &= 0xFEFFFFFF;
      label132:
      g.agR().agA().set(40, Integer.valueOf(i));
      paramString = new aqc();
      paramString.EIY = 55;
      if (!this.oNN.isChecked()) {
        break label217;
      }
    }
    label217:
    for (i = 2;; i = 1)
    {
      paramString.vVH = i;
      ((k)g.ab(k.class)).awA().c(new j.a(55, paramString));
      break;
      i |= 0x1000000;
      break label132;
    }
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(126630);
    paramInt = bs.l(paramObject, 0);
    if ((paramn != g.agR().agA()) || (paramInt <= 0))
    {
      AppMethodBeat.o(126630);
      return;
    }
    if ((paramInt != 40) && (paramInt != 34) && (paramInt != 7))
    {
      AppMethodBeat.o(126630);
      return;
    }
    bYK();
    AppMethodBeat.o(126630);
  }
  
  public final boolean a(f paramf, ai paramai, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(126625);
    this.screen = paramf;
    this.contact = paramai;
    paramf.addPreferencesFromResource(2131951659);
    g.agR().agA().a(this);
    this.oNN = ((CheckBoxPreference)paramf.aPN("contact_info_top_story_not_disturb"));
    bYK();
    AppMethodBeat.o(126625);
    return true;
  }
  
  public final boolean bYJ()
  {
    AppMethodBeat.i(126626);
    g.agR().agA().b(this);
    AppMethodBeat.o(126626);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  final void pb(boolean paramBoolean)
  {
    AppMethodBeat.i(126628);
    int i = u.axI();
    Object localObject;
    if (paramBoolean)
    {
      i &= 0xFBFFFFFF;
      g.agR().agA().set(34, Integer.valueOf(i));
      localObject = new cft();
      ((cft)localObject).DNd = 67108864;
      if (!paramBoolean) {
        break label195;
      }
    }
    label195:
    for (i = 0;; i = 1)
    {
      ((cft)localObject).Fuc = i;
      ((k)g.ab(k.class)).awA().c(new j.a(39, (com.tencent.mm.bw.a)localObject));
      bYK();
      if (!paramBoolean) {
        break label200;
      }
      if (((k)g.ab(k.class)).awG().aNI("topstoryapp") == null)
      {
        localObject = new ap();
        ((ap)localObject).setUsername("topstoryapp");
        ((ap)localObject).setContent(this.context.getString(2131757887));
        ((ap)localObject).ou(bs.eWj());
        ((ap)localObject).jT(0);
        ((ap)localObject).jR(0);
        ((k)g.ab(k.class)).awG().e((ap)localObject);
      }
      AppMethodBeat.o(126628);
      return;
      i |= 0x4000000;
      break;
    }
    label200:
    ((k)g.ab(k.class)).awG().aNG("topstoryapp");
    AppMethodBeat.o(126628);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.widget.a
 * JD-Core Version:    0.7.0.1
 */