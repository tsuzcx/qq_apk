package com.tencent.mm.plugin.radar.ui;

import a.d.b.o;
import a.k;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.radar.a.b;
import com.tencent.mm.plugin.radar.a.c;
import com.tencent.mm.plugin.radar.a.d;
import com.tencent.mm.plugin.radar.b.c;
import com.tencent.mm.plugin.radar.b.c.e;
import com.tencent.mm.plugin.radar.b.d;
import com.tencent.mm.plugin.radar.b.e.a;
import com.tencent.mm.plugin.radar.b.e.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.bio;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class RadarViewController$c
  extends a
{
  private final Context context;
  bio[] nnR;
  HashMap<String, String> nnS;
  HashMap<String, Integer> nnT;
  final RadarViewController.a nnU;
  private int nnV;
  HashMap<String, View> nnW;
  private boolean nnX;
  
  public RadarViewController$c(RadarSpecialGridView paramRadarSpecialGridView, Context paramContext)
  {
    super(paramContext, localObject);
    this.context = localObject;
    this.nnR = new bio[12];
    this.nnS = new HashMap();
    this.nnT = new HashMap();
    this.nnW = new HashMap();
    this.nnU = new RadarViewController.a(paramRadarSpecialGridView);
  }
  
  private final View M(View paramView, int paramInt)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = View.inflate(this.context, a.d.radar_result_item, null);
      if (localView == null) {
        a.d.b.g.cUk();
      }
      localView.setTag(RadarViewController.a(this.nnP), Integer.valueOf(this.nnU.buT()));
      localView.setTag(RadarViewController.b(this.nnP), this.nnU.getInAnimation());
    }
    paramView = localView.findViewById(a.c.radar_result_item_avatar_iv);
    a.d.b.g.j(paramView, "anotherConvertView.findV…ar_result_item_avatar_iv)");
    paramView.setVisibility(8);
    paramView = localView.findViewById(a.c.radar_result_item_avatar_mask_iv);
    a.d.b.g.j(paramView, "anotherConvertView.findV…sult_item_avatar_mask_iv)");
    paramView.setVisibility(8);
    paramView = localView.findViewById(a.c.radar_result_item_username_tv);
    a.d.b.g.j(paramView, "anotherConvertView.findV…_result_item_username_tv)");
    paramView.setVisibility(4);
    paramView = localView.findViewById(a.c.radar_member_state_view);
    a.d.b.g.j(paramView, "anotherConvertView.findV….radar_member_state_view)");
    paramView.setVisibility(4);
    paramView = localView.findViewById(a.c.radar_member_state_choose_view);
    a.d.b.g.j(paramView, "anotherConvertView.findV…member_state_choose_view)");
    paramView.setVisibility(4);
    if ((paramInt == 7) || (paramInt % 3 == 1))
    {
      paramView = localView.findViewById(a.c.bottom_stub);
      a.d.b.g.j(paramView, "anotherConvertView.findV…d<View>(R.id.bottom_stub)");
      paramView.setVisibility(0);
      paramView = localView.findViewById(a.c.top_stub);
      a.d.b.g.j(paramView, "anotherConvertView.findV…ById<View>(R.id.top_stub)");
      paramView.setVisibility(8);
      return localView;
    }
    paramView = localView.findViewById(a.c.top_stub);
    a.d.b.g.j(paramView, "anotherConvertView.findV…ById<View>(R.id.top_stub)");
    paramView.setVisibility(0);
    paramView = localView.findViewById(a.c.bottom_stub);
    a.d.b.g.j(paramView, "anotherConvertView.findV…d<View>(R.id.bottom_stub)");
    paramView.setVisibility(8);
    return localView;
  }
  
  public final View L(View paramView, int paramInt)
  {
    Object localObject1 = RadarViewController.nnL;
    y.d(RadarViewController.access$getTAG$cp(), "getview RadarStatus%s", new Object[] { this.nnP.getRadarStatus() });
    bio localbio = (bio)this.nnR[paramInt];
    int i;
    label97:
    label103:
    String str;
    Object localObject2;
    if (localbio != null)
    {
      localObject1 = (CharSequence)localbio.hPY;
      if ((localObject1 == null) || (a.h.e.X((CharSequence)localObject1)))
      {
        i = 1;
        if (i == 0) {
          break label229;
        }
        localObject1 = (CharSequence)localbio.sUr;
        if ((localObject1 != null) && (!a.h.e.X((CharSequence)localObject1))) {
          break label224;
        }
        i = 1;
        if (i == 0) {
          break label229;
        }
        i = 1;
        if (i != 0) {
          break label1593;
        }
        localObject1 = g.nnt;
        str = g.b(localbio);
        localObject2 = this.nnP.getRadarStatus();
        if (paramView != null) {
          break label1600;
        }
        localObject1 = View.inflate(this.context, a.d.radar_result_item, null);
        if (localObject1 == null) {
          a.d.b.g.cUk();
        }
        ((View)localObject1).setTag(RadarViewController.a(this.nnP), Integer.valueOf(this.nnU.buT()));
        ((View)localObject1).setTag(RadarViewController.b(this.nnP), this.nnU.getInAnimation());
      }
    }
    for (;;)
    {
      Object localObject3 = ((View)localObject1).findViewById(a.c.radar_result_item_avatar_iv);
      if (localObject3 == null)
      {
        throw new k("null cannot be cast to non-null type android.widget.ImageView");
        i = 0;
        break;
        label224:
        i = 0;
        break label97;
        label229:
        i = 0;
        break label103;
      }
      localObject3 = (ImageView)localObject3;
      Object localObject4 = ((View)localObject1).findViewById(a.c.radar_member_state_view);
      if (localObject4 == null) {
        throw new k("null cannot be cast to non-null type com.tencent.mm.plugin.radar.ui.RadarStateView");
      }
      localObject4 = (RadarStateView)localObject4;
      Object localObject5 = ((View)localObject1).findViewById(a.c.radar_result_item_username_tv);
      if (localObject5 == null) {
        throw new k("null cannot be cast to non-null type android.widget.TextView");
      }
      localObject5 = (TextView)localObject5;
      Object localObject6 = ((View)localObject1).findViewById(a.c.radar_result_item_avatar_mask_iv);
      if (localObject6 == null) {
        throw new k("null cannot be cast to non-null type android.widget.ImageView");
      }
      localObject6 = (ImageView)localObject6;
      Object localObject7 = ((View)localObject1).findViewById(a.c.radar_member_state_choose_view);
      if (localObject7 == null) {
        throw new k("null cannot be cast to non-null type com.tencent.mm.plugin.radar.ui.RadarStateChooseView");
      }
      localObject7 = (RadarStateChooseView)localObject7;
      ((ImageView)localObject3).setVisibility(0);
      ((RadarStateView)localObject4).setVisibility(0);
      ((TextView)localObject5).setVisibility(0);
      ((ImageView)localObject6).setVisibility(0);
      if ((localObject2 == e.e.nlv) || (localObject2 == e.e.nlw))
      {
        ((RadarStateView)localObject4).setVisibility(0);
        ((RadarStateChooseView)localObject7).setVisibility(8);
        ((View)localObject1).setTag(new RadarViewController.c.a(this, (TextView)localObject5, (ImageView)localObject3, (RadarStateView)localObject4, (RadarStateChooseView)localObject7, (ImageView)localObject6));
        if ((paramInt != 7) && (paramInt % 3 != 1)) {
          break label566;
        }
        localObject2 = ((View)localObject1).findViewById(a.c.bottom_stub);
        a.d.b.g.j(localObject2, "anotherConvertView.findV…d<View>(R.id.bottom_stub)");
        ((View)localObject2).setVisibility(0);
        localObject2 = ((View)localObject1).findViewById(a.c.top_stub);
        a.d.b.g.j(localObject2, "anotherConvertView.findV…ById<View>(R.id.top_stub)");
        ((View)localObject2).setVisibility(8);
      }
      for (;;)
      {
        if ((paramView == null) || (localObject1 != paramView)) {
          this.nnW.put(str, localObject1);
        }
        localObject2 = ((View)localObject1).getTag();
        if (localObject2 != null) {
          break label616;
        }
        throw new k("null cannot be cast to non-null type com.tencent.mm.plugin.radar.ui.RadarViewController.RadarSearchAdapter.ViewHolder");
        ((RadarStateView)localObject4).setVisibility(8);
        ((RadarStateChooseView)localObject7).setVisibility(0);
        break;
        label566:
        localObject2 = ((View)localObject1).findViewById(a.c.top_stub);
        a.d.b.g.j(localObject2, "anotherConvertView.findV…ById<View>(R.id.top_stub)");
        ((View)localObject2).setVisibility(0);
        localObject2 = ((View)localObject1).findViewById(a.c.bottom_stub);
        a.d.b.g.j(localObject2, "anotherConvertView.findV…d<View>(R.id.bottom_stub)");
        ((View)localObject2).setVisibility(8);
      }
      label616:
      localObject4 = (RadarViewController.c.a)localObject2;
      ((RadarViewController.c.a)localObject4).nnY.setText((CharSequence)j.a(this.nnP.getContext(), (CharSequence)localbio.hRf, ((RadarViewController.c.a)localObject4).nnY.getTextSize()));
      localObject2 = b.a.nlM;
      b.a.a(((RadarViewController.c.a)localObject4).nnZ, str);
      localObject2 = ((View)localObject1).findViewById(a.c.radar_avatar_container);
      a.d.b.g.j(localObject2, "view.findViewById(R.id.radar_avatar_container)");
      ((View)localObject2).setTag(new RadarViewController.d(this.nnP, localbio));
      if ((this.nnP.getRadarStatus() == e.e.nlv) || (this.nnP.getRadarStatus() == e.e.nlw))
      {
        ((RadarViewController.c.a)localObject4).noc.setBackgroundResource(a.b.selector_radar_avatar);
        paramView = ((RadarViewController.c.a)localObject4).noa;
        paramView.nmK = true;
        paramView.buK();
        paramView = ((RadarViewController.c.a)localObject4).nob;
        paramView.nmE = false;
        paramView.setVisibility(8);
        localObject2 = com.tencent.mm.plugin.radar.b.e.a(RadarViewController.c(this.nnP), localbio);
        paramView = (View)localObject2;
        if (localObject2 == null)
        {
          paramView = RadarViewController.e(this.nnP).Lx(str);
          localObject2 = RadarViewController.c(this.nnP);
          a.d.b.g.k(localbio, "member");
          a.d.b.g.k(paramView, "state");
          localObject3 = localbio.hPY;
          a.d.b.g.j(localObject3, "member.UserName");
          ((com.tencent.mm.plugin.radar.b.e)localObject2).b((String)localObject3, paramView);
          localObject3 = localbio.sUr;
          a.d.b.g.j(localObject3, "member.EncodeUserName");
          ((com.tencent.mm.plugin.radar.b.e)localObject2).b((String)localObject3, paramView);
        }
        localObject3 = RadarViewController.c(this.nnP).a(localbio, true);
        localObject5 = ((RadarViewController.c.a)localObject4).noa;
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = c.e.nkE;
        }
        a.d.b.g.k(localObject2, "state");
        ((RadarStateView)localObject5).init();
        ((RadarStateView)localObject5).nmL.removeMessages(0);
        ((RadarStateView)localObject5).clearAnimation();
        ((RadarStateView)localObject5).nlu = ((c.e)localObject2);
        ((RadarStateView)localObject5).nmB = false;
        ((RadarStateView)localObject5).buK();
        localObject2 = ((RadarViewController.c.a)localObject4).noa;
        a.d.b.g.k(paramView, "state");
        ((RadarStateView)localObject2).init();
        localObject3 = RadarStateView.nmO;
        y.d(RadarStateView.access$getTAG$cp(), " turnToState : " + paramView);
        boolean bool = false;
        if (((RadarStateView)localObject2).nlu == paramView) {
          ((RadarStateView)localObject2).buK();
        }
        for (;;)
        {
          paramView = RadarViewController.c(this.nnP);
          a.d.b.g.k(localbio, "member");
          localObject2 = localbio.hPY;
          a.d.b.g.j(localObject2, "member.UserName");
          paramView.a((String)localObject2, null);
          localObject2 = localbio.sUr;
          a.d.b.g.j(localObject2, "member.EncodeUserName");
          paramView.a((String)localObject2, null);
          if (paramInt == 0) {
            this.nnV = this.nnT.size();
          }
          if (this.nnT.remove(str) != null) {
            this.nnU.f(this.nnV - this.nnT.size(), (View)localObject1);
          }
          return localObject1;
          if (((RadarStateView)localObject2).getVisibility() == 0) {}
          for (i = 1;; i = 0)
          {
            if (i != 0)
            {
              ((RadarStateView)localObject2).buM();
              bool = true;
            }
            localObject3 = RadarStateView.nmO;
            y.d(RadarStateView.access$getTAG$cp(), " delay : " + bool);
            ((RadarStateView)localObject2).nlu = paramView;
            if (((RadarStateView)localObject2).nlu == c.e.nkE) {
              break;
            }
            if (bool) {
              break label1232;
            }
            ((RadarStateView)localObject2).nmL.sendEmptyMessage(0);
            break;
          }
          label1232:
          ((RadarStateView)localObject2).nmL.sendEmptyMessageDelayed(0, RadarStateView.buN() + 20);
        }
      }
      localObject2 = RadarViewController.c(this.nnP).nle;
      localObject3 = g.nnt;
      if (!bk.bl((String)((Map)localObject2).get(g.c(localbio))))
      {
        paramView = ((RadarViewController.c.a)localObject4).noa;
        paramView.nmK = false;
        paramView.setVisibility(8);
        paramView = ((RadarViewController.c.a)localObject4).nob;
        paramView.nmE = true;
        paramView.buK();
        paramView = RadarViewController.c(this.nnP);
        if (localbio != null)
        {
          localObject2 = g.nnt;
          localObject2 = g.b(localbio);
          localObject2 = (e.a)paramView.nli.get(localObject2);
          paramView = (View)localObject2;
          if (localObject2 == null) {
            paramView = e.a.nlr;
          }
          localObject2 = paramView;
          if (paramView != null) {}
        }
        else
        {
          localObject2 = e.a.nlr;
        }
        if (localObject2 != e.a.nlr) {
          ((RadarViewController.c.a)localObject4).noc.setBackgroundDrawable(null);
        }
        paramView = ((RadarViewController.c.a)localObject4).nob;
        a.d.b.g.k(localObject2, "status");
        if ((a.d.b.g.e(paramView.nmF, localObject2) ^ true))
        {
          paramView.nmF = ((e.a)localObject2);
          localObject2 = paramView.nmF;
          switch (e.nmH[localObject2.ordinal()])
          {
          }
        }
        for (;;)
        {
          if (paramInt == 0) {
            this.nnV = this.nnT.size();
          }
          paramView = this.nnT;
          localObject2 = g.nnt;
          if (paramView.remove(g.c(localbio)) == null) {
            break;
          }
          this.nnU.f(this.nnV - this.nnT.size(), (View)localObject1);
          return localObject1;
          if (paramView.nmE)
          {
            paramView.buK();
            paramView.nmB = true;
            paramView.startAnimation(paramView.getSlideOutAnim());
            continue;
            if (paramView.nmE)
            {
              paramView.buK();
              paramView.startAnimation(paramView.getSlideInAnim());
            }
          }
        }
      }
      return M(paramView, paramInt);
      label1593:
      return M(paramView, paramInt);
      label1600:
      localObject1 = paramView;
    }
  }
  
  public final void ag(LinkedList<bio> paramLinkedList)
  {
    if (((paramLinkedList != null) && (paramLinkedList.size() == 0)) || (paramLinkedList == null)) {}
    label167:
    label202:
    label242:
    do
    {
      return;
      localObject1 = (c)this;
      int j = ((Object[])((c)localObject1).nnR).length;
      i = 0;
      Object localObject2;
      Object localObject3;
      Object localObject4;
      while (i < j)
      {
        localObject2 = paramLinkedList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (bio)((Iterator)localObject2).next();
          localObject4 = g.nnt;
          localObject4 = g.c((bio)localObject3);
          g localg = g.nnt;
          if (a.d.b.g.e(localObject4, g.c(localObject1.nnR[i]))) {
            paramLinkedList.remove(localObject3);
          }
        }
        i += 1;
      }
      localObject1 = paramLinkedList.iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (bio)((Iterator)localObject1).next();
        int k = Math.abs((int)System.currentTimeMillis() % 6);
        int m = this.nnR.length;
        i = 0;
        int n;
        if (i < m)
        {
          n = (i + k) % 12;
          if ((n != 4) && (n != 7)) {
            break label202;
          }
        }
        for (;;)
        {
          i += 1;
          break label167;
          break;
          localObject3 = this.nnR[n];
          if (localObject3 != null)
          {
            localObject4 = (CharSequence)((bio)localObject3).hPY;
            if ((localObject4 != null) && (!a.h.e.X((CharSequence)localObject4))) {
              break label332;
            }
            j = 1;
            if (j == 0) {
              break label344;
            }
            localObject3 = (CharSequence)((bio)localObject3).sUr;
            if ((localObject3 != null) && (!a.h.e.X((CharSequence)localObject3))) {
              break label338;
            }
            j = 1;
            if (j == 0) {
              break label344;
            }
          }
          for (j = 1;; j = 0)
          {
            if (j == 0) {
              break label348;
            }
            this.nnR[n] = localObject2;
            localObject3 = this.nnT;
            localObject4 = g.nnt;
            a.d.b.g.j(localObject2, "member");
            ((HashMap)localObject3).put(g.b((bio)localObject2), Integer.valueOf(0));
            break;
            j = 0;
            break label242;
            j = 0;
            break label273;
          }
        }
      }
    } while (paramLinkedList.size() <= 0);
    label273:
    label332:
    label338:
    label344:
    label348:
    buD();
    Object localObject1 = d.nkZ;
    int i = paramLinkedList.size();
    if ((d.bRQ == 0) && (i > 0))
    {
      float f = (float)(d.bux() - d.nkV) * 1.0F / 1000.0F;
      y.d(d.TAG, "FoundFirstFriendTimeSpent %s", new Object[] { Float.valueOf(f) });
      paramLinkedList = h.nFQ;
      localObject1 = o.xoy;
      localObject1 = String.format("%s", Arrays.copyOf(new Object[] { Float.valueOf(f) }, 1));
      a.d.b.g.j(localObject1, "java.lang.String.format(format, *args)");
      paramLinkedList.aC(10682, (String)localObject1);
    }
    d.bRQ += i;
    d.nkW = i + d.nkW;
  }
  
  public final void d(bio parambio)
  {
    if (parambio != null)
    {
      localObject = (CharSequence)parambio.hPY;
      if ((localObject != null) && (!a.h.e.X((CharSequence)localObject))) {
        break label61;
      }
      i = 1;
      if (i == 0) {
        break label71;
      }
      localObject = (CharSequence)parambio.sUr;
      if ((localObject != null) && (!a.h.e.X((CharSequence)localObject))) {
        break label66;
      }
      i = 1;
      label50:
      if (i == 0) {
        break label71;
      }
    }
    label61:
    label66:
    label71:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label76;
      }
      return;
      i = 0;
      break;
      i = 0;
      break label50;
    }
    label76:
    Object localObject = g.nnt;
    if (parambio == null) {
      a.d.b.g.cUk();
    }
    localObject = g.b(parambio);
    parambio = (bio)localObject;
    if (RadarViewController.c(this.nnP).nle.containsKey(localObject))
    {
      parambio = RadarViewController.c(this.nnP).nle.get(localObject);
      if (parambio == null) {
        throw new k("null cannot be cast to non-null type kotlin.String");
      }
      parambio = (String)parambio;
    }
    this.nnS.put(parambio, parambio);
  }
  
  public final int getCount()
  {
    if (this.nnX) {
      return 0;
    }
    return ((Object[])this.nnR).length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarViewController.c
 * JD-Core Version:    0.7.0.1
 */