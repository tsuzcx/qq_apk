package com.tencent.mm.plugin.sns.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.f;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.ca;
import com.tencent.mm.protocal.protobuf.cob;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class e
  extends f
{
  protected static c.a info;
  protected static Map<String, b> yvq;
  protected static Map<String, a> yvr;
  public String yvo = null;
  protected int yvp;
  
  static
  {
    AppMethodBeat.i(97433);
    c.a locala = new c.a();
    locala.GvF = new Field[24];
    locala.columns = new String[25];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "snsId";
    locala.GvH.put("snsId", "LONG");
    localStringBuilder.append(" snsId LONG");
    localStringBuilder.append(", ");
    locala.columns[1] = "userName";
    locala.GvH.put("userName", "TEXT");
    localStringBuilder.append(" userName TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "localFlag";
    locala.GvH.put("localFlag", "INTEGER");
    localStringBuilder.append(" localFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "createTime";
    locala.GvH.put("createTime", "INTEGER");
    localStringBuilder.append(" createTime INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "head";
    locala.GvH.put("head", "INTEGER");
    localStringBuilder.append(" head INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "localPrivate";
    locala.GvH.put("localPrivate", "INTEGER");
    localStringBuilder.append(" localPrivate INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "type";
    locala.GvH.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "sourceType";
    locala.GvH.put("sourceType", "INTEGER");
    localStringBuilder.append(" sourceType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[8] = "likeFlag";
    locala.GvH.put("likeFlag", "INTEGER");
    localStringBuilder.append(" likeFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "pravited";
    locala.GvH.put("pravited", "INTEGER");
    localStringBuilder.append(" pravited INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "stringSeq";
    locala.GvH.put("stringSeq", "TEXT");
    localStringBuilder.append(" stringSeq TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "content";
    locala.GvH.put("content", "BLOB");
    localStringBuilder.append(" content BLOB");
    localStringBuilder.append(", ");
    locala.columns[12] = "attrBuf";
    locala.GvH.put("attrBuf", "BLOB");
    localStringBuilder.append(" attrBuf BLOB");
    localStringBuilder.append(", ");
    locala.columns[13] = "postBuf";
    locala.GvH.put("postBuf", "BLOB");
    localStringBuilder.append(" postBuf BLOB");
    localStringBuilder.append(", ");
    locala.columns[14] = "adinfo";
    locala.GvH.put("adinfo", "TEXT");
    localStringBuilder.append(" adinfo TEXT");
    localStringBuilder.append(", ");
    locala.columns[15] = "adxml";
    locala.GvH.put("adxml", "TEXT");
    localStringBuilder.append(" adxml TEXT");
    localStringBuilder.append(", ");
    locala.columns[16] = "createAdTime";
    locala.GvH.put("createAdTime", "INTEGER");
    localStringBuilder.append(" createAdTime INTEGER");
    localStringBuilder.append(", ");
    locala.columns[17] = "exposureTime";
    locala.GvH.put("exposureTime", "INTEGER");
    localStringBuilder.append(" exposureTime INTEGER");
    localStringBuilder.append(", ");
    locala.columns[18] = "firstControlTime";
    locala.GvH.put("firstControlTime", "INTEGER");
    localStringBuilder.append(" firstControlTime INTEGER");
    localStringBuilder.append(", ");
    locala.columns[19] = "recxml";
    locala.GvH.put("recxml", "TEXT");
    localStringBuilder.append(" recxml TEXT");
    localStringBuilder.append(", ");
    locala.columns[20] = "subType";
    locala.GvH.put("subType", "INTEGER");
    localStringBuilder.append(" subType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[21] = "exposureCount";
    locala.GvH.put("exposureCount", "INTEGER");
    localStringBuilder.append(" exposureCount INTEGER");
    localStringBuilder.append(", ");
    locala.columns[22] = "atAdinfo";
    locala.GvH.put("atAdinfo", "TEXT");
    localStringBuilder.append(" atAdinfo TEXT");
    localStringBuilder.append(", ");
    locala.columns[23] = "remindInfoGroup";
    locala.GvH.put("remindInfoGroup", "BLOB");
    localStringBuilder.append(" remindInfoGroup BLOB");
    locala.columns[24] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    yvq = new ConcurrentHashMap();
    yvr = new ConcurrentHashMap();
    AppMethodBeat.o(97433);
  }
  
  private b dLR()
  {
    AppMethodBeat.i(97411);
    b localb;
    if (this.field_recxml != null)
    {
      if (yvq.containsKey(this.field_recxml))
      {
        localb = (b)yvq.get(this.field_recxml);
        AppMethodBeat.o(97411);
        return localb;
      }
      localb = new b(this.field_recxml);
      yvq.put(this.field_recxml, localb);
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
  
  public final void Pb(int paramInt)
  {
    this.field_sourceType |= paramInt;
  }
  
  public final void a(ca paramca)
  {
    AppMethodBeat.i(97421);
    try
    {
      this.field_remindInfoGroup = paramca.toByteArray();
      AppMethodBeat.o(97421);
      return;
    }
    catch (Exception paramca)
    {
      ac.e("MicroMsg.AdSnsInfo", "remindInfo toBytes error! " + paramca.getMessage());
      AppMethodBeat.o(97421);
    }
  }
  
  public final void aj(Bundle paramBundle)
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
    this.yvp = paramBundle.getInt("localid");
    AppMethodBeat.o(97432);
  }
  
  public final boolean auR(String paramString)
  {
    AppMethodBeat.i(97419);
    paramString = com.tencent.mm.modelsns.g.Ds(paramString);
    try
    {
      this.field_content = paramString.toByteArray();
      this.yvo = (com.tencent.mm.b.g.getMessageDigest(this.field_content) + com.tencent.mm.b.g.getMessageDigest(this.field_attrBuf));
      AppMethodBeat.o(97419);
      return true;
    }
    catch (Exception paramString)
    {
      ac.printErrStackTrace("MicroMsg.AdSnsInfo", paramString, "", new Object[0]);
      AppMethodBeat.o(97419);
    }
    return false;
  }
  
  public final void bB(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(97427);
    this.field_attrBuf = paramArrayOfByte;
    this.yvo = (com.tencent.mm.b.g.getMessageDigest(this.field_content) + com.tencent.mm.b.g.getMessageDigest(this.field_attrBuf));
    AppMethodBeat.o(97427);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(97430);
    super.convertFrom(paramCursor);
    this.yvp = ((int)this.systemRowid);
    AppMethodBeat.o(97430);
  }
  
  public final a dFQ()
  {
    AppMethodBeat.i(97412);
    a locala;
    if (this.field_adinfo != null)
    {
      if (yvr.containsKey(this.field_adinfo))
      {
        locala = (a)yvr.get(this.field_adinfo);
        AppMethodBeat.o(97412);
        return locala;
      }
      locala = new a(this.field_adinfo);
      yvr.put(this.field_adinfo, locala);
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
  
  public final b dFR()
  {
    AppMethodBeat.i(97410);
    b localb;
    if (this.field_adxml != null)
    {
      if (yvq.containsKey(this.field_adxml))
      {
        localb = (b)yvq.get(this.field_adxml);
        AppMethodBeat.o(97410);
        return localb;
      }
      localb = new b(this.field_adxml);
      yvq.put(this.field_adxml, localb);
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
  
  public final boolean dJU()
  {
    AppMethodBeat.i(97414);
    b localb = dFR();
    if (localb != null)
    {
      boolean bool = localb.dJU();
      AppMethodBeat.o(97414);
      return bool;
    }
    AppMethodBeat.o(97414);
    return false;
  }
  
  public final a dLS()
  {
    AppMethodBeat.i(97413);
    a locala;
    if (this.field_atAdinfo != null)
    {
      if (yvr.containsKey(this.field_atAdinfo))
      {
        locala = (a)yvr.get(this.field_atAdinfo);
        AppMethodBeat.o(97413);
        return locala;
      }
      locala = new a(this.field_atAdinfo);
      yvr.put(this.field_atAdinfo, locala);
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
  
  public final int dLT()
  {
    AppMethodBeat.i(97415);
    b localb = dLR();
    if (localb == null)
    {
      AppMethodBeat.o(97415);
      return 0;
    }
    int i = localb.yfP;
    AppMethodBeat.o(97415);
    return i;
  }
  
  public final int dLU()
  {
    AppMethodBeat.i(97417);
    b localb = dLR();
    if (localb == null)
    {
      AppMethodBeat.o(97417);
      return 0;
    }
    int i = localb.yfQ;
    AppMethodBeat.o(97417);
    return i;
  }
  
  public final TimeLineObject dLV()
  {
    AppMethodBeat.i(97420);
    TimeLineObject localTimeLineObject1;
    if (this.field_content == null)
    {
      localTimeLineObject1 = com.tencent.mm.modelsns.g.aIb();
      AppMethodBeat.o(97420);
      return localTimeLineObject1;
    }
    if (this.yvo == null) {
      this.yvo = (com.tencent.mm.b.g.getMessageDigest(this.field_content) + com.tencent.mm.b.g.getMessageDigest(this.field_attrBuf));
    }
    if (p.yvz.containsKey(this.yvo))
    {
      localTimeLineObject1 = (TimeLineObject)p.yvz.get(this.yvo);
      if (localTimeLineObject1 != null)
      {
        AppMethodBeat.o(97420);
        return localTimeLineObject1;
      }
    }
    try
    {
      localTimeLineObject1 = (TimeLineObject)new TimeLineObject().parseFrom(this.field_content);
      p.yvz.put(this.yvo, localTimeLineObject1);
      AppMethodBeat.o(97420);
      return localTimeLineObject1;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.AdSnsInfo", "error get snsinfo timeline!");
      TimeLineObject localTimeLineObject2 = com.tencent.mm.modelsns.g.aIb();
      AppMethodBeat.o(97420);
      return localTimeLineObject2;
    }
  }
  
  /* Error */
  public final ca dLW()
  {
    // Byte code:
    //   0: ldc_w 437
    //   3: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 226	com/tencent/mm/plugin/sns/storage/e:field_remindInfoGroup	[B
    //   10: ifnull +63 -> 73
    //   13: new 218	com/tencent/mm/protocal/protobuf/ca
    //   16: dup
    //   17: invokespecial 438	com/tencent/mm/protocal/protobuf/ca:<init>	()V
    //   20: astore_1
    //   21: aload_1
    //   22: aload_0
    //   23: getfield 226	com/tencent/mm/plugin/sns/storage/e:field_remindInfoGroup	[B
    //   26: invokevirtual 439	com/tencent/mm/protocal/protobuf/ca:parseFrom	([B)Lcom/tencent/mm/bw/a;
    //   29: pop
    //   30: ldc_w 437
    //   33: invokestatic 184	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   36: aload_1
    //   37: areturn
    //   38: astore_2
    //   39: aconst_null
    //   40: astore_1
    //   41: ldc 228
    //   43: new 43	java/lang/StringBuilder
    //   46: dup
    //   47: ldc_w 441
    //   50: invokespecial 231	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   53: aload_2
    //   54: invokevirtual 234	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   57: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokestatic 240	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   66: goto -36 -> 30
    //   69: astore_2
    //   70: goto -29 -> 41
    //   73: aconst_null
    //   74: astore_1
    //   75: goto -45 -> 30
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	e
    //   20	55	1	localca	ca
    //   38	16	2	localException1	Exception
    //   69	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   6	21	38	java/lang/Exception
    //   21	30	69	java/lang/Exception
  }
  
  public final com.tencent.mm.bw.b dLX()
  {
    AppMethodBeat.i(97423);
    if ((dLW() != null) && (dLW().DPq != null) && (dLW().DPq.FBi != null))
    {
      com.tencent.mm.bw.b localb = dLW().DPq.FBi.getBuffer();
      AppMethodBeat.o(97423);
      return localb;
    }
    AppMethodBeat.o(97423);
    return null;
  }
  
  public final com.tencent.mm.bw.b dLY()
  {
    AppMethodBeat.i(97424);
    if ((dLW() != null) && (dLW().DPq != null) && (dLW().DPq.FBj != null))
    {
      com.tencent.mm.bw.b localb = dLW().DPq.FBj.getBuffer();
      AppMethodBeat.o(97424);
      return localb;
    }
    AppMethodBeat.o(97424);
    return null;
  }
  
  public final com.tencent.mm.bw.b dLZ()
  {
    AppMethodBeat.i(97425);
    if ((dLW() != null) && (dLW().DPr != null) && (dLW().DPr.FBi != null))
    {
      com.tencent.mm.bw.b localb = dLW().DPr.FBi.getBuffer();
      AppMethodBeat.o(97425);
      return localb;
    }
    AppMethodBeat.o(97425);
    return null;
  }
  
  public final com.tencent.mm.bw.b dMa()
  {
    AppMethodBeat.i(97426);
    if ((dLW() != null) && (dLW().DPr != null) && (dLW().DPr.FBj != null))
    {
      com.tencent.mm.bw.b localb = dLW().DPr.FBj.getBuffer();
      AppMethodBeat.o(97426);
      return localb;
    }
    AppMethodBeat.o(97426);
    return null;
  }
  
  public final p dMb()
  {
    AppMethodBeat.i(97429);
    p localp = new p();
    localp.f(dLV());
    ac.d("MicroMsg.AdSnsInfo", "from server xml ok %d", new Object[] { Long.valueOf(this.field_snsId) });
    localp.yvp = this.yvp;
    localp.field_userName = this.field_userName;
    localp.setCreateTime(this.field_createTime);
    localp.field_likeFlag = this.field_likeFlag;
    localp.xG(this.field_snsId);
    localp.field_sourceType = this.field_sourceType;
    localp.field_content = this.field_content;
    localp.Pb(2);
    localp.Pb(32);
    localp.field_attrBuf = this.field_attrBuf;
    TimeLineObject localTimeLineObject = localp.dLV();
    localTimeLineObject.ncR = this.field_userName;
    localp.field_pravited = localTimeLineObject.Fjj;
    localp.dMr();
    localp.f(localTimeLineObject);
    if (localTimeLineObject.FQo != null)
    {
      localp.field_type = localTimeLineObject.FQo.Ety;
      localp.field_subType = localTimeLineObject.FQo.EtA;
    }
    localp.yvC = this;
    AppMethodBeat.o(97429);
    return localp;
  }
  
  public final Bundle dMc()
  {
    AppMethodBeat.i(97431);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("values", super.convertTo());
    localBundle.putInt("localid", this.yvp);
    AppMethodBeat.o(97431);
    return localBundle;
  }
  
  public final void f(TimeLineObject paramTimeLineObject)
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
      ac.printErrStackTrace("MicroMsg.AdSnsInfo", paramTimeLineObject, "", new Object[0]);
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
    String str = x.bj("ad_table_", this.field_snsId);
    AppMethodBeat.o(97428);
    return str;
  }
  
  public final int getSource()
  {
    AppMethodBeat.i(97416);
    b localb = dLR();
    if (localb == null)
    {
      AppMethodBeat.o(97416);
      return 0;
    }
    int i = localb.yfP;
    AppMethodBeat.o(97416);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.e
 * JD-Core Version:    0.7.0.1
 */