package com.tencent.mm.plugin.shake.b;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fg;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cxk;
import com.tencent.mm.protocal.protobuf.dbt;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.RegionCodeDecoder;
import java.lang.reflect.Field;
import java.util.Map;

public final class d
  extends fg
{
  protected static c.a info;
  public int drx;
  public int scene;
  private SKBuiltinBuffer_t xxd;
  
  static
  {
    AppMethodBeat.i(28108);
    c.a locala = new c.a();
    locala.GvF = new Field[20];
    locala.columns = new String[21];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "shakeItemID";
    locala.GvH.put("shakeItemID", "INTEGER default '0'  PRIMARY KEY ");
    localStringBuilder.append(" shakeItemID INTEGER default '0'  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.GvG = "shakeItemID";
    locala.columns[1] = "username";
    locala.GvH.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "nickname";
    locala.GvH.put("nickname", "TEXT");
    localStringBuilder.append(" nickname TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "province";
    locala.GvH.put("province", "TEXT");
    localStringBuilder.append(" province TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "city";
    locala.GvH.put("city", "TEXT");
    localStringBuilder.append(" city TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "signature";
    locala.GvH.put("signature", "TEXT");
    localStringBuilder.append(" signature TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "distance";
    locala.GvH.put("distance", "TEXT");
    localStringBuilder.append(" distance TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "sex";
    locala.GvH.put("sex", "INTEGER");
    localStringBuilder.append(" sex INTEGER");
    localStringBuilder.append(", ");
    locala.columns[8] = "imgstatus";
    locala.GvH.put("imgstatus", "INTEGER");
    localStringBuilder.append(" imgstatus INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "hasHDImg";
    locala.GvH.put("hasHDImg", "INTEGER");
    localStringBuilder.append(" hasHDImg INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "insertBatch";
    locala.GvH.put("insertBatch", "INTEGER");
    localStringBuilder.append(" insertBatch INTEGER");
    localStringBuilder.append(", ");
    locala.columns[11] = "reserved1";
    locala.GvH.put("reserved1", "INTEGER");
    localStringBuilder.append(" reserved1 INTEGER");
    localStringBuilder.append(", ");
    locala.columns[12] = "reserved2";
    locala.GvH.put("reserved2", "INTEGER");
    localStringBuilder.append(" reserved2 INTEGER");
    localStringBuilder.append(", ");
    locala.columns[13] = "reserved3";
    locala.GvH.put("reserved3", "TEXT");
    localStringBuilder.append(" reserved3 TEXT");
    localStringBuilder.append(", ");
    locala.columns[14] = "reserved4";
    locala.GvH.put("reserved4", "TEXT");
    localStringBuilder.append(" reserved4 TEXT");
    localStringBuilder.append(", ");
    locala.columns[15] = "type";
    locala.GvH.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[16] = "lvbuffer";
    locala.GvH.put("lvbuffer", "BLOB");
    localStringBuilder.append(" lvbuffer BLOB");
    localStringBuilder.append(", ");
    locala.columns[17] = "regionCode";
    locala.GvH.put("regionCode", "TEXT");
    localStringBuilder.append(" regionCode TEXT");
    localStringBuilder.append(", ");
    locala.columns[18] = "snsFlag";
    locala.GvH.put("snsFlag", "INTEGER");
    localStringBuilder.append(" snsFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[19] = "sns_bgurl";
    locala.GvH.put("sns_bgurl", "TEXT");
    localStringBuilder.append(" sns_bgurl TEXT");
    locala.columns[20] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(28108);
  }
  
  public d()
  {
    this.drx = -1;
    this.field_insertBatch = 2;
  }
  
  public d(cxk paramcxk)
  {
    AppMethodBeat.i(28103);
    this.drx = -1;
    this.field_username = paramcxk.ncR;
    this.field_nickname = paramcxk.ndW;
    this.field_signature = paramcxk.iJW;
    this.field_distance = paramcxk.Fep;
    this.field_reserved4 = String.valueOf(paramcxk.FGY);
    this.field_sex = paramcxk.iJT;
    this.field_imgstatus = paramcxk.DPW;
    this.field_hasHDImg = paramcxk.FGW;
    this.field_reserved1 = paramcxk.Feq;
    this.field_reserved3 = paramcxk.Fer;
    this.field_insertBatch = 2;
    if (paramcxk.Few != null)
    {
      this.field_snsFlag = paramcxk.Few.iKe;
      this.field_sns_bgurl = paramcxk.Few.iKf;
    }
    this.xxd = paramcxk.FGX;
    this.field_province = paramcxk.iJU;
    this.field_city = paramcxk.iJV;
    this.field_regionCode = RegionCodeDecoder.aW(paramcxk.iKc, this.field_province, this.field_city);
    AppMethodBeat.o(28103);
  }
  
  private int dCQ()
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
    if ((this.drx & 0x2) != 0) {
      localContentValues.put("username", this.field_username);
    }
    if ((this.drx & 0x4) != 0) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if ((this.drx & 0x8) != 0) {
      localContentValues.put("province", getProvince());
    }
    if ((this.drx & 0x10) != 0) {
      localContentValues.put("city", getCity());
    }
    if ((this.drx & 0x20) != 0) {
      localContentValues.put("signature", this.field_signature);
    }
    if ((this.drx & 0x40) != 0) {
      localContentValues.put("distance", this.field_distance);
    }
    if ((this.drx & 0x80) != 0) {
      localContentValues.put("sex", Integer.valueOf(this.field_sex));
    }
    if ((this.drx & 0x100) != 0) {
      localContentValues.put("imgstatus", Integer.valueOf(this.field_imgstatus));
    }
    if ((this.drx & 0x200) != 0) {
      localContentValues.put("hasHDImg", Integer.valueOf(this.field_hasHDImg));
    }
    if ((this.drx & 0x400) != 0) {
      localContentValues.put("insertBatch", Integer.valueOf(this.field_insertBatch));
    }
    if ((this.drx & 0x800) != 0) {
      localContentValues.put("reserved1", Integer.valueOf(this.field_reserved1));
    }
    if ((this.drx & 0x1000) != 0) {
      localContentValues.put("reserved2", Integer.valueOf(this.field_reserved2));
    }
    if ((this.drx & 0x2000) != 0) {
      localContentValues.put("reserved3", this.field_reserved3);
    }
    if ((this.drx & 0x4000) != 0) {
      localContentValues.put("reserved4", Integer.valueOf(dCQ()));
    }
    if ((this.drx & 0x8000) != 0) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if ((this.drx & 0x10000) != 0) {
      localContentValues.put("lvbuffer", this.field_lvbuffer);
    }
    if ((this.drx & 0x20000) != 0) {
      localContentValues.put("regionCode", this.field_regionCode);
    }
    if ((this.drx & 0x40000) != 0) {
      localContentValues.put("snsFlag", Integer.valueOf(this.field_snsFlag));
    }
    if ((this.drx & 0x80000) != 0) {
      localContentValues.put("sns_bgurl", this.field_sns_bgurl);
    }
    AppMethodBeat.o(28107);
    return localContentValues;
  }
  
  public final String getCity()
  {
    AppMethodBeat.i(28105);
    Object localObject;
    if (!bs.isNullOrNil(this.field_regionCode))
    {
      localObject = this.field_regionCode.split("_");
      if (localObject.length > 0)
      {
        if (localObject.length <= 2) {
          break label71;
        }
        RegionCodeDecoder.fcs();
        this.field_city = RegionCodeDecoder.aY(localObject[0], localObject[1], localObject[2]);
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
        RegionCodeDecoder.fcs();
        this.field_city = RegionCodeDecoder.lD(localObject[0], localObject[1]);
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
    if (!bs.isNullOrNil(this.field_regionCode))
    {
      localObject = this.field_regionCode.split("_");
      if (localObject.length > 0)
      {
        if ((localObject.length <= 2) || (!localObject[0].equalsIgnoreCase("cn"))) {
          break label80;
        }
        RegionCodeDecoder.fcs();
      }
    }
    for (this.field_province = RegionCodeDecoder.lD(localObject[0], localObject[1]);; this.field_province = RegionCodeDecoder.aOz(localObject[0]))
    {
      localObject = this.field_province;
      AppMethodBeat.o(28104);
      return localObject;
      label80:
      RegionCodeDecoder.fcs();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.b.d
 * JD-Core Version:    0.7.0.1
 */