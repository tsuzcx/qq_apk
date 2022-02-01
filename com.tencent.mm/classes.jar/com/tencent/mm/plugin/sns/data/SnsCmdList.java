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
  private int JRe;
  private int JRf;
  public List<Integer> JRg;
  public List<Integer> JRh;
  
  static
  {
    AppMethodBeat.i(95081);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(95081);
  }
  
  public SnsCmdList()
  {
    AppMethodBeat.i(95077);
    this.JRe = 0;
    this.JRf = 0;
    this.JRg = new LinkedList();
    this.JRh = new LinkedList();
    AppMethodBeat.o(95077);
  }
  
  public final void afA(int paramInt)
  {
    AppMethodBeat.i(95078);
    this.JRg.add(Integer.valueOf(paramInt));
    AppMethodBeat.o(95078);
  }
  
  public final void afB(int paramInt)
  {
    AppMethodBeat.i(95079);
    this.JRh.add(Integer.valueOf(paramInt));
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
    this.JRe = this.JRg.size();
    paramParcel.writeInt(this.JRe);
    paramInt = 0;
    while (paramInt < this.JRe)
    {
      paramParcel.writeInt(((Integer)this.JRg.get(paramInt)).intValue());
      paramInt += 1;
    }
    this.JRf = this.JRh.size();
    paramParcel.writeInt(this.JRf);
    paramInt = i;
    while (paramInt < this.JRf)
    {
      paramParcel.writeInt(((Integer)this.JRh.get(paramInt)).intValue());
      paramInt += 1;
    }
    AppMethodBeat.o(95080);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.SnsCmdList
 * JD-Core Version:    0.7.0.1
 */