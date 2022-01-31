package com.tencent.mm.plugin.qmessage.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.g;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;
import java.util.Timer;
import junit.framework.Assert;

public final class b
  implements com.tencent.mm.pluginsdk.b.a, n.b
{
  private ad contact;
  Context context;
  private boolean pyp;
  private f screen;
  
  public b(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private static boolean BT(int paramInt)
  {
    AppMethodBeat.i(24113);
    if ((r.Zr() & paramInt) != 0)
    {
      AppMethodBeat.o(24113);
      return true;
    }
    AppMethodBeat.o(24113);
    return false;
  }
  
  static void f(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(24116);
    int i = r.Zr();
    if (paramBoolean)
    {
      paramInt1 = i | paramInt1;
      aw.aaz();
      c.Ru().set(7, Integer.valueOf(paramInt1));
      if (!paramBoolean) {
        break label77;
      }
    }
    label77:
    for (paramInt1 = 1;; paramInt1 = 2)
    {
      aw.aaz();
      c.Yz().c(new g(paramInt2, paramInt1));
      AppMethodBeat.o(24116);
      return;
      paramInt1 = i & (paramInt1 ^ 0xFFFFFFFF);
      break;
    }
  }
  
  private static boolean isOpen()
  {
    AppMethodBeat.i(24112);
    if ((r.Zy() & 0x20) == 0)
    {
      AppMethodBeat.o(24112);
      return true;
    }
    AppMethodBeat.o(24112);
    return false;
  }
  
  public static void u(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(24111);
    if (paramBoolean) {}
    for (Object localObject = paramContext.getString(2131303380);; localObject = paramContext.getString(2131303388))
    {
      paramContext.getString(2131297087);
      paramContext = h.b(paramContext, (String)localObject, true, null);
      localObject = new b.7(paramBoolean);
      new Timer().schedule(new b.8(paramContext, (ak)localObject), 5000L);
      AppMethodBeat.o(24111);
      return;
    }
  }
  
  public final boolean Ke(String paramString)
  {
    AppMethodBeat.i(24110);
    ab.d("MicroMsg.ContactWidgetQMessage", "handleEvent : key = ".concat(String.valueOf(paramString)));
    if (bo.nullAsNil(paramString).length() <= 0)
    {
      AppMethodBeat.o(24110);
      return false;
    }
    if (paramString.equals("contact_info_view_message"))
    {
      paramString = new Intent(this.context, QConversationUI.class);
      if (this.pyp) {
        ((Activity)this.context).setResult(-1, paramString);
      }
      for (;;)
      {
        ((Activity)this.context).finish();
        AppMethodBeat.o(24110);
        return true;
        this.context.startActivity(paramString);
      }
    }
    if (paramString.equals("contact_info_qmessage_recv_offline_msg"))
    {
      paramString = (CheckBoxPreference)this.screen.atx(paramString);
      if (paramString.isChecked()) {
        f(64, true, 5);
      }
      for (;;)
      {
        AppMethodBeat.o(24110);
        return true;
        if (!BT(8192))
        {
          f(64, false, 5);
          AppMethodBeat.o(24110);
          return true;
        }
        h.a(this.context, 2131298694, 2131297087, new b.1(this), new b.2(this, paramString));
      }
    }
    if (paramString.equals("contact_info_qmessage_display_weixin_online"))
    {
      f(8192, ((CheckBoxPreference)this.screen.atx(paramString)).isChecked(), 12);
      AppMethodBeat.o(24110);
      return true;
    }
    if (paramString.equals("contact_info_qmessage_clear_data"))
    {
      h.d(this.context, this.context.getString(2131298571), "", this.context.getString(2131296891), this.context.getString(2131296888), new b.3(this), null);
      AppMethodBeat.o(24110);
      return true;
    }
    if (paramString.equals("contact_info_qmessage_install"))
    {
      aw.aaz();
      if (bo.g((Integer)c.Ru().get(9, null)) == 0)
      {
        h.b(this.context, 2131303526, new b.4(this), new b.5(this));
        AppMethodBeat.o(24110);
        return true;
      }
      u(this.context, true);
      AppMethodBeat.o(24110);
      return true;
    }
    if (paramString.equals("contact_info_qmessage_uninstall"))
    {
      h.d(this.context, this.context.getString(2131303384), "", this.context.getString(2131296891), this.context.getString(2131296888), new b.6(this), null);
      AppMethodBeat.o(24110);
      return true;
    }
    ab.e("MicroMsg.ContactWidgetQMessage", "handleEvent : unExpected key = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(24110);
    return false;
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(24118);
    aw.aaz();
    if (paramn != c.Ru())
    {
      AppMethodBeat.o(24118);
      return;
    }
    bkc();
    AppMethodBeat.o(24118);
  }
  
  public final boolean a(f paramf, ad paramad, boolean paramBoolean, int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(24114);
    if (paramad != null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      Assert.assertTrue(t.ob(paramad.field_username));
      bool1 = bool2;
      if (paramf != null) {
        bool1 = true;
      }
      Assert.assertTrue(bool1);
      aw.aaz();
      c.Ru().a(this);
      this.contact = paramad;
      this.pyp = paramBoolean;
      this.screen = paramf;
      bkc();
      AppMethodBeat.o(24114);
      return true;
    }
  }
  
  public final boolean bkb()
  {
    AppMethodBeat.i(24117);
    aw.aaz();
    c.Ru().b(this);
    com.tencent.mm.plugin.qmessage.a.pHJ.BO();
    AppMethodBeat.o(24117);
    return true;
  }
  
  final void bkc()
  {
    AppMethodBeat.i(24115);
    boolean bool1 = isOpen();
    boolean bool2 = BT(64);
    BT(8192);
    this.screen.removeAll();
    this.screen.addPreferencesFromResource(2131165216);
    HelperHeaderPreference localHelperHeaderPreference = (HelperHeaderPreference)this.screen.atx("contact_info_header_helper");
    localHelperHeaderPreference.aB(this.contact.field_username, this.contact.Of(), this.context.getString(2131298697));
    if (bool1) {}
    for (int i = 1;; i = 0)
    {
      localHelperHeaderPreference.sb(i);
      if (bool1) {
        break;
      }
      this.screen.aty("contact_info_view_message");
      this.screen.aty("contact_info_qmessage_recv_offline_msg");
      this.screen.aty("contact_info_qmessage_uninstall");
      this.screen.aty("contact_info_qmessage_clear_data");
      AppMethodBeat.o(24115);
      return;
    }
    this.screen.aty("contact_info_qmessage_install");
    ((CheckBoxPreference)this.screen.atx("contact_info_qmessage_recv_offline_msg")).vxW = bool2;
    AppMethodBeat.o(24115);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.ui.b
 * JD-Core Version:    0.7.0.1
 */