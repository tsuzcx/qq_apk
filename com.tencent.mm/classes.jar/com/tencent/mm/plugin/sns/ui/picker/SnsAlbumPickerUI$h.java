package com.tencent.mm.plugin.sns.ui.picker;

import androidx.recyclerview.widget.GridLayoutManager.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerUI$initSnsAlbumRecyclerView$1$1", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "getSpanSize", "", "position", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class SnsAlbumPickerUI$h
  extends GridLayoutManager.b
{
  SnsAlbumPickerUI$h(SnsAlbumPickerUI paramSnsAlbumPickerUI) {}
  
  public final int fJ(int paramInt)
  {
    AppMethodBeat.i(308698);
    if (SnsAlbumPickerUI.j(this.RSH).getItemViewType(paramInt) == 1)
    {
      AppMethodBeat.o(308698);
      return 1;
    }
    AppMethodBeat.o(308698);
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.picker.SnsAlbumPickerUI.h
 * JD-Core Version:    0.7.0.1
 */