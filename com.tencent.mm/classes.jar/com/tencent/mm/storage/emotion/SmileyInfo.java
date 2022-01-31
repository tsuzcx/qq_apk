package com.tencent.mm.storage.emotion;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.em;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public class SmileyInfo
  extends em
  implements Parcelable
{
  public static final Parcelable.Creator<SmileyInfo> CREATOR;
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(62883);
    c.a locala = new c.a();
    locala.yrK = new Field[10];
    locala.columns = new String[11];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "key";
    locala.yrM.put("key", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" key TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "key";
    locala.columns[1] = "cnValue";
    locala.yrM.put("cnValue", "TEXT");
    localStringBuilder.append(" cnValue TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "qqValue";
    locala.yrM.put("qqValue", "TEXT");
    localStringBuilder.append(" qqValue TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "twValue";
    locala.yrM.put("twValue", "TEXT");
    localStringBuilder.append(" twValue TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "enValue";
    locala.yrM.put("enValue", "TEXT");
    localStringBuilder.append(" enValue TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "thValue";
    locala.yrM.put("thValue", "TEXT");
    localStringBuilder.append(" thValue TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "fileName";
    locala.yrM.put("fileName", "TEXT");
    localStringBuilder.append(" fileName TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "eggIndex";
    locala.yrM.put("eggIndex", "INTEGER default '-1' ");
    localStringBuilder.append(" eggIndex INTEGER default '-1' ");
    localStringBuilder.append(", ");
    locala.columns[8] = "position";
    locala.yrM.put("position", "INTEGER default '-1' ");
    localStringBuilder.append(" position INTEGER default '-1' ");
    localStringBuilder.append(", ");
    locala.columns[9] = "flag";
    locala.yrM.put("flag", "INTEGER");
    localStringBuilder.append(" flag INTEGER");
    locala.columns[10] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    CREATOR = new SmileyInfo.1();
    AppMethodBeat.o(62883);
  }
  
  public SmileyInfo() {}
  
  protected SmileyInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(62880);
    this.field_key = paramParcel.readString();
    this.field_cnValue = paramParcel.readString();
    this.field_qqValue = paramParcel.readString();
    this.field_twValue = paramParcel.readString();
    this.field_enValue = paramParcel.readString();
    this.field_thValue = paramParcel.readString();
    this.field_fileName = paramParcel.readString();
    this.field_position = paramParcel.readInt();
    this.field_eggIndex = paramParcel.readInt();
    this.field_flag = paramParcel.readInt();
    AppMethodBeat.o(62880);
  }
  
  public SmileyInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt)
  {
    this.field_key = paramString1;
    this.field_cnValue = paramString3;
    this.field_qqValue = paramString2;
    this.field_enValue = paramString5;
    this.field_thValue = paramString6;
    this.field_twValue = paramString4;
    this.field_position = paramInt;
  }
  
  public SmileyInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt)
  {
    this.field_key = paramString1;
    this.field_cnValue = paramString3;
    this.field_qqValue = paramString2;
    this.field_enValue = paramString5;
    this.field_thValue = paramString6;
    this.field_twValue = paramString4;
    this.field_fileName = paramString7;
    this.field_eggIndex = paramInt;
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
    AppMethodBeat.i(62881);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("key:").append(this.field_key).append("/n");
    ((StringBuilder)localObject).append("cn:").append(this.field_cnValue).append("/n");
    ((StringBuilder)localObject).append("qq:").append(this.field_qqValue).append("/n");
    ((StringBuilder)localObject).append("en:").append(this.field_enValue).append("/n");
    ((StringBuilder)localObject).append("th:").append(this.field_thValue).append("/n");
    ((StringBuilder)localObject).append("tw:").append(this.field_twValue).append("/n");
    ((StringBuilder)localObject).append("position:").append(this.field_position).append("/n");
    ((StringBuilder)localObject).append("file Name:").append(this.field_fileName).append("/n");
    ((StringBuilder)localObject).append("egg index:").append(this.field_eggIndex).append("/n");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(62881);
    return localObject;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(62882);
    paramParcel.writeString(this.field_key);
    paramParcel.writeString(this.field_cnValue);
    paramParcel.writeString(this.field_qqValue);
    paramParcel.writeString(this.field_twValue);
    paramParcel.writeString(this.field_enValue);
    paramParcel.writeString(this.field_thValue);
    paramParcel.writeString(this.field_fileName);
    paramParcel.writeInt(this.field_position);
    paramParcel.writeInt(this.field_eggIndex);
    paramParcel.writeInt(this.field_flag);
    AppMethodBeat.o(62882);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.SmileyInfo
 * JD-Core Version:    0.7.0.1
 */