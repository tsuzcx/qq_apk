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
  private int zdj;
  private int zdk;
  public List<Integer> zdl;
  public List<Integer> zdm;
  
  static
  {
    AppMethodBeat.i(95081);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(95081);
  }
  
  public SnsCmdList()
  {
    AppMethodBeat.i(95077);
    this.zdj = 0;
    this.zdk = 0;
    this.zdl = new LinkedList();
    this.zdm = new LinkedList();
    AppMethodBeat.o(95077);
  }
  
  public final void PH(int paramInt)
  {
    AppMethodBeat.i(95078);
    this.zdl.add(Integer.valueOf(paramInt));
    AppMethodBeat.o(95078);
  }
  
  public final void PI(int paramInt)
  {
    AppMethodBeat.i(95079);
    this.zdm.add(Integer.valueOf(paramInt));
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
    this.zdj = this.zdl.size();
    paramParcel.writeInt(this.zdj);
    paramInt = 0;
    while (paramInt < this.zdj)
    {
      paramParcel.writeInt(((Integer)this.zdl.get(paramInt)).intValue());
      paramInt += 1;
    }
    this.zdk = this.zdm.size();
    paramParcel.writeInt(this.zdk);
    paramInt = i;
    while (paramInt < this.zdk)
    {
      paramParcel.writeInt(((Integer)this.zdm.get(paramInt)).intValue());
      paramInt += 1;
    }
    AppMethodBeat.o(95080);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.SnsCmdList
 * JD-Core Version:    0.7.0.1
 */