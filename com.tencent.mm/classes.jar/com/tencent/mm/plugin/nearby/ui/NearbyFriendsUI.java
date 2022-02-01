package com.tencent.mm.plugin.nearby.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
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
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.np;
import com.tencent.mm.autogen.a.xc;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.cache.MCacheItem;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.c;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.account.friend.model.i.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.nearby.b.c;
import com.tencent.mm.plugin.nearby.b.d;
import com.tencent.mm.plugin.nearby.b.e;
import com.tencent.mm.plugin.nearby.b.f;
import com.tencent.mm.plugin.nearby.b.g;
import com.tencent.mm.plugin.report.service.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.ahl;
import com.tencent.mm.protocal.protobuf.dgy;
import com.tencent.mm.protocal.protobuf.ffs;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.SmoothScrollFactory;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.bz;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.base.w;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@com.tencent.mm.kernel.k
public class NearbyFriendsUI
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private Map<String, a> EOP;
  private ViewGroup EOX;
  private View EOZ;
  private View EPa;
  private boolean EPc;
  private int EPd;
  private int EPf;
  private boolean EPg;
  private boolean EPh;
  private int EPi;
  private boolean EPk;
  private com.tencent.mm.plugin.nearby.model.c MoS;
  private c Mpd;
  private com.tencent.mm.plugin.nearby.model.c Mpe;
  private com.tencent.mm.plugin.nearby.model.d Mpf;
  private boolean Mpg;
  private String[] Mph;
  private BindMobileOrQQHeaderView Mpi;
  private View Mpj;
  private b Mpk;
  private com.tencent.mm.modelgeo.b.a lsF;
  private IListener lsH;
  private com.tencent.mm.modelgeo.d lsy;
  boolean nzW;
  private ListView pVC;
  private w tipDialog;
  private List<dgy> zPw;
  
  public NearbyFriendsUI()
  {
    AppMethodBeat.i(89866);
    this.tipDialog = null;
    this.zPw = new LinkedList();
    this.EOP = new HashMap();
    this.Mpg = false;
    this.EPf = 1;
    this.EPc = false;
    this.EPg = false;
    this.EPh = false;
    this.EPi = 0;
    this.EOZ = null;
    this.lsH = new IListener(com.tencent.mm.app.f.hfK) {};
    this.nzW = false;
    this.lsF = new com.tencent.mm.modelgeo.b.a()
    {
      public final boolean onGetLocation(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2, double paramAnonymousDouble3)
      {
        AppMethodBeat.i(262793);
        if (NearbyFriendsUI.d(NearbyFriendsUI.this))
        {
          AppMethodBeat.o(262793);
          return false;
        }
        NearbyFriendsUI.e(NearbyFriendsUI.this);
        if (NearbyFriendsUI.this.nzW)
        {
          if (NearbyFriendsUI.f(NearbyFriendsUI.this) != null)
          {
            NearbyFriendsUI.f(NearbyFriendsUI.this).dismiss();
            NearbyFriendsUI.a(NearbyFriendsUI.this, null);
          }
          com.tencent.mm.plugin.report.service.g.ahy(11);
          AppMethodBeat.o(262793);
          return false;
        }
        if (paramAnonymousBoolean)
        {
          if (NearbyFriendsUI.f(NearbyFriendsUI.this) != null) {
            NearbyFriendsUI.f(NearbyFriendsUI.this).setMessage(NearbyFriendsUI.this.getString(b.g.Moo));
          }
          NearbyFriendsUI.a(NearbyFriendsUI.this, new NearbyFriendsUI.b(NearbyFriendsUI.this, paramAnonymousFloat2, paramAnonymousFloat1, (int)paramAnonymousDouble2));
          NearbyFriendsUI.a(NearbyFriendsUI.this, new com.tencent.mm.plugin.nearby.model.c(NearbyFriendsUI.g(NearbyFriendsUI.this), NearbyFriendsUI.h(NearbyFriendsUI.this).oDU, NearbyFriendsUI.h(NearbyFriendsUI.this).oDT, NearbyFriendsUI.h(NearbyFriendsUI.this).EOW, paramAnonymousInt, "", ""));
          com.tencent.mm.kernel.h.aZW().a(NearbyFriendsUI.b(NearbyFriendsUI.this), 0);
        }
        for (;;)
        {
          AppMethodBeat.o(262793);
          return false;
          com.tencent.mm.plugin.report.service.g.ahy(11);
          if (NearbyFriendsUI.f(NearbyFriendsUI.this) != null)
          {
            NearbyFriendsUI.f(NearbyFriendsUI.this).dismiss();
            NearbyFriendsUI.a(NearbyFriendsUI.this, null);
          }
          NearbyFriendsUI.this.findViewById(b.c.EGi).setVisibility(0);
          NearbyFriendsUI.i(NearbyFriendsUI.this).setVisibility(8);
          NearbyFriendsUI.j(NearbyFriendsUI.this);
          if ((!NearbyFriendsUI.k(NearbyFriendsUI.this)) && (!com.tencent.mm.modelgeo.d.bJm()))
          {
            NearbyFriendsUI.l(NearbyFriendsUI.this);
            com.tencent.mm.ui.base.k.a(NearbyFriendsUI.this, NearbyFriendsUI.this.getString(b.g.gps_disable_tip), NearbyFriendsUI.this.getString(b.g.app_tip), NearbyFriendsUI.this.getString(b.g.jump_to_settings), NearbyFriendsUI.this.getString(b.g.app_cancel), false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(89845);
                com.tencent.mm.modelgeo.d.dP(NearbyFriendsUI.this);
                AppMethodBeat.o(89845);
              }
            }, null);
          }
        }
      }
    };
    AppMethodBeat.o(89866);
  }
  
  private void eGj()
  {
    int j = 0;
    AppMethodBeat.i(89877);
    Object localObject1 = new LinkedList();
    int i = 0;
    while (i < this.zPw.size())
    {
      if (!d.QS(((dgy)this.zPw.get(i)).pSf)) {
        ((List)localObject1).add((dgy)this.zPw.get(i));
      }
      i += 1;
    }
    this.zPw.clear();
    this.zPw = ((List)localObject1);
    Log.i("MicroMsg.NearbyFriend", "insertPoiItemList()");
    label133:
    Object localObject2;
    List localList;
    if (!this.zPw.isEmpty())
    {
      i = 1;
      localObject1 = this.EOP.keySet().iterator();
      do
      {
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (String)((Iterator)localObject1).next();
        } while (i == 0);
        localObject2 = (a)this.EOP.get(localObject2);
      } while ((((a)localObject2).uPP) || ((((a)localObject2).EOR > 0) && (((a)localObject2).EOU >= ((a)localObject2).EOR)) || (((a)localObject2).wDI >= ((a)localObject2).EOS));
      localList = this.zPw;
      if ((((a)localObject2).pos >= 0) && (((a)localObject2).pos <= this.zPw.size())) {
        break label306;
      }
    }
    label306:
    for (int k = this.zPw.size();; k = ((a)localObject2).pos + j)
    {
      localList.add(k, d.h(((a)localObject2).id, ((a)localObject2).icon, ((a)localObject2).name, ((a)localObject2).desc, ((a)localObject2).EOT));
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
    this.EPh = false;
    AppCompatActivity localAppCompatActivity = getContext();
    getString(b.g.app_tip);
    this.tipDialog = com.tencent.mm.ui.base.k.a(localAppCompatActivity, getString(b.g.nearby_friend_locating), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(89844);
        NearbyFriendsUI.this.nzW = true;
        com.tencent.mm.plugin.report.service.g.ahy(11);
        if (NearbyFriendsUI.b(NearbyFriendsUI.this) != null) {
          com.tencent.mm.kernel.h.aZW().a(NearbyFriendsUI.b(NearbyFriendsUI.this));
        }
        Log.i("MicroMsg.NearbyFriend", "[MonsterzDai]  [loading cancel] cancel in loading");
        if (!NearbyFriendsUI.c(NearbyFriendsUI.this))
        {
          NearbyFriendsUI.this.finish();
          Log.i("MicroMsg.NearbyFriend", "[MonsterzDai]  [loading cancel] cancel in first loading");
        }
        AppMethodBeat.o(89844);
      }
    });
    this.nzW = false;
    if (this.lsy != null)
    {
      this.lsy.a(this.lsF, true, false);
      l.kK(22, 10);
    }
    AppMethodBeat.o(89868);
  }
  
  private void gsQ()
  {
    AppMethodBeat.i(89869);
    View localView;
    Object localObject;
    int i;
    if (com.tencent.mm.bp.a.iGn())
    {
      if (this.EOZ != null)
      {
        this.pVC.removeHeaderView(this.EOZ);
        this.EOZ = null;
      }
      localView = View.inflate(this, b.d.EGK, null);
      localObject = (TextView)localView.findViewById(b.c.say_hi_count);
      com.tencent.mm.kernel.h.baC().aZJ();
      i = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaW().dkF();
      if (i != 0) {
        break label124;
      }
      localView.setVisibility(8);
      localView = null;
    }
    for (;;)
    {
      this.EOZ = localView;
      if (this.EOZ != null) {
        this.pVC.addHeaderView(this.EOZ);
      }
      AppMethodBeat.o(89869);
      return;
      label124:
      localView.setVisibility(0);
      ((TextView)localObject).setText(getResources().getQuantityString(b.e.say_hi_count_text_quantity, i, new Object[] { Integer.valueOf(i) }));
      localObject = (ImageView)localView.findViewById(b.c.match_dlg_img);
      bz localbz = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaW().gbh();
      if (localbz != null) {
        a.b.g((ImageView)localObject, localbz.field_sayhiuser);
      }
      localView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(89847);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/nearby/ui/NearbyFriendsUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          NearbyFriendsUI.i(NearbyFriendsUI.this).removeHeaderView(NearbyFriendsUI.m(NearbyFriendsUI.this));
          NearbyFriendsUI.n(NearbyFriendsUI.this);
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
  
  private void gsR()
  {
    AppMethodBeat.i(89871);
    com.tencent.mm.plugin.nearby.a.pFn.cI(this);
    AppMethodBeat.o(89871);
  }
  
  public int getLayoutId()
  {
    return b.d.Mof;
  }
  
  public void initView()
  {
    AppMethodBeat.i(89870);
    this.pVC = ((ListView)findViewById(b.c.fPh));
    this.Mpd = new c(this);
    Object localObject = this.pVC;
    if (this.EOX == null)
    {
      this.EOX = new LinearLayout(this);
      this.EOX.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      ((LinearLayout)this.EOX).setGravity(17);
    }
    this.EPc = true;
    ((ListView)localObject).addHeaderView(this.EOX);
    localObject = com.tencent.mm.k.i.aRC().getValue("LBSShowBindPhone");
    if ((localObject != null) && (((String)localObject).length() > 0)) {}
    try
    {
      this.EPd = Integer.valueOf((String)localObject).intValue();
      localObject = (String)com.tencent.mm.kernel.h.baE().ban().d(6, null);
      if ((localObject != null) && (((String)localObject).length() > 0)) {
        this.EPd = 0;
      }
      this.EPi = 0;
      if (com.tencent.mm.model.a.g.bDR().Km("3") != null)
      {
        localObject = com.tencent.mm.model.a.g.bDR().Km("3").value;
        locala = com.tencent.mm.plugin.account.friend.model.i.bWW();
        if (((String)localObject).equals("0")) {
          this.EPi = 0;
        }
      }
      else
      {
        if (((this.EPd > 0) || (this.EPi > 0)) && (this.EPi != 1))
        {
          this.Mpi = new BindMobileOrQQHeaderView(this);
          this.pVC.addHeaderView(this.Mpi);
        }
        this.pVC.setAdapter(this.Mpd);
        this.pVC.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(89848);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousAdapterView);
            ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
            ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramAnonymousInt);
            ((com.tencent.mm.hellhoundlib.b.b)localObject).hB(paramAnonymousLong);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/nearby/ui/NearbyFriendsUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
            if (NearbyFriendsUI.o(NearbyFriendsUI.this) <= 0)
            {
              i = paramAnonymousInt;
              if (NearbyFriendsUI.p(NearbyFriendsUI.this) <= 0) {}
            }
            else
            {
              i = paramAnonymousInt - 1;
            }
            paramAnonymousInt = i;
            if (com.tencent.mm.bp.a.iGn())
            {
              paramAnonymousInt = i;
              if (NearbyFriendsUI.m(NearbyFriendsUI.this) != null) {
                paramAnonymousInt = i - 1;
              }
            }
            int i = paramAnonymousInt;
            if (NearbyFriendsUI.q(NearbyFriendsUI.this)) {
              i = paramAnonymousInt - 1;
            }
            if ((i < 0) || (i >= NearbyFriendsUI.r(NearbyFriendsUI.this).size()))
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearby/ui/NearbyFriendsUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(89848);
              return;
            }
            paramAnonymousAdapterView = (dgy)NearbyFriendsUI.r(NearbyFriendsUI.this).get(i);
            if (NearbyFriendsUI.d.QS(paramAnonymousAdapterView.pSf))
            {
              paramAnonymousAdapterView = (NearbyFriendsUI.a)NearbyFriendsUI.s(NearbyFriendsUI.this).get(paramAnonymousAdapterView.UserName);
              paramAnonymousAdapterView.EOV |= 0x1;
              if (paramAnonymousAdapterView.jump_type == 1)
              {
                paramAnonymousView = new AppBrandStatObject();
                paramAnonymousView.scene = 1134;
                ((t)com.tencent.mm.kernel.h.ax(t.class)).a(NearbyFriendsUI.this, paramAnonymousAdapterView.EOT, "", 0, 0, "", paramAnonymousView);
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearby/ui/NearbyFriendsUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(89848);
                return;
                if (paramAnonymousAdapterView.jump_type == 2)
                {
                  paramAnonymousView = new Intent();
                  paramAnonymousView.putExtra("rawUrl", paramAnonymousAdapterView.EOT);
                  paramAnonymousView.putExtra("geta8key_scene", 25);
                  paramAnonymousView.putExtra("stastic_scene", 12);
                  com.tencent.mm.br.c.b(NearbyFriendsUI.this.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
                }
              }
            }
            paramAnonymousView = paramAnonymousAdapterView.UserName;
            au localau = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramAnonymousView);
            if (com.tencent.mm.contact.d.rs(localau.field_type))
            {
              localObject = new Intent();
              ((Intent)localObject).putExtra("Contact_User", paramAnonymousView);
              ((Intent)localObject).putExtra("Contact_Scene", 18);
              ((Intent)localObject).putExtra("Sns_from_Scene", 18);
              ((Intent)localObject).putExtra("lbs_ticket", paramAnonymousAdapterView.aant);
              ((Intent)localObject).putExtra("Contact_IsLbsGotoChatting", true);
              if ((paramAnonymousView != null) && (paramAnonymousView.length() > 0))
              {
                if (localau.iZC()) {
                  com.tencent.mm.plugin.report.service.h.OAn.kvStat(10298, paramAnonymousView + ",18");
                }
                paramAnonymousAdapterView = new xc();
                paramAnonymousAdapterView.iaC.intent = ((Intent)localObject);
                paramAnonymousAdapterView.iaC.username = paramAnonymousView;
                paramAnonymousAdapterView.publish();
                ((Intent)localObject).putExtra("CONTACT_INFO_UI_SOURCE", 5);
                ((Intent)localObject).putExtra("CONTACT_INFO_UI_SUB_SOURCE", 501);
                com.tencent.mm.plugin.nearby.a.pFn.c((Intent)localObject, NearbyFriendsUI.this);
              }
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearby/ui/NearbyFriendsUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(89848);
              return;
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView.UserName);
              paramAnonymousView.putExtra("Contact_Alias", paramAnonymousAdapterView.pSk);
              paramAnonymousView.putExtra("Contact_Nick", paramAnonymousAdapterView.vhX);
              paramAnonymousView.putExtra("Contact_Distance", paramAnonymousAdapterView.aaMl);
              paramAnonymousView.putExtra("Contact_Signature", paramAnonymousAdapterView.pSi);
              paramAnonymousView.putExtra("Contact_RegionCode", RegionCodeDecoder.bI(paramAnonymousAdapterView.pSo, paramAnonymousAdapterView.pSg, paramAnonymousAdapterView.pSh));
              paramAnonymousView.putExtra("Contact_Sex", paramAnonymousAdapterView.pSf);
              paramAnonymousView.putExtra("Contact_IsLBSFriend", true);
              paramAnonymousView.putExtra("Contact_Scene", 18);
              paramAnonymousView.putExtra("Contact_VUser_Info", paramAnonymousAdapterView.aaMn);
              paramAnonymousView.putExtra("Contact_VUser_Info_Flag", paramAnonymousAdapterView.aaMm);
              paramAnonymousView.putExtra("Contact_KWeibo_flag", paramAnonymousAdapterView.aaMq);
              paramAnonymousView.putExtra("Contact_KWeibo", paramAnonymousAdapterView.aaMo);
              paramAnonymousView.putExtra("Contact_KWeiboNick", paramAnonymousAdapterView.aaMp);
              paramAnonymousView.putExtra("Contact_KSnsIFlag", paramAnonymousAdapterView.aaMs.pSq);
              paramAnonymousView.putExtra("Contact_KSnsBgId", paramAnonymousAdapterView.aaMs.pSs);
              paramAnonymousView.putExtra("Contact_KSnsBgUrl", paramAnonymousAdapterView.aaMs.pSr);
              paramAnonymousView.putExtra("lbs_ticket", paramAnonymousAdapterView.aant);
              paramAnonymousView.putExtra("Contact_IsLbsGotoChatting", true);
              if (paramAnonymousAdapterView.pSp != null)
              {
                localObject = new com.tencent.mm.api.c();
                ((com.tencent.mm.api.c)localObject).field_brandList = paramAnonymousAdapterView.pSp;
                ((com.tencent.mm.api.c)localObject).field_brandFlag = paramAnonymousAdapterView.aaMt.pSt;
                ((com.tencent.mm.api.c)localObject).field_brandIconURL = paramAnonymousAdapterView.aaMt.pSw;
                ((com.tencent.mm.api.c)localObject).field_extInfo = paramAnonymousAdapterView.aaMt.pSu;
                ((com.tencent.mm.api.c)localObject).field_brandInfo = paramAnonymousAdapterView.aaMt.pSv;
                paramAnonymousView.putExtra("KBrandInfo_item", new MCacheItem((IAutoDBItem)localObject));
              }
              paramAnonymousView.putExtra("Sns_from_Scene", 18);
              paramAnonymousView.putExtra("CONTACT_INFO_UI_SOURCE", 5);
              paramAnonymousView.putExtra("CONTACT_INFO_UI_SUB_SOURCE", 501);
              com.tencent.mm.plugin.nearby.a.pFn.c(paramAnonymousView, NearbyFriendsUI.this);
            }
          }
        });
        this.pVC.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(89849);
            if (NearbyFriendsUI.t(NearbyFriendsUI.this) != null)
            {
              paramAnonymousView = NearbyFriendsUI.t(NearbyFriendsUI.this);
              if (paramAnonymousView.pSE != null) {
                paramAnonymousView.pSE.B(paramAnonymousMotionEvent);
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
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/nearby/ui/NearbyFriendsUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
            paramAnonymousView = NearbyFriendsUI.i(NearbyFriendsUI.this);
            paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousView);
            localObject = new Object();
            com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousView.aYi(), "com/tencent/mm/plugin/nearby/ui/NearbyFriendsUI$8", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
            BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView)paramAnonymousView.sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/nearby/ui/NearbyFriendsUI$8", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearby/ui/NearbyFriendsUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(89851);
          }
        });
        addIconOptionMenu(0, b.f.icons_outlined_more, new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(89855);
            paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.f(NearbyFriendsUI.this, 1, false);
            paramAnonymousMenuItem.GAC = new u.i()
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
                  NearbyFriendsUI.u(NearbyFriendsUI.this);
                  com.tencent.mm.kernel.h.baE().ban().B(16386, Integer.valueOf(NearbyFriendsUI.g(NearbyFriendsUI.this)));
                  NearbyFriendsUI.v(NearbyFriendsUI.this);
                  AppMethodBeat.o(89853);
                  return;
                  NearbyFriendsUI.a(NearbyFriendsUI.this, 3);
                  NearbyFriendsUI.u(NearbyFriendsUI.this);
                  com.tencent.mm.kernel.h.baE().ban().B(16386, Integer.valueOf(NearbyFriendsUI.g(NearbyFriendsUI.this)));
                  NearbyFriendsUI.v(NearbyFriendsUI.this);
                  AppMethodBeat.o(89853);
                  return;
                  NearbyFriendsUI.a(NearbyFriendsUI.this, 1);
                  NearbyFriendsUI.u(NearbyFriendsUI.this);
                  com.tencent.mm.kernel.h.baE().ban().B(16386, Integer.valueOf(NearbyFriendsUI.g(NearbyFriendsUI.this)));
                  NearbyFriendsUI.v(NearbyFriendsUI.this);
                  AppMethodBeat.o(89853);
                  return;
                  paramAnonymous2MenuItem = new Intent(NearbyFriendsUI.this, NearbySayHiListUI.class);
                  paramAnonymous2MenuItem.putExtra("k_say_hi_type", 2);
                  NearbyFriendsUI.this.startActivityForResult(paramAnonymous2MenuItem, 2009);
                  AppMethodBeat.o(89853);
                  return;
                  NearbyFriendsUI.b(NearbyFriendsUI.this, new com.tencent.mm.plugin.nearby.model.c(2, 0.0F, 0.0F, 0, 0, "", ""));
                  com.tencent.mm.kernel.h.aZW().a(NearbyFriendsUI.w(NearbyFriendsUI.this), 0);
                  paramAnonymous2MenuItem = NearbyFriendsUI.this;
                  AppCompatActivity localAppCompatActivity = NearbyFriendsUI.this.getContext();
                  NearbyFriendsUI.this.getString(b.g.app_tip);
                  NearbyFriendsUI.a(paramAnonymous2MenuItem, com.tencent.mm.ui.base.k.a(localAppCompatActivity, NearbyFriendsUI.this.getString(b.g.Mon), true, new DialogInterface.OnCancelListener()
                  {
                    public final void onCancel(DialogInterface paramAnonymous3DialogInterface)
                    {
                      AppMethodBeat.i(89852);
                      com.tencent.mm.kernel.h.aZW().a(NearbyFriendsUI.w(NearbyFriendsUI.this));
                      AppMethodBeat.o(89852);
                    }
                  }));
                }
              }
            };
            paramAnonymousMenuItem.Vtg = new u.g()
            {
              public final void onCreateMMMenu(com.tencent.mm.ui.base.s paramAnonymous2s)
              {
                AppMethodBeat.i(89854);
                paramAnonymous2s.oh(-1, b.g.Mor);
                paramAnonymous2s.oh(-1, b.g.Moq);
                paramAnonymous2s.oh(-1, b.g.Mop);
                paramAnonymous2s.oh(-1, b.g.say_hi_list_lbs_title);
                paramAnonymous2s.oh(-1, b.g.Mol);
                AppMethodBeat.o(89854);
              }
            };
            paramAnonymousMenuItem.dDn();
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
        i.a locala;
        this.EPd = 0;
        continue;
        if (localException.equals("2"))
        {
          if (locala == i.a.pSR)
          {
            this.EPi = 2;
            com.tencent.mm.model.a.f.Kq("3");
          }
        }
        else if ((localException.equals("1")) && (locala == i.a.pSO))
        {
          this.EPi = 2;
          com.tencent.mm.model.a.f.Kq("3");
        }
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(89872);
    Log.d("MicroMsg.NearbyFriend", "onActivityResult, requestCode %s, resultCode %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(89872);
      return;
      if (paramInt2 == -1)
      {
        this.Mpg = false;
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
    com.tencent.mm.plugin.report.service.g.ahw(11);
    super.onCreate(paramBundle);
    setMMTitle(b.g.nearby_friend_title);
    com.tencent.mm.kernel.h.aZW().a(148, this);
    com.tencent.mm.kernel.h.aZW().a(376, this);
    com.tencent.mm.kernel.h.aZW().a(1087, this);
    this.lsy = com.tencent.mm.modelgeo.d.bJl();
    initView();
    this.Mph = new String[] { getResources().getString(b.g.Mor), getResources().getString(b.g.Moq), getResources().getString(b.g.Mop), getResources().getString(b.g.say_hi_list_lbs_title) };
    this.EPf = Util.nullAs((Integer)com.tencent.mm.kernel.h.baE().ban().d(16386, null), 1);
    Object localObject1;
    int j;
    int i;
    label232:
    Object localObject2;
    if (this.EPf == 3)
    {
      setTitleLogo(0, b.f.ic_sex_male);
      getData();
      if (!LocaleUtil.isSimplifiedChineseAppLang()) {
        break label797;
      }
      localObject1 = XmlParser.parseXml(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yWO, ""), "lbsads", null);
      if (localObject1 == null) {
        break label797;
      }
      j = Util.getInt((String)((Map)localObject1).get(".lbsads.$count"), 0);
      if (j <= 0) {
        break label797;
      }
      i = 0;
      if (i >= j) {
        break label675;
      }
      localObject2 = new StringBuilder(".lbsads.lbsad");
      if (i != 0) {
        break label667;
      }
    }
    label667:
    for (paramBundle = "";; paramBundle = Integer.valueOf(i))
    {
      paramBundle = paramBundle;
      localObject2 = new a((byte)0);
      ((a)localObject2).id = ((String)((Map)localObject1).get(paramBundle + ".$id"));
      ((a)localObject2).pos = Util.getInt((String)((Map)localObject1).get(paramBundle + ".$pos"), 0);
      ((a)localObject2).EOR = Util.getInt((String)((Map)localObject1).get(paramBundle + ".$close_times"), 0);
      ((a)localObject2).EOS = Util.getInt((String)((Map)localObject1).get(paramBundle + ".$show_times"), 2147483647);
      ((a)localObject2).name = ((String)((Map)localObject1).get(paramBundle + ".name"));
      ((a)localObject2).desc = ((String)((Map)localObject1).get(paramBundle + ".desc"));
      ((a)localObject2).icon = ((String)((Map)localObject1).get(paramBundle + ".icon"));
      ((a)localObject2).jump_type = Util.getInt((String)((Map)localObject1).get(paramBundle + ".jump.$type"), 0);
      ((a)localObject2).EOT = ((String)((Map)localObject1).get(paramBundle + ".jump"));
      this.EOP.put(((a)localObject2).id, localObject2);
      i += 1;
      break label232;
      if (this.EPf == 4)
      {
        setTitleLogo(0, b.f.ic_sex_female);
        break;
      }
      setTitleLogo(0, 0);
      this.EPf = 1;
      break;
    }
    label675:
    paramBundle = com.tencent.mm.kernel.h.baE().ban().get(at.a.acZg, null);
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
          localObject2 = (a)this.EOP.get(localObject1[0]);
          if (localObject2 != null)
          {
            ((a)localObject2).EOU = Util.getInt(localObject1[1], 0);
            ((a)localObject2).wDI = Util.getInt(localObject1[2], 0);
          }
        }
        i += 1;
      }
    }
    label797:
    AppMethodBeat.o(89867);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(89875);
    if (this.EPi > 0) {
      com.tencent.mm.model.a.f.Kr("3");
    }
    com.tencent.mm.plugin.report.service.g.ahy(11);
    com.tencent.mm.kernel.h.aZW().b(148, this);
    com.tencent.mm.kernel.h.aZW().b(376, this);
    com.tencent.mm.kernel.h.aZW().b(1087, this);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if (this.lsy != null) {
      this.lsy.a(this.lsF);
    }
    com.tencent.mm.modelavatar.q.bFG().cancel();
    Object localObject;
    if (this.Mpd != null)
    {
      localObject = this.Mpd;
      if (((c)localObject).pSE != null)
      {
        ((c)localObject).pSE.detach();
        ((c)localObject).pSE = null;
      }
    }
    if (this.zPw.size() > 0)
    {
      Iterator localIterator = this.EOP.values().iterator();
      localObject = "";
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        localObject = new StringBuilder().append((String)localObject).append("|").append(locala.id).append(":").append(locala.EOU).append(":");
        int i = locala.wDI + 1;
        locala.wDI = i;
        localObject = i;
        com.tencent.mm.plugin.report.service.h.OAn.b(17431, new Object[] { locala.id, Integer.valueOf(locala.EOV + 1) });
      }
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acZg, localObject);
    }
    super.onDestroy();
    AppMethodBeat.o(89875);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(89873);
    super.onPause();
    if (this.lsy != null) {
      this.lsy.a(this.lsF);
    }
    this.lsH.dead();
    AppMethodBeat.o(89873);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(89874);
    super.onResume();
    if (this.lsy != null)
    {
      this.lsy.a(this.lsF, true, false);
      l.kK(22, 10);
    }
    gsQ();
    this.Mpd.notifyDataSetChanged();
    com.tencent.mm.kernel.h.baC().aZJ();
    if (((n)com.tencent.mm.kernel.h.ax(n.class)).gaW().dkF() == 0) {
      this.pVC.removeHeaderView(this.EPa);
    }
    this.lsH.alive();
    AppMethodBeat.o(89874);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(89876);
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    label319:
    label452:
    Object localObject;
    if (paramp.getType() == 148)
    {
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      int i = ((com.tencent.mm.plugin.nearby.model.c)paramp).bIO();
      if ((this.Mpe == null) && ((i == 1) || (i == 3) || (i == 4)))
      {
        AppMethodBeat.o(89876);
        return;
      }
      if (((i == 1) || (i == 3) || (i == 4)) && (this.Mpg))
      {
        Log.v("MicroMsg.NearbyFriend", "onSceneEnd data already requested, code=%d", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(89876);
        return;
      }
      if ((this.MoS == null) && (i == 2))
      {
        AppMethodBeat.o(89876);
        return;
      }
      Log.i("MicroMsg.NearbyFriend", "onSceneEnd: errType=%d, errCode=%d, errMsg=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if (paramp.getType() != 148)
      {
        AppMethodBeat.o(89876);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if ((i == 1) || (i == 3) || (i == 4))
        {
          this.zPw = ((com.tencent.mm.plugin.nearby.model.c)paramp).gsN();
          if ((this.zPw == null) || (this.zPw.size() == 0))
          {
            findViewById(b.c.fPi).setVisibility(0);
            this.pVC.setVisibility(8);
            gsR();
            com.tencent.mm.plugin.report.service.g.ahy(11);
            if (this.EPf != 3) {
              break label766;
            }
            setTitleLogo(0, b.f.ic_sex_male);
            this.Mpg = true;
            this.Mpe = null;
          }
        }
        else
        {
          if (((com.tencent.mm.plugin.nearby.model.c)paramp).bIO() == 2)
          {
            com.tencent.mm.ui.base.k.d(getContext(), getString(b.g.EHm), "", new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(89843);
                NearbyFriendsUI.this.finish();
                AppMethodBeat.o(89843);
              }
            });
            this.MoS = null;
          }
          if (!((com.tencent.mm.plugin.nearby.model.c)paramp).gsL()) {
            break label810;
          }
          paramString = getString(b.g.EHq);
          paramInt1 = ((com.tencent.mm.plugin.nearby.model.c)paramp).gsM();
          if (this.EOX != null)
          {
            if (this.Mpj != null) {
              break label799;
            }
            this.Mpj = View.inflate(this, b.d.EGL, null);
            this.EOX.addView(this.Mpj);
            this.Mpj.setOnClickListener(new NearbyFriendsUI.2(this));
            ((TextView)this.Mpj.findViewById(b.c.EGl)).setText(paramString);
            if (paramInt1 != 0) {
              ((TextView)this.Mpj.findViewById(b.c.EGk)).setText(String.format(getResources().getQuantityString(b.e.EHj, paramInt1, new Object[] { Integer.valueOf(paramInt1) }), new Object[0]));
            }
          }
        }
        for (;;)
        {
          this.EPg = true;
          AppMethodBeat.o(89876);
          return;
          paramString = new LinkedList();
          localObject = this.zPw.iterator();
          paramInt1 = 0;
          while (((Iterator)localObject).hasNext())
          {
            dgy localdgy = (dgy)((Iterator)localObject).next();
            if (((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().bxr(localdgy.UserName))
            {
              paramString.add(paramInt1, localdgy);
              paramInt1 += 1;
            }
            else if ((!Util.isNullOrNil(localdgy.UserName)) && (!Util.isNullOrNil(localdgy.aaMl)))
            {
              paramString.add(localdgy);
            }
          }
          this.zPw.clear();
          this.zPw = paramString;
          if ((this.zPw == null) || (this.zPw.size() == 0))
          {
            findViewById(b.c.fPi).setVisibility(0);
            this.pVC.setVisibility(8);
            break;
          }
          findViewById(b.c.fPi).setVisibility(8);
          eGj();
          this.Mpd.notifyDataSetChanged();
          if (this.Mpd.getCount() > 0) {
            this.pVC.setSelection(0);
          }
          this.pVC.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(89842);
              com.tencent.mm.plugin.report.service.g.ahx(11);
              AppMethodBeat.o(89842);
            }
          });
          break;
          label766:
          if (this.EPf == 4)
          {
            setTitleLogo(0, b.f.ic_sex_female);
            break label319;
          }
          setTitleLogo(0, 0);
          this.EPf = 1;
          break label319;
          label799:
          this.Mpj.setVisibility(0);
          break label452;
          label810:
          if ((this.Mpj != null) && (this.EOX != null)) {
            this.Mpj.setVisibility(8);
          }
        }
      }
      if ((i == 1) || (i == 3) || (i == 4))
      {
        localObject = (TextView)findViewById(b.c.fPi);
        ((TextView)localObject).setVisibility(0);
        gsR();
        if ((paramString == null) || (paramString.length() <= 0)) {
          break label1164;
        }
      }
    }
    label1164:
    for (paramString = com.tencent.mm.broadcast.a.CH(paramString);; paramString = null)
    {
      if ((paramString != null) && (paramString.desc != null) && (paramString.desc.length() > 0)) {
        ((TextView)localObject).setText(paramString.desc);
      }
      for (;;)
      {
        this.pVC.setVisibility(8);
        this.Mpe = null;
        if (((com.tencent.mm.plugin.nearby.model.c)paramp).bIO() == 2)
        {
          Toast.makeText(this, b.g.EHl, 1).show();
          this.MoS = null;
        }
        AppMethodBeat.o(89876);
        return;
        if (paramInt2 == -2001) {
          ((TextView)localObject).setText(getString(b.g.EHn));
        } else {
          ((TextView)localObject).setText(getString(b.g.EHo));
        }
      }
      if (paramp.getType() == 376)
      {
        if (((com.tencent.mm.plugin.nearby.model.d)paramp).bIO() != 1)
        {
          AppMethodBeat.o(89876);
          return;
        }
        if (this.tipDialog != null)
        {
          this.tipDialog.dismiss();
          this.tipDialog = null;
        }
        if ((paramInt1 == 0) && (paramInt2 == 0) && (((com.tencent.mm.plugin.nearby.model.d)paramp).pss != null))
        {
          paramString = ((com.tencent.mm.plugin.nearby.model.d)paramp).pss;
          com.tencent.mm.plugin.nearby.model.b.kF(paramString, ((com.tencent.mm.plugin.nearby.model.d)paramp).MoA);
          paramp = new Intent();
          paramp.putExtra("Chat_User", paramString);
          com.tencent.mm.plugin.nearby.a.pFn.e(paramp, this);
          AppMethodBeat.o(89876);
          return;
        }
        com.tencent.mm.ui.base.k.a(getContext(), b.g.EHp, b.g.app_tip, new DialogInterface.OnClickListener()
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
    int EOR;
    int EOS;
    String EOT;
    int EOU;
    int EOV = -1;
    String desc;
    String icon;
    String id;
    int jump_type;
    String name;
    int pos;
    boolean uPP = false;
    int wDI;
  }
  
  final class b
  {
    public int EOW;
    public float oDT;
    public float oDU;
    
    public b(float paramFloat1, float paramFloat2, int paramInt)
    {
      this.oDT = paramFloat1;
      this.oDU = paramFloat2;
      this.EOW = paramInt;
    }
  }
  
  final class c
    extends BaseAdapter
  {
    private final Context context;
    com.tencent.mm.ui.applet.b pSE;
    private com.tencent.mm.ui.applet.b.b pSF;
    
    public c(Context paramContext)
    {
      AppMethodBeat.i(89860);
      this.pSE = new com.tencent.mm.ui.applet.b(new com.tencent.mm.ui.applet.b.a()
      {
        public final Bitmap getHeadImg(String paramAnonymousString)
        {
          AppMethodBeat.i(89856);
          paramAnonymousString = com.tencent.mm.modelavatar.d.a(paramAnonymousString, false, -1, null);
          AppMethodBeat.o(89856);
          return paramAnonymousString;
        }
      });
      this.pSF = null;
      this.context = paramContext;
      AppMethodBeat.o(89860);
    }
    
    public final dgy QR(int paramInt)
    {
      AppMethodBeat.i(89863);
      dgy localdgy = (dgy)NearbyFriendsUI.r(NearbyFriendsUI.this).get(paramInt);
      AppMethodBeat.o(89863);
      return localdgy;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(89861);
      int i = NearbyFriendsUI.r(NearbyFriendsUI.this).size();
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
      if (this.pSF == null) {
        this.pSF = new com.tencent.mm.ui.applet.b.b()
        {
          public final int bWT()
          {
            AppMethodBeat.i(89858);
            int i = NearbyFriendsUI.c.this.getCount();
            AppMethodBeat.o(89858);
            return i;
          }
          
          public final String yq(int paramAnonymousInt)
          {
            AppMethodBeat.i(89857);
            if ((paramAnonymousInt < 0) || (paramAnonymousInt >= NearbyFriendsUI.c.this.getCount()))
            {
              Log.e("MicroMsg.NearbyFriend", "pos is invalid");
              AppMethodBeat.o(89857);
              return null;
            }
            Object localObject = NearbyFriendsUI.c.this.QR(paramAnonymousInt);
            if (localObject == null)
            {
              AppMethodBeat.o(89857);
              return null;
            }
            localObject = ((dgy)localObject).UserName;
            AppMethodBeat.o(89857);
            return localObject;
          }
        };
      }
      if (this.pSE != null) {
        this.pSE.a(paramInt, this.pSF);
      }
      Object localObject1;
      label381:
      Object localObject2;
      if (paramView == null)
      {
        paramViewGroup = new NearbyFriendsUI.e();
        paramView = View.inflate(this.context, b.d.Moh, null);
        paramViewGroup.pQZ = ((TextView)paramView.findViewById(b.c.nearby_friend_name));
        paramViewGroup.EPw = ((TextView)paramView.findViewById(b.c.fPk));
        paramViewGroup.EPv = ((TextView)paramView.findViewById(b.c.fPf));
        paramViewGroup.avatar = ((ImageView)paramView.findViewById(b.c.nearby_friend_avatar_iv));
        paramViewGroup.pSI = ((TextView)paramView.findViewById(b.c.fPg));
        paramViewGroup.EPx = ((ImageView)paramView.findViewById(b.c.fPl));
        paramViewGroup.EPy = ((ImageView)paramView.findViewById(b.c.EGj));
        paramViewGroup.EPA = ((ImageView)paramView.findViewById(b.c.EGf));
        paramViewGroup.EPB = ((ImageView)paramView.findViewById(b.c.EGg));
        paramViewGroup.EPC = ((ImageView)paramView.findViewById(b.c.EGh));
        paramViewGroup.nkq = ((ImageView)paramView.findViewById(b.c.close_btn));
        localObject1 = paramViewGroup.EPy.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).height = com.tencent.mm.cd.a.br(this.context, com.tencent.mm.plugin.nearby.b.b.NormalPadding);
        ((ViewGroup.LayoutParams)localObject1).width = com.tencent.mm.cd.a.br(this.context, com.tencent.mm.plugin.nearby.b.b.NormalPadding);
        paramViewGroup.EPy.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        paramViewGroup.DSo = ((ImageView)paramView.findViewById(b.c.fPj));
        paramView.setTag(paramViewGroup);
        localObject1 = (dgy)NearbyFriendsUI.r(NearbyFriendsUI.this).get(paramInt);
        paramViewGroup.pQZ.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this.context, ((dgy)localObject1).vhX, paramViewGroup.pQZ.getTextSize()));
        if (NearbyFriendsUI.g(NearbyFriendsUI.this) != 1) {
          break label875;
        }
        switch (((dgy)localObject1).pSf)
        {
        default: 
          paramViewGroup.DSo.setVisibility(8);
          if (((dgy)localObject1).aaMm != 0)
          {
            paramViewGroup.EPx.setVisibility(0);
            localObject2 = BackwardSupportUtil.BitmapFactory.decodeFile(az.a.okR.vd(((dgy)localObject1).aaMm), 2.0F);
            paramViewGroup.EPx.setImageBitmap((Bitmap)localObject2);
            paramViewGroup.DSo.setVisibility(8);
            label434:
            paramViewGroup.EPv.setText(((dgy)localObject1).aaMl);
            paramViewGroup.EPA.setVisibility(8);
            paramViewGroup.EPB.setVisibility(8);
            paramViewGroup.EPC.setVisibility(8);
            paramViewGroup.nkq.setVisibility(8);
            if ((localObject1 instanceof com.tencent.mm.plugin.nearby.model.a))
            {
              localObject2 = ((com.tencent.mm.plugin.nearby.model.a)localObject1).Mox;
              if ((localObject2 == null) || (((LinkedList)localObject2).size() != 1)) {
                break label899;
              }
              paramViewGroup.EPA.setVisibility(0);
              NearbyFriendsUI.u(paramViewGroup.EPA, (String)((LinkedList)localObject2).get(0));
              label538:
              localObject2 = (NearbyFriendsUI.a)NearbyFriendsUI.s(NearbyFriendsUI.this).get(((dgy)localObject1).UserName);
              if (localObject2 != null)
              {
                if (((NearbyFriendsUI.a)localObject2).EOV != -1) {
                  break label1053;
                }
                paramInt = 0;
                label576:
                ((NearbyFriendsUI.a)localObject2).EOV = paramInt;
                if (((NearbyFriendsUI.a)localObject2).EOR > 0) {
                  paramViewGroup.nkq.setVisibility(0);
                }
              }
              paramViewGroup.nkq.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(89859);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.cH(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/nearby/ui/NearbyFriendsUI$NearbyFriendAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                  paramAnonymousView = (NearbyFriendsUI.a)NearbyFriendsUI.s(NearbyFriendsUI.this).get(this.Mpr.UserName);
                  if (paramAnonymousView != null)
                  {
                    paramAnonymousView.EOU += 1;
                    paramAnonymousView.uPP = true;
                    paramAnonymousView.EOV |= 0x2;
                  }
                  NearbyFriendsUI.z(NearbyFriendsUI.this);
                  NearbyFriendsUI.c.this.notifyDataSetChanged();
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearby/ui/NearbyFriendsUI$NearbyFriendAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(89859);
                }
              });
            }
            if ((((dgy)localObject1).pSi != null) && (!((dgy)localObject1).pSi.trim().equals(""))) {
              break label1062;
            }
            paramViewGroup.EPw.setVisibility(8);
            label649:
            if ((((dgy)localObject1).aaMs == null) || ((((dgy)localObject1).aaMs.pSq & 0x1) <= 0)) {
              break label1099;
            }
            paramViewGroup.EPy.setVisibility(0);
            label678:
            if (!NearbyFriendsUI.d.QS(((dgy)localObject1).pSf)) {
              break label1111;
            }
            paramViewGroup.avatar.setImageBitmap(null);
            localObject2 = new com.tencent.mm.modelimage.loader.a.c.a();
            ((com.tencent.mm.modelimage.loader.a.c.a)localObject2).prefixPath = com.tencent.mm.plugin.image.d.bzL();
            ((com.tencent.mm.modelimage.loader.a.c.a)localObject2).oKp = true;
            ((com.tencent.mm.modelimage.loader.a.c.a)localObject2).nqa = true;
            localObject2 = ((com.tencent.mm.modelimage.loader.a.c.a)localObject2).bKx();
            r.bKe().a(((dgy)localObject1).ZhP, paramViewGroup.avatar, (com.tencent.mm.modelimage.loader.a.c)localObject2);
            if (Util.isNullOrNil(((dgy)localObject1).pSk)) {
              break label1299;
            }
            paramViewGroup.pSI.setText(((dgy)localObject1).pSk);
            paramViewGroup.pSI.setVisibility(0);
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
        paramViewGroup.DSo.setVisibility(0);
        paramViewGroup.DSo.setImageResource(b.f.ic_sex_male);
        paramViewGroup.DSo.setContentDescription(this.context.getString(b.g.male_Imgbtn));
        break label381;
        paramViewGroup.DSo.setVisibility(0);
        paramViewGroup.DSo.setImageResource(b.f.ic_sex_female);
        paramViewGroup.DSo.setContentDescription(this.context.getString(b.g.female_Imgbtn));
        break label381;
        label875:
        paramViewGroup.DSo.setVisibility(8);
        break label381;
        paramViewGroup.EPx.setVisibility(8);
        break label434;
        label899:
        if ((localObject2 != null) && (((LinkedList)localObject2).size() == 2))
        {
          paramViewGroup.EPA.setVisibility(0);
          paramViewGroup.EPB.setVisibility(0);
          NearbyFriendsUI.u(paramViewGroup.EPA, (String)((LinkedList)localObject2).get(0));
          NearbyFriendsUI.u(paramViewGroup.EPB, (String)((LinkedList)localObject2).get(1));
          break label538;
        }
        if ((localObject2 == null) || (((LinkedList)localObject2).size() < 3)) {
          break label538;
        }
        paramViewGroup.EPA.setVisibility(0);
        paramViewGroup.EPB.setVisibility(0);
        paramViewGroup.EPC.setVisibility(0);
        NearbyFriendsUI.u(paramViewGroup.EPA, (String)((LinkedList)localObject2).get(0));
        NearbyFriendsUI.u(paramViewGroup.EPB, (String)((LinkedList)localObject2).get(1));
        NearbyFriendsUI.u(paramViewGroup.EPC, (String)((LinkedList)localObject2).get(2));
        break label538;
        label1053:
        paramInt = ((NearbyFriendsUI.a)localObject2).EOV;
        break label576;
        label1062:
        paramViewGroup.EPw.setVisibility(0);
        paramViewGroup.EPw.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this.context, ((dgy)localObject1).pSi, paramViewGroup.EPw.getTextSize()));
        break label649;
        label1099:
        paramViewGroup.EPy.setVisibility(8);
        break label678;
        label1111:
        a.b.g(paramViewGroup.avatar, ((dgy)localObject1).UserName);
        if (((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().bxr(((dgy)localObject1).UserName))
        {
          paramViewGroup.pSI.setVisibility(0);
          if (au.ayS(((dgy)localObject1).aaMm))
          {
            paramViewGroup.pSI.setText(NearbyFriendsUI.this.getString(b.g.gOo));
          }
          else
          {
            au localau = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().bxu(((dgy)localObject1).UserName);
            Context localContext;
            if (localau != null)
            {
              localObject2 = paramViewGroup.pQZ;
              localContext = this.context;
              if (!Util.isNullOrNil(localau.aSV())) {
                break label1289;
              }
            }
            label1289:
            for (localObject1 = ((dgy)localObject1).vhX;; localObject1 = localau.aSV())
            {
              ((TextView)localObject2).setText(com.tencent.mm.pluginsdk.ui.span.p.b(localContext, (CharSequence)localObject1, paramViewGroup.pQZ.getTextSize()));
              paramViewGroup.pSI.setText(NearbyFriendsUI.this.getString(b.g.nearby_friend_is_contact));
              break;
            }
          }
        }
        else
        {
          label1299:
          paramViewGroup.pSI.setVisibility(8);
        }
      }
    }
  }
  
  static final class d
  {
    public static int EPu = 10000;
    
    public static boolean QS(int paramInt)
    {
      return paramInt == EPu;
    }
    
    public static dgy h(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    {
      AppMethodBeat.i(89865);
      com.tencent.mm.plugin.nearby.model.a locala = new com.tencent.mm.plugin.nearby.model.a();
      locala.pSf = EPu;
      locala.UserName = paramString1;
      locala.ZhP = paramString2;
      locala.aaMl = paramString4;
      locala.vhX = paramString3;
      locala.pSg = paramString5;
      AppMethodBeat.o(89865);
      return locala;
    }
  }
  
  static final class e
  {
    ImageView DSo;
    ImageView EPA;
    ImageView EPB;
    ImageView EPC;
    TextView EPv;
    TextView EPw;
    ImageView EPx;
    ImageView EPy;
    ImageView avatar;
    ImageView nkq;
    TextView pQZ;
    TextView pSI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI
 * JD-Core Version:    0.7.0.1
 */