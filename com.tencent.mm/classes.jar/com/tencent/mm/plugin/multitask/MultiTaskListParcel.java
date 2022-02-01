package com.tencent.mm.plugin.multitask;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/MultiTaskListParcel;", "Landroid/os/Parcelable;", "taskInfoList", "", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "(Ljava/util/List;)V", "in", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "multiTaskInfoList", "getMultiTaskInfoList", "()Ljava/util/List;", "setMultiTaskInfoList", "describeContents", "", "writeToParcel", "", "dest", "flags", "Companion", "plugin-multitask_release"})
final class MultiTaskListParcel
  implements Parcelable
{
  public static final Parcelable.Creator<MultiTaskListParcel> CREATOR;
  public static final MultiTaskListParcel.a FEZ;
  List<? extends MultiTaskInfo> FEY;
  
  static
  {
    AppMethodBeat.i(247720);
    FEZ = new MultiTaskListParcel.a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(247720);
  }
  
  protected MultiTaskListParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(247719);
    this.FEY = ((List)paramParcel.createTypedArrayList(MultiTaskInfo.CREATOR));
    AppMethodBeat.o(247719);
  }
  
  public MultiTaskListParcel(List<? extends MultiTaskInfo> paramList)
  {
    this.FEY = paramList;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(247718);
    p.k(paramParcel, "dest");
    paramParcel.writeTypedList(this.FEY);
    AppMethodBeat.o(247718);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/multitask/MultiTaskListParcel$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/multitask/MultiTaskListParcel;", "createFromParcel", "in", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/multitask/MultiTaskListParcel;", "plugin-multitask_release"})
  public static final class b
    implements Parcelable.Creator<MultiTaskListParcel>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.MultiTaskListParcel
 * JD-Core Version:    0.7.0.1
 */