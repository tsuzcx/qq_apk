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
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.cache.MCacheItem;
import com.tencent.mm.f.a.mj;
import com.tencent.mm.f.a.vm;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.k;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.c;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.nearby.b.c;
import com.tencent.mm.plugin.nearby.b.d;
import com.tencent.mm.plugin.nearby.b.e;
import com.tencent.mm.plugin.nearby.b.f;
import com.tencent.mm.plugin.nearby.b.g;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.aez;
import com.tencent.mm.protocal.protobuf.cqe;
import com.tencent.mm.protocal.protobuf.elj;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.s;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@k
public class NearbyFriendsUI
  extends MMActivity
  implements i
{
  private com.tencent.mm.plugin.nearby.a.c GsS;
  private c Gtd;
  private com.tencent.mm.plugin.nearby.a.c Gte;
  private com.tencent.mm.plugin.nearby.a.d Gtf;
  private boolean Gtg;
  private String[] Gth;
  private BindMobileOrQQHeaderView Gti;
  private View Gtj;
  private b Gtk;
  private com.tencent.mm.modelgeo.d iQC;
  private com.tencent.mm.modelgeo.b.a iQJ;
  private IListener iQL;
  boolean kUn;
  private ListView mYU;
  private s tipDialog;
  private List<cqe> wtq;
  private boolean zHA;
  private int zHB;
  private int zHD;
  private boolean zHE;
  private boolean zHF;
  private int zHG;
  private boolean zHI;
  private Map<String, a> zHm;
  private ViewGroup zHv;
  private View zHx;
  private View zHy;
  
  public NearbyFriendsUI()
  {
    AppMethodBeat.i(89866);
    this.tipDialog = null;
    this.wtq = new LinkedList();
    this.zHm = new HashMap();
    this.Gtg = false;
    this.zHD = 1;
    this.zHA = false;
    this.zHE = false;
    this.zHF = false;
    this.zHG = 0;
    this.zHx = null;
    this.iQL = new IListener() {};
    this.kUn = false;
    this.iQJ = new com.tencent.mm.modelgeo.b.a()
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
        if (NearbyFriendsUI.this.kUn)
        {
          if (NearbyFriendsUI.f(NearbyFriendsUI.this) != null)
          {
            NearbyFriendsUI.f(NearbyFriendsUI.this).dismiss();
            NearbyFriendsUI.a(NearbyFriendsUI.this, null);
          }
          com.tencent.mm.plugin.report.service.g.adc(11);
          AppMethodBeat.o(89846);
          return false;
        }
        if (paramAnonymousBoolean)
        {
          if (NearbyFriendsUI.f(NearbyFriendsUI.this) != null) {
            NearbyFriendsUI.f(NearbyFriendsUI.this).setMessage(NearbyFriendsUI.this.getString(b.g.nearby_friend_finding));
          }
          NearbyFriendsUI.a(NearbyFriendsUI.this, new NearbyFriendsUI.b(NearbyFriendsUI.this, paramAnonymousFloat2, paramAnonymousFloat1, (int)paramAnonymousDouble2));
          NearbyFriendsUI.a(NearbyFriendsUI.this, new com.tencent.mm.plugin.nearby.a.c(NearbyFriendsUI.g(NearbyFriendsUI.this), NearbyFriendsUI.h(NearbyFriendsUI.this).lLs, NearbyFriendsUI.h(NearbyFriendsUI.this).lLr, NearbyFriendsUI.h(NearbyFriendsUI.this).zHu, paramAnonymousInt, "", ""));
          com.tencent.mm.kernel.h.aGY().a(NearbyFriendsUI.b(NearbyFriendsUI.this), 0);
        }
        for (;;)
        {
          AppMethodBeat.o(89846);
          return false;
          com.tencent.mm.plugin.report.service.g.adc(11);
          if (NearbyFriendsUI.f(NearbyFriendsUI.this) != null)
          {
            NearbyFriendsUI.f(NearbyFriendsUI.this).dismiss();
            NearbyFriendsUI.a(NearbyFriendsUI.this, null);
          }
          NearbyFriendsUI.this.findViewById(b.c.nearby_friend_locate_failed).setVisibility(0);
          NearbyFriendsUI.i(NearbyFriendsUI.this).setVisibility(8);
          NearbyFriendsUI.j(NearbyFriendsUI.this);
          if ((!NearbyFriendsUI.k(NearbyFriendsUI.this)) && (!com.tencent.mm.modelgeo.d.blr()))
          {
            NearbyFriendsUI.l(NearbyFriendsUI.this);
            com.tencent.mm.ui.base.h.a(NearbyFriendsUI.this, NearbyFriendsUI.this.getString(b.g.gps_disable_tip), NearbyFriendsUI.this.getString(b.g.app_tip), NearbyFriendsUI.this.getString(b.g.jump_to_settings), NearbyFriendsUI.this.getString(b.g.app_cancel), false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(89845);
                com.tencent.mm.modelgeo.d.cW(NearbyFriendsUI.this);
                AppMethodBeat.o(89845);
              }
            }, null);
          }
        }
      }
    };
    AppMethodBeat.o(89866);
  }
  
  private void dMj()
  {
    int j = 0;
    AppMethodBeat.i(89877);
    Object localObject1 = new LinkedList();
    int i = 0;
    while (i < this.wtq.size())
    {
      if (!d.Ox(((cqe)this.wtq.get(i)).mVy)) {
        ((List)localObject1).add(this.wtq.get(i));
      }
      i += 1;
    }
    this.wtq.clear();
    this.wtq = ((List)localObject1);
    Log.i("MicroMsg.NearbyFriend", "insertPoiItemList()");
    label130:
    Object localObject2;
    List localList;
    if (!this.wtq.isEmpty())
    {
      i = 1;
      localObject1 = this.zHm.keySet().iterator();
      do
      {
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (String)((Iterator)localObject1).next();
        } while (i == 0);
        localObject2 = (a)this.zHm.get(localObject2);
      } while ((((a)localObject2).rED) || ((((a)localObject2).zHo > 0) && (((a)localObject2).zHr >= ((a)localObject2).zHo)) || (((a)localObject2).tzm >= ((a)localObject2).zHp));
      localList = this.wtq;
      if ((((a)localObject2).pos >= 0) && (((a)localObject2).pos <= this.wtq.size())) {
        break label303;
      }
    }
    label303:
    for (int k = this.wtq.size();; k = ((a)localObject2).pos + j)
    {
      localList.add(k, d.h(((a)localObject2).id, ((a)localObject2).icon, ((a)localObject2).name, ((a)localObject2).desc, ((a)localObject2).zHq));
      j += 1;
      break label130;
      i = 0;
      break;
    }
    AppMethodBeat.o(89877);
  }
  
  private void fiA()
  {
    AppMethodBeat.i(89871);
    com.tencent.mm.plugin.nearby.a.mIG.bW(this);
    AppMethodBeat.o(89871);
  }
  
  private void fiz()
  {
    AppMethodBeat.i(89869);
    View localView;
    Object localObject;
    int i;
    if (com.tencent.mm.bw.a.hft())
    {
      if (this.zHx != null)
      {
        this.mYU.removeHeaderView(this.zHx);
        this.zHx = null;
      }
      localView = View.inflate(this, b.d.nearby_goto_sayhi_btn, null);
      localObject = (TextView)localView.findViewById(b.c.say_hi_count);
      com.tencent.mm.kernel.h.aHE().aGH();
      i = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSb().cHo();
      if (i != 0) {
        break label124;
      }
      localView.setVisibility(8);
      localView = null;
    }
    for (;;)
    {
      this.zHx = localView;
      if (this.zHx != null) {
        this.mYU.addHeaderView(this.zHx);
      }
      AppMethodBeat.o(89869);
      return;
      label124:
      localView.setVisibility(0);
      ((TextView)localObject).setText(getResources().getQuantityString(b.e.say_hi_count_text_quantity, i, new Object[] { Integer.valueOf(i) }));
      localObject = (ImageView)localView.findViewById(b.c.match_dlg_img);
      bx localbx = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSb().eSm();
      if (localbx != null) {
        a.b.c((ImageView)localObject, localbx.field_sayhiuser);
      }
      localView.setOnClickListener(new NearbyFriendsUI.9(this));
    }
  }
  
  private void getData()
  {
    AppMethodBeat.i(89868);
    this.zHF = false;
    AppCompatActivity localAppCompatActivity = getContext();
    getString(b.g.app_tip);
    this.tipDialog = com.tencent.mm.ui.base.h.a(localAppCompatActivity, getString(b.g.nearby_friend_locating), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(89844);
        NearbyFriendsUI.this.kUn = true;
        com.tencent.mm.plugin.report.service.g.adc(11);
        if (NearbyFriendsUI.b(NearbyFriendsUI.this) != null) {
          com.tencent.mm.kernel.h.aGY().a(NearbyFriendsUI.b(NearbyFriendsUI.this));
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
    this.kUn = false;
    if (this.iQC != null) {
      this.iQC.a(this.iQJ, true);
    }
    AppMethodBeat.o(89868);
  }
  
  public int getLayoutId()
  {
    return b.d.nearby_friend;
  }
  
  public void initView()
  {
    AppMethodBeat.i(89870);
    this.mYU = ((ListView)findViewById(b.c.nearby_friend_lv));
    this.Gtd = new c(this);
    Object localObject = this.mYU;
    if (this.zHv == null)
    {
      this.zHv = new LinearLayout(this);
      this.zHv.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      ((LinearLayout)this.zHv).setGravity(17);
    }
    this.zHA = true;
    ((ListView)localObject).addHeaderView(this.zHv);
    localObject = com.tencent.mm.n.h.axc().getValue("LBSShowBindPhone");
    if ((localObject != null) && (((String)localObject).length() > 0)) {}
    try
    {
      this.zHB = Integer.valueOf((String)localObject).intValue();
      localObject = (String)com.tencent.mm.kernel.h.aHG().aHp().b(6, null);
      if ((localObject != null) && (((String)localObject).length() > 0)) {
        this.zHB = 0;
      }
      this.zHG = 0;
      if (com.tencent.mm.model.a.g.bga().Sk("3") != null)
      {
        localObject = com.tencent.mm.model.a.g.bga().Sk("3").value;
        locala = com.tencent.mm.plugin.account.friend.a.l.byi();
        if (((String)localObject).equals("0")) {
          this.zHG = 0;
        }
      }
      else
      {
        if (((this.zHB > 0) || (this.zHG > 0)) && (this.zHG != 1))
        {
          this.Gti = new BindMobileOrQQHeaderView(this);
          this.mYU.addHeaderView(this.Gti);
        }
        this.mYU.setAdapter(this.Gtd);
        this.mYU.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(89848);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousAdapterView);
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
            ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramAnonymousInt);
            ((com.tencent.mm.hellhoundlib.b.b)localObject).Fs(paramAnonymousLong);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/nearby/ui/NearbyFriendsUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
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
            if (com.tencent.mm.bw.a.hft())
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
            paramAnonymousAdapterView = (cqe)NearbyFriendsUI.r(NearbyFriendsUI.this).get(i);
            if (NearbyFriendsUI.d.Ox(paramAnonymousAdapterView.mVy))
            {
              paramAnonymousAdapterView = (NearbyFriendsUI.a)NearbyFriendsUI.s(NearbyFriendsUI.this).get(paramAnonymousAdapterView.UserName);
              paramAnonymousAdapterView.zHs |= 0x1;
              if (paramAnonymousAdapterView.jump_type == 1)
              {
                paramAnonymousView = new AppBrandStatObject();
                paramAnonymousView.scene = 1134;
                ((r)com.tencent.mm.kernel.h.ae(r.class)).a(NearbyFriendsUI.this, paramAnonymousAdapterView.zHq, "", 0, 0, "", paramAnonymousView);
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearby/ui/NearbyFriendsUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(89848);
                return;
                if (paramAnonymousAdapterView.jump_type == 2)
                {
                  paramAnonymousView = new Intent();
                  paramAnonymousView.putExtra("rawUrl", paramAnonymousAdapterView.zHq);
                  paramAnonymousView.putExtra("geta8key_scene", 25);
                  paramAnonymousView.putExtra("stastic_scene", 12);
                  com.tencent.mm.by.c.b(NearbyFriendsUI.this.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
                }
              }
            }
            paramAnonymousView = paramAnonymousAdapterView.UserName;
            as localas = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramAnonymousView);
            if (com.tencent.mm.contact.d.rk(localas.field_type))
            {
              localObject = new Intent();
              ((Intent)localObject).putExtra("Contact_User", paramAnonymousView);
              ((Intent)localObject).putExtra("Contact_Scene", 18);
              ((Intent)localObject).putExtra("Sns_from_Scene", 18);
              ((Intent)localObject).putExtra("lbs_ticket", paramAnonymousAdapterView.Tav);
              ((Intent)localObject).putExtra("Contact_IsLbsGotoChatting", true);
              if ((paramAnonymousView != null) && (paramAnonymousView.length() > 0))
              {
                if (localas.hxX()) {
                  com.tencent.mm.plugin.report.service.h.IzE.kvStat(10298, paramAnonymousView + ",18");
                }
                paramAnonymousAdapterView = new vm();
                paramAnonymousAdapterView.fUF.intent = ((Intent)localObject);
                paramAnonymousAdapterView.fUF.username = paramAnonymousView;
                EventCenter.instance.publish(paramAnonymousAdapterView);
                ((Intent)localObject).putExtra("CONTACT_INFO_UI_SOURCE", 5);
                com.tencent.mm.plugin.nearby.a.mIG.c((Intent)localObject, NearbyFriendsUI.this);
              }
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearby/ui/NearbyFriendsUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(89848);
              return;
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView.UserName);
              paramAnonymousView.putExtra("Contact_Alias", paramAnonymousAdapterView.mVD);
              paramAnonymousView.putExtra("Contact_Nick", paramAnonymousAdapterView.rWI);
              paramAnonymousView.putExtra("Contact_Distance", paramAnonymousAdapterView.TxE);
              paramAnonymousView.putExtra("Contact_Signature", paramAnonymousAdapterView.mVB);
              paramAnonymousView.putExtra("Contact_RegionCode", RegionCodeDecoder.bl(paramAnonymousAdapterView.mVH, paramAnonymousAdapterView.mVz, paramAnonymousAdapterView.mVA));
              paramAnonymousView.putExtra("Contact_Sex", paramAnonymousAdapterView.mVy);
              paramAnonymousView.putExtra("Contact_IsLBSFriend", true);
              paramAnonymousView.putExtra("Contact_Scene", 18);
              paramAnonymousView.putExtra("Contact_VUser_Info", paramAnonymousAdapterView.TxG);
              paramAnonymousView.putExtra("Contact_VUser_Info_Flag", paramAnonymousAdapterView.TxF);
              paramAnonymousView.putExtra("Contact_KWeibo_flag", paramAnonymousAdapterView.TxJ);
              paramAnonymousView.putExtra("Contact_KWeibo", paramAnonymousAdapterView.TxH);
              paramAnonymousView.putExtra("Contact_KWeiboNick", paramAnonymousAdapterView.TxI);
              paramAnonymousView.putExtra("Contact_KSnsIFlag", paramAnonymousAdapterView.TxL.mVJ);
              paramAnonymousView.putExtra("Contact_KSnsBgId", paramAnonymousAdapterView.TxL.mVL);
              paramAnonymousView.putExtra("Contact_KSnsBgUrl", paramAnonymousAdapterView.TxL.mVK);
              paramAnonymousView.putExtra("lbs_ticket", paramAnonymousAdapterView.Tav);
              paramAnonymousView.putExtra("Contact_IsLbsGotoChatting", true);
              if (paramAnonymousAdapterView.mVI != null)
              {
                localObject = new com.tencent.mm.api.c();
                ((com.tencent.mm.api.c)localObject).field_brandList = paramAnonymousAdapterView.mVI;
                ((com.tencent.mm.api.c)localObject).field_brandFlag = paramAnonymousAdapterView.TxM.mVM;
                ((com.tencent.mm.api.c)localObject).field_brandIconURL = paramAnonymousAdapterView.TxM.mVP;
                ((com.tencent.mm.api.c)localObject).field_extInfo = paramAnonymousAdapterView.TxM.mVN;
                ((com.tencent.mm.api.c)localObject).field_brandInfo = paramAnonymousAdapterView.TxM.mVO;
                paramAnonymousView.putExtra("KBrandInfo_item", new MCacheItem((IAutoDBItem)localObject));
              }
              paramAnonymousView.putExtra("Sns_from_Scene", 18);
              paramAnonymousView.putExtra("CONTACT_INFO_UI_SOURCE", 5);
              com.tencent.mm.plugin.nearby.a.mIG.c(paramAnonymousView, NearbyFriendsUI.this);
            }
          }
        });
        this.mYU.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(89849);
            if (NearbyFriendsUI.t(NearbyFriendsUI.this) != null)
            {
              paramAnonymousView = NearbyFriendsUI.t(NearbyFriendsUI.this);
              if (paramAnonymousView.mVX != null) {
                paramAnonymousView.mVX.B(paramAnonymousMotionEvent);
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
        setToTop(new NearbyFriendsUI.13(this));
        addIconOptionMenu(0, b.f.icons_outlined_more, new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(89855);
            paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(NearbyFriendsUI.this, 1, false);
            paramAnonymousMenuItem.ODU = new q.g()
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
                  com.tencent.mm.kernel.h.aHG().aHp().i(16386, Integer.valueOf(NearbyFriendsUI.g(NearbyFriendsUI.this)));
                  NearbyFriendsUI.v(NearbyFriendsUI.this);
                  AppMethodBeat.o(89853);
                  return;
                  NearbyFriendsUI.a(NearbyFriendsUI.this, 3);
                  NearbyFriendsUI.u(NearbyFriendsUI.this);
                  com.tencent.mm.kernel.h.aHG().aHp().i(16386, Integer.valueOf(NearbyFriendsUI.g(NearbyFriendsUI.this)));
                  NearbyFriendsUI.v(NearbyFriendsUI.this);
                  AppMethodBeat.o(89853);
                  return;
                  NearbyFriendsUI.a(NearbyFriendsUI.this, 1);
                  NearbyFriendsUI.u(NearbyFriendsUI.this);
                  com.tencent.mm.kernel.h.aHG().aHp().i(16386, Integer.valueOf(NearbyFriendsUI.g(NearbyFriendsUI.this)));
                  NearbyFriendsUI.v(NearbyFriendsUI.this);
                  AppMethodBeat.o(89853);
                  return;
                  paramAnonymous2MenuItem = new Intent(NearbyFriendsUI.this, NearbySayHiListUI.class);
                  paramAnonymous2MenuItem.putExtra("k_say_hi_type", 2);
                  NearbyFriendsUI.this.startActivityForResult(paramAnonymous2MenuItem, 2009);
                  AppMethodBeat.o(89853);
                  return;
                  NearbyFriendsUI.b(NearbyFriendsUI.this, new com.tencent.mm.plugin.nearby.a.c(2, 0.0F, 0.0F, 0, 0, "", ""));
                  com.tencent.mm.kernel.h.aGY().a(NearbyFriendsUI.w(NearbyFriendsUI.this), 0);
                  paramAnonymous2MenuItem = NearbyFriendsUI.this;
                  AppCompatActivity localAppCompatActivity = NearbyFriendsUI.this.getContext();
                  NearbyFriendsUI.this.getString(b.g.app_tip);
                  NearbyFriendsUI.a(paramAnonymous2MenuItem, com.tencent.mm.ui.base.h.a(localAppCompatActivity, NearbyFriendsUI.this.getString(b.g.nearby_friend_clearing_location), true, new DialogInterface.OnCancelListener()
                  {
                    public final void onCancel(DialogInterface paramAnonymous3DialogInterface)
                    {
                      AppMethodBeat.i(89852);
                      com.tencent.mm.kernel.h.aGY().a(NearbyFriendsUI.w(NearbyFriendsUI.this));
                      AppMethodBeat.o(89852);
                    }
                  }));
                }
              }
            };
            paramAnonymousMenuItem.ODT = new q.f()
            {
              public final void onCreateMMMenu(o paramAnonymous2o)
              {
                AppMethodBeat.i(89854);
                paramAnonymous2o.mn(-1, b.g.nearby_friend_location_findmm);
                paramAnonymous2o.mn(-1, b.g.nearby_friend_location_findgg);
                paramAnonymous2o.mn(-1, b.g.nearby_friend_location_findall);
                paramAnonymous2o.mn(-1, b.g.say_hi_list_lbs_title);
                paramAnonymous2o.mn(-1, b.g.nearby_friend_clear_location_exit);
                AppMethodBeat.o(89854);
              }
            };
            paramAnonymousMenuItem.eik();
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
        this.zHB = 0;
        continue;
        if (localException.equals("2"))
        {
          if (locala == l.a.mWl)
          {
            this.zHG = 2;
            com.tencent.mm.model.a.f.So("3");
          }
        }
        else if ((localException.equals("1")) && (locala == l.a.mWi))
        {
          this.zHG = 2;
          com.tencent.mm.model.a.f.So("3");
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
        this.Gtg = false;
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
    com.tencent.mm.plugin.report.service.g.ada(11);
    super.onCreate(paramBundle);
    setMMTitle(b.g.nearby_friend_title);
    com.tencent.mm.kernel.h.aGY().a(148, this);
    com.tencent.mm.kernel.h.aGY().a(376, this);
    com.tencent.mm.kernel.h.aGY().a(1087, this);
    this.iQC = com.tencent.mm.modelgeo.d.blq();
    initView();
    this.Gth = new String[] { getResources().getString(b.g.nearby_friend_location_findmm), getResources().getString(b.g.nearby_friend_location_findgg), getResources().getString(b.g.nearby_friend_location_findall), getResources().getString(b.g.say_hi_list_lbs_title) };
    this.zHD = Util.nullAs((Integer)com.tencent.mm.kernel.h.aHG().aHp().b(16386, null), 1);
    Object localObject1;
    int j;
    int i;
    label232:
    Object localObject2;
    if (this.zHD == 3)
    {
      setTitleLogo(0, b.f.ic_sex_male);
      getData();
      if (!LocaleUtil.isSimplifiedChineseAppLang()) {
        break label797;
      }
      localObject1 = XmlParser.parseXml(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vGV, ""), "lbsads", null);
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
      ((a)localObject2).zHo = Util.getInt((String)((Map)localObject1).get(paramBundle + ".$close_times"), 0);
      ((a)localObject2).zHp = Util.getInt((String)((Map)localObject1).get(paramBundle + ".$show_times"), 2147483647);
      ((a)localObject2).name = ((String)((Map)localObject1).get(paramBundle + ".name"));
      ((a)localObject2).desc = ((String)((Map)localObject1).get(paramBundle + ".desc"));
      ((a)localObject2).icon = ((String)((Map)localObject1).get(paramBundle + ".icon"));
      ((a)localObject2).jump_type = Util.getInt((String)((Map)localObject1).get(paramBundle + ".jump.$type"), 0);
      ((a)localObject2).zHq = ((String)((Map)localObject1).get(paramBundle + ".jump"));
      this.zHm.put(((a)localObject2).id, localObject2);
      i += 1;
      break label232;
      if (this.zHD == 4)
      {
        setTitleLogo(0, b.f.ic_sex_female);
        break;
      }
      setTitleLogo(0, 0);
      this.zHD = 1;
      break;
    }
    label675:
    paramBundle = com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vxu, null);
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
          localObject2 = (a)this.zHm.get(localObject1[0]);
          if (localObject2 != null)
          {
            ((a)localObject2).zHr = Util.getInt(localObject1[1], 0);
            ((a)localObject2).tzm = Util.getInt(localObject1[2], 0);
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
    if (this.zHG > 0) {
      com.tencent.mm.model.a.f.Sp("3");
    }
    com.tencent.mm.plugin.report.service.g.adc(11);
    com.tencent.mm.kernel.h.aGY().b(148, this);
    com.tencent.mm.kernel.h.aGY().b(376, this);
    com.tencent.mm.kernel.h.aGY().b(1087, this);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if (this.iQC != null) {
      this.iQC.b(this.iQJ);
    }
    com.tencent.mm.am.q.bhR().cancel();
    Object localObject;
    if (this.Gtd != null)
    {
      localObject = this.Gtd;
      if (((c)localObject).mVX != null)
      {
        ((c)localObject).mVX.detach();
        ((c)localObject).mVX = null;
      }
    }
    if (this.wtq.size() > 0)
    {
      Iterator localIterator = this.zHm.values().iterator();
      localObject = "";
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        localObject = new StringBuilder().append((String)localObject).append("|").append(locala.id).append(":").append(locala.zHr).append(":");
        int i = locala.tzm + 1;
        locala.tzm = i;
        localObject = i;
        com.tencent.mm.plugin.report.service.h.IzE.a(17431, new Object[] { locala.id, Integer.valueOf(locala.zHs + 1) });
      }
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vxu, localObject);
    }
    super.onDestroy();
    AppMethodBeat.o(89875);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(89873);
    super.onPause();
    if (this.iQC != null) {
      this.iQC.b(this.iQJ);
    }
    EventCenter.instance.removeListener(this.iQL);
    AppMethodBeat.o(89873);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(89874);
    super.onResume();
    if (this.iQC != null) {
      this.iQC.a(this.iQJ, true);
    }
    fiz();
    this.Gtd.notifyDataSetChanged();
    com.tencent.mm.kernel.h.aHE().aGH();
    if (((n)com.tencent.mm.kernel.h.ae(n.class)).eSb().cHo() == 0) {
      this.mYU.removeHeaderView(this.zHy);
    }
    EventCenter.instance.addListener(this.iQL);
    AppMethodBeat.o(89874);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
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
    if (paramq.getType() == 148)
    {
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      int i = ((com.tencent.mm.plugin.nearby.a.c)paramq).ZB();
      if ((this.Gte == null) && ((i == 1) || (i == 3) || (i == 4)))
      {
        AppMethodBeat.o(89876);
        return;
      }
      if (((i == 1) || (i == 3) || (i == 4)) && (this.Gtg))
      {
        Log.v("MicroMsg.NearbyFriend", "onSceneEnd data already requested, code=%d", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(89876);
        return;
      }
      if ((this.GsS == null) && (i == 2))
      {
        AppMethodBeat.o(89876);
        return;
      }
      Log.i("MicroMsg.NearbyFriend", "onSceneEnd: errType=%d, errCode=%d, errMsg=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if (paramq.getType() != 148)
      {
        AppMethodBeat.o(89876);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if ((i == 1) || (i == 3) || (i == 4))
        {
          this.wtq = ((com.tencent.mm.plugin.nearby.a.c)paramq).fiw();
          if ((this.wtq == null) || (this.wtq.size() == 0))
          {
            findViewById(b.c.nearby_friend_not_found).setVisibility(0);
            this.mYU.setVisibility(8);
            fiA();
            com.tencent.mm.plugin.report.service.g.adc(11);
            if (this.zHD != 3) {
              break label766;
            }
            setTitleLogo(0, b.f.ic_sex_male);
            this.Gtg = true;
            this.Gte = null;
          }
        }
        else
        {
          if (((com.tencent.mm.plugin.nearby.a.c)paramq).ZB() == 2)
          {
            com.tencent.mm.ui.base.h.d(getContext(), getString(b.g.nearby_friend_clear_location_ok), "", new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(89843);
                NearbyFriendsUI.this.finish();
                AppMethodBeat.o(89843);
              }
            });
            this.GsS = null;
          }
          if (!((com.tencent.mm.plugin.nearby.a.c)paramq).fiu()) {
            break label810;
          }
          paramString = getString(b.g.nearby_lbsroom_name);
          paramInt1 = ((com.tencent.mm.plugin.nearby.a.c)paramq).fiv();
          if (this.zHv != null)
          {
            if (this.Gtj != null) {
              break label799;
            }
            this.Gtj = View.inflate(this, b.d.nearby_group_header_item, null);
            this.zHv.addView(this.Gtj);
            this.Gtj.setOnClickListener(new NearbyFriendsUI.2(this));
            ((TextView)this.Gtj.findViewById(b.c.nearby_group_title)).setText(paramString);
            if (paramInt1 != 0) {
              ((TextView)this.Gtj.findViewById(b.c.nearby_group_member_count)).setText(String.format(getResources().getQuantityString(b.e.nearby_lbsroom_member_count, paramInt1, new Object[] { Integer.valueOf(paramInt1) }), new Object[0]));
            }
          }
        }
        for (;;)
        {
          this.zHE = true;
          AppMethodBeat.o(89876);
          return;
          paramString = new LinkedList();
          localObject = this.wtq.iterator();
          paramInt1 = 0;
          while (((Iterator)localObject).hasNext())
          {
            cqe localcqe = (cqe)((Iterator)localObject).next();
            if (((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().bwd(localcqe.UserName))
            {
              paramString.add(paramInt1, localcqe);
              paramInt1 += 1;
            }
            else if ((!Util.isNullOrNil(localcqe.UserName)) && (!Util.isNullOrNil(localcqe.TxE)))
            {
              paramString.add(localcqe);
            }
          }
          this.wtq.clear();
          this.wtq = paramString;
          if ((this.wtq == null) || (this.wtq.size() == 0))
          {
            findViewById(b.c.nearby_friend_not_found).setVisibility(0);
            this.mYU.setVisibility(8);
            break;
          }
          findViewById(b.c.nearby_friend_not_found).setVisibility(8);
          dMj();
          this.Gtd.notifyDataSetChanged();
          if (this.Gtd.getCount() > 0) {
            this.mYU.setSelection(0);
          }
          this.mYU.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(89842);
              com.tencent.mm.plugin.report.service.g.adb(11);
              AppMethodBeat.o(89842);
            }
          });
          break;
          label766:
          if (this.zHD == 4)
          {
            setTitleLogo(0, b.f.ic_sex_female);
            break label319;
          }
          setTitleLogo(0, 0);
          this.zHD = 1;
          break label319;
          label799:
          this.Gtj.setVisibility(0);
          break label452;
          label810:
          if ((this.Gtj != null) && (this.zHv != null)) {
            this.Gtj.setVisibility(8);
          }
        }
      }
      if ((i == 1) || (i == 3) || (i == 4))
      {
        localObject = (TextView)findViewById(b.c.nearby_friend_not_found);
        ((TextView)localObject).setVisibility(0);
        fiA();
        if ((paramString == null) || (paramString.length() <= 0)) {
          break label1164;
        }
      }
    }
    label1164:
    for (paramString = com.tencent.mm.h.a.Kb(paramString);; paramString = null)
    {
      if ((paramString != null) && (paramString.desc != null) && (paramString.desc.length() > 0)) {
        ((TextView)localObject).setText(paramString.desc);
      }
      for (;;)
      {
        this.mYU.setVisibility(8);
        this.Gte = null;
        if (((com.tencent.mm.plugin.nearby.a.c)paramq).ZB() == 2)
        {
          Toast.makeText(this, b.g.nearby_friend_clear_location_failed, 1).show();
          this.GsS = null;
        }
        AppMethodBeat.o(89876);
        return;
        if (paramInt2 == -2001) {
          ((TextView)localObject).setText(getString(b.g.nearby_friend_expose));
        } else {
          ((TextView)localObject).setText(getString(b.g.nearby_friend_get_friend_fail));
        }
      }
      if (paramq.getType() == 376)
      {
        if (((com.tencent.mm.plugin.nearby.a.d)paramq).ZB() != 1)
        {
          AppMethodBeat.o(89876);
          return;
        }
        if (this.tipDialog != null)
        {
          this.tipDialog.dismiss();
          this.tipDialog = null;
        }
        if ((paramInt1 == 0) && (paramInt2 == 0) && (((com.tencent.mm.plugin.nearby.a.d)paramq).mye != null))
        {
          paramString = ((com.tencent.mm.plugin.nearby.a.d)paramq).mye;
          com.tencent.mm.plugin.nearby.a.b.jo(paramString, ((com.tencent.mm.plugin.nearby.a.d)paramq).GsA);
          paramq = new Intent();
          paramq.putExtra("Chat_User", paramString);
          com.tencent.mm.plugin.nearby.a.mIG.e(paramq, this);
          AppMethodBeat.o(89876);
          return;
        }
        com.tencent.mm.ui.base.h.a(getContext(), b.g.nearby_lbsroom_join_failed, b.g.app_tip, new DialogInterface.OnClickListener()
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
    String icon;
    String id;
    int jump_type;
    String name;
    int pos;
    boolean rED = false;
    int tzm;
    int zHo;
    int zHp;
    String zHq;
    int zHr;
    int zHs = -1;
  }
  
  final class b
  {
    public float lLr;
    public float lLs;
    public int zHu;
    
    public b(float paramFloat1, float paramFloat2, int paramInt)
    {
      this.lLr = paramFloat1;
      this.lLs = paramFloat2;
      this.zHu = paramInt;
    }
  }
  
  final class c
    extends BaseAdapter
  {
    private final Context context;
    com.tencent.mm.ui.applet.b mVX;
    private com.tencent.mm.ui.applet.b.b mVY;
    
    public c(Context paramContext)
    {
      AppMethodBeat.i(89860);
      this.mVX = new com.tencent.mm.ui.applet.b(new com.tencent.mm.ui.applet.b.a()
      {
        public final Bitmap aaG(String paramAnonymousString)
        {
          AppMethodBeat.i(89856);
          paramAnonymousString = com.tencent.mm.am.d.a(paramAnonymousString, false, -1, null);
          AppMethodBeat.o(89856);
          return paramAnonymousString;
        }
      });
      this.mVY = null;
      this.context = paramContext;
      AppMethodBeat.o(89860);
    }
    
    public final cqe Ow(int paramInt)
    {
      AppMethodBeat.i(89863);
      cqe localcqe = (cqe)NearbyFriendsUI.r(NearbyFriendsUI.this).get(paramInt);
      AppMethodBeat.o(89863);
      return localcqe;
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
      if (this.mVY == null) {
        this.mVY = new com.tencent.mm.ui.applet.b.b()
        {
          public final int byf()
          {
            AppMethodBeat.i(89858);
            int i = NearbyFriendsUI.c.this.getCount();
            AppMethodBeat.o(89858);
            return i;
          }
          
          public final String yk(int paramAnonymousInt)
          {
            AppMethodBeat.i(89857);
            if ((paramAnonymousInt < 0) || (paramAnonymousInt >= NearbyFriendsUI.c.this.getCount()))
            {
              Log.e("MicroMsg.NearbyFriend", "pos is invalid");
              AppMethodBeat.o(89857);
              return null;
            }
            Object localObject = NearbyFriendsUI.c.this.Ow(paramAnonymousInt);
            if (localObject == null)
            {
              AppMethodBeat.o(89857);
              return null;
            }
            localObject = ((cqe)localObject).UserName;
            AppMethodBeat.o(89857);
            return localObject;
          }
        };
      }
      if (this.mVX != null) {
        this.mVX.a(paramInt, this.mVY);
      }
      Object localObject1;
      label381:
      Object localObject2;
      if (paramView == null)
      {
        paramViewGroup = new NearbyFriendsUI.e();
        paramView = View.inflate(this.context, b.d.nearby_friend_item, null);
        paramViewGroup.mUr = ((TextView)paramView.findViewById(b.c.nearby_friend_name));
        paramViewGroup.zHV = ((TextView)paramView.findViewById(b.c.nearby_friend_sign));
        paramViewGroup.zHU = ((TextView)paramView.findViewById(b.c.nearby_friend_distance));
        paramViewGroup.mWb = ((ImageView)paramView.findViewById(b.c.nearby_friend_avatar_iv));
        paramViewGroup.mWc = ((TextView)paramView.findViewById(b.c.nearby_friend_is_friend));
        paramViewGroup.zHW = ((ImageView)paramView.findViewById(b.c.nearby_friend_vuserinfo));
        paramViewGroup.zHX = ((ImageView)paramView.findViewById(b.c.nearby_friend_sns));
        paramViewGroup.zIa = ((ImageView)paramView.findViewById(b.c.nearby_friend_ad_icon_1));
        paramViewGroup.zIb = ((ImageView)paramView.findViewById(b.c.nearby_friend_ad_icon_2));
        paramViewGroup.zIc = ((ImageView)paramView.findViewById(b.c.nearby_friend_ad_icon_3));
        paramViewGroup.kHA = ((ImageView)paramView.findViewById(b.c.close_btn));
        localObject1 = paramViewGroup.zHX.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).height = com.tencent.mm.ci.a.aY(this.context, com.tencent.mm.plugin.nearby.b.b.NormalPadding);
        ((ViewGroup.LayoutParams)localObject1).width = com.tencent.mm.ci.a.aY(this.context, com.tencent.mm.plugin.nearby.b.b.NormalPadding);
        paramViewGroup.zHX.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        paramViewGroup.zHZ = ((ImageView)paramView.findViewById(b.c.nearby_friend_sex));
        paramView.setTag(paramViewGroup);
        localObject1 = (cqe)NearbyFriendsUI.r(NearbyFriendsUI.this).get(paramInt);
        paramViewGroup.mUr.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.context, ((cqe)localObject1).rWI, paramViewGroup.mUr.getTextSize()));
        if (NearbyFriendsUI.g(NearbyFriendsUI.this) != 1) {
          break label875;
        }
        switch (((cqe)localObject1).mVy)
        {
        default: 
          paramViewGroup.zHZ.setVisibility(8);
          if (((cqe)localObject1).TxF != 0)
          {
            paramViewGroup.zHW.setVisibility(0);
            localObject2 = BackwardSupportUtil.BitmapFactory.decodeFile(az.a.ltt.uS(((cqe)localObject1).TxF), 2.0F);
            paramViewGroup.zHW.setImageBitmap((Bitmap)localObject2);
            paramViewGroup.zHZ.setVisibility(8);
            label434:
            paramViewGroup.zHU.setText(((cqe)localObject1).TxE);
            paramViewGroup.zIa.setVisibility(8);
            paramViewGroup.zIb.setVisibility(8);
            paramViewGroup.zIc.setVisibility(8);
            paramViewGroup.kHA.setVisibility(8);
            if ((localObject1 instanceof com.tencent.mm.plugin.nearby.a.a))
            {
              localObject2 = ((com.tencent.mm.plugin.nearby.a.a)localObject1).Gsx;
              if ((localObject2 == null) || (((LinkedList)localObject2).size() != 1)) {
                break label899;
              }
              paramViewGroup.zIa.setVisibility(0);
              NearbyFriendsUI.t(paramViewGroup.zIa, (String)((LinkedList)localObject2).get(0));
              label538:
              localObject2 = (NearbyFriendsUI.a)NearbyFriendsUI.s(NearbyFriendsUI.this).get(((cqe)localObject1).UserName);
              if (localObject2 != null)
              {
                if (((NearbyFriendsUI.a)localObject2).zHs != -1) {
                  break label1053;
                }
                paramInt = 0;
                label576:
                ((NearbyFriendsUI.a)localObject2).zHs = paramInt;
                if (((NearbyFriendsUI.a)localObject2).zHo > 0) {
                  paramViewGroup.kHA.setVisibility(0);
                }
              }
              paramViewGroup.kHA.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(89859);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bn(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/nearby/ui/NearbyFriendsUI$NearbyFriendAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                  paramAnonymousView = (NearbyFriendsUI.a)NearbyFriendsUI.s(NearbyFriendsUI.this).get(this.Gtr.UserName);
                  if (paramAnonymousView != null)
                  {
                    paramAnonymousView.zHr += 1;
                    paramAnonymousView.rED = true;
                    paramAnonymousView.zHs |= 0x2;
                  }
                  NearbyFriendsUI.z(NearbyFriendsUI.this);
                  NearbyFriendsUI.c.this.notifyDataSetChanged();
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearby/ui/NearbyFriendsUI$NearbyFriendAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(89859);
                }
              });
            }
            if ((((cqe)localObject1).mVB != null) && (!((cqe)localObject1).mVB.trim().equals(""))) {
              break label1062;
            }
            paramViewGroup.zHV.setVisibility(8);
            label649:
            if ((((cqe)localObject1).TxL == null) || ((((cqe)localObject1).TxL.mVJ & 0x1) <= 0)) {
              break label1099;
            }
            paramViewGroup.zHX.setVisibility(0);
            label678:
            if (!NearbyFriendsUI.d.Ox(((cqe)localObject1).mVy)) {
              break label1111;
            }
            paramViewGroup.mWb.setImageBitmap(null);
            localObject2 = new c.a();
            ((c.a)localObject2).prefixPath = com.tencent.mm.plugin.image.d.bbW();
            ((c.a)localObject2).lRD = true;
            ((c.a)localObject2).kOl = true;
            localObject2 = ((c.a)localObject2).bmL();
            com.tencent.mm.ay.q.bml().a(((cqe)localObject1).SjJ, paramViewGroup.mWb, (com.tencent.mm.ay.a.a.c)localObject2);
            if (Util.isNullOrNil(((cqe)localObject1).mVD)) {
              break label1299;
            }
            paramViewGroup.mWc.setText(((cqe)localObject1).mVD);
            paramViewGroup.mWc.setVisibility(0);
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
        paramViewGroup.zHZ.setVisibility(0);
        paramViewGroup.zHZ.setImageResource(b.f.ic_sex_male);
        paramViewGroup.zHZ.setContentDescription(this.context.getString(b.g.male_Imgbtn));
        break label381;
        paramViewGroup.zHZ.setVisibility(0);
        paramViewGroup.zHZ.setImageResource(b.f.ic_sex_female);
        paramViewGroup.zHZ.setContentDescription(this.context.getString(b.g.female_Imgbtn));
        break label381;
        label875:
        paramViewGroup.zHZ.setVisibility(8);
        break label381;
        paramViewGroup.zHW.setVisibility(8);
        break label434;
        label899:
        if ((localObject2 != null) && (((LinkedList)localObject2).size() == 2))
        {
          paramViewGroup.zIa.setVisibility(0);
          paramViewGroup.zIb.setVisibility(0);
          NearbyFriendsUI.t(paramViewGroup.zIa, (String)((LinkedList)localObject2).get(0));
          NearbyFriendsUI.t(paramViewGroup.zIb, (String)((LinkedList)localObject2).get(1));
          break label538;
        }
        if ((localObject2 == null) || (((LinkedList)localObject2).size() < 3)) {
          break label538;
        }
        paramViewGroup.zIa.setVisibility(0);
        paramViewGroup.zIb.setVisibility(0);
        paramViewGroup.zIc.setVisibility(0);
        NearbyFriendsUI.t(paramViewGroup.zIa, (String)((LinkedList)localObject2).get(0));
        NearbyFriendsUI.t(paramViewGroup.zIb, (String)((LinkedList)localObject2).get(1));
        NearbyFriendsUI.t(paramViewGroup.zIc, (String)((LinkedList)localObject2).get(2));
        break label538;
        label1053:
        paramInt = ((NearbyFriendsUI.a)localObject2).zHs;
        break label576;
        label1062:
        paramViewGroup.zHV.setVisibility(0);
        paramViewGroup.zHV.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.context, ((cqe)localObject1).mVB, paramViewGroup.zHV.getTextSize()));
        break label649;
        label1099:
        paramViewGroup.zHX.setVisibility(8);
        break label678;
        label1111:
        a.b.c(paramViewGroup.mWb, ((cqe)localObject1).UserName);
        if (((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().bwd(((cqe)localObject1).UserName))
        {
          paramViewGroup.mWc.setVisibility(0);
          if (as.asD(((cqe)localObject1).TxF))
          {
            paramViewGroup.mWc.setText(NearbyFriendsUI.this.getString(b.g.nearby_friend_followed));
          }
          else
          {
            as localas = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().bwg(((cqe)localObject1).UserName);
            Context localContext;
            if (localas != null)
            {
              localObject2 = paramViewGroup.mUr;
              localContext = this.context;
              if (!Util.isNullOrNil(localas.ays())) {
                break label1289;
              }
            }
            label1289:
            for (localObject1 = ((cqe)localObject1).rWI;; localObject1 = localas.ays())
            {
              ((TextView)localObject2).setText(com.tencent.mm.pluginsdk.ui.span.l.b(localContext, (CharSequence)localObject1, paramViewGroup.mUr.getTextSize()));
              paramViewGroup.mWc.setText(NearbyFriendsUI.this.getString(b.g.nearby_friend_is_contact));
              break;
            }
          }
        }
        else
        {
          label1299:
          paramViewGroup.mWc.setVisibility(8);
        }
      }
    }
  }
  
  static final class d
  {
    public static int zHS = 10000;
    
    public static boolean Ox(int paramInt)
    {
      return paramInt == zHS;
    }
    
    public static cqe h(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    {
      AppMethodBeat.i(89865);
      com.tencent.mm.plugin.nearby.a.a locala = new com.tencent.mm.plugin.nearby.a.a();
      locala.mVy = zHS;
      locala.UserName = paramString1;
      locala.SjJ = paramString2;
      locala.TxE = paramString4;
      locala.rWI = paramString3;
      locala.mVz = paramString5;
      AppMethodBeat.o(89865);
      return locala;
    }
  }
  
  static final class e
  {
    ImageView kHA;
    TextView mUr;
    ImageView mWb;
    TextView mWc;
    TextView zHU;
    TextView zHV;
    ImageView zHW;
    ImageView zHX;
    ImageView zHZ;
    ImageView zIa;
    ImageView zIb;
    ImageView zIc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI
 * JD-Core Version:    0.7.0.1
 */