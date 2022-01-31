package com.tencent.mm.ui.chatting.b;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
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
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ag.d.a;
import com.tencent.mm.ag.o;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.af;
import com.tencent.mm.model.au;
import com.tencent.mm.model.b.b.a;
import com.tencent.mm.model.b.b.b;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.chatting.ag;
import com.tencent.mm.ui.chatting.b.b.n;
import com.tencent.mm.ui.chatting.b.b.q;
import com.tencent.mm.ui.conversation.a.e.a;
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.x;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.chatting.b.a.a(cFA=q.class)
public class t
  extends a
  implements q
{
  private int ocd = 0;
  private final j.a voW = new t.4(this);
  private boolean voZ = false;
  protected LinearLayout vqH;
  protected LinearLayout vqI;
  private List<String> vqJ = new LinkedList();
  private String vqK;
  private ActionBarContainer vqL = null;
  public com.tencent.mm.ui.t vqM = null;
  private com.tencent.mm.ui.b vqN;
  private View vqO;
  final v vqP = new t.a(this);
  private b.a vqQ = new t.1(this);
  private final d.a vqR = new t.3(this);
  private MenuItem.OnMenuItemClickListener vqS = new t.7(this);
  final int vqT = 1;
  final int vqU = 2;
  final MenuItem.OnMenuItemClickListener vqV = new t.8(this);
  private View vqW = null;
  private View vqX = null;
  
  private void cBS()
  {
    if (com.tencent.mm.model.s.hg(this.byx.getTalkerUserName()))
    {
      com.tencent.mm.plugin.y.a.bov();
      boolean bool = com.tencent.mm.aw.c.iW(com.tencent.mm.aw.b.evh);
      this.byx.vtz.addIconOptionMenu(0, R.l.actionbar_title_setting, R.k.actionbar_setting_icon, Boolean.valueOf(bool).booleanValue(), this.vqP);
    }
  }
  
  private void cEI()
  {
    if (this.byx.vtz.getContext() == null) {
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.ChattingUI.HeaderComponent", "getActivity is null");
    }
    ViewGroup localViewGroup;
    com.tencent.mm.pluginsdk.ui.b.a locala;
    do
    {
      return;
      cEO();
      localViewGroup = (ViewGroup)this.byx.vtz.getContext().findViewById(R.h.chatting_banner_content);
      locala = com.tencent.mm.ui.conversation.a.e.a(this.byx.vtz.getContext(), e.a.vUA, new Object[] { b.b.dYr });
    } while ((localViewGroup == null) || (locala == null) || (locala.getView() == null) || (this.vqX != null));
    this.vqX = locala.getView();
    localViewGroup.addView(this.vqX, new ViewGroup.LayoutParams(-1, -2));
  }
  
  private void cEK()
  {
    if ((this.byx.cFE()) || (this.vqH == null)) {
      return;
    }
    cEL();
    com.tencent.mm.pluginsdk.ui.b.a locala = com.tencent.mm.ui.conversation.a.e.a(this.byx.vtz.getContext(), e.a.vUr, new Object[] { this.byx.getTalkerUserName(), this.byx.cDP() });
    if ((locala != null) && (locala.getView() != null))
    {
      this.vqH.addView(locala.getView(), new ViewGroup.LayoutParams(-1, -2));
      this.vqH.setVisibility(0);
    }
    h.nFQ.f(11003, new Object[] { this.byx.getTalkerUserName(), Integer.valueOf(1), Integer.valueOf(0) });
  }
  
  private void cEL()
  {
    if (this.vqH != null) {
      this.vqH.removeAllViews();
    }
    if (this.vqI != null)
    {
      this.vqI.setVisibility(8);
      this.vqI.removeAllViews();
    }
  }
  
  private void cEM()
  {
    if (this.byx.vtz.getContext() == null) {
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.ChattingUI.HeaderComponent", "getActivity is null");
    }
    ViewGroup localViewGroup;
    com.tencent.mm.pluginsdk.ui.b.a locala;
    do
    {
      return;
      cEN();
      localViewGroup = (ViewGroup)this.byx.vtz.getContext().findViewById(R.h.chatting_content);
      locala = com.tencent.mm.ui.conversation.a.e.a(this.byx.vtz.getContext(), e.a.vUs, new Object[] { this.byx.getTalkerUserName(), this.byx.cDP(), Boolean.valueOf(this.byx.cFE()) });
    } while ((localViewGroup == null) || (locala == null) || (locala.getView() == null) || (this.vqW != null));
    this.vqW = locala.getView();
    localViewGroup.addView(this.vqW, new ViewGroup.LayoutParams(-1, -2));
  }
  
  private void cEN()
  {
    ViewGroup localViewGroup = (ViewGroup)this.byx.vtz.getContext().findViewById(R.h.chatting_content);
    if ((localViewGroup != null) && (this.vqW != null))
    {
      localViewGroup.removeView(this.vqW);
      this.vqW = null;
    }
  }
  
  private void cEO()
  {
    ViewGroup localViewGroup = (ViewGroup)this.byx.vtz.getContext().findViewById(R.h.chatting_banner_content);
    if ((localViewGroup != null) && (this.vqX != null))
    {
      localViewGroup.removeView(this.vqX);
      this.vqX = null;
    }
  }
  
  private boolean isSupportCustomActionBar()
  {
    return this.byx.vtz.isSupportNavigationSwipeBack();
  }
  
  private View r(ViewGroup paramViewGroup)
  {
    if (this.vqO == null)
    {
      if (paramViewGroup == null) {}
      for (this.vqO = com.tencent.mm.ui.y.gt(this.byx.vtz.getContext()).inflate(R.i.actionbar_custom_area, null);; this.vqO = com.tencent.mm.ui.y.gt(this.byx.vtz.getContext()).inflate(R.i.actionbar_custom_area, paramViewGroup, false)) {
        return this.vqO;
      }
    }
    if (this.vqO.getParent() == null) {
      return this.vqO;
    }
    if ((this.vqO.getParent() instanceof ViewGroup))
    {
      ((ViewGroup)this.vqO.getParent()).removeView(this.vqO);
      return this.vqO;
    }
    if (paramViewGroup == null) {}
    for (this.vqO = com.tencent.mm.ui.y.gt(this.byx.vtz.getContext()).inflate(R.i.actionbar_custom_area, null);; this.vqO = com.tencent.mm.ui.y.gt(this.byx.vtz.getContext()).inflate(R.i.actionbar_custom_area, paramViewGroup, false)) {
      return this.vqO;
    }
  }
  
  public final void Hb(int paramInt)
  {
    int i = 0;
    Object localObject = this.vqN;
    if (paramInt == 0)
    {
      paramInt = 1;
      localObject = ((com.tencent.mm.ui.b)localObject).uGt;
      if (paramInt == 0) {
        break label35;
      }
    }
    label35:
    for (paramInt = i;; paramInt = 8)
    {
      ((ImageView)localObject).setVisibility(paramInt);
      return;
      paramInt = 0;
      break;
    }
  }
  
  public final void N(CharSequence paramCharSequence)
  {
    if (com.tencent.mm.model.s.hb(this.byx.getTalkerUserName()))
    {
      this.vqN.setTitle(paramCharSequence);
      this.byx.vtz.updateDescription(this.byx.vtz.getContext().getString(R.l.chatting_back_talker_desc, new Object[] { paramCharSequence }));
      return;
    }
    if (ad.aaU(this.byx.pSb.field_username))
    {
      com.tencent.mm.openim.a.b localb = (com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.r(com.tencent.mm.openim.a.b.class);
      Context localContext = ae.getContext();
      paramCharSequence = paramCharSequence.toString();
      String str = this.byx.pSb.field_openImAppid;
      paramCharSequence = localb.d(localContext, paramCharSequence, com.tencent.mm.cb.a.aa(ae.getContext(), R.f.BigTextSize));
      this.vqN.setTitle(paramCharSequence);
      this.byx.vtz.updateDescription(this.byx.vtz.getContext().getString(R.l.chatting_back_talker_desc, new Object[] { paramCharSequence }));
      return;
    }
    paramCharSequence = j.b(this.byx.vtz.getContext(), paramCharSequence, com.tencent.mm.cb.a.aa(this.byx.vtz.getContext(), R.f.BigTextSize));
    this.vqN.setTitle(paramCharSequence);
    this.byx.vtz.updateDescription(this.byx.vtz.getContext().getString(R.l.chatting_back_talker_desc, new Object[] { paramCharSequence }));
  }
  
  public final void a(com.tencent.mm.ui.chatting.c.a parama)
  {
    super.a(parama);
    if (isSupportCustomActionBar())
    {
      this.vqM = new com.tencent.mm.ui.t();
      parama = this.vqM;
      com.tencent.mm.ui.chatting.e locale = this.byx.vtz;
      parama.uNW = locale;
      parama.uNX = new com.tencent.mm.ui.b.b(locale.thisActivity(), parama);
      this.byx.vtz.setActivityController(this.vqM);
    }
  }
  
  public final com.tencent.mm.ui.t cCn()
  {
    return this.vqM;
  }
  
  public final void cED()
  {
    if (this.byx.getHeaderViewsCount() > 0) {
      this.vqH = ((LinearLayout)this.byx.getListView().findViewById(R.h.list_header));
    }
    for (;;)
    {
      this.vqH.removeAllViews();
      cEH();
      return;
      this.vqH = ((LinearLayout)this.byx.vtz.getContext().getLayoutInflater().inflate(R.i.chatting_list_header_container, null));
      com.tencent.mm.ui.chatting.c.a locala = this.byx;
      LinearLayout localLinearLayout = this.vqH;
      locala.vtA.addHeaderView(localLinearLayout);
    }
  }
  
  public final void cEE()
  {
    this.byx.vtz.setMMSubTitle(null);
    if (com.tencent.mm.model.s.hg(this.byx.getTalkerUserName())) {
      N(this.byx.pSb.Bp());
    }
    do
    {
      do
      {
        Object localObject;
        do
        {
          return;
          if (((com.tencent.mm.ui.chatting.b.b.y)this.byx.ac(com.tencent.mm.ui.chatting.b.b.y.class)).cFk())
          {
            setMMTitle(R.l.search_chat_content);
            return;
          }
          if (ad.aaR(this.byx.getTalkerUserName()))
          {
            ((n)this.byx.ac(n.class)).cEq().setWordCountLimit(140);
            N(this.byx.pSb.Bq());
            return;
          }
          if (com.tencent.mm.model.s.hR(this.byx.getTalkerUserName()))
          {
            N(this.byx.pSb.Bp());
            return;
          }
          if (ad.hd(this.byx.getTalkerUserName()))
          {
            Activity localActivity = this.byx.vtz.getContext();
            int i = R.l.bottle_chatting_from_city;
            ad localad = this.byx.pSb;
            if (localad != null) {
              if (RegionCodeDecoder.acl(localad.getCountryCode()))
              {
                localObject = localad.getCity();
                if (bk.bl((String)localObject)) {}
              }
            }
            for (;;)
            {
              N(localActivity.getString(i, new Object[] { localObject }).trim());
              return;
              String str = r.gX(localad.getProvince());
              localObject = str;
              if (bk.bl(str))
              {
                RegionCodeDecoder.cvV();
                localObject = RegionCodeDecoder.getLocName(localad.getCountryCode());
                continue;
                str = r.gX(localad.getProvince());
                localObject = str;
                if (bk.bl(str)) {
                  localObject = this.byx.vtz.getContext().getString(R.l.bottle_unknowed_city);
                }
              }
            }
          }
          if (!this.byx.cFD()) {
            break;
          }
          if (com.tencent.mm.model.s.ha(this.byx.getTalkerUserName()))
          {
            if (bk.bl(this.byx.pSb.field_nickname))
            {
              if (com.tencent.mm.model.m.gM(this.byx.getTalkerUserName()) == 0)
              {
                N(this.byx.vtz.getContext().getString(R.l.chatting_roominfo_noname));
                return;
              }
              N(this.byx.vtz.getContext().getString(R.l.fmt_chatting_title_group, new Object[] { this.byx.vtz.getContext().getString(R.l.chatting_roominfo_noname), Integer.valueOf(com.tencent.mm.model.m.gM(this.byx.getTalkerUserName())) }));
              return;
            }
            N(this.byx.vtz.getContext().getString(R.l.fmt_chatting_title_group, new Object[] { this.byx.pSb.Bp(), Integer.valueOf(com.tencent.mm.model.m.gM(this.byx.getTalkerUserName())) }));
            return;
          }
        } while (!com.tencent.mm.model.s.hb(this.byx.getTalkerUserName()));
        if (bk.bl(this.byx.pSb.field_nickname)) {
          if (com.tencent.mm.model.m.gM(this.byx.getTalkerUserName()) == 0) {
            localObject = this.byx.vtz.getContext().getString(R.l.chatting_roominfo_noname);
          }
        }
        for (;;)
        {
          N(j.f(this.byx.vtz.getContext(), j.b(this.byx.vtz.getContext(), (CharSequence)localObject, com.tencent.mm.cb.a.aa(this.byx.vtz.getContext(), R.f.BigTextSize)), R.k.open_im_title_logo));
          return;
          localObject = this.byx.vtz.getContext().getString(R.l.fmt_chatting_title_group, new Object[] { this.byx.vtz.getContext().getString(R.l.chatting_roominfo_noname), Integer.valueOf(com.tencent.mm.model.m.gM(this.byx.getTalkerUserName())) });
          continue;
          localObject = this.byx.vtz.getContext().getString(R.l.fmt_chatting_title_group, new Object[] { this.byx.pSb.Bp(), Integer.valueOf(com.tencent.mm.model.m.gM(this.byx.getTalkerUserName())) });
        }
      } while (((com.tencent.mm.ui.chatting.b.b.c)this.byx.ac(com.tencent.mm.ui.chatting.b.b.c.class)).cDI());
      this.vqN.mG(ad.aaT(this.byx.getTalkerUserName()));
      this.byx.vtz.setMMTitle(this.byx.pSb.Bq());
      this.vqN.mG(ad.aaT(this.byx.getTalkerUserName()));
    } while (!ad.aaU(this.byx.getTalkerUserName()));
    this.byx.vtz.setMMSubTitle(((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.r(com.tencent.mm.openim.a.b.class)).aK(this.byx.pSb.field_openImAppid, this.byx.pSb.field_descWordingId));
  }
  
  public final void cEF()
  {
    Object localObject1;
    Object localObject2;
    if ((this.byx.vtz.isCurrentActivity) || (!isSupportCustomActionBar()))
    {
      localObject1 = ((AppCompatActivity)this.byx.vtz.getContext()).getSupportActionBar();
      localObject2 = r(null);
      ((ActionBar)localObject1).setCustomView((View)localObject2);
      this.vqN = new com.tencent.mm.ui.b((View)localObject2);
      boolean bool = ae.getContext().getSharedPreferences(ae.cqR() + "_redesign", 4).getBoolean("dark_actionbar", false);
      if (((ActionBar)localObject1).getCustomView() != null)
      {
        localObject2 = (ImageView)((ActionBar)localObject1).getCustomView().findViewById(R.h.arrow_area_btn);
        if ((localObject2 != null) && (bool))
        {
          if (((ImageView)localObject2).getDrawable() == null) {
            break label644;
          }
          ((ImageView)localObject2).getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
        }
        label157:
        localObject2 = (TextView)((ActionBar)localObject1).getCustomView().findViewById(R.h.title_area);
        if ((localObject2 != null) && (bool)) {
          ((TextView)localObject2).setTextColor(this.byx.vtz.getMMResources().getColor(R.e.white_text_color));
        }
        localObject2 = (TextView)((ActionBar)localObject1).getCustomView().findViewById(R.h.sub_title_area);
        if ((localObject2 != null) && (bool)) {
          ((TextView)localObject2).setTextColor(this.byx.vtz.getMMResources().getColor(R.e.white_text_color));
        }
        localObject2 = (ImageView)((ActionBar)localObject1).getCustomView().findViewById(R.h.mute_icon);
        if ((localObject2 != null) && (bool))
        {
          if (((ImageView)localObject2).getDrawable() == null) {
            break label656;
          }
          ((ImageView)localObject2).getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
        }
        label294:
        localObject2 = (ImageView)((ActionBar)localObject1).getCustomView().findViewById(R.h.phone_icon);
        if ((localObject2 != null) && (bool))
        {
          if (((ImageView)localObject2).getDrawable() == null) {
            break label668;
          }
          ((ImageView)localObject2).getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
        }
      }
    }
    for (;;)
    {
      this.vqN.mG(false);
      ((ActionBar)localObject1).setDisplayOptions((((ActionBar)localObject1).getDisplayOptions() | 0x10) & 0xFFFFFFFB & 0xFFFFFFFD & 0xFFFFFFF7);
      this.vqJ.clear();
      this.vqJ.add(this.byx.vtz.getStringExtra("Chat_User"));
      setBackBtn(this.vqS);
      return;
      localObject1 = (ViewGroup)this.vqL.findViewById(R.h.action_bar);
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUI.HeaderComponent", "mActionBarContainer %s", new Object[] { this.vqL });
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUI.HeaderComponent", "ctxView %s", new Object[] { this.vqL.findViewById(R.h.action_context_bar) });
      ((ViewGroup)localObject1).setVisibility(0);
      localObject2 = this.vqM.getSupportActionBar();
      View localView = r((ViewGroup)localObject1);
      ((ActionBar)localObject2).setCustomView(localView);
      this.vqN = new com.tencent.mm.ui.b(localView);
      int j = ((ActionBar)localObject2).getHeight();
      int i = j;
      if (j == 0)
      {
        localObject1 = this.byx.vtz.getMMResources().getDisplayMetrics();
        if (((DisplayMetrics)localObject1).widthPixels <= ((DisplayMetrics)localObject1).heightPixels) {
          break label624;
        }
      }
      label624:
      for (i = this.byx.vtz.getMMResources().getDimensionPixelSize(R.f.DefaultActionbarHeightLand);; i = this.byx.vtz.getMMResources().getDimensionPixelSize(R.f.DefaultActionbarHeightPort))
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
      label644:
      ((ImageView)localObject2).setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      break label157;
      label656:
      ((ImageView)localObject2).setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      break label294;
      label668:
      ((ImageView)localObject2).setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
    }
  }
  
  public final void cEG()
  {
    Object localObject = (com.tencent.mm.ui.chatting.b.b.y)this.byx.ac(com.tencent.mm.ui.chatting.b.b.y.class);
    if ((((com.tencent.mm.ui.chatting.b.b.y)localObject).cFk()) || (((com.tencent.mm.ui.chatting.b.b.y)localObject).cFj())) {
      this.byx.showOptionMenu(false);
    }
    while (((com.tencent.mm.ui.chatting.b.b.m)this.byx.ac(com.tencent.mm.ui.chatting.b.b.m.class)).cEp()) {
      return;
    }
    this.byx.vtz.removeAllOptionMenu();
    if (com.tencent.mm.model.s.hg(this.byx.getTalkerUserName()))
    {
      com.tencent.mm.plugin.y.a.bov();
      boolean bool = com.tencent.mm.aw.c.iW(com.tencent.mm.aw.b.evh);
      this.byx.vtz.addIconOptionMenu(0, R.l.actionbar_title_setting, R.k.actionbar_setting_icon, Boolean.valueOf(bool).booleanValue(), this.vqP);
    }
    while (ad.hd(this.byx.getTalkerUserName()))
    {
      this.byx.np(true);
      return;
      if (com.tencent.mm.model.s.hh(this.byx.getTalkerUserName()))
      {
        this.byx.vtz.addIconOptionMenu(0, R.l.actionbar_title_setting, R.k.actionbar_setting_icon, this.vqP);
      }
      else if (com.tencent.mm.model.s.ho(this.byx.getTalkerUserName()))
      {
        this.byx.vtz.addIconOptionMenu(0, R.l.actionbar_title_setting, R.k.actionbar_setting_icon, this.vqP);
        h.nFQ.aC(10071, "1");
      }
      else if (com.tencent.mm.model.s.hp(this.byx.getTalkerUserName()))
      {
        this.byx.vtz.addIconOptionMenu(0, R.l.actionbar_title_setting, R.k.actionbar_setting_icon, this.vqP);
      }
      else if (com.tencent.mm.model.s.hP(this.byx.getTalkerUserName()))
      {
        this.byx.vtz.addIconOptionMenu(0, R.l.actionbar_title_setting, R.k.actionbar_setting_icon, this.vqP);
      }
      else if (com.tencent.mm.model.s.hU(this.byx.getTalkerUserName()))
      {
        if (com.tencent.mm.model.s.hA(this.byx.getTalkerUserName()))
        {
          this.byx.showOptionMenu(false);
          return;
        }
        this.byx.vtz.addIconOptionMenu(0, R.l.actionbar_title_setting, R.k.actionbar_setting_icon, this.vqP);
      }
      else if ((ad.aaR(this.byx.getTalkerUserName())) || (ad.aaT(this.byx.getTalkerUserName())) || (ad.hd(this.byx.getTalkerUserName())))
      {
        this.byx.vtz.addIconOptionMenu(0, R.l.chatting_profile_desc, R.k.actionbar_icon_dark_more, this.vqP);
      }
      else if ((((com.tencent.mm.ui.chatting.b.b.u)this.byx.ac(com.tencent.mm.ui.chatting.b.b.u.class)).cFc()) && (i.ads(this.byx.getTalkerUserName())))
      {
        this.byx.vtz.addIconOptionMenu(0, R.l.chatting_profile_desc, R.k.ofm_add_icon, this.vqP);
      }
      else
      {
        localObject = (com.tencent.mm.ui.chatting.b.b.c)this.byx.ac(com.tencent.mm.ui.chatting.b.b.c.class);
        if ((this.byx.getTalkerUserName().endsWith("@chatroom")) || (com.tencent.mm.model.s.gZ(this.byx.getTalkerUserName())) || (((com.tencent.mm.ui.chatting.b.b.c)localObject).cDG()))
        {
          if (((com.tencent.mm.ui.chatting.b.b.e)this.byx.ac(com.tencent.mm.ui.chatting.b.b.e.class)).cDY())
          {
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUI.HeaderComponent", "cpan show chatroom right btn");
            this.byx.vtz.addIconOptionMenu(0, R.l.chatting_profile_desc, R.k.actionbar_icon_dark_more, this.vqP);
            this.byx.showOptionMenu(true);
          }
          else if ((((com.tencent.mm.ui.chatting.b.b.c)localObject).cDG()) && (!((com.tencent.mm.ui.chatting.b.b.c)localObject).cDH()))
          {
            this.byx.vtz.addIconOptionMenu(0, R.l.chatting_profile_desc, R.k.actionbar_particular_icon, this.vqP);
            this.byx.showOptionMenu(true);
          }
          else
          {
            this.byx.showOptionMenu(false);
          }
        }
        else
        {
          int i;
          if (1 == bk.getInt(com.tencent.mm.m.g.AA().getValue("VOIPShowInChat"), 0))
          {
            i = 1;
            label678:
            if ((i != 0) && (!com.tencent.mm.model.s.hl(this.byx.getTalkerUserName())) && (!com.tencent.mm.model.s.fn(this.byx.getTalkerUserName())) && (!ad.aaR(this.byx.getTalkerUserName())) && (!ad.aaT(this.byx.getTalkerUserName())) && (!ad.hd(this.byx.getTalkerUserName())))
            {
              if (1 != bk.getInt(com.tencent.mm.m.g.AA().getValue("VOIPCallType"), 0)) {
                break label827;
              }
              this.byx.vtz.addIconOptionMenu(2, R.l.chatting_voip_video, R.k.actionbar_voip_video_icon, this.vqV);
            }
          }
          for (;;)
          {
            if (!com.tencent.mm.model.s.hl(this.byx.getTalkerUserName())) {
              break label851;
            }
            this.byx.vtz.addIconOptionMenu(0, R.l.chatting_profile_desc, R.k.actionbar_particular_icon, this.vqP);
            break;
            i = 0;
            break label678;
            label827:
            this.byx.vtz.addIconOptionMenu(1, R.l.chatting_voip_voice, R.k.actionbar_voip_voice_icon, this.vqV);
          }
          label851:
          this.byx.vtz.addIconOptionMenu(0, R.l.chatting_profile_desc, R.k.actionbar_icon_dark_more, this.vqP);
        }
      }
    }
    this.byx.showOptionMenu(true);
  }
  
  public final void cEH()
  {
    if (this.byx == null)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.ChattingUI.HeaderComponent", "[updateBannerStatus] mChattingContext == null!");
      return;
    }
    if (!this.byx.cFE()) {
      if ((i.ads(this.byx.getTalkerUserName())) && (!((com.tencent.mm.ui.chatting.b.b.u)this.byx.ac(com.tencent.mm.ui.chatting.b.b.u.class)).cFc()))
      {
        this.vqK = this.byx.getTalkerUserName();
        cEJ();
      }
    }
    for (;;)
    {
      cEM();
      cEI();
      return;
      if (!((com.tencent.mm.ui.chatting.b.b.s)this.byx.ac(com.tencent.mm.ui.chatting.b.b.s.class)).cEX())
      {
        cEL();
        cEK();
        continue;
        String str = this.byx.getTalkerUserName();
        au.Hx();
        com.tencent.mm.storage.u localu = com.tencent.mm.model.c.FF().in(str);
        int i;
        if ((localu != null) && (localu.MN().size() == 2))
        {
          int j = localu.MN().size();
          i = 0;
          label171:
          if (i < j)
          {
            str = (String)localu.MN().get(i);
            if (!i.ads(str)) {}
          }
        }
        for (;;)
        {
          this.vqK = str;
          if ((bk.bl(this.vqK)) || ((!((com.tencent.mm.ui.chatting.b.b.e)this.byx.ac(com.tencent.mm.ui.chatting.b.b.e.class)).cDY()) && (!((com.tencent.mm.ui.chatting.b.b.c)this.byx.ac(com.tencent.mm.ui.chatting.b.b.c.class)).cDM()))) {
            break label274;
          }
          cEJ();
          break;
          i += 1;
          break label171;
          str = null;
        }
        label274:
        cEL();
      }
    }
  }
  
  @SuppressLint({"ResourceType"})
  public final void cEJ()
  {
    cEL();
    if (this.vqI == null)
    {
      i.a(this.byx.vtz, R.h.viewstub_fixheader);
      this.vqI = ((LinearLayout)this.byx.vtz.getContext().findViewById(R.h.fixed_header));
    }
    this.vqI.setVisibility(0);
    LinearLayout localLinearLayout = (LinearLayout)this.byx.vtz.getContext().getLayoutInflater().inflate(R.i.chatting_list_header, null);
    ImageView localImageView = (ImageView)localLinearLayout.findViewById(R.h.add_friends_avatar);
    String str = this.vqK;
    Object localObject = str;
    if (bk.bl(str)) {
      localObject = this.byx.pSb.field_username;
    }
    localObject = com.tencent.mm.ag.b.a((String)localObject, false, -1);
    if (localObject == null) {
      localImageView.setImageResource(R.k.default_avatar);
    }
    for (;;)
    {
      localObject = (Button)localLinearLayout.findViewById(R.h.chatting_addcontact_btn);
      if (((com.tencent.mm.ui.chatting.b.b.s)this.byx.ac(com.tencent.mm.ui.chatting.b.b.s.class)).cEW()) {
        ((com.tencent.mm.ui.chatting.b.b.s)this.byx.ac(com.tencent.mm.ui.chatting.b.b.s.class)).a((Button)localObject, localLinearLayout, this.vqI);
      }
      localImageView.setOnClickListener(new t.9(this));
      ((Button)localObject).setOnClickListener(new t.10(this, localLinearLayout));
      h.nFQ.f(11004, new Object[] { this.vqK, Integer.valueOf(1) });
      this.vqI.addView(localLinearLayout, new ViewGroup.LayoutParams(-1, -2));
      return;
      localImageView.setImageBitmap((Bitmap)localObject);
    }
  }
  
  public final int cEP()
  {
    int j = 0;
    int i = j;
    if (this.vqH != null)
    {
      i = j;
      if (this.vqH.isShown()) {
        i = this.vqH.getHeight() + 0;
      }
    }
    return i;
  }
  
  public final void cyM()
  {
    cEF();
  }
  
  public final void cyN()
  {
    this.ocd = this.byx.vtz.getIntExtra("add_scene", 0);
    o.JQ().a(this.vqR);
    au.Hx();
    com.tencent.mm.model.c.FF().c(this.voW);
    setBackBtn(this.vqS);
    cBS();
    cEE();
    cEG();
    this.voZ = true;
  }
  
  public final void cyO() {}
  
  public final void cyP()
  {
    au.Hx().FX().a(new t.5(this));
    au.Hx().FY().a(new t.6(this));
    com.tencent.mm.model.b.b localb = au.Hx().FZ();
    b.a locala = this.vqQ;
    try
    {
      localb.mListeners.add(locala);
      if (!this.voZ) {
        cBS();
      }
      cEH();
      this.voZ = false;
      return;
    }
    finally {}
  }
  
  public final void cyQ()
  {
    if (com.tencent.mm.kernel.g.DN().Dc())
    {
      au.Hx().FX().a(null);
      au.Hx().FY().a(null);
      com.tencent.mm.model.b.b localb = au.Hx().FZ();
      b.a locala = this.vqQ;
      try
      {
        localb.mListeners.remove(locala);
        return;
      }
      finally {}
    }
  }
  
  public final void cyR()
  {
    o.JQ().b(this.vqR);
    au.Hx();
    com.tencent.mm.model.c.FF().d(this.voW);
  }
  
  public final void dJ(View paramView)
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.ChattingUI.HeaderComponent", "dealContentView");
    if (isSupportCustomActionBar())
    {
      if (this.vqL == null) {
        this.vqL = ((ActionBarContainer)((ViewStub)paramView.findViewById(R.h.chatting_custom_action_bar)).inflate());
      }
      com.tencent.mm.ui.t localt = this.vqM;
      paramView = (ViewGroup)paramView;
      localt.uNX.MY = paramView;
    }
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    int j = 1;
    super.onConfigurationChanged(paramConfiguration);
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.ChattingUI.HeaderComponent", "getConfiguration().orientation = " + this.byx.vtz.getMMResources().getConfiguration().orientation + ", newConfig.orientation = " + paramConfiguration.orientation);
    this.byx.vtz.getMMResources().getConfiguration().orientation = paramConfiguration.orientation;
    ((n)this.byx.ac(n.class)).cEq().si();
    int i;
    if (this.vqL != null)
    {
      i = 1;
      if (this.vqO == null) {
        break label238;
      }
    }
    for (;;)
    {
      if ((i & j) != 0)
      {
        i = com.tencent.mm.compatible.util.a.bh(this.byx.vtz.getContext());
        this.vqO.setMinimumHeight(i);
        ViewGroup.LayoutParams localLayoutParams2 = this.vqO.getLayoutParams();
        ViewGroup.LayoutParams localLayoutParams1 = localLayoutParams2;
        if (localLayoutParams2 == null) {
          localLayoutParams1 = new ViewGroup.LayoutParams(-1, -1);
        }
        localLayoutParams1.height = i;
        this.vqO.setLayoutParams(localLayoutParams1);
        localLayoutParams1 = this.vqL.getLayoutParams();
        localLayoutParams1.height = i;
        this.vqL.setLayoutParams(localLayoutParams1);
      }
      if (this.vqM != null) {
        this.vqM.uNX.mActionBar.onConfigurationChanged(paramConfiguration);
      }
      return;
      i = 0;
      break;
      label238:
      j = 0;
    }
  }
  
  public final void setBackBtn(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.vqN.d(new t.2(this, paramOnMenuItemClickListener));
  }
  
  public final void setMMSubTitle(String paramString)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUI.HeaderComponent", "now connect state, text : %s", new Object[] { paramString });
    int i = com.tencent.mm.cb.a.aa(this.byx.vtz.getContext(), R.f.HintTextSize);
    paramString = j.b(this.byx.vtz.getContext(), paramString, i);
    com.tencent.mm.ui.b localb = this.vqN;
    if ((paramString == null) || (bk.bl(paramString.toString()))) {
      localb.uGq.setVisibility(8);
    }
    do
    {
      return;
      localb.uGq.setVisibility(0);
      localb.uGq.setText(paramString);
    } while (!com.tencent.mm.cb.a.fh(localb.uGq.getContext()));
    localb.uGq.setTextSize(1, 14.0F);
    localb.eXO.setTextSize(1, 18.0F);
  }
  
  public final void setMMTitle(int paramInt)
  {
    N(this.byx.vtz.getMMResources().getString(paramInt));
  }
  
  public final void setTitleMuteIconVisibility(int paramInt)
  {
    boolean bool = false;
    if (com.tencent.mm.model.s.hP(this.byx.getTalkerUserName()))
    {
      this.vqN.mF(false);
      return;
    }
    com.tencent.mm.ui.b localb = this.vqN;
    if (paramInt == 0) {
      bool = true;
    }
    localb.mF(bool);
  }
  
  public final void setTitlePhoneIconVisibility(int paramInt)
  {
    int i = 0;
    Object localObject = this.vqN;
    if (paramInt == 0)
    {
      paramInt = 1;
      localObject = ((com.tencent.mm.ui.b)localObject).uGr;
      if (paramInt == 0) {
        break label35;
      }
    }
    label35:
    for (paramInt = i;; paramInt = 8)
    {
      ((ImageView)localObject).setVisibility(paramInt);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.t
 * JD-Core Version:    0.7.0.1
 */