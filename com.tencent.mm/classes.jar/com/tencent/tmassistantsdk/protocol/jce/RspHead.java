package com.tencent.tmassistantsdk.protocol.jce;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class RspHead
  extends JceStruct
  implements Cloneable
{
  private static final String TAG = "RspHead";
  public int cmdId = 0;
  public byte encryptWithPack = 0;
  public String phoneGuid = "";
  public int requestId = 0;
  public int ret = 0;
  
  static
  {
    AppMethodBeat.i(76125);
    if (!RspHead.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(76125);
      return;
    }
  }
  
  public RspHead() {}
  
  public RspHead(int paramInt1, int paramInt2, int paramInt3, byte paramByte, String paramString)
  {
    this.requestId = paramInt1;
    this.cmdId = paramInt2;
    this.ret = paramInt3;
    this.encryptWithPack = paramByte;
    this.phoneGuid = paramString;
  }
  
  public final String className()
  {
    return "jce.RspHead";
  }
  
  public final Object clone()
  {
    AppMethodBeat.i(76120);
    localObject1 = null;
    try
    {
      Object localObject2 = super.clone();
      localObject1 = localObject2;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      while ($assertionsDisabled) {}
      localObject1 = new AssertionError();
      AppMethodBeat.o(76120);
      throw ((Throwable)localObject1);
    }
    AppMethodBeat.o(76120);
    return localObject1;
  }
  
  public final void display(StringBuilder paramStringBuilder, int paramInt)
  {
    AppMethodBeat.i(76123);
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.requestId, "requestId");
    paramStringBuilder.display(this.cmdId, "cmdId");
    paramStringBuilder.display(this.ret, "ret");
    paramStringBuilder.display(this.encryptWithPack, "encryptWithPack");
    paramStringBuilder.display(this.phoneGuid, "phoneGuid");
    AppMethodBeat.o(76123);
  }
  
  public final void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    AppMethodBeat.i(76124);
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.requestId, true);
    paramStringBuilder.displaySimple(this.cmdId, true);
    paramStringBuilder.displaySimple(this.ret, true);
    paramStringBuilder.displaySimple(this.encryptWithPack, true);
    paramStringBuilder.displaySimple(this.phoneGuid, false);
    AppMethodBeat.o(76124);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(76118);
    if (paramObject == null)
    {
      AppMethodBeat.o(76118);
      return false;
    }
    paramObject = (RspHead)paramObject;
    if ((JceUtil.equals(this.requestId, paramObject.requestId)) && (JceUtil.equals(this.cmdId, paramObject.cmdId)) && (JceUtil.equals(this.ret, paramObject.ret)) && (JceUtil.equals(this.encryptWithPack, paramObject.encryptWithPack)) && (JceUtil.equals(this.phoneGuid, paramObject.phoneGuid)))
    {
      AppMethodBeat.o(76118);
      return true;
    }
    AppMethodBeat.o(76118);
    return false;
  }
  
  public final String fullClassName()
  {
    return "RspHead";
  }
  
  public final int getCmdId()
  {
    return this.cmdId;
  }
  
  public final byte getEncryptWithPack()
  {
    return this.encryptWithPack;
  }
  
  public final String getPhoneGuid()
  {
    return this.phoneGuid;
  }
  
  public final int getRequestId()
  {
    return this.requestId;
  }
  
  public final int getRet()
  {
    return this.ret;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(76119);
    try
    {
      Exception localException1 = new Exception("Need define key first!");
      AppMethodBeat.o(76119);
      throw localException1;
    }
    catch (Exception localException2)
    {
      ab.printErrStackTrace("RspHead", localException2, "", new Object[0]);
      AppMethodBeat.o(76119);
    }
    return 0;
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(76122);
    this.requestId = paramJceInputStream.read(this.requestId, 0, true);
    this.cmdId = paramJceInputStream.read(this.cmdId, 1, true);
    this.ret = paramJceInputStream.read(this.ret, 2, true);
    this.encryptWithPack = paramJceInputStream.read(this.encryptWithPack, 3, false);
    this.phoneGuid = paramJceInputStream.readString(4, false);
    AppMethodBeat.o(76122);
  }
  
  public final void setCmdId(int paramInt)
  {
    this.cmdId = paramInt;
  }
  
  public final void setEncryptWithPack(byte paramByte)
  {
    this.encryptWithPack = paramByte;
  }
  
  public final void setPhoneGuid(String paramString)
  {
    this.phoneGuid = paramString;
  }
  
  public final void setRequestId(int paramInt)
  {
    this.requestId = paramInt;
  }
  
  public final void setRet(int paramInt)
  {
    this.ret = paramInt;
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(76121);
    paramJceOutputStream.write(this.requestId, 0);
    paramJceOutputStream.write(this.cmdId, 1);
    paramJceOutputStream.write(this.ret, 2);
    paramJceOutputStream.write(this.encryptWithPack, 3);
    if (this.phoneGuid != null) {
      paramJceOutputStream.write(this.phoneGuid, 4);
    }
    AppMethodBeat.o(76121);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.protocol.jce.RspHead
 * JD-Core Version:    0.7.0.1
 */