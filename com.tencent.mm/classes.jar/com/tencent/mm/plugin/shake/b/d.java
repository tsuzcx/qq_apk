package com.tencent.mm.plugin.shake.b;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ga;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dwv;
import com.tencent.mm.protocal.protobuf.ebj;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.storage.RegionCodeDecoder;
import java.lang.reflect.Field;
import java.util.Map;

public final class d
  extends ga
{
  protected static IAutoDBItem.MAutoDBInfo info;
  private SKBuiltinBuffer_t DgQ;
  public int cSx;
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
    this.cSx = -1;
    this.field_insertBatch = 2;
  }
  
  public d(dwv paramdwv)
  {
    AppMethodBeat.i(28103);
    this.cSx = -1;
    this.field_username = paramdwv.UserName;
    this.field_nickname = paramdwv.oUJ;
    this.field_signature = paramdwv.keb;
    this.field_distance = paramdwv.MmJ;
    this.field_reserved4 = String.valueOf(paramdwv.MWR);
    this.field_sex = paramdwv.kdY;
    this.field_imgstatus = paramdwv.KHo;
    this.field_hasHDImg = paramdwv.MWP;
    this.field_reserved1 = paramdwv.MmK;
    this.field_reserved3 = paramdwv.MmL;
    this.field_insertBatch = 2;
    if (paramdwv.MmQ != null)
    {
      this.field_snsFlag = paramdwv.MmQ.kej;
      this.field_sns_bgurl = paramdwv.MmQ.kek;
    }
    this.DgQ = paramdwv.MWQ;
    this.field_province = paramdwv.kdZ;
    this.field_city = paramdwv.kea;
    this.field_regionCode = RegionCodeDecoder.bq(paramdwv.keh, this.field_province, this.field_city);
    AppMethodBeat.o(28103);
  }
  
  private int eTR()
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
    if ((this.cSx & 0x2) != 0) {
      localContentValues.put("username", this.field_username);
    }
    if ((this.cSx & 0x4) != 0) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if ((this.cSx & 0x8) != 0) {
      localContentValues.put("province", getProvince());
    }
    if ((this.cSx & 0x10) != 0) {
      localContentValues.put("city", getCity());
    }
    if ((this.cSx & 0x20) != 0) {
      localContentValues.put("signature", this.field_signature);
    }
    if ((this.cSx & 0x40) != 0) {
      localContentValues.put("distance", this.field_distance);
    }
    if ((this.cSx & 0x80) != 0) {
      localContentValues.put("sex", Integer.valueOf(this.field_sex));
    }
    if ((this.cSx & 0x100) != 0) {
      localContentValues.put("imgstatus", Integer.valueOf(this.field_imgstatus));
    }
    if ((this.cSx & 0x200) != 0) {
      localContentValues.put("hasHDImg", Integer.valueOf(this.field_hasHDImg));
    }
    if ((this.cSx & 0x400) != 0) {
      localContentValues.put("insertBatch", Integer.valueOf(this.field_insertBatch));
    }
    if ((this.cSx & 0x800) != 0) {
      localContentValues.put("reserved1", Integer.valueOf(this.field_reserved1));
    }
    if ((this.cSx & 0x1000) != 0) {
      localContentValues.put("reserved2", Integer.valueOf(this.field_reserved2));
    }
    if ((this.cSx & 0x2000) != 0) {
      localContentValues.put("reserved3", this.field_reserved3);
    }
    if ((this.cSx & 0x4000) != 0) {
      localContentValues.put("reserved4", Integer.valueOf(eTR()));
    }
    if ((this.cSx & 0x8000) != 0) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if ((this.cSx & 0x10000) != 0) {
      localContentValues.put("lvbuffer", this.field_lvbuffer);
    }
    if ((this.cSx & 0x20000) != 0) {
      localContentValues.put("regionCode", this.field_regionCode);
    }
    if ((this.cSx & 0x40000) != 0) {
      localContentValues.put("snsFlag", Integer.valueOf(this.field_snsFlag));
    }
    if ((this.cSx & 0x80000) != 0) {
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
        RegionCodeDecoder.gEm();
        this.field_city = RegionCodeDecoder.bs(localObject[0], localObject[1], localObject[2]);
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
        RegionCodeDecoder.gEm();
        this.field_city = RegionCodeDecoder.mW(localObject[0], localObject[1]);
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
        RegionCodeDecoder.gEm();
      }
    }
    for (this.field_province = RegionCodeDecoder.mW(localObject[0], localObject[1]);; this.field_province = RegionCodeDecoder.bkP(localObject[0]))
    {
      localObject = this.field_province;
      AppMethodBeat.o(28104);
      return localObject;
      label80:
      RegionCodeDecoder.gEm();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.b.d
 * JD-Core Version:    0.7.0.1
 */