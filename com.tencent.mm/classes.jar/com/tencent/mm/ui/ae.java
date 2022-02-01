package com.tencent.mm.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.fl;
import com.tencent.mm.g.a.rb;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.g.a.wq.b;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bv;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.newtips.a.i;
import com.tencent.mm.plugin.newtips.a.k;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.protocal.protobuf.ckb;
import com.tencent.mm.protocal.protobuf.dnz;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.VoipAddressUI;
import com.tencent.mm.ui.tools.s;
import com.tencent.mm.wallet_core.c.aa;
import java.io.IOException;

public final class ae
  extends s
  implements com.tencent.mm.ak.f
{
  private static final int[] JzP = { 2, 1, 10, 20, 2147483647 };
  private static final int[] JzQ = { 2, 1, 10, 2147483647 };
  private SparseArray<c> JzK;
  private a JzM;
  ad JzN;
  private boolean JzO;
  private Context mContext;
  private LayoutInflater mInflater;
  
  public ae(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(33697);
    this.JzN = null;
    this.mContext = paramAppCompatActivity;
    this.mInflater = LayoutInflater.from(paramAppCompatActivity);
    yQ(false);
    this.JzN = ad.fBE();
    AppMethodBeat.o(33697);
  }
  
  public static d acD(int paramInt)
  {
    AppMethodBeat.i(33700);
    Object localObject = ak.getContext();
    switch (paramInt)
    {
    default: 
      localObject = null;
    }
    for (;;)
    {
      AppMethodBeat.o(33700);
      return localObject;
      if (HomeUI.Jso.booleanValue())
      {
        localObject = new d(1, ((Context)localObject).getString(2131761217), "", 2131690971, 2131101171);
      }
      else
      {
        localObject = new d(1, ((Context)localObject).getString(2131761217), "", 2131690972, 0);
        continue;
        if (HomeUI.Jsp.booleanValue())
        {
          localObject = new d(2, ((Context)localObject).getString(2131761220), "", 2131690984, 2131101171);
        }
        else
        {
          localObject = new d(2, ((Context)localObject).getString(2131761220), "", 2131690985, 0);
          continue;
          localObject = new d(3, ((Context)localObject).getString(2131761221), "", 2131689854, 0);
          continue;
          if (1 == bu.getInt(com.tencent.mm.n.g.acL().getValue("VOIPCallType"), 0))
          {
            localObject = new d(4, ((Context)localObject).getString(2131761222), "", 2131690995, 0);
          }
          else
          {
            localObject = new d(4, ((Context)localObject).getString(2131761218), "", 2131690973, 0);
            continue;
            localObject = new d(5, ((Context)localObject).getString(2131763307), "", 2131690990, 0);
            continue;
            localObject = new d(6, ((Context)localObject).getString(2131763276), "", 2131690981, 0);
            continue;
            localObject = new d(7, ((Context)localObject).getString(2131763278), "", 2131690976, 0);
            continue;
            localObject = new d(8, ((Context)localObject).getString(2131758307), "", 2131690979, 0);
            continue;
            localObject = new d(9, ((Context)localObject).getString(2131763311), "", 2131690988, 0);
            continue;
            localObject = new d(10, ((Context)localObject).getString(2131759095), "", 2131690991, 0);
            continue;
            localObject = new d(11, ((Context)localObject).getString(2131763808), "", 2131690987, 0);
            continue;
            localObject = new d(12, ((Context)localObject).getString(2131759965), "", 2131690983, 0);
            continue;
            localObject = new d(13, ((Context)localObject).getString(2131763605), "", 2131690994, 0);
            continue;
            localObject = new d(14, ((Context)localObject).getString(2131761520), "", 2131690989, 0);
            continue;
            localObject = new d(16, ((Context)localObject).getString(2131763154), "", 2131690997, 0);
            continue;
            localObject = new d(17, ((Context)localObject).getString(2131761177), "", 2131690986, 0);
            continue;
            localObject = new d(18, ((Context)localObject).getString(2131759097), "", 2131690992, 0);
            continue;
            localObject = new d(19, ((Context)localObject).getString(2131759100), "", 2131689484, 0);
            continue;
            bc.aCg();
            if (((Integer)com.tencent.mm.model.c.ajA().get(am.a.IPF, Integer.valueOf(0))).intValue() > 1) {
              break;
            }
            localObject = new d(20, ((Context)localObject).getString(2131755231), "", 2131691083, 0, "plus_receiveorpay");
            continue;
            localObject = new d(2147483647, ((Context)localObject).getString(2131763227), "", 2131690982, 0);
            continue;
            localObject = new d(2147483645, ((Context)localObject).getString(2131763204), "", 2131690982, 0);
            continue;
            bc.aCg();
            paramInt = ((Integer)com.tencent.mm.model.c.ajA().get(am.a.IPF, Integer.valueOf(0))).intValue();
            int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qGI, 0);
            if ((paramInt != 8) || (i != 0)) {
              break;
            }
            localObject = new d(22, ((Context)localObject).getString(2131762000), "", 2131691587, 0);
            continue;
            bc.aCg();
            paramInt = ((Integer)com.tencent.mm.model.c.ajA().get(am.a.IPF, Integer.valueOf(0))).intValue();
            i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qGI, 0);
            if ((paramInt != 8) || (i != 1)) {
              break;
            }
            localObject = new d(24, ((Context)localObject).getString(2131766756), "", 2131691083, 0);
            continue;
            localObject = new d(2147483646, "TIT", "", 2131690976, 0);
          }
        }
      }
    }
  }
  
  private static ckb fBG()
  {
    AppMethodBeat.i(187029);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.PlusSubMenuHelper", "OfflineH5 getConfig");
    ckb localckb = new ckb();
    String str = (String)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(am.a.Jeh, null);
    if (bu.isNullOrNil(str)) {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.PlusSubMenuHelper", "OfflineH5 get PayIBGQuickGetOverseaWalletConfig failed");
    }
    for (;;)
    {
      AppMethodBeat.o(187029);
      return localckb;
      try
      {
        localckb.parseFrom(str.getBytes("ISO-8859-1"));
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.PlusSubMenuHelper", "OfflineH5 getConfig success");
      }
      catch (Exception localException)
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.PlusSubMenuHelper", "OfflineH5 parse PayIBGQuickGetOverseaWalletConfig fail, " + localException.getLocalizedMessage());
      }
    }
  }
  
  private boolean fBH()
  {
    AppMethodBeat.i(187031);
    String str = bu.jt(this.mContext);
    if ((!bu.isNullOrNil(str)) && (str.equals("LauncherUI")))
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.PlusSubMenuHelper", "LauncherUI is on ActivityTask Top ");
      AppMethodBeat.o(187031);
      return true;
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.PlusSubMenuHelper", "LauncherUI is not on ActivityTask Top：%s", new Object[] { str });
    AppMethodBeat.o(187031);
    return false;
  }
  
  private void xE(boolean paramBoolean)
  {
    AppMethodBeat.i(187028);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.plugin.wallet_index.c.a.b localb = new com.tencent.mm.plugin.wallet_index.c.a.b(((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IPF, Integer.valueOf(0))).intValue());
    bc.ajj().a(localb, 0);
    this.JzO = paramBoolean;
    AppMethodBeat.o(187028);
  }
  
  public final BaseAdapter Zy()
  {
    AppMethodBeat.i(33701);
    if (this.JzM == null) {
      this.JzM = new a((byte)0);
    }
    a locala = this.JzM;
    AppMethodBeat.o(33701);
    return locala;
  }
  
  public final boolean il()
  {
    int k = 0;
    AppMethodBeat.i(33698);
    this.JzN.xD(false);
    if (this.JzN.JzK.size() != 0) {
      this.JzK = this.JzN.JzK;
    }
    try
    {
      bc.aCg();
      if (((Boolean)com.tencent.mm.model.c.ajA().get(am.a.ING, Boolean.FALSE)).booleanValue())
      {
        int i = k;
        while (i < this.JzK.size())
        {
          int j = ((c)this.JzK.get(i)).JzU.JzX;
          if (j != 2147483646)
          {
            i += 1;
            continue;
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.PlusSubMenuHelper", "dyna plus config is null, we use default one");
            if (this.JzK != null)
            {
              this.JzK.clear();
              label133:
              if (!bu.jq(this.mContext)) {
                break label222;
              }
            }
            label222:
            for (int[] arrayOfInt = JzQ;; arrayOfInt = JzP)
            {
              int m = arrayOfInt.length;
              i = 0;
              j = 0;
              while (i < m)
              {
                c localc = new c(acD(arrayOfInt[i]));
                if (localc.JzU != null) {
                  this.JzK.put(j, localc);
                }
                j += 1;
                i += 1;
              }
              this.JzK = new SparseArray();
              break label133;
            }
          }
        }
        if (i == this.JzK.size()) {
          this.JzK.put(this.JzK.size(), new c(acD(2147483646)));
        }
      }
    }
    catch (Exception localException)
    {
      label268:
      boolean bool;
      break label268;
    }
    if (this.JzM != null) {
      this.JzM.notifyDataSetChanged();
    }
    bool = super.il();
    AppMethodBeat.o(33698);
    return bool;
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, final View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(33699);
    if ((this.mContext instanceof AppCompatActivity)) {
      ((AppCompatActivity)this.mContext).supportInvalidateOptionsMenu();
    }
    int i = ((c)this.JzK.get(paramInt)).JzU.JzX;
    paramAdapterView = new com.tencent.mm.hellhoundlib.b.b();
    paramAdapterView.mu(i);
    paramAdapterView.mu(paramInt);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/PlusSubMenuHelper", "com/tencent/mm/ui/PlusSubMenuHelper", "processOnItemClick", "(II)V", this, paramAdapterView.ahF());
    com.tencent.mm.plugin.report.service.g.yxI.f(11104, new Object[] { Integer.valueOf(i) });
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.widget.recentview.d.class) != null) {
      ((com.tencent.mm.plugin.appbrand.widget.recentview.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.widget.recentview.d.class)).bCV();
    }
    switch (i)
    {
    default: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/PlusSubMenuHelper", "com/tencent/mm/ui/PlusSubMenuHelper", "processOnItemClick", "(II)V");
        this.JzN.acC(i);
        dismiss();
        AppMethodBeat.o(33699);
        return;
        new Intent().putExtra("invite_friend_scene", 2);
        com.tencent.mm.br.d.b(this.mContext, "subapp", ".ui.pluginapp.AddMoreFriendsUI", new Intent());
        continue;
        paramView = new Intent(this.mContext, SelectContactUI.class);
        paramView.putExtra("titile", this.mContext.getString(2131755232));
        paramView.putExtra("list_type", 0);
        paramView.putExtra("list_attr", com.tencent.mm.ui.contact.u.J(new int[] { com.tencent.mm.ui.contact.u.KJT, 256, 512 }));
        paramView.putExtra("scene", 7);
        paramView.putExtra("menu_mode", 2);
        paramView.putExtra("create_group_recommend", true);
        paramAdapterView = this.mContext;
        paramView = new com.tencent.mm.hellhoundlib.b.a().bc(paramView);
        com.tencent.mm.hellhoundlib.a.a.a(paramAdapterView, paramView.ahE(), "com/tencent/mm/ui/PlusSubMenuHelper", "processOnItemClick", "(II)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAdapterView.startActivity((Intent)paramView.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAdapterView, "com/tencent/mm/ui/PlusSubMenuHelper", "processOnItemClick", "(II)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        continue;
        paramView = new Intent();
        paramView.setClassName(this.mContext, "com.tencent.mm.ui.tools.ShareImageRedirectUI");
        paramAdapterView = this.mContext;
        paramView = new com.tencent.mm.hellhoundlib.b.a().bc(paramView);
        com.tencent.mm.hellhoundlib.a.a.a(paramAdapterView, paramView.ahE(), "com/tencent/mm/ui/PlusSubMenuHelper", "processOnItemClick", "(II)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAdapterView.startActivity((Intent)paramView.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAdapterView, "com/tencent/mm/ui/PlusSubMenuHelper", "processOnItemClick", "(II)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        continue;
        paramAdapterView = new wq();
        paramAdapterView.dMc.dMe = true;
        com.tencent.mm.sdk.b.a.IvT.l(paramAdapterView);
        paramAdapterView = paramAdapterView.dMd.dMg;
        if (!bu.isNullOrNil(paramAdapterView))
        {
          com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.PlusSubMenuHelper", "Talkroom is on: ".concat(String.valueOf(paramAdapterView)));
          h.e(this.mContext, this.mContext.getString(2131764350), "", this.mContext.getString(2131755835), this.mContext.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(33686);
              Object localObject = new wq();
              ((wq)localObject).dMc.dMf = true;
              com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
              localObject = new fl();
              ((fl)localObject).drB.username = com.tencent.mm.bi.d.iup.aMK();
              com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
              VoipAddressUI.kw(ae.b(ae.this));
              paramAnonymousDialogInterface.dismiss();
              AppMethodBeat.o(33686);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(33687);
              paramAnonymousDialogInterface.dismiss();
              AppMethodBeat.o(33687);
            }
          });
        }
        else
        {
          VoipAddressUI.kw(this.mContext);
          continue;
          bc.aCg();
          if (!com.tencent.mm.model.c.isSDCardAvailable())
          {
            t.g(this.mContext, null);
          }
          else
          {
            bc.aCg();
            paramAdapterView = (String)com.tencent.mm.model.c.ajA().get(2, null);
            paramView = new Intent();
            paramView.putExtra("sns_userName", paramAdapterView);
            paramView.setFlags(536870912);
            paramView.addFlags(67108864);
            bc.aCg();
            paramInt = bu.a((Integer)com.tencent.mm.model.c.ajA().get(68389, null), 0);
            bc.aCg();
            com.tencent.mm.model.c.ajA().set(68389, Integer.valueOf(paramInt + 1));
            paramView.putExtra("sns_adapter_type", 1);
            com.tencent.mm.br.d.b(this.mContext, "sns", ".ui.SnsTimeLineUserPagerUI", paramView);
            continue;
            com.tencent.mm.plugin.fav.a.b.b(this.mContext, ".ui.FavoriteIndexUI", new Intent());
            continue;
            bool1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qGM, false);
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.PlusSubMenuHelper", " walletMallV2 switch is ：%s", new Object[] { Boolean.valueOf(bool1) });
            if (bool1)
            {
              com.tencent.mm.br.d.b(this.mContext, "mall", ".ui.MallIndexUIv2", new Intent());
            }
            else
            {
              com.tencent.mm.br.d.b(this.mContext, "mall", ".ui.MallIndexUI", new Intent());
              continue;
              paramAdapterView = new Intent();
              paramAdapterView.putExtra("preceding_scence", 2);
              com.tencent.mm.br.d.b(this.mContext, "emoji", ".ui.v2.EmojiStoreV2UI", paramAdapterView);
              continue;
              com.tencent.mm.br.d.b(this.mContext, "setting", ".ui.setting.SelfQRCodeUI", new Intent());
              continue;
              com.tencent.mm.plugin.report.service.g.yxI.f(11265, new Object[] { Integer.valueOf(3) });
              if ((!com.tencent.mm.r.a.n(this.mContext, true)) && (!com.tencent.mm.bh.e.aME()) && (!com.tencent.mm.r.a.p(this.mContext, true)))
              {
                paramAdapterView = new Intent();
                paramAdapterView.putExtra("key_scan_entry_scene", 1);
                paramAdapterView.putExtra("key_config_black_interval", true);
                paramAdapterView.putExtra("key_enable_multi_code", true);
                paramAdapterView.putExtra("key_scan_goods_enable_dynamic_wording", true);
                com.tencent.mm.br.d.b(this.mContext, "scanner", ".ui.BaseScanUI", paramAdapterView);
                continue;
                bc.aCg();
                if (com.tencent.mm.model.c.isSDCardAvailable()) {
                  break;
                }
                t.g(this.mContext, null);
              }
            }
          }
        }
      }
      com.tencent.mm.plugin.report.service.f.OP(10);
      bc.aCg();
      paramAdapterView = (String)com.tencent.mm.model.c.ajA().get(68377, null);
      bc.aCg();
      com.tencent.mm.model.c.ajA().set(68377, "");
      paramView = new Intent();
      paramView.putExtra("sns_timeline_NeedFirstLoadint", true);
      if (bu.isNullOrNil(paramAdapterView)) {
        break;
      }
    }
    for (boolean bool1 = false;; bool1 = true)
    {
      boolean bool2 = bool1;
      if (o.zsx != null)
      {
        bool2 = bool1;
        if (o.zsx.bVY() > 0) {
          bool2 = false;
        }
      }
      paramView.putExtra("sns_resume_state", bool2);
      com.tencent.mm.br.d.b(this.mContext, "sns", ".ui.SnsTimeLineUI", paramView);
      break;
      bc.aCg();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        t.g(this.mContext, null);
        break;
      }
      com.tencent.mm.br.d.Q(this.mContext, "game", ".ui.GameCenterUI");
      new aq().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(33688);
          com.tencent.mm.cp.d.fWU();
          AppMethodBeat.o(33688);
        }
      }, 100L);
      break;
      com.tencent.mm.sdk.b.a.IvT.l(new rb());
      com.tencent.mm.br.d.Q(this.mContext, "shake", ".ui.ShakeReportUI");
      break;
      bc.aCg();
      if (!bu.o((Boolean)com.tencent.mm.model.c.ajA().get(4103, null)))
      {
        com.tencent.mm.br.d.Q(this.mContext, "nearby", ".ui.NearbyFriendsIntroUI");
        break;
      }
      paramAdapterView = bv.aCM();
      if (paramAdapterView == null)
      {
        com.tencent.mm.br.d.Q(this.mContext, "nearby", ".ui.NearbyPersonalInfoUI");
        break;
      }
      paramView = bu.nullAsNil(paramAdapterView.getProvince());
      paramInt = bu.a(Integer.valueOf(paramAdapterView.eQV), 0);
      if ((bu.isNullOrNil(paramView)) || (paramInt == 0))
      {
        com.tencent.mm.br.d.Q(this.mContext, "nearby", ".ui.NearbyPersonalInfoUI");
        break;
      }
      bc.aCg();
      paramAdapterView = (Boolean)com.tencent.mm.model.c.ajA().get(4104, null);
      if ((paramAdapterView == null) || (!paramAdapterView.booleanValue()))
      {
        paramAdapterView = LauncherUI.getInstance();
        if (paramAdapterView != null) {
          paramAdapterView.Jty.getMainTabUI().aWU("tab_find_friend");
        }
        com.tencent.mm.bp.a.hn(this.mContext);
        break;
      }
      paramAdapterView = View.inflate(this.mContext, 2131494579, null);
      paramView = (CheckBox)paramAdapterView.findViewById(2131301369);
      paramView.setChecked(false);
      h.a(this.mContext, this.mContext.getString(2131755906), paramAdapterView, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(33689);
          if (paramView != null)
          {
            bc.aCg();
            paramAnonymousDialogInterface = com.tencent.mm.model.c.ajA();
            if (paramView.isChecked()) {
              break label79;
            }
          }
          label79:
          for (boolean bool = true;; bool = false)
          {
            paramAnonymousDialogInterface.set(4104, Boolean.valueOf(bool));
            paramAnonymousDialogInterface = LauncherUI.getInstance();
            if (paramAnonymousDialogInterface != null) {
              paramAnonymousDialogInterface.Jty.getMainTabUI().aWU("tab_find_friend");
            }
            com.tencent.mm.bp.a.hn(ae.b(ae.this));
            AppMethodBeat.o(33689);
            return;
          }
        }
      }, null);
      break;
      bc.aCg();
      if (com.tencent.mm.model.c.aiX())
      {
        com.tencent.mm.br.d.Q(this.mContext, "webwx", ".ui.WebWXLogoutUI");
        break;
      }
      com.tencent.mm.br.d.Q(this.mContext, "webwx", ".ui.WebWeiXinIntroductionUI");
      break;
      if ((v.aAO() & 0x10000) == 0) {}
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt == 0) {
          break label1765;
        }
        com.tencent.mm.br.d.Q(this.mContext, "masssend", ".ui.MassSendHistoryUI");
        break;
      }
      label1765:
      com.tencent.mm.br.d.b(this.mContext, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", "masssendapp"));
      break;
      com.tencent.mm.br.d.Q(this.mContext, "radar", ".ui.RadarSearchUI");
      break;
      com.tencent.mm.br.d.Q(this.mContext, "pwdgroup", ".ui.FacingCreateChatRoomAllInOneUI");
      break;
      com.tencent.mm.plugin.report.service.g.yxI.kvStat(10919, "1-6");
      com.tencent.mm.pluginsdk.g.hr(this.mContext);
      break;
      paramAdapterView = new Intent();
      bc.aCg();
      paramView = (String)com.tencent.mm.model.c.ajA().get(am.a.ITK, "");
      if (!bu.isNullOrNil(paramView))
      {
        paramAdapterView.putExtra("rawUrl", paramView);
        paramAdapterView.putExtra("showShare", true);
        paramAdapterView.putExtra("show_bottom", false);
        com.tencent.mm.br.d.b(this.mContext, "webview", ".ui.tools.WebViewUI", paramAdapterView);
        break;
      }
      com.tencent.mm.pluginsdk.g.hr(this.mContext);
      break;
      com.tencent.mm.plugin.newtips.a.dxD().Mv(4);
      paramAdapterView = this.mContext;
      paramView = new Intent();
      paramView.putExtra("key_from_scene", 2);
      com.tencent.mm.br.d.b(paramAdapterView, "offline", ".ui.WalletOfflineEntranceUI", paramView);
      if (!com.tencent.mm.y.c.ahI().cJ(262159, 266248)) {
        break;
      }
      com.tencent.mm.y.c.ahI().cK(262159, 266248);
      com.tencent.mm.plugin.report.service.g.yxI.f(14396, new Object[] { Integer.valueOf(2) });
      break;
      com.tencent.mm.pluginsdk.wallet.f.au(this.mContext, 1);
      break;
      com.tencent.mm.kernel.g.ajj().a(2540, this);
      paramAdapterView = fBG();
      if (bu.isNullOrNil(paramAdapterView.HwD))
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.PlusSubMenuHelper", "OfflineH5 has no cache");
        xE(false);
        break;
      }
      paramLong = System.currentTimeMillis();
      long l = paramLong - paramAdapterView.HwF;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.PlusSubMenuHelper", "currentTime ：%s ,lastTime：%s,internalTime ：%s", new Object[] { Long.valueOf(paramLong), Long.valueOf(paramAdapterView.HwF), Long.valueOf(l) });
      if (l < paramAdapterView.HwE)
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.PlusSubMenuHelper", "OfflineH5 dont expired，url：%s", new Object[] { paramAdapterView.HwD });
        com.tencent.mm.wallet_core.ui.f.o(this.mContext, paramAdapterView.HwD, false);
        xE(true);
        break;
      }
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.PlusSubMenuHelper", "OfflineH5 is expired");
      xE(false);
      break;
      paramAdapterView = new Intent();
      paramAdapterView.putExtra("key_from_scene", 2);
      com.tencent.mm.br.d.b(this.mContext, "offline", ".ui.WalletOfflineEntranceUI", paramAdapterView);
      break;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(187030);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.PlusSubMenuHelper", "on Scene End：errType %s , errCode：%s，errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramn instanceof com.tencent.mm.plugin.wallet_index.c.a.b))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label371;
      }
      paramString = (com.tencent.mm.plugin.wallet_index.c.a.b)paramn;
      if (paramString.DHM != null) {
        break label268;
      }
      paramString = new ckb();
      if (paramString.dxd != 0) {
        break label312;
      }
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.PlusSubMenuHelper", "NetScenePayIBGQuickGetOverseaWallet on SceneEnd ok，pay_wallet_wxapp_h5_url：%s, cache_time：%s", new Object[] { paramString.HwD, Integer.valueOf(paramString.HwE) });
      if ((!this.JzO) && (fBH()))
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.PlusSubMenuHelper", "on Scene End jump h5 ");
        com.tencent.mm.wallet_core.ui.f.o(this.mContext, paramString.HwD, false);
      }
      paramString.HwF = System.currentTimeMillis();
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.PlusSubMenuHelper", "on Scene End currentTime ：%s ", new Object[] { Long.valueOf(paramString.HwF) });
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.PlusSubMenuHelper", "OfflineH5 setConfig");
      if (paramString == null) {
        break label432;
      }
    }
    for (;;)
    {
      try
      {
        paramString = new String(paramString.toByteArray(), "ISO-8859-1");
      }
      catch (IOException paramn)
      {
        label268:
        paramString = " ";
      }
      try
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.PlusSubMenuHelper", "OfflineH5 setConfig success");
        ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().set(am.a.Jeh, paramString);
        ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().fuc();
        com.tencent.mm.kernel.g.ajj().b(2540, this);
        AppMethodBeat.o(187030);
        return;
      }
      catch (IOException paramn)
      {
        break label282;
      }
      paramString = paramString.DHM;
      break;
      label282:
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.PlusSubMenuHelper", "save config exp, " + paramn.getLocalizedMessage());
      continue;
      label312:
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.PlusSubMenuHelper", "NetScenePayIBGQuickGetOverseaWallet on SceneEnd failed show dialog ");
      if ((!this.JzO) && (fBH()))
      {
        h.a(this.mContext, paramString.dxe, "", this.mContext.getString(2131766205), false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(187024);
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.PlusSubMenuHelper", "onDialogClick() ");
            AppMethodBeat.o(187024);
          }
        });
        continue;
        label371:
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.PlusSubMenuHelper", "NetScenePayIBGQuickGetOverseaWallet on SceneEnd faile show error dialog ");
        if ((!this.JzO) && (fBH()))
        {
          h.a(this.mContext, paramString, "", this.mContext.getString(2131766205), false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(187025);
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.PlusSubMenuHelper", "onDialogClick() ");
              AppMethodBeat.o(187025);
            }
          });
          continue;
          label432:
          paramString = " ";
        }
      }
    }
  }
  
  final class a
    extends BaseAdapter
  {
    private a() {}
    
    public final int getCount()
    {
      AppMethodBeat.i(33690);
      int i = ae.a(ae.this).size();
      AppMethodBeat.o(33690);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      return null;
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(33691);
      paramView = (ae.c)ae.a(ae.this).get(paramInt);
      paramView = new ae.e(ae.b(ae.this), paramView);
      LayoutInflater localLayoutInflater = ae.c(ae.this);
      label254:
      boolean bool;
      if (paramInt == getCount() - 1)
      {
        paramInt = 1;
        paramView.fQH = localLayoutInflater.inflate(2131494904, paramViewGroup, false);
        paramView.gqi = ((TextView)paramView.fQH.findViewById(2131305902));
        paramView.ka = ((ImageView)paramView.fQH.findViewById(2131300874));
        paramView.JzZ = ((TextView)paramView.fQH.findViewById(2131302799));
        paramView.JAa = ((TextView)paramView.fQH.findViewById(2131306194));
        paramView.JAb = paramView.fQH.findViewById(2131302741);
        if (!bu.isNullOrNil(paramView.JzY.JzU.JzV)) {
          paramView.gqi.setText(paramView.JzY.JzU.JzV);
        }
        if (paramView.JzY.JzU.textColor > 0) {
          paramView.gqi.setTextColor(com.tencent.mm.cb.a.n(ak.getContext(), paramView.JzY.JzU.textColor));
        }
        if (paramView.JzY.JzU.icon <= 0) {
          break label425;
        }
        paramView.ka.setVisibility(0);
        paramView.ka.setImageResource(paramView.JzY.JzU.icon);
        if (!bu.isNullOrNil(paramView.JzY.JzU.JzW)) {
          paramView.ka.setContentDescription(paramView.JzY.JzU.JzW);
        }
        paramView.JAa.setBackgroundResource(com.tencent.mm.ui.tools.u.kL(paramView.context));
        if (paramInt == 0) {
          break label437;
        }
        paramView.fQH.setBackgroundResource(2131234277);
        label314:
        paramView.JzZ.setTextSize(0, com.tencent.mm.cb.a.ay(paramView.context, 2131166950));
        if ((!paramView.JzY.gnS) && (paramView.JzY.dla <= 0) && (!paramView.JzY.JzT)) {
          break label449;
        }
        bool = true;
        label365:
        if (!com.tencent.mm.plugin.newtips.a.g.a(bool, paramView))
        {
          if (!paramView.JzY.gnS) {
            break label455;
          }
          paramView.JzZ.setVisibility(0);
          com.tencent.mm.plugin.newtips.a.g.a(paramView, k.wIw, true);
        }
      }
      for (;;)
      {
        com.tencent.mm.plugin.newtips.a.dxD().h(paramView);
        paramView = paramView.fQH;
        AppMethodBeat.o(33691);
        return paramView;
        paramInt = 0;
        break;
        label425:
        paramView.ka.setVisibility(8);
        break label254;
        label437:
        paramView.fQH.setBackgroundResource(2131234276);
        break label314;
        label449:
        bool = false;
        break label365;
        label455:
        if (paramView.JzY.dla > 0)
        {
          paramView.JAa.setVisibility(0);
          if (paramView.JzY.dla > 99)
          {
            paramView.JAa.setText("");
            paramView.JAa.setBackgroundResource(2131689744);
          }
          for (;;)
          {
            com.tencent.mm.plugin.newtips.a.g.a(paramView, k.wIA, true);
            break;
            paramView.JAa.setText(paramView.JzY.dla);
            paramView.JAa.setBackgroundResource(com.tencent.mm.ui.tools.u.aP(paramView.context, paramView.JzY.dla));
          }
        }
        if (paramView.JzY.JzT)
        {
          paramView.JAb.setVisibility(0);
          com.tencent.mm.plugin.newtips.a.g.a(paramView, k.wIv, true);
        }
        else
        {
          paramView.JzZ.setVisibility(8);
          paramView.JAa.setVisibility(8);
          paramView.JAb.setVisibility(8);
          com.tencent.mm.plugin.newtips.a.g.a(paramView, k.wIw, false);
          com.tencent.mm.plugin.newtips.a.g.a(paramView, k.wIA, false);
          com.tencent.mm.plugin.newtips.a.g.a(paramView, k.wIv, false);
        }
      }
    }
  }
  
  public static final class b
  {
    int JzS;
    int id;
    int iqb;
    int order;
    
    public b(int paramInt1, int paramInt2, int paramInt3)
    {
      this(paramInt1, paramInt2, paramInt3, 0);
    }
    
    public b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.id = paramInt1;
      this.JzS = paramInt2;
      this.iqb = paramInt3;
      this.order = paramInt4;
    }
  }
  
  public static final class c
  {
    boolean JzT = false;
    ae.d JzU;
    int dla = 0;
    boolean gnS = false;
    
    public c(ae.d paramd)
    {
      this.JzU = paramd;
    }
  }
  
  public static final class d
  {
    String JzV;
    String JzW;
    int JzX;
    int icon;
    String path;
    int textColor;
    
    public d(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3)
    {
      this(paramInt1, paramString1, paramString2, paramInt2, paramInt3, "");
    }
    
    public d(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3)
    {
      this.JzV = paramString1;
      this.JzW = paramString2;
      this.icon = paramInt2;
      this.JzX = paramInt1;
      this.textColor = paramInt3;
      this.path = paramString3;
    }
  }
  
  public static final class e
    implements com.tencent.mm.plugin.newtips.a.a
  {
    TextView JAa;
    View JAb;
    ae.c JzY;
    TextView JzZ;
    Context context;
    View fQH;
    TextView gqi;
    ImageView ka;
    
    public e(Context paramContext, ae.c paramc)
    {
      this.context = paramContext;
      this.JzY = paramc;
    }
    
    public final void a(k paramk, boolean paramBoolean)
    {
      AppMethodBeat.i(224189);
      com.tencent.mm.plugin.newtips.a.g.a(this, paramk, paramBoolean);
      AppMethodBeat.o(224189);
    }
    
    public final boolean a(boolean paramBoolean, dnz paramdnz)
    {
      return false;
    }
    
    public final boolean b(boolean paramBoolean, dnz paramdnz)
    {
      return false;
    }
    
    public final boolean c(boolean paramBoolean, dnz paramdnz)
    {
      return false;
    }
    
    public final boolean d(boolean paramBoolean, dnz paramdnz)
    {
      AppMethodBeat.i(33696);
      if (paramBoolean)
      {
        this.JAa.setVisibility(0);
        if (paramdnz.hiV > 99)
        {
          this.JAa.setText("");
          this.JAa.setBackgroundResource(2131689744);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(33696);
        return true;
        this.JAa.setText(paramdnz.hiV);
        this.JAa.setBackgroundResource(com.tencent.mm.ui.tools.u.aP(this.context, paramdnz.hiV));
        continue;
        this.JAa.setVisibility(8);
      }
    }
    
    public final boolean dnD()
    {
      return false;
    }
    
    public final String getPath()
    {
      return this.JzY.JzU.path;
    }
    
    public final View getRoot()
    {
      return this.fQH;
    }
    
    public final boolean oq(boolean paramBoolean)
    {
      AppMethodBeat.i(224190);
      paramBoolean = com.tencent.mm.plugin.newtips.a.g.a(paramBoolean, this);
      AppMethodBeat.o(224190);
      return paramBoolean;
    }
    
    public final boolean or(boolean paramBoolean)
    {
      AppMethodBeat.i(33694);
      if (paramBoolean) {
        this.JAb.setVisibility(0);
      }
      for (;;)
      {
        AppMethodBeat.o(33694);
        return true;
        this.JAb.setVisibility(8);
      }
    }
    
    public final boolean os(boolean paramBoolean)
    {
      AppMethodBeat.i(33695);
      if (paramBoolean) {
        this.JzZ.setVisibility(0);
      }
      for (;;)
      {
        AppMethodBeat.o(33695);
        return true;
        this.JzZ.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.ae
 * JD-Core Version:    0.7.0.1
 */