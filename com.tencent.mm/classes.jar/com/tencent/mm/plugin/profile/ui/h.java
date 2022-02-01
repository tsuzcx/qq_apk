package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.i;
import com.tencent.mm.contact.d;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.f;
import junit.framework.Assert;

public final class h
  implements com.tencent.mm.pluginsdk.c.a
{
  private boolean GXw;
  private boolean GXx;
  private int GZr;
  ContactListExpandPreference GZs;
  private as contact;
  Context context;
  ah iXp;
  private int mXL;
  private String roomId;
  private f screen;
  
  public h(Context paramContext)
  {
    AppMethodBeat.i(27148);
    this.context = paramContext;
    this.GZs = new ContactListExpandPreference(paramContext, 0);
    AppMethodBeat.o(27148);
  }
  
  public final boolean a(f paramf, as paramas, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(27150);
    boolean bool1;
    label34:
    label46:
    boolean bool2;
    int i;
    if (paramas != null)
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      if (Util.nullAsNil(paramas.field_username).length() <= 0) {
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
      this.contact = paramas;
      this.GXw = paramBoolean;
      this.mXL = paramInt;
      this.GXx = ((Activity)this.context).getIntent().getBooleanExtra("User_Verify", false);
      this.GZr = ((Activity)this.context).getIntent().getIntExtra("Kdel_from", -1);
      this.roomId = paramas.field_username;
      bh.beI();
      this.iXp = c.bbV().Rx(this.roomId);
      this.screen.removeAll();
      paramf = new PreferenceSmallCategory(this.context);
      this.screen.b(paramf);
      this.GZs.setKey("roominfo_contact_anchor");
      this.screen.b(this.GZs);
      paramf = new PreferenceCategory(this.context);
      this.screen.b(paramf);
      paramf = new NormalUserFooterPreference(this.context);
      paramf.setLayoutResource(R.i.efj);
      paramf.setKey("contact_info_footer_normal");
      paramas = this.contact;
      bool2 = this.GXw;
      bool1 = this.GXx;
      paramInt = this.mXL;
      i = this.GZr;
      paramf.cQX();
      if (paramas == null) {
        break label429;
      }
      paramBoolean = true;
      label280:
      Assert.assertTrue(paramBoolean);
      if (Util.nullAsNil(paramas.field_username).length() <= 0) {
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
      if (!as.bvW(z.bcZ()).equals(paramas.field_username)) {
        break label439;
      }
      paramInt = 0;
      if (paramInt != 0) {
        this.screen.b(paramf);
      }
      this.GZs.a(this.screen, this.GZs.mKey);
      paramf = v.Ps(this.roomId);
      this.GZs.DZ(false).Ea(false);
      this.GZs.s(this.roomId, paramf);
      this.GZs.a(new ContactListExpandPreference.a()
      {
        public final void asG() {}
        
        public final void e(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
        {
          AppMethodBeat.i(275601);
          if (h.this.GZs.aqp(paramAnonymousInt))
          {
            Object localObject = h.this.GZs.aqq(paramAnonymousInt);
            if (Util.isNullOrNil((String)localObject))
            {
              AppMethodBeat.o(275601);
              return;
            }
            paramAnonymousViewGroup = new Intent();
            paramAnonymousViewGroup.setClass(h.this.context, ContactInfoUI.class);
            paramAnonymousViewGroup.putExtra("Contact_User", (String)localObject);
            paramAnonymousViewGroup.putExtra("Contact_RoomNickname", h.this.iXp.PJ((String)localObject));
            localObject = h.this.context;
            paramAnonymousViewGroup = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousViewGroup);
            com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousViewGroup.aFh(), "com/tencent/mm/plugin/profile/ui/ContactWidgetGroupCard$1", "onItemNormalClick", "(Landroid/view/ViewGroup;Landroid/view/View;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((Context)localObject).startActivity((Intent)paramAnonymousViewGroup.sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/profile/ui/ContactWidgetGroupCard$1", "onItemNormalClick", "(Landroid/view/ViewGroup;Landroid/view/View;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          AppMethodBeat.o(275601);
        }
        
        public final void qv(int paramAnonymousInt) {}
        
        public final void qw(int paramAnonymousInt) {}
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
    paramf.contact = paramas;
    paramf.BLy = "";
    paramf.GXw = bool2;
    paramf.mXL = paramInt;
    paramf.GZr = i;
    paramf.HaV = Util.nullAs(Boolean.valueOf(ab.Qj(paramas.field_username)), false);
    paramf.GWK = false;
    paramf.HaS = false;
    paramf.GZN = 0L;
    paramf.HaT = "";
    paramf.Hbp = false;
    if (paramas.field_deleteFlag == 1)
    {
      paramBoolean = true;
      label522:
      paramf.HaU = paramBoolean;
      paramf.Hbo = paramf.iXq.getIntent().getBooleanExtra("Contact_AlwaysShowSnsPreBtn", false);
      paramf.GYZ = paramf.iXq.getIntent().getIntExtra("add_more_friend_search_scene", 0);
      paramf.HaW = paramf.iXq.getIntent().getBooleanExtra("Contact_IsLbsChattingProfile", false);
      paramf.HaX = paramf.iXq.getIntent().getBooleanExtra("Contact_IsLbsGotoChatting", false);
      paramf.she = paramf.iXq.getIntent().getStringExtra("lbs_ticket");
      if (!z.PD(paramas.field_username))
      {
        bh.beI();
        if (!c.bbU().has(paramas.field_username)) {
          break label677;
        }
      }
      paramf.HaY = new NormalUserFooterPreference.c(paramf);
      paramf.Hbp = true;
    }
    for (;;)
    {
      paramf.initView();
      paramInt = 1;
      break;
      paramBoolean = false;
      break label522;
      label677:
      if (as.bvH(paramas.field_username))
      {
        paramf.HaY = new NormalUserFooterPreference.h(paramf);
      }
      else if (ab.Qy(paramas.field_username))
      {
        paramf.HaY = new NormalUserFooterPreference.d(paramf);
      }
      else if (ab.Qj(paramas.field_username))
      {
        paramf.HaY = new NormalUserFooterPreference.g(paramf);
      }
      else if (as.bvI(paramas.field_username))
      {
        paramf.HaY = new NormalUserFooterPreference.f(paramf);
      }
      else if ((d.rk(paramas.field_type)) && (!as.PY(paramas.field_username)))
      {
        paramf.HaY = new NormalUserFooterPreference.c(paramf);
        paramf.Hbp = true;
      }
      else if (bool1)
      {
        paramf.HaY = new NormalUserFooterPreference.j(paramf);
        paramf.Hbp = true;
      }
      else if (as.PY(paramas.field_username))
      {
        paramf.HaY = new NormalUserFooterPreference.b(paramf);
      }
      else
      {
        paramf.HaY = new NormalUserFooterPreference.c(paramf);
        paramf.Hbp = true;
      }
    }
  }
  
  public final boolean atw(String paramString)
  {
    AppMethodBeat.i(27149);
    Log.d("MicroMsg.ContactWidgetGroupCard", "handleEvent ".concat(String.valueOf(paramString)));
    bh.beI();
    Object localObject = c.bbL().RG(paramString);
    if ((localObject == null) || ((int)((d)localObject).jxt <= 0))
    {
      AppMethodBeat.o(27149);
      return true;
    }
    paramString = new Intent();
    paramString.setClass(this.context, ContactInfoUI.class);
    paramString.putExtra("Contact_User", ((ax)localObject).field_username);
    localObject = this.context;
    paramString = new com.tencent.mm.hellhoundlib.b.a().bm(paramString);
    com.tencent.mm.hellhoundlib.a.a.b(localObject, paramString.aFh(), "com/tencent/mm/plugin/profile/ui/ContactWidgetGroupCard", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((Context)localObject).startActivity((Intent)paramString.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/profile/ui/ContactWidgetGroupCard", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(27149);
    return true;
  }
  
  public final boolean cQX()
  {
    AppMethodBeat.i(27151);
    NormalUserFooterPreference localNormalUserFooterPreference = (NormalUserFooterPreference)this.screen.byG("contact_info_footer_normal");
    if (localNormalUserFooterPreference != null) {
      localNormalUserFooterPreference.cQX();
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