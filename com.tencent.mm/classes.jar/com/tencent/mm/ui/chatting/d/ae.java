package com.tencent.mm.ui.chatting.d;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
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
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBar.LayoutParams;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ActionBarContainer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.am.f.a;
import com.tencent.mm.am.q;
import com.tencent.mm.chatroom.ui.RoomCardUI;
import com.tencent.mm.f.a.aaq;
import com.tencent.mm.f.b.a.iv;
import com.tencent.mm.f.b.a.nf;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.model.b.b.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.appbrand.config.y;
import com.tencent.mm.plugin.finder.utils.r;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.plugin.newtips.PluginNewTips.a;
import com.tencent.mm.plugin.newtips.a.k;
import com.tencent.mm.plugin.textstatus.a.a.b;
import com.tencent.mm.plugin.textstatus.a.a.c;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.aym;
import com.tencent.mm.protocal.protobuf.erx;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.cf;
import com.tencent.mm.ui.AppBrandNotifySettingsUI;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.SingleChatInfoUI;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.b.1;
import com.tencent.mm.ui.b.2;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.ac;
import com.tencent.mm.ui.chatting.d.b.ai;
import com.tencent.mm.ui.chatting.d.b.an;
import com.tencent.mm.ui.chatting.d.b.at;
import com.tencent.mm.ui.chatting.d.b.s;
import com.tencent.mm.ui.chatting.d.b.u;
import com.tencent.mm.ui.conversation.ServiceNotifyConversationUI;
import com.tencent.mm.ui.f.e;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.w.a;
import com.tencent.mm.ui.w.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.chatting.d.a.a(hRc=com.tencent.mm.ui.chatting.d.b.aa.class)
public class ae
  extends a
  implements com.tencent.mm.ui.chatting.d.b.aa
{
  private int JpE;
  private final MStorage.IOnStorageChange WHt;
  private boolean WHy;
  protected LinearLayout WLL;
  protected LinearLayout WLM;
  protected LinearLayout WLN;
  private List<String> WLO;
  private String WLP;
  public com.tencent.mm.ui.z WLQ;
  private com.tencent.mm.ui.b WLR;
  private View WLS;
  private a WLT;
  final com.tencent.mm.ui.ab WLU;
  private com.tencent.mm.model.b.b.a WLV;
  private Runnable WLW;
  private final f.a WLX;
  private View.OnClickListener WLY;
  final int WLZ;
  final int WMa;
  final MenuItem.OnMenuItemClickListener WMb;
  private nf WMc;
  private View WMd;
  private View WMe;
  private MenuItem.OnMenuItemClickListener backListener;
  private ActionBarContainer mActionBarContainer;
  
  public ae()
  {
    AppMethodBeat.i(35388);
    this.WLO = new LinkedList();
    this.JpE = 0;
    this.mActionBarContainer = null;
    this.WLQ = null;
    this.WHy = false;
    this.WLU = new b();
    this.WLV = new com.tencent.mm.model.b.b.a()
    {
      public final void bgn()
      {
        AppMethodBeat.i(179915);
        com.tencent.mm.ui.chatting.e.a.hRl().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(35371);
            bh.beI().bcm();
            if (com.tencent.mm.model.b.b.a(b.b.lwM))
            {
              ae.c(ae.this);
              AppMethodBeat.o(35371);
              return;
            }
            ae.d(ae.this);
            AppMethodBeat.o(35371);
          }
        });
        AppMethodBeat.o(179915);
      }
    };
    this.WLW = null;
    this.WLX = new f.a()
    {
      public final void TM(final String paramAnonymousString)
      {
        AppMethodBeat.i(179917);
        com.tencent.mm.ui.chatting.e.a.hRl().removeCallbacks(ae.e(ae.this));
        com.tencent.mm.ui.chatting.e.a.hRl().postDelayed(ae.a(ae.this, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(179916);
            if ((!Util.isNullOrNil(ae.f(ae.this))) && (!Util.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals(ae.f(ae.this)))) {
              ae.this.Gm(false);
            }
            AppMethodBeat.o(179916);
          }
        }), 1000L);
        AppMethodBeat.o(179917);
      }
    };
    this.WHt = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(179918);
        Log.v("MicroMsg.ChattingUI.HeaderComponent", "roommember watcher notify ".concat(String.valueOf(paramAnonymousString)));
        if ((ae.this.fgR.hRi()) && (!Util.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals(ae.this.fgR.getTalkerUserName())))
        {
          ae.this.hOL();
          ae.this.hPL();
          ae.g(ae.this);
        }
        AppMethodBeat.o(179918);
      }
    };
    this.WLY = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(277349);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/component/HeaderComponent$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        ((com.tencent.mm.plugin.textstatus.a.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.textstatus.a.d.class)).showCardDialog(ae.this.fgR.WQv.getContext(), ae.this.fgR.NKq.field_username);
        if ((ae.this.fgR != null) && (ae.this.fgR.hRi())) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            ((com.tencent.mm.plugin.textstatus.a.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.textstatus.a.d.class)).report22210(ae.this.fgR.NKq.field_username, 2L);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/HeaderComponent$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(277349);
          return;
        }
      }
    };
    this.backListener = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(179922);
        boolean bool = ae.this.fgR.WQv.hMr();
        AppMethodBeat.o(179922);
        return bool;
      }
    };
    this.WLZ = 1;
    this.WMa = 2;
    this.WMb = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(278957);
        aaq localaaq = new aaq();
        localaaq.fZM.fDn = 5;
        localaaq.fZM.talker = ae.this.fgR.NKq.field_username;
        localaaq.fZM.context = ae.this.fgR.WQv.getContext();
        if (paramAnonymousMenuItem.getItemId() == 1) {
          localaaq.fZM.fZI = 4;
        }
        for (;;)
        {
          EventCenter.instance.publish(localaaq);
          AppMethodBeat.o(278957);
          return true;
          if (paramAnonymousMenuItem.getItemId() == 2) {
            localaaq.fZM.fZI = 2;
          }
        }
      }
    };
    this.WMc = null;
    this.WMd = null;
    this.WMe = null;
    AppMethodBeat.o(35388);
  }
  
  private View X(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(35406);
    int i = R.i.actionbar_custom_area_center;
    if (this.WLS == null)
    {
      if (paramViewGroup == null) {}
      for (this.WLS = ad.kS(this.fgR.WQv.getContext()).inflate(i, null);; this.WLS = ad.kS(this.fgR.WQv.getContext()).inflate(i, paramViewGroup, false))
      {
        paramViewGroup = this.WLS;
        AppMethodBeat.o(35406);
        return paramViewGroup;
      }
    }
    if (this.WLS.getParent() == null)
    {
      paramViewGroup = this.WLS;
      AppMethodBeat.o(35406);
      return paramViewGroup;
    }
    if ((this.WLS.getParent() instanceof ViewGroup))
    {
      ((ViewGroup)this.WLS.getParent()).removeView(this.WLS);
      paramViewGroup = this.WLS;
      AppMethodBeat.o(35406);
      return paramViewGroup;
    }
    if (paramViewGroup == null) {}
    for (this.WLS = ad.kS(this.fgR.WQv.getContext()).inflate(i, null);; this.WLS = ad.kS(this.fgR.WQv.getContext()).inflate(i, paramViewGroup, false))
    {
      paramViewGroup = this.WLS;
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
    w.a locala = this.fgR.WQv.findMenuInfo(0);
    if (Util.isNullOrNil(paramString))
    {
      if (locala == null)
      {
        this.fgR.WQv.addIconOptionMenu(0, paramInt1, paramInt2, paramOnMenuItemClickListener);
        AppMethodBeat.o(179927);
        return;
      }
      this.fgR.WQv.updateOptionMenu(0, paramInt1, paramInt2, paramOnMenuItemClickListener);
      AppMethodBeat.o(179927);
      return;
    }
    if (locala == null) {
      this.fgR.WQv.addIconOptionMenu(0, paramInt1, paramInt2, paramOnMenuItemClickListener);
    }
    for (paramOnMenuItemClickListener = this.fgR.WQv.findMenuInfo(0); paramOnMenuItemClickListener == null; paramOnMenuItemClickListener = locala)
    {
      Log.e("MicroMsg.ChattingUI.HeaderComponent", "updateMenuInfo menuInfo == null");
      AppMethodBeat.o(179927);
      return;
      this.fgR.WQv.updateOptionMenu(0, paramInt1, paramInt2, paramOnMenuItemClickListener);
    }
    this.WLT = new a(0, paramString, paramOnMenuItemClickListener);
    com.tencent.mm.plugin.newtips.a.fiO().h(this.WLT);
    com.tencent.mm.plugin.newtips.a.g.a(this.WLT);
    if (paramOnMenuItemClickListener.gbE) {
      com.tencent.mm.plugin.newtips.a.g.a(this.WLT, k.GwK, true);
    }
    AppMethodBeat.o(179927);
  }
  
  private void a(ActionBar paramActionBar)
  {
    AppMethodBeat.i(272210);
    boolean bool = ar.isDarkMode();
    if (paramActionBar.getCustomView() != null)
    {
      Object localObject = (ImageView)paramActionBar.getCustomView().findViewById(R.h.arrow_area_btn);
      if ((localObject != null) && (bool))
      {
        if (((ImageView)localObject).getDrawable() != null) {
          ((ImageView)localObject).getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
        }
      }
      else
      {
        localObject = (TextView)paramActionBar.getCustomView().findViewById(R.h.title_area);
        if (localObject != null)
        {
          ar.a(((TextView)localObject).getPaint(), 0.8F);
          if (bool) {
            ((TextView)localObject).setTextColor(this.fgR.WQv.getMMResources().getColor(R.e.actionbar_title_light_color));
          }
        }
        localObject = (TextView)paramActionBar.getCustomView().findViewById(R.h.sub_title_area);
        if ((localObject != null) && (bool)) {
          ((TextView)localObject).setTextColor(this.fgR.WQv.getMMResources().getColor(R.e.actionbar_title_light_color));
        }
        localObject = (ImageView)paramActionBar.getCustomView().findViewById(R.h.mute_icon);
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
        paramActionBar = (ImageView)paramActionBar.getCustomView().findViewById(R.h.phone_icon);
        if ((paramActionBar == null) || (!bool)) {
          break label268;
        }
        if (paramActionBar.getDrawable() == null) {
          break label260;
        }
        paramActionBar.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
        AppMethodBeat.o(272210);
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
    AppMethodBeat.o(272210);
  }
  
  private void a(String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, w.b paramb)
  {
    AppMethodBeat.i(272212);
    w.a locala2 = this.fgR.WQv.findMenuInfo(0);
    w.a locala1 = locala2;
    if (locala2 != null) {
      if (locala2.VRi == 0)
      {
        locala1 = locala2;
        if (locala2.Wal == null) {}
      }
      else
      {
        this.fgR.WQv.removeOptionMenu(0);
        locala1 = null;
      }
    }
    if (locala1 == null)
    {
      this.fgR.WQv.addTextOptionMenu(0, paramString, paramOnMenuItemClickListener, null, paramb);
      AppMethodBeat.o(272212);
      return;
    }
    this.fgR.WQv.updateOptionMenuText(0, paramString);
    AppMethodBeat.o(272212);
  }
  
  private String aB(as paramas)
  {
    AppMethodBeat.i(35403);
    if (paramas == null)
    {
      paramas = this.fgR.WQv.getContext().getString(R.l.etv);
      AppMethodBeat.o(35403);
      return paramas;
    }
    if (RegionCodeDecoder.bxn(paramas.getCountryCode()))
    {
      String str = paramas.getCity();
      if (!Util.isNullOrNil(str))
      {
        AppMethodBeat.o(35403);
        return str;
      }
      str = com.tencent.mm.model.aa.PL(paramas.getProvince());
      if (!Util.isNullOrNil(str))
      {
        AppMethodBeat.o(35403);
        return str;
      }
      RegionCodeDecoder.hAC();
      paramas = RegionCodeDecoder.getLocName(paramas.getCountryCode());
      AppMethodBeat.o(35403);
      return paramas;
    }
    paramas = com.tencent.mm.model.aa.PL(paramas.getProvince());
    if (!Util.isNullOrNil(paramas))
    {
      AppMethodBeat.o(35403);
      return paramas;
    }
    paramas = this.fgR.WQv.getContext().getString(R.l.etv);
    AppMethodBeat.o(35403);
    return paramas;
  }
  
  private void doResume()
  {
    AppMethodBeat.i(35399);
    if ((com.tencent.mm.model.ab.Qb(this.fgR.getTalkerUserName())) || (com.tencent.mm.model.ab.Qc(this.fgR.getTalkerUserName())) || (com.tencent.mm.model.ab.Qd(this.fgR.getTalkerUserName())) || (com.tencent.mm.model.ab.Qe(this.fgR.getTalkerUserName())) || ((1 == ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.waa, 0)) && (com.tencent.mm.model.ab.Qf(this.fgR.getTalkerUserName()))))
    {
      com.tencent.mm.plugin.newtips.a.fiR();
      boolean bool = com.tencent.mm.plugin.newtips.a.e.aal(com.tencent.mm.plugin.newtips.a.d.Gwh);
      this.fgR.WQv.addIconOptionMenu(0, R.l.actionbar_title_setting, R.k.actionbar_setting_icon, Boolean.valueOf(bool).booleanValue(), this.WLU);
    }
    AppMethodBeat.o(35399);
  }
  
  private void hPG()
  {
    AppMethodBeat.i(35400);
    if (com.tencent.mm.kernel.h.aHE().aGM())
    {
      q.bhz().b(this.WLX);
      bh.beI();
      com.tencent.mm.model.c.bbV().remove(this.WHt);
    }
    com.tencent.mm.ui.chatting.e.a.hRl().removeCallbacks(this.WLW);
    v.bcS();
    if (this.WLT != null)
    {
      com.tencent.mm.plugin.newtips.a.fiO();
      com.tencent.mm.plugin.newtips.a.i.i(this.WLT);
    }
    AppMethodBeat.o(35400);
  }
  
  private void hPH()
  {
    AppMethodBeat.i(272207);
    Log.i("MicroMsg.ChattingUI.HeaderComponent", "resetUserLevelTitle!");
    this.WLR.hFp();
    AppMethodBeat.o(272207);
  }
  
  private void hPI()
  {
    AppMethodBeat.i(272208);
    View localView = this.fgR.WQv.findViewById(R.h.title_area_container);
    if (localView != null) {
      localView.setOnClickListener(this.WLY);
    }
    AppMethodBeat.o(272208);
  }
  
  private void hPK()
  {
    AppMethodBeat.i(35409);
    this.WLO.clear();
    this.WLO.add(this.fgR.WQv.getStringExtra("Chat_User"));
    AppMethodBeat.o(35409);
  }
  
  private void hPM()
  {
    AppMethodBeat.i(35413);
    if (this.fgR.WQv.getContext() == null)
    {
      Log.w("MicroMsg.ChattingUI.HeaderComponent", "getActivity is null");
      AppMethodBeat.o(35413);
      return;
    }
    hPU();
    ViewGroup localViewGroup = (ViewGroup)this.fgR.WQv.getContext().findViewById(R.h.dwV);
    com.tencent.mm.pluginsdk.ui.b.a locala = com.tencent.mm.ui.conversation.a.e.a(this.fgR.WQv.getContext(), com.tencent.mm.ui.conversation.a.e.a.XFe, new Object[] { b.b.lwM });
    if ((localViewGroup != null) && (locala != null) && (locala.getView() != null) && (this.WMe == null))
    {
      this.WMe = locala.getView();
      localViewGroup.addView(this.WMe, new ViewGroup.LayoutParams(-1, -2));
    }
    AppMethodBeat.o(35413);
  }
  
  private void hPO()
  {
    int i = 0;
    AppMethodBeat.i(272214);
    Object localObject1 = (at)this.fgR.bC(at.class);
    if ((((at)localObject1).hQG()) || (((at)localObject1).hQF()) || (((at)localObject1).hQE()))
    {
      AppMethodBeat.o(272214);
      return;
    }
    Object localObject2 = this.fgR.NKq.field_username;
    localObject1 = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().Rw((String)localObject2);
    if ((this.fgR.WQv.hasDestory) || (localObject1 == null) || (((ah)localObject1).field_chatroomNoticeNew != 1))
    {
      hPR();
      AppMethodBeat.o(272214);
      return;
    }
    if (this.WLL != null) {
      hPR();
    }
    if (this.WLN == null)
    {
      m.a(this.fgR.WQv, R.h.dZn);
      this.WLN = ((LinearLayout)this.fgR.WQv.getContext().findViewById(R.h.dHd));
    }
    this.WLN.removeAllViews();
    LinearLayout localLinearLayout = (LinearLayout)this.fgR.WQv.getContext().getLayoutInflater().inflate(R.i.eeA, null);
    this.WLN.addView(localLinearLayout, new ViewGroup.LayoutParams(-1, -2));
    String str = ((ah)localObject1).field_chatroomnotice;
    if (!Util.isNullOrNil(str)) {
      ((TextView)localLinearLayout.findViewById(R.h.dqf)).setText(str);
    }
    final boolean bool1;
    final boolean bool2;
    if (Util.isNullOrNil(((ah)localObject1).field_roomowner))
    {
      bool1 = false;
      bool2 = ((ah)localObject1).bvA(com.tencent.mm.model.z.bcZ());
      localLinearLayout.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(279978);
          Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/component/HeaderComponent$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
          Object localObject2 = new Intent();
          ((Intent)localObject2).setClass(ae.this.fgR.WQv.getContext(), RoomCardUI.class);
          ((Intent)localObject2).putExtra("RoomInfo_Id", this.iWN);
          ((Intent)localObject2).putExtra("room_notice", v.Pw(this.iWN));
          ((Intent)localObject2).putExtra("room_notice_publish_time", v.Pz(this.iWN));
          ((Intent)localObject2).putExtra("room_notice_editor", v.Py(this.iWN));
          ((Intent)localObject2).putExtra("from_scene", 2);
          paramAnonymousView = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().Rw(this.iWN);
          if (paramAnonymousView != null)
          {
            ((Intent)localObject2).putExtra("Is_RoomOwner", bool1);
            ((Intent)localObject2).putExtra("Is_RoomManager", bool2);
          }
          ((Intent)localObject2).putExtra("room_member_count", paramAnonymousView.field_memberCount);
          localObject1 = ae.this.fgR.WQv.getContext();
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
          com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/ui/chatting/component/HeaderComponent$13", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Activity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/ui/chatting/component/HeaderComponent$13", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localObject1 = new nf().DZ(this.iWN);
          ((nf)localObject1).ggi = paramAnonymousView.field_memberCount;
          long l;
          if (bool1)
          {
            l = 1L;
            ((nf)localObject1).ggh = l;
            paramAnonymousView = ((nf)localObject1).Ea(paramAnonymousView.field_chatroomnoticePublishTime);
            paramAnonymousView.gef = 23L;
            paramAnonymousView.bpa();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/HeaderComponent$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(279978);
            return;
          }
          if (bool2) {}
          for (int i = 2;; i = 0)
          {
            l = i;
            break;
          }
        }
      });
      this.WLN.setVisibility(0);
      localLinearLayout.setVisibility(0);
      this.WMc = new nf();
      localObject2 = this.WMc.DZ((String)localObject2);
      ((nf)localObject2).ggi = ((ah)localObject1).field_memberCount;
      if (!bool1) {
        break label421;
      }
    }
    for (long l = 1L;; l = i)
    {
      ((nf)localObject2).ggh = l;
      ((nf)localObject2).Ea(((ah)localObject1).field_chatroomnoticePublishTime).gef = 22L;
      AppMethodBeat.o(272214);
      return;
      bool1 = ((ah)localObject1).field_roomowner.equals(com.tencent.mm.model.z.bcZ());
      break;
      label421:
      if (bool2) {
        i = 2;
      }
    }
  }
  
  private void hPQ()
  {
    AppMethodBeat.i(35415);
    if ((this.fgR.hRi()) || (this.WLL == null))
    {
      hPR();
      AppMethodBeat.o(35415);
      return;
    }
    hPR();
    com.tencent.mm.pluginsdk.ui.b.a locala2;
    if (this.WLL.getTag() == null)
    {
      locala2 = com.tencent.mm.ui.conversation.a.e.a(this.fgR.WQv.getContext(), com.tencent.mm.ui.conversation.a.e.a.XES, new Object[] { this.fgR.getTalkerUserName(), this.fgR.hOp() });
      locala1 = locala2;
      if (locala2 != null)
      {
        locala1 = locala2;
        if (locala2.getView() != null) {
          this.WLL.addView(locala2.getView(), new ViewGroup.LayoutParams(-1, -2));
        }
      }
    }
    for (com.tencent.mm.pluginsdk.ui.b.a locala1 = locala2;; locala1 = (com.tencent.mm.pluginsdk.ui.b.a)this.WLL.getTag())
    {
      if (locala1 != null)
      {
        this.WLL.setVisibility(0);
        this.WLL.setTag(locala1);
      }
      com.tencent.mm.plugin.report.service.h.IzE.a(11003, new Object[] { this.fgR.getTalkerUserName(), Integer.valueOf(1), Integer.valueOf(0) });
      AppMethodBeat.o(35415);
      return;
    }
  }
  
  private void hPR()
  {
    AppMethodBeat.i(35416);
    this.WLL.setVisibility(8);
    if (this.WLN != null) {
      this.WLN.setVisibility(8);
    }
    AppMethodBeat.o(35416);
  }
  
  private void hPS()
  {
    AppMethodBeat.i(35417);
    if (this.fgR.WQv.getContext() == null)
    {
      Log.w("MicroMsg.ChattingUI.HeaderComponent", "getActivity is null");
      AppMethodBeat.o(35417);
      return;
    }
    hPT();
    ViewGroup localViewGroup = (ViewGroup)this.fgR.WQv.getContext().findViewById(R.h.dxb);
    com.tencent.mm.pluginsdk.ui.b.a locala = com.tencent.mm.ui.conversation.a.e.a(this.fgR.WQv.getContext(), com.tencent.mm.ui.conversation.a.e.a.XET, new Object[] { this.fgR.getTalkerUserName(), this.fgR.hOp(), Boolean.valueOf(this.fgR.hRi()) });
    if ((localViewGroup != null) && (locala != null) && (locala.getView() != null) && (this.WMd == null))
    {
      this.WMd = locala.getView();
      localViewGroup.addView(this.WMd, new ViewGroup.LayoutParams(-1, -2));
    }
    AppMethodBeat.o(35417);
  }
  
  private void hPT()
  {
    AppMethodBeat.i(35418);
    ViewGroup localViewGroup = (ViewGroup)this.fgR.WQv.getContext().findViewById(R.h.dxb);
    if ((localViewGroup != null) && (this.WMd != null))
    {
      localViewGroup.removeView(this.WMd);
      this.WMd = null;
    }
    AppMethodBeat.o(35418);
  }
  
  private void hPU()
  {
    AppMethodBeat.i(35419);
    ViewGroup localViewGroup = (ViewGroup)this.fgR.WQv.getContext().findViewById(R.h.dwV);
    if ((localViewGroup != null) && (this.WMe != null))
    {
      localViewGroup.removeView(this.WMe);
      this.WMe = null;
    }
    AppMethodBeat.o(35419);
  }
  
  private boolean isSupportCustomActionBar()
  {
    AppMethodBeat.i(35404);
    boolean bool = this.fgR.WQv.isSupportNavigationSwipeBack();
    AppMethodBeat.o(35404);
    return bool;
  }
  
  public final void Gm(boolean paramBoolean)
  {
    AppMethodBeat.i(35412);
    if (this.fgR == null)
    {
      Log.e("MicroMsg.ChattingUI.HeaderComponent", "[updateBannerStatus] mChattingContext == null!");
      AppMethodBeat.o(35412);
      return;
    }
    if (!this.fgR.hRi()) {
      if ((!com.tencent.mm.model.ab.Qg(this.fgR.getTalkerUserName())) && (m.bvT(this.fgR.getTalkerUserName())) && (!((com.tencent.mm.ui.chatting.d.b.ae)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.ae.class)).hQj()))
      {
        this.WLP = this.fgR.getTalkerUserName();
        hPN();
      }
    }
    for (;;)
    {
      if (paramBoolean)
      {
        hPS();
        hPM();
      }
      AppMethodBeat.o(35412);
      return;
      if ((!((ac)this.fgR.bC(ac.class)).hOY()) && (!((com.tencent.mm.ui.chatting.d.b.o)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.o.class)).hOY()))
      {
        hPQ();
        continue;
        hPR();
        hPO();
      }
    }
  }
  
  public final void a(com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(35390);
    super.a(parama);
    if (isSupportCustomActionBar())
    {
      this.WLQ = new com.tencent.mm.ui.z();
      parama = this.WLQ;
      BaseChattingUIFragment localBaseChattingUIFragment = this.fgR.WQv;
      parama.WaN = localBaseChattingUIFragment;
      parama.WaO = new com.tencent.mm.ui.b.b(localBaseChattingUIFragment.thisActivity(), parama);
      this.fgR.WQv.setActivityController(this.WLQ);
    }
    AppMethodBeat.o(35390);
  }
  
  public final void a(boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(272218);
    com.tencent.mm.ui.b localb = this.WLR;
    int i;
    if (!paramBoolean)
    {
      localb.VPK.setVisibility(0);
      i = localb.mNb.getCurrentTextColor();
      localb.VPK.setIconColor(i);
      localb.VPJ.setOnClickListener(paramOnClickListener);
      p.E(localb.VPJ, 0.7F);
      localb.VPN.setVisibility(8);
      localb.VPM.setOnClickListener(null);
      p.iG(localb.VPM);
    }
    for (;;)
    {
      Log.d("MicroMsg.ActionBarCustomArea", "fixWhenTitleTooLong, forSubTitle: ".concat(String.valueOf(paramBoolean)));
      if (paramBoolean) {
        break;
      }
      localb.mNb.post(new b.1(localb));
      AppMethodBeat.o(272218);
      return;
      localb.VPN.setVisibility(0);
      i = localb.VPL.getCurrentTextColor();
      localb.VPN.setIconColor(i);
      localb.VPM.setOnClickListener(paramOnClickListener);
      p.E(localb.VPM, 0.7F);
      localb.VPK.setVisibility(8);
      localb.VPJ.setOnClickListener(null);
      p.iG(localb.VPJ);
    }
    localb.mNb.post(new b.2(localb));
    AppMethodBeat.o(272218);
  }
  
  public final void avC(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(35427);
    Object localObject = this.WLR;
    if (paramInt == 0)
    {
      paramInt = 1;
      localObject = ((com.tencent.mm.ui.b)localObject).VPQ;
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
  
  public final void bzm(String paramString)
  {
    AppMethodBeat.i(272206);
    Log.i("MicroMsg.ChattingUI.HeaderComponent", "#setUserLevelTitle username=".concat(String.valueOf(paramString)));
    paramString = ((com.tencent.mm.plugin.findersdk.a.m)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.findersdk.a.m.class)).aEv(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(272206);
      return;
    }
    if (!(paramString instanceof com.tencent.mm.plugin.finder.api.i))
    {
      AppMethodBeat.o(272206);
      return;
    }
    paramString = (com.tencent.mm.plugin.finder.api.i)paramString;
    if ((paramString.field_badgeInfoList != null) && (paramString.field_badgeInfoList.SKD != null) && (paramString.field_badgeInfoList.SKD.size() != 0))
    {
      Object localObject = r.ADK;
      paramString = r.c(paramString.field_badgeInfoList.SKD, 0, 0, 0);
      if (!paramString.isEmpty())
      {
        localObject = new SpannableString("  ");
        ((SpannableString)localObject).setSpan(paramString.get(0), 0, 1, 33);
        this.WLR.VPH.setText((CharSequence)localObject);
        Log.i("MicroMsg.ActionBarCustomArea", "#setUserLevel span=".concat(String.valueOf(localObject)));
      }
    }
    AppMethodBeat.o(272206);
  }
  
  public final void hGU()
  {
    AppMethodBeat.i(35391);
    hPJ();
    AppMethodBeat.o(35391);
  }
  
  public final void hGV()
  {
    AppMethodBeat.i(35392);
    this.JpE = this.fgR.WQv.getIntExtra("add_scene", 0);
    q.bhz().a(this.WLX);
    bh.beI();
    com.tencent.mm.model.c.bbV().add(this.WHt);
    setBackBtn(this.backListener);
    doResume();
    hOL();
    hPL();
    hPR();
    this.WHy = true;
    v.a(this.fgR.getTalkerUserName(), new PluginNewTips.a()
    {
      public final void fiS()
      {
        AppMethodBeat.i(179909);
        Log.i("MicroMsg.ChattingUI.HeaderComponent", "onCallback");
        ae.this.hPL();
        AppMethodBeat.o(179909);
      }
    });
    AppMethodBeat.o(35392);
  }
  
  public final void hGW()
  {
    AppMethodBeat.i(35393);
    Gm(true);
    AppMethodBeat.o(35393);
  }
  
  public final void hGX()
  {
    AppMethodBeat.i(35394);
    bh.beI().bck().a(new com.tencent.mm.model.b.e.a()
    {
      public final void bgo()
      {
        AppMethodBeat.i(35378);
        com.tencent.mm.ui.chatting.e.a.hRl().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(35377);
            ae.h(ae.this);
            AppMethodBeat.o(35377);
          }
        });
        AppMethodBeat.o(35378);
      }
      
      public final void bgp()
      {
        AppMethodBeat.i(35379);
        ae.i(ae.this);
        AppMethodBeat.o(35379);
      }
    });
    bh.beI().bcl().a(new com.tencent.mm.model.b.e.a()
    {
      public final void bgo()
      {
        AppMethodBeat.i(179920);
        com.tencent.mm.ui.chatting.e.a.hRl().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(179919);
            ae.j(ae.this);
            AppMethodBeat.o(179919);
          }
        });
        AppMethodBeat.o(179920);
      }
      
      public final void bgp()
      {
        AppMethodBeat.i(179921);
        ae.k(ae.this);
        AppMethodBeat.o(179921);
      }
    });
    com.tencent.mm.model.b.b localb = bh.beI().bcm();
    com.tencent.mm.model.b.b.a locala = this.WLV;
    try
    {
      localb.mListeners.add(locala);
      if (!this.WHy) {
        doResume();
      }
      this.WHy = false;
      AppMethodBeat.o(35394);
      return;
    }
    finally
    {
      AppMethodBeat.o(35394);
    }
  }
  
  public final void hGY()
  {
    AppMethodBeat.i(35395);
    if (com.tencent.mm.kernel.h.aHE().aGM())
    {
      bh.beI().bck().a(null);
      bh.beI().bcl().a(null);
      com.tencent.mm.model.b.b localb = bh.beI().bcm();
      com.tencent.mm.model.b.b.a locala = this.WLV;
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
  
  public final void hGZ()
  {
    AppMethodBeat.i(35396);
    hPG();
    AppMethodBeat.o(35396);
  }
  
  public final void hHa()
  {
    AppMethodBeat.i(272205);
    super.hHa();
    if ((this.fgR.hRi()) && (this.WLN != null) && (this.WLN.getVisibility() == 0)) {
      v.PA(this.fgR.NKq.field_username);
    }
    if (this.WMc != null)
    {
      this.WMc.bpa();
      this.WMc = null;
    }
    AppMethodBeat.o(272205);
  }
  
  public final com.tencent.mm.ui.z hMp()
  {
    return this.WLQ;
  }
  
  public final void hN(View paramView)
  {
    AppMethodBeat.i(35405);
    Log.d("MicroMsg.ChattingUI.HeaderComponent", "dealContentView");
    if (isSupportCustomActionBar())
    {
      if (this.mActionBarContainer == null) {
        this.mActionBarContainer = ((ActionBarContainer)((ViewStub)paramView.findViewById(R.h.dxj)).inflate());
      }
      com.tencent.mm.ui.z localz = this.WLQ;
      paramView = (ViewGroup)paramView;
      localz.WaO.Rx = paramView;
    }
    AppMethodBeat.o(35405);
  }
  
  public final void hNZ()
  {
    AppMethodBeat.i(35397);
    super.hNZ();
    hPG();
    AppMethodBeat.o(35397);
  }
  
  public final void hOL()
  {
    AppMethodBeat.i(35401);
    hPH();
    this.fgR.WQv.setMMSubTitle(null);
    if (((ai)this.fgR.bC(ai.class)).hQk())
    {
      setMMTitle("");
      AppMethodBeat.o(35401);
      return;
    }
    if (com.tencent.mm.model.ab.Qb(this.fgR.getTalkerUserName()))
    {
      setMMTitle(this.fgR.NKq.ayr());
      AppMethodBeat.o(35401);
      return;
    }
    if (((an)this.fgR.bC(an.class)).hQx())
    {
      setMMTitle(R.l.eRN);
      AppMethodBeat.o(35401);
      return;
    }
    if (as.bvH(this.fgR.getTalkerUserName()))
    {
      ((u)this.fgR.bC(u.class)).hPj().setWordCountLimit(140);
      setMMTitle(this.fgR.NKq.ays());
      AppMethodBeat.o(35401);
      return;
    }
    if (com.tencent.mm.model.ab.QS(this.fgR.getTalkerUserName()))
    {
      if (((com.tencent.mm.ui.chatting.d.b.o)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.o.class)).hOZ())
      {
        setMMTitle(this.fgR.WQv.getContext().getString(R.l.eOE));
        AppMethodBeat.o(35401);
        return;
      }
      setMMTitle(this.fgR.NKq.ayr());
      AppMethodBeat.o(35401);
      return;
    }
    if (as.PY(this.fgR.getTalkerUserName()))
    {
      setMMTitle(this.fgR.WQv.getContext().getString(R.l.etp, new Object[] { aB(this.fgR.NKq) }).trim());
      AppMethodBeat.o(35401);
      return;
    }
    if (as.OS(this.fgR.getTalkerUserName()))
    {
      if (this.fgR.bC(com.tencent.mm.ui.chatting.d.b.a.class) != null)
      {
        ((com.tencent.mm.ui.chatting.d.b.a)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.a.class)).hOL();
        AppMethodBeat.o(35401);
      }
    }
    else
    {
      if (this.fgR.hRh())
      {
        boolean bool = ((com.tencent.mm.ui.chatting.d.b.f)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.f.class)).hOA();
        String str = this.fgR.NKq.field_conRemark;
        if (Util.isNullOrNil(str))
        {
          str = this.fgR.NKq.field_nickname;
          if (!Util.isNullOrNil(str)) {
            break label659;
          }
          if (v.Pu(this.fgR.getTalkerUserName()) != 0) {
            break label600;
          }
          str = this.fgR.WQv.getContext().getString(R.l.ewS);
        }
        for (;;)
        {
          Object localObject;
          if (!com.tencent.mm.model.ab.PQ(this.fgR.getTalkerUserName()))
          {
            localObject = str;
            if (!bool) {}
          }
          else
          {
            str = str + " ";
            localObject = l.j(this.fgR.WQv.getContext(), l.d(this.fgR.WQv.getContext(), str, com.tencent.mm.ci.a.aY(this.fgR.WQv.getContext(), R.f.BigTextSize)), R.k.open_im_title_logo);
          }
          setMMTitle((CharSequence)localObject);
          AppMethodBeat.o(35401);
          return;
          setMMSubTitle(l.c(this.fgR.WQv.getContext(), this.fgR.hOp()).toString());
          break;
          label600:
          str = this.fgR.WQv.getContext().getString(R.l.eFv, new Object[] { this.fgR.WQv.getContext().getString(R.l.ewS), Integer.valueOf(v.Pu(this.fgR.getTalkerUserName())) });
          continue;
          label659:
          str = this.fgR.WQv.getContext().getString(R.l.eFv, new Object[] { this.fgR.NKq.ays(), Integer.valueOf(v.Pu(this.fgR.getTalkerUserName())) });
        }
      }
      if (((com.tencent.mm.ui.chatting.d.b.d)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.d.class)).hOg())
      {
        AppMethodBeat.o(35401);
        return;
      }
      if (((com.tencent.mm.ui.chatting.d.b.i)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.i.class)).hOP())
      {
        ((com.tencent.mm.ui.chatting.d.b.i)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.i.class)).hOL();
        AppMethodBeat.o(35401);
        return;
      }
      if (((com.tencent.mm.ui.chatting.d.b.h)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.h.class)).hOK())
      {
        ((com.tencent.mm.ui.chatting.d.b.h)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.h.class)).hOL();
        AppMethodBeat.o(35401);
        return;
      }
      this.WLR.Fh(as.bvJ(this.fgR.getTalkerUserName()));
      this.fgR.WQv.setMMTitle(this.fgR.NKq.ays());
      this.WLR.Fh(as.bvJ(this.fgR.getTalkerUserName()));
      if (as.bvK(this.fgR.getTalkerUserName())) {
        this.fgR.WQv.setMMSubTitle(((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.openim.a.a.class)).bR(this.fgR.NKq.field_openImAppid, this.fgR.NKq.field_descWordingId));
      }
    }
    AppMethodBeat.o(35401);
  }
  
  public final void hPF()
  {
    AppMethodBeat.i(35398);
    if (this.fgR.hMq() > 0) {
      this.WLL = ((LinearLayout)this.fgR.getListView().findViewById(R.h.dLq));
    }
    for (;;)
    {
      if ((((ai)this.fgR.bC(ai.class)).hQk()) && (this.fgR.getListView().getFooterViewsCount() == 0))
      {
        this.WLM = ((LinearLayout)this.fgR.WQv.getContext().getLayoutInflater().inflate(R.i.eey, null));
        this.fgR.getListView().addFooterView(this.WLM);
        if (((ai)this.fgR.bC(ai.class)).hQl())
        {
          int i = com.tencent.mm.kernel.h.aHG().aHp().getInt(ar.a.VDF, 0);
          if (i != 0)
          {
            View localView = this.fgR.getListView().findViewById(R.h.dLp);
            LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
            localLayoutParams.height = i;
            localView.setLayoutParams(localLayoutParams);
          }
        }
      }
      hPR();
      AppMethodBeat.o(35398);
      return;
      this.WLL = ((LinearLayout)this.fgR.WQv.getContext().getLayoutInflater().inflate(R.i.eeB, null));
      this.fgR.dI(this.WLL);
    }
  }
  
  public final void hPJ()
  {
    AppMethodBeat.i(35407);
    if ((this.fgR.WQv.isCurrentActivity) || (!isSupportCustomActionBar()))
    {
      localObject1 = com.tencent.mm.ui.widget.d.c(((AppCompatActivity)this.fgR.WQv.getContext()).getSupportActionBar());
      localObject2 = X(null);
      ((ActionBar)localObject1).setCustomView((View)localObject2);
      this.WLR = new com.tencent.mm.ui.b((View)localObject2);
      a((ActionBar)localObject1);
      this.WLR.Fh(false);
      ((ActionBar)localObject1).O((((ActionBar)localObject1).aC() | 0x10) & 0xFFFFFFFB & 0xFFFFFFFD & 0xFFFFFFF7);
      hPK();
      setBackBtn(this.backListener);
      AppMethodBeat.o(35407);
      return;
    }
    Object localObject1 = (ViewGroup)this.mActionBarContainer.findViewById(R.h.action_bar);
    Log.i("MicroMsg.ChattingUI.HeaderComponent", "mActionBarContainer %s", new Object[] { this.mActionBarContainer });
    Log.i("MicroMsg.ChattingUI.HeaderComponent", "ctxView %s", new Object[] { this.mActionBarContainer.findViewById(R.h.action_context_bar) });
    ((ViewGroup)localObject1).setVisibility(0);
    Object localObject2 = com.tencent.mm.ui.widget.d.c(this.WLQ.getSupportActionBar());
    View localView = X((ViewGroup)localObject1);
    ((ActionBar)localObject2).setCustomView(localView);
    this.WLR = new com.tencent.mm.ui.b(localView);
    int j = ((ActionBar)localObject2).getHeight();
    int i = j;
    if (j == 0)
    {
      localObject1 = this.fgR.WQv.getMMResources().getDisplayMetrics();
      if (((DisplayMetrics)localObject1).widthPixels <= ((DisplayMetrics)localObject1).heightPixels) {
        break label335;
      }
    }
    label335:
    for (i = this.fgR.WQv.getMMResources().getDimensionPixelSize(R.f.DefaultActionbarHeightLand);; i = this.fgR.WQv.getMMResources().getDimensionPixelSize(R.f.DefaultActionbarHeightPort))
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
  
  public final void hPL()
  {
    AppMethodBeat.i(35410);
    Object localObject = (an)this.fgR.bC(an.class);
    if ((((an)localObject).hQx()) || (((an)localObject).hQw()))
    {
      this.fgR.showOptionMenu(false);
      AppMethodBeat.o(35410);
      return;
    }
    if (((s)this.fgR.bC(s.class)).hPi())
    {
      AppMethodBeat.o(35410);
      return;
    }
    if (com.tencent.mm.model.ab.Qg(this.fgR.getTalkerUserName()))
    {
      this.fgR.showOptionMenu(false);
      AppMethodBeat.o(35410);
      return;
    }
    if (((ai)this.fgR.bC(ai.class)).hQk()) {
      a(this.fgR.WQv.getContext().getString(R.l.app_finish), this.WLU, w.b.Wao);
    }
    while (as.PY(this.fgR.getTalkerUserName()))
    {
      this.fgR.Gr(true);
      AppMethodBeat.o(35410);
      return;
      if ((com.tencent.mm.model.ab.Qc(this.fgR.getTalkerUserName())) || (com.tencent.mm.model.ab.Qd(this.fgR.getTalkerUserName())) || (com.tencent.mm.model.ab.Qe(this.fgR.getTalkerUserName())) || ((1 == ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.waa, 0)) && (com.tencent.mm.model.ab.Qf(this.fgR.getTalkerUserName()))))
      {
        a(R.l.actionbar_title_setting, R.k.actionbar_setting_icon, this.WLU);
      }
      else if (com.tencent.mm.model.ab.Qb(this.fgR.getTalkerUserName()))
      {
        com.tencent.mm.plugin.newtips.a.fiR();
        boolean bool = com.tencent.mm.plugin.newtips.a.e.aal(com.tencent.mm.plugin.newtips.a.d.Gwh);
        this.fgR.WQv.addIconOptionMenu(0, R.l.actionbar_title_setting, R.k.actionbar_setting_icon, Boolean.valueOf(bool).booleanValue(), this.WLU);
      }
      else if (com.tencent.mm.model.ab.Qi(this.fgR.getTalkerUserName()))
      {
        a(R.l.actionbar_title_setting, R.k.actionbar_setting_icon, this.WLU);
      }
      else if (com.tencent.mm.model.ab.Qp(this.fgR.getTalkerUserName()))
      {
        a(R.l.actionbar_title_setting, R.k.actionbar_setting_icon, this.WLU);
        com.tencent.mm.plugin.report.service.h.IzE.kvStat(10071, "1");
      }
      else if (com.tencent.mm.model.ab.Qq(this.fgR.getTalkerUserName()))
      {
        a(R.l.actionbar_title_setting, R.k.actionbar_setting_icon, this.WLU);
      }
      else if (com.tencent.mm.model.ab.QQ(this.fgR.getTalkerUserName()))
      {
        if (((com.tencent.mm.ui.chatting.d.b.o)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.o.class)).hOZ())
        {
          this.fgR.showOptionMenu(false);
        }
        else
        {
          bh.beI();
          com.tencent.mm.model.c.getNotifyMessageRecordStorage();
          if (cf.hAw())
          {
            this.fgR.showOptionMenu(false);
            AppMethodBeat.o(35410);
            return;
          }
          a(R.l.actionbar_title_setting, R.k.actionbar_menu_list_icon, this.WLU);
        }
      }
      else if (com.tencent.mm.model.ab.QV(this.fgR.getTalkerUserName()))
      {
        a(R.l.actionbar_title_setting, R.k.actionbar_setting_icon, this.WLU);
      }
      else if (com.tencent.mm.model.ab.QX(this.fgR.getTalkerUserName()))
      {
        if (com.tencent.mm.model.ab.QB(this.fgR.getTalkerUserName()))
        {
          this.fgR.showOptionMenu(false);
          AppMethodBeat.o(35410);
          return;
        }
        a(R.l.actionbar_title_setting, R.k.actionbar_setting_icon, this.WLU);
      }
      else if ((as.bvH(this.fgR.getTalkerUserName())) || (as.bvJ(this.fgR.getTalkerUserName())) || (as.PY(this.fgR.getTalkerUserName())))
      {
        a(R.l.chatting_profile_desc, R.k.actionbar_icon_dark_more, this.WLU);
      }
      else if (as.OS(this.fgR.getTalkerUserName()))
      {
        if (this.fgR.bC(com.tencent.mm.ui.chatting.d.b.a.class) != null) {
          ((com.tencent.mm.ui.chatting.d.b.a)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.a.class)).hRd();
        }
      }
      else if ((((com.tencent.mm.ui.chatting.d.b.ae)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.ae.class)).hQj()) && (m.bvT(this.fgR.getTalkerUserName())))
      {
        a(R.l.chatting_profile_desc, R.k.ofm_add_icon, this.WLU);
      }
      else if ((this.fgR.NKq != null) && (this.fgR.NKq.hxX()) && ((com.tencent.mm.ao.g.Ux(this.fgR.getTalkerUserName())) || (com.tencent.mm.ao.g.Uz(this.fgR.getTalkerUserName()))))
      {
        a(R.l.actionbar_title_setting, R.k.icons_outlined_me, this.WLU);
      }
      else
      {
        ((aj)this.fgR.bC(aj.class)).hQd();
        localObject = (com.tencent.mm.ui.chatting.d.b.d)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.d.class);
        if ((com.tencent.mm.model.ab.PO(this.fgR.getTalkerUserName())) || (((com.tencent.mm.ui.chatting.d.b.d)localObject).hOe()))
        {
          if (((com.tencent.mm.ui.chatting.d.b.f)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.f.class)).hOy())
          {
            Log.i("MicroMsg.ChattingUI.HeaderComponent", "cpan show chatroom right btn");
            if ((((com.tencent.mm.ui.chatting.d.b.f)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.f.class)).hOz()) && (((com.tencent.mm.ui.chatting.d.b.f)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.f.class)).asE()) && (v.bcT())) {
              a(R.l.chatting_profile_desc, R.k.actionbar_icon_dark_more, "chatroom", this.WLU);
            }
            for (;;)
            {
              this.fgR.showOptionMenu(true);
              break;
              a(R.l.chatting_profile_desc, R.k.actionbar_icon_dark_more, this.WLU);
            }
          }
          if ((((com.tencent.mm.ui.chatting.d.b.d)localObject).hOe()) && (!((com.tencent.mm.ui.chatting.d.b.d)localObject).hOf()))
          {
            a(R.l.chatting_profile_desc, R.k.actionbar_particular_icon, this.WLU);
            this.fgR.showOptionMenu(true);
          }
          else
          {
            this.fgR.showOptionMenu(true);
            a(R.l.actionbar_title_setting, R.k.actionbar_icon_dark_more, new com.tencent.mm.ui.ab()
            {
              private int xvk = 1;
              
              public final void atf()
              {
                AppMethodBeat.i(287066);
                com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(ae.this.fgR.WQv.getContext(), 1, true);
                locale.ODT = new q.f()
                {
                  public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramAnonymous2o)
                  {
                    AppMethodBeat.i(275881);
                    paramAnonymous2o.d(ae.2.a(ae.2.this), ae.this.fgR.WQv.getContext().getString(R.l.euL));
                    AppMethodBeat.o(275881);
                  }
                };
                locale.ODU = new q.g()
                {
                  public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(270808);
                    if (paramAnonymous2MenuItem.getItemId() == ae.2.a(ae.2.this))
                    {
                      paramAnonymous2MenuItem = new Intent();
                      paramAnonymous2MenuItem.putExtra("k_username", ae.this.fgR.getTalkerUserName());
                      paramAnonymous2MenuItem.putExtra("showShare", false);
                      paramAnonymous2MenuItem.putExtra("rawUrl", String.format(f.e.VRX, new Object[] { Integer.valueOf(36) }));
                      com.tencent.mm.by.c.b(ae.this.fgR.WQv.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymous2MenuItem);
                    }
                    AppMethodBeat.o(270808);
                  }
                };
                locale.eik();
                AppMethodBeat.o(287066);
              }
            });
            AppMethodBeat.o(35410);
          }
        }
        else
        {
          a(R.l.chatting_profile_desc, R.k.actionbar_icon_dark_more, this.WLU);
        }
      }
    }
    this.fgR.showOptionMenu(true);
    AppMethodBeat.o(35410);
  }
  
  @SuppressLint({"ResourceType"})
  public final void hPN()
  {
    AppMethodBeat.i(35414);
    if (this.fgR.WQv.hasDestory)
    {
      AppMethodBeat.o(35414);
      return;
    }
    hPR();
    if (this.WLN == null)
    {
      m.a(this.fgR.WQv, R.h.dZn);
      this.WLN = ((LinearLayout)this.fgR.WQv.getContext().findViewById(R.h.dHd));
    }
    this.WLN.removeAllViews();
    final LinearLayout localLinearLayout = (LinearLayout)this.fgR.WQv.getContext().getLayoutInflater().inflate(R.i.eez, null);
    this.WLN.addView(localLinearLayout, new ViewGroup.LayoutParams(-1, -2));
    this.WLN.setVisibility(0);
    localLinearLayout.setVisibility(0);
    Util.isNullOrNil(this.WLP);
    Button localButton = (Button)localLinearLayout.findViewById(R.h.dvs);
    if (((ac)this.fgR.bC(ac.class)).hQe()) {
      ((ac)this.fgR.bC(ac.class)).a(localButton, localLinearLayout, this.WLN);
    }
    localLinearLayout.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179914);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/component/HeaderComponent$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        ae.b(ae.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/HeaderComponent$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(179914);
      }
    });
    localButton.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(285514);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/component/HeaderComponent$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
        if (((ac)ae.this.fgR.bC(ac.class)).hQe())
        {
          ((ac)ae.this.fgR.bC(ac.class)).avE(ae.l(ae.this));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/HeaderComponent$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(285514);
          return;
        }
        if ((int)ae.this.fgR.NKq.jxt == 0)
        {
          bh.beI();
          if (com.tencent.mm.model.c.bbL().aw(ae.this.fgR.NKq) != -1) {
            Log.e("MicroMsg.ChattingUI.HeaderComponent", "[insertRetId] successfully! username:%s", new Object[] { ae.this.fgR.NKq });
          }
        }
        if (com.tencent.mm.model.ab.Lj(ae.this.fgR.NKq.field_username))
        {
          paramAnonymousView = ae.this.fgR.NKq.field_username;
          label202:
          bh.beI();
          Object localObject2 = com.tencent.mm.model.c.bbL().RG(ae.f(ae.this));
          if (localObject2 == null) {
            break label400;
          }
          localObject1 = Util.nullAs(((ax)localObject2).hDx, "");
          label236:
          Log.i("MicroMsg.ChattingUI.HeaderComponent", "dkverify banner add:%s chat:%s ticket", new Object[] { ae.f(ae.this), paramAnonymousView, localObject1 });
          if (((!TextUtils.isEmpty(paramAnonymousView)) && (TextUtils.isEmpty((CharSequence)localObject1))) || (as.bvK(((ax)localObject2).field_username))) {
            break label406;
          }
          localObject2 = new com.tencent.mm.pluginsdk.ui.applet.a(ae.this.fgR.WQv.getContext(), new a.a()
          {
            public final void a(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2, String paramAnonymous2String1, String paramAnonymous2String2)
            {
              AppMethodBeat.i(217375);
              if (paramAnonymous2Boolean1)
              {
                com.tencent.mm.model.ab.H(ae.this.fgR.NKq);
                ae.4.this.WMh.setVisibility(8);
              }
              AppMethodBeat.o(217375);
            }
          });
          LinkedList localLinkedList = new LinkedList();
          localLinkedList.add(Integer.valueOf(3));
          ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).bqY((String)localObject1);
          ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).ReN = true;
          ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).d(ae.f(ae.this), paramAnonymousView, localLinkedList);
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.IzE.a(11004, new Object[] { ae.f(ae.this), Integer.valueOf(3) });
          break;
          paramAnonymousView = "";
          break label202;
          label400:
          localObject1 = "";
          break label236;
          label406:
          az.a.ltq.a(ae.f(ae.this), paramAnonymousView, new az.b.a()
          {
            public final void s(String paramAnonymous2String, boolean paramAnonymous2Boolean)
            {
              AppMethodBeat.i(205549);
              com.tencent.mm.pluginsdk.ui.applet.a locala = new com.tencent.mm.pluginsdk.ui.applet.a(ae.this.fgR.WQv.getContext(), new a.a()
              {
                public final void a(boolean paramAnonymous3Boolean1, boolean paramAnonymous3Boolean2, String paramAnonymous3String1, String paramAnonymous3String2)
                {
                  AppMethodBeat.i(290036);
                  if (paramAnonymous3Boolean1)
                  {
                    com.tencent.mm.model.ab.H(ae.this.fgR.NKq);
                    ae.4.this.WMh.setVisibility(8);
                  }
                  AppMethodBeat.o(290036);
                }
              });
              LinkedList localLinkedList = new LinkedList();
              localLinkedList.add(Integer.valueOf(3));
              bh.beI();
              paramAnonymous2String = com.tencent.mm.model.c.bbL().RG(ae.f(ae.this));
              if (paramAnonymous2String != null) {}
              for (paramAnonymous2String = Util.nullAs(paramAnonymous2String.hDx, "");; paramAnonymous2String = "")
              {
                locala.bqY(paramAnonymous2String);
                locala.ReN = true;
                locala.d(ae.f(ae.this), paramAnonymousView, localLinkedList);
                AppMethodBeat.o(205549);
                return;
              }
            }
          });
        }
      }
    });
    com.tencent.mm.plugin.report.service.h.IzE.a(11004, new Object[] { this.WLP, Integer.valueOf(1) });
    AppMethodBeat.o(35414);
  }
  
  public final void hPP()
  {
    AppMethodBeat.i(272215);
    if (this.fgR.WQv.hasDestory)
    {
      AppMethodBeat.o(272215);
      return;
    }
    if (this.WLL != null) {
      hPR();
    }
    if ((this.fgR.WQv.getController() != null) && (this.fgR.WQv.getMMResources() != null)) {
      this.fgR.WQv.getController().setActionbarColor(this.fgR.WQv.getMMResources().getColor(R.e.BG_2));
    }
    Object localObject = ((AppCompatActivity)this.fgR.WQv.getContext()).getSupportActionBar();
    if (localObject != null) {
      ((ActionBar)localObject).e(0.0F);
    }
    if (this.WLN == null)
    {
      m.a(this.fgR.WQv, R.h.dZn);
      this.WLN = ((LinearLayout)this.fgR.WQv.getContext().findViewById(R.h.dHd));
    }
    this.WLN.removeAllViews();
    localObject = (LinearLayout)this.fgR.WQv.getContext().getLayoutInflater().inflate(R.i.eeC, null);
    this.WLN.addView((View)localObject, new ViewGroup.LayoutParams(-1, -2));
    this.WLN.setVisibility(0);
    ((LinearLayout)localObject).setVisibility(0);
    ((com.tencent.mm.ui.chatting.d.b.o)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.o.class)).m(this.WLN);
    AppMethodBeat.o(272215);
  }
  
  public final int hPV()
  {
    AppMethodBeat.i(35420);
    int j = 0;
    int i = j;
    if (this.WLL != null)
    {
      i = j;
      if (this.WLL.isShown()) {
        i = this.WLL.getHeight() + 0;
      }
    }
    AppMethodBeat.o(35420);
    return i;
  }
  
  public final int hPW()
  {
    AppMethodBeat.i(272217);
    if ((this.fgR.WQv.isCurrentActivity) || (!isSupportCustomActionBar())) {
      ((AppCompatActivity)this.fgR.WQv.getContext()).getSupportActionBar().a(X(null), new ActionBar.LayoutParams(-1, -1));
    }
    for (ActionBar localActionBar = ((AppCompatActivity)this.fgR.WQv.getContext()).getSupportActionBar(); (localActionBar != null) && (localActionBar.getCustomView() != null); localActionBar = this.WLQ.getSupportActionBar())
    {
      int[] arrayOfInt = new int[2];
      localActionBar.getCustomView().getLocationOnScreen(arrayOfInt);
      int i = localActionBar.getHeight();
      int j = arrayOfInt[1];
      int k = hPV();
      AppMethodBeat.o(272217);
      return i + j + k;
    }
    AppMethodBeat.o(272217);
    return 0;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    int j = 1;
    AppMethodBeat.i(35389);
    super.onConfigurationChanged(paramConfiguration);
    Log.d("MicroMsg.ChattingUI.HeaderComponent", "getConfiguration().orientation = " + this.fgR.WQv.getMMResources().getConfiguration().orientation + ", newConfig.orientation = " + paramConfiguration.orientation);
    this.fgR.WQv.getMMResources().getConfiguration().orientation = paramConfiguration.orientation;
    Log.i("MicroMsg.ChatFooter", "[dealOrientationChange] %s", new Object[] { ((u)this.fgR.bC(u.class)).hPj().getContext().getResources().getConfiguration() });
    int i;
    if (this.mActionBarContainer != null)
    {
      i = 1;
      if (this.WLS == null) {
        break label272;
      }
    }
    for (;;)
    {
      if ((i & j) != 0)
      {
        i = com.tencent.mm.compatible.util.a.cu(this.fgR.WQv.getContext());
        this.WLS.setMinimumHeight(i);
        ViewGroup.LayoutParams localLayoutParams2 = this.WLS.getLayoutParams();
        ViewGroup.LayoutParams localLayoutParams1 = localLayoutParams2;
        if (localLayoutParams2 == null) {
          localLayoutParams1 = new ViewGroup.LayoutParams(-1, -1);
        }
        localLayoutParams1.height = i;
        this.WLS.setLayoutParams(localLayoutParams1);
        localLayoutParams1 = this.mActionBarContainer.getLayoutParams();
        localLayoutParams1.height = i;
        this.mActionBarContainer.setLayoutParams(localLayoutParams1);
      }
      if (this.WLQ != null) {
        this.WLQ.WaO.mActionBar.onConfigurationChanged(paramConfiguration);
      }
      AppMethodBeat.o(35389);
      return;
      i = 0;
      break;
      label272:
      j = 0;
    }
  }
  
  public final void setBackBtn(final MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    AppMethodBeat.i(35423);
    this.WLR.setClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(284935);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/component/HeaderComponent$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (!ae.this.fgR.WQv.isScreenEnable())
        {
          Log.w("MicroMsg.ChattingUI.HeaderComponent", "Actionbar customView onclick screen not enable");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/HeaderComponent$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(284935);
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
            AppMethodBeat.i(267372);
            if (ae.6.this.VRa != null) {
              ae.6.this.VRa.onMenuItemClick(null);
            }
            AppMethodBeat.o(267372);
          }
        });
        ((ai)ae.this.fgR.bC(ai.class)).hQq();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/HeaderComponent$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(284935);
      }
    });
    this.WLR.hFq();
    AppMethodBeat.o(35423);
  }
  
  public final void setMMSubTitle(String paramString)
  {
    AppMethodBeat.i(35422);
    int i = com.tencent.mm.ci.a.aY(this.fgR.WQv.getContext(), R.f.HintTextSize);
    paramString = l.d(this.fgR.WQv.getContext(), paramString, i);
    this.WLR.aD(paramString);
    AppMethodBeat.o(35422);
  }
  
  public final void setMMTitle(int paramInt)
  {
    AppMethodBeat.i(35402);
    setMMTitle(this.fgR.WQv.getMMResources().getString(paramInt));
    AppMethodBeat.o(35402);
  }
  
  public final void setMMTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(35421);
    if ((com.tencent.mm.model.ab.PQ(this.fgR.getTalkerUserName())) || (((com.tencent.mm.ui.chatting.d.b.f)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.f.class)).hOA()))
    {
      this.WLR.setTitle(paramCharSequence);
      this.fgR.WQv.updateDescription(this.fgR.WQv.getContext().getString(R.l.chatting_back_talker_desc, new Object[] { paramCharSequence }));
      AppMethodBeat.o(35421);
      return;
    }
    if (as.bvK(this.fgR.NKq.field_username))
    {
      paramCharSequence = ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.openim.a.a.class)).e(MMApplicationContext.getContext(), paramCharSequence.toString(), com.tencent.mm.ci.a.aY(MMApplicationContext.getContext(), R.f.BigTextSize));
      this.WLR.setTitle(paramCharSequence);
    }
    for (;;)
    {
      this.fgR.WQv.updateDescription(this.fgR.WQv.getContext().getString(R.l.chatting_back_talker_desc, new Object[] { paramCharSequence }));
      AppMethodBeat.o(35421);
      return;
      paramCharSequence = l.d(this.fgR.WQv.getContext(), paramCharSequence, com.tencent.mm.ci.a.aY(this.fgR.WQv.getContext(), R.f.BigTextSize));
      this.WLR.setTitle(paramCharSequence);
      if (!com.tencent.mm.model.ab.Lj(this.fgR.getTalkerUserName()))
      {
        ((com.tencent.mm.plugin.textstatus.a.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.textstatus.a.d.class)).setTextWithStatus(this.WLR.mNb, this.fgR.getTalkerUserName(), a.b.Mzz, a.c.MzI);
        hPI();
      }
    }
  }
  
  public final void setTitleMuteIconVisibility(int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(35426);
    if ((com.tencent.mm.model.ab.QQ(this.fgR.getTalkerUserName())) || (com.tencent.mm.model.ab.QV(this.fgR.getTalkerUserName())))
    {
      this.WLR.Fg(false);
      AppMethodBeat.o(35426);
      return;
    }
    com.tencent.mm.ui.b localb = this.WLR;
    if (paramInt == 0) {
      bool = true;
    }
    localb.Fg(bool);
    AppMethodBeat.o(35426);
  }
  
  public final void setTitlePhoneIconVisibility(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(35424);
    Object localObject = this.WLR;
    if (paramInt == 0)
    {
      paramInt = 1;
      localObject = ((com.tencent.mm.ui.b)localObject).VPO;
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
    private int VRh;
    public boolean WMr;
    private w.a WMs;
    private View jac;
    private String path;
    
    public a(int paramInt, String paramString, w.a parama)
    {
      AppMethodBeat.i(270061);
      this.jac = new View(ae.this.fgR.WQv.getContext());
      this.WMr = false;
      this.VRh = 0;
      this.path = paramString;
      this.WMs = parama;
      AppMethodBeat.o(270061);
    }
    
    public final void a(k paramk, boolean paramBoolean)
    {
      AppMethodBeat.i(179924);
      com.tencent.mm.plugin.newtips.a.g.a(this, paramk, paramBoolean);
      AppMethodBeat.o(179924);
    }
    
    public final boolean a(boolean paramBoolean, erx paramerx)
    {
      return false;
    }
    
    public final boolean b(boolean paramBoolean, erx paramerx)
    {
      return false;
    }
    
    public final boolean c(boolean paramBoolean, erx paramerx)
    {
      return false;
    }
    
    public final boolean d(boolean paramBoolean, erx paramerx)
    {
      return false;
    }
    
    public final boolean eQW()
    {
      return false;
    }
    
    public final String getPath()
    {
      return this.path;
    }
    
    public final View getRoot()
    {
      return this.jac;
    }
    
    public final boolean tX(boolean paramBoolean)
    {
      AppMethodBeat.i(179925);
      paramBoolean = com.tencent.mm.plugin.newtips.a.g.a(paramBoolean, this);
      AppMethodBeat.o(179925);
      return paramBoolean;
    }
    
    public final boolean tY(boolean paramBoolean)
    {
      AppMethodBeat.i(179926);
      this.WMr = paramBoolean;
      ae.this.fgR.WQv.updateOptionMenuRedDot(this.VRh, paramBoolean);
      AppMethodBeat.o(179926);
      return true;
    }
    
    public final boolean tZ(boolean paramBoolean)
    {
      return false;
    }
  }
  
  final class b
    extends com.tencent.mm.ui.ab
  {
    b() {}
    
    public final void atf()
    {
      AppMethodBeat.i(35387);
      if (((ai)ae.this.fgR.bC(ai.class)).hQm())
      {
        AppMethodBeat.o(35387);
        return;
      }
      Object localObject1;
      if (com.tencent.mm.model.ab.PQ(ae.this.fgR.getTalkerUserName()))
      {
        localObject1 = new iv();
        ((iv)localObject1).zR(ae.this.fgR.getTalkerUserName());
        ((iv)localObject1).gmT = 4L;
        ((iv)localObject1).bpa();
      }
      if ((ae.a(ae.this) != null) && (ae.a(ae.this).WMr)) {
        com.tencent.mm.plugin.newtips.a.fiO().aap(25);
      }
      if (com.tencent.mm.model.ab.Qe(ae.this.fgR.getTalkerUserName())) {
        com.tencent.mm.plugin.report.service.h.IzE.a(19540, new Object[] { Integer.valueOf(2) });
      }
      ae.this.fgR.hideVKB();
      Object localObject3;
      Object localObject2;
      if (com.tencent.mm.model.ab.QQ(ae.this.fgR.getTalkerUserName()))
      {
        if (((com.tencent.mm.ui.chatting.d.b.o)ae.this.fgR.bC(com.tencent.mm.ui.chatting.d.b.o.class)).hOZ())
        {
          localObject3 = ((com.tencent.mm.ui.chatting.d.b.o)ae.this.fgR.bC(com.tencent.mm.ui.chatting.d.b.o.class)).hPb();
          if (as.OS((String)localObject3))
          {
            localObject1 = com.tencent.mm.msgsubscription.api.b.moG;
            localObject2 = com.tencent.mm.msgsubscription.api.b.YR("name_wxa");
            localObject1 = y.afd((String)localObject3);
            if (localObject1 != null)
            {
              localObject1 = ((com.tencent.mm.plugin.appbrand.config.ae)localObject1).nickname;
              if (localObject2 == null) {
                break label379;
              }
              ((com.tencent.mm.msgsubscription.b.a)localObject2).a(ae.this.fgR.WQv.getContext(), 4, (String)localObject3, (String)localObject1);
            }
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.IzE.a(21825, new Object[] { Integer.valueOf(7), localObject3, Long.valueOf(Util.nowSecond()), null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
            AppMethodBeat.o(35387);
            return;
            Log.e("MicroMsg.ChattingUI.HeaderComponent", "attrs is null");
            localObject1 = null;
            break;
            localObject1 = com.tencent.mm.msgsubscription.api.b.moG;
            localObject2 = com.tencent.mm.msgsubscription.api.b.YR("name_biz");
            localObject1 = com.tencent.mm.model.aa.PJ((String)localObject3);
            break;
            label379:
            Log.e("MicroMsg.ChattingUI.HeaderComponent", "service is null");
          }
        }
        localObject1 = ae.this.fgR.WQv.getContext();
        localObject2 = new Intent(ae.this.fgR.WQv.getContext(), ServiceNotifyConversationUI.class);
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
        com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/ui/chatting/component/HeaderComponent$OptionListener", "onRealClick", "(Landroid/view/MenuItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((Activity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/ui/chatting/component/HeaderComponent$OptionListener", "onRealClick", "(Landroid/view/MenuItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.plugin.report.service.h.IzE.a(21825, new Object[] { Integer.valueOf(1), null, Long.valueOf(Util.nowSecond()), null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        AppMethodBeat.o(35387);
        return;
      }
      if (com.tencent.mm.model.ab.QV(ae.this.fgR.getTalkerUserName()))
      {
        localObject2 = new Intent(ae.this.fgR.WQv.getContext(), AppBrandNotifySettingsUI.class);
        localObject1 = (com.tencent.mm.plugin.appbrand.service.g)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.g.class);
        if (localObject1 == null) {
          break label1161;
        }
        localObject1 = ((com.tencent.mm.plugin.appbrand.service.g)localObject1).bFl();
        ((Intent)localObject2).putExtra("report_session_id", (String)localObject1);
      }
      for (;;)
      {
        localObject3 = ae.this.fgR.WQv.getContext();
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
        com.tencent.mm.hellhoundlib.a.a.b(localObject3, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/ui/chatting/component/HeaderComponent$OptionListener", "onRealClick", "(Landroid/view/MenuItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((Activity)localObject3).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject3, "com/tencent/mm/ui/chatting/component/HeaderComponent$OptionListener", "onRealClick", "(Landroid/view/MenuItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.plugin.report.service.h.IzE.a(19724, new Object[] { Integer.valueOf(1), Integer.valueOf(6), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null, null, null, Integer.valueOf(0), null, null, Integer.valueOf(0), null, null, localObject1 });
        AppMethodBeat.o(35387);
        return;
        if (com.tencent.mm.model.ab.Qi(ae.this.fgR.getTalkerUserName()))
        {
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("Contact_User", ae.this.fgR.getTalkerUserName());
          com.tencent.mm.by.c.b(ae.this.fgR.WQv.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject1);
          AppMethodBeat.o(35387);
          return;
        }
        if (((ac)ae.this.fgR.bC(ac.class)).hQe())
        {
          ae.b(ae.this);
          AppMethodBeat.o(35387);
          return;
        }
        if (((com.tencent.mm.ui.chatting.d.b.d)ae.this.fgR.bC(com.tencent.mm.ui.chatting.d.b.d.class)).hOq())
        {
          AppMethodBeat.o(35387);
          return;
        }
        if (((com.tencent.mm.ui.chatting.d.b.i)ae.this.fgR.bC(com.tencent.mm.ui.chatting.d.b.i.class)).hOP()) {
          ((PluginGameLife)com.tencent.mm.kernel.h.ag(PluginGameLife.class)).jumpToGameLifeSingleChatInfoUIReport(ae.this.fgR.getTalkerUserName());
        }
        localObject2 = new Intent();
        ((Intent)localObject2).setClass(ae.this.fgR.WQv.getContext(), SingleChatInfoUI.class);
        ((Intent)localObject2).putExtra("Single_Chat_Talker", ae.this.fgR.getTalkerUserName());
        ((Intent)localObject2).putExtra("fromChatting", true);
        localObject1 = ae.this.fgR.WQv;
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
        com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/ui/chatting/component/HeaderComponent$OptionListener", "onRealClick", "(Landroid/view/MenuItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((MMFragment)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/ui/chatting/component/HeaderComponent$OptionListener", "onRealClick", "(Landroid/view/MenuItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(35387);
        return;
        label1161:
        localObject1 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.ae
 * JD-Core Version:    0.7.0.1
 */