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
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.t;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.g.a.ls;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.c;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.chi;
import com.tencent.mm.protocal.protobuf.ebj;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.b.b;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@com.tencent.mm.kernel.i
public class NearbyFriendsUI
  extends MMActivity
  implements com.tencent.mm.ak.i
{
  private c AAa;
  private com.tencent.mm.plugin.nearby.a.c AAb;
  private com.tencent.mm.plugin.nearby.a.d AAc;
  private boolean AAd;
  private String[] AAe;
  private BindMobileOrQQHeaderView AAf;
  private View AAg;
  private b AAh;
  private com.tencent.mm.plugin.nearby.a.c AzP;
  private com.tencent.mm.modelgeo.b.a gmA;
  private IListener gmC;
  private com.tencent.mm.modelgeo.d gmt;
  boolean ifz;
  private ListView khv;
  private List<chi> sNv;
  private com.tencent.mm.ui.base.q tipDialog;
  private Map<String, a> uRY;
  private ViewGroup uSh;
  private View uSj;
  private View uSk;
  private boolean uSm;
  private int uSn;
  private int uSp;
  private boolean uSq;
  private boolean uSr;
  private int uSs;
  private boolean uSu;
  
  public NearbyFriendsUI()
  {
    AppMethodBeat.i(89866);
    this.tipDialog = null;
    this.sNv = new LinkedList();
    this.uRY = new HashMap();
    this.AAd = false;
    this.uSp = 1;
    this.uSm = false;
    this.uSq = false;
    this.uSr = false;
    this.uSs = 0;
    this.uSj = null;
    this.gmC = new IListener() {};
    this.ifz = false;
    this.gmA = new com.tencent.mm.modelgeo.b.a()
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
        if (NearbyFriendsUI.this.ifz)
        {
          if (NearbyFriendsUI.f(NearbyFriendsUI.this) != null)
          {
            NearbyFriendsUI.f(NearbyFriendsUI.this).dismiss();
            NearbyFriendsUI.a(NearbyFriendsUI.this, null);
          }
          com.tencent.mm.plugin.report.service.g.Wn(11);
          AppMethodBeat.o(89846);
          return false;
        }
        boolean bool;
        if (paramAnonymousBoolean)
        {
          if (NearbyFriendsUI.f(NearbyFriendsUI.this) != null) {
            NearbyFriendsUI.f(NearbyFriendsUI.this).setMessage(NearbyFriendsUI.this.getString(2131763442));
          }
          NearbyFriendsUI.a(NearbyFriendsUI.this, new NearbyFriendsUI.b(NearbyFriendsUI.this, paramAnonymousFloat2, paramAnonymousFloat1, (int)paramAnonymousDouble2));
          com.tencent.mm.modelstat.e locale = com.tencent.mm.modelstat.e.bge();
          if (paramAnonymousInt == 0)
          {
            paramAnonymousBoolean = false;
            if (NearbyFriendsUI.g(NearbyFriendsUI.this) != null) {
              break label264;
            }
            bool = false;
            label163:
            locale.a(2001, paramAnonymousBoolean, bool, paramAnonymousFloat1, paramAnonymousFloat2, (int)paramAnonymousDouble2);
            NearbyFriendsUI.a(NearbyFriendsUI.this, new com.tencent.mm.plugin.nearby.a.c(NearbyFriendsUI.h(NearbyFriendsUI.this), NearbyFriendsUI.i(NearbyFriendsUI.this).iUZ, NearbyFriendsUI.i(NearbyFriendsUI.this).iUY, NearbyFriendsUI.i(NearbyFriendsUI.this).accuracy, paramAnonymousInt, "", ""));
            com.tencent.mm.kernel.g.azz().a(NearbyFriendsUI.b(NearbyFriendsUI.this), 0);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(89846);
          return false;
          paramAnonymousBoolean = true;
          break;
          label264:
          bool = NearbyFriendsUI.g(NearbyFriendsUI.this).iVk;
          break label163;
          com.tencent.mm.plugin.report.service.g.Wn(11);
          if (NearbyFriendsUI.f(NearbyFriendsUI.this) != null)
          {
            NearbyFriendsUI.f(NearbyFriendsUI.this).dismiss();
            NearbyFriendsUI.a(NearbyFriendsUI.this, null);
          }
          NearbyFriendsUI.this.findViewById(2131305245).setVisibility(0);
          NearbyFriendsUI.j(NearbyFriendsUI.this).setVisibility(8);
          NearbyFriendsUI.k(NearbyFriendsUI.this);
          if ((!NearbyFriendsUI.l(NearbyFriendsUI.this)) && (!com.tencent.mm.modelgeo.d.bcc()))
          {
            NearbyFriendsUI.m(NearbyFriendsUI.this);
            com.tencent.mm.ui.base.h.a(NearbyFriendsUI.this, NearbyFriendsUI.this.getString(2131761461), NearbyFriendsUI.this.getString(2131755998), NearbyFriendsUI.this.getString(2131762043), NearbyFriendsUI.this.getString(2131755761), false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(89845);
                com.tencent.mm.modelgeo.d.cZ(NearbyFriendsUI.this);
                AppMethodBeat.o(89845);
              }
            }, null);
          }
        }
      }
    };
    AppMethodBeat.o(89866);
  }
  
  private void dlx()
  {
    int j = 0;
    AppMethodBeat.i(89877);
    Object localObject1 = new LinkedList();
    int i = 0;
    while (i < this.sNv.size())
    {
      if (!d.JD(((chi)this.sNv.get(i)).kdY)) {
        ((List)localObject1).add(this.sNv.get(i));
      }
      i += 1;
    }
    this.sNv.clear();
    this.sNv = ((List)localObject1);
    Log.i("MicroMsg.NearbyFriend", "insertPoiItemList()");
    label130:
    Object localObject2;
    List localList;
    if (!this.sNv.isEmpty())
    {
      i = 1;
      localObject1 = this.uRY.keySet().iterator();
      do
      {
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (String)((Iterator)localObject1).next();
        } while (i == 0);
        localObject2 = (a)this.uRY.get(localObject2);
      } while ((((a)localObject2).oBV) || ((((a)localObject2).uSa > 0) && (((a)localObject2).uSe >= ((a)localObject2).uSa)) || (((a)localObject2).qdp >= ((a)localObject2).uSb));
      localList = this.sNv;
      if ((((a)localObject2).pos >= 0) && (((a)localObject2).pos <= this.sNv.size())) {
        break label303;
      }
    }
    label303:
    for (int k = this.sNv.size();; k = ((a)localObject2).pos + j)
    {
      localList.add(k, d.h(((a)localObject2).id, ((a)localObject2).icon, ((a)localObject2).name, ((a)localObject2).desc, ((a)localObject2).uSd));
      j += 1;
      break label130;
      i = 0;
      break;
    }
    AppMethodBeat.o(89877);
  }
  
  private void ewW()
  {
    AppMethodBeat.i(89869);
    View localView;
    Object localObject;
    int i;
    if (com.tencent.mm.bp.a.glC())
    {
      if (this.uSj != null)
      {
        this.khv.removeHeaderView(this.uSj);
        this.uSj = null;
      }
      localView = View.inflate(this, 2131495818, null);
      localObject = (TextView)localView.findViewById(2131307220);
      com.tencent.mm.kernel.g.aAf().azk();
      i = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiv().ctM();
      if (i != 0) {
        break label124;
      }
      localView.setVisibility(8);
      localView = null;
    }
    for (;;)
    {
      this.uSj = localView;
      if (this.uSj != null) {
        this.khv.addHeaderView(this.uSj);
      }
      AppMethodBeat.o(89869);
      return;
      label124:
      localView.setVisibility(0);
      ((TextView)localObject).setText(getResources().getQuantityString(2131623965, i, new Object[] { Integer.valueOf(i) }));
      localObject = (ImageView)localView.findViewById(2131304534);
      bx localbx = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiv().eiG();
      if (localbx != null) {
        a.b.c((ImageView)localObject, localbx.field_sayhiuser);
      }
      localView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(89847);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/nearby/ui/NearbyFriendsUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
  
  private void ewX()
  {
    AppMethodBeat.i(89871);
    com.tencent.mm.plugin.nearby.a.jRt.bY(this);
    AppMethodBeat.o(89871);
  }
  
  private void getData()
  {
    AppMethodBeat.i(89868);
    this.uSr = false;
    AppCompatActivity localAppCompatActivity = getContext();
    getString(2131755998);
    this.tipDialog = com.tencent.mm.ui.base.h.a(localAppCompatActivity, getString(2131763451), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(89844);
        NearbyFriendsUI.this.ifz = true;
        com.tencent.mm.plugin.report.service.g.Wn(11);
        if (NearbyFriendsUI.b(NearbyFriendsUI.this) != null) {
          com.tencent.mm.kernel.g.azz().a(NearbyFriendsUI.b(NearbyFriendsUI.this));
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
    this.ifz = false;
    if (this.gmt != null) {
      this.gmt.a(this.gmA, true);
    }
    AppMethodBeat.o(89868);
  }
  
  public int getLayoutId()
  {
    return 2131495814;
  }
  
  public void initView()
  {
    AppMethodBeat.i(89870);
    this.khv = ((ListView)findViewById(2131305246));
    this.AAa = new c(this);
    Object localObject = this.khv;
    if (this.uSh == null)
    {
      this.uSh = new LinearLayout(this);
      this.uSh.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      ((LinearLayout)this.uSh).setGravity(17);
    }
    this.uSm = true;
    ((ListView)localObject).addHeaderView(this.uSh);
    localObject = com.tencent.mm.n.h.aqJ().getValue("LBSShowBindPhone");
    if ((localObject != null) && (((String)localObject).length() > 0)) {}
    try
    {
      this.uSn = Integer.valueOf((String)localObject).intValue();
      localObject = (String)com.tencent.mm.kernel.g.aAh().azQ().get(6, null);
      if ((localObject != null) && (((String)localObject).length() > 0)) {
        this.uSn = 0;
      }
      this.uSs = 0;
      if (com.tencent.mm.model.a.g.aWT().KR("3") != null)
      {
        localObject = com.tencent.mm.model.a.g.aWT().KR("3").value;
        locala = com.tencent.mm.plugin.account.friend.a.l.bnZ();
        if (((String)localObject).equals("0")) {
          this.uSs = 0;
        }
      }
      else
      {
        if (((this.uSn > 0) || (this.uSs > 0)) && (this.uSs != 1))
        {
          this.AAf = new BindMobileOrQQHeaderView(this);
          this.khv.addHeaderView(this.AAf);
        }
        this.khv.setAdapter(this.AAa);
        this.khv.setOnItemClickListener(new NearbyFriendsUI.10(this));
        this.khv.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(89849);
            if (NearbyFriendsUI.u(NearbyFriendsUI.this) != null)
            {
              paramAnonymousView = NearbyFriendsUI.u(NearbyFriendsUI.this);
              if (paramAnonymousView.kex != null) {
                paramAnonymousView.kex.onTouchEvent(paramAnonymousMotionEvent);
              }
            }
            AppMethodBeat.o(89849);
            return false;
          }
        });
        setBackBtn(new NearbyFriendsUI.12(this));
        setToTop(new NearbyFriendsUI.13(this));
        addIconOptionMenu(0, 2131690843, new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(89855);
            paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(NearbyFriendsUI.this, 1, false);
            paramAnonymousMenuItem.HLY = new o.g()
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
                  com.tencent.mm.kernel.g.aAh().azQ().set(16386, Integer.valueOf(NearbyFriendsUI.h(NearbyFriendsUI.this)));
                  NearbyFriendsUI.w(NearbyFriendsUI.this);
                  AppMethodBeat.o(89853);
                  return;
                  NearbyFriendsUI.a(NearbyFriendsUI.this, 3);
                  NearbyFriendsUI.v(NearbyFriendsUI.this);
                  com.tencent.mm.kernel.g.aAh().azQ().set(16386, Integer.valueOf(NearbyFriendsUI.h(NearbyFriendsUI.this)));
                  NearbyFriendsUI.w(NearbyFriendsUI.this);
                  AppMethodBeat.o(89853);
                  return;
                  NearbyFriendsUI.a(NearbyFriendsUI.this, 1);
                  NearbyFriendsUI.v(NearbyFriendsUI.this);
                  com.tencent.mm.kernel.g.aAh().azQ().set(16386, Integer.valueOf(NearbyFriendsUI.h(NearbyFriendsUI.this)));
                  NearbyFriendsUI.w(NearbyFriendsUI.this);
                  AppMethodBeat.o(89853);
                  return;
                  paramAnonymous2MenuItem = new Intent(NearbyFriendsUI.this, NearbySayHiListUI.class);
                  paramAnonymous2MenuItem.putExtra("k_say_hi_type", 2);
                  NearbyFriendsUI.this.startActivityForResult(paramAnonymous2MenuItem, 2009);
                  AppMethodBeat.o(89853);
                  return;
                  NearbyFriendsUI.b(NearbyFriendsUI.this, new com.tencent.mm.plugin.nearby.a.c(2, 0.0F, 0.0F, 0, 0, "", ""));
                  com.tencent.mm.kernel.g.azz().a(NearbyFriendsUI.x(NearbyFriendsUI.this), 0);
                  paramAnonymous2MenuItem = NearbyFriendsUI.this;
                  AppCompatActivity localAppCompatActivity = NearbyFriendsUI.this.getContext();
                  NearbyFriendsUI.this.getString(2131755998);
                  NearbyFriendsUI.a(paramAnonymous2MenuItem, com.tencent.mm.ui.base.h.a(localAppCompatActivity, NearbyFriendsUI.this.getString(2131763440), true, new DialogInterface.OnCancelListener()
                  {
                    public final void onCancel(DialogInterface paramAnonymous3DialogInterface)
                    {
                      AppMethodBeat.i(89852);
                      com.tencent.mm.kernel.g.azz().a(NearbyFriendsUI.x(NearbyFriendsUI.this));
                      AppMethodBeat.o(89852);
                    }
                  }));
                }
              }
            };
            paramAnonymousMenuItem.HLX = new o.f()
            {
              public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramAnonymous2m)
              {
                AppMethodBeat.i(89854);
                paramAnonymous2m.kV(-1, 2131763454);
                paramAnonymous2m.kV(-1, 2131763453);
                paramAnonymous2m.kV(-1, 2131763452);
                paramAnonymous2m.kV(-1, 2131764876);
                paramAnonymous2m.kV(-1, 2131763436);
                AppMethodBeat.o(89854);
              }
            };
            paramAnonymousMenuItem.dGm();
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
        this.uSn = 0;
        continue;
        if (localException.equals("2"))
        {
          if (locala == l.a.keM)
          {
            this.uSs = 2;
            com.tencent.mm.model.a.f.KV("3");
          }
        }
        else if ((localException.equals("1")) && (locala == l.a.keJ))
        {
          this.uSs = 2;
          com.tencent.mm.model.a.f.KV("3");
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
        this.AAd = false;
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
    com.tencent.mm.plugin.report.service.g.Wl(11);
    super.onCreate(paramBundle);
    setMMTitle(2131763462);
    com.tencent.mm.kernel.g.azz().a(148, this);
    com.tencent.mm.kernel.g.azz().a(376, this);
    com.tencent.mm.kernel.g.azz().a(1087, this);
    this.gmt = com.tencent.mm.modelgeo.d.bca();
    initView();
    this.AAe = new String[] { getResources().getString(2131763454), getResources().getString(2131763453), getResources().getString(2131763452), getResources().getString(2131764876) };
    this.uSp = Util.nullAs((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(16386, null), 1);
    Object localObject1;
    int j;
    int i;
    label232:
    Object localObject2;
    if (this.uSp == 3)
    {
      setTitleLogo(0, 2131690428);
      getData();
      if (!LocaleUtil.isSimplifiedChineseAppLang()) {
        break label797;
      }
      localObject1 = XmlParser.parseXml(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.rZT, ""), "lbsads", null);
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
      ((a)localObject2).uSa = Util.getInt((String)((Map)localObject1).get(paramBundle + ".$close_times"), 0);
      ((a)localObject2).uSb = Util.getInt((String)((Map)localObject1).get(paramBundle + ".$show_times"), 2147483647);
      ((a)localObject2).name = ((String)((Map)localObject1).get(paramBundle + ".name"));
      ((a)localObject2).desc = ((String)((Map)localObject1).get(paramBundle + ".desc"));
      ((a)localObject2).icon = ((String)((Map)localObject1).get(paramBundle + ".icon"));
      ((a)localObject2).uSc = Util.getInt((String)((Map)localObject1).get(paramBundle + ".jump.$type"), 0);
      ((a)localObject2).uSd = ((String)((Map)localObject1).get(paramBundle + ".jump"));
      this.uRY.put(((a)localObject2).id, localObject2);
      i += 1;
      break label232;
      if (this.uSp == 4)
      {
        setTitleLogo(0, 2131690427);
        break;
      }
      setTitleLogo(0, 0);
      this.uSp = 1;
      break;
    }
    label675:
    paramBundle = com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Oje, null);
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
          localObject2 = (a)this.uRY.get(localObject1[0]);
          if (localObject2 != null)
          {
            ((a)localObject2).uSe = Util.getInt(localObject1[1], 0);
            ((a)localObject2).qdp = Util.getInt(localObject1[2], 0);
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
    if (this.uSs > 0) {
      com.tencent.mm.model.a.f.KW("3");
    }
    com.tencent.mm.plugin.report.service.g.Wn(11);
    com.tencent.mm.kernel.g.azz().b(148, this);
    com.tencent.mm.kernel.g.azz().b(376, this);
    com.tencent.mm.kernel.g.azz().b(1087, this);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if (this.gmt != null) {
      this.gmt.c(this.gmA);
    }
    p.aYD().cancel();
    Object localObject;
    if (this.AAa != null)
    {
      localObject = this.AAa;
      if (((c)localObject).kex != null)
      {
        ((c)localObject).kex.detach();
        ((c)localObject).kex = null;
      }
    }
    if (this.sNv.size() > 0)
    {
      Iterator localIterator = this.uRY.values().iterator();
      localObject = "";
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        localObject = new StringBuilder().append((String)localObject).append("|").append(locala.id).append(":").append(locala.uSe).append(":");
        int i = locala.qdp + 1;
        locala.qdp = i;
        localObject = i;
        com.tencent.mm.plugin.report.service.h.CyF.a(17431, new Object[] { locala.id, Integer.valueOf(locala.uSf + 1) });
      }
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Oje, localObject);
    }
    super.onDestroy();
    AppMethodBeat.o(89875);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(89873);
    super.onPause();
    if (this.gmt != null) {
      this.gmt.c(this.gmA);
    }
    EventCenter.instance.removeListener(this.gmC);
    AppMethodBeat.o(89873);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(89874);
    super.onResume();
    if (this.gmt != null) {
      this.gmt.a(this.gmA, true);
    }
    ewW();
    this.AAa.notifyDataSetChanged();
    com.tencent.mm.kernel.g.aAf().azk();
    if (((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiv().ctM() == 0) {
      this.khv.removeHeaderView(this.uSk);
    }
    EventCenter.instance.addListener(this.gmC);
    AppMethodBeat.o(89874);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
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
      int i = ((com.tencent.mm.plugin.nearby.a.c)paramq).Vj();
      if ((this.AAb == null) && ((i == 1) || (i == 3) || (i == 4)))
      {
        AppMethodBeat.o(89876);
        return;
      }
      if (((i == 1) || (i == 3) || (i == 4)) && (this.AAd))
      {
        Log.v("MicroMsg.NearbyFriend", "onSceneEnd data already requested, code=%d", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(89876);
        return;
      }
      if ((this.AzP == null) && (i == 2))
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
          this.sNv = ((com.tencent.mm.plugin.nearby.a.c)paramq).ewT();
          if ((this.sNv == null) || (this.sNv.size() == 0))
          {
            findViewById(2131305248).setVisibility(0);
            this.khv.setVisibility(8);
            ewX();
            com.tencent.mm.plugin.report.service.g.Wn(11);
            if (this.uSp != 3) {
              break label766;
            }
            setTitleLogo(0, 2131690428);
            this.AAd = true;
            this.AAb = null;
          }
        }
        else
        {
          if (((com.tencent.mm.plugin.nearby.a.c)paramq).Vj() == 2)
          {
            com.tencent.mm.ui.base.h.d(getContext(), getString(2131763439), "", new NearbyFriendsUI.5(this));
            this.AzP = null;
          }
          if (!((com.tencent.mm.plugin.nearby.a.c)paramq).ewR()) {
            break label810;
          }
          paramString = getString(2131763466);
          paramInt1 = ((com.tencent.mm.plugin.nearby.a.c)paramq).ewS();
          if (this.uSh != null)
          {
            if (this.AAg != null) {
              break label799;
            }
            this.AAg = View.inflate(this, 2131495819, null);
            this.uSh.addView(this.AAg);
            this.AAg.setOnClickListener(new NearbyFriendsUI.2(this));
            ((TextView)this.AAg.findViewById(2131305254)).setText(paramString);
            if (paramInt1 != 0) {
              ((TextView)this.AAg.findViewById(2131305253)).setText(String.format(getResources().getQuantityString(2131623958, paramInt1, new Object[] { Integer.valueOf(paramInt1) }), new Object[0]));
            }
          }
        }
        for (;;)
        {
          this.uSq = true;
          AppMethodBeat.o(89876);
          return;
          paramString = new LinkedList();
          localObject = this.sNv.iterator();
          paramInt1 = 0;
          while (((Iterator)localObject).hasNext())
          {
            chi localchi = (chi)((Iterator)localObject).next();
            if (((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().bjG(localchi.UserName))
            {
              paramString.add(paramInt1, localchi);
              paramInt1 += 1;
            }
            else if ((!Util.isNullOrNil(localchi.UserName)) && (!Util.isNullOrNil(localchi.MmJ)))
            {
              paramString.add(localchi);
            }
          }
          this.sNv.clear();
          this.sNv = paramString;
          if ((this.sNv == null) || (this.sNv.size() == 0))
          {
            findViewById(2131305248).setVisibility(0);
            this.khv.setVisibility(8);
            break;
          }
          findViewById(2131305248).setVisibility(8);
          dlx();
          this.AAa.notifyDataSetChanged();
          if (this.AAa.getCount() > 0) {
            this.khv.setSelection(0);
          }
          this.khv.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(89842);
              com.tencent.mm.plugin.report.service.g.Wm(11);
              AppMethodBeat.o(89842);
            }
          });
          break;
          label766:
          if (this.uSp == 4)
          {
            setTitleLogo(0, 2131690427);
            break label319;
          }
          setTitleLogo(0, 0);
          this.uSp = 1;
          break label319;
          label799:
          this.AAg.setVisibility(0);
          break label452;
          label810:
          if ((this.AAg != null) && (this.uSh != null)) {
            this.AAg.setVisibility(8);
          }
        }
      }
      if ((i == 1) || (i == 3) || (i == 4))
      {
        localObject = (TextView)findViewById(2131305248);
        ((TextView)localObject).setVisibility(0);
        ewX();
        if ((paramString == null) || (paramString.length() <= 0)) {
          break label1164;
        }
      }
    }
    label1164:
    for (paramString = com.tencent.mm.h.a.Dk(paramString);; paramString = null)
    {
      if ((paramString != null) && (paramString.desc != null) && (paramString.desc.length() > 0)) {
        ((TextView)localObject).setText(paramString.desc);
      }
      for (;;)
      {
        this.khv.setVisibility(8);
        this.AAb = null;
        if (((com.tencent.mm.plugin.nearby.a.c)paramq).Vj() == 2)
        {
          Toast.makeText(this, 2131763438, 1).show();
          this.AzP = null;
        }
        AppMethodBeat.o(89876);
        return;
        if (paramInt2 == -2001) {
          ((TextView)localObject).setText(getString(2131763441));
        } else {
          ((TextView)localObject).setText(getString(2131763445));
        }
      }
      if (paramq.getType() == 376)
      {
        if (((com.tencent.mm.plugin.nearby.a.d)paramq).Vj() != 1)
        {
          AppMethodBeat.o(89876);
          return;
        }
        if (this.tipDialog != null)
        {
          this.tipDialog.dismiss();
          this.tipDialog = null;
        }
        if ((paramInt1 == 0) && (paramInt2 == 0) && (((com.tencent.mm.plugin.nearby.a.d)paramq).jHa != null))
        {
          paramString = ((com.tencent.mm.plugin.nearby.a.d)paramq).jHa;
          com.tencent.mm.plugin.nearby.a.b.jc(paramString, ((com.tencent.mm.plugin.nearby.a.d)paramq).Azx);
          paramq = new Intent();
          paramq.putExtra("Chat_User", paramString);
          com.tencent.mm.plugin.nearby.a.jRt.e(paramq, this);
          AppMethodBeat.o(89876);
          return;
        }
        com.tencent.mm.ui.base.h.a(getContext(), 2131763464, 2131755998, new NearbyFriendsUI.6(this));
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
    String name;
    boolean oBV = false;
    int pos;
    int qdp;
    int uSa;
    int uSb;
    int uSc;
    String uSd;
    int uSe;
    int uSf = -1;
  }
  
  final class b
  {
    public int accuracy;
    public float iUY;
    public float iUZ;
    
    public b(float paramFloat1, float paramFloat2, int paramInt)
    {
      this.iUY = paramFloat1;
      this.iUZ = paramFloat2;
      this.accuracy = paramInt;
    }
  }
  
  final class c
    extends BaseAdapter
  {
    private final Context context;
    com.tencent.mm.ui.applet.b kex;
    private b.b kez;
    
    public c(Context paramContext)
    {
      AppMethodBeat.i(89860);
      this.kex = new com.tencent.mm.ui.applet.b(new NearbyFriendsUI.c.1(this));
      this.kez = null;
      this.context = paramContext;
      AppMethodBeat.o(89860);
    }
    
    public final chi JC(int paramInt)
    {
      AppMethodBeat.i(89863);
      chi localchi = (chi)NearbyFriendsUI.s(NearbyFriendsUI.this).get(paramInt);
      AppMethodBeat.o(89863);
      return localchi;
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
      if (this.kez == null) {
        this.kez = new b.b()
        {
          public final int bnW()
          {
            AppMethodBeat.i(89858);
            int i = NearbyFriendsUI.c.this.getCount();
            AppMethodBeat.o(89858);
            return i;
          }
          
          public final String vg(int paramAnonymousInt)
          {
            AppMethodBeat.i(89857);
            if ((paramAnonymousInt < 0) || (paramAnonymousInt >= NearbyFriendsUI.c.this.getCount()))
            {
              Log.e("MicroMsg.NearbyFriend", "pos is invalid");
              AppMethodBeat.o(89857);
              return null;
            }
            Object localObject = NearbyFriendsUI.c.this.JC(paramAnonymousInt);
            if (localObject == null)
            {
              AppMethodBeat.o(89857);
              return null;
            }
            localObject = ((chi)localObject).UserName;
            AppMethodBeat.o(89857);
            return localObject;
          }
        };
      }
      if (this.kex != null) {
        this.kex.a(paramInt, this.kez);
      }
      Object localObject1;
      label365:
      Object localObject2;
      if (paramView == null)
      {
        paramViewGroup = new NearbyFriendsUI.e();
        paramView = View.inflate(this.context, 2131495816, null);
        paramViewGroup.kcS = ((TextView)paramView.findViewById(2131305247));
        paramViewGroup.uSH = ((TextView)paramView.findViewById(2131305250));
        paramViewGroup.uSG = ((TextView)paramView.findViewById(2131305242));
        paramViewGroup.keC = ((ImageView)paramView.findViewById(2131305241));
        paramViewGroup.keD = ((TextView)paramView.findViewById(2131305244));
        paramViewGroup.uSI = ((ImageView)paramView.findViewById(2131305252));
        paramViewGroup.uSJ = ((ImageView)paramView.findViewById(2131305251));
        paramViewGroup.uSM = ((ImageView)paramView.findViewById(2131305238));
        paramViewGroup.uSN = ((ImageView)paramView.findViewById(2131305239));
        paramViewGroup.uSO = ((ImageView)paramView.findViewById(2131305240));
        paramViewGroup.hTd = ((ImageView)paramView.findViewById(2131298770));
        localObject1 = paramViewGroup.uSJ.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).height = com.tencent.mm.cb.a.aG(this.context, 2131165534);
        ((ViewGroup.LayoutParams)localObject1).width = com.tencent.mm.cb.a.aG(this.context, 2131165534);
        paramViewGroup.uSJ.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        paramViewGroup.uSL = ((ImageView)paramView.findViewById(2131305249));
        paramView.setTag(paramViewGroup);
        localObject1 = (chi)NearbyFriendsUI.s(NearbyFriendsUI.this).get(paramInt);
        paramViewGroup.kcS.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.context, ((chi)localObject1).oUJ, paramViewGroup.kcS.getTextSize()));
        if (NearbyFriendsUI.h(NearbyFriendsUI.this) != 1) {
          break label859;
        }
        switch (((chi)localObject1).kdY)
        {
        default: 
          paramViewGroup.uSL.setVisibility(8);
          if (((chi)localObject1).MmK != 0)
          {
            paramViewGroup.uSI.setVisibility(0);
            localObject2 = BackwardSupportUtil.BitmapFactory.decodeFile(ay.a.iDs.rV(((chi)localObject1).MmK), 2.0F);
            paramViewGroup.uSI.setImageBitmap((Bitmap)localObject2);
            paramViewGroup.uSL.setVisibility(8);
            label418:
            paramViewGroup.uSG.setText(((chi)localObject1).MmJ);
            paramViewGroup.uSM.setVisibility(8);
            paramViewGroup.uSN.setVisibility(8);
            paramViewGroup.uSO.setVisibility(8);
            paramViewGroup.hTd.setVisibility(8);
            if ((localObject1 instanceof com.tencent.mm.plugin.nearby.a.a))
            {
              localObject2 = ((com.tencent.mm.plugin.nearby.a.a)localObject1).Azu;
              if ((localObject2 == null) || (((LinkedList)localObject2).size() != 1)) {
                break label883;
              }
              paramViewGroup.uSM.setVisibility(0);
              NearbyFriendsUI.u(paramViewGroup.uSM, (String)((LinkedList)localObject2).get(0));
              label522:
              localObject2 = (NearbyFriendsUI.a)NearbyFriendsUI.t(NearbyFriendsUI.this).get(((chi)localObject1).UserName);
              if (localObject2 != null)
              {
                if (((NearbyFriendsUI.a)localObject2).uSf != -1) {
                  break label1037;
                }
                paramInt = 0;
                label560:
                ((NearbyFriendsUI.a)localObject2).uSf = paramInt;
                if (((NearbyFriendsUI.a)localObject2).uSa > 0) {
                  paramViewGroup.hTd.setVisibility(0);
                }
              }
              paramViewGroup.hTd.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(89859);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bm(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/nearby/ui/NearbyFriendsUI$NearbyFriendAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                  paramAnonymousView = (NearbyFriendsUI.a)NearbyFriendsUI.t(NearbyFriendsUI.this).get(this.AAo.UserName);
                  if (paramAnonymousView != null)
                  {
                    paramAnonymousView.uSe += 1;
                    paramAnonymousView.oBV = true;
                    paramAnonymousView.uSf |= 0x2;
                  }
                  NearbyFriendsUI.A(NearbyFriendsUI.this);
                  NearbyFriendsUI.c.this.notifyDataSetChanged();
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearby/ui/NearbyFriendsUI$NearbyFriendAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(89859);
                }
              });
            }
            if ((((chi)localObject1).keb != null) && (!((chi)localObject1).keb.trim().equals(""))) {
              break label1046;
            }
            paramViewGroup.uSH.setVisibility(8);
            label633:
            if ((((chi)localObject1).MmQ == null) || ((((chi)localObject1).MmQ.kej & 0x1) <= 0)) {
              break label1083;
            }
            paramViewGroup.uSJ.setVisibility(0);
            label662:
            if (!NearbyFriendsUI.d.JD(((chi)localObject1).kdY)) {
              break label1095;
            }
            paramViewGroup.keC.setImageBitmap(null);
            localObject2 = new c.a();
            ((c.a)localObject2).prefixPath = com.tencent.mm.plugin.image.d.aSY();
            ((c.a)localObject2).jbf = true;
            ((c.a)localObject2).hZF = true;
            localObject2 = ((c.a)localObject2).bdv();
            com.tencent.mm.av.q.bcV().a(((chi)localObject1).Lis, paramViewGroup.keC, (com.tencent.mm.av.a.a.c)localObject2);
            if (Util.isNullOrNil(((chi)localObject1).ked)) {
              break label1283;
            }
            paramViewGroup.keD.setText(((chi)localObject1).ked);
            paramViewGroup.keD.setVisibility(0);
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
        paramViewGroup.uSL.setVisibility(0);
        paramViewGroup.uSL.setImageResource(2131690428);
        paramViewGroup.uSL.setContentDescription(this.context.getString(2131762865));
        break label365;
        paramViewGroup.uSL.setVisibility(0);
        paramViewGroup.uSL.setImageResource(2131690427);
        paramViewGroup.uSL.setContentDescription(this.context.getString(2131759372));
        break label365;
        label859:
        paramViewGroup.uSL.setVisibility(8);
        break label365;
        paramViewGroup.uSI.setVisibility(8);
        break label418;
        label883:
        if ((localObject2 != null) && (((LinkedList)localObject2).size() == 2))
        {
          paramViewGroup.uSM.setVisibility(0);
          paramViewGroup.uSN.setVisibility(0);
          NearbyFriendsUI.u(paramViewGroup.uSM, (String)((LinkedList)localObject2).get(0));
          NearbyFriendsUI.u(paramViewGroup.uSN, (String)((LinkedList)localObject2).get(1));
          break label522;
        }
        if ((localObject2 == null) || (((LinkedList)localObject2).size() < 3)) {
          break label522;
        }
        paramViewGroup.uSM.setVisibility(0);
        paramViewGroup.uSN.setVisibility(0);
        paramViewGroup.uSO.setVisibility(0);
        NearbyFriendsUI.u(paramViewGroup.uSM, (String)((LinkedList)localObject2).get(0));
        NearbyFriendsUI.u(paramViewGroup.uSN, (String)((LinkedList)localObject2).get(1));
        NearbyFriendsUI.u(paramViewGroup.uSO, (String)((LinkedList)localObject2).get(2));
        break label522;
        label1037:
        paramInt = ((NearbyFriendsUI.a)localObject2).uSf;
        break label560;
        label1046:
        paramViewGroup.uSH.setVisibility(0);
        paramViewGroup.uSH.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.context, ((chi)localObject1).keb, paramViewGroup.uSH.getTextSize()));
        break label633;
        label1083:
        paramViewGroup.uSJ.setVisibility(8);
        break label662;
        label1095:
        a.b.c(paramViewGroup.keC, ((chi)localObject1).UserName);
        if (((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().bjG(((chi)localObject1).UserName))
        {
          paramViewGroup.keD.setVisibility(0);
          if (as.akh(((chi)localObject1).MmK))
          {
            paramViewGroup.keD.setText(NearbyFriendsUI.this.getString(2131763444));
          }
          else
          {
            as localas = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().bjJ(((chi)localObject1).UserName);
            Context localContext;
            if (localas != null)
            {
              localObject2 = paramViewGroup.kcS;
              localContext = this.context;
              if (!Util.isNullOrNil(localas.arJ())) {
                break label1273;
              }
            }
            label1273:
            for (localObject1 = ((chi)localObject1).oUJ;; localObject1 = localas.arJ())
            {
              ((TextView)localObject2).setText(com.tencent.mm.pluginsdk.ui.span.l.b(localContext, (CharSequence)localObject1, paramViewGroup.kcS.getTextSize()));
              paramViewGroup.keD.setText(NearbyFriendsUI.this.getString(2131763449));
              break;
            }
          }
        }
        else
        {
          label1283:
          paramViewGroup.keD.setVisibility(8);
        }
      }
    }
  }
  
  static final class d
  {
    public static int uSE = 10000;
    
    public static boolean JD(int paramInt)
    {
      return paramInt == uSE;
    }
    
    public static chi h(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    {
      AppMethodBeat.i(89865);
      com.tencent.mm.plugin.nearby.a.a locala = new com.tencent.mm.plugin.nearby.a.a();
      locala.kdY = uSE;
      locala.UserName = paramString1;
      locala.Lis = paramString2;
      locala.MmJ = paramString4;
      locala.oUJ = paramString3;
      locala.kdZ = paramString5;
      AppMethodBeat.o(89865);
      return locala;
    }
  }
  
  static final class e
  {
    ImageView hTd;
    TextView kcS;
    ImageView keC;
    TextView keD;
    TextView uSG;
    TextView uSH;
    ImageView uSI;
    ImageView uSJ;
    ImageView uSL;
    ImageView uSM;
    ImageView uSN;
    ImageView uSO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI
 * JD-Core Version:    0.7.0.1
 */