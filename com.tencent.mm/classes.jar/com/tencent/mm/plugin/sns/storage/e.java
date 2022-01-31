package com.tencent.mm.plugin.sns.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.g.c.f;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bs;
import com.tencent.mm.protocal.protobuf.btk;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class e
  extends f
{
  protected static c.a info;
  protected static Map<String, b> rCW;
  protected static Map<String, a> rCX;
  public String rCU = null;
  protected int rCV;
  
  static
  {
    AppMethodBeat.i(37824);
    c.a locala = new c.a();
    locala.yrK = new Field[24];
    locala.columns = new String[25];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "snsId";
    locala.yrM.put("snsId", "LONG");
    localStringBuilder.append(" snsId LONG");
    localStringBuilder.append(", ");
    locala.columns[1] = "userName";
    locala.yrM.put("userName", "TEXT");
    localStringBuilder.append(" userName TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "localFlag";
    locala.yrM.put("localFlag", "INTEGER");
    localStringBuilder.append(" localFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "createTime";
    locala.yrM.put("createTime", "INTEGER");
    localStringBuilder.append(" createTime INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "head";
    locala.yrM.put("head", "INTEGER");
    localStringBuilder.append(" head INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "localPrivate";
    locala.yrM.put("localPrivate", "INTEGER");
    localStringBuilder.append(" localPrivate INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "type";
    locala.yrM.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "sourceType";
    locala.yrM.put("sourceType", "INTEGER");
    localStringBuilder.append(" sourceType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[8] = "likeFlag";
    locala.yrM.put("likeFlag", "INTEGER");
    localStringBuilder.append(" likeFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "pravited";
    locala.yrM.put("pravited", "INTEGER");
    localStringBuilder.append(" pravited INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "stringSeq";
    locala.yrM.put("stringSeq", "TEXT");
    localStringBuilder.append(" stringSeq TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "content";
    locala.yrM.put("content", "BLOB");
    localStringBuilder.append(" content BLOB");
    localStringBuilder.append(", ");
    locala.columns[12] = "attrBuf";
    locala.yrM.put("attrBuf", "BLOB");
    localStringBuilder.append(" attrBuf BLOB");
    localStringBuilder.append(", ");
    locala.columns[13] = "postBuf";
    locala.yrM.put("postBuf", "BLOB");
    localStringBuilder.append(" postBuf BLOB");
    localStringBuilder.append(", ");
    locala.columns[14] = "adinfo";
    locala.yrM.put("adinfo", "TEXT");
    localStringBuilder.append(" adinfo TEXT");
    localStringBuilder.append(", ");
    locala.columns[15] = "adxml";
    locala.yrM.put("adxml", "TEXT");
    localStringBuilder.append(" adxml TEXT");
    localStringBuilder.append(", ");
    locala.columns[16] = "createAdTime";
    locala.yrM.put("createAdTime", "INTEGER");
    localStringBuilder.append(" createAdTime INTEGER");
    localStringBuilder.append(", ");
    locala.columns[17] = "exposureTime";
    locala.yrM.put("exposureTime", "INTEGER");
    localStringBuilder.append(" exposureTime INTEGER");
    localStringBuilder.append(", ");
    locala.columns[18] = "firstControlTime";
    locala.yrM.put("firstControlTime", "INTEGER");
    localStringBuilder.append(" firstControlTime INTEGER");
    localStringBuilder.append(", ");
    locala.columns[19] = "recxml";
    locala.yrM.put("recxml", "TEXT");
    localStringBuilder.append(" recxml TEXT");
    localStringBuilder.append(", ");
    locala.columns[20] = "subType";
    locala.yrM.put("subType", "INTEGER");
    localStringBuilder.append(" subType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[21] = "exposureCount";
    locala.yrM.put("exposureCount", "INTEGER");
    localStringBuilder.append(" exposureCount INTEGER");
    localStringBuilder.append(", ");
    locala.columns[22] = "atAdinfo";
    locala.yrM.put("atAdinfo", "TEXT");
    localStringBuilder.append(" atAdinfo TEXT");
    localStringBuilder.append(", ");
    locala.columns[23] = "remindInfoGroup";
    locala.yrM.put("remindInfoGroup", "BLOB");
    localStringBuilder.append(" remindInfoGroup BLOB");
    locala.columns[24] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    rCW = new ConcurrentHashMap();
    rCX = new ConcurrentHashMap();
    AppMethodBeat.o(37824);
  }
  
  private b csc()
  {
    AppMethodBeat.i(37802);
    b localb;
    if (this.field_recxml != null)
    {
      if (rCW.containsKey(this.field_recxml))
      {
        localb = (b)rCW.get(this.field_recxml);
        AppMethodBeat.o(37802);
        return localb;
      }
      localb = new b(this.field_recxml);
      rCW.put(this.field_recxml, localb);
    }
    for (;;)
    {
      if (localb == null)
      {
        localb = new b(null);
        AppMethodBeat.o(37802);
        return localb;
      }
      AppMethodBeat.o(37802);
      return localb;
      localb = null;
    }
  }
  
  public final void Eu(int paramInt)
  {
    this.field_sourceType |= paramInt;
  }
  
  public final void U(Bundle paramBundle)
  {
    AppMethodBeat.i(37823);
    if (paramBundle == null)
    {
      AppMethodBeat.o(37823);
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
    this.systemRowid = localContentValues.getAsLong("rowid").longValue();
    this.field_atAdinfo = localContentValues.getAsString("atAdinfo");
    this.field_remindInfoGroup = localContentValues.getAsByteArray("remindInfoGroup");
    this.rCV = paramBundle.getInt("localid");
    AppMethodBeat.o(37823);
  }
  
  public final void a(bs parambs)
  {
    AppMethodBeat.i(37812);
    try
    {
      this.field_remindInfoGroup = parambs.toByteArray();
      AppMethodBeat.o(37812);
      return;
    }
    catch (Exception parambs)
    {
      ab.e("MicroMsg.AdSnsInfo", "remindInfo toBytes error! " + parambs.getMessage());
      AppMethodBeat.o(37812);
    }
  }
  
  public final boolean abt(String paramString)
  {
    AppMethodBeat.i(37810);
    paramString = com.tencent.mm.modelsns.e.uA(paramString);
    try
    {
      this.field_content = paramString.toByteArray();
      this.rCU = (g.w(this.field_content) + g.w(this.field_attrBuf));
      AppMethodBeat.o(37810);
      return true;
    }
    catch (Exception paramString)
    {
      ab.printErrStackTrace("MicroMsg.AdSnsInfo", paramString, "", new Object[0]);
      AppMethodBeat.o(37810);
    }
    return false;
  }
  
  public final void bj(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(37818);
    this.field_attrBuf = paramArrayOfByte;
    this.rCU = (g.w(this.field_content) + g.w(this.field_attrBuf));
    AppMethodBeat.o(37818);
  }
  
  public final void c(TimeLineObject paramTimeLineObject)
  {
    AppMethodBeat.i(37809);
    try
    {
      this.field_content = paramTimeLineObject.toByteArray();
      AppMethodBeat.o(37809);
      return;
    }
    catch (Exception paramTimeLineObject)
    {
      ab.printErrStackTrace("MicroMsg.AdSnsInfo", paramTimeLineObject, "", new Object[0]);
      AppMethodBeat.o(37809);
    }
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(37821);
    super.convertFrom(paramCursor);
    this.rCV = ((int)this.systemRowid);
    AppMethodBeat.o(37821);
  }
  
  public final boolean cqx()
  {
    AppMethodBeat.i(37805);
    b localb = csb();
    if (localb != null)
    {
      boolean bool = localb.cqx();
      AppMethodBeat.o(37805);
      return bool;
    }
    AppMethodBeat.o(37805);
    return false;
  }
  
  public final b csb()
  {
    AppMethodBeat.i(37801);
    b localb;
    if (this.field_adxml != null)
    {
      if (rCW.containsKey(this.field_adxml))
      {
        localb = (b)rCW.get(this.field_adxml);
        AppMethodBeat.o(37801);
        return localb;
      }
      localb = new b(this.field_adxml);
      rCW.put(this.field_adxml, localb);
    }
    for (;;)
    {
      if (localb == null)
      {
        localb = new b(null);
        AppMethodBeat.o(37801);
        return localb;
      }
      AppMethodBeat.o(37801);
      return localb;
      localb = null;
    }
  }
  
  public final a csd()
  {
    AppMethodBeat.i(37803);
    a locala;
    if (this.field_adinfo != null)
    {
      if (rCX.containsKey(this.field_adinfo))
      {
        locala = (a)rCX.get(this.field_adinfo);
        AppMethodBeat.o(37803);
        return locala;
      }
      locala = new a(this.field_adinfo);
      rCX.put(this.field_adinfo, locala);
    }
    for (;;)
    {
      if (locala == null)
      {
        locala = new a(null);
        AppMethodBeat.o(37803);
        return locala;
      }
      AppMethodBeat.o(37803);
      return locala;
      locala = null;
    }
  }
  
  public final a cse()
  {
    AppMethodBeat.i(37804);
    a locala;
    if (this.field_atAdinfo != null)
    {
      if (rCX.containsKey(this.field_atAdinfo))
      {
        locala = (a)rCX.get(this.field_atAdinfo);
        AppMethodBeat.o(37804);
        return locala;
      }
      locala = new a(this.field_atAdinfo);
      rCX.put(this.field_atAdinfo, locala);
    }
    for (;;)
    {
      if (locala == null)
      {
        locala = new a(null);
        AppMethodBeat.o(37804);
        return locala;
      }
      AppMethodBeat.o(37804);
      return locala;
      locala = null;
    }
  }
  
  public final int csf()
  {
    AppMethodBeat.i(37806);
    b localb = csc();
    if (localb == null)
    {
      AppMethodBeat.o(37806);
      return 0;
    }
    int i = localb.rqk;
    AppMethodBeat.o(37806);
    return i;
  }
  
  public final int csg()
  {
    AppMethodBeat.i(37808);
    b localb = csc();
    if (localb == null)
    {
      AppMethodBeat.o(37808);
      return 0;
    }
    int i = localb.rql;
    AppMethodBeat.o(37808);
    return i;
  }
  
  public final TimeLineObject csh()
  {
    AppMethodBeat.i(37811);
    TimeLineObject localTimeLineObject1;
    if (this.field_content == null)
    {
      localTimeLineObject1 = com.tencent.mm.modelsns.e.akg();
      AppMethodBeat.o(37811);
      return localTimeLineObject1;
    }
    if (this.rCU == null) {
      this.rCU = (g.w(this.field_content) + g.w(this.field_attrBuf));
    }
    if (n.rDc.containsKey(this.rCU))
    {
      localTimeLineObject1 = (TimeLineObject)n.rDc.get(this.rCU);
      if (localTimeLineObject1 != null)
      {
        AppMethodBeat.o(37811);
        return localTimeLineObject1;
      }
    }
    try
    {
      localTimeLineObject1 = (TimeLineObject)new TimeLineObject().parseFrom(this.field_content);
      n.rDc.put(this.rCU, localTimeLineObject1);
      AppMethodBeat.o(37811);
      return localTimeLineObject1;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.AdSnsInfo", "error get snsinfo timeline!");
      TimeLineObject localTimeLineObject2 = com.tencent.mm.modelsns.e.akg();
      AppMethodBeat.o(37811);
      return localTimeLineObject2;
    }
  }
  
  /* Error */
  public final bs csi()
  {
    // Byte code:
    //   0: ldc_w 440
    //   3: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 320	com/tencent/mm/plugin/sns/storage/e:field_remindInfoGroup	[B
    //   10: ifnull +64 -> 74
    //   13: new 335	com/tencent/mm/protocal/protobuf/bs
    //   16: dup
    //   17: invokespecial 441	com/tencent/mm/protocal/protobuf/bs:<init>	()V
    //   20: astore_1
    //   21: aload_1
    //   22: aload_0
    //   23: getfield 320	com/tencent/mm/plugin/sns/storage/e:field_remindInfoGroup	[B
    //   26: invokevirtual 442	com/tencent/mm/protocal/protobuf/bs:parseFrom	([B)Lcom/tencent/mm/bv/a;
    //   29: pop
    //   30: ldc_w 440
    //   33: invokestatic 184	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   36: aload_1
    //   37: areturn
    //   38: astore_2
    //   39: aconst_null
    //   40: astore_1
    //   41: ldc_w 341
    //   44: new 43	java/lang/StringBuilder
    //   47: dup
    //   48: ldc_w 444
    //   51: invokespecial 344	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   54: aload_2
    //   55: invokevirtual 347	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   58: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokestatic 353	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   67: goto -37 -> 30
    //   70: astore_2
    //   71: goto -30 -> 41
    //   74: aconst_null
    //   75: astore_1
    //   76: goto -46 -> 30
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	e
    //   20	56	1	localbs	bs
    //   38	17	2	localException1	Exception
    //   70	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   6	21	38	java/lang/Exception
    //   21	30	70	java/lang/Exception
  }
  
  public final com.tencent.mm.bv.b csj()
  {
    AppMethodBeat.i(37814);
    if ((csi() != null) && (csi().wom != null) && (csi().wom.xGV != null))
    {
      com.tencent.mm.bv.b localb = csi().wom.xGV.getBuffer();
      AppMethodBeat.o(37814);
      return localb;
    }
    AppMethodBeat.o(37814);
    return null;
  }
  
  public final com.tencent.mm.bv.b csk()
  {
    AppMethodBeat.i(37815);
    if ((csi() != null) && (csi().wom != null) && (csi().wom.xGW != null))
    {
      com.tencent.mm.bv.b localb = csi().wom.xGW.getBuffer();
      AppMethodBeat.o(37815);
      return localb;
    }
    AppMethodBeat.o(37815);
    return null;
  }
  
  public final com.tencent.mm.bv.b csl()
  {
    AppMethodBeat.i(37816);
    if ((csi() != null) && (csi().won != null) && (csi().won.xGV != null))
    {
      com.tencent.mm.bv.b localb = csi().won.xGV.getBuffer();
      AppMethodBeat.o(37816);
      return localb;
    }
    AppMethodBeat.o(37816);
    return null;
  }
  
  public final com.tencent.mm.bv.b csm()
  {
    AppMethodBeat.i(37817);
    if ((csi() != null) && (csi().won != null) && (csi().won.xGW != null))
    {
      com.tencent.mm.bv.b localb = csi().won.xGW.getBuffer();
      AppMethodBeat.o(37817);
      return localb;
    }
    AppMethodBeat.o(37817);
    return null;
  }
  
  public final n csn()
  {
    AppMethodBeat.i(37820);
    n localn = new n();
    localn.c(csh());
    ab.d("MicroMsg.AdSnsInfo", "from server xml ok %d", new Object[] { Long.valueOf(this.field_snsId) });
    localn.rCV = this.rCV;
    localn.field_userName = this.field_userName;
    localn.lp(this.field_createTime);
    localn.field_likeFlag = this.field_likeFlag;
    localn.lV(this.field_snsId);
    localn.field_sourceType = this.field_sourceType;
    localn.field_content = this.field_content;
    localn.Eu(2);
    localn.Eu(32);
    localn.field_attrBuf = this.field_attrBuf;
    TimeLineObject localTimeLineObject = localn.csh();
    localTimeLineObject.jJA = this.field_userName;
    localn.field_pravited = localTimeLineObject.xrU;
    localn.csE();
    localn.c(localTimeLineObject);
    if (localTimeLineObject.xTS != null)
    {
      localn.field_type = localTimeLineObject.xTS.wNZ;
      localn.field_subType = localTimeLineObject.xTS.wOb;
    }
    localn.rDf = this;
    AppMethodBeat.o(37820);
    return localn;
  }
  
  public final Bundle cso()
  {
    AppMethodBeat.i(37822);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("values", super.convertTo());
    localBundle.putInt("localid", this.rCV);
    AppMethodBeat.o(37822);
    return localBundle;
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
  
  public final String getSnsId()
  {
    AppMethodBeat.i(37819);
    String str = v.aE("ad_table_", this.field_snsId);
    AppMethodBeat.o(37819);
    return str;
  }
  
  public final int getSource()
  {
    AppMethodBeat.i(37807);
    b localb = csc();
    if (localb == null)
    {
      AppMethodBeat.o(37807);
      return 0;
    }
    int i = localb.rqk;
    AppMethodBeat.o(37807);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.e
 * JD-Core Version:    0.7.0.1
 */