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
import com.tencent.mm.al.n;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.cache.MCacheItem;
import com.tencent.mm.g.a.lb;
import com.tencent.mm.g.a.tk;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.i;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.c;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.acf;
import com.tencent.mm.protocal.protobuf.btk;
import com.tencent.mm.protocal.protobuf.dhg;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.br;
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
  implements com.tencent.mm.al.f
{
  private com.tencent.mm.modelgeo.d fFe;
  private com.tencent.mm.modelgeo.b.a fFl;
  private com.tencent.mm.sdk.b.c fFn;
  boolean hjP;
  private ListView jgA;
  private List<btk> rdK;
  private com.tencent.mm.ui.base.p tipDialog;
  private boolean vfe;
  private boolean vgd;
  private c woK;
  private com.tencent.mm.plugin.nearby.a.c woL;
  private com.tencent.mm.plugin.nearby.a.d woM;
  private Map<String, a> woN;
  private boolean woO;
  private String[] woP;
  private int woQ;
  private BindMobileOrQQHeaderView woR;
  private ViewGroup woS;
  private View woT;
  private View woU;
  private boolean woV;
  private int woW;
  private boolean woX;
  private int woY;
  private View woZ;
  private com.tencent.mm.plugin.nearby.a.c woz;
  private b wpa;
  
  public NearbyFriendsUI()
  {
    AppMethodBeat.i(89866);
    this.tipDialog = null;
    this.rdK = new LinkedList();
    this.woN = new HashMap();
    this.woO = false;
    this.woQ = 1;
    this.woV = false;
    this.woX = false;
    this.vfe = false;
    this.woY = 0;
    this.woZ = null;
    this.fFn = new com.tencent.mm.sdk.b.c() {};
    this.hjP = false;
    this.fFl = new com.tencent.mm.modelgeo.b.a()
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
        if (NearbyFriendsUI.this.hjP)
        {
          if (NearbyFriendsUI.f(NearbyFriendsUI.this) != null)
          {
            NearbyFriendsUI.f(NearbyFriendsUI.this).dismiss();
            NearbyFriendsUI.a(NearbyFriendsUI.this, null);
          }
          com.tencent.mm.plugin.report.service.f.Ol(11);
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
          com.tencent.mm.modelstat.e locale = com.tencent.mm.modelstat.e.aLE();
          if (paramAnonymousInt == 0)
          {
            paramAnonymousBoolean = false;
            if (NearbyFriendsUI.g(NearbyFriendsUI.this) != null) {
              break label264;
            }
            bool = false;
            label163:
            locale.a(2001, paramAnonymousBoolean, bool, paramAnonymousFloat1, paramAnonymousFloat2, (int)paramAnonymousDouble2);
            NearbyFriendsUI.a(NearbyFriendsUI.this, new com.tencent.mm.plugin.nearby.a.c(NearbyFriendsUI.h(NearbyFriendsUI.this), NearbyFriendsUI.i(NearbyFriendsUI.this).hXk, NearbyFriendsUI.i(NearbyFriendsUI.this).hXj, NearbyFriendsUI.i(NearbyFriendsUI.this).accuracy, paramAnonymousInt, "", ""));
            com.tencent.mm.kernel.g.aiU().a(NearbyFriendsUI.b(NearbyFriendsUI.this), 0);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(89846);
          return false;
          paramAnonymousBoolean = true;
          break;
          label264:
          bool = NearbyFriendsUI.g(NearbyFriendsUI.this).hXu;
          break label163;
          com.tencent.mm.plugin.report.service.f.Ol(11);
          if (NearbyFriendsUI.f(NearbyFriendsUI.this) != null)
          {
            NearbyFriendsUI.f(NearbyFriendsUI.this).dismiss();
            NearbyFriendsUI.a(NearbyFriendsUI.this, null);
          }
          NearbyFriendsUI.this.findViewById(2131302691).setVisibility(0);
          NearbyFriendsUI.j(NearbyFriendsUI.this).setVisibility(8);
          NearbyFriendsUI.k(NearbyFriendsUI.this);
          if ((!NearbyFriendsUI.l(NearbyFriendsUI.this)) && (!com.tencent.mm.modelgeo.d.aHR()))
          {
            NearbyFriendsUI.m(NearbyFriendsUI.this);
            h.a(NearbyFriendsUI.this, NearbyFriendsUI.this.getString(2131760082), NearbyFriendsUI.this.getString(2131755906), NearbyFriendsUI.this.getString(2131760598), NearbyFriendsUI.this.getString(2131755691), false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(89845);
                com.tencent.mm.modelgeo.d.cB(NearbyFriendsUI.this);
                AppMethodBeat.o(89845);
              }
            }, null);
          }
        }
      }
    };
    AppMethodBeat.o(89866);
  }
  
  private void dtY()
  {
    AppMethodBeat.i(89869);
    View localView;
    Object localObject;
    int i;
    if (com.tencent.mm.bq.a.eYD())
    {
      if (this.woZ != null)
      {
        this.jgA.removeHeaderView(this.woZ);
        this.woZ = null;
      }
      localView = View.inflate(this, 2131495004, null);
      localObject = (TextView)localView.findViewById(2131304292);
      com.tencent.mm.kernel.g.ajA().aiF();
      i = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlH().bUJ();
      if (i != 0) {
        break label119;
      }
      localView.setVisibility(8);
      localView = null;
    }
    for (;;)
    {
      this.woZ = localView;
      if (this.woZ != null) {
        this.jgA.addHeaderView(this.woZ);
      }
      AppMethodBeat.o(89869);
      return;
      label119:
      localView.setVisibility(0);
      ((TextView)localObject).setText(getResources().getQuantityString(2131623965, i, new Object[] { Integer.valueOf(i) }));
      localObject = (ImageView)localView.findViewById(2131302192);
      br localbr = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlH().dlS();
      if (localbr != null) {
        a.b.c((ImageView)localObject, localbr.field_sayhiuser);
      }
      localView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(89847);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/nearby/ui/NearbyFriendsUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
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
  
  private void dtZ()
  {
    AppMethodBeat.i(89871);
    com.tencent.mm.plugin.nearby.a.iRG.bB(this);
    AppMethodBeat.o(89871);
  }
  
  private void dua()
  {
    int j = 0;
    AppMethodBeat.i(89877);
    Object localObject1 = new LinkedList();
    int i = 0;
    while (i < this.rdK.size())
    {
      if (!d.LG(((btk)this.rdK.get(i)).jdc)) {
        ((List)localObject1).add(this.rdK.get(i));
      }
      i += 1;
    }
    this.rdK.clear();
    this.rdK = ((List)localObject1);
    ad.i("MicroMsg.NearbyFriend", "insertPoiItemList()");
    label133:
    Object localObject2;
    List localList;
    if (!this.rdK.isEmpty())
    {
      i = 1;
      localObject1 = this.woN.keySet().iterator();
      do
      {
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (String)((Iterator)localObject1).next();
        } while (i == 0);
        localObject2 = (a)this.woN.get(localObject2);
      } while ((((a)localObject2).nmR) || ((((a)localObject2).wpg > 0) && (((a)localObject2).wpj >= ((a)localObject2).wpg)) || (((a)localObject2).oIZ >= ((a)localObject2).wph));
      localList = this.rdK;
      if ((((a)localObject2).pos >= 0) && (((a)localObject2).pos <= this.rdK.size())) {
        break label306;
      }
    }
    label306:
    for (int k = this.rdK.size();; k = ((a)localObject2).pos + j)
    {
      localList.add(k, d.d(((a)localObject2).id, ((a)localObject2).dDH, ((a)localObject2).name, ((a)localObject2).desc, ((a)localObject2).wpi));
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
    this.vfe = false;
    AppCompatActivity localAppCompatActivity = getContext();
    getString(2131755906);
    this.tipDialog = h.b(localAppCompatActivity, getString(2131761509), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(89844);
        NearbyFriendsUI.this.hjP = true;
        com.tencent.mm.plugin.report.service.f.Ol(11);
        if (NearbyFriendsUI.b(NearbyFriendsUI.this) != null) {
          com.tencent.mm.kernel.g.aiU().a(NearbyFriendsUI.b(NearbyFriendsUI.this));
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
    this.hjP = false;
    if (this.fFe != null) {
      this.fFe.a(this.fFl, true);
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
    this.jgA = ((ListView)findViewById(2131302692));
    this.woK = new c(this);
    Object localObject = this.jgA;
    if (this.woS == null)
    {
      this.woS = new LinearLayout(this);
      this.woS.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      ((LinearLayout)this.woS).setGravity(17);
    }
    this.woV = true;
    ((ListView)localObject).addHeaderView(this.woS);
    localObject = com.tencent.mm.n.g.acA().getValue("LBSShowBindPhone");
    if ((localObject != null) && (((String)localObject).length() > 0)) {}
    try
    {
      this.woW = Integer.valueOf((String)localObject).intValue();
      localObject = (String)com.tencent.mm.kernel.g.ajC().ajl().get(6, null);
      if ((localObject != null) && (((String)localObject).length() > 0)) {
        this.woW = 0;
      }
      this.woY = 0;
      if (com.tencent.mm.model.a.g.aCR().BE("3") != null)
      {
        localObject = com.tencent.mm.model.a.g.aCR().BE("3").value;
        locala = com.tencent.mm.plugin.account.friend.a.l.aSO();
        if (((String)localObject).equals("0")) {
          this.woY = 0;
        }
      }
      else
      {
        if (((this.woW > 0) || (this.woY > 0)) && (this.woY != 1))
        {
          this.woR = new BindMobileOrQQHeaderView(this);
          this.jgA.addHeaderView(this.woR);
        }
        this.jgA.setAdapter(this.woK);
        this.jgA.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(89848);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousAdapterView);
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            ((com.tencent.mm.hellhoundlib.b.b)localObject).mr(paramAnonymousInt);
            ((com.tencent.mm.hellhoundlib.b.b)localObject).qY(paramAnonymousLong);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/nearby/ui/NearbyFriendsUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
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
            if (com.tencent.mm.bq.a.eYD())
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
            paramAnonymousAdapterView = (btk)NearbyFriendsUI.s(NearbyFriendsUI.this).get(i);
            if (NearbyFriendsUI.d.LG(paramAnonymousAdapterView.jdc))
            {
              paramAnonymousAdapterView = (NearbyFriendsUI.a)NearbyFriendsUI.t(NearbyFriendsUI.this).get(paramAnonymousAdapterView.nDo);
              paramAnonymousAdapterView.wpk |= 0x1;
              if (paramAnonymousAdapterView.uxt == 1)
              {
                paramAnonymousView = new AppBrandStatObject();
                paramAnonymousView.scene = 1134;
                ((o)com.tencent.mm.kernel.g.ab(o.class)).a(NearbyFriendsUI.this, paramAnonymousAdapterView.wpi, "", 0, 0, "", paramAnonymousView);
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearby/ui/NearbyFriendsUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(89848);
                return;
                if (paramAnonymousAdapterView.uxt == 2)
                {
                  paramAnonymousView = new Intent();
                  paramAnonymousView.putExtra("rawUrl", paramAnonymousAdapterView.wpi);
                  paramAnonymousView.putExtra("geta8key_scene", 25);
                  paramAnonymousView.putExtra("stastic_scene", 12);
                  com.tencent.mm.bs.d.b(NearbyFriendsUI.this.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
                }
              }
            }
            paramAnonymousView = paramAnonymousAdapterView.nDo;
            am localam = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(paramAnonymousView);
            if (com.tencent.mm.o.b.lM(localam.field_type))
            {
              localObject = new Intent();
              ((Intent)localObject).putExtra("Contact_User", paramAnonymousView);
              ((Intent)localObject).putExtra("Contact_Scene", 18);
              ((Intent)localObject).putExtra("Sns_from_Scene", 18);
              ((Intent)localObject).putExtra("lbs_ticket", paramAnonymousAdapterView.Guj);
              ((Intent)localObject).putExtra("Contact_IsLbsGotoChatting", true);
              if ((paramAnonymousView != null) && (paramAnonymousView.length() > 0))
              {
                if (localam.fqg()) {
                  com.tencent.mm.plugin.report.service.g.yhR.kvStat(10298, paramAnonymousView + ",18");
                }
                paramAnonymousAdapterView = new tk();
                paramAnonymousAdapterView.dHR.intent = ((Intent)localObject);
                paramAnonymousAdapterView.dHR.username = paramAnonymousView;
                com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousAdapterView);
                ((Intent)localObject).putExtra("CONTACT_INFO_UI_SOURCE", 5);
                com.tencent.mm.plugin.nearby.a.iRG.c((Intent)localObject, NearbyFriendsUI.this);
              }
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearby/ui/NearbyFriendsUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(89848);
              return;
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView.nDo);
              paramAnonymousView.putExtra("Contact_Alias", paramAnonymousAdapterView.jdh);
              paramAnonymousView.putExtra("Contact_Nick", paramAnonymousAdapterView.nEt);
              paramAnonymousView.putExtra("Contact_Distance", paramAnonymousAdapterView.GNT);
              paramAnonymousView.putExtra("Contact_Signature", paramAnonymousAdapterView.jdf);
              paramAnonymousView.putExtra("Contact_RegionCode", RegionCodeDecoder.bf(paramAnonymousAdapterView.jdl, paramAnonymousAdapterView.jdd, paramAnonymousAdapterView.jde));
              paramAnonymousView.putExtra("Contact_Sex", paramAnonymousAdapterView.jdc);
              paramAnonymousView.putExtra("Contact_IsLBSFriend", true);
              paramAnonymousView.putExtra("Contact_Scene", 18);
              paramAnonymousView.putExtra("Contact_VUser_Info", paramAnonymousAdapterView.GNV);
              paramAnonymousView.putExtra("Contact_VUser_Info_Flag", paramAnonymousAdapterView.GNU);
              paramAnonymousView.putExtra("Contact_KWeibo_flag", paramAnonymousAdapterView.GNY);
              paramAnonymousView.putExtra("Contact_KWeibo", paramAnonymousAdapterView.GNW);
              paramAnonymousView.putExtra("Contact_KWeiboNick", paramAnonymousAdapterView.GNX);
              paramAnonymousView.putExtra("Contact_KSnsIFlag", paramAnonymousAdapterView.GOa.jdn);
              paramAnonymousView.putExtra("Contact_KSnsBgId", paramAnonymousAdapterView.GOa.jdp);
              paramAnonymousView.putExtra("Contact_KSnsBgUrl", paramAnonymousAdapterView.GOa.jdo);
              paramAnonymousView.putExtra("lbs_ticket", paramAnonymousAdapterView.Guj);
              paramAnonymousView.putExtra("Contact_IsLbsGotoChatting", true);
              if (paramAnonymousAdapterView.jdm != null)
              {
                localObject = new com.tencent.mm.api.c();
                ((com.tencent.mm.api.c)localObject).field_brandList = paramAnonymousAdapterView.jdm;
                ((com.tencent.mm.api.c)localObject).field_brandFlag = paramAnonymousAdapterView.GOb.jdq;
                ((com.tencent.mm.api.c)localObject).field_brandIconURL = paramAnonymousAdapterView.GOb.jdt;
                ((com.tencent.mm.api.c)localObject).field_extInfo = paramAnonymousAdapterView.GOb.jdr;
                ((com.tencent.mm.api.c)localObject).field_brandInfo = paramAnonymousAdapterView.GOb.jds;
                paramAnonymousView.putExtra("KBrandInfo_item", new MCacheItem((com.tencent.mm.sdk.e.c)localObject));
              }
              paramAnonymousView.putExtra("Sns_from_Scene", 18);
              paramAnonymousView.putExtra("CONTACT_INFO_UI_SOURCE", 5);
              com.tencent.mm.plugin.nearby.a.iRG.c(paramAnonymousView, NearbyFriendsUI.this);
            }
          }
        });
        this.jgA.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(89849);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            localb.bd(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/nearby/ui/NearbyFriendsUI$6", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
            if (NearbyFriendsUI.u(NearbyFriendsUI.this) != null)
            {
              paramAnonymousView = NearbyFriendsUI.u(NearbyFriendsUI.this);
              if (paramAnonymousView.jdB != null) {
                paramAnonymousView.jdB.onTouchEvent(paramAnonymousMotionEvent);
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
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/nearby/ui/NearbyFriendsUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
            paramAnonymousView = NearbyFriendsUI.j(NearbyFriendsUI.this);
            paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
            localObject = new Object();
            com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.ahp(), "com/tencent/mm/plugin/nearby/ui/NearbyFriendsUI$8", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
            BackwardSupportUtil.c.b((ListView)paramAnonymousView.mq(0));
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
            paramAnonymousMenuItem.KJz = new n.e()
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
                  com.tencent.mm.kernel.g.ajC().ajl().set(16386, Integer.valueOf(NearbyFriendsUI.h(NearbyFriendsUI.this)));
                  NearbyFriendsUI.w(NearbyFriendsUI.this);
                  AppMethodBeat.o(89853);
                  return;
                  NearbyFriendsUI.a(NearbyFriendsUI.this, 3);
                  NearbyFriendsUI.v(NearbyFriendsUI.this);
                  com.tencent.mm.kernel.g.ajC().ajl().set(16386, Integer.valueOf(NearbyFriendsUI.h(NearbyFriendsUI.this)));
                  NearbyFriendsUI.w(NearbyFriendsUI.this);
                  AppMethodBeat.o(89853);
                  return;
                  NearbyFriendsUI.a(NearbyFriendsUI.this, 1);
                  NearbyFriendsUI.v(NearbyFriendsUI.this);
                  com.tencent.mm.kernel.g.ajC().ajl().set(16386, Integer.valueOf(NearbyFriendsUI.h(NearbyFriendsUI.this)));
                  NearbyFriendsUI.w(NearbyFriendsUI.this);
                  AppMethodBeat.o(89853);
                  return;
                  paramAnonymous2MenuItem = new Intent(NearbyFriendsUI.this, NearbySayHiListUI.class);
                  paramAnonymous2MenuItem.putExtra("k_say_hi_type", 2);
                  NearbyFriendsUI.this.startActivityForResult(paramAnonymous2MenuItem, 2009);
                  AppMethodBeat.o(89853);
                  return;
                  NearbyFriendsUI.b(NearbyFriendsUI.this, new com.tencent.mm.plugin.nearby.a.c(2, 0.0F, 0.0F, 0, 0, "", ""));
                  com.tencent.mm.kernel.g.aiU().a(NearbyFriendsUI.x(NearbyFriendsUI.this), 0);
                  paramAnonymous2MenuItem = NearbyFriendsUI.this;
                  AppCompatActivity localAppCompatActivity = NearbyFriendsUI.this.getContext();
                  NearbyFriendsUI.this.getString(2131755906);
                  NearbyFriendsUI.a(paramAnonymous2MenuItem, h.b(localAppCompatActivity, NearbyFriendsUI.this.getString(2131761498), true, new DialogInterface.OnCancelListener()
                  {
                    public final void onCancel(DialogInterface paramAnonymous3DialogInterface)
                    {
                      AppMethodBeat.i(89852);
                      com.tencent.mm.kernel.g.aiU().a(NearbyFriendsUI.x(NearbyFriendsUI.this));
                      AppMethodBeat.o(89852);
                    }
                  }));
                }
              }
            };
            paramAnonymousMenuItem.KJy = new n.d()
            {
              public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
              {
                AppMethodBeat.i(89854);
                paramAnonymous2l.jI(-1, 2131761512);
                paramAnonymous2l.jI(-1, 2131761511);
                paramAnonymous2l.jI(-1, 2131761510);
                paramAnonymous2l.jI(-1, 2131762789);
                paramAnonymous2l.jI(-1, 2131761494);
                AppMethodBeat.o(89854);
              }
            };
            paramAnonymousMenuItem.cMW();
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
        this.woW = 0;
        continue;
        if (localException.equals("2"))
        {
          if (locala == l.a.jdP)
          {
            this.woY = 2;
            com.tencent.mm.model.a.f.BI("3");
          }
        }
        else if ((localException.equals("1")) && (locala == l.a.jdM))
        {
          this.woY = 2;
          com.tencent.mm.model.a.f.BI("3");
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
        this.woO = false;
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
    com.tencent.mm.plugin.report.service.f.Oj(11);
    super.onCreate(paramBundle);
    setMMTitle(2131761520);
    com.tencent.mm.kernel.g.aiU().a(148, this);
    com.tencent.mm.kernel.g.aiU().a(376, this);
    com.tencent.mm.kernel.g.aiU().a(1087, this);
    this.fFe = com.tencent.mm.modelgeo.d.aHQ();
    initView();
    this.woP = new String[] { getResources().getString(2131761512), getResources().getString(2131761511), getResources().getString(2131761510), getResources().getString(2131762789) };
    this.woQ = bt.a((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(16386, null), 1);
    Object localObject1;
    int j;
    int i;
    label231:
    Object localObject2;
    if (this.woQ == 3)
    {
      setTitleLogo(0, 2131690323);
      getData();
      if (!ac.fkp()) {
        break label796;
      }
      localObject1 = bw.M(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qzw, ""), "lbsads");
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
      ((a)localObject2).wpg = bt.getInt((String)((Map)localObject1).get(paramBundle + ".$close_times"), 0);
      ((a)localObject2).wph = bt.getInt((String)((Map)localObject1).get(paramBundle + ".$show_times"), 2147483647);
      ((a)localObject2).name = ((String)((Map)localObject1).get(paramBundle + ".name"));
      ((a)localObject2).desc = ((String)((Map)localObject1).get(paramBundle + ".desc"));
      ((a)localObject2).dDH = ((String)((Map)localObject1).get(paramBundle + ".icon"));
      ((a)localObject2).uxt = bt.getInt((String)((Map)localObject1).get(paramBundle + ".jump.$type"), 0);
      ((a)localObject2).wpi = ((String)((Map)localObject1).get(paramBundle + ".jump"));
      this.woN.put(((a)localObject2).id, localObject2);
      i += 1;
      break label231;
      if (this.woQ == 4)
      {
        setTitleLogo(0, 2131690322);
        break;
      }
      setTitleLogo(0, 0);
      this.woQ = 1;
      break;
    }
    label674:
    paramBundle = com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IFY, null);
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
          localObject2 = (a)this.woN.get(localObject1[0]);
          if (localObject2 != null)
          {
            ((a)localObject2).wpj = bt.getInt(localObject1[1], 0);
            ((a)localObject2).oIZ = bt.getInt(localObject1[2], 0);
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
    if (this.woY > 0) {
      com.tencent.mm.model.a.f.BJ("3");
    }
    com.tencent.mm.plugin.report.service.f.Ol(11);
    com.tencent.mm.kernel.g.aiU().b(148, this);
    com.tencent.mm.kernel.g.aiU().b(376, this);
    com.tencent.mm.kernel.g.aiU().b(1087, this);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if (this.fFe != null) {
      this.fFe.c(this.fFl);
    }
    com.tencent.mm.ak.p.aEz().cancel();
    Object localObject;
    if (this.woK != null)
    {
      localObject = this.woK;
      if (((c)localObject).jdB != null)
      {
        ((c)localObject).jdB.detach();
        ((c)localObject).jdB = null;
      }
    }
    if (this.rdK.size() > 0)
    {
      Iterator localIterator = this.woN.values().iterator();
      localObject = "";
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        localObject = new StringBuilder().append((String)localObject).append("|").append(locala.id).append(":").append(locala.wpj).append(":");
        int i = locala.oIZ + 1;
        locala.oIZ = i;
        localObject = i;
        com.tencent.mm.plugin.report.service.g.yhR.f(17431, new Object[] { locala.id, Integer.valueOf(locala.wpk + 1) });
      }
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IFY, localObject);
    }
    super.onDestroy();
    AppMethodBeat.o(89875);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(89873);
    super.onPause();
    if (this.fFe != null) {
      this.fFe.c(this.fFl);
    }
    com.tencent.mm.sdk.b.a.IbL.d(this.fFn);
    AppMethodBeat.o(89873);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(89874);
    super.onResume();
    if (this.fFe != null) {
      this.fFe.a(this.fFl, true);
    }
    dtY();
    this.woK.notifyDataSetChanged();
    com.tencent.mm.kernel.g.ajA().aiF();
    if (((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlH().bUJ() == 0) {
      this.jgA.removeHeaderView(this.woU);
    }
    com.tencent.mm.sdk.b.a.IbL.c(this.fFn);
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
      int i = ((com.tencent.mm.plugin.nearby.a.c)paramn).KR();
      if ((this.woL == null) && ((i == 1) || (i == 3) || (i == 4)))
      {
        AppMethodBeat.o(89876);
        return;
      }
      if (((i == 1) || (i == 3) || (i == 4)) && (this.woO))
      {
        ad.v("MicroMsg.NearbyFriend", "onSceneEnd data already requested, code=%d", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(89876);
        return;
      }
      if ((this.woz == null) && (i == 2))
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
          this.rdK = ((com.tencent.mm.plugin.nearby.a.c)paramn).dtV();
          if ((this.rdK == null) || (this.rdK.size() == 0))
          {
            findViewById(2131302694).setVisibility(0);
            this.jgA.setVisibility(8);
            dtZ();
            com.tencent.mm.plugin.report.service.f.Ol(11);
            if (this.woQ != 3) {
              break label767;
            }
            setTitleLogo(0, 2131690323);
            this.woO = true;
            this.woL = null;
          }
        }
        else
        {
          if (((com.tencent.mm.plugin.nearby.a.c)paramn).KR() == 2)
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
            this.woz = null;
          }
          if (!((com.tencent.mm.plugin.nearby.a.c)paramn).dtT()) {
            break label811;
          }
          paramString = getString(2131761523);
          paramInt1 = ((com.tencent.mm.plugin.nearby.a.c)paramn).dtU();
          if (this.woS != null)
          {
            if (this.woT != null) {
              break label800;
            }
            this.woT = View.inflate(this, 2131495005, null);
            this.woS.addView(this.woT);
            this.woT.setOnClickListener(new NearbyFriendsUI.2(this));
            ((TextView)this.woT.findViewById(2131302700)).setText(paramString);
            if (paramInt1 != 0) {
              ((TextView)this.woT.findViewById(2131302699)).setText(String.format(getResources().getQuantityString(2131623958, paramInt1, new Object[] { Integer.valueOf(paramInt1) }), new Object[0]));
            }
          }
        }
        for (;;)
        {
          this.woX = true;
          AppMethodBeat.o(89876);
          return;
          paramString = new LinkedList();
          localObject = this.rdK.iterator();
          paramInt1 = 0;
          while (((Iterator)localObject).hasNext())
          {
            btk localbtk = (btk)((Iterator)localObject).next();
            if (((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().aTg(localbtk.nDo))
            {
              paramString.add(paramInt1, localbtk);
              paramInt1 += 1;
            }
            else if ((!bt.isNullOrNil(localbtk.nDo)) && (!bt.isNullOrNil(localbtk.GNT)))
            {
              paramString.add(localbtk);
            }
          }
          this.rdK.clear();
          this.rdK = paramString;
          if ((this.rdK == null) || (this.rdK.size() == 0))
          {
            findViewById(2131302694).setVisibility(0);
            this.jgA.setVisibility(8);
            break;
          }
          findViewById(2131302694).setVisibility(8);
          dua();
          this.woK.notifyDataSetChanged();
          if (this.woK.getCount() > 0) {
            this.jgA.setSelection(0);
          }
          this.jgA.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(89842);
              com.tencent.mm.plugin.report.service.f.Ok(11);
              AppMethodBeat.o(89842);
            }
          });
          break;
          label767:
          if (this.woQ == 4)
          {
            setTitleLogo(0, 2131690322);
            break label321;
          }
          setTitleLogo(0, 0);
          this.woQ = 1;
          break label321;
          label800:
          this.woT.setVisibility(0);
          break label454;
          label811:
          if ((this.woT != null) && (this.woS != null)) {
            this.woT.setVisibility(8);
          }
        }
      }
      if ((i == 1) || (i == 3) || (i == 4))
      {
        localObject = (TextView)findViewById(2131302694);
        ((TextView)localObject).setVisibility(0);
        dtZ();
        if ((paramString == null) || (paramString.length() <= 0)) {
          break label1165;
        }
      }
    }
    label1165:
    for (paramString = com.tencent.mm.h.a.uz(paramString);; paramString = null)
    {
      if ((paramString != null) && (paramString.desc != null) && (paramString.desc.length() > 0)) {
        ((TextView)localObject).setText(paramString.desc);
      }
      for (;;)
      {
        this.jgA.setVisibility(8);
        this.woL = null;
        if (((com.tencent.mm.plugin.nearby.a.c)paramn).KR() == 2)
        {
          Toast.makeText(this, 2131761496, 1).show();
          this.woz = null;
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
        if (((com.tencent.mm.plugin.nearby.a.d)paramn).KR() != 1)
        {
          AppMethodBeat.o(89876);
          return;
        }
        if (this.tipDialog != null)
        {
          this.tipDialog.dismiss();
          this.tipDialog = null;
        }
        if ((paramInt1 == 0) && (paramInt2 == 0) && (((com.tencent.mm.plugin.nearby.a.d)paramn).iHB != null))
        {
          paramString = ((com.tencent.mm.plugin.nearby.a.d)paramn).iHB;
          com.tencent.mm.plugin.nearby.a.b.il(paramString, ((com.tencent.mm.plugin.nearby.a.d)paramn).woh);
          paramn = new Intent();
          paramn.putExtra("Chat_User", paramString);
          com.tencent.mm.plugin.nearby.a.iRG.e(paramn, this);
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
    String dDH;
    String desc;
    String id;
    String name;
    boolean nmR = false;
    int oIZ;
    int pos;
    int uxt;
    int wpg;
    int wph;
    String wpi;
    int wpj;
    int wpk = -1;
  }
  
  final class b
  {
    public int accuracy;
    public float hXj;
    public float hXk;
    
    public b(float paramFloat1, float paramFloat2, int paramInt)
    {
      this.hXj = paramFloat1;
      this.hXk = paramFloat2;
      this.accuracy = paramInt;
    }
  }
  
  final class c
    extends BaseAdapter
  {
    private final Context context;
    com.tencent.mm.ui.applet.b jdB;
    private b.b jdC;
    
    public c(Context paramContext)
    {
      AppMethodBeat.i(89860);
      this.jdB = new com.tencent.mm.ui.applet.b(new com.tencent.mm.ui.applet.b.a()
      {
        public final Bitmap JD(String paramAnonymousString)
        {
          AppMethodBeat.i(89856);
          paramAnonymousString = com.tencent.mm.ak.c.a(paramAnonymousString, false, -1, null);
          AppMethodBeat.o(89856);
          return paramAnonymousString;
        }
      });
      this.jdC = null;
      this.context = paramContext;
      AppMethodBeat.o(89860);
    }
    
    public final btk LF(int paramInt)
    {
      AppMethodBeat.i(89863);
      btk localbtk = (btk)NearbyFriendsUI.s(NearbyFriendsUI.this).get(paramInt);
      AppMethodBeat.o(89863);
      return localbtk;
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
      if (this.jdC == null) {
        this.jdC = new b.b()
        {
          public final int aSL()
          {
            AppMethodBeat.i(89858);
            int i = NearbyFriendsUI.c.this.getCount();
            AppMethodBeat.o(89858);
            return i;
          }
          
          public final String rn(int paramAnonymousInt)
          {
            AppMethodBeat.i(89857);
            if ((paramAnonymousInt < 0) || (paramAnonymousInt >= NearbyFriendsUI.c.this.getCount()))
            {
              ad.e("MicroMsg.NearbyFriend", "pos is invalid");
              AppMethodBeat.o(89857);
              return null;
            }
            Object localObject = NearbyFriendsUI.c.this.LF(paramAnonymousInt);
            if (localObject == null)
            {
              AppMethodBeat.o(89857);
              return null;
            }
            localObject = ((btk)localObject).nDo;
            AppMethodBeat.o(89857);
            return localObject;
          }
        };
      }
      if (this.jdB != null) {
        this.jdB.a(paramInt, this.jdC);
      }
      Object localObject1;
      label365:
      Object localObject2;
      if (paramView == null)
      {
        paramViewGroup = new NearbyFriendsUI.e();
        paramView = View.inflate(this.context, 2131495002, null);
        paramViewGroup.jbW = ((TextView)paramView.findViewById(2131302693));
        paramViewGroup.wpp = ((TextView)paramView.findViewById(2131302696));
        paramViewGroup.wpo = ((TextView)paramView.findViewById(2131302688));
        paramViewGroup.jdF = ((ImageView)paramView.findViewById(2131302687));
        paramViewGroup.jdG = ((TextView)paramView.findViewById(2131302690));
        paramViewGroup.wpq = ((ImageView)paramView.findViewById(2131302698));
        paramViewGroup.wpr = ((ImageView)paramView.findViewById(2131302697));
        paramViewGroup.wpt = ((ImageView)paramView.findViewById(2131302684));
        paramViewGroup.wpu = ((ImageView)paramView.findViewById(2131302685));
        paramViewGroup.wpv = ((ImageView)paramView.findViewById(2131302686));
        paramViewGroup.gXw = ((ImageView)paramView.findViewById(2131298364));
        localObject1 = paramViewGroup.wpr.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).height = com.tencent.mm.cc.a.ax(this.context, 2131165516);
        ((ViewGroup.LayoutParams)localObject1).width = com.tencent.mm.cc.a.ax(this.context, 2131165516);
        paramViewGroup.wpr.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        paramViewGroup.wps = ((ImageView)paramView.findViewById(2131302695));
        paramView.setTag(paramViewGroup);
        localObject1 = (btk)NearbyFriendsUI.s(NearbyFriendsUI.this).get(paramInt);
        paramViewGroup.jbW.setText(k.b(this.context, ((btk)localObject1).nEt, paramViewGroup.jbW.getTextSize()));
        if (NearbyFriendsUI.h(NearbyFriendsUI.this) != 1) {
          break label859;
        }
        switch (((btk)localObject1).jdc)
        {
        default: 
          paramViewGroup.wps.setVisibility(8);
          if (((btk)localObject1).GNU != 0)
          {
            paramViewGroup.wpq.setVisibility(0);
            localObject2 = BackwardSupportUtil.b.o(as.a.hFQ.or(((btk)localObject1).GNU), 2.0F);
            paramViewGroup.wpq.setImageBitmap((Bitmap)localObject2);
            paramViewGroup.wps.setVisibility(8);
            label418:
            paramViewGroup.wpo.setText(((btk)localObject1).GNT);
            paramViewGroup.wpt.setVisibility(8);
            paramViewGroup.wpu.setVisibility(8);
            paramViewGroup.wpv.setVisibility(8);
            paramViewGroup.gXw.setVisibility(8);
            if ((localObject1 instanceof com.tencent.mm.plugin.nearby.a.a))
            {
              localObject2 = ((com.tencent.mm.plugin.nearby.a.a)localObject1).woe;
              if ((localObject2 == null) || (((LinkedList)localObject2).size() != 1)) {
                break label883;
              }
              paramViewGroup.wpt.setVisibility(0);
              NearbyFriendsUI.r(paramViewGroup.wpt, (String)((LinkedList)localObject2).get(0));
              label522:
              localObject2 = (NearbyFriendsUI.a)NearbyFriendsUI.t(NearbyFriendsUI.this).get(((btk)localObject1).nDo);
              if (localObject2 != null)
              {
                if (((NearbyFriendsUI.a)localObject2).wpk != -1) {
                  break label1037;
                }
                paramInt = 0;
                label560:
                ((NearbyFriendsUI.a)localObject2).wpk = paramInt;
                if (((NearbyFriendsUI.a)localObject2).wpg > 0) {
                  paramViewGroup.gXw.setVisibility(0);
                }
              }
              paramViewGroup.gXw.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(89859);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bd(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/nearby/ui/NearbyFriendsUI$NearbyFriendAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                  paramAnonymousView = (NearbyFriendsUI.a)NearbyFriendsUI.t(NearbyFriendsUI.this).get(this.wpm.nDo);
                  if (paramAnonymousView != null)
                  {
                    paramAnonymousView.wpj += 1;
                    paramAnonymousView.nmR = true;
                    paramAnonymousView.wpk |= 0x2;
                  }
                  NearbyFriendsUI.A(NearbyFriendsUI.this);
                  NearbyFriendsUI.c.this.notifyDataSetChanged();
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearby/ui/NearbyFriendsUI$NearbyFriendAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(89859);
                }
              });
            }
            if ((((btk)localObject1).jdf != null) && (!((btk)localObject1).jdf.trim().equals(""))) {
              break label1046;
            }
            paramViewGroup.wpp.setVisibility(8);
            label633:
            if ((((btk)localObject1).GOa == null) || ((((btk)localObject1).GOa.jdn & 0x1) <= 0)) {
              break label1083;
            }
            paramViewGroup.wpr.setVisibility(0);
            label662:
            if (!NearbyFriendsUI.d.LG(((btk)localObject1).jdc)) {
              break label1095;
            }
            paramViewGroup.jdF.setImageBitmap(null);
            localObject2 = new c.a();
            ((c.a)localObject2).prefixPath = com.tencent.mm.plugin.image.d.azA();
            ((c.a)localObject2).idr = true;
            ((c.a)localObject2).hdX = true;
            localObject2 = ((c.a)localObject2).aJc();
            com.tencent.mm.aw.q.aIJ().a(((btk)localObject1).FVp, paramViewGroup.jdF, (com.tencent.mm.aw.a.a.c)localObject2);
            if (bt.isNullOrNil(((btk)localObject1).jdh)) {
              break label1283;
            }
            paramViewGroup.jdG.setText(((btk)localObject1).jdh);
            paramViewGroup.jdG.setVisibility(0);
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
        paramViewGroup.wps.setVisibility(0);
        paramViewGroup.wps.setImageResource(2131690323);
        paramViewGroup.wps.setContentDescription(this.context.getString(2131761078));
        break label365;
        paramViewGroup.wps.setVisibility(0);
        paramViewGroup.wps.setImageResource(2131690322);
        paramViewGroup.wps.setContentDescription(this.context.getString(2131759044));
        break label365;
        label859:
        paramViewGroup.wps.setVisibility(8);
        break label365;
        paramViewGroup.wpq.setVisibility(8);
        break label418;
        label883:
        if ((localObject2 != null) && (((LinkedList)localObject2).size() == 2))
        {
          paramViewGroup.wpt.setVisibility(0);
          paramViewGroup.wpu.setVisibility(0);
          NearbyFriendsUI.r(paramViewGroup.wpt, (String)((LinkedList)localObject2).get(0));
          NearbyFriendsUI.r(paramViewGroup.wpu, (String)((LinkedList)localObject2).get(1));
          break label522;
        }
        if ((localObject2 == null) || (((LinkedList)localObject2).size() < 3)) {
          break label522;
        }
        paramViewGroup.wpt.setVisibility(0);
        paramViewGroup.wpu.setVisibility(0);
        paramViewGroup.wpv.setVisibility(0);
        NearbyFriendsUI.r(paramViewGroup.wpt, (String)((LinkedList)localObject2).get(0));
        NearbyFriendsUI.r(paramViewGroup.wpu, (String)((LinkedList)localObject2).get(1));
        NearbyFriendsUI.r(paramViewGroup.wpv, (String)((LinkedList)localObject2).get(2));
        break label522;
        label1037:
        paramInt = ((NearbyFriendsUI.a)localObject2).wpk;
        break label560;
        label1046:
        paramViewGroup.wpp.setVisibility(0);
        paramViewGroup.wpp.setText(k.b(this.context, ((btk)localObject1).jdf, paramViewGroup.wpp.getTextSize()));
        break label633;
        label1083:
        paramViewGroup.wpr.setVisibility(8);
        break label662;
        label1095:
        a.b.c(paramViewGroup.jdF, ((btk)localObject1).nDo);
        if (((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().aTg(((btk)localObject1).nDo))
        {
          paramViewGroup.jdG.setVisibility(0);
          if (am.aaR(((btk)localObject1).GNU))
          {
            paramViewGroup.jdG.setText(NearbyFriendsUI.this.getString(2131761502));
          }
          else
          {
            am localam = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().aTj(((btk)localObject1).nDo);
            Context localContext;
            if (localam != null)
            {
              localObject2 = paramViewGroup.jbW;
              localContext = this.context;
              if (!bt.isNullOrNil(localam.adv())) {
                break label1273;
              }
            }
            label1273:
            for (localObject1 = ((btk)localObject1).nEt;; localObject1 = localam.adv())
            {
              ((TextView)localObject2).setText(k.b(localContext, (CharSequence)localObject1, paramViewGroup.jbW.getTextSize()));
              paramViewGroup.jdG.setText(NearbyFriendsUI.this.getString(2131761507));
              break;
            }
          }
        }
        else
        {
          label1283:
          paramViewGroup.jdG.setVisibility(8);
        }
      }
    }
  }
  
  static final class d
  {
    public static int wpn = 10000;
    
    public static boolean LG(int paramInt)
    {
      return paramInt == wpn;
    }
    
    public static btk d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    {
      AppMethodBeat.i(89865);
      com.tencent.mm.plugin.nearby.a.a locala = new com.tencent.mm.plugin.nearby.a.a();
      locala.jdc = wpn;
      locala.nDo = paramString1;
      locala.FVp = paramString2;
      locala.GNT = paramString4;
      locala.nEt = paramString3;
      locala.jdd = paramString5;
      AppMethodBeat.o(89865);
      return locala;
    }
  }
  
  static final class e
  {
    ImageView gXw;
    TextView jbW;
    ImageView jdF;
    TextView jdG;
    TextView wpo;
    TextView wpp;
    ImageView wpq;
    ImageView wpr;
    ImageView wps;
    ImageView wpt;
    ImageView wpu;
    ImageView wpv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI
 * JD-Core Version:    0.7.0.1
 */