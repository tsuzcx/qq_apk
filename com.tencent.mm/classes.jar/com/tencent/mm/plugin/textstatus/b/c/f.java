package com.tencent.mm.plugin.textstatus.b.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mvvmlist.MvvmList;
import com.tencent.mm.plugin.textstatus.a.e;
import com.tencent.mm.plugin.textstatus.a.f;
import com.tencent.mm.plugin.textstatus.a.h;
import com.tencent.mm.plugin.textstatus.a.a.a;
import com.tencent.mm.plugin.textstatus.a.a.c;
import com.tencent.mm.plugin.textstatus.h.f.g.c;
import com.tencent.mm.plugin.textstatus.proto.TextStatusTopicInfo;
import com.tencent.mm.plugin.textstatus.ui.TextStatusCardFeedsActivity;
import com.tencent.mm.plugin.textstatus.ui.TextStatusCardFeedsActivity.a;
import com.tencent.mm.plugin.textstatus.ui.m;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.am;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/convert/topic/TopicSquareItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/textstatus/model/topic/SameTopicFriendsItem;", "source", "", "(I)V", "dataListArray", "Landroid/util/SparseArray;", "", "Lcom/tencent/mm/plugin/textstatus/convert/topic/SameTopicFriendData;", "maxCount", "mvvmListArray", "Lcom/tencent/mm/plugin/mvvmlist/MvvmList;", "getSource", "()I", "buildItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "position", "getLayoutId", "initView", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "onBindViewHolder", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Companion", "plugin-textstatus_release", "mvvmList", "adapter", "Lcom/tencent/mm/plugin/mvvmlist/MvvmRecyclerAdapter;"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends com.tencent.mm.view.recyclerview.f<com.tencent.mm.plugin.textstatus.h.g.b>
{
  public static final f.a Tkv;
  private final SparseArray<MvvmList<c>> Tkw;
  private final SparseArray<List<c>> Tkx;
  private int lyL;
  private final int source;
  
  static
  {
    AppMethodBeat.i(290309);
    Tkv = new f.a((byte)0);
    AppMethodBeat.o(290309);
  }
  
  public f(int paramInt)
  {
    AppMethodBeat.i(290243);
    this.source = paramInt;
    this.lyL = -1;
    this.Tkw = new SparseArray();
    this.Tkx = new SparseArray();
    AppMethodBeat.o(290243);
  }
  
  private static final void J(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(290251);
    if (paramRecyclerView != null) {
      paramRecyclerView.setLayoutFrozen(true);
    }
    AppMethodBeat.o(290251);
  }
  
  private static final void a(com.tencent.mm.plugin.textstatus.h.g.b paramb, com.tencent.mm.view.recyclerview.j paramj, View paramView)
  {
    AppMethodBeat.i(290279);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramj);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/convert/topic/TopicSquareItemConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "$item");
    s.u(paramj, "$holder");
    if (paramb.TnV.bMQ.size() > 0)
    {
      paramView = TextStatusCardFeedsActivity.Txc;
      paramj = paramj.context;
      s.s(paramj, "holder.context");
      TextStatusCardFeedsActivity.a.cb(paramj, ((com.tencent.mm.plugin.textstatus.h.f.b)paramb.TnV.bMQ.get(0)).field_UserName);
      paramj = com.tencent.mm.plugin.textstatus.i.b.Trt;
      paramj = ((com.tencent.mm.plugin.textstatus.h.f.b)paramb.TnV.bMQ.get(0)).field_IconID;
      paramView = ((com.tencent.mm.plugin.textstatus.h.f.b)paramb.TnV.bMQ.get(0)).field_UserName;
      int i = paramb.TnV.bMQ.size();
      s.s(paramj, "field_IconID");
      s.s(paramView, "field_UserName");
      com.tencent.mm.plugin.textstatus.i.b.a(6L, paramj, i, paramView, null, null, 0, 0L, 240);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/textstatus/convert/topic/TopicSquareItemConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(290279);
  }
  
  private static final void a(com.tencent.mm.view.recyclerview.j paramj, int paramInt, RecyclerView paramRecyclerView, f paramf, com.tencent.mm.plugin.textstatus.h.g.b paramb, List paramList)
  {
    AppMethodBeat.i(290270);
    s.u(paramj, "$holder");
    s.u(paramf, "this$0");
    s.u(paramb, "$item");
    paramf = k.aeZF;
    paramf = paramj.context;
    s.s(paramf, "holder.context");
    ((m)k.nq(paramf).q(m.class)).hKc();
    if (paramRecyclerView != null) {
      paramRecyclerView.setLayoutFrozen(false);
    }
    ((ImageView)paramj.UH(a.e.divider)).setVisibility(0);
    paramf = (ImageView)paramj.UH(a.e.TcN);
    com.tencent.mm.plugin.textstatus.util.b.hKh().a(paramf, ((com.tencent.mm.plugin.textstatus.h.f.b)paramb.TnV.bMQ.get(0)).field_IconID, a.c.ThP, a.a.Thy, (com.tencent.mm.plugin.textstatus.h.f.b)paramb.TnV.bMQ.get(0));
    TextView localTextView = (TextView)paramj.UH(a.e.gaN);
    aw.d((Paint)localTextView.getPaint());
    int i = paramb.TnV.bMQ.size();
    if (i > 0)
    {
      TextStatusTopicInfo localTextStatusTopicInfo = com.tencent.mm.plugin.textstatus.h.f.b.b((com.tencent.mm.plugin.textstatus.h.f.b)paramb.TnV.bMQ.get(0));
      paramf = com.tencent.mm.plugin.textstatus.b.f.TjQ;
      paramf = com.tencent.mm.plugin.textstatus.b.f.bdN(com.tencent.mm.plugin.auth.a.a.cUx());
      if (paramf != null) {
        break label421;
      }
      paramf = null;
      if (!s.p(localTextStatusTopicInfo.topicId, paramf)) {
        break label429;
      }
      paramInt = 1;
      label235:
      paramList = am.aixg;
      paramList = String.format(com.tencent.mm.plugin.textstatus.util.b.hKh().a(localTextStatusTopicInfo, i, com.tencent.mm.plugin.textstatus.util.b.hKh().f(localTextStatusTopicInfo), paramInt), Arrays.copyOf(new Object[0], 0));
      s.s(paramList, "java.lang.String.format(format, *args)");
      if (((CharSequence)paramList).length() != 0) {
        break label434;
      }
      paramInt = 1;
      label295:
      if (paramInt == 0) {
        break label446;
      }
      if (!s.p(localTextStatusTopicInfo.topicId, paramf)) {
        break label439;
      }
      paramInt = a.h.TgA;
      label315:
      paramj = paramj.context.getResources().getString(paramInt, new Object[] { Integer.valueOf(paramb.TnV.bMQ.size()), com.tencent.mm.plugin.textstatus.util.b.hKh().bei(com.tencent.mm.plugin.textstatus.h.f.b.b((com.tencent.mm.plugin.textstatus.h.f.b)paramb.TnV.bMQ.get(0)).iconId) });
      s.s(paramj, "holder.context.resources…].getTopicInfo().iconId))");
    }
    for (;;)
    {
      localTextView.setText((CharSequence)paramj);
      if (paramRecyclerView != null) {
        paramRecyclerView.post(new f..ExternalSyntheticLambda2(paramRecyclerView));
      }
      AppMethodBeat.o(290270);
      return;
      label421:
      paramf = paramf.field_TopicId;
      break;
      label429:
      paramInt = 2;
      break label235;
      label434:
      paramInt = 0;
      break label295;
      label439:
      paramInt = a.h.Tgx;
      break label315;
      label446:
      paramj = paramList;
    }
  }
  
  private static final MvvmList<c> d(kotlin.j<? extends MvvmList<c>> paramj)
  {
    AppMethodBeat.i(290246);
    paramj = (MvvmList)paramj.getValue();
    AppMethodBeat.o(290246);
    return paramj;
  }
  
  public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.j paramj, int paramInt)
  {
    AppMethodBeat.i(290341);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    AppMethodBeat.o(290341);
  }
  
  public final int getLayoutId()
  {
    return a.f.TfI;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/convert/topic/TopicSquareItemConvert$buildItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.view.recyclerview.g
  {
    b(f paramf, int paramInt) {}
    
    public final com.tencent.mm.view.recyclerview.f<?> yF(int paramInt)
    {
      AppMethodBeat.i(290233);
      Object localObject = new e();
      kotlin.g.a.a locala = (kotlin.g.a.a)new a(this.Tky, this.qkg);
      s.u(locala, "listener");
      ((e)localObject).Tku = locala;
      localObject = (com.tencent.mm.view.recyclerview.f)localObject;
      AppMethodBeat.o(290233);
      return localObject;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(f paramf, int paramInt)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k=3, mv={1, 5, 1})
  public static final class c<T>
    implements Comparator
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(290232);
      int i = kotlin.b.a.b((Comparable)Integer.valueOf(((com.tencent.mm.plugin.textstatus.h.f.b)paramT2).field_CreateTime), (Comparable)Integer.valueOf(((com.tencent.mm.plugin.textstatus.h.f.b)paramT1).field_CreateTime));
      AppMethodBeat.o(290232);
      return i;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/mvvmlist/MvvmRecyclerAdapter;", "Lcom/tencent/mm/plugin/textstatus/convert/topic/SameTopicFriendData;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.mvvmlist.g<c>>
  {
    d(f paramf, int paramInt, kotlin.j<? extends MvvmList<c>> paramj)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/mvvmlist/MvvmList;", "Lcom/tencent/mm/plugin/textstatus/convert/topic/SameTopicFriendData;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<MvvmList<c>>
  {
    e(d paramd, com.tencent.mm.view.recyclerview.j paramj)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.b.c.f
 * JD-Core Version:    0.7.0.1
 */