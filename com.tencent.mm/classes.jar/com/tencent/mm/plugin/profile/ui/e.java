package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.f.e;
import junit.framework.Assert;

public final class e
  implements com.tencent.mm.pluginsdk.c.a
{
  com.tencent.mm.plugin.profile.logic.b MTQ;
  private au contact;
  private final Context context;
  private f screen;
  
  public e(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final boolean a(f paramf, au paramau, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(27115);
    boolean bool;
    label34:
    label46:
    Object localObject;
    if (paramau != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (Util.nullAsNil(paramau.field_username).length() <= 0) {
        break label295;
      }
      bool = true;
      Assert.assertTrue(bool);
      if (paramf == null) {
        break label301;
      }
      bool = true;
      Assert.assertTrue(bool);
      this.contact = paramau;
      ((MMActivity)this.context).getIntent().putExtra("Contact_Scene", 25);
      if (this.MTQ == null) {
        this.MTQ = new com.tencent.mm.plugin.profile.logic.b((MMActivity)this.context, paramau);
      }
      dvq();
      this.screen = paramf;
      paramf.removeAll();
      paramf.aBe(R.o.haL);
      localObject = (NormalProfileHeaderPreference)paramf.bAi("contact_info_header_normal");
      if (localObject != null)
      {
        ((NormalProfileHeaderPreference)localObject).pkD = paramf;
        ((NormalProfileHeaderPreference)localObject).a(paramau, 25, paramBoolean, null);
      }
      localObject = (KeyValuePreference)paramf.bAi("contact_info_signature");
      if ((paramau.signature == null) || (paramau.signature.trim().equals(""))) {
        break label307;
      }
      if (localObject != null)
      {
        ((KeyValuePreference)localObject).adZa = false;
        ((KeyValuePreference)localObject).setTitle(this.context.getString(R.l.gCg));
        ((KeyValuePreference)localObject).aS(p.b(this.context, paramau.signature));
        ((KeyValuePreference)localObject).LG(false);
        ((KeyValuePreference)localObject).aBq(8);
      }
    }
    for (;;)
    {
      ((MultiButtonPreference)paramf.bAi("contact_profile_multi_button")).b(this.context.getString(R.l.biz_report_text), new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27113);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/ContactWidgetBottleContact$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          e.this.MTQ.gBe();
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
      paramf.e((Preference)localObject);
    }
  }
  
  public final boolean anl(String paramString)
  {
    AppMethodBeat.i(27114);
    if (paramString.equals("contact_profile_say_hi"))
    {
      paramString = new Intent();
      paramString.putExtra("Contact_User", this.contact.field_username);
      paramString.putExtra("Contact_Scene", 25);
      paramString.putExtra(f.e.adwe, this.contact.kas);
      com.tencent.mm.plugin.profile.b.pFn.a(paramString, this.context);
    }
    AppMethodBeat.o(27114);
    return true;
  }
  
  public final boolean dvq()
  {
    AppMethodBeat.i(27116);
    if (this.screen == null)
    {
      AppMethodBeat.o(27116);
      return true;
    }
    NormalProfileHeaderPreference localNormalProfileHeaderPreference = (NormalProfileHeaderPreference)this.screen.bAi("contact_info_header_normal");
    if (localNormalProfileHeaderPreference != null) {
      localNormalProfileHeaderPreference.onDetach();
    }
    if (this.MTQ != null) {
      this.MTQ.destroy();
    }
    AppMethodBeat.o(27116);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.e
 * JD-Core Version:    0.7.0.1
 */