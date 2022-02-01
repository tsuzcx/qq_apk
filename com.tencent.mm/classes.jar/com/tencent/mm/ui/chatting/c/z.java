package com.tencent.mm.ui.chatting.c;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
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
import com.tencent.mm.ak.p;
import com.tencent.mm.g.a.ww;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.ar.b.a;
import com.tencent.mm.model.az;
import com.tencent.mm.model.b.b.a;
import com.tencent.mm.model.b.b.b;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.newtips.PluginNewTips.a;
import com.tencent.mm.plugin.newtips.a.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.protocal.protobuf.dcb;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.af;
import com.tencent.mm.ui.AppBrandNotifySettingsUI;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.ServiceNotifySettingsUI;
import com.tencent.mm.ui.SingleChatInfoUI;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.aa;
import com.tencent.mm.ui.chatting.c.b.f;
import com.tencent.mm.ui.chatting.c.b.o;
import com.tencent.mm.ui.r.a;
import com.tencent.mm.ui.u;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.chatting.c.a.a(eYT=com.tencent.mm.ui.chatting.c.b.w.class)
public class z
  extends a
  implements com.tencent.mm.ui.chatting.c.b.w
{
  private final k.a GsS;
  private boolean GsV;
  final int GwA;
  final MenuItem.OnMenuItemClickListener GwB;
  private View GwC;
  private View GwD;
  protected LinearLayout Gwn;
  protected LinearLayout Gwo;
  private List<String> Gwp;
  private String Gwq;
  public u Gwr;
  private com.tencent.mm.ui.a Gws;
  private View Gwt;
  private a Gwu;
  final com.tencent.mm.ui.w Gwv;
  private b.a Gww;
  private Runnable Gwx;
  private final com.tencent.mm.ak.e.a Gwy;
  final int Gwz;
  private MenuItem.OnMenuItemClickListener backListener;
  private ActionBarContainer mActionBarContainer;
  private int woZ;
  
  public z()
  {
    AppMethodBeat.i(35388);
    this.Gwp = new LinkedList();
    this.woZ = 0;
    this.mActionBarContainer = null;
    this.Gwr = null;
    this.GsV = false;
    this.Gwv = new b();
    this.Gww = new b.a()
    {
      public final void atk()
      {
        AppMethodBeat.i(179915);
        com.tencent.mm.ui.chatting.d.a.eZd().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(35371);
            az.arV().aqm();
            if (com.tencent.mm.model.b.b.a(b.b.gPX))
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
    this.Gwx = null;
    this.Gwy = new com.tencent.mm.ak.e.a()
    {
      public final void vZ(final String paramAnonymousString)
      {
        AppMethodBeat.i(179917);
        com.tencent.mm.ui.chatting.d.a.eZd().removeCallbacks(z.e(z.this));
        com.tencent.mm.ui.chatting.d.a.eZd().postDelayed(z.a(z.this, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(179916);
            if ((!bt.isNullOrNil(z.f(z.this))) && (!bt.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals(z.f(z.this)))) {
              z.this.wg(false);
            }
            AppMethodBeat.o(179916);
          }
        }), 1000L);
        AppMethodBeat.o(179917);
      }
    };
    this.GsS = new k.a()
    {
      public final void a(String paramAnonymousString, m paramAnonymousm)
      {
        AppMethodBeat.i(179918);
        com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.ChattingUI.HeaderComponent", "roommember watcher notify ".concat(String.valueOf(paramAnonymousString)));
        if ((z.this.cOd.eZb()) && (!bt.isNullOrNil(paramAnonymousString)))
        {
          z.this.eXQ();
          z.this.eXT();
        }
        AppMethodBeat.o(179918);
      }
    };
    this.backListener = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(35381);
        boolean bool = z.this.cOd.GzJ.eUW();
        AppMethodBeat.o(35381);
        return bool;
      }
    };
    this.Gwz = 1;
    this.GwA = 2;
    this.GwB = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(179922);
        ww localww = new ww();
        localww.dCp.djq = 5;
        localww.dCp.talker = z.this.cOd.zgX.field_username;
        localww.dCp.context = z.this.cOd.GzJ.getContext();
        if (paramAnonymousMenuItem.getItemId() == 1) {
          localww.dCp.dCj = 4;
        }
        for (;;)
        {
          com.tencent.mm.sdk.b.a.ESL.l(localww);
          AppMethodBeat.o(179922);
          return true;
          if (paramAnonymousMenuItem.getItemId() == 2) {
            localww.dCp.dCj = 2;
          }
        }
      }
    };
    this.GwC = null;
    this.GwD = null;
    AppMethodBeat.o(35388);
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
    r.a locala = this.cOd.GzJ.findMenuInfo(0);
    if (bt.isNullOrNil(paramString))
    {
      if (locala == null)
      {
        this.cOd.GzJ.addIconOptionMenu(0, paramInt1, paramInt2, paramOnMenuItemClickListener);
        AppMethodBeat.o(179927);
        return;
      }
      this.cOd.GzJ.updateOptionMenu(0, paramInt1, paramInt2, paramOnMenuItemClickListener);
      AppMethodBeat.o(179927);
      return;
    }
    if (locala == null) {
      this.cOd.GzJ.addIconOptionMenu(0, paramInt1, paramInt2, paramOnMenuItemClickListener);
    }
    for (paramOnMenuItemClickListener = this.cOd.GzJ.findMenuInfo(0); paramOnMenuItemClickListener == null; paramOnMenuItemClickListener = locala)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ChattingUI.HeaderComponent", "updateMenuInfo menuInfo == null");
      AppMethodBeat.o(179927);
      return;
      this.cOd.GzJ.updateOptionMenu(0, paramInt1, paramInt2, paramOnMenuItemClickListener);
    }
    this.Gwu = new a(paramString, paramOnMenuItemClickListener);
    com.tencent.mm.plugin.newtips.a.cWs().h(this.Gwu);
    com.tencent.mm.plugin.newtips.a.g.a(this.Gwu);
    if (paramOnMenuItemClickListener.FOz) {
      com.tencent.mm.plugin.newtips.a.g.a(this.Gwu, com.tencent.mm.plugin.newtips.a.k.uev, true);
    }
    AppMethodBeat.o(179927);
  }
  
  private void a(ActionBar paramActionBar)
  {
    AppMethodBeat.i(35408);
    boolean bool = ai.Eq();
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
          ai.a(((TextView)localObject).getPaint(), 0.8F);
          if (bool) {
            ((TextView)localObject).setTextColor(this.cOd.GzJ.getMMResources().getColor(2131099886));
          }
        }
        localObject = (TextView)paramActionBar.getCustomView().findViewById(2131305509);
        if ((localObject != null) && (bool)) {
          ((TextView)localObject).setTextColor(this.cOd.GzJ.getMMResources().getColor(2131099886));
        }
        localObject = (ImageView)paramActionBar.getCustomView().findViewById(2131302623);
        if ((localObject != null) && (bool))
        {
          if (((ImageView)localObject).getDrawable() == null) {
            break label246;
          }
          ((ImageView)localObject).getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
        }
      }
      for (;;)
      {
        paramActionBar = (ImageView)paramActionBar.getCustomView().findViewById(2131303211);
        if ((paramActionBar == null) || (!bool)) {
          break label265;
        }
        if (paramActionBar.getDrawable() == null) {
          break label257;
        }
        paramActionBar.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
        AppMethodBeat.o(35408);
        return;
        ((ImageView)localObject).setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
        break;
        label246:
        ((ImageView)localObject).setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      }
      label257:
      paramActionBar.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
    }
    label265:
    AppMethodBeat.o(35408);
  }
  
  private String al(af paramaf)
  {
    AppMethodBeat.i(35403);
    if (paramaf == null)
    {
      paramaf = this.cOd.GzJ.getContext().getString(2131756727);
      AppMethodBeat.o(35403);
      return paramaf;
    }
    if (RegionCodeDecoder.aJc(paramaf.getCountryCode()))
    {
      String str = paramaf.getCity();
      if (!bt.isNullOrNil(str))
      {
        AppMethodBeat.o(35403);
        return str;
      }
      str = v.sj(paramaf.getProvince());
      if (!bt.isNullOrNil(str))
      {
        AppMethodBeat.o(35403);
        return str;
      }
      RegionCodeDecoder.eMO();
      paramaf = RegionCodeDecoder.getLocName(paramaf.getCountryCode());
      AppMethodBeat.o(35403);
      return paramaf;
    }
    paramaf = v.sj(paramaf.getProvince());
    if (!bt.isNullOrNil(paramaf))
    {
      AppMethodBeat.o(35403);
      return paramaf;
    }
    paramaf = this.cOd.GzJ.getContext().getString(2131756727);
    AppMethodBeat.o(35403);
    return paramaf;
  }
  
  private void eUz()
  {
    AppMethodBeat.i(35399);
    if ((com.tencent.mm.model.w.sw(this.cOd.getTalkerUserName())) || (com.tencent.mm.model.w.sx(this.cOd.getTalkerUserName())) || (com.tencent.mm.model.w.sy(this.cOd.getTalkerUserName())))
    {
      com.tencent.mm.plugin.newtips.a.cWv();
      boolean bool = com.tencent.mm.plugin.newtips.a.e.Il(com.tencent.mm.plugin.newtips.a.d.udT);
      this.cOd.GzJ.addIconOptionMenu(0, 2131755135, 2131689511, Boolean.valueOf(bool).booleanValue(), this.Gwv);
    }
    AppMethodBeat.o(35399);
  }
  
  private void eXP()
  {
    AppMethodBeat.i(35400);
    if (com.tencent.mm.kernel.g.afz().aeI())
    {
      p.auq().b(this.Gwy);
      az.arV();
      com.tencent.mm.model.c.apV().remove(this.GsS);
    }
    com.tencent.mm.ui.chatting.d.a.eZd().removeCallbacks(this.Gwx);
    com.tencent.mm.model.q.aqA();
    if (this.Gwu != null)
    {
      com.tencent.mm.plugin.newtips.a.cWs();
      i.i(this.Gwu);
    }
    AppMethodBeat.o(35400);
  }
  
  private void eXS()
  {
    AppMethodBeat.i(35409);
    this.Gwp.clear();
    this.Gwp.add(this.cOd.GzJ.getStringExtra("Chat_User"));
    AppMethodBeat.o(35409);
  }
  
  private void eXU()
  {
    AppMethodBeat.i(35413);
    if (this.cOd.GzJ.getContext() == null)
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.ChattingUI.HeaderComponent", "getActivity is null");
      AppMethodBeat.o(35413);
      return;
    }
    eYa();
    ViewGroup localViewGroup = (ViewGroup)this.cOd.GzJ.getContext().findViewById(2131298063);
    com.tencent.mm.pluginsdk.ui.b.a locala = com.tencent.mm.ui.conversation.a.e.a(this.cOd.GzJ.getContext(), com.tencent.mm.ui.conversation.a.e.a.HgK, new Object[] { b.b.gPX });
    if ((localViewGroup != null) && (locala != null) && (locala.getView() != null) && (this.GwD == null))
    {
      this.GwD = locala.getView();
      localViewGroup.addView(this.GwD, new ViewGroup.LayoutParams(-1, -2));
    }
    AppMethodBeat.o(35413);
  }
  
  private void eXW()
  {
    AppMethodBeat.i(35415);
    if ((this.cOd.eZb()) || (this.Gwn == null))
    {
      eXX();
      AppMethodBeat.o(35415);
      return;
    }
    eXX();
    com.tencent.mm.pluginsdk.ui.b.a locala2;
    if (this.Gwn.getTag() == null)
    {
      locala2 = com.tencent.mm.ui.conversation.a.e.a(this.cOd.GzJ.getContext(), com.tencent.mm.ui.conversation.a.e.a.Hgy, new Object[] { this.cOd.getTalkerUserName(), this.cOd.eWM() });
      locala1 = locala2;
      if (locala2 != null)
      {
        locala1 = locala2;
        if (locala2.getView() != null) {
          this.Gwn.addView(locala2.getView(), new ViewGroup.LayoutParams(-1, -2));
        }
      }
    }
    for (com.tencent.mm.pluginsdk.ui.b.a locala1 = locala2;; locala1 = (com.tencent.mm.pluginsdk.ui.b.a)this.Gwn.getTag())
    {
      if (locala1 != null)
      {
        this.Gwn.setVisibility(0);
        this.Gwn.setTag(locala1);
      }
      h.vKh.f(11003, new Object[] { this.cOd.getTalkerUserName(), Integer.valueOf(1), Integer.valueOf(0) });
      AppMethodBeat.o(35415);
      return;
    }
  }
  
  private void eXX()
  {
    AppMethodBeat.i(35416);
    this.Gwn.setVisibility(8);
    if (this.Gwo != null) {
      this.Gwo.setVisibility(8);
    }
    AppMethodBeat.o(35416);
  }
  
  private void eXY()
  {
    AppMethodBeat.i(35417);
    if (this.cOd.GzJ.getContext() == null)
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.ChattingUI.HeaderComponent", "getActivity is null");
      AppMethodBeat.o(35417);
      return;
    }
    eXZ();
    ViewGroup localViewGroup = (ViewGroup)this.cOd.GzJ.getContext().findViewById(2131298070);
    com.tencent.mm.pluginsdk.ui.b.a locala = com.tencent.mm.ui.conversation.a.e.a(this.cOd.GzJ.getContext(), com.tencent.mm.ui.conversation.a.e.a.Hgz, new Object[] { this.cOd.getTalkerUserName(), this.cOd.eWM(), Boolean.valueOf(this.cOd.eZb()) });
    if ((localViewGroup != null) && (locala != null) && (locala.getView() != null) && (this.GwC == null))
    {
      this.GwC = locala.getView();
      localViewGroup.addView(this.GwC, new ViewGroup.LayoutParams(-1, -2));
    }
    AppMethodBeat.o(35417);
  }
  
  private void eXZ()
  {
    AppMethodBeat.i(35418);
    ViewGroup localViewGroup = (ViewGroup)this.cOd.GzJ.getContext().findViewById(2131298070);
    if ((localViewGroup != null) && (this.GwC != null))
    {
      localViewGroup.removeView(this.GwC);
      this.GwC = null;
    }
    AppMethodBeat.o(35418);
  }
  
  private void eYa()
  {
    AppMethodBeat.i(35419);
    ViewGroup localViewGroup = (ViewGroup)this.cOd.GzJ.getContext().findViewById(2131298063);
    if ((localViewGroup != null) && (this.GwD != null))
    {
      localViewGroup.removeView(this.GwD);
      this.GwD = null;
    }
    AppMethodBeat.o(35419);
  }
  
  private boolean isSupportCustomActionBar()
  {
    AppMethodBeat.i(35404);
    boolean bool = this.cOd.GzJ.isSupportNavigationSwipeBack();
    AppMethodBeat.o(35404);
    return bool;
  }
  
  private View z(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(35406);
    if (this.Gwt == null)
    {
      if (paramViewGroup == null) {}
      for (this.Gwt = com.tencent.mm.ui.y.js(this.cOd.GzJ.getContext()).inflate(2131492921, null);; this.Gwt = com.tencent.mm.ui.y.js(this.cOd.GzJ.getContext()).inflate(2131492921, paramViewGroup, false))
      {
        paramViewGroup = this.Gwt;
        AppMethodBeat.o(35406);
        return paramViewGroup;
      }
    }
    if (this.Gwt.getParent() == null)
    {
      paramViewGroup = this.Gwt;
      AppMethodBeat.o(35406);
      return paramViewGroup;
    }
    if ((this.Gwt.getParent() instanceof ViewGroup))
    {
      ((ViewGroup)this.Gwt.getParent()).removeView(this.Gwt);
      paramViewGroup = this.Gwt;
      AppMethodBeat.o(35406);
      return paramViewGroup;
    }
    if (paramViewGroup == null) {}
    for (this.Gwt = com.tencent.mm.ui.y.js(this.cOd.GzJ.getContext()).inflate(2131492921, null);; this.Gwt = com.tencent.mm.ui.y.js(this.cOd.GzJ.getContext()).inflate(2131492921, paramViewGroup, false))
    {
      paramViewGroup = this.Gwt;
      AppMethodBeat.o(35406);
      return paramViewGroup;
    }
  }
  
  public final void YM(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(35427);
    Object localObject = this.Gws;
    if (paramInt == 0)
    {
      paramInt = 1;
      localObject = ((com.tencent.mm.ui.a)localObject).FFN;
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
  
  public final void a(com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(35390);
    super.a(parama);
    if (isSupportCustomActionBar())
    {
      this.Gwr = new u();
      parama = this.Gwr;
      BaseChattingUIFragment localBaseChattingUIFragment = this.cOd.GzJ;
      parama.FOX = localBaseChattingUIFragment;
      parama.FOY = new com.tencent.mm.ui.b.b(localBaseChattingUIFragment.thisActivity(), parama);
      this.cOd.GzJ.setActivityController(this.Gwr);
    }
    AppMethodBeat.o(35390);
  }
  
  public final void eQA()
  {
    AppMethodBeat.i(35391);
    eXR();
    AppMethodBeat.o(35391);
  }
  
  public final void eQB()
  {
    AppMethodBeat.i(35392);
    this.woZ = this.cOd.GzJ.getIntExtra("add_scene", 0);
    p.auq().a(this.Gwy);
    az.arV();
    com.tencent.mm.model.c.apV().add(this.GsS);
    setBackBtn(this.backListener);
    eUz();
    eXQ();
    eXT();
    eXX();
    this.GsV = true;
    com.tencent.mm.model.q.a(this.cOd.getTalkerUserName(), new PluginNewTips.a()
    {
      public final void cWw()
      {
        AppMethodBeat.i(179909);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingUI.HeaderComponent", "onCallback");
        z.this.eXT();
        AppMethodBeat.o(179909);
      }
    });
    AppMethodBeat.o(35392);
  }
  
  public final void eQC()
  {
    AppMethodBeat.i(35393);
    wg(true);
    AppMethodBeat.o(35393);
  }
  
  public final void eQD()
  {
    AppMethodBeat.i(35394);
    az.arV().aqk().a(new com.tencent.mm.model.b.e.a()
    {
      public final void atl()
      {
        AppMethodBeat.i(35378);
        com.tencent.mm.ui.chatting.d.a.eZd().post(new Runnable()
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
      
      public final void atm()
      {
        AppMethodBeat.i(35379);
        z.h(z.this);
        AppMethodBeat.o(35379);
      }
    });
    az.arV().aql().a(new com.tencent.mm.model.b.e.a()
    {
      public final void atl()
      {
        AppMethodBeat.i(179920);
        com.tencent.mm.ui.chatting.d.a.eZd().post(new Runnable()
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
      
      public final void atm()
      {
        AppMethodBeat.i(179921);
        z.j(z.this);
        AppMethodBeat.o(179921);
      }
    });
    com.tencent.mm.model.b.b localb = az.arV().aqm();
    b.a locala = this.Gww;
    try
    {
      localb.mListeners.add(locala);
      if (!this.GsV) {
        eUz();
      }
      this.GsV = false;
      AppMethodBeat.o(35394);
      return;
    }
    finally
    {
      AppMethodBeat.o(35394);
    }
  }
  
  public final void eQE()
  {
    AppMethodBeat.i(35395);
    if (com.tencent.mm.kernel.g.afz().aeI())
    {
      az.arV().aqk().a(null);
      az.arV().aql().a(null);
      com.tencent.mm.model.b.b localb = az.arV().aqm();
      b.a locala = this.Gww;
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
  
  public final void eQF()
  {
    AppMethodBeat.i(35396);
    eXP();
    AppMethodBeat.o(35396);
  }
  
  public final u eUV()
  {
    return this.Gwr;
  }
  
  public final void eWx()
  {
    AppMethodBeat.i(35397);
    super.eWx();
    eXP();
    AppMethodBeat.o(35397);
  }
  
  public final void eXO()
  {
    AppMethodBeat.i(35398);
    if (this.cOd.getHeaderViewsCount() > 0) {
      this.Gwn = ((LinearLayout)this.cOd.getListView().findViewById(2131301446));
    }
    for (;;)
    {
      eXX();
      AppMethodBeat.o(35398);
      return;
      this.Gwn = ((LinearLayout)this.cOd.GzJ.getContext().getLayoutInflater().inflate(2131493515, null));
      com.tencent.mm.ui.chatting.d.a locala = this.cOd;
      LinearLayout localLinearLayout = this.Gwn;
      locala.GzK.addHeaderView(localLinearLayout);
    }
  }
  
  public final void eXQ()
  {
    AppMethodBeat.i(35401);
    this.cOd.GzJ.setMMSubTitle(null);
    if (com.tencent.mm.model.w.sw(this.cOd.getTalkerUserName()))
    {
      setMMTitle(this.cOd.zgX.ZW());
      AppMethodBeat.o(35401);
      return;
    }
    if (((com.tencent.mm.ui.chatting.c.b.ae)this.cOd.be(com.tencent.mm.ui.chatting.c.b.ae.class)).eYx())
    {
      setMMTitle(2131762904);
      AppMethodBeat.o(35401);
      return;
    }
    if (af.aHE(this.cOd.getTalkerUserName()))
    {
      ((com.tencent.mm.ui.chatting.c.b.q)this.cOd.be(com.tencent.mm.ui.chatting.c.b.q.class)).eXs().setWordCountLimit(140);
      setMMTitle(this.cOd.zgX.ZX());
      AppMethodBeat.o(35401);
      return;
    }
    if (com.tencent.mm.model.w.tk(this.cOd.getTalkerUserName()))
    {
      setMMTitle(this.cOd.zgX.ZW());
      AppMethodBeat.o(35401);
      return;
    }
    if (af.st(this.cOd.getTalkerUserName()))
    {
      setMMTitle(this.cOd.GzJ.getContext().getString(2131756698, new Object[] { al(this.cOd.zgX) }).trim());
      AppMethodBeat.o(35401);
      return;
    }
    if (af.rz(this.cOd.getTalkerUserName()))
    {
      if (this.cOd.be(com.tencent.mm.ui.chatting.c.b.a.class) != null)
      {
        ((com.tencent.mm.ui.chatting.c.b.a)this.cOd.be(com.tencent.mm.ui.chatting.c.b.a.class)).eXQ();
        AppMethodBeat.o(35401);
      }
    }
    else
    {
      if (this.cOd.eZa())
      {
        boolean bool = ((f)this.cOd.be(f.class)).eWX();
        String str = this.cOd.zgX.field_conRemark;
        if (bt.isNullOrNil(str))
        {
          str = this.cOd.zgX.field_nickname;
          if (!bt.isNullOrNil(str)) {
            break label570;
          }
          if (com.tencent.mm.model.q.rY(this.cOd.getTalkerUserName()) != 0) {
            break label511;
          }
          str = this.cOd.GzJ.getContext().getString(2131757293);
        }
        for (;;)
        {
          Object localObject;
          if (!com.tencent.mm.model.w.sn(this.cOd.getTalkerUserName()))
          {
            localObject = str;
            if (!bool) {}
          }
          else
          {
            str = str + " ";
            localObject = com.tencent.mm.pluginsdk.ui.span.k.d(this.cOd.GzJ.getContext(), com.tencent.mm.pluginsdk.ui.span.k.b(this.cOd.GzJ.getContext(), str, com.tencent.mm.cd.a.ao(this.cOd.GzJ.getContext(), 2131165192)));
          }
          setMMTitle((CharSequence)localObject);
          AppMethodBeat.o(35401);
          return;
          setMMSubTitle(com.tencent.mm.pluginsdk.ui.span.k.c(this.cOd.GzJ.getContext(), this.cOd.eWM()).toString());
          break;
          label511:
          str = this.cOd.GzJ.getContext().getString(2131759496, new Object[] { this.cOd.GzJ.getContext().getString(2131757293), Integer.valueOf(com.tencent.mm.model.q.rY(this.cOd.getTalkerUserName())) });
          continue;
          label570:
          str = this.cOd.GzJ.getContext().getString(2131759496, new Object[] { this.cOd.zgX.ZX(), Integer.valueOf(com.tencent.mm.model.q.rY(this.cOd.getTalkerUserName())) });
        }
      }
      if (((com.tencent.mm.ui.chatting.c.b.d)this.cOd.be(com.tencent.mm.ui.chatting.c.b.d.class)).eWE())
      {
        AppMethodBeat.o(35401);
        return;
      }
      this.Gws.vi(af.aHG(this.cOd.getTalkerUserName()));
      this.cOd.GzJ.setMMTitle(this.cOd.zgX.ZX());
      this.Gws.vi(af.aHG(this.cOd.getTalkerUserName()));
      if (af.aHH(this.cOd.getTalkerUserName())) {
        this.cOd.GzJ.setMMSubTitle(((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).bt(this.cOd.zgX.field_openImAppid, this.cOd.zgX.field_descWordingId));
      }
    }
    AppMethodBeat.o(35401);
  }
  
  public final void eXR()
  {
    AppMethodBeat.i(35407);
    if ((this.cOd.GzJ.isCurrentActivity) || (!isSupportCustomActionBar()))
    {
      localObject1 = ((AppCompatActivity)this.cOd.GzJ.getContext()).getSupportActionBar();
      localObject2 = z(null);
      ((ActionBar)localObject1).setCustomView((View)localObject2);
      this.Gws = new com.tencent.mm.ui.a((View)localObject2);
      a((ActionBar)localObject1);
      this.Gws.vi(false);
      ((ActionBar)localObject1).setDisplayOptions((((ActionBar)localObject1).getDisplayOptions() | 0x10) & 0xFFFFFFFB & 0xFFFFFFFD & 0xFFFFFFF7);
      eXS();
      setBackBtn(this.backListener);
      AppMethodBeat.o(35407);
      return;
    }
    Object localObject1 = (ViewGroup)this.mActionBarContainer.findViewById(2131296343);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingUI.HeaderComponent", "mActionBarContainer %s", new Object[] { this.mActionBarContainer });
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingUI.HeaderComponent", "ctxView %s", new Object[] { this.mActionBarContainer.findViewById(2131296357) });
    ((ViewGroup)localObject1).setVisibility(0);
    Object localObject2 = this.Gwr.getSupportActionBar();
    View localView = z((ViewGroup)localObject1);
    ((ActionBar)localObject2).setCustomView(localView);
    this.Gws = new com.tencent.mm.ui.a(localView);
    int j = ((ActionBar)localObject2).getHeight();
    int i = j;
    if (j == 0)
    {
      localObject1 = this.cOd.GzJ.getMMResources().getDisplayMetrics();
      if (((DisplayMetrics)localObject1).widthPixels <= ((DisplayMetrics)localObject1).heightPixels) {
        break label322;
      }
    }
    label322:
    for (i = this.cOd.GzJ.getMMResources().getDimensionPixelSize(2131165251);; i = this.cOd.GzJ.getMMResources().getDimensionPixelSize(2131165252))
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
  
  public final void eXT()
  {
    AppMethodBeat.i(35410);
    Object localObject = (com.tencent.mm.ui.chatting.c.b.ae)this.cOd.be(com.tencent.mm.ui.chatting.c.b.ae.class);
    if ((((com.tencent.mm.ui.chatting.c.b.ae)localObject).eYx()) || (((com.tencent.mm.ui.chatting.c.b.ae)localObject).eYw()))
    {
      this.cOd.showOptionMenu(false);
      AppMethodBeat.o(35410);
      return;
    }
    if (((o)this.cOd.be(o.class)).eXr())
    {
      AppMethodBeat.o(35410);
      return;
    }
    if (com.tencent.mm.model.w.sz(this.cOd.getTalkerUserName()))
    {
      this.cOd.showOptionMenu(false);
      AppMethodBeat.o(35410);
      return;
    }
    if ((com.tencent.mm.model.w.sx(this.cOd.getTalkerUserName())) || (com.tencent.mm.model.w.sy(this.cOd.getTalkerUserName()))) {
      a(2131755135, 2131689511, this.Gwv);
    }
    while (af.st(this.cOd.getTalkerUserName()))
    {
      this.cOd.wk(true);
      AppMethodBeat.o(35410);
      return;
      if (com.tencent.mm.model.w.sw(this.cOd.getTalkerUserName()))
      {
        com.tencent.mm.plugin.newtips.a.cWv();
        boolean bool = com.tencent.mm.plugin.newtips.a.e.Il(com.tencent.mm.plugin.newtips.a.d.udT);
        this.cOd.GzJ.addIconOptionMenu(0, 2131755135, 2131689511, Boolean.valueOf(bool).booleanValue(), this.Gwv);
      }
      else if (com.tencent.mm.model.w.sA(this.cOd.getTalkerUserName()))
      {
        a(2131755135, 2131689511, this.Gwv);
      }
      else if (com.tencent.mm.model.w.sH(this.cOd.getTalkerUserName()))
      {
        a(2131755135, 2131689511, this.Gwv);
        h.vKh.kvStat(10071, "1");
      }
      else if (com.tencent.mm.model.w.sI(this.cOd.getTalkerUserName()))
      {
        a(2131755135, 2131689511, this.Gwv);
      }
      else if (com.tencent.mm.model.w.ti(this.cOd.getTalkerUserName()))
      {
        a(2131755135, 2131689511, this.Gwv);
      }
      else if (com.tencent.mm.model.w.tn(this.cOd.getTalkerUserName()))
      {
        a(2131755135, 2131689511, this.Gwv);
      }
      else if (com.tencent.mm.model.w.to(this.cOd.getTalkerUserName()))
      {
        if (com.tencent.mm.model.w.sT(this.cOd.getTalkerUserName()))
        {
          this.cOd.showOptionMenu(false);
          AppMethodBeat.o(35410);
          return;
        }
        a(2131755135, 2131689511, this.Gwv);
      }
      else if ((af.aHE(this.cOd.getTalkerUserName())) || (af.aHG(this.cOd.getTalkerUserName())) || (af.st(this.cOd.getTalkerUserName())))
      {
        a(2131757275, 2131689493, this.Gwv);
      }
      else if (af.rz(this.cOd.getTalkerUserName()))
      {
        if (this.cOd.be(com.tencent.mm.ui.chatting.c.b.a.class) != null) {
          ((com.tencent.mm.ui.chatting.c.b.a)this.cOd.be(com.tencent.mm.ui.chatting.c.b.a.class)).eYU();
        }
      }
      else if ((((aa)this.cOd.be(aa.class)).eYp()) && (j.aKH(this.cOd.getTalkerUserName())))
      {
        a(2131757275, 2131690972, this.Gwv);
      }
      else
      {
        ((ae)this.cOd.be(ae.class)).eYi();
        localObject = (com.tencent.mm.ui.chatting.c.b.d)this.cOd.be(com.tencent.mm.ui.chatting.c.b.d.class);
        if ((com.tencent.mm.model.w.sl(this.cOd.getTalkerUserName())) || (((com.tencent.mm.ui.chatting.c.b.d)localObject).eWC()))
        {
          if (((f)this.cOd.be(f.class)).eWV())
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingUI.HeaderComponent", "cpan show chatroom right btn");
            if ((((f)this.cOd.be(f.class)).eWW()) && (((f)this.cOd.be(f.class)).Vq()) && (com.tencent.mm.model.q.aqB())) {
              a(2131757275, 2131689493, "chatroom", this.Gwv);
            }
            for (;;)
            {
              this.cOd.showOptionMenu(true);
              break;
              a(2131757275, 2131689493, this.Gwv);
            }
          }
          if ((((com.tencent.mm.ui.chatting.c.b.d)localObject).eWC()) && (!((com.tencent.mm.ui.chatting.c.b.d)localObject).eWD()))
          {
            a(2131757275, 2131689507, this.Gwv);
            this.cOd.showOptionMenu(true);
          }
          else
          {
            this.cOd.showOptionMenu(false);
            AppMethodBeat.o(35410);
          }
        }
        else
        {
          a(2131757275, 2131689493, this.Gwv);
        }
      }
    }
    this.cOd.showOptionMenu(true);
    AppMethodBeat.o(35410);
  }
  
  @SuppressLint({"ResourceType"})
  public final void eXV()
  {
    AppMethodBeat.i(35414);
    if (this.cOd.GzJ.hasDestory)
    {
      AppMethodBeat.o(35414);
      return;
    }
    eXX();
    final LinearLayout localLinearLayout;
    ImageView localImageView;
    Object localObject;
    if (this.Gwo == null)
    {
      j.a(this.cOd.GzJ, 2131306443);
      this.Gwo = ((LinearLayout)this.cOd.GzJ.getContext().findViewById(2131300123));
      localLinearLayout = (LinearLayout)this.cOd.GzJ.getContext().getLayoutInflater().inflate(2131493514, null);
      this.Gwo.addView(localLinearLayout, new ViewGroup.LayoutParams(-1, -2));
      this.Gwo.setVisibility(0);
      localLinearLayout.setVisibility(0);
      localImageView = (ImageView)localLinearLayout.findViewById(2131296460);
      String str = this.Gwq;
      localObject = str;
      if (bt.isNullOrNil(str)) {
        localObject = this.cOd.zgX.field_username;
      }
      localObject = com.tencent.mm.ak.c.a((String)localObject, false, -1, null);
      if (localObject != null) {
        break label319;
      }
      localImageView.setImageResource(2131690013);
    }
    for (;;)
    {
      localObject = (Button)localLinearLayout.findViewById(2131297974);
      if (((com.tencent.mm.ui.chatting.c.b.y)this.cOd.be(com.tencent.mm.ui.chatting.c.b.y.class)).eYj()) {
        ((com.tencent.mm.ui.chatting.c.b.y)this.cOd.be(com.tencent.mm.ui.chatting.c.b.y.class)).a((Button)localObject, localLinearLayout, this.Gwo);
      }
      localImageView.setOnClickListener(new View.OnClickListener()
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
          if (((com.tencent.mm.ui.chatting.c.b.y)z.this.cOd.be(com.tencent.mm.ui.chatting.c.b.y.class)).eYj())
          {
            ((com.tencent.mm.ui.chatting.c.b.y)z.this.cOd.be(com.tencent.mm.ui.chatting.c.b.y.class)).YO(z.k(z.this));
            AppMethodBeat.o(35370);
            return;
          }
          if ((int)z.this.cOd.zgX.fId == 0)
          {
            az.arV();
            if (com.tencent.mm.model.c.apM().ag(z.this.cOd.zgX) != -1) {
              com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ChattingUI.HeaderComponent", "[insertRetId] successfully! username:%s", new Object[] { z.this.cOd.zgX });
            }
          }
          String str;
          if (com.tencent.mm.model.w.pF(z.this.cOd.zgX.field_username))
          {
            paramAnonymousView = z.this.cOd.zgX.field_username;
            az.arV();
            Object localObject = com.tencent.mm.model.c.apM().aHY(z.f(z.this));
            if (localObject == null) {
              break label362;
            }
            str = bt.by(((au)localObject).evP, "");
            label195:
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingUI.HeaderComponent", "dkverify banner add:%s chat:%s ticket", new Object[] { z.f(z.this), paramAnonymousView, str });
            if (((!TextUtils.isEmpty(paramAnonymousView)) && (TextUtils.isEmpty(str))) || (af.aHH(((au)localObject).field_username))) {
              break label368;
            }
            localObject = new com.tencent.mm.pluginsdk.ui.applet.a(z.this.cOd.GzJ.getContext(), new a.a()
            {
              public final void a(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2, String paramAnonymous2String1, String paramAnonymous2String2)
              {
                AppMethodBeat.i(179910);
                if (paramAnonymous2Boolean1)
                {
                  com.tencent.mm.model.w.u(z.this.cOd.zgX);
                  z.2.this.GwF.setVisibility(8);
                }
                AppMethodBeat.o(179910);
              }
            });
            LinkedList localLinkedList = new LinkedList();
            localLinkedList.add(Integer.valueOf(3));
            ((com.tencent.mm.pluginsdk.ui.applet.a)localObject).aBJ(str);
            ((com.tencent.mm.pluginsdk.ui.applet.a)localObject).BXA = true;
            ((com.tencent.mm.pluginsdk.ui.applet.a)localObject).d(z.f(z.this), paramAnonymousView, localLinkedList);
          }
          for (;;)
          {
            h.vKh.f(11004, new Object[] { z.f(z.this), Integer.valueOf(3) });
            AppMethodBeat.o(35370);
            return;
            paramAnonymousView = "";
            break;
            label362:
            str = "";
            break label195;
            label368:
            ar.a.gMW.a(z.f(z.this), paramAnonymousView, new ar.b.a()
            {
              public final void p(String paramAnonymous2String, boolean paramAnonymous2Boolean)
              {
                AppMethodBeat.i(179912);
                com.tencent.mm.pluginsdk.ui.applet.a locala = new com.tencent.mm.pluginsdk.ui.applet.a(z.this.cOd.GzJ.getContext(), new a.a()
                {
                  public final void a(boolean paramAnonymous3Boolean1, boolean paramAnonymous3Boolean2, String paramAnonymous3String1, String paramAnonymous3String2)
                  {
                    AppMethodBeat.i(179911);
                    if (paramAnonymous3Boolean1)
                    {
                      com.tencent.mm.model.w.u(z.this.cOd.zgX);
                      z.2.this.GwF.setVisibility(8);
                    }
                    AppMethodBeat.o(179911);
                  }
                });
                LinkedList localLinkedList = new LinkedList();
                localLinkedList.add(Integer.valueOf(3));
                az.arV();
                paramAnonymous2String = com.tencent.mm.model.c.apM().aHY(z.f(z.this));
                if (paramAnonymous2String != null) {}
                for (paramAnonymous2String = bt.by(paramAnonymous2String.evP, "");; paramAnonymous2String = "")
                {
                  locala.aBJ(paramAnonymous2String);
                  locala.BXA = true;
                  locala.d(z.f(z.this), paramAnonymousView, localLinkedList);
                  AppMethodBeat.o(179912);
                  return;
                }
              }
            });
          }
        }
      });
      h.vKh.f(11004, new Object[] { this.Gwq, Integer.valueOf(1) });
      AppMethodBeat.o(35414);
      return;
      localLinearLayout = (LinearLayout)this.Gwo.findViewById(2131297975);
      break;
      label319:
      localImageView.setImageBitmap((Bitmap)localObject);
    }
  }
  
  public final int eYb()
  {
    AppMethodBeat.i(35420);
    int j = 0;
    int i = j;
    if (this.Gwn != null)
    {
      i = j;
      if (this.Gwn.isShown()) {
        i = this.Gwn.getHeight() + 0;
      }
    }
    AppMethodBeat.o(35420);
    return i;
  }
  
  public final void fJ(View paramView)
  {
    AppMethodBeat.i(35405);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ChattingUI.HeaderComponent", "dealContentView");
    if (isSupportCustomActionBar())
    {
      if (this.mActionBarContainer == null) {
        this.mActionBarContainer = ((ActionBarContainer)((ViewStub)paramView.findViewById(2131298079)).inflate());
      }
      u localu = this.Gwr;
      paramView = (ViewGroup)paramView;
      localu.FOY.TP = paramView;
    }
    AppMethodBeat.o(35405);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    int j = 1;
    AppMethodBeat.i(35389);
    super.onConfigurationChanged(paramConfiguration);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ChattingUI.HeaderComponent", "getConfiguration().orientation = " + this.cOd.GzJ.getMMResources().getConfiguration().orientation + ", newConfig.orientation = " + paramConfiguration.orientation);
    this.cOd.GzJ.getMMResources().getConfiguration().orientation = paramConfiguration.orientation;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChatFooter", "[dealOrientationChange] %s", new Object[] { ((com.tencent.mm.ui.chatting.c.b.q)this.cOd.be(com.tencent.mm.ui.chatting.c.b.q.class)).eXs().getContext().getResources().getConfiguration() });
    int i;
    if (this.mActionBarContainer != null)
    {
      i = 1;
      if (this.Gwt == null) {
        break label271;
      }
    }
    for (;;)
    {
      if ((i & j) != 0)
      {
        i = com.tencent.mm.compatible.util.a.ca(this.cOd.GzJ.getContext());
        this.Gwt.setMinimumHeight(i);
        ViewGroup.LayoutParams localLayoutParams2 = this.Gwt.getLayoutParams();
        ViewGroup.LayoutParams localLayoutParams1 = localLayoutParams2;
        if (localLayoutParams2 == null) {
          localLayoutParams1 = new ViewGroup.LayoutParams(-1, -1);
        }
        localLayoutParams1.height = i;
        this.Gwt.setLayoutParams(localLayoutParams1);
        localLayoutParams1 = this.mActionBarContainer.getLayoutParams();
        localLayoutParams1.height = i;
        this.mActionBarContainer.setLayoutParams(localLayoutParams1);
      }
      if (this.Gwr != null) {
        this.Gwr.FOY.mActionBar.onConfigurationChanged(paramConfiguration);
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
    this.Gws.e(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179914);
        if (!z.this.cOd.GzJ.isScreenEnable())
        {
          com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.ChattingUI.HeaderComponent", "Actionbar customView onclick screen not enable");
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
            if (z.3.this.FGX != null) {
              z.3.this.FGX.onMenuItemClick(null);
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
    int i = com.tencent.mm.cd.a.ao(this.cOd.GzJ.getContext(), 2131165466);
    paramString = com.tencent.mm.pluginsdk.ui.span.k.b(this.cOd.GzJ.getContext(), paramString, i);
    this.Gws.ak(paramString);
    AppMethodBeat.o(35422);
  }
  
  public final void setMMTitle(int paramInt)
  {
    AppMethodBeat.i(35402);
    setMMTitle(this.cOd.GzJ.getMMResources().getString(paramInt));
    AppMethodBeat.o(35402);
  }
  
  public final void setMMTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(35421);
    if ((com.tencent.mm.model.w.sn(this.cOd.getTalkerUserName())) || (((f)this.cOd.be(f.class)).eWX()))
    {
      this.Gws.setTitle(paramCharSequence);
      this.cOd.GzJ.updateDescription(this.cOd.GzJ.getContext().getString(2131757133, new Object[] { paramCharSequence }));
      AppMethodBeat.o(35421);
      return;
    }
    if (af.aHH(this.cOd.zgX.field_username))
    {
      paramCharSequence = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).e(com.tencent.mm.sdk.platformtools.aj.getContext(), paramCharSequence.toString(), com.tencent.mm.cd.a.ao(com.tencent.mm.sdk.platformtools.aj.getContext(), 2131165192));
      this.Gws.setTitle(paramCharSequence);
      this.cOd.GzJ.updateDescription(this.cOd.GzJ.getContext().getString(2131757133, new Object[] { paramCharSequence }));
      AppMethodBeat.o(35421);
      return;
    }
    paramCharSequence = com.tencent.mm.pluginsdk.ui.span.k.b(this.cOd.GzJ.getContext(), paramCharSequence, com.tencent.mm.cd.a.ao(this.cOd.GzJ.getContext(), 2131165192));
    this.Gws.setTitle(paramCharSequence);
    this.cOd.GzJ.updateDescription(this.cOd.GzJ.getContext().getString(2131757133, new Object[] { paramCharSequence }));
    AppMethodBeat.o(35421);
  }
  
  public final void setTitleForceNotifyIconVisibility(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(35425);
    Object localObject = this.Gws;
    if (paramInt == 0)
    {
      paramInt = 1;
      localObject = ((com.tencent.mm.ui.a)localObject).FFK;
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
    if ((com.tencent.mm.model.w.ti(this.cOd.getTalkerUserName())) || (com.tencent.mm.model.w.tn(this.cOd.getTalkerUserName())))
    {
      this.Gws.vh(false);
      AppMethodBeat.o(35426);
      return;
    }
    com.tencent.mm.ui.a locala = this.Gws;
    if (paramInt == 0) {
      bool = true;
    }
    locala.vh(bool);
    AppMethodBeat.o(35426);
  }
  
  public final void setTitlePhoneIconVisibility(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(35424);
    Object localObject = this.Gws;
    if (paramInt == 0)
    {
      paramInt = 1;
      localObject = ((com.tencent.mm.ui.a)localObject).FFL;
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
  
  public final void wg(boolean paramBoolean)
  {
    AppMethodBeat.i(35412);
    if (this.cOd == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ChattingUI.HeaderComponent", "[updateBannerStatus] mChattingContext == null!");
      AppMethodBeat.o(35412);
      return;
    }
    if (!this.cOd.eZb()) {
      if ((!com.tencent.mm.model.w.sz(this.cOd.getTalkerUserName())) && (j.aKH(this.cOd.getTalkerUserName())) && (!((aa)this.cOd.be(aa.class)).eYp()))
      {
        this.Gwq = this.cOd.getTalkerUserName();
        eXV();
      }
    }
    for (;;)
    {
      if (paramBoolean)
      {
        eXY();
        eXU();
      }
      AppMethodBeat.o(35412);
      return;
      if (!((com.tencent.mm.ui.chatting.c.b.y)this.cOd.be(com.tencent.mm.ui.chatting.c.b.y.class)).eYk())
      {
        eXW();
        continue;
        eXX();
      }
    }
  }
  
  final class a
    implements com.tencent.mm.plugin.newtips.a.a
  {
    private int FHe;
    public boolean GwN;
    private r.a GwO;
    private View frN;
    private String path;
    
    public a(String paramString, r.a parama)
    {
      AppMethodBeat.i(179923);
      this.frN = new View(z.this.cOd.GzJ.getContext());
      this.GwN = false;
      this.FHe = 0;
      this.path = paramString;
      this.GwO = parama;
      AppMethodBeat.o(179923);
    }
    
    public final void a(com.tencent.mm.plugin.newtips.a.k paramk, boolean paramBoolean)
    {
      AppMethodBeat.i(179924);
      com.tencent.mm.plugin.newtips.a.g.a(this, paramk, paramBoolean);
      AppMethodBeat.o(179924);
    }
    
    public final boolean a(boolean paramBoolean, dcb paramdcb)
    {
      return false;
    }
    
    public final boolean b(boolean paramBoolean, dcb paramdcb)
    {
      return false;
    }
    
    public final boolean c(boolean paramBoolean, dcb paramdcb)
    {
      return false;
    }
    
    public final boolean cND()
    {
      return false;
    }
    
    public final boolean d(boolean paramBoolean, dcb paramdcb)
    {
      return false;
    }
    
    public final String getPath()
    {
      return this.path;
    }
    
    public final View getRoot()
    {
      return this.frN;
    }
    
    public final boolean mY(boolean paramBoolean)
    {
      AppMethodBeat.i(179925);
      paramBoolean = com.tencent.mm.plugin.newtips.a.g.a(paramBoolean, this);
      AppMethodBeat.o(179925);
      return paramBoolean;
    }
    
    public final boolean mZ(boolean paramBoolean)
    {
      AppMethodBeat.i(179926);
      this.GwN = paramBoolean;
      z.this.cOd.GzJ.updateOptionMenuRedDot(this.FHe, paramBoolean);
      AppMethodBeat.o(179926);
      return true;
    }
    
    public final boolean na(boolean paramBoolean)
    {
      return false;
    }
  }
  
  final class b
    extends com.tencent.mm.ui.w
  {
    b() {}
    
    public final void VR()
    {
      AppMethodBeat.i(35387);
      if (com.tencent.mm.model.w.sn(z.this.cOd.getTalkerUserName()))
      {
        localObject1 = new com.tencent.mm.g.b.a.bg();
        ((com.tencent.mm.g.b.a.bg)localObject1).hZ(z.this.cOd.getTalkerUserName());
        ((com.tencent.mm.g.b.a.bg)localObject1).dKc = 4L;
        ((com.tencent.mm.g.b.a.bg)localObject1).aBj();
      }
      if ((z.a(z.this) != null) && (z.a(z.this).GwN)) {
        com.tencent.mm.plugin.newtips.a.cWs().Ip(25);
      }
      if (com.tencent.mm.model.w.sy(z.this.cOd.getTalkerUserName())) {
        h.vKh.f(19540, new Object[] { Integer.valueOf(2) });
      }
      z.this.cOd.hideVKB();
      if (com.tencent.mm.model.w.ti(z.this.cOd.getTalkerUserName()))
      {
        localObject1 = z.this.cOd.GzJ.getContext();
        localObject2 = new Intent(z.this.cOd.GzJ.getContext(), ServiceNotifySettingsUI.class);
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).adn(), "com/tencent/mm/ui/chatting/component/HeaderComponent$OptionListener", "onRealClick", "(Landroid/view/MenuItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((Activity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/chatting/component/HeaderComponent$OptionListener", "onRealClick", "(Landroid/view/MenuItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(35387);
        return;
      }
      if (com.tencent.mm.model.w.tn(z.this.cOd.getTalkerUserName()))
      {
        localObject1 = z.this.cOd.GzJ.getContext();
        localObject2 = new Intent(z.this.cOd.GzJ.getContext(), AppBrandNotifySettingsUI.class);
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).adn(), "com/tencent/mm/ui/chatting/component/HeaderComponent$OptionListener", "onRealClick", "(Landroid/view/MenuItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((Activity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/chatting/component/HeaderComponent$OptionListener", "onRealClick", "(Landroid/view/MenuItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        h.vKh.f(19724, new Object[] { Integer.valueOf(1), Integer.valueOf(6), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null, null, null, Integer.valueOf(0), null, null, Integer.valueOf(0), null, null });
        AppMethodBeat.o(35387);
        return;
      }
      if (com.tencent.mm.model.w.sA(z.this.cOd.getTalkerUserName()))
      {
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("Contact_User", z.this.cOd.getTalkerUserName());
        com.tencent.mm.bs.d.b(z.this.cOd.GzJ.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject1);
        AppMethodBeat.o(35387);
        return;
      }
      if (((com.tencent.mm.ui.chatting.c.b.y)z.this.cOd.be(com.tencent.mm.ui.chatting.c.b.y.class)).eYj())
      {
        z.b(z.this);
        AppMethodBeat.o(35387);
        return;
      }
      if (((com.tencent.mm.ui.chatting.c.b.d)z.this.cOd.be(com.tencent.mm.ui.chatting.c.b.d.class)).eWN())
      {
        AppMethodBeat.o(35387);
        return;
      }
      Object localObject2 = new Intent();
      ((Intent)localObject2).setClass(z.this.cOd.GzJ.getContext(), SingleChatInfoUI.class);
      ((Intent)localObject2).putExtra("Single_Chat_Talker", z.this.cOd.getTalkerUserName());
      ((Intent)localObject2).putExtra("fromChatting", true);
      Object localObject1 = z.this.cOd.GzJ;
      localObject2 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject2);
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).adn(), "com/tencent/mm/ui/chatting/component/HeaderComponent$OptionListener", "onRealClick", "(Landroid/view/MenuItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((MMFragment)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/chatting/component/HeaderComponent$OptionListener", "onRealClick", "(Landroid/view/MenuItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(35387);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.z
 * JD-Core Version:    0.7.0.1
 */