package com.tencent.mm.plugin.remittance.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ans;
import com.tencent.mm.protocal.protobuf.rc;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

public class BusiRemittanceResp
  implements Parcelable
{
  public static final Parcelable.Creator<BusiRemittanceResp> CREATOR;
  public int Cof;
  public String Cog;
  public String Coh;
  public int Coi;
  public String Coj;
  public String Cok;
  public List<ans> Col;
  public rc Com;
  public int Con;
  public int Coo;
  public String Cop;
  public String Coq;
  public int Cor;
  
  static
  {
    AppMethodBeat.i(67837);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(67837);
  }
  
  BusiRemittanceResp()
  {
    AppMethodBeat.i(67833);
    this.Cof = 0;
    this.Cog = "";
    this.Coh = "";
    this.Col = new LinkedList();
    this.Con = 0;
    this.Coo = 0;
    this.Cor = 400;
    AppMethodBeat.o(67833);
  }
  
  protected BusiRemittanceResp(Parcel paramParcel)
  {
    AppMethodBeat.i(67835);
    this.Cof = 0;
    this.Cog = "";
    this.Coh = "";
    this.Col = new LinkedList();
    this.Con = 0;
    this.Coo = 0;
    this.Cor = 400;
    this.Cof = paramParcel.readInt();
    this.Cog = paramParcel.readString();
    this.Coh = paramParcel.readString();
    this.Coi = paramParcel.readInt();
    this.Coj = paramParcel.readString();
    this.Cok = paramParcel.readString();
    this.Con = paramParcel.readInt();
    this.Coo = paramParcel.readInt();
    this.Cop = paramParcel.readString();
    this.Coq = paramParcel.readString();
    this.Cor = paramParcel.readInt();
    this.Col = new LinkedList();
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
          ans localans = new ans();
          localans.parseFrom(arrayOfByte1);
          this.Col.add(localans);
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.BusiRemittanceResp", localException, "", new Object[0]);
          }
        }
      }
    }
    i = paramParcel.readInt();
    if (i > 0)
    {
      byte[] arrayOfByte2 = new byte[i];
      paramParcel.readByteArray(arrayOfByte2);
      this.Com = new rc();
      try
      {
        this.Com.parseFrom(arrayOfByte2);
        AppMethodBeat.o(67835);
        return;
      }
      catch (Exception paramParcel)
      {
        Log.printErrStackTrace("MicroMsg.BusiRemittanceResp", paramParcel, "", new Object[0]);
      }
    }
    AppMethodBeat.o(67835);
  }
  
  BusiRemittanceResp(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(67834);
    this.Cof = 0;
    this.Cog = "";
    this.Coh = "";
    this.Col = new LinkedList();
    this.Con = 0;
    this.Coo = 0;
    this.Cor = 400;
    this.Cof = paramJSONObject.optInt("show_photo", 0);
    this.Cog = paramJSONObject.optString("photo_url", "");
    this.Coh = paramJSONObject.optString("favor_desc", "");
    this.Coi = paramJSONObject.optInt("scan_scene", 0);
    this.Coj = paramJSONObject.optString("favor_req_sign", "");
    this.Cok = paramJSONObject.optString("favor_req_extend", "");
    this.Cop = paramJSONObject.optString("paying_rcvr_info", "");
    this.Coq = paramJSONObject.optString("succpage_rcvr_info", "");
    this.Con = paramJSONObject.optInt("get_favor_flag", 0);
    this.Coo = paramJSONObject.optInt("photo_style", 0);
    this.Cor = paramJSONObject.optInt("get_favor_interval", 400);
    this.Col = b.E(paramJSONObject.optJSONArray("favor_list"));
    paramJSONObject = paramJSONObject.optJSONObject("favor_comm_resp");
    if (paramJSONObject != null)
    {
      this.Com = new rc();
      this.Com.KXZ = paramJSONObject.optString("default_fav_compose_id");
      this.Com.KXX = b.E(paramJSONObject.optJSONArray("favor_info_list"));
      this.Com.KYa = paramJSONObject.optString("favor_resp_sign");
      this.Com.KYb = paramJSONObject.optString("no_compose_wording");
      this.Com.KXY = b.D(paramJSONObject.optJSONArray("favor_compose_result_list"));
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
    paramParcel.writeInt(this.Cof);
    paramParcel.writeString(this.Cog);
    paramParcel.writeString(this.Coh);
    paramParcel.writeInt(this.Coi);
    paramParcel.writeString(this.Coj);
    paramParcel.writeString(this.Cok);
    paramParcel.writeInt(this.Con);
    paramParcel.writeInt(this.Coo);
    paramParcel.writeString(this.Cop);
    paramParcel.writeString(this.Coq);
    paramParcel.writeInt(this.Cor);
    paramParcel.writeInt(this.Col.size());
    if (this.Col.size() > 0)
    {
      paramInt = 0;
      for (;;)
      {
        if (paramInt < this.Col.size())
        {
          Object localObject1 = (ans)this.Col.get(paramInt);
          try
          {
            localObject1 = ((ans)localObject1).toByteArray();
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
              Log.printErrStackTrace("MicroMsg.BusiRemittanceResp", localException1, "", new Object[0]);
              localObject2 = new byte[0];
            }
          }
        }
      }
    }
    Object localObject2 = new byte[0];
    try
    {
      byte[] arrayOfByte = this.Com.toByteArray();
      localObject2 = arrayOfByte;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.BusiRemittanceResp", localException2, "", new Object[0]);
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