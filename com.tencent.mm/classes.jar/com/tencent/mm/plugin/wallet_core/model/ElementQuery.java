package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class ElementQuery
  implements Parcelable
{
  public static String BvO;
  public static final Parcelable.Creator<ElementQuery> CREATOR;
  public int BoU;
  public String BtG;
  public String BvP;
  public boolean BvQ;
  public boolean BvR;
  public boolean BvS;
  public boolean BvT;
  public String BvU;
  public String BvV;
  public boolean BvW;
  public int BvX;
  public int BvY;
  public String BvZ;
  public String Bwa;
  public String Bwb;
  public String Bwc;
  public String Bwd;
  public String Bwe;
  public boolean Bwf;
  public boolean Bwg;
  public boolean Bwh;
  public boolean Bwi;
  public boolean Bwj;
  public boolean Bwk;
  public boolean Bwl;
  public boolean Bwm;
  public boolean Bwn;
  public String Bwo;
  private List<Integer> Bwp;
  public boolean Bwq;
  public String Bwr;
  public int Bws;
  public ArrayList<CreTypeRuleInfo> Bwt;
  public boolean Bwu;
  public JSONObject cFq;
  public String cZz;
  public String tGS;
  public String vwo;
  
  static
  {
    AppMethodBeat.i(70274);
    BvO = "bind_serial";
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(70274);
  }
  
  public ElementQuery()
  {
    this.Bwp = null;
    this.Bwu = false;
  }
  
  public ElementQuery(Parcel paramParcel)
  {
    AppMethodBeat.i(70272);
    this.Bwp = null;
    this.Bwu = false;
    this.vwo = paramParcel.readString();
    this.tGS = paramParcel.readString();
    this.BvP = paramParcel.readString();
    if (1 == paramParcel.readInt())
    {
      bool1 = true;
      this.BvQ = bool1;
      if (1 != paramParcel.readInt()) {
        break label437;
      }
      bool1 = true;
      label70:
      this.BvR = bool1;
      if (1 != paramParcel.readInt()) {
        break label442;
      }
      bool1 = true;
      label85:
      this.BvS = bool1;
      if (1 != paramParcel.readInt()) {
        break label447;
      }
      bool1 = true;
      label100:
      this.BvT = bool1;
      this.BvV = paramParcel.readString();
      this.vwo = paramParcel.readString();
      if (1 != paramParcel.readInt()) {
        break label452;
      }
      bool1 = true;
      label131:
      this.BvW = bool1;
      this.BvX = paramParcel.readInt();
      this.BvY = paramParcel.readInt();
      this.cZz = paramParcel.readString();
      this.BvZ = paramParcel.readString();
      this.Bwa = paramParcel.readString();
      this.Bwb = paramParcel.readString();
      this.Bwe = paramParcel.readString();
      this.Bwd = paramParcel.readString();
      this.Bwc = paramParcel.readString();
      if (1 != paramParcel.readInt()) {
        break label457;
      }
      bool1 = true;
      label218:
      this.Bwf = bool1;
      if (1 != paramParcel.readInt()) {
        break label462;
      }
      bool1 = true;
      label233:
      this.Bwg = bool1;
      if (1 != paramParcel.readInt()) {
        break label467;
      }
      bool1 = true;
      label248:
      this.Bwh = bool1;
      if (1 != paramParcel.readInt()) {
        break label472;
      }
      bool1 = true;
      label263:
      this.Bwi = bool1;
      if (1 != paramParcel.readInt()) {
        break label477;
      }
      bool1 = true;
      label278:
      this.Bwj = bool1;
      if (1 != paramParcel.readInt()) {
        break label482;
      }
      bool1 = true;
      label293:
      this.Bwk = bool1;
      if (1 != paramParcel.readInt()) {
        break label487;
      }
      bool1 = true;
      label308:
      this.Bwm = bool1;
      if (1 != paramParcel.readInt()) {
        break label492;
      }
      bool1 = true;
      label323:
      this.Bwl = bool1;
      if (1 != paramParcel.readInt()) {
        break label497;
      }
      bool1 = true;
      label338:
      this.Bwn = bool1;
      this.BoU = paramParcel.readInt();
      this.Bwo = paramParcel.readString();
      if (1 != paramParcel.readInt()) {
        break label502;
      }
      bool1 = true;
      label369:
      this.Bwu = bool1;
      this.BtG = paramParcel.readString();
      if (1 != paramParcel.readInt()) {
        break label507;
      }
    }
    label437:
    label442:
    label447:
    label452:
    label457:
    label462:
    label467:
    label472:
    label477:
    label482:
    label487:
    label492:
    label497:
    label502:
    label507:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.Bwq = bool1;
      this.Bwr = paramParcel.readString();
      this.Bws = paramParcel.readInt();
      this.Bwt = paramParcel.readArrayList(CreTypeRuleInfo.class.getClassLoader());
      AppMethodBeat.o(70272);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label70;
      bool1 = false;
      break label85;
      bool1 = false;
      break label100;
      bool1 = false;
      break label131;
      bool1 = false;
      break label218;
      bool1 = false;
      break label233;
      bool1 = false;
      break label248;
      bool1 = false;
      break label263;
      bool1 = false;
      break label278;
      bool1 = false;
      break label293;
      bool1 = false;
      break label308;
      bool1 = false;
      break label323;
      bool1 = false;
      break label338;
      bool1 = false;
      break label369;
    }
  }
  
  public static ArrayList<CreTypeRuleInfo> aY(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70271);
    ArrayList localArrayList = new ArrayList();
    if (paramJSONObject != null)
    {
      paramJSONObject = paramJSONObject.optJSONArray("cre_rule_array");
      if (paramJSONObject != null)
      {
        int j = paramJSONObject.length();
        int i = 0;
        while (i < j)
        {
          CreTypeRuleInfo localCreTypeRuleInfo = CreTypeRuleInfo.aW(paramJSONObject.optJSONObject(i));
          if (localCreTypeRuleInfo != null) {
            localArrayList.add(localCreTypeRuleInfo);
          }
          i += 1;
        }
      }
    }
    AppMethodBeat.o(70271);
    return localArrayList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final boolean eqT()
  {
    return 2 == this.BvY;
  }
  
  public final boolean erh()
  {
    return 1 == this.BvY;
  }
  
  public final List<Integer> eri()
  {
    AppMethodBeat.i(70270);
    Object localObject;
    if (this.Bwp != null)
    {
      localObject = this.Bwp;
      AppMethodBeat.o(70270);
      return localObject;
    }
    if (!bs.isNullOrNil(this.Bwo))
    {
      this.Bwp = new ArrayList();
      localObject = this.Bwo.split("\\|");
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        int k = bs.getInt(localObject[i], 0);
        if (k > 0) {
          this.Bwp.add(Integer.valueOf(k));
        }
        i += 1;
      }
      localObject = this.Bwp;
      AppMethodBeat.o(70270);
      return localObject;
    }
    AppMethodBeat.o(70270);
    return null;
  }
  
  public final boolean isError()
  {
    AppMethodBeat.i(70269);
    boolean bool = "0".equals(bs.bG(this.Bwa, "").trim());
    AppMethodBeat.o(70269);
    return bool;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(70273);
    paramParcel.writeString(bs.bG(this.vwo, ""));
    paramParcel.writeString(bs.bG(this.tGS, ""));
    paramParcel.writeString(bs.bG(this.BvP, ""));
    if (this.BvQ)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.BvR) {
        break label464;
      }
      paramInt = 1;
      label70:
      paramParcel.writeInt(paramInt);
      if (!this.BvS) {
        break label469;
      }
      paramInt = 1;
      label84:
      paramParcel.writeInt(paramInt);
      if (!this.BvT) {
        break label474;
      }
      paramInt = 1;
      label98:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(bs.bG(this.BvV, ""));
      paramParcel.writeString(bs.bG(this.vwo, ""));
      if (!this.BvW) {
        break label479;
      }
      paramInt = 1;
      label138:
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.BvX);
      paramParcel.writeInt(this.BvY);
      paramParcel.writeString(bs.bG(this.cZz, ""));
      paramParcel.writeString(bs.bG(this.BvZ, ""));
      paramParcel.writeString(bs.bG(this.Bwa, ""));
      paramParcel.writeString(bs.bG(this.Bwb, ""));
      paramParcel.writeString(bs.bG(this.Bwe, ""));
      paramParcel.writeString(bs.bG(this.Bwd, ""));
      paramParcel.writeString(bs.bG(this.Bwc, ""));
      if (!this.Bwf) {
        break label484;
      }
      paramInt = 1;
      label259:
      paramParcel.writeInt(paramInt);
      if (!this.Bwg) {
        break label489;
      }
      paramInt = 1;
      label273:
      paramParcel.writeInt(paramInt);
      if (!this.Bwh) {
        break label494;
      }
      paramInt = 1;
      label287:
      paramParcel.writeInt(paramInt);
      if (!this.Bwi) {
        break label499;
      }
      paramInt = 1;
      label301:
      paramParcel.writeInt(paramInt);
      if (!this.Bwj) {
        break label504;
      }
      paramInt = 1;
      label315:
      paramParcel.writeInt(paramInt);
      if (!this.Bwk) {
        break label509;
      }
      paramInt = 1;
      label329:
      paramParcel.writeInt(paramInt);
      if (!this.Bwm) {
        break label514;
      }
      paramInt = 1;
      label343:
      paramParcel.writeInt(paramInt);
      if (!this.Bwl) {
        break label519;
      }
      paramInt = 1;
      label357:
      paramParcel.writeInt(paramInt);
      if (!this.Bwn) {
        break label524;
      }
      paramInt = 1;
      label371:
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.BoU);
      paramParcel.writeString(this.Bwo);
      if (!this.Bwu) {
        break label529;
      }
      paramInt = 1;
      label401:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.BtG);
      if (!this.Bwq) {
        break label534;
      }
    }
    label514:
    label519:
    label524:
    label529:
    label534:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.Bwr);
      paramParcel.writeInt(this.Bws);
      paramParcel.writeList(this.Bwt);
      AppMethodBeat.o(70273);
      return;
      paramInt = 0;
      break;
      label464:
      paramInt = 0;
      break label70;
      label469:
      paramInt = 0;
      break label84;
      label474:
      paramInt = 0;
      break label98;
      label479:
      paramInt = 0;
      break label138;
      label484:
      paramInt = 0;
      break label259;
      label489:
      paramInt = 0;
      break label273;
      label494:
      paramInt = 0;
      break label287;
      label499:
      paramInt = 0;
      break label301;
      label504:
      paramInt = 0;
      break label315;
      label509:
      paramInt = 0;
      break label329;
      paramInt = 0;
      break label343;
      paramInt = 0;
      break label357;
      paramInt = 0;
      break label371;
      paramInt = 0;
      break label401;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ElementQuery
 * JD-Core Version:    0.7.0.1
 */