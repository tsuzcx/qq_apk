package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import junit.framework.Assert;

public final class d
  implements a
{
  private final Context context;
  private f dnn;
  
  public d(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final boolean a(f paramf, ad paramad, boolean paramBoolean, int paramInt)
  {
    boolean bool;
    label28:
    label40:
    Object localObject;
    if (paramad != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (bk.pm(paramad.field_username).length() <= 0) {
        break label262;
      }
      bool = true;
      Assert.assertTrue(bool);
      if (paramf == null) {
        break label268;
      }
      bool = true;
      Assert.assertTrue(bool);
      awZ();
      this.dnn = paramf;
      paramf.removeAll();
      paramf.addPreferencesFromResource(R.o.contact_info_pref_bottlecontact);
      localObject = (NormalUserHeaderPreference)paramf.add("contact_info_header_normal");
      if (localObject != null)
      {
        ((NormalUserHeaderPreference)localObject).siY = "ContactWidgetBottleContact";
        ((NormalUserHeaderPreference)localObject).a(paramad, 0, null);
      }
      localObject = (NormalUserFooterPreference)paramf.add("contact_info_footer_normal");
      bool = ((Activity)this.context).getIntent().getBooleanExtra("Contact_FMessageCard", false);
      if ((localObject != null) && (!((NormalUserFooterPreference)localObject).a(paramad, "", paramBoolean, false, true, 25, 2, bool, false, 0L, ""))) {
        paramf.c((Preference)localObject);
      }
      localObject = (KeyValuePreference)paramf.add("contact_info_signature");
      if ((paramad.signature == null) || (paramad.signature.trim().equals(""))) {
        break label274;
      }
      if (localObject != null)
      {
        ((KeyValuePreference)localObject).vcS = false;
        ((KeyValuePreference)localObject).setTitle(this.context.getString(R.l.contact_info_signature));
        ((KeyValuePreference)localObject).setSummary(j.b(this.context, paramad.signature));
        ((KeyValuePreference)localObject).nf(false);
      }
    }
    for (;;)
    {
      return true;
      bool = false;
      break;
      label262:
      bool = false;
      break label28;
      label268:
      bool = false;
      break label40;
      label274:
      paramf.c((Preference)localObject);
    }
  }
  
  public final boolean awZ()
  {
    if (this.dnn == null) {}
    Object localObject;
    do
    {
      return true;
      localObject = (FriendPreference)this.dnn.add("contact_info_friend");
      if (localObject != null) {
        ((FriendPreference)localObject).awZ();
      }
      localObject = (NormalUserHeaderPreference)this.dnn.add("contact_info_header_normal");
      if (localObject != null) {
        ((NormalUserHeaderPreference)localObject).onDetach();
      }
      localObject = (NormalUserFooterPreference)this.dnn.add("contact_info_footer_normal");
    } while (localObject == null);
    ((NormalUserFooterPreference)localObject).awZ();
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean xQ(String paramString)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.d
 * JD-Core Version:    0.7.0.1
 */