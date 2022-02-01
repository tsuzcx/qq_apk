package com.tencent.mm.plugin.nearby.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.o;
import com.tencent.mm.cache.MCacheItem;
import com.tencent.mm.g.a.kk;
import com.tencent.mm.g.a.sk;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.i;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.c;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.blb;
import com.tencent.mm.protocal.protobuf.cwh;
import com.tencent.mm.protocal.protobuf.zh;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.b.b;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@i
public class NearbyFriendsUI
  extends MMActivity
  implements com.tencent.mm.al.g
{
  private com.tencent.mm.modelgeo.d fjC;
  private com.tencent.mm.modelgeo.b.a fjJ;
  private com.tencent.mm.sdk.b.c fjL;
  boolean gqP;
  private ListView inl;
  private List<blb> pLp;
  private boolean sUi;
  private boolean sVh;
  private com.tencent.mm.ui.base.p tipDialog;
  private ViewGroup uaA;
  private View uaB;
  private View uaC;
  private boolean uaD;
  private int uaE;
  private boolean uaF;
  private int uaG;
  private View uaH;
  private b uaI;
  private com.tencent.mm.plugin.nearby.a.c uah;
  private c uas;
  private com.tencent.mm.plugin.nearby.a.c uat;
  private com.tencent.mm.plugin.nearby.a.d uau;
  private Map<String, a> uav;
  private boolean uaw;
  private String[] uax;
  private int uay;
  private BindMobileOrQQHeaderView uaz;
  
  public NearbyFriendsUI()
  {
    AppMethodBeat.i(89866);
    this.tipDialog = null;
    this.pLp = new LinkedList();
    this.uav = new HashMap();
    this.uaw = false;
    this.uay = 1;
    this.uaD = false;
    this.uaF = false;
    this.sUi = false;
    this.uaG = 0;
    this.uaH = null;
    this.fjL = new com.tencent.mm.sdk.b.c() {};
    this.gqP = false;
    this.fjJ = new com.tencent.mm.modelgeo.b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(89846);
        if (NearbyFriendsUI.d(NearbyFriendsUI.this))
        {
          AppMethodBeat.o(89846);
          return false;
        }
        NearbyFriendsUI.e(NearbyFriendsUI.this);
        if (NearbyFriendsUI.this.gqP)
        {
          if (NearbyFriendsUI.f(NearbyFriendsUI.this) != null)
          {
            NearbyFriendsUI.f(NearbyFriendsUI.this).dismiss();
            NearbyFriendsUI.a(NearbyFriendsUI.this, null);
          }
          com.tencent.mm.plugin.report.service.g.KK(11);
          AppMethodBeat.o(89846);
          return false;
        }
        boolean bool;
        if (paramAnonymousBoolean)
        {
          if (NearbyFriendsUI.f(NearbyFriendsUI.this) != null) {
            NearbyFriendsUI.f(NearbyFriendsUI.this).setMessage(NearbyFriendsUI.this.getString(2131761500));
          }
          NearbyFriendsUI.a(NearbyFriendsUI.this, new NearbyFriendsUI.b(NearbyFriendsUI.this, paramAnonymousFloat2, paramAnonymousFloat1, (int)paramAnonymousDouble2));
          com.tencent.mm.modelstat.e locale = com.tencent.mm.modelstat.e.aBE();
          if (paramAnonymousInt == 0)
          {
            paramAnonymousBoolean = false;
            if (NearbyFriendsUI.g(NearbyFriendsUI.this) != null) {
              break label264;
            }
            bool = false;
            label163:
            locale.a(2001, paramAnonymousBoolean, bool, paramAnonymousFloat1, paramAnonymousFloat2, (int)paramAnonymousDouble2);
            NearbyFriendsUI.a(NearbyFriendsUI.this, new com.tencent.mm.plugin.nearby.a.c(NearbyFriendsUI.h(NearbyFriendsUI.this), NearbyFriendsUI.i(NearbyFriendsUI.this).hec, NearbyFriendsUI.i(NearbyFriendsUI.this).heb, NearbyFriendsUI.i(NearbyFriendsUI.this).accuracy, paramAnonymousInt, "", ""));
            com.tencent.mm.kernel.g.aeS().a(NearbyFriendsUI.b(NearbyFriendsUI.this), 0);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(89846);
          return false;
          paramAnonymousBoolean = true;
          break;
          label264:
          bool = NearbyFriendsUI.g(NearbyFriendsUI.this).hem;
          break label163;
          com.tencent.mm.plugin.report.service.g.KK(11);
          if (NearbyFriendsUI.f(NearbyFriendsUI.this) != null)
          {
            NearbyFriendsUI.f(NearbyFriendsUI.this).dismiss();
            NearbyFriendsUI.a(NearbyFriendsUI.this, null);
          }
          NearbyFriendsUI.this.findViewById(2131302691).setVisibility(0);
          NearbyFriendsUI.j(NearbyFriendsUI.this).setVisibility(8);
          NearbyFriendsUI.k(NearbyFriendsUI.this);
          if ((!NearbyFriendsUI.l(NearbyFriendsUI.this)) && (!com.tencent.mm.modelgeo.d.axU()))
          {
            NearbyFriendsUI.m(NearbyFriendsUI.this);
            com.tencent.mm.ui.base.h.a(NearbyFriendsUI.this, NearbyFriendsUI.this.getString(2131760082), NearbyFriendsUI.this.getString(2131755906), NearbyFriendsUI.this.getString(2131760598), NearbyFriendsUI.this.getString(2131755691), false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(89845);
                com.tencent.mm.modelgeo.d.cv(NearbyFriendsUI.this);
                AppMethodBeat.o(89845);
              }
            }, null);
          }
        }
      }
    };
    AppMethodBeat.o(89866);
  }
  
  private void cWe()
  {
    AppMethodBeat.i(89869);
    View localView;
    Object localObject;
    int i;
    if (com.tencent.mm.bq.a.euw())
    {
      if (this.uaH != null)
      {
        this.inl.removeHeaderView(this.uaH);
        this.uaH = null;
      }
      localView = View.inflate(this, 2131495004, null);
      localObject = (TextView)localView.findViewById(2131304292);
      com.tencent.mm.kernel.g.afz().aeD();
      i = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOF().bIR();
      if (i != 0) {
        break label119;
      }
      localView.setVisibility(8);
      localView = null;
    }
    for (;;)
    {
      this.uaH = localView;
      if (this.uaH != null) {
        this.inl.addHeaderView(this.uaH);
      }
      AppMethodBeat.o(89869);
      return;
      label119:
      localView.setVisibility(0);
      ((TextView)localObject).setText(getResources().getQuantityString(2131623965, i, new Object[] { Integer.valueOf(i) }));
      localObject = (ImageView)localView.findViewById(2131302192);
      bi localbi = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOF().cOP();
      if (localbi != null) {
        a.b.c((ImageView)localObject, localbi.field_sayhiuser);
      }
      localView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(89847);
          NearbyFriendsUI.j(NearbyFriendsUI.this).removeHeaderView(NearbyFriendsUI.n(NearbyFriendsUI.this));
          NearbyFriendsUI.o(NearbyFriendsUI.this);
          paramAnonymousView = new Intent(NearbyFriendsUI.this, NearbySayHiListUI.class);
          paramAnonymousView.putExtra("k_say_hi_type", 2);
          paramAnonymousView.putExtra("show_clear_header", true);
          NearbyFriendsUI.this.startActivityForResult(paramAnonymousView, 2009);
          AppMethodBeat.o(89847);
        }
      });
    }
  }
  
  private void cWf()
  {
    AppMethodBeat.i(89871);
    com.tencent.mm.plugin.nearby.a.hYt.bz(this);
    AppMethodBeat.o(89871);
  }
  
  private void cWg()
  {
    int j = 0;
    AppMethodBeat.i(89877);
    Object localObject1 = new LinkedList();
    int i = 0;
    while (i < this.pLp.size())
    {
      if (!d.If(((blb)this.pLp.get(i)).ijM)) {
        ((List)localObject1).add(this.pLp.get(i));
      }
      i += 1;
    }
    this.pLp.clear();
    this.pLp = ((List)localObject1);
    ad.i("MicroMsg.NearbyFriend", "insertPoiItemList()");
    label133:
    Object localObject2;
    List localList;
    if (!this.pLp.isEmpty())
    {
      i = 1;
      localObject1 = this.uav.keySet().iterator();
      do
      {
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (String)((Iterator)localObject1).next();
        } while (i == 0);
        localObject2 = (a)this.uav.get(localObject2);
      } while ((((a)localObject2).mku) || ((((a)localObject2).uaO > 0) && (((a)localObject2).uaS >= ((a)localObject2).uaO)) || (((a)localObject2).nCF >= ((a)localObject2).uaP));
      localList = this.pLp;
      if ((((a)localObject2).pos >= 0) && (((a)localObject2).pos <= this.pLp.size())) {
        break label306;
      }
    }
    label306:
    for (int k = this.pLp.size();; k = ((a)localObject2).pos + j)
    {
      localList.add(k, d.d(((a)localObject2).id, ((a)localObject2).dub, ((a)localObject2).name, ((a)localObject2).desc, ((a)localObject2).uaR));
      j += 1;
      break label133;
      i = 0;
      break;
    }
    AppMethodBeat.o(89877);
  }
  
  private void getData()
  {
    AppMethodBeat.i(89868);
    this.sUi = false;
    AppCompatActivity localAppCompatActivity = getContext();
    getString(2131755906);
    this.tipDialog = com.tencent.mm.ui.base.h.b(localAppCompatActivity, getString(2131761509), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(89844);
        NearbyFriendsUI.this.gqP = true;
        com.tencent.mm.plugin.report.service.g.KK(11);
        if (NearbyFriendsUI.b(NearbyFriendsUI.this) != null) {
          com.tencent.mm.kernel.g.aeS().a(NearbyFriendsUI.b(NearbyFriendsUI.this));
        }
        ad.i("MicroMsg.NearbyFriend", "[MonsterzDai]  [loading cancel] cancel in loading");
        if (!NearbyFriendsUI.c(NearbyFriendsUI.this))
        {
          NearbyFriendsUI.this.finish();
          ad.i("MicroMsg.NearbyFriend", "[MonsterzDai]  [loading cancel] cancel in first loading");
        }
        AppMethodBeat.o(89844);
      }
    });
    this.gqP = false;
    if (this.fjC != null) {
      this.fjC.a(this.fjJ, true);
    }
    AppMethodBeat.o(89868);
  }
  
  public int getLayoutId()
  {
    return 2131495000;
  }
  
  public void initView()
  {
    AppMethodBeat.i(89870);
    this.inl = ((ListView)findViewById(2131302692));
    this.uas = new c(this);
    Object localObject = this.inl;
    if (this.uaA == null)
    {
      this.uaA = new LinearLayout(this);
      this.uaA.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      ((LinearLayout)this.uaA).setGravity(17);
    }
    this.uaD = true;
    ((ListView)localObject).addHeaderView(this.uaA);
    localObject = com.tencent.mm.m.g.Zd().getValue("LBSShowBindPhone");
    if ((localObject != null) && (((String)localObject).length() > 0)) {}
    try
    {
      this.uaE = Integer.valueOf((String)localObject).intValue();
      localObject = (String)com.tencent.mm.kernel.g.afB().afk().get(6, null);
      if ((localObject != null) && (((String)localObject).length() > 0)) {
        this.uaE = 0;
      }
      this.uaG = 0;
      if (com.tencent.mm.model.a.g.asX().uz("3") != null)
      {
        localObject = com.tencent.mm.model.a.g.asX().uz("3").value;
        locala = com.tencent.mm.plugin.account.friend.a.l.aIL();
        if (((String)localObject).equals("0")) {
          this.uaG = 0;
        }
      }
      else
      {
        if (((this.uaE > 0) || (this.uaG > 0)) && (this.uaG != 1))
        {
          this.uaz = new BindMobileOrQQHeaderView(this);
          this.inl.addHeaderView(this.uaz);
        }
        this.inl.setAdapter(this.uas);
        this.inl.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(89848);
            if (NearbyFriendsUI.p(NearbyFriendsUI.this) <= 0)
            {
              i = paramAnonymousInt;
              if (NearbyFriendsUI.q(NearbyFriendsUI.this) <= 0) {}
            }
            else
            {
              i = paramAnonymousInt - 1;
            }
            paramAnonymousInt = i;
            if (com.tencent.mm.bq.a.euw())
            {
              paramAnonymousInt = i;
              if (NearbyFriendsUI.n(NearbyFriendsUI.this) != null) {
                paramAnonymousInt = i - 1;
              }
            }
            int i = paramAnonymousInt;
            if (NearbyFriendsUI.r(NearbyFriendsUI.this)) {
              i = paramAnonymousInt - 1;
            }
            if ((i < 0) || (i >= NearbyFriendsUI.s(NearbyFriendsUI.this).size()))
            {
              AppMethodBeat.o(89848);
              return;
            }
            paramAnonymousAdapterView = (blb)NearbyFriendsUI.s(NearbyFriendsUI.this).get(i);
            if (NearbyFriendsUI.d.If(paramAnonymousAdapterView.ijM))
            {
              paramAnonymousAdapterView = (NearbyFriendsUI.a)NearbyFriendsUI.t(NearbyFriendsUI.this).get(paramAnonymousAdapterView.mAQ);
              paramAnonymousAdapterView.uaT |= 0x1;
              if (paramAnonymousAdapterView.uaQ == 1)
              {
                paramAnonymousView = new AppBrandStatObject();
                paramAnonymousView.scene = 1134;
                ((com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).a(NearbyFriendsUI.this, paramAnonymousAdapterView.uaR, "", 0, 0, "", paramAnonymousView);
                AppMethodBeat.o(89848);
                return;
              }
              if (paramAnonymousAdapterView.uaQ == 2)
              {
                paramAnonymousView = new Intent();
                paramAnonymousView.putExtra("rawUrl", paramAnonymousAdapterView.uaR);
                paramAnonymousView.putExtra("geta8key_scene", 25);
                paramAnonymousView.putExtra("stastic_scene", 12);
                com.tencent.mm.bs.d.b(NearbyFriendsUI.this.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
              }
              AppMethodBeat.o(89848);
              return;
            }
            paramAnonymousView = paramAnonymousAdapterView.mAQ;
            af localaf = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(paramAnonymousView);
            Object localObject;
            if (com.tencent.mm.n.b.ls(localaf.field_type))
            {
              localObject = new Intent();
              ((Intent)localObject).putExtra("Contact_User", paramAnonymousView);
              ((Intent)localObject).putExtra("Contact_Scene", 18);
              ((Intent)localObject).putExtra("Sns_from_Scene", 18);
              ((Intent)localObject).putExtra("lbs_ticket", paramAnonymousAdapterView.Dqd);
              ((Intent)localObject).putExtra("Contact_IsLbsGotoChatting", true);
              if ((paramAnonymousView != null) && (paramAnonymousView.length() > 0))
              {
                if (localaf.eKB()) {
                  com.tencent.mm.plugin.report.service.h.vKh.kvStat(10298, paramAnonymousView + ",18");
                }
                paramAnonymousAdapterView = new sk();
                paramAnonymousAdapterView.dxW.intent = ((Intent)localObject);
                paramAnonymousAdapterView.dxW.username = paramAnonymousView;
                com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousAdapterView);
                ((Intent)localObject).putExtra("CONTACT_INFO_UI_SOURCE", 5);
                com.tencent.mm.plugin.nearby.a.hYt.c((Intent)localObject, NearbyFriendsUI.this);
              }
              AppMethodBeat.o(89848);
              return;
            }
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView.mAQ);
            paramAnonymousView.putExtra("Contact_Alias", paramAnonymousAdapterView.ijR);
            paramAnonymousView.putExtra("Contact_Nick", paramAnonymousAdapterView.mBV);
            paramAnonymousView.putExtra("Contact_Distance", paramAnonymousAdapterView.DIU);
            paramAnonymousView.putExtra("Contact_Signature", paramAnonymousAdapterView.ijP);
            paramAnonymousView.putExtra("Contact_RegionCode", RegionCodeDecoder.aT(paramAnonymousAdapterView.ijV, paramAnonymousAdapterView.ijN, paramAnonymousAdapterView.ijO));
            paramAnonymousView.putExtra("Contact_Sex", paramAnonymousAdapterView.ijM);
            paramAnonymousView.putExtra("Contact_IsLBSFriend", true);
            paramAnonymousView.putExtra("Contact_Scene", 18);
            paramAnonymousView.putExtra("Contact_VUser_Info", paramAnonymousAdapterView.DIW);
            paramAnonymousView.putExtra("Contact_VUser_Info_Flag", paramAnonymousAdapterView.DIV);
            paramAnonymousView.putExtra("Contact_KWeibo_flag", paramAnonymousAdapterView.DIZ);
            paramAnonymousView.putExtra("Contact_KWeibo", paramAnonymousAdapterView.DIX);
            paramAnonymousView.putExtra("Contact_KWeiboNick", paramAnonymousAdapterView.DIY);
            paramAnonymousView.putExtra("Contact_KSnsIFlag", paramAnonymousAdapterView.DJb.ijX);
            paramAnonymousView.putExtra("Contact_KSnsBgId", paramAnonymousAdapterView.DJb.ijZ);
            paramAnonymousView.putExtra("Contact_KSnsBgUrl", paramAnonymousAdapterView.DJb.ijY);
            paramAnonymousView.putExtra("lbs_ticket", paramAnonymousAdapterView.Dqd);
            paramAnonymousView.putExtra("Contact_IsLbsGotoChatting", true);
            if (paramAnonymousAdapterView.ijW != null)
            {
              localObject = new com.tencent.mm.api.c();
              ((com.tencent.mm.api.c)localObject).field_brandList = paramAnonymousAdapterView.ijW;
              ((com.tencent.mm.api.c)localObject).field_brandFlag = paramAnonymousAdapterView.DJc.ika;
              ((com.tencent.mm.api.c)localObject).field_brandIconURL = paramAnonymousAdapterView.DJc.ikd;
              ((com.tencent.mm.api.c)localObject).field_extInfo = paramAnonymousAdapterView.DJc.ikb;
              ((com.tencent.mm.api.c)localObject).field_brandInfo = paramAnonymousAdapterView.DJc.ikc;
              paramAnonymousView.putExtra("KBrandInfo_item", new MCacheItem((com.tencent.mm.sdk.e.c)localObject));
            }
            paramAnonymousView.putExtra("Sns_from_Scene", 18);
            paramAnonymousView.putExtra("CONTACT_INFO_UI_SOURCE", 5);
            com.tencent.mm.plugin.nearby.a.hYt.c(paramAnonymousView, NearbyFriendsUI.this);
            AppMethodBeat.o(89848);
          }
        });
        this.inl.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(89849);
            if (NearbyFriendsUI.u(NearbyFriendsUI.this) != null)
            {
              paramAnonymousView = NearbyFriendsUI.u(NearbyFriendsUI.this);
              if (paramAnonymousView.ikl != null) {
                paramAnonymousView.ikl.onTouchEvent(paramAnonymousMotionEvent);
              }
            }
            AppMethodBeat.o(89849);
            return false;
          }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(89850);
            NearbyFriendsUI.this.finish();
            AppMethodBeat.o(89850);
            return true;
          }
        });
        setToTop(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(89851);
            paramAnonymousView = NearbyFriendsUI.j(NearbyFriendsUI.this);
            paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymousView);
            Object localObject = new Object();
            com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.adn(), "com/tencent/mm/plugin/nearby/ui/NearbyFriendsUI$8", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
            BackwardSupportUtil.c.b((ListView)paramAnonymousView.lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/nearby/ui/NearbyFriendsUI$8", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
            AppMethodBeat.o(89851);
          }
        });
        addIconOptionMenu(0, 2131690603, new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(89855);
            paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(NearbyFriendsUI.this, 1, false);
            paramAnonymousMenuItem.HrY = new n.d()
            {
              public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
              {
                AppMethodBeat.i(89853);
                switch (paramAnonymous2Int)
                {
                }
                for (;;)
                {
                  AppMethodBeat.o(89853);
                  return;
                  NearbyFriendsUI.a(NearbyFriendsUI.this, 4);
                  NearbyFriendsUI.v(NearbyFriendsUI.this);
                  com.tencent.mm.kernel.g.afB().afk().set(16386, Integer.valueOf(NearbyFriendsUI.h(NearbyFriendsUI.this)));
                  NearbyFriendsUI.w(NearbyFriendsUI.this);
                  AppMethodBeat.o(89853);
                  return;
                  NearbyFriendsUI.a(NearbyFriendsUI.this, 3);
                  NearbyFriendsUI.v(NearbyFriendsUI.this);
                  com.tencent.mm.kernel.g.afB().afk().set(16386, Integer.valueOf(NearbyFriendsUI.h(NearbyFriendsUI.this)));
                  NearbyFriendsUI.w(NearbyFriendsUI.this);
                  AppMethodBeat.o(89853);
                  return;
                  NearbyFriendsUI.a(NearbyFriendsUI.this, 1);
                  NearbyFriendsUI.v(NearbyFriendsUI.this);
                  com.tencent.mm.kernel.g.afB().afk().set(16386, Integer.valueOf(NearbyFriendsUI.h(NearbyFriendsUI.this)));
                  NearbyFriendsUI.w(NearbyFriendsUI.this);
                  AppMethodBeat.o(89853);
                  return;
                  paramAnonymous2MenuItem = new Intent(NearbyFriendsUI.this, NearbySayHiListUI.class);
                  paramAnonymous2MenuItem.putExtra("k_say_hi_type", 2);
                  NearbyFriendsUI.this.startActivityForResult(paramAnonymous2MenuItem, 2009);
                  AppMethodBeat.o(89853);
                  return;
                  NearbyFriendsUI.b(NearbyFriendsUI.this, new com.tencent.mm.plugin.nearby.a.c(2, 0.0F, 0.0F, 0, 0, "", ""));
                  com.tencent.mm.kernel.g.aeS().a(NearbyFriendsUI.x(NearbyFriendsUI.this), 0);
                  paramAnonymous2MenuItem = NearbyFriendsUI.this;
                  AppCompatActivity localAppCompatActivity = NearbyFriendsUI.this.getContext();
                  NearbyFriendsUI.this.getString(2131755906);
                  NearbyFriendsUI.a(paramAnonymous2MenuItem, com.tencent.mm.ui.base.h.b(localAppCompatActivity, NearbyFriendsUI.this.getString(2131761498), true, new DialogInterface.OnCancelListener()
                  {
                    public final void onCancel(DialogInterface paramAnonymous3DialogInterface)
                    {
                      AppMethodBeat.i(89852);
                      com.tencent.mm.kernel.g.aeS().a(NearbyFriendsUI.x(NearbyFriendsUI.this));
                      AppMethodBeat.o(89852);
                    }
                  }));
                }
              }
            };
            paramAnonymousMenuItem.HrX = new n.c()
            {
              public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
              {
                AppMethodBeat.i(89854);
                paramAnonymous2l.jj(-1, 2131761512);
                paramAnonymous2l.jj(-1, 2131761511);
                paramAnonymous2l.jj(-1, 2131761510);
                paramAnonymous2l.jj(-1, 2131762789);
                paramAnonymous2l.jj(-1, 2131761494);
                AppMethodBeat.o(89854);
              }
            };
            paramAnonymousMenuItem.csG();
            AppMethodBeat.o(89855);
            return true;
          }
        });
        AppMethodBeat.o(89870);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        l.a locala;
        this.uaE = 0;
        continue;
        if (localException.equals("2"))
        {
          if (locala == l.a.ikz)
          {
            this.uaG = 2;
            com.tencent.mm.model.a.f.uD("3");
          }
        }
        else if ((localException.equals("1")) && (locala == l.a.ikw))
        {
          this.uaG = 2;
          com.tencent.mm.model.a.f.uD("3");
        }
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(89872);
    ad.d("MicroMsg.NearbyFriend", "onActivityResult, requestCode %s, resultCode %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(89872);
      return;
      if (paramInt2 == -1)
      {
        this.uaw = false;
        getData();
        AppMethodBeat.o(89872);
        return;
        if (paramInt2 == -1) {
          finish();
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(89867);
    com.tencent.mm.plugin.report.service.g.KI(11);
    super.onCreate(paramBundle);
    setMMTitle(2131761520);
    com.tencent.mm.kernel.g.aeS().a(148, this);
    com.tencent.mm.kernel.g.aeS().a(376, this);
    com.tencent.mm.kernel.g.aeS().a(1087, this);
    this.fjC = com.tencent.mm.modelgeo.d.axT();
    initView();
    this.uax = new String[] { getResources().getString(2131761512), getResources().getString(2131761511), getResources().getString(2131761510), getResources().getString(2131762789) };
    this.uay = bt.a((Integer)com.tencent.mm.kernel.g.afB().afk().get(16386, null), 1);
    Object localObject1;
    int j;
    int i;
    label231:
    Object localObject2;
    if (this.uay == 3)
    {
      setTitleLogo(0, 2131690323);
      getData();
      if (!ac.eFr()) {
        break label796;
      }
      localObject1 = bw.K(((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.prd, ""), "lbsads");
      if (localObject1 == null) {
        break label796;
      }
      j = bt.getInt((String)((Map)localObject1).get(".lbsads.$count"), 0);
      if (j <= 0) {
        break label796;
      }
      i = 0;
      if (i >= j) {
        break label674;
      }
      localObject2 = new StringBuilder(".lbsads.lbsad");
      if (i != 0) {
        break label666;
      }
    }
    label666:
    for (paramBundle = "";; paramBundle = Integer.valueOf(i))
    {
      paramBundle = paramBundle;
      localObject2 = new a((byte)0);
      ((a)localObject2).id = ((String)((Map)localObject1).get(paramBundle + ".$id"));
      ((a)localObject2).pos = bt.getInt((String)((Map)localObject1).get(paramBundle + ".$pos"), 0);
      ((a)localObject2).uaO = bt.getInt((String)((Map)localObject1).get(paramBundle + ".$close_times"), 0);
      ((a)localObject2).uaP = bt.getInt((String)((Map)localObject1).get(paramBundle + ".$show_times"), 2147483647);
      ((a)localObject2).name = ((String)((Map)localObject1).get(paramBundle + ".name"));
      ((a)localObject2).desc = ((String)((Map)localObject1).get(paramBundle + ".desc"));
      ((a)localObject2).dub = ((String)((Map)localObject1).get(paramBundle + ".icon"));
      ((a)localObject2).uaQ = bt.getInt((String)((Map)localObject1).get(paramBundle + ".jump.$type"), 0);
      ((a)localObject2).uaR = ((String)((Map)localObject1).get(paramBundle + ".jump"));
      this.uav.put(((a)localObject2).id, localObject2);
      i += 1;
      break label231;
      if (this.uay == 4)
      {
        setTitleLogo(0, 2131690322);
        break;
      }
      setTitleLogo(0, 0);
      this.uay = 1;
      break;
    }
    label674:
    paramBundle = com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fvz, null);
    if (paramBundle == null) {}
    for (paramBundle = "";; paramBundle = (String)paramBundle)
    {
      paramBundle = paramBundle.split("\\|");
      j = paramBundle.length;
      i = 0;
      while (i < j)
      {
        localObject1 = paramBundle[i].split(":");
        if (localObject1.length == 3)
        {
          localObject2 = (a)this.uav.get(localObject1[0]);
          if (localObject2 != null)
          {
            ((a)localObject2).uaS = bt.getInt(localObject1[1], 0);
            ((a)localObject2).nCF = bt.getInt(localObject1[2], 0);
          }
        }
        i += 1;
      }
    }
    label796:
    AppMethodBeat.o(89867);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(89875);
    if (this.uaG > 0) {
      com.tencent.mm.model.a.f.uE("3");
    }
    com.tencent.mm.plugin.report.service.g.KK(11);
    com.tencent.mm.kernel.g.aeS().b(148, this);
    com.tencent.mm.kernel.g.aeS().b(376, this);
    com.tencent.mm.kernel.g.aeS().b(1087, this);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if (this.fjC != null) {
      this.fjC.c(this.fjJ);
    }
    com.tencent.mm.ak.p.auH().cancel();
    Object localObject;
    if (this.uas != null)
    {
      localObject = this.uas;
      if (((c)localObject).ikl != null)
      {
        ((c)localObject).ikl.detach();
        ((c)localObject).ikl = null;
      }
    }
    if (this.pLp.size() > 0)
    {
      Iterator localIterator = this.uav.values().iterator();
      localObject = "";
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        localObject = new StringBuilder().append((String)localObject).append("|").append(locala.id).append(":").append(locala.uaS).append(":");
        int i = locala.nCF + 1;
        locala.nCF = i;
        localObject = i;
        com.tencent.mm.plugin.report.service.h.vKh.f(17431, new Object[] { locala.id, Integer.valueOf(locala.uaT + 1) });
      }
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fvz, localObject);
    }
    super.onDestroy();
    AppMethodBeat.o(89875);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(89873);
    super.onPause();
    if (this.fjC != null) {
      this.fjC.c(this.fjJ);
    }
    com.tencent.mm.sdk.b.a.ESL.d(this.fjL);
    AppMethodBeat.o(89873);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(89874);
    super.onResume();
    if (this.fjC != null) {
      this.fjC.a(this.fjJ, true);
    }
    cWe();
    this.uas.notifyDataSetChanged();
    com.tencent.mm.kernel.g.afz().aeD();
    if (((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOF().bIR() == 0) {
      this.inl.removeHeaderView(this.uaC);
    }
    com.tencent.mm.sdk.b.a.ESL.c(this.fjL);
    AppMethodBeat.o(89874);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(89876);
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    label321:
    label454:
    Object localObject;
    if (paramn.getType() == 148)
    {
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      int i = ((com.tencent.mm.plugin.nearby.a.c)paramn).JJ();
      if ((this.uat == null) && ((i == 1) || (i == 3) || (i == 4)))
      {
        AppMethodBeat.o(89876);
        return;
      }
      if (((i == 1) || (i == 3) || (i == 4)) && (this.uaw))
      {
        ad.v("MicroMsg.NearbyFriend", "onSceneEnd data already requested, code=%d", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(89876);
        return;
      }
      if ((this.uah == null) && (i == 2))
      {
        AppMethodBeat.o(89876);
        return;
      }
      ad.i("MicroMsg.NearbyFriend", "onSceneEnd: errType=%d, errCode=%d, errMsg=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if (paramn.getType() != 148)
      {
        AppMethodBeat.o(89876);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if ((i == 1) || (i == 3) || (i == 4))
        {
          this.pLp = ((com.tencent.mm.plugin.nearby.a.c)paramn).cWb();
          if ((this.pLp == null) || (this.pLp.size() == 0))
          {
            findViewById(2131302694).setVisibility(0);
            this.inl.setVisibility(8);
            cWf();
            com.tencent.mm.plugin.report.service.g.KK(11);
            if (this.uay != 3) {
              break label767;
            }
            setTitleLogo(0, 2131690323);
            this.uaw = true;
            this.uat = null;
          }
        }
        else
        {
          if (((com.tencent.mm.plugin.nearby.a.c)paramn).JJ() == 2)
          {
            com.tencent.mm.ui.base.h.d(getContext(), getString(2131761497), "", new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(89843);
                NearbyFriendsUI.this.finish();
                AppMethodBeat.o(89843);
              }
            });
            this.uah = null;
          }
          if (!((com.tencent.mm.plugin.nearby.a.c)paramn).cVZ()) {
            break label811;
          }
          paramString = getString(2131761523);
          paramInt1 = ((com.tencent.mm.plugin.nearby.a.c)paramn).cWa();
          if (this.uaA != null)
          {
            if (this.uaB != null) {
              break label800;
            }
            this.uaB = View.inflate(this, 2131495005, null);
            this.uaA.addView(this.uaB);
            this.uaB.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(89840);
                NearbyFriendsUI.y(NearbyFriendsUI.this);
                AppMethodBeat.o(89840);
              }
            });
            ((TextView)this.uaB.findViewById(2131302700)).setText(paramString);
            if (paramInt1 != 0) {
              ((TextView)this.uaB.findViewById(2131302699)).setText(String.format(getResources().getQuantityString(2131623958, paramInt1, new Object[] { Integer.valueOf(paramInt1) }), new Object[0]));
            }
          }
        }
        for (;;)
        {
          this.uaF = true;
          AppMethodBeat.o(89876);
          return;
          paramString = new LinkedList();
          localObject = this.pLp.iterator();
          paramInt1 = 0;
          while (((Iterator)localObject).hasNext())
          {
            blb localblb = (blb)((Iterator)localObject).next();
            if (((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHT(localblb.mAQ))
            {
              paramString.add(paramInt1, localblb);
              paramInt1 += 1;
            }
            else if ((!bt.isNullOrNil(localblb.mAQ)) && (!bt.isNullOrNil(localblb.DIU)))
            {
              paramString.add(localblb);
            }
          }
          this.pLp.clear();
          this.pLp = paramString;
          if ((this.pLp == null) || (this.pLp.size() == 0))
          {
            findViewById(2131302694).setVisibility(0);
            this.inl.setVisibility(8);
            break;
          }
          findViewById(2131302694).setVisibility(8);
          cWg();
          this.uas.notifyDataSetChanged();
          if (this.uas.getCount() > 0) {
            this.inl.setSelection(0);
          }
          this.inl.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(89842);
              com.tencent.mm.plugin.report.service.g.KJ(11);
              AppMethodBeat.o(89842);
            }
          });
          break;
          label767:
          if (this.uay == 4)
          {
            setTitleLogo(0, 2131690322);
            break label321;
          }
          setTitleLogo(0, 0);
          this.uay = 1;
          break label321;
          label800:
          this.uaB.setVisibility(0);
          break label454;
          label811:
          if ((this.uaB != null) && (this.uaA != null)) {
            this.uaB.setVisibility(8);
          }
        }
      }
      if ((i == 1) || (i == 3) || (i == 4))
      {
        localObject = (TextView)findViewById(2131302694);
        ((TextView)localObject).setVisibility(0);
        cWf();
        if ((paramString == null) || (paramString.length() <= 0)) {
          break label1165;
        }
      }
    }
    label1165:
    for (paramString = com.tencent.mm.h.a.oG(paramString);; paramString = null)
    {
      if ((paramString != null) && (paramString.desc != null) && (paramString.desc.length() > 0)) {
        ((TextView)localObject).setText(paramString.desc);
      }
      for (;;)
      {
        this.inl.setVisibility(8);
        this.uat = null;
        if (((com.tencent.mm.plugin.nearby.a.c)paramn).JJ() == 2)
        {
          Toast.makeText(this, 2131761496, 1).show();
          this.uah = null;
        }
        AppMethodBeat.o(89876);
        return;
        if (paramInt2 == -2001) {
          ((TextView)localObject).setText(getString(2131761499));
        } else {
          ((TextView)localObject).setText(getString(2131761503));
        }
      }
      if (paramn.getType() == 376)
      {
        if (((com.tencent.mm.plugin.nearby.a.d)paramn).JJ() != 1)
        {
          AppMethodBeat.o(89876);
          return;
        }
        if (this.tipDialog != null)
        {
          this.tipDialog.dismiss();
          this.tipDialog = null;
        }
        if ((paramInt1 == 0) && (paramInt2 == 0) && (((com.tencent.mm.plugin.nearby.a.d)paramn).hNI != null))
        {
          paramString = ((com.tencent.mm.plugin.nearby.a.d)paramn).hNI;
          com.tencent.mm.plugin.nearby.a.b.hH(paramString, ((com.tencent.mm.plugin.nearby.a.d)paramn).tZO);
          paramn = new Intent();
          paramn.putExtra("Chat_User", paramString);
          com.tencent.mm.plugin.nearby.a.hYt.e(paramn, this);
          AppMethodBeat.o(89876);
          return;
        }
        com.tencent.mm.ui.base.h.a(getContext(), 2131761521, 2131755906, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
      }
      AppMethodBeat.o(89876);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
  {
    String desc;
    String dub;
    String id;
    boolean mku = false;
    int nCF;
    String name;
    int pos;
    int uaO;
    int uaP;
    int uaQ;
    String uaR;
    int uaS;
    int uaT = -1;
  }
  
  final class b
  {
    public int accuracy;
    public float heb;
    public float hec;
    
    public b(float paramFloat1, float paramFloat2, int paramInt)
    {
      this.heb = paramFloat1;
      this.hec = paramFloat2;
      this.accuracy = paramInt;
    }
  }
  
  final class c
    extends BaseAdapter
  {
    private final Context context;
    com.tencent.mm.ui.applet.b ikl;
    private b.b ikm;
    
    public c(Context paramContext)
    {
      AppMethodBeat.i(89860);
      this.ikl = new com.tencent.mm.ui.applet.b(new com.tencent.mm.ui.applet.b.a()
      {
        public final Bitmap Cl(String paramAnonymousString)
        {
          AppMethodBeat.i(89856);
          paramAnonymousString = com.tencent.mm.ak.c.a(paramAnonymousString, false, -1, null);
          AppMethodBeat.o(89856);
          return paramAnonymousString;
        }
      });
      this.ikm = null;
      this.context = paramContext;
      AppMethodBeat.o(89860);
    }
    
    public final blb Ie(int paramInt)
    {
      AppMethodBeat.i(89863);
      blb localblb = (blb)NearbyFriendsUI.s(NearbyFriendsUI.this).get(paramInt);
      AppMethodBeat.o(89863);
      return localblb;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(89861);
      int i = NearbyFriendsUI.s(NearbyFriendsUI.this).size();
      AppMethodBeat.o(89861);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(89862);
      if (this.ikm == null) {
        this.ikm = new b.b()
        {
          public final int aII()
          {
            AppMethodBeat.i(89858);
            int i = NearbyFriendsUI.c.this.getCount();
            AppMethodBeat.o(89858);
            return i;
          }
          
          public final String qa(int paramAnonymousInt)
          {
            AppMethodBeat.i(89857);
            if ((paramAnonymousInt < 0) || (paramAnonymousInt >= NearbyFriendsUI.c.this.getCount()))
            {
              ad.e("MicroMsg.NearbyFriend", "pos is invalid");
              AppMethodBeat.o(89857);
              return null;
            }
            Object localObject = NearbyFriendsUI.c.this.Ie(paramAnonymousInt);
            if (localObject == null)
            {
              AppMethodBeat.o(89857);
              return null;
            }
            localObject = ((blb)localObject).mAQ;
            AppMethodBeat.o(89857);
            return localObject;
          }
        };
      }
      if (this.ikl != null) {
        this.ikl.a(paramInt, this.ikm);
      }
      Object localObject1;
      label365:
      Object localObject2;
      if (paramView == null)
      {
        paramViewGroup = new NearbyFriendsUI.e();
        paramView = View.inflate(this.context, 2131495002, null);
        paramViewGroup.iiF = ((TextView)paramView.findViewById(2131302693));
        paramViewGroup.uaY = ((TextView)paramView.findViewById(2131302696));
        paramViewGroup.uaX = ((TextView)paramView.findViewById(2131302688));
        paramViewGroup.ikp = ((ImageView)paramView.findViewById(2131302687));
        paramViewGroup.ikq = ((TextView)paramView.findViewById(2131302690));
        paramViewGroup.uaZ = ((ImageView)paramView.findViewById(2131302698));
        paramViewGroup.uba = ((ImageView)paramView.findViewById(2131302697));
        paramViewGroup.ubc = ((ImageView)paramView.findViewById(2131302684));
        paramViewGroup.ubd = ((ImageView)paramView.findViewById(2131302685));
        paramViewGroup.ube = ((ImageView)paramView.findViewById(2131302686));
        paramViewGroup.ubf = ((ImageView)paramView.findViewById(2131298364));
        localObject1 = paramViewGroup.uba.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).height = com.tencent.mm.cd.a.ao(this.context, 2131165516);
        ((ViewGroup.LayoutParams)localObject1).width = com.tencent.mm.cd.a.ao(this.context, 2131165516);
        paramViewGroup.uba.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        paramViewGroup.ubb = ((ImageView)paramView.findViewById(2131302695));
        paramView.setTag(paramViewGroup);
        localObject1 = (blb)NearbyFriendsUI.s(NearbyFriendsUI.this).get(paramInt);
        paramViewGroup.iiF.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, ((blb)localObject1).mBV, paramViewGroup.iiF.getTextSize()));
        if (NearbyFriendsUI.h(NearbyFriendsUI.this) != 1) {
          break label859;
        }
        switch (((blb)localObject1).ijM)
        {
        default: 
          paramViewGroup.ubb.setVisibility(8);
          if (((blb)localObject1).DIV != 0)
          {
            paramViewGroup.uaZ.setVisibility(0);
            localObject2 = BackwardSupportUtil.b.n(ar.a.gMY.nd(((blb)localObject1).DIV), 2.0F);
            paramViewGroup.uaZ.setImageBitmap((Bitmap)localObject2);
            paramViewGroup.ubb.setVisibility(8);
            label418:
            paramViewGroup.uaX.setText(((blb)localObject1).DIU);
            paramViewGroup.ubc.setVisibility(8);
            paramViewGroup.ubd.setVisibility(8);
            paramViewGroup.ube.setVisibility(8);
            paramViewGroup.ubf.setVisibility(8);
            if ((localObject1 instanceof com.tencent.mm.plugin.nearby.a.a))
            {
              localObject2 = ((com.tencent.mm.plugin.nearby.a.a)localObject1).tZL;
              if ((localObject2 == null) || (((LinkedList)localObject2).size() != 1)) {
                break label883;
              }
              paramViewGroup.ubc.setVisibility(0);
              NearbyFriendsUI.r(paramViewGroup.ubc, (String)((LinkedList)localObject2).get(0));
              label522:
              localObject2 = (NearbyFriendsUI.a)NearbyFriendsUI.t(NearbyFriendsUI.this).get(((blb)localObject1).mAQ);
              if (localObject2 != null)
              {
                if (((NearbyFriendsUI.a)localObject2).uaT != -1) {
                  break label1037;
                }
                paramInt = 0;
                label560:
                ((NearbyFriendsUI.a)localObject2).uaT = paramInt;
                if (((NearbyFriendsUI.a)localObject2).uaO > 0) {
                  paramViewGroup.ubf.setVisibility(0);
                }
              }
              paramViewGroup.ubf.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(89859);
                  paramAnonymousView = (NearbyFriendsUI.a)NearbyFriendsUI.t(NearbyFriendsUI.this).get(this.uaV.mAQ);
                  if (paramAnonymousView != null)
                  {
                    paramAnonymousView.uaS += 1;
                    paramAnonymousView.mku = true;
                    paramAnonymousView.uaT |= 0x2;
                  }
                  NearbyFriendsUI.A(NearbyFriendsUI.this);
                  NearbyFriendsUI.c.this.notifyDataSetChanged();
                  AppMethodBeat.o(89859);
                }
              });
            }
            if ((((blb)localObject1).ijP != null) && (!((blb)localObject1).ijP.trim().equals(""))) {
              break label1046;
            }
            paramViewGroup.uaY.setVisibility(8);
            label633:
            if ((((blb)localObject1).DJb == null) || ((((blb)localObject1).DJb.ijX & 0x1) <= 0)) {
              break label1083;
            }
            paramViewGroup.uba.setVisibility(0);
            label662:
            if (!NearbyFriendsUI.d.If(((blb)localObject1).ijM)) {
              break label1095;
            }
            paramViewGroup.ikp.setImageBitmap(null);
            localObject2 = new c.a();
            ((c.a)localObject2).prefixPath = com.tencent.mm.plugin.image.d.apW();
            ((c.a)localObject2).hjU = true;
            ((c.a)localObject2).gjA = true;
            localObject2 = ((c.a)localObject2).azc();
            o.ayJ().a(((blb)localObject1).CVw, paramViewGroup.ikp, (com.tencent.mm.aw.a.a.c)localObject2);
            if (bt.isNullOrNil(((blb)localObject1).ijR)) {
              break label1283;
            }
            paramViewGroup.ikq.setText(((blb)localObject1).ijR);
            paramViewGroup.ikq.setVisibility(0);
          }
          break;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(89862);
        return paramView;
        paramViewGroup = (NearbyFriendsUI.e)paramView.getTag();
        break;
        paramViewGroup.ubb.setVisibility(0);
        paramViewGroup.ubb.setImageResource(2131690323);
        paramViewGroup.ubb.setContentDescription(this.context.getString(2131761078));
        break label365;
        paramViewGroup.ubb.setVisibility(0);
        paramViewGroup.ubb.setImageResource(2131690322);
        paramViewGroup.ubb.setContentDescription(this.context.getString(2131759044));
        break label365;
        label859:
        paramViewGroup.ubb.setVisibility(8);
        break label365;
        paramViewGroup.uaZ.setVisibility(8);
        break label418;
        label883:
        if ((localObject2 != null) && (((LinkedList)localObject2).size() == 2))
        {
          paramViewGroup.ubc.setVisibility(0);
          paramViewGroup.ubd.setVisibility(0);
          NearbyFriendsUI.r(paramViewGroup.ubc, (String)((LinkedList)localObject2).get(0));
          NearbyFriendsUI.r(paramViewGroup.ubd, (String)((LinkedList)localObject2).get(1));
          break label522;
        }
        if ((localObject2 == null) || (((LinkedList)localObject2).size() < 3)) {
          break label522;
        }
        paramViewGroup.ubc.setVisibility(0);
        paramViewGroup.ubd.setVisibility(0);
        paramViewGroup.ube.setVisibility(0);
        NearbyFriendsUI.r(paramViewGroup.ubc, (String)((LinkedList)localObject2).get(0));
        NearbyFriendsUI.r(paramViewGroup.ubd, (String)((LinkedList)localObject2).get(1));
        NearbyFriendsUI.r(paramViewGroup.ube, (String)((LinkedList)localObject2).get(2));
        break label522;
        label1037:
        paramInt = ((NearbyFriendsUI.a)localObject2).uaT;
        break label560;
        label1046:
        paramViewGroup.uaY.setVisibility(0);
        paramViewGroup.uaY.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, ((blb)localObject1).ijP, paramViewGroup.uaY.getTextSize()));
        break label633;
        label1083:
        paramViewGroup.uba.setVisibility(8);
        break label662;
        label1095:
        a.b.c(paramViewGroup.ikp, ((blb)localObject1).mAQ);
        if (((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHT(((blb)localObject1).mAQ))
        {
          paramViewGroup.ikq.setVisibility(0);
          if (af.Wy(((blb)localObject1).DIV))
          {
            paramViewGroup.ikq.setText(NearbyFriendsUI.this.getString(2131761502));
          }
          else
          {
            af localaf = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHW(((blb)localObject1).mAQ);
            Context localContext;
            if (localaf != null)
            {
              localObject2 = paramViewGroup.iiF;
              localContext = this.context;
              if (!bt.isNullOrNil(localaf.ZX())) {
                break label1273;
              }
            }
            label1273:
            for (localObject1 = ((blb)localObject1).mBV;; localObject1 = localaf.ZX())
            {
              ((TextView)localObject2).setText(com.tencent.mm.pluginsdk.ui.span.k.b(localContext, (CharSequence)localObject1, paramViewGroup.iiF.getTextSize()));
              paramViewGroup.ikq.setText(NearbyFriendsUI.this.getString(2131761507));
              break;
            }
          }
        }
        else
        {
          label1283:
          paramViewGroup.ikq.setVisibility(8);
        }
      }
    }
  }
  
  static final class d
  {
    public static int uaW = 10000;
    
    public static boolean If(int paramInt)
    {
      return paramInt == uaW;
    }
    
    public static blb d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    {
      AppMethodBeat.i(89865);
      com.tencent.mm.plugin.nearby.a.a locala = new com.tencent.mm.plugin.nearby.a.a();
      locala.ijM = uaW;
      locala.mAQ = paramString1;
      locala.CVw = paramString2;
      locala.DIU = paramString4;
      locala.mBV = paramString3;
      locala.ijN = paramString5;
      AppMethodBeat.o(89865);
      return locala;
    }
  }
  
  static final class e
  {
    TextView iiF;
    ImageView ikp;
    TextView ikq;
    TextView uaX;
    TextView uaY;
    ImageView uaZ;
    ImageView uba;
    ImageView ubb;
    ImageView ubc;
    ImageView ubd;
    ImageView ube;
    ImageView ubf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI
 * JD-Core Version:    0.7.0.1
 */