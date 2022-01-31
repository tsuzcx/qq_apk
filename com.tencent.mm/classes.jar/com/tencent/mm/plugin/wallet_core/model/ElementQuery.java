package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class ElementQuery
  implements Parcelable
{
  public static final Parcelable.Creator<ElementQuery> CREATOR = new ElementQuery.1();
  public static String quV = "bind_serial";
  public JSONObject efa;
  public String lnT;
  public String mOb;
  public String mOc;
  public int qqY;
  public String qsQ;
  public String quW;
  public boolean quX;
  public boolean quY;
  public boolean quZ;
  public ArrayList<CreTypeRuleInfo> qvA;
  public boolean qvB = false;
  public boolean qva;
  public String qvb;
  public String qvc;
  public boolean qvd;
  public int qve;
  public int qvf;
  public String qvg;
  public String qvh;
  public String qvi;
  public String qvj;
  public String qvk;
  public String qvl;
  public boolean qvm;
  public boolean qvn;
  public boolean qvo;
  public boolean qvp;
  public boolean qvq;
  public boolean qvr;
  public boolean qvs;
  public boolean qvt;
  public boolean qvu;
  public String qvv;
  private List<Integer> qvw = null;
  public boolean qvx;
  public String qvy;
  public int qvz;
  
  public ElementQuery() {}
  
  public ElementQuery(Parcel paramParcel)
  {
    this.mOc = paramParcel.readString();
    this.lnT = paramParcel.readString();
    this.quW = paramParcel.readString();
    if (1 == paramParcel.readInt())
    {
      bool1 = true;
      this.quX = bool1;
      if (1 != paramParcel.readInt()) {
        break label427;
      }
      bool1 = true;
      label65:
      this.quY = bool1;
      if (1 != paramParcel.readInt()) {
        break label432;
      }
      bool1 = true;
      label80:
      this.quZ = bool1;
      if (1 != paramParcel.readInt()) {
        break label437;
      }
      bool1 = true;
      label95:
      this.qva = bool1;
      this.qvc = paramParcel.readString();
      this.mOc = paramParcel.readString();
      if (1 != paramParcel.readInt()) {
        break label442;
      }
      bool1 = true;
      label126:
      this.qvd = bool1;
      this.qve = paramParcel.readInt();
      this.qvf = paramParcel.readInt();
      this.mOb = paramParcel.readString();
      this.qvg = paramParcel.readString();
      this.qvh = paramParcel.readString();
      this.qvi = paramParcel.readString();
      this.qvl = paramParcel.readString();
      this.qvk = paramParcel.readString();
      this.qvj = paramParcel.readString();
      if (1 != paramParcel.readInt()) {
        break label447;
      }
      bool1 = true;
      label213:
      this.qvm = bool1;
      if (1 != paramParcel.readInt()) {
        break label452;
      }
      bool1 = true;
      label228:
      this.qvn = bool1;
      if (1 != paramParcel.readInt()) {
        break label457;
      }
      bool1 = true;
      label243:
      this.qvo = bool1;
      if (1 != paramParcel.readInt()) {
        break label462;
      }
      bool1 = true;
      label258:
      this.qvp = bool1;
      if (1 != paramParcel.readInt()) {
        break label467;
      }
      bool1 = true;
      label273:
      this.qvq = bool1;
      if (1 != paramParcel.readInt()) {
        break label472;
      }
      bool1 = true;
      label288:
      this.qvr = bool1;
      if (1 != paramParcel.readInt()) {
        break label477;
      }
      bool1 = true;
      label303:
      this.qvt = bool1;
      if (1 != paramParcel.readInt()) {
        break label482;
      }
      bool1 = true;
      label318:
      this.qvs = bool1;
      if (1 != paramParcel.readInt()) {
        break label487;
      }
      bool1 = true;
      label333:
      this.qvu = bool1;
      this.qqY = paramParcel.readInt();
      this.qvv = paramParcel.readString();
      if (1 != paramParcel.readInt()) {
        break label492;
      }
      bool1 = true;
      label364:
      this.qvB = bool1;
      this.qsQ = paramParcel.readString();
      if (1 != paramParcel.readInt()) {
        break label497;
      }
    }
    label427:
    label432:
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
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.qvx = bool1;
      this.qvy = paramParcel.readString();
      this.qvz = paramParcel.readInt();
      this.qvA = paramParcel.readArrayList(CreTypeRuleInfo.class.getClassLoader());
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label65;
      bool1 = false;
      break label80;
      bool1 = false;
      break label95;
      bool1 = false;
      break label126;
      bool1 = false;
      break label213;
      bool1 = false;
      break label228;
      bool1 = false;
      break label243;
      bool1 = false;
      break label258;
      bool1 = false;
      break label273;
      bool1 = false;
      break label288;
      bool1 = false;
      break label303;
      bool1 = false;
      break label318;
      bool1 = false;
      break label333;
      bool1 = false;
      break label364;
    }
  }
  
  public static ArrayList<CreTypeRuleInfo> aq(JSONObject paramJSONObject)
  {
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
          CreTypeRuleInfo localCreTypeRuleInfo = CreTypeRuleInfo.ap(paramJSONObject.optJSONObject(i));
          if (localCreTypeRuleInfo != null) {
            localArrayList.add(localCreTypeRuleInfo);
          }
          i += 1;
        }
      }
    }
    return localArrayList;
  }
  
  public final boolean bUS()
  {
    return 2 == this.qvf;
  }
  
  public final boolean bVc()
  {
    return 1 == this.qvf;
  }
  
  public final List<Integer> bVd()
  {
    if (this.qvw != null) {
      return this.qvw;
    }
    if (!bk.bl(this.qvv))
    {
      this.qvw = new ArrayList();
      String[] arrayOfString = this.qvv.split("\\|");
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        int k = bk.getInt(arrayOfString[i], 0);
        if (k > 0) {
          this.qvw.add(Integer.valueOf(k));
        }
        i += 1;
      }
      return this.qvw;
    }
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final boolean isError()
  {
    return "0".equals(bk.aM(this.qvh, "").trim());
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeString(bk.aM(this.mOc, ""));
    paramParcel.writeString(bk.aM(this.lnT, ""));
    paramParcel.writeString(bk.aM(this.quW, ""));
    if (this.quX)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.quY) {
        break label452;
      }
      paramInt = 1;
      label64:
      paramParcel.writeInt(paramInt);
      if (!this.quZ) {
        break label457;
      }
      paramInt = 1;
      label78:
      paramParcel.writeInt(paramInt);
      if (!this.qva) {
        break label462;
      }
      paramInt = 1;
      label92:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(bk.aM(this.qvc, ""));
      paramParcel.writeString(bk.aM(this.mOc, ""));
      if (!this.qvd) {
        break label467;
      }
      paramInt = 1;
      label132:
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.qve);
      paramParcel.writeInt(this.qvf);
      paramParcel.writeString(bk.aM(this.mOb, ""));
      paramParcel.writeString(bk.aM(this.qvg, ""));
      paramParcel.writeString(bk.aM(this.qvh, ""));
      paramParcel.writeString(bk.aM(this.qvi, ""));
      paramParcel.writeString(bk.aM(this.qvl, ""));
      paramParcel.writeString(bk.aM(this.qvk, ""));
      paramParcel.writeString(bk.aM(this.qvj, ""));
      if (!this.qvm) {
        break label472;
      }
      paramInt = 1;
      label253:
      paramParcel.writeInt(paramInt);
      if (!this.qvn) {
        break label477;
      }
      paramInt = 1;
      label267:
      paramParcel.writeInt(paramInt);
      if (!this.qvo) {
        break label482;
      }
      paramInt = 1;
      label281:
      paramParcel.writeInt(paramInt);
      if (!this.qvp) {
        break label487;
      }
      paramInt = 1;
      label295:
      paramParcel.writeInt(paramInt);
      if (!this.qvq) {
        break label492;
      }
      paramInt = 1;
      label309:
      paramParcel.writeInt(paramInt);
      if (!this.qvr) {
        break label497;
      }
      paramInt = 1;
      label323:
      paramParcel.writeInt(paramInt);
      if (!this.qvt) {
        break label502;
      }
      paramInt = 1;
      label337:
      paramParcel.writeInt(paramInt);
      if (!this.qvs) {
        break label507;
      }
      paramInt = 1;
      label351:
      paramParcel.writeInt(paramInt);
      if (!this.qvu) {
        break label512;
      }
      paramInt = 1;
      label365:
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.qqY);
      paramParcel.writeString(this.qvv);
      if (!this.qvB) {
        break label517;
      }
      paramInt = 1;
      label395:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.qsQ);
      if (!this.qvx) {
        break label522;
      }
    }
    label512:
    label517:
    label522:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.qvy);
      paramParcel.writeInt(this.qvz);
      paramParcel.writeList(this.qvA);
      return;
      paramInt = 0;
      break;
      label452:
      paramInt = 0;
      break label64;
      label457:
      paramInt = 0;
      break label78;
      label462:
      paramInt = 0;
      break label92;
      label467:
      paramInt = 0;
      break label132;
      label472:
      paramInt = 0;
      break label253;
      label477:
      paramInt = 0;
      break label267;
      label482:
      paramInt = 0;
      break label281;
      label487:
      paramInt = 0;
      break label295;
      label492:
      paramInt = 0;
      break label309;
      label497:
      paramInt = 0;
      break label323;
      label502:
      paramInt = 0;
      break label337;
      label507:
      paramInt = 0;
      break label351;
      paramInt = 0;
      break label365;
      paramInt = 0;
      break label395;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ElementQuery
 * JD-Core Version:    0.7.0.1
 */