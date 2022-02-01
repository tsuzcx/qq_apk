package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.storagebase.a.a;

public final class f
  implements a<String>
{
  public CharSequence GBP;
  public long fLJ;
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
  
  private void eYW()
  {
    AppMethodBeat.i(90781);
    if (this.field_lvbuff == null)
    {
      AppMethodBeat.o(90781);
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
        AppMethodBeat.o(90781);
        return;
      }
      z localz = new z();
      int i = localz.cr(this.field_lvbuff);
      if (i != 0)
      {
        AppMethodBeat.o(90781);
        return;
      }
      localz.Yp(4);
      localz.Yp(4);
      localz.eUD();
      localz.Yp(8);
      localz.Yp(4);
      localz.eUD();
      localz.eUD();
      localz.Yp(4);
      localz.Yp(4);
      localz.eUD();
      localz.eUD();
      localz.Yp(4);
      localz.Yp(4);
      this.field_signature = localz.getString();
      localz.eUD();
      localz.eUD();
      localz.eUD();
      localz.Yp(4);
      localz.Yp(4);
      localz.eUD();
      localz.Yp(4);
      localz.eUD();
      localz.eUD();
      localz.Yp(4);
      localz.Yp(4);
      if (!localz.eUE()) {
        this.field_remarkDesc = localz.getString();
      }
      this.field_lvbuff = null;
      AppMethodBeat.o(90781);
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.AddressUIContact", "exception:%s", new Object[] { bs.m(localException) });
      AppMethodBeat.o(90781);
    }
  }
  
  public final void aE(int paramInt, long paramLong)
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
      this.fLJ = paramLong;
      return;
    }
    this.field_deleteFlag = ((int)paramLong);
  }
  
  public final String aaS()
  {
    AppMethodBeat.i(90780);
    if ((this.field_conRemark != null) && (!this.field_conRemark.trim().equals("")))
    {
      localObject = this.field_conRemark;
      AppMethodBeat.o(90780);
      return localObject;
    }
    Object localObject = b.sW(this.field_username);
    if (localObject != null)
    {
      AppMethodBeat.o(90780);
      return localObject;
    }
    if ((this.field_nickname == null) || (this.field_nickname.length() <= 0))
    {
      localObject = this.field_alias;
      if (!bs.isNullOrNil((String)localObject))
      {
        AppMethodBeat.o(90780);
        return localObject;
      }
      String str = this.field_username;
      if (str == null) {
        localObject = null;
      }
      while ((localObject != null) && (((String)localObject).length() != 0))
      {
        AppMethodBeat.o(90780);
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
      AppMethodBeat.o(90780);
      return localObject;
    }
    localObject = this.field_nickname;
    AppMethodBeat.o(90780);
    return localObject;
  }
  
  public final void cG(int paramInt, String paramString)
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
    AppMethodBeat.i(90779);
    this.field_username = paramCursor.getString(0);
    this.field_nickname = paramCursor.getString(1);
    this.field_alias = paramCursor.getString(2);
    this.field_conRemark = paramCursor.getString(3);
    this.field_verifyFlag = paramCursor.getInt(4);
    this.field_showHead = paramCursor.getInt(5);
    this.field_weiboFlag = paramCursor.getInt(6);
    this.fLJ = paramCursor.getLong(7);
    this.field_deleteFlag = paramCursor.getInt(8);
    this.field_lvbuff = paramCursor.getBlob(9);
    this.field_descWordingId = paramCursor.getString(10);
    this.field_openImAppid = paramCursor.getString(11);
    if (paramCursor.getColumnCount() >= 14)
    {
      this.field_descWording = paramCursor.getString(12);
      this.field_descWordingQuanpin = paramCursor.getString(13);
    }
    eYW();
    AppMethodBeat.o(90779);
  }
  
  public final void eYX()
  {
    AppMethodBeat.i(90782);
    eYW();
    AppMethodBeat.o(90782);
  }
  
  public final void t(int paramInt, byte[] paramArrayOfByte)
  {
    if (paramInt == 9) {
      this.field_lvbuff = paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.f
 * JD-Core Version:    0.7.0.1
 */