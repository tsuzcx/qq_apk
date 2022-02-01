package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.g.c.gb;
import com.tencent.mm.modelsns.h;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.bzi;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class p
  extends gb
{
  protected static Map<String, TimeLineObject> AdT;
  protected static Map<String, bzi> AdU;
  protected static c.a info;
  public String AdI;
  public int AdJ;
  public String AdV;
  public e AdW;
  private bzi AdX;
  private boolean isAd;
  
  static
  {
    AppMethodBeat.i(97532);
    c.a locala = new c.a();
    locala.IBL = new Field[15];
    locala.columns = new String[16];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "snsId";
    locala.IBN.put("snsId", "LONG");
    localStringBuilder.append(" snsId LONG");
    localStringBuilder.append(", ");
    locala.columns[1] = "userName";
    locala.IBN.put("userName", "TEXT");
    localStringBuilder.append(" userName TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "localFlag";
    locala.IBN.put("localFlag", "INTEGER");
    localStringBuilder.append(" localFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "createTime";
    locala.IBN.put("createTime", "INTEGER");
    localStringBuilder.append(" createTime INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "head";
    locala.IBN.put("head", "INTEGER");
    localStringBuilder.append(" head INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "localPrivate";
    locala.IBN.put("localPrivate", "INTEGER");
    localStringBuilder.append(" localPrivate INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "type";
    locala.IBN.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "sourceType";
    locala.IBN.put("sourceType", "INTEGER");
    localStringBuilder.append(" sourceType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[8] = "likeFlag";
    locala.IBN.put("likeFlag", "INTEGER");
    localStringBuilder.append(" likeFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "pravited";
    locala.IBN.put("pravited", "INTEGER");
    localStringBuilder.append(" pravited INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "stringSeq";
    locala.IBN.put("stringSeq", "TEXT");
    localStringBuilder.append(" stringSeq TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "content";
    locala.IBN.put("content", "BLOB");
    localStringBuilder.append(" content BLOB");
    localStringBuilder.append(", ");
    locala.columns[12] = "attrBuf";
    locala.IBN.put("attrBuf", "BLOB");
    localStringBuilder.append(" attrBuf BLOB");
    localStringBuilder.append(", ");
    locala.columns[13] = "postBuf";
    locala.IBN.put("postBuf", "BLOB");
    localStringBuilder.append(" postBuf BLOB");
    localStringBuilder.append(", ");
    locala.columns[14] = "subType";
    locala.IBN.put("subType", "INTEGER");
    localStringBuilder.append(" subType INTEGER");
    locala.columns[15] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AdT = new ConcurrentHashMap();
    AdU = new ConcurrentHashMap();
    AppMethodBeat.o(97532);
  }
  
  public p()
  {
    this.AdI = null;
    this.AdV = null;
    this.isAd = false;
    this.AdX = null;
  }
  
  public p(byte paramByte)
  {
    AppMethodBeat.i(97498);
    this.AdI = null;
    this.AdV = null;
    this.isAd = false;
    this.AdX = null;
    AC(0L);
    AppMethodBeat.o(97498);
  }
  
  private static int AD(long paramLong)
  {
    AppMethodBeat.i(97502);
    String str = new SimpleDateFormat("yyyyMMdd").format(new Date(1000L * paramLong));
    try
    {
      i = Integer.valueOf(str).intValue();
      AppMethodBeat.o(97502);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.e("MicroMsg.SnsInfo", "error valueOf  ".concat(String.valueOf(str)));
        int i = (int)(paramLong / 86400L);
      }
    }
  }
  
  public static boolean AF(long paramLong)
  {
    AppMethodBeat.i(97512);
    if (bu.rZ(paramLong / 1000L) > 1200L)
    {
      AppMethodBeat.o(97512);
      return true;
    }
    AppMethodBeat.o(97512);
    return false;
  }
  
  public static p K(p paramp)
  {
    AppMethodBeat.i(97499);
    p localp = new p();
    localp.AdJ = paramp.AdJ;
    localp.field_snsId = paramp.field_snsId;
    localp.field_userName = paramp.field_userName;
    localp.field_localFlag = paramp.field_localFlag;
    localp.field_createTime = paramp.field_createTime;
    localp.field_head = paramp.field_head;
    localp.field_localPrivate = paramp.field_localPrivate;
    localp.field_type = paramp.field_type;
    localp.field_sourceType = paramp.field_sourceType;
    localp.field_likeFlag = paramp.field_likeFlag;
    localp.field_pravited = paramp.field_pravited;
    localp.field_stringSeq = paramp.field_stringSeq;
    localp.field_content = paramp.field_content;
    localp.field_attrBuf = paramp.field_attrBuf;
    AppMethodBeat.o(97499);
    return localp;
  }
  
  public static void release()
  {
    try
    {
      AppMethodBeat.i(97508);
      AdT.clear();
      AdU.clear();
      AppMethodBeat.o(97508);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void AC(long paramLong)
  {
    AppMethodBeat.i(97500);
    this.field_snsId = paramLong;
    if (paramLong != 0L) {
      AE(paramLong);
    }
    AppMethodBeat.o(97500);
  }
  
  public final void AE(long paramLong)
  {
    AppMethodBeat.i(97506);
    this.field_stringSeq = r.zV(paramLong);
    this.field_stringSeq = r.azu(this.field_stringSeq);
    ae.d("MicroMsg.SnsInfo", paramLong + " stringSeq " + this.field_stringSeq);
    AppMethodBeat.o(97506);
  }
  
  public final void Rq(int paramInt)
  {
    this.field_sourceType |= paramInt;
  }
  
  public final boolean Rt(int paramInt)
  {
    return (this.field_sourceType & paramInt) > 0;
  }
  
  public final void Ru(int paramInt)
  {
    this.field_sourceType &= (paramInt ^ 0xFFFFFFFF);
  }
  
  public final a Rv(int paramInt)
  {
    AppMethodBeat.i(97516);
    if (paramInt == 2)
    {
      locala = ebM();
      AppMethodBeat.o(97516);
      return locala;
    }
    a locala = dVi();
    AppMethodBeat.o(97516);
    return locala;
  }
  
  public final boolean aBp(String paramString)
  {
    AppMethodBeat.i(97511);
    paramString = h.GZ(paramString);
    try
    {
      this.field_content = paramString.toByteArray();
      this.AdI = (g.getMessageDigest(this.field_content) + g.getMessageDigest(this.field_attrBuf));
      AppMethodBeat.o(97511);
      return true;
    }
    catch (Exception paramString)
    {
      ae.printErrStackTrace("MicroMsg.SnsInfo", paramString, "", new Object[0]);
      AppMethodBeat.o(97511);
    }
    return false;
  }
  
  public final void bL(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(97505);
    this.field_attrBuf = paramArrayOfByte;
    this.AdI = (g.getMessageDigest(this.field_content) + g.getMessageDigest(this.field_attrBuf));
    AppMethodBeat.o(97505);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(97507);
    super.convertFrom(paramCursor);
    this.AdJ = ((int)this.systemRowid);
    AppMethodBeat.o(97507);
  }
  
  public final a dVi()
  {
    AppMethodBeat.i(97514);
    if (this.AdW == null) {
      this.AdW = ah.dXH().Ax(this.field_snsId);
    }
    if (this.AdW == null)
    {
      locala = new a(null);
      AppMethodBeat.o(97514);
      return locala;
    }
    a locala = this.AdW.dVi();
    AppMethodBeat.o(97514);
    return locala;
  }
  
  /* Error */
  public final b dVj()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 385
    //   5: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 364	com/tencent/mm/plugin/sns/storage/p:AdW	Lcom/tencent/mm/plugin/sns/storage/e;
    //   12: ifnonnull +17 -> 29
    //   15: aload_0
    //   16: invokestatic 370	com/tencent/mm/plugin/sns/model/ah:dXH	()Lcom/tencent/mm/plugin/sns/storage/f;
    //   19: aload_0
    //   20: getfield 243	com/tencent/mm/plugin/sns/storage/p:field_snsId	J
    //   23: invokevirtual 376	com/tencent/mm/plugin/sns/storage/f:Ax	(J)Lcom/tencent/mm/plugin/sns/storage/e;
    //   26: putfield 364	com/tencent/mm/plugin/sns/storage/p:AdW	Lcom/tencent/mm/plugin/sns/storage/e;
    //   29: aload_0
    //   30: getfield 364	com/tencent/mm/plugin/sns/storage/p:AdW	Lcom/tencent/mm/plugin/sns/storage/e;
    //   33: ifnonnull +22 -> 55
    //   36: new 387	com/tencent/mm/plugin/sns/storage/b
    //   39: dup
    //   40: aconst_null
    //   41: invokespecial 388	com/tencent/mm/plugin/sns/storage/b:<init>	(Ljava/lang/String;)V
    //   44: astore_1
    //   45: ldc_w 385
    //   48: invokestatic 155	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_1
    //   54: areturn
    //   55: aload_0
    //   56: getfield 364	com/tencent/mm/plugin/sns/storage/p:AdW	Lcom/tencent/mm/plugin/sns/storage/e;
    //   59: invokevirtual 390	com/tencent/mm/plugin/sns/storage/e:dVj	()Lcom/tencent/mm/plugin/sns/storage/b;
    //   62: astore_1
    //   63: ldc_w 385
    //   66: invokestatic 155	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: goto -18 -> 51
    //   72: astore_1
    //   73: aload_0
    //   74: monitorexit
    //   75: aload_1
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	p
    //   44	19	1	localb	b
    //   72	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	29	72	finally
    //   29	51	72	finally
    //   55	69	72	finally
  }
  
  public final boolean dXn()
  {
    return this.field_snsId == 0L;
  }
  
  public final boolean dZA()
  {
    AppMethodBeat.i(97528);
    if ((dVj() != null) && (dVj().dZA()))
    {
      AppMethodBeat.o(97528);
      return true;
    }
    AppMethodBeat.o(97528);
    return false;
  }
  
  public final boolean dZB()
  {
    AppMethodBeat.i(97529);
    if ((dVj() != null) && (dVj().dZB()))
    {
      AppMethodBeat.o(97529);
      return true;
    }
    AppMethodBeat.o(97529);
    return false;
  }
  
  public final boolean dZC()
  {
    AppMethodBeat.i(97530);
    if ((dVj() != null) && (dVj().dZC()))
    {
      AppMethodBeat.o(97530);
      return true;
    }
    AppMethodBeat.o(97530);
    return false;
  }
  
  public final boolean dZD()
  {
    AppMethodBeat.i(219641);
    if ((dVj() != null) && (dVj().dZD()))
    {
      AppMethodBeat.o(219641);
      return true;
    }
    AppMethodBeat.o(219641);
    return false;
  }
  
  public final boolean dZL()
  {
    AppMethodBeat.i(97525);
    b localb = dVj();
    if (localb != null)
    {
      boolean bool = localb.dZL();
      AppMethodBeat.o(97525);
      return bool;
    }
    AppMethodBeat.o(97525);
    return false;
  }
  
  public final a ebM()
  {
    AppMethodBeat.i(97515);
    if (this.AdW == null) {
      this.AdW = ah.dXH().Ax(this.field_snsId);
    }
    if (this.AdW == null)
    {
      locala = new a(null);
      AppMethodBeat.o(97515);
      return locala;
    }
    a locala = this.AdW.ebM();
    AppMethodBeat.o(97515);
    return locala;
  }
  
  public final TimeLineObject ebP()
  {
    AppMethodBeat.i(97509);
    TimeLineObject localTimeLineObject1;
    if (this.field_content == null)
    {
      localTimeLineObject1 = h.aLJ();
      AppMethodBeat.o(97509);
      return localTimeLineObject1;
    }
    if (this.AdI == null) {
      this.AdI = (g.getMessageDigest(this.field_content) + g.getMessageDigest(this.field_attrBuf));
    }
    if (AdT.containsKey(this.AdI))
    {
      localTimeLineObject1 = (TimeLineObject)AdT.get(this.AdI);
      if (localTimeLineObject1 != null)
      {
        AppMethodBeat.o(97509);
        return localTimeLineObject1;
      }
    }
    try
    {
      localTimeLineObject1 = (TimeLineObject)new TimeLineObject().parseFrom(this.field_content);
      AdT.put(this.AdI, localTimeLineObject1);
      AppMethodBeat.o(97509);
      return localTimeLineObject1;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.SnsInfo", "error get snsinfo timeline!");
      TimeLineObject localTimeLineObject2 = h.aLJ();
      AppMethodBeat.o(97509);
      return localTimeLineObject2;
    }
  }
  
  public final Bundle ebW()
  {
    AppMethodBeat.i(97531);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("values", super.convertTo());
    localBundle.putInt("localid", this.AdJ);
    if (ecy() != null) {
      localBundle.putBundle("adValues", ecy().ebW());
    }
    AppMethodBeat.o(97531);
    return localBundle;
  }
  
  public final int ecA()
  {
    AppMethodBeat.i(97526);
    if (Rt(32))
    {
      b localb = dVj();
      TimeLineObject localTimeLineObject = ebP();
      if (localb.dZz())
      {
        AppMethodBeat.o(97526);
        return 3;
      }
      if ((localTimeLineObject != null) && (localTimeLineObject.HUG.Gtw == 27))
      {
        AppMethodBeat.o(97526);
        return 6;
      }
      if ((localb.dZA()) || (localb.dZB()))
      {
        if ((localTimeLineObject != null) && (localTimeLineObject.HUG.Gtw == 15) && (localTimeLineObject.HUN != 1))
        {
          AppMethodBeat.o(97526);
          return 5;
        }
        AppMethodBeat.o(97526);
        return 4;
      }
      if (this.field_type == 1)
      {
        AppMethodBeat.o(97526);
        return 1;
      }
      AppMethodBeat.o(97526);
      return 2;
    }
    AppMethodBeat.o(97526);
    return -1;
  }
  
  public final boolean ecB()
  {
    AppMethodBeat.i(97527);
    if ((ebP() != null) && (ebP().HUG.Gtw == 27))
    {
      AppMethodBeat.o(97527);
      return true;
    }
    AppMethodBeat.o(97527);
    return false;
  }
  
  public final boolean ecC()
  {
    AppMethodBeat.i(219640);
    b localb = dVj();
    a locala = dVi();
    if ((Rt(32)) && (localb != null) && (localb.zOa != null) && (locala != null) && (locala.zLR == 9))
    {
      AppMethodBeat.o(219640);
      return true;
    }
    AppMethodBeat.o(219640);
    return false;
  }
  
  public final bzi ech()
  {
    AppMethodBeat.i(97497);
    bzi localbzi1;
    if (this.field_postBuf == null)
    {
      localbzi1 = new bzi();
      AppMethodBeat.o(97497);
      return localbzi1;
    }
    if (this.AdV == null) {
      this.AdV = g.getMessageDigest(this.field_postBuf);
    }
    if (AdU.containsKey(this.AdV))
    {
      this.AdX = ((bzi)AdU.get(this.AdV));
      if (this.AdX != null)
      {
        localbzi1 = this.AdX;
        AppMethodBeat.o(97497);
        return localbzi1;
      }
    }
    try
    {
      this.AdX = ((bzi)new bzi().parseFrom(this.field_postBuf));
      AdU.put(this.AdV, this.AdX);
      localbzi1 = this.AdX;
      AppMethodBeat.o(97497);
      return localbzi1;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.SnsInfo", "error get snsinfo timeline!");
      bzi localbzi2 = new bzi();
      AppMethodBeat.o(97497);
      return localbzi2;
    }
  }
  
  public final void eci()
  {
    this.field_localPrivate |= 0x1;
  }
  
  public final int ecj()
  {
    return this.field_localPrivate;
  }
  
  public final boolean eck()
  {
    return (this.field_localFlag & 0x80) > 0;
  }
  
  public final void ecl()
  {
    this.field_localFlag |= 0x2;
  }
  
  public final void ecm()
  {
    this.field_localFlag &= 0xFFFFFFFD;
  }
  
  public final boolean ecn()
  {
    return (this.field_localFlag & 0x2) > 0;
  }
  
  public final String eco()
  {
    AppMethodBeat.i(97504);
    if (Rt(32))
    {
      str = x.bn("ad_table_", this.AdJ);
      AppMethodBeat.o(97504);
      return str;
    }
    String str = x.bn("sns_table_", this.AdJ);
    AppMethodBeat.o(97504);
    return str;
  }
  
  public final boolean ecp()
  {
    return (this.field_localFlag & 0x10) > 0;
  }
  
  public final boolean ecq()
  {
    return ((this.field_localFlag & 0x20) > 0) && (this.field_snsId == 0L);
  }
  
  public final void ecr()
  {
    this.field_localFlag &= 0xFFFFFFDF;
  }
  
  public final void ecs()
  {
    this.field_localFlag |= 0x20;
  }
  
  public final String ect()
  {
    AppMethodBeat.i(97517);
    Object localObject = dVi();
    if (localObject == null)
    {
      AppMethodBeat.o(97517);
      return "";
    }
    localObject = ((a)localObject).zMk;
    AppMethodBeat.o(97517);
    return localObject;
  }
  
  public final String ecu()
  {
    AppMethodBeat.i(97518);
    Object localObject = dVi();
    if (localObject == null)
    {
      AppMethodBeat.o(97518);
      return "";
    }
    localObject = ((a)localObject).zMj;
    AppMethodBeat.o(97518);
    return localObject;
  }
  
  public final String ecv()
  {
    AppMethodBeat.i(97519);
    Object localObject = dVj();
    if (localObject != null)
    {
      localObject = ((b)localObject).zLV;
      AppMethodBeat.o(97519);
      return localObject;
    }
    AppMethodBeat.o(97519);
    return "";
  }
  
  public final String ecw()
  {
    AppMethodBeat.i(97520);
    Object localObject = dVi();
    if (localObject != null)
    {
      localObject = ((a)localObject).zLV;
      AppMethodBeat.o(97520);
      return localObject;
    }
    AppMethodBeat.o(97520);
    return "";
  }
  
  public final String ecx()
  {
    AppMethodBeat.i(97521);
    Object localObject = dVi();
    if (localObject != null)
    {
      localObject = ((a)localObject).dGD;
      AppMethodBeat.o(97521);
      return localObject;
    }
    AppMethodBeat.o(97521);
    return "";
  }
  
  public final e ecy()
  {
    AppMethodBeat.i(97522);
    if (this.AdW == null) {
      this.AdW = ah.dXH().Ax(this.field_snsId);
    }
    if (this.AdW != null)
    {
      this.AdW.field_createTime = this.field_createTime;
      this.AdW.field_userName = this.field_userName;
      this.AdW.field_likeFlag = this.field_likeFlag;
      this.AdW.field_attrBuf = this.field_attrBuf;
    }
    e locale = this.AdW;
    AppMethodBeat.o(97522);
    return locale;
  }
  
  public final int ecz()
  {
    AppMethodBeat.i(97524);
    b localb = dVj();
    if (localb != null)
    {
      int i = localb.zNm;
      AppMethodBeat.o(97524);
      return i;
    }
    AppMethodBeat.o(97524);
    return 0;
  }
  
  public final void f(TimeLineObject paramTimeLineObject)
  {
    AppMethodBeat.i(97510);
    try
    {
      this.field_content = paramTimeLineObject.toByteArray();
      this.AdI = (g.getMessageDigest(this.field_content) + g.getMessageDigest(this.field_attrBuf));
      AppMethodBeat.o(97510);
      return;
    }
    catch (Exception paramTimeLineObject)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.SnsInfo", paramTimeLineObject, "", new Object[0]);
      }
    }
  }
  
  public final int getCreateTime()
  {
    return this.field_createTime;
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
  
  public final String getSnsId()
  {
    AppMethodBeat.i(97501);
    if (Rt(32))
    {
      str = x.bn("ad_table_", this.field_snsId);
      AppMethodBeat.o(97501);
      return str;
    }
    String str = x.bn("sns_table_", this.field_snsId);
    AppMethodBeat.o(97501);
    return str;
  }
  
  public final String getUserName()
  {
    return this.field_userName;
  }
  
  public final boolean isValid()
  {
    return this.field_snsId != 0L;
  }
  
  public final void setCreateTime(int paramInt)
  {
    AppMethodBeat.i(97503);
    if ((paramInt - this.field_createTime < 180) && (paramInt - this.field_createTime >= 0))
    {
      if (this.field_head == 0) {
        this.field_head = AD(this.field_createTime);
      }
      AppMethodBeat.o(97503);
      return;
    }
    this.field_createTime = paramInt;
    this.field_head = AD(paramInt);
    AppMethodBeat.o(97503);
  }
  
  public final boolean vx()
  {
    AppMethodBeat.i(224106);
    boolean bool = Rt(32);
    AppMethodBeat.o(224106);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.p
 * JD-Core Version:    0.7.0.1
 */