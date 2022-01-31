package com.tencent.tmassistantsdk.protocol.jce;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class ReqHead
  extends JceStruct
  implements Cloneable
{
  private static final String TAG = "ReqHead";
  static Net cache_net;
  static Terminal cache_terminal;
  public int assistantAPILevel = 0;
  public int assistantVersionCode = 0;
  public int cmdId = 0;
  public byte encryptWithPack = 0;
  public Net net = null;
  public String phoneGuid = "";
  public String qua = "";
  public int requestId = 0;
  public Terminal terminal = null;
  
  static
  {
    AppMethodBeat.i(76097);
    if (!ReqHead.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(76097);
      return;
    }
  }
  
  public ReqHead() {}
  
  public ReqHead(int paramInt1, int paramInt2, String paramString1, String paramString2, byte paramByte, Terminal paramTerminal, int paramInt3, int paramInt4, Net paramNet)
  {
    this.requestId = paramInt1;
    this.cmdId = paramInt2;
    this.phoneGuid = paramString1;
    this.qua = paramString2;
    this.encryptWithPack = paramByte;
    this.terminal = paramTerminal;
    this.assistantAPILevel = paramInt3;
    this.assistantVersionCode = paramInt4;
    this.net = paramNet;
  }
  
  public final String className()
  {
    return "jce.ReqHead";
  }
  
  public final Object clone()
  {
    AppMethodBeat.i(76092);
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
      AppMethodBeat.o(76092);
      throw ((Throwable)localObject1);
    }
    AppMethodBeat.o(76092);
    return localObject1;
  }
  
  public final void display(StringBuilder paramStringBuilder, int paramInt)
  {
    AppMethodBeat.i(76095);
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.requestId, "requestId");
    paramStringBuilder.display(this.cmdId, "cmdId");
    paramStringBuilder.display(this.phoneGuid, "phoneGuid");
    paramStringBuilder.display(this.qua, "qua");
    paramStringBuilder.display(this.encryptWithPack, "encryptWithPack");
    paramStringBuilder.display(this.terminal, "terminal");
    paramStringBuilder.display(this.assistantAPILevel, "assistantAPILevel");
    paramStringBuilder.display(this.assistantVersionCode, "assistantVersionCode");
    paramStringBuilder.display(this.net, "net");
    AppMethodBeat.o(76095);
  }
  
  public final void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    AppMethodBeat.i(76096);
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.requestId, true);
    paramStringBuilder.displaySimple(this.cmdId, true);
    paramStringBuilder.displaySimple(this.phoneGuid, true);
    paramStringBuilder.displaySimple(this.qua, true);
    paramStringBuilder.displaySimple(this.encryptWithPack, true);
    paramStringBuilder.displaySimple(this.terminal, true);
    paramStringBuilder.displaySimple(this.assistantAPILevel, true);
    paramStringBuilder.displaySimple(this.assistantVersionCode, true);
    paramStringBuilder.displaySimple(this.net, false);
    AppMethodBeat.o(76096);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(76090);
    if (paramObject == null)
    {
      AppMethodBeat.o(76090);
      return false;
    }
    paramObject = (ReqHead)paramObject;
    if ((JceUtil.equals(this.requestId, paramObject.requestId)) && (JceUtil.equals(this.cmdId, paramObject.cmdId)) && (JceUtil.equals(this.phoneGuid, paramObject.phoneGuid)) && (JceUtil.equals(this.qua, paramObject.qua)) && (JceUtil.equals(this.encryptWithPack, paramObject.encryptWithPack)) && (JceUtil.equals(this.terminal, paramObject.terminal)) && (JceUtil.equals(this.assistantAPILevel, paramObject.assistantAPILevel)) && (JceUtil.equals(this.assistantVersionCode, paramObject.assistantVersionCode)) && (JceUtil.equals(this.net, paramObject.net)))
    {
      AppMethodBeat.o(76090);
      return true;
    }
    AppMethodBeat.o(76090);
    return false;
  }
  
  public final String fullClassName()
  {
    return "ReqHead";
  }
  
  public final int getAssistantAPILevel()
  {
    return this.assistantAPILevel;
  }
  
  public final int getAssistantVersionCode()
  {
    return this.assistantVersionCode;
  }
  
  public final int getCmdId()
  {
    return this.cmdId;
  }
  
  public final byte getEncryptWithPack()
  {
    return this.encryptWithPack;
  }
  
  public final Net getNet()
  {
    return this.net;
  }
  
  public final String getPhoneGuid()
  {
    return this.phoneGuid;
  }
  
  public final String getQua()
  {
    return this.qua;
  }
  
  public final int getRequestId()
  {
    return this.requestId;
  }
  
  public final Terminal getTerminal()
  {
    return this.terminal;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(76091);
    try
    {
      Exception localException1 = new Exception("Need define key first!");
      AppMethodBeat.o(76091);
      throw localException1;
    }
    catch (Exception localException2)
    {
      ab.printErrStackTrace("ReqHead", localException2, "", new Object[0]);
      AppMethodBeat.o(76091);
    }
    return 0;
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(76094);
    this.requestId = paramJceInputStream.read(this.requestId, 0, true);
    this.cmdId = paramJceInputStream.read(this.cmdId, 1, true);
    this.phoneGuid = paramJceInputStream.readString(2, true);
    this.qua = paramJceInputStream.readString(3, true);
    this.encryptWithPack = paramJceInputStream.read(this.encryptWithPack, 4, false);
    if (cache_terminal == null) {
      cache_terminal = new Terminal();
    }
    this.terminal = ((Terminal)paramJceInputStream.read(cache_terminal, 5, false));
    this.assistantAPILevel = paramJceInputStream.read(this.assistantAPILevel, 6, false);
    this.assistantVersionCode = paramJceInputStream.read(this.assistantVersionCode, 7, false);
    if (cache_net == null) {
      cache_net = new Net();
    }
    this.net = ((Net)paramJceInputStream.read(cache_net, 8, false));
    AppMethodBeat.o(76094);
  }
  
  public final void setAssistantAPILevel(int paramInt)
  {
    this.assistantAPILevel = paramInt;
  }
  
  public final void setAssistantVersionCode(int paramInt)
  {
    this.assistantVersionCode = paramInt;
  }
  
  public final void setCmdId(int paramInt)
  {
    this.cmdId = paramInt;
  }
  
  public final void setEncryptWithPack(byte paramByte)
  {
    this.encryptWithPack = paramByte;
  }
  
  public final void setNet(Net paramNet)
  {
    this.net = paramNet;
  }
  
  public final void setPhoneGuid(String paramString)
  {
    this.phoneGuid = paramString;
  }
  
  public final void setQua(String paramString)
  {
    this.qua = paramString;
  }
  
  public final void setRequestId(int paramInt)
  {
    this.requestId = paramInt;
  }
  
  public final void setTerminal(Terminal paramTerminal)
  {
    this.terminal = paramTerminal;
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(76093);
    paramJceOutputStream.write(this.requestId, 0);
    paramJceOutputStream.write(this.cmdId, 1);
    paramJceOutputStream.write(this.phoneGuid, 2);
    paramJceOutputStream.write(this.qua, 3);
    paramJceOutputStream.write(this.encryptWithPack, 4);
    if (this.terminal != null) {
      paramJceOutputStream.write(this.terminal, 5);
    }
    paramJceOutputStream.write(this.assistantAPILevel, 6);
    paramJceOutputStream.write(this.assistantVersionCode, 7);
    if (this.net != null) {
      paramJceOutputStream.write(this.net, 8);
    }
    AppMethodBeat.o(76093);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tmassistantsdk.protocol.jce.ReqHead
 * JD-Core Version:    0.7.0.1
 */