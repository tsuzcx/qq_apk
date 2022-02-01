package com.tencent.mm.plugin.scanner.ui.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.al.a.e;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/ui/widget/ScanProductMaskDecorView$EmptyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "emptyAreaView", "kotlin.jvm.PlatformType", "getEmptyAreaView", "()Landroid/view/View;", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ScanProductMaskDecorView$b
  extends RecyclerView.v
{
  final View PgR;
  
  public ScanProductMaskDecorView$b(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(314921);
    this.PgR = paramView.findViewById(a.e.empty_extra_view);
    AppMethodBeat.o(314921);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.widget.ScanProductMaskDecorView.b
 * JD-Core Version:    0.7.0.1
 */