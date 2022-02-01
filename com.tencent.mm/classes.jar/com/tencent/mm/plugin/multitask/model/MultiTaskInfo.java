package com.tencent.mm.plugin.multitask.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fm;
import com.tencent.mm.protocal.protobuf.drz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import org.json.JSONObject;

public class MultiTaskInfo
  extends fm
  implements Parcelable
{
  public static final Parcelable.Creator<MultiTaskInfo> CREATOR;
  public static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(303804);
    info = fm.aJm();
    CREATOR = new Parcelable.Creator()
    {
      private static MultiTaskInfo r(Parcel paramAnonymousParcel)
      {
        AppMethodBeat.i(303792);
        MultiTaskInfo localMultiTaskInfo = new MultiTaskInfo();
        localMultiTaskInfo.field_id = paramAnonymousParcel.readString();
        localMultiTaskInfo.field_type = paramAnonymousParcel.readInt();
        localMultiTaskInfo.field_createTime = paramAnonymousParcel.readLong();
        localMultiTaskInfo.field_updateTime = paramAnonymousParcel.readLong();
        Object localObject = new drz();
        ((drz)localObject).nickname = paramAnonymousParcel.readString();
        ((drz)localObject).title = paramAnonymousParcel.readString();
        ((drz)localObject).aaXO = paramAnonymousParcel.readString();
        ((drz)localObject).Rfk = paramAnonymousParcel.readInt();
        ((drz)localObject).lPJ = paramAnonymousParcel.readString();
        ((drz)localObject).aaXP = paramAnonymousParcel.readString();
        ((drz)localObject).aaXQ = paramAnonymousParcel.readInt();
        boolean bool;
        if (paramAnonymousParcel.readInt() != 0) {
          bool = true;
        }
        for (;;)
        {
          ((drz)localObject).aaXR = bool;
          localMultiTaskInfo.field_showData = ((drz)localObject);
          try
          {
            localObject = new byte[paramAnonymousParcel.readInt()];
            paramAnonymousParcel.readByteArray((byte[])localObject);
            localMultiTaskInfo.field_data = ((byte[])localObject);
            AppMethodBeat.o(303792);
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
    AppMethodBeat.o(303804);
  }
  
  public static JSONObject aNS(String paramString)
  {
    AppMethodBeat.i(303788);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("field_id", paramString);
      AppMethodBeat.o(303788);
      return localJSONObject;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.MultiTaskInfo", paramString, "convertMultiTaskToJSONObject fail, exception:%s", new Object[] { paramString });
      AppMethodBeat.o(303788);
    }
    return null;
  }
  
  public static MultiTaskInfo bA(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(303797);
    try
    {
      paramJSONObject = paramJSONObject.getString("field_id");
      MultiTaskInfo localMultiTaskInfo = new MultiTaskInfo();
      localMultiTaskInfo.field_id = paramJSONObject;
      AppMethodBeat.o(303797);
      return localMultiTaskInfo;
    }
    catch (Exception paramJSONObject)
    {
      Log.printErrStackTrace("MicroMsg.MultiTaskInfo", paramJSONObject, "convertJSONObjectToMultiTaskInfo fail, exception:%s", new Object[] { paramJSONObject });
      AppMethodBeat.o(303797);
    }
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final drz gkh()
  {
    AppMethodBeat.i(303814);
    if (this.field_showData == null) {
      this.field_showData = new drz();
    }
    drz localdrz = this.field_showData;
    AppMethodBeat.o(303814);
    return localdrz;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(303832);
    paramParcel.writeString(this.field_id);
    paramParcel.writeInt(this.field_type);
    paramParcel.writeLong(this.field_createTime);
    paramParcel.writeLong(this.field_updateTime);
    paramParcel.writeString(this.field_showData.nickname);
    paramParcel.writeString(this.field_showData.title);
    paramParcel.writeString(this.field_showData.aaXO);
    paramParcel.writeInt(this.field_showData.Rfk);
    paramParcel.writeString(this.field_showData.lPJ);
    paramParcel.writeString(this.field_showData.aaXP);
    paramParcel.writeInt(this.field_showData.aaXQ);
    if (this.field_showData.aaXR) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.field_data.length);
      paramParcel.writeByteArray(this.field_data);
      AppMethodBeat.o(303832);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.model.MultiTaskInfo
 * JD-Core Version:    0.7.0.1
 */