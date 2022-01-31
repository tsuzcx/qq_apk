package com.tencent.mm.plugin.remittance.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.adh;
import com.tencent.mm.protocal.protobuf.mk;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

public class BusiRemittanceResp
  implements Parcelable
{
  public static final Parcelable.Creator<BusiRemittanceResp> CREATOR;
  public int qiM;
  public String qiN;
  public String qiO;
  public int qiP;
  public String qiQ;
  public String qiR;
  public List<adh> qiS;
  public mk qiT;
  public int qiU;
  public int qiV;
  public int qiW;
  
  static
  {
    AppMethodBeat.i(44726);
    CREATOR = new BusiRemittanceResp.1();
    AppMethodBeat.o(44726);
  }
  
  BusiRemittanceResp()
  {
    AppMethodBeat.i(44722);
    this.qiM = 0;
    this.qiN = "";
    this.qiO = "";
    this.qiS = new LinkedList();
    this.qiU = 0;
    this.qiV = 0;
    this.qiW = 400;
    AppMethodBeat.o(44722);
  }
  
  protected BusiRemittanceResp(Parcel paramParcel)
  {
    AppMethodBeat.i(44724);
    this.qiM = 0;
    this.qiN = "";
    this.qiO = "";
    this.qiS = new LinkedList();
    this.qiU = 0;
    this.qiV = 0;
    this.qiW = 400;
    this.qiM = paramParcel.readInt();
    this.qiN = paramParcel.readString();
    this.qiO = paramParcel.readString();
    this.qiP = paramParcel.readInt();
    this.qiQ = paramParcel.readString();
    this.qiR = paramParcel.readString();
    this.qiU = paramParcel.readInt();
    this.qiV = paramParcel.readInt();
    this.qiW = paramParcel.readInt();
    this.qiS = new LinkedList();
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
          adh localadh = new adh();
          localadh.parseFrom(arrayOfByte1);
          this.qiS.add(localadh);
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ab.printErrStackTrace("MicroMsg.BusiRemittanceResp", localException, "", new Object[0]);
          }
        }
      }
    }
    i = paramParcel.readInt();
    if (i > 0)
    {
      byte[] arrayOfByte2 = new byte[i];
      paramParcel.readByteArray(arrayOfByte2);
      this.qiT = new mk();
      try
      {
        this.qiT.parseFrom(arrayOfByte2);
        AppMethodBeat.o(44724);
        return;
      }
      catch (Exception paramParcel)
      {
        ab.printErrStackTrace("MicroMsg.BusiRemittanceResp", paramParcel, "", new Object[0]);
      }
    }
    AppMethodBeat.o(44724);
  }
  
  BusiRemittanceResp(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(44723);
    this.qiM = 0;
    this.qiN = "";
    this.qiO = "";
    this.qiS = new LinkedList();
    this.qiU = 0;
    this.qiV = 0;
    this.qiW = 400;
    this.qiM = paramJSONObject.optInt("show_photo", 0);
    this.qiN = paramJSONObject.optString("photo_url", "");
    this.qiO = paramJSONObject.optString("favor_desc", "");
    this.qiP = paramJSONObject.optInt("scan_scene", 0);
    this.qiQ = paramJSONObject.optString("favor_req_sign", "");
    this.qiR = paramJSONObject.optString("favor_req_extend", "");
    this.qiU = paramJSONObject.optInt("get_favor_flag", 0);
    this.qiV = paramJSONObject.optInt("photo_style", 0);
    this.qiW = paramJSONObject.optInt("get_favor_interval", 400);
    this.qiS = b.z(paramJSONObject.optJSONArray("favor_list"));
    paramJSONObject = paramJSONObject.optJSONObject("favor_comm_resp");
    if (paramJSONObject != null)
    {
      this.qiT = new mk();
      this.qiT.wAU = paramJSONObject.optString("default_fav_compose_id");
      this.qiT.wAS = b.z(paramJSONObject.optJSONArray("favor_info_list"));
      this.qiT.wAV = paramJSONObject.optString("favor_resp_sign");
      this.qiT.wAW = paramJSONObject.optString("no_compose_wording");
      this.qiT.wAT = b.y(paramJSONObject.optJSONArray("favor_compose_result_list"));
    }
    AppMethodBeat.o(44723);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(44725);
    paramParcel.writeInt(this.qiM);
    paramParcel.writeString(this.qiN);
    paramParcel.writeString(this.qiO);
    paramParcel.writeInt(this.qiP);
    paramParcel.writeString(this.qiQ);
    paramParcel.writeString(this.qiR);
    paramParcel.writeInt(this.qiU);
    paramParcel.writeInt(this.qiV);
    paramParcel.writeInt(this.qiW);
    paramParcel.writeInt(this.qiS.size());
    if (this.qiS.size() > 0)
    {
      paramInt = 0;
      for (;;)
      {
        if (paramInt < this.qiS.size())
        {
          Object localObject1 = (adh)this.qiS.get(paramInt);
          try
          {
            localObject1 = ((adh)localObject1).toByteArray();
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
              ab.printErrStackTrace("MicroMsg.BusiRemittanceResp", localException1, "", new Object[0]);
              localObject2 = new byte[0];
            }
          }
        }
      }
    }
    Object localObject2 = new byte[0];
    try
    {
      byte[] arrayOfByte = this.qiT.toByteArray();
      localObject2 = arrayOfByte;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.BusiRemittanceResp", localException2, "", new Object[0]);
      }
    }
    paramParcel.writeInt(localObject2.length);
    if (localObject2.length > 0) {
      paramParcel.writeByteArray((byte[])localObject2);
    }
    AppMethodBeat.o(44725);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.BusiRemittanceResp
 * JD-Core Version:    0.7.0.1
 */