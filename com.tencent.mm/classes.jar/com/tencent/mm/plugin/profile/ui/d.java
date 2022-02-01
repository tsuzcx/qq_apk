package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.e.c;
import junit.framework.Assert;

public final class d
  implements com.tencent.mm.pluginsdk.b.a
{
  private am contact;
  private final Context context;
  private f screen;
  com.tencent.mm.plugin.profile.a.b wOW;
  
  public d(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final boolean a(f paramf, am paramam, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(27115);
    boolean bool;
    label34:
    label46:
    Object localObject;
    if (paramam != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (bt.nullAsNil(paramam.field_username).length() <= 0) {
        break label292;
      }
      bool = true;
      Assert.assertTrue(bool);
      if (paramf == null) {
        break label298;
      }
      bool = true;
      Assert.assertTrue(bool);
      this.contact = paramam;
      ((MMActivity)this.context).getIntent().putExtra("Contact_Scene", 25);
      if (this.wOW == null) {
        this.wOW = new com.tencent.mm.plugin.profile.a.b((MMActivity)this.context, paramam);
      }
      cdn();
      this.screen = paramf;
      paramf.removeAll();
      paramf.addPreferencesFromResource(2131951637);
      localObject = (NormalProfileHeaderPreference)paramf.aVD("contact_info_header_normal");
      if (localObject != null)
      {
        ((NormalProfileHeaderPreference)localObject).mzx = paramf;
        ((NormalProfileHeaderPreference)localObject).a(paramam, 25, paramBoolean, null);
      }
      localObject = (KeyValuePreference)paramf.aVD("contact_info_signature");
      if ((paramam.signature == null) || (paramam.signature.trim().equals(""))) {
        break label304;
      }
      if (localObject != null)
      {
        ((KeyValuePreference)localObject).JsK = false;
        ((KeyValuePreference)localObject).setTitle(this.context.getString(2131757822));
        ((KeyValuePreference)localObject).setSummary(k.c(this.context, paramam.signature));
        ((KeyValuePreference)localObject).xG(false);
        ((KeyValuePreference)localObject).acw(8);
      }
    }
    for (;;)
    {
      ((MultiButtonPreference)paramf.aVD("contact_profile_multi_button")).a(this.context.getString(2131756596), new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27113);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/ContactWidgetBottleContact$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          d.this.wOW.dAp();
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
      paramf.d((Preference)localObject);
    }
  }
  
  public final boolean aaG(String paramString)
  {
    AppMethodBeat.i(27114);
    if (paramString.equals("contact_profile_say_hi"))
    {
      paramString = new Intent();
      paramString.putExtra("Contact_User", this.contact.field_username);
      paramString.putExtra("Contact_Scene", 25);
      paramString.putExtra(e.c.IUp, this.contact.ePK);
      com.tencent.mm.plugin.profile.b.iRG.a(paramString, this.context);
    }
    AppMethodBeat.o(27114);
    return true;
  }
  
  public final boolean cdn()
  {
    AppMethodBeat.i(27116);
    if (this.screen == null)
    {
      AppMethodBeat.o(27116);
      return true;
    }
    NormalProfileHeaderPreference localNormalProfileHeaderPreference = (NormalProfileHeaderPreference)this.screen.aVD("contact_info_header_normal");
    if (localNormalProfileHeaderPreference != null) {
      localNormalProfileHeaderPreference.onDetach();
    }
    if (this.wOW != null) {
      this.wOW.destroy();
    }
    AppMethodBeat.o(27116);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.d
 * JD-Core Version:    0.7.0.1
 */