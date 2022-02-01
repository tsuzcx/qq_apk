package com.tencent.mm.plugin.remittance.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aot;
import com.tencent.mm.protocal.protobuf.fib;
import com.tencent.mm.protocal.protobuf.fic;
import com.tencent.mm.protocal.protobuf.fid;
import com.tencent.mm.protocal.protobuf.qv;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

public class BusiRemittanceResp
  implements Parcelable
{
  public static final Parcelable.Creator<BusiRemittanceResp> CREATOR;
  public int IkY;
  public String IkZ;
  public String Ila;
  public int Ilb;
  public String Ilc;
  public String Ild;
  public List<aot> Ile;
  public qv Ilf;
  public fic Ilg;
  public int Ilh;
  public int Ili;
  public String Ilj;
  public String Ilk;
  public int Ill;
  
  static
  {
    AppMethodBeat.i(67837);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(67837);
  }
  
  BusiRemittanceResp()
  {
    AppMethodBeat.i(67833);
    this.IkY = 0;
    this.IkZ = "";
    this.Ila = "";
    this.Ile = new LinkedList();
    this.Ilh = 0;
    this.Ili = 0;
    this.Ill = 400;
    AppMethodBeat.o(67833);
  }
  
  protected BusiRemittanceResp(Parcel paramParcel)
  {
    AppMethodBeat.i(67835);
    this.IkY = 0;
    this.IkZ = "";
    this.Ila = "";
    this.Ile = new LinkedList();
    this.Ilh = 0;
    this.Ili = 0;
    this.Ill = 400;
    this.IkY = paramParcel.readInt();
    this.IkZ = paramParcel.readString();
    this.Ila = paramParcel.readString();
    this.Ilb = paramParcel.readInt();
    this.Ilc = paramParcel.readString();
    this.Ild = paramParcel.readString();
    this.Ilh = paramParcel.readInt();
    this.Ili = paramParcel.readInt();
    this.Ilj = paramParcel.readString();
    this.Ilk = paramParcel.readString();
    this.Ill = paramParcel.readInt();
    this.Ile = new LinkedList();
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
          aot localaot = new aot();
          localaot.parseFrom(arrayOfByte1);
          this.Ile.add(localaot);
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
      this.Ilf = new qv();
    }
    try
    {
      this.Ilf.parseFrom(arrayOfByte2);
      i = paramParcel.readInt();
      if (i > 0)
      {
        arrayOfByte2 = new byte[i];
        paramParcel.readByteArray(arrayOfByte2);
        this.Ilg = new fic();
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        try
        {
          this.Ilg.parseFrom(arrayOfByte2);
          AppMethodBeat.o(67835);
          return;
        }
        catch (Exception paramParcel)
        {
          Log.printErrStackTrace("MicroMsg.BusiRemittanceResp", paramParcel, "", new Object[0]);
        }
        localException2 = localException2;
        Log.printErrStackTrace("MicroMsg.BusiRemittanceResp", localException2, "", new Object[0]);
      }
      AppMethodBeat.o(67835);
    }
  }
  
  BusiRemittanceResp(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(67834);
    this.IkY = 0;
    this.IkZ = "";
    this.Ila = "";
    this.Ile = new LinkedList();
    this.Ilh = 0;
    this.Ili = 0;
    this.Ill = 400;
    this.IkY = paramJSONObject.optInt("show_photo", 0);
    this.IkZ = paramJSONObject.optString("photo_url", "");
    this.Ila = paramJSONObject.optString("favor_desc", "");
    this.Ilb = paramJSONObject.optInt("scan_scene", 0);
    this.Ilc = paramJSONObject.optString("favor_req_sign", "");
    this.Ild = paramJSONObject.optString("favor_req_extend", "");
    this.Ilj = paramJSONObject.optString("paying_rcvr_info", "");
    this.Ilk = paramJSONObject.optString("succpage_rcvr_info", "");
    this.Ilh = paramJSONObject.optInt("get_favor_flag", 0);
    this.Ili = paramJSONObject.optInt("photo_style", 0);
    this.Ill = paramJSONObject.optInt("get_favor_interval", 400);
    this.Ile = b.F(paramJSONObject.optJSONArray("favor_list"));
    JSONObject localJSONObject1 = paramJSONObject.optJSONObject("favor_comm_resp");
    if (localJSONObject1 != null)
    {
      this.Ilf = new qv();
      this.Ilf.RZi = localJSONObject1.optString("default_fav_compose_id");
      this.Ilf.RZg = b.F(localJSONObject1.optJSONArray("favor_info_list"));
      this.Ilf.RZj = localJSONObject1.optString("favor_resp_sign");
      this.Ilf.RZk = localJSONObject1.optString("no_compose_wording");
      this.Ilf.RZh = b.E(localJSONObject1.optJSONArray("favor_compose_result_list"));
    }
    JSONObject localJSONObject2 = paramJSONObject.optJSONObject("notice");
    if (localJSONObject2 != null)
    {
      this.Ilg = new fic();
      this.Ilg.UHR = localJSONObject2.optInt("is_show_notice");
      fic localfic = this.Ilg;
      localJSONObject1 = localJSONObject2.optJSONObject("text_info");
      fid localfid = new fid();
      paramJSONObject = localJSONObject1;
      if (localJSONObject1 == null) {
        paramJSONObject = new JSONObject();
      }
      localfid.wording = paramJSONObject.optString("wording");
      localJSONObject1 = paramJSONObject.optJSONObject("jump_info");
      fib localfib = new fib();
      paramJSONObject = localJSONObject1;
      if (localJSONObject1 == null) {
        paramJSONObject = new JSONObject();
      }
      localfib.type = paramJSONObject.optInt("type");
      localfib.url = paramJSONObject.optString("url");
      localfib.username = paramJSONObject.optString("username");
      localfib.InB = paramJSONObject.optString("pagepath");
      localfid.UHY = localfib;
      localfic.UHS = localfid;
      this.Ilg.Uba = localJSONObject2.optString("text_color");
      this.Ilg.UHT = localJSONObject2.optString("text_dark_color");
      this.Ilg.UHU = localJSONObject2.optString("lefticon");
      this.Ilg.UHV = localJSONObject2.optString("lefticon_dark");
      this.Ilg.UHW = localJSONObject2.optString("righticon");
      this.Ilg.UHX = localJSONObject2.optString("righticon_dark");
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
    paramParcel.writeInt(this.IkY);
    paramParcel.writeString(this.IkZ);
    paramParcel.writeString(this.Ila);
    paramParcel.writeInt(this.Ilb);
    paramParcel.writeString(this.Ilc);
    paramParcel.writeString(this.Ild);
    paramParcel.writeInt(this.Ilh);
    paramParcel.writeInt(this.Ili);
    paramParcel.writeString(this.Ilj);
    paramParcel.writeString(this.Ilk);
    paramParcel.writeInt(this.Ill);
    paramParcel.writeInt(this.Ile.size());
    if (this.Ile.size() > 0)
    {
      paramInt = 0;
      for (;;)
      {
        if (paramInt < this.Ile.size())
        {
          Object localObject1 = (aot)this.Ile.get(paramInt);
          try
          {
            localObject1 = ((aot)localObject1).toByteArray();
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
      arrayOfByte = this.Ilf.toByteArray();
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
      arrayOfByte = this.Ilg.toByteArray();
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
    AppMethodBeat.o(67836);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.BusiRemittanceResp
 * JD-Core Version:    0.7.0.1
 */