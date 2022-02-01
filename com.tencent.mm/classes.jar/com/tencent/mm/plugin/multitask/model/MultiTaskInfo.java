package com.tencent.mm.plugin.multitask.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ex;
import com.tencent.mm.protocal.protobuf.dar;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;
import org.json.JSONObject;

public class MultiTaskInfo
  extends ex
  implements Parcelable
{
  public static final Parcelable.Creator<MultiTaskInfo> CREATOR;
  public static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(205499);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[6];
    localMAutoDBInfo.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "id";
    localMAutoDBInfo.colsMap.put("id", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" id TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "id";
    localMAutoDBInfo.columns[1] = "type";
    localMAutoDBInfo.colsMap.put("type", "INTEGER default '0' ");
    localStringBuilder.append(" type INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "createTime";
    localMAutoDBInfo.colsMap.put("createTime", "LONG default '0' ");
    localStringBuilder.append(" createTime LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "updateTime";
    localMAutoDBInfo.colsMap.put("updateTime", "LONG default '0' ");
    localStringBuilder.append(" updateTime LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "showData";
    localMAutoDBInfo.colsMap.put("showData", "BLOB");
    localStringBuilder.append(" showData BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "data";
    localMAutoDBInfo.colsMap.put("data", "BLOB default '' ");
    localStringBuilder.append(" data BLOB default '' ");
    localMAutoDBInfo.columns[6] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    CREATOR = new Parcelable.Creator()
    {
      private static MultiTaskInfo n(Parcel paramAnonymousParcel)
      {
        AppMethodBeat.i(205508);
        MultiTaskInfo localMultiTaskInfo = new MultiTaskInfo();
        localMultiTaskInfo.field_id = paramAnonymousParcel.readString();
        localMultiTaskInfo.field_type = paramAnonymousParcel.readInt();
        localMultiTaskInfo.field_createTime = paramAnonymousParcel.readLong();
        localMultiTaskInfo.field_updateTime = paramAnonymousParcel.readLong();
        Object localObject = new dar();
        ((dar)localObject).nickname = paramAnonymousParcel.readString();
        ((dar)localObject).title = paramAnonymousParcel.readString();
        ((dar)localObject).TIf = paramAnonymousParcel.readString();
        ((dar)localObject).KFK = paramAnonymousParcel.readInt();
        ((dar)localObject).jmx = paramAnonymousParcel.readString();
        ((dar)localObject).TIg = paramAnonymousParcel.readString();
        ((dar)localObject).TIh = paramAnonymousParcel.readInt();
        boolean bool;
        if (paramAnonymousParcel.readInt() != 0) {
          bool = true;
        }
        for (;;)
        {
          ((dar)localObject).TIi = bool;
          localMultiTaskInfo.field_showData = ((dar)localObject);
          try
          {
            localObject = new byte[paramAnonymousParcel.readInt()];
            paramAnonymousParcel.readByteArray((byte[])localObject);
            localMultiTaskInfo.field_data = ((byte[])localObject);
            AppMethodBeat.o(205508);
            return localMultiTaskInfo;
            bool = false;
          }
          catch (Exception paramAnonymousParcel)
          {
            for (;;)
            {
              Log.e("MicroMsg.MultiTaskInfo", "read ext info error: %s", new Object[] { paramAnonymousParcel.getMessage() });
            }
          }
        }
      }
    };
    AppMethodBeat.o(205499);
  }
  
  public static JSONObject aRa(String paramString)
  {
    AppMethodBeat.i(205497);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("field_id", paramString);
      AppMethodBeat.o(205497);
      return localJSONObject;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.MultiTaskInfo", paramString, "convertMultiTaskToJSONObject fail, exception:%s", new Object[] { paramString });
      AppMethodBeat.o(205497);
    }
    return null;
  }
  
  public static MultiTaskInfo bk(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(205498);
    try
    {
      paramJSONObject = paramJSONObject.getString("field_id");
      MultiTaskInfo localMultiTaskInfo = new MultiTaskInfo();
      localMultiTaskInfo.field_id = paramJSONObject;
      AppMethodBeat.o(205498);
      return localMultiTaskInfo;
    }
    catch (Exception paramJSONObject)
    {
      Log.printErrStackTrace("MicroMsg.MultiTaskInfo", paramJSONObject, "convertJSONObjectToMultiTaskInfo fail, exception:%s", new Object[] { paramJSONObject });
      AppMethodBeat.o(205498);
    }
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final dar fbc()
  {
    AppMethodBeat.i(205495);
    if (this.field_showData == null) {
      this.field_showData = new dar();
    }
    dar localdar = this.field_showData;
    AppMethodBeat.o(205495);
    return localdar;
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(205496);
    paramParcel.writeString(this.field_id);
    paramParcel.writeInt(this.field_type);
    paramParcel.writeLong(this.field_createTime);
    paramParcel.writeLong(this.field_updateTime);
    paramParcel.writeString(this.field_showData.nickname);
    paramParcel.writeString(this.field_showData.title);
    paramParcel.writeString(this.field_showData.TIf);
    paramParcel.writeInt(this.field_showData.KFK);
    paramParcel.writeString(this.field_showData.jmx);
    paramParcel.writeString(this.field_showData.TIg);
    paramParcel.writeInt(this.field_showData.TIh);
    if (this.field_showData.TIi) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.field_data.length);
      paramParcel.writeByteArray(this.field_data);
      AppMethodBeat.o(205496);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.model.MultiTaskInfo
 * JD-Core Version:    0.7.0.1
 */