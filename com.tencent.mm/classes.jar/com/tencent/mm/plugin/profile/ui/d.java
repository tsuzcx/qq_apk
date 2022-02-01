package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.e.c;
import junit.framework.Assert;

public final class d
  implements a
{
  private af contact;
  private final Context context;
  private f screen;
  com.tencent.mm.plugin.profile.a.b uyW;
  
  public d(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final boolean SN(String paramString)
  {
    AppMethodBeat.i(27114);
    if (paramString.equals("contact_profile_say_hi"))
    {
      paramString = new Intent();
      paramString.putExtra("Contact_User", this.contact.field_username);
      paramString.putExtra("Contact_Scene", 25);
      paramString.putExtra(e.c.FHR, this.contact.evP);
      com.tencent.mm.plugin.profile.b.hYt.a(paramString, this.context);
    }
    AppMethodBeat.o(27114);
    return true;
  }
  
  public final boolean a(f paramf, af paramaf, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(27115);
    boolean bool;
    label34:
    label46:
    Object localObject;
    if (paramaf != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (bt.nullAsNil(paramaf.field_username).length() <= 0) {
        break label292;
      }
      bool = true;
      Assert.assertTrue(bool);
      if (paramf == null) {
        break label298;
      }
      bool = true;
      Assert.assertTrue(bool);
      this.contact = paramaf;
      ((MMActivity)this.context).getIntent().putExtra("Contact_Scene", 25);
      if (this.uyW == null) {
        this.uyW = new com.tencent.mm.plugin.profile.a.b((MMActivity)this.context, paramaf);
      }
      bRu();
      this.screen = paramf;
      paramf.removeAll();
      paramf.addPreferencesFromResource(2131951637);
      localObject = (NormalProfileHeaderPreference)paramf.aKk("contact_info_header_normal");
      if (localObject != null)
      {
        ((NormalProfileHeaderPreference)localObject).lxI = paramf;
        ((NormalProfileHeaderPreference)localObject).a(paramaf, 25, paramBoolean, null);
      }
      localObject = (KeyValuePreference)paramf.aKk("contact_info_signature");
      if ((paramaf.signature == null) || (paramaf.signature.trim().equals(""))) {
        break label304;
      }
      if (localObject != null)
      {
        ((KeyValuePreference)localObject).Gfe = false;
        ((KeyValuePreference)localObject).setTitle(this.context.getString(2131757822));
        ((KeyValuePreference)localObject).setSummary(k.c(this.context, paramaf.signature));
        ((KeyValuePreference)localObject).vR(false);
        ((KeyValuePreference)localObject).Yb(8);
      }
    }
    for (;;)
    {
      ((MultiButtonPreference)paramf.aKk("contact_profile_multi_button")).a(this.context.getString(2131756596), new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27113);
          d.this.uyW.dce();
          AppMethodBeat.o(27113);
        }
      });
      AppMethodBeat.o(27115);
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
  
  public final boolean bRu()
  {
    AppMethodBeat.i(27116);
    if (this.screen == null)
    {
      AppMethodBeat.o(27116);
      return true;
    }
    NormalProfileHeaderPreference localNormalProfileHeaderPreference = (NormalProfileHeaderPreference)this.screen.aKk("contact_info_header_normal");
    if (localNormalProfileHeaderPreference != null) {
      localNormalProfileHeaderPreference.onDetach();
    }
    if (this.uyW != null) {
      this.uyW.destroy();
    }
    AppMethodBeat.o(27116);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.d
 * JD-Core Version:    0.7.0.1
 */