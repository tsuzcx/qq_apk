package com.tencent.mm.plugin.shake.model;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.hb;
import com.tencent.mm.protocal.protobuf.faw;
import com.tencent.mm.protocal.protobuf.ffs;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.storage.RegionCodeDecoder;

public final class d
  extends hb
{
  protected static IAutoDBItem.MAutoDBInfo info;
  private gol Pzm;
  public int eQp;
  public int scene;
  
  static
  {
    AppMethodBeat.i(28108);
    info = hb.aJm();
    AppMethodBeat.o(28108);
  }
  
  public d()
  {
    this.eQp = -1;
    this.field_insertBatch = 2;
  }
  
  public d(faw paramfaw)
  {
    AppMethodBeat.i(28103);
    this.eQp = -1;
    this.field_username = paramfaw.UserName;
    this.field_nickname = paramfaw.vhX;
    this.field_signature = paramfaw.pSi;
    this.field_distance = paramfaw.aaMl;
    this.field_reserved4 = String.valueOf(paramfaw.abAR);
    this.field_sex = paramfaw.pSf;
    this.field_imgstatus = paramfaw.YFH;
    this.field_hasHDImg = paramfaw.abAP;
    this.field_reserved1 = paramfaw.aaMm;
    this.field_reserved3 = paramfaw.aaMn;
    this.field_insertBatch = 2;
    if (paramfaw.aaMs != null)
    {
      this.field_snsFlag = paramfaw.aaMs.pSq;
      this.field_sns_bgurl = paramfaw.aaMs.pSr;
    }
    this.Pzm = paramfaw.abAQ;
    this.field_province = paramfaw.pSg;
    this.field_city = paramfaw.pSh;
    this.field_regionCode = RegionCodeDecoder.bI(paramfaw.pSo, this.field_province, this.field_city);
    AppMethodBeat.o(28103);
  }
  
  private int gWI()
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
    if ((this.eQp & 0x2) != 0) {
      localContentValues.put("username", this.field_username);
    }
    if ((this.eQp & 0x4) != 0) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if ((this.eQp & 0x8) != 0) {
      localContentValues.put("province", getProvince());
    }
    if ((this.eQp & 0x10) != 0) {
      localContentValues.put("city", getCity());
    }
    if ((this.eQp & 0x20) != 0) {
      localContentValues.put("signature", this.field_signature);
    }
    if ((this.eQp & 0x40) != 0) {
      localContentValues.put("distance", this.field_distance);
    }
    if ((this.eQp & 0x80) != 0) {
      localContentValues.put("sex", Integer.valueOf(this.field_sex));
    }
    if ((this.eQp & 0x100) != 0) {
      localContentValues.put("imgstatus", Integer.valueOf(this.field_imgstatus));
    }
    if ((this.eQp & 0x200) != 0) {
      localContentValues.put("hasHDImg", Integer.valueOf(this.field_hasHDImg));
    }
    if ((this.eQp & 0x400) != 0) {
      localContentValues.put("insertBatch", Integer.valueOf(this.field_insertBatch));
    }
    if ((this.eQp & 0x800) != 0) {
      localContentValues.put("reserved1", Integer.valueOf(this.field_reserved1));
    }
    if ((this.eQp & 0x1000) != 0) {
      localContentValues.put("reserved2", Integer.valueOf(this.field_reserved2));
    }
    if ((this.eQp & 0x2000) != 0) {
      localContentValues.put("reserved3", this.field_reserved3);
    }
    if ((this.eQp & 0x4000) != 0) {
      localContentValues.put("reserved4", Integer.valueOf(gWI()));
    }
    if ((this.eQp & 0x8000) != 0) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if ((this.eQp & 0x10000) != 0) {
      localContentValues.put("lvbuffer", this.field_lvbuffer);
    }
    if ((this.eQp & 0x20000) != 0) {
      localContentValues.put("regionCode", this.field_regionCode);
    }
    if ((this.eQp & 0x40000) != 0) {
      localContentValues.put("snsFlag", Integer.valueOf(this.field_snsFlag));
    }
    if ((this.eQp & 0x80000) != 0) {
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
          break label70;
        }
        RegionCodeDecoder.jcF();
        this.field_city = RegionCodeDecoder.bK(localObject[0], localObject[1], localObject[2]);
      }
    }
    for (;;)
    {
      localObject = this.field_city;
      AppMethodBeat.o(28105);
      return localObject;
      label70:
      if (localObject.length == 2)
      {
        RegionCodeDecoder.jcF();
        this.field_city = RegionCodeDecoder.pM(localObject[0], localObject[1]);
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
          break label79;
        }
        RegionCodeDecoder.jcF();
      }
    }
    for (this.field_province = RegionCodeDecoder.pM(localObject[0], localObject[1]);; this.field_province = RegionCodeDecoder.byH(localObject[0]))
    {
      localObject = this.field_province;
      AppMethodBeat.o(28104);
      return localObject;
      label79:
      RegionCodeDecoder.jcF();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.model.d
 * JD-Core Version:    0.7.0.1
 */