package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
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
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.al.ag;
import com.tencent.mm.api.c.a;
import com.tencent.mm.api.c.b;
import com.tencent.mm.g.a.do;
import com.tencent.mm.g.a.do.b;
import com.tencent.mm.g.a.ds;
import com.tencent.mm.g.a.ds.b;
import com.tencent.mm.g.a.mg;
import com.tencent.mm.g.a.qx;
import com.tencent.mm.g.a.u;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.b;
import com.tencent.mm.model.au.b.a;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.w;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.profile.ui.ContactInfoUI;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.a.b;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.protocal.protobuf.aak;
import com.tencent.mm.protocal.protobuf.aco;
import com.tencent.mm.protocal.protobuf.cne;
import com.tencent.mm.protocal.protobuf.dvx;
import com.tencent.mm.protocal.protobuf.lz;
import com.tencent.mm.protocal.protobuf.mo;
import com.tencent.mm.protocal.protobuf.mp;
import com.tencent.mm.protocal.protobuf.mq;
import com.tencent.mm.protocal.protobuf.mx;
import com.tencent.mm.protocal.protobuf.oa;
import com.tencent.mm.protocal.protobuf.ob;
import com.tencent.mm.protocal.protobuf.oi;
import com.tencent.mm.protocal.protobuf.oj;
import com.tencent.mm.protocal.protobuf.ok;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.y;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.e.a;
import com.tencent.mm.ui.widget.a.e;
import d.o;
import d.v;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class ContactWidgetNewBizInfo
  implements LifecycleObserver, com.tencent.mm.ak.f, com.tencent.mm.pluginsdk.b.b
{
  private static String xlb = "crashFlag";
  private static boolean xlc = false;
  private List<c.a> cRa;
  private c.b cRb;
  private String cRk;
  an contact;
  private long endTime;
  long enterTime;
  private boolean isLoading;
  int jij;
  private com.tencent.mm.sdk.b.c kzS;
  private WeakReference<ContactWidgetNewBizInfo> nTM;
  private com.tencent.mm.sdk.b.c ohH;
  private String ouc;
  private com.tencent.mm.ui.base.preference.f screen;
  public String tIA;
  private com.tencent.mm.ui.base.p tipDialog;
  com.tencent.mm.api.c xfE;
  boolean xfQ;
  private String xfV;
  private List<WxaAttributes.WxaEntryInfo> xhj;
  private aco xhk;
  private int xho;
  private Bundle xhs;
  SnsAdClick xht;
  private String xhu;
  ContactInfoUI xkT;
  private ok xkU;
  private com.tencent.mm.plugin.profile.ui.newbizinfo.b.c xkV;
  private boolean xkW;
  private int xkX;
  private boolean xkY;
  private boolean xkZ;
  private Parcelable xla;
  
  public ContactWidgetNewBizInfo(final ContactInfoUI paramContactInfoUI, final String paramString, aco paramaco, long paramLong)
  {
    AppMethodBeat.i(186590);
    this.xho = 0;
    this.xht = null;
    this.xhu = null;
    this.xkV = null;
    this.nTM = null;
    this.ouc = "";
    this.xkW = false;
    this.kzS = new b(this);
    this.ohH = new a(this);
    this.xkX = 0;
    this.xkY = true;
    this.isLoading = false;
    this.xkZ = false;
    this.tipDialog = null;
    this.nTM = new WeakReference(this);
    this.xkT = paramContactInfoUI;
    this.xfV = paramString;
    this.xhk = paramaco;
    this.enterTime = paramLong;
    paramString = paramContactInfoUI.getListView();
    dEC();
    paramString.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(186574);
        if (ContactWidgetNewBizInfo.c(ContactWidgetNewBizInfo.this) != null)
        {
          paramAnonymousAbsListView = (NewBizInfoHeaderPreference)ContactWidgetNewBizInfo.c(ContactWidgetNewBizInfo.this).aXe("contact_info_header_newbizinfo");
          if (paramAnonymousAbsListView != null)
          {
            int[] arrayOfInt = new int[2];
            if (paramAnonymousAbsListView.xlt == null) {}
            for (paramAnonymousInt1 = 0; paramAnonymousInt1 < 0; paramAnonymousInt1 = arrayOfInt[1])
            {
              paramAnonymousInt2 = paramAnonymousAbsListView.xlv.getMeasuredHeight();
              float f = (paramAnonymousInt1 + paramAnonymousInt2 - this.xle) / paramAnonymousInt2;
              paramContactInfoUI.setMMTitleColor(paramContactInfoUI.getResources().getColor(2131099732));
              paramContactInfoUI.setTitleAlpha(1.0F - f);
              AppMethodBeat.o(186574);
              return;
              paramAnonymousAbsListView.xlt.getLocationInWindow(arrayOfInt);
            }
            if (paramAnonymousInt1 == 0)
            {
              if (paramAnonymousAbsListView.xlt == null) {}
              for (boolean bool = false; !bool; bool = paramAnonymousAbsListView.xlt.isAttachedToWindow())
              {
                paramContactInfoUI.setMMTitleColor(paramContactInfoUI.getResources().getColor(2131099732));
                AppMethodBeat.o(186574);
                return;
              }
            }
            paramContactInfoUI.setMMTitleColor(0);
          }
        }
        AppMethodBeat.o(186574);
      }
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(186573);
        ArrayList localArrayList;
        if ((paramAnonymousInt == 0) && (ContactWidgetNewBizInfo.a(ContactWidgetNewBizInfo.this) != null))
        {
          paramAnonymousAbsListView = ContactWidgetNewBizInfo.a(ContactWidgetNewBizInfo.this);
          paramAnonymousInt = paramString.getFirstVisiblePosition();
          int i = paramString.getLastVisiblePosition();
          if (paramAnonymousAbsListView.dEN().zl(16))
          {
            int j = paramAnonymousAbsListView.dEM();
            int k = paramAnonymousAbsListView.xmu;
            localArrayList = new ArrayList();
            if (paramAnonymousInt <= i) {
              for (;;)
              {
                if (paramAnonymousAbsListView.NJ(paramAnonymousInt))
                {
                  int n = paramAnonymousInt + (j - k);
                  if (paramAnonymousAbsListView.xms.NF(n) == a.b.xmi)
                  {
                    Object localObject1 = paramAnonymousAbsListView.xms.getItem(n);
                    if (localObject1 == null)
                    {
                      paramAnonymousAbsListView = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizMessage");
                      AppMethodBeat.o(186573);
                      throw paramAnonymousAbsListView;
                    }
                    localObject1 = (oa)localObject1;
                    Object localObject2 = paramAnonymousAbsListView.xmz.contact;
                    d.g.b.p.g(localObject2, "widget.contact");
                    localObject2 = ((aw)localObject2).field_username;
                    long l = paramAnonymousAbsListView.xmz.enterTime;
                    int m = paramAnonymousAbsListView.xmz.jij;
                    n /= 2;
                    if (((oa)localObject1).Gbs.urJ == 49)
                    {
                      localObject3 = ((oa)localObject1).Gbx.FYQ;
                      d.g.b.p.g(localObject3, "bizMessage.AppMsg.DetailInfo");
                      Object localObject4 = (Iterable)localObject3;
                      localObject3 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject4, 10));
                      localObject4 = ((Iterable)localObject4).iterator();
                      Object localObject5;
                      while (((Iterator)localObject4).hasNext())
                      {
                        localObject5 = (mp)((Iterator)localObject4).next();
                        ((Collection)localObject3).add(d.a.j.listOf(new String[] { ((mp)localObject5).FYs, String.valueOf(((mp)localObject5).hFR) }));
                      }
                      localArrayList.addAll((Collection)localObject3);
                      localObject3 = ((oa)localObject1).Gbx.FYQ;
                      d.g.b.p.g(localObject3, "bizMessage.AppMsg.DetailInfo");
                      localObject3 = ((Iterable)localObject3).iterator();
                      while (((Iterator)localObject3).hasNext())
                      {
                        localObject4 = (mp)((Iterator)localObject3).next();
                        localObject5 = com.tencent.mm.plugin.profile.ui.newbizinfo.c.d.xnQ;
                        d.g.b.p.g(localObject2, "userName");
                        com.tencent.mm.plugin.profile.ui.newbizinfo.c.d.a((String)localObject2, l, ((oa)localObject1).Gbx.FYP.FYo, ((mp)localObject4).FYr, ((mp)localObject4).hFR, n, ((oa)localObject1).Gbx.FYP.CreateTime, m);
                      }
                    }
                    Object localObject3 = com.tencent.mm.plugin.profile.ui.newbizinfo.c.d.xnQ;
                    d.g.b.p.g(localObject2, "userName");
                    com.tencent.mm.plugin.profile.ui.newbizinfo.c.d.a((String)localObject2, l, ((oa)localObject1).Gbs.xri, 0, -1, n, ((oa)localObject1).Gbs.GrG, m);
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
            paramAnonymousAbsListView.dEN().j((List)localArrayList, 126);
          }
          AppMethodBeat.o(186573);
          return;
        }
      }
    });
    AppMethodBeat.o(186590);
  }
  
  private void a(ok paramok)
  {
    AppMethodBeat.i(169758);
    if (paramok == null)
    {
      AppMethodBeat.o(169758);
      return;
    }
    if (paramok.Gcj != null)
    {
      com.tencent.mm.plugin.brandservice.b.c.F(paramok.Gcj.GUi, true);
      boolean bool = paramok.Gcj.GUi;
      if (paramok.Gcj.Hzm != null)
      {
        i = paramok.Gcj.Hzm.size();
        ae.i("MicroMsg.ContactWidgetNewBizInfo", "alvinluo updateProfileInfo %b, size: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
      }
    }
    label87:
    com.tencent.mm.plugin.profile.ui.newbizinfo.b.c localc;
    cne localcne;
    com.tencent.mm.plugin.profile.ui.newbizinfo.b.a locala;
    for (;;)
    {
      if (paramok.Gcd != null)
      {
        dEC();
        if (this.xkV != null)
        {
          localc = this.xkV;
          Object localObject1 = paramok.Gcd;
          localcne = paramok.Gcj;
          d.g.b.p.h(localObject1, "msgList");
          locala = localc.xms;
          d.g.b.p.h(localObject1, "msgList");
          locala.fXm.clear();
          d.g.b.p.g(Calendar.getInstance(), "Calendar.getInstance()");
          new Date();
          Object localObject2 = ((ob)localObject1).Gby;
          d.g.b.p.g(localObject2, "msgList.Msg");
          localObject2 = ((Iterable)localObject2).iterator();
          for (;;)
          {
            if (((Iterator)localObject2).hasNext())
            {
              oa localoa = (oa)((Iterator)localObject2).next();
              locala.fXm.add(new o(a.b.xmh, localoa));
              locala.fXm.add(new o(a.b.xmi, localoa));
              continue;
              i = -1;
              break;
              ae.e("MicroMsg.ContactWidgetNewBizInfo", "alvinluo updateProfileInfo videochannel_notify_info is null");
              break label87;
            }
          }
          localObject1 = ((ob)localObject1).Gbz;
          if ((localObject1 != null) && (((oi)localObject1).GbX == 0)) {
            locala.fXm.add(new o(a.b.xmj, new oa()));
          }
          locala = localc.xms;
          if ((localcne != null) && (com.tencent.mm.plugin.brandservice.b.c.bOu()))
          {
            localObject1 = localcne.Hzm;
            d.g.b.p.g(localObject1, "notifyInfo.notify_list");
            if (((Collection)localObject1).isEmpty()) {
              break label500;
            }
          }
        }
      }
    }
    label500:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        ae.i("MicroMsg.BizMessageAdapter", "alvinluo updateHeader add video channel");
        locala.xlY.clear();
        locala.xlY.add(new o(a.b.xmk, localcne));
      }
      localc.xmA.notifyDataSetChanged();
      if ((!this.xkW) && (paramok.Gcj != null) && (paramok.Gcj.Hzm != null) && (paramok.Gcj.Hzm.size() > 0) && (com.tencent.mm.plugin.brandservice.b.c.bOu()))
      {
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.b(this.contact.field_username, 1401, this.jij, this.enterTime);
        this.xkW = true;
      }
      AppMethodBeat.o(169758);
      return;
    }
  }
  
  /* Error */
  private void ab(an paraman)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 401
    //   5: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: ifnull +9 -> 18
    //   12: getstatic 106	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo:xlc	Z
    //   15: ifeq +12 -> 27
    //   18: ldc_w 401
    //   21: invokestatic 192	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: iconst_1
    //   28: putstatic 106	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo:xlc	Z
    //   31: ldc_w 403
    //   34: invokestatic 409	com/tencent/mm/sdk/platformtools/ay:aRX	(Ljava/lang/String;)Lcom/tencent/mm/sdk/platformtools/ay;
    //   37: astore_2
    //   38: aload_2
    //   39: getstatic 104	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo:xlb	Ljava/lang/String;
    //   42: iconst_0
    //   43: invokevirtual 413	com/tencent/mm/sdk/platformtools/ay:decodeBool	(Ljava/lang/String;Z)Z
    //   46: ifeq +30 -> 76
    //   49: ldc 233
    //   51: ldc_w 415
    //   54: invokestatic 369	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: getstatic 421	com/tencent/mm/plugin/report/service/g:yxI	Lcom/tencent/mm/plugin/report/service/g;
    //   60: ldc2_w 422
    //   63: lconst_0
    //   64: lconst_1
    //   65: iconst_0
    //   66: invokevirtual 427	com/tencent/mm/plugin/report/service/g:idkeyStat	(JJJZ)V
    //   69: aload_1
    //   70: getfield 391	com/tencent/mm/g/c/aw:field_username	Ljava/lang/String;
    //   73: invokestatic 432	com/tencent/mm/plugin/profile/ui/newbizinfo/a:clear	(Ljava/lang/String;)V
    //   76: aload_2
    //   77: getstatic 104	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo:xlb	Ljava/lang/String;
    //   80: iconst_1
    //   81: invokevirtual 435	com/tencent/mm/sdk/platformtools/ay:encode	(Ljava/lang/String;Z)Z
    //   84: pop
    //   85: ldc 233
    //   87: ldc_w 437
    //   90: invokestatic 369	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   93: getstatic 442	com/tencent/mm/sdk/platformtools/j:DEBUG	Z
    //   96: ifne +15 -> 111
    //   99: getstatic 445	com/tencent/mm/sdk/platformtools/j:IS_FLAVOR_RED	Z
    //   102: ifne +9 -> 111
    //   105: invokestatic 450	com/tencent/mm/sdk/platformtools/bv:fpT	()Z
    //   108: ifeq +22 -> 130
    //   111: aload_2
    //   112: ldc_w 452
    //   115: iconst_0
    //   116: invokevirtual 456	com/tencent/mm/sdk/platformtools/ay:decodeInt	(Ljava/lang/String;I)I
    //   119: iconst_1
    //   120: if_icmpne +10 -> 130
    //   123: ldc_w 458
    //   126: iconst_0
    //   127: invokestatic 464	junit/framework/Assert:assertTrue	(Ljava/lang/String;Z)V
    //   130: getstatic 470	com/tencent/e/h:MqF	Lcom/tencent/e/i;
    //   133: new 16	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo$2
    //   136: dup
    //   137: aload_0
    //   138: aload_2
    //   139: invokespecial 473	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo$2:<init>	(Lcom/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo;Lcom/tencent/mm/sdk/platformtools/ay;)V
    //   142: ldc2_w 474
    //   145: invokeinterface 481 4 0
    //   150: pop
    //   151: ldc_w 401
    //   154: invokestatic 192	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   157: goto -133 -> 24
    //   160: astore_1
    //   161: aload_0
    //   162: monitorexit
    //   163: aload_1
    //   164: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	this	ContactWidgetNewBizInfo
    //   0	165	1	paraman	an
    //   37	102	2	localay	ay
    // Exception table:
    //   from	to	target	type
    //   2	8	160	finally
    //   12	18	160	finally
    //   18	24	160	finally
    //   27	76	160	finally
    //   76	111	160	finally
    //   111	130	160	finally
    //   130	157	160	finally
  }
  
  private static int awe(String paramString)
  {
    int j = 10000;
    AppMethodBeat.i(27460);
    int i = j;
    if (!bu.isNullOrNil(paramString)) {}
    try
    {
      i = bu.getInt(Uri.parse(paramString).getQueryParameter("scene"), 10000);
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
  
  private void b(String paramString, final com.tencent.mm.bw.b paramb)
  {
    AppMethodBeat.i(27450);
    if (this.isLoading)
    {
      ae.i("MicroMsg.ContactWidgetNewBizInfo", "not obtailBizInfoFromCgi, use cache");
      AppMethodBeat.o(27450);
      return;
    }
    this.isLoading = true;
    Object localObject = new b.a();
    ((b.a)localObject).funcId = 2656;
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/bizattr/bizprofilev2";
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    oj localoj = new oj();
    localoj.FZa = paramString;
    if (paramb != null)
    {
      localoj.GbY = 1;
      localoj.GbW = paramb;
      localoj.GbZ = 20;
      localoj.Scene = this.jij;
      localoj.Gca = y.getSessionId();
      ((b.a)localObject).hQF = localoj;
      ((b.a)localObject).hQG = new ok();
      localObject = ((b.a)localObject).aDS();
      paramb = new x.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb, n paramAnonymousn)
        {
          AppMethodBeat.i(186582);
          ae.i("MicroMsg.ContactWidgetNewBizInfo", "callback, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          paramAnonymousString = (ok)paramAnonymousb.hQE.hQJ;
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousString != null))
          {
            paramAnonymousb = a.xlX;
            a.a(paramAnonymousString.Gcd);
            if (paramb == null) {
              break label386;
            }
            if ((!paramb.equals(ContactWidgetNewBizInfo.l(ContactWidgetNewBizInfo.this).Gcd.Gbz.GbW)) || (paramAnonymousString.Gcd == null)) {
              break label376;
            }
            ContactWidgetNewBizInfo.l(ContactWidgetNewBizInfo.this).Gcd.Gby.addAll(paramAnonymousString.Gcd.Gby);
            ContactWidgetNewBizInfo.l(ContactWidgetNewBizInfo.this).Gcd.Gbz = paramAnonymousString.Gcd.Gbz;
            if (paramb == null) {
              break label422;
            }
            if ((ContactWidgetNewBizInfo.l(ContactWidgetNewBizInfo.this) != null) && (ContactWidgetNewBizInfo.l(ContactWidgetNewBizInfo.this).Gcd != null))
            {
              ContactWidgetNewBizInfo.a(ContactWidgetNewBizInfo.this, ContactWidgetNewBizInfo.l(ContactWidgetNewBizInfo.this));
              com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.b(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username, 106, ContactWidgetNewBizInfo.h(ContactWidgetNewBizInfo.this), ContactWidgetNewBizInfo.i(ContactWidgetNewBizInfo.this));
            }
            label227:
            if ((paramAnonymousString.FZk & 0x4) == 0) {
              break label449;
            }
            paramAnonymousb = ContactWidgetNewBizInfo.c(4, paramAnonymousString.Gch);
            if (paramAnonymousb == null) {
              break label449;
            }
            paramAnonymousn = (NewBizInfoErrMsgPreference)ContactWidgetNewBizInfo.c(ContactWidgetNewBizInfo.this).aXe("contact_info_biz_err_msg");
            ContactWidgetNewBizInfo.c(ContactWidgetNewBizInfo.this).cT("contact_info_biz_err_msg", false);
            paramAnonymousn.setErrMsg(paramAnonymousb);
          }
          for (;;)
          {
            for (;;)
            {
              if ((paramAnonymousString.FZk & 0x2) != 0)
              {
                paramAnonymousString = (NewBizInfoHeaderPreference)ContactWidgetNewBizInfo.c(ContactWidgetNewBizInfo.this).aXe("contact_info_header_newbizinfo");
                paramAnonymousString.xlx = true;
                if (paramAnonymousString.fTj != null)
                {
                  com.tencent.mm.plugin.brandservice.b.d.a(paramAnonymousString.fTj, paramAnonymousString.contact, "", true);
                  paramAnonymousString.fTj.setClickable(false);
                }
              }
              ContactWidgetNewBizInfo.o(ContactWidgetNewBizInfo.this);
              ContactWidgetNewBizInfo.p(ContactWidgetNewBizInfo.this);
              AppMethodBeat.o(186582);
              return 0;
              label376:
              ae.e("MicroMsg.ContactWidgetNewBizInfo", "drop err resp");
              break;
              try
              {
                label386:
                ContactWidgetNewBizInfo.l(ContactWidgetNewBizInfo.this).parseFrom(paramAnonymousString.toByteArray());
              }
              catch (IOException paramAnonymousb)
              {
                ae.printErrStackTrace("MicroMsg.ContactWidgetNewBizInfo", paramAnonymousb, "profileInfo.parseFrom", new Object[0]);
              }
            }
            break;
            label422:
            a.b(ContactWidgetNewBizInfo.l(ContactWidgetNewBizInfo.this));
            ContactWidgetNewBizInfo.m(ContactWidgetNewBizInfo.this);
            ContactWidgetNewBizInfo.n(ContactWidgetNewBizInfo.this);
            break label227;
            label449:
            if ((paramAnonymousString.FZk & 0x8) != 0)
            {
              paramAnonymousb = ContactWidgetNewBizInfo.c(8, paramAnonymousString.Gch);
              if (paramAnonymousb != null)
              {
                paramAnonymousn = (NewBizInfoErrMsgPreference)ContactWidgetNewBizInfo.c(ContactWidgetNewBizInfo.this).aXe("contact_info_biz_err_msg");
                ContactWidgetNewBizInfo.c(ContactWidgetNewBizInfo.this).cT("contact_info_biz_err_msg", false);
                paramAnonymousn.setErrMsg(paramAnonymousb);
                continue;
              }
            }
            ContactWidgetNewBizInfo.c(ContactWidgetNewBizInfo.this).cT("contact_info_biz_err_msg", true);
          }
        }
      };
      if (!(this.xkT instanceof com.tencent.mm.vending.e.b)) {
        break label197;
      }
    }
    label197:
    for (paramString = this.xkT;; paramString = null)
    {
      com.tencent.mm.ak.x.a((com.tencent.mm.ak.b)localObject, paramb, false, paramString);
      AppMethodBeat.o(27450);
      return;
      localoj.GbY = 0;
      localoj.GbZ = 5;
      break;
    }
  }
  
  private boolean bUY()
  {
    AppMethodBeat.i(27452);
    if ((this.xkU != null) && (this.xkU.Gcb != null) && (this.xkU.Gcb.FXi == 0) && (!dEF()))
    {
      AppMethodBeat.o(27452);
      return true;
    }
    AppMethodBeat.o(27452);
    return false;
  }
  
  private void dDW()
  {
    AppMethodBeat.i(27451);
    ceC();
    dED();
    this.screen.removeAll();
    this.screen.addPreferencesFromResource(2131951647);
    Object localObject = (NewBizInfoHeaderPreference)this.screen.aXe("contact_info_header_newbizinfo");
    if ((localObject != null) && (!bu.isNullOrNil(this.contact.field_username)))
    {
      ((NewBizInfoHeaderPreference)localObject).a(this.contact, this.xfV, this.xfE, this.xkU);
      this.xkZ = true;
      if (this.xkU == null) {
        break label598;
      }
      if (!com.tencent.mm.contact.c.lO(this.contact.field_type)) {
        break label567;
      }
      this.screen.cT("contact_info_biz_add", true);
      this.screen.cT("contact_info_biz_go_chatting", false);
      ((NewBizInfoFollowPreference)this.screen.aXe("contact_info_biz_go_chatting")).xfP = this;
      label161:
      if ((this.xkU != null) && (this.xkU.Gcb != null) && (this.xkU.Gcd != null) && (this.xkU.Gcd.Gbz != null)) {
        a(this.xkU);
      }
      if ((this.xkU != null) && (!bUY()) && (!com.tencent.mm.contact.c.lO(this.contact.field_type))) {
        this.xkT.showOptionMenu(false);
      }
      if ((this.xkU == null) || (this.xkU.Gcg == null)) {
        break label643;
      }
      this.screen.cT("contact_info_biz_menu_newbizinfo", false);
      if (this.xkU != null) {
        ((NewBizInfoMenuPreference)this.screen.aXe("contact_info_biz_menu_newbizinfo")).a(this.xkU.Gcg, this.contact, this.jij, this.enterTime);
      }
    }
    for (;;)
    {
      this.screen.cT("contact_info_biz_err_msg", true);
      ae.d("MicroMsg.ContactWidgetNewBizInfo", "KIsardDevice(%b)", new Object[] { Boolean.valueOf(this.xkT.getIntent().getBooleanExtra("KIsHardDevice", false)) });
      if ((this.xkT.getIntent() == null) || (!this.xkT.getIntent().getBooleanExtra("KIsHardDevice", false))) {
        break label681;
      }
      ae.d("MicroMsg.ContactWidgetNewBizInfo", "Hard device biz...");
      boolean bool = dDZ();
      ae.d("MicroMsg.ContactWidgetNewBizInfo", "contact.isContact()(%b), isHarDeviceBound(%b)", new Object[] { Boolean.valueOf(com.tencent.mm.contact.c.lO(this.contact.field_type)), Boolean.valueOf(bool) });
      if ((com.tencent.mm.contact.c.lO(this.contact.field_type)) && (bool)) {
        break label674;
      }
      ae.w("MicroMsg.ContactWidgetNewBizInfo", "%s is not my hard biz contact", new Object[] { this.contact.field_username });
      dDX();
      localObject = (NewBizInfoNotFollowPreference)this.screen.aXe("contact_info_biz_add");
      this.screen.cT("contact_info_biz_add", false);
      if (localObject == null) {
        break label674;
      }
      if (!bool) {
        break label660;
      }
      ((NewBizInfoNotFollowPreference)localObject).setTitle(this.xkT.getString(2131757610));
      AppMethodBeat.o(27451);
      return;
      ae.w("MicroMsg.ContactWidgetNewBizInfo", "head pref is null");
      this.screen.cT("contact_info_header_bizinfo", true);
      break;
      label567:
      this.screen.cT("contact_info_biz_add", false);
      this.screen.cT("contact_info_biz_go_chatting", true);
      break label161;
      label598:
      this.screen.cT("contact_info_biz_add", true);
      this.screen.cT("contact_info_biz_go_chatting", true);
      this.screen.cT("contact_info_biz_space", false);
      break label161;
      label643:
      this.screen.cT("contact_info_biz_menu_newbizinfo", true);
    }
    label660:
    ((NewBizInfoNotFollowPreference)localObject).setTitle(this.xkT.getString(2131757596));
    label674:
    AppMethodBeat.o(27451);
    return;
    label681:
    if (dEF())
    {
      this.screen.cT("contact_info_biz_loading", false);
      this.screen.cT("contact_info_biz_add", true);
      this.screen.cT("contact_info_biz_go_chatting", true);
      this.screen.cT("contact_info_message_newbizinfo", true);
    }
    AppMethodBeat.o(27451);
  }
  
  private void dDX()
  {
    AppMethodBeat.i(27454);
    if ((this.contact != null) && ((com.tencent.mm.model.x.AV(this.contact.field_username)) || (com.tencent.mm.model.x.Bh(this.contact.field_username))) && (com.tencent.mm.contact.c.lO(this.contact.field_type)))
    {
      this.screen.cT("contact_info_biz_go_chatting", false);
      AppMethodBeat.o(27454);
      return;
    }
    this.screen.cT("contact_info_biz_go_chatting", true);
    AppMethodBeat.o(27454);
  }
  
  private void dDY()
  {
    AppMethodBeat.i(27458);
    if ((NewBizInfoHeaderPreference)this.screen.aXe("contact_info_header_newbizinfo") != null) {
      NewBizInfoHeaderPreference.yX(System.currentTimeMillis());
    }
    if ((this.xkT.getIntent() != null) && (this.xkT.getIntent().getBooleanExtra("KIsHardDevice", false)))
    {
      localObject1 = this.xkT.getIntent().getStringExtra("KHardDeviceBindTicket");
      if (!bu.isNullOrNil((String)localObject1)) {
        break label334;
      }
      ae.i("MicroMsg.ContactWidgetNewBizInfo", "bindTicket is null, means it is not switch from QRcode scan, just add contact");
    }
    label334:
    while (dDZ())
    {
      localObject1 = new com.tencent.mm.pluginsdk.ui.applet.a(this.xkT, new a.a()
      {
        public final void a(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(186585);
          an localan;
          if (paramAnonymousBoolean1)
          {
            com.tencent.mm.ui.base.h.cm(ContactWidgetNewBizInfo.b(ContactWidgetNewBizInfo.this), ContactWidgetNewBizInfo.b(ContactWidgetNewBizInfo.this).getString(2131757607));
            ContactWidgetNewBizInfo.c(ContactWidgetNewBizInfo.this).cT("contact_info_time_expired", true);
            localan = ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this);
            if ((localan != null) && (!bu.isNullOrNil(paramAnonymousString1))) {
              break label379;
            }
            ae.e("MicroMsg.ContactWidgetNewBizInfo", "respUsername == " + paramAnonymousString1 + ", contact = " + localan);
            if (ContactWidgetNewBizInfo.r(ContactWidgetNewBizInfo.this) != null)
            {
              paramAnonymousString1 = new qx();
              ContactWidgetNewBizInfo.r(ContactWidgetNewBizInfo.this).ipN = 4;
              paramAnonymousString1.dGz.dGA = ContactWidgetNewBizInfo.r(ContactWidgetNewBizInfo.this);
              com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousString1);
            }
            paramAnonymousString1 = ag.aGp().Ef(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username);
            paramAnonymousString1.field_status = 1;
            if ((!bu.isNullOrNil(paramAnonymousString1.field_extInfo)) || (bu.isNullOrNil(paramAnonymousString1.field_username)) || (ContactWidgetNewBizInfo.s(ContactWidgetNewBizInfo.this) == null) || (!paramAnonymousString1.field_username.equals(bu.nullAsNil(ContactWidgetNewBizInfo.s(ContactWidgetNewBizInfo.this).field_username)))) {
              break label667;
            }
            ag.aGp().g(ContactWidgetNewBizInfo.s(ContactWidgetNewBizInfo.this));
            label240:
            paramAnonymousBoolean1 = ContactWidgetNewBizInfo.b(ContactWidgetNewBizInfo.this).getIntent().getBooleanExtra("key_biz_profile_stay_after_follow_op", false);
            paramAnonymousBoolean2 = ContactWidgetNewBizInfo.b(ContactWidgetNewBizInfo.this).getIntent().getBooleanExtra("key_start_biz_profile_from_app_brand_profile", false);
            if (!paramAnonymousString1.Kv()) {
              break label678;
            }
            paramAnonymousString1 = new Intent();
            paramAnonymousString1.putExtra("enterprise_biz_name", ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username);
            paramAnonymousString1.putExtra("enterprise_biz_display_name", w.zP(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username));
            paramAnonymousString1.putExtra("enterprise_from_scene", 7);
            paramAnonymousString1.addFlags(67108864);
            com.tencent.mm.br.d.f(ContactWidgetNewBizInfo.b(ContactWidgetNewBizInfo.this), ".ui.conversation.EnterpriseConversationUI", paramAnonymousString1);
          }
          label608:
          for (;;)
          {
            label355:
            ContactWidgetNewBizInfo.b(ContactWidgetNewBizInfo.this).finish();
            label379:
            do
            {
              ContactWidgetNewBizInfo.a(ContactWidgetNewBizInfo.this, 3);
              AppMethodBeat.o(186585);
              return;
              paramAnonymousString2 = null;
              if (com.tencent.mm.model.x.Am(localan.field_username))
              {
                String str = bu.nullAsNil(localan.field_username);
                paramAnonymousString2 = com.tencent.mm.al.g.eX(str);
                if (paramAnonymousString2 != null) {
                  paramAnonymousString2.field_username = paramAnonymousString1;
                }
                ag.aGp().delete(str);
                localan.tu(str);
              }
              localan.setUsername(paramAnonymousString1);
              if ((int)localan.ght == 0)
              {
                bc.aCg();
                com.tencent.mm.model.c.azF().ao(localan);
              }
              if ((int)localan.ght <= 0)
              {
                ae.e("MicroMsg.ContactWidgetNewBizInfo", "addContact : insert contact failed");
                break;
              }
              com.tencent.mm.model.x.B(localan);
              bc.aCg();
              paramAnonymousString1 = com.tencent.mm.model.c.azF().BH(localan.field_username);
              if (paramAnonymousString2 != null)
              {
                ag.aGp().f(paramAnonymousString2);
                break;
              }
              paramAnonymousString2 = com.tencent.mm.al.g.eX(paramAnonymousString1.field_username);
              if ((paramAnonymousString1.fug()) && (com.tencent.mm.al.a.aFH())) {}
              for (int i = 1;; i = 0)
              {
                if ((paramAnonymousString2 != null) && ((!paramAnonymousString2.Kp()) || (i != 0))) {
                  break label608;
                }
                ae.d("MicroMsg.ContactWidgetNewBizInfo", "shouldUpdate");
                au.a.hIG.aJ(paramAnonymousString1.field_username, "");
                com.tencent.mm.aj.c.Dv(paramAnonymousString1.field_username);
                break;
              }
              if ((!paramAnonymousString1.fuk()) || (i != 0)) {
                break;
              }
              ae.d("MicroMsg.ContactWidgetNewBizInfo", "update contact, last check time=%d", new Object[] { Integer.valueOf(paramAnonymousString1.eRm) });
              au.a.hIG.aJ(paramAnonymousString1.field_username, "");
              com.tencent.mm.aj.c.Dv(paramAnonymousString1.field_username);
              break;
              ag.aGp().g(paramAnonymousString1);
              break label240;
              paramAnonymousString1 = new Intent();
              paramAnonymousString1.putExtra("Chat_User", ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username);
              paramAnonymousString1.putExtra("key_has_add_contact", true);
              paramAnonymousString1.putExtra("finish_direct", true);
              if (paramAnonymousBoolean2) {
                paramAnonymousString1.addFlags(268435456);
              }
              y.aUd(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username);
              com.tencent.mm.plugin.profile.b.iUz.d(paramAnonymousString1, ContactWidgetNewBizInfo.b(ContactWidgetNewBizInfo.this));
              if (paramAnonymousBoolean1) {
                break label355;
              }
            } while (!paramAnonymousBoolean2);
          }
        }
      });
      localObject2 = new LinkedList();
      ((LinkedList)localObject2).add(Integer.valueOf(this.jij));
      if (this.cRk != null) {
        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).Fnk = this.cRk;
      }
      if (!bu.isNullOrNil(this.tIA)) {
        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).tIA = this.tIA;
      }
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).Fnq = true;
      String str = this.xkT.getIntent().getStringExtra("url");
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).Fnr = str;
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).otZ = e.a.ace(this.xkT.getIntent().getIntExtra("qbarScene", -1));
      dvx localdvx = new dvx();
      localdvx.FQm = this.xkT.getIntent().getIntExtra("Contact_Sub_Scene", 0);
      localdvx.GvN = this.xkT.getIntent().getStringExtra("Contact_Scene_Note");
      if (!bu.isNullOrNil(str))
      {
        if (bu.isNullOrNil(localdvx.GvN)) {
          localdvx.GvN = str;
        }
        if (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).Xy(str)) {
          localdvx.Ibo = awe(str);
        }
      }
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).Fns = localdvx;
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).a(this.contact.field_username, (LinkedList)localObject2, this.xhu);
      dEG();
      AppMethodBeat.o(27458);
      return;
    }
    ae.d("MicroMsg.ContactWidgetNewBizInfo", "IsHardDevice, bindTicket = %s", new Object[] { localObject1 });
    bc.ajj().a(536, this);
    Object localObject2 = new do();
    ((do)localObject2).dps.dpu = ((String)localObject1);
    ((do)localObject2).dps.opType = 1;
    com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject2);
    Object localObject1 = ((do)localObject2).dpt.dpw;
    localObject2 = this.xkT;
    this.xkT.getString(2131755906);
    this.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject2, this.xkT.getString(2131755936), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(186584);
        bc.ajj().b(536, ContactWidgetNewBizInfo.this);
        paramAnonymousDialogInterface = new do();
        paramAnonymousDialogInterface.dps.opType = 2;
        paramAnonymousDialogInterface.dps.dpw = this.djA;
        com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousDialogInterface);
        AppMethodBeat.o(186584);
      }
    });
    AppMethodBeat.o(27458);
  }
  
  private boolean dDZ()
  {
    AppMethodBeat.i(27462);
    if (this.xkT.getIntent() == null)
    {
      AppMethodBeat.o(27462);
      return false;
    }
    String str1 = this.xkT.getIntent().getStringExtra("device_id");
    String str2 = this.xkT.getIntent().getStringExtra("device_type");
    ds localds = new ds();
    localds.dpD.cVh = str1;
    localds.dpD.dpB = str2;
    com.tencent.mm.sdk.b.a.IvT.l(localds);
    boolean bool = localds.dpE.dpF;
    AppMethodBeat.o(27462);
    return bool;
  }
  
  private void dEC()
  {
    AppMethodBeat.i(27446);
    if (this.xkV != null)
    {
      AppMethodBeat.o(27446);
      return;
    }
    com.tencent.mm.ui.base.preference.h localh = (com.tencent.mm.ui.base.preference.h)this.xkT.getListView().getAdapter();
    if (localh == null)
    {
      ae.e("MicroMsg.ContactWidgetNewBizInfo", "empty adapter");
      AppMethodBeat.o(27446);
      return;
    }
    this.xkV = new com.tencent.mm.plugin.profile.ui.newbizinfo.b.c(this.xkT, this, localh, new String[] { "contact_info_biz_err_msg", "contact_info_footer_space" });
    localh.JNW = this.xkV;
    AppMethodBeat.o(27446);
  }
  
  private void dED()
  {
    AppMethodBeat.i(27448);
    com.tencent.mm.api.c localc2 = com.tencent.mm.al.g.eX(this.contact.field_username);
    this.cRa = null;
    this.cRb = null;
    this.xhj = null;
    com.tencent.mm.api.c localc1;
    if (localc2 != null)
    {
      localc1 = localc2;
      if (localc2.bX(false) != null) {}
    }
    else
    {
      localc1 = localc2;
      if (this.xhk != null)
      {
        localc1 = new com.tencent.mm.api.c();
        localc1.field_username = this.contact.field_username;
        localc1.field_brandFlag = this.xhk.jgj;
        localc1.field_brandIconURL = this.xhk.jgm;
        localc1.field_brandInfo = this.xhk.jgl;
        localc1.field_extInfo = this.xhk.jgk;
        localc1.field_type = localc1.bX(false).getServiceType();
      }
    }
    if ((localc1 != null) && (localc1.field_brandInfo == null) && (localc1.field_extInfo == null) && (this.xhk != null))
    {
      localc1.field_username = this.contact.field_username;
      localc1.field_brandFlag = this.xhk.jgj;
      localc1.field_brandIconURL = this.xhk.jgm;
      localc1.field_brandInfo = this.xhk.jgl;
      localc1.field_extInfo = this.xhk.jgk;
      localc1.field_type = localc1.bX(false).getServiceType();
    }
    if (localc1 != null)
    {
      this.xfE = localc1;
      this.cRa = localc1.KE();
      this.cRb = localc1.bX(false);
      this.xhj = this.cRb.getWxaEntryInfoList();
      if ((this.cRb.KI() != null) && (this.cRb.KI().length() > 0)) {
        this.cRk = this.cRb.KI();
      }
    }
    AppMethodBeat.o(27448);
  }
  
  private boolean dEF()
  {
    boolean bool1 = true;
    AppMethodBeat.i(27453);
    try
    {
      String str = this.cRb.KL();
      boolean bool2 = bu.isNullOrNil(str);
      if (bool2)
      {
        AppMethodBeat.o(27453);
        return false;
      }
      long l = bu.getLong(str, 0L);
      if ((l > 0L) && (l - System.currentTimeMillis() / 1000L < 0L)) {}
      for (;;)
      {
        ae.d("MicroMsg.ContactWidgetNewBizInfo", "isBizAccountTimeExpired:%b", new Object[] { Boolean.valueOf(bool1) });
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
  private void dEG()
  {
    // Byte code:
    //   0: sipush 27459
    //   3: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 159	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo:xkT	Lcom/tencent/mm/plugin/profile/ui/ContactInfoUI;
    //   10: invokevirtual 796	com/tencent/mm/plugin/profile/ui/ContactInfoUI:getIntent	()Landroid/content/Intent;
    //   13: astore 13
    //   15: aload 13
    //   17: ldc_w 1121
    //   20: iconst_0
    //   21: invokevirtual 894	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   24: invokestatic 1126	com/tencent/mm/plugin/profile/ui/newbizinfo/b/g:NM	(I)I
    //   27: istore_1
    //   28: aload 13
    //   30: ldc_w 1128
    //   33: invokevirtual 864	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   36: astore 14
    //   38: aload 13
    //   40: ldc_w 1130
    //   43: invokevirtual 864	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   46: astore 15
    //   48: aload 13
    //   50: ldc_w 1132
    //   53: iconst_0
    //   54: invokevirtual 894	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   57: aload 14
    //   59: invokestatic 1136	com/tencent/mm/plugin/profile/ui/newbizinfo/b/g:bC	(ILjava/lang/String;)I
    //   62: istore_2
    //   63: aload 13
    //   65: ldc_w 647
    //   68: invokevirtual 864	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   71: astore 8
    //   73: aload 13
    //   75: ldc_w 886
    //   78: invokevirtual 864	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   81: astore 12
    //   83: aload 13
    //   85: ldc_w 1138
    //   88: invokevirtual 1142	android/content/Intent:getBundleExtra	(Ljava/lang/String;)Landroid/os/Bundle;
    //   91: astore 10
    //   93: ldc 130
    //   95: astore 9
    //   97: aload 10
    //   99: ifnull +15 -> 114
    //   102: aload 10
    //   104: ldc_w 1144
    //   107: ldc 130
    //   109: invokevirtual 1149	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   112: astore 9
    //   114: aload 13
    //   116: ldc_w 891
    //   119: iconst_m1
    //   120: invokevirtual 894	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   123: invokestatic 900	com/tencent/mm/ui/e$a:ace	(I)I
    //   126: istore_3
    //   127: aload_0
    //   128: getfield 386	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo:contact	Lcom/tencent/mm/storage/an;
    //   131: getfield 391	com/tencent/mm/g/c/aw:field_username	Ljava/lang/String;
    //   134: astore 16
    //   136: aload 9
    //   138: invokestatic 491	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   141: ifne +429 -> 570
    //   144: aload 9
    //   146: invokestatic 1152	com/tencent/mm/sdk/platformtools/bu:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   149: ldc_w 1154
    //   152: invokestatic 1158	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   155: astore 9
    //   157: aload 8
    //   159: astore 10
    //   161: aload 8
    //   163: invokestatic 1152	com/tencent/mm/sdk/platformtools/bu:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   166: ldc_w 1154
    //   169: invokestatic 1158	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   172: astore 8
    //   174: aload 8
    //   176: astore 10
    //   178: aload 12
    //   180: invokestatic 1152	com/tencent/mm/sdk/platformtools/bu:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   183: ldc_w 1154
    //   186: invokestatic 1158	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   189: astore 11
    //   191: aload 11
    //   193: astore 10
    //   195: getstatic 421	com/tencent/mm/plugin/report/service/g:yxI	Lcom/tencent/mm/plugin/report/service/g;
    //   198: sipush 16232
    //   201: bipush 9
    //   203: anewarray 4	java/lang/Object
    //   206: dup
    //   207: iconst_0
    //   208: iload_1
    //   209: invokestatic 246	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   212: aastore
    //   213: dup
    //   214: iconst_1
    //   215: iload_2
    //   216: invokestatic 246	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
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
    //   250: invokestatic 246	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   253: aastore
    //   254: dup
    //   255: bipush 8
    //   257: aload 16
    //   259: aastore
    //   260: invokevirtual 1161	com/tencent/mm/plugin/report/service/g:f	(I[Ljava/lang/Object;)V
    //   263: aload_0
    //   264: getfield 124	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo:xhu	Ljava/lang/String;
    //   267: invokestatic 491	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   270: ifne +16 -> 286
    //   273: getstatic 421	com/tencent/mm/plugin/report/service/g:yxI	Lcom/tencent/mm/plugin/report/service/g;
    //   276: sipush 16697
    //   279: aload_0
    //   280: getfield 124	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo:xhu	Ljava/lang/String;
    //   283: invokevirtual 1165	com/tencent/mm/plugin/report/service/g:kvStat	(ILjava/lang/String;)V
    //   286: aload 13
    //   288: ldc_w 1121
    //   291: iconst_0
    //   292: invokevirtual 894	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   295: istore_1
    //   296: invokestatic 855	java/lang/System:currentTimeMillis	()J
    //   299: ldc2_w 474
    //   302: ldiv
    //   303: l2i
    //   304: i2l
    //   305: lstore 4
    //   307: iload_1
    //   308: sipush 160
    //   311: if_icmpne +147 -> 458
    //   314: aload 13
    //   316: ldc_w 1167
    //   319: lconst_0
    //   320: invokevirtual 1170	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   323: lstore 6
    //   325: getstatic 421	com/tencent/mm/plugin/report/service/g:yxI	Lcom/tencent/mm/plugin/report/service/g;
    //   328: sipush 15721
    //   331: bipush 9
    //   333: anewarray 4	java/lang/Object
    //   336: dup
    //   337: iconst_0
    //   338: aload_0
    //   339: getfield 386	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo:contact	Lcom/tencent/mm/storage/an;
    //   342: getfield 391	com/tencent/mm/g/c/aw:field_username	Ljava/lang/String;
    //   345: aastore
    //   346: dup
    //   347: iconst_1
    //   348: iconst_0
    //   349: invokestatic 246	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   352: aastore
    //   353: dup
    //   354: iconst_2
    //   355: bipush 14
    //   357: invokestatic 246	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   360: aastore
    //   361: dup
    //   362: iconst_3
    //   363: lload 4
    //   365: invokestatic 1175	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   368: aastore
    //   369: dup
    //   370: iconst_4
    //   371: invokestatic 551	com/tencent/mm/storage/y:getSessionId	()I
    //   374: invokestatic 246	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   377: aastore
    //   378: dup
    //   379: iconst_5
    //   380: iconst_0
    //   381: invokestatic 246	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   384: aastore
    //   385: dup
    //   386: bipush 6
    //   388: lload 6
    //   390: invokestatic 1175	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   393: aastore
    //   394: dup
    //   395: bipush 7
    //   397: ldc 130
    //   399: aastore
    //   400: dup
    //   401: bipush 8
    //   403: iconst_1
    //   404: invokestatic 246	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   407: aastore
    //   408: invokevirtual 1161	com/tencent/mm/plugin/report/service/g:f	(I[Ljava/lang/Object;)V
    //   411: getstatic 421	com/tencent/mm/plugin/report/service/g:yxI	Lcom/tencent/mm/plugin/report/service/g;
    //   414: ldc2_w 1176
    //   417: ldc2_w 1178
    //   420: lconst_1
    //   421: iconst_0
    //   422: invokevirtual 427	com/tencent/mm/plugin/report/service/g:idkeyStat	(JJJZ)V
    //   425: sipush 27459
    //   428: invokestatic 192	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   431: return
    //   432: astore 10
    //   434: ldc 130
    //   436: astore 9
    //   438: ldc 233
    //   440: aload 10
    //   442: ldc 130
    //   444: iconst_0
    //   445: anewarray 4	java/lang/Object
    //   448: invokestatic 1183	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   451: aload 12
    //   453: astore 10
    //   455: goto -260 -> 195
    //   458: iload_1
    //   459: sipush 174
    //   462: if_icmpne +88 -> 550
    //   465: getstatic 421	com/tencent/mm/plugin/report/service/g:yxI	Lcom/tencent/mm/plugin/report/service/g;
    //   468: sipush 15721
    //   471: bipush 9
    //   473: anewarray 4	java/lang/Object
    //   476: dup
    //   477: iconst_0
    //   478: aload_0
    //   479: getfield 386	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo:contact	Lcom/tencent/mm/storage/an;
    //   482: getfield 391	com/tencent/mm/g/c/aw:field_username	Ljava/lang/String;
    //   485: aastore
    //   486: dup
    //   487: iconst_1
    //   488: iconst_0
    //   489: invokestatic 246	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   492: aastore
    //   493: dup
    //   494: iconst_2
    //   495: bipush 21
    //   497: invokestatic 246	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   500: aastore
    //   501: dup
    //   502: iconst_3
    //   503: lload 4
    //   505: invokestatic 1175	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   508: aastore
    //   509: dup
    //   510: iconst_4
    //   511: invokestatic 551	com/tencent/mm/storage/y:getSessionId	()I
    //   514: invokestatic 246	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   517: aastore
    //   518: dup
    //   519: iconst_5
    //   520: iconst_0
    //   521: invokestatic 246	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   524: aastore
    //   525: dup
    //   526: bipush 6
    //   528: iconst_0
    //   529: invokestatic 246	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   532: aastore
    //   533: dup
    //   534: bipush 7
    //   536: ldc 130
    //   538: aastore
    //   539: dup
    //   540: bipush 8
    //   542: iconst_3
    //   543: invokestatic 246	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   546: aastore
    //   547: invokevirtual 1161	com/tencent/mm/plugin/report/service/g:f	(I[Ljava/lang/Object;)V
    //   550: sipush 27459
    //   553: invokestatic 192	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   556: return
    //   557: astore 11
    //   559: aload 10
    //   561: astore 8
    //   563: aload 11
    //   565: astore 10
    //   567: goto -129 -> 438
    //   570: ldc 130
    //   572: astore 9
    //   574: aload 12
    //   576: astore 10
    //   578: goto -383 -> 195
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	581	0	this	ContactWidgetNewBizInfo
    //   27	436	1	i	int
    //   62	154	2	j	int
    //   126	124	3	k	int
    //   305	199	4	l1	long
    //   323	66	6	l2	long
    //   71	491	8	localObject1	Object
    //   95	478	9	str1	String
    //   91	147	10	localObject2	Object
    //   432	9	10	localUnsupportedEncodingException1	java.io.UnsupportedEncodingException
    //   453	124	10	localObject3	Object
    //   189	3	11	str2	String
    //   557	7	11	localUnsupportedEncodingException2	java.io.UnsupportedEncodingException
    //   81	494	12	str3	String
    //   13	302	13	localIntent	Intent
    //   36	187	14	str4	String
    //   46	182	15	str5	String
    //   134	124	16	str6	String
    // Exception table:
    //   from	to	target	type
    //   144	157	432	java/io/UnsupportedEncodingException
    //   161	174	557	java/io/UnsupportedEncodingException
    //   178	191	557	java/io/UnsupportedEncodingException
  }
  
  private void initActionBar()
  {
    AppMethodBeat.i(27445);
    this.xkT.setMMTitle(bu.nullAsNil(this.contact.field_nickname));
    this.xkT.setMMTitleColor(0);
    this.xkT.setTitleDividerVis(false);
    this.xkT.setIsDarkActionbarBg(false);
    this.xkT.setActionbarColor(this.xkT.getResources().getColor(2131099650));
    this.xkT.hideActionbarLine();
    this.xkT.setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(186576);
        ContactWidgetNewBizInfo.b(ContactWidgetNewBizInfo.this).onBackPressed();
        AppMethodBeat.o(186576);
        return true;
      }
    }, 2131689490);
    this.xkT.removeAllOptionMenu();
    this.xkT.addIconOptionMenu(1, 2131764452, 2131689494, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(186577);
        ContactWidgetNewBizInfo.d(ContactWidgetNewBizInfo.this);
        AppMethodBeat.o(186577);
        return true;
      }
    });
    this.xkT.addIconOptionMenu(0, "", 2131689493, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(27434);
        paramAnonymousMenuItem = new e(ContactWidgetNewBizInfo.b(ContactWidgetNewBizInfo.this), 1, false);
        paramAnonymousMenuItem.LfS = new n.d()
        {
          public final void onCreateMMMenu(l paramAnonymous2l)
          {
            AppMethodBeat.i(186579);
            if (com.tencent.mm.contact.c.lO(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_type)) {
              if (ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).adB()) {
                if ((y.bOd()) && (com.tencent.mm.al.g.Ep(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username))) {
                  paramAnonymous2l.jM(5, 2131757612);
                }
              }
            }
            for (;;)
            {
              paramAnonymous2l.jM(2, 2131757807);
              paramAnonymous2l.jM(6, 2131757156);
              if (com.tencent.mm.contact.c.lO(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_type)) {
                paramAnonymous2l.jM(3, 2131757623);
              }
              AppMethodBeat.o(186579);
              return;
              paramAnonymous2l.jM(5, 2131761053);
              continue;
              if ((y.bOd()) && (com.tencent.mm.al.g.Ep(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username)))
              {
                paramAnonymous2l.jM(4, 2131757608);
              }
              else
              {
                paramAnonymous2l.jM(4, 2131757877);
                continue;
                if ((int)ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).ght <= 0) {
                  au.a.hIG.a(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username, "", new au.b.a()
                  {
                    public final void p(String paramAnonymous3String, boolean paramAnonymous3Boolean)
                    {
                      AppMethodBeat.i(186578);
                      ae.i("MicroMsg.ContactWidgetNewBizInfo", "onCreateMMMenu Fetch Contact username:%s, succ: %b", new Object[] { paramAnonymous3String, Boolean.valueOf(paramAnonymous3Boolean) });
                      AppMethodBeat.o(186578);
                    }
                  });
                }
              }
            }
          }
        };
        paramAnonymousMenuItem.LfT = new n.e()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(186580);
            switch (paramAnonymous2MenuItem.getItemId())
            {
            default: 
              ae.w("MicroMsg.ContactWidgetNewBizInfo", "default onMMMenuItemSelected err");
            case 2: 
            case 3: 
            case 4: 
            case 5: 
              do
              {
                do
                {
                  AppMethodBeat.o(186580);
                  return;
                  ContactWidgetNewBizInfo.f(ContactWidgetNewBizInfo.this);
                  AppMethodBeat.o(186580);
                  return;
                  ContactWidgetNewBizInfo.g(ContactWidgetNewBizInfo.this);
                  AppMethodBeat.o(186580);
                  return;
                  com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.b(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username, 903, ContactWidgetNewBizInfo.h(ContactWidgetNewBizInfo.this), ContactWidgetNewBizInfo.i(ContactWidgetNewBizInfo.this));
                  com.tencent.mm.model.j.zm(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username);
                  ContactWidgetNewBizInfo.j(ContactWidgetNewBizInfo.this);
                } while ((y.bOd()) && (!com.tencent.mm.al.g.En(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username)));
                com.tencent.mm.ui.base.h.cm(ContactWidgetNewBizInfo.b(ContactWidgetNewBizInfo.this), ContactWidgetNewBizInfo.b(ContactWidgetNewBizInfo.this).getString(2131761054));
                AppMethodBeat.o(186580);
                return;
                com.tencent.mm.model.x.E(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username, true);
                com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.b(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username, 904, ContactWidgetNewBizInfo.h(ContactWidgetNewBizInfo.this), ContactWidgetNewBizInfo.i(ContactWidgetNewBizInfo.this));
                ContactWidgetNewBizInfo.j(ContactWidgetNewBizInfo.this);
              } while ((y.bOd()) && (!com.tencent.mm.al.g.En(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username)));
              com.tencent.mm.ui.base.h.cm(ContactWidgetNewBizInfo.b(ContactWidgetNewBizInfo.this), ContactWidgetNewBizInfo.b(ContactWidgetNewBizInfo.this).getString(2131756644));
              AppMethodBeat.o(186580);
              return;
            }
            ContactWidgetNewBizInfo.k(ContactWidgetNewBizInfo.this);
            AppMethodBeat.o(186580);
          }
        };
        paramAnonymousMenuItem.cPF();
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.b(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username, 600, ContactWidgetNewBizInfo.h(ContactWidgetNewBizInfo.this), ContactWidgetNewBizInfo.i(ContactWidgetNewBizInfo.this));
        AppMethodBeat.o(27434);
        return false;
      }
    });
    AppMethodBeat.o(27445);
  }
  
  final void NE(int paramInt)
  {
    AppMethodBeat.i(27463);
    if ((this.xhs == null) || ((this.jij != 39) && (this.jij != 56) && (this.jij != 35) && (this.jij != 87) && (this.jij != 88) && (this.jij != 89) && (this.jij != 85)))
    {
      ae.d("MicroMsg.ContactWidgetNewBizInfo", "mExtArgs is null or the add contact action is not from biz search.");
      AppMethodBeat.o(27463);
      return;
    }
    if (this.contact == null)
    {
      ae.i("MicroMsg.ContactWidgetNewBizInfo", "contact is null.");
      AppMethodBeat.o(27463);
      return;
    }
    String str2 = this.xhs.getString("Contact_Ext_Args_Search_Id");
    String str3 = bu.nullAsNil(this.xhs.getString("Contact_Ext_Args_Query_String"));
    int j = this.xhs.getInt("Contact_Ext_Args_Index");
    int i;
    switch (this.jij)
    {
    default: 
      i = 0;
      str1 = bu.nullAsNil(this.xhs.getString("Contact_Ext_Extra_Params"));
      str2 = str3 + "," + paramInt + "," + bu.nullAsNil(this.contact.field_username) + "," + j + "," + System.currentTimeMillis() / 1000L + "," + str2 + "," + i;
      if (bu.isNullOrNil(null)) {
        break;
      }
    }
    for (String str1 = str2 + "," + null + "," + str1;; str1 = str2 + ",," + str1)
    {
      ae.v("MicroMsg.ContactWidgetNewBizInfo", "report 10866: %s", new Object[] { str1 });
      com.tencent.mm.plugin.report.service.g.yxI.kvStat(10866, str1);
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
  
  public final long TJ()
  {
    return this.enterTime;
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, an paraman, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(27443);
    if (this.xkT.isFinishing())
    {
      AppMethodBeat.o(27443);
      return true;
    }
    if (paraman != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (bu.nullAsNil(paraman.field_username).length() <= 0) {
        break label374;
      }
      bool = true;
      label52:
      Assert.assertTrue(bool);
      if (paramf == null) {
        break label380;
      }
    }
    label374:
    label380:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      ab(paraman);
      this.screen = paramf;
      this.contact = paraman;
      this.xfQ = paramBoolean;
      this.jij = paramInt;
      this.xht = ((SnsAdClick)this.xkT.getIntent().getParcelableExtra("KSnsAdTag"));
      this.xhu = this.xkT.getIntent().getStringExtra("key_add_contact_report_info");
      this.xho = this.xkT.getIntent().getIntExtra("add_more_friend_search_scene", 0);
      this.xhs = this.xkT.getIntent().getBundleExtra("Contact_Ext_Args");
      this.ouc = this.xkT.getIntent().getStringExtra("key_channel_session_id");
      if (this.xkY)
      {
        this.xkY = false;
        initActionBar();
        this.xkU = a.awg(this.contact.field_username);
        dDW();
        b(paraman.field_username, null);
        paramf = this.xkT.getIntent().getStringExtra("Contact_BIZ_PopupInfoMsg");
        if (!bu.isNullOrNil(paramf))
        {
          this.xkT.getIntent().putExtra("Contact_BIZ_PopupInfoMsg", "");
          com.tencent.mm.ui.base.h.a(this.xkT, paramf, "", this.xkT.getString(2131755835), null);
        }
        if (paraman != null) {
          ag.aGB().DZ(paraman.field_username);
        }
      }
      if (this.xla != null)
      {
        paramf = this.xkT.getListView();
        if (paramf != null) {
          paramf.onRestoreInstanceState(this.xla);
        }
      }
      if ((this.xkT instanceof FragmentActivity))
      {
        this.xkT.getLifecycle().removeObserver(this);
        this.xkT.getLifecycle().addObserver(this);
      }
      AppMethodBeat.o(27443);
      return true;
      bool = false;
      break;
      bool = false;
      break label52;
    }
  }
  
  public final boolean abx(String paramString)
  {
    AppMethodBeat.i(27457);
    if (bu.isNullOrNil(paramString))
    {
      ae.e("MicroMsg.ContactWidgetNewBizInfo", "handleEvent key is null, return");
      AppMethodBeat.o(27457);
      return false;
    }
    ae.i("MicroMsg.ContactWidgetNewBizInfo", "handleEvent key:%s", new Object[] { paramString });
    if ("contact_info_biz_add".endsWith(paramString))
    {
      if (!com.tencent.mm.model.gdpr.c.aDx()) {
        dDY();
      }
      for (;;)
      {
        if (this.xho != 0) {
          com.tencent.mm.plugin.report.service.g.yxI.f(11263, new Object[] { Integer.valueOf(this.xho), this.contact.field_username });
        }
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.b(this.contact.field_username, 200, this.jij, this.enterTime);
        AppMethodBeat.o(27457);
        return true;
        com.tencent.mm.model.gdpr.c.a(this.xkT, com.tencent.mm.model.gdpr.a.hLL, this.contact.field_username, new com.tencent.mm.model.gdpr.b()
        {
          public final void oJ(int paramAnonymousInt)
          {
            AppMethodBeat.i(186583);
            if (paramAnonymousInt == 0) {
              ContactWidgetNewBizInfo.q(ContactWidgetNewBizInfo.this);
            }
            AppMethodBeat.o(186583);
          }
        });
      }
    }
    AppMethodBeat.o(27457);
    return true;
  }
  
  public final boolean agO()
  {
    AppMethodBeat.i(27465);
    if ((this.contact == null) || (this.xfE == null) || (this.xkU == null) || (this.xkU.Gcc == null) || (this.xkU.Gcb == null))
    {
      ae.w("MicroMsg.ContactWidgetNewBizInfo", "reportEnd fail, err");
      this.ohH.dead();
      this.kzS.dead();
      AppMethodBeat.o(27465);
      return false;
    }
    this.endTime = System.currentTimeMillis();
    String str = this.contact.field_username;
    int k = this.jij;
    int m = this.xfE.field_type;
    long l1 = this.enterTime;
    long l2 = this.endTime;
    int i;
    label134:
    int n;
    int i1;
    if (com.tencent.mm.contact.c.lO(this.contact.field_type))
    {
      i = 1;
      n = this.xkU.Gcc.FZd;
      i1 = this.xkU.Gcc.FZe;
      if (this.xhj == null) {
        break label231;
      }
    }
    label231:
    for (int j = this.xhj.size();; j = 0)
    {
      com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.a(str, k, m, l1, l2, i, n, i1, j, com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.b(this.xkU.Gcd), com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.a(this.xkU.Gcg), this.xkU.Gcb.nIJ);
      break;
      i = 0;
      break label134;
    }
  }
  
  public final boolean ceC()
  {
    AppMethodBeat.i(27455);
    if (this.screen == null)
    {
      AppMethodBeat.o(27455);
      return true;
    }
    Object localObject = (NewBizInfoHeaderPreference)this.screen.aXe("contact_info_header_newbizinfo");
    if (localObject != null) {
      ((NewBizInfoHeaderPreference)localObject).onDetach();
    }
    localObject = this.xkT.getListView();
    if (localObject != null) {
      this.xla = ((ListView)localObject).onSaveInstanceState();
    }
    AppMethodBeat.o(27455);
    return true;
  }
  
  public final void cli()
  {
    AppMethodBeat.i(27449);
    if ((this.xkZ) && (this.xkU.Gcd != null) && (this.xkU.Gcd.Gbz != null) && (this.xkU.Gcd.Gbz.GbX == 0)) {
      b(this.contact.field_username, this.xkU.Gcd.Gbz.GbW);
    }
    AppMethodBeat.o(27449);
  }
  
  public final an dEE()
  {
    return this.contact;
  }
  
  public final int dEH()
  {
    return this.jij;
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public void onActivityDestroy()
  {
    AppMethodBeat.i(27444);
    ae.i("MicroMsg.ContactWidgetNewBizInfo", "[onActivityDestroy]");
    ceC();
    AppMethodBeat.o(27444);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(27456);
    if (this.xkT == null)
    {
      ae.e("MicroMsg.ContactWidgetNewBizInfo", "null == context");
      AppMethodBeat.o(27456);
      return;
    }
    ae.i("MicroMsg.ContactWidgetNewBizInfo", "onActivityResult, requestCode = %d, resultCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
      com.tencent.mm.plugin.messenger.a.g.doC().q(str1, str2, bool);
      com.tencent.mm.plugin.messenger.a.g.doC().hW(paramIntent, str2);
      com.tencent.mm.ui.widget.snackbar.b.n(this.xkT, this.xkT.getString(2131759420));
      AppMethodBeat.o(27456);
      return;
    }
    AppMethodBeat.o(27456);
  }
  
  public final boolean onCreate()
  {
    AppMethodBeat.i(27464);
    if ((this.contact == null) || (this.xfE == null))
    {
      ae.w("MicroMsg.ContactWidgetNewBizInfo", "reportStart fail, err");
      this.ohH.alive();
      this.kzS.alive();
      AppMethodBeat.o(27464);
      return false;
    }
    String str = this.contact.field_username;
    int j = this.jij;
    int k = this.xfE.field_type;
    long l = this.enterTime;
    if (com.tencent.mm.contact.c.lO(this.contact.field_type)) {}
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.a(str, j, k, l, i, this.ouc);
      break;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(27461);
    ae.d("MicroMsg.ContactWidgetNewBizInfo", "onSceneEnd errType = " + paramInt1 + ", errCode = " + paramInt2 + ",errMsg = " + paramString);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if (paramn == null)
    {
      ae.e("MicroMsg.ContactWidgetNewBizInfo", "scene == null");
      AppMethodBeat.o(27461);
      return;
    }
    bc.ajj().b(paramn.getType(), this);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ae.e("MicroMsg.ContactWidgetNewBizInfo", "scene.getType() = %s", new Object[] { Integer.valueOf(paramn.getType()) });
      AppMethodBeat.o(27461);
      return;
    }
    ae.d("MicroMsg.ContactWidgetNewBizInfo", "scene.getType() = %s", new Object[] { Integer.valueOf(paramn.getType()) });
    if (paramn.getType() == 536)
    {
      bc.ajj().b(536, this);
      dDW();
    }
    AppMethodBeat.o(27461);
  }
  
  static final class a
    extends com.tencent.mm.sdk.b.c<u>
  {
    private WeakReference<ContactWidgetNewBizInfo> xll;
    
    public a(ContactWidgetNewBizInfo paramContactWidgetNewBizInfo)
    {
      AppMethodBeat.i(186586);
      this.xll = new WeakReference(paramContactWidgetNewBizInfo);
      this.__eventId = u.class.getName().hashCode();
      AppMethodBeat.o(186586);
    }
  }
  
  static final class b
    extends com.tencent.mm.sdk.b.c<mg>
  {
    private WeakReference<ContactWidgetNewBizInfo> xll;
    
    public b(ContactWidgetNewBizInfo paramContactWidgetNewBizInfo)
    {
      AppMethodBeat.i(186588);
      this.xll = new WeakReference(paramContactWidgetNewBizInfo);
      this.__eventId = mg.class.getName().hashCode();
      AppMethodBeat.o(186588);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.ContactWidgetNewBizInfo
 * JD-Core Version:    0.7.0.1
 */