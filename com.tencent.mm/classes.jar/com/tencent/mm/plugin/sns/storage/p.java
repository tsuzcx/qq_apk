package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.g.c.ga;
import com.tencent.mm.modelsns.h;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.byo;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class p
  extends ga
{
  protected static c.a info;
  protected static Map<String, TimeLineObject> zMM;
  protected static Map<String, byo> zMN;
  private boolean isAd;
  public String zMB;
  public int zMC;
  public String zMO;
  public e zMP;
  private byo zMQ;
  
  static
  {
    AppMethodBeat.i(97532);
    c.a locala = new c.a();
    locala.IhA = new Field[15];
    locala.columns = new String[16];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "snsId";
    locala.IhC.put("snsId", "LONG");
    localStringBuilder.append(" snsId LONG");
    localStringBuilder.append(", ");
    locala.columns[1] = "userName";
    locala.IhC.put("userName", "TEXT");
    localStringBuilder.append(" userName TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "localFlag";
    locala.IhC.put("localFlag", "INTEGER");
    localStringBuilder.append(" localFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "createTime";
    locala.IhC.put("createTime", "INTEGER");
    localStringBuilder.append(" createTime INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "head";
    locala.IhC.put("head", "INTEGER");
    localStringBuilder.append(" head INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "localPrivate";
    locala.IhC.put("localPrivate", "INTEGER");
    localStringBuilder.append(" localPrivate INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "type";
    locala.IhC.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "sourceType";
    locala.IhC.put("sourceType", "INTEGER");
    localStringBuilder.append(" sourceType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[8] = "likeFlag";
    locala.IhC.put("likeFlag", "INTEGER");
    localStringBuilder.append(" likeFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "pravited";
    locala.IhC.put("pravited", "INTEGER");
    localStringBuilder.append(" pravited INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "stringSeq";
    locala.IhC.put("stringSeq", "TEXT");
    localStringBuilder.append(" stringSeq TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "content";
    locala.IhC.put("content", "BLOB");
    localStringBuilder.append(" content BLOB");
    localStringBuilder.append(", ");
    locala.columns[12] = "attrBuf";
    locala.IhC.put("attrBuf", "BLOB");
    localStringBuilder.append(" attrBuf BLOB");
    localStringBuilder.append(", ");
    locala.columns[13] = "postBuf";
    locala.IhC.put("postBuf", "BLOB");
    localStringBuilder.append(" postBuf BLOB");
    localStringBuilder.append(", ");
    locala.columns[14] = "subType";
    locala.IhC.put("subType", "INTEGER");
    localStringBuilder.append(" subType INTEGER");
    locala.columns[15] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    zMM = new ConcurrentHashMap();
    zMN = new ConcurrentHashMap();
    AppMethodBeat.o(97532);
  }
  
  public p()
  {
    this.zMB = null;
    this.zMO = null;
    this.isAd = false;
    this.zMQ = null;
  }
  
  public p(byte paramByte)
  {
    AppMethodBeat.i(97498);
    this.zMB = null;
    this.zMO = null;
    this.isAd = false;
    this.zMQ = null;
    Ae(0L);
    AppMethodBeat.o(97498);
  }
  
  private static int Af(long paramLong)
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
        ad.e("MicroMsg.SnsInfo", "error valueOf  ".concat(String.valueOf(str)));
        int i = (int)(paramLong / 86400L);
      }
    }
  }
  
  public static boolean Ah(long paramLong)
  {
    AppMethodBeat.i(97512);
    if (bt.rM(paramLong / 1000L) > 1200L)
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
    localp.zMC = paramp.zMC;
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
      zMM.clear();
      zMN.clear();
      AppMethodBeat.o(97508);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void Ae(long paramLong)
  {
    AppMethodBeat.i(97500);
    this.field_snsId = paramLong;
    if (paramLong != 0L) {
      Ag(paramLong);
    }
    AppMethodBeat.o(97500);
  }
  
  public final void Ag(long paramLong)
  {
    AppMethodBeat.i(97506);
    this.field_stringSeq = q.zw(paramLong);
    this.field_stringSeq = q.ayd(this.field_stringSeq);
    ad.d("MicroMsg.SnsInfo", paramLong + " stringSeq " + this.field_stringSeq);
    AppMethodBeat.o(97506);
  }
  
  public final void QJ(int paramInt)
  {
    this.field_sourceType |= paramInt;
  }
  
  public final boolean QM(int paramInt)
  {
    return (this.field_sourceType & paramInt) > 0;
  }
  
  public final void QN(int paramInt)
  {
    this.field_sourceType &= (paramInt ^ 0xFFFFFFFF);
  }
  
  public final a QO(int paramInt)
  {
    AppMethodBeat.i(97516);
    if (paramInt == 2)
    {
      locala = dYi();
      AppMethodBeat.o(97516);
      return locala;
    }
    a locala = dRK();
    AppMethodBeat.o(97516);
    return locala;
  }
  
  public final boolean azY(String paramString)
  {
    AppMethodBeat.i(97511);
    paramString = h.Gx(paramString);
    try
    {
      this.field_content = paramString.toByteArray();
      this.zMB = (g.getMessageDigest(this.field_content) + g.getMessageDigest(this.field_attrBuf));
      AppMethodBeat.o(97511);
      return true;
    }
    catch (Exception paramString)
    {
      ad.printErrStackTrace("MicroMsg.SnsInfo", paramString, "", new Object[0]);
      AppMethodBeat.o(97511);
    }
    return false;
  }
  
  public final void bI(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(97505);
    this.field_attrBuf = paramArrayOfByte;
    this.zMB = (g.getMessageDigest(this.field_content) + g.getMessageDigest(this.field_attrBuf));
    AppMethodBeat.o(97505);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(97507);
    super.convertFrom(paramCursor);
    this.zMC = ((int)this.systemRowid);
    AppMethodBeat.o(97507);
  }
  
  public final a dRK()
  {
    AppMethodBeat.i(97514);
    if (this.zMP == null) {
      this.zMP = ag.dUh().zZ(this.field_snsId);
    }
    if (this.zMP == null)
    {
      locala = new a(null);
      AppMethodBeat.o(97514);
      return locala;
    }
    a locala = this.zMP.dRK();
    AppMethodBeat.o(97514);
    return locala;
  }
  
  public final b dRL()
  {
    AppMethodBeat.i(97513);
    if (this.zMP == null) {
      this.zMP = ag.dUh().zZ(this.field_snsId);
    }
    if (this.zMP == null)
    {
      localb = new b(null);
      AppMethodBeat.o(97513);
      return localb;
    }
    b localb = this.zMP.dRL();
    AppMethodBeat.o(97513);
    return localb;
  }
  
  public final boolean dTN()
  {
    return this.field_snsId == 0L;
  }
  
  public final boolean dVZ()
  {
    AppMethodBeat.i(97528);
    if ((dRL() != null) && (dRL().dVZ()))
    {
      AppMethodBeat.o(97528);
      return true;
    }
    AppMethodBeat.o(97528);
    return false;
  }
  
  public final boolean dWa()
  {
    AppMethodBeat.i(97529);
    if ((dRL() != null) && (dRL().dWa()))
    {
      AppMethodBeat.o(97529);
      return true;
    }
    AppMethodBeat.o(97529);
    return false;
  }
  
  public final boolean dWb()
  {
    AppMethodBeat.i(97530);
    if ((dRL() != null) && (dRL().dWb()))
    {
      AppMethodBeat.o(97530);
      return true;
    }
    AppMethodBeat.o(97530);
    return false;
  }
  
  public final boolean dWc()
  {
    AppMethodBeat.i(198125);
    if ((dRL() != null) && (dRL().dWc()))
    {
      AppMethodBeat.o(198125);
      return true;
    }
    AppMethodBeat.o(198125);
    return false;
  }
  
  public final boolean dWk()
  {
    AppMethodBeat.i(97525);
    b localb = dRL();
    if (localb != null)
    {
      boolean bool = localb.dWk();
      AppMethodBeat.o(97525);
      return bool;
    }
    AppMethodBeat.o(97525);
    return false;
  }
  
  public final byo dYD()
  {
    AppMethodBeat.i(97497);
    byo localbyo1;
    if (this.field_postBuf == null)
    {
      localbyo1 = new byo();
      AppMethodBeat.o(97497);
      return localbyo1;
    }
    if (this.zMO == null) {
      this.zMO = g.getMessageDigest(this.field_postBuf);
    }
    if (zMN.containsKey(this.zMO))
    {
      this.zMQ = ((byo)zMN.get(this.zMO));
      if (this.zMQ != null)
      {
        localbyo1 = this.zMQ;
        AppMethodBeat.o(97497);
        return localbyo1;
      }
    }
    try
    {
      this.zMQ = ((byo)new byo().parseFrom(this.field_postBuf));
      zMN.put(this.zMO, this.zMQ);
      localbyo1 = this.zMQ;
      AppMethodBeat.o(97497);
      return localbyo1;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.SnsInfo", "error get snsinfo timeline!");
      byo localbyo2 = new byo();
      AppMethodBeat.o(97497);
      return localbyo2;
    }
  }
  
  public final void dYE()
  {
    this.field_localPrivate |= 0x1;
  }
  
  public final int dYF()
  {
    return this.field_localPrivate;
  }
  
  public final boolean dYG()
  {
    return (this.field_localFlag & 0x80) > 0;
  }
  
  public final void dYH()
  {
    this.field_localFlag |= 0x2;
  }
  
  public final void dYI()
  {
    this.field_localFlag &= 0xFFFFFFFD;
  }
  
  public final boolean dYJ()
  {
    return (this.field_localFlag & 0x2) > 0;
  }
  
  public final String dYK()
  {
    AppMethodBeat.i(97504);
    if (QM(32))
    {
      str = x.bm("ad_table_", this.zMC);
      AppMethodBeat.o(97504);
      return str;
    }
    String str = x.bm("sns_table_", this.zMC);
    AppMethodBeat.o(97504);
    return str;
  }
  
  public final boolean dYL()
  {
    return (this.field_localFlag & 0x10) > 0;
  }
  
  public final boolean dYM()
  {
    return ((this.field_localFlag & 0x20) > 0) && (this.field_snsId == 0L);
  }
  
  public final void dYN()
  {
    this.field_localFlag &= 0xFFFFFFDF;
  }
  
  public final void dYO()
  {
    this.field_localFlag |= 0x20;
  }
  
  public final String dYP()
  {
    AppMethodBeat.i(97517);
    Object localObject = dRK();
    if (localObject == null)
    {
      AppMethodBeat.o(97517);
      return "";
    }
    localObject = ((a)localObject).zuP;
    AppMethodBeat.o(97517);
    return localObject;
  }
  
  public final String dYQ()
  {
    AppMethodBeat.i(97518);
    Object localObject = dRK();
    if (localObject == null)
    {
      AppMethodBeat.o(97518);
      return "";
    }
    localObject = ((a)localObject).zuO;
    AppMethodBeat.o(97518);
    return localObject;
  }
  
  public final String dYR()
  {
    AppMethodBeat.i(97519);
    Object localObject = dRL();
    if (localObject != null)
    {
      localObject = ((b)localObject).zuE;
      AppMethodBeat.o(97519);
      return localObject;
    }
    AppMethodBeat.o(97519);
    return "";
  }
  
  public final String dYS()
  {
    AppMethodBeat.i(97520);
    Object localObject = dRK();
    if (localObject != null)
    {
      localObject = ((a)localObject).zuE;
      AppMethodBeat.o(97520);
      return localObject;
    }
    AppMethodBeat.o(97520);
    return "";
  }
  
  public final String dYT()
  {
    AppMethodBeat.i(97521);
    Object localObject = dRK();
    if (localObject != null)
    {
      localObject = ((a)localObject).dFy;
      AppMethodBeat.o(97521);
      return localObject;
    }
    AppMethodBeat.o(97521);
    return "";
  }
  
  public final e dYU()
  {
    AppMethodBeat.i(97522);
    if (this.zMP == null) {
      this.zMP = ag.dUh().zZ(this.field_snsId);
    }
    if (this.zMP != null)
    {
      this.zMP.field_createTime = this.field_createTime;
      this.zMP.field_userName = this.field_userName;
      this.zMP.field_likeFlag = this.field_likeFlag;
      this.zMP.field_attrBuf = this.field_attrBuf;
    }
    e locale = this.zMP;
    AppMethodBeat.o(97522);
    return locale;
  }
  
  public final int dYV()
  {
    AppMethodBeat.i(97524);
    b localb = dRL();
    if (localb != null)
    {
      int i = localb.zvR;
      AppMethodBeat.o(97524);
      return i;
    }
    AppMethodBeat.o(97524);
    return 0;
  }
  
  public final int dYW()
  {
    AppMethodBeat.i(97526);
    if (QM(32))
    {
      b localb = dRL();
      TimeLineObject localTimeLineObject = dYl();
      if (localb.dVY())
      {
        AppMethodBeat.o(97526);
        return 3;
      }
      if ((localTimeLineObject != null) && (localTimeLineObject.HAT.GaP == 27))
      {
        AppMethodBeat.o(97526);
        return 6;
      }
      if ((localb.dVZ()) || (localb.dWa()))
      {
        if ((localTimeLineObject != null) && (localTimeLineObject.HAT.GaP == 15) && (localTimeLineObject.HBa != 1))
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
  
  public final boolean dYX()
  {
    AppMethodBeat.i(97527);
    if ((dYl() != null) && (dYl().HAT.GaP == 27))
    {
      AppMethodBeat.o(97527);
      return true;
    }
    AppMethodBeat.o(97527);
    return false;
  }
  
  public final a dYi()
  {
    AppMethodBeat.i(97515);
    if (this.zMP == null) {
      this.zMP = ag.dUh().zZ(this.field_snsId);
    }
    if (this.zMP == null)
    {
      locala = new a(null);
      AppMethodBeat.o(97515);
      return locala;
    }
    a locala = this.zMP.dYi();
    AppMethodBeat.o(97515);
    return locala;
  }
  
  public final TimeLineObject dYl()
  {
    AppMethodBeat.i(97509);
    TimeLineObject localTimeLineObject1;
    if (this.field_content == null)
    {
      localTimeLineObject1 = h.aLm();
      AppMethodBeat.o(97509);
      return localTimeLineObject1;
    }
    if (this.zMB == null) {
      this.zMB = (g.getMessageDigest(this.field_content) + g.getMessageDigest(this.field_attrBuf));
    }
    if (zMM.containsKey(this.zMB))
    {
      localTimeLineObject1 = (TimeLineObject)zMM.get(this.zMB);
      if (localTimeLineObject1 != null)
      {
        AppMethodBeat.o(97509);
        return localTimeLineObject1;
      }
    }
    try
    {
      localTimeLineObject1 = (TimeLineObject)new TimeLineObject().parseFrom(this.field_content);
      zMM.put(this.zMB, localTimeLineObject1);
      AppMethodBeat.o(97509);
      return localTimeLineObject1;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.SnsInfo", "error get snsinfo timeline!");
      TimeLineObject localTimeLineObject2 = h.aLm();
      AppMethodBeat.o(97509);
      return localTimeLineObject2;
    }
  }
  
  public final Bundle dYs()
  {
    AppMethodBeat.i(97531);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("values", super.convertTo());
    localBundle.putInt("localid", this.zMC);
    if (dYU() != null) {
      localBundle.putBundle("adValues", dYU().dYs());
    }
    AppMethodBeat.o(97531);
    return localBundle;
  }
  
  public final void f(TimeLineObject paramTimeLineObject)
  {
    AppMethodBeat.i(97510);
    try
    {
      this.field_content = paramTimeLineObject.toByteArray();
      this.zMB = (g.getMessageDigest(this.field_content) + g.getMessageDigest(this.field_attrBuf));
      AppMethodBeat.o(97510);
      return;
    }
    catch (Exception paramTimeLineObject)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.SnsInfo", paramTimeLineObject, "", new Object[0]);
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
    if (QM(32))
    {
      str = x.bm("ad_table_", this.field_snsId);
      AppMethodBeat.o(97501);
      return str;
    }
    String str = x.bm("sns_table_", this.field_snsId);
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
        this.field_head = Af(this.field_createTime);
      }
      AppMethodBeat.o(97503);
      return;
    }
    this.field_createTime = paramInt;
    this.field_head = Af(paramInt);
    AppMethodBeat.o(97503);
  }
  
  public final boolean vx()
  {
    AppMethodBeat.i(221348);
    boolean bool = QM(32);
    AppMethodBeat.o(221348);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.p
 * JD-Core Version:    0.7.0.1
 */