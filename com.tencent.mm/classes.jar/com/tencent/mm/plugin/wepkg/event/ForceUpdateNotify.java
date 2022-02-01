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
  public static Set<String> EEz;
  public String[] EEA;
  
  static
  {
    AppMethodBeat.i(110637);
    EEz = new HashSet();
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(110637);
  }
  
  private ForceUpdateNotify(Parcel paramParcel)
  {
    AppMethodBeat.i(110636);
    this.EEA = paramParcel.createStringArray();
    AppMethodBeat.o(110636);
  }
  
  private ForceUpdateNotify(String[] paramArrayOfString)
  {
    this.EEA = paramArrayOfString;
  }
  
  public static void Ej(String paramString)
  {
    AppMethodBeat.i(110633);
    EEz.add(paramString);
    AppMethodBeat.o(110633);
  }
  
  public static void cEN()
  {
    AppMethodBeat.i(110634);
    if (EEz.size() != 0)
    {
      Set localSet = EEz;
      c.a(new ForceUpdateNotify((String[])localSet.toArray(new String[localSet.size()])), new c.a()
      {
        public final void dur()
        {
          AppMethodBeat.i(110631);
          ForceUpdateNotify.EEz.clear();
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
    paramParcel.writeStringArray(this.EEA);
    AppMethodBeat.o(110635);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.event.ForceUpdateNotify
 * JD-Core Version:    0.7.0.1
 */