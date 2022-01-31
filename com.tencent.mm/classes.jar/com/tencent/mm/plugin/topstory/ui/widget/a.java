package com.tencent.mm.plugin.topstory.ui.widget;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.topstory.ui.d;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.protocal.protobuf.aek;
import com.tencent.mm.protocal.protobuf.bmq;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;

public final class a
  implements com.tencent.mm.pluginsdk.b.a, n.b
{
  private ad contact;
  private Context context;
  private CheckBoxPreference ldk;
  private f screen;
  
  public a(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private void bkc()
  {
    AppMethodBeat.i(2224);
    HelperHeaderPreference localHelperHeaderPreference = (HelperHeaderPreference)this.screen.atx("contact_info_header_helper");
    localHelperHeaderPreference.aB(this.contact.field_username, this.contact.Of(), this.context.getString(2131306141));
    int i;
    if ((r.Zy() & 0x4000000) == 0)
    {
      i = 1;
      if (i == 0) {
        break label142;
      }
      localHelperHeaderPreference.sb(1);
      this.screen.cl("contact_info_top_story_install", true);
      this.screen.cl("contact_info_top_story_uninstall", false);
      this.screen.cl("contact_info_go_to_top_story", false);
      this.screen.cl("contact_info_top_story_not_disturb", false);
    }
    for (;;)
    {
      if (!cKC()) {
        break label198;
      }
      this.ldk.vxW = true;
      AppMethodBeat.o(2224);
      return;
      i = 0;
      break;
      label142:
      localHelperHeaderPreference.sb(0);
      this.screen.cl("contact_info_top_story_install", false);
      this.screen.cl("contact_info_top_story_uninstall", true);
      this.screen.cl("contact_info_go_to_top_story", true);
      this.screen.cl("contact_info_top_story_not_disturb", true);
    }
    label198:
    this.ldk.vxW = false;
    AppMethodBeat.o(2224);
  }
  
  private static boolean cKC()
  {
    AppMethodBeat.i(2226);
    if ((r.Zt() & 0x1000000) == 0)
    {
      AppMethodBeat.o(2226);
      return true;
    }
    AppMethodBeat.o(2226);
    return false;
  }
  
  public final boolean Ke(String paramString)
  {
    AppMethodBeat.i(2222);
    if ("contact_info_go_to_top_story".equals(paramString)) {
      d.Y(this.context, 0);
    }
    do
    {
      for (;;)
      {
        AppMethodBeat.o(2222);
        return false;
        if ("contact_info_top_story_install".equals(paramString))
        {
          kl(true);
        }
        else
        {
          if (!"contact_info_top_story_uninstall".equals(paramString)) {
            break;
          }
          h.d(this.context, this.context.getString(2131303384), "", this.context.getString(2131296891), this.context.getString(2131296888), new a.1(this), null);
        }
      }
    } while (!"contact_info_top_story_not_disturb".equals(paramString));
    int i = r.Zt();
    if (this.ldk.isChecked())
    {
      i &= 0xFEFFFFFF;
      label134:
      g.RL().Ru().set(40, Integer.valueOf(i));
      paramString = new aek();
      paramString.wXn = 55;
      if (!this.ldk.isChecked()) {
        break label219;
      }
    }
    label219:
    for (i = 2;; i = 1)
    {
      paramString.pKC = i;
      ((j)g.E(j.class)).Yz().c(new j.a(55, paramString));
      break;
      i |= 0x1000000;
      break label134;
    }
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(2225);
    paramInt = bo.f(paramObject, 0);
    if ((paramn != g.RL().Ru()) || (paramInt <= 0))
    {
      AppMethodBeat.o(2225);
      return;
    }
    if ((paramInt != 40) && (paramInt != 34) && (paramInt != 7))
    {
      AppMethodBeat.o(2225);
      return;
    }
    bkc();
    AppMethodBeat.o(2225);
  }
  
  public final boolean a(f paramf, ad paramad, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(2220);
    this.screen = paramf;
    this.contact = paramad;
    paramf.addPreferencesFromResource(2131165225);
    g.RL().Ru().a(this);
    this.ldk = ((CheckBoxPreference)paramf.atx("contact_info_top_story_not_disturb"));
    bkc();
    AppMethodBeat.o(2220);
    return true;
  }
  
  public final boolean bkb()
  {
    AppMethodBeat.i(2221);
    g.RL().Ru().b(this);
    AppMethodBeat.o(2221);
    return true;
  }
  
  final void kl(boolean paramBoolean)
  {
    AppMethodBeat.i(2223);
    int i = r.Zy();
    Object localObject;
    if (paramBoolean)
    {
      i &= 0xFBFFFFFF;
      g.RL().Ru().set(34, Integer.valueOf(i));
      localObject = new bmq();
      ((bmq)localObject).wmt = 67108864;
      if (!paramBoolean) {
        break label197;
      }
    }
    label197:
    for (i = 0;; i = 1)
    {
      ((bmq)localObject).xBb = i;
      ((j)g.E(j.class)).Yz().c(new j.a(39, (com.tencent.mm.bv.a)localObject));
      bkc();
      if (!paramBoolean) {
        break label202;
      }
      if (((j)g.E(j.class)).YF().arH("topstoryapp") == null)
      {
        localObject = new ak();
        ((ak)localObject).setUsername("topstoryapp");
        ((ak)localObject).setContent(this.context.getString(2131306141));
        ((ak)localObject).fK(bo.aoy());
        ((ak)localObject).hL(0);
        ((ak)localObject).hJ(0);
        ((j)g.E(j.class)).YF().d((ak)localObject);
      }
      AppMethodBeat.o(2223);
      return;
      i |= 0x4000000;
      break;
    }
    label202:
    ((j)g.E(j.class)).YF().arF("topstoryapp");
    AppMethodBeat.o(2223);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.widget.a
 * JD-Core Version:    0.7.0.1
 */