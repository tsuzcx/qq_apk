package com.tencent.mm.plugin.multitask.ui.minusscreen.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.ui.e.c;
import com.tencent.mm.plugin.multitask.ui.e.d;
import com.tencent.mm.plugin.multitask.ui.e.e;
import com.tencent.mm.plugin.multitask.ui.e.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.RoundCornerImageView;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.j;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/view/NoteMinusScreenRoundCornerConvert;", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/view/MinusScreenRoundCornerConvert;", "listener", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/listener/MinusScreenViewItemListener;", "(Lcom/tencent/mm/plugin/multitask/ui/minusscreen/listener/MinusScreenViewItemListener;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getNickName", "context", "Landroid/content/Context;", "item", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/data/RVMultiTaskData;", "onAttachedToRecyclerView", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "ui-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends d
{
  private final String TAG = "MicroMsg.NoteMinusScreenRoundCornerConvert";
  
  public e(com.tencent.mm.plugin.multitask.ui.minusscreen.d.a parama)
  {
    super(e.d.LEl, parama);
  }
  
  public final String a(Context paramContext, com.tencent.mm.plugin.multitask.ui.minusscreen.b.a parama)
  {
    AppMethodBeat.i(304401);
    s.u(paramContext, "context");
    s.u(parama, "item");
    paramContext = paramContext.getResources().getString(e.f.LEr);
    AppMethodBeat.o(304401);
    return paramContext;
  }
  
  public final void a(RecyclerView paramRecyclerView, WxRecyclerAdapter<?> paramWxRecyclerAdapter)
  {
    AppMethodBeat.i(304387);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramWxRecyclerAdapter, "adapter");
    super.a(paramRecyclerView, paramWxRecyclerAdapter);
    AppMethodBeat.o(304387);
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(304371);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    super.a(paramRecyclerView, paramj, paramInt);
    AppMethodBeat.o(304371);
  }
  
  public final void a(j paramj, com.tencent.mm.plugin.multitask.ui.minusscreen.b.a parama, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(304380);
    s.u(paramj, "holder");
    s.u(parama, "item");
    Log.d(this.TAG, "onBindViewHolder");
    super.a(paramj, parama, paramInt1, paramInt2, paramBoolean, paramList);
    ((ImageView)paramj.caK.findViewById(e.c.LDQ)).setImageDrawable(null);
    paramj = (RoundCornerImageView)paramj.caK.findViewById(e.c.LDH);
    paramj.setPadding(com.tencent.mm.cd.a.fromDPToPix(paramj.getContext(), 2), com.tencent.mm.cd.a.fromDPToPix(paramj.getContext(), 2), com.tencent.mm.cd.a.fromDPToPix(paramj.getContext(), 2), com.tencent.mm.cd.a.fromDPToPix(paramj.getContext(), 2));
    paramj.setVisibility(0);
    paramj.setImageResource(e.e.bottomsheet_icon_fav);
    AppMethodBeat.o(304380);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.minusscreen.view.e
 * JD-Core Version:    0.7.0.1
 */