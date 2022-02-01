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
import com.tencent.mm.ak.n;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.cache.MCacheItem;
import com.tencent.mm.g.a.lc;
import com.tencent.mm.g.a.tl;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.i;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.c;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.aco;
import com.tencent.mm.protocal.protobuf.bue;
import com.tencent.mm.protocal.protobuf.dia;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.b.b;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
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
  implements com.tencent.mm.ak.f
{
  private com.tencent.mm.modelgeo.d fHi;
  private com.tencent.mm.modelgeo.b.a fHp;
  private com.tencent.mm.sdk.b.c fHr;
  boolean hmD;
  private ListView jjt;
  private List<bue> rlQ;
  private com.tencent.mm.ui.base.p tipDialog;
  private boolean vrl;
  private boolean vsk;
  private BindMobileOrQQHeaderView wEA;
  private ViewGroup wEB;
  private View wEC;
  private View wED;
  private boolean wEE;
  private int wEF;
  private boolean wEG;
  private int wEH;
  private View wEI;
  private b wEJ;
  private com.tencent.mm.plugin.nearby.a.c wEi;
  private c wEt;
  private com.tencent.mm.plugin.nearby.a.c wEu;
  private com.tencent.mm.plugin.nearby.a.d wEv;
  private Map<String, a> wEw;
  private boolean wEx;
  private String[] wEy;
  private int wEz;
  
  public NearbyFriendsUI()
  {
    AppMethodBeat.i(89866);
    this.tipDialog = null;
    this.rlQ = new LinkedList();
    this.wEw = new HashMap();
    this.wEx = false;
    this.wEz = 1;
    this.wEE = false;
    this.wEG = false;
    this.vrl = false;
    this.wEH = 0;
    this.wEI = null;
    this.fHr = new com.tencent.mm.sdk.b.c() {};
    this.hmD = false;
    this.fHp = new com.tencent.mm.modelgeo.b.a()
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
        if (NearbyFriendsUI.this.hmD)
        {
          if (NearbyFriendsUI.f(NearbyFriendsUI.this) != null)
          {
            NearbyFriendsUI.f(NearbyFriendsUI.this).dismiss();
            NearbyFriendsUI.a(NearbyFriendsUI.this, null);
          }
          com.tencent.mm.plugin.report.service.f.OR(11);
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
          com.tencent.mm.modelstat.e locale = com.tencent.mm.modelstat.e.aMb();
          if (paramAnonymousInt == 0)
          {
            paramAnonymousBoolean = false;
            if (NearbyFriendsUI.g(NearbyFriendsUI.this) != null) {
              break label264;
            }
            bool = false;
            label163:
            locale.a(2001, paramAnonymousBoolean, bool, paramAnonymousFloat1, paramAnonymousFloat2, (int)paramAnonymousDouble2);
            NearbyFriendsUI.a(NearbyFriendsUI.this, new com.tencent.mm.plugin.nearby.a.c(NearbyFriendsUI.h(NearbyFriendsUI.this), NearbyFriendsUI.i(NearbyFriendsUI.this).iac, NearbyFriendsUI.i(NearbyFriendsUI.this).iab, NearbyFriendsUI.i(NearbyFriendsUI.this).accuracy, paramAnonymousInt, "", ""));
            com.tencent.mm.kernel.g.ajj().a(NearbyFriendsUI.b(NearbyFriendsUI.this), 0);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(89846);
          return false;
          paramAnonymousBoolean = true;
          break;
          label264:
          bool = NearbyFriendsUI.g(NearbyFriendsUI.this).iam;
          break label163;
          com.tencent.mm.plugin.report.service.f.OR(11);
          if (NearbyFriendsUI.f(NearbyFriendsUI.this) != null)
          {
            NearbyFriendsUI.f(NearbyFriendsUI.this).dismiss();
            NearbyFriendsUI.a(NearbyFriendsUI.this, null);
          }
          NearbyFriendsUI.this.findViewById(2131302691).setVisibility(0);
          NearbyFriendsUI.j(NearbyFriendsUI.this).setVisibility(8);
          NearbyFriendsUI.k(NearbyFriendsUI.this);
          if ((!NearbyFriendsUI.l(NearbyFriendsUI.this)) && (!com.tencent.mm.modelgeo.d.aIi()))
          {
            NearbyFriendsUI.m(NearbyFriendsUI.this);
            h.a(NearbyFriendsUI.this, NearbyFriendsUI.this.getString(2131760082), NearbyFriendsUI.this.getString(2131755906), NearbyFriendsUI.this.getString(2131760598), NearbyFriendsUI.this.getString(2131755691), false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(89845);
                com.tencent.mm.modelgeo.d.cD(NearbyFriendsUI.this);
                AppMethodBeat.o(89845);
              }
            }, null);
          }
        }
      }
    };
    AppMethodBeat.o(89866);
  }
  
  private void dxn()
  {
    AppMethodBeat.i(89869);
    View localView;
    Object localObject;
    int i;
    if (com.tencent.mm.bp.a.fcr())
    {
      if (this.wEI != null)
      {
        this.jjt.removeHeaderView(this.wEI);
        this.wEI = null;
      }
      localView = View.inflate(this, 2131495004, null);
      localObject = (TextView)localView.findViewById(2131304292);
      com.tencent.mm.kernel.g.ajP().aiU();
      i = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doG().bVY();
      if (i != 0) {
        break label119;
      }
      localView.setVisibility(8);
      localView = null;
    }
    for (;;)
    {
      this.wEI = localView;
      if (this.wEI != null) {
        this.jjt.addHeaderView(this.wEI);
      }
      AppMethodBeat.o(89869);
      return;
      label119:
      localView.setVisibility(0);
      ((TextView)localObject).setText(getResources().getQuantityString(2131623965, i, new Object[] { Integer.valueOf(i) }));
      localObject = (ImageView)localView.findViewById(2131302192);
      bs localbs = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doG().doR();
      if (localbs != null) {
        a.b.c((ImageView)localObject, localbs.field_sayhiuser);
      }
      localView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(89847);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/nearby/ui/NearbyFriendsUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          NearbyFriendsUI.j(NearbyFriendsUI.this).removeHeaderView(NearbyFriendsUI.n(NearbyFriendsUI.this));
          NearbyFriendsUI.o(NearbyFriendsUI.this);
          paramAnonymousView = new Intent(NearbyFriendsUI.this, NearbySayHiListUI.class);
          paramAnonymousView.putExtra("k_say_hi_type", 2);
          paramAnonymousView.putExtra("show_clear_header", true);
          NearbyFriendsUI.this.startActivityForResult(paramAnonymousView, 2009);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearby/ui/NearbyFriendsUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(89847);
        }
      });
    }
  }
  
  private void dxo()
  {
    AppMethodBeat.i(89871);
    com.tencent.mm.plugin.nearby.a.iUz.bD(this);
    AppMethodBeat.o(89871);
  }
  
  private void dxp()
  {
    int j = 0;
    AppMethodBeat.i(89877);
    Object localObject1 = new LinkedList();
    int i = 0;
    while (i < this.rlQ.size())
    {
      if (!d.Ml(((bue)this.rlQ.get(i)).jfV)) {
        ((List)localObject1).add(this.rlQ.get(i));
      }
      i += 1;
    }
    this.rlQ.clear();
    this.rlQ = ((List)localObject1);
    ae.i("MicroMsg.NearbyFriend", "insertPoiItemList()");
    label133:
    Object localObject2;
    List localList;
    if (!this.rlQ.isEmpty())
    {
      i = 1;
      localObject1 = this.wEw.keySet().iterator();
      do
      {
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (String)((Iterator)localObject1).next();
        } while (i == 0);
        localObject2 = (a)this.wEw.get(localObject2);
      } while ((((a)localObject2).nsb) || ((((a)localObject2).wEP > 0) && (((a)localObject2).wES >= ((a)localObject2).wEP)) || (((a)localObject2).oPB >= ((a)localObject2).wEQ));
      localList = this.rlQ;
      if ((((a)localObject2).pos >= 0) && (((a)localObject2).pos <= this.rlQ.size())) {
        break label306;
      }
    }
    label306:
    for (int k = this.rlQ.size();; k = ((a)localObject2).pos + j)
    {
      localList.add(k, d.d(((a)localObject2).id, ((a)localObject2).dEM, ((a)localObject2).name, ((a)localObject2).desc, ((a)localObject2).wER));
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
    this.vrl = false;
    AppCompatActivity localAppCompatActivity = getContext();
    getString(2131755906);
    this.tipDialog = h.b(localAppCompatActivity, getString(2131761509), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(89844);
        NearbyFriendsUI.this.hmD = true;
        com.tencent.mm.plugin.report.service.f.OR(11);
        if (NearbyFriendsUI.b(NearbyFriendsUI.this) != null) {
          com.tencent.mm.kernel.g.ajj().a(NearbyFriendsUI.b(NearbyFriendsUI.this));
        }
        ae.i("MicroMsg.NearbyFriend", "[MonsterzDai]  [loading cancel] cancel in loading");
        if (!NearbyFriendsUI.c(NearbyFriendsUI.this))
        {
          NearbyFriendsUI.this.finish();
          ae.i("MicroMsg.NearbyFriend", "[MonsterzDai]  [loading cancel] cancel in first loading");
        }
        AppMethodBeat.o(89844);
      }
    });
    this.hmD = false;
    if (this.fHi != null) {
      this.fHi.a(this.fHp, true);
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
    this.jjt = ((ListView)findViewById(2131302692));
    this.wEt = new c(this);
    Object localObject = this.jjt;
    if (this.wEB == null)
    {
      this.wEB = new LinearLayout(this);
      this.wEB.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      ((LinearLayout)this.wEB).setGravity(17);
    }
    this.wEE = true;
    ((ListView)localObject).addHeaderView(this.wEB);
    localObject = com.tencent.mm.n.g.acL().getValue("LBSShowBindPhone");
    if ((localObject != null) && (((String)localObject).length() > 0)) {}
    try
    {
      this.wEF = Integer.valueOf((String)localObject).intValue();
      localObject = (String)com.tencent.mm.kernel.g.ajR().ajA().get(6, null);
      if ((localObject != null) && (((String)localObject).length() > 0)) {
        this.wEF = 0;
      }
      this.wEH = 0;
      if (com.tencent.mm.model.a.g.aDh().Cg("3") != null)
      {
        localObject = com.tencent.mm.model.a.g.aDh().Cg("3").value;
        locala = com.tencent.mm.plugin.account.friend.a.l.aTn();
        if (((String)localObject).equals("0")) {
          this.wEH = 0;
        }
      }
      else
      {
        if (((this.wEF > 0) || (this.wEH > 0)) && (this.wEH != 1))
        {
          this.wEA = new BindMobileOrQQHeaderView(this);
          this.jjt.addHeaderView(this.wEA);
        }
        this.jjt.setAdapter(this.wEt);
        this.jjt.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(89848);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousAdapterView);
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            ((com.tencent.mm.hellhoundlib.b.b)localObject).mu(paramAnonymousInt);
            ((com.tencent.mm.hellhoundlib.b.b)localObject).rl(paramAnonymousLong);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/nearby/ui/NearbyFriendsUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
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
            if (com.tencent.mm.bp.a.fcr())
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
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearby/ui/NearbyFriendsUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(89848);
              return;
            }
            paramAnonymousAdapterView = (bue)NearbyFriendsUI.s(NearbyFriendsUI.this).get(i);
            if (NearbyFriendsUI.d.Ml(paramAnonymousAdapterView.jfV))
            {
              paramAnonymousAdapterView = (NearbyFriendsUI.a)NearbyFriendsUI.t(NearbyFriendsUI.this).get(paramAnonymousAdapterView.nIJ);
              paramAnonymousAdapterView.wET |= 0x1;
              if (paramAnonymousAdapterView.uIW == 1)
              {
                paramAnonymousView = new AppBrandStatObject();
                paramAnonymousView.scene = 1134;
                ((com.tencent.mm.plugin.appbrand.service.p)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.p.class)).a(NearbyFriendsUI.this, paramAnonymousAdapterView.wER, "", 0, 0, "", paramAnonymousView);
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearby/ui/NearbyFriendsUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(89848);
                return;
                if (paramAnonymousAdapterView.uIW == 2)
                {
                  paramAnonymousView = new Intent();
                  paramAnonymousView.putExtra("rawUrl", paramAnonymousAdapterView.wER);
                  paramAnonymousView.putExtra("geta8key_scene", 25);
                  paramAnonymousView.putExtra("stastic_scene", 12);
                  com.tencent.mm.br.d.b(NearbyFriendsUI.this.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
                }
              }
            }
            paramAnonymousView = paramAnonymousAdapterView.nIJ;
            an localan = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(paramAnonymousView);
            if (com.tencent.mm.contact.c.lO(localan.field_type))
            {
              localObject = new Intent();
              ((Intent)localObject).putExtra("Contact_User", paramAnonymousView);
              ((Intent)localObject).putExtra("Contact_Scene", 18);
              ((Intent)localObject).putExtra("Sns_from_Scene", 18);
              ((Intent)localObject).putExtra("lbs_ticket", paramAnonymousAdapterView.GNI);
              ((Intent)localObject).putExtra("Contact_IsLbsGotoChatting", true);
              if ((paramAnonymousView != null) && (paramAnonymousView.length() > 0))
              {
                if (localan.fug()) {
                  com.tencent.mm.plugin.report.service.g.yxI.kvStat(10298, paramAnonymousView + ",18");
                }
                paramAnonymousAdapterView = new tl();
                paramAnonymousAdapterView.dIV.intent = ((Intent)localObject);
                paramAnonymousAdapterView.dIV.username = paramAnonymousView;
                com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousAdapterView);
                ((Intent)localObject).putExtra("CONTACT_INFO_UI_SOURCE", 5);
                com.tencent.mm.plugin.nearby.a.iUz.c((Intent)localObject, NearbyFriendsUI.this);
              }
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearby/ui/NearbyFriendsUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(89848);
              return;
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView.nIJ);
              paramAnonymousView.putExtra("Contact_Alias", paramAnonymousAdapterView.jga);
              paramAnonymousView.putExtra("Contact_Nick", paramAnonymousAdapterView.nJO);
              paramAnonymousView.putExtra("Contact_Distance", paramAnonymousAdapterView.Hht);
              paramAnonymousView.putExtra("Contact_Signature", paramAnonymousAdapterView.jfY);
              paramAnonymousView.putExtra("Contact_RegionCode", RegionCodeDecoder.bg(paramAnonymousAdapterView.jge, paramAnonymousAdapterView.jfW, paramAnonymousAdapterView.jfX));
              paramAnonymousView.putExtra("Contact_Sex", paramAnonymousAdapterView.jfV);
              paramAnonymousView.putExtra("Contact_IsLBSFriend", true);
              paramAnonymousView.putExtra("Contact_Scene", 18);
              paramAnonymousView.putExtra("Contact_VUser_Info", paramAnonymousAdapterView.Hhv);
              paramAnonymousView.putExtra("Contact_VUser_Info_Flag", paramAnonymousAdapterView.Hhu);
              paramAnonymousView.putExtra("Contact_KWeibo_flag", paramAnonymousAdapterView.Hhy);
              paramAnonymousView.putExtra("Contact_KWeibo", paramAnonymousAdapterView.Hhw);
              paramAnonymousView.putExtra("Contact_KWeiboNick", paramAnonymousAdapterView.Hhx);
              paramAnonymousView.putExtra("Contact_KSnsIFlag", paramAnonymousAdapterView.HhA.jgg);
              paramAnonymousView.putExtra("Contact_KSnsBgId", paramAnonymousAdapterView.HhA.jgi);
              paramAnonymousView.putExtra("Contact_KSnsBgUrl", paramAnonymousAdapterView.HhA.jgh);
              paramAnonymousView.putExtra("lbs_ticket", paramAnonymousAdapterView.GNI);
              paramAnonymousView.putExtra("Contact_IsLbsGotoChatting", true);
              if (paramAnonymousAdapterView.jgf != null)
              {
                localObject = new com.tencent.mm.api.c();
                ((com.tencent.mm.api.c)localObject).field_brandList = paramAnonymousAdapterView.jgf;
                ((com.tencent.mm.api.c)localObject).field_brandFlag = paramAnonymousAdapterView.HhB.jgj;
                ((com.tencent.mm.api.c)localObject).field_brandIconURL = paramAnonymousAdapterView.HhB.jgm;
                ((com.tencent.mm.api.c)localObject).field_extInfo = paramAnonymousAdapterView.HhB.jgk;
                ((com.tencent.mm.api.c)localObject).field_brandInfo = paramAnonymousAdapterView.HhB.jgl;
                paramAnonymousView.putExtra("KBrandInfo_item", new MCacheItem((com.tencent.mm.sdk.e.c)localObject));
              }
              paramAnonymousView.putExtra("Sns_from_Scene", 18);
              paramAnonymousView.putExtra("CONTACT_INFO_UI_SOURCE", 5);
              com.tencent.mm.plugin.nearby.a.iUz.c(paramAnonymousView, NearbyFriendsUI.this);
            }
          }
        });
        this.jjt.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(89849);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            localb.bd(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/nearby/ui/NearbyFriendsUI$6", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
            if (NearbyFriendsUI.u(NearbyFriendsUI.this) != null)
            {
              paramAnonymousView = NearbyFriendsUI.u(NearbyFriendsUI.this);
              if (paramAnonymousView.jgu != null) {
                paramAnonymousView.jgu.onTouchEvent(paramAnonymousMotionEvent);
              }
            }
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/nearby/ui/NearbyFriendsUI$6", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
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
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/nearby/ui/NearbyFriendsUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
            paramAnonymousView = NearbyFriendsUI.j(NearbyFriendsUI.this);
            paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
            localObject = new Object();
            com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.ahE(), "com/tencent/mm/plugin/nearby/ui/NearbyFriendsUI$8", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
            BackwardSupportUtil.c.b((ListView)paramAnonymousView.mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/nearby/ui/NearbyFriendsUI$8", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearby/ui/NearbyFriendsUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(89851);
          }
        });
        addIconOptionMenu(0, 2131690603, new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(89855);
            paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(NearbyFriendsUI.this, 1, false);
            paramAnonymousMenuItem.LfT = new n.e()
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
                  com.tencent.mm.kernel.g.ajR().ajA().set(16386, Integer.valueOf(NearbyFriendsUI.h(NearbyFriendsUI.this)));
                  NearbyFriendsUI.w(NearbyFriendsUI.this);
                  AppMethodBeat.o(89853);
                  return;
                  NearbyFriendsUI.a(NearbyFriendsUI.this, 3);
                  NearbyFriendsUI.v(NearbyFriendsUI.this);
                  com.tencent.mm.kernel.g.ajR().ajA().set(16386, Integer.valueOf(NearbyFriendsUI.h(NearbyFriendsUI.this)));
                  NearbyFriendsUI.w(NearbyFriendsUI.this);
                  AppMethodBeat.o(89853);
                  return;
                  NearbyFriendsUI.a(NearbyFriendsUI.this, 1);
                  NearbyFriendsUI.v(NearbyFriendsUI.this);
                  com.tencent.mm.kernel.g.ajR().ajA().set(16386, Integer.valueOf(NearbyFriendsUI.h(NearbyFriendsUI.this)));
                  NearbyFriendsUI.w(NearbyFriendsUI.this);
                  AppMethodBeat.o(89853);
                  return;
                  paramAnonymous2MenuItem = new Intent(NearbyFriendsUI.this, NearbySayHiListUI.class);
                  paramAnonymous2MenuItem.putExtra("k_say_hi_type", 2);
                  NearbyFriendsUI.this.startActivityForResult(paramAnonymous2MenuItem, 2009);
                  AppMethodBeat.o(89853);
                  return;
                  NearbyFriendsUI.b(NearbyFriendsUI.this, new com.tencent.mm.plugin.nearby.a.c(2, 0.0F, 0.0F, 0, 0, "", ""));
                  com.tencent.mm.kernel.g.ajj().a(NearbyFriendsUI.x(NearbyFriendsUI.this), 0);
                  paramAnonymous2MenuItem = NearbyFriendsUI.this;
                  AppCompatActivity localAppCompatActivity = NearbyFriendsUI.this.getContext();
                  NearbyFriendsUI.this.getString(2131755906);
                  NearbyFriendsUI.a(paramAnonymous2MenuItem, h.b(localAppCompatActivity, NearbyFriendsUI.this.getString(2131761498), true, new DialogInterface.OnCancelListener()
                  {
                    public final void onCancel(DialogInterface paramAnonymous3DialogInterface)
                    {
                      AppMethodBeat.i(89852);
                      com.tencent.mm.kernel.g.ajj().a(NearbyFriendsUI.x(NearbyFriendsUI.this));
                      AppMethodBeat.o(89852);
                    }
                  }));
                }
              }
            };
            paramAnonymousMenuItem.LfS = new n.d()
            {
              public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
              {
                AppMethodBeat.i(89854);
                paramAnonymous2l.jM(-1, 2131761512);
                paramAnonymous2l.jM(-1, 2131761511);
                paramAnonymous2l.jM(-1, 2131761510);
                paramAnonymous2l.jM(-1, 2131762789);
                paramAnonymous2l.jM(-1, 2131761494);
                AppMethodBeat.o(89854);
              }
            };
            paramAnonymousMenuItem.cPF();
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
        this.wEF = 0;
        continue;
        if (localException.equals("2"))
        {
          if (locala == l.a.jgI)
          {
            this.wEH = 2;
            com.tencent.mm.model.a.f.Ck("3");
          }
        }
        else if ((localException.equals("1")) && (locala == l.a.jgF))
        {
          this.wEH = 2;
          com.tencent.mm.model.a.f.Ck("3");
        }
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(89872);
    ae.d("MicroMsg.NearbyFriend", "onActivityResult, requestCode %s, resultCode %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(89872);
      return;
      if (paramInt2 == -1)
      {
        this.wEx = false;
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
    com.tencent.mm.plugin.report.service.f.OP(11);
    super.onCreate(paramBundle);
    setMMTitle(2131761520);
    com.tencent.mm.kernel.g.ajj().a(148, this);
    com.tencent.mm.kernel.g.ajj().a(376, this);
    com.tencent.mm.kernel.g.ajj().a(1087, this);
    this.fHi = com.tencent.mm.modelgeo.d.aIh();
    initView();
    this.wEy = new String[] { getResources().getString(2131761512), getResources().getString(2131761511), getResources().getString(2131761510), getResources().getString(2131762789) };
    this.wEz = bu.a((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(16386, null), 1);
    Object localObject1;
    int j;
    int i;
    label231:
    Object localObject2;
    if (this.wEz == 3)
    {
      setTitleLogo(0, 2131690323);
      getData();
      if (!ad.foj()) {
        break label796;
      }
      localObject1 = bx.M(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qGC, ""), "lbsads");
      if (localObject1 == null) {
        break label796;
      }
      j = bu.getInt((String)((Map)localObject1).get(".lbsads.$count"), 0);
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
      ((a)localObject2).pos = bu.getInt((String)((Map)localObject1).get(paramBundle + ".$pos"), 0);
      ((a)localObject2).wEP = bu.getInt((String)((Map)localObject1).get(paramBundle + ".$close_times"), 0);
      ((a)localObject2).wEQ = bu.getInt((String)((Map)localObject1).get(paramBundle + ".$show_times"), 2147483647);
      ((a)localObject2).name = ((String)((Map)localObject1).get(paramBundle + ".name"));
      ((a)localObject2).desc = ((String)((Map)localObject1).get(paramBundle + ".desc"));
      ((a)localObject2).dEM = ((String)((Map)localObject1).get(paramBundle + ".icon"));
      ((a)localObject2).uIW = bu.getInt((String)((Map)localObject1).get(paramBundle + ".jump.$type"), 0);
      ((a)localObject2).wER = ((String)((Map)localObject1).get(paramBundle + ".jump"));
      this.wEw.put(((a)localObject2).id, localObject2);
      i += 1;
      break label231;
      if (this.wEz == 4)
      {
        setTitleLogo(0, 2131690322);
        break;
      }
      setTitleLogo(0, 0);
      this.wEz = 1;
      break;
    }
    label674:
    paramBundle = com.tencent.mm.kernel.g.ajR().ajA().get(am.a.Jay, null);
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
          localObject2 = (a)this.wEw.get(localObject1[0]);
          if (localObject2 != null)
          {
            ((a)localObject2).wES = bu.getInt(localObject1[1], 0);
            ((a)localObject2).oPB = bu.getInt(localObject1[2], 0);
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
    if (this.wEH > 0) {
      com.tencent.mm.model.a.f.Cl("3");
    }
    com.tencent.mm.plugin.report.service.f.OR(11);
    com.tencent.mm.kernel.g.ajj().b(148, this);
    com.tencent.mm.kernel.g.ajj().b(376, this);
    com.tencent.mm.kernel.g.ajj().b(1087, this);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if (this.fHi != null) {
      this.fHi.c(this.fHp);
    }
    com.tencent.mm.aj.p.aEP().cancel();
    Object localObject;
    if (this.wEt != null)
    {
      localObject = this.wEt;
      if (((c)localObject).jgu != null)
      {
        ((c)localObject).jgu.detach();
        ((c)localObject).jgu = null;
      }
    }
    if (this.rlQ.size() > 0)
    {
      Iterator localIterator = this.wEw.values().iterator();
      localObject = "";
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        localObject = new StringBuilder().append((String)localObject).append("|").append(locala.id).append(":").append(locala.wES).append(":");
        int i = locala.oPB + 1;
        locala.oPB = i;
        localObject = i;
        com.tencent.mm.plugin.report.service.g.yxI.f(17431, new Object[] { locala.id, Integer.valueOf(locala.wET + 1) });
      }
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.Jay, localObject);
    }
    super.onDestroy();
    AppMethodBeat.o(89875);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(89873);
    super.onPause();
    if (this.fHi != null) {
      this.fHi.c(this.fHp);
    }
    com.tencent.mm.sdk.b.a.IvT.d(this.fHr);
    AppMethodBeat.o(89873);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(89874);
    super.onResume();
    if (this.fHi != null) {
      this.fHi.a(this.fHp, true);
    }
    dxn();
    this.wEt.notifyDataSetChanged();
    com.tencent.mm.kernel.g.ajP().aiU();
    if (((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doG().bVY() == 0) {
      this.jjt.removeHeaderView(this.wED);
    }
    com.tencent.mm.sdk.b.a.IvT.c(this.fHr);
    AppMethodBeat.o(89874);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
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
      int i = ((com.tencent.mm.plugin.nearby.a.c)paramn).KZ();
      if ((this.wEu == null) && ((i == 1) || (i == 3) || (i == 4)))
      {
        AppMethodBeat.o(89876);
        return;
      }
      if (((i == 1) || (i == 3) || (i == 4)) && (this.wEx))
      {
        ae.v("MicroMsg.NearbyFriend", "onSceneEnd data already requested, code=%d", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(89876);
        return;
      }
      if ((this.wEi == null) && (i == 2))
      {
        AppMethodBeat.o(89876);
        return;
      }
      ae.i("MicroMsg.NearbyFriend", "onSceneEnd: errType=%d, errCode=%d, errMsg=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if (paramn.getType() != 148)
      {
        AppMethodBeat.o(89876);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if ((i == 1) || (i == 3) || (i == 4))
        {
          this.rlQ = ((com.tencent.mm.plugin.nearby.a.c)paramn).dxk();
          if ((this.rlQ == null) || (this.rlQ.size() == 0))
          {
            findViewById(2131302694).setVisibility(0);
            this.jjt.setVisibility(8);
            dxo();
            com.tencent.mm.plugin.report.service.f.OR(11);
            if (this.wEz != 3) {
              break label767;
            }
            setTitleLogo(0, 2131690323);
            this.wEx = true;
            this.wEu = null;
          }
        }
        else
        {
          if (((com.tencent.mm.plugin.nearby.a.c)paramn).KZ() == 2)
          {
            h.d(getContext(), getString(2131761497), "", new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(89843);
                NearbyFriendsUI.this.finish();
                AppMethodBeat.o(89843);
              }
            });
            this.wEi = null;
          }
          if (!((com.tencent.mm.plugin.nearby.a.c)paramn).dxi()) {
            break label811;
          }
          paramString = getString(2131761523);
          paramInt1 = ((com.tencent.mm.plugin.nearby.a.c)paramn).dxj();
          if (this.wEB != null)
          {
            if (this.wEC != null) {
              break label800;
            }
            this.wEC = View.inflate(this, 2131495005, null);
            this.wEB.addView(this.wEC);
            this.wEC.setOnClickListener(new NearbyFriendsUI.2(this));
            ((TextView)this.wEC.findViewById(2131302700)).setText(paramString);
            if (paramInt1 != 0) {
              ((TextView)this.wEC.findViewById(2131302699)).setText(String.format(getResources().getQuantityString(2131623958, paramInt1, new Object[] { Integer.valueOf(paramInt1) }), new Object[0]));
            }
          }
        }
        for (;;)
        {
          this.wEG = true;
          AppMethodBeat.o(89876);
          return;
          paramString = new LinkedList();
          localObject = this.rlQ.iterator();
          paramInt1 = 0;
          while (((Iterator)localObject).hasNext())
          {
            bue localbue = (bue)((Iterator)localObject).next();
            if (((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().aUH(localbue.nIJ))
            {
              paramString.add(paramInt1, localbue);
              paramInt1 += 1;
            }
            else if ((!bu.isNullOrNil(localbue.nIJ)) && (!bu.isNullOrNil(localbue.Hht)))
            {
              paramString.add(localbue);
            }
          }
          this.rlQ.clear();
          this.rlQ = paramString;
          if ((this.rlQ == null) || (this.rlQ.size() == 0))
          {
            findViewById(2131302694).setVisibility(0);
            this.jjt.setVisibility(8);
            break;
          }
          findViewById(2131302694).setVisibility(8);
          dxp();
          this.wEt.notifyDataSetChanged();
          if (this.wEt.getCount() > 0) {
            this.jjt.setSelection(0);
          }
          this.jjt.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(89842);
              com.tencent.mm.plugin.report.service.f.OQ(11);
              AppMethodBeat.o(89842);
            }
          });
          break;
          label767:
          if (this.wEz == 4)
          {
            setTitleLogo(0, 2131690322);
            break label321;
          }
          setTitleLogo(0, 0);
          this.wEz = 1;
          break label321;
          label800:
          this.wEC.setVisibility(0);
          break label454;
          label811:
          if ((this.wEC != null) && (this.wEB != null)) {
            this.wEC.setVisibility(8);
          }
        }
      }
      if ((i == 1) || (i == 3) || (i == 4))
      {
        localObject = (TextView)findViewById(2131302694);
        ((TextView)localObject).setVisibility(0);
        dxo();
        if ((paramString == null) || (paramString.length() <= 0)) {
          break label1165;
        }
      }
    }
    label1165:
    for (paramString = com.tencent.mm.h.a.uU(paramString);; paramString = null)
    {
      if ((paramString != null) && (paramString.desc != null) && (paramString.desc.length() > 0)) {
        ((TextView)localObject).setText(paramString.desc);
      }
      for (;;)
      {
        this.jjt.setVisibility(8);
        this.wEu = null;
        if (((com.tencent.mm.plugin.nearby.a.c)paramn).KZ() == 2)
        {
          Toast.makeText(this, 2131761496, 1).show();
          this.wEi = null;
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
        if (((com.tencent.mm.plugin.nearby.a.d)paramn).KZ() != 1)
        {
          AppMethodBeat.o(89876);
          return;
        }
        if (this.tipDialog != null)
        {
          this.tipDialog.dismiss();
          this.tipDialog = null;
        }
        if ((paramInt1 == 0) && (paramInt2 == 0) && (((com.tencent.mm.plugin.nearby.a.d)paramn).iKu != null))
        {
          paramString = ((com.tencent.mm.plugin.nearby.a.d)paramn).iKu;
          com.tencent.mm.plugin.nearby.a.b.ir(paramString, ((com.tencent.mm.plugin.nearby.a.d)paramn).wDQ);
          paramn = new Intent();
          paramn.putExtra("Chat_User", paramString);
          com.tencent.mm.plugin.nearby.a.iUz.e(paramn, this);
          AppMethodBeat.o(89876);
          return;
        }
        h.a(getContext(), 2131761521, 2131755906, new DialogInterface.OnClickListener()
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
    String dEM;
    String desc;
    String id;
    String name;
    boolean nsb = false;
    int oPB;
    int pos;
    int uIW;
    int wEP;
    int wEQ;
    String wER;
    int wES;
    int wET = -1;
  }
  
  final class b
  {
    public int accuracy;
    public float iab;
    public float iac;
    
    public b(float paramFloat1, float paramFloat2, int paramInt)
    {
      this.iab = paramFloat1;
      this.iac = paramFloat2;
      this.accuracy = paramInt;
    }
  }
  
  final class c
    extends BaseAdapter
  {
    private final Context context;
    com.tencent.mm.ui.applet.b jgu;
    private b.b jgv;
    
    public c(Context paramContext)
    {
      AppMethodBeat.i(89860);
      this.jgu = new com.tencent.mm.ui.applet.b(new com.tencent.mm.ui.applet.b.a()
      {
        public final Bitmap Kc(String paramAnonymousString)
        {
          AppMethodBeat.i(89856);
          paramAnonymousString = com.tencent.mm.aj.c.a(paramAnonymousString, false, -1, null);
          AppMethodBeat.o(89856);
          return paramAnonymousString;
        }
      });
      this.jgv = null;
      this.context = paramContext;
      AppMethodBeat.o(89860);
    }
    
    public final bue Mk(int paramInt)
    {
      AppMethodBeat.i(89863);
      bue localbue = (bue)NearbyFriendsUI.s(NearbyFriendsUI.this).get(paramInt);
      AppMethodBeat.o(89863);
      return localbue;
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
      if (this.jgv == null) {
        this.jgv = new b.b()
        {
          public final int aTk()
          {
            AppMethodBeat.i(89858);
            int i = NearbyFriendsUI.c.this.getCount();
            AppMethodBeat.o(89858);
            return i;
          }
          
          public final String rq(int paramAnonymousInt)
          {
            AppMethodBeat.i(89857);
            if ((paramAnonymousInt < 0) || (paramAnonymousInt >= NearbyFriendsUI.c.this.getCount()))
            {
              ae.e("MicroMsg.NearbyFriend", "pos is invalid");
              AppMethodBeat.o(89857);
              return null;
            }
            Object localObject = NearbyFriendsUI.c.this.Mk(paramAnonymousInt);
            if (localObject == null)
            {
              AppMethodBeat.o(89857);
              return null;
            }
            localObject = ((bue)localObject).nIJ;
            AppMethodBeat.o(89857);
            return localObject;
          }
        };
      }
      if (this.jgu != null) {
        this.jgu.a(paramInt, this.jgv);
      }
      Object localObject1;
      label365:
      Object localObject2;
      if (paramView == null)
      {
        paramViewGroup = new NearbyFriendsUI.e();
        paramView = View.inflate(this.context, 2131495002, null);
        paramViewGroup.jeP = ((TextView)paramView.findViewById(2131302693));
        paramViewGroup.wEY = ((TextView)paramView.findViewById(2131302696));
        paramViewGroup.wEX = ((TextView)paramView.findViewById(2131302688));
        paramViewGroup.jgy = ((ImageView)paramView.findViewById(2131302687));
        paramViewGroup.jgz = ((TextView)paramView.findViewById(2131302690));
        paramViewGroup.wEZ = ((ImageView)paramView.findViewById(2131302698));
        paramViewGroup.wFa = ((ImageView)paramView.findViewById(2131302697));
        paramViewGroup.wFc = ((ImageView)paramView.findViewById(2131302684));
        paramViewGroup.wFd = ((ImageView)paramView.findViewById(2131302685));
        paramViewGroup.wFe = ((ImageView)paramView.findViewById(2131302686));
        paramViewGroup.hai = ((ImageView)paramView.findViewById(2131298364));
        localObject1 = paramViewGroup.wFa.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).height = com.tencent.mm.cb.a.ax(this.context, 2131165516);
        ((ViewGroup.LayoutParams)localObject1).width = com.tencent.mm.cb.a.ax(this.context, 2131165516);
        paramViewGroup.wFa.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        paramViewGroup.wFb = ((ImageView)paramView.findViewById(2131302695));
        paramView.setTag(paramViewGroup);
        localObject1 = (bue)NearbyFriendsUI.s(NearbyFriendsUI.this).get(paramInt);
        paramViewGroup.jeP.setText(k.b(this.context, ((bue)localObject1).nJO, paramViewGroup.jeP.getTextSize()));
        if (NearbyFriendsUI.h(NearbyFriendsUI.this) != 1) {
          break label859;
        }
        switch (((bue)localObject1).jfV)
        {
        default: 
          paramViewGroup.wFb.setVisibility(8);
          if (((bue)localObject1).Hhu != 0)
          {
            paramViewGroup.wEZ.setVisibility(0);
            localObject2 = BackwardSupportUtil.b.p(au.a.hII.ou(((bue)localObject1).Hhu), 2.0F);
            paramViewGroup.wEZ.setImageBitmap((Bitmap)localObject2);
            paramViewGroup.wFb.setVisibility(8);
            label418:
            paramViewGroup.wEX.setText(((bue)localObject1).Hht);
            paramViewGroup.wFc.setVisibility(8);
            paramViewGroup.wFd.setVisibility(8);
            paramViewGroup.wFe.setVisibility(8);
            paramViewGroup.hai.setVisibility(8);
            if ((localObject1 instanceof com.tencent.mm.plugin.nearby.a.a))
            {
              localObject2 = ((com.tencent.mm.plugin.nearby.a.a)localObject1).wDN;
              if ((localObject2 == null) || (((LinkedList)localObject2).size() != 1)) {
                break label883;
              }
              paramViewGroup.wFc.setVisibility(0);
              NearbyFriendsUI.r(paramViewGroup.wFc, (String)((LinkedList)localObject2).get(0));
              label522:
              localObject2 = (NearbyFriendsUI.a)NearbyFriendsUI.t(NearbyFriendsUI.this).get(((bue)localObject1).nIJ);
              if (localObject2 != null)
              {
                if (((NearbyFriendsUI.a)localObject2).wET != -1) {
                  break label1037;
                }
                paramInt = 0;
                label560:
                ((NearbyFriendsUI.a)localObject2).wET = paramInt;
                if (((NearbyFriendsUI.a)localObject2).wEP > 0) {
                  paramViewGroup.hai.setVisibility(0);
                }
              }
              paramViewGroup.hai.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(89859);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bd(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/nearby/ui/NearbyFriendsUI$NearbyFriendAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                  paramAnonymousView = (NearbyFriendsUI.a)NearbyFriendsUI.t(NearbyFriendsUI.this).get(this.wEV.nIJ);
                  if (paramAnonymousView != null)
                  {
                    paramAnonymousView.wES += 1;
                    paramAnonymousView.nsb = true;
                    paramAnonymousView.wET |= 0x2;
                  }
                  NearbyFriendsUI.A(NearbyFriendsUI.this);
                  NearbyFriendsUI.c.this.notifyDataSetChanged();
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearby/ui/NearbyFriendsUI$NearbyFriendAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(89859);
                }
              });
            }
            if ((((bue)localObject1).jfY != null) && (!((bue)localObject1).jfY.trim().equals(""))) {
              break label1046;
            }
            paramViewGroup.wEY.setVisibility(8);
            label633:
            if ((((bue)localObject1).HhA == null) || ((((bue)localObject1).HhA.jgg & 0x1) <= 0)) {
              break label1083;
            }
            paramViewGroup.wFa.setVisibility(0);
            label662:
            if (!NearbyFriendsUI.d.Ml(((bue)localObject1).jfV)) {
              break label1095;
            }
            paramViewGroup.jgy.setImageBitmap(null);
            localObject2 = new c.a();
            ((c.a)localObject2).prefixPath = com.tencent.mm.plugin.image.d.azQ();
            ((c.a)localObject2).igk = true;
            ((c.a)localObject2).hgL = true;
            localObject2 = ((c.a)localObject2).aJu();
            com.tencent.mm.av.q.aJb().a(((bue)localObject1).GnO, paramViewGroup.jgy, (com.tencent.mm.av.a.a.c)localObject2);
            if (bu.isNullOrNil(((bue)localObject1).jga)) {
              break label1283;
            }
            paramViewGroup.jgz.setText(((bue)localObject1).jga);
            paramViewGroup.jgz.setVisibility(0);
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
        paramViewGroup.wFb.setVisibility(0);
        paramViewGroup.wFb.setImageResource(2131690323);
        paramViewGroup.wFb.setContentDescription(this.context.getString(2131761078));
        break label365;
        paramViewGroup.wFb.setVisibility(0);
        paramViewGroup.wFb.setImageResource(2131690322);
        paramViewGroup.wFb.setContentDescription(this.context.getString(2131759044));
        break label365;
        label859:
        paramViewGroup.wFb.setVisibility(8);
        break label365;
        paramViewGroup.wEZ.setVisibility(8);
        break label418;
        label883:
        if ((localObject2 != null) && (((LinkedList)localObject2).size() == 2))
        {
          paramViewGroup.wFc.setVisibility(0);
          paramViewGroup.wFd.setVisibility(0);
          NearbyFriendsUI.r(paramViewGroup.wFc, (String)((LinkedList)localObject2).get(0));
          NearbyFriendsUI.r(paramViewGroup.wFd, (String)((LinkedList)localObject2).get(1));
          break label522;
        }
        if ((localObject2 == null) || (((LinkedList)localObject2).size() < 3)) {
          break label522;
        }
        paramViewGroup.wFc.setVisibility(0);
        paramViewGroup.wFd.setVisibility(0);
        paramViewGroup.wFe.setVisibility(0);
        NearbyFriendsUI.r(paramViewGroup.wFc, (String)((LinkedList)localObject2).get(0));
        NearbyFriendsUI.r(paramViewGroup.wFd, (String)((LinkedList)localObject2).get(1));
        NearbyFriendsUI.r(paramViewGroup.wFe, (String)((LinkedList)localObject2).get(2));
        break label522;
        label1037:
        paramInt = ((NearbyFriendsUI.a)localObject2).wET;
        break label560;
        label1046:
        paramViewGroup.wEY.setVisibility(0);
        paramViewGroup.wEY.setText(k.b(this.context, ((bue)localObject1).jfY, paramViewGroup.wEY.getTextSize()));
        break label633;
        label1083:
        paramViewGroup.wFa.setVisibility(8);
        break label662;
        label1095:
        a.b.c(paramViewGroup.jgy, ((bue)localObject1).nIJ);
        if (((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().aUH(((bue)localObject1).nIJ))
        {
          paramViewGroup.jgz.setVisibility(0);
          if (an.abz(((bue)localObject1).Hhu))
          {
            paramViewGroup.jgz.setText(NearbyFriendsUI.this.getString(2131761502));
          }
          else
          {
            an localan = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().aUK(((bue)localObject1).nIJ);
            Context localContext;
            if (localan != null)
            {
              localObject2 = paramViewGroup.jeP;
              localContext = this.context;
              if (!bu.isNullOrNil(localan.adG())) {
                break label1273;
              }
            }
            label1273:
            for (localObject1 = ((bue)localObject1).nJO;; localObject1 = localan.adG())
            {
              ((TextView)localObject2).setText(k.b(localContext, (CharSequence)localObject1, paramViewGroup.jeP.getTextSize()));
              paramViewGroup.jgz.setText(NearbyFriendsUI.this.getString(2131761507));
              break;
            }
          }
        }
        else
        {
          label1283:
          paramViewGroup.jgz.setVisibility(8);
        }
      }
    }
  }
  
  static final class d
  {
    public static int wEW = 10000;
    
    public static boolean Ml(int paramInt)
    {
      return paramInt == wEW;
    }
    
    public static bue d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    {
      AppMethodBeat.i(89865);
      com.tencent.mm.plugin.nearby.a.a locala = new com.tencent.mm.plugin.nearby.a.a();
      locala.jfV = wEW;
      locala.nIJ = paramString1;
      locala.GnO = paramString2;
      locala.Hht = paramString4;
      locala.nJO = paramString3;
      locala.jfW = paramString5;
      AppMethodBeat.o(89865);
      return locala;
    }
  }
  
  static final class e
  {
    ImageView hai;
    TextView jeP;
    ImageView jgy;
    TextView jgz;
    TextView wEX;
    TextView wEY;
    ImageView wEZ;
    ImageView wFa;
    ImageView wFb;
    ImageView wFc;
    ImageView wFd;
    ImageView wFe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI
 * JD-Core Version:    0.7.0.1
 */