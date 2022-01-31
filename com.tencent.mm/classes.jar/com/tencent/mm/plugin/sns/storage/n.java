package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.g.c.eq;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bct;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class n
  extends eq
{
  protected static c.a info;
  protected static Map<String, TimeLineObject> rDc;
  protected static Map<String, bct> rDd;
  public String rCU;
  public int rCV;
  public String rDe;
  public e rDf;
  private bct rDg;
  private boolean raZ;
  
  static
  {
    AppMethodBeat.i(37915);
    c.a locala = new c.a();
    locala.yrK = new Field[15];
    locala.columns = new String[16];
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
    locala.columns[14] = "subType";
    locala.yrM.put("subType", "INTEGER");
    localStringBuilder.append(" subType INTEGER");
    locala.columns[15] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    rDc = new ConcurrentHashMap();
    rDd = new ConcurrentHashMap();
    AppMethodBeat.o(37915);
  }
  
  public n()
  {
    this.rCU = null;
    this.rDe = null;
    this.raZ = false;
    this.rDg = null;
  }
  
  public n(byte paramByte)
  {
    AppMethodBeat.i(37883);
    this.rCU = null;
    this.rDe = null;
    this.raZ = false;
    this.rDg = null;
    lV(0L);
    AppMethodBeat.o(37883);
  }
  
  private static int lW(long paramLong)
  {
    AppMethodBeat.i(37887);
    String str = new SimpleDateFormat("yyyyMMdd").format(new Date(1000L * paramLong));
    try
    {
      i = Integer.valueOf(str).intValue();
      AppMethodBeat.o(37887);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.SnsInfo", "error valueOf  ".concat(String.valueOf(str)));
        int i = (int)(paramLong / 86400L);
      }
    }
  }
  
  public static boolean lY(long paramLong)
  {
    AppMethodBeat.i(37897);
    if (bo.gz(paramLong / 1000L) > 1200L)
    {
      AppMethodBeat.o(37897);
      return true;
    }
    AppMethodBeat.o(37897);
    return false;
  }
  
  public static void release()
  {
    try
    {
      AppMethodBeat.i(37893);
      rDc.clear();
      rDd.clear();
      AppMethodBeat.o(37893);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static n z(n paramn)
  {
    AppMethodBeat.i(37884);
    n localn = new n();
    localn.rCV = paramn.rCV;
    localn.field_snsId = paramn.field_snsId;
    localn.field_userName = paramn.field_userName;
    localn.field_localFlag = paramn.field_localFlag;
    localn.field_createTime = paramn.field_createTime;
    localn.field_head = paramn.field_head;
    localn.field_localPrivate = paramn.field_localPrivate;
    localn.field_type = paramn.field_type;
    localn.field_sourceType = paramn.field_sourceType;
    localn.field_likeFlag = paramn.field_likeFlag;
    localn.field_pravited = paramn.field_pravited;
    localn.field_stringSeq = paramn.field_stringSeq;
    localn.field_content = paramn.field_content;
    localn.field_attrBuf = paramn.field_attrBuf;
    AppMethodBeat.o(37884);
    return localn;
  }
  
  public final void Eu(int paramInt)
  {
    this.field_sourceType |= paramInt;
  }
  
  public final boolean Ex(int paramInt)
  {
    return (this.field_sourceType & paramInt) > 0;
  }
  
  public final void Ey(int paramInt)
  {
    this.field_sourceType &= (paramInt ^ 0xFFFFFFFF);
  }
  
  public final boolean abt(String paramString)
  {
    AppMethodBeat.i(37896);
    paramString = com.tencent.mm.modelsns.e.uA(paramString);
    try
    {
      this.field_content = paramString.toByteArray();
      this.rCU = (g.w(this.field_content) + g.w(this.field_attrBuf));
      AppMethodBeat.o(37896);
      return true;
    }
    catch (Exception paramString)
    {
      ab.printErrStackTrace("MicroMsg.SnsInfo", paramString, "", new Object[0]);
      AppMethodBeat.o(37896);
    }
    return false;
  }
  
  public final void bj(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(37890);
    this.field_attrBuf = paramArrayOfByte;
    this.rCU = (g.w(this.field_content) + g.w(this.field_attrBuf));
    AppMethodBeat.o(37890);
  }
  
  public final void c(TimeLineObject paramTimeLineObject)
  {
    AppMethodBeat.i(37895);
    try
    {
      this.field_content = paramTimeLineObject.toByteArray();
      this.rCU = (g.w(this.field_content) + g.w(this.field_attrBuf));
      AppMethodBeat.o(37895);
      return;
    }
    catch (Exception paramTimeLineObject)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.SnsInfo", paramTimeLineObject, "", new Object[0]);
      }
    }
  }
  
  public final boolean coN()
  {
    return this.field_snsId == 0L;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(37892);
    super.convertFrom(paramCursor);
    this.rCV = ((int)this.systemRowid);
    AppMethodBeat.o(37892);
  }
  
  public final boolean cqp()
  {
    AppMethodBeat.i(37912);
    if ((csb() != null) && (csb().cqp()))
    {
      AppMethodBeat.o(37912);
      return true;
    }
    AppMethodBeat.o(37912);
    return false;
  }
  
  public final boolean cqq()
  {
    AppMethodBeat.i(37913);
    if ((csb() != null) && (csb().cqq()))
    {
      AppMethodBeat.o(37913);
      return true;
    }
    AppMethodBeat.o(37913);
    return false;
  }
  
  public final boolean cqx()
  {
    AppMethodBeat.i(37909);
    b localb = csb();
    if (localb != null)
    {
      boolean bool = localb.cqx();
      AppMethodBeat.o(37909);
      return bool;
    }
    AppMethodBeat.o(37909);
    return false;
  }
  
  public final int csA()
  {
    return this.field_createTime;
  }
  
  public final void csB()
  {
    this.field_localPrivate |= 0x1;
  }
  
  public final int csC()
  {
    return this.field_localPrivate;
  }
  
  public final boolean csD()
  {
    return (this.field_localFlag & 0x80) > 0;
  }
  
  public final void csE()
  {
    this.field_localFlag |= 0x2;
  }
  
  public final void csF()
  {
    this.field_localFlag &= 0xFFFFFFFD;
  }
  
  public final boolean csG()
  {
    return (this.field_localFlag & 0x2) > 0;
  }
  
  public final String csH()
  {
    AppMethodBeat.i(37889);
    if (Ex(32))
    {
      str = v.aE("ad_table_", this.rCV);
      AppMethodBeat.o(37889);
      return str;
    }
    String str = v.aE("sns_table_", this.rCV);
    AppMethodBeat.o(37889);
    return str;
  }
  
  public final boolean csI()
  {
    return (this.field_localFlag & 0x10) > 0;
  }
  
  public final boolean csJ()
  {
    return ((this.field_localFlag & 0x20) > 0) && (this.field_snsId == 0L);
  }
  
  public final void csK()
  {
    this.field_localFlag &= 0xFFFFFFDF;
  }
  
  public final void csL()
  {
    this.field_localFlag |= 0x20;
  }
  
  public final String csM()
  {
    AppMethodBeat.i(37901);
    Object localObject = csd();
    if (localObject == null)
    {
      AppMethodBeat.o(37901);
      return "";
    }
    localObject = ((a)localObject).rpv;
    AppMethodBeat.o(37901);
    return localObject;
  }
  
  public final String csN()
  {
    AppMethodBeat.i(37902);
    Object localObject = csd();
    if (localObject == null)
    {
      AppMethodBeat.o(37902);
      return "";
    }
    localObject = ((a)localObject).rpu;
    AppMethodBeat.o(37902);
    return localObject;
  }
  
  public final String csO()
  {
    AppMethodBeat.i(37904);
    Object localObject = csd();
    if (localObject != null)
    {
      localObject = ((a)localObject).rpk;
      AppMethodBeat.o(37904);
      return localObject;
    }
    AppMethodBeat.o(37904);
    return "";
  }
  
  public final String csP()
  {
    AppMethodBeat.i(37905);
    Object localObject = csd();
    if (localObject != null)
    {
      localObject = ((a)localObject).cFe;
      AppMethodBeat.o(37905);
      return localObject;
    }
    AppMethodBeat.o(37905);
    return "";
  }
  
  public final e csQ()
  {
    AppMethodBeat.i(37906);
    if (this.rDf == null) {
      this.rDf = ag.cpi().lQ(this.field_snsId);
    }
    if (this.rDf != null)
    {
      this.rDf.field_createTime = this.field_createTime;
      this.rDf.field_userName = this.field_userName;
      this.rDf.field_likeFlag = this.field_likeFlag;
      this.rDf.field_attrBuf = this.field_attrBuf;
    }
    e locale = this.rDf;
    AppMethodBeat.o(37906);
    return locale;
  }
  
  public final int csR()
  {
    AppMethodBeat.i(37908);
    b localb = csb();
    if (localb != null)
    {
      int i = localb.rqk;
      AppMethodBeat.o(37908);
      return i;
    }
    AppMethodBeat.o(37908);
    return 0;
  }
  
  public final int csS()
  {
    AppMethodBeat.i(37910);
    if (Ex(32))
    {
      b localb = csb();
      TimeLineObject localTimeLineObject = csh();
      if (localb.cqo())
      {
        AppMethodBeat.o(37910);
        return 3;
      }
      if ((localTimeLineObject != null) && (localTimeLineObject.xTS.wNZ == 27))
      {
        AppMethodBeat.o(37910);
        return 6;
      }
      if ((localb.cqp()) || (localb.cqq()))
      {
        if ((localTimeLineObject != null) && (localTimeLineObject.xTS.wNZ == 15) && (localTimeLineObject.xTZ != 1))
        {
          AppMethodBeat.o(37910);
          return 5;
        }
        AppMethodBeat.o(37910);
        return 4;
      }
      if (this.field_type == 1)
      {
        AppMethodBeat.o(37910);
        return 1;
      }
      AppMethodBeat.o(37910);
      return 2;
    }
    AppMethodBeat.o(37910);
    return -1;
  }
  
  public final boolean csT()
  {
    AppMethodBeat.i(37911);
    if ((csh() != null) && (csh().xTS.wNZ == 27))
    {
      AppMethodBeat.o(37911);
      return true;
    }
    AppMethodBeat.o(37911);
    return false;
  }
  
  public final boolean csU()
  {
    AppMethodBeat.i(145445);
    if (csb() != null)
    {
      if (csb().rqB == 4) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(145445);
        return true;
      }
    }
    AppMethodBeat.o(145445);
    return false;
  }
  
  public final b csb()
  {
    AppMethodBeat.i(37898);
    if (this.rDf == null) {
      this.rDf = ag.cpi().lQ(this.field_snsId);
    }
    if (this.rDf == null)
    {
      localb = new b(null);
      AppMethodBeat.o(37898);
      return localb;
    }
    b localb = this.rDf.csb();
    AppMethodBeat.o(37898);
    return localb;
  }
  
  public final a csd()
  {
    AppMethodBeat.i(37899);
    if (this.rDf == null) {
      this.rDf = ag.cpi().lQ(this.field_snsId);
    }
    if (this.rDf == null)
    {
      locala = new a(null);
      AppMethodBeat.o(37899);
      return locala;
    }
    a locala = this.rDf.csd();
    AppMethodBeat.o(37899);
    return locala;
  }
  
  public final a cse()
  {
    AppMethodBeat.i(37900);
    if (this.rDf == null) {
      this.rDf = ag.cpi().lQ(this.field_snsId);
    }
    if (this.rDf == null)
    {
      locala = new a(null);
      AppMethodBeat.o(37900);
      return locala;
    }
    a locala = this.rDf.cse();
    AppMethodBeat.o(37900);
    return locala;
  }
  
  public final TimeLineObject csh()
  {
    AppMethodBeat.i(37894);
    TimeLineObject localTimeLineObject1;
    if (this.field_content == null)
    {
      localTimeLineObject1 = com.tencent.mm.modelsns.e.akg();
      AppMethodBeat.o(37894);
      return localTimeLineObject1;
    }
    if (this.rCU == null) {
      this.rCU = (g.w(this.field_content) + g.w(this.field_attrBuf));
    }
    if (rDc.containsKey(this.rCU))
    {
      localTimeLineObject1 = (TimeLineObject)rDc.get(this.rCU);
      if (localTimeLineObject1 != null)
      {
        AppMethodBeat.o(37894);
        return localTimeLineObject1;
      }
    }
    try
    {
      localTimeLineObject1 = (TimeLineObject)new TimeLineObject().parseFrom(this.field_content);
      rDc.put(this.rCU, localTimeLineObject1);
      AppMethodBeat.o(37894);
      return localTimeLineObject1;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.SnsInfo", "error get snsinfo timeline!");
      TimeLineObject localTimeLineObject2 = com.tencent.mm.modelsns.e.akg();
      AppMethodBeat.o(37894);
      return localTimeLineObject2;
    }
  }
  
  public final Bundle cso()
  {
    AppMethodBeat.i(37914);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("values", super.convertTo());
    localBundle.putInt("localid", this.rCV);
    if (csQ() != null) {
      localBundle.putBundle("adValues", csQ().cso());
    }
    AppMethodBeat.o(37914);
    return localBundle;
  }
  
  public final bct csz()
  {
    AppMethodBeat.i(37882);
    bct localbct1;
    if (this.field_postBuf == null)
    {
      localbct1 = new bct();
      AppMethodBeat.o(37882);
      return localbct1;
    }
    if (this.rDe == null) {
      this.rDe = g.w(this.field_postBuf);
    }
    if (rDd.containsKey(this.rDe))
    {
      this.rDg = ((bct)rDd.get(this.rDe));
      if (this.rDg != null)
      {
        localbct1 = this.rDg;
        AppMethodBeat.o(37882);
        return localbct1;
      }
    }
    try
    {
      this.rDg = ((bct)new bct().parseFrom(this.field_postBuf));
      rDd.put(this.rDe, this.rDg);
      localbct1 = this.rDg;
      AppMethodBeat.o(37882);
      return localbct1;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.SnsInfo", "error get snsinfo timeline!");
      bct localbct2 = new bct();
      AppMethodBeat.o(37882);
      return localbct2;
    }
  }
  
  public final String getAdLink()
  {
    AppMethodBeat.i(37903);
    Object localObject = csb();
    if (localObject != null)
    {
      localObject = ((b)localObject).rpk;
      AppMethodBeat.o(37903);
      return localObject;
    }
    AppMethodBeat.o(37903);
    return "";
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
  
  public final String getSnsId()
  {
    AppMethodBeat.i(37886);
    if (Ex(32))
    {
      str = v.aE("ad_table_", this.field_snsId);
      AppMethodBeat.o(37886);
      return str;
    }
    String str = v.aE("sns_table_", this.field_snsId);
    AppMethodBeat.o(37886);
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
  
  public final void lV(long paramLong)
  {
    AppMethodBeat.i(37885);
    this.field_snsId = paramLong;
    if (paramLong != 0L) {
      lX(paramLong);
    }
    AppMethodBeat.o(37885);
  }
  
  public final void lX(long paramLong)
  {
    AppMethodBeat.i(37891);
    this.field_stringSeq = i.lq(paramLong);
    this.field_stringSeq = i.ZI(this.field_stringSeq);
    ab.d("MicroMsg.SnsInfo", paramLong + " stringSeq " + this.field_stringSeq);
    AppMethodBeat.o(37891);
  }
  
  public final void lp(int paramInt)
  {
    AppMethodBeat.i(37888);
    if ((paramInt - this.field_createTime < 180) && (paramInt - this.field_createTime >= 0))
    {
      if (this.field_head == 0) {
        this.field_head = lW(this.field_createTime);
      }
      AppMethodBeat.o(37888);
      return;
    }
    this.field_createTime = paramInt;
    this.field_head = lW(paramInt);
    AppMethodBeat.o(37888);
  }
  
  public final boolean pi()
  {
    AppMethodBeat.i(156757);
    boolean bool = Ex(32);
    AppMethodBeat.o(156757);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.n
 * JD-Core Version:    0.7.0.1
 */