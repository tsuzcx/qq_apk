package com.tencent.mm.plugin.sns.ui.picker;

import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerUI$initPickerAdapter$2", "Lcom/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerListAdapter$ISnsAlbumDataLoadCallback;", "onLoadDataFinish", "", "list", "", "Lcom/tencent/mm/plugin/sns/ui/picker/SnsPickerMediaInfo;", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class SnsAlbumPickerUI$d
  implements c.d
{
  SnsAlbumPickerUI$d(SnsAlbumPickerUI paramSnsAlbumPickerUI) {}
  
  public final void kV(List<g> paramList)
  {
    AppMethodBeat.i(308715);
    s.u(paramList, "list");
    Log.i("MicroMsg.SnsAlbumPickerUI", s.X("Adapter onLoadDataFinish callback to UI ，list count = ", Integer.valueOf(paramList.size())));
    if ((paramList.isEmpty()) && (SnsAlbumPickerUI.j(this.RSH).getItemCount() <= 0))
    {
      SnsAlbumPickerUI.g(this.RSH).setVisibility(4);
      SnsAlbumPickerUI.k(this.RSH).setVisibility(0);
      if (!SnsAlbumPickerUI.e(this.RSH)) {
        SnsAlbumPickerUI.k(this.RSH).setText((CharSequence)this.RSH.getString(b.j.sns_album_picker_no_data));
      }
    }
    for (;;)
    {
      if ((paramList.isEmpty()) && (SnsAlbumPickerUI.e(this.RSH))) {
        SnsAlbumPickerUI.i(this.RSH);
      }
      AppMethodBeat.o(308715);
      return;
      SnsAlbumPickerUI.g(this.RSH).setVisibility(0);
      SnsAlbumPickerUI.k(this.RSH).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.picker.SnsAlbumPickerUI.d
 * JD-Core Version:    0.7.0.1
 */