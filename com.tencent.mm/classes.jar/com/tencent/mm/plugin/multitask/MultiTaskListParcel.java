package com.tencent.mm.plugin.multitask;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/MultiTaskListParcel;", "Landroid/os/Parcelable;", "taskInfoList", "", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "(Ljava/util/List;)V", "in", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "multiTaskInfoList", "getMultiTaskInfoList", "()Ljava/util/List;", "setMultiTaskInfoList", "describeContents", "", "writeToParcel", "", "dest", "flags", "Companion", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
final class MultiTaskListParcel
  implements Parcelable
{
  public static final Parcelable.Creator<MultiTaskListParcel> CREATOR;
  public static final MultiTaskListParcel.a LBb;
  List<? extends MultiTaskInfo> LBc;
  
  static
  {
    AppMethodBeat.i(303751);
    LBb = new MultiTaskListParcel.a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(303751);
  }
  
  protected MultiTaskListParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(303741);
    this.LBc = ((List)paramParcel.createTypedArrayList(MultiTaskInfo.CREATOR));
    AppMethodBeat.o(303741);
  }
  
  public MultiTaskListParcel(List<? extends MultiTaskInfo> paramList)
  {
    this.LBc = paramList;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(303768);
    s.u(paramParcel, "dest");
    paramParcel.writeTypedList(this.LBc);
    AppMethodBeat.o(303768);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/multitask/MultiTaskListParcel$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/multitask/MultiTaskListParcel;", "createFromParcel", "in", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/multitask/MultiTaskListParcel;", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Parcelable.Creator<MultiTaskListParcel>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.MultiTaskListParcel
 * JD-Core Version:    0.7.0.1
 */