package com.tencent.tmassistantsdk.protocol.jce;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public final class StatCfg
  extends JceStruct
  implements Cloneable
{
  private static final String TAG = "StatCfg";
  public int internal = 0;
  public short lineNum = 0;
  public byte netType = 0;
  public byte type = 0;
  
  static
  {
    AppMethodBeat.i(102387);
    if (!StatCfg.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(102387);
      return;
    }
  }
  
  public StatCfg() {}
  
  public StatCfg(byte paramByte1, byte paramByte2, short paramShort, int paramInt)
  {
    this.type = paramByte1;
    this.netType = paramByte2;
    this.lineNum = paramShort;
    this.internal = paramInt;
  }
  
  public final String className()
  {
    return "jce.StatCfg";
  }
  
  public final Object clone()
  {
    AppMethodBeat.i(102382);
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
      AppMethodBeat.o(102382);
      throw ((Throwable)localObject1);
    }
    AppMethodBeat.o(102382);
    return localObject1;
  }
  
  public final void display(StringBuilder paramStringBuilder, int paramInt)
  {
    AppMethodBeat.i(102385);
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.type, "type");
    paramStringBuilder.display(this.netType, "netType");
    paramStringBuilder.display(this.lineNum, "lineNum");
    paramStringBuilder.display(this.internal, "internal");
    AppMethodBeat.o(102385);
  }
  
  public final void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    AppMethodBeat.i(102386);
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.type, true);
    paramStringBuilder.displaySimple(this.netType, true);
    paramStringBuilder.displaySimple(this.lineNum, true);
    paramStringBuilder.displaySimple(this.internal, false);
    AppMethodBeat.o(102386);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(102380);
    if (paramObject == null)
    {
      AppMethodBeat.o(102380);
      return false;
    }
    paramObject = (StatCfg)paramObject;
    if ((JceUtil.equals(this.type, paramObject.type)) && (JceUtil.equals(this.netType, paramObject.netType)) && (JceUtil.equals(this.lineNum, paramObject.lineNum)) && (JceUtil.equals(this.internal, paramObject.internal)))
    {
      AppMethodBeat.o(102380);
      return true;
    }
    AppMethodBeat.o(102380);
    return false;
  }
  
  public final String fullClassName()
  {
    return "StatCfg";
  }
  
  public final int getInternal()
  {
    return this.internal;
  }
  
  public final short getLineNum()
  {
    return this.lineNum;
  }
  
  public final byte getNetType()
  {
    return this.netType;
  }
  
  public final byte getType()
  {
    return this.type;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(102381);
    try
    {
      Exception localException1 = new Exception("Need define key first!");
      AppMethodBeat.o(102381);
      throw localException1;
    }
    catch (Exception localException2)
    {
      ad.printErrStackTrace("StatCfg", localException2, "", new Object[0]);
      AppMethodBeat.o(102381);
    }
    return 0;
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(102384);
    this.type = paramJceInputStream.read(this.type, 0, true);
    this.netType = paramJceInputStream.read(this.netType, 1, true);
    this.lineNum = paramJceInputStream.read(this.lineNum, 2, false);
    this.internal = paramJceInputStream.read(this.internal, 3, false);
    AppMethodBeat.o(102384);
  }
  
  public final void setInternal(int paramInt)
  {
    this.internal = paramInt;
  }
  
  public final void setLineNum(short paramShort)
  {
    this.lineNum = paramShort;
  }
  
  public final void setNetType(byte paramByte)
  {
    this.netType = paramByte;
  }
  
  public final void setType(byte paramByte)
  {
    this.type = paramByte;
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(102383);
    paramJceOutputStream.write(this.type, 0);
    paramJceOutputStream.write(this.netType, 1);
    paramJceOutputStream.write(this.lineNum, 2);
    paramJceOutputStream.write(this.internal, 3);
    AppMethodBeat.o(102383);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tmassistantsdk.protocol.jce.StatCfg
 * JD-Core Version:    0.7.0.1
 */