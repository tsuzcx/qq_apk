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
  public static String Adu;
  public static final Parcelable.Creator<ElementQuery> CREATOR;
  public String Abm;
  public String AdA;
  public String AdB;
  public boolean AdC;
  public int AdD;
  public int AdE;
  public String AdF;
  public String AdG;
  public String AdH;
  public String AdI;
  public String AdJ;
  public String AdK;
  public boolean AdL;
  public boolean AdM;
  public boolean AdN;
  public boolean AdO;
  public boolean AdP;
  public boolean AdQ;
  public boolean AdR;
  public boolean AdS;
  public boolean AdT;
  public String AdU;
  private List<Integer> AdV;
  public boolean AdW;
  public String AdX;
  public int AdY;
  public ArrayList<CreTypeRuleInfo> AdZ;
  public String Adv;
  public boolean Adw;
  public boolean Adx;
  public boolean Ady;
  public boolean Adz;
  public boolean Aea;
  public JSONObject cIj;
  public String dca;
  public String szi;
  public String uns;
  public int zWA;
  
  static
  {
    AppMethodBeat.i(70274);
    Adu = "bind_serial";
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(70274);
  }
  
  public ElementQuery()
  {
    this.AdV = null;
    this.Aea = false;
  }
  
  public ElementQuery(Parcel paramParcel)
  {
    AppMethodBeat.i(70272);
    this.AdV = null;
    this.Aea = false;
    this.uns = paramParcel.readString();
    this.szi = paramParcel.readString();
    this.Adv = paramParcel.readString();
    if (1 == paramParcel.readInt())
    {
      bool1 = true;
      this.Adw = bool1;
      if (1 != paramParcel.readInt()) {
        break label437;
      }
      bool1 = true;
      label70:
      this.Adx = bool1;
      if (1 != paramParcel.readInt()) {
        break label442;
      }
      bool1 = true;
      label85:
      this.Ady = bool1;
      if (1 != paramParcel.readInt()) {
        break label447;
      }
      bool1 = true;
      label100:
      this.Adz = bool1;
      this.AdB = paramParcel.readString();
      this.uns = paramParcel.readString();
      if (1 != paramParcel.readInt()) {
        break label452;
      }
      bool1 = true;
      label131:
      this.AdC = bool1;
      this.AdD = paramParcel.readInt();
      this.AdE = paramParcel.readInt();
      this.dca = paramParcel.readString();
      this.AdF = paramParcel.readString();
      this.AdG = paramParcel.readString();
      this.AdH = paramParcel.readString();
      this.AdK = paramParcel.readString();
      this.AdJ = paramParcel.readString();
      this.AdI = paramParcel.readString();
      if (1 != paramParcel.readInt()) {
        break label457;
      }
      bool1 = true;
      label218:
      this.AdL = bool1;
      if (1 != paramParcel.readInt()) {
        break label462;
      }
      bool1 = true;
      label233:
      this.AdM = bool1;
      if (1 != paramParcel.readInt()) {
        break label467;
      }
      bool1 = true;
      label248:
      this.AdN = bool1;
      if (1 != paramParcel.readInt()) {
        break label472;
      }
      bool1 = true;
      label263:
      this.AdO = bool1;
      if (1 != paramParcel.readInt()) {
        break label477;
      }
      bool1 = true;
      label278:
      this.AdP = bool1;
      if (1 != paramParcel.readInt()) {
        break label482;
      }
      bool1 = true;
      label293:
      this.AdQ = bool1;
      if (1 != paramParcel.readInt()) {
        break label487;
      }
      bool1 = true;
      label308:
      this.AdS = bool1;
      if (1 != paramParcel.readInt()) {
        break label492;
      }
      bool1 = true;
      label323:
      this.AdR = bool1;
      if (1 != paramParcel.readInt()) {
        break label497;
      }
      bool1 = true;
      label338:
      this.AdT = bool1;
      this.zWA = paramParcel.readInt();
      this.AdU = paramParcel.readString();
      if (1 != paramParcel.readInt()) {
        break label502;
      }
      bool1 = true;
      label369:
      this.Aea = bool1;
      this.Abm = paramParcel.readString();
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
      this.AdW = bool1;
      this.AdX = paramParcel.readString();
      this.AdY = paramParcel.readInt();
      this.AdZ = paramParcel.readArrayList(CreTypeRuleInfo.class.getClassLoader());
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
  
  public static ArrayList<CreTypeRuleInfo> aX(JSONObject paramJSONObject)
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
          CreTypeRuleInfo localCreTypeRuleInfo = CreTypeRuleInfo.aV(paramJSONObject.optJSONObject(i));
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
  
  public final boolean ebL()
  {
    return 1 == this.AdE;
  }
  
  public final List<Integer> ebM()
  {
    AppMethodBeat.i(70270);
    Object localObject;
    if (this.AdV != null)
    {
      localObject = this.AdV;
      AppMethodBeat.o(70270);
      return localObject;
    }
    if (!bt.isNullOrNil(this.AdU))
    {
      this.AdV = new ArrayList();
      localObject = this.AdU.split("\\|");
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        int k = bt.getInt(localObject[i], 0);
        if (k > 0) {
          this.AdV.add(Integer.valueOf(k));
        }
        i += 1;
      }
      localObject = this.AdV;
      AppMethodBeat.o(70270);
      return localObject;
    }
    AppMethodBeat.o(70270);
    return null;
  }
  
  public final boolean ebx()
  {
    return 2 == this.AdE;
  }
  
  public final boolean isError()
  {
    AppMethodBeat.i(70269);
    boolean bool = "0".equals(bt.by(this.AdG, "").trim());
    AppMethodBeat.o(70269);
    return bool;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(70273);
    paramParcel.writeString(bt.by(this.uns, ""));
    paramParcel.writeString(bt.by(this.szi, ""));
    paramParcel.writeString(bt.by(this.Adv, ""));
    if (this.Adw)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.Adx) {
        break label464;
      }
      paramInt = 1;
      label70:
      paramParcel.writeInt(paramInt);
      if (!this.Ady) {
        break label469;
      }
      paramInt = 1;
      label84:
      paramParcel.writeInt(paramInt);
      if (!this.Adz) {
        break label474;
      }
      paramInt = 1;
      label98:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(bt.by(this.AdB, ""));
      paramParcel.writeString(bt.by(this.uns, ""));
      if (!this.AdC) {
        break label479;
      }
      paramInt = 1;
      label138:
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.AdD);
      paramParcel.writeInt(this.AdE);
      paramParcel.writeString(bt.by(this.dca, ""));
      paramParcel.writeString(bt.by(this.AdF, ""));
      paramParcel.writeString(bt.by(this.AdG, ""));
      paramParcel.writeString(bt.by(this.AdH, ""));
      paramParcel.writeString(bt.by(this.AdK, ""));
      paramParcel.writeString(bt.by(this.AdJ, ""));
      paramParcel.writeString(bt.by(this.AdI, ""));
      if (!this.AdL) {
        break label484;
      }
      paramInt = 1;
      label259:
      paramParcel.writeInt(paramInt);
      if (!this.AdM) {
        break label489;
      }
      paramInt = 1;
      label273:
      paramParcel.writeInt(paramInt);
      if (!this.AdN) {
        break label494;
      }
      paramInt = 1;
      label287:
      paramParcel.writeInt(paramInt);
      if (!this.AdO) {
        break label499;
      }
      paramInt = 1;
      label301:
      paramParcel.writeInt(paramInt);
      if (!this.AdP) {
        break label504;
      }
      paramInt = 1;
      label315:
      paramParcel.writeInt(paramInt);
      if (!this.AdQ) {
        break label509;
      }
      paramInt = 1;
      label329:
      paramParcel.writeInt(paramInt);
      if (!this.AdS) {
        break label514;
      }
      paramInt = 1;
      label343:
      paramParcel.writeInt(paramInt);
      if (!this.AdR) {
        break label519;
      }
      paramInt = 1;
      label357:
      paramParcel.writeInt(paramInt);
      if (!this.AdT) {
        break label524;
      }
      paramInt = 1;
      label371:
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.zWA);
      paramParcel.writeString(this.AdU);
      if (!this.Aea) {
        break label529;
      }
      paramInt = 1;
      label401:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.Abm);
      if (!this.AdW) {
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
      paramParcel.writeString(this.AdX);
      paramParcel.writeInt(this.AdY);
      paramParcel.writeList(this.AdZ);
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