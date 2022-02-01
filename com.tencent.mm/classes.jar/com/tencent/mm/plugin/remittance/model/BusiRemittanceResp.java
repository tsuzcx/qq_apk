package com.tencent.mm.plugin.remittance.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.apv;
import com.tencent.mm.protocal.protobuf.asm;
import com.tencent.mm.protocal.protobuf.gen;
import com.tencent.mm.protocal.protobuf.geo;
import com.tencent.mm.protocal.protobuf.gep;
import com.tencent.mm.protocal.protobuf.sg;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

public class BusiRemittanceResp
  implements Parcelable
{
  public static final Parcelable.Creator<BusiRemittanceResp> CREATOR;
  public int OhM;
  public String OhN;
  public String OhO;
  public int OhP;
  public String OhQ;
  public String OhR;
  public List<asm> OhS;
  public sg OhT;
  public geo OhU;
  public int OhV;
  public int OhW;
  public String OhX;
  public String OhY;
  public int OhZ;
  public apv Oia;
  public String Oib;
  public String Oic;
  
  static
  {
    AppMethodBeat.i(67837);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(67837);
  }
  
  BusiRemittanceResp()
  {
    AppMethodBeat.i(67833);
    this.OhM = 0;
    this.OhN = "";
    this.OhO = "";
    this.OhS = new LinkedList();
    this.OhV = 0;
    this.OhW = 0;
    this.OhZ = 400;
    AppMethodBeat.o(67833);
  }
  
  protected BusiRemittanceResp(Parcel paramParcel)
  {
    AppMethodBeat.i(67835);
    this.OhM = 0;
    this.OhN = "";
    this.OhO = "";
    this.OhS = new LinkedList();
    this.OhV = 0;
    this.OhW = 0;
    this.OhZ = 400;
    this.OhM = paramParcel.readInt();
    this.OhN = paramParcel.readString();
    this.OhO = paramParcel.readString();
    this.OhP = paramParcel.readInt();
    this.OhQ = paramParcel.readString();
    this.OhR = paramParcel.readString();
    this.OhV = paramParcel.readInt();
    this.OhW = paramParcel.readInt();
    this.OhX = paramParcel.readString();
    this.OhY = paramParcel.readString();
    this.OhZ = paramParcel.readInt();
    this.OhS = new LinkedList();
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
          asm localasm = new asm();
          localasm.parseFrom(arrayOfByte1);
          this.OhS.add(localasm);
          i += 1;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.BusiRemittanceResp", localException1, "", new Object[0]);
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
      this.OhT = new sg();
    }
    try
    {
      this.OhT.parseFrom(arrayOfByte2);
      i = paramParcel.readInt();
      if (i > 0)
      {
        arrayOfByte2 = new byte[i];
        paramParcel.readByteArray(arrayOfByte2);
        this.OhU = new geo();
      }
    }
    catch (Exception localException3)
    {
      try
      {
        this.OhU.parseFrom(arrayOfByte2);
        i = paramParcel.readInt();
        if (i > 0)
        {
          arrayOfByte2 = new byte[i];
          paramParcel.readByteArray(arrayOfByte2);
          this.Oia = new apv();
        }
      }
      catch (Exception localException3)
      {
        try
        {
          for (;;)
          {
            this.Oia.parseFrom(arrayOfByte2);
            this.Oib = paramParcel.readString();
            this.Oic = paramParcel.readString();
            AppMethodBeat.o(67835);
            return;
            localException2 = localException2;
            Log.printErrStackTrace("MicroMsg.BusiRemittanceResp", localException2, "", new Object[0]);
          }
          localException3 = localException3;
          Log.printErrStackTrace("MicroMsg.BusiRemittanceResp", localException3, "", new Object[0]);
        }
        catch (Exception localException4)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.BusiRemittanceResp", localException4, "", new Object[0]);
          }
        }
      }
    }
  }
  
  BusiRemittanceResp(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(67834);
    this.OhM = 0;
    this.OhN = "";
    this.OhO = "";
    this.OhS = new LinkedList();
    this.OhV = 0;
    this.OhW = 0;
    this.OhZ = 400;
    this.OhM = paramJSONObject.optInt("show_photo", 0);
    this.OhN = paramJSONObject.optString("photo_url", "");
    this.OhO = paramJSONObject.optString("favor_desc", "");
    this.OhP = paramJSONObject.optInt("scan_scene", 0);
    this.OhQ = paramJSONObject.optString("favor_req_sign", "");
    this.OhR = paramJSONObject.optString("favor_req_extend", "");
    this.OhX = paramJSONObject.optString("paying_rcvr_info", "");
    this.OhY = paramJSONObject.optString("succpage_rcvr_info", "");
    this.OhV = paramJSONObject.optInt("get_favor_flag", 0);
    this.OhW = paramJSONObject.optInt("photo_style", 0);
    this.OhZ = paramJSONObject.optInt("get_favor_interval", 400);
    this.OhS = c.K(paramJSONObject.optJSONArray("favor_list"));
    Object localObject = paramJSONObject.optJSONObject("favor_comm_resp");
    if (localObject != null)
    {
      this.OhT = new sg();
      this.OhT.YXi = ((JSONObject)localObject).optString("default_fav_compose_id");
      this.OhT.YXg = c.K(((JSONObject)localObject).optJSONArray("favor_info_list"));
      this.OhT.OiL = ((JSONObject)localObject).optString("favor_resp_sign");
      this.OhT.YXj = ((JSONObject)localObject).optString("no_compose_wording");
      this.OhT.YXh = c.J(((JSONObject)localObject).optJSONArray("favor_compose_result_list"));
    }
    JSONObject localJSONObject2 = paramJSONObject.optJSONObject("notice");
    if (localJSONObject2 != null)
    {
      this.OhU = new geo();
      this.OhU.abaE = localJSONObject2.optInt("is_show_notice");
      geo localgeo = this.OhU;
      JSONObject localJSONObject1 = localJSONObject2.optJSONObject("text_info");
      gep localgep = new gep();
      localObject = localJSONObject1;
      if (localJSONObject1 == null) {
        localObject = new JSONObject();
      }
      localgep.wording = ((JSONObject)localObject).optString("wording");
      localJSONObject1 = ((JSONObject)localObject).optJSONObject("jump_info");
      gen localgen = new gen();
      localObject = localJSONObject1;
      if (localJSONObject1 == null) {
        localObject = new JSONObject();
      }
      localgen.type = ((JSONObject)localObject).optInt("type");
      localgen.url = ((JSONObject)localObject).optString("url");
      localgen.username = ((JSONObject)localObject).optString("username");
      localgen.OkP = ((JSONObject)localObject).optString("pagepath");
      localgep.accg = localgen;
      localgeo.acca = localgep;
      this.OhU.absh = localJSONObject2.optString("text_color");
      this.OhU.accb = localJSONObject2.optString("text_dark_color");
      this.OhU.accc = localJSONObject2.optString("lefticon");
      this.OhU.accd = localJSONObject2.optString("lefticon_dark");
      this.OhU.acce = localJSONObject2.optString("righticon");
      this.OhU.accf = localJSONObject2.optString("righticon_dark");
    }
    localObject = paramJSONObject.optJSONObject("extra_buy");
    if (localObject != null)
    {
      this.Oia = new apv();
      this.Oia.Zxi = ((JSONObject)localObject).optString("select_wording");
      this.Oia.title = ((JSONObject)localObject).optString("title");
      this.Oia.Oiy = a.I(((JSONObject)localObject).optJSONArray("extra_buy_detail_infos"));
    }
    this.Oib = paramJSONObject.optString("favor_title");
    this.Oic = paramJSONObject.optString("extra_buy_title");
    AppMethodBeat.o(67834);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(67836);
    paramParcel.writeInt(this.OhM);
    paramParcel.writeString(this.OhN);
    paramParcel.writeString(this.OhO);
    paramParcel.writeInt(this.OhP);
    paramParcel.writeString(this.OhQ);
    paramParcel.writeString(this.OhR);
    paramParcel.writeInt(this.OhV);
    paramParcel.writeInt(this.OhW);
    paramParcel.writeString(this.OhX);
    paramParcel.writeString(this.OhY);
    paramParcel.writeInt(this.OhZ);
    paramParcel.writeInt(this.OhS.size());
    if (this.OhS.size() > 0)
    {
      paramInt = 0;
      for (;;)
      {
        if (paramInt < this.OhS.size())
        {
          Object localObject1 = (asm)this.OhS.get(paramInt);
          try
          {
            localObject1 = ((asm)localObject1).toByteArray();
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
      arrayOfByte = this.OhT.toByteArray();
      localObject2 = arrayOfByte;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        byte[] arrayOfByte;
        Log.printErrStackTrace("MicroMsg.BusiRemittanceResp", localException2, "", new Object[0]);
      }
    }
    paramParcel.writeInt(localObject2.length);
    if (localObject2.length > 0) {
      paramParcel.writeByteArray((byte[])localObject2);
    }
    localObject2 = new byte[0];
    try
    {
      arrayOfByte = this.OhU.toByteArray();
      localObject2 = arrayOfByte;
    }
    catch (Exception localException3)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.BusiRemittanceResp", localException3, "", new Object[0]);
      }
    }
    paramParcel.writeInt(localObject2.length);
    if (localObject2.length > 0) {
      paramParcel.writeByteArray((byte[])localObject2);
    }
    localObject2 = new byte[0];
    try
    {
      arrayOfByte = this.Oia.toByteArray();
      localObject2 = arrayOfByte;
    }
    catch (Exception localException4)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.BusiRemittanceResp", localException4, "", new Object[0]);
      }
    }
    paramParcel.writeInt(localObject2.length);
    if (localObject2.length > 0) {
      paramParcel.writeByteArray((byte[])localObject2);
    }
    paramParcel.writeString(this.Oib);
    paramParcel.writeString(this.Oic);
    AppMethodBeat.o(67836);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.BusiRemittanceResp
 * JD-Core Version:    0.7.0.1
 */