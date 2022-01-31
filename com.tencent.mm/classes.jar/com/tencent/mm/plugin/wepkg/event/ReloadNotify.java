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
  public static Set<String> vFE;
  public String[] vFF;
  
  static
  {
    AppMethodBeat.i(63477);
    vFE = new HashSet();
    CREATOR = new ReloadNotify.1();
    AppMethodBeat.o(63477);
  }
  
  private ReloadNotify(Parcel paramParcel)
  {
    AppMethodBeat.i(63476);
    this.vFF = paramParcel.createStringArray();
    AppMethodBeat.o(63476);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(63475);
    paramParcel.writeStringArray(this.vFF);
    AppMethodBeat.o(63475);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.event.ReloadNotify
 * JD-Core Version:    0.7.0.1
 */