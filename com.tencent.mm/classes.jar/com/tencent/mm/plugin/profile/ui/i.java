package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.i;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.contact.d;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.f;
import junit.framework.Assert;

public final class i
  implements com.tencent.mm.pluginsdk.c.a
{
  private boolean MVt;
  private boolean MVu;
  private int MXu;
  ContactListExpandPreference MXv;
  private au contact;
  Context context;
  aj lzy;
  private int pUt;
  private String roomId;
  private f screen;
  
  public i(Context paramContext)
  {
    AppMethodBeat.i(27148);
    this.context = paramContext;
    this.MXv = new ContactListExpandPreference(paramContext, 0);
    AppMethodBeat.o(27148);
  }
  
  public final boolean a(f paramf, au paramau, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(27150);
    boolean bool1;
    label34:
    label46:
    boolean bool2;
    int i;
    if (paramau != null)
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      if (Util.nullAsNil(paramau.field_username).length() <= 0) {
        break label417;
      }
      bool1 = true;
      Assert.assertTrue(bool1);
      if (paramf == null) {
        break label423;
      }
      bool1 = true;
      Assert.assertTrue(bool1);
      this.screen = paramf;
      this.contact = paramau;
      this.MVt = paramBoolean;
      this.pUt = paramInt;
      this.MVu = ((Activity)this.context).getIntent().getBooleanExtra("User_Verify", false);
      this.MXu = ((Activity)this.context).getIntent().getIntExtra("Kdel_from", -1);
      this.roomId = paramau.field_username;
      bh.bCz();
      this.lzy = c.bzK().Jv(this.roomId);
      this.screen.removeAll();
      paramf = new PreferenceSmallCategory(this.context);
      this.screen.c(paramf);
      this.MXv.setKey("roominfo_contact_anchor");
      this.screen.c(this.MXv);
      paramf = new PreferenceCategory(this.context);
      this.screen.c(paramf);
      paramf = new NormalUserFooterPreference(this.context);
      paramf.setLayoutResource(R.i.gif);
      paramf.setKey("contact_info_footer_normal");
      paramau = this.contact;
      bool2 = this.MVt;
      bool1 = this.MVu;
      paramInt = this.pUt;
      i = this.MXu;
      paramf.dvq();
      if (paramau == null) {
        break label429;
      }
      paramBoolean = true;
      label280:
      Assert.assertTrue(paramBoolean);
      if (Util.nullAsNil(paramau.field_username).length() <= 0) {
        break label434;
      }
    }
    label417:
    label423:
    label429:
    label434:
    for (paramBoolean = true;; paramBoolean = false)
    {
      Assert.assertTrue(paramBoolean);
      if (!au.bxd(z.bAM()).equals(paramau.field_username)) {
        break label439;
      }
      paramInt = 0;
      if (paramInt != 0) {
        this.screen.c(paramf);
      }
      this.MXv.a(this.screen, this.MXv.mKey);
      paramf = v.Il(this.roomId);
      this.MXv.JJ(false).JK(false);
      this.MXv.y(this.roomId, paramf);
      this.MXv.a(new ContactListExpandPreference.a()
      {
        public final void aMI() {}
        
        public final void e(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
        {
          AppMethodBeat.i(305439);
          if (i.this.MXv.awt(paramAnonymousInt))
          {
            Object localObject = i.this.MXv.awu(paramAnonymousInt);
            if (Util.isNullOrNil((String)localObject))
            {
              AppMethodBeat.o(305439);
              return;
            }
            paramAnonymousViewGroup = new Intent();
            paramAnonymousViewGroup.setClass(i.this.context, ContactInfoUI.class);
            paramAnonymousViewGroup.putExtra("Contact_User", (String)localObject);
            paramAnonymousViewGroup.putExtra("Contact_RoomNickname", i.this.lzy.getDisplayName((String)localObject));
            localObject = i.this.context;
            paramAnonymousViewGroup = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousViewGroup);
            com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousViewGroup.aYi(), "com/tencent/mm/plugin/profile/ui/ContactWidgetGroupCard$1", "onItemNormalClick", "(Landroid/view/ViewGroup;Landroid/view/View;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((Context)localObject).startActivity((Intent)paramAnonymousViewGroup.sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/profile/ui/ContactWidgetGroupCard$1", "onItemNormalClick", "(Landroid/view/ViewGroup;Landroid/view/View;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          AppMethodBeat.o(305439);
        }
        
        public final void qw(int paramAnonymousInt) {}
        
        public final void qx(int paramAnonymousInt) {}
      });
      AppMethodBeat.o(27150);
      return true;
      bool1 = false;
      break;
      bool1 = false;
      break label34;
      bool1 = false;
      break label46;
      paramBoolean = false;
      break label280;
    }
    label439:
    paramf.contact = paramau;
    paramf.pPi = "";
    paramf.MVt = bool2;
    paramf.pUt = paramInt;
    paramf.MXu = i;
    paramf.MZc = Util.nullAs(Boolean.valueOf(ab.IQ(paramau.field_username)), false);
    paramf.MUD = false;
    paramf.MYZ = false;
    paramf.MXS = 0L;
    paramf.MZa = "";
    paramf.MZw = false;
    if (paramau.field_deleteFlag == 1)
    {
      paramBoolean = true;
      label522:
      paramf.MZb = paramBoolean;
      paramf.MZv = paramf.lzt.getIntent().getBooleanExtra("Contact_AlwaysShowSnsPreBtn", false);
      paramf.MXc = paramf.lzt.getIntent().getIntExtra("add_more_friend_search_scene", 0);
      paramf.MZd = paramf.lzt.getIntent().getBooleanExtra("Contact_IsLbsChattingProfile", false);
      paramf.MZe = paramf.lzt.getIntent().getBooleanExtra("Contact_IsLbsGotoChatting", false);
      paramf.vsZ = paramf.lzt.getIntent().getStringExtra("lbs_ticket");
      if (!z.Iy(paramau.field_username))
      {
        bh.bCz();
        if (!c.bzJ().has(paramau.field_username)) {
          break label677;
        }
      }
      paramf.MZf = new NormalUserFooterPreference.c(paramf);
      paramf.MZw = true;
    }
    for (;;)
    {
      paramf.initView();
      paramInt = 1;
      break;
      paramBoolean = false;
      break label522;
      label677:
      if (au.bwL(paramau.field_username))
      {
        paramf.MZf = new NormalUserFooterPreference.h(paramf);
      }
      else if (au.bwc(paramau.field_username))
      {
        paramf.MZf = new NormalUserFooterPreference.d(paramf);
      }
      else if (ab.IQ(paramau.field_username))
      {
        paramf.MZf = new NormalUserFooterPreference.g(paramf);
      }
      else if (au.bwM(paramau.field_username))
      {
        paramf.MZf = new NormalUserFooterPreference.f(paramf);
      }
      else if ((d.rs(paramau.field_type)) && (!au.bwS(paramau.field_username)))
      {
        paramf.MZf = new NormalUserFooterPreference.c(paramf);
        paramf.MZw = true;
      }
      else if (bool1)
      {
        paramf.MZf = new NormalUserFooterPreference.j(paramf);
        paramf.MZw = true;
      }
      else if (au.bwS(paramau.field_username))
      {
        paramf.MZf = new NormalUserFooterPreference.b(paramf);
      }
      else
      {
        paramf.MZf = new NormalUserFooterPreference.c(paramf);
        paramf.MZw = true;
      }
    }
  }
  
  public final boolean anl(String paramString)
  {
    AppMethodBeat.i(27149);
    Log.d("MicroMsg.ContactWidgetGroupCard", "handleEvent ".concat(String.valueOf(paramString)));
    bh.bCz();
    Object localObject = c.bzA().JE(paramString);
    if ((localObject == null) || ((int)((d)localObject).maN <= 0))
    {
      AppMethodBeat.o(27149);
      return true;
    }
    paramString = new Intent();
    paramString.setClass(this.context, ContactInfoUI.class);
    paramString.putExtra("Contact_User", ((az)localObject).field_username);
    localObject = this.context;
    paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
    com.tencent.mm.hellhoundlib.a.a.b(localObject, paramString.aYi(), "com/tencent/mm/plugin/profile/ui/ContactWidgetGroupCard", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((Context)localObject).startActivity((Intent)paramString.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/profile/ui/ContactWidgetGroupCard", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(27149);
    return true;
  }
  
  public final boolean dvq()
  {
    AppMethodBeat.i(27151);
    NormalUserFooterPreference localNormalUserFooterPreference = (NormalUserFooterPreference)this.screen.bAi("contact_info_footer_normal");
    if (localNormalUserFooterPreference != null) {
      localNormalUserFooterPreference.dvq();
    }
    AppMethodBeat.o(27151);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.i
 * JD-Core Version:    0.7.0.1
 */