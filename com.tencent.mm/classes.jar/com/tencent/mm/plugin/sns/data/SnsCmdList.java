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
  private int wAV;
  private int wAW;
  public List<Integer> wAX;
  public List<Integer> wAY;
  
  static
  {
    AppMethodBeat.i(95081);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(95081);
  }
  
  public SnsCmdList()
  {
    AppMethodBeat.i(95077);
    this.wAV = 0;
    this.wAW = 0;
    this.wAX = new LinkedList();
    this.wAY = new LinkedList();
    AppMethodBeat.o(95077);
  }
  
  public final void LY(int paramInt)
  {
    AppMethodBeat.i(95078);
    this.wAX.add(Integer.valueOf(paramInt));
    AppMethodBeat.o(95078);
  }
  
  public final void LZ(int paramInt)
  {
    AppMethodBeat.i(95079);
    this.wAY.add(Integer.valueOf(paramInt));
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
    this.wAV = this.wAX.size();
    paramParcel.writeInt(this.wAV);
    paramInt = 0;
    while (paramInt < this.wAV)
    {
      paramParcel.writeInt(((Integer)this.wAX.get(paramInt)).intValue());
      paramInt += 1;
    }
    this.wAW = this.wAY.size();
    paramParcel.writeInt(this.wAW);
    paramInt = i;
    while (paramInt < this.wAW)
    {
      paramParcel.writeInt(((Integer)this.wAY.get(paramInt)).intValue());
      paramInt += 1;
    }
    AppMethodBeat.o(95080);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.SnsCmdList
 * JD-Core Version:    0.7.0.1
 */