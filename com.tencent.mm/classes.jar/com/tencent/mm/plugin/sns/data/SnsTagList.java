package com.tencent.mm.plugin.sns.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SnsTagList
  implements Parcelable
{
  public static final Parcelable.Creator<SnsTagList> CREATOR = new SnsTagList.1();
  private int omY = 0;
  private List<Long> omZ = new LinkedList();
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    this.omY = this.omZ.size();
    paramParcel.writeInt(this.omY);
    Iterator localIterator = this.omZ.iterator();
    while (localIterator.hasNext()) {
      paramParcel.writeLong(((Long)localIterator.next()).longValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.SnsTagList
 * JD-Core Version:    0.7.0.1
 */