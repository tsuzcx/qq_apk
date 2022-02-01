package com.tencent.mm.plugin.textstatus.ui;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.GridLayoutManager.b;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import kotlin.g.b.aa.f;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity$onCreate$2", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "getSpanSize", "", "position", "plugin-textstatus_release"})
public final class TextStatusDoWhatActivity$g
  extends GridLayoutManager.b
{
  TextStatusDoWhatActivity$g(aa.f paramf) {}
  
  public final int cx(int paramInt)
  {
    AppMethodBeat.i(236251);
    Object localObject = this.MLa.vnF;
    if (localObject != null)
    {
      localObject = ((WxRecyclerView)localObject).getAdapter();
      if (localObject != null)
      {
        localObject = Integer.valueOf(((RecyclerView.a)localObject).getItemViewType(paramInt));
        if (localObject != null) {
          break label55;
        }
        label39:
        if (localObject != null) {
          break label84;
        }
      }
    }
    label55:
    label84:
    while (((Integer)localObject).intValue() != 1)
    {
      AppMethodBeat.o(236251);
      return 1;
      localObject = null;
      break;
      if (((Integer)localObject).intValue() != -1) {
        break label39;
      }
      paramInt = ((GridLayoutManager)this.MLd.aaBC).ku();
      AppMethodBeat.o(236251);
      return paramInt;
    }
    paramInt = ((GridLayoutManager)this.MLd.aaBC).ku();
    AppMethodBeat.o(236251);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusDoWhatActivity.g
 * JD-Core Version:    0.7.0.1
 */