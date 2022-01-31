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
  private int rbe;
  private int rbf;
  public List<Integer> rbg;
  public List<Integer> rbh;
  
  static
  {
    AppMethodBeat.i(35793);
    CREATOR = new SnsCmdList.1();
    AppMethodBeat.o(35793);
  }
  
  public SnsCmdList()
  {
    AppMethodBeat.i(35789);
    this.rbe = 0;
    this.rbf = 0;
    this.rbg = new LinkedList();
    this.rbh = new LinkedList();
    AppMethodBeat.o(35789);
  }
  
  public final void DA(int paramInt)
  {
    AppMethodBeat.i(35791);
    this.rbh.add(Integer.valueOf(paramInt));
    AppMethodBeat.o(35791);
  }
  
  public final void Dz(int paramInt)
  {
    AppMethodBeat.i(35790);
    this.rbg.add(Integer.valueOf(paramInt));
    AppMethodBeat.o(35790);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(35792);
    this.rbe = this.rbg.size();
    paramParcel.writeInt(this.rbe);
    paramInt = 0;
    while (paramInt < this.rbe)
    {
      paramParcel.writeInt(((Integer)this.rbg.get(paramInt)).intValue());
      paramInt += 1;
    }
    this.rbf = this.rbh.size();
    paramParcel.writeInt(this.rbf);
    paramInt = i;
    while (paramInt < this.rbf)
    {
      paramParcel.writeInt(((Integer)this.rbh.get(paramInt)).intValue());
      paramInt += 1;
    }
    AppMethodBeat.o(35792);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.SnsCmdList
 * JD-Core Version:    0.7.0.1
 */