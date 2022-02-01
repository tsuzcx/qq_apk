package com.tencent.mm.plugin.profile.ui.tab.list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.profile.ui.tab.ContactWidgetTabBizHeaderController;
import com.tencent.mm.plugin.profile.ui.tab.data.BizProfileDataFetcher;
import com.tencent.mm.plugin.profile.ui.tab.view.BizProfileRecyclerView;
import com.tencent.mm.plugin.profile.ui.tab.view.BizProfileRecyclerView.a;
import com.tencent.mm.protocal.protobuf.px;
import com.tencent.mm.protocal.protobuf.py;
import com.tencent.mm.protocal.protobuf.qk;
import com.tencent.mm.protocal.protobuf.qm;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabVideoFragment;", "Lcom/tencent/mm/plugin/profile/ui/tab/list/BaseBizProfileFragment;", "()V", "mMsgList", "", "Lcom/tencent/mm/protocal/protobuf/BizMessage;", "mVideoAdapter", "Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabVideoAdapter;", "msgType", "", "getMsgType", "()I", "isVideoTab", "", "onAppBarLayoutExpand", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "setBizProfileResp", "bizProfileResp", "Lcom/tencent/mm/protocal/protobuf/BizProfileV2Resp;", "setDataFetcher", "dataFetcher", "Lcom/tencent/mm/plugin/profile/ui/tab/data/BizProfileDataFetcher;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class BizProfileTabVideoFragment
  extends BaseBizProfileFragment
{
  private b NfO;
  private List<px> wsq;
  
  public BizProfileTabVideoFragment()
  {
    AppMethodBeat.i(306019);
    this.wsq = ((List)new ArrayList());
    AppMethodBeat.o(306019);
  }
  
  private static final void a(BizProfileTabVideoFragment paramBizProfileTabVideoFragment, qm paramqm)
  {
    Object localObject2 = null;
    boolean bool = true;
    AppMethodBeat.i(306033);
    s.u(paramBizProfileTabVideoFragment, "this$0");
    if (paramqm == null)
    {
      AppMethodBeat.o(306033);
      return;
    }
    paramBizProfileTabVideoFragment.e(new qm());
    paramBizProfileTabVideoFragment.gCV().YVp = paramqm.YVp;
    Object localObject1 = paramBizProfileTabVideoFragment.gCV().YVp;
    int i;
    label96:
    Object localObject3;
    if (localObject1 != null)
    {
      localObject1 = ((py)localObject1).YUi;
      if (localObject1 != null) {
        if (!((Collection)localObject1).isEmpty())
        {
          i = 1;
          if (i != 1) {
            break label296;
          }
          i = 1;
          if (i == 0) {
            break label306;
          }
          paramBizProfileTabVideoFragment.wsq.clear();
          localObject1 = paramBizProfileTabVideoFragment.wsq;
          localObject3 = paramqm.YVp.YUi;
          s.s(localObject3, "bizProfileResp.VideoList.Msg");
          ((List)localObject1).addAll((Collection)localObject3);
          localObject3 = paramBizProfileTabVideoFragment.NfO;
          localObject1 = localObject3;
          if (localObject3 == null)
          {
            s.bIx("mVideoAdapter");
            localObject1 = null;
          }
          ((RecyclerView.a)localObject1).bZE.notifyChanged();
          localObject1 = paramBizProfileTabVideoFragment.gCV().YVp;
          if (localObject1 != null)
          {
            qk localqk = ((py)localObject1).YUj;
            if (localqk != null)
            {
              localObject3 = paramBizProfileTabVideoFragment.NfO;
              localObject1 = localObject3;
              if (localObject3 == null)
              {
                s.bIx("mVideoAdapter");
                localObject1 = null;
              }
              if (localqk.YVg != 0) {
                break label301;
              }
              label232:
              ((b)localObject1).AJ(bool);
            }
          }
          label238:
          localObject1 = com.tencent.mm.plugin.profile.ui.tab.a.a(64, paramqm);
          paramBizProfileTabVideoFragment = paramBizProfileTabVideoFragment.NfO;
          if (paramBizProfileTabVideoFragment != null) {
            break label338;
          }
          s.bIx("mVideoAdapter");
          paramBizProfileTabVideoFragment = localObject2;
        }
      }
    }
    label296:
    label301:
    label306:
    label338:
    for (;;)
    {
      paramqm = (qm)localObject1;
      if (localObject1 == null) {
        paramqm = "";
      }
      s.u(paramqm, "<set-?>");
      paramBizProfileTabVideoFragment.footerWording = paramqm;
      AppMethodBeat.o(306033);
      return;
      i = 0;
      break;
      i = 0;
      break label96;
      bool = false;
      break label232;
      localObject3 = paramBizProfileTabVideoFragment.NfO;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("mVideoAdapter");
        localObject1 = null;
      }
      ((b)localObject1).AJ(false);
      break label238;
    }
  }
  
  private static final void b(BizProfileTabVideoFragment paramBizProfileTabVideoFragment, qm paramqm)
  {
    Object localObject1 = null;
    AppMethodBeat.i(306045);
    s.u(paramBizProfileTabVideoFragment, "this$0");
    if (paramqm == null)
    {
      AppMethodBeat.o(306045);
      return;
    }
    int i;
    label80:
    Object localObject2;
    if (paramBizProfileTabVideoFragment.gCV().YVp == null)
    {
      paramqm.YVp = paramqm.YVp;
      py localpy = paramqm.YVp;
      if (localpy != null)
      {
        LinkedList localLinkedList = localpy.YUi;
        if (localLinkedList != null)
        {
          if (((Collection)localLinkedList).isEmpty()) {
            break label225;
          }
          i = 1;
          if (i != 0)
          {
            i = paramBizProfileTabVideoFragment.wsq.size();
            paramBizProfileTabVideoFragment.wsq.addAll((Collection)localLinkedList);
            localObject2 = paramBizProfileTabVideoFragment.NfO;
            paramqm = (qm)localObject2;
            if (localObject2 == null)
            {
              s.bIx("mVideoAdapter");
              paramqm = null;
            }
            paramqm.bA(i, localLinkedList.size());
          }
        }
        paramBizProfileTabVideoFragment = paramBizProfileTabVideoFragment.NfO;
        if (paramBizProfileTabVideoFragment != null) {
          break label230;
        }
        s.bIx("mVideoAdapter");
        paramBizProfileTabVideoFragment = localObject1;
        label157:
        paramqm = localpy.YUj;
        if ((paramqm == null) || (paramqm.YVg != 0)) {
          break label233;
        }
      }
    }
    label225:
    label230:
    label233:
    for (boolean bool = true;; bool = false)
    {
      paramBizProfileTabVideoFragment.AJ(bool);
      AppMethodBeat.o(306045);
      return;
      localObject2 = paramqm.YVp;
      if (localObject2 == null) {
        break;
      }
      localObject2 = ((py)localObject2).YUj;
      if (localObject2 == null) {
        break;
      }
      paramBizProfileTabVideoFragment.gCV().YVp.YUj = ((qk)localObject2);
      break;
      i = 0;
      break label80;
      break label157;
    }
  }
  
  public final void b(BizProfileDataFetcher paramBizProfileDataFetcher)
  {
    AppMethodBeat.i(306069);
    s.u(paramBizProfileDataFetcher, "dataFetcher");
    a(paramBizProfileDataFetcher);
    gCU().Nei.a((q)this, new BizProfileTabVideoFragment..ExternalSyntheticLambda1(this));
    gCU().Nej.a((q)this, new BizProfileTabVideoFragment..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(306069);
  }
  
  public final void dUU()
  {
    AppMethodBeat.i(306103);
    BizProfileRecyclerView localBizProfileRecyclerView = gCW();
    com.tencent.mm.hellhoundlib.b.a locala = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(localBizProfileRecyclerView, locala.aYi(), "com/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabVideoFragment", "onAppBarLayoutExpand", "()V", "Undefined", "scrollToPosition", "(I)V");
    localBizProfileRecyclerView.scrollToPosition(((Integer)locala.sb(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localBizProfileRecyclerView, "com/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabVideoFragment", "onAppBarLayoutExpand", "()V", "Undefined", "scrollToPosition", "(I)V");
    AppMethodBeat.o(306103);
  }
  
  public final boolean dUV()
  {
    return true;
  }
  
  public final void f(qm paramqm)
  {
    AppMethodBeat.i(306063);
    s.u(paramqm, "bizProfileResp");
    e(new qm());
    gCV().YVp = paramqm.YVp;
    AppMethodBeat.o(306063);
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(306081);
    s.u(paramLayoutInflater, "inflater");
    paramBundle = paramLayoutInflater.inflate(R.i.ghY, paramViewGroup, false);
    paramLayoutInflater = paramBundle.findViewById(R.h.recycler_view);
    s.s(paramLayoutInflater, "view.findViewById(R.id.recycler_view)");
    a((BizProfileRecyclerView)paramLayoutInflater);
    paramLayoutInflater = gCW();
    getActivity();
    paramLayoutInflater.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    paramLayoutInflater = getArguments();
    if (paramLayoutInflater == null) {}
    for (paramLayoutInflater = null;; paramLayoutInflater = paramLayoutInflater.getString("contact"))
    {
      s.checkNotNull(paramLayoutInflater);
      s.s(paramLayoutInflater, "arguments?.getString(\"contact\")!!");
      QZ(paramLayoutInflater);
      this.NfO = new b(this.wsq);
      paramLayoutInflater = gCW().getRecycledViewPool();
      s.s(paramLayoutInflater, "mRecyclerView.recycledViewPool");
      paramLayoutInflater.bD(0, 20);
      gCW().setRecycledViewPool(paramLayoutInflater);
      BizProfileRecyclerView localBizProfileRecyclerView = gCW();
      paramViewGroup = this.NfO;
      paramLayoutInflater = paramViewGroup;
      if (paramViewGroup == null)
      {
        s.bIx("mVideoAdapter");
        paramLayoutInflater = null;
      }
      localBizProfileRecyclerView.setAdapter((RecyclerView.a)paramLayoutInflater);
      gCW().setOnScrollToTopListener((BizProfileRecyclerView.a)new a(this));
      AppMethodBeat.o(306081);
      return paramBundle;
    }
  }
  
  public final void onViewCreated(View paramView, Bundle paramBundle)
  {
    Object localObject = null;
    AppMethodBeat.i(306092);
    s.u(paramView, "view");
    super.onViewCreated(paramView, paramBundle);
    int i;
    if (this.wsq.isEmpty())
    {
      paramView = gCV().YVp;
      if (paramView == null) {
        break label183;
      }
      paramView = paramView.YUi;
      if (paramView == null) {
        break label183;
      }
      if (((Collection)paramView).isEmpty()) {
        break label178;
      }
      i = 1;
      if (i != 1) {
        break label183;
      }
      i = 1;
      label76:
      if (i != 0)
      {
        paramView = this.wsq;
        paramBundle = gCV().YVp.YUi;
        s.s(paramBundle, "mBizProfileResp.VideoList.Msg");
        paramView.addAll((Collection)paramBundle);
        paramBundle = this.NfO;
        paramView = paramBundle;
        if (paramBundle == null)
        {
          s.bIx("mVideoAdapter");
          paramView = null;
        }
        paramView.bZE.notifyChanged();
      }
    }
    paramView = this.NfO;
    if (paramView == null)
    {
      s.bIx("mVideoAdapter");
      paramView = localObject;
    }
    for (;;)
    {
      paramView.NeE = ((kotlin.g.a.a)new b(this));
      AppMethodBeat.o(306092);
      return;
      label178:
      i = 0;
      break;
      label183:
      i = 0;
      break label76;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabVideoFragment$onCreateView$1", "Lcom/tencent/mm/plugin/profile/ui/tab/view/BizProfileRecyclerView$OnScrollToTopListener;", "onScrollToTop", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements BizProfileRecyclerView.a
  {
    a(BizProfileTabVideoFragment paramBizProfileTabVideoFragment) {}
    
    public final void dSq()
    {
      AppMethodBeat.i(306095);
      Object localObject = this.NfP.Nev;
      if (localObject != null) {
        ((ContactWidgetTabBizHeaderController)localObject).gCJ();
      }
      localObject = this.NfP.gCW();
      if (localObject != null)
      {
        com.tencent.mm.hellhoundlib.b.a locala = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabVideoFragment$onCreateView$1", "onScrollToTop", "()V", "Undefined", "scrollToPosition", "(I)V");
        ((BizProfileRecyclerView)localObject).scrollToPosition(((Integer)locala.sb(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabVideoFragment$onCreateView$1", "onScrollToTop", "()V", "Undefined", "scrollToPosition", "(I)V");
      }
      AppMethodBeat.o(306095);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(BizProfileTabVideoFragment paramBizProfileTabVideoFragment)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.list.BizProfileTabVideoFragment
 * JD-Core Version:    0.7.0.1
 */