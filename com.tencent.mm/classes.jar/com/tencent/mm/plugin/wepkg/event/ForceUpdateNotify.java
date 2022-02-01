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
  public static Set<String> XFD;
  public String[] XFE;
  
  static
  {
    AppMethodBeat.i(110637);
    XFD = new HashSet();
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(110637);
  }
  
  private ForceUpdateNotify(Parcel paramParcel)
  {
    AppMethodBeat.i(110636);
    this.XFE = paramParcel.createStringArray();
    AppMethodBeat.o(110636);
  }
  
  private ForceUpdateNotify(String[] paramArrayOfString)
  {
    this.XFE = paramArrayOfString;
  }
  
  public static void add(String paramString)
  {
    AppMethodBeat.i(110633);
    XFD.add(paramString);
    AppMethodBeat.o(110633);
  }
  
  public static void eGV()
  {
    AppMethodBeat.i(110634);
    if (XFD.size() != 0)
    {
      Set localSet = XFD;
      c.a(new ForceUpdateNotify((String[])localSet.toArray(new String[localSet.size()])), new c.a()
      {
        public final void gtj()
        {
          AppMethodBeat.i(110631);
          ForceUpdateNotify.XFD.clear();
          AppMethodBeat.o(110631);
        }
      });
    }
    AppMethodBeat.o(110634);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(110635);
    paramParcel.writeStringArray(this.XFE);
    AppMethodBeat.o(110635);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.event.ForceUpdateNotify
 * JD-Core Version:    0.7.0.1
 */