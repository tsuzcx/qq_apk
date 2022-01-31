package com.tencent.mm.plugin.shake.b;

import android.content.ContentValues;
import com.tencent.mm.h.c.dv;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.bqy;
import com.tencent.mm.protocal.c.but;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.RegionCodeDecoder;
import java.lang.reflect.Field;
import java.util.Map;

public final class d
  extends dv
{
  protected static c.a buS;
  public int bcw = -1;
  private bmk nYN;
  public int scene;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[20];
    locala.columns = new String[21];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "shakeItemID";
    locala.ujN.put("shakeItemID", "INTEGER default '0'  PRIMARY KEY ");
    localStringBuilder.append(" shakeItemID INTEGER default '0'  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "shakeItemID";
    locala.columns[1] = "username";
    locala.ujN.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "nickname";
    locala.ujN.put("nickname", "TEXT");
    localStringBuilder.append(" nickname TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "province";
    locala.ujN.put("province", "TEXT");
    localStringBuilder.append(" province TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "city";
    locala.ujN.put("city", "TEXT");
    localStringBuilder.append(" city TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "signature";
    locala.ujN.put("signature", "TEXT");
    localStringBuilder.append(" signature TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "distance";
    locala.ujN.put("distance", "TEXT");
    localStringBuilder.append(" distance TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "sex";
    locala.ujN.put("sex", "INTEGER");
    localStringBuilder.append(" sex INTEGER");
    localStringBuilder.append(", ");
    locala.columns[8] = "imgstatus";
    locala.ujN.put("imgstatus", "INTEGER");
    localStringBuilder.append(" imgstatus INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "hasHDImg";
    locala.ujN.put("hasHDImg", "INTEGER");
    localStringBuilder.append(" hasHDImg INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "insertBatch";
    locala.ujN.put("insertBatch", "INTEGER");
    localStringBuilder.append(" insertBatch INTEGER");
    localStringBuilder.append(", ");
    locala.columns[11] = "reserved1";
    locala.ujN.put("reserved1", "INTEGER");
    localStringBuilder.append(" reserved1 INTEGER");
    localStringBuilder.append(", ");
    locala.columns[12] = "reserved2";
    locala.ujN.put("reserved2", "INTEGER");
    localStringBuilder.append(" reserved2 INTEGER");
    localStringBuilder.append(", ");
    locala.columns[13] = "reserved3";
    locala.ujN.put("reserved3", "TEXT");
    localStringBuilder.append(" reserved3 TEXT");
    localStringBuilder.append(", ");
    locala.columns[14] = "reserved4";
    locala.ujN.put("reserved4", "TEXT");
    localStringBuilder.append(" reserved4 TEXT");
    localStringBuilder.append(", ");
    locala.columns[15] = "type";
    locala.ujN.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[16] = "lvbuffer";
    locala.ujN.put("lvbuffer", "BLOB");
    localStringBuilder.append(" lvbuffer BLOB");
    localStringBuilder.append(", ");
    locala.columns[17] = "regionCode";
    locala.ujN.put("regionCode", "TEXT");
    localStringBuilder.append(" regionCode TEXT");
    localStringBuilder.append(", ");
    locala.columns[18] = "snsFlag";
    locala.ujN.put("snsFlag", "INTEGER");
    localStringBuilder.append(" snsFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[19] = "sns_bgurl";
    locala.ujN.put("sns_bgurl", "TEXT");
    localStringBuilder.append(" sns_bgurl TEXT");
    locala.columns[20] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  public d()
  {
    this.field_insertBatch = 2;
  }
  
  public d(bqy parambqy)
  {
    this.field_username = parambqy.hPY;
    this.field_nickname = parambqy.hRf;
    this.field_signature = parambqy.ffk;
    this.field_distance = parambqy.tpf;
    this.field_reserved4 = String.valueOf(parambqy.tHK);
    this.field_sex = parambqy.ffh;
    this.field_imgstatus = parambqy.svI;
    this.field_hasHDImg = parambqy.tHI;
    this.field_reserved1 = parambqy.tpg;
    this.field_reserved3 = parambqy.tph;
    this.field_insertBatch = 2;
    if (parambqy.tpm != null)
    {
      this.field_snsFlag = parambqy.tpm.ffs;
      this.field_sns_bgurl = parambqy.tpm.fft;
    }
    this.nYN = parambqy.tHJ;
    this.field_province = parambqy.ffi;
    this.field_city = parambqy.ffj;
    this.field_regionCode = RegionCodeDecoder.ao(parambqy.ffq, this.field_province, this.field_city);
  }
  
  private int bzI()
  {
    try
    {
      int i = Integer.valueOf(this.field_reserved4).intValue();
      return i;
    }
    finally {}
    return 0;
  }
  
  public final String getCity()
  {
    String[] arrayOfString;
    if (!bk.bl(this.field_regionCode))
    {
      arrayOfString = this.field_regionCode.split("_");
      if (arrayOfString.length > 0)
      {
        if (arrayOfString.length <= 2) {
          break label57;
        }
        RegionCodeDecoder.cvV();
        this.field_city = RegionCodeDecoder.ap(arrayOfString[0], arrayOfString[1], arrayOfString[2]);
      }
    }
    for (;;)
    {
      return this.field_city;
      label57:
      if (arrayOfString.length == 2)
      {
        RegionCodeDecoder.cvV();
        this.field_city = RegionCodeDecoder.gp(arrayOfString[0], arrayOfString[1]);
      }
      else
      {
        this.field_city = "";
      }
    }
  }
  
  public final String getProvince()
  {
    String[] arrayOfString;
    if (!bk.bl(this.field_regionCode))
    {
      arrayOfString = this.field_regionCode.split("_");
      if (arrayOfString.length > 0)
      {
        if ((arrayOfString.length <= 2) || (!arrayOfString[0].equalsIgnoreCase("cn"))) {
          break label66;
        }
        RegionCodeDecoder.cvV();
      }
    }
    for (this.field_province = RegionCodeDecoder.gp(arrayOfString[0], arrayOfString[1]);; this.field_province = RegionCodeDecoder.acm(arrayOfString[0]))
    {
      return this.field_province;
      label66:
      RegionCodeDecoder.cvV();
    }
  }
  
  protected final c.a rM()
  {
    return buS;
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if ((this.bcw & 0x2) != 0) {
      localContentValues.put("username", this.field_username);
    }
    if ((this.bcw & 0x4) != 0) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if ((this.bcw & 0x8) != 0) {
      localContentValues.put("province", getProvince());
    }
    if ((this.bcw & 0x10) != 0) {
      localContentValues.put("city", getCity());
    }
    if ((this.bcw & 0x20) != 0) {
      localContentValues.put("signature", this.field_signature);
    }
    if ((this.bcw & 0x40) != 0) {
      localContentValues.put("distance", this.field_distance);
    }
    if ((this.bcw & 0x80) != 0) {
      localContentValues.put("sex", Integer.valueOf(this.field_sex));
    }
    if ((this.bcw & 0x100) != 0) {
      localContentValues.put("imgstatus", Integer.valueOf(this.field_imgstatus));
    }
    if ((this.bcw & 0x200) != 0) {
      localContentValues.put("hasHDImg", Integer.valueOf(this.field_hasHDImg));
    }
    if ((this.bcw & 0x400) != 0) {
      localContentValues.put("insertBatch", Integer.valueOf(this.field_insertBatch));
    }
    if ((this.bcw & 0x800) != 0) {
      localContentValues.put("reserved1", Integer.valueOf(this.field_reserved1));
    }
    if ((this.bcw & 0x1000) != 0) {
      localContentValues.put("reserved2", Integer.valueOf(this.field_reserved2));
    }
    if ((this.bcw & 0x2000) != 0) {
      localContentValues.put("reserved3", this.field_reserved3);
    }
    if ((this.bcw & 0x4000) != 0) {
      localContentValues.put("reserved4", Integer.valueOf(bzI()));
    }
    if ((this.bcw & 0x8000) != 0) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if ((this.bcw & 0x10000) != 0) {
      localContentValues.put("lvbuffer", this.field_lvbuffer);
    }
    if ((this.bcw & 0x20000) != 0) {
      localContentValues.put("regionCode", this.field_regionCode);
    }
    if ((this.bcw & 0x40000) != 0) {
      localContentValues.put("snsFlag", Integer.valueOf(this.field_snsFlag));
    }
    if ((this.bcw & 0x80000) != 0) {
      localContentValues.put("sns_bgurl", this.field_sns_bgurl);
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.b.d
 * JD-Core Version:    0.7.0.1
 */