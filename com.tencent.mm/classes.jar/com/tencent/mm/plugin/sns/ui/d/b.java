package com.tencent.mm.plugin.sns.ui.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.ClipboardManager;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.dr;
import com.tencent.mm.g.a.dr.b;
import com.tencent.mm.g.a.gu;
import com.tencent.mm.g.a.to;
import com.tencent.mm.g.a.tp;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ak;
import com.tencent.mm.plugin.sns.storage.a.b;
import com.tencent.mm.plugin.sns.storage.a.b.a;
import com.tencent.mm.plugin.sns.storage.b.a;
import com.tencent.mm.plugin.sns.storage.b.b;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.plugin.sns.ui.SnsTimeLineUI;
import com.tencent.mm.plugin.sns.ui.ao;
import com.tencent.mm.plugin.sns.ui.av.a;
import com.tencent.mm.plugin.sns.ui.bc;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.item.c.a;
import com.tencent.mm.plugin.sns.ui.item.h.a;
import com.tencent.mm.plugin.sns.ui.item.j.b;
import com.tencent.mm.plugin.sns.ui.q;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.at;
import com.tencent.mm.protocal.protobuf.av;
import com.tencent.mm.protocal.protobuf.cea;
import com.tencent.mm.protocal.protobuf.ces;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class b
{
  Activity activity;
  int cpt = 0;
  public View.OnTouchListener jVU;
  private ClipboardManager mAZ;
  com.tencent.mm.plugin.sns.model.af rFN;
  public View.OnClickListener rHw;
  protected com.tencent.mm.plugin.sns.a.b.g rOU;
  public b.e siQ;
  public View.OnClickListener sjA;
  public View.OnClickListener sjB;
  public View.OnClickListener sjC;
  public View.OnClickListener sjD;
  public c sjE;
  public c sjF;
  public c sjG;
  public c sjH;
  public c sjI;
  public c sjJ;
  public c sjK;
  c sjL;
  public View.OnClickListener sjM;
  public View.OnClickListener sjN;
  public View.OnClickListener sjO;
  public View.OnClickListener sjP;
  public View.OnClickListener sjQ;
  public View.OnClickListener sjR;
  public View.OnClickListener sjS;
  public AdapterView.OnItemClickListener sjT;
  public AdapterView.OnItemClickListener sjU;
  public View.OnClickListener sjV = new b.1(this);
  public View.OnClickListener sjW = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      boolean bool = false;
      AppMethodBeat.i(40259);
      if (paramAnonymousView.getTag() == null)
      {
        AppMethodBeat.o(40259);
        return;
      }
      com.tencent.mm.plugin.sns.storage.n localn = b.dT(paramAnonymousView);
      if ((localn == null) || (!localn.Ex(32)))
      {
        AppMethodBeat.o(40259);
        return;
      }
      int j;
      int i;
      Object localObject;
      label121:
      int k;
      if (localn.csQ().csb().cqs())
      {
        j = v.gG(localn.csQ().csb().cqn(), localn.csP());
        if (j > 0)
        {
          i = 1;
          localObject = localn.csQ().csb().cqn();
          String str1 = localn.csP();
          com.tencent.mm.kernel.g.RJ();
          String str2 = com.tencent.mm.kernel.a.QC();
          if (i == 0) {
            break label213;
          }
          if (i == 0) {
            break label218;
          }
          k = 0;
          label128:
          v.h((String)localObject, str1, str2, j, k);
          if (i != 0) {}
        }
      }
      for (bool = true;; bool = false)
      {
        localObject = localn.csh();
        if ((((TimeLineObject)localObject).xTS.wNZ == 15) && (((TimeLineObject)localObject).xTZ != 1))
        {
          b.a(b.this, paramAnonymousView, localn, 1002, localn.csQ().csb().cqu(), bool);
          AppMethodBeat.o(40259);
          return;
          i = 0;
          break;
          label213:
          j = 2;
          break label121;
          label218:
          k = 1;
          break label128;
        }
        if (((((TimeLineObject)localObject).xTS.wNZ == 1) && (((TimeLineObject)localObject).xTS.wOa.size() == 1)) || (((TimeLineObject)localObject).xTS.wNZ == 7)) {
          b.b(b.this, paramAnonymousView, localn, 1002, localn.csQ().csb().cqu(), bool);
        }
        AppMethodBeat.o(40259);
        return;
      }
    }
  };
  public View.OnClickListener sjX;
  public av.a sjY;
  int sjZ;
  volatile com.tencent.mm.plugin.sns.ui.b.b.b sjn;
  volatile com.tencent.mm.plugin.sns.ui.b.b.a sjo;
  volatile com.tencent.mm.plugin.sns.ui.b.a.b sjp;
  volatile com.tencent.mm.plugin.sns.ui.b.a.a sjq;
  public a sjr;
  public View.OnClickListener sjs;
  public View.OnLongClickListener sjt;
  public c sju;
  public View.OnClickListener sjv;
  public View.OnClickListener sjw;
  public View.OnClickListener sjx;
  public View.OnClickListener sjy;
  public View.OnClickListener sjz;
  private com.tencent.mm.sdk.b.c<tp> ska = new b.23(this);
  private com.tencent.mm.sdk.b.c<to> skb = new b.33(this);
  public View.OnClickListener skc = new b.32(this);
  
  public b(int paramInt, Activity paramActivity, com.tencent.mm.plugin.sns.model.af paramaf)
  {
    this.cpt = paramInt;
    this.activity = paramActivity;
    this.rFN = paramaf;
    if (((paramActivity instanceof SnsTimeLineUI)) && (paramInt == 0)) {
      this.rOU = ((SnsTimeLineUI)paramActivity).cwf();
    }
    this.sjZ = bo.getInt(com.tencent.mm.m.g.Nq().getValue("SnsPOICommentFeedNewUrlSwitch"), 0);
    ab.i("MicroMsg.TimelineClickListener", "init POIComment_FeedNewUrl_Switch:%d", new Object[] { Integer.valueOf(this.sjZ) });
    this.mAZ = ((ClipboardManager)ah.getContext().getSystemService("clipboard"));
    this.sjr = new a(this.activity, this.cpt, this.rFN);
    this.sjC = new b.34(this);
    this.sjN = new b.35(this);
    this.sjR = new b.36(this);
    this.sjS = new b.37(this);
    this.sjs = new b.38(this);
    this.sjt = new b.2(this);
    this.sju = new b.3(this);
    this.sjJ = new b.4(this);
    this.sjK = new b.5(this);
    this.sjG = new c()
    {
      public final void a(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(40249);
        if ((paramAnonymousView.getTag() instanceof q)) {
          b.this.sjL.onCreateContextMenu(paramAnonymousContextMenu, paramAnonymousView, paramAnonymousContextMenuInfo);
        }
        AppMethodBeat.o(40249);
      }
      
      public final boolean dU(View paramAnonymousView)
      {
        AppMethodBeat.i(40250);
        if ((paramAnonymousView.getTag() instanceof q))
        {
          String str = ((q)paramAnonymousView.getTag()).crk;
          com.tencent.mm.plugin.sns.storage.n localn = ag.cpf().abv(str);
          b.this.sjr.a(paramAnonymousView, str, localn.csh());
          AppMethodBeat.o(40250);
          return true;
        }
        AppMethodBeat.o(40250);
        return false;
      }
    };
    this.sjF = new c()
    {
      public final void a(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(40251);
        int j;
        int i;
        if ((paramAnonymousView != null) && ((paramAnonymousView.getTag() instanceof ao)))
        {
          paramAnonymousContextMenuInfo = ((ao)paramAnonymousView.getTag()).ctV;
          com.tencent.mm.plugin.sns.storage.n localn = ag.cpf().abv(paramAnonymousContextMenuInfo);
          if (com.tencent.mm.bq.d.ahR("favorite"))
          {
            paramAnonymousContextMenu.add(0, 2, 0, b.this.activity.getString(2131302102));
            dr localdr = new dr();
            localdr.crt.crk = paramAnonymousContextMenuInfo;
            com.tencent.mm.sdk.b.a.ymk.l(localdr);
            if (localdr.cru.cqS) {
              paramAnonymousContextMenu.add(0, 18, 0, b.this.activity.getString(2131297019));
            }
          }
          com.tencent.mm.plugin.sns.abtest.a.a(paramAnonymousContextMenu, localn);
          paramAnonymousContextMenu = paramAnonymousContextMenu.add(0, 21, 0, b.this.activity.getString(2131303802));
          paramAnonymousContextMenuInfo = new int[2];
          if (paramAnonymousView == null) {
            break label238;
          }
          j = paramAnonymousView.getWidth();
          i = paramAnonymousView.getHeight();
          paramAnonymousView.getLocationInWindow(paramAnonymousContextMenuInfo);
        }
        for (;;)
        {
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("img_gallery_width", j).putExtra("img_gallery_height", i).putExtra("img_gallery_left", paramAnonymousContextMenuInfo[0]).putExtra("img_gallery_top", paramAnonymousContextMenuInfo[1]);
          paramAnonymousContextMenu.setIntent(paramAnonymousView);
          AppMethodBeat.o(40251);
          return;
          label238:
          i = 0;
          j = 0;
        }
      }
      
      public final boolean dU(View paramAnonymousView)
      {
        AppMethodBeat.i(40252);
        if ((paramAnonymousView.getTag() instanceof ao))
        {
          String str = ((ao)paramAnonymousView.getTag()).ctV;
          com.tencent.mm.plugin.sns.storage.n localn = ag.cpf().abv(str);
          b.this.sjr.a(paramAnonymousView, str, localn.csh());
          AppMethodBeat.o(40252);
          return true;
        }
        AppMethodBeat.o(40252);
        return false;
      }
    };
    this.sjI = new c()
    {
      public final void a(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(40254);
        paramAnonymousContextMenuInfo = paramAnonymousView.getTag();
        if ((paramAnonymousContextMenuInfo instanceof ao)) {
          paramAnonymousContextMenuInfo = ((ao)paramAnonymousContextMenuInfo).ctV;
        }
        for (;;)
        {
          if (paramAnonymousContextMenuInfo != null)
          {
            paramAnonymousContextMenuInfo = ag.cpf().abv(paramAnonymousContextMenuInfo);
            TimeLineObject localTimeLineObject = paramAnonymousContextMenuInfo.csh();
            if (com.tencent.mm.bq.d.ahR("favorite")) {
              switch (localTimeLineObject.xTS.wNZ)
              {
              }
            }
          }
          for (;;)
          {
            com.tencent.mm.plugin.sns.abtest.a.a(paramAnonymousContextMenu, paramAnonymousContextMenuInfo);
            AppMethodBeat.o(40254);
            return;
            if (!(paramAnonymousContextMenuInfo instanceof q)) {
              break label158;
            }
            paramAnonymousContextMenuInfo = ((q)paramAnonymousContextMenuInfo).crk;
            break;
            paramAnonymousContextMenu.add(0, 10, 0, paramAnonymousView.getContext().getString(2131302102));
            continue;
            paramAnonymousContextMenu.add(0, 2, 0, paramAnonymousView.getContext().getString(2131302102));
          }
          label158:
          paramAnonymousContextMenuInfo = null;
        }
      }
      
      public final boolean dU(View paramAnonymousView)
      {
        AppMethodBeat.i(40253);
        Object localObject = paramAnonymousView.getTag();
        if ((localObject instanceof ao)) {
          localObject = ((ao)localObject).ctV;
        }
        for (;;)
        {
          if (localObject != null)
          {
            com.tencent.mm.plugin.sns.storage.n localn = ag.cpf().abv((String)localObject);
            b.this.sjr.a(paramAnonymousView, (String)localObject, localn.csh());
            AppMethodBeat.o(40253);
            return true;
            if ((localObject instanceof q)) {
              localObject = ((q)localObject).crk;
            }
          }
          else
          {
            AppMethodBeat.o(40253);
            return false;
          }
          localObject = null;
        }
      }
    };
    this.rHw = new b.9(this);
    this.sjv = new b.10(this);
    this.sjw = new b.11(this);
    this.sjx = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(40260);
        paramAnonymousView = (String)paramAnonymousView.getTag();
        ab.d("MicroMsg.TimelineClickListener", "onItemDelClick:".concat(String.valueOf(paramAnonymousView)));
        paramAnonymousView = ag.cpf().abv(paramAnonymousView).csh();
        av localav = paramAnonymousView.rjv;
        if (localav.wmJ == null)
        {
          AppMethodBeat.o(40260);
          return;
        }
        String str = com.tencent.mm.plugin.sns.c.a.gmP.dE(localav.wmJ.fKw);
        int i = 0;
        if (paramAnonymousView.xTS.wNZ == 1) {
          i = 2;
        }
        while (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(paramAnonymousView, b.this.activity))
        {
          com.tencent.mm.plugin.sns.c.a.gmP.a(b.this.activity, localav.wmJ.fKw, str, paramAnonymousView.jJA, i, 11, 9, localav.wmJ.wmD, paramAnonymousView.Id);
          AppMethodBeat.o(40260);
          return;
          if (paramAnonymousView.xTS.wNZ == 3) {
            i = 5;
          } else if (paramAnonymousView.xTS.wNZ == 15) {
            i = 38;
          }
        }
        switch (localav.jKs)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(40260);
          return;
          Object localObject = new Intent();
          ((Intent)localObject).putExtra("rawUrl", localav.Url);
          com.tencent.mm.plugin.sns.c.a.gmO.i((Intent)localObject, b.this.activity);
          com.tencent.mm.plugin.sns.c.a.gmP.a(b.this.activity, localav.wmJ.fKw, str, paramAnonymousView.jJA, i, 11, 1, localav.wmJ.wmD, paramAnonymousView.Id);
          AppMethodBeat.o(40260);
          return;
          if (localav.Scene == 1)
          {
            localObject = new gu();
            ((gu)localObject).cvL.actionCode = 2;
            ((gu)localObject).cvL.scene = 3;
            ((gu)localObject).cvL.appId = localav.wmJ.fKw;
            ((gu)localObject).cvL.context = b.this.activity;
            com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
            com.tencent.mm.plugin.sns.c.a.gmP.a(b.this.activity, localav.wmJ.fKw, str, paramAnonymousView.jJA, i, 11, 6, localav.wmJ.wmD, paramAnonymousView.Id);
            AppMethodBeat.o(40260);
            return;
            int j = com.tencent.mm.plugin.sns.ui.af.a(b.this.activity, localav);
            if (j == 1)
            {
              localObject = new gu();
              ((gu)localObject).cvL.context = b.this.activity;
              ((gu)localObject).cvL.actionCode = 2;
              ((gu)localObject).cvL.appId = localav.wmJ.fKw;
              ((gu)localObject).cvL.messageAction = localav.wmJ.wmF;
              ((gu)localObject).cvL.messageExt = localav.wmJ.wmE;
              ((gu)localObject).cvL.scene = 3;
              com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
              com.tencent.mm.plugin.sns.c.a.gmP.a(b.this.activity, localav.wmJ.fKw, str, paramAnonymousView.jJA, i, 11, 6, localav.wmJ.wmD, paramAnonymousView.Id);
              AppMethodBeat.o(40260);
              return;
            }
            if (j == 2)
            {
              localObject = new gu();
              ((gu)localObject).cvL.context = b.this.activity;
              ((gu)localObject).cvL.actionCode = 1;
              ((gu)localObject).cvL.appId = localav.wmJ.fKw;
              ((gu)localObject).cvL.messageAction = localav.wmJ.wmF;
              ((gu)localObject).cvL.messageExt = localav.wmJ.wmE;
              ((gu)localObject).cvL.scene = 3;
              com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
              com.tencent.mm.plugin.sns.c.a.gmP.a(b.this.activity, localav.wmJ.fKw, str, paramAnonymousView.jJA, i, 11, 3, localav.wmJ.wmD, paramAnonymousView.Id);
            }
          }
        }
      }
    };
    this.sjD = new View.OnClickListener()
    {
      private static void acr(String paramAnonymousString)
      {
        AppMethodBeat.i(40262);
        long l = ag.cpf().abv(paramAnonymousString).field_snsId;
        Object localObject1 = ag.cpf().lZ(l);
        if (localObject1 != null)
        {
          Object localObject2 = ((com.tencent.mm.plugin.sns.storage.n)localObject1).csh();
          if (localObject2 != null)
          {
            localObject2 = ((TimeLineObject)localObject2).xTS.wOa;
            if (((List)localObject2).size() > 0) {
              ((List)localObject2).get(0);
            }
          }
          localObject2 = ak.q((com.tencent.mm.plugin.sns.storage.n)localObject1);
          localObject1 = new ArrayList();
          localObject2 = ((SnsObject)localObject2).SnsRedEnvelops.xPe;
          if (localObject2 != null)
          {
            int i = 0;
            while (i < ((List)localObject2).size())
            {
              cea localcea = (cea)((List)localObject2).get(i);
              com.tencent.mm.plugin.l.a.a locala = new com.tencent.mm.plugin.l.a.a();
              locala.ikj = localcea.Username;
              locala.oic = localcea.CreateTime;
              locala.oid = localcea.xOb;
              ((List)localObject1).add(locala);
              i += 1;
            }
          }
          com.tencent.mm.plugin.l.a.p(paramAnonymousString, (List)localObject1);
        }
        AppMethodBeat.o(40262);
      }
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(40261);
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.storage.n))
        {
          paramAnonymousView = (com.tencent.mm.plugin.sns.storage.n)paramAnonymousView.getTag();
          if ((paramAnonymousView.field_type == 21) && (com.tencent.mm.model.r.Zn().equals(paramAnonymousView.field_userName)))
          {
            paramAnonymousView.csh();
            com.tencent.mm.plugin.sns.lucky.a.m.m(paramAnonymousView);
            com.tencent.mm.plugin.sns.lucky.a.m.l(paramAnonymousView);
            System.currentTimeMillis();
            com.tencent.mm.plugin.sns.lucky.a.b.kS(24);
          }
          Object localObject = new Intent();
          ((Intent)localObject).putExtra("key_sendid", paramAnonymousView.getSnsId());
          ((Intent)localObject).putExtra("key_feedid", paramAnonymousView.csH());
          ((Intent)localObject).setClassName(b.this.activity, "com.tencent.mm.plugin.sns.lucky.ui.SnsLuckyMoneyDetailUI");
          b.this.activity.startActivity((Intent)localObject);
          localObject = paramAnonymousView.csH();
          paramAnonymousView.getSnsId();
          acr((String)localObject);
        }
        AppMethodBeat.o(40261);
      }
    };
    this.sjy = new b.15(this);
    this.sjz = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(40264);
        b.this.dM(paramAnonymousView);
        AppMethodBeat.o(40264);
      }
    };
    this.sjA = new b.17(this);
    this.sjB = new b.18(this);
    this.sjE = new b.19(this);
    this.jVU = new b.20(this);
    this.sjM = new b.21(this);
    this.sjP = new b.22(this);
    this.sjO = new b.24(this);
    this.sjH = new b.25(this);
    this.sjQ = new b.26(this);
    this.sjT = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(40283);
        ab.i("MicroMsg.TimelineClickListener", "unlike click");
        if (!(paramAnonymousAdapterView.getAdapter() instanceof com.tencent.mm.plugin.sns.ui.c))
        {
          ab.w("MicroMsg.TimelineClickListener", "unknown unlike adapter click");
          AppMethodBeat.o(40283);
          return;
        }
        Object localObject2 = (com.tencent.mm.plugin.sns.data.b)paramAnonymousView.getTag();
        com.tencent.mm.plugin.sns.storage.n localn = ag.cpf().abv(((com.tencent.mm.plugin.sns.data.b)localObject2).crk);
        if (localn == null)
        {
          AppMethodBeat.o(40283);
          return;
        }
        Object localObject1;
        if (paramAnonymousInt == 0)
        {
          if (localn.Ex(32))
          {
            localObject1 = b.a(b.this, localn);
            if (localObject1 == null)
            {
              localObject1 = "";
              ((com.tencent.mm.plugin.sns.b.c)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.sns.b.c.class)).a(11855, localn.csR(), new Object[] { Integer.valueOf(3), localObject1, Integer.valueOf(localn.csR()) });
            }
          }
          else
          {
            if (((com.tencent.mm.plugin.sns.data.b)localObject2).rba.scr.rpz.cqj().size() <= 0) {
              break label295;
            }
          }
          label295:
          for (paramAnonymousInt = 1;; paramAnonymousInt = 0)
          {
            if (paramAnonymousInt == 0) {
              break label300;
            }
            paramAnonymousView = (com.tencent.mm.plugin.sns.ui.c)paramAnonymousAdapterView.getAdapter();
            paramAnonymousView.hAu += 1;
            paramAnonymousView.notifyDataSetChanged();
            paramAnonymousAdapterView.setOnItemClickListener(b.this.sjU);
            b.this.ctt();
            paramAnonymousAdapterView = new a.b.a();
            paramAnonymousAdapterView.rpM = a.b.a.rpI;
            paramAnonymousAdapterView.rbb = ((com.tencent.mm.plugin.sns.data.b)localObject2).rbb;
            paramAnonymousAdapterView.rpN = 0L;
            paramAnonymousAdapterView = new com.tencent.mm.plugin.sns.model.r(localn.field_snsId, 8, paramAnonymousAdapterView);
            com.tencent.mm.kernel.g.RM();
            com.tencent.mm.kernel.g.RK().eHt.a(paramAnonymousAdapterView, 0);
            AppMethodBeat.o(40283);
            return;
            localObject1 = ((com.tencent.mm.plugin.sns.storage.a)localObject1).hpq;
            break;
          }
          label300:
          if (((com.tencent.mm.plugin.sns.data.b)localObject2).rba.scr.rpD)
          {
            AppMethodBeat.o(40283);
            return;
          }
          b.this.dO(paramAnonymousView);
          paramAnonymousAdapterView = new a.b.a();
          paramAnonymousAdapterView.rbb = ((com.tencent.mm.plugin.sns.data.b)localObject2).rbb;
          paramAnonymousAdapterView.rpN = System.currentTimeMillis();
          paramAnonymousAdapterView = new com.tencent.mm.plugin.sns.model.r(localn.field_snsId, 8, paramAnonymousAdapterView);
          com.tencent.mm.kernel.g.RM();
          com.tencent.mm.kernel.g.RK().eHt.a(paramAnonymousAdapterView, 0);
          AppMethodBeat.o(40283);
          return;
        }
        if (((com.tencent.mm.plugin.sns.data.b)localObject2).rba.scq.rqK == null)
        {
          ab.e("MicroMsg.TimelineClickListener", "click feedback item but no report url");
          AppMethodBeat.o(40283);
          return;
        }
        paramAnonymousAdapterView = ((com.tencent.mm.plugin.sns.data.b)localObject2).rba.scq.rqK;
        paramAnonymousInt -= 1;
        if (paramAnonymousInt < paramAnonymousAdapterView.list.size()) {
          paramAnonymousAdapterView = ((b.b)paramAnonymousAdapterView.list.get(paramAnonymousInt)).url;
        }
        try
        {
          paramAnonymousView = String.format("snsid=%s", new Object[] { localn.csh().Id });
          localObject1 = String.format("aid=%s", new Object[] { localn.csM() });
          localObject2 = String.format("traceid=%s", new Object[] { localn.csN() });
          com.tencent.mm.kernel.g.RJ();
          paramAnonymousView = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.m(paramAnonymousAdapterView, new String[] { paramAnonymousView, localObject1, localObject2, String.format("uin=%s", new Object[] { com.tencent.mm.kernel.a.QC() }) });
          paramAnonymousAdapterView = paramAnonymousView;
        }
        catch (Exception paramAnonymousView)
        {
          label572:
          break label572;
        }
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("rawUrl", paramAnonymousAdapterView);
        paramAnonymousView.putExtra("useJs", true);
        paramAnonymousView.putExtra("KPublisherId", "sns_" + com.tencent.mm.plugin.sns.data.i.lq(localn.field_snsId));
        paramAnonymousView.putExtra("pre_username", localn.field_userName);
        paramAnonymousView.putExtra("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.i.lq(localn.field_snsId));
        paramAnonymousView.putExtra("preUsername", localn.field_userName);
        com.tencent.mm.plugin.sns.c.a.gmO.i(paramAnonymousView, b.this.activity);
        AppMethodBeat.o(40283);
      }
    };
    this.sjU = new b.28(this);
    this.sjX = new b.29(this);
    this.sjL = new b.30(this);
    this.siQ = new b.31(this);
  }
  
  public final void a(com.tencent.mm.plugin.sns.ui.c.a.a parama)
  {
    if ((parama instanceof com.tencent.mm.plugin.sns.ui.c.a.b))
    {
      this.sjp = new com.tencent.mm.plugin.sns.ui.b.a.d((MMActivity)this.activity, parama);
      this.sjq = new com.tencent.mm.plugin.sns.ui.b.a.c((MMActivity)this.activity, parama);
    }
    do
    {
      return;
      if ((parama instanceof com.tencent.mm.plugin.sns.ui.c.a.c))
      {
        this.sjp = new com.tencent.mm.plugin.sns.ui.b.a.f((MMActivity)this.activity, parama);
        this.sjq = new com.tencent.mm.plugin.sns.ui.b.a.e((MMActivity)this.activity, parama);
        return;
      }
      if ((parama instanceof com.tencent.mm.plugin.sns.ui.c.a.e))
      {
        this.sjp = new com.tencent.mm.plugin.sns.ui.b.a.j((MMActivity)this.activity, parama);
        this.sjq = new com.tencent.mm.plugin.sns.ui.b.a.i((MMActivity)this.activity, parama);
        return;
      }
    } while (!(parama instanceof com.tencent.mm.plugin.sns.ui.c.a.d));
    this.sjp = new com.tencent.mm.plugin.sns.ui.b.a.h((MMActivity)this.activity, parama);
    this.sjq = new com.tencent.mm.plugin.sns.ui.b.a.g((MMActivity)this.activity, parama);
  }
  
  public abstract void b(View paramView, int paramInt1, int paramInt2, int paramInt3);
  
  public final void bKw()
  {
    this.sjr.bKw();
    com.tencent.mm.sdk.b.a.ymk.c(this.ska);
    com.tencent.mm.sdk.b.a.ymk.c(this.skb);
  }
  
  public abstract void ci(Object paramObject);
  
  public abstract void cts();
  
  public abstract void ctt();
  
  public abstract void dJ(View paramView);
  
  public abstract void dK(View paramView);
  
  public abstract void dL(View paramView);
  
  public abstract void dM(View paramView);
  
  public abstract void dN(View paramView);
  
  public abstract void dO(View paramView);
  
  public final void i(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    if ((paramBaseViewHolder instanceof com.tencent.mm.plugin.sns.ui.item.a.a))
    {
      this.sjn = new com.tencent.mm.plugin.sns.ui.b.b.d((MMActivity)this.activity, paramBaseViewHolder);
      this.sjo = new com.tencent.mm.plugin.sns.ui.b.b.c((MMActivity)this.activity, paramBaseViewHolder);
    }
    do
    {
      return;
      if ((paramBaseViewHolder instanceof c.a))
      {
        this.sjn = new com.tencent.mm.plugin.sns.ui.b.b.f((MMActivity)this.activity, paramBaseViewHolder);
        this.sjo = new com.tencent.mm.plugin.sns.ui.b.b.e((MMActivity)this.activity, paramBaseViewHolder);
        return;
      }
      if ((paramBaseViewHolder instanceof j.b))
      {
        this.sjn = new com.tencent.mm.plugin.sns.ui.b.b.j((MMActivity)this.activity, paramBaseViewHolder);
        this.sjo = new com.tencent.mm.plugin.sns.ui.b.b.i((MMActivity)this.activity, paramBaseViewHolder);
        return;
      }
    } while (!(paramBaseViewHolder instanceof h.a));
    this.sjn = new com.tencent.mm.plugin.sns.ui.b.b.h((MMActivity)this.activity, paramBaseViewHolder);
    this.sjo = new com.tencent.mm.plugin.sns.ui.b.b.g((MMActivity)this.activity, paramBaseViewHolder);
  }
  
  public final void removeListener()
  {
    this.sjr.removeListener();
    com.tencent.mm.sdk.b.a.ymk.d(this.ska);
    com.tencent.mm.sdk.b.a.ymk.d(this.skb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.b
 * JD-Core Version:    0.7.0.1
 */