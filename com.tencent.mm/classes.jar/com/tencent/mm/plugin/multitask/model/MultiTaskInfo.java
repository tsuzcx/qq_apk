package com.tencent.mm.plugin.multitask.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.es;
import com.tencent.mm.protocal.protobuf.cru;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public class MultiTaskInfo
  extends es
  implements Parcelable
{
  public static final Parcelable.Creator<MultiTaskInfo> CREATOR;
  public static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(208699);
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
        AppMethodBeat.i(208695);
        MultiTaskInfo localMultiTaskInfo = new MultiTaskInfo();
        localMultiTaskInfo.field_id = paramAnonymousParcel.readString();
        localMultiTaskInfo.field_type = paramAnonymousParcel.readInt();
        localMultiTaskInfo.field_createTime = paramAnonymousParcel.readLong();
        localMultiTaskInfo.field_updateTime = paramAnonymousParcel.readLong();
        Object localObject = new cru();
        ((cru)localObject).nickname = paramAnonymousParcel.readString();
        ((cru)localObject).title = paramAnonymousParcel.readString();
        ((cru)localObject).MwQ = paramAnonymousParcel.readString();
        ((cru)localObject).Eso = paramAnonymousParcel.readInt();
        ((cru)localObject).gCr = paramAnonymousParcel.readString();
        ((cru)localObject).MwR = paramAnonymousParcel.readString();
        ((cru)localObject).MwS = paramAnonymousParcel.readInt();
        boolean bool;
        if (paramAnonymousParcel.readInt() != 0) {
          bool = true;
        }
        for (;;)
        {
          ((cru)localObject).MwT = bool;
          localMultiTaskInfo.field_showData = ((cru)localObject);
          try
          {
            localObject = new byte[paramAnonymousParcel.readInt()];
            paramAnonymousParcel.readByteArray((byte[])localObject);
            localMultiTaskInfo.field_data = ((byte[])localObject);
            AppMethodBeat.o(208695);
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
    AppMethodBeat.o(208699);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final cru erh()
  {
    AppMethodBeat.i(208697);
    if (this.field_showData == null) {
      this.field_showData = new cru();
    }
    cru localcru = this.field_showData;
    AppMethodBeat.o(208697);
    return localcru;
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(208698);
    paramParcel.writeString(this.field_id);
    paramParcel.writeInt(this.field_type);
    paramParcel.writeLong(this.field_createTime);
    paramParcel.writeLong(this.field_updateTime);
    paramParcel.writeString(this.field_showData.nickname);
    paramParcel.writeString(this.field_showData.title);
    paramParcel.writeString(this.field_showData.MwQ);
    paramParcel.writeInt(this.field_showData.Eso);
    paramParcel.writeString(this.field_showData.gCr);
    paramParcel.writeString(this.field_showData.MwR);
    paramParcel.writeInt(this.field_showData.MwS);
    if (this.field_showData.MwT) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.field_data.length);
      paramParcel.writeByteArray(this.field_data);
      AppMethodBeat.o(208698);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.model.MultiTaskInfo
 * JD-Core Version:    0.7.0.1
 */