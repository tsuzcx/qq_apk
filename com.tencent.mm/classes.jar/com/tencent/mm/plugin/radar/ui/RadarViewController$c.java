package com.tencent.mm.plugin.radar.ui;

import a.f.b.y;
import a.l;
import a.l.m;
import a.v;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.radar.b.c;
import com.tencent.mm.plugin.radar.b.c.e;
import com.tencent.mm.plugin.radar.b.d;
import com.tencent.mm.plugin.radar.b.e;
import com.tencent.mm.plugin.radar.b.e.a;
import com.tencent.mm.plugin.radar.b.e.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.brg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/radar/ui/RadarViewController$RadarSearchAdapter;", "Lcom/tencent/mm/plugin/radar/ui/GridDataAdapter;", "radarGridView", "Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/radar/ui/RadarViewController;Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;Landroid/content/Context;)V", "animSize", "", "animator", "Lcom/tencent/mm/plugin/radar/ui/RadarViewController$AvatarAnimator;", "Lcom/tencent/mm/plugin/radar/ui/RadarViewController;", "count", "getCount", "()I", "hideView", "", "memberReqMap", "Ljava/util/HashMap;", "", "getMemberReqMap", "()Ljava/util/HashMap;", "setMemberReqMap", "(Ljava/util/HashMap;)V", "needAnim", "getNeedAnim", "setNeedAnim", "radarSearchMember", "", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "getRadarSearchMember", "()[Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "setRadarSearchMember", "([Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;)V", "[Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "newMembers", "Ljava/util/LinkedList;", "radarSearchMemberList", "getRadarSearchMemberList", "()Ljava/util/LinkedList;", "setRadarSearchMemberList", "(Ljava/util/LinkedList;)V", "viewTable", "Landroid/view/View;", "getViewTable", "setViewTable", "addMemberReq", "", "member", "clearAll", "clearData", "doInit", "getChanged", "position", "getItem", "", "getView", "convertView", "isMemReqContainsSearchMem", "sm", "makePlaceHolderView", "makeView", "radarStatus", "Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarStatus;", "removeMemberReq", "setRadarChatRoomMemberList", "radarChatMember", "Lcom/tencent/mm/protocal/protobuf/RadarChatRoomMember;", "ViewHolder", "plugin-radar_release"})
public final class RadarViewController$c
  extends a
{
  private final Context context;
  brg[] pTf;
  HashMap<String, String> pTg;
  HashMap<String, Integer> pTh;
  private final RadarViewController.a pTi;
  private int pTj;
  HashMap<String, View> pTk;
  private boolean pTl;
  
  public RadarViewController$c(RadarSpecialGridView paramRadarSpecialGridView, Context paramContext)
  {
    super(paramContext, localObject);
    AppMethodBeat.i(103092);
    this.context = localObject;
    this.pTf = new brg[12];
    this.pTg = new HashMap();
    this.pTh = new HashMap();
    this.pTk = new HashMap();
    this.pTi = new RadarViewController.a(paramRadarSpecialGridView);
    AppMethodBeat.o(103092);
  }
  
  private final View ad(View paramView, int paramInt)
  {
    AppMethodBeat.i(103090);
    View localView = paramView;
    if (paramView == null)
    {
      localView = View.inflate(this.context, 2130970497, null);
      if (localView == null) {
        a.f.b.j.ebi();
      }
      localView.setTag(RadarViewController.a(this.pTd), Integer.valueOf(this.pTi.cff()));
      localView.setTag(RadarViewController.b(this.pTd), this.pTi.getInAnimation());
    }
    paramView = localView.findViewById(2131826989);
    a.f.b.j.p(paramView, "anotherConvertView.findV…ar_result_item_avatar_iv)");
    paramView.setVisibility(8);
    paramView = localView.findViewById(2131826990);
    a.f.b.j.p(paramView, "anotherConvertView.findV…sult_item_avatar_mask_iv)");
    paramView.setVisibility(8);
    paramView = localView.findViewById(2131826992);
    a.f.b.j.p(paramView, "anotherConvertView.findV…_result_item_username_tv)");
    paramView.setVisibility(4);
    paramView = localView.findViewById(2131826988);
    a.f.b.j.p(paramView, "anotherConvertView.findV….radar_member_state_view)");
    paramView.setVisibility(4);
    paramView = localView.findViewById(2131826991);
    a.f.b.j.p(paramView, "anotherConvertView.findV…member_state_choose_view)");
    paramView.setVisibility(4);
    if ((paramInt == 7) || (paramInt % 3 == 1))
    {
      paramView = localView.findViewById(2131826993);
      a.f.b.j.p(paramView, "anotherConvertView.findV…d<View>(R.id.bottom_stub)");
      paramView.setVisibility(0);
      paramView = localView.findViewById(2131826987);
      a.f.b.j.p(paramView, "anotherConvertView.findV…ById<View>(R.id.top_stub)");
      paramView.setVisibility(8);
    }
    for (;;)
    {
      AppMethodBeat.o(103090);
      return localView;
      paramView = localView.findViewById(2131826987);
      a.f.b.j.p(paramView, "anotherConvertView.findV…ById<View>(R.id.top_stub)");
      paramView.setVisibility(0);
      paramView = localView.findViewById(2131826993);
      a.f.b.j.p(paramView, "anotherConvertView.findV…d<View>(R.id.bottom_stub)");
      paramView.setVisibility(8);
    }
  }
  
  public final View ac(View paramView, int paramInt)
  {
    AppMethodBeat.i(103088);
    ab.d(RadarViewController.access$getTAG$cp(), "getview RadarStatus%s", new Object[] { this.pTd.getRadarStatus() });
    brg localbrg = (brg)this.pTf[paramInt];
    Object localObject1;
    int i;
    label97:
    label103:
    String str;
    Object localObject2;
    if (localbrg != null)
    {
      localObject1 = (CharSequence)localbrg.jJA;
      if ((localObject1 == null) || (m.ap((CharSequence)localObject1)))
      {
        i = 1;
        if (i == 0) {
          break label235;
        }
        localObject1 = (CharSequence)localbrg.wSo;
        if ((localObject1 != null) && (!m.ap((CharSequence)localObject1))) {
          break label230;
        }
        i = 1;
        if (i == 0) {
          break label235;
        }
        i = 1;
        if (i != 0) {
          break label1619;
        }
        localObject1 = g.pSH;
        str = g.b(localbrg);
        localObject2 = this.pTd.getRadarStatus();
        if (paramView != null) {
          break label1629;
        }
        localObject1 = View.inflate(this.context, 2130970497, null);
        if (localObject1 == null) {
          a.f.b.j.ebi();
        }
        ((View)localObject1).setTag(RadarViewController.a(this.pTd), Integer.valueOf(this.pTi.cff()));
        ((View)localObject1).setTag(RadarViewController.b(this.pTd), this.pTi.getInAnimation());
      }
    }
    for (;;)
    {
      Object localObject3 = ((View)localObject1).findViewById(2131826989);
      if (localObject3 == null)
      {
        paramView = new v("null cannot be cast to non-null type android.widget.ImageView");
        AppMethodBeat.o(103088);
        throw paramView;
        i = 0;
        break;
        label230:
        i = 0;
        break label97;
        label235:
        i = 0;
        break label103;
      }
      localObject3 = (ImageView)localObject3;
      Object localObject4 = ((View)localObject1).findViewById(2131826988);
      if (localObject4 == null)
      {
        paramView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.radar.ui.RadarStateView");
        AppMethodBeat.o(103088);
        throw paramView;
      }
      localObject4 = (RadarStateView)localObject4;
      Object localObject5 = ((View)localObject1).findViewById(2131826992);
      if (localObject5 == null)
      {
        paramView = new v("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(103088);
        throw paramView;
      }
      localObject5 = (TextView)localObject5;
      Object localObject6 = ((View)localObject1).findViewById(2131826990);
      if (localObject6 == null)
      {
        paramView = new v("null cannot be cast to non-null type android.widget.ImageView");
        AppMethodBeat.o(103088);
        throw paramView;
      }
      localObject6 = (ImageView)localObject6;
      Object localObject7 = ((View)localObject1).findViewById(2131826991);
      if (localObject7 == null)
      {
        paramView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.radar.ui.RadarStateChooseView");
        AppMethodBeat.o(103088);
        throw paramView;
      }
      localObject7 = (RadarStateChooseView)localObject7;
      ((ImageView)localObject3).setVisibility(0);
      ((RadarStateView)localObject4).setVisibility(0);
      ((TextView)localObject5).setVisibility(0);
      ((ImageView)localObject6).setVisibility(0);
      if ((localObject2 == e.e.pQK) || (localObject2 == e.e.pQL))
      {
        ((RadarStateView)localObject4).setVisibility(0);
        ((RadarStateChooseView)localObject7).setVisibility(8);
        ((View)localObject1).setTag(new RadarViewController.c.a(this, (TextView)localObject5, (ImageView)localObject3, (RadarStateView)localObject4, (RadarStateChooseView)localObject7, (ImageView)localObject6));
        if ((paramInt != 7) && (paramInt % 3 != 1)) {
          break label605;
        }
        localObject2 = ((View)localObject1).findViewById(2131826993);
        a.f.b.j.p(localObject2, "anotherConvertView.findV…d<View>(R.id.bottom_stub)");
        ((View)localObject2).setVisibility(0);
        localObject2 = ((View)localObject1).findViewById(2131826987);
        a.f.b.j.p(localObject2, "anotherConvertView.findV…ById<View>(R.id.top_stub)");
        ((View)localObject2).setVisibility(8);
      }
      for (;;)
      {
        if ((paramView == null) || (localObject1 != paramView)) {
          this.pTk.put(str, localObject1);
        }
        localObject2 = ((View)localObject1).getTag();
        if (localObject2 != null) {
          break label653;
        }
        paramView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.radar.ui.RadarViewController.RadarSearchAdapter.ViewHolder");
        AppMethodBeat.o(103088);
        throw paramView;
        ((RadarStateView)localObject4).setVisibility(8);
        ((RadarStateChooseView)localObject7).setVisibility(0);
        break;
        label605:
        localObject2 = ((View)localObject1).findViewById(2131826987);
        a.f.b.j.p(localObject2, "anotherConvertView.findV…ById<View>(R.id.top_stub)");
        ((View)localObject2).setVisibility(0);
        localObject2 = ((View)localObject1).findViewById(2131826993);
        a.f.b.j.p(localObject2, "anotherConvertView.findV…d<View>(R.id.bottom_stub)");
        ((View)localObject2).setVisibility(8);
      }
      label653:
      localObject4 = (RadarViewController.c.a)localObject2;
      ((RadarViewController.c.a)localObject4).pTm.setText((CharSequence)com.tencent.mm.pluginsdk.ui.d.j.b(this.pTd.getContext(), (CharSequence)localbrg.jKG, ((RadarViewController.c.a)localObject4).pTm.getTextSize()));
      localObject2 = b.a.pRb;
      b.a.c(((RadarViewController.c.a)localObject4).pTn, str);
      localObject2 = ((View)localObject1).findViewById(2131826984);
      a.f.b.j.p(localObject2, "view.findViewById(R.id.radar_avatar_container)");
      ((View)localObject2).setTag(new RadarViewController.d(this.pTd, localbrg));
      boolean bool;
      if ((this.pTd.getRadarStatus() == e.e.pQK) || (this.pTd.getRadarStatus() == e.e.pQL))
      {
        ((RadarViewController.c.a)localObject4).pTq.setBackgroundResource(2130840229);
        paramView = ((RadarViewController.c.a)localObject4).pTo;
        paramView.pRY = true;
        paramView.ceW();
        paramView = ((RadarViewController.c.a)localObject4).pTp;
        paramView.pRS = false;
        paramView.setVisibility(8);
        localObject2 = e.a(RadarViewController.c(this.pTd), localbrg);
        paramView = (View)localObject2;
        if (localObject2 == null)
        {
          paramView = RadarViewController.e(this.pTd).XH(str);
          localObject2 = RadarViewController.c(this.pTd);
          a.f.b.j.q(localbrg, "member");
          a.f.b.j.q(paramView, "state");
          localObject3 = localbrg.jJA;
          a.f.b.j.p(localObject3, "member.UserName");
          ((e)localObject2).b((String)localObject3, paramView);
          localObject3 = localbrg.wSo;
          a.f.b.j.p(localObject3, "member.EncodeUserName");
          ((e)localObject2).b((String)localObject3, paramView);
        }
        localObject3 = RadarViewController.c(this.pTd).a(localbrg, true);
        localObject5 = ((RadarViewController.c.a)localObject4).pTo;
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = c.e.pPU;
        }
        a.f.b.j.q(localObject2, "state");
        ((RadarStateView)localObject5).init();
        ((RadarStateView)localObject5).pRZ.removeMessages(0);
        ((RadarStateView)localObject5).clearAnimation();
        ((RadarStateView)localObject5).pQJ = ((c.e)localObject2);
        ((RadarStateView)localObject5).bTs = false;
        ((RadarStateView)localObject5).ceW();
        localObject2 = ((RadarViewController.c.a)localObject4).pTo;
        a.f.b.j.q(paramView, "state");
        ((RadarStateView)localObject2).init();
        ab.d(RadarStateView.TAG, " turnToState : ".concat(String.valueOf(paramView)));
        bool = false;
        if (((RadarStateView)localObject2).pQJ == paramView)
        {
          ((RadarStateView)localObject2).ceW();
          paramView = RadarViewController.c(this.pTd);
          a.f.b.j.q(localbrg, "member");
          localObject2 = localbrg.jJA;
          a.f.b.j.p(localObject2, "member.UserName");
          paramView.a((String)localObject2, null);
          localObject2 = localbrg.wSo;
          a.f.b.j.p(localObject2, "member.EncodeUserName");
          paramView.a((String)localObject2, null);
          if (paramInt == 0) {
            this.pTj = this.pTh.size();
          }
          paramView = (View)localObject1;
          if (this.pTh.remove(str) != null)
          {
            this.pTi.g(this.pTj - this.pTh.size(), (View)localObject1);
            paramView = (View)localObject1;
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(103088);
        return paramView;
        if (((RadarStateView)localObject2).getVisibility() == 0) {}
        for (i = 1;; i = 0)
        {
          if (i != 0)
          {
            ((RadarStateView)localObject2).ceY();
            bool = true;
          }
          ab.d(RadarStateView.TAG, " delay : ".concat(String.valueOf(bool)));
          ((RadarStateView)localObject2).pQJ = paramView;
          if (((RadarStateView)localObject2).pQJ == c.e.pPU) {
            break;
          }
          if (bool) {
            break label1255;
          }
          ((RadarStateView)localObject2).pRZ.sendEmptyMessage(0);
          break;
        }
        label1255:
        ((RadarStateView)localObject2).pRZ.sendEmptyMessageDelayed(0, RadarStateView.pSb + 20);
        break;
        localObject2 = RadarViewController.c(this.pTd).pQt;
        localObject3 = g.pSH;
        if (!bo.isNullOrNil((String)((Map)localObject2).get(g.c(localbrg))))
        {
          paramView = ((RadarViewController.c.a)localObject4).pTo;
          paramView.pRY = false;
          paramView.setVisibility(8);
          paramView = ((RadarViewController.c.a)localObject4).pTp;
          paramView.pRS = true;
          paramView.ceW();
          paramView = RadarViewController.c(this.pTd);
          if (localbrg != null)
          {
            localObject2 = g.pSH;
            localObject2 = g.b(localbrg);
            localObject2 = (e.a)paramView.pQx.get(localObject2);
            paramView = (View)localObject2;
            if (localObject2 == null) {
              paramView = e.a.pQG;
            }
            localObject2 = paramView;
            if (paramView != null) {}
          }
          else
          {
            localObject2 = e.a.pQG;
          }
          if (localObject2 != e.a.pQG) {
            ((RadarViewController.c.a)localObject4).pTq.setBackgroundDrawable(null);
          }
          paramView = ((RadarViewController.c.a)localObject4).pTp;
          a.f.b.j.q(localObject2, "status");
          if (paramView.pRT != localObject2)
          {
            paramView.pRT = ((e.a)localObject2);
            localObject2 = paramView.pRT;
            switch (e.pRV[localObject2.ordinal()])
            {
            }
          }
          for (;;)
          {
            if (paramInt == 0) {
              this.pTj = this.pTh.size();
            }
            localObject2 = this.pTh;
            paramView = g.pSH;
            paramView = (View)localObject1;
            if (((HashMap)localObject2).remove(g.c(localbrg)) == null) {
              break;
            }
            this.pTi.g(this.pTj - this.pTh.size(), (View)localObject1);
            paramView = (View)localObject1;
            break;
            if (paramView.pRS)
            {
              paramView.ceW();
              paramView.bTs = true;
              paramView.startAnimation(paramView.getSlideOutAnim());
              continue;
              if (paramView.pRS)
              {
                paramView.ceW();
                paramView.startAnimation(paramView.getSlideInAnim());
              }
            }
          }
        }
        paramView = ad(paramView, paramInt);
        continue;
        label1619:
        paramView = ad(paramView, paramInt);
      }
      label1629:
      localObject1 = paramView;
    }
  }
  
  public final void ap(LinkedList<brg> paramLinkedList)
  {
    AppMethodBeat.i(103087);
    if (((paramLinkedList != null) && (paramLinkedList.size() == 0)) || (paramLinkedList == null))
    {
      AppMethodBeat.o(103087);
      return;
    }
    Object localObject1 = (c)this;
    int j = ((c)localObject1).pTf.length;
    int i = 0;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    while (i < j)
    {
      localObject2 = paramLinkedList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (brg)((Iterator)localObject2).next();
        localObject4 = g.pSH;
        localObject4 = g.c((brg)localObject3);
        g localg = g.pSH;
        if (a.f.b.j.e(localObject4, g.c(localObject1.pTf[i]))) {
          paramLinkedList.remove(localObject3);
        }
      }
      i += 1;
    }
    localObject1 = paramLinkedList.iterator();
    label282:
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (brg)((Iterator)localObject1).next();
      int k = Math.abs((int)System.currentTimeMillis() % 6);
      int m = this.pTf.length;
      i = 0;
      label176:
      int n;
      if (i < m)
      {
        n = (i + k) % 12;
        if ((n != 4) && (n != 7)) {
          break label211;
        }
      }
      label211:
      label341:
      label347:
      label353:
      label357:
      for (;;)
      {
        i += 1;
        break label176;
        break;
        localObject3 = this.pTf[n];
        if (localObject3 != null)
        {
          localObject4 = (CharSequence)((brg)localObject3).jJA;
          if ((localObject4 != null) && (!m.ap((CharSequence)localObject4))) {
            break label341;
          }
          j = 1;
          label251:
          if (j == 0) {
            break label353;
          }
          localObject3 = (CharSequence)((brg)localObject3).wSo;
          if ((localObject3 != null) && (!m.ap((CharSequence)localObject3))) {
            break label347;
          }
          j = 1;
          if (j == 0) {
            break label353;
          }
        }
        for (j = 1;; j = 0)
        {
          if (j == 0) {
            break label357;
          }
          this.pTf[n] = localObject2;
          localObject3 = this.pTh;
          localObject4 = g.pSH;
          a.f.b.j.p(localObject2, "member");
          ((HashMap)localObject3).put(g.b((brg)localObject2), Integer.valueOf(0));
          break;
          j = 0;
          break label251;
          j = 0;
          break label282;
        }
      }
    }
    if (paramLinkedList.size() > 0)
    {
      aPD();
      localObject1 = d.pQo;
      i = paramLinkedList.size();
      if ((d.czr == 0) && (i > 0))
      {
        float f = (float)(d.ceL() - d.pQk) * 1.0F / 1000.0F;
        ab.d(d.TAG, "FoundFirstFriendTimeSpent %s", new Object[] { Float.valueOf(f) });
        paramLinkedList = h.qsU;
        localObject1 = y.BNt;
        localObject1 = String.format("%s", Arrays.copyOf(new Object[] { Float.valueOf(f) }, 1));
        a.f.b.j.p(localObject1, "java.lang.String.format(format, *args)");
        paramLinkedList.kvStat(10682, (String)localObject1);
      }
      d.czr += i;
      d.pQl = i + d.pQl;
    }
    AppMethodBeat.o(103087);
  }
  
  public final void clearAll()
  {
    AppMethodBeat.i(103089);
    this.pTh.clear();
    this.pTk.clear();
    Iterator localIterator = this.pTk.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (View)this.pTk.get(localObject);
      if (localObject != null)
      {
        RadarViewController.a locala = this.pTi;
        a.f.b.j.p(localObject, "it");
        locala.ck((View)localObject);
      }
    }
    aPD();
    AppMethodBeat.o(103089);
  }
  
  public final void d(brg parambrg)
  {
    AppMethodBeat.i(103091);
    if (parambrg != null)
    {
      localObject = (CharSequence)parambrg.jJA;
      if ((localObject != null) && (!m.ap((CharSequence)localObject))) {
        break label73;
      }
      i = 1;
      if (i == 0) {
        break label83;
      }
      localObject = (CharSequence)parambrg.wSo;
      if ((localObject != null) && (!m.ap((CharSequence)localObject))) {
        break label78;
      }
      i = 1;
      label56:
      if (i == 0) {
        break label83;
      }
    }
    label73:
    label78:
    label83:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label88;
      }
      AppMethodBeat.o(103091);
      return;
      i = 0;
      break;
      i = 0;
      break label56;
    }
    label88:
    Object localObject = g.pSH;
    if (parambrg == null) {
      a.f.b.j.ebi();
    }
    localObject = g.b(parambrg);
    parambrg = (brg)localObject;
    if (RadarViewController.c(this.pTd).pQt.containsKey(localObject))
    {
      parambrg = RadarViewController.c(this.pTd).pQt.get(localObject);
      if (parambrg == null)
      {
        parambrg = new v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(103091);
        throw parambrg;
      }
      parambrg = (String)parambrg;
    }
    this.pTg.put(parambrg, parambrg);
    AppMethodBeat.o(103091);
  }
  
  public final int getCount()
  {
    if (this.pTl) {
      return 0;
    }
    return this.pTf.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarViewController.c
 * JD-Core Version:    0.7.0.1
 */