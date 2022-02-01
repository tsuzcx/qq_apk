package com.tencent.tmassistantsdk.protocol.jce;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class Response
  extends JceStruct
  implements Cloneable
{
  private static final String TAG = "Response";
  static byte[] cache_body;
  static RspHead cache_head;
  public byte[] body = null;
  public RspHead head = null;
  
  static
  {
    AppMethodBeat.i(102359);
    if (!Response.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(102359);
      return;
    }
  }
  
  public Response() {}
  
  public Response(RspHead paramRspHead, byte[] paramArrayOfByte)
  {
    this.head = paramRspHead;
    this.body = paramArrayOfByte;
  }
  
  public final String className()
  {
    return "jce.Response";
  }
  
  public final Object clone()
  {
    AppMethodBeat.i(102354);
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
      AppMethodBeat.o(102354);
      throw ((Throwable)localObject1);
    }
    AppMethodBeat.o(102354);
    return localObject1;
  }
  
  public final void display(StringBuilder paramStringBuilder, int paramInt)
  {
    AppMethodBeat.i(102357);
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.head, "head");
    paramStringBuilder.display(this.body, "body");
    AppMethodBeat.o(102357);
  }
  
  public final void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    AppMethodBeat.i(102358);
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.head, true);
    paramStringBuilder.displaySimple(this.body, false);
    AppMethodBeat.o(102358);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(102352);
    if (paramObject == null)
    {
      AppMethodBeat.o(102352);
      return false;
    }
    paramObject = (Response)paramObject;
    if ((JceUtil.equals(this.head, paramObject.head)) && (JceUtil.equals(this.body, paramObject.body)))
    {
      AppMethodBeat.o(102352);
      return true;
    }
    AppMethodBeat.o(102352);
    return false;
  }
  
  public final String fullClassName()
  {
    return "Response";
  }
  
  public final byte[] getBody()
  {
    return this.body;
  }
  
  public final RspHead getHead()
  {
    return this.head;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(102353);
    try
    {
      Exception localException1 = new Exception("Need define key first!");
      AppMethodBeat.o(102353);
      throw localException1;
    }
    catch (Exception localException2)
    {
      Log.printErrStackTrace("Response", localException2, "", new Object[0]);
      AppMethodBeat.o(102353);
    }
    return 0;
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(102356);
    if (cache_head == null) {
      cache_head = new RspHead();
    }
    this.head = ((RspHead)paramJceInputStream.read(cache_head, 0, true));
    if (cache_body == null)
    {
      byte[] arrayOfByte = (byte[])new byte[1];
      cache_body = arrayOfByte;
      ((byte[])arrayOfByte)[0] = 0;
    }
    this.body = ((byte[])paramJceInputStream.read(cache_body, 1, true));
    AppMethodBeat.o(102356);
  }
  
  public final void setBody(byte[] paramArrayOfByte)
  {
    this.body = paramArrayOfByte;
  }
  
  public final void setHead(RspHead paramRspHead)
  {
    this.head = paramRspHead;
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(102355);
    paramJceOutputStream.write(this.head, 0);
    paramJceOutputStream.write(this.body, 1);
    AppMethodBeat.o(102355);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tmassistantsdk.protocol.jce.Response
 * JD-Core Version:    0.7.0.1
 */