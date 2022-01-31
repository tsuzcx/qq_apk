package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import android.os.Bundle;
import com.tencent.mm.a.g;
import com.tencent.mm.h.c.ee;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.protocal.c.awe;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class n
  extends ee
{
  protected static c.a buS;
  protected static Map<String, bxk> oLr = new ConcurrentHashMap();
  protected static Map<String, awe> oLs = new ConcurrentHashMap();
  public String oLj = null;
  public int oLk;
  public String oLt = null;
  public e oLu;
  private awe oLv = null;
  private boolean omL = false;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[15];
    locala.columns = new String[16];
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
    locala.columns[14] = "subType";
    locala.ujN.put("subType", "INTEGER");
    localStringBuilder.append(" subType INTEGER");
    locala.columns[15] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  public n() {}
  
  public n(byte paramByte)
  {
    gp(0L);
  }
  
  public static n A(n paramn)
  {
    n localn = new n();
    localn.oLk = paramn.oLk;
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
    return localn;
  }
  
  private static int gq(long paramLong)
  {
    String str = new SimpleDateFormat("yyyyMMdd").format(new Date(1000L * paramLong));
    try
    {
      int i = Integer.valueOf(str).intValue();
      return i;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.SnsInfo", "error valueOf  " + str);
    }
    return (int)(paramLong / 86400L);
  }
  
  public static boolean gs(long paramLong)
  {
    return bk.cn(paramLong / 1000L) > 1200L;
  }
  
  public static void release()
  {
    try
    {
      oLr.clear();
      oLs.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
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
      y.printErrStackTrace("MicroMsg.SnsInfo", paramString, "", new Object[0]);
    }
    return false;
  }
  
  public final void aL(byte[] paramArrayOfByte)
  {
    this.field_attrBuf = paramArrayOfByte;
    this.oLj = (g.o(this.field_content) + g.o(this.field_attrBuf));
  }
  
  public final boolean bDo()
  {
    return this.field_snsId == 0L;
  }
  
  public final boolean bEJ()
  {
    return (bFZ() != null) && (bFZ().bEJ());
  }
  
  public final boolean bEK()
  {
    return (bFZ() != null) && (bFZ().bEK());
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
    if (this.oLu == null) {
      this.oLu = af.bDI().gk(this.field_snsId);
    }
    if (this.oLu == null) {
      return new b(null);
    }
    return this.oLu.bFZ();
  }
  
  public final boolean bGA()
  {
    return (this.field_localFlag & 0x80) > 0;
  }
  
  public final void bGB()
  {
    this.field_localFlag |= 0x2;
  }
  
  public final void bGC()
  {
    this.field_localFlag &= 0xFFFFFFFD;
  }
  
  public final boolean bGD()
  {
    return (this.field_localFlag & 0x2) > 0;
  }
  
  public final String bGE()
  {
    if (yr(32)) {
      return v.ak("ad_table_", this.oLk);
    }
    return v.ak("sns_table_", this.oLk);
  }
  
  public final boolean bGF()
  {
    return (this.field_localFlag & 0x10) > 0;
  }
  
  public final boolean bGG()
  {
    return ((this.field_localFlag & 0x20) > 0) && (this.field_snsId == 0L);
  }
  
  public final void bGH()
  {
    this.field_localFlag &= 0xFFFFFFDF;
  }
  
  public final void bGI()
  {
    this.field_localFlag |= 0x20;
  }
  
  public final String bGJ()
  {
    a locala = bGb();
    if (locala == null) {
      return "";
    }
    return locala.oAl;
  }
  
  public final String bGK()
  {
    a locala = bGb();
    if (locala == null) {
      return "";
    }
    return locala.oAk;
  }
  
  public final String bGL()
  {
    a locala = bGb();
    if (locala != null) {
      return locala.oAa;
    }
    return "";
  }
  
  public final String bGM()
  {
    a locala = bGb();
    if (locala != null) {
      return locala.ovV;
    }
    return "";
  }
  
  public final e bGN()
  {
    if (this.oLu == null) {
      this.oLu = af.bDI().gk(this.field_snsId);
    }
    if (this.oLu != null)
    {
      this.oLu.field_createTime = this.field_createTime;
      this.oLu.field_userName = this.field_userName;
      this.oLu.field_likeFlag = this.field_likeFlag;
      this.oLu.field_attrBuf = this.field_attrBuf;
    }
    return this.oLu;
  }
  
  public final int bGO()
  {
    b localb = bFZ();
    if (localb != null) {
      return localb.oBa;
    }
    return 0;
  }
  
  public final int bGP()
  {
    int i = 1;
    if (yr(32))
    {
      b localb = bFZ();
      bxk localbxk = bGe();
      if (localb.bEI()) {
        i = 3;
      }
      do
      {
        return i;
        if ((localbxk != null) && (localbxk.tNr.sPI == 27)) {
          return 6;
        }
        if ((localb.bEJ()) || (localb.bEK()))
        {
          if ((localbxk != null) && (localbxk.tNr.sPI == 15) && (localbxk.tNy != 1)) {
            return 5;
          }
          return 4;
        }
      } while (this.field_type == 1);
      return 2;
    }
    return -1;
  }
  
  public final boolean bGQ()
  {
    return (bGe() != null) && (bGe().tNr.sPI == 27);
  }
  
  public final a bGb()
  {
    if (this.oLu == null) {
      this.oLu = af.bDI().gk(this.field_snsId);
    }
    if (this.oLu == null) {
      return new a(null);
    }
    return this.oLu.bGb();
  }
  
  public final a bGc()
  {
    if (this.oLu == null) {
      this.oLu = af.bDI().gk(this.field_snsId);
    }
    if (this.oLu == null) {
      return new a(null);
    }
    return this.oLu.bGc();
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
      if (!oLr.containsKey(this.oLj)) {
        break;
      }
      localbxk = (bxk)oLr.get(this.oLj);
      localObject = localbxk;
    } while (localbxk != null);
    try
    {
      localObject = (bxk)new bxk().aH(this.field_content);
      oLr.put(this.oLj, localObject);
      return localObject;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.SnsInfo", "error get snsinfo timeline!");
    }
    return com.tencent.mm.modelsns.e.QZ();
  }
  
  public final String bGk()
  {
    if (yr(32)) {
      return v.ak("ad_table_", this.field_snsId);
    }
    return v.ak("sns_table_", this.field_snsId);
  }
  
  public final Bundle bGm()
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("values", super.vf());
    localBundle.putInt("localid", this.oLk);
    if (bGN() != null) {
      localBundle.putBundle("adValues", bGN().bGm());
    }
    return localBundle;
  }
  
  public final awe bGw()
  {
    if (this.field_postBuf == null) {
      return new awe();
    }
    if (this.oLt == null) {
      this.oLt = g.o(this.field_postBuf);
    }
    if (oLs.containsKey(this.oLt))
    {
      this.oLv = ((awe)oLs.get(this.oLt));
      if (this.oLv != null) {
        return this.oLv;
      }
    }
    try
    {
      this.oLv = ((awe)new awe().aH(this.field_postBuf));
      oLs.put(this.oLt, this.oLv);
      return this.oLv;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.SnsInfo", "error get snsinfo timeline!");
    }
    return new awe();
  }
  
  public final int bGx()
  {
    return this.field_createTime;
  }
  
  public final void bGy()
  {
    this.field_localPrivate |= 0x1;
  }
  
  public final int bGz()
  {
    return this.field_localPrivate;
  }
  
  public final void c(bxk parambxk)
  {
    try
    {
      this.field_content = parambxk.toByteArray();
      this.oLj = (g.o(this.field_content) + g.o(this.field_attrBuf));
      return;
    }
    catch (Exception parambxk)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.SnsInfo", parambxk, "", new Object[0]);
      }
    }
  }
  
  public final void d(Cursor paramCursor)
  {
    super.d(paramCursor);
    this.oLk = ((int)this.ujK);
  }
  
  public final String getAdLink()
  {
    b localb = bFZ();
    if (localb != null) {
      return localb.oAa;
    }
    return "";
  }
  
  public final String getUserName()
  {
    return this.field_userName;
  }
  
  public final void gp(long paramLong)
  {
    this.field_snsId = paramLong;
    if (paramLong != 0L) {
      gr(paramLong);
    }
  }
  
  public final void gr(long paramLong)
  {
    this.field_stringSeq = i.fN(paramLong);
    this.field_stringSeq = i.Nb(this.field_stringSeq);
    y.d("MicroMsg.SnsInfo", paramLong + " stringSeq " + this.field_stringSeq);
  }
  
  public final void iB(int paramInt)
  {
    if ((paramInt - this.field_createTime < 180) && (paramInt - this.field_createTime >= 0))
    {
      if (this.field_head == 0) {
        this.field_head = gq(this.field_createTime);
      }
      return;
    }
    this.field_createTime = paramInt;
    this.field_head = gq(paramInt);
  }
  
  public final boolean isValid()
  {
    return this.field_snsId != 0L;
  }
  
  public final boolean mG()
  {
    return yr(32);
  }
  
  protected final c.a rM()
  {
    return buS;
  }
  
  public final void yp(int paramInt)
  {
    this.field_sourceType |= paramInt;
  }
  
  public final boolean yr(int paramInt)
  {
    return (this.field_sourceType & paramInt) > 0;
  }
  
  public final void ys(int paramInt)
  {
    this.field_sourceType &= (paramInt ^ 0xFFFFFFFF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.n
 * JD-Core Version:    0.7.0.1
 */