package com.tencent.mm.plugin.recordvideo.jumper;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class RecordMediaReportInfo
  implements Parcelable
{
  public static final Parcelable.Creator<RecordMediaReportInfo> CREATOR;
  private HashMap xOD;
  
  static
  {
    AppMethodBeat.i(101515);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(101515);
  }
  
  public RecordMediaReportInfo()
  {
    AppMethodBeat.i(101508);
    this.xOD = new HashMap();
    AppMethodBeat.o(101508);
  }
  
  protected RecordMediaReportInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(101512);
    this.xOD = new HashMap();
    this.xOD = ((HashMap)paramParcel.readSerializable());
    AppMethodBeat.o(101512);
  }
  
  public final void awY(String paramString)
  {
    AppMethodBeat.i(101514);
    if (paramString == null)
    {
      AppMethodBeat.o(101514);
      return;
    }
    try
    {
      paramString = new JSONObject(paramString);
      Iterator localIterator = paramString.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        this.xOD.put(str, paramString.get(str));
      }
      AppMethodBeat.o(101514);
    }
    catch (JSONException paramString)
    {
      AppMethodBeat.o(101514);
      return;
    }
  }
  
  public final String dJa()
  {
    AppMethodBeat.i(101513);
    String str = new JSONObject(this.xOD).toString();
    AppMethodBeat.o(101513);
    return str;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void u(String paramString, Object paramObject)
  {
    AppMethodBeat.i(101509);
    this.xOD.put(paramString, paramObject);
    AppMethodBeat.o(101509);
  }
  
  public final <T> T v(String paramString, T paramT)
  {
    AppMethodBeat.i(101510);
    if (this.xOD.get(paramString) != null)
    {
      paramString = this.xOD.get(paramString);
      AppMethodBeat.o(101510);
      return paramString;
    }
    AppMethodBeat.o(101510);
    return paramT;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(101511);
    paramParcel.writeSerializable(this.xOD);
    AppMethodBeat.o(101511);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo
 * JD-Core Version:    0.7.0.1
 */