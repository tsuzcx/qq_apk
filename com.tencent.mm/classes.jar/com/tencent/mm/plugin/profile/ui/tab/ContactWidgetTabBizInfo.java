package com.tencent.mm.plugin.profile.ui.tab;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.GestureDetector.OnGestureListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.x;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import androidx.viewpager.widget.ViewPager.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.an.af;
import com.tencent.mm.api.c.a;
import com.tencent.mm.api.c.b;
import com.tencent.mm.autogen.a.au.a;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.findersdk.a.br;
import com.tencent.mm.plugin.findersdk.a.br.a;
import com.tencent.mm.plugin.profile.ui.ContactInfoUI;
import com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoSettingUI;
import com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.1;
import com.tencent.mm.plugin.profile.ui.tab.data.BizProfileDataFetcher;
import com.tencent.mm.plugin.profile.ui.tab.list.BaseBizProfileFragment;
import com.tencent.mm.plugin.profile.ui.tab.list.BizProfileErrorFragment;
import com.tencent.mm.plugin.profile.ui.tab.list.BizProfileTabMsgFragment;
import com.tencent.mm.plugin.profile.ui.tab.list.BizProfileTabVideoFragment;
import com.tencent.mm.plugin.profile.ui.tab.observer.BizProfileExtraOperateObserver;
import com.tencent.mm.plugin.profile.ui.tab.observer.BizProfileWidgetOperateObserver;
import com.tencent.mm.plugin.profile.ui.tab.view.BizProfileTabLayout;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.ahl;
import com.tencent.mm.protocal.protobuf.bkk;
import com.tencent.mm.protocal.protobuf.nj;
import com.tencent.mm.protocal.protobuf.ol;
import com.tencent.mm.protocal.protobuf.pj;
import com.tencent.mm.protocal.protobuf.py;
import com.tencent.mm.protocal.protobuf.qm;
import com.tencent.mm.protocal.protobuf.re;
import com.tencent.mm.protocal.protobuf.rf;
import com.tencent.mm.protocal.protobuf.rg;
import com.tencent.mm.protocal.protobuf.rp;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.f.s;
import com.tencent.mm.ui.y.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.f;
import kotlin.g.b.am;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizInfo;", "Lcom/tencent/mm/pluginsdk/deprecated/IBodyWidgetEx;", "Landroidx/lifecycle/LifecycleObserver;", "context", "Lcom/tencent/mm/plugin/profile/ui/ContactInfoUI;", "brandIconUrl", "", "customizedInfo", "Lcom/tencent/mm/protocal/protobuf/CustomizedInfo;", "enterTime", "", "(Lcom/tencent/mm/plugin/profile/ui/ContactInfoUI;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/CustomizedInfo;J)V", "AT_SELECT_BIZ_CARD", "", "BIZ_REPORT_URL", "CRASH_FLAG", "MENU_ID_ADD_STAR", "MENU_ID_COMPLAIN", "MENU_ID_MORE", "MENU_ID_REMOVE_STAR", "MENU_ID_SEND", "MENU_ID_SETTING", "MENU_ID_UNSUBSCRIBE", "addContactScene", "addFriendSearchScene", "bizInfo", "Lcom/tencent/mm/api/BizInfo;", "blockAddContact", "", "getBrandIconUrl", "()Ljava/lang/String;", "setBrandIconUrl", "(Ljava/lang/String;)V", "brandInfoList", "", "Lcom/tencent/mm/api/BizInfo$BrandInfo;", "channelSessionId", "contact", "Lcom/tencent/mm/storage/Contact;", "contentView", "Landroid/view/View;", "currentExpandState", "getCurrentExpandState", "()Z", "setCurrentExpandState", "(Z)V", "getCustomizedInfo", "()Lcom/tencent/mm/protocal/protobuf/CustomizedInfo;", "setCustomizedInfo", "(Lcom/tencent/mm/protocal/protobuf/CustomizedInfo;)V", "defaultTabSelectType", "getDefaultTabSelectType", "()I", "defaultTabSelectType$delegate", "Lkotlin/Lazy;", "doesEnterFromFinder", "getDoesEnterFromFinder", "doesEnterFromFinder$delegate", "getEnterTime", "()J", "setEnterTime", "(J)V", "extInfo", "Lcom/tencent/mm/api/BizInfo$ExtInfo;", "feedId", "getFeedId", "feedId$delegate", "finderBizProfileFragment", "Landroidx/fragment/app/Fragment;", "followStatus", "fragments", "", "headerController", "Lcom/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController;", "isChecking", "isFirstTime", "menuDialog", "Lcom/tencent/mm/ui/widget/dialog/MMHalfBottomDialog;", "menuTabLayout", "Lcom/tencent/mm/plugin/profile/ui/tab/view/BizProfileTabLayout;", "operationObservers", "Lcom/tencent/mm/plugin/profile/ui/tab/observer/IBizProfileOperateObserver;", "pagerAdapter", "Lcom/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizInfo$BizProfilePagerAdapter;", "profileDataFetcher", "Lcom/tencent/mm/plugin/profile/ui/tab/data/BizProfileDataFetcher;", "getProfileDataFetcher", "()Lcom/tencent/mm/plugin/profile/ui/tab/data/BizProfileDataFetcher;", "profileDataFetcher$delegate", "profileInfo", "Lcom/tencent/mm/protocal/protobuf/BizProfileV2Resp;", "readonly", "searchClickId", "getSearchClickId", "searchClickId$delegate", "searchId", "getSearchId", "searchId$delegate", "showFinderVideo", "verifyPromptTitle", "verifyTicket", "getVerifyTicket", "setVerifyTicket", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "checkCrash", "", "checkParamsLegal", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "dealBizExpose", "dealSendCardEvent", "doSearchHistory", "handleEvent", "key", "hasFollowStateChanged", "originContact", "currentContact", "hideOriginContentView", "initActionBar", "initBizInfo", "initProfile", "initView", "jumpToSettingUI", "loadProfile", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAttach", "onBizProfileUpdate", "bizProfile", "onCreate", "onDestroy", "onDetach", "onPause", "onPlaceTopChange", "onResume", "reportEnd", "reportStart", "reportUpdate", "scrollToTop", "showMenuDialog", "updateActionBarMenu", "expand", "forceUpdate", "updateBizTeenModeStatus", "updateCurrentItem", "videoFragment", "canShowFinderTab", "updateFragments", "updateTabLayout", "needReport", "BizProfilePagerAdapter", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ContactWidgetTabBizInfo
  implements androidx.lifecycle.p, com.tencent.mm.pluginsdk.c.b
{
  public static final ContactWidgetTabBizInfo.b NdG;
  private final int Aue;
  private final kotlin.j Blq;
  private final int Brj;
  private com.tencent.mm.api.c MVg;
  private boolean MVt;
  public String MVy;
  public ahl MWY;
  private int MXc;
  private final String MXg;
  private qm NcO;
  private final ContactInfoUI NdH;
  private List<com.tencent.mm.plugin.profile.ui.tab.observer.a> NdI;
  private boolean NdJ;
  private boolean NdK;
  private final String NdL;
  private ContactWidgetTabBizHeaderController NdM;
  private a NdN;
  private BizProfileTabLayout NdO;
  private boolean NdP;
  private final kotlin.j NdQ;
  private final kotlin.j NdR;
  private final kotlin.j NdS;
  private final kotlin.j NdT;
  private final kotlin.j NdU;
  private final boolean NdV;
  private Fragment NdW;
  private com.tencent.mm.ui.widget.a.j NdX;
  private final int NdY;
  private final int NdZ;
  private boolean Ndo;
  private String Nds;
  private final int Nea;
  private final int Neb;
  private final int Nec;
  private boolean Ned;
  private final int Nee;
  private com.tencent.mm.storage.au contact;
  private View contentView;
  private ViewPager dyl;
  public long enterTime;
  private final List<Fragment> fragments;
  private List<? extends c.a> hcB;
  private c.b hcC;
  private String hcL;
  public String pPi;
  private int pUt;
  
  static
  {
    AppMethodBeat.i(306217);
    NdG = new ContactWidgetTabBizInfo.b((byte)0);
    AppMethodBeat.o(306217);
  }
  
  public ContactWidgetTabBizInfo(ContactInfoUI paramContactInfoUI, String paramString, ahl paramahl, long paramLong)
  {
    AppMethodBeat.i(305919);
    this.NdH = paramContactInfoUI;
    this.MVy = paramString;
    this.MWY = paramahl;
    this.enterTime = paramLong;
    this.NdI = ((List)new ArrayList());
    this.NdJ = true;
    this.NdL = "crashFlag";
    this.fragments = ((List)new ArrayList());
    this.NdP = true;
    this.Nds = "";
    this.NdQ = kotlin.k.cm((kotlin.g.a.a)new l(this));
    this.NdR = kotlin.k.cm((kotlin.g.a.a)new m(this));
    this.NdS = kotlin.k.cm((kotlin.g.a.a)new k(this));
    this.NdT = kotlin.k.cm((kotlin.g.a.a)new c(this));
    this.NdU = kotlin.k.cm((kotlin.g.a.a)new d(this));
    this.NdI.add(new BizProfileExtraOperateObserver());
    this.NdI.add(new BizProfileWidgetOperateObserver(this.NdH));
    paramContactInfoUI = com.tencent.mm.plugin.bizui.a.a.vtB;
    this.NdV = com.tencent.mm.plugin.bizui.a.a.daJ();
    this.Blq = kotlin.k.cm((kotlin.g.a.a)new e(this));
    this.Aue = 1;
    this.NdY = 2;
    this.Brj = 3;
    this.NdZ = 4;
    this.Nea = 5;
    this.Neb = 6;
    this.Nec = 7;
    this.Nee = 1;
    this.MXg = "https://mp.weixin.qq.com/mp/infringement?username=%s&from=1#wechat_redirect";
    AppMethodBeat.o(305919);
  }
  
  private final void AH(boolean paramBoolean)
  {
    Object localObject4 = null;
    Object localObject3 = null;
    AppMethodBeat.i(306012);
    Object localObject2 = this.NdO;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("menuTabLayout");
      localObject1 = null;
    }
    ((BizProfileTabLayout)localObject1).gDw();
    localObject1 = ((Iterable)this.fragments).iterator();
    int i = 0;
    int j = 0;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Fragment)((Iterator)localObject1).next();
      if (((localObject2 instanceof com.tencent.mm.plugin.findersdk.a.r)) && (((com.tencent.mm.plugin.findersdk.a.r)localObject2).dUV()))
      {
        j = 1;
      }
      else
      {
        if (!(localObject2 instanceof BizProfileTabMsgFragment)) {
          break label797;
        }
        i = 1;
      }
    }
    label791:
    label797:
    for (;;)
    {
      break;
      localObject1 = this.NcO;
      if (localObject1 != null)
      {
        localObject1 = ((qm)localObject1).YVq;
        if (localObject1 != null)
        {
          localObject1 = ((re)localObject1).YWc;
          if (localObject1 != null)
          {
            localObject1 = ((rf)localObject1).YWe;
            if (localObject1 != null) {
              if (!((Collection)localObject1).isEmpty())
              {
                k = 1;
                if (k != 1) {
                  break label689;
                }
                k = 1;
                label192:
                if (k == 0) {
                  break label791;
                }
              }
            }
          }
        }
      }
      for (int k = 1;; k = 0)
      {
        if ((i != 0) && ((j != 0) || (k != 0)))
        {
          localObject2 = this.NdO;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            kotlin.g.b.s.bIx("menuTabLayout");
            localObject1 = null;
          }
          localObject2 = ((BizProfileTabLayout)localObject1).Nga;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            kotlin.g.b.s.bIx("mMsgLayout");
            localObject1 = null;
          }
          ((ViewGroup)localObject1).setVisibility(0);
        }
        if ((j != 0) && ((i != 0) || (k != 0)))
        {
          localObject2 = this.NdO;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            kotlin.g.b.s.bIx("menuTabLayout");
            localObject1 = null;
          }
          localObject2 = ((BizProfileTabLayout)localObject1).Ngb;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            kotlin.g.b.s.bIx("mVideoLayout");
            localObject1 = null;
          }
          ((ViewGroup)localObject1).setVisibility(0);
        }
        if (k != 0)
        {
          localObject2 = this.NdO;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            kotlin.g.b.s.bIx("menuTabLayout");
            localObject1 = null;
          }
          localObject2 = ((BizProfileTabLayout)localObject1).Ngc;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            kotlin.g.b.s.bIx("mServiceLayout");
            localObject1 = null;
          }
          ((ViewGroup)localObject1).setVisibility(0);
        }
        localObject2 = this.NdO;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          kotlin.g.b.s.bIx("menuTabLayout");
          localObject1 = null;
        }
        ViewPager localViewPager = this.dyl;
        localObject2 = localViewPager;
        if (localViewPager == null)
        {
          kotlin.g.b.s.bIx("viewPager");
          localObject2 = null;
        }
        int m = ((ViewPager)localObject2).getCurrentItem();
        if ((m < 0) || (m >= ((BizProfileTabLayout)localObject1).getTabCount()))
        {
          if (this.fragments.size() > 1) {
            break label742;
          }
          localObject2 = this.NdO;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            kotlin.g.b.s.bIx("menuTabLayout");
            localObject1 = null;
          }
          if (((BizProfileTabLayout)localObject1).getTabCount() > 0) {
            break label742;
          }
          localObject1 = this.NdO;
          if (localObject1 != null) {
            break label739;
          }
          kotlin.g.b.s.bIx("menuTabLayout");
          localObject1 = localObject3;
        }
        label689:
        label739:
        for (;;)
        {
          ((BizProfileTabLayout)localObject1).setVisibility(8);
          i = 0;
          j = 0;
          k = 0;
          if (paramBoolean)
          {
            if (j != 0)
            {
              localObject1 = com.tencent.mm.plugin.profile.ui.tab.data.b.Ner;
              com.tencent.mm.plugin.profile.ui.tab.data.b.a(this.contact, 0, this.pUt, this.enterTime, gCM());
            }
            if (k != 0)
            {
              localObject1 = com.tencent.mm.plugin.profile.ui.tab.data.b.Ner;
              com.tencent.mm.plugin.profile.ui.tab.data.b.a(this.contact, 1, this.pUt, this.enterTime, gCM());
            }
            if (i != 0)
            {
              localObject1 = com.tencent.mm.plugin.profile.ui.tab.data.b.Ner;
              com.tencent.mm.plugin.profile.ui.tab.data.b.a(this.contact, 2, this.pUt, this.enterTime, gCM());
            }
            if ((j == 0) && (k == 0) && (i == 0))
            {
              localObject1 = com.tencent.mm.plugin.profile.ui.tab.data.b.Ner;
              com.tencent.mm.plugin.profile.ui.tab.data.b.a(this.contact, 3, this.pUt, this.enterTime, gCM());
            }
          }
          AppMethodBeat.o(306012);
          return;
          k = 0;
          break;
          k = 0;
          break label192;
          switch (m)
          {
          default: 
            break;
          case 0: 
            ((BizProfileTabLayout)localObject1).gDx();
            break;
          case 1: 
            ((BizProfileTabLayout)localObject1).gDy();
            break;
          }
        }
        label742:
        localObject1 = this.NdO;
        if (localObject1 == null)
        {
          kotlin.g.b.s.bIx("menuTabLayout");
          localObject1 = localObject4;
        }
        for (;;)
        {
          ((BizProfileTabLayout)localObject1).setVisibility(0);
          m = i;
          int n = j;
          i = k;
          j = m;
          k = n;
          break;
        }
      }
    }
  }
  
  private final void a(Fragment paramFragment, boolean paramBoolean)
  {
    AppMethodBeat.i(305994);
    if ((paramFragment != null) && (gCO() == 1)) {
      if ((paramBoolean) || (!gCP())) {
        break label70;
      }
    }
    label70:
    for (int i = 0;; i = this.fragments.indexOf(paramFragment))
    {
      if (i >= 0)
      {
        ViewPager localViewPager = this.dyl;
        paramFragment = localViewPager;
        if (localViewPager == null)
        {
          kotlin.g.b.s.bIx("viewPager");
          paramFragment = null;
        }
        paramFragment.setCurrentItem(i, false);
      }
      AppMethodBeat.o(305994);
      return;
    }
  }
  
  private static final void a(ContactWidgetTabBizInfo paramContactWidgetTabBizInfo, MenuItem paramMenuItem, int paramInt)
  {
    Intent localIntent2 = null;
    String str = null;
    Intent localIntent1 = null;
    Object localObject = null;
    AppMethodBeat.i(306134);
    kotlin.g.b.s.u(paramContactWidgetTabBizInfo, "this$0");
    paramInt = paramMenuItem.getItemId();
    if (paramInt == paramContactWidgetTabBizInfo.NdY)
    {
      localIntent1 = new Intent();
      paramMenuItem = paramContactWidgetTabBizInfo.contact;
      if (paramMenuItem == null)
      {
        paramMenuItem = null;
        localIntent1.putExtra("Select_Talker_Name", paramMenuItem);
        paramMenuItem = paramContactWidgetTabBizInfo.contact;
        if (paramMenuItem != null) {
          break label182;
        }
        paramMenuItem = null;
        label78:
        localIntent1.putExtra("Select_block_List", paramMenuItem);
        localIntent1.putExtra("Select_Send_Card", true);
        localIntent1.putExtra("Select_Conv_Type", 3);
        localIntent1.putExtra("mutil_select_is_ret", true);
        com.tencent.mm.plugin.profile.b.pFn.a(localIntent1, paramContactWidgetTabBizInfo.Nee, (MMActivity)paramContactWidgetTabBizInfo.NdH);
        paramMenuItem = paramContactWidgetTabBizInfo.contact;
        if (paramMenuItem != null) {
          break label190;
        }
      }
      label182:
      label190:
      for (paramMenuItem = null;; paramMenuItem = paramMenuItem.field_username)
      {
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.a(paramMenuItem, 800, paramContactWidgetTabBizInfo.pUt, paramContactWidgetTabBizInfo.enterTime, paramContactWidgetTabBizInfo.NdH.getIntent());
        AppMethodBeat.o(306134);
        return;
        paramMenuItem = paramMenuItem.field_username;
        break;
        paramMenuItem = paramMenuItem.field_username;
        break label78;
      }
    }
    if (paramInt == paramContactWidgetTabBizInfo.Brj)
    {
      localIntent1 = new Intent();
      localIntent1.setClass((Context)paramContactWidgetTabBizInfo.NdH, NewBizInfoSettingUI.class);
      paramMenuItem = paramContactWidgetTabBizInfo.contact;
      if (paramMenuItem == null) {}
      for (paramMenuItem = localObject;; paramMenuItem = paramMenuItem.field_username)
      {
        localIntent1.putExtra("Contact_User", paramMenuItem);
        localIntent1.putExtra("key_start_biz_profile_setting_from_scene", 2);
        localIntent1.putExtra("key_profile_enter_timestamp", paramContactWidgetTabBizInfo.enterTime);
        if (paramContactWidgetTabBizInfo.NdH.getIntent() != null) {
          localIntent1.putExtras(paramContactWidgetTabBizInfo.NdH.getIntent());
        }
        paramContactWidgetTabBizInfo = paramContactWidgetTabBizInfo.NdH;
        paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent1);
        com.tencent.mm.hellhoundlib.a.a.b(paramContactWidgetTabBizInfo, paramMenuItem.aYi(), "com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizInfo", "jumpToSettingUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContactWidgetTabBizInfo.startActivity((Intent)paramMenuItem.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramContactWidgetTabBizInfo, "com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizInfo", "jumpToSettingUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(306134);
        return;
      }
    }
    if (paramInt == paramContactWidgetTabBizInfo.NdZ)
    {
      paramMenuItem = paramContactWidgetTabBizInfo.contact;
      if (paramMenuItem == null)
      {
        paramMenuItem = null;
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.a(paramMenuItem, 903, paramContactWidgetTabBizInfo.pUt, paramContactWidgetTabBizInfo.enterTime, paramContactWidgetTabBizInfo.NdH.getIntent());
        paramMenuItem = paramContactWidgetTabBizInfo.contact;
        if (paramMenuItem != null) {
          break label500;
        }
        paramMenuItem = null;
        label437:
        com.tencent.mm.model.j.HW(paramMenuItem);
        paramContactWidgetTabBizInfo.gCR();
        paramMenuItem = paramContactWidgetTabBizInfo.contact;
        if (paramMenuItem != null) {
          break label508;
        }
      }
      label500:
      label508:
      for (paramMenuItem = localIntent2;; paramMenuItem = paramMenuItem.field_username)
      {
        if (!com.tencent.mm.an.g.Mw(paramMenuItem)) {
          break label882;
        }
        com.tencent.mm.ui.base.k.cZ((Context)paramContactWidgetTabBizInfo.NdH, paramContactWidgetTabBizInfo.NdH.getString(R.l.gNh));
        AppMethodBeat.o(306134);
        return;
        paramMenuItem = paramMenuItem.field_username;
        break;
        paramMenuItem = paramMenuItem.field_username;
        break label437;
      }
    }
    if (paramInt == paramContactWidgetTabBizInfo.Nea)
    {
      paramMenuItem = paramContactWidgetTabBizInfo.contact;
      if (paramMenuItem == null)
      {
        paramMenuItem = null;
        ab.L(paramMenuItem, true);
        paramMenuItem = paramContactWidgetTabBizInfo.contact;
        if (paramMenuItem != null) {
          break label632;
        }
        paramMenuItem = null;
        label551:
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.a(paramMenuItem, 904, paramContactWidgetTabBizInfo.pUt, paramContactWidgetTabBizInfo.enterTime, paramContactWidgetTabBizInfo.NdH.getIntent());
        paramContactWidgetTabBizInfo.gCR();
        paramMenuItem = paramContactWidgetTabBizInfo.contact;
        if (paramMenuItem != null) {
          break label640;
        }
      }
      label640:
      for (paramMenuItem = str;; paramMenuItem = paramMenuItem.field_username)
      {
        if (!com.tencent.mm.an.g.Mw(paramMenuItem)) {
          break label882;
        }
        com.tencent.mm.ui.base.k.cZ((Context)paramContactWidgetTabBizInfo.NdH, paramContactWidgetTabBizInfo.NdH.getString(R.l.biz_time_line_unplacedtop_tips));
        AppMethodBeat.o(306134);
        return;
        paramMenuItem = paramMenuItem.field_username;
        break;
        label632:
        paramMenuItem = paramMenuItem.field_username;
        break label551;
      }
    }
    if (paramInt == paramContactWidgetTabBizInfo.Neb)
    {
      if (paramContactWidgetTabBizInfo.contact != null)
      {
        paramMenuItem = paramContactWidgetTabBizInfo.contact;
        if (paramMenuItem != null) {
          break label688;
        }
      }
      label688:
      for (paramMenuItem = null; Util.isNullOrNil(paramMenuItem); paramMenuItem = paramMenuItem.field_username)
      {
        AppMethodBeat.o(306134);
        return;
      }
      paramMenuItem = paramContactWidgetTabBizInfo.contact;
      if (paramMenuItem == null)
      {
        paramMenuItem = null;
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.a(paramMenuItem, 601, paramContactWidgetTabBizInfo.pUt, paramContactWidgetTabBizInfo.enterTime, paramContactWidgetTabBizInfo.NdH.getIntent());
        localIntent2 = new Intent();
        paramMenuItem = am.aixg;
        str = paramContactWidgetTabBizInfo.MXg;
        paramMenuItem = paramContactWidgetTabBizInfo.contact;
        if (paramMenuItem != null) {
          break label837;
        }
      }
      label837:
      for (paramMenuItem = localIntent1;; paramMenuItem = paramMenuItem.field_username)
      {
        paramMenuItem = String.format(str, Arrays.copyOf(new Object[] { paramMenuItem }, 1));
        kotlin.g.b.s.s(paramMenuItem, "java.lang.String.format(format, *args)");
        localIntent2.putExtra("rawUrl", paramMenuItem);
        localIntent2.putExtra("key_menu_hide_expose", true);
        com.tencent.mm.br.c.b((Context)paramContactWidgetTabBizInfo.NdH, "webview", ".ui.tools.WebViewUI", localIntent2);
        AppMethodBeat.o(306134);
        return;
        paramMenuItem = paramMenuItem.field_username;
        break;
      }
    }
    if (paramInt == paramContactWidgetTabBizInfo.Nec)
    {
      paramContactWidgetTabBizInfo = paramContactWidgetTabBizInfo.NdM;
      if (paramContactWidgetTabBizInfo != null)
      {
        paramContactWidgetTabBizInfo.gCz();
        AppMethodBeat.o(306134);
      }
    }
    else
    {
      Log.w("MicroMsg.ContactWidgetTabBizInfo", "default onMMMenuItemSelected err");
    }
    label882:
    AppMethodBeat.o(306134);
  }
  
  private static final void a(ContactWidgetTabBizInfo paramContactWidgetTabBizInfo, qm paramqm)
  {
    AppMethodBeat.i(306060);
    kotlin.g.b.s.u(paramContactWidgetTabBizInfo, "this$0");
    paramContactWidgetTabBizInfo.NcO = paramqm;
    paramContactWidgetTabBizInfo.gBx();
    Object localObject3 = paramContactWidgetTabBizInfo.NdM;
    Object localObject2;
    String str;
    c localc;
    label138:
    label150:
    int i;
    if (localObject3 != null)
    {
      localObject1 = paramContactWidgetTabBizInfo.NcO;
      localObject2 = paramContactWidgetTabBizInfo.MVg;
      str = paramContactWidgetTabBizInfo.pPi;
      ((ContactWidgetTabBizHeaderController)localObject3).NcO = ((qm)localObject1);
      ((ContactWidgetTabBizHeaderController)localObject3).MVg = ((com.tencent.mm.api.c)localObject2);
      ((ContactWidgetTabBizHeaderController)localObject3).pPi = str;
      if (localObject1 != null)
      {
        if ((((qm)localObject1).YRD & 0x2) != 0) {
          ((ContactWidgetTabBizHeaderController)localObject3).NcZ = true;
        }
        if (((ContactWidgetTabBizHeaderController)localObject3).gCI()) {
          ((ContactWidgetTabBizHeaderController)localObject3).FwQ.setVisibility(8);
        }
      }
      else
      {
        localc = ((ContactWidgetTabBizHeaderController)localObject3).Ndm;
        if (localObject1 != null) {
          break label411;
        }
        localc.NcW = null;
        Log.i(c.TAG, "update: profileInfo empty!");
        ((ContactWidgetTabBizHeaderController)localObject3).updateView();
      }
    }
    else
    {
      if (paramqm != null) {
        break label659;
      }
      localObject1 = null;
      if (localObject1 == null) {
        break label673;
      }
      if (((CharSequence)localObject1).length() <= 0) {
        break label668;
      }
      i = 1;
      label170:
      if (i != 1) {
        break label673;
      }
      i = 1;
      label177:
      if (i == 0) {
        break label678;
      }
      localObject2 = paramContactWidgetTabBizInfo.dyl;
      paramqm = (qm)localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("viewPager");
        paramqm = null;
      }
      paramqm.setVisibility(0);
      localObject2 = paramContactWidgetTabBizInfo.NdO;
      paramqm = (qm)localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("menuTabLayout");
        paramqm = null;
      }
      paramqm.setVisibility(8);
      localObject2 = paramContactWidgetTabBizInfo.NdO;
      paramqm = (qm)localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("menuTabLayout");
        paramqm = null;
      }
      paramqm.gDw();
      paramqm = new BizProfileErrorFragment();
      kotlin.g.b.s.u(localObject1, "errorMsg");
      paramqm.errorMsg = ((String)localObject1);
      paramContactWidgetTabBizInfo.fragments.clear();
      paramContactWidgetTabBizInfo.fragments.add(paramqm);
      localObject1 = paramContactWidgetTabBizInfo.NdN;
      paramqm = (qm)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("pagerAdapter");
        paramqm = null;
      }
      paramqm.notifyDataSetChanged();
    }
    for (;;)
    {
      if ((paramContactWidgetTabBizInfo.contact != null) && (paramContactWidgetTabBizInfo.MVg != null) && (paramContactWidgetTabBizInfo.NcO != null))
      {
        paramqm = paramContactWidgetTabBizInfo.NcO;
        kotlin.g.b.s.checkNotNull(paramqm);
        if (paramqm.YVm != null)
        {
          paramqm = paramContactWidgetTabBizInfo.NcO;
          kotlin.g.b.s.checkNotNull(paramqm);
          if (paramqm.YVl != null) {
            break label691;
          }
        }
      }
      Log.w("MicroMsg.ContactWidgetTabBizInfo", "reportUpdate fail, err");
      AppMethodBeat.o(306060);
      return;
      ((ContactWidgetTabBizHeaderController)localObject3).FwQ.setVisibility(0);
      break;
      label411:
      localc.NcO = ((qm)localObject1);
      if (((qm)localObject1).YVy.size() > 0)
      {
        localc.NcW = ((pj)((qm)localObject1).YVy.getFirst());
        str = w.a(((qm)localObject1).YVw.YWz);
        localObject1 = (com.tencent.mm.plugin.g)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.g.class);
        kotlin.g.b.s.s(str, "finderUserName");
        localObject2 = ((com.tencent.mm.plugin.g)localObject1).Sv(str);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new bkk();
        }
        localObject2 = localc.NcW;
        kotlin.g.b.s.checkNotNull(localObject2);
        ((bkk)localObject1).startTime = ((pj)localObject2).start_time;
        localObject2 = localc.NcW;
        kotlin.g.b.s.checkNotNull(localObject2);
        ((bkk)localObject1).status = ((pj)localObject2).YSQ;
        localObject2 = localc.NcW;
        kotlin.g.b.s.checkNotNull(localObject2);
        ((bkk)localObject1).YSR = ((pj)localObject2).YSR;
        localObject2 = localc.NcW;
        kotlin.g.b.s.checkNotNull(localObject2);
        ((bkk)localObject1).hAR = ((pj)localObject2).YSS;
        Log.i(c.TAG, "local cache status has been set " + ((bkk)localObject1).status + '!');
        localObject2 = com.tencent.mm.plugin.finder.feed.model.j.BfL;
        com.tencent.mm.plugin.finder.feed.model.j.b(str, (bkk)localObject1);
        break label138;
      }
      localc.NcW = null;
      Log.i(c.TAG, "update: liveNoticeInfo empty!");
      break label138;
      label659:
      localObject1 = a.b(paramqm);
      break label150;
      label668:
      i = 0;
      break label170;
      label673:
      i = 0;
      break label177;
      label678:
      paramContactWidgetTabBizInfo.d(paramqm);
      paramContactWidgetTabBizInfo.AH(true);
    }
    label691:
    paramqm = paramContactWidgetTabBizInfo.contact;
    kotlin.g.b.s.checkNotNull(paramqm);
    Object localObject1 = paramqm.field_username;
    int m = paramContactWidgetTabBizInfo.pUt;
    paramqm = paramContactWidgetTabBizInfo.MVg;
    kotlin.g.b.s.checkNotNull(paramqm);
    int n = paramqm.field_type;
    long l = paramContactWidgetTabBizInfo.enterTime;
    paramqm = paramContactWidgetTabBizInfo.contact;
    kotlin.g.b.s.checkNotNull(paramqm);
    int j;
    label774:
    int k;
    if (com.tencent.mm.contact.d.rs(paramqm.field_type))
    {
      i = 1;
      paramqm = paramContactWidgetTabBizInfo.NcO;
      kotlin.g.b.s.checkNotNull(paramqm);
      paramqm = paramqm.YVm;
      if (paramqm != null) {
        break label994;
      }
      j = 0;
      paramqm = paramContactWidgetTabBizInfo.NcO;
      kotlin.g.b.s.checkNotNull(paramqm);
      paramqm = paramqm.YVm;
      if (paramqm != null) {
        break label1002;
      }
      k = 0;
      label795:
      paramqm = paramContactWidgetTabBizInfo.NcO;
      kotlin.g.b.s.checkNotNull(paramqm);
      localObject2 = com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.b(paramqm.YVn);
      paramqm = paramContactWidgetTabBizInfo.NcO;
      kotlin.g.b.s.checkNotNull(paramqm);
      localObject3 = com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.a(paramqm.YVq);
      paramqm = paramContactWidgetTabBizInfo.NcO;
      kotlin.g.b.s.checkNotNull(paramqm);
      paramqm = paramqm.YVl;
      if (paramqm != null) {
        break label1011;
      }
    }
    label994:
    label1002:
    label1011:
    for (paramqm = null;; paramqm = paramqm.UserName)
    {
      com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.a((String)localObject1, m, n, l, i, j, k, (String)localObject2, (String)localObject3, paramqm, paramContactWidgetTabBizInfo.getSearchId(), paramContactWidgetTabBizInfo.gCM(), paramContactWidgetTabBizInfo.NdH.getIntent());
      if (paramContactWidgetTabBizInfo.NcO != null)
      {
        paramqm = paramContactWidgetTabBizInfo.NcO;
        kotlin.g.b.s.checkNotNull(paramqm);
        if (paramqm.YVq != null)
        {
          paramqm = paramContactWidgetTabBizInfo.contact;
          kotlin.g.b.s.checkNotNull(paramqm);
          com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.a(paramqm.field_username, 104, paramContactWidgetTabBizInfo.pUt, paramContactWidgetTabBizInfo.enterTime, paramContactWidgetTabBizInfo.NdH.getIntent());
        }
      }
      if (paramContactWidgetTabBizInfo.NcO != null)
      {
        paramqm = paramContactWidgetTabBizInfo.contact;
        kotlin.g.b.s.checkNotNull(paramqm);
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.a(paramqm.field_username, 101, paramContactWidgetTabBizInfo.pUt, paramContactWidgetTabBizInfo.enterTime, paramContactWidgetTabBizInfo.NdH.getIntent());
      }
      AppMethodBeat.o(306060);
      return;
      i = 0;
      break;
      j = paramqm.YRw;
      break label774;
      k = paramqm.YRx;
      break label795;
    }
  }
  
  private static final void a(ContactWidgetTabBizInfo paramContactWidgetTabBizInfo, com.tencent.mm.ui.base.s params)
  {
    az.b localb = null;
    com.tencent.mm.storage.au localau1 = null;
    Object localObject = null;
    AppMethodBeat.i(306118);
    kotlin.g.b.s.u(paramContactWidgetTabBizInfo, "this$0");
    com.tencent.mm.storage.au localau2 = paramContactWidgetTabBizInfo.contact;
    if ((localau2 != null) && (com.tencent.mm.contact.d.rs(localau2.field_type) == true))
    {
      i = 1;
      if (i == 0) {
        break label291;
      }
      localau1 = paramContactWidgetTabBizInfo.contact;
      if ((localau1 == null) || (localau1.aSQ() != true)) {
        break label205;
      }
      i = 1;
      label72:
      if (i == 0) {
        break label234;
      }
      localau1 = paramContactWidgetTabBizInfo.contact;
      if (localau1 != null) {
        break label210;
      }
      label87:
      if (!com.tencent.mm.an.g.My((String)localObject)) {
        break label219;
      }
      params.oh(paramContactWidgetTabBizInfo.Nea, R.l.gAW);
      label106:
      params.oh(paramContactWidgetTabBizInfo.NdY, R.l.contact_info_send_card_biz);
      params.oh(paramContactWidgetTabBizInfo.Neb, R.l.gxj);
      params.oh(paramContactWidgetTabBizInfo.Brj, R.l.gBc);
      localObject = paramContactWidgetTabBizInfo.contact;
      if ((localObject == null) || (com.tencent.mm.contact.d.rs(((az)localObject).field_type) != true)) {
        break label367;
      }
    }
    label205:
    label210:
    label219:
    label234:
    label367:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        params.a(paramContactWidgetTabBizInfo.Nec, -65536, (CharSequence)paramContactWidgetTabBizInfo.NdH.getString(R.l.biz_contact_unsubscribe));
      }
      AppMethodBeat.o(306118);
      return;
      i = 0;
      break;
      i = 0;
      break label72;
      localObject = localau1.field_username;
      break label87;
      params.oh(paramContactWidgetTabBizInfo.Nea, R.l.gNg);
      break label106;
      localObject = paramContactWidgetTabBizInfo.contact;
      if (localObject == null) {}
      for (localObject = localb;; localObject = ((az)localObject).field_username)
      {
        if (!com.tencent.mm.an.g.My((String)localObject)) {
          break label276;
        }
        params.oh(paramContactWidgetTabBizInfo.NdZ, R.l.gAV);
        break;
      }
      params.oh(paramContactWidgetTabBizInfo.NdZ, R.l.contact_info_stick_biz);
      break label106;
      localObject = paramContactWidgetTabBizInfo.contact;
      if (localObject == null)
      {
        localObject = null;
        kotlin.g.b.s.checkNotNull(localObject);
        if (((Integer)localObject).intValue() > 0) {
          break label106;
        }
        localb = az.a.okP;
        localObject = paramContactWidgetTabBizInfo.contact;
        if (localObject != null) {
          break label359;
        }
      }
      for (localObject = localau1;; localObject = ((az)localObject).field_username)
      {
        localb.a((String)localObject, "", ContactWidgetTabBizInfo..ExternalSyntheticLambda6.INSTANCE);
        break;
        localObject = Integer.valueOf((int)((com.tencent.mm.contact.d)localObject).maN);
        break label302;
      }
    }
  }
  
  private static final void a(MultiProcessMMKV paramMultiProcessMMKV, ContactWidgetTabBizInfo paramContactWidgetTabBizInfo)
  {
    AppMethodBeat.i(306067);
    kotlin.g.b.s.u(paramContactWidgetTabBizInfo, "this$0");
    Log.i("MicroMsg.ContactWidgetTabBizInfo", "checkCrash clear crash flag");
    paramMultiProcessMMKV.encode(paramContactWidgetTabBizInfo.NdL, false);
    paramContactWidgetTabBizInfo.NdK = false;
    AppMethodBeat.o(306067);
  }
  
  private static final boolean a(androidx.core.g.d paramd, View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(306075);
    kotlin.g.b.s.u(paramd, "$detector");
    paramd.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(306075);
    return true;
  }
  
  private static final boolean a(ContactWidgetTabBizInfo paramContactWidgetTabBizInfo, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(306083);
    kotlin.g.b.s.u(paramContactWidgetTabBizInfo, "this$0");
    paramContactWidgetTabBizInfo.NdH.onBackPressed();
    AppMethodBeat.o(306083);
    return true;
  }
  
  private final void aH(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(306034);
    Log.d("MicroMsg.ContactWidgetTabBizInfo", "updateActionBarMenu  expand:" + paramBoolean1 + "  forceUpdate:" + paramBoolean2 + "  followStatus:" + this.NdP);
    if ((!paramBoolean2) && (paramBoolean1 == this.Ned))
    {
      AppMethodBeat.o(306034);
      return;
    }
    Log.i("MicroMsg.ContactWidgetTabBizInfo", "updateActionBarMenu  return");
    this.Ned = paramBoolean1;
    this.NdH.removeAllOptionMenu();
    if ((this.NdP) || (paramBoolean1))
    {
      this.NdH.addIconOptionMenu(1, R.l.top_item_desc_search, R.k.actionbar_icon_dark_search, new ContactWidgetTabBizInfo..ExternalSyntheticLambda3(this));
      this.NdH.addIconOptionMenu(0, R.l.chatting_more, R.k.actionbar_icon_dark_more, new ContactWidgetTabBizInfo..ExternalSyntheticLambda1(this));
      AppMethodBeat.o(306034);
      return;
    }
    this.NdH.addTextOptionMenu(2, this.NdH.getString(R.l.gAG), new ContactWidgetTabBizInfo..ExternalSyntheticLambda0(this), null, y.b.adEJ);
    AppMethodBeat.o(306034);
  }
  
  /* Error */
  private final void ao(com.tencent.mm.storage.au paramau)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 1181
    //   5: invokestatic 269	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: ifnull +10 -> 19
    //   12: aload_0
    //   13: getfield 1103	com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizInfo:NdK	Z
    //   16: ifeq +12 -> 28
    //   19: ldc_w 1181
    //   22: invokestatic 275	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   25: aload_0
    //   26: monitorexit
    //   27: return
    //   28: aload_0
    //   29: iconst_1
    //   30: putfield 1103	com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizInfo:NdK	Z
    //   33: ldc_w 1183
    //   36: invokestatic 1187	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getSingleMMKV	(Ljava/lang/String;)Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   39: astore_2
    //   40: aload_2
    //   41: aload_0
    //   42: getfield 362	com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizInfo:NdL	Ljava/lang/String;
    //   45: iconst_0
    //   46: invokevirtual 1190	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:decodeBool	(Ljava/lang/String;Z)Z
    //   49: ifeq +40 -> 89
    //   52: ldc_w 779
    //   55: ldc_w 1192
    //   58: invokestatic 830	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   61: getstatic 1198	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   64: ldc2_w 1199
    //   67: lconst_0
    //   68: lconst_1
    //   69: iconst_0
    //   70: invokevirtual 1204	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   73: aload_1
    //   74: getfield 637	com/tencent/mm/autogen/b/az:field_username	Ljava/lang/String;
    //   77: astore_1
    //   78: aload_1
    //   79: ldc_w 1206
    //   82: invokestatic 757	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   85: aload_1
    //   86: invokestatic 1210	com/tencent/mm/plugin/profile/ui/newbizinfo/b:clear	(Ljava/lang/String;)V
    //   89: aload_2
    //   90: aload_0
    //   91: getfield 362	com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizInfo:NdL	Ljava/lang/String;
    //   94: iconst_1
    //   95: invokevirtual 1101	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:encode	(Ljava/lang/String;Z)Z
    //   98: pop
    //   99: ldc_w 779
    //   102: ldc_w 1212
    //   105: invokestatic 830	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   108: getstatic 1217	com/tencent/mm/sdk/platformtools/BuildInfo:DEBUG	Z
    //   111: ifne +15 -> 126
    //   114: getstatic 1220	com/tencent/mm/sdk/platformtools/BuildInfo:IS_FLAVOR_RED	Z
    //   117: ifne +9 -> 126
    //   120: invokestatic 1225	com/tencent/mm/sdk/platformtools/WeChatEnvironment:hasDebugger	()Z
    //   123: ifeq +22 -> 145
    //   126: aload_2
    //   127: ldc_w 1227
    //   130: iconst_0
    //   131: invokevirtual 1231	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:decodeInt	(Ljava/lang/String;I)I
    //   134: iconst_1
    //   135: if_icmpne +10 -> 145
    //   138: ldc_w 1233
    //   141: iconst_0
    //   142: invokestatic 1238	junit/framework/Assert:assertTrue	(Ljava/lang/String;Z)V
    //   145: getstatic 1244	com/tencent/threadpool/h:ahAA	Lcom/tencent/threadpool/i;
    //   148: new 1246	com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizInfo$$ExternalSyntheticLambda9
    //   151: dup
    //   152: aload_2
    //   153: aload_0
    //   154: invokespecial 1248	com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizInfo$$ExternalSyntheticLambda9:<init>	(Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;Lcom/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizInfo;)V
    //   157: ldc2_w 1249
    //   160: invokeinterface 1256 4 0
    //   165: pop
    //   166: ldc_w 1181
    //   169: invokestatic 275	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   172: goto -147 -> 25
    //   175: astore_1
    //   176: aload_0
    //   177: monitorexit
    //   178: aload_1
    //   179: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	this	ContactWidgetTabBizInfo
    //   0	180	1	paramau	com.tencent.mm.storage.au
    //   39	114	2	localMultiProcessMMKV	MultiProcessMMKV
    // Exception table:
    //   from	to	target	type
    //   2	8	175	finally
    //   12	19	175	finally
    //   19	25	175	finally
    //   28	89	175	finally
    //   89	126	175	finally
    //   126	145	175	finally
    //   145	172	175	finally
  }
  
  private static final boolean b(ContactWidgetTabBizInfo paramContactWidgetTabBizInfo, MenuItem paramMenuItem)
  {
    String str = null;
    AppMethodBeat.i(306100);
    kotlin.g.b.s.u(paramContactWidgetTabBizInfo, "this$0");
    paramMenuItem = paramContactWidgetTabBizInfo.contact;
    Intent localIntent;
    label106:
    int i;
    if (paramMenuItem == null)
    {
      paramMenuItem = null;
      localIntent = aj.ipS();
      localIntent.putExtra("ftsneedkeyboard", true);
      localIntent.putExtra("ftsbizscene", 19);
      localIntent.putExtra("ftsType", 2);
      Map localMap = aj.r(19, false, 2);
      kotlin.g.b.s.s(localMap, "params");
      localMap.put("userName", paramMenuItem);
      localObject = paramContactWidgetTabBizInfo.NcO;
      if (localObject != null) {
        break label360;
      }
      localObject = null;
      if (!Util.isNullOrNil((String)localObject))
      {
        localObject = paramContactWidgetTabBizInfo.NcO;
        if (localObject != null) {
          break label370;
        }
        localObject = str;
        label129:
        localMap.put("thirdExtParam", localObject);
      }
      localIntent.putExtra("rawUrl", aj.bo(localMap));
      localIntent.putExtra("key_load_js_without_delay", true);
      localIntent.putExtra("ftsbizusername", paramMenuItem);
      localIntent.putExtra(f.s.adxb, 13307);
      str = f.s.adxc;
      i = paramContactWidgetTabBizInfo.pUt;
      localObject = com.tencent.mm.plugin.profile.d.gAR().aSe(paramMenuItem);
      if (localObject == null) {
        break label380;
      }
    }
    label360:
    label370:
    label380:
    for (Object localObject = ((com.tencent.mm.plugin.profile.ui.newbizinfo.b.c)localObject).field_decryptUserName;; localObject = "")
    {
      int j = ad.getSessionId();
      Log.d("MicroMsg.Kv13307", "getArgs username:%s scene::%s optype:%d opscene:%d decryptUserName:%s profileScene:%d", new Object[] { paramMenuItem, Integer.valueOf(3), Integer.valueOf(1302), Integer.valueOf(4), localObject, Integer.valueOf(i) });
      localIntent.putStringArrayListExtra(str, new c.1(paramMenuItem, (String)localObject, String.valueOf(j), i));
      localIntent.addFlags(67108864);
      com.tencent.mm.br.c.b((Context)paramContactWidgetTabBizInfo.NdH, "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", localIntent);
      com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.a(paramMenuItem, 1301, paramContactWidgetTabBizInfo.enterTime, paramContactWidgetTabBizInfo.NdH.getIntent());
      AppMethodBeat.o(306100);
      return true;
      paramMenuItem = paramMenuItem.field_username;
      break;
      localObject = ((qm)localObject).YVu;
      break label106;
      localObject = ((qm)localObject).YVu;
      break label129;
    }
  }
  
  private static final boolean c(ContactWidgetTabBizInfo paramContactWidgetTabBizInfo, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(306142);
    kotlin.g.b.s.u(paramContactWidgetTabBizInfo, "this$0");
    paramMenuItem = new com.tencent.mm.ui.widget.a.f((Context)paramContactWidgetTabBizInfo.NdH, 1, false);
    paramMenuItem.Vtg = new ContactWidgetTabBizInfo..ExternalSyntheticLambda7(paramContactWidgetTabBizInfo);
    paramMenuItem.GAC = new ContactWidgetTabBizInfo..ExternalSyntheticLambda8(paramContactWidgetTabBizInfo);
    paramMenuItem.dDn();
    paramMenuItem = paramContactWidgetTabBizInfo.contact;
    if (paramMenuItem == null) {}
    for (paramMenuItem = null;; paramMenuItem = paramMenuItem.field_username)
    {
      com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.a(paramMenuItem, 600, paramContactWidgetTabBizInfo.pUt, paramContactWidgetTabBizInfo.enterTime, paramContactWidgetTabBizInfo.NdH.getIntent());
      AppMethodBeat.o(306142);
      return false;
    }
  }
  
  private static final void cE(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(306108);
    Log.i("MicroMsg.ContactWidgetTabBizInfo", "onCreateMMMenu Fetch Contact username:%s, succ: %b", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(306108);
  }
  
  private final void d(qm paramqm)
  {
    boolean bool = true;
    int j;
    Object localObject1;
    Object localObject3;
    try
    {
      AppMethodBeat.i(305985);
      j = this.fragments.size();
      localObject2 = (Iterable)this.fragments;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        if ((localObject3 instanceof BizProfileTabMsgFragment)) {
          ((Collection)localObject1).add(localObject3);
        }
      }
      localObject3 = kotlin.a.p.oL((List)localObject1);
    }
    finally {}
    Object localObject2 = ((Iterable)this.fragments).iterator();
    int i;
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = ((Iterator)localObject2).next();
      Object localObject4 = (Fragment)localObject1;
      if (((localObject4 instanceof com.tencent.mm.plugin.findersdk.a.r)) && (((com.tencent.mm.plugin.findersdk.a.r)localObject4).dUV()))
      {
        i = 1;
        break label957;
        label172:
        localObject2 = (Fragment)localObject1;
        if (paramqm == null) {
          break label974;
        }
        localObject1 = paramqm.YVn;
        if (localObject1 == null) {
          break label974;
        }
        if (localObject3 != null) {
          break label634;
        }
        localObject4 = ((py)localObject1).YUi;
        if (localObject4 == null) {
          break label629;
        }
        if (((Collection)localObject4).isEmpty()) {
          break label624;
        }
        i = 1;
        break label964;
        label229:
        if (i == 0) {
          break label634;
        }
        localObject4 = new BizProfileTabMsgFragment();
        localObject3 = this.NcO;
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = new qm();
        }
        ((BizProfileTabMsgFragment)localObject4).f((qm)localObject1);
        localObject1 = new Bundle();
        localObject3 = this.contact;
        kotlin.g.b.s.checkNotNull(localObject3);
        localObject3 = ((az)localObject3).field_username;
        kotlin.g.b.s.s(localObject3, "contact!!.username");
        com.tencent.mm.plugin.handoff.c.b.a((Bundle)localObject1, "contact", (String)localObject3);
        localObject3 = ah.aiuX;
        ((BizProfileTabMsgFragment)localObject4).setArguments((Bundle)localObject1);
        ((BizProfileTabMsgFragment)localObject4).b(gCN());
        localObject1 = ah.aiuX;
        this.fragments.add(0, localObject4);
        break label974;
      }
    }
    for (;;)
    {
      label359:
      if (paramqm == null) {
        break label1026;
      }
      paramqm = paramqm.YVp;
      if (paramqm == null) {
        break label1026;
      }
      paramqm = paramqm.YUi;
      if ((paramqm == null) || (((Collection)paramqm).isEmpty())) {
        break label1026;
      }
      i = 1;
      break label984;
      label398:
      Log.i("MicroMsg.ContactWidgetTabBizInfo", kotlin.g.b.s.X("update, VideoTabType is ", localObject1));
      if ((!bool) || (localObject2 != null)) {
        break label725;
      }
      if (this.NdW != null) {
        break label951;
      }
      localObject1 = this.NdO;
      paramqm = (qm)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("menuTabLayout");
        paramqm = null;
      }
      localObject1 = this.NdH.getString(R.l.finder_title);
      kotlin.g.b.s.s(localObject1, "context.getString(R.string.finder_title)");
      paramqm.setVideoTabText((String)localObject1);
      paramqm = (br)com.tencent.mm.kernel.h.ax(br.class);
      localObject1 = this.contact;
      kotlin.g.b.s.checkNotNull(localObject1);
      this.NdW = paramqm.aE(((az)localObject1).field_username, getFeedId()).getFragment();
      paramqm = this.NdW;
      localObject1 = this.fragments;
      kotlin.g.b.s.checkNotNull(paramqm);
      ((List)localObject1).add(paramqm);
      Log.i("MicroMsg.ContactWidgetTabBizInfo", "add finder fragment");
      label555:
      if (j != this.fragments.size())
      {
        localObject2 = this.NdN;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          kotlin.g.b.s.bIx("pagerAdapter");
          localObject1 = null;
        }
        ((a)localObject1).notifyDataSetChanged();
      }
      a(paramqm, bool);
      AppMethodBeat.o(305985);
      return;
      i = 0;
      break label957;
      localObject1 = null;
      break;
      label624:
      i = 0;
      break label964;
      label629:
      i = 0;
      break label229;
      label634:
      localObject1 = ((py)localObject1).YUi;
      if (localObject1 == null) {
        break label1021;
      }
      if (!((Collection)localObject1).isEmpty()) {
        break label1016;
      }
      i = 1;
      break label1006;
      label664:
      if ((i == 0) || (localObject3 == null)) {
        break label974;
      }
      this.fragments.remove(localObject3);
      break label974;
      label688:
      localObject1 = Integer.valueOf(paramqm.YVx);
    }
    label1026:
    label1029:
    for (;;)
    {
      if (((Integer)localObject1).intValue() == 0)
      {
        i = 1;
        break label995;
        label713:
        if (((Integer)localObject1).intValue() != 1) {
          break label1000;
        }
        break label398;
        label725:
        if ((i != 0) && (localObject2 == null))
        {
          localObject2 = new BizProfileTabVideoFragment();
          localObject1 = this.NcO;
          paramqm = (qm)localObject1;
          if (localObject1 == null) {
            paramqm = new qm();
          }
          ((BizProfileTabVideoFragment)localObject2).f(paramqm);
          paramqm = new Bundle();
          localObject1 = this.contact;
          kotlin.g.b.s.checkNotNull(localObject1);
          localObject1 = ((az)localObject1).field_username;
          kotlin.g.b.s.s(localObject1, "contact!!.username");
          com.tencent.mm.plugin.handoff.c.b.a(paramqm, "contact", (String)localObject1);
          localObject1 = ah.aiuX;
          ((BizProfileTabVideoFragment)localObject2).setArguments(paramqm);
          ((BizProfileTabVideoFragment)localObject2).b(gCN());
          localObject1 = (Fragment)localObject2;
          localObject2 = this.NdO;
          paramqm = (qm)localObject2;
          if (localObject2 == null)
          {
            kotlin.g.b.s.bIx("menuTabLayout");
            paramqm = null;
          }
          localObject2 = this.NdH.getString(R.l.gvJ);
          kotlin.g.b.s.s(localObject2, "context.getString(R.stri…z_profile_tab_name_video)");
          paramqm.setVideoTabText((String)localObject2);
          this.fragments.add(localObject1);
          Log.i("MicroMsg.ContactWidgetTabBizInfo", "update mp fragment");
          paramqm = (qm)localObject1;
          break label555;
        }
        if ((i == 0) && (!bool) && (localObject2 != null))
        {
          this.fragments.remove(localObject2);
          Log.i("MicroMsg.ContactWidgetTabBizInfo", "remove fragment");
        }
        label951:
        paramqm = (qm)localObject2;
        break label555;
        label957:
        if (i == 0) {
          break;
        }
        break label172;
        label964:
        if (i != 1) {
          break label629;
        }
        i = 1;
        break label229;
        label974:
        if (paramqm != null) {
          break label688;
        }
        localObject1 = null;
        break label359;
      }
      for (;;)
      {
        label984:
        if ((i != 0) && (localObject1 != null)) {
          break label1029;
        }
        i = 0;
        label995:
        if (localObject1 != null) {
          break label713;
        }
        label1000:
        bool = false;
        break;
        for (;;)
        {
          label1006:
          if (i != 1) {
            break label1021;
          }
          i = 1;
          break;
          label1016:
          i = 0;
        }
        label1021:
        i = 0;
        break label664;
        i = 0;
      }
    }
  }
  
  private static final boolean d(ContactWidgetTabBizInfo paramContactWidgetTabBizInfo, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(306146);
    kotlin.g.b.s.u(paramContactWidgetTabBizInfo, "this$0");
    paramContactWidgetTabBizInfo = paramContactWidgetTabBizInfo.NdM;
    if (paramContactWidgetTabBizInfo != null) {
      paramContactWidgetTabBizInfo.gCA();
    }
    AppMethodBeat.o(306146);
    return true;
  }
  
  private final void gBx()
  {
    AppMethodBeat.i(305965);
    dvq();
    if (this.contact == null)
    {
      AppMethodBeat.o(305965);
      return;
    }
    gCQ();
    AppMethodBeat.o(305965);
  }
  
  private final String gCM()
  {
    AppMethodBeat.i(305921);
    String str = (String)this.NdQ.getValue();
    AppMethodBeat.o(305921);
    return str;
  }
  
  private final BizProfileDataFetcher gCN()
  {
    AppMethodBeat.i(305930);
    BizProfileDataFetcher localBizProfileDataFetcher = (BizProfileDataFetcher)this.NdS.getValue();
    AppMethodBeat.o(305930);
    return localBizProfileDataFetcher;
  }
  
  private final int gCO()
  {
    AppMethodBeat.i(305936);
    int i = ((Number)this.NdT.getValue()).intValue();
    AppMethodBeat.o(305936);
    return i;
  }
  
  private final boolean gCP()
  {
    AppMethodBeat.i(305946);
    boolean bool = ((Boolean)this.NdU.getValue()).booleanValue();
    AppMethodBeat.o(305946);
    return bool;
  }
  
  private final void gCQ()
  {
    int j = 0;
    Object localObject3 = null;
    AppMethodBeat.i(305960);
    Object localObject1 = this.contact;
    Object localObject2;
    label76:
    int i;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject1 = com.tencent.mm.an.g.hU((String)localObject1);
      this.hcB = null;
      this.hcC = null;
      if (((localObject1 != null) && (((com.tencent.mm.api.c)localObject1).dO(false) != null)) || (this.MWY == null)) {
        break label528;
      }
      localObject2 = new com.tencent.mm.api.c();
      localObject1 = this.contact;
      if (localObject1 != null) {
        break label186;
      }
      localObject1 = null;
      ((com.tencent.mm.api.c)localObject2).field_username = ((String)localObject1);
      localObject1 = this.MWY;
      if (localObject1 != null) {
        break label194;
      }
      i = 0;
      label93:
      ((com.tencent.mm.api.c)localObject2).field_brandFlag = i;
      localObject1 = this.MWY;
      if (localObject1 != null) {
        break label202;
      }
      localObject1 = null;
      label110:
      ((com.tencent.mm.api.c)localObject2).field_brandIconURL = ((String)localObject1);
      localObject1 = this.MWY;
      if (localObject1 != null) {
        break label210;
      }
      localObject1 = null;
      label127:
      ((com.tencent.mm.api.c)localObject2).field_brandInfo = ((String)localObject1);
      localObject1 = this.MWY;
      if (localObject1 != null) {
        break label218;
      }
      localObject1 = null;
      label144:
      ((com.tencent.mm.api.c)localObject2).field_extInfo = ((String)localObject1);
      ((com.tencent.mm.api.c)localObject2).field_type = ((com.tencent.mm.api.c)localObject2).dO(false).getServiceType();
      localObject1 = localObject2;
    }
    label390:
    label520:
    label528:
    for (;;)
    {
      if (localObject1 == null)
      {
        AppMethodBeat.o(305960);
        return;
        localObject1 = ((az)localObject1).field_username;
        break;
        label186:
        localObject1 = ((az)localObject1).field_username;
        break label76;
        label194:
        i = ((ahl)localObject1).pSt;
        break label93;
        label202:
        localObject1 = ((ahl)localObject1).pSw;
        break label110;
        label210:
        localObject1 = ((ahl)localObject1).pSv;
        break label127;
        label218:
        localObject1 = ((ahl)localObject1).pSu;
        break label144;
      }
      if ((((com.tencent.mm.api.c)localObject1).field_brandInfo == null) && (((com.tencent.mm.api.c)localObject1).field_extInfo == null) && (this.MWY != null))
      {
        localObject2 = this.contact;
        if (localObject2 == null)
        {
          localObject2 = null;
          ((com.tencent.mm.api.c)localObject1).field_username = ((String)localObject2);
          localObject2 = this.MWY;
          if (localObject2 != null) {
            break label465;
          }
          i = 0;
          label280:
          ((com.tencent.mm.api.c)localObject1).field_brandFlag = i;
          localObject2 = this.MWY;
          if (localObject2 != null) {
            break label474;
          }
          localObject2 = null;
          label299:
          ((com.tencent.mm.api.c)localObject1).field_brandIconURL = ((String)localObject2);
          localObject2 = this.MWY;
          if (localObject2 != null) {
            break label484;
          }
          localObject2 = null;
          label319:
          ((com.tencent.mm.api.c)localObject1).field_brandInfo = ((String)localObject2);
          localObject2 = this.MWY;
          if (localObject2 != null) {
            break label494;
          }
          localObject2 = null;
          label339:
          ((com.tencent.mm.api.c)localObject1).field_extInfo = ((String)localObject2);
          ((com.tencent.mm.api.c)localObject1).field_type = ((com.tencent.mm.api.c)localObject1).dO(false).getServiceType();
        }
      }
      else
      {
        this.MVg = ((com.tencent.mm.api.c)localObject1);
        this.hcB = ((com.tencent.mm.api.c)localObject1).aAY();
        this.hcC = ((com.tencent.mm.api.c)localObject1).dO(false);
        localObject1 = this.hcC;
        if (localObject1 != null) {
          break label504;
        }
        localObject1 = null;
        if (localObject1 != null)
        {
          localObject1 = this.hcC;
          if (localObject1 != null) {
            break label512;
          }
          localObject1 = null;
          label405:
          localObject1 = (CharSequence)localObject1;
          if (localObject1 != null)
          {
            i = j;
            if (((CharSequence)localObject1).length() != 0) {}
          }
          else
          {
            i = 1;
          }
          if (i != 0)
          {
            localObject1 = this.hcC;
            if (localObject1 != null) {
              break label520;
            }
          }
        }
      }
      for (localObject1 = localObject3;; localObject1 = ((c.b)localObject1).aBc())
      {
        this.hcL = ((String)localObject1);
        AppMethodBeat.o(305960);
        return;
        localObject2 = ((az)localObject2).field_username;
        break;
        label465:
        i = ((ahl)localObject2).pSt;
        break label280;
        label474:
        localObject2 = ((ahl)localObject2).pSw;
        break label299;
        label484:
        localObject2 = ((ahl)localObject2).pSv;
        break label319;
        label494:
        localObject2 = ((ahl)localObject2).pSu;
        break label339;
        label504:
        localObject1 = ((c.b)localObject1).aBc();
        break label390;
        localObject1 = ((c.b)localObject1).aBc();
        break label405;
      }
    }
  }
  
  private final void gCR()
  {
    AppMethodBeat.i(306042);
    com.tencent.mm.autogen.a.au localau = new com.tencent.mm.autogen.a.au();
    au.a locala = localau.hAy;
    Object localObject = this.contact;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((az)localObject).field_username)
    {
      locala.userName = ((String)localObject);
      localau.publish();
      AppMethodBeat.o(306042);
      return;
    }
  }
  
  private final long getFeedId()
  {
    AppMethodBeat.i(306001);
    long l = ((Number)this.Blq.getValue()).longValue();
    AppMethodBeat.o(306001);
    return l;
  }
  
  private final String getSearchId()
  {
    AppMethodBeat.i(305925);
    String str = (String)this.NdR.getValue();
    AppMethodBeat.o(305925);
    return str;
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, com.tencent.mm.storage.au paramau, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(306285);
    if (this.NdH.isFinishing())
    {
      AppMethodBeat.o(306285);
      return true;
    }
    if (paramau != null)
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      if (paramau != null) {
        break label147;
      }
      localObject1 = null;
      label43:
      localObject1 = Util.nullAsNil((String)localObject1);
      kotlin.g.b.s.s(localObject1, "nullAsNil(contact?.username)");
      if (((CharSequence)localObject1).length() <= 0) {
        break label156;
      }
      bool1 = true;
      label74:
      Assert.assertTrue(bool1);
      if (paramf == null) {
        break label162;
      }
    }
    label147:
    label156:
    label162:
    for (boolean bool1 = true;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      ao(paramau);
      localObject1 = ((Iterable)this.NdI).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((com.tencent.mm.plugin.profile.ui.tab.observer.a)((Iterator)localObject1).next()).a(paramf, paramau);
      }
      bool1 = false;
      break;
      localObject1 = paramau.field_username;
      break label43;
      bool1 = false;
      break label74;
    }
    this.contact = paramau;
    this.MVt = paramBoolean;
    this.pUt = paramInt;
    this.MXc = this.NdH.getIntent().getIntExtra("add_more_friend_search_scene", 0);
    Object localObject1 = this.NdH.getIntent().getStringExtra("key_channel_session_id");
    paramf = (com.tencent.mm.ui.base.preference.f)localObject1;
    if (localObject1 == null) {
      paramf = "";
    }
    this.Nds = paramf;
    if ((this.pUt == 78) || (this.pUt == 79))
    {
      this.Ndo = false;
      Log.i("MicroMsg.ContactWidgetTabBizInfo", "updateBizTeenModeStatus addContactScene: %d not need to block", new Object[] { Integer.valueOf(this.pUt) });
      if (!this.NdJ) {
        break label2032;
      }
      this.NdJ = false;
      paramf = this.NdH.findViewById(R.h.mm_preference_list_content);
      if (paramf != null) {
        paramf.setVisibility(8);
      }
      paramf = this.NdH.getListView();
      if (paramf != null) {
        paramf.setVisibility(8);
      }
      paramf = this.NdH.findViewById(R.h.preference_bottom);
      if (paramf != null) {
        paramf.setVisibility(8);
      }
      if (!MultiProcessMMKV.getMMKV("test_biz_profile").getBoolean("noCache", false)) {
        break label1725;
      }
      this.NcO = new qm();
      this.NdH.findViewById(R.h.mm_preference_list_content_root);
      paramf = LayoutInflater.from((Context)this.NdH).inflate(R.i.ghW, null);
      kotlin.g.b.s.s(paramf, "inflater.inflate(R.layou…ntact_info_biz_tab, null)");
      this.contentView = paramf;
      localObject2 = this.NdH;
      localObject1 = this.contentView;
      paramf = (com.tencent.mm.ui.base.preference.f)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("contentView");
        paramf = null;
      }
      ((ContactInfoUI)localObject2).setContentView(paramf);
      localObject1 = this.contentView;
      paramf = (com.tencent.mm.ui.base.preference.f)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("contentView");
        paramf = null;
      }
      paramf = paramf.findViewById(R.h.fBr);
      kotlin.g.b.s.s(paramf, "contentView.findViewById…(R.id.combo_content_view)");
      this.dyl = ((ViewPager)paramf);
      localObject1 = this.contentView;
      paramf = (com.tencent.mm.ui.base.preference.f)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("contentView");
        paramf = null;
      }
      paramf = paramf.findViewById(R.h.fuf);
      kotlin.g.b.s.s(paramf, "contentView.findViewById…_profile_menu_tab_layout)");
      this.NdO = ((BizProfileTabLayout)paramf);
      paramf = this.NdO;
      if (paramf != null) {
        break label1754;
      }
      kotlin.g.b.s.bIx("menuTabLayout");
      paramf = null;
      paramf.setOnTabSelected((kotlin.g.a.b)new g(this));
      paramf = this.NdO;
      if (paramf != null) {
        break label1757;
      }
      kotlin.g.b.s.bIx("menuTabLayout");
      paramf = null;
      paramf.setOnServiceTabSelected((kotlin.g.a.a)new h(this));
      localObject2 = (MMActivity)this.NdH;
      localObject1 = this.contentView;
      paramf = (com.tencent.mm.ui.base.preference.f)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("contentView");
        paramf = null;
      }
      paramf = new ContactWidgetTabBizHeaderController((MMActivity)localObject2, paramf);
      paramf.Ndr = ((ContactWidgetTabBizHeaderController.a)new i(this));
      localObject1 = ah.aiuX;
      this.NdM = paramf;
      localf = new ah.f();
      bool1 = false;
      localObject2 = this.NcO;
      bool2 = bool1;
      if (localObject2 != null)
      {
        if (gCO() == 1)
        {
          paramf = ((qm)localObject2).YVp;
          if (paramf == null) {
            break label1766;
          }
          paramf = paramf.YUi;
          if (paramf == null) {
            break label1766;
          }
          if (!((Collection)paramf).isEmpty()) {
            break label1760;
          }
          i = 1;
          if (i != 1) {
            break label1766;
          }
          i = 1;
          if (i != 0)
          {
            bool2 = bool1;
            if (((qm)localObject2).YVx != 1) {
              break label1183;
            }
          }
        }
        paramf = ((qm)localObject2).YVn;
        if (paramf == null) {
          break label1778;
        }
        paramf = paramf.YUi;
        if (paramf == null) {
          break label1778;
        }
        if (((Collection)paramf).isEmpty()) {
          break label1772;
        }
        i = 1;
        if (i != 1) {
          break label1778;
        }
        i = 1;
        if (i != 0)
        {
          localList = this.fragments;
          localBizProfileTabMsgFragment = new BizProfileTabMsgFragment();
          localObject1 = this.NcO;
          paramf = (com.tencent.mm.ui.base.preference.f)localObject1;
          if (localObject1 == null) {
            paramf = new qm();
          }
          localBizProfileTabMsgFragment.f(paramf);
          paramf = new Bundle();
          localObject1 = this.contact;
          kotlin.g.b.s.checkNotNull(localObject1);
          localObject1 = ((az)localObject1).field_username;
          kotlin.g.b.s.s(localObject1, "contact!!.username");
          com.tencent.mm.plugin.handoff.c.b.a(paramf, "contact", (String)localObject1);
          localObject1 = ah.aiuX;
          localBizProfileTabMsgFragment.setArguments(paramf);
          localBizProfileTabMsgFragment.b(gCN());
          localBizProfileTabMsgFragment.enterTime = this.enterTime;
          localBizProfileTabMsgFragment.Nev = this.NdM;
          paramf = ah.aiuX;
          localList.add(localBizProfileTabMsgFragment);
        }
        paramf = ((qm)localObject2).YVp;
        if (paramf == null) {
          break label1784;
        }
        paramf = paramf.YUi;
        if ((paramf == null) || (((Collection)paramf).isEmpty())) {
          break label1784;
        }
        i = 1;
        if ((i == 0) || (((qm)localObject2).YVx != 0)) {
          break label1790;
        }
        i = 1;
        if (((qm)localObject2).YVx != 1) {
          break label1796;
        }
        bool1 = true;
        Log.i("MicroMsg.ContactWidgetTabBizInfo", kotlin.g.b.s.X("init, VideoTabType is ", Integer.valueOf(((qm)localObject2).YVx)));
        if (!bool1) {
          break label1802;
        }
        if (this.NdW == null)
        {
          paramf = (br)com.tencent.mm.kernel.h.ax(br.class);
          localObject1 = this.contact;
          kotlin.g.b.s.checkNotNull(localObject1);
          this.NdW = paramf.aE(((az)localObject1).field_username, getFeedId()).getFragment();
        }
        localf.aqH = this.NdW;
        localObject1 = this.NdO;
        paramf = (com.tencent.mm.ui.base.preference.f)localObject1;
        if (localObject1 == null)
        {
          kotlin.g.b.s.bIx("menuTabLayout");
          paramf = null;
        }
        localObject1 = this.NdH.getString(R.l.finder_title);
        kotlin.g.b.s.s(localObject1, "context.getString(R.string.finder_title)");
        paramf.setVideoTabText((String)localObject1);
        paramf = this.fragments;
        localObject1 = localf.aqH;
        kotlin.g.b.s.checkNotNull(localObject1);
        paramf.add(localObject1);
        bool2 = bool1;
      }
      label1183:
      this.NdN = new a(this.fragments, this.NdH.getSupportFragmentManager());
      paramf = this.dyl;
      if (paramf != null) {
        break label2020;
      }
      kotlin.g.b.s.bIx("viewPager");
      paramf = null;
      localObject2 = this.NdN;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("pagerAdapter");
        localObject1 = null;
      }
      paramf.setAdapter((androidx.viewpager.widget.a)localObject1);
      localObject1 = this.NdN;
      paramf = (com.tencent.mm.ui.base.preference.f)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("pagerAdapter");
        paramf = null;
      }
      paramf.notifyDataSetChanged();
      paramf = this.dyl;
      if (paramf != null) {
        break label2023;
      }
      kotlin.g.b.s.bIx("viewPager");
      paramf = null;
      paramf.addOnPageChangeListener((ViewPager.OnPageChangeListener)new j(this, localf));
      a((Fragment)localf.aqH, bool2);
      AH(false);
      paramf = new androidx.core.g.d((Context)this.NdH, (GestureDetector.OnGestureListener)new f(this));
      localObject1 = this.NdH.getSupportActionBar();
      if (localObject1 != null)
      {
        localObject1 = ((ActionBar)localObject1).getCustomView();
        if (localObject1 != null)
        {
          localObject1 = ((View)localObject1).findViewById(a.g.actionbar_center_layout);
          if (localObject1 != null) {
            ((View)localObject1).setOnTouchListener(new ContactWidgetTabBizInfo..ExternalSyntheticLambda4(paramf));
          }
        }
      }
      this.NdH.setMMTitleColor(androidx.core.content.a.w((Context)this.NdH, R.e.FG_0));
      this.NdH.setMMTitle(this.NdH.getString(R.l.gvI));
      this.NdH.setMMTitleVisibility(0);
      this.NdH.setTitleDividerVis(false);
      this.NdH.setIsDarkActionbarBg(false);
      this.NdH.setActionbarColor(this.NdH.getResources().getColor(R.e.BG_2));
      this.NdH.hideActionbarLine();
      this.NdH.setBackBtn(new ContactWidgetTabBizInfo..ExternalSyntheticLambda2(this), R.k.actionbar_icon_dark_back);
      aH(true, true);
      gBx();
      if (paramau != null) {
        af.bHt().Mh(paramau.field_username);
      }
      gCN().Nei.a((androidx.lifecycle.q)this.NdH, new ContactWidgetTabBizInfo..ExternalSyntheticLambda5(this));
      if (paramau != null)
      {
        if ((!com.tencent.mm.contact.d.rs(paramau.field_type)) || ((int)paramau.maN <= 0)) {
          break label2026;
        }
        bool1 = true;
        this.NdP = bool1;
      }
      gCN().gCS();
    }
    label1725:
    label1754:
    label1757:
    label1760:
    label1766:
    label1772:
    label1778:
    label1784:
    label1790:
    while (paramau == null) {
      for (;;)
      {
        Object localObject2;
        final ah.f localf;
        int i;
        List localList;
        BizProfileTabMsgFragment localBizProfileTabMsgFragment;
        paramf = this.NdM;
        if (paramf != null) {
          paramf.a(paramau, this.MVy, this.MVg, this.NcO, paramInt, paramBoolean);
        }
        AppMethodBeat.o(306285);
        return true;
        boolean bool2 = ((com.tencent.mm.api.r)com.tencent.mm.kernel.h.ax(com.tencent.mm.api.r.class)).aBv();
        if (!bool2) {}
        for (bool1 = true;; bool1 = false)
        {
          this.Ndo = bool1;
          Log.i("MicroMsg.ContactWidgetTabBizInfo", "updateBizTeenModeStatus addContactScene: %d, blockAddContact: %b, isBizTeenModeAllowAll: %b", new Object[] { Integer.valueOf(this.pUt), Boolean.valueOf(this.Ndo), Boolean.valueOf(bool2) });
          break;
        }
        paramf = this.contact;
        if (paramf != null)
        {
          paramf = paramf.field_username;
          if (paramf != null)
          {
            this.NcO = com.tencent.mm.plugin.profile.ui.newbizinfo.b.aSd(paramf);
            continue;
            continue;
            continue;
            i = 0;
            continue;
            i = 0;
            continue;
            i = 0;
            continue;
            i = 0;
            continue;
            i = 0;
            continue;
            i = 0;
            continue;
            bool1 = false;
            continue;
            bool2 = bool1;
            if (i != 0)
            {
              localObject2 = new BizProfileTabVideoFragment();
              localObject1 = this.NcO;
              paramf = (com.tencent.mm.ui.base.preference.f)localObject1;
              if (localObject1 == null) {
                paramf = new qm();
              }
              ((BizProfileTabVideoFragment)localObject2).f(paramf);
              paramf = new Bundle();
              localObject1 = this.contact;
              kotlin.g.b.s.checkNotNull(localObject1);
              localObject1 = ((az)localObject1).field_username;
              kotlin.g.b.s.s(localObject1, "contact!!.username");
              com.tencent.mm.plugin.handoff.c.b.a(paramf, "contact", (String)localObject1);
              localObject1 = ah.aiuX;
              ((BizProfileTabVideoFragment)localObject2).setArguments(paramf);
              ((BizProfileTabVideoFragment)localObject2).b(gCN());
              this.enterTime = this.enterTime;
              ((BaseBizProfileFragment)localObject2).Nev = this.NdM;
              paramf = ah.aiuX;
              localf.aqH = localObject2;
              localObject1 = this.NdO;
              paramf = (com.tencent.mm.ui.base.preference.f)localObject1;
              if (localObject1 == null)
              {
                kotlin.g.b.s.bIx("menuTabLayout");
                paramf = null;
              }
              localObject1 = this.NdH.getString(R.l.gvJ);
              kotlin.g.b.s.s(localObject1, "context.getString(R.stri…z_profile_tab_name_video)");
              paramf.setVideoTabText((String)localObject1);
              paramf = this.fragments;
              localObject1 = localf.aqH;
              kotlin.g.b.s.checkNotNull(localObject1);
              paramf.add(localObject1);
              bool2 = bool1;
              continue;
              continue;
              continue;
              bool1 = false;
            }
          }
        }
      }
    }
    label1796:
    label1802:
    label2020:
    label2023:
    label2026:
    label2032:
    if ((com.tencent.mm.contact.d.rs(paramau.field_type)) && ((int)paramau.maN > 0)) {}
    for (bool1 = true;; bool1 = false)
    {
      if (this.NdP != bool1)
      {
        gCN().gCS();
        aH(true, true);
      }
      this.NdP = bool1;
      break;
    }
  }
  
  public final boolean aXx()
  {
    AppMethodBeat.i(306301);
    if ((this.contact != null) && (this.MVg != null) && (this.NcO != null))
    {
      localObject = this.NcO;
      kotlin.g.b.s.checkNotNull(localObject);
      if (((qm)localObject).YVm != null)
      {
        localObject = this.NcO;
        kotlin.g.b.s.checkNotNull(localObject);
        if (((qm)localObject).YVl != null) {
          break label180;
        }
      }
    }
    Log.w("MicroMsg.ContactWidgetTabBizInfo", "reportEnd fail, err");
    Object localObject = this.NcO;
    label88:
    String str2;
    label109:
    String str3;
    if (localObject == null)
    {
      localObject = null;
      str2 = w.a((com.tencent.mm.bx.b)localObject);
      localObject = this.NcO;
      if (localObject != null) {
        break label462;
      }
      localObject = null;
      str3 = w.a((com.tencent.mm.bx.b)localObject);
      localObject = (CharSequence)str2;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label490;
      }
      i = 1;
      label140:
      if (i == 0)
      {
        localObject = (CharSequence)str3;
        if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
          break label495;
        }
      }
    }
    label180:
    String str1;
    label256:
    label302:
    label462:
    label490:
    label495:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label500;
      }
      AppMethodBeat.o(306301);
      return true;
      l1 = System.currentTimeMillis();
      localObject = this.contact;
      kotlin.g.b.s.checkNotNull(localObject);
      str1 = ((az)localObject).field_username;
      int k = this.pUt;
      localObject = this.MVg;
      kotlin.g.b.s.checkNotNull(localObject);
      int m = ((com.tencent.mm.api.c)localObject).field_type;
      long l2 = this.enterTime;
      localObject = this.contact;
      kotlin.g.b.s.checkNotNull(localObject);
      int n;
      int j;
      if (com.tencent.mm.contact.d.rs(((az)localObject).field_type))
      {
        i = 1;
        localObject = this.NcO;
        kotlin.g.b.s.checkNotNull(localObject);
        n = ((qm)localObject).YVm.YRw;
        localObject = this.NcO;
        kotlin.g.b.s.checkNotNull(localObject);
        localObject = ((qm)localObject).YVm;
        if (localObject != null) {
          break label415;
        }
        j = 0;
        localObject = this.NcO;
        kotlin.g.b.s.checkNotNull(localObject);
        str2 = com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.b(((qm)localObject).YVn);
        localObject = this.NcO;
        kotlin.g.b.s.checkNotNull(localObject);
        str3 = com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.a(((qm)localObject).YVq);
        localObject = this.NcO;
        kotlin.g.b.s.checkNotNull(localObject);
        localObject = ((qm)localObject).YVl;
        if (localObject != null) {
          break label424;
        }
      }
      for (localObject = null;; localObject = ((nj)localObject).UserName)
      {
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.a(str1, k, m, l2, l1, i, n, j, str2, str3, (String)localObject, getSearchId(), gCM(), this.NdH.getIntent());
        break;
        i = 0;
        break label256;
        j = ((ol)localObject).YRx;
        break label302;
      }
      localObject = ((qm)localObject).YVw;
      if (localObject == null)
      {
        localObject = null;
        break label88;
      }
      localObject = ((rp)localObject).YWz;
      break label88;
      localObject = ((qm)localObject).YVw;
      if (localObject == null)
      {
        localObject = null;
        break label109;
      }
      localObject = ((rp)localObject).YWA;
      break label109;
      i = 0;
      break label140;
    }
    label415:
    label424:
    label500:
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.OAn;
    long l1 = this.enterTime;
    localObject = this.contact;
    if (localObject == null) {
      localObject = "";
    }
    for (;;)
    {
      localh.b(22118, new Object[] { Long.valueOf(l1), localObject, Integer.valueOf(1), str2, str3 });
      localObject = this.NdM;
      if ((localObject != null) && (((ContactWidgetTabBizHeaderController)localObject).Ixi != null))
      {
        ((ContactWidgetTabBizHeaderController)localObject).Ixi.dead();
        ((ContactWidgetTabBizHeaderController)localObject).Ixi = null;
      }
      AppMethodBeat.o(306301);
      return true;
      str1 = ((az)localObject).field_username;
      localObject = str1;
      if (str1 == null) {
        localObject = "";
      }
    }
  }
  
  public final boolean anl(String paramString)
  {
    return true;
  }
  
  public final boolean dvq()
  {
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(306291);
    Log.i("MicroMsg.ContactWidgetTabBizInfo", "onActivityResult, requestCode = %d, resultCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    Object localObject;
    if (paramInt1 == this.Nee)
    {
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        localObject = paramIntent.getStringExtra("be_send_card_name");
        String str = paramIntent.getStringExtra("received_card_name");
        boolean bool = paramIntent.getBooleanExtra("Is_Chatroom", false);
        paramIntent = paramIntent.getStringExtra("custom_send_text");
        com.tencent.mm.plugin.messenger.a.g.gaI().B((String)localObject, str, bool);
        com.tencent.mm.plugin.messenger.a.g.gaI().ke(paramIntent, str);
        com.tencent.mm.ui.widget.snackbar.b.u((Activity)this.NdH, this.NdH.getString(R.l.finish_sent));
        AppMethodBeat.o(306291);
      }
    }
    else if (paramInt1 == 10010)
    {
      localObject = this.NdW;
      if (localObject != null)
      {
        ((Fragment)localObject).onActivityResult(paramInt1, paramInt2, paramIntent);
        AppMethodBeat.o(306291);
      }
    }
    else
    {
      AppMethodBeat.o(306291);
      return;
    }
    AppMethodBeat.o(306291);
  }
  
  public final boolean onCreate()
  {
    AppMethodBeat.i(306270);
    if ((this.contact == null) || (this.MVg == null))
    {
      Log.w("MicroMsg.ContactWidgetTabBizInfo", "reportStart fail, err");
      localObject1 = this.NdM;
      if ((localObject1 != null) && (((ContactWidgetTabBizHeaderController)localObject1).Ixi == null) && (ContactWidgetTabBizHeaderController.dbC()))
      {
        ((ContactWidgetTabBizHeaderController)localObject1).Ixi = new ContactWidgetTabBizHeaderController.BizFinderLineStatusChangedEventListenerImpl((ContactWidgetTabBizHeaderController)localObject1);
        ((ContactWidgetTabBizHeaderController)localObject1).Ixi.alive();
      }
      AppMethodBeat.o(306270);
      return true;
    }
    Object localObject1 = this.contact;
    kotlin.g.b.s.checkNotNull(localObject1);
    localObject1 = ((az)localObject1).field_username;
    int j = this.pUt;
    Object localObject2 = this.MVg;
    kotlin.g.b.s.checkNotNull(localObject2);
    int k = ((com.tencent.mm.api.c)localObject2).field_type;
    long l = this.enterTime;
    localObject2 = this.contact;
    kotlin.g.b.s.checkNotNull(localObject2);
    if (com.tencent.mm.contact.d.rs(((az)localObject2).field_type)) {}
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.a((String)localObject1, j, k, l, i, this.Nds, getSearchId(), gCM(), this.NdH.getIntent());
      break;
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(306297);
    Object localObject = this.NdM;
    if ((localObject != null) && (((ContactWidgetTabBizHeaderController)localObject).Ixk != null)) {
      ((ContactWidgetTabBizHeaderController)localObject).Ixk.stopCheck();
    }
    if ((this.NdH.isFinishing()) && (this.NdW != null))
    {
      localObject = this.NdW;
      if (!(localObject instanceof br.a)) {
        break label82;
      }
    }
    label82:
    for (localObject = (br.a)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((br.a)localObject).dUW();
      }
      AppMethodBeat.o(306297);
      return;
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(306295);
    ContactWidgetTabBizHeaderController localContactWidgetTabBizHeaderController = this.NdM;
    if (localContactWidgetTabBizHeaderController != null)
    {
      if (ContactWidgetTabBizHeaderController.dbC())
      {
        if (localContactWidgetTabBizHeaderController.Ixk == null) {
          localContactWidgetTabBizHeaderController.Ixk = ((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).GX(8);
        }
        ((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).dbE();
        localContactWidgetTabBizHeaderController.Ixk.aiO(localContactWidgetTabBizHeaderController.hAw);
      }
      localContactWidgetTabBizHeaderController.Ndm.gCy();
    }
    AppMethodBeat.o(306295);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizInfo$BizProfilePagerAdapter;", "Landroidx/fragment/app/FragmentStatePagerAdapter;", "fragments", "", "Landroidx/fragment/app/Fragment;", "fm", "Landroidx/fragment/app/FragmentManager;", "(Ljava/util/List;Landroidx/fragment/app/FragmentManager;)V", "getFragments", "()Ljava/util/List;", "getCount", "", "getItem", "i", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends androidx.fragment.app.p
  {
    final List<Fragment> fragments;
    
    public a(List<? extends Fragment> paramList, FragmentManager paramFragmentManager)
    {
      super();
      AppMethodBeat.i(305852);
      this.fragments = paramList;
      AppMethodBeat.o(305852);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(305861);
      int i = this.fragments.size();
      AppMethodBeat.o(305861);
      return i;
    }
    
    public final Fragment getItem(int paramInt)
    {
      AppMethodBeat.i(305865);
      Fragment localFragment = (Fragment)this.fragments.get(paramInt);
      AppMethodBeat.o(305865);
      return localFragment;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<Integer>
  {
    c(ContactWidgetTabBizInfo paramContactWidgetTabBizInfo)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<Boolean>
  {
    d(ContactWidgetTabBizInfo paramContactWidgetTabBizInfo)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<Long>
  {
    e(ContactWidgetTabBizInfo paramContactWidgetTabBizInfo)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizInfo$initActionBar$detector$1", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "onDoubleTap", "", "e", "Landroid/view/MotionEvent;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    extends GestureDetector.SimpleOnGestureListener
  {
    f(ContactWidgetTabBizInfo paramContactWidgetTabBizInfo) {}
    
    public final boolean onContextClick(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(305855);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizInfo$initActionBar$detector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
      boolean bool = super.onContextClick(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizInfo$initActionBar$detector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(305855);
      return bool;
    }
    
    public final boolean onDoubleTap(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(305840);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizInfo$initActionBar$detector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
      ContactWidgetTabBizInfo.k(this.Nef);
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizInfo$initActionBar$detector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(305840);
      return true;
    }
    
    public final void onLongPress(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(305848);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizInfo$initActionBar$detector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aYj());
      super.onLongPress(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizInfo$initActionBar$detector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
      AppMethodBeat.o(305848);
    }
    
    public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(305845);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizInfo$initActionBar$detector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
      boolean bool = super.onSingleTapUp(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizInfo$initActionBar$detector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(305845);
      return bool;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "position", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.b<Integer, ah>
  {
    g(ContactWidgetTabBizInfo paramContactWidgetTabBizInfo)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<ah>
  {
    h(ContactWidgetTabBizInfo paramContactWidgetTabBizInfo)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizInfo$initView$3$1", "Lcom/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$OnAppBarExpandListener;", "onActionBarStyleChange", "", "expand", "", "onExpand", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class i
    implements ContactWidgetTabBizHeaderController.a
  {
    i(ContactWidgetTabBizInfo paramContactWidgetTabBizInfo) {}
    
    public final void AG(boolean paramBoolean)
    {
      AppMethodBeat.i(305836);
      ContactWidgetTabBizInfo.a(this.Nef, paramBoolean);
      AppMethodBeat.o(305836);
    }
    
    public final void gCL()
    {
      AppMethodBeat.i(305833);
      Object localObject2 = ContactWidgetTabBizInfo.b(this.Nef);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("viewPager");
        localObject1 = null;
      }
      int j = ((ViewPager)localObject1).getCurrentItem();
      localObject2 = ContactWidgetTabBizInfo.b(this.Nef);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("viewPager");
        localObject1 = null;
      }
      if (((ViewPager)localObject1).getCurrentItem() > ContactWidgetTabBizInfo.a(this.Nef).size() - 1)
      {
        AppMethodBeat.o(305833);
        return;
      }
      Object localObject3 = (Iterable)ContactWidgetTabBizInfo.a(this.Nef);
      localObject1 = this.Nef;
      localObject2 = (Collection)new ArrayList();
      localObject3 = ((Iterable)localObject3).iterator();
      label185:
      while (((Iterator)localObject3).hasNext())
      {
        Object localObject4 = ((Iterator)localObject3).next();
        if (!kotlin.g.b.s.p((Fragment)localObject4, ContactWidgetTabBizInfo.a((ContactWidgetTabBizInfo)localObject1).get(j))) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label185;
          }
          ((Collection)localObject2).add(localObject4);
          break;
        }
      }
      localObject2 = ((Iterable)localObject2).iterator();
      label251:
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (Fragment)((Iterator)localObject2).next();
        if ((localObject1 instanceof com.tencent.mm.plugin.findersdk.a.r)) {}
        for (localObject1 = (com.tencent.mm.plugin.findersdk.a.r)localObject1;; localObject1 = null)
        {
          if (localObject1 == null) {
            break label251;
          }
          ((com.tencent.mm.plugin.findersdk.a.r)localObject1).dUU();
          break;
        }
      }
      AppMethodBeat.o(305833);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizInfo$initView$5", "Landroidx/viewpager/widget/ViewPager$SimpleOnPageChangeListener;", "onPageSelected", "", "position", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class j
    extends ViewPager.f
  {
    j(ContactWidgetTabBizInfo paramContactWidgetTabBizInfo, ah.f<Fragment> paramf) {}
    
    public final void onPageSelected(int paramInt)
    {
      AppMethodBeat.i(305827);
      if ((ContactWidgetTabBizInfo.g(this.Nef) != null) && (localf.aqH != null))
      {
        Object localObject2 = ContactWidgetTabBizInfo.h(this.Nef);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          kotlin.g.b.s.bIx("pagerAdapter");
          localObject1 = null;
        }
        localObject1 = (Fragment)kotlin.a.p.ae(((ContactWidgetTabBizInfo.a)localObject1).fragments, paramInt);
        if (localObject1 != null)
        {
          localObject2 = this.Nef;
          if (!kotlin.g.b.s.p(localObject1, ContactWidgetTabBizInfo.g((ContactWidgetTabBizInfo)localObject2)))
          {
            localObject1 = ContactWidgetTabBizInfo.g((ContactWidgetTabBizInfo)localObject2);
            if ((localObject1 instanceof br.a)) {}
            for (localObject1 = (br.a)localObject1; localObject1 != null; localObject1 = null)
            {
              ((br.a)localObject1).dUW();
              AppMethodBeat.o(305827);
              return;
            }
          }
          localObject1 = ContactWidgetTabBizInfo.g((ContactWidgetTabBizInfo)localObject2);
          if (!(localObject1 instanceof br.a)) {
            break label149;
          }
        }
      }
      label149:
      for (Object localObject1 = (br.a)localObject1;; localObject1 = null)
      {
        if (localObject1 != null) {
          ((br.a)localObject1).dUX();
        }
        AppMethodBeat.o(305827);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/profile/ui/tab/data/BizProfileDataFetcher;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements kotlin.g.a.a<BizProfileDataFetcher>
  {
    k(ContactWidgetTabBizInfo paramContactWidgetTabBizInfo)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends u
    implements kotlin.g.a.a<String>
  {
    l(ContactWidgetTabBizInfo paramContactWidgetTabBizInfo)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends u
    implements kotlin.g.a.a<String>
  {
    m(ContactWidgetTabBizInfo paramContactWidgetTabBizInfo)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends u
    implements kotlin.g.a.a<ah>
  {
    n(ContactWidgetTabBizInfo paramContactWidgetTabBizInfo)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "serviceInfo", "Lcom/tencent/mm/protocal/protobuf/BizServiceMenuButton;", "position", "", "index"}, k=3, mv={1, 5, 1}, xi=48)
  static final class o
    extends u
    implements kotlin.g.a.q<rg, Integer, Integer, ah>
  {
    o(ContactWidgetTabBizInfo paramContactWidgetTabBizInfo)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.ContactWidgetTabBizInfo
 * JD-Core Version:    0.7.0.1
 */