package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.n.b;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.f;
import junit.framework.Assert;

public final class h
  implements com.tencent.mm.pluginsdk.b.a
{
  private ai contact;
  Context context;
  x ftP;
  private int iMg;
  private String roomId;
  private f screen;
  private boolean vIS;
  private boolean vIT;
  private int vKF;
  ContactListExpandPreference vKG;
  
  public h(Context paramContext)
  {
    AppMethodBeat.i(27148);
    this.context = paramContext;
    this.vKG = new ContactListExpandPreference(paramContext, 0);
    AppMethodBeat.o(27148);
  }
  
  public final boolean WZ(String paramString)
  {
    AppMethodBeat.i(27149);
    ac.d("MicroMsg.ContactWidgetGroupCard", "handleEvent ".concat(String.valueOf(paramString)));
    az.ayM();
    Object localObject = c.awB().aNt(paramString);
    if ((localObject == null) || ((int)((b)localObject).fLJ <= 0))
    {
      AppMethodBeat.o(27149);
      return true;
    }
    paramString = new Intent();
    paramString.setClass(this.context, ContactInfoUI.class);
    paramString.putExtra("Contact_User", ((av)localObject).field_username);
    localObject = this.context;
    paramString = new com.tencent.mm.hellhoundlib.b.a().ba(paramString);
    com.tencent.mm.hellhoundlib.a.a.a(localObject, paramString.aeD(), "com/tencent/mm/plugin/profile/ui/ContactWidgetGroupCard", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((Context)localObject).startActivity((Intent)paramString.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/profile/ui/ContactWidgetGroupCard", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(27149);
    return true;
  }
  
  public final boolean a(f paramf, ai paramai, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(27150);
    if (paramai != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (bs.nullAsNil(paramai.field_username).length() <= 0) {
        break label364;
      }
      bool = true;
      label34:
      Assert.assertTrue(bool);
      if (paramf == null) {
        break label370;
      }
    }
    label364:
    label370:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.screen = paramf;
      this.contact = paramai;
      this.vIS = paramBoolean;
      this.iMg = paramInt;
      this.vIT = ((Activity)this.context).getIntent().getBooleanExtra("User_Verify", false);
      this.vKF = ((Activity)this.context).getIntent().getIntExtra("Kdel_from", -1);
      this.roomId = paramai.field_username;
      az.ayM();
      this.ftP = c.awK().xO(this.roomId);
      this.screen.removeAll();
      paramf = new PreferenceSmallCategory(this.context);
      this.screen.b(paramf);
      this.vKG.setKey("roominfo_contact_anchor");
      this.screen.b(this.vKG);
      paramf = new PreferenceCategory(this.context);
      this.screen.b(paramf);
      paramf = new NormalUserFooterPreference(this.context);
      paramf.setLayoutResource(2131493625);
      paramf.setKey("contact_info_footer_normal");
      if (paramf.a(this.contact, "", this.vIS, this.vIT, false, this.iMg, this.vKF, false, false, 0L, "")) {
        this.screen.b(paramf);
      }
      this.vKG.a(this.screen, this.vKG.mKey);
      paramf = q.vZ(this.roomId);
      this.vKG.vc(false).vd(false);
      this.vKG.y(this.roomId, paramf);
      this.vKG.a(new ContactListExpandPreference.a()
      {
        public final void a(ViewGroup paramAnonymousViewGroup, View paramAnonymousView, int paramAnonymousInt) {}
        
        public final void b(ViewGroup paramAnonymousViewGroup, View paramAnonymousView, int paramAnonymousInt)
        {
          AppMethodBeat.i(196011);
          if (h.this.vKG.Xa(paramAnonymousInt))
          {
            paramAnonymousView = h.this.vKG.Xb(paramAnonymousInt);
            if (bs.isNullOrNil(paramAnonymousView))
            {
              AppMethodBeat.o(196011);
              return;
            }
            paramAnonymousViewGroup = new Intent();
            paramAnonymousViewGroup.setClass(h.this.context, ContactInfoUI.class);
            paramAnonymousViewGroup.putExtra("Contact_User", paramAnonymousView);
            paramAnonymousViewGroup.putExtra("Contact_RoomNickname", h.this.ftP.wk(paramAnonymousView));
            paramAnonymousView = h.this.context;
            paramAnonymousViewGroup = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousViewGroup);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousViewGroup.aeD(), "com/tencent/mm/plugin/profile/ui/ContactWidgetGroupCard$1", "onItemNormalClick", "(Landroid/view/ViewGroup;Landroid/view/View;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)paramAnonymousViewGroup.lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/profile/ui/ContactWidgetGroupCard$1", "onItemNormalClick", "(Landroid/view/ViewGroup;Landroid/view/View;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          AppMethodBeat.o(196011);
        }
        
        public final void c(ViewGroup paramAnonymousViewGroup, View paramAnonymousView, int paramAnonymousInt) {}
        
        public final void d(ViewGroup paramAnonymousViewGroup, View paramAnonymousView) {}
        
        public final void e(ViewGroup paramAnonymousViewGroup, View paramAnonymousView) {}
      });
      AppMethodBeat.o(27150);
      return true;
      bool = false;
      break;
      bool = false;
      break label34;
    }
  }
  
  public final boolean bYJ()
  {
    AppMethodBeat.i(27151);
    NormalUserFooterPreference localNormalUserFooterPreference = (NormalUserFooterPreference)this.screen.aPN("contact_info_footer_normal");
    if (localNormalUserFooterPreference != null) {
      localNormalUserFooterPreference.bYJ();
    }
    AppMethodBeat.o(27151);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.h
 * JD-Core Version:    0.7.0.1
 */