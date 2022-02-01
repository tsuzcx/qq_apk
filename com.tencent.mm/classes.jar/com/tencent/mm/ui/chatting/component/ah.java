package com.tencent.mm.ui.chatting.component;

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
import android.widget.FrameLayout.LayoutParams;
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
import com.tencent.mm.ah.a.j;
import com.tencent.mm.autogen.a.acn;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.mmdata.rpt.lf;
import com.tencent.mm.autogen.mmdata.rpt.qt;
import com.tencent.mm.chatroom.ui.RoomCardUI;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.model.b.b.a;
import com.tencent.mm.model.b.b.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.modelavatar.AvatarStorage;
import com.tencent.mm.modelavatar.AvatarStorage.a;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.plugin.newtips.PluginNewTips.a;
import com.tencent.mm.plugin.textstatus.a.a.b;
import com.tencent.mm.plugin.textstatus.a.a.c;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.fng;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.AppBrandNotifySettingsUI;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.SingleChatInfoUI;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.b.1;
import com.tencent.mm.ui.b.2;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.ap;
import com.tencent.mm.ui.chatting.component.api.ba;
import com.tencent.mm.ui.chatting.component.api.x;
import com.tencent.mm.ui.f.f;
import com.tencent.mm.ui.tools.o;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.ui.y;
import com.tencent.mm.ui.y.a;
import com.tencent.mm.ui.y.b;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.chatting.component.annotation.a(juB=com.tencent.mm.ui.chatting.component.api.ad.class)
public class ah
  extends a
  implements com.tencent.mm.ui.chatting.component.api.ad
{
  private int PCB;
  private boolean aepE;
  private final MStorage.IOnStorageChange aepz;
  final com.tencent.mm.ui.ad aerl;
  protected LinearLayout aetO;
  protected LinearLayout aetP;
  protected LinearLayout aetQ;
  private List<String> aetR;
  private String aetS;
  public com.tencent.mm.ui.ab aetT;
  private com.tencent.mm.ui.b aetU;
  private View aetV;
  private a aetW;
  private b.a aetX;
  private Runnable aetY;
  private final AvatarStorage.a aetZ;
  private final View.OnClickListener aeua;
  private final View.OnClickListener aeub;
  final int aeuc;
  final int aeud;
  final MenuItem.OnMenuItemClickListener aeue;
  private qt aeuf;
  private View aeug;
  private View aeuh;
  private MenuItem.OnMenuItemClickListener backListener;
  private ActionBarContainer mActionBarContainer;
  
  public ah()
  {
    AppMethodBeat.i(35388);
    this.aetR = new LinkedList();
    this.PCB = 0;
    this.mActionBarContainer = null;
    this.aetT = null;
    this.aepE = false;
    this.aerl = new b();
    this.aetX = new b.a()
    {
      public final void bEe()
      {
        AppMethodBeat.i(179915);
        com.tencent.mm.ui.chatting.d.a.juI().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(35371);
            bh.bCz().bAb();
            if (com.tencent.mm.model.b.b.a(b.b.ool))
            {
              ah.c(ah.this);
              AppMethodBeat.o(35371);
              return;
            }
            ah.d(ah.this);
            AppMethodBeat.o(35371);
          }
        });
        AppMethodBeat.o(179915);
      }
    };
    this.aetY = null;
    this.aetZ = new AvatarStorage.a()
    {
      public final void LM(final String paramAnonymousString)
      {
        AppMethodBeat.i(179917);
        com.tencent.mm.ui.chatting.d.a.juI().removeCallbacks(ah.e(ah.this));
        com.tencent.mm.ui.chatting.d.a.juI().postDelayed(ah.a(ah.this, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(179916);
            if ((!Util.isNullOrNil(ah.f(ah.this))) && (!Util.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals(ah.f(ah.this)))) {
              ah.this.LZ(false);
            }
            AppMethodBeat.o(179916);
          }
        }), 1000L);
        AppMethodBeat.o(179917);
      }
    };
    this.aepz = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(179918);
        Log.v("MicroMsg.ChattingUI.HeaderComponent", "roommember watcher notify ".concat(String.valueOf(paramAnonymousString)));
        if ((ah.this.hlc.juG()) && (!Util.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals(ah.this.hlc.getTalkerUserName())))
        {
          ah.this.jrB();
          ah.this.jsI();
          ah.g(ah.this);
        }
        AppMethodBeat.o(179918);
      }
    };
    this.aeua = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(256091);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/component/HeaderComponent$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (com.tencent.mm.storage.au.bwQ(ah.this.hlc.getTalkerUserName()))
        {
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("Contact_User", ah.this.hlc.getTalkerUserName());
          paramAnonymousView.putExtra("CONTACT_INFO_UI_SOURCE", 2);
          com.tencent.mm.br.c.b(ah.this.hlc.aezO.getContext(), "profile", ".ui.ContactInfoUI", paramAnonymousView, 213);
          com.tencent.mm.openim.d.a.bm(ah.this.hlc.getTalkerUserName(), 4);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/HeaderComponent$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(256091);
          return;
          if (com.tencent.mm.storage.au.bwY(ah.this.hlc.getTalkerUserName())) {
            ((com.tencent.mm.plugin.textstatus.a.r)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.textstatus.a.r.class)).bW(ah.this.hlc.aezO.getContext(), ah.this.hlc.getTalkerUserName());
          } else {
            ah.l(ah.this);
          }
        }
      }
    };
    this.aeub = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(35382);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/component/HeaderComponent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (((com.tencent.mm.plugin.textstatus.a.f)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.textstatus.a.f.class)).hasStatus(ah.this.hlc.Uxa.field_username)) {
          ah.l(ah.this);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/HeaderComponent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(35382);
      }
    };
    this.backListener = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(256094);
        boolean bool = ah.this.hlc.aezO.joU();
        AppMethodBeat.o(256094);
        return bool;
      }
    };
    this.aeuc = 1;
    this.aeud = 2;
    this.aeue = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(255786);
        acn localacn = new acn();
        localacn.ifU.hId = 5;
        localacn.ifU.talker = ah.this.hlc.Uxa.field_username;
        localacn.ifU.context = ah.this.hlc.aezO.getContext();
        if (paramAnonymousMenuItem.getItemId() == 1) {
          localacn.ifU.ifQ = 4;
        }
        for (;;)
        {
          localacn.publish();
          AppMethodBeat.o(255786);
          return true;
          if (paramAnonymousMenuItem.getItemId() == 2) {
            localacn.ifU.ifQ = 2;
          }
        }
      }
    };
    this.aeuf = null;
    this.aeug = null;
    this.aeuh = null;
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
    y.a locala = this.hlc.aezO.findMenuInfo(0);
    if (Util.isNullOrNil(paramString))
    {
      if (locala == null)
      {
        this.hlc.aezO.addIconOptionMenu(0, paramInt1, paramInt2, paramOnMenuItemClickListener);
        AppMethodBeat.o(179927);
        return;
      }
      this.hlc.aezO.updateOptionMenu(0, paramInt1, paramInt2, paramOnMenuItemClickListener);
      AppMethodBeat.o(179927);
      return;
    }
    if (locala == null) {
      this.hlc.aezO.addIconOptionMenu(0, paramInt1, paramInt2, paramOnMenuItemClickListener);
    }
    for (paramOnMenuItemClickListener = this.hlc.aezO.findMenuInfo(0); paramOnMenuItemClickListener == null; paramOnMenuItemClickListener = locala)
    {
      Log.e("MicroMsg.ChattingUI.HeaderComponent", "updateMenuInfo menuInfo == null");
      AppMethodBeat.o(179927);
      return;
      this.hlc.aezO.updateOptionMenu(0, paramInt1, paramInt2, paramOnMenuItemClickListener);
    }
    this.aetW = new a(0, paramString, paramOnMenuItemClickListener);
    com.tencent.mm.plugin.newtips.a.gtf().h(this.aetW);
    com.tencent.mm.plugin.newtips.a.g.a(this.aetW);
    if (paramOnMenuItemClickListener.ihQ) {
      com.tencent.mm.plugin.newtips.a.g.a(this.aetW, com.tencent.mm.plugin.newtips.a.k.MsK, true);
    }
    AppMethodBeat.o(179927);
  }
  
  private void a(ActionBar paramActionBar)
  {
    AppMethodBeat.i(255921);
    boolean bool = aw.isDarkMode();
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
          aw.a(((TextView)localObject).getPaint(), 0.8F);
          if (bool) {
            ((TextView)localObject).setTextColor(this.hlc.aezO.getMMResources().getColor(R.e.actionbar_title_light_color));
          }
        }
        localObject = (TextView)paramActionBar.getCustomView().findViewById(R.h.sub_title_area);
        if ((localObject != null) && (bool)) {
          ((TextView)localObject).setTextColor(this.hlc.aezO.getMMResources().getColor(R.e.actionbar_title_light_color));
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
        AppMethodBeat.o(255921);
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
    AppMethodBeat.o(255921);
  }
  
  private void a(String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, y.b paramb)
  {
    AppMethodBeat.i(255940);
    y.a locala2 = this.hlc.aezO.findMenuInfo(0);
    y.a locala1 = locala2;
    if (locala2 != null) {
      if (locala2.advq == 0)
      {
        locala1 = locala2;
        if (locala2.adEG == null) {}
      }
      else
      {
        this.hlc.aezO.removeOptionMenu(0);
        locala1 = null;
      }
    }
    if (locala1 == null)
    {
      this.hlc.aezO.addTextOptionMenu(0, paramString, paramOnMenuItemClickListener, null, paramb);
      AppMethodBeat.o(255940);
      return;
    }
    this.hlc.aezO.updateOptionMenuText(0, paramString);
    AppMethodBeat.o(255940);
  }
  
  private String aH(com.tencent.mm.storage.au paramau)
  {
    AppMethodBeat.i(35403);
    if (paramau == null)
    {
      paramau = this.hlc.aezO.getContext().getString(R.l.gvS);
      AppMethodBeat.o(35403);
      return paramau;
    }
    if (RegionCodeDecoder.byG(paramau.getCountryCode()))
    {
      String str = paramau.getCity();
      if (!Util.isNullOrNil(str))
      {
        AppMethodBeat.o(35403);
        return str;
      }
      str = aa.IF(paramau.getProvince());
      if (!Util.isNullOrNil(str))
      {
        AppMethodBeat.o(35403);
        return str;
      }
      RegionCodeDecoder.jcF();
      paramau = RegionCodeDecoder.getLocName(paramau.getCountryCode());
      AppMethodBeat.o(35403);
      return paramau;
    }
    paramau = aa.IF(paramau.getProvince());
    if (!Util.isNullOrNil(paramau))
    {
      AppMethodBeat.o(35403);
      return paramau;
    }
    paramau = this.hlc.aezO.getContext().getString(R.l.gvS);
    AppMethodBeat.o(35403);
    return paramau;
  }
  
  private View ah(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(35406);
    int i = R.i.actionbar_custom_area_center;
    if (this.aetV == null)
    {
      if (paramViewGroup == null) {}
      for (this.aetV = com.tencent.mm.ui.af.mU(this.hlc.aezO.getContext()).inflate(i, null);; this.aetV = com.tencent.mm.ui.af.mU(this.hlc.aezO.getContext()).inflate(i, paramViewGroup, false))
      {
        paramViewGroup = this.aetV;
        AppMethodBeat.o(35406);
        return paramViewGroup;
      }
    }
    if (this.aetV.getParent() == null)
    {
      paramViewGroup = this.aetV;
      AppMethodBeat.o(35406);
      return paramViewGroup;
    }
    if ((this.aetV.getParent() instanceof ViewGroup))
    {
      ((ViewGroup)this.aetV.getParent()).removeView(this.aetV);
      paramViewGroup = this.aetV;
      AppMethodBeat.o(35406);
      return paramViewGroup;
    }
    if (paramViewGroup == null) {}
    for (this.aetV = com.tencent.mm.ui.af.mU(this.hlc.aezO.getContext()).inflate(i, null);; this.aetV = com.tencent.mm.ui.af.mU(this.hlc.aezO.getContext()).inflate(i, paramViewGroup, false))
    {
      paramViewGroup = this.aetV;
      AppMethodBeat.o(35406);
      return paramViewGroup;
    }
  }
  
  private void doResume()
  {
    AppMethodBeat.i(35399);
    if ((com.tencent.mm.storage.au.bxe(this.hlc.getTalkerUserName())) || (com.tencent.mm.storage.au.bxj(this.hlc.getTalkerUserName())) || ((1 == ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.ztC, 1)) && (com.tencent.mm.model.ab.IM(this.hlc.getTalkerUserName()))))
    {
      com.tencent.mm.plugin.newtips.a.gti();
      boolean bool = com.tencent.mm.plugin.newtips.a.e.aeE(com.tencent.mm.plugin.newtips.a.d.Msg);
      this.hlc.aezO.addIconOptionMenu(0, R.l.actionbar_title_setting, R.k.actionbar_setting_icon, Boolean.valueOf(bool).booleanValue(), this.aerl);
    }
    AppMethodBeat.o(35399);
  }
  
  private boolean isSupportCustomActionBar()
  {
    AppMethodBeat.i(35404);
    boolean bool = this.hlc.aezO.isSupportNavigationSwipeBack();
    AppMethodBeat.o(35404);
    return bool;
  }
  
  private void jsC()
  {
    AppMethodBeat.i(35400);
    if (com.tencent.mm.kernel.h.baC().aZN())
    {
      com.tencent.mm.modelavatar.q.bFp().b(this.aetZ);
      bh.bCz();
      com.tencent.mm.model.c.bzK().remove(this.aepz);
    }
    com.tencent.mm.ui.chatting.d.a.juI().removeCallbacks(this.aetY);
    com.tencent.mm.model.v.bAF();
    if (this.aetW != null)
    {
      com.tencent.mm.plugin.newtips.a.gtf();
      com.tencent.mm.plugin.newtips.a.i.i(this.aetW);
    }
    AppMethodBeat.o(35400);
  }
  
  private void jsD()
  {
    AppMethodBeat.i(255898);
    Log.i("MicroMsg.ChattingUI.HeaderComponent", "resetUserLevelTitle!");
    this.aetU.jhC();
    AppMethodBeat.o(255898);
  }
  
  private void jsE()
  {
    AppMethodBeat.i(255900);
    View localView = this.hlc.aezO.findViewById(R.h.title_area_container);
    if (localView != null) {
      localView.setOnClickListener(this.aeua);
    }
    AppMethodBeat.o(255900);
  }
  
  private void jsF()
  {
    AppMethodBeat.i(255902);
    View localView = this.hlc.aezO.findViewById(R.h.sub_title_area_container);
    if (localView != null) {
      localView.setOnClickListener(this.aeub);
    }
    AppMethodBeat.o(255902);
  }
  
  private void jsH()
  {
    AppMethodBeat.i(35409);
    this.aetR.clear();
    this.aetR.add(this.hlc.aezO.getStringExtra("Chat_User"));
    AppMethodBeat.o(35409);
  }
  
  private void jsJ()
  {
    AppMethodBeat.i(35413);
    if (this.hlc.aezO.getContext() == null)
    {
      Log.w("MicroMsg.ChattingUI.HeaderComponent", "getActivity is null");
      AppMethodBeat.o(35413);
      return;
    }
    jsR();
    ViewGroup localViewGroup = (ViewGroup)this.hlc.aezO.getContext().findViewById(R.h.fxo);
    com.tencent.mm.pluginsdk.ui.a.a locala = com.tencent.mm.ui.conversation.banner.e.a(this.hlc.aezO.getContext(), com.tencent.mm.ui.conversation.banner.e.a.aftb, new Object[] { b.b.ool });
    if ((localViewGroup != null) && (locala != null) && (locala.getView() != null) && (this.aeuh == null))
    {
      this.aeuh = locala.getView();
      localViewGroup.addView(this.aeuh, new ViewGroup.LayoutParams(-1, -2));
    }
    AppMethodBeat.o(35413);
  }
  
  private void jsL()
  {
    int i = 0;
    AppMethodBeat.i(255952);
    Object localObject1 = (ba)this.hlc.cm(ba.class);
    if ((((ba)localObject1).jtJ()) || (((ba)localObject1).jtI()) || (((ba)localObject1).jtH()))
    {
      AppMethodBeat.o(255952);
      return;
    }
    Object localObject2 = this.hlc.Uxa.field_username;
    localObject1 = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju((String)localObject2);
    if ((this.hlc.aezO.hasDestory) || (localObject1 == null) || (((aj)localObject1).field_chatroomNoticeNew != 1))
    {
      jsO();
      AppMethodBeat.o(255952);
      return;
    }
    if (this.aetO != null) {
      jsO();
    }
    if (this.aetQ == null)
    {
      n.c(this.hlc.aezO, R.h.gch);
      this.aetQ = ((LinearLayout)this.hlc.aezO.getContext().findViewById(R.h.fIm));
    }
    this.aetQ.removeAllViews();
    LinearLayout localLinearLayout = (LinearLayout)this.hlc.aezO.getContext().getLayoutInflater().inflate(R.i.ghq, null);
    this.aetQ.addView(localLinearLayout, new ViewGroup.LayoutParams(-1, -2));
    String str = ((aj)localObject1).field_chatroomnotice;
    if (!Util.isNullOrNil(str)) {
      ((TextView)localLinearLayout.findViewById(R.h.fqt)).setText(str);
    }
    final boolean bool1;
    final boolean bool2;
    if (Util.isNullOrNil(((aj)localObject1).field_roomowner))
    {
      bool1 = false;
      bool2 = ((aj)localObject1).bvK(z.bAM());
      localLinearLayout.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(255797);
          Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/component/HeaderComponent$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
          Object localObject2 = new Intent();
          ((Intent)localObject2).setClass(ah.this.hlc.aezO.getContext(), RoomCardUI.class);
          ((Intent)localObject2).putExtra("RoomInfo_Id", this.lyR);
          ((Intent)localObject2).putExtra("room_notice", com.tencent.mm.model.v.Ip(this.lyR));
          ((Intent)localObject2).putExtra("room_notice_publish_time", com.tencent.mm.model.v.Is(this.lyR));
          ((Intent)localObject2).putExtra("room_notice_editor", com.tencent.mm.model.v.Ir(this.lyR));
          ((Intent)localObject2).putExtra("from_scene", 2);
          paramAnonymousView = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(this.lyR);
          if (paramAnonymousView != null)
          {
            ((Intent)localObject2).putExtra("Is_RoomOwner", bool1);
            ((Intent)localObject2).putExtra("Is_RoomManager", bool2);
          }
          ((Intent)localObject2).putExtra("room_member_count", paramAnonymousView.field_memberCount);
          localObject1 = ah.this.hlc.aezO.getContext();
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
          com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/ui/chatting/component/HeaderComponent$14", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Activity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/ui/chatting/component/HeaderComponent$14", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localObject1 = new qt().xT(this.lyR);
          ((qt)localObject1).imZ = paramAnonymousView.field_memberCount;
          long l;
          if (bool1)
          {
            l = 1L;
            ((qt)localObject1).imY = l;
            paramAnonymousView = ((qt)localObject1).xU(paramAnonymousView.field_chatroomnoticePublishTime);
            paramAnonymousView.ikE = 23L;
            paramAnonymousView.bMH();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/HeaderComponent$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(255797);
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
      this.aetQ.setVisibility(0);
      localLinearLayout.setVisibility(0);
      this.aeuf = new qt();
      localObject2 = this.aeuf.xT((String)localObject2);
      ((qt)localObject2).imZ = ((aj)localObject1).field_memberCount;
      if (!bool1) {
        break label421;
      }
    }
    for (long l = 1L;; l = i)
    {
      ((qt)localObject2).imY = l;
      ((qt)localObject2).xU(((aj)localObject1).field_chatroomnoticePublishTime).ikE = 22L;
      AppMethodBeat.o(255952);
      return;
      bool1 = ((aj)localObject1).field_roomowner.equals(z.bAM());
      break;
      label421:
      if (bool2) {
        i = 2;
      }
    }
  }
  
  private void jsN()
  {
    AppMethodBeat.i(35415);
    if ((this.hlc.juG()) || (this.aetO == null))
    {
      jsO();
      AppMethodBeat.o(35415);
      return;
    }
    jsO();
    com.tencent.mm.pluginsdk.ui.a.a locala2;
    if (this.aetO.getTag() == null)
    {
      locala2 = com.tencent.mm.ui.conversation.banner.e.a(this.hlc.aezO.getContext(), com.tencent.mm.ui.conversation.banner.e.a.afsP, new Object[] { this.hlc.getTalkerUserName(), this.hlc.jrh() });
      locala1 = locala2;
      if (locala2 != null)
      {
        locala1 = locala2;
        if (locala2.getView() != null) {
          this.aetO.addView(locala2.getView(), new ViewGroup.LayoutParams(-1, -2));
        }
      }
    }
    for (com.tencent.mm.pluginsdk.ui.a.a locala1 = locala2;; locala1 = (com.tencent.mm.pluginsdk.ui.a.a)this.aetO.getTag())
    {
      if (locala1 != null)
      {
        this.aetO.setVisibility(0);
        this.aetO.setTag(locala1);
      }
      com.tencent.mm.plugin.report.service.h.OAn.b(11003, new Object[] { this.hlc.getTalkerUserName(), Integer.valueOf(1), Integer.valueOf(0) });
      AppMethodBeat.o(35415);
      return;
    }
  }
  
  private void jsO()
  {
    AppMethodBeat.i(35416);
    this.aetO.setVisibility(8);
    if (this.aetQ != null) {
      this.aetQ.setVisibility(8);
    }
    AppMethodBeat.o(35416);
  }
  
  private void jsP()
  {
    AppMethodBeat.i(35417);
    if (this.hlc.aezO.getContext() == null)
    {
      Log.w("MicroMsg.ChattingUI.HeaderComponent", "getActivity is null");
      AppMethodBeat.o(35417);
      return;
    }
    jsQ();
    ViewGroup localViewGroup = (ViewGroup)this.hlc.aezO.getContext().findViewById(R.h.fxv);
    com.tencent.mm.pluginsdk.ui.a.a locala = com.tencent.mm.ui.conversation.banner.e.a(this.hlc.aezO.getContext(), com.tencent.mm.ui.conversation.banner.e.a.afsQ, new Object[] { this.hlc.getTalkerUserName(), this.hlc.jrh(), Boolean.valueOf(this.hlc.juG()) });
    if ((localViewGroup != null) && (locala != null) && (locala.getView() != null) && (this.aeug == null))
    {
      this.aeug = locala.getView();
      localViewGroup.addView(this.aeug, new ViewGroup.LayoutParams(-1, -2));
    }
    AppMethodBeat.o(35417);
  }
  
  private void jsQ()
  {
    AppMethodBeat.i(35418);
    ViewGroup localViewGroup = (ViewGroup)this.hlc.aezO.getContext().findViewById(R.h.fxv);
    if ((localViewGroup != null) && (this.aeug != null))
    {
      localViewGroup.removeView(this.aeug);
      this.aeug = null;
    }
    AppMethodBeat.o(35418);
  }
  
  private void jsR()
  {
    AppMethodBeat.i(35419);
    ViewGroup localViewGroup = (ViewGroup)this.hlc.aezO.getContext().findViewById(R.h.fxo);
    if ((localViewGroup != null) && (this.aeuh != null))
    {
      localViewGroup.removeView(this.aeuh);
      this.aeuh = null;
    }
    AppMethodBeat.o(35419);
  }
  
  public final void LZ(boolean paramBoolean)
  {
    AppMethodBeat.i(35412);
    if (this.hlc == null)
    {
      Log.e("MicroMsg.ChattingUI.HeaderComponent", "[updateBannerStatus] mChattingContext == null!");
      AppMethodBeat.o(35412);
      return;
    }
    if (!this.hlc.juG()) {
      if ((!com.tencent.mm.model.ab.IN(this.hlc.getTalkerUserName())) && (n.bxa(this.hlc.getTalkerUserName())) && (!((com.tencent.mm.ui.chatting.component.api.ah)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.ah.class)).jti()))
      {
        this.aetS = this.hlc.getTalkerUserName();
        jsK();
      }
    }
    for (;;)
    {
      if (paramBoolean)
      {
        jsP();
        jsJ();
      }
      AppMethodBeat.o(35412);
      return;
      if ((!((com.tencent.mm.ui.chatting.component.api.af)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.af.class)).jrO()) && (!((com.tencent.mm.ui.chatting.component.api.q)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.q.class)).jrO()))
      {
        jsN();
        continue;
        jsO();
        jsL();
      }
    }
  }
  
  public final void a(com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(35390);
    super.a(parama);
    if (isSupportCustomActionBar())
    {
      this.aetT = new com.tencent.mm.ui.ab();
      parama = this.aetT;
      BaseChattingUIFragment localBaseChattingUIFragment = this.hlc.aezO;
      parama.adFi = localBaseChattingUIFragment;
      parama.adFj = new com.tencent.mm.ui.b.b(localBaseChattingUIFragment.thisActivity(), parama);
      this.hlc.aezO.setActivityController(this.aetT);
    }
    AppMethodBeat.o(35390);
  }
  
  public final void a(boolean paramBoolean, View.OnClickListener paramOnClickListener, String paramString)
  {
    AppMethodBeat.i(256102);
    com.tencent.mm.ui.b localb = this.aetU;
    int i;
    if (!paramBoolean)
    {
      localb.adtP.setVisibility(0);
      i = localb.pJJ.getCurrentTextColor();
      localb.adtP.setIconColor(i);
      localb.adtP.setContentDescription(paramString);
      localb.adtO.setOnClickListener(paramOnClickListener);
      o.F(localb.adtO, 0.7F);
      localb.adtS.setVisibility(8);
      localb.adtR.setOnClickListener(null);
      localb.adtR.setClickable(false);
      localb.adtR.setFocusable(true);
      o.mb(localb.adtR);
    }
    for (;;)
    {
      Log.d("MicroMsg.ActionBarCustomArea", "fixWhenTitleTooLong, forSubTitle: ".concat(String.valueOf(paramBoolean)));
      if (paramBoolean) {
        break;
      }
      localb.pJJ.post(new b.1(localb));
      AppMethodBeat.o(256102);
      return;
      localb.adtS.setVisibility(0);
      i = localb.adtQ.getCurrentTextColor();
      localb.adtS.setIconColor(i);
      localb.adtS.setContentDescription(paramString);
      localb.adtR.setOnClickListener(paramOnClickListener);
      o.F(localb.adtR, 0.7F);
      localb.adtP.setVisibility(8);
      localb.adtO.setOnClickListener(null);
      localb.adtO.setClickable(false);
      localb.adtO.setFocusable(true);
      o.mb(localb.adtO);
    }
    localb.pJJ.post(new b.2(localb));
    AppMethodBeat.o(256102);
  }
  
  public final void aCe(int paramInt)
  {
    AppMethodBeat.i(35427);
    com.tencent.mm.ui.b localb = this.aetU;
    ImageView localImageView;
    if (paramInt == 0)
    {
      paramInt = 1;
      if (paramInt == 0) {
        break label68;
      }
      localImageView = localb.adtV;
      if (!aw.isDarkMode()) {
        break label61;
      }
    }
    label61:
    for (paramInt = a.j.chat_reject_title_icon;; paramInt = a.j.chat_reject_icon)
    {
      localImageView.setImageResource(paramInt);
      localb.adtV.setVisibility(0);
      AppMethodBeat.o(35427);
      return;
      paramInt = 0;
      break;
    }
    label68:
    localb.adtV.setVisibility(8);
    AppMethodBeat.o(35427);
  }
  
  public final void b(SpannableString paramSpannableString)
  {
    AppMethodBeat.i(256097);
    this.aetU.aQ(paramSpannableString);
    AppMethodBeat.o(256097);
  }
  
  public final void jjf()
  {
    AppMethodBeat.i(35391);
    jsG();
    AppMethodBeat.o(35391);
  }
  
  public final void jjg()
  {
    AppMethodBeat.i(35392);
    this.PCB = this.hlc.aezO.getIntExtra("add_scene", 0);
    com.tencent.mm.modelavatar.q.bFp().a(this.aetZ);
    bh.bCz();
    com.tencent.mm.model.c.bzK().add(this.aepz);
    setBackBtn(this.backListener);
    doResume();
    jrB();
    jsI();
    jsO();
    this.aepE = true;
    com.tencent.mm.model.v.a(this.hlc.getTalkerUserName(), new PluginNewTips.a()
    {
      public final void gtj()
      {
        AppMethodBeat.i(179909);
        Log.i("MicroMsg.ChattingUI.HeaderComponent", "onCallback");
        ah.this.jsI();
        AppMethodBeat.o(179909);
      }
    });
    AppMethodBeat.o(35392);
  }
  
  public final void jjh()
  {
    AppMethodBeat.i(35393);
    LZ(true);
    if (((com.tencent.mm.ui.chatting.component.api.r)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.r.class)).jrT())
    {
      jrB();
      ((com.tencent.mm.plugin.textstatus.a.r)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.textstatus.a.r.class)).dh(this.hlc.getTalkerUserName(), 5);
      ((com.tencent.mm.plugin.textstatus.a.r)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.textstatus.a.r.class)).bX(this.hlc.aezO.getContext(), this.hlc.getTalkerUserName());
    }
    AppMethodBeat.o(35393);
  }
  
  public final void jji()
  {
    AppMethodBeat.i(35394);
    bh.bCz().bzZ().a(new com.tencent.mm.model.b.e.a()
    {
      public final void bEf()
      {
        AppMethodBeat.i(35378);
        com.tencent.mm.ui.chatting.d.a.juI().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(35377);
            ah.h(ah.this);
            AppMethodBeat.o(35377);
          }
        });
        AppMethodBeat.o(35378);
      }
      
      public final void bEg()
      {
        AppMethodBeat.i(35379);
        ah.i(ah.this);
        AppMethodBeat.o(35379);
      }
    });
    bh.bCz().bAa().a(new com.tencent.mm.model.b.e.a()
    {
      public final void bEf()
      {
        AppMethodBeat.i(179920);
        com.tencent.mm.ui.chatting.d.a.juI().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(179919);
            ah.j(ah.this);
            AppMethodBeat.o(179919);
          }
        });
        AppMethodBeat.o(179920);
      }
      
      public final void bEg()
      {
        AppMethodBeat.i(179921);
        ah.k(ah.this);
        AppMethodBeat.o(179921);
      }
    });
    com.tencent.mm.model.b.b localb = bh.bCz().bAb();
    b.a locala = this.aetX;
    try
    {
      localb.mListeners.add(locala);
      if (!this.aepE) {
        doResume();
      }
      this.aepE = false;
      AppMethodBeat.o(35394);
      return;
    }
    finally
    {
      AppMethodBeat.o(35394);
    }
  }
  
  public final void jjj()
  {
    AppMethodBeat.i(35395);
    if (com.tencent.mm.kernel.h.baC().aZN())
    {
      bh.bCz().bzZ().a(null);
      bh.bCz().bAa().a(null);
      com.tencent.mm.model.b.b localb = bh.bCz().bAb();
      b.a locala = this.aetX;
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
  
  public final void jjk()
  {
    AppMethodBeat.i(35396);
    jsC();
    AppMethodBeat.o(35396);
  }
  
  public final void jjl()
  {
    AppMethodBeat.i(256027);
    super.jjl();
    if ((this.hlc.juG()) && (this.aetQ != null) && (this.aetQ.getVisibility() == 0)) {
      com.tencent.mm.model.v.It(this.hlc.Uxa.field_username);
    }
    if (this.aeuf != null)
    {
      this.aeuf.bMH();
      this.aeuf = null;
    }
    AppMethodBeat.o(256027);
  }
  
  public final com.tencent.mm.ui.ab joS()
  {
    return this.aetT;
  }
  
  public final void jqF()
  {
    AppMethodBeat.i(35397);
    super.jqF();
    jsC();
    AppMethodBeat.o(35397);
  }
  
  public final void jrB()
  {
    AppMethodBeat.i(35401);
    jsD();
    this.hlc.aezO.setMMSubTitle(null);
    if (((ap)this.hlc.cm(ap.class)).jtm())
    {
      setMMTitle("");
      AppMethodBeat.o(35401);
      return;
    }
    if (com.tencent.mm.storage.au.bxe(this.hlc.getTalkerUserName()))
    {
      setMMTitle(this.hlc.Uxa.aSU());
      AppMethodBeat.o(35401);
      return;
    }
    if (((com.tencent.mm.ui.chatting.component.api.au)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.au.class)).jtz())
    {
      setMMTitle(R.l.gUt);
      AppMethodBeat.o(35401);
      return;
    }
    if (com.tencent.mm.storage.au.bwL(this.hlc.getTalkerUserName()))
    {
      ((x)this.hlc.cm(x.class)).jsd().setWordCountLimit(140);
      setMMTitle(this.hlc.Uxa.aSV());
      AppMethodBeat.o(35401);
      return;
    }
    if (com.tencent.mm.storage.au.bww(this.hlc.getTalkerUserName()))
    {
      if (((com.tencent.mm.ui.chatting.component.api.q)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.q.class)).jrP())
      {
        setMMTitle(this.hlc.aezO.getContext().getString(R.l.gQS));
        AppMethodBeat.o(35401);
        return;
      }
      setMMTitle(this.hlc.Uxa.aSU());
      AppMethodBeat.o(35401);
      return;
    }
    if (com.tencent.mm.storage.au.bwS(this.hlc.getTalkerUserName()))
    {
      setMMTitle(this.hlc.aezO.getContext().getString(R.l.gvM, new Object[] { aH(this.hlc.Uxa) }).trim());
      AppMethodBeat.o(35401);
      return;
    }
    if (com.tencent.mm.storage.au.Hh(this.hlc.getTalkerUserName()))
    {
      if (this.hlc.cm(com.tencent.mm.ui.chatting.component.api.a.class) != null)
      {
        ((com.tencent.mm.ui.chatting.component.api.a)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.a.class)).jrB();
        AppMethodBeat.o(35401);
      }
    }
    else
    {
      if (this.hlc.juF())
      {
        boolean bool2 = ((com.tencent.mm.ui.chatting.component.api.g)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.g.class)).aMq();
        String str = this.hlc.Uxa.field_conRemark;
        boolean bool1;
        if (Util.isNullOrNil(str))
        {
          str = this.hlc.Uxa.field_nickname;
          if ((!com.tencent.mm.storage.au.bwE(this.hlc.getTalkerUserName())) || (!((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).alQ(this.hlc.getTalkerUserName()))) {
            break label657;
          }
          bool1 = true;
          label473:
          Log.i("MicroMsg.ChattingUI.HeaderComponent", "isChatroomDismiss = ".concat(String.valueOf(bool1)));
          if (!Util.isNullOrNil(str)) {
            break label745;
          }
          if (com.tencent.mm.model.v.getMembersCountByChatRoomName(this.hlc.getTalkerUserName()) != 0) {
            break label662;
          }
          str = this.hlc.aezO.getContext().getString(R.l.gzv);
        }
        for (;;)
        {
          Object localObject;
          if (!com.tencent.mm.storage.au.bwF(this.hlc.getTalkerUserName()))
          {
            localObject = str;
            if (!bool2) {}
          }
          else
          {
            str = str + " ";
            localObject = p.i(this.hlc.aezO.getContext(), p.d(this.hlc.aezO.getContext(), str, com.tencent.mm.cd.a.br(this.hlc.aezO.getContext(), R.f.BigTextSize)), R.k.open_im_title_logo);
          }
          setMMTitle((CharSequence)localObject);
          AppMethodBeat.o(35401);
          return;
          setMMSubTitle(p.b(this.hlc.aezO.getContext(), this.hlc.jrh()).toString());
          break;
          label657:
          bool1 = false;
          break label473;
          label662:
          if (bool1)
          {
            str = this.hlc.aezO.getContext().getString(R.l.gzv);
          }
          else
          {
            str = this.hlc.aezO.getContext().getString(R.l.gIp, new Object[] { this.hlc.aezO.getContext().getString(R.l.gzv), Integer.valueOf(com.tencent.mm.model.v.getMembersCountByChatRoomName(this.hlc.getTalkerUserName())) });
            continue;
            label745:
            if (bool1) {
              str = this.hlc.Uxa.aSV();
            } else {
              str = this.hlc.aezO.getContext().getString(R.l.gIp, new Object[] { this.hlc.Uxa.aSV(), Integer.valueOf(com.tencent.mm.model.v.getMembersCountByChatRoomName(this.hlc.getTalkerUserName())) });
            }
          }
        }
      }
      if (((com.tencent.mm.ui.chatting.component.api.e)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.e.class)).jqX())
      {
        AppMethodBeat.o(35401);
        return;
      }
      if (((com.tencent.mm.ui.chatting.component.api.k)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.k.class)).jrF())
      {
        ((com.tencent.mm.ui.chatting.component.api.k)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.k.class)).jrB();
        AppMethodBeat.o(35401);
        return;
      }
      if (((com.tencent.mm.ui.chatting.component.api.i)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.i.class)).jrA())
      {
        ((com.tencent.mm.ui.chatting.component.api.i)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.i.class)).jrB();
        AppMethodBeat.o(35401);
        return;
      }
      this.aetU.KS(com.tencent.mm.storage.au.bwN(this.hlc.getTalkerUserName()));
      if (!com.tencent.mm.storage.au.bwQ(this.hlc.getTalkerUserName())) {
        break label1082;
      }
      setMMTitle(this.hlc.Uxa.aSV());
      this.aetU.KQ(true);
    }
    for (;;)
    {
      this.aetU.KS(com.tencent.mm.storage.au.bwN(this.hlc.getTalkerUserName()));
      if ((com.tencent.mm.storage.au.bwO(this.hlc.getTalkerUserName())) || (com.tencent.mm.storage.au.bwQ(this.hlc.getTalkerUserName()))) {
        this.hlc.aezO.setMMSubTitle(((com.tencent.mm.openim.api.e)com.tencent.mm.kernel.h.ax(com.tencent.mm.openim.api.e.class)).cc(this.hlc.Uxa.field_openImAppid, this.hlc.Uxa.field_descWordingId));
      }
      AppMethodBeat.o(35401);
      return;
      label1082:
      this.aetU.KQ(false);
      this.hlc.aezO.setMMTitle(this.hlc.Uxa.aSV());
      if (((com.tencent.mm.plugin.textstatus.a.f)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.textstatus.a.f.class)).hasStatus(this.hlc.Uxa.field_username)) {
        this.hlc.aezO.setMMSubTitle(this.hlc.Uxa.aSV());
      }
    }
  }
  
  public final void jsB()
  {
    AppMethodBeat.i(35398);
    if (this.hlc.joT() > 0) {
      this.aetO = ((LinearLayout)this.hlc.getListView().findViewById(R.h.fMW));
    }
    for (;;)
    {
      if ((((ap)this.hlc.cm(ap.class)).jtm()) && (this.hlc.getListView().getFooterViewsCount() == 0))
      {
        this.aetP = ((LinearLayout)this.hlc.aezO.getContext().getLayoutInflater().inflate(R.i.gho, null));
        this.hlc.getListView().addFooterView(this.aetP);
        if (((ap)this.hlc.cm(ap.class)).jtn())
        {
          int i = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adgC, 0);
          if (i != 0)
          {
            View localView = this.hlc.getListView().findViewById(R.h.fMV);
            LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
            localLayoutParams.height = i;
            localView.setLayoutParams(localLayoutParams);
          }
        }
      }
      jsO();
      AppMethodBeat.o(35398);
      return;
      this.aetO = ((LinearLayout)this.hlc.aezO.getContext().getLayoutInflater().inflate(R.i.ghr, null));
      this.hlc.ev(this.aetO);
    }
  }
  
  public final void jsG()
  {
    AppMethodBeat.i(35407);
    if ((this.hlc.aezO.isCurrentActivity) || (!isSupportCustomActionBar()))
    {
      localObject1 = com.tencent.mm.ui.widget.d.c(((AppCompatActivity)this.hlc.aezO.getContext()).getSupportActionBar());
      localObject2 = ah(null);
      ((ActionBar)localObject1).setCustomView((View)localObject2);
      this.aetU = new com.tencent.mm.ui.b((View)localObject2);
      a((ActionBar)localObject1);
      this.aetU.KS(false);
      ((ActionBar)localObject1).M((((ActionBar)localObject1).bu() | 0x10) & 0xFFFFFFFB & 0xFFFFFFFD & 0xFFFFFFF7);
      jsH();
      setBackBtn(this.backListener);
      AppMethodBeat.o(35407);
      return;
    }
    Object localObject1 = (ViewGroup)this.mActionBarContainer.findViewById(R.h.action_bar);
    Log.i("MicroMsg.ChattingUI.HeaderComponent", "mActionBarContainer %s", new Object[] { this.mActionBarContainer });
    Log.i("MicroMsg.ChattingUI.HeaderComponent", "ctxView %s", new Object[] { this.mActionBarContainer.findViewById(R.h.action_context_bar) });
    ((ViewGroup)localObject1).setVisibility(0);
    Object localObject2 = com.tencent.mm.ui.widget.d.c(this.aetT.getSupportActionBar());
    View localView = ah((ViewGroup)localObject1);
    ((ActionBar)localObject2).setCustomView(localView);
    this.aetU = new com.tencent.mm.ui.b(localView);
    int i = ((ActionBar)localObject2).getHeight();
    Object localObject3;
    if (i == 0)
    {
      localObject3 = this.hlc.aezO.getMMResources().getDisplayMetrics();
      if (((DisplayMetrics)localObject3).widthPixels > ((DisplayMetrics)localObject3).heightPixels) {
        i = this.hlc.aezO.getMMResources().getDimensionPixelSize(R.f.DefaultActionbarHeightLand);
      }
    }
    for (;;)
    {
      label281:
      localObject3 = localView.findViewById(R.h.sub_title_area);
      int j = i;
      if (localObject3 != null)
      {
        if (!((com.tencent.mm.ui.chatting.component.api.i)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.i.class)).jrA()) {
          break label449;
        }
        j = this.hlc.aezO.getMMResources().getDimensionPixelSize(R.f.FinderActionbarHeight);
        i = this.hlc.aezO.getMMResources().getDimensionPixelSize(R.f.Edge_A);
        ((View)localObject3).setPadding(i, i, i, i);
        ((ViewGroup)localObject1).setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
      }
      for (;;)
      {
        localView.setMinimumHeight(j);
        localObject3 = localView.getLayoutParams();
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = new ViewGroup.LayoutParams(-1, -1);
        }
        ((ViewGroup.LayoutParams)localObject1).height = j;
        ((ViewGroup.LayoutParams)localObject1).width = -1;
        localView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = localObject2;
        break;
        i = this.hlc.aezO.getMMResources().getDimensionPixelSize(R.f.DefaultActionbarHeightPort);
        break label281;
        label449:
        ((View)localObject3).setPadding(0, 0, 0, 0);
        ((ViewGroup)localObject1).setLayoutParams(new FrameLayout.LayoutParams(-1, this.hlc.aezO.getMMResources().getDimensionPixelSize(R.f.DefaultActionbarHeightPort)));
        j = i;
      }
    }
  }
  
  public final void jsI()
  {
    boolean bool3 = false;
    AppMethodBeat.i(35410);
    Object localObject = (com.tencent.mm.ui.chatting.component.api.au)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.au.class);
    if ((((com.tencent.mm.ui.chatting.component.api.au)localObject).jtz()) || (((com.tencent.mm.ui.chatting.component.api.au)localObject).jty()))
    {
      this.hlc.showOptionMenu(false);
      AppMethodBeat.o(35410);
      return;
    }
    if (((com.tencent.mm.ui.chatting.component.api.v)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.v.class)).jsc())
    {
      AppMethodBeat.o(35410);
      return;
    }
    if (com.tencent.mm.model.ab.IN(this.hlc.getTalkerUserName()))
    {
      this.hlc.showOptionMenu(false);
      AppMethodBeat.o(35410);
      return;
    }
    if (((ap)this.hlc.cm(ap.class)).jtm()) {
      a(this.hlc.aezO.getContext().getString(R.l.app_finish), this.aerl, y.b.adEJ);
    }
    while (com.tencent.mm.storage.au.bwS(this.hlc.getTalkerUserName()))
    {
      this.hlc.Mg(true);
      AppMethodBeat.o(35410);
      return;
      if ((com.tencent.mm.storage.au.bxj(this.hlc.getTalkerUserName())) || ((1 == ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.ztC, 1)) && (com.tencent.mm.model.ab.IM(this.hlc.getTalkerUserName()))))
      {
        a(R.l.actionbar_title_setting, R.k.actionbar_setting_icon, this.aerl);
      }
      else
      {
        boolean bool1;
        if (com.tencent.mm.storage.au.bxe(this.hlc.getTalkerUserName()))
        {
          com.tencent.mm.plugin.newtips.a.gti();
          bool1 = com.tencent.mm.plugin.newtips.a.e.aeE(com.tencent.mm.plugin.newtips.a.d.Msg);
          this.hlc.aezO.addIconOptionMenu(0, R.l.actionbar_title_setting, R.k.actionbar_setting_icon, Boolean.valueOf(bool1).booleanValue(), this.aerl);
        }
        else if (com.tencent.mm.model.ab.IP(this.hlc.getTalkerUserName()))
        {
          a(R.l.actionbar_title_setting, R.k.actionbar_setting_icon, this.aerl);
        }
        else if (com.tencent.mm.storage.au.bvS(this.hlc.getTalkerUserName()))
        {
          a(R.l.actionbar_title_setting, R.k.actionbar_setting_icon, this.aerl);
          com.tencent.mm.plugin.report.service.h.OAn.kvStat(10071, "1");
        }
        else if (com.tencent.mm.storage.au.bvT(this.hlc.getTalkerUserName()))
        {
          a(R.l.actionbar_title_setting, R.k.actionbar_setting_icon, this.aerl);
        }
        else if (com.tencent.mm.storage.au.bwu(this.hlc.getTalkerUserName()))
        {
          if (((com.tencent.mm.ui.chatting.component.api.q)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.q.class)).jrR()) {
            AppMethodBeat.o(35410);
          }
        }
        else if (com.tencent.mm.storage.au.bwA(this.hlc.getTalkerUserName()))
        {
          a(R.l.actionbar_title_setting, R.k.actionbar_setting_icon, this.aerl);
        }
        else if (com.tencent.mm.model.ab.IV(this.hlc.getTalkerUserName()))
        {
          if (com.tencent.mm.storage.au.bwf(this.hlc.getTalkerUserName()))
          {
            this.hlc.showOptionMenu(false);
            AppMethodBeat.o(35410);
            return;
          }
          a(R.l.actionbar_title_setting, R.k.actionbar_setting_icon, this.aerl);
        }
        else if ((com.tencent.mm.storage.au.bwL(this.hlc.getTalkerUserName())) || (com.tencent.mm.storage.au.bwN(this.hlc.getTalkerUserName())) || (com.tencent.mm.storage.au.bwS(this.hlc.getTalkerUserName())))
        {
          a(R.l.chatting_profile_desc, R.k.actionbar_icon_dark_more, this.aerl);
        }
        else if (com.tencent.mm.storage.au.Hh(this.hlc.getTalkerUserName()))
        {
          if (this.hlc.cm(com.tencent.mm.ui.chatting.component.api.a.class) != null) {
            ((com.tencent.mm.ui.chatting.component.api.a)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.a.class)).juC();
          }
        }
        else if ((((com.tencent.mm.ui.chatting.component.api.ah)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.ah.class)).jti()) && (n.bxa(this.hlc.getTalkerUserName())))
        {
          a(R.l.chatting_profile_desc, R.k.ofm_add_icon, this.aerl);
        }
        else if ((this.hlc.Uxa != null) && (this.hlc.Uxa.iZC()) && ((com.tencent.mm.an.g.Mw(this.hlc.getTalkerUserName())) || (com.tencent.mm.an.g.My(this.hlc.getTalkerUserName()))))
        {
          a(R.l.actionbar_title_setting, R.k.icons_outlined_me, this.aerl);
        }
        else
        {
          ((am)this.hlc.cm(am.class)).jtb();
          localObject = (com.tencent.mm.ui.chatting.component.api.e)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.e.class);
          if ((com.tencent.mm.storage.au.bwE(this.hlc.getTalkerUserName())) || (((com.tencent.mm.ui.chatting.component.api.e)localObject).jqV()))
          {
            if ((com.tencent.mm.storage.au.bwE(this.hlc.getTalkerUserName())) && (((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).alQ(this.hlc.getTalkerUserName()))) {}
            for (bool1 = true;; bool1 = false)
            {
              boolean bool2 = bool3;
              if (com.tencent.mm.storage.au.bwE(this.hlc.getTalkerUserName()))
              {
                bool2 = bool3;
                if (!com.tencent.mm.model.v.If(this.hlc.getTalkerUserName())) {
                  bool2 = true;
                }
              }
              Log.i("MicroMsg.ChattingUI.HeaderComponent", "isChatroomDismiss = " + bool1 + ", inChatRoom = " + bool2);
              if ((!bool1) && (!bool2)) {
                break label950;
              }
              a(R.l.chatting_profile_desc, R.k.actionbar_icon_dark_more, this.aerl);
              break;
            }
            label950:
            if (((com.tencent.mm.ui.chatting.component.api.g)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.g.class)).jrq())
            {
              Log.i("MicroMsg.ChattingUI.HeaderComponent", "cpan show chatroom right btn");
              if ((((com.tencent.mm.ui.chatting.component.api.g)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.g.class)).jrr()) && (((com.tencent.mm.ui.chatting.component.api.g)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.g.class)).aMF()) && (com.tencent.mm.model.v.bAG())) {
                a(R.l.chatting_profile_desc, R.k.actionbar_icon_dark_more, "chatroom", this.aerl);
              }
              for (;;)
              {
                this.hlc.showOptionMenu(true);
                break;
                a(R.l.chatting_profile_desc, R.k.actionbar_icon_dark_more, this.aerl);
              }
            }
            if ((((com.tencent.mm.ui.chatting.component.api.e)localObject).jqV()) && (!((com.tencent.mm.ui.chatting.component.api.e)localObject).jqW()))
            {
              a(R.l.chatting_profile_desc, R.k.actionbar_particular_icon, this.aerl);
              this.hlc.showOptionMenu(true);
            }
            else
            {
              this.hlc.showOptionMenu(true);
              a(R.l.actionbar_title_setting, R.k.actionbar_icon_dark_more, new com.tencent.mm.ui.ad()
              {
                private int ASV = 1;
                
                public final void d(MenuItem paramAnonymousMenuItem)
                {
                  AppMethodBeat.i(255790);
                  paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.f(ah.this.hlc.aezO.getContext(), 1, true);
                  paramAnonymousMenuItem.Vtg = new u.g()
                  {
                    public final void onCreateMMMenu(s paramAnonymous2s)
                    {
                      AppMethodBeat.i(256021);
                      paramAnonymous2s.c(ah.3.a(ah.3.this), ah.this.hlc.aezO.getContext().getString(R.l.gxj));
                      AppMethodBeat.o(256021);
                    }
                  };
                  paramAnonymousMenuItem.GAC = new u.i()
                  {
                    public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
                    {
                      AppMethodBeat.i(256024);
                      if (paramAnonymous2MenuItem.getItemId() == ah.3.a(ah.3.this))
                      {
                        paramAnonymous2MenuItem = new Intent();
                        paramAnonymous2MenuItem.putExtra("k_username", ah.this.hlc.getTalkerUserName());
                        paramAnonymous2MenuItem.putExtra("showShare", false);
                        paramAnonymous2MenuItem.putExtra("rawUrl", String.format(f.f.adwf, new Object[] { Integer.valueOf(36) }));
                        com.tencent.mm.br.c.b(ah.this.hlc.aezO.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymous2MenuItem);
                      }
                      AppMethodBeat.o(256024);
                    }
                  };
                  paramAnonymousMenuItem.dDn();
                  AppMethodBeat.o(255790);
                }
              });
              AppMethodBeat.o(35410);
            }
          }
          else
          {
            a(R.l.chatting_profile_desc, R.k.actionbar_icon_dark_more, this.aerl);
          }
        }
      }
    }
    this.hlc.showOptionMenu(true);
    AppMethodBeat.o(35410);
  }
  
  public final void jsK()
  {
    AppMethodBeat.i(35414);
    if (this.hlc.aezO.hasDestory)
    {
      AppMethodBeat.o(35414);
      return;
    }
    jsO();
    if (this.aetQ == null)
    {
      n.c(this.hlc.aezO, R.h.gch);
      this.aetQ = ((LinearLayout)this.hlc.aezO.getContext().findViewById(R.h.fIm));
    }
    this.aetQ.removeAllViews();
    final LinearLayout localLinearLayout = (LinearLayout)this.hlc.aezO.getContext().getLayoutInflater().inflate(R.i.ghp, null);
    this.aetQ.addView(localLinearLayout, new ViewGroup.LayoutParams(-1, -2));
    this.aetQ.setVisibility(0);
    localLinearLayout.setVisibility(0);
    Util.isNullOrNil(this.aetS);
    Button localButton = (Button)localLinearLayout.findViewById(R.h.fvI);
    if (((com.tencent.mm.ui.chatting.component.api.af)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.af.class)).jtc()) {
      ((com.tencent.mm.ui.chatting.component.api.af)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.af.class)).a(localButton, localLinearLayout, this.aetQ);
    }
    localLinearLayout.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(255789);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/component/HeaderComponent$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        ah.b(ah.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/HeaderComponent$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(255789);
      }
    });
    localButton.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(255795);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/component/HeaderComponent$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
        if (((com.tencent.mm.ui.chatting.component.api.af)ah.this.hlc.cm(com.tencent.mm.ui.chatting.component.api.af.class)).jtc())
        {
          ((com.tencent.mm.ui.chatting.component.api.af)ah.this.hlc.cm(com.tencent.mm.ui.chatting.component.api.af.class)).aCg(ah.m(ah.this));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/HeaderComponent$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(255795);
          return;
        }
        if ((int)ah.this.hlc.Uxa.maN == 0)
        {
          bh.bCz();
          if (com.tencent.mm.model.c.bzA().aC(ah.this.hlc.Uxa) != -1) {
            Log.e("MicroMsg.ChattingUI.HeaderComponent", "[insertRetId] successfully! username:%s", new Object[] { ah.this.hlc.Uxa });
          }
        }
        if (com.tencent.mm.storage.au.bwE(ah.this.hlc.Uxa.field_username))
        {
          paramAnonymousView = ah.this.hlc.Uxa.field_username;
          label202:
          bh.bCz();
          Object localObject2 = com.tencent.mm.model.c.bzA().JE(ah.f(ah.this));
          if (localObject2 == null) {
            break label400;
          }
          localObject1 = Util.nullAs(((az)localObject2).kas, "");
          label236:
          Log.i("MicroMsg.ChattingUI.HeaderComponent", "dkverify banner add:%s chat:%s ticket", new Object[] { ah.f(ah.this), paramAnonymousView, localObject1 });
          if (((!TextUtils.isEmpty(paramAnonymousView)) && (TextUtils.isEmpty((CharSequence)localObject1))) || (com.tencent.mm.storage.au.bwO(((az)localObject2).field_username))) {
            break label406;
          }
          localObject2 = new com.tencent.mm.pluginsdk.ui.applet.a(ah.this.hlc.aezO.getContext(), new a.a()
          {
            public final void canAddContact(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2, String paramAnonymous2String1, String paramAnonymous2String2)
            {
              AppMethodBeat.i(256037);
              if (paramAnonymous2Boolean1)
              {
                com.tencent.mm.model.ab.I(ah.this.hlc.Uxa);
                ah.5.this.aeuk.setVisibility(8);
              }
              AppMethodBeat.o(256037);
            }
          });
          LinkedList localLinkedList = new LinkedList();
          localLinkedList.add(Integer.valueOf(3));
          ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).bqM((String)localObject1);
          ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).YaS = true;
          ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).d(ah.f(ah.this), paramAnonymousView, localLinkedList);
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.OAn.b(11004, new Object[] { ah.f(ah.this), Integer.valueOf(3) });
          break;
          paramAnonymousView = "";
          break label202;
          label400:
          localObject1 = "";
          break label236;
          label406:
          az.a.okP.a(ah.f(ah.this), paramAnonymousView, new az.b.a()
          {
            public final void getContactCallBack(String paramAnonymous2String, boolean paramAnonymous2Boolean)
            {
              AppMethodBeat.i(256035);
              com.tencent.mm.pluginsdk.ui.applet.a locala = new com.tencent.mm.pluginsdk.ui.applet.a(ah.this.hlc.aezO.getContext(), new a.a()
              {
                public final void canAddContact(boolean paramAnonymous3Boolean1, boolean paramAnonymous3Boolean2, String paramAnonymous3String1, String paramAnonymous3String2)
                {
                  AppMethodBeat.i(256267);
                  if (paramAnonymous3Boolean1)
                  {
                    com.tencent.mm.model.ab.I(ah.this.hlc.Uxa);
                    ah.5.this.aeuk.setVisibility(8);
                  }
                  AppMethodBeat.o(256267);
                }
              });
              LinkedList localLinkedList = new LinkedList();
              localLinkedList.add(Integer.valueOf(3));
              bh.bCz();
              paramAnonymous2String = com.tencent.mm.model.c.bzA().JE(ah.f(ah.this));
              if (paramAnonymous2String != null) {}
              for (paramAnonymous2String = Util.nullAs(paramAnonymous2String.kas, "");; paramAnonymous2String = "")
              {
                locala.bqM(paramAnonymous2String);
                locala.YaS = true;
                locala.d(ah.f(ah.this), paramAnonymousView, localLinkedList);
                AppMethodBeat.o(256035);
                return;
              }
            }
          });
        }
      }
    });
    com.tencent.mm.plugin.report.service.h.OAn.b(11004, new Object[] { this.aetS, Integer.valueOf(1) });
    AppMethodBeat.o(35414);
  }
  
  public final void jsM()
  {
    AppMethodBeat.i(256073);
    if (this.hlc.aezO.hasDestory)
    {
      AppMethodBeat.o(256073);
      return;
    }
    if (this.aetO != null) {
      jsO();
    }
    if ((this.hlc.aezO.getController() != null) && (this.hlc.aezO.getMMResources() != null)) {
      this.hlc.aezO.getController().setActionbarColor(this.hlc.aezO.getMMResources().getColor(R.e.BG_2));
    }
    Object localObject = ((AppCompatActivity)this.hlc.aezO.getContext()).getSupportActionBar();
    if (localObject != null) {
      ((ActionBar)localObject).g(0.0F);
    }
    if (this.aetQ == null)
    {
      n.c(this.hlc.aezO, R.h.gch);
      this.aetQ = ((LinearLayout)this.hlc.aezO.getContext().findViewById(R.h.fIm));
    }
    this.aetQ.removeAllViews();
    localObject = (LinearLayout)this.hlc.aezO.getContext().getLayoutInflater().inflate(R.i.ghs, null);
    this.aetQ.addView((View)localObject, new ViewGroup.LayoutParams(-1, -2));
    this.aetQ.setVisibility(0);
    ((LinearLayout)localObject).setVisibility(0);
    ((com.tencent.mm.ui.chatting.component.api.q)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.q.class)).p(this.aetQ);
    AppMethodBeat.o(256073);
  }
  
  public final int jsS()
  {
    AppMethodBeat.i(35420);
    int j = 0;
    int i = j;
    if (this.aetO != null)
    {
      i = j;
      if (this.aetO.isShown()) {
        i = this.aetO.getHeight() + 0;
      }
    }
    AppMethodBeat.o(35420);
    return i;
  }
  
  public final int jsT()
  {
    AppMethodBeat.i(256083);
    if ((this.hlc.aezO.isCurrentActivity) || (!isSupportCustomActionBar())) {
      ((AppCompatActivity)this.hlc.aezO.getContext()).getSupportActionBar().a(ah(null), new ActionBar.LayoutParams(-1, -1));
    }
    for (ActionBar localActionBar = ((AppCompatActivity)this.hlc.aezO.getContext()).getSupportActionBar(); (localActionBar != null) && (localActionBar.getCustomView() != null); localActionBar = this.aetT.getSupportActionBar())
    {
      int[] arrayOfInt = new int[2];
      localActionBar.getCustomView().getLocationOnScreen(arrayOfInt);
      int i = localActionBar.getHeight();
      int j = arrayOfInt[1];
      int k = jsS();
      AppMethodBeat.o(256083);
      return i + j + k;
    }
    AppMethodBeat.o(256083);
    return 0;
  }
  
  public final ImageView jsU()
  {
    return this.aetU.adtW;
  }
  
  public final void lk(View paramView)
  {
    AppMethodBeat.i(35405);
    Log.d("MicroMsg.ChattingUI.HeaderComponent", "dealContentView");
    if (isSupportCustomActionBar())
    {
      if (this.mActionBarContainer == null) {
        this.mActionBarContainer = ((ActionBarContainer)((ViewStub)paramView.findViewById(R.h.fxE)).inflate());
      }
      com.tencent.mm.ui.ab localab = this.aetT;
      paramView = (ViewGroup)paramView;
      localab.adFj.bxO = paramView;
    }
    AppMethodBeat.o(35405);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    int j = 1;
    AppMethodBeat.i(35389);
    super.onConfigurationChanged(paramConfiguration);
    Log.d("MicroMsg.ChattingUI.HeaderComponent", "getConfiguration().orientation = " + this.hlc.aezO.getMMResources().getConfiguration().orientation + ", newConfig.orientation = " + paramConfiguration.orientation);
    this.hlc.aezO.getMMResources().getConfiguration().orientation = paramConfiguration.orientation;
    Log.i("MicroMsg.ChatFooter", "[dealOrientationChange] %s", new Object[] { ((x)this.hlc.cm(x.class)).jsd().getContext().getResources().getConfiguration() });
    int i;
    if (this.mActionBarContainer != null)
    {
      i = 1;
      if (this.aetV == null) {
        break label271;
      }
    }
    for (;;)
    {
      if ((i & j) != 0)
      {
        i = com.tencent.mm.compatible.util.a.di(this.hlc.aezO.getContext());
        this.aetV.setMinimumHeight(i);
        ViewGroup.LayoutParams localLayoutParams2 = this.aetV.getLayoutParams();
        ViewGroup.LayoutParams localLayoutParams1 = localLayoutParams2;
        if (localLayoutParams2 == null) {
          localLayoutParams1 = new ViewGroup.LayoutParams(-1, -1);
        }
        localLayoutParams1.height = i;
        this.aetV.setLayoutParams(localLayoutParams1);
        localLayoutParams1 = this.mActionBarContainer.getLayoutParams();
        localLayoutParams1.height = i;
        this.mActionBarContainer.setLayoutParams(localLayoutParams1);
      }
      if (this.aetT != null) {
        this.aetT.adFj.mActionBar.onConfigurationChanged(paramConfiguration);
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
    this.aetU.setClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(255796);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/component/HeaderComponent$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (!ah.this.hlc.aezO.isScreenEnable())
        {
          Log.w("MicroMsg.ChattingUI.HeaderComponent", "Actionbar customView onclick screen not enable");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/HeaderComponent$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(255796);
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
            AppMethodBeat.i(255968);
            if (ah.7.this.advi != null) {
              ah.7.this.advi.onMenuItemClick(null);
            }
            AppMethodBeat.o(255968);
          }
        });
        ((ap)ah.this.hlc.cm(ap.class)).jts();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/HeaderComponent$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(255796);
      }
    });
    this.aetU.jhD();
    AppMethodBeat.o(35423);
  }
  
  public final void setMMSubTitle(String paramString)
  {
    AppMethodBeat.i(35422);
    int i = com.tencent.mm.cd.a.br(this.hlc.aezO.getContext(), R.f.HintTextSize);
    paramString = p.d(this.hlc.aezO.getContext(), paramString, i);
    this.aetU.aQ(paramString);
    if ((((com.tencent.mm.plugin.textstatus.a.f)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.textstatus.a.f.class)).hasStatus(this.hlc.Uxa.field_username)) && (!com.tencent.mm.storage.au.bwE(this.hlc.getTalkerUserName())))
    {
      ((com.tencent.mm.plugin.textstatus.a.f)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.textstatus.a.f.class)).setTextStatusWithDesc(this.aetU.adtQ, this.hlc.getTalkerUserName(), a.b.ThD, a.c.ThP);
      this.aetU.adtQ.requestLayout();
      jsF();
    }
    AppMethodBeat.o(35422);
  }
  
  public final void setMMTitle(int paramInt)
  {
    AppMethodBeat.i(35402);
    setMMTitle(this.hlc.aezO.getMMResources().getString(paramInt));
    AppMethodBeat.o(35402);
  }
  
  public final void setMMTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(35421);
    if ((com.tencent.mm.storage.au.bwF(this.hlc.getTalkerUserName())) || (((com.tencent.mm.ui.chatting.component.api.g)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.g.class)).aMq()))
    {
      this.aetU.setTitle(paramCharSequence);
      this.hlc.aezO.updateDescription(this.hlc.aezO.getContext().getString(R.l.chatting_back_talker_desc, new Object[] { paramCharSequence }));
      AppMethodBeat.o(35421);
      return;
    }
    if (com.tencent.mm.storage.au.bwO(this.hlc.Uxa.field_username))
    {
      paramCharSequence = ((com.tencent.mm.openim.api.e)com.tencent.mm.kernel.h.ax(com.tencent.mm.openim.api.e.class)).e(MMApplicationContext.getContext(), paramCharSequence.toString(), com.tencent.mm.cd.a.br(MMApplicationContext.getContext(), R.f.BigTextSize));
      this.aetU.setTitle(paramCharSequence);
    }
    for (;;)
    {
      this.hlc.aezO.updateDescription(this.hlc.aezO.getContext().getString(R.l.chatting_back_talker_desc, new Object[] { paramCharSequence }));
      AppMethodBeat.o(35421);
      return;
      SpannableString localSpannableString = p.d(this.hlc.aezO.getContext(), paramCharSequence, com.tencent.mm.cd.a.br(this.hlc.aezO.getContext(), R.f.BigTextSize));
      this.aetU.setTitle(localSpannableString);
      paramCharSequence = localSpannableString;
      if (!com.tencent.mm.storage.au.bwE(this.hlc.getTalkerUserName()))
      {
        jsE();
        paramCharSequence = localSpannableString;
      }
    }
  }
  
  public final void setTitleMuteIconVisibility(int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(35426);
    if ((com.tencent.mm.storage.au.bwu(this.hlc.getTalkerUserName())) || (com.tencent.mm.storage.au.bwA(this.hlc.getTalkerUserName())))
    {
      this.aetU.KR(false);
      AppMethodBeat.o(35426);
      return;
    }
    com.tencent.mm.ui.b localb = this.aetU;
    if (paramInt == 0) {
      bool = true;
    }
    localb.KR(bool);
    AppMethodBeat.o(35426);
  }
  
  public final void setTitlePhoneIconVisibility(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(35424);
    Object localObject = this.aetU;
    if (paramInt == 0)
    {
      paramInt = 1;
      localObject = ((com.tencent.mm.ui.b)localObject).adtT;
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
    private int advp;
    public boolean aeuu;
    private y.a aeuv;
    private View lBX;
    private String path;
    
    public a(int paramInt, String paramString, y.a parama)
    {
      AppMethodBeat.i(256318);
      this.lBX = new View(ah.this.hlc.aezO.getContext());
      this.aeuu = false;
      this.advp = 0;
      this.path = paramString;
      this.aeuv = parama;
      AppMethodBeat.o(256318);
    }
    
    public final void a(com.tencent.mm.plugin.newtips.a.k paramk, boolean paramBoolean)
    {
      AppMethodBeat.i(179924);
      com.tencent.mm.plugin.newtips.a.g.a(this, paramk, paramBoolean);
      AppMethodBeat.o(179924);
    }
    
    public final boolean a(boolean paramBoolean, fng paramfng)
    {
      return false;
    }
    
    public final boolean b(boolean paramBoolean, fng paramfng)
    {
      return false;
    }
    
    public final boolean c(boolean paramBoolean, fng paramfng)
    {
      return false;
    }
    
    public final boolean d(boolean paramBoolean, fng paramfng)
    {
      return false;
    }
    
    public final boolean fZD()
    {
      return false;
    }
    
    public final String getPath()
    {
      return this.path;
    }
    
    public final View getRoot()
    {
      return this.lBX;
    }
    
    public final boolean ym(boolean paramBoolean)
    {
      AppMethodBeat.i(179925);
      paramBoolean = com.tencent.mm.plugin.newtips.a.g.a(paramBoolean, this);
      AppMethodBeat.o(179925);
      return paramBoolean;
    }
    
    public final boolean yn(boolean paramBoolean)
    {
      AppMethodBeat.i(179926);
      this.aeuu = paramBoolean;
      ah.this.hlc.aezO.updateOptionMenuRedDot(this.advp, paramBoolean);
      AppMethodBeat.o(179926);
      return true;
    }
    
    public final boolean yo(boolean paramBoolean)
    {
      return false;
    }
  }
  
  final class b
    extends com.tencent.mm.ui.ad
  {
    b() {}
    
    public final void d(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(256324);
      if (((ap)ah.this.hlc.cm(ap.class)).jto())
      {
        AppMethodBeat.o(256324);
        return;
      }
      if (com.tencent.mm.storage.au.bwF(ah.this.hlc.getTalkerUserName()))
      {
        paramMenuItem = new lf();
        paramMenuItem.uc(ah.this.hlc.getTalkerUserName());
        paramMenuItem.iuA = 4L;
        paramMenuItem.bMH();
      }
      if ((ah.a(ah.this) != null) && (ah.a(ah.this).aeuu)) {
        com.tencent.mm.plugin.newtips.a.gtf().aeI(25);
      }
      if (com.tencent.mm.storage.au.bxh(ah.this.hlc.getTalkerUserName())) {
        com.tencent.mm.plugin.report.service.h.OAn.b(19540, new Object[] { Integer.valueOf(2) });
      }
      ah.this.hlc.hideVKB();
      Object localObject;
      if (com.tencent.mm.storage.au.bwA(ah.this.hlc.getTalkerUserName()))
      {
        localObject = new Intent(ah.this.hlc.aezO.getContext(), AppBrandNotifySettingsUI.class);
        paramMenuItem = (com.tencent.mm.plugin.appbrand.service.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.h.class);
        if (paramMenuItem == null) {
          break label837;
        }
        paramMenuItem = paramMenuItem.cez();
        ((Intent)localObject).putExtra("report_session_id", paramMenuItem);
      }
      for (;;)
      {
        Activity localActivity = ah.this.hlc.aezO.getContext();
        localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(localActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/chatting/component/HeaderComponent$OptionListener", "onRealClick", "(Landroid/view/MenuItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(localActivity, "com/tencent/mm/ui/chatting/component/HeaderComponent$OptionListener", "onRealClick", "(Landroid/view/MenuItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.plugin.report.service.h.OAn.b(19724, new Object[] { Integer.valueOf(1), Integer.valueOf(6), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null, null, null, Integer.valueOf(0), null, null, Integer.valueOf(0), null, null, paramMenuItem });
        AppMethodBeat.o(256324);
        return;
        if (com.tencent.mm.model.ab.IP(ah.this.hlc.getTalkerUserName()))
        {
          paramMenuItem = new Intent();
          paramMenuItem.putExtra("Contact_User", ah.this.hlc.getTalkerUserName());
          com.tencent.mm.br.c.b(ah.this.hlc.aezO.getContext(), "profile", ".ui.ContactInfoUI", paramMenuItem);
          AppMethodBeat.o(256324);
          return;
        }
        if (((com.tencent.mm.ui.chatting.component.api.af)ah.this.hlc.cm(com.tencent.mm.ui.chatting.component.api.af.class)).jtc())
        {
          ah.b(ah.this);
          AppMethodBeat.o(256324);
          return;
        }
        if (((com.tencent.mm.ui.chatting.component.api.e)ah.this.hlc.cm(com.tencent.mm.ui.chatting.component.api.e.class)).jri())
        {
          AppMethodBeat.o(256324);
          return;
        }
        if (((com.tencent.mm.ui.chatting.component.api.k)ah.this.hlc.cm(com.tencent.mm.ui.chatting.component.api.k.class)).jrF()) {
          ((PluginGameLife)com.tencent.mm.kernel.h.az(PluginGameLife.class)).jumpToGameLifeSingleChatInfoUIReport(ah.this.hlc.getTalkerUserName());
        }
        if (((com.tencent.mm.ui.chatting.component.api.r)ah.this.hlc.cm(com.tencent.mm.ui.chatting.component.api.r.class)).jrT()) {
          ((com.tencent.mm.plugin.textstatus.a.r)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.textstatus.a.r.class)).dh(ah.this.hlc.getTalkerUserName(), 153);
        }
        if (com.tencent.mm.storage.au.bwQ(ah.this.hlc.getTalkerUserName())) {
          com.tencent.mm.openim.d.a.bm(ah.this.hlc.getTalkerUserName(), 5);
        }
        localObject = new Intent();
        ((Intent)localObject).setClass(ah.this.hlc.aezO.getContext(), SingleChatInfoUI.class);
        ((Intent)localObject).putExtra("Single_Chat_Talker", ah.this.hlc.getTalkerUserName());
        ((Intent)localObject).putExtra("fromChatting", true);
        paramMenuItem = ah.this.hlc.aezO;
        localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/chatting/component/HeaderComponent$OptionListener", "onRealClick", "(Landroid/view/MenuItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramMenuItem, "com/tencent/mm/ui/chatting/component/HeaderComponent$OptionListener", "onRealClick", "(Landroid/view/MenuItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(256324);
        return;
        label837:
        paramMenuItem = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.ah
 * JD-Core Version:    0.7.0.1
 */