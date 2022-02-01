package com.tencent.mm.plugin.remittance.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ale;
import com.tencent.mm.protocal.protobuf.qb;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

public class BusiRemittanceResp
  implements Parcelable
{
  public static final Parcelable.Creator<BusiRemittanceResp> CREATOR;
  public String ynA;
  public int ynB;
  public int ynp;
  public String ynq;
  public String ynr;
  public int yns;
  public String ynt;
  public String ynu;
  public List<ale> ynv;
  public qb ynw;
  public int ynx;
  public int yny;
  public String ynz;
  
  static
  {
    AppMethodBeat.i(67837);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(67837);
  }
  
  BusiRemittanceResp()
  {
    AppMethodBeat.i(67833);
    this.ynp = 0;
    this.ynq = "";
    this.ynr = "";
    this.ynv = new LinkedList();
    this.ynx = 0;
    this.yny = 0;
    this.ynB = 400;
    AppMethodBeat.o(67833);
  }
  
  protected BusiRemittanceResp(Parcel paramParcel)
  {
    AppMethodBeat.i(67835);
    this.ynp = 0;
    this.ynq = "";
    this.ynr = "";
    this.ynv = new LinkedList();
    this.ynx = 0;
    this.yny = 0;
    this.ynB = 400;
    this.ynp = paramParcel.readInt();
    this.ynq = paramParcel.readString();
    this.ynr = paramParcel.readString();
    this.yns = paramParcel.readInt();
    this.ynt = paramParcel.readString();
    this.ynu = paramParcel.readString();
    this.ynx = paramParcel.readInt();
    this.yny = paramParcel.readInt();
    this.ynz = paramParcel.readString();
    this.ynA = paramParcel.readString();
    this.ynB = paramParcel.readInt();
    this.ynv = new LinkedList();
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
          ale localale = new ale();
          localale.parseFrom(arrayOfByte1);
          this.ynv.add(localale);
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ae.printErrStackTrace("MicroMsg.BusiRemittanceResp", localException, "", new Object[0]);
          }
        }
      }
    }
    i = paramParcel.readInt();
    if (i > 0)
    {
      byte[] arrayOfByte2 = new byte[i];
      paramParcel.readByteArray(arrayOfByte2);
      this.ynw = new qb();
      try
      {
        this.ynw.parseFrom(arrayOfByte2);
        AppMethodBeat.o(67835);
        return;
      }
      catch (Exception paramParcel)
      {
        ae.printErrStackTrace("MicroMsg.BusiRemittanceResp", paramParcel, "", new Object[0]);
      }
    }
    AppMethodBeat.o(67835);
  }
  
  BusiRemittanceResp(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(67834);
    this.ynp = 0;
    this.ynq = "";
    this.ynr = "";
    this.ynv = new LinkedList();
    this.ynx = 0;
    this.yny = 0;
    this.ynB = 400;
    this.ynp = paramJSONObject.optInt("show_photo", 0);
    this.ynq = paramJSONObject.optString("photo_url", "");
    this.ynr = paramJSONObject.optString("favor_desc", "");
    this.yns = paramJSONObject.optInt("scan_scene", 0);
    this.ynt = paramJSONObject.optString("favor_req_sign", "");
    this.ynu = paramJSONObject.optString("favor_req_extend", "");
    this.ynz = paramJSONObject.optString("paying_rcvr_info", "");
    this.ynA = paramJSONObject.optString("succpage_rcvr_info", "");
    this.ynx = paramJSONObject.optInt("get_favor_flag", 0);
    this.yny = paramJSONObject.optInt("photo_style", 0);
    this.ynB = paramJSONObject.optInt("get_favor_interval", 400);
    this.ynv = b.D(paramJSONObject.optJSONArray("favor_list"));
    paramJSONObject = paramJSONObject.optJSONObject("favor_comm_resp");
    if (paramJSONObject != null)
    {
      this.ynw = new qb();
      this.ynw.GdI = paramJSONObject.optString("default_fav_compose_id");
      this.ynw.GdG = b.D(paramJSONObject.optJSONArray("favor_info_list"));
      this.ynw.GdJ = paramJSONObject.optString("favor_resp_sign");
      this.ynw.GdK = paramJSONObject.optString("no_compose_wording");
      this.ynw.GdH = b.C(paramJSONObject.optJSONArray("favor_compose_result_list"));
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
    paramParcel.writeInt(this.ynp);
    paramParcel.writeString(this.ynq);
    paramParcel.writeString(this.ynr);
    paramParcel.writeInt(this.yns);
    paramParcel.writeString(this.ynt);
    paramParcel.writeString(this.ynu);
    paramParcel.writeInt(this.ynx);
    paramParcel.writeInt(this.yny);
    paramParcel.writeString(this.ynz);
    paramParcel.writeString(this.ynA);
    paramParcel.writeInt(this.ynB);
    paramParcel.writeInt(this.ynv.size());
    if (this.ynv.size() > 0)
    {
      paramInt = 0;
      for (;;)
      {
        if (paramInt < this.ynv.size())
        {
          Object localObject1 = (ale)this.ynv.get(paramInt);
          try
          {
            localObject1 = ((ale)localObject1).toByteArray();
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
              ae.printErrStackTrace("MicroMsg.BusiRemittanceResp", localException1, "", new Object[0]);
              localObject2 = new byte[0];
            }
          }
        }
      }
    }
    Object localObject2 = new byte[0];
    try
    {
      byte[] arrayOfByte = this.ynw.toByteArray();
      localObject2 = arrayOfByte;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.BusiRemittanceResp", localException2, "", new Object[0]);
      }
    }
    paramParcel.writeInt(localObject2.length);
    if (localObject2.length > 0) {
      paramParcel.writeByteArray((byte[])localObject2);
    }
    AppMethodBeat.o(67836);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.BusiRemittanceResp
 * JD-Core Version:    0.7.0.1
 */