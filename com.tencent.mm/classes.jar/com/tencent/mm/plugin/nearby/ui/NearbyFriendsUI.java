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
import com.tencent.mm.ak.q;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.o;
import com.tencent.mm.cache.MCacheItem;
import com.tencent.mm.g.a.ks;
import com.tencent.mm.g.a.st;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.i;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.c;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.aaf;
import com.tencent.mm.protocal.protobuf.box;
import com.tencent.mm.protocal.protobuf.dbt;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bl;
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
  implements com.tencent.mm.ak.g
{
  private com.tencent.mm.modelgeo.d fmW;
  private com.tencent.mm.modelgeo.b.a fnd;
  private com.tencent.mm.sdk.b.c fnf;
  boolean gRx;
  private ListView iNr;
  private List<box> qtW;
  private com.tencent.mm.ui.base.p tipDialog;
  private boolean ucu;
  private boolean udt;
  private View vjA;
  private View vjB;
  private boolean vjC;
  private int vjD;
  private boolean vjE;
  private int vjF;
  private View vjG;
  private b vjH;
  private com.tencent.mm.plugin.nearby.a.c vjg;
  private c vjr;
  private com.tencent.mm.plugin.nearby.a.c vjs;
  private com.tencent.mm.plugin.nearby.a.d vjt;
  private Map<String, a> vju;
  private boolean vjv;
  private String[] vjw;
  private int vjx;
  private BindMobileOrQQHeaderView vjy;
  private ViewGroup vjz;
  
  public NearbyFriendsUI()
  {
    AppMethodBeat.i(89866);
    this.tipDialog = null;
    this.qtW = new LinkedList();
    this.vju = new HashMap();
    this.vjv = false;
    this.vjx = 1;
    this.vjC = false;
    this.vjE = false;
    this.ucu = false;
    this.vjF = 0;
    this.vjG = null;
    this.fnf = new com.tencent.mm.sdk.b.c() {};
    this.gRx = false;
    this.fnd = new com.tencent.mm.modelgeo.b.a()
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
        if (NearbyFriendsUI.this.gRx)
        {
          if (NearbyFriendsUI.f(NearbyFriendsUI.this) != null)
          {
            NearbyFriendsUI.f(NearbyFriendsUI.this).dismiss();
            NearbyFriendsUI.a(NearbyFriendsUI.this, null);
          }
          com.tencent.mm.plugin.report.service.g.MJ(11);
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
          com.tencent.mm.modelstat.e locale = com.tencent.mm.modelstat.e.aIu();
          if (paramAnonymousInt == 0)
          {
            paramAnonymousBoolean = false;
            if (NearbyFriendsUI.g(NearbyFriendsUI.this) != null) {
              break label264;
            }
            bool = false;
            label163:
            locale.a(2001, paramAnonymousBoolean, bool, paramAnonymousFloat1, paramAnonymousFloat2, (int)paramAnonymousDouble2);
            NearbyFriendsUI.a(NearbyFriendsUI.this, new com.tencent.mm.plugin.nearby.a.c(NearbyFriendsUI.h(NearbyFriendsUI.this), NearbyFriendsUI.i(NearbyFriendsUI.this).hEF, NearbyFriendsUI.i(NearbyFriendsUI.this).hEE, NearbyFriendsUI.i(NearbyFriendsUI.this).accuracy, paramAnonymousInt, "", ""));
            com.tencent.mm.kernel.g.agi().a(NearbyFriendsUI.b(NearbyFriendsUI.this), 0);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(89846);
          return false;
          paramAnonymousBoolean = true;
          break;
          label264:
          bool = NearbyFriendsUI.g(NearbyFriendsUI.this).hEP;
          break label163;
          com.tencent.mm.plugin.report.service.g.MJ(11);
          if (NearbyFriendsUI.f(NearbyFriendsUI.this) != null)
          {
            NearbyFriendsUI.f(NearbyFriendsUI.this).dismiss();
            NearbyFriendsUI.a(NearbyFriendsUI.this, null);
          }
          NearbyFriendsUI.this.findViewById(2131302691).setVisibility(0);
          NearbyFriendsUI.j(NearbyFriendsUI.this).setVisibility(8);
          NearbyFriendsUI.k(NearbyFriendsUI.this);
          if ((!NearbyFriendsUI.l(NearbyFriendsUI.this)) && (!com.tencent.mm.modelgeo.d.aEM()))
          {
            NearbyFriendsUI.m(NearbyFriendsUI.this);
            com.tencent.mm.ui.base.h.a(NearbyFriendsUI.this, NearbyFriendsUI.this.getString(2131760082), NearbyFriendsUI.this.getString(2131755906), NearbyFriendsUI.this.getString(2131760598), NearbyFriendsUI.this.getString(2131755691), false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(89845);
                com.tencent.mm.modelgeo.d.cE(NearbyFriendsUI.this);
                AppMethodBeat.o(89845);
              }
            }, null);
          }
        }
      }
    };
    AppMethodBeat.o(89866);
  }
  
  private void djM()
  {
    AppMethodBeat.i(89869);
    View localView;
    Object localObject;
    int i;
    if (com.tencent.mm.bp.a.eJP())
    {
      if (this.vjG != null)
      {
        this.iNr.removeHeaderView(this.vjG);
        this.vjG = null;
      }
      localView = View.inflate(this, 2131495004, null);
      localObject = (TextView)localView.findViewById(2131304292);
      com.tencent.mm.kernel.g.agP().afT();
      i = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dco().bQe();
      if (i != 0) {
        break label119;
      }
      localView.setVisibility(8);
      localView = null;
    }
    for (;;)
    {
      this.vjG = localView;
      if (this.vjG != null) {
        this.iNr.addHeaderView(this.vjG);
      }
      AppMethodBeat.o(89869);
      return;
      label119:
      localView.setVisibility(0);
      ((TextView)localObject).setText(getResources().getQuantityString(2131623965, i, new Object[] { Integer.valueOf(i) }));
      localObject = (ImageView)localView.findViewById(2131302192);
      bl localbl = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dco().dcy();
      if (localbl != null) {
        a.b.c((ImageView)localObject, localbl.field_sayhiuser);
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
  
  private void djN()
  {
    AppMethodBeat.i(89871);
    com.tencent.mm.plugin.nearby.a.iyx.bC(this);
    AppMethodBeat.o(89871);
  }
  
  private void djO()
  {
    int j = 0;
    AppMethodBeat.i(89877);
    Object localObject1 = new LinkedList();
    int i = 0;
    while (i < this.qtW.size())
    {
      if (!d.Ke(((box)this.qtW.get(i)).iJT)) {
        ((List)localObject1).add(this.qtW.get(i));
      }
      i += 1;
    }
    this.qtW.clear();
    this.qtW = ((List)localObject1);
    ac.i("MicroMsg.NearbyFriend", "insertPoiItemList()");
    label133:
    Object localObject2;
    List localList;
    if (!this.qtW.isEmpty())
    {
      i = 1;
      localObject1 = this.vju.keySet().iterator();
      do
      {
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (String)((Iterator)localObject1).next();
        } while (i == 0);
        localObject2 = (a)this.vju.get(localObject2);
      } while ((((a)localObject2).mMv) || ((((a)localObject2).vjN > 0) && (((a)localObject2).vjR >= ((a)localObject2).vjN)) || (((a)localObject2).ofG >= ((a)localObject2).vjO));
      localList = this.qtW;
      if ((((a)localObject2).pos >= 0) && (((a)localObject2).pos <= this.qtW.size())) {
        break label306;
      }
    }
    label306:
    for (int k = this.qtW.size();; k = ((a)localObject2).pos + j)
    {
      localList.add(k, d.d(((a)localObject2).id, ((a)localObject2).drM, ((a)localObject2).name, ((a)localObject2).desc, ((a)localObject2).vjQ));
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
    this.ucu = false;
    AppCompatActivity localAppCompatActivity = getContext();
    getString(2131755906);
    this.tipDialog = com.tencent.mm.ui.base.h.b(localAppCompatActivity, getString(2131761509), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(89844);
        NearbyFriendsUI.this.gRx = true;
        com.tencent.mm.plugin.report.service.g.MJ(11);
        if (NearbyFriendsUI.b(NearbyFriendsUI.this) != null) {
          com.tencent.mm.kernel.g.agi().a(NearbyFriendsUI.b(NearbyFriendsUI.this));
        }
        ac.i("MicroMsg.NearbyFriend", "[MonsterzDai]  [loading cancel] cancel in loading");
        if (!NearbyFriendsUI.c(NearbyFriendsUI.this))
        {
          NearbyFriendsUI.this.finish();
          ac.i("MicroMsg.NearbyFriend", "[MonsterzDai]  [loading cancel] cancel in first loading");
        }
        AppMethodBeat.o(89844);
      }
    });
    this.gRx = false;
    if (this.fmW != null) {
      this.fmW.a(this.fnd, true);
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
    this.iNr = ((ListView)findViewById(2131302692));
    this.vjr = new c(this);
    Object localObject = this.iNr;
    if (this.vjz == null)
    {
      this.vjz = new LinearLayout(this);
      this.vjz.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      ((LinearLayout)this.vjz).setGravity(17);
    }
    this.vjC = true;
    ((ListView)localObject).addHeaderView(this.vjz);
    localObject = com.tencent.mm.m.g.ZY().getValue("LBSShowBindPhone");
    if ((localObject != null) && (((String)localObject).length() > 0)) {}
    try
    {
      this.vjD = Integer.valueOf((String)localObject).intValue();
      localObject = (String)com.tencent.mm.kernel.g.agR().agA().get(6, null);
      if ((localObject != null) && (((String)localObject).length() > 0)) {
        this.vjD = 0;
      }
      this.vjF = 0;
      if (com.tencent.mm.model.a.g.azO().yF("3") != null)
      {
        localObject = com.tencent.mm.model.a.g.azO().yF("3").value;
        locala = com.tencent.mm.plugin.account.friend.a.l.aPC();
        if (((String)localObject).equals("0")) {
          this.vjF = 0;
        }
      }
      else
      {
        if (((this.vjD > 0) || (this.vjF > 0)) && (this.vjF != 1))
        {
          this.vjy = new BindMobileOrQQHeaderView(this);
          this.iNr.addHeaderView(this.vjy);
        }
        this.iNr.setAdapter(this.vjr);
        this.iNr.setOnItemClickListener(new AdapterView.OnItemClickListener()
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
            if (com.tencent.mm.bp.a.eJP())
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
            paramAnonymousAdapterView = (box)NearbyFriendsUI.s(NearbyFriendsUI.this).get(i);
            if (NearbyFriendsUI.d.Ke(paramAnonymousAdapterView.iJT))
            {
              paramAnonymousAdapterView = (NearbyFriendsUI.a)NearbyFriendsUI.t(NearbyFriendsUI.this).get(paramAnonymousAdapterView.ncR);
              paramAnonymousAdapterView.vjS |= 0x1;
              if (paramAnonymousAdapterView.vjP == 1)
              {
                paramAnonymousView = new AppBrandStatObject();
                paramAnonymousView.scene = 1134;
                ((com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).a(NearbyFriendsUI.this, paramAnonymousAdapterView.vjQ, "", 0, 0, "", paramAnonymousView);
                AppMethodBeat.o(89848);
                return;
              }
              if (paramAnonymousAdapterView.vjP == 2)
              {
                paramAnonymousView = new Intent();
                paramAnonymousView.putExtra("rawUrl", paramAnonymousAdapterView.vjQ);
                paramAnonymousView.putExtra("geta8key_scene", 25);
                paramAnonymousView.putExtra("stastic_scene", 12);
                com.tencent.mm.br.d.b(NearbyFriendsUI.this.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
              }
              AppMethodBeat.o(89848);
              return;
            }
            paramAnonymousView = paramAnonymousAdapterView.ncR;
            ai localai = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramAnonymousView);
            Object localObject;
            if (com.tencent.mm.n.b.ln(localai.field_type))
            {
              localObject = new Intent();
              ((Intent)localObject).putExtra("Contact_User", paramAnonymousView);
              ((Intent)localObject).putExtra("Contact_Scene", 18);
              ((Intent)localObject).putExtra("Sns_from_Scene", 18);
              ((Intent)localObject).putExtra("lbs_ticket", paramAnonymousAdapterView.ELg);
              ((Intent)localObject).putExtra("Contact_IsLbsGotoChatting", true);
              if ((paramAnonymousView != null) && (paramAnonymousView.length() > 0))
              {
                if (localai.fad()) {
                  com.tencent.mm.plugin.report.service.h.wUl.kvStat(10298, paramAnonymousView + ",18");
                }
                paramAnonymousAdapterView = new st();
                paramAnonymousAdapterView.dvI.intent = ((Intent)localObject);
                paramAnonymousAdapterView.dvI.username = paramAnonymousView;
                com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousAdapterView);
                ((Intent)localObject).putExtra("CONTACT_INFO_UI_SOURCE", 5);
                com.tencent.mm.plugin.nearby.a.iyx.c((Intent)localObject, NearbyFriendsUI.this);
              }
              AppMethodBeat.o(89848);
              return;
            }
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView.ncR);
            paramAnonymousView.putExtra("Contact_Alias", paramAnonymousAdapterView.iJY);
            paramAnonymousView.putExtra("Contact_Nick", paramAnonymousAdapterView.ndW);
            paramAnonymousView.putExtra("Contact_Distance", paramAnonymousAdapterView.Fep);
            paramAnonymousView.putExtra("Contact_Signature", paramAnonymousAdapterView.iJW);
            paramAnonymousView.putExtra("Contact_RegionCode", RegionCodeDecoder.aW(paramAnonymousAdapterView.iKc, paramAnonymousAdapterView.iJU, paramAnonymousAdapterView.iJV));
            paramAnonymousView.putExtra("Contact_Sex", paramAnonymousAdapterView.iJT);
            paramAnonymousView.putExtra("Contact_IsLBSFriend", true);
            paramAnonymousView.putExtra("Contact_Scene", 18);
            paramAnonymousView.putExtra("Contact_VUser_Info", paramAnonymousAdapterView.Fer);
            paramAnonymousView.putExtra("Contact_VUser_Info_Flag", paramAnonymousAdapterView.Feq);
            paramAnonymousView.putExtra("Contact_KWeibo_flag", paramAnonymousAdapterView.Feu);
            paramAnonymousView.putExtra("Contact_KWeibo", paramAnonymousAdapterView.Fes);
            paramAnonymousView.putExtra("Contact_KWeiboNick", paramAnonymousAdapterView.Fet);
            paramAnonymousView.putExtra("Contact_KSnsIFlag", paramAnonymousAdapterView.Few.iKe);
            paramAnonymousView.putExtra("Contact_KSnsBgId", paramAnonymousAdapterView.Few.iKg);
            paramAnonymousView.putExtra("Contact_KSnsBgUrl", paramAnonymousAdapterView.Few.iKf);
            paramAnonymousView.putExtra("lbs_ticket", paramAnonymousAdapterView.ELg);
            paramAnonymousView.putExtra("Contact_IsLbsGotoChatting", true);
            if (paramAnonymousAdapterView.iKd != null)
            {
              localObject = new com.tencent.mm.api.c();
              ((com.tencent.mm.api.c)localObject).field_brandList = paramAnonymousAdapterView.iKd;
              ((com.tencent.mm.api.c)localObject).field_brandFlag = paramAnonymousAdapterView.Fex.iKh;
              ((com.tencent.mm.api.c)localObject).field_brandIconURL = paramAnonymousAdapterView.Fex.iKk;
              ((com.tencent.mm.api.c)localObject).field_extInfo = paramAnonymousAdapterView.Fex.iKi;
              ((com.tencent.mm.api.c)localObject).field_brandInfo = paramAnonymousAdapterView.Fex.iKj;
              paramAnonymousView.putExtra("KBrandInfo_item", new MCacheItem((com.tencent.mm.sdk.e.c)localObject));
            }
            paramAnonymousView.putExtra("Sns_from_Scene", 18);
            paramAnonymousView.putExtra("CONTACT_INFO_UI_SOURCE", 5);
            com.tencent.mm.plugin.nearby.a.iyx.c(paramAnonymousView, NearbyFriendsUI.this);
            AppMethodBeat.o(89848);
          }
        });
        this.iNr.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(89849);
            if (NearbyFriendsUI.u(NearbyFriendsUI.this) != null)
            {
              paramAnonymousView = NearbyFriendsUI.u(NearbyFriendsUI.this);
              if (paramAnonymousView.iKs != null) {
                paramAnonymousView.iKs.onTouchEvent(paramAnonymousMotionEvent);
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
            paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousView);
            Object localObject = new Object();
            com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.aeD(), "com/tencent/mm/plugin/nearby/ui/NearbyFriendsUI$8", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
            BackwardSupportUtil.c.b((ListView)paramAnonymousView.lR(0));
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
            paramAnonymousMenuItem.ISv = new n.d()
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
                  com.tencent.mm.kernel.g.agR().agA().set(16386, Integer.valueOf(NearbyFriendsUI.h(NearbyFriendsUI.this)));
                  NearbyFriendsUI.w(NearbyFriendsUI.this);
                  AppMethodBeat.o(89853);
                  return;
                  NearbyFriendsUI.a(NearbyFriendsUI.this, 3);
                  NearbyFriendsUI.v(NearbyFriendsUI.this);
                  com.tencent.mm.kernel.g.agR().agA().set(16386, Integer.valueOf(NearbyFriendsUI.h(NearbyFriendsUI.this)));
                  NearbyFriendsUI.w(NearbyFriendsUI.this);
                  AppMethodBeat.o(89853);
                  return;
                  NearbyFriendsUI.a(NearbyFriendsUI.this, 1);
                  NearbyFriendsUI.v(NearbyFriendsUI.this);
                  com.tencent.mm.kernel.g.agR().agA().set(16386, Integer.valueOf(NearbyFriendsUI.h(NearbyFriendsUI.this)));
                  NearbyFriendsUI.w(NearbyFriendsUI.this);
                  AppMethodBeat.o(89853);
                  return;
                  paramAnonymous2MenuItem = new Intent(NearbyFriendsUI.this, NearbySayHiListUI.class);
                  paramAnonymous2MenuItem.putExtra("k_say_hi_type", 2);
                  NearbyFriendsUI.this.startActivityForResult(paramAnonymous2MenuItem, 2009);
                  AppMethodBeat.o(89853);
                  return;
                  NearbyFriendsUI.b(NearbyFriendsUI.this, new com.tencent.mm.plugin.nearby.a.c(2, 0.0F, 0.0F, 0, 0, "", ""));
                  com.tencent.mm.kernel.g.agi().a(NearbyFriendsUI.x(NearbyFriendsUI.this), 0);
                  paramAnonymous2MenuItem = NearbyFriendsUI.this;
                  AppCompatActivity localAppCompatActivity = NearbyFriendsUI.this.getContext();
                  NearbyFriendsUI.this.getString(2131755906);
                  NearbyFriendsUI.a(paramAnonymous2MenuItem, com.tencent.mm.ui.base.h.b(localAppCompatActivity, NearbyFriendsUI.this.getString(2131761498), true, new DialogInterface.OnCancelListener()
                  {
                    public final void onCancel(DialogInterface paramAnonymous3DialogInterface)
                    {
                      AppMethodBeat.i(89852);
                      com.tencent.mm.kernel.g.agi().a(NearbyFriendsUI.x(NearbyFriendsUI.this));
                      AppMethodBeat.o(89852);
                    }
                  }));
                }
              }
            };
            paramAnonymousMenuItem.ISu = new n.c()
            {
              public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
              {
                AppMethodBeat.i(89854);
                paramAnonymous2l.jw(-1, 2131761512);
                paramAnonymous2l.jw(-1, 2131761511);
                paramAnonymous2l.jw(-1, 2131761510);
                paramAnonymous2l.jw(-1, 2131762789);
                paramAnonymous2l.jw(-1, 2131761494);
                AppMethodBeat.o(89854);
              }
            };
            paramAnonymousMenuItem.cED();
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
        this.vjD = 0;
        continue;
        if (localException.equals("2"))
        {
          if (locala == l.a.iKG)
          {
            this.vjF = 2;
            com.tencent.mm.model.a.f.yJ("3");
          }
        }
        else if ((localException.equals("1")) && (locala == l.a.iKD))
        {
          this.vjF = 2;
          com.tencent.mm.model.a.f.yJ("3");
        }
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(89872);
    ac.d("MicroMsg.NearbyFriend", "onActivityResult, requestCode %s, resultCode %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(89872);
      return;
      if (paramInt2 == -1)
      {
        this.vjv = false;
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
    com.tencent.mm.plugin.report.service.g.MH(11);
    super.onCreate(paramBundle);
    setMMTitle(2131761520);
    com.tencent.mm.kernel.g.agi().a(148, this);
    com.tencent.mm.kernel.g.agi().a(376, this);
    com.tencent.mm.kernel.g.agi().a(1087, this);
    this.fmW = com.tencent.mm.modelgeo.d.aEL();
    initView();
    this.vjw = new String[] { getResources().getString(2131761512), getResources().getString(2131761511), getResources().getString(2131761510), getResources().getString(2131762789) };
    this.vjx = bs.a((Integer)com.tencent.mm.kernel.g.agR().agA().get(16386, null), 1);
    Object localObject1;
    int j;
    int i;
    label231:
    Object localObject2;
    if (this.vjx == 3)
    {
      setTitleLogo(0, 2131690323);
      getData();
      if (!ab.eUL()) {
        break label796;
      }
      localObject1 = bv.L(((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pUQ, ""), "lbsads");
      if (localObject1 == null) {
        break label796;
      }
      j = bs.getInt((String)((Map)localObject1).get(".lbsads.$count"), 0);
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
      ((a)localObject2).pos = bs.getInt((String)((Map)localObject1).get(paramBundle + ".$pos"), 0);
      ((a)localObject2).vjN = bs.getInt((String)((Map)localObject1).get(paramBundle + ".$close_times"), 0);
      ((a)localObject2).vjO = bs.getInt((String)((Map)localObject1).get(paramBundle + ".$show_times"), 2147483647);
      ((a)localObject2).name = ((String)((Map)localObject1).get(paramBundle + ".name"));
      ((a)localObject2).desc = ((String)((Map)localObject1).get(paramBundle + ".desc"));
      ((a)localObject2).drM = ((String)((Map)localObject1).get(paramBundle + ".icon"));
      ((a)localObject2).vjP = bs.getInt((String)((Map)localObject1).get(paramBundle + ".jump.$type"), 0);
      ((a)localObject2).vjQ = ((String)((Map)localObject1).get(paramBundle + ".jump"));
      this.vju.put(((a)localObject2).id, localObject2);
      i += 1;
      break label231;
      if (this.vjx == 4)
      {
        setTitleLogo(0, 2131690322);
        break;
      }
      setTitleLogo(0, 0);
      this.vjx = 1;
      break;
    }
    label674:
    paramBundle = com.tencent.mm.kernel.g.agR().agA().get(ah.a.GTt, null);
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
          localObject2 = (a)this.vju.get(localObject1[0]);
          if (localObject2 != null)
          {
            ((a)localObject2).vjR = bs.getInt(localObject1[1], 0);
            ((a)localObject2).ofG = bs.getInt(localObject1[2], 0);
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
    if (this.vjF > 0) {
      com.tencent.mm.model.a.f.yK("3");
    }
    com.tencent.mm.plugin.report.service.g.MJ(11);
    com.tencent.mm.kernel.g.agi().b(148, this);
    com.tencent.mm.kernel.g.agi().b(376, this);
    com.tencent.mm.kernel.g.agi().b(1087, this);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if (this.fmW != null) {
      this.fmW.c(this.fnd);
    }
    com.tencent.mm.aj.p.aBy().cancel();
    Object localObject;
    if (this.vjr != null)
    {
      localObject = this.vjr;
      if (((c)localObject).iKs != null)
      {
        ((c)localObject).iKs.detach();
        ((c)localObject).iKs = null;
      }
    }
    if (this.qtW.size() > 0)
    {
      Iterator localIterator = this.vju.values().iterator();
      localObject = "";
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        localObject = new StringBuilder().append((String)localObject).append("|").append(locala.id).append(":").append(locala.vjR).append(":");
        int i = locala.ofG + 1;
        locala.ofG = i;
        localObject = i;
        com.tencent.mm.plugin.report.service.h.wUl.f(17431, new Object[] { locala.id, Integer.valueOf(locala.vjS + 1) });
      }
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GTt, localObject);
    }
    super.onDestroy();
    AppMethodBeat.o(89875);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(89873);
    super.onPause();
    if (this.fmW != null) {
      this.fmW.c(this.fnd);
    }
    com.tencent.mm.sdk.b.a.GpY.d(this.fnf);
    AppMethodBeat.o(89873);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(89874);
    super.onResume();
    if (this.fmW != null) {
      this.fmW.a(this.fnd, true);
    }
    djM();
    this.vjr.notifyDataSetChanged();
    com.tencent.mm.kernel.g.agP().afT();
    if (((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dco().bQe() == 0) {
      this.iNr.removeHeaderView(this.vjB);
    }
    com.tencent.mm.sdk.b.a.GpY.c(this.fnf);
    AppMethodBeat.o(89874);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
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
      int i = ((com.tencent.mm.plugin.nearby.a.c)paramn).Js();
      if ((this.vjs == null) && ((i == 1) || (i == 3) || (i == 4)))
      {
        AppMethodBeat.o(89876);
        return;
      }
      if (((i == 1) || (i == 3) || (i == 4)) && (this.vjv))
      {
        ac.v("MicroMsg.NearbyFriend", "onSceneEnd data already requested, code=%d", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(89876);
        return;
      }
      if ((this.vjg == null) && (i == 2))
      {
        AppMethodBeat.o(89876);
        return;
      }
      ac.i("MicroMsg.NearbyFriend", "onSceneEnd: errType=%d, errCode=%d, errMsg=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if (paramn.getType() != 148)
      {
        AppMethodBeat.o(89876);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if ((i == 1) || (i == 3) || (i == 4))
        {
          this.qtW = ((com.tencent.mm.plugin.nearby.a.c)paramn).djJ();
          if ((this.qtW == null) || (this.qtW.size() == 0))
          {
            findViewById(2131302694).setVisibility(0);
            this.iNr.setVisibility(8);
            djN();
            com.tencent.mm.plugin.report.service.g.MJ(11);
            if (this.vjx != 3) {
              break label767;
            }
            setTitleLogo(0, 2131690323);
            this.vjv = true;
            this.vjs = null;
          }
        }
        else
        {
          if (((com.tencent.mm.plugin.nearby.a.c)paramn).Js() == 2)
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
            this.vjg = null;
          }
          if (!((com.tencent.mm.plugin.nearby.a.c)paramn).djH()) {
            break label811;
          }
          paramString = getString(2131761523);
          paramInt1 = ((com.tencent.mm.plugin.nearby.a.c)paramn).djI();
          if (this.vjz != null)
          {
            if (this.vjA != null) {
              break label800;
            }
            this.vjA = View.inflate(this, 2131495005, null);
            this.vjz.addView(this.vjA);
            this.vjA.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(89840);
                NearbyFriendsUI.y(NearbyFriendsUI.this);
                AppMethodBeat.o(89840);
              }
            });
            ((TextView)this.vjA.findViewById(2131302700)).setText(paramString);
            if (paramInt1 != 0) {
              ((TextView)this.vjA.findViewById(2131302699)).setText(String.format(getResources().getQuantityString(2131623958, paramInt1, new Object[] { Integer.valueOf(paramInt1) }), new Object[0]));
            }
          }
        }
        for (;;)
        {
          this.vjE = true;
          AppMethodBeat.o(89876);
          return;
          paramString = new LinkedList();
          localObject = this.qtW.iterator();
          paramInt1 = 0;
          while (((Iterator)localObject).hasNext())
          {
            box localbox = (box)((Iterator)localObject).next();
            if (((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNo(localbox.ncR))
            {
              paramString.add(paramInt1, localbox);
              paramInt1 += 1;
            }
            else if ((!bs.isNullOrNil(localbox.ncR)) && (!bs.isNullOrNil(localbox.Fep)))
            {
              paramString.add(localbox);
            }
          }
          this.qtW.clear();
          this.qtW = paramString;
          if ((this.qtW == null) || (this.qtW.size() == 0))
          {
            findViewById(2131302694).setVisibility(0);
            this.iNr.setVisibility(8);
            break;
          }
          findViewById(2131302694).setVisibility(8);
          djO();
          this.vjr.notifyDataSetChanged();
          if (this.vjr.getCount() > 0) {
            this.iNr.setSelection(0);
          }
          this.iNr.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(89842);
              com.tencent.mm.plugin.report.service.g.MI(11);
              AppMethodBeat.o(89842);
            }
          });
          break;
          label767:
          if (this.vjx == 4)
          {
            setTitleLogo(0, 2131690322);
            break label321;
          }
          setTitleLogo(0, 0);
          this.vjx = 1;
          break label321;
          label800:
          this.vjA.setVisibility(0);
          break label454;
          label811:
          if ((this.vjA != null) && (this.vjz != null)) {
            this.vjA.setVisibility(8);
          }
        }
      }
      if ((i == 1) || (i == 3) || (i == 4))
      {
        localObject = (TextView)findViewById(2131302694);
        ((TextView)localObject).setVisibility(0);
        djN();
        if ((paramString == null) || (paramString.length() <= 0)) {
          break label1165;
        }
      }
    }
    label1165:
    for (paramString = com.tencent.mm.h.a.rM(paramString);; paramString = null)
    {
      if ((paramString != null) && (paramString.desc != null) && (paramString.desc.length() > 0)) {
        ((TextView)localObject).setText(paramString.desc);
      }
      for (;;)
      {
        this.iNr.setVisibility(8);
        this.vjs = null;
        if (((com.tencent.mm.plugin.nearby.a.c)paramn).Js() == 2)
        {
          Toast.makeText(this, 2131761496, 1).show();
          this.vjg = null;
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
        if (((com.tencent.mm.plugin.nearby.a.d)paramn).Js() != 1)
        {
          AppMethodBeat.o(89876);
          return;
        }
        if (this.tipDialog != null)
        {
          this.tipDialog.dismiss();
          this.tipDialog = null;
        }
        if ((paramInt1 == 0) && (paramInt2 == 0) && (((com.tencent.mm.plugin.nearby.a.d)paramn).ioe != null))
        {
          paramString = ((com.tencent.mm.plugin.nearby.a.d)paramn).ioe;
          com.tencent.mm.plugin.nearby.a.b.ia(paramString, ((com.tencent.mm.plugin.nearby.a.d)paramn).viO);
          paramn = new Intent();
          paramn.putExtra("Chat_User", paramString);
          com.tencent.mm.plugin.nearby.a.iyx.e(paramn, this);
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
    String drM;
    String id;
    boolean mMv = false;
    String name;
    int ofG;
    int pos;
    int vjN;
    int vjO;
    int vjP;
    String vjQ;
    int vjR;
    int vjS = -1;
  }
  
  final class b
  {
    public int accuracy;
    public float hEE;
    public float hEF;
    
    public b(float paramFloat1, float paramFloat2, int paramInt)
    {
      this.hEE = paramFloat1;
      this.hEF = paramFloat2;
      this.accuracy = paramInt;
    }
  }
  
  final class c
    extends BaseAdapter
  {
    private final Context context;
    com.tencent.mm.ui.applet.b iKs;
    private b.b iKt;
    
    public c(Context paramContext)
    {
      AppMethodBeat.i(89860);
      this.iKs = new com.tencent.mm.ui.applet.b(new com.tencent.mm.ui.applet.b.a()
      {
        public final Bitmap Go(String paramAnonymousString)
        {
          AppMethodBeat.i(89856);
          paramAnonymousString = com.tencent.mm.aj.c.a(paramAnonymousString, false, -1, null);
          AppMethodBeat.o(89856);
          return paramAnonymousString;
        }
      });
      this.iKt = null;
      this.context = paramContext;
      AppMethodBeat.o(89860);
    }
    
    public final box Kd(int paramInt)
    {
      AppMethodBeat.i(89863);
      box localbox = (box)NearbyFriendsUI.s(NearbyFriendsUI.this).get(paramInt);
      AppMethodBeat.o(89863);
      return localbox;
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
      if (this.iKt == null) {
        this.iKt = new b.b()
        {
          public final int aPz()
          {
            AppMethodBeat.i(89858);
            int i = NearbyFriendsUI.c.this.getCount();
            AppMethodBeat.o(89858);
            return i;
          }
          
          public final String qN(int paramAnonymousInt)
          {
            AppMethodBeat.i(89857);
            if ((paramAnonymousInt < 0) || (paramAnonymousInt >= NearbyFriendsUI.c.this.getCount()))
            {
              ac.e("MicroMsg.NearbyFriend", "pos is invalid");
              AppMethodBeat.o(89857);
              return null;
            }
            Object localObject = NearbyFriendsUI.c.this.Kd(paramAnonymousInt);
            if (localObject == null)
            {
              AppMethodBeat.o(89857);
              return null;
            }
            localObject = ((box)localObject).ncR;
            AppMethodBeat.o(89857);
            return localObject;
          }
        };
      }
      if (this.iKs != null) {
        this.iKs.a(paramInt, this.iKt);
      }
      Object localObject1;
      label365:
      Object localObject2;
      if (paramView == null)
      {
        paramViewGroup = new NearbyFriendsUI.e();
        paramView = View.inflate(this.context, 2131495002, null);
        paramViewGroup.iIN = ((TextView)paramView.findViewById(2131302693));
        paramViewGroup.vjX = ((TextView)paramView.findViewById(2131302696));
        paramViewGroup.vjW = ((TextView)paramView.findViewById(2131302688));
        paramViewGroup.iKw = ((ImageView)paramView.findViewById(2131302687));
        paramViewGroup.iKx = ((TextView)paramView.findViewById(2131302690));
        paramViewGroup.vjY = ((ImageView)paramView.findViewById(2131302698));
        paramViewGroup.vjZ = ((ImageView)paramView.findViewById(2131302697));
        paramViewGroup.vkb = ((ImageView)paramView.findViewById(2131302684));
        paramViewGroup.vkc = ((ImageView)paramView.findViewById(2131302685));
        paramViewGroup.vkd = ((ImageView)paramView.findViewById(2131302686));
        paramViewGroup.gDM = ((ImageView)paramView.findViewById(2131298364));
        localObject1 = paramViewGroup.vjZ.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).height = com.tencent.mm.cc.a.au(this.context, 2131165516);
        ((ViewGroup.LayoutParams)localObject1).width = com.tencent.mm.cc.a.au(this.context, 2131165516);
        paramViewGroup.vjZ.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        paramViewGroup.vka = ((ImageView)paramView.findViewById(2131302695));
        paramView.setTag(paramViewGroup);
        localObject1 = (box)NearbyFriendsUI.s(NearbyFriendsUI.this).get(paramInt);
        paramViewGroup.iIN.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, ((box)localObject1).ndW, paramViewGroup.iIN.getTextSize()));
        if (NearbyFriendsUI.h(NearbyFriendsUI.this) != 1) {
          break label859;
        }
        switch (((box)localObject1).iJT)
        {
        default: 
          paramViewGroup.vka.setVisibility(8);
          if (((box)localObject1).Feq != 0)
          {
            paramViewGroup.vjY.setVisibility(0);
            localObject2 = BackwardSupportUtil.b.n(ar.a.hny.nR(((box)localObject1).Feq), 2.0F);
            paramViewGroup.vjY.setImageBitmap((Bitmap)localObject2);
            paramViewGroup.vka.setVisibility(8);
            label418:
            paramViewGroup.vjW.setText(((box)localObject1).Fep);
            paramViewGroup.vkb.setVisibility(8);
            paramViewGroup.vkc.setVisibility(8);
            paramViewGroup.vkd.setVisibility(8);
            paramViewGroup.gDM.setVisibility(8);
            if ((localObject1 instanceof com.tencent.mm.plugin.nearby.a.a))
            {
              localObject2 = ((com.tencent.mm.plugin.nearby.a.a)localObject1).viL;
              if ((localObject2 == null) || (((LinkedList)localObject2).size() != 1)) {
                break label883;
              }
              paramViewGroup.vkb.setVisibility(0);
              NearbyFriendsUI.r(paramViewGroup.vkb, (String)((LinkedList)localObject2).get(0));
              label522:
              localObject2 = (NearbyFriendsUI.a)NearbyFriendsUI.t(NearbyFriendsUI.this).get(((box)localObject1).ncR);
              if (localObject2 != null)
              {
                if (((NearbyFriendsUI.a)localObject2).vjS != -1) {
                  break label1037;
                }
                paramInt = 0;
                label560:
                ((NearbyFriendsUI.a)localObject2).vjS = paramInt;
                if (((NearbyFriendsUI.a)localObject2).vjN > 0) {
                  paramViewGroup.gDM.setVisibility(0);
                }
              }
              paramViewGroup.gDM.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(89859);
                  paramAnonymousView = (NearbyFriendsUI.a)NearbyFriendsUI.t(NearbyFriendsUI.this).get(this.vjU.ncR);
                  if (paramAnonymousView != null)
                  {
                    paramAnonymousView.vjR += 1;
                    paramAnonymousView.mMv = true;
                    paramAnonymousView.vjS |= 0x2;
                  }
                  NearbyFriendsUI.A(NearbyFriendsUI.this);
                  NearbyFriendsUI.c.this.notifyDataSetChanged();
                  AppMethodBeat.o(89859);
                }
              });
            }
            if ((((box)localObject1).iJW != null) && (!((box)localObject1).iJW.trim().equals(""))) {
              break label1046;
            }
            paramViewGroup.vjX.setVisibility(8);
            label633:
            if ((((box)localObject1).Few == null) || ((((box)localObject1).Few.iKe & 0x1) <= 0)) {
              break label1083;
            }
            paramViewGroup.vjZ.setVisibility(0);
            label662:
            if (!NearbyFriendsUI.d.Ke(((box)localObject1).iJT)) {
              break label1095;
            }
            paramViewGroup.iKw.setImageBitmap(null);
            localObject2 = new c.a();
            ((c.a)localObject2).prefixPath = com.tencent.mm.plugin.image.d.awL();
            ((c.a)localObject2).hKx = true;
            ((c.a)localObject2).gKm = true;
            localObject2 = ((c.a)localObject2).aFT();
            o.aFB().a(((box)localObject1).Eog, paramViewGroup.iKw, (com.tencent.mm.av.a.a.c)localObject2);
            if (bs.isNullOrNil(((box)localObject1).iJY)) {
              break label1283;
            }
            paramViewGroup.iKx.setText(((box)localObject1).iJY);
            paramViewGroup.iKx.setVisibility(0);
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
        paramViewGroup.vka.setVisibility(0);
        paramViewGroup.vka.setImageResource(2131690323);
        paramViewGroup.vka.setContentDescription(this.context.getString(2131761078));
        break label365;
        paramViewGroup.vka.setVisibility(0);
        paramViewGroup.vka.setImageResource(2131690322);
        paramViewGroup.vka.setContentDescription(this.context.getString(2131759044));
        break label365;
        label859:
        paramViewGroup.vka.setVisibility(8);
        break label365;
        paramViewGroup.vjY.setVisibility(8);
        break label418;
        label883:
        if ((localObject2 != null) && (((LinkedList)localObject2).size() == 2))
        {
          paramViewGroup.vkb.setVisibility(0);
          paramViewGroup.vkc.setVisibility(0);
          NearbyFriendsUI.r(paramViewGroup.vkb, (String)((LinkedList)localObject2).get(0));
          NearbyFriendsUI.r(paramViewGroup.vkc, (String)((LinkedList)localObject2).get(1));
          break label522;
        }
        if ((localObject2 == null) || (((LinkedList)localObject2).size() < 3)) {
          break label522;
        }
        paramViewGroup.vkb.setVisibility(0);
        paramViewGroup.vkc.setVisibility(0);
        paramViewGroup.vkd.setVisibility(0);
        NearbyFriendsUI.r(paramViewGroup.vkb, (String)((LinkedList)localObject2).get(0));
        NearbyFriendsUI.r(paramViewGroup.vkc, (String)((LinkedList)localObject2).get(1));
        NearbyFriendsUI.r(paramViewGroup.vkd, (String)((LinkedList)localObject2).get(2));
        break label522;
        label1037:
        paramInt = ((NearbyFriendsUI.a)localObject2).vjS;
        break label560;
        label1046:
        paramViewGroup.vjX.setVisibility(0);
        paramViewGroup.vjX.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, ((box)localObject1).iJW, paramViewGroup.vjX.getTextSize()));
        break label633;
        label1083:
        paramViewGroup.vjZ.setVisibility(8);
        break label662;
        label1095:
        a.b.c(paramViewGroup.iKw, ((box)localObject1).ncR);
        if (((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNo(((box)localObject1).ncR))
        {
          paramViewGroup.iKx.setVisibility(0);
          if (ai.YI(((box)localObject1).Feq))
          {
            paramViewGroup.iKx.setText(NearbyFriendsUI.this.getString(2131761502));
          }
          else
          {
            ai localai = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNr(((box)localObject1).ncR);
            Context localContext;
            if (localai != null)
            {
              localObject2 = paramViewGroup.iIN;
              localContext = this.context;
              if (!bs.isNullOrNil(localai.aaS())) {
                break label1273;
              }
            }
            label1273:
            for (localObject1 = ((box)localObject1).ndW;; localObject1 = localai.aaS())
            {
              ((TextView)localObject2).setText(com.tencent.mm.pluginsdk.ui.span.k.b(localContext, (CharSequence)localObject1, paramViewGroup.iIN.getTextSize()));
              paramViewGroup.iKx.setText(NearbyFriendsUI.this.getString(2131761507));
              break;
            }
          }
        }
        else
        {
          label1283:
          paramViewGroup.iKx.setVisibility(8);
        }
      }
    }
  }
  
  static final class d
  {
    public static int vjV = 10000;
    
    public static boolean Ke(int paramInt)
    {
      return paramInt == vjV;
    }
    
    public static box d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    {
      AppMethodBeat.i(89865);
      com.tencent.mm.plugin.nearby.a.a locala = new com.tencent.mm.plugin.nearby.a.a();
      locala.iJT = vjV;
      locala.ncR = paramString1;
      locala.Eog = paramString2;
      locala.Fep = paramString4;
      locala.ndW = paramString3;
      locala.iJU = paramString5;
      AppMethodBeat.o(89865);
      return locala;
    }
  }
  
  static final class e
  {
    ImageView gDM;
    TextView iIN;
    ImageView iKw;
    TextView iKx;
    TextView vjW;
    TextView vjX;
    ImageView vjY;
    ImageView vjZ;
    ImageView vka;
    ImageView vkb;
    ImageView vkc;
    ImageView vkd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI
 * JD-Core Version:    0.7.0.1
 */