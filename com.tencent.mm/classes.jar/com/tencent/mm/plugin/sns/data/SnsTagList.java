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
  private int rbo;
  private List<Long> rbp;
  
  static
  {
    AppMethodBeat.i(35803);
    CREATOR = new SnsTagList.1();
    AppMethodBeat.o(35803);
  }
  
  public SnsTagList()
  {
    AppMethodBeat.i(35801);
    this.rbo = 0;
    this.rbp = new LinkedList();
    AppMethodBeat.o(35801);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(35802);
    this.rbo = this.rbp.size();
    paramParcel.writeInt(this.rbo);
    Iterator localIterator = this.rbp.iterator();
    while (localIterator.hasNext()) {
      paramParcel.writeLong(((Long)localIterator.next()).longValue());
    }
    AppMethodBeat.o(35802);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.SnsTagList
 * JD-Core Version:    0.7.0.1
 */