package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.al.ag;
import com.tencent.mm.api.c.a;
import com.tencent.mm.api.c.b;
import com.tencent.mm.g.a.dr;
import com.tencent.mm.g.a.dr.b;
import com.tencent.mm.g.a.dv;
import com.tencent.mm.g.a.dv.b;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.b;
import com.tencent.mm.model.ay.b.a;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.profile.ui.ContactInfoUI;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.a.b;
import com.tencent.mm.protocal.protobuf.acb;
import com.tencent.mm.protocal.protobuf.aeq;
import com.tencent.mm.protocal.protobuf.dey;
import com.tencent.mm.protocal.protobuf.eqb;
import com.tencent.mm.protocal.protobuf.mq;
import com.tencent.mm.protocal.protobuf.ng;
import com.tencent.mm.protocal.protobuf.nh;
import com.tencent.mm.protocal.protobuf.ni;
import com.tencent.mm.protocal.protobuf.np;
import com.tencent.mm.protocal.protobuf.ou;
import com.tencent.mm.protocal.protobuf.ov;
import com.tencent.mm.protocal.protobuf.pf;
import com.tencent.mm.protocal.protobuf.pg;
import com.tencent.mm.protocal.protobuf.ph;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.e.a;
import com.tencent.mm.ui.widget.a.e;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;
import kotlin.g.b.p;

