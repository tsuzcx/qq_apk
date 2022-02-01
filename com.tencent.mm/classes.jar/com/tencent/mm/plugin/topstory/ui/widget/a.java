package com.tencent.mm.plugin.topstory.ui.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.topstory.ui.d;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.protocal.protobuf.amy;
import com.tencent.mm.protocal.protobuf.cau;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bh;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;

public final class a
  implements com.tencent.mm.pluginsdk.b.a, n.b
{
  private af contact;
  private Context context;
  private CheckBoxPreference okn;
  private f screen;
  
  public a(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private void bRv()
  {
    AppMethodBeat.i(126629);
    HelperHeaderPreference localHelperHeaderPreference = (HelperHeaderPreference)this.screen.aKk("contact_info_header_helper");
    localHelperHeaderPreference.aO(this.contact.field_username, this.contact.ZX(), this.context.getString(2131757887));
    int i;
    if ((u.aqS() & 0x4000000) == 0)
    {
      i = 1;
      if (i == 0) {
        break label144;
      }
      localHelperHeaderPreference.updateStatus(1);
      this.screen.cE("contact_info_top_story_install", true);
      this.screen.cE("contact_info_top_story_uninstall", false);
      this.screen.cE("contact_info_go_to_top_story", false);
      this.screen.cE("contact_info_top_story_not_disturb", false);
    }
    for (;;)
    {
      if (!dQh()) {
        break label204;
      }
      this.okn.lG = true;
      AppMethodBeat.o(126629);
      return;
      i = 0;
      break;
      label144:
      localHelperHeaderPreference.updateStatus(0);
      this.screen.cE("contact_info_top_story_install", false);
      this.screen.cE("contact_info_top_story_uninstall", true);
      this.screen.cE("contact_info_go_to_top_story", true);
      this.screen.cE("contact_info_top_story_not_disturb", true);
    }
    label204:
    this.okn.lG = false;
    AppMethodBeat.o(126629);
  }
  
  private static boolean dQh()
  {
    AppMethodBeat.i(126631);
    if ((u.aqM() & 0x1000000) == 0)
    {
      AppMethodBeat.o(126631);
      return true;
    }
    AppMethodBeat.o(126631);
    return false;
  }
  
  public final boolean SN(String paramString)
  {
    AppMethodBeat.i(126627);
    if ("contact_info_go_to_top_story".equals(paramString)) {
      d.aa(this.context, 0);
    }
    do
    {
      for (;;)
      {
        AppMethodBeat.o(126627);
        return false;
        if ("contact_info_top_story_install".equals(paramString))
        {
          oh(true);
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
              a.this.oh(false);
              AppMethodBeat.o(126624);
            }
          }, null);
        }
      }
    } while (!"contact_info_top_story_not_disturb".equals(paramString));
    int i = u.aqM();
    if (this.okn.isChecked())
    {
      i &= 0xFEFFFFFF;
      label132:
      g.afB().afk().set(40, Integer.valueOf(i));
      paramString = new amy();
      paramString.DnY = 55;
      if (!this.okn.isChecked()) {
        break label217;
      }
    }
    label217:
    for (i = 2;; i = 1)
    {
      paramString.uMR = i;
      ((k)g.ab(k.class)).apL().c(new j.a(55, paramString));
      break;
      i |= 0x1000000;
      break label132;
    }
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(126630);
    paramInt = bt.i(paramObject, 0);
    if ((paramn != g.afB().afk()) || (paramInt <= 0))
    {
      AppMethodBeat.o(126630);
      return;
    }
    if ((paramInt != 40) && (paramInt != 34) && (paramInt != 7))
    {
      AppMethodBeat.o(126630);
      return;
    }
    bRv();
    AppMethodBeat.o(126630);
  }
  
  public final boolean a(f paramf, af paramaf, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(126625);
    this.screen = paramf;
    this.contact = paramaf;
    paramf.addPreferencesFromResource(2131951659);
    g.afB().afk().a(this);
    this.okn = ((CheckBoxPreference)paramf.aKk("contact_info_top_story_not_disturb"));
    bRv();
    AppMethodBeat.o(126625);
    return true;
  }
  
  public final boolean bRu()
  {
    AppMethodBeat.i(126626);
    g.afB().afk().b(this);
    AppMethodBeat.o(126626);
    return true;
  }
  
  final void oh(boolean paramBoolean)
  {
    AppMethodBeat.i(126628);
    int i = u.aqS();
    Object localObject;
    if (paramBoolean)
    {
      i &= 0xFBFFFFFF;
      g.afB().afk().set(34, Integer.valueOf(i));
      localObject = new cau();
      ((cau)localObject).CuI = 67108864;
      if (!paramBoolean) {
        break label195;
      }
    }
    label195:
    for (i = 0;; i = 1)
    {
      ((cau)localObject).DXj = i;
      ((k)g.ab(k.class)).apL().c(new j.a(39, (com.tencent.mm.bx.a)localObject));
      bRv();
      if (!paramBoolean) {
        break label200;
      }
      if (((k)g.ab(k.class)).apR().aIn("topstoryapp") == null)
      {
        localObject = new am();
        ((am)localObject).setUsername("topstoryapp");
        ((am)localObject).setContent(this.context.getString(2131757887));
        ((am)localObject).kS(bt.eGO());
        ((am)localObject).jV(0);
        ((am)localObject).jT(0);
        ((k)g.ab(k.class)).apR().e((am)localObject);
      }
      AppMethodBeat.o(126628);
      return;
      i |= 0x4000000;
      break;
    }
    label200:
    ((k)g.ab(k.class)).apR().aIl("topstoryapp");
    AppMethodBeat.o(126628);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.widget.a
 * JD-Core Version:    0.7.0.1
 */