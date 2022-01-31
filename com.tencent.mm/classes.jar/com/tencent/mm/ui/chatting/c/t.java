package com.tencent.mm.ui.chatting.c;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ActionBarContainer;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.d.a;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.b.b.a;
import com.tencent.mm.model.b.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.f;
import com.tencent.mm.ui.chatting.c.b.r;
import com.tencent.mm.ui.chatting.c.b.v;
import com.tencent.mm.ui.chatting.c.b.z;
import com.tencent.mm.ui.conversation.a.e;
import com.tencent.mm.ui.conversation.a.e.a;
import com.tencent.mm.ui.u;
import com.tencent.mm.ui.w;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.chatting.c.a.a(dJy=r.class)
public class t
  extends a
  implements r
{
  private MenuItem.OnMenuItemClickListener backListener;
  private ActionBarContainer mActionBarContainer;
  private int qQk;
  private boolean zEB;
  private final k.a zEy;
  private View zGA;
  private View zGB;
  protected LinearLayout zGm;
  protected LinearLayout zGn;
  private List<String> zGo;
  private String zGp;
  public com.tencent.mm.ui.s zGq;
  private com.tencent.mm.ui.a zGr;
  private View zGs;
  final u zGt;
  private b.a zGu;
  private Runnable zGv;
  private final d.a zGw;
  final int zGx;
  final int zGy;
  final MenuItem.OnMenuItemClickListener zGz;
  
  public t()
  {
    AppMethodBeat.i(31493);
    this.zGo = new LinkedList();
    this.qQk = 0;
    this.mActionBarContainer = null;
    this.zGq = null;
    this.zEB = false;
    this.zGt = new t.a(this);
    this.zGu = new t.1(this);
    this.zGv = null;
    this.zGw = new t.3(this);
    this.zEy = new k.a()
    {
      public final void a(String paramAnonymousString, m paramAnonymousm)
      {
        AppMethodBeat.i(31478);
        ab.v("MicroMsg.ChattingUI.HeaderComponent", "roommember watcher notify ".concat(String.valueOf(paramAnonymousString)));
        if ((t.this.caz.dJG()) && (!bo.isNullOrNil(paramAnonymousString)))
        {
          t.this.dIv();
          t.this.dIy();
        }
        AppMethodBeat.o(31478);
      }
    };
    this.backListener = new t.7(this);
    this.zGx = 1;
    this.zGy = 2;
    this.zGz = new t.8(this);
    this.zGA = null;
    this.zGB = null;
    AppMethodBeat.o(31493);
  }
  
  private void a(int paramInt1, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    AppMethodBeat.i(31516);
    if (this.caz.zJz.findMenuInfo(0) == null)
    {
      this.caz.zJz.addIconOptionMenu(0, paramInt1, paramInt2, paramOnMenuItemClickListener);
      AppMethodBeat.o(31516);
      return;
    }
    this.caz.zJz.updateOptionMenu(0, paramInt1, paramInt2, paramOnMenuItemClickListener);
    AppMethodBeat.o(31516);
  }
  
  private static void a(ActionBar paramActionBar)
  {
    AppMethodBeat.i(31513);
    if (paramActionBar.getCustomView() != null)
    {
      paramActionBar.getCustomView().findViewById(2131820980);
      TextView localTextView = (TextView)paramActionBar.getCustomView().findViewById(2131820981);
      if (localTextView != null) {
        af.a(localTextView.getPaint(), 0.8F);
      }
      paramActionBar.getCustomView().findViewById(2131820982);
      paramActionBar.getCustomView().findViewById(2131820984);
      paramActionBar.getCustomView().findViewById(2131820985);
    }
    AppMethodBeat.o(31513);
  }
  
  private String b(com.tencent.mm.storage.ad paramad)
  {
    AppMethodBeat.i(31508);
    if (paramad == null)
    {
      paramad = this.caz.zJz.getContext().getString(2131297803);
      AppMethodBeat.o(31508);
      return paramad;
    }
    if (RegionCodeDecoder.asx(paramad.getCountryCode()))
    {
      String str = paramad.getCity();
      if (!bo.isNullOrNil(str))
      {
        AppMethodBeat.o(31508);
        return str;
      }
      str = com.tencent.mm.model.s.nG(paramad.getProvince());
      if (!bo.isNullOrNil(str))
      {
        AppMethodBeat.o(31508);
        return str;
      }
      RegionCodeDecoder.dyE();
      paramad = RegionCodeDecoder.getLocName(paramad.getCountryCode());
      AppMethodBeat.o(31508);
      return paramad;
    }
    paramad = com.tencent.mm.model.s.nG(paramad.getProvince());
    if (!bo.isNullOrNil(paramad))
    {
      AppMethodBeat.o(31508);
      return paramad;
    }
    paramad = this.caz.zJz.getContext().getString(2131297803);
    AppMethodBeat.o(31508);
    return paramad;
  }
  
  private void dFD()
  {
    AppMethodBeat.i(31504);
    if (com.tencent.mm.model.t.nP(this.caz.getTalkerUserName()))
    {
      com.tencent.mm.plugin.r.a.bWU();
      boolean bool = com.tencent.mm.ax.c.lO(com.tencent.mm.ax.b.fKU);
      this.caz.zJz.addIconOptionMenu(0, 2131296408, 2131230758, Boolean.valueOf(bool).booleanValue(), this.zGt);
    }
    AppMethodBeat.o(31504);
  }
  
  private void dIB()
  {
    AppMethodBeat.i(31520);
    if ((this.caz.dJG()) || (this.zGm == null))
    {
      dIC();
      AppMethodBeat.o(31520);
      return;
    }
    dIC();
    com.tencent.mm.pluginsdk.ui.b.a locala2;
    if (this.zGm.getTag() == null)
    {
      locala2 = e.a(this.caz.zJz.getContext(), e.a.Amn, new Object[] { this.caz.getTalkerUserName(), this.caz.dHF() });
      locala1 = locala2;
      if (locala2 != null)
      {
        locala1 = locala2;
        if (locala2.getView() != null) {
          this.zGm.addView(locala2.getView(), new ViewGroup.LayoutParams(-1, -2));
        }
      }
    }
    for (com.tencent.mm.pluginsdk.ui.b.a locala1 = locala2;; locala1 = (com.tencent.mm.pluginsdk.ui.b.a)this.zGm.getTag())
    {
      if (locala1 != null)
      {
        this.zGm.setVisibility(0);
        this.zGm.setTag(locala1);
      }
      h.qsU.e(11003, new Object[] { this.caz.getTalkerUserName(), Integer.valueOf(1), Integer.valueOf(0) });
      AppMethodBeat.o(31520);
      return;
    }
  }
  
  private void dIC()
  {
    AppMethodBeat.i(31521);
    this.zGm.setVisibility(8);
    if (this.zGn != null) {
      this.zGn.setVisibility(8);
    }
    AppMethodBeat.o(31521);
  }
  
  private void dID()
  {
    AppMethodBeat.i(31522);
    if (this.caz.zJz.getContext() == null)
    {
      ab.w("MicroMsg.ChattingUI.HeaderComponent", "getActivity is null");
      AppMethodBeat.o(31522);
      return;
    }
    dIE();
    ViewGroup localViewGroup = (ViewGroup)this.caz.zJz.getContext().findViewById(2131822440);
    com.tencent.mm.pluginsdk.ui.b.a locala = e.a(this.caz.zJz.getContext(), e.a.Amo, new Object[] { this.caz.getTalkerUserName(), this.caz.dHF(), Boolean.valueOf(this.caz.dJG()) });
    if ((localViewGroup != null) && (locala != null) && (locala.getView() != null) && (this.zGA == null))
    {
      this.zGA = locala.getView();
      localViewGroup.addView(this.zGA, new ViewGroup.LayoutParams(-1, -2));
    }
    AppMethodBeat.o(31522);
  }
  
  private void dIE()
  {
    AppMethodBeat.i(31523);
    ViewGroup localViewGroup = (ViewGroup)this.caz.zJz.getContext().findViewById(2131822440);
    if ((localViewGroup != null) && (this.zGA != null))
    {
      localViewGroup.removeView(this.zGA);
      this.zGA = null;
    }
    AppMethodBeat.o(31523);
  }
  
  private void dIF()
  {
    AppMethodBeat.i(31524);
    ViewGroup localViewGroup = (ViewGroup)this.caz.zJz.getContext().findViewById(2131822453);
    if ((localViewGroup != null) && (this.zGB != null))
    {
      localViewGroup.removeView(this.zGB);
      this.zGB = null;
    }
    AppMethodBeat.o(31524);
  }
  
  private void dIu()
  {
    AppMethodBeat.i(31505);
    if (g.RJ().QU())
    {
      com.tencent.mm.ah.o.acQ().b(this.zGw);
      aw.aaz();
      com.tencent.mm.model.c.YJ().remove(this.zEy);
    }
    com.tencent.mm.ui.chatting.d.a.dJI().removeCallbacks(this.zGv);
    AppMethodBeat.o(31505);
  }
  
  private void dIx()
  {
    AppMethodBeat.i(31514);
    this.zGo.clear();
    this.zGo.add(this.caz.zJz.getStringExtra("Chat_User"));
    AppMethodBeat.o(31514);
  }
  
  private void dIz()
  {
    AppMethodBeat.i(31518);
    if (this.caz.zJz.getContext() == null)
    {
      ab.w("MicroMsg.ChattingUI.HeaderComponent", "getActivity is null");
      AppMethodBeat.o(31518);
      return;
    }
    dIF();
    ViewGroup localViewGroup = (ViewGroup)this.caz.zJz.getContext().findViewById(2131822453);
    com.tencent.mm.pluginsdk.ui.b.a locala = e.a(this.caz.zJz.getContext(), e.a.Amy, new Object[] { b.b.fow });
    if ((localViewGroup != null) && (locala != null) && (locala.getView() != null) && (this.zGB == null))
    {
      this.zGB = locala.getView();
      localViewGroup.addView(this.zGB, new ViewGroup.LayoutParams(-1, -2));
    }
    AppMethodBeat.o(31518);
  }
  
  private boolean isSupportCustomActionBar()
  {
    AppMethodBeat.i(31509);
    boolean bool = this.caz.zJz.isSupportNavigationSwipeBack();
    AppMethodBeat.o(31509);
    return bool;
  }
  
  private View w(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(31511);
    if (this.zGs == null)
    {
      if (paramViewGroup == null) {}
      for (this.zGs = w.hM(this.caz.zJz.getContext()).inflate(2130968613, null);; this.zGs = w.hM(this.caz.zJz.getContext()).inflate(2130968613, paramViewGroup, false))
      {
        paramViewGroup = this.zGs;
        AppMethodBeat.o(31511);
        return paramViewGroup;
      }
    }
    if (this.zGs.getParent() == null)
    {
      paramViewGroup = this.zGs;
      AppMethodBeat.o(31511);
      return paramViewGroup;
    }
    if ((this.zGs.getParent() instanceof ViewGroup))
    {
      ((ViewGroup)this.zGs.getParent()).removeView(this.zGs);
      paramViewGroup = this.zGs;
      AppMethodBeat.o(31511);
      return paramViewGroup;
    }
    if (paramViewGroup == null) {}
    for (this.zGs = w.hM(this.caz.zJz.getContext()).inflate(2130968613, null);; this.zGs = w.hM(this.caz.zJz.getContext()).inflate(2130968613, paramViewGroup, false))
    {
      paramViewGroup = this.zGs;
      AppMethodBeat.o(31511);
      return paramViewGroup;
    }
  }
  
  public final void PF(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(31532);
    Object localObject = this.zGr;
    if (paramInt == 0)
    {
      paramInt = 1;
      localObject = ((com.tencent.mm.ui.a)localObject).yTr;
      if (paramInt == 0) {
        break label47;
      }
    }
    label47:
    for (paramInt = i;; paramInt = 8)
    {
      ((ImageView)localObject).setVisibility(paramInt);
      AppMethodBeat.o(31532);
      return;
      paramInt = 0;
      break;
    }
  }
  
  public final void a(com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(31495);
    super.a(parama);
    if (isSupportCustomActionBar())
    {
      this.zGq = new com.tencent.mm.ui.s();
      parama = this.zGq;
      BaseChattingUIFragment localBaseChattingUIFragment = this.caz.zJz;
      parama.zbQ = localBaseChattingUIFragment;
      parama.zbR = new com.tencent.mm.ui.b.b(localBaseChattingUIFragment.thisActivity(), parama);
      this.caz.zJz.setActivityController(this.zGq);
    }
    AppMethodBeat.o(31495);
  }
  
  public final void dBY()
  {
    AppMethodBeat.i(31496);
    dIw();
    AppMethodBeat.o(31496);
  }
  
  public final void dBZ()
  {
    AppMethodBeat.i(31497);
    this.qQk = this.caz.zJz.getIntExtra("add_scene", 0);
    com.tencent.mm.ah.o.acQ().a(this.zGw);
    aw.aaz();
    com.tencent.mm.model.c.YJ().add(this.zEy);
    setBackBtn(this.backListener);
    dFD();
    dIv();
    dIy();
    dIC();
    this.zEB = true;
    AppMethodBeat.o(31497);
  }
  
  public final void dCa()
  {
    AppMethodBeat.i(31498);
    qV(true);
    AppMethodBeat.o(31498);
  }
  
  public final void dCb()
  {
    AppMethodBeat.i(31499);
    aw.aaz().YY().a(new t.5(this));
    aw.aaz().YZ().a(new t.6(this));
    com.tencent.mm.model.b.b localb = aw.aaz().Za();
    b.a locala = this.zGu;
    try
    {
      localb.mListeners.add(locala);
      if (!this.zEB) {
        dFD();
      }
      this.zEB = false;
      AppMethodBeat.o(31499);
      return;
    }
    finally
    {
      AppMethodBeat.o(31499);
    }
  }
  
  public final void dCc()
  {
    AppMethodBeat.i(31500);
    if (g.RJ().QU())
    {
      aw.aaz().YY().a(null);
      aw.aaz().YZ().a(null);
      com.tencent.mm.model.b.b localb = aw.aaz().Za();
      b.a locala = this.zGu;
      try
      {
        localb.mListeners.remove(locala);
        return;
      }
      finally
      {
        AppMethodBeat.o(31500);
      }
    }
    AppMethodBeat.o(31500);
  }
  
  public final void dCd()
  {
    AppMethodBeat.i(31501);
    dIu();
    AppMethodBeat.o(31501);
  }
  
  public final com.tencent.mm.ui.s dGa()
  {
    return this.zGq;
  }
  
  public final void dHq()
  {
    AppMethodBeat.i(31502);
    super.dHq();
    dIu();
    AppMethodBeat.o(31502);
  }
  
  @SuppressLint({"ResourceType"})
  public final void dIA()
  {
    AppMethodBeat.i(31519);
    if (this.caz.zJz.hasDestory)
    {
      AppMethodBeat.o(31519);
      return;
    }
    dIC();
    LinearLayout localLinearLayout;
    ImageView localImageView;
    Object localObject;
    if (this.zGn == null)
    {
      i.a(this.caz.zJz, 2131822438);
      this.zGn = ((LinearLayout)this.caz.zJz.getContext().findViewById(2131822470));
      localLinearLayout = (LinearLayout)this.caz.zJz.getContext().getLayoutInflater().inflate(2130969134, null);
      this.zGn.addView(localLinearLayout, new ViewGroup.LayoutParams(-1, -2));
      this.zGn.setVisibility(0);
      localLinearLayout.setVisibility(0);
      localImageView = (ImageView)localLinearLayout.findViewById(2131822756);
      String str = this.zGp;
      localObject = str;
      if (bo.isNullOrNil(str)) {
        localObject = this.caz.txj.field_username;
      }
      localObject = com.tencent.mm.ah.b.b((String)localObject, false, -1);
      if (localObject != null) {
        break label316;
      }
      localImageView.setImageResource(2131231207);
    }
    for (;;)
    {
      localObject = (Button)localLinearLayout.findViewById(2131822758);
      if (((com.tencent.mm.ui.chatting.c.b.t)this.caz.ay(com.tencent.mm.ui.chatting.c.b.t.class)).dIO()) {
        ((com.tencent.mm.ui.chatting.c.b.t)this.caz.ay(com.tencent.mm.ui.chatting.c.b.t.class)).a((Button)localObject, localLinearLayout, this.zGn);
      }
      localImageView.setOnClickListener(new t.9(this));
      ((Button)localObject).setOnClickListener(new t.10(this, localLinearLayout));
      h.qsU.e(11004, new Object[] { this.zGp, Integer.valueOf(1) });
      AppMethodBeat.o(31519);
      return;
      localLinearLayout = (LinearLayout)this.zGn.findViewById(2131822755);
      break;
      label316:
      localImageView.setImageBitmap((Bitmap)localObject);
    }
  }
  
  public final int dIG()
  {
    AppMethodBeat.i(31525);
    int j = 0;
    int i = j;
    if (this.zGm != null)
    {
      i = j;
      if (this.zGm.isShown()) {
        i = this.zGm.getHeight() + 0;
      }
    }
    AppMethodBeat.o(31525);
    return i;
  }
  
  public final void dIt()
  {
    AppMethodBeat.i(31503);
    if (this.caz.getHeaderViewsCount() > 0) {
      this.zGm = ((LinearLayout)this.caz.getListView().findViewById(2131822759));
    }
    for (;;)
    {
      dIC();
      AppMethodBeat.o(31503);
      return;
      this.zGm = ((LinearLayout)this.caz.zJz.getContext().getLayoutInflater().inflate(2130969135, null));
      com.tencent.mm.ui.chatting.d.a locala = this.caz;
      LinearLayout localLinearLayout = this.zGm;
      locala.zJA.addHeaderView(localLinearLayout);
    }
  }
  
  public final void dIv()
  {
    AppMethodBeat.i(31506);
    this.caz.zJz.setMMSubTitle(null);
    if (com.tencent.mm.model.t.nP(this.caz.getTalkerUserName()))
    {
      setMMTitle(this.caz.txj.Oe());
      AppMethodBeat.o(31506);
      return;
    }
    if (((z)this.caz.ay(z.class)).dJc())
    {
      setMMTitle(2131302966);
      AppMethodBeat.o(31506);
      return;
    }
    if (com.tencent.mm.storage.ad.arc(this.caz.getTalkerUserName()))
    {
      ((com.tencent.mm.ui.chatting.c.b.o)this.caz.ay(com.tencent.mm.ui.chatting.c.b.o.class)).dIg().setWordCountLimit(140);
      setMMTitle(this.caz.txj.Of());
      AppMethodBeat.o(31506);
      return;
    }
    if (com.tencent.mm.model.t.oA(this.caz.getTalkerUserName()))
    {
      setMMTitle(this.caz.txj.Oe());
      AppMethodBeat.o(31506);
      return;
    }
    if (com.tencent.mm.storage.ad.nM(this.caz.getTalkerUserName()))
    {
      setMMTitle(this.caz.zJz.getContext().getString(2131297774, new Object[] { b(this.caz.txj) }).trim());
      AppMethodBeat.o(31506);
      return;
    }
    if (com.tencent.mm.storage.ad.na(this.caz.getTalkerUserName()))
    {
      if (this.caz.ay(com.tencent.mm.ui.chatting.c.b.a.class) != null)
      {
        ((com.tencent.mm.ui.chatting.c.b.a)this.caz.ay(com.tencent.mm.ui.chatting.c.b.a.class)).dIv();
        AppMethodBeat.o(31506);
      }
    }
    else if (this.caz.dJF())
    {
      if (com.tencent.mm.model.t.nJ(this.caz.getTalkerUserName()))
      {
        if (bo.isNullOrNil(this.caz.txj.field_nickname))
        {
          if (com.tencent.mm.model.n.nv(this.caz.getTalkerUserName()) == 0)
          {
            setMMTitle(this.caz.zJz.getContext().getString(2131298302));
            AppMethodBeat.o(31506);
            return;
          }
          setMMTitle(this.caz.zJz.getContext().getString(2131300029, new Object[] { this.caz.zJz.getContext().getString(2131298302), Integer.valueOf(com.tencent.mm.model.n.nv(this.caz.getTalkerUserName())) }));
          AppMethodBeat.o(31506);
          return;
        }
        setMMTitle(this.caz.zJz.getContext().getString(2131300029, new Object[] { this.caz.txj.Oe(), Integer.valueOf(com.tencent.mm.model.n.nv(this.caz.getTalkerUserName())) }));
        AppMethodBeat.o(31506);
        return;
      }
      if (com.tencent.mm.model.t.nK(this.caz.getTalkerUserName()))
      {
        String str;
        if (bo.isNullOrNil(this.caz.txj.field_nickname)) {
          if (com.tencent.mm.model.n.nv(this.caz.getTalkerUserName()) == 0) {
            str = this.caz.zJz.getContext().getString(2131298302);
          }
        }
        for (;;)
        {
          setMMTitle(j.c(this.caz.zJz.getContext(), j.b(this.caz.zJz.getContext(), str, com.tencent.mm.cb.a.ao(this.caz.zJz.getContext(), 2131427501))));
          AppMethodBeat.o(31506);
          return;
          str = this.caz.zJz.getContext().getString(2131300029, new Object[] { this.caz.zJz.getContext().getString(2131298302), Integer.valueOf(com.tencent.mm.model.n.nv(this.caz.getTalkerUserName())) });
          continue;
          str = this.caz.zJz.getContext().getString(2131300029, new Object[] { this.caz.txj.Oe(), Integer.valueOf(com.tencent.mm.model.n.nv(this.caz.getTalkerUserName())) });
        }
      }
    }
    else
    {
      if (((com.tencent.mm.ui.chatting.c.b.d)this.caz.ay(com.tencent.mm.ui.chatting.c.b.d.class)).dHx())
      {
        AppMethodBeat.o(31506);
        return;
      }
      this.zGr.pZ(com.tencent.mm.storage.ad.are(this.caz.getTalkerUserName()));
      this.caz.zJz.setMMTitle(this.caz.txj.Of());
      this.zGr.pZ(com.tencent.mm.storage.ad.are(this.caz.getTalkerUserName()));
      if (com.tencent.mm.storage.ad.arf(this.caz.getTalkerUserName())) {
        this.caz.zJz.setMMSubTitle(((com.tencent.mm.openim.a.b)g.E(com.tencent.mm.openim.a.b.class)).bd(this.caz.txj.field_openImAppid, this.caz.txj.field_descWordingId));
      }
    }
    AppMethodBeat.o(31506);
  }
  
  public final void dIw()
  {
    AppMethodBeat.i(31512);
    if ((this.caz.zJz.isCurrentActivity) || (!isSupportCustomActionBar()))
    {
      localObject1 = ((AppCompatActivity)this.caz.zJz.getContext()).getSupportActionBar();
      localObject2 = w(null);
      ((ActionBar)localObject1).setCustomView((View)localObject2);
      this.zGr = new com.tencent.mm.ui.a((View)localObject2);
      a((ActionBar)localObject1);
      this.zGr.pZ(false);
      ((ActionBar)localObject1).setDisplayOptions((((ActionBar)localObject1).getDisplayOptions() | 0x10) & 0xFFFFFFFB & 0xFFFFFFFD & 0xFFFFFFF7);
      dIx();
      setBackBtn(this.backListener);
      AppMethodBeat.o(31512);
      return;
    }
    Object localObject1 = (ViewGroup)this.mActionBarContainer.findViewById(2131820957);
    ab.i("MicroMsg.ChattingUI.HeaderComponent", "mActionBarContainer %s", new Object[] { this.mActionBarContainer });
    ab.i("MicroMsg.ChattingUI.HeaderComponent", "ctxView %s", new Object[] { this.mActionBarContainer.findViewById(2131820958) });
    ((ViewGroup)localObject1).setVisibility(0);
    Object localObject2 = this.zGq.getSupportActionBar();
    View localView = w((ViewGroup)localObject1);
    ((ActionBar)localObject2).setCustomView(localView);
    this.zGr = new com.tencent.mm.ui.a(localView);
    int j = ((ActionBar)localObject2).getHeight();
    int i = j;
    if (j == 0)
    {
      localObject1 = this.caz.zJz.getMMResources().getDisplayMetrics();
      if (((DisplayMetrics)localObject1).widthPixels <= ((DisplayMetrics)localObject1).heightPixels) {
        break label323;
      }
    }
    label323:
    for (i = this.caz.zJz.getMMResources().getDimensionPixelSize(2131427558);; i = this.caz.zJz.getMMResources().getDimensionPixelSize(2131427559))
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
  
  public final void dIy()
  {
    AppMethodBeat.i(31515);
    Object localObject = (z)this.caz.ay(z.class);
    if ((((z)localObject).dJc()) || (((z)localObject).dJb()))
    {
      this.caz.showOptionMenu(false);
      AppMethodBeat.o(31515);
      return;
    }
    if (((com.tencent.mm.ui.chatting.c.b.n)this.caz.ay(com.tencent.mm.ui.chatting.c.b.n.class)).dIf())
    {
      AppMethodBeat.o(31515);
      return;
    }
    if (com.tencent.mm.model.t.nP(this.caz.getTalkerUserName()))
    {
      com.tencent.mm.plugin.r.a.bWU();
      boolean bool = com.tencent.mm.ax.c.lO(com.tencent.mm.ax.b.fKU);
      this.caz.zJz.addIconOptionMenu(0, 2131296408, 2131230758, Boolean.valueOf(bool).booleanValue(), this.zGt);
    }
    while (com.tencent.mm.storage.ad.nM(this.caz.getTalkerUserName()))
    {
      this.caz.qZ(true);
      AppMethodBeat.o(31515);
      return;
      if (com.tencent.mm.model.t.nQ(this.caz.getTalkerUserName()))
      {
        a(2131296408, 2131230758, this.zGt);
      }
      else if (com.tencent.mm.model.t.nX(this.caz.getTalkerUserName()))
      {
        a(2131296408, 2131230758, this.zGt);
        h.qsU.kvStat(10071, "1");
      }
      else if (com.tencent.mm.model.t.nY(this.caz.getTalkerUserName()))
      {
        a(2131296408, 2131230758, this.zGt);
      }
      else if (com.tencent.mm.model.t.oy(this.caz.getTalkerUserName()))
      {
        a(2131296408, 2131230758, this.zGt);
      }
      else if (com.tencent.mm.model.t.oD(this.caz.getTalkerUserName()))
      {
        if (com.tencent.mm.model.t.oj(this.caz.getTalkerUserName()))
        {
          this.caz.showOptionMenu(false);
          AppMethodBeat.o(31515);
          return;
        }
        a(2131296408, 2131230758, this.zGt);
      }
      else if ((com.tencent.mm.storage.ad.arc(this.caz.getTalkerUserName())) || (com.tencent.mm.storage.ad.are(this.caz.getTalkerUserName())) || (com.tencent.mm.storage.ad.nM(this.caz.getTalkerUserName())))
      {
        a(2131298284, 2131230740, this.zGt);
      }
      else if (com.tencent.mm.storage.ad.na(this.caz.getTalkerUserName()))
      {
        if (this.caz.ay(com.tencent.mm.ui.chatting.c.b.a.class) != null) {
          ((com.tencent.mm.ui.chatting.c.b.a)this.caz.ay(com.tencent.mm.ui.chatting.c.b.a.class)).dJz();
        }
      }
      else if ((((v)this.caz.ay(v.class)).dIU()) && (i.atT(this.caz.getTalkerUserName())))
      {
        a(2131298284, 2131231802, this.zGt);
      }
      else
      {
        ((x)this.caz.ay(x.class)).dIN();
        localObject = (com.tencent.mm.ui.chatting.c.b.d)this.caz.ay(com.tencent.mm.ui.chatting.c.b.d.class);
        if ((com.tencent.mm.model.t.nI(this.caz.getTalkerUserName())) || (((com.tencent.mm.ui.chatting.c.b.d)localObject).dHv()))
        {
          if (((f)this.caz.ay(f.class)).dHO())
          {
            ab.i("MicroMsg.ChattingUI.HeaderComponent", "cpan show chatroom right btn");
            a(2131298284, 2131230740, this.zGt);
            this.caz.showOptionMenu(true);
          }
          else if ((((com.tencent.mm.ui.chatting.c.b.d)localObject).dHv()) && (!((com.tencent.mm.ui.chatting.c.b.d)localObject).dHw()))
          {
            a(2131298284, 2131230754, this.zGt);
            this.caz.showOptionMenu(true);
          }
          else
          {
            this.caz.showOptionMenu(false);
            AppMethodBeat.o(31515);
          }
        }
        else {
          a(2131298284, 2131230740, this.zGt);
        }
      }
    }
    this.caz.showOptionMenu(true);
    AppMethodBeat.o(31515);
  }
  
  public final void eS(View paramView)
  {
    AppMethodBeat.i(31510);
    ab.d("MicroMsg.ChattingUI.HeaderComponent", "dealContentView");
    if (isSupportCustomActionBar())
    {
      if (this.mActionBarContainer == null) {
        this.mActionBarContainer = ((ActionBarContainer)((ViewStub)paramView.findViewById(2131822437)).inflate());
      }
      com.tencent.mm.ui.s locals = this.zGq;
      paramView = (ViewGroup)paramView;
      locals.zbR.MO = paramView;
    }
    AppMethodBeat.o(31510);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    int j = 1;
    AppMethodBeat.i(31494);
    super.onConfigurationChanged(paramConfiguration);
    ab.d("MicroMsg.ChattingUI.HeaderComponent", "getConfiguration().orientation = " + this.caz.zJz.getMMResources().getConfiguration().orientation + ", newConfig.orientation = " + paramConfiguration.orientation);
    this.caz.zJz.getMMResources().getConfiguration().orientation = paramConfiguration.orientation;
    ((com.tencent.mm.ui.chatting.c.b.o)this.caz.ay(com.tencent.mm.ui.chatting.c.b.o.class)).dIg().dnV();
    int i;
    if (this.mActionBarContainer != null)
    {
      i = 1;
      if (this.zGs == null) {
        break label250;
      }
    }
    for (;;)
    {
      if ((i & j) != 0)
      {
        i = com.tencent.mm.compatible.util.a.bL(this.caz.zJz.getContext());
        this.zGs.setMinimumHeight(i);
        ViewGroup.LayoutParams localLayoutParams2 = this.zGs.getLayoutParams();
        ViewGroup.LayoutParams localLayoutParams1 = localLayoutParams2;
        if (localLayoutParams2 == null) {
          localLayoutParams1 = new ViewGroup.LayoutParams(-1, -1);
        }
        localLayoutParams1.height = i;
        this.zGs.setLayoutParams(localLayoutParams1);
        localLayoutParams1 = this.mActionBarContainer.getLayoutParams();
        localLayoutParams1.height = i;
        this.mActionBarContainer.setLayoutParams(localLayoutParams1);
      }
      if (this.zGq != null) {
        this.zGq.zbR.mActionBar.onConfigurationChanged(paramConfiguration);
      }
      AppMethodBeat.o(31494);
      return;
      i = 0;
      break;
      label250:
      j = 0;
    }
  }
  
  public final void qV(boolean paramBoolean)
  {
    AppMethodBeat.i(31517);
    if (this.caz == null)
    {
      ab.e("MicroMsg.ChattingUI.HeaderComponent", "[updateBannerStatus] mChattingContext == null!");
      AppMethodBeat.o(31517);
      return;
    }
    if (!this.caz.dJG()) {
      if ((i.atT(this.caz.getTalkerUserName())) && (!((v)this.caz.ay(v.class)).dIU()))
      {
        this.zGp = this.caz.getTalkerUserName();
        dIA();
      }
    }
    for (;;)
    {
      if (paramBoolean)
      {
        dID();
        dIz();
      }
      AppMethodBeat.o(31517);
      return;
      if (!((com.tencent.mm.ui.chatting.c.b.t)this.caz.ay(com.tencent.mm.ui.chatting.c.b.t.class)).dIP())
      {
        dIB();
        continue;
        dIC();
      }
    }
  }
  
  public final void setBackBtn(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    AppMethodBeat.i(31528);
    this.zGr.b(new t.2(this, paramOnMenuItemClickListener));
    AppMethodBeat.o(31528);
  }
  
  public final void setMMSubTitle(String paramString)
  {
    AppMethodBeat.i(31527);
    int i = com.tencent.mm.cb.a.ao(this.caz.zJz.getContext(), 2131427758);
    paramString = j.b(this.caz.zJz.getContext(), paramString, i);
    com.tencent.mm.ui.a locala = this.zGr;
    if ((paramString == null) || (bo.isNullOrNil(paramString.toString())))
    {
      locala.yTn.setVisibility(8);
      AppMethodBeat.o(31527);
      return;
    }
    locala.yTn.setVisibility(0);
    locala.yTn.setText(paramString);
    if (com.tencent.mm.cb.a.gt(locala.yTn.getContext()))
    {
      locala.yTn.setTextSize(1, 14.0F);
      locala.gpL.setTextSize(1, 18.0F);
    }
    AppMethodBeat.o(31527);
  }
  
  public final void setMMTitle(int paramInt)
  {
    AppMethodBeat.i(31507);
    setMMTitle(this.caz.zJz.getMMResources().getString(paramInt));
    AppMethodBeat.o(31507);
  }
  
  public final void setMMTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(31526);
    if (com.tencent.mm.model.t.nK(this.caz.getTalkerUserName()))
    {
      this.zGr.setTitle(paramCharSequence);
      this.caz.zJz.updateDescription(this.caz.zJz.getContext().getString(2131298144, new Object[] { paramCharSequence }));
      AppMethodBeat.o(31526);
      return;
    }
    if (com.tencent.mm.storage.ad.arf(this.caz.txj.field_username))
    {
      paramCharSequence = ((com.tencent.mm.openim.a.b)g.E(com.tencent.mm.openim.a.b.class)).e(ah.getContext(), paramCharSequence.toString(), com.tencent.mm.cb.a.ao(ah.getContext(), 2131427501));
      this.zGr.setTitle(paramCharSequence);
      this.caz.zJz.updateDescription(this.caz.zJz.getContext().getString(2131298144, new Object[] { paramCharSequence }));
      AppMethodBeat.o(31526);
      return;
    }
    paramCharSequence = j.b(this.caz.zJz.getContext(), paramCharSequence, com.tencent.mm.cb.a.ao(this.caz.zJz.getContext(), 2131427501));
    this.zGr.setTitle(paramCharSequence);
    this.caz.zJz.updateDescription(this.caz.zJz.getContext().getString(2131298144, new Object[] { paramCharSequence }));
    AppMethodBeat.o(31526);
  }
  
  public final void setTitleForceNotifyIconVisibility(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(31530);
    Object localObject = this.zGr;
    if (paramInt == 0)
    {
      paramInt = 1;
      localObject = ((com.tencent.mm.ui.a)localObject).yTo;
      if (paramInt == 0) {
        break label47;
      }
    }
    label47:
    for (paramInt = i;; paramInt = 8)
    {
      ((ImageView)localObject).setVisibility(paramInt);
      AppMethodBeat.o(31530);
      return;
      paramInt = 0;
      break;
    }
  }
  
  public final void setTitleMuteIconVisibility(int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(31531);
    if (com.tencent.mm.model.t.oy(this.caz.getTalkerUserName()))
    {
      this.zGr.pY(false);
      AppMethodBeat.o(31531);
      return;
    }
    com.tencent.mm.ui.a locala = this.zGr;
    if (paramInt == 0) {
      bool = true;
    }
    locala.pY(bool);
    AppMethodBeat.o(31531);
  }
  
  public final void setTitlePhoneIconVisibility(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(31529);
    Object localObject = this.zGr;
    if (paramInt == 0)
    {
      paramInt = 1;
      localObject = ((com.tencent.mm.ui.a)localObject).yTp;
      if (paramInt == 0) {
        break label47;
      }
    }
    label47:
    for (paramInt = i;; paramInt = 8)
    {
      ((ImageView)localObject).setVisibility(paramInt);
      AppMethodBeat.o(31529);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.t
 * JD-Core Version:    0.7.0.1
 */