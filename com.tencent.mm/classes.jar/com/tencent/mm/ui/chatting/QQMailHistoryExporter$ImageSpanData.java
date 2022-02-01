package com.tencent.mm.ui.chatting;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class QQMailHistoryExporter$ImageSpanData
  implements Parcelable
{
  public static final Parcelable.Creator<ImageSpanData> CREATOR;
  int dgI;
  int endPos;
  String path;
  private int thumbnail = 0;
  
  static
  {
    AppMethodBeat.i(34850);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(34850);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(34849);
    paramParcel.writeInt(this.dgI);
    paramParcel.writeInt(this.endPos);
    paramParcel.writeString(this.path);
    paramParcel.writeInt(this.thumbnail);
    AppMethodBeat.o(34849);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.QQMailHistoryExporter.ImageSpanData
 * JD-Core Version:    0.7.0.1
 */