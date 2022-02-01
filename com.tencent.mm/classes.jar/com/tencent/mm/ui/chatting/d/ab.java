package com.tencent.mm.ui.chatting.d;

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
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.p;
import com.tencent.mm.g.a.yb;
import com.tencent.mm.g.b.a.dm;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.b;
import com.tencent.mm.model.as.b.a;
import com.tencent.mm.model.b.b.a;
import com.tencent.mm.model.b.b.b;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.plugin.newtips.PluginNewTips.a;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.protocal.protobuf.dnc;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.AppBrandNotifySettingsUI;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.ServiceNotifySettingsUI;
import com.tencent.mm.ui.SingleChatInfoUI;
import com.tencent.mm.ui.a.1;
import com.tencent.mm.ui.a.2;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.aa;
import com.tencent.mm.ui.chatting.d.b.ac;
import com.tencent.mm.ui.chatting.d.b.af;
import com.tencent.mm.ui.chatting.d.b.f;
import com.tencent.mm.ui.chatting.d.b.s;
import com.tencent.mm.ui.chatting.d.b.y;
import com.tencent.mm.ui.s.a;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.ui.tools.o;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.ui.x;
import com.tencent.mm.ui.z;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.chatting.d.a.a(fFo=y.class)
public class ab
  extends a
  implements y
{
  private final k.a JGU;
  private boolean JGZ;
  protected LinearLayout JKC;
  protected LinearLayout JKD;
  protected LinearLayout JKE;
  private List<String> JKF;
  private String JKG;
  public com.tencent.mm.ui.v JKH;
  private com.tencent.mm.ui.a JKI;
  private View JKJ;
  private a JKK;
  final x JKL;
  private b.a JKM;
  private Runnable JKN;
  private final com.tencent.mm.ak.e.a JKO;
  final int JKP;
  final int JKQ;
  final MenuItem.OnMenuItemClickListener JKR;
  private View JKS;
  private View JKT;
  private MenuItem.OnMenuItemClickListener backListener;
  private ActionBarContainer mActionBarContainer;
  private int yPa;
  
  public ab()
  {
    AppMethodBeat.i(35388);
    this.JKF = new LinkedList();
    this.yPa = 0;
    this.mActionBarContainer = null;
    this.JKH = null;
    this.JGZ = false;
    this.JKL = new b();
    this.JKM = new b.a()
    {
      public final void aDe()
      {
        AppMethodBeat.i(179915);
        com.tencent.mm.ui.chatting.e.a.fFx().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(35371);
            ba.aBQ().azQ();
            if (com.tencent.mm.model.b.b.a(b.b.hIP))
            {
              ab.c(ab.this);
              AppMethodBeat.o(35371);
              return;
            }
            ab.d(ab.this);
            AppMethodBeat.o(35371);
          }
        });
        AppMethodBeat.o(179915);
      }
    };
    this.JKN = null;
    this.JKO = new com.tencent.mm.ak.e.a()
    {
      public final void De(final String paramAnonymousString)
      {
        AppMethodBeat.i(179917);
        com.tencent.mm.ui.chatting.e.a.fFx().removeCallbacks(ab.e(ab.this));
        com.tencent.mm.ui.chatting.e.a.fFx().postDelayed(ab.a(ab.this, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(179916);
            if ((!bt.isNullOrNil(ab.f(ab.this))) && (!bt.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals(ab.f(ab.this)))) {
              ab.this.xV(false);
            }
            AppMethodBeat.o(179916);
          }
        }), 1000L);
        AppMethodBeat.o(179917);
      }
    };
    this.JGU = new k.a()
    {
      public final void a(String paramAnonymousString, m paramAnonymousm)
      {
        AppMethodBeat.i(179918);
        com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.ChattingUI.HeaderComponent", "roommember watcher notify ".concat(String.valueOf(paramAnonymousString)));
        if ((ab.this.cWM.fFv()) && (!bt.isNullOrNil(paramAnonymousString)))
        {
          ab.this.fDo();
          ab.this.fEc();
        }
        AppMethodBeat.o(179918);
      }
    };
    this.backListener = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(35381);
        boolean bool = ab.this.cWM.JOR.fAX();
        AppMethodBeat.o(35381);
        return bool;
      }
    };
    this.JKP = 1;
    this.JKQ = 2;
    this.JKR = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(179922);
        yb localyb = new yb();
        localyb.dMo.dsi = 5;
        localyb.dMo.talker = ab.this.cWM.BYG.field_username;
        localyb.dMo.context = ab.this.cWM.JOR.getContext();
        if (paramAnonymousMenuItem.getItemId() == 1) {
          localyb.dMo.dMk = 4;
        }
        for (;;)
        {
          com.tencent.mm.sdk.b.a.IbL.l(localyb);
          AppMethodBeat.o(179922);
          return true;
          if (paramAnonymousMenuItem.getItemId() == 2) {
            localyb.dMo.dMk = 2;
          }
        }
      }
    };
    this.JKS = null;
    this.JKT = null;
    AppMethodBeat.o(35388);
  }
  
  private View F(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(35406);
    if (this.JKJ == null)
    {
      if (paramViewGroup == null) {}
      for (this.JKJ = z.jO(this.cWM.JOR.getContext()).inflate(2131492921, null);; this.JKJ = z.jO(this.cWM.JOR.getContext()).inflate(2131492921, paramViewGroup, false))
      {
        paramViewGroup = this.JKJ;
        AppMethodBeat.o(35406);
        return paramViewGroup;
      }
    }
    if (this.JKJ.getParent() == null)
    {
      paramViewGroup = this.JKJ;
      AppMethodBeat.o(35406);
      return paramViewGroup;
    }
    if ((this.JKJ.getParent() instanceof ViewGroup))
    {
      ((ViewGroup)this.JKJ.getParent()).removeView(this.JKJ);
      paramViewGroup = this.JKJ;
      AppMethodBeat.o(35406);
      return paramViewGroup;
    }
    if (paramViewGroup == null) {}
    for (this.JKJ = z.jO(this.cWM.JOR.getContext()).inflate(2131492921, null);; this.JKJ = z.jO(this.cWM.JOR.getContext()).inflate(2131492921, paramViewGroup, false))
    {
      paramViewGroup = this.JKJ;
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
    s.a locala = this.cWM.JOR.findMenuInfo(0);
    if (bt.isNullOrNil(paramString))
    {
      if (locala == null)
      {
        this.cWM.JOR.addIconOptionMenu(0, paramInt1, paramInt2, paramOnMenuItemClickListener);
        AppMethodBeat.o(179927);
        return;
      }
      this.cWM.JOR.updateOptionMenu(0, paramInt1, paramInt2, paramOnMenuItemClickListener);
      AppMethodBeat.o(179927);
      return;
    }
    if (locala == null) {
      this.cWM.JOR.addIconOptionMenu(0, paramInt1, paramInt2, paramOnMenuItemClickListener);
    }
    for (paramOnMenuItemClickListener = this.cWM.JOR.findMenuInfo(0); paramOnMenuItemClickListener == null; paramOnMenuItemClickListener = locala)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ChattingUI.HeaderComponent", "updateMenuInfo menuInfo == null");
      AppMethodBeat.o(179927);
      return;
      this.cWM.JOR.updateOptionMenu(0, paramInt1, paramInt2, paramOnMenuItemClickListener);
    }
    this.JKK = new a(paramString, paramOnMenuItemClickListener);
    com.tencent.mm.plugin.newtips.a.dun().h(this.JKK);
    com.tencent.mm.plugin.newtips.a.g.a(this.JKK);
    if (paramOnMenuItemClickListener.JbQ) {
      com.tencent.mm.plugin.newtips.a.g.a(this.JKK, com.tencent.mm.plugin.newtips.a.k.wsL, true);
    }
    AppMethodBeat.o(179927);
  }
  
  private void a(ActionBar paramActionBar)
  {
    AppMethodBeat.i(35408);
    boolean bool = al.isDarkMode();
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
          al.a(((TextView)localObject).getPaint(), 0.8F);
          if (bool) {
            ((TextView)localObject).setTextColor(this.cWM.JOR.getMMResources().getColor(2131099886));
          }
        }
        localObject = (TextView)paramActionBar.getCustomView().findViewById(2131305509);
        if ((localObject != null) && (bool)) {
          ((TextView)localObject).setTextColor(this.cWM.JOR.getMMResources().getColor(2131099886));
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
  
  private void a(String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, s.b paramb)
  {
    AppMethodBeat.i(194049);
    s.a locala2 = this.cWM.JOR.findMenuInfo(0);
    s.a locala1 = locala2;
    if (locala2 != null) {
      if (locala2.ITD == 0)
      {
        locala1 = locala2;
        if (locala2.JbO == null) {}
      }
      else
      {
        this.cWM.JOR.removeOptionMenu(0);
        locala1 = null;
      }
    }
    if (locala1 == null)
    {
      this.cWM.JOR.addTextOptionMenu(0, paramString, paramOnMenuItemClickListener, null, paramb);
      AppMethodBeat.o(194049);
      return;
    }
    this.cWM.JOR.updateOptionMenuText(0, paramString);
    AppMethodBeat.o(194049);
  }
  
  private String am(am paramam)
  {
    AppMethodBeat.i(35403);
    if (paramam == null)
    {
      paramam = this.cWM.JOR.getContext().getString(2131756727);
      AppMethodBeat.o(35403);
      return paramam;
    }
    if (RegionCodeDecoder.aUp(paramam.getCountryCode()))
    {
      String str = paramam.getCity();
      if (!bt.isNullOrNil(str))
      {
        AppMethodBeat.o(35403);
        return str;
      }
      str = com.tencent.mm.model.v.zh(paramam.getProvince());
      if (!bt.isNullOrNil(str))
      {
        AppMethodBeat.o(35403);
        return str;
      }
      RegionCodeDecoder.fsz();
      paramam = RegionCodeDecoder.getLocName(paramam.getCountryCode());
      AppMethodBeat.o(35403);
      return paramam;
    }
    paramam = com.tencent.mm.model.v.zh(paramam.getProvince());
    if (!bt.isNullOrNil(paramam))
    {
      AppMethodBeat.o(35403);
      return paramam;
    }
    paramam = this.cWM.JOR.getContext().getString(2131756727);
    AppMethodBeat.o(35403);
    return paramam;
  }
  
  private void fAB()
  {
    AppMethodBeat.i(35399);
    if ((w.zv(this.cWM.getTalkerUserName())) || (w.zw(this.cWM.getTalkerUserName())) || (w.zx(this.cWM.getTalkerUserName())))
    {
      com.tencent.mm.plugin.newtips.a.duq();
      boolean bool = com.tencent.mm.plugin.newtips.a.e.LM(com.tencent.mm.plugin.newtips.a.d.wsk);
      this.cWM.JOR.addIconOptionMenu(0, 2131755135, 2131689511, Boolean.valueOf(bool).booleanValue(), this.JKL);
    }
    AppMethodBeat.o(35399);
  }
  
  private void fDZ()
  {
    AppMethodBeat.i(35400);
    if (com.tencent.mm.kernel.g.ajA().aiK())
    {
      p.aEk().b(this.JKO);
      ba.aBQ();
      com.tencent.mm.model.c.azz().remove(this.JGU);
    }
    com.tencent.mm.ui.chatting.e.a.fFx().removeCallbacks(this.JKN);
    com.tencent.mm.model.q.aAf();
    if (this.JKK != null)
    {
      com.tencent.mm.plugin.newtips.a.dun();
      com.tencent.mm.plugin.newtips.a.i.i(this.JKK);
    }
    AppMethodBeat.o(35400);
  }
  
  private void fEb()
  {
    AppMethodBeat.i(35409);
    this.JKF.clear();
    this.JKF.add(this.cWM.JOR.getStringExtra("Chat_User"));
    AppMethodBeat.o(35409);
  }
  
  private void fEd()
  {
    AppMethodBeat.i(35413);
    if (this.cWM.JOR.getContext() == null)
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.ChattingUI.HeaderComponent", "getActivity is null");
      AppMethodBeat.o(35413);
      return;
    }
    fEj();
    ViewGroup localViewGroup = (ViewGroup)this.cWM.JOR.getContext().findViewById(2131298063);
    com.tencent.mm.pluginsdk.ui.b.a locala = com.tencent.mm.ui.conversation.a.e.a(this.cWM.JOR.getContext(), com.tencent.mm.ui.conversation.a.e.a.Kyj, new Object[] { b.b.hIP });
    if ((localViewGroup != null) && (locala != null) && (locala.getView() != null) && (this.JKT == null))
    {
      this.JKT = locala.getView();
      localViewGroup.addView(this.JKT, new ViewGroup.LayoutParams(-1, -2));
    }
    AppMethodBeat.o(35413);
  }
  
  private void fEf()
  {
    AppMethodBeat.i(35415);
    if ((this.cWM.fFv()) || (this.JKC == null))
    {
      fEg();
      AppMethodBeat.o(35415);
      return;
    }
    fEg();
    com.tencent.mm.pluginsdk.ui.b.a locala2;
    if (this.JKC.getTag() == null)
    {
      locala2 = com.tencent.mm.ui.conversation.a.e.a(this.cWM.JOR.getContext(), com.tencent.mm.ui.conversation.a.e.a.KxX, new Object[] { this.cWM.getTalkerUserName(), this.cWM.fCR() });
      locala1 = locala2;
      if (locala2 != null)
      {
        locala1 = locala2;
        if (locala2.getView() != null) {
          this.JKC.addView(locala2.getView(), new ViewGroup.LayoutParams(-1, -2));
        }
      }
    }
    for (com.tencent.mm.pluginsdk.ui.b.a locala1 = locala2;; locala1 = (com.tencent.mm.pluginsdk.ui.b.a)this.JKC.getTag())
    {
      if (locala1 != null)
      {
        this.JKC.setVisibility(0);
        this.JKC.setTag(locala1);
      }
      com.tencent.mm.plugin.report.service.g.yhR.f(11003, new Object[] { this.cWM.getTalkerUserName(), Integer.valueOf(1), Integer.valueOf(0) });
      AppMethodBeat.o(35415);
      return;
    }
  }
  
  private void fEg()
  {
    AppMethodBeat.i(35416);
    this.JKC.setVisibility(8);
    if (this.JKE != null) {
      this.JKE.setVisibility(8);
    }
    AppMethodBeat.o(35416);
  }
  
  private void fEh()
  {
    AppMethodBeat.i(35417);
    if (this.cWM.JOR.getContext() == null)
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.ChattingUI.HeaderComponent", "getActivity is null");
      AppMethodBeat.o(35417);
      return;
    }
    fEi();
    ViewGroup localViewGroup = (ViewGroup)this.cWM.JOR.getContext().findViewById(2131298070);
    com.tencent.mm.pluginsdk.ui.b.a locala = com.tencent.mm.ui.conversation.a.e.a(this.cWM.JOR.getContext(), com.tencent.mm.ui.conversation.a.e.a.KxY, new Object[] { this.cWM.getTalkerUserName(), this.cWM.fCR(), Boolean.valueOf(this.cWM.fFv()) });
    if ((localViewGroup != null) && (locala != null) && (locala.getView() != null) && (this.JKS == null))
    {
      this.JKS = locala.getView();
      localViewGroup.addView(this.JKS, new ViewGroup.LayoutParams(-1, -2));
    }
    AppMethodBeat.o(35417);
  }
  
  private void fEi()
  {
    AppMethodBeat.i(35418);
    ViewGroup localViewGroup = (ViewGroup)this.cWM.JOR.getContext().findViewById(2131298070);
    if ((localViewGroup != null) && (this.JKS != null))
    {
      localViewGroup.removeView(this.JKS);
      this.JKS = null;
    }
    AppMethodBeat.o(35418);
  }
  
  private void fEj()
  {
    AppMethodBeat.i(35419);
    ViewGroup localViewGroup = (ViewGroup)this.cWM.JOR.getContext().findViewById(2131298063);
    if ((localViewGroup != null) && (this.JKT != null))
    {
      localViewGroup.removeView(this.JKT);
      this.JKT = null;
    }
    AppMethodBeat.o(35419);
  }
  
  private boolean isSupportCustomActionBar()
  {
    AppMethodBeat.i(35404);
    boolean bool = this.cWM.JOR.isSupportNavigationSwipeBack();
    AppMethodBeat.o(35404);
    return bool;
  }
  
  public final void a(com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(35390);
    super.a(parama);
    if (isSupportCustomActionBar())
    {
      this.JKH = new com.tencent.mm.ui.v();
      parama = this.JKH;
      BaseChattingUIFragment localBaseChattingUIFragment = this.cWM.JOR;
      parama.Jco = localBaseChattingUIFragment;
      parama.Jcp = new com.tencent.mm.ui.b.b(localBaseChattingUIFragment.thisActivity(), parama);
      this.cWM.JOR.setActivityController(this.JKH);
    }
    AppMethodBeat.o(35390);
  }
  
  public final void a(boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(194050);
    com.tencent.mm.ui.a locala = this.JKI;
    int i;
    if (!paramBoolean)
    {
      locala.ISe.setVisibility(0);
      i = locala.iVq.getCurrentTextColor();
      locala.ISe.setIconColor(i);
      locala.ISd.setOnClickListener(paramOnClickListener);
      o.gU(locala.ISd);
      locala.ISh.setVisibility(8);
      locala.ISg.setOnClickListener(null);
      o.gV(locala.ISg);
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ActionBarCustomArea", "fixWhenTitleTooLong, forSubTitle: ".concat(String.valueOf(paramBoolean)));
      if (paramBoolean) {
        break;
      }
      locala.iVq.post(new a.1(locala));
      AppMethodBeat.o(194050);
      return;
      locala.ISh.setVisibility(0);
      i = locala.ISf.getCurrentTextColor();
      locala.ISh.setIconColor(i);
      locala.ISg.setOnClickListener(paramOnClickListener);
      o.gU(locala.ISg);
      locala.ISe.setVisibility(8);
      locala.ISd.setOnClickListener(null);
      o.gV(locala.ISd);
    }
    locala.iVq.post(new a.2(locala));
    AppMethodBeat.o(194050);
  }
  
  public final void adj(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(35427);
    Object localObject = this.JKI;
    if (paramInt == 0)
    {
      paramInt = 1;
      localObject = ((com.tencent.mm.ui.a)localObject).ISl;
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
  
  public final com.tencent.mm.ui.v fAW()
  {
    return this.JKH;
  }
  
  public final void fCC()
  {
    AppMethodBeat.i(35397);
    super.fCC();
    fDZ();
    AppMethodBeat.o(35397);
  }
  
  public final void fDY()
  {
    AppMethodBeat.i(35398);
    if (this.cWM.getHeaderViewsCount() > 0) {
      this.JKC = ((LinearLayout)this.cWM.getListView().findViewById(2131301446));
    }
    for (;;)
    {
      if ((((af)this.cWM.bh(af.class)).fEz()) && (this.cWM.getListView().getFooterViewsCount() == 0))
      {
        this.JKD = ((LinearLayout)this.cWM.JOR.getContext().getLayoutInflater().inflate(2131496441, null));
        this.cWM.getListView().addFooterView(this.JKD);
        if (((af)this.cWM.bh(af.class)).fEA())
        {
          int i = com.tencent.mm.kernel.g.ajC().ajl().getInt(al.a.IJU, 0);
          if (i != 0)
          {
            localObject1 = this.cWM.getListView().findViewById(2131308346);
            localObject2 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
            ((LinearLayout.LayoutParams)localObject2).height = i;
            ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          }
        }
      }
      fEg();
      AppMethodBeat.o(35398);
      return;
      this.JKC = ((LinearLayout)this.cWM.JOR.getContext().getLayoutInflater().inflate(2131493515, null));
      Object localObject1 = this.cWM;
      Object localObject2 = this.JKC;
      ((com.tencent.mm.ui.chatting.e.a)localObject1).JOS.addHeaderView((View)localObject2);
    }
  }
  
  public final void fDo()
  {
    AppMethodBeat.i(35401);
    this.cWM.JOR.setMMSubTitle(null);
    if (((af)this.cWM.bh(af.class)).fEz())
    {
      setMMTitle("");
      AppMethodBeat.o(35401);
      return;
    }
    if (w.zv(this.cWM.getTalkerUserName()))
    {
      setMMTitle(this.cWM.BYG.adu());
      AppMethodBeat.o(35401);
      return;
    }
    if (((com.tencent.mm.ui.chatting.d.b.ai)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.ai.class)).fEN())
    {
      setMMTitle(2131762904);
      AppMethodBeat.o(35401);
      return;
    }
    if (am.aSN(this.cWM.getTalkerUserName()))
    {
      ((s)this.cWM.bh(s.class)).fDC().setWordCountLimit(140);
      setMMTitle(this.cWM.BYG.adv());
      AppMethodBeat.o(35401);
      return;
    }
    if (w.Ak(this.cWM.getTalkerUserName()))
    {
      setMMTitle(this.cWM.BYG.adu());
      AppMethodBeat.o(35401);
      return;
    }
    if (am.zs(this.cWM.getTalkerUserName()))
    {
      setMMTitle(this.cWM.JOR.getContext().getString(2131756698, new Object[] { am(this.cWM.BYG) }).trim());
      AppMethodBeat.o(35401);
      return;
    }
    if (am.yt(this.cWM.getTalkerUserName()))
    {
      if (this.cWM.bh(com.tencent.mm.ui.chatting.d.b.a.class) != null)
      {
        ((com.tencent.mm.ui.chatting.d.b.a)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.a.class)).fDo();
        AppMethodBeat.o(35401);
      }
    }
    else
    {
      if (this.cWM.fFu())
      {
        boolean bool = ((f)this.cWM.bh(f.class)).fDc();
        String str = this.cWM.BYG.field_conRemark;
        if (bt.isNullOrNil(str))
        {
          str = this.cWM.BYG.field_nickname;
          if (!bt.isNullOrNil(str)) {
            break label604;
          }
          if (com.tencent.mm.model.q.yS(this.cWM.getTalkerUserName()) != 0) {
            break label545;
          }
          str = this.cWM.JOR.getContext().getString(2131757293);
        }
        for (;;)
        {
          Object localObject;
          if (!w.zl(this.cWM.getTalkerUserName()))
          {
            localObject = str;
            if (!bool) {}
          }
          else
          {
            str = str + " ";
            localObject = com.tencent.mm.pluginsdk.ui.span.k.d(this.cWM.JOR.getContext(), com.tencent.mm.pluginsdk.ui.span.k.b(this.cWM.JOR.getContext(), str, com.tencent.mm.cc.a.ax(this.cWM.JOR.getContext(), 2131165192)));
          }
          setMMTitle((CharSequence)localObject);
          AppMethodBeat.o(35401);
          return;
          setMMSubTitle(com.tencent.mm.pluginsdk.ui.span.k.c(this.cWM.JOR.getContext(), this.cWM.fCR()).toString());
          break;
          label545:
          str = this.cWM.JOR.getContext().getString(2131759496, new Object[] { this.cWM.JOR.getContext().getString(2131757293), Integer.valueOf(com.tencent.mm.model.q.yS(this.cWM.getTalkerUserName())) });
          continue;
          label604:
          str = this.cWM.JOR.getContext().getString(2131759496, new Object[] { this.cWM.BYG.adv(), Integer.valueOf(com.tencent.mm.model.q.yS(this.cWM.getTalkerUserName())) });
        }
      }
      if (((com.tencent.mm.ui.chatting.d.b.d)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fCJ())
      {
        AppMethodBeat.o(35401);
        return;
      }
      if (((com.tencent.mm.ui.chatting.d.b.i)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.i.class)).fDn())
      {
        ((com.tencent.mm.ui.chatting.d.b.i)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.i.class)).fDo();
        AppMethodBeat.o(35401);
        return;
      }
      this.JKI.wW(am.aSP(this.cWM.getTalkerUserName()));
      this.cWM.JOR.setMMTitle(this.cWM.BYG.adv());
      this.JKI.wW(am.aSP(this.cWM.getTalkerUserName()));
      if (am.aSQ(this.cWM.getTalkerUserName())) {
        this.cWM.JOR.setMMSubTitle(((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).bC(this.cWM.BYG.field_openImAppid, this.cWM.BYG.field_descWordingId));
      }
    }
    AppMethodBeat.o(35401);
  }
  
  public final void fEa()
  {
    AppMethodBeat.i(35407);
    if ((this.cWM.JOR.isCurrentActivity) || (!isSupportCustomActionBar()))
    {
      localObject1 = ((AppCompatActivity)this.cWM.JOR.getContext()).getSupportActionBar();
      localObject2 = F(null);
      ((ActionBar)localObject1).setCustomView((View)localObject2);
      this.JKI = new com.tencent.mm.ui.a((View)localObject2);
      a((ActionBar)localObject1);
      this.JKI.wW(false);
      ((ActionBar)localObject1).setDisplayOptions((((ActionBar)localObject1).getDisplayOptions() | 0x10) & 0xFFFFFFFB & 0xFFFFFFFD & 0xFFFFFFF7);
      fEb();
      setBackBtn(this.backListener);
      AppMethodBeat.o(35407);
      return;
    }
    Object localObject1 = (ViewGroup)this.mActionBarContainer.findViewById(2131296343);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingUI.HeaderComponent", "mActionBarContainer %s", new Object[] { this.mActionBarContainer });
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingUI.HeaderComponent", "ctxView %s", new Object[] { this.mActionBarContainer.findViewById(2131296357) });
    ((ViewGroup)localObject1).setVisibility(0);
    Object localObject2 = this.JKH.getSupportActionBar();
    View localView = F((ViewGroup)localObject1);
    ((ActionBar)localObject2).setCustomView(localView);
    this.JKI = new com.tencent.mm.ui.a(localView);
    int j = ((ActionBar)localObject2).getHeight();
    int i = j;
    if (j == 0)
    {
      localObject1 = this.cWM.JOR.getMMResources().getDisplayMetrics();
      if (((DisplayMetrics)localObject1).widthPixels <= ((DisplayMetrics)localObject1).heightPixels) {
        break label322;
      }
    }
    label322:
    for (i = this.cWM.JOR.getMMResources().getDimensionPixelSize(2131165251);; i = this.cWM.JOR.getMMResources().getDimensionPixelSize(2131165252))
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
  
  public final void fEc()
  {
    AppMethodBeat.i(35410);
    Object localObject = (com.tencent.mm.ui.chatting.d.b.ai)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.ai.class);
    if ((((com.tencent.mm.ui.chatting.d.b.ai)localObject).fEN()) || (((com.tencent.mm.ui.chatting.d.b.ai)localObject).fEM()))
    {
      this.cWM.showOptionMenu(false);
      AppMethodBeat.o(35410);
      return;
    }
    if (((com.tencent.mm.ui.chatting.d.b.q)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.q.class)).fDB())
    {
      AppMethodBeat.o(35410);
      return;
    }
    if (w.zy(this.cWM.getTalkerUserName()))
    {
      this.cWM.showOptionMenu(false);
      AppMethodBeat.o(35410);
      return;
    }
    if (((af)this.cWM.bh(af.class)).fEz()) {
      a(this.cWM.JOR.getContext().getString(2131755779), this.JKL, s.b.JbS);
    }
    while (am.zs(this.cWM.getTalkerUserName()))
    {
      this.cWM.ya(true);
      AppMethodBeat.o(35410);
      return;
      if ((w.zw(this.cWM.getTalkerUserName())) || (w.zx(this.cWM.getTalkerUserName())))
      {
        a(2131755135, 2131689511, this.JKL);
      }
      else if (w.zv(this.cWM.getTalkerUserName()))
      {
        com.tencent.mm.plugin.newtips.a.duq();
        boolean bool = com.tencent.mm.plugin.newtips.a.e.LM(com.tencent.mm.plugin.newtips.a.d.wsk);
        this.cWM.JOR.addIconOptionMenu(0, 2131755135, 2131689511, Boolean.valueOf(bool).booleanValue(), this.JKL);
      }
      else if (w.zA(this.cWM.getTalkerUserName()))
      {
        a(2131755135, 2131689511, this.JKL);
      }
      else if (w.zH(this.cWM.getTalkerUserName()))
      {
        a(2131755135, 2131689511, this.JKL);
        com.tencent.mm.plugin.report.service.g.yhR.kvStat(10071, "1");
      }
      else if (w.zI(this.cWM.getTalkerUserName()))
      {
        a(2131755135, 2131689511, this.JKL);
      }
      else if (w.Ai(this.cWM.getTalkerUserName()))
      {
        a(2131755135, 2131689511, this.JKL);
      }
      else if (w.An(this.cWM.getTalkerUserName()))
      {
        a(2131755135, 2131689511, this.JKL);
      }
      else if (w.Ap(this.cWM.getTalkerUserName()))
      {
        if (w.zT(this.cWM.getTalkerUserName()))
        {
          this.cWM.showOptionMenu(false);
          AppMethodBeat.o(35410);
          return;
        }
        a(2131755135, 2131689511, this.JKL);
      }
      else if ((am.aSN(this.cWM.getTalkerUserName())) || (am.aSP(this.cWM.getTalkerUserName())) || (am.zs(this.cWM.getTalkerUserName())))
      {
        a(2131757275, 2131689493, this.JKL);
      }
      else if (am.yt(this.cWM.getTalkerUserName()))
      {
        if (this.cWM.bh(com.tencent.mm.ui.chatting.d.b.a.class) != null) {
          ((com.tencent.mm.ui.chatting.d.b.a)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.a.class)).fFp();
        }
      }
      else if ((((ac)this.cWM.bh(ac.class)).fEy()) && (l.aWd(this.cWM.getTalkerUserName())))
      {
        a(2131757275, 2131690972, this.JKL);
      }
      else if ((this.cWM.BYG != null) && (this.cWM.BYG.fqg()) && ((com.tencent.mm.am.g.DL(this.cWM.getTalkerUserName())) || (com.tencent.mm.am.g.DN(this.cWM.getTalkerUserName()))))
      {
        a(2131755135, 2131690592, this.JKL);
      }
      else
      {
        ((ag)this.cWM.bh(ag.class)).fEr();
        localObject = (com.tencent.mm.ui.chatting.d.b.d)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.d.class);
        if ((w.zj(this.cWM.getTalkerUserName())) || (((com.tencent.mm.ui.chatting.d.b.d)localObject).fCH()))
        {
          if (((f)this.cWM.bh(f.class)).fDa())
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingUI.HeaderComponent", "cpan show chatroom right btn");
            if ((((f)this.cWM.bh(f.class)).fDb()) && (((f)this.cWM.bh(f.class)).YH()) && (com.tencent.mm.model.q.aAg())) {
              a(2131757275, 2131689493, "chatroom", this.JKL);
            }
            for (;;)
            {
              this.cWM.showOptionMenu(true);
              break;
              a(2131757275, 2131689493, this.JKL);
            }
          }
          if ((((com.tencent.mm.ui.chatting.d.b.d)localObject).fCH()) && (!((com.tencent.mm.ui.chatting.d.b.d)localObject).fCI()))
          {
            a(2131757275, 2131689507, this.JKL);
            this.cWM.showOptionMenu(true);
          }
          else
          {
            this.cWM.showOptionMenu(false);
            AppMethodBeat.o(35410);
          }
        }
        else
        {
          a(2131757275, 2131689493, this.JKL);
        }
      }
    }
    this.cWM.showOptionMenu(true);
    AppMethodBeat.o(35410);
  }
  
  @SuppressLint({"ResourceType"})
  public final void fEe()
  {
    AppMethodBeat.i(35414);
    if (this.cWM.JOR.hasDestory)
    {
      AppMethodBeat.o(35414);
      return;
    }
    fEg();
    final LinearLayout localLinearLayout;
    if (this.JKE == null)
    {
      l.a(this.cWM.JOR, 2131306443);
      this.JKE = ((LinearLayout)this.cWM.JOR.getContext().findViewById(2131300123));
      localLinearLayout = (LinearLayout)this.cWM.JOR.getContext().getLayoutInflater().inflate(2131493514, null);
      this.JKE.addView(localLinearLayout, new ViewGroup.LayoutParams(-1, -2));
    }
    for (;;)
    {
      this.JKE.setVisibility(0);
      localLinearLayout.setVisibility(0);
      localLinearLayout.findViewById(2131296460);
      String str = this.JKG;
      Object localObject = str;
      if (bt.isNullOrNil(str)) {
        localObject = this.cWM.BYG.field_username;
      }
      com.tencent.mm.ak.c.a((String)localObject, false, -1, null);
      localObject = (Button)localLinearLayout.findViewById(2131297974);
      if (((aa)this.cWM.bh(aa.class)).fEs()) {
        ((aa)this.cWM.bh(aa.class)).a((Button)localObject, localLinearLayout, this.JKE);
      }
      localLinearLayout.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(35386);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/HeaderComponent$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          ab.b(ab.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/HeaderComponent$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(35386);
        }
      });
      ((Button)localObject).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(35370);
          Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/HeaderComponent$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
          if (((aa)ab.this.cWM.bh(aa.class)).fEs())
          {
            ((aa)ab.this.cWM.bh(aa.class)).adl(ab.k(ab.this));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/HeaderComponent$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(35370);
            return;
          }
          if ((int)ab.this.cWM.BYG.gfj == 0)
          {
            ba.aBQ();
            if (com.tencent.mm.model.c.azp().ah(ab.this.cWM.BYG) != -1) {
              com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ChattingUI.HeaderComponent", "[insertRetId] successfully! username:%s", new Object[] { ab.this.cWM.BYG });
            }
          }
          if (w.vF(ab.this.cWM.BYG.field_username))
          {
            paramAnonymousView = ab.this.cWM.BYG.field_username;
            label202:
            ba.aBQ();
            Object localObject2 = com.tencent.mm.model.c.azp().Bf(ab.f(ab.this));
            if (localObject2 == null) {
              break label400;
            }
            localObject1 = bt.bI(((aw)localObject2).ePK, "");
            label236:
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingUI.HeaderComponent", "dkverify banner add:%s chat:%s ticket", new Object[] { ab.f(ab.this), paramAnonymousView, localObject1 });
            if (((!TextUtils.isEmpty(paramAnonymousView)) && (TextUtils.isEmpty((CharSequence)localObject1))) || (am.aSQ(((aw)localObject2).field_username))) {
              break label406;
            }
            localObject2 = new com.tencent.mm.pluginsdk.ui.applet.a(ab.this.cWM.JOR.getContext(), new a.a()
            {
              public final void a(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2, String paramAnonymous2String1, String paramAnonymous2String2)
              {
                AppMethodBeat.i(179910);
                if (paramAnonymous2Boolean1)
                {
                  w.u(ab.this.cWM.BYG);
                  ab.2.this.JKV.setVisibility(8);
                }
                AppMethodBeat.o(179910);
              }
            });
            LinkedList localLinkedList = new LinkedList();
            localLinkedList.add(Integer.valueOf(3));
            ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).aME((String)localObject1);
            ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).EUV = true;
            ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).d(ab.f(ab.this), paramAnonymousView, localLinkedList);
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.g.yhR.f(11004, new Object[] { ab.f(ab.this), Integer.valueOf(3) });
            break;
            paramAnonymousView = "";
            break label202;
            label400:
            localObject1 = "";
            break label236;
            label406:
            as.a.hFO.a(ab.f(ab.this), paramAnonymousView, new as.b.a()
            {
              public final void p(String paramAnonymous2String, boolean paramAnonymous2Boolean)
              {
                AppMethodBeat.i(179912);
                com.tencent.mm.pluginsdk.ui.applet.a locala = new com.tencent.mm.pluginsdk.ui.applet.a(ab.this.cWM.JOR.getContext(), new a.a()
                {
                  public final void a(boolean paramAnonymous3Boolean1, boolean paramAnonymous3Boolean2, String paramAnonymous3String1, String paramAnonymous3String2)
                  {
                    AppMethodBeat.i(179911);
                    if (paramAnonymous3Boolean1)
                    {
                      w.u(ab.this.cWM.BYG);
                      ab.2.this.JKV.setVisibility(8);
                    }
                    AppMethodBeat.o(179911);
                  }
                });
                LinkedList localLinkedList = new LinkedList();
                localLinkedList.add(Integer.valueOf(3));
                ba.aBQ();
                paramAnonymous2String = com.tencent.mm.model.c.azp().Bf(ab.f(ab.this));
                if (paramAnonymous2String != null) {}
                for (paramAnonymous2String = bt.bI(paramAnonymous2String.ePK, "");; paramAnonymous2String = "")
                {
                  locala.aME(paramAnonymous2String);
                  locala.EUV = true;
                  locala.d(ab.f(ab.this), paramAnonymousView, localLinkedList);
                  AppMethodBeat.o(179912);
                  return;
                }
              }
            });
          }
        }
      });
      com.tencent.mm.plugin.report.service.g.yhR.f(11004, new Object[] { this.JKG, Integer.valueOf(1) });
      AppMethodBeat.o(35414);
      return;
      localLinearLayout = (LinearLayout)this.JKE.findViewById(2131297975);
    }
  }
  
  public final int fEk()
  {
    AppMethodBeat.i(35420);
    int j = 0;
    int i = j;
    if (this.JKC != null)
    {
      i = j;
      if (this.JKC.isShown()) {
        i = this.JKC.getHeight() + 0;
      }
    }
    AppMethodBeat.o(35420);
    return i;
  }
  
  public final void fws()
  {
    AppMethodBeat.i(35391);
    fEa();
    AppMethodBeat.o(35391);
  }
  
  public final void fwt()
  {
    AppMethodBeat.i(35392);
    this.yPa = this.cWM.JOR.getIntExtra("add_scene", 0);
    p.aEk().a(this.JKO);
    ba.aBQ();
    com.tencent.mm.model.c.azz().add(this.JGU);
    setBackBtn(this.backListener);
    fAB();
    fDo();
    fEc();
    fEg();
    this.JGZ = true;
    com.tencent.mm.model.q.a(this.cWM.getTalkerUserName(), new PluginNewTips.a()
    {
      public final void dur()
      {
        AppMethodBeat.i(179909);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingUI.HeaderComponent", "onCallback");
        ab.this.fEc();
        AppMethodBeat.o(179909);
      }
    });
    AppMethodBeat.o(35392);
  }
  
  public final void fwu()
  {
    AppMethodBeat.i(35393);
    xV(true);
    AppMethodBeat.o(35393);
  }
  
  public final void fwv()
  {
    AppMethodBeat.i(35394);
    ba.aBQ().azO().a(new com.tencent.mm.model.b.e.a()
    {
      public final void aDf()
      {
        AppMethodBeat.i(35378);
        com.tencent.mm.ui.chatting.e.a.fFx().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(35377);
            ab.g(ab.this);
            AppMethodBeat.o(35377);
          }
        });
        AppMethodBeat.o(35378);
      }
      
      public final void aDg()
      {
        AppMethodBeat.i(35379);
        ab.h(ab.this);
        AppMethodBeat.o(35379);
      }
    });
    ba.aBQ().azP().a(new com.tencent.mm.model.b.e.a()
    {
      public final void aDf()
      {
        AppMethodBeat.i(179920);
        com.tencent.mm.ui.chatting.e.a.fFx().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(179919);
            ab.i(ab.this);
            AppMethodBeat.o(179919);
          }
        });
        AppMethodBeat.o(179920);
      }
      
      public final void aDg()
      {
        AppMethodBeat.i(179921);
        ab.j(ab.this);
        AppMethodBeat.o(179921);
      }
    });
    com.tencent.mm.model.b.b localb = ba.aBQ().azQ();
    b.a locala = this.JKM;
    try
    {
      localb.mListeners.add(locala);
      if (!this.JGZ) {
        fAB();
      }
      this.JGZ = false;
      AppMethodBeat.o(35394);
      return;
    }
    finally
    {
      AppMethodBeat.o(35394);
    }
  }
  
  public final void fww()
  {
    AppMethodBeat.i(35395);
    if (com.tencent.mm.kernel.g.ajA().aiK())
    {
      ba.aBQ().azO().a(null);
      ba.aBQ().azP().a(null);
      com.tencent.mm.model.b.b localb = ba.aBQ().azQ();
      b.a locala = this.JKM;
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
  
  public final void fwx()
  {
    AppMethodBeat.i(35396);
    fDZ();
    AppMethodBeat.o(35396);
  }
  
  public final void gl(View paramView)
  {
    AppMethodBeat.i(35405);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ChattingUI.HeaderComponent", "dealContentView");
    if (isSupportCustomActionBar())
    {
      if (this.mActionBarContainer == null) {
        this.mActionBarContainer = ((ActionBarContainer)((ViewStub)paramView.findViewById(2131298079)).inflate());
      }
      com.tencent.mm.ui.v localv = this.JKH;
      paramView = (ViewGroup)paramView;
      localv.Jcp.WA = paramView;
    }
    AppMethodBeat.o(35405);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    int j = 1;
    AppMethodBeat.i(35389);
    super.onConfigurationChanged(paramConfiguration);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ChattingUI.HeaderComponent", "getConfiguration().orientation = " + this.cWM.JOR.getMMResources().getConfiguration().orientation + ", newConfig.orientation = " + paramConfiguration.orientation);
    this.cWM.JOR.getMMResources().getConfiguration().orientation = paramConfiguration.orientation;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChatFooter", "[dealOrientationChange] %s", new Object[] { ((s)this.cWM.bh(s.class)).fDC().getContext().getResources().getConfiguration() });
    int i;
    if (this.mActionBarContainer != null)
    {
      i = 1;
      if (this.JKJ == null) {
        break label271;
      }
    }
    for (;;)
    {
      if ((i & j) != 0)
      {
        i = com.tencent.mm.compatible.util.a.cb(this.cWM.JOR.getContext());
        this.JKJ.setMinimumHeight(i);
        ViewGroup.LayoutParams localLayoutParams2 = this.JKJ.getLayoutParams();
        ViewGroup.LayoutParams localLayoutParams1 = localLayoutParams2;
        if (localLayoutParams2 == null) {
          localLayoutParams1 = new ViewGroup.LayoutParams(-1, -1);
        }
        localLayoutParams1.height = i;
        this.JKJ.setLayoutParams(localLayoutParams1);
        localLayoutParams1 = this.mActionBarContainer.getLayoutParams();
        localLayoutParams1.height = i;
        this.mActionBarContainer.setLayoutParams(localLayoutParams1);
      }
      if (this.JKH != null) {
        this.JKH.Jcp.mActionBar.onConfigurationChanged(paramConfiguration);
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
    this.JKI.setClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179914);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/HeaderComponent$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (!ab.this.cWM.JOR.isScreenEnable())
        {
          com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.ChattingUI.HeaderComponent", "Actionbar customView onclick screen not enable");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/HeaderComponent$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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
            if (ab.3.this.ITv != null) {
              ab.3.this.ITv.onMenuItemClick(null);
            }
            AppMethodBeat.o(179913);
          }
        });
        ((af)ab.this.cWM.bh(af.class)).fEF();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/HeaderComponent$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(179914);
      }
    });
    this.JKI.fuT();
    AppMethodBeat.o(35423);
  }
  
  public final void setMMSubTitle(String paramString)
  {
    AppMethodBeat.i(35422);
    int i = com.tencent.mm.cc.a.ax(this.cWM.JOR.getContext(), 2131165466);
    paramString = com.tencent.mm.pluginsdk.ui.span.k.b(this.cWM.JOR.getContext(), paramString, i);
    this.JKI.al(paramString);
    AppMethodBeat.o(35422);
  }
  
  public final void setMMTitle(int paramInt)
  {
    AppMethodBeat.i(35402);
    setMMTitle(this.cWM.JOR.getMMResources().getString(paramInt));
    AppMethodBeat.o(35402);
  }
  
  public final void setMMTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(35421);
    if ((w.zl(this.cWM.getTalkerUserName())) || (((f)this.cWM.bh(f.class)).fDc()))
    {
      this.JKI.setTitle(paramCharSequence);
      this.cWM.JOR.updateDescription(this.cWM.JOR.getContext().getString(2131757133, new Object[] { paramCharSequence }));
      AppMethodBeat.o(35421);
      return;
    }
    if (am.aSQ(this.cWM.BYG.field_username))
    {
      paramCharSequence = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).e(aj.getContext(), paramCharSequence.toString(), com.tencent.mm.cc.a.ax(aj.getContext(), 2131165192));
      this.JKI.setTitle(paramCharSequence);
      this.cWM.JOR.updateDescription(this.cWM.JOR.getContext().getString(2131757133, new Object[] { paramCharSequence }));
      AppMethodBeat.o(35421);
      return;
    }
    paramCharSequence = com.tencent.mm.pluginsdk.ui.span.k.b(this.cWM.JOR.getContext(), paramCharSequence, com.tencent.mm.cc.a.ax(this.cWM.JOR.getContext(), 2131165192));
    this.JKI.setTitle(paramCharSequence);
    this.cWM.JOR.updateDescription(this.cWM.JOR.getContext().getString(2131757133, new Object[] { paramCharSequence }));
    AppMethodBeat.o(35421);
  }
  
  public final void setTitleForceNotifyIconVisibility(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(35425);
    Object localObject = this.JKI;
    if (paramInt == 0)
    {
      paramInt = 1;
      localObject = ((com.tencent.mm.ui.a)localObject).ISi;
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
    if ((w.Ai(this.cWM.getTalkerUserName())) || (w.An(this.cWM.getTalkerUserName())))
    {
      this.JKI.wV(false);
      AppMethodBeat.o(35426);
      return;
    }
    com.tencent.mm.ui.a locala = this.JKI;
    if (paramInt == 0) {
      bool = true;
    }
    locala.wV(bool);
    AppMethodBeat.o(35426);
  }
  
  public final void setTitlePhoneIconVisibility(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(35424);
    Object localObject = this.JKI;
    if (paramInt == 0)
    {
      paramInt = 1;
      localObject = ((com.tencent.mm.ui.a)localObject).ISj;
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
  
  public final void xV(boolean paramBoolean)
  {
    AppMethodBeat.i(35412);
    if (this.cWM == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ChattingUI.HeaderComponent", "[updateBannerStatus] mChattingContext == null!");
      AppMethodBeat.o(35412);
      return;
    }
    if (!this.cWM.fFv()) {
      if ((!w.zy(this.cWM.getTalkerUserName())) && (l.aWd(this.cWM.getTalkerUserName())) && (!((ac)this.cWM.bh(ac.class)).fEy()))
      {
        this.JKG = this.cWM.getTalkerUserName();
        fEe();
      }
    }
    for (;;)
    {
      if (paramBoolean)
      {
        fEh();
        fEd();
      }
      AppMethodBeat.o(35412);
      return;
      if (!((aa)this.cWM.bh(aa.class)).fEt())
      {
        fEf();
        continue;
        fEg();
      }
    }
  }
  
  final class a
    implements com.tencent.mm.plugin.newtips.a.a
  {
    private int ITC;
    public boolean JLd;
    private s.a JLe;
    private View fOB;
    private String path;
    
    public a(String paramString, s.a parama)
    {
      AppMethodBeat.i(179923);
      this.fOB = new View(ab.this.cWM.JOR.getContext());
      this.JLd = false;
      this.ITC = 0;
      this.path = paramString;
      this.JLe = parama;
      AppMethodBeat.o(179923);
    }
    
    public final void a(com.tencent.mm.plugin.newtips.a.k paramk, boolean paramBoolean)
    {
      AppMethodBeat.i(179924);
      com.tencent.mm.plugin.newtips.a.g.a(this, paramk, paramBoolean);
      AppMethodBeat.o(179924);
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
      return false;
    }
    
    public final boolean dkD()
    {
      return false;
    }
    
    public final String getPath()
    {
      return this.path;
    }
    
    public final View getRoot()
    {
      return this.fOB;
    }
    
    public final boolean ol(boolean paramBoolean)
    {
      AppMethodBeat.i(179925);
      paramBoolean = com.tencent.mm.plugin.newtips.a.g.a(paramBoolean, this);
      AppMethodBeat.o(179925);
      return paramBoolean;
    }
    
    public final boolean om(boolean paramBoolean)
    {
      AppMethodBeat.i(179926);
      this.JLd = paramBoolean;
      ab.this.cWM.JOR.updateOptionMenuRedDot(this.ITC, paramBoolean);
      AppMethodBeat.o(179926);
      return true;
    }
    
    public final boolean on(boolean paramBoolean)
    {
      return false;
    }
  }
  
  final class b
    extends x
  {
    b() {}
    
    public final void Zi()
    {
      AppMethodBeat.i(35387);
      if (((af)ab.this.cWM.bh(af.class)).fEB())
      {
        AppMethodBeat.o(35387);
        return;
      }
      Object localObject1;
      if (w.zl(ab.this.cWM.getTalkerUserName()))
      {
        localObject1 = new dm();
        ((dm)localObject1).mS(ab.this.cWM.getTalkerUserName());
        ((dm)localObject1).dUW = 4L;
        ((dm)localObject1).aLk();
      }
      if ((ab.a(ab.this) != null) && (ab.a(ab.this).JLd)) {
        com.tencent.mm.plugin.newtips.a.dun().LQ(25);
      }
      if (w.zx(ab.this.cWM.getTalkerUserName())) {
        com.tencent.mm.plugin.report.service.g.yhR.f(19540, new Object[] { Integer.valueOf(2) });
      }
      ab.this.cWM.hideVKB();
      Object localObject2;
      if (w.Ai(ab.this.cWM.getTalkerUserName()))
      {
        localObject1 = ab.this.cWM.JOR.getContext();
        localObject2 = new Intent(ab.this.cWM.JOR.getContext(), ServiceNotifySettingsUI.class);
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/ui/chatting/component/HeaderComponent$OptionListener", "onRealClick", "(Landroid/view/MenuItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((Activity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/chatting/component/HeaderComponent$OptionListener", "onRealClick", "(Landroid/view/MenuItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(35387);
        return;
      }
      if (w.An(ab.this.cWM.getTalkerUserName()))
      {
        localObject2 = new Intent(ab.this.cWM.JOR.getContext(), AppBrandNotifySettingsUI.class);
        localObject1 = (com.tencent.mm.plugin.appbrand.service.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.g.class);
        if (localObject1 == null) {
          break label874;
        }
        localObject1 = ((com.tencent.mm.plugin.appbrand.service.g)localObject1).aYA();
        ((Intent)localObject2).putExtra("report_session_id", (String)localObject1);
      }
      for (;;)
      {
        Activity localActivity = ab.this.cWM.JOR.getContext();
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(localActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/ui/chatting/component/HeaderComponent$OptionListener", "onRealClick", "(Landroid/view/MenuItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(localActivity, "com/tencent/mm/ui/chatting/component/HeaderComponent$OptionListener", "onRealClick", "(Landroid/view/MenuItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.plugin.report.service.g.yhR.f(19724, new Object[] { Integer.valueOf(1), Integer.valueOf(6), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null, null, null, Integer.valueOf(0), null, null, Integer.valueOf(0), null, null, localObject1 });
        AppMethodBeat.o(35387);
        return;
        if (w.zA(ab.this.cWM.getTalkerUserName()))
        {
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("Contact_User", ab.this.cWM.getTalkerUserName());
          com.tencent.mm.bs.d.b(ab.this.cWM.JOR.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject1);
          AppMethodBeat.o(35387);
          return;
        }
        if (((aa)ab.this.cWM.bh(aa.class)).fEs())
        {
          ab.b(ab.this);
          AppMethodBeat.o(35387);
          return;
        }
        if (((com.tencent.mm.ui.chatting.d.b.d)ab.this.cWM.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fCS())
        {
          AppMethodBeat.o(35387);
          return;
        }
        if (((com.tencent.mm.ui.chatting.d.b.i)ab.this.cWM.bh(com.tencent.mm.ui.chatting.d.b.i.class)).fDn()) {
          ((PluginGameLife)com.tencent.mm.kernel.g.ad(PluginGameLife.class)).jumpToGameLifeSingleChatInfoUIReport(ab.this.cWM.getTalkerUserName());
        }
        localObject2 = new Intent();
        ((Intent)localObject2).setClass(ab.this.cWM.JOR.getContext(), SingleChatInfoUI.class);
        ((Intent)localObject2).putExtra("Single_Chat_Talker", ab.this.cWM.getTalkerUserName());
        ((Intent)localObject2).putExtra("fromChatting", true);
        localObject1 = ab.this.cWM.JOR;
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/ui/chatting/component/HeaderComponent$OptionListener", "onRealClick", "(Landroid/view/MenuItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((MMFragment)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/chatting/component/HeaderComponent$OptionListener", "onRealClick", "(Landroid/view/MenuItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(35387);
        return;
        label874:
        localObject1 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.ab
 * JD-Core Version:    0.7.0.1
 */