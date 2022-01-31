package com.tencent.mm.plugin.sns.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.LinkedList;
import java.util.List;

public class SnsCmdList
  implements Parcelable
{
  public static final Parcelable.Creator<SnsCmdList> CREATOR = new SnsCmdList.1();
  private int omP = 0;
  private int omQ = 0;
  public List<Integer> omR = new LinkedList();
  public List<Integer> omS = new LinkedList();
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 0;
    this.omP = this.omR.size();
    paramParcel.writeInt(this.omP);
    paramInt = 0;
    while (paramInt < this.omP)
    {
      paramParcel.writeInt(((Integer)this.omR.get(paramInt)).intValue());
      paramInt += 1;
    }
    this.omQ = this.omS.size();
    paramParcel.writeInt(this.omQ);
    paramInt = i;
    while (paramInt < this.omQ)
    {
      paramParcel.writeInt(((Integer)this.omS.get(paramInt)).intValue());
      paramInt += 1;
    }
  }
  
  public final void xA(int paramInt)
  {
    this.omS.add(Integer.valueOf(paramInt));
  }
  
  public final void xz(int paramInt)
  {
    this.omR.add(Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.SnsCmdList
 * JD-Core Version:    0.7.0.1
 */