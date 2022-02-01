package com.tencent.mm.plugin.sns.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.List;

public class SnsCmdList
  implements Parcelable
{
  public static final Parcelable.Creator<SnsCmdList> CREATOR;
  private int ztZ;
  private int zua;
  public List<Integer> zub;
  public List<Integer> zuc;
  
  static
  {
    AppMethodBeat.i(95081);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(95081);
  }
  
  public SnsCmdList()
  {
    AppMethodBeat.i(95077);
    this.ztZ = 0;
    this.zua = 0;
    this.zub = new LinkedList();
    this.zuc = new LinkedList();
    AppMethodBeat.o(95077);
  }
  
  public final void Qo(int paramInt)
  {
    AppMethodBeat.i(95078);
    this.zub.add(Integer.valueOf(paramInt));
    AppMethodBeat.o(95078);
  }
  
  public final void Qp(int paramInt)
  {
    AppMethodBeat.i(95079);
    this.zuc.add(Integer.valueOf(paramInt));
    AppMethodBeat.o(95079);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(95080);
    this.ztZ = this.zub.size();
    paramParcel.writeInt(this.ztZ);
    paramInt = 0;
    while (paramInt < this.ztZ)
    {
      paramParcel.writeInt(((Integer)this.zub.get(paramInt)).intValue());
      paramInt += 1;
    }
    this.zua = this.zuc.size();
    paramParcel.writeInt(this.zua);
    paramInt = i;
    while (paramInt < this.zua)
    {
      paramParcel.writeInt(((Integer)this.zuc.get(paramInt)).intValue());
      paramInt += 1;
    }
    AppMethodBeat.o(95080);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.SnsCmdList
 * JD-Core Version:    0.7.0.1
 */