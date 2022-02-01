package com.tencent.mm.plugin.multitalk.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aa;
import com.tencent.mm.plugin.multitalk.a.e;
import com.tencent.mm.plugin.multitalk.a.h;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.o;
import com.tencent.mm.plugin.multitalk.model.u;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.bf;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.List;

public final class g
  implements View.OnClickListener
{
  RecyclerView LuA;
  View LuB;
  private ImageButton LuC;
  private ImageButton LuD;
  private boolean LuE;
  private int LuF;
  private MultiTalkMainUI Luv;
  private View Luw;
  private View Lux;
  private TextView Luy;
  private ImageView Luz;
  TextView vCy;
  
  public g(MultiTalkMainUI paramMultiTalkMainUI)
  {
    AppMethodBeat.i(114722);
    this.LuE = false;
    this.LuF = 0;
    this.Luv = paramMultiTalkMainUI;
    this.Luw = paramMultiTalkMainUI.findViewById(a.e.invite_layout);
    this.LuB = paramMultiTalkMainUI.findViewById(a.e.small_avatar_introduce_layout);
    Object localObject1 = paramMultiTalkMainUI.findViewById(a.e.invite_main_layout);
    Object localObject2 = (RelativeLayout.LayoutParams)((View)localObject1).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject2).topMargin = ((int)(com.tencent.mm.cd.a.mt(paramMultiTalkMainUI) * 15.9D / 100.0D));
    ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    this.Luy = ((TextView)paramMultiTalkMainUI.findViewById(a.e.invite_main_nickname_tv));
    this.Luz = ((ImageView)paramMultiTalkMainUI.findViewById(a.e.invite_main_avatar_iv));
    this.LuA = ((RecyclerView)paramMultiTalkMainUI.findViewById(a.e.small_avatar_iv_container));
    this.Lux = paramMultiTalkMainUI.findViewById(a.e.multitalk_mini_action);
    this.LuF = (com.tencent.mm.cd.a.mt(paramMultiTalkMainUI) - com.tencent.mm.cd.a.fromDPToPix(paramMultiTalkMainUI, 412) - (int)(com.tencent.mm.cd.a.mt(paramMultiTalkMainUI) * 21.899999999999999D / 100.0D));
    localObject1 = new LinearLayoutManager();
    localObject2 = (RelativeLayout.LayoutParams)this.LuB.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject2).bottomMargin = ((int)(com.tencent.mm.cd.a.mt(paramMultiTalkMainUI) * 21.899999999999999D / 100.0D));
    this.LuB.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject2 = paramMultiTalkMainUI.findViewById(a.e.invite_control_layout);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject2).getLayoutParams();
    localLayoutParams.bottomMargin = ((int)(com.tencent.mm.cd.a.mt(paramMultiTalkMainUI) * 3.6D / 100.0D));
    ((View)localObject2).setLayoutParams(localLayoutParams);
    this.LuA.setLayoutManager((RecyclerView.LayoutManager)localObject1);
    this.LuA.setAdapter(new s(paramMultiTalkMainUI));
    this.LuA.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(285473);
        g localg = g.this;
        Object localObject = (ViewGroup.MarginLayoutParams)localg.vCy.getLayoutParams();
        int i = ((ViewGroup.MarginLayoutParams)localObject).bottomMargin;
        float f = ((ViewGroup.MarginLayoutParams)localObject).topMargin + (i + localg.vCy.getHeight());
        i = (int)(localg.LuB.getHeight() - f);
        localObject = (RelativeLayout.LayoutParams)localg.LuA.getLayoutParams();
        int j = f.Luc * 3 + f.LtU * 2;
        if (i >= j) {}
        for (((RelativeLayout.LayoutParams)localObject).height = j;; ((RelativeLayout.LayoutParams)localObject).height = i)
        {
          localg.LuA.setLayoutParams((ViewGroup.LayoutParams)localObject);
          AppMethodBeat.o(285473);
          return;
        }
      }
    });
    this.LuA.setOnScrollListener(new RecyclerView.l()
    {
      public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(285402);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousRecyclerView);
        localb.sc(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkInvitingUILogic$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
        super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
        if ((paramAnonymousInt == 0) && (g.a(g.this))) {
          o.yW(false);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkInvitingUILogic$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(285402);
      }
      
      public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(285408);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousRecyclerView);
        localb.sc(paramAnonymousInt1);
        localb.sc(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkInvitingUILogic$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
        super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        paramAnonymousRecyclerView = g.this;
        if (paramAnonymousInt2 != 0) {}
        for (boolean bool = true;; bool = false)
        {
          g.a(paramAnonymousRecyclerView, bool);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkInvitingUILogic$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
          AppMethodBeat.o(285408);
          return;
        }
      }
    });
    this.vCy = ((TextView)paramMultiTalkMainUI.findViewById(a.e.introduce_tv));
    this.LuC = ((ImageButton)paramMultiTalkMainUI.findViewById(a.e.invite_pickup_btn));
    this.LuD = ((ImageButton)paramMultiTalkMainUI.findViewById(a.e.invite_hangup_btn));
    this.LuC.setOnClickListener(this);
    this.LuD.setOnClickListener(this);
    AppMethodBeat.o(114722);
  }
  
  private String jb(List<String> paramList)
  {
    AppMethodBeat.i(285511);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.Luv.getContext().getString(a.h.multitalk_members_join));
    int i = 0;
    while (i < paramList.size())
    {
      if (!((s)this.LuA.getAdapter()).aNI((String)paramList.get(i))) {
        localStringBuffer.append(((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName((String)paramList.get(i)) + ",");
      }
      i += 1;
    }
    paramList = localStringBuffer.toString();
    AppMethodBeat.o(285511);
    return paramList;
  }
  
  public final void ghs()
  {
    AppMethodBeat.i(114724);
    this.Luw.setVisibility(8);
    this.Luv.cXB().removeView(this.Luw);
    AppMethodBeat.o(114724);
  }
  
  public final void n(MultiTalkGroup paramMultiTalkGroup)
  {
    int j = 0;
    AppMethodBeat.i(114723);
    this.Luw.setVisibility(0);
    this.Lux.setVisibility(0);
    String str = u.ggC();
    ArrayList localArrayList = new ArrayList();
    int i;
    if (!Util.isNullOrNil(str))
    {
      i = 0;
      while (i < paramMultiTalkGroup.ahhh.size())
      {
        if (!((MultiTalkGroupMember)paramMultiTalkGroup.ahhh.get(i)).ahhi.equals(str)) {
          localArrayList.add(((MultiTalkGroupMember)paramMultiTalkGroup.ahhh.get(i)).ahhi);
        }
        i += 1;
      }
      this.Luy.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this.Luv, aa.getDisplayName(str)));
      this.Luz.setContentDescription(com.tencent.mm.pluginsdk.ui.span.p.b(this.Luv, aa.getDisplayName(str)));
      a.b.a(this.Luz, str, 0.1F, true);
    }
    if ((this.Luv.cXB() != null) && (this.Luv.cXB().findViewById(a.e.rootview) != null))
    {
      paramMultiTalkGroup = new RelativeLayout.LayoutParams(-1, -1);
      paramMultiTalkGroup.bottomMargin = bf.bk(this.Luv);
      this.Luv.cXB().findViewById(a.e.rootview).setLayoutParams(paramMultiTalkGroup);
    }
    if (localArrayList.size() > 0)
    {
      this.vCy.setVisibility(0);
      this.vCy.setText(a.h.multitalk_member_wording);
      this.LuB.setTag(a.e.tag_multi_talk_name_list, jb(localArrayList));
      this.LuA.getLayoutParams();
      this.LuA.setVisibility(0);
      this.LuA.removeAllViews();
      i = j;
      while (i < localArrayList.size())
      {
        if (!((s)this.LuA.getAdapter()).aNI((String)localArrayList.get(i))) {
          ((s)this.LuA.getAdapter()).gi((String)localArrayList.get(i), i);
        }
        i += 1;
      }
      this.LuA.getAdapter().bZE.notifyChanged();
      AppMethodBeat.o(114723);
      return;
    }
    this.vCy.setVisibility(8);
    this.LuA.setVisibility(8);
    AppMethodBeat.o(114723);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(114725);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkInvitingUILogic", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if (paramView.getId() == a.e.invite_hangup_btn)
    {
      ac.ggS().j(true, false, false);
      paramView = paramView.getContext();
      if ((paramView != null) && (!com.tencent.mm.compatible.e.b.dh(paramView))) {
        com.tencent.threadpool.h.ahAA.o(new g.3(this), 2000L);
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkInvitingUILogic", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(114725);
      return;
      if (paramView.getId() == a.e.invite_pickup_btn) {
        ac.ggS().gga();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.g
 * JD-Core Version:    0.7.0.1
 */