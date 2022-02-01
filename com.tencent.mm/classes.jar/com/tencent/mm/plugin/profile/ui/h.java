package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.v;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.f;
import junit.framework.Assert;

public final class h
  implements com.tencent.mm.pluginsdk.b.a
{
  private boolean Bdx;
  private boolean Bdy;
  private int Bft;
  ContactListExpandPreference Bfu;
  private as contact;
  Context context;
  ah gtd;
  private int kgm;
  private String roomId;
  private f screen;
  
  public h(Context paramContext)
  {
    AppMethodBeat.i(27148);
    this.context = paramContext;
    this.Bfu = new ContactListExpandPreference(paramContext, 0);
    AppMethodBeat.o(27148);
  }
  
  public final boolean a(f paramf, as paramas, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(27150);
    if (paramas != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (Util.nullAsNil(paramas.field_username).length() <= 0) {
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
      this.contact = paramas;
      this.Bdx = paramBoolean;
      this.kgm = paramInt;
      this.Bdy = ((Activity)this.context).getIntent().getBooleanExtra("User_Verify", false);
      this.Bft = ((Activity)this.context).getIntent().getIntExtra("Kdel_from", -1);
      this.roomId = paramas.field_username;
      bg.aVF();
      this.gtd = com.tencent.mm.model.c.aSX().Ke(this.roomId);
      this.screen.removeAll();
      paramf = new PreferenceSmallCategory(this.context);
      this.screen.c(paramf);
      this.Bfu.setKey("roominfo_contact_anchor");
      this.screen.c(this.Bfu);
      paramf = new PreferenceCategory(this.context);
      this.screen.c(paramf);
      paramf = new NormalUserFooterPreference(this.context);
      paramf.setLayoutResource(2131493752);
      paramf.setKey("contact_info_footer_normal");
      if (paramf.a(this.contact, "", this.Bdx, this.Bdy, false, this.kgm, this.Bft, false, false, 0L, "")) {
        this.screen.c(paramf);
      }
      this.Bfu.a(this.screen, this.Bfu.mKey);
      paramf = v.Ic(this.roomId);
      this.Bfu.zU(false).zV(false);
      this.Bfu.H(this.roomId, paramf);
      this.Bfu.a(new ContactListExpandPreference.a()
      {
        public final void amF() {}
        
        public final void e(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
        {
          AppMethodBeat.i(231865);
          if (h.this.Bfu.ain(paramAnonymousInt))
          {
            Object localObject = h.this.Bfu.aio(paramAnonymousInt);
            if (Util.isNullOrNil((String)localObject))
            {
              AppMethodBeat.o(231865);
              return;
            }
            paramAnonymousViewGroup = new Intent();
            paramAnonymousViewGroup.setClass(h.this.context, ContactInfoUI.class);
            paramAnonymousViewGroup.putExtra("Contact_User", (String)localObject);
            paramAnonymousViewGroup.putExtra("Contact_RoomNickname", h.this.gtd.getDisplayName((String)localObject));
            localObject = h.this.context;
            paramAnonymousViewGroup = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousViewGroup);
            com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousViewGroup.axQ(), "com/tencent/mm/plugin/profile/ui/ContactWidgetGroupCard$1", "onItemNormalClick", "(Landroid/view/ViewGroup;Landroid/view/View;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((Context)localObject).startActivity((Intent)paramAnonymousViewGroup.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/profile/ui/ContactWidgetGroupCard$1", "onItemNormalClick", "(Landroid/view/ViewGroup;Landroid/view/View;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          AppMethodBeat.o(231865);
        }
        
        public final void og(int paramAnonymousInt) {}
        
        public final void oh(int paramAnonymousInt) {}
      });
      AppMethodBeat.o(27150);
      return true;
      bool = false;
      break;
      bool = false;
      break label34;
    }
  }
  
  public final boolean alD(String paramString)
  {
    AppMethodBeat.i(27149);
    Log.d("MicroMsg.ContactWidgetGroupCard", "handleEvent ".concat(String.valueOf(paramString)));
    bg.aVF();
    Object localObject = com.tencent.mm.model.c.aSN().Kn(paramString);
    if ((localObject == null) || ((int)((com.tencent.mm.contact.c)localObject).gMZ <= 0))
    {
      AppMethodBeat.o(27149);
      return true;
    }
    paramString = new Intent();
    paramString.setClass(this.context, ContactInfoUI.class);
    paramString.putExtra("Contact_User", ((ax)localObject).field_username);
    localObject = this.context;
    paramString = new com.tencent.mm.hellhoundlib.b.a().bl(paramString);
    com.tencent.mm.hellhoundlib.a.a.a(localObject, paramString.axQ(), "com/tencent/mm/plugin/profile/ui/ContactWidgetGroupCard", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((Context)localObject).startActivity((Intent)paramString.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/profile/ui/ContactWidgetGroupCard", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(27149);
    return true;
  }
  
  public final boolean cCs()
  {
    AppMethodBeat.i(27151);
    NormalUserFooterPreference localNormalUserFooterPreference = (NormalUserFooterPreference)this.screen.bmg("contact_info_footer_normal");
    if (localNormalUserFooterPreference != null) {
      localNormalUserFooterPreference.cCs();
    }
    AppMethodBeat.o(27151);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.h
 * JD-Core Version:    0.7.0.1
 */