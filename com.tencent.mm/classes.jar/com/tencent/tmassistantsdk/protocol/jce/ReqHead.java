package com.tencent.tmassistantsdk.protocol.jce;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.mm.sdk.platformtools.y;

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
    if (!ReqHead.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
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
    Object localObject1 = null;
    try
    {
      Object localObject2 = super.clone();
      localObject1 = localObject2;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      while ($assertionsDisabled) {}
      throw new AssertionError();
    }
    return localObject1;
  }
  
  public final void display(StringBuilder paramStringBuilder, int paramInt)
  {
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
  }
  
  public final void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
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
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (ReqHead)paramObject;
    } while ((!JceUtil.equals(this.requestId, paramObject.requestId)) || (!JceUtil.equals(this.cmdId, paramObject.cmdId)) || (!JceUtil.equals(this.phoneGuid, paramObject.phoneGuid)) || (!JceUtil.equals(this.qua, paramObject.qua)) || (!JceUtil.equals(this.encryptWithPack, paramObject.encryptWithPack)) || (!JceUtil.equals(this.terminal, paramObject.terminal)) || (!JceUtil.equals(this.assistantAPILevel, paramObject.assistantAPILevel)) || (!JceUtil.equals(this.assistantVersionCode, paramObject.assistantVersionCode)) || (!JceUtil.equals(this.net, paramObject.net)));
    return true;
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
    try
    {
      throw new Exception("Need define key first!");
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("ReqHead", localException, "", new Object[0]);
    }
    return 0;
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tmassistantsdk.protocol.jce.ReqHead
 * JD-Core Version:    0.7.0.1
 */