package com.tencent.mm.plugin.qqmail.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.az.k;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.qqmail.b.ac;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import junit.framework.Assert;

public final class a
  implements com.tencent.mm.ai.f, com.tencent.mm.pluginsdk.b.a, n.b
{
  private static boolean pMA = false;
  private ad contact;
  private Context context;
  private ProgressDialog eeN;
  private boolean enable;
  private ProgressDialog fsw;
  private boolean pMz;
  private boolean pyp;
  private com.tencent.mm.ui.base.preference.f screen;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(68267);
    if (paramContext != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.context = paramContext;
      AppMethodBeat.o(68267);
      return;
    }
  }
  
  private void bkc()
  {
    boolean bool2 = true;
    AppMethodBeat.i(68270);
    label46:
    Object localObject;
    int i;
    if ((r.Zy() & 0x1) == 0)
    {
      bool1 = true;
      this.enable = bool1;
      if (bo.g((Integer)g.RL().Ru().get(17, null)) != 1) {
        break label336;
      }
      bool1 = true;
      this.pMz = bool1;
      localObject = (HelperHeaderPreference)this.screen.atx("contact_info_header_helper");
      ((HelperHeaderPreference)localObject).aB(this.contact.field_username, this.contact.Of(), this.context.getString(2131298709));
      if (!this.enable) {
        break label341;
      }
      i = 1;
      label107:
      ((HelperHeaderPreference)localObject).sb(i);
      this.screen.cl("contact_info_qqmailhelper_install", this.enable);
      localObject = this.screen;
      if (this.enable) {
        break label346;
      }
      bool1 = true;
      label143:
      ((com.tencent.mm.ui.base.preference.f)localObject).cl("contact_info_qqmailhelper_view", bool1);
      localObject = this.screen;
      if (this.enable) {
        break label351;
      }
      bool1 = true;
      label168:
      ((com.tencent.mm.ui.base.preference.f)localObject).cl("contact_info_qqmailhelper_compose", bool1);
      localObject = (CheckBoxPreference)this.screen.atx("contact_info_qqmailhelper_recv_remind");
      if (localObject != null) {
        ((CheckBoxPreference)localObject).vxW = this.pMz;
      }
      localObject = this.screen;
      if (this.enable) {
        break label356;
      }
      bool1 = true;
      label223:
      ((com.tencent.mm.ui.base.preference.f)localObject).cl("contact_info_qqmailhelper_recv_remind", bool1);
      localObject = this.screen;
      if ((this.enable & this.pMz)) {
        break label361;
      }
      bool1 = true;
      label253:
      ((com.tencent.mm.ui.base.preference.f)localObject).cl("contact_info_qqmailhelper_set_files_view", bool1);
      this.screen.cl("contact_info_qqmailhelper_download_mgr_view", true);
      localObject = this.screen;
      if (this.enable) {
        break label366;
      }
      bool1 = true;
      label290:
      ((com.tencent.mm.ui.base.preference.f)localObject).cl("contact_info_qqmailhelper_clear_data", bool1);
      localObject = this.screen;
      if (this.enable) {
        break label371;
      }
    }
    label336:
    label341:
    label346:
    label351:
    label356:
    label361:
    label366:
    label371:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((com.tencent.mm.ui.base.preference.f)localObject).cl("contact_info_qqmailhelper_uninstall", bool1);
      AppMethodBeat.o(68270);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label46;
      i = 0;
      break label107;
      bool1 = false;
      break label143;
      bool1 = false;
      break label168;
      bool1 = false;
      break label223;
      bool1 = false;
      break label253;
      bool1 = false;
      break label290;
    }
  }
  
  private void kl(boolean paramBoolean)
  {
    AppMethodBeat.i(68271);
    if (paramBoolean) {}
    for (String str = this.context.getString(2131303380);; str = this.context.getString(2131303388))
    {
      Context localContext = this.context;
      this.context.getString(2131297087);
      this.fsw = h.b(localContext, str, true, null);
      pMA = true;
      km(paramBoolean);
      AppMethodBeat.o(68271);
      return;
    }
  }
  
  private boolean km(boolean paramBoolean)
  {
    AppMethodBeat.i(68274);
    final com.tencent.mm.plugin.qqmail.b.t localt = new com.tencent.mm.plugin.qqmail.b.t(paramBoolean, "");
    if (!pMA) {
      this.eeN = h.b(this.context, this.context.getString(2131297112), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(68264);
          g.RK().eHt.a(localt);
          AppMethodBeat.o(68264);
        }
      });
    }
    g.RK().eHt.a(localt, 0);
    AppMethodBeat.o(68274);
    return false;
  }
  
  public final boolean Ke(String paramString)
  {
    boolean bool1 = false;
    AppMethodBeat.i(68268);
    ab.d("MicroMsg.ContactWidgetQQMail", "handleEvent : key = ".concat(String.valueOf(paramString)));
    if (bo.nullAsNil(paramString).length() <= 0)
    {
      AppMethodBeat.o(68268);
      return false;
    }
    if (paramString.equals("contact_info_qqmailhelper_view"))
    {
      paramString = new Intent();
      if (this.pyp)
      {
        paramString.putExtra("Chat_User", this.contact.field_username);
        paramString.putExtra("Chat_Mode", 1);
        paramString.addFlags(67108864);
        ((Activity)this.context).setResult(-1, paramString);
      }
      for (;;)
      {
        ((Activity)this.context).finish();
        AppMethodBeat.o(68268);
        return true;
        paramString.putExtra("Chat_User", this.contact.field_username);
        paramString.putExtra("Chat_Mode", 1);
        paramString.addFlags(67108864);
        com.tencent.mm.plugin.qqmail.a.a.gmO.d(paramString, this.context);
      }
    }
    if (paramString.equals("contact_info_qqmailhelper_compose"))
    {
      paramString = new Intent(this.context, ComposeUI.class);
      if (this.pyp)
      {
        paramString.putExtra("Chat_User", this.contact.field_username);
        paramString.addFlags(67108864);
        ((Activity)this.context).setResult(-1, paramString);
      }
      for (;;)
      {
        ((Activity)this.context).finish();
        AppMethodBeat.o(68268);
        return true;
        paramString.putExtra("Chat_User", this.contact.field_username);
        paramString.addFlags(67108864);
        this.context.startActivity(paramString);
      }
    }
    if (paramString.equals("contact_info_qqmailhelper_set_files_view"))
    {
      paramString = new Intent("android.intent.action.VIEW", Uri.parse(bo.nullAsNil((String)g.RL().Ru().get(29, null))));
      paramString.putExtra("title", this.context.getString(2131298708));
      paramString.putExtra("zoom", false);
      paramString.putExtra("show_bottom", false);
      paramString.putExtra("showShare", false);
      paramString.putExtra("vertical_scroll", false);
      com.tencent.mm.plugin.qqmail.a.a.gmO.i(paramString, this.context);
      AppMethodBeat.o(68268);
      return true;
    }
    if (paramString.equals("contact_info_qqmailhelper_recv_remind"))
    {
      paramString = (CheckBoxPreference)this.screen.atx(paramString);
      boolean bool2 = paramString.isChecked();
      km(bool2);
      if (!bool2) {
        bool1 = true;
      }
      paramString.vxW = bool1;
      AppMethodBeat.o(68268);
      return true;
    }
    if (paramString.equals("contact_info_qqmailhelper_clear_data"))
    {
      h.a(this.context, this.context.getString(2131298573), "", new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68261);
          ac.cdS();
          AppMethodBeat.o(68261);
        }
      }, null);
      AppMethodBeat.o(68268);
      return true;
    }
    if (paramString.equals("contact_info_qqmailhelper_install"))
    {
      if (bo.g((Integer)g.RL().Ru().get(9, null)) == 0)
      {
        h.b(this.context, 2131303526, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(68262);
            com.tencent.mm.plugin.qqmail.a.a.gmO.g(null, a.a(a.this));
            AppMethodBeat.o(68262);
          }
        }, null);
        AppMethodBeat.o(68268);
        return true;
      }
      kl(true);
      AppMethodBeat.o(68268);
      return true;
    }
    if (paramString.equals("contact_info_qqmailhelper_uninstall"))
    {
      h.d(this.context, this.context.getString(2131303384), "", this.context.getString(2131296891), this.context.getString(2131296888), new a.3(this), null);
      AppMethodBeat.o(68268);
      return true;
    }
    ab.e("MicroMsg.ContactWidgetQQMail", "handleEvent : unExpected key = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(68268);
    return false;
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(68273);
    int i = bo.f(paramObject, 0);
    ab.d("MicroMsg.ContactWidgetQQMail", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramn });
    if ((paramn != g.RL().Ru()) || (i <= 0))
    {
      ab.e("MicroMsg.ContactWidgetQQMail", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramn });
      AppMethodBeat.o(68273);
      return;
    }
    if ((i != 17) && (i != 34) && (i != 7))
    {
      AppMethodBeat.o(68273);
      return;
    }
    bkc();
    AppMethodBeat.o(68273);
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, ad paramad, boolean paramBoolean, int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(68269);
    if (paramf != null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      bool1 = bool2;
      if (paramad != null) {
        bool1 = true;
      }
      Assert.assertTrue(bool1);
      Assert.assertTrue(com.tencent.mm.model.t.nX(paramad.field_username));
      g.RL().Ru().a(this);
      g.RK().eHt.a(24, this);
      this.pyp = paramBoolean;
      this.contact = paramad;
      this.screen = paramf;
      paramf.addPreferencesFromResource(2131165218);
      bkc();
      AppMethodBeat.o(68269);
      return true;
    }
  }
  
  public final boolean bkb()
  {
    AppMethodBeat.i(68272);
    g.RL().Ru().b(this);
    g.RK().eHt.b(24, this);
    if (this.fsw != null)
    {
      this.fsw.dismiss();
      this.fsw = null;
    }
    if (this.eeN != null)
    {
      this.eeN.dismiss();
      this.eeN = null;
    }
    AppMethodBeat.o(68272);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(68275);
    if (paramm.getType() != 24)
    {
      ab.w("MicroMsg.ContactWidgetQQMail", "onSceneEnd : unExpected type = " + paramm.getType());
      AppMethodBeat.o(68275);
      return;
    }
    if (this.eeN != null)
    {
      this.eeN.dismiss();
      this.eeN = null;
    }
    if (this.fsw != null)
    {
      this.fsw.dismiss();
      this.fsw = null;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      bool = ((com.tencent.mm.plugin.qqmail.b.t)paramm).cKK;
      paramString = g.RL().Ru();
      if (bool)
      {
        paramInt1 = 1;
        paramString.set(17, Integer.valueOf(paramInt1));
        if ((pMA) && (bo.cB(this.context)))
        {
          if (bool) {
            g.RL().Ru().set(17, Integer.valueOf(1));
          }
          paramInt1 = r.Zy();
          if (!bool) {
            break label273;
          }
          paramInt1 &= 0xFFFFFFFE;
        }
      }
      for (;;)
      {
        g.RL().Ru().set(34, Integer.valueOf(paramInt1));
        ((j)g.E(j.class)).Yz().c(new k("", "", "", "", "", "", "", "", paramInt1, "", ""));
        com.tencent.mm.plugin.qqmail.a.a.gmP.BO();
        if (!bool) {
          ac.cdS();
        }
        pMA = false;
        AppMethodBeat.o(68275);
        return;
        paramInt1 = 2;
        break;
        label273:
        paramInt1 |= 0x1;
      }
    }
    boolean bool = ((com.tencent.mm.plugin.qqmail.b.t)paramm).cKK;
    ab.e("MicroMsg.ContactWidgetQQMail", "NetSceneSwitchPushMail fail : errType = " + paramInt1 + ", errCode = " + paramInt2);
    if (paramInt1 == 4)
    {
      switch (paramInt2)
      {
      default: 
        AppMethodBeat.o(68275);
        return;
      case -31: 
        ab.i("MicroMsg.ContactWidgetQQMail", "need second pass");
        paramString = View.inflate(this.context, 2130970634, null);
        paramm = (EditText)paramString.findViewById(2131827507);
        h.a(this.context, this.context.getString(2131298707), paramString, new a.5(this, bool, paramm));
        AppMethodBeat.o(68275);
        return;
      }
      ab.w("MicroMsg.ContactWidgetQQMail", "onSceneEnd, sys err");
    }
    if (pMA)
    {
      paramString = this.context;
      if (bool) {
        paramInt1 = 2131303377;
      }
    }
    for (paramString = paramString.getString(paramInt1);; paramString = this.context.getString(2131296925))
    {
      Toast.makeText(this.context, paramString, 1).show();
      pMA = false;
      AppMethodBeat.o(68275);
      return;
      paramInt1 = 2131303383;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.a
 * JD-Core Version:    0.7.0.1
 */