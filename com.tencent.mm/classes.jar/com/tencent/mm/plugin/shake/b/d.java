package com.tencent.mm.plugin.shake.b;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fr;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ddr;
import com.tencent.mm.protocal.protobuf.dia;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.RegionCodeDecoder;
import java.lang.reflect.Field;
import java.util.Map;

public final class d
  extends fr
{
  protected static c.a info;
  public int dEu;
  public int scene;
  private SKBuiltinBuffer_t zbY;
  
  static
  {
    AppMethodBeat.i(28108);
    c.a locala = new c.a();
    locala.IBL = new Field[20];
    locala.columns = new String[21];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "shakeItemID";
    locala.IBN.put("shakeItemID", "INTEGER default '0'  PRIMARY KEY ");
    localStringBuilder.append(" shakeItemID INTEGER default '0'  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "shakeItemID";
    locala.columns[1] = "username";
    locala.IBN.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "nickname";
    locala.IBN.put("nickname", "TEXT");
    localStringBuilder.append(" nickname TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "province";
    locala.IBN.put("province", "TEXT");
    localStringBuilder.append(" province TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "city";
    locala.IBN.put("city", "TEXT");
    localStringBuilder.append(" city TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "signature";
    locala.IBN.put("signature", "TEXT");
    localStringBuilder.append(" signature TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "distance";
    locala.IBN.put("distance", "TEXT");
    localStringBuilder.append(" distance TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "sex";
    locala.IBN.put("sex", "INTEGER");
    localStringBuilder.append(" sex INTEGER");
    localStringBuilder.append(", ");
    locala.columns[8] = "imgstatus";
    locala.IBN.put("imgstatus", "INTEGER");
    localStringBuilder.append(" imgstatus INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "hasHDImg";
    locala.IBN.put("hasHDImg", "INTEGER");
    localStringBuilder.append(" hasHDImg INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "insertBatch";
    locala.IBN.put("insertBatch", "INTEGER");
    localStringBuilder.append(" insertBatch INTEGER");
    localStringBuilder.append(", ");
    locala.columns[11] = "reserved1";
    locala.IBN.put("reserved1", "INTEGER");
    localStringBuilder.append(" reserved1 INTEGER");
    localStringBuilder.append(", ");
    locala.columns[12] = "reserved2";
    locala.IBN.put("reserved2", "INTEGER");
    localStringBuilder.append(" reserved2 INTEGER");
    localStringBuilder.append(", ");
    locala.columns[13] = "reserved3";
    locala.IBN.put("reserved3", "TEXT");
    localStringBuilder.append(" reserved3 TEXT");
    localStringBuilder.append(", ");
    locala.columns[14] = "reserved4";
    locala.IBN.put("reserved4", "TEXT");
    localStringBuilder.append(" reserved4 TEXT");
    localStringBuilder.append(", ");
    locala.columns[15] = "type";
    locala.IBN.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[16] = "lvbuffer";
    locala.IBN.put("lvbuffer", "BLOB");
    localStringBuilder.append(" lvbuffer BLOB");
    localStringBuilder.append(", ");
    locala.columns[17] = "regionCode";
    locala.IBN.put("regionCode", "TEXT");
    localStringBuilder.append(" regionCode TEXT");
    localStringBuilder.append(", ");
    locala.columns[18] = "snsFlag";
    locala.IBN.put("snsFlag", "INTEGER");
    localStringBuilder.append(" snsFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[19] = "sns_bgurl";
    locala.IBN.put("sns_bgurl", "TEXT");
    localStringBuilder.append(" sns_bgurl TEXT");
    locala.columns[20] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(28108);
  }
  
  public d()
  {
    this.dEu = -1;
    this.field_insertBatch = 2;
  }
  
  public d(ddr paramddr)
  {
    AppMethodBeat.i(28103);
    this.dEu = -1;
    this.field_username = paramddr.nIJ;
    this.field_nickname = paramddr.nJO;
    this.field_signature = paramddr.jfY;
    this.field_distance = paramddr.Hht;
    this.field_reserved4 = String.valueOf(paramddr.HLi);
    this.field_sex = paramddr.jfV;
    this.field_imgstatus = paramddr.FNJ;
    this.field_hasHDImg = paramddr.HLg;
    this.field_reserved1 = paramddr.Hhu;
    this.field_reserved3 = paramddr.Hhv;
    this.field_insertBatch = 2;
    if (paramddr.HhA != null)
    {
      this.field_snsFlag = paramddr.HhA.jgg;
      this.field_sns_bgurl = paramddr.HhA.jgh;
    }
    this.zbY = paramddr.HLh;
    this.field_province = paramddr.jfW;
    this.field_city = paramddr.jfX;
    this.field_regionCode = RegionCodeDecoder.bg(paramddr.jge, this.field_province, this.field_city);
    AppMethodBeat.o(28103);
  }
  
  private int dRQ()
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
    if ((this.dEu & 0x2) != 0) {
      localContentValues.put("username", this.field_username);
    }
    if ((this.dEu & 0x4) != 0) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if ((this.dEu & 0x8) != 0) {
      localContentValues.put("province", getProvince());
    }
    if ((this.dEu & 0x10) != 0) {
      localContentValues.put("city", getCity());
    }
    if ((this.dEu & 0x20) != 0) {
      localContentValues.put("signature", this.field_signature);
    }
    if ((this.dEu & 0x40) != 0) {
      localContentValues.put("distance", this.field_distance);
    }
    if ((this.dEu & 0x80) != 0) {
      localContentValues.put("sex", Integer.valueOf(this.field_sex));
    }
    if ((this.dEu & 0x100) != 0) {
      localContentValues.put("imgstatus", Integer.valueOf(this.field_imgstatus));
    }
    if ((this.dEu & 0x200) != 0) {
      localContentValues.put("hasHDImg", Integer.valueOf(this.field_hasHDImg));
    }
    if ((this.dEu & 0x400) != 0) {
      localContentValues.put("insertBatch", Integer.valueOf(this.field_insertBatch));
    }
    if ((this.dEu & 0x800) != 0) {
      localContentValues.put("reserved1", Integer.valueOf(this.field_reserved1));
    }
    if ((this.dEu & 0x1000) != 0) {
      localContentValues.put("reserved2", Integer.valueOf(this.field_reserved2));
    }
    if ((this.dEu & 0x2000) != 0) {
      localContentValues.put("reserved3", this.field_reserved3);
    }
    if ((this.dEu & 0x4000) != 0) {
      localContentValues.put("reserved4", Integer.valueOf(dRQ()));
    }
    if ((this.dEu & 0x8000) != 0) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if ((this.dEu & 0x10000) != 0) {
      localContentValues.put("lvbuffer", this.field_lvbuffer);
    }
    if ((this.dEu & 0x20000) != 0) {
      localContentValues.put("regionCode", this.field_regionCode);
    }
    if ((this.dEu & 0x40000) != 0) {
      localContentValues.put("snsFlag", Integer.valueOf(this.field_snsFlag));
    }
    if ((this.dEu & 0x80000) != 0) {
      localContentValues.put("sns_bgurl", this.field_sns_bgurl);
    }
    AppMethodBeat.o(28107);
    return localContentValues;
  }
  
  public final String getCity()
  {
    AppMethodBeat.i(28105);
    Object localObject;
    if (!bu.isNullOrNil(this.field_regionCode))
    {
      localObject = this.field_regionCode.split("_");
      if (localObject.length > 0)
      {
        if (localObject.length <= 2) {
          break label71;
        }
        RegionCodeDecoder.fwA();
        this.field_city = RegionCodeDecoder.bi(localObject[0], localObject[1], localObject[2]);
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
        RegionCodeDecoder.fwA();
        this.field_city = RegionCodeDecoder.mi(localObject[0], localObject[1]);
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
    AppMethodBeat.i(28104);
    Object localObject;
    if (!bu.isNullOrNil(this.field_regionCode))
    {
      localObject = this.field_regionCode.split("_");
      if (localObject.length > 0)
      {
        if ((localObject.length <= 2) || (!localObject[0].equalsIgnoreCase("cn"))) {
          break label80;
        }
        RegionCodeDecoder.fwA();
      }
    }
    for (this.field_province = RegionCodeDecoder.mi(localObject[0], localObject[1]);; this.field_province = RegionCodeDecoder.aVR(localObject[0]))
    {
      localObject = this.field_province;
      AppMethodBeat.o(28104);
      return localObject;
      label80:
      RegionCodeDecoder.fwA();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.b.d
 * JD-Core Version:    0.7.0.1
 */