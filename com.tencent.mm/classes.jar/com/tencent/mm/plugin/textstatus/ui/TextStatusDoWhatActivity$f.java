package com.tencent.mm.plugin.textstatus.ui;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.GridLayoutManager.b;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import kotlin.Metadata;
import kotlin.g.b.ah.f;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity$onCreate$2", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "getSpanSize", "", "position", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class TextStatusDoWhatActivity$f
  extends GridLayoutManager.b
{
  TextStatusDoWhatActivity$f(TextStatusDoWhatActivity paramTextStatusDoWhatActivity, ah.f<GridLayoutManager> paramf) {}
  
  public final int fJ(int paramInt)
  {
    Integer localInteger = null;
    AppMethodBeat.i(291148);
    Object localObject = this.Txw.yAg;
    if (localObject == null)
    {
      if (localInteger != null) {
        break label55;
      }
      label23:
      if (localInteger != null) {
        break label84;
      }
    }
    label55:
    label84:
    while (localInteger.intValue() != 1)
    {
      AppMethodBeat.o(291148);
      return 1;
      localObject = ((WxRecyclerView)localObject).getAdapter();
      if (localObject == null) {
        break;
      }
      localInteger = Integer.valueOf(((RecyclerView.a)localObject).getItemViewType(paramInt));
      break;
      if (localInteger.intValue() != -1) {
        break label23;
      }
      paramInt = ((GridLayoutManager)this.Txx.aqH).bWl;
      AppMethodBeat.o(291148);
      return paramInt;
    }
    paramInt = ((GridLayoutManager)this.Txx.aqH).bWl;
    AppMethodBeat.o(291148);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusDoWhatActivity.f
 * JD-Core Version:    0.7.0.1
 */