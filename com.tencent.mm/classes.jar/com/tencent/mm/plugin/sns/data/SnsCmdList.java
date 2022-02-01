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
  private int xNp;
  private int xNq;
  public List<Integer> xNr;
  public List<Integer> xNs;
  
  static
  {
    AppMethodBeat.i(95081);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(95081);
  }
  
  public SnsCmdList()
  {
    AppMethodBeat.i(95077);
    this.xNp = 0;
    this.xNq = 0;
    this.xNr = new LinkedList();
    this.xNs = new LinkedList();
    AppMethodBeat.o(95077);
  }
  
  public final void Oa(int paramInt)
  {
    AppMethodBeat.i(95078);
    this.xNr.add(Integer.valueOf(paramInt));
    AppMethodBeat.o(95078);
  }
  
  public final void Ob(int paramInt)
  {
    AppMethodBeat.i(95079);
    this.xNs.add(Integer.valueOf(paramInt));
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
    this.xNp = this.xNr.size();
    paramParcel.writeInt(this.xNp);
    paramInt = 0;
    while (paramInt < this.xNp)
    {
      paramParcel.writeInt(((Integer)this.xNr.get(paramInt)).intValue());
      paramInt += 1;
    }
    this.xNq = this.xNs.size();
    paramParcel.writeInt(this.xNq);
    paramInt = i;
    while (paramInt < this.xNq)
    {
      paramParcel.writeInt(((Integer)this.xNs.get(paramInt)).intValue());
      paramInt += 1;
    }
    AppMethodBeat.o(95080);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.SnsCmdList
 * JD-Core Version:    0.7.0.1
 */