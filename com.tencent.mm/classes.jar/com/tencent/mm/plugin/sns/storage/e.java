package com.tencent.mm.plugin.sns.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import com.tencent.mm.a.g;
import com.tencent.mm.h.c.f;
import com.tencent.mm.protocal.c.bkk;
import com.tencent.mm.protocal.c.bm;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class e
  extends f
{
  protected static c.a buS;
  protected static Map<String, b> oLl = new ConcurrentHashMap();
  protected static Map<String, a> oLm = new ConcurrentHashMap();
  public String oLj = null;
  protected int oLk;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[24];
    locala.columns = new String[25];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "snsId";
    locala.ujN.put("snsId", "LONG");
    localStringBuilder.append(" snsId LONG");
    localStringBuilder.append(", ");
    locala.columns[1] = "userName";
    locala.ujN.put("userName", "TEXT");
    localStringBuilder.append(" userName TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "localFlag";
    locala.ujN.put("localFlag", "INTEGER");
    localStringBuilder.append(" localFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "createTime";
    locala.ujN.put("createTime", "INTEGER");
    localStringBuilder.append(" createTime INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "head";
    locala.ujN.put("head", "INTEGER");
    localStringBuilder.append(" head INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "localPrivate";
    locala.ujN.put("localPrivate", "INTEGER");
    localStringBuilder.append(" localPrivate INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "type";
    locala.ujN.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "sourceType";
    locala.ujN.put("sourceType", "INTEGER");
    localStringBuilder.append(" sourceType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[8] = "likeFlag";
    locala.ujN.put("likeFlag", "INTEGER");
    localStringBuilder.append(" likeFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "pravited";
    locala.ujN.put("pravited", "INTEGER");
    localStringBuilder.append(" pravited INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "stringSeq";
    locala.ujN.put("stringSeq", "TEXT");
    localStringBuilder.append(" stringSeq TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "content";
    locala.ujN.put("content", "BLOB");
    localStringBuilder.append(" content BLOB");
    localStringBuilder.append(", ");
    locala.columns[12] = "attrBuf";
    locala.ujN.put("attrBuf", "BLOB");
    localStringBuilder.append(" attrBuf BLOB");
    localStringBuilder.append(", ");
    locala.columns[13] = "postBuf";
    locala.ujN.put("postBuf", "BLOB");
    localStringBuilder.append(" postBuf BLOB");
    localStringBuilder.append(", ");
    locala.columns[14] = "adinfo";
    locala.ujN.put("adinfo", "TEXT");
    localStringBuilder.append(" adinfo TEXT");
    localStringBuilder.append(", ");
    locala.columns[15] = "adxml";
    locala.ujN.put("adxml", "TEXT");
    localStringBuilder.append(" adxml TEXT");
    localStringBuilder.append(", ");
    locala.columns[16] = "createAdTime";
    locala.ujN.put("createAdTime", "INTEGER");
    localStringBuilder.append(" createAdTime INTEGER");
    localStringBuilder.append(", ");
    locala.columns[17] = "exposureTime";
    locala.ujN.put("exposureTime", "INTEGER");
    localStringBuilder.append(" exposureTime INTEGER");
    localStringBuilder.append(", ");
    locala.columns[18] = "firstControlTime";
    locala.ujN.put("firstControlTime", "INTEGER");
    localStringBuilder.append(" firstControlTime INTEGER");
    localStringBuilder.append(", ");
    locala.columns[19] = "recxml";
    locala.ujN.put("recxml", "TEXT");
    localStringBuilder.append(" recxml TEXT");
    localStringBuilder.append(", ");
    locala.columns[20] = "subType";
    locala.ujN.put("subType", "INTEGER");
    localStringBuilder.append(" subType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[21] = "exposureCount";
    locala.ujN.put("exposureCount", "INTEGER");
    localStringBuilder.append(" exposureCount INTEGER");
    localStringBuilder.append(", ");
    locala.columns[22] = "atAdinfo";
    locala.ujN.put("atAdinfo", "TEXT");
    localStringBuilder.append(" atAdinfo TEXT");
    localStringBuilder.append(", ");
    locala.columns[23] = "remindInfoGroup";
    locala.ujN.put("remindInfoGroup", "BLOB");
    localStringBuilder.append(" remindInfoGroup BLOB");
    locala.columns[24] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  public final void D(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    ContentValues localContentValues = (ContentValues)paramBundle.getParcelable("values");
    this.field_snsId = localContentValues.getAsLong("snsId").longValue();
    this.field_userName = localContentValues.getAsString("userName");
    this.field_localFlag = localContentValues.getAsInteger("localFlag").intValue();
    this.field_createTime = localContentValues.getAsInteger("createTime").intValue();
    this.field_head = localContentValues.getAsInteger("head").intValue();
    this.field_localPrivate = localContentValues.getAsInteger("localPrivate").intValue();
    this.field_type = localContentValues.getAsInteger("type").intValue();
    this.field_sourceType = localContentValues.getAsInteger("sourceType").intValue();
    this.field_likeFlag = localContentValues.getAsInteger("likeFlag").intValue();
    this.field_pravited = localContentValues.getAsInteger("pravited").intValue();
    this.field_stringSeq = localContentValues.getAsString("stringSeq");
    this.field_content = localContentValues.getAsByteArray("content");
    this.field_attrBuf = localContentValues.getAsByteArray("attrBuf");
    this.field_postBuf = localContentValues.getAsByteArray("postBuf");
    this.field_adinfo = localContentValues.getAsString("adinfo");
    this.field_adxml = localContentValues.getAsString("adxml");
    this.field_createAdTime = localContentValues.getAsInteger("createAdTime").intValue();
    this.field_exposureTime = localContentValues.getAsInteger("exposureTime").intValue();
    this.field_firstControlTime = localContentValues.getAsInteger("firstControlTime").intValue();
    this.field_recxml = localContentValues.getAsString("recxml");
    this.field_subType = localContentValues.getAsInteger("subType").intValue();
    this.ujK = localContentValues.getAsLong("rowid").longValue();
    this.field_atAdinfo = localContentValues.getAsString("atAdinfo");
    this.field_remindInfoGroup = localContentValues.getAsByteArray("remindInfoGroup");
    this.oLk = paramBundle.getInt("localid");
  }
  
  public final boolean Oz(String paramString)
  {
    paramString = com.tencent.mm.modelsns.e.nn(paramString);
    try
    {
      this.field_content = paramString.toByteArray();
      this.oLj = (g.o(this.field_content) + g.o(this.field_attrBuf));
      return true;
    }
    catch (Exception paramString)
    {
      y.printErrStackTrace("MicroMsg.AdSnsInfo", paramString, "", new Object[0]);
    }
    return false;
  }
  
  public final void a(bm parambm)
  {
    try
    {
      this.field_remindInfoGroup = parambm.toByteArray();
      return;
    }
    catch (Exception parambm)
    {
      y.e("MicroMsg.AdSnsInfo", "remindInfo toBytes error! " + parambm.getMessage());
    }
  }
  
  public final void aL(byte[] paramArrayOfByte)
  {
    this.field_attrBuf = paramArrayOfByte;
    this.oLj = (g.o(this.field_content) + g.o(this.field_attrBuf));
  }
  
  public final boolean bEQ()
  {
    b localb = bFZ();
    if (localb != null) {
      return localb.bEQ();
    }
    return false;
  }
  
  public final b bFZ()
  {
    Object localObject;
    b localb;
    if (this.field_adxml != null)
    {
      if (oLl.containsKey(this.field_adxml))
      {
        localObject = (b)oLl.get(this.field_adxml);
        return localObject;
      }
      localb = new b(this.field_adxml);
      oLl.put(this.field_adxml, localb);
    }
    for (;;)
    {
      localObject = localb;
      if (localb != null) {
        break;
      }
      return new b(null);
      localb = null;
    }
  }
  
  public final b bGa()
  {
    Object localObject;
    b localb;
    if (this.field_recxml != null)
    {
      if (oLl.containsKey(this.field_recxml))
      {
        localObject = (b)oLl.get(this.field_recxml);
        return localObject;
      }
      localb = new b(this.field_recxml);
      oLl.put(this.field_recxml, localb);
    }
    for (;;)
    {
      localObject = localb;
      if (localb != null) {
        break;
      }
      return new b(null);
      localb = null;
    }
  }
  
  public final a bGb()
  {
    Object localObject;
    a locala;
    if (this.field_adinfo != null)
    {
      if (oLm.containsKey(this.field_adinfo))
      {
        localObject = (a)oLm.get(this.field_adinfo);
        return localObject;
      }
      locala = new a(this.field_adinfo);
      oLm.put(this.field_adinfo, locala);
    }
    for (;;)
    {
      localObject = locala;
      if (locala != null) {
        break;
      }
      return new a(null);
      locala = null;
    }
  }
  
  public final a bGc()
  {
    Object localObject;
    a locala;
    if (this.field_atAdinfo != null)
    {
      if (oLm.containsKey(this.field_atAdinfo))
      {
        localObject = (a)oLm.get(this.field_atAdinfo);
        return localObject;
      }
      locala = new a(this.field_atAdinfo);
      oLm.put(this.field_atAdinfo, locala);
    }
    for (;;)
    {
      localObject = locala;
      if (locala != null) {
        break;
      }
      return new a(null);
      locala = null;
    }
  }
  
  public final int bGd()
  {
    b localb = bGa();
    if (localb == null) {
      return 0;
    }
    return localb.oBa;
  }
  
  public final bxk bGe()
  {
    Object localObject;
    if (this.field_content == null) {
      localObject = com.tencent.mm.modelsns.e.QZ();
    }
    bxk localbxk;
    do
    {
      return localObject;
      if (this.oLj == null) {
        this.oLj = (g.o(this.field_content) + g.o(this.field_attrBuf));
      }
      if (!n.oLr.containsKey(this.oLj)) {
        break;
      }
      localbxk = (bxk)n.oLr.get(this.oLj);
      localObject = localbxk;
    } while (localbxk != null);
    try
    {
      localObject = (bxk)new bxk().aH(this.field_content);
      n.oLr.put(this.oLj, localObject);
      return localObject;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.AdSnsInfo", "error get snsinfo timeline!");
    }
    return com.tencent.mm.modelsns.e.QZ();
  }
  
  public final bm bGf()
  {
    try
    {
      bm localbm;
      if (this.field_remindInfoGroup != null) {
        localbm = new bm();
      }
      label29:
      return null;
    }
    catch (Exception localException1)
    {
      try
      {
        localbm.aH(this.field_remindInfoGroup);
        return localbm;
      }
      catch (Exception localException2)
      {
        break label29;
      }
      localException1 = localException1;
      localbm = null;
      y.e("MicroMsg.AdSnsInfo", "parse remindInfo error! " + localException1.getMessage());
      return localbm;
    }
  }
  
  public final com.tencent.mm.bv.b bGg()
  {
    if ((bGf() != null) && (bGf().svg != null) && (bGf().svg.tEf != null)) {
      return bGf().svg.tEf.tFM;
    }
    return null;
  }
  
  public final com.tencent.mm.bv.b bGh()
  {
    if ((bGf() != null) && (bGf().svg != null) && (bGf().svg.tEg != null)) {
      return bGf().svg.tEg.tFM;
    }
    return null;
  }
  
  public final com.tencent.mm.bv.b bGi()
  {
    if ((bGf() != null) && (bGf().svh != null) && (bGf().svh.tEf != null)) {
      return bGf().svh.tEf.tFM;
    }
    return null;
  }
  
  public final com.tencent.mm.bv.b bGj()
  {
    if ((bGf() != null) && (bGf().svh != null) && (bGf().svh.tEg != null)) {
      return bGf().svh.tEg.tFM;
    }
    return null;
  }
  
  public final String bGk()
  {
    return v.ak("ad_table_", this.field_snsId);
  }
  
  public final n bGl()
  {
    n localn = new n();
    localn.c(bGe());
    y.d("MicroMsg.AdSnsInfo", "from server xml ok %d", new Object[] { Long.valueOf(this.field_snsId) });
    localn.oLk = this.oLk;
    localn.field_userName = this.field_userName;
    localn.iB(this.field_createTime);
    localn.field_likeFlag = this.field_likeFlag;
    localn.gp(this.field_snsId);
    localn.field_sourceType = this.field_sourceType;
    localn.field_content = this.field_content;
    localn.yp(2);
    localn.yp(32);
    localn.field_attrBuf = this.field_attrBuf;
    bxk localbxk = localn.bGe();
    localbxk.hPY = this.field_userName;
    localn.field_pravited = localbxk.trR;
    localn.bGB();
    localn.c(localbxk);
    if (localbxk.tNr != null)
    {
      localn.field_type = localbxk.tNr.sPI;
      localn.field_subType = localbxk.tNr.sPK;
    }
    localn.oLu = this;
    return localn;
  }
  
  public final Bundle bGm()
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("values", super.vf());
    localBundle.putInt("localid", this.oLk);
    return localBundle;
  }
  
  public final void c(bxk parambxk)
  {
    try
    {
      this.field_content = parambxk.toByteArray();
      return;
    }
    catch (Exception parambxk)
    {
      y.printErrStackTrace("MicroMsg.AdSnsInfo", parambxk, "", new Object[0]);
    }
  }
  
  public final void d(Cursor paramCursor)
  {
    super.d(paramCursor);
    this.oLk = ((int)this.ujK);
  }
  
  public final int getSource()
  {
    b localb = bGa();
    if (localb == null) {
      return 0;
    }
    return localb.oBa;
  }
  
  protected final c.a rM()
  {
    return buS;
  }
  
  public final void yp(int paramInt)
  {
    this.field_sourceType |= paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.e
 * JD-Core Version:    0.7.0.1
 */