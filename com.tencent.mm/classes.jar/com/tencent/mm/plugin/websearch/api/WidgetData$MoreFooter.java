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
  public String Wqv;
  public String Wqw;
  public String title;
  
  static
  {
    AppMethodBeat.i(117819);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(117819);
  }
  
  public WidgetData$MoreFooter() {}
  
  protected WidgetData$MoreFooter(Parcel paramParcel)
  {
    AppMethodBeat.i(117816);
    this.title = paramParcel.readString();
    this.Wqv = paramParcel.readString();
    this.Wqw = paramParcel.readString();
    AppMethodBeat.o(117816);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(117817);
    if (this == paramObject)
    {
      AppMethodBeat.o(117817);
      return true;
    }
    if (!(paramObject instanceof MoreFooter))
    {
      AppMethodBeat.o(117817);
      return false;
    }
    paramObject = (MoreFooter)paramObject;
    if ((Objects.equals(this.title, paramObject.title)) && (Objects.equals(this.Wqv, paramObject.Wqv)) && (Objects.equals(this.Wqw, paramObject.Wqw)))
    {
      AppMethodBeat.o(117817);
      return true;
    }
    AppMethodBeat.o(117817);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(117818);
    int i = Objects.hash(new Object[] { this.title, this.Wqv, this.Wqw });
    AppMethodBeat.o(117818);
    return i;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(117815);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.Wqv);
    paramParcel.writeString(this.Wqw);
    AppMethodBeat.o(117815);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.WidgetData.MoreFooter
 * JD-Core Version:    0.7.0.1
 */