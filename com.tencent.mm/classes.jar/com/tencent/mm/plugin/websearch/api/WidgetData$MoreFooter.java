package com.tencent.mm.plugin.websearch.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;

public class WidgetData$MoreFooter
  implements Parcelable
{
  public static final Parcelable.Creator<MoreFooter> CREATOR;
  public String title;
  public String uKN;
  public String uKO;
  
  static
  {
    AppMethodBeat.i(124271);
    CREATOR = new WidgetData.MoreFooter.1();
    AppMethodBeat.o(124271);
  }
  
  public WidgetData$MoreFooter() {}
  
  protected WidgetData$MoreFooter(Parcel paramParcel)
  {
    AppMethodBeat.i(124268);
    this.title = paramParcel.readString();
    this.uKN = paramParcel.readString();
    this.uKO = paramParcel.readString();
    AppMethodBeat.o(124268);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(124269);
    if (this == paramObject)
    {
      AppMethodBeat.o(124269);
      return true;
    }
    if (!(paramObject instanceof MoreFooter))
    {
      AppMethodBeat.o(124269);
      return false;
    }
    paramObject = (MoreFooter)paramObject;
    if ((Objects.equals(this.title, paramObject.title)) && (Objects.equals(this.uKN, paramObject.uKN)) && (Objects.equals(this.uKO, paramObject.uKO)))
    {
      AppMethodBeat.o(124269);
      return true;
    }
    AppMethodBeat.o(124269);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(124270);
    int i = Objects.hash(new Object[] { this.title, this.uKN, this.uKO });
    AppMethodBeat.o(124270);
    return i;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(124267);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.uKN);
    paramParcel.writeString(this.uKO);
    AppMethodBeat.o(124267);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.WidgetData.MoreFooter
 * JD-Core Version:    0.7.0.1
 */