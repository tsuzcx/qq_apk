package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.e.b;
import junit.framework.Assert;

public final class d
  implements a
{
  private ad contact;
  private final Context context;
  com.tencent.mm.plugin.profile.a.b pxo;
  private f screen;
  
  public d(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final boolean Ke(String paramString)
  {
    AppMethodBeat.i(23499);
    if (paramString.equals("contact_profile_say_hi"))
    {
      paramString = new Intent();
      paramString.putExtra("Contact_User", this.contact.field_username);
      paramString.putExtra("Contact_Scene", 25);
      paramString.putExtra(e.b.yUZ, this.contact.dra);
      com.tencent.mm.plugin.profile.b.gmO.a(paramString, this.context);
    }
    AppMethodBeat.o(23499);
    return true;
  }
  
  public final boolean a(f paramf, ad paramad, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(23500);
    boolean bool;
    label34:
    label46:
    Object localObject;
    if (paramad != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (bo.nullAsNil(paramad.field_username).length() <= 0) {
        break label292;
      }
      bool = true;
      Assert.assertTrue(bool);
      if (paramf == null) {
        break label298;
      }
      bool = true;
      Assert.assertTrue(bool);
      this.contact = paramad;
      ((MMActivity)this.context).getIntent().putExtra("Contact_Scene", 25);
      if (this.pxo == null) {
        this.pxo = new com.tencent.mm.plugin.profile.a.b((MMActivity)this.context, paramad);
      }
      bkb();
      this.screen = paramf;
      paramf.removeAll();
      paramf.addPreferencesFromResource(2131165203);
      localObject = (NormalProfileHeaderPreference)paramf.atx("contact_info_header_normal");
      if (localObject != null)
      {
        ((NormalProfileHeaderPreference)localObject).iLA = paramf;
        ((NormalProfileHeaderPreference)localObject).a(paramad, 25, paramBoolean, null);
      }
      localObject = (KeyValuePreference)paramf.atx("contact_info_signature");
      if ((paramad.signature == null) || (paramad.signature.trim().equals(""))) {
        break label304;
      }
      if (localObject != null)
      {
        ((KeyValuePreference)localObject).zrr = false;
        ((KeyValuePreference)localObject).setTitle(this.context.getString(2131298759));
        ((KeyValuePreference)localObject).setSummary(j.b(this.context, paramad.signature));
        ((KeyValuePreference)localObject).qJ(false);
        ((KeyValuePreference)localObject).OW(8);
      }
    }
    for (;;)
    {
      ((MultiButtonPreference)paramf.atx("contact_profile_multi_button")).a(this.context.getString(2131297684), new d.1(this));
      AppMethodBeat.o(23500);
      return true;
      bool = false;
      break;
      label292:
      bool = false;
      break label34;
      label298:
      bool = false;
      break label46;
      label304:
      paramf.d((Preference)localObject);
    }
  }
  
  public final boolean bkb()
  {
    AppMethodBeat.i(23501);
    if (this.screen == null)
    {
      AppMethodBeat.o(23501);
      return true;
    }
    NormalProfileHeaderPreference localNormalProfileHeaderPreference = (NormalProfileHeaderPreference)this.screen.atx("contact_info_header_normal");
    if (localNormalProfileHeaderPreference != null) {
      localNormalProfileHeaderPreference.onDetach();
    }
    AppMethodBeat.o(23501);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.d
 * JD-Core Version:    0.7.0.1
 */