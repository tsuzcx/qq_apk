package com.tencent.mm.plugin.recordvideo.jumper;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public class RecordMediaReportInfo
  implements Parcelable
{
  public static final Parcelable.Creator<RecordMediaReportInfo> CREATOR;
  private HashMap qbF;
  
  static
  {
    AppMethodBeat.i(156029);
    CREATOR = new RecordMediaReportInfo.1();
    AppMethodBeat.o(156029);
  }
  
  public RecordMediaReportInfo()
  {
    AppMethodBeat.i(156024);
    this.qbF = new HashMap();
    AppMethodBeat.o(156024);
  }
  
  protected RecordMediaReportInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(156028);
    this.qbF = new HashMap();
    this.qbF = ((HashMap)paramParcel.readSerializable());
    AppMethodBeat.o(156028);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void p(String paramString, Object paramObject)
  {
    AppMethodBeat.i(156025);
    this.qbF.put(paramString, paramObject);
    AppMethodBeat.o(156025);
  }
  
  public final <T> T q(String paramString, T paramT)
  {
    AppMethodBeat.i(156026);
    if (this.qbF.get(paramString) != null)
    {
      paramString = this.qbF.get(paramString);
      AppMethodBeat.o(156026);
      return paramString;
    }
    AppMethodBeat.o(156026);
    return paramT;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(156027);
    paramParcel.writeSerializable(this.qbF);
    AppMethodBeat.o(156027);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo
 * JD-Core Version:    0.7.0.1
 */