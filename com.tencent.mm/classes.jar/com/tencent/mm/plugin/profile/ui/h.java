package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.n.b;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.f;
import junit.framework.Assert;

public final class h
  implements com.tencent.mm.pluginsdk.b.a
{
  private af contact;
  Context context;
  w fql;
  private int ima;
  private String roomId;
  private f screen;
  private boolean uAa;
  private int uBM;
  ContactListExpandPreference uBN;
  private boolean uzZ;
  
  public h(Context paramContext)
  {
    AppMethodBeat.i(27148);
    this.context = paramContext;
    this.uBN = new ContactListExpandPreference(paramContext, 0);
    AppMethodBeat.o(27148);
  }
  
  public final boolean SN(String paramString)
  {
    AppMethodBeat.i(27149);
    ad.d("MicroMsg.ContactWidgetGroupCard", "handleEvent ".concat(String.valueOf(paramString)));
    az.arV();
    Object localObject = c.apM().aHY(paramString);
    if ((localObject == null) || ((int)((b)localObject).fId <= 0))
    {
      AppMethodBeat.o(27149);
      return true;
    }
    paramString = new Intent();
    paramString.setClass(this.context, ContactInfoUI.class);
    paramString.putExtra("Contact_User", ((au)localObject).field_username);
    localObject = this.context;
    paramString = new com.tencent.mm.hellhoundlib.b.a().bd(paramString);
    com.tencent.mm.hellhoundlib.a.a.a(localObject, paramString.adn(), "com/tencent/mm/plugin/profile/ui/ContactWidgetGroupCard", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((Context)localObject).startActivity((Intent)paramString.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/profile/ui/ContactWidgetGroupCard", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(27149);
    return true;
  }
  
  public final boolean a(f paramf, af paramaf, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(27150);
    if (paramaf != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (bt.nullAsNil(paramaf.field_username).length() <= 0) {
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
      this.contact = paramaf;
      this.uzZ = paramBoolean;
      this.ima = paramInt;
      this.uAa = ((Activity)this.context).getIntent().getBooleanExtra("User_Verify", false);
      this.uBM = ((Activity)this.context).getIntent().getIntExtra("Kdel_from", -1);
      this.roomId = paramaf.field_username;
      az.arV();
      this.fql = c.apV().tI(this.roomId);
      this.screen.removeAll();
      paramf = new PreferenceSmallCategory(this.context);
      this.screen.b(paramf);
      this.uBN.setKey("roominfo_contact_anchor");
      this.screen.b(this.uBN);
      paramf = new PreferenceCategory(this.context);
      this.screen.b(paramf);
      paramf = new NormalUserFooterPreference(this.context);
      paramf.setLayoutResource(2131493625);
      paramf.setKey("contact_info_footer_normal");
      if (paramf.a(this.contact, "", this.uzZ, this.uAa, false, this.ima, this.uBM, false, false, 0L, "")) {
        this.screen.b(paramf);
      }
      this.uBN.a(this.screen, this.uBN.mKey);
      paramf = q.rW(this.roomId);
      this.uBN.ub(false).uc(false);
      this.uBN.B(this.roomId, paramf);
      this.uBN.a(new ContactListExpandPreference.a()
      {
        public final void b(ViewGroup paramAnonymousViewGroup, View paramAnonymousView, int paramAnonymousInt) {}
        
        public final void c(ViewGroup paramAnonymousViewGroup, View paramAnonymousView, int paramAnonymousInt)
        {
          AppMethodBeat.i(204852);
          if (h.this.uBN.UR(paramAnonymousInt))
          {
            paramAnonymousView = h.this.uBN.US(paramAnonymousInt);
            if (bt.isNullOrNil(paramAnonymousView))
            {
              AppMethodBeat.o(204852);
              return;
            }
            paramAnonymousViewGroup = new Intent();
            paramAnonymousViewGroup.setClass(h.this.context, ContactInfoUI.class);
            paramAnonymousViewGroup.putExtra("Contact_User", paramAnonymousView);
            paramAnonymousViewGroup.putExtra("Contact_RoomNickname", h.this.fql.sh(paramAnonymousView));
            paramAnonymousView = h.this.context;
            paramAnonymousViewGroup = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymousViewGroup);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousViewGroup.adn(), "com/tencent/mm/plugin/profile/ui/ContactWidgetGroupCard$1", "onItemNormalClick", "(Landroid/view/ViewGroup;Landroid/view/View;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)paramAnonymousViewGroup.lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/profile/ui/ContactWidgetGroupCard$1", "onItemNormalClick", "(Landroid/view/ViewGroup;Landroid/view/View;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          AppMethodBeat.o(204852);
        }
        
        public final void d(ViewGroup paramAnonymousViewGroup, View paramAnonymousView) {}
        
        public final void d(ViewGroup paramAnonymousViewGroup, View paramAnonymousView, int paramAnonymousInt) {}
        
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
  
  public final boolean bRu()
  {
    AppMethodBeat.i(27151);
    NormalUserFooterPreference localNormalUserFooterPreference = (NormalUserFooterPreference)this.screen.aKk("contact_info_footer_normal");
    if (localNormalUserFooterPreference != null) {
      localNormalUserFooterPreference.bRu();
    }
    AppMethodBeat.o(27151);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.h
 * JD-Core Version:    0.7.0.1
 */