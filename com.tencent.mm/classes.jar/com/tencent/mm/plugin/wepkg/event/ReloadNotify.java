package com.tencent.mm.plugin.wepkg.event;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

public class ReloadNotify
  implements Parcelable
{
  public static Parcelable.Creator<ReloadNotify> CREATOR;
  public static Set<String> XFD;
  public String[] XFE;
  
  static
  {
    AppMethodBeat.i(110648);
    XFD = new HashSet();
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(110648);
  }
  
  private ReloadNotify(Parcel paramParcel)
  {
    AppMethodBeat.i(110647);
    this.XFE = paramParcel.createStringArray();
    AppMethodBeat.o(110647);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(110646);
    paramParcel.writeStringArray(this.XFE);
    AppMethodBeat.o(110646);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.event.ReloadNotify
 * JD-Core Version:    0.7.0.1
 */