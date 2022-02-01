package com.tencent.mm.plugin.sns.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SnsTagList
  implements Parcelable
{
  public static final Parcelable.Creator<SnsTagList> CREATOR;
  private int Qod;
  private List<Long> Qoe;
  
  static
  {
    AppMethodBeat.i(95093);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(95093);
  }
  
  public SnsTagList()
  {
    AppMethodBeat.i(95091);
    this.Qod = 0;
    this.Qoe = new LinkedList();
    AppMethodBeat.o(95091);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(95092);
    this.Qod = this.Qoe.size();
    paramParcel.writeInt(this.Qod);
    Iterator localIterator = this.Qoe.iterator();
    while (localIterator.hasNext()) {
      paramParcel.writeLong(((Long)localIterator.next()).longValue());
    }
    AppMethodBeat.o(95092);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.SnsTagList
 * JD-Core Version:    0.7.0.1
 */