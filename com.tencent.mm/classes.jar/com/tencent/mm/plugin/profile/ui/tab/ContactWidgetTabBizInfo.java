package com.tencent.mm.plugin.profile.ui.tab;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.GestureDetector.OnGestureListener;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.appcompat.app.ActionBar;
import androidx.lifecycle.k;
import androidx.lifecycle.r;
import androidx.lifecycle.s;
import androidx.viewpager.widget.ViewPager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ao.af;
import com.tencent.mm.api.c.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.profile.ui.ContactInfoUI;
import com.tencent.mm.plugin.profile.ui.tab.data.BizProfileDataFetcher;
import com.tencent.mm.plugin.profile.ui.tab.list.BaseBizProfileFragment;
import com.tencent.mm.plugin.profile.ui.tab.list.BizProfileTabMsgFragment;
import com.tencent.mm.plugin.profile.ui.tab.list.BizProfileTabVideoFragment;
import com.tencent.mm.plugin.profile.ui.tab.observer.BizProfileExtraOperateObserver;
import com.tencent.mm.plugin.profile.ui.tab.observer.BizProfileWidgetOperateObserver;
import com.tencent.mm.plugin.profile.ui.tab.view.BizProfileTabLayout;
import com.tencent.mm.pluginsdk.o.a;
import com.tencent.mm.protocal.protobuf.aez;
import com.tencent.mm.protocal.protobuf.mg;
import com.tencent.mm.protocal.protobuf.nf;
import com.tencent.mm.protocal.protobuf.op;
import com.tencent.mm.protocal.protobuf.pd;
import com.tencent.mm.protocal.protobuf.pu;
import com.tencent.mm.protocal.protobuf.pv;
import com.tencent.mm.protocal.protobuf.pw;
import com.tencent.mm.protocal.protobuf.qf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.w.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizInfo;", "Lcom/tencent/mm/pluginsdk/deprecated/IBodyWidgetEx;", "Landroidx/lifecycle/LifecycleObserver;", "context", "Lcom/tencent/mm/plugin/profile/ui/ContactInfoUI;", "brandIconUrl", "", "customizedInfo", "Lcom/tencent/mm/protocal/protobuf/CustomizedInfo;", "enterTime", "", "(Lcom/tencent/mm/plugin/profile/ui/ContactInfoUI;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/CustomizedInfo;J)V", "AT_SELECT_BIZ_CARD", "", "BIZ_REPORT_URL", "CRASH_FLAG", "MENU_ID_ADD_STAR", "MENU_ID_COMPLAIN", "MENU_ID_MORE", "MENU_ID_REMOVE_STAR", "MENU_ID_SEND", "MENU_ID_SETTING", "MENU_ID_UNSUBSCRIBE", "addContactScene", "addFriendSearchScene", "bizInfo", "Lcom/tencent/mm/api/BizInfo;", "blockAddContact", "", "getBrandIconUrl", "()Ljava/lang/String;", "setBrandIconUrl", "(Ljava/lang/String;)V", "brandInfoList", "", "Lcom/tencent/mm/api/BizInfo$BrandInfo;", "channelSessionId", "contact", "Lcom/tencent/mm/storage/Contact;", "contentView", "Landroid/view/View;", "currentExpandState", "getCurrentExpandState", "()Z", "setCurrentExpandState", "(Z)V", "getCustomizedInfo", "()Lcom/tencent/mm/protocal/protobuf/CustomizedInfo;", "setCustomizedInfo", "(Lcom/tencent/mm/protocal/protobuf/CustomizedInfo;)V", "defaultTabSelectType", "getDefaultTabSelectType", "()I", "defaultTabSelectType$delegate", "Lkotlin/Lazy;", "getEnterTime", "()J", "setEnterTime", "(J)V", "extInfo", "Lcom/tencent/mm/api/BizInfo$ExtInfo;", "followStatus", "fragments", "", "Lcom/tencent/mm/plugin/profile/ui/tab/list/BaseBizProfileFragment;", "headerController", "Lcom/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController;", "isChecking", "isFirstTime", "menuDialog", "Lcom/tencent/mm/ui/widget/dialog/MMHalfBottomDialog;", "menuTabLayout", "Lcom/tencent/mm/plugin/profile/ui/tab/view/BizProfileTabLayout;", "operationObservers", "Lcom/tencent/mm/plugin/profile/ui/tab/observer/IBizProfileOperateObserver;", "pagerAdapter", "Lcom/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizInfo$BizProfilePagerAdapter;", "profileDataFetcher", "Lcom/tencent/mm/plugin/profile/ui/tab/data/BizProfileDataFetcher;", "getProfileDataFetcher", "()Lcom/tencent/mm/plugin/profile/ui/tab/data/BizProfileDataFetcher;", "profileDataFetcher$delegate", "profileInfo", "Lcom/tencent/mm/protocal/protobuf/BizProfileV2Resp;", "readonly", "verifyPromptTitle", "verifyTicket", "getVerifyTicket", "setVerifyTicket", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "checkCrash", "", "checkParamsLegal", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "dealBizExpose", "dealSendCardEvent", "doSearchHistory", "handleEvent", "key", "hasFollowStateChanged", "originContact", "currentContact", "hideOriginContentView", "initActionBar", "initBizInfo", "initProfile", "initView", "jumpToSettingUI", "loadProfile", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAttach", "onBizProfileUpdate", "bizProfile", "onCreate", "onDestroy", "onDetach", "onPause", "onPlaceTopChange", "onResume", "reportEnd", "reportStart", "reportUpdate", "scrollToTop", "showMenuDialog", "updateActionBarMenu", "expand", "forceUpdate", "updateBizTeenModeStatus", "updateFragments", "updateTabLayout", "needReport", "BizProfilePagerAdapter", "Companion", "app_release"})
public final class ContactWidgetTabBizInfo
  implements k, com.tencent.mm.pluginsdk.c.b
{
  public static final ContactWidgetTabBizInfo.b HgO;
  public String BLy;
  public String GXB;
  private com.tencent.mm.api.c GXj;
  private boolean GXw;
  public aez GYV;
  private int GYZ;
  private final String GZd;
  private final String HdC;
  private boolean HdD;
  private final ContactInfoUI Hdt;
  private pd Hdu;
  private String Hdw;
  private boolean Hdy;
  private boolean Hdz;
  private c HgA;
  private ContactWidgetTabBizInfo.a HgB;
  private BizProfileTabLayout HgC;
  private boolean HgD;
  private final kotlin.f HgE;
  private final kotlin.f HgF;
  private com.tencent.mm.ui.widget.a.g HgG;
  private final int HgH;
  private final int HgI;
  private final int HgJ;
  private final int HgK;
  private final int HgL;
  private boolean HgM;
  private final int HgN;
  private List<com.tencent.mm.plugin.profile.ui.tab.observer.a> Hgz;
  private ViewPager bFl;
  private as contact;
  private View contentView;
  private List<? extends c.a> eZb;
  private com.tencent.mm.api.c.b eZc;
  private String eZl;
  public long enterTime;
  private final List<BaseBizProfileFragment> fragments;
  private int mXL;
  private final int wXe;
  private final int xRJ;
  
  static
  {
    AppMethodBeat.i(269598);
    HgO = new ContactWidgetTabBizInfo.b((byte)0);
    AppMethodBeat.o(269598);
  }
  
  public ContactWidgetTabBizInfo(ContactInfoUI paramContactInfoUI, String paramString, aez paramaez, long paramLong)
  {
    AppMethodBeat.i(269597);
    this.Hdt = paramContactInfoUI;
    this.GXB = paramString;
    this.GYV = paramaez;
    this.enterTime = paramLong;
    this.Hgz = ((List)new ArrayList());
    this.Hdz = true;
    this.HdC = "crashFlag";
    this.fragments = ((List)new ArrayList());
    this.HgD = true;
    this.Hdw = "";
    this.HgE = kotlin.g.ar((kotlin.g.a.a)new l(this));
    this.HgF = kotlin.g.ar((kotlin.g.a.a)new d(this));
    this.Hgz.add(new BizProfileExtraOperateObserver());
    this.Hgz.add(new BizProfileWidgetOperateObserver(this.Hdt));
    this.wXe = 1;
    this.HgH = 2;
    this.xRJ = 3;
    this.HgI = 4;
    this.HgJ = 5;
    this.HgK = 6;
    this.HgL = 7;
    this.HgN = 1;
    this.GZd = "https://mp.weixin.qq.com/mp/infringement?username=%s&from=1#wechat_redirect";
    AppMethodBeat.o(269597);
  }
  
  /* Error */
  private final void ai(as paramas)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 504
    //   5: invokestatic 247	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: ifnull +10 -> 19
    //   12: aload_0
    //   13: getfield 506	com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizInfo:HdD	Z
    //   16: ifeq +12 -> 28
    //   19: ldc_w 504
    //   22: invokestatic 256	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   25: aload_0
    //   26: monitorexit
    //   27: return
    //   28: aload_0
    //   29: iconst_1
    //   30: putfield 506	com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizInfo:HdD	Z
    //   33: ldc_w 508
    //   36: invokestatic 514	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getSingleMMKV	(Ljava/lang/String;)Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   39: astore_2
    //   40: aload_2
    //   41: aload_0
    //   42: getfield 289	com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizInfo:HdC	Ljava/lang/String;
    //   45: iconst_0
    //   46: invokevirtual 518	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:decodeBool	(Ljava/lang/String;Z)Z
    //   49: ifeq +40 -> 89
    //   52: ldc_w 367
    //   55: ldc_w 520
    //   58: invokestatic 522	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   61: getstatic 528	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
    //   64: ldc2_w 529
    //   67: lconst_0
    //   68: lconst_1
    //   69: iconst_0
    //   70: invokevirtual 534	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   73: aload_1
    //   74: invokevirtual 380	com/tencent/mm/storage/as:getUsername	()Ljava/lang/String;
    //   77: astore_1
    //   78: aload_1
    //   79: ldc_w 536
    //   82: invokestatic 539	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   85: aload_1
    //   86: invokestatic 543	com/tencent/mm/plugin/profile/ui/newbizinfo/a:clear	(Ljava/lang/String;)V
    //   89: aload_2
    //   90: aload_0
    //   91: getfield 289	com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizInfo:HdC	Ljava/lang/String;
    //   94: iconst_1
    //   95: invokevirtual 546	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:encode	(Ljava/lang/String;Z)Z
    //   98: pop
    //   99: ldc_w 367
    //   102: ldc_w 548
    //   105: invokestatic 522	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   108: getstatic 553	com/tencent/mm/sdk/platformtools/BuildInfo:DEBUG	Z
    //   111: ifne +15 -> 126
    //   114: getstatic 556	com/tencent/mm/sdk/platformtools/BuildInfo:IS_FLAVOR_RED	Z
    //   117: ifne +9 -> 126
    //   120: invokestatic 561	com/tencent/mm/sdk/platformtools/WeChatEnvironment:hasDebugger	()Z
    //   123: ifeq +22 -> 145
    //   126: aload_2
    //   127: ldc_w 563
    //   130: iconst_0
    //   131: invokevirtual 567	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:decodeInt	(Ljava/lang/String;I)I
    //   134: iconst_1
    //   135: if_icmpne +10 -> 145
    //   138: ldc_w 569
    //   141: iconst_0
    //   142: invokestatic 575	junit/framework/Assert:assertTrue	(Ljava/lang/String;Z)V
    //   145: getstatic 581	com/tencent/e/h:ZvG	Lcom/tencent/e/i;
    //   148: new 14	com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizInfo$c
    //   151: dup
    //   152: aload_0
    //   153: aload_2
    //   154: invokespecial 584	com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizInfo$c:<init>	(Lcom/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizInfo;Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;)V
    //   157: checkcast 586	java/lang/Runnable
    //   160: ldc2_w 587
    //   163: invokeinterface 593 4 0
    //   168: pop
    //   169: ldc_w 504
    //   172: invokestatic 256	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  private final void ao(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(269596);
    Log.d("MicroMsg.ContactWidgetTabBizInfo", "updateActionBarMenu  expand:" + paramBoolean1 + "  forceUpdate:" + paramBoolean2 + "  followStatus:" + this.HgD);
    if ((!paramBoolean2) && (paramBoolean1 == this.HgM))
    {
      AppMethodBeat.o(269596);
      return;
    }
    Log.i("MicroMsg.ContactWidgetTabBizInfo", "updateActionBarMenu  return");
    this.HgM = paramBoolean1;
    this.Hdt.removeAllOptionMenu();
    if ((this.HgD) || (paramBoolean1))
    {
      this.Hdt.addIconOptionMenu(1, R.l.top_item_desc_search, R.k.actionbar_icon_dark_search, (MenuItem.OnMenuItemClickListener)new o(this));
      this.Hdt.addIconOptionMenu(0, "", R.k.actionbar_icon_dark_more, (MenuItem.OnMenuItemClickListener)new p(this));
      AppMethodBeat.o(269596);
      return;
    }
    this.Hdt.addTextOptionMenu(2, this.Hdt.getString(R.l.exR), (MenuItem.OnMenuItemClickListener)new q(this), null, w.b.Wao);
    AppMethodBeat.o(269596);
  }
  
  private final void d(pd parampd)
  {
    int j;
    try
    {
      AppMethodBeat.i(269593);
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
      localObject1 = (BizProfileTabMsgFragment)kotlin.a.j.lp((List)localObject1);
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
    localObject2 = (BizProfileTabVideoFragment)kotlin.a.j.lp((List)localObject2);
    int i;
    if (parampd != null)
    {
      localObject3 = parampd.RXu;
      if (localObject3 != null)
      {
        if (localObject1 != null) {
          break label630;
        }
        localObject4 = ((op)localObject3).RWC;
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
        localObject3 = this.Hdu;
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = new pd();
        }
        ((BizProfileTabMsgFragment)localObject4).f((pd)localObject1);
        localObject1 = new Bundle();
        localObject3 = this.contact;
        if (localObject3 == null) {
          p.iCn();
        }
        localObject3 = ((as)localObject3).getUsername();
        p.j(localObject3, "contact!!.username");
        com.tencent.mm.plugin.handoff.c.b.a((Bundle)localObject1, "contact", (String)localObject3);
        ((BizProfileTabMsgFragment)localObject4).setArguments((Bundle)localObject1);
        ((BizProfileTabMsgFragment)localObject4).e(frD());
        this.fragments.add(0, localObject4);
      }
    }
    label357:
    Object localObject1 = localObject2;
    if (parampd != null)
    {
      parampd = parampd.RXw;
      localObject1 = localObject2;
      if (parampd != null)
      {
        if (localObject2 != null) {
          break label704;
        }
        localObject1 = parampd.RWC;
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
        localObject2 = this.Hdu;
        parampd = (pd)localObject2;
        if (localObject2 == null) {
          parampd = new pd();
        }
        ((BizProfileTabVideoFragment)localObject1).f(parampd);
        parampd = new Bundle();
        localObject2 = this.contact;
        if (localObject2 == null) {
          p.iCn();
        }
        localObject2 = ((as)localObject2).getUsername();
        p.j(localObject2, "contact!!.username");
        com.tencent.mm.plugin.handoff.c.b.a(parampd, "contact", (String)localObject2);
        ((BizProfileTabVideoFragment)localObject1).setArguments(parampd);
        ((BizProfileTabVideoFragment)localObject1).e(frD());
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
        parampd = this.HgB;
        if (parampd == null) {
          p.bGy("pagerAdapter");
        }
        parampd.notifyDataSetChanged();
      }
      if ((localObject1 != null) && (frE() == 1))
      {
        parampd = this.fragments;
        if (localObject1 == null) {
          p.iCn();
        }
        i = parampd.indexOf(localObject1);
        if (i >= 0)
        {
          parampd = this.bFl;
          if (parampd == null) {
            p.bGy("viewPager");
          }
          parampd.setCurrentItem(i, false);
        }
      }
      AppMethodBeat.o(269593);
      return;
      i = 0;
      break;
      localObject3 = ((op)localObject3).RWC;
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
        p.iCn();
      }
      ((List)localObject3).remove(localObject1);
      break label357;
      parampd = parampd.RWC;
      localObject1 = localObject2;
    } while (parampd == null);
    label667:
    label704:
    parampd = (Collection)parampd;
    if (parampd != null) {
      if (parampd.isEmpty()) {
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
      parampd = this.fragments;
      if (localObject2 == null) {
        p.iCn();
      }
      parampd.remove(localObject2);
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
  
  private final void fqQ()
  {
    int j = 0;
    Object localObject3 = null;
    AppMethodBeat.i(269589);
    Object localObject1 = this.contact;
    Object localObject2;
    label81:
    int i;
    if (localObject1 != null)
    {
      localObject1 = ((as)localObject1).getUsername();
      localObject1 = com.tencent.mm.ao.g.gu((String)localObject1);
      this.eZb = null;
      this.eZc = null;
      if (((localObject1 != null) && (((com.tencent.mm.api.c)localObject1).YO() != null)) || (this.GYV == null)) {
        break label545;
      }
      localObject2 = new com.tencent.mm.api.c();
      localObject1 = this.contact;
      if (localObject1 == null) {
        break label208;
      }
      localObject1 = ((as)localObject1).getUsername();
      ((com.tencent.mm.api.c)localObject2).field_username = ((String)localObject1);
      localObject1 = this.GYV;
      if (localObject1 == null) {
        break label213;
      }
      i = ((aez)localObject1).mVM;
      label101:
      ((com.tencent.mm.api.c)localObject2).field_brandFlag = i;
      localObject1 = this.GYV;
      if (localObject1 == null) {
        break label218;
      }
      localObject1 = ((aez)localObject1).mVP;
      label121:
      ((com.tencent.mm.api.c)localObject2).field_brandIconURL = ((String)localObject1);
      localObject1 = this.GYV;
      if (localObject1 == null) {
        break label223;
      }
      localObject1 = ((aez)localObject1).mVO;
      label141:
      ((com.tencent.mm.api.c)localObject2).field_brandInfo = ((String)localObject1);
      localObject1 = this.GYV;
      if (localObject1 == null) {
        break label228;
      }
      localObject1 = ((aez)localObject1).mVN;
      label161:
      ((com.tencent.mm.api.c)localObject2).field_extInfo = ((String)localObject1);
      localObject1 = ((com.tencent.mm.api.c)localObject2).YO();
      p.j(localObject1, "bi.extInfo");
      ((com.tencent.mm.api.c)localObject2).field_type = ((com.tencent.mm.api.c.b)localObject1).getServiceType();
      localObject1 = localObject2;
    }
    label512:
    label517:
    label523:
    label529:
    label535:
    label540:
    label545:
    for (;;)
    {
      if (localObject1 == null)
      {
        AppMethodBeat.o(269589);
        return;
        localObject1 = null;
        break;
        label208:
        localObject1 = null;
        break label81;
        label213:
        i = 0;
        break label101;
        label218:
        localObject1 = null;
        break label121;
        label223:
        localObject1 = null;
        break label141;
        label228:
        localObject1 = null;
        break label161;
      }
      if ((((com.tencent.mm.api.c)localObject1).field_brandInfo == null) && (((com.tencent.mm.api.c)localObject1).field_extInfo == null) && (this.GYV != null))
      {
        localObject2 = this.contact;
        if (localObject2 != null)
        {
          localObject2 = ((as)localObject2).getUsername();
          ((com.tencent.mm.api.c)localObject1).field_username = ((String)localObject2);
          localObject2 = this.GYV;
          if (localObject2 == null) {
            break label512;
          }
          i = ((aez)localObject2).mVM;
          label295:
          ((com.tencent.mm.api.c)localObject1).field_brandFlag = i;
          localObject2 = this.GYV;
          if (localObject2 == null) {
            break label517;
          }
          localObject2 = ((aez)localObject2).mVP;
          label318:
          ((com.tencent.mm.api.c)localObject1).field_brandIconURL = ((String)localObject2);
          localObject2 = this.GYV;
          if (localObject2 == null) {
            break label523;
          }
          localObject2 = ((aez)localObject2).mVO;
          label342:
          ((com.tencent.mm.api.c)localObject1).field_brandInfo = ((String)localObject2);
          localObject2 = this.GYV;
          if (localObject2 == null) {
            break label529;
          }
          localObject2 = ((aez)localObject2).mVN;
          label366:
          ((com.tencent.mm.api.c)localObject1).field_extInfo = ((String)localObject2);
          localObject2 = ((com.tencent.mm.api.c)localObject1).YO();
          p.j(localObject2, "bi.extInfo");
          ((com.tencent.mm.api.c)localObject1).field_type = ((com.tencent.mm.api.c.b)localObject2).getServiceType();
        }
      }
      else
      {
        this.GXj = ((com.tencent.mm.api.c)localObject1);
        this.eZb = ((com.tencent.mm.api.c)localObject1).Zg();
        this.eZc = ((com.tencent.mm.api.c)localObject1).YO();
        localObject1 = this.eZc;
        if (localObject1 == null) {
          break label535;
        }
        localObject1 = ((com.tencent.mm.api.c.b)localObject1).Zk();
        label430:
        if (localObject1 != null)
        {
          localObject1 = this.eZc;
          if (localObject1 == null) {
            break label540;
          }
        }
      }
      for (localObject1 = ((com.tencent.mm.api.c.b)localObject1).Zk();; localObject1 = null)
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
          localObject2 = this.eZc;
          localObject1 = localObject3;
          if (localObject2 != null) {
            localObject1 = ((com.tencent.mm.api.c.b)localObject2).Zk();
          }
          this.eZl = ((String)localObject1);
        }
        AppMethodBeat.o(269589);
        return;
        localObject2 = null;
        break;
        i = 0;
        break label295;
        localObject2 = null;
        break label318;
        localObject2 = null;
        break label342;
        localObject2 = null;
        break label366;
        localObject1 = null;
        break label430;
      }
    }
  }
  
  private final void fqh()
  {
    AppMethodBeat.i(269590);
    cQX();
    if (this.contact == null)
    {
      AppMethodBeat.o(269590);
      return;
    }
    fqQ();
    AppMethodBeat.o(269590);
  }
  
  private final BizProfileDataFetcher frD()
  {
    AppMethodBeat.i(269578);
    BizProfileDataFetcher localBizProfileDataFetcher = (BizProfileDataFetcher)this.HgE.getValue();
    AppMethodBeat.o(269578);
    return localBizProfileDataFetcher;
  }
  
  private final int frE()
  {
    AppMethodBeat.i(269579);
    int i = ((Number)this.HgF.getValue()).intValue();
    AppMethodBeat.o(269579);
    return i;
  }
  
  private final void wi(boolean paramBoolean)
  {
    AppMethodBeat.i(269594);
    Object localObject1 = this.HgC;
    if (localObject1 == null) {
      p.bGy("menuTabLayout");
    }
    ((BizProfileTabLayout)localObject1).frO();
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
      localObject1 = this.Hdu;
      int j;
      if (localObject1 != null)
      {
        localObject1 = ((pd)localObject1).RXx;
        if (localObject1 != null)
        {
          localObject1 = ((pu)localObject1).RYd;
          if (localObject1 != null)
          {
            localObject1 = ((pv)localObject1).RYf;
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
          localObject1 = this.HgC;
          if (localObject1 == null) {
            p.bGy("menuTabLayout");
          }
          localObject1 = ((BizProfileTabLayout)localObject1).Him;
          if (localObject1 == null) {
            p.bGy("mMsgLayout");
          }
          ((ViewGroup)localObject1).setVisibility(0);
        }
        if ((k != 0) && ((i != 0) || (j != 0)))
        {
          localObject1 = this.HgC;
          if (localObject1 == null) {
            p.bGy("menuTabLayout");
          }
          localObject1 = ((BizProfileTabLayout)localObject1).Hin;
          if (localObject1 == null) {
            p.bGy("mVideoLayout");
          }
          ((ViewGroup)localObject1).setVisibility(0);
        }
        if (j != 0)
        {
          localObject1 = this.HgC;
          if (localObject1 == null) {
            p.bGy("menuTabLayout");
          }
          localObject1 = ((BizProfileTabLayout)localObject1).Hio;
          if (localObject1 == null) {
            p.bGy("mServiceLayout");
          }
          ((ViewGroup)localObject1).setVisibility(0);
        }
        localObject1 = this.HgC;
        if (localObject1 == null) {
          p.bGy("menuTabLayout");
        }
        localObject2 = this.bFl;
        if (localObject2 == null) {
          p.bGy("viewPager");
        }
        int m = ((ViewPager)localObject2).getCurrentItem();
        if ((m < 0) || (m >= ((BizProfileTabLayout)localObject1).getTabCount()))
        {
          if (this.fragments.size() > 1) {
            break label603;
          }
          localObject1 = this.HgC;
          if (localObject1 == null) {
            p.bGy("menuTabLayout");
          }
          if (((BizProfileTabLayout)localObject1).getTabCount() > 0) {
            break label603;
          }
          localObject1 = this.HgC;
          if (localObject1 == null) {
            p.bGy("menuTabLayout");
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
              localObject1 = com.tencent.mm.plugin.profile.ui.tab.data.b.Hhf;
              com.tencent.mm.plugin.profile.ui.tab.data.b.a(this.contact, 0, this.mXL);
            }
            if (k != 0)
            {
              localObject1 = com.tencent.mm.plugin.profile.ui.tab.data.b.Hhf;
              com.tencent.mm.plugin.profile.ui.tab.data.b.a(this.contact, 1, this.mXL);
            }
            if (j != 0)
            {
              localObject1 = com.tencent.mm.plugin.profile.ui.tab.data.b.Hhf;
              com.tencent.mm.plugin.profile.ui.tab.data.b.a(this.contact, 2, this.mXL);
            }
            if ((i == 0) && (k == 0) && (j == 0))
            {
              localObject1 = com.tencent.mm.plugin.profile.ui.tab.data.b.Hhf;
              com.tencent.mm.plugin.profile.ui.tab.data.b.a(this.contact, 3, this.mXL);
            }
          }
          AppMethodBeat.o(269594);
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
            ((BizProfileTabLayout)localObject1).frP();
            break;
          case 1: 
            ((BizProfileTabLayout)localObject1).frQ();
            break;
            localObject1 = this.HgC;
            if (localObject1 == null) {
              p.bGy("menuTabLayout");
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
    AppMethodBeat.i(269584);
    if (this.Hdt.isFinishing())
    {
      AppMethodBeat.o(269584);
      return true;
    }
    if (paramas != null)
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      if (paramas == null) {
        break label150;
      }
      localObject1 = paramas.getUsername();
      label46:
      localObject1 = Util.nullAsNil((String)localObject1);
      p.j(localObject1, "Util.nullAsNil(contact?.username)");
      if (((CharSequence)localObject1).length() <= 0) {
        break label156;
      }
      bool1 = true;
      label77:
      Assert.assertTrue(bool1);
      if (paramf == null) {
        break label162;
      }
    }
    label150:
    label156:
    label162:
    for (boolean bool1 = true;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      ai(paramas);
      localObject1 = ((Iterable)this.Hgz).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((com.tencent.mm.plugin.profile.ui.tab.observer.a)((Iterator)localObject1).next()).a(paramf, paramas);
      }
      bool1 = false;
      break;
      localObject1 = null;
      break label46;
      bool1 = false;
      break label77;
    }
    this.contact = paramas;
    this.GXw = paramBoolean;
    this.mXL = paramInt;
    this.GYZ = this.Hdt.getIntent().getIntExtra("add_more_friend_search_scene", 0);
    Object localObject1 = this.Hdt.getIntent().getStringExtra("key_channel_session_id");
    paramf = (com.tencent.mm.ui.base.preference.f)localObject1;
    if (localObject1 == null) {
      paramf = "";
    }
    this.Hdw = paramf;
    Object localObject2;
    if ((this.mXL == 78) || (this.mXL == 79))
    {
      this.Hdy = false;
      Log.i("MicroMsg.ContactWidgetTabBizInfo", "updateBizTeenModeStatus addContactScene: %d not need to block", new Object[] { Integer.valueOf(this.mXL) });
      if (!this.Hdz) {
        break label1630;
      }
      this.Hdz = false;
      paramf = this.Hdt.findViewById(R.h.mm_preference_list_content);
      if (paramf != null) {
        paramf.setVisibility(8);
      }
      paramf = this.Hdt.getListView();
      if (paramf != null) {
        paramf.setVisibility(8);
      }
      paramf = this.Hdt.findViewById(R.h.preference_bottom);
      if (paramf != null) {
        paramf.setVisibility(8);
      }
      paramf = this.contact;
      if (paramf != null)
      {
        paramf = paramf.getUsername();
        if (paramf != null) {
          this.Hdu = com.tencent.mm.plugin.profile.ui.newbizinfo.a.aUW(paramf);
        }
      }
      this.Hdt.findViewById(R.h.mm_preference_list_content_root);
      paramf = LayoutInflater.from((Context)this.Hdt).inflate(R.i.efc, null);
      p.j(paramf, "inflater.inflate(R.layou…ntact_info_biz_tab, null)");
      this.contentView = paramf;
      paramf = this.Hdt;
      localObject1 = this.contentView;
      if (localObject1 == null) {
        p.bGy("contentView");
      }
      paramf.setContentView((View)localObject1);
      paramf = this.contentView;
      if (paramf == null) {
        p.bGy("contentView");
      }
      paramf = paramf.findViewById(R.h.dAv);
      p.j(paramf, "contentView.findViewById…(R.id.combo_content_view)");
      this.bFl = ((ViewPager)paramf);
      paramf = this.contentView;
      if (paramf == null) {
        p.bGy("contentView");
      }
      paramf = paramf.findViewById(R.h.dtO);
      p.j(paramf, "contentView.findViewById…_profile_menu_tab_layout)");
      this.HgC = ((BizProfileTabLayout)paramf);
      paramf = this.HgC;
      if (paramf == null) {
        p.bGy("menuTabLayout");
      }
      paramf.setOnTabSelected((kotlin.g.a.b)new i(this));
      paramf = this.HgC;
      if (paramf == null) {
        p.bGy("menuTabLayout");
      }
      paramf.setOnServiceTabSelected((kotlin.g.a.a)new j(this));
      paramf = (MMActivity)this.Hdt;
      localObject1 = this.contentView;
      if (localObject1 == null) {
        p.bGy("contentView");
      }
      paramf = new c(paramf, (View)localObject1);
      paramf.a((c.b)new h(this));
      this.HgA = paramf;
      localObject2 = this.Hdu;
      if (localObject2 != null)
      {
        if (frE() != 1) {
          break label1269;
        }
        paramf = ((pd)localObject2).RXw;
        if (paramf == null) {
          break label1269;
        }
        paramf = paramf.RWC;
        if (paramf == null) {
          break label1269;
        }
        if (((Collection)paramf).isEmpty()) {
          break label1263;
        }
        i = 1;
        label692:
        if (i != 1) {
          break label1269;
        }
      }
      label698:
      paramf = this.fragments;
      localObject1 = this.Hdt.getSupportFragmentManager();
      p.j(localObject1, "context.supportFragmentManager");
      this.HgB = new ContactWidgetTabBizInfo.a(paramf, (androidx.fragment.app.e)localObject1);
      paramf = this.bFl;
      if (paramf == null) {
        p.bGy("viewPager");
      }
      localObject1 = this.HgB;
      if (localObject1 == null) {
        p.bGy("pagerAdapter");
      }
      paramf.setAdapter((androidx.viewpager.widget.a)localObject1);
      paramf = this.HgB;
      if (paramf == null) {
        p.bGy("pagerAdapter");
      }
      paramf.notifyDataSetChanged();
      wi(false);
      paramf = new androidx.core.g.d((Context)this.Hdt, (GestureDetector.OnGestureListener)new ContactWidgetTabBizInfo.g(this));
      localObject1 = this.Hdt.getSupportActionBar();
      if (localObject1 != null)
      {
        localObject1 = ((ActionBar)localObject1).getCustomView();
        if (localObject1 != null)
        {
          localObject1 = ((View)localObject1).findViewById(a.g.actionbar_center_layout);
          if (localObject1 != null) {
            ((View)localObject1).setOnTouchListener((View.OnTouchListener)new ContactWidgetTabBizInfo.e(paramf));
          }
        }
      }
      localObject1 = this.Hdt;
      paramf = this.contact;
      if (paramf == null) {
        break label1619;
      }
      paramf = paramf.getNickname();
      label902:
      ((ContactInfoUI)localObject1).setMMTitle(Util.nullAsNil(paramf));
      this.Hdt.setMMTitleColor(androidx.core.content.a.w((Context)this.Hdt, R.e.FG_0));
      this.Hdt.setMMTitleVisibility(8);
      this.Hdt.setTitleDividerVis(false);
      this.Hdt.setIsDarkActionbarBg(false);
      this.Hdt.setActionbarColor(this.Hdt.getResources().getColor(R.e.BG_2));
      this.Hdt.hideActionbarLine();
      this.Hdt.setBackBtn((MenuItem.OnMenuItemClickListener)new f(this), R.k.actionbar_icon_dark_back);
      ao(true, true);
      fqh();
      if (paramas != null) {
        af.bjI().Ui(paramas.getUsername());
      }
      frD().HgT.a((androidx.lifecycle.l)this.Hdt, (s)new k(this));
      if (paramas != null)
      {
        if ((!paramas.axZ()) || (paramas.ayq() <= 0)) {
          break label1624;
        }
        bool1 = true;
        label1078:
        this.HgD = bool1;
      }
      frD().frF();
      label1091:
      localObject1 = this.Hdt;
      if (paramas == null) {
        break label1688;
      }
      paramf = paramas.getNickname();
      label1106:
      ((ContactInfoUI)localObject1).setMMTitle(Util.nullAsNil(paramf));
      paramf = this.Hdt;
      if (!this.HgM) {
        break label1693;
      }
    }
    label1303:
    label1688:
    label1693:
    for (int i = 8;; i = 0)
    {
      paramf.setMMTitleVisibility(i);
      paramf = this.HgA;
      if (paramf != null) {
        paramf.a(paramas, this.GXB, this.GXj, this.Hdu, paramInt, paramBoolean);
      }
      AppMethodBeat.o(269584);
      return true;
      paramf = com.tencent.mm.kernel.h.ae(com.tencent.mm.api.q.class);
      p.j(paramf, "MMKernel.service(IBizTeenModeService::class.java)");
      boolean bool2 = ((com.tencent.mm.api.q)paramf).ZN();
      if (!bool2) {}
      for (bool1 = true;; bool1 = false)
      {
        this.Hdy = bool1;
        Log.i("MicroMsg.ContactWidgetTabBizInfo", "updateBizTeenModeStatus addContactScene: %d, blockAddContact: %b, isBizTeenModeAllowAll: %b", new Object[] { Integer.valueOf(this.mXL), Boolean.valueOf(this.Hdy), Boolean.valueOf(bool2) });
        break;
      }
      label1263:
      i = 0;
      break label692;
      label1269:
      paramf = ((pd)localObject2).RXu;
      Object localObject3;
      if (paramf != null)
      {
        paramf = paramf.RWC;
        if (paramf != null)
        {
          if (((Collection)paramf).isEmpty()) {
            break label1607;
          }
          i = 1;
          if (i == 1)
          {
            localObject3 = this.fragments;
            BizProfileTabMsgFragment localBizProfileTabMsgFragment = new BizProfileTabMsgFragment();
            localObject1 = this.Hdu;
            paramf = (com.tencent.mm.ui.base.preference.f)localObject1;
            if (localObject1 == null) {
              paramf = new pd();
            }
            localBizProfileTabMsgFragment.f(paramf);
            paramf = new Bundle();
            localObject1 = this.contact;
            if (localObject1 == null) {
              p.iCn();
            }
            localObject1 = ((as)localObject1).getUsername();
            p.j(localObject1, "contact!!.username");
            com.tencent.mm.plugin.handoff.c.b.a(paramf, "contact", (String)localObject1);
            localBizProfileTabMsgFragment.setArguments(paramf);
            localBizProfileTabMsgFragment.e(frD());
            localBizProfileTabMsgFragment.enterTime = this.enterTime;
            localBizProfileTabMsgFragment.Hhj = this.HgA;
            ((List)localObject3).add(localBizProfileTabMsgFragment);
          }
        }
      }
      paramf = ((pd)localObject2).RXw;
      if (paramf == null) {
        break label698;
      }
      paramf = paramf.RWC;
      if (paramf == null) {
        break label698;
      }
      if (!((Collection)paramf).isEmpty()) {}
      for (i = 1;; i = 0)
      {
        if (i != 1) {
          break label1617;
        }
        localObject2 = this.fragments;
        localObject3 = new BizProfileTabVideoFragment();
        localObject1 = this.Hdu;
        paramf = (com.tencent.mm.ui.base.preference.f)localObject1;
        if (localObject1 == null) {
          paramf = new pd();
        }
        ((BizProfileTabVideoFragment)localObject3).f(paramf);
        paramf = new Bundle();
        localObject1 = this.contact;
        if (localObject1 == null) {
          p.iCn();
        }
        localObject1 = ((as)localObject1).getUsername();
        p.j(localObject1, "contact!!.username");
        com.tencent.mm.plugin.handoff.c.b.a(paramf, "contact", (String)localObject1);
        ((BizProfileTabVideoFragment)localObject3).setArguments(paramf);
        ((BizProfileTabVideoFragment)localObject3).e(frD());
        ((BaseBizProfileFragment)localObject3).Hhj = this.HgA;
        ((List)localObject2).add(localObject3);
        break;
        label1607:
        i = 0;
        break label1303;
      }
      label1617:
      break label698;
      label1619:
      paramf = null;
      break label902;
      label1624:
      bool1 = false;
      break label1078;
      label1630:
      if (paramas == null) {
        break label1091;
      }
      if ((paramas.axZ()) && (paramas.ayq() > 0)) {}
      for (bool1 = true;; bool1 = false)
      {
        if (this.HgD != bool1)
        {
          frD().frF();
          ao(true, true);
        }
        this.HgD = bool1;
        break;
      }
      paramf = null;
      break label1106;
    }
  }
  
  public final boolean aEt()
  {
    AppMethodBeat.i(269588);
    if ((this.contact != null) && (this.GXj != null) && (this.Hdu != null))
    {
      localObject = this.Hdu;
      if (localObject == null) {
        p.iCn();
      }
      if (((pd)localObject).RXt != null)
      {
        localObject = this.Hdu;
        if (localObject == null) {
          p.iCn();
        }
        if (((pd)localObject).RXs != null) {
          break label218;
        }
      }
    }
    Log.w("MicroMsg.ContactWidgetTabBizInfo", "reportEnd fail, err");
    Object localObject = this.Hdu;
    label110:
    String str2;
    label147:
    String str3;
    if (localObject != null)
    {
      localObject = ((pd)localObject).RXD;
      if (localObject != null)
      {
        localObject = ((qf)localObject).RYA;
        str2 = z.a((com.tencent.mm.cd.b)localObject);
        localObject = this.Hdu;
        if (localObject == null) {
          break label485;
        }
        localObject = ((pd)localObject).RXD;
        if (localObject == null) {
          break label485;
        }
        localObject = ((qf)localObject).RYB;
        str3 = z.a((com.tencent.mm.cd.b)localObject);
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
      AppMethodBeat.o(269588);
      return true;
      l1 = System.currentTimeMillis();
      localObject = this.contact;
      if (localObject == null) {
        p.iCn();
      }
      str1 = ((as)localObject).getUsername();
      int k = this.mXL;
      localObject = this.GXj;
      if (localObject == null) {
        p.iCn();
      }
      int m = ((com.tencent.mm.api.c)localObject).field_type;
      long l2 = this.enterTime;
      localObject = this.contact;
      if (localObject == null) {
        p.iCn();
      }
      int n;
      int j;
      if (((as)localObject).axZ())
      {
        i = 1;
        localObject = this.Hdu;
        if (localObject == null) {
          p.iCn();
        }
        n = ((pd)localObject).RXt.RTV;
        localObject = this.Hdu;
        if (localObject == null) {
          p.iCn();
        }
        localObject = ((pd)localObject).RXt;
        if (localObject == null) {
          break label468;
        }
        j = ((nf)localObject).RTW;
        localObject = this.Hdu;
        if (localObject == null) {
          p.iCn();
        }
        str2 = com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.c(((pd)localObject).RXu);
        localObject = this.Hdu;
        if (localObject == null) {
          p.iCn();
        }
        str3 = com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.a(((pd)localObject).RXx);
        localObject = this.Hdu;
        if (localObject == null) {
          p.iCn();
        }
        localObject = ((pd)localObject).RXs;
        if (localObject == null) {
          break label473;
        }
      }
      for (localObject = ((mg)localObject).UserName;; localObject = null)
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
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.IzE;
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
    localObject = this.HgA;
    if (localObject != null) {
      ((c)localObject).onDestroy();
    }
    AppMethodBeat.o(269588);
    return true;
  }
  
  public final boolean atw(String paramString)
  {
    return true;
  }
  
  public final boolean cQX()
  {
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(269585);
    Log.i("MicroMsg.ContactWidgetTabBizInfo", "onActivityResult, requestCode = %d, resultCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == this.HgN)
    {
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        String str1 = paramIntent.getStringExtra("be_send_card_name");
        String str2 = paramIntent.getStringExtra("received_card_name");
        boolean bool = paramIntent.getBooleanExtra("Is_Chatroom", false);
        paramIntent = paramIntent.getStringExtra("custom_send_text");
        o.a.eRW().u(str1, str2, bool);
        o.a.eRW().iQ(paramIntent, str2);
        com.tencent.mm.ui.widget.snackbar.b.r((Activity)this.Hdt, this.Hdt.getString(R.l.finish_sent));
        AppMethodBeat.o(269585);
      }
    }
    else
    {
      AppMethodBeat.o(269585);
      return;
    }
    AppMethodBeat.o(269585);
  }
  
  public final boolean onCreate()
  {
    AppMethodBeat.i(269581);
    if ((this.contact == null) || (this.GXj == null))
    {
      Log.w("MicroMsg.ContactWidgetTabBizInfo", "reportStart fail, err");
      localObject1 = this.HgA;
      if (localObject1 != null) {
        ((c)localObject1).onCreate();
      }
      AppMethodBeat.o(269581);
      return true;
    }
    Object localObject1 = this.contact;
    if (localObject1 == null) {
      p.iCn();
    }
    localObject1 = ((as)localObject1).getUsername();
    int j = this.mXL;
    Object localObject2 = this.GXj;
    if (localObject2 == null) {
      p.iCn();
    }
    int k = ((com.tencent.mm.api.c)localObject2).field_type;
    long l = this.enterTime;
    localObject2 = this.contact;
    if (localObject2 == null) {
      p.iCn();
    }
    if (((as)localObject2).axZ()) {}
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.a((String)localObject1, j, k, l, i, this.Hdw);
      break;
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(269587);
    c localc = this.HgA;
    if (localc != null)
    {
      localc.onPause();
      AppMethodBeat.o(269587);
      return;
    }
    AppMethodBeat.o(269587);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(269586);
    c localc = this.HgA;
    if (localc != null)
    {
      localc.onResume();
      AppMethodBeat.o(269586);
      return;
    }
    AppMethodBeat.o(269586);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(ContactWidgetTabBizInfo paramContactWidgetTabBizInfo, MultiProcessMMKV paramMultiProcessMMKV) {}
    
    public final void run()
    {
      AppMethodBeat.i(292278);
      Log.i("MicroMsg.ContactWidgetTabBizInfo", "checkCrash clear crash flag");
      localMultiProcessMMKV.encode(ContactWidgetTabBizInfo.i(this.HgP), false);
      ContactWidgetTabBizInfo.j(this.HgP);
      AppMethodBeat.o(292278);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Integer>
  {
    d(ContactWidgetTabBizInfo paramContactWidgetTabBizInfo)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class f
    implements MenuItem.OnMenuItemClickListener
  {
    f(ContactWidgetTabBizInfo paramContactWidgetTabBizInfo) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(279033);
      ContactWidgetTabBizInfo.h(this.HgP).onBackPressed();
      AppMethodBeat.o(279033);
      return true;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizInfo$initView$3$1", "Lcom/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$OnAppBarExpandListener;", "onActionBarStyleChange", "", "expand", "", "onExpand", "app_release"})
  public static final class h
    implements c.b
  {
    h(ContactWidgetTabBizInfo paramContactWidgetTabBizInfo) {}
    
    public final void frC()
    {
      AppMethodBeat.i(279543);
      int i = ContactWidgetTabBizInfo.c(this.HgP).getCurrentItem();
      if (ContactWidgetTabBizInfo.c(this.HgP).getCurrentItem() > ContactWidgetTabBizInfo.b(this.HgP).size() - 1)
      {
        AppMethodBeat.o(279543);
        return;
      }
      Object localObject2 = (Iterable)ContactWidgetTabBizInfo.b(this.HgP);
      Object localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        if ((p.h((BaseBizProfileFragment)localObject3, (BaseBizProfileFragment)ContactWidgetTabBizInfo.b(this.HgP).get(i)) ^ true)) {
          ((Collection)localObject1).add(localObject3);
        }
      }
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((BaseBizProfileFragment)((Iterator)localObject1).next()).frK();
      }
      AppMethodBeat.o(279543);
    }
    
    public final void wh(boolean paramBoolean)
    {
      AppMethodBeat.i(279544);
      ContactWidgetTabBizInfo.a(this.HgP, paramBoolean);
      AppMethodBeat.o(279544);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "position", "", "invoke"})
  static final class i
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Integer, x>
  {
    i(ContactWidgetTabBizInfo paramContactWidgetTabBizInfo)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class j
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    j(ContactWidgetTabBizInfo paramContactWidgetTabBizInfo)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/BizProfileV2Resp;", "kotlin.jvm.PlatformType", "onChanged"})
  static final class k<T>
    implements s<pd>
  {
    k(ContactWidgetTabBizInfo paramContactWidgetTabBizInfo) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/profile/ui/tab/data/BizProfileDataFetcher;", "invoke"})
  static final class l
    extends kotlin.g.b.q
    implements kotlin.g.a.a<BizProfileDataFetcher>
  {
    l(ContactWidgetTabBizInfo paramContactWidgetTabBizInfo)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class m
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    m(ContactWidgetTabBizInfo paramContactWidgetTabBizInfo)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "serviceInfo", "Lcom/tencent/mm/protocal/protobuf/BizServiceMenuButton;", "position", "", "index", "invoke"})
  static final class n
    extends kotlin.g.b.q
    implements kotlin.g.a.q<pw, Integer, Integer, x>
  {
    n(ContactWidgetTabBizInfo paramContactWidgetTabBizInfo)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class o
    implements MenuItem.OnMenuItemClickListener
  {
    o(ContactWidgetTabBizInfo paramContactWidgetTabBizInfo) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(280100);
      ContactWidgetTabBizInfo.l(this.HgP);
      AppMethodBeat.o(280100);
      return true;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class p
    implements MenuItem.OnMenuItemClickListener
  {
    p(ContactWidgetTabBizInfo paramContactWidgetTabBizInfo) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(291083);
      paramMenuItem = new com.tencent.mm.ui.widget.a.e((Context)ContactWidgetTabBizInfo.h(this.HgP), 1, false);
      paramMenuItem.a((q.f)new q.f()
      {
        public final void onCreateMMMenu(o paramAnonymouso)
        {
          Object localObject2 = null;
          Object localObject1 = null;
          AppMethodBeat.i(282516);
          as localas = ContactWidgetTabBizInfo.d(this.HgR.HgP);
          if ((localas != null) && (localas.axZ() == true))
          {
            localas = ContactWidgetTabBizInfo.d(this.HgR.HgP);
            if ((localas != null) && (localas.ayn() == true))
            {
              localObject2 = ContactWidgetTabBizInfo.d(this.HgR.HgP);
              if (localObject2 != null) {
                localObject1 = ((as)localObject2).getUsername();
              }
              if (com.tencent.mm.ao.g.Uz((String)localObject1)) {
                paramAnonymouso.mn(ContactWidgetTabBizInfo.m(this.HgR.HgP), R.l.eyd);
              }
            }
          }
          label343:
          do
          {
            for (;;)
            {
              paramAnonymouso.mn(ContactWidgetTabBizInfo.o(this.HgR.HgP), R.l.ezg);
              paramAnonymouso.mn(ContactWidgetTabBizInfo.p(this.HgR.HgP), R.l.euL);
              localObject1 = ContactWidgetTabBizInfo.d(this.HgR.HgP);
              if (localObject1 == null) {
                break;
              }
              if (((as)localObject1).axZ() == true)
              {
                paramAnonymouso.mn(ContactWidgetTabBizInfo.q(this.HgR.HgP), R.l.eyk);
                paramAnonymouso.a(ContactWidgetTabBizInfo.r(this.HgR.HgP), -65536, (CharSequence)ContactWidgetTabBizInfo.h(this.HgR.HgP).getString(R.l.esL));
              }
              AppMethodBeat.o(282516);
              return;
              paramAnonymouso.mn(ContactWidgetTabBizInfo.m(this.HgR.HgP), R.l.eLm);
              continue;
              localas = ContactWidgetTabBizInfo.d(this.HgR.HgP);
              localObject1 = localObject2;
              if (localas != null) {
                localObject1 = localas.getUsername();
              }
              if (com.tencent.mm.ao.g.Uz((String)localObject1)) {
                paramAnonymouso.mn(ContactWidgetTabBizInfo.n(this.HgR.HgP), R.l.eyb);
              } else {
                paramAnonymouso.mn(ContactWidgetTabBizInfo.n(this.HgR.HgP), R.l.contact_info_stick_biz);
              }
            }
            localObject1 = ContactWidgetTabBizInfo.d(this.HgR.HgP);
            if (localObject1 == null) {
              break;
            }
            localObject1 = Integer.valueOf(((as)localObject1).ayq());
            if (localObject1 == null) {
              p.iCn();
            }
          } while (((Integer)localObject1).intValue() > 0);
          localObject2 = az.a.ber();
          localObject1 = ContactWidgetTabBizInfo.d(this.HgR.HgP);
          if (localObject1 != null) {}
          for (localObject1 = ((as)localObject1).getUsername();; localObject1 = null)
          {
            ((az.b)localObject2).a((String)localObject1, "", (az.b.a)ContactWidgetTabBizInfo.p.1.1.HgS);
            break;
            localObject1 = null;
            break label343;
          }
          AppMethodBeat.o(282516);
        }
      });
      paramMenuItem.a((q.g)new q.g()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          as localas2 = null;
          as localas1 = null;
          AppMethodBeat.i(283518);
          p.j(paramAnonymousMenuItem, "menuItem");
          paramAnonymousInt = paramAnonymousMenuItem.getItemId();
          if (paramAnonymousInt == ContactWidgetTabBizInfo.o(this.HgR.HgP))
          {
            ContactWidgetTabBizInfo.s(this.HgR.HgP);
            AppMethodBeat.o(283518);
            return;
          }
          if (paramAnonymousInt == ContactWidgetTabBizInfo.q(this.HgR.HgP))
          {
            ContactWidgetTabBizInfo.t(this.HgR.HgP);
            AppMethodBeat.o(283518);
            return;
          }
          if (paramAnonymousInt == ContactWidgetTabBizInfo.n(this.HgR.HgP))
          {
            paramAnonymousMenuItem = ContactWidgetTabBizInfo.d(this.HgR.HgP);
            if (paramAnonymousMenuItem != null)
            {
              paramAnonymousMenuItem = paramAnonymousMenuItem.getUsername();
              com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.c(paramAnonymousMenuItem, 903, ContactWidgetTabBizInfo.e(this.HgR.HgP), this.HgR.HgP.enterTime);
              paramAnonymousMenuItem = ContactWidgetTabBizInfo.d(this.HgR.HgP);
              if (paramAnonymousMenuItem == null) {
                break label254;
              }
            }
            label254:
            for (paramAnonymousMenuItem = paramAnonymousMenuItem.getUsername();; paramAnonymousMenuItem = null)
            {
              com.tencent.mm.model.j.Pd(paramAnonymousMenuItem);
              ContactWidgetTabBizInfo.u(this.HgR.HgP);
              localas2 = ContactWidgetTabBizInfo.d(this.HgR.HgP);
              paramAnonymousMenuItem = localas1;
              if (localas2 != null) {
                paramAnonymousMenuItem = localas2.getUsername();
              }
              if (!com.tencent.mm.ao.g.Ux(paramAnonymousMenuItem)) {
                break label516;
              }
              com.tencent.mm.ui.base.h.cL((Context)ContactWidgetTabBizInfo.h(this.HgR.HgP), ContactWidgetTabBizInfo.h(this.HgR.HgP).getString(R.l.eLn));
              AppMethodBeat.o(283518);
              return;
              paramAnonymousMenuItem = null;
              break;
            }
          }
          if (paramAnonymousInt == ContactWidgetTabBizInfo.m(this.HgR.HgP))
          {
            paramAnonymousMenuItem = ContactWidgetTabBizInfo.d(this.HgR.HgP);
            if (paramAnonymousMenuItem != null)
            {
              paramAnonymousMenuItem = paramAnonymousMenuItem.getUsername();
              ab.H(paramAnonymousMenuItem, true);
              paramAnonymousMenuItem = ContactWidgetTabBizInfo.d(this.HgR.HgP);
              if (paramAnonymousMenuItem == null) {
                break label429;
              }
            }
            label429:
            for (paramAnonymousMenuItem = paramAnonymousMenuItem.getUsername();; paramAnonymousMenuItem = null)
            {
              com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.c(paramAnonymousMenuItem, 904, ContactWidgetTabBizInfo.e(this.HgR.HgP), this.HgR.HgP.enterTime);
              ContactWidgetTabBizInfo.u(this.HgR.HgP);
              localas1 = ContactWidgetTabBizInfo.d(this.HgR.HgP);
              paramAnonymousMenuItem = localas2;
              if (localas1 != null) {
                paramAnonymousMenuItem = localas1.getUsername();
              }
              if (!com.tencent.mm.ao.g.Ux(paramAnonymousMenuItem)) {
                break label516;
              }
              com.tencent.mm.ui.base.h.cL((Context)ContactWidgetTabBizInfo.h(this.HgR.HgP), ContactWidgetTabBizInfo.h(this.HgR.HgP).getString(R.l.esU));
              AppMethodBeat.o(283518);
              return;
              paramAnonymousMenuItem = null;
              break;
            }
          }
          if (paramAnonymousInt == ContactWidgetTabBizInfo.p(this.HgR.HgP))
          {
            ContactWidgetTabBizInfo.v(this.HgR.HgP);
            AppMethodBeat.o(283518);
            return;
          }
          if (paramAnonymousInt == ContactWidgetTabBizInfo.r(this.HgR.HgP))
          {
            paramAnonymousMenuItem = ContactWidgetTabBizInfo.w(this.HgR.HgP);
            if (paramAnonymousMenuItem != null)
            {
              paramAnonymousMenuItem.frt();
              AppMethodBeat.o(283518);
              return;
            }
            AppMethodBeat.o(283518);
            return;
          }
          Log.w("MicroMsg.ContactWidgetTabBizInfo", "default onMMMenuItemSelected err");
          label516:
          AppMethodBeat.o(283518);
        }
      });
      paramMenuItem.eik();
      paramMenuItem = ContactWidgetTabBizInfo.d(this.HgP);
      if (paramMenuItem != null) {}
      for (paramMenuItem = paramMenuItem.getUsername();; paramMenuItem = null)
      {
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.c(paramMenuItem, 600, ContactWidgetTabBizInfo.e(this.HgP), this.HgP.enterTime);
        AppMethodBeat.o(291083);
        return false;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class q
    implements MenuItem.OnMenuItemClickListener
  {
    q(ContactWidgetTabBizInfo paramContactWidgetTabBizInfo) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(269128);
      paramMenuItem = ContactWidgetTabBizInfo.w(this.HgP);
      if (paramMenuItem != null) {
        paramMenuItem.fru();
      }
      AppMethodBeat.o(269128);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.ContactWidgetTabBizInfo
 * JD-Core Version:    0.7.0.1
 */