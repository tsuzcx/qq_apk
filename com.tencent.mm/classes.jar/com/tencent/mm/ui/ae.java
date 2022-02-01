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
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.fk;
import com.tencent.mm.g.a.ra;
import com.tencent.mm.g.a.wm;
import com.tencent.mm.g.a.wm.b;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.newtips.a.i;
import com.tencent.mm.plugin.newtips.a.k;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.protocal.protobuf.cjh;
import com.tencent.mm.protocal.protobuf.dnc;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.VoipAddressUI;
import com.tencent.mm.ui.tools.s;
import com.tencent.mm.wallet_core.c.aa;
import java.io.IOException;

public final class ae
  extends s
  implements com.tencent.mm.al.f
{
  private static final int[] Jfe = { 2, 1, 10, 20, 2147483647 };
  private static final int[] Jff = { 2, 1, 10, 2147483647 };
  private SparseArray<c> JeZ;
  private a Jfb;
  ad Jfc;
  private boolean Jfd;
  private Context mContext;
  private LayoutInflater mInflater;
  
  public ae(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(33697);
    this.Jfc = null;
    this.mContext = paramAppCompatActivity;
    this.mInflater = LayoutInflater.from(paramAppCompatActivity);
    yD(false);
    this.Jfc = ad.fxC();
    AppMethodBeat.o(33697);
  }
  
  public static d abV(int paramInt)
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
      if (HomeUI.IXG.booleanValue())
      {
        localObject = new d(1, ((Context)localObject).getString(2131761217), "", 2131690971, 2131101171);
      }
      else
      {
        localObject = new d(1, ((Context)localObject).getString(2131761217), "", 2131690972, 0);
        continue;
        if (HomeUI.IXH.booleanValue())
        {
          localObject = new d(2, ((Context)localObject).getString(2131761220), "", 2131690984, 2131101171);
        }
        else
        {
          localObject = new d(2, ((Context)localObject).getString(2131761220), "", 2131690985, 0);
          continue;
          localObject = new d(3, ((Context)localObject).getString(2131761221), "", 2131689854, 0);
          continue;
          if (1 == com.tencent.mm.sdk.platformtools.bt.getInt(com.tencent.mm.n.g.acA().getValue("VOIPCallType"), 0))
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
            ba.aBQ();
            if (((Integer)com.tencent.mm.model.c.ajl().get(al.a.Ivh, Integer.valueOf(0))).intValue() > 1) {
              break;
            }
            localObject = new d(20, ((Context)localObject).getString(2131755231), "", 2131691083, 0, "plus_receiveorpay");
            continue;
            localObject = new d(2147483647, ((Context)localObject).getString(2131763227), "", 2131690982, 0);
            continue;
            localObject = new d(2147483645, ((Context)localObject).getString(2131763204), "", 2131690982, 0);
            continue;
            ba.aBQ();
            paramInt = ((Integer)com.tencent.mm.model.c.ajl().get(al.a.Ivh, Integer.valueOf(0))).intValue();
            int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qzB, 0);
            if ((paramInt != 8) || (i != 0)) {
              break;
            }
            localObject = new d(22, ((Context)localObject).getString(2131762000), "", 2131691587, 0);
            continue;
            ba.aBQ();
            paramInt = ((Integer)com.tencent.mm.model.c.ajl().get(al.a.Ivh, Integer.valueOf(0))).intValue();
            i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qzB, 0);
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
  
  private static cjh fxE()
  {
    AppMethodBeat.i(193738);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.PlusSubMenuHelper", "OfflineH5 getConfig");
    cjh localcjh = new cjh();
    String str = (String)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(al.a.IJB, null);
    if (com.tencent.mm.sdk.platformtools.bt.isNullOrNil(str)) {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.PlusSubMenuHelper", "OfflineH5 get PayIBGQuickGetOverseaWalletConfig failed");
    }
    for (;;)
    {
      AppMethodBeat.o(193738);
      return localcjh;
      try
      {
        localcjh.parseFrom(str.getBytes("ISO-8859-1"));
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.PlusSubMenuHelper", "OfflineH5 getConfig success");
      }
      catch (Exception localException)
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.PlusSubMenuHelper", "OfflineH5 parse PayIBGQuickGetOverseaWalletConfig fail, " + localException.getLocalizedMessage());
      }
    }
  }
  
  private boolean fxF()
  {
    AppMethodBeat.i(193740);
    String str = com.tencent.mm.sdk.platformtools.bt.jn(this.mContext);
    if ((!com.tencent.mm.sdk.platformtools.bt.isNullOrNil(str)) && (str.equals("LauncherUI")))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.PlusSubMenuHelper", "LauncherUI is on ActivityTask Top ");
      AppMethodBeat.o(193740);
      return true;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.PlusSubMenuHelper", "LauncherUI is not on ActivityTask Top：%s", new Object[] { str });
    AppMethodBeat.o(193740);
    return false;
  }
  
  private void xw(boolean paramBoolean)
  {
    AppMethodBeat.i(193737);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.plugin.wallet_index.c.a.b localb = new com.tencent.mm.plugin.wallet_index.c.a.b(((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Ivh, Integer.valueOf(0))).intValue());
    ba.aiU().a(localb, 0);
    this.Jfd = paramBoolean;
    AppMethodBeat.o(193737);
  }
  
  public final BaseAdapter Zp()
  {
    AppMethodBeat.i(33701);
    if (this.Jfb == null) {
      this.Jfb = new a((byte)0);
    }
    a locala = this.Jfb;
    AppMethodBeat.o(33701);
    return locala;
  }
  
  public final boolean il()
  {
    int k = 0;
    AppMethodBeat.i(33698);
    this.Jfc.xv(false);
    if (this.Jfc.JeZ.size() != 0) {
      this.JeZ = this.Jfc.JeZ;
    }
    try
    {
      ba.aBQ();
      if (((Boolean)com.tencent.mm.model.c.ajl().get(al.a.Itk, Boolean.FALSE)).booleanValue())
      {
        int i = k;
        while (i < this.JeZ.size())
        {
          int j = ((c)this.JeZ.get(i)).Jfj.Jfm;
          if (j != 2147483646)
          {
            i += 1;
            continue;
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.PlusSubMenuHelper", "dyna plus config is null, we use default one");
            if (this.JeZ != null)
            {
              this.JeZ.clear();
              label133:
              if (!com.tencent.mm.sdk.platformtools.bt.jk(this.mContext)) {
                break label222;
              }
            }
            label222:
            for (int[] arrayOfInt = Jff;; arrayOfInt = Jfe)
            {
              int m = arrayOfInt.length;
              i = 0;
              j = 0;
              while (i < m)
              {
                c localc = new c(abV(arrayOfInt[i]));
                if (localc.Jfj != null) {
                  this.JeZ.put(j, localc);
                }
                j += 1;
                i += 1;
              }
              this.JeZ = new SparseArray();
              break label133;
            }
          }
        }
        if (i == this.JeZ.size()) {
          this.JeZ.put(this.JeZ.size(), new c(abV(2147483646)));
        }
      }
    }
    catch (Exception localException)
    {
      label268:
      boolean bool;
      break label268;
    }
    if (this.Jfb != null) {
      this.Jfb.notifyDataSetChanged();
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
    int i = ((c)this.JeZ.get(paramInt)).Jfj.Jfm;
    paramAdapterView = new com.tencent.mm.hellhoundlib.b.b();
    paramAdapterView.mr(i);
    paramAdapterView.mr(paramInt);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/PlusSubMenuHelper", "com/tencent/mm/ui/PlusSubMenuHelper", "processOnItemClick", "(II)V", this, paramAdapterView.ahq());
    com.tencent.mm.plugin.report.service.g.yhR.f(11104, new Object[] { Integer.valueOf(i) });
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.widget.recentview.d.class) != null) {
      ((com.tencent.mm.plugin.appbrand.widget.recentview.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.widget.recentview.d.class)).bCb();
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
        this.Jfc.abU(i);
        dismiss();
        AppMethodBeat.o(33699);
        return;
        new Intent().putExtra("invite_friend_scene", 2);
        com.tencent.mm.bs.d.b(this.mContext, "subapp", ".ui.pluginapp.AddMoreFriendsUI", new Intent());
        continue;
        paramView = new Intent(this.mContext, SelectContactUI.class);
        paramView.putExtra("titile", this.mContext.getString(2131755232));
        paramView.putExtra("list_type", 0);
        paramView.putExtra("list_attr", com.tencent.mm.ui.contact.u.I(new int[] { com.tencent.mm.ui.contact.u.Knz, 256, 512 }));
        paramView.putExtra("scene", 7);
        paramView.putExtra("menu_mode", 2);
        paramView.putExtra("create_group_recommend", true);
        paramAdapterView = this.mContext;
        paramView = new com.tencent.mm.hellhoundlib.b.a().bc(paramView);
        com.tencent.mm.hellhoundlib.a.a.a(paramAdapterView, paramView.ahp(), "com/tencent/mm/ui/PlusSubMenuHelper", "processOnItemClick", "(II)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAdapterView.startActivity((Intent)paramView.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAdapterView, "com/tencent/mm/ui/PlusSubMenuHelper", "processOnItemClick", "(II)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        continue;
        paramView = new Intent();
        paramView.setClassName(this.mContext, "com.tencent.mm.ui.tools.ShareImageRedirectUI");
        paramAdapterView = this.mContext;
        paramView = new com.tencent.mm.hellhoundlib.b.a().bc(paramView);
        com.tencent.mm.hellhoundlib.a.a.a(paramAdapterView, paramView.ahp(), "com/tencent/mm/ui/PlusSubMenuHelper", "processOnItemClick", "(II)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAdapterView.startActivity((Intent)paramView.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAdapterView, "com/tencent/mm/ui/PlusSubMenuHelper", "processOnItemClick", "(II)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        continue;
        paramAdapterView = new wm();
        paramAdapterView.dKN.dKP = true;
        com.tencent.mm.sdk.b.a.IbL.l(paramAdapterView);
        paramAdapterView = paramAdapterView.dKO.dKR;
        if (!com.tencent.mm.sdk.platformtools.bt.isNullOrNil(paramAdapterView))
        {
          com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.PlusSubMenuHelper", "Talkroom is on: ".concat(String.valueOf(paramAdapterView)));
          h.e(this.mContext, this.mContext.getString(2131764350), "", this.mContext.getString(2131755835), this.mContext.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(33686);
              Object localObject = new wm();
              ((wm)localObject).dKN.dKQ = true;
              com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
              localObject = new fk();
              ((fk)localObject).dqw.username = com.tencent.mm.bj.d.irv.aMm();
              com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
              VoipAddressUI.kp(ae.b(ae.this));
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
          VoipAddressUI.kp(this.mContext);
          continue;
          ba.aBQ();
          if (!com.tencent.mm.model.c.isSDCardAvailable())
          {
            t.g(this.mContext, null);
          }
          else
          {
            ba.aBQ();
            paramAdapterView = (String)com.tencent.mm.model.c.ajl().get(2, null);
            paramView = new Intent();
            paramView.putExtra("sns_userName", paramAdapterView);
            paramView.setFlags(536870912);
            paramView.addFlags(67108864);
            ba.aBQ();
            paramInt = com.tencent.mm.sdk.platformtools.bt.a((Integer)com.tencent.mm.model.c.ajl().get(68389, null), 0);
            ba.aBQ();
            com.tencent.mm.model.c.ajl().set(68389, Integer.valueOf(paramInt + 1));
            paramView.putExtra("sns_adapter_type", 1);
            com.tencent.mm.bs.d.b(this.mContext, "sns", ".ui.SnsTimeLineUserPagerUI", paramView);
            continue;
            com.tencent.mm.plugin.fav.a.b.b(this.mContext, ".ui.FavoriteIndexUI", new Intent());
            continue;
            bool1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qzF, false);
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.PlusSubMenuHelper", " walletMallV2 switch is ：%s", new Object[] { Boolean.valueOf(bool1) });
            if (bool1)
            {
              com.tencent.mm.bs.d.b(this.mContext, "mall", ".ui.MallIndexUIv2", new Intent());
            }
            else
            {
              com.tencent.mm.bs.d.b(this.mContext, "mall", ".ui.MallIndexUI", new Intent());
              continue;
              paramAdapterView = new Intent();
              paramAdapterView.putExtra("preceding_scence", 2);
              com.tencent.mm.bs.d.b(this.mContext, "emoji", ".ui.v2.EmojiStoreV2UI", paramAdapterView);
              continue;
              com.tencent.mm.bs.d.b(this.mContext, "setting", ".ui.setting.SelfQRCodeUI", new Intent());
              continue;
              com.tencent.mm.plugin.report.service.g.yhR.f(11265, new Object[] { Integer.valueOf(3) });
              if ((!com.tencent.mm.s.a.n(this.mContext, true)) && (!com.tencent.mm.bi.e.aMh()) && (!com.tencent.mm.s.a.p(this.mContext, true)))
              {
                paramAdapterView = new Intent();
                paramAdapterView.putExtra("key_scan_entry_scene", 1);
                paramAdapterView.putExtra("key_config_black_interval", true);
                com.tencent.mm.bs.d.b(this.mContext, "scanner", ".ui.BaseScanUI", paramAdapterView);
                continue;
                ba.aBQ();
                if (com.tencent.mm.model.c.isSDCardAvailable()) {
                  break;
                }
                t.g(this.mContext, null);
              }
            }
          }
        }
      }
      com.tencent.mm.plugin.report.service.f.Oj(10);
      ba.aBQ();
      paramAdapterView = (String)com.tencent.mm.model.c.ajl().get(68377, null);
      ba.aBQ();
      com.tencent.mm.model.c.ajl().set(68377, "");
      paramView = new Intent();
      paramView.putExtra("sns_timeline_NeedFirstLoadint", true);
      if (com.tencent.mm.sdk.platformtools.bt.isNullOrNil(paramAdapterView)) {
        break;
      }
    }
    for (boolean bool1 = false;; bool1 = true)
    {
      boolean bool2 = bool1;
      if (o.zbU != null)
      {
        bool2 = bool1;
        if (o.zbU.bUJ() > 0) {
          bool2 = false;
        }
      }
      paramView.putExtra("sns_resume_state", bool2);
      com.tencent.mm.bs.d.b(this.mContext, "sns", ".ui.SnsTimeLineUI", paramView);
      break;
      ba.aBQ();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        t.g(this.mContext, null);
        break;
      }
      com.tencent.mm.bs.d.Q(this.mContext, "game", ".ui.GameCenterUI");
      new ap().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(33688);
          com.tencent.mm.cq.d.fSu();
          AppMethodBeat.o(33688);
        }
      }, 100L);
      break;
      com.tencent.mm.sdk.b.a.IbL.l(new ra());
      com.tencent.mm.bs.d.Q(this.mContext, "shake", ".ui.ShakeReportUI");
      break;
      ba.aBQ();
      if (!com.tencent.mm.sdk.platformtools.bt.o((Boolean)com.tencent.mm.model.c.ajl().get(4103, null)))
      {
        com.tencent.mm.bs.d.Q(this.mContext, "nearby", ".ui.NearbyFriendsIntroUI");
        break;
      }
      paramAdapterView = com.tencent.mm.model.bt.aCw();
      if (paramAdapterView == null)
      {
        com.tencent.mm.bs.d.Q(this.mContext, "nearby", ".ui.NearbyPersonalInfoUI");
        break;
      }
      paramView = com.tencent.mm.sdk.platformtools.bt.nullAsNil(paramAdapterView.getProvince());
      paramInt = com.tencent.mm.sdk.platformtools.bt.a(Integer.valueOf(paramAdapterView.ePk), 0);
      if ((com.tencent.mm.sdk.platformtools.bt.isNullOrNil(paramView)) || (paramInt == 0))
      {
        com.tencent.mm.bs.d.Q(this.mContext, "nearby", ".ui.NearbyPersonalInfoUI");
        break;
      }
      ba.aBQ();
      paramAdapterView = (Boolean)com.tencent.mm.model.c.ajl().get(4104, null);
      if ((paramAdapterView == null) || (!paramAdapterView.booleanValue()))
      {
        paramAdapterView = LauncherUI.getInstance();
        if (paramAdapterView != null) {
          paramAdapterView.IYQ.getMainTabUI().aVt("tab_find_friend");
        }
        com.tencent.mm.bq.a.hh(this.mContext);
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
            ba.aBQ();
            paramAnonymousDialogInterface = com.tencent.mm.model.c.ajl();
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
              paramAnonymousDialogInterface.IYQ.getMainTabUI().aVt("tab_find_friend");
            }
            com.tencent.mm.bq.a.hh(ae.b(ae.this));
            AppMethodBeat.o(33689);
            return;
          }
        }
      }, null);
      break;
      ba.aBQ();
      if (com.tencent.mm.model.c.aiI())
      {
        com.tencent.mm.bs.d.Q(this.mContext, "webwx", ".ui.WebWXLogoutUI");
        break;
      }
      com.tencent.mm.bs.d.Q(this.mContext, "webwx", ".ui.WebWeiXinIntroductionUI");
      break;
      if ((com.tencent.mm.model.u.aAy() & 0x10000) == 0) {}
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt == 0) {
          break label1747;
        }
        com.tencent.mm.bs.d.Q(this.mContext, "masssend", ".ui.MassSendHistoryUI");
        break;
      }
      label1747:
      com.tencent.mm.bs.d.b(this.mContext, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", "masssendapp"));
      break;
      com.tencent.mm.bs.d.Q(this.mContext, "radar", ".ui.RadarSearchUI");
      break;
      com.tencent.mm.bs.d.Q(this.mContext, "pwdgroup", ".ui.FacingCreateChatRoomAllInOneUI");
      break;
      com.tencent.mm.plugin.report.service.g.yhR.kvStat(10919, "1-6");
      com.tencent.mm.pluginsdk.g.hl(this.mContext);
      break;
      paramAdapterView = new Intent();
      ba.aBQ();
      paramView = (String)com.tencent.mm.model.c.ajl().get(al.a.Izm, "");
      if (!com.tencent.mm.sdk.platformtools.bt.isNullOrNil(paramView))
      {
        paramAdapterView.putExtra("rawUrl", paramView);
        paramAdapterView.putExtra("showShare", true);
        paramAdapterView.putExtra("show_bottom", false);
        com.tencent.mm.bs.d.b(this.mContext, "webview", ".ui.tools.WebViewUI", paramAdapterView);
        break;
      }
      com.tencent.mm.pluginsdk.g.hl(this.mContext);
      break;
      com.tencent.mm.plugin.newtips.a.dun().LQ(4);
      paramAdapterView = this.mContext;
      paramView = new Intent();
      paramView.putExtra("key_from_scene", 2);
      com.tencent.mm.bs.d.b(paramAdapterView, "offline", ".ui.WalletOfflineEntranceUI", paramView);
      if (!com.tencent.mm.z.c.aht().cJ(262159, 266248)) {
        break;
      }
      com.tencent.mm.z.c.aht().cK(262159, 266248);
      com.tencent.mm.plugin.report.service.g.yhR.f(14396, new Object[] { Integer.valueOf(2) });
      break;
      com.tencent.mm.pluginsdk.wallet.f.au(this.mContext, 1);
      break;
      com.tencent.mm.kernel.g.aiU().a(2540, this);
      paramAdapterView = fxE();
      if (com.tencent.mm.sdk.platformtools.bt.isNullOrNil(paramAdapterView.Hdd))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.PlusSubMenuHelper", "OfflineH5 has no cache");
        xw(false);
        break;
      }
      paramLong = System.currentTimeMillis();
      long l = paramLong - paramAdapterView.Hdf;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.PlusSubMenuHelper", "currentTime ：%s ,lastTime：%s,internalTime ：%s", new Object[] { Long.valueOf(paramLong), Long.valueOf(paramAdapterView.Hdf), Long.valueOf(l) });
      if (l < paramAdapterView.Hde)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.PlusSubMenuHelper", "OfflineH5 dont expired，url：%s", new Object[] { paramAdapterView.Hdd });
        com.tencent.mm.wallet_core.ui.e.n(this.mContext, paramAdapterView.Hdd, false);
        xw(true);
        break;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.PlusSubMenuHelper", "OfflineH5 is expired");
      xw(false);
      break;
      paramAdapterView = new Intent();
      paramAdapterView.putExtra("key_from_scene", 2);
      com.tencent.mm.bs.d.b(this.mContext, "offline", ".ui.WalletOfflineEntranceUI", paramAdapterView);
      break;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(193739);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.PlusSubMenuHelper", "on Scene End：errType %s , errCode：%s，errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramn instanceof com.tencent.mm.plugin.wallet_index.c.a.b))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label371;
      }
      paramString = (com.tencent.mm.plugin.wallet_index.c.a.b)paramn;
      if (paramString.Dqg != null) {
        break label268;
      }
      paramString = new cjh();
      if (paramString.dvY != 0) {
        break label312;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.PlusSubMenuHelper", "NetScenePayIBGQuickGetOverseaWallet on SceneEnd ok，pay_wallet_wxapp_h5_url：%s, cache_time：%s", new Object[] { paramString.Hdd, Integer.valueOf(paramString.Hde) });
      if ((!this.Jfd) && (fxF()))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.PlusSubMenuHelper", "on Scene End jump h5 ");
        com.tencent.mm.wallet_core.ui.e.n(this.mContext, paramString.Hdd, false);
      }
      paramString.Hdf = System.currentTimeMillis();
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.PlusSubMenuHelper", "on Scene End currentTime ：%s ", new Object[] { Long.valueOf(paramString.Hdf) });
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.PlusSubMenuHelper", "OfflineH5 setConfig");
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
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.PlusSubMenuHelper", "OfflineH5 setConfig success");
        ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().set(al.a.IJB, paramString);
        ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().fqc();
        com.tencent.mm.kernel.g.aiU().b(2540, this);
        AppMethodBeat.o(193739);
        return;
      }
      catch (IOException paramn)
      {
        break label282;
      }
      paramString = paramString.Dqg;
      break;
      label282:
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.PlusSubMenuHelper", "save config exp, " + paramn.getLocalizedMessage());
      continue;
      label312:
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.PlusSubMenuHelper", "NetScenePayIBGQuickGetOverseaWallet on SceneEnd failed show dialog ");
      if ((!this.Jfd) && (fxF()))
      {
        h.a(this.mContext, paramString.dvZ, "", this.mContext.getString(2131766205), false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(193733);
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.PlusSubMenuHelper", "onDialogClick() ");
            AppMethodBeat.o(193733);
          }
        });
        continue;
        label371:
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.PlusSubMenuHelper", "NetScenePayIBGQuickGetOverseaWallet on SceneEnd faile show error dialog ");
        if ((!this.Jfd) && (fxF()))
        {
          h.a(this.mContext, paramString, "", this.mContext.getString(2131766205), false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(193734);
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.PlusSubMenuHelper", "onDialogClick() ");
              AppMethodBeat.o(193734);
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
        paramView.fOB = localLayoutInflater.inflate(2131494904, paramViewGroup, false);
        paramView.gnM = ((TextView)paramView.fOB.findViewById(2131305902));
        paramView.ka = ((ImageView)paramView.fOB.findViewById(2131300874));
        paramView.Jfo = ((TextView)paramView.fOB.findViewById(2131302799));
        paramView.Jfp = ((TextView)paramView.fOB.findViewById(2131306194));
        paramView.Jfq = paramView.fOB.findViewById(2131302741);
        if (!com.tencent.mm.sdk.platformtools.bt.isNullOrNil(paramView.Jfn.Jfj.Jfk)) {
          paramView.gnM.setText(paramView.Jfn.Jfj.Jfk);
        }
        if (paramView.Jfn.Jfj.textColor > 0) {
          paramView.gnM.setTextColor(com.tencent.mm.cc.a.n(aj.getContext(), paramView.Jfn.Jfj.textColor));
        }
        if (paramView.Jfn.Jfj.icon <= 0) {
          break label425;
        }
        paramView.ka.setVisibility(0);
        paramView.ka.setImageResource(paramView.Jfn.Jfj.icon);
        if (!com.tencent.mm.sdk.platformtools.bt.isNullOrNil(paramView.Jfn.Jfj.Jfl)) {
          paramView.ka.setContentDescription(paramView.Jfn.Jfj.Jfl);
        }
        paramView.Jfp.setBackgroundResource(com.tencent.mm.ui.tools.u.kE(paramView.context));
        if (paramInt == 0) {
          break label437;
        }
        paramView.fOB.setBackgroundResource(2131234277);
        label314:
        paramView.Jfo.setTextSize(0, com.tencent.mm.cc.a.ay(paramView.context, 2131166950));
        if ((!paramView.Jfn.glx) && (paramView.Jfn.djY <= 0) && (!paramView.Jfn.Jfi)) {
          break label449;
        }
        bool = true;
        label365:
        if (!com.tencent.mm.plugin.newtips.a.g.a(bool, paramView))
        {
          if (!paramView.Jfn.glx) {
            break label455;
          }
          paramView.Jfo.setVisibility(0);
          com.tencent.mm.plugin.newtips.a.g.a(paramView, k.wsM, true);
        }
      }
      for (;;)
      {
        com.tencent.mm.plugin.newtips.a.dun().h(paramView);
        paramView = paramView.fOB;
        AppMethodBeat.o(33691);
        return paramView;
        paramInt = 0;
        break;
        label425:
        paramView.ka.setVisibility(8);
        break label254;
        label437:
        paramView.fOB.setBackgroundResource(2131234276);
        break label314;
        label449:
        bool = false;
        break label365;
        label455:
        if (paramView.Jfn.djY > 0)
        {
          paramView.Jfp.setVisibility(0);
          if (paramView.Jfn.djY > 99)
          {
            paramView.Jfp.setText("");
            paramView.Jfp.setBackgroundResource(2131689744);
          }
          for (;;)
          {
            com.tencent.mm.plugin.newtips.a.g.a(paramView, k.wsQ, true);
            break;
            paramView.Jfp.setText(paramView.Jfn.djY);
            paramView.Jfp.setBackgroundResource(com.tencent.mm.ui.tools.u.aP(paramView.context, paramView.Jfn.djY));
          }
        }
        if (paramView.Jfn.Jfi)
        {
          paramView.Jfq.setVisibility(0);
          com.tencent.mm.plugin.newtips.a.g.a(paramView, k.wsL, true);
        }
        else
        {
          paramView.Jfo.setVisibility(8);
          paramView.Jfp.setVisibility(8);
          paramView.Jfq.setVisibility(8);
          com.tencent.mm.plugin.newtips.a.g.a(paramView, k.wsM, false);
          com.tencent.mm.plugin.newtips.a.g.a(paramView, k.wsQ, false);
          com.tencent.mm.plugin.newtips.a.g.a(paramView, k.wsL, false);
        }
      }
    }
  }
  
  public static final class b
  {
    int Jfh;
    int id;
    int inh;
    int order;
    
    public b(int paramInt1, int paramInt2, int paramInt3)
    {
      this(paramInt1, paramInt2, paramInt3, 0);
    }
    
    public b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.id = paramInt1;
      this.Jfh = paramInt2;
      this.inh = paramInt3;
      this.order = paramInt4;
    }
  }
  
  public static final class c
  {
    boolean Jfi = false;
    ae.d Jfj;
    int djY = 0;
    boolean glx = false;
    
    public c(ae.d paramd)
    {
      this.Jfj = paramd;
    }
  }
  
  public static final class d
  {
    String Jfk;
    String Jfl;
    int Jfm;
    int icon;
    String path;
    int textColor;
    
    public d(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3)
    {
      this(paramInt1, paramString1, paramString2, paramInt2, paramInt3, "");
    }
    
    public d(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3)
    {
      this.Jfk = paramString1;
      this.Jfl = paramString2;
      this.icon = paramInt2;
      this.Jfm = paramInt1;
      this.textColor = paramInt3;
      this.path = paramString3;
    }
  }
  
  public static final class e
    implements com.tencent.mm.plugin.newtips.a.a
  {
    ae.c Jfn;
    TextView Jfo;
    TextView Jfp;
    View Jfq;
    Context context;
    View fOB;
    TextView gnM;
    ImageView ka;
    
    public e(Context paramContext, ae.c paramc)
    {
      this.context = paramContext;
      this.Jfn = paramc;
    }
    
    public final void a(k paramk, boolean paramBoolean)
    {
      AppMethodBeat.i(221396);
      com.tencent.mm.plugin.newtips.a.g.a(this, paramk, paramBoolean);
      AppMethodBeat.o(221396);
    }
    
    public final boolean a(boolean paramBoolean, dnc paramdnc)
    {
      return false;
    }
    
    public final boolean b(boolean paramBoolean, dnc paramdnc)
    {
      return false;
    }
    
    public final boolean c(boolean paramBoolean, dnc paramdnc)
    {
      return false;
    }
    
    public final boolean d(boolean paramBoolean, dnc paramdnc)
    {
      AppMethodBeat.i(33696);
      if (paramBoolean)
      {
        this.Jfp.setVisibility(0);
        if (paramdnc.hgh > 99)
        {
          this.Jfp.setText("");
          this.Jfp.setBackgroundResource(2131689744);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(33696);
        return true;
        this.Jfp.setText(paramdnc.hgh);
        this.Jfp.setBackgroundResource(com.tencent.mm.ui.tools.u.aP(this.context, paramdnc.hgh));
        continue;
        this.Jfp.setVisibility(8);
      }
    }
    
    public final boolean dkD()
    {
      return false;
    }
    
    public final String getPath()
    {
      return this.Jfn.Jfj.path;
    }
    
    public final View getRoot()
    {
      return this.fOB;
    }
    
    public final boolean ol(boolean paramBoolean)
    {
      AppMethodBeat.i(221397);
      paramBoolean = com.tencent.mm.plugin.newtips.a.g.a(paramBoolean, this);
      AppMethodBeat.o(221397);
      return paramBoolean;
    }
    
    public final boolean om(boolean paramBoolean)
    {
      AppMethodBeat.i(33694);
      if (paramBoolean) {
        this.Jfq.setVisibility(0);
      }
      for (;;)
      {
        AppMethodBeat.o(33694);
        return true;
        this.Jfq.setVisibility(8);
      }
    }
    
    public final boolean on(boolean paramBoolean)
    {
      AppMethodBeat.i(33695);
      if (paramBoolean) {
        this.Jfo.setVisibility(0);
      }
      for (;;)
      {
        AppMethodBeat.o(33695);
        return true;
        this.Jfo.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.ae
 * JD-Core Version:    0.7.0.1
 */