package com.tencent.mm.plugin.wepkg.event;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

public class ForceUpdateNotify
  implements Parcelable
{
  public static Parcelable.Creator<ForceUpdateNotify> CREATOR;
  public static Set<String> vFE;
  public String[] vFF;
  
  static
  {
    AppMethodBeat.i(63466);
    vFE = new HashSet();
    CREATOR = new ForceUpdateNotify.2();
    AppMethodBeat.o(63466);
  }
  
  private ForceUpdateNotify(Parcel paramParcel)
  {
    AppMethodBeat.i(63465);
    this.vFF = paramParcel.createStringArray();
    AppMethodBeat.o(63465);
  }
  
  private ForceUpdateNotify(String[] paramArrayOfString)
  {
    this.vFF = paramArrayOfString;
  }
  
  public static void boB()
  {
    AppMethodBeat.i(63463);
    if (vFE.size() != 0)
    {
      Set localSet = vFE;
      c.a(new ForceUpdateNotify((String[])localSet.toArray(new String[localSet.size()])), new ForceUpdateNotify.1());
    }
    AppMethodBeat.o(63463);
  }
  
  public static void xB(String paramString)
  {
    AppMethodBeat.i(63462);
    vFE.add(paramString);
    AppMethodBeat.o(63462);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(63464);
    paramParcel.writeStringArray(this.vFF);
    AppMethodBeat.o(63464);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.event.ForceUpdateNotify
 * JD-Core Version:    0.7.0.1
 */