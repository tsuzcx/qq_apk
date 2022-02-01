package com.tencent.mm.plugin.sns.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.f;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.by;
import com.tencent.mm.protocal.protobuf.ciu;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class e
  extends f
{
  protected static c.a info;
  protected static Map<String, b> xiC;
  protected static Map<String, a> xiD;
  public String xiA = null;
  protected int xiB;
  
  static
  {
    AppMethodBeat.i(97433);
    c.a locala = new c.a();
    locala.EYt = new Field[24];
    locala.columns = new String[25];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "snsId";
    locala.EYv.put("snsId", "LONG");
    localStringBuilder.append(" snsId LONG");
    localStringBuilder.append(", ");
    locala.columns[1] = "userName";
    locala.EYv.put("userName", "TEXT");
    localStringBuilder.append(" userName TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "localFlag";
    locala.EYv.put("localFlag", "INTEGER");
    localStringBuilder.append(" localFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "createTime";
    locala.EYv.put("createTime", "INTEGER");
    localStringBuilder.append(" createTime INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "head";
    locala.EYv.put("head", "INTEGER");
    localStringBuilder.append(" head INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "localPrivate";
    locala.EYv.put("localPrivate", "INTEGER");
    localStringBuilder.append(" localPrivate INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "type";
    locala.EYv.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "sourceType";
    locala.EYv.put("sourceType", "INTEGER");
    localStringBuilder.append(" sourceType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[8] = "likeFlag";
    locala.EYv.put("likeFlag", "INTEGER");
    localStringBuilder.append(" likeFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "pravited";
    locala.EYv.put("pravited", "INTEGER");
    localStringBuilder.append(" pravited INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "stringSeq";
    locala.EYv.put("stringSeq", "TEXT");
    localStringBuilder.append(" stringSeq TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "content";
    locala.EYv.put("content", "BLOB");
    localStringBuilder.append(" content BLOB");
    localStringBuilder.append(", ");
    locala.columns[12] = "attrBuf";
    locala.EYv.put("attrBuf", "BLOB");
    localStringBuilder.append(" attrBuf BLOB");
    localStringBuilder.append(", ");
    locala.columns[13] = "postBuf";
    locala.EYv.put("postBuf", "BLOB");
    localStringBuilder.append(" postBuf BLOB");
    localStringBuilder.append(", ");
    locala.columns[14] = "adinfo";
    locala.EYv.put("adinfo", "TEXT");
    localStringBuilder.append(" adinfo TEXT");
    localStringBuilder.append(", ");
    locala.columns[15] = "adxml";
    locala.EYv.put("adxml", "TEXT");
    localStringBuilder.append(" adxml TEXT");
    localStringBuilder.append(", ");
    locala.columns[16] = "createAdTime";
    locala.EYv.put("createAdTime", "INTEGER");
    localStringBuilder.append(" createAdTime INTEGER");
    localStringBuilder.append(", ");
    locala.columns[17] = "exposureTime";
    locala.EYv.put("exposureTime", "INTEGER");
    localStringBuilder.append(" exposureTime INTEGER");
    localStringBuilder.append(", ");
    locala.columns[18] = "firstControlTime";
    locala.EYv.put("firstControlTime", "INTEGER");
    localStringBuilder.append(" firstControlTime INTEGER");
    localStringBuilder.append(", ");
    locala.columns[19] = "recxml";
    locala.EYv.put("recxml", "TEXT");
    localStringBuilder.append(" recxml TEXT");
    localStringBuilder.append(", ");
    locala.columns[20] = "subType";
    locala.EYv.put("subType", "INTEGER");
    localStringBuilder.append(" subType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[21] = "exposureCount";
    locala.EYv.put("exposureCount", "INTEGER");
    localStringBuilder.append(" exposureCount INTEGER");
    localStringBuilder.append(", ");
    locala.columns[22] = "atAdinfo";
    locala.EYv.put("atAdinfo", "TEXT");
    localStringBuilder.append(" atAdinfo TEXT");
    localStringBuilder.append(", ");
    locala.columns[23] = "remindInfoGroup";
    locala.EYv.put("remindInfoGroup", "BLOB");
    localStringBuilder.append(" remindInfoGroup BLOB");
    locala.columns[24] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    xiC = new ConcurrentHashMap();
    xiD = new ConcurrentHashMap();
    AppMethodBeat.o(97433);
  }
  
  private b dxt()
  {
    AppMethodBeat.i(97411);
    b localb;
    if (this.field_recxml != null)
    {
      if (xiC.containsKey(this.field_recxml))
      {
        localb = (b)xiC.get(this.field_recxml);
        AppMethodBeat.o(97411);
        return localb;
      }
      localb = new b(this.field_recxml);
      xiC.put(this.field_recxml, localb);
    }
    for (;;)
    {
      if (localb == null)
      {
        localb = new b(null);
        AppMethodBeat.o(97411);
        return localb;
      }
      AppMethodBeat.o(97411);
      return localb;
      localb = null;
    }
  }
  
  public final void MY(int paramInt)
  {
    this.field_sourceType |= paramInt;
  }
  
  public final void a(by paramby)
  {
    AppMethodBeat.i(97421);
    try
    {
      this.field_remindInfoGroup = paramby.toByteArray();
      AppMethodBeat.o(97421);
      return;
    }
    catch (Exception paramby)
    {
      ad.e("MicroMsg.AdSnsInfo", "remindInfo toBytes error! " + paramby.getMessage());
      AppMethodBeat.o(97421);
    }
  }
  
  public final void ae(Bundle paramBundle)
  {
    AppMethodBeat.i(97432);
    if (paramBundle == null)
    {
      AppMethodBeat.o(97432);
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
    this.xiB = paramBundle.getInt("localid");
    AppMethodBeat.o(97432);
  }
  
  public final boolean apI(String paramString)
  {
    AppMethodBeat.i(97419);
    paramString = com.tencent.mm.modelsns.g.zn(paramString);
    try
    {
      this.field_content = paramString.toByteArray();
      this.xiA = (com.tencent.mm.b.g.getMessageDigest(this.field_content) + com.tencent.mm.b.g.getMessageDigest(this.field_attrBuf));
      AppMethodBeat.o(97419);
      return true;
    }
    catch (Exception paramString)
    {
      ad.printErrStackTrace("MicroMsg.AdSnsInfo", paramString, "", new Object[0]);
      AppMethodBeat.o(97419);
    }
    return false;
  }
  
  public final void bC(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(97427);
    this.field_attrBuf = paramArrayOfByte;
    this.xiA = (com.tencent.mm.b.g.getMessageDigest(this.field_content) + com.tencent.mm.b.g.getMessageDigest(this.field_attrBuf));
    AppMethodBeat.o(97427);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(97430);
    super.convertFrom(paramCursor);
    this.xiB = ((int)this.systemRowid);
    AppMethodBeat.o(97430);
  }
  
  public final boolean dvv()
  {
    AppMethodBeat.i(97414);
    b localb = dxs();
    if (localb != null)
    {
      boolean bool = localb.dvv();
      AppMethodBeat.o(97414);
      return bool;
    }
    AppMethodBeat.o(97414);
    return false;
  }
  
  public final com.tencent.mm.bx.b dxA()
  {
    AppMethodBeat.i(97423);
    if ((dxz() != null) && (dxz().CwU != null) && (dxz().CwU.Eei != null))
    {
      com.tencent.mm.bx.b localb = dxz().CwU.Eei.getBuffer();
      AppMethodBeat.o(97423);
      return localb;
    }
    AppMethodBeat.o(97423);
    return null;
  }
  
  public final com.tencent.mm.bx.b dxB()
  {
    AppMethodBeat.i(97424);
    if ((dxz() != null) && (dxz().CwU != null) && (dxz().CwU.Eej != null))
    {
      com.tencent.mm.bx.b localb = dxz().CwU.Eej.getBuffer();
      AppMethodBeat.o(97424);
      return localb;
    }
    AppMethodBeat.o(97424);
    return null;
  }
  
  public final com.tencent.mm.bx.b dxC()
  {
    AppMethodBeat.i(97425);
    if ((dxz() != null) && (dxz().CwV != null) && (dxz().CwV.Eei != null))
    {
      com.tencent.mm.bx.b localb = dxz().CwV.Eei.getBuffer();
      AppMethodBeat.o(97425);
      return localb;
    }
    AppMethodBeat.o(97425);
    return null;
  }
  
  public final com.tencent.mm.bx.b dxD()
  {
    AppMethodBeat.i(97426);
    if ((dxz() != null) && (dxz().CwV != null) && (dxz().CwV.Eej != null))
    {
      com.tencent.mm.bx.b localb = dxz().CwV.Eej.getBuffer();
      AppMethodBeat.o(97426);
      return localb;
    }
    AppMethodBeat.o(97426);
    return null;
  }
  
  public final p dxE()
  {
    AppMethodBeat.i(97429);
    p localp = new p();
    localp.g(dxy());
    ad.d("MicroMsg.AdSnsInfo", "from server xml ok %d", new Object[] { Long.valueOf(this.field_snsId) });
    localp.xiB = this.xiB;
    localp.field_userName = this.field_userName;
    localp.setCreateTime(this.field_createTime);
    localp.field_likeFlag = this.field_likeFlag;
    localp.td(this.field_snsId);
    localp.field_sourceType = this.field_sourceType;
    localp.field_content = this.field_content;
    localp.MY(2);
    localp.MY(32);
    localp.field_attrBuf = this.field_attrBuf;
    TimeLineObject localTimeLineObject = localp.dxy();
    localTimeLineObject.mAQ = this.field_userName;
    localp.field_pravited = localTimeLineObject.DMS;
    localp.dxU();
    localp.g(localTimeLineObject);
    if (localTimeLineObject.Etm != null)
    {
      localp.field_type = localTimeLineObject.Etm.DaB;
      localp.field_subType = localTimeLineObject.Etm.DaD;
    }
    localp.xiL = this;
    AppMethodBeat.o(97429);
    return localp;
  }
  
  public final Bundle dxF()
  {
    AppMethodBeat.i(97431);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("values", super.convertTo());
    localBundle.putInt("localid", this.xiB);
    AppMethodBeat.o(97431);
    return localBundle;
  }
  
  public final b dxs()
  {
    AppMethodBeat.i(97410);
    b localb;
    if (this.field_adxml != null)
    {
      if (xiC.containsKey(this.field_adxml))
      {
        localb = (b)xiC.get(this.field_adxml);
        AppMethodBeat.o(97410);
        return localb;
      }
      localb = new b(this.field_adxml);
      xiC.put(this.field_adxml, localb);
    }
    for (;;)
    {
      if (localb == null)
      {
        localb = new b(null);
        AppMethodBeat.o(97410);
        return localb;
      }
      AppMethodBeat.o(97410);
      return localb;
      localb = null;
    }
  }
  
  public final a dxu()
  {
    AppMethodBeat.i(97412);
    a locala;
    if (this.field_adinfo != null)
    {
      if (xiD.containsKey(this.field_adinfo))
      {
        locala = (a)xiD.get(this.field_adinfo);
        AppMethodBeat.o(97412);
        return locala;
      }
      locala = new a(this.field_adinfo);
      xiD.put(this.field_adinfo, locala);
    }
    for (;;)
    {
      if (locala == null)
      {
        locala = new a(null);
        AppMethodBeat.o(97412);
        return locala;
      }
      AppMethodBeat.o(97412);
      return locala;
      locala = null;
    }
  }
  
  public final a dxv()
  {
    AppMethodBeat.i(97413);
    a locala;
    if (this.field_atAdinfo != null)
    {
      if (xiD.containsKey(this.field_atAdinfo))
      {
        locala = (a)xiD.get(this.field_atAdinfo);
        AppMethodBeat.o(97413);
        return locala;
      }
      locala = new a(this.field_atAdinfo);
      xiD.put(this.field_atAdinfo, locala);
    }
    for (;;)
    {
      if (locala == null)
      {
        locala = new a(null);
        AppMethodBeat.o(97413);
        return locala;
      }
      AppMethodBeat.o(97413);
      return locala;
      locala = null;
    }
  }
  
  public final int dxw()
  {
    AppMethodBeat.i(97415);
    b localb = dxt();
    if (localb == null)
    {
      AppMethodBeat.o(97415);
      return 0;
    }
    int i = localb.wTf;
    AppMethodBeat.o(97415);
    return i;
  }
  
  public final int dxx()
  {
    AppMethodBeat.i(97417);
    b localb = dxt();
    if (localb == null)
    {
      AppMethodBeat.o(97417);
      return 0;
    }
    int i = localb.wTg;
    AppMethodBeat.o(97417);
    return i;
  }
  
  public final TimeLineObject dxy()
  {
    AppMethodBeat.i(97420);
    TimeLineObject localTimeLineObject1;
    if (this.field_content == null)
    {
      localTimeLineObject1 = com.tencent.mm.modelsns.g.aBl();
      AppMethodBeat.o(97420);
      return localTimeLineObject1;
    }
    if (this.xiA == null) {
      this.xiA = (com.tencent.mm.b.g.getMessageDigest(this.field_content) + com.tencent.mm.b.g.getMessageDigest(this.field_attrBuf));
    }
    if (p.xiI.containsKey(this.xiA))
    {
      localTimeLineObject1 = (TimeLineObject)p.xiI.get(this.xiA);
      if (localTimeLineObject1 != null)
      {
        AppMethodBeat.o(97420);
        return localTimeLineObject1;
      }
    }
    try
    {
      localTimeLineObject1 = (TimeLineObject)new TimeLineObject().parseFrom(this.field_content);
      p.xiI.put(this.xiA, localTimeLineObject1);
      AppMethodBeat.o(97420);
      return localTimeLineObject1;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.AdSnsInfo", "error get snsinfo timeline!");
      TimeLineObject localTimeLineObject2 = com.tencent.mm.modelsns.g.aBl();
      AppMethodBeat.o(97420);
      return localTimeLineObject2;
    }
  }
  
  /* Error */
  public final by dxz()
  {
    // Byte code:
    //   0: ldc_w 549
    //   3: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 226	com/tencent/mm/plugin/sns/storage/e:field_remindInfoGroup	[B
    //   10: ifnull +63 -> 73
    //   13: new 218	com/tencent/mm/protocal/protobuf/by
    //   16: dup
    //   17: invokespecial 550	com/tencent/mm/protocal/protobuf/by:<init>	()V
    //   20: astore_1
    //   21: aload_1
    //   22: aload_0
    //   23: getfield 226	com/tencent/mm/plugin/sns/storage/e:field_remindInfoGroup	[B
    //   26: invokevirtual 551	com/tencent/mm/protocal/protobuf/by:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   29: pop
    //   30: ldc_w 549
    //   33: invokestatic 184	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   36: aload_1
    //   37: areturn
    //   38: astore_2
    //   39: aconst_null
    //   40: astore_1
    //   41: ldc 228
    //   43: new 43	java/lang/StringBuilder
    //   46: dup
    //   47: ldc_w 553
    //   50: invokespecial 231	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   53: aload_2
    //   54: invokevirtual 234	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   57: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokestatic 240	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   66: goto -36 -> 30
    //   69: astore_2
    //   70: goto -29 -> 41
    //   73: aconst_null
    //   74: astore_1
    //   75: goto -45 -> 30
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	e
    //   20	55	1	localby	by
    //   38	16	2	localException1	Exception
    //   69	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   6	21	38	java/lang/Exception
    //   21	30	69	java/lang/Exception
  }
  
  public final void g(TimeLineObject paramTimeLineObject)
  {
    AppMethodBeat.i(97418);
    try
    {
      this.field_content = paramTimeLineObject.toByteArray();
      AppMethodBeat.o(97418);
      return;
    }
    catch (Exception paramTimeLineObject)
    {
      ad.printErrStackTrace("MicroMsg.AdSnsInfo", paramTimeLineObject, "", new Object[0]);
      AppMethodBeat.o(97418);
    }
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
  
  public final String getSnsId()
  {
    AppMethodBeat.i(97428);
    String str = x.bh("ad_table_", this.field_snsId);
    AppMethodBeat.o(97428);
    return str;
  }
  
  public final int getSource()
  {
    AppMethodBeat.i(97416);
    b localb = dxt();
    if (localb == null)
    {
      AppMethodBeat.o(97416);
      return 0;
    }
    int i = localb.wTf;
    AppMethodBeat.o(97416);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.e
 * JD-Core Version:    0.7.0.1
 */