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
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.al.x;
import com.tencent.mm.al.x.a;
import com.tencent.mm.am.ag;
import com.tencent.mm.api.c.a;
import com.tencent.mm.api.c.b;
import com.tencent.mm.g.a.dn;
import com.tencent.mm.g.a.dn.b;
import com.tencent.mm.g.a.dr;
import com.tencent.mm.g.a.dr.b;
import com.tencent.mm.g.a.mf;
import com.tencent.mm.g.a.qw;
import com.tencent.mm.g.a.u;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.b;
import com.tencent.mm.model.as.b.a;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.w;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.profile.ui.ContactInfoUI;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.a.b;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.protocal.protobuf.aah;
import com.tencent.mm.protocal.protobuf.acf;
import com.tencent.mm.protocal.protobuf.cmk;
import com.tencent.mm.protocal.protobuf.dva;
import com.tencent.mm.protocal.protobuf.lz;
import com.tencent.mm.protocal.protobuf.mm;
import com.tencent.mm.protocal.protobuf.mn;
import com.tencent.mm.protocal.protobuf.mo;
import com.tencent.mm.protocal.protobuf.mv;
import com.tencent.mm.protocal.protobuf.ny;
import com.tencent.mm.protocal.protobuf.nz;
import com.tencent.mm.protocal.protobuf.og;
import com.tencent.mm.protocal.protobuf.oh;
import com.tencent.mm.protocal.protobuf.oi;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.y;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.e.a;
import com.tencent.mm.ui.widget.a.e;
import d.o;
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
  implements LifecycleObserver, com.tencent.mm.al.f, com.tencent.mm.pluginsdk.b.b
{
  private static String wVk = "crashFlag";
  private static boolean wVl = false;
  private String cQA;
  private List<c.a> cQq;
  private c.b cQr;
  am contact;
  private long endTime;
  long enterTime;
  private boolean isLoading;
  int jfq;
  private com.tencent.mm.sdk.b.c kwD;
  private WeakReference<ContactWidgetNewBizInfo> nOh;
  private com.tencent.mm.sdk.b.c obT;
  private String ool;
  private com.tencent.mm.ui.base.preference.f screen;
  private com.tencent.mm.ui.base.p tipDialog;
  public String txJ;
  com.tencent.mm.api.c wPN;
  boolean wPZ;
  private String wQe;
  private Bundle wRB;
  SnsAdClick wRC;
  private String wRD;
  private List<WxaAttributes.WxaEntryInfo> wRs;
  private acf wRt;
  private int wRx;
  ContactInfoUI wVc;
  private oi wVd;
  private com.tencent.mm.plugin.profile.ui.newbizinfo.b.c wVe;
  private boolean wVf;
  private int wVg;
  private boolean wVh;
  private boolean wVi;
  private Parcelable wVj;
  
  public ContactWidgetNewBizInfo(final ContactInfoUI paramContactInfoUI, final String paramString, acf paramacf, long paramLong)
  {
    AppMethodBeat.i(193316);
    this.wRx = 0;
    this.wRC = null;
    this.wRD = null;
    this.wVe = null;
    this.nOh = null;
    this.ool = "";
    this.wVf = false;
    this.kwD = new b(this);
    this.obT = new a(this);
    this.wVg = 0;
    this.wVh = true;
    this.isLoading = false;
    this.wVi = false;
    this.tipDialog = null;
    this.nOh = new WeakReference(this);
    this.wVc = paramContactInfoUI;
    this.wQe = paramString;
    this.wRt = paramacf;
    this.enterTime = paramLong;
    paramString = paramContactInfoUI.getListView();
    dBl();
    paramString.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(193300);
        if (ContactWidgetNewBizInfo.c(ContactWidgetNewBizInfo.this) != null)
        {
          paramAnonymousAbsListView = (NewBizInfoHeaderPreference)ContactWidgetNewBizInfo.c(ContactWidgetNewBizInfo.this).aVD("contact_info_header_newbizinfo");
          if (paramAnonymousAbsListView != null)
          {
            int[] arrayOfInt = new int[2];
            if (paramAnonymousAbsListView.wVC == null) {}
            for (paramAnonymousInt1 = 0; paramAnonymousInt1 < 0; paramAnonymousInt1 = arrayOfInt[1])
            {
              paramAnonymousInt2 = paramAnonymousAbsListView.wVE.getMeasuredHeight();
              float f = (paramAnonymousInt1 + paramAnonymousInt2 - this.wVn) / paramAnonymousInt2;
              paramContactInfoUI.setMMTitleColor(paramContactInfoUI.getResources().getColor(2131099732));
              paramContactInfoUI.setTitleAlpha(1.0F - f);
              AppMethodBeat.o(193300);
              return;
              paramAnonymousAbsListView.wVC.getLocationInWindow(arrayOfInt);
            }
            if (paramAnonymousInt1 == 0)
            {
              if (paramAnonymousAbsListView.wVC == null) {}
              for (boolean bool = false; !bool; bool = paramAnonymousAbsListView.wVC.isAttachedToWindow())
              {
                paramContactInfoUI.setMMTitleColor(paramContactInfoUI.getResources().getColor(2131099732));
                AppMethodBeat.o(193300);
                return;
              }
            }
            paramContactInfoUI.setMMTitleColor(0);
          }
        }
        AppMethodBeat.o(193300);
      }
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(193299);
        ArrayList localArrayList;
        if ((paramAnonymousInt == 0) && (ContactWidgetNewBizInfo.a(ContactWidgetNewBizInfo.this) != null))
        {
          paramAnonymousAbsListView = ContactWidgetNewBizInfo.a(ContactWidgetNewBizInfo.this);
          paramAnonymousInt = paramString.getFirstVisiblePosition();
          int i = paramString.getLastVisiblePosition();
          if (paramAnonymousAbsListView.dBw().zc(16))
          {
            int j = paramAnonymousAbsListView.dBv();
            int k = paramAnonymousAbsListView.wWD;
            localArrayList = new ArrayList();
            if (paramAnonymousInt <= i) {
              for (;;)
              {
                if (paramAnonymousAbsListView.Nd(paramAnonymousInt))
                {
                  int n = paramAnonymousInt + (j - k);
                  if (paramAnonymousAbsListView.wWB.MZ(n) == a.b.wWr)
                  {
                    Object localObject1 = paramAnonymousAbsListView.wWB.getItem(n);
                    if (localObject1 == null)
                    {
                      paramAnonymousAbsListView = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizMessage");
                      AppMethodBeat.o(193299);
                      throw paramAnonymousAbsListView;
                    }
                    localObject1 = (ny)localObject1;
                    Object localObject2 = paramAnonymousAbsListView.wWI.contact;
                    d.g.b.p.g(localObject2, "widget.contact");
                    localObject2 = ((aw)localObject2).field_username;
                    long l = paramAnonymousAbsListView.wWI.enterTime;
                    int m = paramAnonymousAbsListView.wWI.jfq;
                    n /= 2;
                    if (((ny)localObject1).FIT.ugm == 49)
                    {
                      localObject3 = ((ny)localObject1).FIY.FGu;
                      d.g.b.p.g(localObject3, "bizMessage.AppMsg.DetailInfo");
                      Object localObject4 = (Iterable)localObject3;
                      localObject3 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject4, 10));
                      localObject4 = ((Iterable)localObject4).iterator();
                      Object localObject5;
                      while (((Iterator)localObject4).hasNext())
                      {
                        localObject5 = (mn)((Iterator)localObject4).next();
                        ((Collection)localObject3).add(d.a.j.listOf(new String[] { ((mn)localObject5).FFW, String.valueOf(((mn)localObject5).hCZ) }));
                      }
                      localArrayList.addAll((Collection)localObject3);
                      localObject3 = ((ny)localObject1).FIY.FGu;
                      d.g.b.p.g(localObject3, "bizMessage.AppMsg.DetailInfo");
                      localObject3 = ((Iterable)localObject3).iterator();
                      while (((Iterator)localObject3).hasNext())
                      {
                        localObject4 = (mn)((Iterator)localObject3).next();
                        localObject5 = com.tencent.mm.plugin.profile.ui.newbizinfo.c.d.wXZ;
                        d.g.b.p.g(localObject2, "userName");
                        com.tencent.mm.plugin.profile.ui.newbizinfo.c.d.a((String)localObject2, l, ((ny)localObject1).FIY.FGt.FFS, ((mn)localObject4).FFV, ((mn)localObject4).hCZ, n, ((ny)localObject1).FIY.FGt.CreateTime, m);
                      }
                    }
                    Object localObject3 = com.tencent.mm.plugin.profile.ui.newbizinfo.c.d.wXZ;
                    d.g.b.p.g(localObject2, "userName");
                    com.tencent.mm.plugin.profile.ui.newbizinfo.c.d.a((String)localObject2, l, ((ny)localObject1).FIT.xbr, 0, -1, n, ((ny)localObject1).FIT.FZg, m);
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
            paramAnonymousAbsListView.dBw().j((List)localArrayList, 126);
          }
          AppMethodBeat.o(193299);
          return;
        }
      }
    });
    AppMethodBeat.o(193316);
  }
  
  /* Error */
  private void U(am paramam)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 195
    //   4: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: ifnull +9 -> 17
    //   11: getstatic 106	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo:wVl	Z
    //   14: ifeq +11 -> 25
    //   17: ldc 195
    //   19: invokestatic 192	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: iconst_1
    //   26: putstatic 106	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo:wVl	Z
    //   29: ldc 197
    //   31: invokestatic 203	com/tencent/mm/sdk/platformtools/ax:aQA	(Ljava/lang/String;)Lcom/tencent/mm/sdk/platformtools/ax;
    //   34: astore_2
    //   35: aload_2
    //   36: getstatic 104	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo:wVk	Ljava/lang/String;
    //   39: iconst_0
    //   40: invokevirtual 207	com/tencent/mm/sdk/platformtools/ax:decodeBool	(Ljava/lang/String;Z)Z
    //   43: ifeq +29 -> 72
    //   46: ldc 209
    //   48: ldc 211
    //   50: invokestatic 216	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   53: getstatic 222	com/tencent/mm/plugin/report/service/g:yhR	Lcom/tencent/mm/plugin/report/service/g;
    //   56: ldc2_w 223
    //   59: lconst_0
    //   60: lconst_1
    //   61: iconst_0
    //   62: invokevirtual 228	com/tencent/mm/plugin/report/service/g:idkeyStat	(JJJZ)V
    //   65: aload_1
    //   66: getfield 233	com/tencent/mm/g/c/aw:field_username	Ljava/lang/String;
    //   69: invokestatic 239	com/tencent/mm/plugin/profile/ui/newbizinfo/a:clear	(Ljava/lang/String;)V
    //   72: aload_2
    //   73: getstatic 104	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo:wVk	Ljava/lang/String;
    //   76: iconst_1
    //   77: invokevirtual 242	com/tencent/mm/sdk/platformtools/ax:encode	(Ljava/lang/String;Z)Z
    //   80: pop
    //   81: ldc 209
    //   83: ldc 244
    //   85: invokestatic 216	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: getstatic 249	com/tencent/mm/sdk/platformtools/i:DEBUG	Z
    //   91: ifne +15 -> 106
    //   94: getstatic 252	com/tencent/mm/sdk/platformtools/i:IS_FLAVOR_RED	Z
    //   97: ifne +9 -> 106
    //   100: invokestatic 258	com/tencent/mm/sdk/platformtools/bu:flY	()Z
    //   103: ifeq +22 -> 125
    //   106: aload_2
    //   107: ldc_w 260
    //   110: iconst_0
    //   111: invokevirtual 264	com/tencent/mm/sdk/platformtools/ax:decodeInt	(Ljava/lang/String;I)I
    //   114: iconst_1
    //   115: if_icmpne +10 -> 125
    //   118: ldc_w 266
    //   121: iconst_0
    //   122: invokestatic 272	junit/framework/Assert:assertTrue	(Ljava/lang/String;Z)V
    //   125: getstatic 278	com/tencent/e/h:LTJ	Lcom/tencent/e/i;
    //   128: new 16	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo$2
    //   131: dup
    //   132: aload_0
    //   133: aload_2
    //   134: invokespecial 281	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo$2:<init>	(Lcom/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo;Lcom/tencent/mm/sdk/platformtools/ax;)V
    //   137: ldc2_w 282
    //   140: invokeinterface 289 4 0
    //   145: pop
    //   146: ldc 195
    //   148: invokestatic 192	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   151: goto -129 -> 22
    //   154: astore_1
    //   155: aload_0
    //   156: monitorexit
    //   157: aload_1
    //   158: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	this	ContactWidgetNewBizInfo
    //   0	159	1	paramam	am
    //   34	100	2	localax	ax
    // Exception table:
    //   from	to	target	type
    //   2	7	154	finally
    //   11	17	154	finally
    //   17	22	154	finally
    //   25	72	154	finally
    //   72	106	154	finally
    //   106	125	154	finally
    //   125	151	154	finally
  }
  
  private void a(oi paramoi)
  {
    AppMethodBeat.i(169758);
    if (paramoi == null)
    {
      AppMethodBeat.o(169758);
      return;
    }
    if (paramoi.FJK != null)
    {
      com.tencent.mm.plugin.brandservice.b.c.F(paramoi.FJK.GAI, true);
      boolean bool = paramoi.FJK.GAI;
      if (paramoi.FJK.HfM != null)
      {
        i = paramoi.FJK.HfM.size();
        ad.i("MicroMsg.ContactWidgetNewBizInfo", "alvinluo updateProfileInfo %b, size: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
      }
    }
    label90:
    com.tencent.mm.plugin.profile.ui.newbizinfo.b.c localc;
    cmk localcmk;
    com.tencent.mm.plugin.profile.ui.newbizinfo.b.a locala;
    for (;;)
    {
      if (paramoi.FJE != null)
      {
        dBl();
        if (this.wVe != null)
        {
          localc = this.wVe;
          Object localObject1 = paramoi.FJE;
          localcmk = paramoi.FJK;
          d.g.b.p.h(localObject1, "msgList");
          locala = localc.wWB;
          d.g.b.p.h(localObject1, "msgList");
          locala.fVg.clear();
          d.g.b.p.g(Calendar.getInstance(), "Calendar.getInstance()");
          new Date();
          Object localObject2 = ((nz)localObject1).FIZ;
          d.g.b.p.g(localObject2, "msgList.Msg");
          localObject2 = ((Iterable)localObject2).iterator();
          for (;;)
          {
            if (((Iterator)localObject2).hasNext())
            {
              ny localny = (ny)((Iterator)localObject2).next();
              locala.fVg.add(new o(a.b.wWq, localny));
              locala.fVg.add(new o(a.b.wWr, localny));
              continue;
              i = -1;
              break;
              ad.e("MicroMsg.ContactWidgetNewBizInfo", "alvinluo updateProfileInfo videochannel_notify_info is null");
              break label90;
            }
          }
          localObject1 = ((nz)localObject1).FJa;
          if ((localObject1 != null) && (((og)localObject1).FJy == 0)) {
            locala.fVg.add(new o(a.b.wWs, new ny()));
          }
          locala = localc.wWB;
          if ((localcmk != null) && (com.tencent.mm.plugin.brandservice.b.c.bNw()))
          {
            localObject1 = localcmk.HfM;
            d.g.b.p.g(localObject1, "notifyInfo.notify_list");
            if (((Collection)localObject1).isEmpty()) {
              break label504;
            }
          }
        }
      }
    }
    label504:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        ad.i("MicroMsg.BizMessageAdapter", "alvinluo updateHeader add video channel");
        locala.wWh.clear();
        locala.wWh.add(new o(a.b.wWt, localcmk));
      }
      localc.wWJ.notifyDataSetChanged();
      if ((!this.wVf) && (paramoi.FJK != null) && (paramoi.FJK.HfM != null) && (paramoi.FJK.HfM.size() > 0) && (com.tencent.mm.plugin.brandservice.b.c.bNw()))
      {
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.b(this.contact.field_username, 1401, this.jfq, this.enterTime);
        this.wVf = true;
      }
      AppMethodBeat.o(169758);
      return;
    }
  }
  
  private static int auP(String paramString)
  {
    int j = 10000;
    AppMethodBeat.i(27460);
    int i = j;
    if (!bt.isNullOrNil(paramString)) {}
    try
    {
      i = bt.getInt(Uri.parse(paramString).getQueryParameter("scene"), 10000);
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
  
  private void b(String paramString, final com.tencent.mm.bx.b paramb)
  {
    AppMethodBeat.i(27450);
    if (this.isLoading)
    {
      ad.i("MicroMsg.ContactWidgetNewBizInfo", "not obtailBizInfoFromCgi, use cache");
      AppMethodBeat.o(27450);
      return;
    }
    this.isLoading = true;
    Object localObject = new b.a();
    ((b.a)localObject).funcId = 2656;
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/bizattr/bizprofilev2";
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    oh localoh = new oh();
    localoh.FGE = paramString;
    if (paramb != null)
    {
      localoh.FJz = 1;
      localoh.FJx = paramb;
      localoh.FJA = 20;
      localoh.Scene = this.jfq;
      localoh.FJB = y.getSessionId();
      ((b.a)localObject).hNM = localoh;
      ((b.a)localObject).hNN = new oi();
      localObject = ((b.a)localObject).aDC();
      paramb = new x.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb, n paramAnonymousn)
        {
          AppMethodBeat.i(193308);
          ad.i("MicroMsg.ContactWidgetNewBizInfo", "callback, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          paramAnonymousString = (oi)paramAnonymousb.hNL.hNQ;
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousString != null))
          {
            paramAnonymousb = a.wWg;
            a.a(paramAnonymousString.FJE);
            if (paramb == null) {
              break label386;
            }
            if ((!paramb.equals(ContactWidgetNewBizInfo.l(ContactWidgetNewBizInfo.this).FJE.FJa.FJx)) || (paramAnonymousString.FJE == null)) {
              break label376;
            }
            ContactWidgetNewBizInfo.l(ContactWidgetNewBizInfo.this).FJE.FIZ.addAll(paramAnonymousString.FJE.FIZ);
            ContactWidgetNewBizInfo.l(ContactWidgetNewBizInfo.this).FJE.FJa = paramAnonymousString.FJE.FJa;
            if (paramb == null) {
              break label422;
            }
            if ((ContactWidgetNewBizInfo.l(ContactWidgetNewBizInfo.this) != null) && (ContactWidgetNewBizInfo.l(ContactWidgetNewBizInfo.this).FJE != null))
            {
              ContactWidgetNewBizInfo.a(ContactWidgetNewBizInfo.this, ContactWidgetNewBizInfo.l(ContactWidgetNewBizInfo.this));
              com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.b(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username, 106, ContactWidgetNewBizInfo.h(ContactWidgetNewBizInfo.this), ContactWidgetNewBizInfo.i(ContactWidgetNewBizInfo.this));
            }
            label227:
            if ((paramAnonymousString.FGO & 0x4) == 0) {
              break label449;
            }
            paramAnonymousb = ContactWidgetNewBizInfo.c(4, paramAnonymousString.FJI);
            if (paramAnonymousb == null) {
              break label449;
            }
            paramAnonymousn = (NewBizInfoErrMsgPreference)ContactWidgetNewBizInfo.c(ContactWidgetNewBizInfo.this).aVD("contact_info_biz_err_msg");
            ContactWidgetNewBizInfo.c(ContactWidgetNewBizInfo.this).cP("contact_info_biz_err_msg", false);
            paramAnonymousn.setErrMsg(paramAnonymousb);
          }
          for (;;)
          {
            for (;;)
            {
              if ((paramAnonymousString.FGO & 0x2) != 0)
              {
                paramAnonymousString = (NewBizInfoHeaderPreference)ContactWidgetNewBizInfo.c(ContactWidgetNewBizInfo.this).aVD("contact_info_header_newbizinfo");
                paramAnonymousString.wVG = true;
                if (paramAnonymousString.fRd != null)
                {
                  com.tencent.mm.plugin.brandservice.b.d.a(paramAnonymousString.fRd, paramAnonymousString.contact, "", true);
                  paramAnonymousString.fRd.setClickable(false);
                }
              }
              ContactWidgetNewBizInfo.o(ContactWidgetNewBizInfo.this);
              ContactWidgetNewBizInfo.p(ContactWidgetNewBizInfo.this);
              AppMethodBeat.o(193308);
              return 0;
              label376:
              ad.e("MicroMsg.ContactWidgetNewBizInfo", "drop err resp");
              break;
              try
              {
                label386:
                ContactWidgetNewBizInfo.l(ContactWidgetNewBizInfo.this).parseFrom(paramAnonymousString.toByteArray());
              }
              catch (IOException paramAnonymousb)
              {
                ad.printErrStackTrace("MicroMsg.ContactWidgetNewBizInfo", paramAnonymousb, "profileInfo.parseFrom", new Object[0]);
              }
            }
            break;
            label422:
            a.b(ContactWidgetNewBizInfo.l(ContactWidgetNewBizInfo.this));
            ContactWidgetNewBizInfo.m(ContactWidgetNewBizInfo.this);
            ContactWidgetNewBizInfo.n(ContactWidgetNewBizInfo.this);
            break label227;
            label449:
            if ((paramAnonymousString.FGO & 0x8) != 0)
            {
              paramAnonymousb = ContactWidgetNewBizInfo.c(8, paramAnonymousString.FJI);
              if (paramAnonymousb != null)
              {
                paramAnonymousn = (NewBizInfoErrMsgPreference)ContactWidgetNewBizInfo.c(ContactWidgetNewBizInfo.this).aVD("contact_info_biz_err_msg");
                ContactWidgetNewBizInfo.c(ContactWidgetNewBizInfo.this).cP("contact_info_biz_err_msg", false);
                paramAnonymousn.setErrMsg(paramAnonymousb);
                continue;
              }
            }
            ContactWidgetNewBizInfo.c(ContactWidgetNewBizInfo.this).cP("contact_info_biz_err_msg", true);
          }
        }
      };
      if (!(this.wVc instanceof com.tencent.mm.vending.e.b)) {
        break label197;
      }
    }
    label197:
    for (paramString = this.wVc;; paramString = null)
    {
      x.a((com.tencent.mm.al.b)localObject, paramb, false, paramString);
      AppMethodBeat.o(27450);
      return;
      localoh.FJz = 0;
      localoh.FJA = 5;
      break;
    }
  }
  
  private boolean bTJ()
  {
    AppMethodBeat.i(27452);
    if ((this.wVd != null) && (this.wVd.FJC != null) && (this.wVd.FJC.FEN == 0) && (!dBo()))
    {
      AppMethodBeat.o(27452);
      return true;
    }
    AppMethodBeat.o(27452);
    return false;
  }
  
  private void dAF()
  {
    AppMethodBeat.i(27451);
    cdn();
    dBm();
    this.screen.removeAll();
    this.screen.addPreferencesFromResource(2131951647);
    Object localObject = (NewBizInfoHeaderPreference)this.screen.aVD("contact_info_header_newbizinfo");
    if ((localObject != null) && (!bt.isNullOrNil(this.contact.field_username)))
    {
      ((NewBizInfoHeaderPreference)localObject).a(this.contact, this.wQe, this.wPN, this.wVd);
      this.wVi = true;
      if (this.wVd == null) {
        break label598;
      }
      if (!com.tencent.mm.o.b.lM(this.contact.field_type)) {
        break label567;
      }
      this.screen.cP("contact_info_biz_add", true);
      this.screen.cP("contact_info_biz_go_chatting", false);
      ((NewBizInfoFollowPreference)this.screen.aVD("contact_info_biz_go_chatting")).wPY = this;
      label161:
      if ((this.wVd != null) && (this.wVd.FJC != null) && (this.wVd.FJE != null) && (this.wVd.FJE.FJa != null)) {
        a(this.wVd);
      }
      if ((this.wVd != null) && (!bTJ()) && (!com.tencent.mm.o.b.lM(this.contact.field_type))) {
        this.wVc.showOptionMenu(false);
      }
      if ((this.wVd == null) || (this.wVd.FJH == null)) {
        break label643;
      }
      this.screen.cP("contact_info_biz_menu_newbizinfo", false);
      if (this.wVd != null) {
        ((NewBizInfoMenuPreference)this.screen.aVD("contact_info_biz_menu_newbizinfo")).a(this.wVd.FJH, this.contact, this.jfq, this.enterTime);
      }
    }
    for (;;)
    {
      this.screen.cP("contact_info_biz_err_msg", true);
      ad.d("MicroMsg.ContactWidgetNewBizInfo", "KIsardDevice(%b)", new Object[] { Boolean.valueOf(this.wVc.getIntent().getBooleanExtra("KIsHardDevice", false)) });
      if ((this.wVc.getIntent() == null) || (!this.wVc.getIntent().getBooleanExtra("KIsHardDevice", false))) {
        break label681;
      }
      ad.d("MicroMsg.ContactWidgetNewBizInfo", "Hard device biz...");
      boolean bool = dAI();
      ad.d("MicroMsg.ContactWidgetNewBizInfo", "contact.isContact()(%b), isHarDeviceBound(%b)", new Object[] { Boolean.valueOf(com.tencent.mm.o.b.lM(this.contact.field_type)), Boolean.valueOf(bool) });
      if ((com.tencent.mm.o.b.lM(this.contact.field_type)) && (bool)) {
        break label674;
      }
      ad.w("MicroMsg.ContactWidgetNewBizInfo", "%s is not my hard biz contact", new Object[] { this.contact.field_username });
      dAG();
      localObject = (NewBizInfoNotFollowPreference)this.screen.aVD("contact_info_biz_add");
      this.screen.cP("contact_info_biz_add", false);
      if (localObject == null) {
        break label674;
      }
      if (!bool) {
        break label660;
      }
      ((NewBizInfoNotFollowPreference)localObject).setTitle(this.wVc.getString(2131757610));
      AppMethodBeat.o(27451);
      return;
      ad.w("MicroMsg.ContactWidgetNewBizInfo", "head pref is null");
      this.screen.cP("contact_info_header_bizinfo", true);
      break;
      label567:
      this.screen.cP("contact_info_biz_add", false);
      this.screen.cP("contact_info_biz_go_chatting", true);
      break label161;
      label598:
      this.screen.cP("contact_info_biz_add", true);
      this.screen.cP("contact_info_biz_go_chatting", true);
      this.screen.cP("contact_info_biz_space", false);
      break label161;
      label643:
      this.screen.cP("contact_info_biz_menu_newbizinfo", true);
    }
    label660:
    ((NewBizInfoNotFollowPreference)localObject).setTitle(this.wVc.getString(2131757596));
    label674:
    AppMethodBeat.o(27451);
    return;
    label681:
    if (dBo())
    {
      this.screen.cP("contact_info_biz_loading", false);
      this.screen.cP("contact_info_biz_add", true);
      this.screen.cP("contact_info_biz_go_chatting", true);
      this.screen.cP("contact_info_message_newbizinfo", true);
    }
    AppMethodBeat.o(27451);
  }
  
  private void dAG()
  {
    AppMethodBeat.i(27454);
    if ((this.contact != null) && ((w.Al(this.contact.field_username)) || (w.Ax(this.contact.field_username))) && (com.tencent.mm.o.b.lM(this.contact.field_type)))
    {
      this.screen.cP("contact_info_biz_go_chatting", false);
      AppMethodBeat.o(27454);
      return;
    }
    this.screen.cP("contact_info_biz_go_chatting", true);
    AppMethodBeat.o(27454);
  }
  
  private void dAH()
  {
    AppMethodBeat.i(27458);
    if ((NewBizInfoHeaderPreference)this.screen.aVD("contact_info_header_newbizinfo") != null) {
      NewBizInfoHeaderPreference.yy(System.currentTimeMillis());
    }
    if ((this.wVc.getIntent() != null) && (this.wVc.getIntent().getBooleanExtra("KIsHardDevice", false)))
    {
      localObject1 = this.wVc.getIntent().getStringExtra("KHardDeviceBindTicket");
      if (!bt.isNullOrNil((String)localObject1)) {
        break label334;
      }
      ad.i("MicroMsg.ContactWidgetNewBizInfo", "bindTicket is null, means it is not switch from QRcode scan, just add contact");
    }
    label334:
    while (dAI())
    {
      localObject1 = new com.tencent.mm.pluginsdk.ui.applet.a(this.wVc, new a.a()
      {
        public final void a(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(193311);
          am localam;
          if (paramAnonymousBoolean1)
          {
            com.tencent.mm.ui.base.h.cl(ContactWidgetNewBizInfo.b(ContactWidgetNewBizInfo.this), ContactWidgetNewBizInfo.b(ContactWidgetNewBizInfo.this).getString(2131757607));
            ContactWidgetNewBizInfo.c(ContactWidgetNewBizInfo.this).cP("contact_info_time_expired", true);
            localam = ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this);
            if ((localam != null) && (!bt.isNullOrNil(paramAnonymousString1))) {
              break label379;
            }
            ad.e("MicroMsg.ContactWidgetNewBizInfo", "respUsername == " + paramAnonymousString1 + ", contact = " + localam);
            if (ContactWidgetNewBizInfo.r(ContactWidgetNewBizInfo.this) != null)
            {
              paramAnonymousString1 = new qw();
              ContactWidgetNewBizInfo.r(ContactWidgetNewBizInfo.this).imT = 4;
              paramAnonymousString1.dFu.dFv = ContactWidgetNewBizInfo.r(ContactWidgetNewBizInfo.this);
              com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousString1);
            }
            paramAnonymousString1 = ag.aFZ().DD(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username);
            paramAnonymousString1.field_status = 1;
            if ((!bt.isNullOrNil(paramAnonymousString1.field_extInfo)) || (bt.isNullOrNil(paramAnonymousString1.field_username)) || (ContactWidgetNewBizInfo.s(ContactWidgetNewBizInfo.this) == null) || (!paramAnonymousString1.field_username.equals(bt.nullAsNil(ContactWidgetNewBizInfo.s(ContactWidgetNewBizInfo.this).field_username)))) {
              break label667;
            }
            ag.aFZ().g(ContactWidgetNewBizInfo.s(ContactWidgetNewBizInfo.this));
            label240:
            paramAnonymousBoolean1 = ContactWidgetNewBizInfo.b(ContactWidgetNewBizInfo.this).getIntent().getBooleanExtra("key_biz_profile_stay_after_follow_op", false);
            paramAnonymousBoolean2 = ContactWidgetNewBizInfo.b(ContactWidgetNewBizInfo.this).getIntent().getBooleanExtra("key_start_biz_profile_from_app_brand_profile", false);
            if (!paramAnonymousString1.Kn()) {
              break label678;
            }
            paramAnonymousString1 = new Intent();
            paramAnonymousString1.putExtra("enterprise_biz_name", ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username);
            paramAnonymousString1.putExtra("enterprise_biz_display_name", com.tencent.mm.model.v.zf(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username));
            paramAnonymousString1.putExtra("enterprise_from_scene", 7);
            paramAnonymousString1.addFlags(67108864);
            com.tencent.mm.bs.d.f(ContactWidgetNewBizInfo.b(ContactWidgetNewBizInfo.this), ".ui.conversation.EnterpriseConversationUI", paramAnonymousString1);
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
              AppMethodBeat.o(193311);
              return;
              paramAnonymousString2 = null;
              if (w.zC(localam.field_username))
              {
                String str = bt.nullAsNil(localam.field_username);
                paramAnonymousString2 = com.tencent.mm.am.g.eS(str);
                if (paramAnonymousString2 != null) {
                  paramAnonymousString2.field_username = paramAnonymousString1;
                }
                ag.aFZ().delete(str);
                localam.sZ(str);
              }
              localam.setUsername(paramAnonymousString1);
              if ((int)localam.gfj == 0)
              {
                ba.aBQ();
                com.tencent.mm.model.c.azp().ah(localam);
              }
              if ((int)localam.gfj <= 0)
              {
                ad.e("MicroMsg.ContactWidgetNewBizInfo", "addContact : insert contact failed");
                break;
              }
              w.u(localam);
              ba.aBQ();
              paramAnonymousString1 = com.tencent.mm.model.c.azp().Bf(localam.field_username);
              if (paramAnonymousString2 != null)
              {
                ag.aFZ().f(paramAnonymousString2);
                break;
              }
              paramAnonymousString2 = com.tencent.mm.am.g.eS(paramAnonymousString1.field_username);
              if ((paramAnonymousString1.fqg()) && (com.tencent.mm.am.a.aFr())) {}
              for (int i = 1;; i = 0)
              {
                if ((paramAnonymousString2 != null) && ((!paramAnonymousString2.Kh()) || (i != 0))) {
                  break label608;
                }
                ad.d("MicroMsg.ContactWidgetNewBizInfo", "shouldUpdate");
                as.a.hFO.aI(paramAnonymousString1.field_username, "");
                com.tencent.mm.ak.c.CT(paramAnonymousString1.field_username);
                break;
              }
              if ((!paramAnonymousString1.fqk()) || (i != 0)) {
                break;
              }
              ad.d("MicroMsg.ContactWidgetNewBizInfo", "update contact, last check time=%d", new Object[] { Integer.valueOf(paramAnonymousString1.ePB) });
              as.a.hFO.aI(paramAnonymousString1.field_username, "");
              com.tencent.mm.ak.c.CT(paramAnonymousString1.field_username);
              break;
              ag.aFZ().g(paramAnonymousString1);
              break label240;
              paramAnonymousString1 = new Intent();
              paramAnonymousString1.putExtra("Chat_User", ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username);
              paramAnonymousString1.putExtra("key_has_add_contact", true);
              paramAnonymousString1.putExtra("finish_direct", true);
              if (paramAnonymousBoolean2) {
                paramAnonymousString1.addFlags(268435456);
              }
              y.aSF(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username);
              com.tencent.mm.plugin.profile.b.iRG.d(paramAnonymousString1, ContactWidgetNewBizInfo.b(ContactWidgetNewBizInfo.this));
              if (paramAnonymousBoolean1) {
                break label355;
              }
            } while (!paramAnonymousBoolean2);
          }
        }
      });
      localObject2 = new LinkedList();
      ((LinkedList)localObject2).add(Integer.valueOf(this.jfq));
      if (this.cQA != null) {
        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).EUP = this.cQA;
      }
      if (!bt.isNullOrNil(this.txJ)) {
        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).txJ = this.txJ;
      }
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).EUV = true;
      String str = this.wVc.getIntent().getStringExtra("url");
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).EUW = str;
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).ooi = e.a.abw(this.wVc.getIntent().getIntExtra("qbarScene", -1));
      dva localdva = new dva();
      localdva.FxO = this.wVc.getIntent().getIntExtra("Contact_Sub_Scene", 0);
      localdva.Gdg = this.wVc.getIntent().getStringExtra("Contact_Scene_Note");
      if (!bt.isNullOrNil(str))
      {
        if (bt.isNullOrNil(localdva.Gdg)) {
          localdva.Gdg = str;
        }
        if (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).WM(str)) {
          localdva.HHB = auP(str);
        }
      }
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).EUX = localdva;
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).a(this.contact.field_username, (LinkedList)localObject2, this.wRD);
      dBp();
      AppMethodBeat.o(27458);
      return;
    }
    ad.d("MicroMsg.ContactWidgetNewBizInfo", "IsHardDevice, bindTicket = %s", new Object[] { localObject1 });
    ba.aiU().a(536, this);
    Object localObject2 = new dn();
    ((dn)localObject2).don.dop = ((String)localObject1);
    ((dn)localObject2).don.opType = 1;
    com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject2);
    Object localObject1 = ((dn)localObject2).doo.dor;
    localObject2 = this.wVc;
    this.wVc.getString(2131755906);
    this.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject2, this.wVc.getString(2131755936), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(193310);
        ba.aiU().b(536, ContactWidgetNewBizInfo.this);
        paramAnonymousDialogInterface = new dn();
        paramAnonymousDialogInterface.don.opType = 2;
        paramAnonymousDialogInterface.don.dor = this.diy;
        com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousDialogInterface);
        AppMethodBeat.o(193310);
      }
    });
    AppMethodBeat.o(27458);
  }
  
  private boolean dAI()
  {
    AppMethodBeat.i(27462);
    if (this.wVc.getIntent() == null)
    {
      AppMethodBeat.o(27462);
      return false;
    }
    String str1 = this.wVc.getIntent().getStringExtra("device_id");
    String str2 = this.wVc.getIntent().getStringExtra("device_type");
    dr localdr = new dr();
    localdr.doy.cUi = str1;
    localdr.doy.dow = str2;
    com.tencent.mm.sdk.b.a.IbL.l(localdr);
    boolean bool = localdr.doz.doA;
    AppMethodBeat.o(27462);
    return bool;
  }
  
  private void dBl()
  {
    AppMethodBeat.i(27446);
    if (this.wVe != null)
    {
      AppMethodBeat.o(27446);
      return;
    }
    com.tencent.mm.ui.base.preference.h localh = (com.tencent.mm.ui.base.preference.h)this.wVc.getListView().getAdapter();
    if (localh == null)
    {
      ad.e("MicroMsg.ContactWidgetNewBizInfo", "empty adapter");
      AppMethodBeat.o(27446);
      return;
    }
    this.wVe = new com.tencent.mm.plugin.profile.ui.newbizinfo.b.c(this.wVc, this, localh, new String[] { "contact_info_biz_err_msg", "contact_info_footer_space" });
    localh.Jth = this.wVe;
    AppMethodBeat.o(27446);
  }
  
  private void dBm()
  {
    AppMethodBeat.i(27448);
    com.tencent.mm.api.c localc2 = com.tencent.mm.am.g.eS(this.contact.field_username);
    this.cQq = null;
    this.cQr = null;
    this.wRs = null;
    com.tencent.mm.api.c localc1;
    if (localc2 != null)
    {
      localc1 = localc2;
      if (localc2.bX(false) != null) {}
    }
    else
    {
      localc1 = localc2;
      if (this.wRt != null)
      {
        localc1 = new com.tencent.mm.api.c();
        localc1.field_username = this.contact.field_username;
        localc1.field_brandFlag = this.wRt.jdq;
        localc1.field_brandIconURL = this.wRt.jdt;
        localc1.field_brandInfo = this.wRt.jds;
        localc1.field_extInfo = this.wRt.jdr;
        localc1.field_type = localc1.bX(false).getServiceType();
      }
    }
    if ((localc1 != null) && (localc1.field_brandInfo == null) && (localc1.field_extInfo == null) && (this.wRt != null))
    {
      localc1.field_username = this.contact.field_username;
      localc1.field_brandFlag = this.wRt.jdq;
      localc1.field_brandIconURL = this.wRt.jdt;
      localc1.field_brandInfo = this.wRt.jds;
      localc1.field_extInfo = this.wRt.jdr;
      localc1.field_type = localc1.bX(false).getServiceType();
    }
    if (localc1 != null)
    {
      this.wPN = localc1;
      this.cQq = localc1.Kw();
      this.cQr = localc1.bX(false);
      this.wRs = this.cQr.getWxaEntryInfoList();
      if ((this.cQr.KA() != null) && (this.cQr.KA().length() > 0)) {
        this.cQA = this.cQr.KA();
      }
    }
    AppMethodBeat.o(27448);
  }
  
  private boolean dBo()
  {
    boolean bool1 = true;
    AppMethodBeat.i(27453);
    try
    {
      String str = this.cQr.KD();
      boolean bool2 = bt.isNullOrNil(str);
      if (bool2)
      {
        AppMethodBeat.o(27453);
        return false;
      }
      long l = bt.getLong(str, 0L);
      if ((l > 0L) && (l - System.currentTimeMillis() / 1000L < 0L)) {}
      for (;;)
      {
        ad.d("MicroMsg.ContactWidgetNewBizInfo", "isBizAccountTimeExpired:%b", new Object[] { Boolean.valueOf(bool1) });
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
  private void dBp()
  {
    // Byte code:
    //   0: sipush 27459
    //   3: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 159	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo:wVc	Lcom/tencent/mm/plugin/profile/ui/ContactInfoUI;
    //   10: invokevirtual 797	com/tencent/mm/plugin/profile/ui/ContactInfoUI:getIntent	()Landroid/content/Intent;
    //   13: astore 13
    //   15: aload 13
    //   17: ldc_w 1123
    //   20: iconst_0
    //   21: invokevirtual 895	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   24: invokestatic 1128	com/tencent/mm/plugin/profile/ui/newbizinfo/b/g:Ng	(I)I
    //   27: istore_1
    //   28: aload 13
    //   30: ldc_w 1130
    //   33: invokevirtual 865	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   36: astore 14
    //   38: aload 13
    //   40: ldc_w 1132
    //   43: invokevirtual 865	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   46: astore 15
    //   48: aload 13
    //   50: ldc_w 1134
    //   53: iconst_0
    //   54: invokevirtual 895	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   57: aload 14
    //   59: invokestatic 1138	com/tencent/mm/plugin/profile/ui/newbizinfo/b/g:bC	(ILjava/lang/String;)I
    //   62: istore_2
    //   63: aload 13
    //   65: ldc_w 647
    //   68: invokevirtual 865	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   71: astore 8
    //   73: aload 13
    //   75: ldc_w 887
    //   78: invokevirtual 865	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   81: astore 12
    //   83: aload 13
    //   85: ldc_w 1140
    //   88: invokevirtual 1144	android/content/Intent:getBundleExtra	(Ljava/lang/String;)Landroid/os/Bundle;
    //   91: astore 10
    //   93: ldc 130
    //   95: astore 9
    //   97: aload 10
    //   99: ifnull +15 -> 114
    //   102: aload 10
    //   104: ldc_w 1146
    //   107: ldc 130
    //   109: invokevirtual 1151	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   112: astore 9
    //   114: aload 13
    //   116: ldc_w 892
    //   119: iconst_m1
    //   120: invokevirtual 895	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   123: invokestatic 901	com/tencent/mm/ui/e$a:abw	(I)I
    //   126: istore_3
    //   127: aload_0
    //   128: getfield 474	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo:contact	Lcom/tencent/mm/storage/am;
    //   131: getfield 233	com/tencent/mm/g/c/aw:field_username	Ljava/lang/String;
    //   134: astore 16
    //   136: aload 9
    //   138: invokestatic 491	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   141: ifne +429 -> 570
    //   144: aload 9
    //   146: invokestatic 1154	com/tencent/mm/sdk/platformtools/bt:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   149: ldc_w 1156
    //   152: invokestatic 1160	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   155: astore 9
    //   157: aload 8
    //   159: astore 10
    //   161: aload 8
    //   163: invokestatic 1154	com/tencent/mm/sdk/platformtools/bt:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   166: ldc_w 1156
    //   169: invokestatic 1160	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   172: astore 8
    //   174: aload 8
    //   176: astore 10
    //   178: aload 12
    //   180: invokestatic 1154	com/tencent/mm/sdk/platformtools/bt:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   183: ldc_w 1156
    //   186: invokestatic 1160	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   189: astore 11
    //   191: aload 11
    //   193: astore 10
    //   195: getstatic 222	com/tencent/mm/plugin/report/service/g:yhR	Lcom/tencent/mm/plugin/report/service/g;
    //   198: sipush 16232
    //   201: bipush 9
    //   203: anewarray 4	java/lang/Object
    //   206: dup
    //   207: iconst_0
    //   208: iload_1
    //   209: invokestatic 341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   212: aastore
    //   213: dup
    //   214: iconst_1
    //   215: iload_2
    //   216: invokestatic 341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
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
    //   250: invokestatic 341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   253: aastore
    //   254: dup
    //   255: bipush 8
    //   257: aload 16
    //   259: aastore
    //   260: invokevirtual 1163	com/tencent/mm/plugin/report/service/g:f	(I[Ljava/lang/Object;)V
    //   263: aload_0
    //   264: getfield 124	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo:wRD	Ljava/lang/String;
    //   267: invokestatic 491	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   270: ifne +16 -> 286
    //   273: getstatic 222	com/tencent/mm/plugin/report/service/g:yhR	Lcom/tencent/mm/plugin/report/service/g;
    //   276: sipush 16697
    //   279: aload_0
    //   280: getfield 124	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo:wRD	Ljava/lang/String;
    //   283: invokevirtual 1167	com/tencent/mm/plugin/report/service/g:kvStat	(ILjava/lang/String;)V
    //   286: aload 13
    //   288: ldc_w 1123
    //   291: iconst_0
    //   292: invokevirtual 895	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   295: istore_1
    //   296: invokestatic 856	java/lang/System:currentTimeMillis	()J
    //   299: ldc2_w 282
    //   302: ldiv
    //   303: l2i
    //   304: i2l
    //   305: lstore 4
    //   307: iload_1
    //   308: sipush 160
    //   311: if_icmpne +147 -> 458
    //   314: aload 13
    //   316: ldc_w 1169
    //   319: lconst_0
    //   320: invokevirtual 1172	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   323: lstore 6
    //   325: getstatic 222	com/tencent/mm/plugin/report/service/g:yhR	Lcom/tencent/mm/plugin/report/service/g;
    //   328: sipush 15721
    //   331: bipush 9
    //   333: anewarray 4	java/lang/Object
    //   336: dup
    //   337: iconst_0
    //   338: aload_0
    //   339: getfield 474	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo:contact	Lcom/tencent/mm/storage/am;
    //   342: getfield 233	com/tencent/mm/g/c/aw:field_username	Ljava/lang/String;
    //   345: aastore
    //   346: dup
    //   347: iconst_1
    //   348: iconst_0
    //   349: invokestatic 341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   352: aastore
    //   353: dup
    //   354: iconst_2
    //   355: bipush 14
    //   357: invokestatic 341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   360: aastore
    //   361: dup
    //   362: iconst_3
    //   363: lload 4
    //   365: invokestatic 1177	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   368: aastore
    //   369: dup
    //   370: iconst_4
    //   371: invokestatic 551	com/tencent/mm/storage/y:getSessionId	()I
    //   374: invokestatic 341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   377: aastore
    //   378: dup
    //   379: iconst_5
    //   380: iconst_0
    //   381: invokestatic 341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   384: aastore
    //   385: dup
    //   386: bipush 6
    //   388: lload 6
    //   390: invokestatic 1177	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   393: aastore
    //   394: dup
    //   395: bipush 7
    //   397: ldc 130
    //   399: aastore
    //   400: dup
    //   401: bipush 8
    //   403: iconst_1
    //   404: invokestatic 341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   407: aastore
    //   408: invokevirtual 1163	com/tencent/mm/plugin/report/service/g:f	(I[Ljava/lang/Object;)V
    //   411: getstatic 222	com/tencent/mm/plugin/report/service/g:yhR	Lcom/tencent/mm/plugin/report/service/g;
    //   414: ldc2_w 1178
    //   417: ldc2_w 1180
    //   420: lconst_1
    //   421: iconst_0
    //   422: invokevirtual 228	com/tencent/mm/plugin/report/service/g:idkeyStat	(JJJZ)V
    //   425: sipush 27459
    //   428: invokestatic 192	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   431: return
    //   432: astore 10
    //   434: ldc 130
    //   436: astore 9
    //   438: ldc 209
    //   440: aload 10
    //   442: ldc 130
    //   444: iconst_0
    //   445: anewarray 4	java/lang/Object
    //   448: invokestatic 1185	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   451: aload 12
    //   453: astore 10
    //   455: goto -260 -> 195
    //   458: iload_1
    //   459: sipush 174
    //   462: if_icmpne +88 -> 550
    //   465: getstatic 222	com/tencent/mm/plugin/report/service/g:yhR	Lcom/tencent/mm/plugin/report/service/g;
    //   468: sipush 15721
    //   471: bipush 9
    //   473: anewarray 4	java/lang/Object
    //   476: dup
    //   477: iconst_0
    //   478: aload_0
    //   479: getfield 474	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo:contact	Lcom/tencent/mm/storage/am;
    //   482: getfield 233	com/tencent/mm/g/c/aw:field_username	Ljava/lang/String;
    //   485: aastore
    //   486: dup
    //   487: iconst_1
    //   488: iconst_0
    //   489: invokestatic 341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   492: aastore
    //   493: dup
    //   494: iconst_2
    //   495: bipush 21
    //   497: invokestatic 341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   500: aastore
    //   501: dup
    //   502: iconst_3
    //   503: lload 4
    //   505: invokestatic 1177	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   508: aastore
    //   509: dup
    //   510: iconst_4
    //   511: invokestatic 551	com/tencent/mm/storage/y:getSessionId	()I
    //   514: invokestatic 341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   517: aastore
    //   518: dup
    //   519: iconst_5
    //   520: iconst_0
    //   521: invokestatic 341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   524: aastore
    //   525: dup
    //   526: bipush 6
    //   528: iconst_0
    //   529: invokestatic 341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   532: aastore
    //   533: dup
    //   534: bipush 7
    //   536: ldc 130
    //   538: aastore
    //   539: dup
    //   540: bipush 8
    //   542: iconst_3
    //   543: invokestatic 341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   546: aastore
    //   547: invokevirtual 1163	com/tencent/mm/plugin/report/service/g:f	(I[Ljava/lang/Object;)V
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
    this.wVc.setMMTitle(bt.nullAsNil(this.contact.field_nickname));
    this.wVc.setMMTitleColor(0);
    this.wVc.setTitleDividerVis(false);
    this.wVc.setIsDarkActionbarBg(false);
    this.wVc.setActionbarColor(this.wVc.getResources().getColor(2131099650));
    this.wVc.hideActionbarLine();
    this.wVc.setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(193302);
        ContactWidgetNewBizInfo.b(ContactWidgetNewBizInfo.this).onBackPressed();
        AppMethodBeat.o(193302);
        return true;
      }
    }, 2131689490);
    this.wVc.removeAllOptionMenu();
    this.wVc.addIconOptionMenu(1, 2131764452, 2131689494, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(193303);
        ContactWidgetNewBizInfo.d(ContactWidgetNewBizInfo.this);
        AppMethodBeat.o(193303);
        return true;
      }
    });
    this.wVc.addIconOptionMenu(0, "", 2131689493, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(27434);
        paramAnonymousMenuItem = new e(ContactWidgetNewBizInfo.b(ContactWidgetNewBizInfo.this), 1, false);
        paramAnonymousMenuItem.KJy = new n.d()
        {
          public final void onCreateMMMenu(l paramAnonymous2l)
          {
            AppMethodBeat.i(193305);
            if (com.tencent.mm.o.b.lM(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_type)) {
              if (ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).adq()) {
                if ((y.bNf()) && (com.tencent.mm.am.g.DN(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username))) {
                  paramAnonymous2l.jI(5, 2131757612);
                }
              }
            }
            for (;;)
            {
              paramAnonymous2l.jI(2, 2131757807);
              paramAnonymous2l.jI(6, 2131757156);
              if (com.tencent.mm.o.b.lM(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_type)) {
                paramAnonymous2l.jI(3, 2131757623);
              }
              AppMethodBeat.o(193305);
              return;
              paramAnonymous2l.jI(5, 2131761053);
              continue;
              if ((y.bNf()) && (com.tencent.mm.am.g.DN(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username)))
              {
                paramAnonymous2l.jI(4, 2131757608);
              }
              else
              {
                paramAnonymous2l.jI(4, 2131757877);
                continue;
                if ((int)ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).gfj <= 0) {
                  as.a.hFO.a(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username, "", new as.b.a()
                  {
                    public final void p(String paramAnonymous3String, boolean paramAnonymous3Boolean)
                    {
                      AppMethodBeat.i(193304);
                      ad.i("MicroMsg.ContactWidgetNewBizInfo", "onCreateMMMenu Fetch Contact username:%s, succ: %b", new Object[] { paramAnonymous3String, Boolean.valueOf(paramAnonymous3Boolean) });
                      AppMethodBeat.o(193304);
                    }
                  });
                }
              }
            }
          }
        };
        paramAnonymousMenuItem.KJz = new n.e()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(193306);
            switch (paramAnonymous2MenuItem.getItemId())
            {
            default: 
              ad.w("MicroMsg.ContactWidgetNewBizInfo", "default onMMMenuItemSelected err");
            case 2: 
            case 3: 
            case 4: 
            case 5: 
              do
              {
                do
                {
                  AppMethodBeat.o(193306);
                  return;
                  ContactWidgetNewBizInfo.f(ContactWidgetNewBizInfo.this);
                  AppMethodBeat.o(193306);
                  return;
                  ContactWidgetNewBizInfo.g(ContactWidgetNewBizInfo.this);
                  AppMethodBeat.o(193306);
                  return;
                  com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.b(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username, 903, ContactWidgetNewBizInfo.h(ContactWidgetNewBizInfo.this), ContactWidgetNewBizInfo.i(ContactWidgetNewBizInfo.this));
                  com.tencent.mm.model.j.yC(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username);
                  ContactWidgetNewBizInfo.j(ContactWidgetNewBizInfo.this);
                } while ((y.bNf()) && (!com.tencent.mm.am.g.DL(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username)));
                com.tencent.mm.ui.base.h.cl(ContactWidgetNewBizInfo.b(ContactWidgetNewBizInfo.this), ContactWidgetNewBizInfo.b(ContactWidgetNewBizInfo.this).getString(2131761054));
                AppMethodBeat.o(193306);
                return;
                w.E(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username, true);
                com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.b(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username, 904, ContactWidgetNewBizInfo.h(ContactWidgetNewBizInfo.this), ContactWidgetNewBizInfo.i(ContactWidgetNewBizInfo.this));
                ContactWidgetNewBizInfo.j(ContactWidgetNewBizInfo.this);
              } while ((y.bNf()) && (!com.tencent.mm.am.g.DL(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username)));
              com.tencent.mm.ui.base.h.cl(ContactWidgetNewBizInfo.b(ContactWidgetNewBizInfo.this), ContactWidgetNewBizInfo.b(ContactWidgetNewBizInfo.this).getString(2131756644));
              AppMethodBeat.o(193306);
              return;
            }
            ContactWidgetNewBizInfo.k(ContactWidgetNewBizInfo.this);
            AppMethodBeat.o(193306);
          }
        };
        paramAnonymousMenuItem.cMW();
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.b(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username, 600, ContactWidgetNewBizInfo.h(ContactWidgetNewBizInfo.this), ContactWidgetNewBizInfo.i(ContactWidgetNewBizInfo.this));
        AppMethodBeat.o(27434);
        return false;
      }
    });
    AppMethodBeat.o(27445);
  }
  
  final void MY(int paramInt)
  {
    AppMethodBeat.i(27463);
    if ((this.wRB == null) || ((this.jfq != 39) && (this.jfq != 56) && (this.jfq != 35) && (this.jfq != 87) && (this.jfq != 88) && (this.jfq != 89) && (this.jfq != 85)))
    {
      ad.d("MicroMsg.ContactWidgetNewBizInfo", "mExtArgs is null or the add contact action is not from biz search.");
      AppMethodBeat.o(27463);
      return;
    }
    if (this.contact == null)
    {
      ad.i("MicroMsg.ContactWidgetNewBizInfo", "contact is null.");
      AppMethodBeat.o(27463);
      return;
    }
    String str2 = this.wRB.getString("Contact_Ext_Args_Search_Id");
    String str3 = bt.nullAsNil(this.wRB.getString("Contact_Ext_Args_Query_String"));
    int j = this.wRB.getInt("Contact_Ext_Args_Index");
    int i;
    switch (this.jfq)
    {
    default: 
      i = 0;
      str1 = bt.nullAsNil(this.wRB.getString("Contact_Ext_Extra_Params"));
      str2 = str3 + "," + paramInt + "," + bt.nullAsNil(this.contact.field_username) + "," + j + "," + System.currentTimeMillis() / 1000L + "," + str2 + "," + i;
      if (bt.isNullOrNil(null)) {
        break;
      }
    }
    for (String str1 = str2 + "," + null + "," + str1;; str1 = str2 + ",," + str1)
    {
      ad.v("MicroMsg.ContactWidgetNewBizInfo", "report 10866: %s", new Object[] { str1 });
      com.tencent.mm.plugin.report.service.g.yhR.kvStat(10866, str1);
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
  
  public final long TD()
  {
    return this.enterTime;
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, am paramam, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(27443);
    if (this.wVc.isFinishing())
    {
      AppMethodBeat.o(27443);
      return true;
    }
    if (paramam != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (bt.nullAsNil(paramam.field_username).length() <= 0) {
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
      U(paramam);
      this.screen = paramf;
      this.contact = paramam;
      this.wPZ = paramBoolean;
      this.jfq = paramInt;
      this.wRC = ((SnsAdClick)this.wVc.getIntent().getParcelableExtra("KSnsAdTag"));
      this.wRD = this.wVc.getIntent().getStringExtra("key_add_contact_report_info");
      this.wRx = this.wVc.getIntent().getIntExtra("add_more_friend_search_scene", 0);
      this.wRB = this.wVc.getIntent().getBundleExtra("Contact_Ext_Args");
      this.ool = this.wVc.getIntent().getStringExtra("key_channel_session_id");
      if (this.wVh)
      {
        this.wVh = false;
        initActionBar();
        this.wVd = a.auR(this.contact.field_username);
        dAF();
        b(paramam.field_username, null);
        paramf = this.wVc.getIntent().getStringExtra("Contact_BIZ_PopupInfoMsg");
        if (!bt.isNullOrNil(paramf))
        {
          this.wVc.getIntent().putExtra("Contact_BIZ_PopupInfoMsg", "");
          com.tencent.mm.ui.base.h.a(this.wVc, paramf, "", this.wVc.getString(2131755835), null);
        }
        if (paramam != null) {
          ag.aGl().Dx(paramam.field_username);
        }
      }
      if (this.wVj != null)
      {
        paramf = this.wVc.getListView();
        if (paramf != null) {
          paramf.onRestoreInstanceState(this.wVj);
        }
      }
      if ((this.wVc instanceof FragmentActivity))
      {
        this.wVc.getLifecycle().removeObserver(this);
        this.wVc.getLifecycle().addObserver(this);
      }
      AppMethodBeat.o(27443);
      return true;
      bool = false;
      break;
      bool = false;
      break label52;
    }
  }
  
  public final boolean aaG(String paramString)
  {
    AppMethodBeat.i(27457);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.ContactWidgetNewBizInfo", "handleEvent key is null, return");
      AppMethodBeat.o(27457);
      return false;
    }
    ad.i("MicroMsg.ContactWidgetNewBizInfo", "handleEvent key:%s", new Object[] { paramString });
    if ("contact_info_biz_add".endsWith(paramString))
    {
      if (!com.tencent.mm.model.gdpr.c.aDh()) {
        dAH();
      }
      for (;;)
      {
        if (this.wRx != 0) {
          com.tencent.mm.plugin.report.service.g.yhR.f(11263, new Object[] { Integer.valueOf(this.wRx), this.contact.field_username });
        }
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.b(this.contact.field_username, 200, this.jfq, this.enterTime);
        AppMethodBeat.o(27457);
        return true;
        com.tencent.mm.model.gdpr.c.a(this.wVc, com.tencent.mm.model.gdpr.a.hIS, this.contact.field_username, new com.tencent.mm.model.gdpr.b()
        {
          public final void oG(int paramAnonymousInt)
          {
            AppMethodBeat.i(193309);
            if (paramAnonymousInt == 0) {
              ContactWidgetNewBizInfo.q(ContactWidgetNewBizInfo.this);
            }
            AppMethodBeat.o(193309);
          }
        });
      }
    }
    AppMethodBeat.o(27457);
    return true;
  }
  
  public final boolean agA()
  {
    AppMethodBeat.i(27465);
    if ((this.contact == null) || (this.wPN == null) || (this.wVd == null) || (this.wVd.FJD == null) || (this.wVd.FJC == null))
    {
      ad.w("MicroMsg.ContactWidgetNewBizInfo", "reportEnd fail, err");
      this.obT.dead();
      this.kwD.dead();
      AppMethodBeat.o(27465);
      return false;
    }
    this.endTime = System.currentTimeMillis();
    String str = this.contact.field_username;
    int k = this.jfq;
    int m = this.wPN.field_type;
    long l1 = this.enterTime;
    long l2 = this.endTime;
    int i;
    label134:
    int n;
    int i1;
    if (com.tencent.mm.o.b.lM(this.contact.field_type))
    {
      i = 1;
      n = this.wVd.FJD.FGH;
      i1 = this.wVd.FJD.FGI;
      if (this.wRs == null) {
        break label231;
      }
    }
    label231:
    for (int j = this.wRs.size();; j = 0)
    {
      com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.a(str, k, m, l1, l2, i, n, i1, j, com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.b(this.wVd.FJE), com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.a(this.wVd.FJH), this.wVd.FJC.nDo);
      break;
      i = 0;
      break label134;
    }
  }
  
  public final boolean cdn()
  {
    AppMethodBeat.i(27455);
    if (this.screen == null)
    {
      AppMethodBeat.o(27455);
      return true;
    }
    Object localObject = (NewBizInfoHeaderPreference)this.screen.aVD("contact_info_header_newbizinfo");
    if (localObject != null) {
      ((NewBizInfoHeaderPreference)localObject).onDetach();
    }
    localObject = this.wVc.getListView();
    if (localObject != null) {
      this.wVj = ((ListView)localObject).onSaveInstanceState();
    }
    AppMethodBeat.o(27455);
    return true;
  }
  
  public final void cjS()
  {
    AppMethodBeat.i(27449);
    if ((this.wVi) && (this.wVd.FJE != null) && (this.wVd.FJE.FJa != null) && (this.wVd.FJE.FJa.FJy == 0)) {
      b(this.contact.field_username, this.wVd.FJE.FJa.FJx);
    }
    AppMethodBeat.o(27449);
  }
  
  public final am dBn()
  {
    return this.contact;
  }
  
  public final int dBq()
  {
    return this.jfq;
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public void onActivityDestroy()
  {
    AppMethodBeat.i(27444);
    ad.i("MicroMsg.ContactWidgetNewBizInfo", "[onActivityDestroy]");
    cdn();
    AppMethodBeat.o(27444);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(27456);
    if (this.wVc == null)
    {
      ad.e("MicroMsg.ContactWidgetNewBizInfo", "null == context");
      AppMethodBeat.o(27456);
      return;
    }
    ad.i("MicroMsg.ContactWidgetNewBizInfo", "onActivityResult, requestCode = %d, resultCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
      com.tencent.mm.plugin.messenger.a.g.dlD().q(str1, str2, bool);
      com.tencent.mm.plugin.messenger.a.g.dlD().hP(paramIntent, str2);
      com.tencent.mm.ui.widget.snackbar.b.n(this.wVc, this.wVc.getString(2131759420));
      AppMethodBeat.o(27456);
      return;
    }
    AppMethodBeat.o(27456);
  }
  
  public final boolean onCreate()
  {
    AppMethodBeat.i(27464);
    if ((this.contact == null) || (this.wPN == null))
    {
      ad.w("MicroMsg.ContactWidgetNewBizInfo", "reportStart fail, err");
      this.obT.alive();
      this.kwD.alive();
      AppMethodBeat.o(27464);
      return false;
    }
    String str = this.contact.field_username;
    int j = this.jfq;
    int k = this.wPN.field_type;
    long l = this.enterTime;
    if (com.tencent.mm.o.b.lM(this.contact.field_type)) {}
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.a(str, j, k, l, i, this.ool);
      break;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(27461);
    ad.d("MicroMsg.ContactWidgetNewBizInfo", "onSceneEnd errType = " + paramInt1 + ", errCode = " + paramInt2 + ",errMsg = " + paramString);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if (paramn == null)
    {
      ad.e("MicroMsg.ContactWidgetNewBizInfo", "scene == null");
      AppMethodBeat.o(27461);
      return;
    }
    ba.aiU().b(paramn.getType(), this);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ad.e("MicroMsg.ContactWidgetNewBizInfo", "scene.getType() = %s", new Object[] { Integer.valueOf(paramn.getType()) });
      AppMethodBeat.o(27461);
      return;
    }
    ad.d("MicroMsg.ContactWidgetNewBizInfo", "scene.getType() = %s", new Object[] { Integer.valueOf(paramn.getType()) });
    if (paramn.getType() == 536)
    {
      ba.aiU().b(536, this);
      dAF();
    }
    AppMethodBeat.o(27461);
  }
  
  static final class a
    extends com.tencent.mm.sdk.b.c<u>
  {
    private WeakReference<ContactWidgetNewBizInfo> wVu;
    
    public a(ContactWidgetNewBizInfo paramContactWidgetNewBizInfo)
    {
      AppMethodBeat.i(193312);
      this.wVu = new WeakReference(paramContactWidgetNewBizInfo);
      this.__eventId = u.class.getName().hashCode();
      AppMethodBeat.o(193312);
    }
  }
  
  static final class b
    extends com.tencent.mm.sdk.b.c<mf>
  {
    private WeakReference<ContactWidgetNewBizInfo> wVu;
    
    public b(ContactWidgetNewBizInfo paramContactWidgetNewBizInfo)
    {
      AppMethodBeat.i(193314);
      this.wVu = new WeakReference(paramContactWidgetNewBizInfo);
      this.__eventId = mf.class.getName().hashCode();
      AppMethodBeat.o(193314);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.ContactWidgetNewBizInfo
 * JD-Core Version:    0.7.0.1
 */