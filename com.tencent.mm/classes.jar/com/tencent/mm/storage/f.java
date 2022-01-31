package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.a.o;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.y;

public final class f
  implements com.tencent.mm.cf.a.a<String>
{
  public long dBe;
  private String field_alias;
  public String field_conRemark;
  public int field_deleteFlag;
  public String field_descWording;
  public String field_descWordingId;
  public String field_descWordingQuanpin;
  public byte[] field_lvbuff;
  public String field_nickname;
  public String field_openImAppid;
  public String field_remarkDesc;
  public int field_showHead;
  public String field_signature;
  public String field_username;
  public int field_verifyFlag;
  public int field_weiboFlag;
  public CharSequence umR;
  
  private void cts()
  {
    if (this.field_lvbuff == null) {}
    for (;;)
    {
      return;
      try
      {
        if ((this.field_lvbuff != null) && (this.field_lvbuff.length != 0))
        {
          v localv = new v();
          if (localv.bA(this.field_lvbuff) == 0)
          {
            localv.EZ(4);
            localv.EZ(4);
            localv.cqw();
            localv.EZ(8);
            localv.EZ(4);
            localv.cqw();
            localv.cqw();
            localv.EZ(4);
            localv.EZ(4);
            localv.cqw();
            localv.cqw();
            localv.EZ(4);
            localv.EZ(4);
            this.field_signature = localv.getString();
            localv.cqw();
            localv.cqw();
            localv.cqw();
            localv.EZ(4);
            localv.EZ(4);
            localv.cqw();
            localv.EZ(4);
            localv.cqw();
            localv.cqw();
            localv.EZ(4);
            localv.EZ(4);
            if (!localv.cqx()) {
              this.field_remarkDesc = localv.getString();
            }
            this.field_lvbuff = null;
            return;
          }
        }
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.AddressUIContact", "exception:%s", new Object[] { bk.j(localException) });
      }
    }
  }
  
  public final String Bq()
  {
    if ((this.field_conRemark != null) && (!this.field_conRemark.trim().equals(""))) {
      localObject2 = this.field_conRemark;
    }
    Object localObject1;
    do
    {
      do
      {
        return localObject2;
        localObject1 = com.tencent.mm.n.a.ft(this.field_username);
        localObject2 = localObject1;
      } while (localObject1 != null);
      if ((this.field_nickname != null) && (this.field_nickname.length() > 0)) {
        break;
      }
      localObject1 = this.field_alias;
      localObject2 = localObject1;
    } while (!bk.bl((String)localObject1));
    Object localObject2 = this.field_username;
    if (localObject2 == null) {
      localObject1 = null;
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((String)localObject1).length() != 0) {
          break;
        }
      }
      return this.field_username;
      if (((String)localObject2).toLowerCase().endsWith("@t.qq.com"))
      {
        localObject1 = "@" + ((String)localObject2).replace("@t.qq.com", "");
      }
      else
      {
        localObject1 = localObject2;
        if (((String)localObject2).toLowerCase().endsWith("@qqim"))
        {
          localObject1 = ((String)localObject2).replace("@qqim", "");
          long l = Long.valueOf((String)localObject1).longValue();
          if (l < 0L) {
            localObject1 = new o(l).toString();
          }
        }
      }
    }
    return this.field_nickname;
  }
  
  public final void V(int paramInt, long paramLong)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 4: 
      this.field_verifyFlag = ((int)paramLong);
      return;
    case 5: 
      this.field_showHead = ((int)paramLong);
      return;
    case 6: 
      this.field_weiboFlag = ((int)paramLong);
      return;
    case 7: 
      this.dBe = paramLong;
      return;
    }
    this.field_deleteFlag = ((int)paramLong);
  }
  
  public final void bc(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    default: 
      return;
    case 0: 
      this.field_username = paramString;
      return;
    case 1: 
      this.field_nickname = paramString;
      return;
    case 2: 
      this.field_alias = paramString;
      return;
    case 3: 
      this.field_conRemark = paramString;
      return;
    case 10: 
      this.field_descWordingId = paramString;
      return;
    case 11: 
      this.field_openImAppid = paramString;
      return;
    case 12: 
      this.field_descWording = paramString;
      return;
    }
    this.field_descWordingQuanpin = paramString;
  }
  
  public final void ctt()
  {
    cts();
  }
  
  public final void d(Cursor paramCursor)
  {
    this.field_username = paramCursor.getString(0);
    this.field_nickname = paramCursor.getString(1);
    this.field_alias = paramCursor.getString(2);
    this.field_conRemark = paramCursor.getString(3);
    this.field_verifyFlag = paramCursor.getInt(4);
    this.field_showHead = paramCursor.getInt(5);
    this.field_weiboFlag = paramCursor.getInt(6);
    this.dBe = paramCursor.getLong(7);
    this.field_deleteFlag = paramCursor.getInt(8);
    this.field_lvbuff = paramCursor.getBlob(9);
    this.field_descWordingId = paramCursor.getString(10);
    this.field_openImAppid = paramCursor.getString(11);
    if (paramCursor.getColumnCount() >= 14)
    {
      this.field_descWording = paramCursor.getString(12);
      this.field_descWordingQuanpin = paramCursor.getString(13);
    }
    cts();
  }
  
  public final void q(int paramInt, byte[] paramArrayOfByte)
  {
    if (paramInt == 9) {
      this.field_lvbuff = paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.storage.f
 * JD-Core Version:    0.7.0.1
 */