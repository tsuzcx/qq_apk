package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
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
import com.tencent.mm.ak.x;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.al.af;
import com.tencent.mm.api.c.a;
import com.tencent.mm.api.c.b;
import com.tencent.mm.g.a.dk;
import com.tencent.mm.g.a.dk.b;
import com.tencent.mm.g.a.do;
import com.tencent.mm.g.a.do.b;
import com.tencent.mm.g.a.lw;
import com.tencent.mm.g.a.ql;
import com.tencent.mm.g.a.u;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.ar.b.a;
import com.tencent.mm.model.az;
import com.tencent.mm.model.w;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.profile.ui.ContactInfoUI;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.a.b;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.protocal.protobuf.aaf;
import com.tencent.mm.protocal.protobuf.chl;
import com.tencent.mm.protocal.protobuf.dpj;
import com.tencent.mm.protocal.protobuf.lp;
import com.tencent.mm.protocal.protobuf.lx;
import com.tencent.mm.protocal.protobuf.ly;
import com.tencent.mm.protocal.protobuf.lz;
import com.tencent.mm.protocal.protobuf.mg;
import com.tencent.mm.protocal.protobuf.nc;
import com.tencent.mm.protocal.protobuf.nd;
import com.tencent.mm.protocal.protobuf.nj;
import com.tencent.mm.protocal.protobuf.nk;
import com.tencent.mm.protocal.protobuf.nl;
import com.tencent.mm.protocal.protobuf.yi;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.e.a;
import d.g.b.k;
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
  implements LifecycleObserver, com.tencent.mm.ak.g, com.tencent.mm.pluginsdk.b.b
{
  private static String vOb = "crashFlag";
  private static boolean vOc = false;
  private List<c.a> cFl;
  private c.b cFm;
  private String cFv;
  ai contact;
  private long endTime;
  long enterTime;
  int iMg;
  private boolean isLoading;
  private com.tencent.mm.sdk.b.c kce;
  private com.tencent.mm.sdk.b.c nAK;
  private String nLF;
  private WeakReference<ContactWidgetNewBizInfo> nnu;
  public String sBi;
  private com.tencent.mm.ui.base.preference.f screen;
  private p tipDialog;
  com.tencent.mm.api.c vIG;
  boolean vIS;
  private String vIX;
  private List<WxaAttributes.WxaEntryInfo> vKj;
  private aaf vKk;
  private int vKo;
  private Bundle vKs;
  SnsAdClick vKt;
  private String vKu;
  ContactInfoUI vNT;
  private nl vNU;
  private com.tencent.mm.plugin.profile.ui.newbizinfo.b.c vNV;
  private boolean vNW;
  private int vNX;
  private boolean vNY;
  private boolean vNZ;
  private Parcelable vOa;
  
  public ContactWidgetNewBizInfo(final ContactInfoUI paramContactInfoUI, final String paramString, aaf paramaaf)
  {
    AppMethodBeat.i(27442);
    this.vKo = 0;
    this.vKt = null;
    this.vKu = null;
    this.vNV = null;
    this.nnu = null;
    this.nLF = "";
    this.vNW = false;
    this.kce = new b(this);
    this.nAK = new a(this);
    this.vNX = 0;
    this.vNY = true;
    this.isLoading = false;
    this.vNZ = false;
    this.tipDialog = null;
    this.nnu = new WeakReference(this);
    this.vNT = paramContactInfoUI;
    this.vIX = paramString;
    this.vKk = paramaaf;
    paramString = paramContactInfoUI.getListView();
    dqI();
    paramString.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(196052);
        if (ContactWidgetNewBizInfo.c(ContactWidgetNewBizInfo.this) != null)
        {
          paramAnonymousAbsListView = (NewBizInfoHeaderPreference)ContactWidgetNewBizInfo.c(ContactWidgetNewBizInfo.this).aPN("contact_info_header_newbizinfo");
          if (paramAnonymousAbsListView != null)
          {
            int[] arrayOfInt = new int[2];
            if (paramAnonymousAbsListView.vOt == null) {}
            for (paramAnonymousInt1 = 0; paramAnonymousInt1 < 0; paramAnonymousInt1 = arrayOfInt[1])
            {
              paramAnonymousInt2 = paramAnonymousAbsListView.vOv.getMeasuredHeight();
              float f = (paramAnonymousInt1 + paramAnonymousInt2 - this.vOe) / paramAnonymousInt2;
              paramContactInfoUI.setMMTitleColor(ao.aJ(paramContactInfoUI, 2130968584));
              paramContactInfoUI.setTitleAlpha(1.0F - f);
              AppMethodBeat.o(196052);
              return;
              paramAnonymousAbsListView.vOt.getLocationInWindow(arrayOfInt);
            }
            if (paramAnonymousInt1 == 0)
            {
              if (paramAnonymousAbsListView.vOt == null) {}
              for (boolean bool = false; !bool; bool = paramAnonymousAbsListView.vOt.isAttachedToWindow())
              {
                paramContactInfoUI.setMMTitleColor(ao.aJ(paramContactInfoUI, 2130968584));
                AppMethodBeat.o(196052);
                return;
              }
            }
            paramContactInfoUI.setMMTitleColor(0);
          }
        }
        AppMethodBeat.o(196052);
      }
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(196051);
        ArrayList localArrayList;
        if ((paramAnonymousInt == 0) && (ContactWidgetNewBizInfo.a(ContactWidgetNewBizInfo.this) != null))
        {
          paramAnonymousAbsListView = ContactWidgetNewBizInfo.a(ContactWidgetNewBizInfo.this);
          paramAnonymousInt = paramString.getFirstVisiblePosition();
          int i = paramString.getLastVisiblePosition();
          if (paramAnonymousAbsListView.dqU().ys(16))
          {
            int j = paramAnonymousAbsListView.dqT();
            int k = paramAnonymousAbsListView.vPs;
            localArrayList = new ArrayList();
            if (paramAnonymousInt <= i) {
              for (;;)
              {
                if (paramAnonymousAbsListView.LB(paramAnonymousInt))
                {
                  int n = paramAnonymousInt + (j - k);
                  if (paramAnonymousAbsListView.vPq.Lx(n) == a.b.vPg)
                  {
                    Object localObject1 = paramAnonymousAbsListView.vPq.getItem(n);
                    if (localObject1 == null)
                    {
                      paramAnonymousAbsListView = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizMessage");
                      AppMethodBeat.o(196051);
                      throw paramAnonymousAbsListView;
                    }
                    localObject1 = (nc)localObject1;
                    Object localObject2 = paramAnonymousAbsListView.vPx.contact;
                    k.g(localObject2, "widget.contact");
                    localObject2 = ((av)localObject2).field_username;
                    long l = paramAnonymousAbsListView.vPx.enterTime;
                    int m = paramAnonymousAbsListView.vPx.iMg;
                    n /= 2;
                    if (((nc)localObject1).EcP.tit == 49)
                    {
                      localObject3 = ((nc)localObject1).EcU.EaL;
                      k.g(localObject3, "bizMessage.AppMsg.DetailInfo");
                      Object localObject4 = (Iterable)localObject3;
                      localObject3 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject4, 10));
                      localObject4 = ((Iterable)localObject4).iterator();
                      Object localObject5;
                      while (((Iterator)localObject4).hasNext())
                      {
                        localObject5 = (ly)((Iterator)localObject4).next();
                        ((Collection)localObject3).add(d.a.j.listOf(new String[] { ((ly)localObject5).Ean, String.valueOf(((ly)localObject5).hkQ) }));
                      }
                      localArrayList.addAll((Collection)localObject3);
                      localObject3 = ((nc)localObject1).EcU.EaL;
                      k.g(localObject3, "bizMessage.AppMsg.DetailInfo");
                      localObject3 = ((Iterable)localObject3).iterator();
                      while (((Iterator)localObject3).hasNext())
                      {
                        localObject4 = (ly)((Iterator)localObject3).next();
                        localObject5 = com.tencent.mm.plugin.profile.ui.newbizinfo.c.d.vQP;
                        k.g(localObject2, "userName");
                        com.tencent.mm.plugin.profile.ui.newbizinfo.c.d.a((String)localObject2, l, ((nc)localObject1).EcU.EaK.Eaj, ((ly)localObject4).Eam, ((ly)localObject4).hkQ, n, ((nc)localObject1).EcU.EaK.CreateTime, m);
                      }
                    }
                    Object localObject3 = com.tencent.mm.plugin.profile.ui.newbizinfo.c.d.vQP;
                    k.g(localObject2, "userName");
                    com.tencent.mm.plugin.profile.ui.newbizinfo.c.d.a((String)localObject2, l, ((nc)localObject1).EcP.vTO, 0, -1, n, ((nc)localObject1).EcP.ErX, m);
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
            paramAnonymousAbsListView.dqU().i((List)localArrayList, 126);
          }
          AppMethodBeat.o(196051);
          return;
        }
      }
    });
    AppMethodBeat.o(27442);
  }
  
  /* Error */
  private void U(ai paramai)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 192
    //   4: invokestatic 117	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: ifnull +9 -> 17
    //   11: getstatic 106	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo:vOc	Z
    //   14: ifeq +11 -> 25
    //   17: ldc 192
    //   19: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: iconst_1
    //   26: putstatic 106	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo:vOc	Z
    //   29: ldc 194
    //   31: invokestatic 200	com/tencent/mm/sdk/platformtools/aw:aKU	(Ljava/lang/String;)Lcom/tencent/mm/sdk/platformtools/aw;
    //   34: astore_2
    //   35: aload_2
    //   36: getstatic 104	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo:vOb	Ljava/lang/String;
    //   39: iconst_0
    //   40: invokevirtual 204	com/tencent/mm/sdk/platformtools/aw:decodeBool	(Ljava/lang/String;Z)Z
    //   43: ifeq +29 -> 72
    //   46: ldc 206
    //   48: ldc 208
    //   50: invokestatic 213	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   53: getstatic 219	com/tencent/mm/plugin/report/service/h:wUl	Lcom/tencent/mm/plugin/report/service/h;
    //   56: ldc2_w 220
    //   59: lconst_0
    //   60: lconst_1
    //   61: iconst_0
    //   62: invokevirtual 225	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   65: aload_1
    //   66: getfield 230	com/tencent/mm/g/c/av:field_username	Ljava/lang/String;
    //   69: invokestatic 236	com/tencent/mm/plugin/profile/ui/newbizinfo/a:clear	(Ljava/lang/String;)V
    //   72: aload_2
    //   73: getstatic 104	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo:vOb	Ljava/lang/String;
    //   76: iconst_1
    //   77: invokevirtual 239	com/tencent/mm/sdk/platformtools/aw:encode	(Ljava/lang/String;Z)Z
    //   80: pop
    //   81: ldc 206
    //   83: ldc 241
    //   85: invokestatic 213	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: getstatic 246	com/tencent/mm/sdk/platformtools/h:DEBUG	Z
    //   91: ifne +15 -> 106
    //   94: getstatic 249	com/tencent/mm/sdk/platformtools/h:IS_FLAVOR_RED	Z
    //   97: ifne +9 -> 106
    //   100: invokestatic 255	com/tencent/mm/sdk/platformtools/bt:eWo	()Z
    //   103: ifeq +22 -> 125
    //   106: aload_2
    //   107: ldc_w 257
    //   110: iconst_0
    //   111: invokevirtual 261	com/tencent/mm/sdk/platformtools/aw:decodeInt	(Ljava/lang/String;I)I
    //   114: iconst_1
    //   115: if_icmpne +10 -> 125
    //   118: ldc_w 263
    //   121: iconst_0
    //   122: invokestatic 269	junit/framework/Assert:assertTrue	(Ljava/lang/String;Z)V
    //   125: getstatic 275	com/tencent/e/h:JZN	Lcom/tencent/e/i;
    //   128: new 16	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo$2
    //   131: dup
    //   132: aload_0
    //   133: aload_2
    //   134: invokespecial 278	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo$2:<init>	(Lcom/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo;Lcom/tencent/mm/sdk/platformtools/aw;)V
    //   137: ldc2_w 279
    //   140: invokeinterface 286 4 0
    //   145: pop
    //   146: ldc 192
    //   148: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   151: goto -129 -> 22
    //   154: astore_1
    //   155: aload_0
    //   156: monitorexit
    //   157: aload_1
    //   158: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	this	ContactWidgetNewBizInfo
    //   0	159	1	paramai	ai
    //   34	100	2	localaw	aw
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
  
  private void a(nl paramnl)
  {
    AppMethodBeat.i(169758);
    if (paramnl == null)
    {
      AppMethodBeat.o(169758);
      return;
    }
    if (paramnl.EdB != null)
    {
      com.tencent.mm.plugin.brandservice.b.c.E(paramnl.EdB.ERq, true);
      boolean bool = paramnl.EdB.ERq;
      if (paramnl.EdB.FvH != null)
      {
        i = paramnl.EdB.FvH.size();
        ac.i("MicroMsg.ContactWidgetNewBizInfo", "alvinluo updateProfileInfo %b, size: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
      }
    }
    label90:
    com.tencent.mm.plugin.profile.ui.newbizinfo.b.c localc;
    chl localchl;
    com.tencent.mm.plugin.profile.ui.newbizinfo.b.a locala;
    for (;;)
    {
      if (paramnl.Edv != null)
      {
        dqI();
        if (this.vNV != null)
        {
          localc = this.vNV;
          Object localObject1 = paramnl.Edv;
          localchl = paramnl.EdB;
          k.h(localObject1, "msgList");
          locala = localc.vPq;
          k.h(localObject1, "msgList");
          locala.fBS.clear();
          k.g(Calendar.getInstance(), "Calendar.getInstance()");
          new Date();
          Object localObject2 = ((nd)localObject1).EcV;
          k.g(localObject2, "msgList.Msg");
          localObject2 = ((Iterable)localObject2).iterator();
          for (;;)
          {
            if (((Iterator)localObject2).hasNext())
            {
              nc localnc = (nc)((Iterator)localObject2).next();
              locala.fBS.add(new o(a.b.vPf, localnc));
              locala.fBS.add(new o(a.b.vPg, localnc));
              continue;
              i = -1;
              break;
              ac.e("MicroMsg.ContactWidgetNewBizInfo", "alvinluo updateProfileInfo videochannel_notify_info is null");
              break label90;
            }
          }
          localObject1 = ((nd)localObject1).EcW;
          if ((localObject1 != null) && (((nj)localObject1).Edp == 0)) {
            locala.fBS.add(new o(a.b.vPh, new nc()));
          }
          locala = localc.vPq;
          if ((localchl != null) && (com.tencent.mm.plugin.brandservice.b.c.bJe()))
          {
            localObject1 = localchl.FvH;
            k.g(localObject1, "notifyInfo.notify_list");
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
        ac.i("MicroMsg.BizMessageAdapter", "alvinluo updateHeader add video channel");
        locala.vOW.clear();
        locala.vOW.add(new o(a.b.vPi, localchl));
      }
      localc.vPy.notifyDataSetChanged();
      if ((!this.vNW) && (paramnl.EdB != null) && (paramnl.EdB.FvH != null) && (paramnl.EdB.FvH.size() > 0) && (com.tencent.mm.plugin.brandservice.b.c.bJe()))
      {
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.K(this.contact.field_username, 1401, this.iMg);
        this.vNW = true;
      }
      AppMethodBeat.o(169758);
      return;
    }
  }
  
  private static int apJ(String paramString)
  {
    int j = 10000;
    AppMethodBeat.i(27460);
    int i = j;
    if (!bs.isNullOrNil(paramString)) {}
    try
    {
      i = bs.getInt(Uri.parse(paramString).getQueryParameter("scene"), 10000);
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
      ac.i("MicroMsg.ContactWidgetNewBizInfo", "not obtailBizInfoFromCgi, use cache");
      AppMethodBeat.o(27450);
      return;
    }
    this.isLoading = true;
    Object localObject = new b.a();
    ((b.a)localObject).funcId = 2656;
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/bizattr/bizprofilev2";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    nk localnk = new nk();
    localnk.EaV = paramString;
    if (paramb != null)
    {
      localnk.Edq = 1;
      localnk.Edo = paramb;
      localnk.Edr = 20;
      localnk.Scene = this.iMg;
      localnk.Eds = com.tencent.mm.storage.v.getSessionId();
      ((b.a)localObject).hvt = localnk;
      ((b.a)localObject).hvu = new nl();
      localObject = ((b.a)localObject).aAz();
      paramb = new x.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb, n paramAnonymousn)
        {
          AppMethodBeat.i(196060);
          ac.i("MicroMsg.ContactWidgetNewBizInfo", "callback, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          paramAnonymousString = (nl)paramAnonymousb.hvs.hvw;
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousString != null))
          {
            paramAnonymousb = a.vOV;
            a.a(paramAnonymousString.Edv);
            if (paramb == null) {
              break label379;
            }
            if ((!paramb.equals(ContactWidgetNewBizInfo.k(ContactWidgetNewBizInfo.this).Edv.EcW.Edo)) || (paramAnonymousString.Edv == null)) {
              break label369;
            }
            ContactWidgetNewBizInfo.k(ContactWidgetNewBizInfo.this).Edv.EcV.addAll(paramAnonymousString.Edv.EcV);
            ContactWidgetNewBizInfo.k(ContactWidgetNewBizInfo.this).Edv.EcW = paramAnonymousString.Edv.EcW;
            if (paramb == null) {
              break label415;
            }
            if ((ContactWidgetNewBizInfo.k(ContactWidgetNewBizInfo.this) != null) && (ContactWidgetNewBizInfo.k(ContactWidgetNewBizInfo.this).Edv != null))
            {
              ContactWidgetNewBizInfo.a(ContactWidgetNewBizInfo.this, ContactWidgetNewBizInfo.k(ContactWidgetNewBizInfo.this));
              com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.K(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username, 106, ContactWidgetNewBizInfo.h(ContactWidgetNewBizInfo.this));
            }
            label220:
            if ((paramAnonymousString.Ebf & 0x4) == 0) {
              break label442;
            }
            paramAnonymousb = ContactWidgetNewBizInfo.c(4, paramAnonymousString.Edz);
            if (paramAnonymousb == null) {
              break label442;
            }
            paramAnonymousn = (NewBizInfoErrMsgPreference)ContactWidgetNewBizInfo.c(ContactWidgetNewBizInfo.this).aPN("contact_info_biz_err_msg");
            ContactWidgetNewBizInfo.c(ContactWidgetNewBizInfo.this).cK("contact_info_biz_err_msg", false);
            paramAnonymousn.setErrMsg(paramAnonymousb);
          }
          for (;;)
          {
            for (;;)
            {
              if ((paramAnonymousString.Ebf & 0x2) != 0)
              {
                paramAnonymousString = (NewBizInfoHeaderPreference)ContactWidgetNewBizInfo.c(ContactWidgetNewBizInfo.this).aPN("contact_info_header_newbizinfo");
                paramAnonymousString.vOx = true;
                if (paramAnonymousString.fxQ != null)
                {
                  com.tencent.mm.plugin.brandservice.b.d.a(paramAnonymousString.fxQ, paramAnonymousString.contact, "", true);
                  paramAnonymousString.fxQ.setClickable(false);
                }
              }
              ContactWidgetNewBizInfo.n(ContactWidgetNewBizInfo.this);
              ContactWidgetNewBizInfo.o(ContactWidgetNewBizInfo.this);
              AppMethodBeat.o(196060);
              return 0;
              label369:
              ac.e("MicroMsg.ContactWidgetNewBizInfo", "drop err resp");
              break;
              try
              {
                label379:
                ContactWidgetNewBizInfo.k(ContactWidgetNewBizInfo.this).parseFrom(paramAnonymousString.toByteArray());
              }
              catch (IOException paramAnonymousb)
              {
                ac.printErrStackTrace("MicroMsg.ContactWidgetNewBizInfo", paramAnonymousb, "profileInfo.parseFrom", new Object[0]);
              }
            }
            break;
            label415:
            a.b(ContactWidgetNewBizInfo.k(ContactWidgetNewBizInfo.this));
            ContactWidgetNewBizInfo.l(ContactWidgetNewBizInfo.this);
            ContactWidgetNewBizInfo.m(ContactWidgetNewBizInfo.this);
            break label220;
            label442:
            if ((paramAnonymousString.Ebf & 0x8) != 0)
            {
              paramAnonymousb = ContactWidgetNewBizInfo.c(8, paramAnonymousString.Edz);
              if (paramAnonymousb != null)
              {
                paramAnonymousn = (NewBizInfoErrMsgPreference)ContactWidgetNewBizInfo.c(ContactWidgetNewBizInfo.this).aPN("contact_info_biz_err_msg");
                ContactWidgetNewBizInfo.c(ContactWidgetNewBizInfo.this).cK("contact_info_biz_err_msg", false);
                paramAnonymousn.setErrMsg(paramAnonymousb);
                continue;
              }
            }
            ContactWidgetNewBizInfo.c(ContactWidgetNewBizInfo.this).cK("contact_info_biz_err_msg", true);
          }
        }
      };
      if (!(this.vNT instanceof com.tencent.mm.vending.e.b)) {
        break label197;
      }
    }
    label197:
    for (paramString = this.vNT;; paramString = null)
    {
      x.a((com.tencent.mm.ak.b)localObject, paramb, false, paramString);
      AppMethodBeat.o(27450);
      return;
      localnk.Edq = 0;
      localnk.Edr = 5;
      break;
    }
  }
  
  private boolean bPe()
  {
    AppMethodBeat.i(27452);
    if ((this.vNU != null) && (this.vNU.Edt != null) && (this.vNU.Edt.DZr == 0) && (!dqL()))
    {
      AppMethodBeat.o(27452);
      return true;
    }
    AppMethodBeat.o(27452);
    return false;
  }
  
  private void dqI()
  {
    AppMethodBeat.i(27446);
    if (this.vNV != null)
    {
      AppMethodBeat.o(27446);
      return;
    }
    com.tencent.mm.ui.base.preference.h localh = (com.tencent.mm.ui.base.preference.h)this.vNT.getListView().getAdapter();
    if (localh == null)
    {
      ac.e("MicroMsg.ContactWidgetNewBizInfo", "empty adapter");
      AppMethodBeat.o(27446);
      return;
    }
    this.vNV = new com.tencent.mm.plugin.profile.ui.newbizinfo.b.c(this.vNT, this, localh, new String[] { "contact_info_biz_err_msg", "contact_info_footer_space" });
    localh.HFq = this.vNV;
    AppMethodBeat.o(27446);
  }
  
  private void dqJ()
  {
    AppMethodBeat.i(27448);
    com.tencent.mm.api.c localc2 = com.tencent.mm.al.f.dX(this.contact.field_username);
    this.cFl = null;
    this.cFm = null;
    this.vKj = null;
    com.tencent.mm.api.c localc1;
    if (localc2 != null)
    {
      localc1 = localc2;
      if (localc2.bV(false) != null) {}
    }
    else
    {
      localc1 = localc2;
      if (this.vKk != null)
      {
        localc1 = new com.tencent.mm.api.c();
        localc1.field_username = this.contact.field_username;
        localc1.field_brandFlag = this.vKk.iKh;
        localc1.field_brandIconURL = this.vKk.iKk;
        localc1.field_brandInfo = this.vKk.iKj;
        localc1.field_extInfo = this.vKk.iKi;
        localc1.field_type = localc1.bV(false).getServiceType();
      }
    }
    if ((localc1 != null) && (localc1.field_brandInfo == null) && (localc1.field_extInfo == null) && (this.vKk != null))
    {
      localc1.field_username = this.contact.field_username;
      localc1.field_brandFlag = this.vKk.iKh;
      localc1.field_brandIconURL = this.vKk.iKk;
      localc1.field_brandInfo = this.vKk.iKj;
      localc1.field_extInfo = this.vKk.iKi;
      localc1.field_type = localc1.bV(false).getServiceType();
    }
    if (localc1 != null)
    {
      this.vIG = localc1;
      this.cFl = localc1.IW();
      this.cFm = localc1.bV(false);
      this.vKj = this.cFm.getWxaEntryInfoList();
      if ((this.cFm.Ja() != null) && (this.cFm.Ja().length() > 0)) {
        this.cFv = this.cFm.Ja();
      }
    }
    AppMethodBeat.o(27448);
  }
  
  private boolean dqL()
  {
    boolean bool1 = true;
    AppMethodBeat.i(27453);
    try
    {
      String str = this.cFm.Jd();
      boolean bool2 = bs.isNullOrNil(str);
      if (bool2)
      {
        AppMethodBeat.o(27453);
        return false;
      }
      long l = bs.getLong(str, 0L);
      if ((l > 0L) && (l - System.currentTimeMillis() / 1000L < 0L)) {}
      for (;;)
      {
        ac.d("MicroMsg.ContactWidgetNewBizInfo", "isBizAccountTimeExpired:%b", new Object[] { Boolean.valueOf(bool1) });
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
  private void dqM()
  {
    // Byte code:
    //   0: sipush 27459
    //   3: invokestatic 117	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 158	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo:vNT	Lcom/tencent/mm/plugin/profile/ui/ContactInfoUI;
    //   10: invokevirtual 823	com/tencent/mm/plugin/profile/ui/ContactInfoUI:getIntent	()Landroid/content/Intent;
    //   13: astore 13
    //   15: aload 13
    //   17: ldc_w 825
    //   20: iconst_0
    //   21: invokevirtual 828	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   24: invokestatic 834	com/tencent/mm/plugin/profile/ui/newbizinfo/b/g:LE	(I)I
    //   27: istore_1
    //   28: aload 13
    //   30: ldc_w 836
    //   33: invokevirtual 839	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   36: astore 14
    //   38: aload 13
    //   40: ldc_w 841
    //   43: invokevirtual 839	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   46: astore 15
    //   48: aload 13
    //   50: ldc_w 843
    //   53: iconst_0
    //   54: invokevirtual 828	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   57: aload 14
    //   59: invokestatic 847	com/tencent/mm/plugin/profile/ui/newbizinfo/b/g:bx	(ILjava/lang/String;)I
    //   62: istore_2
    //   63: aload 13
    //   65: ldc_w 638
    //   68: invokevirtual 839	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   71: astore 8
    //   73: aload 13
    //   75: ldc_w 849
    //   78: invokevirtual 839	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   81: astore 12
    //   83: aload 13
    //   85: ldc_w 851
    //   88: invokevirtual 855	android/content/Intent:getBundleExtra	(Ljava/lang/String;)Landroid/os/Bundle;
    //   91: astore 10
    //   93: ldc 129
    //   95: astore 9
    //   97: aload 10
    //   99: ifnull +15 -> 114
    //   102: aload 10
    //   104: ldc_w 857
    //   107: ldc 129
    //   109: invokevirtual 863	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   112: astore 9
    //   114: aload 13
    //   116: ldc_w 865
    //   119: iconst_m1
    //   120: invokevirtual 828	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   123: invokestatic 870	com/tencent/mm/ui/e$a:Zn	(I)I
    //   126: istore_3
    //   127: aload_0
    //   128: getfield 470	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo:contact	Lcom/tencent/mm/storage/ai;
    //   131: getfield 230	com/tencent/mm/g/c/av:field_username	Ljava/lang/String;
    //   134: astore 16
    //   136: aload 9
    //   138: invokestatic 488	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   141: ifne +429 -> 570
    //   144: aload 9
    //   146: invokestatic 873	com/tencent/mm/sdk/platformtools/bs:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   149: ldc_w 875
    //   152: invokestatic 879	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   155: astore 9
    //   157: aload 8
    //   159: astore 10
    //   161: aload 8
    //   163: invokestatic 873	com/tencent/mm/sdk/platformtools/bs:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   166: ldc_w 875
    //   169: invokestatic 879	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   172: astore 8
    //   174: aload 8
    //   176: astore 10
    //   178: aload 12
    //   180: invokestatic 873	com/tencent/mm/sdk/platformtools/bs:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   183: ldc_w 875
    //   186: invokestatic 879	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   189: astore 11
    //   191: aload 11
    //   193: astore 10
    //   195: getstatic 219	com/tencent/mm/plugin/report/service/h:wUl	Lcom/tencent/mm/plugin/report/service/h;
    //   198: sipush 16232
    //   201: bipush 9
    //   203: anewarray 4	java/lang/Object
    //   206: dup
    //   207: iconst_0
    //   208: iload_1
    //   209: invokestatic 337	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   212: aastore
    //   213: dup
    //   214: iconst_1
    //   215: iload_2
    //   216: invokestatic 337	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
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
    //   250: invokestatic 337	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   253: aastore
    //   254: dup
    //   255: bipush 8
    //   257: aload 16
    //   259: aastore
    //   260: invokevirtual 882	com/tencent/mm/plugin/report/service/h:f	(I[Ljava/lang/Object;)V
    //   263: aload_0
    //   264: getfield 123	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo:vKu	Ljava/lang/String;
    //   267: invokestatic 488	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   270: ifne +16 -> 286
    //   273: getstatic 219	com/tencent/mm/plugin/report/service/h:wUl	Lcom/tencent/mm/plugin/report/service/h;
    //   276: sipush 16697
    //   279: aload_0
    //   280: getfield 123	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo:vKu	Ljava/lang/String;
    //   283: invokevirtual 886	com/tencent/mm/plugin/report/service/h:kvStat	(ILjava/lang/String;)V
    //   286: aload 13
    //   288: ldc_w 825
    //   291: iconst_0
    //   292: invokevirtual 828	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   295: istore_1
    //   296: invokestatic 815	java/lang/System:currentTimeMillis	()J
    //   299: ldc2_w 279
    //   302: ldiv
    //   303: l2i
    //   304: i2l
    //   305: lstore 4
    //   307: iload_1
    //   308: sipush 160
    //   311: if_icmpne +147 -> 458
    //   314: aload 13
    //   316: ldc_w 888
    //   319: lconst_0
    //   320: invokevirtual 891	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   323: lstore 6
    //   325: getstatic 219	com/tencent/mm/plugin/report/service/h:wUl	Lcom/tencent/mm/plugin/report/service/h;
    //   328: sipush 15721
    //   331: bipush 9
    //   333: anewarray 4	java/lang/Object
    //   336: dup
    //   337: iconst_0
    //   338: aload_0
    //   339: getfield 470	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo:contact	Lcom/tencent/mm/storage/ai;
    //   342: getfield 230	com/tencent/mm/g/c/av:field_username	Ljava/lang/String;
    //   345: aastore
    //   346: dup
    //   347: iconst_1
    //   348: iconst_0
    //   349: invokestatic 337	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   352: aastore
    //   353: dup
    //   354: iconst_2
    //   355: bipush 14
    //   357: invokestatic 337	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   360: aastore
    //   361: dup
    //   362: iconst_3
    //   363: lload 4
    //   365: invokestatic 896	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   368: aastore
    //   369: dup
    //   370: iconst_4
    //   371: invokestatic 548	com/tencent/mm/storage/v:getSessionId	()I
    //   374: invokestatic 337	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   377: aastore
    //   378: dup
    //   379: iconst_5
    //   380: iconst_0
    //   381: invokestatic 337	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   384: aastore
    //   385: dup
    //   386: bipush 6
    //   388: lload 6
    //   390: invokestatic 896	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   393: aastore
    //   394: dup
    //   395: bipush 7
    //   397: ldc 129
    //   399: aastore
    //   400: dup
    //   401: bipush 8
    //   403: iconst_1
    //   404: invokestatic 337	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   407: aastore
    //   408: invokevirtual 882	com/tencent/mm/plugin/report/service/h:f	(I[Ljava/lang/Object;)V
    //   411: getstatic 219	com/tencent/mm/plugin/report/service/h:wUl	Lcom/tencent/mm/plugin/report/service/h;
    //   414: ldc2_w 897
    //   417: ldc2_w 899
    //   420: lconst_1
    //   421: iconst_0
    //   422: invokevirtual 225	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   425: sipush 27459
    //   428: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   431: return
    //   432: astore 10
    //   434: ldc 129
    //   436: astore 9
    //   438: ldc 206
    //   440: aload 10
    //   442: ldc 129
    //   444: iconst_0
    //   445: anewarray 4	java/lang/Object
    //   448: invokestatic 904	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   451: aload 12
    //   453: astore 10
    //   455: goto -260 -> 195
    //   458: iload_1
    //   459: sipush 174
    //   462: if_icmpne +88 -> 550
    //   465: getstatic 219	com/tencent/mm/plugin/report/service/h:wUl	Lcom/tencent/mm/plugin/report/service/h;
    //   468: sipush 15721
    //   471: bipush 9
    //   473: anewarray 4	java/lang/Object
    //   476: dup
    //   477: iconst_0
    //   478: aload_0
    //   479: getfield 470	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo:contact	Lcom/tencent/mm/storage/ai;
    //   482: getfield 230	com/tencent/mm/g/c/av:field_username	Ljava/lang/String;
    //   485: aastore
    //   486: dup
    //   487: iconst_1
    //   488: iconst_0
    //   489: invokestatic 337	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   492: aastore
    //   493: dup
    //   494: iconst_2
    //   495: bipush 21
    //   497: invokestatic 337	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   500: aastore
    //   501: dup
    //   502: iconst_3
    //   503: lload 4
    //   505: invokestatic 896	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   508: aastore
    //   509: dup
    //   510: iconst_4
    //   511: invokestatic 548	com/tencent/mm/storage/v:getSessionId	()I
    //   514: invokestatic 337	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   517: aastore
    //   518: dup
    //   519: iconst_5
    //   520: iconst_0
    //   521: invokestatic 337	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   524: aastore
    //   525: dup
    //   526: bipush 6
    //   528: iconst_0
    //   529: invokestatic 337	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   532: aastore
    //   533: dup
    //   534: bipush 7
    //   536: ldc 129
    //   538: aastore
    //   539: dup
    //   540: bipush 8
    //   542: iconst_2
    //   543: invokestatic 337	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   546: aastore
    //   547: invokevirtual 882	com/tencent/mm/plugin/report/service/h:f	(I[Ljava/lang/Object;)V
    //   550: sipush 27459
    //   553: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   556: return
    //   557: astore 11
    //   559: aload 10
    //   561: astore 8
    //   563: aload 11
    //   565: astore 10
    //   567: goto -129 -> 438
    //   570: ldc 129
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
  
  private void dqc()
  {
    AppMethodBeat.i(27451);
    bYJ();
    dqJ();
    this.screen.removeAll();
    this.screen.addPreferencesFromResource(2131951647);
    Object localObject = (NewBizInfoHeaderPreference)this.screen.aPN("contact_info_header_newbizinfo");
    if ((localObject != null) && (!bs.isNullOrNil(this.contact.field_username)))
    {
      ((NewBizInfoHeaderPreference)localObject).a(this.contact, this.vIX, this.vIG, this.vNU);
      this.vNZ = true;
      if (this.vNU == null) {
        break label594;
      }
      if (!com.tencent.mm.n.b.ln(this.contact.field_type)) {
        break label563;
      }
      this.screen.cK("contact_info_biz_add", true);
      this.screen.cK("contact_info_biz_go_chatting", false);
      ((NewBizInfoFollowPreference)this.screen.aPN("contact_info_biz_go_chatting")).vIR = this;
      label161:
      if ((this.vNU != null) && (this.vNU.Edt != null) && (this.vNU.Edv != null) && (this.vNU.Edv.EcW != null)) {
        a(this.vNU);
      }
      if ((this.vNU != null) && (!bPe()) && (!com.tencent.mm.n.b.ln(this.contact.field_type))) {
        this.vNT.showOptionMenu(false);
      }
      if ((this.vNU == null) || (this.vNU.Edy == null)) {
        break label639;
      }
      this.screen.cK("contact_info_biz_menu_newbizinfo", false);
      if (this.vNU != null) {
        ((NewBizInfoMenuPreference)this.screen.aPN("contact_info_biz_menu_newbizinfo")).a(this.vNU.Edy, this.contact, this.iMg);
      }
    }
    for (;;)
    {
      this.screen.cK("contact_info_biz_err_msg", true);
      ac.d("MicroMsg.ContactWidgetNewBizInfo", "KIsardDevice(%b)", new Object[] { Boolean.valueOf(this.vNT.getIntent().getBooleanExtra("KIsHardDevice", false)) });
      if ((this.vNT.getIntent() == null) || (!this.vNT.getIntent().getBooleanExtra("KIsHardDevice", false))) {
        break label677;
      }
      ac.d("MicroMsg.ContactWidgetNewBizInfo", "Hard device biz...");
      boolean bool = dqf();
      ac.d("MicroMsg.ContactWidgetNewBizInfo", "contact.isContact()(%b), isHarDeviceBound(%b)", new Object[] { Boolean.valueOf(com.tencent.mm.n.b.ln(this.contact.field_type)), Boolean.valueOf(bool) });
      if ((com.tencent.mm.n.b.ln(this.contact.field_type)) && (bool)) {
        break label670;
      }
      ac.w("MicroMsg.ContactWidgetNewBizInfo", "%s is not my hard biz contact", new Object[] { this.contact.field_username });
      dqd();
      localObject = (NewBizInfoNotFollowPreference)this.screen.aPN("contact_info_biz_add");
      this.screen.cK("contact_info_biz_add", false);
      if (localObject == null) {
        break label670;
      }
      if (!bool) {
        break label656;
      }
      ((NewBizInfoNotFollowPreference)localObject).setTitle(this.vNT.getString(2131757610));
      AppMethodBeat.o(27451);
      return;
      ac.w("MicroMsg.ContactWidgetNewBizInfo", "head pref is null");
      this.screen.cK("contact_info_header_bizinfo", true);
      break;
      label563:
      this.screen.cK("contact_info_biz_add", false);
      this.screen.cK("contact_info_biz_go_chatting", true);
      break label161;
      label594:
      this.screen.cK("contact_info_biz_add", true);
      this.screen.cK("contact_info_biz_go_chatting", true);
      this.screen.cK("contact_info_biz_space", false);
      break label161;
      label639:
      this.screen.cK("contact_info_biz_menu_newbizinfo", true);
    }
    label656:
    ((NewBizInfoNotFollowPreference)localObject).setTitle(this.vNT.getString(2131757596));
    label670:
    AppMethodBeat.o(27451);
    return;
    label677:
    if (dqL())
    {
      this.screen.cK("contact_info_biz_loading", false);
      this.screen.cK("contact_info_biz_add", true);
      this.screen.cK("contact_info_biz_go_chatting", true);
      this.screen.cK("contact_info_message_newbizinfo", true);
    }
    AppMethodBeat.o(27451);
  }
  
  private void dqd()
  {
    AppMethodBeat.i(27454);
    if ((this.contact != null) && ((w.xo(this.contact.field_username)) || (w.xz(this.contact.field_username))) && (com.tencent.mm.n.b.ln(this.contact.field_type)))
    {
      this.screen.cK("contact_info_biz_go_chatting", false);
      AppMethodBeat.o(27454);
      return;
    }
    this.screen.cK("contact_info_biz_go_chatting", true);
    AppMethodBeat.o(27454);
  }
  
  private void dqe()
  {
    AppMethodBeat.i(27458);
    if ((NewBizInfoHeaderPreference)this.screen.aPN("contact_info_header_newbizinfo") != null) {
      NewBizInfoHeaderPreference.wn(System.currentTimeMillis());
    }
    if ((this.vNT.getIntent() != null) && (this.vNT.getIntent().getBooleanExtra("KIsHardDevice", false)))
    {
      localObject1 = this.vNT.getIntent().getStringExtra("KHardDeviceBindTicket");
      if (!bs.isNullOrNil((String)localObject1)) {
        break label334;
      }
      ac.i("MicroMsg.ContactWidgetNewBizInfo", "bindTicket is null, means it is not switch from QRcode scan, just add contact");
    }
    label334:
    while (dqf())
    {
      localObject1 = new com.tencent.mm.pluginsdk.ui.applet.a(this.vNT, new a.a()
      {
        public final void a(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(196063);
          ai localai;
          if (paramAnonymousBoolean1)
          {
            com.tencent.mm.ui.base.h.cg(ContactWidgetNewBizInfo.b(ContactWidgetNewBizInfo.this), ContactWidgetNewBizInfo.b(ContactWidgetNewBizInfo.this).getString(2131757607));
            ContactWidgetNewBizInfo.c(ContactWidgetNewBizInfo.this).cK("contact_info_time_expired", true);
            localai = ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this);
            if ((localai != null) && (!bs.isNullOrNil(paramAnonymousString1))) {
              break label379;
            }
            ac.e("MicroMsg.ContactWidgetNewBizInfo", "respUsername == " + paramAnonymousString1 + ", contact = " + localai);
            if (ContactWidgetNewBizInfo.q(ContactWidgetNewBizInfo.this) != null)
            {
              paramAnonymousString1 = new ql();
              ContactWidgetNewBizInfo.q(ContactWidgetNewBizInfo.this).hTz = 4;
              paramAnonymousString1.dtt.dtu = ContactWidgetNewBizInfo.q(ContactWidgetNewBizInfo.this);
              com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousString1);
            }
            paramAnonymousString1 = af.aCW().AE(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username);
            paramAnonymousString1.field_status = 1;
            if ((!bs.isNullOrNil(paramAnonymousString1.field_extInfo)) || (bs.isNullOrNil(paramAnonymousString1.field_username)) || (ContactWidgetNewBizInfo.r(ContactWidgetNewBizInfo.this) == null) || (!paramAnonymousString1.field_username.equals(bs.nullAsNil(ContactWidgetNewBizInfo.r(ContactWidgetNewBizInfo.this).field_username)))) {
              break label667;
            }
            af.aCW().g(ContactWidgetNewBizInfo.r(ContactWidgetNewBizInfo.this));
            label240:
            paramAnonymousBoolean1 = ContactWidgetNewBizInfo.b(ContactWidgetNewBizInfo.this).getIntent().getBooleanExtra("key_biz_profile_stay_after_follow_op", false);
            paramAnonymousBoolean2 = ContactWidgetNewBizInfo.b(ContactWidgetNewBizInfo.this).getIntent().getBooleanExtra("key_start_biz_profile_from_app_brand_profile", false);
            if (!paramAnonymousString1.IN()) {
              break label678;
            }
            paramAnonymousString1 = new Intent();
            paramAnonymousString1.putExtra("enterprise_biz_name", ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username);
            paramAnonymousString1.putExtra("enterprise_biz_display_name", com.tencent.mm.model.v.wk(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username));
            paramAnonymousString1.putExtra("enterprise_from_scene", 7);
            paramAnonymousString1.addFlags(67108864);
            com.tencent.mm.br.d.e(ContactWidgetNewBizInfo.b(ContactWidgetNewBizInfo.this), ".ui.conversation.EnterpriseConversationUI", paramAnonymousString1);
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
              AppMethodBeat.o(196063);
              return;
              paramAnonymousString2 = null;
              if (w.wF(localai.field_username))
              {
                String str = bs.nullAsNil(localai.field_username);
                paramAnonymousString2 = com.tencent.mm.al.f.dX(str);
                if (paramAnonymousString2 != null) {
                  paramAnonymousString2.field_username = paramAnonymousString1;
                }
                af.aCW().delete(str);
                localai.qp(str);
              }
              localai.setUsername(paramAnonymousString1);
              if ((int)localai.fLJ == 0)
              {
                az.ayM();
                com.tencent.mm.model.c.awB().ah(localai);
              }
              if ((int)localai.fLJ <= 0)
              {
                ac.e("MicroMsg.ContactWidgetNewBizInfo", "addContact : insert contact failed");
                break;
              }
              w.u(localai);
              az.ayM();
              paramAnonymousString1 = com.tencent.mm.model.c.awB().aNt(localai.field_username);
              if (paramAnonymousString2 != null)
              {
                af.aCW().f(paramAnonymousString2);
                break;
              }
              paramAnonymousString2 = com.tencent.mm.al.f.dX(paramAnonymousString1.field_username);
              if ((paramAnonymousString1.fad()) && (com.tencent.mm.al.a.aCo())) {}
              for (int i = 1;; i = 0)
              {
                if ((paramAnonymousString2 != null) && ((!paramAnonymousString2.IH()) || (i != 0))) {
                  break label608;
                }
                ac.d("MicroMsg.ContactWidgetNewBizInfo", "shouldUpdate");
                ar.a.hnw.aJ(paramAnonymousString1.field_username, "");
                com.tencent.mm.aj.c.zU(paramAnonymousString1.field_username);
                break;
              }
              if ((!paramAnonymousString1.fah()) || (i != 0)) {
                break;
              }
              ac.d("MicroMsg.ContactWidgetNewBizInfo", "update contact, last check time=%d", new Object[] { Integer.valueOf(paramAnonymousString1.eyc) });
              ar.a.hnw.aJ(paramAnonymousString1.field_username, "");
              com.tencent.mm.aj.c.zU(paramAnonymousString1.field_username);
              break;
              af.aCW().g(paramAnonymousString1);
              break label240;
              paramAnonymousString1 = new Intent();
              paramAnonymousString1.putExtra("Chat_User", ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username);
              paramAnonymousString1.putExtra("key_has_add_contact", true);
              paramAnonymousString1.putExtra("finish_direct", true);
              if (paramAnonymousBoolean2) {
                paramAnonymousString1.addFlags(268435456);
              }
              com.tencent.mm.storage.v.aMS(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username);
              com.tencent.mm.plugin.profile.b.iyx.d(paramAnonymousString1, ContactWidgetNewBizInfo.b(ContactWidgetNewBizInfo.this));
              if (paramAnonymousBoolean1) {
                break label355;
              }
            } while (!paramAnonymousBoolean2);
          }
        }
      });
      localObject2 = new LinkedList();
      ((LinkedList)localObject2).add(Integer.valueOf(this.iMg));
      if (this.cFv != null) {
        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).DpL = this.cFv;
      }
      if (!bs.isNullOrNil(this.sBi)) {
        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).sBi = this.sBi;
      }
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).DpR = true;
      String str = this.vNT.getIntent().getStringExtra("url");
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).DpS = str;
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).nLC = e.a.Zn(this.vNT.getIntent().getIntExtra("qbarScene", -1));
      dpj localdpj = new dpj();
      localdpj.DSv = this.vNT.getIntent().getIntExtra("Contact_Sub_Scene", 0);
      localdpj.EvK = this.vNT.getIntent().getStringExtra("Contact_Scene_Note");
      if (!bs.isNullOrNil(str))
      {
        if (bs.isNullOrNil(localdpj.EvK)) {
          localdpj.EvK = str;
        }
        if (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).Tg(str)) {
          localdpj.FWL = apJ(str);
        }
      }
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).DpT = localdpj;
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).a(this.contact.field_username, (LinkedList)localObject2, this.vKu);
      dqM();
      AppMethodBeat.o(27458);
      return;
    }
    ac.d("MicroMsg.ContactWidgetNewBizInfo", "IsHardDevice, bindTicket = %s", new Object[] { localObject1 });
    az.agi().a(536, this);
    Object localObject2 = new dk();
    ((dk)localObject2).dcR.dcT = ((String)localObject1);
    ((dk)localObject2).dcR.opType = 1;
    com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject2);
    Object localObject1 = ((dk)localObject2).dcS.dcV;
    localObject2 = this.vNT;
    this.vNT.getString(2131755906);
    this.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject2, this.vNT.getString(2131755936), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(196062);
        az.agi().b(536, ContactWidgetNewBizInfo.this);
        paramAnonymousDialogInterface = new dk();
        paramAnonymousDialogInterface.dcR.opType = 2;
        paramAnonymousDialogInterface.dcR.dcV = this.cXh;
        com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousDialogInterface);
        AppMethodBeat.o(196062);
      }
    });
    AppMethodBeat.o(27458);
  }
  
  private boolean dqf()
  {
    AppMethodBeat.i(27462);
    if (this.vNT.getIntent() == null)
    {
      AppMethodBeat.o(27462);
      return false;
    }
    String str1 = this.vNT.getIntent().getStringExtra("device_id");
    String str2 = this.vNT.getIntent().getStringExtra("device_type");
    do localdo = new do();
    localdo.ddc.cIZ = str1;
    localdo.ddc.dda = str2;
    com.tencent.mm.sdk.b.a.GpY.l(localdo);
    boolean bool = localdo.ddd.dde;
    AppMethodBeat.o(27462);
    return bool;
  }
  
  private void initActionBar()
  {
    AppMethodBeat.i(27445);
    this.vNT.setMMTitle(bs.nullAsNil(this.contact.field_nickname));
    this.vNT.setMMTitleColor(0);
    this.vNT.setTitleDividerVis(false);
    this.vNT.setIsDarkActionbarBg(false);
    this.vNT.setActionbarColor(ao.aJ(this.vNT, 2130968579));
    this.vNT.hideActionbarLine();
    this.vNT.setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(196054);
        ContactWidgetNewBizInfo.b(ContactWidgetNewBizInfo.this).onBackPressed();
        AppMethodBeat.o(196054);
        return true;
      }
    }, 2131689490);
    this.vNT.removeAllOptionMenu();
    this.vNT.addIconOptionMenu(1, 2131764452, 2131689494, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(196055);
        ContactWidgetNewBizInfo.d(ContactWidgetNewBizInfo.this);
        AppMethodBeat.o(196055);
        return true;
      }
    });
    this.vNT.addIconOptionMenu(0, "", 2131689493, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(27434);
        paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(ContactWidgetNewBizInfo.b(ContactWidgetNewBizInfo.this), 1, false);
        paramAnonymousMenuItem.ISu = new n.c()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
          {
            AppMethodBeat.i(196057);
            if (com.tencent.mm.n.b.ln(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_type)) {
              if (ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).aaN()) {
                if ((com.tencent.mm.storage.v.bIO()) && (com.tencent.mm.al.f.AO(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username))) {
                  paramAnonymous2l.jw(5, 2131757612);
                }
              }
            }
            for (;;)
            {
              paramAnonymous2l.jw(2, 2131757807);
              paramAnonymous2l.jw(6, 2131757156);
              if (com.tencent.mm.n.b.ln(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_type)) {
                paramAnonymous2l.jw(3, 2131757623);
              }
              AppMethodBeat.o(196057);
              return;
              paramAnonymous2l.jw(5, 2131761053);
              continue;
              if ((com.tencent.mm.storage.v.bIO()) && (com.tencent.mm.al.f.AO(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username)))
              {
                paramAnonymous2l.jw(4, 2131757608);
              }
              else
              {
                paramAnonymous2l.jw(4, 2131757877);
                continue;
                if ((int)ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).fLJ <= 0) {
                  ar.a.hnw.a(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username, "", new ar.b.a()
                  {
                    public final void p(String paramAnonymous3String, boolean paramAnonymous3Boolean)
                    {
                      AppMethodBeat.i(196056);
                      ac.i("MicroMsg.ContactWidgetNewBizInfo", "onCreateMMMenu Fetch Contact username:%s, succ: %b", new Object[] { paramAnonymous3String, Boolean.valueOf(paramAnonymous3Boolean) });
                      AppMethodBeat.o(196056);
                    }
                  });
                }
              }
            }
          }
        };
        paramAnonymousMenuItem.ISv = new n.d()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(196058);
            switch (paramAnonymous2MenuItem.getItemId())
            {
            default: 
              ac.w("MicroMsg.ContactWidgetNewBizInfo", "default onMMMenuItemSelected err");
            case 2: 
            case 3: 
            case 4: 
            case 5: 
              do
              {
                do
                {
                  AppMethodBeat.o(196058);
                  return;
                  ContactWidgetNewBizInfo.f(ContactWidgetNewBizInfo.this);
                  AppMethodBeat.o(196058);
                  return;
                  ContactWidgetNewBizInfo.g(ContactWidgetNewBizInfo.this);
                  AppMethodBeat.o(196058);
                  return;
                  com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.K(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username, 903, ContactWidgetNewBizInfo.h(ContactWidgetNewBizInfo.this));
                  com.tencent.mm.model.j.vL(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username);
                  ContactWidgetNewBizInfo.i(ContactWidgetNewBizInfo.this);
                } while ((com.tencent.mm.storage.v.bIO()) && (!com.tencent.mm.al.f.AM(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username)));
                com.tencent.mm.ui.base.h.cg(ContactWidgetNewBizInfo.b(ContactWidgetNewBizInfo.this), ContactWidgetNewBizInfo.b(ContactWidgetNewBizInfo.this).getString(2131761054));
                AppMethodBeat.o(196058);
                return;
                w.E(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username, true);
                com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.K(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username, 904, ContactWidgetNewBizInfo.h(ContactWidgetNewBizInfo.this));
                ContactWidgetNewBizInfo.i(ContactWidgetNewBizInfo.this);
              } while ((com.tencent.mm.storage.v.bIO()) && (!com.tencent.mm.al.f.AM(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username)));
              com.tencent.mm.ui.base.h.cg(ContactWidgetNewBizInfo.b(ContactWidgetNewBizInfo.this), ContactWidgetNewBizInfo.b(ContactWidgetNewBizInfo.this).getString(2131756644));
              AppMethodBeat.o(196058);
              return;
            }
            ContactWidgetNewBizInfo.j(ContactWidgetNewBizInfo.this);
            AppMethodBeat.o(196058);
          }
        };
        paramAnonymousMenuItem.cED();
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.K(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username, 600, ContactWidgetNewBizInfo.h(ContactWidgetNewBizInfo.this));
        AppMethodBeat.o(27434);
        return false;
      }
    });
    AppMethodBeat.o(27445);
  }
  
  final void Lw(int paramInt)
  {
    AppMethodBeat.i(27463);
    if ((this.vKs == null) || ((this.iMg != 39) && (this.iMg != 56) && (this.iMg != 35) && (this.iMg != 87) && (this.iMg != 88) && (this.iMg != 89) && (this.iMg != 85)))
    {
      ac.d("MicroMsg.ContactWidgetNewBizInfo", "mExtArgs is null or the add contact action is not from biz search.");
      AppMethodBeat.o(27463);
      return;
    }
    if (this.contact == null)
    {
      ac.i("MicroMsg.ContactWidgetNewBizInfo", "contact is null.");
      AppMethodBeat.o(27463);
      return;
    }
    String str2 = this.vKs.getString("Contact_Ext_Args_Search_Id");
    String str3 = bs.nullAsNil(this.vKs.getString("Contact_Ext_Args_Query_String"));
    int j = this.vKs.getInt("Contact_Ext_Args_Index");
    int i;
    switch (this.iMg)
    {
    default: 
      i = 0;
      str1 = bs.nullAsNil(this.vKs.getString("Contact_Ext_Extra_Params"));
      str2 = str3 + "," + paramInt + "," + bs.nullAsNil(this.contact.field_username) + "," + j + "," + System.currentTimeMillis() / 1000L + "," + str2 + "," + i;
      if (bs.isNullOrNil(null)) {
        break;
      }
    }
    for (String str1 = str2 + "," + null + "," + str1;; str1 = str2 + ",," + str1)
    {
      ac.v("MicroMsg.ContactWidgetNewBizInfo", "report 10866: %s", new Object[] { str1 });
      com.tencent.mm.plugin.report.service.h.wUl.kvStat(10866, str1);
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
  
  public final long Rw()
  {
    return this.enterTime;
  }
  
  public final boolean WZ(String paramString)
  {
    AppMethodBeat.i(27457);
    if (bs.isNullOrNil(paramString))
    {
      ac.e("MicroMsg.ContactWidgetNewBizInfo", "handleEvent key is null, return");
      AppMethodBeat.o(27457);
      return false;
    }
    ac.i("MicroMsg.ContactWidgetNewBizInfo", "handleEvent key:%s", new Object[] { paramString });
    if ("contact_info_biz_add".endsWith(paramString))
    {
      if (!com.tencent.mm.model.gdpr.c.aAe()) {
        dqe();
      }
      for (;;)
      {
        if (this.vKo != 0) {
          com.tencent.mm.plugin.report.service.h.wUl.f(11263, new Object[] { Integer.valueOf(this.vKo), this.contact.field_username });
        }
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.K(this.contact.field_username, 200, this.iMg);
        AppMethodBeat.o(27457);
        return true;
        com.tencent.mm.model.gdpr.c.a(this.vNT, com.tencent.mm.model.gdpr.a.hqA, this.contact.field_username, new com.tencent.mm.model.gdpr.b()
        {
          public final void og(int paramAnonymousInt)
          {
            AppMethodBeat.i(196061);
            if (paramAnonymousInt == 0) {
              ContactWidgetNewBizInfo.p(ContactWidgetNewBizInfo.this);
            }
            AppMethodBeat.o(196061);
          }
        });
      }
    }
    AppMethodBeat.o(27457);
    return true;
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, ai paramai, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(27443);
    if (this.vNT.isFinishing())
    {
      AppMethodBeat.o(27443);
      return true;
    }
    if (paramai != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (bs.nullAsNil(paramai.field_username).length() <= 0) {
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
      U(paramai);
      this.screen = paramf;
      this.contact = paramai;
      this.vIS = paramBoolean;
      this.iMg = paramInt;
      this.vKt = ((SnsAdClick)this.vNT.getIntent().getParcelableExtra("KSnsAdTag"));
      this.vKu = this.vNT.getIntent().getStringExtra("key_add_contact_report_info");
      this.vKo = this.vNT.getIntent().getIntExtra("add_more_friend_search_scene", 0);
      this.vKs = this.vNT.getIntent().getBundleExtra("Contact_Ext_Args");
      this.nLF = this.vNT.getIntent().getStringExtra("key_channel_session_id");
      if (this.vNY)
      {
        this.vNY = false;
        initActionBar();
        this.vNU = a.apL(this.contact.field_username);
        dqc();
        b(paramai.field_username, null);
        paramf = this.vNT.getIntent().getStringExtra("Contact_BIZ_PopupInfoMsg");
        if (!bs.isNullOrNil(paramf))
        {
          this.vNT.getIntent().putExtra("Contact_BIZ_PopupInfoMsg", "");
          com.tencent.mm.ui.base.h.a(this.vNT, paramf, "", this.vNT.getString(2131755835), null);
        }
        if (paramai != null) {
          af.aDi().Ay(paramai.field_username);
        }
      }
      if (this.vOa != null)
      {
        paramf = this.vNT.getListView();
        if (paramf != null) {
          paramf.onRestoreInstanceState(this.vOa);
        }
      }
      if ((this.vNT instanceof FragmentActivity))
      {
        this.vNT.getLifecycle().removeObserver(this);
        this.vNT.getLifecycle().addObserver(this);
      }
      AppMethodBeat.o(27443);
      return true;
      bool = false;
      break;
      bool = false;
      break label52;
    }
  }
  
  public final boolean adU()
  {
    AppMethodBeat.i(27465);
    if ((this.contact == null) || (this.vIG == null) || (this.vNU == null) || (this.vNU.Edu == null) || (this.vNU.Edt == null))
    {
      ac.w("MicroMsg.ContactWidgetNewBizInfo", "reportEnd fail, err");
      this.nAK.dead();
      this.kce.dead();
      AppMethodBeat.o(27465);
      return false;
    }
    this.endTime = System.currentTimeMillis();
    String str = this.contact.field_username;
    int k = this.iMg;
    int m = this.vIG.field_type;
    long l1 = this.enterTime;
    long l2 = this.endTime;
    int i;
    label134:
    int n;
    int i1;
    if (com.tencent.mm.n.b.ln(this.contact.field_type))
    {
      i = 1;
      n = this.vNU.Edu.EaY;
      i1 = this.vNU.Edu.EaZ;
      if (this.vKj == null) {
        break label231;
      }
    }
    label231:
    for (int j = this.vKj.size();; j = 0)
    {
      com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.a(str, k, m, l1, l2, i, n, i1, j, com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.b(this.vNU.Edv), com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.a(this.vNU.Edy), this.vNU.Edt.ncR);
      break;
      i = 0;
      break label134;
    }
  }
  
  public final boolean bYJ()
  {
    AppMethodBeat.i(27455);
    if (this.screen == null)
    {
      AppMethodBeat.o(27455);
      return true;
    }
    Object localObject = (NewBizInfoHeaderPreference)this.screen.aPN("contact_info_header_newbizinfo");
    if (localObject != null) {
      ((NewBizInfoHeaderPreference)localObject).onDetach();
    }
    localObject = this.vNT.getListView();
    if (localObject != null) {
      this.vOa = ((ListView)localObject).onSaveInstanceState();
    }
    AppMethodBeat.o(27455);
    return true;
  }
  
  public final void cfp()
  {
    AppMethodBeat.i(27449);
    if ((this.vNZ) && (this.vNU.Edv != null) && (this.vNU.Edv.EcW != null) && (this.vNU.Edv.EcW.Edp == 0)) {
      b(this.contact.field_username, this.vNU.Edv.EcW.Edo);
    }
    AppMethodBeat.o(27449);
  }
  
  public final ai dqK()
  {
    return this.contact;
  }
  
  public final int dqN()
  {
    return this.iMg;
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public void onActivityDestroy()
  {
    AppMethodBeat.i(27444);
    ac.i("MicroMsg.ContactWidgetNewBizInfo", "[onActivityDestroy]");
    bYJ();
    AppMethodBeat.o(27444);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(27456);
    if (this.vNT == null)
    {
      ac.e("MicroMsg.ContactWidgetNewBizInfo", "null == context");
      AppMethodBeat.o(27456);
      return;
    }
    ac.i("MicroMsg.ContactWidgetNewBizInfo", "onActivityResult, requestCode = %d, resultCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
      com.tencent.mm.plugin.messenger.a.j.dck().q(str1, str2, bool);
      com.tencent.mm.plugin.messenger.a.j.dck().hF(paramIntent, str2);
      com.tencent.mm.ui.widget.snackbar.b.n(this.vNT, this.vNT.getString(2131759420));
      AppMethodBeat.o(27456);
      return;
    }
    AppMethodBeat.o(27456);
  }
  
  public final boolean onCreate()
  {
    AppMethodBeat.i(27464);
    if ((this.contact == null) || (this.vIG == null))
    {
      ac.w("MicroMsg.ContactWidgetNewBizInfo", "reportStart fail, err");
      this.nAK.alive();
      this.kce.alive();
      AppMethodBeat.o(27464);
      return false;
    }
    this.enterTime = System.currentTimeMillis();
    String str = this.contact.field_username;
    int j = this.iMg;
    int k = this.vIG.field_type;
    long l = this.enterTime;
    if (com.tencent.mm.n.b.ln(this.contact.field_type)) {}
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.a(str, j, k, l, i, this.nLF);
      break;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(27461);
    ac.d("MicroMsg.ContactWidgetNewBizInfo", "onSceneEnd errType = " + paramInt1 + ", errCode = " + paramInt2 + ",errMsg = " + paramString);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if (paramn == null)
    {
      ac.e("MicroMsg.ContactWidgetNewBizInfo", "scene == null");
      AppMethodBeat.o(27461);
      return;
    }
    az.agi().b(paramn.getType(), this);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ac.e("MicroMsg.ContactWidgetNewBizInfo", "scene.getType() = %s", new Object[] { Integer.valueOf(paramn.getType()) });
      AppMethodBeat.o(27461);
      return;
    }
    ac.d("MicroMsg.ContactWidgetNewBizInfo", "scene.getType() = %s", new Object[] { Integer.valueOf(paramn.getType()) });
    if (paramn.getType() == 536)
    {
      az.agi().b(536, this);
      dqc();
    }
    AppMethodBeat.o(27461);
  }
  
  static final class a
    extends com.tencent.mm.sdk.b.c<u>
  {
    private WeakReference<ContactWidgetNewBizInfo> vOl;
    
    public a(ContactWidgetNewBizInfo paramContactWidgetNewBizInfo)
    {
      AppMethodBeat.i(196064);
      this.vOl = new WeakReference(paramContactWidgetNewBizInfo);
      this.__eventId = u.class.getName().hashCode();
      AppMethodBeat.o(196064);
    }
  }
  
  static final class b
    extends com.tencent.mm.sdk.b.c<lw>
  {
    private WeakReference<ContactWidgetNewBizInfo> vOl;
    
    public b(ContactWidgetNewBizInfo paramContactWidgetNewBizInfo)
    {
      AppMethodBeat.i(196066);
      this.vOl = new WeakReference(paramContactWidgetNewBizInfo);
      this.__eventId = lw.class.getName().hashCode();
      AppMethodBeat.o(196066);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.ContactWidgetNewBizInfo
 * JD-Core Version:    0.7.0.1
 */