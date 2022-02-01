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
  private int DEj;
  private int DEk;
  public List<Integer> DEl;
  public List<Integer> DEm;
  
  static
  {
    AppMethodBeat.i(95081);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(95081);
  }
  
  public SnsCmdList()
  {
    AppMethodBeat.i(95077);
    this.DEj = 0;
    this.DEk = 0;
    this.DEl = new LinkedList();
    this.DEm = new LinkedList();
    AppMethodBeat.o(95077);
  }
  
  public final void Yj(int paramInt)
  {
    AppMethodBeat.i(95078);
    this.DEl.add(Integer.valueOf(paramInt));
    AppMethodBeat.o(95078);
  }
  
  public final void Yk(int paramInt)
  {
    AppMethodBeat.i(95079);
    this.DEm.add(Integer.valueOf(paramInt));
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
    this.DEj = this.DEl.size();
    paramParcel.writeInt(this.DEj);
    paramInt = 0;
    while (paramInt < this.DEj)
    {
      paramParcel.writeInt(((Integer)this.DEl.get(paramInt)).intValue());
      paramInt += 1;
    }
    this.DEk = this.DEm.size();
    paramParcel.writeInt(this.DEk);
    paramInt = i;
    while (paramInt < this.DEk)
    {
      paramParcel.writeInt(((Integer)this.DEm.get(paramInt)).intValue());
      paramInt += 1;
    }
    AppMethodBeat.o(95080);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.SnsCmdList
 * JD-Core Version:    0.7.0.1
 */