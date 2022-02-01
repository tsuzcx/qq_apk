package com.tencent.mm.storage.emotion;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fi;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public class SmileyPanelConfigInfo
  extends fi
  implements Parcelable
{
  public static final Parcelable.Creator<SmileyPanelConfigInfo> CREATOR;
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(105150);
    c.a locala = new c.a();
    locala.EYt = new Field[2];
    locala.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "key";
    locala.EYv.put("key", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" key TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.EYu = "key";
    locala.columns[1] = "position";
    locala.EYv.put("position", "INTEGER");
    localStringBuilder.append(" position INTEGER");
    locala.columns[2] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(105150);
  }
  
  public SmileyPanelConfigInfo() {}
  
  public SmileyPanelConfigInfo(int paramInt, String paramString)
  {
    this.field_position = paramInt;
    this.field_key = paramString;
  }
  
  protected SmileyPanelConfigInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(105147);
    this.field_position = paramParcel.readInt();
    this.field_key = paramParcel.readString();
    AppMethodBeat.o(105147);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public c.a getDBInfo()
  {
    return null;
  }
  
  public String toString()
  {
    AppMethodBeat.i(105148);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("index:").append(this.field_position);
    ((StringBuilder)localObject).append("key  :").append(this.field_key);
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(105148);
    return localObject;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(105149);
    paramParcel.writeInt(this.field_position);
    paramParcel.writeString(this.field_key);
    AppMethodBeat.o(105149);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.SmileyPanelConfigInfo
 * JD-Core Version:    0.7.0.1
 */