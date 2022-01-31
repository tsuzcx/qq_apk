package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class ElementQuery
  implements Parcelable
{
  public static final Parcelable.Creator<ElementQuery> CREATOR;
  public static String uhn;
  public JSONObject fvc;
  public String nLq;
  public String poq;
  public String por;
  public int ubU;
  public String ufd;
  public String uhA;
  public String uhB;
  public String uhC;
  public String uhD;
  public boolean uhE;
  public boolean uhF;
  public boolean uhG;
  public boolean uhH;
  public boolean uhI;
  public boolean uhJ;
  public boolean uhK;
  public boolean uhL;
  public boolean uhM;
  public String uhN;
  private List<Integer> uhO;
  public boolean uhP;
  public String uhQ;
  public int uhR;
  public ArrayList<CreTypeRuleInfo> uhS;
  public boolean uhT;
  public String uho;
  public boolean uhp;
  public boolean uhq;
  public boolean uhr;
  public boolean uhs;
  public String uht;
  public String uhu;
  public boolean uhv;
  public int uhw;
  public int uhx;
  public String uhy;
  public String uhz;
  
  static
  {
    AppMethodBeat.i(46757);
    uhn = "bind_serial";
    CREATOR = new ElementQuery.1();
    AppMethodBeat.o(46757);
  }
  
  public ElementQuery()
  {
    this.uhO = null;
    this.uhT = false;
  }
  
  public ElementQuery(Parcel paramParcel)
  {
    AppMethodBeat.i(46755);
    this.uhO = null;
    this.uhT = false;
    this.por = paramParcel.readString();
    this.nLq = paramParcel.readString();
    this.uho = paramParcel.readString();
    if (1 == paramParcel.readInt())
    {
      bool1 = true;
      this.uhp = bool1;
      if (1 != paramParcel.readInt()) {
        break label437;
      }
      bool1 = true;
      label70:
      this.uhq = bool1;
      if (1 != paramParcel.readInt()) {
        break label442;
      }
      bool1 = true;
      label85:
      this.uhr = bool1;
      if (1 != paramParcel.readInt()) {
        break label447;
      }
      bool1 = true;
      label100:
      this.uhs = bool1;
      this.uhu = paramParcel.readString();
      this.por = paramParcel.readString();
      if (1 != paramParcel.readInt()) {
        break label452;
      }
      bool1 = true;
      label131:
      this.uhv = bool1;
      this.uhw = paramParcel.readInt();
      this.uhx = paramParcel.readInt();
      this.poq = paramParcel.readString();
      this.uhy = paramParcel.readString();
      this.uhz = paramParcel.readString();
      this.uhA = paramParcel.readString();
      this.uhD = paramParcel.readString();
      this.uhC = paramParcel.readString();
      this.uhB = paramParcel.readString();
      if (1 != paramParcel.readInt()) {
        break label457;
      }
      bool1 = true;
      label218:
      this.uhE = bool1;
      if (1 != paramParcel.readInt()) {
        break label462;
      }
      bool1 = true;
      label233:
      this.uhF = bool1;
      if (1 != paramParcel.readInt()) {
        break label467;
      }
      bool1 = true;
      label248:
      this.uhG = bool1;
      if (1 != paramParcel.readInt()) {
        break label472;
      }
      bool1 = true;
      label263:
      this.uhH = bool1;
      if (1 != paramParcel.readInt()) {
        break label477;
      }
      bool1 = true;
      label278:
      this.uhI = bool1;
      if (1 != paramParcel.readInt()) {
        break label482;
      }
      bool1 = true;
      label293:
      this.uhJ = bool1;
      if (1 != paramParcel.readInt()) {
        break label487;
      }
      bool1 = true;
      label308:
      this.uhL = bool1;
      if (1 != paramParcel.readInt()) {
        break label492;
      }
      bool1 = true;
      label323:
      this.uhK = bool1;
      if (1 != paramParcel.readInt()) {
        break label497;
      }
      bool1 = true;
      label338:
      this.uhM = bool1;
      this.ubU = paramParcel.readInt();
      this.uhN = paramParcel.readString();
      if (1 != paramParcel.readInt()) {
        break label502;
      }
      bool1 = true;
      label369:
      this.uhT = bool1;
      this.ufd = paramParcel.readString();
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
      this.uhP = bool1;
      this.uhQ = paramParcel.readString();
      this.uhR = paramParcel.readInt();
      this.uhS = paramParcel.readArrayList(CreTypeRuleInfo.class.getClassLoader());
      AppMethodBeat.o(46755);
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
  
  public static ArrayList<CreTypeRuleInfo> aC(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(46754);
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
          CreTypeRuleInfo localCreTypeRuleInfo = CreTypeRuleInfo.aA(paramJSONObject.optJSONObject(i));
          if (localCreTypeRuleInfo != null) {
            localArrayList.add(localCreTypeRuleInfo);
          }
          i += 1;
        }
      }
    }
    AppMethodBeat.o(46754);
    return localArrayList;
  }
  
  public final boolean cTh()
  {
    return 2 == this.uhx;
  }
  
  public final boolean cTv()
  {
    return 1 == this.uhx;
  }
  
  public final List<Integer> cTw()
  {
    AppMethodBeat.i(46753);
    Object localObject;
    if (this.uhO != null)
    {
      localObject = this.uhO;
      AppMethodBeat.o(46753);
      return localObject;
    }
    if (!bo.isNullOrNil(this.uhN))
    {
      this.uhO = new ArrayList();
      localObject = this.uhN.split("\\|");
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        int k = bo.getInt(localObject[i], 0);
        if (k > 0) {
          this.uhO.add(Integer.valueOf(k));
        }
        i += 1;
      }
      localObject = this.uhO;
      AppMethodBeat.o(46753);
      return localObject;
    }
    AppMethodBeat.o(46753);
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final boolean isError()
  {
    AppMethodBeat.i(46752);
    boolean bool = "0".equals(bo.bf(this.uhz, "").trim());
    AppMethodBeat.o(46752);
    return bool;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(46756);
    paramParcel.writeString(bo.bf(this.por, ""));
    paramParcel.writeString(bo.bf(this.nLq, ""));
    paramParcel.writeString(bo.bf(this.uho, ""));
    if (this.uhp)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.uhq) {
        break label464;
      }
      paramInt = 1;
      label70:
      paramParcel.writeInt(paramInt);
      if (!this.uhr) {
        break label469;
      }
      paramInt = 1;
      label84:
      paramParcel.writeInt(paramInt);
      if (!this.uhs) {
        break label474;
      }
      paramInt = 1;
      label98:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(bo.bf(this.uhu, ""));
      paramParcel.writeString(bo.bf(this.por, ""));
      if (!this.uhv) {
        break label479;
      }
      paramInt = 1;
      label138:
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.uhw);
      paramParcel.writeInt(this.uhx);
      paramParcel.writeString(bo.bf(this.poq, ""));
      paramParcel.writeString(bo.bf(this.uhy, ""));
      paramParcel.writeString(bo.bf(this.uhz, ""));
      paramParcel.writeString(bo.bf(this.uhA, ""));
      paramParcel.writeString(bo.bf(this.uhD, ""));
      paramParcel.writeString(bo.bf(this.uhC, ""));
      paramParcel.writeString(bo.bf(this.uhB, ""));
      if (!this.uhE) {
        break label484;
      }
      paramInt = 1;
      label259:
      paramParcel.writeInt(paramInt);
      if (!this.uhF) {
        break label489;
      }
      paramInt = 1;
      label273:
      paramParcel.writeInt(paramInt);
      if (!this.uhG) {
        break label494;
      }
      paramInt = 1;
      label287:
      paramParcel.writeInt(paramInt);
      if (!this.uhH) {
        break label499;
      }
      paramInt = 1;
      label301:
      paramParcel.writeInt(paramInt);
      if (!this.uhI) {
        break label504;
      }
      paramInt = 1;
      label315:
      paramParcel.writeInt(paramInt);
      if (!this.uhJ) {
        break label509;
      }
      paramInt = 1;
      label329:
      paramParcel.writeInt(paramInt);
      if (!this.uhL) {
        break label514;
      }
      paramInt = 1;
      label343:
      paramParcel.writeInt(paramInt);
      if (!this.uhK) {
        break label519;
      }
      paramInt = 1;
      label357:
      paramParcel.writeInt(paramInt);
      if (!this.uhM) {
        break label524;
      }
      paramInt = 1;
      label371:
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.ubU);
      paramParcel.writeString(this.uhN);
      if (!this.uhT) {
        break label529;
      }
      paramInt = 1;
      label401:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.ufd);
      if (!this.uhP) {
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
      paramParcel.writeString(this.uhQ);
      paramParcel.writeInt(this.uhR);
      paramParcel.writeList(this.uhS);
      AppMethodBeat.o(46756);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ElementQuery
 * JD-Core Version:    0.7.0.1
 */