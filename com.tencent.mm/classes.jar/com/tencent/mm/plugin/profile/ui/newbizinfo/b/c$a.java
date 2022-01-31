package com.tencent.mm.plugin.profile.ui.newbizinfo.b;

import a.f;
import a.l.m;
import a.v;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.e;
import com.tencent.mm.protocal.protobuf.ke;
import com.tencent.mm.protocal.protobuf.kf;
import com.tencent.mm.protocal.protobuf.kg;
import com.tencent.mm.protocal.protobuf.lf;
import com.tencent.mm.protocal.protobuf.lw;
import com.tencent.mm.protocal.protobuf.uq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMCollapsibleTextView;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$BizMsgViewHolder;", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$ViewHolder;", "interpolator", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator;", "convertView", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "bizMsg", "Lcom/tencent/mm/protocal/protobuf/BizMessage;", "expandSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "position", "(Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator;Landroid/view/View;Landroid/view/ViewGroup;Lcom/tencent/mm/protocal/protobuf/BizMessage;Ljava/util/HashSet;I)V", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "view", "getView", "()Landroid/view/View;", "widget", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo;", "fillCommonSlot", "", "container", "detail", "Lcom/tencent/mm/protocal/protobuf/BizAppMsgDetailInfo;", "base", "Lcom/tencent/mm/protocal/protobuf/BizAppMsgBaseInfo;", "slotType", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotType;", "fillSingleText", "text", "Lcom/tencent/mm/protocal/protobuf/BizTextMsgInfo;", "Lcom/tencent/mm/protocal/protobuf/CommMsgBaseInfo;", "fillSlotTarget", "fillTopSlot", "getPlayId", "", "isPlaying", "", "playId", "firstNotEmpty", "", "([Ljava/lang/String;)Ljava/lang/String;", "app_release"})
final class c$a
  extends c.g
{
  Context context;
  Intent intent;
  private HashSet<Integer> pEw;
  com.tencent.mm.plugin.profile.ui.newbizinfo.b pEy;
  final View view;
  
  public c$a(c paramc, View paramView, ViewGroup paramViewGroup, lf paramlf, HashSet<Integer> paramHashSet, int paramInt)
  {
    AppMethodBeat.i(154690);
    Object localObject1 = paramc.pEx.getContext();
    a.f.b.j.p(localObject1, "interpolator.ui.context");
    this.context = ((Context)localObject1);
    this.pEy = paramc.pEy;
    localObject1 = paramc.pEx.getIntent();
    a.f.b.j.p(localObject1, "interpolator.ui.intent");
    this.intent = ((Intent)localObject1);
    this.pEw = paramHashSet;
    Object localObject2;
    int i;
    if (paramView != null)
    {
      paramHashSet = paramView.getTag();
      if (!a.f.b.j.e(paramHashSet, paramlf)) {
        break label248;
      }
      localObject2 = paramlf.wzz;
      paramHashSet = this;
      localObject1 = paramView;
      if (localObject2 == null) {
        break label235;
      }
      localObject2 = ((kg)localObject2).wxG;
      paramHashSet = this;
      localObject1 = paramView;
      if (localObject2 == null) {
        break label235;
      }
      i = 0;
      paramHashSet = ((Iterable)localObject2).iterator();
      label161:
      if (!paramHashSet.hasNext()) {
        break label223;
      }
      localObject1 = (kf)paramHashSet.next();
      a.f.b.j.p(localObject1, "detail");
      if (!a.f.b.j.e(a((kf)localObject1), c.a(paramc))) {
        break label1381;
      }
      c.a(paramc, "none");
      i = 1;
    }
    label223:
    label739:
    label1381:
    for (;;)
    {
      break label161;
      paramHashSet = null;
      break;
      if (i != 1)
      {
        localObject1 = paramView;
        paramHashSet = this;
        label235:
        paramHashSet.view = ((View)localObject1);
        AppMethodBeat.o(154690);
        return;
      }
      label248:
      paramc = LayoutInflater.from(this.context).inflate(2130969222, paramViewGroup, false);
      if (paramc == null)
      {
        paramc = new v("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(154690);
        throw paramc;
      }
      paramView = (ViewGroup)paramc;
      paramView.setTag(this);
      switch (paramlf.wzu.nqW)
      {
      }
      boolean bool;
      int j;
      do
      {
        do
        {
          localObject1 = (View)paramView;
          paramHashSet = this;
          break;
          paramHashSet = paramlf.wzv;
          a.f.b.j.p(paramHashSet, "bizMsg.Text");
          paramViewGroup = paramlf.wzu;
          a.f.b.j.p(paramViewGroup, "bizMsg.BaseInfo");
          paramc = new c.f(10, c.d.pET, paramView);
          paramInt = paramViewGroup.pIE;
          paramViewGroup = this.pEw;
          paramlf = paramHashSet.ntu;
          a.f.b.j.p(paramlf, "text.Content");
          a.f.b.j.q(paramViewGroup, "expandSet");
          a.f.b.j.q(paramlf, "text");
          paramHashSet = paramc.cdi();
          a.f.b.j.p(paramHashSet, "collapseTextLayout");
          paramlf = com.tencent.mm.pluginsdk.ui.d.j.g(paramHashSet.getContext(), (CharSequence)paramlf, (int)paramc.cdi().getTextSize());
          paramHashSet = paramc.cdi();
          if (!paramViewGroup.contains(Integer.valueOf(paramInt))) {}
          for (bool = true;; bool = false)
          {
            paramHashSet.setCollapsed(bool);
            paramHashSet = paramc.cdi();
            a.f.b.j.p(paramlf, "text");
            paramHashSet.setText((CharSequence)paramlf);
            paramc.cdi().setOnCollapse((a.f.a.a)new c.f.e(paramViewGroup, paramInt));
            paramc.cdi().setOnExpand((a.f.a.a)new c.f.f(paramViewGroup, paramInt));
            break;
          }
          j = paramlf.wzz.wxG.size();
          if (j <= 1) {
            break label1050;
          }
          paramc = c.d.pEQ;
          if (paramlf.wzz.wxF.wxf == 0) {
            break label1317;
          }
          paramViewGroup = paramlf.wzz.wxG.get(0);
          a.f.b.j.p(paramViewGroup, "bizMsg.AppMsg.DetailInfo[0]");
          paramViewGroup = (kf)paramViewGroup;
          paramHashSet = paramlf.wzz.wxF;
          a.f.b.j.p(paramHashSet, "bizMsg.AppMsg.BaseInfo");
          localObject1 = c.pEB;
          ab.v(c.access$getTAG$cp(), "fillTopSlot:" + paramViewGroup.wxi);
          localObject1 = new c.f(paramViewGroup.wqp, paramc, paramView);
          if (paramViewGroup.wqp != 8)
          {
            localObject2 = paramViewGroup.Title;
            a.f.b.j.p(localObject2, "detail.Title");
            ((c.f)localObject1).setTitle((String)localObject2);
          }
          if (paramc == c.d.pET)
          {
            paramc = (CharSequence)paramViewGroup.wxg;
            if ((paramc != null) && (!m.ap(paramc))) {
              break label1057;
            }
            i = 1;
            if (i == 0) {
              ((MMNeat7extView)((c.f)localObject1).pFu.getValue()).af((CharSequence)paramViewGroup.wxg);
            }
          }
          paramc = (CharSequence)paramViewGroup.wxx;
          if ((paramc != null) && (!m.ap(paramc))) {
            break label1063;
          }
          i = 1;
          if (i == 0)
          {
            paramc = (TextView)((c.f)localObject1).pEN.getValue();
            a.f.b.j.p(paramc, "view.showDescTv");
            paramc.setText((CharSequence)paramViewGroup.wxx);
          }
          switch (paramViewGroup.wqp)
          {
          case 6: 
          default: 
            switch (paramViewGroup.wqp)
            {
            default: 
              switch (paramViewGroup.wqp)
              {
              default: 
                paramc = new String[2];
                paramc[0] = paramViewGroup.wxk;
                paramc[1] = paramViewGroup.wxm;
                ((c.f)localObject1).setImageUrl(C(paramc));
                a((View)((c.f)localObject1).ccZ(), paramViewGroup, paramHashSet, paramInt);
              }
              break;
            }
            break;
          }
        } while (j <= 1);
        i = 1;
      } while (i >= j);
      paramc = paramlf.wzz.wxG.get(i);
      a.f.b.j.p(paramc, "bizMsg.AppMsg.DetailInfo[i]");
      paramViewGroup = (kf)paramc;
      paramHashSet = paramlf.wzz.wxF;
      a.f.b.j.p(paramHashSet, "bizMsg.AppMsg.BaseInfo");
      if (i == j - 1) {}
      for (paramc = c.d.pES;; paramc = c.d.pER)
      {
        a(paramView, paramViewGroup, paramHashSet, paramc, paramInt);
        i += 1;
        break label966;
        paramc = c.d.pET;
        break;
        i = 0;
        break label739;
        i = 0;
        break label789;
        paramc = (TextView)((c.f)localObject1).pFp.getValue();
        a.f.b.j.p(paramc, "view.videoDurationTv");
        paramc.setText((CharSequence)com.tencent.mm.af.l.kq(paramViewGroup.wxw));
        break label860;
        paramc = (TextView)((c.f)localObject1).pFq.getValue();
        a.f.b.j.p(paramc, "view.voiceDurationTv");
        paramc.setText((CharSequence)com.tencent.mm.af.l.kq(paramViewGroup.wxr));
        break label860;
        if (paramViewGroup.wxE <= 1) {
          break label860;
        }
        paramc = (TextView)((c.f)localObject1).pEM.getValue();
        a.f.b.j.p(paramc, "view.picCntTv");
        paramc.setText((CharSequence)String.valueOf(paramViewGroup.wxE));
        break label860;
        paramc = (CharSequence)paramViewGroup.wxg;
        if ((paramc == null) || (m.ap(paramc)))
        {
          i = 1;
          if (i != 0) {
            break label1258;
          }
          bool = true;
          if (bool) {
            break label1264;
          }
          ((c.f)localObject1).cdh().setPadding(0, 0, 0, ((c.e)localObject1).pEY);
        }
        for (;;)
        {
          ((c.f)localObject1).pFw = bool;
          break;
          i = 0;
          break label1213;
          label1258:
          bool = false;
          break label1221;
          label1264:
          ((c.f)localObject1).cdh().setPadding(((c.e)localObject1).pFb, ((c.e)localObject1).pFa, ((c.e)localObject1).pFb, ((c.e)localObject1).pEY);
        }
        paramc = new String[2];
        paramc[0] = paramViewGroup.wxm;
        paramc[1] = paramViewGroup.wxk;
        break label931;
        paramViewGroup = paramlf.wzz.wxG.get(0);
        a.f.b.j.p(paramViewGroup, "bizMsg.AppMsg.DetailInfo[0]");
        paramViewGroup = (kf)paramViewGroup;
        paramHashSet = paramlf.wzz.wxF;
        a.f.b.j.p(paramHashSet, "bizMsg.AppMsg.BaseInfo");
        a(paramView, paramViewGroup, paramHashSet, paramc, paramInt);
        break label957;
      }
    }
  }
  
  private static String C(String[] paramArrayOfString)
  {
    AppMethodBeat.i(154056);
    int i = 0;
    Object localObject;
    int j;
    if (i < 2)
    {
      localObject = paramArrayOfString[i];
      CharSequence localCharSequence = (CharSequence)localObject;
      if ((localCharSequence == null) || (m.ap(localCharSequence)))
      {
        j = 1;
        label38:
        if (j != 0) {
          break label73;
        }
        j = 1;
        label44:
        if (j == 0) {
          break label78;
        }
      }
    }
    for (paramArrayOfString = (String[])localObject;; paramArrayOfString = null)
    {
      localObject = paramArrayOfString;
      if (paramArrayOfString == null) {
        localObject = "";
      }
      AppMethodBeat.o(154056);
      return localObject;
      j = 0;
      break label38;
      label73:
      j = 0;
      break label44;
      label78:
      i += 1;
      break;
    }
  }
  
  private static String a(kf paramkf)
  {
    AppMethodBeat.i(154059);
    paramkf = paramkf.wxi;
    a.f.b.j.p(paramkf, "detail.ContentUrl");
    paramkf = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.GQ(paramkf);
    AppMethodBeat.o(154059);
    return paramkf;
  }
  
  private final void a(View paramView, kf paramkf, ke paramke, int paramInt)
  {
    AppMethodBeat.i(154689);
    ImageView localImageView;
    c.a.b localb;
    c.a.c localc;
    String str;
    if (paramkf.wqp == 7)
    {
      localImageView = (ImageView)paramView.findViewById(2131823049);
      if (localImageView != null)
      {
        localb = new c.a.b(localImageView);
        localc = new c.a.c(localImageView);
        str = a(paramkf);
        if (!eb(str)) {
          break label121;
        }
        localb.ate();
      }
    }
    for (;;)
    {
      localImageView.setOnClickListener((View.OnClickListener)new c.a.a(localb, str, this, paramkf));
      paramView.setOnClickListener((View.OnClickListener)new c.a.d(this, paramkf, paramke, paramView, paramInt));
      AppMethodBeat.o(154689);
      return;
      label121:
      localc.ate();
    }
  }
  
  private final void a(ViewGroup paramViewGroup, kf paramkf, ke paramke, c.d paramd, int paramInt)
  {
    AppMethodBeat.i(154688);
    c.c localc = c.pEB;
    ab.v(c.access$getTAG$cp(), "fillCommonSlot:" + paramkf.wxi);
    paramd = new c.b(paramkf.wqp, paramd, paramViewGroup);
    paramViewGroup = paramkf.Title;
    a.f.b.j.p(paramViewGroup, "detail.Title");
    paramd.setTitle(paramViewGroup);
    paramViewGroup = (CharSequence)paramkf.wxx;
    int i;
    if ((paramViewGroup == null) || (m.ap(paramViewGroup)))
    {
      i = 1;
      if (i == 0)
      {
        paramViewGroup = (TextView)paramd.pEN.getValue();
        a.f.b.j.p(paramViewGroup, "view.showDescTv");
        paramViewGroup.setText((CharSequence)paramkf.wxx);
      }
      if ((paramkf.wqp == 8) && (paramkf.wxE > 1))
      {
        paramViewGroup = (TextView)paramd.pEM.getValue();
        a.f.b.j.p(paramViewGroup, "view.picCntTv");
        paramViewGroup.setText((CharSequence)String.valueOf(paramkf.wxE));
      }
      switch (paramkf.wqp)
      {
      default: 
        paramViewGroup = new String[2];
        paramViewGroup[0] = paramkf.wxl;
        paramViewGroup[1] = paramkf.wxk;
      }
    }
    for (;;)
    {
      paramd.setImageUrl(C(paramViewGroup));
      a((View)paramd.ccZ(), paramkf, paramke, paramInt);
      AppMethodBeat.o(154688);
      return;
      i = 0;
      break;
      paramViewGroup = new String[2];
      paramViewGroup[0] = paramkf.wxk;
      paramViewGroup[1] = paramkf.wxl;
    }
  }
  
  private static boolean eb(String paramString)
  {
    AppMethodBeat.i(154058);
    e locale = com.tencent.mm.aw.a.aiz();
    if (locale != null)
    {
      if ((a.f.b.j.e(locale.fKj, paramString)) && (locale.fKh == 0) && (com.tencent.mm.aw.a.aiw()))
      {
        AppMethodBeat.o(154058);
        return true;
      }
      AppMethodBeat.o(154058);
      return false;
    }
    AppMethodBeat.o(154058);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.b.c.a
 * JD-Core Version:    0.7.0.1
 */