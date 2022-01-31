package com.tencent.mm.plugin.remittance.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.protocal.c.jy;
import com.tencent.mm.protocal.c.za;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

public class BusiRemittanceResp
  implements Parcelable
{
  public static final Parcelable.Creator<BusiRemittanceResp> CREATOR = new BusiRemittanceResp.1();
  public int nxL = 0;
  public String nxM = "";
  public String nxN = "";
  public int nxO;
  public String nxP;
  public String nxQ;
  public List<za> nxR = new LinkedList();
  public jy nxS;
  public int nxT = 0;
  public int nxU = 0;
  public int nxV = 400;
  
  BusiRemittanceResp() {}
  
  protected BusiRemittanceResp(Parcel paramParcel)
  {
    this.nxL = paramParcel.readInt();
    this.nxM = paramParcel.readString();
    this.nxN = paramParcel.readString();
    this.nxO = paramParcel.readInt();
    this.nxP = paramParcel.readString();
    this.nxQ = paramParcel.readString();
    this.nxT = paramParcel.readInt();
    this.nxU = paramParcel.readInt();
    this.nxV = paramParcel.readInt();
    this.nxR = new LinkedList();
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
          za localza = new za();
          localza.aH(arrayOfByte1);
          this.nxR.add(localza);
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            y.printErrStackTrace("MicroMsg.BusiRemittanceResp", localException, "", new Object[0]);
          }
        }
      }
    }
    i = paramParcel.readInt();
    byte[] arrayOfByte2;
    if (i > 0)
    {
      arrayOfByte2 = new byte[i];
      paramParcel.readByteArray(arrayOfByte2);
      this.nxS = new jy();
    }
    try
    {
      this.nxS.aH(arrayOfByte2);
      return;
    }
    catch (Exception paramParcel)
    {
      y.printErrStackTrace("MicroMsg.BusiRemittanceResp", paramParcel, "", new Object[0]);
    }
  }
  
  BusiRemittanceResp(JSONObject paramJSONObject)
  {
    this.nxL = paramJSONObject.optInt("show_photo", 0);
    this.nxM = paramJSONObject.optString("photo_url", "");
    this.nxN = paramJSONObject.optString("favor_desc", "");
    this.nxO = paramJSONObject.optInt("scan_scene", 0);
    this.nxP = paramJSONObject.optString("favor_req_sign", "");
    this.nxQ = paramJSONObject.optString("favor_req_extend", "");
    this.nxT = paramJSONObject.optInt("get_favor_flag", 0);
    this.nxU = paramJSONObject.optInt("photo_style", 0);
    this.nxV = paramJSONObject.optInt("get_favor_interval", 400);
    this.nxR = b.u(paramJSONObject.optJSONArray("favor_list"));
    paramJSONObject = paramJSONObject.optJSONObject("favor_comm_resp");
    if (paramJSONObject != null)
    {
      this.nxS = new jy();
      this.nxS.sEL = paramJSONObject.optString("default_fav_compose_id");
      this.nxS.sEJ = b.u(paramJSONObject.optJSONArray("favor_info_list"));
      this.nxS.sEM = paramJSONObject.optString("favor_resp_sign");
      this.nxS.sEN = paramJSONObject.optString("no_compose_wording");
      this.nxS.sEK = b.t(paramJSONObject.optJSONArray("favor_compose_result_list"));
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.nxL);
    paramParcel.writeString(this.nxM);
    paramParcel.writeString(this.nxN);
    paramParcel.writeInt(this.nxO);
    paramParcel.writeString(this.nxP);
    paramParcel.writeString(this.nxQ);
    paramParcel.writeInt(this.nxT);
    paramParcel.writeInt(this.nxU);
    paramParcel.writeInt(this.nxV);
    paramParcel.writeInt(this.nxR.size());
    if (this.nxR.size() > 0)
    {
      paramInt = 0;
      for (;;)
      {
        if (paramInt < this.nxR.size())
        {
          Object localObject1 = (za)this.nxR.get(paramInt);
          try
          {
            localObject1 = ((za)localObject1).toByteArray();
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
              y.printErrStackTrace("MicroMsg.BusiRemittanceResp", localException1, "", new Object[0]);
              localObject2 = new byte[0];
            }
          }
        }
      }
    }
    Object localObject2 = new byte[0];
    try
    {
      byte[] arrayOfByte = this.nxS.toByteArray();
      localObject2 = arrayOfByte;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.BusiRemittanceResp", localException2, "", new Object[0]);
      }
    }
    paramParcel.writeInt(localObject2.length);
    if (localObject2.length > 0) {
      paramParcel.writeByteArray((byte[])localObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.BusiRemittanceResp
 * JD-Core Version:    0.7.0.1
 */