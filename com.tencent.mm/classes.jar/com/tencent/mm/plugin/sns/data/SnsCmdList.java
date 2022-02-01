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
  private int QnQ;
  private int QnR;
  public List<Integer> QnS;
  public List<Integer> alK;
  
  static
  {
    AppMethodBeat.i(95081);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(95081);
  }
  
  public SnsCmdList()
  {
    AppMethodBeat.i(95077);
    this.QnQ = 0;
    this.QnR = 0;
    this.QnS = new LinkedList();
    this.alK = new LinkedList();
    AppMethodBeat.o(95077);
  }
  
  public final void akp(int paramInt)
  {
    AppMethodBeat.i(95078);
    this.QnS.add(Integer.valueOf(paramInt));
    AppMethodBeat.o(95078);
  }
  
  public final void akq(int paramInt)
  {
    AppMethodBeat.i(95079);
    this.alK.add(Integer.valueOf(paramInt));
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
    this.QnQ = this.QnS.size();
    paramParcel.writeInt(this.QnQ);
    paramInt = 0;
    while (paramInt < this.QnQ)
    {
      paramParcel.writeInt(((Integer)this.QnS.get(paramInt)).intValue());
      paramInt += 1;
    }
    this.QnR = this.alK.size();
    paramParcel.writeInt(this.QnR);
    paramInt = i;
    while (paramInt < this.QnR)
    {
      paramParcel.writeInt(((Integer)this.alK.get(paramInt)).intValue());
      paramInt += 1;
    }
    AppMethodBeat.o(95080);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.SnsCmdList
 * JD-Core Version:    0.7.0.1
 */