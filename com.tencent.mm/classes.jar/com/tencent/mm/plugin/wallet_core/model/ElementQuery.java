package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class ElementQuery
  implements Parcelable
{
  public static final Parcelable.Creator<ElementQuery> CREATOR;
  public static String CWe;
  public int CPj;
  public String CTV;
  public boolean CWA;
  public boolean CWB;
  public boolean CWC;
  public boolean CWD;
  public String CWE;
  private List<Integer> CWF;
  public boolean CWG;
  public String CWH;
  public int CWI;
  public ArrayList<CreTypeRuleInfo> CWJ;
  public boolean CWK;
  public String CWf;
  public boolean CWg;
  public boolean CWh;
  public boolean CWi;
  public boolean CWj;
  public String CWk;
  public String CWl;
  public boolean CWm;
  public int CWn;
  public int CWo;
  public String CWp;
  public String CWq;
  public String CWr;
  public String CWs;
  public String CWt;
  public String CWu;
  public boolean CWv;
  public boolean CWw;
  public boolean CWx;
  public boolean CWy;
  public boolean CWz;
  public JSONObject cQv;
  public String dkR;
  public String uJF;
  public String wBI;
  
  static
  {
    AppMethodBeat.i(70274);
    CWe = "bind_serial";
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(70274);
  }
  
  public ElementQuery()
  {
    this.CWF = null;
    this.CWK = false;
  }
  
  public ElementQuery(Parcel paramParcel)
  {
    AppMethodBeat.i(70272);
    this.CWF = null;
    this.CWK = false;
    this.wBI = paramParcel.readString();
    this.uJF = paramParcel.readString();
    this.CWf = paramParcel.readString();
    if (1 == paramParcel.readInt())
    {
      bool1 = true;
      this.CWg = bool1;
      if (1 != paramParcel.readInt()) {
        break label437;
      }
      bool1 = true;
      label70:
      this.CWh = bool1;
      if (1 != paramParcel.readInt()) {
        break label442;
      }
      bool1 = true;
      label85:
      this.CWi = bool1;
      if (1 != paramParcel.readInt()) {
        break label447;
      }
      bool1 = true;
      label100:
      this.CWj = bool1;
      this.CWl = paramParcel.readString();
      this.wBI = paramParcel.readString();
      if (1 != paramParcel.readInt()) {
        break label452;
      }
      bool1 = true;
      label131:
      this.CWm = bool1;
      this.CWn = paramParcel.readInt();
      this.CWo = paramParcel.readInt();
      this.dkR = paramParcel.readString();
      this.CWp = paramParcel.readString();
      this.CWq = paramParcel.readString();
      this.CWr = paramParcel.readString();
      this.CWu = paramParcel.readString();
      this.CWt = paramParcel.readString();
      this.CWs = paramParcel.readString();
      if (1 != paramParcel.readInt()) {
        break label457;
      }
      bool1 = true;
      label218:
      this.CWv = bool1;
      if (1 != paramParcel.readInt()) {
        break label462;
      }
      bool1 = true;
      label233:
      this.CWw = bool1;
      if (1 != paramParcel.readInt()) {
        break label467;
      }
      bool1 = true;
      label248:
      this.CWx = bool1;
      if (1 != paramParcel.readInt()) {
        break label472;
      }
      bool1 = true;
      label263:
      this.CWy = bool1;
      if (1 != paramParcel.readInt()) {
        break label477;
      }
      bool1 = true;
      label278:
      this.CWz = bool1;
      if (1 != paramParcel.readInt()) {
        break label482;
      }
      bool1 = true;
      label293:
      this.CWA = bool1;
      if (1 != paramParcel.readInt()) {
        break label487;
      }
      bool1 = true;
      label308:
      this.CWC = bool1;
      if (1 != paramParcel.readInt()) {
        break label492;
      }
      bool1 = true;
      label323:
      this.CWB = bool1;
      if (1 != paramParcel.readInt()) {
        break label497;
      }
      bool1 = true;
      label338:
      this.CWD = bool1;
      this.CPj = paramParcel.readInt();
      this.CWE = paramParcel.readString();
      if (1 != paramParcel.readInt()) {
        break label502;
      }
      bool1 = true;
      label369:
      this.CWK = bool1;
      this.CTV = paramParcel.readString();
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
      this.CWG = bool1;
      this.CWH = paramParcel.readString();
      this.CWI = paramParcel.readInt();
      this.CWJ = paramParcel.readArrayList(CreTypeRuleInfo.class.getClassLoader());
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
  
  public final boolean eET()
  {
    return 2 == this.CWo;
  }
  
  public final boolean eFh()
  {
    return 1 == this.CWo;
  }
  
  public final List<Integer> eFi()
  {
    AppMethodBeat.i(70270);
    Object localObject;
    if (this.CWF != null)
    {
      localObject = this.CWF;
      AppMethodBeat.o(70270);
      return localObject;
    }
    if (!bt.isNullOrNil(this.CWE))
    {
      this.CWF = new ArrayList();
      localObject = this.CWE.split("\\|");
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        int k = bt.getInt(localObject[i], 0);
        if (k > 0) {
          this.CWF.add(Integer.valueOf(k));
        }
        i += 1;
      }
      localObject = this.CWF;
      AppMethodBeat.o(70270);
      return localObject;
    }
    AppMethodBeat.o(70270);
    return null;
  }
  
  public final boolean isError()
  {
    AppMethodBeat.i(70269);
    boolean bool = "0".equals(bt.bI(this.CWq, "").trim());
    AppMethodBeat.o(70269);
    return bool;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(70273);
    paramParcel.writeString(bt.bI(this.wBI, ""));
    paramParcel.writeString(bt.bI(this.uJF, ""));
    paramParcel.writeString(bt.bI(this.CWf, ""));
    if (this.CWg)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.CWh) {
        break label464;
      }
      paramInt = 1;
      label70:
      paramParcel.writeInt(paramInt);
      if (!this.CWi) {
        break label469;
      }
      paramInt = 1;
      label84:
      paramParcel.writeInt(paramInt);
      if (!this.CWj) {
        break label474;
      }
      paramInt = 1;
      label98:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(bt.bI(this.CWl, ""));
      paramParcel.writeString(bt.bI(this.wBI, ""));
      if (!this.CWm) {
        break label479;
      }
      paramInt = 1;
      label138:
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.CWn);
      paramParcel.writeInt(this.CWo);
      paramParcel.writeString(bt.bI(this.dkR, ""));
      paramParcel.writeString(bt.bI(this.CWp, ""));
      paramParcel.writeString(bt.bI(this.CWq, ""));
      paramParcel.writeString(bt.bI(this.CWr, ""));
      paramParcel.writeString(bt.bI(this.CWu, ""));
      paramParcel.writeString(bt.bI(this.CWt, ""));
      paramParcel.writeString(bt.bI(this.CWs, ""));
      if (!this.CWv) {
        break label484;
      }
      paramInt = 1;
      label259:
      paramParcel.writeInt(paramInt);
      if (!this.CWw) {
        break label489;
      }
      paramInt = 1;
      label273:
      paramParcel.writeInt(paramInt);
      if (!this.CWx) {
        break label494;
      }
      paramInt = 1;
      label287:
      paramParcel.writeInt(paramInt);
      if (!this.CWy) {
        break label499;
      }
      paramInt = 1;
      label301:
      paramParcel.writeInt(paramInt);
      if (!this.CWz) {
        break label504;
      }
      paramInt = 1;
      label315:
      paramParcel.writeInt(paramInt);
      if (!this.CWA) {
        break label509;
      }
      paramInt = 1;
      label329:
      paramParcel.writeInt(paramInt);
      if (!this.CWC) {
        break label514;
      }
      paramInt = 1;
      label343:
      paramParcel.writeInt(paramInt);
      if (!this.CWB) {
        break label519;
      }
      paramInt = 1;
      label357:
      paramParcel.writeInt(paramInt);
      if (!this.CWD) {
        break label524;
      }
      paramInt = 1;
      label371:
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.CPj);
      paramParcel.writeString(this.CWE);
      if (!this.CWK) {
        break label529;
      }
      paramInt = 1;
      label401:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.CTV);
      if (!this.CWG) {
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
      paramParcel.writeString(this.CWH);
      paramParcel.writeInt(this.CWI);
      paramParcel.writeList(this.CWJ);
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