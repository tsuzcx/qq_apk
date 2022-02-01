package com.tencent.mm.plugin.webwx.ui;

import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webwx/ui/LoginDeviceAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/webwx/ui/LoginDeviceViewHolder;", "onlineInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/messenger/extdevice/NetSceneGetOnlineInfo$LocalOnlineInfo;", "selectedPosition", "", "listener", "Lcom/tencent/mm/plugin/webwx/ui/LoginDeviceViewHolder$IDeviceListener;", "(Ljava/util/ArrayList;ILcom/tencent/mm/plugin/webwx/ui/LoginDeviceViewHolder$IDeviceListener;)V", "getListener", "()Lcom/tencent/mm/plugin/webwx/ui/LoginDeviceViewHolder$IDeviceListener;", "getOnlineInfoList", "()Ljava/util/ArrayList;", "getItemCount", "onBindViewHolder", "", "viewHolder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "p1", "setSelection", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends RecyclerView.a<b>
{
  public static final a.a Xxp;
  private final ArrayList<com.tencent.mm.plugin.messenger.b.a.a> Xxq;
  private final b.a Xxr;
  int dyx;
  
  static
  {
    AppMethodBeat.i(265361);
    Xxp = new a.a((byte)0);
    AppMethodBeat.o(265361);
  }
  
  public a(ArrayList<com.tencent.mm.plugin.messenger.b.a.a> paramArrayList, int paramInt, b.a parama)
  {
    AppMethodBeat.i(265355);
    this.Xxq = paramArrayList;
    this.dyx = paramInt;
    this.Xxr = parama;
    AppMethodBeat.o(265355);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(265364);
    int i = this.Xxq.size();
    AppMethodBeat.o(265364);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.ui.a
 * JD-Core Version:    0.7.0.1
 */