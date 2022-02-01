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
import com.tencent.mm.aj.p;
import com.tencent.mm.g.a.yh;
import com.tencent.mm.g.b.a.do;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.b;
import com.tencent.mm.model.au.b.a;
import com.tencent.mm.model.b.b.a;
import com.tencent.mm.model.b.b.b;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.r;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.plugin.newtips.PluginNewTips.a;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.protocal.protobuf.dnz;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.AppBrandNotifySettingsUI;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.ServiceNotifySettingsUI;
import com.tencent.mm.ui.SingleChatInfoUI;
import com.tencent.mm.ui.a.1;
import com.tencent.mm.ui.a.2;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.aa;
import com.tencent.mm.ui.chatting.d.b.ac;
import com.tencent.mm.ui.chatting.d.b.af;
import com.tencent.mm.ui.chatting.d.b.f;
import com.tencent.mm.ui.chatting.d.b.q;
import com.tencent.mm.ui.chatting.d.b.s;
import com.tencent.mm.ui.chatting.d.b.y;
import com.tencent.mm.ui.s.a;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.ui.tools.o;
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.ui.z;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.chatting.d.a.a(fJv=y.class)
public class ab
  extends a
  implements y
{
  private final k.a KbL;
  private boolean KbQ;
  protected LinearLayout KfA;
  private List<String> KfB;
  private String KfC;
  public v KfD;
  private com.tencent.mm.ui.a KfE;
  private View KfF;
  private a KfG;
  final com.tencent.mm.ui.x KfH;
  private b.a KfI;
  private Runnable KfJ;
  private final com.tencent.mm.aj.e.a KfK;
  final int KfL;
  final int KfM;
  final MenuItem.OnMenuItemClickListener KfN;
  private View KfO;
  private View KfP;
  protected LinearLayout Kfy;
  protected LinearLayout Kfz;
  private MenuItem.OnMenuItemClickListener backListener;
  private ActionBarContainer mActionBarContainer;
  private int zfk;
  
  public ab()
  {
    AppMethodBeat.i(35388);
    this.KfB = new LinkedList();
    this.zfk = 0;
    this.mActionBarContainer = null;
    this.KfD = null;
    this.KbQ = false;
    this.KfH = new b();
    this.KfI = new b.a()
    {
      public final void aDu()
      {
        AppMethodBeat.i(179915);
        com.tencent.mm.ui.chatting.e.a.fJE().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(35371);
            bc.aCg().aAg();
            if (com.tencent.mm.model.b.b.a(b.b.hLI))
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
    this.KfJ = null;
    this.KfK = new com.tencent.mm.aj.e.a()
    {
      public final void DG(final String paramAnonymousString)
      {
        AppMethodBeat.i(179917);
        com.tencent.mm.ui.chatting.e.a.fJE().removeCallbacks(ab.e(ab.this));
        com.tencent.mm.ui.chatting.e.a.fJE().postDelayed(ab.a(ab.this, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(179916);
            if ((!bu.isNullOrNil(ab.f(ab.this))) && (!bu.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals(ab.f(ab.this)))) {
              ab.this.yc(false);
            }
            AppMethodBeat.o(179916);
          }
        }), 1000L);
        AppMethodBeat.o(179917);
      }
    };
    this.KbL = new k.a()
    {
      public final void a(String paramAnonymousString, m paramAnonymousm)
      {
        AppMethodBeat.i(179918);
        com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.ChattingUI.HeaderComponent", "roommember watcher notify ".concat(String.valueOf(paramAnonymousString)));
        if ((ab.this.cXJ.fJC()) && (!bu.isNullOrNil(paramAnonymousString)))
        {
          ab.this.fHr();
          ab.this.fIf();
        }
        AppMethodBeat.o(179918);
      }
    };
    this.backListener = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(35381);
        boolean bool = ab.this.cXJ.Kkd.fEZ();
        AppMethodBeat.o(35381);
        return bool;
      }
    };
    this.KfL = 1;
    this.KfM = 2;
    this.KfN = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(179922);
        yh localyh = new yh();
        localyh.dNE.dto = 5;
        localyh.dNE.talker = ab.this.cXJ.Cqh.field_username;
        localyh.dNE.context = ab.this.cXJ.Kkd.getContext();
        if (paramAnonymousMenuItem.getItemId() == 1) {
          localyh.dNE.dNA = 4;
        }
        for (;;)
        {
          com.tencent.mm.sdk.b.a.IvT.l(localyh);
          AppMethodBeat.o(179922);
          return true;
          if (paramAnonymousMenuItem.getItemId() == 2) {
            localyh.dNE.dNA = 2;
          }
        }
      }
    };
    this.KfO = null;
    this.KfP = null;
    AppMethodBeat.o(35388);
  }
  
  private View F(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(35406);
    if (this.KfF == null)
    {
      if (paramViewGroup == null) {}
      for (this.KfF = z.jV(this.cXJ.Kkd.getContext()).inflate(2131492921, null);; this.KfF = z.jV(this.cXJ.Kkd.getContext()).inflate(2131492921, paramViewGroup, false))
      {
        paramViewGroup = this.KfF;
        AppMethodBeat.o(35406);
        return paramViewGroup;
      }
    }
    if (this.KfF.getParent() == null)
    {
      paramViewGroup = this.KfF;
      AppMethodBeat.o(35406);
      return paramViewGroup;
    }
    if ((this.KfF.getParent() instanceof ViewGroup))
    {
      ((ViewGroup)this.KfF.getParent()).removeView(this.KfF);
      paramViewGroup = this.KfF;
      AppMethodBeat.o(35406);
      return paramViewGroup;
    }
    if (paramViewGroup == null) {}
    for (this.KfF = z.jV(this.cXJ.Kkd.getContext()).inflate(2131492921, null);; this.KfF = z.jV(this.cXJ.Kkd.getContext()).inflate(2131492921, paramViewGroup, false))
    {
      paramViewGroup = this.KfF;
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
    s.a locala = this.cXJ.Kkd.findMenuInfo(0);
    if (bu.isNullOrNil(paramString))
    {
      if (locala == null)
      {
        this.cXJ.Kkd.addIconOptionMenu(0, paramInt1, paramInt2, paramOnMenuItemClickListener);
        AppMethodBeat.o(179927);
        return;
      }
      this.cXJ.Kkd.updateOptionMenu(0, paramInt1, paramInt2, paramOnMenuItemClickListener);
      AppMethodBeat.o(179927);
      return;
    }
    if (locala == null) {
      this.cXJ.Kkd.addIconOptionMenu(0, paramInt1, paramInt2, paramOnMenuItemClickListener);
    }
    for (paramOnMenuItemClickListener = this.cXJ.Kkd.findMenuInfo(0); paramOnMenuItemClickListener == null; paramOnMenuItemClickListener = locala)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.ChattingUI.HeaderComponent", "updateMenuInfo menuInfo == null");
      AppMethodBeat.o(179927);
      return;
      this.cXJ.Kkd.updateOptionMenu(0, paramInt1, paramInt2, paramOnMenuItemClickListener);
    }
    this.KfG = new a(paramString, paramOnMenuItemClickListener);
    com.tencent.mm.plugin.newtips.a.dxD().h(this.KfG);
    com.tencent.mm.plugin.newtips.a.g.a(this.KfG);
    if (paramOnMenuItemClickListener.Jwy) {
      com.tencent.mm.plugin.newtips.a.g.a(this.KfG, com.tencent.mm.plugin.newtips.a.k.wIv, true);
    }
    AppMethodBeat.o(179927);
  }
  
  private void a(ActionBar paramActionBar)
  {
    AppMethodBeat.i(35408);
    boolean bool = com.tencent.mm.ui.al.isDarkMode();
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
          com.tencent.mm.ui.al.a(((TextView)localObject).getPaint(), 0.8F);
          if (bool) {
            ((TextView)localObject).setTextColor(this.cXJ.Kkd.getMMResources().getColor(2131099886));
          }
        }
        localObject = (TextView)paramActionBar.getCustomView().findViewById(2131305509);
        if ((localObject != null) && (bool)) {
          ((TextView)localObject).setTextColor(this.cXJ.Kkd.getMMResources().getColor(2131099886));
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
    AppMethodBeat.i(187357);
    s.a locala2 = this.cXJ.Kkd.findMenuInfo(0);
    s.a locala1 = locala2;
    if (locala2 != null) {
      if (locala2.Jol == 0)
      {
        locala1 = locala2;
        if (locala2.Jww == null) {}
      }
      else
      {
        this.cXJ.Kkd.removeOptionMenu(0);
        locala1 = null;
      }
    }
    if (locala1 == null)
    {
      this.cXJ.Kkd.addTextOptionMenu(0, paramString, paramOnMenuItemClickListener, null, paramb);
      AppMethodBeat.o(187357);
      return;
    }
    this.cXJ.Kkd.updateOptionMenuText(0, paramString);
    AppMethodBeat.o(187357);
  }
  
  private String at(an paraman)
  {
    AppMethodBeat.i(35403);
    if (paraman == null)
    {
      paraman = this.cXJ.Kkd.getContext().getString(2131756727);
      AppMethodBeat.o(35403);
      return paraman;
    }
    if (RegionCodeDecoder.aVQ(paraman.getCountryCode()))
    {
      String str = paraman.getCity();
      if (!bu.isNullOrNil(str))
      {
        AppMethodBeat.o(35403);
        return str;
      }
      str = w.zR(paraman.getProvince());
      if (!bu.isNullOrNil(str))
      {
        AppMethodBeat.o(35403);
        return str;
      }
      RegionCodeDecoder.fwA();
      paraman = RegionCodeDecoder.getLocName(paraman.getCountryCode());
      AppMethodBeat.o(35403);
      return paraman;
    }
    paraman = w.zR(paraman.getProvince());
    if (!bu.isNullOrNil(paraman))
    {
      AppMethodBeat.o(35403);
      return paraman;
    }
    paraman = this.cXJ.Kkd.getContext().getString(2131756727);
    AppMethodBeat.o(35403);
    return paraman;
  }
  
  private void fED()
  {
    AppMethodBeat.i(35399);
    if ((com.tencent.mm.model.x.Af(this.cXJ.getTalkerUserName())) || (com.tencent.mm.model.x.Ag(this.cXJ.getTalkerUserName())) || (com.tencent.mm.model.x.Ah(this.cXJ.getTalkerUserName())))
    {
      com.tencent.mm.plugin.newtips.a.dxG();
      boolean bool = com.tencent.mm.plugin.newtips.a.e.Mr(com.tencent.mm.plugin.newtips.a.d.wHT);
      this.cXJ.Kkd.addIconOptionMenu(0, 2131755135, 2131689511, Boolean.valueOf(bool).booleanValue(), this.KfH);
    }
    AppMethodBeat.o(35399);
  }
  
  private void fIc()
  {
    AppMethodBeat.i(35400);
    if (com.tencent.mm.kernel.g.ajP().aiZ())
    {
      p.aEA().b(this.KfK);
      bc.aCg();
      com.tencent.mm.model.c.azP().remove(this.KbL);
    }
    com.tencent.mm.ui.chatting.e.a.fJE().removeCallbacks(this.KfJ);
    r.aAv();
    if (this.KfG != null)
    {
      com.tencent.mm.plugin.newtips.a.dxD();
      com.tencent.mm.plugin.newtips.a.i.i(this.KfG);
    }
    AppMethodBeat.o(35400);
  }
  
  private void fIe()
  {
    AppMethodBeat.i(35409);
    this.KfB.clear();
    this.KfB.add(this.cXJ.Kkd.getStringExtra("Chat_User"));
    AppMethodBeat.o(35409);
  }
  
  private void fIg()
  {
    AppMethodBeat.i(35413);
    if (this.cXJ.Kkd.getContext() == null)
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.ChattingUI.HeaderComponent", "getActivity is null");
      AppMethodBeat.o(35413);
      return;
    }
    fIm();
    ViewGroup localViewGroup = (ViewGroup)this.cXJ.Kkd.getContext().findViewById(2131298063);
    com.tencent.mm.pluginsdk.ui.b.a locala = com.tencent.mm.ui.conversation.a.e.a(this.cXJ.Kkd.getContext(), com.tencent.mm.ui.conversation.a.e.a.KUD, new Object[] { b.b.hLI });
    if ((localViewGroup != null) && (locala != null) && (locala.getView() != null) && (this.KfP == null))
    {
      this.KfP = locala.getView();
      localViewGroup.addView(this.KfP, new ViewGroup.LayoutParams(-1, -2));
    }
    AppMethodBeat.o(35413);
  }
  
  private void fIi()
  {
    AppMethodBeat.i(35415);
    if ((this.cXJ.fJC()) || (this.Kfy == null))
    {
      fIj();
      AppMethodBeat.o(35415);
      return;
    }
    fIj();
    com.tencent.mm.pluginsdk.ui.b.a locala2;
    if (this.Kfy.getTag() == null)
    {
      locala2 = com.tencent.mm.ui.conversation.a.e.a(this.cXJ.Kkd.getContext(), com.tencent.mm.ui.conversation.a.e.a.KUr, new Object[] { this.cXJ.getTalkerUserName(), this.cXJ.fGT() });
      locala1 = locala2;
      if (locala2 != null)
      {
        locala1 = locala2;
        if (locala2.getView() != null) {
          this.Kfy.addView(locala2.getView(), new ViewGroup.LayoutParams(-1, -2));
        }
      }
    }
    for (com.tencent.mm.pluginsdk.ui.b.a locala1 = locala2;; locala1 = (com.tencent.mm.pluginsdk.ui.b.a)this.Kfy.getTag())
    {
      if (locala1 != null)
      {
        this.Kfy.setVisibility(0);
        this.Kfy.setTag(locala1);
      }
      com.tencent.mm.plugin.report.service.g.yxI.f(11003, new Object[] { this.cXJ.getTalkerUserName(), Integer.valueOf(1), Integer.valueOf(0) });
      AppMethodBeat.o(35415);
      return;
    }
  }
  
  private void fIj()
  {
    AppMethodBeat.i(35416);
    this.Kfy.setVisibility(8);
    if (this.KfA != null) {
      this.KfA.setVisibility(8);
    }
    AppMethodBeat.o(35416);
  }
  
  private void fIk()
  {
    AppMethodBeat.i(35417);
    if (this.cXJ.Kkd.getContext() == null)
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.ChattingUI.HeaderComponent", "getActivity is null");
      AppMethodBeat.o(35417);
      return;
    }
    fIl();
    ViewGroup localViewGroup = (ViewGroup)this.cXJ.Kkd.getContext().findViewById(2131298070);
    com.tencent.mm.pluginsdk.ui.b.a locala = com.tencent.mm.ui.conversation.a.e.a(this.cXJ.Kkd.getContext(), com.tencent.mm.ui.conversation.a.e.a.KUs, new Object[] { this.cXJ.getTalkerUserName(), this.cXJ.fGT(), Boolean.valueOf(this.cXJ.fJC()) });
    if ((localViewGroup != null) && (locala != null) && (locala.getView() != null) && (this.KfO == null))
    {
      this.KfO = locala.getView();
      localViewGroup.addView(this.KfO, new ViewGroup.LayoutParams(-1, -2));
    }
    AppMethodBeat.o(35417);
  }
  
  private void fIl()
  {
    AppMethodBeat.i(35418);
    ViewGroup localViewGroup = (ViewGroup)this.cXJ.Kkd.getContext().findViewById(2131298070);
    if ((localViewGroup != null) && (this.KfO != null))
    {
      localViewGroup.removeView(this.KfO);
      this.KfO = null;
    }
    AppMethodBeat.o(35418);
  }
  
  private void fIm()
  {
    AppMethodBeat.i(35419);
    ViewGroup localViewGroup = (ViewGroup)this.cXJ.Kkd.getContext().findViewById(2131298063);
    if ((localViewGroup != null) && (this.KfP != null))
    {
      localViewGroup.removeView(this.KfP);
      this.KfP = null;
    }
    AppMethodBeat.o(35419);
  }
  
  private boolean isSupportCustomActionBar()
  {
    AppMethodBeat.i(35404);
    boolean bool = this.cXJ.Kkd.isSupportNavigationSwipeBack();
    AppMethodBeat.o(35404);
    return bool;
  }
  
  public final void a(com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(35390);
    super.a(parama);
    if (isSupportCustomActionBar())
    {
      this.KfD = new v();
      parama = this.KfD;
      BaseChattingUIFragment localBaseChattingUIFragment = this.cXJ.Kkd;
      parama.JwY = localBaseChattingUIFragment;
      parama.JwZ = new com.tencent.mm.ui.b.b(localBaseChattingUIFragment.thisActivity(), parama);
      this.cXJ.Kkd.setActivityController(this.KfD);
    }
    AppMethodBeat.o(35390);
  }
  
  public final void a(boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(187359);
    com.tencent.mm.ui.a locala = this.KfE;
    int i;
    if (!paramBoolean)
    {
      locala.JmM.setVisibility(0);
      i = locala.iYj.getCurrentTextColor();
      locala.JmM.setIconColor(i);
      locala.JmL.setOnClickListener(paramOnClickListener);
      o.gZ(locala.JmL);
      locala.JmP.setVisibility(8);
      locala.JmO.setOnClickListener(null);
      o.ha(locala.JmO);
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.ActionBarCustomArea", "fixWhenTitleTooLong, forSubTitle: ".concat(String.valueOf(paramBoolean)));
      if (paramBoolean) {
        break;
      }
      locala.iYj.post(new a.1(locala));
      AppMethodBeat.o(187359);
      return;
      locala.JmP.setVisibility(0);
      i = locala.JmN.getCurrentTextColor();
      locala.JmP.setIconColor(i);
      locala.JmO.setOnClickListener(paramOnClickListener);
      o.gZ(locala.JmO);
      locala.JmM.setVisibility(8);
      locala.JmL.setOnClickListener(null);
      o.ha(locala.JmL);
    }
    locala.iYj.post(new a.2(locala));
    AppMethodBeat.o(187359);
  }
  
  public final void adQ(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(35427);
    Object localObject = this.KfE;
    if (paramInt == 0)
    {
      paramInt = 1;
      localObject = ((com.tencent.mm.ui.a)localObject).JmT;
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
  
  public final void fAs()
  {
    AppMethodBeat.i(35391);
    fId();
    AppMethodBeat.o(35391);
  }
  
  public final void fAt()
  {
    AppMethodBeat.i(35392);
    this.zfk = this.cXJ.Kkd.getIntExtra("add_scene", 0);
    p.aEA().a(this.KfK);
    bc.aCg();
    com.tencent.mm.model.c.azP().add(this.KbL);
    setBackBtn(this.backListener);
    fED();
    fHr();
    fIf();
    fIj();
    this.KbQ = true;
    r.a(this.cXJ.getTalkerUserName(), new PluginNewTips.a()
    {
      public final void dxH()
      {
        AppMethodBeat.i(179909);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingUI.HeaderComponent", "onCallback");
        ab.this.fIf();
        AppMethodBeat.o(179909);
      }
    });
    AppMethodBeat.o(35392);
  }
  
  public final void fAu()
  {
    AppMethodBeat.i(35393);
    yc(true);
    AppMethodBeat.o(35393);
  }
  
  public final void fAv()
  {
    AppMethodBeat.i(35394);
    bc.aCg().aAe().a(new com.tencent.mm.model.b.e.a()
    {
      public final void aDv()
      {
        AppMethodBeat.i(35378);
        com.tencent.mm.ui.chatting.e.a.fJE().post(new Runnable()
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
      
      public final void aDw()
      {
        AppMethodBeat.i(35379);
        ab.h(ab.this);
        AppMethodBeat.o(35379);
      }
    });
    bc.aCg().aAf().a(new com.tencent.mm.model.b.e.a()
    {
      public final void aDv()
      {
        AppMethodBeat.i(179920);
        com.tencent.mm.ui.chatting.e.a.fJE().post(new Runnable()
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
      
      public final void aDw()
      {
        AppMethodBeat.i(179921);
        ab.j(ab.this);
        AppMethodBeat.o(179921);
      }
    });
    com.tencent.mm.model.b.b localb = bc.aCg().aAg();
    b.a locala = this.KfI;
    try
    {
      localb.mListeners.add(locala);
      if (!this.KbQ) {
        fED();
      }
      this.KbQ = false;
      AppMethodBeat.o(35394);
      return;
    }
    finally
    {
      AppMethodBeat.o(35394);
    }
  }
  
  public final void fAw()
  {
    AppMethodBeat.i(35395);
    if (com.tencent.mm.kernel.g.ajP().aiZ())
    {
      bc.aCg().aAe().a(null);
      bc.aCg().aAf().a(null);
      com.tencent.mm.model.b.b localb = bc.aCg().aAg();
      b.a locala = this.KfI;
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
  
  public final void fAx()
  {
    AppMethodBeat.i(35396);
    fIc();
    AppMethodBeat.o(35396);
  }
  
  public final v fEY()
  {
    return this.KfD;
  }
  
  public final void fGE()
  {
    AppMethodBeat.i(35397);
    super.fGE();
    fIc();
    AppMethodBeat.o(35397);
  }
  
  public final void fHr()
  {
    AppMethodBeat.i(35401);
    this.cXJ.Kkd.setMMSubTitle(null);
    if (((af)this.cXJ.bh(af.class)).fID())
    {
      setMMTitle("");
      AppMethodBeat.o(35401);
      return;
    }
    if (com.tencent.mm.model.x.Af(this.cXJ.getTalkerUserName()))
    {
      setMMTitle(this.cXJ.Cqh.adF());
      AppMethodBeat.o(35401);
      return;
    }
    if (((com.tencent.mm.ui.chatting.d.b.aj)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.aj.class)).fIQ())
    {
      setMMTitle(2131762904);
      AppMethodBeat.o(35401);
      return;
    }
    if (an.aUn(this.cXJ.getTalkerUserName()))
    {
      ((s)this.cXJ.bh(s.class)).fHF().setWordCountLimit(140);
      setMMTitle(this.cXJ.Cqh.adG());
      AppMethodBeat.o(35401);
      return;
    }
    if (com.tencent.mm.model.x.AU(this.cXJ.getTalkerUserName()))
    {
      setMMTitle(this.cXJ.Cqh.adF());
      AppMethodBeat.o(35401);
      return;
    }
    if (an.Ac(this.cXJ.getTalkerUserName()))
    {
      setMMTitle(this.cXJ.Kkd.getContext().getString(2131756698, new Object[] { at(this.cXJ.Cqh) }).trim());
      AppMethodBeat.o(35401);
      return;
    }
    if (an.zd(this.cXJ.getTalkerUserName()))
    {
      if (this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.a.class) != null)
      {
        ((com.tencent.mm.ui.chatting.d.b.a)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.a.class)).fHr();
        AppMethodBeat.o(35401);
      }
    }
    else
    {
      if (this.cXJ.fJB())
      {
        boolean bool = ((f)this.cXJ.bh(f.class)).fHe();
        String str = this.cXJ.Cqh.field_conRemark;
        if (bu.isNullOrNil(str))
        {
          str = this.cXJ.Cqh.field_nickname;
          if (!bu.isNullOrNil(str)) {
            break label604;
          }
          if (r.zC(this.cXJ.getTalkerUserName()) != 0) {
            break label545;
          }
          str = this.cXJ.Kkd.getContext().getString(2131757293);
        }
        for (;;)
        {
          Object localObject;
          if (!com.tencent.mm.model.x.zV(this.cXJ.getTalkerUserName()))
          {
            localObject = str;
            if (!bool) {}
          }
          else
          {
            str = str + " ";
            localObject = com.tencent.mm.pluginsdk.ui.span.k.d(this.cXJ.Kkd.getContext(), com.tencent.mm.pluginsdk.ui.span.k.b(this.cXJ.Kkd.getContext(), str, com.tencent.mm.cb.a.ax(this.cXJ.Kkd.getContext(), 2131165192)));
          }
          setMMTitle((CharSequence)localObject);
          AppMethodBeat.o(35401);
          return;
          setMMSubTitle(com.tencent.mm.pluginsdk.ui.span.k.c(this.cXJ.Kkd.getContext(), this.cXJ.fGT()).toString());
          break;
          label545:
          str = this.cXJ.Kkd.getContext().getString(2131759496, new Object[] { this.cXJ.Kkd.getContext().getString(2131757293), Integer.valueOf(r.zC(this.cXJ.getTalkerUserName())) });
          continue;
          label604:
          str = this.cXJ.Kkd.getContext().getString(2131759496, new Object[] { this.cXJ.Cqh.adG(), Integer.valueOf(r.zC(this.cXJ.getTalkerUserName())) });
        }
      }
      if (((com.tencent.mm.ui.chatting.d.b.d)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fGL())
      {
        AppMethodBeat.o(35401);
        return;
      }
      if (((com.tencent.mm.ui.chatting.d.b.i)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.i.class)).fHq())
      {
        ((com.tencent.mm.ui.chatting.d.b.i)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.i.class)).fHr();
        AppMethodBeat.o(35401);
        return;
      }
      this.KfE.xe(an.aUp(this.cXJ.getTalkerUserName()));
      this.cXJ.Kkd.setMMTitle(this.cXJ.Cqh.adG());
      this.KfE.xe(an.aUp(this.cXJ.getTalkerUserName()));
      if (an.aUq(this.cXJ.getTalkerUserName())) {
        this.cXJ.Kkd.setMMSubTitle(((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.a.class)).bC(this.cXJ.Cqh.field_openImAppid, this.cXJ.Cqh.field_descWordingId));
      }
    }
    AppMethodBeat.o(35401);
  }
  
  public final void fIb()
  {
    AppMethodBeat.i(35398);
    if (this.cXJ.getHeaderViewsCount() > 0) {
      this.Kfy = ((LinearLayout)this.cXJ.getListView().findViewById(2131301446));
    }
    for (;;)
    {
      if ((((af)this.cXJ.bh(af.class)).fID()) && (this.cXJ.getListView().getFooterViewsCount() == 0))
      {
        this.Kfz = ((LinearLayout)this.cXJ.Kkd.getContext().getLayoutInflater().inflate(2131496441, null));
        this.cXJ.getListView().addFooterView(this.Kfz);
        if (((af)this.cXJ.bh(af.class)).fIE())
        {
          int i = com.tencent.mm.kernel.g.ajR().ajA().getInt(am.a.JeB, 0);
          if (i != 0)
          {
            localObject1 = this.cXJ.getListView().findViewById(2131308346);
            localObject2 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
            ((LinearLayout.LayoutParams)localObject2).height = i;
            ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          }
        }
      }
      fIj();
      AppMethodBeat.o(35398);
      return;
      this.Kfy = ((LinearLayout)this.cXJ.Kkd.getContext().getLayoutInflater().inflate(2131493515, null));
      Object localObject1 = this.cXJ;
      Object localObject2 = this.Kfy;
      ((com.tencent.mm.ui.chatting.e.a)localObject1).Kke.addHeaderView((View)localObject2);
    }
  }
  
  public final void fId()
  {
    AppMethodBeat.i(35407);
    if ((this.cXJ.Kkd.isCurrentActivity) || (!isSupportCustomActionBar()))
    {
      localObject1 = ((AppCompatActivity)this.cXJ.Kkd.getContext()).getSupportActionBar();
      localObject2 = F(null);
      ((ActionBar)localObject1).setCustomView((View)localObject2);
      this.KfE = new com.tencent.mm.ui.a((View)localObject2);
      a((ActionBar)localObject1);
      this.KfE.xe(false);
      ((ActionBar)localObject1).setDisplayOptions((((ActionBar)localObject1).getDisplayOptions() | 0x10) & 0xFFFFFFFB & 0xFFFFFFFD & 0xFFFFFFF7);
      fIe();
      setBackBtn(this.backListener);
      AppMethodBeat.o(35407);
      return;
    }
    Object localObject1 = (ViewGroup)this.mActionBarContainer.findViewById(2131296343);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingUI.HeaderComponent", "mActionBarContainer %s", new Object[] { this.mActionBarContainer });
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingUI.HeaderComponent", "ctxView %s", new Object[] { this.mActionBarContainer.findViewById(2131296357) });
    ((ViewGroup)localObject1).setVisibility(0);
    Object localObject2 = this.KfD.getSupportActionBar();
    View localView = F((ViewGroup)localObject1);
    ((ActionBar)localObject2).setCustomView(localView);
    this.KfE = new com.tencent.mm.ui.a(localView);
    int j = ((ActionBar)localObject2).getHeight();
    int i = j;
    if (j == 0)
    {
      localObject1 = this.cXJ.Kkd.getMMResources().getDisplayMetrics();
      if (((DisplayMetrics)localObject1).widthPixels <= ((DisplayMetrics)localObject1).heightPixels) {
        break label322;
      }
    }
    label322:
    for (i = this.cXJ.Kkd.getMMResources().getDimensionPixelSize(2131165251);; i = this.cXJ.Kkd.getMMResources().getDimensionPixelSize(2131165252))
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
  
  public final void fIf()
  {
    AppMethodBeat.i(35410);
    Object localObject = (com.tencent.mm.ui.chatting.d.b.aj)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.aj.class);
    if ((((com.tencent.mm.ui.chatting.d.b.aj)localObject).fIQ()) || (((com.tencent.mm.ui.chatting.d.b.aj)localObject).fIP()))
    {
      this.cXJ.showOptionMenu(false);
      AppMethodBeat.o(35410);
      return;
    }
    if (((q)this.cXJ.bh(q.class)).fHE())
    {
      AppMethodBeat.o(35410);
      return;
    }
    if (com.tencent.mm.model.x.Ai(this.cXJ.getTalkerUserName()))
    {
      this.cXJ.showOptionMenu(false);
      AppMethodBeat.o(35410);
      return;
    }
    if (((af)this.cXJ.bh(af.class)).fID()) {
      a(this.cXJ.Kkd.getContext().getString(2131755779), this.KfH, s.b.JwA);
    }
    while (an.Ac(this.cXJ.getTalkerUserName()))
    {
      this.cXJ.yh(true);
      AppMethodBeat.o(35410);
      return;
      if ((com.tencent.mm.model.x.Ag(this.cXJ.getTalkerUserName())) || (com.tencent.mm.model.x.Ah(this.cXJ.getTalkerUserName())))
      {
        a(2131755135, 2131689511, this.KfH);
      }
      else if (com.tencent.mm.model.x.Af(this.cXJ.getTalkerUserName()))
      {
        com.tencent.mm.plugin.newtips.a.dxG();
        boolean bool = com.tencent.mm.plugin.newtips.a.e.Mr(com.tencent.mm.plugin.newtips.a.d.wHT);
        this.cXJ.Kkd.addIconOptionMenu(0, 2131755135, 2131689511, Boolean.valueOf(bool).booleanValue(), this.KfH);
      }
      else if (com.tencent.mm.model.x.Ak(this.cXJ.getTalkerUserName()))
      {
        a(2131755135, 2131689511, this.KfH);
      }
      else if (com.tencent.mm.model.x.Ar(this.cXJ.getTalkerUserName()))
      {
        a(2131755135, 2131689511, this.KfH);
        com.tencent.mm.plugin.report.service.g.yxI.kvStat(10071, "1");
      }
      else if (com.tencent.mm.model.x.As(this.cXJ.getTalkerUserName()))
      {
        a(2131755135, 2131689511, this.KfH);
      }
      else if (com.tencent.mm.model.x.AS(this.cXJ.getTalkerUserName()))
      {
        a(2131755135, 2131689511, this.KfH);
      }
      else if (com.tencent.mm.model.x.AX(this.cXJ.getTalkerUserName()))
      {
        a(2131755135, 2131689511, this.KfH);
      }
      else if (com.tencent.mm.model.x.AZ(this.cXJ.getTalkerUserName()))
      {
        if (com.tencent.mm.model.x.AD(this.cXJ.getTalkerUserName()))
        {
          this.cXJ.showOptionMenu(false);
          AppMethodBeat.o(35410);
          return;
        }
        a(2131755135, 2131689511, this.KfH);
      }
      else if ((an.aUn(this.cXJ.getTalkerUserName())) || (an.aUp(this.cXJ.getTalkerUserName())) || (an.Ac(this.cXJ.getTalkerUserName())))
      {
        a(2131757275, 2131689493, this.KfH);
      }
      else if (an.zd(this.cXJ.getTalkerUserName()))
      {
        if (this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.a.class) != null) {
          ((com.tencent.mm.ui.chatting.d.b.a)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.a.class)).fJw();
        }
      }
      else if ((((ac)this.cXJ.bh(ac.class)).fIC()) && (l.aXE(this.cXJ.getTalkerUserName())))
      {
        a(2131757275, 2131690972, this.KfH);
      }
      else if ((this.cXJ.Cqh != null) && (this.cXJ.Cqh.fug()) && ((com.tencent.mm.al.g.En(this.cXJ.getTalkerUserName())) || (com.tencent.mm.al.g.Ep(this.cXJ.getTalkerUserName()))))
      {
        a(2131755135, 2131690592, this.KfH);
      }
      else
      {
        ((ag)this.cXJ.bh(ag.class)).fIv();
        localObject = (com.tencent.mm.ui.chatting.d.b.d)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.d.class);
        if ((com.tencent.mm.model.x.zT(this.cXJ.getTalkerUserName())) || (((com.tencent.mm.ui.chatting.d.b.d)localObject).fGJ()))
        {
          if (((f)this.cXJ.bh(f.class)).fHc())
          {
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingUI.HeaderComponent", "cpan show chatroom right btn");
            if ((((f)this.cXJ.bh(f.class)).fHd()) && (((f)this.cXJ.bh(f.class)).YQ()) && (r.aAw())) {
              a(2131757275, 2131689493, "chatroom", this.KfH);
            }
            for (;;)
            {
              this.cXJ.showOptionMenu(true);
              break;
              a(2131757275, 2131689493, this.KfH);
            }
          }
          if ((((com.tencent.mm.ui.chatting.d.b.d)localObject).fGJ()) && (!((com.tencent.mm.ui.chatting.d.b.d)localObject).fGK()))
          {
            a(2131757275, 2131689507, this.KfH);
            this.cXJ.showOptionMenu(true);
          }
          else
          {
            this.cXJ.showOptionMenu(false);
            AppMethodBeat.o(35410);
          }
        }
        else
        {
          a(2131757275, 2131689493, this.KfH);
        }
      }
    }
    this.cXJ.showOptionMenu(true);
    AppMethodBeat.o(35410);
  }
  
  @SuppressLint({"ResourceType"})
  public final void fIh()
  {
    AppMethodBeat.i(35414);
    if (this.cXJ.Kkd.hasDestory)
    {
      AppMethodBeat.o(35414);
      return;
    }
    fIj();
    final LinearLayout localLinearLayout;
    if (this.KfA == null)
    {
      l.a(this.cXJ.Kkd, 2131306443);
      this.KfA = ((LinearLayout)this.cXJ.Kkd.getContext().findViewById(2131300123));
      localLinearLayout = (LinearLayout)this.cXJ.Kkd.getContext().getLayoutInflater().inflate(2131493514, null);
      this.KfA.addView(localLinearLayout, new ViewGroup.LayoutParams(-1, -2));
    }
    for (;;)
    {
      this.KfA.setVisibility(0);
      localLinearLayout.setVisibility(0);
      localLinearLayout.findViewById(2131296460);
      String str = this.KfC;
      Object localObject = str;
      if (bu.isNullOrNil(str)) {
        localObject = this.cXJ.Cqh.field_username;
      }
      com.tencent.mm.aj.c.a((String)localObject, false, -1, null);
      localObject = (Button)localLinearLayout.findViewById(2131297974);
      if (((aa)this.cXJ.bh(aa.class)).fIw()) {
        ((aa)this.cXJ.bh(aa.class)).a((Button)localObject, localLinearLayout, this.KfA);
      }
      localLinearLayout.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(35386);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/HeaderComponent$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
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
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/HeaderComponent$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
          if (((aa)ab.this.cXJ.bh(aa.class)).fIw())
          {
            ((aa)ab.this.cXJ.bh(aa.class)).adS(ab.k(ab.this));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/HeaderComponent$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(35370);
            return;
          }
          if ((int)ab.this.cXJ.Cqh.ght == 0)
          {
            bc.aCg();
            if (com.tencent.mm.model.c.azF().ao(ab.this.cXJ.Cqh) != -1) {
              com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.ChattingUI.HeaderComponent", "[insertRetId] successfully! username:%s", new Object[] { ab.this.cXJ.Cqh });
            }
          }
          if (com.tencent.mm.model.x.wb(ab.this.cXJ.Cqh.field_username))
          {
            paramAnonymousView = ab.this.cXJ.Cqh.field_username;
            label202:
            bc.aCg();
            Object localObject2 = com.tencent.mm.model.c.azF().BH(ab.f(ab.this));
            if (localObject2 == null) {
              break label400;
            }
            localObject1 = bu.bI(((aw)localObject2).eRv, "");
            label236:
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingUI.HeaderComponent", "dkverify banner add:%s chat:%s ticket", new Object[] { ab.f(ab.this), paramAnonymousView, localObject1 });
            if (((!TextUtils.isEmpty(paramAnonymousView)) && (TextUtils.isEmpty((CharSequence)localObject1))) || (an.aUq(((aw)localObject2).field_username))) {
              break label406;
            }
            localObject2 = new com.tencent.mm.pluginsdk.ui.applet.a(ab.this.cXJ.Kkd.getContext(), new a.a()
            {
              public final void a(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2, String paramAnonymous2String1, String paramAnonymous2String2)
              {
                AppMethodBeat.i(179910);
                if (paramAnonymous2Boolean1)
                {
                  com.tencent.mm.model.x.B(ab.this.cXJ.Cqh);
                  ab.2.this.KfR.setVisibility(8);
                }
                AppMethodBeat.o(179910);
              }
            });
            LinkedList localLinkedList = new LinkedList();
            localLinkedList.add(Integer.valueOf(3));
            ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).aOa((String)localObject1);
            ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).Fnq = true;
            ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).d(ab.f(ab.this), paramAnonymousView, localLinkedList);
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.g.yxI.f(11004, new Object[] { ab.f(ab.this), Integer.valueOf(3) });
            break;
            paramAnonymousView = "";
            break label202;
            label400:
            localObject1 = "";
            break label236;
            label406:
            au.a.hIG.a(ab.f(ab.this), paramAnonymousView, new au.b.a()
            {
              public final void p(String paramAnonymous2String, boolean paramAnonymous2Boolean)
              {
                AppMethodBeat.i(179912);
                com.tencent.mm.pluginsdk.ui.applet.a locala = new com.tencent.mm.pluginsdk.ui.applet.a(ab.this.cXJ.Kkd.getContext(), new a.a()
                {
                  public final void a(boolean paramAnonymous3Boolean1, boolean paramAnonymous3Boolean2, String paramAnonymous3String1, String paramAnonymous3String2)
                  {
                    AppMethodBeat.i(179911);
                    if (paramAnonymous3Boolean1)
                    {
                      com.tencent.mm.model.x.B(ab.this.cXJ.Cqh);
                      ab.2.this.KfR.setVisibility(8);
                    }
                    AppMethodBeat.o(179911);
                  }
                });
                LinkedList localLinkedList = new LinkedList();
                localLinkedList.add(Integer.valueOf(3));
                bc.aCg();
                paramAnonymous2String = com.tencent.mm.model.c.azF().BH(ab.f(ab.this));
                if (paramAnonymous2String != null) {}
                for (paramAnonymous2String = bu.bI(paramAnonymous2String.eRv, "");; paramAnonymous2String = "")
                {
                  locala.aOa(paramAnonymous2String);
                  locala.Fnq = true;
                  locala.d(ab.f(ab.this), paramAnonymousView, localLinkedList);
                  AppMethodBeat.o(179912);
                  return;
                }
              }
            });
          }
        }
      });
      com.tencent.mm.plugin.report.service.g.yxI.f(11004, new Object[] { this.KfC, Integer.valueOf(1) });
      AppMethodBeat.o(35414);
      return;
      localLinearLayout = (LinearLayout)this.KfA.findViewById(2131297975);
    }
  }
  
  public final int fIn()
  {
    AppMethodBeat.i(35420);
    int j = 0;
    int i = j;
    if (this.Kfy != null)
    {
      i = j;
      if (this.Kfy.isShown()) {
        i = this.Kfy.getHeight() + 0;
      }
    }
    AppMethodBeat.o(35420);
    return i;
  }
  
  public final int fIo()
  {
    AppMethodBeat.i(187358);
    if ((this.cXJ.Kkd.isCurrentActivity) || (!isSupportCustomActionBar())) {
      ((AppCompatActivity)this.cXJ.Kkd.getContext()).getSupportActionBar().setCustomView(F(null));
    }
    for (ActionBar localActionBar = ((AppCompatActivity)this.cXJ.Kkd.getContext()).getSupportActionBar(); (localActionBar != null) && (localActionBar.getCustomView() != null); localActionBar = this.KfD.getSupportActionBar())
    {
      int[] arrayOfInt = new int[2];
      localActionBar.getCustomView().getLocationOnScreen(arrayOfInt);
      int i = localActionBar.getHeight();
      int j = arrayOfInt[1];
      int k = fIn();
      AppMethodBeat.o(187358);
      return i + j + k;
    }
    AppMethodBeat.o(187358);
    return 0;
  }
  
  public final void gk(View paramView)
  {
    AppMethodBeat.i(35405);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.ChattingUI.HeaderComponent", "dealContentView");
    if (isSupportCustomActionBar())
    {
      if (this.mActionBarContainer == null) {
        this.mActionBarContainer = ((ActionBarContainer)((ViewStub)paramView.findViewById(2131298079)).inflate());
      }
      v localv = this.KfD;
      paramView = (ViewGroup)paramView;
      localv.JwZ.WA = paramView;
    }
    AppMethodBeat.o(35405);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    int j = 1;
    AppMethodBeat.i(35389);
    super.onConfigurationChanged(paramConfiguration);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.ChattingUI.HeaderComponent", "getConfiguration().orientation = " + this.cXJ.Kkd.getMMResources().getConfiguration().orientation + ", newConfig.orientation = " + paramConfiguration.orientation);
    this.cXJ.Kkd.getMMResources().getConfiguration().orientation = paramConfiguration.orientation;
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChatFooter", "[dealOrientationChange] %s", new Object[] { ((s)this.cXJ.bh(s.class)).fHF().getContext().getResources().getConfiguration() });
    int i;
    if (this.mActionBarContainer != null)
    {
      i = 1;
      if (this.KfF == null) {
        break label271;
      }
    }
    for (;;)
    {
      if ((i & j) != 0)
      {
        i = com.tencent.mm.compatible.util.a.cd(this.cXJ.Kkd.getContext());
        this.KfF.setMinimumHeight(i);
        ViewGroup.LayoutParams localLayoutParams2 = this.KfF.getLayoutParams();
        ViewGroup.LayoutParams localLayoutParams1 = localLayoutParams2;
        if (localLayoutParams2 == null) {
          localLayoutParams1 = new ViewGroup.LayoutParams(-1, -1);
        }
        localLayoutParams1.height = i;
        this.KfF.setLayoutParams(localLayoutParams1);
        localLayoutParams1 = this.mActionBarContainer.getLayoutParams();
        localLayoutParams1.height = i;
        this.mActionBarContainer.setLayoutParams(localLayoutParams1);
      }
      if (this.KfD != null) {
        this.KfD.JwZ.mActionBar.onConfigurationChanged(paramConfiguration);
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
    this.KfE.setClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179914);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/HeaderComponent$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (!ab.this.cXJ.Kkd.isScreenEnable())
        {
          com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.ChattingUI.HeaderComponent", "Actionbar customView onclick screen not enable");
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
            if (ab.3.this.Jod != null) {
              ab.3.this.Jod.onMenuItemClick(null);
            }
            AppMethodBeat.o(179913);
          }
        });
        ((af)ab.this.cXJ.bh(af.class)).fIJ();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/HeaderComponent$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(179914);
      }
    });
    this.KfE.fyU();
    AppMethodBeat.o(35423);
  }
  
  public final void setMMSubTitle(String paramString)
  {
    AppMethodBeat.i(35422);
    int i = com.tencent.mm.cb.a.ax(this.cXJ.Kkd.getContext(), 2131165466);
    paramString = com.tencent.mm.pluginsdk.ui.span.k.b(this.cXJ.Kkd.getContext(), paramString, i);
    this.KfE.ak(paramString);
    AppMethodBeat.o(35422);
  }
  
  public final void setMMTitle(int paramInt)
  {
    AppMethodBeat.i(35402);
    setMMTitle(this.cXJ.Kkd.getMMResources().getString(paramInt));
    AppMethodBeat.o(35402);
  }
  
  public final void setMMTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(35421);
    if ((com.tencent.mm.model.x.zV(this.cXJ.getTalkerUserName())) || (((f)this.cXJ.bh(f.class)).fHe()))
    {
      this.KfE.setTitle(paramCharSequence);
      this.cXJ.Kkd.updateDescription(this.cXJ.Kkd.getContext().getString(2131757133, new Object[] { paramCharSequence }));
      AppMethodBeat.o(35421);
      return;
    }
    if (an.aUq(this.cXJ.Cqh.field_username))
    {
      paramCharSequence = ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.a.class)).e(ak.getContext(), paramCharSequence.toString(), com.tencent.mm.cb.a.ax(ak.getContext(), 2131165192));
      this.KfE.setTitle(paramCharSequence);
      this.cXJ.Kkd.updateDescription(this.cXJ.Kkd.getContext().getString(2131757133, new Object[] { paramCharSequence }));
      AppMethodBeat.o(35421);
      return;
    }
    paramCharSequence = com.tencent.mm.pluginsdk.ui.span.k.b(this.cXJ.Kkd.getContext(), paramCharSequence, com.tencent.mm.cb.a.ax(this.cXJ.Kkd.getContext(), 2131165192));
    this.KfE.setTitle(paramCharSequence);
    this.cXJ.Kkd.updateDescription(this.cXJ.Kkd.getContext().getString(2131757133, new Object[] { paramCharSequence }));
    AppMethodBeat.o(35421);
  }
  
  public final void setTitleForceNotifyIconVisibility(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(35425);
    Object localObject = this.KfE;
    if (paramInt == 0)
    {
      paramInt = 1;
      localObject = ((com.tencent.mm.ui.a)localObject).JmQ;
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
    if ((com.tencent.mm.model.x.AS(this.cXJ.getTalkerUserName())) || (com.tencent.mm.model.x.AX(this.cXJ.getTalkerUserName())))
    {
      this.KfE.xd(false);
      AppMethodBeat.o(35426);
      return;
    }
    com.tencent.mm.ui.a locala = this.KfE;
    if (paramInt == 0) {
      bool = true;
    }
    locala.xd(bool);
    AppMethodBeat.o(35426);
  }
  
  public final void setTitlePhoneIconVisibility(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(35424);
    Object localObject = this.KfE;
    if (paramInt == 0)
    {
      paramInt = 1;
      localObject = ((com.tencent.mm.ui.a)localObject).JmR;
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
  
  public final void yc(boolean paramBoolean)
  {
    AppMethodBeat.i(35412);
    if (this.cXJ == null)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.ChattingUI.HeaderComponent", "[updateBannerStatus] mChattingContext == null!");
      AppMethodBeat.o(35412);
      return;
    }
    if (!this.cXJ.fJC()) {
      if ((!com.tencent.mm.model.x.Ai(this.cXJ.getTalkerUserName())) && (l.aXE(this.cXJ.getTalkerUserName())) && (!((ac)this.cXJ.bh(ac.class)).fIC()))
      {
        this.KfC = this.cXJ.getTalkerUserName();
        fIh();
      }
    }
    for (;;)
    {
      if (paramBoolean)
      {
        fIk();
        fIg();
      }
      AppMethodBeat.o(35412);
      return;
      if (!((aa)this.cXJ.bh(aa.class)).fIx())
      {
        fIi();
        continue;
        fIj();
      }
    }
  }
  
  final class a
    implements com.tencent.mm.plugin.newtips.a.a
  {
    private int Jok;
    public boolean KfZ;
    private s.a Kga;
    private View fQH;
    private String path;
    
    public a(String paramString, s.a parama)
    {
      AppMethodBeat.i(179923);
      this.fQH = new View(ab.this.cXJ.Kkd.getContext());
      this.KfZ = false;
      this.Jok = 0;
      this.path = paramString;
      this.Kga = parama;
      AppMethodBeat.o(179923);
    }
    
    public final void a(com.tencent.mm.plugin.newtips.a.k paramk, boolean paramBoolean)
    {
      AppMethodBeat.i(179924);
      com.tencent.mm.plugin.newtips.a.g.a(this, paramk, paramBoolean);
      AppMethodBeat.o(179924);
    }
    
    public final boolean a(boolean paramBoolean, dnz paramdnz)
    {
      return false;
    }
    
    public final boolean b(boolean paramBoolean, dnz paramdnz)
    {
      return false;
    }
    
    public final boolean c(boolean paramBoolean, dnz paramdnz)
    {
      return false;
    }
    
    public final boolean d(boolean paramBoolean, dnz paramdnz)
    {
      return false;
    }
    
    public final boolean dnD()
    {
      return false;
    }
    
    public final String getPath()
    {
      return this.path;
    }
    
    public final View getRoot()
    {
      return this.fQH;
    }
    
    public final boolean oq(boolean paramBoolean)
    {
      AppMethodBeat.i(179925);
      paramBoolean = com.tencent.mm.plugin.newtips.a.g.a(paramBoolean, this);
      AppMethodBeat.o(179925);
      return paramBoolean;
    }
    
    public final boolean or(boolean paramBoolean)
    {
      AppMethodBeat.i(179926);
      this.KfZ = paramBoolean;
      ab.this.cXJ.Kkd.updateOptionMenuRedDot(this.Jok, paramBoolean);
      AppMethodBeat.o(179926);
      return true;
    }
    
    public final boolean os(boolean paramBoolean)
    {
      return false;
    }
  }
  
  final class b
    extends com.tencent.mm.ui.x
  {
    b() {}
    
    public final void Zr()
    {
      AppMethodBeat.i(35387);
      if (((af)ab.this.cXJ.bh(af.class)).fIF())
      {
        AppMethodBeat.o(35387);
        return;
      }
      Object localObject1;
      if (com.tencent.mm.model.x.zV(ab.this.cXJ.getTalkerUserName()))
      {
        localObject1 = new do();
        ((do)localObject1).nl(ab.this.cXJ.getTalkerUserName());
        ((do)localObject1).dWm = 4L;
        ((do)localObject1).aLH();
      }
      if ((ab.a(ab.this) != null) && (ab.a(ab.this).KfZ)) {
        com.tencent.mm.plugin.newtips.a.dxD().Mv(25);
      }
      if (com.tencent.mm.model.x.Ah(ab.this.cXJ.getTalkerUserName())) {
        com.tencent.mm.plugin.report.service.g.yxI.f(19540, new Object[] { Integer.valueOf(2) });
      }
      ab.this.cXJ.hideVKB();
      Object localObject2;
      if (com.tencent.mm.model.x.AS(ab.this.cXJ.getTalkerUserName()))
      {
        localObject1 = ab.this.cXJ.Kkd.getContext();
        localObject2 = new Intent(ab.this.cXJ.Kkd.getContext(), ServiceNotifySettingsUI.class);
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/ui/chatting/component/HeaderComponent$OptionListener", "onRealClick", "(Landroid/view/MenuItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((Activity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/chatting/component/HeaderComponent$OptionListener", "onRealClick", "(Landroid/view/MenuItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(35387);
        return;
      }
      if (com.tencent.mm.model.x.AX(ab.this.cXJ.getTalkerUserName()))
      {
        localObject2 = new Intent(ab.this.cXJ.Kkd.getContext(), AppBrandNotifySettingsUI.class);
        localObject1 = (com.tencent.mm.plugin.appbrand.service.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.g.class);
        if (localObject1 == null) {
          break label874;
        }
        localObject1 = ((com.tencent.mm.plugin.appbrand.service.g)localObject1).aYW();
        ((Intent)localObject2).putExtra("report_session_id", (String)localObject1);
      }
      for (;;)
      {
        Activity localActivity = ab.this.cXJ.Kkd.getContext();
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(localActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/ui/chatting/component/HeaderComponent$OptionListener", "onRealClick", "(Landroid/view/MenuItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(localActivity, "com/tencent/mm/ui/chatting/component/HeaderComponent$OptionListener", "onRealClick", "(Landroid/view/MenuItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.plugin.report.service.g.yxI.f(19724, new Object[] { Integer.valueOf(1), Integer.valueOf(6), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null, null, null, Integer.valueOf(0), null, null, Integer.valueOf(0), null, null, localObject1 });
        AppMethodBeat.o(35387);
        return;
        if (com.tencent.mm.model.x.Ak(ab.this.cXJ.getTalkerUserName()))
        {
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("Contact_User", ab.this.cXJ.getTalkerUserName());
          com.tencent.mm.br.d.b(ab.this.cXJ.Kkd.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject1);
          AppMethodBeat.o(35387);
          return;
        }
        if (((aa)ab.this.cXJ.bh(aa.class)).fIw())
        {
          ab.b(ab.this);
          AppMethodBeat.o(35387);
          return;
        }
        if (((com.tencent.mm.ui.chatting.d.b.d)ab.this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fGU())
        {
          AppMethodBeat.o(35387);
          return;
        }
        if (((com.tencent.mm.ui.chatting.d.b.i)ab.this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.i.class)).fHq()) {
          ((PluginGameLife)com.tencent.mm.kernel.g.ad(PluginGameLife.class)).jumpToGameLifeSingleChatInfoUIReport(ab.this.cXJ.getTalkerUserName());
        }
        localObject2 = new Intent();
        ((Intent)localObject2).setClass(ab.this.cXJ.Kkd.getContext(), SingleChatInfoUI.class);
        ((Intent)localObject2).putExtra("Single_Chat_Talker", ab.this.cXJ.getTalkerUserName());
        ((Intent)localObject2).putExtra("fromChatting", true);
        localObject1 = ab.this.cXJ.Kkd;
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/ui/chatting/component/HeaderComponent$OptionListener", "onRealClick", "(Landroid/view/MenuItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((MMFragment)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0));
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