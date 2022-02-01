package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class ElementQuery
  implements Parcelable
{
  public static final Parcelable.Creator<ElementQuery> CREATOR;
  public static String OPb;
  public String DNV;
  public String GGC;
  public int OIp;
  public String OMV;
  public boolean OPA;
  public String OPB;
  private List<Integer> OPC;
  public boolean OPD;
  public String OPE;
  public int OPF;
  public ArrayList<CreTypeRuleInfo> OPG;
  public boolean OPH;
  public String OPc;
  public boolean OPd;
  public boolean OPe;
  public boolean OPf;
  public boolean OPg;
  public String OPh;
  public String OPi;
  public boolean OPj;
  public int OPk;
  public int OPl;
  public String OPm;
  public String OPn;
  public String OPo;
  public String OPp;
  public String OPq;
  public String OPr;
  public boolean OPs;
  public boolean OPt;
  public boolean OPu;
  public boolean OPv;
  public boolean OPw;
  public boolean OPx;
  public boolean OPy;
  public boolean OPz;
  public JSONObject eZg;
  public String fvP;
  
  static
  {
    AppMethodBeat.i(70274);
    OPb = "bind_serial";
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(70274);
  }
  
  public ElementQuery()
  {
    this.OPC = null;
    this.OPH = false;
  }
  
  public ElementQuery(Parcel paramParcel)
  {
    AppMethodBeat.i(70272);
    this.OPC = null;
    this.OPH = false;
    this.GGC = paramParcel.readString();
    this.DNV = paramParcel.readString();
    this.OPc = paramParcel.readString();
    if (1 == paramParcel.readInt())
    {
      bool1 = true;
      this.OPd = bool1;
      if (1 != paramParcel.readInt()) {
        break label437;
      }
      bool1 = true;
      label70:
      this.OPe = bool1;
      if (1 != paramParcel.readInt()) {
        break label442;
      }
      bool1 = true;
      label85:
      this.OPf = bool1;
      if (1 != paramParcel.readInt()) {
        break label447;
      }
      bool1 = true;
      label100:
      this.OPg = bool1;
      this.OPi = paramParcel.readString();
      this.GGC = paramParcel.readString();
      if (1 != paramParcel.readInt()) {
        break label452;
      }
      bool1 = true;
      label131:
      this.OPj = bool1;
      this.OPk = paramParcel.readInt();
      this.OPl = paramParcel.readInt();
      this.fvP = paramParcel.readString();
      this.OPm = paramParcel.readString();
      this.OPn = paramParcel.readString();
      this.OPo = paramParcel.readString();
      this.OPr = paramParcel.readString();
      this.OPq = paramParcel.readString();
      this.OPp = paramParcel.readString();
      if (1 != paramParcel.readInt()) {
        break label457;
      }
      bool1 = true;
      label218:
      this.OPs = bool1;
      if (1 != paramParcel.readInt()) {
        break label462;
      }
      bool1 = true;
      label233:
      this.OPt = bool1;
      if (1 != paramParcel.readInt()) {
        break label467;
      }
      bool1 = true;
      label248:
      this.OPu = bool1;
      if (1 != paramParcel.readInt()) {
        break label472;
      }
      bool1 = true;
      label263:
      this.OPv = bool1;
      if (1 != paramParcel.readInt()) {
        break label477;
      }
      bool1 = true;
      label278:
      this.OPw = bool1;
      if (1 != paramParcel.readInt()) {
        break label482;
      }
      bool1 = true;
      label293:
      this.OPx = bool1;
      if (1 != paramParcel.readInt()) {
        break label487;
      }
      bool1 = true;
      label308:
      this.OPz = bool1;
      if (1 != paramParcel.readInt()) {
        break label492;
      }
      bool1 = true;
      label323:
      this.OPy = bool1;
      if (1 != paramParcel.readInt()) {
        break label497;
      }
      bool1 = true;
      label338:
      this.OPA = bool1;
      this.OIp = paramParcel.readInt();
      this.OPB = paramParcel.readString();
      if (1 != paramParcel.readInt()) {
        break label502;
      }
      bool1 = true;
      label369:
      this.OPH = bool1;
      this.OMV = paramParcel.readString();
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
      this.OPD = bool1;
      this.OPE = paramParcel.readString();
      this.OPF = paramParcel.readInt();
      this.OPG = paramParcel.readArrayList(CreTypeRuleInfo.class.getClassLoader());
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
  
  public static ArrayList<CreTypeRuleInfo> bR(JSONObject paramJSONObject)
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
          CreTypeRuleInfo localCreTypeRuleInfo = CreTypeRuleInfo.bP(paramJSONObject.optJSONObject(i));
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
  
  public final boolean gIJ()
  {
    return 2 == this.OPl;
  }
  
  public final boolean gIX()
  {
    return 1 == this.OPl;
  }
  
  public final List<Integer> gIY()
  {
    AppMethodBeat.i(70270);
    Object localObject;
    if (this.OPC != null)
    {
      localObject = this.OPC;
      AppMethodBeat.o(70270);
      return localObject;
    }
    if (!Util.isNullOrNil(this.OPB))
    {
      this.OPC = new ArrayList();
      localObject = this.OPB.split("\\|");
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        int k = Util.getInt(localObject[i], 0);
        if (k > 0) {
          this.OPC.add(Integer.valueOf(k));
        }
        i += 1;
      }
      localObject = this.OPC;
      AppMethodBeat.o(70270);
      return localObject;
    }
    AppMethodBeat.o(70270);
    return null;
  }
  
  public final boolean isError()
  {
    AppMethodBeat.i(70269);
    boolean bool = "0".equals(Util.nullAs(this.OPn, "").trim());
    AppMethodBeat.o(70269);
    return bool;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(70273);
    paramParcel.writeString(Util.nullAs(this.GGC, ""));
    paramParcel.writeString(Util.nullAs(this.DNV, ""));
    paramParcel.writeString(Util.nullAs(this.OPc, ""));
    if (this.OPd)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.OPe) {
        break label464;
      }
      paramInt = 1;
      label70:
      paramParcel.writeInt(paramInt);
      if (!this.OPf) {
        break label469;
      }
      paramInt = 1;
      label84:
      paramParcel.writeInt(paramInt);
      if (!this.OPg) {
        break label474;
      }
      paramInt = 1;
      label98:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(Util.nullAs(this.OPi, ""));
      paramParcel.writeString(Util.nullAs(this.GGC, ""));
      if (!this.OPj) {
        break label479;
      }
      paramInt = 1;
      label138:
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.OPk);
      paramParcel.writeInt(this.OPl);
      paramParcel.writeString(Util.nullAs(this.fvP, ""));
      paramParcel.writeString(Util.nullAs(this.OPm, ""));
      paramParcel.writeString(Util.nullAs(this.OPn, ""));
      paramParcel.writeString(Util.nullAs(this.OPo, ""));
      paramParcel.writeString(Util.nullAs(this.OPr, ""));
      paramParcel.writeString(Util.nullAs(this.OPq, ""));
      paramParcel.writeString(Util.nullAs(this.OPp, ""));
      if (!this.OPs) {
        break label484;
      }
      paramInt = 1;
      label259:
      paramParcel.writeInt(paramInt);
      if (!this.OPt) {
        break label489;
      }
      paramInt = 1;
      label273:
      paramParcel.writeInt(paramInt);
      if (!this.OPu) {
        break label494;
      }
      paramInt = 1;
      label287:
      paramParcel.writeInt(paramInt);
      if (!this.OPv) {
        break label499;
      }
      paramInt = 1;
      label301:
      paramParcel.writeInt(paramInt);
      if (!this.OPw) {
        break label504;
      }
      paramInt = 1;
      label315:
      paramParcel.writeInt(paramInt);
      if (!this.OPx) {
        break label509;
      }
      paramInt = 1;
      label329:
      paramParcel.writeInt(paramInt);
      if (!this.OPz) {
        break label514;
      }
      paramInt = 1;
      label343:
      paramParcel.writeInt(paramInt);
      if (!this.OPy) {
        break label519;
      }
      paramInt = 1;
      label357:
      paramParcel.writeInt(paramInt);
      if (!this.OPA) {
        break label524;
      }
      paramInt = 1;
      label371:
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.OIp);
      paramParcel.writeString(this.OPB);
      if (!this.OPH) {
        break label529;
      }
      paramInt = 1;
      label401:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.OMV);
      if (!this.OPD) {
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
      paramParcel.writeString(this.OPE);
      paramParcel.writeInt(this.OPF);
      paramParcel.writeList(this.OPG);
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