package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.o.b;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.f;
import junit.framework.Assert;

public final class h
  implements com.tencent.mm.pluginsdk.b.a
{
  private am contact;
  Context context;
  ab fLO;
  private int jfq;
  private String roomId;
  private f screen;
  private boolean wPZ;
  private boolean wQa;
  private int wRO;
  ContactListExpandPreference wRP;
  
  public h(Context paramContext)
  {
    AppMethodBeat.i(27148);
    this.context = paramContext;
    this.wRP = new ContactListExpandPreference(paramContext, 0);
    AppMethodBeat.o(27148);
  }
  
  public final boolean a(f paramf, am paramam, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(27150);
    if (paramam != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (bt.nullAsNil(paramam.field_username).length() <= 0) {
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
      this.contact = paramam;
      this.wPZ = paramBoolean;
      this.jfq = paramInt;
      this.wQa = ((Activity)this.context).getIntent().getBooleanExtra("User_Verify", false);
      this.wRO = ((Activity)this.context).getIntent().getIntExtra("Kdel_from", -1);
      this.roomId = paramam.field_username;
      ba.aBQ();
      this.fLO = c.azz().AO(this.roomId);
      this.screen.removeAll();
      paramf = new PreferenceSmallCategory(this.context);
      this.screen.b(paramf);
      this.wRP.setKey("roominfo_contact_anchor");
      this.screen.b(this.wRP);
      paramf = new PreferenceCategory(this.context);
      this.screen.b(paramf);
      paramf = new NormalUserFooterPreference(this.context);
      paramf.setLayoutResource(2131493625);
      paramf.setKey("contact_info_footer_normal");
      if (paramf.a(this.contact, "", this.wPZ, this.wQa, false, this.jfq, this.wRO, false, false, 0L, "")) {
        this.screen.b(paramf);
      }
      this.wRP.a(this.screen, this.wRP.mKey);
      paramf = q.yQ(this.roomId);
      this.wRP.vO(false).vP(false);
      this.wRP.A(this.roomId, paramf);
      this.wRP.a(new ContactListExpandPreference.a()
      {
        public final void YJ() {}
        
        public final void e(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
        {
          AppMethodBeat.i(193254);
          if (h.this.wRP.YW(paramAnonymousInt))
          {
            Object localObject = h.this.wRP.YX(paramAnonymousInt);
            if (bt.isNullOrNil((String)localObject))
            {
              AppMethodBeat.o(193254);
              return;
            }
            paramAnonymousViewGroup = new Intent();
            paramAnonymousViewGroup.setClass(h.this.context, ContactInfoUI.class);
            paramAnonymousViewGroup.putExtra("Contact_User", (String)localObject);
            paramAnonymousViewGroup.putExtra("Contact_RoomNickname", h.this.fLO.zf((String)localObject));
            localObject = h.this.context;
            paramAnonymousViewGroup = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousViewGroup);
            com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousViewGroup.ahp(), "com/tencent/mm/plugin/profile/ui/ContactWidgetGroupCard$1", "onItemNormalClick", "(Landroid/view/ViewGroup;Landroid/view/View;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((Context)localObject).startActivity((Intent)paramAnonymousViewGroup.mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/profile/ui/ContactWidgetGroupCard$1", "onItemNormalClick", "(Landroid/view/ViewGroup;Landroid/view/View;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          AppMethodBeat.o(193254);
        }
        
        public final void lc(int paramAnonymousInt) {}
        
        public final void ld(int paramAnonymousInt) {}
      });
      AppMethodBeat.o(27150);
      return true;
      bool = false;
      break;
      bool = false;
      break label34;
    }
  }
  
  public final boolean aaG(String paramString)
  {
    AppMethodBeat.i(27149);
    ad.d("MicroMsg.ContactWidgetGroupCard", "handleEvent ".concat(String.valueOf(paramString)));
    ba.aBQ();
    Object localObject = c.azp().Bf(paramString);
    if ((localObject == null) || ((int)((b)localObject).gfj <= 0))
    {
      AppMethodBeat.o(27149);
      return true;
    }
    paramString = new Intent();
    paramString.setClass(this.context, ContactInfoUI.class);
    paramString.putExtra("Contact_User", ((aw)localObject).field_username);
    localObject = this.context;
    paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
    com.tencent.mm.hellhoundlib.a.a.a(localObject, paramString.ahp(), "com/tencent/mm/plugin/profile/ui/ContactWidgetGroupCard", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((Context)localObject).startActivity((Intent)paramString.mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/profile/ui/ContactWidgetGroupCard", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(27149);
    return true;
  }
  
  public final boolean cdn()
  {
    AppMethodBeat.i(27151);
    NormalUserFooterPreference localNormalUserFooterPreference = (NormalUserFooterPreference)this.screen.aVD("contact_info_footer_normal");
    if (localNormalUserFooterPreference != null) {
      localNormalUserFooterPreference.cdn();
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