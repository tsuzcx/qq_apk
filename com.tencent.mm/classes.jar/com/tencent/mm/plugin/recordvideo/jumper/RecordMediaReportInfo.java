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
  private HashMap vig;
  
  static
  {
    AppMethodBeat.i(101515);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(101515);
  }
  
  public RecordMediaReportInfo()
  {
    AppMethodBeat.i(101508);
    this.vig = new HashMap();
    AppMethodBeat.o(101508);
  }
  
  protected RecordMediaReportInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(101512);
    this.vig = new HashMap();
    this.vig = ((HashMap)paramParcel.readSerializable());
    AppMethodBeat.o(101512);
  }
  
  public final void alK(String paramString)
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
        this.vig.put(str, paramString.get(str));
      }
      AppMethodBeat.o(101514);
    }
    catch (JSONException paramString)
    {
      AppMethodBeat.o(101514);
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final String dhG()
  {
    AppMethodBeat.i(101513);
    String str = new JSONObject(this.vig).toString();
    AppMethodBeat.o(101513);
    return str;
  }
  
  public final void v(String paramString, Object paramObject)
  {
    AppMethodBeat.i(101509);
    this.vig.put(paramString, paramObject);
    AppMethodBeat.o(101509);
  }
  
  public final <T> T w(String paramString, T paramT)
  {
    AppMethodBeat.i(101510);
    if (this.vig.get(paramString) != null)
    {
      paramString = this.vig.get(paramString);
      AppMethodBeat.o(101510);
      return paramString;
    }
    AppMethodBeat.o(101510);
    return paramT;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(101511);
    paramParcel.writeSerializable(this.vig);
    AppMethodBeat.o(101511);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo
 * JD-Core Version:    0.7.0.1
 */