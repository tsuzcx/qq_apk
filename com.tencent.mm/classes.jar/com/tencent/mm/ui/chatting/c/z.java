package com.tencent.mm.ui.chatting.c;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ActionBarContainer;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.p;
import com.tencent.mm.g.a.xh;
import com.tencent.mm.g.b.a.ct;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.ar.b.a;
import com.tencent.mm.model.az;
import com.tencent.mm.model.b.b.a;
import com.tencent.mm.model.b.b.b;
import com.tencent.mm.plugin.newtips.PluginNewTips.a;
import com.tencent.mm.plugin.newtips.a.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.protocal.protobuf.dhn;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.AppBrandNotifySettingsUI;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.ServiceNotifySettingsUI;
import com.tencent.mm.ui.SingleChatInfoUI;
import com.tencent.mm.ui.a.1;
import com.tencent.mm.ui.a.2;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ad;
import com.tencent.mm.ui.chatting.c.b.aa;
import com.tencent.mm.ui.chatting.c.b.f;
import com.tencent.mm.ui.chatting.c.b.y;
import com.tencent.mm.ui.s.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.ui.x;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.chatting.c.a.a(foJ=com.tencent.mm.ui.chatting.c.b.w.class)
public class z
  extends a
  implements com.tencent.mm.ui.chatting.c.b.w
{
  private final k.a HSK;
  private boolean HSN;
  protected LinearLayout HWe;
  protected LinearLayout HWf;
  private List<String> HWg;
  private String HWh;
  public com.tencent.mm.ui.v HWi;
  private com.tencent.mm.ui.a HWj;
  private View HWk;
  private a HWl;
  final x HWm;
  private b.a HWn;
  private Runnable HWo;
  private final com.tencent.mm.aj.e.a HWp;
  final int HWq;
  final int HWr;
  final MenuItem.OnMenuItemClickListener HWs;
  private View HWt;
  private View HWu;
  private MenuItem.OnMenuItemClickListener backListener;
  private ActionBarContainer mActionBarContainer;
  private int xAq;
  
  public z()
  {
    AppMethodBeat.i(35388);
    this.HWg = new LinkedList();
    this.xAq = 0;
    this.mActionBarContainer = null;
    this.HWi = null;
    this.HSN = false;
    this.HWm = new b();
    this.HWn = new b.a()
    {
      public final void aAb()
      {
        AppMethodBeat.i(179915);
        com.tencent.mm.ui.chatting.d.a.foS().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(35371);
            az.ayM().axb();
            if (com.tencent.mm.model.b.b.a(b.b.hqx))
            {
              z.c(z.this);
              AppMethodBeat.o(35371);
              return;
            }
            z.d(z.this);
            AppMethodBeat.o(35371);
          }
        });
        AppMethodBeat.o(179915);
      }
    };
    this.HWo = null;
    this.HWp = new com.tencent.mm.aj.e.a()
    {
      public final void Af(final String paramAnonymousString)
      {
        AppMethodBeat.i(179917);
        com.tencent.mm.ui.chatting.d.a.foS().removeCallbacks(z.e(z.this));
        com.tencent.mm.ui.chatting.d.a.foS().postDelayed(z.a(z.this, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(179916);
            if ((!bs.isNullOrNil(z.f(z.this))) && (!bs.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals(z.f(z.this)))) {
              z.this.xk(false);
            }
            AppMethodBeat.o(179916);
          }
        }), 1000L);
        AppMethodBeat.o(179917);
      }
    };
    this.HSK = new k.a()
    {
      public final void a(String paramAnonymousString, m paramAnonymousm)
      {
        AppMethodBeat.i(179918);
        ac.v("MicroMsg.ChattingUI.HeaderComponent", "roommember watcher notify ".concat(String.valueOf(paramAnonymousString)));
        if ((z.this.cLy.foQ()) && (!bs.isNullOrNil(paramAnonymousString)))
        {
          z.this.fnC();
          z.this.fnF();
        }
        AppMethodBeat.o(179918);
      }
    };
    this.backListener = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(35381);
        boolean bool = z.this.cLy.HZF.fkI();
        AppMethodBeat.o(35381);
        return bool;
      }
    };
    this.HWq = 1;
    this.HWr = 2;
    this.HWs = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(179922);
        xh localxh = new xh();
        localxh.dAb.dgL = 5;
        localxh.dAb.talker = z.this.cLy.AzG.field_username;
        localxh.dAb.context = z.this.cLy.HZF.getContext();
        if (paramAnonymousMenuItem.getItemId() == 1) {
          localxh.dAb.dzX = 4;
        }
        for (;;)
        {
          com.tencent.mm.sdk.b.a.GpY.l(localxh);
          AppMethodBeat.o(179922);
          return true;
          if (paramAnonymousMenuItem.getItemId() == 2) {
            localxh.dAb.dzX = 2;
          }
        }
      }
    };
    this.HWt = null;
    this.HWu = null;
    AppMethodBeat.o(35388);
  }
  
  private View A(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(35406);
    if (this.HWk == null)
    {
      if (paramViewGroup == null) {}
      for (this.HWk = com.tencent.mm.ui.z.jD(this.cLy.HZF.getContext()).inflate(2131492921, null);; this.HWk = com.tencent.mm.ui.z.jD(this.cLy.HZF.getContext()).inflate(2131492921, paramViewGroup, false))
      {
        paramViewGroup = this.HWk;
        AppMethodBeat.o(35406);
        return paramViewGroup;
      }
    }
    if (this.HWk.getParent() == null)
    {
      paramViewGroup = this.HWk;
      AppMethodBeat.o(35406);
      return paramViewGroup;
    }
    if ((this.HWk.getParent() instanceof ViewGroup))
    {
      ((ViewGroup)this.HWk.getParent()).removeView(this.HWk);
      paramViewGroup = this.HWk;
      AppMethodBeat.o(35406);
      return paramViewGroup;
    }
    if (paramViewGroup == null) {}
    for (this.HWk = com.tencent.mm.ui.z.jD(this.cLy.HZF.getContext()).inflate(2131492921, null);; this.HWk = com.tencent.mm.ui.z.jD(this.cLy.HZF.getContext()).inflate(2131492921, paramViewGroup, false))
    {
      paramViewGroup = this.HWk;
      AppMethodBeat.o(35406);
      return paramViewGroup;
    }
  }
  
  private void a(int paramInt1, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    AppMethodBeat.i(35411);
    a(paramInt1, paramInt2, "", paramOnMenuItemClickListener);
    AppMethodBeat.o(35411);
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    AppMethodBeat.i(179927);
    s.a locala = this.cLy.HZF.findMenuInfo(0);
    if (bs.isNullOrNil(paramString))
    {
      if (locala == null)
      {
        this.cLy.HZF.addIconOptionMenu(0, paramInt1, paramInt2, paramOnMenuItemClickListener);
        AppMethodBeat.o(179927);
        return;
      }
      this.cLy.HZF.updateOptionMenu(0, paramInt1, paramInt2, paramOnMenuItemClickListener);
      AppMethodBeat.o(179927);
      return;
    }
    if (locala == null) {
      this.cLy.HZF.addIconOptionMenu(0, paramInt1, paramInt2, paramOnMenuItemClickListener);
    }
    for (paramOnMenuItemClickListener = this.cLy.HZF.findMenuInfo(0); paramOnMenuItemClickListener == null; paramOnMenuItemClickListener = locala)
    {
      ac.e("MicroMsg.ChattingUI.HeaderComponent", "updateMenuInfo menuInfo == null");
      AppMethodBeat.o(179927);
      return;
      this.cLy.HZF.updateOptionMenu(0, paramInt1, paramInt2, paramOnMenuItemClickListener);
    }
    this.HWl = new a(paramString, paramOnMenuItemClickListener);
    com.tencent.mm.plugin.newtips.a.dkb().h(this.HWl);
    com.tencent.mm.plugin.newtips.a.g.a(this.HWl);
    if (paramOnMenuItemClickListener.Hok) {
      com.tencent.mm.plugin.newtips.a.g.a(this.HWl, com.tencent.mm.plugin.newtips.a.k.vnt, true);
    }
    AppMethodBeat.o(179927);
  }
  
  private void a(ActionBar paramActionBar)
  {
    AppMethodBeat.i(35408);
    boolean bool = com.tencent.mm.ui.aj.DT();
    if (paramActionBar.getCustomView() != null)
    {
      Object localObject = (ImageView)paramActionBar.getCustomView().findViewById(2131296940);
      if ((localObject != null) && (bool))
      {
        if (((ImageView)localObject).getDrawable() != null) {
          ((ImageView)localObject).getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
        }
      }
      else
      {
        localObject = (TextView)paramActionBar.getCustomView().findViewById(2131305908);
        if (localObject != null)
        {
          com.tencent.mm.ui.aj.a(((TextView)localObject).getPaint(), 0.8F);
          if (bool) {
            ((TextView)localObject).setTextColor(this.cLy.HZF.getMMResources().getColor(2131099886));
          }
        }
        localObject = (TextView)paramActionBar.getCustomView().findViewById(2131305509);
        if ((localObject != null) && (bool)) {
          ((TextView)localObject).setTextColor(this.cLy.HZF.getMMResources().getColor(2131099886));
        }
        localObject = (ImageView)paramActionBar.getCustomView().findViewById(2131302623);
        if ((localObject != null) && (bool))
        {
          if (((ImageView)localObject).getDrawable() == null) {
            break label249;
          }
          ((ImageView)localObject).getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
        }
      }
      for (;;)
      {
        paramActionBar = (ImageView)paramActionBar.getCustomView().findViewById(2131303211);
        if ((paramActionBar == null) || (!bool)) {
          break label268;
        }
        if (paramActionBar.getDrawable() == null) {
          break label260;
        }
        paramActionBar.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
        AppMethodBeat.o(35408);
        return;
        ((ImageView)localObject).setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
        break;
        label249:
        ((ImageView)localObject).setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      }
      label260:
      paramActionBar.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
    }
    label268:
    AppMethodBeat.o(35408);
  }
  
  private String am(com.tencent.mm.storage.ai paramai)
  {
    AppMethodBeat.i(35403);
    if (paramai == null)
    {
      paramai = this.cLy.HZF.getContext().getString(2131756727);
      AppMethodBeat.o(35403);
      return paramai;
    }
    if (RegionCodeDecoder.aOy(paramai.getCountryCode()))
    {
      String str = paramai.getCity();
      if (!bs.isNullOrNil(str))
      {
        AppMethodBeat.o(35403);
        return str;
      }
      str = com.tencent.mm.model.v.wm(paramai.getProvince());
      if (!bs.isNullOrNil(str))
      {
        AppMethodBeat.o(35403);
        return str;
      }
      RegionCodeDecoder.fcs();
      paramai = RegionCodeDecoder.getLocName(paramai.getCountryCode());
      AppMethodBeat.o(35403);
      return paramai;
    }
    paramai = com.tencent.mm.model.v.wm(paramai.getProvince());
    if (!bs.isNullOrNil(paramai))
    {
      AppMethodBeat.o(35403);
      return paramai;
    }
    paramai = this.cLy.HZF.getContext().getString(2131756727);
    AppMethodBeat.o(35403);
    return paramai;
  }
  
  private void fkm()
  {
    AppMethodBeat.i(35399);
    if ((com.tencent.mm.model.w.wz(this.cLy.getTalkerUserName())) || (com.tencent.mm.model.w.wA(this.cLy.getTalkerUserName())) || (com.tencent.mm.model.w.wB(this.cLy.getTalkerUserName())))
    {
      com.tencent.mm.plugin.newtips.a.dke();
      boolean bool = com.tencent.mm.plugin.newtips.a.e.Kk(com.tencent.mm.plugin.newtips.a.d.vmS);
      this.cLy.HZF.addIconOptionMenu(0, 2131755135, 2131689511, Boolean.valueOf(bool).booleanValue(), this.HWm);
    }
    AppMethodBeat.o(35399);
  }
  
  private void fnB()
  {
    AppMethodBeat.i(35400);
    if (com.tencent.mm.kernel.g.agP().afY())
    {
      p.aBh().b(this.HWp);
      az.ayM();
      com.tencent.mm.model.c.awK().remove(this.HSK);
    }
    com.tencent.mm.ui.chatting.d.a.foS().removeCallbacks(this.HWo);
    com.tencent.mm.model.q.axq();
    if (this.HWl != null)
    {
      com.tencent.mm.plugin.newtips.a.dkb();
      i.i(this.HWl);
    }
    AppMethodBeat.o(35400);
  }
  
  private void fnE()
  {
    AppMethodBeat.i(35409);
    this.HWg.clear();
    this.HWg.add(this.cLy.HZF.getStringExtra("Chat_User"));
    AppMethodBeat.o(35409);
  }
  
  private void fnG()
  {
    AppMethodBeat.i(35413);
    if (this.cLy.HZF.getContext() == null)
    {
      ac.w("MicroMsg.ChattingUI.HeaderComponent", "getActivity is null");
      AppMethodBeat.o(35413);
      return;
    }
    fnM();
    ViewGroup localViewGroup = (ViewGroup)this.cLy.HZF.getContext().findViewById(2131298063);
    com.tencent.mm.pluginsdk.ui.b.a locala = com.tencent.mm.ui.conversation.a.e.a(this.cLy.HZF.getContext(), com.tencent.mm.ui.conversation.a.e.a.IHd, new Object[] { b.b.hqx });
    if ((localViewGroup != null) && (locala != null) && (locala.getView() != null) && (this.HWu == null))
    {
      this.HWu = locala.getView();
      localViewGroup.addView(this.HWu, new ViewGroup.LayoutParams(-1, -2));
    }
    AppMethodBeat.o(35413);
  }
  
  private void fnI()
  {
    AppMethodBeat.i(35415);
    if ((this.cLy.foQ()) || (this.HWe == null))
    {
      fnJ();
      AppMethodBeat.o(35415);
      return;
    }
    fnJ();
    com.tencent.mm.pluginsdk.ui.b.a locala2;
    if (this.HWe.getTag() == null)
    {
      locala2 = com.tencent.mm.ui.conversation.a.e.a(this.cLy.HZF.getContext(), com.tencent.mm.ui.conversation.a.e.a.IGR, new Object[] { this.cLy.getTalkerUserName(), this.cLy.fmy() });
      locala1 = locala2;
      if (locala2 != null)
      {
        locala1 = locala2;
        if (locala2.getView() != null) {
          this.HWe.addView(locala2.getView(), new ViewGroup.LayoutParams(-1, -2));
        }
      }
    }
    for (com.tencent.mm.pluginsdk.ui.b.a locala1 = locala2;; locala1 = (com.tencent.mm.pluginsdk.ui.b.a)this.HWe.getTag())
    {
      if (locala1 != null)
      {
        this.HWe.setVisibility(0);
        this.HWe.setTag(locala1);
      }
      h.wUl.f(11003, new Object[] { this.cLy.getTalkerUserName(), Integer.valueOf(1), Integer.valueOf(0) });
      AppMethodBeat.o(35415);
      return;
    }
  }
  
  private void fnJ()
  {
    AppMethodBeat.i(35416);
    this.HWe.setVisibility(8);
    if (this.HWf != null) {
      this.HWf.setVisibility(8);
    }
    AppMethodBeat.o(35416);
  }
  
  private void fnK()
  {
    AppMethodBeat.i(35417);
    if (this.cLy.HZF.getContext() == null)
    {
      ac.w("MicroMsg.ChattingUI.HeaderComponent", "getActivity is null");
      AppMethodBeat.o(35417);
      return;
    }
    fnL();
    ViewGroup localViewGroup = (ViewGroup)this.cLy.HZF.getContext().findViewById(2131298070);
    com.tencent.mm.pluginsdk.ui.b.a locala = com.tencent.mm.ui.conversation.a.e.a(this.cLy.HZF.getContext(), com.tencent.mm.ui.conversation.a.e.a.IGS, new Object[] { this.cLy.getTalkerUserName(), this.cLy.fmy(), Boolean.valueOf(this.cLy.foQ()) });
    if ((localViewGroup != null) && (locala != null) && (locala.getView() != null) && (this.HWt == null))
    {
      this.HWt = locala.getView();
      localViewGroup.addView(this.HWt, new ViewGroup.LayoutParams(-1, -2));
    }
    AppMethodBeat.o(35417);
  }
  
  private void fnL()
  {
    AppMethodBeat.i(35418);
    ViewGroup localViewGroup = (ViewGroup)this.cLy.HZF.getContext().findViewById(2131298070);
    if ((localViewGroup != null) && (this.HWt != null))
    {
      localViewGroup.removeView(this.HWt);
      this.HWt = null;
    }
    AppMethodBeat.o(35418);
  }
  
  private void fnM()
  {
    AppMethodBeat.i(35419);
    ViewGroup localViewGroup = (ViewGroup)this.cLy.HZF.getContext().findViewById(2131298063);
    if ((localViewGroup != null) && (this.HWu != null))
    {
      localViewGroup.removeView(this.HWu);
      this.HWu = null;
    }
    AppMethodBeat.o(35419);
  }
  
  private boolean isSupportCustomActionBar()
  {
    AppMethodBeat.i(35404);
    boolean bool = this.cLy.HZF.isSupportNavigationSwipeBack();
    AppMethodBeat.o(35404);
    return bool;
  }
  
  public final void a(com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(35390);
    super.a(parama);
    if (isSupportCustomActionBar())
    {
      this.HWi = new com.tencent.mm.ui.v();
      parama = this.HWi;
      BaseChattingUIFragment localBaseChattingUIFragment = this.cLy.HZF;
      parama.HoI = localBaseChattingUIFragment;
      parama.HoJ = new com.tencent.mm.ui.b.b(localBaseChattingUIFragment.thisActivity(), parama);
      this.cLy.HZF.setActivityController(this.HWi);
    }
    AppMethodBeat.o(35390);
  }
  
  public final void a(boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(196504);
    com.tencent.mm.ui.a locala = this.HWj;
    int i;
    if (!paramBoolean)
    {
      locala.HeN.setVisibility(0);
      i = locala.iCg.getCurrentTextColor();
      locala.HeN.setIconColor(i);
      locala.HeM.setOnClickListener(paramOnClickListener);
      com.tencent.mm.ui.tools.o.gD(locala.HeM);
      locala.HeQ.setVisibility(8);
      locala.HeP.setOnClickListener(null);
      com.tencent.mm.ui.tools.o.gE(locala.HeP);
    }
    for (;;)
    {
      ac.d("MicroMsg.ActionBarCustomArea", "fixWhenTitleTooLong, forSubTitle: ".concat(String.valueOf(paramBoolean)));
      if (paramBoolean) {
        break;
      }
      locala.iCg.post(new a.1(locala));
      AppMethodBeat.o(196504);
      return;
      locala.HeQ.setVisibility(0);
      i = locala.HeO.getCurrentTextColor();
      locala.HeQ.setIconColor(i);
      locala.HeP.setOnClickListener(paramOnClickListener);
      com.tencent.mm.ui.tools.o.gD(locala.HeP);
      locala.HeN.setVisibility(8);
      locala.HeM.setOnClickListener(null);
      com.tencent.mm.ui.tools.o.gE(locala.HeM);
    }
    locala.iCg.post(new a.2(locala));
    AppMethodBeat.o(196504);
  }
  
  public final void aaX(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(35427);
    Object localObject = this.HWj;
    if (paramInt == 0)
    {
      paramInt = 1;
      localObject = ((com.tencent.mm.ui.a)localObject).HeU;
      if (paramInt == 0) {
        break label47;
      }
    }
    label47:
    for (paramInt = i;; paramInt = 8)
    {
      ((ImageView)localObject).setVisibility(paramInt);
      AppMethodBeat.o(35427);
      return;
      paramInt = 0;
      break;
    }
  }
  
  public final void fW(View paramView)
  {
    AppMethodBeat.i(35405);
    ac.d("MicroMsg.ChattingUI.HeaderComponent", "dealContentView");
    if (isSupportCustomActionBar())
    {
      if (this.mActionBarContainer == null) {
        this.mActionBarContainer = ((ActionBarContainer)((ViewStub)paramView.findViewById(2131298079)).inflate());
      }
      com.tencent.mm.ui.v localv = this.HWi;
      paramView = (ViewGroup)paramView;
      localv.HoJ.UK = paramView;
    }
    AppMethodBeat.o(35405);
  }
  
  public final void fgg()
  {
    AppMethodBeat.i(35391);
    fnD();
    AppMethodBeat.o(35391);
  }
  
  public final void fgh()
  {
    AppMethodBeat.i(35392);
    this.xAq = this.cLy.HZF.getIntExtra("add_scene", 0);
    p.aBh().a(this.HWp);
    az.ayM();
    com.tencent.mm.model.c.awK().add(this.HSK);
    setBackBtn(this.backListener);
    fkm();
    fnC();
    fnF();
    fnJ();
    this.HSN = true;
    com.tencent.mm.model.q.a(this.cLy.getTalkerUserName(), new PluginNewTips.a()
    {
      public final void dkf()
      {
        AppMethodBeat.i(179909);
        ac.i("MicroMsg.ChattingUI.HeaderComponent", "onCallback");
        z.this.fnF();
        AppMethodBeat.o(179909);
      }
    });
    AppMethodBeat.o(35392);
  }
  
  public final void fgi()
  {
    AppMethodBeat.i(35393);
    xk(true);
    AppMethodBeat.o(35393);
  }
  
  public final void fgj()
  {
    AppMethodBeat.i(35394);
    az.ayM().awZ().a(new com.tencent.mm.model.b.e.a()
    {
      public final void aAc()
      {
        AppMethodBeat.i(35378);
        com.tencent.mm.ui.chatting.d.a.foS().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(35377);
            z.g(z.this);
            AppMethodBeat.o(35377);
          }
        });
        AppMethodBeat.o(35378);
      }
      
      public final void aAd()
      {
        AppMethodBeat.i(35379);
        z.h(z.this);
        AppMethodBeat.o(35379);
      }
    });
    az.ayM().axa().a(new com.tencent.mm.model.b.e.a()
    {
      public final void aAc()
      {
        AppMethodBeat.i(179920);
        com.tencent.mm.ui.chatting.d.a.foS().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(179919);
            z.i(z.this);
            AppMethodBeat.o(179919);
          }
        });
        AppMethodBeat.o(179920);
      }
      
      public final void aAd()
      {
        AppMethodBeat.i(179921);
        z.j(z.this);
        AppMethodBeat.o(179921);
      }
    });
    com.tencent.mm.model.b.b localb = az.ayM().axb();
    b.a locala = this.HWn;
    try
    {
      localb.mListeners.add(locala);
      if (!this.HSN) {
        fkm();
      }
      this.HSN = false;
      AppMethodBeat.o(35394);
      return;
    }
    finally
    {
      AppMethodBeat.o(35394);
    }
  }
  
  public final void fgk()
  {
    AppMethodBeat.i(35395);
    if (com.tencent.mm.kernel.g.agP().afY())
    {
      az.ayM().awZ().a(null);
      az.ayM().axa().a(null);
      com.tencent.mm.model.b.b localb = az.ayM().axb();
      b.a locala = this.HWn;
      try
      {
        localb.mListeners.remove(locala);
        return;
      }
      finally
      {
        AppMethodBeat.o(35395);
      }
    }
    AppMethodBeat.o(35395);
  }
  
  public final void fgl()
  {
    AppMethodBeat.i(35396);
    fnB();
    AppMethodBeat.o(35396);
  }
  
  public final com.tencent.mm.ui.v fkH()
  {
    return this.HWi;
  }
  
  public final void fmj()
  {
    AppMethodBeat.i(35397);
    super.fmj();
    fnB();
    AppMethodBeat.o(35397);
  }
  
  public final void fnA()
  {
    AppMethodBeat.i(35398);
    if (this.cLy.getHeaderViewsCount() > 0) {
      this.HWe = ((LinearLayout)this.cLy.getListView().findViewById(2131301446));
    }
    for (;;)
    {
      fnJ();
      AppMethodBeat.o(35398);
      return;
      this.HWe = ((LinearLayout)this.cLy.HZF.getContext().getLayoutInflater().inflate(2131493515, null));
      com.tencent.mm.ui.chatting.d.a locala = this.cLy;
      LinearLayout localLinearLayout = this.HWe;
      locala.HZG.addHeaderView(localLinearLayout);
    }
  }
  
  public final void fnC()
  {
    AppMethodBeat.i(35401);
    this.cLy.HZF.setMMSubTitle(null);
    if (com.tencent.mm.model.w.wz(this.cLy.getTalkerUserName()))
    {
      setMMTitle(this.cLy.AzG.aaR());
      AppMethodBeat.o(35401);
      return;
    }
    if (((com.tencent.mm.ui.chatting.c.b.ae)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.ae.class)).foj())
    {
      setMMTitle(2131762904);
      AppMethodBeat.o(35401);
      return;
    }
    if (com.tencent.mm.storage.ai.aMZ(this.cLy.getTalkerUserName()))
    {
      ((com.tencent.mm.ui.chatting.c.b.q)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.q.class)).fne().setWordCountLimit(140);
      setMMTitle(this.cLy.AzG.aaS());
      AppMethodBeat.o(35401);
      return;
    }
    if (com.tencent.mm.model.w.xn(this.cLy.getTalkerUserName()))
    {
      setMMTitle(this.cLy.AzG.aaR());
      AppMethodBeat.o(35401);
      return;
    }
    if (com.tencent.mm.storage.ai.ww(this.cLy.getTalkerUserName()))
    {
      setMMTitle(this.cLy.HZF.getContext().getString(2131756698, new Object[] { am(this.cLy.AzG) }).trim());
      AppMethodBeat.o(35401);
      return;
    }
    if (com.tencent.mm.storage.ai.vC(this.cLy.getTalkerUserName()))
    {
      if (this.cLy.bf(com.tencent.mm.ui.chatting.c.b.a.class) != null)
      {
        ((com.tencent.mm.ui.chatting.c.b.a)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.a.class)).fnC();
        AppMethodBeat.o(35401);
      }
    }
    else
    {
      if (this.cLy.foP())
      {
        boolean bool = ((f)this.cLy.bf(f.class)).fmJ();
        String str = this.cLy.AzG.field_conRemark;
        if (bs.isNullOrNil(str))
        {
          str = this.cLy.AzG.field_nickname;
          if (!bs.isNullOrNil(str)) {
            break label570;
          }
          if (com.tencent.mm.model.q.wb(this.cLy.getTalkerUserName()) != 0) {
            break label511;
          }
          str = this.cLy.HZF.getContext().getString(2131757293);
        }
        for (;;)
        {
          Object localObject;
          if (!com.tencent.mm.model.w.wq(this.cLy.getTalkerUserName()))
          {
            localObject = str;
            if (!bool) {}
          }
          else
          {
            str = str + " ";
            localObject = com.tencent.mm.pluginsdk.ui.span.k.d(this.cLy.HZF.getContext(), com.tencent.mm.pluginsdk.ui.span.k.b(this.cLy.HZF.getContext(), str, com.tencent.mm.cc.a.au(this.cLy.HZF.getContext(), 2131165192)));
          }
          setMMTitle((CharSequence)localObject);
          AppMethodBeat.o(35401);
          return;
          setMMSubTitle(com.tencent.mm.pluginsdk.ui.span.k.c(this.cLy.HZF.getContext(), this.cLy.fmy()).toString());
          break;
          label511:
          str = this.cLy.HZF.getContext().getString(2131759496, new Object[] { this.cLy.HZF.getContext().getString(2131757293), Integer.valueOf(com.tencent.mm.model.q.wb(this.cLy.getTalkerUserName())) });
          continue;
          label570:
          str = this.cLy.HZF.getContext().getString(2131759496, new Object[] { this.cLy.AzG.aaS(), Integer.valueOf(com.tencent.mm.model.q.wb(this.cLy.getTalkerUserName())) });
        }
      }
      if (((com.tencent.mm.ui.chatting.c.b.d)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.d.class)).fmq())
      {
        AppMethodBeat.o(35401);
        return;
      }
      this.HWj.wk(com.tencent.mm.storage.ai.aNb(this.cLy.getTalkerUserName()));
      this.cLy.HZF.setMMTitle(this.cLy.AzG.aaS());
      this.HWj.wk(com.tencent.mm.storage.ai.aNb(this.cLy.getTalkerUserName()));
      if (com.tencent.mm.storage.ai.aNc(this.cLy.getTalkerUserName())) {
        this.cLy.HZF.setMMSubTitle(((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).bB(this.cLy.AzG.field_openImAppid, this.cLy.AzG.field_descWordingId));
      }
    }
    AppMethodBeat.o(35401);
  }
  
  public final void fnD()
  {
    AppMethodBeat.i(35407);
    if ((this.cLy.HZF.isCurrentActivity) || (!isSupportCustomActionBar()))
    {
      localObject1 = ((AppCompatActivity)this.cLy.HZF.getContext()).getSupportActionBar();
      localObject2 = A(null);
      ((ActionBar)localObject1).setCustomView((View)localObject2);
      this.HWj = new com.tencent.mm.ui.a((View)localObject2);
      a((ActionBar)localObject1);
      this.HWj.wk(false);
      ((ActionBar)localObject1).setDisplayOptions((((ActionBar)localObject1).getDisplayOptions() | 0x10) & 0xFFFFFFFB & 0xFFFFFFFD & 0xFFFFFFF7);
      fnE();
      setBackBtn(this.backListener);
      AppMethodBeat.o(35407);
      return;
    }
    Object localObject1 = (ViewGroup)this.mActionBarContainer.findViewById(2131296343);
    ac.i("MicroMsg.ChattingUI.HeaderComponent", "mActionBarContainer %s", new Object[] { this.mActionBarContainer });
    ac.i("MicroMsg.ChattingUI.HeaderComponent", "ctxView %s", new Object[] { this.mActionBarContainer.findViewById(2131296357) });
    ((ViewGroup)localObject1).setVisibility(0);
    Object localObject2 = this.HWi.getSupportActionBar();
    View localView = A((ViewGroup)localObject1);
    ((ActionBar)localObject2).setCustomView(localView);
    this.HWj = new com.tencent.mm.ui.a(localView);
    int j = ((ActionBar)localObject2).getHeight();
    int i = j;
    if (j == 0)
    {
      localObject1 = this.cLy.HZF.getMMResources().getDisplayMetrics();
      if (((DisplayMetrics)localObject1).widthPixels <= ((DisplayMetrics)localObject1).heightPixels) {
        break label322;
      }
    }
    label322:
    for (i = this.cLy.HZF.getMMResources().getDimensionPixelSize(2131165251);; i = this.cLy.HZF.getMMResources().getDimensionPixelSize(2131165252))
    {
      localView.setMinimumHeight(i);
      ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
      localObject1 = localLayoutParams;
      if (localLayoutParams == null) {
        localObject1 = new ViewGroup.LayoutParams(-1, -1);
      }
      ((ViewGroup.LayoutParams)localObject1).height = i;
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = localObject2;
      break;
    }
  }
  
  public final void fnF()
  {
    AppMethodBeat.i(35410);
    Object localObject = (com.tencent.mm.ui.chatting.c.b.ae)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.ae.class);
    if ((((com.tencent.mm.ui.chatting.c.b.ae)localObject).foj()) || (((com.tencent.mm.ui.chatting.c.b.ae)localObject).foi()))
    {
      this.cLy.showOptionMenu(false);
      AppMethodBeat.o(35410);
      return;
    }
    if (((com.tencent.mm.ui.chatting.c.b.o)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.o.class)).fnd())
    {
      AppMethodBeat.o(35410);
      return;
    }
    if (com.tencent.mm.model.w.wC(this.cLy.getTalkerUserName()))
    {
      this.cLy.showOptionMenu(false);
      AppMethodBeat.o(35410);
      return;
    }
    if ((com.tencent.mm.model.w.wA(this.cLy.getTalkerUserName())) || (com.tencent.mm.model.w.wB(this.cLy.getTalkerUserName()))) {
      a(2131755135, 2131689511, this.HWm);
    }
    while (com.tencent.mm.storage.ai.ww(this.cLy.getTalkerUserName()))
    {
      this.cLy.xo(true);
      AppMethodBeat.o(35410);
      return;
      if (com.tencent.mm.model.w.wz(this.cLy.getTalkerUserName()))
      {
        com.tencent.mm.plugin.newtips.a.dke();
        boolean bool = com.tencent.mm.plugin.newtips.a.e.Kk(com.tencent.mm.plugin.newtips.a.d.vmS);
        this.cLy.HZF.addIconOptionMenu(0, 2131755135, 2131689511, Boolean.valueOf(bool).booleanValue(), this.HWm);
      }
      else if (com.tencent.mm.model.w.wD(this.cLy.getTalkerUserName()))
      {
        a(2131755135, 2131689511, this.HWm);
      }
      else if (com.tencent.mm.model.w.wK(this.cLy.getTalkerUserName()))
      {
        a(2131755135, 2131689511, this.HWm);
        h.wUl.kvStat(10071, "1");
      }
      else if (com.tencent.mm.model.w.wL(this.cLy.getTalkerUserName()))
      {
        a(2131755135, 2131689511, this.HWm);
      }
      else if (com.tencent.mm.model.w.xl(this.cLy.getTalkerUserName()))
      {
        a(2131755135, 2131689511, this.HWm);
      }
      else if (com.tencent.mm.model.w.xq(this.cLy.getTalkerUserName()))
      {
        a(2131755135, 2131689511, this.HWm);
      }
      else if (com.tencent.mm.model.w.xr(this.cLy.getTalkerUserName()))
      {
        if (com.tencent.mm.model.w.wW(this.cLy.getTalkerUserName()))
        {
          this.cLy.showOptionMenu(false);
          AppMethodBeat.o(35410);
          return;
        }
        a(2131755135, 2131689511, this.HWm);
      }
      else if ((com.tencent.mm.storage.ai.aMZ(this.cLy.getTalkerUserName())) || (com.tencent.mm.storage.ai.aNb(this.cLy.getTalkerUserName())) || (com.tencent.mm.storage.ai.ww(this.cLy.getTalkerUserName())))
      {
        a(2131757275, 2131689493, this.HWm);
      }
      else if (com.tencent.mm.storage.ai.vC(this.cLy.getTalkerUserName()))
      {
        if (this.cLy.bf(com.tencent.mm.ui.chatting.c.b.a.class) != null) {
          ((com.tencent.mm.ui.chatting.c.b.a)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.a.class)).foK();
        }
      }
      else if ((((aa)this.cLy.bf(aa.class)).fob()) && (j.aQk(this.cLy.getTalkerUserName())))
      {
        a(2131757275, 2131690972, this.HWm);
      }
      else
      {
        ((ae)this.cLy.bf(ae.class)).fnU();
        localObject = (com.tencent.mm.ui.chatting.c.b.d)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.d.class);
        if ((com.tencent.mm.model.w.wo(this.cLy.getTalkerUserName())) || (((com.tencent.mm.ui.chatting.c.b.d)localObject).fmo()))
        {
          if (((f)this.cLy.bf(f.class)).fmH())
          {
            ac.i("MicroMsg.ChattingUI.HeaderComponent", "cpan show chatroom right btn");
            if ((((f)this.cLy.bf(f.class)).fmI()) && (((f)this.cLy.bf(f.class)).Wp()) && (com.tencent.mm.model.q.axr())) {
              a(2131757275, 2131689493, "chatroom", this.HWm);
            }
            for (;;)
            {
              this.cLy.showOptionMenu(true);
              break;
              a(2131757275, 2131689493, this.HWm);
            }
          }
          if ((((com.tencent.mm.ui.chatting.c.b.d)localObject).fmo()) && (!((com.tencent.mm.ui.chatting.c.b.d)localObject).fmp()))
          {
            a(2131757275, 2131689507, this.HWm);
            this.cLy.showOptionMenu(true);
          }
          else
          {
            this.cLy.showOptionMenu(false);
            AppMethodBeat.o(35410);
          }
        }
        else
        {
          a(2131757275, 2131689493, this.HWm);
        }
      }
    }
    this.cLy.showOptionMenu(true);
    AppMethodBeat.o(35410);
  }
  
  @SuppressLint({"ResourceType"})
  public final void fnH()
  {
    AppMethodBeat.i(35414);
    if (this.cLy.HZF.hasDestory)
    {
      AppMethodBeat.o(35414);
      return;
    }
    fnJ();
    final LinearLayout localLinearLayout;
    if (this.HWf == null)
    {
      j.a(this.cLy.HZF, 2131306443);
      this.HWf = ((LinearLayout)this.cLy.HZF.getContext().findViewById(2131300123));
      localLinearLayout = (LinearLayout)this.cLy.HZF.getContext().getLayoutInflater().inflate(2131493514, null);
      this.HWf.addView(localLinearLayout, new ViewGroup.LayoutParams(-1, -2));
    }
    for (;;)
    {
      this.HWf.setVisibility(0);
      localLinearLayout.setVisibility(0);
      localLinearLayout.findViewById(2131296460);
      String str = this.HWh;
      Object localObject = str;
      if (bs.isNullOrNil(str)) {
        localObject = this.cLy.AzG.field_username;
      }
      com.tencent.mm.aj.c.a((String)localObject, false, -1, null);
      localObject = (Button)localLinearLayout.findViewById(2131297974);
      if (((y)this.cLy.bf(y.class)).fnV()) {
        ((y)this.cLy.bf(y.class)).a((Button)localObject, localLinearLayout, this.HWf);
      }
      localLinearLayout.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(35386);
          z.b(z.this);
          AppMethodBeat.o(35386);
        }
      });
      ((Button)localObject).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(35370);
          if (((y)z.this.cLy.bf(y.class)).fnV())
          {
            ((y)z.this.cLy.bf(y.class)).aaZ(z.k(z.this));
            AppMethodBeat.o(35370);
            return;
          }
          if ((int)z.this.cLy.AzG.fLJ == 0)
          {
            az.ayM();
            if (com.tencent.mm.model.c.awB().ah(z.this.cLy.AzG) != -1) {
              ac.e("MicroMsg.ChattingUI.HeaderComponent", "[insertRetId] successfully! username:%s", new Object[] { z.this.cLy.AzG });
            }
          }
          String str;
          if (com.tencent.mm.model.w.sQ(z.this.cLy.AzG.field_username))
          {
            paramAnonymousView = z.this.cLy.AzG.field_username;
            az.ayM();
            Object localObject = com.tencent.mm.model.c.awB().aNt(z.f(z.this));
            if (localObject == null) {
              break label362;
            }
            str = bs.bG(((av)localObject).eym, "");
            label195:
            ac.i("MicroMsg.ChattingUI.HeaderComponent", "dkverify banner add:%s chat:%s ticket", new Object[] { z.f(z.this), paramAnonymousView, str });
            if (((!TextUtils.isEmpty(paramAnonymousView)) && (TextUtils.isEmpty(str))) || (com.tencent.mm.storage.ai.aNc(((av)localObject).field_username))) {
              break label368;
            }
            localObject = new com.tencent.mm.pluginsdk.ui.applet.a(z.this.cLy.HZF.getContext(), new a.a()
            {
              public final void a(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2, String paramAnonymous2String1, String paramAnonymous2String2)
              {
                AppMethodBeat.i(179910);
                if (paramAnonymous2Boolean1)
                {
                  com.tencent.mm.model.w.u(z.this.cLy.AzG);
                  z.2.this.HWw.setVisibility(8);
                }
                AppMethodBeat.o(179910);
              }
            });
            LinkedList localLinkedList = new LinkedList();
            localLinkedList.add(Integer.valueOf(3));
            ((com.tencent.mm.pluginsdk.ui.applet.a)localObject).aHb(str);
            ((com.tencent.mm.pluginsdk.ui.applet.a)localObject).DpR = true;
            ((com.tencent.mm.pluginsdk.ui.applet.a)localObject).d(z.f(z.this), paramAnonymousView, localLinkedList);
          }
          for (;;)
          {
            h.wUl.f(11004, new Object[] { z.f(z.this), Integer.valueOf(3) });
            AppMethodBeat.o(35370);
            return;
            paramAnonymousView = "";
            break;
            label362:
            str = "";
            break label195;
            label368:
            ar.a.hnw.a(z.f(z.this), paramAnonymousView, new ar.b.a()
            {
              public final void p(String paramAnonymous2String, boolean paramAnonymous2Boolean)
              {
                AppMethodBeat.i(179912);
                com.tencent.mm.pluginsdk.ui.applet.a locala = new com.tencent.mm.pluginsdk.ui.applet.a(z.this.cLy.HZF.getContext(), new a.a()
                {
                  public final void a(boolean paramAnonymous3Boolean1, boolean paramAnonymous3Boolean2, String paramAnonymous3String1, String paramAnonymous3String2)
                  {
                    AppMethodBeat.i(179911);
                    if (paramAnonymous3Boolean1)
                    {
                      com.tencent.mm.model.w.u(z.this.cLy.AzG);
                      z.2.this.HWw.setVisibility(8);
                    }
                    AppMethodBeat.o(179911);
                  }
                });
                LinkedList localLinkedList = new LinkedList();
                localLinkedList.add(Integer.valueOf(3));
                az.ayM();
                paramAnonymous2String = com.tencent.mm.model.c.awB().aNt(z.f(z.this));
                if (paramAnonymous2String != null) {}
                for (paramAnonymous2String = bs.bG(paramAnonymous2String.eym, "");; paramAnonymous2String = "")
                {
                  locala.aHb(paramAnonymous2String);
                  locala.DpR = true;
                  locala.d(z.f(z.this), paramAnonymousView, localLinkedList);
                  AppMethodBeat.o(179912);
                  return;
                }
              }
            });
          }
        }
      });
      h.wUl.f(11004, new Object[] { this.HWh, Integer.valueOf(1) });
      AppMethodBeat.o(35414);
      return;
      localLinearLayout = (LinearLayout)this.HWf.findViewById(2131297975);
    }
  }
  
  public final int fnN()
  {
    AppMethodBeat.i(35420);
    int j = 0;
    int i = j;
    if (this.HWe != null)
    {
      i = j;
      if (this.HWe.isShown()) {
        i = this.HWe.getHeight() + 0;
      }
    }
    AppMethodBeat.o(35420);
    return i;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    int j = 1;
    AppMethodBeat.i(35389);
    super.onConfigurationChanged(paramConfiguration);
    ac.d("MicroMsg.ChattingUI.HeaderComponent", "getConfiguration().orientation = " + this.cLy.HZF.getMMResources().getConfiguration().orientation + ", newConfig.orientation = " + paramConfiguration.orientation);
    this.cLy.HZF.getMMResources().getConfiguration().orientation = paramConfiguration.orientation;
    ac.i("MicroMsg.ChatFooter", "[dealOrientationChange] %s", new Object[] { ((com.tencent.mm.ui.chatting.c.b.q)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.q.class)).fne().getContext().getResources().getConfiguration() });
    int i;
    if (this.mActionBarContainer != null)
    {
      i = 1;
      if (this.HWk == null) {
        break label271;
      }
    }
    for (;;)
    {
      if ((i & j) != 0)
      {
        i = com.tencent.mm.compatible.util.a.cd(this.cLy.HZF.getContext());
        this.HWk.setMinimumHeight(i);
        ViewGroup.LayoutParams localLayoutParams2 = this.HWk.getLayoutParams();
        ViewGroup.LayoutParams localLayoutParams1 = localLayoutParams2;
        if (localLayoutParams2 == null) {
          localLayoutParams1 = new ViewGroup.LayoutParams(-1, -1);
        }
        localLayoutParams1.height = i;
        this.HWk.setLayoutParams(localLayoutParams1);
        localLayoutParams1 = this.mActionBarContainer.getLayoutParams();
        localLayoutParams1.height = i;
        this.mActionBarContainer.setLayoutParams(localLayoutParams1);
      }
      if (this.HWi != null) {
        this.HWi.HoJ.mActionBar.onConfigurationChanged(paramConfiguration);
      }
      AppMethodBeat.o(35389);
      return;
      i = 0;
      break;
      label271:
      j = 0;
    }
  }
  
  public final void setBackBtn(final MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    AppMethodBeat.i(35423);
    this.HWj.e(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179914);
        if (!z.this.cLy.HZF.isScreenEnable())
        {
          ac.w("MicroMsg.ChattingUI.HeaderComponent", "Actionbar customView onclick screen not enable");
          AppMethodBeat.o(179914);
          return;
        }
        paramAnonymousView.setSelected(false);
        paramAnonymousView.setPressed(false);
        paramAnonymousView.clearFocus();
        paramAnonymousView.invalidate();
        paramAnonymousView.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(179913);
            if (z.3.this.Hgf != null) {
              z.3.this.Hgf.onMenuItemClick(null);
            }
            AppMethodBeat.o(179913);
          }
        });
        AppMethodBeat.o(179914);
      }
    });
    AppMethodBeat.o(35423);
  }
  
  public final void setMMSubTitle(String paramString)
  {
    AppMethodBeat.i(35422);
    int i = com.tencent.mm.cc.a.au(this.cLy.HZF.getContext(), 2131165466);
    paramString = com.tencent.mm.pluginsdk.ui.span.k.b(this.cLy.HZF.getContext(), paramString, i);
    this.HWj.al(paramString);
    AppMethodBeat.o(35422);
  }
  
  public final void setMMTitle(int paramInt)
  {
    AppMethodBeat.i(35402);
    setMMTitle(this.cLy.HZF.getMMResources().getString(paramInt));
    AppMethodBeat.o(35402);
  }
  
  public final void setMMTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(35421);
    if ((com.tencent.mm.model.w.wq(this.cLy.getTalkerUserName())) || (((f)this.cLy.bf(f.class)).fmJ()))
    {
      this.HWj.setTitle(paramCharSequence);
      this.cLy.HZF.updateDescription(this.cLy.HZF.getContext().getString(2131757133, new Object[] { paramCharSequence }));
      AppMethodBeat.o(35421);
      return;
    }
    if (com.tencent.mm.storage.ai.aNc(this.cLy.AzG.field_username))
    {
      paramCharSequence = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).e(com.tencent.mm.sdk.platformtools.ai.getContext(), paramCharSequence.toString(), com.tencent.mm.cc.a.au(com.tencent.mm.sdk.platformtools.ai.getContext(), 2131165192));
      this.HWj.setTitle(paramCharSequence);
      this.cLy.HZF.updateDescription(this.cLy.HZF.getContext().getString(2131757133, new Object[] { paramCharSequence }));
      AppMethodBeat.o(35421);
      return;
    }
    paramCharSequence = com.tencent.mm.pluginsdk.ui.span.k.b(this.cLy.HZF.getContext(), paramCharSequence, com.tencent.mm.cc.a.au(this.cLy.HZF.getContext(), 2131165192));
    this.HWj.setTitle(paramCharSequence);
    this.cLy.HZF.updateDescription(this.cLy.HZF.getContext().getString(2131757133, new Object[] { paramCharSequence }));
    AppMethodBeat.o(35421);
  }
  
  public final void setTitleForceNotifyIconVisibility(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(35425);
    Object localObject = this.HWj;
    if (paramInt == 0)
    {
      paramInt = 1;
      localObject = ((com.tencent.mm.ui.a)localObject).HeR;
      if (paramInt == 0) {
        break label47;
      }
    }
    label47:
    for (paramInt = i;; paramInt = 8)
    {
      ((ImageView)localObject).setVisibility(paramInt);
      AppMethodBeat.o(35425);
      return;
      paramInt = 0;
      break;
    }
  }
  
  public final void setTitleMuteIconVisibility(int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(35426);
    if ((com.tencent.mm.model.w.xl(this.cLy.getTalkerUserName())) || (com.tencent.mm.model.w.xq(this.cLy.getTalkerUserName())))
    {
      this.HWj.wj(false);
      AppMethodBeat.o(35426);
      return;
    }
    com.tencent.mm.ui.a locala = this.HWj;
    if (paramInt == 0) {
      bool = true;
    }
    locala.wj(bool);
    AppMethodBeat.o(35426);
  }
  
  public final void setTitlePhoneIconVisibility(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(35424);
    Object localObject = this.HWj;
    if (paramInt == 0)
    {
      paramInt = 1;
      localObject = ((com.tencent.mm.ui.a)localObject).HeS;
      if (paramInt == 0) {
        break label47;
      }
    }
    label47:
    for (paramInt = i;; paramInt = 8)
    {
      ((ImageView)localObject).setVisibility(paramInt);
      AppMethodBeat.o(35424);
      return;
      paramInt = 0;
      break;
    }
  }
  
  public final void xk(boolean paramBoolean)
  {
    AppMethodBeat.i(35412);
    if (this.cLy == null)
    {
      ac.e("MicroMsg.ChattingUI.HeaderComponent", "[updateBannerStatus] mChattingContext == null!");
      AppMethodBeat.o(35412);
      return;
    }
    if (!this.cLy.foQ()) {
      if ((!com.tencent.mm.model.w.wC(this.cLy.getTalkerUserName())) && (j.aQk(this.cLy.getTalkerUserName())) && (!((aa)this.cLy.bf(aa.class)).fob()))
      {
        this.HWh = this.cLy.getTalkerUserName();
        fnH();
      }
    }
    for (;;)
    {
      if (paramBoolean)
      {
        fnK();
        fnG();
      }
      AppMethodBeat.o(35412);
      return;
      if (!((y)this.cLy.bf(y.class)).fnW())
      {
        fnI();
        continue;
        fnJ();
      }
    }
  }
  
  final class a
    implements com.tencent.mm.plugin.newtips.a.a
  {
    public boolean HWE;
    private s.a HWF;
    private int Hgm;
    private View fvu;
    private String path;
    
    public a(String paramString, s.a parama)
    {
      AppMethodBeat.i(179923);
      this.fvu = new View(z.this.cLy.HZF.getContext());
      this.HWE = false;
      this.Hgm = 0;
      this.path = paramString;
      this.HWF = parama;
      AppMethodBeat.o(179923);
    }
    
    public final void a(com.tencent.mm.plugin.newtips.a.k paramk, boolean paramBoolean)
    {
      AppMethodBeat.i(179924);
      com.tencent.mm.plugin.newtips.a.g.a(this, paramk, paramBoolean);
      AppMethodBeat.o(179924);
    }
    
    public final boolean a(boolean paramBoolean, dhn paramdhn)
    {
      return false;
    }
    
    public final boolean b(boolean paramBoolean, dhn paramdhn)
    {
      return false;
    }
    
    public final boolean c(boolean paramBoolean, dhn paramdhn)
    {
      return false;
    }
    
    public final boolean d(boolean paramBoolean, dhn paramdhn)
    {
      return false;
    }
    
    public final boolean dbk()
    {
      return false;
    }
    
    public final String getPath()
    {
      return this.path;
    }
    
    public final View getRoot()
    {
      return this.fvu;
    }
    
    public final boolean nR(boolean paramBoolean)
    {
      AppMethodBeat.i(179925);
      paramBoolean = com.tencent.mm.plugin.newtips.a.g.a(paramBoolean, this);
      AppMethodBeat.o(179925);
      return paramBoolean;
    }
    
    public final boolean nS(boolean paramBoolean)
    {
      AppMethodBeat.i(179926);
      this.HWE = paramBoolean;
      z.this.cLy.HZF.updateOptionMenuRedDot(this.Hgm, paramBoolean);
      AppMethodBeat.o(179926);
      return true;
    }
    
    public final boolean nT(boolean paramBoolean)
    {
      return false;
    }
  }
  
  final class b
    extends x
  {
    b() {}
    
    public final void WP()
    {
      AppMethodBeat.i(35387);
      Object localObject1;
      if (com.tencent.mm.model.w.wq(z.this.cLy.getTalkerUserName()))
      {
        localObject1 = new ct();
        ((ct)localObject1).kP(z.this.cLy.getTalkerUserName());
        ((ct)localObject1).dHR = 4L;
        ((ct)localObject1).aHZ();
      }
      if ((z.a(z.this) != null) && (z.a(z.this).HWE)) {
        com.tencent.mm.plugin.newtips.a.dkb().Ko(25);
      }
      if (com.tencent.mm.model.w.wB(z.this.cLy.getTalkerUserName())) {
        h.wUl.f(19540, new Object[] { Integer.valueOf(2) });
      }
      z.this.cLy.hideVKB();
      Object localObject2;
      if (com.tencent.mm.model.w.xl(z.this.cLy.getTalkerUserName()))
      {
        localObject1 = z.this.cLy.HZF.getContext();
        localObject2 = new Intent(z.this.cLy.HZF.getContext(), ServiceNotifySettingsUI.class);
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aeD(), "com/tencent/mm/ui/chatting/component/HeaderComponent$OptionListener", "onRealClick", "(Landroid/view/MenuItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((Activity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/chatting/component/HeaderComponent$OptionListener", "onRealClick", "(Landroid/view/MenuItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(35387);
        return;
      }
      if (com.tencent.mm.model.w.xq(z.this.cLy.getTalkerUserName()))
      {
        localObject2 = new Intent(z.this.cLy.HZF.getContext(), AppBrandNotifySettingsUI.class);
        localObject1 = (com.tencent.mm.plugin.appbrand.service.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.g.class);
        if (localObject1 == null) {
          break label801;
        }
        localObject1 = ((com.tencent.mm.plugin.appbrand.service.g)localObject1).aVg();
        ((Intent)localObject2).putExtra("report_session_id", (String)localObject1);
      }
      for (;;)
      {
        Activity localActivity = z.this.cLy.HZF.getContext();
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(localActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aeD(), "com/tencent/mm/ui/chatting/component/HeaderComponent$OptionListener", "onRealClick", "(Landroid/view/MenuItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(localActivity, "com/tencent/mm/ui/chatting/component/HeaderComponent$OptionListener", "onRealClick", "(Landroid/view/MenuItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        h.wUl.f(19724, new Object[] { Integer.valueOf(1), Integer.valueOf(6), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null, null, null, Integer.valueOf(0), null, null, Integer.valueOf(0), null, null, localObject1 });
        AppMethodBeat.o(35387);
        return;
        if (com.tencent.mm.model.w.wD(z.this.cLy.getTalkerUserName()))
        {
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("Contact_User", z.this.cLy.getTalkerUserName());
          com.tencent.mm.br.d.b(z.this.cLy.HZF.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject1);
          AppMethodBeat.o(35387);
          return;
        }
        if (((y)z.this.cLy.bf(y.class)).fnV())
        {
          z.b(z.this);
          AppMethodBeat.o(35387);
          return;
        }
        if (((com.tencent.mm.ui.chatting.c.b.d)z.this.cLy.bf(com.tencent.mm.ui.chatting.c.b.d.class)).fmz())
        {
          AppMethodBeat.o(35387);
          return;
        }
        localObject2 = new Intent();
        ((Intent)localObject2).setClass(z.this.cLy.HZF.getContext(), SingleChatInfoUI.class);
        ((Intent)localObject2).putExtra("Single_Chat_Talker", z.this.cLy.getTalkerUserName());
        ((Intent)localObject2).putExtra("fromChatting", true);
        localObject1 = z.this.cLy.HZF;
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aeD(), "com/tencent/mm/ui/chatting/component/HeaderComponent$OptionListener", "onRealClick", "(Landroid/view/MenuItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((MMFragment)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/chatting/component/HeaderComponent$OptionListener", "onRealClick", "(Landroid/view/MenuItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(35387);
        return;
        label801:
        localObject1 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.z
 * JD-Core Version:    0.7.0.1
 */