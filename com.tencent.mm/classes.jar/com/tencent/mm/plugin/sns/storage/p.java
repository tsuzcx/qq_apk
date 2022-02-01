package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fm;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bpj;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class p
  extends fm
{
  protected static c.a info;
  protected static Map<String, TimeLineObject> xiI;
  protected static Map<String, bpj> xiJ;
  private boolean isAd;
  public String xiA;
  public int xiB;
  public String xiK;
  public e xiL;
  private bpj xiM;
  
  static
  {
    AppMethodBeat.i(97532);
    c.a locala = new c.a();
    locala.EYt = new Field[15];
    locala.columns = new String[16];
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
    locala.columns[14] = "subType";
    locala.EYv.put("subType", "INTEGER");
    localStringBuilder.append(" subType INTEGER");
    locala.columns[15] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    xiI = new ConcurrentHashMap();
    xiJ = new ConcurrentHashMap();
    AppMethodBeat.o(97532);
  }
  
  public p()
  {
    this.xiA = null;
    this.xiK = null;
    this.isAd = false;
    this.xiM = null;
  }
  
  public p(byte paramByte)
  {
    AppMethodBeat.i(97498);
    this.xiA = null;
    this.xiK = null;
    this.isAd = false;
    this.xiM = null;
    td(0L);
    AppMethodBeat.o(97498);
  }
  
  public static p H(p paramp)
  {
    AppMethodBeat.i(97499);
    p localp = new p();
    localp.xiB = paramp.xiB;
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
      xiI.clear();
      xiJ.clear();
      AppMethodBeat.o(97508);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private static int te(long paramLong)
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
  
  public static boolean tg(long paramLong)
  {
    AppMethodBeat.i(97512);
    if (bt.lZ(paramLong / 1000L) > 1200L)
    {
      AppMethodBeat.o(97512);
      return true;
    }
    AppMethodBeat.o(97512);
    return false;
  }
  
  public final void MY(int paramInt)
  {
    this.field_sourceType |= paramInt;
  }
  
  public final boolean Nb(int paramInt)
  {
    return (this.field_sourceType & paramInt) > 0;
  }
  
  public final void Nc(int paramInt)
  {
    this.field_sourceType &= (paramInt ^ 0xFFFFFFFF);
  }
  
  public final a Nd(int paramInt)
  {
    AppMethodBeat.i(97516);
    if (paramInt == 2)
    {
      locala = dxv();
      AppMethodBeat.o(97516);
      return locala;
    }
    a locala = dxu();
    AppMethodBeat.o(97516);
    return locala;
  }
  
  public final boolean apI(String paramString)
  {
    AppMethodBeat.i(97511);
    paramString = com.tencent.mm.modelsns.g.zn(paramString);
    try
    {
      this.field_content = paramString.toByteArray();
      this.xiA = (com.tencent.mm.b.g.getMessageDigest(this.field_content) + com.tencent.mm.b.g.getMessageDigest(this.field_attrBuf));
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
  
  public final void bC(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(97505);
    this.field_attrBuf = paramArrayOfByte;
    this.xiA = (com.tencent.mm.b.g.getMessageDigest(this.field_content) + com.tencent.mm.b.g.getMessageDigest(this.field_attrBuf));
    AppMethodBeat.o(97505);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(97507);
    super.convertFrom(paramCursor);
    this.xiB = ((int)this.systemRowid);
    AppMethodBeat.o(97507);
  }
  
  public final boolean dtd()
  {
    return this.field_snsId == 0L;
  }
  
  public final boolean dvm()
  {
    AppMethodBeat.i(97528);
    if ((dxs() != null) && (dxs().dvm()))
    {
      AppMethodBeat.o(97528);
      return true;
    }
    AppMethodBeat.o(97528);
    return false;
  }
  
  public final boolean dvn()
  {
    AppMethodBeat.i(97529);
    if ((dxs() != null) && (dxs().dvn()))
    {
      AppMethodBeat.o(97529);
      return true;
    }
    AppMethodBeat.o(97529);
    return false;
  }
  
  public final boolean dvv()
  {
    AppMethodBeat.i(97525);
    b localb = dxs();
    if (localb != null)
    {
      boolean bool = localb.dvv();
      AppMethodBeat.o(97525);
      return bool;
    }
    AppMethodBeat.o(97525);
    return false;
  }
  
  public final Bundle dxF()
  {
    AppMethodBeat.i(97531);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("values", super.convertTo());
    localBundle.putInt("localid", this.xiB);
    if (dyh() != null) {
      localBundle.putBundle("adValues", dyh().dxF());
    }
    AppMethodBeat.o(97531);
    return localBundle;
  }
  
  public final bpj dxQ()
  {
    AppMethodBeat.i(97497);
    bpj localbpj1;
    if (this.field_postBuf == null)
    {
      localbpj1 = new bpj();
      AppMethodBeat.o(97497);
      return localbpj1;
    }
    if (this.xiK == null) {
      this.xiK = com.tencent.mm.b.g.getMessageDigest(this.field_postBuf);
    }
    if (xiJ.containsKey(this.xiK))
    {
      this.xiM = ((bpj)xiJ.get(this.xiK));
      if (this.xiM != null)
      {
        localbpj1 = this.xiM;
        AppMethodBeat.o(97497);
        return localbpj1;
      }
    }
    try
    {
      this.xiM = ((bpj)new bpj().parseFrom(this.field_postBuf));
      xiJ.put(this.xiK, this.xiM);
      localbpj1 = this.xiM;
      AppMethodBeat.o(97497);
      return localbpj1;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.SnsInfo", "error get snsinfo timeline!");
      bpj localbpj2 = new bpj();
      AppMethodBeat.o(97497);
      return localbpj2;
    }
  }
  
  public final void dxR()
  {
    this.field_localPrivate |= 0x1;
  }
  
  public final int dxS()
  {
    return this.field_localPrivate;
  }
  
  public final boolean dxT()
  {
    return (this.field_localFlag & 0x80) > 0;
  }
  
  public final void dxU()
  {
    this.field_localFlag |= 0x2;
  }
  
  public final void dxV()
  {
    this.field_localFlag &= 0xFFFFFFFD;
  }
  
  public final boolean dxW()
  {
    return (this.field_localFlag & 0x2) > 0;
  }
  
  public final String dxX()
  {
    AppMethodBeat.i(97504);
    if (Nb(32))
    {
      str = x.bh("ad_table_", this.xiB);
      AppMethodBeat.o(97504);
      return str;
    }
    String str = x.bh("sns_table_", this.xiB);
    AppMethodBeat.o(97504);
    return str;
  }
  
  public final boolean dxY()
  {
    return (this.field_localFlag & 0x10) > 0;
  }
  
  public final boolean dxZ()
  {
    return ((this.field_localFlag & 0x20) > 0) && (this.field_snsId == 0L);
  }
  
  public final b dxs()
  {
    AppMethodBeat.i(97513);
    if (this.xiL == null) {
      this.xiL = af.dtx().sY(this.field_snsId);
    }
    if (this.xiL == null)
    {
      localb = new b(null);
      AppMethodBeat.o(97513);
      return localb;
    }
    b localb = this.xiL.dxs();
    AppMethodBeat.o(97513);
    return localb;
  }
  
  public final a dxu()
  {
    AppMethodBeat.i(97514);
    if (this.xiL == null) {
      this.xiL = af.dtx().sY(this.field_snsId);
    }
    if (this.xiL == null)
    {
      locala = new a(null);
      AppMethodBeat.o(97514);
      return locala;
    }
    a locala = this.xiL.dxu();
    AppMethodBeat.o(97514);
    return locala;
  }
  
  public final a dxv()
  {
    AppMethodBeat.i(97515);
    if (this.xiL == null) {
      this.xiL = af.dtx().sY(this.field_snsId);
    }
    if (this.xiL == null)
    {
      locala = new a(null);
      AppMethodBeat.o(97515);
      return locala;
    }
    a locala = this.xiL.dxv();
    AppMethodBeat.o(97515);
    return locala;
  }
  
  public final TimeLineObject dxy()
  {
    AppMethodBeat.i(97509);
    TimeLineObject localTimeLineObject1;
    if (this.field_content == null)
    {
      localTimeLineObject1 = com.tencent.mm.modelsns.g.aBl();
      AppMethodBeat.o(97509);
      return localTimeLineObject1;
    }
    if (this.xiA == null) {
      this.xiA = (com.tencent.mm.b.g.getMessageDigest(this.field_content) + com.tencent.mm.b.g.getMessageDigest(this.field_attrBuf));
    }
    if (xiI.containsKey(this.xiA))
    {
      localTimeLineObject1 = (TimeLineObject)xiI.get(this.xiA);
      if (localTimeLineObject1 != null)
      {
        AppMethodBeat.o(97509);
        return localTimeLineObject1;
      }
    }
    try
    {
      localTimeLineObject1 = (TimeLineObject)new TimeLineObject().parseFrom(this.field_content);
      xiI.put(this.xiA, localTimeLineObject1);
      AppMethodBeat.o(97509);
      return localTimeLineObject1;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.SnsInfo", "error get snsinfo timeline!");
      TimeLineObject localTimeLineObject2 = com.tencent.mm.modelsns.g.aBl();
      AppMethodBeat.o(97509);
      return localTimeLineObject2;
    }
  }
  
  public final void dya()
  {
    this.field_localFlag &= 0xFFFFFFDF;
  }
  
  public final void dyb()
  {
    this.field_localFlag |= 0x20;
  }
  
  public final String dyc()
  {
    AppMethodBeat.i(97517);
    Object localObject = dxu();
    if (localObject == null)
    {
      AppMethodBeat.o(97517);
      return "";
    }
    localObject = ((a)localObject).wSi;
    AppMethodBeat.o(97517);
    return localObject;
  }
  
  public final String dyd()
  {
    AppMethodBeat.i(97518);
    Object localObject = dxu();
    if (localObject == null)
    {
      AppMethodBeat.o(97518);
      return "";
    }
    localObject = ((a)localObject).wSh;
    AppMethodBeat.o(97518);
    return localObject;
  }
  
  public final String dye()
  {
    AppMethodBeat.i(97519);
    Object localObject = dxs();
    if (localObject != null)
    {
      localObject = ((b)localObject).wRX;
      AppMethodBeat.o(97519);
      return localObject;
    }
    AppMethodBeat.o(97519);
    return "";
  }
  
  public final String dyf()
  {
    AppMethodBeat.i(97520);
    Object localObject = dxu();
    if (localObject != null)
    {
      localObject = ((a)localObject).wRX;
      AppMethodBeat.o(97520);
      return localObject;
    }
    AppMethodBeat.o(97520);
    return "";
  }
  
  public final String dyg()
  {
    AppMethodBeat.i(97521);
    Object localObject = dxu();
    if (localObject != null)
    {
      localObject = ((a)localObject).dvK;
      AppMethodBeat.o(97521);
      return localObject;
    }
    AppMethodBeat.o(97521);
    return "";
  }
  
  public final e dyh()
  {
    AppMethodBeat.i(97522);
    if (this.xiL == null) {
      this.xiL = af.dtx().sY(this.field_snsId);
    }
    if (this.xiL != null)
    {
      this.xiL.field_createTime = this.field_createTime;
      this.xiL.field_userName = this.field_userName;
      this.xiL.field_likeFlag = this.field_likeFlag;
      this.xiL.field_attrBuf = this.field_attrBuf;
    }
    e locale = this.xiL;
    AppMethodBeat.o(97522);
    return locale;
  }
  
  public final int dyi()
  {
    AppMethodBeat.i(97524);
    b localb = dxs();
    if (localb != null)
    {
      int i = localb.wTf;
      AppMethodBeat.o(97524);
      return i;
    }
    AppMethodBeat.o(97524);
    return 0;
  }
  
  public final int dyj()
  {
    AppMethodBeat.i(97526);
    if (Nb(32))
    {
      b localb = dxs();
      TimeLineObject localTimeLineObject = dxy();
      if (localb.dvl())
      {
        AppMethodBeat.o(97526);
        return 3;
      }
      if ((localTimeLineObject != null) && (localTimeLineObject.Etm.DaB == 27))
      {
        AppMethodBeat.o(97526);
        return 6;
      }
      if ((localb.dvm()) || (localb.dvn()))
      {
        if ((localTimeLineObject != null) && (localTimeLineObject.Etm.DaB == 15) && (localTimeLineObject.Ett != 1))
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
  
  public final boolean dyk()
  {
    AppMethodBeat.i(97527);
    if ((dxy() != null) && (dxy().Etm.DaB == 27))
    {
      AppMethodBeat.o(97527);
      return true;
    }
    AppMethodBeat.o(97527);
    return false;
  }
  
  public final boolean dyl()
  {
    AppMethodBeat.i(97530);
    if (dxs() != null)
    {
      if (dxs().wTw == 4) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(97530);
        return true;
      }
    }
    AppMethodBeat.o(97530);
    return false;
  }
  
  public final void g(TimeLineObject paramTimeLineObject)
  {
    AppMethodBeat.i(97510);
    try
    {
      this.field_content = paramTimeLineObject.toByteArray();
      this.xiA = (com.tencent.mm.b.g.getMessageDigest(this.field_content) + com.tencent.mm.b.g.getMessageDigest(this.field_attrBuf));
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
    if (Nb(32))
    {
      str = x.bh("ad_table_", this.field_snsId);
      AppMethodBeat.o(97501);
      return str;
    }
    String str = x.bh("sns_table_", this.field_snsId);
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
        this.field_head = te(this.field_createTime);
      }
      AppMethodBeat.o(97503);
      return;
    }
    this.field_createTime = paramInt;
    this.field_head = te(paramInt);
    AppMethodBeat.o(97503);
  }
  
  public final boolean tQ()
  {
    AppMethodBeat.i(201280);
    boolean bool = Nb(32);
    AppMethodBeat.o(201280);
    return bool;
  }
  
  public final void td(long paramLong)
  {
    AppMethodBeat.i(97500);
    this.field_snsId = paramLong;
    if (paramLong != 0L) {
      tf(paramLong);
    }
    AppMethodBeat.o(97500);
  }
  
  public final void tf(long paramLong)
  {
    AppMethodBeat.i(97506);
    this.field_stringSeq = q.st(paramLong);
    this.field_stringSeq = q.anM(this.field_stringSeq);
    ad.d("MicroMsg.SnsInfo", paramLong + " stringSeq " + this.field_stringSeq);
    AppMethodBeat.o(97506);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.p
 * JD-Core Version:    0.7.0.1
 */