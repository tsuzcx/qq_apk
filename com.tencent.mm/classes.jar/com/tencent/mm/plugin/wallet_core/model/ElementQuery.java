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
  public static String HXb;
  public String ANo;
  public int HQg;
  public String HUU;
  public boolean HXA;
  public String HXB;
  private List<Integer> HXC;
  public boolean HXD;
  public String HXE;
  public int HXF;
  public ArrayList<CreTypeRuleInfo> HXG;
  public boolean HXH;
  public String HXc;
  public boolean HXd;
  public boolean HXe;
  public boolean HXf;
  public boolean HXg;
  public String HXh;
  public String HXi;
  public boolean HXj;
  public int HXk;
  public int HXl;
  public String HXm;
  public String HXn;
  public String HXo;
  public String HXp;
  public String HXq;
  public String HXr;
  public boolean HXs;
  public boolean HXt;
  public boolean HXu;
  public boolean HXv;
  public boolean HXw;
  public boolean HXx;
  public boolean HXy;
  public boolean HXz;
  public String dDj;
  public JSONObject dhz;
  public String ynT;
  
  static
  {
    AppMethodBeat.i(70274);
    HXb = "bind_serial";
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(70274);
  }
  
  public ElementQuery()
  {
    this.HXC = null;
    this.HXH = false;
  }
  
  public ElementQuery(Parcel paramParcel)
  {
    AppMethodBeat.i(70272);
    this.HXC = null;
    this.HXH = false;
    this.ANo = paramParcel.readString();
    this.ynT = paramParcel.readString();
    this.HXc = paramParcel.readString();
    if (1 == paramParcel.readInt())
    {
      bool1 = true;
      this.HXd = bool1;
      if (1 != paramParcel.readInt()) {
        break label437;
      }
      bool1 = true;
      label70:
      this.HXe = bool1;
      if (1 != paramParcel.readInt()) {
        break label442;
      }
      bool1 = true;
      label85:
      this.HXf = bool1;
      if (1 != paramParcel.readInt()) {
        break label447;
      }
      bool1 = true;
      label100:
      this.HXg = bool1;
      this.HXi = paramParcel.readString();
      this.ANo = paramParcel.readString();
      if (1 != paramParcel.readInt()) {
        break label452;
      }
      bool1 = true;
      label131:
      this.HXj = bool1;
      this.HXk = paramParcel.readInt();
      this.HXl = paramParcel.readInt();
      this.dDj = paramParcel.readString();
      this.HXm = paramParcel.readString();
      this.HXn = paramParcel.readString();
      this.HXo = paramParcel.readString();
      this.HXr = paramParcel.readString();
      this.HXq = paramParcel.readString();
      this.HXp = paramParcel.readString();
      if (1 != paramParcel.readInt()) {
        break label457;
      }
      bool1 = true;
      label218:
      this.HXs = bool1;
      if (1 != paramParcel.readInt()) {
        break label462;
      }
      bool1 = true;
      label233:
      this.HXt = bool1;
      if (1 != paramParcel.readInt()) {
        break label467;
      }
      bool1 = true;
      label248:
      this.HXu = bool1;
      if (1 != paramParcel.readInt()) {
        break label472;
      }
      bool1 = true;
      label263:
      this.HXv = bool1;
      if (1 != paramParcel.readInt()) {
        break label477;
      }
      bool1 = true;
      label278:
      this.HXw = bool1;
      if (1 != paramParcel.readInt()) {
        break label482;
      }
      bool1 = true;
      label293:
      this.HXx = bool1;
      if (1 != paramParcel.readInt()) {
        break label487;
      }
      bool1 = true;
      label308:
      this.HXz = bool1;
      if (1 != paramParcel.readInt()) {
        break label492;
      }
      bool1 = true;
      label323:
      this.HXy = bool1;
      if (1 != paramParcel.readInt()) {
        break label497;
      }
      bool1 = true;
      label338:
      this.HXA = bool1;
      this.HQg = paramParcel.readInt();
      this.HXB = paramParcel.readString();
      if (1 != paramParcel.readInt()) {
        break label502;
      }
      bool1 = true;
      label369:
      this.HXH = bool1;
      this.HUU = paramParcel.readString();
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
      this.HXD = bool1;
      this.HXE = paramParcel.readString();
      this.HXF = paramParcel.readInt();
      this.HXG = paramParcel.readArrayList(CreTypeRuleInfo.class.getClassLoader());
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
  
  public static ArrayList<CreTypeRuleInfo> bG(JSONObject paramJSONObject)
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
          CreTypeRuleInfo localCreTypeRuleInfo = CreTypeRuleInfo.bE(paramJSONObject.optJSONObject(i));
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
  
  public final boolean fQd()
  {
    return 2 == this.HXl;
  }
  
  public final boolean fQr()
  {
    return 1 == this.HXl;
  }
  
  public final List<Integer> fQs()
  {
    AppMethodBeat.i(70270);
    Object localObject;
    if (this.HXC != null)
    {
      localObject = this.HXC;
      AppMethodBeat.o(70270);
      return localObject;
    }
    if (!Util.isNullOrNil(this.HXB))
    {
      this.HXC = new ArrayList();
      localObject = this.HXB.split("\\|");
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        int k = Util.getInt(localObject[i], 0);
        if (k > 0) {
          this.HXC.add(Integer.valueOf(k));
        }
        i += 1;
      }
      localObject = this.HXC;
      AppMethodBeat.o(70270);
      return localObject;
    }
    AppMethodBeat.o(70270);
    return null;
  }
  
  public final boolean isError()
  {
    AppMethodBeat.i(70269);
    boolean bool = "0".equals(Util.nullAs(this.HXn, "").trim());
    AppMethodBeat.o(70269);
    return bool;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(70273);
    paramParcel.writeString(Util.nullAs(this.ANo, ""));
    paramParcel.writeString(Util.nullAs(this.ynT, ""));
    paramParcel.writeString(Util.nullAs(this.HXc, ""));
    if (this.HXd)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.HXe) {
        break label464;
      }
      paramInt = 1;
      label70:
      paramParcel.writeInt(paramInt);
      if (!this.HXf) {
        break label469;
      }
      paramInt = 1;
      label84:
      paramParcel.writeInt(paramInt);
      if (!this.HXg) {
        break label474;
      }
      paramInt = 1;
      label98:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(Util.nullAs(this.HXi, ""));
      paramParcel.writeString(Util.nullAs(this.ANo, ""));
      if (!this.HXj) {
        break label479;
      }
      paramInt = 1;
      label138:
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.HXk);
      paramParcel.writeInt(this.HXl);
      paramParcel.writeString(Util.nullAs(this.dDj, ""));
      paramParcel.writeString(Util.nullAs(this.HXm, ""));
      paramParcel.writeString(Util.nullAs(this.HXn, ""));
      paramParcel.writeString(Util.nullAs(this.HXo, ""));
      paramParcel.writeString(Util.nullAs(this.HXr, ""));
      paramParcel.writeString(Util.nullAs(this.HXq, ""));
      paramParcel.writeString(Util.nullAs(this.HXp, ""));
      if (!this.HXs) {
        break label484;
      }
      paramInt = 1;
      label259:
      paramParcel.writeInt(paramInt);
      if (!this.HXt) {
        break label489;
      }
      paramInt = 1;
      label273:
      paramParcel.writeInt(paramInt);
      if (!this.HXu) {
        break label494;
      }
      paramInt = 1;
      label287:
      paramParcel.writeInt(paramInt);
      if (!this.HXv) {
        break label499;
      }
      paramInt = 1;
      label301:
      paramParcel.writeInt(paramInt);
      if (!this.HXw) {
        break label504;
      }
      paramInt = 1;
      label315:
      paramParcel.writeInt(paramInt);
      if (!this.HXx) {
        break label509;
      }
      paramInt = 1;
      label329:
      paramParcel.writeInt(paramInt);
      if (!this.HXz) {
        break label514;
      }
      paramInt = 1;
      label343:
      paramParcel.writeInt(paramInt);
      if (!this.HXy) {
        break label519;
      }
      paramInt = 1;
      label357:
      paramParcel.writeInt(paramInt);
      if (!this.HXA) {
        break label524;
      }
      paramInt = 1;
      label371:
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.HQg);
      paramParcel.writeString(this.HXB);
      if (!this.HXH) {
        break label529;
      }
      paramInt = 1;
      label401:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.HUU);
      if (!this.HXD) {
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
      paramParcel.writeString(this.HXE);
      paramParcel.writeInt(this.HXF);
      paramParcel.writeList(this.HXG);
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