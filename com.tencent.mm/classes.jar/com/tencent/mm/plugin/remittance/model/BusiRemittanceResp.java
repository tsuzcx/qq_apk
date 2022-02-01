package com.tencent.mm.plugin.remittance.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aie;
import com.tencent.mm.protocal.protobuf.ou;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

public class BusiRemittanceResp
  implements Parcelable
{
  public static final Parcelable.Creator<BusiRemittanceResp> CREATOR;
  public int wJQ;
  public String wJR;
  public String wJS;
  public int wJT;
  public String wJU;
  public String wJV;
  public List<aie> wJW;
  public ou wJX;
  public int wJY;
  public int wJZ;
  public String wKa;
  public String wKb;
  public int wKc;
  
  static
  {
    AppMethodBeat.i(67837);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(67837);
  }
  
  BusiRemittanceResp()
  {
    AppMethodBeat.i(67833);
    this.wJQ = 0;
    this.wJR = "";
    this.wJS = "";
    this.wJW = new LinkedList();
    this.wJY = 0;
    this.wJZ = 0;
    this.wKc = 400;
    AppMethodBeat.o(67833);
  }
  
  protected BusiRemittanceResp(Parcel paramParcel)
  {
    AppMethodBeat.i(67835);
    this.wJQ = 0;
    this.wJR = "";
    this.wJS = "";
    this.wJW = new LinkedList();
    this.wJY = 0;
    this.wJZ = 0;
    this.wKc = 400;
    this.wJQ = paramParcel.readInt();
    this.wJR = paramParcel.readString();
    this.wJS = paramParcel.readString();
    this.wJT = paramParcel.readInt();
    this.wJU = paramParcel.readString();
    this.wJV = paramParcel.readString();
    this.wJY = paramParcel.readInt();
    this.wJZ = paramParcel.readInt();
    this.wKa = paramParcel.readString();
    this.wKb = paramParcel.readString();
    this.wKc = paramParcel.readInt();
    this.wJW = new LinkedList();
    int j = paramParcel.readInt();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        int k = paramParcel.readInt();
        byte[] arrayOfByte1;
        if (k > 0)
        {
          arrayOfByte1 = new byte[k];
          paramParcel.readByteArray(arrayOfByte1);
        }
        try
        {
          aie localaie = new aie();
          localaie.parseFrom(arrayOfByte1);
          this.wJW.add(localaie);
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ac.printErrStackTrace("MicroMsg.BusiRemittanceResp", localException, "", new Object[0]);
          }
        }
      }
    }
    i = paramParcel.readInt();
    if (i > 0)
    {
      byte[] arrayOfByte2 = new byte[i];
      paramParcel.readByteArray(arrayOfByte2);
      this.wJX = new ou();
      try
      {
        this.wJX.parseFrom(arrayOfByte2);
        AppMethodBeat.o(67835);
        return;
      }
      catch (Exception paramParcel)
      {
        ac.printErrStackTrace("MicroMsg.BusiRemittanceResp", paramParcel, "", new Object[0]);
      }
    }
    AppMethodBeat.o(67835);
  }
  
  BusiRemittanceResp(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(67834);
    this.wJQ = 0;
    this.wJR = "";
    this.wJS = "";
    this.wJW = new LinkedList();
    this.wJY = 0;
    this.wJZ = 0;
    this.wKc = 400;
    this.wJQ = paramJSONObject.optInt("show_photo", 0);
    this.wJR = paramJSONObject.optString("photo_url", "");
    this.wJS = paramJSONObject.optString("favor_desc", "");
    this.wJT = paramJSONObject.optInt("scan_scene", 0);
    this.wJU = paramJSONObject.optString("favor_req_sign", "");
    this.wJV = paramJSONObject.optString("favor_req_extend", "");
    this.wKa = paramJSONObject.optString("paying_rcvr_info", "");
    this.wKb = paramJSONObject.optString("succpage_rcvr_info", "");
    this.wJY = paramJSONObject.optInt("get_favor_flag", 0);
    this.wJZ = paramJSONObject.optInt("photo_style", 0);
    this.wKc = paramJSONObject.optInt("get_favor_interval", 400);
    this.wJW = b.B(paramJSONObject.optJSONArray("favor_list"));
    paramJSONObject = paramJSONObject.optJSONObject("favor_comm_resp");
    if (paramJSONObject != null)
    {
      this.wJX = new ou();
      this.wJX.EeK = paramJSONObject.optString("default_fav_compose_id");
      this.wJX.EeI = b.B(paramJSONObject.optJSONArray("favor_info_list"));
      this.wJX.EeL = paramJSONObject.optString("favor_resp_sign");
      this.wJX.EeM = paramJSONObject.optString("no_compose_wording");
      this.wJX.EeJ = b.A(paramJSONObject.optJSONArray("favor_compose_result_list"));
    }
    AppMethodBeat.o(67834);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(67836);
    paramParcel.writeInt(this.wJQ);
    paramParcel.writeString(this.wJR);
    paramParcel.writeString(this.wJS);
    paramParcel.writeInt(this.wJT);
    paramParcel.writeString(this.wJU);
    paramParcel.writeString(this.wJV);
    paramParcel.writeInt(this.wJY);
    paramParcel.writeInt(this.wJZ);
    paramParcel.writeString(this.wKa);
    paramParcel.writeString(this.wKb);
    paramParcel.writeInt(this.wKc);
    paramParcel.writeInt(this.wJW.size());
    if (this.wJW.size() > 0)
    {
      paramInt = 0;
      for (;;)
      {
        if (paramInt < this.wJW.size())
        {
          Object localObject1 = (aie)this.wJW.get(paramInt);
          try
          {
            localObject1 = ((aie)localObject1).toByteArray();
            paramParcel.writeInt(localObject1.length);
            if (localObject1.length > 0) {
              paramParcel.writeByteArray((byte[])localObject1);
            }
            paramInt += 1;
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              ac.printErrStackTrace("MicroMsg.BusiRemittanceResp", localException1, "", new Object[0]);
              localObject2 = new byte[0];
            }
          }
        }
      }
    }
    Object localObject2 = new byte[0];
    try
    {
      byte[] arrayOfByte = this.wJX.toByteArray();
      localObject2 = arrayOfByte;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.BusiRemittanceResp", localException2, "", new Object[0]);
      }
    }
    paramParcel.writeInt(localObject2.length);
    if (localObject2.length > 0) {
      paramParcel.writeByteArray((byte[])localObject2);
    }
    AppMethodBeat.o(67836);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.BusiRemittanceResp
 * JD-Core Version:    0.7.0.1
 */