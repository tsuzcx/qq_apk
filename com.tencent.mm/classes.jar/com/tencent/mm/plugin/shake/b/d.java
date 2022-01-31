package com.tencent.mm.plugin.shake.b;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eh;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cbj;
import com.tencent.mm.protocal.protobuf.cfj;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.RegionCodeDecoder;
import java.lang.reflect.Field;
import java.util.Map;

public final class d
  extends eh
{
  protected static c.a info;
  public int bsY;
  private SKBuiltinBuffer_t qMX;
  public int scene;
  
  static
  {
    AppMethodBeat.i(24433);
    c.a locala = new c.a();
    locala.yrK = new Field[20];
    locala.columns = new String[21];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "shakeItemID";
    locala.yrM.put("shakeItemID", "INTEGER default '0'  PRIMARY KEY ");
    localStringBuilder.append(" shakeItemID INTEGER default '0'  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "shakeItemID";
    locala.columns[1] = "username";
    locala.yrM.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "nickname";
    locala.yrM.put("nickname", "TEXT");
    localStringBuilder.append(" nickname TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "province";
    locala.yrM.put("province", "TEXT");
    localStringBuilder.append(" province TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "city";
    locala.yrM.put("city", "TEXT");
    localStringBuilder.append(" city TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "signature";
    locala.yrM.put("signature", "TEXT");
    localStringBuilder.append(" signature TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "distance";
    locala.yrM.put("distance", "TEXT");
    localStringBuilder.append(" distance TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "sex";
    locala.yrM.put("sex", "INTEGER");
    localStringBuilder.append(" sex INTEGER");
    localStringBuilder.append(", ");
    locala.columns[8] = "imgstatus";
    locala.yrM.put("imgstatus", "INTEGER");
    localStringBuilder.append(" imgstatus INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "hasHDImg";
    locala.yrM.put("hasHDImg", "INTEGER");
    localStringBuilder.append(" hasHDImg INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "insertBatch";
    locala.yrM.put("insertBatch", "INTEGER");
    localStringBuilder.append(" insertBatch INTEGER");
    localStringBuilder.append(", ");
    locala.columns[11] = "reserved1";
    locala.yrM.put("reserved1", "INTEGER");
    localStringBuilder.append(" reserved1 INTEGER");
    localStringBuilder.append(", ");
    locala.columns[12] = "reserved2";
    locala.yrM.put("reserved2", "INTEGER");
    localStringBuilder.append(" reserved2 INTEGER");
    localStringBuilder.append(", ");
    locala.columns[13] = "reserved3";
    locala.yrM.put("reserved3", "TEXT");
    localStringBuilder.append(" reserved3 TEXT");
    localStringBuilder.append(", ");
    locala.columns[14] = "reserved4";
    locala.yrM.put("reserved4", "TEXT");
    localStringBuilder.append(" reserved4 TEXT");
    localStringBuilder.append(", ");
    locala.columns[15] = "type";
    locala.yrM.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[16] = "lvbuffer";
    locala.yrM.put("lvbuffer", "BLOB");
    localStringBuilder.append(" lvbuffer BLOB");
    localStringBuilder.append(", ");
    locala.columns[17] = "regionCode";
    locala.yrM.put("regionCode", "TEXT");
    localStringBuilder.append(" regionCode TEXT");
    localStringBuilder.append(", ");
    locala.columns[18] = "snsFlag";
    locala.yrM.put("snsFlag", "INTEGER");
    localStringBuilder.append(" snsFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[19] = "sns_bgurl";
    locala.yrM.put("sns_bgurl", "TEXT");
    localStringBuilder.append(" sns_bgurl TEXT");
    locala.columns[20] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(24433);
  }
  
  public d()
  {
    this.bsY = -1;
    this.field_insertBatch = 2;
  }
  
  public d(cbj paramcbj)
  {
    AppMethodBeat.i(24428);
    this.bsY = -1;
    this.field_username = paramcbj.jJA;
    this.field_nickname = paramcbj.jKG;
    this.field_signature = paramcbj.gwS;
    this.field_distance = paramcbj.xpd;
    this.field_reserved4 = String.valueOf(paramcbj.xMc);
    this.field_sex = paramcbj.gwP;
    this.field_imgstatus = paramcbj.woS;
    this.field_hasHDImg = paramcbj.xMa;
    this.field_reserved1 = paramcbj.xpe;
    this.field_reserved3 = paramcbj.xpf;
    this.field_insertBatch = 2;
    if (paramcbj.xpk != null)
    {
      this.field_snsFlag = paramcbj.xpk.gxa;
      this.field_sns_bgurl = paramcbj.xpk.gxb;
    }
    this.qMX = paramcbj.xMb;
    this.field_province = paramcbj.gwQ;
    this.field_city = paramcbj.gwR;
    this.field_regionCode = RegionCodeDecoder.aF(paramcbj.gwY, this.field_province, this.field_city);
    AppMethodBeat.o(24428);
  }
  
  private int ckS()
  {
    AppMethodBeat.i(24431);
    try
    {
      int i = Integer.valueOf(this.field_reserved4).intValue();
      return i;
    }
    finally
    {
      AppMethodBeat.o(24431);
    }
    return 0;
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(24432);
    ContentValues localContentValues = new ContentValues();
    if ((this.bsY & 0x2) != 0) {
      localContentValues.put("username", this.field_username);
    }
    if ((this.bsY & 0x4) != 0) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if ((this.bsY & 0x8) != 0) {
      localContentValues.put("province", getProvince());
    }
    if ((this.bsY & 0x10) != 0) {
      localContentValues.put("city", getCity());
    }
    if ((this.bsY & 0x20) != 0) {
      localContentValues.put("signature", this.field_signature);
    }
    if ((this.bsY & 0x40) != 0) {
      localContentValues.put("distance", this.field_distance);
    }
    if ((this.bsY & 0x80) != 0) {
      localContentValues.put("sex", Integer.valueOf(this.field_sex));
    }
    if ((this.bsY & 0x100) != 0) {
      localContentValues.put("imgstatus", Integer.valueOf(this.field_imgstatus));
    }
    if ((this.bsY & 0x200) != 0) {
      localContentValues.put("hasHDImg", Integer.valueOf(this.field_hasHDImg));
    }
    if ((this.bsY & 0x400) != 0) {
      localContentValues.put("insertBatch", Integer.valueOf(this.field_insertBatch));
    }
    if ((this.bsY & 0x800) != 0) {
      localContentValues.put("reserved1", Integer.valueOf(this.field_reserved1));
    }
    if ((this.bsY & 0x1000) != 0) {
      localContentValues.put("reserved2", Integer.valueOf(this.field_reserved2));
    }
    if ((this.bsY & 0x2000) != 0) {
      localContentValues.put("reserved3", this.field_reserved3);
    }
    if ((this.bsY & 0x4000) != 0) {
      localContentValues.put("reserved4", Integer.valueOf(ckS()));
    }
    if ((this.bsY & 0x8000) != 0) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if ((this.bsY & 0x10000) != 0) {
      localContentValues.put("lvbuffer", this.field_lvbuffer);
    }
    if ((this.bsY & 0x20000) != 0) {
      localContentValues.put("regionCode", this.field_regionCode);
    }
    if ((this.bsY & 0x40000) != 0) {
      localContentValues.put("snsFlag", Integer.valueOf(this.field_snsFlag));
    }
    if ((this.bsY & 0x80000) != 0) {
      localContentValues.put("sns_bgurl", this.field_sns_bgurl);
    }
    AppMethodBeat.o(24432);
    return localContentValues;
  }
  
  public final String getCity()
  {
    AppMethodBeat.i(24430);
    Object localObject;
    if (!bo.isNullOrNil(this.field_regionCode))
    {
      localObject = this.field_regionCode.split("_");
      if (localObject.length > 0)
      {
        if (localObject.length <= 2) {
          break label71;
        }
        RegionCodeDecoder.dyE();
        this.field_city = RegionCodeDecoder.aG(localObject[0], localObject[1], localObject[2]);
      }
    }
    for (;;)
    {
      localObject = this.field_city;
      AppMethodBeat.o(24430);
      return localObject;
      label71:
      if (localObject.length == 2)
      {
        RegionCodeDecoder.dyE();
        this.field_city = RegionCodeDecoder.iq(localObject[0], localObject[1]);
      }
      else
      {
        this.field_city = "";
      }
    }
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
  
  public final String getProvince()
  {
    AppMethodBeat.i(24429);
    Object localObject;
    if (!bo.isNullOrNil(this.field_regionCode))
    {
      localObject = this.field_regionCode.split("_");
      if (localObject.length > 0)
      {
        if ((localObject.length <= 2) || (!localObject[0].equalsIgnoreCase("cn"))) {
          break label80;
        }
        RegionCodeDecoder.dyE();
      }
    }
    for (this.field_province = RegionCodeDecoder.iq(localObject[0], localObject[1]);; this.field_province = RegionCodeDecoder.asy(localObject[0]))
    {
      localObject = this.field_province;
      AppMethodBeat.o(24429);
      return localObject;
      label80:
      RegionCodeDecoder.dyE();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.b.d
 * JD-Core Version:    0.7.0.1
 */