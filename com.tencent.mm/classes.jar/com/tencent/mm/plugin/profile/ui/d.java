package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.f.d;
import junit.framework.Assert;

public final class d
  implements com.tencent.mm.pluginsdk.c.a
{
  com.tencent.mm.plugin.profile.a.b GWl;
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
        break label295;
      }
      bool = true;
      Assert.assertTrue(bool);
      if (paramf == null) {
        break label301;
      }
      bool = true;
      Assert.assertTrue(bool);
      this.contact = paramas;
      ((MMActivity)this.context).getIntent().putExtra("Contact_Scene", 25);
      if (this.GWl == null) {
        this.GWl = new com.tencent.mm.plugin.profile.a.b((MMActivity)this.context, paramas);
      }
      cQX();
      this.screen = paramf;
      paramf.removeAll();
      paramf.auC(R.o.eXj);
      localObject = (NormalProfileHeaderPreference)paramf.byG("contact_info_header_normal");
      if (localObject != null)
      {
        ((NormalProfileHeaderPreference)localObject).mrf = paramf;
        ((NormalProfileHeaderPreference)localObject).a(paramas, 25, paramBoolean, null);
      }
      localObject = (KeyValuePreference)paramf.byG("contact_info_signature");
      if ((paramas.signature == null) || (paramas.signature.trim().equals(""))) {
        break label307;
      }
      if (localObject != null)
      {
        ((KeyValuePreference)localObject).WrK = false;
        ((KeyValuePreference)localObject).setTitle(this.context.getString(R.l.ezr));
        ((KeyValuePreference)localObject).aF(l.c(this.context, paramas.signature));
        ((KeyValuePreference)localObject).FU(false);
        ((KeyValuePreference)localObject).auO(8);
      }
    }
    for (;;)
    {
      ((MultiButtonPreference)paramf.byG("contact_profile_multi_button")).a(this.context.getString(R.l.biz_report_text), new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27113);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/ContactWidgetBottleContact$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          d.this.GWl.fpQ();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/ContactWidgetBottleContact$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27113);
        }
      });
      AppMethodBeat.o(27115);
      return true;
      bool = false;
      break;
      label295:
      bool = false;
      break label34;
      label301:
      bool = false;
      break label46;
      label307:
      paramf.d((Preference)localObject);
    }
  }
  
  public final boolean atw(String paramString)
  {
    AppMethodBeat.i(27114);
    if (paramString.equals("contact_profile_say_hi"))
    {
      paramString = new Intent();
      paramString.putExtra("Contact_User", this.contact.field_username);
      paramString.putExtra("Contact_Scene", 25);
      paramString.putExtra(f.d.VRW, this.contact.hDx);
      com.tencent.mm.plugin.profile.b.mIG.a(paramString, this.context);
    }
    AppMethodBeat.o(27114);
    return true;
  }
  
  public final boolean cQX()
  {
    AppMethodBeat.i(27116);
    if (this.screen == null)
    {
      AppMethodBeat.o(27116);
      return true;
    }
    NormalProfileHeaderPreference localNormalProfileHeaderPreference = (NormalProfileHeaderPreference)this.screen.byG("contact_info_header_normal");
    if (localNormalProfileHeaderPreference != null) {
      localNormalProfileHeaderPreference.onDetach();
    }
    if (this.GWl != null) {
      this.GWl.destroy();
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