public class ContactWidgetNewBizInfo
  implements LifecycleObserver, i, com.tencent.mm.pluginsdk.b.b
{
  private static final String Bff;
  private static String Bjc;
  private static boolean Bjd;
  private String BdC;
  com.tencent.mm.api.c Bdk;
  boolean Bdx;
  private List<WxaAttributes.WxaEntryInfo> BeW;
  private aeq BeX;
  private int Bfb;
  private Bundle Bfg;
  SnsAdClick Bfh;
  private String Bfi;
  ContactInfoUI BiT;
  private ph BiU;
  private com.tencent.mm.plugin.profile.ui.newbizinfo.b.c BiV;
  private boolean BiW;
  private boolean BiX;
  private int BiY;
  private boolean BiZ;
  private boolean Bja;
  private Parcelable Bjb;
  as contact;
  private String dhE;
  private List<c.a> dhu;
  private c.b dhv;
  private long endTime;
  long enterTime;
  private boolean isLoading;
  int kgm;
  private IListener lEl;
  private String pHz;
  private WeakReference<ContactWidgetNewBizInfo> peA;
  private IListener pti;
  private f screen;
  private com.tencent.mm.ui.base.q tipDialog;
  private String wZz;
  
  static
  {
    AppMethodBeat.i(231954);
    Bff = "https://" + WeChatHosts.domainString(2131761726) + "/mp/infringement?username=%s&from=1#wechat_redirect";
    Bjc = "crashFlag";
    Bjd = false;
    AppMethodBeat.o(231954);
  }
  
  public ContactWidgetNewBizInfo(final ContactInfoUI paramContactInfoUI, final String paramString, aeq paramaeq, long paramLong)
  {
    AppMethodBeat.i(231952);
    this.Bfb = 0;
    this.Bfh = null;
    this.Bfi = null;
    this.BiV = null;
    this.peA = null;
    this.pHz = "";
    this.BiW = false;
    this.BiX = false;
    this.lEl = new b(this);
    this.pti = new ContactWidgetNewBizInfo.a(this);
    this.BiY = 0;
    this.BiZ = true;
    this.isLoading = false;
    this.Bja = false;
    this.tipDialog = null;
    this.peA = new WeakReference(this);
    this.BiT = paramContactInfoUI;
    this.BdC = paramString;
    this.BeX = paramaeq;
    this.enterTime = paramLong;
    paramString = paramContactInfoUI.getListView();
    eEY();
    paramString.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(231936);
        if (ContactWidgetNewBizInfo.c(ContactWidgetNewBizInfo.this) != null)
        {
          paramAnonymousAbsListView = (NewBizInfoHeaderPreference)ContactWidgetNewBizInfo.c(ContactWidgetNewBizInfo.this).bmg("contact_info_header_newbizinfo");
          if (paramAnonymousAbsListView != null)
          {
            int[] arrayOfInt = new int[2];
            if (paramAnonymousAbsListView.Bju == null) {}
            for (paramAnonymousInt1 = 0; paramAnonymousInt1 < 0; paramAnonymousInt1 = arrayOfInt[1])
            {
              paramAnonymousInt2 = paramAnonymousAbsListView.Bjw.getMeasuredHeight();
              float f = (paramAnonymousInt1 + paramAnonymousInt2 - this.Bjf) / paramAnonymousInt2;
              paramContactInfoUI.setMMTitleColor(paramContactInfoUI.getResources().getColor(2131099746));
              paramContactInfoUI.setTitleAlpha(1.0F - f);
              AppMethodBeat.o(231936);
              return;
              paramAnonymousAbsListView.Bju.getLocationInWindow(arrayOfInt);
            }
            if (paramAnonymousInt1 == 0)
            {
              if (paramAnonymousAbsListView.Bju == null) {}
              for (boolean bool = false; !bool; bool = paramAnonymousAbsListView.Bju.isAttachedToWindow())
              {
                paramContactInfoUI.setMMTitleColor(paramContactInfoUI.getResources().getColor(2131099746));
                AppMethodBeat.o(231936);
                return;
              }
            }
            paramContactInfoUI.setMMTitleColor(0);
          }
        }
        AppMethodBeat.o(231936);
      }
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(231935);
        ArrayList localArrayList;
        if ((paramAnonymousInt == 0) && (ContactWidgetNewBizInfo.a(ContactWidgetNewBizInfo.this) != null))
        {
          paramAnonymousAbsListView = ContactWidgetNewBizInfo.a(ContactWidgetNewBizInfo.this);
          paramAnonymousInt = paramString.getFirstVisiblePosition();
          int i = paramString.getLastVisiblePosition();
          if (paramAnonymousAbsListView.eFj().CR(16))
          {
            int j = paramAnonymousAbsListView.eFi();
            int k = paramAnonymousAbsListView.Bkw;
            localArrayList = new ArrayList();
            if (paramAnonymousInt <= i) {
              for (;;)
              {
                if (paramAnonymousAbsListView.UY(paramAnonymousInt))
                {
                  int n = paramAnonymousInt + (j - k);
                  if (paramAnonymousAbsListView.Bku.UU(n) == a.b.Bkk)
                  {
                    Object localObject1 = paramAnonymousAbsListView.Bku.getItem(n);
                    if (localObject1 == null)
                    {
                      paramAnonymousAbsListView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizMessage");
                      AppMethodBeat.o(231935);
                      throw paramAnonymousAbsListView;
                    }
                    localObject1 = (ou)localObject1;
                    Object localObject2 = paramAnonymousAbsListView.BkB.contact;
                    p.g(localObject2, "widget.contact");
                    localObject2 = ((ax)localObject2).field_username;
                    long l = paramAnonymousAbsListView.BkB.enterTime;
                    int m = paramAnonymousAbsListView.BkB.kgm;
                    n /= 2;
                    if (((ou)localObject1).KVq.xKb == 49)
                    {
                      localObject3 = ((ou)localObject1).KVv.KSK;
                      p.g(localObject3, "bizMessage.AppMsg.DetailInfo");
                      Object localObject4 = (Iterable)localObject3;
                      localObject3 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject4, 10));
                      localObject4 = ((Iterable)localObject4).iterator();
                      Object localObject5;
                      while (((Iterator)localObject4).hasNext())
                      {
                        localObject5 = (nh)((Iterator)localObject4).next();
                        ((Collection)localObject3).add(kotlin.a.j.listOf(new String[] { ((nh)localObject5).KSj, String.valueOf(((nh)localObject5).iAb) }));
                      }
                      localArrayList.addAll((Collection)localObject3);
                      localObject3 = ((ou)localObject1).KVv.KSK;
                      p.g(localObject3, "bizMessage.AppMsg.DetailInfo");
                      localObject3 = ((Iterable)localObject3).iterator();
                      while (((Iterator)localObject3).hasNext())
                      {
                        localObject4 = (nh)((Iterator)localObject3).next();
                        localObject5 = com.tencent.mm.plugin.profile.ui.newbizinfo.c.d.BlR;
                        p.g(localObject2, "userName");
                        com.tencent.mm.plugin.profile.ui.newbizinfo.c.d.a((String)localObject2, l, ((ou)localObject1).KVv.KSJ.KSf, ((nh)localObject4).KSi, ((nh)localObject4).iAb, n, ((ou)localObject1).KVv.KSJ.CreateTime, m);
                      }
                    }
                    Object localObject3 = com.tencent.mm.plugin.profile.ui.newbizinfo.c.d.BlR;
                    p.g(localObject2, "userName");
                    com.tencent.mm.plugin.profile.ui.newbizinfo.c.d.a((String)localObject2, l, ((ou)localObject1).KVq.Brl, 0, -1, n, ((ou)localObject1).KVq.LmE, m);
                  }
                }
                if (paramAnonymousInt == i) {
                  break;
                }
                paramAnonymousInt += 1;
              }
            }
            if (((Collection)localArrayList).isEmpty()) {
              break label545;
            }
          }
        }
        label545:
        for (paramAnonymousInt = 1;; paramAnonymousInt = 0)
        {
          if (paramAnonymousInt != 0) {
            paramAnonymousAbsListView.eFj().j((List)localArrayList, 126);
          }
          AppMethodBeat.o(231935);
          return;
        }
      }
    });
    AppMethodBeat.o(231952);
  }
  
  private void a(ph paramph)
  {
    AppMethodBeat.i(169758);
    if (paramph == null)
    {
      AppMethodBeat.o(169758);
      return;
    }
    int i;
    if (paramph.KWm != null)
    {
      com.tencent.mm.plugin.brandservice.b.c.E(paramph.KWm.LYA, true);
      boolean bool = paramph.KWm.LYA;
      if (paramph.KWm.MJY != null)
      {
        i = paramph.KWm.MJY.size();
        Log.i("MicroMsg.ContactWidgetNewBizInfo", "alvinluo updateProfileInfo %b, size: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
      }
    }
    for (;;)
    {
      if (paramph.KWg != null)
      {
        eEY();
        if (this.BiV != null)
        {
          com.tencent.mm.plugin.profile.ui.newbizinfo.b.c localc = this.BiV;
          ov localov = paramph.KWg;
          dey localdey = paramph.KWm;
          p.h(localov, "msgList");
          localc.Bku.b(localov);
          localc.Bku.a(localdey);
          localc.BkC.notifyDataSetChanged();
        }
      }
      if ((!this.BiW) && (paramph.KWm != null) && (paramph.KWm.MJY != null) && (paramph.KWm.MJY.size() > 0) && (com.tencent.mm.plugin.brandservice.b.c.clv()))
      {
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.c(this.contact.field_username, 1401, this.kgm, this.enterTime);
        this.BiW = true;
      }
      AppMethodBeat.o(169758);
      return;
      i = -1;
      break;
      Log.e("MicroMsg.ContactWidgetNewBizInfo", "alvinluo updateProfileInfo videochannel_notify_info is null");
    }
  }
  
  private static int aKw(String paramString)
  {
    int j = 10000;
    AppMethodBeat.i(27460);
    int i = j;
    if (!Util.isNullOrNil(paramString)) {}
    try
    {
      i = Util.getInt(Uri.parse(paramString).getQueryParameter("scene"), 10000);
      AppMethodBeat.o(27460);
      return i;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        i = j;
      }
    }
  }
  
  /* Error */
  private void ab(as paramas)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 363
    //   5: invokestatic 100	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: ifnull +9 -> 18
    //   12: getstatic 133	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo:Bjd	Z
    //   15: ifeq +12 -> 27
    //   18: ldc_w 363
    //   21: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: iconst_1
    //   28: putstatic 133	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo:Bjd	Z
    //   31: ldc_w 365
    //   34: invokestatic 371	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getSingleMMKV	(Ljava/lang/String;)Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   37: astore_2
    //   38: aload_2
    //   39: getstatic 131	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo:Bjc	Ljava/lang/String;
    //   42: iconst_0
    //   43: invokevirtual 375	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:decodeBool	(Ljava/lang/String;Z)Z
    //   46: ifeq +31 -> 77
    //   49: ldc_w 256
    //   52: ldc_w 377
    //   55: invokestatic 379	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   58: getstatic 385	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
    //   61: ldc2_w 386
    //   64: lconst_0
    //   65: lconst_1
    //   66: iconst_0
    //   67: invokevirtual 391	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   70: aload_1
    //   71: getfield 320	com/tencent/mm/g/c/ax:field_username	Ljava/lang/String;
    //   74: invokestatic 396	com/tencent/mm/plugin/profile/ui/newbizinfo/a:clear	(Ljava/lang/String;)V
    //   77: aload_2
    //   78: getstatic 131	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo:Bjc	Ljava/lang/String;
    //   81: iconst_1
    //   82: invokevirtual 399	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:encode	(Ljava/lang/String;Z)Z
    //   85: pop
    //   86: ldc_w 256
    //   89: ldc_w 401
    //   92: invokestatic 379	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   95: getstatic 406	com/tencent/mm/sdk/platformtools/BuildInfo:DEBUG	Z
    //   98: ifne +15 -> 113
    //   101: getstatic 409	com/tencent/mm/sdk/platformtools/BuildInfo:IS_FLAVOR_RED	Z
    //   104: ifne +9 -> 113
    //   107: invokestatic 414	com/tencent/mm/sdk/platformtools/WeChatEnvironment:hasDebugger	()Z
    //   110: ifeq +22 -> 132
    //   113: aload_2
    //   114: ldc_w 416
    //   117: iconst_0
    //   118: invokevirtual 419	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:decodeInt	(Ljava/lang/String;I)I
    //   121: iconst_1
    //   122: if_icmpne +10 -> 132
    //   125: ldc_w 421
    //   128: iconst_0
    //   129: invokestatic 427	junit/framework/Assert:assertTrue	(Ljava/lang/String;Z)V
    //   132: getstatic 433	com/tencent/f/h:RTc	Lcom/tencent/f/i;
    //   135: new 14	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo$2
    //   138: dup
    //   139: aload_0
    //   140: aload_2
    //   141: invokespecial 436	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo$2:<init>	(Lcom/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo;Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;)V
    //   144: ldc2_w 437
    //   147: invokeinterface 443 4 0
    //   152: pop
    //   153: ldc_w 363
    //   156: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   159: goto -135 -> 24
    //   162: astore_1
    //   163: aload_0
    //   164: monitorexit
    //   165: aload_1
    //   166: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	167	0	this	ContactWidgetNewBizInfo
    //   0	167	1	paramas	as
    //   37	104	2	localMultiProcessMMKV	MultiProcessMMKV
    // Exception table:
    //   from	to	target	type
    //   2	8	162	finally
    //   12	18	162	finally
    //   18	24	162	finally
    //   27	77	162	finally
    //   77	113	162	finally
    //   113	132	162	finally
    //   132	159	162	finally
  }
  
  private void b(String paramString, final com.tencent.mm.bw.b paramb)
  {
    AppMethodBeat.i(27450);
    if (this.isLoading)
    {
      Log.i("MicroMsg.ContactWidgetNewBizInfo", "not obtailBizInfoFromCgi, use cache");
      AppMethodBeat.o(27450);
      return;
    }
    this.isLoading = true;
    Object localObject = new d.a();
    ((d.a)localObject).funcId = 2656;
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/bizattr/bizprofilev2";
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    pg localpg = new pg();
    localpg.KSV = paramString;
    if (paramb != null)
    {
      localpg.KWb = 1;
      localpg.KVZ = paramb;
      localpg.KWc = 20;
      localpg.Scene = this.kgm;
      localpg.KWd = com.tencent.mm.storage.ab.getSessionId();
      ((d.a)localObject).iLN = localpg;
      ((d.a)localObject).iLO = new ph();
      localObject = ((d.a)localObject).aXF();
      paramb = new aa.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.d paramAnonymousd, com.tencent.mm.ak.q paramAnonymousq)
        {
          AppMethodBeat.i(231944);
          Log.i("MicroMsg.ContactWidgetNewBizInfo", "callback, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          paramAnonymousString = (ph)paramAnonymousd.iLL.iLR;
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousString != null))
          {
            paramAnonymousd = a.BjZ;
            a.a(paramAnonymousString.KWg);
            if (paramb == null) {
              break label386;
            }
            if ((!paramb.equals(ContactWidgetNewBizInfo.l(ContactWidgetNewBizInfo.this).KWg.KVx.KVZ)) || (paramAnonymousString.KWg == null)) {
              break label376;
            }
            ContactWidgetNewBizInfo.l(ContactWidgetNewBizInfo.this).KWg.KVw.addAll(paramAnonymousString.KWg.KVw);
            ContactWidgetNewBizInfo.l(ContactWidgetNewBizInfo.this).KWg.KVx = paramAnonymousString.KWg.KVx;
            if (paramb == null) {
              break label422;
            }
            if ((ContactWidgetNewBizInfo.l(ContactWidgetNewBizInfo.this) != null) && (ContactWidgetNewBizInfo.l(ContactWidgetNewBizInfo.this).KWg != null))
            {
              ContactWidgetNewBizInfo.a(ContactWidgetNewBizInfo.this, ContactWidgetNewBizInfo.l(ContactWidgetNewBizInfo.this));
              com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.c(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username, 106, ContactWidgetNewBizInfo.h(ContactWidgetNewBizInfo.this), ContactWidgetNewBizInfo.i(ContactWidgetNewBizInfo.this));
            }
            label227:
            if ((paramAnonymousString.KTf & 0x4) == 0) {
              break label449;
            }
            paramAnonymousd = ContactWidgetNewBizInfo.d(4, paramAnonymousString.KWk);
            if (paramAnonymousd == null) {
              break label449;
            }
            paramAnonymousq = (NewBizInfoErrMsgPreference)ContactWidgetNewBizInfo.c(ContactWidgetNewBizInfo.this).bmg("contact_info_biz_err_msg");
            ContactWidgetNewBizInfo.c(ContactWidgetNewBizInfo.this).jdMethod_do("contact_info_biz_err_msg", false);
            paramAnonymousq.setErrMsg(paramAnonymousd);
          }
          for (;;)
          {
            for (;;)
            {
              if ((paramAnonymousString.KTf & 0x2) != 0)
              {
                paramAnonymousString = (NewBizInfoHeaderPreference)ContactWidgetNewBizInfo.c(ContactWidgetNewBizInfo.this).bmg("contact_info_header_newbizinfo");
                paramAnonymousString.Bjy = true;
                if (paramAnonymousString.gyr != null)
                {
                  com.tencent.mm.plugin.brandservice.b.d.a(paramAnonymousString.gyr, paramAnonymousString.contact, "", true);
                  paramAnonymousString.gyr.setClickable(false);
                }
              }
              ContactWidgetNewBizInfo.o(ContactWidgetNewBizInfo.this);
              ContactWidgetNewBizInfo.p(ContactWidgetNewBizInfo.this);
              AppMethodBeat.o(231944);
              return 0;
              label376:
              Log.e("MicroMsg.ContactWidgetNewBizInfo", "drop err resp");
              break;
              try
              {
                label386:
                ContactWidgetNewBizInfo.l(ContactWidgetNewBizInfo.this).parseFrom(paramAnonymousString.toByteArray());
              }
              catch (IOException paramAnonymousd)
              {
                Log.printErrStackTrace("MicroMsg.ContactWidgetNewBizInfo", paramAnonymousd, "profileInfo.parseFrom", new Object[0]);
              }
            }
            break;
            label422:
            a.b(ContactWidgetNewBizInfo.l(ContactWidgetNewBizInfo.this));
            ContactWidgetNewBizInfo.m(ContactWidgetNewBizInfo.this);
            ContactWidgetNewBizInfo.n(ContactWidgetNewBizInfo.this);
            break label227;
            label449:
            if ((paramAnonymousString.KTf & 0x8) != 0)
            {
              paramAnonymousd = ContactWidgetNewBizInfo.d(8, paramAnonymousString.KWk);
              if (paramAnonymousd != null)
              {
                paramAnonymousq = (NewBizInfoErrMsgPreference)ContactWidgetNewBizInfo.c(ContactWidgetNewBizInfo.this).bmg("contact_info_biz_err_msg");
                ContactWidgetNewBizInfo.c(ContactWidgetNewBizInfo.this).jdMethod_do("contact_info_biz_err_msg", false);
                paramAnonymousq.setErrMsg(paramAnonymousd);
                continue;
              }
            }
            ContactWidgetNewBizInfo.c(ContactWidgetNewBizInfo.this).jdMethod_do("contact_info_biz_err_msg", true);
          }
        }
      };
      if (!(this.BiT instanceof com.tencent.mm.vending.e.b)) {
        break label198;
      }
    }
    label198:
    for (paramString = this.BiT;; paramString = null)
    {
      aa.a((com.tencent.mm.ak.d)localObject, paramb, false, paramString);
      AppMethodBeat.o(27450);
      return;
      localpg.KWb = 0;
      localpg.KWc = 5;
      break;
    }
  }
  
  private boolean csM()
  {
    AppMethodBeat.i(27452);
    if ((this.BiU != null) && (this.BiU.KWe != null) && (this.BiU.KWe.KQU == 0) && (!eFb()))
    {
      AppMethodBeat.o(27452);
      return true;
    }
    AppMethodBeat.o(27452);
    return false;
  }
  
  private void eEY()
  {
    AppMethodBeat.i(27446);
    if (this.BiV != null)
    {
      AppMethodBeat.o(27446);
      return;
    }
    com.tencent.mm.ui.base.preference.h localh = (com.tencent.mm.ui.base.preference.h)this.BiT.getListView().getAdapter();
    if (localh == null)
    {
      Log.e("MicroMsg.ContactWidgetNewBizInfo", "empty adapter");
      AppMethodBeat.o(27446);
      return;
    }
    this.BiV = new com.tencent.mm.plugin.profile.ui.newbizinfo.b.c(this.BiT, this, localh, new String[] { "contact_info_biz_err_msg", "contact_info_footer_space" });
    localh.OYY = this.BiV;
    AppMethodBeat.o(27446);
  }
  
  private void eEZ()
  {
    AppMethodBeat.i(27448);
    com.tencent.mm.api.c localc2 = com.tencent.mm.al.g.fJ(this.contact.field_username);
    this.dhu = null;
    this.dhv = null;
    this.BeW = null;
    com.tencent.mm.api.c localc1;
    if (localc2 != null)
    {
      localc1 = localc2;
      if (localc2.cG(false) != null) {}
    }
    else
    {
      localc1 = localc2;
      if (this.BeX != null)
      {
        localc1 = new com.tencent.mm.api.c();
        localc1.field_username = this.contact.field_username;
        localc1.field_brandFlag = this.BeX.kem;
        localc1.field_brandIconURL = this.BeX.kep;
        localc1.field_brandInfo = this.BeX.keo;
        localc1.field_extInfo = this.BeX.ken;
        localc1.field_type = localc1.cG(false).getServiceType();
      }
    }
    if ((localc1 != null) && (localc1.field_brandInfo == null) && (localc1.field_extInfo == null) && (this.BeX != null))
    {
      localc1.field_username = this.contact.field_username;
      localc1.field_brandFlag = this.BeX.kem;
      localc1.field_brandIconURL = this.BeX.kep;
      localc1.field_brandInfo = this.BeX.keo;
      localc1.field_extInfo = this.BeX.ken;
      localc1.field_type = localc1.cG(false).getServiceType();
    }
    if (localc1 != null)
    {
      this.Bdk = localc1;
      this.dhu = localc1.UO();
      this.dhv = localc1.cG(false);
      this.BeW = this.dhv.getWxaEntryInfoList();
      if ((this.dhv.US() != null) && (this.dhv.US().length() > 0)) {
        this.dhE = this.dhv.US();
      }
    }
    AppMethodBeat.o(27448);
  }
  
  private void eEp()
  {
    AppMethodBeat.i(27451);
    cCs();
    eEZ();
    this.screen.removeAll();
    this.screen.addPreferencesFromResource(2132017185);
    Object localObject = (NewBizInfoHeaderPreference)this.screen.bmg("contact_info_header_newbizinfo");
    if ((localObject != null) && (!Util.isNullOrNil(this.contact.field_username)))
    {
      ((NewBizInfoHeaderPreference)localObject).a(this.contact, this.BdC, this.Bdk, this.BiU);
      this.Bja = true;
      if (this.BiU == null) {
        break label603;
      }
      if (!com.tencent.mm.contact.c.oR(this.contact.field_type)) {
        break label572;
      }
      this.screen.jdMethod_do("contact_info_biz_add", true);
      this.screen.jdMethod_do("contact_info_biz_go_chatting", false);
      ((NewBizInfoFollowPreference)this.screen.bmg("contact_info_biz_go_chatting")).Bdv = this;
      label161:
      if ((this.BiU != null) && (this.BiU.KWe != null) && (this.BiU.KWg != null) && (this.BiU.KWg.KVx != null)) {
        a(this.BiU);
      }
      if ((this.BiU != null) && (!csM()) && (!com.tencent.mm.contact.c.oR(this.contact.field_type))) {
        this.BiT.showOptionMenu(false);
      }
      if ((this.BiU == null) || (this.BiU.KWj == null)) {
        break label648;
      }
      this.screen.jdMethod_do("contact_info_biz_menu_newbizinfo", false);
      if (this.BiU != null) {
        ((NewBizInfoMenuPreference)this.screen.bmg("contact_info_biz_menu_newbizinfo")).a(this.BiU.KWj, this.contact, this.kgm, this.enterTime);
      }
    }
    for (;;)
    {
      this.screen.jdMethod_do("contact_info_biz_err_msg", true);
      Log.d("MicroMsg.ContactWidgetNewBizInfo", "KIsardDevice(%b)", new Object[] { Boolean.valueOf(this.BiT.getIntent().getBooleanExtra("KIsHardDevice", false)) });
      if ((this.BiT.getIntent() == null) || (!this.BiT.getIntent().getBooleanExtra("KIsHardDevice", false))) {
        break label686;
      }
      Log.d("MicroMsg.ContactWidgetNewBizInfo", "Hard device biz...");
      boolean bool = eEs();
      Log.d("MicroMsg.ContactWidgetNewBizInfo", "contact.isContact()(%b), isHarDeviceBound(%b)", new Object[] { Boolean.valueOf(com.tencent.mm.contact.c.oR(this.contact.field_type)), Boolean.valueOf(bool) });
      if ((com.tencent.mm.contact.c.oR(this.contact.field_type)) && (bool)) {
        break label679;
      }
      Log.w("MicroMsg.ContactWidgetNewBizInfo", "%s is not my hard biz contact", new Object[] { this.contact.field_username });
      eEq();
      localObject = (NewBizInfoNotFollowPreference)this.screen.bmg("contact_info_biz_add");
      this.screen.jdMethod_do("contact_info_biz_add", false);
      if (localObject == null) {
        break label679;
      }
      if (!bool) {
        break label665;
      }
      ((NewBizInfoNotFollowPreference)localObject).setTitle(this.BiT.getString(2131757838));
      AppMethodBeat.o(27451);
      return;
      Log.w("MicroMsg.ContactWidgetNewBizInfo", "head pref is null");
      this.screen.jdMethod_do("contact_info_header_bizinfo", true);
      break;
      label572:
      this.screen.jdMethod_do("contact_info_biz_add", false);
      this.screen.jdMethod_do("contact_info_biz_go_chatting", true);
      break label161;
      label603:
      this.screen.jdMethod_do("contact_info_biz_add", true);
      this.screen.jdMethod_do("contact_info_biz_go_chatting", true);
      this.screen.jdMethod_do("contact_info_biz_space", false);
      break label161;
      label648:
      this.screen.jdMethod_do("contact_info_biz_menu_newbizinfo", true);
    }
    label665:
    ((NewBizInfoNotFollowPreference)localObject).setTitle(this.BiT.getString(2131757823));
    label679:
    AppMethodBeat.o(27451);
    return;
    label686:
    if (eFb())
    {
      this.screen.jdMethod_do("contact_info_biz_loading", false);
      this.screen.jdMethod_do("contact_info_biz_add", true);
      this.screen.jdMethod_do("contact_info_biz_go_chatting", true);
      this.screen.jdMethod_do("contact_info_message_newbizinfo", true);
    }
    AppMethodBeat.o(27451);
  }
  
  private void eEq()
  {
    AppMethodBeat.i(27454);
    if ((this.contact != null) && ((com.tencent.mm.model.ab.JA(this.contact.field_username)) || (com.tencent.mm.model.ab.JM(this.contact.field_username))) && (com.tencent.mm.contact.c.oR(this.contact.field_type)))
    {
      this.screen.jdMethod_do("contact_info_biz_go_chatting", false);
      AppMethodBeat.o(27454);
      return;
    }
    this.screen.jdMethod_do("contact_info_biz_go_chatting", true);
    AppMethodBeat.o(27454);
  }
  
  private void eEr()
  {
    AppMethodBeat.i(27458);
    if ((NewBizInfoHeaderPreference)this.screen.bmg("contact_info_header_newbizinfo") != null) {
      NewBizInfoHeaderPreference.HN(System.currentTimeMillis());
    }
    if ((this.BiT.getIntent() != null) && (this.BiT.getIntent().getBooleanExtra("KIsHardDevice", false)))
    {
      localObject1 = this.BiT.getIntent().getStringExtra("KHardDeviceBindTicket");
      if (!Util.isNullOrNil((String)localObject1)) {
        break label335;
      }
      Log.i("MicroMsg.ContactWidgetNewBizInfo", "bindTicket is null, means it is not switch from QRcode scan, just add contact");
    }
    label335:
    while (eEs())
    {
      localObject1 = new com.tencent.mm.pluginsdk.ui.applet.a(this.BiT, new ContactWidgetNewBizInfo.10(this));
      localObject2 = new LinkedList();
      ((LinkedList)localObject2).add(Integer.valueOf(this.kgm));
      if (this.dhE != null) {
        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).wHV = this.dhE;
      }
      if (!Util.isNullOrNil(this.wZz)) {
        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).wZz = this.wZz;
      }
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).Keg = true;
      String str = this.BiT.getIntent().getStringExtra("url");
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).Keh = str;
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).pHw = e.a.akL(this.BiT.getIntent().getIntExtra("qbarScene", -1));
      eqb localeqb = new eqb();
      localeqb.KJS = this.BiT.getIntent().getIntExtra("Contact_Sub_Scene", 0);
      localeqb.Lru = this.BiT.getIntent().getStringExtra("Contact_Scene_Note");
      if (!Util.isNullOrNil(str))
      {
        if (Util.isNullOrNil(localeqb.Lru)) {
          localeqb.Lru = str;
        }
        if (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).ahv(str)) {
          localeqb.NnE = aKw(str);
        }
      }
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).Kei = localeqb;
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).a(this.contact.field_username, (LinkedList)localObject2, this.Bfi);
      eFc();
      AppMethodBeat.o(27458);
      return;
    }
    Log.d("MicroMsg.ContactWidgetNewBizInfo", "IsHardDevice, bindTicket = %s", new Object[] { localObject1 });
    bg.azz().a(536, this);
    Object localObject2 = new dr();
    ((dr)localObject2).dGF.dGH = ((String)localObject1);
    ((dr)localObject2).dGF.opType = 1;
    EventCenter.instance.publish((IEvent)localObject2);
    Object localObject1 = ((dr)localObject2).dGG.dGJ;
    localObject2 = this.BiT;
    this.BiT.getString(2131755998);
    this.tipDialog = com.tencent.mm.ui.base.h.a((Context)localObject2, this.BiT.getString(2131756029), true, new ContactWidgetNewBizInfo.9(this, (com.tencent.mm.ak.q)localObject1));
    AppMethodBeat.o(27458);
  }
  
  private boolean eEs()
  {
    AppMethodBeat.i(27462);
    if (this.BiT.getIntent() == null)
    {
      AppMethodBeat.o(27462);
      return false;
    }
    String str1 = this.BiT.getIntent().getStringExtra("device_id");
    String str2 = this.BiT.getIntent().getStringExtra("device_type");
    dv localdv = new dv();
    localdv.dGR.dGL = str1;
    localdv.dGR.dGP = str2;
    EventCenter.instance.publish(localdv);
    boolean bool = localdv.dGS.dGT;
    AppMethodBeat.o(27462);
    return bool;
  }
  
  private boolean eFb()
  {
    boolean bool1 = true;
    AppMethodBeat.i(27453);
    try
    {
      String str = this.dhv.UV();
      boolean bool2 = Util.isNullOrNil(str);
      if (bool2)
      {
        AppMethodBeat.o(27453);
        return false;
      }
      long l = Util.getLong(str, 0L);
      if ((l > 0L) && (l - System.currentTimeMillis() / 1000L < 0L)) {}
      for (;;)
      {
        Log.d("MicroMsg.ContactWidgetNewBizInfo", "isBizAccountTimeExpired:%b", new Object[] { Boolean.valueOf(bool1) });
        AppMethodBeat.o(27453);
        return bool1;
        bool1 = false;
      }
      return false;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(27453);
    }
  }
  
  /* Error */
  private void eFc()
  {
    // Byte code:
    //   0: sipush 27459
    //   3: invokestatic 100	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 184	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo:BiT	Lcom/tencent/mm/plugin/profile/ui/ContactInfoUI;
    //   10: invokevirtual 804	com/tencent/mm/plugin/profile/ui/ContactInfoUI:getIntent	()Landroid/content/Intent;
    //   13: astore 13
    //   15: aload 13
    //   17: ldc_w 1057
    //   20: iconst_0
    //   21: invokevirtual 908	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   24: invokestatic 1062	com/tencent/mm/plugin/profile/ui/newbizinfo/b/g:Vb	(I)I
    //   27: istore_1
    //   28: aload 13
    //   30: ldc_w 1064
    //   33: invokevirtual 874	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   36: astore 14
    //   38: aload 13
    //   40: ldc_w 1066
    //   43: invokevirtual 874	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   46: astore 15
    //   48: aload 13
    //   50: ldc_w 1068
    //   53: iconst_0
    //   54: invokevirtual 908	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   57: aload 14
    //   59: invokestatic 1072	com/tencent/mm/plugin/profile/ui/newbizinfo/b/g:bQ	(ILjava/lang/String;)I
    //   62: istore_2
    //   63: aload 13
    //   65: ldc_w 594
    //   68: invokevirtual 874	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   71: astore 8
    //   73: aload 13
    //   75: ldc_w 900
    //   78: invokevirtual 874	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   81: astore 12
    //   83: aload 13
    //   85: ldc_w 1074
    //   88: invokevirtual 1078	android/content/Intent:getBundleExtra	(Ljava/lang/String;)Landroid/os/Bundle;
    //   91: astore 10
    //   93: ldc 153
    //   95: astore 9
    //   97: aload 10
    //   99: ifnull +15 -> 114
    //   102: aload 10
    //   104: ldc_w 1080
    //   107: ldc 153
    //   109: invokevirtual 1085	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   112: astore 9
    //   114: aload 13
    //   116: ldc_w 905
    //   119: iconst_m1
    //   120: invokevirtual 908	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   123: invokestatic 914	com/tencent/mm/ui/e$a:akL	(I)I
    //   126: istore_3
    //   127: aload_0
    //   128: getfield 315	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo:contact	Lcom/tencent/mm/storage/as;
    //   131: getfield 320	com/tencent/mm/g/c/ax:field_username	Ljava/lang/String;
    //   134: astore 16
    //   136: aload 9
    //   138: invokestatic 344	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   141: ifne +430 -> 571
    //   144: aload 9
    //   146: invokestatic 1088	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   149: ldc_w 1090
    //   152: invokestatic 1094	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   155: astore 9
    //   157: aload 8
    //   159: astore 10
    //   161: aload 8
    //   163: invokestatic 1088	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   166: ldc_w 1090
    //   169: invokestatic 1094	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   172: astore 8
    //   174: aload 8
    //   176: astore 10
    //   178: aload 12
    //   180: invokestatic 1088	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   183: ldc_w 1090
    //   186: invokestatic 1094	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   189: astore 11
    //   191: aload 11
    //   193: astore 10
    //   195: getstatic 385	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
    //   198: sipush 16232
    //   201: bipush 9
    //   203: anewarray 4	java/lang/Object
    //   206: dup
    //   207: iconst_0
    //   208: iload_1
    //   209: invokestatic 269	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   212: aastore
    //   213: dup
    //   214: iconst_1
    //   215: iload_2
    //   216: invokestatic 269	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   219: aastore
    //   220: dup
    //   221: iconst_2
    //   222: aload 14
    //   224: aastore
    //   225: dup
    //   226: iconst_3
    //   227: aload 15
    //   229: aastore
    //   230: dup
    //   231: iconst_4
    //   232: aload 8
    //   234: aastore
    //   235: dup
    //   236: iconst_5
    //   237: aload 10
    //   239: aastore
    //   240: dup
    //   241: bipush 6
    //   243: aload 9
    //   245: aastore
    //   246: dup
    //   247: bipush 7
    //   249: iload_3
    //   250: invokestatic 269	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   253: aastore
    //   254: dup
    //   255: bipush 8
    //   257: aload 16
    //   259: aastore
    //   260: invokevirtual 1097	com/tencent/mm/plugin/report/service/h:a	(I[Ljava/lang/Object;)V
    //   263: aload_0
    //   264: getfield 147	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo:Bfi	Ljava/lang/String;
    //   267: invokestatic 344	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   270: ifne +16 -> 286
    //   273: getstatic 385	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
    //   276: sipush 16697
    //   279: aload_0
    //   280: getfield 147	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo:Bfi	Ljava/lang/String;
    //   283: invokevirtual 1101	com/tencent/mm/plugin/report/service/h:kvStat	(ILjava/lang/String;)V
    //   286: aload 13
    //   288: ldc_w 1057
    //   291: iconst_0
    //   292: invokevirtual 908	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   295: istore_1
    //   296: invokestatic 865	java/lang/System:currentTimeMillis	()J
    //   299: ldc2_w 437
    //   302: ldiv
    //   303: l2i
    //   304: i2l
    //   305: lstore 4
    //   307: iload_1
    //   308: sipush 160
    //   311: if_icmpne +148 -> 459
    //   314: aload 13
    //   316: ldc_w 1103
    //   319: lconst_0
    //   320: invokevirtual 1106	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   323: lstore 6
    //   325: getstatic 385	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
    //   328: sipush 15721
    //   331: bipush 9
    //   333: anewarray 4	java/lang/Object
    //   336: dup
    //   337: iconst_0
    //   338: aload_0
    //   339: getfield 315	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo:contact	Lcom/tencent/mm/storage/as;
    //   342: getfield 320	com/tencent/mm/g/c/ax:field_username	Ljava/lang/String;
    //   345: aastore
    //   346: dup
    //   347: iconst_1
    //   348: iconst_0
    //   349: invokestatic 269	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   352: aastore
    //   353: dup
    //   354: iconst_2
    //   355: bipush 14
    //   357: invokestatic 269	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   360: aastore
    //   361: dup
    //   362: iconst_3
    //   363: lload 4
    //   365: invokestatic 1111	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   368: aastore
    //   369: dup
    //   370: iconst_4
    //   371: invokestatic 488	com/tencent/mm/storage/ab:getSessionId	()I
    //   374: invokestatic 269	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   377: aastore
    //   378: dup
    //   379: iconst_5
    //   380: iconst_0
    //   381: invokestatic 269	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   384: aastore
    //   385: dup
    //   386: bipush 6
    //   388: lload 6
    //   390: invokestatic 1111	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   393: aastore
    //   394: dup
    //   395: bipush 7
    //   397: ldc 153
    //   399: aastore
    //   400: dup
    //   401: bipush 8
    //   403: iconst_1
    //   404: invokestatic 269	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   407: aastore
    //   408: invokevirtual 1097	com/tencent/mm/plugin/report/service/h:a	(I[Ljava/lang/Object;)V
    //   411: getstatic 385	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
    //   414: ldc2_w 1112
    //   417: ldc2_w 1114
    //   420: lconst_1
    //   421: iconst_0
    //   422: invokevirtual 391	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   425: sipush 27459
    //   428: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   431: return
    //   432: astore 10
    //   434: ldc 153
    //   436: astore 9
    //   438: ldc_w 256
    //   441: aload 10
    //   443: ldc 153
    //   445: iconst_0
    //   446: anewarray 4	java/lang/Object
    //   449: invokestatic 1119	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   452: aload 12
    //   454: astore 10
    //   456: goto -261 -> 195
    //   459: iload_1
    //   460: sipush 174
    //   463: if_icmpne +88 -> 551
    //   466: getstatic 385	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
    //   469: sipush 15721
    //   472: bipush 9
    //   474: anewarray 4	java/lang/Object
    //   477: dup
    //   478: iconst_0
    //   479: aload_0
    //   480: getfield 315	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo:contact	Lcom/tencent/mm/storage/as;
    //   483: getfield 320	com/tencent/mm/g/c/ax:field_username	Ljava/lang/String;
    //   486: aastore
    //   487: dup
    //   488: iconst_1
    //   489: iconst_0
    //   490: invokestatic 269	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   493: aastore
    //   494: dup
    //   495: iconst_2
    //   496: bipush 21
    //   498: invokestatic 269	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   501: aastore
    //   502: dup
    //   503: iconst_3
    //   504: lload 4
    //   506: invokestatic 1111	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   509: aastore
    //   510: dup
    //   511: iconst_4
    //   512: invokestatic 488	com/tencent/mm/storage/ab:getSessionId	()I
    //   515: invokestatic 269	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   518: aastore
    //   519: dup
    //   520: iconst_5
    //   521: iconst_0
    //   522: invokestatic 269	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   525: aastore
    //   526: dup
    //   527: bipush 6
    //   529: iconst_0
    //   530: invokestatic 269	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   533: aastore
    //   534: dup
    //   535: bipush 7
    //   537: ldc 153
    //   539: aastore
    //   540: dup
    //   541: bipush 8
    //   543: iconst_3
    //   544: invokestatic 269	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   547: aastore
    //   548: invokevirtual 1097	com/tencent/mm/plugin/report/service/h:a	(I[Ljava/lang/Object;)V
    //   551: sipush 27459
    //   554: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   557: return
    //   558: astore 11
    //   560: aload 10
    //   562: astore 8
    //   564: aload 11
    //   566: astore 10
    //   568: goto -130 -> 438
    //   571: ldc 153
    //   573: astore 9
    //   575: aload 12
    //   577: astore 10
    //   579: goto -384 -> 195
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	582	0	this	ContactWidgetNewBizInfo
    //   27	437	1	i	int
    //   62	154	2	j	int
    //   126	124	3	k	int
    //   305	200	4	l1	long
    //   323	66	6	l2	long
    //   71	492	8	localObject1	Object
    //   95	479	9	str1	String
    //   91	147	10	localObject2	Object
    //   432	10	10	localUnsupportedEncodingException1	java.io.UnsupportedEncodingException
    //   454	124	10	localObject3	Object
    //   189	3	11	str2	String
    //   558	7	11	localUnsupportedEncodingException2	java.io.UnsupportedEncodingException
    //   81	495	12	str3	String
    //   13	302	13	localIntent	Intent
    //   36	187	14	str4	String
    //   46	182	15	str5	String
    //   134	124	16	str6	String
    // Exception table:
    //   from	to	target	type
    //   144	157	432	java/io/UnsupportedEncodingException
    //   161	174	558	java/io/UnsupportedEncodingException
    //   178	191	558	java/io/UnsupportedEncodingException
  }
  
  private void initActionBar()
  {
    AppMethodBeat.i(27445);
    this.BiT.setMMTitle(Util.nullAsNil(this.contact.field_nickname));
    this.BiT.setMMTitleColor(0);
    this.BiT.setTitleDividerVis(false);
    this.BiT.setIsDarkActionbarBg(false);
    this.BiT.setActionbarColor(this.BiT.getResources().getColor(2131099650));
    this.BiT.hideActionbarLine();
    this.BiT.setBackBtn(new ContactWidgetNewBizInfo.3(this), 2131689492);
    this.BiT.removeAllOptionMenu();
    this.BiT.addIconOptionMenu(1, 2131766796, 2131689496, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(231939);
        ContactWidgetNewBizInfo.d(ContactWidgetNewBizInfo.this);
        AppMethodBeat.o(231939);
        return true;
      }
    });
    this.BiT.addIconOptionMenu(0, "", 2131689495, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(27434);
        paramAnonymousMenuItem = new e(ContactWidgetNewBizInfo.b(ContactWidgetNewBizInfo.this), 1, false);
        paramAnonymousMenuItem.HLX = new o.f()
        {
          public final void onCreateMMMenu(m paramAnonymous2m)
          {
            AppMethodBeat.i(231941);
            if (com.tencent.mm.contact.c.oR(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_type)) {
              if (ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).arE()) {
                if ((com.tencent.mm.storage.ab.clc()) && (com.tencent.mm.al.g.Nd(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username))) {
                  paramAnonymous2m.kV(5, 2131757840);
                }
              }
            }
            for (;;)
            {
              paramAnonymous2m.kV(2, 2131758047);
              paramAnonymous2m.kV(6, 2131757360);
              if (com.tencent.mm.contact.c.oR(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_type)) {
                paramAnonymous2m.kV(3, 2131757851);
              }
              AppMethodBeat.o(231941);
              return;
              paramAnonymous2m.kV(5, 2131762839);
              continue;
              if ((com.tencent.mm.storage.ab.clc()) && (com.tencent.mm.al.g.Nd(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username)))
              {
                paramAnonymous2m.kV(4, 2131757836);
              }
              else
              {
                paramAnonymous2m.kV(4, 2131758117);
                continue;
                if ((int)ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).gMZ <= 0) {
                  ay.a.iDq.a(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username, "", new ay.b.a()
                  {
                    public final void p(String paramAnonymous3String, boolean paramAnonymous3Boolean)
                    {
                      AppMethodBeat.i(231940);
                      Log.i("MicroMsg.ContactWidgetNewBizInfo", "onCreateMMMenu Fetch Contact username:%s, succ: %b", new Object[] { paramAnonymous3String, Boolean.valueOf(paramAnonymous3Boolean) });
                      AppMethodBeat.o(231940);
                    }
                  });
                }
              }
            }
          }
        };
        paramAnonymousMenuItem.HLY = new o.g()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(231942);
            switch (paramAnonymous2MenuItem.getItemId())
            {
            default: 
              Log.w("MicroMsg.ContactWidgetNewBizInfo", "default onMMMenuItemSelected err");
            case 2: 
            case 3: 
            case 4: 
            case 5: 
              do
              {
                do
                {
                  AppMethodBeat.o(231942);
                  return;
                  ContactWidgetNewBizInfo.f(ContactWidgetNewBizInfo.this);
                  AppMethodBeat.o(231942);
                  return;
                  ContactWidgetNewBizInfo.g(ContactWidgetNewBizInfo.this);
                  AppMethodBeat.o(231942);
                  return;
                  com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.c(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username, 903, ContactWidgetNewBizInfo.h(ContactWidgetNewBizInfo.this), ContactWidgetNewBizInfo.i(ContactWidgetNewBizInfo.this));
                  com.tencent.mm.model.j.HO(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username);
                  ContactWidgetNewBizInfo.j(ContactWidgetNewBizInfo.this);
                } while ((com.tencent.mm.storage.ab.clc()) && (!com.tencent.mm.al.g.Nb(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username)));
                com.tencent.mm.ui.base.h.cD(ContactWidgetNewBizInfo.b(ContactWidgetNewBizInfo.this), ContactWidgetNewBizInfo.b(ContactWidgetNewBizInfo.this).getString(2131762840));
                AppMethodBeat.o(231942);
                return;
                com.tencent.mm.model.ab.F(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username, true);
                com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.c(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username, 904, ContactWidgetNewBizInfo.h(ContactWidgetNewBizInfo.this), ContactWidgetNewBizInfo.i(ContactWidgetNewBizInfo.this));
                ContactWidgetNewBizInfo.j(ContactWidgetNewBizInfo.this);
              } while ((com.tencent.mm.storage.ab.clc()) && (!com.tencent.mm.al.g.Nb(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username)));
              com.tencent.mm.ui.base.h.cD(ContactWidgetNewBizInfo.b(ContactWidgetNewBizInfo.this), ContactWidgetNewBizInfo.b(ContactWidgetNewBizInfo.this).getString(2131756793));
              AppMethodBeat.o(231942);
              return;
            }
            ContactWidgetNewBizInfo.k(ContactWidgetNewBizInfo.this);
            AppMethodBeat.o(231942);
          }
        };
        paramAnonymousMenuItem.dGm();
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.c(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username, 600, ContactWidgetNewBizInfo.h(ContactWidgetNewBizInfo.this), ContactWidgetNewBizInfo.i(ContactWidgetNewBizInfo.this));
        AppMethodBeat.o(27434);
        return false;
      }
    });
    AppMethodBeat.o(27445);
  }
  
  final void US(int paramInt)
  {
    AppMethodBeat.i(27463);
    if ((this.Bfg == null) || ((this.kgm != 39) && (this.kgm != 56) && (this.kgm != 35) && (this.kgm != 87) && (this.kgm != 88) && (this.kgm != 89) && (this.kgm != 85)))
    {
      Log.d("MicroMsg.ContactWidgetNewBizInfo", "mExtArgs is null or the add contact action is not from biz search.");
      AppMethodBeat.o(27463);
      return;
    }
    if (this.contact == null)
    {
      Log.i("MicroMsg.ContactWidgetNewBizInfo", "contact is null.");
      AppMethodBeat.o(27463);
      return;
    }
    String str2 = this.Bfg.getString("Contact_Ext_Args_Search_Id");
    String str3 = Util.nullAsNil(this.Bfg.getString("Contact_Ext_Args_Query_String"));
    int j = this.Bfg.getInt("Contact_Ext_Args_Index");
    int i;
    switch (this.kgm)
    {
    default: 
      i = 0;
      str1 = Util.nullAsNil(this.Bfg.getString("Contact_Ext_Extra_Params"));
      str2 = str3 + "," + paramInt + "," + Util.nullAsNil(this.contact.field_username) + "," + j + "," + System.currentTimeMillis() / 1000L + "," + str2 + "," + i;
      if (Util.isNullOrNil(null)) {
        break;
      }
    }
    for (String str1 = str2 + "," + null + "," + str1;; str1 = str2 + ",," + str1)
    {
      Log.v("MicroMsg.ContactWidgetNewBizInfo", "report 10866: %s", new Object[] { str1 });
      com.tencent.mm.plugin.report.service.h.CyF.kvStat(10866, str1);
      AppMethodBeat.o(27463);
      return;
      i = 1;
      break;
      i = 2;
      break;
      i = 3;
      break;
      i = 4;
      break;
      i = 5;
      break;
    }
  }
  
  public final boolean a(f paramf, as paramas, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(27443);
    if (this.BiT.isFinishing())
    {
      AppMethodBeat.o(27443);
      return true;
    }
    if (paramas != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (Util.nullAsNil(paramas.field_username).length() <= 0) {
        break label420;
      }
      bool = true;
      label52:
      Assert.assertTrue(bool);
      if (paramf == null) {
        break label426;
      }
    }
    label420:
    label426:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      ab(paramas);
      this.screen = paramf;
      this.contact = paramas;
      this.Bdx = paramBoolean;
      this.kgm = paramInt;
      this.Bfh = ((SnsAdClick)this.BiT.getIntent().getParcelableExtra("KSnsAdTag"));
      this.Bfi = this.BiT.getIntent().getStringExtra("key_add_contact_report_info");
      this.Bfb = this.BiT.getIntent().getIntExtra("add_more_friend_search_scene", 0);
      this.Bfg = this.BiT.getIntent().getBundleExtra("Contact_Ext_Args");
      this.pHz = this.BiT.getIntent().getStringExtra("key_channel_session_id");
      if ((this.kgm != 78) && (this.kgm != 79)) {
        break label432;
      }
      this.BiX = false;
      Log.i("MicroMsg.ContactWidgetNewBizInfo", "updateBizTeenModeStatus addContactScene: %d not need to block", new Object[] { Integer.valueOf(this.kgm) });
      if (this.BiZ)
      {
        this.BiZ = false;
        initActionBar();
        this.BiU = a.aKy(this.contact.field_username);
        eEp();
        b(paramas.field_username, null);
        paramf = this.BiT.getIntent().getStringExtra("Contact_BIZ_PopupInfoMsg");
        if (!Util.isNullOrNil(paramf))
        {
          this.BiT.getIntent().putExtra("Contact_BIZ_PopupInfoMsg", "");
          com.tencent.mm.ui.base.h.a(this.BiT, paramf, "", this.BiT.getString(2131755921), null);
        }
        if (paramas != null) {
          ag.bau().MN(paramas.field_username);
        }
      }
      if (this.Bjb != null)
      {
        paramf = this.BiT.getListView();
        if (paramf != null) {
          paramf.onRestoreInstanceState(this.Bjb);
        }
      }
      if ((this.BiT instanceof FragmentActivity))
      {
        this.BiT.getLifecycle().removeObserver(this);
        this.BiT.getLifecycle().addObserver(this);
      }
      AppMethodBeat.o(27443);
      return true;
      bool = false;
      break;
      bool = false;
      break label52;
    }
    label432:
    bool = ((com.tencent.mm.api.q)com.tencent.mm.kernel.g.af(com.tencent.mm.api.q.class)).Vu();
    if (!bool) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.BiX = paramBoolean;
      Log.i("MicroMsg.ContactWidgetNewBizInfo", "updateBizTeenModeStatus addContactScene: %d, blockAddContact: %b, isBizTeenModeAllowAll: %b", new Object[] { Integer.valueOf(this.kgm), Boolean.valueOf(this.BiX), Boolean.valueOf(bool) });
      break;
    }
  }
  
  public final long ahy()
  {
    return this.enterTime;
  }
  
  public final boolean alD(String paramString)
  {
    AppMethodBeat.i(27457);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.ContactWidgetNewBizInfo", "handleEvent key is null, return");
      AppMethodBeat.o(27457);
      return false;
    }
    Log.i("MicroMsg.ContactWidgetNewBizInfo", "handleEvent key:%s, blockAddContact: %b", new Object[] { paramString, Boolean.valueOf(this.BiX) });
    if ("contact_info_biz_add".endsWith(paramString))
    {
      if (this.BiX)
      {
        ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class)).hr(this.BiT);
        if ((this.contact != null) && (this.contact.field_username != null)) {
          ((com.tencent.mm.api.q)com.tencent.mm.kernel.g.af(com.tencent.mm.api.q.class)).d(7, this.contact.field_username, this.contact.field_nickname);
        }
        AppMethodBeat.o(27457);
        return true;
      }
      if (!com.tencent.mm.model.gdpr.c.aXj()) {
        eEr();
      }
      for (;;)
      {
        if (this.Bfb != 0) {
          com.tencent.mm.plugin.report.service.h.CyF.a(11263, new Object[] { Integer.valueOf(this.Bfb), this.contact.field_username });
        }
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.c(this.contact.field_username, 200, this.kgm, this.enterTime);
        AppMethodBeat.o(27457);
        return true;
        com.tencent.mm.model.gdpr.c.a(this.BiT, com.tencent.mm.model.gdpr.a.iGN, this.contact.field_username, new com.tencent.mm.model.gdpr.b()
        {
          public final void sx(int paramAnonymousInt)
          {
            AppMethodBeat.i(231945);
            if (paramAnonymousInt == 0) {
              ContactWidgetNewBizInfo.q(ContactWidgetNewBizInfo.this);
            }
            AppMethodBeat.o(231945);
          }
        });
      }
    }
    AppMethodBeat.o(27457);
    return true;
  }
  
  public final boolean axa()
  {
    AppMethodBeat.i(27465);
    if ((this.contact == null) || (this.Bdk == null) || (this.BiU == null) || (this.BiU.KWf == null) || (this.BiU.KWe == null))
    {
      Log.w("MicroMsg.ContactWidgetNewBizInfo", "reportEnd fail, err");
      this.pti.dead();
      this.lEl.dead();
      AppMethodBeat.o(27465);
      return false;
    }
    this.endTime = System.currentTimeMillis();
    String str = this.contact.field_username;
    int k = this.kgm;
    int m = this.Bdk.field_type;
    long l1 = this.enterTime;
    long l2 = this.endTime;
    int i;
    label135:
    int n;
    int i1;
    if (com.tencent.mm.contact.c.oR(this.contact.field_type))
    {
      i = 1;
      n = this.BiU.KWf.KSY;
      i1 = this.BiU.KWf.KSZ;
      if (this.BeW == null) {
        break label232;
      }
    }
    label232:
    for (int j = this.BeW.size();; j = 0)
    {
      com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.a(str, k, m, l1, l2, i, n, i1, j, com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.c(this.BiU.KWg), com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.a(this.BiU.KWj), this.BiU.KWe.UserName);
      break;
      i = 0;
      break label135;
    }
  }
  
  public final boolean cCs()
  {
    AppMethodBeat.i(27455);
    if (this.screen == null)
    {
      AppMethodBeat.o(27455);
      return true;
    }
    Object localObject = (NewBizInfoHeaderPreference)this.screen.bmg("contact_info_header_newbizinfo");
    if (localObject != null) {
      ((NewBizInfoHeaderPreference)localObject).onDetach();
    }
    localObject = this.BiT.getListView();
    if (localObject != null) {
      this.Bjb = ((ListView)localObject).onSaveInstanceState();
    }
    AppMethodBeat.o(27455);
    return true;
  }
  
  public final void cJk()
  {
    AppMethodBeat.i(27449);
    if ((this.Bja) && (this.BiU.KWg != null) && (this.BiU.KWg.KVx != null) && (this.BiU.KWg.KVx.KWa == 0)) {
      b(this.contact.field_username, this.BiU.KWg.KVx.KVZ);
    }
    AppMethodBeat.o(27449);
  }
  
  public final as eFa()
  {
    return this.contact;
  }
  
  public final int eFd()
  {
    return this.kgm;
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public void onActivityDestroy()
  {
    AppMethodBeat.i(27444);
    Log.i("MicroMsg.ContactWidgetNewBizInfo", "[onActivityDestroy]");
    cCs();
    AppMethodBeat.o(27444);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(27456);
    if (this.BiT == null)
    {
      Log.e("MicroMsg.ContactWidgetNewBizInfo", "null == context");
      AppMethodBeat.o(27456);
      return;
    }
    Log.i("MicroMsg.ContactWidgetNewBizInfo", "onActivityResult, requestCode = %d, resultCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(27456);
      return;
    }
    if ((paramInt2 == -1) && (paramIntent != null))
    {
      String str1 = paramIntent.getStringExtra("be_send_card_name");
      String str2 = paramIntent.getStringExtra("received_card_name");
      boolean bool = paramIntent.getBooleanExtra("Is_Chatroom", false);
      paramIntent = paramIntent.getStringExtra("custom_send_text");
      com.tencent.mm.plugin.messenger.a.g.eir().s(str1, str2, bool);
      com.tencent.mm.plugin.messenger.a.g.eir().iF(paramIntent, str2);
      com.tencent.mm.ui.widget.snackbar.b.r(this.BiT, this.BiT.getString(2131760708));
      AppMethodBeat.o(27456);
      return;
    }
    AppMethodBeat.o(27456);
  }
  
  public final boolean onCreate()
  {
    AppMethodBeat.i(27464);
    Log.v("MicroMsg.ContactWidgetNewBizInfo", "alvinluo ContactWidgetNewBizInfo onCreate");
    if ((this.contact == null) || (this.Bdk == null))
    {
      Log.w("MicroMsg.ContactWidgetNewBizInfo", "reportStart fail, err");
      this.pti.alive();
      this.lEl.alive();
      AppMethodBeat.o(27464);
      return false;
    }
    String str = this.contact.field_username;
    int j = this.kgm;
    int k = this.Bdk.field_type;
    long l = this.enterTime;
    if (com.tencent.mm.contact.c.oR(this.contact.field_type)) {}
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.a(str, j, k, l, i, this.pHz);
      break;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(27461);
    Log.d("MicroMsg.ContactWidgetNewBizInfo", "onSceneEnd errType = " + paramInt1 + ", errCode = " + paramInt2 + ",errMsg = " + paramString);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if (paramq == null)
    {
      Log.e("MicroMsg.ContactWidgetNewBizInfo", "scene == null");
      AppMethodBeat.o(27461);
      return;
    }
    bg.azz().b(paramq.getType(), this);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Log.e("MicroMsg.ContactWidgetNewBizInfo", "scene.getType() = %s", new Object[] { Integer.valueOf(paramq.getType()) });
      AppMethodBeat.o(27461);
      return;
    }
    Log.d("MicroMsg.ContactWidgetNewBizInfo", "scene.getType() = %s", new Object[] { Integer.valueOf(paramq.getType()) });
    if (paramq.getType() == 536)
    {
      bg.azz().b(536, this);
      eEp();
    }
    AppMethodBeat.o(27461);
  }
  
  static final class b
    extends IListener<mx>
  {
    private WeakReference<ContactWidgetNewBizInfo> Bjm;
    
    public b(ContactWidgetNewBizInfo paramContactWidgetNewBizInfo)
    {
      AppMethodBeat.i(231950);
      this.Bjm = new WeakReference(paramContactWidgetNewBizInfo);
      this.__eventId = mx.class.getName().hashCode();
      AppMethodBeat.o(231950);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.ContactWidgetNewBizInfo
 * JD-Core Version:    0.7.0.1
 */