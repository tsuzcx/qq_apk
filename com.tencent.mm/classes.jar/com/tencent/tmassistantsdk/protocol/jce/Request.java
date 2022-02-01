package com.tencent.tmassistantsdk.protocol.jce;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

public final class Request
  extends JceStruct
  implements Cloneable
{
  private static final String TAG = "Request";
  static byte[] cache_body;
  static ReqHead cache_head;
  public byte[] body = null;
  public ReqHead head = null;
  
  static
  {
    AppMethodBeat.i(102351);
    if (!Request.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(102351);
      return;
    }
  }
  
  public Request() {}
  
  public Request(ReqHead paramReqHead, byte[] paramArrayOfByte)
  {
    this.head = paramReqHead;
    this.body = paramArrayOfByte;
  }
  
  public final String className()
  {
    return "jce.Request";
  }
  
  public final Object clone()
  {
    AppMethodBeat.i(102346);
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
      AppMethodBeat.o(102346);
      throw ((Throwable)localObject1);
    }
    AppMethodBeat.o(102346);
    return localObject1;
  }
  
  public final void display(StringBuilder paramStringBuilder, int paramInt)
  {
    AppMethodBeat.i(102349);
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.head, "head");
    paramStringBuilder.display(this.body, "body");
    AppMethodBeat.o(102349);
  }
  
  public final void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    AppMethodBeat.i(102350);
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.head, true);
    paramStringBuilder.displaySimple(this.body, false);
    AppMethodBeat.o(102350);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(102344);
    if (paramObject == null)
    {
      AppMethodBeat.o(102344);
      return false;
    }
    paramObject = (Request)paramObject;
    if ((JceUtil.equals(this.head, paramObject.head)) && (JceUtil.equals(this.body, paramObject.body)))
    {
      AppMethodBeat.o(102344);
      return true;
    }
    AppMethodBeat.o(102344);
    return false;
  }
  
  public final String fullClassName()
  {
    return "Request";
  }
  
  public final byte[] getBody()
  {
    return this.body;
  }
  
  public final ReqHead getHead()
  {
    return this.head;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(102345);
    try
    {
      Exception localException1 = new Exception("Need define key first!");
      AppMethodBeat.o(102345);
      throw localException1;
    }
    catch (Exception localException2)
    {
      ac.printErrStackTrace("Request", localException2, "", new Object[0]);
      AppMethodBeat.o(102345);
    }
    return 0;
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(102348);
    if (cache_head == null) {
      cache_head = new ReqHead();
    }
    this.head = ((ReqHead)paramJceInputStream.read(cache_head, 0, true));
    if (cache_body == null)
    {
      byte[] arrayOfByte = (byte[])new byte[1];
      cache_body = arrayOfByte;
      ((byte[])arrayOfByte)[0] = 0;
    }
    this.body = ((byte[])paramJceInputStream.read(cache_body, 1, false));
    AppMethodBeat.o(102348);
  }
  
  public final void setBody(byte[] paramArrayOfByte)
  {
    this.body = paramArrayOfByte;
  }
  
  public final void setHead(ReqHead paramReqHead)
  {
    this.head = paramReqHead;
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(102347);
    paramJceOutputStream.write(this.head, 0);
    if (this.body != null) {
      paramJceOutputStream.write(this.body, 1);
    }
    AppMethodBeat.o(102347);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tmassistantsdk.protocol.jce.Request
 * JD-Core Version:    0.7.0.1
 */