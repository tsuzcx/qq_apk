package com.tencent.mm.plugin.profile.ui.tab.observer;

import android.content.Intent;
import android.content.res.Resources;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.api.c.b;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.b;
import com.tencent.mm.model.ay.b.a;
import com.tencent.mm.model.j;
import com.tencent.mm.plugin.profile.ui.ContactInfoUI;
import com.tencent.mm.plugin.profile.ui.newbizinfo.a;
import com.tencent.mm.protocal.protobuf.aeq;
import com.tencent.mm.protocal.protobuf.ph;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.widget.a.e;

public class BizProfileWidgetOperateObserver
  extends BaseBizProfileOperateObserver
{
  private ContactInfoUI BiT;
  private ph BiU;
  private boolean BiZ = true;
  private int kgm;
  
  public BizProfileWidgetOperateObserver(ContactInfoUI paramContactInfoUI)
  {
    this.BiT = paramContactInfoUI;
  }
  
  public final boolean a(f paramf, final as paramas)
  {
    AppMethodBeat.i(232015);
    if (this.BiZ)
    {
      this.BiZ = false;
      this.BiT.setMMTitle(Util.nullAsNil(paramas.field_nickname));
      this.BiT.setMMTitleColor(0);
      this.BiT.setTitleDividerVis(false);
      this.BiT.setIsDarkActionbarBg(false);
      this.BiT.setActionbarColor(this.BiT.getResources().getColor(2131099650));
      this.BiT.hideActionbarLine();
      this.BiT.setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(232009);
          BizProfileWidgetOperateObserver.a(BizProfileWidgetOperateObserver.this).onBackPressed();
          AppMethodBeat.o(232009);
          return true;
        }
      }, 2131689492);
      this.BiT.removeAllOptionMenu();
      this.BiT.addIconOptionMenu(1, 2131766796, 2131689496, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(232010);
          BizProfileWidgetOperateObserver.a(BizProfileWidgetOperateObserver.this, paramas);
          AppMethodBeat.o(232010);
          return true;
        }
      });
      this.BiT.addIconOptionMenu(0, "", 2131689495, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(232014);
          paramAnonymousMenuItem = new e(BizProfileWidgetOperateObserver.a(BizProfileWidgetOperateObserver.this), 1, false);
          paramAnonymousMenuItem.HLX = new o.f()
          {
            public final void onCreateMMMenu(m paramAnonymous2m)
            {
              AppMethodBeat.i(232012);
              if (com.tencent.mm.contact.c.oR(BizProfileWidgetOperateObserver.3.this.gAi.field_type)) {
                if (BizProfileWidgetOperateObserver.3.this.gAi.arE()) {
                  if ((com.tencent.mm.storage.ab.clc()) && (g.Nd(BizProfileWidgetOperateObserver.3.this.gAi.field_username))) {
                    paramAnonymous2m.kV(5, 2131757840);
                  }
                }
              }
              for (;;)
              {
                paramAnonymous2m.kV(2, 2131758047);
                paramAnonymous2m.kV(6, 2131757360);
                if (com.tencent.mm.contact.c.oR(BizProfileWidgetOperateObserver.3.this.gAi.field_type)) {
                  paramAnonymous2m.kV(3, 2131757851);
                }
                AppMethodBeat.o(232012);
                return;
                paramAnonymous2m.kV(5, 2131762839);
                continue;
                if ((com.tencent.mm.storage.ab.clc()) && (g.Nd(BizProfileWidgetOperateObserver.3.this.gAi.field_username)))
                {
                  paramAnonymous2m.kV(4, 2131757836);
                }
                else
                {
                  paramAnonymous2m.kV(4, 2131758117);
                  continue;
                  if ((int)BizProfileWidgetOperateObserver.3.this.gAi.gMZ <= 0) {
                    ay.a.iDq.a(BizProfileWidgetOperateObserver.3.this.gAi.field_username, "", new ay.b.a()
                    {
                      public final void p(String paramAnonymous3String, boolean paramAnonymous3Boolean)
                      {
                        AppMethodBeat.i(232011);
                        Log.i("MicroMsg.ContactWidgetTabBizInfo.UI", "onCreateMMMenu Fetch Contact username:%s, succ: %b", new Object[] { paramAnonymous3String, Boolean.valueOf(paramAnonymous3Boolean) });
                        AppMethodBeat.o(232011);
                      }
                    });
                  }
                }
              }
            }
          };
          paramAnonymousMenuItem.HLY = new o.g()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(232013);
              switch (paramAnonymous2MenuItem.getItemId())
              {
              default: 
                Log.w("MicroMsg.ContactWidgetTabBizInfo.UI", "default onMMMenuItemSelected err");
              case 2: 
              case 3: 
              case 4: 
              case 5: 
                do
                {
                  do
                  {
                    AppMethodBeat.o(232013);
                    return;
                    BizProfileWidgetOperateObserver.b(BizProfileWidgetOperateObserver.this, BizProfileWidgetOperateObserver.3.this.gAi);
                    AppMethodBeat.o(232013);
                    return;
                    BizProfileWidgetOperateObserver.c(BizProfileWidgetOperateObserver.this, BizProfileWidgetOperateObserver.3.this.gAi);
                    AppMethodBeat.o(232013);
                    return;
                    com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.c(BizProfileWidgetOperateObserver.3.this.gAi.field_username, 903, BizProfileWidgetOperateObserver.b(BizProfileWidgetOperateObserver.this), BizProfileWidgetOperateObserver.this.enterTime);
                    j.HO(BizProfileWidgetOperateObserver.3.this.gAi.field_username);
                    BizProfileWidgetOperateObserver.ad(BizProfileWidgetOperateObserver.3.this.gAi);
                  } while ((com.tencent.mm.storage.ab.clc()) && (!g.Nb(BizProfileWidgetOperateObserver.3.this.gAi.field_username)));
                  h.cD(BizProfileWidgetOperateObserver.a(BizProfileWidgetOperateObserver.this), BizProfileWidgetOperateObserver.a(BizProfileWidgetOperateObserver.this).getString(2131762840));
                  AppMethodBeat.o(232013);
                  return;
                  com.tencent.mm.model.ab.F(BizProfileWidgetOperateObserver.3.this.gAi.field_username, true);
                  com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.c(BizProfileWidgetOperateObserver.3.this.gAi.field_username, 904, BizProfileWidgetOperateObserver.b(BizProfileWidgetOperateObserver.this), BizProfileWidgetOperateObserver.this.enterTime);
                  BizProfileWidgetOperateObserver.ad(BizProfileWidgetOperateObserver.3.this.gAi);
                } while ((com.tencent.mm.storage.ab.clc()) && (!g.Nb(BizProfileWidgetOperateObserver.3.this.gAi.field_username)));
                h.cD(BizProfileWidgetOperateObserver.a(BizProfileWidgetOperateObserver.this), BizProfileWidgetOperateObserver.a(BizProfileWidgetOperateObserver.this).getString(2131756793));
                AppMethodBeat.o(232013);
                return;
              }
              BizProfileWidgetOperateObserver.d(BizProfileWidgetOperateObserver.this, BizProfileWidgetOperateObserver.3.this.gAi);
              AppMethodBeat.o(232013);
            }
          };
          paramAnonymousMenuItem.dGm();
          com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.c(paramas.field_username, 600, BizProfileWidgetOperateObserver.b(BizProfileWidgetOperateObserver.this), BizProfileWidgetOperateObserver.this.enterTime);
          AppMethodBeat.o(232014);
          return false;
        }
      });
      this.BiU = a.aKy(paramas.field_username);
      com.tencent.mm.api.c localc = g.fJ(paramas.field_username);
      this.dhu = null;
      this.dhv = null;
      this.BeW = null;
      if (localc != null)
      {
        paramf = localc;
        if (localc.cG(false) != null) {}
      }
      else
      {
        paramf = localc;
        if (this.BeX != null)
        {
          paramf = new com.tencent.mm.api.c();
          paramf.field_username = paramas.field_username;
          paramf.field_brandFlag = this.BeX.kem;
          paramf.field_brandIconURL = this.BeX.kep;
          paramf.field_brandInfo = this.BeX.keo;
          paramf.field_extInfo = this.BeX.ken;
          paramf.field_type = paramf.cG(false).getServiceType();
        }
      }
      if ((paramf != null) && (paramf.field_brandInfo == null) && (paramf.field_extInfo == null) && (this.BeX != null))
      {
        paramf.field_username = paramas.field_username;
        paramf.field_brandFlag = this.BeX.kem;
        paramf.field_brandIconURL = this.BeX.kep;
        paramf.field_brandInfo = this.BeX.keo;
        paramf.field_extInfo = this.BeX.ken;
        paramf.field_type = paramf.cG(false).getServiceType();
      }
      if (paramf != null)
      {
        this.Bdk = paramf;
        this.dhu = paramf.UO();
        this.dhv = paramf.cG(false);
        this.BeW = this.dhv.getWxaEntryInfoList();
        if ((this.dhv.US() != null) && (this.dhv.US().length() > 0)) {
          this.dhE = this.dhv.US();
        }
      }
      paramf = this.BiT.getIntent().getStringExtra("Contact_BIZ_PopupInfoMsg");
      if (!Util.isNullOrNil(paramf))
      {
        this.BiT.getIntent().putExtra("Contact_BIZ_PopupInfoMsg", "");
        h.a(this.BiT, paramf, "", this.BiT.getString(2131755921), null);
      }
    }
    AppMethodBeat.o(232015);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.observer.BizProfileWidgetOperateObserver
 * JD-Core Version:    0.7.0.1
 */