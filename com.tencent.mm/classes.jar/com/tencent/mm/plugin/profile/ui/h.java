package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.al;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.r;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.f;
import junit.framework.Assert;

public final class h
  implements com.tencent.mm.pluginsdk.b.a
{
  private an contact;
  Context context;
  ac fNS;
  private int jij;
  private String roomId;
  private f screen;
  private boolean xfQ;
  private boolean xfR;
  private int xhF;
  ContactListExpandPreference xhG;
  
  public h(Context paramContext)
  {
    AppMethodBeat.i(27148);
    this.context = paramContext;
    this.xhG = new ContactListExpandPreference(paramContext, 0);
    AppMethodBeat.o(27148);
  }
  
  public final boolean a(f paramf, an paraman, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(27150);
    if (paraman != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (bu.nullAsNil(paraman.field_username).length() <= 0) {
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
      this.contact = paraman;
      this.xfQ = paramBoolean;
      this.jij = paramInt;
      this.xfR = ((Activity)this.context).getIntent().getBooleanExtra("User_Verify", false);
      this.xhF = ((Activity)this.context).getIntent().getIntExtra("Kdel_from", -1);
      this.roomId = paraman.field_username;
      bc.aCg();
      this.fNS = com.tencent.mm.model.c.azP().By(this.roomId);
      this.screen.removeAll();
      paramf = new PreferenceSmallCategory(this.context);
      this.screen.b(paramf);
      this.xhG.setKey("roominfo_contact_anchor");
      this.screen.b(this.xhG);
      paramf = new PreferenceCategory(this.context);
      this.screen.b(paramf);
      paramf = new NormalUserFooterPreference(this.context);
      paramf.setLayoutResource(2131493625);
      paramf.setKey("contact_info_footer_normal");
      if (paramf.a(this.contact, "", this.xfQ, this.xfR, false, this.jij, this.xhF, false, false, 0L, "")) {
        this.screen.b(paramf);
      }
      this.xhG.a(this.screen, this.xhG.mKey);
      paramf = r.zA(this.roomId);
      this.xhG.vW(false).vX(false);
      this.xhG.B(this.roomId, paramf);
      this.xhG.a(new ContactListExpandPreference.a()
      {
        public final void YS() {}
        
        public final void e(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
        {
          AppMethodBeat.i(186528);
          if (h.this.xhG.ZC(paramAnonymousInt))
          {
            Object localObject = h.this.xhG.ZD(paramAnonymousInt);
            if (bu.isNullOrNil((String)localObject))
            {
              AppMethodBeat.o(186528);
              return;
            }
            paramAnonymousViewGroup = new Intent();
            paramAnonymousViewGroup.setClass(h.this.context, ContactInfoUI.class);
            paramAnonymousViewGroup.putExtra("Contact_User", (String)localObject);
            paramAnonymousViewGroup.putExtra("Contact_RoomNickname", h.this.fNS.zP((String)localObject));
            localObject = h.this.context;
            paramAnonymousViewGroup = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousViewGroup);
            com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousViewGroup.ahE(), "com/tencent/mm/plugin/profile/ui/ContactWidgetGroupCard$1", "onItemNormalClick", "(Landroid/view/ViewGroup;Landroid/view/View;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((Context)localObject).startActivity((Intent)paramAnonymousViewGroup.mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/profile/ui/ContactWidgetGroupCard$1", "onItemNormalClick", "(Landroid/view/ViewGroup;Landroid/view/View;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          AppMethodBeat.o(186528);
        }
        
        public final void le(int paramAnonymousInt) {}
        
        public final void lf(int paramAnonymousInt) {}
      });
      AppMethodBeat.o(27150);
      return true;
      bool = false;
      break;
      bool = false;
      break label34;
    }
  }
  
  public final boolean abx(String paramString)
  {
    AppMethodBeat.i(27149);
    ae.d("MicroMsg.ContactWidgetGroupCard", "handleEvent ".concat(String.valueOf(paramString)));
    bc.aCg();
    Object localObject = com.tencent.mm.model.c.azF().BH(paramString);
    if ((localObject == null) || ((int)((com.tencent.mm.contact.c)localObject).ght <= 0))
    {
      AppMethodBeat.o(27149);
      return true;
    }
    paramString = new Intent();
    paramString.setClass(this.context, ContactInfoUI.class);
    paramString.putExtra("Contact_User", ((aw)localObject).field_username);
    localObject = this.context;
    paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
    com.tencent.mm.hellhoundlib.a.a.a(localObject, paramString.ahE(), "com/tencent/mm/plugin/profile/ui/ContactWidgetGroupCard", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((Context)localObject).startActivity((Intent)paramString.mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/profile/ui/ContactWidgetGroupCard", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(27149);
    return true;
  }
  
  public final boolean ceC()
  {
    AppMethodBeat.i(27151);
    NormalUserFooterPreference localNormalUserFooterPreference = (NormalUserFooterPreference)this.screen.aXe("contact_info_footer_normal");
    if (localNormalUserFooterPreference != null) {
      localNormalUserFooterPreference.ceC();
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