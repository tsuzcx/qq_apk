package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.n;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.f;
import junit.framework.Assert;

public final class h
  implements com.tencent.mm.pluginsdk.b.a
{
  private ad contact;
  Context context;
  private String eeu;
  u efi;
  private int gyR;
  private int pAe;
  ContactListExpandPreference pAf;
  private boolean pyp;
  private boolean pyq;
  private f screen;
  
  public h(Context paramContext)
  {
    AppMethodBeat.i(23533);
    this.context = paramContext;
    this.pAf = new ContactListExpandPreference(paramContext, 0);
    AppMethodBeat.o(23533);
  }
  
  public final boolean Ke(String paramString)
  {
    AppMethodBeat.i(23534);
    ab.d("MicroMsg.ContactWidgetGroupCard", "handleEvent ".concat(String.valueOf(paramString)));
    aw.aaz();
    paramString = c.YA().arw(paramString);
    if ((paramString == null) || ((int)paramString.euF <= 0))
    {
      AppMethodBeat.o(23534);
      return true;
    }
    Intent localIntent = new Intent();
    localIntent.setClass(this.context, ContactInfoUI.class);
    localIntent.putExtra("Contact_User", paramString.field_username);
    this.context.startActivity(localIntent);
    AppMethodBeat.o(23534);
    return true;
  }
  
  public final boolean a(f paramf, ad paramad, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(23535);
    if (paramad != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (bo.nullAsNil(paramad.field_username).length() <= 0) {
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
      this.contact = paramad;
      this.pyp = paramBoolean;
      this.gyR = paramInt;
      this.pyq = ((Activity)this.context).getIntent().getBooleanExtra("User_Verify", false);
      this.pAe = ((Activity)this.context).getIntent().getIntExtra("Kdel_from", -1);
      this.eeu = paramad.field_username;
      aw.aaz();
      this.efi = c.YJ().oV(this.eeu);
      this.screen.removeAll();
      paramf = new PreferenceSmallCategory(this.context);
      this.screen.b(paramf);
      this.pAf.setKey("roominfo_contact_anchor");
      this.screen.b(this.pAf);
      paramf = new PreferenceCategory(this.context);
      this.screen.b(paramf);
      paramf = new NormalUserFooterPreference(this.context);
      paramf.setLayoutResource(2130969237);
      paramf.setKey("contact_info_footer_normal");
      if (paramf.a(this.contact, "", this.pyp, this.pyq, false, this.gyR, this.pAe, false, false, 0L, "")) {
        this.screen.b(paramf);
      }
      this.pAf.a(this.screen, this.pAf.mKey);
      paramf = n.nt(this.eeu);
      this.pAf.pf(false).pg(false);
      this.pAf.v(this.eeu, paramf);
      this.pAf.a(new h.1(this));
      AppMethodBeat.o(23535);
      return true;
      bool = false;
      break;
      bool = false;
      break label34;
    }
  }
  
  public final boolean bkb()
  {
    AppMethodBeat.i(23536);
    NormalUserFooterPreference localNormalUserFooterPreference = (NormalUserFooterPreference)this.screen.atx("contact_info_footer_normal");
    if (localNormalUserFooterPreference != null) {
      localNormalUserFooterPreference.bkb();
    }
    AppMethodBeat.o(23536);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.h
 * JD-Core Version:    0.7.0.1
 */