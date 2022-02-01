package com.tencent.mm.plugin.nearby.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.a.d;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

public final class a
  implements i, com.tencent.mm.pluginsdk.b.a, MStorageEx.IOnStorageChange
{
  private static boolean AzR = true;
  private com.tencent.mm.plugin.nearby.a.c AzP;
  private CheckBox AzQ;
  private d AzS;
  private as contact;
  private Context context;
  private View jBV;
  private f screen;
  private com.tencent.mm.ui.base.q tipDialog;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(89816);
    this.AzS = null;
    this.context = paramContext;
    this.jBV = View.inflate(paramContext, 2131495206, null);
    this.AzQ = ((CheckBox)this.jBV.findViewById(2131303120));
    this.AzQ.setChecked(false);
    com.tencent.mm.kernel.g.azz().a(148, this);
    AppMethodBeat.o(89816);
  }
  
  public static void C(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(89821);
    if (paramBoolean) {}
    for (Object localObject = paramContext.getString(2131765544);; localObject = paramContext.getString(2131765552))
    {
      AzR = paramBoolean;
      paramContext.getString(2131755998);
      paramContext = h.a(paramContext, (String)localObject, true, null);
      localObject = new MMHandler()
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(89814);
          int i = z.aUl();
          if (this.qNu) {
            i &= 0xFFFFFDFF;
          }
          for (;;)
          {
            com.tencent.mm.kernel.g.aAh().azQ().set(34, Integer.valueOf(i));
            ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSM().d(new com.tencent.mm.ba.l("", "", "", "", "", "", "", "", i, "", ""));
            if (!this.qNu)
            {
              com.tencent.mm.kernel.g.aAf().azk();
              ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiv().byC();
              com.tencent.mm.kernel.g.azz().a(new com.tencent.mm.plugin.nearby.a.c(2, 0.0F, 0.0F, 0, 0, "", ""), 0);
            }
            if (this.znB != null) {
              this.znB.onNotifyChange(null, null);
            }
            AppMethodBeat.o(89814);
            return;
            i |= 0x200;
          }
        }
      };
      new Timer().schedule(new TimerTask()
      {
        public final void run()
        {
          AppMethodBeat.i(89815);
          if (this.qDi != null)
          {
            this.qDi.dismiss();
            this.val$handler.sendEmptyMessage(0);
          }
          AppMethodBeat.o(89815);
        }
      }, 1500L);
      AppMethodBeat.o(89821);
      return;
    }
  }
  
  private void cCt()
  {
    boolean bool2 = true;
    AppMethodBeat.i(89820);
    boolean bool3 = isOpen();
    Object localObject = (HelperHeaderPreference)this.screen.bmg("contact_info_header_helper");
    ((HelperHeaderPreference)localObject).bk(this.contact.field_username, this.contact.arJ(), this.context.getString(2131757930));
    int i;
    if (bool3)
    {
      i = 1;
      ((HelperHeaderPreference)localObject).updateStatus(i);
      this.screen.jdMethod_do("contact_info_lbs_install", bool3);
      localObject = this.screen;
      if (bool3) {
        break label166;
      }
      bool1 = true;
      label96:
      ((f)localObject).jdMethod_do("contact_info_lbs_go_lbs", bool1);
      localObject = this.screen;
      if (bool3) {
        break label171;
      }
      bool1 = true;
      label120:
      ((f)localObject).jdMethod_do("contact_info_lbs_clear_info", bool1);
      localObject = this.screen;
      if (bool3) {
        break label176;
      }
    }
    label166:
    label171:
    label176:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((f)localObject).jdMethod_do("contact_info_lbs_uninstall", bool1);
      AppMethodBeat.o(89820);
      return;
      i = 0;
      break;
      bool1 = false;
      break label96;
      bool1 = false;
      break label120;
    }
  }
  
  private static boolean isOpen()
  {
    AppMethodBeat.i(89818);
    if ((z.aUl() & 0x200) == 0)
    {
      AppMethodBeat.o(89818);
      return true;
    }
    AppMethodBeat.o(89818);
    return false;
  }
  
  public final boolean a(f paramf, as paramas, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(89819);
    if (paramf != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Assert.assertTrue(paramBoolean);
      paramBoolean = bool;
      if (paramas != null) {
        paramBoolean = true;
      }
      Assert.assertTrue(paramBoolean);
      Assert.assertTrue(ab.Jg(paramas.field_username));
      com.tencent.mm.kernel.g.aAh().azQ().add(this);
      Log.v("MicroMsg.ContactWidgetLBS", "listener added");
      this.contact = paramas;
      this.screen = paramf;
      AzR = true;
      paramf.addPreferencesFromResource(2132017180);
      cCt();
      AppMethodBeat.o(89819);
      return true;
    }
  }
  
  public final boolean alD(String paramString)
  {
    AppMethodBeat.i(89817);
    Log.d("MicroMsg.ContactWidgetLBS", "handleEvent : key = ".concat(String.valueOf(paramString)));
    if (Util.nullAsNil(paramString).length() <= 0)
    {
      AppMethodBeat.o(89817);
      return false;
    }
    if (paramString.equals("contact_info_lbs_go_lbs"))
    {
      paramString = (Boolean)com.tencent.mm.kernel.g.aAh().azQ().get(4103, null);
      if ((paramString == null) || (!paramString.booleanValue())) {
        com.tencent.mm.br.c.V(this.context, "nearby", ".ui.NearbyFriendsIntroUI");
      }
      for (;;)
      {
        AppMethodBeat.o(89817);
        return true;
        paramString = bz.aWk();
        if (paramString == null)
        {
          com.tencent.mm.br.c.V(this.context, "nearby", ".ui.NearbyPersonalInfoUI");
        }
        else
        {
          String str1 = Util.nullAsNil(paramString.getProvince());
          String str2 = Util.nullAsNil(paramString.getCity());
          int i = paramString.fuA;
          if ((str1.equals("")) || (str2.equals("")) || (i == 0))
          {
            com.tencent.mm.br.c.V(this.context, "nearby", ".ui.NearbyPersonalInfoUI");
          }
          else
          {
            paramString = (Boolean)com.tencent.mm.kernel.g.aAh().azQ().get(4104, null);
            if ((paramString == null) || (!paramString.booleanValue()))
            {
              com.tencent.mm.bp.a.ih(this.context);
              ((Activity)this.context).finish();
            }
            else if (this.AzS == null)
            {
              this.AzS = h.a(this.context, this.context.getString(2131755998), this.jBV, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(89811);
                  paramAnonymousDialogInterface = com.tencent.mm.kernel.g.aAh().azQ();
                  if (!a.b(a.this).isChecked()) {}
                  for (boolean bool = true;; bool = false)
                  {
                    paramAnonymousDialogInterface.set(4104, Boolean.valueOf(bool));
                    com.tencent.mm.bp.a.ih(a.a(a.this));
                    ((Activity)a.a(a.this)).finish();
                    AppMethodBeat.o(89811);
                    return;
                  }
                }
              }, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
              });
            }
            else
            {
              this.AzS.show();
            }
          }
        }
      }
    }
    if (paramString.equals("contact_info_lbs_install"))
    {
      C(this.context, true);
      AppMethodBeat.o(89817);
      return true;
    }
    if (paramString.equals("contact_info_lbs_clear_info"))
    {
      h.a(this.context, 2131763437, 2131763436, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(89813);
          a.a(a.this, new com.tencent.mm.plugin.nearby.a.c(2, 0.0F, 0.0F, 0, 0, "", ""));
          com.tencent.mm.kernel.g.azz().a(a.c(a.this), 0);
          paramAnonymousDialogInterface = a.this;
          Context localContext = a.a(a.this);
          a.a(a.this).getString(2131755998);
          a.a(paramAnonymousDialogInterface, h.a(localContext, a.a(a.this).getString(2131763440), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(89812);
              com.tencent.mm.kernel.g.azz().a(a.c(a.this));
              AppMethodBeat.o(89812);
            }
          }));
          AppMethodBeat.o(89813);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(89817);
      return true;
    }
    if (paramString.equals("contact_info_lbs_uninstall"))
    {
      h.c(this.context, this.context.getString(2131765548), "", this.context.getString(2131755764), this.context.getString(2131755761), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(89810);
          a.C(a.a(a.this), false);
          AppMethodBeat.o(89810);
        }
      }, null);
      AppMethodBeat.o(89817);
      return true;
    }
    Log.e("MicroMsg.ContactWidgetLBS", "handleEvent : unExpected key = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(89817);
    return false;
  }
  
  public final boolean cCs()
  {
    AppMethodBeat.i(89822);
    com.tencent.mm.kernel.g.aAh().azQ().remove(this);
    com.tencent.mm.kernel.g.azz().b(148, this);
    com.tencent.mm.plugin.nearby.a.jRu.WZ();
    AppMethodBeat.o(89822);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(89823);
    int i = Util.nullAsInt(paramObject, 0);
    Log.d("MicroMsg.ContactWidgetLBS", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramMStorageEx });
    if ((paramMStorageEx != com.tencent.mm.kernel.g.aAh().azQ()) || (i <= 0))
    {
      Log.e("MicroMsg.ContactWidgetLBS", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramMStorageEx });
      AppMethodBeat.o(89823);
      return;
    }
    if ((i != 40) && (i != 34) && (i != 7))
    {
      AppMethodBeat.o(89823);
      return;
    }
    cCt();
    AppMethodBeat.o(89823);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(89824);
    if ((this.AzP == null) && (((com.tencent.mm.plugin.nearby.a.c)paramq).Vj() == 2))
    {
      AppMethodBeat.o(89824);
      return;
    }
    Log.i("MicroMsg.ContactWidgetLBS", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (paramq.getType() != 148)
    {
      AppMethodBeat.o(89824);
      return;
    }
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0)) {}
    for (paramInt1 = 2131763439;; paramInt1 = 2131763438)
    {
      if ((((com.tencent.mm.plugin.nearby.a.c)paramq).Vj() == 2) && (AzR))
      {
        h.a(this.context, paramInt1, 2131755998, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        this.AzP = null;
      }
      AppMethodBeat.o(89824);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.a
 * JD-Core Version:    0.7.0.1
 */