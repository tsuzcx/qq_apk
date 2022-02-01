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
import android.support.v7.app.ActionBar.LayoutParams;
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
import com.tencent.mm.g.a.zj;
import com.tencent.mm.g.b.a.gq;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.b;
import com.tencent.mm.model.ay.b.a;
import com.tencent.mm.model.b.b.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.plugin.newtips.PluginNewTips.a;
import com.tencent.mm.plugin.newtips.a.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.textstatus.a.a.b;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.protocal.protobuf.ehv;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.cf;
import com.tencent.mm.ui.AppBrandNotifySettingsUI;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.SingleChatInfoUI;
import com.tencent.mm.ui.a.1;
import com.tencent.mm.ui.a.2;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.ac;
import com.tencent.mm.ui.chatting.d.b.am;
import com.tencent.mm.ui.chatting.d.b.f;
import com.tencent.mm.ui.chatting.d.b.s;
import com.tencent.mm.ui.chatting.d.b.u;
import com.tencent.mm.ui.conversation.ServiceNotifyConversationUI;
import com.tencent.mm.ui.t;
import com.tencent.mm.ui.t.a;
import com.tencent.mm.ui.t.b;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.chatting.d.a.a(gRF=com.tencent.mm.ui.chatting.d.b.aa.class)
public class ad
  extends a
  implements com.tencent.mm.ui.chatting.d.b.aa
{
  private int Dkc;
  private final MStorage.IOnStorageChange Pnh;
  private boolean Pnm;
  private Runnable PrA;
  private final com.tencent.mm.aj.e.a PrB;
  private View.OnClickListener PrC;
  final int PrD;
  final int PrE;
  final MenuItem.OnMenuItemClickListener PrF;
  private View PrG;
  private View PrH;
  protected LinearLayout Prp;
  protected LinearLayout Prq;
  protected LinearLayout Prr;
  private List<String> Prs;
  private String Prt;
  public w Pru;
  private com.tencent.mm.ui.a Prv;
  private View Prw;
  private a Prx;
  final com.tencent.mm.ui.y Pry;
  private com.tencent.mm.model.b.b.a Prz;
  private MenuItem.OnMenuItemClickListener backListener;
  private ActionBarContainer mActionBarContainer;
  
  public ad()
  {
    AppMethodBeat.i(35388);
    this.Prs = new LinkedList();
    this.Dkc = 0;
    this.mActionBarContainer = null;
    this.Pru = null;
    this.Pnm = false;
    this.Pry = new b();
    this.Prz = new com.tencent.mm.model.b.b.a()
    {
      public final void aXg()
      {
        AppMethodBeat.i(179915);
        com.tencent.mm.ui.chatting.e.a.gRP().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(35371);
            bg.aVF().aTo();
            if (com.tencent.mm.model.b.b.a(b.b.iGK))
            {
              ad.c(ad.this);
              AppMethodBeat.o(35371);
              return;
            }
            ad.d(ad.this);
            AppMethodBeat.o(35371);
          }
        });
        AppMethodBeat.o(179915);
      }
    };
    this.PrA = null;
    this.PrB = new com.tencent.mm.aj.e.a()
    {
      public final void Mr(final String paramAnonymousString)
      {
        AppMethodBeat.i(179917);
        com.tencent.mm.ui.chatting.e.a.gRP().removeCallbacks(ad.e(ad.this));
        com.tencent.mm.ui.chatting.e.a.gRP().postDelayed(ad.a(ad.this, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(179916);
            if ((!Util.isNullOrNil(ad.f(ad.this))) && (!Util.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals(ad.f(ad.this)))) {
              ad.this.BR(false);
            }
            AppMethodBeat.o(179916);
          }
        }), 1000L);
        AppMethodBeat.o(179917);
      }
    };
    this.Pnh = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(179918);
        Log.v("MicroMsg.ChattingUI.HeaderComponent", "roommember watcher notify ".concat(String.valueOf(paramAnonymousString)));
        if ((ad.this.dom.gRM()) && (!Util.isNullOrNil(paramAnonymousString)))
        {
          ad.this.gPx();
          ad.this.gQp();
        }
        AppMethodBeat.o(179918);
      }
    };
    this.PrC = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(233132);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/HeaderComponent$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        ((com.tencent.mm.plugin.textstatus.a.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.textstatus.a.c.class)).showCardDialog(ad.this.dom.Pwc.getContext(), ad.this.dom.GUe.field_username);
        ((com.tencent.mm.plugin.textstatus.a.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.textstatus.a.c.class)).report22210(ad.this.dom.GUe.field_username, 2L);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/HeaderComponent$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(233132);
      }
    };
    this.backListener = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(179922);
        boolean bool = ad.this.dom.Pwc.gNh();
        AppMethodBeat.o(179922);
        return bool;
      }
    };
    this.PrD = 1;
    this.PrE = 2;
    this.PrF = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(233133);
        zj localzj = new zj();
        localzj.efx.dKy = 5;
        localzj.efx.talker = ad.this.dom.GUe.field_username;
        localzj.efx.context = ad.this.dom.Pwc.getContext();
        if (paramAnonymousMenuItem.getItemId() == 1) {
          localzj.efx.eft = 4;
        }
        for (;;)
        {
          EventCenter.instance.publish(localzj);
          AppMethodBeat.o(233133);
          return true;
          if (paramAnonymousMenuItem.getItemId() == 2) {
            localzj.efx.eft = 2;
          }
        }
      }
    };
    this.PrG = null;
    this.PrH = null;
    AppMethodBeat.o(35388);
  }
  
  private View P(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(35406);
    if (this.Prw == null)
    {
      if (paramViewGroup == null) {}
      for (this.Prw = com.tencent.mm.ui.aa.jQ(this.dom.Pwc.getContext()).inflate(2131492940, null);; this.Prw = com.tencent.mm.ui.aa.jQ(this.dom.Pwc.getContext()).inflate(2131492940, paramViewGroup, false))
      {
        paramViewGroup = this.Prw;
        AppMethodBeat.o(35406);
        return paramViewGroup;
      }
    }
    if (this.Prw.getParent() == null)
    {
      paramViewGroup = this.Prw;
      AppMethodBeat.o(35406);
      return paramViewGroup;
    }
    if ((this.Prw.getParent() instanceof ViewGroup))
    {
      ((ViewGroup)this.Prw.getParent()).removeView(this.Prw);
      paramViewGroup = this.Prw;
      AppMethodBeat.o(35406);
      return paramViewGroup;
    }
    if (paramViewGroup == null) {}
    for (this.Prw = com.tencent.mm.ui.aa.jQ(this.dom.Pwc.getContext()).inflate(2131492940, null);; this.Prw = com.tencent.mm.ui.aa.jQ(this.dom.Pwc.getContext()).inflate(2131492940, paramViewGroup, false))
    {
      paramViewGroup = this.Prw;
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
    t.a locala = this.dom.Pwc.findMenuInfo(0);
    if (Util.isNullOrNil(paramString))
    {
      if (locala == null)
      {
        this.dom.Pwc.addIconOptionMenu(0, paramInt1, paramInt2, paramOnMenuItemClickListener);
        AppMethodBeat.o(179927);
        return;
      }
      this.dom.Pwc.updateOptionMenu(0, paramInt1, paramInt2, paramOnMenuItemClickListener);
      AppMethodBeat.o(179927);
      return;
    }
    if (locala == null) {
      this.dom.Pwc.addIconOptionMenu(0, paramInt1, paramInt2, paramOnMenuItemClickListener);
    }
    for (paramOnMenuItemClickListener = this.dom.Pwc.findMenuInfo(0); paramOnMenuItemClickListener == null; paramOnMenuItemClickListener = locala)
    {
      Log.e("MicroMsg.ChattingUI.HeaderComponent", "updateMenuInfo menuInfo == null");
      AppMethodBeat.o(179927);
      return;
      this.dom.Pwc.updateOptionMenu(0, paramInt1, paramInt2, paramOnMenuItemClickListener);
    }
    this.Prx = new a(0, paramString, paramOnMenuItemClickListener);
    com.tencent.mm.plugin.newtips.a.exl().h(this.Prx);
    com.tencent.mm.plugin.newtips.a.g.a(this.Prx);
    if (paramOnMenuItemClickListener.eho) {
      com.tencent.mm.plugin.newtips.a.g.a(this.Prx, k.ADG, true);
    }
    AppMethodBeat.o(179927);
  }
  
  private void a(ActionBar paramActionBar)
  {
    AppMethodBeat.i(35408);
    boolean bool = com.tencent.mm.ui.ao.isDarkMode();
    if (paramActionBar.getCustomView() != null)
    {
      Object localObject = (ImageView)paramActionBar.getCustomView().findViewById(2131297047);
      if ((localObject != null) && (bool))
      {
        if (((ImageView)localObject).getDrawable() != null) {
          ((ImageView)localObject).getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
        }
      }
      else
      {
        localObject = (TextView)paramActionBar.getCustomView().findViewById(2131309202);
        if (localObject != null)
        {
          com.tencent.mm.ui.ao.a(((TextView)localObject).getPaint(), 0.8F);
          if (bool) {
            ((TextView)localObject).setTextColor(this.dom.Pwc.getMMResources().getColor(2131099904));
          }
        }
        localObject = (TextView)paramActionBar.getCustomView().findViewById(2131308718);
        if ((localObject != null) && (bool)) {
          ((TextView)localObject).setTextColor(this.dom.Pwc.getMMResources().getColor(2131099904));
        }
        localObject = (ImageView)paramActionBar.getCustomView().findViewById(2131305120);
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
        paramActionBar = (ImageView)paramActionBar.getCustomView().findViewById(2131305879);
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
  
  private void a(String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, t.b paramb)
  {
    AppMethodBeat.i(233136);
    t.a locala2 = this.dom.Pwc.findMenuInfo(0);
    t.a locala1 = locala2;
    if (locala2 != null) {
      if (locala2.Oyf == 0)
      {
        locala1 = locala2;
        if (locala2.OGR == null) {}
      }
      else
      {
        this.dom.Pwc.removeOptionMenu(0);
        locala1 = null;
      }
    }
    if (locala1 == null)
    {
      this.dom.Pwc.addTextOptionMenu(0, paramString, paramOnMenuItemClickListener, null, paramb);
      AppMethodBeat.o(233136);
      return;
    }
    this.dom.Pwc.updateOptionMenuText(0, paramString);
    AppMethodBeat.o(233136);
  }
  
  private String av(as paramas)
  {
    AppMethodBeat.i(35403);
    if (paramas == null)
    {
      paramas = this.dom.Pwc.getContext().getString(2131756885);
      AppMethodBeat.o(35403);
      return paramas;
    }
    if (RegionCodeDecoder.bkO(paramas.getCountryCode()))
    {
      String str = paramas.getCity();
      if (!Util.isNullOrNil(str))
      {
        AppMethodBeat.o(35403);
        return str;
      }
      str = com.tencent.mm.model.aa.It(paramas.getProvince());
      if (!Util.isNullOrNil(str))
      {
        AppMethodBeat.o(35403);
        return str;
      }
      RegionCodeDecoder.gEm();
      paramas = RegionCodeDecoder.getLocName(paramas.getCountryCode());
      AppMethodBeat.o(35403);
      return paramas;
    }
    paramas = com.tencent.mm.model.aa.It(paramas.getProvince());
    if (!Util.isNullOrNil(paramas))
    {
      AppMethodBeat.o(35403);
      return paramas;
    }
    paramas = this.dom.Pwc.getContext().getString(2131756885);
    AppMethodBeat.o(35403);
    return paramas;
  }
  
  private void doResume()
  {
    AppMethodBeat.i(35399);
    if ((ab.IJ(this.dom.getTalkerUserName())) || (ab.IK(this.dom.getTalkerUserName())) || (ab.IL(this.dom.getTalkerUserName())) || ((1 == ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.soA, 0)) && (ab.IM(this.dom.getTalkerUserName()))))
    {
      com.tencent.mm.plugin.newtips.a.exo();
      boolean bool = com.tencent.mm.plugin.newtips.a.e.Ty(com.tencent.mm.plugin.newtips.a.d.ADd);
      this.dom.Pwc.addIconOptionMenu(0, 2131755153, 2131689513, Boolean.valueOf(bool).booleanValue(), this.Pry);
    }
    AppMethodBeat.o(35399);
  }
  
  private void gQl()
  {
    AppMethodBeat.i(35400);
    if (com.tencent.mm.kernel.g.aAf().azp())
    {
      p.aYn().b(this.PrB);
      bg.aVF();
      com.tencent.mm.model.c.aSX().remove(this.Pnh);
    }
    com.tencent.mm.ui.chatting.e.a.gRP().removeCallbacks(this.PrA);
    v.aTR();
    if (this.Prx != null)
    {
      com.tencent.mm.plugin.newtips.a.exl();
      com.tencent.mm.plugin.newtips.a.i.i(this.Prx);
    }
    AppMethodBeat.o(35400);
  }
  
  private void gQm()
  {
    AppMethodBeat.i(233135);
    View localView = this.dom.Pwc.findViewById(2131309204);
    if (localView != null) {
      localView.setOnClickListener(this.PrC);
    }
    AppMethodBeat.o(233135);
  }
  
  private void gQo()
  {
    AppMethodBeat.i(35409);
    this.Prs.clear();
    this.Prs.add(this.dom.Pwc.getStringExtra("Chat_User"));
    AppMethodBeat.o(35409);
  }
  
  private void gQq()
  {
    AppMethodBeat.i(35413);
    if (this.dom.Pwc.getContext() == null)
    {
      Log.w("MicroMsg.ChattingUI.HeaderComponent", "getActivity is null");
      AppMethodBeat.o(35413);
      return;
    }
    gQx();
    ViewGroup localViewGroup = (ViewGroup)this.dom.Pwc.getContext().findViewById(2131298404);
    com.tencent.mm.pluginsdk.ui.b.a locala = com.tencent.mm.ui.conversation.a.e.a(this.dom.Pwc.getContext(), com.tencent.mm.ui.conversation.a.e.a.QhT, new Object[] { b.b.iGK });
    if ((localViewGroup != null) && (locala != null) && (locala.getView() != null) && (this.PrH == null))
    {
      this.PrH = locala.getView();
      localViewGroup.addView(this.PrH, new ViewGroup.LayoutParams(-1, -2));
    }
    AppMethodBeat.o(35413);
  }
  
  private void gQt()
  {
    AppMethodBeat.i(35415);
    if ((this.dom.gRM()) || (this.Prp == null))
    {
      gQu();
      AppMethodBeat.o(35415);
      return;
    }
    gQu();
    com.tencent.mm.pluginsdk.ui.b.a locala2;
    if (this.Prp.getTag() == null)
    {
      locala2 = com.tencent.mm.ui.conversation.a.e.a(this.dom.Pwc.getContext(), com.tencent.mm.ui.conversation.a.e.a.QhH, new Object[] { this.dom.getTalkerUserName(), this.dom.gOZ() });
      locala1 = locala2;
      if (locala2 != null)
      {
        locala1 = locala2;
        if (locala2.getView() != null) {
          this.Prp.addView(locala2.getView(), new ViewGroup.LayoutParams(-1, -2));
        }
      }
    }
    for (com.tencent.mm.pluginsdk.ui.b.a locala1 = locala2;; locala1 = (com.tencent.mm.pluginsdk.ui.b.a)this.Prp.getTag())
    {
      if (locala1 != null)
      {
        this.Prp.setVisibility(0);
        this.Prp.setTag(locala1);
      }
      h.CyF.a(11003, new Object[] { this.dom.getTalkerUserName(), Integer.valueOf(1), Integer.valueOf(0) });
      AppMethodBeat.o(35415);
      return;
    }
  }
  
  private void gQu()
  {
    AppMethodBeat.i(35416);
    this.Prp.setVisibility(8);
    if (this.Prr != null) {
      this.Prr.setVisibility(8);
    }
    AppMethodBeat.o(35416);
  }
  
  private void gQv()
  {
    AppMethodBeat.i(35417);
    if (this.dom.Pwc.getContext() == null)
    {
      Log.w("MicroMsg.ChattingUI.HeaderComponent", "getActivity is null");
      AppMethodBeat.o(35417);
      return;
    }
    gQw();
    ViewGroup localViewGroup = (ViewGroup)this.dom.Pwc.getContext().findViewById(2131298413);
    com.tencent.mm.pluginsdk.ui.b.a locala = com.tencent.mm.ui.conversation.a.e.a(this.dom.Pwc.getContext(), com.tencent.mm.ui.conversation.a.e.a.QhI, new Object[] { this.dom.getTalkerUserName(), this.dom.gOZ(), Boolean.valueOf(this.dom.gRM()) });
    if ((localViewGroup != null) && (locala != null) && (locala.getView() != null) && (this.PrG == null))
    {
      this.PrG = locala.getView();
      localViewGroup.addView(this.PrG, new ViewGroup.LayoutParams(-1, -2));
    }
    AppMethodBeat.o(35417);
  }
  
  private void gQw()
  {
    AppMethodBeat.i(35418);
    ViewGroup localViewGroup = (ViewGroup)this.dom.Pwc.getContext().findViewById(2131298413);
    if ((localViewGroup != null) && (this.PrG != null))
    {
      localViewGroup.removeView(this.PrG);
      this.PrG = null;
    }
    AppMethodBeat.o(35418);
  }
  
  private void gQx()
  {
    AppMethodBeat.i(35419);
    ViewGroup localViewGroup = (ViewGroup)this.dom.Pwc.getContext().findViewById(2131298404);
    if ((localViewGroup != null) && (this.PrH != null))
    {
      localViewGroup.removeView(this.PrH);
      this.PrH = null;
    }
    AppMethodBeat.o(35419);
  }
  
  private boolean isSupportCustomActionBar()
  {
    AppMethodBeat.i(35404);
    boolean bool = this.dom.Pwc.isSupportNavigationSwipeBack();
    AppMethodBeat.o(35404);
    return bool;
  }
  
  public final void BR(boolean paramBoolean)
  {
    AppMethodBeat.i(35412);
    if (this.dom == null)
    {
      Log.e("MicroMsg.ChattingUI.HeaderComponent", "[updateBannerStatus] mChattingContext == null!");
      AppMethodBeat.o(35412);
      return;
    }
    if (!this.dom.gRM()) {
      if ((!ab.IN(this.dom.getTalkerUserName())) && (l.bmI(this.dom.getTalkerUserName())) && (!((com.tencent.mm.ui.chatting.d.b.ae)this.dom.bh(com.tencent.mm.ui.chatting.d.b.ae.class)).gQM()))
      {
        this.Prt = this.dom.getTalkerUserName();
        gQr();
      }
    }
    for (;;)
    {
      if (paramBoolean)
      {
        gQv();
        gQq();
      }
      AppMethodBeat.o(35412);
      return;
      if ((!((ac)this.dom.bh(ac.class)).gPG()) && (!((com.tencent.mm.ui.chatting.d.b.o)this.dom.bh(com.tencent.mm.ui.chatting.d.b.o.class)).gPG()))
      {
        gQt();
        continue;
        gQu();
      }
    }
  }
  
  public final void a(com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(35390);
    super.a(parama);
    if (isSupportCustomActionBar())
    {
      this.Pru = new w();
      parama = this.Pru;
      BaseChattingUIFragment localBaseChattingUIFragment = this.dom.Pwc;
      parama.OHs = localBaseChattingUIFragment;
      parama.OHt = new com.tencent.mm.ui.b.b(localBaseChattingUIFragment.thisActivity(), parama);
      this.dom.Pwc.setActivityController(this.Pru);
    }
    AppMethodBeat.o(35390);
  }
  
  public final void a(boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(233139);
    com.tencent.mm.ui.a locala = this.Prv;
    int i;
    if (!paramBoolean)
    {
      locala.OwF.setVisibility(0);
      i = locala.jVO.getCurrentTextColor();
      locala.OwF.setIconColor(i);
      locala.OwE.setOnClickListener(paramOnClickListener);
      com.tencent.mm.ui.tools.o.hq(locala.OwE);
      locala.OwI.setVisibility(8);
      locala.OwH.setOnClickListener(null);
      com.tencent.mm.ui.tools.o.hr(locala.OwH);
    }
    for (;;)
    {
      Log.d("MicroMsg.ActionBarCustomArea", "fixWhenTitleTooLong, forSubTitle: ".concat(String.valueOf(paramBoolean)));
      if (paramBoolean) {
        break;
      }
      locala.jVO.post(new a.1(locala));
      AppMethodBeat.o(233139);
      return;
      locala.OwI.setVisibility(0);
      i = locala.OwG.getCurrentTextColor();
      locala.OwI.setIconColor(i);
      locala.OwH.setOnClickListener(paramOnClickListener);
      com.tencent.mm.ui.tools.o.hq(locala.OwH);
      locala.OwF.setVisibility(8);
      locala.OwE.setOnClickListener(null);
      com.tencent.mm.ui.tools.o.hr(locala.OwE);
    }
    locala.jVO.post(new a.2(locala));
    AppMethodBeat.o(233139);
  }
  
  public final void amB(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(35427);
    Object localObject = this.Prv;
    if (paramInt == 0)
    {
      paramInt = 1;
      localObject = ((com.tencent.mm.ui.a)localObject).OwM;
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
  
  public final void cFx()
  {
    AppMethodBeat.i(35394);
    bg.aVF().aTm().a(new com.tencent.mm.model.b.e.a()
    {
      public final void aXh()
      {
        AppMethodBeat.i(35378);
        com.tencent.mm.ui.chatting.e.a.gRP().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(35377);
            ad.g(ad.this);
            AppMethodBeat.o(35377);
          }
        });
        AppMethodBeat.o(35378);
      }
      
      public final void aXi()
      {
        AppMethodBeat.i(35379);
        ad.h(ad.this);
        AppMethodBeat.o(35379);
      }
    });
    bg.aVF().aTn().a(new com.tencent.mm.model.b.e.a()
    {
      public final void aXh()
      {
        AppMethodBeat.i(179920);
        com.tencent.mm.ui.chatting.e.a.gRP().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(179919);
            ad.i(ad.this);
            AppMethodBeat.o(179919);
          }
        });
        AppMethodBeat.o(179920);
      }
      
      public final void aXi()
      {
        AppMethodBeat.i(179921);
        ad.j(ad.this);
        AppMethodBeat.o(179921);
      }
    });
    com.tencent.mm.model.b.b localb = bg.aVF().aTo();
    com.tencent.mm.model.b.b.a locala = this.Prz;
    try
    {
      localb.mListeners.add(locala);
      if (!this.Pnm) {
        doResume();
      }
      this.Pnm = false;
      AppMethodBeat.o(35394);
      return;
    }
    finally
    {
      AppMethodBeat.o(35394);
    }
  }
  
  public final void cFy()
  {
    AppMethodBeat.i(35395);
    if (com.tencent.mm.kernel.g.aAf().azp())
    {
      bg.aVF().aTm().a(null);
      bg.aVF().aTn().a(null);
      com.tencent.mm.model.b.b localb = bg.aVF().aTo();
      com.tencent.mm.model.b.b.a locala = this.Prz;
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
  
  public final void gC(View paramView)
  {
    AppMethodBeat.i(35405);
    Log.d("MicroMsg.ChattingUI.HeaderComponent", "dealContentView");
    if (isSupportCustomActionBar())
    {
      if (this.mActionBarContainer == null) {
        this.mActionBarContainer = ((ActionBarContainer)((ViewStub)paramView.findViewById(2131298422)).inflate());
      }
      w localw = this.Pru;
      paramView = (ViewGroup)paramView;
      localw.OHt.WN = paramView;
    }
    AppMethodBeat.o(35405);
  }
  
  public final void gIk()
  {
    AppMethodBeat.i(35391);
    gQn();
    AppMethodBeat.o(35391);
  }
  
  public final void gIl()
  {
    AppMethodBeat.i(35392);
    this.Dkc = this.dom.Pwc.getIntExtra("add_scene", 0);
    p.aYn().a(this.PrB);
    bg.aVF();
    com.tencent.mm.model.c.aSX().add(this.Pnh);
    setBackBtn(this.backListener);
    doResume();
    gPx();
    gQp();
    gQu();
    this.Pnm = true;
    v.a(this.dom.getTalkerUserName(), new PluginNewTips.a()
    {
      public final void exp()
      {
        AppMethodBeat.i(179909);
        Log.i("MicroMsg.ChattingUI.HeaderComponent", "onCallback");
        ad.this.gQp();
        AppMethodBeat.o(179909);
      }
    });
    AppMethodBeat.o(35392);
  }
  
  public final void gIm()
  {
    AppMethodBeat.i(35393);
    BR(true);
    AppMethodBeat.o(35393);
  }
  
  public final void gIn()
  {
    AppMethodBeat.i(35396);
    gQl();
    AppMethodBeat.o(35396);
  }
  
  public final w gNg()
  {
    return this.Pru;
  }
  
  public final void gOK()
  {
    AppMethodBeat.i(35397);
    super.gOK();
    gQl();
    AppMethodBeat.o(35397);
  }
  
  public final void gPx()
  {
    AppMethodBeat.i(35401);
    this.dom.Pwc.setMMSubTitle(null);
    if (((com.tencent.mm.ui.chatting.d.b.ai)this.dom.bh(com.tencent.mm.ui.chatting.d.b.ai.class)).gQN())
    {
      setMMTitle("");
      AppMethodBeat.o(35401);
      return;
    }
    if (ab.IJ(this.dom.getTalkerUserName()))
    {
      setMMTitle(this.dom.GUe.arI());
      AppMethodBeat.o(35401);
      return;
    }
    if (((am)this.dom.bh(am.class)).gRa())
    {
      setMMTitle(2131765040);
      AppMethodBeat.o(35401);
      return;
    }
    if (as.bjm(this.dom.getTalkerUserName()))
    {
      ((u)this.dom.bh(u.class)).gPO().setWordCountLimit(140);
      setMMTitle(this.dom.GUe.arJ());
      AppMethodBeat.o(35401);
      return;
    }
    if (ab.Jz(this.dom.getTalkerUserName()))
    {
      if (((com.tencent.mm.ui.chatting.d.b.o)this.dom.bh(com.tencent.mm.ui.chatting.d.b.o.class)).gPH())
      {
        setMMTitle(this.dom.Pwc.getContext().getString(2131763745));
        AppMethodBeat.o(35401);
        return;
      }
      setMMTitle(this.dom.GUe.arI());
      AppMethodBeat.o(35401);
      return;
    }
    if (as.IG(this.dom.getTalkerUserName()))
    {
      setMMTitle(this.dom.Pwc.getContext().getString(2131756856, new Object[] { av(this.dom.GUe) }).trim());
      AppMethodBeat.o(35401);
      return;
    }
    if (as.HF(this.dom.getTalkerUserName()))
    {
      if (this.dom.bh(com.tencent.mm.ui.chatting.d.b.a.class) != null)
      {
        ((com.tencent.mm.ui.chatting.d.b.a)this.dom.bh(com.tencent.mm.ui.chatting.d.b.a.class)).gPx();
        AppMethodBeat.o(35401);
      }
    }
    else
    {
      if (this.dom.gRL())
      {
        boolean bool = ((f)this.dom.bh(f.class)).gPk();
        String str = this.dom.GUe.field_conRemark;
        if (Util.isNullOrNil(str))
        {
          str = this.dom.GUe.field_nickname;
          if (!Util.isNullOrNil(str)) {
            break label652;
          }
          if (v.Ie(this.dom.getTalkerUserName()) != 0) {
            break label593;
          }
          str = this.dom.Pwc.getContext().getString(2131757507);
        }
        for (;;)
        {
          Object localObject;
          if (!ab.Iy(this.dom.getTalkerUserName()))
          {
            localObject = str;
            if (!bool) {}
          }
          else
          {
            str = str + " ";
            localObject = com.tencent.mm.pluginsdk.ui.span.l.d(this.dom.Pwc.getContext(), com.tencent.mm.pluginsdk.ui.span.l.e(this.dom.Pwc.getContext(), str, com.tencent.mm.cb.a.aG(this.dom.Pwc.getContext(), 2131165195)));
          }
          setMMTitle((CharSequence)localObject);
          AppMethodBeat.o(35401);
          return;
          setMMSubTitle(com.tencent.mm.pluginsdk.ui.span.l.c(this.dom.Pwc.getContext(), this.dom.gOZ()).toString());
          break;
          label593:
          str = this.dom.Pwc.getContext().getString(2131760811, new Object[] { this.dom.Pwc.getContext().getString(2131757507), Integer.valueOf(v.Ie(this.dom.getTalkerUserName())) });
          continue;
          label652:
          str = this.dom.Pwc.getContext().getString(2131760811, new Object[] { this.dom.GUe.arJ(), Integer.valueOf(v.Ie(this.dom.getTalkerUserName())) });
        }
      }
      if (((com.tencent.mm.ui.chatting.d.b.d)this.dom.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOR())
      {
        AppMethodBeat.o(35401);
        return;
      }
      if (((com.tencent.mm.ui.chatting.d.b.i)this.dom.bh(com.tencent.mm.ui.chatting.d.b.i.class)).gPw())
      {
        ((com.tencent.mm.ui.chatting.d.b.i)this.dom.bh(com.tencent.mm.ui.chatting.d.b.i.class)).gPx();
        AppMethodBeat.o(35401);
        return;
      }
      this.Prv.AS(as.bjo(this.dom.getTalkerUserName()));
      this.dom.Pwc.setMMTitle(this.dom.GUe.arJ());
      this.Prv.AS(as.bjo(this.dom.getTalkerUserName()));
      if (as.bjp(this.dom.getTalkerUserName())) {
        this.dom.Pwc.setMMSubTitle(((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.openim.a.a.class)).bN(this.dom.GUe.field_openImAppid, this.dom.GUe.field_descWordingId));
      }
    }
    AppMethodBeat.o(35401);
  }
  
  public final void gQk()
  {
    AppMethodBeat.i(35398);
    if (this.dom.getHeaderViewsCount() > 0) {
      this.Prp = ((LinearLayout)this.dom.getListView().findViewById(2131303231));
    }
    for (;;)
    {
      if ((((com.tencent.mm.ui.chatting.d.b.ai)this.dom.bh(com.tencent.mm.ui.chatting.d.b.ai.class)).gQN()) && (this.dom.getListView().getFooterViewsCount() == 0))
      {
        this.Prq = ((LinearLayout)this.dom.Pwc.getContext().getLayoutInflater().inflate(2131493623, null));
        this.dom.getListView().addFooterView(this.Prq);
        if (((com.tencent.mm.ui.chatting.d.b.ai)this.dom.bh(com.tencent.mm.ui.chatting.d.b.ai.class)).gQO())
        {
          int i = com.tencent.mm.kernel.g.aAh().azQ().getInt(ar.a.Oom, 0);
          if (i != 0)
          {
            localObject1 = this.dom.getListView().findViewById(2131303230);
            localObject2 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
            ((LinearLayout.LayoutParams)localObject2).height = i;
            ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          }
        }
      }
      gQu();
      AppMethodBeat.o(35398);
      return;
      this.Prp = ((LinearLayout)this.dom.Pwc.getContext().getLayoutInflater().inflate(2131493625, null));
      Object localObject1 = this.dom;
      Object localObject2 = this.Prp;
      ((com.tencent.mm.ui.chatting.e.a)localObject1).Pwd.addHeaderView((View)localObject2);
    }
  }
  
  public final void gQn()
  {
    AppMethodBeat.i(35407);
    if ((this.dom.Pwc.isCurrentActivity) || (!isSupportCustomActionBar()))
    {
      localObject1 = ((AppCompatActivity)this.dom.Pwc.getContext()).getSupportActionBar();
      localObject2 = P(null);
      ((ActionBar)localObject1).setCustomView((View)localObject2);
      this.Prv = new com.tencent.mm.ui.a((View)localObject2);
      a((ActionBar)localObject1);
      this.Prv.AS(false);
      ((ActionBar)localObject1).setDisplayOptions((((ActionBar)localObject1).getDisplayOptions() | 0x10) & 0xFFFFFFFB & 0xFFFFFFFD & 0xFFFFFFF7);
      gQo();
      setBackBtn(this.backListener);
      AppMethodBeat.o(35407);
      return;
    }
    Object localObject1 = (ViewGroup)this.mActionBarContainer.findViewById(2131296363);
    Log.i("MicroMsg.ChattingUI.HeaderComponent", "mActionBarContainer %s", new Object[] { this.mActionBarContainer });
    Log.i("MicroMsg.ChattingUI.HeaderComponent", "ctxView %s", new Object[] { this.mActionBarContainer.findViewById(2131296380) });
    ((ViewGroup)localObject1).setVisibility(0);
    Object localObject2 = this.Pru.getSupportActionBar();
    View localView = P((ViewGroup)localObject1);
    ((ActionBar)localObject2).setCustomView(localView);
    this.Prv = new com.tencent.mm.ui.a(localView);
    int j = ((ActionBar)localObject2).getHeight();
    int i = j;
    if (j == 0)
    {
      localObject1 = this.dom.Pwc.getMMResources().getDisplayMetrics();
      if (((DisplayMetrics)localObject1).widthPixels <= ((DisplayMetrics)localObject1).heightPixels) {
        break label327;
      }
    }
    label327:
    for (i = this.dom.Pwc.getMMResources().getDimensionPixelSize(2131165255);; i = this.dom.Pwc.getMMResources().getDimensionPixelSize(2131165256))
    {
      localView.setMinimumHeight(i);
      ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
      localObject1 = localLayoutParams;
      if (localLayoutParams == null) {
        localObject1 = new ViewGroup.LayoutParams(-1, -1);
      }
      ((ViewGroup.LayoutParams)localObject1).height = i;
      ((ViewGroup.LayoutParams)localObject1).width = -1;
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = localObject2;
      break;
    }
  }
  
  public final void gQp()
  {
    AppMethodBeat.i(35410);
    Object localObject = (am)this.dom.bh(am.class);
    if ((((am)localObject).gRa()) || (((am)localObject).gQZ()))
    {
      this.dom.showOptionMenu(false);
      AppMethodBeat.o(35410);
      return;
    }
    if (((s)this.dom.bh(s.class)).gPN())
    {
      AppMethodBeat.o(35410);
      return;
    }
    if (ab.IN(this.dom.getTalkerUserName()))
    {
      this.dom.showOptionMenu(false);
      AppMethodBeat.o(35410);
      return;
    }
    if (((com.tencent.mm.ui.chatting.d.b.ai)this.dom.bh(com.tencent.mm.ui.chatting.d.b.ai.class)).gQN()) {
      a(this.dom.Pwc.getContext().getString(2131755858), this.Pry, t.b.OGU);
    }
    while (as.IG(this.dom.getTalkerUserName()))
    {
      this.dom.BW(true);
      AppMethodBeat.o(35410);
      return;
      if ((ab.IK(this.dom.getTalkerUserName())) || (ab.IL(this.dom.getTalkerUserName())) || ((1 == ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.soA, 0)) && (ab.IM(this.dom.getTalkerUserName()))))
      {
        a(2131755153, 2131689513, this.Pry);
      }
      else if (ab.IJ(this.dom.getTalkerUserName()))
      {
        com.tencent.mm.plugin.newtips.a.exo();
        boolean bool = com.tencent.mm.plugin.newtips.a.e.Ty(com.tencent.mm.plugin.newtips.a.d.ADd);
        this.dom.Pwc.addIconOptionMenu(0, 2131755153, 2131689513, Boolean.valueOf(bool).booleanValue(), this.Pry);
      }
      else if (ab.IP(this.dom.getTalkerUserName()))
      {
        a(2131755153, 2131689513, this.Pry);
      }
      else if (ab.IW(this.dom.getTalkerUserName()))
      {
        a(2131755153, 2131689513, this.Pry);
        h.CyF.kvStat(10071, "1");
      }
      else if (ab.IX(this.dom.getTalkerUserName()))
      {
        a(2131755153, 2131689513, this.Pry);
      }
      else if (ab.Jx(this.dom.getTalkerUserName()))
      {
        if (((com.tencent.mm.ui.chatting.d.b.o)this.dom.bh(com.tencent.mm.ui.chatting.d.b.o.class)).gPH())
        {
          this.dom.showOptionMenu(false);
        }
        else
        {
          bg.aVF();
          com.tencent.mm.model.c.getNotifyMessageRecordStorage();
          if (cf.gEg())
          {
            this.dom.showOptionMenu(false);
            AppMethodBeat.o(35410);
            return;
          }
          a(2131755153, 2131689507, this.Pry);
        }
      }
      else if (ab.JC(this.dom.getTalkerUserName()))
      {
        a(2131755153, 2131689513, this.Pry);
      }
      else if (ab.JE(this.dom.getTalkerUserName()))
      {
        if (ab.Ji(this.dom.getTalkerUserName()))
        {
          this.dom.showOptionMenu(false);
          AppMethodBeat.o(35410);
          return;
        }
        a(2131755153, 2131689513, this.Pry);
      }
      else if ((as.bjm(this.dom.getTalkerUserName())) || (as.bjo(this.dom.getTalkerUserName())) || (as.IG(this.dom.getTalkerUserName())))
      {
        a(2131757489, 2131689495, this.Pry);
      }
      else if (as.HF(this.dom.getTalkerUserName()))
      {
        if (this.dom.bh(com.tencent.mm.ui.chatting.d.b.a.class) != null) {
          ((com.tencent.mm.ui.chatting.d.b.a)this.dom.bh(com.tencent.mm.ui.chatting.d.b.a.class)).gRG();
        }
      }
      else if ((((com.tencent.mm.ui.chatting.d.b.ae)this.dom.bh(com.tencent.mm.ui.chatting.d.b.ae.class)).gQM()) && (l.bmI(this.dom.getTalkerUserName())))
      {
        a(2131757489, 2131691270, this.Pry);
      }
      else if ((this.dom.GUe != null) && (this.dom.GUe.gBM()) && ((com.tencent.mm.al.g.Nb(this.dom.getTalkerUserName())) || (com.tencent.mm.al.g.Nd(this.dom.getTalkerUserName()))))
      {
        a(2131755153, 2131690829, this.Pry);
      }
      else
      {
        ((ai)this.dom.bh(ai.class)).gQG();
        localObject = (com.tencent.mm.ui.chatting.d.b.d)this.dom.bh(com.tencent.mm.ui.chatting.d.b.d.class);
        if ((ab.Iw(this.dom.getTalkerUserName())) || (((com.tencent.mm.ui.chatting.d.b.d)localObject).gOP()))
        {
          if (((f)this.dom.bh(f.class)).gPi())
          {
            Log.i("MicroMsg.ChattingUI.HeaderComponent", "cpan show chatroom right btn");
            if ((((f)this.dom.bh(f.class)).gPj()) && (((f)this.dom.bh(f.class)).amD()) && (v.aTS())) {
              a(2131757489, 2131689495, "chatroom", this.Pry);
            }
            for (;;)
            {
              this.dom.showOptionMenu(true);
              break;
              a(2131757489, 2131689495, this.Pry);
            }
          }
          if ((((com.tencent.mm.ui.chatting.d.b.d)localObject).gOP()) && (!((com.tencent.mm.ui.chatting.d.b.d)localObject).gOQ()))
          {
            a(2131757489, 2131689509, this.Pry);
            this.dom.showOptionMenu(true);
          }
          else
          {
            this.dom.showOptionMenu(false);
            AppMethodBeat.o(35410);
          }
        }
        else
        {
          a(2131757489, 2131689495, this.Pry);
        }
      }
    }
    this.dom.showOptionMenu(true);
    AppMethodBeat.o(35410);
  }
  
  @SuppressLint({"ResourceType"})
  public final void gQr()
  {
    AppMethodBeat.i(35414);
    if (this.dom.Pwc.hasDestory)
    {
      AppMethodBeat.o(35414);
      return;
    }
    gQu();
    final LinearLayout localLinearLayout;
    if (this.Prr == null)
    {
      l.a(this.dom.Pwc, 2131309880);
      this.Prr = ((LinearLayout)this.dom.Pwc.getContext().findViewById(2131301563));
      localLinearLayout = (LinearLayout)this.dom.Pwc.getContext().getLayoutInflater().inflate(2131493624, null);
      this.Prr.addView(localLinearLayout, new ViewGroup.LayoutParams(-1, -2));
    }
    for (;;)
    {
      this.Prr.setVisibility(0);
      localLinearLayout.setVisibility(0);
      localLinearLayout.findViewById(2131296533);
      String str = this.Prt;
      Object localObject = str;
      if (Util.isNullOrNil(str)) {
        localObject = this.dom.GUe.field_username;
      }
      com.tencent.mm.aj.c.a((String)localObject, false, -1, null);
      localObject = (Button)localLinearLayout.findViewById(2131298315);
      if (((ac)this.dom.bh(ac.class)).gQH()) {
        ((ac)this.dom.bh(ac.class)).a((Button)localObject, localLinearLayout, this.Prr);
      }
      localLinearLayout.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(35370);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/HeaderComponent$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          ad.b(ad.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/HeaderComponent$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(35370);
        }
      });
      ((Button)localObject).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(179914);
          Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/HeaderComponent$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
          if (((ac)ad.this.dom.bh(ac.class)).gQH())
          {
            ((ac)ad.this.dom.bh(ac.class)).amD(ad.k(ad.this));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/HeaderComponent$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(179914);
            return;
          }
          if ((int)ad.this.dom.GUe.gMZ == 0)
          {
            bg.aVF();
            if (com.tencent.mm.model.c.aSN().aq(ad.this.dom.GUe) != -1) {
              Log.e("MicroMsg.ChattingUI.HeaderComponent", "[insertRetId] successfully! username:%s", new Object[] { ad.this.dom.GUe });
            }
          }
          if (ab.Eq(ad.this.dom.GUe.field_username))
          {
            paramAnonymousView = ad.this.dom.GUe.field_username;
            label202:
            bg.aVF();
            Object localObject2 = com.tencent.mm.model.c.aSN().Kn(ad.f(ad.this));
            if (localObject2 == null) {
              break label400;
            }
            localObject1 = Util.nullAs(((ax)localObject2).fuY, "");
            label236:
            Log.i("MicroMsg.ChattingUI.HeaderComponent", "dkverify banner add:%s chat:%s ticket", new Object[] { ad.f(ad.this), paramAnonymousView, localObject1 });
            if (((!TextUtils.isEmpty(paramAnonymousView)) && (TextUtils.isEmpty((CharSequence)localObject1))) || (as.bjp(((ax)localObject2).field_username))) {
              break label406;
            }
            localObject2 = new com.tencent.mm.pluginsdk.ui.applet.a(ad.this.dom.Pwc.getContext(), new a.a()
            {
              public final void a(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2, String paramAnonymous2String1, String paramAnonymous2String2)
              {
                AppMethodBeat.i(233127);
                if (paramAnonymous2Boolean1)
                {
                  ab.B(ad.this.dom.GUe);
                  ad.3.this.PrJ.setVisibility(8);
                }
                AppMethodBeat.o(233127);
              }
            });
            LinkedList localLinkedList = new LinkedList();
            localLinkedList.add(Integer.valueOf(3));
            ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).beC((String)localObject1);
            ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).Keg = true;
            ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).d(ad.f(ad.this), paramAnonymousView, localLinkedList);
          }
          for (;;)
          {
            h.CyF.a(11004, new Object[] { ad.f(ad.this), Integer.valueOf(3) });
            break;
            paramAnonymousView = "";
            break label202;
            label400:
            localObject1 = "";
            break label236;
            label406:
            ay.a.iDq.a(ad.f(ad.this), paramAnonymousView, new ay.b.a()
            {
              public final void p(String paramAnonymous2String, boolean paramAnonymous2Boolean)
              {
                AppMethodBeat.i(233129);
                com.tencent.mm.pluginsdk.ui.applet.a locala = new com.tencent.mm.pluginsdk.ui.applet.a(ad.this.dom.Pwc.getContext(), new a.a()
                {
                  public final void a(boolean paramAnonymous3Boolean1, boolean paramAnonymous3Boolean2, String paramAnonymous3String1, String paramAnonymous3String2)
                  {
                    AppMethodBeat.i(233128);
                    if (paramAnonymous3Boolean1)
                    {
                      ab.B(ad.this.dom.GUe);
                      ad.3.this.PrJ.setVisibility(8);
                    }
                    AppMethodBeat.o(233128);
                  }
                });
                LinkedList localLinkedList = new LinkedList();
                localLinkedList.add(Integer.valueOf(3));
                bg.aVF();
                paramAnonymous2String = com.tencent.mm.model.c.aSN().Kn(ad.f(ad.this));
                if (paramAnonymous2String != null) {}
                for (paramAnonymous2String = Util.nullAs(paramAnonymous2String.fuY, "");; paramAnonymous2String = "")
                {
                  locala.beC(paramAnonymous2String);
                  locala.Keg = true;
                  locala.d(ad.f(ad.this), paramAnonymousView, localLinkedList);
                  AppMethodBeat.o(233129);
                  return;
                }
              }
            });
          }
        }
      });
      h.CyF.a(11004, new Object[] { this.Prt, Integer.valueOf(1) });
      AppMethodBeat.o(35414);
      return;
      localLinearLayout = (LinearLayout)this.Prr.findViewById(2131298316);
    }
  }
  
  public final void gQs()
  {
    AppMethodBeat.i(233137);
    if (this.dom.Pwc.hasDestory)
    {
      AppMethodBeat.o(233137);
      return;
    }
    if (this.Prp != null) {
      gQu();
    }
    if ((this.dom.Pwc.getController() != null) && (this.dom.Pwc.getMMResources() != null)) {
      this.dom.Pwc.getController().setActionbarColor(this.dom.Pwc.getMMResources().getColor(2131099650));
    }
    Object localObject = ((AppCompatActivity)this.dom.Pwc.getContext()).getSupportActionBar();
    if (localObject != null) {
      ((ActionBar)localObject).setElevation(0.0F);
    }
    if (this.Prr == null)
    {
      l.a(this.dom.Pwc, 2131309880);
      this.Prr = ((LinearLayout)this.dom.Pwc.getContext().findViewById(2131301563));
      localObject = (LinearLayout)this.dom.Pwc.getContext().getLayoutInflater().inflate(2131493626, null);
      this.Prr.addView((View)localObject, new ViewGroup.LayoutParams(-1, -2));
    }
    for (;;)
    {
      this.Prr.setVisibility(0);
      ((LinearLayout)localObject).setVisibility(0);
      ((com.tencent.mm.ui.chatting.d.b.o)this.dom.bh(com.tencent.mm.ui.chatting.d.b.o.class)).j(this.Prr);
      AppMethodBeat.o(233137);
      return;
      localObject = (LinearLayout)this.Prr.findViewById(2131298537);
    }
  }
  
  public final int gQy()
  {
    AppMethodBeat.i(35420);
    int j = 0;
    int i = j;
    if (this.Prp != null)
    {
      i = j;
      if (this.Prp.isShown()) {
        i = this.Prp.getHeight() + 0;
      }
    }
    AppMethodBeat.o(35420);
    return i;
  }
  
  public final int gQz()
  {
    AppMethodBeat.i(233138);
    if ((this.dom.Pwc.isCurrentActivity) || (!isSupportCustomActionBar())) {
      ((AppCompatActivity)this.dom.Pwc.getContext()).getSupportActionBar().a(P(null), new ActionBar.LayoutParams(-1, -1));
    }
    for (ActionBar localActionBar = ((AppCompatActivity)this.dom.Pwc.getContext()).getSupportActionBar(); (localActionBar != null) && (localActionBar.getCustomView() != null); localActionBar = this.Pru.getSupportActionBar())
    {
      int[] arrayOfInt = new int[2];
      localActionBar.getCustomView().getLocationOnScreen(arrayOfInt);
      int i = localActionBar.getHeight();
      int j = arrayOfInt[1];
      int k = gQy();
      AppMethodBeat.o(233138);
      return i + j + k;
    }
    AppMethodBeat.o(233138);
    return 0;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    int j = 1;
    AppMethodBeat.i(35389);
    super.onConfigurationChanged(paramConfiguration);
    Log.d("MicroMsg.ChattingUI.HeaderComponent", "getConfiguration().orientation = " + this.dom.Pwc.getMMResources().getConfiguration().orientation + ", newConfig.orientation = " + paramConfiguration.orientation);
    this.dom.Pwc.getMMResources().getConfiguration().orientation = paramConfiguration.orientation;
    Log.i("MicroMsg.ChatFooter", "[dealOrientationChange] %s", new Object[] { ((u)this.dom.bh(u.class)).gPO().getContext().getResources().getConfiguration() });
    int i;
    if (this.mActionBarContainer != null)
    {
      i = 1;
      if (this.Prw == null) {
        break label271;
      }
    }
    for (;;)
    {
      if ((i & j) != 0)
      {
        i = com.tencent.mm.compatible.util.a.cy(this.dom.Pwc.getContext());
        this.Prw.setMinimumHeight(i);
        ViewGroup.LayoutParams localLayoutParams2 = this.Prw.getLayoutParams();
        ViewGroup.LayoutParams localLayoutParams1 = localLayoutParams2;
        if (localLayoutParams2 == null) {
          localLayoutParams1 = new ViewGroup.LayoutParams(-1, -1);
        }
        localLayoutParams1.height = i;
        this.Prw.setLayoutParams(localLayoutParams1);
        localLayoutParams1 = this.mActionBarContainer.getLayoutParams();
        localLayoutParams1.height = i;
        this.mActionBarContainer.setLayoutParams(localLayoutParams1);
      }
      if (this.Pru != null) {
        this.Pru.OHt.mActionBar.onConfigurationChanged(paramConfiguration);
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
    this.Prv.setClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(233131);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/HeaderComponent$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (!ad.this.dom.Pwc.isScreenEnable())
        {
          Log.w("MicroMsg.ChattingUI.HeaderComponent", "Actionbar customView onclick screen not enable");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/HeaderComponent$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(233131);
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
            AppMethodBeat.i(233130);
            if (ad.4.this.OxX != null) {
              ad.4.this.OxX.onMenuItemClick(null);
            }
            AppMethodBeat.o(233130);
          }
        });
        ((com.tencent.mm.ui.chatting.d.b.ai)ad.this.dom.bh(com.tencent.mm.ui.chatting.d.b.ai.class)).gQT();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/HeaderComponent$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(233131);
      }
    });
    this.Prv.gGI();
    AppMethodBeat.o(35423);
  }
  
  public final void setMMSubTitle(String paramString)
  {
    AppMethodBeat.i(35422);
    int i = com.tencent.mm.cb.a.aG(this.dom.Pwc.getContext(), 2131165482);
    paramString = com.tencent.mm.pluginsdk.ui.span.l.e(this.dom.Pwc.getContext(), paramString, i);
    this.Prv.ap(paramString);
    AppMethodBeat.o(35422);
  }
  
  public final void setMMTitle(int paramInt)
  {
    AppMethodBeat.i(35402);
    setMMTitle(this.dom.Pwc.getMMResources().getString(paramInt));
    AppMethodBeat.o(35402);
  }
  
  public final void setMMTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(35421);
    if ((ab.Iy(this.dom.getTalkerUserName())) || (((f)this.dom.bh(f.class)).gPk()))
    {
      this.Prv.setTitle(paramCharSequence);
      this.dom.Pwc.updateDescription(this.dom.Pwc.getContext().getString(2131757337, new Object[] { paramCharSequence }));
      AppMethodBeat.o(35421);
      return;
    }
    if (as.bjp(this.dom.GUe.field_username)) {
      paramCharSequence = ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.openim.a.a.class)).e(MMApplicationContext.getContext(), paramCharSequence.toString(), com.tencent.mm.cb.a.aG(MMApplicationContext.getContext(), 2131165195));
    }
    for (;;)
    {
      this.Prv.setTitle(paramCharSequence);
      this.dom.Pwc.updateDescription(this.dom.Pwc.getContext().getString(2131757337, new Object[] { paramCharSequence }));
      AppMethodBeat.o(35421);
      return;
      paramCharSequence = com.tencent.mm.pluginsdk.ui.span.l.e(this.dom.Pwc.getContext(), paramCharSequence, com.tencent.mm.cb.a.aG(this.dom.Pwc.getContext(), 2131165195));
      if (!ab.Eq(this.dom.getTalkerUserName()))
      {
        paramCharSequence = ((com.tencent.mm.plugin.textstatus.a.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.textstatus.a.c.class)).attachTextStatusSpanSync(this.dom.getTalkerUserName(), paramCharSequence, a.b.FXg, com.tencent.mm.cb.a.aG(this.dom.Pwc.getContext(), 2131165195));
        gQm();
      }
    }
  }
  
  public final void setTitleForceNotifyIconVisibility(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(35425);
    Object localObject = this.Prv;
    if (paramInt == 0)
    {
      paramInt = 1;
      localObject = ((com.tencent.mm.ui.a)localObject).OwJ;
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
    if ((ab.Jx(this.dom.getTalkerUserName())) || (ab.JC(this.dom.getTalkerUserName())))
    {
      this.Prv.AR(false);
      AppMethodBeat.o(35426);
      return;
    }
    com.tencent.mm.ui.a locala = this.Prv;
    if (paramInt == 0) {
      bool = true;
    }
    locala.AR(bool);
    AppMethodBeat.o(35426);
  }
  
  public final void setTitlePhoneIconVisibility(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(35424);
    Object localObject = this.Prv;
    if (paramInt == 0)
    {
      paramInt = 1;
      localObject = ((com.tencent.mm.ui.a)localObject).OwK;
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
  
  final class a
    implements com.tencent.mm.plugin.newtips.a.a
  {
    private int Oye;
    public boolean PrR;
    private t.a PrS;
    private View gvQ;
    private String path;
    
    public a(int paramInt, String paramString, t.a parama)
    {
      AppMethodBeat.i(233134);
      this.gvQ = new View(ad.this.dom.Pwc.getContext());
      this.PrR = false;
      this.Oye = 0;
      this.path = paramString;
      this.PrS = parama;
      AppMethodBeat.o(233134);
    }
    
    public final void a(k paramk, boolean paramBoolean)
    {
      AppMethodBeat.i(179924);
      com.tencent.mm.plugin.newtips.a.g.a(this, paramk, paramBoolean);
      AppMethodBeat.o(179924);
    }
    
    public final boolean a(boolean paramBoolean, ehv paramehv)
    {
      return false;
    }
    
    public final boolean b(boolean paramBoolean, ehv paramehv)
    {
      return false;
    }
    
    public final boolean c(boolean paramBoolean, ehv paramehv)
    {
      return false;
    }
    
    public final boolean d(boolean paramBoolean, ehv paramehv)
    {
      return false;
    }
    
    public final boolean ehp()
    {
      return false;
    }
    
    public final String getPath()
    {
      return this.path;
    }
    
    public final View getRoot()
    {
      return this.gvQ;
    }
    
    public final boolean qV(boolean paramBoolean)
    {
      AppMethodBeat.i(179925);
      paramBoolean = com.tencent.mm.plugin.newtips.a.g.a(paramBoolean, this);
      AppMethodBeat.o(179925);
      return paramBoolean;
    }
    
    public final boolean qW(boolean paramBoolean)
    {
      AppMethodBeat.i(179926);
      this.PrR = paramBoolean;
      ad.this.dom.Pwc.updateOptionMenuRedDot(this.Oye, paramBoolean);
      AppMethodBeat.o(179926);
      return true;
    }
    
    public final boolean qX(boolean paramBoolean)
    {
      return false;
    }
  }
  
  final class b
    extends com.tencent.mm.ui.y
  {
    b() {}
    
    public final void ane()
    {
      AppMethodBeat.i(35387);
      if (((com.tencent.mm.ui.chatting.d.b.ai)ad.this.dom.bh(com.tencent.mm.ui.chatting.d.b.ai.class)).gQP())
      {
        AppMethodBeat.o(35387);
        return;
      }
      Object localObject1;
      if (ab.Iy(ad.this.dom.getTalkerUserName()))
      {
        localObject1 = new gq();
        ((gq)localObject1).us(ad.this.dom.getTalkerUserName());
        ((gq)localObject1).erw = 4L;
        ((gq)localObject1).bfK();
      }
      if ((ad.a(ad.this) != null) && (ad.a(ad.this).PrR)) {
        com.tencent.mm.plugin.newtips.a.exl().TC(25);
      }
      if (ab.IL(ad.this.dom.getTalkerUserName())) {
        h.CyF.a(19540, new Object[] { Integer.valueOf(2) });
      }
      ad.this.dom.hideVKB();
      Object localObject3;
      Object localObject2;
      if (ab.Jx(ad.this.dom.getTalkerUserName()))
      {
        if (((com.tencent.mm.ui.chatting.d.b.o)ad.this.dom.bh(com.tencent.mm.ui.chatting.d.b.o.class)).gPH())
        {
          localObject3 = ((com.tencent.mm.ui.chatting.d.b.o)ad.this.dom.bh(com.tencent.mm.ui.chatting.d.b.o.class)).gPI();
          if (as.HF((String)localObject3))
          {
            localObject1 = com.tencent.mm.msgsubscription.api.b.jza;
            localObject2 = com.tencent.mm.msgsubscription.api.b.Ru("name_wxa");
            localObject1 = com.tencent.mm.plugin.appbrand.config.y.Xr((String)localObject3);
            if (localObject1 != null)
            {
              localObject1 = ((com.tencent.mm.plugin.appbrand.config.ae)localObject1).nickname;
              if (localObject2 == null) {
                break label379;
              }
              ((com.tencent.mm.msgsubscription.b.a)localObject2).a(ad.this.dom.Pwc.getContext(), 4, (String)localObject3, (String)localObject1);
            }
          }
          for (;;)
          {
            h.CyF.a(21825, new Object[] { Integer.valueOf(7), localObject3, Long.valueOf(Util.nowSecond()), null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
            AppMethodBeat.o(35387);
            return;
            Log.e("MicroMsg.ChattingUI.HeaderComponent", "attrs is null");
            localObject1 = null;
            break;
            localObject1 = com.tencent.mm.msgsubscription.api.b.jza;
            localObject2 = com.tencent.mm.msgsubscription.api.b.Ru("name_biz");
            localObject1 = com.tencent.mm.model.aa.getDisplayName((String)localObject3);
            break;
            label379:
            Log.e("MicroMsg.ChattingUI.HeaderComponent", "service is null");
          }
        }
        localObject1 = ad.this.dom.Pwc.getContext();
        localObject2 = new Intent(ad.this.dom.Pwc.getContext(), ServiceNotifyConversationUI.class);
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/ui/chatting/component/HeaderComponent$OptionListener", "onRealClick", "(Landroid/view/MenuItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((Activity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/chatting/component/HeaderComponent$OptionListener", "onRealClick", "(Landroid/view/MenuItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        h.CyF.a(21825, new Object[] { Integer.valueOf(1), null, Long.valueOf(Util.nowSecond()), null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        AppMethodBeat.o(35387);
        return;
      }
      if (ab.JC(ad.this.dom.getTalkerUserName()))
      {
        localObject2 = new Intent(ad.this.dom.Pwc.getContext(), AppBrandNotifySettingsUI.class);
        localObject1 = (com.tencent.mm.plugin.appbrand.service.g)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.g.class);
        if (localObject1 == null) {
          break label1161;
        }
        localObject1 = ((com.tencent.mm.plugin.appbrand.service.g)localObject1).bul();
        ((Intent)localObject2).putExtra("report_session_id", (String)localObject1);
      }
      for (;;)
      {
        localObject3 = ad.this.dom.Pwc.getContext();
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(localObject3, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/ui/chatting/component/HeaderComponent$OptionListener", "onRealClick", "(Landroid/view/MenuItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((Activity)localObject3).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject3, "com/tencent/mm/ui/chatting/component/HeaderComponent$OptionListener", "onRealClick", "(Landroid/view/MenuItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        h.CyF.a(19724, new Object[] { Integer.valueOf(1), Integer.valueOf(6), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null, null, null, Integer.valueOf(0), null, null, Integer.valueOf(0), null, null, localObject1 });
        AppMethodBeat.o(35387);
        return;
        if (ab.IP(ad.this.dom.getTalkerUserName()))
        {
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("Contact_User", ad.this.dom.getTalkerUserName());
          com.tencent.mm.br.c.b(ad.this.dom.Pwc.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject1);
          AppMethodBeat.o(35387);
          return;
        }
        if (((ac)ad.this.dom.bh(ac.class)).gQH())
        {
          ad.b(ad.this);
          AppMethodBeat.o(35387);
          return;
        }
        if (((com.tencent.mm.ui.chatting.d.b.d)ad.this.dom.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gPa())
        {
          AppMethodBeat.o(35387);
          return;
        }
        if (((com.tencent.mm.ui.chatting.d.b.i)ad.this.dom.bh(com.tencent.mm.ui.chatting.d.b.i.class)).gPw()) {
          ((PluginGameLife)com.tencent.mm.kernel.g.ah(PluginGameLife.class)).jumpToGameLifeSingleChatInfoUIReport(ad.this.dom.getTalkerUserName());
        }
        localObject2 = new Intent();
        ((Intent)localObject2).setClass(ad.this.dom.Pwc.getContext(), SingleChatInfoUI.class);
        ((Intent)localObject2).putExtra("Single_Chat_Talker", ad.this.dom.getTalkerUserName());
        ((Intent)localObject2).putExtra("fromChatting", true);
        localObject1 = ad.this.dom.Pwc;
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/ui/chatting/component/HeaderComponent$OptionListener", "onRealClick", "(Landroid/view/MenuItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((MMFragment)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/chatting/component/HeaderComponent$OptionListener", "onRealClick", "(Landroid/view/MenuItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(35387);
        return;
        label1161:
        localObject1 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.ad
 * JD-Core Version:    0.7.0.1
 */