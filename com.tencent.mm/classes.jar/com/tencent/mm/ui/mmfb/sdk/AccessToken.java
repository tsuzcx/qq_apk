package com.tencent.mm.ui.mmfb.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public final class AccessToken
  implements Parcelable
{
  public static final Parcelable.Creator<AccessToken> CREATOR;
  private static final Date afyl;
  private static final Date afym;
  private static final Date afyn;
  private final Date afyo;
  private final Set<String> afyp;
  private final Set<String> afyq;
  private final Set<String> afyr;
  private final Date afys;
  private final String afyt;
  private final Date afyu;
  private final String afyv;
  private final String token;
  private final String userId;
  
  static
  {
    AppMethodBeat.i(250235);
    Date localDate = new Date(9223372036854775807L);
    afyl = localDate;
    afym = localDate;
    afyn = new Date();
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(250235);
  }
  
  AccessToken(Parcel paramParcel)
  {
    AppMethodBeat.i(250228);
    this.afyo = new Date(paramParcel.readLong());
    ArrayList localArrayList = new ArrayList();
    paramParcel.readStringList(localArrayList);
    this.afyp = Collections.unmodifiableSet(new HashSet(localArrayList));
    localArrayList.clear();
    paramParcel.readStringList(localArrayList);
    this.afyq = Collections.unmodifiableSet(new HashSet(localArrayList));
    localArrayList.clear();
    paramParcel.readStringList(localArrayList);
    this.afyr = Collections.unmodifiableSet(new HashSet(localArrayList));
    this.token = paramParcel.readString();
    this.afys = new Date(paramParcel.readLong());
    this.afyt = paramParcel.readString();
    this.userId = paramParcel.readString();
    this.afyu = new Date(paramParcel.readLong());
    this.afyv = paramParcel.readString();
    AppMethodBeat.o(250228);
  }
  
  public static boolean jBM()
  {
    return false;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(250249);
    if (this == paramObject)
    {
      AppMethodBeat.o(250249);
      return true;
    }
    if (!(paramObject instanceof AccessToken))
    {
      AppMethodBeat.o(250249);
      return false;
    }
    paramObject = (AccessToken)paramObject;
    if ((this.afyo.equals(paramObject.afyo)) && (this.afyp.equals(paramObject.afyp)) && (this.afyq.equals(paramObject.afyq)) && (this.afyr.equals(paramObject.afyr)) && (this.token.equals(paramObject.token)) && (this.afys.equals(paramObject.afys))) {
      if (this.afyt == null)
      {
        if (paramObject.afyt != null) {
          break label203;
        }
        if ((!this.userId.equals(paramObject.userId)) || (!this.afyu.equals(paramObject.afyu))) {
          break label203;
        }
        if (this.afyv != null) {
          break label210;
        }
        if (paramObject.afyv != null) {
          break label203;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(250249);
      return true;
      if (this.afyt.equals(paramObject.afyt)) {
        break;
      }
      label203:
      label210:
      do
      {
        AppMethodBeat.o(250249);
        return false;
      } while (!this.afyv.equals(paramObject.afyv));
    }
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(250254);
    int k = this.afyo.hashCode();
    int m = this.afyp.hashCode();
    int n = this.afyq.hashCode();
    int i1 = this.afyr.hashCode();
    int i2 = this.token.hashCode();
    int i3 = this.afys.hashCode();
    int i;
    int i4;
    int i5;
    if (this.afyt == null)
    {
      i = 0;
      i4 = this.userId.hashCode();
      i5 = this.afyu.hashCode();
      if (this.afyv != null) {
        break label174;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(250254);
      return (((i + ((((((k + 527) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31) * 31 + i4) * 31 + i5) * 31 + j;
      i = this.afyt.hashCode();
      break;
      label174:
      j = this.afyv.hashCode();
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(250241);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("{AccessToken");
    ((StringBuilder)localObject).append(" token:null");
    ((StringBuilder)localObject).append(" permissions:");
    if (this.afyp == null) {
      ((StringBuilder)localObject).append("null");
    }
    for (;;)
    {
      ((StringBuilder)localObject).append("}");
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(250241);
      return localObject;
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(TextUtils.join(", ", this.afyp));
      ((StringBuilder)localObject).append("]");
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(250259);
    paramParcel.writeLong(this.afyo.getTime());
    paramParcel.writeStringList(new ArrayList(this.afyp));
    paramParcel.writeStringList(new ArrayList(this.afyq));
    paramParcel.writeStringList(new ArrayList(this.afyr));
    paramParcel.writeString(this.token);
    paramParcel.writeLong(this.afys.getTime());
    paramParcel.writeString(this.afyt);
    paramParcel.writeString(this.userId);
    paramParcel.writeLong(this.afyu.getTime());
    paramParcel.writeString(this.afyv);
    AppMethodBeat.o(250259);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.mmfb.sdk.AccessToken
 * JD-Core Version:    0.7.0.1
 */