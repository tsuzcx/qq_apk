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
  public static Set<String> BIr;
  public static Parcelable.Creator<ForceUpdateNotify> CREATOR;
  public String[] BIs;
  
  static
  {
    AppMethodBeat.i(110637);
    BIr = new HashSet();
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(110637);
  }
  
  private ForceUpdateNotify(Parcel paramParcel)
  {
    AppMethodBeat.i(110636);
    this.BIs = paramParcel.createStringArray();
    AppMethodBeat.o(110636);
  }
  
  private ForceUpdateNotify(String[] paramArrayOfString)
  {
    this.BIs = paramArrayOfString;
  }
  
  public static void cot()
  {
    AppMethodBeat.i(110634);
    if (BIr.size() != 0)
    {
      Set localSet = BIr;
      c.a(new ForceUpdateNotify((String[])localSet.toArray(new String[localSet.size()])), new c.a()
      {
        public final void cWw()
        {
          AppMethodBeat.i(110631);
          ForceUpdateNotify.BIr.clear();
          AppMethodBeat.o(110631);
        }
      });
    }
    AppMethodBeat.o(110634);
  }
  
  public static void xe(String paramString)
  {
    AppMethodBeat.i(110633);
    BIr.add(paramString);
    AppMethodBeat.o(110633);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(110635);
    paramParcel.writeStringArray(this.BIs);
    AppMethodBeat.o(110635);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.event.ForceUpdateNotify
 * JD-Core Version:    0.7.0.1
 */