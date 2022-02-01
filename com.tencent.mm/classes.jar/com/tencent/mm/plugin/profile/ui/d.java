package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.e.d;
import junit.framework.Assert;

public final class d
  implements com.tencent.mm.pluginsdk.b.a
{
  com.tencent.mm.plugin.profile.a.b Bcm;
  private as contact;
  private final Context context;
  private f screen;
  
  public d(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final boolean a(f paramf, as paramas, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(27115);
    boolean bool;
    label34:
    label46:
    Object localObject;
    if (paramas != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (Util.nullAsNil(paramas.field_username).length() <= 0) {
        break label292;
      }
      bool = true;
      Assert.assertTrue(bool);
      if (paramf == null) {
        break label298;
      }
      bool = true;
      Assert.assertTrue(bool);
      this.contact = paramas;
      ((MMActivity)this.context).getIntent().putExtra("Contact_Scene", 25);
      if (this.Bcm == null) {
        this.Bcm = new com.tencent.mm.plugin.profile.a.b((MMActivity)this.context, paramas);
      }
      cCs();
      this.screen = paramf;
      paramf.removeAll();
      paramf.addPreferencesFromResource(2132017174);
      localObject = (NormalProfileHeaderPreference)paramf.bmg("contact_info_header_normal");
      if (localObject != null)
      {
        ((NormalProfileHeaderPreference)localObject).nRm = paramf;
        ((NormalProfileHeaderPreference)localObject).a(paramas, 25, paramBoolean, null);
      }
      localObject = (KeyValuePreference)paramf.bmg("contact_info_signature");
      if ((paramas.signature == null) || (paramas.signature.trim().equals(""))) {
        break label304;
      }
      if (localObject != null)
      {
        ((KeyValuePreference)localObject).OYB = false;
        ((KeyValuePreference)localObject).setTitle(this.context.getString(2131758062));
        ((KeyValuePreference)localObject).setSummary(l.c(this.context, paramas.signature));
        ((KeyValuePreference)localObject).BC(false);
        ((KeyValuePreference)localObject).alO(8);
      }
    }
    for (;;)
    {
      ((MultiButtonPreference)paramf.bmg("contact_profile_multi_button")).a(this.context.getString(2131756736), new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27113);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/ContactWidgetBottleContact$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          d.this.Bcm.eDX();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/ContactWidgetBottleContact$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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
      paramf.e((Preference)localObject);
    }
  }
  
  public final boolean alD(String paramString)
  {
    AppMethodBeat.i(27114);
    if (paramString.equals("contact_profile_say_hi"))
    {
      paramString = new Intent();
      paramString.putExtra("Contact_User", this.contact.field_username);
      paramString.putExtra("Contact_Scene", 25);
      paramString.putExtra(e.d.OyT, this.contact.fuY);
      com.tencent.mm.plugin.profile.b.jRt.a(paramString, this.context);
    }
    AppMethodBeat.o(27114);
    return true;
  }
  
  public final boolean cCs()
  {
    AppMethodBeat.i(27116);
    if (this.screen == null)
    {
      AppMethodBeat.o(27116);
      return true;
    }
    NormalProfileHeaderPreference localNormalProfileHeaderPreference = (NormalProfileHeaderPreference)this.screen.bmg("contact_info_header_normal");
    if (localNormalProfileHeaderPreference != null) {
      localNormalProfileHeaderPreference.onDetach();
    }
    if (this.Bcm != null) {
      this.Bcm.destroy();
    }
    AppMethodBeat.o(27116);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.d
 * JD-Core Version:    0.7.0.1
 */