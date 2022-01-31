package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.y;

public final class f
  implements com.tencent.mm.cg.a.a<String>
{
  public long euF;
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
  public CharSequence ywx;
  
  private void dvO()
  {
    AppMethodBeat.i(136950);
    if (this.field_lvbuff == null)
    {
      AppMethodBeat.o(136950);
      return;
    }
    try
    {
      if (this.field_lvbuff != null)
      {
        i = this.field_lvbuff.length;
        if (i != 0) {}
      }
      else
      {
        AppMethodBeat.o(136950);
        return;
      }
      y localy = new y();
      int i = localy.ca(this.field_lvbuff);
      if (i != 0)
      {
        AppMethodBeat.o(136950);
        return;
      }
      localy.Nb(4);
      localy.Nb(4);
      localy.dst();
      localy.Nb(8);
      localy.Nb(4);
      localy.dst();
      localy.dst();
      localy.Nb(4);
      localy.Nb(4);
      localy.dst();
      localy.dst();
      localy.Nb(4);
      localy.Nb(4);
      this.field_signature = localy.getString();
      localy.dst();
      localy.dst();
      localy.dst();
      localy.Nb(4);
      localy.Nb(4);
      localy.dst();
      localy.Nb(4);
      localy.dst();
      localy.dst();
      localy.Nb(4);
      localy.Nb(4);
      if (!localy.dsu()) {
        this.field_remarkDesc = localy.getString();
      }
      this.field_lvbuff = null;
      AppMethodBeat.o(136950);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.AddressUIContact", "exception:%s", new Object[] { bo.l(localException) });
      AppMethodBeat.o(136950);
    }
  }
  
  public final String Of()
  {
    AppMethodBeat.i(136949);
    if ((this.field_conRemark != null) && (!this.field_conRemark.trim().equals("")))
    {
      localObject = this.field_conRemark;
      AppMethodBeat.o(136949);
      return localObject;
    }
    Object localObject = com.tencent.mm.n.a.lG(this.field_username);
    if (localObject != null)
    {
      AppMethodBeat.o(136949);
      return localObject;
    }
    if ((this.field_nickname == null) || (this.field_nickname.length() <= 0))
    {
      localObject = this.field_alias;
      if (!bo.isNullOrNil((String)localObject))
      {
        AppMethodBeat.o(136949);
        return localObject;
      }
      String str = this.field_username;
      if (str == null) {
        localObject = null;
      }
      while ((localObject != null) && (((String)localObject).length() != 0))
      {
        AppMethodBeat.o(136949);
        return localObject;
        if (str.toLowerCase().endsWith("@t.qq.com"))
        {
          localObject = "@" + str.replace("@t.qq.com", "");
        }
        else
        {
          localObject = str;
          if (str.toLowerCase().endsWith("@qqim"))
          {
            localObject = str.replace("@qqim", "");
            long l = Long.valueOf((String)localObject).longValue();
            if (l < 0L) {
              localObject = new p(l).toString();
            }
          }
        }
      }
      localObject = this.field_username;
      AppMethodBeat.o(136949);
      return localObject;
    }
    localObject = this.field_nickname;
    AppMethodBeat.o(136949);
    return localObject;
  }
  
  public final void ak(int paramInt, long paramLong)
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
      this.euF = paramLong;
      return;
    }
    this.field_deleteFlag = ((int)paramLong);
  }
  
  public final void bJ(int paramInt, String paramString)
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
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(136948);
    this.field_username = paramCursor.getString(0);
    this.field_nickname = paramCursor.getString(1);
    this.field_alias = paramCursor.getString(2);
    this.field_conRemark = paramCursor.getString(3);
    this.field_verifyFlag = paramCursor.getInt(4);
    this.field_showHead = paramCursor.getInt(5);
    this.field_weiboFlag = paramCursor.getInt(6);
    this.euF = paramCursor.getLong(7);
    this.field_deleteFlag = paramCursor.getInt(8);
    this.field_lvbuff = paramCursor.getBlob(9);
    this.field_descWordingId = paramCursor.getString(10);
    this.field_openImAppid = paramCursor.getString(11);
    if (paramCursor.getColumnCount() >= 14)
    {
      this.field_descWording = paramCursor.getString(12);
      this.field_descWordingQuanpin = paramCursor.getString(13);
    }
    dvO();
    AppMethodBeat.o(136948);
  }
  
  public final void dvP()
  {
    AppMethodBeat.i(136951);
    dvO();
    AppMethodBeat.o(136951);
  }
  
  public final void r(int paramInt, byte[] paramArrayOfByte)
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