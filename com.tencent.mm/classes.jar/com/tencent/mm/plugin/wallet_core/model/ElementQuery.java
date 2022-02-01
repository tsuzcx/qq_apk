package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class ElementQuery
  implements Parcelable
{
  public static final Parcelable.Creator<ElementQuery> CREATOR;
  public static String DnJ;
  public int DgN;
  public String DlB;
  public String DnK;
  public boolean DnL;
  public boolean DnM;
  public boolean DnN;
  public boolean DnO;
  public String DnP;
  public String DnQ;
  public boolean DnR;
  public int DnS;
  public int DnT;
  public String DnU;
  public String DnV;
  public String DnW;
  public String DnX;
  public String DnY;
  public String DnZ;
  public boolean Doa;
  public boolean Dob;
  public boolean Doc;
  public boolean Dod;
  public boolean Doe;
  public boolean Dof;
  public boolean Dog;
  public boolean Doh;
  public boolean Doi;
  public String Doj;
  private List<Integer> Dok;
  public boolean Dol;
  public String Dom;
  public int Don;
  public ArrayList<CreTypeRuleInfo> Doo;
  public boolean Dop;
  public JSONObject cRf;
  public String dlT;
  public String uVs;
  public String wRt;
  
  static
  {
    AppMethodBeat.i(70274);
    DnJ = "bind_serial";
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(70274);
  }
  
  public ElementQuery()
  {
    this.Dok = null;
    this.Dop = false;
  }
  
  public ElementQuery(Parcel paramParcel)
  {
    AppMethodBeat.i(70272);
    this.Dok = null;
    this.Dop = false;
    this.wRt = paramParcel.readString();
    this.uVs = paramParcel.readString();
    this.DnK = paramParcel.readString();
    if (1 == paramParcel.readInt())
    {
      bool1 = true;
      this.DnL = bool1;
      if (1 != paramParcel.readInt()) {
        break label437;
      }
      bool1 = true;
      label70:
      this.DnM = bool1;
      if (1 != paramParcel.readInt()) {
        break label442;
      }
      bool1 = true;
      label85:
      this.DnN = bool1;
      if (1 != paramParcel.readInt()) {
        break label447;
      }
      bool1 = true;
      label100:
      this.DnO = bool1;
      this.DnQ = paramParcel.readString();
      this.wRt = paramParcel.readString();
      if (1 != paramParcel.readInt()) {
        break label452;
      }
      bool1 = true;
      label131:
      this.DnR = bool1;
      this.DnS = paramParcel.readInt();
      this.DnT = paramParcel.readInt();
      this.dlT = paramParcel.readString();
      this.DnU = paramParcel.readString();
      this.DnV = paramParcel.readString();
      this.DnW = paramParcel.readString();
      this.DnZ = paramParcel.readString();
      this.DnY = paramParcel.readString();
      this.DnX = paramParcel.readString();
      if (1 != paramParcel.readInt()) {
        break label457;
      }
      bool1 = true;
      label218:
      this.Doa = bool1;
      if (1 != paramParcel.readInt()) {
        break label462;
      }
      bool1 = true;
      label233:
      this.Dob = bool1;
      if (1 != paramParcel.readInt()) {
        break label467;
      }
      bool1 = true;
      label248:
      this.Doc = bool1;
      if (1 != paramParcel.readInt()) {
        break label472;
      }
      bool1 = true;
      label263:
      this.Dod = bool1;
      if (1 != paramParcel.readInt()) {
        break label477;
      }
      bool1 = true;
      label278:
      this.Doe = bool1;
      if (1 != paramParcel.readInt()) {
        break label482;
      }
      bool1 = true;
      label293:
      this.Dof = bool1;
      if (1 != paramParcel.readInt()) {
        break label487;
      }
      bool1 = true;
      label308:
      this.Doh = bool1;
      if (1 != paramParcel.readInt()) {
        break label492;
      }
      bool1 = true;
      label323:
      this.Dog = bool1;
      if (1 != paramParcel.readInt()) {
        break label497;
      }
      bool1 = true;
      label338:
      this.Doi = bool1;
      this.DgN = paramParcel.readInt();
      this.Doj = paramParcel.readString();
      if (1 != paramParcel.readInt()) {
        break label502;
      }
      bool1 = true;
      label369:
      this.Dop = bool1;
      this.DlB = paramParcel.readString();
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
      this.Dol = bool1;
      this.Dom = paramParcel.readString();
      this.Don = paramParcel.readInt();
      this.Doo = paramParcel.readArrayList(CreTypeRuleInfo.class.getClassLoader());
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
  
  public static ArrayList<CreTypeRuleInfo> bg(JSONObject paramJSONObject)
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
          CreTypeRuleInfo localCreTypeRuleInfo = CreTypeRuleInfo.be(paramJSONObject.optJSONObject(i));
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
  
  public final boolean eIA()
  {
    return 2 == this.DnT;
  }
  
  public final boolean eIO()
  {
    return 1 == this.DnT;
  }
  
  public final List<Integer> eIP()
  {
    AppMethodBeat.i(70270);
    Object localObject;
    if (this.Dok != null)
    {
      localObject = this.Dok;
      AppMethodBeat.o(70270);
      return localObject;
    }
    if (!bu.isNullOrNil(this.Doj))
    {
      this.Dok = new ArrayList();
      localObject = this.Doj.split("\\|");
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        int k = bu.getInt(localObject[i], 0);
        if (k > 0) {
          this.Dok.add(Integer.valueOf(k));
        }
        i += 1;
      }
      localObject = this.Dok;
      AppMethodBeat.o(70270);
      return localObject;
    }
    AppMethodBeat.o(70270);
    return null;
  }
  
  public final boolean isError()
  {
    AppMethodBeat.i(70269);
    boolean bool = "0".equals(bu.bI(this.DnV, "").trim());
    AppMethodBeat.o(70269);
    return bool;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(70273);
    paramParcel.writeString(bu.bI(this.wRt, ""));
    paramParcel.writeString(bu.bI(this.uVs, ""));
    paramParcel.writeString(bu.bI(this.DnK, ""));
    if (this.DnL)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.DnM) {
        break label464;
      }
      paramInt = 1;
      label70:
      paramParcel.writeInt(paramInt);
      if (!this.DnN) {
        break label469;
      }
      paramInt = 1;
      label84:
      paramParcel.writeInt(paramInt);
      if (!this.DnO) {
        break label474;
      }
      paramInt = 1;
      label98:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(bu.bI(this.DnQ, ""));
      paramParcel.writeString(bu.bI(this.wRt, ""));
      if (!this.DnR) {
        break label479;
      }
      paramInt = 1;
      label138:
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.DnS);
      paramParcel.writeInt(this.DnT);
      paramParcel.writeString(bu.bI(this.dlT, ""));
      paramParcel.writeString(bu.bI(this.DnU, ""));
      paramParcel.writeString(bu.bI(this.DnV, ""));
      paramParcel.writeString(bu.bI(this.DnW, ""));
      paramParcel.writeString(bu.bI(this.DnZ, ""));
      paramParcel.writeString(bu.bI(this.DnY, ""));
      paramParcel.writeString(bu.bI(this.DnX, ""));
      if (!this.Doa) {
        break label484;
      }
      paramInt = 1;
      label259:
      paramParcel.writeInt(paramInt);
      if (!this.Dob) {
        break label489;
      }
      paramInt = 1;
      label273:
      paramParcel.writeInt(paramInt);
      if (!this.Doc) {
        break label494;
      }
      paramInt = 1;
      label287:
      paramParcel.writeInt(paramInt);
      if (!this.Dod) {
        break label499;
      }
      paramInt = 1;
      label301:
      paramParcel.writeInt(paramInt);
      if (!this.Doe) {
        break label504;
      }
      paramInt = 1;
      label315:
      paramParcel.writeInt(paramInt);
      if (!this.Dof) {
        break label509;
      }
      paramInt = 1;
      label329:
      paramParcel.writeInt(paramInt);
      if (!this.Doh) {
        break label514;
      }
      paramInt = 1;
      label343:
      paramParcel.writeInt(paramInt);
      if (!this.Dog) {
        break label519;
      }
      paramInt = 1;
      label357:
      paramParcel.writeInt(paramInt);
      if (!this.Doi) {
        break label524;
      }
      paramInt = 1;
      label371:
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.DgN);
      paramParcel.writeString(this.Doj);
      if (!this.Dop) {
        break label529;
      }
      paramInt = 1;
      label401:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.DlB);
      if (!this.Dol) {
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
      paramParcel.writeString(this.Dom);
      paramParcel.writeInt(this.Don);
      paramParcel.writeList(this.Doo);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ElementQuery
 * JD-Core Version:    0.7.0.1
 */