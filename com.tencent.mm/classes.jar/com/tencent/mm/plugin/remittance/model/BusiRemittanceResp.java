package com.tencent.mm.plugin.remittance.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ahf;
import com.tencent.mm.protocal.protobuf.on;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

public class BusiRemittanceResp
  implements Parcelable
{
  public static final Parcelable.Creator<BusiRemittanceResp> CREATOR;
  public int vzL;
  public String vzM;
  public String vzN;
  public int vzO;
  public String vzP;
  public String vzQ;
  public List<ahf> vzR;
  public on vzS;
  public int vzT;
  public int vzU;
  public String vzV;
  public String vzW;
  public int vzX;
  
  static
  {
    AppMethodBeat.i(67837);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(67837);
  }
  
  BusiRemittanceResp()
  {
    AppMethodBeat.i(67833);
    this.vzL = 0;
    this.vzM = "";
    this.vzN = "";
    this.vzR = new LinkedList();
    this.vzT = 0;
    this.vzU = 0;
    this.vzX = 400;
    AppMethodBeat.o(67833);
  }
  
  protected BusiRemittanceResp(Parcel paramParcel)
  {
    AppMethodBeat.i(67835);
    this.vzL = 0;
    this.vzM = "";
    this.vzN = "";
    this.vzR = new LinkedList();
    this.vzT = 0;
    this.vzU = 0;
    this.vzX = 400;
    this.vzL = paramParcel.readInt();
    this.vzM = paramParcel.readString();
    this.vzN = paramParcel.readString();
    this.vzO = paramParcel.readInt();
    this.vzP = paramParcel.readString();
    this.vzQ = paramParcel.readString();
    this.vzT = paramParcel.readInt();
    this.vzU = paramParcel.readInt();
    this.vzV = paramParcel.readString();
    this.vzW = paramParcel.readString();
    this.vzX = paramParcel.readInt();
    this.vzR = new LinkedList();
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
          ahf localahf = new ahf();
          localahf.parseFrom(arrayOfByte1);
          this.vzR.add(localahf);
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.BusiRemittanceResp", localException, "", new Object[0]);
          }
        }
      }
    }
    i = paramParcel.readInt();
    if (i > 0)
    {
      byte[] arrayOfByte2 = new byte[i];
      paramParcel.readByteArray(arrayOfByte2);
      this.vzS = new on();
      try
      {
        this.vzS.parseFrom(arrayOfByte2);
        AppMethodBeat.o(67835);
        return;
      }
      catch (Exception paramParcel)
      {
        ad.printErrStackTrace("MicroMsg.BusiRemittanceResp", paramParcel, "", new Object[0]);
      }
    }
    AppMethodBeat.o(67835);
  }
  
  BusiRemittanceResp(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(67834);
    this.vzL = 0;
    this.vzM = "";
    this.vzN = "";
    this.vzR = new LinkedList();
    this.vzT = 0;
    this.vzU = 0;
    this.vzX = 400;
    this.vzL = paramJSONObject.optInt("show_photo", 0);
    this.vzM = paramJSONObject.optString("photo_url", "");
    this.vzN = paramJSONObject.optString("favor_desc", "");
    this.vzO = paramJSONObject.optInt("scan_scene", 0);
    this.vzP = paramJSONObject.optString("favor_req_sign", "");
    this.vzQ = paramJSONObject.optString("favor_req_extend", "");
    this.vzV = paramJSONObject.optString("paying_rcvr_info", "");
    this.vzW = paramJSONObject.optString("succpage_rcvr_info", "");
    this.vzT = paramJSONObject.optInt("get_favor_flag", 0);
    this.vzU = paramJSONObject.optInt("photo_style", 0);
    this.vzX = paramJSONObject.optInt("get_favor_interval", 400);
    this.vzR = b.B(paramJSONObject.optJSONArray("favor_list"));
    paramJSONObject = paramJSONObject.optJSONObject("favor_comm_resp");
    if (paramJSONObject != null)
    {
      this.vzS = new on();
      this.vzS.CMi = paramJSONObject.optString("default_fav_compose_id");
      this.vzS.CMg = b.B(paramJSONObject.optJSONArray("favor_info_list"));
      this.vzS.CMj = paramJSONObject.optString("favor_resp_sign");
      this.vzS.CMk = paramJSONObject.optString("no_compose_wording");
      this.vzS.CMh = b.A(paramJSONObject.optJSONArray("favor_compose_result_list"));
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
    paramParcel.writeInt(this.vzL);
    paramParcel.writeString(this.vzM);
    paramParcel.writeString(this.vzN);
    paramParcel.writeInt(this.vzO);
    paramParcel.writeString(this.vzP);
    paramParcel.writeString(this.vzQ);
    paramParcel.writeInt(this.vzT);
    paramParcel.writeInt(this.vzU);
    paramParcel.writeString(this.vzV);
    paramParcel.writeString(this.vzW);
    paramParcel.writeInt(this.vzX);
    paramParcel.writeInt(this.vzR.size());
    if (this.vzR.size() > 0)
    {
      paramInt = 0;
      for (;;)
      {
        if (paramInt < this.vzR.size())
        {
          Object localObject1 = (ahf)this.vzR.get(paramInt);
          try
          {
            localObject1 = ((ahf)localObject1).toByteArray();
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
              ad.printErrStackTrace("MicroMsg.BusiRemittanceResp", localException1, "", new Object[0]);
              localObject2 = new byte[0];
            }
          }
        }
      }
    }
    Object localObject2 = new byte[0];
    try
    {
      byte[] arrayOfByte = this.vzS.toByteArray();
      localObject2 = arrayOfByte;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.BusiRemittanceResp", localException2, "", new Object[0]);
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