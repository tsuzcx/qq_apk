package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fq;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bua;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class p
  extends fq
{
  protected static c.a info;
  protected static Map<String, bua> yvA;
  protected static Map<String, TimeLineObject> yvz;
  private boolean isAd;
  public String yvB;
  public e yvC;
  private bua yvD;
  public String yvo;
  public int yvp;
  
  static
  {
    AppMethodBeat.i(97532);
    c.a locala = new c.a();
    locala.GvF = new Field[15];
    locala.columns = new String[16];
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
    locala.columns[14] = "subType";
    locala.GvH.put("subType", "INTEGER");
    localStringBuilder.append(" subType INTEGER");
    locala.columns[15] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    yvz = new ConcurrentHashMap();
    yvA = new ConcurrentHashMap();
    AppMethodBeat.o(97532);
  }
  
  public p()
  {
    this.yvo = null;
    this.yvB = null;
    this.isAd = false;
    this.yvD = null;
  }
  
  public p(byte paramByte)
  {
    AppMethodBeat.i(97498);
    this.yvo = null;
    this.yvB = null;
    this.isAd = false;
    this.yvD = null;
    xG(0L);
    AppMethodBeat.o(97498);
  }
  
  public static p I(p paramp)
  {
    AppMethodBeat.i(97499);
    p localp = new p();
    localp.yvp = paramp.yvp;
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
      yvz.clear();
      yvA.clear();
      AppMethodBeat.o(97508);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private static int xH(long paramLong)
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
        ac.e("MicroMsg.SnsInfo", "error valueOf  ".concat(String.valueOf(str)));
        int i = (int)(paramLong / 86400L);
      }
    }
  }
  
  public static boolean xJ(long paramLong)
  {
    AppMethodBeat.i(97512);
    if (bs.pN(paramLong / 1000L) > 1200L)
    {
      AppMethodBeat.o(97512);
      return true;
    }
    AppMethodBeat.o(97512);
    return false;
  }
  
  public final void Pb(int paramInt)
  {
    this.field_sourceType |= paramInt;
  }
  
  public final boolean Pe(int paramInt)
  {
    return (this.field_sourceType & paramInt) > 0;
  }
  
  public final void Pf(int paramInt)
  {
    this.field_sourceType &= (paramInt ^ 0xFFFFFFFF);
  }
  
  public final a Pg(int paramInt)
  {
    AppMethodBeat.i(97516);
    if (paramInt == 2)
    {
      locala = dLS();
      AppMethodBeat.o(97516);
      return locala;
    }
    a locala = dFQ();
    AppMethodBeat.o(97516);
    return locala;
  }
  
  public final boolean auR(String paramString)
  {
    AppMethodBeat.i(97511);
    paramString = com.tencent.mm.modelsns.g.Ds(paramString);
    try
    {
      this.field_content = paramString.toByteArray();
      this.yvo = (com.tencent.mm.b.g.getMessageDigest(this.field_content) + com.tencent.mm.b.g.getMessageDigest(this.field_attrBuf));
      AppMethodBeat.o(97511);
      return true;
    }
    catch (Exception paramString)
    {
      ac.printErrStackTrace("MicroMsg.SnsInfo", paramString, "", new Object[0]);
      AppMethodBeat.o(97511);
    }
    return false;
  }
  
  public final void bB(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(97505);
    this.field_attrBuf = paramArrayOfByte;
    this.yvo = (com.tencent.mm.b.g.getMessageDigest(this.field_content) + com.tencent.mm.b.g.getMessageDigest(this.field_attrBuf));
    AppMethodBeat.o(97505);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(97507);
    super.convertFrom(paramCursor);
    this.yvp = ((int)this.systemRowid);
    AppMethodBeat.o(97507);
  }
  
  public final a dFQ()
  {
    AppMethodBeat.i(97514);
    if (this.yvC == null) {
      this.yvC = af.dHU().xB(this.field_snsId);
    }
    if (this.yvC == null)
    {
      locala = new a(null);
      AppMethodBeat.o(97514);
      return locala;
    }
    a locala = this.yvC.dFQ();
    AppMethodBeat.o(97514);
    return locala;
  }
  
  public final b dFR()
  {
    AppMethodBeat.i(97513);
    if (this.yvC == null) {
      this.yvC = af.dHU().xB(this.field_snsId);
    }
    if (this.yvC == null)
    {
      localb = new b(null);
      AppMethodBeat.o(97513);
      return localb;
    }
    b localb = this.yvC.dFR();
    AppMethodBeat.o(97513);
    return localb;
  }
  
  public final boolean dHA()
  {
    return this.field_snsId == 0L;
  }
  
  public final boolean dJL()
  {
    AppMethodBeat.i(97528);
    if ((dFR() != null) && (dFR().dJL()))
    {
      AppMethodBeat.o(97528);
      return true;
    }
    AppMethodBeat.o(97528);
    return false;
  }
  
  public final boolean dJM()
  {
    AppMethodBeat.i(97529);
    if ((dFR() != null) && (dFR().dJM()))
    {
      AppMethodBeat.o(97529);
      return true;
    }
    AppMethodBeat.o(97529);
    return false;
  }
  
  public final boolean dJU()
  {
    AppMethodBeat.i(97525);
    b localb = dFR();
    if (localb != null)
    {
      boolean bool = localb.dJU();
      AppMethodBeat.o(97525);
      return bool;
    }
    AppMethodBeat.o(97525);
    return false;
  }
  
  public final a dLS()
  {
    AppMethodBeat.i(97515);
    if (this.yvC == null) {
      this.yvC = af.dHU().xB(this.field_snsId);
    }
    if (this.yvC == null)
    {
      locala = new a(null);
      AppMethodBeat.o(97515);
      return locala;
    }
    a locala = this.yvC.dLS();
    AppMethodBeat.o(97515);
    return locala;
  }
  
  public final TimeLineObject dLV()
  {
    AppMethodBeat.i(97509);
    TimeLineObject localTimeLineObject1;
    if (this.field_content == null)
    {
      localTimeLineObject1 = com.tencent.mm.modelsns.g.aIb();
      AppMethodBeat.o(97509);
      return localTimeLineObject1;
    }
    if (this.yvo == null) {
      this.yvo = (com.tencent.mm.b.g.getMessageDigest(this.field_content) + com.tencent.mm.b.g.getMessageDigest(this.field_attrBuf));
    }
    if (yvz.containsKey(this.yvo))
    {
      localTimeLineObject1 = (TimeLineObject)yvz.get(this.yvo);
      if (localTimeLineObject1 != null)
      {
        AppMethodBeat.o(97509);
        return localTimeLineObject1;
      }
    }
    try
    {
      localTimeLineObject1 = (TimeLineObject)new TimeLineObject().parseFrom(this.field_content);
      yvz.put(this.yvo, localTimeLineObject1);
      AppMethodBeat.o(97509);
      return localTimeLineObject1;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.SnsInfo", "error get snsinfo timeline!");
      TimeLineObject localTimeLineObject2 = com.tencent.mm.modelsns.g.aIb();
      AppMethodBeat.o(97509);
      return localTimeLineObject2;
    }
  }
  
  public final String dMA()
  {
    AppMethodBeat.i(97518);
    Object localObject = dFQ();
    if (localObject == null)
    {
      AppMethodBeat.o(97518);
      return "";
    }
    localObject = ((a)localObject).yeN;
    AppMethodBeat.o(97518);
    return localObject;
  }
  
  public final String dMB()
  {
    AppMethodBeat.i(97519);
    Object localObject = dFR();
    if (localObject != null)
    {
      localObject = ((b)localObject).yeD;
      AppMethodBeat.o(97519);
      return localObject;
    }
    AppMethodBeat.o(97519);
    return "";
  }
  
  public final String dMC()
  {
    AppMethodBeat.i(97520);
    Object localObject = dFQ();
    if (localObject != null)
    {
      localObject = ((a)localObject).yeD;
      AppMethodBeat.o(97520);
      return localObject;
    }
    AppMethodBeat.o(97520);
    return "";
  }
  
  public final String dMD()
  {
    AppMethodBeat.i(97521);
    Object localObject = dFQ();
    if (localObject != null)
    {
      localObject = ((a)localObject).dtx;
      AppMethodBeat.o(97521);
      return localObject;
    }
    AppMethodBeat.o(97521);
    return "";
  }
  
  public final e dME()
  {
    AppMethodBeat.i(97522);
    if (this.yvC == null) {
      this.yvC = af.dHU().xB(this.field_snsId);
    }
    if (this.yvC != null)
    {
      this.yvC.field_createTime = this.field_createTime;
      this.yvC.field_userName = this.field_userName;
      this.yvC.field_likeFlag = this.field_likeFlag;
      this.yvC.field_attrBuf = this.field_attrBuf;
    }
    e locale = this.yvC;
    AppMethodBeat.o(97522);
    return locale;
  }
  
  public final int dMF()
  {
    AppMethodBeat.i(97524);
    b localb = dFR();
    if (localb != null)
    {
      int i = localb.yfP;
      AppMethodBeat.o(97524);
      return i;
    }
    AppMethodBeat.o(97524);
    return 0;
  }
  
  public final int dMG()
  {
    AppMethodBeat.i(97526);
    if (Pe(32))
    {
      b localb = dFR();
      TimeLineObject localTimeLineObject = dLV();
      if (localb.dJK())
      {
        AppMethodBeat.o(97526);
        return 3;
      }
      if ((localTimeLineObject != null) && (localTimeLineObject.FQo.Ety == 27))
      {
        AppMethodBeat.o(97526);
        return 6;
      }
      if ((localb.dJL()) || (localb.dJM()))
      {
        if ((localTimeLineObject != null) && (localTimeLineObject.FQo.Ety == 15) && (localTimeLineObject.FQv != 1))
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
  
  public final boolean dMH()
  {
    AppMethodBeat.i(97527);
    if ((dLV() != null) && (dLV().FQo.Ety == 27))
    {
      AppMethodBeat.o(97527);
      return true;
    }
    AppMethodBeat.o(97527);
    return false;
  }
  
  public final boolean dMI()
  {
    AppMethodBeat.i(97530);
    if (dFR() != null)
    {
      if (dFR().ygg == 4) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(97530);
        return true;
      }
    }
    AppMethodBeat.o(97530);
    return false;
  }
  
  public final Bundle dMc()
  {
    AppMethodBeat.i(97531);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("values", super.convertTo());
    localBundle.putInt("localid", this.yvp);
    if (dME() != null) {
      localBundle.putBundle("adValues", dME().dMc());
    }
    AppMethodBeat.o(97531);
    return localBundle;
  }
  
  public final bua dMn()
  {
    AppMethodBeat.i(97497);
    bua localbua1;
    if (this.field_postBuf == null)
    {
      localbua1 = new bua();
      AppMethodBeat.o(97497);
      return localbua1;
    }
    if (this.yvB == null) {
      this.yvB = com.tencent.mm.b.g.getMessageDigest(this.field_postBuf);
    }
    if (yvA.containsKey(this.yvB))
    {
      this.yvD = ((bua)yvA.get(this.yvB));
      if (this.yvD != null)
      {
        localbua1 = this.yvD;
        AppMethodBeat.o(97497);
        return localbua1;
      }
    }
    try
    {
      this.yvD = ((bua)new bua().parseFrom(this.field_postBuf));
      yvA.put(this.yvB, this.yvD);
      localbua1 = this.yvD;
      AppMethodBeat.o(97497);
      return localbua1;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.SnsInfo", "error get snsinfo timeline!");
      bua localbua2 = new bua();
      AppMethodBeat.o(97497);
      return localbua2;
    }
  }
  
  public final void dMo()
  {
    this.field_localPrivate |= 0x1;
  }
  
  public final int dMp()
  {
    return this.field_localPrivate;
  }
  
  public final boolean dMq()
  {
    return (this.field_localFlag & 0x80) > 0;
  }
  
  public final void dMr()
  {
    this.field_localFlag |= 0x2;
  }
  
  public final void dMs()
  {
    this.field_localFlag &= 0xFFFFFFFD;
  }
  
  public final boolean dMt()
  {
    return (this.field_localFlag & 0x2) > 0;
  }
  
  public final String dMu()
  {
    AppMethodBeat.i(97504);
    if (Pe(32))
    {
      str = x.bj("ad_table_", this.yvp);
      AppMethodBeat.o(97504);
      return str;
    }
    String str = x.bj("sns_table_", this.yvp);
    AppMethodBeat.o(97504);
    return str;
  }
  
  public final boolean dMv()
  {
    return (this.field_localFlag & 0x10) > 0;
  }
  
  public final boolean dMw()
  {
    return ((this.field_localFlag & 0x20) > 0) && (this.field_snsId == 0L);
  }
  
  public final void dMx()
  {
    this.field_localFlag &= 0xFFFFFFDF;
  }
  
  public final void dMy()
  {
    this.field_localFlag |= 0x20;
  }
  
  public final String dMz()
  {
    AppMethodBeat.i(97517);
    Object localObject = dFQ();
    if (localObject == null)
    {
      AppMethodBeat.o(97517);
      return "";
    }
    localObject = ((a)localObject).yeO;
    AppMethodBeat.o(97517);
    return localObject;
  }
  
  public final void f(TimeLineObject paramTimeLineObject)
  {
    AppMethodBeat.i(97510);
    try
    {
      this.field_content = paramTimeLineObject.toByteArray();
      this.yvo = (com.tencent.mm.b.g.getMessageDigest(this.field_content) + com.tencent.mm.b.g.getMessageDigest(this.field_attrBuf));
      AppMethodBeat.o(97510);
      return;
    }
    catch (Exception paramTimeLineObject)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.SnsInfo", paramTimeLineObject, "", new Object[0]);
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
    if (Pe(32))
    {
      str = x.bj("ad_table_", this.field_snsId);
      AppMethodBeat.o(97501);
      return str;
    }
    String str = x.bj("sns_table_", this.field_snsId);
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
        this.field_head = xH(this.field_createTime);
      }
      AppMethodBeat.o(97503);
      return;
    }
    this.field_createTime = paramInt;
    this.field_head = xH(paramInt);
    AppMethodBeat.o(97503);
  }
  
  public final boolean tY()
  {
    AppMethodBeat.i(210268);
    boolean bool = Pe(32);
    AppMethodBeat.o(210268);
    return bool;
  }
  
  public final void xG(long paramLong)
  {
    AppMethodBeat.i(97500);
    this.field_snsId = paramLong;
    if (paramLong != 0L) {
      xI(paramLong);
    }
    AppMethodBeat.o(97500);
  }
  
  public final void xI(long paramLong)
  {
    AppMethodBeat.i(97506);
    this.field_stringSeq = q.wW(paramLong);
    this.field_stringSeq = q.asY(this.field_stringSeq);
    ac.d("MicroMsg.SnsInfo", paramLong + " stringSeq " + this.field_stringSeq);
    AppMethodBeat.o(97506);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.p
 * JD-Core Version:    0.7.0.1
 */