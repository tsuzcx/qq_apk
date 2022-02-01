package com.tencent.mm.plugin.sns.ui.picker;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.dmz;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerUI$initPickerAdapter$4", "Lcom/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerListAdapter$IOnGridMediaItemClickListener;", "onGridMediaItemClick", "", "itemData", "Lcom/tencent/mm/plugin/sns/ui/picker/SnsPickerMediaInfo;", "itemView", "Landroid/view/View;", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class SnsAlbumPickerUI$f
  implements c.b
{
  SnsAlbumPickerUI$f(SnsAlbumPickerUI paramSnsAlbumPickerUI) {}
  
  public final void a(g paramg, View paramView)
  {
    AppMethodBeat.i(308708);
    s.u(paramg, "itemData");
    s.u(paramView, "itemView");
    paramView = this.RSH;
    int i = paramg.RSO.localid;
    paramg = paramg.Qsr.Id;
    s.s(paramg, "itemData.mediaObj.Id");
    SnsAlbumPickerUI.a(paramView, i, paramg);
    AppMethodBeat.o(308708);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.picker.SnsAlbumPickerUI.f
 * JD-Core Version:    0.7.0.1
 */