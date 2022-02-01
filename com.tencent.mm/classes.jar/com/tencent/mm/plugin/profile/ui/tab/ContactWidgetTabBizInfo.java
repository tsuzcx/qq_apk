package com.tencent.mm.plugin.profile.ui.tab;

import android.app.Activity;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.ag;
import com.tencent.mm.api.c.b;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.b;
import com.tencent.mm.model.ay.b.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.a.d;
import com.tencent.mm.plugin.profile.ui.ContactInfoUI;
import com.tencent.mm.plugin.profile.ui.tab.data.BizProfileDataFetcher;
import com.tencent.mm.plugin.profile.ui.tab.list.BaseBizProfileFragment;
import com.tencent.mm.plugin.profile.ui.tab.list.BizProfileTabMsgFragment;
import com.tencent.mm.plugin.profile.ui.tab.list.BizProfileTabVideoFragment;
import com.tencent.mm.plugin.profile.ui.tab.observer.BizProfileExtraOperateObserver;
import com.tencent.mm.plugin.profile.ui.tab.observer.BizProfileWidgetOperateObserver;
import com.tencent.mm.plugin.profile.ui.tab.observer.IBizProfileOperateObserver;
import com.tencent.mm.plugin.profile.ui.tab.view.BizProfileTabLayout;
import com.tencent.mm.pluginsdk.o.a;
import com.tencent.mm.protocal.protobuf.aeq;
import com.tencent.mm.protocal.protobuf.mq;
import com.tencent.mm.protocal.protobuf.np;
import com.tencent.mm.protocal.protobuf.ov;
import com.tencent.mm.protocal.protobuf.ph;
import com.tencent.mm.protocal.protobuf.py;
import com.tencent.mm.protocal.protobuf.pz;
import com.tencent.mm.protocal.protobuf.qa;
import com.tencent.mm.protocal.protobuf.qj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.widget.a.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizInfo;", "Lcom/tencent/mm/pluginsdk/deprecated/IBodyWidgetEx;", "Landroid/arch/lifecycle/LifecycleObserver;", "context", "Lcom/tencent/mm/plugin/profile/ui/ContactInfoUI;", "brandIconUrl", "", "customizedInfo", "Lcom/tencent/mm/protocal/protobuf/CustomizedInfo;", "enterTime", "", "(Lcom/tencent/mm/plugin/profile/ui/ContactInfoUI;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/CustomizedInfo;J)V", "AT_SELECT_BIZ_CARD", "", "BIZ_REPORT_URL", "CRASH_FLAG", "MENU_ID_ADD_STAR", "MENU_ID_COMPLAIN", "MENU_ID_MORE", "MENU_ID_REMOVE_STAR", "MENU_ID_SEND", "MENU_ID_SETTING", "addContactScene", "addFriendSearchScene", "bizInfo", "Lcom/tencent/mm/api/BizInfo;", "blockAddContact", "", "getBrandIconUrl", "()Ljava/lang/String;", "setBrandIconUrl", "(Ljava/lang/String;)V", "brandInfoList", "", "Lcom/tencent/mm/api/BizInfo$BrandInfo;", "channelSessionId", "contact", "Lcom/tencent/mm/storage/Contact;", "contentView", "Landroid/view/View;", "getCustomizedInfo", "()Lcom/tencent/mm/protocal/protobuf/CustomizedInfo;", "setCustomizedInfo", "(Lcom/tencent/mm/protocal/protobuf/CustomizedInfo;)V", "defaultTabSelectType", "getDefaultTabSelectType", "()I", "defaultTabSelectType$delegate", "Lkotlin/Lazy;", "getEnterTime", "()J", "setEnterTime", "(J)V", "extInfo", "Lcom/tencent/mm/api/BizInfo$ExtInfo;", "followStatus", "fragments", "", "Lcom/tencent/mm/plugin/profile/ui/tab/list/BaseBizProfileFragment;", "headerController", "Lcom/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController;", "isChecking", "isFirstTime", "menuDialog", "Lcom/tencent/mm/ui/widget/dialog/MMHalfBottomDialog;", "menuTabLayout", "Lcom/tencent/mm/plugin/profile/ui/tab/view/BizProfileTabLayout;", "operationObservers", "Lcom/tencent/mm/plugin/profile/ui/tab/observer/IBizProfileOperateObserver;", "pagerAdapter", "Lcom/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizInfo$BizProfilePagerAdapter;", "profileDataFetcher", "Lcom/tencent/mm/plugin/profile/ui/tab/data/BizProfileDataFetcher;", "getProfileDataFetcher", "()Lcom/tencent/mm/plugin/profile/ui/tab/data/BizProfileDataFetcher;", "profileDataFetcher$delegate", "profileInfo", "Lcom/tencent/mm/protocal/protobuf/BizProfileV2Resp;", "readonly", "verifyPromptTitle", "verifyTicket", "getVerifyTicket", "setVerifyTicket", "viewPager", "Landroid/support/v4/view/ViewPager;", "checkCrash", "", "checkParamsLegal", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "dealBizExpose", "dealSendCardEvent", "doSearchHistory", "handleEvent", "key", "hasFollowStateChanged", "originContact", "currentContact", "hideOriginContentView", "initActionBar", "initBizInfo", "initProfile", "initView", "jumpToSettingUI", "loadProfile", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAttach", "onBizProfileUpdate", "bizProfile", "onCreate", "onDestroy", "onDetach", "onPlaceTopChange", "reportEnd", "reportStart", "reportUpdate", "showMenuDialog", "updateBizTeenModeStatus", "updateFragments", "updateTabLayout", "needReport", "BizProfilePagerAdapter", "Companion", "app_release"})
public final class ContactWidgetTabBizInfo
  implements LifecycleObserver, com.tencent.mm.pluginsdk.b.b
{
  public static final ContactWidgetTabBizInfo.b Bmv;
  public String BdC;
  private com.tencent.mm.api.c Bdk;
  private boolean Bdx;
  public aeq BeX;
  private int Bfb;
  private final String Bff;
  private final ContactInfoUI BiT;
  private ph BiU;
  private boolean BiX;
  private boolean BiZ;
  private final String Bjc;
  private boolean Bjd;
  private List<IBizProfileOperateObserver> Bmi;
  private c Bmj;
  private ContactWidgetTabBizInfo.a Bmk;
  private BizProfileTabLayout Bml;
  private boolean Bmm;
  private final kotlin.f Bmn;
  private final kotlin.f Bmo;
  private com.tencent.mm.ui.widget.a.g Bmp;
  private final int Bmq;
  private final int Bmr;
  private final int Bms;
  private final int Bmt;
  private final int Bmu;
  private as contact;
  private View contentView;
  private String dhE;
  private List<? extends com.tencent.mm.api.c.a> dhu;
  private c.b dhv;
  public long enterTime;
  private final List<BaseBizProfileFragment> fragments;
  private int kgm;
  private String pHz;
  private final int tqu;
  private ViewPager uO;
  private final int uct;
  public String wZz;
  
  static
  {
    AppMethodBeat.i(230697);
    Bmv = new ContactWidgetTabBizInfo.b((byte)0);
    AppMethodBeat.o(230697);
  }
  
  public ContactWidgetTabBizInfo(ContactInfoUI paramContactInfoUI, String paramString, aeq paramaeq, long paramLong)
  {
    AppMethodBeat.i(230696);
    this.BiT = paramContactInfoUI;
    this.BdC = paramString;
    this.BeX = paramaeq;
    this.enterTime = paramLong;
    this.Bmi = ((List)new ArrayList());
    this.BiZ = true;
    this.Bjc = "crashFlag";
    this.fragments = ((List)new ArrayList());
    this.Bmm = true;
    this.pHz = "";
    this.Bmn = kotlin.g.ah((kotlin.g.a.a)new l(this));
    this.Bmo = kotlin.g.ah((kotlin.g.a.a)new d(this));
    this.Bmi.add(new BizProfileExtraOperateObserver());
    this.Bmi.add(new BizProfileWidgetOperateObserver(this.BiT));
    this.tqu = 1;
    this.Bmq = 2;
    this.uct = 3;
    this.Bmr = 4;
    this.Bms = 5;
    this.Bmt = 6;
    this.Bmu = 1;
    this.Bff = "https://mp.weixin.qq.com/mp/infringement?username=%s&from=1#wechat_redirect";
    AppMethodBeat.o(230696);
  }
  
  /* Error */
  private final void ab(as paramas)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 482
    //   5: invokestatic 231	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: ifnull +10 -> 19
    //   12: aload_0
    //   13: getfield 484	com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizInfo:Bjd	Z
    //   16: ifeq +12 -> 28
    //   19: ldc_w 482
    //   22: invokestatic 240	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   25: aload_0
    //   26: monitorexit
    //   27: return
    //   28: aload_0
    //   29: iconst_1
    //   30: putfield 484	com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizInfo:Bjd	Z
    //   33: ldc_w 486
    //   36: invokestatic 492	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getSingleMMKV	(Ljava/lang/String;)Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   39: astore_2
    //   40: aload_2
    //   41: aload_0
    //   42: getfield 273	com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizInfo:Bjc	Ljava/lang/String;
    //   45: iconst_0
    //   46: invokevirtual 496	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:decodeBool	(Ljava/lang/String;Z)Z
    //   49: ifeq +40 -> 89
    //   52: ldc_w 349
    //   55: ldc_w 498
    //   58: invokestatic 500	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   61: getstatic 506	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
    //   64: ldc2_w 507
    //   67: lconst_0
    //   68: lconst_1
    //   69: iconst_0
    //   70: invokevirtual 512	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   73: aload_1
    //   74: invokevirtual 362	com/tencent/mm/storage/as:getUsername	()Ljava/lang/String;
    //   77: astore_1
    //   78: aload_1
    //   79: ldc_w 514
    //   82: invokestatic 517	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   85: aload_1
    //   86: invokestatic 521	com/tencent/mm/plugin/profile/ui/newbizinfo/a:clear	(Ljava/lang/String;)V
    //   89: aload_2
    //   90: aload_0
    //   91: getfield 273	com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizInfo:Bjc	Ljava/lang/String;
    //   94: iconst_1
    //   95: invokevirtual 524	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:encode	(Ljava/lang/String;Z)Z
    //   98: pop
    //   99: ldc_w 349
    //   102: ldc_w 526
    //   105: invokestatic 500	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   108: getstatic 531	com/tencent/mm/sdk/platformtools/BuildInfo:DEBUG	Z
    //   111: ifne +15 -> 126
    //   114: getstatic 534	com/tencent/mm/sdk/platformtools/BuildInfo:IS_FLAVOR_RED	Z
    //   117: ifne +9 -> 126
    //   120: invokestatic 539	com/tencent/mm/sdk/platformtools/WeChatEnvironment:hasDebugger	()Z
    //   123: ifeq +22 -> 145
    //   126: aload_2
    //   127: ldc_w 541
    //   130: iconst_0
    //   131: invokevirtual 545	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:decodeInt	(Ljava/lang/String;I)I
    //   134: iconst_1
    //   135: if_icmpne +10 -> 145
    //   138: ldc_w 547
    //   141: iconst_0
    //   142: invokestatic 553	junit/framework/Assert:assertTrue	(Ljava/lang/String;Z)V
    //   145: getstatic 559	com/tencent/f/h:RTc	Lcom/tencent/f/i;
    //   148: new 14	com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizInfo$c
    //   151: dup
    //   152: aload_0
    //   153: aload_2
    //   154: invokespecial 562	com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizInfo$c:<init>	(Lcom/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizInfo;Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;)V
    //   157: checkcast 564	java/lang/Runnable
    //   160: ldc2_w 565
    //   163: invokeinterface 571 4 0
    //   168: pop
    //   169: ldc_w 482
    //   172: invokestatic 240	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   175: goto -150 -> 25
    //   178: astore_1
    //   179: aload_0
    //   180: monitorexit
    //   181: aload_1
    //   182: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	this	ContactWidgetTabBizInfo
    //   0	183	1	paramas	as
    //   39	115	2	localMultiProcessMMKV	MultiProcessMMKV
    // Exception table:
    //   from	to	target	type
    //   2	8	178	finally
    //   12	19	178	finally
    //   19	25	178	finally
    //   28	89	178	finally
    //   89	126	178	finally
    //   126	145	178	finally
    //   145	175	178	finally
  }
  
  private final void d(ph paramph)
  {
    int j;
    try
    {
      AppMethodBeat.i(230693);
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
      localObject1 = (BizProfileTabMsgFragment)kotlin.a.j.kt((List)localObject1);
    }
    finally {}
    Object localObject3 = (Iterable)this.fragments;
    Object localObject2 = (Collection)new ArrayList();
    localObject3 = ((Iterable)localObject3).iterator();
    Object localObject4;
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = ((Iterator)localObject3).next();
      if ((localObject4 instanceof BizProfileTabVideoFragment)) {
        ((Collection)localObject2).add(localObject4);
      }
    }
    localObject2 = (BizProfileTabVideoFragment)kotlin.a.j.kt((List)localObject2);
    int i;
    if (paramph != null)
    {
      localObject3 = paramph.KWg;
      if (localObject3 != null)
      {
        if (localObject1 != null) {
          break label630;
        }
        localObject4 = ((ov)localObject3).KVw;
        if (localObject4 == null) {
          break label630;
        }
        if (((Collection)localObject4).isEmpty()) {
          break label625;
        }
        i = 1;
        if (i != 1) {
          break label630;
        }
        localObject4 = new BizProfileTabMsgFragment();
        localObject3 = this.BiU;
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = new ph();
        }
        ((BizProfileTabMsgFragment)localObject4).f((ph)localObject1);
        localObject1 = new Bundle();
        localObject3 = this.contact;
        if (localObject3 == null) {
          p.hyc();
        }
        localObject3 = ((as)localObject3).getUsername();
        p.g(localObject3, "contact!!.username");
        com.tencent.mm.plugin.handoff.c.b.a((Bundle)localObject1, "contact", (String)localObject3);
        ((BizProfileTabMsgFragment)localObject4).setArguments((Bundle)localObject1);
        ((BizProfileTabMsgFragment)localObject4).e(eFG());
        this.fragments.add(0, localObject4);
      }
    }
    label357:
    Object localObject1 = localObject2;
    if (paramph != null)
    {
      paramph = paramph.KWi;
      localObject1 = localObject2;
      if (paramph != null)
      {
        if (localObject2 != null) {
          break label704;
        }
        localObject1 = paramph.KVw;
        if (localObject1 == null) {
          break label704;
        }
        if (((Collection)localObject1).isEmpty()) {
          break label800;
        }
        i = 1;
        label409:
        if (i != 1) {
          break label704;
        }
        localObject1 = new BizProfileTabVideoFragment();
        localObject2 = this.BiU;
        paramph = (ph)localObject2;
        if (localObject2 == null) {
          paramph = new ph();
        }
        ((BizProfileTabVideoFragment)localObject1).f(paramph);
        paramph = new Bundle();
        localObject2 = this.contact;
        if (localObject2 == null) {
          p.hyc();
        }
        localObject2 = ((as)localObject2).getUsername();
        p.g(localObject2, "contact!!.username");
        com.tencent.mm.plugin.handoff.c.b.a(paramph, "contact", (String)localObject2);
        ((BizProfileTabVideoFragment)localObject1).setArguments(paramph);
        ((BizProfileTabVideoFragment)localObject1).e(eFG());
        this.fragments.add(localObject1);
      }
    }
    label524:
    label625:
    label630:
    do
    {
      if (j != this.fragments.size())
      {
        paramph = this.Bmk;
        if (paramph == null) {
          p.btv("pagerAdapter");
        }
        paramph.notifyDataSetChanged();
      }
      if ((localObject1 != null) && (eFH() == 1))
      {
        paramph = this.fragments;
        if (localObject1 == null) {
          p.hyc();
        }
        i = paramph.indexOf(localObject1);
        if (i >= 0)
        {
          paramph = this.uO;
          if (paramph == null) {
            p.btv("viewPager");
          }
          paramph.setCurrentItem(i, false);
        }
      }
      AppMethodBeat.o(230693);
      return;
      i = 0;
      break;
      localObject3 = ((ov)localObject3).KVw;
      if (localObject3 == null) {
        break label357;
      }
      localObject3 = (Collection)localObject3;
      if (localObject3 == null) {
        break label790;
      }
      if (!((Collection)localObject3).isEmpty()) {
        break label795;
      }
      break label790;
      if ((i != 1) || (localObject1 == null)) {
        break label798;
      }
      localObject3 = this.fragments;
      if (localObject1 == null) {
        p.hyc();
      }
      ((List)localObject3).remove(localObject1);
      break label357;
      paramph = paramph.KVw;
      localObject1 = localObject2;
    } while (paramph == null);
    label667:
    label704:
    paramph = (Collection)paramph;
    if (paramph != null) {
      if (paramph.isEmpty()) {
        break label805;
      }
    }
    for (;;)
    {
      localObject1 = localObject2;
      if (i != 1) {
        break label524;
      }
      localObject1 = localObject2;
      if (localObject2 == null) {
        break label524;
      }
      paramph = this.fragments;
      if (localObject2 == null) {
        p.hyc();
      }
      paramph.remove(localObject2);
      localObject1 = localObject2;
      break label524;
      i = 0;
      continue;
      label790:
      i = 1;
      break label667;
      label795:
      i = 0;
      break label667;
      label798:
      break;
      label800:
      i = 0;
      break label409;
      label805:
      i = 1;
    }
  }
  
  private final void eEZ()
  {
    int j = 0;
    Object localObject3 = null;
    AppMethodBeat.i(230691);
    Object localObject1 = this.contact;
    if (localObject1 != null) {}
    Object localObject2;
    for (localObject1 = ((as)localObject1).getUsername();; localObject1 = null)
    {
      localObject2 = com.tencent.mm.al.g.fJ((String)localObject1);
      this.dhu = null;
      this.dhv = null;
      if (localObject2 != null) {
        break;
      }
      AppMethodBeat.o(230691);
      return;
    }
    localObject1 = localObject2;
    int i;
    if (((com.tencent.mm.api.c)localObject2).Uw() == null)
    {
      localObject1 = localObject2;
      if (this.BeX != null)
      {
        localObject2 = new com.tencent.mm.api.c();
        localObject1 = this.contact;
        if (localObject1 == null) {
          break label486;
        }
        localObject1 = ((as)localObject1).getUsername();
        ((com.tencent.mm.api.c)localObject2).field_username = ((String)localObject1);
        localObject1 = this.BeX;
        if (localObject1 == null) {
          break label491;
        }
        i = ((aeq)localObject1).kem;
        label122:
        ((com.tencent.mm.api.c)localObject2).field_brandFlag = i;
        localObject1 = this.BeX;
        if (localObject1 == null) {
          break label496;
        }
        localObject1 = ((aeq)localObject1).kep;
        label142:
        ((com.tencent.mm.api.c)localObject2).field_brandIconURL = ((String)localObject1);
        localObject1 = this.BeX;
        if (localObject1 == null) {
          break label501;
        }
        localObject1 = ((aeq)localObject1).keo;
        label162:
        ((com.tencent.mm.api.c)localObject2).field_brandInfo = ((String)localObject1);
        localObject1 = this.BeX;
        if (localObject1 == null) {
          break label506;
        }
        localObject1 = ((aeq)localObject1).ken;
        label182:
        ((com.tencent.mm.api.c)localObject2).field_extInfo = ((String)localObject1);
        localObject1 = ((com.tencent.mm.api.c)localObject2).Uw();
        p.g(localObject1, "bi.extInfo");
        ((com.tencent.mm.api.c)localObject2).field_type = ((c.b)localObject1).getServiceType();
        localObject1 = localObject2;
      }
    }
    if ((((com.tencent.mm.api.c)localObject1).field_brandInfo == null) && (((com.tencent.mm.api.c)localObject1).field_extInfo == null) && (this.BeX != null))
    {
      localObject2 = this.contact;
      if (localObject2 != null)
      {
        localObject2 = ((as)localObject2).getUsername();
        label252:
        ((com.tencent.mm.api.c)localObject1).field_username = ((String)localObject2);
        localObject2 = this.BeX;
        if (localObject2 == null) {
          break label517;
        }
        i = ((aeq)localObject2).kem;
        label275:
        ((com.tencent.mm.api.c)localObject1).field_brandFlag = i;
        localObject2 = this.BeX;
        if (localObject2 == null) {
          break label522;
        }
        localObject2 = ((aeq)localObject2).kep;
        label298:
        ((com.tencent.mm.api.c)localObject1).field_brandIconURL = ((String)localObject2);
        localObject2 = this.BeX;
        if (localObject2 == null) {
          break label528;
        }
        localObject2 = ((aeq)localObject2).keo;
        label322:
        ((com.tencent.mm.api.c)localObject1).field_brandInfo = ((String)localObject2);
        localObject2 = this.BeX;
        if (localObject2 == null) {
          break label534;
        }
        localObject2 = ((aeq)localObject2).ken;
        label346:
        ((com.tencent.mm.api.c)localObject1).field_extInfo = ((String)localObject2);
        localObject2 = ((com.tencent.mm.api.c)localObject1).Uw();
        p.g(localObject2, "bi.extInfo");
        ((com.tencent.mm.api.c)localObject1).field_type = ((c.b)localObject2).getServiceType();
      }
    }
    else
    {
      this.Bdk = ((com.tencent.mm.api.c)localObject1);
      this.dhu = ((com.tencent.mm.api.c)localObject1).UO();
      this.dhv = ((com.tencent.mm.api.c)localObject1).Uw();
      localObject1 = this.dhv;
      if (localObject1 == null) {
        break label540;
      }
      localObject1 = ((c.b)localObject1).US();
      label410:
      if (localObject1 != null)
      {
        localObject1 = this.dhv;
        if (localObject1 == null) {
          break label545;
        }
      }
    }
    label517:
    label522:
    label528:
    label534:
    label540:
    label545:
    for (localObject1 = ((c.b)localObject1).US();; localObject1 = null)
    {
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
        localObject2 = this.dhv;
        localObject1 = localObject3;
        if (localObject2 != null) {
          localObject1 = ((c.b)localObject2).US();
        }
        this.dhE = ((String)localObject1);
      }
      AppMethodBeat.o(230691);
      return;
      label486:
      localObject1 = null;
      break;
      label491:
      i = 0;
      break label122;
      label496:
      localObject1 = null;
      break label142;
      label501:
      localObject1 = null;
      break label162;
      label506:
      localObject1 = null;
      break label182;
      localObject2 = null;
      break label252;
      i = 0;
      break label275;
      localObject2 = null;
      break label298;
      localObject2 = null;
      break label322;
      localObject2 = null;
      break label346;
      localObject1 = null;
      break label410;
    }
  }
  
  private final void eEp()
  {
    AppMethodBeat.i(230692);
    cCs();
    if (this.contact == null)
    {
      AppMethodBeat.o(230692);
      return;
    }
    eEZ();
    AppMethodBeat.o(230692);
  }
  
  private final BizProfileDataFetcher eFG()
  {
    AppMethodBeat.i(230685);
    BizProfileDataFetcher localBizProfileDataFetcher = (BizProfileDataFetcher)this.Bmn.getValue();
    AppMethodBeat.o(230685);
    return localBizProfileDataFetcher;
  }
  
  private final int eFH()
  {
    AppMethodBeat.i(230686);
    int i = ((Number)this.Bmo.getValue()).intValue();
    AppMethodBeat.o(230686);
    return i;
  }
  
  private final void sO(boolean paramBoolean)
  {
    AppMethodBeat.i(230694);
    Object localObject1 = this.Bml;
    if (localObject1 == null) {
      p.btv("menuTabLayout");
    }
    ((BizProfileTabLayout)localObject1).eFP();
    localObject1 = ((Iterable)this.fragments).iterator();
    int i = 0;
    int k = 0;
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (BaseBizProfileFragment)((Iterator)localObject1).next();
      if ((localObject2 instanceof BizProfileTabVideoFragment))
      {
        k = 1;
      }
      else
      {
        if (!(localObject2 instanceof BizProfileTabMsgFragment)) {
          break label634;
        }
        i = 1;
      }
    }
    label165:
    label603:
    label629:
    label634:
    for (;;)
    {
      break;
      localObject1 = this.BiU;
      int j;
      if (localObject1 != null)
      {
        localObject1 = ((ph)localObject1).KWj;
        if (localObject1 != null)
        {
          localObject1 = ((py)localObject1).KWP;
          if (localObject1 != null)
          {
            localObject1 = ((pz)localObject1).KWS;
            if (localObject1 != null) {
              if (!((Collection)localObject1).isEmpty())
              {
                j = 1;
                if (j != 1) {
                  break label629;
                }
                j = 1;
              }
            }
          }
        }
      }
      for (;;)
      {
        if ((i != 0) && ((k != 0) || (j != 0)))
        {
          localObject1 = this.Bml;
          if (localObject1 == null) {
            p.btv("menuTabLayout");
          }
          localObject1 = ((BizProfileTabLayout)localObject1).BnT;
          if (localObject1 == null) {
            p.btv("mMsgLayout");
          }
          ((ViewGroup)localObject1).setVisibility(0);
        }
        if ((k != 0) && ((i != 0) || (j != 0)))
        {
          localObject1 = this.Bml;
          if (localObject1 == null) {
            p.btv("menuTabLayout");
          }
          localObject1 = ((BizProfileTabLayout)localObject1).BnU;
          if (localObject1 == null) {
            p.btv("mVideoLayout");
          }
          ((ViewGroup)localObject1).setVisibility(0);
        }
        if (j != 0)
        {
          localObject1 = this.Bml;
          if (localObject1 == null) {
            p.btv("menuTabLayout");
          }
          localObject1 = ((BizProfileTabLayout)localObject1).BnV;
          if (localObject1 == null) {
            p.btv("mServiceLayout");
          }
          ((ViewGroup)localObject1).setVisibility(0);
        }
        localObject1 = this.Bml;
        if (localObject1 == null) {
          p.btv("menuTabLayout");
        }
        localObject2 = this.uO;
        if (localObject2 == null) {
          p.btv("viewPager");
        }
        int m = ((ViewPager)localObject2).getCurrentItem();
        if ((m < 0) || (m >= ((BizProfileTabLayout)localObject1).getTabCount()))
        {
          if (this.fragments.size() > 1) {
            break label603;
          }
          localObject1 = this.Bml;
          if (localObject1 == null) {
            p.btv("menuTabLayout");
          }
          if (((BizProfileTabLayout)localObject1).getTabCount() > 0) {
            break label603;
          }
          localObject1 = this.Bml;
          if (localObject1 == null) {
            p.btv("menuTabLayout");
          }
          ((BizProfileTabLayout)localObject1).setVisibility(8);
          j = 0;
          i = 0;
          k = 0;
        }
        for (;;)
        {
          if (paramBoolean)
          {
            if (i != 0)
            {
              localObject1 = com.tencent.mm.plugin.profile.ui.tab.data.b.BmM;
              com.tencent.mm.plugin.profile.ui.tab.data.b.a(this.contact, 0, this.kgm);
            }
            if (k != 0)
            {
              localObject1 = com.tencent.mm.plugin.profile.ui.tab.data.b.BmM;
              com.tencent.mm.plugin.profile.ui.tab.data.b.a(this.contact, 1, this.kgm);
            }
            if (j != 0)
            {
              localObject1 = com.tencent.mm.plugin.profile.ui.tab.data.b.BmM;
              com.tencent.mm.plugin.profile.ui.tab.data.b.a(this.contact, 2, this.kgm);
            }
            if ((i == 0) && (k == 0) && (j == 0))
            {
              localObject1 = com.tencent.mm.plugin.profile.ui.tab.data.b.BmM;
              com.tencent.mm.plugin.profile.ui.tab.data.b.a(this.contact, 3, this.kgm);
            }
          }
          AppMethodBeat.o(230694);
          return;
          j = 0;
          break;
          j = 0;
          break label165;
          switch (m)
          {
          default: 
            break;
          case 0: 
            ((BizProfileTabLayout)localObject1).eFQ();
            break;
          case 1: 
            ((BizProfileTabLayout)localObject1).eFR();
            break;
            localObject1 = this.Bml;
            if (localObject1 == null) {
              p.btv("menuTabLayout");
            }
            ((BizProfileTabLayout)localObject1).setVisibility(0);
          }
        }
        j = 0;
      }
    }
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, as paramas, boolean paramBoolean, int paramInt)
  {
    Object localObject2 = null;
    AppMethodBeat.i(230688);
    if (this.BiT.isFinishing())
    {
      AppMethodBeat.o(230688);
      return true;
    }
    if (paramas != null)
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      if (paramas == null) {
        break label153;
      }
      localObject1 = paramas.getUsername();
      label49:
      localObject1 = Util.nullAsNil((String)localObject1);
      p.g(localObject1, "Util.nullAsNil(contact?.username)");
      if (((CharSequence)localObject1).length() <= 0) {
        break label159;
      }
      bool1 = true;
      label80:
      Assert.assertTrue(bool1);
      if (paramf == null) {
        break label165;
      }
    }
    label153:
    label159:
    label165:
    for (boolean bool1 = true;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      ab(paramas);
      localObject1 = ((Iterable)this.Bmi).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((IBizProfileOperateObserver)((Iterator)localObject1).next()).a(paramf, paramas);
      }
      bool1 = false;
      break;
      localObject1 = null;
      break label49;
      bool1 = false;
      break label80;
    }
    this.contact = paramas;
    this.Bdx = paramBoolean;
    this.kgm = paramInt;
    this.Bfb = this.BiT.getIntent().getIntExtra("add_more_friend_search_scene", 0);
    Object localObject1 = this.BiT.getIntent().getStringExtra("key_channel_session_id");
    paramf = (com.tencent.mm.ui.base.preference.f)localObject1;
    if (localObject1 == null) {
      paramf = "";
    }
    this.pHz = paramf;
    if ((this.kgm == 78) || (this.kgm == 79))
    {
      this.BiX = false;
      Log.i("MicroMsg.ContactWidgetTabBizInfo", "updateBizTeenModeStatus addContactScene: %d not need to block", new Object[] { Integer.valueOf(this.kgm) });
      if (!this.BiZ) {
        break label1551;
      }
      this.BiZ = false;
      paramf = this.BiT.findViewById(2131304719);
      if (paramf != null) {
        paramf.setVisibility(8);
      }
      paramf = this.BiT.getListView();
      if (paramf != null) {
        paramf.setVisibility(8);
      }
      paramf = this.BiT.findViewById(2131306091);
      if (paramf != null) {
        paramf.setVisibility(8);
      }
      paramf = this.contact;
      if (paramf != null)
      {
        paramf = paramf.getUsername();
        if (paramf != null) {
          this.BiU = com.tencent.mm.plugin.profile.ui.newbizinfo.a.aKy(paramf);
        }
      }
      this.BiT.findViewById(2131304720);
      paramf = LayoutInflater.from((Context)this.BiT).inflate(2131493741, null);
      p.g(paramf, "inflater.inflate(R.layou…ntact_info_biz_tab, null)");
      this.contentView = paramf;
      paramf = this.BiT;
      localObject1 = this.contentView;
      if (localObject1 == null) {
        p.btv("contentView");
      }
      paramf.setContentView((View)localObject1);
      paramf = this.contentView;
      if (paramf == null) {
        p.btv("contentView");
      }
      paramf = paramf.findViewById(2131298925);
      p.g(paramf, "contentView.findViewById…(R.id.combo_content_view)");
      this.uO = ((ViewPager)paramf);
      paramf = this.contentView;
      if (paramf == null) {
        p.btv("contentView");
      }
      paramf = paramf.findViewById(2131297476);
      p.g(paramf, "contentView.findViewById…_profile_menu_tab_layout)");
      this.Bml = ((BizProfileTabLayout)paramf);
      paramf = this.Bml;
      if (paramf == null) {
        p.btv("menuTabLayout");
      }
      paramf.setOnTabSelected((kotlin.g.a.b)new i(this));
      paramf = this.Bml;
      if (paramf == null) {
        p.btv("menuTabLayout");
      }
      paramf.setOnServiceTabSelected((kotlin.g.a.a)new j(this));
      paramf = (MMActivity)this.BiT;
      localObject1 = this.contentView;
      if (localObject1 == null) {
        p.btv("contentView");
      }
      paramf = new c(paramf, (View)localObject1);
      paramf.a((c.a)new h(this));
      this.Bmj = paramf;
      localObject3 = this.BiU;
      if (localObject3 != null)
      {
        if (eFH() != 1) {
          break label1208;
        }
        paramf = ((ph)localObject3).KWi;
        if (paramf == null) {
          break label1208;
        }
        paramf = paramf.KVw;
        if (paramf == null) {
          break label1208;
        }
        if (((Collection)paramf).isEmpty()) {
          break label1202;
        }
        i = 1;
        if (i != 1) {
          break label1208;
        }
      }
      paramf = this.fragments;
      localObject1 = this.BiT.getSupportFragmentManager();
      p.g(localObject1, "context.supportFragmentManager");
      this.Bmk = new ContactWidgetTabBizInfo.a(paramf, (android.support.v4.app.g)localObject1);
      paramf = this.uO;
      if (paramf == null) {
        p.btv("viewPager");
      }
      localObject1 = this.Bmk;
      if (localObject1 == null) {
        p.btv("pagerAdapter");
      }
      paramf.setAdapter((android.support.v4.view.q)localObject1);
      paramf = this.Bmk;
      if (paramf == null) {
        p.btv("pagerAdapter");
      }
      paramf.notifyDataSetChanged();
      sO(false);
      localObject1 = this.BiT;
      paramf = this.contact;
      if (paramf == null) {
        break label1540;
      }
      paramf = paramf.getNickname();
      ((ContactInfoUI)localObject1).setMMTitle(Util.nullAsNil(paramf));
      this.BiT.setMMTitleColor(0);
      this.BiT.setTitleDividerVis(false);
      this.BiT.setIsDarkActionbarBg(false);
      this.BiT.setActionbarColor(this.BiT.getResources().getColor(2131099650));
      this.BiT.hideActionbarLine();
      this.BiT.setBackBtn((MenuItem.OnMenuItemClickListener)new e(this), 2131689492);
      this.BiT.removeAllOptionMenu();
      this.BiT.addIconOptionMenu(1, 2131766796, 2131689496, (MenuItem.OnMenuItemClickListener)new f(this));
      this.BiT.addIconOptionMenu(0, "", 2131689495, (MenuItem.OnMenuItemClickListener)new g(this));
      eEp();
      if (paramas != null) {
        ag.bau().MN(paramas.getUsername());
      }
      eFG().Bmz.observe((LifecycleOwner)this.BiT, (Observer)new k(this));
      if (paramas != null)
      {
        if ((!paramas.arv()) || (paramas.arH() <= 0)) {
          break label1545;
        }
        bool1 = true;
        this.Bmm = bool1;
      }
      eFG().eFI();
    }
    label1202:
    label1208:
    label1242:
    label1528:
    while (paramas == null) {
      for (;;)
      {
        Object localObject3;
        localObject1 = this.BiT;
        paramf = localObject2;
        if (paramas != null) {
          paramf = paramas.getNickname();
        }
        ((ContactInfoUI)localObject1).setMMTitle(Util.nullAsNil(paramf));
        this.BiT.setMMTitleColor(0);
        paramf = this.Bmj;
        if (paramf != null) {
          paramf.a(paramas, this.BdC, this.Bdk, this.BiU, paramInt, paramBoolean);
        }
        AppMethodBeat.o(230688);
        return true;
        paramf = com.tencent.mm.kernel.g.af(com.tencent.mm.api.q.class);
        p.g(paramf, "MMKernel.service(IBizTeenModeService::class.java)");
        boolean bool2 = ((com.tencent.mm.api.q)paramf).Vu();
        if (!bool2) {}
        for (bool1 = true;; bool1 = false)
        {
          this.BiX = bool1;
          Log.i("MicroMsg.ContactWidgetTabBizInfo", "updateBizTeenModeStatus addContactScene: %d, blockAddContact: %b, isBizTeenModeAllowAll: %b", new Object[] { Integer.valueOf(this.kgm), Boolean.valueOf(this.BiX), Boolean.valueOf(bool2) });
          break;
        }
        int i = 0;
        continue;
        paramf = ((ph)localObject3).KWg;
        Object localObject4;
        if (paramf != null)
        {
          paramf = paramf.KVw;
          if (paramf != null)
          {
            if (((Collection)paramf).isEmpty()) {
              break label1528;
            }
            i = 1;
            if (i == 1)
            {
              localObject4 = this.fragments;
              BizProfileTabMsgFragment localBizProfileTabMsgFragment = new BizProfileTabMsgFragment();
              localObject1 = this.BiU;
              paramf = (com.tencent.mm.ui.base.preference.f)localObject1;
              if (localObject1 == null) {
                paramf = new ph();
              }
              localBizProfileTabMsgFragment.f(paramf);
              paramf = new Bundle();
              localObject1 = this.contact;
              if (localObject1 == null) {
                p.hyc();
              }
              localObject1 = ((as)localObject1).getUsername();
              p.g(localObject1, "contact!!.username");
              com.tencent.mm.plugin.handoff.c.b.a(paramf, "contact", (String)localObject1);
              localBizProfileTabMsgFragment.setArguments(paramf);
              localBizProfileTabMsgFragment.e(eFG());
              localBizProfileTabMsgFragment.enterTime = this.enterTime;
              ((List)localObject4).add(localBizProfileTabMsgFragment);
            }
          }
        }
        paramf = ((ph)localObject3).KWi;
        if (paramf != null)
        {
          paramf = paramf.KVw;
          if (paramf != null)
          {
            if (!((Collection)paramf).isEmpty()) {}
            for (i = 1;; i = 0)
            {
              if (i != 1) {
                break label1538;
              }
              localObject3 = this.fragments;
              localObject4 = new BizProfileTabVideoFragment();
              localObject1 = this.BiU;
              paramf = (com.tencent.mm.ui.base.preference.f)localObject1;
              if (localObject1 == null) {
                paramf = new ph();
              }
              ((BizProfileTabVideoFragment)localObject4).f(paramf);
              paramf = new Bundle();
              localObject1 = this.contact;
              if (localObject1 == null) {
                p.hyc();
              }
              localObject1 = ((as)localObject1).getUsername();
              p.g(localObject1, "contact!!.username");
              com.tencent.mm.plugin.handoff.c.b.a(paramf, "contact", (String)localObject1);
              ((BizProfileTabVideoFragment)localObject4).setArguments(paramf);
              ((BizProfileTabVideoFragment)localObject4).e(eFG());
              ((List)localObject3).add(localObject4);
              break;
              i = 0;
              break label1242;
            }
            continue;
            paramf = null;
            continue;
            bool1 = false;
          }
        }
      }
    }
    label1538:
    label1540:
    label1545:
    label1551:
    if ((paramas.arv()) && (paramas.arH() > 0)) {}
    for (bool1 = true;; bool1 = false)
    {
      if (this.Bmm != bool1) {
        eFG().eFI();
      }
      this.Bmm = bool1;
      break;
    }
  }
  
  public final boolean alD(String paramString)
  {
    return true;
  }
  
  public final boolean axa()
  {
    AppMethodBeat.i(230690);
    if ((this.contact != null) && (this.Bdk != null) && (this.BiU != null))
    {
      localObject = this.BiU;
      if (localObject == null) {
        p.hyc();
      }
      if (((ph)localObject).KWf != null)
      {
        localObject = this.BiU;
        if (localObject == null) {
          p.hyc();
        }
        if (((ph)localObject).KWe != null) {
          break label218;
        }
      }
    }
    Log.w("MicroMsg.ContactWidgetTabBizInfo", "reportEnd fail, err");
    Object localObject = this.BiU;
    label110:
    String str2;
    label147:
    String str3;
    if (localObject != null)
    {
      localObject = ((ph)localObject).KWp;
      if (localObject != null)
      {
        localObject = ((qj)localObject).KXl;
        str2 = z.a((com.tencent.mm.bw.b)localObject);
        localObject = this.BiU;
        if (localObject == null) {
          break label485;
        }
        localObject = ((ph)localObject).KWp;
        if (localObject == null) {
          break label485;
        }
        localObject = ((qj)localObject).KXm;
        str3 = z.a((com.tencent.mm.bw.b)localObject);
        localObject = (CharSequence)str2;
        if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
          break label491;
        }
        i = 1;
        label178:
        if (i == 0)
        {
          localObject = (CharSequence)str3;
          if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
            break label496;
          }
        }
      }
    }
    label218:
    String str1;
    label300:
    label356:
    label485:
    label491:
    label496:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label501;
      }
      AppMethodBeat.o(230690);
      return true;
      l1 = System.currentTimeMillis();
      localObject = this.contact;
      if (localObject == null) {
        p.hyc();
      }
      str1 = ((as)localObject).getUsername();
      int k = this.kgm;
      localObject = this.Bdk;
      if (localObject == null) {
        p.hyc();
      }
      int m = ((com.tencent.mm.api.c)localObject).field_type;
      long l2 = this.enterTime;
      localObject = this.contact;
      if (localObject == null) {
        p.hyc();
      }
      int n;
      int j;
      if (((as)localObject).arv())
      {
        i = 1;
        localObject = this.BiU;
        if (localObject == null) {
          p.hyc();
        }
        n = ((ph)localObject).KWf.KSY;
        localObject = this.BiU;
        if (localObject == null) {
          p.hyc();
        }
        localObject = ((ph)localObject).KWf;
        if (localObject == null) {
          break label468;
        }
        j = ((np)localObject).KSZ;
        localObject = this.BiU;
        if (localObject == null) {
          p.hyc();
        }
        str2 = com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.c(((ph)localObject).KWg);
        localObject = this.BiU;
        if (localObject == null) {
          p.hyc();
        }
        str3 = com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.a(((ph)localObject).KWj);
        localObject = this.BiU;
        if (localObject == null) {
          p.hyc();
        }
        localObject = ((ph)localObject).KWe;
        if (localObject == null) {
          break label473;
        }
      }
      for (localObject = ((mq)localObject).UserName;; localObject = null)
      {
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.a(str1, k, m, l2, l1, i, n, j, 0, str2, str3, (String)localObject);
        break;
        i = 0;
        break label300;
        j = 0;
        break label356;
      }
      localObject = null;
      break label110;
      localObject = null;
      break label147;
      i = 0;
      break label178;
    }
    label468:
    label473:
    label501:
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.CyF;
    long l1 = this.enterTime;
    localObject = this.contact;
    if (localObject != null)
    {
      str1 = ((as)localObject).getUsername();
      localObject = str1;
      if (str1 != null) {}
    }
    else
    {
      localObject = "";
    }
    localh.a(22118, new Object[] { Long.valueOf(l1), localObject, Integer.valueOf(1), str2, str3 });
    AppMethodBeat.o(230690);
    return true;
  }
  
  public final boolean cCs()
  {
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(230689);
    Log.i("MicroMsg.ContactWidgetTabBizInfo", "onActivityResult, requestCode = %d, resultCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == this.Bmu)
    {
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        String str1 = paramIntent.getStringExtra("be_send_card_name");
        String str2 = paramIntent.getStringExtra("received_card_name");
        boolean bool = paramIntent.getBooleanExtra("Is_Chatroom", false);
        paramIntent = paramIntent.getStringExtra("custom_send_text");
        o.a.eir().s(str1, str2, bool);
        o.a.eir().iF(paramIntent, str2);
        com.tencent.mm.ui.widget.snackbar.b.r((Activity)this.BiT, this.BiT.getString(2131760708));
        AppMethodBeat.o(230689);
      }
    }
    else
    {
      AppMethodBeat.o(230689);
      return;
    }
    AppMethodBeat.o(230689);
  }
  
  public final boolean onCreate()
  {
    AppMethodBeat.i(230687);
    if ((this.contact == null) || (this.Bdk == null))
    {
      Log.w("MicroMsg.ContactWidgetTabBizInfo", "reportStart fail, err");
      AppMethodBeat.o(230687);
      return true;
    }
    Object localObject1 = this.contact;
    if (localObject1 == null) {
      p.hyc();
    }
    localObject1 = ((as)localObject1).getUsername();
    int j = this.kgm;
    Object localObject2 = this.Bdk;
    if (localObject2 == null) {
      p.hyc();
    }
    int k = ((com.tencent.mm.api.c)localObject2).field_type;
    long l = this.enterTime;
    localObject2 = this.contact;
    if (localObject2 == null) {
      p.hyc();
    }
    if (((as)localObject2).arv()) {}
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.a((String)localObject1, j, k, l, i, this.pHz);
      break;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(ContactWidgetTabBizInfo paramContactWidgetTabBizInfo, MultiProcessMMKV paramMultiProcessMMKV) {}
    
    public final void run()
    {
      AppMethodBeat.i(230669);
      Log.i("MicroMsg.ContactWidgetTabBizInfo", "checkCrash clear crash flag");
      localMultiProcessMMKV.encode(ContactWidgetTabBizInfo.i(this.Bmw), false);
      ContactWidgetTabBizInfo.j(this.Bmw);
      AppMethodBeat.o(230669);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Integer>
  {
    d(ContactWidgetTabBizInfo paramContactWidgetTabBizInfo)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class e
    implements MenuItem.OnMenuItemClickListener
  {
    e(ContactWidgetTabBizInfo paramContactWidgetTabBizInfo) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(230671);
      ContactWidgetTabBizInfo.h(this.Bmw).onBackPressed();
      AppMethodBeat.o(230671);
      return true;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class f
    implements MenuItem.OnMenuItemClickListener
  {
    f(ContactWidgetTabBizInfo paramContactWidgetTabBizInfo) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(230672);
      ContactWidgetTabBizInfo.k(this.Bmw);
      AppMethodBeat.o(230672);
      return true;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class g
    implements MenuItem.OnMenuItemClickListener
  {
    g(ContactWidgetTabBizInfo paramContactWidgetTabBizInfo) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(230677);
      paramMenuItem = new e((Context)ContactWidgetTabBizInfo.h(this.Bmw), 1, false);
      paramMenuItem.a((o.f)new o.f()
      {
        public final void onCreateMMMenu(m paramAnonymousm)
        {
          Object localObject2 = null;
          Object localObject1 = null;
          AppMethodBeat.i(230675);
          as localas = ContactWidgetTabBizInfo.d(this.Bmx.Bmw);
          if ((localas != null) && (localas.arv() == true))
          {
            localas = ContactWidgetTabBizInfo.d(this.Bmx.Bmw);
            if ((localas != null) && (localas.arE() == true)) {
              if (com.tencent.mm.storage.ab.clc())
              {
                localObject2 = ContactWidgetTabBizInfo.d(this.Bmx.Bmw);
                if (localObject2 != null) {
                  localObject1 = ((as)localObject2).getUsername();
                }
                if (com.tencent.mm.al.g.Nd((String)localObject1)) {
                  paramAnonymousm.kV(ContactWidgetTabBizInfo.l(this.Bmx.Bmw), 2131757840);
                }
              }
            }
          }
          label312:
          do
          {
            for (;;)
            {
              paramAnonymousm.kV(ContactWidgetTabBizInfo.n(this.Bmx.Bmw), 2131758047);
              paramAnonymousm.kV(ContactWidgetTabBizInfo.o(this.Bmx.Bmw), 2131757360);
              localObject1 = ContactWidgetTabBizInfo.d(this.Bmx.Bmw);
              if (localObject1 == null) {
                break;
              }
              if (((as)localObject1).arv() == true) {
                paramAnonymousm.kV(ContactWidgetTabBizInfo.p(this.Bmx.Bmw), 2131757851);
              }
              AppMethodBeat.o(230675);
              return;
              paramAnonymousm.kV(ContactWidgetTabBizInfo.l(this.Bmx.Bmw), 2131762839);
              continue;
              if (com.tencent.mm.storage.ab.clc())
              {
                localas = ContactWidgetTabBizInfo.d(this.Bmx.Bmw);
                localObject1 = localObject2;
                if (localas != null) {
                  localObject1 = localas.getUsername();
                }
                if (com.tencent.mm.al.g.Nd((String)localObject1))
                {
                  paramAnonymousm.kV(ContactWidgetTabBizInfo.m(this.Bmx.Bmw), 2131757836);
                  continue;
                }
              }
              paramAnonymousm.kV(ContactWidgetTabBizInfo.m(this.Bmx.Bmw), 2131758117);
            }
            localObject1 = ContactWidgetTabBizInfo.d(this.Bmx.Bmw);
            if (localObject1 == null) {
              break;
            }
            localObject1 = Integer.valueOf(((as)localObject1).arH());
            if (localObject1 == null) {
              p.hyc();
            }
          } while (((Integer)localObject1).intValue() > 0);
          localObject2 = ay.a.aVo();
          localObject1 = ContactWidgetTabBizInfo.d(this.Bmx.Bmw);
          if (localObject1 != null) {}
          for (localObject1 = ((as)localObject1).getUsername();; localObject1 = null)
          {
            ((ay.b)localObject2).a((String)localObject1, "", (ay.b.a)ContactWidgetTabBizInfo.g.1.1.Bmy);
            break;
            localObject1 = null;
            break label312;
          }
          AppMethodBeat.o(230675);
        }
      });
      paramMenuItem.a((o.g)new o.g()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          as localas2 = null;
          as localas1 = null;
          AppMethodBeat.i(230676);
          p.g(paramAnonymousMenuItem, "menuItem");
          paramAnonymousInt = paramAnonymousMenuItem.getItemId();
          if (paramAnonymousInt == ContactWidgetTabBizInfo.n(this.Bmx.Bmw))
          {
            ContactWidgetTabBizInfo.q(this.Bmx.Bmw);
            AppMethodBeat.o(230676);
            return;
          }
          if (paramAnonymousInt == ContactWidgetTabBizInfo.p(this.Bmx.Bmw))
          {
            ContactWidgetTabBizInfo.r(this.Bmx.Bmw);
            AppMethodBeat.o(230676);
            return;
          }
          if (paramAnonymousInt == ContactWidgetTabBizInfo.m(this.Bmx.Bmw))
          {
            paramAnonymousMenuItem = ContactWidgetTabBizInfo.d(this.Bmx.Bmw);
            if (paramAnonymousMenuItem != null)
            {
              paramAnonymousMenuItem = paramAnonymousMenuItem.getUsername();
              com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.c(paramAnonymousMenuItem, 903, ContactWidgetTabBizInfo.e(this.Bmx.Bmw), this.Bmx.Bmw.enterTime);
              paramAnonymousMenuItem = ContactWidgetTabBizInfo.d(this.Bmx.Bmw);
              if (paramAnonymousMenuItem == null) {
                break label259;
              }
            }
            label259:
            for (paramAnonymousMenuItem = paramAnonymousMenuItem.getUsername();; paramAnonymousMenuItem = null)
            {
              com.tencent.mm.model.j.HO(paramAnonymousMenuItem);
              ContactWidgetTabBizInfo.s(this.Bmx.Bmw);
              if (com.tencent.mm.storage.ab.clc())
              {
                localas2 = ContactWidgetTabBizInfo.d(this.Bmx.Bmw);
                paramAnonymousMenuItem = localas1;
                if (localas2 != null) {
                  paramAnonymousMenuItem = localas2.getUsername();
                }
                if (!com.tencent.mm.al.g.Nb(paramAnonymousMenuItem)) {
                  break label481;
                }
              }
              com.tencent.mm.ui.base.h.cA((Context)ContactWidgetTabBizInfo.h(this.Bmx.Bmw), ContactWidgetTabBizInfo.h(this.Bmx.Bmw).getString(2131762840));
              AppMethodBeat.o(230676);
              return;
              paramAnonymousMenuItem = null;
              break;
            }
          }
          if (paramAnonymousInt == ContactWidgetTabBizInfo.l(this.Bmx.Bmw))
          {
            paramAnonymousMenuItem = ContactWidgetTabBizInfo.d(this.Bmx.Bmw);
            if (paramAnonymousMenuItem != null)
            {
              paramAnonymousMenuItem = paramAnonymousMenuItem.getUsername();
              com.tencent.mm.model.ab.F(paramAnonymousMenuItem, true);
              paramAnonymousMenuItem = ContactWidgetTabBizInfo.d(this.Bmx.Bmw);
              if (paramAnonymousMenuItem == null) {
                break label439;
              }
            }
            label439:
            for (paramAnonymousMenuItem = paramAnonymousMenuItem.getUsername();; paramAnonymousMenuItem = null)
            {
              com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.c(paramAnonymousMenuItem, 904, ContactWidgetTabBizInfo.e(this.Bmx.Bmw), this.Bmx.Bmw.enterTime);
              ContactWidgetTabBizInfo.s(this.Bmx.Bmw);
              if (com.tencent.mm.storage.ab.clc())
              {
                localas1 = ContactWidgetTabBizInfo.d(this.Bmx.Bmw);
                paramAnonymousMenuItem = localas2;
                if (localas1 != null) {
                  paramAnonymousMenuItem = localas1.getUsername();
                }
                if (!com.tencent.mm.al.g.Nb(paramAnonymousMenuItem)) {
                  break label481;
                }
              }
              com.tencent.mm.ui.base.h.cA((Context)ContactWidgetTabBizInfo.h(this.Bmx.Bmw), ContactWidgetTabBizInfo.h(this.Bmx.Bmw).getString(2131756793));
              AppMethodBeat.o(230676);
              return;
              paramAnonymousMenuItem = null;
              break;
            }
          }
          if (paramAnonymousInt == ContactWidgetTabBizInfo.o(this.Bmx.Bmw))
          {
            ContactWidgetTabBizInfo.t(this.Bmx.Bmw);
            AppMethodBeat.o(230676);
            return;
          }
          Log.w("MicroMsg.ContactWidgetTabBizInfo", "default onMMMenuItemSelected err");
          label481:
          AppMethodBeat.o(230676);
        }
      });
      paramMenuItem.dGm();
      paramMenuItem = ContactWidgetTabBizInfo.d(this.Bmw);
      if (paramMenuItem != null) {}
      for (paramMenuItem = paramMenuItem.getUsername();; paramMenuItem = null)
      {
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.c(paramMenuItem, 600, ContactWidgetTabBizInfo.e(this.Bmw), this.Bmw.enterTime);
        AppMethodBeat.o(230677);
        return false;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onExpand", "com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizInfo$initView$3$1"})
  static final class h
    implements c.a
  {
    h(ContactWidgetTabBizInfo paramContactWidgetTabBizInfo) {}
    
    public final void eFF()
    {
      AppMethodBeat.i(230678);
      int i = ContactWidgetTabBizInfo.c(this.Bmw).getCurrentItem();
      if (ContactWidgetTabBizInfo.c(this.Bmw).getCurrentItem() > ContactWidgetTabBizInfo.b(this.Bmw).size() - 1)
      {
        AppMethodBeat.o(230678);
        return;
      }
      Object localObject2 = (Iterable)ContactWidgetTabBizInfo.b(this.Bmw);
      Object localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        if ((p.j((BaseBizProfileFragment)localObject3, (BaseBizProfileFragment)ContactWidgetTabBizInfo.b(this.Bmw).get(i)) ^ true)) {
          ((Collection)localObject1).add(localObject3);
        }
      }
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((BaseBizProfileFragment)((Iterator)localObject1).next()).eFM();
      }
      AppMethodBeat.o(230678);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "position", "", "invoke"})
  static final class i
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Integer, x>
  {
    i(ContactWidgetTabBizInfo paramContactWidgetTabBizInfo)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class j
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    j(ContactWidgetTabBizInfo paramContactWidgetTabBizInfo)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/BizProfileV2Resp;", "onChanged"})
  static final class k<T>
    implements Observer<ph>
  {
    k(ContactWidgetTabBizInfo paramContactWidgetTabBizInfo) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/profile/ui/tab/data/BizProfileDataFetcher;", "invoke"})
  static final class l
    extends kotlin.g.b.q
    implements kotlin.g.a.a<BizProfileDataFetcher>
  {
    l(ContactWidgetTabBizInfo paramContactWidgetTabBizInfo)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class m
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    m(ContactWidgetTabBizInfo paramContactWidgetTabBizInfo)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "serviceInfo", "Lcom/tencent/mm/protocal/protobuf/BizServiceMenuButton;", "position", "", "index", "invoke"})
  static final class n
    extends kotlin.g.b.q
    implements kotlin.g.a.q<qa, Integer, Integer, x>
  {
    n(ContactWidgetTabBizInfo paramContactWidgetTabBizInfo)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.ContactWidgetTabBizInfo
 * JD-Core Version:    0.7.0.1
 */