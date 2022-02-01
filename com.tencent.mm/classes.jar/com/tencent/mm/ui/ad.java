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
import com.tencent.mm.g.a.fg;
import com.tencent.mm.g.a.qg;
import com.tencent.mm.g.a.vj;
import com.tencent.mm.g.a.vj.b;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bs;
import com.tencent.mm.plugin.newtips.a.i;
import com.tencent.mm.plugin.newtips.a.k;
import com.tencent.mm.plugin.sns.c.o;
import com.tencent.mm.protocal.protobuf.dcb;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.VoipAddressUI;
import com.tencent.mm.ui.tools.s;

public final class ad
  extends s
{
  private static final int[] FRJ = { 2, 1, 10, 20, 2147483647 };
  private static final int[] FRK = { 2, 1, 10, 2147483647 };
  private SparseArray<c> FRF;
  private a FRH;
  ac FRI;
  private Context mContext;
  private LayoutInflater mInflater;
  
  public ad(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(33697);
    this.FRI = null;
    this.mContext = paramAppCompatActivity;
    this.mInflater = LayoutInflater.from(paramAppCompatActivity);
    wI(false);
    this.FRI = ac.eRH();
    AppMethodBeat.o(33697);
  }
  
  public static d XA(int paramInt)
  {
    AppMethodBeat.i(33700);
    Object localObject = aj.getContext();
    switch (paramInt)
    {
    default: 
      localObject = null;
    }
    for (;;)
    {
      AppMethodBeat.o(33700);
      return localObject;
      if (HomeUI.FKR.booleanValue())
      {
        localObject = new d(1, ((Context)localObject).getString(2131761217), "", 2131690971, 2131101171);
      }
      else
      {
        localObject = new d(1, ((Context)localObject).getString(2131761217), "", 2131690972, 0);
        continue;
        if (HomeUI.FKS.booleanValue())
        {
          localObject = new d(2, ((Context)localObject).getString(2131761220), "", 2131690984, 2131101171);
        }
        else
        {
          localObject = new d(2, ((Context)localObject).getString(2131761220), "", 2131690985, 0);
          continue;
          localObject = new d(3, ((Context)localObject).getString(2131761221), "", 2131689854, 0);
          continue;
          if (1 == bt.getInt(com.tencent.mm.m.g.Zd().getValue("VOIPCallType"), 0))
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
            az.arV();
            if (((Integer)com.tencent.mm.model.c.afk().get(ae.a.Fla, Integer.valueOf(0))).intValue() > 1) {
              break;
            }
            localObject = new d(20, ((Context)localObject).getString(2131755231), "", 2131691083, 0, "plus_receiveorpay");
            continue;
            localObject = new d(2147483647, ((Context)localObject).getString(2131763227), "", 2131690982, 0);
            continue;
            localObject = new d(2147483645, ((Context)localObject).getString(2131763204), "", 2131690982, 0);
            continue;
            az.arV();
            if (((Integer)com.tencent.mm.model.c.afk().get(ae.a.Fla, Integer.valueOf(0))).intValue() != 8) {
              break;
            }
            localObject = new d(22, ((Context)localObject).getString(2131762000), "", 2131690963, 0);
            continue;
            localObject = new d(2147483646, "TIT", "", 2131690976, 0);
          }
        }
      }
    }
  }
  
  public final BaseAdapter VY()
  {
    AppMethodBeat.i(33701);
    if (this.FRH == null) {
      this.FRH = new a((byte)0);
    }
    a locala = this.FRH;
    AppMethodBeat.o(33701);
    return locala;
  }
  
  public final boolean hM()
  {
    int k = 0;
    AppMethodBeat.i(33698);
    this.FRI.vG(false);
    if (this.FRI.FRF.size() != 0) {
      this.FRF = this.FRI.FRF;
    }
    try
    {
      az.arV();
      if (((Boolean)com.tencent.mm.model.c.afk().get(ae.a.Fjd, Boolean.FALSE)).booleanValue())
      {
        int i = k;
        while (i < this.FRF.size())
        {
          int j = ((c)this.FRF.get(i)).FRO.FRR;
          if (j != 2147483646)
          {
            i += 1;
            continue;
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.PlusSubMenuHelper", "dyna plus config is null, we use default one");
            if (this.FRF != null)
            {
              this.FRF.clear();
              label131:
              if (!bt.iP(this.mContext)) {
                break label220;
              }
            }
            label220:
            for (int[] arrayOfInt = FRK;; arrayOfInt = FRJ)
            {
              int m = arrayOfInt.length;
              i = 0;
              j = 0;
              while (i < m)
              {
                c localc = new c(XA(arrayOfInt[i]));
                if (localc.FRO != null) {
                  this.FRF.put(j, localc);
                }
                j += 1;
                i += 1;
              }
              this.FRF = new SparseArray();
              break label131;
            }
          }
        }
        if (i == this.FRF.size()) {
          this.FRF.put(this.FRF.size(), new c(XA(2147483646)));
        }
      }
    }
    catch (Exception localException)
    {
      label265:
      boolean bool;
      break label265;
    }
    if (this.FRH != null) {
      this.FRH.notifyDataSetChanged();
    }
    bool = super.hM();
    AppMethodBeat.o(33698);
    return bool;
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, final View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(33699);
    if ((this.mContext instanceof AppCompatActivity)) {
      ((AppCompatActivity)this.mContext).supportInvalidateOptionsMenu();
    }
    int i = ((c)this.FRF.get(paramInt)).FRO.FRR;
    paramAdapterView = new com.tencent.mm.hellhoundlib.b.b();
    paramAdapterView.lT(i);
    paramAdapterView.lT(paramInt);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/PlusSubMenuHelper", "com/tencent/mm/ui/PlusSubMenuHelper", "processOnItemClick", "(II)V", this, paramAdapterView.ado());
    com.tencent.mm.plugin.report.service.h.vKh.f(11104, new Object[] { Integer.valueOf(i) });
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.widget.recentview.d.class) != null) {
      ((com.tencent.mm.plugin.appbrand.widget.recentview.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.widget.recentview.d.class)).bqV();
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
        this.FRI.Xz(i);
        dismiss();
        AppMethodBeat.o(33699);
        return;
        new Intent().putExtra("invite_friend_scene", 2);
        com.tencent.mm.bs.d.b(this.mContext, "subapp", ".ui.pluginapp.AddMoreFriendsUI", new Intent());
        continue;
        paramView = new Intent(this.mContext, SelectContactUI.class);
        paramView.putExtra("titile", this.mContext.getString(2131755232));
        paramView.putExtra("list_type", 0);
        paramView.putExtra("list_attr", com.tencent.mm.ui.contact.u.I(new int[] { com.tencent.mm.ui.contact.u.GWD, 256, 512 }));
        paramView.putExtra("scene", 7);
        paramView.putExtra("create_group_recommend", true);
        paramAdapterView = this.mContext;
        paramView = new com.tencent.mm.hellhoundlib.b.a().bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.a(paramAdapterView, paramView.adn(), "com/tencent/mm/ui/PlusSubMenuHelper", "processOnItemClick", "(II)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAdapterView.startActivity((Intent)paramView.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAdapterView, "com/tencent/mm/ui/PlusSubMenuHelper", "processOnItemClick", "(II)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        continue;
        paramView = new Intent();
        paramView.setClassName(this.mContext, "com.tencent.mm.ui.tools.ShareImageRedirectUI");
        paramAdapterView = this.mContext;
        paramView = new com.tencent.mm.hellhoundlib.b.a().bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.a(paramAdapterView, paramView.adn(), "com/tencent/mm/ui/PlusSubMenuHelper", "processOnItemClick", "(II)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAdapterView.startActivity((Intent)paramView.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAdapterView, "com/tencent/mm/ui/PlusSubMenuHelper", "processOnItemClick", "(II)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        continue;
        paramAdapterView = new vj();
        paramAdapterView.dAP.dAR = true;
        com.tencent.mm.sdk.b.a.ESL.l(paramAdapterView);
        paramAdapterView = paramAdapterView.dAQ.dAT;
        if (!bt.isNullOrNil(paramAdapterView))
        {
          com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.PlusSubMenuHelper", "Talkroom is on: ".concat(String.valueOf(paramAdapterView)));
          com.tencent.mm.ui.base.h.d(this.mContext, this.mContext.getString(2131764350), "", this.mContext.getString(2131755835), this.mContext.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(33686);
              Object localObject = new vj();
              ((vj)localObject).dAP.dAS = true;
              com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
              localObject = new fg();
              ((fg)localObject).dhF.username = com.tencent.mm.bj.d.hxy.aCm();
              com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
              VoipAddressUI.jS(ad.b(ad.this));
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
          VoipAddressUI.jS(this.mContext);
          continue;
          az.arV();
          if (!com.tencent.mm.model.c.isSDCardAvailable())
          {
            t.g(this.mContext, null);
          }
          else
          {
            az.arV();
            paramAdapterView = (String)com.tencent.mm.model.c.afk().get(2, null);
            paramView = new Intent();
            paramView.putExtra("sns_userName", paramAdapterView);
            paramView.setFlags(536870912);
            paramView.addFlags(67108864);
            az.arV();
            paramInt = bt.a((Integer)com.tencent.mm.model.c.afk().get(68389, null), 0);
            az.arV();
            com.tencent.mm.model.c.afk().set(68389, Integer.valueOf(paramInt + 1));
            paramView.putExtra("sns_adapter_type", 1);
            com.tencent.mm.bs.d.b(this.mContext, "sns", ".ui.SnsTimeLineUserPagerUI", paramView);
            continue;
            com.tencent.mm.plugin.fav.a.b.b(this.mContext, ".ui.FavoriteIndexUI", new Intent());
            continue;
            com.tencent.mm.bs.d.b(this.mContext, "mall", ".ui.MallIndexUI", new Intent());
            continue;
            paramAdapterView = new Intent();
            paramAdapterView.putExtra("preceding_scence", 2);
            com.tencent.mm.bs.d.b(this.mContext, "emoji", ".ui.v2.EmojiStoreV2UI", paramAdapterView);
            continue;
            com.tencent.mm.bs.d.b(this.mContext, "setting", ".ui.setting.SelfQRCodeUI", new Intent());
            continue;
            com.tencent.mm.plugin.report.service.h.vKh.f(11265, new Object[] { Integer.valueOf(3) });
            if ((!com.tencent.mm.r.a.cd(this.mContext)) && (!com.tencent.mm.bi.e.aCh()))
            {
              paramAdapterView = new Intent();
              paramAdapterView.putExtra("key_scan_entry_scene", 1);
              paramAdapterView.putExtra("key_config_black_interval", true);
              com.tencent.mm.bs.d.b(this.mContext, "scanner", ".ui.BaseScanUI", paramAdapterView);
              continue;
              az.arV();
              if (com.tencent.mm.model.c.isSDCardAvailable()) {
                break;
              }
              t.g(this.mContext, null);
            }
          }
        }
      }
      com.tencent.mm.plugin.report.service.g.KI(10);
      az.arV();
      paramAdapterView = (String)com.tencent.mm.model.c.afk().get(68377, null);
      az.arV();
      com.tencent.mm.model.c.afk().set(68377, "");
      paramView = new Intent();
      paramView.putExtra("sns_timeline_NeedFirstLoadint", true);
      if (bt.isNullOrNil(paramAdapterView)) {
        break;
      }
    }
    for (boolean bool1 = false;; bool1 = true)
    {
      boolean bool2 = bool1;
      if (o.wzI != null)
      {
        bool2 = bool1;
        if (o.wzI.bIR() > 0) {
          bool2 = false;
        }
      }
      paramView.putExtra("sns_resume_state", bool2);
      com.tencent.mm.bs.d.b(this.mContext, "sns", ".ui.SnsTimeLineUI", paramView);
      break;
      az.arV();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        t.g(this.mContext, null);
        break;
      }
      com.tencent.mm.bs.d.O(this.mContext, "game", ".ui.GameCenterUI");
      new ap().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(33688);
          com.tencent.mm.cr.d.fkP();
          AppMethodBeat.o(33688);
        }
      }, 100L);
      break;
      com.tencent.mm.sdk.b.a.ESL.l(new qg());
      com.tencent.mm.bs.d.O(this.mContext, "shake", ".ui.ShakeReportUI");
      break;
      az.arV();
      if (!bt.l((Boolean)com.tencent.mm.model.c.afk().get(4103, null)))
      {
        com.tencent.mm.bs.d.O(this.mContext, "nearby", ".ui.NearbyFriendsIntroUI");
        break;
      }
      paramAdapterView = bs.asC();
      if (paramAdapterView == null)
      {
        com.tencent.mm.bs.d.O(this.mContext, "nearby", ".ui.NearbyPersonalInfoUI");
        break;
      }
      paramView = bt.nullAsNil(paramAdapterView.getProvince());
      paramInt = bt.a(Integer.valueOf(paramAdapterView.evp), 0);
      if ((bt.isNullOrNil(paramView)) || (paramInt == 0))
      {
        com.tencent.mm.bs.d.O(this.mContext, "nearby", ".ui.NearbyPersonalInfoUI");
        break;
      }
      az.arV();
      paramAdapterView = (Boolean)com.tencent.mm.model.c.afk().get(4104, null);
      if ((paramAdapterView == null) || (!paramAdapterView.booleanValue()))
      {
        paramAdapterView = LauncherUI.getInstance();
        if (paramAdapterView != null) {
          paramAdapterView.FMb.getMainTabUI().aKb("tab_find_friend");
        }
        com.tencent.mm.bq.a.gR(this.mContext);
        break;
      }
      paramAdapterView = View.inflate(this.mContext, 2131494579, null);
      paramView = (CheckBox)paramAdapterView.findViewById(2131301369);
      paramView.setChecked(false);
      com.tencent.mm.ui.base.h.a(this.mContext, this.mContext.getString(2131755906), paramAdapterView, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(33689);
          if (paramView != null)
          {
            az.arV();
            paramAnonymousDialogInterface = com.tencent.mm.model.c.afk();
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
              paramAnonymousDialogInterface.FMb.getMainTabUI().aKb("tab_find_friend");
            }
            com.tencent.mm.bq.a.gR(ad.b(ad.this));
            AppMethodBeat.o(33689);
            return;
          }
        }
      }, null);
      break;
      az.arV();
      if (com.tencent.mm.model.c.aeG())
      {
        com.tencent.mm.bs.d.O(this.mContext, "webwx", ".ui.WebWXLogoutUI");
        break;
      }
      com.tencent.mm.bs.d.O(this.mContext, "webwx", ".ui.WebWeiXinIntroductionUI");
      break;
      if ((com.tencent.mm.model.u.aqS() & 0x10000) == 0) {}
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt == 0) {
          break label1650;
        }
        com.tencent.mm.bs.d.O(this.mContext, "masssend", ".ui.MassSendHistoryUI");
        break;
      }
      label1650:
      com.tencent.mm.bs.d.b(this.mContext, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", "masssendapp"));
      break;
      com.tencent.mm.bs.d.O(this.mContext, "radar", ".ui.RadarSearchUI");
      break;
      com.tencent.mm.bs.d.O(this.mContext, "pwdgroup", ".ui.FacingCreateChatRoomAllInOneUI");
      break;
      com.tencent.mm.plugin.report.service.h.vKh.kvStat(10919, "1-6");
      com.tencent.mm.pluginsdk.f.gV(this.mContext);
      break;
      paramAdapterView = new Intent();
      az.arV();
      paramView = (String)com.tencent.mm.model.c.afk().get(ae.a.Fpf, "");
      if (!bt.isNullOrNil(paramView))
      {
        paramAdapterView.putExtra("rawUrl", paramView);
        paramAdapterView.putExtra("showShare", true);
        paramAdapterView.putExtra("show_bottom", false);
        com.tencent.mm.bs.d.b(this.mContext, "webview", ".ui.tools.WebViewUI", paramAdapterView);
        break;
      }
      com.tencent.mm.pluginsdk.f.gV(this.mContext);
      break;
      com.tencent.mm.plugin.newtips.a.cWs().Ip(4);
      paramAdapterView = this.mContext;
      paramView = new Intent();
      paramView.putExtra("key_from_scene", 2);
      com.tencent.mm.bs.d.b(paramAdapterView, "offline", ".ui.WalletOfflineEntranceUI", paramView);
      if (!com.tencent.mm.z.c.adr().cJ(262159, 266248)) {
        break;
      }
      com.tencent.mm.z.c.adr().cK(262159, 266248);
      com.tencent.mm.plugin.report.service.h.vKh.f(14396, new Object[] { Integer.valueOf(2) });
      break;
      com.tencent.mm.pluginsdk.wallet.f.al(this.mContext, 1);
      break;
      paramAdapterView = new Intent();
      paramAdapterView.putExtra("key_from_scene", 2);
      com.tencent.mm.bs.d.b(this.mContext, "offline", ".ui.WalletOfflineEntranceUI", paramAdapterView);
      break;
    }
  }
  
  final class a
    extends BaseAdapter
  {
    private a() {}
    
    public final int getCount()
    {
      AppMethodBeat.i(33690);
      int i = ad.a(ad.this).size();
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
      paramView = (ad.c)ad.a(ad.this).get(paramInt);
      paramView = new ad.e(ad.b(ad.this), paramView);
      LayoutInflater localLayoutInflater = ad.c(ad.this);
      label254:
      boolean bool;
      if (paramInt == getCount() - 1)
      {
        paramInt = 1;
        paramView.frN = localLayoutInflater.inflate(2131494904, paramViewGroup, false);
        paramView.fQp = ((TextView)paramView.frN.findViewById(2131305902));
        paramView.hg = ((ImageView)paramView.frN.findViewById(2131300874));
        paramView.FRT = ((TextView)paramView.frN.findViewById(2131302799));
        paramView.FRU = ((TextView)paramView.frN.findViewById(2131306194));
        paramView.FRV = paramView.frN.findViewById(2131302741);
        if (!bt.isNullOrNil(paramView.FRS.FRO.FRP)) {
          paramView.fQp.setText(paramView.FRS.FRO.FRP);
        }
        if (paramView.FRS.FRO.textColor > 0) {
          paramView.fQp.setTextColor(com.tencent.mm.cd.a.n(aj.getContext(), paramView.FRS.FRO.textColor));
        }
        if (paramView.FRS.FRO.icon <= 0) {
          break label425;
        }
        paramView.hg.setVisibility(0);
        paramView.hg.setImageResource(paramView.FRS.FRO.icon);
        if (!bt.isNullOrNil(paramView.FRS.FRO.FRQ)) {
          paramView.hg.setContentDescription(paramView.FRS.FRO.FRQ);
        }
        paramView.FRU.setBackgroundResource(com.tencent.mm.ui.tools.u.kh(paramView.context));
        if (paramInt == 0) {
          break label437;
        }
        paramView.frN.setBackgroundResource(2131234277);
        label314:
        paramView.FRT.setTextSize(0, com.tencent.mm.cd.a.ap(paramView.context, 2131166950));
        if ((!paramView.FRS.fOi) && (paramView.FRS.dbk <= 0) && (!paramView.FRS.FRN)) {
          break label449;
        }
        bool = true;
        label365:
        if (!com.tencent.mm.plugin.newtips.a.g.a(bool, paramView))
        {
          if (!paramView.FRS.fOi) {
            break label455;
          }
          paramView.FRT.setVisibility(0);
          com.tencent.mm.plugin.newtips.a.g.a(paramView, k.uew, true);
        }
      }
      for (;;)
      {
        com.tencent.mm.plugin.newtips.a.cWs().h(paramView);
        paramView = paramView.frN;
        AppMethodBeat.o(33691);
        return paramView;
        paramInt = 0;
        break;
        label425:
        paramView.hg.setVisibility(8);
        break label254;
        label437:
        paramView.frN.setBackgroundResource(2131234276);
        break label314;
        label449:
        bool = false;
        break label365;
        label455:
        if (paramView.FRS.dbk > 0)
        {
          paramView.FRU.setVisibility(0);
          if (paramView.FRS.dbk > 99)
          {
            paramView.FRU.setText("");
            paramView.FRU.setBackgroundResource(2131689744);
          }
          for (;;)
          {
            com.tencent.mm.plugin.newtips.a.g.a(paramView, k.ueA, true);
            break;
            paramView.FRU.setText(paramView.FRS.dbk);
            paramView.FRU.setBackgroundResource(com.tencent.mm.ui.tools.u.aG(paramView.context, paramView.FRS.dbk));
          }
        }
        if (paramView.FRS.FRN)
        {
          paramView.FRV.setVisibility(0);
          com.tencent.mm.plugin.newtips.a.g.a(paramView, k.uev, true);
        }
        else
        {
          paramView.FRT.setVisibility(8);
          paramView.FRU.setVisibility(8);
          paramView.FRV.setVisibility(8);
          com.tencent.mm.plugin.newtips.a.g.a(paramView, k.uew, false);
          com.tencent.mm.plugin.newtips.a.g.a(paramView, k.ueA, false);
          com.tencent.mm.plugin.newtips.a.g.a(paramView, k.uev, false);
        }
      }
    }
  }
  
  public static final class b
  {
    int FRM;
    int htk;
    int id;
    int order;
    
    public b(int paramInt1, int paramInt2, int paramInt3)
    {
      this(paramInt1, paramInt2, paramInt3, 0);
    }
    
    public b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.id = paramInt1;
      this.FRM = paramInt2;
      this.htk = paramInt3;
      this.order = paramInt4;
    }
  }
  
  public static final class c
  {
    boolean FRN = false;
    ad.d FRO;
    int dbk = 0;
    boolean fOi = false;
    
    public c(ad.d paramd)
    {
      this.FRO = paramd;
    }
  }
  
  public static final class d
  {
    String FRP;
    String FRQ;
    int FRR;
    int icon;
    String path;
    int textColor;
    
    public d(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3)
    {
      this(paramInt1, paramString1, paramString2, paramInt2, paramInt3, "");
    }
    
    public d(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3)
    {
      this.FRP = paramString1;
      this.FRQ = paramString2;
      this.icon = paramInt2;
      this.FRR = paramInt1;
      this.textColor = paramInt3;
      this.path = paramString3;
    }
  }
  
  public static final class e
    implements com.tencent.mm.plugin.newtips.a.a
  {
    ad.c FRS;
    TextView FRT;
    TextView FRU;
    View FRV;
    Context context;
    TextView fQp;
    View frN;
    ImageView hg;
    
    public e(Context paramContext, ad.c paramc)
    {
      this.context = paramContext;
      this.FRS = paramc;
    }
    
    public final void a(k paramk, boolean paramBoolean)
    {
      AppMethodBeat.i(204939);
      com.tencent.mm.plugin.newtips.a.g.a(this, paramk, paramBoolean);
      AppMethodBeat.o(204939);
    }
    
    public final boolean a(boolean paramBoolean, dcb paramdcb)
    {
      return false;
    }
    
    public final boolean b(boolean paramBoolean, dcb paramdcb)
    {
      return false;
    }
    
    public final boolean c(boolean paramBoolean, dcb paramdcb)
    {
      return false;
    }
    
    public final boolean cND()
    {
      return false;
    }
    
    public final boolean d(boolean paramBoolean, dcb paramdcb)
    {
      AppMethodBeat.i(33696);
      if (paramBoolean)
      {
        this.FRU.setVisibility(0);
        if (paramdcb.glx > 99)
        {
          this.FRU.setText("");
          this.FRU.setBackgroundResource(2131689744);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(33696);
        return true;
        this.FRU.setText(paramdcb.glx);
        this.FRU.setBackgroundResource(com.tencent.mm.ui.tools.u.aG(this.context, paramdcb.glx));
        continue;
        this.FRU.setVisibility(8);
      }
    }
    
    public final String getPath()
    {
      return this.FRS.FRO.path;
    }
    
    public final View getRoot()
    {
      return this.frN;
    }
    
    public final boolean mY(boolean paramBoolean)
    {
      AppMethodBeat.i(204940);
      paramBoolean = com.tencent.mm.plugin.newtips.a.g.a(paramBoolean, this);
      AppMethodBeat.o(204940);
      return paramBoolean;
    }
    
    public final boolean mZ(boolean paramBoolean)
    {
      AppMethodBeat.i(33694);
      if (paramBoolean) {
        this.FRV.setVisibility(0);
      }
      for (;;)
      {
        AppMethodBeat.o(33694);
        return true;
        this.FRV.setVisibility(8);
      }
    }
    
    public final boolean na(boolean paramBoolean)
    {
      AppMethodBeat.i(33695);
      if (paramBoolean) {
        this.FRT.setVisibility(0);
      }
      for (;;)
      {
        AppMethodBeat.o(33695);
        return true;
        this.FRT.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.ad
 * JD-Core Version:    0.7.0.1
 */