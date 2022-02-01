package com.tencent.mm.plugin.shake.b;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.gh;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.egw;
import com.tencent.mm.protocal.protobuf.elj;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.storage.RegionCodeDecoder;
import java.lang.reflect.Field;
import java.util.Map;

public final class d
  extends gh
{
  protected static IAutoDBItem.MAutoDBInfo info;
  private eae Jmw;
  public int cUP;
  public int scene;
  
  static
  {
    AppMethodBeat.i(28108);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[20];
    localMAutoDBInfo.columns = new String[21];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "shakeItemID";
    localMAutoDBInfo.colsMap.put("shakeItemID", "INTEGER default '0'  PRIMARY KEY ");
    localStringBuilder.append(" shakeItemID INTEGER default '0'  PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "shakeItemID";
    localMAutoDBInfo.columns[1] = "username";
    localMAutoDBInfo.colsMap.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "nickname";
    localMAutoDBInfo.colsMap.put("nickname", "TEXT");
    localStringBuilder.append(" nickname TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "province";
    localMAutoDBInfo.colsMap.put("province", "TEXT");
    localStringBuilder.append(" province TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "city";
    localMAutoDBInfo.colsMap.put("city", "TEXT");
    localStringBuilder.append(" city TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "signature";
    localMAutoDBInfo.colsMap.put("signature", "TEXT");
    localStringBuilder.append(" signature TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "distance";
    localMAutoDBInfo.colsMap.put("distance", "TEXT");
    localStringBuilder.append(" distance TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "sex";
    localMAutoDBInfo.colsMap.put("sex", "INTEGER");
    localStringBuilder.append(" sex INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "imgstatus";
    localMAutoDBInfo.colsMap.put("imgstatus", "INTEGER");
    localStringBuilder.append(" imgstatus INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "hasHDImg";
    localMAutoDBInfo.colsMap.put("hasHDImg", "INTEGER");
    localStringBuilder.append(" hasHDImg INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "insertBatch";
    localMAutoDBInfo.colsMap.put("insertBatch", "INTEGER");
    localStringBuilder.append(" insertBatch INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "reserved1";
    localMAutoDBInfo.colsMap.put("reserved1", "INTEGER");
    localStringBuilder.append(" reserved1 INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "reserved2";
    localMAutoDBInfo.colsMap.put("reserved2", "INTEGER");
    localStringBuilder.append(" reserved2 INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "reserved3";
    localMAutoDBInfo.colsMap.put("reserved3", "TEXT");
    localStringBuilder.append(" reserved3 TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "reserved4";
    localMAutoDBInfo.colsMap.put("reserved4", "TEXT");
    localStringBuilder.append(" reserved4 TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "type";
    localMAutoDBInfo.colsMap.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "lvbuffer";
    localMAutoDBInfo.colsMap.put("lvbuffer", "BLOB");
    localStringBuilder.append(" lvbuffer BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "regionCode";
    localMAutoDBInfo.colsMap.put("regionCode", "TEXT");
    localStringBuilder.append(" regionCode TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[18] = "snsFlag";
    localMAutoDBInfo.colsMap.put("snsFlag", "INTEGER");
    localStringBuilder.append(" snsFlag INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[19] = "sns_bgurl";
    localMAutoDBInfo.colsMap.put("sns_bgurl", "TEXT");
    localStringBuilder.append(" sns_bgurl TEXT");
    localMAutoDBInfo.columns[20] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(28108);
  }
  
  public d()
  {
    this.cUP = -1;
    this.field_insertBatch = 2;
  }
  
  public d(egw paramegw)
  {
    AppMethodBeat.i(28103);
    this.cUP = -1;
    this.field_username = paramegw.UserName;
    this.field_nickname = paramegw.rWI;
    this.field_signature = paramegw.mVB;
    this.field_distance = paramegw.TxE;
    this.field_reserved4 = String.valueOf(paramegw.Ujm);
    this.field_sex = paramegw.mVy;
    this.field_imgstatus = paramegw.RIG;
    this.field_hasHDImg = paramegw.Ujk;
    this.field_reserved1 = paramegw.TxF;
    this.field_reserved3 = paramegw.TxG;
    this.field_insertBatch = 2;
    if (paramegw.TxL != null)
    {
      this.field_snsFlag = paramegw.TxL.mVJ;
      this.field_sns_bgurl = paramegw.TxL.mVK;
    }
    this.Jmw = paramegw.Ujl;
    this.field_province = paramegw.mVz;
    this.field_city = paramegw.mVA;
    this.field_regionCode = RegionCodeDecoder.bl(paramegw.mVH, this.field_province, this.field_city);
    AppMethodBeat.o(28103);
  }
  
  private int fGT()
  {
    AppMethodBeat.i(28106);
    try
    {
      int i = Integer.valueOf(this.field_reserved4).intValue();
      return i;
    }
    finally
    {
      AppMethodBeat.o(28106);
    }
    return 0;
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(28107);
    ContentValues localContentValues = new ContentValues();
    if ((this.cUP & 0x2) != 0) {
      localContentValues.put("username", this.field_username);
    }
    if ((this.cUP & 0x4) != 0) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if ((this.cUP & 0x8) != 0) {
      localContentValues.put("province", getProvince());
    }
    if ((this.cUP & 0x10) != 0) {
      localContentValues.put("city", getCity());
    }
    if ((this.cUP & 0x20) != 0) {
      localContentValues.put("signature", this.field_signature);
    }
    if ((this.cUP & 0x40) != 0) {
      localContentValues.put("distance", this.field_distance);
    }
    if ((this.cUP & 0x80) != 0) {
      localContentValues.put("sex", Integer.valueOf(this.field_sex));
    }
    if ((this.cUP & 0x100) != 0) {
      localContentValues.put("imgstatus", Integer.valueOf(this.field_imgstatus));
    }
    if ((this.cUP & 0x200) != 0) {
      localContentValues.put("hasHDImg", Integer.valueOf(this.field_hasHDImg));
    }
    if ((this.cUP & 0x400) != 0) {
      localContentValues.put("insertBatch", Integer.valueOf(this.field_insertBatch));
    }
    if ((this.cUP & 0x800) != 0) {
      localContentValues.put("reserved1", Integer.valueOf(this.field_reserved1));
    }
    if ((this.cUP & 0x1000) != 0) {
      localContentValues.put("reserved2", Integer.valueOf(this.field_reserved2));
    }
    if ((this.cUP & 0x2000) != 0) {
      localContentValues.put("reserved3", this.field_reserved3);
    }
    if ((this.cUP & 0x4000) != 0) {
      localContentValues.put("reserved4", Integer.valueOf(fGT()));
    }
    if ((this.cUP & 0x8000) != 0) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if ((this.cUP & 0x10000) != 0) {
      localContentValues.put("lvbuffer", this.field_lvbuffer);
    }
    if ((this.cUP & 0x20000) != 0) {
      localContentValues.put("regionCode", this.field_regionCode);
    }
    if ((this.cUP & 0x40000) != 0) {
      localContentValues.put("snsFlag", Integer.valueOf(this.field_snsFlag));
    }
    if ((this.cUP & 0x80000) != 0) {
      localContentValues.put("sns_bgurl", this.field_sns_bgurl);
    }
    AppMethodBeat.o(28107);
    return localContentValues;
  }
  
  public final String getCity()
  {
    AppMethodBeat.i(28105);
    Object localObject;
    if (!Util.isNullOrNil(this.field_regionCode))
    {
      localObject = this.field_regionCode.split("_");
      if (localObject.length > 0)
      {
        if (localObject.length <= 2) {
          break label71;
        }
        RegionCodeDecoder.hAC();
        this.field_city = RegionCodeDecoder.bn(localObject[0], localObject[1], localObject[2]);
      }
    }
    for (;;)
    {
      localObject = this.field_city;
      AppMethodBeat.o(28105);
      return localObject;
      label71:
      if (localObject.length == 2)
      {
        RegionCodeDecoder.hAC();
        this.field_city = RegionCodeDecoder.nO(localObject[0], localObject[1]);
      }
      else
      {
        this.field_city = "";
      }
    }
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final String getProvince()
  {
    AppMethodBeat.i(28104);
    Object localObject;
    if (!Util.isNullOrNil(this.field_regionCode))
    {
      localObject = this.field_regionCode.split("_");
      if (localObject.length > 0)
      {
        if ((localObject.length <= 2) || (!localObject[0].equalsIgnoreCase("cn"))) {
          break label80;
        }
        RegionCodeDecoder.hAC();
      }
    }
    for (this.field_province = RegionCodeDecoder.nO(localObject[0], localObject[1]);; this.field_province = RegionCodeDecoder.bxp(localObject[0]))
    {
      localObject = this.field_province;
      AppMethodBeat.o(28104);
      return localObject;
      label80:
      RegionCodeDecoder.hAC();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.b.d
 * JD-Core Version:    0.7.0.1
 */