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
  public static String VEV;
  public String JFk;
  public String MDt;
  public String VCG;
  public String VEW;
  public boolean VEX;
  public boolean VEY;
  public boolean VEZ;
  public ArrayList<CreTypeRuleInfo> VFA;
  public boolean VFB;
  public boolean VFa;
  public String VFb;
  public String VFc;
  public boolean VFd;
  public int VFe;
  public int VFf;
  public String VFg;
  public String VFh;
  public String VFi;
  public String VFj;
  public String VFk;
  public String VFl;
  public boolean VFm;
  public boolean VFn;
  public boolean VFo;
  public boolean VFp;
  public boolean VFq;
  public boolean VFr;
  public boolean VFs;
  public boolean VFt;
  public boolean VFu;
  public String VFv;
  private List<Integer> VFw;
  public boolean VFx;
  public String VFy;
  public int VFz;
  public int Vyb;
  public String hAk;
  public JSONObject hcG;
  
  static
  {
    AppMethodBeat.i(70274);
    VEV = "bind_serial";
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(70274);
  }
  
  public ElementQuery()
  {
    this.VFw = null;
    this.VFB = false;
  }
  
  public ElementQuery(Parcel paramParcel)
  {
    AppMethodBeat.i(70272);
    this.VFw = null;
    this.VFB = false;
    this.MDt = paramParcel.readString();
    this.JFk = paramParcel.readString();
    this.VEW = paramParcel.readString();
    if (1 == paramParcel.readInt())
    {
      bool1 = true;
      this.VEX = bool1;
      if (1 != paramParcel.readInt()) {
        break label437;
      }
      bool1 = true;
      label70:
      this.VEY = bool1;
      if (1 != paramParcel.readInt()) {
        break label442;
      }
      bool1 = true;
      label85:
      this.VEZ = bool1;
      if (1 != paramParcel.readInt()) {
        break label447;
      }
      bool1 = true;
      label100:
      this.VFa = bool1;
      this.VFc = paramParcel.readString();
      this.MDt = paramParcel.readString();
      if (1 != paramParcel.readInt()) {
        break label452;
      }
      bool1 = true;
      label131:
      this.VFd = bool1;
      this.VFe = paramParcel.readInt();
      this.VFf = paramParcel.readInt();
      this.hAk = paramParcel.readString();
      this.VFg = paramParcel.readString();
      this.VFh = paramParcel.readString();
      this.VFi = paramParcel.readString();
      this.VFl = paramParcel.readString();
      this.VFk = paramParcel.readString();
      this.VFj = paramParcel.readString();
      if (1 != paramParcel.readInt()) {
        break label457;
      }
      bool1 = true;
      label218:
      this.VFm = bool1;
      if (1 != paramParcel.readInt()) {
        break label462;
      }
      bool1 = true;
      label233:
      this.VFn = bool1;
      if (1 != paramParcel.readInt()) {
        break label467;
      }
      bool1 = true;
      label248:
      this.VFo = bool1;
      if (1 != paramParcel.readInt()) {
        break label472;
      }
      bool1 = true;
      label263:
      this.VFp = bool1;
      if (1 != paramParcel.readInt()) {
        break label477;
      }
      bool1 = true;
      label278:
      this.VFq = bool1;
      if (1 != paramParcel.readInt()) {
        break label482;
      }
      bool1 = true;
      label293:
      this.VFr = bool1;
      if (1 != paramParcel.readInt()) {
        break label487;
      }
      bool1 = true;
      label308:
      this.VFt = bool1;
      if (1 != paramParcel.readInt()) {
        break label492;
      }
      bool1 = true;
      label323:
      this.VFs = bool1;
      if (1 != paramParcel.readInt()) {
        break label497;
      }
      bool1 = true;
      label338:
      this.VFu = bool1;
      this.Vyb = paramParcel.readInt();
      this.VFv = paramParcel.readString();
      if (1 != paramParcel.readInt()) {
        break label502;
      }
      bool1 = true;
      label369:
      this.VFB = bool1;
      this.VCG = paramParcel.readString();
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
      this.VFx = bool1;
      this.VFy = paramParcel.readString();
      this.VFz = paramParcel.readInt();
      this.VFA = paramParcel.readArrayList(CreTypeRuleInfo.class.getClassLoader());
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
  
  public static ArrayList<CreTypeRuleInfo> cm(JSONObject paramJSONObject)
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
          CreTypeRuleInfo localCreTypeRuleInfo = CreTypeRuleInfo.ck(paramJSONObject.optJSONObject(i));
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
  
  public final boolean ihX()
  {
    return 2 == this.VFf;
  }
  
  public final boolean iil()
  {
    return 1 == this.VFf;
  }
  
  public final List<Integer> iim()
  {
    AppMethodBeat.i(70270);
    Object localObject;
    if (this.VFw != null)
    {
      localObject = this.VFw;
      AppMethodBeat.o(70270);
      return localObject;
    }
    if (!Util.isNullOrNil(this.VFv))
    {
      this.VFw = new ArrayList();
      localObject = this.VFv.split("\\|");
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        int k = Util.getInt(localObject[i], 0);
        if (k > 0) {
          this.VFw.add(Integer.valueOf(k));
        }
        i += 1;
      }
      localObject = this.VFw;
      AppMethodBeat.o(70270);
      return localObject;
    }
    AppMethodBeat.o(70270);
    return null;
  }
  
  public final boolean isError()
  {
    AppMethodBeat.i(70269);
    boolean bool = "0".equals(Util.nullAs(this.VFh, "").trim());
    AppMethodBeat.o(70269);
    return bool;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(70273);
    paramParcel.writeString(Util.nullAs(this.MDt, ""));
    paramParcel.writeString(Util.nullAs(this.JFk, ""));
    paramParcel.writeString(Util.nullAs(this.VEW, ""));
    if (this.VEX)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.VEY) {
        break label464;
      }
      paramInt = 1;
      label70:
      paramParcel.writeInt(paramInt);
      if (!this.VEZ) {
        break label469;
      }
      paramInt = 1;
      label84:
      paramParcel.writeInt(paramInt);
      if (!this.VFa) {
        break label474;
      }
      paramInt = 1;
      label98:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(Util.nullAs(this.VFc, ""));
      paramParcel.writeString(Util.nullAs(this.MDt, ""));
      if (!this.VFd) {
        break label479;
      }
      paramInt = 1;
      label138:
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.VFe);
      paramParcel.writeInt(this.VFf);
      paramParcel.writeString(Util.nullAs(this.hAk, ""));
      paramParcel.writeString(Util.nullAs(this.VFg, ""));
      paramParcel.writeString(Util.nullAs(this.VFh, ""));
      paramParcel.writeString(Util.nullAs(this.VFi, ""));
      paramParcel.writeString(Util.nullAs(this.VFl, ""));
      paramParcel.writeString(Util.nullAs(this.VFk, ""));
      paramParcel.writeString(Util.nullAs(this.VFj, ""));
      if (!this.VFm) {
        break label484;
      }
      paramInt = 1;
      label259:
      paramParcel.writeInt(paramInt);
      if (!this.VFn) {
        break label489;
      }
      paramInt = 1;
      label273:
      paramParcel.writeInt(paramInt);
      if (!this.VFo) {
        break label494;
      }
      paramInt = 1;
      label287:
      paramParcel.writeInt(paramInt);
      if (!this.VFp) {
        break label499;
      }
      paramInt = 1;
      label301:
      paramParcel.writeInt(paramInt);
      if (!this.VFq) {
        break label504;
      }
      paramInt = 1;
      label315:
      paramParcel.writeInt(paramInt);
      if (!this.VFr) {
        break label509;
      }
      paramInt = 1;
      label329:
      paramParcel.writeInt(paramInt);
      if (!this.VFt) {
        break label514;
      }
      paramInt = 1;
      label343:
      paramParcel.writeInt(paramInt);
      if (!this.VFs) {
        break label519;
      }
      paramInt = 1;
      label357:
      paramParcel.writeInt(paramInt);
      if (!this.VFu) {
        break label524;
      }
      paramInt = 1;
      label371:
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.Vyb);
      paramParcel.writeString(this.VFv);
      if (!this.VFB) {
        break label529;
      }
      paramInt = 1;
      label401:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.VCG);
      if (!this.VFx) {
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
      paramParcel.writeString(this.VFy);
      paramParcel.writeInt(this.VFz);
      paramParcel.writeList(this.VFA);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ElementQuery
 * JD-Core Version:    0.7.0.1
 */