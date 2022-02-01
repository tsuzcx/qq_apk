package com.tencent.mm.plugin.remittance.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aku;
import com.tencent.mm.protocal.protobuf.pz;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

public class BusiRemittanceResp
  implements Parcelable
{
  public static final Parcelable.Creator<BusiRemittanceResp> CREATOR;
  public int xXA;
  public String xXB;
  public String xXC;
  public List<aku> xXD;
  public pz xXE;
  public int xXF;
  public int xXG;
  public String xXH;
  public String xXI;
  public int xXJ;
  public int xXx;
  public String xXy;
  public String xXz;
  
  static
  {
    AppMethodBeat.i(67837);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(67837);
  }
  
  BusiRemittanceResp()
  {
    AppMethodBeat.i(67833);
    this.xXx = 0;
    this.xXy = "";
    this.xXz = "";
    this.xXD = new LinkedList();
    this.xXF = 0;
    this.xXG = 0;
    this.xXJ = 400;
    AppMethodBeat.o(67833);
  }
  
  protected BusiRemittanceResp(Parcel paramParcel)
  {
    AppMethodBeat.i(67835);
    this.xXx = 0;
    this.xXy = "";
    this.xXz = "";
    this.xXD = new LinkedList();
    this.xXF = 0;
    this.xXG = 0;
    this.xXJ = 400;
    this.xXx = paramParcel.readInt();
    this.xXy = paramParcel.readString();
    this.xXz = paramParcel.readString();
    this.xXA = paramParcel.readInt();
    this.xXB = paramParcel.readString();
    this.xXC = paramParcel.readString();
    this.xXF = paramParcel.readInt();
    this.xXG = paramParcel.readInt();
    this.xXH = paramParcel.readString();
    this.xXI = paramParcel.readString();
    this.xXJ = paramParcel.readInt();
    this.xXD = new LinkedList();
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
          aku localaku = new aku();
          localaku.parseFrom(arrayOfByte1);
          this.xXD.add(localaku);
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
      this.xXE = new pz();
      try
      {
        this.xXE.parseFrom(arrayOfByte2);
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
    this.xXx = 0;
    this.xXy = "";
    this.xXz = "";
    this.xXD = new LinkedList();
    this.xXF = 0;
    this.xXG = 0;
    this.xXJ = 400;
    this.xXx = paramJSONObject.optInt("show_photo", 0);
    this.xXy = paramJSONObject.optString("photo_url", "");
    this.xXz = paramJSONObject.optString("favor_desc", "");
    this.xXA = paramJSONObject.optInt("scan_scene", 0);
    this.xXB = paramJSONObject.optString("favor_req_sign", "");
    this.xXC = paramJSONObject.optString("favor_req_extend", "");
    this.xXH = paramJSONObject.optString("paying_rcvr_info", "");
    this.xXI = paramJSONObject.optString("succpage_rcvr_info", "");
    this.xXF = paramJSONObject.optInt("get_favor_flag", 0);
    this.xXG = paramJSONObject.optInt("photo_style", 0);
    this.xXJ = paramJSONObject.optInt("get_favor_interval", 400);
    this.xXD = b.C(paramJSONObject.optJSONArray("favor_list"));
    paramJSONObject = paramJSONObject.optJSONObject("favor_comm_resp");
    if (paramJSONObject != null)
    {
      this.xXE = new pz();
      this.xXE.FLj = paramJSONObject.optString("default_fav_compose_id");
      this.xXE.FLh = b.C(paramJSONObject.optJSONArray("favor_info_list"));
      this.xXE.FLk = paramJSONObject.optString("favor_resp_sign");
      this.xXE.FLl = paramJSONObject.optString("no_compose_wording");
      this.xXE.FLi = b.B(paramJSONObject.optJSONArray("favor_compose_result_list"));
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
    paramParcel.writeInt(this.xXx);
    paramParcel.writeString(this.xXy);
    paramParcel.writeString(this.xXz);
    paramParcel.writeInt(this.xXA);
    paramParcel.writeString(this.xXB);
    paramParcel.writeString(this.xXC);
    paramParcel.writeInt(this.xXF);
    paramParcel.writeInt(this.xXG);
    paramParcel.writeString(this.xXH);
    paramParcel.writeString(this.xXI);
    paramParcel.writeInt(this.xXJ);
    paramParcel.writeInt(this.xXD.size());
    if (this.xXD.size() > 0)
    {
      paramInt = 0;
      for (;;)
      {
        if (paramInt < this.xXD.size())
        {
          Object localObject1 = (aku)this.xXD.get(paramInt);
          try
          {
            localObject1 = ((aku)localObject1).toByteArray();
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
      byte[] arrayOfByte = this.xXE.toByteArray();
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