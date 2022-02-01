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
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.al.x;
import com.tencent.mm.al.x.a;
import com.tencent.mm.api.c.a;
import com.tencent.mm.api.c.b;
import com.tencent.mm.g.a.dj;
import com.tencent.mm.g.a.dj.b;
import com.tencent.mm.g.a.dn;
import com.tencent.mm.g.a.dn.b;
import com.tencent.mm.g.a.ln;
import com.tencent.mm.g.a.qc;
import com.tencent.mm.g.a.t;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.az;
import com.tencent.mm.model.w;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.profile.ui.ContactInfoUI;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.a.b;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.protocal.protobuf.ccj;
import com.tencent.mm.protocal.protobuf.dju;
import com.tencent.mm.protocal.protobuf.lj;
import com.tencent.mm.protocal.protobuf.lq;
import com.tencent.mm.protocal.protobuf.lr;
import com.tencent.mm.protocal.protobuf.ls;
import com.tencent.mm.protocal.protobuf.lz;
import com.tencent.mm.protocal.protobuf.mv;
import com.tencent.mm.protocal.protobuf.mw;
import com.tencent.mm.protocal.protobuf.nc;
import com.tencent.mm.protocal.protobuf.nd;
import com.tencent.mm.protocal.protobuf.ne;
import com.tencent.mm.protocal.protobuf.xq;
import com.tencent.mm.protocal.protobuf.zh;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.u;
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
  implements LifecycleObserver, com.tencent.mm.al.g, com.tencent.mm.pluginsdk.b.b
{
  private static String uFk = "crashFlag";
  private static boolean uFl = false;
  private List<c.a> cIe;
  private c.b cIf;
  private String cIo;
  com.tencent.mm.storage.af contact;
  private long endTime;
  long enterTime;
  int ima;
  private boolean isLoading;
  private com.tencent.mm.sdk.b.c jBI;
  private WeakReference<ContactWidgetNewBizInfo> mLl;
  private com.tencent.mm.sdk.b.c mYl;
  private String niM;
  public String rso;
  private com.tencent.mm.ui.base.preference.f screen;
  private p tipDialog;
  private String uAe;
  SnsAdClick uBA;
  private String uBB;
  private List<WxaAttributes.WxaEntryInfo> uBq;
  private zh uBr;
  private int uBv;
  private Bundle uBz;
  ContactInfoUI uFc;
  private ne uFd;
  private com.tencent.mm.plugin.profile.ui.newbizinfo.b.c uFe;
  private boolean uFf;
  private int uFg;
  private boolean uFh;
  private boolean uFi;
  private Parcelable uFj;
  com.tencent.mm.api.c uzN;
  boolean uzZ;
  
  public ContactWidgetNewBizInfo(final ContactInfoUI paramContactInfoUI, final String paramString, zh paramzh)
  {
    AppMethodBeat.i(27442);
    this.uBv = 0;
    this.uBA = null;
    this.uBB = null;
    this.uFe = null;
    this.mLl = null;
    this.niM = "";
    this.uFf = false;
    this.jBI = new b(this);
    this.mYl = new a(this);
    this.uFg = 0;
    this.uFh = true;
    this.isLoading = false;
    this.uFi = false;
    this.tipDialog = null;
    this.mLl = new WeakReference(this);
    this.uFc = paramContactInfoUI;
    this.uAe = paramString;
    this.uBr = paramzh;
    paramString = paramContactInfoUI.getListView();
    dda();
    paramString.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(191231);
        if (ContactWidgetNewBizInfo.c(ContactWidgetNewBizInfo.this) != null)
        {
          paramAnonymousAbsListView = (NewBizInfoHeaderPreference)ContactWidgetNewBizInfo.c(ContactWidgetNewBizInfo.this).aKk("contact_info_header_newbizinfo");
          if (paramAnonymousAbsListView != null)
          {
            int[] arrayOfInt = new int[2];
            if (paramAnonymousAbsListView.uFB == null) {}
            for (paramAnonymousInt1 = 0; paramAnonymousInt1 < 0; paramAnonymousInt1 = arrayOfInt[1])
            {
              paramAnonymousInt2 = paramAnonymousAbsListView.uFD.getMeasuredHeight();
              float f = (paramAnonymousInt1 + paramAnonymousInt2 - this.uFn) / paramAnonymousInt2;
              paramContactInfoUI.setMMTitleColor(ao.aD(paramContactInfoUI, 2130968584));
              paramContactInfoUI.setTitleAlpha(1.0F - f);
              AppMethodBeat.o(191231);
              return;
              paramAnonymousAbsListView.uFB.getLocationInWindow(arrayOfInt);
            }
            if (paramAnonymousInt1 == 0)
            {
              if (paramAnonymousAbsListView.uFB == null) {}
              for (boolean bool = false; !bool; bool = paramAnonymousAbsListView.uFB.isAttachedToWindow())
              {
                paramContactInfoUI.setMMTitleColor(ao.aD(paramContactInfoUI, 2130968584));
                AppMethodBeat.o(191231);
                return;
              }
            }
            paramContactInfoUI.setMMTitleColor(0);
          }
        }
        AppMethodBeat.o(191231);
      }
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(191230);
        ArrayList localArrayList;
        if ((paramAnonymousInt == 0) && (ContactWidgetNewBizInfo.a(ContactWidgetNewBizInfo.this) != null))
        {
          paramAnonymousAbsListView = ContactWidgetNewBizInfo.a(ContactWidgetNewBizInfo.this);
          paramAnonymousInt = paramString.getFirstVisiblePosition();
          int i = paramString.getLastVisiblePosition();
          if (paramAnonymousAbsListView.ddm().xA(16))
          {
            int j = paramAnonymousAbsListView.ddl();
            int k = paramAnonymousAbsListView.uGB;
            localArrayList = new ArrayList();
            if (paramAnonymousInt <= i) {
              for (;;)
              {
                if (paramAnonymousAbsListView.JC(paramAnonymousInt))
                {
                  int n = paramAnonymousInt + (j - k);
                  if (paramAnonymousAbsListView.uGz.Jy(n) == a.b.uGp)
                  {
                    Object localObject1 = paramAnonymousAbsListView.uGz.getItem(n);
                    if (localObject1 == null)
                    {
                      paramAnonymousAbsListView = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizMessage");
                      AppMethodBeat.o(191230);
                      throw paramAnonymousAbsListView;
                    }
                    localObject1 = (mv)localObject1;
                    Object localObject2 = paramAnonymousAbsListView.uGG.contact;
                    k.g(localObject2, "widget.contact");
                    localObject2 = ((au)localObject2).field_username;
                    long l = paramAnonymousAbsListView.uGG.enterTime;
                    int m = paramAnonymousAbsListView.uGG.ima;
                    n /= 2;
                    if (((mv)localObject1).CKn.saz == 49)
                    {
                      localObject3 = ((mv)localObject1).CKs.CIj;
                      k.g(localObject3, "bizMessage.AppMsg.DetailInfo");
                      Object localObject4 = (Iterable)localObject3;
                      localObject3 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject4, 10));
                      localObject4 = ((Iterable)localObject4).iterator();
                      Object localObject5;
                      while (((Iterator)localObject4).hasNext())
                      {
                        localObject5 = (lr)((Iterator)localObject4).next();
                        ((Collection)localObject3).add(d.a.j.listOf(new String[] { ((lr)localObject5).CHL, String.valueOf(((lr)localObject5).gKq) }));
                      }
                      localArrayList.addAll((Collection)localObject3);
                      localObject3 = ((mv)localObject1).CKs.CIj;
                      k.g(localObject3, "bizMessage.AppMsg.DetailInfo");
                      localObject3 = ((Iterable)localObject3).iterator();
                      while (((Iterator)localObject3).hasNext())
                      {
                        localObject4 = (lr)((Iterator)localObject3).next();
                        localObject5 = com.tencent.mm.plugin.profile.ui.newbizinfo.c.d.uHY;
                        k.g(localObject2, "userName");
                        com.tencent.mm.plugin.profile.ui.newbizinfo.c.d.a((String)localObject2, l, ((mv)localObject1).CKs.CIi.CHH, ((lr)localObject4).CHK, ((lr)localObject4).gKq, n, ((mv)localObject1).CKs.CIi.CreateTime, m);
                      }
                    }
                    Object localObject3 = com.tencent.mm.plugin.profile.ui.newbizinfo.c.d.uHY;
                    k.g(localObject2, "userName");
                    com.tencent.mm.plugin.profile.ui.newbizinfo.c.d.a((String)localObject2, l, ((mv)localObject1).CKn.uKX, 0, -1, n, ((mv)localObject1).CKn.CZk, m);
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
            paramAnonymousAbsListView.ddm().i((List)localArrayList, 126);
          }
          AppMethodBeat.o(191230);
          return;
        }
      }
    });
    AppMethodBeat.o(27442);
  }
  
  /* Error */
  private void T(com.tencent.mm.storage.af paramaf)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 190
    //   4: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: ifnull +9 -> 17
    //   11: getstatic 104	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo:uFl	Z
    //   14: ifeq +11 -> 25
    //   17: ldc 190
    //   19: invokestatic 187	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: iconst_1
    //   26: putstatic 104	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo:uFl	Z
    //   29: ldc 192
    //   31: invokestatic 198	com/tencent/mm/sdk/platformtools/ax:aFD	(Ljava/lang/String;)Lcom/tencent/mm/sdk/platformtools/ax;
    //   34: astore_2
    //   35: aload_2
    //   36: getstatic 102	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo:uFk	Ljava/lang/String;
    //   39: iconst_0
    //   40: invokevirtual 202	com/tencent/mm/sdk/platformtools/ax:decodeBool	(Ljava/lang/String;Z)Z
    //   43: ifeq +29 -> 72
    //   46: ldc 204
    //   48: ldc 206
    //   50: invokestatic 211	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   53: getstatic 217	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
    //   56: ldc2_w 218
    //   59: lconst_0
    //   60: lconst_1
    //   61: iconst_0
    //   62: invokevirtual 223	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   65: aload_1
    //   66: getfield 228	com/tencent/mm/g/c/au:field_username	Ljava/lang/String;
    //   69: invokestatic 234	com/tencent/mm/plugin/profile/ui/newbizinfo/a:clear	(Ljava/lang/String;)V
    //   72: aload_2
    //   73: getstatic 102	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo:uFk	Ljava/lang/String;
    //   76: iconst_1
    //   77: invokevirtual 237	com/tencent/mm/sdk/platformtools/ax:encode	(Ljava/lang/String;Z)Z
    //   80: pop
    //   81: ldc 204
    //   83: ldc 239
    //   85: invokestatic 211	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: getstatic 244	com/tencent/mm/sdk/platformtools/h:DEBUG	Z
    //   91: ifne +15 -> 106
    //   94: getstatic 247	com/tencent/mm/sdk/platformtools/h:IS_FLAVOR_RED	Z
    //   97: ifne +9 -> 106
    //   100: invokestatic 253	com/tencent/mm/sdk/platformtools/bu:eGT	()Z
    //   103: ifeq +21 -> 124
    //   106: aload_2
    //   107: ldc 255
    //   109: iconst_0
    //   110: invokevirtual 259	com/tencent/mm/sdk/platformtools/ax:decodeInt	(Ljava/lang/String;I)I
    //   113: iconst_1
    //   114: if_icmpne +10 -> 124
    //   117: ldc_w 261
    //   120: iconst_0
    //   121: invokestatic 267	junit/framework/Assert:assertTrue	(Ljava/lang/String;Z)V
    //   124: getstatic 273	com/tencent/e/h:Iye	Lcom/tencent/e/i;
    //   127: new 16	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo$2
    //   130: dup
    //   131: aload_0
    //   132: aload_2
    //   133: invokespecial 276	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo$2:<init>	(Lcom/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo;Lcom/tencent/mm/sdk/platformtools/ax;)V
    //   136: ldc2_w 277
    //   139: invokeinterface 284 4 0
    //   144: pop
    //   145: ldc 190
    //   147: invokestatic 187	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: goto -128 -> 22
    //   153: astore_1
    //   154: aload_0
    //   155: monitorexit
    //   156: aload_1
    //   157: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	this	ContactWidgetNewBizInfo
    //   0	158	1	paramaf	com.tencent.mm.storage.af
    //   34	99	2	localax	ax
    // Exception table:
    //   from	to	target	type
    //   2	7	153	finally
    //   11	17	153	finally
    //   17	22	153	finally
    //   25	72	153	finally
    //   72	106	153	finally
    //   106	124	153	finally
    //   124	150	153	finally
  }
  
  private void a(ne paramne)
  {
    AppMethodBeat.i(169758);
    if (paramne == null)
    {
      AppMethodBeat.o(169758);
      return;
    }
    if (paramne.CKZ != null)
    {
      com.tencent.mm.plugin.brandservice.b.d.D(paramne.CKZ.DvV, true);
      boolean bool = paramne.CKZ.DvV;
      if (paramne.CKZ.DYN != null)
      {
        i = paramne.CKZ.DYN.size();
        ad.i("MicroMsg.ContactWidgetNewBizInfo", "alvinluo updateProfileInfo %b, size: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
      }
    }
    label90:
    com.tencent.mm.plugin.profile.ui.newbizinfo.b.c localc;
    ccj localccj;
    com.tencent.mm.plugin.profile.ui.newbizinfo.b.a locala;
    for (;;)
    {
      if (paramne.CKT != null)
      {
        dda();
        if (this.uFe != null)
        {
          localc = this.uFe;
          Object localObject1 = paramne.CKT;
          localccj = paramne.CKZ;
          k.h(localObject1, "msgList");
          locala = localc.uGz;
          k.h(localObject1, "msgList");
          locala.fyl.clear();
          k.g(Calendar.getInstance(), "Calendar.getInstance()");
          new Date();
          Object localObject2 = ((mw)localObject1).CKt;
          k.g(localObject2, "msgList.Msg");
          localObject2 = ((Iterable)localObject2).iterator();
          for (;;)
          {
            if (((Iterator)localObject2).hasNext())
            {
              mv localmv = (mv)((Iterator)localObject2).next();
              locala.fyl.add(new o(a.b.uGo, localmv));
              locala.fyl.add(new o(a.b.uGp, localmv));
              continue;
              i = -1;
              break;
              ad.e("MicroMsg.ContactWidgetNewBizInfo", "alvinluo updateProfileInfo videochannel_notify_info is null");
              break label90;
            }
          }
          localObject1 = ((mw)localObject1).CKu;
          if ((localObject1 != null) && (((nc)localObject1).CKN == 0)) {
            locala.fyl.add(new o(a.b.uGq, new mv()));
          }
          locala = localc.uGz;
          if ((localccj != null) && (com.tencent.mm.plugin.brandservice.b.d.bCg()))
          {
            localObject1 = localccj.DYN;
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
        ad.i("MicroMsg.BizMessageAdapter", "alvinluo updateHeader add video channel");
        locala.uGf.clear();
        locala.uGf.add(new o(a.b.uGr, localccj));
      }
      localc.uGH.notifyDataSetChanged();
      if ((!this.uFf) && (paramne.CKZ != null) && (paramne.CKZ.DYN != null) && (paramne.CKZ.DYN.size() > 0) && (com.tencent.mm.plugin.brandservice.b.d.bCg()))
      {
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.L(this.contact.field_username, 1401, this.ima);
        this.uFf = true;
      }
      AppMethodBeat.o(169758);
      return;
    }
  }
  
  private void a(String paramString, final com.tencent.mm.bx.b paramb)
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
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    nd localnd = new nd();
    localnd.CIt = paramString;
    if (paramb != null)
    {
      localnd.CKO = 1;
      localnd.CKM = paramb;
      localnd.CKP = 20;
      localnd.Scene = this.ima;
      localnd.CKQ = u.getSessionId();
      ((b.a)localObject).gUU = localnd;
      ((b.a)localObject).gUV = new ne();
      localObject = ((b.a)localObject).atI();
      paramb = new x.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb, n paramAnonymousn)
        {
          AppMethodBeat.i(191238);
          ad.i("MicroMsg.ContactWidgetNewBizInfo", "callback, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          paramAnonymousString = (ne)paramAnonymousb.gUT.gUX;
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousString != null))
          {
            paramAnonymousb = a.uGe;
            a.a(paramAnonymousString.CKT);
            if (paramb == null) {
              break label379;
            }
            if ((!paramb.equals(ContactWidgetNewBizInfo.k(ContactWidgetNewBizInfo.this).CKT.CKu.CKM)) || (paramAnonymousString.CKT == null)) {
              break label369;
            }
            ContactWidgetNewBizInfo.k(ContactWidgetNewBizInfo.this).CKT.CKt.addAll(paramAnonymousString.CKT.CKt);
            ContactWidgetNewBizInfo.k(ContactWidgetNewBizInfo.this).CKT.CKu = paramAnonymousString.CKT.CKu;
            if (paramb == null) {
              break label415;
            }
            if ((ContactWidgetNewBizInfo.k(ContactWidgetNewBizInfo.this) != null) && (ContactWidgetNewBizInfo.k(ContactWidgetNewBizInfo.this).CKT != null))
            {
              ContactWidgetNewBizInfo.a(ContactWidgetNewBizInfo.this, ContactWidgetNewBizInfo.k(ContactWidgetNewBizInfo.this));
              com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.L(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username, 106, ContactWidgetNewBizInfo.h(ContactWidgetNewBizInfo.this));
            }
            label220:
            if ((paramAnonymousString.CID & 0x4) == 0) {
              break label442;
            }
            paramAnonymousb = ContactWidgetNewBizInfo.c(4, paramAnonymousString.CKX);
            if (paramAnonymousb == null) {
              break label442;
            }
            paramAnonymousn = (NewBizInfoErrMsgPreference)ContactWidgetNewBizInfo.c(ContactWidgetNewBizInfo.this).aKk("contact_info_biz_err_msg");
            ContactWidgetNewBizInfo.c(ContactWidgetNewBizInfo.this).cE("contact_info_biz_err_msg", false);
            paramAnonymousn.setErrMsg(paramAnonymousb);
          }
          for (;;)
          {
            for (;;)
            {
              if ((paramAnonymousString.CID & 0x2) != 0)
              {
                paramAnonymousString = (NewBizInfoHeaderPreference)ContactWidgetNewBizInfo.c(ContactWidgetNewBizInfo.this).aKk("contact_info_header_newbizinfo");
                paramAnonymousString.uFG = true;
                if (paramAnonymousString.fuj != null)
                {
                  com.tencent.mm.plugin.brandservice.b.e.a(paramAnonymousString.fuj, paramAnonymousString.contact, "", true);
                  paramAnonymousString.fuj.setClickable(false);
                }
              }
              ContactWidgetNewBizInfo.n(ContactWidgetNewBizInfo.this);
              ContactWidgetNewBizInfo.o(ContactWidgetNewBizInfo.this);
              AppMethodBeat.o(191238);
              return 0;
              label369:
              ad.e("MicroMsg.ContactWidgetNewBizInfo", "drop err resp");
              break;
              try
              {
                label379:
                ContactWidgetNewBizInfo.k(ContactWidgetNewBizInfo.this).parseFrom(paramAnonymousString.toByteArray());
              }
              catch (IOException paramAnonymousb)
              {
                ad.printErrStackTrace("MicroMsg.ContactWidgetNewBizInfo", paramAnonymousb, "profileInfo.parseFrom", new Object[0]);
              }
            }
            break;
            label415:
            a.b(ContactWidgetNewBizInfo.k(ContactWidgetNewBizInfo.this));
            ContactWidgetNewBizInfo.l(ContactWidgetNewBizInfo.this);
            ContactWidgetNewBizInfo.m(ContactWidgetNewBizInfo.this);
            break label220;
            label442:
            if ((paramAnonymousString.CID & 0x8) != 0)
            {
              paramAnonymousb = ContactWidgetNewBizInfo.c(8, paramAnonymousString.CKX);
              if (paramAnonymousb != null)
              {
                paramAnonymousn = (NewBizInfoErrMsgPreference)ContactWidgetNewBizInfo.c(ContactWidgetNewBizInfo.this).aKk("contact_info_biz_err_msg");
                ContactWidgetNewBizInfo.c(ContactWidgetNewBizInfo.this).cE("contact_info_biz_err_msg", false);
                paramAnonymousn.setErrMsg(paramAnonymousb);
                continue;
              }
            }
            ContactWidgetNewBizInfo.c(ContactWidgetNewBizInfo.this).cE("contact_info_biz_err_msg", true);
          }
        }
      };
      if (!(this.uFc instanceof com.tencent.mm.vending.e.b)) {
        break label197;
      }
    }
    label197:
    for (paramString = this.uFc;; paramString = null)
    {
      x.a((com.tencent.mm.al.b)localObject, paramb, false, paramString);
      AppMethodBeat.o(27450);
      return;
      localnd.CKO = 0;
      localnd.CKP = 5;
      break;
    }
  }
  
  private static int akK(String paramString)
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
  
  private boolean bHR()
  {
    AppMethodBeat.i(27452);
    if ((this.uFd != null) && (this.uFd.CKR != null) && (this.uFd.CKR.CGR == 0) && (!ddd()))
    {
      AppMethodBeat.o(27452);
      return true;
    }
    AppMethodBeat.o(27452);
    return false;
  }
  
  private void dcu()
  {
    AppMethodBeat.i(27451);
    bRu();
    ddb();
    this.screen.removeAll();
    this.screen.addPreferencesFromResource(2131951647);
    Object localObject = (NewBizInfoHeaderPreference)this.screen.aKk("contact_info_header_newbizinfo");
    if ((localObject != null) && (!bt.isNullOrNil(this.contact.field_username)))
    {
      ((NewBizInfoHeaderPreference)localObject).a(this.contact, this.uAe, this.uzN, this.uFd);
      this.uFi = true;
      if (this.uFd == null) {
        break label594;
      }
      if (!com.tencent.mm.n.b.ls(this.contact.field_type)) {
        break label563;
      }
      this.screen.cE("contact_info_biz_add", true);
      this.screen.cE("contact_info_biz_go_chatting", false);
      ((NewBizInfoFollowPreference)this.screen.aKk("contact_info_biz_go_chatting")).uzY = this;
      label161:
      if ((this.uFd != null) && (this.uFd.CKR != null) && (this.uFd.CKT != null) && (this.uFd.CKT.CKu != null)) {
        a(this.uFd);
      }
      if ((this.uFd != null) && (!bHR()) && (!com.tencent.mm.n.b.ls(this.contact.field_type))) {
        this.uFc.showOptionMenu(false);
      }
      if ((this.uFd == null) || (this.uFd.CKW == null)) {
        break label639;
      }
      this.screen.cE("contact_info_biz_menu_newbizinfo", false);
      if (this.uFd != null) {
        ((NewBizInfoMenuPreference)this.screen.aKk("contact_info_biz_menu_newbizinfo")).a(this.uFd.CKW, this.contact, this.ima);
      }
    }
    for (;;)
    {
      this.screen.cE("contact_info_biz_err_msg", true);
      ad.d("MicroMsg.ContactWidgetNewBizInfo", "KIsardDevice(%b)", new Object[] { Boolean.valueOf(this.uFc.getIntent().getBooleanExtra("KIsHardDevice", false)) });
      if ((this.uFc.getIntent() == null) || (!this.uFc.getIntent().getBooleanExtra("KIsHardDevice", false))) {
        break label677;
      }
      ad.d("MicroMsg.ContactWidgetNewBizInfo", "Hard device biz...");
      boolean bool = dcx();
      ad.d("MicroMsg.ContactWidgetNewBizInfo", "contact.isContact()(%b), isHarDeviceBound(%b)", new Object[] { Boolean.valueOf(com.tencent.mm.n.b.ls(this.contact.field_type)), Boolean.valueOf(bool) });
      if ((com.tencent.mm.n.b.ls(this.contact.field_type)) && (bool)) {
        break label670;
      }
      ad.w("MicroMsg.ContactWidgetNewBizInfo", "%s is not my hard biz contact", new Object[] { this.contact.field_username });
      dcv();
      localObject = (NewBizInfoNotFollowPreference)this.screen.aKk("contact_info_biz_add");
      this.screen.cE("contact_info_biz_add", false);
      if (localObject == null) {
        break label670;
      }
      if (!bool) {
        break label656;
      }
      ((NewBizInfoNotFollowPreference)localObject).setTitle(this.uFc.getString(2131757610));
      AppMethodBeat.o(27451);
      return;
      ad.w("MicroMsg.ContactWidgetNewBizInfo", "head pref is null");
      this.screen.cE("contact_info_header_bizinfo", true);
      break;
      label563:
      this.screen.cE("contact_info_biz_add", false);
      this.screen.cE("contact_info_biz_go_chatting", true);
      break label161;
      label594:
      this.screen.cE("contact_info_biz_add", true);
      this.screen.cE("contact_info_biz_go_chatting", true);
      this.screen.cE("contact_info_biz_space", false);
      break label161;
      label639:
      this.screen.cE("contact_info_biz_menu_newbizinfo", true);
    }
    label656:
    ((NewBizInfoNotFollowPreference)localObject).setTitle(this.uFc.getString(2131757596));
    label670:
    AppMethodBeat.o(27451);
    return;
    label677:
    if (ddd())
    {
      this.screen.cE("contact_info_biz_loading", false);
      this.screen.cE("contact_info_biz_add", true);
      this.screen.cE("contact_info_biz_go_chatting", true);
      this.screen.cE("contact_info_message_newbizinfo", true);
    }
    AppMethodBeat.o(27451);
  }
  
  private void dcv()
  {
    AppMethodBeat.i(27454);
    if ((this.contact != null) && ((w.tl(this.contact.field_username)) || (w.tw(this.contact.field_username))) && (com.tencent.mm.n.b.ls(this.contact.field_type)))
    {
      this.screen.cE("contact_info_biz_go_chatting", false);
      AppMethodBeat.o(27454);
      return;
    }
    this.screen.cE("contact_info_biz_go_chatting", true);
    AppMethodBeat.o(27454);
  }
  
  private void dcw()
  {
    AppMethodBeat.i(27458);
    if ((NewBizInfoHeaderPreference)this.screen.aKk("contact_info_header_newbizinfo") != null) {
      NewBizInfoHeaderPreference.rK(System.currentTimeMillis());
    }
    if ((this.uFc.getIntent() != null) && (this.uFc.getIntent().getBooleanExtra("KIsHardDevice", false)))
    {
      localObject1 = this.uFc.getIntent().getStringExtra("KHardDeviceBindTicket");
      if (!bt.isNullOrNil((String)localObject1)) {
        break label334;
      }
      ad.i("MicroMsg.ContactWidgetNewBizInfo", "bindTicket is null, means it is not switch from QRcode scan, just add contact");
    }
    label334:
    while (dcx())
    {
      localObject1 = new com.tencent.mm.pluginsdk.ui.applet.a(this.uFc, new a.a()
      {
        public final void a(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(191241);
          com.tencent.mm.storage.af localaf;
          if (paramAnonymousBoolean1)
          {
            com.tencent.mm.ui.base.h.cf(ContactWidgetNewBizInfo.b(ContactWidgetNewBizInfo.this), ContactWidgetNewBizInfo.b(ContactWidgetNewBizInfo.this).getString(2131757607));
            ContactWidgetNewBizInfo.c(ContactWidgetNewBizInfo.this).cE("contact_info_time_expired", true);
            localaf = ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this);
            if ((localaf != null) && (!bt.isNullOrNil(paramAnonymousString1))) {
              break label379;
            }
            ad.e("MicroMsg.ContactWidgetNewBizInfo", "respUsername == " + paramAnonymousString1 + ", contact = " + localaf);
            if (ContactWidgetNewBizInfo.q(ContactWidgetNewBizInfo.this) != null)
            {
              paramAnonymousString1 = new qc();
              ContactWidgetNewBizInfo.q(ContactWidgetNewBizInfo.this).hsX = 4;
              paramAnonymousString1.dvG.dvH = ContactWidgetNewBizInfo.q(ContactWidgetNewBizInfo.this);
              com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousString1);
            }
            paramAnonymousString1 = com.tencent.mm.am.af.awe().wy(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username);
            paramAnonymousString1.field_status = 1;
            if ((!bt.isNullOrNil(paramAnonymousString1.field_extInfo)) || (bt.isNullOrNil(paramAnonymousString1.field_username)) || (ContactWidgetNewBizInfo.r(ContactWidgetNewBizInfo.this) == null) || (!paramAnonymousString1.field_username.equals(bt.nullAsNil(ContactWidgetNewBizInfo.r(ContactWidgetNewBizInfo.this).field_username)))) {
              break label667;
            }
            com.tencent.mm.am.af.awe().g(ContactWidgetNewBizInfo.r(ContactWidgetNewBizInfo.this));
            label240:
            paramAnonymousBoolean1 = ContactWidgetNewBizInfo.b(ContactWidgetNewBizInfo.this).getIntent().getBooleanExtra("key_biz_profile_stay_after_follow_op", false);
            paramAnonymousBoolean2 = ContactWidgetNewBizInfo.b(ContactWidgetNewBizInfo.this).getIntent().getBooleanExtra("key_start_biz_profile_from_app_brand_profile", false);
            if (!paramAnonymousString1.Je()) {
              break label678;
            }
            paramAnonymousString1 = new Intent();
            paramAnonymousString1.putExtra("enterprise_biz_name", ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username);
            paramAnonymousString1.putExtra("enterprise_biz_display_name", com.tencent.mm.model.v.sh(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username));
            paramAnonymousString1.putExtra("enterprise_from_scene", 7);
            paramAnonymousString1.addFlags(67108864);
            com.tencent.mm.bs.d.e(ContactWidgetNewBizInfo.b(ContactWidgetNewBizInfo.this), ".ui.conversation.EnterpriseConversationUI", paramAnonymousString1);
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
              AppMethodBeat.o(191241);
              return;
              paramAnonymousString2 = null;
              if (w.sC(localaf.field_username))
              {
                String str = bt.nullAsNil(localaf.field_username);
                paramAnonymousString2 = com.tencent.mm.am.f.ei(str);
                if (paramAnonymousString2 != null) {
                  paramAnonymousString2.field_username = paramAnonymousString1;
                }
                com.tencent.mm.am.af.awe().delete(str);
                localaf.nj(str);
              }
              localaf.setUsername(paramAnonymousString1);
              if ((int)localaf.fId == 0)
              {
                az.arV();
                com.tencent.mm.model.c.apM().ag(localaf);
              }
              if ((int)localaf.fId <= 0)
              {
                ad.e("MicroMsg.ContactWidgetNewBizInfo", "addContact : insert contact failed");
                break;
              }
              w.u(localaf);
              az.arV();
              paramAnonymousString1 = com.tencent.mm.model.c.apM().aHY(localaf.field_username);
              if (paramAnonymousString2 != null)
              {
                com.tencent.mm.am.af.awe().f(paramAnonymousString2);
                break;
              }
              paramAnonymousString2 = com.tencent.mm.am.f.ei(paramAnonymousString1.field_username);
              if ((paramAnonymousString1.eKB()) && (com.tencent.mm.am.a.avv())) {}
              for (int i = 1;; i = 0)
              {
                if ((paramAnonymousString2 != null) && ((!paramAnonymousString2.IY()) || (i != 0))) {
                  break label608;
                }
                ad.d("MicroMsg.ContactWidgetNewBizInfo", "shouldUpdate");
                ar.a.gMW.aB(paramAnonymousString1.field_username, "");
                com.tencent.mm.ak.c.vO(paramAnonymousString1.field_username);
                break;
              }
              if ((!paramAnonymousString1.eKF()) || (i != 0)) {
                break;
              }
              ad.d("MicroMsg.ContactWidgetNewBizInfo", "update contact, last check time=%d", new Object[] { Integer.valueOf(paramAnonymousString1.evG) });
              ar.a.gMW.aB(paramAnonymousString1.field_username, "");
              com.tencent.mm.ak.c.vO(paramAnonymousString1.field_username);
              break;
              com.tencent.mm.am.af.awe().g(paramAnonymousString1);
              break label240;
              paramAnonymousString1 = new Intent();
              paramAnonymousString1.putExtra("Chat_User", ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username);
              paramAnonymousString1.putExtra("key_has_add_contact", true);
              paramAnonymousString1.putExtra("finish_direct", true);
              if (paramAnonymousBoolean2) {
                paramAnonymousString1.addFlags(268435456);
              }
              u.aHx(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username);
              com.tencent.mm.plugin.profile.b.hYt.d(paramAnonymousString1, ContactWidgetNewBizInfo.b(ContactWidgetNewBizInfo.this));
              if (paramAnonymousBoolean1) {
                break label355;
              }
            } while (!paramAnonymousBoolean2);
          }
        }
      });
      localObject2 = new LinkedList();
      ((LinkedList)localObject2).add(Integer.valueOf(this.ima));
      if (this.cIo != null) {
        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).BXu = this.cIo;
      }
      if (!bt.isNullOrNil(this.rso)) {
        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).rso = this.rso;
      }
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).BXA = true;
      String str = this.uFc.getIntent().getStringExtra("url");
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).BXB = str;
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).niJ = e.a.Xd(this.uFc.getIntent().getIntExtra("qbarScene", -1));
      dju localdju = new dju();
      localdju.CzZ = this.uFc.getIntent().getIntExtra("Contact_Sub_Scene", 0);
      localdju.DcD = this.uFc.getIntent().getStringExtra("Contact_Scene_Note");
      if (!bt.isNullOrNil(str))
      {
        if (bt.isNullOrNil(localdju.DcD)) {
          localdju.DcD = str;
        }
        if (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).isMpUrl(str)) {
          localdju.EzH = akK(str);
        }
      }
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).BXC = localdju;
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).a(this.contact.field_username, (LinkedList)localObject2, this.uBB);
      dde();
      AppMethodBeat.o(27458);
      return;
    }
    ad.d("MicroMsg.ContactWidgetNewBizInfo", "IsHardDevice, bindTicket = %s", new Object[] { localObject1 });
    az.aeS().a(536, this);
    Object localObject2 = new dj();
    ((dj)localObject2).dfw.dfy = ((String)localObject1);
    ((dj)localObject2).dfw.opType = 1;
    com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject2);
    Object localObject1 = ((dj)localObject2).dfx.dfA;
    localObject2 = this.uFc;
    this.uFc.getString(2131755906);
    this.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject2, this.uFc.getString(2131755936), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(191240);
        az.aeS().b(536, ContactWidgetNewBizInfo.this);
        paramAnonymousDialogInterface = new dj();
        paramAnonymousDialogInterface.dfw.opType = 2;
        paramAnonymousDialogInterface.dfw.dfA = this.cZL;
        com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousDialogInterface);
        AppMethodBeat.o(191240);
      }
    });
    AppMethodBeat.o(27458);
  }
  
  private boolean dcx()
  {
    AppMethodBeat.i(27462);
    if (this.uFc.getIntent() == null)
    {
      AppMethodBeat.o(27462);
      return false;
    }
    String str1 = this.uFc.getIntent().getStringExtra("device_id");
    String str2 = this.uFc.getIntent().getStringExtra("device_type");
    dn localdn = new dn();
    localdn.dfH.cLR = str1;
    localdn.dfH.dfF = str2;
    com.tencent.mm.sdk.b.a.ESL.l(localdn);
    boolean bool = localdn.dfI.dfJ;
    AppMethodBeat.o(27462);
    return bool;
  }
  
  private void dda()
  {
    AppMethodBeat.i(27446);
    if (this.uFe != null)
    {
      AppMethodBeat.o(27446);
      return;
    }
    com.tencent.mm.ui.base.preference.h localh = (com.tencent.mm.ui.base.preference.h)this.uFc.getListView().getAdapter();
    if (localh == null)
    {
      ad.e("MicroMsg.ContactWidgetNewBizInfo", "empty adapter");
      AppMethodBeat.o(27446);
      return;
    }
    this.uFe = new com.tencent.mm.plugin.profile.ui.newbizinfo.b.c(this.uFc, this, localh, new String[] { "contact_info_biz_err_msg", "contact_info_footer_space" });
    localh.GfB = this.uFe;
    AppMethodBeat.o(27446);
  }
  
  private void ddb()
  {
    AppMethodBeat.i(27448);
    com.tencent.mm.api.c localc2 = com.tencent.mm.am.f.ei(this.contact.field_username);
    this.cIe = null;
    this.cIf = null;
    this.uBq = null;
    com.tencent.mm.api.c localc1;
    if (localc2 != null)
    {
      localc1 = localc2;
      if (localc2.bU(false) != null) {}
    }
    else
    {
      localc1 = localc2;
      if (this.uBr != null)
      {
        localc1 = new com.tencent.mm.api.c();
        localc1.field_username = this.contact.field_username;
        localc1.field_brandFlag = this.uBr.ika;
        localc1.field_brandIconURL = this.uBr.ikd;
        localc1.field_brandInfo = this.uBr.ikc;
        localc1.field_extInfo = this.uBr.ikb;
        localc1.field_type = localc1.bU(false).getServiceType();
      }
    }
    if ((localc1 != null) && (localc1.field_brandInfo == null) && (localc1.field_extInfo == null) && (this.uBr != null))
    {
      localc1.field_username = this.contact.field_username;
      localc1.field_brandFlag = this.uBr.ika;
      localc1.field_brandIconURL = this.uBr.ikd;
      localc1.field_brandInfo = this.uBr.ikc;
      localc1.field_extInfo = this.uBr.ikb;
      localc1.field_type = localc1.bU(false).getServiceType();
    }
    if (localc1 != null)
    {
      this.uzN = localc1;
      this.cIe = localc1.Jn();
      this.cIf = localc1.bU(false);
      this.uBq = this.cIf.getWxaEntryInfoList();
      if ((this.cIf.Jr() != null) && (this.cIf.Jr().length() > 0)) {
        this.cIo = this.cIf.Jr();
      }
    }
    AppMethodBeat.o(27448);
  }
  
  private boolean ddd()
  {
    boolean bool1 = true;
    AppMethodBeat.i(27453);
    try
    {
      String str = this.cIf.Ju();
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
  private void dde()
  {
    // Byte code:
    //   0: sipush 27459
    //   3: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 156	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo:uFc	Lcom/tencent/mm/plugin/profile/ui/ContactInfoUI;
    //   10: invokevirtual 786	com/tencent/mm/plugin/profile/ui/ContactInfoUI:getIntent	()Landroid/content/Intent;
    //   13: astore 13
    //   15: aload 13
    //   17: ldc_w 1112
    //   20: iconst_0
    //   21: invokevirtual 884	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   24: invokestatic 1117	com/tencent/mm/plugin/profile/ui/newbizinfo/b/g:JF	(I)I
    //   27: istore_1
    //   28: aload 13
    //   30: ldc_w 1119
    //   33: invokevirtual 854	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   36: astore 14
    //   38: aload 13
    //   40: ldc_w 1121
    //   43: invokevirtual 854	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   46: astore 15
    //   48: aload 13
    //   50: ldc_w 1123
    //   53: iconst_0
    //   54: invokevirtual 884	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   57: aload 14
    //   59: invokestatic 1127	com/tencent/mm/plugin/profile/ui/newbizinfo/b/g:bs	(ILjava/lang/String;)I
    //   62: istore_2
    //   63: aload 13
    //   65: ldc_w 636
    //   68: invokevirtual 854	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   71: astore 8
    //   73: aload 13
    //   75: ldc_w 876
    //   78: invokevirtual 854	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   81: astore 12
    //   83: aload 13
    //   85: ldc_w 1129
    //   88: invokevirtual 1133	android/content/Intent:getBundleExtra	(Ljava/lang/String;)Landroid/os/Bundle;
    //   91: astore 10
    //   93: ldc 127
    //   95: astore 9
    //   97: aload 10
    //   99: ifnull +15 -> 114
    //   102: aload 10
    //   104: ldc_w 1135
    //   107: ldc 127
    //   109: invokevirtual 1140	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   112: astore 9
    //   114: aload 13
    //   116: ldc_w 881
    //   119: iconst_m1
    //   120: invokevirtual 884	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   123: invokestatic 890	com/tencent/mm/ui/e$a:Xd	(I)I
    //   126: istore_3
    //   127: aload_0
    //   128: getfield 468	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo:contact	Lcom/tencent/mm/storage/af;
    //   131: getfield 228	com/tencent/mm/g/c/au:field_username	Ljava/lang/String;
    //   134: astore 16
    //   136: aload 9
    //   138: invokestatic 555	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   141: ifne +429 -> 570
    //   144: aload 9
    //   146: invokestatic 1143	com/tencent/mm/sdk/platformtools/bt:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   149: ldc_w 1145
    //   152: invokestatic 1149	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   155: astore 9
    //   157: aload 8
    //   159: astore 10
    //   161: aload 8
    //   163: invokestatic 1143	com/tencent/mm/sdk/platformtools/bt:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   166: ldc_w 1145
    //   169: invokestatic 1149	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   172: astore 8
    //   174: aload 8
    //   176: astore 10
    //   178: aload 12
    //   180: invokestatic 1143	com/tencent/mm/sdk/platformtools/bt:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   183: ldc_w 1145
    //   186: invokestatic 1149	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   189: astore 11
    //   191: aload 11
    //   193: astore 10
    //   195: getstatic 217	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
    //   198: sipush 16232
    //   201: bipush 9
    //   203: anewarray 4	java/lang/Object
    //   206: dup
    //   207: iconst_0
    //   208: iload_1
    //   209: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   212: aastore
    //   213: dup
    //   214: iconst_1
    //   215: iload_2
    //   216: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
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
    //   250: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   253: aastore
    //   254: dup
    //   255: bipush 8
    //   257: aload 16
    //   259: aastore
    //   260: invokevirtual 1152	com/tencent/mm/plugin/report/service/h:f	(I[Ljava/lang/Object;)V
    //   263: aload_0
    //   264: getfield 121	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo:uBB	Ljava/lang/String;
    //   267: invokestatic 555	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   270: ifne +16 -> 286
    //   273: getstatic 217	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
    //   276: sipush 16697
    //   279: aload_0
    //   280: getfield 121	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo:uBB	Ljava/lang/String;
    //   283: invokevirtual 1156	com/tencent/mm/plugin/report/service/h:kvStat	(ILjava/lang/String;)V
    //   286: aload 13
    //   288: ldc_w 1112
    //   291: iconst_0
    //   292: invokevirtual 884	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   295: istore_1
    //   296: invokestatic 845	java/lang/System:currentTimeMillis	()J
    //   299: ldc2_w 277
    //   302: ldiv
    //   303: l2i
    //   304: i2l
    //   305: lstore 4
    //   307: iload_1
    //   308: sipush 160
    //   311: if_icmpne +147 -> 458
    //   314: aload 13
    //   316: ldc_w 1158
    //   319: lconst_0
    //   320: invokevirtual 1161	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   323: lstore 6
    //   325: getstatic 217	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
    //   328: sipush 15721
    //   331: bipush 9
    //   333: anewarray 4	java/lang/Object
    //   336: dup
    //   337: iconst_0
    //   338: aload_0
    //   339: getfield 468	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo:contact	Lcom/tencent/mm/storage/af;
    //   342: getfield 228	com/tencent/mm/g/c/au:field_username	Ljava/lang/String;
    //   345: aastore
    //   346: dup
    //   347: iconst_1
    //   348: iconst_0
    //   349: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   352: aastore
    //   353: dup
    //   354: iconst_2
    //   355: bipush 14
    //   357: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   360: aastore
    //   361: dup
    //   362: iconst_3
    //   363: lload 4
    //   365: invokestatic 1166	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   368: aastore
    //   369: dup
    //   370: iconst_4
    //   371: invokestatic 520	com/tencent/mm/storage/u:getSessionId	()I
    //   374: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   377: aastore
    //   378: dup
    //   379: iconst_5
    //   380: iconst_0
    //   381: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   384: aastore
    //   385: dup
    //   386: bipush 6
    //   388: lload 6
    //   390: invokestatic 1166	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   393: aastore
    //   394: dup
    //   395: bipush 7
    //   397: ldc 127
    //   399: aastore
    //   400: dup
    //   401: bipush 8
    //   403: iconst_1
    //   404: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   407: aastore
    //   408: invokevirtual 1152	com/tencent/mm/plugin/report/service/h:f	(I[Ljava/lang/Object;)V
    //   411: getstatic 217	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
    //   414: ldc2_w 1167
    //   417: ldc2_w 1169
    //   420: lconst_1
    //   421: iconst_0
    //   422: invokevirtual 223	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   425: sipush 27459
    //   428: invokestatic 187	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   431: return
    //   432: astore 10
    //   434: ldc 127
    //   436: astore 9
    //   438: ldc 204
    //   440: aload 10
    //   442: ldc 127
    //   444: iconst_0
    //   445: anewarray 4	java/lang/Object
    //   448: invokestatic 1174	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   451: aload 12
    //   453: astore 10
    //   455: goto -260 -> 195
    //   458: iload_1
    //   459: sipush 174
    //   462: if_icmpne +88 -> 550
    //   465: getstatic 217	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
    //   468: sipush 15721
    //   471: bipush 9
    //   473: anewarray 4	java/lang/Object
    //   476: dup
    //   477: iconst_0
    //   478: aload_0
    //   479: getfield 468	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo:contact	Lcom/tencent/mm/storage/af;
    //   482: getfield 228	com/tencent/mm/g/c/au:field_username	Ljava/lang/String;
    //   485: aastore
    //   486: dup
    //   487: iconst_1
    //   488: iconst_0
    //   489: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   492: aastore
    //   493: dup
    //   494: iconst_2
    //   495: bipush 21
    //   497: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   500: aastore
    //   501: dup
    //   502: iconst_3
    //   503: lload 4
    //   505: invokestatic 1166	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   508: aastore
    //   509: dup
    //   510: iconst_4
    //   511: invokestatic 520	com/tencent/mm/storage/u:getSessionId	()I
    //   514: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   517: aastore
    //   518: dup
    //   519: iconst_5
    //   520: iconst_0
    //   521: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   524: aastore
    //   525: dup
    //   526: bipush 6
    //   528: iconst_0
    //   529: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   532: aastore
    //   533: dup
    //   534: bipush 7
    //   536: ldc 127
    //   538: aastore
    //   539: dup
    //   540: bipush 8
    //   542: iconst_2
    //   543: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   546: aastore
    //   547: invokevirtual 1152	com/tencent/mm/plugin/report/service/h:f	(I[Ljava/lang/Object;)V
    //   550: sipush 27459
    //   553: invokestatic 187	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   556: return
    //   557: astore 11
    //   559: aload 10
    //   561: astore 8
    //   563: aload 11
    //   565: astore 10
    //   567: goto -129 -> 438
    //   570: ldc 127
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
    this.uFc.setMMTitle(bt.nullAsNil(this.contact.field_nickname));
    this.uFc.setMMTitleColor(0);
    this.uFc.setTitleDividerVis(false);
    this.uFc.setIsDarkActionbarBg(false);
    this.uFc.setActionbarColor(ao.aD(this.uFc, 2130968579));
    this.uFc.hideActionbarLine();
    this.uFc.setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(191233);
        ContactWidgetNewBizInfo.b(ContactWidgetNewBizInfo.this).onBackPressed();
        AppMethodBeat.o(191233);
        return true;
      }
    }, 2131689490);
    this.uFc.removeAllOptionMenu();
    this.uFc.addIconOptionMenu(1, 2131764452, 2131689494, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(191234);
        ContactWidgetNewBizInfo.d(ContactWidgetNewBizInfo.this);
        AppMethodBeat.o(191234);
        return true;
      }
    });
    this.uFc.addIconOptionMenu(0, "", 2131689493, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(27434);
        paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(ContactWidgetNewBizInfo.b(ContactWidgetNewBizInfo.this), 1, false);
        paramAnonymousMenuItem.HrX = new n.c()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
          {
            AppMethodBeat.i(191235);
            if (com.tencent.mm.n.b.ls(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_type))
            {
              if (!ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).ZS()) {
                break label153;
              }
              if ((!u.bBQ()) || (!com.tencent.mm.am.f.wI(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username))) {
                break label142;
              }
              paramAnonymous2l.jj(5, 2131757612);
            }
            for (;;)
            {
              if (com.tencent.mm.n.b.ls(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_type)) {
                paramAnonymous2l.jj(2, 2131757807);
              }
              paramAnonymous2l.jj(6, 2131757156);
              if (com.tencent.mm.n.b.ls(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_type)) {
                paramAnonymous2l.jj(3, 2131757623);
              }
              AppMethodBeat.o(191235);
              return;
              label142:
              paramAnonymous2l.jj(5, 2131761053);
              continue;
              label153:
              if ((u.bBQ()) && (com.tencent.mm.am.f.wI(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username))) {
                paramAnonymous2l.jj(4, 2131757608);
              } else {
                paramAnonymous2l.jj(4, 2131757877);
              }
            }
          }
        };
        paramAnonymousMenuItem.HrY = new n.d()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(191236);
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
                  AppMethodBeat.o(191236);
                  return;
                  ContactWidgetNewBizInfo.f(ContactWidgetNewBizInfo.this);
                  AppMethodBeat.o(191236);
                  return;
                  ContactWidgetNewBizInfo.g(ContactWidgetNewBizInfo.this);
                  AppMethodBeat.o(191236);
                  return;
                  com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.L(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username, 903, ContactWidgetNewBizInfo.h(ContactWidgetNewBizInfo.this));
                  com.tencent.mm.model.j.rI(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username);
                  ContactWidgetNewBizInfo.i(ContactWidgetNewBizInfo.this);
                } while ((u.bBQ()) && (!com.tencent.mm.am.f.wG(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username)));
                com.tencent.mm.ui.base.h.cf(ContactWidgetNewBizInfo.b(ContactWidgetNewBizInfo.this), ContactWidgetNewBizInfo.b(ContactWidgetNewBizInfo.this).getString(2131761054));
                AppMethodBeat.o(191236);
                return;
                w.D(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username, true);
                com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.L(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username, 904, ContactWidgetNewBizInfo.h(ContactWidgetNewBizInfo.this));
                ContactWidgetNewBizInfo.i(ContactWidgetNewBizInfo.this);
              } while ((u.bBQ()) && (!com.tencent.mm.am.f.wG(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username)));
              com.tencent.mm.ui.base.h.cf(ContactWidgetNewBizInfo.b(ContactWidgetNewBizInfo.this), ContactWidgetNewBizInfo.b(ContactWidgetNewBizInfo.this).getString(2131756644));
              AppMethodBeat.o(191236);
              return;
            }
            ContactWidgetNewBizInfo.j(ContactWidgetNewBizInfo.this);
            AppMethodBeat.o(191236);
          }
        };
        paramAnonymousMenuItem.csG();
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.L(ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this).field_username, 600, ContactWidgetNewBizInfo.h(ContactWidgetNewBizInfo.this));
        AppMethodBeat.o(27434);
        return false;
      }
    });
    AppMethodBeat.o(27445);
  }
  
  final void Jx(int paramInt)
  {
    AppMethodBeat.i(27463);
    if ((this.uBz == null) || ((this.ima != 39) && (this.ima != 56) && (this.ima != 35) && (this.ima != 87) && (this.ima != 88) && (this.ima != 89) && (this.ima != 85)))
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
    String str2 = this.uBz.getString("Contact_Ext_Args_Search_Id");
    String str3 = bt.nullAsNil(this.uBz.getString("Contact_Ext_Args_Query_String"));
    int j = this.uBz.getInt("Contact_Ext_Args_Index");
    int i;
    switch (this.ima)
    {
    default: 
      i = 0;
      str1 = bt.nullAsNil(this.uBz.getString("Contact_Ext_Extra_Params"));
      str2 = str3 + "," + paramInt + "," + bt.nullAsNil(this.contact.field_username) + "," + j + "," + System.currentTimeMillis() / 1000L + "," + str2 + "," + i;
      if (bt.isNullOrNil(null)) {
        break;
      }
    }
    for (String str1 = str2 + "," + null + "," + str1;; str1 = str2 + ",," + str1)
    {
      ad.v("MicroMsg.ContactWidgetNewBizInfo", "report 10866: %s", new Object[] { str1 });
      com.tencent.mm.plugin.report.service.h.vKh.kvStat(10866, str1);
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
  
  public final long QU()
  {
    return this.enterTime;
  }
  
  public final boolean SN(String paramString)
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
      if (!com.tencent.mm.model.gdpr.c.atn()) {
        dcw();
      }
      for (;;)
      {
        if (this.uBv != 0) {
          com.tencent.mm.plugin.report.service.h.vKh.f(11263, new Object[] { Integer.valueOf(this.uBv), this.contact.field_username });
        }
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.L(this.contact.field_username, 200, this.ima);
        AppMethodBeat.o(27457);
        return true;
        com.tencent.mm.model.gdpr.c.a(this.uFc, com.tencent.mm.model.gdpr.a.gQa, this.contact.field_username, new com.tencent.mm.model.gdpr.b()
        {
          public final void ns(int paramAnonymousInt)
          {
            AppMethodBeat.i(191239);
            if (paramAnonymousInt == 0) {
              ContactWidgetNewBizInfo.p(ContactWidgetNewBizInfo.this);
            }
            AppMethodBeat.o(191239);
          }
        });
      }
    }
    AppMethodBeat.o(27457);
    return true;
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, com.tencent.mm.storage.af paramaf, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(27443);
    if (this.uFc.isFinishing())
    {
      AppMethodBeat.o(27443);
      return true;
    }
    if (paramaf != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (bt.nullAsNil(paramaf.field_username).length() <= 0) {
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
      T(paramaf);
      this.screen = paramf;
      this.contact = paramaf;
      this.uzZ = paramBoolean;
      this.ima = paramInt;
      this.uBA = ((SnsAdClick)this.uFc.getIntent().getParcelableExtra("KSnsAdTag"));
      this.uBB = this.uFc.getIntent().getStringExtra("key_add_contact_report_info");
      this.uBv = this.uFc.getIntent().getIntExtra("add_more_friend_search_scene", 0);
      this.uBz = this.uFc.getIntent().getBundleExtra("Contact_Ext_Args");
      this.niM = this.uFc.getIntent().getStringExtra("key_channel_session_id");
      if (this.uFh)
      {
        this.uFh = false;
        initActionBar();
        this.uFd = a.akM(this.contact.field_username);
        dcu();
        a(paramaf.field_username, null);
        paramf = this.uFc.getIntent().getStringExtra("Contact_BIZ_PopupInfoMsg");
        if (!bt.isNullOrNil(paramf))
        {
          this.uFc.getIntent().putExtra("Contact_BIZ_PopupInfoMsg", "");
          com.tencent.mm.ui.base.h.a(this.uFc, paramf, "", this.uFc.getString(2131755835), null);
        }
        if (paramaf != null) {
          com.tencent.mm.am.af.awq().ws(paramaf.field_username);
        }
      }
      if (this.uFj != null)
      {
        paramf = this.uFc.getListView();
        if (paramf != null) {
          paramf.onRestoreInstanceState(this.uFj);
        }
      }
      if ((this.uFc instanceof FragmentActivity))
      {
        this.uFc.getLifecycle().removeObserver(this);
        this.uFc.getLifecycle().addObserver(this);
      }
      AppMethodBeat.o(27443);
      return true;
      bool = false;
      break;
      bool = false;
      break label52;
    }
  }
  
  public final boolean acO()
  {
    AppMethodBeat.i(27465);
    if ((this.contact == null) || (this.uzN == null) || (this.uFd == null) || (this.uFd.CKS == null) || (this.uFd.CKR == null))
    {
      ad.w("MicroMsg.ContactWidgetNewBizInfo", "reportEnd fail, err");
      this.mYl.dead();
      this.jBI.dead();
      AppMethodBeat.o(27465);
      return false;
    }
    this.endTime = System.currentTimeMillis();
    String str = this.contact.field_username;
    int k = this.ima;
    int m = this.uzN.field_type;
    long l1 = this.enterTime;
    long l2 = this.endTime;
    int i;
    label134:
    int n;
    int i1;
    if (com.tencent.mm.n.b.ls(this.contact.field_type))
    {
      i = 1;
      n = this.uFd.CKS.CIw;
      i1 = this.uFd.CKS.CIx;
      if (this.uBq == null) {
        break label231;
      }
    }
    label231:
    for (int j = this.uBq.size();; j = 0)
    {
      com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.a(str, k, m, l1, l2, i, n, i1, j, com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.b(this.uFd.CKT), com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.a(this.uFd.CKW), this.uFd.CKR.mAQ);
      break;
      i = 0;
      break label134;
    }
  }
  
  public final boolean bRu()
  {
    AppMethodBeat.i(27455);
    if (this.screen == null)
    {
      AppMethodBeat.o(27455);
      return true;
    }
    Object localObject = (NewBizInfoHeaderPreference)this.screen.aKk("contact_info_header_newbizinfo");
    if (localObject != null) {
      ((NewBizInfoHeaderPreference)localObject).onDetach();
    }
    localObject = this.uFc.getListView();
    if (localObject != null) {
      this.uFj = ((ListView)localObject).onSaveInstanceState();
    }
    AppMethodBeat.o(27455);
    return true;
  }
  
  public final void bYc()
  {
    AppMethodBeat.i(27449);
    if ((this.uFi) && (this.uFd.CKT != null) && (this.uFd.CKT.CKu != null) && (this.uFd.CKT.CKu.CKN == 0)) {
      a(this.contact.field_username, this.uFd.CKT.CKu.CKM);
    }
    AppMethodBeat.o(27449);
  }
  
  public final com.tencent.mm.storage.af ddc()
  {
    return this.contact;
  }
  
  public final int ddf()
  {
    return this.ima;
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public void onActivityDestroy()
  {
    AppMethodBeat.i(27444);
    ad.i("MicroMsg.ContactWidgetNewBizInfo", "[onActivityDestroy]");
    bRu();
    AppMethodBeat.o(27444);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(27456);
    if (this.uFc == null)
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
      com.tencent.mm.plugin.messenger.a.j.cOB().q(str1, str2, bool);
      com.tencent.mm.plugin.messenger.a.j.cOB().hm(paramIntent, str2);
      com.tencent.mm.ui.widget.snackbar.b.n(this.uFc, this.uFc.getString(2131759420));
      AppMethodBeat.o(27456);
      return;
    }
    AppMethodBeat.o(27456);
  }
  
  public final boolean onCreate()
  {
    AppMethodBeat.i(27464);
    if ((this.contact == null) || (this.uzN == null))
    {
      ad.w("MicroMsg.ContactWidgetNewBizInfo", "reportStart fail, err");
      this.mYl.alive();
      this.jBI.alive();
      AppMethodBeat.o(27464);
      return false;
    }
    this.enterTime = System.currentTimeMillis();
    String str = this.contact.field_username;
    int j = this.ima;
    int k = this.uzN.field_type;
    long l = this.enterTime;
    if (com.tencent.mm.n.b.ls(this.contact.field_type)) {}
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.a(str, j, k, l, i, this.niM);
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
    az.aeS().b(paramn.getType(), this);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ad.e("MicroMsg.ContactWidgetNewBizInfo", "scene.getType() = %s", new Object[] { Integer.valueOf(paramn.getType()) });
      AppMethodBeat.o(27461);
      return;
    }
    ad.d("MicroMsg.ContactWidgetNewBizInfo", "scene.getType() = %s", new Object[] { Integer.valueOf(paramn.getType()) });
    if (paramn.getType() == 536)
    {
      az.aeS().b(536, this);
      dcu();
    }
    AppMethodBeat.o(27461);
  }
  
  static final class a
    extends com.tencent.mm.sdk.b.c<t>
  {
    private WeakReference<ContactWidgetNewBizInfo> uFt;
    
    public a(ContactWidgetNewBizInfo paramContactWidgetNewBizInfo)
    {
      AppMethodBeat.i(191242);
      this.uFt = new WeakReference(paramContactWidgetNewBizInfo);
      this.__eventId = t.class.getName().hashCode();
      AppMethodBeat.o(191242);
    }
  }
  
  static final class b
    extends com.tencent.mm.sdk.b.c<ln>
  {
    private WeakReference<ContactWidgetNewBizInfo> uFt;
    
    public b(ContactWidgetNewBizInfo paramContactWidgetNewBizInfo)
    {
      AppMethodBeat.i(191244);
      this.uFt = new WeakReference(paramContactWidgetNewBizInfo);
      this.__eventId = ln.class.getName().hashCode();
      AppMethodBeat.o(191244);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.ContactWidgetNewBizInfo
 * JD-Core Version:    0.7.0.1
 */